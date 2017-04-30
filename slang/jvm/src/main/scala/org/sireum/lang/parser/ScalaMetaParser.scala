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


package org.sireum.lang.parser

import org.sireum.lang.{ast => AST}
import org.sireum.util._
import org.sireum.{Option, Some, None, ISZ}
import scala.meta._

// TODO: clean up quasiquotes due to IntelliJ's macro annotation inference workaround
object ScalaMetaParser {

  object Enclosing extends Enumeration {
    type Type = Value
    val Top, Package, Object, ExtObject, DatatypeTrait, DatatypeClass, RecordTrait, RecordClass, Sig, RichClass, Method, Block = Value
  }

  case class Result(text: String,
                    hashSireum: Boolean,
                    programOpt: Option[AST.TopUnit.Program],
                    tags: ISZ[Tag])

  def apply(isWorksheet: Boolean,
            isDiet: Boolean,
            fileUriOpt: scala.Option[FileResourceUri],
            text: String): Result =
    apply(allowSireumPackage = false, isWorksheet, isDiet, fileUriOpt, text)

  private[sireum] def apply(allowSireumPackage: Boolean,
                            isWorksheet: Boolean,
                            isDiet: Boolean,
                            fileUriOpt: scala.Option[FileResourceUri],
                            text: String): Result = {
    val lines = text.trim.lines
    val line = if (lines.hasNext) lines.next.filterNot(_.isWhitespace) else ""
    val hashSireum = line.contains("#Sireum")
    val dialect =
      if (isWorksheet) scala.meta.dialects.Scala212.copy(
        allowToplevelTerms = true, allowLiteralTypes = true, allowTrailingCommas = true)
      else scala.meta.dialects.Scala212.copy(
        allowLiteralTypes = true, allowTrailingCommas = true)
    dialect(text).parse[Source] match {
      case Parsed.Success(x) =>
        //println("Input: " + x.structure)
        new ScalaMetaParser(text, allowSireumPackage, hashSireum,
          isWorksheet, isDiet, fileUriOpt).translateSource(x)
      case pe: Parsed.Error =>
        Result(text, hashSireum, None(), ISZ(error(fileUriOpt, pe.pos, pe.message)))
    }
  }

  def error(fileUriOpt: scala.Option[FileResourceUri],
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
      toLocationError(fileUriOpt, "Slang Parser", message)
  }

  def isDollar(t: Term): Boolean = t match {
    case q"$$" => true
    case _ => false
  }

  private[ScalaMetaParser] lazy val rExp = AST.Exp.Ident(AST.Id("$"))
  private[ScalaMetaParser] lazy val rStmt = AST.Stmt.Expr(rExp)
}

import ScalaMetaParser._

class ScalaMetaParser(text: String,
                      allowSireumPackage: Boolean,
                      hashSireum: Boolean,
                      isWorksheet: Boolean,
                      isDiet: Boolean,
                      fileUriOpt: scala.Option[FileResourceUri]) {
  var tags: ISZ[Tag] = ISZ()

  def error(pos: Position,
            message: String): Unit = {
    tags :+= ScalaMetaParser.error(fileUriOpt, pos, message)
  }

  def iszEmpty[T]: ISZ[T] = ISZ()

  val unitType = AST.Type.Named(AST.Name(ISZ(AST.Id("Unit"))), ISZ())

  def errorNotSlang(pos: Position, message: String): Unit =
    error(pos, message + " not in Slang.")

  def errorInSlang(pos: Position, message: String): Unit =
    error(pos, message + " in Slang.")

  def translateSource(source: Source): Result = {
    def topF(rest: List[Stat]): Result = {
      val shouldParse = fileUriOpt.forall(fileUri =>
        fileUri.endsWith(".logika") ||
          fileUri.endsWith(".sc") ||
          (hashSireum && fileUri.endsWith(".scala")))
      if (shouldParse)
        Result(text, hashSireum,
          Some(AST.TopUnit.Program(
            opt(fileUriOpt),
            AST.Name(ISZ()),
            AST.Body(ISZ(rest.map(translateStat(Enclosing.Top)): _*)))), tags)
      else
        Result(text, hashSireum, None(), tags)
    }

    source.stats match {
      case List(q"package $ref { ..$stats }") =>
        if (hashSireum) {
          val name = AST.Name(packageRef2IS(ref))
          val refSyntax = ref.syntax
          if (refSyntax == "org.sireum" || refSyntax.startsWith("org.sireum.")) {
            if (allowSireumPackage)
              Result(text, hashSireum,
                Some(AST.TopUnit.Program(
                  opt(fileUriOpt),
                  name,
                  AST.Body(ISZ(stats.map(translateStat(Enclosing.Package)): _*)))), tags)
            else {
              errorInSlang(ref.pos, s"Cannot define members of the $refSyntax package")
              Result(text, hashSireum, None(), tags)
            }
          } else {
            def packageF(rest: List[Stat]) = Result(text, hashSireum,
              Some(AST.TopUnit.Program(
                opt(fileUriOpt),
                name,
                AST.Body(ISZ(rest.map(translateStat(Enclosing.Package)): _*)))), tags)

            stats match {
              case q"import org.sireum._" :: rest => packageF(rest)
              case q"import org.sireum.logika._" :: rest => packageF(rest)
              case _ =>
                errorInSlang(ref.pos, "The first member of packages should be 'import org.sireum._'")
                Result(text, hashSireum, None(), tags)
            }
          }
        } else Result(text, hashSireum, None(), tags)
      case q"import org.sireum._" :: rest => topF(rest)
      case q"import org.sireum.logika._" :: rest => topF(rest)
      case Nil =>
        Result(text, hashSireum, Some(AST.TopUnit.Program(opt(fileUriOpt), AST.Name(ISZ()), AST.Body(ISZ()))), tags)
      case stats =>
        if (hashSireum)
          errorInSlang(stats.head.pos, "The first statement should be either 'package <name>' or 'import org.sireum._'")
        Result(text, hashSireum, None(), tags)
    }
  }

  def translateStat(enclosing: Enclosing.Type)(stat: Stat): AST.Stmt = {
    stat match {
      case stat: Import => translateImport(enclosing, stat)
      case stat: Defn.Val => translateVal(enclosing, stat)
      case stat: Defn.Var => translateVar(enclosing, stat)
      case stat: Decl.Def => translateDef(enclosing, stat)
      case stat: Defn.Def => translateDef(enclosing, stat)
      case stat: Defn.Object if stat.mods.exists({
        case mod"@enum" => true
        case _ => false
      }) => translateEnum(enclosing, stat)
      case stat: Defn.Object => translateObject(enclosing, stat)
      case stat: Defn.Trait if stat.mods.exists({
        case mod"@sig" => true
        case _ => false
      }) => translateSig(enclosing, stat)
      case stat: Defn.Trait if stat.mods.exists({
        case mod"@datatype" => true
        case _ => false
      }) => translateDatatype(enclosing, stat)
      case stat: Defn.Class if stat.mods.exists({
        case mod"@datatype" => true
        case _ => false
      }) => translateDatatype(enclosing, stat)
      case stat: Defn.Trait if stat.mods.exists({
        case mod"@record" => true
        case _ => false
      }) => translateRecord(enclosing, stat)
      case stat: Defn.Class if stat.mods.exists({
        case mod"@record" => true
        case _ => false
      }) => translateRecord(enclosing, stat)
      case stat: Decl.Type => translateTypeAlias(enclosing, stat)
      case stat: Term.Apply => AST.Stmt.Expr(translateExp(stat))
      case stat: Term.Assign => rStmt // TODO
      case stat: Term.Block => translateBlock(enclosing, stat)
      case stat: Term.Update => rStmt // TODO
      case stat: Term.If => translateIfStmt(enclosing, stat)
      case stat: Term.Match => rStmt // TODO
      case stat: Term.While => translateWhile(enclosing, stat)
      case stat: Term.Do => translateDoWhile(enclosing, stat)
      case stat: Term.For => translateFor(enclosing, stat)
      case Term.Interpolate(Term.Name("l"), Seq(l@Lit(s: String)), Nil) => parseLStmt(enclosing, l.pos, s)
      case _ =>
        errorNotSlang(stat.pos, s"Statement '${syntax(stat)}' is")
        rStmt
    }
  }

  def translateImport(enclosing: Enclosing.Type,
                      stat: Import): AST.Stmt = stat.importers match {
    case Seq(Importer(ref: Term.Name, Seq(Importee.Wildcard()))) =>
      AST.Stmt.RichImport(cid(ref))
    case _ =>
      var importers = ISZ[AST.Stmt.Import.Importer]()
      for (importer <- stat.importers) {
        val ref = packageRef2IS(importer.ref)
        val name = AST.Name(ref)
        var sels = ISZ[AST.Stmt.Import.Selector]()
        for (importee <- importer.importees) importee match {
          case importee"$finame => $tiname" =>
            sels +:= AST.Stmt.Import.Selector(cid(finame), cid(tiname))
          case importee"${iname: Name.Indeterminate}" =>
            val id = cid(iname)
            sels +:= AST.Stmt.Import.Selector(id, id)
          case _ => errorNotSlang(importee.pos, s"Importee '${importee.syntax}' from ${importer.ref.syntax} is")
        }
        importers +:= AST.Stmt.Import.Importer(name, sels)
      }
      AST.Stmt.Import(importers)
  }

  def translateVal(enclosing: Enclosing.Type, stat: Defn.Val): AST.Stmt = {
    var hasError = false
    enclosing match {
      case Enclosing.Top | Enclosing.Object | Enclosing.ExtObject | Enclosing.DatatypeClass | Enclosing.RecordClass | Enclosing.RichClass | Enclosing.Method | Enclosing.Block =>
      case _ =>
        hasError = true
        if (isWorksheet) errorInSlang(stat.pos, "Val declarations can only appear at the top-level, inside objects, classes, methods, or code blocks")
        else errorInSlang(stat.pos, "Val declarations can only appear inside objects, classes, methods, or code blocks")
    }
    val q"..$mods val ..$patsnel: ${tpeopt: scala.Option[Type]} = $expr" = stat
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
    if (tpeopt.isEmpty && !(enclosing match {
      case Enclosing.Top | Enclosing.Method | Enclosing.Block => true
      case _ => false
    })) {
      hasError = true
      if (isWorksheet) errorInSlang(stat.pos, "Untyped val declarations can only appear at the top-level, inside methods, or code blocks")
      else errorInSlang(stat.pos, "Untyped val declarations can only appear inside methods or code blocks")
    } else if (patsnel.size != 1) {
      hasError = true
      errorInSlang(stat.pos, "Cannot define multiple vals in a single statement")
    } else if (!(hasSpec || enclosing == Enclosing.ExtObject) && isDollar(expr)) {
      hasError = true
      error(stat.pos, "'$' is only allowed in a Slang @ext object or @spec val/var expression.")
    } else if (hasSpec && (!isDollar(expr) || !patsnel.head.isInstanceOf[Pat.Var.Term])) {
      hasError = true
      errorInSlang(stat.pos, "@spec val declarations should have the form: '@spec val <id> : <type> = $'")
    }
    if (hasError) rStmt
    else if (hasSpec)
      AST.Stmt.SpecVar(isVal = true, cid(patsnel.head.asInstanceOf[Pat.Var.Term]), translateType(tpeopt.get))
    else patsnel.head match {
      case x: Pat.Var.Term =>
        AST.Stmt.Var(isVal = true, cid(x),
          opt(tpeopt.map(translateType)), if (isDiet) None() else Some(translateAssignExp(expr)))
      case pattern =>
        val pat = translatePattern(pattern)
        pat match {
          case _: AST.Pattern.Structure =>
          case _ => error(pattern.pos, s"Unallowable val pattern: '${pattern.syntax}'")
        }
        AST.Stmt.VarPattern(isVal = true, pat,
          opt(tpeopt.map(translateType)), if (isDiet) None() else Some(translateAssignExp(expr)))
    }
  }

  def translateVar(enclosing: Enclosing.Type, stat: Defn.Var): AST.Stmt = {
    var hasError = false
    enclosing match {
      case Enclosing.Top | Enclosing.Object | Enclosing.ExtObject | Enclosing.RecordClass | Enclosing.Method | Enclosing.Block =>
      case _ =>
        hasError = true
        if (isWorksheet) errorInSlang(stat.pos, "Val declarations can only appear at the top-level, inside objects, classes, methods, or code blocks")
        else errorInSlang(stat.pos, "Val declarations can only appear inside objects, @record classes, methods, or code blocks")
    }
    val q"..$mods var ..$patsnel: ${tpeopt: scala.Option[Type]} = ${expropt: scala.Option[Term]}" = stat
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
    if (tpeopt.isEmpty && !(enclosing match {
      case Enclosing.Top | Enclosing.Method | Enclosing.Block => true
      case _ => false
    })) {
      hasError = true
      if (isWorksheet) errorInSlang(stat.pos, "Untyped var declarations can only appear at the top-level, inside methods, or code blocks")
      else errorInSlang(stat.pos, "Untyped var declarations can only appear inside methods or code blocks")
    } else if (patsnel.size != 1) {
      hasError = true
      errorInSlang(stat.pos, "Cannot define multiple vars in a single statement")
    } else if (!(hasSpec || enclosing == Enclosing.ExtObject) && isDollarExpr) {
      hasError = true
      error(stat.pos, "'$' is only allowed in a Slang @ext object or @spec val/var expression.")
    } else if (hasSpec && (!isDollarExpr || !patsnel.head.isInstanceOf[Pat.Var.Term])) {
      hasError = true
      errorInSlang(stat.pos, "@spec var declarations should have the form: '@spec val <id> : <type> = $'")
    } else if (expropt.isEmpty) {
      hasError = true
      errorInSlang(stat.pos, "Uninitialized '_' var declarations are disallowed")
    }
    if (hasError) rStmt
    else if (hasSpec)
      AST.Stmt.SpecVar(isVal = false, cid(patsnel.head.asInstanceOf[Pat.Var.Term]), translateType(tpeopt.get))
    else patsnel.head match {
      case x: Pat.Var.Term =>
        AST.Stmt.Var(isVal = false, cid(x),
          opt(tpeopt.map(translateType)), if (isDiet) None() else Some(translateAssignExp(expropt.get)))
      case pattern =>
        val pat = translatePattern(pattern)
        pat match {
          case _: AST.Pattern.Structure =>
          case _ => error(pattern.pos, s"Unallowable var pattern: '${pattern.syntax}'")
        }
        AST.Stmt.VarPattern(isVal = false, pat,
          opt(tpeopt.map(translateType)), if (isDiet) None() else Some(translateAssignExp(expropt.get)))
    }
  }

  def translateDef(enclosing: Enclosing.Type, stat: Decl.Def): AST.Stmt = {
    enclosing match {
      case Enclosing.DatatypeTrait | Enclosing.RecordTrait | Enclosing.Sig =>
      case _ => errorInSlang(stat.pos, "Method declarations can only appear inside @datatype, @record, or @sig traits")
    }
    val q"..$mods def $name[..$tparams](...$paramss): $tpe" = stat
    var hasError = false
    if (paramss.size > 1) {
      hasError = true
      errorNotSlang(name.pos, "Methods with multiple parameter tuples are")
    }
    var isPure = false
    for (mod <- mods) mod match {
      case mod"@pure" =>
        if (isPure) {
          hasError = true
          error(mod.pos, "Redundant @pure.")
        }
        isPure = true
      case _ =>
        hasError = true
        errorInSlang(mod.pos, s"Only the @pure method modifier is allowed for method declarations")
    }
    val sig = AST.MethodSig(
      cid(name),
      ISZ(tparams.map(translateTypeParam): _*),
      paramss.isEmpty,
      ISZ(paramss.headOption.getOrElse(ivectorEmpty).map(translateDefParam): _*),
      translateType(tpe))
    AST.Stmt.Method(isPure, sig, AST.MethodContract(ISZ(), ISZ(), ISZ(), ISZ(), ISZ()), None())
  }

  def translateDef(enclosing: Enclosing.Type, tree: Defn.Def): AST.Stmt = {
    val q"..$mods def $name[..$tparams](...$paramss): ${tpeopt: scala.Option[Type]} = $exp" = tree
    var hasError = false
    if (paramss.size > 1) {
      hasError = true
      errorNotSlang(name.pos, "Methods with multiple parameter tuples are")
    }
    if (tpeopt.isEmpty) {
      hasError = true
      errorInSlang(name.pos, "Methods have to be given an explicit return type")
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
        errorInSlang(mod.pos, s"Only either method modifier @pure or @spec is allowed for method definitions")
    }
    if (isPure && isSpec) {
      hasError = true
      errorInSlang(mods.head.pos, s"Only either method modifier @pure or @spec is allowed")
    }
    val sig = AST.MethodSig(
      cid(name),
      ISZ(tparams.map(translateTypeParam): _*),
      paramss.isEmpty,
      ISZ(paramss.headOption.getOrElse(ivectorEmpty).map(translateDefParam): _*),
      tpeopt.map(translateType).getOrElse(unitType))
    if (enclosing == Enclosing.ExtObject)
      exp match {
        case q"$$" =>
          AST.Stmt.ExtMethod(isPure, sig, AST.MethodContract(
            iszEmpty, iszEmpty, iszEmpty, iszEmpty, iszEmpty))
        case Term.Interpolate(Term.Name("l"), Seq(l@Lit(s: String)), Nil) =>
          AST.Stmt.ExtMethod(isPure, sig, parseContract(l.pos, s))
        case _ =>
          hasError = true
          error(exp.pos, "Only '$' or 'l\"\"\"{ ... }\"\"\"' are allowed as Slang @ext object method expression.")
          AST.Stmt.ExtMethod(isPure, sig, AST.MethodContract(
            iszEmpty, iszEmpty, iszEmpty, iszEmpty, iszEmpty))
      }
    else if (isSpec)
      exp match {
        case q"$$" =>
          AST.Stmt.SpecMethod(sig, ISZ(), ISZ())
        case Term.Interpolate(Term.Name("l"), Seq(l@Lit(s: String)), Nil) =>
          val (defs, where) = parseDefs(l.pos, s)
          AST.Stmt.SpecMethod(sig, defs, where)
        case _ =>
          hasError = true
          error(exp.pos, "Only '$' or 'l\"\"\"{ ... }\"\"\"' is allowed as Slang @spec method expression.")
          AST.Stmt.SpecMethod(sig, ISZ(), ISZ())
      }
    else exp match {
      case exp: Term.Block =>
        val (mc, bodyOpt) = exp.stats.headOption match {
          case scala.Some(Term.Interpolate(Term.Name("l"), Seq(l@Lit(s: String)), Nil)) =>
            (parseContract(l.pos, s),
              if (isDiet) None[AST.Body]()
              else Some(AST.Body(ISZ(exp.stats.tail.map(translateStat(Enclosing.Method)): _*))))
          case _ =>
            (AST.MethodContract(iszEmpty, iszEmpty, iszEmpty, iszEmpty, iszEmpty),
              if (isDiet) None[AST.Body]()
              else Some(AST.Body(ISZ(exp.stats.map(translateStat(Enclosing.Method)): _*))))
        }
        AST.Stmt.Method(isPure, sig, mc, bodyOpt)
      case _ =>
        errorInSlang(exp.pos, "Only block '{ ... }' is allowed for method definitions")
        AST.Stmt.Method(isPure, sig, AST.MethodContract(iszEmpty, iszEmpty, iszEmpty, iszEmpty, iszEmpty), None())
    }
  }

  def translateEnum(enclosing: Enclosing.Type, stat: Defn.Object): AST.Stmt = {
    rStmt // TODO
  }

  def translateObject(enclosing: Enclosing.Type, stat: Defn.Object): AST.Stmt = {
    var hasError = false
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        hasError = true
        if (isWorksheet) errorInSlang(stat.pos, "Object declarations can only appear at the top-level, package-level, or inside other objects")
        else errorInSlang(stat.pos, "Object declarations can only appear at the package-level or inside other objects")
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
        errorNotSlang(mods.head.pos, "Object modifiers other than @ext are")
    }
    if (estats.nonEmpty) {
      hasError = true
      errorNotSlang(estats.head.pos, "Object early initializations are")
    }
    if (ctorcalls.nonEmpty) {
      hasError = true
      errorNotSlang(ctorcalls.head.pos, "Object super constructor calls are")
    }
    if (!hasError) {
      val tstat = if (hasExt) translateStat(Enclosing.ExtObject) _ else translateStat(Enclosing.Object) _
      AST.Stmt.Object(hasExt, cid(name), ISZ(stats.map(tstat): _*))
    } else AST.Stmt.Object(hasExt, cid(name), ISZ())
  }

  def translateDatatype(enclosing: Enclosing.Type, stat: Defn.Trait): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        if (isWorksheet) errorInSlang(stat.pos, "@datatype trait declarations can only appear at the top-level, package-level, or inside objects")
        else errorInSlang(stat.pos, "@datatype trait declarations can only appear at the package-level or inside objects")
    }
    val q"..$mods trait $tname[..$tparams] extends { ..$estats } with ..$ctorcalls { $param => ..$stats }" = stat
    if (estats.nonEmpty || !param.name.isInstanceOf[Name.Anonymous])
      error(tname.pos, "Slang @datatype traits have to be of the form '@datatype trait <id> ... { ... }'.")
    var hasDatatype = false
    for (mod <- mods) mod match {
      case mod"@datatype" =>
        if (hasDatatype) {
          error(mod.pos, "Redundant @datatype.")
        }
        hasDatatype = true
      case _ =>
        error(mod.pos, "No modifiers are allowed for Slang @datatype traits.")
    }
    AST.Stmt.AbstractDatatype(isRoot = true,
      isDatatype = true,
      cid(tname),
      ISZ(tparams.map(translateTypeParam): _*),
      ISZ(),
      ISZ(ctorcalls.map(translateCtorCall): _*),
      ISZ(stats.map(translateStat(Enclosing.DatatypeTrait)): _*))
  }

  def translateDatatype(enclosing: Enclosing.Type, stat: Defn.Class): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        if (isWorksheet) errorInSlang(stat.pos, "@datatype class declarations can only appear at the top-level, package-level, or inside objects")
        else errorInSlang(stat.pos, "@datatype class declarations can only appear at package-level or inside objects")
    }
    val q"..$mods class $tname[..$tparams] ..$ctorMods (...$paramss) extends { ..$estats } with ..$ctorcalls { $param => ..$stats }" = stat
    if (ctorMods.nonEmpty || paramss.size > 1 || estats.nonEmpty ||
      ctorcalls.size > 1 || !param.name.isInstanceOf[Name.Anonymous]) {
      error(tname.pos, "Slang @datatype classes have to be of the form '@datatype class <id> ... (...) ... { ... }'.")
    }
    var hasDatatype = false
    for (mod <- mods) mod match {
      case mod"@datatype" =>
        if (hasDatatype) {
          error(mod.pos, "Redundant @datatype.")
        }
        hasDatatype = true
      case _ =>
        error(mod.pos, "No modifiers are allowed for Slang @datatype classes.")
    }
    val params = ISZ(paramss.flatMap(_.map(translateAbstractDatatypeParam(isDatatype = true))): _*)
    AST.Stmt.AbstractDatatype(isRoot = false,
      isDatatype = true,
      cid(tname),
      ISZ(tparams.map(translateTypeParam): _*),
      params,
      ISZ(ctorcalls.map(translateCtorCall): _*),
      ISZ(stats.map(translateStat(Enclosing.DatatypeClass)): _*))
  }

  def translateRecord(enclosing: Enclosing.Type, stat: Defn.Trait): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        if (isWorksheet) errorInSlang(stat.pos, "@record trait declarations can only appear at the top-level, package-level, or inside objects")
        else errorInSlang(stat.pos, "@rcord trait declarations can only appear at the package-level or inside objects")
    }
    val q"..$mods trait $tname[..$tparams] extends { ..$estats } with ..$ctorcalls { $param => ..$stats }" = stat
    if (estats.nonEmpty || !param.name.isInstanceOf[Name.Anonymous])
      error(tname.pos, "Slang @record traits have to be of the form '@record trait <id> ... { ... }'.")
    var hasRecord = false
    for (mod <- mods) mod match {
      case mod"@record" =>
        if (hasRecord) {
          error(mod.pos, "Redundant @record.")
        }
        hasRecord = true
      case _ =>
        error(mod.pos, "No modifiers are allowed for Slang @record traits.")
    }
    AST.Stmt.AbstractDatatype(isRoot = true,
      isDatatype = false,
      cid(tname),
      ISZ(tparams.map(translateTypeParam): _*),
      ISZ(),
      ISZ(ctorcalls.map(translateCtorCall): _*),
      ISZ(stats.map(translateStat(Enclosing.RecordTrait)): _*))
  }

  def translateRecord(enclosing: Enclosing.Type, stat: Defn.Class): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        if (isWorksheet) errorInSlang(stat.pos, "@record class declarations can only appear at the top-level, package-level, or inside objects")
        else errorInSlang(stat.pos, "@record class declarations can only appear at the package-level or inside objects")
    }
    val q"..$mods class $tname[..$tparams] ..$ctorMods (...$paramss) extends { ..$estats } with ..$ctorcalls { $param => ..$stats }" = stat
    if (ctorMods.nonEmpty || paramss.size > 1 || estats.nonEmpty ||
      ctorcalls.size > 1 || !param.name.isInstanceOf[Name.Anonymous]) {
      error(tname.pos, "Slang @record classes have to be of the form '@record class <id>(...) { ... }'.")
    }
    var hasRecord = false
    for (mod <- mods) mod match {
      case mod"@record" =>
        if (hasRecord) {
          error(mod.pos, "Redundant @record.")
        }
        hasRecord = true
      case _ =>
        error(mod.pos, "No modifiers are allowed for Slang @record classes.")
    }
    val params = ISZ(paramss.flatMap(_.map(translateAbstractDatatypeParam(isDatatype = false))): _*)
    AST.Stmt.AbstractDatatype(isRoot = false,
      isDatatype = false,
      cid(tname),
      ISZ(tparams.map(translateTypeParam): _*),
      params,
      ISZ(ctorcalls.map(translateCtorCall): _*),
      ISZ(stats.map(translateStat(Enclosing.RecordClass)): _*))
  }

  def translateSig(enclosing: Enclosing.Type, stat: Defn.Trait): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        if (isWorksheet) errorInSlang(stat.pos, "@sig trait declarations can only appear at the top-level, package-level, or inside objects")
        else errorInSlang(stat.pos, "@sig trait declarations can only appear at the package-level or inside objects")
    }
    val q"..$mods trait $tname[..$tparams] extends { ..$estats } with ..$ctorcalls { $param => ..$stats }" = stat
    if (estats.nonEmpty || !param.name.isInstanceOf[Name.Anonymous])
      error(tname.pos, "Slang @sig traits have to be of the form '@sig trait <id> ... { ... }'.")
    var hasSealed = false
    for (mod <- mods) mod match {
      case mod"sealed" =>
        if (hasSealed) {
          error(mod.pos, "Redundant 'sealed'.")
        }
        hasSealed = true
      case _ =>
        error(mod.pos, "Only the 'sealed' modifier is allowed for Slang @sig traits.")
    }
    AST.Stmt.Sig(cid(tname),
      ISZ(tparams.map(translateTypeParam): _*),
      ISZ(ctorcalls.map(translateCtorCall): _*),
      ISZ(stats.map(translateStat(Enclosing.Sig)): _*))
  }

  def translateTypeAlias(enclosing: Enclosing.Type, stat: Decl.Type): AST.Stmt = {
    rStmt // TODO
  }

  def translateBlock(enclosing: Enclosing.Type, stat: Term.Block): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Method | Enclosing.Block =>
        AST.Stmt.Block(AST.Body(ISZ(stat.stats.map(translateStat(Enclosing.Block)): _*)))
      case _ =>
        if (isWorksheet) errorInSlang(stat.pos, "Code-blocks can only appear at the top-level, inside methods, or other code blocks")
        else errorInSlang(stat.pos, "Code-blocks can only appear inside methods or other code blocks")
        rStmt
    }
  }

  def translateIfStmt(enclosing: Enclosing.Type, stat: Term.If): AST.Stmt = {
    var hasError = false
    enclosing match {
      case Enclosing.Top | Enclosing.Method | Enclosing.Block =>
      case _ =>
        hasError = true
        if (isWorksheet) errorInSlang(stat.pos, "If-statements can only appear at the top-level, inside methods, or code blocks")
        else errorInSlang(stat.pos, "If-statements can only appear inside methods or code blocks")
    }
    if (!stat.thenp.isInstanceOf[Term.Block]) {
      hasError = true
      errorInSlang(stat.thenp.pos, "If-then part should be a code block '{ ... }'")
    }
    stat.elsep match {
      case _: Term.Block | _: Term.If | _: Lit.Unit =>
      case _ =>
        hasError = true
        errorInSlang(stat.elsep.pos, "If-else part should be either a code block '{ ... }' or another if-conditional.")
    }
    if (hasError) rStmt else ((stat.thenp, stat.elsep): @unchecked) match {
      case (thenp: Term.Block, elsep: Term.Block) =>
        AST.Stmt.If(translateExp(stat.cond),
          AST.Body(ISZ(thenp.stats.map(translateStat(enclosing)): _*)),
          AST.Body(ISZ(elsep.stats.map(translateStat(enclosing)): _*)))
      case (thenp: Term.Block, elsep: Term.If) =>
        AST.Stmt.If(translateExp(stat.cond),
          AST.Body(ISZ(thenp.stats.map(translateStat(enclosing)): _*)),
          AST.Body(ISZ(translateIfStmt(Enclosing.Block, elsep))))
      case (thenp: Term.Block, elsep: Lit.Unit) =>
        AST.Stmt.If(translateExp(stat.cond),
          AST.Body(ISZ(thenp.stats.map(translateStat(enclosing)): _*)),
          AST.Body(ISZ()))
    }
  }

  def translateWhile(enclosing: Enclosing.Type, stat: Term.While): AST.Stmt = {
    var hasError = false
    enclosing match {
      case Enclosing.Top | Enclosing.Method | Enclosing.Block =>
      case _ =>
        hasError = true
        if (isWorksheet) errorInSlang(stat.pos, "While-statements can only appear at the top-level, inside methods, or code blocks")
        else errorInSlang(stat.pos, "While-statements can only appear inside methods or code blocks")
    }
    var reads: ISZ[AST.Name] = ISZ()
    var invariants: ISZ[AST.Exp] = ISZ()
    var stats: Seq[Stat] = Seq()
    stat.body match {
      case body: Term.Block => body.stats match {
        case Term.Interpolate(Term.Name("l"), Seq(l@Lit(s: String)), Seq()) :: rest =>
          val (rs, is) = parseLoopContract(l.pos, s)
          reads = rs
          invariants = is
          stats = rest
        case (t: Term.Interpolate) :: rest =>
          hasError = true
          error(t.pos, "Expecting a Slang while-loop contract l\"\"\"{ ... }\"\"\" but found '" + syntax(t) + "'.")
        case _ =>
          stats = body.stats
      }
      case _ =>
        hasError = true
        errorInSlang(stat.body.pos, "While-loop body should be a code block '{ ... }'")
    }
    if (hasError) rStmt else
      AST.Stmt.While(isDoWhile = false, translateExp(stat.expr), reads, invariants,
        AST.Body(ISZ(stats.map(translateStat(Enclosing.Block)): _*)))
  }

  def translateDoWhile(enclosing: Enclosing.Type, stat: Term.Do): AST.Stmt = {
    var hasError = false
    enclosing match {
      case Enclosing.Top | Enclosing.Method | Enclosing.Block =>
      case _ =>
        hasError = true
        if (isWorksheet) errorInSlang(stat.pos, "Do-While-statements can only appear at the top-level, inside methods, or code blocks")
        else errorInSlang(stat.pos, "Do-While-statements can only appear inside methods or code blocks")
    }
    var reads: ISZ[AST.Name] = ISZ()
    var invariants: ISZ[AST.Exp] = ISZ()
    var stats: Seq[Stat] = Seq()
    stat.body match {
      case body: Term.Block => body.stats.lastOption match {
        case scala.Some(Term.Interpolate(Term.Name("l"), Seq(l@Lit(s: String)), Seq())) =>
          val (rs, is) = parseLoopContract(l.pos, s)
          reads = rs
          invariants = is
          stats = body.stats.dropRight(1)
        case scala.Some(t: Term.Interpolate) =>
          hasError = true
          error(t.pos, "Expecting a Slang do-while-loop contract l\"\"\"{ ... }\"\"\" but found '" + syntax(t) + "'.")
        case _ =>
          stats = body.stats
      }
      case _ =>
        hasError = true
        errorInSlang(stat.body.pos, "Do-While-loop body should be a code block '{ ... }'")
    }
    if (hasError) rStmt else
      AST.Stmt.While(isDoWhile = true, translateExp(stat.expr), reads, invariants,
        AST.Body(ISZ(stats.map(translateStat(Enclosing.Block)): _*)))
  }

  def translateFor(enclosing: Enclosing.Type, stat: Term.For): AST.Stmt = {
    var hasError = false
    enclosing match {
      case Enclosing.Top | Enclosing.Method | Enclosing.Block =>
      case _ =>
        hasError = true
        if (isWorksheet) errorInSlang(stat.pos, "For-statements can only appear at the top-level, inside methods, or code blocks")
        else errorInSlang(stat.pos, "For-statements can only appear inside methods or code blocks")
    }
    var reads: ISZ[AST.Name] = ISZ()
    var invariants: ISZ[AST.Exp] = ISZ()
    var stats: Seq[Stat] = Seq()
    stat.body match {
      case body: Term.Block => body.stats match {
        case Term.Interpolate(Term.Name("l"), Seq(l@Lit(s: String)), Seq()) :: rest =>
          val (rs, is) = parseLoopContract(l.pos, s)
          reads = rs
          invariants = is
          stats = rest
        case (t: Term.Interpolate) :: rest =>
          hasError = true
          error(t.pos, "Expecting a Slang for-loop contract l\"\"\"{ ... }\"\"\" but found '" + syntax(t) + "'.")
        case _ =>
          stats = body.stats
      }
      case _ =>
        hasError = true
        errorInSlang(stat.body.pos, "While-loop body should be a code block '{ ... }'")
    }
    val foo = ISZ("a", "b", "c")
    for (f <- foo) {

    }
    if (hasError) rStmt else stat.enums match {
      case Seq(enumerator"${id: Pat.Var.Term} <- $expr") =>
        expr match {
          case q"$from to $to by $step" =>
          case q"$from until $to by $step" =>
          case q"$from to $to" =>
          case q"$from until $to" =>
          case q"$s.indices" =>
          case _ =>
        }
      case _ =>
    }
    rStmt // TODO
  }

  def translateCtorCall(cc: Ctor.Call): AST.Type = {
    def f(t: Term): ISZ[AST.Id] = t match {
      case ctor"${ctorname: Ctor.Name}" => ISZ(cid(ctorname))
      case ctor"$ref.$ctorname" => f(ref) :+ cid(ctorname)
      case q"${name: Term.Name}" => ISZ(cid(name))
      case q"$expr.$name" => f(expr) :+ cid(name)
    }

    cc match {
      case ctor"$ctorref[..$atpesnel]" => AST.Type.Named(AST.Name(f(ctorref)), ISZ(atpesnel.map(translateType): _*))
      case _ => AST.Type.Named(AST.Name(f(cc)), ISZ())
    }
  }

  def translateAbstractDatatypeParam(isDatatype: Boolean)(tp: Term.Param): AST.AbstractDatatypeParam = {
    val param"..$mods $paramname: ${atpeopt: scala.Option[Type.Arg]} = ${expropt: scala.Option[Term]}" = tp
    var hasError = true
    var hasHidden = false
    var hasPure = false
    var isVar = false
    for (mod <- mods) mod match {
      case mod"@hidden" =>
        if (hasHidden) {
          hasError = true
          error(mod.pos, "Redundant @hidden.")
        }
        hasHidden = true
      case mod"@pure" =>
        if (hasPure) {
          hasError = true
          error(mod.pos, "Redundant @pure.")
        }
        hasPure = true
      case mod"varparam" if isDatatype => isVar = true
      case _ =>
        hasError = true
        if (isDatatype) error(mod.pos, s"Unallowed modifier '${syntax(mod)}' for a Slang @datatype class.")
        else error(mod.pos, s"Unallowed modifier '${syntax(mod)}' for a Slang @record class.")
    }
    if (atpeopt.isEmpty || expropt.nonEmpty) {
      hasError = true
      val hidden = if (hasHidden) "@hidden " else ""
      val pure = if (hasPure) "@pure" else ""
      errorInSlang(tp.pos, s"The abstract dataype parameter should have the form '$hidden$pure<id> : <type>'")
    }
    if (hasError) AST.AbstractDatatypeParam(hasHidden, hasPure, cid(paramname), unitType)
    else AST.AbstractDatatypeParam(hasHidden, hasPure, cid(paramname), translateTypeArg(atpeopt.get))
  }

  def translateTypeParam(tp: Type.Param): AST.TypeParam = tp match {
    case tparam"..$mods $tparamname[..$tparams] >: ${stpeopt: scala.Option[Type]} <: ${tpeopt: scala.Option[Type]} <% ..$tpes : ..$tpes2" =>
      if (mods.nonEmpty || tparams.nonEmpty || stpeopt.nonEmpty || tpes.nonEmpty || tpes2.nonEmpty)
        errorInSlang(tp.pos, "Only type parameters of the forms '<id>' or '<id> <: <type>' are")
      AST.TypeParam(cid(tparamname), opt(tpeopt.map(translateType)))
  }

  def translateDefParam(tp: Term.Param): AST.Param = {
    val param"..$mods $paramname: ${atpeopt: scala.Option[Type.Arg]} = ${expropt: scala.Option[Term]}" = tp
    var hasPure = false
    for (mod <- mods) mod match {
      case mod"@pure" =>
        if (hasPure) {
          error(mod.pos, "Redundant @pure.")
        }
        hasPure = true
      case _ =>
        error(mod.pos, s"Unallowed modifier '${syntax(mod)}' for a Slang method.")
    }
    if (atpeopt.isEmpty || expropt.nonEmpty) {
      val pure = if (hasPure) "@pure " else ""
      errorInSlang(tp.pos, s"The parameter should have the form '$pure<id> : <type>'")
    }
    atpeopt.map(ta => AST.Param(hasPure, cid(paramname), translateTypeArg(ta))).
      getOrElse(AST.Param(hasPure, cid(paramname), unitType))
  }

  def translateTypeArg(ta: Type.Arg): AST.Type = ta match {
    case targ"${tpe: Type}" =>
      translateType(tpe)
    case _: Type.Arg.Repeated =>
      errorNotSlang(ta.pos, "Repeated types '<type>*' are")
      unitType
    case _: Type.Arg.ByName =>
      errorNotSlang(ta.pos, "By name types '=> <type>' are")
      unitType
  }

  def translateType(t: Type): AST.Type = t match {
    case t"${name: Type.Name}[..$tpesnel]" =>
      AST.Type.Named(AST.Name(ISZ(cid(name))), ISZ(tpesnel.map(translateType): _*))
    case t"${name: Type.Name}" =>
      AST.Type.Named(AST.Name(ISZ(cid(name))), ISZ())
    case t"(..$tpesnel)" =>
      AST.Type.Tuple(ISZ(tpesnel.map(translateType): _*))
    case t"$ref.$tname" =>
      def f(t: Term): ISZ[AST.Id] = t match {
        case q"$expr.$name" => f(expr) :+ cid(name)
        case q"${name: Term.Name}" => ISZ(cid(name))
        case _ =>
          errorInSlang(t.pos, s"Invalid type reference '${t.syntax}'")
          ISZ(AST.Id("$"))
      }

      AST.Type.Named(AST.Name(f(ref) :+ cid(tname)), ISZ())
    case t"(..$atpes) => $tpe" =>
      AST.Type.Fun(ISZ(atpes.map(translateTypeArg): _*), translateType(tpe))
    case _ =>
      errorNotSlang(t.pos, s"Type '${syntax(t)}' is")
      unitType
  }

  def translateAssignExp(exp: Term): AST.AssignExp = {
    rStmt // TODO
  }

  def translatePattern(pat: Pat): AST.Pattern = {
    AST.Pattern.Wildcard() // TODO
  }

  def translateExp(exp: Term): AST.Exp = {
    exp match {
      case exp: Term.Name => rExp // TODO
      case exp: Term.Select => rExp // TODO
      case exp: Term.Apply => rExp // TODO
      case exp: Term.ApplyInfix => rExp // TODO
      case exp: Term.ApplyUnary => rExp // TODO
      case exp: Term.Tuple => rExp // TODO
      case exp: Term.If =>
        var hasError = false
        if (exp.thenp.isInstanceOf[Term.Block]) {
          hasError = true
          errorInSlang(exp.thenp.pos, "If-then expression should not be a code block '{ ... }'")
        }
        if (exp.elsep.isInstanceOf[Term.Block]) {
          hasError = true
          errorInSlang(exp.thenp.pos, "If-else expression should not be a code block '{ ... }'")
        }
        if (hasError) rExp
        else rExp // TODO
      case exp: Term.Eta => rExp // TODO
      case exp: Term.Interpolate => rExp // TODO
      case exp: Lit => rExp // TODO
      case _ =>
        errorNotSlang(exp.pos, s"Expresion '${syntax(exp)}' is")
        rExp
    }
  }

  def parseDefs(pos: Position, text: String): (ISZ[AST.SpecMethodDef], ISZ[AST.Stmt.Assign]) = {
    // TODO: parse defs
    (ISZ(), ISZ())
  }

  def parseContract(pos: Position, text: String): AST.MethodContract = {
    // TODO: parse contract
    AST.MethodContract(iszEmpty, iszEmpty, iszEmpty, iszEmpty, iszEmpty)
  }

  def parseLStmt(enclosing: Enclosing.Type, pos: Position, text: String): AST.Stmt = {
    // TODO: parse stmt
    AST.Stmt.Expr(AST.Exp.Ident(AST.Id("$")))
  }

  def parseLoopContract(pos: Position, text: String): (ISZ[AST.Name], ISZ[AST.Exp]) = {
    // TODO: parse while contract
    (ISZ(), ISZ())
  }

  def cid(t: Pat.Var.Term): AST.Id = cid(t.name.value, t.pos)

  def cid(name: Term.Name): AST.Id = cid(name.value, name.pos)

  def cid(name: Ctor.Name): AST.Id = cid(name.value, name.pos)

  def cid(name: Type.Param.Name): AST.Id = cid(name.value, name.pos)

  def cid(name: Term.Param.Name): AST.Id = cid(name.value, name.pos)

  def cid(name: Name.Indeterminate): AST.Id = cid(name.value, name.pos)

  def cid(id: String, pos: Position): AST.Id = {
    def isLetter(c: Char): Boolean = ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')

    def isLetterOrDigit(c: Char): Boolean = isLetter(c) || ('0' <= c && c <= '9')

    if (!(isLetter(id.head) && id.tail.forall(isLetterOrDigit)))
      errorInSlang(pos, s"'$id' is not a valid identifier form (i.e., [a-z,A-Z][a-z,A-Z,0-9]*)")
    AST.Id(id)
  }

  def packageRef2IS(ref: Term.Ref): ISZ[AST.Id] = {
    def f(t: Term): ISZ[AST.Id] = t match {
      case q"${name: Term.Name}" => ISZ(cid(name))
      case q"$expr.$name" => f(expr) :+ cid(name)
      case _ => errorInSlang(t.pos, s"Invalid package name '${ref.syntax}'")
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

  def opt[T](opt: scala.Option[T]): Option[T] = opt match {
    case scala.Some(x) => Some(x)
    case _ => None()
  }
}
