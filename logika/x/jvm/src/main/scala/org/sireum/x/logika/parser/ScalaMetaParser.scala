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
import org.sireum.logika.{option, some, none, ISZ}
import scala.meta._

// TODO: clean up quasiquotes due to IntelliJ's macro annotation inference workaround
object ScalaMetaParser {

  object Enclosing extends Enumeration {
    type Type = Value
    val Top, Package, Object, ExtObject, DatatypeTrait, DatatypeClass, RecordTrait, RecordClass, Method = Value
  }

  case class Result(text: String,
                    hashLogika: Boolean,
                    programOpt: Option[AST.Program],
                    tags: ISeq[Tag])

  def apply(isWorksheet: Boolean,
            isDiet: Boolean,
            fileUriOpt: Option[FileResourceUri],
            text: String): Result =
    apply(allowLogikaPackage = false, isWorksheet, isDiet, fileUriOpt, text)

  private[logika] def apply(allowLogikaPackage: Boolean,
                            isWorksheet: Boolean,
                            isDiet: Boolean,
                            fileUriOpt: Option[FileResourceUri],
                            text: String): Result = {
    val lines = text.trim.lines
    val line = if (lines.hasNext) lines.next.filterNot(_.isWhitespace) else ""
    val hashLogika = "//#Logika" == line
    val dialect =
      if (isWorksheet) scala.meta.dialects.Scala212.copy(allowToplevelTerms = true)
      else scala.meta.dialects.Scala212
    dialect(text).parse[Source] match {
      case Parsed.Success(x) =>
        //println("Input: " + x.structure)
        new ScalaMetaParser(text, allowLogikaPackage, hashLogika,
          isWorksheet, isDiet, fileUriOpt).translateSource(x)
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
                      allowLogikaPackage: Boolean,
                      hashLogika: Boolean,
                      isWorksheet: Boolean,
                      isDiet: Boolean,
                      fileUriOpt: Option[FileResourceUri]) {
  var tags: IVector[Tag] = ivectorEmpty

  def error(pos: Position,
            message: String): Unit = {
    tags :+= ScalaMetaParser.error(fileUriOpt, pos, message)
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
        if (ref.syntax == "org.sireum.logika") {
          if (allowLogikaPackage)
            Result(text, hashLogika,
              Some(AST.Program(
                fileUriOpt,
                name,
                AST.Block(ISZ(stats.map(translateStat(Enclosing.Package)): _*)))), tags)
          else {
            errorInLogika(ref.pos, "Cannot define members of the org.sireum.logika package")
            Result(text, hashLogika, None, tags)
          }
        } else stats match {
          case q"import org.sireum.logika._" :: rest =>
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

  def translateStat(enclosing: Enclosing.Type)(stat: Stat): AST.Stmt = {
    lazy val er = AST.ExpStmt(AST.NameExp(AST.Name(ISZ(AST.Id("$")))))
    stat match {
      case stat: Defn.Val => translateVal(enclosing, stat)
      case stat: Defn.Var => translateVar(enclosing, stat)
      case stat: Defn.Def => translateDef(enclosing, stat)
      case stat: Defn.Object => translateObject(enclosing, stat)
      case stat: Defn.Trait if stat.mods.exists({
        case mod"@datatype" => true
        case _ => false
      }) => translateDatatype(enclosing, stat)
      case stat: Defn.Class if stat.mods.exists({
        case mod"@datatype" => true
        case _ => false
      }) => translateDatatype(enclosing, stat)
      case stat: Defn.Class if stat.mods.exists({
        case mod"@record" => true
        case _ => false
      }) => translateRecord(enclosing, stat)
      case Term.Interpolate(Term.Name("l"), Seq(l@Lit(s: String)), Nil) => parseLogikaStmt(enclosing, l.pos, s)
      case stat: Term.Apply => er // TODO
      case stat: Term.Assign => er // TODO
      case stat: Term.Update => er // TODO
      case stat: Term.If =>
        var hasError = false
        if (!stat.thenp.isInstanceOf[Term.Block]) {
          errorInLogika(stat.thenp.pos, "If-then part should be a block '{ ... }'")
          hasError = true
        }
        if (!(stat.elsep.isInstanceOf[Term.Block] || stat.elsep.isInstanceOf[Term.If])) {
          errorInLogika(stat.thenp.pos, "If-else part should be either a block '{ ... }' or another if-conditional.")
          hasError = true
        }
        if (hasError) er else er // TODO
      case stat: Term.Match => er // TODO
      case stat: Term.While =>
        if (!stat.body.isInstanceOf[Term.Block]) {
          errorInLogika(stat.body.pos, "While-loop body should be a block '{ ... }'")
          er
        } else er // TODO
      case stat: Term.Do =>
        if (!stat.body.isInstanceOf[Term.Block]) {
          errorInLogika(stat.body.pos, "Do-while-loop body should be a block '{ ... }'")
          er
        } else er // TODO
      case stat: Term.For =>
        var hasError = false
        if (!stat.body.isInstanceOf[Term.Block]) {
          errorInLogika(stat.body.pos, "For-loop body should be a block '{ ... }'")
          hasError = true
        }
        if (hasError) er else er // TODO
      case _ =>
        errorNotLogika(stat.pos, s"Statement '${syntax(stat)}' is")
        er
    }
  }

  def translateVal(enclosing: Enclosing.Type, stat: Defn.Val): AST.Stmt = {
    var hasError = false
    enclosing match {
      case Enclosing.Top | Enclosing.Object | Enclosing.ExtObject | Enclosing.Method =>
      case _ =>
        hasError = true
        errorInLogika(stat.pos, "Val declarations can only appear at the top-level, inside objects, or methods")
    }
    val q"..$mods val ..$patsnel: ${tpeopt: Option[Type]} = $expr" = stat
    var hasSpec = false
    for (mod <- mods) mod match {
      case mod"@spec" =>
        if (hasSpec) {
          hasError = true
          error(mod.pos, "Redundant @spec.")
        }
        hasSpec = true
      case _ =>
        hasError = true
        error(mod.pos, "Only the @spec modifier is allowed for val declarations.")
    }
    if (patsnel.size != 1 || !patsnel.head.isInstanceOf[Pat.Var.Term] || tpeopt.isEmpty) {
      hasError = true
      if (hasSpec)
        errorInLogika(stat.pos, "@spec val declaration should have the form: '@spec val <id> : <type> = $'")
      else
        errorInLogika(stat.pos, "Val declaration should have the form: 'val <id> : <type> = <exp>'")
    } else if (!(hasSpec || enclosing == Enclosing.ExtObject) && isDollar(expr)) {
      hasError = true
      error(stat.pos, "'$' is only allowed in a Logika @ext object or @spec val/var expression.")
    } else if (hasSpec && !isDollar(expr)) {
      hasError = true
      errorInLogika(stat.pos, "@spec val declaration should have the form: '@spec val <id> : <type> = $'")
    }
    if (hasError) AST.ExpStmt(AST.NameExp(AST.Name(ISZ(AST.Id("$")))))
    else if (hasSpec)
      AST.SpecVarStmt(isVal = true, cid(patsnel.head.asInstanceOf[Pat.Var.Term]), translateType(tpeopt.get))
    else
      AST.VarStmt(isVal = true, cid(patsnel.head.asInstanceOf[Pat.Var.Term]),
        translateType(tpeopt.get), if (isDiet) None else Some(translateExp(expr)))
  }

  def translateVar(enclosing: Enclosing.Type, stat: Defn.Var): AST.Stmt = {
    var hasError = false
    enclosing match {
      case Enclosing.Top | Enclosing.Object | Enclosing.ExtObject | Enclosing.Method =>
      case _ =>
        hasError = true
        errorInLogika(stat.pos, "Var declarations can only appear at the top-level, inside objects, or methods")
    }
    val q"..$mods var ..$patsnel: ${tpeopt: Option[Type]} = ${expropt: Option[Term]}" = stat
    var hasSpec = false
    for (mod <- mods) mod match {
      case mod"@spec" =>
        if (hasSpec) {
          hasError = true
          error(mod.pos, "Redundant @spec.")
        }
        hasSpec = true
      case _ =>
        hasError = true
        error(mod.pos, "Only the @spec modifier is allowed for var declarations.")
    }
    val isDollarExpr = expropt.map(isDollar).getOrElse(false)
    if (patsnel.size != 1 || !patsnel.head.isInstanceOf[Pat.Var.Term] || tpeopt.isEmpty) {
      hasError = true
      if (hasSpec)
        errorInLogika(stat.pos, "@spec var declaration should have the form: '@spec var <id> : <type> = $'")
      else
        errorInLogika(stat.pos, "Var declaration should have the form: 'var <id> : <type> = <exp>'")
    } else if (!(hasSpec || enclosing == Enclosing.ExtObject) && isDollarExpr) {
      hasError = true
      error(stat.pos, "'$' is only allowed in a Logika @ext object or @spec val/var expression.")
    } else if (hasSpec && !isDollarExpr) {
      hasError = true
      errorInLogika(stat.pos, "@spec var declaration should have the form: '@spec var <id> : <type> = $'")
    } else if (expropt.isEmpty && enclosing != Enclosing.Method) {
      hasError = true
      errorInLogika(stat.pos, "Uninitialized '_' var declarations are only allowed inside methods")
    }

    if (hasError) AST.ExpStmt(AST.NameExp(AST.Name(ISZ(AST.Id("$")))))
    else if (hasSpec)
      AST.SpecVarStmt(isVal = false, cid(patsnel.head.asInstanceOf[Pat.Var.Term]), translateType(tpeopt.get))
    else
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
      paramss.isEmpty,
      ISZ(paramss.headOption.getOrElse(ivectorEmpty).map(translateParam): _*),
      tpeopt.map(translateType).getOrElse(unitType))
    if (enclosing == Enclosing.ExtObject)
      exp match {
        case q"$$" =>
          AST.ExtMethodStmt(isPure, sig, AST.MethodContract(
            iszEmpty, iszEmpty, iszEmpty, iszEmpty, iszEmpty))
        case Term.Interpolate(Term.Name("c"), Seq(l@Lit(s: String)), Nil) =>
          AST.ExtMethodStmt(isPure, sig, parseContract(l.pos, s))
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
        case Term.Interpolate(Term.Name("c"), Seq(l@Lit(s: String)), Nil) =>
          val (defs, where) = parseDefs(l.pos, s)
          AST.SpecMethodStmt(sig, defs, where)
        case _ =>
          hasError = true
          error(exp.pos, "Only '$' or 'c\"\"\"{ ... }\"\"\"' is allowed as Logika @spec method expression.")
          AST.SpecMethodStmt(sig, ISZ(), None)
      }
    else exp match {
      case exp: Term.Block =>
        val (mc, blockOpt) = exp.stats.headOption match {
          case Some(Term.Interpolate(Term.Name("l"), Seq(l@Lit(s: String)), Nil)) =>
            (parseContract(l.pos, s),
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

  def translateObject(enclosing: Enclosing.Type, stat: Defn.Object): AST.Stmt = {
    var hasError = false
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        hasError = true
        errorInLogika(stat.pos, "Object declarations can only appear at the top-level, package-level, or inside other objects")
    }
    val q"..$mods object $name extends { ..$estats } with ..$ctorcalls { ..$stats }" = stat
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
      AST.ObjectStmt(hasExt, cid(name), ISZ(stats.map(tstat): _*))
    } else AST.ObjectStmt(hasExt, cid(name), ISZ())
  }

  def translateDatatype(enclosing: Enclosing.Type, stat: Defn.Trait): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        errorInLogika(stat.pos, "Trait declarations can only appear at the top-level, package-level, or inside other objects")
    }
    val q"..$mods trait $tname[..$tparams] extends { ..$estats } with ..$ctorcalls { $param => ..$stats }" = stat
    if (estats.nonEmpty || ctorcalls.nonEmpty || !param.name.isInstanceOf[Name.Anonymous])
      error(tname.pos, "Logika @datatype traits have to be of the form '@datatype trait <id> { ... }'.")
    var hasDatatype = false
    for (mod <- mods) mod match {
      case mod"@datatype" =>
        if (hasDatatype) {
          error(mod.pos, "Redundant @datatype.")
        }
        hasDatatype = true
      case _ =>
        error(mod.pos, "Logika @datatype traits have to be of the form '@datatype trait <id> { ... }'.")
    }
    AST.CompositeStmt(isRoot = true,
      isDatatype = true,
      cid(tname),
      None,
      ISZ(),
      ISZ(stats.map(translateStat(Enclosing.DatatypeTrait)): _*))
  }

  def translateDatatype(enclosing: Enclosing.Type, stat: Defn.Class): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        errorInLogika(stat.pos, "@datatype class declarations can only appear at the top-level, package-level, or inside other objects")
    }
    val q"..$mods class $tname[..$tparams] ..$ctorMods (...$paramss) extends { ..$estats } with ..$ctorcalls { $param => ..$stats }" = stat
    if (ctorMods.nonEmpty || paramss.size > 1 || estats.nonEmpty ||
      ctorcalls.size > 1 || !param.name.isInstanceOf[Name.Anonymous]) {
      error(tname.pos, "Logika @datatype classes have to be of the form '@datatype class <id>(...) { ... }'.")
    }
    var hasDatatype = false
    for (mod <- mods) mod match {
      case mod"@datatype" =>
        if (hasDatatype) {
          error(mod.pos, "Redundant @datatype.")
        }
        hasDatatype = true
      case _ =>
        error(mod.pos, "Logika @datatype classes have to be of the form '@datatype class <id>(...) { ... }'.")
    }
    val params = ISZ(paramss.flatMap(_.map(translateCompositeParam(isDatatype = true))): _*)
    AST.CompositeStmt(isRoot = false,
      isDatatype = true,
      cid(tname),
      ctorcalls.headOption.map(translateCtorCall),
      params,
      ISZ(stats.map(translateStat(Enclosing.DatatypeClass)): _*))
  }

  def translateRecord(enclosing: Enclosing.Type, stat: Defn.Trait): AST.Stmt = {
    val q"..$mods trait $tname[..$tparams] extends { ..$estats } with ..$ctorcalls { $param => ..$stats }" = stat
    if (estats.nonEmpty || ctorcalls.nonEmpty || !param.name.isInstanceOf[Name.Anonymous])
      error(tname.pos, "Logika @record traits have to be of the form '@record trait <id> { ... }'.")
    var hasRecord = false
    for (mod <- mods) mod match {
      case mod"@record" =>
        if (hasRecord) {
          error(mod.pos, "Redundant @record.")
        }
        hasRecord = true
      case _ =>
        error(mod.pos, "Logika @record classes have to be of the form '@record class <id>(...) { ... }'.")
    }
    AST.CompositeStmt(isRoot = true,
      isDatatype = false,
      cid(tname),
      None,
      ISZ(),
      ISZ(stats.map(translateStat(Enclosing.RecordTrait)): _*))
  }

  def translateRecord(enclosing: Enclosing.Type, stat: Defn.Class): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        errorInLogika(stat.pos, "@datatype class declarations can only appear at the top-level, package-level, or inside other objects")
    }
    val q"..$mods class $tname[..$tparams] ..$ctorMods (...$paramss) extends { ..$estats } with ..$ctorcalls { $param => ..$stats }" = stat
    if (ctorMods.nonEmpty || paramss.size > 1 || estats.nonEmpty ||
      ctorcalls.size > 1 || !param.name.isInstanceOf[Name.Anonymous]) {
      error(tname.pos, "Logika @record classes have to be of the form '@record class <id>(...) { ... }'.")
    }
    var hasRecord = false
    for (mod <- mods) mod match {
      case mod"@record" =>
        if (hasRecord) {
          error(mod.pos, "Redundant @record.")
        }
        hasRecord = true
      case _ =>
        error(tname.pos, "Logika @record classes have to be of the form '@record class <id>(...) { ... }'.")
    }
    val params = ISZ(paramss.flatMap(_.map(translateCompositeParam(isDatatype = false))): _*)
    AST.CompositeStmt(isRoot = false,
      isDatatype = false,
      cid(tname),
      ctorcalls.headOption.map(translateCtorCall),
      params,
      ISZ(stats.map(translateStat(Enclosing.RecordClass)): _*))
  }

  def translateCtorCall(cc: Ctor.Call): AST.Type = {
    def f(t: Term): ISZ[AST.Id] = t match {
      case ctor"${ctorname: Ctor.Name}" => ISZ(cid(ctorname))
      case ctor"$ref.$ctorname" => f(ref) :+ cid(ctorname)
      case q"${name: Term.Name}" => ISZ(cid(name))
      case q"$expr.$name" => f(expr) :+ cid(name)
    }

    cc match {
      case ctor"$ctorref[..$atpesnel]" => AST.NamedType(AST.Name(f(ctorref)), ISZ(atpesnel.map(translateType): _*))
      case _ => AST.NamedType(AST.Name(f(cc)), ISZ())
    }
  }

  def translateCompositeParam(isDatatype: Boolean)(tp: Term.Param): AST.CompositeParam = {
    val param"..$mods $paramname: ${atpeopt: Option[Type.Arg]} = ${expropt: Option[Term]}" = tp
    var hasError = true
    var hasHidden = false
    var isVar = false
    for (mod <- mods) mod match {
      case mod"@hidden" =>
        if (hasHidden) {
          hasError = true
          error(mod.pos, "Redundant @hidden.")
        }
        hasHidden = true
      case mod"varparam" if isDatatype => isVar = true
      case _ =>
        hasError = true
        if (isDatatype) error(mod.pos, s"Unallowed modifier '${syntax(mod)}' for a Logika @datatype class.")
        else error(mod.pos, s"Unallowed modifier '${syntax(mod)}' for a Logika @record class.")
    }
    if (atpeopt.isEmpty || expropt.nonEmpty) {
      hasError = true
      if (hasHidden) errorInLogika(tp.pos, "Parameters should have the form '@hidden <id> : <type>'")
      else errorInLogika(tp.pos, "Parameters should have the form '<id> : <type>'")
    }
    if (hasError) AST.CompositeParam(hasHidden, cid(paramname), unitType)
    else AST.CompositeParam(hasHidden, cid(paramname), translateTypeArg(atpeopt.get))
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
    lazy val er = AST.NameExp(AST.Name(ISZ(AST.Id("$"))))
    exp match {
      case exp: Term.Name => er // TODO
      case exp: Term.Select => er // TODO
      case exp: Term.Apply => er // TODO
      case exp: Term.ApplyInfix => er // TODO
      case exp: Term.ApplyUnary => er // TODO
      case exp: Term.Tuple => er // TODO
      case exp: Term.If =>
        var hasError = false
        if (exp.thenp.isInstanceOf[Term.Block]) {
          hasError = true
          errorInLogika(exp.thenp.pos, "If-then expression should not be a block '{ ... }'")
        }
        if (exp.elsep.isInstanceOf[Term.Block]) {
          hasError = true
          errorInLogika(exp.thenp.pos, "If-else expression should not be a block '{ ... }'")
        }
        if (hasError) er
        else er // TODO
      case exp: Term.Eta => er // TODO
      case exp: Term.Interpolate => er // TODO
      case exp: Lit => er // TODO
      case _ =>
        errorNotLogika(exp.pos, s"Expresion '${syntax(exp)}' is")
        er
    }
  }

  def parseDefs(pos: Position, text: String): (ISZ[AST.SpecMethodDef], Option[AST.WhereClause]) = {
    // TODO: parse defs
    (ISZ(), None)
  }

  def parseContract(pos: Position, text: String): AST.MethodContract = {
    // TODO: parse contract
    AST.MethodContract(iszEmpty, iszEmpty, iszEmpty, iszEmpty, iszEmpty)
  }

  def parseLogikaStmt(enclosing: Enclosing.Type, pos: Position, text: String): AST.Stmt = {
    // TODO: parse logika stmt
    AST.ExpStmt(AST.NameExp(AST.Name(ISZ(AST.Id("$")))))
  }

  def cid(t: Pat.Var.Term): AST.Id = cid(t.name.value, t.pos)

  def cid(name: Term.Name): AST.Id = cid(name.value, name.pos)

  def cid(name: Ctor.Name): AST.Id = cid(name.value, name.pos)

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

  import scala.language.implicitConversions

  implicit def opt[T](opt: Option[T]): option[T] = opt match {
    case Some(x) => new some(x)
    case _ => new none()
  }
}
