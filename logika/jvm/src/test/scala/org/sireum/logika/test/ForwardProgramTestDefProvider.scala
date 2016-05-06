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

package org.sireum.logika.test

import java.io.InputStreamReader

import org.sireum.logika.Checker
import org.sireum.logika.message.{CheckerKind, ProofFile, Check}
import org.sireum.test._
import org.sireum.util._
import org.sireum.util.jvm.FileUtil

final class ForwardProgramTestDefProvider(tf: TestFramework)
  extends TestDefProvider {

  override def testDefs: ISeq[TestDef] =
    (1 to 14).toVector.map { x =>
      val name = f"assignment-$x%02d"
      ConditionTest(name, check(name))
    } ++
      (1 to 1).toVector.map { x =>
        val name = f"conditional-$x%d"
        ConditionTest(name, check(name))
      } ++
      (2 to 3).toVector.map { x =>
        val name = f"function-$x%d"
        ConditionTest(name, check(name))
      } ++
      (1 to 3).toVector.map { x =>
        val name = f"function-to-loop-axiom-$x%d"
        ConditionTest(name, check(name))
      } ++
      (1 to 3).toVector.map { x =>
        val name = f"function-to-loop-$x%d"
        ConditionTest(name, check(name))
      } ++
      (0 to 4).toVector.map { x =>
        val name = f"seq-$x%d"
        ConditionTest(name, check(name))
      } ++
      (1 to 2).toVector.map { x =>
        val name = f"method-$x%d"
        ConditionTest(name, check(name))
      } :+
      ConditionTest("seq-axiom-3", check("seq-axiom-3")) :+
      ConditionTest("bank", check("bank")) :+
      ConditionTest("square", check("square"))

  def check(filename: String): Boolean = {
    val uri = s"example/forward/$filename.logika"
    val r = new InputStreamReader(
      getClass.getResourceAsStream(uri))
    val text = FileUtil.readFile(r)
    r.close()
    implicit val reporter = new ConsoleTagReporter {
      override def info(msg: String): Unit = {
      }

      override def warn(msg: String): Unit = {
      }
    }
    Checker.check(
      Check(requestId = "",
        isBackground = false,
        kind = CheckerKind.Forward,
        hintEnabled = true,
        inscribeSummoningsEnabled = true,
        coneInfluenceEnabled = true,
        proofs = ivector(ProofFile(Some(uri), text)),
        lastOnly = false,
        autoEnabled = false,
        timeout = 2000,
        checkSatEnabled = true,
        bitWidth = 0,
        loopBound = 10,
        recursionBound = 10,
        useMethodContract = true))
    !reporter.hasError
  }
}