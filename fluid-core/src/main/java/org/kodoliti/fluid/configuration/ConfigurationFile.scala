package org.kodoliti.fluid.configuration

import java.io.{IOException, FileNotFoundException}
import io.BufferedSource


class ConfigurationFile {


    val fileName : String = "fluid.xml"
    var fileSource : BufferedSource = _

  //  var text: Nothing = io.Source.fromInputStream(getClass.getResourceAsStream("file.xml")).mkString

    def loadFile(){
        try {
        fileSource = io.Source.fromInputStream(ClassLoader.getSystemResourceAsStream(fileName))

        } catch {
            case ex: FileNotFoundException => {
                println("Missing file exception")
            }
            case ex: IOException => {
                println("IO Exception")
            }
        }
    }

}