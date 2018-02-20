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
import org.sireum.lang.symbol._

/*
Pools:
org.sireum.lang.ast.Typed
org.sireum.lang.ast.ResolvedInfo
org.sireum.lang.symbol.Scope.Global

Emptiness:
org.sireum.lang.ast.Attr
org.sireum.lang.ast.Contract
 */
object CustomMessagePack {

  val TypedPoolExtType: S8 = MessagePack.LastExtType.increase
  val ResolvedInfoPoolExtType: S8 = TypedPoolExtType.increase
  val ScopeGlobalPoolExtType: S8 = ResolvedInfoPoolExtType.increase
  val emptyContract: AST.Contract = AST.Contract(ISZ(), ISZ(), ISZ(), ISZ(), ISZ())
  val emptyAttr: AST.Attr = AST.Attr(None())

  @record class Reader(val reader: MessagePack.Reader.Impl) extends MsgPack.Reader {

    val typedPool: MSZ[AST.Typed] = MSZ()
    val resolvedInfoPool: MSZ[AST.ResolvedInfo] = MSZ()
    val scopeGlobalPool: MSZ[Scope.Global] = MSZ()

    def errorOpt: Option[MessagePack.ErrorMsg] = {
      return reader.errorOpt
    }

    def init(): Unit = {
      reader.initialized = T
      reader.pooling = F
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
      pOpt = reader.readExtTypeHeader()
      pOpt match {
        case Some((t, size)) =>
          assert(t == TypedPoolExtType)
          typedPool.expand(size, AST.Typed.Tuple(ISZ()))
          var i = 0
          while (i < size) {
            val typed = super.read_astTyped()
            typedPool(i) = typed
            i = i + 1
          }
        case _ =>
      }
      pOpt = reader.readExtTypeHeader()
      pOpt match {
        case Some((t, size)) =>
          assert(t == ResolvedInfoPoolExtType)
          resolvedInfoPool.expand(size, AST.ResolvedInfo.Object(ISZ()))
          var i = 0
          while (i < size) {
            val ri = super.read_astResolvedInfo()
            resolvedInfoPool(i) = ri
            i = i + 1
          }
        case _ =>
      }
      pOpt = reader.readExtTypeHeader()
      pOpt match {
        case Some((t, size)) =>
          assert(t == ScopeGlobalPoolExtType)
          scopeGlobalPool.expand(size, Scope.Global(ISZ(), ISZ(), ISZ()))
          var i = 0
          while (i < size) {
            val sg = super.read_symbolScopeGlobal()
            scopeGlobalPool(i) = sg
            i = i + 1
          }
        case _ =>
      }
      reader.pooling = T
    }

    override def read_astContract(): AST.Contract = {
      val isNil = reader.skipIfNil()
      if (isNil) {
        return emptyContract
      } else {
        val r = super.read_astContract()
        return r
      }
    }

    override def read_astAttr(): AST.Attr = {
      val isNil = reader.skipIfNil()
      if (isNil) {
        return emptyAttr
      } else {
        val r = super.read_astAttr()
        return r
      }
    }

    override def read_astTyped(): AST.Typed = {
      if (reader.pooling) {
        val n = reader.readZ()
        return typedPool(n)
      } else {
        val r = super.read_astTyped()
        return r
      }
    }

    override def read_astTypedFun(): AST.Typed.Fun = {
      val o = read_astTyped()
      o match {
        case o: AST.Typed.Fun => return o
        case _ =>
          if (errorOpt.nonEmpty) {
            return AST.Typed.Fun(F, F, ISZ(), AST.Typed.unit)
          } else {
            halt("Unexpected situation when reading AST.Typed.Fun MessagePack")
          }
      }
    }

    override def read_astResolvedInfo(): AST.ResolvedInfo = {
      if (reader.pooling) {
        val n = reader.readZ()
        return resolvedInfoPool(n)
      } else {
        val r = super.read_astResolvedInfo()
        return r
      }
    }

    override def read_symbolScopeGlobalT(typeParsed: B): Scope.Global = {
      if (!reader.pooling) {
        val r = super.read_symbolScopeGlobalT(typeParsed)
        return r
      }
      if (!typeParsed) {
        reader.expectZ(MsgPack.Constants._symbolScopeGlobal)
      }
      val n = reader.readZ()
      return scopeGlobalPool(n)
    }

  }

  @record class Writer(val writer: MessagePack.Writer.Impl) extends MsgPack.Writer {

    var typedPool: HashSMap[AST.Typed, Z] = HashSMap.emptyInit(1024)
    var resolvedInfoPool: HashSMap[AST.ResolvedInfo, Z] = HashSMap.emptyInit(1024)
    var scopeGlobalInfoPool: HashSMap[Scope.Global, Z] = HashSMap.emptyInit(1024)

    override def write_symbolScopeGlobal(o: Scope.Global): Unit = {
      writer.writeZ(MsgPack.Constants._symbolScopeGlobal)
      val n: Z = scopeGlobalInfoPool.get(o) match {
        case Some(m) => m
        case _ =>
          val m = scopeGlobalInfoPool.size
          scopeGlobalInfoPool = scopeGlobalInfoPool + o ~> m
          m
      }
      writer.writeZ(n)
    }

    override def write_astResolvedInfo(o: AST.ResolvedInfo): Unit = {
      val n: Z = resolvedInfoPool.get(o) match {
        case Some(m) => m
        case _ =>
          val m = resolvedInfoPool.size
          resolvedInfoPool = resolvedInfoPool + o ~> m
          m
      }
      writer.writeZ(n)
    }

    override def write_astTyped(o: AST.Typed): Unit = {
      val n: Z = typedPool.get(o) match {
        case Some(m) => m
        case _ =>
          val m = typedPool.size
          typedPool = typedPool + o ~> m
          m
      }
      writer.writeZ(n)
    }

    override def write_astTypedFun(o: AST.Typed.Fun): Unit = {
      write_astTyped(o)
    }

    override def write_astContract(o: AST.Contract): Unit = {
      if (o == emptyContract) {
        writer.writeNil()
      } else {
        super.write_astContract(o)
      }
    }

    override def write_astAttr(o: AST.Attr): Unit = {
      if (o == emptyAttr) {
        writer.writeNil()
      } else {
        super.write_astAttr(o)
      }
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
        val r = MsgPack.Writer.Default(MessagePack.Writer.Impl(F, MSZ.create(poolBufferSize, u8"0"), 0))
        r.writer.writeExtTypeHeader(MessagePack.StringPoolExtType, strings.size)
        for (s <- strings) {
          r.writer.writeStringNoPool(s)
        }
        r.writer.writeExtTypeHeader(MessagePack.DocInfoExtType, writer.docInfoPool.size)
        for (di <- writer.docInfoPool.keys.elements) {
          r.writer.writeDocInfoNoPool(di)
        }
        r.writer.writeExtTypeHeader(TypedPoolExtType, typedPool.size)
        for (t <- typedPool.keys.elements) {
          r.write_astTyped(t)
        }
        r.writer.writeExtTypeHeader(ResolvedInfoPoolExtType, resolvedInfoPool.size)
        for (ri <- resolvedInfoPool.keys.elements) {
          r.write_astResolvedInfo(ri)
        }
        r.writer.writeExtTypeHeader(ScopeGlobalPoolExtType, scopeGlobalInfoPool.size)
        for (sg <- scopeGlobalInfoPool.keys.elements) {
          r.write_symbolScopeGlobal(sg)
        }
        (r.writer.buf, r.writer.size)
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

  def readTypeHierarchy(reader: MsgPack.Reader): TypeHierarchy = {
    def readQName(): Resolver.QName = {
      reader.reader.readISZ(reader.reader.readString _)
    }
    val infos = reader.reader.readISZ(reader.read_symbolInfo _)
    val typeInfos = reader.reader.readISZ(reader.read_symbolTypeInfo _)
    val poset = reader.reader.readPoset(readQName _)
    val aliases = reader.reader.readHashMap(readQName _, reader.read_astTyped _)
    var nameMap = HashMap.emptyInit[Resolver.QName, Info](infos.size)
    for (info <- infos) {
      nameMap = nameMap + info.name ~> info
    }
    var typeMap = HashMap.emptyInit[Resolver.QName, TypeInfo](typeInfos.size)
    for (typeInfo <- typeInfos) {
      typeMap = typeMap + typeInfo.name ~> typeInfo
    }
    return TypeHierarchy(nameMap, typeMap, poset, aliases)
  }

  def writeTypeHierarchy(writer: MsgPack.Writer, o: TypeHierarchy): Unit = {
    def writeQName(o: ISZ[String]): Unit = {
      writer.writer.writeISZ(o, writer.writer.writeString _)
    }
    writer.writer.writeISZ(o.nameMap.values, writer.write_symbolInfo _)
    writer.writer.writeISZ(o.typeMap.values, writer.write_symbolTypeInfo _)
    writer.writer.writePoset(o.poset, writeQName _)
    writer.writer.writeHashMap(o.aliases, writeQName _, writer.write_astTyped _)
  }

  def fromTypeHierarchy(o: TypeHierarchy): ISZ[U8] = {
    val writer = Writer(MessagePack.Writer.Impl(T, MS.create(1024, u8"0"), 0))
    writeTypeHierarchy(writer, o)
    val r = writer.result
    return r
  }

  def toTypeHierarchy(data: ISZ[U8]): Either[TypeHierarchy, MessagePack.ErrorMsg] = {
    val reader = Reader(MessagePack.Reader.Impl(data, 0))
    reader.init()
    val r = readTypeHierarchy(reader)
    if (reader.reader.errorOpt.nonEmpty) {
      println(reader.reader.errorOpt)
    }
    reader.reader.errorOpt match {
      case Some(err) => return Either.Right(err)
      case _ => return Either.Left(r)
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
    assert(reader.reader.errorOpt.isEmpty)
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
    assert(reader.reader.errorOpt.isEmpty)
    return r
  }

}
