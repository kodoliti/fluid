package org.kodoliti.fluid.core.runtime.process

import org.kodoliti.fluid.core.runtime.ProcessEnvironment
import org.kodoliti.fluid.core.runtime.model.base._
import org.kodoliti.fluid.core.runtime.model.base.StartEvent
import org.kodoliti.fluid.core.runtime.model.base.SequenceFlow
import org.kodoliti.fluid.core.runtime.model.base.ProcessDef
import org.kodoliti.fluid.utility.logging.Logger
import org.kodoliti.fluid.model.TDefinitions

class ProcessExecutor {

  val log = Logger

  def runProcess(name: String) = {
   // val processDef: ProcessDef = ProcessEnvironment.getProcessDef()

   // val startEvent = processDef.events.find(e => e.isInstanceOf[StartEvent]).get
    //val endEvent = processDef.events.find(e => e.isInstanceOf[EndEvent]).get

   // val sequences = processDef.sequences

 //   val orderedSeq = createOrderedSequence(Seq(), sequences, startEvent.asInstanceOf[StartEvent].id)
    //run(orderedSeq, processDef.tasks, startEvent.asInstanceOf[StartEvent], endEvent.asInstanceOf[EndEvent], processDef)
  //  run(orderedSeq, processDef.tasks, processDef)
  }


  // todo add handling when sequence wasn't found
  def createOrderedSequence(seq: Seq[SequenceFlow], sequences: List[SequenceFlow], startIdx: String): Seq[SequenceFlow] = {
    if (sequences.isEmpty) {
      seq
    } else {
      val sourceRefSeq = sequences.find(s => s.sourceRef == startIdx).get
      (seq :+ sourceRefSeq) ++: createOrderedSequence(seq, sequences.filter(s => s != sourceRefSeq), sourceRefSeq.targetRef)
    }
  }

  def process(dTree:DTree): DTree = {

    if (dTree.isEndNode())
     return null
     else
    dTree.process()

    return dTree.nextNode;
  }


  def run(seq: Seq[SequenceFlow], tasks: List[Task], processDef: ProcessDef) {
    log.info(">>>> start processing <<<<")
    val startEvent = processDef.events.find(e => e.isInstanceOf[StartEvent])

    if (startEvent.isEmpty) throw new IllegalStateException("Here isn't start node")

    startEvent.get.execute(new Executor)

    val elements: List[FlowElement] = processDef.events ::: processDef.tasks

    for (sequenceFlow <- seq) {

     /* val sourceEvent = elements.find(e => e.id == sequenceFlow.sourceRef)

      if (!sourceEvent.isEmpty) {
        sourceEvent.get.execute(new Executor())
      } */
      val targetEvent = elements.find(e => e.id == sequenceFlow.targetRef)

      if (!targetEvent.isEmpty) {
        targetEvent.get.execute(new Executor())
      }

      if (!targetEvent.isEmpty) {
        if (sequenceFlow.condition.isEmpty)
           targetEvent.get.execute(new Executor())
        else
          sequenceFlow.condition
      }


      /*  val event = processDef.events.find(e => e.id == sequenceFlow.sourceRef && e.isInstanceOf[Event])

        if (!event.isEmpty) {
          new Executor().execute(event.get)
        }
      */


      /*
      val optionTask = tasks.find(task => task.id == sequenceFlow.sourceRef)
           if (!optionTask.isEmpty) {
             log.info("execute task")
             val clazz = optionTask.get.getScriptClass()
             val h = clazz.newInstance()
             clazz.getMethod("execute", Array[Class[_]](): _*).invoke(h, Array[Object](): _*)
           }
     */
    }
    // log.info("node : " + endEvent.name)
    log.info(">>>> end processing <<<<")
  }

}

class Executor {
  val log = Logger
  /* def execute(event: Event) {
     log.info("event node : " + event.name)
   }
 */

  def execute(task: Task) {
    log.info("execute task")
    val clazz = task.getScriptClass()
    val h = clazz.newInstance()
    clazz.getMethod("execute", Array[Class[_]](): _*).invoke(h, Array[Object](): _*)
  }

  def execute(startEvent: StartEvent) {
    log.info("node : " + startEvent.name)
  }

  def execute(endEvent: EndEvent) {
    log.info("node : " + endEvent.name)
  }

  def execute(exclusiveGateway: ExclusiveGateway) {
     log.info("exclusiveGateway : " + exclusiveGateway)
   }

}
