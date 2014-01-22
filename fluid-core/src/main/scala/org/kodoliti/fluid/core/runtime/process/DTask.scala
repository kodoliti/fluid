package org.kodoliti.fluid.core.runtime.process


class DTask(script: String, id: String,
            name: String,
            nextTree: DTree) extends DTree(id: String, name: String, nextTree: DTree) {

  // val scriptClass: Class[_] = new ClassCreator().create(script)
  val scriptClass: Class[_] = null

  def getScriptClass(): Class[_] = scriptClass


  override def process() {
    super.process()
    val clazz = getScriptClass()
    val h = clazz.newInstance()
    clazz.getMethod("execute", Array[Class[_]](): _*).invoke(h, Array[Object](): _*)
  }
}
