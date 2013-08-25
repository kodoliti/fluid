package org.kodoliti.fluid.core.runtime.model

object PersistenceProviderType extends Enumeration {
    type PersistenceProviderType = Value
    val MONGODB = Value("MONGODB")
    val CASSANDRA = Value("CASSANDRA")

    def getValue(s: String): PersistenceProviderType = {
        PersistenceProviderType.Value
    }
}