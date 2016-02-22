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

package org.sireum.util.jvm

import org.antlr.v4.runtime._

import org.sireum.util._

object Antlr4Util {

  final implicit class At[T <: AnyRef](val n: T) extends AnyVal {
    @inline
    def at(ctx: ParserRuleContext)(
      implicit nodeLocMap: MIdMap[AnyRef, LocationInfo]): T =
      at(ctx.getStart, ctx.getStop)

    @inline
    def at(t: Token)(
      implicit nodeLocMap: MIdMap[AnyRef, LocationInfo]): T = at(t, t)

    def at(start: Token, stop: Token)(
      implicit nodeLocMap: MIdMap[AnyRef, LocationInfo]): T = {
      val lb = stop.getLine
      val cb = stop.getCharPositionInLine
      val (le, ce) = end(lb, cb, stop.getText)
      nodeLocMap(n) =
        LocationInfo(
          offset = start.getStartIndex,
          length = stop.getStopIndex - start.getStartIndex + 1,
          lineBegin = start.getLine,
          columnBegin = start.getCharPositionInLine + 1,
          lineEnd = le,
          columnEnd = ce)
      n
    }

    def at(start: Token, stop: AnyRef)(
      implicit nodeLocMap: MIdMap[AnyRef, LocationInfo]): T = {
      val stopLi = nodeLocMap(stop)
      nodeLocMap(n) =
        LocationInfo(
          offset = start.getStartIndex,
          length = stopLi.offset + stopLi.length - start.getStartIndex,
          lineBegin = start.getLine,
          columnBegin = start.getCharPositionInLine + 1,
          lineEnd = stopLi.lineEnd,
          columnEnd = stopLi.columnEnd
        )
      n
    }

    def at(start: AnyRef, stop: Token)(
      implicit nodeLocMap: MIdMap[AnyRef, LocationInfo]): T = {
      val startLi = nodeLocMap(start)
      val lb = stop.getLine
      val cb = stop.getCharPositionInLine
      val (le, ce) = end(lb, cb, stop.getText)
      nodeLocMap(n) =
        LocationInfo(
          offset = startLi.offset,
          length = stop.getStopIndex - startLi.offset + 1,
          lineBegin = startLi.lineBegin,
          columnBegin = startLi.columnBegin,
          lineEnd = le,
          columnEnd = ce
        )
      n
    }

    def at(start: AnyRef, stop: AnyRef)(
      implicit nodeLocMap: MIdMap[AnyRef, LocationInfo]): T = {
      val startLi = nodeLocMap(start)
      val stopLi = nodeLocMap(stop)
      nodeLocMap(n) =
        LocationInfo(
          offset = startLi.offset,
          length = stopLi.offset + stopLi.length - startLi.offset,
          lineBegin = startLi.lineBegin,
          columnBegin = startLi.columnBegin,
          lineEnd = stopLi.lineEnd,
          columnEnd = stopLi.columnEnd
        )
      n
    }
  }

  def end(lineBegin: PosInteger,
          columnBegin: PosInteger,
          text: String): (PosInteger, PosInteger) = {
    val i = text.lastIndexOf('\n')
    if (i < 0)
      (lineBegin, columnBegin + text.length)
    else {
      var lines = 0
      for (c <- text if c == '\n') lines += 1
      (lineBegin + lines, text.length - i - 1)
    }
  }
}
