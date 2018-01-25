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

  def checkOutline(typeHierarchy: TypeHierarchy,
                   reporter: Reporter): TypeHierarchy = {
    def combine(r: (TypeHierarchy, AccumulatingReporter),
                f: TypeHierarchy => (TypeHierarchy, AccumulatingReporter)): (TypeHierarchy, AccumulatingReporter) = {
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
      for (p <- typeHierarchy.poset.parentsOf(TypeHierarchy.TypeName(AST.Typed.Name(name, ISZ(), None()))).elements if r) {
        typeMap.get(p.t.ids).get match {
          case ti: TypeInfo.TypeAlias =>
            val t = typeHierarchy.dealiasInit(AST.Typed.Name(ti.name, ISZ(), None()), reporter).get
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
          val children = typeHierarchy.poset.childrenOf(TypeHierarchy.TypeName(AST.Typed.Name(name, ISZ(), None()))).elements
          for (n <- children) {
            l = l :+ n.t.ids
          }
        }
      }
      val jobsOps = ISZOps(jobs)
      val r = jobsOps.
        parMapFoldLeft(
          (f: () => TypeHierarchy => (TypeHierarchy, AccumulatingReporter)) => f(),
          combine _,
          (th, AccumulatingReporter.create))
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
      val r = ISZOps(jobs).
        parMapFoldLeft(
          (f: () => TypeHierarchy => (TypeHierarchy, AccumulatingReporter)) => f(),
          combine _,
          (th, AccumulatingReporter.create))
      reporter.reports(r._2.messages)
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
    val tOpt = typeHierarchy.typed(info.scope, sv.tipe, reporter)
    tOpt match {
      case Some(t) => return Some(info(ast = sv(tipe = sv.tipe.typed(t))))
      case _ => return None()
    }
  }

  def outlineVar(info: Info.Var, reporter: Reporter): Option[Info] = {
    val v = info.ast
    val tpe = v.tipeOpt.get
    val tOpt = typeHierarchy.typed(info.scope, tpe, reporter)
    tOpt match {
      case Some(t) => return Some(info(ast = v(tipeOpt = Some(tpe.typed(t)))))
      case _ => return None()
    }
  }

  def outlineSpecMethod(info: Info.SpecMethod, reporter: Reporter): Option[Info] = {
    val sm = info.ast
    val sigOpt = outlineMethodSig(info.scope, sm.sig, reporter)
    sigOpt match {
      case Some(sig) => return Some(info(ast = sm(sig = sig)))
      case _ => return None()
    }
  }

  def outlineMethod(info: Info.Method, reporter: Reporter): Option[Info] = {
    val m = info.ast
    val sigOpt = outlineMethodSig(info.scope, m.sig, reporter)
    sigOpt match {
      case Some(sig) => return Some(info(ast = m(sig = sig)))
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
        case _ => None()
      }
      idOpt match {
        case Some(id) =>
          val infoOpt: Option[Info] = typeHierarchy.nameMap.get(info.name :+ id).get match {
            case inf: Info.SpecVar => val rOpt = outlineSpecVar(inf, reporter); rOpt
            case inf: Info.Var => val rOpt = outlineVar(inf, reporter); rOpt
            case inf: Info.SpecMethod => val rOpt = outlineSpecMethod(inf, reporter); rOpt
            case inf: Info.Method => val rOpt = outlineMethod(inf, reporter); rOpt
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
    var members = outlineMembers(T, info.name,
      TypeInfo.Members(info.specVars, HashMap.empty, info.specMethods, info.methods), scope, reporter)
    members = outlineInheritedMembers(info.name, info.ast.parents, scope, members, reporter)
    val specVars = members.specVars
    val specMethods = members.specMethods
    val methods = members.methods
    val newInfo = info(outlined = T, specVars = specVars, specMethods = specMethods, methods = methods)
    return (th: TypeHierarchy) => (th(typeMap = th.typeMap.put(info.name, newInfo)), reporter)
  }

  @pure def outlineAdt(info: TypeInfo.AbstractDatatype): TypeHierarchy => (TypeHierarchy, AccumulatingReporter) = {
    val reporter = AccumulatingReporter.create
    val tm = typeParamMap(info.ast.typeParams, reporter)
    val scope = localTypeScope(tm.map, info.scope)
    var members = outlineMembers(info.ast.isRoot, info.name,
      TypeInfo.Members(info.specVars, info.vars, info.specMethods, info.methods), scope, reporter)
    members = outlineInheritedMembers(info.name, info.ast.parents, scope, members, reporter)
    val specVars = members.specVars
    val vars = members.vars
    val specMethods = members.specMethods
    val methods = members.methods
    val newInfo = info(outlined = T, specVars = specVars, vars = vars, specMethods = specMethods, methods = methods)
    return (th: TypeHierarchy) => (th(typeMap = th.typeMap.put(info.name, newInfo)), reporter)
  }

  def outlineMethodSig(scope: Scope,
                       sig: AST.MethodSig,
                       reporter: Reporter): Option[AST.MethodSig] = {
    val id = sig.id.value
    val typeParams = sig.typeParams
    for (tp <- typeParams) {
      scope.resolveType(typeHierarchy.typeMap, ISZ(tp.id.value)) match {
        case Some(ti) if isTypeParamName(ti.name) =>
          reporter.error(tp.id.attr.posOpt, TypeChecker.typeCheckerKind,
            s"Cannot redeclare type parameter $id.")
          return None()
        case _ =>
      }
    }
    val tm = typeParamMap(typeParams, reporter)
    val mScope = localTypeScope(tm.map, scope)
    var params = ISZ[AST.Param]()
    for (p <- sig.params) {
      val tOpt = typeHierarchy.typed(mScope, p.tipe, reporter)
      tOpt match {
        case Some(t) => params = params :+ p(tipe = p.tipe.typed(t))
        case _ => return None()
      }
    }
    val tOpt = typeHierarchy.typed(mScope, sig.returnType, reporter)
    tOpt match {
      case Some(t) => return Some(sig(params = params, returnType = sig.returnType.typed(t)))
      case _ => return None()
    }
  }


  def outlineMembers(isAbstract: B,
                     name: QName,
                     info: TypeInfo.Members,
                     scope: Scope,
                     reporter: Reporter): TypeInfo.Members = {
    var specVars = HashMap.empty[String, (QName, AST.Stmt.SpecVar)]
    var vars = HashMap.empty[String, (QName, AST.Stmt.Var)]
    var specMethods = HashMap.empty[String, (QName, AST.Stmt.SpecMethod)]
    var methods = HashMap.empty[String, (QName, AST.Stmt.Method)]

    def isDeclared(id: String): B = {
      return specVars.contains(id) || vars.contains(id) || specMethods.contains(id) || methods.contains(id)
    }

    def checkSpecVar(sv: AST.Stmt.SpecVar): Unit = {
      val id = sv.id.value
      if (isDeclared(id)) {
        reporter.error(sv.attr.posOpt, TypeChecker.typeCheckerKind,
          s"Cannot redeclare $id.")
        return
      }
      val tOpt = typeHierarchy.typed(scope, sv.tipe, reporter)
      tOpt match {
        case Some(t) => specVars = specVars.put(id, (name, sv(tipe = sv.tipe.typed(t))))
        case _ =>
      }
    }

    def checkVar(v: AST.Stmt.Var): Unit = {
      val id = v.id.value
      if (isDeclared(id)) {
        reporter.error(v.attr.posOpt, TypeChecker.typeCheckerKind,
          s"Cannot redeclare $id.")
        return
      }
      val tpe = v.tipeOpt.get
      val tOpt = typeHierarchy.typed(scope, tpe, reporter)
      tOpt match {
        case Some(t) =>
          vars = vars.put(id, (name, v(tipeOpt = Some(tpe.typed(t)))))
        case _ =>
      }
    }

    def checkSpecMethod(sm: AST.Stmt.SpecMethod): Unit = {
      val id = sm.sig.id.value
      if (isDeclared(id)) {
        reporter.error(sm.sig.id.attr.posOpt, TypeChecker.typeCheckerKind,
          s"Cannot redeclare $id.")
        return
      }
      val sigOpt = outlineMethodSig(scope, sm.sig, reporter)
      sigOpt match {
        case Some(sig) => specMethods = specMethods.put(id, (name, sm(sig = sig)))
        case _ =>
      }
    }

    def checkMethod(m: AST.Stmt.Method): Unit = {
      val id = m.sig.id.value
      if (isDeclared(id)) {
        reporter.error(m.sig.id.attr.posOpt, TypeChecker.typeCheckerKind,
          s"Cannot redeclare $id.")
        return
      }
      val sigOpt = outlineMethodSig(scope, m.sig, reporter)
      sigOpt match {
        case Some(sig) => methods = methods.put(id, (name, m(sig = sig)))
        case _ =>
      }
    }

    for (p <- specVars.values) {
      checkSpecVar(p._2)
    }

    for (p <- vars.values) {
      checkVar(p._2)
    }

    for (p <- specMethods.values) {
      checkSpecMethod(p._2)
    }

    for (p <- methods.values) {
      checkMethod(p._2)
    }

    return TypeInfo.Members(specVars, vars, specMethods, methods)
  }

  def outlineInheritedMembers(name: QName,
                              parents: ISZ[AST.Type.Named],
                              scope: Scope,
                              info: TypeInfo.Members,
                              reporter: Reporter): TypeInfo.Members = {
    var specVars = info.specVars
    var vars = info.vars
    var specMethods = info.specMethods
    var methods = info.methods

    def checkSpecInherit(id: String, tname: QName, posOpt: Option[AST.PosInfo]): B = {
      specVars.get(id) match {
        case Some((owner, _)) =>
          if (name != tname) {
            reporter.error(posOpt, TypeChecker.typeCheckerKind,
              st"Cannot inherit $id because it has been previously inherited from ${(owner, ".")}.".render)
          } else {
            reporter.error(posOpt, TypeChecker.typeCheckerKind,
              s"Cannot inherit $id because it has been previously declared.")
          }
          return F
        case _ =>
      }
      specMethods.get(id) match {
        case Some((owner, _)) =>
          if (name != tname) {
            reporter.error(posOpt, TypeChecker.typeCheckerKind,
              st"Cannot inherit $id because it has been previously inherited from ${(owner, ".")}.".render)
          } else {
            reporter.error(posOpt, TypeChecker.typeCheckerKind,
              s"Cannot inherit $id because it has been previously declared.")
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
        case Some((owner, _)) =>
          if (name != tname) {
            reporter.error(posOpt, TypeChecker.typeCheckerKind,
              st"Cannot inherit $id because it has been previously inherited from ${(owner, ".")}.".render)
          } else {
            reporter.error(posOpt, TypeChecker.typeCheckerKind,
              s"Cannot inherit $id because it has been previously declared.")
          }
          return F
        case _ =>
      }
      methods.get(id) match {
        case Some((owner, _)) =>
          if (name != tname) {
            reporter.error(posOpt, TypeChecker.typeCheckerKind,
              st"Cannot inherit $id because it has been previously inherited from ${(owner, ".")}.".render)
          } else {
            reporter.error(posOpt, TypeChecker.typeCheckerKind,
              s"Cannot inherit $id because it has been previously declared.")
          }
          return F
        case _ =>
      }
      return T
    }

    def inheritSpecVar(p: (QName, AST.Stmt.SpecVar),
                       posOpt: Option[AST.PosInfo],
                       substMap: HashMap[String, AST.Typed]): Unit = {
      val owner = p._1
      var sv = p._2
      val id = sv.id.value
      val ok = checkInherit(id, owner, posOpt)
      if (ok) {
        if (substMap.isEmpty) {
          specVars = specVars.put(id, p)
        } else {
          up(sv.tipe) = sv.tipe.typed(TypeChecker.substType(substMap, sv.tipe.typedOpt.get))
          specVars = specVars.put(id, (owner, sv))
        }
      }
    }

    def inheritVar(p: (QName, AST.Stmt.Var),
                   posOpt: Option[AST.PosInfo],
                   substMap: HashMap[String, AST.Typed]): Unit = {
      val owner = p._1
      var v = p._2
      val id = v.id.value
      val ok = checkInherit(id, owner, posOpt)
      if (ok) {
        if (substMap.isEmpty) {
          vars = vars.put(id, p)
        } else {
          up(v.tipeOpt) = Some(v.tipeOpt.get.typed(TypeChecker.substType(substMap, v.tipeOpt.get.typedOpt.get)))
          vars = vars.put(id, (owner, v))
        }
      }
    }

    def inheritSpecMethod(p: (QName, AST.Stmt.SpecMethod),
                          posOpt: Option[AST.PosInfo],
                          substMap: HashMap[String, AST.Typed]): Unit = {
      val owner = p._1
      var sm = p._2
      val id = sm.sig.id.value
      val ok = checkInherit(id, owner, posOpt)
      if (ok) {
        if (substMap.isEmpty) {
          specMethods = specMethods.put(id, p)
        } else {
          var params = ISZ[AST.Param]()
          for (param <- sm.sig.params) {
            var prm = param
            up(prm.tipe) = prm.tipe.typed(TypeChecker.substType(substMap, prm.tipe.typedOpt.get))
            params = params :+ prm
          }
          up(sm.sig.params) = params
          up(sm.sig.returnType) = sm.sig.returnType.typed(TypeChecker.substType(substMap, sm.sig.returnType.typedOpt.get))
          specMethods = specMethods.put(id, (owner, sm))
        }
      }
    }

    def checkMethodEquality(m1: AST.Stmt.Method,
                            m2: AST.Stmt.Method,
                            substMap: HashMap[String, AST.Typed],
                            posOpt: Option[AST.PosInfo]): B = {
      val t1 = typeHierarchy.dealias(TypeChecker.extractMethodType(
        m1.purity != AST.Purity.Impure, m1.sig), posOpt, reporter)
      val t2 = typeHierarchy.dealias(TypeChecker.substType(substMap,
        TypeChecker.extractMethodType(m1.purity != AST.Purity.Impure, m2.sig)), posOpt, reporter)
      return TypeChecker.isEqType(t1, t2)
    }

    def checkMethodRefinement(m: AST.Stmt.Method,
                              supM: AST.Stmt.Method,
                              substMap: HashMap[String, AST.Typed],
                              posOpt: Option[AST.PosInfo]): B = {
      val t1 = typeHierarchy.dealias(TypeChecker.extractMethodType(m.purity != AST.Purity.Impure, m.sig), posOpt, reporter)
      val t2 = typeHierarchy.dealias(TypeChecker.substType(substMap,
        TypeChecker.extractMethodType(supM.purity != AST.Purity.Impure, supM.sig)), posOpt, reporter)
      return typeHierarchy.isRefinement(t1, t2)
    }

    def checkVarRefinement(m: AST.Stmt.Method,
                           v: AST.Stmt.Var,
                           substMap: HashMap[String, AST.Typed],
                           posOpt: Option[AST.PosInfo]): B = {
      if (m.sig.typeParams.nonEmpty) {
        return F
      }
      if (m.sig.hasParams || m.sig.params.nonEmpty) {
        return F
      }
      val rt = typeHierarchy.dealias(TypeChecker.substType(substMap, m.sig.returnType.typedOpt.get), posOpt, reporter)
      val t = typeHierarchy.dealias(v.tipeOpt.get.typedOpt.get, posOpt, reporter)
      val r = typeHierarchy.isSubType(t, rt)
      return r
    }

    def inheritMethod(p: (QName, AST.Stmt.Method),
                      posOpt: Option[AST.PosInfo],
                      substMap: HashMap[String, AST.Typed]): Unit = {
      val tname = p._1
      val pm = p._2
      val id = pm.sig.id.value

      var ok = checkSpecInherit(id, tname, posOpt)
      if (!ok) {
        return
      }
      vars.get(id) match {
        case Some((owner, _)) =>
          if (name != tname) {
            reporter.error(posOpt, TypeChecker.typeCheckerKind,
              st"Cannot inherit $id because it has been previously inherited from ${(owner, ".")}.".render)
          } else {
            reporter.error(posOpt, TypeChecker.typeCheckerKind,
              s"Cannot inherit $id because it has been previously declared.")
          }
          return
        case _ =>
      }
      methods.get(id) match {
        case Some((owner, m)) =>
          if (name != tname) {
            ok = checkMethodEquality(m, pm, substMap, posOpt)
            if (!ok) {
              reporter.error(posOpt, TypeChecker.typeCheckerKind,
                st"Cannot inherit $id because it has been previously inherited from ${(owner, ".")} with differing type.".render)
              return
            }
            if (pm.bodyOpt.nonEmpty) {
              if (m.bodyOpt.nonEmpty) {
                reporter.error(posOpt, TypeChecker.typeCheckerKind,
                  st"Cannot inherit $id because it has been previously inherited from ${(owner, ".")} with their own implementation.".render)
                return
              } else {
                methods = methods.put(id, p)
              }
            }
          } else {
            ok = checkMethodRefinement(m, pm, substMap, posOpt)
            if (!ok) {
              reporter.error(posOpt, TypeChecker.typeCheckerKind,
                s"Cannot inherit $id because it has been previously declared with incompatible type.")
              return
            }
            if (pm.bodyOpt.nonEmpty && m.bodyOpt.isEmpty) {
              reporter.error(posOpt, TypeChecker.typeCheckerKind,
                s"Cannot inherit $id with implementation because it has been previously declared but unimplemented.")
              return
            }
          }
        case _ =>
          vars.get(id) match {
            case Some((_, v)) =>
              ok = checkVarRefinement(pm, v, substMap, posOpt)
              if (!ok) {
                reporter.error(posOpt, TypeChecker.typeCheckerKind,
                  s"Cannot inherit $id because it has been previously declared with incompatible type.")
                return
              }
            case _ =>
              if (substMap.isEmpty) {
                methods = methods.put(id, p)
              } else {
                var m = pm
                var params = ISZ[AST.Param]()
                for (param <- m.sig.params) {
                  var prm = param
                  up(prm.tipe) = prm.tipe.typed(TypeChecker.substType(substMap, prm.tipe.typedOpt.get))
                  params = params :+ prm
                }
                up(m.sig.params) = params
                up(m.sig.returnType) = m.sig.returnType.typed(TypeChecker.substType(substMap, m.sig.returnType.typedOpt.get))
                methods = methods.put(id, (tname, m))
              }
          }
      }
    }

    for (parent <- parents) {
      val tOpt = typeHierarchy.typed(scope, parent, reporter)
      tOpt match {
        case Some(t: AST.Typed.Name) =>
          val dt = typeHierarchy.dealias(t, parent.attr.posOpt, reporter)
          dt match {
            case dt: AST.Typed.Name =>
              typeHierarchy.typeMap.get(dt.ids) match {
                case Some(ti: TypeInfo.Sig) =>
                  val substMapOpt = TypeChecker.buildSubstMap(ti.name, parent.posOpt, ti.ast.typeParams, dt.args, reporter)
                  substMapOpt match {
                    case Some(substMap) =>
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
                  val substMapOpt = TypeChecker.buildSubstMap(ti.name, parent.posOpt, ti.ast.typeParams, dt.args, reporter)
                  substMapOpt match {
                    case Some(substMap) =>
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
            case _ => halt("Infeasible: type hierarchy phase should have checked type parents should be a @sig, @msig, @datatype, @record, or @rich.")
          }
        case _ => halt("Infeasible: type hierarchy phase should have checked type parents should be a typed name.")
      }
    }
    return TypeInfo.Members(specVars, vars, specMethods, methods)
  }

}
