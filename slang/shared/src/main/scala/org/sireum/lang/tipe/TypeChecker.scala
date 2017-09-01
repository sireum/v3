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
  type TypeFactory = Map[String, AST.Typed] => AST.Typed
}

import TypeChecker._

@datatype class TypeChecker(globalNameMap: NameMap,
                            globalTypeMap: TypeMap,
                            typeHierarchy: TypeHierarchy.Type) {

  @memoize def applyType(isSpec: B,
                         fqName: QName,
                         typeArgs: Map[String, AST.Typed],
                         argTypes: ISZ[AST.Typed]): (AST.Typed, ISZ[Reporter.Message]) = {
    ???
  }

  @memoize def applyTypeNamed(isSpec: B,
                              fqName: QName,
                              typeArgs: Map[String, AST.Typed],
                              argTypes: Map[String, AST.Typed]): (AST.Typed, ISZ[Reporter.Message]) = {
    ???
  }

  @memoize def typeOfGlobalName(isSpec: B,
                                fqName: QName,
                                typeArgs: Map[String, AST.Typed]): (TypeFactory, ISZ[Reporter.Message]) = {
    ???
  }

  @memoize def memberType(isSpec: B,
                          fqName: QName,
                          typeArgs: Map[String, AST.Typed],
                          member: String,
                          memberTypeArgs: Map[String, AST.Typed]): (TypeFactory, ISZ[Reporter.Message]) = {
    ???
  }

  def check(reporter: Reporter): Unit = {
    var varInfos = ISZ[Either[Info, TypeInfo]]()
    var methodInfos = ISZ[Either[Info, TypeInfo]]()
    var specExtMethodInfos = ISZ[Either[Info, TypeInfo]]()
    for (info <- globalNameMap.values) {
      info match {
        case _: Info.Var => varInfos = varInfos :+ Either(Some(info), None[TypeInfo]())
        case _: Info.SpecVar => varInfos = varInfos :+ Either(Some(info), None[TypeInfo]())
        case _: Info.Method => methodInfos = methodInfos :+ Either(Some(info), None[TypeInfo]())
        case _: Info.SpecMethod => specExtMethodInfos = specExtMethodInfos :+ Either(Some(info), None[TypeInfo]())
        case _: Info.ExtMethod => specExtMethodInfos = specExtMethodInfos :+ Either(Some(info), None[TypeInfo]())
        case _ =>
      }
    }
    var sigInfos = ISZ[Either[Info, TypeInfo]]()
    var adtRootInfos = ISZ[Either[Info, TypeInfo]]()
    var richRootInfos = ISZ[Either[Info, TypeInfo]]()
    var adtInfos = ISZ[Either[Info, TypeInfo]]()
    var richInfos = ISZ[Either[Info, TypeInfo]]()
    for (info <- globalTypeMap.values) {
      info match {
        case _: TypeInfo.Sig => sigInfos = sigInfos :+ Either(None[Info](), Some(info))
        case info: TypeInfo.AbstractDatatype =>
          if (info.ast.isRoot) {
            adtRootInfos = adtRootInfos :+ Either(None[Info](), Some(info))
          } else {
            adtInfos = adtInfos :+ Either(None[Info](), Some(info))
          }
        case info: TypeInfo.Rich =>
          if (info.ast.isRoot) {
            richRootInfos = richRootInfos :+ Either(None[Info](), Some(info))
          } else {
            richInfos = richInfos :+ Either(None[Info](), Some(info))
          }
        case _ =>
      }
    }
    val infos = sigInfos ++ adtRootInfos ++ richRootInfos ++ adtInfos ++ richInfos ++
      varInfos ++ specExtMethodInfos ++ methodInfos
    val r = ISOps(infos).parMapFoldLeft(checkInfo, AccumulatingReporter.combine, AccumulatingReporter.create)
    reporter.reports(r.messages)
  }

  @pure def checkInfo(info: Either[Info, TypeInfo]): AccumulatingReporter = {
    ???
  }

}
