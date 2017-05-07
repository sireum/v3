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
import org.sireum.logika.message.{Check, CheckerKind, ProofFile}
import org.sireum.test._
import org.sireum.util._
import org.sireum.util.jvm.{FileUtil, OsUtil, OsArch}

final class SymExeProgramTestDefProvider(tf: TestFramework)
  extends TestDefProvider {

  val tmMult = OsUtil.detect match {
    case OsArch.Win => 0
    case _ => 1
  }

  override def testDefs: ISeq[TestDef] =
    ((1 to 1).toVector.map { x =>
      val name = f"symexe/assignment-$x%02d"
      ConditionTest('s' + name, check(name, 0, isSummarizing = true))
    } :+
      ConditionTest("symexe/square", check("symexe/square", 0, isSummarizing = true, timeout = 8000 * tmMult)) :+
      ConditionTest("symexe/max", check("symexe/max", 0, isSummarizing = true)) :+
      ConditionTest("symexe/abs", check("symexe/abs", 8, isSummarizing = true)) :+
      ConditionTest("symexe/abs-top", check("symexe/abs-top", 8, isSummarizing = true)) :+
      ConditionTest("symexe/prims", check("symexe/prims", 0, isSummarizing = true, timeout = 8000 * tmMult)) :+
      ConditionTest("symexe/seqs", check("symexe/seqs", 0, isSummarizing = true)) :+
      ConditionTest("symexe/ffsS8", check("symexe/ffsS8", 0, isSummarizing = true)) :+
      ConditionTest("symexe/ffsS8-top", check("symexe/ffsS8-top", 0, isSummarizing = true)) :+
      ConditionTest("symexe/ffsU32", check("symexe/ffsU32", 0, isSummarizing = true)) :+
      ConditionTest("symexe/factorial", check("symexe/factorial", 0, isSummarizing = true)) :+
      ConditionTest("symexe/plurality", check("symexe/plurality", 0, isSummarizing = true)) :+
      ConditionTest("symexe/plurality-opt", check("symexe/plurality-opt", 0, isSummarizing = true)) :+
      ConditionTest("symexe/if-return", check("symexe/if-return", 0, isSummarizing = true)) :+
      ConditionTest("symexe/pure-invoke", check("symexe/pure-invoke", 0, isSummarizing = true)) :+
      ConditionTest("symexe/pure-invoke2", check("symexe/pure-invoke2", 0, isSummarizing = true)) :+
      ConditionTest("usymexe/abs-top", check("symexe/abs-top", 8, isSummarizing = false)) :+
      ConditionTest("usymexe/ffsS8-top", check("symexe/ffsS8-top", 8, isSummarizing = false, timeout = 8000 * tmMult)) :+
      ConditionTest("usymexe/ffsU32-top", check("symexe/ffsU32-top", 8, isSummarizing = false, timeout = 8000 * tmMult)) :+
      ConditionTest("usymexe/ffsS8-loop", check("symexe/ffsS8-loop", 8, isSummarizing = false, timeout = 8000 * tmMult)) :+
      ConditionTest("usymexe/ffsU32-loop", check("symexe/ffsU32-loop", 8, isSummarizing = false, timeout = 16000 * tmMult)) :+
      ConditionTest("usymexe/ffsU32-loop-bug", check("symexe/ffsU32-loop-bug", 8, isSummarizing = false, hasError = true))
      ) ++
      (1 to 14).toVector.map { x =>
        val name = f"forward/assignment-$x%02d"
        ConditionTest(name, check(name, 0, isSummarizing = true))
      } ++
      (1 to 1).toVector.map { x =>
        val name = f"forward/conditional-$x%d"
        ConditionTest(name, check(name, 0, isSummarizing = true))
      } ++
      (2 to 3).toVector.map { x =>
        val name = f"forward/function-$x%d"
        ConditionTest(name, check(name, 0, isSummarizing = true))
      } ++
      (1 to 3).toVector.map { x =>
        val name = f"forward/function-to-loop-axiom-$x%d"
        ConditionTest(name, check(name, 0, isSummarizing = true))
      } ++
      (1 to 3).toVector.map { x =>
        val name = f"forward/function-to-loop-$x%d"
        ConditionTest(name, check(name, 0, isSummarizing = true))
      } ++
      (0 to 4).toVector.map { x =>
        val name = f"forward/seq-$x%d"
        ConditionTest(name, check(name, 0, isSummarizing = true))
      } ++
      (1 to 1).toVector.map { x =>
        val name = f"forward/method-$x%d"
        ConditionTest(name, check(name, 0, isSummarizing = true))
      } :+
      ConditionTest("forward/seq-axiom-3", check("forward/seq-axiom-3", 0, isSummarizing = true)) :+
      ConditionTest("forward/bank", check("forward/bank", 0, isSummarizing = true)) :+
      ConditionTest("forward/square", check("forward/square", 0, isSummarizing = true))

  def check(filename: String, bitWidth: Int, isSummarizing: Boolean, hasError: Boolean = false, timeout: Int = 5000): Boolean = {
    var uri = s"example/$filename.logika"
    val r = try new InputStreamReader(getClass.getResourceAsStream(uri))
    catch {
      case _: Throwable =>
        uri = s"example/$filename.sc"
        new InputStreamReader(getClass.getResourceAsStream(uri))
    }
    val text = FileUtil.readFile(r)
    r.close()
    implicit val reporter = new ConsoleTagReporter {
      override def info(msg: String): Unit = {
      }

      override def warn(msg: String): Unit = {
      }

      override def error(msg: String): Unit = {
        if (!hasError) {
          super.error(msg)
        }
      }
    }
    Checker.check(
      Check(requestId = "",
        isBackground = false,
        kind =
          if (isSummarizing) CheckerKind.SummarizingSymExe
          else CheckerKind.UnrollingSymExe,
        hintEnabled = true,
        inscribeSummoningsEnabled = true,
        coneInfluenceEnabled = true,
        proofs = ivector(ProofFile(Some(uri), text)),
        lastOnly = false,
        autoEnabled = true,
        timeout = timeout,
        checkSatEnabled = true,
        bitWidth = bitWidth,
        loopBound = 32,
        recursionBound = 10,
        useMethodContract = true))
    hasError == reporter.hasError
  }
}