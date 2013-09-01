package org.kodoliti.fluid.utility.logging

import java.lang.{Throwable, Class}
import util.control.NoStackTrace
import java.text.SimpleDateFormat
import java.util.Date

class DefaultLogger extends Logger {

  // trait LogLevelType

  // type LogLevel = Int with LogLevelType

  /*    final val ErrorLevel = 1.asInstanceOf[Int with LogLevelType]
      final val WarningLevel = 2.asInstanceOf[Int with LogLevelType]
      final val InfoLevel = 3.asInstanceOf[Int with LogLevelType]
      final val DebugLevel = 4.asInstanceOf[Int with LogLevelType]
    */
  final val ErrorLevel = 1.asInstanceOf[Int]
  final val WarningLevel = 2.asInstanceOf[Int]
  final val InfoLevel = 3.asInstanceOf[Int]
  final val DebugLevel = 4.asInstanceOf[Int]


  val errorFormat = "[ERROR] [%s] [%s] [%s] %s\n%s".intern
  val errorFormatWithoutCause = "[ERROR] [%s] [%s] [%s] %s".intern
  val warningFormat = "[WARN] [%s] [%s] [%s] %s".intern
  val infoFormat = "[INFO] [%s] [%s] %s %s".intern
  val debugFormat = "[DEBUG] [%s] [%s] [%s] %s".intern


  def info(source: String) = {
    print(Info(source, Info.getClass, ""))
  }


  def print(event: LogEvent) = println(infoFormat.format(
      timestamp,
      event.thread.getName,
      event.logSource,
      event.message))

  val dateFormat = new SimpleDateFormat("HH:mm:ss.S")

  def timestamp = dateFormat.format(new Date)

  /*  def print(event: Any) {
      event match {
        case e: Error ⇒ error(e)
        case e: Warning ⇒ warning(e)
        case e: Info ⇒ info(e)
        case e: Debug ⇒ debug(e)
        case e ⇒ warning(Warning(simpleName(this), this.getClass, "received unexpected event of class " + e.getClass + ": " + e))
      }
    }
   */
}


sealed trait LogEvent {
  /**
   * The thread that created this log event
   */

  final val ErrorLevel = 1.asInstanceOf[Int]
  final val WarningLevel = 2.asInstanceOf[Int]
  final val InfoLevel = 3.asInstanceOf[Int]
  final val DebugLevel = 4.asInstanceOf[Int]

  type LogLevel = Int

  @transient
  val thread: Thread = Thread.currentThread

  /**
   * The LogLevel of this LogEvent
   */
  def level: LogLevel

  /**
   * The source of this event
   */
  def logSource: String

  /**
   * The class of the source of this event
   */
  def logClass: Class[_]

  /**
   * The message, may be any object or null.
   */
  def message: Any
}

/**
 * For ERROR Logging
 */
case class Error(cause: Throwable, logSource: String, logClass: Class[_], message: Any = "") extends LogEvent {
  def this(logSource: String, logClass: Class[_], message: Any) = this(Error.NoCause, logSource, logClass, message)

  override def level = ErrorLevel
}

object Error {
  def apply(logSource: String, logClass: Class[_], message: Any) = new Error(NoCause, logSource, logClass, message)

  /** Null Object used for errors without cause Throwable */
  object NoCause extends NoStackTrace

}

/**
 * For WARNING Logging
 */
case class Warning(logSource: String, logClass: Class[_], message: Any = "") extends LogEvent {
  override def level = WarningLevel
}

/**
 * For INFO Logging
 */
case class Info(logSource: String, logClass: Class[_], message: Any = "") extends LogEvent {
  override def level = InfoLevel
}

/**
 * For DEBUG Logging
 */
case class Debug(logSource: String, logClass: Class[_], message: Any = "") extends LogEvent {
  override def level = DebugLevel
}
