// #Sireum
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

package org.sireum.lang.ast

import org.sireum._
import org.sireum.Json.Printer._

object JSON {

  object Printer {

    @pure def printTopUnit(o: TopUnit): ST = {
      o match {
        case o: TopUnit.TruthTableUnit => return printTopUnitTruthTableUnit(o)
        case o: TopUnit.SequentUnit => return printTopUnitSequentUnit(o)
        case o: TopUnit.Program => return printTopUnitProgram(o)
      }
    }

    @pure def printTopUnitTruthTableUnit(o: TopUnit.TruthTableUnit): ST = {
      ???
    }

    @pure def printLClauseSequent(sequent: LClause.Sequent): ST = {
      ???
    }

    @pure def printPurity(o: Purity.Type): ST = {
      val value: String = o match {
        case Purity.Impure => "Impure"
        case Purity.Pure => "Pure"
        case Purity.Memoize => "Memoize"
      }
      return printObject(ISZ(
        ("type", printString("Purity")),
        ("value", printString(value))
      ))
    }

    @pure def printTopUnitSequentUnit(o: TopUnit.SequentUnit): ST = {
      return printObject(ISZ(
        ("type", printString("TopUnit.SequentUnit")),
        ("fileUriOpt", printOption(o.fileUriOpt, printString)),
        ("sequent", printLClauseSequent(o.sequent))
      ))
    }

    @pure def printTopUnitProgram(o: TopUnit.Program): ST = {
      return printObject(ISZ(
        ("type", printString("TopUnit.Program")),
        ("fileUriOpt", printOption(o.fileUriOpt, printString)),
        ("packageName", printName(o.packageName)),
        ("body", printBody(o.body))
      ))
    }

    @pure def printName(o: Name): ST = {
      ???
    }

    @pure def printBody(o: Body): ST = {
      return printObject(ISZ(
        ("type", printString("Body")),
        ("stmts", printISZ(F, o.stmts, printStmt))
      ))
    }

    @pure def printStmt(o: Stmt): ST = {
      ???
    }
  }

  @record class Parser(input: String) {
    val parser: Json.Parser = Json.Parser.create(input)

    def parsePurity(): Purity.Type = {
      val r = parsePurityT(F)
      return r
    }

    def parsePurityT(typeParsed: B): Purity.Type = {
      if (!typeParsed) {
        parser.parseObjectType("Purity")
      }
      parser.parseObjectKey("value")
      val s = parser.parseString()
      s match {
        case "Impure" => return Purity.Impure
        case "Pure" => return Purity.Pure
        case "Memoize" => return Purity.Memoize
      }
    }

    def parseTopUnit(): TopUnit = {
      val t = parser.parseObjectTypes(ISZ("TopUnit.TruthTableUnit", "TopUnit.SequentUnit", "TopUnit.Program"))
      t match {
        case "TopUnit.TruthTableUnit" => ???
        case "TopUnit.SequentUnit" => val r = parseTopUnitSequentUnitT(T); return r
        case "TopUnit.Program" => val r = parseTopUnitProgramT(T); return r
      }
    }

    def parseTopUnitSequentUnit(): TopUnit.SequentUnit = {
      val r = parseTopUnitSequentUnitT(F)
      return r
    }

    def parseTopUnitSequentUnitT(typeParsed: B): TopUnit.SequentUnit = {
      if (!typeParsed) {
        parser.parseObjectType("TopUnit.SequentUnit")
      }
      parser.parseObjectKey("fileUriOpt")
      val fileUriOpt = parser.parseOption(parser.parseString)
      parser.parseObjectNext()
      parser.parseObjectKey("sequent")
      val sequent = parseLClauseSequent()
      parser.parseObjectNext()
      return TopUnit.SequentUnit(fileUriOpt, sequent)
    }

    def parseTopUnitProgram(): TopUnit.Program = {
      val r = parseTopUnitProgramT(F)
      return r
    }

    def parseTopUnitProgramT(typeParsed: B): TopUnit.Program = {
      if (!typeParsed) {
        parser.parseObjectType("TopUnit.Program")
      }
      parser.parseObjectKey("fileUriOpt")
      val fileUriOpt = parser.parseOption(parser.parseString)
      parser.parseObjectNext()
      parser.parseObjectKey("packageName")
      val packageName = parseName()
      parser.parseObjectNext()
      parser.parseObjectKey("body")
      val body = parseBody()
      parser.parseObjectNext()
      return TopUnit.Program(fileUriOpt, packageName, body)
    }

    def parseLClauseSequent(): LClause.Sequent = {
      val r = parseLClauseSequentT(F)
      return r
    }

    def parseLClauseSequentT(typeParsed: B): LClause.Sequent = {
      ???
    }

    def parseName(): Name = {
      val r = parseNameT(F)
      return r
    }

    def parseNameT(typeParsed: B): Name = {
      ???
    }

    def parseBody(): Body = {
      val r = parseBodyT(F)
      return r
    }

    def parseBodyT(typeParsed: B): Body = {
      if (!typeParsed) {
        parser.parseObjectType("Body")
      }
      parser.parseObjectKey("stmts")
      val stmts = parser.parseISZ(parseStmt)
      parser.parseObjectNext()
      return Body(stmts)
    }

    def parseStmt(): Stmt = {
      ???
    }

    def eof(): B = {
      val r = parser.eof()
      return r
    }

    def errorOpt: Option[Json.ErrorMsg] = {
      return parser.errorOpt
    }

  }

  def to[T](s: String, f: Parser => T): Either[T, Json.ErrorMsg] = {
    val parser = Parser(s)
    val r = f(parser)
    parser.eof()
    val eOpt = parser.errorOpt
    eOpt match {
      case Some(e) => return Either(None(), Some(e))
      case _ => return Either(Some(r), None())
    }
  }

  def fromTopUnit(o: TopUnit): String = {
    return Printer.printTopUnit(o).render
  }

  def toTopUnit(s: String): Either[TopUnit, Json.ErrorMsg] = {
    def fTopUnit(parser: Parser): TopUnit = {
      val r = parser.parseTopUnit()
      return r
    }
    val r = to(s, fTopUnit)
    return r
  }
}
