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


package org.sireum.x.logika.parser

import org.sireum.x.logika.{ast => AST}
import org.sireum.util._
import org.sireum.logika.{Z, IS, ISZ}
import scala.meta._

// TODO: remove asInstanceOf hack (due to IntelliJ's macro annotation inference workaround)
object ScalaMetaParser {

  case class Result(program: Option[AST.Program], tags: ISeq[Tag])

  def apply(fileUriOpt: Option[FileResourceUri],
            text: String): Result = {

    text.parse[scala.meta.Source] match {
      case Parsed.Success(x) =>
        println("Input: " + x.structure)
        new ScalaMetaParser(fileUriOpt).translateSource(x)
      case pe: Parsed.Error =>
        Result(None, ivector(error(fileUriOpt, pe.pos, pe.message)))
    }
  }

  def error(fileUriOpt: Option[FileResourceUri],
            pos: scala.meta.Position,
            message: String): Tag = {
    val posStart = pos.start
    val posEnd = pos.end
    LocationInfo(
      posStart.line + 1,
      posStart.column + 1,
      posEnd.line + 1,
      posEnd.column + 1,
      posStart.offset,
      posEnd.offset - posStart.offset).
      toLocationError(fileUriOpt, "Logika Parser", message)
  }
}

import ScalaMetaParser._

class ScalaMetaParser(fileUriOpt: Option[FileResourceUri]) {
  var tags: IVector[Tag] = ivectorEmpty

  def error(pos: scala.meta.Position,
            message: String): Unit = {
    tags +:= ScalaMetaParser.error(fileUriOpt, pos, message)
  }

  def iszEmpty[T]: ISZ[T] = ISZ()

  def errorNotLogika(pos: scala.meta.Position, message: String): Unit =
    error(pos, message + "not in the Logika language.")

  def errorInLogika(pos: scala.meta.Position, message: String): Unit =
    error(pos, message + "in the Logika language.")

  def translateSource(source: scala.meta.Source): Result = source.stats match {
    case List(q"package $ref { ..$stats }") =>
      val name = AST.Name(packageRef2IS(ref))
      Result(
        Some(AST.Program(
          fileUriOpt,
          name,
          AST.Block(ISZ(stats.flatMap(translateStat(isExt = false)): _*)))), tags)
    case q"import org.sireum.logika._" :: stats =>
      Result(
        Some(AST.Program(
          fileUriOpt,
          AST.Name(ISZ()),
          AST.Block(ISZ(stats.flatMap(translateStat(isExt = false)): _*)))), tags)
    case stats =>
      if (stats.nonEmpty)
        error(stats.head.pos, s"A Logika program should either start with 'package <name>' or 'import org.sireum.logika._'.")
      Result(None, tags)
  }

  def translateStat(isExt: Boolean)(stat: scala.meta.Stat): Option[AST.Stmt] = stat match {
    case q"..$mods object $name extends { ..$estats } with ..$ctorcalls { ..$stats }" =>
      var hasError = false
      var hasExt = false
      mods match {
        case mod"@ext" :: Nil => hasExt = true
        case Nil => // skip
        case _ =>
          hasError = true
          errorNotLogika(mods.head.pos, "Object modifiers other than @ext are")
      }
      if (estats.nonEmpty) {
        hasError = true
        errorNotLogika(mods.head.pos, "Object early initializations are")
      }
      if (ctorcalls.nonEmpty) {
        hasError = true
        errorNotLogika(mods.head.pos, "Object super constructor calls are")
      }
      if (!hasError)
        Some(AST.ObjectStmt(AST.Id(name.value), ISZ(stats.flatMap(translateStat(hasExt)): _*)))
      else None
    case q"..$mods def $name[..$tparams](...$paramss): $tpeopt = $exp" =>
      var hasError = false
      if (paramss.size > 1) {
        hasError = true
        errorNotLogika(mods.head.pos, "Methods with multiple parameter tuples are")
      }
      if (tpeopt.asInstanceOf[Option[scala.meta.Type]].isEmpty) {
        hasError = true
        errorInLogika(name.pos, "Methods have to be given explicit return type")
      }
      var isPure = false
      var isSpec = false
      for (mod <- mods) mod match {
        case mod"@pure" => isPure = true
        case mod"@spec" => isSpec = true
        case _ =>
          hasError = true
          errorInLogika(mod.pos, s"Only method modifiers @pure and @spec are allowed")
      }
      val sig = AST.MethodSig(
        AST.Id(name.value),
        ISZ(tparams.map(translateTypeParam): _*),
        ISZ(paramss.headOption.getOrElse(ivectorEmpty).map(translateParam): _*),
        translateType(tpeopt.asInstanceOf[Option[scala.meta.Type]].get))
      if (isExt) {
        exp match {
          case Term.Name("$") =>
            Some(AST.ExtMethodStmt(isPure, sig, AST.MethodContract(
              iszEmpty, iszEmpty, iszEmpty, iszEmpty, iszEmpty)))
          case exp: Term.Interpolate if exp.prefix.value == "c" =>
            ???
          case _ =>
            hasError = true
            error(exp.pos, "Only $ or c\"\"\"{ ... }\"\"\" are allowed as Logika @ext object method expression.")
            None
        }
      } else if (isSpec) {
        exp match {
          case exp: Term.Interpolate if exp.prefix.value == "c" =>
            ???
          case _ =>
            hasError = true
            error(exp.pos, "Only c\"\"\"{ ... }\"\"\" is allowed as Logika @spec method expression.")
            None
        }
      } else {
        ???
      }
  }

  def translateTypeParam(tp: scala.meta.Type.Param): AST.TypeParam = tp match {
    case tparam"..$mods $tparamname[..$tparams] >: $stpeopt <: $tpeopt <% ..$tpes : ..$tpes2" =>
      if (mods.nonEmpty || tparams.nonEmpty ||
        stpeopt.asInstanceOf[Option[scala.meta.Type]].nonEmpty || tpes.nonEmpty || tpes2.nonEmpty)
        errorInLogika(tp.pos, "Only type parameters of the forms '<id>' or '<id> <: <type>' are supported")
      tpeopt.asInstanceOf[Option[scala.meta.Type]] match {
        case Some(tpe) =>
          translateType(tpe) match {
            case t: AST.NamedType => AST.TypeParam(AST.Id(tparamname.value), Some(t))
            case _ =>
              errorNotLogika(tpe.pos, s"Type parameter bound '${tpe.syntax}' is")
              AST.TypeParam(AST.Id(tparamname.value), None)
          }
        case _ => AST.TypeParam(AST.Id(tparamname.value), None)
      }
  }

  def translateParam(tp: scala.meta.Term.Param): AST.Param = ???

  def translateType(t: scala.meta.Type): AST.Type = ???

  def packageRef2IS(ref: Term.Ref): IS[Z, AST.Id] =
    ISZ(ref.toString.split(".").map(AST.Id): _*)
}
