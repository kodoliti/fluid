package org.kodoliti.fluid.core.runtime.model.base

case class SequenceFlow(id: String, sourceRef: String, targetRef: String, condition : Option[ConditionExpression]) {

}

class ConditionExpression(script: String){
}
