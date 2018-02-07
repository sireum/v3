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

package org.sireum.lang.ast

import org.sireum._

@datatype trait TopUnit {
  @pure def fileUriOpt: Option[String]
}

object TopUnit {

  @datatype class Program(val fileUriOpt: Option[String], packageName: Name, body: Body) extends TopUnit

  @datatype class SequentUnit(val fileUriOpt: Option[String], sequent: LClause.Sequent) extends TopUnit

  @datatype class TruthTableUnit(
    val fileUriOpt: Option[String],
    stars: ISZ[PosInfo],
    vars: ISZ[Id],
    separator: PosInfo,
    isSequent: B,
    sequent: LClause.Sequent,
    rows: ISZ[TruthTable.Row],
    conclusionOpt: Option[TruthTable.Conclusion]
  ) extends TopUnit

}

@datatype trait Stmt {
  def posOpt: Option[PosInfo]

  def asAssignExp: AssignExp = {
    halt(s"Invalid operation 'asAssignExp' on $this.")
  }
}

@sig sealed trait AssignExp {

  @pure def asStmt: Stmt

  @pure def exprs: ISZ[Stmt.Expr] = {
    this match {
      case stmt: Stmt.Expr => return ISZ(stmt)
      case stmt: Stmt.Block =>
        return ops.ISZOps(stmt.body.stmts).last.asAssignExp.exprs
      case stmt: Stmt.If =>
        return ops.ISZOps(stmt.thenBody.stmts).last.asAssignExp.exprs ++
          ops.ISZOps(stmt.elseBody.stmts).last.asAssignExp.exprs
      case stmt: Stmt.Match =>
        return for (c <- stmt.cases;
          e <- ops.ISZOps(c.body.stmts).last.asAssignExp.exprs)
          yield e
      case _: Stmt.Return => return ISZ()
    }
  }
}

@enum object Purity {
  'Impure
  'Pure
  'Memoize
}

object Stmt {

  @datatype class Import(importers: ISZ[Import.Importer], @hidden attr: Attr) extends Stmt {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

  }

  object Import {

    @datatype class Importer(name: Name, selectorOpt: Option[Selector])

    @datatype trait Selector

    @datatype class MultiSelector(selectors: ISZ[NamedSelector]) extends Selector

    @datatype class WildcardSelector extends Selector

    @datatype class NamedSelector(from: Id, to: Id)

  }

  @datatype class Var(isVal: B, id: Id, tipeOpt: Option[Type], initOpt: Option[AssignExp], @hidden attr: Attr)
      extends Stmt {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

  }

  @datatype class VarPattern(isVal: B, pattern: Pattern, tipeOpt: Option[Type], init: AssignExp, @hidden attr: Attr)
      extends Stmt {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

  }

  @datatype class SpecVar(isVal: B, id: Id, tipe: Type, @hidden attr: Attr) extends Stmt {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

  }

  @datatype class Method(
    purity: Purity.Type,
    hasOverride: B,
    isHelper: B,
    sig: MethodSig,
    contract: Contract,
    bodyOpt: Option[Body],
    @hidden attr: Attr
  ) extends Stmt {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

  }

  @datatype class ExtMethod(isPure: B, sig: MethodSig, contract: Contract, @hidden attr: Attr) extends Stmt {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

  }

  @datatype class SpecMethod(sig: MethodSig, defs: ISZ[SpecDef], where: ISZ[WhereDef], @hidden attr: Attr)
      extends Stmt {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

  }

  @datatype class Enum(id: Id, elements: ISZ[Id], @hidden attr: Attr) extends Stmt {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

  }

  @datatype class SubZ(
    id: Id,
    isSigned: B,
    isBitVector: B,
    isWrapped: B,
    hasMin: B,
    hasMax: B,
    bitWidth: Z,
    min: Z,
    max: Z,
    index: Z,
    @hidden attr: Attr
  ) extends Stmt {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    def isZeroIndex: B = {
      return index == 0
    }
  }

  @datatype class Object(isExt: B, id: Id, parents: ISZ[Type], stmts: ISZ[Stmt], @hidden attr: Attr) extends Stmt {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

  }

  @datatype class Sig(
    isImmutable: B,
    isExt: B,
    id: Id,
    typeParams: ISZ[TypeParam],
    parents: ISZ[Type.Named],
    stmts: ISZ[Stmt],
    @hidden attr: Attr
  ) extends Stmt {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

  }

  @datatype class AbstractDatatype(
    isRoot: B,
    isDatatype: B,
    id: Id,
    typeParams: ISZ[TypeParam],
    params: ISZ[AbstractDatatypeParam],
    parents: ISZ[Type.Named],
    stmts: ISZ[Stmt],
    @hidden attr: Attr
  ) extends Stmt {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

  }

  @datatype class TypeAlias(id: Id, typeParams: ISZ[TypeParam], tipe: Type, @hidden attr: Attr) extends Stmt {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

  }

  @datatype class Assign(lhs: Exp, rhs: AssignExp, @hidden attr: Attr) extends Stmt {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

  }

  @datatype class Block(body: Body, @hidden attr: Attr) extends Stmt with AssignExp {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def asAssignExp: AssignExp = {
      return this
    }

    @pure override def asStmt: Stmt = {
      return this
    }

  }

  @datatype class If(cond: Exp, thenBody: Body, elseBody: Body, @hidden attr: Attr) extends Stmt with AssignExp {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def asAssignExp: AssignExp = {
      return this
    }

    @pure override def asStmt: Stmt = {
      return this
    }
  }

  @datatype class Match(exp: Exp, cases: ISZ[Case], @hidden attr: Attr) extends Stmt with AssignExp {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def asAssignExp: AssignExp = {
      return this
    }

    @pure override def asStmt: Stmt = {
      return this
    }

  }

  @datatype class While(cond: Exp, invariants: ISZ[ContractExp], modifies: ISZ[Exp], body: Body, @hidden attr: Attr)
      extends Stmt {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

  }

  @datatype class DoWhile(cond: Exp, invariants: ISZ[ContractExp], modifies: ISZ[Exp], body: Body, @hidden attr: Attr)
      extends Stmt {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

  }

  @datatype class For(
    enumGen: EnumGen.For,
    invariants: ISZ[ContractExp],
    modifies: ISZ[Exp],
    body: Body,
    @hidden attr: Attr
  ) extends Stmt {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

  }

  @datatype class Return(expOpt: Option[Exp], @hidden attr: TypedAttr) extends Stmt with AssignExp {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def asStmt: Stmt = {
      return this
    }

  }

  @datatype class LStmt(clause: LClause, @hidden val attr: Attr) extends Stmt {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

  }

  @datatype class Expr(exp: Exp, @hidden attr: Attr) extends Stmt with AssignExp {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure def typedOpt: Option[Typed] = {
      return exp.typedOpt
    }

    @pure override def asAssignExp: AssignExp = {
      return this
    }

    @pure override def asStmt: Stmt = {
      return this
    }

  }

}

@datatype trait LClause

object LClause {

  @datatype class Invariants(value: ISZ[ContractExp]) extends LClause

  @datatype class Facts(value: ISZ[Fact]) extends LClause

  @datatype class Fact(id: Id, exp: Exp)

  @datatype class Theorems(value: ISZ[Theorem]) extends LClause

  @datatype class Theorem(id: Id, sequent: Sequent)

  @datatype class Sequent(premises: ISZ[Exp], conclusions: ISZ[Exp], proofOpt: Option[Proof]) extends LClause

  @datatype class Proof(steps: ISZ[ProofStep]) extends LClause

}

@datatype class ContractExp(idOpt: Option[Id], exp: Exp)

@datatype class Case(pattern: Pattern, condOpt: Option[Exp], body: Body)

object EnumGen {

  @datatype trait Range

  object Range {

    @datatype class Expr(isReverse: B, exp: Exp) extends Range

    @datatype class Indices(isReverse: B, exp: Exp) extends Range

    @datatype class Step(isInclusive: B, start: Exp, end: Exp, byOpt: Option[Exp]) extends Range

  }

  @datatype class For(idOpt: Option[Id], range: Range, condOpt: Option[Exp])

}

@datatype trait Type {

  @pure def posOpt: Option[PosInfo]

  @pure def typedOpt: Option[Typed]

  @pure def typed(t: Typed): Type
}

object Type {

  @datatype class Named(name: Name, typeArgs: ISZ[Type], attr: TypedAttr) extends Type {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return attr.typedOpt
    }

    @pure override def typed(t: Typed): Named = {
      return this(name, typeArgs, attr(typedOpt = Some(t)))
    }

  }

  @datatype class Fun(isPure: B, isByName: B, args: ISZ[Type], ret: Type, attr: TypedAttr) extends Type {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return attr.typedOpt
    }

    @pure override def typed(t: Typed): Fun = {
      return this(isPure, isByName, args, ret, attr(typedOpt = Some(t)))
    }

  }

  @datatype class Tuple(args: ISZ[Type], attr: TypedAttr) extends Type {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return attr.typedOpt
    }

    @pure override def typed(t: Typed): Tuple = {
      return this(args, attr(typedOpt = Some(t)))
    }

  }

}

@datatype trait Pattern

object Pattern {

  @datatype class Literal(lit: Lit) extends Pattern

  @datatype class LitInterpolate(prefix: String, value: String, @hidden attr: TypedAttr) extends Pattern

  @datatype class Ref(name: Name, @hidden attr: ResolvedAttr) extends Pattern

  @datatype class VarBinding(id: Id, typeOpt: Option[Type], @hidden attr: Attr) extends Pattern

  @datatype class Wildcard(typeOpt: Option[Type], @hidden attr: Attr) extends Pattern

  @datatype class SeqWildcard(@hidden attr: TypedAttr) extends Pattern

  @datatype class Structure(
    idOpt: Option[Id],
    nameOpt: Option[Name],
    patterns: ISZ[Pattern],
    @hidden attr: ResolvedAttr
  ) extends Pattern

}

@datatype trait Exp {

  @pure def posOpt: Option[PosInfo]

  @pure def typedOpt: Option[Typed]

}

@sig sealed trait Lit

object Exp {

  @datatype class LitB(value: B, @hidden attr: Attr) extends Exp with Lit {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return Typed.bOpt
    }
  }

  @datatype class LitC(value: C, @hidden attr: Attr) extends Exp with Lit {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return Typed.cOpt
    }
  }

  @datatype class LitZ(value: Z, @hidden attr: Attr) extends Exp with Lit {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return Typed.zOpt
    }
  }

  @datatype class LitF32(value: F32, @hidden attr: Attr) extends Exp with Lit {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return Typed.f32Opt
    }
  }

  @datatype class LitF64(value: F64, @hidden attr: Attr) extends Exp with Lit {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return Typed.f64Opt
    }
  }

  @datatype class LitR(value: R, @hidden attr: Attr) extends Exp with Lit {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return Typed.rOpt
    }
  }

  @datatype class LitString(value: String, @hidden attr: Attr) extends Exp with Lit {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return Typed.stringOpt
    }
  }

  @datatype class StringInterpolate(prefix: String, lits: ISZ[LitString], args: ISZ[Exp], @hidden attr: TypedAttr)
      extends Exp {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return attr.typedOpt
    }
  }

  @datatype class This(@hidden attr: TypedAttr) extends Exp {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return attr.typedOpt
    }
  }

  @datatype class Super(@hidden attr: TypedAttr) extends Exp {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return attr.typedOpt
    }
  }

  @enum object UnaryOp {
    'Not
    'Plus
    'Minus
    'Complement
  }

  @datatype class Unary(op: UnaryOp.Type, exp: Exp, @hidden attr: TypedAttr) extends Exp {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return attr.typedOpt
    }
  }

  @enum object BinaryOp {
    'Add
    'Sub
    'Mul
    'Div
    'Rem
    'Eq
    'Ne
    'Shl
    'Shr
    'Ushr
    'Lt
    'Le
    'Gt
    'Ge
    'And
    'Or
    'Xor
    'Imply
    'CondAnd
    'CondOr
    'Append
    'Prepend
    'AppendAll
    'RemoveAll
    'MapsTo
  }

  @sig sealed trait Ref {
    @pure def targs: ISZ[Type]

    @pure def asExp: Exp
  }

  @datatype class Binary(left: Exp, op: BinaryOp.Type, right: Exp, @hidden attr: TypedAttr) extends Exp {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return attr.typedOpt
    }
  }

  object Ident {

    val targs: ISZ[Type] = ISZ()

  }

  @datatype class Ident(id: Id, @hidden attr: ResolvedAttr) extends Exp with Ref {

    @pure override def targs: ISZ[Type] = {
      return Ident.targs
    }

    @pure override def asExp: Exp = {
      return this
    }

    @pure override def hash: Z = {
      attr.resOpt match {
        case Some(res) => return res.hash
        case _ => return id.hash
      }
    }

    @pure def isEqual(other: Ident): B = {
      (attr.resOpt, other.attr.resOpt) match {
        case (Some(res), Some(otherRes)) => return res == otherRes
        case _ => return id == other.id
      }
    }

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return attr.typedOpt
    }
  }

  @datatype class Eta(ref: Ref, @hidden attr: TypedAttr) extends Exp {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return attr.typedOpt
    }
  }

  @datatype class Tuple(args: ISZ[Exp], @hidden attr: TypedAttr) extends Exp {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return attr.typedOpt
    }
  }

  @datatype class Select(receiverOpt: Option[Exp], id: Id, val targs: ISZ[Type], @hidden attr: ResolvedAttr)
      extends Exp with Ref {

    @pure override def asExp: Exp = {
      return this
    }

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return attr.typedOpt
    }
  }

  @datatype class Invoke(receiverOpt: Option[Exp], id: Id, targs: ISZ[Type], args: ISZ[Exp], @hidden attr: ResolvedAttr)
      extends Exp {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return attr.typedOpt
    }
  }

  @datatype class InvokeNamed(
    receiverOpt: Option[Exp],
    id: Id,
    targs: ISZ[Type],
    args: ISZ[NamedArg],
    @hidden attr: ResolvedAttr
  ) extends Exp {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return attr.typedOpt
    }
  }

  @datatype class If(cond: Exp, thenExp: Exp, elseExp: Exp, @hidden attr: TypedAttr) extends Exp {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return attr.typedOpt
    }
  }

  object Fun {

    @datatype class Param(id: Id, tipeOpt: Option[Type])

  }

  @datatype class Fun(params: ISZ[Fun.Param], contract: Contract, exp: AssignExp, @hidden attr: TypedAttr) extends Exp {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return attr.typedOpt
    }
  }

  @datatype class ForYield(enumGens: ISZ[EnumGen.For], exp: Exp, @hidden attr: TypedAttr) extends Exp {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return attr.typedOpt
    }
  }

  @datatype class Quant(isForall: B, varFragments: ISZ[VarFragment], exp: Exp, @hidden attr: Attr) extends Exp {

    @pure override def posOpt: Option[PosInfo] = {
      return attr.posOpt
    }

    @pure override def typedOpt: Option[Typed] = {
      return Typed.bOpt
    }
  }

}

@datatype class NamedArg(id: Id, arg: Exp, index: Z)

@datatype class VarFragment(ids: ISZ[Id], domainOpt: Option[Domain])

@datatype trait Domain {
  def attr: TypedAttr
}

object Domain {

  @datatype class Type(tipe: org.sireum.lang.ast.Type, @hidden val attr: TypedAttr) extends Domain

  @datatype class Range(lo: Exp, loExact: B, hi: Exp, hiExact: B, @hidden val attr: TypedAttr) extends Domain

}

@datatype class Id(value: String, @hidden attr: Attr)

@datatype class Name(ids: ISZ[Id], @hidden attr: Attr)

@datatype class Body(stmts: ISZ[Stmt], @hidden undecls: ISZ[String])

@datatype class AbstractDatatypeParam(isHidden: B, isVal: B, id: Id, tipe: Type)

@datatype class MethodSig(
  isPure: B,
  id: Id,
  typeParams: ISZ[TypeParam],
  hasParams: B,
  params: ISZ[Param],
  returnType: Type
) {

  @pure def funType: Typed.Fun = {
    var pts = ISZ[Typed]()
    for (p <- params) {
      pts = pts :+ p.tipe.typedOpt.get
    }
    val t = Typed.Fun(isPure, !hasParams, pts, returnType.typedOpt.get)
    t match {
      case t: Typed.Fun => return t
      case _ => halt("Infeasible")
    }
  }
}

@datatype class Param(isHidden: B, id: Id, tipe: Type)

@datatype class TypeParam(id: Id)

@datatype class Contract(
  reads: ISZ[Exp],
  requires: ISZ[ContractExp],
  modifies: ISZ[Exp],
  ensures: ISZ[ContractExp],
  subs: ISZ[SubContract]
)

@datatype class SubContract(id: Id, params: ISZ[Id], contract: Contract)

@datatype trait WhereDef

object WhereDef {

  @datatype class Val(id: Id, tipe: Type, exp: Exp) extends WhereDef

  @datatype class Def(id: Id, params: ISZ[Param], rTipe: Type, defs: ISZ[SpecDef]) extends WhereDef

}

@datatype class SpecDef(idOpt: Option[Id], exp: Exp, isOtherwise: B, patternOpt: Option[Pattern], guardOpt: Option[Exp])

@datatype trait ProofStep {
  def step: Exp.LitZ
}

object ProofStep {

  @datatype class Basic(val step: Exp.LitZ, exp: Exp, just: Just) extends ProofStep

  @datatype class SubProof(val step: Exp.LitZ, assumeStep: AssumeProofStep, steps: ISZ[ProofStep]) extends ProofStep

}

@datatype trait AssumeProofStep {
  def step: Exp.LitZ
}

object AssumeProofStep {

  @datatype class Regular(val step: Exp.LitZ, exp: Exp) extends AssumeProofStep

  @datatype class ForallIntroAps(val step: Exp.LitZ, varFragments: ISZ[VarFragment]) extends AssumeProofStep

  @datatype class ExistsElimAps(val step: Exp.LitZ, varFragments: ISZ[VarFragment], exp: Exp) extends AssumeProofStep

}

@datatype trait Just {
  def attr: Attr
}

object Just {

  @datatype class Premise(@hidden val attr: Attr) extends Just

  @datatype class AndIntro(steps: ISZ[Exp.LitZ], @hidden val attr: Attr) extends Just

  @datatype class AndElim(is1: B, andStep: Exp.LitZ, @hidden val attr: Attr) extends Just

  @datatype class OrIntro(is1: B, step: Exp.LitZ, @hidden val attr: Attr) extends Just

  @datatype class OrElim(orStep: Exp.LitZ, subProofSteps: ISZ[Exp.LitZ], @hidden val attr: Attr) extends Just

  @datatype class ImplyIntro(subProofStep: Exp.LitZ, @hidden val attr: Attr) extends Just

  @datatype class ImplyElim(implyStep: Exp.LitZ, steps: ISZ[Exp.LitZ], @hidden val attr: Attr) extends Just

  @datatype class NegIntro(subProofStep: Exp.LitZ, @hidden val attr: Attr) extends Just

  @datatype class NegElim(step: Exp.LitZ, negStep: Exp.LitZ, @hidden val attr: Attr) extends Just

  @datatype class BottomElim(subProofStep: Exp.LitZ, @hidden val attr: Attr) extends Just

  @datatype class Pbc(subProofStep: Exp.LitZ, @hidden val attr: Attr) extends Just

  @datatype class ForallIntro(subProofStep: Exp.LitZ, @hidden val attr: Attr) extends Just

  @datatype class ForallElim(forallStep: Exp.LitZ, args: ISZ[Exp], @hidden val attr: Attr) extends Just

  @datatype class ExistsIntro(existsStep: Exp.LitZ, args: ISZ[Exp], @hidden val attr: Attr) extends Just

  @datatype class ExistsElim(existsStep: Exp.LitZ, subProofStep: Exp.LitZ, @hidden val attr: Attr) extends Just

  @datatype class Fact(name: Name, @hidden val attr: Attr) extends Just

  @datatype class Invariant(nameOpt: Option[Name], @hidden val attr: Attr) extends Just

  @datatype class Subst(isRight: B, eqStep: Exp.LitZ, step: Exp.LitZ, @hidden val attr: Attr) extends Just

  @datatype class Auto(isAlgebra: B, steps: ISZ[Exp.LitZ], @hidden val attr: Attr) extends Just

  @datatype class Coq(path: Exp.LitString, steps: ISZ[Exp.LitZ], @hidden val attr: Attr) extends Just

}

object TruthTable {

  @datatype class Row(assignment: Assignment, separator: PosInfo, values: Assignment)

  @datatype class Assignment(values: ISZ[Exp.LitB], @hidden attr: Attr)

  @datatype trait Conclusion {
    def attr: Attr
  }

  object Conclusion {

    @datatype class Validity(isValid: B, assignments: ISZ[Assignment], @hidden val attr: Attr) extends Conclusion

    @datatype class Tautology(@hidden val attr: Attr) extends Conclusion

    @datatype class Contradictory(@hidden val attr: Attr) extends Conclusion

    @datatype class Contingent(
      trueAssignments: ISZ[Assignment],
      falseAssignments: ISZ[Assignment],
      @hidden val attr: Attr
    ) extends Conclusion

  }

}

@datatype trait Typed {

  @pure def isPureFun: B

  @pure def subst(map: HashMap[String, Typed]): Typed

  @pure def isEqual(other: Typed): B = {
    (this, other) match {
      case (t1: Typed.Name, t2: Typed.Name) =>
        if (t1.args.size != t2.args.size) {
          return F
        }
        if (t1.ids != t2.ids) {
          return F
        }
        for (i <- z"0" until t1.args.size) {
          if (t1.args(i) != t2.args(i)) {
            return F
          }
        }
        return T
      case (t1: Typed.Tuple, t2: Typed.Tuple) =>
        if (t1.args.size != t2.args.size) {
          return F
        }
        for (i <- z"0" until t1.args.size) {
          if (t1.args(i) != t2.args(i)) {
            return F
          }
        }
        return T
      case (t1: Typed.Fun, t2: Typed.Fun) =>
        if (t1.isPure != t2.isPure || t1.isByName != t2.isByName) {
          return F
        }
        if (t1.args.size != t2.args.size) {
          return F
        }
        if (t1.ret != t2.ret) {
          return F
        }
        for (i <- z"0" until t1.args.size) {
          if (t1.args(i) != t2.args(i)) {
            return F
          }
        }
        return T
      case (t1: Typed.TypeVar, t2: Typed.TypeVar) =>
        return t1.id == t2.id
      case (t1: Typed.Fun, _) if t1.isByName =>
        return t1.ret == other
      case (_, t2: Typed.Fun) if t2.isByName =>
        return this == t2.ret
      case (t1: Typed.Package, t2: Typed.Package) =>
        return t1.name == t2.name
      case (t1: Typed.Object, t2: Typed.Object) =>
        return t1.name == t2.name
      case (t1: Typed.Enum, t2: Typed.Enum) =>
        return t1.name == t2.name
      case (t1: Typed.Method, t2: Typed.Method) =>
        return t1.isInObject == t2.isInObject &&
          t1.mode == t2.mode &&
          t1.owner == t2.owner &&
          t1.name == t2.name &&
          t1.tpe == t2.tpe
      case (t1: Typed.Methods, t2: Typed.Methods) =>
        return t1.methods == t2.methods
      case _ =>
        if (this.isUnitType && other.isUnitType) {
          return T
        }
        return F
    }
  }

  @pure def deBruijn: Typed = {
    var map = HashMap.empty[String, Z]

    def dbFun(t: Typed.Fun): Typed.Fun = {
      var args = ISZ[Typed]()
      for (arg <- t.args) {
        val ta = db(arg)
        args = args :+ ta
      }
      val tr = db(t.ret)
      return t(args = args, ret = tr)
    }

    def dbMethod(t: Typed.Method): Typed.Method = {
      var newTypeParams = ISZ[String]()
      for (t <- t.typeParams) {
        val i: Z = map.get(t) match {
          case Some(n) => n
          case _ =>
            val n = map.size
            map = map.put(t, n)
            n
        }
        newTypeParams = newTypeParams :+ s"$$$i"
      }
      t(typeParams = newTypeParams, tpe = dbFun(t.tpe))
    }

    def db(t: Typed): Typed = {
      t match {
        case t: Typed.Name =>
          if (t.args.nonEmpty) {
            var args = ISZ[Typed]()
            for (arg <- t.args) {
              val ta = db(arg)
              args = args :+ ta
            }
            return t(args = args)
          } else {
            return t
          }
        case t: Typed.Tuple =>
          var args = ISZ[Typed]()
          for (arg <- t.args) {
            val ta = db(arg)
            args = args :+ ta
          }
          return t(args = args)
        case t: Typed.Fun => return dbFun(t)
        case t: Typed.TypeVar =>
          val i: Z = map.get(t.id) match {
            case Some(n) => n
            case _ =>
              val n = map.size
              map = map.put(t.id, n)
              n
          }
          return t(id = s"$$$i")
        case t: Typed.Enum => return t
        case t: Typed.Method => return dbMethod(t)
        case t: Typed.Object => return t
        case t: Typed.Package => return t
        case t: Typed.Methods =>
          t(t.methods.map(dbMethod _))
      }
    }

    val r = db(this)
    return r
  }

  @pure def isUnitType: B = {
    this match {
      case t: Typed.Tuple if t.args.isEmpty => return T
      case t: Typed.Name => return t.args.isEmpty && t.ids == Typed.unit.ids
      case _ => return F
    }
  }

  @pure def typeVarSet: HashSSet[String] = {
    return HashSSet.empty[String].addAll(collectTypeVars)
  }

  @pure def collectTypeVars: ISZ[String]
}

@enum object MethodMode {
  'Method
  'Spec
  'Ext
  'Constructor
  'Copy
  'Extractor
  'Select
  'Store
}

object Typed {

  @datatype class Name(ids: ISZ[String], args: ISZ[Typed]) extends Typed {

    @pure override def isPureFun: B = {
      return F
    }

    @pure override def string: String = {
      return if (args.isEmpty) st"${(ids, ".")}".render
      else st"${(ids, ".")}[${(args, ", ")}]".render
    }

    @pure override def subst(m: HashMap[String, Typed]): Typed.Name = {
      if (m.isEmpty) {
        return this
      }
      return Name(ids, args.map(ta => ta.subst(m)))
    }

    @pure override def collectTypeVars: ISZ[String] = {
      return for (arg <- args; tv <- arg.collectTypeVars) yield tv
    }

  }

  @datatype class Tuple(args: ISZ[Typed]) extends Typed {

    @pure override def isPureFun: B = {
      return F
    }

    @pure override def string: String = {
      return st"(${(args, ", ")})".render
    }

    @pure override def subst(m: HashMap[String, Typed]): Typed.Tuple = {
      if (m.isEmpty) {
        return this
      }
      return Tuple(args.map(ta => ta.subst(m)))
    }

    @pure override def collectTypeVars: ISZ[String] = {
      return for (arg <- args; tv <- arg.collectTypeVars) yield tv
    }
  }

  @datatype class Fun(isPure: B, isByName: B, args: ISZ[Typed], ret: Typed) extends Typed {

    @pure override def isPureFun: B = {
      return F
    }

    @pure override def string: String = {
      return if (isByName) st"=> $ret".render
      else if (isPure) st"((${(args, ", ")}) => $ret @pure)".render
      else st"(${(args, ", ")}) => $ret".render
    }

    @pure override def subst(m: HashMap[String, Typed]): Typed.Fun = {
      if (m.isEmpty) {
        return this
      }
      return Fun(isPure, isByName, args.map(ta => ta.subst(m)), ret.subst(m))
    }

    @pure override def collectTypeVars: ISZ[String] = {
      return (for (arg <- args; tv <- arg.collectTypeVars) yield tv) ++ ret.collectTypeVars
    }

  }

  @datatype class TypeVar(id: String) extends Typed {

    @pure override def isPureFun: B = {
      return F
    }

    @pure override def subst(m: HashMap[String, Typed]): Typed = {
      if (m.isEmpty) {
        return this
      }
      m.get(id) match {
        case Some(t2) => return t2
        case _ => return this
      }
    }

    @pure override def string: String = {
      return id
    }

    @pure override def collectTypeVars: ISZ[String] = {
      return ISZ(id)
    }
  }

  @datatype class Package(name: ISZ[String]) extends Typed {

    @pure override def isPureFun: B = {
      return F
    }

    @pure override def string: String = {
      return st"Package ${(name, ".")}".render
    }

    @pure override def subst(m: HashMap[String, Typed]): Typed.Package = {
      return this
    }

    @pure override def collectTypeVars: ISZ[String] = {
      return ISZ()
    }
  }

  @datatype class Object(owner: ISZ[String], id: String) extends Typed {

    @pure def name: ISZ[String] = {
      return owner :+ id
    }

    @pure override def isPureFun: B = {
      return F
    }

    @pure override def string: String = {
      return st"Object ${(name, ".")}".render
    }

    @pure override def subst(m: HashMap[String, Typed]): Typed.Object = {
      return this
    }

    @pure override def collectTypeVars: ISZ[String] = {
      return ISZ()
    }
  }

  @datatype class Enum(name: ISZ[String]) extends Typed {

    @pure override def isPureFun: B = {
      return F
    }

    @pure override def string: String = {
      return st"@enum ${(name, ".")}".render
    }

    @pure override def subst(m: HashMap[String, Typed]): Typed.Enum = {
      return this
    }

    @pure override def collectTypeVars: ISZ[String] = {
      return ISZ()
    }
  }

  object Method {

    object Subst {

      @pure def summarize(substs: ISZ[Subst]): HashSMap[String, Typed] = {
        var r = HashSMap.emptyInit[String, Typed](substs.size)
        for (subst <- substs) {
          r.get(subst.id) match {
            case Some(_) =>
            case _ =>
              r = r.put(subst.id, subst.tipe)
          }
        }
        return r
      }

      @pure def summarizeAsSubst(substs: ISZ[Subst]): ISZ[Subst] = {
        return for (e <- summarize(substs).entries) yield Subst(e._1, e._2)
      }
    }

    @datatype class Subst(id: String, tipe: Typed)

  }

  @datatype class Method(
    isInObject: B,
    mode: MethodMode.Type,
    typeParams: ISZ[String],
    owner: ISZ[String],
    name: String,
    paramNames: ISZ[String],
    substs: ISZ[Method.Subst],
    tpe: Typed.Fun
  ) extends Typed {

    @pure override def isPureFun: B = {
      return F
    }

    @pure override def string: String = {
      return st"$mode ${(owner, ".")}${if (isInObject) "." else "#"}$name".render
    }

    @pure override def subst(m: HashMap[String, Typed]): Typed.Method = {
      if (m.isEmpty) {
        return this
      }
      return Method(
        isInObject,
        mode,
        typeParams,
        owner,
        name,
        paramNames,
        Method.Subst.summarizeAsSubst(substs ++ m.entries.map(p => Method.Subst(p._1, p._2))),
        tpe.subst(m)
      )
    }

    @pure override def collectTypeVars: ISZ[String] = {
      return tpe.collectTypeVars
    }
  }

  @datatype class Methods(methods: ISZ[Method]) extends Typed {

    @pure override def isPureFun: B = {
      return F
    }

    @pure override def string: String = {
      return st"{ ${(methods, ", ")} }".render
    }

    @pure override def subst(m: HashMap[String, Typed]): Typed.Methods = {
      return this(methods.map(mt => mt.subst(m)))
    }

    @pure override def collectTypeVars: ISZ[String] = {
      return for (m <- methods; tv <- m.collectTypeVars) yield tv
    }
  }

  // @formatter:off
  val sireumName: ISZ[String] = ISZ("org", "sireum")
  val nothing: Typed.Name = Typed.Name(ISZ("org", "sireum", "Nothing"), ISZ())
  val nothingOpt: Option[Typed] = Some(nothing)
  val unit: Typed.Name = Typed.Name(ISZ("org", "sireum", "Unit"), ISZ())
  val unitOpt: Option[Typed] = Some(unit)
  val b: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "B"), ISZ())
  val bOpt: Option[Typed] = Some(b)
  val c: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "C"), ISZ())
  val cOpt: Option[Typed] = Some(c)
  val z: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "Z"), ISZ())
  val zOpt: Option[Typed] = Some(z)
  val z8: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "Z8"), ISZ())
  val z16: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "Z16"), ISZ())
  val z32: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "Z32"), ISZ())
  val z64: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "Z64"), ISZ())
  val n: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "N"), ISZ())
  val n8: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "N8"), ISZ())
  val n16: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "N16"), ISZ())
  val n32: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "N32"), ISZ())
  val n64: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "N64"), ISZ())
  val s8: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "S8"), ISZ())
  val s16: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "S16"), ISZ())
  val s32: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "S32"), ISZ())
  val s64: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "S64"), ISZ())
  val u8: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "U8"), ISZ())
  val u16: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "U16"), ISZ())
  val u32: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "U32"), ISZ())
  val u64: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "U64"), ISZ())
  val f32: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "F32"), ISZ())
  val f32Opt: Option[Typed] = Some(f32)
  val f64: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "F64"), ISZ())
  val f64Opt: Option[Typed] = Some(f64)
  val r: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "R"), ISZ())
  val rOpt: Option[Typed] = Some(r)
  val string: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "String"), ISZ())
  val stringOpt: Option[Typed] = Some(string)
  val st: Typed.Name = Typed.Name(ISZ[String]("org", "sireum", "ST"), ISZ())
  val stOpt: Option[Typed] = Some(st)

  val optionName: ISZ[String] = ISZ("org", "sireum", "Option")
  val isName: ISZ[String] = ISZ("org", "sireum", "IS")
  val msName: ISZ[String] = ISZ("org", "sireum", "MS")
  val iszName: ISZ[String] = ISZ("org", "sireum", "ISZ")
  val mszName: ISZ[String] = ISZ("org", "sireum", "MSZ")
  val zsName: ISZ[String] = ISZ("org", "sireum", "ZS")

  val bConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.b)))
  val bConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "B", ISZ(), ISZ(), Typed.bConstructorType))
  val bConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "B", ISZ(), Some(Typed.bConstructorType)))
  val cConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.c)))
  val cConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "C", ISZ(), ISZ(), Typed.cConstructorType))
  val cConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "C", ISZ(), Some(Typed.cConstructorType)))
  val zConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.z)))
  val zConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "Z", ISZ(), ISZ(), Typed.zConstructorType))
  val zConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "Z", ISZ(), Some(Typed.zConstructorType)))
  val z8ConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.z8)))
  val z8ConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "Z8", ISZ(), ISZ(), Typed.z8ConstructorType))
  val z8ConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "Z8", ISZ(), Some(Typed.z8ConstructorType)))
  val z16ConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.z16)))
  val z16ConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "Z16", ISZ(), ISZ(), Typed.z16ConstructorType))
  val z16ConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "Z16", ISZ(), Some(Typed.z16ConstructorType)))
  val z32ConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.z32)))
  val z32ConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "Z32", ISZ(), ISZ(), Typed.z32ConstructorType))
  val z32ConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "Z32", ISZ(), Some(Typed.z32ConstructorType)))
  val z64ConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.z64)))
  val z64ConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "Z64", ISZ(), ISZ(), Typed.z64ConstructorType))
  val z64ConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "Z64", ISZ(), Some(Typed.z64ConstructorType)))
  val nConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.n)))
  val nConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "N", ISZ(), ISZ(), Typed.nConstructorType))
  val nConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "N", ISZ(), Some(Typed.nConstructorType)))
  val n8ConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.n8)))
  val n8ConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "N8", ISZ(), ISZ(), Typed.n8ConstructorType))
  val n8ConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "N8", ISZ(), Some(Typed.n8ConstructorType)))
  val n16ConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.n16)))
  val n16ConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "N16", ISZ(), ISZ(), Typed.n16ConstructorType))
  val n16ConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "N16", ISZ(), Some(Typed.n16ConstructorType)))
  val n32ConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.n32)))
  val n32ConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "N32", ISZ(), ISZ(), Typed.n32ConstructorType))
  val n32ConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "N32", ISZ(), Some(Typed.n32ConstructorType)))
  val n64ConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.n64)))
  val n64ConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "N64", ISZ(), ISZ(), Typed.n64ConstructorType))
  val n64ConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "N64", ISZ(), Some(Typed.n64ConstructorType)))
  val s8ConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.s8)))
  val s8ConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "S8", ISZ(), ISZ(), Typed.s8ConstructorType))
  val s8ConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "S8", ISZ(), Some(Typed.s8ConstructorType)))
  val s16ConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.s16)))
  val s16ConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "S16", ISZ(), ISZ(), Typed.s16ConstructorType))
  val s16ConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "S16", ISZ(), Some(Typed.s16ConstructorType)))
  val s32ConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.s32)))
  val s32ConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "S32", ISZ(), ISZ(), Typed.s32ConstructorType))
  val s32ConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "S32", ISZ(), Some(Typed.s32ConstructorType)))
  val s64ConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.s64)))
  val s64ConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "S64", ISZ(), ISZ(), Typed.s64ConstructorType))
  val s64ConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "S64", ISZ(), Some(Typed.s64ConstructorType)))
  val u8ConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.u8)))
  val u8ConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "U8", ISZ(), ISZ(), Typed.u8ConstructorType))
  val u8ConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "U8", ISZ(), Some(Typed.u8ConstructorType)))
  val u16ConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.u16)))
  val u16ConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "U16", ISZ(), ISZ(), Typed.u16ConstructorType))
  val u16ConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "U16", ISZ(), Some(Typed.u16ConstructorType)))
  val u32ConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.u32)))
  val u32ConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "U32", ISZ(), ISZ(), Typed.u32ConstructorType))
  val u32ConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "U32", ISZ(), Some(Typed.u32ConstructorType)))
  val u64ConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.u64)))
  val u64ConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "U64", ISZ(), ISZ(), Typed.u64ConstructorType))
  val u64ConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "U64", ISZ(), Some(Typed.u64ConstructorType)))
  val f32ConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.f32)))
  val f32ConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "F32", ISZ(), ISZ(), Typed.f32ConstructorType))
  val f32ConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "F32", ISZ(), Some(Typed.f32ConstructorType)))
  val f64ConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.f64)))
  val f64ConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "F64", ISZ(), ISZ(), Typed.f64ConstructorType))
  val f64ConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "F64", ISZ(), Some(Typed.f64ConstructorType)))
  val rConstructorType: Typed.Fun = Typed.Fun(T, F, ISZ(Typed.string), Typed.Name(optionName, ISZ(Typed.r)))
  val rConstructorMethodOpt: Option[Typed] = Some(Typed.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "R", ISZ(), ISZ(), Typed.rConstructorType))
  val rConstructorResOpt: Option[ResolvedInfo] = Some(ResolvedInfo.Method(T, MethodMode.Constructor, ISZ(),
    sireumName, "R", ISZ(), Some(Typed.rConstructorType)))

  val basicConstructorMap: HashMap[ISZ[String], (Option[Typed], Option[ResolvedInfo])] = {
    var m = HashMap.emptyInit[ISZ[String], (Option[Typed], Option[ResolvedInfo])](30)
    m = m.put(b.ids,   (bConstructorMethodOpt  , bConstructorResOpt  ))
    m = m.put(c.ids,   (cConstructorMethodOpt  , cConstructorResOpt  ))
    m = m.put(z.ids,   (zConstructorMethodOpt  , zConstructorResOpt  ))
    m = m.put(z8.ids,  (z8ConstructorMethodOpt , z8ConstructorResOpt ))
    m = m.put(z16.ids, (z16ConstructorMethodOpt, z16ConstructorResOpt))
    m = m.put(z32.ids, (z32ConstructorMethodOpt, z32ConstructorResOpt))
    m = m.put(z64.ids, (z64ConstructorMethodOpt, z64ConstructorResOpt))
    m = m.put(n.ids,   (nConstructorMethodOpt  , nConstructorResOpt  ))
    m = m.put(n8.ids,  (n8ConstructorMethodOpt , n8ConstructorResOpt ))
    m = m.put(n16.ids, (n16ConstructorMethodOpt, n16ConstructorResOpt))
    m = m.put(n32.ids, (n32ConstructorMethodOpt, n32ConstructorResOpt))
    m = m.put(n64.ids, (n64ConstructorMethodOpt, n64ConstructorResOpt))
    m = m.put(s8.ids,  (s8ConstructorMethodOpt , s8ConstructorResOpt ))
    m = m.put(s16.ids, (s16ConstructorMethodOpt, s16ConstructorResOpt))
    m = m.put(s32.ids, (s32ConstructorMethodOpt, s32ConstructorResOpt))
    m = m.put(s64.ids, (s64ConstructorMethodOpt, s64ConstructorResOpt))
    m = m.put(u8.ids,  (u8ConstructorMethodOpt , u8ConstructorResOpt ))
    m = m.put(u16.ids, (u16ConstructorMethodOpt, u16ConstructorResOpt))
    m = m.put(u32.ids, (u32ConstructorMethodOpt, u32ConstructorResOpt))
    m = m.put(u64.ids, (u64ConstructorMethodOpt, u64ConstructorResOpt))
    m = m.put(f32.ids, (f32ConstructorMethodOpt, f32ConstructorResOpt))
    m = m.put(f64.ids, (f64ConstructorMethodOpt, f64ConstructorResOpt))
    m = m.put(r.ids,   (rConstructorMethodOpt  , rConstructorResOpt  ))
    m
  }
  // @formatter:on

}

@datatype class Attr(posOpt: Option[PosInfo])

@datatype class TypedAttr(posOpt: Option[PosInfo], typedOpt: Option[Typed])

@datatype class ResolvedAttr(posOpt: Option[PosInfo], resOpt: Option[ResolvedInfo], typedOpt: Option[Typed])

@datatype trait ResolvedInfo

object ResolvedInfo {

  @datatype class BuiltIn(name: String) extends ResolvedInfo

  @datatype class Package(name: ISZ[String]) extends ResolvedInfo

  @datatype class Enum(name: ISZ[String]) extends ResolvedInfo

  @datatype class EnumElement(owner: ISZ[String], name: String, ordinal: Z) extends ResolvedInfo

  @datatype class Object(name: ISZ[String]) extends ResolvedInfo

  @datatype class Var(isInObject: B, isSpec: B, owner: ISZ[String], id: String) extends ResolvedInfo

  @datatype class Method(
    isInObject: B,
    mode: MethodMode.Type,
    typeParams: ISZ[String],
    owner: ISZ[String],
    name: String,
    paramNames: ISZ[String],
    tpeOpt: Option[Typed.Fun]
  ) extends ResolvedInfo

  @datatype class Methods(methods: ISZ[Method]) extends ResolvedInfo

  @datatype class Type(name: ISZ[String]) extends ResolvedInfo

  @datatype class Tuple(size: Z, index: Z) extends ResolvedInfo

  @datatype class LocalVar(context: ISZ[String], id: String) extends ResolvedInfo

}

@datatype class PosInfo(
  fileUriOpt: Option[String],
  beginLine: Z,
  beginColumn: Z,
  endLine: Z,
  endColumn: Z,
  offset: Z,
  length: Z
) {
  {
    assert(beginLine >= 1, "beginLine")
    assert(beginColumn >= 1, "beginColumn")
    assert(endLine >= 1, "endLine")
    assert(endColumn >= 1, "endColumn")
    assert(offset >= 0, "offset")
    assert(length >= 0, "length")
  }

  l"""invariant beginLine ≥ 1
                beginColumn ≥ 1
                endLine ≥ 1
                endColumn ≥ 1
                offset ≥ 0
                length ≥ 0
   """

}
