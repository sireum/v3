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

import org.sireum.lang.util.Reporter
import org.sireum.lang.{ast => AST}
import org.sireum.{B, ISZ, None, Option, Some, String, Z}

import scala.meta._
import scala.meta.internal.parsers.ScalametaParser
import scala.util.{Success, Try}

object SlangParser {

  val messageKind = "Slang Parser"

  val bvs: Set[Predef.String] = Set("bb", "bl")

  val unops: Map[Predef.String, AST.Exp.UnaryOp.Type] = Map(
    "!" -> AST.Exp.UnaryOp.Not,
    "+" -> AST.Exp.UnaryOp.Plus,
    "-" -> AST.Exp.UnaryOp.Minus,
    "~" -> AST.Exp.UnaryOp.Complement,
    "¬" -> AST.Exp.UnaryOp.Not
  )

  val builtinPrefix = Seq("z", "r", "c", "string", "f32", "f64")

  val disallowedTypeIds = Seq("Unit", "Nothing")

  val disallowedMethodIds = Seq(
    "assert",
    "assume",
    "print",
    "println",
    "eprint",
    "eprintln",
    "halt",
    "native",
    "apply",
    "unapply",
    "unapplySeq",
    "~>",
    "==",
    "!="
  )

  val disallowedMethodIdEndings = Seq("old", "result", "reads", "modifies", "pre", "requires", "post", "ensures", "=")

  val unaryMethods = Seq("unary_!", "unary_+", "unary_-", "unary_~")

  val topLevelMethodsIds = Seq("assert", "assume", "print", "println", "eprint", "eprintln", "halt")

  def scalaDialect(isWorksheet: Boolean): Dialect =
    if (isWorksheet)
      scala.meta.dialects.Scala212.copy(allowToplevelTerms = true, allowLiteralTypes = true, allowTrailingCommas = true)
    else scala.meta.dialects.Scala212.copy(allowLiteralTypes = true, allowTrailingCommas = true)

  case class Result(text: Predef.String, hashSireum: Boolean, unitOpt: Option[AST.TopUnit])

  def apply(
    isWorksheet: Boolean,
    isDiet: Boolean,
    fileUriOpt: Option[String],
    text: Predef.String,
    reporter: Reporter
  ): Result =
    apply(allowSireumPackage = false, isWorksheet, isDiet, fileUriOpt, text, reporter)

  def apply(
    allowSireumPackage: Boolean,
    isWorksheet: Boolean,
    isDiet: Boolean,
    fileUriOpt: Option[String],
    txt: Predef.String,
    reporter: Reporter
  ): Result = {
    val text = txt.replaceAllLiterally("\r\n", "\n") // WORKAROUND: scalameta crlf issues
    val i = text.indexOf('\n')
    val sb = new _root_.java.lang.StringBuilder
    if (i >= 0) {
      for (j <- 0 until i) text(j) match {
        case '\t' | '\r' | ' ' =>
        case c => sb.append(c)
      }
    }
    val firstLine = sb.toString
    val hashSireum = firstLine.contains("#Sireum")
    val (dialect, input) = scalaDialect(isWorksheet)(text)
    new SlangParser(text, input, dialect, allowSireumPackage, hashSireum, isWorksheet, isDiet, fileUriOpt, reporter)
      .parseTopUnit()
  }

  def isDollar(t: Term): Boolean = t match {
    case t: Term.Name if t.value == "$" => true
    case _ => false
  }

  def hasSelfType(p: Self): Boolean = p.name.value != "" || p.decltpe.nonEmpty

  private[SlangParser] lazy val emptyAttr = AST.Attr(posOpt = None())
  private[SlangParser] lazy val emptyTypedAttr = AST.TypedAttr(posOpt = None(), typedOpt = None())
  private[SlangParser] lazy val emptyResolvedAttr =
    AST.ResolvedAttr(posOpt = None(), resOpt = None(), typedOpt = None())

  private[SlangParser] lazy val rDollarId = AST.Id("$", emptyAttr)
  private[SlangParser] lazy val rExp = AST.Exp.Ident(rDollarId, emptyResolvedAttr)
  private[SlangParser] lazy val rStmt = AST.Stmt.Expr(rExp, emptyAttr)
  private[SlangParser] lazy val emptyContract = AST.Contract(ISZ(), ISZ(), ISZ(), ISZ(), ISZ())

}

import SlangParser._

class SlangParser(
  text: Predef.String,
  input: Input,
  dialect: Dialect,
  allowSireumPackage: Boolean,
  hashSireum: Boolean,
  isWorksheet: Boolean,
  isDiet: Boolean,
  fileUriOpt: Option[String],
  reporter: Reporter
) {
  var lPointOpt: scala.Option[Int] = scala.None

  def parseTopUnit(): Result = {
    try {
      if (fileUriOpt.getOrElse("").value.endsWith(".scala")) {
        if (hashSireum) {
          val parser = new ScalametaParser(input, dialect)
          translateSource(parser.parseSource())
        } else Result(text, hashSireum, None())
      } else {
        val parser = new ScalametaParser(input, dialect)
        val oldIn = parser.in
        parser.in = oldIn.fork
        parser.next()
        parser.newLinesOpt()
        if (parser.isIdentOf("*")) {
          new LParser(input, dialect, this).truthTable(fileUriOpt)
        } else if (parser.token.is[Token.KwPackage] || parser.token.is[Token.KwImport] || parser.token.is[Token.EOF]) {
          parser.in = oldIn
          translateSource(parser.parseSource())
        } else {
          new LParser(input, dialect, this).sequentFile(fileUriOpt)
        }
      }
    } catch {
      case e: ParseException =>
        error(e.pos, e.shortMessage)
        Result(text, hashSireum, None())
      case e: TokenizeException =>
        error(e.pos, e.shortMessage)
        Result(text, hashSireum, None())
      case e: Throwable =>
        e.printStackTrace()
        reporter.error(None(), messageKind, s"Parsing error: ${e.getMessage}.")
        Result(text, hashSireum, None())
    }
  }

  def posInfo(pos: Position): AST.PosInfo = {
    val startOffset = lPointOpt.getOrElse(0)
    val range = Position.Range(input, startOffset + pos.start, startOffset + pos.end)
    AST.PosInfo(
      fileUriOpt = fileUriOpt,
      beginLine = range.startLine + 1,
      beginColumn = range.startColumn + 1,
      endLine = range.endLine + 1,
      endColumn = range.endColumn + 1,
      offset = range.start,
      length = range.end - range.start
    )
  }

  def posOpt(pos: Position): Option[AST.PosInfo] = Some(posInfo(pos))

  def error(pos: Position, message: Predef.String): Unit =
    reporter.error(posOpt(pos), SlangParser.messageKind, message)

  val unitType = AST.Type.Named(AST.Name(ISZ(AST.Id("Unit", emptyAttr)), emptyAttr), ISZ(), emptyTypedAttr)

  def errorNotSlang(pos: Position, message: Predef.String): Unit =
    error(pos, message + " not in Slang.")

  def errorInSlang(pos: Position, message: Predef.String): Unit =
    error(pos, message + " in Slang.")

  def translateSource(source: Source): Result = {
    def topF(rest: List[Stat]): Result = {
      val shouldParse = fileUriOpt.forall(
        fileUri =>
          fileUri.value.endsWith(".logika") ||
            fileUri.value.endsWith(".slang") ||
            fileUri.value.endsWith(".sc") ||
            (hashSireum && fileUri.value.endsWith(".scala"))
      )
      if (shouldParse)
        Result(
          text,
          hashSireum,
          Some(
            AST.TopUnit.Program(
              fileUriOpt,
              AST.Name(ISZ(), emptyAttr),
              bodyCheck(checkNestedMethods(ISZ(rest.map(translateStat(Enclosing.Top)): _*)), ISZ())
            )
          )
        )
      else
        Result(text, hashSireum, None())
    }

    source.stats match {
      case List(pkg: Pkg) =>
        val ref = pkg.ref
        val stats = pkg.stats
        if (hashSireum || fileUriOpt.isEmpty || fileUriOpt.get.value.endsWith(".slang")) {
          val name = AST.Name(ref2IS(ref), attr(ref.pos))
          val refSyntax = ref.syntax
          if (refSyntax == "org.sireum" || refSyntax.startsWith("org.sireum.")) {
            if (allowSireumPackage)
              Result(
                text,
                hashSireum,
                Some(
                  AST.TopUnit.Program(
                    fileUriOpt,
                    name,
                    bodyCheck(checkNestedMethods(ISZ(stats.map(translateStat(Enclosing.Package)): _*)), ISZ())
                  )
                )
              )
            else {
              errorInSlang(ref.pos, s"Cannot define members of the $refSyntax package")
              Result(text, hashSireum, None())
            }
          } else {
            def packageF(rest: List[Stat]) =
              Result(
                text,
                hashSireum,
                Some(
                  AST.TopUnit.Program(
                    fileUriOpt,
                    name,
                    bodyCheck(checkNestedMethods(ISZ(rest.map(translateStat(Enclosing.Package)): _*)), ISZ())
                  )
                )
              )

            stats match {
              case q"import org.sireum._" :: rest => packageF(stats)
              case q"import org.sireum.logika._" :: rest => packageF(stats)
              case _ =>
                errorInSlang(ref.pos, "The first member of packages should be 'import org.sireum._'")
                Result(text, hashSireum, None())
            }
          }
        } else Result(text, hashSireum, None())
      case q"import org.sireum._" :: rest => topF(source.stats)
      case q"import org.sireum.logika._" :: rest => topF(source.stats)
      case Nil =>
        Result(
          text,
          hashSireum,
          Some(AST.TopUnit.Program(fileUriOpt, AST.Name(ISZ(), emptyAttr), bodyCheck(ISZ(), ISZ())))
        )
      case stats =>
        if (hashSireum)
          errorInSlang(stats.head.pos, "The first statement should be either 'package <name>' or 'import org.sireum._'")
        Result(text, hashSireum, None())
    }
  }

  def translateStat(enclosing: Enclosing.Type)(stat: Stat): AST.Stmt = {
    val r: AST.Stmt = stat match {
      case stat: Import => translateImport(enclosing, stat)
      case stat: Defn.Val => translateVal(enclosing, stat)
      case stat: Defn.Var => translateVar(enclosing, stat)
      case stat: Decl.Def =>
        checkMethodId(stat.name.pos, stat.name.value)
        translateDef(enclosing, stat)
      case stat: Defn.Def =>
        checkMethodId(stat.name.pos, stat.name.value)
        translateDef(enclosing, stat)
      case stat: Defn.Object =>
        checkTypeId(stat.name.pos, stat.name.value)
        translateObject(enclosing, stat)
      case stat: Defn.Trait =>
        checkTypeId(stat.name.pos, stat.name.value)
        for (mod <- stat.mods.headOption) mod match {
          case mod"@sig" | mod"@msig" | mod"@ext" => return translateSig(enclosing, stat)
          case mod"@datatype" => return translateDatatype(enclosing, stat)
          case mod"@record" => return translateRecord(enclosing, stat)
          case _ =>
        }
        errorNotSlang(stat.pos, s"Statement '${syntax(stat)}' is")
        rStmt
      case stat: Defn.Class =>
        checkTypeId(stat.name.pos, stat.name.value)
        stat match {
          case stat @ q"@range(..$_) class $_" => return translateRangeType(enclosing, stat)
          case stat @ q"@bits(..$_) class $_" => return translateBitsType(enclosing, stat)
          case _ =>
        }
        for (mod <- stat.mods.headOption) mod match {
          case mod"@datatype" => return translateDatatype(enclosing, stat)
          case mod"@record" => return translateRecord(enclosing, stat)
          case _ =>
        }
        errorNotSlang(stat.pos, s"Statement '${syntax(stat)}' is")
        rStmt
      case stat: Defn.Type => translateTypeAlias(enclosing, stat)
      case stat: Term.Assign =>
        stat.lhs match {
          case q"$fun(...${argss: List[List[Term]]})" if argss.nonEmpty =>
            translateAssign(enclosing, fun, argss, stat.rhs, stat)
          case _ => translateAssign(enclosing, stat)
        }
      case stat: Term.Block => translateBlock(enclosing, stat, isAssignExp = false)
      case stat: Term.If => translateIfStmt(enclosing, stat, isAssignExp = false)
      case stat: Term.Match => translateMatch(enclosing, stat, isAssignExp = false)
      case stat: Term.While => translateWhile(enclosing, stat)
      case stat: Term.Do => translateDoWhile(enclosing, stat)
      case stat: Term.For => translateFor(enclosing, stat)
      case stat: Term.Return => translateReturn(enclosing, stat)
      case _: Term.Apply | _: Term.ApplyInfix =>
        val term = stat.asInstanceOf[Term]
        stmtCheck(enclosing, term, s"${syntax(stat)}")
        AST.Stmt.Expr(translateExp(term), attr(stat.pos))
      case stat @ Term.Interpolate(Term.Name("l"), Seq(_: Lit.String), Nil) => parseLStmt(enclosing, stat)
      case _ =>
        errorNotSlang(stat.pos, s"Statement '${stat.syntax}' is")
        rStmt
    }

    val transformer = new AST.Transformer(new AST.Transformer.PrePost[Unit] {
      def string: String = ""

      override def preExpInvoke(ctx: Unit, o: AST.Exp.Invoke): AST.Transformer.PreResult[Unit, AST.Exp] = {
        if (topLevelMethodsIds.contains(o.id.value)) {
          reporter.error(
            o.id.attr.posOpt,
            SlangParser.messageKind,
            s"Method '${o.id.value}' can only be called at the statement level."
          )
        }
        super.preExpInvoke(ctx, o)
      }

      override def preExpInvokeNamed(ctx: Unit, o: AST.Exp.InvokeNamed): AST.Transformer.PreResult[Unit, AST.Exp] = {
        if (topLevelMethodsIds.contains(o.id.value)) {
          reporter.error(
            o.id.attr.posOpt,
            SlangParser.messageKind,
            s"Method '${o.id.value}' cannot be called using named arguments."
          )
        }
        super.preExpInvokeNamed(ctx, o)
      }

    })

    r match {
      case AST.Stmt.Expr(AST.Exp.Invoke(expOpt, AST.Id(id), _, args)) if id.value == "halt" =>
        expOpt.foreach(e => transformer.transformExp((), e))
        for (arg <- args) {
          transformer.transformExp((), arg)
        }
      case r: AST.Stmt.Expr => transformer.transformStmt((), r)
      case r: AST.Stmt.Assign => transformer.transformStmt((), r)
      case r: AST.Stmt.Var => transformer.transformStmt((), r)
      case r: AST.Stmt.VarPattern => transformer.transformStmt((), r)
      case r: AST.Stmt.Return => transformer.transformStmt((), r)
      case r: AST.Stmt.Match => transformer.transformExp((), r.exp)
      case r: AST.Stmt.If => transformer.transformExp((), r.cond)
      case r: AST.Stmt.DoWhile => transformer.transformExp((), r.cond)
      case r: AST.Stmt.For => for (eg <- r.enumGens) transformer.transformEnumGenFor((), eg)
      case r: AST.Stmt.While => transformer.transformExp((), r.cond)
      case _ =>
    }

    r
  }

  def translateImport(enclosing: Enclosing.Type, stat: Import): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Method =>
      case _ =>
        if (isWorksheet) errorInSlang(stat.pos, "Imports can only appear at the top-level or inside packages.")
        else errorInSlang(stat.pos, "Imports can only appear inside packages.")
    }
    stat.importers match {
      case Seq(Importer(ref: Term.Ref, Seq(Importee.Wildcard()))) =>
        AST.Stmt.Import(
          ISZ(AST.Stmt.Import.Importer(AST.Name(ref2IS(ref), attr(ref.pos)), Some(AST.Stmt.Import.WildcardSelector()))),
          attr(stat.pos)
        )
      case _ =>
        var importers = ISZ[AST.Stmt.Import.Importer]()
        for (importer <- stat.importers) {
          val ref = ref2IS(importer.ref)
          val name = AST.Name(ref, attr(importer.ref.pos))
          var sels = ISZ[AST.Stmt.Import.NamedSelector]()
          for (importee <- importer.importees) importee match {
            case importee"$finame => $tiname" =>
              sels +:= AST.Stmt.Import.NamedSelector(cid(finame), cid(tiname))
            case importee"${iname: Name.Indeterminate}" =>
              val id = cid(iname)
              sels +:= AST.Stmt.Import.NamedSelector(id, id)
            case _ => errorNotSlang(importee.pos, s"Importee '${importee.syntax}' from ${importer.ref.syntax} is")
          }
          importers +:= AST.Stmt.Import.Importer(name, Some(AST.Stmt.Import.MultiSelector(sels)))
        }
        AST.Stmt.Import(importers, attr(stat.pos))
    }
  }

  def translateVal(enclosing: Enclosing.Type, stat: Defn.Val): AST.Stmt = {
    var hasError = false
    enclosing match {
      case Enclosing.Top | Enclosing.Object | Enclosing.ExtObject | Enclosing.DatatypeClass | Enclosing.RecordClass |
          Enclosing.Method | Enclosing.Block =>
      case _ =>
        hasError = true
        if (isWorksheet)
          errorInSlang(
            stat.pos,
            "Val declarations can only appear at the top-level, inside objects, classes, methods, or code blocks"
          )
        else errorInSlang(stat.pos, "Val declarations can only appear inside objects, classes, methods, or code blocks")
    }
    val mods = stat.mods
    val patsnel = stat.pats
    val tpeopt = stat.decltpe
    val expr = stat.rhs
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
      if (isWorksheet)
        errorInSlang(
          stat.pos,
          "Untyped val declarations can only appear at the top-level, inside methods, or code blocks"
        )
      else errorInSlang(stat.pos, "Untyped val declarations can only appear inside methods or code blocks")
    } else if (patsnel.size != 1) {
      hasError = true
      errorInSlang(stat.pos, "Cannot define multiple vals in a single statement")
    } else if (isDollarExpr && !(hasSpec || enclosing == Enclosing.ExtObject)) {
      hasError = true
      error(stat.pos, "'$' is only allowed in a Slang @ext object or @spec val/var expression.")
    } else if (hasSpec && (!isDollar(expr) || !patsnel.head.isInstanceOf[Pat.Var] || tpeopt.isEmpty)) {
      hasError = true
      errorInSlang(stat.pos, "@spec val declarations should have the form: '@spec val〈ID〉:〈type〉= $'")
    }
    if (hasError) rStmt
    else if (hasSpec)
      AST.Stmt.SpecVar(isVal = true, cid(patsnel.head.asInstanceOf[Pat.Var]), translateType(tpeopt.get), attr(stat.pos))
    else
      patsnel.head match {
        case x: Pat.Var =>
          checkMethodId(x.name.pos, x.name.value)
          val r = AST.Stmt.Var(
            isVal = true,
            cid(x),
            opt(tpeopt.map(translateType)),
            if (isDiet && tpeopt.nonEmpty) None()
            else if (isDollarExpr) None()
            else Some(translateAssignExp(expr)),
            attr(stat.pos)
          )
          if (tpeopt.isEmpty) checkTyped(expr.pos, r.initOpt)
          r
        case pattern: Pat =>
          enclosing match {
            case Enclosing.Method | Enclosing.Block =>
            case _ => errorInSlang(pattern.pos, "Val pattern can only appear inside methods or code blocks")
          }
          val pat = translatePattern(pattern)
          pat match {
            case _: AST.Pattern.Structure =>
            case _ => error(pattern.pos, s"Unallowable val pattern: '${pattern.syntax}'")
          }
          val exp = translateAssignExp(expr)
          val r = AST.Stmt.VarPattern(isVal = true, pat, opt(tpeopt.map(translateType)), exp, attr(stat.pos))
          if (tpeopt.isEmpty) checkTyped(expr.pos, Some(r.init))
          r
      }
  }

  def translateVar(enclosing: Enclosing.Type, stat: Defn.Var): AST.Stmt = {
    var hasError = false
    enclosing match {
      case Enclosing.Top | Enclosing.Object | Enclosing.ExtObject | Enclosing.RecordClass | Enclosing.Method |
          Enclosing.Block =>
      case _ =>
        hasError = true
        if (isWorksheet)
          errorInSlang(
            stat.pos,
            "Val declarations can only appear at the top-level, inside objects, classes, methods, or code blocks"
          )
        else
          errorInSlang(
            stat.pos,
            "Val declarations can only appear inside objects, @record classes, methods, or code blocks"
          )
    }
    val mods = stat.mods
    val patsnel = stat.pats
    val tpeopt = stat.decltpe
    val expropt = stat.rhs
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
      if (isWorksheet)
        errorInSlang(
          stat.pos,
          "Untyped var declarations can only appear at the top-level, inside methods, or code blocks"
        )
      else errorInSlang(stat.pos, "Untyped var declarations can only appear inside methods or code blocks")
    } else if (patsnel.size != 1) {
      hasError = true
      errorInSlang(stat.pos, "Cannot define multiple vars in a single statement")
    } else if (isDollarExpr && !(hasSpec || enclosing == Enclosing.ExtObject)) {
      hasError = true
      error(stat.pos, "'$' is only allowed in a Slang @ext object or @spec val/var expression.")
    } else if (hasSpec && (!isDollarExpr || !patsnel.head.isInstanceOf[Pat.Var] || tpeopt.isEmpty)) {
      hasError = true
      errorInSlang(stat.pos, "@spec val declarations should have the form: '@spec var〈ID〉:〈type〉= $'")
    } else if (expropt.isEmpty) {
      hasError = true
      errorInSlang(stat.pos, "Uninitialized '_' var declarations are disallowed")
    }
    if (hasError) rStmt
    else if (hasSpec)
      AST.Stmt
        .SpecVar(isVal = false, cid(patsnel.head.asInstanceOf[Pat.Var]), translateType(tpeopt.get), attr(stat.pos))
    else
      patsnel.head match {
        case x: Pat.Var =>
          checkMethodId(x.name.pos, x.name.value)
          val r = AST.Stmt.Var(
            isVal = false,
            cid(x),
            opt(tpeopt.map(translateType)),
            if (isDiet && tpeopt.nonEmpty) None()
            else if (isDollarExpr) None()
            else opt(expropt.map(translateAssignExp)),
            attr(stat.pos)
          )
          if (tpeopt.isEmpty) checkTyped(expropt.get.pos, r.initOpt)
          r
        case pattern: Pat =>
          enclosing match {
            case Enclosing.Method | Enclosing.Block =>
            case _ => errorInSlang(pattern.pos, "Var pattern can only appear inside methods or code blocks")
          }
          if (tpeopt.nonEmpty)
            errorInSlang(pattern.pos, "Var pattern cannot be explicitly typed")
          if (expropt.isEmpty)
            errorInSlang(pattern.pos, "Var pattern has to be initialized")
          val pat = translatePattern(pattern)
          pat match {
            case _: AST.Pattern.Structure =>
            case _ => error(pattern.pos, s"Unallowable var pattern: '${pattern.syntax}'")
          }
          val exp = expropt.map(translateAssignExp).getOrElse(AST.Stmt.Expr(rExp, attr(pattern.pos)))
          val r = AST.Stmt.VarPattern(isVal = false, pat, opt(tpeopt.map(translateType)), exp, attr(stat.pos))
          if (tpeopt.isEmpty) checkTyped(expropt.get.pos, Some(r.init))
          r
      }
  }

  def checkTyped(pos: => Position, initOpt: Option[AST.AssignExp]): Unit = {
    var hasError = false

    def check(stmt: Any): Unit = stmt match {
      case AST.Stmt.Expr(_: AST.Exp.If) => hasError = true
      case AST.Stmt.Expr(_: AST.Exp.ForYield) => hasError = true
      case AST.Stmt.Expr(_) =>
      case _ => hasError = true
    }

    initOpt match {
      case Some(s) => check(s)
      case _ =>
    }

    if (hasError) errorInSlang(pos, "Complex initialization should be explicitly typed")
  }

  def translateDef(enclosing: Enclosing.Type, stat: Decl.Def): AST.Stmt = {
    enclosing match {
      case Enclosing.DatatypeTrait | Enclosing.RecordTrait | Enclosing.Sig =>
      case _ => errorInSlang(stat.pos, "Method declarations without a body can only appear inside traits")
    }
    val mods = stat.mods
    val name = stat.name
    val tparams = stat.tparams
    val paramss = stat.paramss
    val tpe = stat.decltpe
    var hasError = false
    if (paramss.size > 1) {
      hasError = true
      errorNotSlang(name.pos, "Methods with multiple parameter tuples are")
    }
    var isPure = false
    var hasOverride = false
    var isHelper = false
    for (mod <- mods) mod match {
      case mod"@pure" =>
        if (isPure) {
          hasError = true
          error(mod.pos, "Redundant @pure.")
        }
        isPure = true
      case mod"@helper" =>
        if (isHelper) {
          hasError = true
          error(mod.pos, "Redundant @helper.")
        }
        isHelper = true
      case mod"override" =>
        if (hasOverride) {
          hasError = true
          error(mod.pos, "Redundant override.")
        }
        hasOverride = true
      case _ =>
        hasError = true
        errorInSlang(mod.pos, s"Only the @pure and/or override method modifiers are allowed for method declarations")
    }
    val (hasParams, params) = paramss.headOption match {
      case scala.Some(ps) => (true, ISZ[AST.Param](ps.map(translateParam(isMemoize = false)): _*))
      case _ => (false, ISZ[AST.Param]())
    }
    val sig =
      AST.MethodSig(isPure, cid(name), ISZ(tparams.map(translateTypeParam): _*), hasParams, params, translateType(tpe))
    val purity = if (isPure) AST.Purity.Pure else AST.Purity.Impure
    AST.Stmt.Method(
      purity,
      hasOverride,
      isHelper,
      sig,
      emptyContract,
      None(),
      attr(stat.pos)
    )
  }

  def translateDef(enclosing: Enclosing.Type, tree: Defn.Def): AST.Stmt = {
    val mods = tree.mods
    val name = tree.name
    val tparams = tree.tparams
    val paramss = tree.paramss
    val tpeopt = tree.decltpe
    val exp = tree.body
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
    var hasOverride = false
    var isMemoize = false
    var isHelper = false
    for (mod <- mods) mod match {
      case mod"@pure" =>
        if (isPure) {
          hasError = true
          error(mod.pos, "Redundant @pure.")
        }
        isPure = true
      case mod"@helper" =>
        if (isHelper) {
          hasError = true
          error(mod.pos, "Redundant @helper.")
        }
        isHelper = true
      case mod"@spec" =>
        if (isSpec) {
          hasError = true
          error(mod.pos, "Redundant @spec.")
        }
        isSpec = true
      case mod"@memoize" =>
        if (isMemoize) {
          hasError = true
          error(mod.pos, "Redundant @memoize.")
        }
        isMemoize = true
      case mod"override" =>
        if (hasOverride) {
          hasError = true
          error(mod.pos, "Redundant override.")
        }
        hasOverride = true
      case _ =>
        hasError = true
        errorInSlang(
          mod.pos,
          s"Only either method modifier @pure, @memoize, @spec, and/or override is allowed for method definitions"
        )
    }
    if (isPure && isMemoize) {
      hasError = true
      errorInSlang(
        mods.head.pos,
        s"Methods cannot be annotated with both @memoize and @pure (@memoize methods are always @pure)"
      )
    }
    if (isPure && isSpec) {
      hasError = true
      errorInSlang(
        mods.head.pos,
        s"Methods cannot be annotated with both @pure and @spec (@spec methods are always @pure)"
      )
    }
    if (isMemoize && isSpec) {
      hasError = true
      errorInSlang(mods.head.pos, s"Methods cannot be annotated with both @memoize and @spec")
    }
    if (hasOverride && isSpec) {
      hasError = true
      errorInSlang(mods.head.pos, s"@spec methods cannot have an override modifier")
    }
    if (hasOverride && isMemoize) {
      hasError = true
      errorInSlang(mods.head.pos, s"@memoize methods cannot have an override modifier")
    }
    if (isSpec && isHelper) {
      hasError = true
      errorInSlang(mods.head.pos, s"@spec methods cannot have a @helper modifier")
    }
    val purity = if (isMemoize) AST.Purity.Memoize else if (isPure) AST.Purity.Pure else AST.Purity.Impure
    val (hasParams, params) = paramss.headOption match {
      case scala.Some(ps) => (true, ISZ[AST.Param](ps.map(translateParam(isMemoize)): _*))
      case _ => (false, ISZ[AST.Param]())
    }
    val sig = AST.MethodSig(
      isMemoize || isPure,
      cid(name),
      ISZ(tparams.map(translateTypeParam): _*),
      hasParams,
      params,
      tpeopt.map(translateType).getOrElse(unitType)
    )

    def body(): AST.Stmt.Method = {
      def err(): AST.Stmt.Method = {
        errorInSlang(exp.pos, "Only block '{ ... }' is allowed for a method body")
        AST.Stmt.Method(
          purity,
          hasOverride,
          isHelper,
          sig,
          emptyContract,
          None(),
          attr(tree.pos)
        )
      }

      exp match {
        case exp: Term.Block =>
          val (mc, bodyOpt) = exp.stats.headOption match {
            case scala.Some(l @ Term.Interpolate(Term.Name("l"), Seq(_: Lit.String), Nil)) =>
              (
                parseContract(l),
                if (isDiet) None[AST.Body]()
                else Some(bodyCheck(ISZ(exp.stats.tail.map(translateStat(Enclosing.Method)): _*), ISZ()))
              )
            case _ =>
              (
                emptyContract,
                if (isDiet) None[AST.Body]()
                else Some(bodyCheck(ISZ(exp.stats.map(translateStat(Enclosing.Method)): _*), ISZ()))
              )
          }
          AST.Stmt.Method(purity, hasOverride, isHelper, sig, mc, bodyOpt, attr(tree.pos))
        case l @ Term.Interpolate(Term.Name("l"), Seq(_: Lit.String), Nil) =>
          enclosing match {
            case Enclosing.Sig | Enclosing.DatatypeTrait | Enclosing.RecordTrait =>
              if (isMemoize) {
                errorInSlang(
                  exp.pos,
                  "Only the @pure and/or override method modifiers are allowed for method declarations"
                )
              }
              AST.Stmt.Method(purity, hasOverride, isHelper, sig, parseContract(l), None(), attr(tree.pos))
            case _ => err()
          }
        case _ => err()
      }
    }

    if (isSpec) {
      if (checkSymbol(sig.id.value.value)) {
        error(name.pos, s"@spec methods cannot be named with an identifier starting with a symbol")
      }
      exp match {
        case exp: Term.Name if exp.value == "$" =>
          AST.Stmt.SpecMethod(sig, ISZ(), ISZ(), attr(tree.pos))
        case exp@Term.Interpolate(Term.Name("l"), Seq(_: Lit.String), Nil) =>
          val (sds, wds) = parseDefs(exp)
          AST.Stmt.SpecMethod(sig, sds, wds, attr(tree.pos))
        case _ =>
          hasError = true
          error(exp.pos, "Only '$' or 'l\"\"\"{ ... }\"\"\"' is allowed as Slang @spec method expression.")
          AST.Stmt.SpecMethod(sig, ISZ(), ISZ(), attr(tree.pos))
      }
    } else if (enclosing == Enclosing.ExtObject) {
      if (checkSymbol(sig.id.value.value)) {
        error(name.pos, s"Extension methods cannot be named with an identifier starting with a symbol")
      }
      if (isHelper)
        errorInSlang(exp.pos, s"Extension methods cannot have a @helper modifier")
      if (hasOverride)
        errorInSlang(exp.pos, s"Extension methods cannot have an override modifier")
      if (isMemoize)
        errorInSlang(exp.pos, s"Extension methods cannot have a @memoize modifier")
      exp match {
        case exp: Term.Name if exp.value == "$" =>
          AST.Stmt.ExtMethod(isPure, sig, emptyContract, attr(tree.pos))
        case exp @ Term.Interpolate(Term.Name("l"), Seq(_: Lit.String), Nil) =>
          AST.Stmt.ExtMethod(isPure, sig, parseContract(exp), attr(tree.pos))
        case _ =>
          hasError = true
          error(exp.pos, "Only '$' or 'l\"\"\"{ ... }\"\"\"' are allowed as Slang extension method expression.")
          AST.Stmt.ExtMethod(isPure, sig, emptyContract, attr(tree.pos))
      }
    } else body()
  }

  def extractStaticZ(exp: Term): Z = {
    def extractString(s: Predef.String): Z = {
      Try(Z.$String(s)) match {
        case Success(n) => n
        case _ => error(exp.pos, s"Invalid Slang Z literal '$s'"); 0
      }
    }

    exp match {
      case Lit.Int(n) => n
      case Lit.Long(n) => n
      case Term.Apply(Term.Name("Z"), Seq(Lit.Int(n))) => n
      case Term.Apply(Term.Name("Z"), Seq(Lit.Long(n))) => n
      case Term.Apply(Term.Name("Z"), Seq(Lit.String(s))) => extractString(s)
      case Term.Apply(Term.Select(Term.Apply(Term.Name("StringContext"), Seq(Lit.String(s))), Term.Name("z")), Seq()) =>
        extractString(s)
      case exp: Term.Interpolate if exp.prefix.value == "z" && exp.args.isEmpty && exp.parts.size == 1 =>
        exp.parts.head match {
          case Lit.String(s) => extractString(s)
          case _ => error(exp.pos, s"Invalid Slang Z literal '${syntax(exp)}'"); 0
        }
      case _ => error(exp.pos, s"Expecting Z literal, but '${syntax(exp)}' found."); 0
    }
  }

  def extractStaticB(exp: Term): B = exp match {
    case Lit.Boolean(b) => b
    case Term.Name("T") => true
    case Term.Name("F") => false
    case _ => error(exp.pos, s"Expecting B literal, but '${syntax(exp)}' found."); false
  }

  def translateRangeType(enclosing: Enclosing.Type, stat: Defn.Class): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        if (isWorksheet)
          errorInSlang(
            stat.pos,
            "@range class declarations can only appear at the top-level, package-level, or inside objects"
          )
        else errorInSlang(stat.pos, "@range class declarations can only appear at package-level or inside objects")
    }
    val q"@range(..${modparams: List[Term]}) class $tname" = stat
    var hasMin = false
    var hasMax = false
    var index = false
    var min: Z = 0
    var max: Z = 0
    for (p <- modparams) p match {
      case q"min = ${exp: Term}" =>
        hasMin = true
        min = extractStaticZ(exp)
      case q"max = ${exp: Term}" =>
        hasMax = true
        max = extractStaticZ(exp)
      case q"index = ${exp: Term}" =>
        index = extractStaticB(exp)
      case t => error(t.pos, s"Invalid Slang @range argument '${syntax(t)}'.")
    }

    val isSigned = !hasMin || min < 0
    val isBitVector = false
    val bitWidth = 0
    val isWrapped = false

    if (!hasMin && !hasMax) error(stat.pos, "Slang @range requires either min, max, or both.")
    if (index && !hasMin) error(stat.pos, "Slang @range index requires a min.")
    if (hasMin && hasMax && min > max)
      error(stat.pos, s"Slang @range min ($min) should not be greater than its max ($max).")

    AST.Stmt.SubZ(
      cid(tname),
      isSigned,
      isBitVector,
      isWrapped,
      hasMin,
      hasMax,
      bitWidth,
      min,
      max,
      if (index) min else 0,
      attr(stat.pos)
    )
  }

  def translateBitsType(enclosing: Enclosing.Type, stat: Defn.Class): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        if (isWorksheet)
          errorInSlang(
            stat.pos,
            "@range class declarations can only appear at the top-level, package-level, or inside objects"
          )
        else errorInSlang(stat.pos, "@range class declarations can only appear at package-level or inside objects")
    }
    val q"@bits(..${modparams: List[Term]}) class $tname" = stat

    var isSigned = false
    var bitWidth: Z = 0
    var min: Z = 0
    var max: Z = 0
    var index = false
    var hasMin = false
    var hasMax = false
    var width = 64
    for (p <- modparams) p match {
      case q"signed = ${exp: Term}" =>
        isSigned = extractStaticB(exp)
      case t @ q"width = ${exp: Term}" =>
        bitWidth = extractStaticZ(exp)
        width = bitWidth match {
          case Z.Int(8) => 8
          case Z.Int(16) => 16
          case Z.Int(32) => 32
          case Z.Int(64) => 64
          case _ =>
            error(
              t.pos,
              s"Invalid Slang @bits width argument '${syntax(exp)}' (only 8, 16, 32, or 64 are currently supported)."
            ); 64
        }
      case q"min = ${exp: Term}" =>
        min = extractStaticZ(exp)
        hasMin = true
      case q"max = ${exp: Term}" =>
        max = extractStaticZ(exp)
        hasMax = true
      case q"index = ${exp: Term}" =>
        index = extractStaticB(exp)
      case t => error(t.pos, s"Invalid Slang @bits argument '${syntax(t)}'.")
    }

    val signedString = if (isSigned) "signed" else "unsigned"

    val (wMin, wMax) =
      if (isSigned) (Z(BigInt(-2).pow(width - 1)), Z(BigInt(2).pow(width - 1) - 1))
      else (Z(0), Z(BigInt(2).pow(width) - 1))
    if (index && !hasMin) error(stat.pos, "Slang @bits index requires a min.")
    if (hasMin && hasMax && min > max)
      error(stat.pos, s"Slang @range min ($min) should not be greater than its max ($max).")
    if (hasMin && min < wMin)
      error(stat.pos, s"Slang @bits min ($min) should not be less than its $signedString bit-width minimum ($wMin).")
    if (hasMax && max > wMax)
      error(stat.pos, s"Slang @bits max ($max) should not be greater than its $signedString bit-width maximum ($wMax).")
    if (!hasMin) min = wMin
    if (!hasMax) max = wMax

    val isWrapped = min == wMin && max == wMax
    val isBitVector = true

    AST.Stmt.SubZ(
      cid(tname),
      isSigned,
      isBitVector,
      isWrapped,
      hasMin,
      hasMax,
      bitWidth,
      min,
      max,
      if (index) min else 0,
      attr(stat.pos)
    )
  }

  def translateObject(enclosing: Enclosing.Type, stat: Defn.Object): AST.Stmt = {
    var hasError = false
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        hasError = true
        if (isWorksheet)
          errorInSlang(
            stat.pos,
            "Object declarations can only appear at the top-level, package-level, or inside other objects"
          )
        else errorInSlang(stat.pos, "Object declarations can only appear at the package-level or inside other objects")
    }
    val mods = stat.mods
    val name = stat.name
    val estats = stat.templ.early
    val ctorcalls = stat.templ.inits
    val stats = stat.templ.stats
    val self = stat.templ.self
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
      hasError = true
      error(stat.pos, "Slang @enum declarations should have the form: '@enum object〈ID〉{ ... }'")
    } else if (estats.nonEmpty) {
      hasError = true
      errorNotSlang(estats.head.pos, "Object early initializations are")
    } else if (hasSelfType(self)) {
      hasError = true
      errorNotSlang(self.pos, s"Self type: ${syntax(self)} is")
    }
    if (hasEnum) {
      val elements: Seq[AST.Id] = (for (stat <- stats)
        yield
          stat match {
            case Lit.Symbol(symbol) => scala.Some(cid(symbol.name, stat.pos))
            case _ =>
              error(stat.pos, s"An @enum element should be a single quote immediately followed by〈ID〉(i.e., a symbol).")
              scala.None
          }).flatten

      AST.Stmt.Enum(cid(name), ISZ(elements: _*), attr(stat.pos))
    } else if (!hasError) {
      val tstat = if (hasExt) translateStat(Enclosing.ExtObject) _ else translateStat(Enclosing.Object) _
      AST.Stmt.Object(
        hasExt,
        cid(name),
        ISZ(ctorcalls.map(translateExtend): _*),
        checkNestedMethods(ISZ(stats.map(tstat): _*)),
        attr(stat.pos)
      )
    } else AST.Stmt.Object(hasExt, cid(name), ISZ(), ISZ(), attr(stat.pos))
  }

  def translateSig(enclosing: Enclosing.Type, stat: Defn.Trait): AST.Stmt = {
    val mods = stat.mods
    val tname = stat.name
    val tparams = stat.tparams
    val estats = stat.templ.early
    val ctorcalls = stat.templ.inits
    val self = stat.templ.self
    val stats = stat.templ.stats

    if (hasSelfType(self)) {
      errorNotSlang(tname.pos, s"Self type: ${syntax(self)} is")
    }

    var hasSig = false
    var hasMSig = false
    var hasSealed = false
    var hasExt = false
    var m = ""
    for (mod <- mods) mod match {
      case mod"@sig" =>
        if (hasSig) {
          error(mod.pos, "Redundant '@sig'.")
        }
        hasSig = true
        m = "@sig"
      case mod"@msig" =>
        if (hasSig) {
          error(mod.pos, "Redundant '@msig'.")
        }
        hasMSig = true
        m = "@msig"
      case mod"@ext" =>
        if (hasExt) {
          error(mod.pos, "Redundant '@ext'.")
        }
        hasExt = true
        m = "@ext"
      case mod"sealed" =>
        if (hasSealed) {
          error(mod.pos, "Redundant 'sealed'.")
        }
        hasSealed = true
      case _ =>
        if (hasSig) error(mod.pos, "Only the 'sealed' modifier is allowed for Slang @sig traits.")
        else if (hasMSig) error(mod.pos, "Only the 'sealed' modifier is allowed for Slang @msig traits.")
        else error(mod.pos, "No modifier is allowed for Slang @ext traits.")
    }

    if (hasSig && hasMSig) error(stat.pos, "Slang @sig and @msig cannot be used together.")

    if (hasExt && (hasSig || hasMSig || hasSealed))
      error(stat.pos, "Slang @ext cannot be used together with other modifiers.")

    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        if (isWorksheet)
          errorInSlang(
            stat.pos,
            s"$m trait declarations can only appear at the top-level, package-level, or inside objects"
          )
        else errorInSlang(stat.pos, s"$m trait declarations can only appear at the package-level or inside objects")
    }
    if (estats.nonEmpty)
      error(tname.pos, s"Slang $m traits have to be of the form '$m trait〈ID〉... { ... }'.")

    AST.Stmt.Sig(
      hasSig,
      hasExt,
      cid(tname),
      ISZ(tparams.map(translateTypeParam): _*),
      ISZ(ctorcalls.map(translateExtend): _*),
      checkNestedMethods(ISZ(stats.map(translateStat(Enclosing.Sig)): _*)),
      attr(stat.pos)
    )
  }

  def translateDatatype(enclosing: Enclosing.Type, stat: Defn.Trait): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        if (isWorksheet)
          errorInSlang(
            stat.pos,
            "@datatype trait declarations can only appear at the top-level, package-level, or inside objects"
          )
        else
          errorInSlang(stat.pos, "@datatype trait declarations can only appear at the package-level or inside objects")
    }
    val mods = stat.mods
    val tname = stat.name
    val tparams = stat.tparams
    val estats = stat.templ.early
    val ctorcalls = stat.templ.inits
    val self = stat.templ.self
    val stats = stat.templ.stats
    if (estats.nonEmpty || hasSelfType(self))
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
    AST.Stmt.AbstractDatatype(
      isRoot = true,
      isDatatype = true,
      cid(tname),
      ISZ(tparams.map(translateTypeParam): _*),
      ISZ(),
      ISZ(ctorcalls.map(translateExtend): _*),
      checkNestedMethods(ISZ(stats.map(translateStat(Enclosing.DatatypeTrait)): _*)),
      attr(stat.pos)
    )
  }

  def translateDatatype(enclosing: Enclosing.Type, stat: Defn.Class): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        if (isWorksheet)
          errorInSlang(
            stat.pos,
            "@datatype class declarations can only appear at the top-level, package-level, or inside objects"
          )
        else errorInSlang(stat.pos, "@datatype class declarations can only appear at package-level or inside objects")
    }
    val mods = stat.mods
    val tname = stat.name
    val tparams = stat.tparams
    val ctorMods = stat.ctor.mods
    val paramss = stat.ctor.paramss
    val estats = stat.templ.early
    val ctorcalls = stat.templ.inits
    val self = stat.templ.self
    val stats = stat.templ.stats
    if (ctorMods.nonEmpty || paramss.size > 1 || estats.nonEmpty || hasSelfType(self)) {
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
    AST.Stmt.AbstractDatatype(
      isRoot = false,
      isDatatype = true,
      cid(tname),
      ISZ(tparams.map(translateTypeParam): _*),
      params,
      ISZ(ctorcalls.map(translateExtend): _*),
      checkNestedMethods(ISZ(stats.map(translateStat(Enclosing.DatatypeClass)): _*)),
      attr(stat.pos)
    )
  }

  def translateRecord(enclosing: Enclosing.Type, stat: Defn.Trait): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        if (isWorksheet)
          errorInSlang(
            stat.pos,
            "@record trait declarations can only appear at the top-level, package-level, or inside objects"
          )
        else errorInSlang(stat.pos, "@rcord trait declarations can only appear at the package-level or inside objects")
    }
    val mods = stat.mods
    val tname = stat.name
    val tparams = stat.tparams
    val estats = stat.templ.early
    val ctorcalls = stat.templ.inits
    val self = stat.templ.self
    val stats = stat.templ.stats
    if (estats.nonEmpty || hasSelfType(self))
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
    AST.Stmt.AbstractDatatype(
      isRoot = true,
      isDatatype = false,
      cid(tname),
      ISZ(tparams.map(translateTypeParam): _*),
      ISZ(),
      ISZ(ctorcalls.map(translateExtend): _*),
      checkNestedMethods(ISZ(stats.map(translateStat(Enclosing.RecordTrait)): _*)),
      attr(stat.pos)
    )
  }

  def translateRecord(enclosing: Enclosing.Type, stat: Defn.Class): AST.Stmt = {
    enclosing match {
      case Enclosing.Top | Enclosing.Package | Enclosing.Object =>
      case _ =>
        if (isWorksheet)
          errorInSlang(
            stat.pos,
            "@record class declarations can only appear at the top-level, package-level, or inside objects"
          )
        else errorInSlang(stat.pos, "@record class declarations can only appear at the package-level or inside objects")
    }
    val mods = stat.mods
    val tname = stat.name
    val tparams = stat.tparams
    val ctorMods = stat.ctor.mods
    val paramss = stat.ctor.paramss
    val estats = stat.templ.early
    val ctorcalls = stat.templ.inits
    val self = stat.templ.self
    val stats = stat.templ.stats
    if (ctorMods.nonEmpty || paramss.size > 1 || estats.nonEmpty || hasSelfType(self)) {
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
    AST.Stmt.AbstractDatatype(
      isRoot = false,
      isDatatype = false,
      cid(tname),
      ISZ(tparams.map(translateTypeParam): _*),
      params,
      ISZ(ctorcalls.map(translateExtend): _*),
      checkNestedMethods(ISZ(stats.map(translateStat(Enclosing.RecordClass)): _*)),
      attr(stat.pos)
    )
  }

  def translateTypeAlias(enclosing: Enclosing.Type, stat: Defn.Type): AST.Stmt = {
    val mods = stat.mods
    val tname = stat.name
    val tparams = stat.tparams
    val tpe = stat.body
    if (mods.nonEmpty) {
      error(stat.pos, "Slang type definitions should be of the form: 'type〈ID〉... =〈type〉'.")
    }
    AST.Stmt.TypeAlias(cid(tname), ISZ(tparams.map(translateTypeParam): _*), translateType(tpe), attr(stat.pos))
  }

  def translateType(t: Type): AST.Type = {
    def f(t: Term): ISZ[AST.Id] = t match {
      case q"$expr.$name" => f(expr) :+ cid(name)
      case q"${name: Term.Name}" => ISZ(cid(name))
      case _ =>
        errorInSlang(t.pos, s"Invalid type reference '${t.syntax}'")
        ISZ(rDollarId)
    }

    t match {
      case t"$ref.$tname[..$tpesnel]" =>
        AST.Type
          .Named(AST.Name(f(ref) :+ cid(tname), attr(t.pos)), ISZ(tpesnel.map(translateType): _*), typedAttr(t.pos))
      case t"${name: Type.Name}[..$tpesnel]" =>
        AST.Type.Named(AST.Name(ISZ(cid(name)), attr(name.pos)), ISZ(tpesnel.map(translateType): _*), typedAttr(t.pos))
      case t"${name: Type.Name}" =>
        AST.Type.Named(AST.Name(ISZ(cid(name)), attr(name.pos)), ISZ(), typedAttr(t.pos))
      case t"(..$tpesnel)" =>
        AST.Type.Tuple(ISZ(tpesnel.map(translateType): _*), typedAttr(t.pos))
      case t"$ref.$tname" =>
        AST.Type.Named(AST.Name(f(ref) :+ cid(tname), attr(t.pos)), ISZ(), typedAttr(t.pos))
      case t: Type.Function =>
        val (isPure, ret) = t.res match {
          case res: Type.Annotate =>
            (res.annots.exists({
              case mod"@pure" => true
              case _ => false
            }), res.tpe)
          case _ => (false, t.res)
        }
        AST.Type.Fun(
          isPure,
          false,
          ISZ(t.params.map(t => translateTypeArg(allowByName = false)(t)): _*),
          translateType(ret),
          typedAttr(t.pos)
        )
      case _ =>
        errorNotSlang(t.pos, s"Type '${syntax(t)}' is")
        unitType
    }
  }

  def translateTypeArg(allowByName: Boolean)(ta: Type): AST.Type = ta match {
    case _: Type.Repeated =>
      errorNotSlang(ta.pos, "Repeated types '〈type〉*' are")
      unitType
    case ta: Type.ByName =>
      if (allowByName) {
        AST.Type.Fun(true, true, ISZ(), translateType(ta.tpe), typedAttr(ta.pos))
      } else {
        errorInSlang(ta.pos, "By name types '=> 〈type〉' are only allowed on (non-@memoize) method parameters")
        unitType
      }
    case _ => translateType(ta)
  }

  def translateAssignExp(exp: Term): AST.Stmt with AST.AssignExp = exp match {
    case exp: Term.Block => translateBlock(Enclosing.Block, exp, isAssignExp = true)
    case exp: Term.If if exp.thenp.isInstanceOf[Term.Block] =>
      translateIfStmt(Enclosing.Block, exp, isAssignExp = true)
    case exp: Term.Match => translateMatch(Enclosing.Block, exp, isAssignExp = true)
    case exp: Term.Return => translateReturn(Enclosing.Block, exp)
    case _ => AST.Stmt.Expr(translateExp(exp), attr(exp.pos))
  }

  def translateStmtsExp(pos: Position, stats: Seq[Stat]): ISZ[AST.Stmt] = {
    stats.lastOption match {
      case scala.Some(exp: Term) =>
        ISZ(stats.dropRight(1).map(translateStat(Enclosing.Block)) :+ translateAssignExp(exp): _*)
      case scala.Some(stat) =>
        error(stat.pos, s"Expecting an expression but '${syntax(stat)}' found.")
        ISZ()
      case _ =>
        error(pos, s"Expecting an expression but none found.")
        ISZ()
    }
  }

  def translatePattern(pat: Pat): AST.Pattern = {
    pat match {
      case p"${pname: Pat.Var} @ $ref(..${apats: List[Pat]})" =>
        AST.Pattern.Structure(
          Some(cid(pname.name)),
          Some(AST.Name(ref2IS(ref), attr(ref.pos))),
          ISZ(apats.map(translatePattern): _*),
          resolvedAttr(pat.pos)
        )
      case p"${pname: Pat.Var} @ (..$patsnel)" =>
        AST.Pattern
          .Structure(Some(cid(pname.name)), None(), ISZ(patsnel.map(translatePattern): _*), resolvedAttr(pat.pos))
      case p"$ref(..${apats: List[Pat]})" =>
        AST.Pattern.Structure(
          None(),
          Some(AST.Name(ref2IS(ref), attr(ref.pos))),
          ISZ(apats.map(translatePattern): _*),
          resolvedAttr(pat.pos)
        )
      case p"(..$patsnel)" if patsnel.size > 1 =>
        AST.Pattern.Structure(None(), None(), ISZ(patsnel.map(translatePattern): _*), resolvedAttr(pat.pos))
      case p"${ref: Term.Ref}.$ename" =>
        checkMethodId(ename.pos, ename.value)
        AST.Pattern.Ref(AST.Name(ref2IS(ref) :+ cid(ename), attr(pat.pos)), resolvedAttr(pat.pos))
      case pat: Term.Name =>
        checkMethodId(pat.pos, pat.value)
        AST.Pattern.Ref(AST.Name(ISZ(cid(pat)), attr(pat.pos)), resolvedAttr(pat.pos))
      case p"${name: Pat.Var} : $tpe" =>
        checkMethodId(name.name.pos, name.name.value)
        AST.Pattern.VarBinding(cid(name), Some(translateType(tpe)), typedAttr(pat.pos))
      case q"${name: Pat.Var}" =>
        checkMethodId(name.name.pos, name.name.value)
        AST.Pattern.VarBinding(cid(name), None(), typedAttr(pat.pos))
      case p"_ : $tpe" => AST.Pattern.Wildcard(Some(translateType(tpe)), typedAttr(pat.pos))
      case p"_" => AST.Pattern.Wildcard(None(), typedAttr(pat.pos))
      case p"${lit: Pat.Interpolate}" => translateLit(lit)
      case p"${lit: Lit}" => AST.Pattern.Literal(translateLit(lit))
      case _: Pat.SeqWildcard => AST.Pattern.SeqWildcard(typedAttr(pat.pos))
      case _ =>
        errorInSlang(pat.pos, s"Invalid pattern: '${pat.structure}'")
        AST.Pattern.Wildcard(None(), typedAttr(pat.pos))
    }
  }

  def translatePattern(pat: Term): AST.Pattern = {
    pat match {
      case q"$expr(...${aexprssnel: List[List[Term]]})" =>
        if (aexprssnel.size == 1) {
          val args = aexprssnel.head
          expr match {
            case expr: Term.Ref =>
              return AST.Pattern.Structure(
                None(),
                Some(AST.Name(ref2IS(expr), attr(expr.pos))),
                ISZ(args.map(translatePattern): _*),
                resolvedAttr(pat.pos)
              )
            case _ =>
          }
        }
        errorInSlang(pat.pos, s"Invalid pattern: '${syntax(pat)}'")
        AST.Pattern.Wildcard(None(), typedAttr(pat.pos))
      case q"(..$exprsnel)" if exprsnel.size > 1 =>
        AST.Pattern.Structure(None(), None(), ISZ(exprsnel.map(translatePattern): _*), resolvedAttr(pat.pos))
      case q"${name: Term.Name}" => AST.Pattern.VarBinding(cid(name), None(), typedAttr(pat.pos))
      case p"${lit: Lit}" => AST.Pattern.Literal(translateLit(lit))
      case _ =>
        errorInSlang(pat.pos, s"Invalid pattern: '${syntax(pat)}'")
        AST.Pattern.Wildcard(None(), typedAttr(pat.pos))
    }
  }

  def translateTypeParam(tp: Type.Param): AST.TypeParam = tp match {
    case tparam"..$mods $_[..$tparams] >: ${stpeopt: scala.Option[Type]} <: ${tpeopt: scala.Option[Type]} <% ..$tpes : ..$tpes2" =>
      if (mods.nonEmpty || tparams.nonEmpty || stpeopt.nonEmpty || tpeopt.nonEmpty || tpes.nonEmpty || tpes2.nonEmpty)
        errorInSlang(tp.pos, "Only type parameters of the forms '〈ID〉' is")
      checkTypeId(tp.name.pos, tp.name.value)
      AST.TypeParam(cid(tp.name))
  }

  def translateParam(isMemoize: Boolean)(tp: Term.Param): AST.Param = {
    val mods = tp.mods
    val paramname = tp.name
    val atpeopt = tp.decltpe
    val expropt = tp.default
    var hasHidden = false
    for (mod <- mods) mod match {
      case mod"@hidden" =>
        if (isMemoize) {
          if (hasHidden) {
            error(mod.pos, "Redundant @hidden.")
          }
          hasHidden = true
        } else errorInSlang(mod.pos, "@hidden is only allowed for @memoize methods")
      case _ =>
        error(mod.pos, s"Unallowed modifier '${syntax(mod)}' for a Slang method.")
    }
    if (atpeopt.isEmpty || expropt.nonEmpty) {
      val mod = if (hasHidden) "@hidden " else ""
      errorInSlang(tp.pos, s"The parameter should have the form '$mod〈ID〉:〈type〉'")
    }
    atpeopt
      .map(ta => AST.Param(hasHidden, cid(tp.name), translateTypeArg(!isMemoize)(ta)))
      .getOrElse(AST.Param(hasHidden, cid(tp.name), unitType))
  }

  def translateFunParam(tp: Term.Param): AST.Exp.Fun.Param = {
    val mods = tp.mods
    val paramname = tp.name
    val atpeopt = tp.decltpe
    val expropt = tp.default
    for (mod <- mods) mod match {
      case _ =>
        error(mod.pos, s"Unallowed modifier '${syntax(mod)}' for a Slang fun expression.")
    }
    if (expropt.nonEmpty) {
      errorInSlang(tp.pos, s"The parameter should have the form '〈ID〉⸨ :〈type〉⸩?'")
    }
    atpeopt
      .map(ta => AST.Exp.Fun.Param(cid(tp.name), Some(translateTypeArg(false)(ta))))
      .getOrElse(AST.Exp.Fun.Param(cid(tp.name), None()))
  }

  def translateBlock(enclosing: Enclosing.Type, stat: Term.Block, isAssignExp: Boolean): AST.Stmt.Block = {
    enclosing match {
      case Enclosing.Top | Enclosing.Object | Enclosing.DatatypeClass | Enclosing.RecordClass | Enclosing.Method |
          Enclosing.Block =>
        val stmts =
          if (isAssignExp) translateStmtsExp(stat.pos, stat.stats)
          else ISZ(stat.stats.map(translateStat(Enclosing.Block)): _*)
        AST.Stmt.Block(bodyCheck(stmts, ISZ()), attr(stat.pos))
      case _ =>
        if (isWorksheet)
          errorInSlang(
            stat.pos,
            "Code-blocks can only appear at the top-level, inside @datatype classes, @record classes, methods, or other code blocks"
          )
        else
          errorInSlang(
            stat.pos,
            "Code-blocks can only appear inside @datatype classes, @record classes, methods or other code blocks"
          )
        AST.Stmt.Block(bodyCheck(ISZ(), ISZ()), emptyAttr)
    }
  }

  def translateExtend(init: Init): AST.Type.Named = {
    if (init.argss.nonEmpty) errorInSlang(init.pos, "Cannot supply arguments for extends")
    translateType(init.tpe) match {
      case r: AST.Type.Named => r
      case _ =>
        errorInSlang(init.pos, "Invalid type for extends")
        AST.Type.Named(AST.Name(ISZ(), emptyAttr), ISZ(), emptyTypedAttr)
    }
  }

  def translateAbstractDatatypeParam(isDatatype: Boolean)(tp: Term.Param): AST.AbstractDatatypeParam = {
    val mods = tp.mods
    val paramname = tp.name
    val atpeopt = tp.decltpe
    val expropt = tp.default
    var hasError = false
    var hasHidden = false
    var isVar = false
    checkMethodId(tp.name.pos, tp.name.value)
    for (mod <- mods) mod match {
      case mod"@hidden" =>
        if (hasHidden) {
          hasError = true
          error(mod.pos, "Redundant @hidden.")
        }
        hasHidden = true
      case mod"varparam" if !isDatatype => isVar = true
      case mod"valparam" =>
      case _ =>
        hasError = true
        if (isDatatype) error(mod.pos, s"Unallowed modifier '${syntax(mod)}' for a Slang @datatype class.")
        else error(mod.pos, s"Unallowed modifier '${syntax(mod)}' for a Slang @record class.")
    }
    if (atpeopt.isEmpty || expropt.nonEmpty) {
      hasError = true
      val hidden = if (hasHidden) "@hidden " else ""
      errorInSlang(tp.pos, s"The abstract dataype parameter should have the form '$hidden〈ID〉:〈type〉'")
    }
    if (hasError) AST.AbstractDatatypeParam(hasHidden, !isVar, cid(paramname), unitType)
    else
      AST.AbstractDatatypeParam(hasHidden, !isVar, cid(paramname), translateTypeArg(allowByName = false)(atpeopt.get))
  }

  def bodyCheck(stmts: ISZ[AST.Stmt], undecls: ISZ[String]): AST.Body = {
    var i = 0
    for (stmt <- stmts) {
      val (ret, hlt) = stmt match {
        case stmt: AST.Stmt.Return => (true, false)
        case AST.Stmt.Expr(AST.Exp.Invoke(_, AST.Id(id), _, _)) if id.value == "halt" => (false, true)
        case _ => (false, false)
      }
      if ((ret || hlt) && Z(i) != stmts.size - 1) {
        val text = if (ret) "return" else "halt"
        for (j <- Z(i + 1) until stmts.size) {
          reporter.error(stmts(j).posOpt, SlangParser.messageKind, s"No statements are allowed after $text.")
        }
      }
      i = i + 1
    }
    return AST.Body(stmts, undecls)
  }

  def stmtCheck(enclosing: Enclosing.Type, stat: Term, kind: Predef.String): Boolean = enclosing match {
    case Enclosing.Top | Enclosing.Method | Enclosing.Block => false
    case _ =>
      if (isWorksheet) errorInSlang(stat.pos, s"$kind can only appear at the top-level, inside methods, or code blocks")
      else errorInSlang(stat.pos, s"$kind can only appear inside methods or code blocks")
      true
  }

  def checkLhs(lhs: AST.Exp): AST.Exp = {
    lhs match {
      case lhs: AST.Exp.Ident =>
      case lhs: AST.Exp.Select if lhs.targs.isEmpty && lhs.receiverOpt.nonEmpty =>
        lhs.receiverOpt.foreach(receiver => checkLhs(receiver))
      case lhs: AST.Exp.Invoke
          if lhs.id.value.value == "apply" && lhs.receiverOpt.nonEmpty && lhs.targs.isEmpty && lhs.args.size == 1 =>
        lhs.receiverOpt.foreach(receiver => checkLhs(receiver))
      case _ =>
        reporter.error(lhs.posOpt, SlangParser.messageKind, s"Invalid assignment left-hand-side form in Slang: ${lhs}")
    }
    lhs
  }

  def translateAssign(enclosing: Enclosing.Type, stat: Term.Assign): AST.Stmt = {
    stmtCheck(enclosing, stat, "Assigments")
    val lhs = translateExp(stat.lhs)
    AST.Stmt.Assign(checkLhs(lhs), translateAssignExp(stat.rhs), attr(stat.pos))
  }

  def translateAssign(
    enclosing: Enclosing.Type,
    fun: Term,
    argss: List[List[Term]],
    rhs: Term,
    stat: Term
  ): AST.Stmt = {
    val pos = stat.pos

    stmtCheck(enclosing, stat, "Assigments")
    var lhs = translateExp(fun)
    val prevPos = fun.pos
    if (argss.nonEmpty) {
      for (args <- argss) {
        val pos =
          if (args.nonEmpty) Position.Range(args.head.pos.input, args.head.pos.start, args.last.pos.end)
          else prevPos
        lhs = translateApply(lhs, args, pos)
      }
    } else {
      errorInSlang(pos, s"Invalid update form: '${syntax(stat)}'")
    }
    AST.Stmt.Assign(checkLhs(lhs), translateAssignExp(rhs), attr(pos))
  }

  def translateIfStmt(enclosing: Enclosing.Type, stat: Term.If, isAssignExp: Boolean): AST.Stmt.If = {
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
    if (hasError) AST.Stmt.If(cond, bodyCheck(ISZ(), ISZ()), bodyCheck(ISZ(), ISZ()), emptyAttr)
    else
      ((stat.thenp, stat.elsep): @unchecked) match {
        case (thenp: Term.Block, elsep: Term.Block) =>
          AST.Stmt.If(
            cond,
            bodyCheck(
              if (isAssignExp) translateStmtsExp(thenp.pos, thenp.stats)
              else ISZ(thenp.stats.map(translateStat(enclosing)): _*),
              ISZ()
            ),
            bodyCheck(
              if (isAssignExp) translateStmtsExp(elsep.pos, elsep.stats)
              else ISZ(elsep.stats.map(translateStat(enclosing)): _*),
              ISZ()
            ),
            attr(stat.pos)
          )
        case (thenp: Term.Block, elsep: Term.If) =>
          AST.Stmt.If(
            cond,
            bodyCheck(
              if (isAssignExp) translateStmtsExp(thenp.pos, thenp.stats)
              else ISZ(thenp.stats.map(translateStat(enclosing)): _*),
              ISZ()
            ),
            bodyCheck(ISZ(translateIfStmt(Enclosing.Block, elsep, isAssignExp)), ISZ()),
            attr(stat.pos)
          )
        case (thenp: Term.Block, elsep: Lit.Unit) =>
          if (isAssignExp) error(elsep.pos, "Expecting a code block with an expression.")
          AST.Stmt.If(
            cond,
            bodyCheck(ISZ(thenp.stats.map(translateStat(enclosing)): _*), ISZ()),
            bodyCheck(ISZ(), ISZ()),
            attr(stat.pos)
          )
      }
  }

  def translateMatch(enclosing: Enclosing.Type, stat: Term.Match, isAssignExp: Boolean): AST.Stmt.Match = {
    def translateCase(stat: Case): AST.Case = {
      AST
        .Case(translatePattern(stat.pat), opt(stat.cond.map(translateExp)), stat.body match {
          case b: Term.Block =>
            bodyCheck(
              if (isAssignExp) translateStmtsExp(b.pos, b.stats)
              else ISZ(b.stats.map(translateStat(Enclosing.Block)): _*),
              ISZ()
            )
          case b: Term if isAssignExp =>
            bodyCheck(
              if (isAssignExp) ISZ(translateAssignExp(b))
              else ISZ(translateStat(Enclosing.Block)(b)),
              ISZ()
            )
          case b if isAssignExp =>
            error(stat.body.pos, s"Expecting an expression but '${syntax(b)}' found.")
            bodyCheck(ISZ(), ISZ())
          case b => bodyCheck(ISZ(translateStat(Enclosing.Block)(b)), ISZ())
        })
    }

    stmtCheck(enclosing, stat, "Match-statements")
    val exp = translateExp(stat.expr)
    val cases = stat.cases.map(translateCase)
    exp match {
      case exp @ AST.Exp.Select(_, AST.Id(String("native")), _) =>
        var i = 0
        for (c <- cases) {
          c.pattern match {
            case pat: AST.Pattern.LitInterpolate =>
              error(stat.cases(i).pat.pos, s"Cannot use a literal interpolator when matching using 'native'.")
            case _ =>
          }
          i = i + 1
        }
      case _ =>
    }
    AST.Stmt.Match(exp, ISZ(cases: _*), attr(stat.pos))
  }

  def translateWhile(enclosing: Enclosing.Type, stat: Term.While): AST.Stmt = {
    var hasError = stmtCheck(enclosing, stat, "While-statements")
    var invariants: ISZ[AST.ContractExp] = ISZ()
    var mods: ISZ[AST.Exp] = ISZ()
    var stats: Seq[Stat] = Seq()
    stat.body match {
      case body: Term.Block =>
        body.stats match {
          case (l @ Term.Interpolate(Term.Name("l"), Seq(_: Lit.String), Nil)) :: rest =>
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
    if (hasError) rStmt
    else
      AST.Stmt.While(
        translateExp(stat.expr),
        invariants,
        mods,
        bodyCheck(ISZ(stats.map(translateStat(Enclosing.Block)): _*), ISZ()),
        attr(stat.pos)
      )
  }

  def translateDoWhile(enclosing: Enclosing.Type, stat: Term.Do): AST.Stmt = {
    var hasError = stmtCheck(enclosing, stat, "Do-while-statements")
    var modifies: ISZ[AST.Exp] = ISZ()
    var invariants: ISZ[AST.ContractExp] = ISZ()
    var stats: Seq[Stat] = Seq()
    stat.body match {
      case body: Term.Block =>
        body.stats.lastOption match {
          case scala.Some(l @ Term.Interpolate(Term.Name("l"), Seq(_: Lit.String), Nil)) =>
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
    if (hasError) rStmt
    else
      AST.Stmt.DoWhile(
        translateExp(stat.expr),
        invariants,
        modifies,
        bodyCheck(ISZ(stats.map(translateStat(Enclosing.Block)): _*), ISZ()),
        attr(stat.pos)
      )
  }

  def translateFor(enclosing: Enclosing.Type, stat: Term.For): AST.Stmt = {
    var hasError = stmtCheck(enclosing, stat, "For-statements")
    var modifies: ISZ[AST.Exp] = ISZ()
    var invariants: ISZ[AST.ContractExp] = ISZ()
    var stats: Seq[Stat] = Seq()
    stat.body match {
      case body: Term.Block =>
        body.stats match {
          case (l @ Term.Interpolate(Term.Name("l"), Seq(_: Lit.String), Nil)) :: rest =>
            val (is, ms) = parseLoopContract(l)
            modifies = ms
            invariants = is
            stats = rest
          case (t: Term.Interpolate) :: _ =>
            hasError = true
            error(t.pos, "Expecting a Slang for-loop contract l\"\"\"{ ... }\"\"\" but found '" + syntax(t) + "'.")
          case _ =>
            stats = body.stats
        }
      case _ =>
        hasError = true
        errorInSlang(stat.body.pos, "For-loop body should be a code block")
    }
    if (hasError) rStmt
    else
      AST.Stmt.For(
        translateEnumGens(stat.enums),
        invariants,
        modifies,
        bodyCheck(ISZ(stats.map(translateStat(Enclosing.Block)): _*), ISZ()),
        attr(stat.pos)
      )
  }

  def translateRange(r: Term): AST.EnumGen.Range = {
    r match {
      case q"$start until $end by $by" =>
        AST.EnumGen.Range
          .Step(isInclusive = false, translateExp(start), translateExp(end), Some(translateExp(by)), attr(r.pos))
      case q"$start to $end by $by" =>
        AST.EnumGen.Range
          .Step(isInclusive = true, translateExp(start), translateExp(end), Some(translateExp(by)), attr(r.pos))
      case q"$start until $end" =>
        AST.EnumGen.Range.Step(isInclusive = false, translateExp(start), translateExp(end), None(), attr(r.pos))
      case q"$start to $end" =>
        AST.EnumGen.Range.Step(isInclusive = true, translateExp(start), translateExp(end), None(), attr(r.pos))
      case q"$s.indices" => AST.EnumGen.Range.Expr(isReverse = false, isIndices = true, translateExp(s), attr(r.pos))
      case q"$s.indices.reverse" =>
        AST.EnumGen.Range.Expr(isReverse = true, isIndices = true, translateExp(s), attr(r.pos))
      case q"$s.reverse" => AST.EnumGen.Range.Expr(isReverse = true, isIndices = false, translateExp(s), attr(r.pos))
      case _ => AST.EnumGen.Range.Expr(isReverse = false, isIndices = false, translateExp(r), attr(r.pos))
    }
  }

  def translateEnumGens(enums: Seq[Enumerator]): ISZ[AST.EnumGen.For] = enums match {
    case head :: enumerator"if $cond" :: rest =>
      head match {
        case enumerator"${_: Pat.Wildcard} <- $expr" =>
          AST.EnumGen.For(None(), translateRange(expr), Some(translateExp(cond))) +: translateEnumGens(rest)
        case enumerator"${id: Pat.Var} <- $expr" =>
          checkMethodId(id.name.pos, id.name.value)
          AST.EnumGen.For(Some(cid(id)), translateRange(expr), Some(translateExp(cond))) +: translateEnumGens(rest)
        case _ =>
          errorNotSlang(head.pos, s"For-loop enumerator: '${syntax(head)}'")
          ISZ()
      }
    case enumerator"${_: Pat.Wildcard} <- $expr" :: rest =>
      AST.EnumGen.For(None(), translateRange(expr), None()) +: translateEnumGens(rest)
    case enumerator"${id: Pat.Var} <- $expr" :: rest =>
      checkMethodId(id.name.pos, id.name.value)
      AST.EnumGen.For(Some(cid(id)), translateRange(expr), None()) +: translateEnumGens(rest)
    case Nil => ISZ()
    case _ =>
      errorNotSlang(enums.head.pos, s"For-loop enumerator: '${syntax(enums.head)}'")
      ISZ()
  }

  def translateReturn(enclosing: Enclosing.Type, stat: Term.Return): AST.Stmt.Return = {
    stmtCheck(enclosing, stat, "Return-statements")
    stat.expr match {
      case _: Lit.Unit => AST.Stmt.Return(None(), typedAttr(stat.pos))
      case _ => AST.Stmt.Return(Some(translateExp(stat.expr)), typedAttr(stat.pos))
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
        val prefix = exp.prefix.value
        if (builtinPrefix.contains(prefix)) translateLit(exp)
        else translateStringInterpolate(exp)
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
      case exp: Term.This => AST.Exp.This(typedAttr(exp.pos))
      case q"super[${name: Name}]" => AST.Exp.Super(Some(cid(name)), typedAttr(exp.pos))
      case q"super" => AST.Exp.Super(None(), typedAttr(exp.pos))
      case exp: Term.Eta =>
        val ref: AST.Exp.Ref = translateExp(exp.expr) match {
          case r: AST.Exp.Ident => r
          case r: AST.Exp.Select => r
          case _ =>
            error(exp.expr.pos, s"Expecting an identifier or an access expression, but found ${syntax(exp.expr)}.")
            rExp
        }
        AST.Exp.Eta(ref, typedAttr(exp.pos))
      case exp: Term.Tuple => AST.Exp.Tuple(ISZ(exp.args.map(translateExp): _*), typedAttr(exp.pos))
      case exp: Term.ApplyUnary => translateUnaryExp(exp)
      case exp: Term.ApplyInfix => translateBinaryExp(exp)
      case q"L$$Quant(..${args: List[Term]})" =>
        val es = args
        es match {
          case Seq(b: Lit.Boolean, q"$ids: $t", e) =>
            AST.Exp.Quant(
              b.value,
              ISZ(AST.VarFragment(fresh(ids), Some(AST.Domain.Type(translateType(t), typedAttr(t.pos))))),
              translateExp(e),
              attr(exp.pos)
            )
          case Seq(b: Lit.Boolean, ids, e) =>
            AST.Exp.Quant(b.value, ISZ(AST.VarFragment(fresh(ids), None())), translateExp(e), attr(exp.pos))
          case Seq(b: Lit.Boolean, ids, tt @ Term.Tuple(Seq(lo, loExact: Lit.Boolean, hi, hiExact: Lit.Boolean)), e) =>
            AST.Exp.Quant(
              b.value,
              ISZ(
                AST.VarFragment(
                  fresh(ids),
                  Some(
                    AST.Domain
                      .Range(translateExp(lo), loExact.value, translateExp(hi), hiExact.value, typedAttr(tt.pos))
                  )
                )
              ),
              translateExp(e),
              attr(exp.pos)
            )
        }
      case q"$expr.$name[..$tpes](...${aexprssnel: List[List[Term]]})" if tpes.nonEmpty && aexprssnel.nonEmpty =>
        translateInvoke(
          scala.Some(expr),
          cid(name),
          name.pos,
          tpes,
          aexprssnel,
          Position.Range(expr.pos.input, name.pos.start, exp.pos.end)
        )
      case q"$expr.$name(...${aexprssnel: List[List[Term]]})" if aexprssnel.nonEmpty =>
        translateInvoke(
          scala.Some(expr),
          cid(name),
          name.pos,
          List(),
          aexprssnel,
          Position.Range(expr.pos.input, name.pos.start, exp.pos.end)
        )
      case q"${name: Term.Name}[..$tpes](...${aexprssnel: List[List[Term]]})" if aexprssnel.nonEmpty =>
        translateInvoke(scala.None, cid(name), name.pos, tpes, aexprssnel, exp.pos)
      case q"${name: Term.Name}(...${aexprssnel: List[List[Term]]})" if aexprssnel.nonEmpty =>
        translateInvoke(scala.None, cid(name), name.pos, List(), aexprssnel, exp.pos)
      case q"${fun @ q"this"}(...${aexprssnel: List[List[Term]]})" if aexprssnel.nonEmpty =>
        translateInvoke(scala.None, cidNoCheck("this", fun.pos), fun.pos, List(), aexprssnel, exp.pos)
      case q"$expr.$name[..$tpes]" if tpes.nonEmpty =>
        translateSelect(expr, name, tpes, Position.Range(exp.pos.input, name.pos.start, exp.pos.end))
      case q"$expr.$name" => translateSelect(expr, name, List(), name.pos)
      case exp: Term.If => translateIfExp(exp)
      case exp: Term.Function => translateFun(exp)
      case Term.Block(List(fn: Term.Function)) => translateFun(fn)
      case exp: Term.ForYield => translateForYield(exp)
      case _ =>
        errorNotSlang(exp.pos, s"Expression '${syntax(exp)}' is")
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

  def translateLit(
    prefix: Term.Name,
    args: Seq[_],
    parts: Seq[Lit],
    pos: Position,
    syntx: => Predef.String
  ): AST.Exp with AST.Lit = {
    def errR = AST.Exp.LitB(false, attr(pos))

    if (text.substring(pos.start, pos.end).startsWith(prefix.value + "\"\"\"")) {
      error(pos, "'" + prefix.value + "\"...\"' should be used instead of '" + prefix.value + "\"\"...\"\"\"'.")
      return errR
    }
    if (args.nonEmpty || !(parts match {
        case List(Lit.String(_)) => true
        case _ => false
      })) {
      errorNotSlang(pos, s"Literal '$syntx' is")
      return errR
    }
    val List(Lit.String(value)) = parts
    val r = prefix.value match {
      case "z" =>
        try AST.Exp.LitZ(Z.$String(value), attr(pos))
        catch {
          case _: Throwable =>
            error(pos, s"Invalid Z literal '${value}'.")
            AST.Exp.LitZ(0, attr(pos))
        }
      case "r" =>
        try AST.Exp.LitR(org.sireum.R.$String(value), attr(pos))
        catch {
          case _: Throwable =>
            error(pos, s"Invalid R literal '${value}'.")
            AST.Exp.LitR(org.sireum.R.$String("0"), attr(pos))
        }
      case "c" =>
        val c = StringContext.treatEscapes(value)
        if (c.size != 1) {
          error(pos, s"Invalid C literal '${value}'.")
          AST.Exp.LitC('?', attr(pos))
        } else AST.Exp.LitC(c.head, attr(pos))
      case "f32" =>
        try AST.Exp.LitF32(value.toFloat, attr(pos))
        catch {
          case _: Throwable =>
            error(pos, "Invalid 32-bit float number form.")
            AST.Exp.LitF32(0.0f, attr(pos))
        }
      case "f64" =>
        try AST.Exp.LitF32(value.toFloat, attr(pos))
        catch {
          case _: Throwable =>
            error(pos, "Invalid 64-bit double number form.")
            AST.Exp.LitF32(0.0f, attr(pos))
        }
      case "string" => AST.Exp.LitString(value, attr(pos))
    }
    return r
    error(pos, s"Invalid ${prefix.value.toUpperCase} number: '$syntx'")
    AST.Exp.LitB(false, attr(pos))
  }

  def translateLit(lit: Pat.Interpolate): AST.Pattern.LitInterpolate = {
    if (lit.args.nonEmpty || lit.parts.size != 1) {
      errorInSlang(lit.pos, s"Literal pattern interpolation cannot have arguments")
      AST.Pattern.LitInterpolate(lit.prefix.value, "", typedAttr(lit.pos))
    } else {
      val List(Lit.String(value)) = lit.parts
      lit.prefix.value match {
        case "z" =>
          try Z.$String(value)
          catch {
            case _: Throwable => error(lit.pos, s"Invalid Z literal '${value}'.")
          }
        case "r" =>
          try org.sireum.R.$String(value)
          catch {
            case _: Throwable => error(lit.pos, s"Invalid R literal '${value}'.")
          }
        case "c" =>
          if ((StringContext.treatEscapes(value)).size != 1) {
            error(lit.pos, s"Invalid C literal '${value}'.")
          }
        case "f32" =>
          try value.toFloat
          catch {
            case _: Throwable =>
              error(lit.pos, s"Invalid F32 literal '${value}'.")
          }
        case "f64" =>
          try value.toFloat
          catch {
            case _: Throwable =>
              error(lit.pos, s"Invalid F64 literal '${value}'.")
          }
        case "string" =>
        case prefix =>
          try Z.$String(value)
          catch {
            case _: Throwable =>
              error(lit.pos, s"Invalid ${prefix.head.toUpper}${prefix.substring(1)} literal '${value}'.")
          }
      }
      AST.Pattern.LitInterpolate(lit.prefix.value, lit.parts.head.value.toString, typedAttr(lit.pos))
    }
  }

  def translateLit(lit: Term.Interpolate): AST.Exp with AST.Lit =
    translateLit(lit.prefix, lit.args, lit.parts, lit.pos, syntax(lit))

  def translateStringInterpolate(s: Term.Interpolate): AST.Exp.StringInterpolate = {
    s.prefix.value match {
      case "s" | "st" =>
      case _ =>
        if (s.args.nonEmpty || s.parts.size != 1) {
          errorInSlang(s.pos, s"Literal pattern interpolation cannot have arguments.")
        } else {
          val List(Lit.String(value)) = s.parts
          try Z.$String(value)
          catch {
            case _: Throwable =>
              error(s.pos, s"Invalid ${s.prefix.value.head.toUpper}${s.prefix.value.substring(1)} literal '${value}'.")
          }

        }
    }
    AST.Exp.StringInterpolate(s.prefix.value, ISZ(s.parts.map({
      case Lit.String(value) => AST.Exp.LitString(value, attr(s.pos))
      case _ =>
        error(s.pos, s"Invalid string interpolation: '${syntax(s)}'")
        AST.Exp.LitString("", attr(s.pos))
    }): _*), ISZ(s.args.map(translateExp): _*), typedAttr(s.pos))
  }

  def translateUnaryExp(t: Term.ApplyUnary): AST.Exp = {
    unops.get(t.op.value) match {
      case scala.Some(op) => AST.Exp.Unary(op, translateExp(t.arg), resolvedAttr(t.op.pos))
      case _ =>
        errorInSlang(t.op.pos, s"'${t.op.value}' is not a unary operator")
        rExp
    }
  }

  def translateBinaryExp(t: Term.ApplyInfix): AST.Exp = {
    if (t.targs.nonEmpty)
      errorInSlang(t.targs.head.pos, "Binary operations cannot have type arguments")

    if (!t.op.value.headOption.exists(_ == '$') && !checkSymbol(t.op.value)) {
      error(
        t.op.pos,
        s"Cannot use infix expression notation to invoke '${t.op.value}' in Slang (use dot invoke notation instead)."
      )
    }
    val op = if (t.op.value == LParser.implyInternalSym) "->" else t.op.value
    t.args match {
      case List(right) => AST.Exp.Binary(translateExp(t.lhs), op, translateExp(right), resolvedAttr(t.op.pos))
      case _ =>
        import org.sireum._
        error(t.op.pos, st"Invalid righ-hand-side for '${t.op.value}': '(${(t.args.map(_.syntax), ", ")})'".render.value)
        rExp
    }
  }

  def translateInvoke(
    receiverOpt: scala.Option[Term],
    name: AST.Id,
    namePos: Position,
    tpes: Seq[Type],
    argss: Seq[Seq[Term]],
    pos: Position
  ): AST.Exp = {
    def translateArgss(argss: Seq[Seq[Term]]): Either[ISZ[AST.NamedArg], ISZ[AST.Exp]] = {
      if (argss.isEmpty) return Right(ISZ())
      translateArgs(argss.head)
    }

    if (checkSymbol(name.value.value)) {
      reporter.error(
        name.attr.posOpt,
        SlangParser.messageKind,
        s"Cannot use dot invocation notation for ${name.value.value} in Slang (use infix expression notation instead)."
      )
    }

    var r: AST.Exp = translateArgss(argss) match {
      case Left(args) =>
        AST.Exp.InvokeNamed(
          opt(receiverOpt.map(translateExp)),
          name,
          ISZ(tpes.map(translateType): _*),
          args,
          resolvedAttr(pos)
        )
      case Right(args) =>
        AST.Exp
          .Invoke(opt(receiverOpt.map(translateExp)), name, ISZ(tpes.map(translateType): _*), args, resolvedAttr(pos))
    }
    var prevPos = namePos
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
    if (name.value == "native" && tpes.nonEmpty) {
      error(name.pos, "Selector 'native' does not accept type arguments.")
    }
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

  def translateForYield(exp: Term.ForYield): AST.Exp = {
    val enums = translateEnumGens(exp.enums)
    var hasError = enums.isEmpty
    exp.body match {
      case body: Term.Block =>
        hasError = true
        errorInSlang(body.pos, "For-yield expression should not be a code block")
      case body: Lit.Unit =>
        hasError = true
        errorInSlang(body.pos, "For-yield expression should not be empty")
      case _ =>
    }
    if (hasError) rExp
    else AST.Exp.ForYield(enums, translateExp(exp.body), typedAttr(exp.pos))
  }

  def translateFun(exp: Term.Function): AST.Exp = {
    val ps = ISZ(exp.params.map(translateFunParam): _*)

    val (mc, body) = exp.body match {
      case tbody @ Term.Block(stats) =>
        stats.headOption match {
          case scala.Some(l @ Term.Interpolate(Term.Name("l"), Seq(_: Lit.String), Nil)) =>
            val newBlock = tbody.copy(stats = stats.tail)
            (parseContract(l), translateAssignExp(newBlock))
          case _ =>
            (emptyContract, translateAssignExp(tbody))
        }
      case _ => (emptyContract, translateAssignExp(exp.body))
    }
    AST.Exp.Fun(ISZ(), ps, mc, body, typedAttr(exp.pos))
  }

  def translateArgs(args: Seq[Term]): Either[ISZ[AST.NamedArg], ISZ[AST.Exp]] = {
    def expArg(arg: Term): AST.Exp = arg match {
      case q"$e1 -> $e2" => AST.Exp.Tuple(ISZ(translateExp(e1), expArg(e2)), typedAttr(arg.pos))
      case _ => translateExp(arg)
    }

    def namedArg(arg: Term): AST.NamedArg = arg match {
      case q"${name: Term.Name} = ${expr: Term}" => AST.NamedArg(cid(name), expArg(expr), -1)
      case _ =>
        errorNotSlang(arg.pos, s"Argument ${syntax(arg)} is")
        AST.NamedArg(rDollarId, rExp, -1)
    }

    var isNamed = false
    var isPositional = false
    for (arg <- args) arg match {
      case _: Term.Repeated =>
        errorInSlang(arg.pos, s"Repeated argument: '${syntax(arg)}'")
        return Right(ISZ())
      case _: Term.Assign => isNamed = true
      case _ => isPositional = true
    }
    if (isNamed && isPositional) {
      errorInSlang(args.head.pos, "Cannot mix positional and named arguments")
      Right(ISZ())
    } else if (isNamed) Left(ISZ(args.map(namedArg): _*))
    else Right(ISZ(args.map(expArg): _*))
  }

  def translateApply(fun: AST.Exp, termArgs: Seq[Term], pos: Position): AST.Exp = {
    translateArgs(termArgs) match {
      case Left(args) => AST.Exp.InvokeNamed(Some(fun), cidNoCheck("apply", pos), ISZ(), args, resolvedAttr(pos))
      case Right(args) => AST.Exp.Invoke(Some(fun), cidNoCheck("apply", pos), ISZ(), args, resolvedAttr(pos))
    }
  }

  def checkLSyntax(exp: Term.Interpolate): Boolean = {
    val startOffset = exp.pos.start
    val c = text.charAt(startOffset)
    if (!text.substring(startOffset + 1, exp.pos.end).startsWith("\"\"\"")) {
      error(exp.pos, "'" + c + "\"\"\"...\"\"\"' should be used instead of '" + c + "\"...\"'.")
      false
    } else true
  }

  def lParser[T](exp: Term.Interpolate)(f: LParser => T): T = {
    val pos = exp.pos
    val startOffset = pos.start + 4
    val endOffset = pos.end - 3
    lPointOpt = scala.Some(startOffset)
    try f(new LParser(Input.Slice(input, startOffset, endOffset), dialect, this))
    catch {
      case e: ParseException =>
        throw ParseException(Position.Range(input, startOffset + e.pos.start, startOffset + e.pos.end), e.shortMessage)
      case e: TokenizeException =>
        throw TokenizeException(
          Position.Range(input, startOffset + e.pos.start, startOffset + e.pos.end),
          e.shortMessage
        )
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
    if (!checkLSyntax(exp)) return emptyContract
    lParser(exp)(_.defContract())
  }

  def parseLStmt(enclosing: Enclosing.Type, exp: Term.Interpolate): AST.Stmt = {
    def isProofSequentContext: Boolean = enclosing match {
      case Enclosing.Top | Enclosing.Object | Enclosing.ExtObject | Enclosing.Method | Enclosing.Block |
          Enclosing.DatatypeClass | Enclosing.RecordClass =>
        true
      case _ => false
    }

    def isInvariantContext: Boolean = enclosing match {
      case Enclosing.Top | Enclosing.Object | Enclosing.ExtObject | Enclosing.DatatypeTrait | Enclosing.DatatypeClass |
          Enclosing.RecordTrait | Enclosing.RecordClass | Enclosing.Sig =>
        true
      case _ => false
    }

    def isFactsTheoremsContext: Boolean = enclosing match {
      case Enclosing.Top | Enclosing.Object => true
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

  def checkNestedMethods(stmts: ISZ[AST.Stmt]): ISZ[AST.Stmt] = {
    for (stmt <- stmts) stmt match {
      case stmt: AST.Stmt.Method => checkNestedMethods(stmt)
      case _ =>
    }
    stmts
  }

  def checkNestedMethods(m: AST.Stmt.Method): Unit = {
    val set = scala.collection.mutable.HashSet[Predef.String]()
    val transformer = new AST.Transformer[Unit](new AST.Transformer.PrePost[Unit] {
      def string: String = ""

      override def preStmtMethod(ctx: Unit, o: AST.Stmt.Method): AST.Transformer.PreResult[Unit, AST.Stmt] = {
        val id = o.sig.id.value.value
        if (set.contains(id)) {
          reporter.error(o.sig.id.attr.posOpt, SlangParser.messageKind, s"Cannot redeclare nested method '$id'.")
        }
        set.add(id)
        super.preStmtMethod(ctx, o)
      }
    })
  }

  def cid(t: Pat.Var): AST.Id = cid(t.name.value, t.pos)

  def cid(name: Name): AST.Id = cid(name.value, name.pos)

  def cidNoCheck(id: Predef.String, pos: Position): AST.Id =
    AST.Id(id, attr(pos))

  def cid(id: Predef.String, pos: Position): AST.Id = {
    if (id.contains('$') || id.endsWith("_="))
      errorInSlang(pos, s"'$id' is not a valid identifier form")

    cidNoCheck(id, pos)
  }

  def checkTypeId(pos: Position, id: Predef.String): Unit = {
    if (disallowedTypeIds.contains(id)) {
      errorInSlang(pos, s"Type identifier $id is disallowed")
    }
  }

  def isSymbolFirstChar(c: Char): Boolean = {
    c match {
      case '*' | '/' | '%' | '+' | '-' | ':' | '=' | '!' | '<' | '>' | '&' | '^' | '|' => true
      case _ => fastparse.CharPredicates.isMathSymbol(c) || fastparse.CharPredicates.isOtherSymbol(c)
    }
  }

  def isSymbolFollowChar(c: Char): Boolean = {
    c match {
      case '@' | '#' | '?' => true
      case _ => isSymbolFirstChar(c)
    }
  }

  def checkSymbol(id: Predef.String): Boolean = {
    id.headOption.exists(isSymbolFirstChar)
  }

  def checkMethodId(pos: Position, id: Predef.String): Unit = {
    def err(): Unit = errorInSlang(pos, s"Identifier $id is disallowed")

    if (disallowedMethodIds.contains(id)) {
      err()
    } else if (unaryMethods.contains(id)) {
      return
    } else if (id.startsWith("unary_")) {
      err()
    } else {
      val i = id.lastIndexOf('_')
      if (i >= 0 && i != id.length - 1) {
        val ending = id.substring(i + 1)
        if (disallowedMethodIdEndings.contains(ending)) {
          err()
        } else {
          try {
            BigInt(ending)
            err()
          } catch {
            case _: Throwable =>
          }
        }
      }
    }
    if (id.headOption.exists(isSymbolFirstChar)) {
      if (!id.tail.forall(isSymbolFollowChar)) {
        errorInSlang(pos, s"Cannot mix symbol and non-symbol characters for identifier starting with a symbol")
      }
    }
  }

  def attr(pos: Position): AST.Attr = AST.Attr(posOpt = posOpt(pos))

  def typedAttr(pos: Position): AST.TypedAttr = AST.TypedAttr(posOpt = posOpt(pos), typedOpt = None())

  def resolvedAttr(pos: Position): AST.ResolvedAttr =
    AST.ResolvedAttr(posOpt = posOpt(pos), resOpt = None(), typedOpt = None())

  def ref2IS(ref: Term): ISZ[AST.Id] = {
    def f(t: Term): ISZ[AST.Id] = t match {
      case name: Term.Name => ISZ(cid(name))
      case q"$expr.$name" => f(expr) :+ cid(name)
      case _ =>
        errorInSlang(t.pos, s"Invalid name reference '${ref.syntax}'")
        ISZ(rDollarId)
    }

    f(ref)
  }

  def syntax(t: Tree, max: Int = 20): Predef.String = {
    val startOffset = lPointOpt.getOrElse(0)
    val text = this.text.substring(startOffset + t.pos.start, startOffset + t.pos.end)
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
