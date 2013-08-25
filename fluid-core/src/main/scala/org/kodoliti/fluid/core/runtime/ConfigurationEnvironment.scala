package org.kodoliti.fluid.core.runtime

import model.{FluidConf, SystemConf}


class ConfigurationEnvironment private(val configuration: SystemConf) {
    //  def this (grid : Grid) = this(grid, null)


   // @transient
    override lazy val toString = {
        val sb = new StringBuilder("")
        sb.append("://")
        //  sb.append(persistenceProviderType)
        print(sb.toString)
        sb.toString
    }

}

object ConfigurationEnvironment {

    //val (myVar1: Int, myVar2: String) = Pair(40, "Foo")
     private var configuration: FluidConf = _

    // def apply(protocol: String, system: String) = new Address(protocol, system)

    // def apply(protocol: String, system: String, host: String, port: Int) = new Address(protocol, system, Some(host), Some(port))

    def apply(configuration: FluidConf) {
        this.configuration = configuration
        //new ConfigurationEnvironment(configuration)
    }

    def getConfiguration(): FluidConf = configuration


    configuration = {

        new FluidConf(null, null)

    }
}