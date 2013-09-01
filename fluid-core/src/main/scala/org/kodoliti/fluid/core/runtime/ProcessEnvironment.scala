package org.kodoliti.fluid.core.runtime

import model.base.ProcessDef
import process.DTree

object ProcessEnvironment {

  private var dTree: DTree = _

  def apply(dTree: DTree) {
    this.dTree = dTree
  }

  def getProcessDef(): DTree = dTree

}

class ProcessEnvironment {

}
