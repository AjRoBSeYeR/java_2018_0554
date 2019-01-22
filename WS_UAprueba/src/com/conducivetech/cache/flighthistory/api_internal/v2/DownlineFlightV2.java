/**
 * DownlineFlightV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class DownlineFlightV2  implements java.io.Serializable {
    private com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 arrivalAirport;

    private java.lang.String fsCode;

    private java.lang.Long flightId;

    public DownlineFlightV2() {
    }

    public DownlineFlightV2(
           com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 arrivalAirport,
           java.lang.String fsCode,
           java.lang.Long flightId) {
           this.arrivalAirport = arrivalAirport;
           this.fsCode = fsCode;
           this.flightId = flightId;
    }


    /**
     * Gets the arrivalAirport value for this DownlineFlightV2.
     * 
     * @return arrivalAirport
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 getArrivalAirport() {
        return arrivalAirport;
    }


    /**
     * Sets the arrivalAirport value for this DownlineFlightV2.
     * 
     * @param arrivalAirport
     */
    public void setArrivalAirport(com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }


    /**
     * Gets the fsCode value for this DownlineFlightV2.
     * 
     * @return fsCode
     */
    public java.lang.String getFsCode() {
        return fsCode;
    }


    /**
     * Sets the fsCode value for this DownlineFlightV2.
     * 
     * @param fsCode
     */
    public void setFsCode(java.lang.String fsCode) {
        this.fsCode = fsCode;
    }


    /**
     * Gets the flightId value for this DownlineFlightV2.
     * 
     * @return flightId
     */
    public java.lang.Long getFlightId() {
        return flightId;
    }


    /**
     * Sets the flightId value for this DownlineFlightV2.
     * 
     * @param flightId
     */
    public void setFlightId(java.lang.Long flightId) {
        this.flightId = flightId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DownlineFlightV2)) return false;
        DownlineFlightV2 other = (DownlineFlightV2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrivalAirport==null && other.getArrivalAirport()==null) || 
             (this.arrivalAirport!=null &&
              this.arrivalAirport.equals(other.getArrivalAirport()))) &&
            ((this.fsCode==null && other.getFsCode()==null) || 
             (this.fsCode!=null &&
              this.fsCode.equals(other.getFsCode()))) &&
            ((this.flightId==null && other.getFlightId()==null) || 
             (this.flightId!=null &&
              this.flightId.equals(other.getFlightId())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getArrivalAirport() != null) {
            _hashCode += getArrivalAirport().hashCode();
        }
        if (getFsCode() != null) {
            _hashCode += getFsCode().hashCode();
        }
        if (getFlightId() != null) {
            _hashCode += getFlightId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DownlineFlightV2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "downlineFlightV2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrivalAirport");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrivalAirport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airportV1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fsCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fsCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flightId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "flightId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
