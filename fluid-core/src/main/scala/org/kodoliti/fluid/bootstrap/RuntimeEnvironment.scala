package org.kodoliti.fluid.bootstrap

object RuntimeEnvironment {
  var isRunning: Boolean = false;

  def apply() {
    if (!isRunning) {
      new RuntimeContext().run();
      isRunning = true;
    }
  }
}

class RuntimeEnvironment {

}
