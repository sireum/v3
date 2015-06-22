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

package org.sireum.pilar.ast

import org.antlr.v4.runtime.{Token, ParserRuleContext}
import org.antlr.v4.runtime.tree.TerminalNode
import org.sireum.pilar.parser.PilarParser._
import org.sireum.util._

object Builder {

  trait Reporter {
    def error(line: PosInteger,
              column: PosInteger,
              offset: PosInteger,
              message: String): Unit
  }

  final def build(ctx: ModelContext)(
    implicit reporter: Reporter): Model =
    Model(
      ctx.annotation().map(build),
      ctx.modelElement().map(build)
    ) at ctx

  final def build(ctx: AnnotationContext): Annotation = {
    val (id, raw) = build(ctx.lit())
    Annotation(id, raw) at ctx
  }

  final def build(ctx: LitContext): (Id, Raw) =
    (buildID(ctx.ID()), buildLIT(ctx.LIT()))

  final def buildID(n: Token): Id = {
    val text = n.getText
    (if (text.charAt(0) == '\'')
      Id(text.substring(1, text.length), Id.Complex)
    else if (text.charAt(0) match {
      case '.' | '~' | '!' | '%' | '^' | '&' | '*' |
           '-' | '+' | '=' | '|' | '<' | '>' | '/' | '?' => true
      case _ => false
    })
      Id(text.substring(0, text.length), Id.Op)
    else
      Id(text, Id.Simple)) at n
  }

  final def buildLIT(n: Token): Raw = {
    val text = n.getText
    (if (text.charAt(0) == '\'') Raw(text.substring(1), simple = true)
    else Raw(text.substring(1, text.length - 1), simple = true)) at n
  }

  final def build(ctx: ModelElementContext)(
    implicit reporter: Reporter): ModelElement =
    ctx match {
      case ctx: GlobalVarContext => build(ctx.globalVarDecl())
      case ctx: ProcedureContext => build(ctx.procDecl())
    }

  final def build(ctx: GlobalVarDeclContext): GlobalVarDecl =
    GlobalVarDecl(buildID(ctx.ID()), ctx.annotation().map(build)) at ctx

  final def build(ctx: ProcDeclContext)(
    implicit reporter: Reporter): ProcedureDecl =
    ProcedureDecl(
      buildID(ctx.ID()),
      Option(ctx.param()).map(_.map(build)).
        getOrElse(Node.emptySeq),
      ctx.annotation().map(build),
      Option(ctx.procBody()).map(build)
    ) at ctx

  final def build(ctx: ParamContext): ParamDecl =
    ParamDecl(
      buildID(ctx.ID()),
      ctx.annotation().map(build)
    ) at ctx

  final def build(ctx: ProcBodyContext)(
    implicit reporter: Reporter): ProcedureBody =
    ProcedureBody(
      Option(ctx.localVarDecl).
        map(_.map(build)).getOrElse(Node.emptySeq),
      ctx.location().map(build)
    ) at ctx

  final def build(ctx: LocalVarDeclContext): LocalVarDecl =
    LocalVarDecl(
      buildID(ctx.ID()),
      ctx.annotation().map(build)
    ) at ctx

  final def build(ctx: LocationContext)(
    implicit reporter: Reporter): Location =
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

  final def build(ctx: ActionContext): Action =
    ctx match {
      case ctx: AssignActionContext => build(ctx)
      case ctx: AssertActionContext => build(ctx)
      case ctx: AssumeActionContext => build(ctx)
      case ctx: ExtActionContext => build(ctx)
    }

  final def build(ctx: AssignActionContext): AssignAction =
    AssignAction(
      build(ctx.l),
      build(ctx.r),
      ctx.annotation().map(build)
    ) at ctx

  final def build(ctx: AssertActionContext): AssertAction =
    AssertAction(
      build(ctx.exp()),
      ctx.annotation().map(build)
    ) at ctx

  final def build(ctx: AssumeActionContext): AssumeAction =
    AssumeAction(
      build(ctx.exp()),
      ctx.annotation().map(build)
    ) at ctx

  final def build(ctx: ExtActionContext): ExtAction =
    ExtAction(
      buildID(ctx.ID()),
      Option(ctx.arg().exp()).
        map(_.map(build)).getOrElse(Node.emptySeq),
      ctx.annotation().map(build)
    ) at ctx

  final def build(ctx: JumpContext)(
    implicit reporter: Reporter): Jump =
    ctx match {
      case ctx: GotoJumpContext => build(ctx)
      case ctx: IfJumpContext => build(ctx)
      case ctx: ReturnJumpContext => build(ctx)
      case ctx: SwitchJumpContext => build(ctx)
      case ctx: ExtJumpContext => build(ctx)
    }

  final def build(ctx: GotoJumpContext): GotoJump =
    GotoJump(
      buildID(ctx.ID()),
      ctx.annotation().map(build)
    ) at ctx

  final def build(ctx: IfJumpContext): IfJump =
    IfJump(
      build(ctx.exp()),
      buildID(ctx.t),
      buildID(ctx.f),
      ctx.annotation().map(build)
    ) at ctx

  final def build(ctx: ReturnJumpContext): ReturnJump =
    ReturnJump(
      Option(ctx.exp()).map(build),
      ctx.annotation().map(build)
    ) at ctx

  final def build(ctx: SwitchJumpContext)(
    implicit reporter: Reporter): SwitchJump =
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
        val u = buildID(ctx.u)
        if (u.value != "_") {
          val locInfo = u.locationInfoOpt.get
          reporter.error(locInfo.lineBegin, locInfo.columnBegin, locInfo.offset,
            s"Expecting: '_', but found: '${u.value}'")
        }
        SwitchCase(None, buildID(ctx.t)) at(ctx.b, ctx.t)
      },
      ctx.annotation().map(build)
    ) at ctx

  final def build(ctx: ExtJumpContext): ExtJump =
    ExtJump(
      buildID(ctx.ID()),
      Option(ctx.arg().exp()).
        map(_.map(build)).getOrElse(Node.emptySeq),
      ctx.annotation().map(build)
    ) at ctx

  final def build(ctx: ExpContext): Exp = {
    val start = ctx.start
    var r = build(ctx.primArgs())
    if (ctx.expSuffix().nonEmpty) {
      val first = ctx.expSuffix(0)
      val op = buildID(first.ID())
      var right = build(first.primArgs())
      r = BinaryExp(r, op, right,
        ctx.expSuffix().map(ctxS =>
          (buildID(ctxS.ID()), build(ctxS.primArgs()))
        )) at ctx
    }
    r
  }

  final def build(ctx: PrimArgsContext): Exp = {
    val start = ctx.start
    var r = build(ctx.prim())
    for (arg <- ctx.arg()) {
      r = CallExp(r, Option(arg.exp()).map(_.map(build)).
        getOrElse(Node.emptySeq)) at(start, arg.stop)
    }
    r
  }

  final def build(ctx: PrimContext): Exp =
    ctx match {
      case ctx: LitExpContext => build(ctx)
      case ctx: IdExpContext => build(ctx)
      case ctx: TupleExpContext => build(ctx)
    }

  final def build(ctx: LitExpContext): LiteralExp = {
    val (id, raw) = build(ctx.lit())
    LiteralExp(id, raw) at ctx
  }

  final def build(ctx: IdExpContext): IdExp =
    IdExp(buildID(ctx.ID())) at ctx

  final def build(ctx: TupleExpContext): TupleExp =
    TupleExp(
      Option(ctx.exp()).map(_.map(build)).
        getOrElse(Node.emptySeq),
      ctx.annotation().map(build)
    ) at ctx


  import scala.language.implicitConversions

  @inline
  private implicit def toNodeSeq[T](ns: java.lang.Iterable[T]): Node.Seq[T] =
    Node.seq[T](scala.collection.JavaConversions.iterableAsScalaIterable(ns))

  @inline
  private implicit def toToken(n: TerminalNode): Token = n.getSymbol

  private[ast] implicit class At[T <: Node](val n: T) extends AnyVal {
    def at(ctx: ParserRuleContext): T = {
      val start = ctx.getStart
      val stop = ctx.getStop
      val lb = stop.getLine
      val cb = stop.getCharPositionInLine
      val (le, ce) = end(lb, cb, stop.getText)
      n.locationInfoOpt = Some(LocationInfo(
        offset = start.getStartIndex,
        length = stop.getStopIndex - start.getStartIndex + 1,
        lineBegin = start.getLine,
        columnBegin = start.getCharPositionInLine,
        lineEnd = le,
        columnEnd = ce))
      n
    }

    @inline
    def at(t: Token): T = at(t, t)

    def at(start: Token, stop: Token): T = {
      val lb = stop.getLine
      val cb = stop.getCharPositionInLine
      val (le, ce) = end(lb, cb, stop.getText)
      n.locationInfoOpt = Some(LocationInfo(
        offset = start.getStartIndex,
        length = stop.getStopIndex - start.getStartIndex + 1,
        lineBegin = start.getLine,
        columnBegin = start.getCharPositionInLine,
        lineEnd = le,
        columnEnd = ce))
      n
    }

    @inline
    private def end(lineBegin: PosInteger,
                    columnBegin: PosInteger,
                    text: String): (PosInteger, PosInteger) = {
      val i = text.lastIndexOf('\n')
      if (i < 0)
        (lineBegin, columnBegin + text.length - 1)
      else {
        var lines = 0
        for (c <- text if c == '\n') lines += 1
        (lineBegin + lines, text.length - i - 3)
      }
    }
  }

}
