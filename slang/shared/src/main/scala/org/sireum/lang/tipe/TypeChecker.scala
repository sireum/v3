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
  val typeCheckerKind: String = "Type Checker"
  val unitType: AST.Typed.Tuple = AST.Typed.Tuple(ISZ(), None())
  val errType: AST.Typed = AST.Typed.Name(ISZ(), ISZ(), None())

  @pure def substType(m: HashMap[String, AST.Typed], t: AST.Typed): AST.Typed = {
    t match {
      case t: AST.Typed.Name =>
        if (t.ids.size == 1 && t.args.isEmpty) {
          m.get(t.ids(0)) match {
            case Some(t2) => return t2
            case _ =>
          }
        }
        return t(args = t.args.map((ta: AST.Typed) => substType(m, ta)))
      case t: AST.Typed.Tuple => return t(args = t.args.map((ta: AST.Typed) => substType(m, ta)))
      case t: AST.Typed.Fun => return t(args = t.args.map((ta: AST.Typed) => substType(m, ta)), ret = substType(m, t.ret))
    }
  }

  def buildSubstMap(name: QName,
                    posOpt: Option[AST.PosInfo],
                    typeParams: ISZ[AST.TypeParam],
                    args: ISZ[AST.Typed],
                    reporter: Reporter): Option[HashMap[String, AST.Typed]] = {
    if (typeParams.size != args.size) {
      reporter.error(posOpt, typeCheckerKind, st"Type ${(name, ".")} requires ${typeParams.size} type arguments, but only ${args.size} is supplied.".render)
      return None()
    }
    var substMap = HashMap.empty[String, AST.Typed]
    for (i <- 0 until args.size) {
      substMap = substMap.put(typeParamName(typeParams(i)), args(i))
    }
    return Some(substMap)
  }

  @pure def isEqType(t1: AST.Typed, t2: AST.Typed): B = {
    (t1, t2) match {
      case (t1: AST.Typed.Name, t2: AST.Typed.Name) =>
        if (t1.args.size != t2.args.size) {
          return F
        }
        if (t1.ids != t2.ids) {
          return F
        }
        for (i <- 0 until t1.args.size) {
          if (!isEqType(t1.args(i), t2.args(i))) {
            return F
          }
        }
        return T
      case (t1: AST.Typed.Tuple, t2: AST.Typed.Tuple) =>
        if (t1.args.size != t2.args.size) {
          return F
        }
        for (i <- 0 until t1.args.size) {
          if (!isEqType(t1.args(i), t2.args(i))) {
            return F
          }
        }
        return T
      case (t1: AST.Typed.Fun, t2: AST.Typed.Fun) =>
        if (t1.args.size != t2.args.size) {
          return F
        }
        if (!isEqType(t1.ret, t2.ret)) {
          return F
        }
        for (i <- 0 until t1.args.size) {
          if (!isEqType(t1.args(i), t2.args(i))) {
            return F
          }
        }
        return T
      case _ => return F
    }
  }

  @pure def deBruijn(t: AST.Typed): AST.Typed = {
    var map = HashMap.empty[String, Z]

    def db(t: AST.Typed): AST.Typed = {
      t match {
        case t: AST.Typed.Name =>
          if (t.args.nonEmpty) {
            var args = ISZ[AST.Typed]()
            for (arg <- t.args) {
              val ta = db(arg)
              args = args :+ ta
            }
            return t(args = args)
          } else if (t.ids.size == 1 && isTypeParamNameString(t.ids(0).value)) {
            val k = t.ids(0).value
            val i: Z = map.get(k) match {
              case Some(n) => n
              case _ =>
                val n = map.size
                map = map.put(k, n)
                n
            }
            return t(ids = ISZ(typeParamNameString(s"!$i")))
          } else {
            return t
          }
        case t: AST.Typed.Tuple =>
          var args = ISZ[AST.Typed]()
          for (arg <- t.args) {
            val ta = db(arg)
            args = args :+ ta
          }
          return t(args = args)
        case t: AST.Typed.Fun =>
          var args = ISZ[AST.Typed]()
          for (arg <- t.args) {
            val ta = db(arg)
            args = args :+ ta
          }
          val tr = db(t.ret)
          return t(args = args, ret = tr)
      }
    }

    val r = db(t)
    return r
  }

  @pure def extractMethodType(m: AST.MethodSig): AST.Typed.Fun = {
    var pts = ISZ[AST.Typed]()
    for (p <- m.params) {
      pts = pts :+ p.tipe.typedOpt.get
    }
    val t = deBruijn(AST.Typed.Fun(pts, m.returnType.typedOpt.get, m.id.attr.posOpt))
    t match {
      case t: AST.Typed.Fun => return t
      case _ => halt("Infeasible")
    }
  }
}

import TypeChecker._

@datatype class TypeChecker(globalNameMap: NameMap,
                            globalTypeMap: TypeMap,
                            typeHierarchy: TypeHierarchy.Type) {

  def typeCheck(scope: Scope,
                t: AST.Type,
                reporter: Reporter): Option[AST.Typed] = {
    t match {
      case t: AST.Type.Named =>
        var argTypes = ISZ[AST.Typed]()
        var hasError = F
        for (arg <- t.typeArgs) {
          val targOpt = typeCheck(scope, arg, reporter)
          targOpt match {
            case Some(targ) => argTypes = argTypes :+ targ
            case _ => hasError = T
          }
        }
        if (hasError) {
          return None[AST.Typed]()
        }
        val name = AST.Util.ids2strings(t.name.ids)
        scope.resolveType(globalTypeMap, name) match {
          case Some(ti: TypeInfo.TypeAlias) =>
            val tparamSize = ti.ast.typeParams.size
            if (argTypes.size != tparamSize) {
              reporter.error(t.posOpt, typeCheckerKind,
                st"Type alias ${(name, ".")} requires $tparamSize type arguments but ${argTypes.size} supplied.".render)
              return None()
            }
            return Some(AST.Typed.Name(ti.name, argTypes, t.posOpt))
          case Some(ti: TypeInfo.TypeVar) =>
            if (argTypes.nonEmpty) {
              reporter.error(t.posOpt, typeCheckerKind,
                s"Type variable ${name(0)} does not accept type arguments.")
              return None()
            }
            return Some(AST.Typed.Name(ti.name, argTypes, t.posOpt))
          case Some(ti) =>
            val p: (String, Z) = ti match {
              case ti: TypeInfo.SubZ => (if (ti.ast.isBitVector) "@bits" else "@range", 0)
              case _: TypeInfo.Enum => ("@enum", 0)
              case ti: TypeInfo.Sig => (if (ti.ast.isExt) "@ext" else if (ti.ast.isImmutable) "@sig" else "@msig", ti.ast.typeParams.size)
              case ti: TypeInfo.AbstractDatatype => (if (ti.ast.isDatatype) "@datatype" else "@record", ti.ast.typeParams.size)
              case ti: TypeInfo.Rich => ("@rich", ti.ast.typeParams.size)
              case _ => halt("Infeasible")
            }
            if (argTypes.size != p._2) {
              if (p._2 == 0) {
                reporter.error(t.posOpt, typeCheckerKind,
                  st"Slang ${p._1} ${(name, ".")} does not accept type arguments.".render)
              } else {
                reporter.error(t.posOpt, typeCheckerKind,
                  st"Slang ${p._1} ${(name, ".")} requires ${p._2} type arguments but ${argTypes.size} is supplied.".render)
              }
              return None()
            }
            return Some(AST.Typed.Name(ti.name, argTypes, t.posOpt))
          case _ =>
            if (name.size == 1 && argTypes.isEmpty && name(0) == "Unit") {
              return Some(unitType)
            } else {
              reporter.error(t.posOpt, typeCheckerKind, st"Could not find a type named ${(name, ".")}.".render)
            }
            return None()
        }
      case t: AST.Type.Tuple =>
        var esTypes = ISZ[AST.Typed]()
        var hasError = F
        for (arg <- t.args) {
          val targOpt = typeCheck(scope, arg, reporter)
          targOpt match {
            case Some(targ) => esTypes = esTypes :+ targ
            case _ => hasError = T
          }
        }
        if (hasError) {
          return None[AST.Typed]()
        } else {
          return Some(AST.Typed.Tuple(esTypes, t.posOpt))
        }
      case t: AST.Type.Fun =>
        var paramTypes = ISZ[AST.Typed]()
        var hasError = F
        for (arg <- t.args) {
          val targOpt = typeCheck(scope, arg, reporter)
          targOpt match {
            case Some(targ) => paramTypes = paramTypes :+ targ
            case _ => hasError = T
          }
        }
        val trOpt = typeCheck(scope, t.ret, reporter)
        trOpt match {
          case Some(tr) if !hasError => return Some(AST.Typed.Fun(paramTypes, tr, t.posOpt))
          case _ => return None[AST.Typed]()
        }
    }
  }

  def applyTypeAlias(typed: AST.Typed.Name,
                     ti: TypeInfo.TypeAlias,
                     posOpt: Option[AST.PosInfo],
                     reporter: Reporter): Option[AST.Typed] = {
    val tm = typeParamMap(ti.ast.typeParams, reporter)
    val scope = localTypeScope(tm.map, ti.scope)
    val tOpt = typeCheck(scope, ti.ast.tipe, reporter)
    tOpt match {
      case Some(t) =>
        val substMapOpt = buildSubstMap(ti.name, posOpt, ti.ast.typeParams, typed.args, reporter)
        substMapOpt match {
          case Some(substMap) => return Some(substType(substMap, t))
          case _ => return None()
        }
      case _ => return tOpt
    }
  }

  def dealias(typed: AST.Typed, posOpt: Option[AST.PosInfo], reporter: Reporter): AST.Typed = {
    def dealiasOpt(t: AST.Typed): Option[AST.Typed] = {
      t match {
        case t: AST.Typed.Name =>
          var newArgs = ISZ[AST.Typed]()
          var changed = F
          for (arg <- t.args) {
            val newArgOpt = dealiasOpt(arg)
            newArgOpt match {
              case Some(newArg) =>
                newArgs = newArgs :+ newArg
                changed = T
              case _ => newArgs = newArgs :+ arg
            }
          }
          val typed2: AST.Typed.Name = if (changed) t(args = newArgs) else t
          globalTypeMap.get(t.ids) match {
            case Some(ti: TypeInfo.TypeAlias) =>
              val rOpt = applyTypeAlias(typed2, ti, posOpt, reporter)
              rOpt match {
                case Some(r) =>
                  val r2 = dealias(r, posOpt, reporter)
                  return Some(r2)
                case _ => return None()
              }
            case _ =>
              return if (changed) Some(typed2) else None()
          }
        case t: AST.Typed.Tuple =>
          var newArgs = ISZ[AST.Typed]()
          var changed = F
          for (arg <- t.args) {
            val newArgOpt = dealiasOpt(arg)
            newArgOpt match {
              case Some(newArg) =>
                newArgs = newArgs :+ newArg
                changed = T
              case _ =>
                newArgs = newArgs :+ arg
            }
          }
          return if (changed) Some(t(args = newArgs)) else None()
        case t: AST.Typed.Fun =>
          var newArgs = ISZ[AST.Typed]()
          var changed = F
          for (arg <- t.args) {
            val newArgOpt = dealiasOpt(arg)
            newArgOpt match {
              case Some(newArg) =>
                newArgs = newArgs :+ newArg
                changed = T
              case _ =>
                newArgs = newArgs :+ arg
            }
          }
          val newRetOpt = dealiasOpt(t.ret)
          val newRet = newRetOpt.getOrElse(t.ret)
          changed = changed || newRetOpt.nonEmpty
          return if (changed) Some(t(args = newArgs, ret = newRet)) else None()
      }
    }

    val rOpt = dealiasOpt(typed)
    return rOpt.getOrElse(typed)
  }

  @pure def isRefinement(t1: AST.Typed, t2: AST.Typed): B = {
    (t1, t2) match {
      case (t1: AST.Typed.Fun, t2: AST.Typed.Fun) =>
        if (t1.args.size != t2.args.size) {
          return F
        }
        for (i <- 0 until t1.args.size) {
          if (!isSubType(t2.args(i), t1.args(i))) {
            return F
          }
        }
        return isSubType(t1.ret, t2.ret)
      case _ => isSubType(t1, t2)
    }
  }

  @pure def isSubType(t1: AST.Typed, t2: AST.Typed): B = {
    (t1, t2) match {
      case (t1: AST.Typed.Name, t2: AST.Typed.Name) =>
        if (t1.args.size != t2.args.size) {
          return F
        }
        for (i <- 0 until t1.args.size) {
          if (!isEqType(t1.args(i), t2.args(i))) {
            return F
          }
        }
        if (t1.ids == t2.ids) {
          return T
        }
        return typeHierarchy.poset.ancestorsOf(t1).contains(t2)
      case _ => return isEqType(t1, t2)
    }
  }

  @pure def rootTypes(): ISZ[QName] = {
    var r = ISZ[QName]()
    for (p <- typeHierarchy.poset.parents.entries) {
      if (p._2.isEmpty) {
        r = r :+ p._1.ids
      }
    }
    return r
  }

  def checkOutline(reporter: Reporter): TypeChecker = {
    def combine(r: (TypeChecker, AccumulatingReporter),
                f: TypeChecker => (TypeChecker, AccumulatingReporter)): (TypeChecker, AccumulatingReporter) = {
      val p = f(r._1)
      return (p._1, AccumulatingReporter.combine(r._2, p._2))
    }

    def parentsOutlined(name: QName): B = {
      def isOutlined(name: QName): B = {
        globalTypeMap.get(name).get match {
          case ti: TypeInfo.Sig => return ti.outlined
          case ti: TypeInfo.AbstractDatatype => return ti.outlined
          case ti: TypeInfo.Rich => return ti.outlined
          case _ => return T
        }
      }

      var r = T
      for (p <- typeHierarchy.poset.parentsOf(AST.Typed.Name(name, ISZ(), None())).elements if r) {
        globalTypeMap.get(p.ids).get match {
          case ti: TypeInfo.TypeAlias =>
            val t = typeHierarchy.dealias(AST.Typed.Name(ti.name, ISZ(), None()), reporter).get
            r = isOutlined(t.ids)
          case ti =>
            r = isOutlined(ti.name)
        }
      }
      return r
    }

    // WORKAROUND: has to use B => TypeChecker => AccumulatingReporter instead of () => TypeChecker => AccumulatingReporter
    // due to issues in scalameta macro expansion
    var workList = rootTypes()
    var tc = this
    while (workList.nonEmpty) {
      var l = ISZ[QName]()
      var jobs = ISZ[B => TypeChecker => (TypeChecker, AccumulatingReporter)]()
      for (name <- workList) {
        val ti = tc.globalTypeMap.get(name).get
        ti match {
          case ti: TypeInfo.Sig if !ti.outlined =>
            val po = parentsOutlined(ti.name)
            if (po) {
              jobs = jobs :+ ((_: B) => tc.checkSigOutline(ti))
            }
          case ti: TypeInfo.AbstractDatatype if !ti.outlined =>
            val po = parentsOutlined(ti.name)
            if (po) {
              jobs = jobs :+ ((_: B) => tc.checkAdtOutline(ti))
            }
          case ti: TypeInfo.Rich if !ti.outlined =>
            val po = parentsOutlined(ti.name)
            if (po) {
              jobs = jobs :+ ((_: B) => tc.checkRichOutline(ti))
            }
          case _ =>
        }
        for (n <- typeHierarchy.poset.childrenOf(AST.Typed.Name(name, ISZ(), None())).elements) {
          l = l :+ n.ids
        }
      }
      val r = ISOps(jobs).
        parMapFoldLeft(
          (f: B => TypeChecker => (TypeChecker, AccumulatingReporter)) => f(T),
          combine _,
          (this, AccumulatingReporter.create))
      reporter.reports(r._2.messages)
      tc = r._1
      workList = l
    }
    var jobs = ISZ[B => TypeChecker => (TypeChecker, AccumulatingReporter)]()
    for (info <- tc.globalNameMap.values) {
      info match {
        case info: Info.Object => jobs = jobs :+ ((_: B) => tc.checkObjectOutline(info))
        case _ =>
      }
    }
    val r = ISOps(jobs).
      parMapFoldLeft(
        (f: B => TypeChecker => (TypeChecker, AccumulatingReporter)) => f(T),
        combine _,
        (this, AccumulatingReporter.create))
    reporter.reports(r._2.messages)
    return r._1
  }

  def checkSpecVarOutline(info: Info.SpecVar, reporter: Reporter): Option[Info] = {
    val sv = info.ast
    val id = sv.id.value
    val tOpt = typeCheck(info.scope, sv.tipe, reporter)
    tOpt match {
      case Some(t) => return Some(info(ast = sv(tipe = sv.tipe.typed(t))))
      case _ => return None()
    }
  }

  def checkVarOutline(info: Info.Var, reporter: Reporter): Option[Info] = {
    val v = info.ast
    val id = v.id.value
    val tpe = v.tipeOpt.get
    val tOpt = typeCheck(info.scope, tpe, reporter)
    tOpt match {
      case Some(t) => return Some(info(ast = v(tipeOpt = Some(tpe.typed(t)))))
      case _ => return None()
    }
  }

  def checkSpecMethodOutline(info: Info.SpecMethod, reporter: Reporter): Option[Info] = {
    val sm = info.ast
    val id = sm.sig.id.value
    val sigOpt = checkMethodSigOutline(info.scope, sm.sig, reporter)
    sigOpt match {
      case Some(sig) => return Some(info(ast = sm(sig = sig)))
      case _ => return None()
    }
  }

  def checkMethodOutline(info: Info.Method, reporter: Reporter): Option[Info] = {
    val m = info.ast
    val id = m.sig.id.value
    val sigOpt = checkMethodSigOutline(info.scope, m.sig, reporter)
    sigOpt match {
      case Some(sig) => return Some(info(ast = m(sig = sig)))
      case _ => return None()
    }
  }

  @pure def checkObjectOutline(info: Info.Object): TypeChecker => (TypeChecker, AccumulatingReporter) = {
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
          val infoOpt: Option[Info] = globalNameMap.get(info.name :+ id).get match {
            case inf: Info.SpecVar => val rOpt = checkSpecVarOutline(inf, reporter); rOpt
            case inf: Info.Var => val rOpt = checkVarOutline(inf, reporter); rOpt
            case inf: Info.SpecMethod => val rOpt = checkSpecMethodOutline(inf, reporter); rOpt
            case inf: Info.Method => val rOpt = checkMethodOutline(inf, reporter); rOpt
            case _ => None()
          }
          infoOpt match {
            case Some(inf) => infos = infos :+ ((inf.name, inf))
            case _ =>
          }
        case _ =>
      }
    }

    return (tc: TypeChecker) => (tc(globalNameMap = tc.globalNameMap.putAll(infos)), reporter)
  }

  @pure def checkSigOutline(info: TypeInfo.Sig): TypeChecker => (TypeChecker, AccumulatingReporter) = {
    val reporter = AccumulatingReporter.create
    var tm = typeParamMap(info.ast.typeParams, reporter)
    val scope = localTypeScope(tm.map, info.scope)
    var members = checkMembersOutline(T, info.name,
      TypeInfo.Members(info.specVars, HashMap.empty, info.specMethods, info.methods), scope, reporter)
    members = inheritMembersOutline(info.name, info.ast.parents, scope, members, reporter)
    val specVars = members.specVars
    val specMethods = members.specMethods
    val methods = members.methods
    return (tc: TypeChecker) =>
      (tc(globalTypeMap =
        tc.globalTypeMap.put(info.name,
          info(specVars = specVars, specMethods = specMethods, methods = methods))), reporter)
  }

  @pure def checkAdtOutline(info: TypeInfo.AbstractDatatype): TypeChecker => (TypeChecker, AccumulatingReporter) = {
    val reporter = AccumulatingReporter.create
    var tm = typeParamMap(info.ast.typeParams, reporter)
    val scope = localTypeScope(tm.map, info.scope)
    var members = checkMembersOutline(info.ast.isRoot, info.name,
      TypeInfo.Members(info.specVars, info.vars, info.specMethods, info.methods), scope, reporter)
    members = inheritMembersOutline(info.name, info.ast.parents, scope, members, reporter)
    val specVars = members.specVars
    val vars = members.vars
    val specMethods = members.specMethods
    val methods = members.methods
    return (tc: TypeChecker) =>
      (tc(globalTypeMap =
        tc.globalTypeMap.put(info.name,
          info(specVars = specVars, vars = vars, specMethods = specMethods, methods = methods))), reporter)
  }

  @pure def checkRichOutline(info: TypeInfo.Rich): TypeChecker => (TypeChecker, AccumulatingReporter) = {
    val reporter = AccumulatingReporter.create
    var tm = typeParamMap(info.ast.typeParams, reporter)
    val scope = localTypeScope(tm.map, info.scope)
    var members = checkMembersOutline(info.ast.isRoot, info.name,
      TypeInfo.Members(HashMap.empty, HashMap.empty, info.specMethods, info.methods), scope, reporter)
    members = inheritMembersOutline(info.name, info.ast.parents, scope, members, reporter)
    val specMethods = members.specMethods
    val methods = members.methods
    return (tc: TypeChecker) =>
      (tc(globalTypeMap =
        tc.globalTypeMap.put(info.name,
          info(specMethods = specMethods, methods = methods))), reporter)
  }

  def checkMethodSigOutline(scope: Scope,
                            sig: AST.MethodSig,
                            reporter: Reporter): Option[AST.MethodSig] = {
    val id = sig.id.value
    val typeParams = sig.typeParams
    for (tp <- typeParams) {
      scope.resolveType(globalTypeMap, ISZ(tp.id.value)) match {
        case Some(ti) if isTypeParamName(ti.name) =>
          reporter.error(tp.id.attr.posOpt, typeCheckerKind,
            s"Cannot redeclare type parameter $id.")
          return None()
        case _ =>
      }
    }
    var tm = typeParamMap(typeParams, reporter)
    val mScope = localTypeScope(tm.map, scope)
    var params = ISZ[AST.Param]()
    for (p <- sig.params) {
      var prm = p
      val tOpt = typeCheck(mScope, p.tipe, reporter)
      tOpt match {
        case Some(t) => params = params :+ p(tipe = p.tipe.typed(t))
        case _ => return None()
      }
    }
    val tOpt = typeCheck(mScope, sig.returnType, reporter)
    tOpt match {
      case Some(t) => return Some(sig(params = params, returnType = sig.returnType.typed(t)))
      case _ => return None()
    }
  }


  def checkMembersOutline(isAbstract: B,
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
        reporter.error(sv.attr.posOpt, typeCheckerKind,
          s"Cannot redeclare $id.")
        return
      }
      val tOpt = typeCheck(scope, sv.tipe, reporter)
      tOpt match {
        case Some(t) => specVars = specVars.put(id, (name, sv(tipe = sv.tipe.typed(t))))
        case _ =>
      }
    }

    def checkVar(v: AST.Stmt.Var): Unit = {
      val id = v.id.value
      if (isDeclared(id)) {
        reporter.error(v.attr.posOpt, typeCheckerKind,
          s"Cannot redeclare $id.")
        return
      }
      val tpe = v.tipeOpt.get
      val tOpt = typeCheck(scope, tpe, reporter)
      tOpt match {
        case Some(t) =>
          vars = vars.put(id, (name, v(tipeOpt = Some(tpe.typed(t)))))
        case _ =>
      }
    }

    def checkSpecMethod(sm: AST.Stmt.SpecMethod): Unit = {
      val id = sm.sig.id.value
      if (isDeclared(id)) {
        reporter.error(sm.sig.id.attr.posOpt, typeCheckerKind,
          s"Cannot redeclare $id.")
        return
      }
      val sigOpt = checkMethodSigOutline(scope, sm.sig, reporter)
      sigOpt match {
        case Some(sig) => specMethods = specMethods.put(id, (name, sm(sig = sig)))
        case _ =>
      }
    }

    def checkMethod(m: AST.Stmt.Method): Unit = {
      val id = m.sig.id.value
      if (isDeclared(id)) {
        reporter.error(m.sig.id.attr.posOpt, typeCheckerKind,
          s"Cannot redeclare $id.")
        return
      }
      val sigOpt = checkMethodSigOutline(scope, m.sig, reporter)
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

  def inheritMembersOutline(name: QName,
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
            reporter.error(posOpt, typeCheckerKind,
              st"Cannot inherit $id because it has been previously inherited from ${(owner, ".")}.".render)
          } else {
            reporter.error(posOpt, typeCheckerKind,
              s"Cannot inherit $id because it has been previously declared.")
          }
          return F
        case _ =>
      }
      specMethods.get(id) match {
        case Some((owner, _)) =>
          if (name != tname) {
            reporter.error(posOpt, typeCheckerKind,
              st"Cannot inherit $id because it has been previously inherited from ${(owner, ".")}.".render)
          } else {
            reporter.error(posOpt, typeCheckerKind,
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
            reporter.error(posOpt, typeCheckerKind,
              st"Cannot inherit $id because it has been previously inherited from ${(owner, ".")}.".render)
          } else {
            reporter.error(posOpt, typeCheckerKind,
              s"Cannot inherit $id because it has been previously declared.")
          }
          return F
        case _ =>
      }
      methods.get(id) match {
        case Some((owner, _)) =>
          if (name != tname) {
            reporter.error(posOpt, typeCheckerKind,
              st"Cannot inherit $id because it has been previously inherited from ${(owner, ".")}.".render)
          } else {
            reporter.error(posOpt, typeCheckerKind,
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
          up(sv.tipe) = sv.tipe.typed(substType(substMap, sv.tipe.typedOpt.get))
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
          up(v.tipeOpt) = Some(v.tipeOpt.get.typed(substType(substMap, v.tipeOpt.get.typedOpt.get)))
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
            up(prm.tipe) = prm.tipe.typed(substType(substMap, prm.tipe.typedOpt.get))
            params = params :+ prm
          }
          up(sm.sig.params) = params
          up(sm.sig.returnType) = sm.sig.returnType.typed(substType(substMap, sm.sig.returnType.typedOpt.get))
          specMethods = specMethods.put(id, (owner, sm))
        }
      }
    }

    def checkMethodEquality(m1: AST.Stmt.Method,
                            m2: AST.Stmt.Method,
                            substMap: HashMap[String, AST.Typed],
                            posOpt: Option[AST.PosInfo]): B = {
      val t1 = dealias(extractMethodType(m1.sig), posOpt, reporter)
      val t2 = dealias(substType(substMap, extractMethodType(m2.sig)), posOpt, reporter)
      return isEqType(t1, t2)
    }

    def checkMethodRefinement(m: AST.Stmt.Method,
                              supM: AST.Stmt.Method,
                              substMap: HashMap[String, AST.Typed],
                              posOpt: Option[AST.PosInfo]): B = {
      val t1 = dealias(extractMethodType(m.sig), posOpt, reporter)
      val t2 = dealias(substType(substMap, extractMethodType(supM.sig)), posOpt, reporter)
      return isRefinement(t1, t2)
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
      val rt = dealias(substType(substMap, m.sig.returnType.typedOpt.get), posOpt, reporter)
      val t = dealias(v.tipeOpt.get.typedOpt.get, posOpt, reporter)
      val r = isSubType(t, rt)
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
            reporter.error(posOpt, typeCheckerKind,
              st"Cannot inherit $id because it has been previously inherited from ${(owner, ".")}.".render)
          } else {
            reporter.error(posOpt, typeCheckerKind,
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
              reporter.error(posOpt, typeCheckerKind,
                st"Cannot inherit $id because it has been previously inherited from ${(owner, ".")} with differing type.".render)
              return
            }
            if (pm.bodyOpt.nonEmpty) {
              if (m.bodyOpt.nonEmpty) {
                reporter.error(posOpt, typeCheckerKind,
                  st"Cannot inherit $id because it has been previously inherited from ${(owner, ".")} with their own implementation.".render)
                return
              } else {
                methods = methods.put(id, p)
              }
            }
          } else {
            ok = checkMethodRefinement(m, pm, substMap, posOpt)
            if (!ok) {
              reporter.error(posOpt, typeCheckerKind,
                s"Cannot inherit $id because it has been previously declared with incompatible type.")
              return
            }
            if (pm.bodyOpt.nonEmpty && m.bodyOpt.isEmpty) {
              reporter.error(posOpt, typeCheckerKind,
                s"Cannot inherit $id with implementation because it has been previously declared but unimplemented.")
              return
            }
          }
        case _ =>
          vars.get(id) match {
            case Some((owner, v)) =>
              ok = checkVarRefinement(pm, v, substMap, posOpt)
              if (!ok) {
                reporter.error(posOpt, typeCheckerKind,
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
                  up(prm.tipe) = prm.tipe.typed(substType(substMap, prm.tipe.typedOpt.get))
                  params = params :+ prm
                }
                up(m.sig.params) = params
                up(m.sig.returnType) = m.sig.returnType.typed(substType(substMap, m.sig.returnType.typedOpt.get))
                methods = methods.put(id, (tname, m))
              }
          }
      }
    }

    for (parent <- parents) {
      val tOpt = typeCheck(scope, parent, reporter)
      tOpt match {
        case Some(t: AST.Typed.Name) =>
          val dt = dealias(t, parent.attr.posOpt, reporter)
          dt match {
            case dt: AST.Typed.Name =>
              globalTypeMap.get(dt.ids) match {
                case Some(ti: TypeInfo.Sig) =>
                  val substMapOpt = buildSubstMap(ti.name, parent.posOpt, ti.ast.typeParams, dt.args, reporter)
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
                  val substMapOpt = buildSubstMap(ti.name, parent.posOpt, ti.ast.typeParams, dt.args, reporter)
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
                case Some(ti: TypeInfo.Rich) =>
                  val substMapOpt = buildSubstMap(ti.name, parent.posOpt, ti.ast.typeParams, dt.args, reporter)
                  substMapOpt match {
                    case Some(substMap) =>
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

  @pure def checkProgram(program: AST.TopUnit.Program): TypeChecker => (TypeChecker, AccumulatingReporter) = {
    halt("TODO")
  }

}
