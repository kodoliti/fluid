package org.kodoliti.fluid.utility


object BaseConversion {

    implicit def toInt(value: String) = {
        try {
            value.toInt
        } catch {
            case ex: java.lang.NumberFormatException => 0
        }
    }

}