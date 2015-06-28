/*
Copyright (c) 2015, Robby, Kansas State University
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

package org.sireum.pilar.parser

import org.sireum.pilar.ast._
import org.sireum.pilar.parser.FastParser._
import org.sireum.util._

final class FastParser(input: String,
                       reporter: Reporter,
                       private val createLocInfo: Boolean,
                       private val max: Natural = 0,
                       private var line: PosInteger = 1,
                       private var column: PosInteger = 1,
                       private var offset: Natural = 0) {

  private val _max = if (max <= 0) input.length else max
  private implicit val _createLocInfo = createLocInfo
  private implicit val nodeLocMap = midmapEmpty[Node, LocationInfo]

  assert(offset <= _max)

  def parseModelFile(): Option[Model] = parseWithEOF(parseModel())

  def parseWithEOF[T](parse: => Option[T]): Option[T] = {
    val rOpt = parse
    if (rOpt.isEmpty) return None

    parseWhiteSpace()

    if (peek() == EOF) rOpt
    else {
      reporter.error(line, column, offset,
        s"Expected the end of input but found: '${input.substring(offset, _max)}'")
      None
    }
  }

  def parseModel(): Option[Model] = {
    var ok = true
    var recovered = false
    def rcv(): Unit = {
      ok = false
      val i = findKeywords(modelElementKeywords)
      if (i >= 0) {
        recovered = true
        consume(i)
      }
    }

    parseWhiteSpace()

    implicit val begin = (line, column, offset)

    val annotations = parseAnnotations(rcv)

    if (!ok && !recovered) return None

    var elements = Node.emptySeq[ModelElement]

    parseWhiteSpace()
    while (charEq(peek(), 'g') || charEq(peek(), 'd')) {
      val eOpt = parseModelElement(rcv)
      if (eOpt.isDefined) elements = elements :+ eOpt.get
      else ok = false
      parseWhiteSpace()
    }
    val r = Model(elements, annotations) at(line, column, offset)
    r.nodeLocMap = nodeLocMap

    Some(r)
  }

  def parseModelElement(recover: () => Unit): Option[ModelElement] = {
    parseWhiteSpace()
    peek() match {
      case 'g' =>
        if (matchKeyword("global")) {
          if (matchKeyword("var")) {
            return parseGlobalVarDecl(recover)
          }
        }
        recover()
        None
      case 'd' =>
        parseProcedureDecl(recover)
      case _ =>
        reporter.error(line, column, offset,
          "Expected either a global variable or a procedure declaration")
        None
    }
  }

  private def parseGlobalVarDecl(recover: () => Unit): Option[GlobalVarDecl] = {
    var ok = true
    def rcv(): Unit = {
      ok = false
      val i = findChar(';')
      if (i >= 0) {
        consume(i + 1)
      } else {
        recover()
      }
    }

    implicit val begin = (line, column, offset)

    val idOpt = parseID(rcv)
    if (idOpt.isEmpty) return None
    val id = idOpt.get

    val annotations = parseAnnotations(rcv)

    if (!ok) return None

    if (!matchChar(';') { s =>
      reporter.error(line, column, offset,
        s"Expected: ';', but found $s")
    }) {
      recover()
      return None
    }

    Some(GlobalVarDecl(id, annotations) at(line, column, offset))
  }

  private def parseProcedureDecl(recover: () => Unit): Option[ProcedureDecl] = {
    def rcvID(): Unit = {
      val i = findChar('(', ')', ';', '{', '#', '}')
      if (i >= 0) {
        consume(i)
      }
    }
    def rcvParam(): Unit = {
      var i = findChar(',', ')', ';', '{', '#', '}')
      if (i >= 0) {
        consume(i)
      } else {
        i = findChar(')', ';', '{', '}')
        if (i >= 0) {
          consume(i)
        }
      }
    }

    var ok = true
    def rcv(): Unit = {
      recover()
      ok = false
    }

    implicit val begin = (line, column, offset)

    if (!matchKeyword("def")) {
      recover()
      return None
    }

    var idOpt = parseID(rcvID)
    if (idOpt.isEmpty) idOpt = Some(Id("<missing>"))

    matchChar('(') { s =>
      reporter.error(line, column, offset,
        s"Expected: ')', but found $s")
    }

    var params = Node.emptySeq[ParamDecl]

    parseWhiteSpace()

    if (charNe(peek(), ')')) {

      val paramOpt = parseParamDecl(rcvParam)
      if (paramOpt.isDefined) params = params :+ paramOpt.get

      parseWhiteSpace()

      while (charEq(peek(), ',')) {
        consume()
        val paramOpt = parseParamDecl(rcvParam)
        if (paramOpt.isDefined) params = params :+ paramOpt.get

        parseWhiteSpace()
      }
    }

    matchChar(')') { s =>
      reporter.error(line, column, offset,
        s"Expected: ')', but found $s")
    }

    val annotations = parseAnnotations(rcv)

    if (!ok) return None

    var bodyOpt: Option[ProcedureBody] = None

    parseWhiteSpace()

    if (charEq(peek(), ';')) consume()
    else if (charEq(peek(), '{'))
      bodyOpt = parseProcedureBody(recover)
    else return None

    Some(ProcedureDecl(idOpt.get, params, bodyOpt, annotations).
      at(line, column, offset))
  }

  def parseParamDecl(recover: () => Unit): Option[ParamDecl] = {
    var ok = true
    def rcv(): Unit = {
      ok = false
      recover()
    }

    parseWhiteSpace()

    implicit val begin = (line, column, offset)

    val idOpt = parseID(rcv)
    if (idOpt.isEmpty) return None
    val id = idOpt.get

    val annotations = parseAnnotations(rcv)

    if (!ok) return None

    Some(ParamDecl(id, annotations) at(line, column, offset))
  }

  private[parser] def parseProcedureBody(recover: () => Unit): Option[ProcedureBody] = {
    def rcv(): Unit = {
      var i = findChar('#', '}')
      if (i >= 0) {
        consume(i)
      } else {
        i = findChar('}')
        if (i >= 0) {
          consume(i)
        } else {
          recover()
        }
      }
    }

    implicit val begin = (line, column, offset)

    var shouldRecover = false

    matchChar('{') { s =>
      reporter.error(line, column, offset,
        s"Expected: '{', but found $s")
      shouldRecover = true
    }

    var locals = Node.emptySeq[LocalVarDecl]

    parseWhiteSpace()

    if (charEq(peek(), 'v')) {
      matchKeyword("var")

      var ok = true

      val localOpt = parseLocalVarDecl(rcv)
      if (localOpt.nonEmpty)
        locals = locals :+ localOpt.get
      else ok = false

      parseWhiteSpace()

      while (ok && charNe(peek(), '#')) {
        val localOpt = parseLocalVarDecl(rcv)
        if (localOpt.nonEmpty)
          locals = locals :+ localOpt.get
        else ok = false
        parseWhiteSpace()
      }
    }

    var locations = Node.emptySeq[Location]

    while (charEq(peek(), '#')) {
      val locationOpt = parseLocation(rcv)
      if (locationOpt.nonEmpty)
        locations = locations :+ locationOpt.get

      parseWhiteSpace()
    }

    matchChar('}') { s =>
      reporter.error(line, column, offset,
        s"Expected: '}', but found $s")
      shouldRecover = true
    }

    val r = Some(ProcedureBody(locals, locations).
      at(line, column, offset))
    if (shouldRecover) {
      recover()
    }
    r
  }

  def parseLocalVarDecl(recover: () => Unit): Option[LocalVarDecl] = {
    var ok = true
    def rcv(): Unit = {
      recover()
      ok = false
    }

    parseWhiteSpace()

    implicit val begin = (line, column, offset)

    val idOpt = parseID(rcv)
    if (idOpt.isEmpty) return None
    val id = idOpt.get

    val annotations = parseAnnotations(rcv)

    if (!ok) return None

    if (!matchChar(';') { s =>
      reporter.error(line, column, offset,
        s"Expected: ';', but found $s")
    }) {
      recover()
      return None
    }

    Some(LocalVarDecl(id, annotations) at(line, column, offset))
  }

  def parseLocation(recover: () => Unit): Option[Location] = {
    var ok = true
    def rcv(): Unit = {
      ok = false
      val i = findChar('#', '}')
      if (i >= 0) {
        consume(i)
      } else {
        recover()
      }
    }

    parseWhiteSpace()

    implicit val begin = (line, column, offset)

    matchChar('#') {
      s =>
        reporter.error(line, column, offset,
          s"Expected: ';', but found $s")
        ok = false
    }

    if (!ok) {
      rcv()
      return None
    }

    val idOpt = parseID(recover)
    if (idOpt.isEmpty) return None
    val id = idOpt.get

    val annotations = parseAnnotations(recover)

    if (!ok) return None

    parseWhiteSpace()

    (peekKeyword(0, locationKeywords) match {
      case 0 => parseCallTransformation(id, annotations, recover)
      case _ => parseBlockTransformation(id, annotations, recover)
    }).map(_.at(line, column, offset))
  }

  private def parseCallTransformation(label: Id,
                                      annotations: Node.Seq[Annotation],
                                      recover: () => Unit)(
                                       implicit begin: (Int, Int, Int)): Option[Location] = {
    implicit val begin = (line, column, offset)

    if (!matchKeyword("call")) {
      recover()
      return None
    }

    var lhsOpt: Option[Exp] = None

    if (predictCallAssign()) {
      lhsOpt = parseExp(recover)
      if (lhsOpt.isEmpty) return None

      if (!matchCharSeq(":=", "assignment operator")) {
        recover()
        return None
      }
    }

    val idOpt = parseID(recover)
    if (idOpt.isEmpty) return None
    val id = idOpt.get

    val argsOpt = parseArg(recover)
    if (argsOpt.isEmpty) return None
    val args = argsOpt.get

    if (!matchKeyword("goto")) {
      recover()
      return None
    }

    val tOpt = parseID(recover)
    if (tOpt.isEmpty) return None
    val t = tOpt.get

    matchChar(';') { s =>
      reporter.error(line, column, offset,
        s"Expected: ';', but found $s")
      recover()
      return None
    }

    Some(CallLocation(label, lhsOpt, id, args, t, annotations))
  }

  private def parseBlockTransformation(label: Id,
                                       annotations: Node.Seq[Annotation],
                                       recover: () => Unit)(
                                        implicit begin: (Int, Int, Int)): Option[Location] = {
    var ok = true
    def rcv(): Unit = {
      ok = false
      recover()
    }

    var actions = Node.emptySeq[Action]

    while (predictAction()) {
      val actionOpt = parseAction(rcv)
      if (actionOpt.nonEmpty)
        actions = actions :+ actionOpt.get
      else {
        if (!ok) return None
      }
      parseWhiteSpace()
    }

    var jumpOpt = parseJump(rcv)
    if (jumpOpt.isEmpty) {
      if (!ok) return None
      else jumpOpt = Some(GotoJump(Id("<missing>"), Node.emptySeq))
    }

    Some(BlockLocation(label, actions, jumpOpt.get, annotations))
  }

  def parseAction(recover: () => Unit): Option[Action] = {
    parseWhiteSpace()
    peekKeyword(0, actionKeywords) match {
      case 0 => parseAssertAction(recover)
      case 1 => parseAssumeAction(recover)
      case 2 => parseExtAction(recover)
      case _ => parseAssignAction(recover)
    }
  }

  private def parseAssignAction(recover: () => Unit): Option[AssignAction] = {
    var ok = true
    def rcv(): Unit = {
      ok = false
      val i = findChar(';', '#', '}')
      if (i >= 0) {
        consume(i + 1)
      } else {
        recover()
      }
    }

    implicit val begin = (line, column, offset)

    val lhsOpt = parseExp(rcv)
    if (lhsOpt.isEmpty) return None
    val lhs = lhsOpt.get

    if (!matchCharSeq(":=", "assignment operator")) {
      rcv()
      return None
    }

    val rhsOpt = parseExp(rcv)
    if (rhsOpt.isEmpty) return None
    val rhs = rhsOpt.get

    val annotations = parseAnnotations(rcv)

    if (!ok) return None

    if (!matchChar(';') { s =>
      reporter.error(line, column, offset,
        s"Expected: ';', but found $s")
    }) {
      recover()
      return None
    }

    Some(AssignAction(lhs, rhs, annotations) at(line, column, offset))
  }


  private def parseAssertAction(recover: () => Unit): Option[AssertAction] = {
    var ok = true
    def rcv(): Unit = {
      ok = false
      val i = findChar(';', '#', '}')
      if (i >= 0) {
        consume(i + 1)
      } else {
        recover()
      }
    }

    implicit val begin = (line, column, offset)

    if (!matchKeyword("assert")) {
      rcv()
      return None
    }

    val expOpt = parseExp(rcv)
    if (expOpt.isEmpty) return None
    val exp = expOpt.get

    val annotations = parseAnnotations(rcv)

    if (!ok) return None

    if (!matchChar(';') { s =>
      reporter.error(line, column, offset,
        s"Expected: ';', but found $s")
    }) {
      recover()
      return None
    }

    Some(AssertAction(exp, annotations) at(line, column, offset))
  }

  private def parseAssumeAction(recover: () => Unit): Option[AssumeAction] = {
    var ok = true
    def rcv(): Unit = {
      ok = false
      val i = findChar(';', '#', '}')
      if (i >= 0) {
        consume(i + 1)
      } else {
        recover()
      }
    }

    implicit val begin = (line, column, offset)

    if (!matchKeyword("assume")) {
      rcv()
      return None
    }

    val expOpt = parseExp(rcv)
    if (expOpt.isEmpty) return None
    val exp = expOpt.get

    val annotations = parseAnnotations(rcv)

    if (!ok) return None

    if (!matchChar(';') { s =>
      reporter.error(line, column, offset,
        s"Expected: ';', but found $s")
    }) {
      recover()
      return None
    }

    Some(AssumeAction(exp, annotations) at(line, column, offset))
  }

  private def parseExtAction(recover: () => Unit): Option[ExtAction] = {
    var ok = true
    def rcv(): Unit = {
      ok = false
      val i = findChar(';', '#', '}')
      if (i >= 0) {
        consume(i + 1)
      } else {
        recover()
      }
    }

    implicit val begin = (line, column, offset)

    if (!matchKeyword("ext")) {
      rcv()
      return None
    }

    val idOpt = parseID(rcv)
    if (idOpt.isEmpty) return None
    val id = idOpt.get

    val argsOpt = parseArg(rcv)
    if (argsOpt.isEmpty) return None
    val args = argsOpt.get

    val annotations = parseAnnotations(rcv)

    if (!ok) return None

    if (!matchChar(';') { s =>
      reporter.error(line, column, offset,
        s"Expected: ';', but found $s")
    }) {
      recover()
      return None
    }

    Some(ExtAction(id, args, annotations) at(line, column, offset))
  }

  def parseJump(recover: () => Unit): Option[Jump] = {
    parseWhiteSpace()
    peek() match {
      case 'g' => parseGotoJump(recover)
      case 'i' => parseIfJump(recover)
      case 'r' => parseReturnJump(recover)
      case 's' => parseSwitchJump(recover)
      case 'j' => parseExtJump(recover)
      case _ =>
        reporter.error(line, column, offset,
          s"Expected a goto, if, return, switch, or extension jump")
        recover()
        None
    }
  }

  private def parseGotoJump(recover: () => Unit): Option[GotoJump] = {
    var ok = true
    def rcv(): Unit = {
      ok = false
      val i = findChar(';', '#', '}')
      if (i >= 0) {
        consume(i + 1)
      } else {
        recover()
      }
    }

    implicit val begin = (line, column, offset)

    if (!matchKeyword("goto")) {
      rcv()
      return None
    }

    val idOpt = parseID(rcv)
    if (idOpt.isEmpty) return None
    val id = idOpt.get

    val annotations = parseAnnotations(rcv)

    if (!ok) return None

    if (!matchChar(';') { s =>
      reporter.error(line, column, offset,
        s"Expected: ';', but found $s")
    }) {
      recover()
      return None
    }

    Some(GotoJump(id, annotations) at(line, column, offset))
  }

  private def parseIfJump(recover: () => Unit): Option[IfJump] = {
    var ok = true
    def rcv(): Unit = {
      ok = false
      val i = findChar(';', '#', '}')
      if (i >= 0) {
        consume(i + 1)
      } else {
        recover()
      }
    }

    implicit val begin = (line, column, offset)

    if (!matchKeyword("if")) {
      rcv()
      return None
    }

    val expOpt = parseExp(rcv)
    if (expOpt.isEmpty) return None
    val exp = expOpt.get

    if (!matchKeyword("then")) {
      rcv()
      return None
    }

    val tOpt = parseID(rcv)
    if (tOpt.isEmpty) return None
    val t = tOpt.get

    if (!matchKeyword("else")) {
      rcv()
      return None
    }

    val fOpt = parseID(rcv)
    if (fOpt.isEmpty) return None
    val f = fOpt.get

    val annotations = parseAnnotations(rcv)

    if (!ok) return None

    if (!matchChar(';') { s =>
      reporter.error(line, column, offset,
        s"Expected: ';', but found $s")
    }) {
      recover()
      return None
    }

    Some(IfJump(exp, t, f, annotations) at(line, column, offset))
  }

  private def parseReturnJump(recover: () => Unit): Option[ReturnJump] = {
    var ok = true
    def rcv(): Unit = {
      ok = false
      val i = findChar(';', '#', '}')
      if (i >= 0) {
        consume(i + 1)
      } else {
        recover()
      }
    }

    implicit val begin = (line, column, offset)

    if (!matchKeyword("return")) {
      rcv()
      return None
    }

    parseWhiteSpace()

    val c = peek()
    var eOpt: Option[Exp] = None
    if (charNe(c, '@') && charNe(c, ';')) {
      eOpt = parseExp(rcv)
      if (eOpt.isEmpty) return None
    }

    val annotations = parseAnnotations(rcv)

    if (!ok) return None

    if (!matchChar(';') { s =>
      reporter.error(line, column, offset,
        s"Expected: ';', but found $s")
    }) {
      recover()
      return None
    }

    Some(ReturnJump(eOpt, annotations) at(line, column, offset))
  }

  private def parseSwitchJump(recover: () => Unit): Option[SwitchJump] = {
    var ok = true
    def rcv(): Unit = {
      ok = false
      val i = findChar(';', '#', '}')
      if (i >= 0) {
        consume(i + 1)
      } else {
        recover()
      }
    }

    implicit val begin = (line, column, offset)

    if (!matchKeyword("switch")) {
      rcv()
      return None
    }

    val expOpt = parseExp(rcv)
    if (expOpt.isEmpty) return None
    val exp = expOpt.get

    var cases = Node.emptySeq[SwitchCase]

    parseWhiteSpace()

    while (charEq(peek(), 'c')) {
      val begin2 = (line, column, offset)
      if (!matchKeyword("case")) {
        rcv()
        return None
      }

      val lit = parseIdOrLitExp(rcv) match {
        case Some(l: LiteralExp) => l
        case _ => return None
      }

      matchChar(':') { s =>
        reporter.error(line, column, offset,
          s"Expected: ':', but found $s")
        rcv()
        return None
      }

      val idOpt = parseID(rcv)
      if (idOpt.isEmpty) return None
      val id = idOpt.get

      cases = cases :+ SwitchCase(Some(lit), id).
        at(line, column, offset)(begin2, createLocInfo, nodeLocMap)

      parseWhiteSpace()
    }

    if (charEq(peek(), 'd')) {
      val begin2 = (line, column, offset)
      if (!matchKeyword("default")) {
        rcv()
        return None
      }

      matchChar(':') { s =>
        reporter.error(line, column, offset,
          s"Expected: ':', but found $s")
        rcv()
        return None
      }

      val idOpt = parseID(rcv)
      if (idOpt.isEmpty) return None
      val id = idOpt.get

      cases = cases :+ SwitchCase(None, id).
        at(line, column, offset)(begin2, createLocInfo, nodeLocMap)
    }

    val annotations = parseAnnotations(rcv)

    if (!ok) return None

    if (!matchChar(';') { s =>
      reporter.error(line, column, offset,
        s"Expected: ';', but found $s")
    }) {
      recover()
      return None
    }

    Some(SwitchJump(exp, cases, annotations) at(line, column, offset))
  }

  private def parseExtJump(recover: () => Unit): Option[ExtJump] = {
    var ok = true
    def rcv(): Unit = {
      ok = false
      val i = findChar(';', '#', '}')
      if (i >= 0) {
        consume(i + 1)
      } else {
        recover()
      }
    }

    implicit val begin = (line, column, offset)

    if (!matchKeyword("jext")) {
      rcv()
      return None
    }

    val idOpt = parseID(rcv)
    if (idOpt.isEmpty) return None
    val id = idOpt.get

    val argsOpt = parseArg(rcv)
    if (argsOpt.isEmpty) return None
    val args = argsOpt.get

    val annotations = parseAnnotations(rcv)

    if (!ok) return None

    if (!matchChar(';') { s =>
      reporter.error(line, column, offset,
        s"Expected: ';', but found $s")
    }) {
      recover()
      return None
    }

    Some(ExtJump(id, args, annotations) at(line, column, offset))
  }

  def parseExp(recover: () => Unit): Option[Exp] = {
    parseWhiteSpace()

    implicit val begin = (line, column, offset)

    val rOpt = parsePrimaryExpArgs(recover)

    if (rOpt.isEmpty) return None
    val r = rOpt.get

    var ok = true
    var (kind, (continue, i)) = peekID()
    var suffix = Node.emptySeq[(Id, Exp)]
    while (ok && continue) {
      val id = parseID(kind, i, recover).get

      parsePrimaryExpArgs(recover) match {
        case Some(e) => suffix = suffix :+ ((id, e))
        case _ => ok = false
      }

      if (ok) {
        parseWhiteSpace()

        val p = peekID()
        kind = p._1
        continue = p._2._1
        i = p._2._2
      }
    }
    if (ok && suffix.nonEmpty) {
      val (op, right) = suffix.head
      Some(InfixExp(r, op, right, suffix.tail).
        at(line, column, offset))
    } else Some(r)
  }

  private def parsePrimaryExpArgs(recover: () => Unit): Option[Exp] = {
    parseWhiteSpace()

    implicit val begin = (line, column, offset)

    var r =
      parsePrimaryExp(recover) match {
        case Some(prim) => prim
        case None => return None
      }


    var ok = true
    parseWhiteSpace()
    while (charEq(peek(), '(') && ok) {
      parseArg(recover) match {
        case Some(es) =>
          r = ExtExp(r, es) at(line, column, offset)
        case _ => ok = false
      }
      parseWhiteSpace()
    }
    Some(r)
  }

  private[parser] def parsePrimaryExp(recover: () => Unit): Option[Exp] = {
    if (charEq(peek(), '(')) parseTupleExp(recover)
    else parseIdOrLitExp(recover)
  }

  private def parseIdOrLitExp(recover: () => Unit): Option[Exp] = {
    parseWhiteSpace()

    implicit val begin = (line, column, offset)

    val idOpt = parseID(recover)
    if (idOpt.isEmpty) return None
    val id = idOpt.get

    parseWhiteSpace()

    peek() match {
      case '\'' | '\"' =>
        parseLIT(recover).map(raw =>
          LiteralExp(id, raw).at(line, column, offset))
      case _ =>
        val r = IdExp(id)
        if (createLocInfo)
          nodeLocMap(r) = nodeLocMap(id)
        Some(r)
    }
  }

  private def parseTupleExp(recover: () => Unit): Option[Exp] = {
    def rcv(): Unit = {
      var i = findChar(',', ')', ';', '#', '}')
      if (i >= 0) {
        consume(i)
        return
      }
      i = findChar(')', ';', '#', '}')
      if (i >= 0) {
        consume(i)
      } else {
        recover()
      }
    }

    implicit val begin = (line, column, offset)

    consume()

    val eOpt = parseExp(rcv)
    if (eOpt.isEmpty) return None
    val e = eOpt.get

    var ok = true
    var es = Node.seq(e)

    parseWhiteSpace()
    while (charEq(peek(), ',') && ok) {
      consume()
      parseExp(rcv) match {
        case Some(e2) => es = es :+ e2
        case _ => ok = false
      }
      parseWhiteSpace()
    }
    ok = ok && matchChar(')') {
      s =>
        reporter.error(line, column, offset,
          s"Expected: ')', but found $s")
        recover()
    }
    if (ok) {
      Some(TupleExp(es, parseAnnotations(recover)).
        at(line, column, offset))
    } else None
  }

  def parseAnnotations(recover: () => Unit): Node.Seq[Annotation] = {
    def rcv(): Unit = {
      val i = findChar('@', ';')
      if (i >= 0) consume(i)
      else recover()
    }

    var r = Node.emptySeq[Annotation]
    parseWhiteSpace()
    while (charEq(peek(), '@')) {
      parseAnnotation(rcv).foreach(a => r = r :+ a)
      parseWhiteSpace()
    }
    r
  }

  private[parser] def parseAnnotation(recover: () => Unit): Option[Annotation] = {
    implicit val begin = (line, column, offset)

    if (!matchChar('@') {
      s =>
        reporter.error(begin._1, begin._2, begin._3,
          s"Expected: '@', but found $s")
        recover()
    }) return None

    for (
      id <- parseID(recover);
      raw <- {
        parseWhiteSpace()
        if (charEq(peek(), '\'') || charEq(peek(), '"'))
          parseLIT(recover)
        else Some(Raw(""))
      }) yield {
      Annotation(id, raw) at(line, column, offset)
    }
  }

  @inline
  private def parseArg(recover: () => Unit): Option[Node.Seq[Exp]] = {
    def rcv(): Unit = {
      var i = findChar(',', ')', ';', '#', '}')
      if (i >= 0) {
        consume(i)
        return
      }
      i = findChar(')', ')', ';', '#', '}')
      if (i >= 0) {
        consume(i)
        return
      }
    }

    parseWhiteSpace()

    implicit val begin = (line, column, offset)

    var ok = matchChar('(') {
      s =>
        reporter.error(begin._1, begin._2, begin._3,
          s"Expected: '(', but found $s")
        recover()
    }
    if (!ok) return None

    var es = Node.emptySeq[Exp]

    parseWhiteSpace()

    if (charEq(peek(), ')')) {
      consume()
      return Some(es)
    }

    val eOpt = parseExp(recover)
    if (eOpt.isEmpty) return None
    es = es :+ eOpt.get

    parseWhiteSpace()

    while (charEq(peek(), ',') && ok) {
      consume()
      parseExp(rcv) match {
        case Some(e2) => es = es :+ e2
        case _ => ok = false
      }
      parseWhiteSpace()
    }
    ok = ok && matchChar(')') {
      s =>
        reporter.error(line, column, offset,
          s"Expected: ')', but found $s")
        recover()
    }
    if (ok) Some(es) else None
  }

  private[parser] def parseID(recover: () => Unit): Option[Id] = {
    parseWhiteSpace()
    peek() match {
      case '`' =>
        val (ok, i) = peekComplexID()
        parseComplexID(ok, i, recover)
      case '.' | '~' | '!' | '%' | '^' | '&' | '*' |
           '-' | '+' | '=' | '|' | '<' | '>' | '/' | '?' =>
        val (ok, i) = peekOpID()
        parseOpID(ok, i, recover)
      case _ =>
        val (ok, i) = peekSimpleID()
        parseSimpleID(ok, i, recover)
    }
  }

  private[parser] def parseLIT(recover: () => Unit): Option[Raw] = {
    parseWhiteSpace()
    peek() match {
      case '\'' =>
        val (ok, i) = peekSimpleLIT()
        parseSimpleLIT(ok, i, recover)
      case '"' =>
        val (ok, i) = peekComplexLIT()
        parseComplexLIT(ok, i, recover)
      case c =>
        reporter.error(line, column, offset,
          s"Invalid character for a literal string: '${
            c.asInstanceOf[Char]
          }'")
        recover()
        None
    }
  }

  private def parseID(kind: FastParser.IdKind.Value,
                      i: Natural,
                      recover: () => Unit) =
    kind match {
      case FastParser.IdKind.Simple => parseSimpleID(ok = true, i, recover)
      case FastParser.IdKind.Op => parseOpID(ok = true, i, recover)
      case FastParser.IdKind.Complex => parseComplexID(ok = true, i, recover)
    }

  @inline
  private def parseComplexID(ok: Boolean, i: Natural, recover: () => Unit) = {
    implicit val begin = (line, column, offset)
    if (ok) {
      consume(i)
      Some(Id(input.substring(begin._3 + 1, offset - 1).intern()).
        at(line, column, offset))
    } else {
      reporter.error(begin._1, begin._2, begin._3,
        s"Expected a complex identifier form but found: '${
          input.substring(begin._3, offset + i)
        }'")
      recover()
      None
    }
  }

  @inline
  private def parseOpID(ok: Boolean, i: Natural, recover: () => Unit) = {
    implicit val begin = (line, column, offset)
    if (ok) {
      consume(i)
      Some(Id(input.substring(begin._3, offset).intern()).
        at(line, column, offset))
    } else {
      reporter.error(begin._1, begin._2, begin._3,
        s"Expected a Op identifier form but found: '${
          input.substring(begin._3, offset + i)
        }'")
      recover()
      None
    }
  }

  @inline
  private def parseSimpleID(ok: Boolean, i: Natural, recover: () => Unit) = {
    implicit val begin = (line, column, offset)
    if (ok) {
      consume(i)
      Some(Id(input.substring(begin._3, offset).intern()).
        at(line, column, offset))
    } else {
      if (i == 0)
        reporter.error(begin._1, begin._2, begin._3,
          "Expected an identifier but found" + (
            if (offset + i < _max) s": '${
              peek().asInstanceOf[Char]
            }'"
            else " nothing"))
      else
        reporter.error(begin._1, begin._2, begin._3,
          s"Expected an identifier but found: '${
            input.substring(begin._3, offset + i)
          }'")
      recover()
      None
    }
  }

  @inline
  private def predictAction() = peek() match {
    case 'a' | 'e' => true
    case _ => predictID()
  }

  @inline
  private def predictID() = peek() match {
    case '`' => true
    case '.' | '~' | '!' | '%' | '^' | '&' | '*' |
         '-' | '+' | '=' | '|' | '<' | '>' | '/' | '?' => true
    case _ => peekSimpleID()._1
  }

  @inline
  private def peekID() = peek() match {
    case '`' =>
      (FastParser.IdKind.Complex, peekComplexID())
    case '.' | '~' | '!' | '%' | '^' | '&' | '*' |
         '-' | '+' | '=' | '|' | '<' | '>' | '/' | '?' =>
      (FastParser.IdKind.Op, peekOpID())
    case _ =>
      (FastParser.IdKind.Simple, peekSimpleID())
  }

  @inline
  private def peekSimpleID() = {
    val p = peekOneStar(peek, 0, isJavaLetter, isJavaDigitOrLetter)
    val (ok, i) = p
    if (ok &&
      keywords.contains(input.substring(offset, offset + i)))
      (false, 0)
    else p
  }

  @inline
  private def peekOpID(offset: Natural = 0) =
    peekOneStar(peek, offset, isOpIDFirstChar, isOpIDTrailingChar)

  @inline
  private def peekSimpleLIT(offset: Natural = 0) =
    peekOneStar(peek, offset, isSimpleLITFirstChar, isSimpleLITTrailingChar)

  @inline
  private def peekComplexID(offset: Natural = 0) =
    peekOnePlusOne(offset, '`', isComplexIDChar, '`')

  @inline
  private def parseSimpleLIT(ok: Boolean, i: Natural, recover: () => Unit) = {
    implicit val begin = (line, column, offset)
    if (ok) {
      consume(i)
      Some(Raw(input.substring(begin._3 + 1, offset)).
        at(line, column, offset))
    } else {
      reporter.error(begin._1, begin._2, begin._3,
        s"Expected a single-quoted string literal but found: '${
          input.substring(begin._3, offset + i)
        }'")
      recover()
      None
    }
  }

  @inline
  private def parseComplexLIT(ok: Boolean, i: Natural, recover: () => Unit): Option[Raw] = {
    implicit val begin = (line, column, offset)
    if (ok) {
      consume(i)
      Some(Raw(input.substring(begin._3 + 1, offset - 1).
        replaceAll( """\\\\""", "\\").
        replaceAll( """\\"""", "\"")).
        at(line, column, offset))
    } else {
      reporter.error(begin._1, begin._2, begin._3,
        s"Expected a multi-line string literal but found: '${
          input.substring(begin._3, offset + i)
        }'")
      recover()
      None
    }
  }

  @inline
  private def peekComplexLIT(offset: Natural = 0): (Boolean, Natural) = {
    // http://hackingoff.com/compilers/regular-expression-to-nfa-dfa
    // "(N|S("|S))*"
    // N is any char that is not "
    // S is \
    var state = 0
    var i = 0
    var ok = true
    var continue = true
    while (ok && continue) {
      val c = peek(offset + i)
      state match {
        case 0 =>
          c match {
            case '"' =>
              state = 1
              i += 1
            case _ => ok = false
          }
        case 1 =>
          c match {
            case '"' =>
              state = 2
              i += 1
            case '\\' =>
              state = 4
              i += 1
            case _ =>
              if (charNe(c, '"')) {
                state = 3
                i += 1
              } else ok = false
          }
        case 2 =>
          continue = false
        case 3 =>
          c match {
            case '"' =>
              state = 2
              i += 1
            case '\\' =>
              state = 4
              i += 1
            case _ =>
              if (charNe(c, '"')) {
                // state = 3
                i += 1
              } else ok = false
          }
        case 4 =>
          c match {
            case '"' =>
              state = 5
              i += 1
            case '\\' =>
              state = 6
              i += 1
            case _ => ok = false
          }
        case 5 =>
          c match {
            case '"' =>
              state = 2
              i += 1
            case '\\' =>
              state = 4
              i += 1
            case _ =>
              if (charNe(c, '"')) {
                state = 3
                i += 1
              } else ok = false
          }
        case 6 =>
          c match {
            case '"' =>
              state = 2
              i += 1
            case '\\' =>
              state = 4
              i += 1
            case _ =>
              if (charNe(c, '"')) {
                state = 3
                i += 1
              } else ok = false
          }
      }
    }
    (ok, offset + i)
  }

  @inline
  private def peekOnePlusOne(offset: Natural,
                             C: Char,
                             D: Int => Boolean,
                             E: Char): (Boolean, Natural) = {
    // http://hackingoff.com/compilers/regular-expression-to-nfa-dfa
    // CD+E
    // C is the starting character
    // D is the predicate for acceptable following characters until E
    // E is the ending character
    var state = 0
    var i = 0
    var ok = true
    var continue = true
    while (ok && continue) {
      val c = peek(offset + i)
      state match {
        case 0 =>
          if (charEq(c, C)) {
            state = 1
            i += 1
          } else ok = false
        case 1 =>
          if (D(c)) {
            state = 2
            i += 1
          } else ok = false
        case 2 =>
          if (charEq(c, E)) {
            state = 3
            i += 1
          } else if (D(c)) {
            // state = 2
            i += 1
          } else ok = false
        case 3 => continue = false
      }
    }
    (ok, offset + i)
  }

  @inline
  private def peekKeyword(offset: Int, keywords: Map[String, Int]): NaturalSentinel = {
    val (ok, i) = peekOneStar(peek, offset, isJavaLetter, isJavaDigitOrLetter)
    if (!ok) return naturalSentinel
    val s = input.substring(this.offset + offset, this.offset + i)
    keywords.getOrElse(s, naturalSentinel)
  }

  private def matchKeyword(s: String): Boolean = {
    parseWhiteSpace()
    val begin = (line, column, offset)
    if (!matchCharSeq(s, "keyword")) return false
    var isID = false
    while (isJavaDigitOrLetter(peek())) {
      consume()
      isID = true
    }

    if (isID) {
      reporter.error(begin._1, begin._2, begin._3,
        s"Expected: '$s', but found: '${
          input.substring(begin._3, offset + 1)
        }'")
      false
    } else {
      true
    }
  }

  private def matchCharSeq(s: String, something: String): Boolean = {
    parseWhiteSpace()
    val begin = (line, column, offset)
    var i = 0
    var ok = true
    while (i < s.length && ok) {
      if (charNe(peek(), s.charAt(i))) {
        ok = false
        if (i == 0)
          reporter.error(begin._1, begin._2, begin._3,
            s"Expected $something: '$s', but found nothing")
        else
          reporter.error(begin._1, begin._2, begin._3,
            s"Expected $something: '$s', but found: '${
              input.substring(begin._3, offset)
            }'")
      } else consume()
      i += 1
    }
    ok
  }

  private def matchChar(char: Char)(f: String => Unit): Boolean = {
    parseWhiteSpace()
    val c = peek()
    if (charNe(c, char)) {
      if (c == EOF) f(" nothing")
      else f(s": '${
        c.asInstanceOf[Char]
      }'")
      false
    } else {
      consume()
      true
    }
  }

  @inline
  private def parseWhiteSpace(): Unit = {
    while (isWhitespace(peek())) consume()
  }

  private def predictCallAssign(): Boolean = {
    var i = 0
    var d = peek(i)
    while (d != EOF && charNe(d, ';')) {
      d match {
        case '"' =>
          val (ok, j) = peekComplexLIT(i)
          if (ok) i = j else i += 1
        case '\'' =>
          val (ok, j) = peekSimpleLIT(i)
          if (ok) i = j else i += 1
        case '`' =>
          val (ok, j) = peekComplexID(i)
          if (ok) i = j else i += 1
        case '.' | '~' | '!' | '%' | '^' | '&' | '*' |
             '-' | '+' | '=' | '|' | '<' | '>' | '/' | '?' =>
          val (ok, j) = peekOpID(i)
          if (ok) i = j else i += 1
        case ':' =>
          if (charEq(peek(i + 1), '=')) return true
          else return true
        case _ =>
          i += 1
      }
      d = peek(i)
    }
    false
  }

  private def findChar(c: Char, limits: CharSentinel*): NaturalSentinel = {
    var i = 0
    var d = peek(i)
    while (d != EOF && charNe(d, c) && !limits.contains(d)) {
      d match {
        case '"' =>
          val (ok, j) = peekComplexLIT(i)
          if (ok) i = j else i += 1
        case '\'' =>
          val (ok, j) = peekSimpleLIT(i)
          if (ok) i = j else i += 1
        case '`' =>
          val (ok, j) = peekComplexID(i)
          if (ok) i = j else i += 1
        case '.' | '~' | '!' | '%' | '^' | '&' | '*' |
             '-' | '+' | '=' | '|' | '<' | '>' | '/' | '?' =>
          val (ok, j) = peekOpID(i)
          if (ok) i = j + 1 else i += 1
        case _ =>
          i += 1
      }
      d = peek(i)
    }
    if (charEq(d, c)) i else naturalSentinel
  }

  private def findKeywords(m: Map[String, Int]): NaturalSentinel = {
    var i = 0
    var d = peek(i)
    while (d != EOF && peekKeyword(i, m) == naturalSentinel) {
      d match {
        case '"' =>
          val (ok, j) = peekComplexLIT(i)
          if (ok) i = j else i += 1
        case '\'' =>
          val (ok, j) = peekSimpleLIT(i)
          if (ok) i = j else i += 1
        case '`' =>
          val (ok, j) = peekComplexID(i)
          if (ok) i = j else i += 1
        case '.' | '~' | '!' | '%' | '^' | '&' | '*' |
             '-' | '+' | '=' | '|' | '<' | '>' | '/' | '?' =>
          val (ok, j) = peekOpID(i)
          if (ok) i = j else i += 1
        case _ =>
          i += 1
      }
      d = peek(i)
    }
    if (d != EOF) i else naturalSentinel
  }


  @inline
  private def consume(n: Natural): Unit = {
    var i = 0
    while (i < n) {
      consume()
      i += 1
    }
  }

  @inline
  private def consume(): Char = {
    val c = input.charAt(offset)
    if (c == '\n') {
      line += 1
      column = 1
    } else {
      column += 1
    }
    offset += 1
    c
  }

  @inline
  private def peek(index: Natural = 0): CharSentinel = {
    val n = offset + index
    if (0 <= n && n < _max) input.charAt(n) else EOF
  }

  @inline
  private def isComplexIDChar(c: CharSentinel) = c match {
    case '\r' | '\n' | '\t' | '\u000C' | '`' => false
    case _ => true
  }
}

object FastParser {
  final val EOF = naturalSentinel
  final val keywords = Set(
    "assert",
    "assume",
    "call",
    "case",
    "def",
    "default",
    "else",
    "ext",
    "global",
    "goto",
    "if",
    "jext",
    "return",
    "switch",
    "then",
    "var"
  )
  final private val modelElementKeywords = Map("global" -> 0, "def" -> 1)
  final private val actionKeywords = Map("assert" -> 0, "assume" -> 1, "ext" -> 2)
  final private val locationKeywords = Map("call" -> 0)

  def apply(input: String,
            maxErrors: Natural = 0,
            reporter: Reporter = ConsoleReporter,
            createLocInfo: Boolean = false): Option[Model] = {
    class ParsingEscape extends RuntimeException

    val r = new Reporter {
      var i = 0

      override def error(line: PosInteger,
                         column: PosInteger,
                         offset: Natural,
                         message: String): Unit = {
        reporter.error(line, column, offset, message)
        i += 1
        if (maxErrors != naturalSentinel && i >= maxErrors)
          throw new ParsingEscape
      }
    }
    try {
      new FastParser(input, r, createLocInfo).parseModelFile()
    } catch {
      case _: ParsingEscape => None
    }
  }

  object IdKind extends Enum("Id") {
    type Type = Value
    val Simple = Value("Simple")
    val Op = Value("Op")
    val Complex = Value("Complex")
  }

  trait Reporter {
    def error(line: PosInteger,
              column: PosInteger,
              offset: Natural,
              message: String): Unit
  }

  object ConsoleReporter extends Reporter {
    override def error(line: PosInteger,
                       column: PosInteger,
                       offset: Natural,
                       message: String): Unit = {
      Console.err.println(s"[$line, $column] $message")
      Console.err.flush()
    }
  }

  private[parser] implicit class At[T <: Node](val n: T) extends AnyVal {
    def at(line: PosInteger,
           column: PosInteger,
           offset: Natural)(
      implicit t: (Int, Int, Int),
      createLocInfo: Boolean,
      nodeLocMap: MIdMap[Node, LocationInfo]): T = {
      if (createLocInfo)
        nodeLocMap(n) =
          org.sireum.util.LocationInfo(
            t._1, t._2, line, column, t._3, offset - t._3 + 1
          )
      n
    }
  }

  @inline
  private[pilar] def peekOneStar(peek: Natural => NaturalSentinel,
                                 offset: Natural,
                                 C: CharSentinel => Boolean,
                                 D: CharSentinel => Boolean): (Boolean, Natural) = {
    // http://hackingoff.com/compilers/regular-expression-to-nfa-dfa
    // CD*
    // C is the predicate for starting character
    // D is the predicate for acceptable following characters
    var state = 0
    var i = 0
    var ok = true
    var continue = true
    while (ok && continue) {
      val c = peek(offset + i)
      state match {
        case 0 =>
          if (C(c)) {
            state = 1
            i += 1
          } else ok = false
        case 1 =>
          if (D(c)) {
            state = 2
            i += 1
          } else continue = false
        case 2 =>
          if (D(c)) {
            // state = 2
            i += 1
          } else continue = false
      }
    }
    (ok, offset + i)
  }

  @inline
  private[pilar] def isOpIDFirstChar(c: CharSentinel): Boolean =
    c match {
      case '.' | '~' | '!' | '%' | '^' | '&' | '*' |
           '-' | '+' | '=' | '|' | '<' | '>' | '/' | '?' => true
      case _ => false
    }

  @inline
  private[pilar] def isOpIDTrailingChar(c: CharSentinel) =
    c match {
      case ' ' | '\r' | '\n' | '\t' | '\u000C' | ';' | '(' | ',' |
           ')' | '{' | '}' | '\'' | '"' | '#' | '@' | '`' | ':' | EOF => false
      case _ => true
    }

  @inline
  private def isSimpleLITFirstChar(c: CharSentinel) = charEq(c, '\'')

  @inline
  private[pilar] def isSimpleLITTrailingChar(c: CharSentinel) =
    c match {
      case ' ' | '\r' | '\n' | '\t' | '\u000C' | ';' | '(' | ',' |
           ')' | '{' | '}' | '\'' | '"' | '#' | '@' | '`' | ':' | EOF => false
      case _ => true
    }

  @inline
  private def charEq(cs: CharSentinel, c: Char) = cs == c.toInt

  @inline
  private def charNe(cs: CharSentinel, c: Char) = cs != c.toInt

  @inline
  private[pilar] def isJavaLetter(c: CharSentinel) =
    (c >= 'a' && c <= 'z') ||
      (c >= 'A' && c <= 'Z') ||
      charEq(c, '$') || charEq(c, '_')

  @inline
  private[pilar] def isJavaDigit(c: CharSentinel) = c >= '0' && c <= '9'

  @inline
  private[pilar] def isJavaDigitOrLetter(c: CharSentinel) =
    isJavaDigit(c) || isJavaLetter(c)

  @inline
  private[pilar] def isWhitespace(c: CharSentinel) = c match {
    case ' ' | '\r' | '\n' | '\t' | '\u000C' => true
    case _ => false
  }
}
