package org.kodoliti.fluid.activity

import org.scalatest.junit.AssertionsForJUnit
import org.scalatest.matchers.ShouldMatchers
import org.junit.{Before, Test}
import org.kodoliti.fluid.core.runtime.model.base.ProcessDef
import org.scalatest.Ignore

@Ignore
class ProcessActivityTest extends AssertionsForJUnit with ShouldMatchers {

 //  var processActivity: ProcessActivity = new ProcessActivity()

  @Before
  def setUp() {
    print("test")
  }


  @Test
  def shouldStartSimpleProcess() {
  //  processActivity.start("SIMPLE_PROCESS")
    new ProcessDef()

/*
val ns = <foo><bar>Text1</bar><bar>Text2</bar><bin/></foo>
    println("\n")
println(ns \ "bar")          // => <bar><baz/>Test</bar>
    println(ns \\ "baz")

  println(<a><b><c>hello</c></b></a> \\ "c")*/
  }

}
