//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.23 at 10:57:20 PM CEST 
//


package org.kodoliti.fluid.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tSubConversation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tSubConversation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/BPMN/20100524/MODEL}tConversationNode">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.omg.org/spec/BPMN/20100524/MODEL}conversationNode" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSubConversation", propOrder = {
    "conversationNode"
})
public class TSubConversation
    extends TConversationNode
{

    @XmlElementRef(name = "conversationNode", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TConversationNode>> conversationNode;

    /**
     * Gets the value of the conversationNode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conversationNode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConversationNode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link org.kodoliti.fluid.model.TCallConversation }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link org.kodoliti.fluid.model.TSubConversation }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link org.kodoliti.fluid.model.TConversation }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link org.kodoliti.fluid.model.TConversationNode }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends TConversationNode>> getConversationNode() {
        if (conversationNode == null) {
            conversationNode = new ArrayList<JAXBElement<? extends TConversationNode>>();
        }
        return this.conversationNode;
    }

}
