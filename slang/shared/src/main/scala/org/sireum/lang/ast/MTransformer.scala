// #Sireum
// @formatter:off

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

// This file is auto-generated from AST.scala

package org.sireum.lang.ast

import org.sireum._

object MTransformer {

  @record class PreResult[T](continue: B,
                             resultOpt: MOption[T])

  @sig trait PrePost {

    def preTopUnit(o: TopUnit): PreResult[TopUnit] = {
      o match {
        case o: TopUnit.Program => return preTopUnitProgram(o)
        case o: TopUnit.SequentUnit => return preTopUnitSequentUnit(o)
        case o: TopUnit.TruthTableUnit => return preTopUnitTruthTableUnit(o)
      }
    }

    def preTopUnitProgram(o: TopUnit.Program): PreResult[TopUnit] = {
      return PreResult(T, MNone())
    }

    def preTopUnitSequentUnit(o: TopUnit.SequentUnit): PreResult[TopUnit] = {
      return PreResult(T, MNone())
    }

    def preTopUnitTruthTableUnit(o: TopUnit.TruthTableUnit): PreResult[TopUnit] = {
      return PreResult(T, MNone())
    }

    def preStmt(o: Stmt): PreResult[Stmt] = {
      o match {
        case o: Stmt.Import => return preStmtImport(o)
        case o: Stmt.Var => return preStmtVar(o)
        case o: Stmt.VarPattern => return preStmtVarPattern(o)
        case o: Stmt.SpecVar => return preStmtSpecVar(o)
        case o: Stmt.Method => return preStmtMethod(o)
        case o: Stmt.ExtMethod => return preStmtExtMethod(o)
        case o: Stmt.SpecMethod => return preStmtSpecMethod(o)
        case o: Stmt.Enum => return preStmtEnum(o)
        case o: Stmt.Object => return preStmtObject(o)
        case o: Stmt.Sig => return preStmtSig(o)
        case o: Stmt.AbstractDatatype => return preStmtAbstractDatatype(o)
        case o: Stmt.Rich => return preStmtRich(o)
        case o: Stmt.TypeAlias => return preStmtTypeAlias(o)
        case o: Stmt.Assign => return preStmtAssign(o)
        case o: Stmt.AssignUp => return preStmtAssignUp(o)
        case o: Stmt.AssignPattern => return preStmtAssignPattern(o)
        case o: Stmt.Block => return preStmtBlock(o)
        case o: Stmt.If => return preStmtIf(o)
        case o: Stmt.Match => return preStmtMatch(o)
        case o: Stmt.While => return preStmtWhile(o)
        case o: Stmt.DoWhile => return preStmtDoWhile(o)
        case o: Stmt.For => return preStmtFor(o)
        case o: Stmt.Return => return preStmtReturn(o)
        case o: Stmt.LStmt => return preStmtLStmt(o)
        case o: Stmt.Expr => return preStmtExpr(o)
      }
    }

    def preStmtImport(o: Stmt.Import): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtImportImporter(o: Stmt.Import.Importer): PreResult[Stmt.Import.Importer] = {
      return PreResult(T, MNone())
    }

    def preStmtImportSelector(o: Stmt.Import.Selector): PreResult[Stmt.Import.Selector] = {
      o match {
        case o: Stmt.Import.MultiSelector => return preStmtImportMultiSelector(o)
        case o: Stmt.Import.WildcardSelector => return preStmtImportWildcardSelector(o)
      }
    }

    def preStmtImportMultiSelector(o: Stmt.Import.MultiSelector): PreResult[Stmt.Import.Selector] = {
      return PreResult(T, MNone())
    }

    def preStmtImportWildcardSelector(o: Stmt.Import.WildcardSelector): PreResult[Stmt.Import.Selector] = {
      return PreResult(T, MNone())
    }

    def preStmtImportNamedSelector(o: Stmt.Import.NamedSelector): PreResult[Stmt.Import.NamedSelector] = {
      return PreResult(T, MNone())
    }

    def preStmtVar(o: Stmt.Var): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtVarPattern(o: Stmt.VarPattern): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtSpecVar(o: Stmt.SpecVar): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtMethod(o: Stmt.Method): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtExtMethod(o: Stmt.ExtMethod): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtSpecMethod(o: Stmt.SpecMethod): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtEnum(o: Stmt.Enum): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtObject(o: Stmt.Object): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtSig(o: Stmt.Sig): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtAbstractDatatype(o: Stmt.AbstractDatatype): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtRich(o: Stmt.Rich): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtTypeAlias(o: Stmt.TypeAlias): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtAssign(o: Stmt.Assign): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtAssignUp(o: Stmt.AssignUp): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtAssignPattern(o: Stmt.AssignPattern): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtBlock(o: Stmt.Block): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtIf(o: Stmt.If): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtMatch(o: Stmt.Match): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtWhile(o: Stmt.While): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtDoWhile(o: Stmt.DoWhile): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtFor(o: Stmt.For): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtReturn(o: Stmt.Return): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtLStmt(o: Stmt.LStmt): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preStmtExpr(o: Stmt.Expr): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def preLClause(o: LClause): PreResult[LClause] = {
      o match {
        case o: LClause.Invariants => return preLClauseInvariants(o)
        case o: LClause.Facts => return preLClauseFacts(o)
        case o: LClause.Theorems => return preLClauseTheorems(o)
        case o: LClause.Sequent => return preLClauseSequent(o)
        case o: LClause.Proof => return preLClauseProof(o)
      }
    }

    def preLClauseInvariants(o: LClause.Invariants): PreResult[LClause] = {
      return PreResult(T, MNone())
    }

    def preLClauseFacts(o: LClause.Facts): PreResult[LClause] = {
      return PreResult(T, MNone())
    }

    def preLClauseFact(o: LClause.Fact): PreResult[LClause.Fact] = {
      return PreResult(T, MNone())
    }

    def preLClauseTheorems(o: LClause.Theorems): PreResult[LClause] = {
      return PreResult(T, MNone())
    }

    def preLClauseTheorem(o: LClause.Theorem): PreResult[LClause.Theorem] = {
      return PreResult(T, MNone())
    }

    def preLClauseSequent(o: LClause.Sequent): PreResult[LClause] = {
      return PreResult(T, MNone())
    }

    def preLClauseProof(o: LClause.Proof): PreResult[LClause] = {
      return PreResult(T, MNone())
    }

    def preContractExp(o: ContractExp): PreResult[ContractExp] = {
      return PreResult(T, MNone())
    }

    def preCase(o: Case): PreResult[Case] = {
      return PreResult(T, MNone())
    }

    def preEnumGenRange(o: EnumGen.Range): PreResult[EnumGen.Range] = {
      o match {
        case o: EnumGen.Range.Expr => return preEnumGenRangeExpr(o)
        case o: EnumGen.Range.Indices => return preEnumGenRangeIndices(o)
        case o: EnumGen.Range.Step => return preEnumGenRangeStep(o)
      }
    }

    def preEnumGenRangeExpr(o: EnumGen.Range.Expr): PreResult[EnumGen.Range] = {
      return PreResult(T, MNone())
    }

    def preEnumGenRangeIndices(o: EnumGen.Range.Indices): PreResult[EnumGen.Range] = {
      return PreResult(T, MNone())
    }

    def preEnumGenRangeStep(o: EnumGen.Range.Step): PreResult[EnumGen.Range] = {
      return PreResult(T, MNone())
    }

    def preEnumGenFor(o: EnumGen.For): PreResult[EnumGen.For] = {
      return PreResult(T, MNone())
    }

    def preType(o: Type): PreResult[Type] = {
      o match {
        case o: Type.Named => return preTypeNamed(o)
        case o: Type.Fun => return preTypeFun(o)
        case o: Type.Tuple => return preTypeTuple(o)
      }
    }

    def preTypeNamed(o: Type.Named): PreResult[Type] = {
      return PreResult(T, MNone())
    }

    def preTypeFun(o: Type.Fun): PreResult[Type] = {
      return PreResult(T, MNone())
    }

    def preTypeTuple(o: Type.Tuple): PreResult[Type] = {
      return PreResult(T, MNone())
    }

    def prePattern(o: Pattern): PreResult[Pattern] = {
      o match {
        case o: Pattern.Literal => return prePatternLiteral(o)
        case o: Pattern.Ref => return prePatternRef(o)
        case o: Pattern.Variable => return prePatternVariable(o)
        case o: Pattern.Wildcard => return prePatternWildcard(o)
        case o: Pattern.SeqWildcard => return prePatternSeqWildcard(o)
        case o: Pattern.Structure => return prePatternStructure(o)
      }
    }

    def prePatternLiteral(o: Pattern.Literal): PreResult[Pattern] = {
      return PreResult(T, MNone())
    }

    def prePatternRef(o: Pattern.Ref): PreResult[Pattern] = {
      return PreResult(T, MNone())
    }

    def prePatternVariable(o: Pattern.Variable): PreResult[Pattern] = {
      return PreResult(T, MNone())
    }

    def prePatternWildcard(o: Pattern.Wildcard): PreResult[Pattern] = {
      return PreResult(T, MNone())
    }

    def prePatternSeqWildcard(o: Pattern.SeqWildcard): PreResult[Pattern] = {
      return PreResult(T, MNone())
    }

    def prePatternStructure(o: Pattern.Structure): PreResult[Pattern] = {
      return PreResult(T, MNone())
    }

    def preExp(o: Exp): PreResult[Exp] = {
      o match {
        case o: Exp.LitB => return preExpLitB(o)
        case o: Exp.LitC => return preExpLitC(o)
        case o: Exp.LitZ => return preExpLitZ(o)
        case o: Exp.LitZ8 => return preExpLitZ8(o)
        case o: Exp.LitZ16 => return preExpLitZ16(o)
        case o: Exp.LitZ32 => return preExpLitZ32(o)
        case o: Exp.LitZ64 => return preExpLitZ64(o)
        case o: Exp.LitN => return preExpLitN(o)
        case o: Exp.LitN8 => return preExpLitN8(o)
        case o: Exp.LitN16 => return preExpLitN16(o)
        case o: Exp.LitN32 => return preExpLitN32(o)
        case o: Exp.LitN64 => return preExpLitN64(o)
        case o: Exp.LitS8 => return preExpLitS8(o)
        case o: Exp.LitS16 => return preExpLitS16(o)
        case o: Exp.LitS32 => return preExpLitS32(o)
        case o: Exp.LitS64 => return preExpLitS64(o)
        case o: Exp.LitU8 => return preExpLitU8(o)
        case o: Exp.LitU16 => return preExpLitU16(o)
        case o: Exp.LitU32 => return preExpLitU32(o)
        case o: Exp.LitU64 => return preExpLitU64(o)
        case o: Exp.LitF32 => return preExpLitF32(o)
        case o: Exp.LitF64 => return preExpLitF64(o)
        case o: Exp.LitR => return preExpLitR(o)
        case o: Exp.LitBv => return preExpLitBv(o)
        case o: Exp.LitString => return preExpLitString(o)
        case o: Exp.StringInterpolate => return preExpStringInterpolate(o)
        case o: Exp.This => return preExpThis(o)
        case o: Exp.Super => return preExpSuper(o)
        case o: Exp.Unary => return preExpUnary(o)
        case o: Exp.Binary => return preExpBinary(o)
        case o: Exp.Ident => return preExpIdent(o)
        case o: Exp.Eta => return preExpEta(o)
        case o: Exp.Tuple => return preExpTuple(o)
        case o: Exp.Select => return preExpSelect(o)
        case o: Exp.Invoke => return preExpInvoke(o)
        case o: Exp.InvokeNamed => return preExpInvokeNamed(o)
        case o: Exp.If => return preExpIf(o)
        case o: Exp.Fun => return preExpFun(o)
        case o: Exp.ForYield => return preExpForYield(o)
        case o: Exp.Quant => return preExpQuant(o)
      }
    }

    def preExpLitB(o: Exp.LitB): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitC(o: Exp.LitC): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitZ(o: Exp.LitZ): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitZ8(o: Exp.LitZ8): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitZ16(o: Exp.LitZ16): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitZ32(o: Exp.LitZ32): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitZ64(o: Exp.LitZ64): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitN(o: Exp.LitN): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitN8(o: Exp.LitN8): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitN16(o: Exp.LitN16): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitN32(o: Exp.LitN32): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitN64(o: Exp.LitN64): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitS8(o: Exp.LitS8): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitS16(o: Exp.LitS16): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitS32(o: Exp.LitS32): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitS64(o: Exp.LitS64): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitU8(o: Exp.LitU8): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitU16(o: Exp.LitU16): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitU32(o: Exp.LitU32): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitU64(o: Exp.LitU64): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitF32(o: Exp.LitF32): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitF64(o: Exp.LitF64): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitR(o: Exp.LitR): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitBv(o: Exp.LitBv): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpLitString(o: Exp.LitString): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpStringInterpolate(o: Exp.StringInterpolate): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpThis(o: Exp.This): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpSuper(o: Exp.Super): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpUnary(o: Exp.Unary): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpBinary(o: Exp.Binary): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpIdent(o: Exp.Ident): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpEta(o: Exp.Eta): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpTuple(o: Exp.Tuple): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpSelect(o: Exp.Select): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpInvoke(o: Exp.Invoke): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpInvokeNamed(o: Exp.InvokeNamed): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpIf(o: Exp.If): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpFun(o: Exp.Fun): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpForYield(o: Exp.ForYield): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preExpQuant(o: Exp.Quant): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def preNamedArg(o: NamedArg): PreResult[NamedArg] = {
      return PreResult(T, MNone())
    }

    def preVarFragment(o: VarFragment): PreResult[VarFragment] = {
      return PreResult(T, MNone())
    }

    def preDomain(o: Domain): PreResult[Domain] = {
      o match {
        case o: Domain.Type => return preDomainType(o)
        case o: Domain.Range => return preDomainRange(o)
      }
    }

    def preDomainType(o: Domain.Type): PreResult[Domain] = {
      return PreResult(T, MNone())
    }

    def preDomainRange(o: Domain.Range): PreResult[Domain] = {
      return PreResult(T, MNone())
    }

    def preId(o: Id): PreResult[Id] = {
      return PreResult(T, MNone())
    }

    def preName(o: Name): PreResult[Name] = {
      return PreResult(T, MNone())
    }

    def preBody(o: Body): PreResult[Body] = {
      return PreResult(T, MNone())
    }

    def preAbstractDatatypeParam(o: AbstractDatatypeParam): PreResult[AbstractDatatypeParam] = {
      return PreResult(T, MNone())
    }

    def preMethodSig(o: MethodSig): PreResult[MethodSig] = {
      return PreResult(T, MNone())
    }

    def preParam(o: Param): PreResult[Param] = {
      return PreResult(T, MNone())
    }

    def preTypeParam(o: TypeParam): PreResult[TypeParam] = {
      return PreResult(T, MNone())
    }

    def preContract(o: Contract): PreResult[Contract] = {
      return PreResult(T, MNone())
    }

    def preSubContract(o: SubContract): PreResult[SubContract] = {
      return PreResult(T, MNone())
    }

    def preSubContractParam(o: SubContractParam): PreResult[SubContractParam] = {
      return PreResult(T, MNone())
    }

    def preWhereDef(o: WhereDef): PreResult[WhereDef] = {
      o match {
        case o: WhereDef.Val => return preWhereDefVal(o)
        case o: WhereDef.Def => return preWhereDefDef(o)
      }
    }

    def preWhereDefVal(o: WhereDef.Val): PreResult[WhereDef] = {
      return PreResult(T, MNone())
    }

    def preWhereDefDef(o: WhereDef.Def): PreResult[WhereDef] = {
      return PreResult(T, MNone())
    }

    def preSpecDef(o: SpecDef): PreResult[SpecDef] = {
      return PreResult(T, MNone())
    }

    def preProofStep(o: ProofStep): PreResult[ProofStep] = {
      o match {
        case o: ProofStep.Basic => return preProofStepBasic(o)
        case o: ProofStep.SubProof => return preProofStepSubProof(o)
      }
    }

    def preProofStepBasic(o: ProofStep.Basic): PreResult[ProofStep] = {
      return PreResult(T, MNone())
    }

    def preProofStepSubProof(o: ProofStep.SubProof): PreResult[ProofStep] = {
      return PreResult(T, MNone())
    }

    def preAssumeProofStep(o: AssumeProofStep): PreResult[AssumeProofStep] = {
      o match {
        case o: AssumeProofStep.Regular => return preAssumeProofStepRegular(o)
        case o: AssumeProofStep.ForallIntroAps => return preAssumeProofStepForallIntroAps(o)
        case o: AssumeProofStep.ExistsElimAps => return preAssumeProofStepExistsElimAps(o)
      }
    }

    def preAssumeProofStepRegular(o: AssumeProofStep.Regular): PreResult[AssumeProofStep] = {
      return PreResult(T, MNone())
    }

    def preAssumeProofStepForallIntroAps(o: AssumeProofStep.ForallIntroAps): PreResult[AssumeProofStep] = {
      return PreResult(T, MNone())
    }

    def preAssumeProofStepExistsElimAps(o: AssumeProofStep.ExistsElimAps): PreResult[AssumeProofStep] = {
      return PreResult(T, MNone())
    }

    def preJust(o: Just): PreResult[Just] = {
      o match {
        case o: Just.Premise => return preJustPremise(o)
        case o: Just.AndIntro => return preJustAndIntro(o)
        case o: Just.AndElim => return preJustAndElim(o)
        case o: Just.OrIntro => return preJustOrIntro(o)
        case o: Just.OrElim => return preJustOrElim(o)
        case o: Just.ImplyIntro => return preJustImplyIntro(o)
        case o: Just.ImplyElim => return preJustImplyElim(o)
        case o: Just.NegIntro => return preJustNegIntro(o)
        case o: Just.NegElim => return preJustNegElim(o)
        case o: Just.BottomElim => return preJustBottomElim(o)
        case o: Just.Pbc => return preJustPbc(o)
        case o: Just.ForallIntro => return preJustForallIntro(o)
        case o: Just.ForallElim => return preJustForallElim(o)
        case o: Just.ExistsIntro => return preJustExistsIntro(o)
        case o: Just.ExistsElim => return preJustExistsElim(o)
        case o: Just.Fact => return preJustFact(o)
        case o: Just.Invariant => return preJustInvariant(o)
        case o: Just.Subst => return preJustSubst(o)
        case o: Just.Auto => return preJustAuto(o)
        case o: Just.Coq => return preJustCoq(o)
      }
    }

    def preJustPremise(o: Just.Premise): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preJustAndIntro(o: Just.AndIntro): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preJustAndElim(o: Just.AndElim): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preJustOrIntro(o: Just.OrIntro): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preJustOrElim(o: Just.OrElim): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preJustImplyIntro(o: Just.ImplyIntro): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preJustImplyElim(o: Just.ImplyElim): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preJustNegIntro(o: Just.NegIntro): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preJustNegElim(o: Just.NegElim): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preJustBottomElim(o: Just.BottomElim): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preJustPbc(o: Just.Pbc): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preJustForallIntro(o: Just.ForallIntro): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preJustForallElim(o: Just.ForallElim): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preJustExistsIntro(o: Just.ExistsIntro): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preJustExistsElim(o: Just.ExistsElim): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preJustFact(o: Just.Fact): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preJustInvariant(o: Just.Invariant): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preJustSubst(o: Just.Subst): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preJustAuto(o: Just.Auto): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preJustCoq(o: Just.Coq): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def preTruthTableRow(o: TruthTable.Row): PreResult[TruthTable.Row] = {
      return PreResult(T, MNone())
    }

    def preTruthTableConclusion(o: TruthTable.Conclusion): PreResult[TruthTable.Conclusion] = {
      o match {
        case o: TruthTable.Conclusion.Validity => return preTruthTableConclusionValidity(o)
        case o: TruthTable.Conclusion.Tautology => return preTruthTableConclusionTautology(o)
        case o: TruthTable.Conclusion.Contradictory => return preTruthTableConclusionContradictory(o)
        case o: TruthTable.Conclusion.Contingent => return preTruthTableConclusionContingent(o)
      }
    }

    def preTruthTableConclusionValidity(o: TruthTable.Conclusion.Validity): PreResult[TruthTable.Conclusion] = {
      return PreResult(T, MNone())
    }

    def preTruthTableConclusionTautology(o: TruthTable.Conclusion.Tautology): PreResult[TruthTable.Conclusion] = {
      return PreResult(T, MNone())
    }

    def preTruthTableConclusionContradictory(o: TruthTable.Conclusion.Contradictory): PreResult[TruthTable.Conclusion] = {
      return PreResult(T, MNone())
    }

    def preTruthTableConclusionContingent(o: TruthTable.Conclusion.Contingent): PreResult[TruthTable.Conclusion] = {
      return PreResult(T, MNone())
    }

    def preAttr(o: Attr): PreResult[Attr] = {
      return PreResult(T, MNone())
    }

    def preTypedAttr(o: TypedAttr): PreResult[TypedAttr] = {
      return PreResult(T, MNone())
    }

    def preResolvedAttr(o: ResolvedAttr): PreResult[ResolvedAttr] = {
      return PreResult(T, MNone())
    }

    def preResolvedInfo(o: ResolvedInfo): PreResult[ResolvedInfo] = {
      return PreResult(T, MNone())
    }

    def prePosInfo(o: PosInfo): PreResult[PosInfo] = {
      return PreResult(T, MNone())
    }

    def postTopUnit(o: TopUnit): MOption[TopUnit] = {
      o match {
        case o: TopUnit.Program => return postTopUnitProgram(o)
        case o: TopUnit.SequentUnit => return postTopUnitSequentUnit(o)
        case o: TopUnit.TruthTableUnit => return postTopUnitTruthTableUnit(o)
      }
    }

    def postTopUnitProgram(o: TopUnit.Program): MOption[TopUnit] = {
      return MNone()
    }

    def postTopUnitSequentUnit(o: TopUnit.SequentUnit): MOption[TopUnit] = {
      return MNone()
    }

    def postTopUnitTruthTableUnit(o: TopUnit.TruthTableUnit): MOption[TopUnit] = {
      return MNone()
    }

    def postStmt(o: Stmt): MOption[Stmt] = {
      o match {
        case o: Stmt.Import => return postStmtImport(o)
        case o: Stmt.Var => return postStmtVar(o)
        case o: Stmt.VarPattern => return postStmtVarPattern(o)
        case o: Stmt.SpecVar => return postStmtSpecVar(o)
        case o: Stmt.Method => return postStmtMethod(o)
        case o: Stmt.ExtMethod => return postStmtExtMethod(o)
        case o: Stmt.SpecMethod => return postStmtSpecMethod(o)
        case o: Stmt.Enum => return postStmtEnum(o)
        case o: Stmt.Object => return postStmtObject(o)
        case o: Stmt.Sig => return postStmtSig(o)
        case o: Stmt.AbstractDatatype => return postStmtAbstractDatatype(o)
        case o: Stmt.Rich => return postStmtRich(o)
        case o: Stmt.TypeAlias => return postStmtTypeAlias(o)
        case o: Stmt.Assign => return postStmtAssign(o)
        case o: Stmt.AssignUp => return postStmtAssignUp(o)
        case o: Stmt.AssignPattern => return postStmtAssignPattern(o)
        case o: Stmt.Block => return postStmtBlock(o)
        case o: Stmt.If => return postStmtIf(o)
        case o: Stmt.Match => return postStmtMatch(o)
        case o: Stmt.While => return postStmtWhile(o)
        case o: Stmt.DoWhile => return postStmtDoWhile(o)
        case o: Stmt.For => return postStmtFor(o)
        case o: Stmt.Return => return postStmtReturn(o)
        case o: Stmt.LStmt => return postStmtLStmt(o)
        case o: Stmt.Expr => return postStmtExpr(o)
      }
    }

    def postStmtImport(o: Stmt.Import): MOption[Stmt] = {
      return MNone()
    }

    def postStmtImportImporter(o: Stmt.Import.Importer): MOption[Stmt.Import.Importer] = {
      return MNone()
    }

    def postStmtImportSelector(o: Stmt.Import.Selector): MOption[Stmt.Import.Selector] = {
      o match {
        case o: Stmt.Import.MultiSelector => return postStmtImportMultiSelector(o)
        case o: Stmt.Import.WildcardSelector => return postStmtImportWildcardSelector(o)
      }
    }

    def postStmtImportMultiSelector(o: Stmt.Import.MultiSelector): MOption[Stmt.Import.Selector] = {
      return MNone()
    }

    def postStmtImportWildcardSelector(o: Stmt.Import.WildcardSelector): MOption[Stmt.Import.Selector] = {
      return MNone()
    }

    def postStmtImportNamedSelector(o: Stmt.Import.NamedSelector): MOption[Stmt.Import.NamedSelector] = {
      return MNone()
    }

    def postStmtVar(o: Stmt.Var): MOption[Stmt] = {
      return MNone()
    }

    def postStmtVarPattern(o: Stmt.VarPattern): MOption[Stmt] = {
      return MNone()
    }

    def postStmtSpecVar(o: Stmt.SpecVar): MOption[Stmt] = {
      return MNone()
    }

    def postStmtMethod(o: Stmt.Method): MOption[Stmt] = {
      return MNone()
    }

    def postStmtExtMethod(o: Stmt.ExtMethod): MOption[Stmt] = {
      return MNone()
    }

    def postStmtSpecMethod(o: Stmt.SpecMethod): MOption[Stmt] = {
      return MNone()
    }

    def postStmtEnum(o: Stmt.Enum): MOption[Stmt] = {
      return MNone()
    }

    def postStmtObject(o: Stmt.Object): MOption[Stmt] = {
      return MNone()
    }

    def postStmtSig(o: Stmt.Sig): MOption[Stmt] = {
      return MNone()
    }

    def postStmtAbstractDatatype(o: Stmt.AbstractDatatype): MOption[Stmt] = {
      return MNone()
    }

    def postStmtRich(o: Stmt.Rich): MOption[Stmt] = {
      return MNone()
    }

    def postStmtTypeAlias(o: Stmt.TypeAlias): MOption[Stmt] = {
      return MNone()
    }

    def postStmtAssign(o: Stmt.Assign): MOption[Stmt] = {
      return MNone()
    }

    def postStmtAssignUp(o: Stmt.AssignUp): MOption[Stmt] = {
      return MNone()
    }

    def postStmtAssignPattern(o: Stmt.AssignPattern): MOption[Stmt] = {
      return MNone()
    }

    def postStmtBlock(o: Stmt.Block): MOption[Stmt] = {
      return MNone()
    }

    def postStmtIf(o: Stmt.If): MOption[Stmt] = {
      return MNone()
    }

    def postStmtMatch(o: Stmt.Match): MOption[Stmt] = {
      return MNone()
    }

    def postStmtWhile(o: Stmt.While): MOption[Stmt] = {
      return MNone()
    }

    def postStmtDoWhile(o: Stmt.DoWhile): MOption[Stmt] = {
      return MNone()
    }

    def postStmtFor(o: Stmt.For): MOption[Stmt] = {
      return MNone()
    }

    def postStmtReturn(o: Stmt.Return): MOption[Stmt] = {
      return MNone()
    }

    def postStmtLStmt(o: Stmt.LStmt): MOption[Stmt] = {
      return MNone()
    }

    def postStmtExpr(o: Stmt.Expr): MOption[Stmt] = {
      return MNone()
    }

    def postLClause(o: LClause): MOption[LClause] = {
      o match {
        case o: LClause.Invariants => return postLClauseInvariants(o)
        case o: LClause.Facts => return postLClauseFacts(o)
        case o: LClause.Theorems => return postLClauseTheorems(o)
        case o: LClause.Sequent => return postLClauseSequent(o)
        case o: LClause.Proof => return postLClauseProof(o)
      }
    }

    def postLClauseInvariants(o: LClause.Invariants): MOption[LClause] = {
      return MNone()
    }

    def postLClauseFacts(o: LClause.Facts): MOption[LClause] = {
      return MNone()
    }

    def postLClauseFact(o: LClause.Fact): MOption[LClause.Fact] = {
      return MNone()
    }

    def postLClauseTheorems(o: LClause.Theorems): MOption[LClause] = {
      return MNone()
    }

    def postLClauseTheorem(o: LClause.Theorem): MOption[LClause.Theorem] = {
      return MNone()
    }

    def postLClauseSequent(o: LClause.Sequent): MOption[LClause] = {
      return MNone()
    }

    def postLClauseProof(o: LClause.Proof): MOption[LClause] = {
      return MNone()
    }

    def postContractExp(o: ContractExp): MOption[ContractExp] = {
      return MNone()
    }

    def postCase(o: Case): MOption[Case] = {
      return MNone()
    }

    def postEnumGenRange(o: EnumGen.Range): MOption[EnumGen.Range] = {
      o match {
        case o: EnumGen.Range.Expr => return postEnumGenRangeExpr(o)
        case o: EnumGen.Range.Indices => return postEnumGenRangeIndices(o)
        case o: EnumGen.Range.Step => return postEnumGenRangeStep(o)
      }
    }

    def postEnumGenRangeExpr(o: EnumGen.Range.Expr): MOption[EnumGen.Range] = {
      return MNone()
    }

    def postEnumGenRangeIndices(o: EnumGen.Range.Indices): MOption[EnumGen.Range] = {
      return MNone()
    }

    def postEnumGenRangeStep(o: EnumGen.Range.Step): MOption[EnumGen.Range] = {
      return MNone()
    }

    def postEnumGenFor(o: EnumGen.For): MOption[EnumGen.For] = {
      return MNone()
    }

    def postType(o: Type): MOption[Type] = {
      o match {
        case o: Type.Named => return postTypeNamed(o)
        case o: Type.Fun => return postTypeFun(o)
        case o: Type.Tuple => return postTypeTuple(o)
      }
    }

    def postTypeNamed(o: Type.Named): MOption[Type] = {
      return MNone()
    }

    def postTypeFun(o: Type.Fun): MOption[Type] = {
      return MNone()
    }

    def postTypeTuple(o: Type.Tuple): MOption[Type] = {
      return MNone()
    }

    def postPattern(o: Pattern): MOption[Pattern] = {
      o match {
        case o: Pattern.Literal => return postPatternLiteral(o)
        case o: Pattern.Ref => return postPatternRef(o)
        case o: Pattern.Variable => return postPatternVariable(o)
        case o: Pattern.Wildcard => return postPatternWildcard(o)
        case o: Pattern.SeqWildcard => return postPatternSeqWildcard(o)
        case o: Pattern.Structure => return postPatternStructure(o)
      }
    }

    def postPatternLiteral(o: Pattern.Literal): MOption[Pattern] = {
      return MNone()
    }

    def postPatternRef(o: Pattern.Ref): MOption[Pattern] = {
      return MNone()
    }

    def postPatternVariable(o: Pattern.Variable): MOption[Pattern] = {
      return MNone()
    }

    def postPatternWildcard(o: Pattern.Wildcard): MOption[Pattern] = {
      return MNone()
    }

    def postPatternSeqWildcard(o: Pattern.SeqWildcard): MOption[Pattern] = {
      return MNone()
    }

    def postPatternStructure(o: Pattern.Structure): MOption[Pattern] = {
      return MNone()
    }

    def postExp(o: Exp): MOption[Exp] = {
      o match {
        case o: Exp.LitB => return postExpLitB(o)
        case o: Exp.LitC => return postExpLitC(o)
        case o: Exp.LitZ => return postExpLitZ(o)
        case o: Exp.LitZ8 => return postExpLitZ8(o)
        case o: Exp.LitZ16 => return postExpLitZ16(o)
        case o: Exp.LitZ32 => return postExpLitZ32(o)
        case o: Exp.LitZ64 => return postExpLitZ64(o)
        case o: Exp.LitN => return postExpLitN(o)
        case o: Exp.LitN8 => return postExpLitN8(o)
        case o: Exp.LitN16 => return postExpLitN16(o)
        case o: Exp.LitN32 => return postExpLitN32(o)
        case o: Exp.LitN64 => return postExpLitN64(o)
        case o: Exp.LitS8 => return postExpLitS8(o)
        case o: Exp.LitS16 => return postExpLitS16(o)
        case o: Exp.LitS32 => return postExpLitS32(o)
        case o: Exp.LitS64 => return postExpLitS64(o)
        case o: Exp.LitU8 => return postExpLitU8(o)
        case o: Exp.LitU16 => return postExpLitU16(o)
        case o: Exp.LitU32 => return postExpLitU32(o)
        case o: Exp.LitU64 => return postExpLitU64(o)
        case o: Exp.LitF32 => return postExpLitF32(o)
        case o: Exp.LitF64 => return postExpLitF64(o)
        case o: Exp.LitR => return postExpLitR(o)
        case o: Exp.LitBv => return postExpLitBv(o)
        case o: Exp.LitString => return postExpLitString(o)
        case o: Exp.StringInterpolate => return postExpStringInterpolate(o)
        case o: Exp.This => return postExpThis(o)
        case o: Exp.Super => return postExpSuper(o)
        case o: Exp.Unary => return postExpUnary(o)
        case o: Exp.Binary => return postExpBinary(o)
        case o: Exp.Ident => return postExpIdent(o)
        case o: Exp.Eta => return postExpEta(o)
        case o: Exp.Tuple => return postExpTuple(o)
        case o: Exp.Select => return postExpSelect(o)
        case o: Exp.Invoke => return postExpInvoke(o)
        case o: Exp.InvokeNamed => return postExpInvokeNamed(o)
        case o: Exp.If => return postExpIf(o)
        case o: Exp.Fun => return postExpFun(o)
        case o: Exp.ForYield => return postExpForYield(o)
        case o: Exp.Quant => return postExpQuant(o)
      }
    }

    def postExpLitB(o: Exp.LitB): MOption[Exp] = {
      return MNone()
    }

    def postExpLitC(o: Exp.LitC): MOption[Exp] = {
      return MNone()
    }

    def postExpLitZ(o: Exp.LitZ): MOption[Exp] = {
      return MNone()
    }

    def postExpLitZ8(o: Exp.LitZ8): MOption[Exp] = {
      return MNone()
    }

    def postExpLitZ16(o: Exp.LitZ16): MOption[Exp] = {
      return MNone()
    }

    def postExpLitZ32(o: Exp.LitZ32): MOption[Exp] = {
      return MNone()
    }

    def postExpLitZ64(o: Exp.LitZ64): MOption[Exp] = {
      return MNone()
    }

    def postExpLitN(o: Exp.LitN): MOption[Exp] = {
      return MNone()
    }

    def postExpLitN8(o: Exp.LitN8): MOption[Exp] = {
      return MNone()
    }

    def postExpLitN16(o: Exp.LitN16): MOption[Exp] = {
      return MNone()
    }

    def postExpLitN32(o: Exp.LitN32): MOption[Exp] = {
      return MNone()
    }

    def postExpLitN64(o: Exp.LitN64): MOption[Exp] = {
      return MNone()
    }

    def postExpLitS8(o: Exp.LitS8): MOption[Exp] = {
      return MNone()
    }

    def postExpLitS16(o: Exp.LitS16): MOption[Exp] = {
      return MNone()
    }

    def postExpLitS32(o: Exp.LitS32): MOption[Exp] = {
      return MNone()
    }

    def postExpLitS64(o: Exp.LitS64): MOption[Exp] = {
      return MNone()
    }

    def postExpLitU8(o: Exp.LitU8): MOption[Exp] = {
      return MNone()
    }

    def postExpLitU16(o: Exp.LitU16): MOption[Exp] = {
      return MNone()
    }

    def postExpLitU32(o: Exp.LitU32): MOption[Exp] = {
      return MNone()
    }

    def postExpLitU64(o: Exp.LitU64): MOption[Exp] = {
      return MNone()
    }

    def postExpLitF32(o: Exp.LitF32): MOption[Exp] = {
      return MNone()
    }

    def postExpLitF64(o: Exp.LitF64): MOption[Exp] = {
      return MNone()
    }

    def postExpLitR(o: Exp.LitR): MOption[Exp] = {
      return MNone()
    }

    def postExpLitBv(o: Exp.LitBv): MOption[Exp] = {
      return MNone()
    }

    def postExpLitString(o: Exp.LitString): MOption[Exp] = {
      return MNone()
    }

    def postExpStringInterpolate(o: Exp.StringInterpolate): MOption[Exp] = {
      return MNone()
    }

    def postExpThis(o: Exp.This): MOption[Exp] = {
      return MNone()
    }

    def postExpSuper(o: Exp.Super): MOption[Exp] = {
      return MNone()
    }

    def postExpUnary(o: Exp.Unary): MOption[Exp] = {
      return MNone()
    }

    def postExpBinary(o: Exp.Binary): MOption[Exp] = {
      return MNone()
    }

    def postExpIdent(o: Exp.Ident): MOption[Exp] = {
      return MNone()
    }

    def postExpEta(o: Exp.Eta): MOption[Exp] = {
      return MNone()
    }

    def postExpTuple(o: Exp.Tuple): MOption[Exp] = {
      return MNone()
    }

    def postExpSelect(o: Exp.Select): MOption[Exp] = {
      return MNone()
    }

    def postExpInvoke(o: Exp.Invoke): MOption[Exp] = {
      return MNone()
    }

    def postExpInvokeNamed(o: Exp.InvokeNamed): MOption[Exp] = {
      return MNone()
    }

    def postExpIf(o: Exp.If): MOption[Exp] = {
      return MNone()
    }

    def postExpFun(o: Exp.Fun): MOption[Exp] = {
      return MNone()
    }

    def postExpForYield(o: Exp.ForYield): MOption[Exp] = {
      return MNone()
    }

    def postExpQuant(o: Exp.Quant): MOption[Exp] = {
      return MNone()
    }

    def postNamedArg(o: NamedArg): MOption[NamedArg] = {
      return MNone()
    }

    def postVarFragment(o: VarFragment): MOption[VarFragment] = {
      return MNone()
    }

    def postDomain(o: Domain): MOption[Domain] = {
      o match {
        case o: Domain.Type => return postDomainType(o)
        case o: Domain.Range => return postDomainRange(o)
      }
    }

    def postDomainType(o: Domain.Type): MOption[Domain] = {
      return MNone()
    }

    def postDomainRange(o: Domain.Range): MOption[Domain] = {
      return MNone()
    }

    def postId(o: Id): MOption[Id] = {
      return MNone()
    }

    def postName(o: Name): MOption[Name] = {
      return MNone()
    }

    def postBody(o: Body): MOption[Body] = {
      return MNone()
    }

    def postAbstractDatatypeParam(o: AbstractDatatypeParam): MOption[AbstractDatatypeParam] = {
      return MNone()
    }

    def postMethodSig(o: MethodSig): MOption[MethodSig] = {
      return MNone()
    }

    def postParam(o: Param): MOption[Param] = {
      return MNone()
    }

    def postTypeParam(o: TypeParam): MOption[TypeParam] = {
      return MNone()
    }

    def postContract(o: Contract): MOption[Contract] = {
      return MNone()
    }

    def postSubContract(o: SubContract): MOption[SubContract] = {
      return MNone()
    }

    def postSubContractParam(o: SubContractParam): MOption[SubContractParam] = {
      return MNone()
    }

    def postWhereDef(o: WhereDef): MOption[WhereDef] = {
      o match {
        case o: WhereDef.Val => return postWhereDefVal(o)
        case o: WhereDef.Def => return postWhereDefDef(o)
      }
    }

    def postWhereDefVal(o: WhereDef.Val): MOption[WhereDef] = {
      return MNone()
    }

    def postWhereDefDef(o: WhereDef.Def): MOption[WhereDef] = {
      return MNone()
    }

    def postSpecDef(o: SpecDef): MOption[SpecDef] = {
      return MNone()
    }

    def postProofStep(o: ProofStep): MOption[ProofStep] = {
      o match {
        case o: ProofStep.Basic => return postProofStepBasic(o)
        case o: ProofStep.SubProof => return postProofStepSubProof(o)
      }
    }

    def postProofStepBasic(o: ProofStep.Basic): MOption[ProofStep] = {
      return MNone()
    }

    def postProofStepSubProof(o: ProofStep.SubProof): MOption[ProofStep] = {
      return MNone()
    }

    def postAssumeProofStep(o: AssumeProofStep): MOption[AssumeProofStep] = {
      o match {
        case o: AssumeProofStep.Regular => return postAssumeProofStepRegular(o)
        case o: AssumeProofStep.ForallIntroAps => return postAssumeProofStepForallIntroAps(o)
        case o: AssumeProofStep.ExistsElimAps => return postAssumeProofStepExistsElimAps(o)
      }
    }

    def postAssumeProofStepRegular(o: AssumeProofStep.Regular): MOption[AssumeProofStep] = {
      return MNone()
    }

    def postAssumeProofStepForallIntroAps(o: AssumeProofStep.ForallIntroAps): MOption[AssumeProofStep] = {
      return MNone()
    }

    def postAssumeProofStepExistsElimAps(o: AssumeProofStep.ExistsElimAps): MOption[AssumeProofStep] = {
      return MNone()
    }

    def postJust(o: Just): MOption[Just] = {
      o match {
        case o: Just.Premise => return postJustPremise(o)
        case o: Just.AndIntro => return postJustAndIntro(o)
        case o: Just.AndElim => return postJustAndElim(o)
        case o: Just.OrIntro => return postJustOrIntro(o)
        case o: Just.OrElim => return postJustOrElim(o)
        case o: Just.ImplyIntro => return postJustImplyIntro(o)
        case o: Just.ImplyElim => return postJustImplyElim(o)
        case o: Just.NegIntro => return postJustNegIntro(o)
        case o: Just.NegElim => return postJustNegElim(o)
        case o: Just.BottomElim => return postJustBottomElim(o)
        case o: Just.Pbc => return postJustPbc(o)
        case o: Just.ForallIntro => return postJustForallIntro(o)
        case o: Just.ForallElim => return postJustForallElim(o)
        case o: Just.ExistsIntro => return postJustExistsIntro(o)
        case o: Just.ExistsElim => return postJustExistsElim(o)
        case o: Just.Fact => return postJustFact(o)
        case o: Just.Invariant => return postJustInvariant(o)
        case o: Just.Subst => return postJustSubst(o)
        case o: Just.Auto => return postJustAuto(o)
        case o: Just.Coq => return postJustCoq(o)
      }
    }

    def postJustPremise(o: Just.Premise): MOption[Just] = {
      return MNone()
    }

    def postJustAndIntro(o: Just.AndIntro): MOption[Just] = {
      return MNone()
    }

    def postJustAndElim(o: Just.AndElim): MOption[Just] = {
      return MNone()
    }

    def postJustOrIntro(o: Just.OrIntro): MOption[Just] = {
      return MNone()
    }

    def postJustOrElim(o: Just.OrElim): MOption[Just] = {
      return MNone()
    }

    def postJustImplyIntro(o: Just.ImplyIntro): MOption[Just] = {
      return MNone()
    }

    def postJustImplyElim(o: Just.ImplyElim): MOption[Just] = {
      return MNone()
    }

    def postJustNegIntro(o: Just.NegIntro): MOption[Just] = {
      return MNone()
    }

    def postJustNegElim(o: Just.NegElim): MOption[Just] = {
      return MNone()
    }

    def postJustBottomElim(o: Just.BottomElim): MOption[Just] = {
      return MNone()
    }

    def postJustPbc(o: Just.Pbc): MOption[Just] = {
      return MNone()
    }

    def postJustForallIntro(o: Just.ForallIntro): MOption[Just] = {
      return MNone()
    }

    def postJustForallElim(o: Just.ForallElim): MOption[Just] = {
      return MNone()
    }

    def postJustExistsIntro(o: Just.ExistsIntro): MOption[Just] = {
      return MNone()
    }

    def postJustExistsElim(o: Just.ExistsElim): MOption[Just] = {
      return MNone()
    }

    def postJustFact(o: Just.Fact): MOption[Just] = {
      return MNone()
    }

    def postJustInvariant(o: Just.Invariant): MOption[Just] = {
      return MNone()
    }

    def postJustSubst(o: Just.Subst): MOption[Just] = {
      return MNone()
    }

    def postJustAuto(o: Just.Auto): MOption[Just] = {
      return MNone()
    }

    def postJustCoq(o: Just.Coq): MOption[Just] = {
      return MNone()
    }

    def postTruthTableRow(o: TruthTable.Row): MOption[TruthTable.Row] = {
      return MNone()
    }

    def postTruthTableConclusion(o: TruthTable.Conclusion): MOption[TruthTable.Conclusion] = {
      o match {
        case o: TruthTable.Conclusion.Validity => return postTruthTableConclusionValidity(o)
        case o: TruthTable.Conclusion.Tautology => return postTruthTableConclusionTautology(o)
        case o: TruthTable.Conclusion.Contradictory => return postTruthTableConclusionContradictory(o)
        case o: TruthTable.Conclusion.Contingent => return postTruthTableConclusionContingent(o)
      }
    }

    def postTruthTableConclusionValidity(o: TruthTable.Conclusion.Validity): MOption[TruthTable.Conclusion] = {
      return MNone()
    }

    def postTruthTableConclusionTautology(o: TruthTable.Conclusion.Tautology): MOption[TruthTable.Conclusion] = {
      return MNone()
    }

    def postTruthTableConclusionContradictory(o: TruthTable.Conclusion.Contradictory): MOption[TruthTable.Conclusion] = {
      return MNone()
    }

    def postTruthTableConclusionContingent(o: TruthTable.Conclusion.Contingent): MOption[TruthTable.Conclusion] = {
      return MNone()
    }

    def postAttr(o: Attr): MOption[Attr] = {
      return MNone()
    }

    def postTypedAttr(o: TypedAttr): MOption[TypedAttr] = {
      return MNone()
    }

    def postResolvedAttr(o: ResolvedAttr): MOption[ResolvedAttr] = {
      return MNone()
    }

    def postResolvedInfo(o: ResolvedInfo): MOption[ResolvedInfo] = {
      return MNone()
    }

    def postPosInfo(o: PosInfo): MOption[PosInfo] = {
      return MNone()
    }

  }

  def transformISZ[T](s: IS[Z, T], f: T => MOption[T]): MOption[IS[Z, T]] = {
    val s2: MS[Z, T] = SI.toMS(s)
    var changed: B = F
    for (i <- s2.indices) {
      val e: T = s(i)
      val r: MOption[T] = f(e)
      changed = changed || r.nonEmpty
      s2(i) = r.getOrElse(e)
    }
    if (changed) {
      return MSome(SM.toIS(s2))
    } else {
      return MNone()
    }
  }

  def transformOption[T](option: Option[T], f: T => MOption[T]): MOption[Option[T]] = {
    option match {
      case Some(v) =>
        val r = f(v)
        r match {
          case MSome(v2) => return MSome(Some(v2))
          case _ => return MNone()
        }
      case _ => return MNone()
    }
  }

}

import MTransformer._

@record class MTransformer(pp: PrePost) {

  def transformTopUnit(o: TopUnit): MOption[TopUnit] = {
    val preR: PreResult[TopUnit] = pp.preTopUnit(o)
    val r: MOption[TopUnit] = if (preR.continue) {
      val o2: TopUnit = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[TopUnit] = o2 match {
        case o2: TopUnit.Program =>
          val r0: MOption[Name] = transformName(o2.packageName)
          val r1: MOption[Body] = transformBody(o2.body)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(packageName = r0.getOrElse(o2.packageName), body = r1.getOrElse(o2.body)))
          else
            MNone()
        case o2: TopUnit.SequentUnit =>
          val r0: MOption[LClause.Sequent] = transformLClauseSequent(o2.sequent)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(sequent = r0.getOrElse(o2.sequent)))
          else
            MNone()
        case o2: TopUnit.TruthTableUnit =>
          val r0: MOption[IS[Z, PosInfo]] = transformISZ(o2.stars, transformPosInfo _)
          val r1: MOption[IS[Z, Id]] = transformISZ(o2.vars, transformId _)
          val r2: MOption[PosInfo] = transformPosInfo(o2.separator)
          val r3: MOption[LClause.Sequent] = transformLClauseSequent(o2.sequent)
          val r4: MOption[IS[Z, TruthTable.Row]] = transformISZ(o2.rows, transformTruthTableRow _)
          val r5: MOption[Option[TruthTable.Conclusion]] = transformOption(o2.conclusionOpt, transformTruthTableConclusion _)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty || r4.nonEmpty || r5.nonEmpty)
            MSome(o2(stars = r0.getOrElse(o2.stars), vars = r1.getOrElse(o2.vars), separator = r2.getOrElse(o2.separator), sequent = r3.getOrElse(o2.sequent), rows = r4.getOrElse(o2.rows), conclusionOpt = r5.getOrElse(o2.conclusionOpt)))
          else
            MNone()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: TopUnit = r.getOrElse(o)
    val postR: MOption[TopUnit] = pp.postTopUnit(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformStmt(o: Stmt): MOption[Stmt] = {
    val preR: PreResult[Stmt] = pp.preStmt(o)
    val r: MOption[Stmt] = if (preR.continue) {
      val o2: Stmt = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Stmt] = o2 match {
        case o2: Stmt.Import =>
          val r0: MOption[IS[Z, Stmt.Import.Importer]] = transformISZ(o2.importers, transformStmtImportImporter _)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(importers = r0.getOrElse(o2.importers), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Var =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[Option[Type]] = transformOption(o2.tipeOpt, transformType _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), tipeOpt = r1.getOrElse(o2.tipeOpt), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.VarPattern =>
          val r0: MOption[Pattern] = transformPattern(o2.pattern)
          val r1: MOption[Option[Type]] = transformOption(o2.tipeOpt, transformType _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(pattern = r0.getOrElse(o2.pattern), tipeOpt = r1.getOrElse(o2.tipeOpt), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.SpecVar =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[Type] = transformType(o2.tipe)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), tipe = r1.getOrElse(o2.tipe), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Method =>
          val r0: MOption[MethodSig] = transformMethodSig(o2.sig)
          val r1: MOption[Contract] = transformContract(o2.contract)
          val r2: MOption[Option[Body]] = transformOption(o2.bodyOpt, transformBody _)
          val r3: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(sig = r0.getOrElse(o2.sig), contract = r1.getOrElse(o2.contract), bodyOpt = r2.getOrElse(o2.bodyOpt), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.ExtMethod =>
          val r0: MOption[MethodSig] = transformMethodSig(o2.sig)
          val r1: MOption[Contract] = transformContract(o2.contract)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(sig = r0.getOrElse(o2.sig), contract = r1.getOrElse(o2.contract), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.SpecMethod =>
          val r0: MOption[MethodSig] = transformMethodSig(o2.sig)
          val r1: MOption[IS[Z, SpecDef]] = transformISZ(o2.defs, transformSpecDef _)
          val r2: MOption[IS[Z, WhereDef]] = transformISZ(o2.where, transformWhereDef _)
          val r3: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(sig = r0.getOrElse(o2.sig), defs = r1.getOrElse(o2.defs), where = r2.getOrElse(o2.where), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Enum =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[IS[Z, Id]] = transformISZ(o2.elements, transformId _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), elements = r1.getOrElse(o2.elements), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Object =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[IS[Z, Type]] = transformISZ(o2.parents, transformType _)
          val r2: MOption[IS[Z, Stmt]] = transformISZ(o2.stmts, transformStmt _)
          val r3: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), parents = r1.getOrElse(o2.parents), stmts = r2.getOrElse(o2.stmts), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Sig =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[IS[Z, TypeParam]] = transformISZ(o2.typeParams, transformTypeParam _)
          val r2: MOption[IS[Z, Type.Named]] = transformISZ(o2.parents, transformTypeNamed _)
          val r3: MOption[Option[Type]] = transformOption(o2.selfTypeOpt, transformType _)
          val r4: MOption[IS[Z, Stmt]] = transformISZ(o2.stmts, transformStmt _)
          val r5: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty || r4.nonEmpty || r5.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), typeParams = r1.getOrElse(o2.typeParams), parents = r2.getOrElse(o2.parents), selfTypeOpt = r3.getOrElse(o2.selfTypeOpt), stmts = r4.getOrElse(o2.stmts), attr = r5.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.AbstractDatatype =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[IS[Z, TypeParam]] = transformISZ(o2.typeParams, transformTypeParam _)
          val r2: MOption[IS[Z, AbstractDatatypeParam]] = transformISZ(o2.params, transformAbstractDatatypeParam _)
          val r3: MOption[IS[Z, Type.Named]] = transformISZ(o2.parents, transformTypeNamed _)
          val r4: MOption[IS[Z, Stmt]] = transformISZ(o2.stmts, transformStmt _)
          val r5: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty || r4.nonEmpty || r5.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), typeParams = r1.getOrElse(o2.typeParams), params = r2.getOrElse(o2.params), parents = r3.getOrElse(o2.parents), stmts = r4.getOrElse(o2.stmts), attr = r5.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Rich =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[IS[Z, TypeParam]] = transformISZ(o2.typeParams, transformTypeParam _)
          val r2: MOption[IS[Z, Param]] = transformISZ(o2.params, transformParam _)
          val r3: MOption[IS[Z, Type.Named]] = transformISZ(o2.parents, transformTypeNamed _)
          val r4: MOption[IS[Z, Stmt]] = transformISZ(o2.stmts, transformStmt _)
          val r5: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty || r4.nonEmpty || r5.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), typeParams = r1.getOrElse(o2.typeParams), params = r2.getOrElse(o2.params), parents = r3.getOrElse(o2.parents), stmts = r4.getOrElse(o2.stmts), attr = r5.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.TypeAlias =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[IS[Z, TypeParam]] = transformISZ(o2.typeParams, transformTypeParam _)
          val r2: MOption[Type] = transformType(o2.tipe)
          val r3: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), typeParams = r1.getOrElse(o2.typeParams), tipe = r2.getOrElse(o2.tipe), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Assign =>
          val r0: MOption[Exp] = transformExp(o2.lhs)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(lhs = r0.getOrElse(o2.lhs), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.AssignUp =>
          val r0: MOption[Exp] = transformExp(o2.lhs)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(lhs = r0.getOrElse(o2.lhs), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.AssignPattern =>
          val r0: MOption[Pattern] = transformPattern(o2.lhs)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(lhs = r0.getOrElse(o2.lhs), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Block =>
          val r0: MOption[Body] = transformBody(o2.body)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(body = r0.getOrElse(o2.body), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.If =>
          val r0: MOption[Exp] = transformExp(o2.cond)
          val r1: MOption[Body] = transformBody(o2.thenbody)
          val r2: MOption[Body] = transformBody(o2.elsebody)
          val r3: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(cond = r0.getOrElse(o2.cond), thenbody = r1.getOrElse(o2.thenbody), elsebody = r2.getOrElse(o2.elsebody), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Match =>
          val r0: MOption[Exp] = transformExp(o2.cond)
          val r1: MOption[IS[Z, Case]] = transformISZ(o2.cases, transformCase _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(cond = r0.getOrElse(o2.cond), cases = r1.getOrElse(o2.cases), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.While =>
          val r0: MOption[Exp] = transformExp(o2.cond)
          val r1: MOption[IS[Z, ContractExp]] = transformISZ(o2.invariants, transformContractExp _)
          val r2: MOption[IS[Z, Exp]] = transformISZ(o2.modifies, transformExp _)
          val r3: MOption[Body] = transformBody(o2.body)
          val r4: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty || r4.nonEmpty)
            MSome(o2(cond = r0.getOrElse(o2.cond), invariants = r1.getOrElse(o2.invariants), modifies = r2.getOrElse(o2.modifies), body = r3.getOrElse(o2.body), attr = r4.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.DoWhile =>
          val r0: MOption[Exp] = transformExp(o2.cond)
          val r1: MOption[IS[Z, ContractExp]] = transformISZ(o2.invariants, transformContractExp _)
          val r2: MOption[IS[Z, Exp]] = transformISZ(o2.modifies, transformExp _)
          val r3: MOption[Body] = transformBody(o2.body)
          val r4: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty || r4.nonEmpty)
            MSome(o2(cond = r0.getOrElse(o2.cond), invariants = r1.getOrElse(o2.invariants), modifies = r2.getOrElse(o2.modifies), body = r3.getOrElse(o2.body), attr = r4.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.For =>
          val r0: MOption[EnumGen.For] = transformEnumGenFor(o2.enumGen)
          val r1: MOption[IS[Z, ContractExp]] = transformISZ(o2.invariants, transformContractExp _)
          val r2: MOption[IS[Z, Exp]] = transformISZ(o2.modifies, transformExp _)
          val r3: MOption[Body] = transformBody(o2.body)
          val r4: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty || r4.nonEmpty)
            MSome(o2(enumGen = r0.getOrElse(o2.enumGen), invariants = r1.getOrElse(o2.invariants), modifies = r2.getOrElse(o2.modifies), body = r3.getOrElse(o2.body), attr = r4.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Return =>
          val r0: MOption[Option[Exp]] = transformOption(o2.expOpt, transformExp _)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(expOpt = r0.getOrElse(o2.expOpt), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.LStmt =>
          val r0: MOption[LClause] = transformLClause(o2.clause)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(clause = r0.getOrElse(o2.clause), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Expr =>
          val r0: MOption[Exp] = transformExp(o2.exp)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(exp = r0.getOrElse(o2.exp), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Stmt = r.getOrElse(o)
    val postR: MOption[Stmt] = pp.postStmt(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformStmtImportImporter(o: Stmt.Import.Importer): MOption[Stmt.Import.Importer] = {
    val preR: PreResult[Stmt.Import.Importer] = pp.preStmtImportImporter(o)
    val r: MOption[Stmt.Import.Importer] = if (preR.continue) {
      val o2: Stmt.Import.Importer = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Name] = transformName(o2.name)
      val r1: MOption[Option[Stmt.Import.Selector]] = transformOption(o2.selectorOpt, transformStmtImportSelector _)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty)
        MSome(o2(name = r0.getOrElse(o2.name), selectorOpt = r1.getOrElse(o2.selectorOpt)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Stmt.Import.Importer = r.getOrElse(o)
    val postR: MOption[Stmt.Import.Importer] = pp.postStmtImportImporter(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformStmtImportSelector(o: Stmt.Import.Selector): MOption[Stmt.Import.Selector] = {
    val preR: PreResult[Stmt.Import.Selector] = pp.preStmtImportSelector(o)
    val r: MOption[Stmt.Import.Selector] = if (preR.continue) {
      val o2: Stmt.Import.Selector = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Stmt.Import.Selector] = o2 match {
        case o2: Stmt.Import.MultiSelector =>
          val r0: MOption[IS[Z, Stmt.Import.NamedSelector]] = transformISZ(o2.selectors, transformStmtImportNamedSelector _)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(selectors = r0.getOrElse(o2.selectors)))
          else
            MNone()
        case o2: Stmt.Import.WildcardSelector =>
          if (hasChanged)
            MSome(o2)
          else
            MNone()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Stmt.Import.Selector = r.getOrElse(o)
    val postR: MOption[Stmt.Import.Selector] = pp.postStmtImportSelector(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformStmtImportNamedSelector(o: Stmt.Import.NamedSelector): MOption[Stmt.Import.NamedSelector] = {
    val preR: PreResult[Stmt.Import.NamedSelector] = pp.preStmtImportNamedSelector(o)
    val r: MOption[Stmt.Import.NamedSelector] = if (preR.continue) {
      val o2: Stmt.Import.NamedSelector = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.from)
      val r1: MOption[Id] = transformId(o2.to)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty)
        MSome(o2(from = r0.getOrElse(o2.from), to = r1.getOrElse(o2.to)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Stmt.Import.NamedSelector = r.getOrElse(o)
    val postR: MOption[Stmt.Import.NamedSelector] = pp.postStmtImportNamedSelector(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformLClause(o: LClause): MOption[LClause] = {
    val preR: PreResult[LClause] = pp.preLClause(o)
    val r: MOption[LClause] = if (preR.continue) {
      val o2: LClause = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[LClause] = o2 match {
        case o2: LClause.Invariants =>
          val r0: MOption[IS[Z, ContractExp]] = transformISZ(o2.value, transformContractExp _)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(value = r0.getOrElse(o2.value)))
          else
            MNone()
        case o2: LClause.Facts =>
          val r0: MOption[IS[Z, LClause.Fact]] = transformISZ(o2.value, transformLClauseFact _)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(value = r0.getOrElse(o2.value)))
          else
            MNone()
        case o2: LClause.Theorems =>
          val r0: MOption[IS[Z, LClause.Theorem]] = transformISZ(o2.value, transformLClauseTheorem _)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(value = r0.getOrElse(o2.value)))
          else
            MNone()
        case o2: LClause.Sequent =>
          val r0: MOption[IS[Z, Exp]] = transformISZ(o2.premises, transformExp _)
          val r1: MOption[IS[Z, Exp]] = transformISZ(o2.conclusions, transformExp _)
          val r2: MOption[Option[LClause.Proof]] = transformOption(o2.proofOpt, transformLClauseProof _)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(premises = r0.getOrElse(o2.premises), conclusions = r1.getOrElse(o2.conclusions), proofOpt = r2.getOrElse(o2.proofOpt)))
          else
            MNone()
        case o2: LClause.Proof =>
          val r0: MOption[IS[Z, ProofStep]] = transformISZ(o2.steps, transformProofStep _)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(steps = r0.getOrElse(o2.steps)))
          else
            MNone()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: LClause = r.getOrElse(o)
    val postR: MOption[LClause] = pp.postLClause(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformLClauseFact(o: LClause.Fact): MOption[LClause.Fact] = {
    val preR: PreResult[LClause.Fact] = pp.preLClauseFact(o)
    val r: MOption[LClause.Fact] = if (preR.continue) {
      val o2: LClause.Fact = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[Exp] = transformExp(o2.exp)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty)
        MSome(o2(id = r0.getOrElse(o2.id), exp = r1.getOrElse(o2.exp)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: LClause.Fact = r.getOrElse(o)
    val postR: MOption[LClause.Fact] = pp.postLClauseFact(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformLClauseTheorem(o: LClause.Theorem): MOption[LClause.Theorem] = {
    val preR: PreResult[LClause.Theorem] = pp.preLClauseTheorem(o)
    val r: MOption[LClause.Theorem] = if (preR.continue) {
      val o2: LClause.Theorem = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[LClause.Sequent] = transformLClauseSequent(o2.sequent)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty)
        MSome(o2(id = r0.getOrElse(o2.id), sequent = r1.getOrElse(o2.sequent)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: LClause.Theorem = r.getOrElse(o)
    val postR: MOption[LClause.Theorem] = pp.postLClauseTheorem(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformContractExp(o: ContractExp): MOption[ContractExp] = {
    val preR: PreResult[ContractExp] = pp.preContractExp(o)
    val r: MOption[ContractExp] = if (preR.continue) {
      val o2: ContractExp = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Option[Id]] = transformOption(o2.idOpt, transformId _)
      val r1: MOption[Exp] = transformExp(o2.exp)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty)
        MSome(o2(idOpt = r0.getOrElse(o2.idOpt), exp = r1.getOrElse(o2.exp)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: ContractExp = r.getOrElse(o)
    val postR: MOption[ContractExp] = pp.postContractExp(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformCase(o: Case): MOption[Case] = {
    val preR: PreResult[Case] = pp.preCase(o)
    val r: MOption[Case] = if (preR.continue) {
      val o2: Case = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Pattern] = transformPattern(o2.pattern)
      val r1: MOption[Option[Exp]] = transformOption(o2.condOpt, transformExp _)
      val r2: MOption[Body] = transformBody(o2.body)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
        MSome(o2(pattern = r0.getOrElse(o2.pattern), condOpt = r1.getOrElse(o2.condOpt), body = r2.getOrElse(o2.body)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Case = r.getOrElse(o)
    val postR: MOption[Case] = pp.postCase(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformEnumGenRange(o: EnumGen.Range): MOption[EnumGen.Range] = {
    val preR: PreResult[EnumGen.Range] = pp.preEnumGenRange(o)
    val r: MOption[EnumGen.Range] = if (preR.continue) {
      val o2: EnumGen.Range = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[EnumGen.Range] = o2 match {
        case o2: EnumGen.Range.Expr =>
          val r0: MOption[Exp] = transformExp(o2.exp)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(exp = r0.getOrElse(o2.exp)))
          else
            MNone()
        case o2: EnumGen.Range.Indices =>
          val r0: MOption[Exp] = transformExp(o2.exp)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(exp = r0.getOrElse(o2.exp)))
          else
            MNone()
        case o2: EnumGen.Range.Step =>
          val r0: MOption[Exp] = transformExp(o2.start)
          val r1: MOption[Exp] = transformExp(o2.end)
          val r2: MOption[Option[Exp]] = transformOption(o2.byOpt, transformExp _)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(start = r0.getOrElse(o2.start), end = r1.getOrElse(o2.end), byOpt = r2.getOrElse(o2.byOpt)))
          else
            MNone()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: EnumGen.Range = r.getOrElse(o)
    val postR: MOption[EnumGen.Range] = pp.postEnumGenRange(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformEnumGenFor(o: EnumGen.For): MOption[EnumGen.For] = {
    val preR: PreResult[EnumGen.For] = pp.preEnumGenFor(o)
    val r: MOption[EnumGen.For] = if (preR.continue) {
      val o2: EnumGen.For = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[EnumGen.Range] = transformEnumGenRange(o2.range)
      val r2: MOption[Option[Exp]] = transformOption(o2.condOpt, transformExp _)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
        MSome(o2(id = r0.getOrElse(o2.id), range = r1.getOrElse(o2.range), condOpt = r2.getOrElse(o2.condOpt)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: EnumGen.For = r.getOrElse(o)
    val postR: MOption[EnumGen.For] = pp.postEnumGenFor(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformType(o: Type): MOption[Type] = {
    val preR: PreResult[Type] = pp.preType(o)
    val r: MOption[Type] = if (preR.continue) {
      val o2: Type = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Type] = o2 match {
        case o2: Type.Named =>
          val r0: MOption[Name] = transformName(o2.name)
          val r1: MOption[IS[Z, Type]] = transformISZ(o2.typeArgs, transformType _)
          val r2: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(name = r0.getOrElse(o2.name), typeArgs = r1.getOrElse(o2.typeArgs), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Type.Fun =>
          val r0: MOption[IS[Z, Type]] = transformISZ(o2.args, transformType _)
          val r1: MOption[Type] = transformType(o2.ret)
          val r2: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(args = r0.getOrElse(o2.args), ret = r1.getOrElse(o2.ret), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Type.Tuple =>
          val r0: MOption[IS[Z, Type]] = transformISZ(o2.args, transformType _)
          val r1: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(args = r0.getOrElse(o2.args), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Type = r.getOrElse(o)
    val postR: MOption[Type] = pp.postType(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformPattern(o: Pattern): MOption[Pattern] = {
    val preR: PreResult[Pattern] = pp.prePattern(o)
    val r: MOption[Pattern] = if (preR.continue) {
      val o2: Pattern = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Pattern] = o2 match {
        case o2: Pattern.Literal =>
          if (hasChanged)
            MSome(o2)
          else
            MNone()
        case o2: Pattern.Ref =>
          val r0: MOption[Name] = transformName(o2.name)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(name = r0.getOrElse(o2.name)))
          else
            MNone()
        case o2: Pattern.Variable =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[Option[Type]] = transformOption(o2.typeOpt, transformType _)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), typeOpt = r1.getOrElse(o2.typeOpt)))
          else
            MNone()
        case o2: Pattern.Wildcard =>
          val r0: MOption[Option[Type]] = transformOption(o2.typeOpt, transformType _)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(typeOpt = r0.getOrElse(o2.typeOpt)))
          else
            MNone()
        case o2: Pattern.SeqWildcard =>
          if (hasChanged)
            MSome(o2)
          else
            MNone()
        case o2: Pattern.Structure =>
          val r0: MOption[Option[Id]] = transformOption(o2.idOpt, transformId _)
          val r1: MOption[Option[Name]] = transformOption(o2.nameOpt, transformName _)
          val r2: MOption[IS[Z, Pattern]] = transformISZ(o2.patterns, transformPattern _)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(idOpt = r0.getOrElse(o2.idOpt), nameOpt = r1.getOrElse(o2.nameOpt), patterns = r2.getOrElse(o2.patterns)))
          else
            MNone()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Pattern = r.getOrElse(o)
    val postR: MOption[Pattern] = pp.postPattern(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformExp(o: Exp): MOption[Exp] = {
    val preR: PreResult[Exp] = pp.preExp(o)
    val r: MOption[Exp] = if (preR.continue) {
      val o2: Exp = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Exp] = o2 match {
        case o2: Exp.LitB =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitC =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitZ =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitZ8 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitZ16 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitZ32 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitZ64 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitN =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitN8 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitN16 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitN32 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitN64 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitS8 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitS16 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitS32 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitS64 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitU8 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitU16 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitU32 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitU64 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitF32 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitF64 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitR =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitBv =>
          val r0: MOption[Type] = transformType(o2.tipe)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(tipe = r0.getOrElse(o2.tipe), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitString =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.StringInterpolate =>
          val r0: MOption[IS[Z, Exp.LitString]] = transformISZ(o2.lits, transformExpLitString _)
          val r1: MOption[IS[Z, Exp]] = transformISZ(o2.args, transformExp _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(lits = r0.getOrElse(o2.lits), args = r1.getOrElse(o2.args), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.This =>
          val r0: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Super =>
          val r0: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Unary =>
          val r0: MOption[Exp] = transformExp(o2.exp)
          val r1: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(exp = r0.getOrElse(o2.exp), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Binary =>
          val r0: MOption[Exp] = transformExp(o2.left)
          val r1: MOption[Exp] = transformExp(o2.right)
          val r2: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(left = r0.getOrElse(o2.left), right = r1.getOrElse(o2.right), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Ident =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Eta =>
          val r0: MOption[Exp] = transformExp(o2.exp)
          val r1: MOption[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(exp = r0.getOrElse(o2.exp), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Tuple =>
          val r0: MOption[IS[Z, Exp]] = transformISZ(o2.args, transformExp _)
          val r1: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(args = r0.getOrElse(o2.args), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Select =>
          val r0: MOption[Option[Exp]] = transformOption(o2.receiverOpt, transformExp _)
          val r1: MOption[Id] = transformId(o2.id)
          val r2: MOption[IS[Z, Type]] = transformISZ(o2.targs, transformType _)
          val r3: MOption[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(receiverOpt = r0.getOrElse(o2.receiverOpt), id = r1.getOrElse(o2.id), targs = r2.getOrElse(o2.targs), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Invoke =>
          val r0: MOption[Option[Exp]] = transformOption(o2.receiverOpt, transformExp _)
          val r1: MOption[Id] = transformId(o2.id)
          val r2: MOption[IS[Z, Type]] = transformISZ(o2.targs, transformType _)
          val r3: MOption[IS[Z, Exp]] = transformISZ(o2.args, transformExp _)
          val r4: MOption[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty || r4.nonEmpty)
            MSome(o2(receiverOpt = r0.getOrElse(o2.receiverOpt), id = r1.getOrElse(o2.id), targs = r2.getOrElse(o2.targs), args = r3.getOrElse(o2.args), attr = r4.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.InvokeNamed =>
          val r0: MOption[Option[Exp]] = transformOption(o2.receiverOpt, transformExp _)
          val r1: MOption[Id] = transformId(o2.id)
          val r2: MOption[IS[Z, Type]] = transformISZ(o2.targs, transformType _)
          val r3: MOption[IS[Z, NamedArg]] = transformISZ(o2.args, transformNamedArg _)
          val r4: MOption[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty || r4.nonEmpty)
            MSome(o2(receiverOpt = r0.getOrElse(o2.receiverOpt), id = r1.getOrElse(o2.id), targs = r2.getOrElse(o2.targs), args = r3.getOrElse(o2.args), attr = r4.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.If =>
          val r0: MOption[Exp] = transformExp(o2.cond)
          val r1: MOption[Exp] = transformExp(o2.thenExp)
          val r2: MOption[Exp] = transformExp(o2.elseExp)
          val r3: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(cond = r0.getOrElse(o2.cond), thenExp = r1.getOrElse(o2.thenExp), elseExp = r2.getOrElse(o2.elseExp), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Fun =>
          val r0: MOption[IS[Z, Param]] = transformISZ(o2.params, transformParam _)
          val r1: MOption[Exp] = transformExp(o2.exp)
          val r2: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(params = r0.getOrElse(o2.params), exp = r1.getOrElse(o2.exp), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.ForYield =>
          val r0: MOption[IS[Z, EnumGen.For]] = transformISZ(o2.enumGens, transformEnumGenFor _)
          val r1: MOption[Exp] = transformExp(o2.exp)
          val r2: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(enumGens = r0.getOrElse(o2.enumGens), exp = r1.getOrElse(o2.exp), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Quant =>
          val r0: MOption[IS[Z, VarFragment]] = transformISZ(o2.varFragments, transformVarFragment _)
          val r1: MOption[Exp] = transformExp(o2.exp)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(varFragments = r0.getOrElse(o2.varFragments), exp = r1.getOrElse(o2.exp), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Exp = r.getOrElse(o)
    val postR: MOption[Exp] = pp.postExp(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformNamedArg(o: NamedArg): MOption[NamedArg] = {
    val preR: PreResult[NamedArg] = pp.preNamedArg(o)
    val r: MOption[NamedArg] = if (preR.continue) {
      val o2: NamedArg = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[Exp] = transformExp(o2.arg)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty)
        MSome(o2(id = r0.getOrElse(o2.id), arg = r1.getOrElse(o2.arg)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: NamedArg = r.getOrElse(o)
    val postR: MOption[NamedArg] = pp.postNamedArg(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformVarFragment(o: VarFragment): MOption[VarFragment] = {
    val preR: PreResult[VarFragment] = pp.preVarFragment(o)
    val r: MOption[VarFragment] = if (preR.continue) {
      val o2: VarFragment = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Id]] = transformISZ(o2.ids, transformId _)
      val r1: MOption[Option[Domain]] = transformOption(o2.domainOpt, transformDomain _)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty)
        MSome(o2(ids = r0.getOrElse(o2.ids), domainOpt = r1.getOrElse(o2.domainOpt)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: VarFragment = r.getOrElse(o)
    val postR: MOption[VarFragment] = pp.postVarFragment(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformDomain(o: Domain): MOption[Domain] = {
    val preR: PreResult[Domain] = pp.preDomain(o)
    val r: MOption[Domain] = if (preR.continue) {
      val o2: Domain = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Domain] = o2 match {
        case o2: Domain.Type =>
          val r0: MOption[Type] = transformType(o2.tipe)
          val r1: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(tipe = r0.getOrElse(o2.tipe), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Domain.Range =>
          val r0: MOption[Exp] = transformExp(o2.lo)
          val r1: MOption[Exp] = transformExp(o2.hi)
          val r2: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(lo = r0.getOrElse(o2.lo), hi = r1.getOrElse(o2.hi), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Domain = r.getOrElse(o)
    val postR: MOption[Domain] = pp.postDomain(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformId(o: Id): MOption[Id] = {
    val preR: PreResult[Id] = pp.preId(o)
    val r: MOption[Id] = if (preR.continue) {
      val o2: Id = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Attr] = transformAttr(o2.attr)
      if (hasChanged || r0.nonEmpty)
        MSome(o2(attr = r0.getOrElse(o2.attr)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Id = r.getOrElse(o)
    val postR: MOption[Id] = pp.postId(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformName(o: Name): MOption[Name] = {
    val preR: PreResult[Name] = pp.preName(o)
    val r: MOption[Name] = if (preR.continue) {
      val o2: Name = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Id]] = transformISZ(o2.ids, transformId _)
      val r1: MOption[Attr] = transformAttr(o2.attr)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty)
        MSome(o2(ids = r0.getOrElse(o2.ids), attr = r1.getOrElse(o2.attr)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Name = r.getOrElse(o)
    val postR: MOption[Name] = pp.postName(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformBody(o: Body): MOption[Body] = {
    val preR: PreResult[Body] = pp.preBody(o)
    val r: MOption[Body] = if (preR.continue) {
      val o2: Body = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Stmt]] = transformISZ(o2.stmts, transformStmt _)
      if (hasChanged || r0.nonEmpty)
        MSome(o2(stmts = r0.getOrElse(o2.stmts)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Body = r.getOrElse(o)
    val postR: MOption[Body] = pp.postBody(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformAbstractDatatypeParam(o: AbstractDatatypeParam): MOption[AbstractDatatypeParam] = {
    val preR: PreResult[AbstractDatatypeParam] = pp.preAbstractDatatypeParam(o)
    val r: MOption[AbstractDatatypeParam] = if (preR.continue) {
      val o2: AbstractDatatypeParam = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[Type] = transformType(o2.tipe)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty)
        MSome(o2(id = r0.getOrElse(o2.id), tipe = r1.getOrElse(o2.tipe)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: AbstractDatatypeParam = r.getOrElse(o)
    val postR: MOption[AbstractDatatypeParam] = pp.postAbstractDatatypeParam(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformMethodSig(o: MethodSig): MOption[MethodSig] = {
    val preR: PreResult[MethodSig] = pp.preMethodSig(o)
    val r: MOption[MethodSig] = if (preR.continue) {
      val o2: MethodSig = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[IS[Z, TypeParam]] = transformISZ(o2.typeParams, transformTypeParam _)
      val r2: MOption[Type] = transformType(o2.returnType)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
        MSome(o2(id = r0.getOrElse(o2.id), typeParams = r1.getOrElse(o2.typeParams), returnType = r2.getOrElse(o2.returnType)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: MethodSig = r.getOrElse(o)
    val postR: MOption[MethodSig] = pp.postMethodSig(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformParam(o: Param): MOption[Param] = {
    val preR: PreResult[Param] = pp.preParam(o)
    val r: MOption[Param] = if (preR.continue) {
      val o2: Param = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[Type] = transformType(o2.tipe)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty)
        MSome(o2(id = r0.getOrElse(o2.id), tipe = r1.getOrElse(o2.tipe)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Param = r.getOrElse(o)
    val postR: MOption[Param] = pp.postParam(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformTypeParam(o: TypeParam): MOption[TypeParam] = {
    val preR: PreResult[TypeParam] = pp.preTypeParam(o)
    val r: MOption[TypeParam] = if (preR.continue) {
      val o2: TypeParam = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[Option[Type]] = transformOption(o2.superTypeOpt, transformType _)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty)
        MSome(o2(id = r0.getOrElse(o2.id), superTypeOpt = r1.getOrElse(o2.superTypeOpt)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: TypeParam = r.getOrElse(o)
    val postR: MOption[TypeParam] = pp.postTypeParam(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformContract(o: Contract): MOption[Contract] = {
    val preR: PreResult[Contract] = pp.preContract(o)
    val r: MOption[Contract] = if (preR.continue) {
      val o2: Contract = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Exp]] = transformISZ(o2.reads, transformExp _)
      val r1: MOption[IS[Z, ContractExp]] = transformISZ(o2.requires, transformContractExp _)
      val r2: MOption[IS[Z, Exp]] = transformISZ(o2.modifies, transformExp _)
      val r3: MOption[IS[Z, ContractExp]] = transformISZ(o2.ensures, transformContractExp _)
      val r4: MOption[IS[Z, SubContract]] = transformISZ(o2.subs, transformSubContract _)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty || r4.nonEmpty)
        MSome(o2(reads = r0.getOrElse(o2.reads), requires = r1.getOrElse(o2.requires), modifies = r2.getOrElse(o2.modifies), ensures = r3.getOrElse(o2.ensures), subs = r4.getOrElse(o2.subs)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Contract = r.getOrElse(o)
    val postR: MOption[Contract] = pp.postContract(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformSubContract(o: SubContract): MOption[SubContract] = {
    val preR: PreResult[SubContract] = pp.preSubContract(o)
    val r: MOption[SubContract] = if (preR.continue) {
      val o2: SubContract = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[IS[Z, SubContractParam]] = transformISZ(o2.params, transformSubContractParam _)
      val r2: MOption[Contract] = transformContract(o2.contract)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
        MSome(o2(id = r0.getOrElse(o2.id), params = r1.getOrElse(o2.params), contract = r2.getOrElse(o2.contract)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: SubContract = r.getOrElse(o)
    val postR: MOption[SubContract] = pp.postSubContract(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformSubContractParam(o: SubContractParam): MOption[SubContractParam] = {
    val preR: PreResult[SubContractParam] = pp.preSubContractParam(o)
    val r: MOption[SubContractParam] = if (preR.continue) {
      val o2: SubContractParam = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      if (hasChanged || r0.nonEmpty)
        MSome(o2(id = r0.getOrElse(o2.id)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: SubContractParam = r.getOrElse(o)
    val postR: MOption[SubContractParam] = pp.postSubContractParam(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformWhereDef(o: WhereDef): MOption[WhereDef] = {
    val preR: PreResult[WhereDef] = pp.preWhereDef(o)
    val r: MOption[WhereDef] = if (preR.continue) {
      val o2: WhereDef = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[WhereDef] = o2 match {
        case o2: WhereDef.Val =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[Type] = transformType(o2.tipe)
          val r2: MOption[Exp] = transformExp(o2.exp)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), tipe = r1.getOrElse(o2.tipe), exp = r2.getOrElse(o2.exp)))
          else
            MNone()
        case o2: WhereDef.Def =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[IS[Z, Param]] = transformISZ(o2.params, transformParam _)
          val r2: MOption[Type] = transformType(o2.rTipe)
          val r3: MOption[IS[Z, SpecDef]] = transformISZ(o2.defs, transformSpecDef _)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), params = r1.getOrElse(o2.params), rTipe = r2.getOrElse(o2.rTipe), defs = r3.getOrElse(o2.defs)))
          else
            MNone()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: WhereDef = r.getOrElse(o)
    val postR: MOption[WhereDef] = pp.postWhereDef(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformSpecDef(o: SpecDef): MOption[SpecDef] = {
    val preR: PreResult[SpecDef] = pp.preSpecDef(o)
    val r: MOption[SpecDef] = if (preR.continue) {
      val o2: SpecDef = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Option[Id]] = transformOption(o2.idOpt, transformId _)
      val r1: MOption[Exp] = transformExp(o2.exp)
      val r2: MOption[Option[Pattern]] = transformOption(o2.patternOpt, transformPattern _)
      val r3: MOption[Option[Exp]] = transformOption(o2.guardOpt, transformExp _)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
        MSome(o2(idOpt = r0.getOrElse(o2.idOpt), exp = r1.getOrElse(o2.exp), patternOpt = r2.getOrElse(o2.patternOpt), guardOpt = r3.getOrElse(o2.guardOpt)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: SpecDef = r.getOrElse(o)
    val postR: MOption[SpecDef] = pp.postSpecDef(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformProofStep(o: ProofStep): MOption[ProofStep] = {
    val preR: PreResult[ProofStep] = pp.preProofStep(o)
    val r: MOption[ProofStep] = if (preR.continue) {
      val o2: ProofStep = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[ProofStep] = o2 match {
        case o2: ProofStep.Basic =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: MOption[Exp] = transformExp(o2.exp)
          val r2: MOption[Just] = transformJust(o2.just)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(step = r0.getOrElse(o2.step), exp = r1.getOrElse(o2.exp), just = r2.getOrElse(o2.just)))
          else
            MNone()
        case o2: ProofStep.SubProof =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: MOption[AssumeProofStep] = transformAssumeProofStep(o2.assumeStep)
          val r2: MOption[IS[Z, ProofStep]] = transformISZ(o2.steps, transformProofStep _)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(step = r0.getOrElse(o2.step), assumeStep = r1.getOrElse(o2.assumeStep), steps = r2.getOrElse(o2.steps)))
          else
            MNone()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: ProofStep = r.getOrElse(o)
    val postR: MOption[ProofStep] = pp.postProofStep(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformAssumeProofStep(o: AssumeProofStep): MOption[AssumeProofStep] = {
    val preR: PreResult[AssumeProofStep] = pp.preAssumeProofStep(o)
    val r: MOption[AssumeProofStep] = if (preR.continue) {
      val o2: AssumeProofStep = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[AssumeProofStep] = o2 match {
        case o2: AssumeProofStep.Regular =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: MOption[Exp] = transformExp(o2.exp)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(step = r0.getOrElse(o2.step), exp = r1.getOrElse(o2.exp)))
          else
            MNone()
        case o2: AssumeProofStep.ForallIntroAps =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: MOption[IS[Z, VarFragment]] = transformISZ(o2.varFragments, transformVarFragment _)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(step = r0.getOrElse(o2.step), varFragments = r1.getOrElse(o2.varFragments)))
          else
            MNone()
        case o2: AssumeProofStep.ExistsElimAps =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: MOption[IS[Z, VarFragment]] = transformISZ(o2.varFragments, transformVarFragment _)
          val r2: MOption[Exp] = transformExp(o2.exp)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(step = r0.getOrElse(o2.step), varFragments = r1.getOrElse(o2.varFragments), exp = r2.getOrElse(o2.exp)))
          else
            MNone()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: AssumeProofStep = r.getOrElse(o)
    val postR: MOption[AssumeProofStep] = pp.postAssumeProofStep(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformJust(o: Just): MOption[Just] = {
    val preR: PreResult[Just] = pp.preJust(o)
    val r: MOption[Just] = if (preR.continue) {
      val o2: Just = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Just] = o2 match {
        case o2: Just.Premise =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.AndIntro =>
          val r0: MOption[IS[Z, Exp.LitZ]] = transformISZ(o2.steps, transformExpLitZ _)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(steps = r0.getOrElse(o2.steps), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.AndElim =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.andStep)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(andStep = r0.getOrElse(o2.andStep), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.OrIntro =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(step = r0.getOrElse(o2.step), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.OrElim =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.orStep)
          val r1: MOption[IS[Z, Exp.LitZ]] = transformISZ(o2.subProofSteps, transformExpLitZ _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(orStep = r0.getOrElse(o2.orStep), subProofSteps = r1.getOrElse(o2.subProofSteps), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.ImplyIntro =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.subProofStep)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(subProofStep = r0.getOrElse(o2.subProofStep), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.ImplyElim =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.implyStep)
          val r1: MOption[IS[Z, Exp.LitZ]] = transformISZ(o2.steps, transformExpLitZ _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(implyStep = r0.getOrElse(o2.implyStep), steps = r1.getOrElse(o2.steps), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.NegIntro =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.subProofStep)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(subProofStep = r0.getOrElse(o2.subProofStep), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.NegElim =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: MOption[Exp.LitZ] = transformExpLitZ(o2.negStep)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(step = r0.getOrElse(o2.step), negStep = r1.getOrElse(o2.negStep), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.BottomElim =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.subProofStep)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(subProofStep = r0.getOrElse(o2.subProofStep), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.Pbc =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.subProofStep)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(subProofStep = r0.getOrElse(o2.subProofStep), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.ForallIntro =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.subProofStep)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(subProofStep = r0.getOrElse(o2.subProofStep), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.ForallElim =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.forallStep)
          val r1: MOption[IS[Z, Exp]] = transformISZ(o2.args, transformExp _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(forallStep = r0.getOrElse(o2.forallStep), args = r1.getOrElse(o2.args), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.ExistsIntro =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.existsStep)
          val r1: MOption[IS[Z, Exp]] = transformISZ(o2.args, transformExp _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(existsStep = r0.getOrElse(o2.existsStep), args = r1.getOrElse(o2.args), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.ExistsElim =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.existsStep)
          val r1: MOption[Exp.LitZ] = transformExpLitZ(o2.subProofStep)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(existsStep = r0.getOrElse(o2.existsStep), subProofStep = r1.getOrElse(o2.subProofStep), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.Fact =>
          val r0: MOption[Name] = transformName(o2.name)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(name = r0.getOrElse(o2.name), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.Invariant =>
          val r0: MOption[Option[Name]] = transformOption(o2.nameOpt, transformName _)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(nameOpt = r0.getOrElse(o2.nameOpt), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.Subst =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.eqStep)
          val r1: MOption[Exp.LitZ] = transformExpLitZ(o2.step)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(eqStep = r0.getOrElse(o2.eqStep), step = r1.getOrElse(o2.step), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.Auto =>
          val r0: MOption[IS[Z, Exp.LitZ]] = transformISZ(o2.steps, transformExpLitZ _)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(steps = r0.getOrElse(o2.steps), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.Coq =>
          val r0: MOption[Exp.LitString] = transformExpLitString(o2.path)
          val r1: MOption[IS[Z, Exp.LitZ]] = transformISZ(o2.steps, transformExpLitZ _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(path = r0.getOrElse(o2.path), steps = r1.getOrElse(o2.steps), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Just = r.getOrElse(o)
    val postR: MOption[Just] = pp.postJust(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformTruthTableRow(o: TruthTable.Row): MOption[TruthTable.Row] = {
    val preR: PreResult[TruthTable.Row] = pp.preTruthTableRow(o)
    val r: MOption[TruthTable.Row] = if (preR.continue) {
      val o2: TruthTable.Row = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Exp.LitB]] = transformISZ(o2.assignment, transformExpLitB _)
      val r1: MOption[PosInfo] = transformPosInfo(o2.separator)
      val r2: MOption[IS[Z, Exp.LitB]] = transformISZ(o2.values, transformExpLitB _)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
        MSome(o2(assignment = r0.getOrElse(o2.assignment), separator = r1.getOrElse(o2.separator), values = r2.getOrElse(o2.values)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: TruthTable.Row = r.getOrElse(o)
    val postR: MOption[TruthTable.Row] = pp.postTruthTableRow(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformTruthTableConclusion(o: TruthTable.Conclusion): MOption[TruthTable.Conclusion] = {
    val preR: PreResult[TruthTable.Conclusion] = pp.preTruthTableConclusion(o)
    val r: MOption[TruthTable.Conclusion] = if (preR.continue) {
      val o2: TruthTable.Conclusion = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[TruthTable.Conclusion] = o2 match {
        case o2: TruthTable.Conclusion.Validity =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: TruthTable.Conclusion.Tautology =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: TruthTable.Conclusion.Contradictory =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: TruthTable.Conclusion.Contingent =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: TruthTable.Conclusion = r.getOrElse(o)
    val postR: MOption[TruthTable.Conclusion] = pp.postTruthTableConclusion(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformAttr(o: Attr): MOption[Attr] = {
    val preR: PreResult[Attr] = pp.preAttr(o)
    val r: MOption[Attr] = if (preR.continue) {
      val o2: Attr = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Option[PosInfo]] = transformOption(o2.posOpt, transformPosInfo _)
      if (hasChanged || r0.nonEmpty)
        MSome(o2(posOpt = r0.getOrElse(o2.posOpt)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Attr = r.getOrElse(o)
    val postR: MOption[Attr] = pp.postAttr(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformTypedAttr(o: TypedAttr): MOption[TypedAttr] = {
    val preR: PreResult[TypedAttr] = pp.preTypedAttr(o)
    val r: MOption[TypedAttr] = if (preR.continue) {
      val o2: TypedAttr = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Option[PosInfo]] = transformOption(o2.posOpt, transformPosInfo _)
      val r1: MOption[Option[Type]] = transformOption(o2.typeOpt, transformType _)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty)
        MSome(o2(posOpt = r0.getOrElse(o2.posOpt), typeOpt = r1.getOrElse(o2.typeOpt)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: TypedAttr = r.getOrElse(o)
    val postR: MOption[TypedAttr] = pp.postTypedAttr(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformResolvedAttr(o: ResolvedAttr): MOption[ResolvedAttr] = {
    val preR: PreResult[ResolvedAttr] = pp.preResolvedAttr(o)
    val r: MOption[ResolvedAttr] = if (preR.continue) {
      val o2: ResolvedAttr = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Option[PosInfo]] = transformOption(o2.posOpt, transformPosInfo _)
      val r1: MOption[Option[ResolvedInfo]] = transformOption(o2.resOpt, transformResolvedInfo _)
      val r2: MOption[Option[Type]] = transformOption(o2.typeOpt, transformType _)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
        MSome(o2(posOpt = r0.getOrElse(o2.posOpt), resOpt = r1.getOrElse(o2.resOpt), typeOpt = r2.getOrElse(o2.typeOpt)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: ResolvedAttr = r.getOrElse(o)
    val postR: MOption[ResolvedAttr] = pp.postResolvedAttr(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformResolvedInfo(o: ResolvedInfo): MOption[ResolvedInfo] = {
    val preR: PreResult[ResolvedInfo] = pp.preResolvedInfo(o)
    val r: MOption[ResolvedInfo] = if (preR.continue) {
      val o2: ResolvedInfo = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      if (hasChanged)
        MSome(o2)
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: ResolvedInfo = r.getOrElse(o)
    val postR: MOption[ResolvedInfo] = pp.postResolvedInfo(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformPosInfo(o: PosInfo): MOption[PosInfo] = {
    val preR: PreResult[PosInfo] = pp.prePosInfo(o)
    val r: MOption[PosInfo] = if (preR.continue) {
      val o2: PosInfo = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      if (hasChanged)
        MSome(o2)
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: PosInfo = r.getOrElse(o)
    val postR: MOption[PosInfo] = pp.postPosInfo(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformLClauseProof(o: LClause.Proof): MOption[LClause.Proof] = {
    val preR: PreResult[LClause.Proof] = pp.preLClauseProof(o) match {
     case PreResult(continue, MSome(r: LClause.Proof)) => PreResult(continue, MSome[LClause.Proof](r))
     case _ => assert(F); PreResult(F, MNone[LClause.Proof]())
   }
    val r: MOption[LClause.Proof] = if (preR.continue) {
      val o2: LClause.Proof = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, ProofStep]] = transformISZ(o2.steps, transformProofStep _)
      if (hasChanged || r0.nonEmpty)
        MSome(o2(steps = r0.getOrElse(o2.steps)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: LClause.Proof = r.getOrElse(o)
    val postR: MOption[LClause.Proof] = pp.postLClauseProof(o2) match {
     case MSome(result: LClause.Proof) => MSome[LClause.Proof](result)
     case _ => assert(F); MNone[LClause.Proof]()
   }
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformLClauseSequent(o: LClause.Sequent): MOption[LClause.Sequent] = {
    val preR: PreResult[LClause.Sequent] = pp.preLClauseSequent(o) match {
     case PreResult(continue, MSome(r: LClause.Sequent)) => PreResult(continue, MSome[LClause.Sequent](r))
     case _ => assert(F); PreResult(F, MNone[LClause.Sequent]())
   }
    val r: MOption[LClause.Sequent] = if (preR.continue) {
      val o2: LClause.Sequent = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Exp]] = transformISZ(o2.premises, transformExp _)
      val r1: MOption[IS[Z, Exp]] = transformISZ(o2.conclusions, transformExp _)
      val r2: MOption[Option[LClause.Proof]] = transformOption(o2.proofOpt, transformLClauseProof _)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
        MSome(o2(premises = r0.getOrElse(o2.premises), conclusions = r1.getOrElse(o2.conclusions), proofOpt = r2.getOrElse(o2.proofOpt)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: LClause.Sequent = r.getOrElse(o)
    val postR: MOption[LClause.Sequent] = pp.postLClauseSequent(o2) match {
     case MSome(result: LClause.Sequent) => MSome[LClause.Sequent](result)
     case _ => assert(F); MNone[LClause.Sequent]()
   }
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformTypeNamed(o: Type.Named): MOption[Type.Named] = {
    val preR: PreResult[Type.Named] = pp.preTypeNamed(o) match {
     case PreResult(continue, MSome(r: Type.Named)) => PreResult(continue, MSome[Type.Named](r))
     case _ => assert(F); PreResult(F, MNone[Type.Named]())
   }
    val r: MOption[Type.Named] = if (preR.continue) {
      val o2: Type.Named = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Name] = transformName(o2.name)
      val r1: MOption[IS[Z, Type]] = transformISZ(o2.typeArgs, transformType _)
      val r2: MOption[TypedAttr] = transformTypedAttr(o2.attr)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
        MSome(o2(name = r0.getOrElse(o2.name), typeArgs = r1.getOrElse(o2.typeArgs), attr = r2.getOrElse(o2.attr)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Type.Named = r.getOrElse(o)
    val postR: MOption[Type.Named] = pp.postTypeNamed(o2) match {
     case MSome(result: Type.Named) => MSome[Type.Named](result)
     case _ => assert(F); MNone[Type.Named]()
   }
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformExpLitString(o: Exp.LitString): MOption[Exp.LitString] = {
    val preR: PreResult[Exp.LitString] = pp.preExpLitString(o) match {
     case PreResult(continue, MSome(r: Exp.LitString)) => PreResult(continue, MSome[Exp.LitString](r))
     case _ => assert(F); PreResult(F, MNone[Exp.LitString]())
   }
    val r: MOption[Exp.LitString] = if (preR.continue) {
      val o2: Exp.LitString = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Attr] = transformAttr(o2.attr)
      if (hasChanged || r0.nonEmpty)
        MSome(o2(attr = r0.getOrElse(o2.attr)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Exp.LitString = r.getOrElse(o)
    val postR: MOption[Exp.LitString] = pp.postExpLitString(o2) match {
     case MSome(result: Exp.LitString) => MSome[Exp.LitString](result)
     case _ => assert(F); MNone[Exp.LitString]()
   }
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformExpLitZ(o: Exp.LitZ): MOption[Exp.LitZ] = {
    val preR: PreResult[Exp.LitZ] = pp.preExpLitZ(o) match {
     case PreResult(continue, MSome(r: Exp.LitZ)) => PreResult(continue, MSome[Exp.LitZ](r))
     case _ => assert(F); PreResult(F, MNone[Exp.LitZ]())
   }
    val r: MOption[Exp.LitZ] = if (preR.continue) {
      val o2: Exp.LitZ = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Attr] = transformAttr(o2.attr)
      if (hasChanged || r0.nonEmpty)
        MSome(o2(attr = r0.getOrElse(o2.attr)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Exp.LitZ = r.getOrElse(o)
    val postR: MOption[Exp.LitZ] = pp.postExpLitZ(o2) match {
     case MSome(result: Exp.LitZ) => MSome[Exp.LitZ](result)
     case _ => assert(F); MNone[Exp.LitZ]()
   }
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformExpLitB(o: Exp.LitB): MOption[Exp.LitB] = {
    val preR: PreResult[Exp.LitB] = pp.preExpLitB(o) match {
     case PreResult(continue, MSome(r: Exp.LitB)) => PreResult(continue, MSome[Exp.LitB](r))
     case _ => assert(F); PreResult(F, MNone[Exp.LitB]())
   }
    val r: MOption[Exp.LitB] = if (preR.continue) {
      val o2: Exp.LitB = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Attr] = transformAttr(o2.attr)
      if (hasChanged || r0.nonEmpty)
        MSome(o2(attr = r0.getOrElse(o2.attr)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Exp.LitB = r.getOrElse(o)
    val postR: MOption[Exp.LitB] = pp.postExpLitB(o2) match {
     case MSome(result: Exp.LitB) => MSome[Exp.LitB](result)
     case _ => assert(F); MNone[Exp.LitB]()
   }
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

}