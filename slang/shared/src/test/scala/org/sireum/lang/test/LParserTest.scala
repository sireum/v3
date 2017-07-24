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

package org.sireum.lang.test

import org.sireum.lang.ast.TopUnit
import org.sireum.{B, T, HashSMap, ISZ, None => SNone, String => SString}
import org.sireum.lang.parser.LParser
import org.sireum.lang.util.AccumulatingReporter
import org.sireum.test.{SireumRcSpec, SireumSpec}
import org.sireum.`macro`.RC

import scala.meta._

class LParserTest extends SireumRcSpec {
  lazy val resources: HashSMap[ISZ[SString], SString] = RC.text(_.elements.last.value.endsWith(".slang"))

  def check(path: ISZ[SString], content: SString): B = {
    path(0).value match {
      case "truthtable" => parseTruthTable(content.value)
      case "propositional" => parsePropositional(content.value)
      case "predicate" => parsePredicate(content.value)
    }
  }

  def parsePredicate(input: String): Boolean =
    parser(input) { (p, reporter) =>
      val r = p.sequentFile(SNone())
      check(reporter) && r.unitOpt.exists(_.isInstanceOf[TopUnit.SequentUnit])
    }

  def parsePropositional(input: String): Boolean =
    parser(input) { (p, reporter) =>
      val r = p.sequentFile(SNone())
      check(reporter) && r.unitOpt.exists(_.isInstanceOf[TopUnit.SequentUnit])
    }

  def parseTruthTable(input: String): Boolean =
    parser(input) { (p, reporter) =>
      val r = p.truthTable(SNone())
      check(reporter) && r.unitOpt.exists(_.isInstanceOf[TopUnit.TruthTableUnit])
    }

  def check(r: AccumulatingReporter): Boolean = {
    if (r.hasIssue) r.printMessages()
    !r.hasIssue
  }

  def parser[T](input: String)(f: (LParser, AccumulatingReporter) => Boolean): Boolean = {
    val r: Boolean = try {
      LParser[Boolean](input, AccumulatingReporter(ISZ()))(f)
      //println(fparser(parser)
    } catch {
      case e: TokenizeException =>
        Console.err.println(s"[${e.pos.start.line}, ${e.pos.end.line}] ${e.getMessage}")
        e.printStackTrace()
        false
      case e: ParseException =>
        Console.err.println(s"[${e.pos.start.line}, ${e.pos.end.line}] ${e.getMessage}")
        e.printStackTrace()
        false
    }
    r
  }
}
