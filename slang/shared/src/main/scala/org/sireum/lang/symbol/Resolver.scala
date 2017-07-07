// #Sireum
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

package org.sireum.lang.symbol

import org.sireum._
import org.sireum.lang.{ast => AST}

object Resolver {

  @datatype trait Info

  @datatype trait TypeInfo {

    def canHaveCompanion: B

    def posInfoOpt: Option[AST.PosInfo]
  }

  @datatype class PackageInfo(name: ISZ[String]) extends Info

  @datatype class VarInfo(name: ISZ[String],
                          imports: ISZ[AST.Stmt.Import],
                          ast: AST.Stmt.Var) extends Info

  @datatype class SpecVarInfo(name: ISZ[String],
                              imports: ISZ[AST.Stmt.Import],
                              ast: AST.Stmt.SpecVar) extends Info

  @datatype class MethodInfo(name: ISZ[String],
                             imports: ISZ[AST.Stmt.Import],
                             ast: AST.Stmt.Method) extends Info

  @datatype class SpecMethodInfo(name: ISZ[String],
                                 imports: ISZ[AST.Stmt.Import],
                                 ast: AST.Stmt.SpecMethod) extends Info

  @datatype class ObjectInfo(name: ISZ[String],
                             isExt: B)
    extends Info

  @datatype class ExtMethodInfo(name: ISZ[String],
                                imports: ISZ[AST.Stmt.Import],
                                ast: AST.Stmt.ExtMethod)
    extends Info

  @datatype class EnumInfo(name: ISZ[String],
                           elements: Set[String])
    extends Info

  @datatype class SigInfo(name: ISZ[String],
                          specVars: Map[String, AST.Stmt.SpecVar],
                          specMethods: Map[String, AST.Stmt.SpecMethod],
                          methods: Map[String, AST.Stmt.Method],
                          imports: ISZ[AST.Stmt.Import],
                          ast: AST.Stmt.Sig)
    extends TypeInfo {

    def canHaveCompanion: B = {
      return T
    }

    def posInfoOpt: Option[AST.PosInfo] = {
      return ast.attr.posInfoOpt
    }
  }

  @datatype class AbstractDatatypeInfo(name: ISZ[String],
                                       specVars: Map[String, AST.Stmt.SpecVar],
                                       vars: Map[String, AST.Stmt.Var],
                                       specMethods: Map[String, AST.Stmt.SpecMethod],
                                       methods: Map[String, AST.Stmt.Method],
                                       imports: ISZ[AST.Stmt.Import],
                                       ast: AST.Stmt.AbstractDatatype)
    extends TypeInfo {

    def canHaveCompanion: B = {
      return T
    }

    def posInfoOpt: Option[AST.PosInfo] = {
      return ast.attr.posInfoOpt
    }
  }

  @datatype class RichInfo(name: ISZ[String],
                           methods: Map[String, AST.Stmt.Method],
                           imports: ISZ[AST.Stmt.Import],
                           ast: AST.Stmt.Rich)
    extends TypeInfo {

    def canHaveCompanion: B = {
      return T
    }

    def posInfoOpt: Option[AST.PosInfo] = {
      return ast.attr.posInfoOpt
    }
  }

  @datatype class TypeAliasInfo(name: ISZ[String],
                                imports: ISZ[AST.Stmt.Import],
                                ast: AST.Stmt.TypeAlias)
    extends TypeInfo {

    def canHaveCompanion: B = {
      return F
    }

    def posInfoOpt: Option[AST.PosInfo] = {
      return ast.attr.posInfoOpt
    }
  }

  @datatype class Members(specVars: Map[String, AST.Stmt.SpecVar],
                          vars: Map[String, AST.Stmt.Var],
                          specMethods: Map[String, AST.Stmt.SpecMethod],
                          methods: Map[String, AST.Stmt.Method])

  val rootPackageInfo: PackageInfo = PackageInfo(ISZ())
}
