/*
 Copyright (c) 2016, Robby, Kansas State University
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

package org.sireum.logika.ast

import java.io.StringReader
import org.sireum.util._

import org.sireum.util.{AccumulatingTagReporter, FileResourceUri, LocationInfo, Natural, Visitor}

object AstUtil {
  def wipe(fileUriOpt: Option[FileResourceUri],
           programText: String,
           bitWidth: Natural,
           autoEnabled: Boolean)(
            implicit reporter: AccumulatingTagReporter): (String, Program) = {
    val newProgramText = wipeContractAndPrintStatements(
      wipeCommentsAndLogikaAssertions(programText),
      bitWidth,
      autoEnabled)
    val p = Builder(fileUriOpt, newProgramText, bitWidth, autoEnabled).get.asInstanceOf[Program]
    (newProgramText, p)
  }

  private def wipeCommentsAndLogikaAssertions(content: String): String = {
    val contentChars = content.toCharArray

    def wipe(t: org.antlr.v4.runtime.Token): Unit =
      for (i <- t.getStartIndex to t.getStopIndex)
        if (!contentChars(i).isWhitespace)
          contentChars(i) = ' '

    import scala.collection.JavaConverters._
    import org.antlr.v4.runtime.ANTLRInputStream
    import org.sireum.logika.parser.Antlr4LogikaLexer
    import Antlr4LogikaLexer._
    val sr = new StringReader(content)
    val inputStream = new ANTLRInputStream(sr)
    val lexer = new Antlr4LogikaLexer(inputStream)
    var inProof = false
    for (t <- lexer.getAllTokens.asScala) t.getType match {
      case COMMENT | LINE_COMMENT => wipe(t)
      case _ =>
        t.getText match {
          case "l\"\"\"" => inProof = true; wipe(t)
          case "\"\"\"" => inProof = false; wipe(t)
          case _ => if (inProof) wipe(t)
        }
    }
    new String(contentChars)
  }

  private def wipeContractAndPrintStatements(content: String,
                                             bitWidth: Natural,
                                             autoEnabled: Boolean)(
                                              implicit reporter: AccumulatingTagReporter): String = {
    val contentChars = content.toCharArray

    def wipe(li: LocationInfo): Boolean = {
      for (i <- 0 until li.length) {
        val j = li.offset + i
        if (!contentChars(j).isWhitespace)
          contentChars(j) = ' '
      }
      false
    }

    val program = Builder(None, content, bitWidth, autoEnabled).get

    Visitor.build({
      case n: Assert => wipe(program.nodeLocMap(n))
      case n: Assume => wipe(program.nodeLocMap(n))
      case n: Print => wipe(program.nodeLocMap(n))
    })(program)

    new String(contentChars).split('\n').map(_.replaceFirst("\\s++$", "")).
      mkString(scala.util.Properties.lineSeparator).replaceFirst("\\s++$", "")
  }

  def equal(result: UnitNode, expected: UnitNode): Boolean =
    try equal(result, expected, result.nodeLocMap, expected.nodeLocMap) catch {
      case _: CompareException => false
    }

  private def equal(o1: Any, o2: Any,
                    nodeLocMap1: MIdMap[Node, LocationInfo],
                    nodeLocMap2: MIdMap[Node, LocationInfo]): Boolean = {
    (o1, o2) match {
      case (o1: Node, o2: Node) =>
        if (o1.getClass.getName != o2.getClass.getName) throw CompareException(o1, o2)
        val len = o1.productArity
        for (i <- 0 until len) {
          if (!equal(o1.productElement(i), o2.productElement(i), nodeLocMap1, nodeLocMap2))
            throw CompareException(o1, o2, i)
        }
        true
      case (o1: Product, o2: Product) =>
        if (o1.productArity != o2.productArity) return false
        var result = true
        for (i <- 0 until o1.productArity if result) {
          result = equal(o1.productElement(i), o2.productElement(i), nodeLocMap1, nodeLocMap2)
        }
        result
      case (o1: Iterable[_], o2: Iterable[_]) =>
        if (o1.size != o2.size) return false
        o1.zip(o2).forall(p => equal(p._1, p._2, nodeLocMap1, nodeLocMap2))
      case _ => o1 == o2
    }
  }

  private final case class CompareException(node1: Node,
                                            node2: Node,
                                            diffElementIndex: NaturalSentinel = -1) extends RuntimeException

}
