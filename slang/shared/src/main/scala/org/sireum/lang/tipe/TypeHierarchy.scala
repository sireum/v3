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
  type Type = Poset[AST.Typed]

  @pure def typedInfo(info: TypeInfo): AST.Typed = {
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
    def resolveTypeNameds(scope: Scope, ts: ISZ[AST.Type.Named]): ISZ[AST.Typed] = {
      var r = ISZ[AST.Typed]()
      for (t <- ts) {
        val typed = resolveType(scope, t)
        r = r :+ typed
      }
      return r
    }
    val zName = ISZ("org", "sireum", "Z")
    var r = init
    if (!typeMap.contains(zName)) {
      reporter.error(None(), resolverKind, "Could not find Z type.")
      return r
    }
    val zTyped: AST.Typed = typedInfo(typeMap.get(zName).get)
    for (info <- typeMap.values) {
      val typed = typedInfo(info)
      info match {
        case _: TypeInfo.SubZ => r = r.addParents(typed, ISZ(zTyped))
        case _: TypeInfo.Enum => r = r.addNode(typed)
        case info: TypeInfo.Sig =>
          val scope = typeParamsScope(info.ast.typeParams, info.scope, reporter)
          val parents = resolveTypeNameds(scope, info.ast.parents)
          r = r.addParents(typed, parents)
        case info: TypeInfo.AbstractDatatype =>
          val scope = typeParamsScope(info.ast.typeParams, info.scope, reporter)
          val parents = resolveTypeNameds(scope, info.ast.parents)
          r = r.addParents(typed, parents)
        case info: TypeInfo.Rich =>
          val scope = typeParamsScope(info.ast.typeParams, info.scope, reporter)
          val parents: ISZ[AST.Typed] = resolveTypeNameds(scope, info.ast.parents)
          r = r.addParents(typed, parents)
        case info: TypeInfo.TypeAlias =>
          val scope = typeParamsScope(info.ast.typeParams, info.scope, reporter)
          val parents = ISZ(resolveType(scope, info.ast.tipe))
          r = r.addParents(typed, parents)
        case _: TypeInfo.TypeVar => halt("Infeasible")
      }
    }
    return r
  }
}
