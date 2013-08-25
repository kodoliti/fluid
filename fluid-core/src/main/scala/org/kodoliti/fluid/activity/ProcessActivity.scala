package org.kodoliti.fluid.activity

import org.kodoliti.fluid.bootstrap.RuntimeEnvironment
import org.kodoliti.fluid.core.runtime.process.ProcessExecutor

class ProcessActivity {

  val run = {
    print(" start configuration")
    RuntimeEnvironment()
  }

/*  def setRuntimeEnvironment() = {
    RuntimeEnvironment()
  }*/

  def start(name: String): Process = {
    // find process in processcontext
    // create new instance
    // find start node
    new ProcessExecutor().runProcess(name)

      null
  }

  def resume(process: Process): Process = {
       null
   }
}
