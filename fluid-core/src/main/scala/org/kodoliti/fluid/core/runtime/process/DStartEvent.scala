package org.kodoliti.fluid.core.runtime.process

import org.kodoliti.fluid.utility.logging.Log


class DStartEvent(id: String,
                  name: String,
                  nextTree: DTree) extends DTree(id, name, nextTree) with Log {

  override def process() {
    super.execute()
  }
}
