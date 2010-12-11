/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.apache.hadoop.hive.serde2.thrift.test;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.async.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;

public class Complex implements TBase<Complex, Complex._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("Complex");

  private static final TField AINT_FIELD_DESC = new TField("aint", TType.I32, (short)1);
  private static final TField A_STRING_FIELD_DESC = new TField("aString", TType.STRING, (short)2);
  private static final TField LINT_FIELD_DESC = new TField("lint", TType.LIST, (short)3);
  private static final TField L_STRING_FIELD_DESC = new TField("lString", TType.LIST, (short)4);
  private static final TField LINT_STRING_FIELD_DESC = new TField("lintString", TType.LIST, (short)5);
  private static final TField M_STRING_STRING_FIELD_DESC = new TField("mStringString", TType.MAP, (short)6);

  private int aint;
  private String aString;
  private List<Integer> lint;
  private List<String> lString;
  private List<IntString> lintString;
  private Map<String,String> mStringString;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    AINT((short)1, "aint"),
    A_STRING((short)2, "aString"),
    LINT((short)3, "lint"),
    L_STRING((short)4, "lString"),
    LINT_STRING((short)5, "lintString"),
    M_STRING_STRING((short)6, "mStringString");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // AINT
          return AINT;
        case 2: // A_STRING
          return A_STRING;
        case 3: // LINT
          return LINT;
        case 4: // L_STRING
          return L_STRING;
        case 5: // LINT_STRING
          return LINT_STRING;
        case 6: // M_STRING_STRING
          return M_STRING_STRING;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __AINT_ISSET_ID = 0;
  private BitSet __isset_bit_vector = new BitSet(1);

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.AINT, new FieldMetaData("aint", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I32)));
    tmpMap.put(_Fields.A_STRING, new FieldMetaData("aString", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.LINT, new FieldMetaData("lint", TFieldRequirementType.DEFAULT, 
        new ListMetaData(TType.LIST, 
            new FieldValueMetaData(TType.I32))));
    tmpMap.put(_Fields.L_STRING, new FieldMetaData("lString", TFieldRequirementType.DEFAULT, 
        new ListMetaData(TType.LIST, 
            new FieldValueMetaData(TType.STRING))));
    tmpMap.put(_Fields.LINT_STRING, new FieldMetaData("lintString", TFieldRequirementType.DEFAULT, 
        new ListMetaData(TType.LIST, 
            new StructMetaData(TType.STRUCT, IntString.class))));
    tmpMap.put(_Fields.M_STRING_STRING, new FieldMetaData("mStringString", TFieldRequirementType.DEFAULT, 
        new MapMetaData(TType.MAP, 
            new FieldValueMetaData(TType.STRING), 
            new FieldValueMetaData(TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(Complex.class, metaDataMap);
  }

  public Complex() {
  }

  public Complex(
    int aint,
    String aString,
    List<Integer> lint,
    List<String> lString,
    List<IntString> lintString,
    Map<String,String> mStringString)
  {
    this();
    this.aint = aint;
    setAintIsSet(true);
    this.aString = aString;
    this.lint = lint;
    this.lString = lString;
    this.lintString = lintString;
    this.mStringString = mStringString;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Complex(Complex other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.aint = other.aint;
    if (other.isSetAString()) {
      this.aString = other.aString;
    }
    if (other.isSetLint()) {
      List<Integer> __this__lint = new ArrayList<Integer>();
      for (Integer other_element : other.lint) {
        __this__lint.add(other_element);
      }
      this.lint = __this__lint;
    }
    if (other.isSetLString()) {
      List<String> __this__lString = new ArrayList<String>();
      for (String other_element : other.lString) {
        __this__lString.add(other_element);
      }
      this.lString = __this__lString;
    }
    if (other.isSetLintString()) {
      List<IntString> __this__lintString = new ArrayList<IntString>();
      for (IntString other_element : other.lintString) {
        __this__lintString.add(new IntString(other_element));
      }
      this.lintString = __this__lintString;
    }
    if (other.isSetMStringString()) {
      Map<String,String> __this__mStringString = new HashMap<String,String>();
      for (Map.Entry<String, String> other_element : other.mStringString.entrySet()) {

        String other_element_key = other_element.getKey();
        String other_element_value = other_element.getValue();

        String __this__mStringString_copy_key = other_element_key;

        String __this__mStringString_copy_value = other_element_value;

        __this__mStringString.put(__this__mStringString_copy_key, __this__mStringString_copy_value);
      }
      this.mStringString = __this__mStringString;
    }
  }

  public Complex deepCopy() {
    return new Complex(this);
  }

  @Override
  public void clear() {
    setAintIsSet(false);
    this.aint = 0;
    this.aString = null;
    this.lint = null;
    this.lString = null;
    this.lintString = null;
    this.mStringString = null;
  }

  public int getAint() {
    return this.aint;
  }

  public void setAint(int aint) {
    this.aint = aint;
    setAintIsSet(true);
  }

  public void unsetAint() {
    __isset_bit_vector.clear(__AINT_ISSET_ID);
  }

  /** Returns true if field aint is set (has been asigned a value) and false otherwise */
  public boolean isSetAint() {
    return __isset_bit_vector.get(__AINT_ISSET_ID);
  }

  public void setAintIsSet(boolean value) {
    __isset_bit_vector.set(__AINT_ISSET_ID, value);
  }

  public String getAString() {
    return this.aString;
  }

  public void setAString(String aString) {
    this.aString = aString;
  }

  public void unsetAString() {
    this.aString = null;
  }

  /** Returns true if field aString is set (has been asigned a value) and false otherwise */
  public boolean isSetAString() {
    return this.aString != null;
  }

  public void setAStringIsSet(boolean value) {
    if (!value) {
      this.aString = null;
    }
  }

  public int getLintSize() {
    return (this.lint == null) ? 0 : this.lint.size();
  }

  public java.util.Iterator<Integer> getLintIterator() {
    return (this.lint == null) ? null : this.lint.iterator();
  }

  public void addToLint(int elem) {
    if (this.lint == null) {
      this.lint = new ArrayList<Integer>();
    }
    this.lint.add(elem);
  }

  public List<Integer> getLint() {
    return this.lint;
  }

  public void setLint(List<Integer> lint) {
    this.lint = lint;
  }

  public void unsetLint() {
    this.lint = null;
  }

  /** Returns true if field lint is set (has been asigned a value) and false otherwise */
  public boolean isSetLint() {
    return this.lint != null;
  }

  public void setLintIsSet(boolean value) {
    if (!value) {
      this.lint = null;
    }
  }

  public int getLStringSize() {
    return (this.lString == null) ? 0 : this.lString.size();
  }

  public java.util.Iterator<String> getLStringIterator() {
    return (this.lString == null) ? null : this.lString.iterator();
  }

  public void addToLString(String elem) {
    if (this.lString == null) {
      this.lString = new ArrayList<String>();
    }
    this.lString.add(elem);
  }

  public List<String> getLString() {
    return this.lString;
  }

  public void setLString(List<String> lString) {
    this.lString = lString;
  }

  public void unsetLString() {
    this.lString = null;
  }

  /** Returns true if field lString is set (has been asigned a value) and false otherwise */
  public boolean isSetLString() {
    return this.lString != null;
  }

  public void setLStringIsSet(boolean value) {
    if (!value) {
      this.lString = null;
    }
  }

  public int getLintStringSize() {
    return (this.lintString == null) ? 0 : this.lintString.size();
  }

  public java.util.Iterator<IntString> getLintStringIterator() {
    return (this.lintString == null) ? null : this.lintString.iterator();
  }

  public void addToLintString(IntString elem) {
    if (this.lintString == null) {
      this.lintString = new ArrayList<IntString>();
    }
    this.lintString.add(elem);
  }

  public List<IntString> getLintString() {
    return this.lintString;
  }

  public void setLintString(List<IntString> lintString) {
    this.lintString = lintString;
  }

  public void unsetLintString() {
    this.lintString = null;
  }

  /** Returns true if field lintString is set (has been asigned a value) and false otherwise */
  public boolean isSetLintString() {
    return this.lintString != null;
  }

  public void setLintStringIsSet(boolean value) {
    if (!value) {
      this.lintString = null;
    }
  }

  public int getMStringStringSize() {
    return (this.mStringString == null) ? 0 : this.mStringString.size();
  }

  public void putToMStringString(String key, String val) {
    if (this.mStringString == null) {
      this.mStringString = new HashMap<String,String>();
    }
    this.mStringString.put(key, val);
  }

  public Map<String,String> getMStringString() {
    return this.mStringString;
  }

  public void setMStringString(Map<String,String> mStringString) {
    this.mStringString = mStringString;
  }

  public void unsetMStringString() {
    this.mStringString = null;
  }

  /** Returns true if field mStringString is set (has been asigned a value) and false otherwise */
  public boolean isSetMStringString() {
    return this.mStringString != null;
  }

  public void setMStringStringIsSet(boolean value) {
    if (!value) {
      this.mStringString = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case AINT:
      if (value == null) {
        unsetAint();
      } else {
        setAint((Integer)value);
      }
      break;

    case A_STRING:
      if (value == null) {
        unsetAString();
      } else {
        setAString((String)value);
      }
      break;

    case LINT:
      if (value == null) {
        unsetLint();
      } else {
        setLint((List<Integer>)value);
      }
      break;

    case L_STRING:
      if (value == null) {
        unsetLString();
      } else {
        setLString((List<String>)value);
      }
      break;

    case LINT_STRING:
      if (value == null) {
        unsetLintString();
      } else {
        setLintString((List<IntString>)value);
      }
      break;

    case M_STRING_STRING:
      if (value == null) {
        unsetMStringString();
      } else {
        setMStringString((Map<String,String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case AINT:
      return new Integer(getAint());

    case A_STRING:
      return getAString();

    case LINT:
      return getLint();

    case L_STRING:
      return getLString();

    case LINT_STRING:
      return getLintString();

    case M_STRING_STRING:
      return getMStringString();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case AINT:
      return isSetAint();
    case A_STRING:
      return isSetAString();
    case LINT:
      return isSetLint();
    case L_STRING:
      return isSetLString();
    case LINT_STRING:
      return isSetLintString();
    case M_STRING_STRING:
      return isSetMStringString();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Complex)
      return this.equals((Complex)that);
    return false;
  }

  public boolean equals(Complex that) {
    if (that == null)
      return false;

    boolean this_present_aint = true;
    boolean that_present_aint = true;
    if (this_present_aint || that_present_aint) {
      if (!(this_present_aint && that_present_aint))
        return false;
      if (this.aint != that.aint)
        return false;
    }

    boolean this_present_aString = true && this.isSetAString();
    boolean that_present_aString = true && that.isSetAString();
    if (this_present_aString || that_present_aString) {
      if (!(this_present_aString && that_present_aString))
        return false;
      if (!this.aString.equals(that.aString))
        return false;
    }

    boolean this_present_lint = true && this.isSetLint();
    boolean that_present_lint = true && that.isSetLint();
    if (this_present_lint || that_present_lint) {
      if (!(this_present_lint && that_present_lint))
        return false;
      if (!this.lint.equals(that.lint))
        return false;
    }

    boolean this_present_lString = true && this.isSetLString();
    boolean that_present_lString = true && that.isSetLString();
    if (this_present_lString || that_present_lString) {
      if (!(this_present_lString && that_present_lString))
        return false;
      if (!this.lString.equals(that.lString))
        return false;
    }

    boolean this_present_lintString = true && this.isSetLintString();
    boolean that_present_lintString = true && that.isSetLintString();
    if (this_present_lintString || that_present_lintString) {
      if (!(this_present_lintString && that_present_lintString))
        return false;
      if (!this.lintString.equals(that.lintString))
        return false;
    }

    boolean this_present_mStringString = true && this.isSetMStringString();
    boolean that_present_mStringString = true && that.isSetMStringString();
    if (this_present_mStringString || that_present_mStringString) {
      if (!(this_present_mStringString && that_present_mStringString))
        return false;
      if (!this.mStringString.equals(that.mStringString))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Complex other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Complex typedOther = (Complex)other;

    lastComparison = Boolean.valueOf(isSetAint()).compareTo(typedOther.isSetAint());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAint()) {
      lastComparison = TBaseHelper.compareTo(this.aint, typedOther.aint);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAString()).compareTo(typedOther.isSetAString());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAString()) {
      lastComparison = TBaseHelper.compareTo(this.aString, typedOther.aString);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLint()).compareTo(typedOther.isSetLint());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLint()) {
      lastComparison = TBaseHelper.compareTo(this.lint, typedOther.lint);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLString()).compareTo(typedOther.isSetLString());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLString()) {
      lastComparison = TBaseHelper.compareTo(this.lString, typedOther.lString);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLintString()).compareTo(typedOther.isSetLintString());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLintString()) {
      lastComparison = TBaseHelper.compareTo(this.lintString, typedOther.lintString);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMStringString()).compareTo(typedOther.isSetMStringString());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMStringString()) {
      lastComparison = TBaseHelper.compareTo(this.mStringString, typedOther.mStringString);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // AINT
          if (field.type == TType.I32) {
            this.aint = iprot.readI32();
            setAintIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // A_STRING
          if (field.type == TType.STRING) {
            this.aString = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // LINT
          if (field.type == TType.LIST) {
            {
              TList _list0 = iprot.readListBegin();
              this.lint = new ArrayList<Integer>(_list0.size);
              for (int _i1 = 0; _i1 < _list0.size; ++_i1)
              {
                int _elem2;
                _elem2 = iprot.readI32();
                this.lint.add(_elem2);
              }
              iprot.readListEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // L_STRING
          if (field.type == TType.LIST) {
            {
              TList _list3 = iprot.readListBegin();
              this.lString = new ArrayList<String>(_list3.size);
              for (int _i4 = 0; _i4 < _list3.size; ++_i4)
              {
                String _elem5;
                _elem5 = iprot.readString();
                this.lString.add(_elem5);
              }
              iprot.readListEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // LINT_STRING
          if (field.type == TType.LIST) {
            {
              TList _list6 = iprot.readListBegin();
              this.lintString = new ArrayList<IntString>(_list6.size);
              for (int _i7 = 0; _i7 < _list6.size; ++_i7)
              {
                IntString _elem8;
                _elem8 = new IntString();
                _elem8.read(iprot);
                this.lintString.add(_elem8);
              }
              iprot.readListEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // M_STRING_STRING
          if (field.type == TType.MAP) {
            {
              TMap _map9 = iprot.readMapBegin();
              this.mStringString = new HashMap<String,String>(2*_map9.size);
              for (int _i10 = 0; _i10 < _map9.size; ++_i10)
              {
                String _key11;
                String _val12;
                _key11 = iprot.readString();
                _val12 = iprot.readString();
                this.mStringString.put(_key11, _val12);
              }
              iprot.readMapEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(AINT_FIELD_DESC);
    oprot.writeI32(this.aint);
    oprot.writeFieldEnd();
    if (this.aString != null) {
      oprot.writeFieldBegin(A_STRING_FIELD_DESC);
      oprot.writeString(this.aString);
      oprot.writeFieldEnd();
    }
    if (this.lint != null) {
      oprot.writeFieldBegin(LINT_FIELD_DESC);
      {
        oprot.writeListBegin(new TList(TType.I32, this.lint.size()));
        for (int _iter13 : this.lint)
        {
          oprot.writeI32(_iter13);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.lString != null) {
      oprot.writeFieldBegin(L_STRING_FIELD_DESC);
      {
        oprot.writeListBegin(new TList(TType.STRING, this.lString.size()));
        for (String _iter14 : this.lString)
        {
          oprot.writeString(_iter14);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.lintString != null) {
      oprot.writeFieldBegin(LINT_STRING_FIELD_DESC);
      {
        oprot.writeListBegin(new TList(TType.STRUCT, this.lintString.size()));
        for (IntString _iter15 : this.lintString)
        {
          _iter15.write(oprot);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.mStringString != null) {
      oprot.writeFieldBegin(M_STRING_STRING_FIELD_DESC);
      {
        oprot.writeMapBegin(new TMap(TType.STRING, TType.STRING, this.mStringString.size()));
        for (Map.Entry<String, String> _iter16 : this.mStringString.entrySet())
        {
          oprot.writeString(_iter16.getKey());
          oprot.writeString(_iter16.getValue());
        }
        oprot.writeMapEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Complex(");
    boolean first = true;

    sb.append("aint:");
    sb.append(this.aint);
    first = false;
    if (!first) sb.append(", ");
    sb.append("aString:");
    if (this.aString == null) {
      sb.append("null");
    } else {
      sb.append(this.aString);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("lint:");
    if (this.lint == null) {
      sb.append("null");
    } else {
      sb.append(this.lint);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("lString:");
    if (this.lString == null) {
      sb.append("null");
    } else {
      sb.append(this.lString);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("lintString:");
    if (this.lintString == null) {
      sb.append("null");
    } else {
      sb.append(this.lintString);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("mStringString:");
    if (this.mStringString == null) {
      sb.append("null");
    } else {
      sb.append(this.mStringString);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}
