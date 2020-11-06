/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.xdja.iss.thrift.datatype;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2020-10-30")
public class ResSetStr implements org.apache.thrift.TBase<ResSetStr, ResSetStr._Fields>, java.io.Serializable, Cloneable, Comparable<ResSetStr> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ResSetStr");

  private static final org.apache.thrift.protocol.TField RES_FIELD_DESC = new org.apache.thrift.protocol.TField("res", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("value", org.apache.thrift.protocol.TType.SET, (short)2);
  private static final org.apache.thrift.protocol.TField EXT_FIELD_DESC = new org.apache.thrift.protocol.TField("ext", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ResSetStrStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ResSetStrTupleSchemeFactory();

  public int res; // required
  public java.util.Set<String> value; // required
  public String ext; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RES((short)1, "res"),
    VALUE((short)2, "value"),
    EXT((short)3, "ext");

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
        case 2: // VALUE
          return VALUE;
        case 3: // EXT
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
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RES, new org.apache.thrift.meta_data.FieldMetaData("res", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.VALUE, new org.apache.thrift.meta_data.FieldMetaData("value", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.EXT, new org.apache.thrift.meta_data.FieldMetaData("ext", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ResSetStr.class, metaDataMap);
  }

  public ResSetStr() {
  }

  public ResSetStr(
    int res,
    java.util.Set<String> value,
    String ext)
  {
    this();
    this.res = res;
    setResIsSet(true);
    this.value = value;
    this.ext = ext;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ResSetStr(ResSetStr other) {
    __isset_bitfield = other.__isset_bitfield;
    this.res = other.res;
    if (other.isSetValue()) {
      java.util.Set<String> __this__value = new java.util.HashSet<String>(other.value);
      this.value = __this__value;
    }
    if (other.isSetExt()) {
      this.ext = other.ext;
    }
  }

  public ResSetStr deepCopy() {
    return new ResSetStr(this);
  }

  @Override
  public void clear() {
    setResIsSet(false);
    this.res = 0;
    this.value = null;
    this.ext = null;
  }

  public int getRes() {
    return this.res;
  }

  public ResSetStr setRes(int res) {
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

  public int getValueSize() {
    return (this.value == null) ? 0 : this.value.size();
  }

  public java.util.Iterator<String> getValueIterator() {
    return (this.value == null) ? null : this.value.iterator();
  }

  public void addToValue(String elem) {
    if (this.value == null) {
      this.value = new java.util.HashSet<String>();
    }
    this.value.add(elem);
  }

  public java.util.Set<String> getValue() {
    return this.value;
  }

  public ResSetStr setValue(java.util.Set<String> value) {
    this.value = value;
    return this;
  }

  public void unsetValue() {
    this.value = null;
  }

  /** Returns true if field value is set (has been assigned a value) and false otherwise */
  public boolean isSetValue() {
    return this.value != null;
  }

  public void setValueIsSet(boolean value) {
    if (!value) {
      this.value = null;
    }
  }

  public String getExt() {
    return this.ext;
  }

  public ResSetStr setExt(String ext) {
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

    case VALUE:
      if (value == null) {
        unsetValue();
      } else {
        setValue((java.util.Set<String>)value);
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

    case VALUE:
      return getValue();

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
    case VALUE:
      return isSetValue();
    case EXT:
      return isSetExt();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ResSetStr)
      return this.equals((ResSetStr)that);
    return false;
  }

  public boolean equals(ResSetStr that) {
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

    boolean this_present_value = true && this.isSetValue();
    boolean that_present_value = true && that.isSetValue();
    if (this_present_value || that_present_value) {
      if (!(this_present_value && that_present_value))
        return false;
      if (!this.value.equals(that.value))
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

    hashCode = hashCode * 8191 + ((isSetValue()) ? 131071 : 524287);
    if (isSetValue())
      hashCode = hashCode * 8191 + value.hashCode();

    hashCode = hashCode * 8191 + ((isSetExt()) ? 131071 : 524287);
    if (isSetExt())
      hashCode = hashCode * 8191 + ext.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(ResSetStr other) {
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
    lastComparison = Boolean.valueOf(isSetValue()).compareTo(other.isSetValue());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValue()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.value, other.value);
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
    StringBuilder sb = new StringBuilder("ResSetStr(");
    boolean first = true;

    sb.append("res:");
    sb.append(this.res);
    first = false;
    if (!first) sb.append(", ");
    sb.append("value:");
    if (this.value == null) {
      sb.append("null");
    } else {
      sb.append(this.value);
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

  private static class ResSetStrStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ResSetStrStandardScheme getScheme() {
      return new ResSetStrStandardScheme();
    }
  }

  private static class ResSetStrStandardScheme extends org.apache.thrift.scheme.StandardScheme<ResSetStr> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ResSetStr struct) throws org.apache.thrift.TException {
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
          case 2: // VALUE
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set16 = iprot.readSetBegin();
                struct.value = new java.util.HashSet<String>(2*_set16.size);
                String _elem17;
                for (int _i18 = 0; _i18 < _set16.size; ++_i18)
                {
                  _elem17 = iprot.readString();
                  struct.value.add(_elem17);
                }
                iprot.readSetEnd();
              }
              struct.setValueIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // EXT
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ResSetStr struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(RES_FIELD_DESC);
      oprot.writeI32(struct.res);
      oprot.writeFieldEnd();
      if (struct.value != null) {
        oprot.writeFieldBegin(VALUE_FIELD_DESC);
        {
          oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRING, struct.value.size()));
          for (String _iter19 : struct.value)
          {
            oprot.writeString(_iter19);
          }
          oprot.writeSetEnd();
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

  private static class ResSetStrTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ResSetStrTupleScheme getScheme() {
      return new ResSetStrTupleScheme();
    }
  }

  private static class ResSetStrTupleScheme extends org.apache.thrift.scheme.TupleScheme<ResSetStr> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ResSetStr struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetRes()) {
        optionals.set(0);
      }
      if (struct.isSetValue()) {
        optionals.set(1);
      }
      if (struct.isSetExt()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetRes()) {
        oprot.writeI32(struct.res);
      }
      if (struct.isSetValue()) {
        {
          oprot.writeI32(struct.value.size());
          for (String _iter20 : struct.value)
          {
            oprot.writeString(_iter20);
          }
        }
      }
      if (struct.isSetExt()) {
        oprot.writeString(struct.ext);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ResSetStr struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.res = iprot.readI32();
        struct.setResIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TSet _set21 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.value = new java.util.HashSet<String>(2*_set21.size);
          String _elem22;
          for (int _i23 = 0; _i23 < _set21.size; ++_i23)
          {
            _elem22 = iprot.readString();
            struct.value.add(_elem22);
          }
        }
        struct.setValueIsSet(true);
      }
      if (incoming.get(2)) {
        struct.ext = iprot.readString();
        struct.setExtIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

