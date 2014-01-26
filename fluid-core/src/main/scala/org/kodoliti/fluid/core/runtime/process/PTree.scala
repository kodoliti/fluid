package org.kodoliti.fluid.core.runtime.process

import org.kodoliti.fluid.model.TBaseElement

class PTree(tElement: TBaseElement,
            nextTree: PTree) {

  //def this() = this("", "", null)

  val id: String = tElement.getId

  val nextNode: PTree = nextTree

  def execute() = {}

  def setNext(dTree: PTree): PTree = {
    // nextNode = dTree
    return nextNode
  }


  def isEndNode(): Boolean = nextNode == null

}
