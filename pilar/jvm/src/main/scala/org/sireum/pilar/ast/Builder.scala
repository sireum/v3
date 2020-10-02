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

package org.sireum.pilar.ast

import java.io.StringReader

import org.antlr.v4.runtime.atn.PredictionMode
import org.antlr.v4.runtime.misc.ParseCancellationException
import org.sireum.util._
import org.sireum.pilar.parser._
import org.sireum.pilar.parser.Antlr4PilarParser._
import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree._

import org.sireum.util.jvm.Antlr4Util._

final class Builder private() {

  private implicit val nodeLocMap = midmapEmpty[AnyRef, LocationInfo]

  def build(ctx: ModelContext): Model = {
    val r =
      Model(
        ctx.modelElement().map(build),
        ctx.annotation().map(build)
      ) at ctx
    r.nodeLocMap = midmapEmpty.asInstanceOf[MIdMap[Node, LocationInfo]]
    r
  }

  def build(ctx: AnnotationContext): Annotation = {
    val id = buildID(ctx.ID())
    Annotation(id,
      Option(ctx.LIT().getSymbol).map(lit => buildLIT(id, lit)).
        getOrElse(RawLit(""))) at ctx
  }

  def build(ctx: LitContext): (Id, Lit) = {
    val id = buildID(ctx.ID())
    (id, buildLIT(id, ctx.LIT()))
  }

  def buildID(n: Token): Id = {
    val text = n.getText
    (if (text.charAt(0) == '\'')
      Id(text.substring(1, text.length).intern())
    else if (text.charAt(0) match {
      case '.' | '~' | '!' | '%' | '^' | '&' | '*' |
           '-' | '+' | '=' | '|' | '<' | '>' | '/' | '?' => true
      case _ => false
    })
      Id(text.substring(0, text.length).intern())
    else
      Id(text.intern())) at n
  }

  def buildLIT(id: Id, n: Token): Lit = {
    val text = n.getText
    val raw =
      (if (text.charAt(0) == '\'') RawLit(text.substring(1))
      else {
        val s =
          if (text.charAt(0) == '"') text.replaceAll("\"\"", "\"")
          else text.replaceAll("»»", "»")
        RawLit(s.substring(1, s.length - 1))
      }) at n
    val toExtern = Node.externTo(id.value)
    if (toExtern.isDefinedAt(raw.value)) {
      val lit = ExtLit(toExtern(raw.value))
      nodeLocMap.get(raw) match {
        case Some(li) =>
          nodeLocMap -= raw
          nodeLocMap(lit) = li
        case _ =>
      }
      lit
    } else raw
  }

  def build(ctx: ModelElementContext): ModelElement =
    ctx match {
      case ctx: GlobalVarContext => build(ctx.globalVarDecl())
      case ctx: ProcedureContext => build(ctx.procDecl())
    }

  def build(ctx: GlobalVarDeclContext): GlobalVarDecl =
    GlobalVarDecl(buildID(ctx.ID()), ctx.annotation().map(build)) at ctx

  def build(ctx: ProcDeclContext): ProcedureDecl =
    ProcedureDecl(
      buildID(ctx.ID()),
      Option(ctx.param()).map(_.map(build)).
        getOrElse(Node.emptySeq),
      Option(ctx.procBody()).map(build),
      ctx.annotation().map(build)
    ) at ctx

  def build(ctx: ParamContext): ParamDecl =
    ParamDecl(
      buildID(ctx.ID()),
      ctx.annotation().map(build)
    ) at ctx

  def build(ctx: ProcBodyContext): ProcedureBody =
    ProcedureBody(
      Option(ctx.localVarDecl).
        map(_.map(build)).getOrElse(Node.emptySeq),
      ctx.location().map(build)
    ) at ctx

  def build(ctx: LocalVarDeclContext): LocalVarDecl =
    LocalVarDecl(
      buildID(ctx.ID()),
      ctx.annotation().map(build)
    ) at ctx

  def build(ctx: LocationContext): Location =
    ctx.transformation() match {
      case ctxT: CallContext =>
        CallLocation(
          buildID(ctx.ID()),
          Option(ctxT.exp()).map(build),
          buildID(ctxT.p),
          Option(ctxT.arg().exp()).
            map(_.map(build)).getOrElse(Node.emptySeq),
          buildID(ctxT.l),
          ctx.annotation().map(build)
        ) at ctx
      case ctxT: BlockContext =>
        BlockLocation(
          buildID(ctx.ID()),
          ctxT.action().map(build),
          build(ctxT.jump()),
          ctx.annotation().map(build)
        ) at ctx
    }

  def build(ctx: ActionContext): Action =
    ctx match {
      case ctx: AssignActionContext => build(ctx)
      case ctx: AssertActionContext => build(ctx)
      case ctx: AssumeActionContext => build(ctx)
      case ctx: ExtActionContext => build(ctx)
    }

  def build(ctx: AssignActionContext): AssignAction =
    AssignAction(
      build(ctx.l),
      build(ctx.r),
      ctx.annotation().map(build)
    ) at ctx

  def build(ctx: AssertActionContext): AssertAction =
    AssertAction(
      build(ctx.exp()),
      ctx.annotation().map(build)
    ) at ctx

  def build(ctx: AssumeActionContext): AssumeAction =
    AssumeAction(
      build(ctx.exp()),
      ctx.annotation().map(build)
    ) at ctx

  def build(ctx: ExtActionContext): ExtAction =
    ExtAction(
      buildID(ctx.ID()),
      Option(ctx.arg().exp()).
        map(_.map(build)).getOrElse(Node.emptySeq),
      ctx.annotation().map(build)
    ) at ctx

  def build(ctx: JumpContext): Jump =
    ctx match {
      case ctx: GotoJumpContext => build(ctx)
      case ctx: IfJumpContext => build(ctx)
      case ctx: ReturnJumpContext => build(ctx)
      case ctx: SwitchJumpContext => build(ctx)
      case ctx: ExtJumpContext => build(ctx)
    }

  def build(ctx: GotoJumpContext): GotoJump =
    GotoJump(
      buildID(ctx.ID()),
      ctx.annotation().map(build)
    ) at ctx

  def build(ctx: IfJumpContext): IfJump =
    IfJump(
      build(ctx.exp()),
      buildID(ctx.t),
      buildID(ctx.f),
      ctx.annotation().map(build)
    ) at ctx

  def build(ctx: ReturnJumpContext): ReturnJump =
    ReturnJump(
      Option(ctx.exp()).map(build),
      ctx.annotation().map(build)
    ) at ctx

  def build(ctx: SwitchJumpContext): SwitchJump =
    SwitchJump(
      build(ctx.exp()),
      ctx.switchCase().map { ctxSC =>
        val (id, raw) = build(ctxSC.lit())
        val lit = LiteralExp(id, raw) at ctxSC.lit()
        SwitchCase(
          Some(lit),
          buildID(ctxSC.ID())
        ) at ctxSC
      } :+ {
        SwitchCase(None, buildID(ctx.ID())).at(ctx.b, ctx.ID())
      },
      ctx.annotation().map(build)
    ) at ctx

  def build(ctx: ExtJumpContext): ExtJump =
    ExtJump(
      buildID(ctx.ID()),
      Option(ctx.arg().exp()).
        map(_.map(build)).getOrElse(Node.emptySeq),
      ctx.annotation().map(build)
    ) at ctx

  def build(ctx: ExpContext): Exp = {
    var r = build(ctx.primArgs())
    if (ctx.expSuffix().nonEmpty) {
      val first = ctx.expSuffix(0)
      val op = buildID(first.ID())
      val right = build(first.primArgs())
      r = InfixExp(r, op, right,
        ctx.expSuffix().tail.map(ctxS =>
          (buildID(ctxS.ID()), build(ctxS.primArgs()))
        )) at ctx
    }
    r
  }

  def build(ctx: PrimArgsContext): Exp = {
    val start = ctx.start
    var r = build(ctx.prim())
    for (arg <- ctx.arg()) {
      r = ExtExp(r, Option(arg.exp()).map(_.map(build)).
        getOrElse(Node.emptySeq)).at(start, arg.stop)
    }
    r
  }

  def build(ctx: PrimContext): Exp =
    ctx match {
      case ctx: LitExpContext => build(ctx)
      case ctx: IdExpContext => build(ctx)
      case ctx: TupleExpContext => build(ctx)
    }

  def build(ctx: LitExpContext): LiteralExp = {
    val (id, raw) = build(ctx.lit())
    LiteralExp(id, raw) at ctx
  }

  def build(ctx: IdExpContext): IdExp =
    IdExp(buildID(ctx.ID())) at ctx

  def build(ctx: TupleExpContext): TupleExp =
    TupleExp(
      Option(ctx.exp()).map(_.map(build)).
        getOrElse(Node.emptySeq),
      ctx.annotation().map(build)
    ) at ctx


  import scala.language.implicitConversions

  @inline
  private implicit def toNodeSeq[T](ns: java.lang.Iterable[T]): Node.Seq[T] =
    Node.seq[T](scala.jdk.CollectionConverters.IterableHasAsScala(ns).asScala)

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
      Console.err.println(s"[$line, $column] $message")
      Console.err.flush()
    }
  }

  def apply(input: String,
            maxErrors: Natural = 0,
            reporter: Reporter = ConsoleReporter): Option[Model] = {
    class ParsingEscape extends RuntimeException

    import org.sireum.pilar.parser.Antlr4PilarLexer

    val inputStream = CharStreams.fromString(input)
    val lexer = new Antlr4PilarLexer(inputStream)
    val tokens = new CommonTokenStream(lexer)
    val parser = new Antlr4PilarParser(tokens)
    parser.getInterpreter.setPredictionMode(PredictionMode.SLL)
    parser.removeErrorListeners()
    val errorHandler = parser.getErrorHandler
    parser.setErrorHandler(new BailErrorStrategy())
    var success = true
    val mfOpt: Option[ModelFileContext] =
      try Some(parser.modelFile())
      catch {
        case _: ParseCancellationException =>
          tokens.seek(0)
          parser.reset()
          parser.getInterpreter.setPredictionMode(PredictionMode.LL)
          parser.setErrorHandler(errorHandler)
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
              reporter.error(line, charPositionInLine, start, msg + s" (token=${token.getType})")
              errors += 1
              if (maxErrors > 0 && errors >= maxErrors) {
                throw new ParsingEscape
              }
            }
          })
          try Some(parser.modelFile())
          catch {
            case _: ParsingEscape =>
              None
          }
      }
    if (success)
      mfOpt.map(mf => new Builder().build(mf.model()))
    else None
  }
}
