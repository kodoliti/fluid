package org.kodoliti

import java.net.InetAddress


object TestApp {

  val q = 10
  lazy val v = {print("master")}

  def c = {print("master c")}

  def funct() : Int ={
    for (x <- (1 to 100000000))
      x

    1
  }
    def main(args:Array[String]){
     // println(((1000 to 10000).toStream take(10)).toList)
     // println(evaluate(3, funct ))
    //  ((1000 to 10000) filter isPrime)(1)
   //   println(List(100, 200, 300) map { _ * 10/100 *q })

        var test = List("1","2")

              var test2 = "wqewq" :: test


        println("Test app "+expr )

        var addr:InetAddress = InetAddress.getLocalHost();

    // Get IP Address
        var ipAddr:Array[Byte] = addr.getAddress();
       print(" ipaddr "+ipAddr)
    // Get hostname
        var hostname:String = addr.getHostAddress();
        print("hostname "+hostname);
    }

  def expr = {
    val x = {
      print("x "); 1
    }
    lazy val y = {
      print( " y "); 2
    }
    def z = {
      print( " z "); 3
    }
    //x + y
   z + y + x + z + y + x
  }

  //x z y  z

  def evaluate(x:Int, y: => Int) = {  x + y }
 }