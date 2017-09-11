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

package org.sireum.lang.tipe

import org.sireum._
import org.sireum.ops._
import org.sireum.ops.ISZOps._
import org.sireum.lang.{ast => AST}
import org.sireum.lang.symbol.Resolver._
import org.sireum.lang.util._

object TypeChecker {
  type FunType = Map[String, AST.Typed] => AST.Typed
}

import TypeChecker._

@datatype class TypeChecker(globalNameMap: NameMap,
                            globalTypeMap: TypeMap,
                            typeHierarchy: TypeHierarchy.Type,
                            checkers: ISZ[TypeChecker]) {

  @memoize def applyType(isSpec: B,
                         fqName: QName,
                         typeArgs: Map[String, AST.Typed],
                         argTypes: ISZ[AST.Typed]): (AST.Typed, ISZ[Reporter.Message]) = {
    halt("TODO")
  }

  @memoize def applyTypeNamed(isSpec: B,
                              fqName: QName,
                              typeArgs: Map[String, AST.Typed],
                              argTypes: Map[String, AST.Typed]): (AST.Typed, ISZ[Reporter.Message]) = {
    halt("TODO")
  }

  @memoize def typeOfGlobalName(isSpec: B,
                                fqName: QName,
                                typeArgs: Map[String, AST.Typed]): (FunType, ISZ[Reporter.Message]) = {
    halt("TODO")
  }

  @memoize def memberType(isSpec: B,
                          fqName: QName,
                          typeArgs: Map[String, AST.Typed],
                          member: String,
                          memberTypeArgs: Map[String, AST.Typed]): (FunType, ISZ[Reporter.Message]) = {
    halt("TODO")
  }

  def rootTypes(): ISZ[QName] = {
    var r = ISZ[QName]()
    for (p <- typeHierarchy.poset.parents.entries) {
      if (p._2.isEmpty) {
        r = r :+ p._1.ids
      }
    }
    return r
  }

  def check(reporter: Reporter): Unit = {
    // WORKAROUND: has to use B => AccumulatingReporter instead of () => AccumulatingReporter
    // due to issues in scalameta macro expansion
    var typeInfos = ISZ[B => AccumulatingReporter]()
    for (info <- globalTypeMap.values) {
      info match {
        case info: TypeInfo.Sig =>
          typeInfos = typeInfos :+ ((_: B) => checkSig(info))
        case info: TypeInfo.AbstractDatatype =>
          typeInfos = typeInfos :+ ((_: B) => checkAdt(info))
        case info: TypeInfo.Rich =>
          typeInfos = typeInfos :+ ((_: B) => checkRich(info))
        case _ =>
      }
    }
    var objectInfos = ISZ[B => AccumulatingReporter]()
    for (info <- globalNameMap.values) {
      info match {
        case info: Info.Object =>
          objectInfos = objectInfos :+ ((_: B) => checkObject(info))
        case _ =>
      }
    }
    val r = ISOps(typeInfos ++ objectInfos).
      parMapFoldLeft(
        (f: B => AccumulatingReporter) => f(T),
        AccumulatingReporter.combine,
        AccumulatingReporter.create)
    reporter.reports(r.messages)
  }

  @memoize def checkVarType(typeParams: ISZ[AST.TypeParam],
                            info: Info.Var): (FunType, ISZ[Reporter.Message]) = {
    halt("TODO")
  }

  @memoize def checkSpecVarType(typeParams: ISZ[AST.TypeParam],
                                info: Info.SpecVar): (FunType, ISZ[Reporter.Message]) = {
    halt("TODO")
  }

  @memoize def checkSpecMethodType(typeParams: ISZ[AST.TypeParam],
                                   info: Info.SpecMethod): (FunType, ISZ[Reporter.Message]) = {
    halt("TODO")
  }

  @memoize def checkExtMethodType(typeParams: ISZ[AST.TypeParam],
                                  info: Info.ExtMethod): (FunType, ISZ[Reporter.Message]) = {
    halt("TODO")
  }

  @memoize def checkMethodType(typeParams: ISZ[AST.TypeParam],
                               info: Info.Method): (FunType, ISZ[Reporter.Message]) = {
    halt("TODO")
  }

  @pure def checkObject(ast: Info.Object): AccumulatingReporter = {
    halt("TODO")
  }

  @pure def checkSig(info: TypeInfo.Sig): AccumulatingReporter = {
    halt("TODO")
  }

  @pure def checkAdt(info: TypeInfo.AbstractDatatype): AccumulatingReporter = {
    halt("TODO")
  }

  @pure def checkRich(info: TypeInfo.Rich): AccumulatingReporter = {
    halt("TODO")
  }

  @pure def checkScript(program: AST.TopUnit.Program): AccumulatingReporter = {
    halt("TODO")
  }

}
