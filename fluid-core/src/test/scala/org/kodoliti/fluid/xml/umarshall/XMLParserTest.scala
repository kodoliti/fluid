package org.kodoliti.fluid.xml.umarshall


import org.scalatest.junit.AssertionsForJUnit
import collection.mutable.ListBuffer
import org.junit.Assert._
import org.junit.{Before, Test}

//@RunWith(classOf[JUnitRunner])
class XMLParserTest extends AssertionsForJUnit {


  var big_bob: String = _

  big_bob += 'def
  var sb: StringBuilder = _
  var lb: ListBuffer[String] = _

  @Before def initialize() {
    sb = new StringBuilder("ScalaTest is ")
    lb = new ListBuffer[String]
  }

  @Test def verifyEasy() {
    // Uses JUnit-style assertions
    sb.append("easy!")
    val numbers = Array(1, 2, 3, 4, 5)
    val sum = numbers.reduceLeft[Int](_ + _)
    print(sum)

    assertEquals("ScalaTest is easy!", sb.toString)
    assertTrue(lb.isEmpty)
    lb += "sweet"
    try {
      "verbose".charAt(-1)
      fail()
    }
    catch {
      case e: StringIndexOutOfBoundsException => // Expected
    }
  }

}