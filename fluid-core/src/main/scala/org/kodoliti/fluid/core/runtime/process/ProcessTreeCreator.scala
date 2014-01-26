package org.kodoliti.fluid.core.runtime.process

import org.kodoliti.fluid.model._
import java.util
import javax.xml.bind.JAXBElement
import scala.collection.JavaConverters._

object ProcessTreeCreator {


  def create(definitions: TDefinitions): PTree = {
    val elements: util.List[JAXBElement[_ <: TRootElement]] = definitions.getRootElement


    for (e <- elements.asScala) {
      //if (e.getDeclaredType.isInstanceOf[Class[TProcess]]){
      if (e.getDeclaredType.getName == "org.kodoliti.fluid.model.TProcess") {
        val tProcess: TProcess = e.getValue.asInstanceOf[TProcess]
        val sortedList = tProcess.getFlowElement.asScala sortBy (_.getValue.asInstanceOf[TBaseElement].getId)
        //       println("      e  = " + sortedList)
        //    val d = createDTree(sortedList.toList, new PTree(e.getValue.asInstanceOf[TBaseElement], null))
        //      print(d)
        return createDTree(sortedList.toList, new PTree(e.getValue.asInstanceOf[TBaseElement], null))
        //        println("      e  = " + sortedList)
      }
    }
    return null
  }


  /*  def createDTree(list: List[JAXBElement[_ <: TFlowElement]], dTree: DTree): DTree = {
      def create(list: List[JAXBElement[_ <: TFlowElement]], dTree: DTree): DTree = list match {
        case Nil => dTree
        case x :: xs if (x.getDeclaredType.getName eq "org.kodoliti.fluid.model.TStartEvent") => create(xs, dTree.setNext(new DTree("", "", null)))
        case x :: xs if (x.getDeclaredType.getName ne "org.kodoliti.fluid.model.TStartEvent") => create(xs, dTree.setNext(new DTree("", "", null)))
      }

      return create(list, dTree)
    }
  */

  /*  def createDTree(list: List[JAXBElement[_ <: TFlowElement]], dTree: DTree): DTree = {
        def create(list: List[JAXBElement[_ <: TFlowElement]], dTree: DTree): DTree = list match {
          case Nil => dTree
          case x :: xs if (x.getDeclaredType.getName eq "org.kodoliti.fluid.model.TStartEvent") => create(xs, new DTree("", "", dTree.previousNode, dTree.nextNode))
          case x :: xs if (x.getDeclaredType.getName ne "org.kodoliti.fluid.model.TStartEvent") => create(xs, new DTree("", "", dTree.previousNode, dTree.nextNode))
        }

        return create(list, dTree)
      }
  */

  def createDTree(list: List[JAXBElement[_ <: TFlowElement]], dTree: PTree): PTree = {
    def create(list: List[JAXBElement[_ <: TFlowElement]], dTree: PTree): PTree = list match {
      case Nil => dTree
      case x :: xs if (x.getDeclaredType.getName eq "org.kodoliti.fluid.model.TStartEvent") => new PStartEvent(x.getValue.asInstanceOf[TStartEvent], create(xs, dTree))
      case x :: xs if (x.getDeclaredType.getName eq "org.kodoliti.fluid.model.TScriptTask") => new PScriptTask(x.getValue.asInstanceOf[TScriptTask], create(xs, dTree))
      case x :: xs if (x.getDeclaredType.getName eq "org.kodoliti.fluid.model.TEndEvent") => new PEndEvent(x.getValue.asInstanceOf[TEndEvent], create(xs, dTree))
      //case x :: xs if (x.getDeclaredType.getName ne "org.kodoliti.fluid.model.TStartEvent") => new DStartEvent("", "", create(xs, dTree))
      case x :: xs => new PTree(x.getValue.asInstanceOf[TBaseElement], create(xs, dTree))
      //  case _ => throw new IllegalStateException()

      // case x :: xs if (x.getDeclaredType.getName ne "org.kodoliti.fluid.model.TStartEvent") => new DTree("", "", dTree.previousNode, create(xs,dTree))
      //case x :: xs if (x.getDeclaredType.getName ne "org.kodoliti.fluid.model.TStartEvent") => create(xs, new DTree("", "", dTree.previousNode, dTree.nextNode))
    }

    return create(list, dTree)
  }


}
