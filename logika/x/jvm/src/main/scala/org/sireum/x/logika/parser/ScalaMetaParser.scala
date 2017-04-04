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
import org.sireum.logika.ISZ
import scala.meta._

// TODO: clean up quasiquotes due to IntelliJ's macro annotation inference workaround
object ScalaMetaParser {

  case class Result(program: Option[AST.Program], tags: ISeq[Tag])

  def apply(isDiet: Boolean,
            fileUriOpt: Option[FileResourceUri],
            text: String): Result = {
    val lines = text.lines
    val isLogika = lines.nonEmpty && ("//#Logika" == lines.next.filterNot(_.isWhitespace))
    text.parse[scala.meta.Source] match {
      case Parsed.Success(x) =>
        println("Input: " + x.structure)
        new ScalaMetaParser(isLogika, isDiet, fileUriOpt).translateSource(x)
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

class ScalaMetaParser(isLogika: Boolean,
                      isDiet: Boolean,
                      fileUriOpt: Option[FileResourceUri]) {
  var tags: IVector[Tag] = ivectorEmpty

  def error(pos: scala.meta.Position,
            message: String): Unit = {
    tags +:= ScalaMetaParser.error(fileUriOpt, pos, message)
  }

  def iszEmpty[T]: ISZ[T] = ISZ()

  val unitType = AST.NamedType(AST.Name(ISZ(AST.Id("Unit"))), ISZ())

  def errorNotLogika(pos: scala.meta.Position, message: String): Unit =
    error(pos, message + "not in the Logika language.")

  def errorInLogika(pos: scala.meta.Position, message: String): Unit =
    error(pos, message + "in the Logika language.")

  def translateSource(source: scala.meta.Source): Result = source.stats match {
    case List(q"package $ref { ..$stats }") =>
      if (isLogika) {
        val name = AST.Name(packageRef2IS(ref))
        Result(
          Some(AST.Program(
            fileUriOpt,
            name,
            AST.Block(ISZ(stats.map(translateStat(isExt = false)): _*)))), tags)
      } else Result(None, tags)
    case stats@(q"import org.sireum.logika._" :: _) =>
      val shouldParse = fileUriOpt.forall(fileUri =>
        fileUri.endsWith(".logika") ||
          fileUri.endsWith(".sc") ||
          (isLogika && fileUri.endsWith(".scala")))
      if (shouldParse)
        Result(
          Some(AST.Program(
            fileUriOpt,
            AST.Name(ISZ()),
            AST.Block(ISZ(stats.map(translateStat(isExt = false)): _*)))), tags)
      else
        Result(None, tags)
    case stats =>
      if (isLogika) {
        Result(
          Some(AST.Program(
            fileUriOpt,
            AST.Name(ISZ()),
            AST.Block(ISZ(stats.map(translateStat(isExt = false)): _*)))), tags)
      } else {
        if (stats.nonEmpty)
          error(stats.head.pos, s"A Logika program should either start with 'package <name>' or 'import org.sireum.logika._'.")
        Result(None, tags)
      }
  }

  def translateStat(isExt: Boolean)(stat: scala.meta.Stat): AST.Stmt = stat match {
    case stat: scala.meta.Defn.Object => translateObject(isExt, stat)
    case stat: scala.meta.Defn.Def => translateDef(isExt, stat)
    case _ =>
      val text = syntax(stat)
      errorNotLogika(stat.pos, s"Statement '$text' is")
      AST.ExpStmt(AST.NameExp(AST.Name(ISZ(AST.Id("$")))))
  }

  def translateObject(isExt: Boolean, tree: Defn.Object): AST.Stmt = {
    val q"..$mods object $name extends { ..$estats } with ..$ctorcalls { ..$stats }" = tree
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
      AST.ObjectStmt(AST.Id(name.value), ISZ(stats.map(translateStat(hasExt)): _*))
    else AST.ObjectStmt(AST.Id(name.value), ISZ())
  }

  def translateDef(isExt: Boolean, tree: Defn.Def): AST.Stmt = {
    val q"..$mods def $name[..$tparams](...$paramss): ${tpeopt: Option[scala.meta.Type]} = $exp" = tree
    var hasError = false
    if (paramss.size > 1) {
      hasError = true
      errorNotLogika(mods.head.pos, "Methods with multiple parameter tuples are")
    }
    if (tpeopt.isEmpty) {
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
      tpeopt.map(translateType).getOrElse(unitType))
    if (isExt)
      exp match {
        case Term.Name("$") =>
          AST.ExtMethodStmt(isPure, sig, AST.MethodContract(
            iszEmpty, iszEmpty, iszEmpty, iszEmpty, iszEmpty))
        case exp: Term.Interpolate if exp.prefix.value == "c" =>
          AST.ExtMethodStmt(isPure, sig, parseContract(exp))
        case _ =>
          hasError = true
          error(exp.pos, "Only $ or c\"\"\"{ ... }\"\"\" are allowed as Logika @ext object method expression.")
          AST.ExtMethodStmt(isPure, sig, AST.MethodContract(
            iszEmpty, iszEmpty, iszEmpty, iszEmpty, iszEmpty))
      }
    else if (isSpec)
      exp match {
        case Term.Name("$") =>
          AST.SpecMethodStmt(sig, ISZ())
        case exp: Term.Interpolate if exp.prefix.value == "c" =>
          AST.SpecMethodStmt(sig, parseDefs(exp))
        case _ =>
          hasError = true
          error(exp.pos, "Only c\"\"\"{ ... }\"\"\" is allowed as Logika @spec method expression.")
          AST.SpecMethodStmt(sig, ISZ())
      }
    else exp match {
      case exp: scala.meta.Term.Block =>
        val (mc, stats) = exp.stats.headOption match {
          case Some(stat: Term.Interpolate) if stat.prefix.value == "l" =>
            (parseContract(stat), if (isDiet) ivectorEmpty else exp.stats.tail)
          case _ =>
            (AST.MethodContract(iszEmpty, iszEmpty, iszEmpty, iszEmpty, iszEmpty),
              if (isDiet) ivectorEmpty else exp.stats)
        }
        AST.MethodStmt(isPure, sig, mc, AST.Block(ISZ(stats.map(translateStat(isExt = false)): _*)))
      case _ =>
        errorInLogika(exp.pos, "Only block '{ ... }' is allowed for method definitions")
        AST.MethodStmt(isPure, sig, AST.MethodContract(iszEmpty, iszEmpty, iszEmpty, iszEmpty, iszEmpty), AST.Block(ISZ()))
    }
  }

  def translateTypeParam(tp: scala.meta.Type.Param): AST.TypeParam = tp match {
    case tparam"..$mods $tparamname[..$tparams] >: ${stpeopt: Option[scala.meta.Type]} <: ${tpeopt: Option[scala.meta.Type]} <% ..$tpes : ..$tpes2" =>
      if (mods.nonEmpty || tparams.nonEmpty || stpeopt.nonEmpty || tpes.nonEmpty || tpes2.nonEmpty)
        errorInLogika(tp.pos, "Only type parameters of the forms '<id>' or '<id> <: <type>' are supported")
      tpeopt match {
        case Some(tpe: scala.meta.Type) =>
          translateType(tpe) match {
            case t: AST.NamedType => AST.TypeParam(AST.Id(tparamname.value), Some(t))
            case _ =>
              errorNotLogika(tpe.pos, s"Type parameter bound '${tpe.syntax}' is")
              AST.TypeParam(AST.Id(tparamname.value), None)
          }
        case _ => AST.TypeParam(AST.Id(tparamname.value), None)
      }
  }

  def translateParam(tp: scala.meta.Term.Param): AST.Param = {
    val param"..$mods $paramname: ${atpeopt: Option[scala.meta.Type.Arg]} = ${expropt: Option[scala.meta.Term]}" = tp
    if (mods.nonEmpty || atpeopt.isEmpty || expropt.nonEmpty)
      errorInLogika(tp.pos, "Parameters should have the form '<id> : <type>'")
    lazy val er = AST.Param(AST.Id(paramname.value), unitType)
    atpeopt.map(ta => AST.Param(AST.Id(paramname.value), translateTypeArg(ta))).getOrElse(er)
  }

  def translateTypeArg(ta: scala.meta.Type.Arg): AST.Type = ta match {
    case targ"${tpe: Type}" =>
      translateType(tpe)
    case _: scala.meta.Type.Arg.Repeated =>
      errorNotLogika(ta.pos, "Repeated types '<type>*' are")
      unitType
    case _: scala.meta.Type.Arg.ByName =>
      errorNotLogika(ta.pos, "By name types '=> <type>' are")
      unitType
  }

  def translateType(t: scala.meta.Type): AST.Type = t match {
    case t"${name: Type.Name}[..$tpesnel]" =>
      AST.NamedType(AST.Name(typeName2IS(name)), ISZ(tpesnel.map(translateType): _*))
    case t"${name: Type.Name}" =>
      AST.NamedType(AST.Name(typeName2IS(name)), ISZ())
    case t"(..$atpes) => $tpe" =>
      AST.FunType(ISZ(atpes.map(translateTypeArg): _*), translateType(tpe))
    case _ =>
      errorNotLogika(t.pos, s"Type '${syntax(t)}' is")
      unitType
  }

  def parseDefs(defs: Term.Interpolate): ISZ[AST.SpecMethodDef] = {
    // TODO: parse defs
    ISZ()
  }

  def parseContract(c: Term.Interpolate): AST.MethodContract = {
    // TODO: parse contract
    AST.MethodContract(iszEmpty, iszEmpty, iszEmpty, iszEmpty, iszEmpty)
  }

  def typeName2IS(name: Type.Name): ISZ[AST.Id] =
    ISZ(name.value.split(".").map(AST.Id): _*)

  def packageRef2IS(ref: Term.Ref): ISZ[AST.Id] =
    ISZ(ref.toString.split(".").map(AST.Id): _*)

  def syntax(t: scala.meta.Tree, max: Int = 20): String = {
    val text = t.syntax
    (if (text.length < max) text else text.substring(0, max)).
      replaceAllLiterally("\r", " ").
      replaceAllLiterally("\n", " ").
      replaceAllLiterally("\t", " ") + " ..."
  }
}
