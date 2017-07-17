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

import java.io.File

object Paths {
  val rootDir: File = new File(getClass.getResource(".").getPath, "../../../../../../../../../").getCanonicalFile

  val licensePath = new File(rootDir, "license.txt")

  val preludePackagePath = new File(rootDir, "runtime/prelude/shared/src/main/scala/org/sireum/")
  val slangPackagePath = new File(rootDir, "slang/shared/src/main/scala/org/sireum/lang")

  val preludePath = new File(preludePackagePath, "prelude.scala")

  val posetPath = new File(preludePackagePath, "Poset.scala")
  val setPath = new File(preludePackagePath, "Set.scala")
  val mapPath = new File(preludePackagePath, "Map.scala")
  val hashSetPath = new File(preludePackagePath, "HashSet.scala")
  val hashMapPath = new File(preludePackagePath, "HashMap.scala")
  val hashSSetPath = new File(preludePackagePath, "HashSSet.scala")
  val hashSMapPath = new File(preludePackagePath, "HashSMap.scala")
  val optionPath = new File(preludePackagePath, "Option.scala")
  val slangAstPath = new File(slangPackagePath, "ast/AST.scala")
  val slangMTransformerPath = new File(slangPackagePath, "ast/MTransformer.scala")
  val slangTransformerPath = new File(slangPackagePath, "ast/Transformer.scala")
}
