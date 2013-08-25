package org.kodoliti.fluid.xml.bpmn2.parser

import javax.xml.XMLConstants
import javax.xml.validation.SchemaFactory
import javax.xml.transform.stream.StreamSource


import xml.XML
import org.xml.sax.{InputSource, XMLReader}
import java.io.{FileInputStream, File}


object SchemaAdapterTest {

         // A schema can be loaded in like ...
        val sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
        val s = sf.newSchema(new StreamSource(ClassLoader.getSystemResourceAsStream("configuration/fluid-schema.xsd")))

   // val s = sf.newSchema(new StreamSource(getClass.getResourceAsStream("configuration/fluid-schema.xsd")))

        // and whenever we would want to do something like:

      //  val is = new InputSource(new File("foo.xml"))
       // val xml = XML.load(is)

        // instead we'll use our class:



    def main(args: Array[String]) = {
     //    print(" @@@@@@   : "+ClassLoader.getSystemResourceAsStream("fluid-schema.xsd").mkString)
        val is = new InputSource(ClassLoader.getSystemResourceAsStream("fluid.xml"))
        val xml = new SchemaAwareFactoryAdapter(s).loadXML(is)
        print(xml)
    }

}