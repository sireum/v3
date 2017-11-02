/*
 Copyright (c) 2016, Robby, Kansas State University
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

package org.sireum.logika.tipe

import org.sireum.logika.ast._
import org.sireum.util._

object TypeChecker {
  final val kind: String = "Type Checker"
  final val posNegTipes: Set[NumberTipe] = Set(Z, Z8, Z16, Z32, Z64, S8, S16, S32, S64, R, F32, F64)

  final def check(weakModifies: Boolean, bitWidth: Natural, programs: Program*)(
    implicit reporter: AccumulatingTagReporter): Boolean = {
    var typeMap = imapEmpty[String, (Tipe, Node, Program)]
    var factMap = imapEmpty[String, (Either[Fact, (Fun, FunDef)], Program)]
    var mdGlobalsMap = imapEmpty[String, ISet[String]]
    var currentGlobals = isetEmpty[String]
    for (program <- programs) {
      val factOrFunDecls = program.block.stmts.flatMap(_ match {
        case stmt: FactStmt => Some(stmt.fact.factOrFunDecls)
        case _ => None
      }).flatten
      for (fact@Fact(id, _) <- factOrFunDecls) {
        factMap = addId(factMap, program, id, Left(fact))
      }
      for (f@Fun(id, _, _, _) <- factOrFunDecls) {
        val ft = tipe(bitWidth, f)
        id.tipe = ft
        typeMap = addId(typeMap, program, id, ft, f)
        for (fd <- f.funDefs) {
          factMap = addId(factMap, program, fd.id, Right((f, fd)))
        }
      }
      for (stmt <- program.block.stmts) stmt match {
        case VarDecl(_, Id(value), _, _) => currentGlobals += value
        case m@MethodDecl(_, _, id, _, _, _, _) =>
          mdGlobalsMap += id.value -> currentGlobals
          typeMap = addId(typeMap, program, id, tipe(bitWidth, m), m)
        case _ =>
      }
    }
    if (reporter.hasError) return false
    if (programs.nonEmpty) {
      var tc = TypeContext(typeMap, factMap, mdGlobalsMap, programs.head,
        weakModifies, bitWidth).check(programs.head)
      for (program <- programs.tail)
        tc = tc.copy(program = program).check(program)
    }
    !reporter.hasError
  }

  private[tipe] def addId(factMap: IMap[String, (Either[Fact, (Fun, FunDef)], Program)],
                          program: Program, id: Id, factOrFunDef: Either[Fact, (Fun, FunDef)])(
                           implicit reporter: AccumulatingTagReporter): IMap[String, (Either[Fact, (Fun, FunDef)], Program)] = {
    factMap.get(id.value) match {
      case Some((e, otherProgram)) =>
        val otherLi = e match {
          case Left(other) => otherProgram.nodeLocMap(other)
          case Right((_, other)) => otherProgram.nodeLocMap(other)
        }
        val message =
          if ((program eq otherProgram) || otherProgram.fileUriOpt.isEmpty)
            s"Identifier ${id.value} has been declared at [${otherLi.lineBegin}, ${otherLi.columnBegin}]."
          else
            s"Identifier ${id.value} has been declared at [${otherLi.lineBegin}, ${otherLi.columnBegin}] of ${otherProgram.fileUriOpt.get}."
        reporter.report(
          program.nodeLocMap(id).toLocationError(program.fileUriOpt, kind, message))
        factMap
      case _ => factMap + (id.value -> (factOrFunDef, program))
    }
  }

  private[tipe] def addId(typeMap: IMap[String, (Tipe, Node, Program)],
                          program: Program, id: Id, tipe: Tipe, decl: Node)(
                           implicit reporter: AccumulatingTagReporter): IMap[String, (Tipe, Node, Program)] = {
    id.tipe = tipe
    typeMap.get(id.value) match {
      case Some((_, other, otherProgram)) =>
        val otherLi = otherProgram.nodeLocMap(other)
        val message =
          if ((program eq otherProgram) || otherProgram.fileUriOpt.isEmpty)
            s"Identifier ${id.value} has been declared at [${otherLi.lineBegin}, ${otherLi.columnBegin}]."
          else
            s"Identifier ${id.value} has been declared at [${otherLi.lineBegin}, ${otherLi.columnBegin}] of ${otherProgram.fileUriOpt.get}."
        reporter.report(
          program.nodeLocMap(id).toLocationError(program.fileUriOpt, kind, message))
        typeMap
      case _ => typeMap + (id.value -> (id.tipe, decl, program))
    }
  }

  private[tipe] final def tipe(bitWidth: Natural, t: Type): Tipe = t match {
    case _: BType => B
    case _: ZType => Tipe.normalize(bitWidth, Z)
    case _: Z8Type => Z8
    case _: Z16Type => Z16
    case _: Z32Type => Z32
    case _: Z64Type => Z64
    case _: NType => Tipe.normalize(bitWidth, N)
    case _: N8Type => N8
    case _: N16Type => N16
    case _: N32Type => N32
    case _: N64Type => N64
    case _: S8Type => S8
    case _: S16Type => S16
    case _: S32Type => S32
    case _: S64Type => S64
    case _: U8Type => U8
    case _: U16Type => U16
    case _: U32Type => U32
    case _: U64Type => U64
    case _: RType => R
    case _: F32Type => F32
    case _: F64Type => F64
    case _: BSType => BS
    case _: ZSType => ZS
    case _: Z8SType => Z8S
    case _: Z16SType => Z16S
    case _: Z32SType => Z32S
    case _: Z64SType => Z64S
    case _: NSType => NS
    case _: N8SType => N8S
    case _: N16SType => N16S
    case _: N32SType => N32S
    case _: N64SType => N64S
    case _: S8SType => S8S
    case _: S16SType => S16S
    case _: S32SType => S32S
    case _: S64SType => S64S
    case _: U8SType => U8S
    case _: U16SType => U16S
    case _: U32SType => U32S
    case _: U64SType => U64S
    case _: RSType => RS
    case _: F32SType => F32S
    case _: F64SType => F64S
  }

  private[tipe] final def tipe(bitWidth: Natural, m: MethodDecl): FunTipe =
    FunTipe(m.params.map(p => tipe(bitWidth, p.tpe)),
      m.returnTypeOpt.map(tipe(bitWidth, _)).getOrElse(UnitTipe))

  private[tipe] final def tipe(bitWidth: Natural, f: Fun): FunTipe =
    FunTipe(f.params.map(p => tipe(bitWidth, p.tpe)),
      tipe(bitWidth, f.returnType))
}

private final case class
TypeContext(typeMap: IMap[String, (Tipe, Node, Program)],
            factMap: IMap[String, (Either[Fact, (Fun, FunDef)], Program)],
            mdGlobalsMap: IMap[String, ISet[String]],
            program: Program,
            weakModifies: Boolean,
            bitWidth: Natural)(
             implicit reporter: AccumulatingTagReporter) {

  private val someB = Some(B)
  private val someZ = Some(Tipe.normalize(bitWidth, Z))
  private val someR = Some(R)
  private lazy val zMax: BigInt = BigInt(2).pow(bitWidth - 1) - 1

  def check(p: Program): TypeContext = {
    val r = check(p.block)(None)
    for (stmt <- p.block.stmts) {
      val applyOpt =
        stmt match {
          case VarDecl(_, _, _, a: Apply) => Some(a)
          case Assign(_, a: Apply) => Some(a)
          case ExpStmt(a) => Some(a)
          case _ => None
        }
      applyOpt.foreach(_.declOpt.foreach {
        case Left(d) if d.isHelper =>
          error(applyOpt.get, s"Cannot directly call a helper method in the program main level.")
        case _ =>
      })
    }
    r
  }

  def check(b: Block)(
    implicit mOpt: Option[MethodDecl]): TypeContext = {
    var tc = this
    for (stmt <- b.stmts) tc = tc.check(stmt)
    mOpt match {
      case Some(md) =>
        val t = md.id.tipe.asInstanceOf[Fn].result
        b.returnOpt.map(_.expOpt) match {
          case Some(Some(e)) =>
            tc.check(e, allowMethod = false)(
              allowFun = false, mOpt) match {
              case Some(t2) =>
                if (!tipeEq(t, t2))
                  error(e, s"Expecting return type $t, but found $t2.")
              case _ =>
            }
          case Some(None) =>
            error(b.returnOpt.get, s"Expecting return type $t, but found none.")
          case _ =>
        }
      case _ =>
        b.returnOpt.map(_.expOpt) match {
          case Some(Some(e)) => error(e, s"Unexpected return expression.")
          case _ =>
        }
    }
    tc
  }

  def check(stmt: Stmt)(
    implicit mOpt: Option[MethodDecl]): TypeContext = stmt match {
    case VarDecl(isVar, id, t, exp) =>
      id.tipe = TypeChecker.tipe(bitWidth, t)
      check(exp, allowMethod = true)(allowFun = false, mOpt).foreach(tExp =>
        if (!tipeEq(id.tipe, tExp))
          error(stmt, s"${if (isVar) "Var" else "Val"} declaration requires the same type on both left and right expressions, but found ${id.tipe} and $tExp, respectively.")
        else if (tExp.isInstanceOf[MSeq]) {
          exp match {
            case _: SeqLit | _: Clone | _: Prepend | _: Append | _: Random | _: Apply =>
            case TypeMethodCallExp(_: ZSType, Id("create"), _) =>
            case _ =>
              error(stmt, s"Assignment to a var of $tExp type can only be done from a $tExp literal, clone, prepend (+:), append (:+), create, random, and invocation.")
          }
        })
      copy(typeMap = TypeChecker.addId(typeMap, program, id, id.tipe, stmt))
    case Assign(id, exp) =>
      for (tExp <- check(exp, allowMethod = true)(allowFun = false, mOpt))
        typeMap.get(id.value) match {
          case Some((tId, vd: VarDecl, _)) if vd.isVar =>
            id.tipe = tId
            if (!tipeEq(tId, tExp))
              error(stmt, s"Assignment requires the same type on both left and right expressions, but found $tId and $tExp, respectively.")
            else if (tId.isInstanceOf[MSeq])
              exp match {
                case _: SeqLit | _: Clone | _: Prepend | _: Append | _: Random | _: Apply =>
                case TypeMethodCallExp(_: ZSType, Id("create"), _) =>
                case _ =>
                  error(stmt, s"Assignment to a var of $tId type can only be done from a $tId literal, clone, prepend (+:), or append (:+), create, random, and invocation.")
              }
          case _ =>
            error(stmt, s"Can only assign to a var.")
        }
      this
    case Assume(exp) => b(exp)(allowFun = false, mOpt); this
    case Assert(exp) => b(exp)(allowFun = false, mOpt); this
    case ExpStmt(exp) =>
      check(exp, allowMethod = true)(allowFun = false, mOpt); this
    case If(exp, trueBlock, falseBlock) =>
      b(exp)(allowFun = false, mOpt)
      check(trueBlock)
      check(falseBlock)
      this
    case While(exp, block, loopInv) =>
      for (iExp <- loopInv.invariant.exps) b(iExp)(allowFun = true, mOpt)
      b(exp)(allowFun = false, mOpt)
      check(block)
      checkModifies(loopInv.modifies, block, stmt)
      this
    case p: Print =>
      var argTipes = ivectorEmpty[Option[Tipe]]
      for (arg <- p.args) arg match {
        case exp: Exp =>
          check(exp, allowMethod = false)(allowFun = false, mOpt).
            foreach(argTipes :+= Some(_))
        case _ =>
          argTipes :+= None
      }
      p.argTipes = argTipes
      this
    case SeqAssign(id, index, exp) =>
      mseq(id)(allowFun = false, mOpt) match {
        case Some(t) =>
          id.tipe = t
          z(index)(allowFun = false, mOpt)
          check(exp, allowMethod = false)(allowFun = false, mOpt) match {
            case Some(et) =>
              if (!tipeEq(et, t.result))
                error(exp, s"Expecting type ${t.result}, but found $et.")
            case _ =>
          }
        case _ =>
      }
      this
    case md: MethodDecl =>
      var tm = typeMap
      for (p <- md.params)
        tm = TypeChecker.addId(tm, program, p.id, TypeChecker.tipe(bitWidth, p.tpe), p)
      val tc = copy(typeMap = tm)
      for (e <- md.contract.requires.exps) tc.b(e)(allowFun = true, mOpt)
      tc.check(md.block)(Some(md))
      md.returnTypeOpt match {
        case Some(rt) =>
          val t = TypeChecker.tipe(bitWidth, rt)
          val tcPost = copy(
            typeMap = TypeChecker.addId(tm, program, Id("result"), t, md))
          for (e <- md.contract.ensures.exps)
            tcPost.b(e)(allowFun = true, mOpt)
        case None =>
          for (e <- md.contract.ensures.exps) tc.b(e)(allowFun = true, mOpt)
      }
      tc.checkModifies(md.contract.modifies, md.block, md)
      this
    case ProofStmt(proof) => check(proof); this
    case SequentStmt(sequent) =>
      for (e <- sequent.premises) b(e)(allowFun = true, mOpt)
      for (e <- sequent.conclusions) b(e)(allowFun = true, mOpt)
      sequent.proofOpt.foreach(check)
      this
    case InvStmt(inv) => for (e <- inv.exps) b(e)(allowFun = true, mOpt); this
    case FactStmt(facts) =>
      for (f <- facts.factOrFunDecls) f match {
        case f: Fact => b(f.exp)(allowFun = true, None)
        case f: Fun =>
          val rt = f.id.tipe.asInstanceOf[Fn].result
          var tm = typeMap
          for (p <- f.params) {
            p.id.tipe = TypeChecker.tipe(bitWidth, p.tpe)
            tm = TypeChecker.addId(tm, program, p.id, p.id.tipe, p)
          }
          val tc = copy(typeMap = tm)
          for (fd <- f.funDefs) {
            tc.b(fd.cond)(allowFun = true, None)
            tc.check(fd.exp, allowMethod = false)(allowFun = true, None) match {
              case Some(t) =>
                if (!tipeEq(rt, t))
                  error(fd.exp, s"The expression's type does not match function return type.")
              case _ =>
            }
          }
      }
      this
  }

  def check(p: ProofGroup): Unit = {
    var tc = this
    for (step <- p.allSteps) step match {
      case step: QuantAssumeStep =>
        tc = copy(typeMap =
          TypeChecker.addId(typeMap, program, step.id,
            TypeChecker.tipe(bitWidth, step.typeOpt.get), step))
        step match {
          case step: RegularStep =>
            tc.b(step.exp)(allowFun = true, None)
          case _ =>
        }
      case step: FactJust =>
        val id = step.id.value
        factMap.get(id) match {
          case Some((Left(fact), _)) => step.decl = Left3(fact)
          case Some((Right(funDef), _)) => step.decl = Middle3(funDef)
          case _ =>
            typeMap.get(step.id.value) match {
              case Some((_, md: MethodDecl, _)) =>
                if (!md.isPure)
                  error(step.id, s"Could not use a method without @pure as a fact.")
                step.decl = Right3(md)
              case _ =>
                error(step.id, s"Could not resolve fact or method ${step.id.value}.")
            }
        }
        tc.b(step.exp)(allowFun = true, None)
      case step: RegularStep =>
        tc.b(step.exp)(allowFun = true, None)
      case step: ProofGroup => tc.check(step)
      case _ =>
    }
  }

  def checkModifies(m: Modifies, block: Block, node: Node): Unit = {
    var modifiedVars = isetEmpty[Id]
    for (id <- m.ids) {
      if (modifiedVars.contains(id)) {
        warn(id, s"$id has already been declared as modifiable.")
      }
      modifiedVars += id
      typeMap.get(id.value) match {
        case Some((t, VarDecl(true, _, _, _), _)) => id.tipe = t
        case Some((t: MSeq, _, _)) => id.tipe = t
        case Some(_) =>
          error(id, s"Only variable or sequence value can be modified.")
        case _ => tipe(id).foreach(id.tipe = _)
      }
    }
    if (node.isInstanceOf[While])
      for (id <- collectAssignedVars(block) -- modifiedVars if typeMap.contains(id.value)) {
        val li = program.nodeLocMap(id)
        val msg = s"Variable ${id.value} is modified at [${li.lineBegin}, ${li.columnBegin}] inside the loop but not declared in the loop modifies clause."
        if (weakModifies) warn(node, msg) else error(node, msg)
      }
    else {
      var localIds = isetEmpty[Id]
      Visitor.build({
        case VarDecl(true, id, _, _) => localIds += id; false
      })(block)
      for (id <- (collectAssignedVars(block) & typeMap.keySet.map(x => {
        val id = Id(x)
        id.tipe = typeMap(x)._1
        id
      })) -- modifiedVars) {
        val li = program.nodeLocMap(id)
        val msg = s"Variable ${id.value} is modified at [${li.lineBegin}, ${li.columnBegin}] but not declared in the method's modifies clause."
        if (weakModifies) warn(node, msg) else error(node, msg)
      }
    }
  }


  def check(e: Exp, allowMethod: Boolean)(
    implicit allowFun: Boolean,
    mOpt: Option[MethodDecl]): Option[Tipe] =
    e match {
      case _: BooleanLit => someB
      case e: Id => val r = tipe(e); r.foreach(e.tipe = _); r
      case e: Size => mseq(e.exp).foreach(e.tipe = _); someZ
      case e: Clone =>
        if (!allowMethod) error(e.id, s"Clone is only allowed at statement level.")
        mseq(e.id)
      case e: Result =>
        val id = Id("result")
        program.nodeLocMap(id) = program.nodeLocMap(e)
        val r = tipe(id)
        r.foreach(e.tipe = _)
        program.nodeLocMap -= id
        r
      case e: Apply =>
        val isMethod =
          e.exp match {
            case id: Id =>
              typeMap.get(id.value) match {
                case Some((_, md: MethodDecl, _)) =>
                  if (!allowMethod && !md.isPure)
                    error(id, s"Invocation of method without @pure is only allowed at statement level.")
                  e.declOpt = Some(Left(md))
                  true
                case Some((_, f: Fun, _)) =>
                  if (!allowFun)
                    error(id, s"Use of proof function is only allowed in proof context.")
                  e.declOpt = Some(Right(f))
                  false
                case _ =>
                  false
              }
            case _ => false
          }
        check(e.exp, allowMethod = false) match {
          case Some(t: Fn) =>
            if (e.args.size != t.params.size) {
              val text = if (isMethod) "Method" else "Proof function"
              error(e, s"$text ${Exp.toString(e.exp, inProof = allowFun)} requires ${t.params.size} arguments, but found ${e.args.size}.")
            } else if (isMethod) {
              val Some(Left(md)) = e.declOpt
              mOpt.foreach(m => if (!md.isPure && m.isPure) error(e.exp, s"Can only call to another @pure method from a @pure method."))
              if (!md.isPure) for (arg@Id(value) <- e.args) typeMap(value) match {
                case (_: RefTipe, _, _) if mdGlobalsMap(md.id.value).contains(value) =>
                  error(arg, s"Cannot pass non-scalar global variable $value as an argument that can access $value directly.")
                case _ =>
              }
              val modifiedIds = md.contract.modifies.ids.toSet
              val modifiedArgParams: MMap[Exp, Id] = mmapEmpty
              for ((param, arg) <- md.params.zip(e.args)
                   if param.id.tipe.isInstanceOf[RefTipe] &&
                     modifiedIds.contains(param.id) &&
                     !arg.isInstanceOf[SeqLit] &&
                     !modifiedArgParams.contains(arg)) {
                modifiedArgParams(arg) = param.id
              }
              for ((param, arg) <- md.params.zip(e.args)
                   if param.id.tipe.isInstanceOf[RefTipe]) {
                modifiedArgParams.get(arg) match {
                  case Some(pid) if pid.value != param.id.value =>
                    error(arg, s"Cannot pass ${Exp.toString(arg, inProof = false)} for parameter ${param.id.value} because it will be passed for modified parameter ${pid.value}.")
                  case _ =>
                }
              }
            }
            for ((arg, pType) <- e.args.zip(t.params)) {
              if (pType == Z) z(arg)
              else check(arg, allowMethod = false) match {
                case Some(`pType`) =>
                case Some(x) =>
                  error(arg, s"Expecting type $pType, but found $x.")
                case _ =>
              }
            }
            e.expTipe = t
            Some(t.result)
          case Some(t) =>
            if (e.args.size == 1)
              error(e.exp, s"Expecting a function/sequence type, but found $t.")
            else
              error(e.exp, s"Expecting a function type, but found $t.")
            None
          case _ => None
        }
      case _: RandomInt =>
        if (!allowMethod)
          error(e, s"Invoking randomInt is only allowed at statement level.")
        someZ
      case _: ReadInt =>
        if (!allowMethod)
          error(e, s"Invoking readInt is only allowed at statement level.")
        someZ
      case e: IntLit => Some(Tipe.normalize(bitWidth,
        e.tpeOpt.map(TypeChecker.tipe(bitWidth, _)).getOrElse(Z)))
      case e: FloatLit => e.primitiveValue match {
        case Left(_: Float) => Some(F32)
        case Right(_: Double) => Some(F64)
      }
      case _: RealLit => someR
      case e: IntMin => Some(TypeChecker.tipe(bitWidth, e.integralType))
      case e: IntMax => Some(TypeChecker.tipe(bitWidth, e.integralType))
      case e: Random =>
        if (!allowMethod)
          error(e, s"Invoking .random is only allowed at statement level.")
        Some(TypeChecker.tipe(bitWidth, e.tpe))
      case e: TypeMethodCallExp =>
        if (!allowMethod)
          error(e, s"Invoking ${e.id.value} is only allowed at statement level.")
        val mst = TypeChecker.tipe(bitWidth, e.tpe).asInstanceOf[MSeq]
        e.id.tipe = FunTipe(ivector(Z, mst.result), mst)
        e.id.value match {
          case "create" =>
            if (e.args.size != 2)
              error(e, s"Invoking create requires 2 arguments instead of ${e.args.size}.")
            else {
              z(e.args(0))
              check(e.args(1), allowMethod = false) match {
                case Some(t) =>
                  if (!tipeEq(mst.result, t))
                    error(e, s"Invalid default value for elements of ${e.tpe}.")
                case _ =>
              }
            }
        }
        Some(mst)
      case e: BinaryExp =>
        e match {
          case _: Mul | _: Div | _: Rem | _: Add | _: Sub =>
            (number(e.left), number(e.right)) match {
              case (Some(tLeft), Some(tRight)) =>
                if (!tipeEq(tLeft, tRight)) {
                  val op = e.op(false)
                  error(e.right, s"The $op binary operator requires the same type on both left and right expressions, but found $tLeft and $tRight, respectively.")
                  None
                } else {
                  e.tipe = tLeft
                  Some(tLeft)
                }
              case _ => None
            }
          case _: Lt | _: Le | _: Gt | _: Ge =>
            (number(e.left), number(e.right)) match {
              case (Some(tLeft), Some(tRight)) =>
                if (!tipeEq(tLeft, tRight)) {
                  val op = e.op(false)
                  error(e.right, s"The $op binary operator requires the same type on both left and right expressions, but found $tLeft and $tRight, respectively.")
                  None
                } else if ((tLeft == F32 || tLeft == F64) && (e.isInstanceOf[Le] || e.isInstanceOf[Ge])) {
                  val op = e.op(false)
                  error(e.right, s"Cannot compare $tLeft with $op (only < or > are allowed).")
                  None
                } else {
                  e.tipe = tLeft
                  someB
                }
              case _ => None
            }
          case _: Shl | _: Shr =>
            (m(e.left), m(e.right)) match {
              case (Some(tLeft), Some(tRight)) =>
                if (!tipeEq(tLeft, tRight)) {
                  val op = e.op(false)
                  error(e.right, s"The $op binary operator requires the same type on both left and right expressions, but found $tLeft and $tRight, respectively.")
                  None
                } else {
                  e.tipe = tLeft
                  Some(tLeft)
                }
              case _ => None
            }
          case _: UShr =>
            (ms(e.left), ms(e.right)) match {
              case (Some(tLeft), Some(tRight)) =>
                if (!tipeEq(tLeft, tRight)) {
                  val op = e.op(false)
                  error(e.right, s"The $op binary operator requires the same type on both left and right expressions, but found $tLeft and $tRight, respectively.")
                  None
                } else {
                  e.tipe = tLeft
                  Some(tLeft)
                }
              case _ => None
            }
          case e: EqualityExp =>
            for (tLeft <- check(e.left, allowMethod = false); tRight <- check(e.right, allowMethod = false))
              if (!tipeEq(tLeft, tRight)) {
                val op = if (e.isInstanceOf[Eq]) "equal" else "not-equal"
                error(e.right, s"The $op binary operator requires the same type on both left and right expressions, but found $tLeft and $tRight, respectively.")
              } else if (tLeft == F32 || tLeft == F64) {
                val op = e.op(false)
                error(e.right, s"Cannot compare $tLeft with $op (only < or > are allowed).")
                None
              } else {
                e.tipe = tLeft
              }
            someB
          case e: Append =>
            (mseq(e.left), check(e.right, allowMethod = false)) match {
              case (Some(tLeft), Some(tRight)) =>
                if (!tipeEq(tLeft.result, tRight)) {
                  error(e, s"Ill-typed append operation $tLeft :+ $tRight.")
                  None
                } else {
                  e.tipe = tLeft
                  Some(tLeft)
                }
              case _ => None
            }
          case _: Prepend =>
            (check(e.left, allowMethod = false), mseq(e.right)) match {
              case (Some(tLeft), Some(tRight)) =>
                if (!tipeEq(tLeft, tRight.result)) {
                  error(e, s"Ill-typed prepend operation $tLeft +: $tRight.")
                  None
                } else {
                  e.tipe = tRight
                  Some(tRight)
                }
              case _ => None
            }
          case _: And | _: Or | _: Xor =>
            (check(e.left, allowMethod = false), check(e.right, allowMethod = false)) match {
              case (Some(tLeft), Some(tRight)) =>
                if (!(tLeft == tRight &&
                  (tLeft == B || tLeft.isInstanceOf[ModuloIntegralTipe]))) {
                  error(e, s"Ill-typed operation $tLeft ${e.op(false)} $tRight.")
                  None
                } else {
                  e.tipe = tLeft
                  Some(tLeft)
                }
              case _ => None
            }
          case _: Implies =>
            b(e.left); b(e.right); e.tipe = B; someB
        }
      case e: Not =>
        check(e.exp, allowMethod = false) match {
          case Some(t) =>
            if (!(t == B || t.isInstanceOf[ModuloIntegralTipe])) {
              error(e, s"Ill-typed operation ${e.op(false)}$t.")
              None
            } else {
              e.tipe = t
              Some(t)
            }
          case _ => None
        }
      case e: Minus =>
        number(e.exp) match {
          case Some(t) if TypeChecker.posNegTipes.contains(t) =>
            e.tipe = t
            Some(t)
          case _ => None
        }
      case e: Quant[_] =>
        val tOpt: Option[Tipe] = e.domainOpt match {
          case Some(TypeDomain(tpe)) => Some(TypeChecker.tipe(bitWidth, tpe))
          case Some(rd@RangeDomain(lo, hi, _, _)) =>
            val loT = check(lo, allowMethod)
            val hiT = check(hi, allowMethod)
            if (loT.isDefined && hiT.isDefined) {
              if (!tipeEq(loT.get, hiT.get)) {
                error(rd, s"Mismatch range type: ${loT.get} .. ${hiT.get}.")
                None
              } else if (!loT.get.isInstanceOf[NumberTipe]) {
                error(rd, s"Expecting numbers for range, but found: ${loT.get}.")
                None
              } else {
                rd.tipe = loT.get
                loT
              }
            } else None
          case None =>
            assert(assertion = false, "Unexpected situation.")
            None
        }
        tOpt.foreach { t =>
          var tm = typeMap
          for (id <- e.ids) {
            tm = TypeChecker.addId(tm, program, id, t, e)
            id.tipe = t
          }
          copy(typeMap = tm).check(e.exp, allowMethod = false)
        }
        someB
      case e: SeqLit =>
        val ts = TypeChecker.tipe(bitWidth, e.tpe).asInstanceOf[MSeq]
        val et = ts.result
        if (bitWidth != 0 && e.args.size > zMax) {
          error(e, s"Cannot have a sequence larger than $zMax for bit-width $bitWidth.")
        }
        for (arg <- e.args; t <- check(arg, allowMethod = false)) {
          if (!tipeEq(et, t)) {
            error(arg, s"Expecting an expression of type $et, but found $t.")
          }
        }
        Some(ts)
    }

  def tipeEq(t1: Tipe, t2: Tipe): Boolean = (t1, t2) match {
    case (Z, Z) => true
    case (N, N) => true
    case (Z, _) =>
      bitWidth match {
        case 0 => Z == t2
        case 8 => Z8 == t2
        case 16 => Z16 == t2
        case 32 => Z32 == t2
        case 64 => Z64 == t2
      }
    case (_, Z) => bitWidth match {
      case 0 => Z == t1
      case 8 => Z8 == t1
      case 16 => Z16 == t1
      case 32 => Z32 == t1
      case 64 => Z64 == t1
    }
    case (N, _) => bitWidth match {
      case 0 => N == t2
      case 8 => Z8 == t2
      case 16 => Z16 == t2
      case 32 => Z32 == t2
      case 64 => Z64 == t2
    }
    case (_, N) => bitWidth match {
      case 0 => N == t1
      case 8 => Z8 == t1
      case 16 => Z16 == t1
      case 32 => Z32 == t1
      case 64 => Z64 == t1
    }
    case _ => t1 == t2
  }

  def collectAssignedVars(b: Block): ISet[Id] = {
    var r = isetEmpty[Id]
    var lids = isetEmpty[Id]

    def collect(e: Exp): Unit = e match {
      case a: Apply => a.declOpt match {
        case Some(Left(md)) =>
          val paramIds = md.params.map(_.id)
          val modifiedIds = md.contract.modifies.ids.toSet
          r ++= (modifiedIds -- paramIds)
          for ((argId@Id(_), paramId) <- a.args.zip(paramIds) if
          argId.tipe.isInstanceOf[MSeq] && modifiedIds.contains(paramId))
            r += argId
        case _ =>
      }
      case _ =>
    }

    Visitor.build({
      case VarDecl(_, id, _, e) => lids += id; collect(e); false
      case Assign(id, e) if !lids.contains(id) => r += id; collect(e); false
      case SeqAssign(id, _, _) => r += id; false
      case w: While => r ++= (w.loopInv.modifies.ids.toSet -- lids); false
    })(b)
    r
  }

  def b(e: Exp)(implicit allowFun: Boolean, mOpt: Option[MethodDecl]): Unit =
    check(e, allowMethod = false) match {
      case Some(B) =>
      case Some(t) => error(e, s"Expecting an expression of type B, but found $t.")
      case _ =>
    }

  def z(e: Exp)(implicit allowFun: Boolean, mOpt: Option[MethodDecl]): Unit =
    for (t <- check(e, allowMethod = false)) {
      if (!tipeEq(Z, t)) {
        error(e, s"Expecting an expression of type Z, but found $t.")
      }
    }

  def number(e: Exp)(implicit allowFun: Boolean, mOpt: Option[MethodDecl]): Option[NumberTipe] =
    check(e, allowMethod = false) match {
      case Some(t: NumberTipe) => Some(t)
      case Some(t) => error(e, s"Expecting an expression of number type, but found $t."); None
      case _ => None
    }

  def integral(e: Exp)(implicit allowFun: Boolean, mOpt: Option[MethodDecl]): Option[IntegralTipe] =
    check(e, allowMethod = false) match {
      case Some(t: IntegralTipe) => Some(t)
      case Some(t) => error(e, s"Expecting an expression of type integer, but found $t."); None
      case _ => None
    }

  def m(e: Exp)(implicit allowFun: Boolean, mOpt: Option[MethodDecl]): Option[ModuloIntegralTipe] =
    check(e, allowMethod = false) match {
      case Some(t: ModuloIntegralTipe) => Some(t)
      case Some(t) => error(e, s"Expecting an expression of type modulo integer, but found $t."); None
      case _ => None
    }

  def ms(e: Exp)(implicit allowFun: Boolean, mOpt: Option[MethodDecl]): Option[ModuloIntegralTipe with SignedIntegralTipe] =
    check(e, allowMethod = false) match {
      case Some(t: ModuloIntegralTipe with SignedIntegralTipe) => Some(t)
      case Some(t) => error(e, s"Expecting an expression of type signed modulo integer, but found $t."); None
      case _ => None
    }

  def mseq(e: Exp)(implicit allowFun: Boolean, mOpt: Option[MethodDecl]): Option[MSeq] =
    check(e, allowMethod = false) match {
      case Some(t: MSeq) => Some(t)
      case Some(t) => error(e, s"Expecting an expression of type mutable sequence, but found $t."); None
      case _ => None
    }

  def tipe(id: Id): Option[Tipe] = typeMap.get(id.value) match {
    case Some((t, _, _)) => Some(t)
    case _ =>
      nameOfSymExeOld(id.value) match {
        case Some(x) => typeMap.get(x) match {
          case Some((t, _, _)) => Some(t)
          case _ =>
            error(id, s"Undeclared identifier ${id.value}.")
            None
        }
        case _ =>
          if (id.value.endsWith("_old")) {
            typeMap.get(id.value.substring(0, id.value.length - 4)) match {
              case Some((t, _, _)) => return Some(t)
              case _ =>
            }
          } else if (id.value.endsWith("_in")) {
            typeMap.get(id.value.substring(0, id.value.length - 3)) match {
              case Some((t, _, _)) => return Some(t)
              case _ =>
            }
          }
          error(id, s"Undeclared identifier ${id.value}.")
          None
      }
  }

  def nameOfSymExeOld(x: String): Option[String] = {
    val i = x.indexOf('_')
    if (i < 0) return None
    for (j <- i until x.length)
      if (!x.charAt(j).isDigit)
        return None
    Some(x.substring(0, i))
  }

  def warn(n: Node, msg: String): Unit =
    reporter.report(program.nodeLocMap(n).
      toLocationWarning(program.fileUriOpt, TypeChecker.kind, msg))

  def error(n: Node, msg: String): Unit =
    reporter.report(program.nodeLocMap(n).
      toLocationError(program.fileUriOpt, TypeChecker.kind, msg))
}


