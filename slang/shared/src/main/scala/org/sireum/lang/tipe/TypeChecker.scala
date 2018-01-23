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
import org.sireum.lang.{ast => AST}
import org.sireum.lang.symbol.Resolver._
import org.sireum.lang.util._

object TypeChecker {

  @enum object BasicKind {
    'B
    'C
    'Z
    'Range
    'Bits
    'F32
    'F64
    'R
  }

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
    for (i <- z"0" until args.size) {
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
        for (i <- z"0" until t1.args.size) {
          if (!isEqType(t1.args(i), t2.args(i))) {
            return F
          }
        }
        return T
      case (t1: AST.Typed.Tuple, t2: AST.Typed.Tuple) =>
        if (t1.args.size != t2.args.size) {
          return F
        }
        for (i <- z"0" until t1.args.size) {
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
        for (i <- z"0" until t1.args.size) {
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

@datatype class TypeChecker(typeHierarchy: TypeHierarchy) {

  val typeB: AST.Typed.Name = {
    val name = ISZ[String]("org", "sireum", "B")
    AST.Typed.Name(name, ISZ(), typeHierarchy.typeMap.get(name).get.posOpt)
  }

  val typeC: AST.Typed.Name = {
    val name = ISZ[String]("org", "sireum", "C")
    AST.Typed.Name(name, ISZ(), typeHierarchy.typeMap.get(name).get.posOpt)
  }

  val typeF32: AST.Typed.Name = {
    val name = ISZ[String]("org", "sireum", "F32")
    AST.Typed.Name(name, ISZ(), typeHierarchy.typeMap.get(name).get.posOpt)
  }

  val typeF64: AST.Typed.Name = {
    val name = ISZ[String]("org", "sireum", "F64")
    AST.Typed.Name(name, ISZ(), typeHierarchy.typeMap.get(name).get.posOpt)
  }

  val typeZ: AST.Typed.Name = {
    val name = ISZ[String]("org", "sireum", "Z")
    AST.Typed.Name(name, ISZ(), typeHierarchy.typeMap.get(name).get.posOpt)
  }

  val typeR: AST.Typed.Name = {
    val name = ISZ[String]("org", "sireum", "R")
    AST.Typed.Name(name, ISZ(), typeHierarchy.typeMap.get(name).get.posOpt)
  }

  val typeString: AST.Typed.Name = {
    val name = ISZ[String]("org", "sireum", "String")
    AST.Typed.Name(name, ISZ(), typeHierarchy.typeMap.get(name).get.posOpt)
  }

  val typeST: AST.Typed.Name = {
    val name = ISZ[String]("org", "sireum", "ST")
    AST.Typed.Name(name, ISZ(), typeHierarchy.typeMap.get(name).get.posOpt)
  }

  def basicKind(scope: Scope, t: AST.Typed,
                posOpt: Option[AST.PosInfo],
                reporter: Reporter): Option[(AST.Typed, BasicKind.Type)] = {
    val tpe = typeHierarchy.dealias(t, posOpt, reporter)
    tpe match {
      case tpe: AST.Typed.Name =>
        if (tpe.args.nonEmpty) {
          return None()
        }
        if (tpe.ids.size == 3) {
          if (tpe.ids == typeB.ids) {
            return Some((tpe, BasicKind.B))
          }
          if (tpe.ids == typeZ.ids) {
            return Some((tpe, BasicKind.Z))
          }
          if (tpe.ids == typeC.ids) {
            return Some((tpe, BasicKind.C))
          }
          if (tpe.ids == typeF32.ids) {
            return Some((tpe, BasicKind.F32))
          }
          if (tpe.ids == typeF64.ids) {
            return Some((tpe, BasicKind.F64))
          }
          if (tpe.ids == typeR.ids) {
            return Some((tpe, BasicKind.F64))
          }
        }
        scope.resolveType(typeMap, tpe.ids) match {
          case Some(ti: TypeInfo.SubZ) =>
            return Some((tpe, if (ti.ast.isBitVector) BasicKind.Bits else BasicKind.Range))
          case _ =>
        }
      case _ =>
    }
    return None()
  }

  @pure def typeMap: TypeMap = {
    return typeHierarchy.typeMap
  }

  @pure def nameMap: NameMap = {
    return typeHierarchy.nameMap
  }

  def checkExp(scope: Scope,
               exp: AST.Exp,
               reporter: Reporter): (AST.Exp, Option[AST.Typed]) = {

    exp match {

      case exp: AST.Exp.Binary =>

        val (left, leftTypeOpt) = checkExp(scope, exp.left, reporter)
        val (right, rightTypeOpt) = checkExp(scope, exp.right, reporter)
        val newBinaryExp = exp(left = left, right = right)
        (leftTypeOpt, rightTypeOpt) match {
          case (Some(leftType), Some(rightType)) =>
            val lOpt = basicKind(scope, leftType, exp.left.posOpt, reporter)
            val rOpt = basicKind(scope, rightType, exp.right.posOpt, reporter)
            (lOpt, rOpt) match {
              case (Some((leftT, leftKind)), Some((rightT, rightKind))) =>
                if (leftKind != rightKind) {
                  reporter.error(exp.posOpt, typeCheckerKind,
                    st"Incompatible types for binary operation ${AST.Util.typedString(leftT)} ${AST.Util.binop(exp.op)} ${AST.Util.typedString(rightT)}.".render)
                  return (newBinaryExp, None())
                }
                if ((leftKind == BasicKind.B && AST.Util.isBoolBinop(exp.op)) ||
                  (AST.Util.isArithBinop(exp.op) && leftKind != BasicKind.B) ||
                  (AST.Util.isBitsBinop(exp.op) && leftKind == BasicKind.Bits)) {
                  var r = newBinaryExp
                  val tOpt = Some(leftT)
                  up(r.attr.typedOpt) = tOpt
                  return (r, tOpt)
                } else if (AST.Util.isCompareBinop(exp.op) && leftKind != BasicKind.B) {
                  var r = newBinaryExp
                  val tOpt: Option[AST.Typed] = Some(typeB)
                  up(r.attr.typedOpt) = tOpt
                  return (r, tOpt)
                } else {
                  reporter.error(exp.posOpt, typeCheckerKind,
                    st"Undefined binary operation ${AST.Util.binop(exp.op)} on ${AST.Util.typedString(leftT)}".render)
                }
                halt("Unimplemented") // TODO
              case _ =>
                halt("Unimplemented") // TODO: find <op> binary methods
            }
          case _ => return (exp(left = left, right = right), None())
        }

      case exp: AST.Exp.Eta => halt("Unimplemented") // TODO

      case exp: AST.Exp.ForYield => halt("Unimplemented") // TODO

      case exp: AST.Exp.Fun => halt("Unimplemented") // TODO

      case exp: AST.Exp.Ident => halt("Unimplemented") // TODO

      case exp: AST.Exp.If => halt("Unimplemented") // TODO

      case exp: AST.Exp.Invoke => halt("Unimplemented") // TODO

      case exp: AST.Exp.InvokeNamed => halt("Unimplemented") // TODO

      case exp: AST.Exp.LitB => return (exp, Some(typeB))

      case exp: AST.Exp.LitBv => halt("Unimplemented") // TODO

      case exp: AST.Exp.LitC => return (exp, Some(typeC))

      case exp: AST.Exp.LitF32 => return (exp, Some(typeF32))

      case exp: AST.Exp.LitF64 => return (exp, Some(typeF64))

      case exp: AST.Exp.LitR => return (exp, Some(typeR))

      case exp: AST.Exp.LitString => return (exp, Some(typeString))

      case exp: AST.Exp.LitZ => return (exp, Some(typeZ))

      case exp: AST.Exp.Quant => halt("Unimplemented") // TODO

      case exp: AST.Exp.Select => halt("Unimplemented") // TODO

      case exp: AST.Exp.StringInterpolate =>
        var args = ISZ[AST.Exp]()
        var argTypes = ISZ[AST.Typed]()
        var ok = T
        for (arg <- exp.args) {
          val (newArg, argTypeOpt) = checkExp(scope, arg, reporter)
          args = args :+ newArg
          argTypeOpt match {
            case Some(argType) => argTypes = argTypes :+ argType
            case _ => ok = F
          }
        }
        exp.prefix.native match {
          case "s" => return (exp(args = args), Some(typeString))
          case "st" => return (exp(args = args), Some(typeST))
          case _ => halt("Unimplemented") // TODO
        }

      case exp: AST.Exp.Super => halt("Unimplemented") // TODO

      case exp: AST.Exp.This => halt("Unimplemented") // TODO

      case exp: AST.Exp.Tuple =>
        var args = ISZ[AST.Exp]()
        var argTypes = ISZ[AST.Typed]()
        var ok = T
        for (arg <- args) {
          val (newArg, argTypeOpt) = checkExp(scope, arg, reporter)
          args = args :+ newArg
          argTypeOpt match {
            case Some(argType) => argTypes = argTypes :+ argType
            case _ => ok = F
          }
        }
        var r = exp
        up(r.args) = args
        if (!ok) {
          return (r, None())
        }
        val t: AST.Typed = AST.Typed.Tuple(argTypes, exp.posOpt)
        up(r.attr.typedOpt) = Some(t)
        return (r, Some(t))

      case exp: AST.Exp.Unary =>
        val (newExp, expTypeOpt) = checkExp(scope, exp.exp, reporter)
        val newUnaryExp = exp(exp = newExp)
        expTypeOpt match {
          case Some(expType) =>
            val kindOpt = basicKind(scope, expType, exp.posOpt, reporter)
            kindOpt match {
              case Some((tpe, kind)) =>
                if (exp.op == AST.Exp.UnaryOp.Not && kind != BasicKind.B) {
                  reporter.error(exp.posOpt, typeCheckerKind,
                    st"Undefined unary operation ! on ${AST.Util.typedString(tpe)}.".render)
                  return (newUnaryExp, None())
                }
                if (exp.op == AST.Exp.UnaryOp.Complement &&
                  !(kind == BasicKind.B || kind == BasicKind.Bits)) {
                  reporter.error(exp.posOpt, typeCheckerKind,
                    st"Undefined unary operation ~ on ${AST.Util.typedString(tpe)}.".render)
                  return (newUnaryExp, None())
                }
                var r = newUnaryExp
                val tOpt = Some(tpe)
                up(r.attr.typedOpt) = tOpt
                return (newUnaryExp, tOpt)
              case _ =>
                // TODO: resolve unary_<op> on <expType>
                reporter.error(exp.posOpt, typeCheckerKind,
                  st"Undefined unary operation ${AST.Util.unop(exp.op)} on ${AST.Util.typedString(expType)}.".render)
            }
          case _ =>
        }
        return (newExp, None())
    }
  }

  def expectBExp(scope: Scope, exp: AST.Exp, reporter: Reporter): AST.Exp = {
    val (newExp, expTypeOpt) = checkExp(scope, exp, reporter)
    expTypeOpt match {
      case Some(expType) =>
        val t = typeHierarchy.dealias(expType, exp.posOpt, reporter)
        if (t != typeB) {
          reporter.error(exp.posOpt, typeCheckerKind,
            st"Expecting expression of type org.sireum.B, but found ${AST.Util.typedString(t)}.".render)
          return exp
        } else {
          return newExp
        }
      case _ => return exp
    }
  }

  def expectStringExp(scope: Scope, exp: AST.Exp, reporter: Reporter): AST.Exp = {
    val (newExp, expTypeOpt) = checkExp(scope, exp, reporter)
    expTypeOpt match {
      case Some(expType) =>
        val t = typeHierarchy.dealias(expType, exp.posOpt, reporter)
        if (t != typeString) {
          reporter.error(exp.posOpt, typeCheckerKind,
            st"Expecting expression of type org.sireum.String, but found ${AST.Util.typedString(t)}.".render)
          return exp
        } else {
          return newExp
        }
      case _ => return exp
    }
  }

  def checkStmt(scope: Scope, stmt: AST.Stmt, reporter: Reporter): AST.Stmt = {

    def checkAssertume(isAssert: B, assertume: AST.Stmt.Expr, assertumeExp: AST.Exp.Invoke,
                       cond: AST.Exp, msgOpt: Option[AST.Exp]): AST.Stmt = {
      val newCondExp = expectBExp(scope, cond, reporter)

      msgOpt match {
        case Some(msg) =>
          val newMsg = expectStringExp(scope, cond, reporter)
          return assertume(exp = assertumeExp(args = ISZ(newCondExp, newMsg)))
        case _ =>
          return assertume(exp = assertumeExp(args = ISZ(newCondExp)))
      }
    }

    stmt match {

      case stmt: AST.Stmt.LStmt => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.AbstractDatatype => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.Assign => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.AssignPattern => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.AssignUp => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.Block => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.DoWhile => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.Enum => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.Expr =>

        stmt.exp match {

          case exp@AST.Exp.Invoke(None(), AST.Id(string"assert"), targs, args) if targs.isEmpty =>
            args.size match {
              case z"1" => val r = checkAssertume(T, stmt, exp, args(0), None()); return r
              case z"2" => val r = checkAssertume(T, stmt, exp, args(0), Some(args(1))); return r
              case _ =>
                reporter.error(stmt.exp.posOpt, typeCheckerKind,
                  s"Invalid number of arguments (${args.size}) for assert.")
                return stmt
            }

          case exp@AST.Exp.Invoke(None(), AST.Id(string"assume"), targs, args) if targs.isEmpty =>
            args.size match {
              case z"1" => val r = checkAssertume(F, stmt, exp, args(0), None()); return r
              case z"2" => val r = checkAssertume(F, stmt, exp, args(0), Some(args(1))); return r
              case _ =>
                reporter.error(stmt.exp.posOpt, typeCheckerKind,
                  s"Invalid number of arguments (${args.size}) for assume.")
                return stmt
            }

            halt("Unimplemented.") // TODO

          case _ => halt("Unimplemented.") // TODO
        }

      case stmt: AST.Stmt.ExtMethod => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.For => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.If => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.Import => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.Match => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.Method => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.Object => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.Return => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.Sig => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.SpecMethod => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.SpecVar => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.SubZ => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.TypeAlias => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.Var => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.VarPattern => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.While => halt("Unimplemented.") // TODO

    }
  }

  @pure def checkProgram(program: AST.TopUnit.Program): TypeChecker => (TypeChecker, AccumulatingReporter) = {
    halt("Unimplemented") // TODO
  }

}
