/*
Copyright (c) 2019, Robby, Kansas State University
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

// @formatter:off
// This file was auto-generated from org.sireum.pilar.ast.Node

package org.sireum.pilar.ast

import org.sireum.util.Json._

object Json {
  type FromExtern = PartialFunction[Any, String]
  type ToExtern = PartialFunction[String, Any]

  final val externMap = scala.collection.mutable.Map[String, (FromExtern, ToExtern)]().withDefaultValue((Map(), Map()))

  import scala.language.implicitConversions

  implicit def fromNode(o: org.sireum.pilar.ast.Node): ujson.Obj =
    o match {
      case o: org.sireum.pilar.ast.Annotation =>
        ujson.Obj(
          (".class", ujson.Str("Annotation")),
          ("id", fromNode(o.id)),
          ("lit", fromNode(o.lit))
        )
      case o: org.sireum.pilar.ast.AssertAction =>
        ujson.Obj(
          (".class", ujson.Str("AssertAction")),
          ("exp", fromNode(o.exp)),
          ("annotations", fromSeq(o.annotations)(fromNode))
        )
      case o: org.sireum.pilar.ast.AssignAction =>
        ujson.Obj(
          (".class", ujson.Str("AssignAction")),
          ("lhs", fromNode(o.lhs)),
          ("rhs", fromNode(o.rhs)),
          ("annotations", fromSeq(o.annotations)(fromNode))
        )
      case o: org.sireum.pilar.ast.AssumeAction =>
        ujson.Obj(
          (".class", ujson.Str("AssumeAction")),
          ("exp", fromNode(o.exp)),
          ("annotations", fromSeq(o.annotations)(fromNode))
        )
      case o: org.sireum.pilar.ast.BlockLocation =>
        ujson.Obj(
          (".class", ujson.Str("BlockLocation")),
          ("label", fromNode(o.label)),
          ("actions", fromSeq(o.actions)(fromNode)),
          ("jump", fromNode(o.jump)),
          ("annotations", fromSeq(o.annotations)(fromNode))
        )
      case o: org.sireum.pilar.ast.CallLocation =>
        ujson.Obj(
          (".class", ujson.Str("CallLocation")),
          ("label", fromNode(o.label)),
          ("lhsOpt", fromOption(o.lhsOpt)(fromNode)),
          ("id", fromNode(o.id)),
          ("args", fromSeq(o.args)(fromNode)),
          ("target", fromNode(o.target)),
          ("annotations", fromSeq(o.annotations)(fromNode))
        )
      case o: org.sireum.pilar.ast.ExtAction =>
        ujson.Obj(
          (".class", ujson.Str("ExtAction")),
          ("id", fromNode(o.id)),
          ("args", fromSeq(o.args)(fromNode)),
          ("annotations", fromSeq(o.annotations)(fromNode))
        )
      case o: org.sireum.pilar.ast.ExtExp =>
        ujson.Obj(
          (".class", ujson.Str("ExtExp")),
          ("exp", fromNode(o.exp)),
          ("args", fromSeq(o.args)(fromNode))
        )
      case o: org.sireum.pilar.ast.ExtJump =>
        ujson.Obj(
          (".class", ujson.Str("ExtJump")),
          ("id", fromNode(o.id)),
          ("args", fromSeq(o.args)(fromNode)),
          ("annotations", fromSeq(o.annotations)(fromNode))
        )
      case o: org.sireum.pilar.ast.ExtLit =>
        ujson.Obj(
          (".class", ujson.Str("ExtLit")),
          ("value", fromStr(externMap("ExtLit")._1(o.value)))
        )
      case o: org.sireum.pilar.ast.GlobalVarDecl =>
        ujson.Obj(
          (".class", ujson.Str("GlobalVarDecl")),
          ("id", fromNode(o.id)),
          ("annotations", fromSeq(o.annotations)(fromNode))
        )
      case o: org.sireum.pilar.ast.GotoJump =>
        ujson.Obj(
          (".class", ujson.Str("GotoJump")),
          ("target", fromNode(o.target)),
          ("annotations", fromSeq(o.annotations)(fromNode))
        )
      case o: org.sireum.pilar.ast.IdExp =>
        ujson.Obj(
          (".class", ujson.Str("IdExp")),
          ("id", fromNode(o.id))
        )
      case o: org.sireum.pilar.ast.IfJump =>
        ujson.Obj(
          (".class", ujson.Str("IfJump")),
          ("exp", fromNode(o.exp)),
          ("tTarget", fromNode(o.tTarget)),
          ("fTarget", fromNode(o.fTarget)),
          ("annotations", fromSeq(o.annotations)(fromNode))
        )
      case o: org.sireum.pilar.ast.InfixExp =>
        ujson.Obj(
          (".class", ujson.Str("InfixExp")),
          ("left", fromNode(o.left)),
          ("op", fromNode(o.op)),
          ("right", fromNode(o.right)),
          ("rest", fromSeq(o.rest)(fromTuple2))
        )
      case o: org.sireum.pilar.ast.LiteralExp =>
        ujson.Obj(
          (".class", ujson.Str("LiteralExp")),
          ("id", fromNode(o.id)),
          ("lit", fromNode(o.lit))
        )
      case o: org.sireum.pilar.ast.LocalVarDecl =>
        ujson.Obj(
          (".class", ujson.Str("LocalVarDecl")),
          ("id", fromNode(o.id)),
          ("annotations", fromSeq(o.annotations)(fromNode))
        )
      case o: org.sireum.pilar.ast.Model =>
        ujson.Obj(
          (".class", ujson.Str("Model")),
          ("elements", fromSeq(o.elements)(fromNode)),
          ("annotations", fromSeq(o.annotations)(fromNode))
        )
      case o: org.sireum.pilar.ast.ParamDecl =>
        ujson.Obj(
          (".class", ujson.Str("ParamDecl")),
          ("id", fromNode(o.id)),
          ("annotations", fromSeq(o.annotations)(fromNode))
        )
      case o: org.sireum.pilar.ast.ProcedureBody =>
        ujson.Obj(
          (".class", ujson.Str("ProcedureBody")),
          ("locals", fromSeq(o.locals)(fromNode)),
          ("locations", fromSeq(o.locations)(fromNode))
        )
      case o: org.sireum.pilar.ast.ProcedureDecl =>
        ujson.Obj(
          (".class", ujson.Str("ProcedureDecl")),
          ("id", fromNode(o.id)),
          ("params", fromSeq(o.params)(fromNode)),
          ("bodyOpt", fromOption(o.bodyOpt)(fromNode)),
          ("annotations", fromSeq(o.annotations)(fromNode))
        )
      case o: org.sireum.pilar.ast.RawLit =>
        ujson.Obj(
          (".class", ujson.Str("RawLit")),
          ("value", fromStr(o.value))
        )
      case o: org.sireum.pilar.ast.ReturnJump =>
        ujson.Obj(
          (".class", ujson.Str("ReturnJump")),
          ("expOpt", fromOption(o.expOpt)(fromNode)),
          ("annotations", fromSeq(o.annotations)(fromNode))
        )
      case o: org.sireum.pilar.ast.SwitchCase =>
        ujson.Obj(
          (".class", ujson.Str("SwitchCase")),
          ("expOpt", fromOption(o.expOpt)(fromNode)),
          ("target", fromNode(o.target))
        )
      case o: org.sireum.pilar.ast.SwitchJump =>
        ujson.Obj(
          (".class", ujson.Str("SwitchJump")),
          ("exp", fromNode(o.exp)),
          ("cases", fromSeq(o.cases)(fromNode)),
          ("annotations", fromSeq(o.annotations)(fromNode))
        )
      case o: org.sireum.pilar.ast.TupleExp =>
        ujson.Obj(
          (".class", ujson.Str("TupleExp")),
          ("exps", fromSeq(o.exps)(fromNode)),
          ("annotations", fromSeq(o.annotations)(fromNode))
        )
      case o: org.sireum.pilar.ast._Id =>
        ujson.Obj(
          (".class", ujson.Str("_Id")),
          ("value", fromStr(o.value))
        )
    }

  implicit def toNode[T <: org.sireum.pilar.ast.Node](v: ujson.Value): T =
    (v: @unchecked) match {
      case o: ujson.Obj =>
        (o.value.head._2.asInstanceOf[ujson.Str].value match {
           case "Annotation" =>
             org.sireum.pilar.ast.Annotation(toNode[Id](o.value.toSeq(1)._2), toNode[Lit](o.value.toSeq(2)._2))
           case "AssertAction" =>
             org.sireum.pilar.ast.AssertAction(toNode[Exp](o.value.toSeq(1)._2), toVector(o.value.toSeq(2)._2)(toNode[Annotation]))
           case "AssignAction" =>
             org.sireum.pilar.ast.AssignAction(toNode[Exp](o.value.toSeq(1)._2), toNode[Exp](o.value.toSeq(2)._2), toVector(o.value.toSeq(3)._2)(toNode[Annotation]))
           case "AssumeAction" =>
             org.sireum.pilar.ast.AssumeAction(toNode[Exp](o.value.toSeq(1)._2), toVector(o.value.toSeq(2)._2)(toNode[Annotation]))
           case "BlockLocation" =>
             org.sireum.pilar.ast.BlockLocation(toNode[Id](o.value.toSeq(1)._2), toVector(o.value.toSeq(2)._2)(toNode[Action]), toNode[Jump](o.value.toSeq(3)._2), toVector(o.value.toSeq(4)._2)(toNode[Annotation]))
           case "CallLocation" =>
             org.sireum.pilar.ast.CallLocation(toNode[Id](o.value.toSeq(1)._2), toOption(o.value.toSeq(2)._2)(toNode[Exp]), toNode[Id](o.value.toSeq(3)._2), toVector(o.value.toSeq(4)._2)(toNode[Exp]), toNode[Id](o.value.toSeq(5)._2), toVector(o.value.toSeq(6)._2)(toNode[Annotation]))
           case "ExtAction" =>
             org.sireum.pilar.ast.ExtAction(toNode[Id](o.value.toSeq(1)._2), toVector(o.value.toSeq(2)._2)(toNode[Exp]), toVector(o.value.toSeq(3)._2)(toNode[Annotation]))
           case "ExtExp" =>
             org.sireum.pilar.ast.ExtExp(toNode[Exp](o.value.toSeq(1)._2), toVector(o.value.toSeq(2)._2)(toNode[Exp]))
           case "ExtJump" =>
             org.sireum.pilar.ast.ExtJump(toNode[Id](o.value.toSeq(1)._2), toVector(o.value.toSeq(2)._2)(toNode[Exp]), toVector(o.value.toSeq(3)._2)(toNode[Annotation]))
           case "ExtLit" =>
             org.sireum.pilar.ast.ExtLit(externMap("ExtLit")._2(toStr(o.value.toSeq(1)._2)))
           case "GlobalVarDecl" =>
             org.sireum.pilar.ast.GlobalVarDecl(toNode[Id](o.value.toSeq(1)._2), toVector(o.value.toSeq(2)._2)(toNode[Annotation]))
           case "GotoJump" =>
             org.sireum.pilar.ast.GotoJump(toNode[Id](o.value.toSeq(1)._2), toVector(o.value.toSeq(2)._2)(toNode[Annotation]))
           case "IdExp" =>
             org.sireum.pilar.ast.IdExp(toNode[Id](o.value.toSeq(1)._2))
           case "IfJump" =>
             org.sireum.pilar.ast.IfJump(toNode[Exp](o.value.toSeq(1)._2), toNode[Id](o.value.toSeq(2)._2), toNode[Id](o.value.toSeq(3)._2), toVector(o.value.toSeq(4)._2)(toNode[Annotation]))
           case "InfixExp" =>
             org.sireum.pilar.ast.InfixExp(toNode[Exp](o.value.toSeq(1)._2), toNode[Id](o.value.toSeq(2)._2), toNode[Exp](o.value.toSeq(3)._2), toVector(o.value.toSeq(4)._2)(toTuple2))
           case "LiteralExp" =>
             org.sireum.pilar.ast.LiteralExp(toNode[Id](o.value.toSeq(1)._2), toNode[Lit](o.value.toSeq(2)._2))
           case "LocalVarDecl" =>
             org.sireum.pilar.ast.LocalVarDecl(toNode[Id](o.value.toSeq(1)._2), toVector(o.value.toSeq(2)._2)(toNode[Annotation]))
           case "Model" =>
             org.sireum.pilar.ast.Model(toVector(o.value.toSeq(1)._2)(toNode[ModelElement]), toVector(o.value.toSeq(2)._2)(toNode[Annotation]))
           case "ParamDecl" =>
             org.sireum.pilar.ast.ParamDecl(toNode[Id](o.value.toSeq(1)._2), toVector(o.value.toSeq(2)._2)(toNode[Annotation]))
           case "ProcedureBody" =>
             org.sireum.pilar.ast.ProcedureBody(toVector(o.value.toSeq(1)._2)(toNode[LocalVarDecl]), toVector(o.value.toSeq(2)._2)(toNode[Location]))
           case "ProcedureDecl" =>
             org.sireum.pilar.ast.ProcedureDecl(toNode[Id](o.value.toSeq(1)._2), toVector(o.value.toSeq(2)._2)(toNode[ParamDecl]), toOption(o.value.toSeq(3)._2)(toNode[ProcedureBody]), toVector(o.value.toSeq(4)._2)(toNode[Annotation]))
           case "RawLit" =>
             org.sireum.pilar.ast.RawLit(toStr(o.value.toSeq(1)._2))
           case "ReturnJump" =>
             org.sireum.pilar.ast.ReturnJump(toOption(o.value.toSeq(1)._2)(toNode[Exp]), toVector(o.value.toSeq(2)._2)(toNode[Annotation]))
           case "SwitchCase" =>
             org.sireum.pilar.ast.SwitchCase(toOption(o.value.toSeq(1)._2)(toNode[LiteralExp]), toNode[Id](o.value.toSeq(2)._2))
           case "SwitchJump" =>
             org.sireum.pilar.ast.SwitchJump(toNode[Exp](o.value.toSeq(1)._2), toVector(o.value.toSeq(2)._2)(toNode[SwitchCase]), toVector(o.value.toSeq(3)._2)(toNode[Annotation]))
           case "TupleExp" =>
             org.sireum.pilar.ast.TupleExp(toVector(o.value.toSeq(1)._2)(toNode[Exp]), toVector(o.value.toSeq(2)._2)(toNode[Annotation]))
           case "_Id" =>
             org.sireum.pilar.ast._Id(toStrIntern(o.value.toSeq(1)._2))
         }).asInstanceOf[T]
    }
}