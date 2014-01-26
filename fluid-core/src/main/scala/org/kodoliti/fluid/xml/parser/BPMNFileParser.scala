package org.kodoliti.fluid.xml.parser

import xml.{Node, NodeSeq, Elem}
import org.kodoliti.fluid.core.runtime.model.base._
import org.kodoliti.fluid.core.runtime.model.base.ProcessDef
import org.kodoliti.fluid.core.runtime.process.PTree
import org.kodoliti.fluid.model.TDefinitions
import javax.xml.bind.{Unmarshaller, JAXBContext}

class BPMNFileParser {


  def parseBPMNProcessDefinition(xml: Elem): ProcessDef = {
    val processElem = (xml \\ "process").head

    ProcessDef((processElem \ "@id").toString, (processElem \ "@name").toString,
      getEvents((processElem \\ "_").toList, List[Event]()), null,
    //  getListFromNodeSeq(xml \\ "scriptTask", List[Task](), node => Task((node \ "@id").text, (node \ "@name").text, (node \ "script").text)),
      getListFromNodeSeq(xml \\ "sequenceFlow", List[SequenceFlow](), node => new SequenceFlow((node \ "@id").text, (node \ "@sourceRef").text, (node \ "@targetRef").text, getCondition(node))))
  }

  def getEvents(nodes: List[Node], acc: List[Event]): List[Event] = {
    nodes match {
      case x :: xs if (x.label == "startEvent") => (acc :+ new StartEvent((x \ "@id").text, (x \ "@name").text)) ::: getEvents(xs, acc)
      case x :: xs if (x.label == "endEvent") => (acc :+ new EndEvent((x \ "@id").text, (x \ "@name").text)) ::: getEvents(xs, acc)
      case x :: xs => acc ++: getEvents(xs, acc)
      case Nil => acc
    }
  }

  def getListFromNodeSeq[T](nodeSeq: NodeSeq, acc: List[T], f: Node => T): List[T] = {
    if (nodeSeq.isEmpty)
      acc
    else
      (acc :+ f(nodeSeq.head)) ::: getListFromNodeSeq(nodeSeq.tail, acc, f)
  }

  def getCondition(node: Node) : Option[ConditionExpression] = {
    val condition = (node \ "conditionExpression")
    if (condition.isEmpty)
      return None
    else
      return Some(new ConditionExpression(condition.text))
  }

  def getBPMNProcessDefinitions(xml: Elem): TDefinitions = {



    return null
  }


}