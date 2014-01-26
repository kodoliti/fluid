package org.kodoliti.fluid.core.runtime.process

import org.kodoliti.fluid.assembly.ClassCreator
import org.kodoliti.fluid.model.{TBaseElement, TFlowElement}


class PTask(tFlowElement: TFlowElement,
            nextTree: PTree) extends PTree(tFlowElement: TBaseElement, nextTree: PTree) {

}
