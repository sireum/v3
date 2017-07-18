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
import org.sireum.lang.util.{Reporter}
import org.sireum.lang.{ast => AST}

@record class GlobalDeclarationResolver(var globalNameMap: Resolver.NameMap,
                                        var globalTypeMap: Resolver.TypeMap,
                                        reporter: Reporter) {

  var packageName: Resolver.QName = ISZ()
  var currentName: Resolver.QName = ISZ()
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

  @memoize def scope(packageName: Resolver.QName,
                     imports: ISZ[AST.Stmt.Import],
                     name: Resolver.QName): Resolver.Scope.Global = {
    return Resolver.Scope.Global(packageName, imports, SI.dropRight(name, 1))
  }

  def resolveGlobalStmt(stmt: AST.Stmt): Unit = {
    stmt match {
      case stmt: AST.Stmt.Import =>
        currentImports = currentImports :+ stmt
      case stmt: AST.Stmt.Var =>
        val name = currentName :+ stmt.id.value
        declareName(if (stmt.isVal) "val" else "var", name,
          Resolver.Info.Var(name, scope(packageName, currentImports, name), stmt), stmt.attr.posInfoOpt)
      case stmt: AST.Stmt.SpecVar =>
        val name = currentName :+ stmt.id.value
        declareName(if (stmt.isVal) "val" else "var", name,
          Resolver.Info.SpecVar(name, scope(packageName, currentImports, name), stmt), stmt.attr.posInfoOpt)
      case stmt: AST.Stmt.Method =>
        val name = currentName :+ stmt.sig.id.value
        declareName("method", name,
          Resolver.Info.Method(name, scope(packageName, currentImports, name), stmt), stmt.attr.posInfoOpt)
      case stmt: AST.Stmt.ExtMethod =>
        val name = currentName :+ stmt.sig.id.value
        declareName("extension method", name,
          Resolver.Info.ExtMethod(name, scope(packageName, currentImports, name), stmt), stmt.attr.posInfoOpt)
      case stmt: AST.Stmt.SpecMethod =>
        val name = currentName :+ stmt.sig.id.value
        declareName("specification method", name,
          Resolver.Info.SpecMethod(name, scope(packageName, currentImports, name), stmt), stmt.attr.posInfoOpt)
      case stmt: AST.Stmt.Enum =>
        val name = currentName :+ stmt.id.value
        var elements = Set.empty[String]
        for (e <- stmt.elements) {
          if (elements.contains(e.value)) {
            reporter.error(e.attr.posInfoOpt, s"Redeclaration of @enum element ${e.value}.")
          } else {
            elements = elements.add(e.value)
          }
        }
        declareName("enumeration", name, Resolver.Info.Enum(name, elements), stmt.attr.posInfoOpt)
        declareType("enumeration", name :+ "Type", Resolver.TypeInfo.Enum(name, elements, stmt.attr.posInfoOpt), stmt.attr.posInfoOpt)
      case stmt: AST.Stmt.Object =>
        val name = currentName :+ stmt.id.value

        globalTypeMap.get(name) match {
          case Some(info) =>
            val posOpt = stmt.attr.posInfoOpt
            if (stmt.isExt | !info.canHaveCompanion) {
              reporter.error(posOpt, s"Cannot declare extension object because the name has already been declared previously.")
            } else if (!AST.Util.fileUriOptEq(posOpt, info.posInfoOpt)) {
              reporter.error(posOpt, s"Cannot declare companion object for a type defined in a different compilation unit.")
            }
          case _ =>
        }

        declareName(if (stmt.isExt) "extension object" else "object", name,
          Resolver.Info.Object(name, stmt.isExt), stmt.attr.posInfoOpt)
        val oldName = currentName
        currentName = name
        for (s <- stmt.stmts) {
          resolveGlobalStmt(s)
        }
        currentName = oldName
      case stmt: AST.Stmt.Sig =>
        val name = currentName :+ stmt.id.value
        val members = resolveMembers(stmt.stmts)
        assert(members.vars.isEmpty)
        declareType("sig", name, Resolver.TypeInfo.Sig(name, members.specVars,
          members.specMethods, members.methods, scope(packageName, currentImports, name), stmt), stmt.attr.posInfoOpt)
      case stmt: AST.Stmt.AbstractDatatype =>
        val name = currentName :+ stmt.id.value
        val members = resolveMembers(stmt.stmts)
        declareType(if (stmt.isDatatype) "datatype" else "record", name,
          Resolver.TypeInfo.AbstractDatatype(name, members.specVars, members.vars, members.specMethods,
            members.methods, scope(packageName, currentImports, name), stmt), stmt.attr.posInfoOpt)
      case stmt: AST.Stmt.Rich =>
        val name = currentName :+ stmt.id.value
        val members = resolveMembers(stmt.stmts)
        assert(members.specVars.isEmpty & members.vars.isEmpty & members.specMethods.isEmpty)
        declareType("rich", name, Resolver.TypeInfo.Rich(name, members.methods,
          scope(packageName, currentImports, name), stmt), stmt.attr.posInfoOpt)
      case stmt: AST.Stmt.TypeAlias =>
        val name = currentName :+ stmt.id.value
        declareType("type alias", name,
          Resolver.TypeInfo.TypeAlias(name, scope(packageName, currentImports, name), stmt), stmt.attr.posInfoOpt)
      case _ =>
    }
  }

  def resolveMembers(stmts: ISZ[AST.Stmt]): Resolver.TypeInfo.Members = {
    var specVars = HashMap.empty[String, AST.Stmt.SpecVar]
    var vars = HashMap.empty[String, AST.Stmt.Var]
    var specMethods = HashMap.empty[String, AST.Stmt.SpecMethod]
    var methods = HashMap.empty[String, AST.Stmt.Method]

    @pure def checkId(id: AST.Id): Unit = {
      val name = id.value
      val declared: B =
        if (specVars.contains(name)) T
        else if (vars.contains(name)) T
        else if (specMethods.contains(name)) T
        else if (methods.contains(name)) T
        else F
      if (declared) {
        reporter.error(id.attr.posInfoOpt, s"Member $name has been previously declared.")
      }
    }

    for (stmt <- stmts) {
      stmt match {
        case stmt: AST.Stmt.Var =>
          checkId(stmt.id)
          vars = vars.put(stmt.id.value, stmt)
        case stmt: AST.Stmt.SpecVar =>
          checkId(stmt.id)
          specVars = specVars.put(stmt.id.value, stmt)
        case stmt: AST.Stmt.Method =>
          checkId(stmt.sig.id)
          methods = methods.put(stmt.sig.id.value, stmt)
        case stmt: AST.Stmt.SpecMethod =>
          checkId(stmt.sig.id)
          specMethods = specMethods.put(stmt.sig.id.value, stmt)
        case _ =>
      }
    }
    Resolver.TypeInfo.Members(specVars, vars, specMethods, methods)
  }

  def declareName(entity: String,
                  name: Resolver.QName,
                  info: Resolver.Info,
                  posOpt: Option[AST.PosInfo]): Unit = {
    globalNameMap.get(name) match {
      case Some(_) => reporter.error(posOpt, s"Cannot declare $entity because the name has already been declared previously.")
      case _ => globalNameMap = globalNameMap.put(name, info)
    }
  }

  def declareType(entity: String,
                  name: Resolver.QName,
                  info: Resolver.TypeInfo,
                  posOpt: Option[AST.PosInfo]): Unit = {
    globalNameMap.get(name) match {
      case Some(objectInfo: Resolver.Info.Object) if !objectInfo.isExt =>
        if (!info.canHaveCompanion) {
          reporter.error(posOpt, s"Cannot declare $entity because the name has already been declared previously.")
        } else if (!AST.Util.fileUriOptEq(posOpt, info.posInfoOpt)) {
          reporter.error(posOpt, s"Cannot declare $entity whose object companion is in a different compilation unit.")
        }
      case Some(_) => reporter.error(posOpt, s"Cannot declare $entity because the name has already been declared previously.")
      case _ =>
    }
    globalTypeMap.get(name) match {
      case Some(_) => reporter.error(posOpt, s"Cannot declare $entity because the name has already been declared previously.")
      case _ => globalTypeMap = globalTypeMap.put(name, info)
    }
  }

  def declarePackage(name: Resolver.QName, posOpt: Option[AST.PosInfo]): Unit = {
    globalNameMap.get(name) match {
      case Some(_: Resolver.Info.Package) =>
      case Some(_) => reporter.error(posOpt, "Cannot declare package because the name has already been used for a non-package entity.")
      case _ => globalNameMap = globalNameMap.put(name, Resolver.Info.Package(name))
    }
  }

  def declarePackageName(name: AST.Name): Option[Resolver.Info.Package] = {
    val ids = name.ids
    if (name.ids.isEmpty) {
      return Some(Resolver.rootPackageInfo)
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
      case Some(info: Resolver.Info.Package) => return Some(info)
      case _ => return None()
    }
  }
}
