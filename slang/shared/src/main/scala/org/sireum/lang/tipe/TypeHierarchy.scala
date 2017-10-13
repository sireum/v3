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
  @datatype class Type(poset: Poset[AST.Typed.Name],
                       aliases: HashMap[AST.Typed.Name, AST.Typed]) {
    def rootTypes: ISZ[AST.Typed.Name] = {
      var r = ISZ[AST.Typed.Name]()
      for (ps <- poset.parents.entries) {
        if (ps._2.isEmpty) {
          r = r :+ ps._1
        }
      }
      return r
    }

    def dealias(t: AST.Typed.Name, reporter: Reporter): Option[AST.Typed.Name] = {
      aliases.get(t) match {
        case Some(t2: AST.Typed.Name) =>
          val r = dealias(t2, reporter)
          return r
        case Some(_) =>
          reporter.error(None(), resolverKind, st"Expected a named type in type hiearchy but ${(t.ids, ".")} is not.".render)
          return None()
        case _ => return Some(t)
      }
    }

    def checkCyclic(reporter: Reporter): Unit = {
      var workList = rootTypes
      var temp = ISZ[AST.Typed.Name]()
      var seen = HashSet.empty[AST.Typed.Name]()
      while (workList.nonEmpty) {
        for (t <- workList) {
          if (seen.contains(t)) {
            reporter.error(None(), resolverKind, st"Cyclic type hierarchy from ${(t.ids, ".")}.".render)
          } else {
            seen = seen.add(t)
            for (child <- poset.childrenOf(t).elements) {
              val dchild = dealias(child, reporter)
              dchild match {
                case Some(childT) => temp = temp :+ childT
                case _ =>
              }
            }
          }
        }
        workList = temp
      }
    }
  }

  @pure def typedInfo(info: TypeInfo): AST.Typed.Name = {
    @pure def typedParam(tp: AST.TypeParam): AST.Typed = {
      return AST.Typed.Name(ISZ(tp.id.value), ISZ(), tp.id.attr.posOpt)
    }
    info match {
      case info: TypeInfo.SubZ => return AST.Typed.Name(info.name, ISZ(), info.posOpt)
      case info: TypeInfo.Enum => return AST.Typed.Name(info.name, ISZ(), info.posOpt)
      case info: TypeInfo.Sig =>
        val args = info.ast.typeParams.map(typedParam)
        return AST.Typed.Name(info.name, args, info.posOpt)
      case info: TypeInfo.AbstractDatatype =>
        val args = info.ast.typeParams.map(typedParam)
        return AST.Typed.Name(info.name, args, info.posOpt)
      case info: TypeInfo.Rich =>
        val args = info.ast.typeParams.map(typedParam)
        return AST.Typed.Name(info.name, args, info.posOpt)
      case info: TypeInfo.TypeAlias =>
        val args = info.ast.typeParams.map(typedParam)
        return AST.Typed.Name(info.name, args, info.posOpt)
      case _: TypeInfo.TypeVar => halt("Infeasible")
    }
  }

  def build(typeMap: TypeMap, init: Type, reporter: Reporter): Type = {
    def resolveType(scope: Scope, t: AST.Type): AST.Typed = {
      t match {
        case t: AST.Type.Named =>
          val name = AST.Util.ids2strings(t.name.ids)
          if (scope.resolveType(typeMap, name).isEmpty) {
            reporter.error(t.name.attr.posOpt, resolverKind, s"Could not resolve type named '${st"${(name, ".")}".render}'.")
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
          AST.Typed.Fun(ts, rt, t.posOpt)
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
    val zName = ISZ("org", "sireum", "Z")
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
    val zTyped = typedInfo(typeMap.get(zName).get)
    for (info <- typeMap.values) {
      info match {
        case _: TypeInfo.SubZ =>
          val typed = typedInfo(info)
          up(r.poset) = r.poset.addParents(typed, ISZ(zTyped))
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
        case info: TypeInfo.Rich =>
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
