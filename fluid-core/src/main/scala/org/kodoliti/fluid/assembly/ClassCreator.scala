package org.kodoliti.fluid.assembly

import javassist.{CtClass, CtNewMethod, CtMethod, ClassPool}

class ClassCreator {

  def create(script: String): Class[_] = {
    val cp = ClassPool.getDefault();
    val cc = cp.makeClass("Point");
    //val cc = cp.get("org.kodoliti.fluid.CtProcessClass");
    cc.defrost();
    val ctMethod: CtMethod = CtNewMethod.make(CtClass.voidType, "execute", null, null, script, cc)
    cc.addMethod(ctMethod)
    cc.toClass()
  }

}
