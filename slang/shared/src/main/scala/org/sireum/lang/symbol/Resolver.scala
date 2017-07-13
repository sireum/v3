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

  type QName = ISZ[String]

  type NameMap = Map[QName, Info]

  type TypeMap = Map[QName, TypeInfo]


  @record trait Scope {
    @pure def outerOpt: Option[Scope]

    def resolveName(globalNameMap: NameMap,
                    name: QName): Option[Info]

    def resolveType(globalTypeMap: TypeMap,
                    name: QName): Option[TypeInfo]
  }

  object Scope {

    @record class Local(nameMap: Map[String, Info],
                        outerOpt: Option[Scope]) {

      def resolveName(globalNameMap: NameMap,
                      name: QName): Option[Info] = {
        if (name.size == 1) {
          val infoOpt = nameMap.get(name(0))
          if (infoOpt.nonEmpty) {
            return infoOpt
          }
        }
        outerOpt match {
          case Some(scope) => return scope.resolveName(globalNameMap, name)
          case _ => return None()
        }
      }

      def resolveType(globalTypeMap: TypeMap,
                      name: QName): Option[TypeInfo] = {
        outerOpt match {
          case Some(scope) => return scope.resolveType(globalTypeMap, name)
          case _ => return None()
        }
      }
    }

    @record class Global(enclosingName: QName,
                         packageName: QName,
                         imports: ISZ[AST.Stmt.Import])
      extends Scope {

      var nameMap: Map[QName, Option[Info]] = Map.empty
      var typeMap: Map[QName, Option[TypeInfo]] = Map.empty

      @pure def outerOpt: Option[Scope] = {
        return None()
      }

      def resolveName(globalNameMap: NameMap,
                      name: QName): Option[Info] = {
        @pure def resolveImported(name: QName): Option[Info] = {
          for (impor <- imports.reverse) {
            for (importer <- impor.importers.reverse) {
              val contextName = AST.Util.ids2strings(importer.name.ids)
              importer.selectorOpt match {
                case Some(selector: AST.Stmt.Import.MultiSelector) =>
                  val nss = selector.selectors
                  for (ns <- nss.reverse) {
                    if (name == ISZ(ns.to.value)) {
                      val n = contextName :+ ns.from.value
                      val rOpt = globalNameMap.get(packageName ++ n)
                      if (rOpt.nonEmpty) {
                        return rOpt
                      }
                      val rGlobalOpt = globalNameMap.get(n)
                      if (rGlobalOpt.nonEmpty) {
                        return rGlobalOpt
                      }
                    }
                  }
                case Some(_: AST.Stmt.Import.WildcardSelector) =>
                  val n = contextName ++ name
                  val rOpt = globalNameMap.get(n)
                  if (rOpt.nonEmpty) {
                    return rOpt
                  }
                  val rGlobalOpt = globalNameMap.get(packageName ++ n)
                  if (rGlobalOpt.nonEmpty) {
                    return rGlobalOpt
                  }
                case None() =>
                  if (ISZ(contextName(contextName.size - 1)) == name) {
                    val rOpt = globalNameMap.get(packageName ++ contextName)
                    if (rOpt.nonEmpty) {
                      return rOpt
                    }
                    val rGlobalOpt = globalNameMap.get(contextName)
                    if (rGlobalOpt.nonEmpty) {
                      return rGlobalOpt
                    }
                  }
              }
            }
          }
          return None()

        }

        val globalOpt = globalNameMap.get(name)
        if (globalOpt.nonEmpty) {
          return globalOpt
        }

        var en = enclosingName
        while (en != packageName) {
          val enclosedOpt = globalNameMap.get(en ++ name)
          if (enclosedOpt.nonEmpty) {
            return enclosedOpt
          }
          en = SI.dropRight(en, 1)
        }

        nameMap.get(name) match {
          case Some(rOpt) =>
            rOpt match {
              case Some(_) => return rOpt
              case _ =>
            }
          case _ =>
            val importedOpt = resolveImported(name)
            nameMap.put(name, importedOpt)
            if (importedOpt.nonEmpty) {
              return importedOpt
            }
        }

        return globalNameMap.get(packageName ++ name)
      }

      def resolveType(globalTypeMap: TypeMap,
                      name: QName): Option[TypeInfo] = {
        @pure def resolveImportedType(name: QName): Option[TypeInfo] = {
          for (impor <- imports.reverse) {
            for (importer <- impor.importers.reverse) {
              val contextName = AST.Util.ids2strings(importer.name.ids)
              importer.selectorOpt match {
                case Some(selector: AST.Stmt.Import.MultiSelector) =>
                  val nss = selector.selectors
                  for (ns <- nss.reverse) {
                    if (name == ISZ(ns.to.value)) {
                      val n = contextName :+ ns.from.value
                      val rOpt = globalTypeMap.get(packageName ++ n)
                      if (rOpt.nonEmpty) {
                        return rOpt
                      }
                      val rGlobalOpt = globalTypeMap.get(n)
                      if (rGlobalOpt.nonEmpty) {
                        return rGlobalOpt
                      }
                    }
                  }
                case Some(_: AST.Stmt.Import.WildcardSelector) =>
                  val n = contextName ++ name
                  val rOpt = globalTypeMap.get(packageName ++ n)
                  if (rOpt.nonEmpty) {
                    return rOpt
                  }
                  val rGlobalOpt = globalTypeMap.get(n)
                  if (rGlobalOpt.nonEmpty) {
                    return rGlobalOpt
                  }
                case None() =>
                  if (ISZ(contextName(contextName.size - 1)) == name) {
                    val rOpt = globalTypeMap.get(packageName ++ contextName)
                    if (rOpt.nonEmpty) {
                      return rOpt
                    }
                    val rGlobalOpt = globalTypeMap.get(contextName)
                    if (rGlobalOpt.nonEmpty) {
                      return rGlobalOpt
                    }
                  }
              }
            }
          }
          return None()
        }

        val builtInTypeOpt = builtInTypeNames.get(name)
        if (builtInTypeOpt.nonEmpty) {
          return builtInTypeOpt
        }

        val globalTypeOpt = globalTypeMap.get(name)
        if (globalTypeOpt.nonEmpty) {
          return globalTypeOpt
        }

        var en = enclosingName
        while (en != packageName) {
          val enclosedTypeOpt = globalTypeMap.get(en ++ name)
          if (enclosedTypeOpt.nonEmpty) {
            return enclosedTypeOpt
          }
          en = SI.dropRight(en, 1)
        }

        typeMap.get(name) match {
          case Some(rOpt) =>
            rOpt match {
              case Some(_) => return rOpt
              case _ =>
            }
          case _ =>
            val importedTypeOpt = resolveImportedType(name)
            typeMap.put(name, importedTypeOpt)
            if (importedTypeOpt.nonEmpty) {
              return importedTypeOpt
            }
        }

        return globalTypeMap.get(packageName ++ name)
      }
    }

  }

  @datatype trait Info {
    def name: QName
  }

  object Info {

    @datatype class Package(name: QName) extends Info

    @datatype class Var(name: QName,
                        scope: Scope.Global,
                        ast: AST.Stmt.Var) extends Info

    @datatype class SpecVar(name: QName,
                            scope: Scope.Global,
                            ast: AST.Stmt.SpecVar) extends Info

    @datatype class Method(name: QName,
                           scope: Scope.Global,
                           ast: AST.Stmt.Method) extends Info

    @datatype class SpecMethod(name: QName,
                               scope: Scope.Global,
                               ast: AST.Stmt.SpecMethod) extends Info

    @datatype class Object(name: QName,
                           isExt: B)
      extends Info

    @datatype class ExtMethod(name: QName,
                              scope: Scope.Global,
                              ast: AST.Stmt.ExtMethod)
      extends Info

    @datatype class Enum(name: QName,
                         elements: Set[String])
      extends Info

  }

  @datatype trait TypeInfo {

    def name: QName

    def canHaveCompanion: B

    def posInfoOpt: Option[AST.PosInfo]
  }

  object TypeInfo {

    @datatype class BuiltIn(name: QName)
      extends TypeInfo {
      def canHaveCompanion: B = {
        return F
      }

      def posInfoOpt: Option[AST.PosInfo] = {
        return None()
      }
    }

    @datatype class Enum(name: QName,
                         elements: Set[String],
                         posInfoOpt: Option[AST.PosInfo])
      extends TypeInfo {
      def canHaveCompanion: B = {
        return F
      }
    }

    @datatype class Sig(name: QName,
                        specVars: Map[String, AST.Stmt.SpecVar],
                        specMethods: Map[String, AST.Stmt.SpecMethod],
                        methods: Map[String, AST.Stmt.Method],
                        scope: Scope.Global,
                        ast: AST.Stmt.Sig)
      extends TypeInfo {

      def canHaveCompanion: B = {
        return T
      }

      def posInfoOpt: Option[AST.PosInfo] = {
        return ast.attr.posInfoOpt
      }
    }

    @datatype class AbstractDatatype(name: QName,
                                     specVars: Map[String, AST.Stmt.SpecVar],
                                     vars: Map[String, AST.Stmt.Var],
                                     specMethods: Map[String, AST.Stmt.SpecMethod],
                                     methods: Map[String, AST.Stmt.Method],
                                     scope: Scope.Global,
                                     ast: AST.Stmt.AbstractDatatype)
      extends TypeInfo {

      def canHaveCompanion: B = {
        return T
      }

      def posInfoOpt: Option[AST.PosInfo] = {
        return ast.attr.posInfoOpt
      }
    }

    @datatype class Rich(name: QName,
                         methods: Map[String, AST.Stmt.Method],
                         scope: Scope.Global,
                         ast: AST.Stmt.Rich)
      extends TypeInfo {

      def canHaveCompanion: B = {
        return T
      }

      def posInfoOpt: Option[AST.PosInfo] = {
        return ast.attr.posInfoOpt
      }
    }

    @datatype class TypeAlias(name: QName,
                              scope: Scope.Global,
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

  }

  val rootPackageInfo: Info.Package = Info.Package(ISZ())
  val builtInPackageName: QName = ISZ()
  val builtInTypeNames: Map[QName, TypeInfo] = Map(ISZ(
    (ISZ("B"), TypeInfo.BuiltIn(builtInPackageName :+ "B")),
    (ISZ("C"), TypeInfo.BuiltIn(builtInPackageName :+ "C")),
    (ISZ("Z"), TypeInfo.BuiltIn(builtInPackageName :+ "Z")),
    (ISZ("Z8"), TypeInfo.BuiltIn(builtInPackageName :+ "Z8")),
    (ISZ("Z16"), TypeInfo.BuiltIn(builtInPackageName :+ "Z16")),
    (ISZ("Z32"), TypeInfo.BuiltIn(builtInPackageName :+ "Z32")),
    (ISZ("Z64"), TypeInfo.BuiltIn(builtInPackageName :+ "Z64")),
    (ISZ("N"), TypeInfo.BuiltIn(builtInPackageName :+ "N")),
    (ISZ("N8"), TypeInfo.BuiltIn(builtInPackageName :+ "N8")),
    (ISZ("N16"), TypeInfo.BuiltIn(builtInPackageName :+ "N16")),
    (ISZ("N32"), TypeInfo.BuiltIn(builtInPackageName :+ "N32")),
    (ISZ("N64"), TypeInfo.BuiltIn(builtInPackageName :+ "N64")),
    (ISZ("S8"), TypeInfo.BuiltIn(builtInPackageName :+ "S8")),
    (ISZ("S16"), TypeInfo.BuiltIn(builtInPackageName :+ "S16")),
    (ISZ("S32"), TypeInfo.BuiltIn(builtInPackageName :+ "S32")),
    (ISZ("S64"), TypeInfo.BuiltIn(builtInPackageName :+ "S64")),
    (ISZ("U8"), TypeInfo.BuiltIn(builtInPackageName :+ "U8")),
    (ISZ("U16"), TypeInfo.BuiltIn(builtInPackageName :+ "U16")),
    (ISZ("U32"), TypeInfo.BuiltIn(builtInPackageName :+ "U32")),
    (ISZ("U64"), TypeInfo.BuiltIn(builtInPackageName :+ "U64")),
    (ISZ("F32"), TypeInfo.BuiltIn(builtInPackageName :+ "F32")),
    (ISZ("F64"), TypeInfo.BuiltIn(builtInPackageName :+ "F64")),
    (ISZ("R"), TypeInfo.BuiltIn(builtInPackageName :+ "R")),
    (ISZ("IS"), TypeInfo.BuiltIn(builtInPackageName :+ "IS")),
    (ISZ("MS"), TypeInfo.BuiltIn(builtInPackageName :+ "MS")),
    (ISZ("ISZ"), TypeInfo.BuiltIn(builtInPackageName :+ "ISZ")),
    (ISZ("ISZ8"), TypeInfo.BuiltIn(builtInPackageName :+ "ISZ8")),
    (ISZ("ISZ16"), TypeInfo.BuiltIn(builtInPackageName :+ "ISZ16")),
    (ISZ("ISZ32"), TypeInfo.BuiltIn(builtInPackageName :+ "ISZ32")),
    (ISZ("ISZ64"), TypeInfo.BuiltIn(builtInPackageName :+ "ISZ64")),
    (ISZ("ISN"), TypeInfo.BuiltIn(builtInPackageName :+ "ISN")),
    (ISZ("ISN8"), TypeInfo.BuiltIn(builtInPackageName :+ "ISN8")),
    (ISZ("ISN16"), TypeInfo.BuiltIn(builtInPackageName :+ "ISN16")),
    (ISZ("ISN32"), TypeInfo.BuiltIn(builtInPackageName :+ "ISN32")),
    (ISZ("ISN64"), TypeInfo.BuiltIn(builtInPackageName :+ "ISN64")),
    (ISZ("ISS8"), TypeInfo.BuiltIn(builtInPackageName :+ "ISS8")),
    (ISZ("ISS16"), TypeInfo.BuiltIn(builtInPackageName :+ "ISS16")),
    (ISZ("ISS32"), TypeInfo.BuiltIn(builtInPackageName :+ "ISS32")),
    (ISZ("ISS64"), TypeInfo.BuiltIn(builtInPackageName :+ "ISS64")),
    (ISZ("ISU8"), TypeInfo.BuiltIn(builtInPackageName :+ "ISU8")),
    (ISZ("ISU16"), TypeInfo.BuiltIn(builtInPackageName :+ "ISU16")),
    (ISZ("ISU32"), TypeInfo.BuiltIn(builtInPackageName :+ "ISU32")),
    (ISZ("ISU64"), TypeInfo.BuiltIn(builtInPackageName :+ "ISU64")),
    (ISZ("MSZ"), TypeInfo.BuiltIn(builtInPackageName :+ "MSZ")),
    (ISZ("MSZ8"), TypeInfo.BuiltIn(builtInPackageName :+ "MSZ8")),
    (ISZ("MSZ16"), TypeInfo.BuiltIn(builtInPackageName :+ "MSZ16")),
    (ISZ("MSZ32"), TypeInfo.BuiltIn(builtInPackageName :+ "MSZ32")),
    (ISZ("MSZ64"), TypeInfo.BuiltIn(builtInPackageName :+ "MSZ64")),
    (ISZ("MSN"), TypeInfo.BuiltIn(builtInPackageName :+ "MSN")),
    (ISZ("MSN8"), TypeInfo.BuiltIn(builtInPackageName :+ "MSN8")),
    (ISZ("MSN16"), TypeInfo.BuiltIn(builtInPackageName :+ "MSN16")),
    (ISZ("MSN32"), TypeInfo.BuiltIn(builtInPackageName :+ "MSN32")),
    (ISZ("MSN64"), TypeInfo.BuiltIn(builtInPackageName :+ "MSN64")),
    (ISZ("MSS8"), TypeInfo.BuiltIn(builtInPackageName :+ "MSS8")),
    (ISZ("MSS16"), TypeInfo.BuiltIn(builtInPackageName :+ "MSS16")),
    (ISZ("MSS32"), TypeInfo.BuiltIn(builtInPackageName :+ "MSS32")),
    (ISZ("MSS64"), TypeInfo.BuiltIn(builtInPackageName :+ "MSS64")),
    (ISZ("MSU8"), TypeInfo.BuiltIn(builtInPackageName :+ "MSU8")),
    (ISZ("MSU16"), TypeInfo.BuiltIn(builtInPackageName :+ "MSU16")),
    (ISZ("MSU32"), TypeInfo.BuiltIn(builtInPackageName :+ "MSU32")),
    (ISZ("MSU64"), TypeInfo.BuiltIn(builtInPackageName :+ "MSU64")),
    (ISZ("String"), TypeInfo.BuiltIn(builtInPackageName :+ "String"))
  ))

}
