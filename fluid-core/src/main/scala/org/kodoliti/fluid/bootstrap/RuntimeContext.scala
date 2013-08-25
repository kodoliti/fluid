package org.kodoliti.fluid.bootstrap

import xml.Elem
import org.kodoliti.fluid.core.runtime.{ProcessEnvironment, ConfigurationEnvironment}
import javassist._
import javassist.bytecode.MethodInfo
import org.kodoliti.fluid.CtProcessClass
import java.lang.reflect.Method
import org.kodoliti.fluid.utility.logging.Logger
import org.kodoliti.fluid.core.runtime.process.DTree

class RuntimeContext {

//  var ctProcessClass = new CtProcessClass()

  //val xml: Elem = new ContextFileLoader().xml
  def run() {
    val fluidConf = new ConfigurationLoader().load.get
    //ProcessContextLoader(ConfigurationEnvironment.getConfiguration().process)
  //  ProcessContextLoader(fluidConf.process)
    val dTree =  new ProcessContextLoader().load().get
    ProcessEnvironment(dTree)

//    val script = processDef.tasks.head.script


 //   val pool:ClassPool = ClassPool.getDefault()
  //  val ctClass:CtClass = pool.get("org.kodoliti.fluid.CtProcessClass")
   // val ctMethod:CtMethod = new CtMethod(CtClass.voidType, "test", Array[CtClass](ctClass), ctClass)

  // val ctMethod:CtMethod = new CtMethod(CtClass.voidType, "test", null, ctClass)
  //  ctClass.addMethod(ctMethod)
  //  ctMethod.setBody(script)
   // ctClass.writeFile()

  //  val mt:CtMethod = CtNewMethod.make("public static void main(String[] args) { System.out.println(\"Hello World!\"); }", ctClass);
   // ctClass.addMethod(mt);
   // ctClass.writeFile();
     //val ctProcessClass = new CtProcessClass();
    //val c = ctClass.toClass(this.getClass().getClassLoader());



    //val ctProcessClass = c.newInstance()
    //val cl = new Loader(pool)
   // val cnew = cl.loadClass("org.kodoliti.fluid.CtProcessClass");
  //  val ctProcessClass = c.newInstance();
    //val ctProcessClass = c.newInstance()

//    println("aaa  "+getMethodsName(ctClass.getMethods.toList))
 //   val clazz = java.lang.Class.forName("org.kodoliti.fluid.CtProcessClass")

  //  println("meth : "+getMethodsName(c.getMethods.toList))
   // println("method : "+c.getMethod("test", Array[Class[_]]():_*).getReturnType)

/*
    val cp = ClassPool.getDefault();
    val cc = cp.get("org.kodoliti.fluid.CtProcessClass");
    cc.defrost();
    val m = cc.getDeclaredMethod("call");

    m.insertBefore("{ System.out.println(\"Hello.say():\"); }");

    val ctMethod:CtMethod = CtNewMethod.make(CtClass.voidType, "test", null, null, script, cc)

    // new CtMethod(CtClass.voidType, "test", null, cc)
    cc.addMethod(ctMethod)
     ctMethod.setBody(script)
    val c = cc.toClass()
    val h  = c.newInstance().asInstanceOf[CtProcessClass]
    h.call();





    c.getMethod("test", Array[Class[_]]():_*).invoke(h, Array[Object]():_*) */
  }

 /* def getMethodsName(list : List[Method]){
    if (!list.isEmpty){
      println (list.head.getName)
      getMethodsName(list.tail)
    }
  }

  def runTest() {
    val fluidConf = new ConfigurationLoader().load.get
      //ProcessContextLoader(ConfigurationEnvironment.getConfiguration().process)
    //  ProcessContextLoader(fluidConf.process)
      val processDef =  new ProcessContextLoader().load().get
      print(processDef)
      val script = processDef.tasks.head.script
   //   val pool:ClassPool = ClassPool.getDefault()
    //  val ctClass:CtClass = pool.get("org.kodoliti.fluid.CtProcessClass")
     // val ctMethod:CtMethod = new CtMethod(CtClass.voidType, "test", Array[CtClass](ctClass), ctClass)

    // val ctMethod:CtMethod = new CtMethod(CtClass.voidType, "test", null, ctClass)
    //  ctClass.addMethod(ctMethod)
    //  ctMethod.setBody(script)
     // ctClass.writeFile()

    //  val mt:CtMethod = CtNewMethod.make("public static void main(String[] args) { System.out.println(\"Hello World!\"); }", ctClass);
     // ctClass.addMethod(mt);
     // ctClass.writeFile();
       //val ctProcessClass = new CtProcessClass();
      //val c = ctClass.toClass(this.getClass().getClassLoader());



      //val ctProcessClass = c.newInstance()
      //val cl = new Loader(pool)
     // val cnew = cl.loadClass("org.kodoliti.fluid.CtProcessClass");
    //  val ctProcessClass = c.newInstance();
      //val ctProcessClass = c.newInstance()

  //    println("aaa  "+getMethodsName(ctClass.getMethods.toList))
   //   val clazz = java.lang.Class.forName("org.kodoliti.fluid.CtProcessClass")

    //  println("meth : "+getMethodsName(c.getMethods.toList))
     // println("method : "+c.getMethod("test", Array[Class[_]]():_*).getReturnType)


      val cp = ClassPool.getDefault();
      val cc = cp.get("org.kodoliti.fluid.CtProcessClass");
      cc.defrost();
      val m = cc.getDeclaredMethod("call");

      m.insertBefore("{ System.out.println(\"Hello.say():\"); }");

      val ctMethod:CtMethod = CtNewMethod.make(CtClass.voidType, "test", null, null, script, cc)

      // new CtMethod(CtClass.voidType, "test", null, cc)
      cc.addMethod(ctMethod)
       ctMethod.setBody(script)
      val c = cc.toClass()
      val h  = c.newInstance().asInstanceOf[CtProcessClass]
      h.call();
  }*/


}