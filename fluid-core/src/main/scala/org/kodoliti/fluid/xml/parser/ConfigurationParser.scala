package org.kodoliti.fluid.xml.parser


import scala.xml._
import scala.Predef._
import org.kodoliti.fluid.core.runtime.model._
import org.kodoliti.fluid.utility.BaseConversion._
import org.kodoliti.fluid.core.runtime.model.Grid
import org.kodoliti.fluid.core.runtime.model.GridNode
import org.kodoliti.fluid.core.runtime.model.PersistenceConnectionConf
import org.kodoliti.fluid.core.runtime.model.SystemConf
import org.kodoliti.fluid.core.runtime.model.Persistence


class ConfigurationParser {

  def parseConfiguration(xml: Elem): FluidConf = {
    //  new SystemConf(parseGrid(xml \\ "grid"),
    //   parsePersistence(xml \\ "persistence"))
    FluidConf(getSystemConf(xml), getProcessConf(xml))
  }

  def getSystemConf(xml: Elem): SystemConf = {
    SystemConf(Grid(getGridNodes(xml)), Persistence(PersistenceProviderType.MONGODB, getPersistenceConnectionConf(xml)))
  }

  def getProcessConf(xml: Elem): ProcessConf = {
    ProcessConf(Diagram(((xml \\ "diagram").head \\ "@location").toString), getTaskList(xml))
  }

  def getTaskList(xml: Elem) : List[Task] = {
    getObjectListFromNodeSeq(xml \\ "task", List[Task](), node => new Task((node \\ "@class").toString))
  }

  def getPersistenceConnectionConf(xml: Elem): PersistenceConnectionConf  = {
    getObjectListFromNodeSeq(xml \\ "connection-conf", List[PersistenceConnectionConf](),
      node => new PersistenceConnectionConf((node \\ "@driverClass").toString,
        (node \\ "@host").toString,
        (node \\ "@port").toString,
          (node \\ "@username").toString,
          (node \\ "@password").toString)).head
  }

  def getGridNodes(xml: Elem): List[GridNode] = {
    getObjectListFromNodeSeq(xml \\ "node", List[GridNode](), node => new GridNode((node \\ "@id").toString(), (node \\ "@address").toString))
  }


  def getObjectListFromNodeSeq[T](nodeSeq: NodeSeq, acc: List[T], f: Node => T): List[T] = {
    if (nodeSeq.isEmpty)
      acc
    else
      (acc :+ f(nodeSeq.head)) ::: getObjectListFromNodeSeq(nodeSeq.tail, acc, f)
  }

  /*
       def parseGrid(nodeSeq: NodeSeq): Grid = {
          // <nodes>
          //    <node id="" address="" />
          // </nodes>

        //   var gridNodes = Array[GridNode]()
           val list = new ListBuffer[GridNode]
           val nodes: NodeSeq = nodeSeq(0) \\ "node"

           for (node <- nodes){
               list.append(new GridNode(NumberUtil.getInt((node \\ "@id").toString), (node \\ "@address").toString))
           }
           print(list.toArray size)

         //  for (val node <- nodes.map(_ => <node></node>)){
             //  println(nodes)
              // println(node)
        //   }

          new Grid(list.toList)

         //  node match {
           //    case <b>{c}</b> => new Grid(null)
              // case <p>
              //         {c@_ *}
              //         </p> => for (child <- c) getBolds1(child)
          //     case _ => new Grid(null)
          // }
       }


   def parsePersistence(nodeSeq: NodeSeq): Persistence = {
     new Persistence()
   }
 */
}