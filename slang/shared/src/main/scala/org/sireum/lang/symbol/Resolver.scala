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
import org.sireum.lang.util.Reporter
import org.sireum.lang.{ast => AST}

object Resolver {

  @enum object Var {
    'Val
    'Var
    'SpecVar
    'SpecVal
  }

  @datatype trait Info

  @datatype class PackageInfo(ids: ISZ[String]) extends Info

  @datatype class ObjectInfo(ids: ISZ[String], isExt: B) extends Info

  @datatype class EnumInfo(ids: ISZ[String],
                           elements: ISZ[String])
    extends Info

  @datatype class SigInfo(ids: ISZ[String],
                          methods: Map[String, AST.Stmt.Method],
                          imports: ISZ[AST.Stmt.Import],
                          ast: AST.Stmt.Sig)
    extends Info

  @datatype class AbstractDatatypeInfo(ids: ISZ[String],
                                       vars: Map[String, AST.Stmt.Var],
                                       methods: Map[String, AST.Stmt.Method],
                                       imports: ISZ[AST.Stmt.Import],
                                       ast: AST.Stmt.AbstractDatatype)
    extends Info

  @datatype class RichInfo(ids: ISZ[String],
                           isRoot: B,
                           methods: Map[String, AST.Stmt.Method],
                           imports: ISZ[AST.Stmt.Import],
                           ast: AST.Stmt.Rich)
    extends Info

  val rootPackageInfo: PackageInfo = PackageInfo(ISZ())
}

import Resolver._

@record class GlobalDeclarationResolver(var globalNameMap: Map[ISZ[String], Resolver.Info],
                                        var packageInfo: PackageInfo,
                                        reporter: Reporter) {

  def resolveProgram(program: AST.TopUnit.Program): AST.TopUnit.Program = {
    declarePackageName(program.packageName) match {
      case Some(info) => packageInfo = info
      case _ => return program
    }

    ???
  }

  def declarePackage(name: ISZ[String], posOpt: Option[AST.PosInfo]): Unit = {
    globalNameMap.get(name) match {
      case Some(_: PackageInfo) =>
      case Some(_) =>
        reporter.error(posOpt, s"Cannot declare package name because the name has already been used for a non-package.")
      case _ => globalNameMap = globalNameMap.put(name, PackageInfo(name))
    }
  }

  def declarePackageName(name: AST.Name): Option[PackageInfo] = {
    val ids = name.ids
    if (name.ids.isEmpty) {
      return Some(rootPackageInfo)
    }
    var currentName = ISZ(ids(0).value)
    var currentPosOpt = ids(0).attr.posInfoOpt
    declarePackage(currentName, currentPosOpt)

    for (i <- 1 until ids.size) {
      currentName = currentName :+ ids(i).value
      currentPosOpt = ids(i).attr.posInfoOpt
      declarePackage(currentName, currentPosOpt)
    }

    globalNameMap.get(currentName) match {
      case Some(info: PackageInfo) => return Some(info)
      case _ => return None()
    }
  }
}
