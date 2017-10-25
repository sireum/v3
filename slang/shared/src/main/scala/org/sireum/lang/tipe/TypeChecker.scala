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
  val errType: AST.Typed = AST.Typed.Name(ISZ(), ISZ(), None())

  @datatype class TypeConstructor(parameters: ISZ[String],
                                  tipe: AST.Typed) {
    def construct(args: Map[String, AST.Typed]): AST.Typed = {
      var m = HashMap.empty[String, AST.Typed]
      for (p <- parameters) {
        args.get(p) match {
          case Some(argType) =>
            m = m.put(p, argType)
          case _ =>
            halt(s"Could not find argument for type parameter '$p'.")
        }
      }
      return substType(m, tipe)
    }
  }

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
            reporter.error(t.posOpt, typeCheckerKind, st"Could not find a type named ${(name, ".")}.".render)
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

  @memoize def applyType(isSpec: B,
                         fqName: QName,
                         typeArgs: Map[String, AST.Typed],
                         argTypes: ISZ[AST.Typed]): (AST.Typed, AccumulatingReporter) = {
    halt("TODO")
  }

  @memoize def applyTypeNamed(isSpec: B,
                              fqName: QName,
                              typeArgs: Map[String, AST.Typed],
                              argTypes: Map[String, AST.Typed]): (AST.Typed, AccumulatingReporter) = {
    halt("TODO")
  }

  @memoize def typeOfGlobalName(isSpec: B,
                                fqName: QName,
                                typeArgs: Map[String, AST.Typed]): (TypeConstructor, AccumulatingReporter) = {
    halt("TODO")
  }

  @memoize def memberType(isSpec: B,
                          fqName: QName,
                          typeArgs: Map[String, AST.Typed],
                          member: String,
                          memberTypeArgs: Map[String, AST.Typed]): (TypeConstructor, AccumulatingReporter) = {
    halt("TODO")
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

  def checkVarType(typeParams: ISZ[AST.TypeParam],
                   info: Info.Var,
                   reporter: Reporter): Info.Var = {
    var r = info
    r.ast.tipeOpt match {
      case Some(t) =>
        val tm = typeParamMap(typeParams, reporter)
        val scope = localTypeScope(tm.map, r.scope)
        val typedOpt = typeCheck(scope, t, reporter)
        typedOpt match {
          case Some(typed) =>
            up(r.ast.tipeOpt) = Some(t.typed(typed))
            return r
          case _ =>
        }
      case _ =>
    }
    return r
  }

  def checkSpecVarType(typeParams: ISZ[AST.TypeParam],
                       info: Info.SpecVar,
                       reporter: Reporter): Info.SpecVar = {
    var r = info
    val tm = typeParamMap(typeParams, reporter)
    val scope = localTypeScope(tm.map, info.scope)
    val typedOpt = typeCheck(scope, r.ast.tipe, reporter)
    typedOpt match {
      case Some(typed) =>
        up(r.ast.tipe) = r.ast.tipe.typed(typed)
        return r
      case _ =>
    }
    return r
  }

  def checkMethodSigType(typeParams: ISZ[AST.TypeParam],
                         sigScope: Scope,
                         sig: AST.MethodSig,
                         reporter: Reporter): Option[AST.MethodSig] = {
    var tm = typeParamMap(typeParams, reporter)
    tm = typeParamMapInit(sig.typeParams, tm, reporter)
    val scope = localTypeScope(tm.map, sigScope)
    val retOpt = typeCheck(scope, sig.returnType, reporter)
    var hasError = retOpt.isEmpty
    var params = ISZ[AST.Param]()
    for (p <- sig.params) {
      val tOpt = typeCheck(scope, p.tipe, reporter)
      tOpt match {
        case Some(t) => params = params :+ p(tipe = p.tipe.typed(t))
        case _ => hasError = T
      }
    }
    if (hasError) {
      return None()
    }
    return Some(sig(params = params, returnType = sig.returnType.typed(retOpt.get)))
  }

  def checkSpecMethodType(typeParams: ISZ[AST.TypeParam],
                          info: Info.SpecMethod,
                          reporter: Reporter): Info.SpecMethod = {
    var r = info
    val sigOpt = checkMethodSigType(typeParams, info.scope, info.ast.sig, reporter)
    sigOpt match {
      case Some(sig) => up(r.ast.sig) = sig
      case _ =>
    }
    return r
  }

  def checkExtMethodType(typeParams: ISZ[AST.TypeParam],
                         info: Info.ExtMethod,
                         reporter: Reporter): Info.ExtMethod = {
    var r = info
    val sigOpt = checkMethodSigType(typeParams, info.scope, info.ast.sig, reporter)
    sigOpt match {
      case Some(sig) => up(r.ast.sig) = sig
      case _ =>
    }
    return r
  }

  def checkMethodType(typeParams: ISZ[AST.TypeParam],
                      info: Info.Method,
                      reporter: Reporter): Info.Method = {
    var r = info
    val sigOpt = checkMethodSigType(typeParams, info.scope, info.ast.sig, reporter)
    sigOpt match {
      case Some(sig) => up(r.ast.sig) = sig
      case _ =>
    }
    return r
  }

  @pure def checkObjectOutline(ast: Info.Object): TypeChecker => (TypeChecker, AccumulatingReporter) = {
    halt("TODO")
  }

  @pure def checkSigOutline(info: TypeInfo.Sig): TypeChecker => (TypeChecker, AccumulatingReporter) = {
    val reporter = AccumulatingReporter.create
    var tm = typeParamMap(info.ast.typeParams, reporter)
    val scope = localTypeScope(tm.map, info.scope)
    var members = checkMembersOutline(
      TypeInfo.Members(info.specVars, HashMap.empty, info.specMethods, info.methods), scope, reporter)
    members = inheritMembersOutline(info.name, info.ast.parents, scope, members, reporter)
    halt("TODO")
  }

  @pure def checkAdtOutline(info: TypeInfo.AbstractDatatype): TypeChecker => (TypeChecker, AccumulatingReporter) = {
    val reporter = AccumulatingReporter.create
    var tm = typeParamMap(info.ast.typeParams, reporter)
    val scope = localTypeScope(tm.map, info.scope)
    var members = checkMembersOutline(
      TypeInfo.Members(info.specVars, info.vars, info.specMethods, info.methods), scope, reporter)
    members = inheritMembersOutline(info.name, info.ast.parents, scope, members, reporter)
    halt("TODO")
  }

  @pure def checkRichOutline(info: TypeInfo.Rich): TypeChecker => (TypeChecker, AccumulatingReporter) = {
    val reporter = AccumulatingReporter.create
    var tm = typeParamMap(info.ast.typeParams, reporter)
    val scope = localTypeScope(tm.map, info.scope)
    var members = checkMembersOutline(
      TypeInfo.Members(HashMap.empty, HashMap.empty, info.specMethods, info.methods), scope, reporter)
    members = inheritMembersOutline(info.name, info.ast.parents, scope, members, reporter)
    halt("TODO")
  }

  def checkMembersOutline(info: TypeInfo.Members, scope: Scope, reporter: Reporter): TypeInfo.Members = {
    halt("TODO")
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
    var parentImplMethods = HashSet.empty[String]

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

    @pure def extractMethodType(m: AST.MethodSig): AST.Typed.Fun = {
      var map = HashMap.empty[String, Z]
      def deBruijn(t: AST.Typed): AST.Typed = {
        t match {
          case t: AST.Typed.Name =>
            if (t.args.nonEmpty) {
              var args = ISZ[AST.Typed]()
              for (arg <- t.args) {
                val ta = deBruijn(arg)
                args = args :+ ta
              }
              return t(args = args)
            } else if (t.ids.size == 1 && isTypeParamName(t.ids(0).value)) {
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
              val ta = deBruijn(arg)
              args = args :+ ta
            }
            return t(args = args)
          case t: AST.Typed.Fun =>
            var args = ISZ[AST.Typed]()
            for (arg <- t.args) {
              val ta = deBruijn(arg)
              args = args :+ ta
            }
            val tr = deBruijn(t.ret)
            return t(args = args, ret = tr)
        }
      }
      var pts = ISZ[AST.Typed]()
      for (p <- m.params) {
        val t = deBruijn(p.tipe.typedOpt.get)
        pts = pts :+ t
      }
      val t = deBruijn(m.returnType.typedOpt.get)
      return AST.Typed.Fun(pts, t, m.id.attr.posOpt)
    }

    def checkMethodEquality(m1: AST.Stmt.Method,
                            m2: AST.Stmt.Method,
                            substMap: HashMap[String, AST.Typed],
                            posOpt: Option[AST.PosInfo]): B = {
      val t1 = dealias(extractMethodType(m1.sig), posOpt, reporter)
      val t2 = dealias(substType(substMap, extractMethodType(m2.sig)), posOpt, reporter)
      return isEqType(t1, t2)
    }

    def checkMethodCompatibility(m: AST.Stmt.Method,
                                 supM: AST.Stmt.Method,
                                 substMap: HashMap[String, AST.Typed],
                                 posOpt: Option[AST.PosInfo]): B = {
      val t1 = dealias(extractMethodType(m.sig), posOpt, reporter)
      val t2 = dealias(substType(substMap, extractMethodType(supM.sig)), posOpt, reporter)
      return isRefinement(t1, t2)
    }

    def checkVarCompatibility(m: AST.Stmt.Method,
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
            ok = checkMethodCompatibility(m, pm, substMap, posOpt)
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
              ok = checkVarCompatibility(pm, v, substMap, posOpt)
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

  @pure def checkScript(program: AST.TopUnit.Program): TypeChecker => (TypeChecker, AccumulatingReporter) = {
    halt("TODO")
  }

}
