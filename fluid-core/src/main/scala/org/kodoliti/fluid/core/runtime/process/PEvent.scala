package org.kodoliti.fluid.core.runtime.process

import org.kodoliti.fluid.utility.logging.{Logger, Log}
import org.kodoliti.fluid.model.{TEvent, TEndEvent, TBaseElement, TStartEvent}


class PEvent(tElement: TEvent,
                  nextTree: PTree) extends PTree(tElement: TBaseElement, nextTree) with Log {
  val log = Logger
}

class PStartEvent(tElement: TStartEvent,
                  nextTree: PTree) extends PEvent(tElement: TEvent, nextTree) with Log {

  override def execute() {
    log.info("start process")
  }
}

class PEndEvent(tElement: TEndEvent,
                nextTree: PTree) extends PEvent(tElement: TEvent, nextTree) {

  override def execute() {
    log.info("end process")
  }

}
