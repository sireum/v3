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

package org.sireum.lang

import org.sireum.$internal.RC
import org.sireum.lang.ast.TopUnit
import org.sireum.{None => SNone}
import org.sireum.test.SireumRcSpec
import org.sireum.lang.test.TestUtil

class LParserTest extends SireumRcSpec {
  lazy val textResources: scala.collection.Map[scala.Seq[Predef.String], Predef.String] =
    RC.text(Seq())((p, _) => p.last.endsWith(".slang"))

  def check(path: scala.Seq[Predef.String], content: Predef.String): Boolean = {
    path.head match {
      case "truthtable" => parseTruthTable(content)
      case "propositional" => parsePropositional(content)
      case "predicate" => parsePredicate(content)
    }
  }

  def parsePredicate(input: String): Boolean =
    TestUtil.lparser(input) { (p, reporter) =>
      val r = p.sequentFile(SNone())
      TestUtil.check(reporter) && r.unitOpt.exists(_.isInstanceOf[TopUnit.SequentUnit])
    }

  def parsePropositional(input: String): Boolean =
    TestUtil.lparser(input) { (p, reporter) =>
      val r = p.sequentFile(SNone())
      TestUtil.check(reporter) && r.unitOpt.exists(_.isInstanceOf[TopUnit.SequentUnit])
    }

  def parseTruthTable(input: String): Boolean =
    TestUtil.lparser(input) { (p, reporter) =>
      val r = p.truthTable(SNone())
      TestUtil.check(reporter) && r.unitOpt.exists(_.isInstanceOf[TopUnit.TruthTableUnit])
    }
}
