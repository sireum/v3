// #Sireum
/*
 Copyright (c) 2017, Robby, Kansas State University
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met:

 1. Redistributions of source code must retain the above copyright notice, this
    list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright notice,
    this list of conditions and the following disclaimer in the documentation
    and/or other materials provided with the distribution.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.sireum.lang.util

import org.sireum._
import org.sireum.lang.ast.PosInfo

object Reporter {
  object Message {
    @enum object Level {
      'InternalError
      'Error
      'Warning
      'Info
    }
  }
  @datatype class Message(level: Message.Level.Type, posOpt: Option[PosInfo], kind: String, message: String) {
    def isError: B = {
      return level == Message.Level.InternalError || level == Message.Level.Error
    }
    def fileUriOpt: Option[String] = {
      posOpt match {
        case Some(pos) => return pos.fileUriOpt
        case _ => None()
      }
    }
  }
}

@msig trait Reporter {

  def hasIssue: B

  def internalError(posOpt: Option[PosInfo], kind: String, message: String): Unit

  def error(posOpt: Option[PosInfo], kind: String, message: String): Unit

  def warn(posOpt: Option[PosInfo], kind: String, message: String): Unit

  def info(posOpt: Option[PosInfo], kind: String, message: String): Unit
}

import Reporter._
import Reporter.Message.Level

object AccumulatingReporter {
  @pure def combine(r1: AccumulatingReporter, r2: AccumulatingReporter): AccumulatingReporter = {
    return AccumulatingReporter(r1.messages ++ r2.messages)
  }
}

@record class AccumulatingReporter(var messages: ISZ[Message])
  extends Reporter {

  def hasInternalError: B = {
    for (m <- messages) {
      m.level match {
        case Level.InternalError => return T
        case _ =>
      }
    }
    return F
  }

  def hasError: B = {
    for (m <- messages) {
      m.level match {
        case Level.Error => return T
        case _ =>
      }
    }
    return F
  }

  def hasWarning: B = {
    for (m <- messages) {
      if (m.level == Level.Warning) {
        return T
      }
    }
    return F
  }

  def hasIssue: B = {
    for (m <- messages) {
      m.level match {
        case Level.InternalError => return T
        case Level.Error => return T
        case Level.Warning => return T
        case _ =>
      }
    }
    return F
  }

  def hasInfo: B = {
    for (m <- messages) {
      if (m.level == Level.Info) {
        return T
      }
    }
    return F
  }

  def hasMessage: B = {
    return messages.nonEmpty
  }

  def internalErrors: ISZ[Message] = {
    return for (m <- messages if m.level == Level.InternalError) yield m
  }

  def errors: ISZ[Message] = {
    return for (m <- messages if m.level == Level.Error) yield m
  }

  def warnings: ISZ[Message] = {
    return for (m <- messages if m.level == Level.Warning) yield m
  }

  def issues: ISZ[Message] = {
    return for (m <- messages if m.level == Level.InternalError || m.level == Level.Error || m.level == Level.Warning) yield m
  }

  def infos: ISZ[Message] = {
    return for (m <- messages if m.level == Level.Info) yield m
  }

  def internalError(posOpt: Option[PosInfo], kind: String, message: String): Unit = {
    messages = messages :+ Message(Level.InternalError, posOpt, kind, message)
  }

  def error(posOpt: Option[PosInfo], kind: String, message: String): Unit = {
    messages = messages :+ Message(Level.Error, posOpt, kind, message)
  }

  def warn(posOpt: Option[PosInfo], kind: String, message: String): Unit = {
    messages = messages :+ Message(Level.Warning, posOpt, kind, message)
  }

  def info(posOpt: Option[PosInfo], kind: String, message: String): Unit = {
    messages = messages :+ Message(Level.Info, posOpt, kind, message)
  }

  def messagesByFileUri: HashSMap[Option[String], ISZ[Message]] = {
    var r = HashSMap.empty[Option[String], ISZ[Message]]
    for (m <- messages) {
      val key: Option[String] = m.fileUriOpt
      r.get(key) match {
        case Some(ms) => r = r.put(key, ms :+ m)
        case _ => r = r.put(key, ISZ(m))
      }
    }
    return r
  }

  def printMessages(): Unit = {
    val map = messagesByFileUri
    val inclFileUri = map.size <= 1
    for (kv <- map.entries) {
      val fileUriOpt = kv._1
      val ms = kv._2
      fileUriOpt match {
        case Some(fileUri) =>
          if (inclFileUri) {
            println(s"* $fileUri")
          }
          for (m <- ms) {
            if (inclFileUri) {
              cprint(m.isError, "  ")
            }
            val mText: String = m.posOpt match {
              case Some(pos) => s"- [${pos.beginLine}, ${pos.beginColumn}] ${m.message}"
              case _ => s"- ${m.message}"
            }
            cprintln(m.isError, mText)
          }
        case _ =>
          for (m <- ms) {
            val mText: String = m.posOpt match {
              case Some(pos) => s"- [${pos.beginLine}, ${pos.beginColumn}] ${m.message}"
              case _ => s"- ${m.message}"
            }
            cprintln(m.isError, mText)
          }
      }
    }
  }

}
