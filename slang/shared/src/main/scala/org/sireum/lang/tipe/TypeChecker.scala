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
import org.sireum.lang.symbol.Resolver
import org.sireum.ops._
import org.sireum.ops.ISZOps._
import org.sireum.lang.{ast => AST}
import org.sireum.lang.symbol.Resolver._
import org.sireum.lang.util._

object TypeChecker {
  val typeCheckerKind: String = "Type Checker"
  val errType: AST.Typed = AST.Typed.Name(ISZ(), ISZ(), None())

  @datatype class TypeConstructor(parameters: ISZ[(String, AST.Typed)],
                                  tipe: AST.Typed) {
    def construct(args: Map[String, AST.Typed],
                  typeChecker: TypeChecker,
                  posOpt: Option[AST.PosInfo],
                  reporter: Reporter): Option[AST.Typed] = {
      var m = Map.empty[String, AST.Typed]
      var hasError = F
      for (p <- parameters) {
        val pName = p._1
        val pType = substType(m, p._2)
        args.get(pName) match {
          case Some(argType) =>
            if (!typeChecker.isSubType(argType, pType, reporter)) {
              reporter.error(posOpt, typeCheckerKind, s"Type '${AST.Util.typedString(argType).render}' is not a subtype of '${AST.Util.typedString(pType)}'.")
              hasError = T
            }
            m = m.put(pName, argType)
          case _ =>
            reporter.error(posOpt, typeCheckerKind, s"Could not find argument for type parameter '$pName'.")
            hasError = T
        }
      }
      return if (hasError) None[AST.Typed]() else Some(substType(m, tipe))
    }
  }

  @pure def substType(m: Map[String, AST.Typed], t: AST.Typed): AST.Typed = {
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
                            typeHierarchy: Poset[AST.Typed.Name],
                            checkers: ISZ[TypeChecker]) {

  def typeCheck(scope: Scope, t: AST.Type, reporter: AccumulatingReporter): Option[AST.Typed] = {
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
          case Some(ti: Resolver.TypeInfo.SubZ) =>
          case Some(ti: Resolver.TypeInfo.Enum) =>
          case Some(ti: Resolver.TypeInfo.Sig) =>
          case Some(ti: Resolver.TypeInfo.AbstractDatatype) =>
          case Some(ti: Resolver.TypeInfo.Rich) =>
          case Some(ti: Resolver.TypeInfo.TypeAlias) =>
          case Some(ti: Resolver.TypeInfo.TypeVar) =>
        }
        halt("TODO")
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
                     ti: Resolver.TypeInfo.TypeAlias,
                     reporter: Reporter): Option[AST.Typed] = {
    val tiScope = ti.scope
    val nameMap = HashMap.empty[String, Resolver.Info]
    var typeMap = HashMap.empty[String, Resolver.TypeInfo]
    var scope = Scope.Local(nameMap, typeMap, Some(tiScope))
    for (tp <- ti.ast.typeParams if !reporter.hasIssue) {
      val name = tp.id.value
      tp.superTypeOpt match {
        case Some(t) =>
          halt("TODO")
        case _ =>
      }
      typeMap = typeMap.put(name, TypeInfo.TypeVar(tp.id.value, tp))
      scope = Scope.Local(nameMap, typeMap, Some(tiScope))
    }
    halt("TODO")
  }

  def dealias(typed: AST.Typed, reporter: Reporter): AST.Typed = {
    def dealiasOpt(t: AST.Typed): Option[AST.Typed] = {
      t match {
        case t: AST.Typed.Name =>
          globalTypeMap.get(t.ids) match {
            case Some(ti: Resolver.TypeInfo.TypeAlias) =>
              halt("TODO")
            case _ =>
              var newArgs = ISZ[AST.Typed]()
              for (arg <- t.args) {
                val newArgOpt = dealiasOpt(arg)
                newArgOpt match {
                  case Some(newArg) => newArgs = newArgs :+ newArg
                  case _ => return None()
                }
              }
              return Some(t(args = newArgs))
          }
        case t: AST.Typed.Tuple =>
          var newArgs = ISZ[AST.Typed]()
          for (arg <- t.args) {
            val newArgOpt = dealiasOpt(arg)
            newArgOpt match {
              case Some(newArg) => newArgs = newArgs :+ newArg
              case _ => return None()
            }
          }
          return Some(t(args = newArgs))
        case t: AST.Typed.Fun =>
          dealiasOpt(t.ret) match {
            case Some(newRet) =>
              var newArgs = ISZ[AST.Typed]()
              for (arg <- t.args) {
                val newArgOpt = dealiasOpt(arg)
                 newArgOpt match {
                  case Some(newArg) => newArgs = newArgs :+ newArg
                  case _ => return None()
                }
              }
              return Some(t(args = newArgs, ret = newRet))
            case _ => return None()
          }
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

  @pure def isSubType(t1: AST.Typed, t2: AST.Typed, reporter: Reporter): B = {
    val dt1 = dealias(t1, reporter)
    val dt2 = dealias(t2, reporter)
    if (isEqType(dt1, dt2)) {
      return T
    }
    (dt1, dt2) match {
      case (dt1: AST.Typed.Name, dt2: AST.Typed.Name) =>
        halt("TODO")
      case _ => return F
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

  def rootTypes(): ISZ[QName] = {
    var r = ISZ[QName]()
    for (p <- typeHierarchy.parents.entries) {
      if (p._2.isEmpty) {
        r = r :+ p._1.ids
      }
    }
    return r
  }

  def check(reporter: Reporter): Unit = {
    // WORKAROUND: has to use B => AccumulatingReporter instead of () => AccumulatingReporter
    // due to issues in scalameta macro expansion
    var typeInfos = ISZ[B => AccumulatingReporter]()
    for (info <- globalTypeMap.values) {
      info match {
        case info: TypeInfo.Sig =>
          typeInfos = typeInfos :+ ((_: B) => checkSig(info))
        case info: TypeInfo.AbstractDatatype =>
          typeInfos = typeInfos :+ ((_: B) => checkAdt(info))
        case info: TypeInfo.Rich =>
          typeInfos = typeInfos :+ ((_: B) => checkRich(info))
        case _ =>
      }
    }
    var objectInfos = ISZ[B => AccumulatingReporter]()
    for (info <- globalNameMap.values) {
      info match {
        case info: Info.Object =>
          objectInfos = objectInfos :+ ((_: B) => checkObject(info))
        case _ =>
      }
    }
    val r = ISOps(typeInfos ++ objectInfos).
      parMapFoldLeft(
        (f: B => AccumulatingReporter) => f(T),
        AccumulatingReporter.combine,
        AccumulatingReporter.create)
    reporter.reports(r.messages)
  }

  @memoize def checkVarType(typeParams: ISZ[AST.TypeParam],
                            info: Info.Var): (TypeConstructor, AccumulatingReporter) = {
    halt("TODO")
  }

  @memoize def checkSpecVarType(typeParams: ISZ[AST.TypeParam],
                                info: Info.SpecVar): (TypeConstructor, AccumulatingReporter) = {
    halt("TODO")
  }

  @memoize def checkSpecMethodType(typeParams: ISZ[AST.TypeParam],
                                   info: Info.SpecMethod): (TypeConstructor, AccumulatingReporter) = {
    halt("TODO")
  }

  @memoize def checkExtMethodType(typeParams: ISZ[AST.TypeParam],
                                  info: Info.ExtMethod): (TypeConstructor, AccumulatingReporter) = {
    halt("TODO")
  }

  @memoize def checkMethodType(typeParams: ISZ[AST.TypeParam],
                               info: Info.Method): (TypeConstructor, AccumulatingReporter) = {
    halt("TODO")
  }

  @pure def checkObject(ast: Info.Object): AccumulatingReporter = {
    halt("TODO")
  }

  @pure def checkSig(info: TypeInfo.Sig): AccumulatingReporter = {
    halt("TODO")
  }

  @pure def checkAdt(info: TypeInfo.AbstractDatatype): AccumulatingReporter = {
    halt("TODO")
  }

  @pure def checkRich(info: TypeInfo.Rich): AccumulatingReporter = {
    halt("TODO")
  }

  @pure def checkScript(program: AST.TopUnit.Program): AccumulatingReporter = {
    halt("TODO")
  }

}
