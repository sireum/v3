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
import org.sireum.lang.parser.Parser
import org.sireum.ops._
import org.sireum.lang.util.{AccumulatingReporter, Reporter}
import org.sireum.lang.{ast => AST}

object Resolver {

  type QName = ISZ[String]

  type NameMap = HashMap[QName, Info]

  type TypeMap = HashMap[QName, TypeInfo]


  @datatype trait Scope {
    @pure def outerOpt: Option[Scope]

    @pure def resolveName(globalNameMap: NameMap,
                          name: QName): Option[Info]

    @pure def resolveType(globalTypeMap: TypeMap,
                          name: QName): Option[TypeInfo]
  }

  object Scope {

    @datatype class Local(nameMap: HashMap[String, Info],
                          typeMap: HashMap[String, TypeInfo],
                          val outerOpt: Option[Scope])
      extends Scope {

      @pure def resolveName(globalNameMap: NameMap,
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

      @pure def resolveType(globalTypeMap: TypeMap,
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

    @datatype class Global(packageName: QName,
                           imports: ISZ[AST.Stmt.Import],
                           enclosingName: QName)
      extends Scope {

      @pure def outerOpt: Option[Scope] = {
        return None()
      }

      @pure def resolveName(globalNameMap: NameMap,
                            name: QName): Option[Info] = {
        return resolveNameMemoized(globalNameMap, name)
      }

      @pure def resolveImported(globalNameMap: NameMap,
                                name: QName): Option[Info] = {
        for (i <- imports.indices.reverse) {
          val impor = imports(i)
          val importers = impor.importers
          for (j <- importers.indices.reverse) {
            val importer = importers(j)
            val contextName = AST.Util.ids2strings(importer.name.ids)
            importer.selectorOpt match {
              case Some(selector: AST.Stmt.Import.MultiSelector) =>
                val nss = selector.selectors
                val name0 = name(0)
                for (k <- nss.indices.reverse) {
                  val ns = nss(k)
                  if (name0 == ns.to.value) {
                    val n = (contextName :+ ns.from.value) ++ ISZOps(name).drop(1)
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
                val name0 = name(0)
                val contextLast = contextName(contextName.size - 1)
                if (contextLast == name0) {
                  val n = contextName ++ ISZOps(name).drop(1)
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
          }
        }
        return None()
      }

      @pure def resolveType(globalTypeMap: TypeMap,
                            name: QName): Option[TypeInfo] = {
        return resolveTypeMemoized(globalTypeMap, name)
      }

      @pure def resolveImportedType(globalTypeMap: TypeMap,
                                    name: QName): Option[TypeInfo] = {
        for (i <- imports.indices.reverse) {
          val impor = imports(i)
          val importers = impor.importers
          for (j <- importers.indices.reverse) {
            val importer = importers(j)
            val contextName = AST.Util.ids2strings(importer.name.ids)
            importer.selectorOpt match {
              case Some(selector: AST.Stmt.Import.MultiSelector) =>
                val nss = selector.selectors
                val name0 = name(0)
                for (k <- nss.indices.reverse) {
                  val ns = nss(k)
                  if (name0 == ns.to.value) {
                    val n = (contextName :+ ns.from.value) ++ ISZOps(name).drop(1)
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
                val name0 = name(0)
                val contextLast = contextName(contextName.size - 1)
                if (contextLast == name0) {
                  val n = contextName ++ ISZOps(name).drop(1)
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
          }
        }
        return None()
      }

      @memoize def resolveNameMemoized(@hidden globalNameMap: NameMap,
                                       name: QName): Option[Info] = {
        val globalOpt = globalNameMap.get(name)
        if (globalOpt.nonEmpty) {
          return globalOpt
        }

        var en = enclosingName
        while (en.size >= packageName.size && en != packageName) {
          val enclosedOpt = globalNameMap.get(en ++ name)
          if (enclosedOpt.nonEmpty) {
            return enclosedOpt
          }
          en = ISZOps(en).dropRight(1)
        }

        val importedOpt = resolveImported(globalNameMap, name)
        if (importedOpt.nonEmpty) {
          return importedOpt
        }

        return globalNameMap.get(packageName ++ name)
      }

      @memoize def resolveTypeMemoized(@hidden globalTypeMap: TypeMap,
                                       name: QName): Option[TypeInfo] = {
        val globalTypeOpt = globalTypeMap.get(name)
        if (globalTypeOpt.nonEmpty) {
          return globalTypeOpt
        }

        var en = enclosingName
        while (en.size >= packageName.size && en != packageName) {
          val enclosedTypeOpt = globalTypeMap.get(en ++ name)
          if (enclosedTypeOpt.nonEmpty) {
            return enclosedTypeOpt
          }
          en = ISZOps(en).dropRight(1)
        }

        val importedTypeOpt = resolveImportedType(globalTypeMap, name)
        if (importedTypeOpt.nonEmpty) {
          return importedTypeOpt
        }

        return globalTypeMap.get(packageName ++ name)
      }
    }

  }

  @datatype trait Info {
    def name: QName

    def posOpt: Option[AST.PosInfo]
  }

  object Info {

    @datatype class Package(val name: QName) extends Info {
      def posOpt: Option[AST.PosInfo] = {
        return None[AST.PosInfo]()
      }
    }

    @datatype class Var(val name: QName,
                        scope: Scope.Global,
                        ast: AST.Stmt.Var) extends Info {
      def posOpt: Option[AST.PosInfo] = {
        return ast.attr.posOpt
      }

      def outlined: B = {
        ast.tipeOpt match {
          case Some(t) => return t.typedOpt.nonEmpty
          case _ => return T
        }
      }
    }

    @datatype class SpecVar(val name: QName,
                            scope: Scope.Global,
                            ast: AST.Stmt.SpecVar) extends Info {
      def posOpt: Option[AST.PosInfo] = {
        return ast.attr.posOpt
      }
      def outlined: B = {
        return ast.tipe.typedOpt.nonEmpty
      }
    }

    @datatype class Method(val name: QName,
                           scope: Scope.Global,
                           ast: AST.Stmt.Method) extends Info {
      def posOpt: Option[AST.PosInfo] = {
        return ast.attr.posOpt
      }
      def outlined: B = {
        return ast.sig.returnType.typedOpt.nonEmpty
      }
    }

    @datatype class SpecMethod(val name: QName,
                               scope: Scope.Global,
                               ast: AST.Stmt.SpecMethod) extends Info {
      def posOpt: Option[AST.PosInfo] = {
        return ast.attr.posOpt
      }
      def outlined: B = {
        return ast.sig.returnType.typedOpt.nonEmpty
      }
    }

    @datatype class Object(val name: QName,
                           outlined: B,
                           ast: AST.Stmt.Object)
      extends Info {
      def posOpt: Option[AST.PosInfo] = {
        return ast.attr.posOpt
      }
    }

    @datatype class ExtMethod(val name: QName,
                              scope: Scope.Global,
                              ast: AST.Stmt.ExtMethod)
      extends Info {
      def posOpt: Option[AST.PosInfo] = {
        return ast.attr.posOpt
      }
    }

    @datatype class Enum(val name: QName,
                         elements: Set[String],
                         val posOpt: Option[AST.PosInfo])
      extends Info

    @datatype class FreshVar(val name: QName,
                             ast: AST.Id)
      extends Info {
      def posOpt: Option[AST.PosInfo] = {
        return ast.attr.posOpt
      }
    }

    @datatype class QuantVar(val name: QName,
                             ast: AST.Id)
      extends Info {
      def posOpt: Option[AST.PosInfo] = {
        return ast.attr.posOpt
      }
    }

  }

  @datatype trait TypeInfo {

    def name: QName

    def canHaveCompanion: B

    def posOpt: Option[AST.PosInfo]
  }

  object TypeInfo {

    @datatype class SubZ(val name: QName,
                         ast: AST.Stmt.SubZ) extends TypeInfo {
      def canHaveCompanion: B = {
        return F
      }

      def posOpt: Option[AST.PosInfo] = {
        return ast.attr.posOpt
      }
    }

    @datatype class Enum(val name: QName,
                         elements: Set[String],
                         val posOpt: Option[AST.PosInfo])
      extends TypeInfo {
      def canHaveCompanion: B = {
        return F
      }
    }

    @datatype class Sig(val name: QName,
                        outlined: B,
                        specVars: HashMap[String, (QName, AST.Stmt.SpecVar)],
                        specMethods: HashMap[String, (QName, AST.Stmt.SpecMethod)],
                        methods: HashMap[String, (QName, AST.Stmt.Method)],
                        scope: Scope.Global,
                        ast: AST.Stmt.Sig)
      extends TypeInfo {

      def canHaveCompanion: B = {
        return T
      }

      def posOpt: Option[AST.PosInfo] = {
        return ast.attr.posOpt
      }
    }

    @datatype class AbstractDatatype(val name: QName,
                                     outlined: B,
                                     specVars: HashMap[String, (QName, AST.Stmt.SpecVar)],
                                     vars: HashMap[String, (QName, AST.Stmt.Var)],
                                     specMethods: HashMap[String, (QName, AST.Stmt.SpecMethod)],
                                     methods: HashMap[String, (QName, AST.Stmt.Method)],
                                     scope: Scope.Global,
                                     ast: AST.Stmt.AbstractDatatype)
      extends TypeInfo {

      def canHaveCompanion: B = {
        return T
      }

      def posOpt: Option[AST.PosInfo] = {
        return ast.attr.posOpt
      }
    }

    @datatype class TypeAlias(val name: QName,
                              scope: Scope.Global,
                              ast: AST.Stmt.TypeAlias)
      extends TypeInfo {

      def canHaveCompanion: B = {
        return F
      }

      def posOpt: Option[AST.PosInfo] = {
        return ast.attr.posOpt
      }
    }

    @datatype class TypeVar(id: String,
                            ast: AST.TypeParam)
      extends TypeInfo {

      def name: QName = {
        return ISZ(id)
      }

      def canHaveCompanion: B = {
        return F
      }

      def posOpt: Option[AST.PosInfo] = {
        return ast.id.attr.posOpt
      }
    }

    @datatype class Members(specVars: HashMap[String, (QName, AST.Stmt.SpecVar)],
                            vars: HashMap[String, (QName, AST.Stmt.Var)],
                            specMethods: HashMap[String, (QName, AST.Stmt.SpecMethod)],
                            methods: HashMap[String, (QName, AST.Stmt.Method)])

  }

  val resolverKind: String = "Slang Resolver"
  val rootPackageInfo: Info.Package = Info.Package(ISZ())

  @pure def ltTypeInfo(ti1: TypeInfo, ti2: TypeInfo): B = {
    (ti1.posOpt, ti2.posOpt) match {
      case (Some(pos1), Some(pos2)) => return pos1.offset < pos2.offset
      case _ => return F
    }
  }

  @pure def sortedGlobalTypes(globalTypeMap: TypeMap): ISZ[TypeInfo] = {
    return ISZOps(globalTypeMap.values).sortWith(ltTypeInfo)
  }

  @pure def typePoset(globalTypeMap: TypeMap,
                      globalTypes: ISZ[TypeInfo],
                      reporter: Reporter): Poset[QName] = {
    var r = Poset.empty[QName]

    for (ti <- globalTypes) {
      ti match {
        case ti: TypeInfo.AbstractDatatype if ti.ast.isRoot => r = r.addNode(ti.name)
        case ti: TypeInfo.Sig => r = r.addNode(ti.name)
        case _ =>
      }
    }
    for (ti <- globalTypes) {
      ti match {
        case ti: TypeInfo.AbstractDatatype if !ti.ast.isRoot =>
          for (t <- ti.ast.parents) {
            ti.scope.resolveType(globalTypeMap, AST.Util.ids2strings(t.name.ids)) match {
              case Some(parent: TypeInfo.AbstractDatatype) if parent.ast.isDatatype == ti.ast.isDatatype =>
                  r = r.addChildren(parent.name, ISZ(ti.name))
              case Some(parent: TypeInfo.Sig) if parent.ast.isImmutable == ti.ast.isDatatype =>
                r = r.addChildren(parent.name, ISZ(ti.name))
              case Some(_) =>
                reporter.error(t.attr.posOpt, resolverKind,
                  st"${(ti.name, ".")} cannot extend ${(AST.Util.ids2strings(t.name.ids), ".")}.".render)
              case _ => reporter.error(t.attr.posOpt, resolverKind,
                st"Could not find ${(ti.name, ".")}'s super type ${(AST.Util.ids2strings(t.name.ids), ".")}.".render)
            }
          }
        case ti: TypeInfo.Sig =>
          for (t <- ti.ast.parents) {
            ti.scope.resolveType(globalTypeMap, AST.Util.ids2strings(t.name.ids)) match {
              case Some(parent: TypeInfo.Sig) if parent.ast.isImmutable == ti.ast.isImmutable =>
                r = r.addChildren(parent.name, ISZ(ti.name))
              case Some(_) =>
                reporter.error(t.attr.posOpt, resolverKind,
                  st"${(ti.name, ".")} cannot extend ${(AST.Util.ids2strings(t.name.ids), ".")}.".render)
              case _ => reporter.error(t.attr.posOpt, resolverKind,
                st"Could not find ${(ti.name, ".")}'s super type ${(AST.Util.ids2strings(t.name.ids), ".")}.".render)
            }
          }
        case _ =>
      }
    }
    return r
  }

  @pure def relQName(name: QName, ids: QName): QName = {
    val sz = name.size
    if (ids.size <= sz) {
      return ids
    }
    var i = z"0"
    while (i < name.size) {
      if (ids(i) != name(i)) {
        return ids
      }
      i = i + 1
    }
    return ISZOps(ids).drop(sz)
  }

  def typeString(name: QName, t: AST.Type, reporter: Reporter): ST = {
    t match {
      case t: AST.Type.Named => return typeNameString(name, relQName(name, AST.Util.ids2strings(t.name.ids)))
      case _ =>
        reporter.internalError(t.posOpt, resolverKind, s"Unexpected type $t.")
        return st""
    }
  }

  def typeParamsScope(tps: ISZ[AST.TypeParam],
                      scope: Scope,
                      reporter: Reporter): Scope = {
    var typeMap = HashMap.empty[String, TypeInfo]
    for (tp <- tps) {
      val id = tp.id.value
      if (typeMap.contains(id)) {
        reporter.error(tp.id.attr.posOpt, resolverKind, s"Redeclaration of type parameter '$id'.")
      } else {
        typeMap = typeMap.put(id, TypeInfo.TypeVar(id, tp))
      }
    }
    return Scope.Local(HashMap.empty, typeMap, Some(scope))
  }

  @pure def typeNameString(name: QName, ids: QName): ST = {
    return st"${(relQName(name, ids), ".")}"
  }

  @pure def typeName(name: QName, ids: QName): ST = {
    return st"${relQName(name, ids)}"
  }

  @pure def addBuiltIns(nameMap: NameMap, typeMap: TypeMap): (NameMap, TypeMap) = {
    val sireumName: QName = ISZ("org", "sireum")
    val iszName = sireumName :+ "ISZ"

    if (typeMap.contains(iszName)) {
      return (nameMap, typeMap)
    }

    val emptyAttr = AST.Attr(None[AST.PosInfo]())
    val dollar = AST.Exp.Ident(AST.Id("$", emptyAttr),
      AST.ResolvedAttr(None[AST.PosInfo](), None[AST.ResolvedInfo](), None[AST.Typed]()))

    val dollarAssignExp = AST.Stmt.Expr(dollar, emptyAttr)

    val scope = Scope.Global(sireumName, ISZ[AST.Stmt.Import](), ISZ[String]())

    var tm = typeMap.put(iszName, TypeInfo.TypeAlias(iszName, scope,
      Parser("type ISZ[T] = IS[Z, T]").parseStmt[AST.Stmt.TypeAlias]))

    val mszName = sireumName :+ "MSZ"

    tm = tm.put(mszName, TypeInfo.TypeAlias(mszName, scope,
      Parser("type MSZ[T] = MS[Z, T]").parseStmt[AST.Stmt.TypeAlias]))

    val tName = sireumName :+ "T"
    var nm = nameMap.put(tName, Info.Var(tName, scope,
      Parser("val T: B = true").parseStmt[AST.Stmt.Var](initOpt = Some(dollarAssignExp))))

    val fName = sireumName :+ "F"
    nm = nm.put(fName, Info.Var(fName, scope,
      Parser("val F: B = false").parseStmt[AST.Stmt.Var](initOpt = Some(dollarAssignExp))))

    return (nm, tm)

  }

  def parseProgramAndGloballyResolve(sources: ISZ[(Option[String], String)],
                                     nameMap: NameMap,
                                     typeMap: TypeMap): (AccumulatingReporter, NameMap, TypeMap) = {
    def parseGloballyResolve(p: (Option[String], String)): (AccumulatingReporter, NameMap, TypeMap) = {
      val reporter = AccumulatingReporter.create
      val r = Parser(p._2).parseTopUnit[AST.TopUnit.Program](T, F, F, p._1, reporter)
      val nameMap = HashMap.empty[QName, Info]
      val typeMap = HashMap.empty[QName, TypeInfo]
      r match {
        case Some(program) =>
          val gdr = GlobalDeclarationResolver(nameMap, typeMap, reporter)
          gdr.resolveProgram(program)
          return (reporter, gdr.globalNameMap, gdr.globalTypeMap)
        case _ => return (reporter, nameMap, typeMap)
      }
    }

    @pure def combine(r: (AccumulatingReporter, NameMap, TypeMap),
                      u: (AccumulatingReporter, NameMap, TypeMap)): (AccumulatingReporter, NameMap, TypeMap) = {
      var rNameMap = r._2
      var rTypeMap = r._3
      val uNameMap = u._2
      val uTypeMap = u._3
      val reporter = AccumulatingReporter.combine(r._1, u._1)
      for (p <- uNameMap.entries) {
        val name = p._1
        val uInfo = p._2
        rNameMap.get(name) match {
          case Some(rInfo) =>
            (rInfo, uInfo) match {
              case (_: Info.Package, _: Info.Package) =>
              case _ =>
                rInfo.posOpt match {
                  case Some(pos) =>
                    val file: String = pos.fileUriOpt match {
                      case Some(fileUri) => s" in $fileUri"
                      case _ => ""
                    }
                    reporter.error(uInfo.posOpt, resolverKind,
                      st"Name '${(name, ".")}' has already been declared at [${pos.beginLine}, ${pos.beginColumn}]$file".render)
                  case _ =>
                }
            }
          case _ => rNameMap = rNameMap.put(name, uInfo)
        }
      }
      for (p <- uTypeMap.entries) {
        val name = p._1
        val uInfo = p._2
        rTypeMap.get(name) match {
          case Some(rInfo) =>
            rInfo.posOpt match {
              case Some(pos) =>
                val file: String = pos.fileUriOpt match {
                  case Some(fileUri) => s" in $fileUri"
                  case _ => ""
                }
                reporter.error(uInfo.posOpt, resolverKind,
                  st"Type named '${(name, ".")}' has already been declared at [${pos.beginLine}, ${pos.beginColumn}]$file".render)
              case _ =>
            }
          case _ => rTypeMap = rTypeMap.put(name, uInfo)
        }
      }
      return (reporter, rNameMap, rTypeMap)
    }

    val t = ISZOps(sources).
      mParMapFoldLeft[(AccumulatingReporter, NameMap, TypeMap), (AccumulatingReporter, NameMap, TypeMap)](
      parseGloballyResolve _, combine _, (AccumulatingReporter.create, nameMap, typeMap))
    val p = addBuiltIns(t._2, t._3)
    return (t._1, p._1, p._2)
  }

  @pure def typeParamNameString(s: String): String = {
    return s"`$s"
  }

  @pure def typeParamName(typeParam: AST.TypeParam): String = {
    return typeParamNameString(typeParam.id.value)
  }

  @pure def isTypeParamNameString(id: String): B = {
    return id.size > 0 && id.at(0) == '`'
  }

  @pure def isTypeParamName(name: QName): B = {
    return name.size == 1 && isTypeParamNameString(name(0))
  }

  @pure def isTypeParam(t: AST.Typed): B = {
    t match {
      case t: AST.Typed.Name => return t.args == 0 && isTypeParamName(t.ids)
      case _ => return F
    }
  }

  def typeParamMap(typeParams: ISZ[AST.TypeParam],
                   reporter: Reporter): HashSMap[String, TypeInfo] = {
    val r = typeParamMapInit(typeParams, HashSMap.empty[String, TypeInfo], reporter)
    return r
  }

  def typeParamMapInit(typeParams: ISZ[AST.TypeParam],
                       init: HashSMap[String, TypeInfo],
                       reporter: Reporter): HashSMap[String, TypeInfo] = {
    var r = init
    for (tp <- typeParams) {
      val name = typeParamName(tp)
      if (r.contains(name)) {
        reporter.error(tp.id.attr.posOpt, resolverKind, s"Redeclaration of type parameter ${tp.id.value}.")
      }
      r = r.put(tp.id.value, TypeInfo.TypeVar(name, tp))
    }
    return r
  }

  @pure def localTypeScope(typeMap: HashMap[String, TypeInfo], outer: Scope): Scope = {
    return Scope.Local(HashMap.empty[String, Info], typeMap, Some(outer))
  }

}
