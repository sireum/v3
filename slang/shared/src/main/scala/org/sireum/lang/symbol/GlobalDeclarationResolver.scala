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
import org.sireum.ops._
import Resolver._
import org.sireum.lang.util.Reporter
import org.sireum.lang.{ast => AST}

@record class GlobalDeclarationResolver(var globalNameMap: NameMap,
                                        var globalTypeMap: TypeMap,
                                        reporter: Reporter) {

  var packageName: QName = ISZ()
  var currentName: QName = ISZ()
  var currentImports: ISZ[AST.Stmt.Import] = ISZ()

  def resolveProgram(program: AST.TopUnit.Program): Unit = {
    declarePackageName(program.packageName) match {
      case Some(info) =>
        packageName = info.name
        currentName = packageName
      case _ =>
    }

    for (stmt <- program.body.stmts) {
      resolveGlobalStmt(stmt)
    }
  }

  @memoize def scope(packageName: QName,
                     imports: ISZ[AST.Stmt.Import],
                     name: QName): Scope.Global = {
    return Scope.Global(packageName, imports, ISZOps(name).dropRight(1))
  }

  def resolveGlobalStmt(stmt: AST.Stmt): Unit = {
    stmt match {
      case stmt: AST.Stmt.Import =>
        currentImports = currentImports :+ stmt
      case stmt: AST.Stmt.Var =>
        val name = currentName :+ stmt.id.value
        declareName(if (stmt.isVal) "val" else "var", name,
          Info.Var(name, scope(packageName, currentImports, name), stmt), stmt.attr.posOpt)
      case stmt: AST.Stmt.SpecVar =>
        val name = currentName :+ stmt.id.value
        declareName(if (stmt.isVal) "val" else "var", name,
          Info.SpecVar(name, scope(packageName, currentImports, name), stmt), stmt.attr.posOpt)
      case stmt: AST.Stmt.Method =>
        val name = currentName :+ stmt.sig.id.value
        declareName("method", name,
          Info.Method(name, scope(packageName, currentImports, name), stmt), stmt.attr.posOpt)
      case stmt: AST.Stmt.ExtMethod =>
        val name = currentName :+ stmt.sig.id.value
        declareName("extension method", name,
          Info.ExtMethod(name, scope(packageName, currentImports, name), stmt), stmt.attr.posOpt)
      case stmt: AST.Stmt.SpecMethod =>
        val name = currentName :+ stmt.sig.id.value
        declareName("specification method", name,
          Info.SpecMethod(name, scope(packageName, currentImports, name), stmt), stmt.attr.posOpt)
      case stmt: AST.Stmt.SubZ =>
        val name = currentName :+ stmt.id.value
        declareType(if (stmt.isBitVector) "bits" else "range", name, TypeInfo.SubZ(name, stmt), stmt.attr.posOpt)
      case stmt: AST.Stmt.Enum =>
        val name = currentName :+ stmt.id.value
        var elements = Set.empty[String]
        for (e <- stmt.elements) {
          if (elements.contains(e.value)) {
            reporter.error(e.attr.posOpt, resolverKind, s"Redeclaration of @enum element ${e.value}.")
          } else {
            elements = elements.add(e.value)
          }
        }
        declareName("enumeration", name, Info.Enum(name, elements, stmt.attr.posOpt), stmt.attr.posOpt)
        declareType("enumeration", name :+ "Type", TypeInfo.Enum(name, elements, stmt.attr.posOpt), stmt.attr.posOpt)
      case stmt: AST.Stmt.Object =>
        val name = currentName :+ stmt.id.value

        globalTypeMap.get(name) match {
          case Some(info) =>
            val posOpt = stmt.attr.posOpt
            if (stmt.isExt | !info.canHaveCompanion) {
              reporter.error(posOpt, resolverKind, s"Cannot declare extension object because the name has already been declared previously.")
            } else if (!AST.Util.fileUriOptEq(posOpt, info.posOpt)) {
              reporter.error(posOpt, resolverKind, s"Cannot declare companion object for a type defined in a different compilation unit.")
            }
          case _ =>
        }

        declareName(if (stmt.isExt) "extension object" else "object", name,
          Info.Object(name, stmt), stmt.attr.posOpt)
        val oldName = currentName
        currentName = name
        for (s <- stmt.stmts) {
          resolveGlobalStmt(s)
        }
        currentName = oldName
      case stmt: AST.Stmt.Sig =>
        val name = currentName :+ stmt.id.value
        val members = resolveMembers(name, stmt.stmts)
        assert(members.vars.isEmpty)
        declareType("sig", name, TypeInfo.Sig(name, F, members.specVars,
          members.specMethods, members.methods, scope(packageName, currentImports, name), stmt), stmt.attr.posOpt)
      case stmt: AST.Stmt.AbstractDatatype =>
        val name = currentName :+ stmt.id.value
        val members = resolveMembers(name, stmt.stmts)
        declareType(if (stmt.isDatatype) "datatype" else "record", name,
          TypeInfo.AbstractDatatype(name, F, members.specVars, members.vars, members.specMethods,
            members.methods, scope(packageName, currentImports, name), stmt), stmt.attr.posOpt)
      case stmt: AST.Stmt.Rich =>
        val name = currentName :+ stmt.id.value
        val members = resolveMembers(name, stmt.stmts)
        assert(members.specVars.isEmpty & members.vars.isEmpty)
        declareType("rich", name, TypeInfo.Rich(name, F, members.specMethods, members.methods,
          scope(packageName, currentImports, name), stmt), stmt.attr.posOpt)
      case stmt: AST.Stmt.TypeAlias =>
        val name = currentName :+ stmt.id.value
        declareType("type alias", name,
          TypeInfo.TypeAlias(name, scope(packageName, currentImports, name), stmt), stmt.attr.posOpt)
      case _ =>
    }
  }

  def resolveMembers(owner: QName, stmts: ISZ[AST.Stmt]): TypeInfo.Members = {
    var specVars = HashMap.empty[String, (QName, AST.Stmt.SpecVar)]
    var vars = HashMap.empty[String, (QName, AST.Stmt.Var)]
    var specMethods = HashMap.empty[String, (QName, AST.Stmt.SpecMethod)]
    var methods = HashMap.empty[String, (QName, AST.Stmt.Method)]

    @pure def checkId(id: AST.Id): Unit = {
      val name = id.value
      val declared: B =
        if (specVars.contains(name)) T
        else if (vars.contains(name)) T
        else if (specMethods.contains(name)) T
        else if (methods.contains(name)) T
        else F
      if (declared) {
        reporter.error(id.attr.posOpt, resolverKind, s"Member $name has been previously declared.")
      }
    }

    for (stmt <- stmts) {
      stmt match {
        case stmt: AST.Stmt.Var =>
          checkId(stmt.id)
          vars = vars.put(stmt.id.value, (owner, stmt))
        case stmt: AST.Stmt.SpecVar =>
          checkId(stmt.id)
          specVars = specVars.put(stmt.id.value, (owner, stmt))
        case stmt: AST.Stmt.Method =>
          checkId(stmt.sig.id)
          methods = methods.put(stmt.sig.id.value, (owner, stmt))
        case stmt: AST.Stmt.SpecMethod =>
          checkId(stmt.sig.id)
          specMethods = specMethods.put(stmt.sig.id.value, (owner, stmt))
        case _ =>
      }
    }
    TypeInfo.Members(specVars, vars, specMethods, methods)
  }

  def declareName(entity: String,
                  name: QName,
                  info: Info,
                  posOpt: Option[AST.PosInfo]): Unit = {
    globalNameMap.get(name) match {
      case Some(_) => reporter.error(posOpt, resolverKind, s"Cannot declare $entity because the name has already been declared previously.")
      case _ => globalNameMap = globalNameMap.put(name, info)
    }
  }

  def declareType(entity: String,
                  name: QName,
                  info: TypeInfo,
                  posOpt: Option[AST.PosInfo]): Unit = {
    globalNameMap.get(name) match {
      case Some(objectInfo: Info.Object) if !objectInfo.ast.isExt =>
        if (!info.canHaveCompanion) {
          reporter.error(posOpt, resolverKind, s"Cannot declare $entity because the name has already been declared previously.")
        } else if (!AST.Util.fileUriOptEq(posOpt, info.posOpt)) {
          reporter.error(posOpt, resolverKind, s"Cannot declare $entity whose object companion is in a different compilation unit.")
        }
      case Some(_) => reporter.error(posOpt, resolverKind, s"Cannot declare $entity because the name has already been declared previously.")
      case _ =>
    }
    globalTypeMap.get(name) match {
      case Some(_) => reporter.error(posOpt, resolverKind, s"Cannot declare $entity because the name has already been declared previously.")
      case _ => globalTypeMap = globalTypeMap.put(name, info)
    }
  }

  def declarePackage(name: QName, posOpt: Option[AST.PosInfo]): Unit = {
    globalNameMap.get(name) match {
      case Some(_: Info.Package) =>
      case Some(_) => reporter.error(posOpt, resolverKind, "Cannot declare package because the name has already been used for a non-package entity.")
      case _ => globalNameMap = globalNameMap.put(name, Info.Package(name))
    }
  }

  def declarePackageName(name: AST.Name): Option[Info.Package] = {
    val ids = name.ids
    if (name.ids.isEmpty) {
      return Some(rootPackageInfo)
    }
    var currentName = ISZ(ids(0).value)
    var currentPosOpt = ids(0).attr.posOpt
    declarePackage(currentName, currentPosOpt)

    for (i <- 1 until ids.size) {
      currentName = currentName :+ ids(i).value
      currentPosOpt = ids(i).attr.posOpt
      declarePackage(currentName, currentPosOpt)
    }

    globalNameMap.get(currentName) match {
      case Some(info: Info.Package) => return Some(info)
      case _ => return None()
    }
  }
}
