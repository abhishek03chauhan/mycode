//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.23 at 01:03:19 PM IST 
//


package com.ecb.xmltutility.dto;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionOperationType1Code.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionOperationType1Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AMND"/>
 *     &lt;enumeration value="CANC"/>
 *     &lt;enumeration value="CORR"/>
 *     &lt;enumeration value="NEWT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransactionOperationType1Code")
@XmlEnum
public enum TransactionOperationType1Code {

    AMND,
    CANC,
    CORR,
    NEWT;

    public String value() {
        return name();
    }

    public static TransactionOperationType1Code fromValue(String v) {
        return valueOf(v);
    }

}