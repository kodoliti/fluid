//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.23 at 10:57:20 PM CEST 
//


package org.kodoliti.fluid.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for tCallActivity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tCallActivity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/BPMN/20100524/MODEL}tActivity">
 *       &lt;attribute name="calledElement" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCallActivity")
public class TCallActivity
    extends TActivity
{

    @XmlAttribute(name = "calledElement")
    protected QName calledElement;

    /**
     * Gets the value of the calledElement property.
     * 
     * @return
     *     possible object is
     *     {@link javax.xml.namespace.QName }
     *     
     */
    public QName getCalledElement() {
        return calledElement;
    }

    /**
     * Sets the value of the calledElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link javax.xml.namespace.QName }
     *     
     */
    public void setCalledElement(QName value) {
        this.calledElement = value;
    }

}
