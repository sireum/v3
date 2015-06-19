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

import org.sireum.util._

object Internal {

  final val modelFieldNames = ivector("annotations", "elements")
  final val annotationFieldNames = ivector("id", "raw")
  final val idFieldNames = ivector("value", "isSimpleForm")
  final val rawFieldNames = ivector("value", "isSimple")
  final val globalVarDeclFieldNames = ivector("id", "annotations")
  final val procedureDeclFieldNames =
    ivector("id", "params", "bodyOpt", "annotations")
  final val paramDeclFieldNames = ivector("id", "annotations")
  final val procedureBodyFieldNames = ivector("locals", "locations")
  final val localVarDeclFieldNames = ivector("id", "annotations")
  final val callLocationFieldNames =
    ivector("label", "lhsOpt", "id", "args", "target", "annotations")
  final val blockLocationFieldNames =
    ivector("label", "actions", "jump", "annotations")
  final val assignActionFieldNames = ivector("lhs", "rhs", "annotations")
  final val assertActionFieldNames = ivector("exp", "annotations")
  final val assumeActionFieldNames = ivector("exp", "annotations")
  final val extActionFieldNames = ivector("id", "args", "annotations")
  final val gotoJumpFieldNames = ivector("target", "annotations")
  final val ifJumpFieldNames =
    ivector("exp", "tTarget", "fTarget", "annotations")
  final val returnJumpFieldNames = ivector("expOpt", "annotations")
  final val switchJumpFieldNames = ivector("exp", "cases", "annotations")
  final val switchCaseFieldNames = ivector("expOpt", "target")
  final val extJumpFieldNames = ivector("id", "args", "annotations")
  final val literalExpFieldNames = ivector("id", "raw")
  final val idExpFieldNames = ivector("id")
  final val tupleExpFieldNames = ivector("exps", "annotations")
  final val binaryExpFieldNames = ivector("left", "op", "right")
  final val callExpFieldNames = ivector("exp", "args")

  import Node._

  final def model(children: AnyRef*): Model = {
    val Seq(anns: NodeSeq[_], es: NodeSeq[_]) = children
    Model(cast(anns), cast(es))
  }

  final def annotation(children: AnyRef*): Annotation = {
    val Seq(id: Id, raw: Raw) = children
    Annotation(id, raw)
  }

  final def id(children: AnyRef*): Id = {
    val Seq(value: String, b: java.lang.Boolean) = children
    Id(value, b)
  }

  final def raw(children: AnyRef*): Raw = {
    val Seq(value: String, b: java.lang.Boolean) = children
    Raw(value, b)
  }

  final def globalVarDecl(children: AnyRef*): GlobalVarDecl = {
    val Seq(id: Id, anns: NodeSeq[_]) = children
    GlobalVarDecl(id, cast(anns))
  }

  final def procedureDecl(children: AnyRef*): ProcedureDecl = {
    val Seq(id: Id, ps: NodeSeq[_], anns: NodeSeq[_],
    bo: Option[_]) = children
    ProcedureDecl(id, cast(ps), cast(anns), cast(bo))
  }

  final def paramDecl(children: AnyRef*): ParamDecl = {
    val Seq(id: Id, anns: NodeSeq[_]) = children
    ParamDecl(id, cast(anns))
  }

  final def procedureBody(children: AnyRef*): ProcedureBody = {
    val Seq(ls: NodeSeq[_], locs: NodeSeq[_]) =
      children
    ProcedureBody(cast(ls), cast(locs))
  }

  final def localVarDecl(children: AnyRef*): LocalVarDecl = {
    val Seq(id: Id, anns: NodeSeq[_]) = children
    LocalVarDecl(id, cast(anns))
  }

  final def callLocation(children: AnyRef*): CallLocation = {
    val Seq(lbl: Id, l: Option[_], id: Id, args: NodeSeq[_],
    target: Id, anns: NodeSeq[_]) =
      children
    CallLocation(lbl, cast(l), id, cast(args), target, cast(anns))
  }

  final def blockLocation(children: AnyRef*): BlockLocation = {
    val Seq(lbl: Id, actions: NodeSeq[_], j: Jump, anns: NodeSeq[_]) =
      children
    BlockLocation(lbl, cast(actions), j, cast(anns))
  }

  final def assignAction(children: AnyRef*): AssignAction = {
    val Seq(l: Exp, r: Exp, anns: NodeSeq[_]) = children
    AssignAction(l, r, cast(anns))
  }

  final def assertAction(children: AnyRef*): AssertAction = {
    val Seq(e: Exp, anns: NodeSeq[_]) = children
    AssertAction(e, cast(anns))
  }

  final def assumeAction(children: AnyRef*): AssumeAction = {
    val Seq(e: Exp, anns: NodeSeq[_]) = children
    AssumeAction(e, cast(anns))
  }

  final def extAction(children: AnyRef*): ExtAction = {
    val Seq(id: Id, args: NodeSeq[_], anns: NodeSeq[_]) =
      children
    ExtAction(id, cast(args), cast(anns))
  }

  final def gotoJump(children: AnyRef*): GotoJump = {
    val Seq(t: Id, anns: NodeSeq[_]) = children
    GotoJump(t, cast(anns))
  }

  final def ifJump(children: AnyRef*): IfJump = {
    val Seq(e: Exp, t: Id, f: Id, anns: NodeSeq[_]) = children
    IfJump(e, t, f, cast(anns))
  }

  final def returnJump(children: AnyRef*): ReturnJump = {
    val Seq(eo: Option[_], anns: NodeSeq[_]) = children
    ReturnJump(cast(eo), cast(anns))
  }

  final def switchJump(children: AnyRef*): SwitchJump = {
    val Seq(e: Exp, cs: NodeSeq[_], anns: NodeSeq[_]) = children
    SwitchJump(e, cast(cs), cast(anns))
  }

  final def switchCase(children: AnyRef*): SwitchCase = {
    val Seq(eo: Option[_], t: Id) = children
    SwitchCase(cast(eo), t)
  }

  final def extJump(children: AnyRef*): ExtJump = {
    val Seq(id: Id, args: NodeSeq[_], anns: NodeSeq[_]) = children
    ExtJump(id, cast(args), cast(anns))
  }

  final def literalExp(children: AnyRef*): LiteralExp = {
    val Seq(id: Id, raw: Raw) = children
    LiteralExp(id, raw)
  }

  final def idExp(children: AnyRef*): IdExp = {
    val Seq(id: Id) = children
    IdExp(id)
  }

  final def tupleExp(children: AnyRef*): TupleExp = {
    val Seq(es: NodeSeq[_], anns: NodeSeq[_]) = children
    TupleExp(cast(es), cast(anns))
  }

  final def binaryExp(children: AnyRef*): BinaryExp = {
    val Seq(l: Exp, op: Id, r: Exp) = children
    BinaryExp(l, op, r)
  }

  final def callExp(children: AnyRef*): CallExp = {
    val Seq(e: Exp, args: NodeSeq[_]) = children
    CallExp(e, cast(args))
  }

  def registerConverters(json: Json): Unit = {
    import org.sireum.util.Json._
    json.register("Model", new CaseClassConverter {
      override val to: To = {
        case m: Model =>
          modelFieldNames.zip(ivector(
            fromSeq(m.annotations, json.fromCaseClass),
            fromSeq(m.elements, json.fromCaseClass)))
      }
      override val from: From = {
        case vs =>
          val Seq(anns, elements) = vs
          model(
            toVector[Annotation](anns, json.toCaseClass),
            toVector[ModelElement](elements, json.toCaseClass))
      }
    })
  }

  registerConverters(json)
}
