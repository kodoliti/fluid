package org.kodoliti.fluid.core.runtime

import process.PTree

object ProcessEnvironment {

  private var pTreeList: List[PTree] = _

  def apply(pTreeList: List[PTree]) {
    this.pTreeList = pTreeList
  }

  def getProcessTree(): PTree = pTreeList.head

  def findProcessTree(name: String): PTree = pTreeList.find(_.id equalsIgnoreCase(name)).get

}

class ProcessEnvironment {

}
