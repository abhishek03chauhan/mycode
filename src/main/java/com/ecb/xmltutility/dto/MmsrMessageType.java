//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.23 at 01:03:19 PM IST 
//


package com.ecb.xmltutility.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MmsrMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MmsrMessageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:iso:std:iso:20022:tech:xs:head.001.001.01}AppHdr"/>
 *         &lt;element ref="{urn:iso:std:iso:20022:tech:xs:auth.013.001.02}Document" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MmsrMessageType", namespace = "", propOrder = {
    "appHdr",
    "document"
})
@XmlRootElement
public class MmsrMessageType {

    @XmlElement(name = "AppHdr", namespace = "urn:iso:std:iso:20022:tech:xs:head.001.001.01", required = true)
    protected BusinessApplicationHeaderV01 appHdr;
    @XmlElement(name = "Document", namespace = "urn:iso:std:iso:20022:tech:xs:auth.013.001.02")
    protected List<Document> document;

    /**
     * Gets the value of the appHdr property.
     * 
     * @return
     *     possible object is
     *     {@link BusinessApplicationHeaderV01 }
     *     
     */
    public BusinessApplicationHeaderV01 getAppHdr() {
        return appHdr;
    }

    /**
     * Sets the value of the appHdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessApplicationHeaderV01 }
     *     
     */
    public void setAppHdr(BusinessApplicationHeaderV01 value) {
        this.appHdr = value;
    }

    /**
     * Gets the value of the document property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the document property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Document }
     * 
     * 
     */
    public List<Document> getDocument() {
        if (document == null) {
            document = new ArrayList<Document>();
        }
        return this.document;
    }

}
