package org.sireum.lang.ast

import org.sireum._

object JSON_Ext extends _Json_Ext {
  object St {

    def stTopUnit(o: TopUnit): ST = o match {
      case o: TopUnit.TruthTableUnit => stTopUnitTruthTableUnit(o)
      case o: TopUnit.SequentUnit => stTopUnitSequentUnit(o)
      case o: TopUnit.Program => stTopUnitProgram(o)
    }

    def stTopUnitTruthTableUnit(o: TopUnit.TruthTableUnit): ST = {
      ???
    }

    def stLClauseSequent(sequent: LClause.Sequent): ST = ???

    def stTopUnitSequentUnit(o: TopUnit.SequentUnit): ST = _JsonSt.stRawObject(
      ("type", _JsonSt.stPredefString("TopUnit.SequentUnit")),
      ("fileUriOpt", stOption(o.fileUriOpt, stString)),
      ("sequent", stLClauseSequent(o.sequent))
    )

    def stTopUnitProgram(o: TopUnit.Program): ST = _JsonSt.stRawObject(
      ("type", _JsonSt.stPredefString("TopUnit.Program")),
      ("fileUriOpt", stOption(o.fileUriOpt, stString)),
      ("packageName", stName(o.packageName)),
      ("body", stBody(o.body))
    )

    def stName(o: Name): ST = ???

    def stBody(o: Body): ST = _JsonSt.stRawObject(
      ("type", _JsonSt.stPredefString("Body")),
      ("stmts", stISZComplex(o.stmts, stStmt))
    )

    def stStmt(o: Stmt): ST = ???
  }

  final class Parser(override val input: CharSequence) extends _JsonParser {
    override var offset: Int = 0

    def parseTopUnit(): TopUnit = parseObjectType("TopUnit.TruthTableUnit", "TopUnit.SequentUnit", "TopUnit.Program") match {
      case "TopUnit.TruthTableUnit" => ???
      case "TopUnit.SequentUnit" =>
        parseObjectKey("fileUriOpt")
        val fileUriOpt = parseOption(() => parseString())
        parseObjectNext()
        parseObjectKey("sequent")
        val sequent = parseLClauseSequent()
        parseObjectNext()
        TopUnit.SequentUnit(fileUriOpt, sequent)
      case "TopUnit.Program" =>
        parseObjectKey("fileUriOpt")
        val fileUriOpt = parseOption(() => parseString())
        parseObjectNext()
        val packageName = parseName()
        parseObjectNext()
        val body = parseBody()
        parseObjectNext()
        TopUnit.Program(fileUriOpt, packageName, body)
    }

    def parseName(): Name = ???

    def parseBody(): Body = {
      parseObjectType("Body")
      parseObjectKey("stmts")
      val stmts = parseISZ(() => parseStmt())
      Body(stmts)
    }

    def parseStmt(): Stmt = ???

    def parseLClauseSequent(): LClause.Sequent = ???
  }


  def fromTopUnit(o: TopUnit): String = St.stTopUnit(o).render

  def toTopUnit(s: String): TopUnit = new Parser(s.value).parseTopUnit()
}
