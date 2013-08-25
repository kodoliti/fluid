package org.kodoliti.fluid.scala.inception

object Tester {


    def main(args: Array[String]) = singleExpression(args.toList)

    def singleExpression: List[String] => (List[Int], List[Int]) = {
        a =>
            a map (_.toInt) partition (_ < 30)
    }


}