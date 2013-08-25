package org.kodoliti.fluid.xml.bpmn2.parser



object XMLParserDemo {
   import scala.xml._;
   def getBolds1(node: Node): Unit = node match {
      case <b>{c}</b> => println("pogrubione: " + c)
      case <p>{c @ _ *}</p> => for (child <- c) getBolds1(child)
      case _ => { }
   }
   def getBolds2(node: Node): Unit = {
      node match {
         case Elem(_, "p", _, _, c @ _ *) => c.foreach(k => getBolds2(k))
         case Elem(_, "b", _, _, c @ _ *) => println("pogrubione: " + node.text);
         case _ => { }
      }
   }
   def getBolds3(doc: Node) = for (node <- doc \\ "b") println("pogrubione: " + node.text);
   def main(args: Array[String]) = {
      val doc =
      <html>
          <body>
          <p>Scala is a <b>Java-like programming language</b>...
               ...mainstream languages – <p><b>Java</b> and C#</p>.
          </p>
          </body>
      </html>
      val body = (doc \\ "p")
      println(body)
      println("Pierwsza wersja:");
      getBolds1(body(0));
  //    println("Druga wersja");
   //   getBolds2(body(0));
   //   println("Trzecia wersja");
    //  getBolds3(body(0));
   }
}