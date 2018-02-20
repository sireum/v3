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

package org.sireum.lang.tipe

import org.sireum._
import org.sireum.lang.{ast => AST}
import org.sireum.U8._

object CustomMessagePack {

  @record class Reader(val reader: MessagePack.Reader.Impl) extends MsgPack.Reader {

    def errorOpt: Option[MessagePack.ErrorMsg] = {
      return reader.errorOpt
    }

    def init(): Unit = {
      reader.initialized = T
      reader.pooling = T
      var pOpt = reader.readExtTypeHeader()
      pOpt match {
        case Some((t, size)) =>
          assert(t == MessagePack.StringPoolExtType)
          reader.stringPool.expand(size, "")
          var i = 0
          while (i < size) {
            val s = reader.readStringNoPool()
            reader.stringPool(i) = s
            i = i + 1
          }
        case _ =>
      }
      pOpt = reader.readExtTypeHeader()
      pOpt match {
        case Some((t, size)) =>
          assert(t == MessagePack.DocInfoExtType)
          reader.docInfoPool.expand(size, message.DocInfo(None(), ISZ()))
          var i = 0
          while (i < size) {
            val docInfo = reader.readDocInfoNoPool()
            reader.docInfoPool(i) = docInfo
            i = i + 1
          }
        case _ =>
      }
    }
  }

  @record class Writer(val writer: MessagePack.Writer.Impl) extends MsgPack.Writer {

    override def result: ISZ[U8] = {
      val strings = writer.stringPool.keys.elements
      val poolBufferSize: Z = {
        var r: Z = 0
        for (s <- strings) {
          r = r + s.size * 2
        }
        r + 4
      }
      val (stringPoolBuf, stringPoolBufSize): (MSZ[U8], Z) = {
        val r = MessagePack.Writer.Impl(F, MSZ.create(poolBufferSize, u8"0"), 0)
        r.writeExtTypeHeader(MessagePack.StringPoolExtType, strings.size)
        for (s <- strings) {
          r.writeStringNoPool(s)
        }
        r.writeExtTypeHeader(MessagePack.DocInfoExtType, writer.docInfoPool.size)
        for (di <- writer.docInfoPool.keys.elements) {
          r.writeDocInfoNoPool(di)
        }
        (r.buf, r.size)
      }

      val r = MSZ.create(stringPoolBufSize + writer.size, u8"0")
      var i = 0
      while (i < stringPoolBufSize) {
        r(i) = stringPoolBuf(i)
        i = i + 1
      }
      i = 0
      while (i < writer.size) {
        r(i + stringPoolBufSize) = writer.buf(i)
        i = i + 1
      }
      return r.toIS
    }
  }

  def fromTopUnit(o: AST.TopUnit): ISZ[U8] = {
    val writer = Writer(MessagePack.Writer.Impl(T, MS.create(1024, u8"0"), 0))
    writer.write_astTopUnit(o)
    val r = writer.result
    return r
  }

  def toTopUnit(data: ISZ[U8]): AST.TopUnit = {
    val reader = Reader(MessagePack.Reader.Impl(data, 0))
    reader.init()
    val r = reader.read_astTopUnit()
    return r
  }

  def fromExp(o: AST.Exp): ISZ[U8] = {
    val writer = Writer(MessagePack.Writer.Impl(T, MS.create(1024, u8"0"), 0))
    writer.write_astExp(o)
    val r = writer.result
    return r
  }

  def toExp(data: ISZ[U8]): AST.Exp = {
    val reader = Reader(MessagePack.Reader.Impl(data, 0))
    reader.init()
    val r = reader.read_astExp()
    return r
  }

}
