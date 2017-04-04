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

  case class Result(hashLogika: Boolean,
                    program: Option[AST.Program],
                    tags: ISeq[Tag])

  def apply(isDiet: Boolean,
            fileUriOpt: Option[FileResourceUri],
            text: String): Result = {
    val lines = text.lines
    val hashLogika = lines.hasNext && ("//#Logika" == lines.next.filterNot(_.isWhitespace))
    text.parse[Source] match {
      case Parsed.Success(x) =>
        //println("Input: " + x.structure)
        new ScalaMetaParser(hashLogika, isDiet, fileUriOpt).translateSource(x)
      case pe: Parsed.Error =>
        Result(hashLogika, None, ivector(error(fileUriOpt, pe.pos, pe.message)))
    }
  }

  def error(fileUriOpt: Option[FileResourceUri],
            pos: Position,
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

class ScalaMetaParser(hashLogika: Boolean,
                      isDiet: Boolean,
                      fileUriOpt: Option[FileResourceUri]) {
  var tags: IVector[Tag] = ivectorEmpty

  def error(pos: Position,
            message: String): Unit = {
    tags +:= ScalaMetaParser.error(fileUriOpt, pos, message)
  }

  def iszEmpty[T]: ISZ[T] = ISZ()

  val unitType = AST.NamedType(AST.Name(ISZ(AST.Id("Unit"))), ISZ())

  def errorNotLogika(pos: Position, message: String): Unit =
    error(pos, message + " not in the Logika language.")

  def errorInLogika(pos: Position, message: String): Unit =
    error(pos, message + " in the Logika language.")

  def translateSource(source: Source): Result = source.stats match {
    case List(q"package $ref { ..$stats }") =>
      if (hashLogika) {
        val name = AST.Name(packageRef2IS(ref))
        Result(hashLogika,
          Some(AST.Program(
            fileUriOpt,
            name,
            AST.Block(ISZ(stats.map(translateStat(isExt = false)): _*)))), tags)
      } else Result(hashLogika, None, tags)
    case stats@(q"import org.sireum.logika._" :: _) =>
      val shouldParse = fileUriOpt.forall(fileUri =>
        fileUri.endsWith(".logika") ||
          fileUri.endsWith(".sc") ||
          (hashLogika && fileUri.endsWith(".scala")))
      if (shouldParse)
        Result(hashLogika,
          Some(AST.Program(
            fileUriOpt,
            AST.Name(ISZ()),
            AST.Block(ISZ(stats.map(translateStat(isExt = false)): _*)))), tags)
      else
        Result(hashLogika, None, tags)
    case stats =>
      if (hashLogika)
        Result(hashLogika,
          Some(AST.Program(
            fileUriOpt,
            AST.Name(ISZ()),
            AST.Block(ISZ(stats.map(translateStat(isExt = false)): _*)))), tags)
      else
        Result(hashLogika, None, tags)
  }

  def translateStat(isExt: Boolean)(stat: Stat): AST.Stmt = stat match {
    case stat: Defn.Object => translateObject(isExt, stat)
    case stat: Defn.Def => translateDef(isExt, stat)
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
      errorNotLogika(estats.head.pos, "Object early initializations are")
    }
    if (ctorcalls.nonEmpty) {
      hasError = true
      errorNotLogika(ctorcalls.head.pos, "Object super constructor calls are")
    }
    if (!hasError)
      AST.ObjectStmt(cid(name), ISZ(stats.map(translateStat(hasExt)): _*))
    else AST.ObjectStmt(cid(name), ISZ())
  }

  def translateDef(isExt: Boolean, tree: Defn.Def): AST.Stmt = {
    val q"..$mods def $name[..$tparams](...$paramss): ${tpeopt: Option[Type]} = $exp" = tree
    var hasError = false
    if (paramss.size > 1) {
      hasError = true
      errorNotLogika(name.pos, "Methods with multiple parameter tuples are")
    }
    if (tpeopt.isEmpty) {
      hasError = true
      errorInLogika(name.pos, "Methods have to be given explicit return type")
    }
    var isPure = false
    var isSpec = false
    for (mod <- mods) mod match {
      case mod"@pure" =>
        if (isPure) {
          hasError = true
          error(mod.pos, "Redundant @pure.")
        }
        isPure = true
      case mod"@spec" =>
        if (isSpec) {
          hasError = true
          error(mod.pos, "Redundant @spec.")
        }
        isSpec = true
      case _ =>
        hasError = true
        errorInLogika(mod.pos, s"Only either method modifier @pure or @spec is allowed")
    }
    if (isPure && isSpec) {
      hasError = true
      errorInLogika(mods.head.pos, s"Only either method modifier @pure or @spec is allowed")
    }
    val sig = AST.MethodSig(
      cid(name),
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
          error(exp.pos, "Only $ or c\"\"\"{ ... }\"\"\" is allowed as Logika @spec method expression.")
          AST.SpecMethodStmt(sig, ISZ())
      }
    else exp match {
      case exp: Term.Block =>
        val (mc, blockOpt) = exp.stats.headOption match {
          case Some(stat: Term.Interpolate) if stat.prefix.value == "l" =>
            (parseContract(stat),
              if (isDiet) None
              else Some(AST.Block(ISZ(exp.stats.tail.map(translateStat(isExt = false)): _*))))
          case _ =>
            (AST.MethodContract(iszEmpty, iszEmpty, iszEmpty, iszEmpty, iszEmpty),
              if (isDiet) None
              else Some(AST.Block(ISZ(exp.stats.map(translateStat(isExt = false)): _*))))
        }
        AST.MethodStmt(isPure, sig, mc, blockOpt)
      case _ =>
        errorInLogika(exp.pos, "Only block '{ ... }' is allowed for method definitions")
        AST.MethodStmt(isPure, sig, AST.MethodContract(iszEmpty, iszEmpty, iszEmpty, iszEmpty, iszEmpty), None)
    }
  }

  def translateTypeParam(tp: Type.Param): AST.TypeParam = tp match {
    case tparam"..$mods $tparamname[..$tparams] >: ${stpeopt: Option[Type]} <: ${tpeopt: Option[Type]} <% ..$tpes : ..$tpes2" =>
      if (mods.nonEmpty || tparams.nonEmpty || stpeopt.nonEmpty || tpes.nonEmpty || tpes2.nonEmpty)
        errorInLogika(tp.pos, "Only type parameters of the forms '<id>' or '<id> <: <type>' are supported")
      tpeopt match {
        case Some(tpe: Type) =>
          translateType(tpe) match {
            case t: AST.NamedType => AST.TypeParam(cid(tparamname), Some(t))
            case _ =>
              errorNotLogika(tpe.pos, s"Type parameter bound '${tpe.syntax}' is")
              AST.TypeParam(cid(tparamname), None)
          }
        case _ => AST.TypeParam(cid(tparamname), None)
      }
  }

  def translateParam(tp: Term.Param): AST.Param = {
    val param"..$mods $paramname: ${atpeopt: Option[Type.Arg]} = ${expropt: Option[Term]}" = tp
    if (mods.nonEmpty || atpeopt.isEmpty || expropt.nonEmpty)
      errorInLogika(tp.pos, "Parameters should have the form '<id> : <type>'")
    lazy val er = AST.Param(cid(paramname), unitType)
    atpeopt.map(ta => AST.Param(cid(paramname), translateTypeArg(ta))).getOrElse(er)
  }

  def translateTypeArg(ta: Type.Arg): AST.Type = ta match {
    case targ"${tpe: Type}" =>
      translateType(tpe)
    case _: Type.Arg.Repeated =>
      errorNotLogika(ta.pos, "Repeated types '<type>*' are")
      unitType
    case _: Type.Arg.ByName =>
      errorNotLogika(ta.pos, "By name types '=> <type>' are")
      unitType
  }

  def translateType(t: Type): AST.Type = t match {
    case t"${name: Type.Name}[..$tpesnel]" =>
      AST.NamedType(AST.Name(ISZ(cid(name))), ISZ(tpesnel.map(translateType): _*))
    case t"${name: Type.Name}" =>
      AST.NamedType(AST.Name(ISZ(cid(name))), ISZ())
    case t"$ref.$tname" =>
      def f(t: Term): ISZ[AST.Id] = t match {
        case q"$expr.$name" => f(expr) :+ cid(name)
        case q"${name: Term.Name}" => ISZ(cid(name))
        case _ =>
          errorInLogika(t.pos, s"Invalid type reference '${t.syntax}'")
          ISZ(AST.Id("$"))
      }
      AST.NamedType(AST.Name(f(ref) :+ cid(tname)), ISZ())
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

  def cid(name: Term.Name): AST.Id = cid(name.value, name.pos)

  def cid(name: Type.Param.Name): AST.Id = cid(name.value, name.pos)

  def cid(name: Term.Param.Name): AST.Id = cid(name.value, name.pos)

  def cid(id: String, pos: Position): AST.Id = {
    def isLetter(c: Char): Boolean = ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')
    def isLetterOrDigit(c: Char): Boolean = isLetter(c) || ('0' <= c && c <= '9')
    if (!(isLetter(id.head) && id.tail.forall(isLetterOrDigit)))
      errorInLogika(pos, s"'$id' is not a valid identifier form (i.e., [a-z,A-Z][a-z,A-Z,0-9]*)")
    AST.Id(id)
  }

  def packageRef2IS(ref: Term.Ref): ISZ[AST.Id] = {
    def f(t: Term): ISZ[AST.Id] = t match {
      case q"${name: Term.Name}" => ISZ(cid(name))
      case q"$expr.$name" =>  f(expr) :+ cid(name)
      case _ => errorInLogika(t.pos, s"Invalid package name '${ref.syntax}'")
        ISZ(AST.Id("$"))
    }
    f(ref)
  }

  def syntax(t: Tree, max: Int = 20): String = {
    val text = t.syntax
    (if (text.length < max) text else text.substring(0, max)).map {
      case '\r' => ' '
      case '\t' => ' '
      case '\n' => ' '
      case c => c
    }
  }
}
