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

import upickle.Js
import org.sireum.util.Json._

// This file is auto-generated from the Node class hierarchy

object Json {

  import scala.language.implicitConversions

  implicit def from(o: Node): Js.Obj =
    o match {
      case o: Annotation =>
        Js.Obj(
          (".class", Js.Str("Annotation")),
          ("id", from(o.id)),
          ("raw", from(o.raw))
        )
      case o: AssertAction =>
        Js.Obj(
          (".class", Js.Str("AssertAction")),
          ("exp", from(o.exp)),
          ("annotations", fromSeq(o.annotations)(from))
        )
      case o: AssignAction =>
        Js.Obj(
          (".class", Js.Str("AssignAction")),
          ("lhs", from(o.lhs)),
          ("rhs", from(o.rhs)),
          ("annotations", fromSeq(o.annotations)(from))
        )
      case o: AssumeAction =>
        Js.Obj(
          (".class", Js.Str("AssumeAction")),
          ("exp", from(o.exp)),
          ("annotations", fromSeq(o.annotations)(from))
        )
      case o: BlockLocation =>
        Js.Obj(
          (".class", Js.Str("BlockLocation")),
          ("label", from(o.label)),
          ("actions", fromSeq(o.actions)(from)),
          ("jump", from(o.jump)),
          ("annotations", fromSeq(o.annotations)(from))
        )
      case o: CallExp =>
        Js.Obj(
          (".class", Js.Str("CallExp")),
          ("exp", from(o.exp)),
          ("args", fromSeq(o.args)(from))
        )
      case o: CallLocation =>
        Js.Obj(
          (".class", Js.Str("CallLocation")),
          ("label", from(o.label)),
          ("lhsOpt", fromOption(o.lhsOpt)(from)),
          ("id", from(o.id)),
          ("args", fromSeq(o.args)(from)),
          ("target", from(o.target)),
          ("annotations", fromSeq(o.annotations)(from))
        )
      case o: ExtAction =>
        Js.Obj(
          (".class", Js.Str("ExtAction")),
          ("id", from(o.id)),
          ("args", fromSeq(o.args)(from)),
          ("annotations", fromSeq(o.annotations)(from))
        )
      case o: ExtJump =>
        Js.Obj(
          (".class", Js.Str("ExtJump")),
          ("id", from(o.id)),
          ("args", fromSeq(o.args)(from)),
          ("annotations", fromSeq(o.annotations)(from))
        )
      case o: GenBinaryExp =>
        Js.Obj(
          (".class", Js.Str("GenBinaryExp")),
          ("left", from(o.left)),
          ("op", from(o.op)),
          ("right", from(o.right)),
          ("rest", fromSeq(o.rest)(fromTuple2))
        )
      case o: GlobalVarDecl =>
        Js.Obj(
          (".class", Js.Str("GlobalVarDecl")),
          ("id", from(o.id)),
          ("annotations", fromSeq(o.annotations)(from))
        )
      case o: GotoJump =>
        Js.Obj(
          (".class", Js.Str("GotoJump")),
          ("target", from(o.target)),
          ("annotations", fromSeq(o.annotations)(from))
        )
      case o: Id =>
        Js.Obj(
          (".class", Js.Str("Id")),
          ("value", fromStr(o.value))
        )
      case o: IdExp =>
        Js.Obj(
          (".class", Js.Str("IdExp")),
          ("id", from(o.id))
        )
      case o: IfJump =>
        Js.Obj(
          (".class", Js.Str("IfJump")),
          ("exp", from(o.exp)),
          ("tTarget", from(o.tTarget)),
          ("fTarget", from(o.fTarget)),
          ("annotations", fromSeq(o.annotations)(from))
        )
      case o: LiteralExp =>
        Js.Obj(
          (".class", Js.Str("LiteralExp")),
          ("id", from(o.id)),
          ("raw", from(o.raw))
        )
      case o: LocalVarDecl =>
        Js.Obj(
          (".class", Js.Str("LocalVarDecl")),
          ("id", from(o.id)),
          ("annotations", fromSeq(o.annotations)(from))
        )
      case o: Model =>
        Js.Obj(
          (".class", Js.Str("Model")),
          ("elements", fromSeq(o.elements)(from)),
          ("annotations", fromSeq(o.annotations)(from))
        )
      case o: ParamDecl =>
        Js.Obj(
          (".class", Js.Str("ParamDecl")),
          ("id", from(o.id)),
          ("annotations", fromSeq(o.annotations)(from))
        )
      case o: ProcedureBody =>
        Js.Obj(
          (".class", Js.Str("ProcedureBody")),
          ("locals", fromSeq(o.locals)(from)),
          ("locations", fromSeq(o.locations)(from))
        )
      case o: ProcedureDecl =>
        Js.Obj(
          (".class", Js.Str("ProcedureDecl")),
          ("id", from(o.id)),
          ("params", fromSeq(o.params)(from)),
          ("bodyOpt", fromOption(o.bodyOpt)(from)),
          ("annotations", fromSeq(o.annotations)(from))
        )
      case o: Raw =>
        Js.Obj(
          (".class", Js.Str("Raw")),
          ("value", fromStr(o.value))
        )
      case o: ReturnJump =>
        Js.Obj(
          (".class", Js.Str("ReturnJump")),
          ("expOpt", fromOption(o.expOpt)(from)),
          ("annotations", fromSeq(o.annotations)(from))
        )
      case o: SwitchCase =>
        Js.Obj(
          (".class", Js.Str("SwitchCase")),
          ("expOpt", fromOption(o.expOpt)(from)),
          ("target", from(o.target))
        )
      case o: SwitchJump =>
        Js.Obj(
          (".class", Js.Str("SwitchJump")),
          ("exp", from(o.exp)),
          ("cases", fromSeq(o.cases)(from)),
          ("annotations", fromSeq(o.annotations)(from))
        )
      case o: TupleExp =>
        Js.Obj(
          (".class", Js.Str("TupleExp")),
          ("exps", fromSeq(o.exps)(from)),
          ("annotations", fromSeq(o.annotations)(from))
        )
    }

  implicit def to[T <: Node](v: Js.Value): T =
    (v: @unchecked) match {
      case o: Js.Obj =>
        (o.value.head._2.asInstanceOf[Js.Str].value match {
          case "Annotation" =>
            Annotation(to[Id](o.value(1)._2), to[Raw](o.value(2)._2))
          case "AssertAction" =>
            AssertAction(to[Exp](o.value(1)._2), toVector(o.value(2)._2)(to[Annotation]))
          case "AssignAction" =>
            AssignAction(to[Exp](o.value(1)._2), to[Exp](o.value(2)._2), toVector(o.value(3)._2)(to[Annotation]))
          case "AssumeAction" =>
            AssumeAction(to[Exp](o.value(1)._2), toVector(o.value(2)._2)(to[Annotation]))
          case "BlockLocation" =>
            BlockLocation(to[Id](o.value(1)._2), toVector(o.value(2)._2)(to[Action]), to[Jump](o.value(3)._2), toVector(o.value(4)._2)(to[Annotation]))
          case "CallExp" =>
            CallExp(to[Exp](o.value(1)._2), toVector(o.value(2)._2)(to[Exp]))
          case "CallLocation" =>
            CallLocation(to[Id](o.value(1)._2), toOption(o.value(2)._2)(to[Exp]), to[Id](o.value(3)._2), toVector(o.value(4)._2)(to[Exp]), to[Id](o.value(5)._2), toVector(o.value(6)._2)(to[Annotation]))
          case "ExtAction" =>
            ExtAction(to[Id](o.value(1)._2), toVector(o.value(2)._2)(to[Exp]), toVector(o.value(3)._2)(to[Annotation]))
          case "ExtJump" =>
            ExtJump(to[Id](o.value(1)._2), toVector(o.value(2)._2)(to[Exp]), toVector(o.value(3)._2)(to[Annotation]))
          case "GenBinaryExp" =>
            GenBinaryExp(to[Exp](o.value(1)._2), to[Id](o.value(2)._2), to[Exp](o.value(3)._2), toVector(o.value(4)._2)(toTuple2))
          case "GlobalVarDecl" =>
            GlobalVarDecl(to[Id](o.value(1)._2), toVector(o.value(2)._2)(to[Annotation]))
          case "GotoJump" =>
            GotoJump(to[Id](o.value(1)._2), toVector(o.value(2)._2)(to[Annotation]))
          case "Id" =>
            Id(toStr(o.value(1)._2))
          case "IdExp" =>
            IdExp(to[Id](o.value(1)._2))
          case "IfJump" =>
            IfJump(to[Exp](o.value(1)._2), to[Id](o.value(2)._2), to[Id](o.value(3)._2), toVector(o.value(4)._2)(to[Annotation]))
          case "LiteralExp" =>
            LiteralExp(to[Id](o.value(1)._2), to[Raw](o.value(2)._2))
          case "LocalVarDecl" =>
            LocalVarDecl(to[Id](o.value(1)._2), toVector(o.value(2)._2)(to[Annotation]))
          case "Model" =>
            Model(toVector(o.value(1)._2)(to[ModelElement]), toVector(o.value(2)._2)(to[Annotation]))
          case "ParamDecl" =>
            ParamDecl(to[Id](o.value(1)._2), toVector(o.value(2)._2)(to[Annotation]))
          case "ProcedureBody" =>
            ProcedureBody(toVector(o.value(1)._2)(to[LocalVarDecl]), toVector(o.value(2)._2)(to[Location]))
          case "ProcedureDecl" =>
            ProcedureDecl(to[Id](o.value(1)._2), toVector(o.value(2)._2)(to[ParamDecl]), toOption(o.value(3)._2)(to[ProcedureBody]), toVector(o.value(4)._2)(to[Annotation]))
          case "Raw" =>
            Raw(toStr(o.value(1)._2))
          case "ReturnJump" =>
            ReturnJump(toOption(o.value(1)._2)(to[Exp]), toVector(o.value(2)._2)(to[Annotation]))
          case "SwitchCase" =>
            SwitchCase(toOption(o.value(1)._2)(to[LiteralExp]), to[Id](o.value(2)._2))
          case "SwitchJump" =>
            SwitchJump(to[Exp](o.value(1)._2), toVector(o.value(2)._2)(to[SwitchCase]), toVector(o.value(3)._2)(to[Annotation]))
          case "TupleExp" =>
            TupleExp(toVector(o.value(1)._2)(to[Exp]), toVector(o.value(2)._2)(to[Annotation]))
        }).asInstanceOf[T]
    }
}
