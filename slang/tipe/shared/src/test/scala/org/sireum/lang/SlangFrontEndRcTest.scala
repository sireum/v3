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

import org.sireum.$internal.Trie
import org.sireum.test._

class SlangFrontEndRcTest extends TestSuite {
  val notJs: Boolean = !org.sireum.$internal.Macro.isJs
  val tq = "\"\"\""

  val tests = Tests {

    "Library" - {

      passingRc(org.sireum.Library_Ext.trie)

    }

    "Slang" - {

      passingRc(org.sireum.lang.$SlangFiles.trie)

    }

  }

  def passingRc(n: Trie.Node[String, String])(implicit pos: org.scalactic.source.Position): Unit = n match {
    case n: Trie.InNode[String, String] =>
      for ((childKey, child) <- n.children) child match {
        case child: Trie.InNode[String, String] =>
          childKey - {
            passingRc(child)
          }
        case child: Trie.Leaf[String, String] =>
          registerTest(childKey, ts: _*)(
            assert(
              SlangFrontEndTest.passingCheck(child.data, addImport = false, isPrelude = true, checkJSON = false)
            )
          )(pos)
      }
    case _ =>
  }
}
