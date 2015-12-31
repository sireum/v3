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

package org.sireum.logika

import java.io.InputStreamReader

import org.sireum.logika.ast._
import org.sireum.logika.tipe.TypeChecker
import org.sireum.logika.util.ErrorCountingReporter
import org.sireum.test._
import org.sireum.util._
import org.sireum.util.jvm.FileUtil

final class ProgramTestDefProvider(tf: TestFramework)
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
        val name = f"function-to-loop-$x%d"
        ConditionTest(name, check(name))
      } ++
      (0 to 3).toVector.map { x =>
        val name = f"seq-$x%d"
        ConditionTest(name, check(name))
      } :+
      ConditionTest("bank", check("bank"))

  def check(filename: String): Boolean = {
    val r = new InputStreamReader(
      getClass.getResourceAsStream(filename + ".scala"))
    val text = FileUtil.readFile(r)
    r.close()
    implicit val reporter = ErrorCountingReporter

    val programOpt = Builder[Program](text)
    if (programOpt.isEmpty) assert(false)

    val program = programOpt.get

    if (!TypeChecker.check(program)) assert(false)

    if (!filename.startsWith("seq-"))
      Checker.check(program, autoEnabled = false, 2000)
    else true
  }
}