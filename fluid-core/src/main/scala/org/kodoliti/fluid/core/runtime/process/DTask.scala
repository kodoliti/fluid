package org.kodoliti.fluid.core.runtime.process

import org.kodoliti.fluid.assembly.ClassCreator

class DTask(script:String, id: String,
                     name: String,
                     dTree: DTree) extends DTree(id: String,
                     name: String,
                     dTree: DTree) {

  val scriptClass: Class[_] = new ClassCreator().create(script)

  def getScriptClass(): Class[_] = scriptClass


  override def process() {
    super.process()
    val clazz = getScriptClass()
    val h = clazz.newInstance()
    clazz.getMethod("execute", Array[Class[_]](): _*).invoke(h, Array[Object](): _*)

  }
}
