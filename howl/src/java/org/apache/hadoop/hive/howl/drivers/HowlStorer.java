/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.howl.drivers;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.howl.data.DefaultHowlRecord;
import org.apache.hadoop.hive.howl.data.HowlFieldSchema;
import org.apache.hadoop.hive.howl.data.HowlRecord;
import org.apache.hadoop.hive.howl.data.HowlSchema;
import org.apache.hadoop.hive.howl.data.HowlTypeInfo;
import org.apache.hadoop.hive.howl.mapreduce.HowlOutputFormat;
import org.apache.hadoop.hive.howl.mapreduce.HowlTableInfo;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.OutputFormat;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.pig.ResourceSchema;
import org.apache.pig.StoreFunc;
import org.apache.pig.ResourceSchema.ResourceFieldSchema;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.DataType;
import org.apache.pig.data.Tuple;
import org.apache.pig.impl.logicalLayer.parser.ParseException;
import org.apache.pig.impl.logicalLayer.parser.QueryParser;
import org.apache.pig.impl.logicalLayer.schema.Schema;
import org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema;
import org.apache.pig.impl.util.UDFContext;

/**
 * HowlStorer.
 *
 */


public class HowlStorer extends StoreFunc {

  /**
   *
   */
  private static final String HOWL_THRIFT_SERVER_URI = "howl.thrift.server.uri";

  private final Map<String,String> partitions;
  private ResourceFieldSchema[] fSchemas;
  private final Schema pigSchema;
  private static final Log log = LogFactory.getLog(HowlStorer.class);

  public HowlStorer(String partSpecs, String schema) throws ParseException {

    String[] partKVPs = partSpecs.split(",");
    partitions = new HashMap<String, String>(partKVPs.length);
    for(String partKVP : partKVPs){
      String[] partKV = partKVP.split("=");
      if(partKV.length == 2) {
        partitions.put(partKV[0].trim(), partKV[1].trim());
      }
    }

    pigSchema = new QueryParser(new StringReader(schema)).TupleSchema();
  }

  private RecordWriter<WritableComparable<?>, HowlRecord> writer;


  @Override
  public void checkSchema(ResourceSchema resourceSchema) throws IOException {
    fSchemas = resourceSchema.getFields();
    Schema runtimeSchema = Schema.getPigSchema(resourceSchema);
    assert Schema.equals(runtimeSchema, pigSchema, false, true) : "Schema provided in store statement doesn't match with the Schema" +
    "returned by Pig run-time. Schema provided in HowlStorer: "+pigSchema.toString()+ " Schema received from Pig runtime: "+runtimeSchema.toString();

  }

  private HowlSchema convertPigSchemaToHowlSchema(Schema pigSchema){

    List<HowlFieldSchema> fieldSchemas = new ArrayList<HowlFieldSchema>(pigSchema.size());
    for(FieldSchema fSchema : pigSchema.getFields()){
      byte type = fSchema.type;
      HowlFieldSchema howlFSchema;
      if(type == org.apache.pig.data.DataType.BAG || type == org.apache.pig.data.DataType.TUPLE){
        howlFSchema = new HowlFieldSchema(fSchema.alias,getHowlTypeInfoFrom(fSchema.schema).toString(),"");
      }

      else if (type == org.apache.pig.data.DataType.MAP){
        // We only allow map<string,primitive>
        howlFSchema = new HowlFieldSchema(fSchema.alias,"map<string,string>","");
      }
      else{
        howlFSchema = new HowlFieldSchema(fSchema.alias,getHiveTypeString(fSchema.type),"");

      }
      fieldSchemas.add(howlFSchema);
    }
    return new HowlSchema(fieldSchemas);
  }

  private HowlTypeInfo getHowlTypeInfoFrom(Schema pigSchema){

    // Magically get HowlTypeInfo from Pig's Schema.

    return new HowlTypeInfo("");
//    for(FieldSchema fSchema : pigSchema.getFields()){
//      byte type = fSchema.type;
//      HowlTypeInfo howlTypeInfo;
//      if(type == org.apache.pig.data.DataType.BAG || type == org.apache.pig.data.DataType.TUPLE){
//        howlTypeInfo = new HowlTypeInfo(fSchema.alias,convertPigSchemaToHiveSchemaStr(fSchema.schema.toString()),"");
//      }
//
//      else if (type == org.apache.pig.data.DataType.MAP){
//        // We only allow map<string,primitive>
//        howlFSchema = new HowlFieldSchema(fSchema.alias,"map<string,string>","");
//      }
//      else{
//        howlFSchema = new HowlFieldSchema(fSchema.alias,getHiveTypeString(fSchema.type),"");
//
//      }
//      fieldSchemas.add(howlFSchema);
//    }
  }

  private String getHiveTypeString(byte type){

    switch(type){

    case DataType.CHARARRAY:
    case DataType.BIGCHARARRAY:
      return "string";
    default:
      return DataType.findTypeName(type);
    }
  }

  private String convertPigSchemaToHiveSchemaStr(String pigSchema){

    // 1. Replace ( with struct<
    // 2. Replace ),],} with >
    // 3. Replace { with list<
    // 4. Replace [ with map<string,string
    // 5. Replace anything other then type names with ''.
    // 6. Replace : with ''
    return pigSchema.replaceAll("(", "struct<").replaceAll("{", "list<").replaceAll("[", "map<string,string").replaceAll("[),\\],}]", ">");
  }
  @Override
  public OutputFormat getOutputFormat() throws IOException {
    return new HowlOutputFormat();
  }

  @Override
  public void prepareToWrite(RecordWriter writer) throws IOException {
    this.writer = writer;
  }

  @Override
  public void putNext(Tuple tuple) throws IOException {

    List<Object> outgoing = new ArrayList<Object>(tuple.size());

    int i = 0;
    for (ResourceFieldSchema fSchema : fSchemas) {
      outgoing.add(getJavaObj(tuple.get(i++), fSchema));
    }

    try {
      writer.write(null, new DefaultHowlRecord(outgoing));
    } catch (InterruptedException e) {
      throw new IOException(e);
    }
  }

  private Object getJavaObj(Object pigObj, ResourceFieldSchema fSchema) throws ExecException{

    Byte type = fSchema.getType();
    if(!org.apache.pig.data.DataType.isComplex(type)){
      return pigObj;
    }
    switch(type){
    case org.apache.pig.data.DataType.BAG:
      DataBag pigBag = (DataBag)pigObj;
      ResourceFieldSchema tupSchema = fSchema.getSchema().getFields()[0];
      List<Object> bagContents = new ArrayList<Object>((int)pigBag.size());
      Iterator<Tuple> bagItr = pigBag.iterator();
      ResourceFieldSchema[] innerElems = tupSchema.getSchema().getFields();

      while(bagItr.hasNext()){
        if(innerElems.length == 1){
          // If there is only one element in tuple contained in bag, we throw away the tuple.
          bagContents.add(getJavaObj(bagItr.next().get(0),innerElems[0]));
        } else {
          bagContents.add(getJavaObj(bagItr.next(), tupSchema));
        }
      }
      return bagContents;
    case org.apache.pig.data.DataType.MAP:
      // Pray to God that they really made use of value objects in there script.
      return pigObj;
    case org.apache.pig.data.DataType.TUPLE:
      Tuple innerTup = (Tuple)pigObj;
      List<Object> innerList = new ArrayList<Object>(innerTup.size());
      int i = 0;
      for(ResourceFieldSchema fieldSchema : fSchema.getSchema().getFields()){
        innerList.add(getJavaObj(innerTup.get(i++), fieldSchema));
      }
      return innerList;
    default:
      throw new ExecException("Unknown pig type: "+type);
    }
  }

  @Override
  public String relToAbsPathForStoreLocation(String location, Path curDir) throws IOException {

    // Dont muck around with db name and table name.
    return location;
  }

  @Override
  public void setStoreFuncUDFContextSignature(String signature) {

  }

  @Override
  public void setStoreLocation(String location, Job job) throws IOException {

    String[] userStr = location.split("\\.");
    if(userStr.length != 2) {
      throw new IOException("Incorrect store location. Please, specify the store location as dbname.tblname");
    }
    HowlTableInfo tblInfo = new HowlTableInfo(UDFContext.getUDFContext().getClientSystemProps().getProperty(HOWL_THRIFT_SERVER_URI),
        userStr[0],userStr[1],partitions);
    HowlOutputFormat.setOutput(job, tblInfo);
    HowlSchema howlSchema = HowlOutputFormat.getTableSchema(job);
    HowlOutputFormat.setSchema(job, convertPigSchemaToHowlSchema(pigSchema));

  }

}