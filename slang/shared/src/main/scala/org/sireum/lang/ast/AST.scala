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
  def fileUriOpt: Option[String]
}

object TopUnit {

  @datatype class Program(fileUriOpt: Option[String],
                          packageName: Name,
                          body: Body)
    extends TopUnit

  @datatype class SequentUnit(fileUriOpt: Option[String],
                              sequent: LClause.Sequent)
    extends TopUnit


  @datatype class TruthTableUnit(fileUriOpt: Option[String],
                                 stars: ISZ[Z],
                                 vars: ISZ[Id],
                                 sepColumn: Z,
                                 isSequent: B,
                                 sequent: LClause.Sequent,
                                 rows: ISZ[TruthTable.Row],
                                 conclusionOpt: Option[TruthTable.Conclusion])
    extends TopUnit

}

@datatype trait Stmt {
  def attr: Attr
}

@sig sealed trait AssignExp

object Stmt {

  @datatype class Import(importers: ISZ[Import.Importer],
                         @hidden attr: Attr)
    extends Stmt

  object Import {

    @datatype class Importer(name: Name, selectorsOpt: Option[ISZ[Selector]])

    @datatype class Selector(from: Id, to: Id)

  }

  @datatype class Var(isVal: B,
                      id: Id,
                      tpeOpt: Option[Type],
                      initOpt: Option[AssignExp],
                      @hidden attr: Attr)
    extends Stmt

  @datatype class VarPattern(isVal: B,
                             pattern: Pattern,
                             tpeOpt: Option[Type],
                             initOpt: Option[AssignExp],
                             @hidden attr: Attr)
    extends Stmt

  @datatype class SpecVar(isVal: B,
                          id: Id,
                          tpe: Type,
                          @hidden attr: Attr)
    extends Stmt

  @datatype class Method(isPure: B,
                         sig: MethodSig,
                         contract: Contract,
                         bodyOpt: Option[Body],
                         @hidden attr: Attr)
    extends Stmt

  @datatype class ExtMethod(isPure: B,
                            sig: MethodSig,
                            contract: Contract,
                            @hidden attr: Attr)
    extends Stmt

  @datatype class SpecMethod(sig: MethodSig,
                             defs: ISZ[SpecDef],
                             where: ISZ[WhereDef],
                             @hidden attr: Attr)
    extends Stmt

  @datatype class Enum(id: Id,
                       elements: ISZ[Id],
                       @hidden attr: Attr)
    extends Stmt

  @datatype class Object(isExt: B,
                         id: Id,
                         parents: ISZ[Type],
                         stmts: ISZ[Stmt],
                         @hidden attr: Attr)
    extends Stmt

  @datatype class Sig(id: Id,
                      typeParams: ISZ[TypeParam],
                      parents: ISZ[Type],
                      selfTypeOpt: Option[Type],
                      stmt: ISZ[Stmt],
                      @hidden attr: Attr)
    extends Stmt

  @datatype class AbstractDatatype(isRoot: B,
                                   isDatatype: B,
                                   id: Id,
                                   typeParams: ISZ[TypeParam],
                                   params: ISZ[AbstractDatatypeParam],
                                   parents: ISZ[Type],
                                   stmt: ISZ[Stmt],
                                   @hidden attr: Attr)
    extends Stmt

  @datatype class Rich(isRoot: B,
                       id: Id,
                       typeParams: ISZ[TypeParam],
                       params: ISZ[Param],
                       parents: ISZ[Type],
                       stmt: ISZ[Stmt],
                       @hidden attr: Attr)
    extends Stmt

  @datatype class TypeAlias(id: Id,
                            typeParams: ISZ[TypeParam],
                            tpe: Type,
                            @hidden attr: Attr)
    extends Stmt

  @datatype class Assign(lhs: Exp,
                         rhs: AssignExp,
                         @hidden attr: Attr)
    extends Stmt

  @datatype class AssignUp(lhs: Exp,
                           rhs: AssignExp,
                           @hidden attr: Attr)
    extends Stmt

  @datatype class AssignPattern(lhs: Pattern,
                                rhs: AssignExp,
                                @hidden attr: Attr)
    extends Stmt

  @datatype class Block(body: Body,
                        @hidden attr: Attr)
    extends Stmt with AssignExp

  @datatype class If(cond: Exp,
                     thenbody: Body,
                     elsebody: Body,
                     @hidden attr: Attr)
    extends Stmt with AssignExp

  @datatype class Match(cond: Exp,
                        cases: ISZ[Case],
                        @hidden attr: Attr)
    extends Stmt with AssignExp

  @datatype class While(cond: Exp,
                        invariants: ISZ[ContractExp],
                        modifies: ISZ[Exp],
                        body: Body,
                        @hidden attr: Attr)
    extends Stmt

  @datatype class DoWhile(cond: Exp,
                          invariants: ISZ[ContractExp],
                          modifies: ISZ[Exp],
                          body: Body,
                          @hidden attr: Attr)
    extends Stmt

  @datatype class For(id: Id,
                      range: Range,
                      condOpt: Option[Exp],
                      invariants: ISZ[ContractExp],
                      modifies: ISZ[Exp],
                      body: Body,
                      @hidden attr: Attr)
    extends Stmt

  @datatype class Return(expOpt: Option[Exp],
                         @hidden attr: Attr)
    extends Stmt

  @datatype class LStmt(clause: LClause,
                        @hidden attr: Attr)
    extends Stmt

  @datatype class Expr(exp: Exp,
                       @hidden attr: Attr)
    extends Stmt with AssignExp

}

@datatype trait LClause

object LClause {

  @datatype class Invariants(value: ISZ[ContractExp])
    extends LClause

  @datatype class Facts(value: ISZ[Fact])
    extends LClause

  @datatype class Fact(id: Id,
                       exp: Exp)

  @datatype class Theorems(value: ISZ[Theorem])
    extends LClause

  @datatype class Theorem(id: Id,
                          sequent: Sequent)

  @datatype class Sequent(premises: ISZ[Exp],
                          conclusions: ISZ[Exp],
                          proofOpt: Option[Proof])
    extends LClause

  @datatype class Proof(steps: ISZ[ProofStep])
    extends LClause

}

@datatype class ContractExp(idOpt: Option[Id],
                            exp: Exp)

@datatype class Case(pattern: Pattern,
                     condOpt: Option[Exp],
                     body: Body)

@datatype trait Range

object Range {

  @datatype class Expr(exp: Exp) extends Range

  @datatype class Indices(isReverse: B,
                          exp: Exp)
    extends Range

  @datatype class Step(isInclusive: B,
                       start: Exp,
                       end: Exp,
                       byOpt: Option[Exp]) extends Range

}

@datatype trait Type

object Type {

  @datatype class Named(name: Name,
                        typeArgs: ISZ[Type],
                        attr: TypedAttr)
    extends Type

  @datatype class Fun(args: ISZ[Type],
                      ret: Type,
                      attr: TypedAttr)
    extends Type

  @datatype class Tuple(args: ISZ[Type],
                        attr: TypedAttr)
    extends Type

}

@datatype trait Pattern

object Pattern {

  @datatype class Literal(lit: Lit)
    extends Pattern

  @datatype class Variable(id: Id,
                           typeOpt: Option[Type])
    extends Pattern

  @datatype class Wildcard(typeOpt: Option[Type])
    extends Pattern

  @datatype class SeqWildcard
    extends Pattern

  @datatype class Structure(idOpt: Option[Id],
                            nameOpt: Option[Name],
                            patterns: ISZ[Pattern])
    extends Pattern

}

@datatype trait Exp

@sig sealed trait Lit

object Exp {

  @datatype class LitB(value: B,
                       @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitC(value: C,
                       @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitZ(value: Z,
                       @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitZ8(value: Z8,
                        @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitZ16(value: Z16,
                         @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitZ32(value: Z32,
                         @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitZ64(value: Z64,
                         @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitN(value: N,
                       @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitN8(value: N8,
                        @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitN16(value: N16,
                         @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitN32(value: N32,
                         @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitN64(value: N64,
                         @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitS8(value: S8,
                        @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitS16(value: S16,
                         @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitS32(value: S32,
                         @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitS64(value: S64,
                         @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitU8(value: U8,
                        @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitU16(value: U16,
                         @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitU32(value: U32,
                         @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitU64(value: U64,
                         @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitF32(value: F32,
                         @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitF64(value: F64,
                         @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitR(value: R,
                       @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitBv(value: ISZ[B],
                        tpe: Type,
                        @hidden attr: Attr)
    extends Exp with Lit

  @datatype class LitString(value: String,
                            @hidden attr: Attr)
    extends Exp with Lit

  @datatype class StringInterpolate(lits: ISZ[LitString],
                                    args: ISZ[Exp],
                                    @hidden attr: Attr)
    extends Exp

  @enum object UnaryOp {
    'Not
    'Plus
    'Minus
    'Complement
  }

  @datatype class Unary(op: UnaryOp.Type,
                        exp: Exp,
                        @hidden attr: TypedAttr)
    extends Exp

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
    'Append
    'Prepend
    'AppendAll
    'RemoveAll
  }

  @datatype class Binary(left: Exp,
                         op: BinaryOp.Type,
                         right: Exp,
                         @hidden attr: TypedAttr)
    extends Exp

  @datatype class Ident(id: Id,
                        @hidden attr: ResolvedAttr)
    extends Exp

  @datatype class Eta(exp: Exp,
                      @hidden attr: ResolvedAttr)
    extends Exp

  @datatype class Tuple(args: ISZ[Exp],
                        @hidden attr: TypedAttr)
    extends Exp

  @datatype class Select(receiverOpt: Option[Exp],
                         id: Id,
                         targs: ISZ[Type],
                         @hidden attr: ResolvedAttr)
    extends Exp

  @datatype class Invoke(receiverOpt: Option[Exp],
                         id: Id,
                         targs: ISZ[Type],
                         args: ISZ[Exp],
                         @hidden attr: ResolvedAttr)
    extends Exp

  @datatype class InvokeNamed(receiverOpt: Option[Exp],
                              id: Id,
                              targs: ISZ[Type],
                              args: ISZ[NamedArg],
                              @hidden attr: ResolvedAttr)
    extends Exp

  @datatype class If(cond: Exp,
                     thenExp: Exp,
                     elseExp: Exp,
                     @hidden attr: TypedAttr)
    extends Exp

  @datatype class Quant(isForall: B,
                        varFragments: ISZ[VarFragment],
                        exp: Exp)
    extends Exp

}

@datatype class NamedArg(id: Id,
                         arg: Exp)

@datatype class VarFragment(ids: ISZ[Id],
                            domainOpt: Option[Domain])

@datatype trait Domain {
  def attr: TypedAttr
}

object Domain {

  @datatype class Type(tipe: org.sireum.lang.ast.Type,
                       @hidden attr: TypedAttr)
    extends Domain

  @datatype class Range(lo: Exp,
                        loExact: B,
                        hi: Exp,
                        hiExact: B,
                        @hidden attr: TypedAttr)
    extends Domain

}

@datatype class Id(value: String,
                   @hidden attr: Attr)

@datatype class Name(ids: ISZ[Id],
                     @hidden attr: Attr)

@datatype class Body(stmts: ISZ[Stmt])

@datatype class AbstractDatatypeParam(isHidden: B,
                                      isPure: B,
                                      id: Id,
                                      tpe: Type)

@datatype class MethodSig(id: Id,
                          typeParams: ISZ[TypeParam],
                          paramsOpt: Option[ISZ[Param]],
                          returnType: Type)

@datatype class Param(isPure: B,
                      id: Id,
                      tpe: Type)

@datatype class TypeParam(id: Id,
                          superTypeOpt: Option[Type])

@datatype class Contract(reads: ISZ[Exp],
                         requires: ISZ[ContractExp],
                         modifies: ISZ[Exp],
                         ensures: ISZ[ContractExp],
                         subs: ISZ[SubContract])

@datatype class SubContract(id: Id,
                            params: ISZ[SubContractParam],
                            contract: Contract)

@datatype class SubContractParam(isPure: B,
                                 id: Id)

@datatype trait WhereDef

object WhereDef {

  @datatype class Val(id: Id,
                      tipe: Type,
                      exp: Exp) extends WhereDef

  @datatype class Def(id: Id,
                      params: ISZ[Param],
                      rTipe: Type,
                      defs: ISZ[SpecDef]) extends WhereDef

}

@datatype class SpecDef(idOpt: Option[Id],
                        exp: Exp,
                        isOtherwise: B,
                        patternOpt: Option[Pattern],
                        guardOpt: Option[Exp])

@datatype trait ProofStep {
  def step: Exp.LitZ
}

object ProofStep {

  @datatype class Basic(step: Exp.LitZ,
                        exp: Exp,
                        just: Just)
    extends ProofStep

  @datatype class SubProof(step: Exp.LitZ,
                           assumeStep: AssumeProofStep,
                           steps: ISZ[ProofStep])
    extends ProofStep

}

@datatype trait AssumeProofStep {
  def step: Exp.LitZ
}

object AssumeProofStep {

  @datatype class Regular(step: Exp.LitZ,
                          exp: Exp)
    extends AssumeProofStep

  @datatype class ForallIntroAps(step: Exp.LitZ,
                                 varFragments: ISZ[VarFragment])
    extends AssumeProofStep

  @datatype class ExistsElimAps(step: Exp.LitZ,
                                varFragments: ISZ[VarFragment],
                                exp: Exp)
    extends AssumeProofStep

}

@datatype trait Just {
  def attr: Attr
}

object Just {

  @datatype class Premise(@hidden attr: Attr) extends Just

  @datatype class AndIntro(steps: ISZ[Exp.LitZ],
                           @hidden attr: Attr)
    extends Just

  @datatype class AndElim(is1: B,
                          andStep: Exp.LitZ,
                          @hidden attr: Attr)
    extends Just

  @datatype class OrIntro(is1: B,
                          step: Exp.LitZ,
                          @hidden attr: Attr)
    extends Just

  @datatype class OrElim(orStep: Exp.LitZ,
                         subProofSteps: ISZ[Exp.LitZ],
                         @hidden attr: Attr)
    extends Just

  @datatype class ImplyIntro(subProofStep:
                             Exp.LitZ,
                             @hidden attr: Attr)
    extends Just

  @datatype class ImplyElim(implyStep: Exp.LitZ,
                            steps: ISZ[Exp.LitZ],
                            @hidden attr: Attr)
    extends Just

  @datatype class NegIntro(subProofStep: Exp.LitZ,
                           @hidden attr: Attr)
    extends Just

  @datatype class NegElim(step: Exp.LitZ,
                          negStep: Exp.LitZ,
                          @hidden attr: Attr)
    extends Just

  @datatype class BottomElim(subProofStep: Exp.LitZ,
                             @hidden attr: Attr)
    extends Just

  @datatype class Pbc(subProofStep: Exp.LitZ,
                      @hidden attr: Attr)
    extends Just

  @datatype class ForallIntro(subProofStep: Exp.LitZ,
                              @hidden attr: Attr)
    extends Just

  @datatype class ForallElim(forallStep: Exp.LitZ,
                             args: ISZ[Exp],
                             @hidden attr: Attr)
    extends Just

  @datatype class ExistsIntro(existsStep: Exp.LitZ,
                              args: ISZ[Exp],
                              @hidden attr: Attr)
    extends Just

  @datatype class ExistsElim(existsStep: Exp.LitZ,
                             subProofStep: Exp.LitZ,
                             @hidden attr: Attr)
    extends Just

  @datatype class Fact(name: Name,
                       @hidden attr: Attr)
    extends Just

  @datatype class Invariant(nameOpt: Option[Name],
                            @hidden attr: Attr)
    extends Just

  @datatype class Subst(isRight: B,
                        eqStep: Exp.LitZ,
                        step: Exp.LitZ,
                        @hidden attr: Attr)
    extends Just

  @datatype class Auto(isAlgebra: B,
                       steps: ISZ[Exp.LitZ],
                       @hidden attr: Attr)
    extends Just

  @datatype class Coq(path: Exp.LitString,
                      steps: ISZ[Exp.LitZ],
                      @hidden attr: Attr)
    extends Just

}

object TruthTable {

  @datatype class Row(assignment: ISZ[Exp.LitB],
                      column: Z,
                      values: ISZ[Exp.LitB])

  @datatype trait Conclusion {
    def attr: Attr
  }

  object Conclusion {

    @datatype class Validity(isValid: B,
                             assignments: ISZ[ISZ[Exp.LitB]],
                             @hidden attr: Attr)
      extends Conclusion

    @datatype class Tautology(@hidden attr: Attr) extends Conclusion

    @datatype class Contradictory(@hidden attr: Attr) extends Conclusion

    @datatype class Contingent(trueAssignments: ISZ[ISZ[Exp.LitB]],
                               falseAssignments: ISZ[ISZ[Exp.LitB]],
                               @hidden attr: Attr)
      extends Conclusion

  }

}

@datatype class Attr(posInfoOpt: Option[PosInfo])

@datatype class TypedAttr(posInfoOpt: Option[PosInfo],
                          typeOpt: Option[Type])

@datatype class ResolvedAttr(posInfoOpt: Option[PosInfo],
                             resOpt: Option[ResolvedInfo],
                             typeOpt: Option[Type])

@datatype class ResolvedInfo(kind: SymbolKind.Type,
                             ids: ISZ[String],
                             externFileUriOpt: Option[String])

@enum object SymbolKind {
  'Package
  'Val
  'Var
  'Method
  'ExtMethod
  'SpecMethod
  'Object
  'Sig
  'DatatypeTrait
  'DatatypeClass
  'RecordTrait
  'RecordClass
  'RichTrait
  'RichClass
  'Enum
  'TypeAlias
}

@datatype class PosInfo(fileUriOpt: Option[String],
                        beginLine: Z,
                        beginColumn: Z,
                        endLine: Z,
                        endColumn: Z,
                        offset: Z,
                        length: Z)