package org.kodoliti.fluid.bootstrap

import org.kodoliti.fluid.core.runtime.model.ProcessConf
import org.xml.sax.InputSource
import javax.xml.validation.SchemaFactory
import javax.xml.XMLConstants
import javax.xml.transform.stream.StreamSource
import java.io.File
import org.kodoliti.fluid.xml.ResourceResolver
import javax.xml.bind.{JAXBElement, Unmarshaller, JAXBContext}
import org.kodoliti.fluid.model.TDefinitions
import org.kodoliti.fluid.core.runtime.process.{PTree, ProcessTreeCreator}

//import scala.collection.JavaConversions.


object ProcessContextLoader {

  def apply(processConf: ProcessConf) {
    // find process diagrams
    // create run context for all processes(diagrams)

  }
}

class ProcessContextLoader(processConf: ProcessConf) {

  val jaxbContext: String = "org.kodoliti.fluid.model"

  val fileName: String = "bpmn/SimpleProcess.xml"
  var fileSource: InputSource = _

  val source: StreamSource = new StreamSource(ClassLoader.getSystemResourceAsStream("bpmn/SimpleProcess.xml"))

  val schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
  schemaFactory.setResourceResolver(new ResourceResolver())
  val schema = schemaFactory.newSchema(new StreamSource(ClassLoader.getSystemResourceAsStream("bpmn/schema/BPMN20.xsd")))
  /*val schema = schemaFactory.newSchema(Array[Source](new StreamSource(ClassLoader.getSystemResourceAsStream("bpmn/schema/BPMN20.xsd")),
                                          new StreamSource(ClassLoader.getSystemResourceAsStream("bpmn/schema/BPMNDI.xsd")),
                                          new StreamSource(ClassLoader.getSystemResourceAsStream("bpmn/schema/DC.xsd")),
                                          new StreamSource(ClassLoader.getSystemResourceAsStream("bpmn/schema/DI.xsd")),
                                          new StreamSource(ClassLoader.getSystemResourceAsStream("bpmn/schema/DiagramDefinition.xsd")),
                                          new StreamSource(ClassLoader.getSystemResourceAsStream("bpmn/schema/DiagramInterchange.xsd")),
                                          new StreamSource(ClassLoader.getSystemResourceAsStream("bpmn/schema/Semantic.xsd"))))
 */
  val dictionaryPath = List("", fileName)

  def loadProcessTree(): Option[List[PTree]] = {
      return null
  }

  def load(): Option[PTree] = {
    /* val wordstream = Option {
       getClass.getClassLoader.getResourceAsStream(fileName)
     } orElse {
       resourceAsStreamFromSrc(dictionaryPath)
     } getOrElse {
       sys.error("Could not load word list, dictionary file not found")
     } */
    try {
      // val s = io.Source.fromInputStream(wordstream)
      // val xml = new XMLLoader(schema).loadXML(new InputSource(wordstream))


      //  ConfigurationEnvironment(new ConfigurationParser().parseConfiguration(xml))
      //  Some(new BPMNFileParser().getBPMNProcessDefinitions(xml))

      val jc: JAXBContext = JAXBContext.newInstance(jaxbContext)

      val unmarshaller: Unmarshaller = jc.createUnmarshaller
      unmarshaller.setSchema(schema)

      val root: JAXBElement[TDefinitions] = unmarshaller.unmarshal(source, classOf[TDefinitions])

      val value: TDefinitions = root.getValue
      //Some(ConfigurationEnvironment.getConfiguration())

      Some(ProcessTreeCreator.create(value))


    } catch {
      case e: Exception => println("Could not load word list: " + e)
        throw e
    } finally {
      //   wordstream.close()
    }
  }

  def subFile(file: File, children: String*) = {
    children.foldLeft(file)((file, child) => new File(file, child))
  }

  def resourceAsStreamFromSrc(resourcePath: List[String]): Option[java.io.InputStream] = {
    val classesDir = new File(getClass.getResource(".").toURI)
    val projectDir = classesDir.getParentFile.getParentFile.getParentFile.getParentFile
    val resourceFile = subFile(projectDir, ("src" :: "main" :: "resources" :: resourcePath): _*)
    if (resourceFile.exists)
      Some(new java.io.FileInputStream(resourceFile))
    else
      None
  }

}