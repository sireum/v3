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

package org.sireum.lang.tools

import org.sireum.lang.ast._
import org.sireum.lang.symbol.{GlobalDeclarationResolver, Resolver}
import org.sireum.lang.util.Reporter
import org.stringtemplate.v4.{ST, STGroup, STGroupFile}
import org.sireum.{ISZ, Map => SMap, None => SNone, Option => SOption, Some => SSome, String => SString}

object TransformerGen {

  def gen(program: TopUnit.Program,
          reporter: Reporter = new Reporter {
            def error(posOpt: SOption[PosInfo], message: SString): Unit = {
              posOpt match {
                case SSome(pos) => Console.err.println(s"[${pos.beginLine}, ${pos.beginColumn}] $message")
                case _ => Console.err.println(message)
              }
              Console.err.flush()
            }

            def warn(posOpt: SOption[PosInfo], message: SString): Unit = {
              posOpt match {
                case SSome(pos) => Console.out.println(s"[${pos.beginLine}, ${pos.beginColumn}] $message")
                case _ => Console.out.println(message)
              }
              Console.out.flush()
            }
          }): ST = {
    val gdr = GlobalDeclarationResolver(
      SMap.empty[ISZ[SString], Resolver.Info],
      SMap.empty[ISZ[SString], Resolver.TypeInfo],
      reporter
    )
    gdr.resolveProgram(program)
    new TransformerGen(new STGroupFile(getClass.getResource("mtransformer.stg"), "UTF-8", '$', '$'),
      gdr.globalNameMap, gdr.globalTypeMap, reporter).gen()
  }
}

class TransformerGen(stg: STGroup,
                     globalNameMap: SMap[ISZ[SString], Resolver.Info],
                     globalTypeMap: SMap[ISZ[SString], Resolver.TypeInfo],
                     reporter: Reporter) {
  def gen(): ST = {
    ???
  }
}
