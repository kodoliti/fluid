package org.kodoliti.fluid.core.runtime.process

import org.kodoliti.fluid.model.{TFlowElement, TScriptTask}
import org.kodoliti.fluid.assembly.ClassCreator
import org.kodoliti.fluid.utility.logging.Logger

class PScriptTask(tElement: TScriptTask,
                  nextTree: PTree) extends PTask(tElement: TFlowElement, nextTree: PTree) {

  val log = Logger

  val name: String = tElement.getName


  val scriptClass: Class[_] = new ClassCreator().create("System.out.println(\"Hello World!!!!\");")

  def getScriptClass(): Class[_] = scriptClass

  val clazz = getScriptClass()
  val h = clazz.newInstance()


  override def execute() {
    log.info("script task execute")
    clazz.getMethod("execute", Array[Class[_]](): _*).invoke(h, Array[Object](): _*)
  }


}
