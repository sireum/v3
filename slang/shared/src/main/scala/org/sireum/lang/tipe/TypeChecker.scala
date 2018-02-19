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
import org.sireum.lang.symbol.{GlobalDeclarationResolver, Resolver}
import org.sireum.lang.{ast => AST}
import org.sireum.lang.symbol._
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

  @enum object BuiltInKind {
    'Print
    'Assertume
    'Halt
  }

  val typeCheckerKind: String = "Type Checker"
  val errType: AST.Typed = AST.Typed.Name(ISZ(), ISZ())

  val builtInMethods: HashSet[String] =
    HashSet ++ ISZ("assert", "assume", "println", "print", "cprintln", "cprint", "eprintln", "eprint", "halt")
  val assertResOpt: Option[AST.ResolvedInfo] = Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.Assert))

  val assertume1TypedOpt: Option[AST.Typed] = Some(AST.Typed.Fun(F, F, ISZ(AST.Typed.b), AST.Typed.unit))

  val assertume2TypedOpt: Option[AST.Typed] = Some(
    AST.Typed.Fun(F, F, ISZ(AST.Typed.b, AST.Typed.string), AST.Typed.unit)
  )
  val assumeResOpt: Option[AST.ResolvedInfo] = Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.Assume))
  val printlnResOpt: Option[AST.ResolvedInfo] = Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.Println))
  val printResOpt: Option[AST.ResolvedInfo] = Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.Print))
  val cprintlnResOpt: Option[AST.ResolvedInfo] = Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.Cprintln))
  val cprintResOpt: Option[AST.ResolvedInfo] = Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.Cprint))
  val eprintlnResOpt: Option[AST.ResolvedInfo] = Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.Eprintln))
  val eprintResOpt: Option[AST.ResolvedInfo] = Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.Eprint))
  val haltResOpt: Option[AST.ResolvedInfo] = Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.Halt))

  val haltTypedOpt: Option[AST.Typed] = Some(AST.Typed.Fun(F, F, ISZ(AST.Typed.string), AST.Typed.nothing))
  val nativeResOpt: Option[AST.ResolvedInfo] = Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.Native))
  val nativeCTypedOpt: Option[AST.Typed] = Some(AST.Typed.Fun(F, T, ISZ(), AST.Typed.c))
  val nativeStringTypedOpt: Option[AST.Typed] = Some(AST.Typed.Fun(F, T, ISZ(), AST.Typed.string))
  val nativeF32TypedOpt: Option[AST.Typed] = Some(AST.Typed.Fun(F, T, ISZ(), AST.Typed.f32))
  val nativeF64TypedOpt: Option[AST.Typed] = Some(AST.Typed.Fun(F, T, ISZ(), AST.Typed.f64))
  val applyResOpt: Option[AST.ResolvedInfo] = Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.Apply))
  val stringResOpt: Option[AST.ResolvedInfo] = Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.String))
  val hashResOpt: Option[AST.ResolvedInfo] = Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.Hash))

  val unopResOpt: HashMap[AST.Exp.UnaryOp.Type, Option[AST.ResolvedInfo]] = HashMap ++ ISZ(
    AST.Exp.UnaryOp.Plus ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.UnaryPlus)),
    AST.Exp.UnaryOp.Minus ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.UnaryMinus)),
    AST.Exp.UnaryOp.Not ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.UnaryNot)),
    AST.Exp.UnaryOp.Complement ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.UnaryComplement))
  )

  val binopResOpt: HashMap[String, Option[AST.ResolvedInfo]] = HashMap ++ ISZ(
    string"+" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryAdd)),
    string"-" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinarySub)),
    string"*" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryMul)),
    string"/" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryDiv)),
    string"%" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryRem)),
    string"==" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryEq)),
    string"!=" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryNe)),
    string"<<" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryShl)),
    string">>" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryShr)),
    string">>>" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryUshr)),
    string"<" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryLt)),
    string"<=" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryLe)),
    string">" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryGt)),
    string">=" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryGe)),
    string"&" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryAnd)),
    string"|" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryOr)),
    string"|^" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryXor)),
    string"->" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryImply)),
    string"&&" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryCondAnd)),
    string"||" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryCondOr)),
    string":+" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryAppend)),
    string"+:" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryPrepend)),
    string"++" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryAppendAll)),
    string"--" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryRemoveAll)),
    string"~>" ~> Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.BinaryMapsTo))
  )

  @memoize def libraryReporter: (TypeChecker, AccumulatingReporter) = {
    val (initNameMap, initTypeMap) =
      Resolver.addBuiltIns(HashMap.empty, HashMap.empty)
    val (reporter, nameMap, typeMap) =
      Resolver.parseProgramAndGloballyResolve(Library.files, initNameMap, initTypeMap)
    val th =
      TypeHierarchy.build(TypeHierarchy(nameMap, typeMap, Poset.empty, HashMap.empty), reporter)
    val thOutlined = TypeOutliner.checkOutline(th, reporter)
    val tc = TypeChecker(thOutlined, ISZ(), F)
    val r = (tc, reporter)
    return r
  }

  @memoize def checkedLibraryReporter: (TypeChecker, AccumulatingReporter) = {
    val (tc, reporter) = libraryReporter
    val th = tc.typeHierarchy
    val th2 = TypeChecker.checkComponents(th, th.nameMap, th.typeMap, reporter)
    return (TypeChecker(th2, ISZ(), F), reporter)
  }

  def buildTypeSubstMap(
    name: QName,
    posOpt: Option[AST.PosInfo],
    typeParams: ISZ[AST.TypeParam],
    args: ISZ[AST.Typed],
    reporter: Reporter
  ): Option[HashMap[String, AST.Typed]] = {
    if (typeParams.size != args.size) {
      reporter.error(
        posOpt,
        typeCheckerKind,
        st"Type ${(name, ".")} requires ${typeParams.size} type arguments, but only ${args.size} is supplied.".render
      )
      return None()
    }
    var substMap = HashMap.empty[String, AST.Typed]
    for (i <- z"0" until args.size) {
      substMap = substMap + typeParams(i).id.value ~> args(i)
    }
    return Some(substMap)
  }

  def buildMethodSubstMap(
    m: AST.Typed.Method,
    posOpt: Option[AST.PosInfo],
    args: ISZ[AST.Typed],
    reporter: Reporter
  ): Option[HashMap[String, AST.Typed]] = {
    if (m.typeParams.size != args.size) {
      reporter.error(
        posOpt,
        typeCheckerKind,
        st"$m requires ${m.typeParams.size} type arguments, but only ${args.size} is supplied.".render
      )
      return None()
    }
    var substMap = HashMap.empty[String, AST.Typed]
    for (i <- z"0" until args.size) {
      substMap = substMap + m.typeParams(i) ~> args(i)
    }
    return Some(substMap)
  }

  def checkWorksheet(
    thOpt: Option[TypeHierarchy],
    program: AST.TopUnit.Program,
    reporter: Reporter
  ): AST.TopUnit.Program = {
    val th: TypeHierarchy = thOpt match {
      case Some(thi) => thi
      case _ =>
        val (tc, rep) = libraryReporter
        if (rep.hasIssue) {
          reporter.reports(rep.messages)
          return program
        }
        tc.typeHierarchy
    }

    val gdr = GlobalDeclarationResolver(HashMap.empty, HashMap.empty, AccumulatingReporter.create)
    gdr.resolveProgram(
      program(
        body = program.body(
          stmts = program.body.stmts.withFilter(
            stmt =>
              stmt match {
                case _: AST.Stmt.Method => F
                case _: AST.Stmt.SpecMethod => F
                case _: AST.Stmt.Var => F
                case _: AST.Stmt.VarPattern => F
                case _: AST.Stmt.SpecVar => F
                case _ => T
            }
          )
        )
      )
    )

    if (gdr.reporter.hasError) {
      reporter.reports(gdr.reporter.messages)
      return program
    }

    val th2: TypeHierarchy = {
      val (rep, nameMap, typeMap) =
        Resolver.combine(
          (AccumulatingReporter.create, th.nameMap, th.typeMap),
          (AccumulatingReporter.create, gdr.globalNameMap, gdr.globalTypeMap)
        )

      if (rep.hasIssue) {
        reporter.reports(rep.messages)
        return program
      }

      TypeHierarchy.build(th(nameMap = nameMap, typeMap = typeMap), reporter)
    }

    if (reporter.hasError) {
      return program
    }

    val th3 = TypeOutliner.checkOutline(th2, reporter)
    if (reporter.hasError) {
      return program
    }

    var nameMap: NameMap = HashMap.empty
    var typeMap: TypeMap = HashMap.empty

    for (name <- gdr.globalNameMap.keys) {
      nameMap = nameMap + name ~> th3.nameMap.get(name).get
    }

    for (name <- gdr.globalTypeMap.keys) {
      typeMap = typeMap + name ~> th3.typeMap.get(name).get
    }

    val th4 = checkComponents(th3, nameMap, typeMap, reporter)
    if (reporter.hasError) {
      return program
    }

    val typeChecker = TypeChecker(th4, ISZ(), F)
    val scope = Scope.Local(HashMap.empty, HashMap.empty, None(), None(), Some(Scope.Global(ISZ(), ISZ(), ISZ())))
    val newBody = typeChecker.checkBody(None(), scope, program.body, reporter)
    return program(body = newBody)
  }

  def checkComponents(th: TypeHierarchy, nameMap: NameMap, typeMap: TypeMap, reporter: Reporter): TypeHierarchy = {
    var jobs = ISZ[() => TypeHierarchy => (TypeHierarchy, AccumulatingReporter)]()
    for (info <- typeMap.values) {
      info match {
        case info: TypeInfo.Sig if !info.typeChecked =>
          jobs = jobs :+ (() => TypeChecker(th, info.name, F).checkSig(info))
        case info: TypeInfo.AbstractDatatype if !info.typeChecked =>
          jobs = jobs :+ (() => TypeChecker(th, info.name, F).checkAbstractDatatype(info))
        case _ =>
      }
    }
    for (info <- nameMap.values) {
      info match {
        case info: Info.Object => jobs = jobs :+ (() => TypeChecker(th, info.name, F).checkObject(info))
        case _ =>
      }
    }
    val p = ops
      .ISZOps(jobs)
      .parMapFoldLeft(
        (f: () => TypeHierarchy => (TypeHierarchy, AccumulatingReporter)) => f(),
        TypeHierarchy.combine _,
        (th, AccumulatingReporter.create)
      )
    var r = p._1
    def reconstructObject(info: Info): Unit = {
      info match {
        case info: Info.Object =>
          var newStmts = ISZ[AST.Stmt]()
          for (stmt <- info.ast.stmts) {
            stmt match {
              case stmt: AST.Stmt.AbstractDatatype =>
                r.typeMap.get(info.name :+ stmt.id.value) match {
                  case Some(adtInfo: TypeInfo.AbstractDatatype) => newStmts = newStmts :+ adtInfo.ast
                  case _ => halt(s"Unexpected situation when type checking object @datatype/@record members")
                }
              case stmt: AST.Stmt.Sig =>
                r.typeMap.get(info.name :+ stmt.id.value) match {
                  case Some(sigInfo: TypeInfo.Sig) => newStmts = newStmts :+ sigInfo.ast
                  case _ => halt(s"Unexpected situation when type checking object @datatype/@record members")
                }
              case stmt: AST.Stmt.TypeAlias =>
                r.typeMap.get(info.name :+ stmt.id.value) match {
                  case Some(taInfo: TypeInfo.TypeAlias) => newStmts = newStmts :+ taInfo.ast
                  case _ => halt(s"Unexpected situation when type checking object type alias members")
                }
              case stmt: AST.Stmt.Object =>
                reconstructObject(r.nameMap.get(info.name :+ stmt.id.value).get)
              case _ => newStmts = newStmts :+ stmt
            }
          }
          r = r(nameMap = r.nameMap + info.name ~> info(typeChecked = T, ast = info.ast(stmts = newStmts)))
        case _ =>
      }
    }
    for (name <- nameMap.keys) {
      r.nameMap.get(name) match {
        case Some(info) => reconstructObject(info)
        case _ =>
      }
    }
    reporter.reports(p._2.messages)
    return r
  }
}

import TypeChecker._

@datatype class TypeChecker(typeHierarchy: TypeHierarchy, context: QName, inSpec: B) {

  def basicKind(
    scope: Scope,
    tpe: AST.Typed,
    posOpt: Option[AST.PosInfo],
    reporter: Reporter
  ): Option[BasicKind.Type] = {
    tpe match {
      case tpe: AST.Typed.Name =>
        if (tpe.args.nonEmpty) {
          return None()
        }
        if (tpe.ids.size == 3) {
          tpe.ids match {
            case AST.Typed.bName => return Some(BasicKind.B)
            case AST.Typed.zName => return Some(BasicKind.Z)
            case AST.Typed.cName => return Some(BasicKind.C)
            case AST.Typed.f32Name => return Some(BasicKind.F32)
            case AST.Typed.f64Name => return Some(BasicKind.F64)
            case AST.Typed.rName => return Some(BasicKind.R)
            case _ =>
          }
        }
        scope.resolveType(typeMap, tpe.ids) match {
          case Some(ti: TypeInfo.SubZ) =>
            return Some(if (ti.ast.isBitVector) BasicKind.Bits else BasicKind.Range)
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

  @pure def checkInfo(info: Info): (Option[AST.Typed], Option[AST.ResolvedInfo]) = {
    info match {
      case info: Info.LocalVar => return (info.typedOpt, info.resOpt)
      case info: Info.Package => return (info.typedOpt, info.resOpt)
      case info: Info.Object => return (info.typedOpt, info.resOpt)
      case info: Info.Enum => return (info.typedOpt, info.resOpt)
      case info: Info.EnumElement => return (info.typedOpt, info.resOpt)
      case info: Info.Method =>
        return if (inSpec && info.ast.purity == AST.Purity.Impure)
          (None(), None())
        else (info.typedOpt, info.resOpt)
      case info: Info.ExtMethod =>
        return if (inSpec && !info.ast.isPure) (None(), None()) else (info.typedOpt, info.resOpt)
      case info: Info.Var => return (info.typedOpt, info.resOpt)
      case info: Info.QuantVar =>
        return if (inSpec) (info.typedOpt, info.resOpt) else (None(), None())
      case info: Info.SpecMethod =>
        return if (!inSpec) (None(), None()) else (info.typedOpt, info.resOpt)
      case info: Info.SpecVar =>
        return if (!inSpec) (None(), None()) else (info.typedOpt, info.resOpt)
    }
  }

  @pure def checkInfoOpt(infoOpt: Option[Info]): (Option[AST.Typed], Option[AST.ResolvedInfo]) = {
    infoOpt match {
      case Some(info) => return checkInfo(info)
      case _ => return (None(), None())
    }
  }

  def checkStringInterpolator(
    posOpt: Option[AST.PosInfo],
    scope: Scope,
    prefix: String,
    reporter: Reporter
  ): Option[AST.Typed] = {
    scope.resolveName(typeHierarchy.nameMap, ISZ(prefix)) match {
      case Some(info: Info.Object) =>
        scope.resolveType(typeHierarchy.typeMap, info.owner) match {
          case Some(typeInfo: TypeInfo.SubZ) =>
            return Some(AST.Typed.Name(typeInfo.name, ISZ()))
          case _ =>
        }
      case _ =>
    }
    reporter.error(posOpt, typeCheckerKind, s"Could not resolve literal interpolator for '$prefix'.")
    return None()
  }

  def checkUnboundTypeVar(
    posOpt: Option[AST.PosInfo],
    t: AST.Typed,
    sm: HashMap[String, AST.Typed],
    typeParams: ISZ[String],
    reporter: Reporter
  ): B = {
    var unbound = ISZ[String]()
    for (tp <- typeParams) {
      sm.get(tp) match {
        case Some(_) =>
        case _ => unbound = unbound :+ tp
      }
    }
    if (unbound.nonEmpty) {
      reporter
        .error(posOpt, typeCheckerKind, st"Could not infer type parameter(s): '${(unbound, "', '")}' for $t.".render)
      return F
    }
    return T
  }

  def checkIndexType(posOpt: Option[AST.PosInfo], t: AST.Typed, reporter: Reporter): Unit = {
    if (t == AST.Typed.z) {
      return
    }
    t match {
      case t: AST.Typed.Name =>
        typeHierarchy.typeMap.get(t.ids) match {
          case Some(_: TypeInfo.SubZ) => return
          case _ =>
        }
      case _ =>
    }

    reporter
      .error(posOpt, typeCheckerKind, s"Expecting either type '${AST.Typed.z}', @bits, or @range, but '$t' found.")
  }

  def checkEnumGens(
    sc: Scope,
    enumGens: ISZ[AST.EnumGen.For],
    reporter: Reporter
  ): (Option[Scope.Local], ISZ[AST.EnumGen.For], AST.Typed, B) = {

    var scope = createNewScope(sc)
    var ok = T
    var isISOpt: Option[B] = None()
    var indexType: AST.Typed = AST.Typed.z

    def declId(idOpt: Option[AST.Id], tOpt: Option[AST.Typed]): Unit = {
      idOpt match {
        case Some(id) =>
          val key = id.value
          if (scope.nameMap.contains(key)) {
            reporter.error(
              id.attr.posOpt,
              typeCheckerKind,
              s"Cannot declare '$key' because the identifier has already been previously declared."
            )
            ok = F
          } else {
            scope = scope(
              nameMap = scope.nameMap + key ~> Info
                .LocalVar(context :+ key, F, id, tOpt, Some(AST.ResolvedInfo.LocalVar(context, key)))
            )
          }
        case _ =>
      }
    }

    def checkIS(posOpt: Option[AST.PosInfo], b: B): B = {
      isISOpt match {
        case Some(prev) =>
          if (b != prev) {
            reporter.error(
              posOpt,
              typeCheckerKind,
              st"For-yield expressions cannot involve both '${(AST.Typed.isName, ".")}' and '${(AST.Typed.msName, ".")}'.".render
            )
            return F
          }
        case _ => isISOpt = Some(b)
      }
      return T
    }

    def checkEnumGen(enumGen: AST.EnumGen.For): AST.EnumGen.For = {
      enumGen.range match {
        case range: AST.EnumGen.Range.Step =>
          ok = checkIS(range.attr.posOpt, T)
          val (newStartExp, startExpTypeOpt) = checkExp(None(), scope, range.start, reporter)
          val (newEndExp, endExpTypeOpt) = checkExp(startExpTypeOpt, scope, range.end, reporter)
          val newByOpt: Option[AST.Exp] = range.byOpt match {
            case Some(by) =>
              val (newByExp, _) = checkExp(startExpTypeOpt, scope, by, reporter)
              Some(newByExp)
            case _ => None()
          }
          (startExpTypeOpt, endExpTypeOpt) match {
            case (Some(startExpType), Some(_)) if newByOpt.nonEmpty || range.byOpt.isEmpty =>
              checkIndexType(range.start.posOpt, startExpType, reporter)
              declId(enumGen.idOpt, Some(startExpType))
              val newCondOpt: Option[AST.Exp] = enumGen.condOpt match {
                case Some(cond) if ok =>
                  val (newCondExp, _) = checkExp(AST.Typed.bOpt, scope, cond, reporter)
                  Some(newCondExp)
                case _ => None()
              }
              return enumGen(
                range = range(start = newStartExp, end = newEndExp, byOpt = newByOpt),
                condOpt = newCondOpt
              )
            case _ =>
              ok = F
              return enumGen(range = range(start = newStartExp, end = newEndExp, byOpt = newByOpt))
          }
        case range: AST.EnumGen.Range.Expr =>
          val (newExp, expTypeOpt) = checkExp(None(), scope, range.exp, reporter)
          expTypeOpt match {
            case Some(expType: AST.Typed.Name) =>
              expType.ids match {
                case AST.Typed.isName =>
                  ok = checkIS(range.attr.posOpt, T)
                  indexType = expType.args(0)
                case AST.Typed.msName =>
                  ok = checkIS(range.attr.posOpt, F)
                  indexType = expType.args(0)
                case _ =>
                  ok = F
              }
              val newCondOpt: Option[AST.Exp] = if (ok) {
                declId(enumGen.idOpt, Some(if (range.isIndices) expType.args(0) else expType.args(1)))
                enumGen.condOpt match {
                  case Some(cond) =>
                    val (newCond, _) = checkExp(AST.Typed.bOpt, scope, cond, reporter)
                    Some(newCond)
                  case _ => None()
                }
              } else {
                None()
              }
              return enumGen(range = range(exp = newExp), condOpt = newCondOpt)
            case Some(expType) =>
              reporter.error(
                range.exp.posOpt,
                typeCheckerKind,
                st"Expecting either type of '${(AST.Typed.isName, ".")}' or '${(AST.Typed.msName, ".")}', but '$expType' found.".render
              )
              ok = F
              return enumGen(range = range(exp = newExp))
            case _ =>
              ok = F
              return enumGen(range = range(exp = newExp))
          }
      }
    }

    var newEnumGens = ISZ[AST.EnumGen.For]()
    var i = 0
    val size = enumGens.size
    while (ok && i < size) {
      val newEnumGen = checkEnumGen(enumGens(i))
      newEnumGens = newEnumGens :+ newEnumGen
      i = i + 1
    }

    while (i < size) {
      newEnumGens = newEnumGens :+ enumGens(i)
      i = i + 1
    }

    return (if (ok) Some(scope) else None(), newEnumGens, indexType, isISOpt.getOrElse(T))
  }

  def checkFun(
    expectedOpt: Option[AST.Typed],
    sc: Scope,
    exp: AST.Exp.Fun,
    reporter: Reporter
  ): (AST.Exp, Option[AST.Typed]) = {
    var scope = createNewScope(sc)
    var ok = T

    def declId(id: AST.Id, tOpt: Option[AST.Typed]): Unit = {
      val key = id.value
      if (scope.nameMap.contains(key)) {
        reporter.error(
          id.attr.posOpt,
          typeCheckerKind,
          s"Cannot declare '$key' because the identifier has already been previously declared."
        )
        ok = F
      } else {
        scope = scope(
          nameMap = scope.nameMap + key ~> Info
            .LocalVar(context :+ key, F, id, tOpt, Some(AST.ResolvedInfo.LocalVar(context, key)))
        )
      }
    }

    val untypedParam = ops.ISZOps(exp.params).exists(p => p.tipeOpt.isEmpty)
    if (untypedParam) {
      expectedOpt match {
        case Some(expected: AST.Typed.Fun) =>
          val size = expected.args.size
          if (size != exp.params.size) {
            reporter.error(exp.posOpt, typeCheckerKind, s"Expecting $size parameters, but ${exp.params.size} found.")
            return (exp, None())
          }

          var newParams = ISZ[AST.Exp.Fun.Param]()
          var i = 0
          while (ok && i < size) {
            val p = exp.params(i)
            val expectedType = expected.args(i)
            declId(p.id, Some(expectedType))
            val newTipeOpt: Option[AST.Type] = p.tipeOpt match {
              case Some(tipe) =>
                val tOpt = typeHierarchy.typed(scope, tipe, reporter)
                tOpt match {
                  case Some(t) if t.typedOpt.nonEmpty =>
                    if (t.typedOpt.get != expectedType) {
                      reporter.error(
                        tipe.posOpt,
                        typeCheckerKind,
                        s"Expecting type '$expectedType', but '${t.typedOpt.get}' found."
                      )
                    }
                  case _ =>
                }
                tOpt
              case _ => None()
            }
            newParams = newParams :+ p(tipeOpt = newTipeOpt)
            i = i + 1
          }
          if (!ok) {
            return (exp, None())
          }
          val (newExp, _) = checkAssignExp(Some(expected.ret), scope, exp.exp, reporter)
          val tOpt: Option[AST.Typed] = Some(expected)
          return (exp(context = context, params = newParams, exp = newExp, attr = exp.attr(typedOpt = tOpt)), tOpt)
        case _ =>
          for (p <- exp.params if p.tipeOpt.isEmpty) {
            reporter.error(p.id.attr.posOpt, typeCheckerKind, "Explicit type for the lambda expression is required.")
          }
          return (exp, None())
      }
    } else {
      val expectedRetOpt: Option[AST.Typed] = expectedOpt match {
        case Some(expected: AST.Typed.Fun) => Some(expected.ret)
        case _ => None()
      }
      var newParams = ISZ[AST.Exp.Fun.Param]()
      var paramTypes = ISZ[AST.Typed]()
      for (p <- exp.params if ok) {
        val newTipeOpt: Option[AST.Type] = p.tipeOpt match {
          case Some(tipe) =>
            val tOpt = typeHierarchy.typed(scope, tipe, reporter)
            tOpt
          case _ => None()
        }
        newTipeOpt match {
          case Some(newTipe) if newTipe.typedOpt.nonEmpty =>
            val tOpt = newTipe.typedOpt
            val t = tOpt.get
            paramTypes = paramTypes :+ t
            declId(p.id, tOpt)
          case _ => ok = F
        }
        newParams = newParams :+ p(tipeOpt = newTipeOpt)
      }
      if (!ok) {
        return (exp, None())
      }
      val (newExp, retTypeOpt) = checkAssignExp(expectedRetOpt, scope, exp.exp, reporter)
      val tOpt: Option[AST.Typed] = retTypeOpt match {
        case Some(retType) => Some(AST.Typed.Fun(T, F, paramTypes, retType))
        case _ => None()
      }
      return (exp(context = context, params = newParams, exp = newExp, attr = exp.attr(typedOpt = tOpt)), tOpt)
    }
  }

  def checkExp(
    expectedOpt: Option[AST.Typed],
    scope: Scope,
    exp: AST.Exp,
    reporter: Reporter
  ): (AST.Exp, Option[AST.Typed]) = {

    def checkAssertume(
      resOpt: Option[AST.ResolvedInfo],
      assertumeExp: AST.Exp.Invoke,
      cond: AST.Exp,
      msgOpt: Option[AST.Exp]
    ): (AST.Exp, Option[AST.Typed]) = {
      val (newCondExp, _) = checkExp(AST.Typed.bOpt, scope, cond, reporter)

      msgOpt match {
        case Some(msg) =>
          val (newMsg, _) = checkExp(AST.Typed.stringOpt, scope, msg, reporter)
          val attr =
            assertumeExp.attr(typedOpt = assertume2TypedOpt, resOpt = resOpt)
          return (assertumeExp(args = ISZ(newCondExp, newMsg), attr = attr), AST.Typed.unitOpt)
        case _ =>
          val attr =
            assertumeExp.attr(typedOpt = assertume1TypedOpt, resOpt = resOpt)
          return (assertumeExp(args = ISZ(newCondExp), attr = attr), AST.Typed.unitOpt)
      }
    }

    def checkPrint(
      resOpt: Option[AST.ResolvedInfo],
      printExp: AST.Exp.Invoke,
      args: ISZ[AST.Exp]
    ): (AST.Exp, Option[AST.Typed]) = {
      var newArgs = ISZ[AST.Exp]()
      var argTypes: ISZ[AST.Typed] = {
        val hasBool: B = resOpt.get match {
          case AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.Cprint) => T
          case AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.Cprintln) => T
          case _ => F
        }
        if (hasBool) ISZ[AST.Typed](AST.Typed.b) else ISZ[AST.Typed]()
      }
      for (arg <- args) {
        val (newArg, argTypeOpt) = checkExp(None(), scope, arg, reporter)
        argTypeOpt match {
          case Some(argType) => argTypes = argTypes :+ argType
          case _ =>
        }
        newArgs = newArgs :+ newArg
      }
      val attr = printExp.attr(typedOpt = Some(AST.Typed.Fun(F, F, argTypes, AST.Typed.unit)), resOpt = resOpt)
      return (printExp(args = newArgs, attr = attr), AST.Typed.unitOpt)
    }

    def checkHalt(haltExp: AST.Exp.Invoke, args: ISZ[AST.Exp]): (AST.Exp, Option[AST.Typed]) = {
      if (args.size != 1) {
        reporter.error(haltExp.posOpt, typeCheckerKind, s"Expecting one argument, but ${args.size} found.")
        return (haltExp(attr = haltExp.attr(resOpt = haltResOpt, typedOpt = haltTypedOpt)), AST.Typed.nothingOpt)
      }
      val (newArg, _) = checkExp(AST.Typed.stringOpt, scope, args(0), reporter)
      return (
        haltExp(args = ISZ(newArg), attr = haltExp.attr(resOpt = haltResOpt, typedOpt = haltTypedOpt)),
        AST.Typed.nothingOpt
      )
    }

    def checkUnary(exp: AST.Exp.Unary): (AST.Exp, Option[AST.Typed]) = {
      val (newExp, expTypeOpt) = checkExp(None(), scope, exp.exp, reporter)
      val newUnaryExp = exp(exp = newExp)
      expTypeOpt match {
        case Some(expType) =>
          val kindOpt = basicKind(scope, expType, exp.posOpt, reporter)
          kindOpt match {
            case Some(kind) =>
              if (exp.op == AST.Exp.UnaryOp.Not && kind != BasicKind.B) {
                reporter.error(exp.posOpt, typeCheckerKind, st"Undefined unary operation ! on '$expType'.".render)
                return (newUnaryExp, None())
              }
              if (exp.op == AST.Exp.UnaryOp.Complement &&
                !(kind == BasicKind.B || kind == BasicKind.Bits)) {
                reporter.error(exp.posOpt, typeCheckerKind, st"Undefined unary operation ~ on '$expType'.".render)
                return (newUnaryExp, None())
              }
              var r = newUnaryExp
              val tOpt: Option[AST.Typed] = Some(expType)
              r = r(attr = r.attr(typedOpt = tOpt, resOpt = unopResOpt.get(exp.op).get))
              return (r, tOpt)
            case _ =>
              val (typedOpt, resOpt) =
                checkSelectH(expType, AST.Id(AST.Util.unopId(exp.op), AST.Attr(exp.posOpt)), F)
              return (exp(exp = newExp, attr = exp.attr(resOpt = resOpt, typedOpt = typedOpt)), typedOpt)
          }
        case _ =>
      }
      return (newExp, None())
    }

    def checkBinary(exp: AST.Exp.Binary): (AST.Exp, Option[AST.Typed]) = {
      val rep = AccumulatingReporter.create
      val (newLeft, leftTypeOpt) = checkExp(None(), scope, exp.left, rep)
      if (leftTypeOpt.isEmpty) {
        return (exp(left = newLeft), None())
      }
      val leftType = leftTypeOpt.get

      def errIncompat(rt: AST.Typed): Unit = {
        reporter.error(
          exp.posOpt,
          typeCheckerKind,
          st"Incompatible types for binary operation '$leftType' ${exp.op} '$rt'.".render
        )
      }

      if (exp.op == AST.Exp.BinaryOp.Eq || exp.op == AST.Exp.BinaryOp.Ne) {
        reporter.reports(rep.messages)
        val (right, rightTypeOpt) = checkExp(None(), scope, exp.right, reporter)
        rightTypeOpt match {
          case Some(rightType) =>
            val isCompat = typeHierarchy.isCompatible(leftType, rightType)
            if (!isCompat) {
              errIncompat(rightType)
            }
          case _ =>
        }
        return (
          exp(
            left = newLeft,
            right = right,
            attr = exp.attr(resOpt = binopResOpt.get(exp.op).get, typedOpt = AST.Typed.bOpt)
          ),
          AST.Typed.bOpt
        )
      } else if (exp.op == AST.Exp.BinaryOp.MapsTo) {
        reporter.reports(rep.messages)
        val (right, rightTypeOpt) = checkExp(None(), scope, exp.right, reporter)
        val tOpt: Option[AST.Typed] = rightTypeOpt match {
          case Some(rightType) => Some(AST.Typed.Tuple(ISZ(leftType, rightType)))
          case _ => None()
        }
        return (
          exp(left = newLeft, right = right, attr = exp.attr(resOpt = binopResOpt.get(exp.op).get, typedOpt = tOpt)),
          tOpt
        )
      }

      val lOpt = basicKind(scope, leftType, exp.left.posOpt, reporter)

      lOpt match {
        case Some(leftKind) =>
          reporter.reports(rep.messages)
          val (newRight, rightTypeOpt) = checkExp(None(), scope, exp.right, reporter)

          rightTypeOpt match {
            case Some(rightType) =>
              def errUndef(): Unit = {
                reporter
                  .error(exp.posOpt, typeCheckerKind, st"Undefined binary operation ${exp.op} on '$leftType'".render)
              }

              val rOpt = basicKind(scope, rightType, exp.right.posOpt, reporter)
              val tOpt: Option[AST.Typed] = rOpt match {
                case Some(rightKind) =>
                  if (leftKind != rightKind) {
                    errIncompat(rightType)
                    None()
                  } else if ((leftKind == BasicKind.B && AST.Util.isBoolBinop(exp.op)) ||
                    (AST.Util.isArithBinop(exp.op) && leftKind != BasicKind.B) ||
                    (AST.Util.isBitsBinop(exp.op) && (leftKind == BasicKind.Bits || leftKind == BasicKind.C))) {
                    Some(leftType)
                  } else if (AST.Util.isCompareBinop(exp.op) && leftKind != BasicKind.B) {
                    Some(AST.Typed.b)
                  } else {
                    errUndef()
                    None()
                  }
                case _ =>
                  errIncompat(rightType)
                  None()
              }
              return (
                exp(
                  left = newLeft,
                  right = newRight,
                  attr = exp.attr(resOpt = binopResOpt.get(exp.op).get, typedOpt = tOpt)
                ),
                tOpt
              )

            case _ => return (exp(left = newLeft, right = newRight), None())
          }
        case _ =>
          if (ops.StringOps(exp.op).endsWith(":")) {
            val (newInvoke, tOpt) = checkInvoke(
              AST.Exp.Invoke(Some(exp.right), AST.Id(exp.op, AST.Attr(exp.posOpt)), ISZ(), ISZ(exp.left), exp.attr)
            )
            newInvoke match {
              case newInvoke: AST.Exp.Invoke =>
                return (exp(left = newInvoke.args(0), right = newInvoke.receiverOpt.get, attr = newInvoke.attr), tOpt)
              case _ => halt("Unexpected situation when type checking binary expression.")
            }
          } else {
            val (newInvoke, tOpt) = checkInvoke(
              AST.Exp.Invoke(Some(exp.left), AST.Id(exp.op, AST.Attr(exp.posOpt)), ISZ(), ISZ(exp.right), exp.attr)
            )
            newInvoke match {
              case newInvoke: AST.Exp.Invoke =>
                return (exp(left = newInvoke.receiverOpt.get, right = newInvoke.args(0), attr = newInvoke.attr), tOpt)
              case _ => halt("Unexpected situation when type checking binary expression.")
            }
          }
      }
    }

    def checkTuple(exp: AST.Exp.Tuple): (AST.Exp, Option[AST.Typed]) = {
      var newArgs = ISZ[AST.Exp]()
      var argTypes = ISZ[AST.Typed]()
      var ok = T
      for (arg <- exp.args) {
        val (newArg, argTypeOpt) = checkExp(None(), scope, arg, reporter)
        newArgs = newArgs :+ newArg
        argTypeOpt match {
          case Some(argType) => argTypes = argTypes :+ argType
          case _ => ok = F
        }
      }
      var r = exp
      r = r(args = newArgs)
      if (!ok) {
        return (r, None())
      }
      val t: AST.Typed = AST.Typed.Tuple(argTypes)
      val tOpt: Option[AST.Typed] = Some(t)
      r = r(attr = r.attr(typedOpt = tOpt))
      return (r, tOpt)
    }

    def checkStringInterpolate(exp: AST.Exp.StringInterpolate): (AST.Exp, Option[AST.Typed]) = {
      var args = ISZ[AST.Exp]()
      var argTypes = ISZ[AST.Typed]()
      var ok = T
      for (arg <- exp.args) {
        val (newArg, argTypeOpt) = checkExp(None(), scope, arg, reporter)
        args = args :+ newArg
        argTypeOpt match {
          case Some(argType) => argTypes = argTypes :+ argType
          case _ => ok = F
        }
      }
      exp.prefix.native match {
        case "s" => return (exp(args = args, attr = exp.attr(typedOpt = AST.Typed.stringOpt)), Some(AST.Typed.string))
        case "st" => return (exp(args = args, attr = exp.attr(typedOpt = AST.Typed.stOpt)), Some(AST.Typed.st))
        case _ =>
          val tOpt = checkStringInterpolator(exp.posOpt, scope, exp.prefix, reporter)
          tOpt match {
            case Some(_) => return (exp(args = args, attr = exp.attr(typedOpt = tOpt)), tOpt)
            case _ => return (exp(args = args), None())
          }
      }
    }

    def checkEtaH(
      t: AST.Typed,
      ref: AST.Exp.Ref,
      typeArgs: ISZ[AST.Typed],
      etaParentOpt: Option[AST.Exp.Eta]
    ): (AST.Exp, Option[AST.Typed]) = {

      val exp = ref.asExp

      def noResult: (AST.Exp, Option[AST.Typed]) = {
        return (exp, None())
      }

      t match {
        case t: AST.Typed.Method =>
          val substMap: HashMap[String, AST.Typed] =
            if (typeArgs.isEmpty && t.typeParams.nonEmpty && t.tpe.isByName) {
              expectedOpt match {
                case Some(expected) =>
                  val smOpt =
                    unify(exp.posOpt, T, expected, t.tpe.ret, reporter)
                  smOpt match {
                    case Some(sm) =>
                      val ok = checkUnboundTypeVar(exp.posOpt, t, sm, t.typeParams, reporter)
                      if (!ok) {
                        return noResult
                      }
                      sm
                    case _ => return noResult
                  }
                case _ =>
                  reporter.error(exp.posOpt, typeCheckerKind, s"Explicit type arguments are required.")
                  return noResult
              }
            } else {
              if (t.typeParams.size != typeArgs.size) {
                reporter.error(
                  exp.posOpt,
                  typeCheckerKind,
                  s"Expecting ${t.typeParams.size} type arguments, but ${typeArgs.size} found."
                )
                return noResult
              }
              var sm = HashMap.emptyInit[String, AST.Typed](typeArgs.size)
              val size = typeArgs.size
              var i = 0
              while (i < size) {
                sm = sm + t.typeParams(i) ~> typeArgs(i)
                i = i + 1
              }
              sm
            }
          if (ref.targs.nonEmpty) {
            etaParentOpt match {
              case Some(etaParent) =>
                val tpe: AST.Typed =
                  if (t.tpe.isByName) t.tpe(isByName = F) else t.tpe
                val tOpt = Some(tpe.subst(substMap))
                return (etaParent(ref = ref, attr = etaParent.attr(typedOpt = tOpt)), tOpt)
              case _ if t.tpe.isByName =>
                return (exp, Some(t.tpe.ret.subst(substMap)))
              case _ =>
                reporter.error(
                  exp.posOpt,
                  typeCheckerKind,
                  "Method access has to be explicitly eta-expanded to become a function using '_'."
                )
                return noResult
            }
          } else {
            etaParentOpt match {
              case Some(etaParent) =>
                val tOpt: Option[AST.Typed] = Some(if (t.tpe.isByName) t.tpe(isByName = F) else t.tpe)
                return (etaParent(ref = ref, attr = etaParent.attr(typedOpt = tOpt)), tOpt)
              case _ if t.tpe.isByName => return (exp, Some(t.tpe.ret.subst(substMap)))
              case _ =>
                reporter.error(
                  exp.posOpt,
                  typeCheckerKind,
                  "Method access has to be explicitly eta-expanded to become a function using '_'."
                )
                return noResult
            }
          }
        case _ =>
          if (ref.targs.nonEmpty) {
            reporter.error(exp.posOpt, typeCheckerKind, s"Cannot supply type arguments on '$t'.")
            return noResult
          } else {
            etaParentOpt match {
              case Some(_) =>
                reporter.error(exp.posOpt, typeCheckerKind, s"Cannot eta-expand non-method '$t'.")
                return noResult
              case _ => return (exp, Some(t))
            }
          }
      }
    }

    def checkSelectH(
      receiverType: AST.Typed,
      ident: AST.Id,
      hasTypeArgs: B
    ): (Option[AST.Typed], Option[AST.ResolvedInfo]) = {
      val id = ident.value
      id.native match {
        case "apply" => return (Some(receiverType), applyResOpt)
        case _ =>
      }

      @pure def noResult: (Option[AST.Typed], Option[AST.ResolvedInfo]) = {
        return (None(), None())
      }

      def errAccess(t: AST.Typed): Unit = {
        reporter.error(ident.attr.posOpt, typeCheckerKind, s"'$id' is not a member of type '$t'.")
      }

      def checkAccess(t: AST.Typed): (Option[AST.Typed], Option[AST.ResolvedInfo]) = {
        id.native match {
          case "string" => return (AST.Typed.stringOpt, stringResOpt)
          case "hash" => return (AST.Typed.zOpt, hashResOpt)
          case _ =>
            t match {
              case t: AST.Typed.Name if t.args.isEmpty =>
                typeHierarchy.typeMap.get(t.ids) match {
                  case Some(info: TypeInfo.Enum) =>
                    id.native match {
                      case "name" => return (info.nameTypedOpt, TypeInfo.Enum.nameResOpt)
                      case "ordinal" => return (info.ordinalTypedOpt, TypeInfo.Enum.ordinalResOpt)
                      case _ =>
                    }
                  case _ =>
                }
              case _ =>
            }
            errAccess(t)
            return noResult
        }
      }

      def errTypeArgs(t: AST.Typed): Unit = {
        reporter.error(ident.attr.posOpt, typeCheckerKind, s"Member '$id' of type '$t' does not accept type arguments.")
      }

      receiverType match {
        case receiverType: AST.Typed.Name =>
          typeHierarchy.typeMap.get(receiverType.ids).get match {
            case info: TypeInfo.Sig =>
              val r = info.typeRes(id, inSpec)
              r._1 match {
                case Some(rt) =>
                  val smOpt =
                    buildTypeSubstMap(info.name, ident.attr.posOpt, info.ast.typeParams, receiverType.args, reporter)
                  smOpt match {
                    case Some(sm) => return (Some(rt.subst(sm)), r._2)
                    case _ => return noResult
                  }
                case _ => val res = checkAccess(receiverType); return res
              }
            case info: TypeInfo.AbstractDatatype =>
              val r = info.typeRes(id, inSpec)
              r._1 match {
                case Some(rt) =>
                  val smOpt =
                    buildTypeSubstMap(info.name, ident.attr.posOpt, info.ast.typeParams, receiverType.args, reporter)
                  smOpt match {
                    case Some(sm) => return (Some(rt.subst(sm)), r._2)
                    case _ => return noResult
                  }
                case _ => val res = checkAccess(receiverType); return res
              }
            case _ => val res = checkAccess(receiverType); return res
          }
        case receiverType: AST.Typed.Tuple =>
          if (id.size == 0 || ops.StringOps(id).first != '_') {
            val res = checkAccess(receiverType)
            return res
          }
          Z(ops.StringOps(id).substring(1, id.size)) match {
            case Some(n) =>
              val size = receiverType.args.size
              if (!(0 < n && n <= size)) {
                errAccess(receiverType)
                return noResult
              }
              if (hasTypeArgs) {
                errTypeArgs(receiverType)
                return noResult
              }
              return (Some(receiverType.args(n - 1)), Some(AST.ResolvedInfo.Tuple(size, n)))
            case _ =>
              errAccess(receiverType)
              return noResult
          }
        case receiverType: AST.Typed.Fun =>
          errAccess(receiverType)
          return noResult
        case receiverType: AST.Typed.Package =>
          val r = checkInfoOpt(typeHierarchy.nameMap.get(receiverType.name :+ id))
          if (r._1.isEmpty) {
            reporter.error(
              ident.attr.posOpt,
              typeCheckerKind,
              st"'$id' is not a member of package '${(receiverType.name, ".")}'.".render
            )
          }
          return r
        case receiverType: AST.Typed.Object =>
          val r = checkInfoOpt(typeHierarchy.nameMap.get(receiverType.name :+ id))
          if (r._1.isEmpty) {
            reporter.error(
              ident.attr.posOpt,
              typeCheckerKind,
              st"'$id' is not a member of object '${(receiverType.name, ".")}'.".render
            )
          }
          return r
        case receiverType: AST.Typed.Enum =>
          typeHierarchy.nameMap.get(receiverType.name) match {
            case Some(info: Info.Enum) =>
              id.native match {
                case "byName" => return (info.byNameTypedOpt, Info.Enum.byNameResOpt)
                case "byOrdinal" => return (info.byOrdinalTypedOpt, Info.Enum.byOrdinalResOpt)
                case _ =>
              }
              info.elements.get(id) match {
                case Some(resOpt) =>
                  if (hasTypeArgs) {
                    errTypeArgs(receiverType)
                    return noResult
                  }
                  return (info.elementTypedOpt, resOpt)
                case _ =>
                  errAccess(receiverType)
                  return noResult
              }
            case _ =>
              halt("Unexpected situation while type checking enum access.")
          }
        case receiverType: AST.Typed.Method =>
          errAccess(receiverType)
          return noResult
        case receiverType: AST.Typed.Methods =>
          errAccess(receiverType)
          return noResult
        case receiverType: AST.Typed.TypeVar => val res = checkAccess(receiverType); return res
      }
    }

    def checkId(id: AST.Id): (Option[AST.Typed], Option[AST.ResolvedInfo]) = {
      scope.resolveName(typeHierarchy.nameMap, ISZ(id.value)) match {
        case Some(info) => return checkInfo(info)
        case _ =>
          scope.thisOpt match {
            case Some(t) => val r = checkSelectH(t, id, F); return r
            case _ =>
              reporter.error(id.attr.posOpt, typeCheckerKind, s"Could not resolve '${id.value}'.")
              return (None(), None())
          }

      }
    }

    def checkIdent(exp: AST.Exp.Ident, etaParentOpt: Option[AST.Exp.Eta]): (AST.Exp, Option[AST.Typed]) = {
      val (typedOpt, resOpt) = checkId(exp.id)
      val newExp = exp(attr = exp.attr(typedOpt = typedOpt, resOpt = resOpt))
      if (typedOpt.isEmpty) {
        return (newExp, typedOpt)
      }
      val r = checkEtaH(typedOpt.get, newExp, ISZ(), etaParentOpt)
      return r
    }

    def checkTypeArgs(tas: ISZ[AST.Type]): Option[(ISZ[AST.Typed], ISZ[AST.Type])] = {
      var typeArgs = ISZ[AST.Typed]()
      var newTargs = ISZ[AST.Type]()
      for (targ <- tas) {
        val tipeOpt = typeHierarchy.typed(scope, targ, reporter)
        tipeOpt match {
          case Some(tipe) if tipe.typedOpt.nonEmpty =>
            typeArgs = typeArgs :+ tipe.typedOpt.get
            newTargs = newTargs :+ tipe
          case _ =>
            return None()
        }
      }
      return Some((typeArgs, newTargs))
    }

    def checkSelect(exp: AST.Exp.Select, etaParentOpt: Option[AST.Exp.Eta]): (AST.Exp, Option[AST.Typed]) = {
      val (typeArgs, newTargs): (ISZ[AST.Typed], ISZ[AST.Type]) = {
        val pOpt = checkTypeArgs(exp.targs)
        if (pOpt.nonEmpty) {
          pOpt.get
        } else {
          return (exp, None())
        }
      }

      val (newExp, typedOpt): (AST.Exp.Select, Option[AST.Typed]) = {
        exp.receiverOpt match {
          case Some(receiver) =>
            val (newReceiver, receiverTypeOpt) =
              checkExp(None(), scope, receiver, reporter)
            receiverTypeOpt match {
              case Some(receiverType) =>
                val (typedOpt, resOpt) =
                  checkSelectH(receiverType, exp.id, exp.targs.nonEmpty)
                (
                  exp(
                    targs = newTargs,
                    receiverOpt = Some(newReceiver),
                    attr = exp.attr(typedOpt = typedOpt, resOpt = resOpt)
                  ),
                  typedOpt
                )
              case _ =>
                (exp(targs = newTargs, receiverOpt = Some(newReceiver)), None[AST.Typed]())
            }
          case _ =>
            val (typedOpt, resOpt) = checkId(exp.id)
            (exp(targs = newTargs, attr = exp.attr(typedOpt = typedOpt, resOpt = resOpt)), typedOpt)
        }
      }

      if (typedOpt.isEmpty) {
        return (newExp, typedOpt)
      }

      val r = checkEtaH(typedOpt.get, newExp, typeArgs, etaParentOpt)
      return r
    }

    def checkInvokeType(
      posOpt: Option[AST.PosInfo],
      resOpt: Option[AST.ResolvedInfo],
      typed: AST.Typed,
      numOfArgs: Z,
      argNames: ISZ[String]
    ): (Option[AST.Typed], Option[AST.ResolvedInfo]) = {
      val tpe: AST.Typed = typed match {
        case typed: AST.Typed.Method if typed.tpe.isByName => typed.tpe.ret
        case _ => typed
      }
      tpe match {
        case tpe: AST.Typed.Object =>
          AST.Typed.basicConstructorMap.get(tpe.name) match {
            case Some(r @ (_, _)) => return r
            case _ =>
              tpe.name match {
                case AST.Typed.`isName` =>
                  val indexTypeVar = AST.Typed.TypeVar("I")
                  val valueTypeVar = AST.Typed.TypeVar("V")
                  val argTypes: ISZ[AST.Typed] = for (_ <- z"0" until numOfArgs)
                    yield valueTypeVar
                  val constructorType =
                    AST.Typed.Fun(T, F, argTypes, AST.Typed.Name(AST.Typed.isName, ISZ(indexTypeVar, valueTypeVar)))
                  val typeParams = ISZ[String]("I", "V")
                  return (
                    Some(
                      AST.Typed.Method(
                        T,
                        AST.MethodMode.Constructor,
                        typeParams,
                        AST.Typed.sireumName,
                        "IS",
                        ISZ(),
                        ISZ(),
                        constructorType
                      )
                    ),
                    Some(
                      AST.ResolvedInfo.Method(
                        T,
                        AST.MethodMode.Constructor,
                        typeParams,
                        AST.Typed.sireumName,
                        "IS",
                        ISZ(),
                        Some(constructorType)
                      )
                    )
                  )
                case AST.Typed.`msName` =>
                  val indexTypeVar = AST.Typed.TypeVar("I")
                  val valueTypeVar = AST.Typed.TypeVar("V")
                  val argTypes: ISZ[AST.Typed] =
                    for (_ <- z"0" until numOfArgs) yield valueTypeVar
                  val constructorType: AST.Typed.Fun =
                    AST.Typed.Fun(T, F, argTypes, AST.Typed.Name(AST.Typed.msName, ISZ(indexTypeVar, valueTypeVar)))
                  val typeParams = ISZ[String]("I", "V")
                  return (
                    Some(
                      AST.Typed.Method(
                        T,
                        AST.MethodMode.Constructor,
                        typeParams,
                        AST.Typed.sireumName,
                        "MS",
                        ISZ(),
                        ISZ(),
                        constructorType
                      )
                    ),
                    Some(
                      AST.ResolvedInfo.Method(
                        T,
                        AST.MethodMode.Constructor,
                        typeParams,
                        AST.Typed.sireumName,
                        "MS",
                        ISZ(),
                        Some(constructorType)
                      )
                    )
                  )
                case AST.Typed.`iszName` =>
                  val valueTypeVar = AST.Typed.TypeVar("V")
                  val argTypes: ISZ[AST.Typed] =
                    for (_ <- z"0" until numOfArgs) yield valueTypeVar
                  val constructorType: AST.Typed.Fun =
                    AST.Typed.Fun(T, F, argTypes, AST.Typed.Name(AST.Typed.isName, ISZ(AST.Typed.z, valueTypeVar)))
                  val typeParams = ISZ[String]("V")
                  return (
                    Some(
                      AST.Typed.Method(
                        T,
                        AST.MethodMode.Constructor,
                        typeParams,
                        AST.Typed.sireumName,
                        "IS",
                        ISZ(),
                        ISZ(),
                        constructorType
                      )
                    ),
                    Some(
                      AST.ResolvedInfo.Method(
                        T,
                        AST.MethodMode.Constructor,
                        typeParams,
                        AST.Typed.sireumName,
                        "IS",
                        ISZ(),
                        Some(constructorType)
                      )
                    )
                  )
                case AST.Typed.`mszName` =>
                  val valueTypeVar = AST.Typed.TypeVar("V")
                  val argTypes: ISZ[AST.Typed] =
                    for (_ <- z"0" until numOfArgs) yield valueTypeVar
                  val constructorType: AST.Typed.Fun =
                    AST.Typed.Fun(T, F, argTypes, AST.Typed.Name(AST.Typed.msName, ISZ(AST.Typed.z, valueTypeVar)))
                  val typeParams = ISZ[String]("V")
                  return (
                    Some(
                      AST.Typed.Method(
                        T,
                        AST.MethodMode.Constructor,
                        typeParams,
                        AST.Typed.sireumName,
                        "MS",
                        ISZ(),
                        ISZ(),
                        constructorType
                      )
                    ),
                    Some(
                      AST.ResolvedInfo.Method(
                        T,
                        AST.MethodMode.Constructor,
                        typeParams,
                        AST.Typed.sireumName,
                        "MS",
                        ISZ(),
                        Some(constructorType)
                      )
                    )
                  )
                case AST.Typed.`zsName` =>
                  val argTypes: ISZ[AST.Typed] =
                    for (_ <- z"0" until numOfArgs) yield AST.Typed.z
                  val constructorType: AST.Typed.Fun =
                    AST.Typed.Fun(T, F, argTypes, AST.Typed.Name(AST.Typed.msName, ISZ(AST.Typed.z, AST.Typed.z)))
                  return (
                    Some(
                      AST.Typed.Method(
                        T,
                        AST.MethodMode.Constructor,
                        ISZ(),
                        AST.Typed.sireumName,
                        "IS",
                        ISZ(),
                        ISZ(),
                        constructorType
                      )
                    ),
                    Some(
                      AST.ResolvedInfo.Method(
                        T,
                        AST.MethodMode.Constructor,
                        ISZ(),
                        AST.Typed.sireumName,
                        "IS",
                        ISZ(),
                        Some(constructorType)
                      )
                    )
                  )
                case _ =>
                  typeHierarchy.typeMap.get(tpe.name) match {
                    case Some(info) =>
                      info match {
                        case info: TypeInfo.SubZ =>
                          val t = AST.Typed.Name(tpe.name, ISZ())
                          val constructorType: AST.Typed.Fun =
                            AST.Typed.Fun(T, F, ISZ(AST.Typed.string), AST.Typed.Name(AST.Typed.optionName, ISZ(t)))
                          return (
                            Some(
                              AST.Typed.Method(
                                T,
                                AST.MethodMode.Constructor,
                                ISZ(),
                                info.owner,
                                info.ast.id.value,
                                ISZ(),
                                ISZ(),
                                constructorType
                              )
                            ),
                            Some(
                              AST.ResolvedInfo.Method(
                                T,
                                AST.MethodMode.Constructor,
                                ISZ(),
                                info.owner,
                                info.ast.id.value,
                                ISZ(),
                                Some(constructorType)
                              )
                            )
                          )

                        case info: TypeInfo.AbstractDatatype if !info.ast.isRoot =>
                          info.constructorTypeOpt match {
                            case Some(constructorType) =>
                              return (Some(constructorType), info.constructorResOpt)
                            case _ =>
                              reporter.error(
                                posOpt,
                                typeCheckerKind,
                                st"Cannot create an object of type ${(tpe.name, ".")}.".render
                              )
                              return (None(), None())
                          }
                        case _ =>
                      }
                    case _ =>
                  }
              }
          }
        case tpe: AST.Typed.Name =>
          tpe.ids match {
            case AST.Typed.`isName` if tpe.args.size == 2 =>
              if (numOfArgs == 1) {
                val indexType = tpe.args(0)
                val valueType = tpe.args(1)
                val tupleVars = AST.Typed.Tuple(ISZ(indexType, valueType))
                val storeType = AST.Typed.Fun(T, F, ISZ(tupleVars), tpe)
                val selectType = AST.Typed.Fun(T, F, ISZ(indexType), valueType)
                return (
                  Some(
                    AST.Typed.Methods(
                      ISZ(
                        AST.Typed.Method(
                          F,
                          AST.MethodMode.Select,
                          ISZ(),
                          AST.Typed.sireumName,
                          "IS",
                          ISZ(),
                          ISZ(),
                          selectType
                        ),
                        AST.Typed
                          .Method(F, AST.MethodMode.Store, ISZ(), AST.Typed.sireumName, "IS", ISZ(), ISZ(), storeType)
                      )
                    )
                  ),
                  Some(
                    AST.ResolvedInfo.Methods(
                      ISZ(
                        AST.ResolvedInfo
                          .Method(F, AST.MethodMode.Select, ISZ(), AST.Typed.sireumName, "IS", ISZ(), Some(selectType)),
                        AST.ResolvedInfo
                          .Method(F, AST.MethodMode.Store, ISZ(), AST.Typed.sireumName, "IS", ISZ(), Some(storeType))
                      )
                    )
                  )
                )
              } else {
                val indexType = tpe.args(0)
                val valueType = tpe.args(1)
                val tupleVars = AST.Typed.Tuple(ISZ(indexType, valueType))
                val argTypes: ISZ[AST.Typed] = for (_ <- z"0" until numOfArgs)
                  yield tupleVars
                val storeType = AST.Typed.Fun(T, F, argTypes, tpe)
                return (
                  Some(
                    AST.Typed
                      .Method(F, AST.MethodMode.Store, ISZ(), AST.Typed.sireumName, "IS", ISZ(), ISZ(), storeType)
                  ),
                  Some(
                    AST.ResolvedInfo
                      .Method(F, AST.MethodMode.Store, ISZ(), AST.Typed.sireumName, "IS", ISZ(), Some(storeType))
                  )
                )
              }
            case AST.Typed.`msName` if tpe.args.size == 2 =>
              if (numOfArgs == 1) {
                val indexType = tpe.args(0)
                val valueType = tpe.args(1)
                val tupleVars = AST.Typed.Tuple(ISZ(indexType, valueType))
                val storeType = AST.Typed.Fun(T, F, ISZ(tupleVars), tpe)
                val selectType = AST.Typed.Fun(T, F, ISZ(indexType), valueType)
                return (
                  Some(
                    AST.Typed.Methods(
                      ISZ(
                        AST.Typed.Method(
                          F,
                          AST.MethodMode.Select,
                          ISZ(),
                          AST.Typed.sireumName,
                          "MS",
                          ISZ(),
                          ISZ(),
                          selectType
                        ),
                        AST.Typed
                          .Method(F, AST.MethodMode.Store, ISZ(), AST.Typed.sireumName, "MS", ISZ(), ISZ(), storeType)
                      )
                    )
                  ),
                  Some(
                    AST.ResolvedInfo.Methods(
                      ISZ(
                        AST.ResolvedInfo
                          .Method(F, AST.MethodMode.Select, ISZ(), AST.Typed.sireumName, "MS", ISZ(), Some(selectType)),
                        AST.ResolvedInfo
                          .Method(F, AST.MethodMode.Store, ISZ(), AST.Typed.sireumName, "MS", ISZ(), Some(storeType))
                      )
                    )
                  )
                )
              } else {
                val indexType = tpe.args(0)
                val valueType = tpe.args(1)
                val tupleVars = AST.Typed.Tuple(ISZ(indexType, valueType))
                val argTypes: ISZ[AST.Typed] = for (_ <- z"0" until numOfArgs)
                  yield tupleVars
                val storeType = AST.Typed.Fun(T, F, argTypes, tpe)
                return (
                  Some(
                    AST.Typed
                      .Method(F, AST.MethodMode.Store, ISZ(), AST.Typed.sireumName, "MS", ISZ(), ISZ(), storeType)
                  ),
                  Some(
                    AST.ResolvedInfo
                      .Method(F, AST.MethodMode.Store, ISZ(), AST.Typed.sireumName, "MS", ISZ(), Some(storeType))
                  )
                )
              }
            case _ =>
              typeHierarchy.typeMap.get(tpe.ids) match {
                case Some(info: TypeInfo.AbstractDatatype) if !info.ast.isRoot =>
                  val params: ISZ[AST.AbstractDatatypeParam] = if (argNames.isEmpty) {
                    info.ast.params
                  } else {
                    val argNameSet = HashSSet.emptyInit[String](argNames.size) ++ argNames
                    val ps = info.ast.params.withFilter(p => argNameSet.contains(p.id.value))
                    if (argNameSet.size != ps.size) {
                      val names = argNameSet -- info.ast.params.map(p => p.id.value)
                      reporter.error(
                        posOpt,
                        typeCheckerKind,
                        st"Could not find parameter(s) '${(names.elements, "', '")}' in '$tpe'.".render
                      )
                      return (None(), resOpt)
                    } else if (ps.size == 0 && info.ast.params.size != 0) {
                      reporter
                        .error(posOpt, typeCheckerKind, st"Cannot perform copy of '$tpe' without argument.".render)
                      return (None(), resOpt)
                    }
                    ps
                  }
                  val paramNames = params.map(p => p.id.value)
                  val paramTypes = params.map(p => p.tipe.typedOpt.get)
                  val smOpt = unify(posOpt, F, tpe, info.tpe, reporter)
                  smOpt match {
                    case Some(sm) =>
                      val copyType = AST.Typed.Fun(T, F, paramTypes, tpe).subst(sm)
                      val id = info.ast.id.value
                      return (
                        Some(
                          AST.Typed.Method(F, AST.MethodMode.Copy, ISZ(), info.owner, id, paramNames, ISZ(), copyType)
                        ),
                        Some(
                          AST.ResolvedInfo
                            .Method(F, AST.MethodMode.Copy, ISZ(), info.owner, id, paramNames, Some(copyType))
                        )
                      )
                    case _ => return (None(), resOpt)
                  }
              }
          }
        case _ =>
      }
      return (Some(tpe), resOpt)
    }

    def checkInvokeGenH(
      m: AST.Typed.Method,
      expId: AST.Id,
      expArgs: ISZ[AST.Exp],
      typeArgs: ISZ[AST.Typed],
      rep: Reporter,
      make: (ISZ[AST.Exp], Option[AST.Typed]) => AST.Exp @pure
    ): (AST.Exp, Option[AST.Typed]) = {

      @pure def partResult: (AST.Exp, Option[AST.Typed]) = {
        return (make(expArgs, None()), None())
      }

      def checkH(sm: HashMap[String, AST.Typed]): (AST.Exp, Option[AST.Typed]) = {
        val funType = m.tpe.subst(sm)
        var i = 0
        val size = expArgs.size
        if (m.paramNames.isEmpty) {
          var args = ISZ[AST.Exp]()
          while (i < size) {
            val (newArg, _) =
              checkExp(Some(funType.args(i)), scope, expArgs(i), rep)
            args = args :+ newArg
            i = i + 1
          }
          return (make(args, Some(funType.ret)), Some(funType.ret))
        } else {
          var args = Map.empty[String, AST.Exp]
          while (i < size) {
            val (newArg, _) =
              checkExp(Some(funType.args(i)), scope, expArgs(i), rep)
            args = args + m.paramNames(i) ~> newArg
            i = i + 1
          }
          return (make(args.values, Some(funType.ret)), Some(funType.ret))
        }
      }

      if (typeArgs.isEmpty && m.typeParams.nonEmpty) {
        val repExpected = AccumulatingReporter.create
        def tryExpected(): (AST.Exp, Option[AST.Typed]) = {
          expectedOpt match {
            case Some(expected) =>
              val smOpt = unify(expId.attr.posOpt, T, expected, m.tpe.ret, repExpected)
              smOpt match {
                case Some(sm) =>
                  val ok = checkUnboundTypeVar(expId.attr.posOpt, m, sm, m.typeParams, repExpected)
                  if (!ok) {
                    return partResult
                  }
                  val r = checkH(sm)
                  return r
                case _ => return partResult
              }
            case _ => return partResult
          }
        }
        val rExpected = tryExpected()
        if (rExpected._2.nonEmpty) {
          return rExpected
        }
        val repArgs = AccumulatingReporter.create
        def tryArgs(): (AST.Exp, Option[AST.Typed]) = {
          var newArgs = ISZ[AST.Exp]()
          var argTypes = ISZ[AST.Typed]()
          for (e <- expArgs) {
            val (newArg, argTypeOpt) = checkExp(None(), scope, e, repArgs)
            newArgs = newArgs :+ newArg
            argTypeOpt match {
              case Some(argType) => argTypes = argTypes :+ argType
              case _ =>
            }
          }

          val smOpt = unifies(expId.attr.posOpt, T, argTypes, m.tpe.args, repArgs)
          smOpt match {
            case Some(sm) =>
              val ok = checkUnboundTypeVar(expId.attr.posOpt, m, sm, m.typeParams, repArgs)
              if (!ok) {
                return (make(newArgs, None()), None())
              }
              val funType = m.tpe.subst(sm)
              return (make(newArgs, Some(funType.ret)), Some(funType.ret))
            case _ =>
              return (make(newArgs, None()), None())
          }
        }
        val rArgs = tryArgs()
        if (rArgs._2.nonEmpty) {
          return rArgs
        }
        if (repArgs.hasIssue) {
          rep.reports(repArgs.messages)
        } else {
          rep.reports(repExpected.messages)
        }
        return rArgs
      } else {
        val smOpt = buildMethodSubstMap(m, expId.attr.posOpt, typeArgs, rep)
        smOpt match {
          case Some(sm) =>
            val ok = checkUnboundTypeVar(expId.attr.posOpt, m, sm, m.typeParams, rep)
            if (!ok) {
              return partResult
            }
            val r = checkH(sm)
            return r
          case _ => return partResult
        }
      }
    }

    def checkInvoke(exp: AST.Exp.Invoke): (AST.Exp, Option[AST.Typed]) = {
      val (typeArgs, newTargs): (ISZ[AST.Typed], ISZ[AST.Type]) = {
        val pOpt = checkTypeArgs(exp.targs)
        if (pOpt.nonEmpty) {
          pOpt.get
        } else {
          return (exp, None())
        }
      }

      def checkInvokeH(
        tOpt: Option[AST.Typed],
        rOpt: Option[AST.ResolvedInfo],
        receiverOpt: Option[AST.Exp]
      ): (AST.Exp, Option[AST.Typed]) = {

        @pure def partResult: (AST.Exp, Option[AST.Typed]) = {
          return (exp(targs = newTargs, receiverOpt = receiverOpt), None())
        }

        val (t, resOpt): (AST.Typed, Option[AST.ResolvedInfo]) = tOpt match {
          case Some(tpe) =>
            val (t2Opt, newResOpt) =
              checkInvokeType(exp.id.attr.posOpt, rOpt, tpe, exp.args.size, ISZ())
            t2Opt match {
              case Some(t2) => (t2, newResOpt)
              case _ => return partResult
            }
          case _ => return partResult
        }

        def checkInvokeMethod(
          m: AST.Typed.Method,
          mResOpt: Option[AST.ResolvedInfo],
          rep: Reporter
        ): (AST.Exp, Option[AST.Typed]) = {
          if (m.tpe.isByName) {
            reporter.error(exp.id.attr.posOpt, typeCheckerKind, s"$m does not accept any argument.")
            return partResult
          } else if (m.tpe.args.size != exp.args.size) {
            reporter.error(
              exp.id.attr.posOpt,
              typeCheckerKind,
              s"$m is expecting ${m.tpe.args.size} argument(s), but ${exp.args.size} found."
            )
            return partResult
          }

          @pure def make(eArgs: ISZ[AST.Exp], tpeOpt: Option[AST.Typed]): AST.Exp = {
            return exp(
              receiverOpt = receiverOpt,
              targs = newTargs,
              args = eArgs,
              attr = exp.attr(typedOpt = tpeOpt, resOpt = mResOpt)
            )
          }

          val r = checkInvokeGenH(m, exp.id, exp.args, typeArgs, rep, make _)
          return r
        }

        t match {
          case m: AST.Typed.Methods =>
            val res: AST.ResolvedInfo.Methods = resOpt match {
              case Some(r: AST.ResolvedInfo.Methods) if r.methods.size == m.methods.size =>
                r
              case _ =>
                halt(s"Unexpected situation when invoking IS/MS store/select.")
            }
            var messages = ISZ[Reporter.Message]()
            var found = F
            var i = 0
            val size = m.methods.size
            var r = partResult
            while (!found && i < size) {
              val rep = AccumulatingReporter.create
              r = checkInvokeMethod(m.methods(i), Some(res.methods(i)), rep)
              if (!rep.hasIssue) {
                found = T
              } else {
                messages = messages ++ rep.messages
              }
              i = i + 1
            }
            if (found) {
              return r
            } else {
              reporter.reports(messages)
              return partResult
            }
          case m: AST.Typed.Method =>
            val r = checkInvokeMethod(m, resOpt, reporter); return r
          case t: AST.Typed.Fun =>
            if (exp.targs.nonEmpty) {
              reporter
                .error(exp.id.attr.posOpt, typeCheckerKind, s"Cannot supply type arguments when applying a function.")
              return partResult
            }
            val size = exp.args.size
            if (t.args.size != size) {
              reporter.error(
                exp.id.attr.posOpt,
                typeCheckerKind,
                s"Function '$t' is expecting $size arguments, but $size found."
              )
              return partResult
            }
            var i = 0
            var newArgs = ISZ[AST.Exp]()
            while (i < size) {
              val (newArg, _) =
                checkExp(Some(t.args(i)), scope, exp.args(i), reporter)
              newArgs = newArgs :+ newArg
              i = i + 1
            }
            return (
              exp(args = newArgs, receiverOpt = receiverOpt, attr = exp.attr(resOpt = resOpt, typedOpt = Some(t))),
              Some(t.ret)
            )
          case _ =>
            reporter.error(exp.id.attr.posOpt, typeCheckerKind, s"Cannot invoke on '$t'.")
            return partResult
        }
      }

      exp.receiverOpt match {
        case Some(receiver) =>
          val (newReceiver, receiverTypeOpt) =
            checkExp(None(), scope, receiver, reporter)
          val receiverType: AST.Typed = receiverTypeOpt match {
            case Some(t) => t
            case _ =>
              return (exp(targs = newTargs, receiverOpt = Some(newReceiver)), None())
          }
          val (typedOpt, resOpt) =
            checkSelectH(receiverType, exp.id, exp.targs.nonEmpty)
          val r = checkInvokeH(typedOpt, resOpt, Some(newReceiver))
          return r
        case _ =>
          val (typedOpt, resOpt) = checkId(exp.id)
          val r = checkInvokeH(typedOpt, resOpt, None())
          return r
      }
    }

    def checkInvokeNamed(exp: AST.Exp.InvokeNamed): (AST.Exp, Option[AST.Typed]) = {
      val (typeArgs, newTargs): (ISZ[AST.Typed], ISZ[AST.Type]) = {
        val pOpt = checkTypeArgs(exp.targs)
        if (pOpt.nonEmpty) {
          pOpt.get
        } else {
          return (exp, None())
        }
      }

      def checkInvokeNamedH(
        tOpt: Option[AST.Typed],
        rOpt: Option[AST.ResolvedInfo],
        receiverOpt: Option[AST.Exp]
      ): (AST.Exp, Option[AST.Typed]) = {

        @pure def partResult: (AST.Exp, Option[AST.Typed]) = {
          return (exp(targs = newTargs, receiverOpt = receiverOpt), None())
        }

        val (t, resOpt): (AST.Typed, Option[AST.ResolvedInfo]) = tOpt match {
          case Some(tpe) =>
            val (t2Opt, newResOpt) =
              checkInvokeType(exp.id.attr.posOpt, rOpt, tpe, exp.args.size, exp.args.map(na => na.id.value))
            t2Opt match {
              case Some(t2) => (t2, newResOpt)
              case _ => return partResult
            }
          case _ => return partResult
        }

        t match {
          case m: AST.Typed.Method =>
            if (m.tpe.args.size != exp.args.size) {
              reporter.error(
                exp.id.attr.posOpt,
                typeCheckerKind,
                s"$m is expecting ${m.tpe.args.size} arguments, but ${exp.args.size} found."
              )
              return partResult
            }

            val nameToIndexMap: HashMap[String, Z] = {
              var r = HashMap.emptyInit[String, Z](m.paramNames.size)
              var i = 0
              for (name <- m.paramNames) {
                r = r + name ~> i
                i = i + 1
              }
              r
            }

            val expArgs: ISZ[AST.Exp] = {
              val size = exp.args.size
              val r = MSZ.create[AST.Exp](size, exp)
              var ok = T
              var defined = HashSet.emptyInit[String](size)
              for (na <- exp.args) {
                val name = na.id.value
                if (defined.contains(name)) {
                  ok = F
                  reporter.error(
                    na.id.attr.posOpt,
                    typeCheckerKind,
                    s"An argument for parameter '$name' has previously been supplied."
                  )
                }
                defined = defined + name
                nameToIndexMap.get(name) match {
                  case Some(n) => r(n) = na.arg
                  case _ =>
                    ok = F
                    reporter.error(na.id.attr.posOpt, typeCheckerKind, s"Could not find parameter '$name' in '$m'.")
                }
                if (!ok) {
                  return partResult
                }
              }
              r.toIS
            }

            @pure def make(eArgs: ISZ[AST.Exp], tpeOpt: Option[AST.Typed]): AST.Exp = {
              val args: ISZ[AST.NamedArg] =
                if (eArgs.size == expArgs.size) {
                  var r = ISZ[AST.NamedArg]()
                  for (na <- exp.args) {
                    val name = na.id.value
                    val index = nameToIndexMap.get(name).get
                    r = r :+ na(arg = eArgs(index), index = index)
                  }
                  r
                } else {
                  exp.args
                }
              return exp(
                receiverOpt = receiverOpt,
                targs = newTargs,
                args = args,
                attr = exp.attr(typedOpt = tpeOpt, resOpt = resOpt)
              )
            }

            val r =
              checkInvokeGenH(m, exp.id, expArgs, typeArgs, reporter, make _)
            return r
          case _: AST.Typed.Fun =>
            reporter
              .error(exp.id.attr.posOpt, typeCheckerKind, s"Cannot supply named arguments when applying a function.")
            return partResult
          case _ =>
            reporter.error(exp.id.attr.posOpt, typeCheckerKind, s"Cannot invoke with named arguments on '$t'.")
            return partResult
        }
      }

      exp.receiverOpt match {
        case Some(receiver) =>
          val (newReceiver, receiverTypeOpt) =
            checkExp(None(), scope, receiver, reporter)
          val receiverType: AST.Typed = receiverTypeOpt match {
            case Some(t) => t
            case _ =>
              return (exp(targs = newTargs, receiverOpt = Some(newReceiver)), None())
          }
          val (typedOpt, resOpt) =
            checkSelectH(receiverType, exp.id, exp.targs.nonEmpty)
          val r = checkInvokeNamedH(typedOpt, resOpt, Some(newReceiver))
          return r
        case _ =>
          val (typedOpt, resOpt) = checkId(exp.id)
          val r = checkInvokeNamedH(typedOpt, resOpt, None())
          return r
      }
    }

    def checkIf(exp: AST.Exp.If): (AST.Exp, Option[AST.Typed]) = {
      val (newCond, _) = checkExp(AST.Typed.bOpt, scope, exp.cond, reporter)
      expectedOpt match {
        case Some(expected) =>
          val (newThenExp, _) = checkExp(Some(expected), scope, exp.thenExp, reporter)
          val (newElseExp, _) = checkExp(Some(expected), scope, exp.elseExp, reporter)
          return (
            exp(cond = newCond, thenExp = newThenExp, elseExp = newElseExp, attr = exp.attr(typedOpt = expectedOpt)),
            expectedOpt
          )
        case _ =>
          val (newThenExp, thenTypeOpt) = checkExp(expectedOpt, scope, exp.thenExp, reporter)
          val (newElseExp, elseTypeOpt) = checkExp(expectedOpt, scope, exp.elseExp, reporter)
          (thenTypeOpt, elseTypeOpt) match {
            case (Some(thenType), Some(elseType)) =>
              val tOpt = typeHierarchy.lub(ISZ(thenType, elseType))
              tOpt match {
                case Some(_) =>
                case _ =>
                  reporter.error(
                    exp.posOpt,
                    typeCheckerKind,
                    st"Could not find a common ancestor for: { '${(ISZ(thenType, elseType), "', '")}' }.".render
                  )
              }
              return (
                exp(cond = newCond, thenExp = newThenExp, elseExp = newElseExp, attr = exp.attr(typedOpt = tOpt)),
                tOpt
              )
            case _ => return (exp(cond = newCond, thenExp = newThenExp, elseExp = newElseExp), None())
          }
      }
    }

    def checkForYield(exp: AST.Exp.ForYield): (AST.Exp, Option[AST.Typed]) = {
      val (newScopeOpt, newEnumGens, indexType, isIS) = checkEnumGens(scope, exp.enumGens, reporter)
      newScopeOpt match {
        case Some(newScope) =>
          val expectedValueOpt: Option[AST.Typed] = expectedOpt match {
            case Some(expected: AST.Typed.Name)
                if expected.ids == AST.Typed.isName || expected.ids == AST.Typed.msName =>
              Some(expected.args(1))
            case _ => None()
          }
          val (newExp, expTypeOpt) = checkExp(expectedValueOpt, newScope, exp.exp, reporter)
          expTypeOpt match {
            case Some(t) =>
              val tOpt: Option[AST.Typed] = Some(
                AST.Typed.Name(if (isIS) AST.Typed.isName else AST.Typed.msName, ISZ(indexType, t))
              )
              return (exp(enumGens = newEnumGens, exp = newExp, attr = exp.attr(typedOpt = tOpt)), tOpt)
            case _ => return (exp(enumGens = newEnumGens, exp = newExp), None())
          }
        case _ => return (exp(enumGens = newEnumGens), None())
      }
    }

    def checkThis(exp: AST.Exp.This): (AST.Exp, Option[AST.Typed]) = {
      scope.thisOpt match {
        case tOpt @ Some(_) => return (exp(attr = exp.attr(typedOpt = tOpt)), tOpt)
        case _ =>
          reporter.error(exp.posOpt, typeCheckerKind, "Cannot access 'this' at this location.")
          return (exp, None())
      }
    }

    def checkSuper(exp: AST.Exp.Super): (AST.Exp, Option[AST.Typed]) = {
      scope.thisOpt match {
        case Some(t: AST.Typed.Name) =>
          val parents: ISZ[AST.Typed] = typeHierarchy.typeMap.get(t.ids) match {
            case Some(info: TypeInfo.AbstractDatatype) => info.ast.parents.map(p => p.typedOpt.get)
            case Some(info: TypeInfo.Sig) => info.ast.parents.map(p => p.typedOpt.get)
            case _ => halt("Unexpected situation when type checking super.")
          }
          exp.idOpt match {
            case Some(id) =>
              var i: Z = 0
              for (p <- parents) {
                p match {
                  case p: AST.Typed.Name if p.ids(p.ids.size - 1) == id.value =>
                    for (j <- i + 1 until parents.size) {
                      parents(j) match {
                        case otherP: AST.Typed.Name if otherP.ids(otherP.ids.size - 1) == id.value =>
                          reporter.error(exp.posOpt, typeCheckerKind, s"Ambiguous super type qualifier '${id.value}'.")
                          return (exp, None())
                        case _ =>
                      }
                    }
                    val tOpt: Option[AST.Typed] = Some(p)
                    return (exp(attr = exp.attr(typedOpt = tOpt)), tOpt)
                  case _ =>
                }
                i = i + 1
              }
              reporter.error(exp.posOpt, typeCheckerKind, s"Could not find super type '${id.value}'.")
              return (exp, None())
            case _ =>
              if (parents.size != 1) {
                reporter.error(exp.posOpt, typeCheckerKind, "Explicit super type identifier is required: super[〈ID〉].")
                return (exp, None())
              } else {
                val tOpt: Option[AST.Typed] = Some(parents(0))
                return (exp(attr = exp.attr(typedOpt = tOpt)), tOpt)
              }
          }
        case _ =>
          reporter.error(exp.posOpt, typeCheckerKind, "Cannot access 'super' at this location.")
          return (exp, None())
      }
    }

    def checkExpH(): (AST.Exp, Option[AST.Typed]) = {
      exp match {

        case exp: AST.Exp.Binary => val r = checkBinary(exp); return r

        case exp: AST.Exp.Eta =>
          exp.ref match {
            case ref: AST.Exp.Ident =>
              val r = checkIdent(ref, Some(exp)); return r
            case ref: AST.Exp.Select =>
              val r = checkSelect(ref, Some(exp)); return r
          }

        case exp: AST.Exp.ForYield => val r = checkForYield(exp); return r

        case exp: AST.Exp.Fun =>
          val pos: AST.PosInfo = exp.posOpt match {
            case Some(p) => p
            case _ =>
              reporter.error(
                exp.posOpt,
                typeCheckerKind,
                "Could not generate lambda expression name due to lack of positional information."
              )
              return (exp, None())
          }
          val r = this(typeHierarchy, context :+ s"$$${pos.beginLine}_${pos.beginColumn}", inSpec)
            .checkFun(expectedOpt, scope, exp, reporter)
          return r

        case exp: AST.Exp.Ident => val r = checkIdent(exp, None()); return r

        case exp: AST.Exp.If => val r = checkIf(exp); return r

        case exp: AST.Exp.Invoke =>
          exp match {
            case exp @ AST.Exp.Invoke(None(), AST.Id(name), targs, args)
                if targs.isEmpty && builtInMethods.contains(name) =>
              val (kind, resOpt): (BuiltInKind.Type, Option[AST.ResolvedInfo]) =
                name.native match {
                  case "assert" => (BuiltInKind.Assertume, assertResOpt)
                  case "assume" => (BuiltInKind.Assertume, assumeResOpt)
                  case "println" => (BuiltInKind.Print, printlnResOpt)
                  case "print" => (BuiltInKind.Print, printResOpt)
                  case "cprintln" => (BuiltInKind.Print, cprintlnResOpt)
                  case "cprint" => (BuiltInKind.Print, cprintResOpt)
                  case "eprintln" => (BuiltInKind.Print, eprintlnResOpt)
                  case "eprint" => (BuiltInKind.Print, eprintResOpt)
                  case "halt" => (BuiltInKind.Halt, haltResOpt)
                  case _ => halt(s"Unimplemented built-in method $name.")
                }
              kind match {
                case BuiltInKind.Assertume =>
                  args.size match {
                    case z"1" =>
                      val r = checkAssertume(resOpt, exp, args(0), None());
                      return r
                    case z"2" =>
                      val r =
                        checkAssertume(resOpt, exp, args(0), Some(args(1)));
                      return r
                    case _ =>
                      reporter
                        .error(exp.posOpt, typeCheckerKind, s"Invalid number of arguments (${args.size}) for $name.")
                      return (exp, None())
                  }
                case BuiltInKind.Print =>
                  val r = checkPrint(resOpt, exp, args); return r
                case BuiltInKind.Halt => val r = checkHalt(exp, args); return r
              }
            case _ => val r = checkInvoke(exp); return r
          }

        case exp: AST.Exp.InvokeNamed =>
          exp match {
            case exp @ AST.Exp.InvokeNamed(None(), AST.Id(name), targs, _)
                if targs.isEmpty && builtInMethods.contains(name) =>
              reporter.error(exp.posOpt, typeCheckerKind, s"Cannot invoke '$name' with named argument(s).")
              return (exp, None())
            case _ => val r = checkInvokeNamed(exp); return r
          }

        case exp: AST.Exp.LitB => return (exp, exp.typedOpt)

        case exp: AST.Exp.LitC => return (exp, exp.typedOpt)

        case exp: AST.Exp.LitF32 => return (exp, exp.typedOpt)

        case exp: AST.Exp.LitF64 => return (exp, exp.typedOpt)

        case exp: AST.Exp.LitR => return (exp, exp.typedOpt)

        case exp: AST.Exp.LitString => return (exp, Some(AST.Typed.string))

        case exp: AST.Exp.LitZ => return (exp, exp.typedOpt)

        case exp: AST.Exp.Quant => halt("Unimplemented") // TODO

        case exp: AST.Exp.Select => val r = checkSelect(exp, None()); return r

        case exp: AST.Exp.StringInterpolate => val r = checkStringInterpolate(exp); return r

        case exp: AST.Exp.Super => val r = checkSuper(exp); return r

        case exp: AST.Exp.This => val r = checkThis(exp); return r

        case exp: AST.Exp.Tuple => val r = checkTuple(exp); return r

        case exp: AST.Exp.Unary => val r = checkUnary(exp); return r
      }
    }

    val r = checkExpH()
    (expectedOpt, r._2) match {
      case (Some(expected), Some(t)) =>
        if (typeHierarchy.isSubType(t, expected)) {
          return r
        } else {
          reporter.error(exp.posOpt, typeCheckerKind, s"Expecting type '$expected', but '$t' found.")
          return (r._1, None())
        }
      case _ =>
        return r
    }

  }

  def checkAssignExp(
    expectedOpt: Option[AST.Typed],
    scope: Scope.Local,
    aexp: AST.AssignExp,
    reporter: Reporter
  ): (AST.AssignExp, Option[AST.Typed]) = {

    val newStmt: AST.Stmt = aexp match {
      case aexp: AST.Stmt.Expr =>
        val r = checkExpr(expectedOpt, scope, aexp, reporter)
        return (r, r.typedOpt)
      case aexp: AST.Stmt.If =>
        val r = checkIf(expectedOpt, scope, aexp, reporter); r
      case aexp: AST.Stmt.Block =>
        val r = checkBlock(expectedOpt, scope, aexp, reporter); r
      case aexp: AST.Stmt.Match =>
        val r = checkMatch(expectedOpt, scope, aexp, reporter); r
      case aexp: AST.Stmt.Return =>
        val (_, r) = checkStmt(scope, aexp, reporter); r
    }

    val newAexp = newStmt.asAssignExp

    def noResult: (AST.AssignExp, Option[AST.Typed]) = {
      return (newAexp, None())
    }

    def errType(): Unit = {
      reporter.error(newStmt.posOpt, typeCheckerKind, s"Could not find a common type for leaf expressions.")
    }

    var types = ISZ[AST.Typed]()
    for (expr <- newAexp.exprs) {
      expr.typedOpt match {
        case Some(t) => types = types :+ t
        case _ => return noResult
      }
    }

    typeHierarchy.lub(types) match {
      case r @ Some(t) =>
        expectedOpt match {
          case Some(expected) =>
            if (typeHierarchy.isSubType(t, expected)) {
              return (newAexp, r)
            } else {
              reporter.error(newStmt.posOpt, typeCheckerKind, s"Expecting type '$expected', but '$t' found")
              return (newAexp, None())
            }
          case _ => return (newAexp, r)
        }

      case _ => errType(); return noResult
    }
  }

  def checkStmts(
    expectedOpt: Option[AST.Typed],
    scope: Scope.Local,
    stmts: ISZ[AST.Stmt],
    reporter: Reporter
  ): (Option[Scope.Local], ISZ[AST.Stmt]) = {
    var newScope = scope
    var newStmts = ISZ[AST.Stmt]()
    val size = stmts.size - 1
    for (i <- z"0" until size) {
      val (newScope2Opt, newStmt) = checkStmt(newScope, stmts(i), reporter)
      newScope2Opt match {
        case Some(newScope2) =>
          newScope = newScope2
          newStmts = newStmts :+ newStmt
        case _ =>
          for (j <- i until stmts.size) {
            newStmts = newStmts :+ stmts(j)
          }
          return (None(), newStmts)
      }
    }

    if (size < 0) {
      return (Some(newScope), newStmts)
    }

    val stmt = stmts(size)

    expectedOpt match {
      case Some(_) =>
        val (r, _) =
          checkAssignExp(expectedOpt, newScope, stmt.asAssignExp, reporter)
        return (Some(newScope), newStmts :+ r.asStmt)
      case _ =>
        val (newScope2Opt, newStmt) = checkStmt(newScope, stmt, reporter)
        newScope2Opt match {
          case Some(newScope2) => return (Some(newScope2), newStmts :+ newStmt)
          case _ => return (None(), newStmts :+ stmt)
        }
    }

    return (Some(newScope), newStmts)
  }

  def checkStmtOpts(scope: Scope.Local, stmtOpts: ISZ[Option[AST.Stmt]], reporter: Reporter): ISZ[Option[AST.Stmt]] = {
    var newScope = scope
    var newStmtOpts = ISZ[Option[AST.Stmt]]()
    for (i <- z"0" until stmtOpts.size) {
      stmtOpts(i) match {
        case Some(stmt) =>
          val (newScope2Opt, newStmt) = checkStmt(newScope, stmt, reporter)
          newScope2Opt match {
            case Some(newScope2) =>
              newScope = newScope2
              newStmtOpts = newStmtOpts :+ Some(newStmt)
            case _ =>
              for (j <- i until stmtOpts.size) {
                newStmtOpts = newStmtOpts :+ stmtOpts(i)
              }
              return newStmtOpts
          }
        case _ => newStmtOpts = newStmtOpts :+ None()
      }
    }

    return newStmtOpts
  }

  def checkImport(scope: Scope.Local, stmt: AST.Stmt.Import, reporter: Reporter): (Option[Scope.Local], AST.Stmt) = {
    // TODO: resolve import

    @pure def addImport(s: Scope.Local): Scope.Local = {
      s.outerOpt match {
        case Some(outer: Scope.Local) => s(outerOpt = Some(addImport(outer)))
        case Some(outer: Scope.Global) =>
          s(outerOpt = Some(outer(imports = outer.imports :+ stmt)))
        case _ => halt("Unexpected local scope without an outer scope.")
      }
    }

    return (Some(addImport(scope)), stmt)
  }

  def checkBody(expectedOpt: Option[AST.Typed], sc: Scope.Local, body: AST.Body, reporter: Reporter): AST.Body = {
    val to = TypeOutliner(typeHierarchy)
    var ok = T
    var scope = sc
    var stmts = ISZ[AST.Stmt]()
    for (stmt <- body.stmts) {
      stmt match {
        case stmt: AST.Stmt.Import =>
          val (newScopeOpt, newStmt) = checkImport(scope, stmt, reporter)
          newScopeOpt match {
            case Some(newScope) => scope = newScope
            case _ => return body
          }
          stmts = stmts :+ newStmt
        case stmt: AST.Stmt.Method =>
          val id = stmt.sig.id.value
          val infoOpt = to.outlineMethod(
            Info.Method(
              context,
              F,
              scope,
              T,
              stmt,
              None(),
              Some(
                AST.ResolvedInfo.Method(
                  F,
                  AST.MethodMode.Method,
                  stmt.sig.typeParams.map(tp => tp.id.value),
                  context,
                  id,
                  stmt.sig.params.map(p => p.id.value),
                  None()
                )
              )
            ),
            reporter
          )
          infoOpt match {
            case Some(info: Info.Method) =>
              scope = scope(nameMap = scope.nameMap + id ~> info)
              stmts = stmts :+ info.ast
            case _ => ok = F
          }
        case _ => stmts = stmts :+ stmt
      }
    }
    if (!ok) {
      return body
    }
    scope = sc(nameMap = scope.nameMap)
    val (newScopeOpt, newStmts) = checkStmts(expectedOpt, scope, stmts, reporter)
    val undecls: ISZ[String] = newScopeOpt match {
      case Some(newScope) =>
        var r = ISZ[String]()
        for (e <- newScope.nameMap.entries) {
          e._2 match {
            case _: Info.Method =>
            case _ => r = r :+ e._1
          }
        }
        r
      case _ => body.undecls
    }
    return body(stmts = newStmts, undecls = undecls)
  }

  @pure def createNewScope(scope: Scope): Scope.Local = {
    return Scope.Local(HashMap.empty, HashMap.empty, None(), None(), Some(scope))
  }

  def checkPattern(
    expected: AST.Typed,
    sc: Scope.Local,
    pat: AST.Pattern,
    reporter: Reporter
  ): (Option[Scope.Local], AST.Pattern) = {

    var scope = createNewScope(sc)
    var ok = T

    def declId(idOpt: Option[AST.Id], tOpt: Option[AST.Typed]): Unit = {
      idOpt match {
        case Some(id) =>
          val key = id.value
          if (scope.nameMap.contains(key)) {
            reporter.error(
              id.attr.posOpt,
              typeCheckerKind,
              s"Cannot declare '$key' because the identifier has already been previously declared."
            )
            ok = F
          } else {
            scope = scope(
              nameMap = scope.nameMap + key ~> Info
                .LocalVar(context :+ key, F, id, tOpt, Some(AST.ResolvedInfo.LocalVar(context, key)))
            )
          }
        case _ =>
      }
    }

    def checkTipe(expected: AST.Typed, tipe: AST.Type): AST.Type = {
      val newTipeOpt = typeHierarchy.typed(scope, tipe, reporter)
      newTipeOpt match {
        case Some(newTipe) if newTipe.typedOpt.nonEmpty =>
          val t = newTipe.typedOpt.get
          if (t != expected && typeHierarchy.isSubType(expected, t)) {
            // OK
          } else {
            if (typeHierarchy.isSubType(t, expected)) {
              reporter.warn(
                tipe.posOpt,
                typeCheckerKind,
                s"Unnecessary type matching because it is always going to be successful (i.e.,  $t <: $expected)."
              )
            } else {
              if (typeHierarchy.glb(ISZ(expected, t)).isEmpty) {
                reporter.error(
                  tipe.posOpt,
                  typeCheckerKind,
                  s"Fruitless type matching because it is always going to be unsuccessful (i.e., $t and $expected do not have a common subtype)."
                )
                ok = F
              }
            }
          }
          return newTipe
        case _ => return tipe
      }
    }

    def checkPatternH(expected: AST.Typed, pattern: AST.Pattern): AST.Pattern = {
      pattern match {
        case pattern: AST.Pattern.Wildcard =>
          pattern.typeOpt match {
            case Some(tipe) =>
              val newTipe = checkTipe(expected, tipe)
              return pattern(typeOpt = Some(newTipe), attr = pattern.attr(typedOpt = Some(expected)))
            case _ => return pattern(attr = pattern.attr(typedOpt = Some(expected)))
          }
        case pattern: AST.Pattern.SeqWildcard =>
          return pattern(attr = pattern.attr(typedOpt = Some(expected)))
        case pattern: AST.Pattern.Ref =>
          val refName = pattern.name.ids.map(id => id.value)
          checkInfoOpt(scope.resolveName(typeHierarchy.nameMap, refName)) match {
            case (Some(t), resOpt) =>
              if (typeHierarchy.glb(ISZ(expected, t)).isEmpty) {
                reporter.error(
                  pattern.posOpt,
                  typeCheckerKind,
                  s"Fruitless matching because it is always going to be unsuccessful (i.e., $t and $expected do not have a common subtype)."
                )
                ok = F
              }
              return pattern(attr = pattern.attr(typedOpt = Some(t), resOpt = resOpt))
            case _ =>
              reporter.error(pattern.posOpt, typeCheckerKind, st"Could not resolve '${(refName, ".")}'.".render)
              return pattern
          }
        case pattern: AST.Pattern.Literal =>
          val t = pattern.lit.typedOpt.get
          if (t != expected) {
            reporter.error(pattern.posOpt, typeCheckerKind, s"Cannot match $t with $expected.")
          }
          return pattern
        case pattern: AST.Pattern.LitInterpolate =>
          val t: AST.Typed = pattern.prefix.native match {
            case "z" => AST.Typed.z
            case "r" => AST.Typed.r
            case "c" => AST.Typed.c
            case "f32" => AST.Typed.f32
            case "f64" => AST.Typed.f64
            case "string" => AST.Typed.string
            case _ =>
              val tpeOpt = checkStringInterpolator(pattern.posOpt, scope, pattern.prefix, reporter)
              tpeOpt match {
                case Some(tpe) => tpe
                case _ => return pattern
              }
          }
          if (t != expected) {
            reporter.error(pattern.posOpt, typeCheckerKind, s"Cannot match $t with $expected.")
          }
          return pattern(attr = pattern.attr(typedOpt = Some(t)))
        case pattern: AST.Pattern.VarBinding =>
          pattern.tipeOpt match {
            case Some(tipe) =>
              val newTipe = checkTipe(expected, tipe)
              if (newTipe.typedOpt.nonEmpty) {
                val t = newTipe.typedOpt.get
                val tOpt: Option[AST.Typed] = Some(t)
                declId(Some(pattern.id), tOpt)
                return pattern(tipeOpt = Some(newTipe), attr = pattern.attr(typedOpt = tOpt))
              }
              return pattern(tipeOpt = Some(newTipe))
            case _ =>
              val tOpt: Option[AST.Typed] = Some(expected)
              declId(Some(pattern.id), tOpt)
              return pattern(attr = pattern.attr(typedOpt = tOpt))
          }
        case pattern: AST.Pattern.Structure =>
          pattern.nameOpt match {
            case Some(nm) =>
              val name: ISZ[String] = scope.resolveType(typeHierarchy.typeMap, nm.ids.map(id => id.value)) match {
                case Some(info) => info.name
                case nms =>
                  reporter
                    .error(pattern.posOpt, typeCheckerKind, st"Could not resolve type named ${(nms, ".")}.".render)
                  return pattern
              }

              def s(valueType: AST.Typed): AST.Pattern = {
                var newPatterns = ISZ[AST.Pattern]()
                for (p <- pattern.patterns) {
                  val newPattern = checkPatternH(valueType, p)
                  newPatterns = newPatterns :+ newPattern
                }
                val tOpt: Option[AST.Typed] = Some(expected)
                declId(pattern.idOpt, tOpt)
                return pattern(
                  patterns = newPatterns,
                  attr = pattern.attr(typedOpt = tOpt, resOpt = AST.Typed.isResOpt)
                )
              }
              (name, expected) match {
                case (AST.Typed.isName, AST.Typed.Name(AST.Typed.isName, argTypes)) => val r = s(argTypes(1)); return r
                case (AST.Typed.msName, AST.Typed.Name(AST.Typed.msName, argTypes)) => val r = s(argTypes(1)); return r
                case (AST.Typed.iszName, AST.Typed.Name(AST.Typed.isName, argTypes)) =>
                  if (argTypes(0) != AST.Typed.z) {
                    reporter.error(
                      pattern.posOpt,
                      typeCheckerKind,
                      st"Expecting an '${(AST.Typed.isName, ".")}' with index type '${AST.Typed.z}', but index type '${argTypes(0)}' found.".render
                    )
                    return pattern
                  }
                  val r = s(argTypes(1))
                  return r
                case (AST.Typed.mszName, AST.Typed.Name(AST.Typed.msName, argTypes)) =>
                  if (argTypes(0) != AST.Typed.z) {
                    reporter.error(
                      pattern.posOpt,
                      typeCheckerKind,
                      st"Expecting an '${(AST.Typed.msName, ".")}' with index type '${AST.Typed.z}', but index type '${argTypes(0)}' found.".render
                    )
                    return pattern
                  }
                  val r = s(argTypes(1))
                  return r
                case (AST.Typed.zsName, AST.Typed.Name(AST.Typed.msName, argTypes)) =>
                  var ok = T
                  if (argTypes(0) != AST.Typed.z) {
                    reporter.error(
                      pattern.posOpt,
                      typeCheckerKind,
                      st"Expecting an '${(AST.Typed.msName, ".")}' with index type '${AST.Typed.z}', but index type '${argTypes(0)}' found.".render
                    )
                    ok = F
                  }
                  if (argTypes(1) != AST.Typed.z) {
                    reporter.error(
                      pattern.posOpt,
                      typeCheckerKind,
                      st"Expecting an '${(AST.Typed.msName, ".")}' with element type '${AST.Typed.z}', but element type '${argTypes(1)}' found.".render
                    )
                    ok = F
                  }
                  if (!ok) {
                    return pattern
                  }
                  val r = s(argTypes(1))
                  return r
                case (_, expected: AST.Typed.Name) =>
                  scope.resolveType(typeHierarchy.typeMap, name) match {
                    case Some(info: TypeInfo.AbstractDatatype) if !info.ast.isRoot =>
                      val typedOpt: Option[AST.Typed] = Some(expected)

                      def partialResult: AST.Pattern = {
                        return pattern(attr = pattern.attr(typedOpt = typedOpt, resOpt = info.extractorResOpt))
                      }

                      val size = info.extractorTypeMap.size
                      if (size != pattern.patterns.size) {
                        reporter.error(
                          pattern.posOpt,
                          typeCheckerKind,
                          s"Expecting $size patterns, but ${pattern.patterns.size} found."
                        )
                        ok = F
                        return partialResult
                      }
                      val smOpt = unify(pattern.posOpt, T, expected, info.tpe, reporter)
                      smOpt match {
                        case Some(sm) =>
                          val ok = checkUnboundTypeVar(
                            pattern.posOpt,
                            info.tpe,
                            sm,
                            info.ast.typeParams.map(tp => tp.id.value),
                            reporter
                          )
                          if (!ok) {
                            return partialResult
                          }
                          var newPatterns = ISZ[AST.Pattern]()
                          var i = 0
                          val exts = info.extractorTypeMap.values
                          while (i < size) {
                            val newPattern = checkPatternH(exts(i).subst(sm), pattern.patterns(i))
                            newPatterns = newPatterns :+ newPattern
                            i = i + 1
                          }
                          return pattern(
                            patterns = newPatterns,
                            attr = pattern.attr(typedOpt = typedOpt, resOpt = info.extractorResOpt)
                          )
                        case _ => return partialResult
                      }
                    case Some(_) =>
                      reporter.error(
                        pattern.posOpt,
                        typeCheckerKind,
                        st"Cannot pattern match on type $expected using ${(name, ".")}.".render
                      )
                      ok = F
                      return pattern
                    case _ =>
                  }
                case _ =>
                  expected match {
                    case _: AST.Typed.Name =>
                      reporter.error(
                        pattern.posOpt,
                        typeCheckerKind,
                        st"Cannot pattern match on type $expected using ${(name, ".")}.".render
                      )
                    case _ =>
                  }
              }
              reporter
                .error(pattern.posOpt, typeCheckerKind, st"Undefined type ${(name, ".")} for pattern matching.".render)
              ok = F
              return pattern
            case _ =>
              expected match {
                case expected: AST.Typed.Tuple =>
                  val size = expected.args.size
                  if (size != pattern.patterns.size) {
                    reporter.error(
                      pattern.posOpt,
                      typeCheckerKind,
                      s"Expecting $size patterns, but ${pattern.patterns.size} found."
                    )
                    ok = F
                    return pattern
                  }
                  var newPatterns = ISZ[AST.Pattern]()
                  var i = 0
                  while (i < size) {
                    val p = checkPatternH(expected.args(i), pattern.patterns(i))
                    newPatterns = newPatterns :+ p
                    i = i + 1
                  }
                  declId(pattern.idOpt, Some(expected))
                  return pattern(
                    patterns = newPatterns,
                    attr = pattern.attr(
                      typedOpt = Some(expected),
                      resOpt = Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.Tuple))
                    )
                  )
                case _ =>
                  reporter.error(pattern.posOpt, typeCheckerKind, "Cannot match non-tuple type with tuple extractor.")
                  ok = F
                  return pattern
              }
          }
      }
    }
    val r = checkPatternH(expected, pat)
    return if (ok) (Some(scope), r) else (None(), r)
  }

  def checkExpr(
    expectedOpt: Option[AST.Typed],
    scope: Scope.Local,
    stmt: AST.Stmt.Expr,
    reporter: Reporter
  ): AST.Stmt.Expr = {
    val (newExp, typedOpt) = checkExp(expectedOpt, scope, stmt.exp, reporter)
    return stmt(exp = newExp, attr = stmt.attr(typedOpt = typedOpt))
  }

  def checkBlock(
    expectedOpt: Option[AST.Typed],
    scope: Scope.Local,
    stmt: AST.Stmt.Block,
    reporter: Reporter
  ): AST.Stmt = {
    val newBody = checkBody(expectedOpt, createNewScope(scope), stmt.body, reporter)
    return stmt(body = newBody)
  }

  def checkIf(expectedOpt: Option[AST.Typed], scope: Scope.Local, stmt: AST.Stmt.If, reporter: Reporter): AST.Stmt = {
    val (newCond, _) = checkExp(AST.Typed.bOpt, scope, stmt.cond, reporter)
    val tBody = checkBody(expectedOpt, createNewScope(scope), stmt.thenBody, reporter)
    val eBody = checkBody(expectedOpt, createNewScope(scope), stmt.elseBody, reporter)
    return stmt(cond = newCond, thenBody = tBody, elseBody = eBody)
  }

  def checkMatch(
    expectedOpt: Option[AST.Typed],
    scope: Scope.Local,
    stmt: AST.Stmt.Match,
    reporter: Reporter
  ): AST.Stmt = {

    def checkSelectNative(exp: AST.Exp.Select): (AST.Exp, Option[AST.Typed]) = {
      val receiver: AST.Exp = exp.receiverOpt.get
      val (newExp, expTypeOpt) = checkExp(None(), scope, receiver, reporter)

      def partResult: (AST.Exp, Option[AST.Typed]) = {
        return (exp(receiverOpt = Some(newExp)), None())
      }

      expTypeOpt match {
        case Some(t) =>
          t match {
            case AST.Typed.`c` =>
              return (
                exp(receiverOpt = Some(newExp), attr = exp.attr(resOpt = nativeResOpt, typedOpt = nativeCTypedOpt)),
                Some(t)
              )
            case AST.Typed.`string` =>
              return (
                exp(
                  receiverOpt = Some(newExp),
                  attr = exp.attr(resOpt = nativeResOpt, typedOpt = nativeStringTypedOpt)
                ),
                Some(t)
              )
            case AST.Typed.`f32` =>
              return (
                exp(receiverOpt = Some(newExp), attr = exp.attr(resOpt = nativeResOpt, typedOpt = nativeF32TypedOpt)),
                Some(t)
              )
            case AST.Typed.`f64` =>
              return (
                exp(receiverOpt = Some(newExp), attr = exp.attr(resOpt = nativeResOpt, typedOpt = nativeF64TypedOpt)),
                Some(t)
              )
            case _ =>
              reporter.error(
                receiver.posOpt,
                typeCheckerKind,
                s"Selector native is only usable from type C, String, F32, and F64, but '$t' found."
              )
              return partResult
          }
        case _ => return partResult
      }
    }

    val (newExp, expTypeOpt): (AST.Exp, Option[AST.Typed]) = stmt.exp match {
      case exp @ AST.Exp.Select(Some(_), AST.Id(string"native"), _) =>
        val p = checkSelectNative(exp)
        p
      case _ =>
        val p = checkExp(None(), scope, stmt.exp, reporter)
        p
    }
    val expType: AST.Typed = expTypeOpt match {
      case Some(et) => et
      case _ => return stmt(exp = newExp)
    }

    var newCases = ISZ[AST.Case]()
    for (c <- stmt.cases) {
      val (newScopeOpt, newPattern) = checkPattern(expType, scope, c.pattern, reporter)
      newScopeOpt match {
        case Some(newScope) =>
          val newCondOpt: Option[AST.Exp] = c.condOpt match {
            case Some(cond) =>
              val (newCond, _) = checkExp(AST.Typed.bOpt, newScope, cond, reporter)
              Some(newCond)
            case o => o
          }
          val newBody = checkBody(expectedOpt, newScope, c.body, reporter)
          newCases = newCases :+ c(pattern = newPattern, condOpt = newCondOpt, body = newBody)
        case _ => newCases = newCases :+ c(pattern = newPattern)
      }
    }

    return stmt(exp = newExp, cases = newCases)
  }

  def checkStmt(scope: Scope.Local, stmt: AST.Stmt, reporter: Reporter): (Option[Scope.Local], AST.Stmt) = {

    def checkVar(stmt: AST.Stmt.Var): (Option[Scope.Local], AST.Stmt) = {
      val key = stmt.id.value

      def err(): Unit = {
        reporter.error(
          stmt.id.attr.posOpt,
          typeCheckerKind,
          s"Cannot declare '$key' because the identifier has already been previously declared."
        )
      }

      val name = context :+ stmt.id.value
      var r = stmt
      val resOpt: Option[AST.ResolvedInfo] = scope.resolveName(typeHierarchy.nameMap, ISZ(key)) match {
        case Some(info: Info.Var) => info.resOpt
        case Some(_: Info.LocalVar) =>
          err()
          return (None(), r)
        case _ => Some(AST.ResolvedInfo.LocalVar(context, key))
      }
      val expectedOpt: Option[AST.Typed] = stmt.tipeOpt match {
        case Some(tipe) =>
          tipe.typedOpt match {
            case tOpt @ Some(_) => tOpt
            case _ =>
              val newTipeOpt = typeHierarchy.typed(scope, tipe, reporter)
              newTipeOpt match {
                case Some(newTipe) if newTipe.typedOpt.nonEmpty =>
                  r = r(tipeOpt = newTipeOpt)
                  newTipe.typedOpt
                case _ => return (None(), r)
              }
          }
        case _ => None()
      }
      val (rhs, tOpt) =
        checkAssignExp(expectedOpt, scope, stmt.initOpt.get, reporter)
      tOpt match {
        case Some(_) =>
          val typedOpt: Option[AST.Typed] = expectedOpt match {
            case Some(_) => expectedOpt
            case _ => tOpt
          }
          val newScope = scope(nameMap = scope.nameMap + key ~> Info.LocalVar(name, stmt.isVal, r.id, typedOpt, resOpt))
          val newStmt = r(initOpt = Some(rhs))
          return (Some(newScope), newStmt)
        case _ =>
          return (None(), r)
      }
    }

    def checkVarPattern(stmt: AST.Stmt.VarPattern): (Option[Scope.Local], AST.Stmt) = {
      var newTipeOpt = stmt.tipeOpt
      val expectedOpt: Option[AST.Typed] = newTipeOpt match {
        case Some(tipe) =>
          newTipeOpt = typeHierarchy.typed(scope, tipe, reporter)
          newTipeOpt match {
            case Some(newTipe) if newTipe.typedOpt.nonEmpty => newTipe.typedOpt
            case _ => return (None(), stmt(tipeOpt = newTipeOpt))
          }
        case _ => None()
      }
      val (newInit, initTypeOpt) = checkAssignExp(expectedOpt, scope, stmt.init, reporter)
      initTypeOpt match {
        case Some(initType) =>
          val expected: AST.Typed = if (expectedOpt.nonEmpty) expectedOpt.get else initType
          val (scopeOpt, newPattern) = checkPattern(expected, scope, stmt.pattern, reporter)
          return (scopeOpt, stmt(pattern = newPattern, tipeOpt = newTipeOpt, init = newInit))
        case _ =>
          if (expectedOpt.isEmpty) {
            val varText: String = if (stmt.isVal) "val" else "var"
            reporter.error(
              stmt.pattern.posOpt,
              typeCheckerKind,
              s"Could not infer the expected type for $varText pattern to match to."
            )
          }
          return (None(), stmt(tipeOpt = newTipeOpt, init = newInit))
      }
    }

    def checkAssign(stmt: AST.Stmt.Assign): AST.Stmt = {
      stmt.lhs match {
        case lhs: AST.Exp.Ident =>
          def checkAssignH(expectedOpt: Option[AST.Typed], resOpt: Option[AST.ResolvedInfo]): AST.Stmt = {
            val (newRhs, _) = checkAssignExp(expectedOpt, scope, stmt.rhs, reporter)
            return stmt(lhs = lhs(attr = lhs.attr(resOpt = resOpt, typedOpt = expectedOpt)), rhs = newRhs)
          }
          def partialResult(): AST.Stmt = {
            val (newRhs, _) = checkAssignExp(None(), scope, stmt.rhs, reporter)
            return stmt(rhs = newRhs)
          }
          def checkVar(info: Info.Var): AST.Stmt = {
            if (info.ast.isVal) {
              reporter.error(lhs.posOpt, typeCheckerKind, s"Cannot assign to read-only variable '${lhs.id.value}'.")
            }
            val r = checkAssignH(info.typedOpt, info.resOpt)
            return r
          }
          scope.resolveName(typeHierarchy.nameMap, ISZ(lhs.id.value)) match {
            case Some(info: Info.LocalVar) =>
              if (info.isVal) {
                reporter.error(lhs.posOpt, typeCheckerKind, s"Cannot assign to read-only variable '${lhs.id.value}'.")
              }
              val r = checkAssignH(info.typedOpt, info.resOpt)
              return r
            case Some(info: Info.Var) => val r = checkVar(info); return r
            case Some(info) =>
              reporter.error(lhs.posOpt, typeCheckerKind, st"Cannot assign to '${(info.name, ".")}'.".render)
              val (newRhs, _) = checkAssignExp(None(), scope, stmt.rhs, reporter)
              return stmt(rhs = newRhs)
            case _ =>
              scope.thisOpt match {
                case Some(t: AST.Typed.Name) =>
                  typeHierarchy.typeMap.get(t.ids) match {
                    case Some(info: TypeInfo.AbstractDatatype) =>
                      info.vars.get(lhs.id.value) match {
                        case Some(varInfo) => val r = checkVar(varInfo); return r
                        case _ =>
                      }
                    case _ =>
                  }
                case _ =>
              }
              reporter.error(lhs.id.attr.posOpt, typeCheckerKind, s"Could not resolve '${lhs.id.value}'.")
              val r = partialResult()
              return r
          }
        case lhs: AST.Exp.Select =>
          val (newReceiver, receiverTypeOpt) = checkExp(None(), scope, lhs.receiverOpt.get, reporter)
          def partialResult(): AST.Stmt = {
            val (newRhs, _) = checkAssignExp(None(), scope, stmt.rhs, reporter)
            return stmt(lhs = lhs(receiverOpt = Some(newReceiver)), rhs = newRhs)
          }
          receiverTypeOpt match {
            case Some(t: AST.Typed.Name) =>
              typeHierarchy.typeMap.get(t.ids) match {
                case Some(info: TypeInfo.AbstractDatatype) =>
                  info.vars.get(lhs.id.value) match {
                    case Some(varInfo) =>
                      if (varInfo.ast.isVal) {
                        reporter.error(
                          lhs.id.attr.posOpt,
                          typeCheckerKind,
                          st"Cannot assign to val '${lhs.id.value}' of '${(info.name, ".")}'.".render
                        )
                      }
                      val (newRhs, _) = checkAssignExp(varInfo.typedOpt, scope, stmt.rhs, reporter)
                      return stmt(
                        lhs = lhs(
                          receiverOpt = Some(newReceiver),
                          attr = lhs.attr(resOpt = varInfo.resOpt, typedOpt = varInfo.typedOpt)
                        ),
                        rhs = newRhs
                      )
                    case _ =>
                      reporter.error(
                        lhs.id.attr.posOpt,
                        typeCheckerKind,
                        st"'${lhs.id.value}' is not a var of '${(info.name, ".")}'.".render
                      )
                  }
                case _ =>
              }
              val r = partialResult()
              return r
            case Some(_) => halt("Unexpected situation when type checking field assignment.")
            case _ => val r = partialResult(); return r
          }
        case lhs: AST.Exp.Invoke =>
          val receiver = lhs.receiverOpt.get
          val (newReceiver, receiverTypeOpt) = checkExp(None(), scope, receiver, reporter)
          receiverTypeOpt match {
            case Some(AST.Typed.Name(AST.Typed.msName, args)) =>
              val (newArg, _) = checkExp(Some(args(0)), scope, lhs.args(0), reporter)
              val (newRhs, _) = checkAssignExp(Some(args(1)), scope, stmt.rhs, reporter)
              return stmt(
                lhs = lhs(
                  receiverOpt = Some(newReceiver),
                  args = ISZ(newArg),
                  attr = lhs.attr(
                    resOpt = Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.Update)),
                    typedOpt = Some(args(1))
                  )
                ),
                rhs = newRhs
              )
            case Some(lhsType) =>
              reporter.error(lhs.posOpt, typeCheckerKind, s"Cannot perform index update on type '$lhsType'.")
            case _ =>
          }
          val (newRhs, _) = checkAssignExp(None(), scope, stmt.rhs, reporter)
          return stmt(
            lhs = lhs(
              receiverOpt = Some(newReceiver),
              attr = lhs.attr(resOpt = Some(AST.ResolvedInfo.BuiltIn(AST.ResolvedInfo.BuiltIn.Kind.Update)))
            ),
            rhs = newRhs
          )
        case _ => halt("Unexpected situation when type checking assignment.")
      }
    }

    def checkFor(stmt: AST.Stmt.For): AST.Stmt = {
      val (newScopeOpt, newEnumGens, _, _) = checkEnumGens(scope, stmt.enumGens, reporter)
      newScopeOpt match {
        case Some(newScope) =>
          val newBody = checkBody(None(), newScope, stmt.body, reporter)
          return stmt(enumGens = newEnumGens, body = newBody)
        case _ => return stmt(enumGens = newEnumGens)
      }
    }

    stmt match {

      case stmt: AST.Stmt.LStmt => return (Some(scope), stmt) // TODO

      case stmt: AST.Stmt.AbstractDatatype =>
        typeHierarchy.typeMap.get(context :+ stmt.id.value) match {
          case Some(info: TypeInfo.AbstractDatatype) => return (Some(scope), info.ast)
          case _ => halt("Unexpected situation when type checking statement.")
        }

      case stmt: AST.Stmt.Assign => val r = checkAssign(stmt); return (Some(scope), r)

      case stmt: AST.Stmt.Block =>
        val r = checkBlock(None(), scope, stmt, reporter); return (Some(scope), r)

      case stmt: AST.Stmt.DoWhile =>
        val newBody = checkBody(None(), createNewScope(scope), stmt.body, reporter)
        val (newCond, _) = checkExp(AST.Typed.bOpt, scope, stmt.cond, reporter)
        return (Some(scope), stmt(cond = newCond, body = newBody))

      case stmt: AST.Stmt.Enum => return (Some(scope), stmt)

      case stmt: AST.Stmt.Expr => val r = checkExpr(None(), scope, stmt, reporter); return (Some(scope), r)

      case stmt: AST.Stmt.ExtMethod => return (Some(scope), stmt)

      case stmt: AST.Stmt.For => val r = checkFor(stmt); return (Some(scope), r)

      case stmt: AST.Stmt.If =>
        val r = checkIf(None(), scope, stmt, reporter); return (Some(scope), r)

      case stmt: AST.Stmt.Import => val r = checkImport(scope, stmt, reporter); return r

      case stmt: AST.Stmt.Match => val r = checkMatch(None(), scope, stmt, reporter); return (Some(scope), r)

      case stmt: AST.Stmt.Method =>
        val tc = TypeChecker(typeHierarchy, context :+ stmt.sig.id.value, inSpec)
        val r = tc.checkMethod(scope, stmt, reporter)
        return (Some(scope), r)

      case stmt: AST.Stmt.Object =>
        typeHierarchy.nameMap.get(context :+ stmt.id.value) match {
          case Some(info: Info.Object) => return (Some(scope), info.ast)
          case _ => halt("Unexpected situation when type checking statement.")
        }

      case stmt: AST.Stmt.Return =>
        (scope.returnOpt, stmt.expOpt) match {
          case (tOpt @ Some(_), Some(exp)) =>
            val (newExp, expTypeCond) = checkExp(tOpt, scope, exp, reporter)
            expTypeCond match {
              case Some(t) =>
                if (!typeHierarchy.isSubType(t, tOpt.get)) {
                  reporter.error(
                    exp.posOpt,
                    typeCheckerKind,
                    s"Expecting type '${tOpt.get}', but incompatible type '$t' found."
                  )
                }
                return (Some(scope), stmt(expOpt = Some(newExp), attr = stmt.attr(typedOpt = tOpt)))
              case _ => return (None(), stmt(expOpt = Some(newExp)))
            }
          case (Some(t), _) =>
            if (t != AST.Typed.unit) {
              reporter.error(stmt.posOpt, typeCheckerKind, s"Expecting type '$t', but none found.")
              return (None(), stmt)
            } else {
              return (Some(scope), stmt(attr = stmt.attr(typedOpt = AST.Typed.unitOpt)))
            }
          case (_, Some(exp)) =>
            val (newExp, _) = checkExp(None(), scope, exp, reporter)
            reporter.error(exp.posOpt, typeCheckerKind, s"Unexpected return expression.")
            return (None(), stmt(expOpt = Some(newExp)))
          case _ =>
            return (Some(scope), stmt)
        }

      case stmt: AST.Stmt.Sig =>
        typeHierarchy.typeMap.get(context :+ stmt.id.value) match {
          case Some(info: TypeInfo.Sig) => return (Some(scope), info.ast)
          case _ => halt("Unexpected situation when type checking statement.")
        }

      case stmt: AST.Stmt.SpecMethod => return (Some(scope), stmt) // TODO

      case stmt: AST.Stmt.SpecVar => return (Some(scope), stmt)

      case stmt: AST.Stmt.SubZ => return (Some(scope), stmt)

      case stmt: AST.Stmt.TypeAlias => return (Some(scope), stmt)

      case stmt: AST.Stmt.Var => val r = checkVar(stmt); return r

      case stmt: AST.Stmt.VarPattern => val r = checkVarPattern(stmt); return r

      case stmt: AST.Stmt.While =>
        val (newCond, _) = checkExp(AST.Typed.bOpt, scope, stmt.cond, reporter)
        val newBody = checkBody(None(), createNewScope(scope), stmt.body, reporter)
        return (Some(scope), stmt(cond = newCond, body = newBody))

    }
  }

  def checkMethod(sc: Scope, stmt: AST.Stmt.Method, reporter: Reporter): AST.Stmt = {
    if (stmt.bodyOpt.isEmpty) {
      return stmt
    }
    val typeParams = typeParamMap(stmt.sig.typeParams, reporter)
    var scope = localTypeScope(typeParams.map, sc)
    stmt.sig.returnType.typedOpt match {
      case tOpt @ Some(_) => scope = scope(methodReturnOpt = tOpt)
      case _ => halt("Unexpected situation when type checking method.")
    }
    var ok = T
    for (p <- stmt.sig.params) {
      val id = p.id.value
      scope.resolveName(typeHierarchy.nameMap, ISZ(id)) match {
        case Some(_: Info.LocalVar) =>
          reporter.warn(
            p.id.attr.posOpt,
            typeCheckerKind,
            s"Identifier '$id' shadows a declaration in the enclosing context."
          )
          ok = F
        case _ =>
          scope = scope(
            nameMap = scope.nameMap + id ~> Info
              .LocalVar(context :+ id, T, p.id, p.tipe.typedOpt, Some(AST.ResolvedInfo.LocalVar(context, id)))
          )
      }
    }
    if (!ok) {
      return stmt
    }
    val newBody = checkBody(None(), scope, stmt.bodyOpt.get, reporter)
    return stmt(bodyOpt = Some(newBody))
  }

  def checkAbstractDatatype(info: TypeInfo.AbstractDatatype): TypeHierarchy => (TypeHierarchy, AccumulatingReporter) = {
    assert(info.outlined, st"${(info.name, ".")} is not outlined".render)
    val reporter = AccumulatingReporter.create
    val typeParams = typeParamMap(info.ast.typeParams, reporter)
    var scope = localTypeScope(typeParams.map, info.scope)
    scope = scope(localThisOpt = Some(info.tpe))
    var stmts = ISZ[AST.Stmt]()
    for (stmt <- info.ast.stmts) {
      stmt match {
        case stmt: AST.Stmt.Var => stmts = stmts :+ info.vars.get(stmt.id.value).get.ast
        case stmt: AST.Stmt.SpecVar => stmts = stmts :+ info.specVars.get(stmt.id.value).get.ast
        case stmt: AST.Stmt.Method => stmts = stmts :+ info.methods.get(stmt.sig.id.value).get.ast
        case stmt: AST.Stmt.SpecMethod => stmts = stmts :+ info.specMethods.get(stmt.sig.id.value).get.ast
        case _ => stmts = stmts :+ stmt
      }
    }
    val (_, newStmts) = checkStmts(None(), scope, stmts, reporter)
    var specVars: HashMap[String, Info.SpecVar] = info.specVars
    var vars: HashMap[String, Info.Var] = info.vars
    var specMethods: HashMap[String, Info.SpecMethod] = info.specMethods
    var methods: HashMap[String, Info.Method] = info.methods
    for (stmt <- newStmts) {
      stmt match {
        case stmt: AST.Stmt.Var =>
          val id = stmt.id.value
          val vInfo = info.vars.get(id).get
          vars = vars + id ~> vInfo(ast = stmt)
        case stmt: AST.Stmt.SpecVar =>
          val id = stmt.id.value
          val svInfo = info.specVars.get(id).get
          specVars = specVars + id ~> svInfo(ast = stmt)
        case stmt: AST.Stmt.Method =>
          val id = stmt.sig.id.value
          val mInfo = info.methods.get(id).get
          methods = methods + id ~> mInfo(ast = stmt)
        case stmt: AST.Stmt.SpecMethod =>
          val id = stmt.sig.id.value
          val smInfo = info.specMethods.get(id).get
          specMethods = specMethods + id ~> smInfo(ast = stmt)
        case _ =>
      }
    }
    return (th: TypeHierarchy) =>
      (
        th(
          typeMap = th.typeMap + info.name ~> info(
            typeChecked = T,
            ast = info.ast(stmts = newStmts),
            vars = vars,
            specVars = specVars,
            methods = methods,
            specMethods = specMethods
          )
        ),
        reporter
    )
  }

  def checkSig(info: TypeInfo.Sig): TypeHierarchy => (TypeHierarchy, AccumulatingReporter) = {
    assert(info.outlined, st"${(info.name, ".")} is not outlined".render)
    val reporter = AccumulatingReporter.create
    val typeParams = typeParamMap(info.ast.typeParams, reporter)
    var scope = localTypeScope(typeParams.map, info.scope)
    scope = scope(localThisOpt = Some(info.tpe))
    var stmts = ISZ[AST.Stmt]()
    for (stmt <- info.ast.stmts) {
      stmt match {
        case stmt: AST.Stmt.SpecVar => stmts = stmts :+ info.specVars.get(stmt.id.value).get.ast
        case stmt: AST.Stmt.Method => stmts = stmts :+ info.methods.get(stmt.sig.id.value).get.ast
        case stmt: AST.Stmt.SpecMethod => stmts = stmts :+ info.specMethods.get(stmt.sig.id.value).get.ast
        case _ => stmts = stmts :+ stmt
      }
    }
    val (_, newStmts) = checkStmts(None(), scope, stmts, reporter)
    var specVars: HashMap[String, Info.SpecVar] = info.specVars
    var specMethods: HashMap[String, Info.SpecMethod] = info.specMethods
    var methods: HashMap[String, Info.Method] = info.methods
    for (stmt <- newStmts) {
      stmt match {
        case stmt: AST.Stmt.SpecVar =>
          val id = stmt.id.value
          val svInfo = info.specVars.get(id).get
          specVars = specVars + id ~> svInfo(ast = stmt)
        case stmt: AST.Stmt.Method =>
          val id = stmt.sig.id.value
          val mInfo = info.methods.get(id).get
          methods = methods + id ~> mInfo(ast = stmt)
        case stmt: AST.Stmt.SpecMethod =>
          val id = stmt.sig.id.value
          val smInfo = info.specMethods.get(id).get
          specMethods = specMethods + id ~> smInfo(ast = stmt)
        case _ =>
      }
    }
    return (th: TypeHierarchy) =>
      (
        th(
          typeMap = th.typeMap + info.name ~> info(
            typeChecked = T,
            ast = info.ast(stmts = newStmts),
            specVars = specVars,
            methods = methods,
            specMethods = specMethods
          )
        ),
        reporter
    )
  }

  def checkObject(info: Info.Object): TypeHierarchy => (TypeHierarchy, AccumulatingReporter) = {
    assert(info.outlined, st"${(info.name, ".")} is not outlined".render)
    val name = info.name
    def getStmt(id: String): Option[AST.Stmt] = {
      typeHierarchy.nameMap.get(name :+ id).get match {
        case info: Info.Var => return Some(info.ast)
        case info: Info.SpecVar => return Some(info.ast)
        case info: Info.SpecMethod => return Some(info.ast)
        case info: Info.Method => return Some(info.ast)
        case info: Info.ExtMethod => return Some(info.ast)
        case _ => halt("Unexpected situation when type checking object.")
      }
    }
    val reporter = AccumulatingReporter.create
    var scope = createNewScope(info.scope(enclosingName = name))
    scope = scope(localThisOpt = Some(AST.Typed.Object(info.owner, info.ast.id.value)))
    var stmtOpts = ISZ[Option[AST.Stmt]]()
    for (stmt <- info.ast.stmts) {
      stmt match {
        case stmt: AST.Stmt.Var => stmtOpts = stmtOpts :+ getStmt(stmt.id.value)
        case stmt: AST.Stmt.SpecVar => stmtOpts = stmtOpts :+ getStmt(stmt.id.value)
        case stmt: AST.Stmt.Method => stmtOpts = stmtOpts :+ getStmt(stmt.sig.id.value)
        case stmt: AST.Stmt.SpecMethod => stmtOpts = stmtOpts :+ getStmt(stmt.sig.id.value)
        case stmt: AST.Stmt.ExtMethod => stmtOpts = stmtOpts :+ getStmt(stmt.sig.id.value)
        case _: AST.Stmt.Sig => stmtOpts = stmtOpts :+ None()
        case _: AST.Stmt.AbstractDatatype => stmtOpts = stmtOpts :+ None()
        case _: AST.Stmt.Object => stmtOpts = stmtOpts :+ None()
        case _ => stmtOpts = stmtOpts :+ Some(stmt)
      }
    }
    val newStmtOpts = checkStmtOpts(scope, stmtOpts, reporter)
    var i = 0
    var newStmts = ISZ[AST.Stmt]()
    for (stmtOpt <- newStmtOpts) {
      stmtOpt match {
        case Some(stmt) => newStmts = newStmts :+ stmt
        case _ => newStmts = newStmts :+ info.ast.stmts(i)
      }
      i = i + 1
    }
    return (th: TypeHierarchy) =>
      (th(nameMap = th.nameMap + info.name ~> info(ast = info.ast(stmts = newStmts))), reporter)
  }

  @pure def unifyCombine(
    r: HashMap[String, AST.Typed],
    m: HashMap[String, AST.Typed]
  ): Option[HashMap[String, AST.Typed]] = {
    var res = r
    for (e <- m.entries) {
      val (key, value) = e
      res.get(key) match {
        case Some(v) =>
          if (value != v) {
            return None()
          }
        case _ => res = res + key ~> value
      }
    }
    return Some(res)
  }

  def unify(
    posOpt: Option[AST.PosInfo],
    allowSubType: B,
    expected: AST.Typed,
    tpe: AST.Typed,
    reporter: Reporter
  ): Option[HashMap[String, AST.Typed]] = {
    def err(): Unit = {
      reporter.error(posOpt, typeCheckerKind, s"Could not unify type '$expected' with '$tpe'.")
    }

    (expected, tpe) match {
      case (_, tpe: AST.Typed.TypeVar) =>
        return Some(HashMap.empty[String, AST.Typed] + tpe.id ~> expected)
      case (expected: AST.Typed.Name, tpe: AST.Typed.Name) =>
        val rt: AST.Typed.Name = if (allowSubType && tpe.ids != expected.ids) {
          val ancestors: ISZ[AST.Typed.Name] = typeHierarchy.typeMap.get(tpe.ids) match {
            case Some(info: TypeInfo.AbstractDatatype) => info.ancestors
            case Some(info: TypeInfo.Sig) => info.ancestors
            case _ => halt(s"Unexpected situation when trying to unify $expected and $tpe")
          }
          var r = tpe
          var found = F
          for (ancestor <- ancestors if !found && ancestor.ids == expected.ids) {
            r = ancestor
            found = T
          }
          r
        } else {
          if (tpe.ids != expected.ids || tpe.args.size != expected.args.size) {
            err()
            return None()
          }
          tpe
        }
        val size = rt.args.size
        var i = 0
        var r = HashMap.empty[String, AST.Typed]
        while (i < size) {
          val mOpt = unify(posOpt, F, expected.args(i), rt.args(i), reporter)
          mOpt match {
            case Some(m) =>
              unifyCombine(r, m) match {
                case Some(c) => r = c
                case _ => err(); return None()
              }
            case _ => return None()
          }
          i = i + 1
        }
        return Some(r)
      case (expected: AST.Typed.Tuple, tpe: AST.Typed.Tuple) =>
        val size = expected.args.size
        if (size != tpe.args.size) {
          err()
          return None()
        }
        var i = 0
        var r = HashMap.empty[String, AST.Typed]
        while (i < size) {
          val mOpt = unify(posOpt, F, expected.args(i), tpe.args(i), reporter)
          mOpt match {
            case Some(m) =>
              unifyCombine(r, m) match {
                case Some(c) => r = c
                case _ => err(); return None()
              }
            case _ => return None()
          }
          i = i + 1
        }
        return Some(r)
      case (expected: AST.Typed.Fun, tpe: AST.Typed.Fun) =>
        val size = expected.args.size
        if (size != tpe.args.size) {
          err()
          return None()
        }
        var i = 0
        var r = HashMap.empty[String, AST.Typed]
        while (i < size) {
          val mOpt = unify(posOpt, F, expected.args(i), tpe.args(i), reporter)
          mOpt match {
            case Some(m) =>
              unifyCombine(r, m) match {
                case Some(c) => r = c
                case _ => err(); return None()
              }
            case _ => return None()
          }
          i = i + 1
        }
        val mOpt = unify(posOpt, F, expected.ret, tpe.ret, reporter)
        mOpt match {
          case Some(m) =>
            unifyCombine(r, m) match {
              case Some(c) => r = c
              case _ => err(); return None()
            }
          case _ => return None()
        }
        return Some(r)
      case _ => return None()
    }
  }

  def unifies(
    posOpt: Option[AST.PosInfo],
    allowSubType: B,
    expected: ISZ[AST.Typed],
    tpe: ISZ[AST.Typed],
    reporter: Reporter
  ): Option[HashMap[String, AST.Typed]] = {
    def err(): Unit = {
      reporter.error(
        posOpt,
        typeCheckerKind,
        s"Could not unify type '${AST.Typed.Tuple(expected)}' with '${AST.Typed.Tuple(tpe)}'."
      )
    }

    val size = expected.size
    if (size != tpe.size) {
      return None()
    }
    var r = HashMap.empty[String, AST.Typed]
    var i = 0
    while (i < size) {
      val mOpt = unify(posOpt, allowSubType, expected(i), tpe(i), reporter)
      mOpt match {
        case Some(m) =>
          unifyCombine(r, m) match {
            case Some(c) => r = c
            case _ => err(); return None()
          }
        case _ => return None()
      }
      i = i + 1
    }
    return Some(r)
  }
}
