package org.kodoliti.fluid.core.runtime.model.base

import org.kodoliti.fluid.assembly.ClassCreator

class Task(id: String, name: String, script: String) extends FlowElement {

 // def id_=(x$1: String): Unit = null

  /* def execute(executor:Executor){
      executor.execute(this)
    }*/

  val scriptClass: Class[_] = new ClassCreator().create(script)

  def getScriptClass(): Class[_] = scriptClass

}
