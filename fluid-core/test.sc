import org.kodoliti.fluid.core.runtime.model.base.{EndEvent, StartEvent, Event}
import scala.xml.Elem
import scala.xml.Node
import scala.xml.NodeSeq

//type MyType = Int => Int
def singletonSet(elem: Int) : Int => Int = (x:Int) => x + elem
println(singletonSet(4)(4))


val l = List(1,2,3) :+ 4
l :+ 9
//val events = List[Event]()
//events :+ StartEvent("id" , "test")
val b = <def><a><b>123</b><c>qqqq</c></a><diagram></diagram></def>
val xml = (b \\ "a")


def getListFromNodeSeq(nodeSeq: NodeSeq, acc: List[String]):List[String] = {
  if (nodeSeq.isEmpty){
    acc
  } else {
    println(nodeSeq.head.label)
    (acc :+ nodeSeq.head.label) ::: getListFromNodeSeq(nodeSeq.tail, acc)
  }
}
getListFromNodeSeq(xml \ "_", List())








//(b \\ "a").map(x => println(x.label))
class Foo() { def :++ (n:Int) = println(2*n) }
val foo = new Foo()
  foo :++ 111
def getEvents(xml: Elem): List[Event] = {
   val events = List[Event]()
 //  println(StartEvent("id" , "test"))
 //  events :+ StartEvent("id" , "test") :+ EndEvent("id" , "test")
    val start = new StartEvent("id" , "test")
  // "test" ++: start
  events
   //events :+ EndEvent("id" , "test")
 }








println(getEvents(null))










