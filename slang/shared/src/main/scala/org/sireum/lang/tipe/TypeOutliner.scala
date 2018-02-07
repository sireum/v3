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
import org.sireum.lang.{ast => AST}
import org.sireum.lang.symbol.Resolver._
import org.sireum.lang.util._

object TypeOutliner {

  def checkOutline(typeHierarchy: TypeHierarchy, reporter: Reporter): TypeHierarchy = {
    def combine(
      r: (TypeHierarchy, AccumulatingReporter),
      f: TypeHierarchy => (TypeHierarchy, AccumulatingReporter)
    ): (TypeHierarchy, AccumulatingReporter) = {
      val p = f(r._1)
      return (p._1, AccumulatingReporter.combine(r._2, p._2))
    }

    def parentsOutlined(name: QName, typeMap: TypeMap): B = {
      def isOutlined(name: QName): B = {
        typeMap.get(name).get match {
          case ti: TypeInfo.Sig => return ti.outlined
          case ti: TypeInfo.AbstractDatatype => return ti.outlined
          case _ => return T
        }
      }

      var r = T
      for (p <- typeHierarchy.poset.parentsOf(TypeHierarchy.TypeName(AST.Typed.Name(name, ISZ()))).elements if r) {
        typeMap.get(p.t.ids).get match {
          case ti: TypeInfo.TypeAlias =>
            val t = typeHierarchy.dealiasInit(AST.Typed.Name(ti.name, ISZ()), reporter).get
            r = isOutlined(t.ids)
          case ti =>
            r = isOutlined(ti.name)
        }
      }
      return r
    }

    var workList = typeHierarchy.rootTypeNames()
    var th = typeHierarchy
    while (workList.nonEmpty && !reporter.hasIssue) {
      var l = ISZ[QName]()
      var jobs = ISZ[() => TypeHierarchy => (TypeHierarchy, AccumulatingReporter)]()
      for (name <- workList) {
        val ti = th.typeMap.get(name).get
        var ok: B = F
        val to = TypeOutliner(th)
        ti match {
          case ti: TypeInfo.Sig =>
            if (!ti.outlined) {
              val po = parentsOutlined(ti.name, th.typeMap)
              if (po) {
                jobs = jobs :+ (() => to.outlineSig(ti))
                ok = T
              }
            } else {
              ok = T
            }
          case ti: TypeInfo.AbstractDatatype =>
            if (!ti.outlined) {
              val po = parentsOutlined(ti.name, th.typeMap)
              if (po) {
                jobs = jobs :+ (() => to.outlineAdt(ti))
                ok = T
              }
            } else {
              ok = T
            }
          case _ =>
        }
        if (ok) {
          val children = typeHierarchy.poset.childrenOf(TypeHierarchy.TypeName(AST.Typed.Name(name, ISZ()))).elements
          for (n <- children) {
            l = l :+ n.t.ids
          }
        }
      }
      val jobsOps = ISZOps(jobs)
      val r = jobsOps.parMapFoldLeft(
        (f: () => TypeHierarchy => (TypeHierarchy, AccumulatingReporter)) => f(),
        combine _,
        (th, AccumulatingReporter.create)
      )
      reporter.reports(r._2.messages)
      th = r._1
      workList = l
    }
    if (!reporter.hasIssue) {
      var jobs = ISZ[() => TypeHierarchy => (TypeHierarchy, AccumulatingReporter)]()
      val to = TypeOutliner(th)
      for (info <- th.nameMap.values) {
        info match {
          case info: Info.Object if !info.outlined => jobs = jobs :+ (() => to.outlineObject(info))
          case _ =>
        }
      }
      val r = ISZOps(jobs).parMapFoldLeft(
        (f: () => TypeHierarchy => (TypeHierarchy, AccumulatingReporter)) => f(),
        combine _,
        (th, AccumulatingReporter.create)
      )
      reporter.reports(r._2.messages)
      th = r._1
      var gnm = th.nameMap
      val to2 = TypeOutliner(th)
      for (info <- gnm.values) {
        val infoOpt: Option[Info] = info match {
          case info: Info.Var if !info.outlined => to2.outlineVar(info, reporter)
          case info: Info.SpecVar if !info.outlined => to2.outlineSpecVar(info, reporter)
          case info: Info.Method if !info.outlined => to2.outlineMethod(info, reporter)
          case info: Info.SpecMethod if !info.outlined => to2.outlineSpecMethod(info, reporter)
          case _ => None()
        }
        infoOpt match {
          case Some(inf) => gnm = gnm.put(info.name, inf)
          case _ =>
        }
      }
      return th(nameMap = gnm)
    } else {
      return th
    }
  }
}

@datatype class TypeOutliner(typeHierarchy: TypeHierarchy) {

  def outlineSpecVar(info: Info.SpecVar, reporter: Reporter): Option[Info] = {
    val sv = info.ast
    val newTipeOpt = typeHierarchy.typed(info.scope, sv.tipe, reporter)
    newTipeOpt match {
      case Some(newTipe) =>
        return Some(info(ast = sv(tipe = newTipe), typedOpt = newTipe.typedOpt))
      case _ => return None()
    }
  }

  def outlineVar(info: Info.Var, reporter: Reporter): Option[Info] = {
    val v = info.ast
    val tpe = v.tipeOpt.get
    val newTipeOpt = typeHierarchy.typed(info.scope, tpe, reporter)
    newTipeOpt match {
      case Some(newTipe) =>
        return Some(info(ast = v(tipeOpt = newTipeOpt), typedOpt = newTipe.typedOpt))
      case _ => return None()
    }
  }

  def outlineSpecMethod(info: Info.SpecMethod, reporter: Reporter): Option[Info] = {
    val sm = info.ast
    val sigOpt = outlineMethodSig(info.scope, sm.sig, reporter)
    sigOpt match {
      case Some((sig, tVars)) =>
        return Some(
          info(
            ast = sm(sig = sig),
            typedOpt = Some(
              AST.Typed.Method(
                T,
                AST.MethodMode.Spec,
                tVars,
                info.owner,
                sig.id.value,
                sig.params.map(p => p.id.value),
                ISZ(),
                sig.funType
              )
            )
          )
        )
      case _ => return None()
    }
  }

  def outlineMethod(info: Info.Method, reporter: Reporter): Option[Info] = {
    val m = info.ast
    val sigOpt = outlineMethodSig(info.scope, m.sig, reporter)
    sigOpt match {
      case Some((sig, tVars)) =>
        return Some(
          info(
            ast = m(sig = sig),
            typedOpt = Some(
              AST.Typed.Method(
                T,
                AST.MethodMode.Normal,
                tVars,
                info.owner,
                sig.id.value,
                sig.params.map(p => p.id.value),
                ISZ(),
                sig.funType
              )
            )
          )
        )
      case _ => return None()
    }
  }

  def outlineExtMethod(info: Info.ExtMethod, reporter: Reporter): Option[Info] = {
    val m = info.ast
    val sigOpt = outlineMethodSig(info.scope, m.sig, reporter)
    sigOpt match {
      case Some((sig, tVars)) =>
        return Some(
          info(
            ast = m(sig = sig),
            typedOpt = Some(
              AST.Typed.Method(
                T,
                AST.MethodMode.Ext,
                tVars,
                info.owner,
                sig.id.value,
                sig.params.map(p => p.id.value),
                ISZ(),
                sig.funType
              )
            )
          )
        )
      case _ => return None()
    }
  }

  @pure def outlineObject(info: Info.Object): TypeHierarchy => (TypeHierarchy, AccumulatingReporter) = {
    val reporter = AccumulatingReporter.create

    var infos = ISZ[(QName, Info)]()
    for (stmt <- info.ast.stmts) {
      val idOpt: Option[String] = stmt match {
        case stmt: AST.Stmt.SpecVar => Some(stmt.id.value)
        case stmt: AST.Stmt.Var => Some(stmt.id.value)
        case stmt: AST.Stmt.SpecMethod => Some(stmt.sig.id.value)
        case stmt: AST.Stmt.Method => Some(stmt.sig.id.value)
        case stmt: AST.Stmt.ExtMethod => Some(stmt.sig.id.value)
        case _ => None()
      }
      idOpt match {
        case Some(id) =>
          val infoOpt: Option[Info] = typeHierarchy.nameMap.get(info.name :+ id).get match {
            case inf: Info.SpecVar => val rOpt = outlineSpecVar(inf, reporter); rOpt
            case inf: Info.Var => val rOpt = outlineVar(inf, reporter); rOpt
            case inf: Info.SpecMethod => val rOpt = outlineSpecMethod(inf, reporter); rOpt
            case inf: Info.Method => val rOpt = outlineMethod(inf, reporter); rOpt
            case inf: Info.ExtMethod => val rOpt = outlineExtMethod(inf, reporter); rOpt
            case _ => None()
          }
          infoOpt match {
            case Some(inf) => infos = infos :+ ((inf.name, inf))
            case _ =>
          }
        case _ =>
      }
    }

    return (th: TypeHierarchy) => (th(nameMap = th.nameMap.putAll(infos).put(info.name, info(outlined = T))), reporter)
  }

  @pure def outlineSig(info: TypeInfo.Sig): TypeHierarchy => (TypeHierarchy, AccumulatingReporter) = {
    val reporter = AccumulatingReporter.create
    val tm = typeParamMap(info.ast.typeParams, reporter)
    val scope = localTypeScope(tm.map, info.scope)
    val members = outlineMembers(
      T,
      info.name,
      TypeInfo.Members(info.specVars, HashMap.empty, info.specMethods, info.methods),
      scope,
      reporter
    )
    val (TypeInfo.Members(specVars, _, specMethods, methods), ancestors) =
      outlineInheritedMembers(info.name, info.ast.parents, scope, members, reporter)
    val newInfo =
      info(outlined = T, ancestors = ancestors, specVars = specVars, specMethods = specMethods, methods = methods)
    return (th: TypeHierarchy) => (th(typeMap = th.typeMap.put(info.name, newInfo)), reporter)
  }

  @pure def outlineAdt(info: TypeInfo.AbstractDatatype): TypeHierarchy => (TypeHierarchy, AccumulatingReporter) = {
    val reporter = AccumulatingReporter.create
    val tm = typeParamMap(info.ast.typeParams, reporter)
    val scope = localTypeScope(tm.map, info.scope)
    val members = outlineMembers(
      info.ast.isRoot,
      info.name,
      TypeInfo.Members(info.specVars, info.vars, info.specMethods, info.methods),
      scope,
      reporter
    )
    val (TypeInfo.Members(specVars, vars, specMethods, methods), ancestors) =
      outlineInheritedMembers(info.name, info.ast.parents, scope, members, reporter)
    var newParams = ISZ[AST.AbstractDatatypeParam]()
    var paramTypes = ISZ[AST.Typed]()
    for (p <- info.ast.params) {
      val newTipeOpt = typeHierarchy.typed(scope, p.tipe, reporter)
      newTipeOpt match {
        case Some(newTipe) if newTipe.typedOpt.nonEmpty =>
          paramTypes = paramTypes :+ newTipe.typedOpt.get
          newParams = newParams :+ p(tipe = newTipe)
        case _ =>
      }
    }
    val newInfo: TypeInfo.AbstractDatatype =
      if (info.ast.isRoot)
        info(
          outlined = T,
          ancestors = ancestors,
          specVars = specVars,
          vars = vars,
          specMethods = specMethods,
          methods = methods
        )
      else
        info(
          outlined = T,
          ancestors = ancestors,
          constructorTypeOpt = Some(
            AST.Typed.Method(
              F,
              AST.MethodMode.Constructor,
              tm.keys.elements,
              info.owner,
              info.ast.id.value,
              info.ast.params.map(p => p.id.value),
              ISZ(),
              AST.Typed.Fun(T, F, paramTypes, info.tpe)
            )
          ),
          specVars = specVars,
          vars = vars,
          specMethods = specMethods,
          methods = methods,
          ast = info.ast(params = newParams)
        )
    return (th: TypeHierarchy) => (th(typeMap = th.typeMap.put(info.name, newInfo)), reporter)
  }

  def outlineMethodSig(scope: Scope, sig: AST.MethodSig, reporter: Reporter): Option[(AST.MethodSig, ISZ[String])] = {
    val typeParams = sig.typeParams
    for (tp <- typeParams) {
      scope.resolveType(typeHierarchy.typeMap, ISZ(tp.id.value)) match {
        case Some(info) if info.name.size == 1 =>
          reporter
            .error(tp.id.attr.posOpt, TypeChecker.typeCheckerKind, s"Cannot redeclare type parameter ${tp.id.value}.")
          return None()
        case _ =>
      }
    }
    val tm = typeParamMap(typeParams, reporter)
    val mScope = localTypeScope(tm.map, scope)
    var params = ISZ[AST.Param]()
    for (p <- sig.params) {
      val tipeOpt = typeHierarchy.typed(mScope, p.tipe, reporter)
      tipeOpt match {
        case Some(tipe) if tipe.typedOpt.nonEmpty => params = params :+ p(tipe = tipe)
        case _ => return None()
      }
    }
    val returnTypeOpt = typeHierarchy.typed(mScope, sig.returnType, reporter)
    returnTypeOpt match {
      case Some(returnType) if returnTypeOpt.nonEmpty =>
        return Some((sig(params = params, returnType = returnType), tm.keys.elements))
      case _ => return None()
    }
  }

  def outlineMembers(
    isAbstract: B,
    name: QName,
    info: TypeInfo.Members,
    scope: Scope,
    reporter: Reporter
  ): TypeInfo.Members = {
    var specVars = HashMap.empty[String, Info.SpecVar]
    var vars = HashMap.empty[String, Info.Var]
    var specMethods = HashMap.empty[String, Info.SpecMethod]
    var methods = HashMap.empty[String, Info.Method]

    def isDeclared(id: String): B = {
      return specVars.contains(id) || vars.contains(id) || specMethods.contains(id) || methods.contains(id)
    }

    def checkSpecVar(info: Info.SpecVar): Unit = {
      val sv = info.ast
      val id = sv.id.value
      if (isDeclared(id)) {
        reporter.error(sv.attr.posOpt, TypeChecker.typeCheckerKind, s"Cannot redeclare $id.")
        return
      }
      val tipeOpt = typeHierarchy.typed(scope, sv.tipe, reporter)
      tipeOpt match {
        case Some(tipe) if tipe.typedOpt.nonEmpty =>
          specVars = specVars.put(id, info(ast = sv(tipe = tipe), typedOpt = tipe.typedOpt))
        case _ =>
      }
    }

    def checkVar(info: Info.Var): Unit = {
      val v = info.ast
      val id = v.id.value
      if (isDeclared(id)) {
        reporter.error(v.attr.posOpt, TypeChecker.typeCheckerKind, s"Cannot redeclare $id.")
        return
      }
      val tpe = v.tipeOpt.get
      val tipeOpt = typeHierarchy.typed(scope, tpe, reporter)
      tipeOpt match {
        case Some(tipe) =>
          vars = vars.put(id, info(ast = v(tipeOpt = Some(tipe)), typedOpt = tipe.typedOpt))
        case _ =>
      }
    }

    def checkSpecMethod(info: Info.SpecMethod): Unit = {
      val sm = info.ast
      val id = sm.sig.id.value
      if (isDeclared(id)) {
        reporter.error(sm.sig.id.attr.posOpt, TypeChecker.typeCheckerKind, s"Cannot redeclare $id.")
        return
      }
      val sigOpt = outlineMethodSig(scope, sm.sig, reporter)
      sigOpt match {
        case Some((sig, tVars)) =>
          specMethods = specMethods.put(
            id,
            info(
              ast = sm(sig = sig),
              typedOpt = Some(
                AST.Typed.Method(
                  F,
                  AST.MethodMode.Spec,
                  tVars,
                  info.owner,
                  id,
                  sig.params.map(p => p.id.value),
                  ISZ(),
                  sig.funType
                )
              )
            )
          )
        case _ =>
      }
    }

    def checkMethod(info: Info.Method): Unit = {
      val m = info.ast
      val id = m.sig.id.value
      if (isDeclared(id)) {
        reporter.error(m.sig.id.attr.posOpt, TypeChecker.typeCheckerKind, s"Cannot redeclare $id.")
        return
      }
      val sigOpt = outlineMethodSig(scope, m.sig, reporter)
      sigOpt match {
        case Some((sig, tVars)) =>
          methods = methods.put(
            id,
            info(
              ast = m(sig = sig),
              typedOpt = Some(
                AST.Typed.Method(
                  F,
                  AST.MethodMode.Normal,
                  tVars,
                  info.owner,
                  id,
                  sig.params.map(p => p.id.value),
                  ISZ(),
                  sig.funType
                )
              )
            )
          )
        case _ =>
      }
    }

    for (p <- info.specVars.values) {
      checkSpecVar(p)
    }

    for (p <- info.vars.values) {
      checkVar(p)
    }

    for (p <- info.specMethods.values) {
      checkSpecMethod(p)
    }

    for (p <- info.methods.values) {
      checkMethod(p)
    }

    return TypeInfo.Members(specVars, vars, specMethods, methods)
  }

  def outlineInheritedMembers(
    name: QName,
    parents: ISZ[AST.Type.Named],
    scope: Scope,
    info: TypeInfo.Members,
    reporter: Reporter
  ): (TypeInfo.Members, ISZ[AST.Typed.Name]) = {
    var specVars = info.specVars
    var vars = info.vars
    var specMethods = info.specMethods
    var methods = info.methods

    def checkSpecInherit(id: String, tname: QName, posOpt: Option[AST.PosInfo]): B = {
      specVars.get(id) match {
        case Some(otherInfo) =>
          if (name != tname) {
            reporter.error(
              posOpt,
              TypeChecker.typeCheckerKind,
              st"Cannot inherit $id because it has been previously inherited from ${(otherInfo.owner, ".")}.".render
            )
          } else {
            reporter.error(
              posOpt,
              TypeChecker.typeCheckerKind,
              s"Cannot inherit $id because it has been previously declared."
            )
          }
          return F
        case _ =>
      }
      specMethods.get(id) match {
        case Some(otherInfo) =>
          if (name != tname) {
            reporter.error(
              posOpt,
              TypeChecker.typeCheckerKind,
              st"Cannot inherit $id because it has been previously inherited from ${(otherInfo.owner, ".")}.".render
            )
          } else {
            reporter.error(
              posOpt,
              TypeChecker.typeCheckerKind,
              s"Cannot inherit $id because it has been previously declared."
            )
          }
          return F
        case _ =>
      }
      return T
    }

    def checkInherit(id: String, tname: QName, posOpt: Option[AST.PosInfo]): B = {
      val ok = checkSpecInherit(id, tname, posOpt)
      if (!ok) {
        return ok
      }
      vars.get(id) match {
        case Some(otherInfo) =>
          if (name != tname) {
            reporter.error(
              posOpt,
              TypeChecker.typeCheckerKind,
              st"Cannot inherit $id because it has been previously inherited from ${(otherInfo.owner, ".")}.".render
            )
          } else {
            reporter.error(
              posOpt,
              TypeChecker.typeCheckerKind,
              s"Cannot inherit $id because it has been previously declared."
            )
          }
          return F
        case _ =>
      }
      methods.get(id) match {
        case Some(otherInfo) =>
          if (name != tname) {
            reporter.error(
              posOpt,
              TypeChecker.typeCheckerKind,
              st"Cannot inherit $id because it has been previously inherited from ${(otherInfo.owner, ".")}.".render
            )
          } else {
            reporter.error(
              posOpt,
              TypeChecker.typeCheckerKind,
              s"Cannot inherit $id because it has been previously declared."
            )
          }
          return F
        case _ =>
      }
      return T
    }

    def inheritSpecVar(info: Info.SpecVar, posOpt: Option[AST.PosInfo], substMap: HashMap[String, AST.Typed]): Unit = {
      val owner = info.owner
      var sv = info.ast
      val id = sv.id.value
      val ok = checkInherit(id, owner, posOpt)
      if (ok) {
        if (substMap.isEmpty) {
          specVars = specVars.put(id, info)
        } else {
          sv = sv(tipe = sv.tipe.typed(sv.tipe.typedOpt.get.subst(substMap)))
          specVars = specVars.put(id, info(ast = sv, typedOpt = sv.tipe.typedOpt))
        }
      }
    }

    def inheritVar(info: Info.Var, posOpt: Option[AST.PosInfo], substMap: HashMap[String, AST.Typed]): Unit = {
      val owner = info.owner
      var v = info.ast
      val id = v.id.value
      val ok = checkInherit(id, owner, posOpt)
      if (ok) {
        if (substMap.isEmpty) {
          if (v.initOpt.nonEmpty) {
            v = v(initOpt = None())
          }
          vars = vars.put(id, info(ast = v))
        } else {
          val t = v.tipeOpt.get.typed(v.tipeOpt.get.typedOpt.get.subst(substMap))
          v = v(tipeOpt = Some(t), initOpt = None())
          vars = vars.put(id, info(ast = v, typedOpt = t.typedOpt))
        }
      }
    }

    def inheritSpecMethod(
      info: Info.SpecMethod,
      posOpt: Option[AST.PosInfo],
      substMap: HashMap[String, AST.Typed]
    ): Unit = {
      val owner = info.owner
      var sm = info.ast
      val id = sm.sig.id.value
      val ok = checkInherit(id, owner, posOpt)
      if (ok) {
        if (substMap.isEmpty) {
          if (sm.defs.nonEmpty || sm.where.nonEmpty) {
            sm = sm(defs = ISZ(), where = ISZ())
          }
          specMethods = specMethods.put(id, info(ast = sm))
        } else {
          var params = ISZ[AST.Param]()
          for (param <- sm.sig.params) {
            params = params :+ param(tipe = param.tipe.typed(param.tipe.typedOpt.get.subst(substMap)))
          }
          sm = sm(
            sig = sm.sig(
              params = params,
              returnType = sm.sig.returnType.typed(sm.sig.returnType.typedOpt.get.subst(substMap))
            )
          )
          specMethods = specMethods.put(id, info(ast = sm, typedOpt = Some(sm.sig.funType)))
        }
      }
    }

    def checkMethodEquality(
      m1: Info.Method,
      m2: Info.Method,
      substMap: HashMap[String, AST.Typed],
      posOpt: Option[AST.PosInfo]
    ): B = {
      val t1 = m1.typedOpt.get.deBruijn
      val t2 = m2.typedOpt.get.subst(substMap).deBruijn
      return t1 == t2
    }

    def checkMethodRefinement(
      m: Info.Method,
      supM: Info.Method,
      substMap: HashMap[String, AST.Typed],
      posOpt: Option[AST.PosInfo]
    ): B = {
      val t1 = m.typedOpt.get.deBruijn
      val t2 = supM.typedOpt.get.subst(substMap).deBruijn
      return typeHierarchy.isRefinement(t1, t2)
    }

    def checkVarRefinement(
      m: AST.Stmt.Method,
      v: AST.Stmt.Var,
      substMap: HashMap[String, AST.Typed],
      posOpt: Option[AST.PosInfo]
    ): B = {
      if (m.sig.typeParams.nonEmpty) {
        return F
      }
      if (m.sig.hasParams || m.sig.params.nonEmpty) {
        return F
      }
      val rt = m.sig.returnType.typedOpt.get.subst(substMap)
      val t = v.tipeOpt.get.typedOpt.get
      val r = typeHierarchy.isSubType(t, rt)
      return r
    }

    def inheritMethod(info: Info.Method, posOpt: Option[AST.PosInfo], substMap: HashMap[String, AST.Typed]): Unit = {
      val tname = info.owner
      val pm = info.ast
      val id = pm.sig.id.value

      var ok = checkSpecInherit(id, tname, posOpt)
      if (!ok) {
        return
      }
      vars.get(id) match {
        case Some(otherInfo) =>
          if (name != otherInfo.owner) {
            reporter.error(
              posOpt,
              TypeChecker.typeCheckerKind,
              st"Cannot inherit $id from ${(tname, ".")} because it has been previously inherited from ${(name, ".")}.".render
            )
            return
          } else if (!(!info.ast.sig.hasParams && typeHierarchy.isSubType(
              otherInfo.typedOpt.get,
              info.ast.sig.returnType.typedOpt.get
            ))) {
            reporter.error(
              posOpt,
              TypeChecker.typeCheckerKind,
              st"Cannot inherit $id from ${(tname, ".")} because it is declared with incompatible type.".render
            )
            return
          }
        case _ =>
      }
      methods.get(id) match {
        case Some(otherInfo) =>
          if (name != otherInfo.owner) {
            ok = checkMethodEquality(otherInfo, info, substMap, posOpt)
            if (!ok) {
              reporter.error(
                posOpt,
                TypeChecker.typeCheckerKind,
                st"Cannot inherit $id from ${(tname, ".")} because it has been previously inherited from ${(otherInfo.owner, ".")} with differing type.".render
              )
              return
            }
            if (info.hasBody && otherInfo.hasBody) {
              reporter.error(
                posOpt,
                TypeChecker.typeCheckerKind,
                st"Cannot inherit $id from ${(tname, ".")} because it has been previously inherited from ${(otherInfo.owner, ".")} with their own implementation.".render
              )
              return
            }
          } else {
            ok = checkMethodRefinement(otherInfo, info, substMap, posOpt)
            if (!ok) {
              checkMethodRefinement(otherInfo, info, substMap, posOpt)
              reporter.error(
                posOpt,
                TypeChecker.typeCheckerKind,
                st"Cannot inherit $id from ${(tname, ".")} because it is declared with incompatible type.".render
              )
              return
            }
            if (info.hasBody && !otherInfo.hasBody) {
              reporter.error(
                posOpt,
                TypeChecker.typeCheckerKind,
                st"Cannot inherit $id from ${(tname, ".")} with implementation because it is declared but unimplemented.".render
              )
              return
            }
          }
        case _ =>
          vars.get(id) match {
            case Some(otherInfo) =>
              val v = otherInfo.ast
              ok = checkVarRefinement(pm, v, substMap, posOpt)
              if (!ok) {
                reporter.error(
                  posOpt,
                  TypeChecker.typeCheckerKind,
                  s"Cannot inherit $id because it has been previously declared with incompatible type."
                )
                return
              }
            case _ =>
              if (substMap.isEmpty) {
                methods = methods.put(
                  id,
                  if (info.ast.bodyOpt.nonEmpty) info(ast = info.ast(bodyOpt = None()))
                  else info
                )
              } else {
                var m = pm
                var params = ISZ[AST.Param]()
                for (param <- m.sig.params) {
                  params = params :+ param(tipe = param.tipe.typed(param.tipe.typedOpt.get.subst(substMap)))
                }
                m = m(
                  bodyOpt = None(),
                  sig = m.sig(
                    params = params,
                    returnType = m.sig.returnType.typed(m.sig.returnType.typedOpt.get.subst(substMap))
                  )
                )
                methods = methods.put(id, info(ast = m, typedOpt = Some(info.typedOpt.get.subst(substMap))))
              }
          }
      }
    }

    var ancestors = HashSSet.empty[AST.Typed]
    for (parent <- parents) {
      val tipeOpt = typeHierarchy.typed(scope, parent, reporter)
      for (tipe <- tipeOpt) {
        tipe.typedOpt match {
          case Some(t: AST.Typed.Name) =>
            t match {
              case t: AST.Typed.Name =>
                typeHierarchy.typeMap.get(t.ids) match {
                  case Some(ti: TypeInfo.Sig) =>
                    val substMapOpt =
                      TypeChecker.buildTypeSubstMap(ti.name, parent.posOpt, ti.ast.typeParams, t.args, reporter)
                    substMapOpt match {
                      case Some(substMap) =>
                        ancestors = ancestors.add(ti.tpe.subst(substMap))
                        for (tpe <- ti.ancestors) {
                          ancestors = ancestors.add(tpe.subst(substMap))
                        }
                        for (p <- ti.specVars.values) {
                          inheritSpecVar(p, parent.attr.posOpt, substMap)
                        }
                        for (p <- ti.specMethods.values) {
                          inheritSpecMethod(p, parent.attr.posOpt, substMap)
                        }
                        for (p <- ti.methods.values) {
                          inheritMethod(p, parent.attr.posOpt, substMap)
                        }
                      case _ =>
                    }
                  case Some(ti: TypeInfo.AbstractDatatype) =>
                    val substMapOpt =
                      TypeChecker.buildTypeSubstMap(ti.name, parent.posOpt, ti.ast.typeParams, t.args, reporter)
                    substMapOpt match {
                      case Some(substMap) =>
                        ancestors = ancestors.add(ti.tpe.subst(substMap))
                        for (tpe <- ti.ancestors) {
                          ancestors = ancestors.add(tpe.subst(substMap))
                        }
                        for (p <- ti.specVars.values) {
                          inheritSpecVar(p, parent.attr.posOpt, substMap)
                        }
                        for (p <- ti.vars.values) {
                          inheritVar(p, parent.attr.posOpt, substMap)
                        }
                        for (p <- ti.specMethods.values) {
                          inheritSpecMethod(p, parent.attr.posOpt, substMap)
                        }
                        for (p <- ti.methods.values) {
                          inheritMethod(p, parent.attr.posOpt, substMap)
                        }
                      case _ =>
                    }
                  case _ =>
                }
              case _ =>
                halt(
                  "Infeasible: type hierarchy phase should have checked type parents should be a @sig, @msig, @datatype, @record, or @rich."
                )
            }
          case _ => halt("Infeasible: type hierarchy phase should have checked type parents should be a typed name.")
        }
      }
    }
    return (
      TypeInfo.Members(specVars, vars, specMethods, methods),
      ancestors.elements.map(
        t =>
          t match {
            case t: AST.Typed.Name => t
            case _ => halt("Unexpected situation while outlining types.")
        }
      )
    )
  }

}
