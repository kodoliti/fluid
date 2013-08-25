package org.kodoliti.fluid.core.runtime.process


class DStartEvent(id: String,
                       name: String,
                       dTree: DTree) extends DTree(id: String,
                                              name: String,
                                              dTree: DTree) {

  override def process() {
    super.process()
  }
}
