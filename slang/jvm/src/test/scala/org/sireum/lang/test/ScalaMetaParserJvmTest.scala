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

import Paths._

import org.sireum.test._
import org.sireum.lang.util.FileUtil._

class ScalaMetaParserJvmTest extends SireumSpec {

  val smpt = new ScalaMetaParserTest

  {
    implicit val _spec: SireumSpec = this

    "Passing" - {

      smpt.passing(readFile(posetPath), addImport = false, isPrelude = true)

      smpt.passing(readFile(setPath), addImport = false, isPrelude = true)

      smpt.passing(readFile(mapPath), addImport = false, isPrelude = true)

      smpt.passing(readFile(hashSetPath), addImport = false, isPrelude = true)

      smpt.passing(readFile(hashMapPath), addImport = false, isPrelude = true)

      smpt.passing(readFile(hashSSetPath), addImport = false, isPrelude = true)

      smpt.passing(readFile(hashSMapPath), addImport = false, isPrelude = true)

      smpt.passing(readFile(optionPath), addImport = false, isPrelude = true)

      smpt.passing(readFile(preludePath), addImport = false, isPrelude = true)

      smpt.passing(readFile(slangAstPath), addImport = false, isPrelude = true)

      smpt.passing(readFile(slangAstUtilPath), addImport = false, isPrelude = true)

      smpt.passing(readFile(slangTransformerPath), addImport = false, isPrelude = true)

      smpt.passing(readFile(slangMTransformerPath), addImport = false, isPrelude = true)

      smpt.passing(readFile(slangGlobalDeclarationResolverPath), addImport = false, isPrelude = true)

      smpt.passing(readFile(slangResolverPath), addImport = false, isPrelude = true)

      smpt.passing(readFile(slangSequentResolverPath), addImport = false, isPrelude = true)
    }
  }
}