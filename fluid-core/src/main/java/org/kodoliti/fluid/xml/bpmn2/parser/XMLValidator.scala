package org.kodoliti.fluid.xml.bpmn2.parser

import org.xml.sax.InputSource
import org.w3c.dom.Node
import javax.xml.parsers.{SAXParserFactory, SAXParser}
import xml.{Elem, TopScope}
import xml.parsing.NoBindingFactoryAdapter
import javax.xml.validation.Schema


class XMLValidator(schema : Schema) extends NoBindingFactoryAdapter {

  def loadXML(source: InputSource): Elem = {
    // create parser
    val parser: SAXParser = try {
      val f = SAXParserFactory.newInstance()
      f.setNamespaceAware(true)
      f.setFeature("http://xml.org/sax/features/namespace-prefixes", true)
      f.newSAXParser()
    } catch {
      case e: Exception =>
        Console.err.println("error: Unable to instantiate parser")
        throw e
    }

    val xr = parser.getXMLReader()
    val vh = schema.newValidatorHandler()
    vh.setContentHandler(this)
    xr.setContentHandler(vh)

    // parse file
    scopeStack.push(TopScope)
    xr.parse(source)
    scopeStack.pop
    return rootElem.asInstanceOf[Elem]
  }
}