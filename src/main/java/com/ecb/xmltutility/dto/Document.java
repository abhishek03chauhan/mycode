//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.23 at 01:03:19 PM IST 
//


package com.ecb.xmltutility.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Document complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Document">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MnyMktUscrdMktSttstclRpt" type="{urn:iso:std:iso:20022:tech:xs:auth.013.001.02}MoneyMarketUnsecuredMarketStatisticalReportV02"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", propOrder = {
    "mnyMktUscrdMktSttstclRpt"
})
public class Document {

    @XmlElement(name = "MnyMktUscrdMktSttstclRpt", required = true)
    protected MoneyMarketUnsecuredMarketStatisticalReportV02 mnyMktUscrdMktSttstclRpt;

    /**
     * Gets the value of the mnyMktUscrdMktSttstclRpt property.
     * 
     * @return
     *     possible object is
     *     {@link MoneyMarketUnsecuredMarketStatisticalReportV02 }
     *     
     */
    public MoneyMarketUnsecuredMarketStatisticalReportV02 getMnyMktUscrdMktSttstclRpt() {
        return mnyMktUscrdMktSttstclRpt;
    }

    /**
     * Sets the value of the mnyMktUscrdMktSttstclRpt property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoneyMarketUnsecuredMarketStatisticalReportV02 }
     *     
     */
    public void setMnyMktUscrdMktSttstclRpt(MoneyMarketUnsecuredMarketStatisticalReportV02 value) {
        this.mnyMktUscrdMktSttstclRpt = value;
    }

}
