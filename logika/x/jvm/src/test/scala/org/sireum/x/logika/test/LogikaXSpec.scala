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

package org.sireum.x.logika.test

import org.scalatest.FreeSpec

class LogikaXSpec extends FreeSpec {
  private val m: scala.collection.mutable.Map[Int, Int] = {
    import scala.collection.JavaConverters._
    new java.util.concurrent.ConcurrentHashMap[Int, Int]().asScala
  }

  private def name(line: Int): String = {
    val last = m.getOrElseUpdate(line, 0)
    val next = last + 1
    m(line) = next
    if (last == 0) s"L$line" else s"L$line # $next"
  }

  def *(b: => Boolean)(implicit pos: org.scalactic.source.Position): Unit = {
    registerTest(name(pos.lineNumber))(assert(b))(pos)
  }

  def *(title: String)(b: => Boolean)(implicit pos: org.scalactic.source.Position): Unit = {
    registerTest(s"${name(pos.lineNumber)}: $title")(assert(b))(pos)
  }

  def *(b: => Boolean, msg: => String)(implicit pos: org.scalactic.source.Position): Unit = {
    registerTest(name(pos.lineNumber))(assert(b, msg))(pos)
  }
}