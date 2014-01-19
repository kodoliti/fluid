package org.kodoliti.fluid.core.runtime.process

import org.kodoliti.fluid.model._
import java.util
import javax.xml.bind.JAXBElement
import scala.collection.JavaConverters._

object DTreeCreator {


  def create(definitions: TDefinitions): DTree = {
    val elements: util.List[JAXBElement[_ <: TRootElement]] = definitions.getRootElement


    for (e <- elements.asScala) {
      //if (e.getDeclaredType.isInstanceOf[Class[TProcess]]){
      if (e.getDeclaredType.getName == "org.kodoliti.fluid.model.TProcess") {
        val tProcess: TProcess = e.getValue.asInstanceOf[TProcess]
        val sortedList = tProcess.getFlowElement.asScala sortBy (_.getValue.asInstanceOf[TBaseElement].getId)
        println("      e  = " + sortedList)


        val d = createDTree(sortedList.toList, new DTree("", "", null))
        print(d)
        return d

        println("      e  = " + sortedList)
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

  def createDTree(list: List[JAXBElement[_ <: TFlowElement]], dTree: DTree): DTree = {
    def create(list: List[JAXBElement[_ <: TFlowElement]], dTree: DTree): DTree = list match {
      case Nil => dTree
      case x :: xs if (x.getDeclaredType.getName eq "org.kodoliti.fluid.model.TStartEvent") => new DStartEvent("", "", create(xs, dTree))
      case x :: xs if (x.getDeclaredType.getName eq "org.kodoliti.fluid.model.TScriptTask") => new DTask("","1","2",create(xs, dTree))
      //case x :: xs if (x.getDeclaredType.getName ne "org.kodoliti.fluid.model.TStartEvent") => new DStartEvent("", "", create(xs, dTree))
      case x :: xs => new DTree("","",create(xs, dTree))
    //  case _ => throw new IllegalStateException()

      // case x :: xs if (x.getDeclaredType.getName ne "org.kodoliti.fluid.model.TStartEvent") => new DTree("", "", dTree.previousNode, create(xs,dTree))
      //case x :: xs if (x.getDeclaredType.getName ne "org.kodoliti.fluid.model.TStartEvent") => create(xs, new DTree("", "", dTree.previousNode, dTree.nextNode))
    }
    return create(list, dTree)
  }


}
