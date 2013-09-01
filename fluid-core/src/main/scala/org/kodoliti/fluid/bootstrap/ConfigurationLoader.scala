package org.kodoliti.fluid.bootstrap

import java.io.File
import javax.xml.validation.SchemaFactory
import javax.xml.XMLConstants
import javax.xml.transform.stream.StreamSource
import org.kodoliti.fluid.xml.util.XMLLoader
import org.xml.sax.InputSource
import org.kodoliti.fluid.core.runtime.ConfigurationEnvironment
import org.kodoliti.fluid.xml.parser.ConfigurationParser
import org.kodoliti.fluid.core.runtime.model.FluidConf

class ConfigurationLoader {


  val fileName: String = "fluid.xml"
  var fileSource: InputSource = _

  val schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
  val schema = schemaFactory.newSchema(new StreamSource(ClassLoader.getSystemResourceAsStream("configuration/fluid-schema.xsd")))

  /*    val numbers = Array(1, 2, 3, 4, 5)
  val sum = numbers.reduceLeft[Int](_ + _)

  type t = Grid {def someMethod: String => {

  }}

  def delayedInit(body: => Unit)

  def test: Unit => {

  }

  */

  /* def load() {
     try {
       //fileSource = scala.io.Source.fromInputStream(ClassLoader.getSystemResourceAsStream(fileName))
       fileSource = new InputSource(ClassLoader.getSystemResourceAsStream(fileName))
       if (fileSource == null) {
         loadDefault()
       } else {
         val xml = new XMLLoader(schema).loadXML(fileSource)
         ConfigurationEnvironment(new ConfigurationParser().parseConfiguration(xml))
         ConfigurationEnvironment.getConfiguration()
       }
     } catch {
       case ex: FileNotFoundException => {
         println("Missing file exception")
       }
       case ex: IOException => {
         println("IO Exception")
       }
     }
   } */

  /* def load(xml: Elem) {
     ConfigurationEnvironment(new ConfigurationParser().parseConfiguration(xml))
     ConfigurationEnvironment.getConfiguration()
   }

 */
  def loadDefault() {

  }


  val dictionaryPath = List("", fileName)

  def load() : Option[FluidConf] = {
    val wordstream = Option {
      getClass.getClassLoader.getResourceAsStream(fileName)
    } orElse {
      resourceAsStreamFromSrc(dictionaryPath)
    } getOrElse {
      sys.error("Could not load word list, dictionary file not found")
    }
    try {
    //  val s = io.Source.fromInputStream(wordstream)
      val xml = new XMLLoader(schema).loadXML(new InputSource(wordstream))
      ConfigurationEnvironment(new ConfigurationParser().parseConfiguration(xml))
      Some(ConfigurationEnvironment.getConfiguration())
    } catch {
      case e: Exception =>
        println("Could not load word list: " + e)
        throw e
    } finally {
      wordstream.close()
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