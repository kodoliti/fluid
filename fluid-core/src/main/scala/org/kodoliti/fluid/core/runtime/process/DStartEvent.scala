package org.kodoliti.fluid.core.runtime.process


class DStartEvent(id: String,
                  name: String,
                  nextTree: DTree) extends DTree(id: String,
                              name: String,
                              nextTree: DTree) {

  override def process() {
    super.process()
  }
}
