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

package org.sireum.lang.ast

import org.sireum._
import org.sireum.U8._
import org.sireum.S8._

object CustomMessagePack {

  val FileInfoExtType: S8 = MessagePack.StringPoolExtType + s8"1"

  @record class Reader(val reader: MessagePack.Reader.Impl) extends MsgPack.Reader {

    var fileInfoPool: MSZ[Option[FileInfo]] = MSZ()

    def errorOpt: Option[MessagePack.ErrorMsg] = {
      return reader.errorOpt
    }

    def init(): Unit = {
      reader.initialized = T
      var pOpt = reader.readExtTypeHeader()
      pOpt match {
        case Some((t, size)) =>
          assert(t == MessagePack.StringPoolExtType)
          reader.stringPool.expand(size, "")
          var i = 0
          while (i < size) {
            val s = reader.readStringConstant()
            reader.stringPool(i) = s
            i = i + 1
          }
        case _ =>
      }
      pOpt = reader.readExtTypeHeader()
      pOpt match {
        case Some((t, size)) =>
          assert(t == FileInfoExtType)
          fileInfoPool.expand(size, None())
          var i = 0
          while (i < size) {
            val o = super.readFileInfo()
            fileInfoPool(i) = Some(o)
            i = i + 1
          }
        case _ =>
      }
    }

    override def readFileInfo(): FileInfo = {
      val n = reader.readZ()
      return fileInfoPool(n).get
    }
  }

  @record class Writer(val writer: MessagePack.Writer.Impl) extends MsgPack.Writer {
    var fileInfoPool: HashSMap[FileInfo, Z] = HashSMap.empty

    override def writeFileInfo(o: FileInfo): Unit = {
      val n: Z = fileInfoPool.get(o) match {
        case Some(m) => m
        case _ =>
          fileInfoPool = fileInfoPool + o ~> fileInfoPool.size
          fileInfoPool.size - 1
      }
      writeZ(n)
    }

    override def result: ISZ[U8] = {
      val strings = writer.stringPool.keys.elements
      val poolBufferSize: Z = {
        var r: Z = 0
        for (s <- strings) {
          r = r + s.size * 2
        }
        r + 4
      }
      val (poolBuf, poolBufSize): (MSZ[U8], Z) = {
        val w = MsgPack.Writer.Default(
          MessagePack.Writer.Impl(F, MSZ.create(poolBufferSize + fileInfoPool.size * 1000, u8"0"), 0, HashSMap.empty)
        )
        w.writer.writeExtTypeHeader(MessagePack.StringPoolExtType, strings.size)
        for (s <- strings) {
          w.writer.writeStringConstant(s)
        }
        val size = fileInfoPool.size
        w.writer.writeExtTypeHeader(FileInfoExtType, size)
        for (o <- fileInfoPool.keys.elements) {
          w.writeFileInfo(o)
        }
        (w.writer.buf, w.writer.size)
      }

      val r = MSZ.create(poolBufSize + writer.size, u8"0")
      var i = 0
      while (i < poolBufSize) {
        r(i) = poolBuf(i)
        i = i + 1
      }
      i = 0
      while (i < writer.size) {
        r(i + poolBufSize) = writer.buf(i)
        i = i + 1
      }
      return r.toIS
    }
  }

  def fromTopUnit(o: TopUnit): ISZ[U8] = {
    val writer = Writer(MessagePack.Writer.Impl(T, MS.create(1024, u8"0"), 0, HashSMap.emptyInit(1024)))
    writer.writeTopUnit(o)
    val r = writer.result
    return r
  }

  def toTopUnit(data: ISZ[U8]): TopUnit = {
    val reader = Reader(MessagePack.Reader.Impl(data, 0, MSZ(), T))
    reader.init()
    val r = reader.readTopUnit()
    return r
  }

  def fromExp(o: Exp): ISZ[U8] = {
    val writer = Writer(MessagePack.Writer.Impl(T, MS.create(1024, u8"0"), 0, HashSMap.emptyInit(1024)))
    writer.writeExp(o)
    val r = writer.result
    return r
  }

  def toExp(data: ISZ[U8]): Exp = {
    val reader = Reader(MessagePack.Reader.Impl(data, 0, MSZ(), T))
    reader.init()
    val r = reader.readExp()
    return r
  }

}
