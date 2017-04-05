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

  object Enclosing extends Enumeration {
    type Type = Value
    val Top, Package, Object, ExtObject, Datatype, Record, Method = Value
  }

  case class Result(text: String,
                    hashLogika: Boolean,
                    programOpt: Option[AST.Program],
                    tags: ISeq[Tag])

  def apply(isWorksheet: Boolean,
            isDiet: Boolean,
            fileUriOpt: Option[FileResourceUri],
            text: String): Result = {
    val lines = text.lines
    val hashLogika = lines.hasNext && ("//#Logika" == lines.next.filterNot(_.isWhitespace))
    val dialect =
      if (isWorksheet) scala.meta.dialects.Scala212.copy(allowToplevelTerms = true)
      else scala.meta.dialects.Scala212
    dialect(text).parse[Source] match {
      case Parsed.Success(x) =>
        //println("Input: " + x.structure)
        new ScalaMetaParser(text, hashLogika, isDiet, fileUriOpt).translateSource(x)
      case pe: Parsed.Error =>
        Result(text, hashLogika, None, ivector(error(fileUriOpt, pe.pos, pe.message)))
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

  def isDollar(t: Term): Boolean = t match {
    case q"$$" => true
    case _ => false
  }
}

import ScalaMetaParser._

class ScalaMetaParser(text: String,
                      hashLogika: Boolean,
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
        stats match {
          case q"import org.sireum.logika._" :: rest =>
            val name = AST.Name(packageRef2IS(ref))
            Result(text, hashLogika,
              Some(AST.Program(
                fileUriOpt,
                name,
                AST.Block(ISZ(rest.map(translateStat(Enclosing.Package)): _*)))), tags)
          case _ =>
            errorInLogika(ref.pos, "The first member of packages should be 'import org.sireum.logika._'")
            Result(text, hashLogika, None, tags)
        }
      } else Result(text, hashLogika, None, tags)
    case q"import org.sireum.logika._" :: rest =>
      val shouldParse = fileUriOpt.forall(fileUri =>
        fileUri.endsWith(".logika") ||
          fileUri.endsWith(".sc") ||
          (hashLogika && fileUri.endsWith(".scala")))
      if (shouldParse)
        Result(text, hashLogika,
          Some(AST.Program(
            fileUriOpt,
            AST.Name(ISZ()),
            AST.Block(ISZ(rest.map(translateStat(Enclosing.Top)): _*)))), tags)
      else
        Result(text, hashLogika, None, tags)
    case Nil =>
      Result(text, hashLogika, Some(AST.Program(fileUriOpt, AST.Name(ISZ()), AST.Block(ISZ()))), tags)
    case stats =>
      if (hashLogika)
        errorInLogika(stats.head.pos, "The first statement should be either 'package <name>' or 'import org.sireum.logika._'")
      Result(text, hashLogika, None, tags)
  }

  def translateStat(enclosing: Enclosing.Type)(stat: Stat): AST.Stmt = stat match {
    case stat: Defn.Object => translateObject(enclosing, stat)
    case stat: Defn.Val => translateVal(enclosing, stat)
    case stat: Defn.Var => translateVar(enclosing, stat)
    case stat: Defn.Def => translateDef(enclosing, stat)
    case Term.Interpolate(Term.Name("l"), Seq(Lit(s: String)), Nil) => parseLogikaStmt(s)
    case _ =>
      val text = syntax(stat)
      errorNotLogika(stat.pos, s"Statement '$text' is")
      AST.ExpStmt(AST.NameExp(AST.Name(ISZ(AST.Id("$")))))
  }

  def translateObject(enclosing: Enclosing.Type, tree: Defn.Object): AST.Stmt = {
    val q"..$mods object $name extends { ..$estats } with ..$ctorcalls { ..$stats }" = tree
    var hasError = false
    var hasExt = false
    for (mod <- mods) mod match {
      case mod"@ext" =>
        if (hasExt) {
          hasError = true
          error(mods.head.pos, "Redundant @ext.")
        }
        hasExt = true
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
    if (!hasError) {
      val tstat = if (hasExt) translateStat(Enclosing.ExtObject) _ else translateStat(Enclosing.Object) _
      AST.ObjectStmt(cid(name), ISZ(stats.map(tstat): _*))
    } else AST.ObjectStmt(cid(name), ISZ())
  }

  def translateVal(enclosing: Enclosing.Type, stat: Defn.Val): AST.Stmt = {
    val q"..$mods val ..$patsnel: ${tpeopt: Option[Type]} = $expr" = stat
    lazy val er = AST.ExpStmt(AST.NameExp(AST.Name(ISZ(AST.Id("$")))))
    if (mods.nonEmpty || patsnel.size != 1 || !patsnel.head.isInstanceOf[Pat.Var.Term] || tpeopt.isEmpty) {
      errorInLogika(stat.pos, "Val declaration should have the form: 'val <id> : <type> = <exp>'")
      er
    } else if (enclosing != Enclosing.ExtObject && isDollar(expr)) {
      error(stat.pos, "'$' is only allowed in a Logika @ext object or @spec val/var expression.")
      er
    } else
      AST.VarStmt(isVal = true, cid(patsnel.head.asInstanceOf[Pat.Var.Term]),
        translateType(tpeopt.get), if (isDiet) None else Some(translateExp(expr)))
  }

  def translateVar(enclosing: Enclosing.Type, stat: Defn.Var): AST.Stmt = {
    val q"..$mods var ..$patsnel: ${tpeopt: Option[Type]} = ${expropt: Option[Term]}" = stat
    lazy val er = AST.ExpStmt(AST.NameExp(AST.Name(ISZ(AST.Id("$")))))
    if (mods.nonEmpty || patsnel.size != 1 || !patsnel.head.isInstanceOf[Pat.Var.Term] ||
      tpeopt.isEmpty || (expropt.isEmpty && enclosing != Enclosing.Method)) {
      errorInLogika(stat.pos, "Var declaration should have the form: 'var <id> : <type> = <exp>'")
      er
    } else if (enclosing != Enclosing.ExtObject && expropt.exists(isDollar)) {
      error(stat.pos, "'$' is only allowed in a Logika @ext object or @spec val/var expression.")
      er
    } else
      AST.VarStmt(isVal = false, cid(patsnel.head.asInstanceOf[Pat.Var.Term]),
        translateType(tpeopt.get), if (isDiet) None else expropt.map(translateExp))
  }

  def translateDef(enclosing: Enclosing.Type, tree: Defn.Def): AST.Stmt = {
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
    if (enclosing == Enclosing.ExtObject)
      exp match {
        case q"$$" =>
          AST.ExtMethodStmt(isPure, sig, AST.MethodContract(
            iszEmpty, iszEmpty, iszEmpty, iszEmpty, iszEmpty))
        case Term.Interpolate(Term.Name("c"), Seq(Lit(s: String)), Nil) =>
          AST.ExtMethodStmt(isPure, sig, parseContract(s))
        case _ =>
          hasError = true
          error(exp.pos, "Only '$' or 'c\"\"\"{ ... }\"\"\"' are allowed as Logika @ext object method expression.")
          AST.ExtMethodStmt(isPure, sig, AST.MethodContract(
            iszEmpty, iszEmpty, iszEmpty, iszEmpty, iszEmpty))
      }
    else if (isSpec)
      exp match {
        case q"$$" =>
          AST.SpecMethodStmt(sig, ISZ(), None)
        case Term.Interpolate(Term.Name("c"), Seq(Lit(s: String)), Nil) =>
          val (defs, where) = parseDefs(s)
          AST.SpecMethodStmt(sig, defs, where)
        case _ =>
          hasError = true
          error(exp.pos, "Only '$' or 'c\"\"\"{ ... }\"\"\"' is allowed as Logika @spec method expression.")
          AST.SpecMethodStmt(sig, ISZ(), None)
      }
    else exp match {
      case exp: Term.Block =>
        val (mc, blockOpt) = exp.stats.headOption match {
          case Some(Term.Interpolate(Term.Name("l"), Seq(Lit(s: String)), Nil)) =>
            (parseContract(s),
              if (isDiet) None
              else Some(AST.Block(ISZ(exp.stats.tail.map(translateStat(Enclosing.Method)): _*))))
          case _ =>
            (AST.MethodContract(iszEmpty, iszEmpty, iszEmpty, iszEmpty, iszEmpty),
              if (isDiet) None
              else Some(AST.Block(ISZ(exp.stats.map(translateStat(Enclosing.Method)): _*))))
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
    case t"(..$tpesnel)" =>
      AST.TupleType(ISZ(tpesnel.map(translateType): _*))
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

  def translateExp(exp: Term): AST.Exp = {
    // TODO: translate Exp
    AST.NameExp(AST.Name(ISZ(AST.Id("$"))))
  }

  def parseDefs(text: String): (ISZ[AST.SpecMethodDef], Option[AST.WhereClause]) = {
    // TODO: parse defs
    (ISZ(), None)
  }

  def parseContract(text: String): AST.MethodContract = {
    // TODO: parse contract
    AST.MethodContract(iszEmpty, iszEmpty, iszEmpty, iszEmpty, iszEmpty)
  }

  def parseLogikaStmt(text: String): AST.Stmt = {
    // TODO: parse logika stmt
    AST.ExpStmt(AST.NameExp(AST.Name(ISZ(AST.Id("$")))))
  }

  def cid(t: Pat.Var.Term): AST.Id = cid(t.name.value, t.pos)

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
      case q"$expr.$name" => f(expr) :+ cid(name)
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
    } + " ..."
  }
}
