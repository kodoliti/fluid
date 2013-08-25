package org.kodoliti.fluid.core.runtime.model.base

case class ProcessDef(id: String,
                 name: String,
                 events: List[Event],
                 tasks: List[Task],
                 sequences :List[SequenceFlow] ) {

  def this() = this("","", null, null, null)



}
