/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.xdja.iss.thrift.datatype;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2020-10-30")
public class ResLongListStr implements org.apache.thrift.TBase<ResLongListStr, ResLongListStr._Fields>, java.io.Serializable, Cloneable, Comparable<ResLongListStr> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ResLongListStr");

  private static final org.apache.thrift.protocol.TField RES_FIELD_DESC = new org.apache.thrift.protocol.TField("res", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField VALUE_LONG_FIELD_DESC = new org.apache.thrift.protocol.TField("valueLong", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField VALUE_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("valueList", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField EXT_FIELD_DESC = new org.apache.thrift.protocol.TField("ext", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ResLongListStrStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ResLongListStrTupleSchemeFactory();

  public int res; // required
  public long valueLong; // required
  public java.util.List<String> valueList; // required
  public String ext; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RES((short)1, "res"),
    VALUE_LONG((short)2, "valueLong"),
    VALUE_LIST((short)3, "valueList"),
    EXT((short)4, "ext");

    private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // RES
          return RES;
        case 2: // VALUE_LONG
          return VALUE_LONG;
        case 3: // VALUE_LIST
          return VALUE_LIST;
        case 4: // EXT
          return EXT;
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
  private static final int __RES_ISSET_ID = 0;
  private static final int __VALUELONG_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RES, new org.apache.thrift.meta_data.FieldMetaData("res", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.VALUE_LONG, new org.apache.thrift.meta_data.FieldMetaData("valueLong", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.VALUE_LIST, new org.apache.thrift.meta_data.FieldMetaData("valueList", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.EXT, new org.apache.thrift.meta_data.FieldMetaData("ext", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ResLongListStr.class, metaDataMap);
  }

  public ResLongListStr() {
  }

  public ResLongListStr(
    int res,
    long valueLong,
    java.util.List<String> valueList,
    String ext)
  {
    this();
    this.res = res;
    setResIsSet(true);
    this.valueLong = valueLong;
    setValueLongIsSet(true);
    this.valueList = valueList;
    this.ext = ext;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ResLongListStr(ResLongListStr other) {
    __isset_bitfield = other.__isset_bitfield;
    this.res = other.res;
    this.valueLong = other.valueLong;
    if (other.isSetValueList()) {
      java.util.List<String> __this__valueList = new java.util.ArrayList<String>(other.valueList);
      this.valueList = __this__valueList;
    }
    if (other.isSetExt()) {
      this.ext = other.ext;
    }
  }

  public ResLongListStr deepCopy() {
    return new ResLongListStr(this);
  }

  @Override
  public void clear() {
    setResIsSet(false);
    this.res = 0;
    setValueLongIsSet(false);
    this.valueLong = 0;
    this.valueList = null;
    this.ext = null;
  }

  public int getRes() {
    return this.res;
  }

  public ResLongListStr setRes(int res) {
    this.res = res;
    setResIsSet(true);
    return this;
  }

  public void unsetRes() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __RES_ISSET_ID);
  }

  /** Returns true if field res is set (has been assigned a value) and false otherwise */
  public boolean isSetRes() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __RES_ISSET_ID);
  }

  public void setResIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __RES_ISSET_ID, value);
  }

  public long getValueLong() {
    return this.valueLong;
  }

  public ResLongListStr setValueLong(long valueLong) {
    this.valueLong = valueLong;
    setValueLongIsSet(true);
    return this;
  }

  public void unsetValueLong() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __VALUELONG_ISSET_ID);
  }

  /** Returns true if field valueLong is set (has been assigned a value) and false otherwise */
  public boolean isSetValueLong() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __VALUELONG_ISSET_ID);
  }

  public void setValueLongIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __VALUELONG_ISSET_ID, value);
  }

  public int getValueListSize() {
    return (this.valueList == null) ? 0 : this.valueList.size();
  }

  public java.util.Iterator<String> getValueListIterator() {
    return (this.valueList == null) ? null : this.valueList.iterator();
  }

  public void addToValueList(String elem) {
    if (this.valueList == null) {
      this.valueList = new java.util.ArrayList<String>();
    }
    this.valueList.add(elem);
  }

  public java.util.List<String> getValueList() {
    return this.valueList;
  }

  public ResLongListStr setValueList(java.util.List<String> valueList) {
    this.valueList = valueList;
    return this;
  }

  public void unsetValueList() {
    this.valueList = null;
  }

  /** Returns true if field valueList is set (has been assigned a value) and false otherwise */
  public boolean isSetValueList() {
    return this.valueList != null;
  }

  public void setValueListIsSet(boolean value) {
    if (!value) {
      this.valueList = null;
    }
  }

  public String getExt() {
    return this.ext;
  }

  public ResLongListStr setExt(String ext) {
    this.ext = ext;
    return this;
  }

  public void unsetExt() {
    this.ext = null;
  }

  /** Returns true if field ext is set (has been assigned a value) and false otherwise */
  public boolean isSetExt() {
    return this.ext != null;
  }

  public void setExtIsSet(boolean value) {
    if (!value) {
      this.ext = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RES:
      if (value == null) {
        unsetRes();
      } else {
        setRes((Integer)value);
      }
      break;

    case VALUE_LONG:
      if (value == null) {
        unsetValueLong();
      } else {
        setValueLong((Long)value);
      }
      break;

    case VALUE_LIST:
      if (value == null) {
        unsetValueList();
      } else {
        setValueList((java.util.List<String>)value);
      }
      break;

    case EXT:
      if (value == null) {
        unsetExt();
      } else {
        setExt((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RES:
      return getRes();

    case VALUE_LONG:
      return getValueLong();

    case VALUE_LIST:
      return getValueList();

    case EXT:
      return getExt();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RES:
      return isSetRes();
    case VALUE_LONG:
      return isSetValueLong();
    case VALUE_LIST:
      return isSetValueList();
    case EXT:
      return isSetExt();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ResLongListStr)
      return this.equals((ResLongListStr)that);
    return false;
  }

  public boolean equals(ResLongListStr that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_res = true;
    boolean that_present_res = true;
    if (this_present_res || that_present_res) {
      if (!(this_present_res && that_present_res))
        return false;
      if (this.res != that.res)
        return false;
    }

    boolean this_present_valueLong = true;
    boolean that_present_valueLong = true;
    if (this_present_valueLong || that_present_valueLong) {
      if (!(this_present_valueLong && that_present_valueLong))
        return false;
      if (this.valueLong != that.valueLong)
        return false;
    }

    boolean this_present_valueList = true && this.isSetValueList();
    boolean that_present_valueList = true && that.isSetValueList();
    if (this_present_valueList || that_present_valueList) {
      if (!(this_present_valueList && that_present_valueList))
        return false;
      if (!this.valueList.equals(that.valueList))
        return false;
    }

    boolean this_present_ext = true && this.isSetExt();
    boolean that_present_ext = true && that.isSetExt();
    if (this_present_ext || that_present_ext) {
      if (!(this_present_ext && that_present_ext))
        return false;
      if (!this.ext.equals(that.ext))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + res;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(valueLong);

    hashCode = hashCode * 8191 + ((isSetValueList()) ? 131071 : 524287);
    if (isSetValueList())
      hashCode = hashCode * 8191 + valueList.hashCode();

    hashCode = hashCode * 8191 + ((isSetExt()) ? 131071 : 524287);
    if (isSetExt())
      hashCode = hashCode * 8191 + ext.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(ResLongListStr other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetRes()).compareTo(other.isSetRes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.res, other.res);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetValueLong()).compareTo(other.isSetValueLong());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValueLong()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.valueLong, other.valueLong);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetValueList()).compareTo(other.isSetValueList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValueList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.valueList, other.valueList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetExt()).compareTo(other.isSetExt());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExt()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ext, other.ext);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ResLongListStr(");
    boolean first = true;

    sb.append("res:");
    sb.append(this.res);
    first = false;
    if (!first) sb.append(", ");
    sb.append("valueLong:");
    sb.append(this.valueLong);
    first = false;
    if (!first) sb.append(", ");
    sb.append("valueList:");
    if (this.valueList == null) {
      sb.append("null");
    } else {
      sb.append(this.valueList);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("ext:");
    if (this.ext == null) {
      sb.append("null");
    } else {
      sb.append(this.ext);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ResLongListStrStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ResLongListStrStandardScheme getScheme() {
      return new ResLongListStrStandardScheme();
    }
  }

  private static class ResLongListStrStandardScheme extends org.apache.thrift.scheme.StandardScheme<ResLongListStr> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ResLongListStr struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RES
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.res = iprot.readI32();
              struct.setResIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // VALUE_LONG
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.valueLong = iprot.readI64();
              struct.setValueLongIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // VALUE_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list8 = iprot.readListBegin();
                struct.valueList = new java.util.ArrayList<String>(_list8.size);
                String _elem9;
                for (int _i10 = 0; _i10 < _list8.size; ++_i10)
                {
                  _elem9 = iprot.readString();
                  struct.valueList.add(_elem9);
                }
                iprot.readListEnd();
              }
              struct.setValueListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // EXT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.ext = iprot.readString();
              struct.setExtIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ResLongListStr struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(RES_FIELD_DESC);
      oprot.writeI32(struct.res);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(VALUE_LONG_FIELD_DESC);
      oprot.writeI64(struct.valueLong);
      oprot.writeFieldEnd();
      if (struct.valueList != null) {
        oprot.writeFieldBegin(VALUE_LIST_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.valueList.size()));
          for (String _iter11 : struct.valueList)
          {
            oprot.writeString(_iter11);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.ext != null) {
        oprot.writeFieldBegin(EXT_FIELD_DESC);
        oprot.writeString(struct.ext);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ResLongListStrTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ResLongListStrTupleScheme getScheme() {
      return new ResLongListStrTupleScheme();
    }
  }

  private static class ResLongListStrTupleScheme extends org.apache.thrift.scheme.TupleScheme<ResLongListStr> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ResLongListStr struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetRes()) {
        optionals.set(0);
      }
      if (struct.isSetValueLong()) {
        optionals.set(1);
      }
      if (struct.isSetValueList()) {
        optionals.set(2);
      }
      if (struct.isSetExt()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetRes()) {
        oprot.writeI32(struct.res);
      }
      if (struct.isSetValueLong()) {
        oprot.writeI64(struct.valueLong);
      }
      if (struct.isSetValueList()) {
        {
          oprot.writeI32(struct.valueList.size());
          for (String _iter12 : struct.valueList)
          {
            oprot.writeString(_iter12);
          }
        }
      }
      if (struct.isSetExt()) {
        oprot.writeString(struct.ext);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ResLongListStr struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.res = iprot.readI32();
        struct.setResIsSet(true);
      }
      if (incoming.get(1)) {
        struct.valueLong = iprot.readI64();
        struct.setValueLongIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list13 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.valueList = new java.util.ArrayList<String>(_list13.size);
          String _elem14;
          for (int _i15 = 0; _i15 < _list13.size; ++_i15)
          {
            _elem14 = iprot.readString();
            struct.valueList.add(_elem14);
          }
        }
        struct.setValueListIsSet(true);
      }
      if (incoming.get(3)) {
        struct.ext = iprot.readString();
        struct.setExtIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

