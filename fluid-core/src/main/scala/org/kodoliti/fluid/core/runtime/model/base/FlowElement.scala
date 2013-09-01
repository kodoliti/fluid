package org.kodoliti.fluid.core.runtime.model.base

import org.kodoliti.fluid.core.runtime.process.Executor

abstract class FlowElement {

   var id:String

   def execute(executor:Executor)
}
