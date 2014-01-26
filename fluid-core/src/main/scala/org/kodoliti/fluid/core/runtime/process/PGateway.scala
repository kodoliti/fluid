package org.kodoliti.fluid.core.runtime.process

import org.kodoliti.fluid.model.{TBaseElement, TGateway, TFlowElement}

class PGateway(tFlowElement: TGateway,
                     nextTree: PTree) extends PTree(tFlowElement: TBaseElement, nextTree: PTree) {


  def test() {
  }

}
