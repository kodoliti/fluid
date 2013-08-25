package org.kodoliti.fluid.bootstrap

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert._
import org.junit.Test
import org.kodoliti.fluid.core.runtime.ConfigurationEnvironment
import org.kodoliti.fluid.core.runtime.model._
import org.kodoliti.fluid.core.runtime.model.Grid
import org.kodoliti.fluid.core.runtime.model.GridNode
import org.kodoliti.fluid.core.runtime.model.SystemConf
import org.kodoliti.fluid.core.runtime.model.Persistence
import org.kodoliti.fluid.CtProcessClass

class ConfigurationLoaderTest extends AssertionsForJUnit {

  @Test
  def shouldLoadConfiguration() {
    new ConfigurationLoader().load
    val environment: ConfigurationEnvironment.type = ConfigurationEnvironment
    val configuration: FluidConf = environment.getConfiguration
    println("ConfigurationEnvironment.getConfiguration() = " + configuration)
    assertEquals(new SystemConf(Grid(List(GridNode(1, "192.168.1.10"), GridNode(2, "192.168.1.11"))),
      Persistence(PersistenceProviderType.MONGODB, PersistenceConnectionConf("", "127.0.0.1", 27017, "", ""))), ConfigurationEnvironment.getConfiguration().systemConf)
  }

}