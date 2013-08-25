package org.kodoliti.fluid.core.runtime.model.base

import org.kodoliti.fluid.core.runtime.process.Executor

case class StartEvent(id: String, name: String) extends Event {
  def id_=(x$1: String): Unit = null

  def execute(executor:Executor){
    executor.execute(this)
  }

}
