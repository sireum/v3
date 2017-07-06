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
import org.sireum.{B, ISZ, None, Option, Some, String, _2String, enum}
import org.sireum.math.Numbers

import scala.meta._
import scala.meta.internal.parsers.ScalametaParser

// TODO: clean up quasiquotes due to IntelliJ's macro annotation inference workaround
object SlangParser {

  @enum object Enclosing {
    'Top
    'Package
    'Object
    'ExtObject
    'DatatypeTrait
    'DatatypeClass
    'RecordTrait
    'RecordClass
    'Sig
    'RichTrait
    'RichClass
    'Method
    'Block
  }

  val bvs: Set[Predef.String] = Set("bb", "bl")

  val unops: Map[Predef.String, AST.Exp.UnaryOp.Type] = Map(
    "!" -> AST.Exp.UnaryOp.Not,
    "+" -> AST.Exp.UnaryOp.Plus,
    "-" -> AST.Exp.UnaryOp.Minus,
    "~" -> AST.Exp.UnaryOp.Complement,
    "¬" -> AST.Exp.UnaryOp.Not
  )

  val binops: Map[Predef.String, AST.Exp.BinaryOp.Type] = Map(
    "+" -> AST.Exp.BinaryOp.Add,
    "-" -> AST.Exp.BinaryOp.Sub,
    "*" -> AST.Exp.BinaryOp.Mul,
    "/" -> AST.Exp.BinaryOp.Div,
    "%" -> AST.Exp.BinaryOp.Rem,
    "==" -> AST.Exp.BinaryOp.Eq,
    "!=" -> AST.Exp.BinaryOp.Ne,
    "<<" -> AST.Exp.BinaryOp.Shl,
    ">>" -> AST.Exp.BinaryOp.Shr,
    ">>>" -> AST.Exp.BinaryOp.Ushr,
    "<" -> AST.Exp.BinaryOp.Lt,
    "<=" -> AST.Exp.BinaryOp.Le,
    ">" -> AST.Exp.BinaryOp.Gt,
    ">=" -> AST.Exp.BinaryOp.Ge,
    "&" -> AST.Exp.BinaryOp.And,
    "|" -> AST.Exp.BinaryOp.Or,
    "|^" -> AST.Exp.BinaryOp.Xor,
    LParser.implyInternalSym -> AST.Exp.BinaryOp.Imply,
    ":+" -> AST.Exp.BinaryOp.Append,
    "+:" -> AST.Exp.BinaryOp.Prepend,
    "++" -> AST.Exp.BinaryOp.AppendAll,
    "--" -> AST.Exp.BinaryOp.RemoveAll)

  def scalaDialect(isWorksheet: Boolean): Dialect =
    if (isWorksheet) scala.meta.dialects.Scala212.copy(
      allowToplevelTerms = true, allowLiteralTypes = true, allowTrailingCommas = true)
    else scala.meta.dialects.Scala212.copy(
      allowLiteralTypes = true, allowTrailingCommas = true)

  case class Result(text: Predef.String,
                    hashSireum: Boolean,
                    unitOpt: Option[AST.TopUnit],
                    tags: ISZ[Tag])

  def apply(isWorksheet: Boolean,
            isDiet: Boolean,
            fileUriOpt: scala.Option[FileResourceUri],
            text: Predef.String): Result =
    apply(allowSireumPackage = false, isWorksheet, isDiet, fileUriOpt, text)

  def apply(allowSireumPackage: Boolean,
            isWorksheet: Boolean,
            isDiet: Boolean,
            fileUriOpt: scala.Option[FileResourceUri],
            text: Predef.String): Result = {
    val lines = text.trim.lines
    val line = if (lines.hasNext) lines.next.filterNot(_.isWhitespace) else ""
    val hashSireum = line.contains("#Sireum")
    val (dialect, input) = scalaDialect(isWorksheet)(text)
    new SlangParser(text, input, dialect, allowSireumPackage, hashSireum,
      isWorksheet, isDiet, fileUriOpt).parseTopUnit()
  }

  def error(fileUriOpt: scala.Option[FileResourceUri],
            pos: Position,
            message: Predef.String): Tag = {
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

  def hasSelfType(p: Term.Param): Boolean = {
    val param"..$mods $paramname: ${atpeopt: scala.Option[Type.Arg]} = ${expropt: scala.Option[Term]}" = p
    mods.nonEmpty || !paramname.isInstanceOf[Name.Anonymous] || atpeopt.nonEmpty || expropt.nonEmpty
  }

  private[SlangParser] lazy val emptyAttr = AST.Attr(posInfoOpt = None())
  private[SlangParser] lazy val emptyTypedAttr = AST.TypedAttr(posInfoOpt = None(), typeOpt = None())
  private[SlangParser] lazy val emptyResolvedAttr = AST.ResolvedAttr(posInfoOpt = None(), resOpt = None(), typeOpt = None())

  private[SlangParser] lazy val rDollarId = AST.Id("$", emptyAttr)
  private[SlangParser] lazy val rExp = AST.Exp.Ident(rDollarId, emptyResolvedAttr)
  private[SlangParser] lazy val rStmt = AST.Stmt.Expr(rExp, emptyAttr)
}

import SlangParser._

class SlangParser(text: Predef.String,
                  input: Input,
                  dialect: Dialect,
                  allowSireumPackage: Boolean,
                  hashSireum: Boolean,
                  isWorksheet: Boolean,
                  isDiet: Boolean,
                  fileUriOpt: scala.Option[FileResourceUri]) {
  var tags: ISZ[Tag] = ISZ()
  var lPointOpt: scala.Option[(Int, Int, Int)] = scala.None

  def parseTopUnit(): Result = {
    val parser = new ScalametaParser(input, dialect)

    try {
      if (fileUriOpt.getOrElse("").endsWith(".scala")) {
        if (hashSireum) translateSource(parser.parseSource())
        else Result(text, hashSireum, None(), tags)
      } else {
        val oldIn = parser.in
        parser.in = oldIn.fork
        parser.next()
        parser.newLinesOpt()
        if (parser.isIdentOf("*")) {
          new LParser(input, dialect, this).truthTable(opt(fileUriOpt.map(_2String)))
        } else if (parser.token.is[Token.KwPackage] || parser.token.is[Token.KwImport] || parser.token.is[Token.EOF]) {
          parser.in = oldIn
          translateSource(parser.parseSource())
        } else {
          new LParser(input, dialect, this).sequentFile(opt(fileUriOpt.map(_2String)))
        }
      }
    } catch {
      case e: ParseException =>
        error(e.pos, e.shortMessage)
        Result(text, hashSireum, None(), tags)
      case e: TokenizeException =>
        error(e.pos, e.shortMessage)
        Result(text, hashSireum, None(), tags)
    }
  }

  def error(pos: Position,
            message: Predef.String): Unit = {
    lPointOpt match {
      case scala.Some((startOffset, _, _)) =>
        tags :+= SlangParser.error(fileUriOpt,
          Position.Range(input, startOffset + pos.start.offset, startOffset + pos.end.offset),
          message)
      case _ =>
        tags :+= SlangParser.error(fileUriOpt, pos, message)
    }
  }

  val unitType = AST.Type.Named(AST.Name(ISZ(AST.Id("Unit", emptyAttr)), emptyAttr), ISZ(), emptyTypedAttr)

  def errorNotSlang(pos: Position, message: Predef.String): Unit =
    error(pos, message + " not in Slang.")

  def errorInSlang(pos: Position, message: Predef.String): Unit =
    error(pos, message + " in Slang.")

  def translateSource(source: Source): Result = {
    def topF(rest: List[Stat]): Result = {
      val shouldParse = fileUriOpt.forall(fileUri =>
        fileUri.value.endsWith(".logika") ||
          fileUri.value.endsWith(".sc") ||
          (hashSireum && fileUri.value.endsWith(".scala")))
      if (shouldParse)
        Result(text, hashSireum,
          Some(AST.TopUnit.Program(
            opt(fileUriOpt.map(_2String)),
            AST.Name(ISZ(), emptyAttr),
            AST.Body(ISZ(rest.map(translateStat(Enclosing.Top)): _*)))), tags)
      else
        Result(text, hashSireum, None(), tags)
    }

    val uriOpt = opt(fileUriOpt.map(_2String))

    source.stats match {
      case List(q"package $ref { ..$stats }") =>
        if (hashSireum) {
          val name = AST.Name(ref2IS(ref), attr(ref.pos))
          val refSyntax = ref.syntax
          if (refSyntax == "org.sireum" || refSyntax.startsWith("org.sireum.")) {
            if (allowSireumPackage)
              Result(text, hashSireum,
                Some(AST.TopUnit.Program(uriOpt, name,
                  AST.Body(ISZ(stats.map(translateStat(Enclosing.Package)): _*)))), tags)
            else {
              errorInSlang(ref.pos, s"Cannot define members of the $refSyntax package")
              Result(text, hashSireum, None(), tags)
            }
          } else {
            def packageF(rest: List[Stat]) = Result(text, hashSireum,
              Some(AST.TopUnit.Program(uriOpt, name,
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
        Result(text, hashSireum, Some(AST.TopUnit.Program(uriOpt, AST.Name(ISZ(), emptyAttr), AST.Body(ISZ()))), tags)
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
      case stat: Defn.Object => translateObject(enclosing, stat)
      case stat: Defn.Trait =>
        for (mod <- stat.mods) mod match {
          case mod"@sig" => return translateSig(enclosing, stat)
          case mod"@datatype" => return translateDatatype(enclosing, stat)
          case mod"@record" => return translateRecord(enclosing, stat)
          case mod"@rich" => return translateRich(enclosing, stat)
        }
        errorNotSlang(stat.pos, s"Statement '${syntax(stat)}' is")
        rStmt
      case stat: Defn.Class =>
        for (mod <- stat.mods) mod match {
          case mod"@datatype" => return translateDatatype(enclosing, stat)
          case mod"@record" => return translateRecord(enclosing, stat)
          case mod"@rich" => return translateRich(enclosing, stat)
        }
        errorNotSlang(stat.pos, s"Statement '${syntax(stat)}' is")
        rStmt
      case stat: Defn.Type => translateTypeAlias(enclosing, stat)
      case stat: Term.Assign => translateAssign(enclosing, stat)
      case stat: Term.Update => translateAssign(enclosing, stat)
      case stat: Term.Block => translateBlock(enclosing, stat, isAssignExp = false)
      case stat: Term.If => translateIfStmt(enclosing, stat, isAssignExp = false)
      case stat: Term.Match => translateMatch(enclosing, stat, isAssignExp = false)
      case stat: Term.While => translateWhile(enclosing, stat)
      case stat: Term.Do => translateDoWhile(enclosing, stat)
      case stat: Term.For => translateFor(enclosing, stat)
      case stat: Term.Return => translateReturn(enclosing, stat)
      case stat: Term.Apply => AST.Stmt.Expr(translateExp(stat), attr(stat.pos))
      case stat@Term.Interpolate(Term.Name("l"), Seq(_: Lit.String), Nil) => parseLStmt(enclosing, stat)
      case _ =>
        errorNotSlang(stat.pos, s"Statement '${stat.syntax}' is")
        rStmt
    }
  }

  def translateImport(enclosing: Enclosing.Type,
                      stat: Import): AST.Stmt = stat.importers match {
    case Seq(Importer(ref: Term.Ref, Seq(Importee.Wildcard()))) =>
      AST.Stmt.Import(ISZ(AST.Stmt.Import.Importer(AST.Name(ref2IS(ref), attr(ref.pos)), Some(ISZ()))), attr(stat.pos))
    case _ =>
      var importers = ISZ[AST.Stmt.Import.Importer]()
      for (importer <- stat.importers) {
        val ref = ref2IS(importer.ref)
        val name = AST.Name(ref, attr(importer.ref.pos))
        var sels = ISZ[AST.Stmt.Import.Selector]()
        for (importee <- importer.importees) importee match {
          case importee"$finame => $tiname" =>
            sels +:= AST.Stmt.Import.Selector(cid(finame), cid(tiname))
          case importee"${iname: Name.Indeterminate}" =>
            val id = cid(iname)
            sels +:= AST.Stmt.Import.Selector(id, id)
          case _ => errorNotSlang(importee.pos, s"Importee '${importee.syntax}' from ${importer.ref.syntax} is")
        }
        importers +:= AST.Stmt.Import.Importer(name, Some(sels))
      }
      AST.Stmt.Import(importers, attr(stat.pos))
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
    val isDollarExpr = isDollar(expr)
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
    } else if (isDollarExpr && !(hasSpec || enclosing == Enclosing.ExtObject)) {
      hasError = true
      error(stat.pos, "'$' is only allowed in a Slang @ext object or @spec val/var expression.")
    } else if (hasSpec && (!isDollar(expr) || !patsnel.head.isInstanceOf[Pat.Var.Term] || tpeopt.isEmpty)) {
      hasError = true
      errorInSlang(stat.pos, "@spec val declarations should have the form: '@spec val〈ID〉:〈type〉= $'")
    }
    if (hasError) rStmt
    else if (hasSpec)
      AST.Stmt.SpecVar(isVal = true, cid(patsnel.head.asInstanceOf[Pat.Var.Term]), translateType(tpeopt.get), attr(stat.pos))
    else patsnel.head match {
      case x: Pat.Var.Term =>
        val r = AST.Stmt.Var(isVal = true, cid(x),
          opt(tpeopt.map(translateType)),
          if (isDiet && tpeopt.nonEmpty) None()
          else if (isDollarExpr) None() else Some(translateAssignExp(expr)), attr(stat.pos))
        if (tpeopt.isEmpty) checkTyped(expr.pos, r)
        r
      case pattern =>
        if (tpeopt.nonEmpty)
          errorInSlang(pattern.pos, "Val pattern cannot be explicitly typed")
        val pat = translatePattern(pattern)
        pat match {
          case _: AST.Pattern.Structure =>
          case _ => error(pattern.pos, s"Unallowable val pattern: '${pattern.syntax}'")
        }
        AST.Stmt.VarPattern(isVal = true, pat,
          None(), if (isDiet) None() else Some(translateAssignExp(expr)), attr(stat.pos))
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
    } else if (isDollarExpr && !(hasSpec || enclosing == Enclosing.ExtObject)) {
      hasError = true
      error(stat.pos, "'$' is only allowed in a Slang @ext object or @spec val/var expression.")
    } else if (hasSpec && (!isDollarExpr || !patsnel.head.isInstanceOf[Pat.Var.Term] || tpeopt.isEmpty)) {
      hasError = true
      errorInSlang(stat.pos, "@spec val declarations should have the form: '@spec var〈ID〉:〈type〉= $'")
    } else if (expropt.isEmpty) {
      hasError = true
      errorInSlang(stat.pos, "Uninitialized '_' var declarations are disallowed")
    }
    if (hasError) rStmt
    else if (hasSpec)
      AST.Stmt.SpecVar(isVal = false, cid(patsnel.head.asInstanceOf[Pat.Var.Term]), translateType(tpeopt.get), attr(stat.pos))
    else patsnel.head match {
      case x: Pat.Var.Term =>
        val r = AST.Stmt.Var(isVal = false, cid(x),
          opt(tpeopt.map(translateType)),
          if (isDiet && tpeopt.nonEmpty) None()
          else if (isDollarExpr) None() else opt(expropt.map(translateAssignExp)), attr(stat.pos))
        if (tpeopt.isEmpty) checkTyped(expropt.get.pos, r)
        r
      case pattern =>
        if (tpeopt.nonEmpty)
          errorInSlang(pattern.pos, "Var pattern cannot be explicitly typed")
        val pat = translatePattern(pattern)
        pat match {
          case _: AST.Pattern.Structure =>
          case _ => error(pattern.pos, s"Unallowable var pattern: '${pattern.syntax}'")
        }
        AST.Stmt.VarPattern(isVal = false, pat,
          None(), if (isDiet) None() else opt(expropt.map(translateAssignExp)), attr(stat.pos))
    }
  }

  def checkTyped(pos: => Position, stmt: AST.Stmt.Var): Unit = {
    var hasError = false

    def check(stmt: Any): Unit = stmt match {
      case AST.Stmt.Expr(_: AST.Exp.If) => hasError = true
      case AST.Stmt.Expr(_) =>
      case _ => hasError = true
    }

    stmt.initOpt match {
      case Some(stmt) => check(stmt)
      case _ =>
    }

    if (hasError) errorInSlang(pos, "Complex initialization should be explicitly typed")
  }

  def translateDef(enclosing: Enclosing.Type, stat: Decl.Def): AST.Stmt = {
    enclosing match {
      case Enclosing.DatatypeTrait | Enclosing.RecordTrait | Enclosing.Sig | Enclosing.RichTrait =>
      case _ => errorInSlang(stat.pos, "Method declarations without a body can only appear inside traits")
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
      opt(paramss.headOption.map(ps => ISZ(ps.map(translateParam): _*))),
      translateType(tpe))
    AST.Stmt.Method(isPure, sig, AST.Contract(ISZ(), ISZ(), ISZ(), ISZ(), ISZ()), None(), attr(stat.pos))
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
      opt(paramss.headOption.map(ps => ISZ(ps.map(translateParam): _*))),
      tpeopt.map(translateType).getOrElse(unitType))
    if (isSpec)
      exp match {
        case q"$$" =>
          AST.Stmt.SpecMethod(sig, ISZ(), ISZ(), attr(tree.pos))
        case exp@Term.Interpolate(Term.Name("l"), Seq(_: Lit.String), Nil) =>
          val (sds, wds) = parseDefs(exp)
          AST.Stmt.SpecMethod(sig, sds, wds, attr(tree.pos))
        case _ =>
          hasError = true
          error(exp.pos, "Only '$' or 'l\"\"\"{ ... }\"\"\"' is allowed as Slang @spec method expression.")
          AST.Stmt.SpecMethod(sig, ISZ(), ISZ(), attr(tree.pos))
      }
    else if (enclosing == Enclosing.ExtObject)
      exp match {
        case q"$$" =>
          AST.Stmt.ExtMethod(isPure, sig, AST.Contract(
            ISZ(), ISZ(), ISZ(), ISZ(), ISZ()), attr(tree.pos))
        case exp@Term.Interpolate(Term.Name("l"), Seq(_: Lit.String), Nil) =>
          AST.Stmt.ExtMethod(isPure, sig, parseContract(exp), attr(tree.pos))
        case _ =>
          hasError = true
          error(exp.pos, "Only '$' or 'l\"\"\"{ ... }\"\"\"' are allowed as Slang @ext object method expression.")
          AST.Stmt.ExtMethod(isPure, sig, AST.Contract(
            ISZ(), ISZ(), ISZ(), ISZ(), ISZ()), attr(tree.pos))
      }
    else exp match {
      case exp: Term.Block =>
        val (mc, bodyOpt) = exp.stats.headOption match {
          case scala.Some(l@Term.Interpolate(Term.Name("l"), Seq(_: Lit.String), Nil)) =>
            (parseContract(l),
              if (isDiet) None[AST.Body]()
              else Some(AST.Body(ISZ(exp.stats.tail.map(translateStat(Enclosing.Method)): _*))))
          case _ =>
            (AST.Contract(ISZ(), ISZ(), ISZ(), ISZ(), ISZ()),
              if (isDiet) None[AST.Body]()
              else Some(AST.Body(ISZ(exp.stats.map(translateStat(Enclosing.Method)): _*))))
        }
        AST.Stmt.Method(isPure, sig, mc, bodyOpt, attr(tree.pos))
      case _ =>
        errorInSlang(exp.pos, "Only block '{ ... }' is allowed for a method body")
        AST.Stmt.Method(isPure, sig, AST.Contract(ISZ(), ISZ(), ISZ(), ISZ(), ISZ()), None(), attr(tree.pos))
    }
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
    var hasEnum = false
    for (mod <- mods) mod match {
      case mod"@ext" =>
        if (hasExt) {
          hasError = true
          error(mods.head.pos, "Redundant @ext.")
        }
        hasExt = true
      case mod"@enum" =>
        if (hasEnum) {
          hasError = true
          error(mod.pos, "Redundant @enum.")
        }
        hasEnum = true
      case _ =>
        hasError = true
        errorNotSlang(mods.head.pos, "Object modifiers other than @ext are")
    }
    if (hasExt && (estats.nonEmpty || ctorcalls.nonEmpty)) {
      hasError = true
      error(name.pos, "Slang @ext objects have to be of the form '@ext object〈ID〉{ ... }'.")
    } else if (hasEnum && (estats.nonEmpty || ctorcalls.nonEmpty)) {
      error(stat.pos, "Slang @enum declarations should have the form: '@enum object〈ID〉{ ... }'")
    } else if (estats.nonEmpty) {
      hasError = true
      errorNotSlang(estats.head.pos, "Object early initializations are")
    }
    if (hasEnum) {
      val elements: Seq[AST.Id] = (for (stat <- stats) yield stat match {
        case Lit.Symbol(symbol) => scala.Some(cid(symbol.name.substring(1), stat.pos))
        case _ =>
          error(stat.pos, s"An @enum element should be a single quote immediately followed by〈ID〉(i.e., a symbol).")
          scala.None
      }).flatten

      AST.Stmt.Enum(cid(name), ISZ(elements: _*), attr(stat.pos))
    } else if (!hasError) {
      val tstat = if (hasExt) translateStat(Enclosing.ExtObject) _ else translateStat(Enclosing.Object) _
      AST.Stmt.Object(
        hasExt, cid(name),
        ISZ(ctorcalls.map(translateExtend): _*),
        ISZ(stats.map(tstat): _*), attr(stat.pos))
    } else AST.Stmt.Object(hasExt, cid(name), ISZ(), ISZ(), attr(stat.pos))
  }

  def translateSig(enclosing: Enclosing.Type, stat: Defn.Trait): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        if (isWorksheet) errorInSlang(stat.pos, "@sig trait declarations can only appear at the top-level, package-level, or inside objects")
        else errorInSlang(stat.pos, "@sig trait declarations can only appear at the package-level or inside objects")
    }
    val q"..$mods trait $tname[..$tparams] extends { ..$estats } with ..$ctorcalls { $param => ..$stats }" = stat
    if (estats.nonEmpty)
      error(tname.pos, "Slang @sig traits have to be of the form '@sig trait〈ID〉... { ... }'.")

    val param"$_: ${atpeopt: scala.Option[Type.Arg]} = ${expropt: scala.Option[Term]}" = param

    if (!param.name.isInstanceOf[Name.Anonymous] || expropt.nonEmpty) {
      errorNotSlang(tname.pos, s"Self type: ${syntax(param)} is")
    }

    var hasSig = false
    var hasSealed = false
    for (mod <- mods) mod match {
      case mod"@sig" =>
        if (hasSig) {
          error(mod.pos, "Redundant '@sig'.")
        }
        hasSig = true
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
      ISZ(ctorcalls.map(translateExtend): _*),
      opt(atpeopt.map(translateTypeArg)),
      ISZ(stats.map(translateStat(Enclosing.Sig)): _*),
      attr(stat.pos))
  }

  def translateDatatype(enclosing: Enclosing.Type, stat: Defn.Trait): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        if (isWorksheet) errorInSlang(stat.pos, "@datatype trait declarations can only appear at the top-level, package-level, or inside objects")
        else errorInSlang(stat.pos, "@datatype trait declarations can only appear at the package-level or inside objects")
    }
    val q"..$mods trait $tname[..$tparams] extends { ..$estats } with ..$ctorcalls { $param => ..$stats }" = stat
    if (estats.nonEmpty || hasSelfType(param))
      error(tname.pos, "Slang @datatype traits have to be of the form '@datatype trait〈ID〉... { ... }'.")
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
      ISZ(ctorcalls.map(translateExtend): _*),
      ISZ(stats.map(translateStat(Enclosing.DatatypeTrait)): _*),
      attr(stat.pos))
  }

  def translateDatatype(enclosing: Enclosing.Type, stat: Defn.Class): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        if (isWorksheet) errorInSlang(stat.pos, "@datatype class declarations can only appear at the top-level, package-level, or inside objects")
        else errorInSlang(stat.pos, "@datatype class declarations can only appear at package-level or inside objects")
    }
    val q"..$mods class $tname[..$tparams] ..$ctorMods (...$paramss) extends { ..$estats } with ..$ctorcalls { $param => ..$stats }" = stat
    if (ctorMods.nonEmpty || paramss.size > 1 || estats.nonEmpty || hasSelfType(param)) {
      error(tname.pos, "Slang @datatype classes have to be of the form '@datatype class〈ID〉... (...) ... { ... }'.")
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
      ISZ(ctorcalls.map(translateExtend): _*),
      ISZ(stats.map(translateStat(Enclosing.DatatypeClass)): _*),
      attr(stat.pos))
  }

  def translateRecord(enclosing: Enclosing.Type, stat: Defn.Trait): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        if (isWorksheet) errorInSlang(stat.pos, "@record trait declarations can only appear at the top-level, package-level, or inside objects")
        else errorInSlang(stat.pos, "@rcord trait declarations can only appear at the package-level or inside objects")
    }
    val q"..$mods trait $tname[..$tparams] extends { ..$estats } with ..$ctorcalls { $param => ..$stats }" = stat
    if (estats.nonEmpty || hasSelfType(param))
      error(tname.pos, "Slang @record traits have to be of the form '@record trait〈ID〉... { ... }'.")
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
      ISZ(ctorcalls.map(translateExtend): _*),
      ISZ(stats.map(translateStat(Enclosing.RecordTrait)): _*),
      attr(stat.pos))
  }

  def translateRecord(enclosing: Enclosing.Type, stat: Defn.Class): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        if (isWorksheet) errorInSlang(stat.pos, "@record class declarations can only appear at the top-level, package-level, or inside objects")
        else errorInSlang(stat.pos, "@record class declarations can only appear at the package-level or inside objects")
    }
    val q"..$mods class $tname[..$tparams] ..$ctorMods (...$paramss) extends { ..$estats } with ..$ctorcalls { $param => ..$stats }" = stat
    if (ctorMods.nonEmpty || paramss.size > 1 || estats.nonEmpty || hasSelfType(param)) {
      error(tname.pos, "Slang @record classes have to be of the form '@record class〈ID〉(...) { ... }'.")
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
      ISZ(ctorcalls.map(translateExtend): _*),
      ISZ(stats.map(translateStat(Enclosing.RecordClass)): _*),
      attr(stat.pos))
  }

  def translateRich(enclosing: Enclosing.Type, stat: Defn.Trait): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        if (isWorksheet) errorInSlang(stat.pos, "@rich trait declarations can only appear at the top-level, package-level, or inside objects")
        else errorInSlang(stat.pos, "@rich trait declarations can only appear at the package-level or inside objects")
    }
    val q"..$mods trait $tname[..$tparams] extends { ..$estats } with ..$ctorcalls { $param => ..$stats }" = stat
    if (estats.nonEmpty || hasSelfType(param))
      error(tname.pos, "Slang @rich traits have to be of the form '@rich trait〈ID〉... { ... }'.")
    var hasRich = false
    for (mod <- mods) mod match {
      case mod"@rich" =>
        if (hasRich) {
          error(mod.pos, "Redundant @rich.")
        }
        hasRich = true
      case _ =>
        error(mod.pos, "No modifiers are allowed for Slang @rich traits.")
    }
    AST.Stmt.Rich(isRoot = true,
      cid(tname),
      ISZ(tparams.map(translateTypeParam): _*),
      ISZ(),
      ISZ(ctorcalls.map(translateExtend): _*),
      ISZ(stats.map(translateStat(Enclosing.DatatypeTrait)): _*),
      attr(stat.pos))
  }

  def translateRich(enclosing: Enclosing.Type, stat: Defn.Class): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        if (isWorksheet) errorInSlang(stat.pos, "@rich class declarations can only appear at the top-level, package-level, or inside objects")
        else errorInSlang(stat.pos, "@rich class declarations can only appear at package-level or inside objects")
    }
    val q"..$mods class $tname[..$tparams] ..$ctorMods (...$paramss) extends { ..$estats } with ..$ctorcalls { $param => ..$stats }" = stat
    if (ctorMods.nonEmpty || paramss.size > 1 || estats.nonEmpty ||
      ctorcalls.size > 1 || hasSelfType(param)) {
      error(tname.pos, "Slang @rich classes have to be of the form '@rich class〈ID〉... (...) ... { ... }'.")
    }
    var hasRich = false
    for (mod <- mods) mod match {
      case mod"@rich" =>
        if (hasRich) {
          error(mod.pos, "Redundant @rich.")
        }
        hasRich = true
      case _ =>
        error(mod.pos, "No modifiers are allowed for Slang @rich classes.")
    }
    AST.Stmt.Rich(isRoot = false,
      cid(tname),
      ISZ(tparams.map(translateTypeParam): _*),
      ISZ(paramss.flatMap(_.map(translateParam)): _*),
      ISZ(ctorcalls.map(translateExtend): _*),
      ISZ(stats.map(translateStat(Enclosing.DatatypeClass)): _*),
      attr(stat.pos))
  }

  def translateTypeAlias(enclosing: Enclosing.Type, stat: Defn.Type): AST.Stmt = {
    val q"..$mods type $tname[..$tparams] = $tpe" = stat
    if (mods.nonEmpty) {
      error(stat.pos, "Slang type definitions should be of the form: 'type〈ID〉... =〈type〉'.")
    }
    AST.Stmt.TypeAlias(cid(tname), ISZ(tparams.map(translateTypeParam): _*), translateType(tpe), attr(stat.pos))
  }

  def translateType(t: Type): AST.Type = t match {
    case t"${name: Type.Name}[..$tpesnel]" =>
      AST.Type.Named(AST.Name(ISZ(cid(name)), attr(name.pos)), ISZ(tpesnel.map(translateType): _*), typedAttr(t.pos))
    case t"${name: Type.Name}" =>
      AST.Type.Named(AST.Name(ISZ(cid(name)), attr(name.pos)), ISZ(), typedAttr(t.pos))
    case t"(..$tpesnel)" =>
      AST.Type.Tuple(ISZ(tpesnel.map(translateType): _*), typedAttr(t.pos))
    case t"$ref.$tname" =>
      def f(t: Term): ISZ[AST.Id] = t match {
        case q"$expr.$name" => f(expr) :+ cid(name)
        case q"${name: Term.Name}" => ISZ(cid(name))
        case _ =>
          errorInSlang(t.pos, s"Invalid type reference '${t.syntax}'")
          ISZ(rDollarId)
      }

      AST.Type.Named(AST.Name(f(ref) :+ cid(tname), attr(t.pos)), ISZ(), typedAttr(t.pos))
    case t"(..$atpes) => $tpe" =>
      AST.Type.Fun(ISZ(atpes.map(translateTypeArg): _*), translateType(tpe), typedAttr(t.pos))
    case _ =>
      errorNotSlang(t.pos, s"Type '${syntax(t)}' is")
      unitType
  }

  def translateType(t: Pat.Type): AST.Type = t match {
    case t"${name: Type.Name}" =>
      AST.Type.Named(AST.Name(ISZ(cid(name)), attr(name.pos)), ISZ(), typedAttr(t.pos))
    case pt"$ref.$tname" =>
      def f(t: Term): ISZ[AST.Id] = t match {
        case q"$expr.$name" => f(expr) :+ cid(name)
        case q"${name: Term.Name}" => ISZ(cid(name))
        case _ =>
          errorInSlang(t.pos, s"Invalid type reference '${t.syntax}'")
          ISZ(rDollarId)
      }
      AST.Type.Named(AST.Name(f(ref) :+ cid(tname), attr(t.pos)), ISZ(), typedAttr(t.pos))
    case _ =>
      errorNotSlang(t.pos, s"Type '${syntax(t)}' is")
      unitType
  }

  def translateTypeArg(ta: Type.Arg): AST.Type = ta match {
    case targ"${tpe: Type}" =>
      translateType(tpe)
    case _: Type.Arg.Repeated =>
      errorNotSlang(ta.pos, "Repeated types '〈type〉*' are")
      unitType
    case _: Type.Arg.ByName =>
      errorNotSlang(ta.pos, "By name types '=> 〈type〉' are")
      unitType
  }

  def translateAssignExp(exp: Term): AST.Stmt with AST.AssignExp = exp match {
    case exp: Term.Block => translateBlock(Enclosing.Block, exp, isAssignExp = true)
    case exp: Term.If if exp.thenp.isInstanceOf[Term.Block] =>
      translateIfStmt(Enclosing.Block, exp, isAssignExp = true)
    case exp: Term.Match => translateMatch(Enclosing.Block, exp, isAssignExp = true)
    case _ => AST.Stmt.Expr(translateExp(exp), attr(exp.pos))
  }

  def translateStmtsExp(pos: Position, stats: Seq[Stat]): ISZ[AST.Stmt] = {
    stats.lastOption match {
      case scala.Some(exp: Term) => ISZ(stats.dropRight(1).map(translateStat(Enclosing.Block)) :+ AST.Stmt.Expr(translateExp(exp), attr(exp.pos)): _*)
      case scala.Some(stat) =>
        error(stat.pos, s"Expecting an expression but '${syntax(stat)}' found.")
        ISZ()
      case _ => error(pos, s"Expecting an expression but none found.")
        ISZ()
    }
  }

  def translatePattern(pat: Pat): AST.Pattern = {
    pat match {
      case p"$pname @ $ref[..$tpes](..$apats)" =>
        if (tpes.nonEmpty) errorInSlang(tpes.head.pos, "Cannot supply type arguments for extraction pattern")
        AST.Pattern.Structure(Some(cid(pname.name)), Some(AST.Name(ref2IS(ref), attr(ref.pos))),
          ISZ(apats.map(translatePatternArg): _*))
      case p"$pname @ (..$patsnel)" =>
        AST.Pattern.Structure(Some(cid(pname.name)), None(),
          ISZ(patsnel.map(translatePattern): _*))
      case p"$ref[..$tpes](..$apats)" =>
        if (tpes.nonEmpty) errorInSlang(tpes.head.pos, "Cannot supply type arguments for extraction pattern")
        AST.Pattern.Structure(None(), Some(AST.Name(ref2IS(ref), attr(ref.pos))),
          ISZ(apats.map(translatePatternArg): _*))
      case p"(..$patsnel)" if patsnel.size > 1 =>
        AST.Pattern.Structure(None(), None(), ISZ(patsnel.map(translatePattern): _*))
      case p"${name: Pat.Var.Term} : $tpe" => AST.Pattern.Variable(cid(name), Some(translateType(tpe)))
      case q"${name: Pat.Var.Term}" => AST.Pattern.Variable(cid(name), None())
      case p"_ : $tpe" => AST.Pattern.Wildcard(Some(translateType(tpe)))
      case p"_" => AST.Pattern.Wildcard(None())
      case p"${lit: Lit}" => AST.Pattern.Literal(translateLit(lit))
      case _ =>
        errorInSlang(pat.pos, s"Invalid pattern: '${syntax(pat)}'")
        AST.Pattern.Wildcard(None())
    }
  }

  def translatePatternArg(patArg: Pat.Arg): AST.Pattern = patArg match {
    case parg"${pat: Pat}" => translatePattern(pat)
    case parg"_*" => AST.Pattern.SeqWildcard()
  }

  def translatePattern(pat: Term): AST.Pattern = {
    pat match {
      case q"$expr(...$aexprssnel)" =>
        if (aexprssnel.size == 1) {
          val args = aexprssnel.head
          expr match {
            case expr: Term.Ref =>
              return AST.Pattern.Structure(None(), Some(AST.Name(ref2IS(expr), attr(expr.pos))),
                ISZ(args.map(translatePatternArg): _*))
            case _ =>
          }
        }
        errorInSlang(pat.pos, s"Invalid pattern: '${syntax(pat)}'")
        AST.Pattern.Wildcard(None())
      case q"(..$exprsnel)" if exprsnel.size > 1 =>
        AST.Pattern.Structure(None(), None(),
          ISZ(exprsnel.map(translatePattern): _*))
      case q"${name: Term.Name}" => AST.Pattern.Variable(cid(name), None())
      case p"${lit: Lit}" => AST.Pattern.Literal(translateLit(lit))
      case _ =>
        errorInSlang(pat.pos, s"Invalid pattern: '${syntax(pat)}'")
        AST.Pattern.Wildcard(None())
    }
  }

  def translatePatternArg(patArg: Term.Arg): AST.Pattern = patArg match {
    case arg"${expr: Term}" => translatePattern(expr)
    case _ =>
      errorInSlang(patArg.pos, s"Invalid pattern: '${syntax(patArg)}'")
      AST.Pattern.Wildcard(None())
  }

  def translateTypeParam(tp: Type.Param): AST.TypeParam = tp match {
    case tparam"..$mods $tparamname[..$tparams] >: ${stpeopt: scala.Option[Type]} <: ${tpeopt: scala.Option[Type]} <% ..$tpes : ..$tpes2" =>
      if (mods.nonEmpty || tparams.nonEmpty || stpeopt.nonEmpty || tpes.nonEmpty || tpes2.nonEmpty)
        errorInSlang(tp.pos, "Only type parameters of the forms '〈ID〉' or '〈ID〉<:〈type〉' are")
      AST.TypeParam(cid(tparamname), opt(tpeopt.map(translateType)))
  }

  def translateParam(tp: Term.Param): AST.Param = {
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
      errorInSlang(tp.pos, s"The parameter should have the form '$pure〈ID〉:〈type〉'")
    }
    atpeopt.map(ta => AST.Param(hasPure, cid(paramname), translateTypeArg(ta))).
      getOrElse(AST.Param(hasPure, cid(paramname), unitType))
  }

  def translateBlock(enclosing: Enclosing.Type, stat: Term.Block, isAssignExp: Boolean): AST.Stmt.Block = {
    enclosing match {
      case Enclosing.Top | Enclosing.Method | Enclosing.Block =>
        val stmts =
          if (isAssignExp) translateStmtsExp(stat.pos, stat.stats)
          else ISZ(stat.stats.map(translateStat(Enclosing.Block)): _*)
        AST.Stmt.Block(AST.Body(stmts), attr(stat.pos))
      case _ =>
        if (isWorksheet) errorInSlang(stat.pos, "Code-blocks can only appear at the top-level, inside methods, or other code blocks")
        else errorInSlang(stat.pos, "Code-blocks can only appear inside methods or other code blocks")
        AST.Stmt.Block(AST.Body(ISZ()), emptyAttr)
    }
  }

  def translateExtend(cc: Ctor.Call): AST.Type = {
    def f(t: Term): ISZ[AST.Id] = t match {
      case ctor"${ctorname: Ctor.Name}" => ISZ(cid(ctorname))
      case ctor"$ref.$ctorname" => f(ref) :+ cid(ctorname)
      case q"${name: Term.Name}" => ISZ(cid(name))
      case q"$expr.$name" => f(expr) :+ cid(name)
      case _ =>
        errorNotSlang(t.pos, s"Super constructor call: '${syntax(t)}' is")
        ISZ(rDollarId)
    }

    cc match {
      case ctor"$ctorref[..$atpesnel]" => AST.Type.Named(
        AST.Name(f(ctorref), attr(ctorref.pos)), ISZ(atpesnel.map(translateType): _*), typedAttr(cc.pos))
      case _ => AST.Type.Named(AST.Name(f(cc), attr(cc.pos)), ISZ(), typedAttr(cc.pos))
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
      case mod"varparam" if !isDatatype => isVar = true
      case _ =>
        hasError = true
        if (isDatatype) error(mod.pos, s"Unallowed modifier '${syntax(mod)}' for a Slang @datatype class.")
        else error(mod.pos, s"Unallowed modifier '${syntax(mod)}' for a Slang @record class.")
    }
    if (atpeopt.isEmpty || expropt.nonEmpty) {
      hasError = true
      val hidden = if (hasHidden) "@hidden " else ""
      val pure = if (hasPure) "@pure" else ""
      errorInSlang(tp.pos, s"The abstract dataype parameter should have the form '$hidden$pure〈ID〉:〈type〉'")
    }
    if (hasError) AST.AbstractDatatypeParam(hasHidden, hasPure, cid(paramname), unitType)
    else AST.AbstractDatatypeParam(hasHidden, hasPure, cid(paramname), translateTypeArg(atpeopt.get))
  }

  def stmtCheck(enclosing: Enclosing.Type, stat: Term, kind: Predef.String): Boolean = enclosing match {
    case Enclosing.Top | Enclosing.Method | Enclosing.Block => false
    case _ =>
      if (isWorksheet) errorInSlang(stat.pos, s"$kind can only appear at the top-level, inside methods, or code blocks")
      else errorInSlang(stat.pos, s"$kind can only appear inside methods or code blocks")
      true
  }

  def translateAssign(enclosing: Enclosing.Type, stat: Term.Assign): AST.Stmt = {
    stmtCheck(enclosing, stat, "Assigments")
    AST.Stmt.Assign(translateExp(stat.lhs), translateAssignExp(stat.rhs), attr(stat.pos))
  }

  def translateAssign(enclosing: Enclosing.Type, stat: Term.Update): AST.Stmt = {
    def expArg(arg: Term.Arg): AST.Exp = arg match {
      case arg"${expr: Term}" => translateExp(expr)
    }

    def patArg(arg: Term.Arg): AST.Pattern = arg match {
      case arg"${expr: Term}" => translatePattern(expr)
      case _ =>
        error(arg.pos, "Slang non-tuple pat should be of the form: 'pat(〈pattern〉) = ...'")
        AST.Pattern.Wildcard(None())
    }

    def patVar(arg: Term.Arg): AST.Pattern = arg match {
      case arg: Term.Name => AST.Pattern.Variable(cid(arg), None())
    }

    stmtCheck(enclosing, stat, "Assigments")
    stat.fun match {
      case Term.Name("up") =>
        if (stat.argss.size == 1 && stat.argss.head.size == 1 && stat.argss.head.head.isInstanceOf[Term])
          AST.Stmt.AssignUp(expArg(stat.argss.head.head), translateAssignExp(stat.rhs), attr(stat.pos))
        else {
          error(stat.pos, "Slang up should be of the form: 'up(...) = ...'")
          rStmt
        }
      case Term.Name("pat") =>
        if (stat.argss.size == 1) {
          val args = stat.argss.head
          if (args.length > 1) {
            if (args.forall({
              case q"${_: Term.Name}" => true
              case _ => false
            })) {
              AST.Stmt.AssignPattern(AST.Pattern.Structure(None(), None(),
                ISZ(args.map(patVar): _*)), translateAssignExp(stat.rhs), attr(stat.pos))
            } else {
              error(stat.pos, "Slang tuple pat should be of the form: 'pat(〈ID〉,〈ID〉, ... ) = ...'")
              rStmt
            }
          } else {
            AST.Stmt.AssignPattern(patArg(args.head), translateAssignExp(stat.rhs), attr(stat.pos))
          }
        } else {
          error(stat.pos, "Slang pat should be of the form: 'pat(...) = ...'")
          rStmt
        }
      case _ =>
        var lhs = translateExp(stat.fun)
        var prevPos = stat.fun.pos
        if (stat.argss.nonEmpty) {
          for (args <- stat.argss) {
            val pos =
              if (args.nonEmpty) Position.Range(args.head.pos.input, args.head.pos.start, args.last.pos.end)
              else prevPos
            lhs = translateApply(lhs, args, pos)
          }
        } else {
          errorInSlang(stat.pos, s"Invalid update form: '${syntax(stat)}'")
        }
        AST.Stmt.Assign(lhs, translateAssignExp(stat.rhs), attr(stat.pos))
    }
  }

  def translateIfStmt(enclosing: Enclosing.Type,
                      stat: Term.If,
                      isAssignExp: Boolean): AST.Stmt.If = {
    var hasError = stmtCheck(enclosing, stat, "If-statements")
    if (!stat.thenp.isInstanceOf[Term.Block]) {
      hasError = true
      errorInSlang(stat.thenp.pos, "If-then part should be a code block")
    }
    stat.elsep match {
      case _: Term.Block | _: Term.If | _: Lit.Unit =>
      case _ =>
        hasError = true
        errorInSlang(stat.elsep.pos, "If-else part should be either a code block or another if-conditional.")
    }
    val cond = translateExp(stat.cond)
    if (hasError) AST.Stmt.If(cond, AST.Body(ISZ()), AST.Body(ISZ()), emptyAttr)
    else ((stat.thenp, stat.elsep): @unchecked) match {
      case (thenp: Term.Block, elsep: Term.Block) =>
        AST.Stmt.If(cond,
          AST.Body(
            if (isAssignExp) translateStmtsExp(thenp.pos, thenp.stats)
            else ISZ(thenp.stats.map(translateStat(enclosing)): _*)),
          AST.Body(
            if (isAssignExp) translateStmtsExp(elsep.pos, elsep.stats)
            else ISZ(elsep.stats.map(translateStat(enclosing)): _*)),
          attr(stat.pos))
      case (thenp: Term.Block, elsep: Term.If) =>
        AST.Stmt.If(cond,
          AST.Body(
            if (isAssignExp) translateStmtsExp(thenp.pos, thenp.stats)
            else ISZ(thenp.stats.map(translateStat(enclosing)): _*)),
          AST.Body(ISZ(translateIfStmt(Enclosing.Block, elsep, isAssignExp))),
          attr(stat.pos))
      case (thenp: Term.Block, elsep: Lit.Unit) =>
        if (isAssignExp) error(elsep.pos, "Expecting a code block with an expression.")
        AST.Stmt.If(cond,
          AST.Body(ISZ(thenp.stats.map(translateStat(enclosing)): _*)),
          AST.Body(ISZ()),
          attr(stat.pos))
    }
  }

  def translateMatch(enclosing: Enclosing.Type, stat: Term.Match, isAssignExp: Boolean): AST.Stmt.Match = {
    def translateCase(stat: Case): AST.Case = {
      AST.Case(translatePattern(stat.pat), opt(stat.cond.map(translateExp)), stat.body match {
        case b: Term.Block => AST.Body(
          if (isAssignExp) translateStmtsExp(b.pos, b.stats)
          else ISZ(b.stats.map(translateStat(Enclosing.Block)): _*))
        case b: Term if isAssignExp =>
          AST.Body(
            if (isAssignExp) ISZ(AST.Stmt.Expr(translateExp(b), attr(b.pos)))
            else ISZ(translateStat(Enclosing.Block)(b)))
        case b if isAssignExp =>
          error(stat.body.pos, s"Expecting an expression but '${syntax(b)}' found.")
          AST.Body(ISZ())
        case b => AST.Body(ISZ(translateStat(Enclosing.Block)(b)))
      })
    }

    stmtCheck(enclosing, stat, "Match-statements")
    AST.Stmt.Match(translateExp(stat.expr),
      ISZ(stat.cases.map(translateCase): _*),
      attr(stat.pos))
  }

  def translateWhile(enclosing: Enclosing.Type, stat: Term.While): AST.Stmt = {
    var hasError = stmtCheck(enclosing, stat, "While-statements")
    var invariants: ISZ[AST.ContractExp] = ISZ()
    var mods: ISZ[AST.Exp] = ISZ()
    var stats: Seq[Stat] = Seq()
    stat.body match {
      case body: Term.Block => body.stats match {
        case (l@Term.Interpolate(Term.Name("l"), Seq(_: Lit.String), Nil)) :: rest =>
          val (is, ms) = parseLoopContract(l)
          invariants = is
          mods = ms
          stats = rest
        case (t: Term.Interpolate) :: _ =>
          hasError = true
          error(t.pos, "Expecting a Slang while-loop contract l\"\"\"{ ... }\"\"\" but found '" + syntax(t) + "'.")
        case _ =>
          stats = body.stats
      }
      case _ =>
        hasError = true
        errorInSlang(stat.body.pos, "While-loop body should be a code block")
    }
    if (hasError) rStmt else
      AST.Stmt.While(translateExp(stat.expr), invariants, mods,
        AST.Body(ISZ(stats.map(translateStat(Enclosing.Block)): _*)),
        attr(stat.pos))
  }

  def translateDoWhile(enclosing: Enclosing.Type, stat: Term.Do): AST.Stmt = {
    var hasError = stmtCheck(enclosing, stat, "Do-while-statements")
    var modifies: ISZ[AST.Exp] = ISZ()
    var invariants: ISZ[AST.ContractExp] = ISZ()
    var stats: Seq[Stat] = Seq()
    stat.body match {
      case body: Term.Block => body.stats.lastOption match {
        case scala.Some(l@Term.Interpolate(Term.Name("l"), Seq(_: Lit.String), Nil)) =>
          val (is, ms) = parseLoopContract(l)
          modifies = ms
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
        errorInSlang(stat.body.pos, "Do-While-loop body should be a code block")
    }
    if (hasError) rStmt else
      AST.Stmt.DoWhile(translateExp(stat.expr), invariants, modifies,
        AST.Body(ISZ(stats.map(translateStat(Enclosing.Block)): _*)),
        attr(stat.pos))
  }

  def translateFor(enclosing: Enclosing.Type, stat: Term.For): AST.Stmt = {
    def translateRange(r: Term): AST.Range = r match {
      case q"$start until $end by $by" => AST.Range.Step(isInclusive = false, translateExp(start), expArg(end), Some(expArg(by)))
      case q"$start to $end by $by" => AST.Range.Step(isInclusive = true, translateExp(start), expArg(end), Some(expArg(by)))
      case q"$start until $end" => AST.Range.Step(isInclusive = false, translateExp(start), expArg(end), None())
      case q"$start to $end" => AST.Range.Step(isInclusive = true, translateExp(start), expArg(end), None())
      case q"$s.indices" => AST.Range.Indices(isReverse = false, translateExp(s))
      case q"$s.indices.reverse" => AST.Range.Indices(isReverse = true, translateExp(s))
      case _ => AST.Range.Expr(translateExp(r))
    }

    def expArg(arg: Term.Arg): AST.Exp = arg match {
      case arg"${expr: Term}" => translateExp(expr)
      case _ =>
        errorInSlang(arg.pos, s"Invalid for-statement enumerator argument: '${syntax(arg)}'")
        rExp
    }

    var hasError = stmtCheck(enclosing, stat, "For-statements")
    var modifies: ISZ[AST.Exp] = ISZ()
    var invariants: ISZ[AST.ContractExp] = ISZ()
    var stats: Seq[Stat] = Seq()
    stat.body match {
      case body: Term.Block => body.stats match {
        case (l@Term.Interpolate(Term.Name("l"), Seq(_: Lit.String), Nil)) :: rest =>
          val (is, ms) = parseLoopContract(l)
          modifies = ms
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
        errorInSlang(stat.body.pos, "For-loop body should be a code block")
    }
    if (hasError) rStmt else stat.enums match {
      case Seq(enumerator"${id: Pat.Var.Term} <- $expr", enumerator"if $cond") =>
        AST.Stmt.For(cid(id), translateRange(expr), Some(translateExp(cond)),
          invariants, modifies, AST.Body(ISZ(stats.map(translateStat(Enclosing.Block)): _*)), attr(stat.pos))
      case Seq(enumerator"${id: Pat.Var.Term} <- $expr") =>
        AST.Stmt.For(cid(id), translateRange(expr), None(),
          invariants, modifies, AST.Body(ISZ(stats.map(translateStat(Enclosing.Block)): _*)), attr(stat.pos))
      case _ =>
        errorNotSlang(stat.pos, s"For-loop enumerator: '${syntax(stat)}'"); rStmt
    }
  }

  def translateReturn(enclosing: Enclosing.Type, stat: Term.Return): AST.Stmt = {
    stmtCheck(enclosing, stat, "Return-statements")
    stat.expr match {
      case Lit.Unit(_) => AST.Stmt.Return(None(), attr(stat.pos))
      case _ => AST.Stmt.Return(Some(translateExp(stat.expr)), attr(stat.pos))
    }
  }

  def translateExp(exp: Term): AST.Exp = {
    def fresh(t: Term): ISZ[AST.Id] = t match {
      case t: Term.Name => ISZ(cid(t))
      case t: Term.Tuple => ISZ(t.args.map(arg => cid(arg.asInstanceOf[Term.Name])): _*)
    }

    exp match {
      case exp: Lit => translateLit(exp)
      case exp: Term.Interpolate =>
        if (exp.prefix.value == "s") translateStringInterpolate(exp)
        else translateLit(exp)
      case q"${expr: Term.Interpolate}[..$tpesnel]" if bvs.contains(expr.prefix.value) &&
        expr.args.size == 1 && (expr.parts match {
        case List(Lit.String(_)) => true
        case _ => false
      }) => translateLitBv(isBigEndian = expr.prefix.value == "bb", expr, tpesnel.head)
      case exp: Term.Name =>
        if (exp.value.forall(c => c == '¬' || c == '~' || c == '!')) {
          val l = exp.value.toList.reverse
          var s = s"${l.head}..."
          for (c <- l.tail) {
            s = s"$c($s)"
          }
          error(exp.pos, s"'${exp.value}' should be written as '$s'.")
          rExp
        } else AST.Exp.Ident(cid(exp), resolvedAttr(exp.pos))
      case exp: Term.Eta => AST.Exp.Eta(translateExp(exp.expr), resolvedAttr(exp.pos))
      case exp: Term.Tuple => AST.Exp.Tuple(ISZ(exp.args.map(translateExp): _*), typedAttr(exp.pos))
      case exp: Term.ApplyUnary => translateUnaryExp(exp)
      case exp: Term.ApplyInfix => translateBinaryExp(exp)
      case q"L$$Quant(..$args)" =>
        val es = args.map { case arg"${exp: Term}" => exp }
        es match {
          case Seq(b: Lit.Boolean, q"$ids: $t", e) =>
            AST.Exp.Quant(
              b.value,
              ISZ(AST.VarFragment(fresh(ids),
                Some(AST.Domain.Type(translateType(t), typedAttr(t.pos))))),
              translateExp(e))
          case Seq(b: Lit.Boolean, ids, e) =>
            AST.Exp.Quant(
              b.value,
              ISZ(AST.VarFragment(fresh(ids), None())),
              translateExp(e))
          case Seq(b: Lit.Boolean, ids, tt@Term.Tuple(Seq(lo, loExact: Lit.Boolean, hi, hiExact: Lit.Boolean)), e) =>
            AST.Exp.Quant(
              b.value,
              ISZ(AST.VarFragment(fresh(ids),
                Some(AST.Domain.Range(translateExp(lo), loExact.value, translateExp(hi), hiExact.value, typedAttr(tt.pos))))),
              translateExp(e))
        }
      case q"$expr.$name[..$tpes](...$aexprssnel)" if tpes.nonEmpty =>
        translateInvoke(scala.Some(expr), name, tpes, aexprssnel, Position.Range(expr.pos.input, name.pos.start, exp.pos.end))
      case q"$expr.$name(...$aexprssnel)" =>
        translateInvoke(scala.Some(expr), name, List(), aexprssnel, Position.Range(expr.pos.input, name.pos.start, exp.pos.end))
      case q"${name: Term.Name}[..$tpes](...$aexprssnel)" => translateInvoke(scala.None, name, tpes, aexprssnel, exp.pos)
      case q"${name: Term.Name}(...$aexprssnel)" => translateInvoke(scala.None, name, List(), aexprssnel, exp.pos)
      case q"$expr.$name[..$tpes]" if tpes.nonEmpty =>
        translateSelect(expr, name, tpes, Position.Range(exp.pos.input, name.pos.start, exp.pos.end))
      case q"$expr.$name" => translateSelect(expr, name, List(), name.pos)
      case exp: Term.If => translateIfExp(exp)
      case _ =>
        errorNotSlang(exp.pos, s"Expresion '${syntax(exp)}' is")
        rExp
    }
  }

  def translateLit(lit: Lit): AST.Exp with AST.Lit = lit match {
    case Lit.Boolean(value) => AST.Exp.LitB(value, attr(lit.pos))
    case Lit.Char(value) => AST.Exp.LitC(value, attr(lit.pos))
    case Lit.Int(value) => AST.Exp.LitZ(value, attr(lit.pos))
    case Lit.Long(value) => AST.Exp.LitZ(value, attr(lit.pos))
    case Lit.Float(value) =>
      try AST.Exp.LitF32(value.toFloat, attr(lit.pos))
      catch {
        case _: NumberFormatException =>
          error(lit.pos, "Invalid 32-bit float number form.")
          AST.Exp.LitF32(0.0f, attr(lit.pos))
      }
    case Lit.Double(value) =>
      try AST.Exp.LitF64(value.toDouble, attr(lit.pos))
      catch {
        case _: NumberFormatException =>
          error(lit.pos, "Invalid 64-bit double number form.")
          AST.Exp.LitF64(0.0d, attr(lit.pos))
      }
    case Lit.String(value) => AST.Exp.LitString(value, attr(lit.pos))
    case _ =>
      errorNotSlang(lit.pos, s"Literal '${syntax(lit)}' is")
      AST.Exp.LitB(false, attr(lit.pos))
  }

  def translateLit(lit: Term.Interpolate): AST.Exp with AST.Lit = {
    def toBigInt(value: Predef.String): BigInt = {
      if (value.toUpperCase().startsWith("0X")) BigInt(value.substring(2), 16)
      else BigInt(value)
    }

    def errR = AST.Exp.LitB(false, attr(lit.pos))

    if (text.substring(lit.pos.start.offset, lit.pos.end.offset).startsWith(lit.prefix.value + "\"\"\"")) {
      error(lit.pos, "'" + lit.prefix.value + "\"...\"' should be used instead of '" + lit.prefix.value + "\"\"...\"\"\"'.")
      return errR
    }
    if (lit.args.nonEmpty || !(lit.parts match {
      case List(Lit.String(_)) => true
      case _ => false
    })) {
      errorNotSlang(lit.pos, s"Literal '${syntax(lit)}' is")
      return errR
    }
    val List(Lit.String(value)) = lit.parts
    try {
      val r = lit.prefix.value match {
        case "z" => AST.Exp.LitZ(Numbers.toZ(toBigInt(value)), attr(lit.pos))
        case "z8" => AST.Exp.LitZ8(Numbers.toZ8(toBigInt(value)), attr(lit.pos))
        case "z16" => AST.Exp.LitZ16(Numbers.toZ16(toBigInt(value)), attr(lit.pos))
        case "z32" => AST.Exp.LitZ32(Numbers.toZ32(toBigInt(value)), attr(lit.pos))
        case "z64" => AST.Exp.LitZ64(Numbers.toZ64(toBigInt(value)), attr(lit.pos))
        case "n" => AST.Exp.LitN(Numbers.toN(toBigInt(value)), attr(lit.pos))
        case "n8" => AST.Exp.LitN8(Numbers.toN8(toBigInt(value)), attr(lit.pos))
        case "n16" => AST.Exp.LitN16(Numbers.toN16(toBigInt(value)), attr(lit.pos))
        case "n32" => AST.Exp.LitN32(Numbers.toN32(toBigInt(value)), attr(lit.pos))
        case "n64" => AST.Exp.LitN64(Numbers.toN64(toBigInt(value)), attr(lit.pos))
        case "s8" => AST.Exp.LitS8(Numbers.toS8Exact(toBigInt(value)), attr(lit.pos))
        case "s16" => AST.Exp.LitS16(Numbers.toS16Exact(toBigInt(value)), attr(lit.pos))
        case "s32" => AST.Exp.LitS32(Numbers.toS32Exact(toBigInt(value)), attr(lit.pos))
        case "s64" => AST.Exp.LitS64(Numbers.toS64Exact(toBigInt(value)), attr(lit.pos))
        case "u8" => AST.Exp.LitU8(Numbers.toU8Exact(toBigInt(value)), attr(lit.pos))
        case "u16" => AST.Exp.LitU16(Numbers.toU16Exact(toBigInt(value)), attr(lit.pos))
        case "u32" => AST.Exp.LitU32(Numbers.toU32Exact(toBigInt(value)), attr(lit.pos))
        case "u64" => AST.Exp.LitU64(Numbers.toU64Exact(toBigInt(value)), attr(lit.pos))
        case "f32" => AST.Exp.LitF32(Numbers.toF32(value.toFloat), attr(lit.pos))
        case "f64" => AST.Exp.LitF64(Numbers.toF64(value.toDouble), attr(lit.pos))
        case "r" => AST.Exp.LitR(Numbers.toR(value), attr(lit.pos))
      }
      return r
    } catch {
      case e: IllegalArgumentException =>
      case e: NumberFormatException =>
    }
    error(lit.pos, s"Invalid ${lit.prefix.value.toUpperCase} number: '${syntax(lit)}'")
    AST.Exp.LitB(false, attr(lit.pos))
  }

  def translateLitBv(isBigEndian: Boolean,
                     lit: Term.Interpolate,
                     indexType: Type): AST.Exp with AST.Lit = {
    val List(Lit.String(v)) = lit.parts
    val v2 = v.filter(_.isWhitespace).toLowerCase
    if (v2.startsWith("0x")) {
      val v3 = if (isBigEndian) v2.substring(2).reverse else v2.substring(2)
      val size = v3.length * 4
      val bs = scala.collection.mutable.BitSet(size)
      for (i <- v3.indices) {
        val n = v3(i) match {
          case '0' => 0
          case '1' => 1
          case '2' => 2
          case '3' => 3
          case '4' => 4
          case '5' => 5
          case '6' => 6
          case '7' => 7
          case '8' => 8
          case '9' => 9
          case 'a' => 10
          case 'b' => 11
          case 'c' => 12
          case 'd' => 13
          case 'e' => 14
          case 'f' => 15
          case _ =>
            error(lit.pos, s"Invalid bit-vector literal: '${syntax(lit)}'")
            return AST.Exp.LitB(false, attr(lit.pos))
        }
        for (j <- 0 until 4 if (1 << j & n) != 0) {
          bs += (i * 4 + j)
        }
      }
      AST.Exp.LitBv(ISZ((0 until size).map(bs(_): B): _*),
        translateType(indexType), attr(lit.pos)) // TODO: Optimize ISZ for B
    } else {
      val v3 = if (isBigEndian) v2.reverse else v2
      val size = v3.length
      val bs = scala.collection.mutable.BitSet(size)
      for (i <- v3.indices) {
        v3(i) match {
          case '0' =>
          case '1' => bs += i
          case _ =>
            error(lit.pos, s"Invalid bit-vector literal: '${syntax(lit)}'")
            return AST.Exp.LitB(false, attr(lit.pos))
        }
      }
      AST.Exp.LitBv(ISZ((0 until size).map(bs(_): B): _*),
        translateType(indexType), attr(lit.pos)) // TODO: Optimize ISZ for B
    }
  }

  def translateStringInterpolate(s: Term.Interpolate): AST.Exp.StringInterpolate =
    AST.Exp.StringInterpolate(
      ISZ(s.parts.map({
        case Lit.String(value) => AST.Exp.LitString(value, attr(s.pos))
        case _ =>
          error(s.pos, s"Invalid string interpolation: '${syntax(s)}'")
          AST.Exp.LitString("", attr(s.pos))
      }): _*),
      ISZ(s.args.map(translateExp): _*), attr(s.pos))

  def translateUnaryExp(t: Term.ApplyUnary): AST.Exp = {
    unops.get(t.op.value) match {
      case scala.Some(op) => AST.Exp.Unary(op, translateExp(t.arg), typedAttr(t.op.pos))
      case _ =>
        errorInSlang(t.op.pos, s"'${t.op.value}' is not a unary operator")
        rExp
    }
  }

  def translateBinaryExp(t: Term.ApplyInfix): AST.Exp = {
    def expArg(arg: Term.Arg): AST.Exp = arg match {
      case arg"${expr: Term}" => translateExp(expr)
      case _ =>
        errorInSlang(arg.pos, s"Invalid righ-hand-side for '${t.op.value}': '${syntax(arg)}'")
        rExp
    }

    if (t.targs.nonEmpty)
      errorInSlang(t.targs.head.pos, "Binary operations cannot have type arguments")

    t.args match {
      case List(right) =>
        binops.get(t.op.value) match {
          case scala.Some(op) => AST.Exp.Binary(translateExp(t.lhs), op, expArg(right), typedAttr(t.op.pos))
          case _ =>
            errorInSlang(t.op.pos, s"'${t.op.value}' is not a binary operator")
            rExp
        }
      case _ =>
        error(t.op.pos, s"Invalid righ-hand-side for '${t.op.value}': '(..${t.args.map(_.syntax)})'")
        rExp
    }
  }

  def translateInvoke(receiverOpt: scala.Option[Term], name: Term.Name,
                      tpes: Seq[Type], argss: Seq[Seq[Term.Arg]], pos: Position): AST.Exp = {
    def translateArgss(argss: Seq[Seq[Term.Arg]]): Either[ISZ[AST.NamedArg], ISZ[AST.Exp]] = {
      if (argss.isEmpty) return Right(ISZ())
      translateArgs(argss.head)
    }

    var r: AST.Exp = translateArgss(argss) match {
      case Left(args) => AST.Exp.InvokeNamed(opt(receiverOpt.map(translateExp)), cid(name),
        ISZ(tpes.map(translateType): _*), args, resolvedAttr(pos))
      case Right(args) => AST.Exp.Invoke(opt(receiverOpt.map(translateExp)), cid(name),
        ISZ(tpes.map(translateType): _*), args, resolvedAttr(pos))
    }
    var prevPos = name.pos
    for (i <- 1 until argss.size) {
      val args = argss(i)
      val pos =
        if (args.nonEmpty) Position.Range(args.head.pos.input, args.head.pos.start, args.last.pos.end)
        else prevPos
      prevPos = pos
      r = translateApply(r, argss(i), pos)
    }
    r
  }

  def translateSelect(receiver: Term, name: Term.Name, tpes: Seq[Type], pos: Position): AST.Exp = {
    AST.Exp.Select(Some(translateExp(receiver)), cid(name), ISZ(tpes.map(translateType): _*), resolvedAttr(pos))
  }

  def translateIfExp(exp: Term.If): AST.Exp = {
    var hasError = false
    if (exp.thenp.isInstanceOf[Term.Block]) {
      hasError = true
      errorInSlang(exp.thenp.pos, "If-then expression should not be a code block")
    }
    exp.elsep match {
      case elsep: Term.Block =>
        hasError = true
        errorInSlang(elsep.pos, "If-else expression should not be a code block")
      case elsep: Lit.Unit =>
        hasError = true
        errorInSlang(elsep.pos, "If-else expression should not be empty")
      case _ =>
    }
    if (hasError) rExp
    else AST.Exp.If(translateExp(exp.cond), translateExp(exp.thenp), translateExp(exp.elsep), typedAttr(exp.pos))
  }

  def translateArgs(args: Seq[Term.Arg]): Either[ISZ[AST.NamedArg], ISZ[AST.Exp]] = {
    def expArg(arg: Term.Arg): AST.Exp = arg match {
      case arg"${expr: Term}" => translateExp(expr)
    }

    def namedArg(arg: Term.Arg): AST.NamedArg = arg match {
      case arg: Term.Arg.Named => AST.NamedArg(cid(arg.name), expArg(arg.expr))
    }

    var isNamed = false
    var isPositional = false
    for (arg <- args) arg match {
      case _: Term.Arg.Repeated =>
        errorInSlang(arg.pos, s"Repeated argument: '${syntax(arg)}'")
        return Right(ISZ())
      case _: Term.Arg.Named => isNamed = true
      case _ => isPositional = true
    }
    if (isNamed && isPositional) {
      errorInSlang(args.head.pos, "Cannot mix positional and named arguments")
      Right(ISZ())
    } else if (isNamed) Left(ISZ(args.map(namedArg): _*))
    else Right(ISZ(args.map(expArg): _*))
  }

  def translateApply(fun: AST.Exp, termArgs: Seq[Term.Arg], pos: Position): AST.Exp =
    translateArgs(termArgs) match {
      case Left(args) => AST.Exp.InvokeNamed(Some(fun), cidNoCheck("apply", pos), ISZ(), args, resolvedAttr(pos))
      case Right(args) => AST.Exp.Invoke(Some(fun), cidNoCheck("apply", pos), ISZ(), args, resolvedAttr(pos))
    }

  def checkLSyntax(exp: Term.Interpolate): Boolean = {
    val startOffset = exp.pos.start.offset
    val c = text.charAt(startOffset)
    if (!text.substring(startOffset + 1, exp.pos.end.offset).startsWith("\"\"\"")) {
      error(exp.pos, "'" + c + "\"\"\"...\"\"\"' should be used instead of '" + c + "\"...\"'.")
      false
    } else true
  }

  def lParser[T](exp: Term.Interpolate)(f: LParser => T): T = {
    val start = exp.pos.start
    val startOffset = start.offset + 4
    val startLine = start.line
    val startColum = start.column
    val endOffset = exp.pos.end.offset - 3
    lPointOpt = scala.Some((startOffset, startLine, startColum))
    try f(new LParser(Input.Slice(input, startOffset, endOffset), dialect, this))
    catch {
      case e: ParseException => throw ParseException(
        Position.Range(input, startOffset + e.pos.start.offset,
          startOffset + e.pos.end.offset), e.shortMessage)
      case e: TokenizeException => throw TokenizeException(
        Position.Range(input, startOffset + e.pos.start.offset,
          startOffset + e.pos.end.offset), e.shortMessage)
    } finally lPointOpt = scala.None
  }

  def parseDefs(exp: Term.Interpolate): (ISZ[AST.SpecDef], ISZ[AST.WhereDef]) = {
    if (!checkLSyntax(exp)) return (ISZ(), ISZ())
    lParser(exp) { parser =>
      val (sds, wds) = parser.specDefs()
      (ISZ(sds: _*), ISZ(wds: _*))
    }
  }

  def parseContract(exp: Term.Interpolate): AST.Contract = {
    if (!checkLSyntax(exp)) return AST.Contract(ISZ(), ISZ(), ISZ(), ISZ(), ISZ())
    lParser(exp)(_.defContract())
  }

  def parseLStmt(enclosing: Enclosing.Type, exp: Term.Interpolate): AST.Stmt = {
    def isProofSequentContext: Boolean = enclosing match {
      case Enclosing.Top | Enclosing.Object | Enclosing.ExtObject | Enclosing.Method
           | Enclosing.Block | Enclosing.DatatypeClass | Enclosing.RecordClass => true
      case _ => false
    }

    def isInvariantContext: Boolean = enclosing match {
      case Enclosing.Top | Enclosing.Object | Enclosing.ExtObject => true
      case _ => false
    }

    def isFactsTheoremsContext: Boolean = enclosing match {
      case Enclosing.Top | Enclosing.Object | Enclosing.ExtObject
           | Enclosing.DatatypeTrait | Enclosing.DatatypeClass | Enclosing.RecordTrait
           | Enclosing.RecordClass | Enclosing.Sig => true
      case _ => false
    }

    if (!checkLSyntax(exp)) return rStmt
    val clause = lParser(exp)(_.lClause())
    clause match {
      case _: AST.LClause.Sequent if !isProofSequentContext => error(exp.pos, "Invalid sequent location.")
      case _: AST.LClause.Proof if !isProofSequentContext => error(exp.pos, "Invalid proof location.")
      case _: AST.LClause.Invariants if !isInvariantContext => error(exp.pos, "Invalid invariant location.")
      case _: AST.LClause.Facts if !isFactsTheoremsContext => error(exp.pos, "Invalid fact location.")
      case _: AST.LClause.Theorems if !isFactsTheoremsContext => error(exp.pos, "Invalid theorem location.")
      case _ =>
    }
    AST.Stmt.LStmt(clause, attr(exp.pos))
  }

  def parseLoopContract(exp: Term.Interpolate): (ISZ[AST.ContractExp], ISZ[AST.Exp]) = {
    if (!checkLSyntax(exp)) return (ISZ(), ISZ())
    val (invs, mods) = lParser(exp)(_.loopInvMode())
    (ISZ(invs: _*), ISZ(mods: _*))
  }

  def cid(t: Pat.Var.Term): AST.Id = cid(t.name.value, t.pos)

  def cid(name: Term.Name): AST.Id = cid(name.value, name.pos)

  def cid(name: Ctor.Name): AST.Id = cid(name.value, name.pos)

  def cid(name: Type.Param.Name): AST.Id = cid(name.value, name.pos)

  def cid(name: Term.Param.Name): AST.Id = cid(name.value, name.pos)

  def cid(name: Name.Indeterminate): AST.Id = cid(name.value, name.pos)

  def cidNoCheck(id: Predef.String, pos: Position): AST.Id =
    AST.Id(id, attr(pos))

  def cid(id: Predef.String, pos: Position): AST.Id = {
    def isLetter(c: Char): Boolean = ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')

    def isDigit(c: Char): Boolean = '0' <= c && c <= '9'

    def isLetterOrDigit(c: Char): Boolean = isLetter(c) || isDigit(c) || c == '_'

    if (id.head == '_' && id.tail.forall(isDigit)) {
      // OK
    } else if (!(isLetter(id.head) && id.tail.forall(isLetterOrDigit)))
      errorInSlang(pos, s"'$id' is not a valid identifier form (i.e., [a-z,A-Z][a-z,A-Z,0-9]*)")

    cidNoCheck(id, pos)
  }

  def attr(pos: Position): AST.Attr = AST.Attr(posInfoOpt = posInfoOpt(pos))

  def typedAttr(pos: Position): AST.TypedAttr = AST.TypedAttr(posInfoOpt = posInfoOpt(pos), typeOpt = None())

  def resolvedAttr(pos: Position): AST.ResolvedAttr = AST.ResolvedAttr(posInfoOpt = posInfoOpt(pos), resOpt = None(), typeOpt = None())

  def posInfoOpt(pos: Position): Option[AST.PosInfo] = {
    val (startOffset, startLine, startColumn) = lPointOpt.getOrElse((0, 0, 0))
    Some(AST.PosInfo(
      fileUriOpt = fileUriOpt match {
        case scala.Some(uri) => Some(uri)
        case _ => None[String]()
      },
      beginLine = startLine + pos.start.line - 1,
      beginColumn = startColumn + pos.start.column - 1,
      endLine = startLine + pos.end.line - 1,
      endColumn = startColumn + pos.end.column - 1,
      offset = startOffset + pos.start.offset,
      length = pos.end.offset - pos.start.offset + 1
    ))
  }

  def ref2IS(ref: Term.Ref): ISZ[AST.Id] = {
    def f(t: Term): ISZ[AST.Id] = t match {
      case q"${name: Term.Name}" => ISZ(cid(name))
      case q"$expr.$name" => f(expr) :+ cid(name)
      case _ => errorInSlang(t.pos, s"Invalid name reference '${ref.syntax}'")
        ISZ(rDollarId)
    }

    f(ref)
  }

  def syntax(t: Tree, max: Int = 20): Predef.String = {
    val startOffset = lPointOpt.map(_._1).getOrElse(0)
    val text = this.text.substring(startOffset + t.pos.start.offset, startOffset + t.pos.end.offset)
    (if (text.length < max) text else text.substring(0, max) + "...").map {
      case '\r' => ' '
      case '\t' => ' '
      case '\n' => ' '
      case c => c
    }
  }

  def opt[T](opt: scala.Option[T]): Option[T] = opt match {
    case scala.Some(x) => Some(x)
    case _ => None()
  }
}
