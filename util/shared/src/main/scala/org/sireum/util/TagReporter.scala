/*
 Copyright (c) 2016, Robby, Kansas State University
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

package org.sireum.util

trait TagReporter {
  def report(tag: Tag): Unit
}

class AccumulatingTagReporter extends TagReporter {
  var tags: ISeq[Tag] = ivectorEmpty

  def hasError: Boolean = tags.exists(_.isInstanceOf[ErrorTag])

  override def report(tag: Tag): Unit = {
    tags :+= tag
  }
}

class ConsoleTagReporter extends AccumulatingTagReporter {
  protected var currentUri: String = _

  override def report(t: Tag): Unit = {
    def uri(s: String): Unit = {
      if (s != currentUri) {
        currentUri = s
        info(s"On $s:")
      }
    }
    super.report(t)
    t match {
      case t: LocationInfo =>
        info(s"[${t.lineBegin}, ${t.columnBegin}] Something has happened.")
      case t: FileLocationInfoErrorMessage =>
        uri(t.uri)
        error(s"* [${t.lineBegin}, ${t.columnBegin}] ${t.message}")
      case t: FileLocationInfoWarningMessage =>
        uri(t.uri)
        warn(s"* [${t.lineBegin}, ${t.columnBegin}] ${t.message}")
      case t: FileLocationInfoInfoMessage =>
        uri(t.uri)
        info(s"* [${t.lineBegin}, ${t.columnBegin}] ${t.message}")
      case t: LocationInfoErrorMessage =>
        error(s"[${t.lineBegin}, ${t.columnBegin}] ${t.message}")
      case t: LocationInfoWarningMessage =>
        warn(s"[${t.lineBegin}, ${t.columnBegin}] ${t.message}")
      case t: LocationInfoInfoMessage =>
        info(s"[${t.lineBegin}, ${t.columnBegin}] ${t.message}")
      case t: InternalErrorMessage =>
        internalError(s"${t.message}")
      case t: ErrorMessage =>
        error(s"${t.message}")
      case t: WarningMessage =>
        warn(s"${t.message}")
      case t: InfoMessage =>
        info(s"${t.message}")
    }
  }

  def info(msg: String): Unit = {
    Console.err.println(msg)
    Console.err.flush()
  }

  def warn(msg: String): Unit = {
    Console.out.println(msg)
    Console.out.flush()
  }

  def error(msg: String): Unit = {
    Console.err.println(msg)
    Console.err.flush()
  }

  def internalError(msg: String): Unit = {
    Console.err.println("[Internal Error] " + msg)
    Console.err.flush()
  }
}