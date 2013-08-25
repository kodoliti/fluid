package org.kodoliti.fluid.core.runtime.process

class DTree(id: String,
                     name: String,
                     dTree: DTree) {

  val nextNode = dTree

  def process() = {


  }

  def isEndNode(): Boolean = true

}
