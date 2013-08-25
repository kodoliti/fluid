package org.kodoliti.fluid.bootstrap

import org.xml.sax.InputSource
import javax.xml.validation.SchemaFactory
import javax.xml.XMLConstants
import javax.xml.transform.stream.StreamSource
import org.kodoliti.fluid.xml.util.XMLLoader
import xml.Elem


class ContextFileLoader {

    val fileName: String = "fluid.xml"
    val fileSource: InputSource = new InputSource(ClassLoader.getSystemResourceAsStream(fileName))

    val schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
    val schema = schemaFactory.newSchema(new StreamSource(ClassLoader.getSystemResourceAsStream("configuration/fluid-schema.xsd")))

    val xml: Elem = {
        //fileSource = scala.io.Source.fromInputStream(ClassLoader.getSystemResourceAsStream(fileName))
        //fileSource = new InputSource(ClassLoader.getSystemResourceAsStream(fileName))
        if (fileSource != null) {
            new XMLLoader(schema).loadXML(fileSource)
        } else {
            loadDefault()
        }
    }

/*
    def load(): Elem = {
        //fileSource = scala.io.Source.fromInputStream(ClassLoader.getSystemResourceAsStream(fileName))
      //  fileSource = new InputSource(ClassLoader.getSystemResourceAsStream(fileName))
        if (fileSource != null) {
            new XMLLoader(schema).loadXML(fileSource)
        } else {
            loadDefault()
        }

    }
*/
    def loadDefault(): Elem = {
        null
    }

}