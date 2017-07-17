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

  type NameMap = HashMap[QName, Info]

  type TypeMap = HashMap[QName, TypeInfo]


  @record trait Scope {
    @pure def outerOpt: Option[Scope]

    def resolveName(globalNameMap: NameMap,
                    name: QName): Option[Info]

    def resolveType(globalTypeMap: TypeMap,
                    name: QName): Option[TypeInfo]
  }

  object Scope {

    @record class Local(nameMap: HashMap[String, Info],
                        typeMap: HashMap[String, TypeInfo],
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
        if (name.size == 1) {
          val typeInfoOpt = typeMap.get(name(0))
          if (typeInfoOpt.nonEmpty) {
            return typeInfoOpt
          }
        }
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

      var nameMap: HashMap[QName, Option[Info]] = HashMap.empty
      var typeMap: HashMap[QName, Option[TypeInfo]] = HashMap.empty

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
                        specVars: HashMap[String, AST.Stmt.SpecVar],
                        specMethods: HashMap[String, AST.Stmt.SpecMethod],
                        methods: HashMap[String, AST.Stmt.Method],
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
                                     specVars: HashMap[String, AST.Stmt.SpecVar],
                                     vars: HashMap[String, AST.Stmt.Var],
                                     specMethods: HashMap[String, AST.Stmt.SpecMethod],
                                     methods: HashMap[String, AST.Stmt.Method],
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
                         methods: HashMap[String, AST.Stmt.Method],
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

    @datatype class Members(specVars: HashMap[String, AST.Stmt.SpecVar],
                            vars: HashMap[String, AST.Stmt.Var],
                            specMethods: HashMap[String, AST.Stmt.SpecMethod],
                            methods: HashMap[String, AST.Stmt.Method])

  }

  val rootPackageInfo: Info.Package = Info.Package(ISZ())
  val builtInPackageName: QName = ISZ()
  val builtInTypeNames: HashMap[QName, TypeInfo] = HashMap.emptyInit[QName, TypeInfo](128).
    put(ISZ("B"), TypeInfo.BuiltIn(builtInPackageName :+ "B")).
    put(ISZ("C"), TypeInfo.BuiltIn(builtInPackageName :+ "C")).
    put(ISZ("Z"), TypeInfo.BuiltIn(builtInPackageName :+ "Z")).
    put(ISZ("Z8"), TypeInfo.BuiltIn(builtInPackageName :+ "Z8")).
    put(ISZ("Z16"), TypeInfo.BuiltIn(builtInPackageName :+ "Z16")).
    put(ISZ("Z32"), TypeInfo.BuiltIn(builtInPackageName :+ "Z32")).
    put(ISZ("Z64"), TypeInfo.BuiltIn(builtInPackageName :+ "Z64")).
    put(ISZ("N"), TypeInfo.BuiltIn(builtInPackageName :+ "N")).
    put(ISZ("N8"), TypeInfo.BuiltIn(builtInPackageName :+ "N8")).
    put(ISZ("N16"), TypeInfo.BuiltIn(builtInPackageName :+ "N16")).
    put(ISZ("N32"), TypeInfo.BuiltIn(builtInPackageName :+ "N32")).
    put(ISZ("N64"), TypeInfo.BuiltIn(builtInPackageName :+ "N64")).
    put(ISZ("S8"), TypeInfo.BuiltIn(builtInPackageName :+ "S8")).
    put(ISZ("S16"), TypeInfo.BuiltIn(builtInPackageName :+ "S16")).
    put(ISZ("S32"), TypeInfo.BuiltIn(builtInPackageName :+ "S32")).
    put(ISZ("S64"), TypeInfo.BuiltIn(builtInPackageName :+ "S64")).
    put(ISZ("U8"), TypeInfo.BuiltIn(builtInPackageName :+ "U8")).
    put(ISZ("U16"), TypeInfo.BuiltIn(builtInPackageName :+ "U16")).
    put(ISZ("U32"), TypeInfo.BuiltIn(builtInPackageName :+ "U32")).
    put(ISZ("U64"), TypeInfo.BuiltIn(builtInPackageName :+ "U64")).
    put(ISZ("F32"), TypeInfo.BuiltIn(builtInPackageName :+ "F32")).
    put(ISZ("F64"), TypeInfo.BuiltIn(builtInPackageName :+ "F64")).
    put(ISZ("R"), TypeInfo.BuiltIn(builtInPackageName :+ "R")).
    put(ISZ("IS"), TypeInfo.BuiltIn(builtInPackageName :+ "IS")).
    put(ISZ("MS"), TypeInfo.BuiltIn(builtInPackageName :+ "MS")).
    put(ISZ("ISZ"), TypeInfo.BuiltIn(builtInPackageName :+ "ISZ")).
    put(ISZ("ISZ8"), TypeInfo.BuiltIn(builtInPackageName :+ "ISZ8")).
    put(ISZ("ISZ16"), TypeInfo.BuiltIn(builtInPackageName :+ "ISZ16")).
    put(ISZ("ISZ32"), TypeInfo.BuiltIn(builtInPackageName :+ "ISZ32")).
    put(ISZ("ISZ64"), TypeInfo.BuiltIn(builtInPackageName :+ "ISZ64")).
    put(ISZ("ISN"), TypeInfo.BuiltIn(builtInPackageName :+ "ISN")).
    put(ISZ("ISN8"), TypeInfo.BuiltIn(builtInPackageName :+ "ISN8")).
    put(ISZ("ISN16"), TypeInfo.BuiltIn(builtInPackageName :+ "ISN16")).
    put(ISZ("ISN32"), TypeInfo.BuiltIn(builtInPackageName :+ "ISN32")).
    put(ISZ("ISN64"), TypeInfo.BuiltIn(builtInPackageName :+ "ISN64")).
    put(ISZ("ISS8"), TypeInfo.BuiltIn(builtInPackageName :+ "ISS8")).
    put(ISZ("ISS16"), TypeInfo.BuiltIn(builtInPackageName :+ "ISS16")).
    put(ISZ("ISS32"), TypeInfo.BuiltIn(builtInPackageName :+ "ISS32")).
    put(ISZ("ISS64"), TypeInfo.BuiltIn(builtInPackageName :+ "ISS64")).
    put(ISZ("ISU8"), TypeInfo.BuiltIn(builtInPackageName :+ "ISU8")).
    put(ISZ("ISU16"), TypeInfo.BuiltIn(builtInPackageName :+ "ISU16")).
    put(ISZ("ISU32"), TypeInfo.BuiltIn(builtInPackageName :+ "ISU32")).
    put(ISZ("ISU64"), TypeInfo.BuiltIn(builtInPackageName :+ "ISU64")).
    put(ISZ("MSZ"), TypeInfo.BuiltIn(builtInPackageName :+ "MSZ")).
    put(ISZ("MSZ8"), TypeInfo.BuiltIn(builtInPackageName :+ "MSZ8")).
    put(ISZ("MSZ16"), TypeInfo.BuiltIn(builtInPackageName :+ "MSZ16")).
    put(ISZ("MSZ32"), TypeInfo.BuiltIn(builtInPackageName :+ "MSZ32")).
    put(ISZ("MSZ64"), TypeInfo.BuiltIn(builtInPackageName :+ "MSZ64")).
    put(ISZ("MSN"), TypeInfo.BuiltIn(builtInPackageName :+ "MSN")).
    put(ISZ("MSN8"), TypeInfo.BuiltIn(builtInPackageName :+ "MSN8")).
    put(ISZ("MSN16"), TypeInfo.BuiltIn(builtInPackageName :+ "MSN16")).
    put(ISZ("MSN32"), TypeInfo.BuiltIn(builtInPackageName :+ "MSN32")).
    put(ISZ("MSN64"), TypeInfo.BuiltIn(builtInPackageName :+ "MSN64")).
    put(ISZ("MSS8"), TypeInfo.BuiltIn(builtInPackageName :+ "MSS8")).
    put(ISZ("MSS16"), TypeInfo.BuiltIn(builtInPackageName :+ "MSS16")).
    put(ISZ("MSS32"), TypeInfo.BuiltIn(builtInPackageName :+ "MSS32")).
    put(ISZ("MSS64"), TypeInfo.BuiltIn(builtInPackageName :+ "MSS64")).
    put(ISZ("MSU8"), TypeInfo.BuiltIn(builtInPackageName :+ "MSU8")).
    put(ISZ("MSU16"), TypeInfo.BuiltIn(builtInPackageName :+ "MSU16")).
    put(ISZ("MSU32"), TypeInfo.BuiltIn(builtInPackageName :+ "MSU32")).
    put(ISZ("MSU64"), TypeInfo.BuiltIn(builtInPackageName :+ "MSU64")).
    put(ISZ("String"), TypeInfo.BuiltIn(builtInPackageName :+ "String"))

}
