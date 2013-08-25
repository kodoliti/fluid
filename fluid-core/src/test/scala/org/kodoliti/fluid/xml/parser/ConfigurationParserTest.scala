package org.kodoliti.fluid.xml.parser

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert._
import org.junit.Test
import org.scalatest.matchers.ShouldMatchers

class ConfigurationParserTest extends AssertionsForJUnit with ConfigurationXmlSample with ShouldMatchers {


  @Test
  def shouldParseConfiguration() {
    val configuration = new ConfigurationParser().parseConfiguration(basicConfiguration)
    assertEquals(configuration, configuration)
  }

}