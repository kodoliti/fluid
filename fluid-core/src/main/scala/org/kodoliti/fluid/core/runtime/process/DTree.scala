package org.kodoliti.fluid.core.runtime.process

class DTree(id: String,
            name: String,
            nextTree: DTree) {

  def this() = this("","", null)

  val nextNode: DTree = nextTree


  def execute() ={

  }

 /* def process() = {

  } */

  def setNext(dTree: DTree): DTree = {
   // nextNode = dTree
    return nextNode
  }


  def isEndNode(): Boolean = true

}
