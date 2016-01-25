/*
Copyright (c) 2015, Robby, Kansas State University
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

package org.sireum.awas.ast

import java.io.StringReader

import org.antlr.v4.runtime._
import org.sireum.awas.parser.Antlr4AwasParser._
import org.sireum.util._
import scala.collection._
import org.antlr.v4.runtime.tree._

import org.sireum.util.jvm.Antlr4Util._

final class Builder private() {

  private implicit val nodeLocMap = midmapEmpty[AnyRef, LocationInfo]

  def build(ctx: ModelContext): Model = {
    val r = Model(ctx.typeDecl().map(build),
      ctx.constantDecl().map(build),
      ctx.componentDecl().map(build),
      ctx.connectionDecl().map(build)
    ) at ctx
    r.nodeLocMap = midmapEmpty.asInstanceOf[MIdMap[Node, LocationInfo]]
    r
  }

  def build(ctx: TypeDeclContext): TypeDecl =
    ctx match {
      case ctx: AliasTypeDeclContext => build(ctx.asInstanceOf[AliasTypeDeclContext].typeAliasDecl())
      case ctx: EnumTypeDeclContext => build(ctx.asInstanceOf[EnumTypeDeclContext].enumDecl())
      case ctx: LatticeTypeDeclContext => build(ctx.asInstanceOf[LatticeTypeDeclContext].latticeDecl())
      case ctx: RecordTypeDeclContext => build(ctx.asInstanceOf[RecordTypeDeclContext].recordDecl())
    }

  def build(ctx: ConstantDeclContext): ConstantDecl = {
    ConstantDecl(build(ctx.name()), build(ctx.`type`()), build(ctx.init())) at ctx
  }

  def build(ctx: ComponentDeclContext): ComponentDecl = {
    ComponentDecl(build(ctx.name()),
      ctx.port().map(build),
      ctx.flow().map(build),
      ctx.property().map(build)) at ctx
  }

  def build(ctx: ConnectionDeclContext): ConnectionDecl = {
    ConnectionDecl(build(ctx.connName),
      build(ctx.fromComponent),
      buildId(ctx.fromPort),
      ctx.fromE.map(build),
      build(ctx.toComponent),
      buildId(ctx.toPort),
      ctx.toE.map(build),
      ctx.property().map(build)) at ctx
  }

  def build(ctx: TypeAliasDeclContext): AliasDecl = {
    AliasDecl(build(ctx.name()),
      build(ctx.`type`())) at ctx
  }

  def build(ctx: EnumDeclContext): EnumDecl = {
    EnumDecl(build(ctx.n), ctx.supers.map(build), ctx.elements.map(buildId)) at ctx
  }

  def build(ctx: LatticeDeclContext): LatticeDecl = {
    LatticeDecl(build(ctx.n), ctx.supers.map(build)) at ctx
  }

  def build(ctx: RecordDeclContext): RecordDecl = {
    RecordDecl(build(ctx.name()), ctx.field().map(build)) at ctx
  }

  def build(ctx: FieldContext): FieldDecl = {
    FieldDecl(buildId(ctx.ID()), build(ctx.`type`())) at ctx
  }

  def build(ctx: PortContext): Port = {
    val mod = ctx.mod.getText().equals("in")
    Port(mod, buildId(ctx.ID()),
      if (ctx.name() != null) Some(build(ctx.name())) else None) at ctx
  }

  def build(ctx: FlowContext): Flow = {
    Flow(buildId(ctx.id),
      arbitraryToken(ctx.from),
      ctx.fromE.map(build),
      arbitraryToken(ctx.to),
      ctx.toE.map(build)) at ctx
  }

  def arbitraryToken(n: Token): Option[Id] = {
    n match {
      case null => None
      case n => n.getText() match {
        case "_" => None
        case _ => Some(buildId(n))
      }
    }
  }

  def build(ctx: PropertyContext): Property = {
    Property(buildId(ctx.ID()), build(ctx.`type`()),
      if (ctx.init() != null) Some(build(ctx.init())) else None) at ctx
  }

  def build(ctx: NameContext): Name = {
    Name(ctx.ID().map(toToken _ andThen buildId _)) at ctx
  }

  def buildId(t: Token): Id = {
    Id(t.getText.intern()) at t
  }

  def build(ctx: TypeContext): Type = {
    ctx match {
      case ctx: BaseTypeContext => build(ctx.basicType())
      case ctx: OptionTypeContext => OptionTypeDecl(build(ctx.`type`())) at ctx
      case ctx: SetTypeContext => SetTypeDecl(build(ctx.`type`())) at ctx
      case ctx: SeqTypeContext => SeqTypeDecl(build(ctx.`type`())) at ctx
      case ctx: MapTypeContext => MapTypeDecl(build(ctx.basicType()), build(ctx.`type`())) at ctx
    }
  }

  def build(ctx: BasicTypeContext): BasicType = {
    ctx match {
      case ctx: BooleanTypeContext => BooleanTypeDecl() at ctx
      case ctx: IntegerTypeContext => IntegerTypeDecl(
        if (ctx.hi != null) Some((build(ctx.hi), build(ctx.lo))) else None) at ctx
      case ctx: RealTypeContext => RealTypeDecl() at ctx
      case ctx: StringTypeContext => StringTypeDecl() at ctx
      case ctx: ComponentTypeContext => ComponentTypeDecl() at ctx
      case ctx: PortTypeContext => PortTypeDecl() at ctx
      case ctx: NamedTypeContext => NamedTypeDecl(build(ctx.name())) at ctx
    }
  }

  def build(ctx: IntConstantContext): IntTypeDisc = {
    ctx match {
      case ctx: LitIntConstantContext => IntLit(ctx.INTEGER().getText.toInt) at ctx
      case ctx: NamedIntConstantContext => NamedIntType(build(ctx.name())) at ctx
      case ctx: ArbitraryIntConstantContext => ArbitrartyIntType() at ctx
    }
  }

  def build(ctx: InitContext): Init = {
    ctx match {
      case ctx: TrueContext => BooleanInit(true) at ctx
      case ctx: FalseContext => BooleanInit(false) at ctx
      case ctx: IntegerContext => IntegerInit(ctx.INTEGER().getText.toInt) at ctx
      case ctx: RealContext => RealInit(ctx.REAL().getText.toDouble) at ctx
      case ctx: StringContext => StringInit(ctx.STRING().getText) at ctx
      case ctx: RecordContext => RecordInit(build(ctx.name()), ctx.ID().map(t => buildId(t) ->
        build(ctx.init(ctx.ID().indexOf(t))))(breakOut): IMap[Id, Init]) at ctx
      case ctx: NameRefContext => NameRefInit(build(ctx.name()),
        if (ctx.ID() != null) Some(buildId(ctx.ID())) else None) at ctx
      case ctx: NoneContext => NoneInit(build(ctx.`type`())) at ctx
      case ctx: SomeContext => SomeInit(build(ctx.`type`()), build(ctx.init())) at ctx
      case ctx: SetContext => SetInit(build(ctx.`type`()), ctx.init().map(build).toSet) at ctx
      case ctx: SeqContext => SeqInit(build(ctx.`type`()), ctx.init().map(build)) at ctx
      case ctx: MapContext => {
        var mapinit = imapEmpty[Init, Init]
        ctx.mapEntry().forEach(mp => {
          mapinit = mapinit + (build(mp.key) -> build(mp.value))
        })
        MapInit(build(ctx.basicType()), build(ctx.`type`()), mapinit) at ctx
      }
    }
  }

  import scala.language.implicitConversions

  @inline
  private implicit def toNodeSeq[T](ns: java.lang.Iterable[T]): Node.Seq[T] =
    Node.seq[T](scala.collection.JavaConversions.iterableAsScalaIterable(ns))

  @inline
  private implicit def toToken(n: TerminalNode): Token = n.getSymbol
}

object Builder {

  trait Reporter {
    def error(line: PosInteger,
              column: PosInteger,
              offset: Natural,
              message: String): Unit
  }

  object ConsoleReporter extends Reporter {
    override def error(line: PosInteger,
                       column: PosInteger,
                       offset: Natural,
                       message: String): Unit = {
      //Console.err.println(s"[$line, $column] $message")
      Console.err.println("[" + line + ", " + column + "] " + message)
      Console.err.flush()
    }
  }

  def apply(input: String,
            maxErrors: Natural = 0,
            reporter: Reporter = ConsoleReporter): Option[Model] = {
    class ParsingEscape extends RuntimeException

    import org.sireum.awas.parser.Antlr4AwasLexer
    import org.sireum.awas.parser.Antlr4AwasParser

    val sr = new StringReader(input)
    val inputStream = new ANTLRInputStream(sr)
    val lexer = new Antlr4AwasLexer(inputStream)
    val tokens = new CommonTokenStream(lexer)
    val parser = new Antlr4AwasParser(tokens)
    parser.removeErrorListeners()
    var success = true
    parser.addErrorListener(new BaseErrorListener {
      var errors = 0

      override def syntaxError(recognizer: Recognizer[_, _],
                               offendingSymbol: Any,
                               line: PosInteger,
                               charPositionInLine: PosInteger,
                               msg: String,
                               e: RecognitionException): Unit = {
        success = false
        val token = offendingSymbol.asInstanceOf[Token]
        val start = token.getStartIndex
        reporter.error(line, charPositionInLine, start, msg + " (token=" + token.getType + ")")
        errors += 1
        if (maxErrors > 0 && errors >= maxErrors) {
          throw new ParsingEscape
        }
      }
    })
    val mfOpt: Option[ModelFileContext] =
      try {
        success = true
        Some(parser.modelFile())
      } catch {
        case t: Throwable => None
      }
    if (success)
      mfOpt.map(mf => new Builder().build(mf.model()))
    else
      None
  }
}