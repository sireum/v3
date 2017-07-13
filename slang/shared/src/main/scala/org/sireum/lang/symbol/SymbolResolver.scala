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

object SymbolResolver {
  val builtInPackageName: ISZ[String] = ISZ()
  val builtInTypeNames: Map[ISZ[String], Resolver.TypeInfo] = Map(ISZ(
    (ISZ("Z"), Resolver.BuiltIn(builtInPackageName :+ "Z")),
    (ISZ("Z8"), Resolver.BuiltIn(builtInPackageName :+ "Z8")),
    (ISZ("Z16"), Resolver.BuiltIn(builtInPackageName :+ "Z16")),
    (ISZ("Z32"), Resolver.BuiltIn(builtInPackageName :+ "Z32")),
    (ISZ("Z64"), Resolver.BuiltIn(builtInPackageName :+ "Z64")),
    (ISZ("N"), Resolver.BuiltIn(builtInPackageName :+ "N")),
    (ISZ("N8"), Resolver.BuiltIn(builtInPackageName :+ "N8")),
    (ISZ("N16"), Resolver.BuiltIn(builtInPackageName :+ "N16")),
    (ISZ("N32"), Resolver.BuiltIn(builtInPackageName :+ "N32")),
    (ISZ("N64"), Resolver.BuiltIn(builtInPackageName :+ "N64")),
    (ISZ("S8"), Resolver.BuiltIn(builtInPackageName :+ "S8")),
    (ISZ("S16"), Resolver.BuiltIn(builtInPackageName :+ "S16")),
    (ISZ("S32"), Resolver.BuiltIn(builtInPackageName :+ "S32")),
    (ISZ("S64"), Resolver.BuiltIn(builtInPackageName :+ "S64")),
    (ISZ("U8"), Resolver.BuiltIn(builtInPackageName :+ "U8")),
    (ISZ("U16"), Resolver.BuiltIn(builtInPackageName :+ "U16")),
    (ISZ("U32"), Resolver.BuiltIn(builtInPackageName :+ "U32")),
    (ISZ("U64"), Resolver.BuiltIn(builtInPackageName :+ "U64")),
    (ISZ("F32"), Resolver.BuiltIn(builtInPackageName :+ "F32")),
    (ISZ("F64"), Resolver.BuiltIn(builtInPackageName :+ "F64")),
    (ISZ("R"), Resolver.BuiltIn(builtInPackageName :+ "R")),
    (ISZ("IS"), Resolver.BuiltIn(builtInPackageName :+ "IS")),
    (ISZ("MS"), Resolver.BuiltIn(builtInPackageName :+ "MS")),
    (ISZ("ISZ"), Resolver.BuiltIn(builtInPackageName :+ "ISZ")),
    (ISZ("ISZ8"), Resolver.BuiltIn(builtInPackageName :+ "ISZ8")),
    (ISZ("ISZ16"), Resolver.BuiltIn(builtInPackageName :+ "ISZ16")),
    (ISZ("ISZ32"), Resolver.BuiltIn(builtInPackageName :+ "ISZ32")),
    (ISZ("ISZ64"), Resolver.BuiltIn(builtInPackageName :+ "ISZ64")),
    (ISZ("ISN"), Resolver.BuiltIn(builtInPackageName :+ "ISN")),
    (ISZ("ISN8"), Resolver.BuiltIn(builtInPackageName :+ "ISN8")),
    (ISZ("ISN16"), Resolver.BuiltIn(builtInPackageName :+ "ISN16")),
    (ISZ("ISN32"), Resolver.BuiltIn(builtInPackageName :+ "ISN32")),
    (ISZ("ISN64"), Resolver.BuiltIn(builtInPackageName :+ "ISN64")),
    (ISZ("ISS8"), Resolver.BuiltIn(builtInPackageName :+ "ISS8")),
    (ISZ("ISS16"), Resolver.BuiltIn(builtInPackageName :+ "ISS16")),
    (ISZ("ISS32"), Resolver.BuiltIn(builtInPackageName :+ "ISS32")),
    (ISZ("ISS64"), Resolver.BuiltIn(builtInPackageName :+ "ISS64")),
    (ISZ("ISU8"), Resolver.BuiltIn(builtInPackageName :+ "ISU8")),
    (ISZ("ISU16"), Resolver.BuiltIn(builtInPackageName :+ "ISU16")),
    (ISZ("ISU32"), Resolver.BuiltIn(builtInPackageName :+ "ISU32")),
    (ISZ("ISU64"), Resolver.BuiltIn(builtInPackageName :+ "ISU64")),
    (ISZ("MSZ"), Resolver.BuiltIn(builtInPackageName :+ "MSZ")),
    (ISZ("MSZ8"), Resolver.BuiltIn(builtInPackageName :+ "MSZ8")),
    (ISZ("MSZ16"), Resolver.BuiltIn(builtInPackageName :+ "MSZ16")),
    (ISZ("MSZ32"), Resolver.BuiltIn(builtInPackageName :+ "MSZ32")),
    (ISZ("MSZ64"), Resolver.BuiltIn(builtInPackageName :+ "MSZ64")),
    (ISZ("MSN"), Resolver.BuiltIn(builtInPackageName :+ "MSN")),
    (ISZ("MSN8"), Resolver.BuiltIn(builtInPackageName :+ "MSN8")),
    (ISZ("MSN16"), Resolver.BuiltIn(builtInPackageName :+ "MSN16")),
    (ISZ("MSN32"), Resolver.BuiltIn(builtInPackageName :+ "MSN32")),
    (ISZ("MSN64"), Resolver.BuiltIn(builtInPackageName :+ "MSN64")),
    (ISZ("MSS8"), Resolver.BuiltIn(builtInPackageName :+ "MSS8")),
    (ISZ("MSS16"), Resolver.BuiltIn(builtInPackageName :+ "MSS16")),
    (ISZ("MSS32"), Resolver.BuiltIn(builtInPackageName :+ "MSS32")),
    (ISZ("MSS64"), Resolver.BuiltIn(builtInPackageName :+ "MSS64")),
    (ISZ("MSU8"), Resolver.BuiltIn(builtInPackageName :+ "MSU8")),
    (ISZ("MSU16"), Resolver.BuiltIn(builtInPackageName :+ "MSU16")),
    (ISZ("MSU32"), Resolver.BuiltIn(builtInPackageName :+ "MSU32")),
    (ISZ("MSU64"), Resolver.BuiltIn(builtInPackageName :+ "MSU64"))
  ))

  @datatype trait Scope {
    def outerOpt: Option[Scope]

    def resolveName(name: ISZ[String]): Option[Resolver.Info]

    def resolveType(name: ISZ[String]): Option[Resolver.TypeInfo]
  }

  @datatype class MapScope(nameMap: Map[ISZ[String], Resolver.Info],
                           outerOpt: Option[Scope]) {
    def resolveName(name: ISZ[String]): Option[Resolver.Info] = {
      val infoOpt = nameMap.get(name)
      if (infoOpt.nonEmpty) {
        return infoOpt
      }
      outerOpt match {
        case Some(scope) => return scope.resolveName(name)
        case _ => return None()
      }
    }

    def resolveType(name: ISZ[String]): Option[Resolver.TypeInfo] = {
      outerOpt match {
        case Some(scope) => return scope.resolveType(name)
        case _ => return None()
      }
    }
  }

  @datatype class ImportScope(enclosingName: ISZ[String],
                              packageName: ISZ[String],
                              imports: ISZ[AST.Stmt.Import],
                              globalNameMap: Map[ISZ[String], Resolver.Info],
                              globalTypeMap: Map[ISZ[String], Resolver.TypeInfo])
    extends Scope {

    def outerOpt: Option[Scope] = {
      return None()
    }

    def resolveName(name: ISZ[String]): Option[Resolver.Info] = {
      ???
    }

    def resolveType(name: ISZ[String]): Option[Resolver.TypeInfo] = {
      val builtInTypeOpt = resolveBuiltInType(name)
      if (builtInTypeOpt.nonEmpty) {
        return builtInTypeOpt
      }
      val enclosedTypeOpt = resolveContextType(enclosingName, name)
      if (enclosedTypeOpt.nonEmpty) {
        return enclosedTypeOpt
      }
      val importedTypeOpt = resolveImportedType(name)
      if (importedTypeOpt.nonEmpty) {
        return importedTypeOpt
      }
      return resolveContextType(packageName, name)
    }

    def resolveImportedType(name: ISZ[String]): Option[Resolver.TypeInfo] = {
      for (impor <- imports.reverse) {
        for (importer <- impor.importers.reverse) {
          val contextName = AST.Util.ids2strings(importer.name.ids)
          importer.selectorOpt match {
            case Some(selector: AST.Stmt.Import.MultiSelector) =>
              val nss = selector.selectors
              for (ns <- nss.reverse) {
                if (name == ISZ(ns.to.value)) {
                  val rOpt = resolveContextType(contextName, ISZ(ns.from.value))
                  if (rOpt.nonEmpty) {
                    return rOpt
                  }
                }
              }
            case Some(_: AST.Stmt.Import.WildcardSelector) =>
              val rOpt = resolveContextType(contextName, name)
              if (rOpt.nonEmpty) {
                return rOpt
              }
            case None() =>
              if (ISZ(contextName(contextName.size - 1)) == name) {
                val rOpt = resolveContextType(contextName, ISZ())
                if (rOpt.nonEmpty) {
                  return rOpt
                }
              }
          }
        }
      }
      return None()
    }

    def resolveContextType(contextName: ISZ[String], name: ISZ[String]): Option[Resolver.TypeInfo] = {
      return globalTypeMap.get(contextName ++ name)
    }

    def resolveBuiltInType(name: ISZ[String]): Option[Resolver.TypeInfo] = {
      return builtInTypeNames.get(name)
    }
  }

}

@record class SymbolResolver(globalNameMap: Map[ISZ[String], Resolver.Info],
                             globalTypeMap: Map[ISZ[String], Resolver.TypeInfo]) {

  def resolve(): Unit = {
    ???
  }
}
