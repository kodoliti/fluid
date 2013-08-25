package org.kodoliti.fluid.utility.logging

object Logger {

  private var logger: Logger = new DefaultLogger()

  def setLogger(logger: Logger) {
    this.logger = logger
  }

  def info(source: String) {
    logger.info(source)
  }

}

abstract class Logger {

  def info(source: String)

}
