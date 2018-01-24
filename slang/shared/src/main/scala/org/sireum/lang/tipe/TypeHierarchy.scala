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
import org.sireum.lang.symbol.Resolver._
import org.sireum.lang.util._
import org.sireum.lang.{ast => AST}

object TypeHierarchy {

  @pure def typedInfo(info: TypeInfo): AST.Typed.Name = {
    @pure def typedParam(tp: AST.TypeParam): AST.Typed = {
      return AST.Typed.Name(ISZ(tp.id.value), ISZ(), tp.id.attr.posOpt)
    }

    info match {
      case info: TypeInfo.SubZ => return AST.Typed.Name(info.name, ISZ(), info.posOpt)
      case info: TypeInfo.Enum => return AST.Typed.Name(info.name :+ "Type", ISZ(), info.posOpt)
      case info: TypeInfo.Sig =>
        val args = info.ast.typeParams.map(typedParam)
        return AST.Typed.Name(info.name, args, info.posOpt)
      case info: TypeInfo.AbstractDatatype =>
        val args = info.ast.typeParams.map(typedParam)
        return AST.Typed.Name(info.name, args, info.posOpt)
      case info: TypeInfo.TypeAlias =>
        val args = info.ast.typeParams.map(typedParam)
        return AST.Typed.Name(info.name, args, info.posOpt)
      case _: TypeInfo.TypeVar => halt("Infeasible")
    }
  }

  def build(init: TypeHierarchy, reporter: Reporter): TypeHierarchy = {
    val typeMap = init.typeMap

    def resolveType(scope: Scope, t: AST.Type): AST.Typed = {
      t match {
        case t: AST.Type.Named =>
          var name = AST.Util.ids2strings(t.name.ids)
          scope.resolveType(typeMap, name) match {
            case Some(ti) => name = ti.name
            case _ => reporter.error(t.name.attr.posOpt, resolverKind, s"Could not resolve type named '${st"${(name, ".")}".render}'.")
          }
          val args: ISZ[AST.Typed] = {
            var as = ISZ[AST.Typed]()
            for (ta <- t.typeArgs) {
              val tas = resolveType(scope, ta)
              as = as :+ tas
            }
            as
          }
          AST.Typed.Name(name, args, t.posOpt)
        case t: AST.Type.Tuple =>
          val ts: ISZ[AST.Typed] = {
            var as = ISZ[AST.Typed]()
            for (a <- t.args) {
              val ta = resolveType(scope, a)
              as = as :+ ta
            }
            as
          }
          AST.Typed.Tuple(ts, t.posOpt)
        case t: AST.Type.Fun =>
          val ts: ISZ[AST.Typed] = {
            var as = ISZ[AST.Typed]()
            for (a <- t.args) {
              val ta = resolveType(scope, a)
              as = as :+ ta
            }
            as
          }
          val rt = resolveType(scope, t.ret)
          AST.Typed.Fun(t.isPure, t.isByName, ts, rt, t.posOpt)
      }
    }

    def resolveTypeNameds(posOpt: Option[AST.PosInfo],
                          scope: Scope,
                          ts: ISZ[AST.Type.Named]): ISZ[AST.Typed.Name] = {
      var r = ISZ[AST.Typed.Name]()
      for (t <- ts) {
        val typed = resolveType(scope, t)
        typed match {
          case typed: AST.Typed.Name => r = r :+ typed
          case _ => reporter.error(posOpt, resolverKind, "Expected a named type.")
        }
      }
      return r
    }

    val zName: QName = ISZ("org", "sireum", "Z")
    var r = init

    def resolveAlias(info: TypeInfo.TypeAlias, seen: HashSet[QName]): AST.Typed = {
      if (seen.contains(info.name)) {
        reporter.error(info.posOpt, resolverKind, st"Type alias ${(info.name, ".")} is cyclic.".render)
        return AST.Typed.Name(info.name, ISZ(), info.posOpt)
      }
      val typed = typedInfo(info)
      r.aliases.get(typed) match {
        case Some(rt) => return rt
        case _ =>
      }
      val scope = typeParamsScope(info.ast.typeParams, info.scope, reporter)
      val t = resolveType(scope, info.ast.tipe)
      t match {
        case t: AST.Typed.Name =>
          typeMap.get(t.ids) match {
            case Some(ti: TypeInfo.TypeAlias) => resolveAlias(ti, seen.add(info.name))
            case _ =>
          }
        case _ =>
      }
      up(r.aliases) = r.aliases.put(typed, t)
      return t
    }

    if (!typeMap.contains(zName)) {
      reporter.error(None(), resolverKind, "Could not find Z type.")
      return r
    }
    for (info <- typeMap.values) {
      info match {
        case _: TypeInfo.SubZ =>
          val typed = typedInfo(info)
          up(r.poset) = r.poset.addNode(typed)
        case _: TypeInfo.Enum =>
          val typed = typedInfo(info)
          up(r.poset) = r.poset.addNode(typed)
        case info: TypeInfo.Sig =>
          val typed = typedInfo(info)
          val scope = typeParamsScope(info.ast.typeParams, info.scope, reporter)
          val parents = resolveTypeNameds(info.posOpt, scope, info.ast.parents)
          up(r.poset) = r.poset.addParents(typed, parents)
        case info: TypeInfo.AbstractDatatype =>
          val typed = typedInfo(info)
          val scope = typeParamsScope(info.ast.typeParams, info.scope, reporter)
          val parents = resolveTypeNameds(info.posOpt, scope, info.ast.parents)
          up(r.poset) = r.poset.addParents(typed, parents)
        case info: TypeInfo.TypeAlias =>
          resolveAlias(info, HashSet.empty)
        case _: TypeInfo.TypeVar => halt("Infeasible")
      }
    }
    if (reporter.hasIssue) {
      return r
    }
    r.checkCyclic(reporter)
    return r
  }
}

@datatype class TypeHierarchy(nameMap: NameMap,
                              typeMap: TypeMap,
                              poset: Poset[AST.Typed.Name],
                              aliases: HashMap[AST.Typed.Name, AST.Typed]) {

  @pure def rootTypes: ISZ[AST.Typed.Name] = {
    var r = ISZ[AST.Typed.Name]()
    for (ps <- poset.parents.entries) {
      if (ps._2.isEmpty) {
        r = r :+ ps._1
      }
    }
    return r
  }

  @pure def rootTypeNames(): ISZ[QName] = {
    var r = ISZ[QName]()
    for (p <- poset.parents.entries) {
      if (p._2.isEmpty) {
        r = r :+ p._1.ids
      }
    }
    return r
  }


  def dealiasInit(t: AST.Typed.Name, reporter: Reporter): Option[AST.Typed.Name] = {
    aliases.get(t) match {
      case Some(t2: AST.Typed.Name) =>
        val r = dealiasInit(t2, reporter)
        return r
      case Some(_) =>
        reporter.error(None(), resolverKind, st"Expected a named type in type hiearchy but ${(t.ids, ".")} is not.".render)
        return None()
      case _ => return Some(t)
    }
  }

  def checkCyclic(reporter: Reporter): Unit = {
    var cache = HashMap.empty[AST.Typed.Name, HashSet[AST.Typed.Name]]
    for (t <- rootTypes) {
      val r = poset.descendantsCache(t, cache)
      cache = r._2
    }
    for (kv <- cache.entries) {
      val k = kv._1
      val v = kv._2
      if (v.contains(k)) {
        reporter.error(None(), resolverKind, st"Cyclic type hierarchy involving ${(k.ids, ".")}.".render)
      }
    }
  }

  def typed(scope: Scope,
            t: AST.Type,
            reporter: Reporter): Option[AST.Typed] = {
    t match {
      case t: AST.Type.Named =>
        var argTypes = ISZ[AST.Typed]()
        var hasError = F
        for (arg <- t.typeArgs) {
          val targOpt = typed(scope, arg, reporter)
          targOpt match {
            case Some(targ) => argTypes = argTypes :+ targ
            case _ => hasError = T
          }
        }
        if (hasError) {
          return None[AST.Typed]()
        }
        val name = AST.Util.ids2strings(t.name.ids)
        scope.resolveType(typeMap, name) match {
          case Some(ti: TypeInfo.TypeAlias) =>
            val tparamSize = ti.ast.typeParams.size
            if (argTypes.size != tparamSize) {
              reporter.error(t.posOpt, TypeChecker.typeCheckerKind,
                st"Type alias ${(name, ".")} requires $tparamSize type arguments but ${argTypes.size} supplied.".render)
              return None()
            }
            return Some(AST.Typed.Name(ti.name, argTypes, t.posOpt))
          case Some(ti: TypeInfo.TypeVar) =>
            if (argTypes.nonEmpty) {
              reporter.error(t.posOpt, TypeChecker.typeCheckerKind,
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
              case _ => halt("Infeasible")
            }
            if (argTypes.size != p._2) {
              if (p._2 == 0) {
                reporter.error(t.posOpt, TypeChecker.typeCheckerKind,
                  st"Slang ${p._1} ${(name, ".")} does not accept type arguments.".render)
              } else {
                reporter.error(t.posOpt, TypeChecker.typeCheckerKind,
                  st"Slang ${p._1} ${(name, ".")} requires ${p._2} type arguments but ${argTypes.size} is supplied.".render)
              }
              return None()
            }
            return Some(AST.Typed.Name(ti.name, argTypes, t.posOpt))
          case _ =>
            if (name.size == 1 && argTypes.isEmpty && name(0) == "Unit") {
              return Some(TypeChecker.typeUnit)
            } else {
              reporter.error(t.posOpt, TypeChecker.typeCheckerKind, st"Could not find a type named ${(name, ".")}.".render)
            }
            return None()
        }
      case t: AST.Type.Tuple =>
        var esTypes = ISZ[AST.Typed]()
        var hasError = F
        for (arg <- t.args) {
          val targOpt = typed(scope, arg, reporter)
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
          val targOpt = typed(scope, arg, reporter)
          targOpt match {
            case Some(targ) => paramTypes = paramTypes :+ targ
            case _ => hasError = T
          }
        }
        val trOpt = typed(scope, t.ret, reporter)
        trOpt match {
          case Some(tr) if !hasError =>
            return Some(AST.Typed.Fun(t.isPure, t.isByName, paramTypes, tr, t.posOpt))
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
    val tOpt = this.typed(scope, ti.ast.tipe, reporter)
    tOpt match {
      case Some(t) =>
        val substMapOpt = TypeChecker.buildSubstMap(ti.name, posOpt, ti.ast.typeParams, typed.args, reporter)
        substMapOpt match {
          case Some(substMap) => return Some(TypeChecker.substType(substMap, t))
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
          typeMap.get(t.ids) match {
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
        for (i <- z"0" until t1.args.size) {
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
        for (i <- z"0" until t1.args.size) {
          if (!TypeChecker.isEqType(t1.args(i), t2.args(i))) {
            return F
          }
        }
        if (t1.ids == t2.ids) {
          return T
        }
        return poset.ancestorsOf(t1).contains(t2)
      case _ => return TypeChecker.isEqType(t1, t2)
    }
  }
}
