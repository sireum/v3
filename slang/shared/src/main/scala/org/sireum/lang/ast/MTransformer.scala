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

  @sig trait Pre {

    def transformTopUnit(o: TopUnit): PreResult[TopUnit] = {
      o match {
        case o: TopUnit.Program => return transformTopUnitProgram(o)
        case o: TopUnit.SequentUnit => return transformTopUnitSequentUnit(o)
        case o: TopUnit.TruthTableUnit => return transformTopUnitTruthTableUnit(o)
      }
    }

    def transformTopUnitProgram(o: TopUnit.Program): PreResult[TopUnit] = {
      return PreResult(T, MNone())
    }

    def transformTopUnitSequentUnit(o: TopUnit.SequentUnit): PreResult[TopUnit] = {
      return PreResult(T, MNone())
    }

    def transformTopUnitTruthTableUnit(o: TopUnit.TruthTableUnit): PreResult[TopUnit] = {
      return PreResult(T, MNone())
    }

    def transformStmt(o: Stmt): PreResult[Stmt] = {
      o match {
        case o: Stmt.Import => return transformStmtImport(o)
        case o: Stmt.Var => return transformStmtVar(o)
        case o: Stmt.VarPattern => return transformStmtVarPattern(o)
        case o: Stmt.SpecVar => return transformStmtSpecVar(o)
        case o: Stmt.Method => return transformStmtMethod(o)
        case o: Stmt.ExtMethod => return transformStmtExtMethod(o)
        case o: Stmt.SpecMethod => return transformStmtSpecMethod(o)
        case o: Stmt.Enum => return transformStmtEnum(o)
        case o: Stmt.Object => return transformStmtObject(o)
        case o: Stmt.Sig => return transformStmtSig(o)
        case o: Stmt.AbstractDatatype => return transformStmtAbstractDatatype(o)
        case o: Stmt.Rich => return transformStmtRich(o)
        case o: Stmt.TypeAlias => return transformStmtTypeAlias(o)
        case o: Stmt.Assign => return transformStmtAssign(o)
        case o: Stmt.AssignUp => return transformStmtAssignUp(o)
        case o: Stmt.AssignPattern => return transformStmtAssignPattern(o)
        case o: Stmt.Block => return transformStmtBlock(o)
        case o: Stmt.If => return transformStmtIf(o)
        case o: Stmt.Match => return transformStmtMatch(o)
        case o: Stmt.While => return transformStmtWhile(o)
        case o: Stmt.DoWhile => return transformStmtDoWhile(o)
        case o: Stmt.For => return transformStmtFor(o)
        case o: Stmt.Return => return transformStmtReturn(o)
        case o: Stmt.LStmt => return transformStmtLStmt(o)
        case o: Stmt.Expr => return transformStmtExpr(o)
      }
    }

    def transformStmtImport(o: Stmt.Import): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtImportImporter(o: Stmt.Import.Importer): PreResult[Stmt.Import.Importer] = {
      return PreResult(T, MNone())
    }

    def transformStmtImportSelector(o: Stmt.Import.Selector): PreResult[Stmt.Import.Selector] = {
      o match {
        case o: Stmt.Import.MultiSelector => return transformStmtImportMultiSelector(o)
        case o: Stmt.Import.WildcardSelector => return transformStmtImportWildcardSelector(o)
      }
    }

    def transformStmtImportMultiSelector(o: Stmt.Import.MultiSelector): PreResult[Stmt.Import.Selector] = {
      return PreResult(T, MNone())
    }

    def transformStmtImportWildcardSelector(o: Stmt.Import.WildcardSelector): PreResult[Stmt.Import.Selector] = {
      return PreResult(T, MNone())
    }

    def transformStmtImportNamedSelector(o: Stmt.Import.NamedSelector): PreResult[Stmt.Import.NamedSelector] = {
      return PreResult(T, MNone())
    }

    def transformStmtVar(o: Stmt.Var): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtVarPattern(o: Stmt.VarPattern): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtSpecVar(o: Stmt.SpecVar): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtMethod(o: Stmt.Method): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtExtMethod(o: Stmt.ExtMethod): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtSpecMethod(o: Stmt.SpecMethod): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtEnum(o: Stmt.Enum): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtObject(o: Stmt.Object): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtSig(o: Stmt.Sig): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtAbstractDatatype(o: Stmt.AbstractDatatype): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtRich(o: Stmt.Rich): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtTypeAlias(o: Stmt.TypeAlias): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtAssign(o: Stmt.Assign): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtAssignUp(o: Stmt.AssignUp): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtAssignPattern(o: Stmt.AssignPattern): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtBlock(o: Stmt.Block): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtIf(o: Stmt.If): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtMatch(o: Stmt.Match): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtWhile(o: Stmt.While): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtDoWhile(o: Stmt.DoWhile): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtFor(o: Stmt.For): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtReturn(o: Stmt.Return): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtLStmt(o: Stmt.LStmt): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformStmtExpr(o: Stmt.Expr): PreResult[Stmt] = {
      return PreResult(T, MNone())
    }

    def transformLClause(o: LClause): PreResult[LClause] = {
      o match {
        case o: LClause.Invariants => return transformLClauseInvariants(o)
        case o: LClause.Facts => return transformLClauseFacts(o)
        case o: LClause.Theorems => return transformLClauseTheorems(o)
        case o: LClause.Sequent => return transformLClauseSequent(o)
        case o: LClause.Proof => return transformLClauseProof(o)
      }
    }

    def transformLClauseInvariants(o: LClause.Invariants): PreResult[LClause] = {
      return PreResult(T, MNone())
    }

    def transformLClauseFacts(o: LClause.Facts): PreResult[LClause] = {
      return PreResult(T, MNone())
    }

    def transformLClauseFact(o: LClause.Fact): PreResult[LClause.Fact] = {
      return PreResult(T, MNone())
    }

    def transformLClauseTheorems(o: LClause.Theorems): PreResult[LClause] = {
      return PreResult(T, MNone())
    }

    def transformLClauseTheorem(o: LClause.Theorem): PreResult[LClause.Theorem] = {
      return PreResult(T, MNone())
    }

    def transformLClauseSequent(o: LClause.Sequent): PreResult[LClause] = {
      return PreResult(T, MNone())
    }

    def transformLClauseProof(o: LClause.Proof): PreResult[LClause] = {
      return PreResult(T, MNone())
    }

    def transformContractExp(o: ContractExp): PreResult[ContractExp] = {
      return PreResult(T, MNone())
    }

    def transformCase(o: Case): PreResult[Case] = {
      return PreResult(T, MNone())
    }

    def transformRange(o: Range): PreResult[Range] = {
      o match {
        case o: Range.Expr => return transformRangeExpr(o)
        case o: Range.Indices => return transformRangeIndices(o)
        case o: Range.Step => return transformRangeStep(o)
      }
    }

    def transformRangeExpr(o: Range.Expr): PreResult[Range] = {
      return PreResult(T, MNone())
    }

    def transformRangeIndices(o: Range.Indices): PreResult[Range] = {
      return PreResult(T, MNone())
    }

    def transformRangeStep(o: Range.Step): PreResult[Range] = {
      return PreResult(T, MNone())
    }

    def transformType(o: Type): PreResult[Type] = {
      o match {
        case o: Type.Named => return transformTypeNamed(o)
        case o: Type.Fun => return transformTypeFun(o)
        case o: Type.Tuple => return transformTypeTuple(o)
      }
    }

    def transformTypeNamed(o: Type.Named): PreResult[Type] = {
      return PreResult(T, MNone())
    }

    def transformTypeFun(o: Type.Fun): PreResult[Type] = {
      return PreResult(T, MNone())
    }

    def transformTypeTuple(o: Type.Tuple): PreResult[Type] = {
      return PreResult(T, MNone())
    }

    def transformPattern(o: Pattern): PreResult[Pattern] = {
      o match {
        case o: Pattern.Literal => return transformPatternLiteral(o)
        case o: Pattern.Ref => return transformPatternRef(o)
        case o: Pattern.Variable => return transformPatternVariable(o)
        case o: Pattern.Wildcard => return transformPatternWildcard(o)
        case o: Pattern.SeqWildcard => return transformPatternSeqWildcard(o)
        case o: Pattern.Structure => return transformPatternStructure(o)
      }
    }

    def transformPatternLiteral(o: Pattern.Literal): PreResult[Pattern] = {
      return PreResult(T, MNone())
    }

    def transformPatternRef(o: Pattern.Ref): PreResult[Pattern] = {
      return PreResult(T, MNone())
    }

    def transformPatternVariable(o: Pattern.Variable): PreResult[Pattern] = {
      return PreResult(T, MNone())
    }

    def transformPatternWildcard(o: Pattern.Wildcard): PreResult[Pattern] = {
      return PreResult(T, MNone())
    }

    def transformPatternSeqWildcard(o: Pattern.SeqWildcard): PreResult[Pattern] = {
      return PreResult(T, MNone())
    }

    def transformPatternStructure(o: Pattern.Structure): PreResult[Pattern] = {
      return PreResult(T, MNone())
    }

    def transformExp(o: Exp): PreResult[Exp] = {
      o match {
        case o: Exp.LitB => return transformExpLitB(o)
        case o: Exp.LitC => return transformExpLitC(o)
        case o: Exp.LitZ => return transformExpLitZ(o)
        case o: Exp.LitZ8 => return transformExpLitZ8(o)
        case o: Exp.LitZ16 => return transformExpLitZ16(o)
        case o: Exp.LitZ32 => return transformExpLitZ32(o)
        case o: Exp.LitZ64 => return transformExpLitZ64(o)
        case o: Exp.LitN => return transformExpLitN(o)
        case o: Exp.LitN8 => return transformExpLitN8(o)
        case o: Exp.LitN16 => return transformExpLitN16(o)
        case o: Exp.LitN32 => return transformExpLitN32(o)
        case o: Exp.LitN64 => return transformExpLitN64(o)
        case o: Exp.LitS8 => return transformExpLitS8(o)
        case o: Exp.LitS16 => return transformExpLitS16(o)
        case o: Exp.LitS32 => return transformExpLitS32(o)
        case o: Exp.LitS64 => return transformExpLitS64(o)
        case o: Exp.LitU8 => return transformExpLitU8(o)
        case o: Exp.LitU16 => return transformExpLitU16(o)
        case o: Exp.LitU32 => return transformExpLitU32(o)
        case o: Exp.LitU64 => return transformExpLitU64(o)
        case o: Exp.LitF32 => return transformExpLitF32(o)
        case o: Exp.LitF64 => return transformExpLitF64(o)
        case o: Exp.LitR => return transformExpLitR(o)
        case o: Exp.LitBv => return transformExpLitBv(o)
        case o: Exp.LitString => return transformExpLitString(o)
        case o: Exp.StringInterpolate => return transformExpStringInterpolate(o)
        case o: Exp.This => return transformExpThis(o)
        case o: Exp.Unary => return transformExpUnary(o)
        case o: Exp.Binary => return transformExpBinary(o)
        case o: Exp.Ident => return transformExpIdent(o)
        case o: Exp.Eta => return transformExpEta(o)
        case o: Exp.Tuple => return transformExpTuple(o)
        case o: Exp.Select => return transformExpSelect(o)
        case o: Exp.Invoke => return transformExpInvoke(o)
        case o: Exp.InvokeNamed => return transformExpInvokeNamed(o)
        case o: Exp.If => return transformExpIf(o)
        case o: Exp.Quant => return transformExpQuant(o)
      }
    }

    def transformExpLitB(o: Exp.LitB): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitC(o: Exp.LitC): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitZ(o: Exp.LitZ): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitZ8(o: Exp.LitZ8): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitZ16(o: Exp.LitZ16): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitZ32(o: Exp.LitZ32): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitZ64(o: Exp.LitZ64): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitN(o: Exp.LitN): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitN8(o: Exp.LitN8): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitN16(o: Exp.LitN16): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitN32(o: Exp.LitN32): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitN64(o: Exp.LitN64): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitS8(o: Exp.LitS8): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitS16(o: Exp.LitS16): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitS32(o: Exp.LitS32): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitS64(o: Exp.LitS64): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitU8(o: Exp.LitU8): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitU16(o: Exp.LitU16): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitU32(o: Exp.LitU32): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitU64(o: Exp.LitU64): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitF32(o: Exp.LitF32): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitF64(o: Exp.LitF64): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitR(o: Exp.LitR): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitBv(o: Exp.LitBv): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpLitString(o: Exp.LitString): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpStringInterpolate(o: Exp.StringInterpolate): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpThis(o: Exp.This): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpUnary(o: Exp.Unary): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpBinary(o: Exp.Binary): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpIdent(o: Exp.Ident): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpEta(o: Exp.Eta): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpTuple(o: Exp.Tuple): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpSelect(o: Exp.Select): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpInvoke(o: Exp.Invoke): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpInvokeNamed(o: Exp.InvokeNamed): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpIf(o: Exp.If): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformExpQuant(o: Exp.Quant): PreResult[Exp] = {
      return PreResult(T, MNone())
    }

    def transformNamedArg(o: NamedArg): PreResult[NamedArg] = {
      return PreResult(T, MNone())
    }

    def transformVarFragment(o: VarFragment): PreResult[VarFragment] = {
      return PreResult(T, MNone())
    }

    def transformDomain(o: Domain): PreResult[Domain] = {
      o match {
        case o: Domain.Type => return transformDomainType(o)
        case o: Domain.Range => return transformDomainRange(o)
      }
    }

    def transformDomainType(o: Domain.Type): PreResult[Domain] = {
      return PreResult(T, MNone())
    }

    def transformDomainRange(o: Domain.Range): PreResult[Domain] = {
      return PreResult(T, MNone())
    }

    def transformId(o: Id): PreResult[Id] = {
      return PreResult(T, MNone())
    }

    def transformName(o: Name): PreResult[Name] = {
      return PreResult(T, MNone())
    }

    def transformBody(o: Body): PreResult[Body] = {
      return PreResult(T, MNone())
    }

    def transformAbstractDatatypeParam(o: AbstractDatatypeParam): PreResult[AbstractDatatypeParam] = {
      return PreResult(T, MNone())
    }

    def transformMethodSig(o: MethodSig): PreResult[MethodSig] = {
      return PreResult(T, MNone())
    }

    def transformParam(o: Param): PreResult[Param] = {
      return PreResult(T, MNone())
    }

    def transformTypeParam(o: TypeParam): PreResult[TypeParam] = {
      return PreResult(T, MNone())
    }

    def transformContract(o: Contract): PreResult[Contract] = {
      return PreResult(T, MNone())
    }

    def transformSubContract(o: SubContract): PreResult[SubContract] = {
      return PreResult(T, MNone())
    }

    def transformSubContractParam(o: SubContractParam): PreResult[SubContractParam] = {
      return PreResult(T, MNone())
    }

    def transformWhereDef(o: WhereDef): PreResult[WhereDef] = {
      o match {
        case o: WhereDef.Val => return transformWhereDefVal(o)
        case o: WhereDef.Def => return transformWhereDefDef(o)
      }
    }

    def transformWhereDefVal(o: WhereDef.Val): PreResult[WhereDef] = {
      return PreResult(T, MNone())
    }

    def transformWhereDefDef(o: WhereDef.Def): PreResult[WhereDef] = {
      return PreResult(T, MNone())
    }

    def transformSpecDef(o: SpecDef): PreResult[SpecDef] = {
      return PreResult(T, MNone())
    }

    def transformProofStep(o: ProofStep): PreResult[ProofStep] = {
      o match {
        case o: ProofStep.Basic => return transformProofStepBasic(o)
        case o: ProofStep.SubProof => return transformProofStepSubProof(o)
      }
    }

    def transformProofStepBasic(o: ProofStep.Basic): PreResult[ProofStep] = {
      return PreResult(T, MNone())
    }

    def transformProofStepSubProof(o: ProofStep.SubProof): PreResult[ProofStep] = {
      return PreResult(T, MNone())
    }

    def transformAssumeProofStep(o: AssumeProofStep): PreResult[AssumeProofStep] = {
      o match {
        case o: AssumeProofStep.Regular => return transformAssumeProofStepRegular(o)
        case o: AssumeProofStep.ForallIntroAps => return transformAssumeProofStepForallIntroAps(o)
        case o: AssumeProofStep.ExistsElimAps => return transformAssumeProofStepExistsElimAps(o)
      }
    }

    def transformAssumeProofStepRegular(o: AssumeProofStep.Regular): PreResult[AssumeProofStep] = {
      return PreResult(T, MNone())
    }

    def transformAssumeProofStepForallIntroAps(o: AssumeProofStep.ForallIntroAps): PreResult[AssumeProofStep] = {
      return PreResult(T, MNone())
    }

    def transformAssumeProofStepExistsElimAps(o: AssumeProofStep.ExistsElimAps): PreResult[AssumeProofStep] = {
      return PreResult(T, MNone())
    }

    def transformJust(o: Just): PreResult[Just] = {
      o match {
        case o: Just.Premise => return transformJustPremise(o)
        case o: Just.AndIntro => return transformJustAndIntro(o)
        case o: Just.AndElim => return transformJustAndElim(o)
        case o: Just.OrIntro => return transformJustOrIntro(o)
        case o: Just.OrElim => return transformJustOrElim(o)
        case o: Just.ImplyIntro => return transformJustImplyIntro(o)
        case o: Just.ImplyElim => return transformJustImplyElim(o)
        case o: Just.NegIntro => return transformJustNegIntro(o)
        case o: Just.NegElim => return transformJustNegElim(o)
        case o: Just.BottomElim => return transformJustBottomElim(o)
        case o: Just.Pbc => return transformJustPbc(o)
        case o: Just.ForallIntro => return transformJustForallIntro(o)
        case o: Just.ForallElim => return transformJustForallElim(o)
        case o: Just.ExistsIntro => return transformJustExistsIntro(o)
        case o: Just.ExistsElim => return transformJustExistsElim(o)
        case o: Just.Fact => return transformJustFact(o)
        case o: Just.Invariant => return transformJustInvariant(o)
        case o: Just.Subst => return transformJustSubst(o)
        case o: Just.Auto => return transformJustAuto(o)
        case o: Just.Coq => return transformJustCoq(o)
      }
    }

    def transformJustPremise(o: Just.Premise): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformJustAndIntro(o: Just.AndIntro): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformJustAndElim(o: Just.AndElim): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformJustOrIntro(o: Just.OrIntro): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformJustOrElim(o: Just.OrElim): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformJustImplyIntro(o: Just.ImplyIntro): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformJustImplyElim(o: Just.ImplyElim): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformJustNegIntro(o: Just.NegIntro): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformJustNegElim(o: Just.NegElim): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformJustBottomElim(o: Just.BottomElim): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformJustPbc(o: Just.Pbc): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformJustForallIntro(o: Just.ForallIntro): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformJustForallElim(o: Just.ForallElim): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformJustExistsIntro(o: Just.ExistsIntro): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformJustExistsElim(o: Just.ExistsElim): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformJustFact(o: Just.Fact): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformJustInvariant(o: Just.Invariant): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformJustSubst(o: Just.Subst): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformJustAuto(o: Just.Auto): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformJustCoq(o: Just.Coq): PreResult[Just] = {
      return PreResult(T, MNone())
    }

    def transformTruthTableRow(o: TruthTable.Row): PreResult[TruthTable.Row] = {
      return PreResult(T, MNone())
    }

    def transformTruthTableConclusion(o: TruthTable.Conclusion): PreResult[TruthTable.Conclusion] = {
      o match {
        case o: TruthTable.Conclusion.Validity => return transformTruthTableConclusionValidity(o)
        case o: TruthTable.Conclusion.Tautology => return transformTruthTableConclusionTautology(o)
        case o: TruthTable.Conclusion.Contradictory => return transformTruthTableConclusionContradictory(o)
        case o: TruthTable.Conclusion.Contingent => return transformTruthTableConclusionContingent(o)
      }
    }

    def transformTruthTableConclusionValidity(o: TruthTable.Conclusion.Validity): PreResult[TruthTable.Conclusion] = {
      return PreResult(T, MNone())
    }

    def transformTruthTableConclusionTautology(o: TruthTable.Conclusion.Tautology): PreResult[TruthTable.Conclusion] = {
      return PreResult(T, MNone())
    }

    def transformTruthTableConclusionContradictory(o: TruthTable.Conclusion.Contradictory): PreResult[TruthTable.Conclusion] = {
      return PreResult(T, MNone())
    }

    def transformTruthTableConclusionContingent(o: TruthTable.Conclusion.Contingent): PreResult[TruthTable.Conclusion] = {
      return PreResult(T, MNone())
    }

    def transformAttr(o: Attr): PreResult[Attr] = {
      return PreResult(T, MNone())
    }

    def transformTypedAttr(o: TypedAttr): PreResult[TypedAttr] = {
      return PreResult(T, MNone())
    }

    def transformResolvedAttr(o: ResolvedAttr): PreResult[ResolvedAttr] = {
      return PreResult(T, MNone())
    }

    def transformResolvedInfo(o: ResolvedInfo): PreResult[ResolvedInfo] = {
      return PreResult(T, MNone())
    }

    def transformPosInfo(o: PosInfo): PreResult[PosInfo] = {
      return PreResult(T, MNone())
    }

  }

  @sig trait Post {

    def transformTopUnit(o: TopUnit): MOption[TopUnit] = {
      o match {
        case o: TopUnit.Program => return transformTopUnitProgram(o)
        case o: TopUnit.SequentUnit => return transformTopUnitSequentUnit(o)
        case o: TopUnit.TruthTableUnit => return transformTopUnitTruthTableUnit(o)
      }
    }

    def transformTopUnitProgram(o: TopUnit.Program): MOption[TopUnit] = {
      return MNone()
    }

    def transformTopUnitSequentUnit(o: TopUnit.SequentUnit): MOption[TopUnit] = {
      return MNone()
    }

    def transformTopUnitTruthTableUnit(o: TopUnit.TruthTableUnit): MOption[TopUnit] = {
      return MNone()
    }

    def transformStmt(o: Stmt): MOption[Stmt] = {
      o match {
        case o: Stmt.Import => return transformStmtImport(o)
        case o: Stmt.Var => return transformStmtVar(o)
        case o: Stmt.VarPattern => return transformStmtVarPattern(o)
        case o: Stmt.SpecVar => return transformStmtSpecVar(o)
        case o: Stmt.Method => return transformStmtMethod(o)
        case o: Stmt.ExtMethod => return transformStmtExtMethod(o)
        case o: Stmt.SpecMethod => return transformStmtSpecMethod(o)
        case o: Stmt.Enum => return transformStmtEnum(o)
        case o: Stmt.Object => return transformStmtObject(o)
        case o: Stmt.Sig => return transformStmtSig(o)
        case o: Stmt.AbstractDatatype => return transformStmtAbstractDatatype(o)
        case o: Stmt.Rich => return transformStmtRich(o)
        case o: Stmt.TypeAlias => return transformStmtTypeAlias(o)
        case o: Stmt.Assign => return transformStmtAssign(o)
        case o: Stmt.AssignUp => return transformStmtAssignUp(o)
        case o: Stmt.AssignPattern => return transformStmtAssignPattern(o)
        case o: Stmt.Block => return transformStmtBlock(o)
        case o: Stmt.If => return transformStmtIf(o)
        case o: Stmt.Match => return transformStmtMatch(o)
        case o: Stmt.While => return transformStmtWhile(o)
        case o: Stmt.DoWhile => return transformStmtDoWhile(o)
        case o: Stmt.For => return transformStmtFor(o)
        case o: Stmt.Return => return transformStmtReturn(o)
        case o: Stmt.LStmt => return transformStmtLStmt(o)
        case o: Stmt.Expr => return transformStmtExpr(o)
      }
    }

    def transformStmtImport(o: Stmt.Import): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtImportImporter(o: Stmt.Import.Importer): MOption[Stmt.Import.Importer] = {
      return MNone()
    }

    def transformStmtImportSelector(o: Stmt.Import.Selector): MOption[Stmt.Import.Selector] = {
      o match {
        case o: Stmt.Import.MultiSelector => return transformStmtImportMultiSelector(o)
        case o: Stmt.Import.WildcardSelector => return transformStmtImportWildcardSelector(o)
      }
    }

    def transformStmtImportMultiSelector(o: Stmt.Import.MultiSelector): MOption[Stmt.Import.Selector] = {
      return MNone()
    }

    def transformStmtImportWildcardSelector(o: Stmt.Import.WildcardSelector): MOption[Stmt.Import.Selector] = {
      return MNone()
    }

    def transformStmtImportNamedSelector(o: Stmt.Import.NamedSelector): MOption[Stmt.Import.NamedSelector] = {
      return MNone()
    }

    def transformStmtVar(o: Stmt.Var): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtVarPattern(o: Stmt.VarPattern): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtSpecVar(o: Stmt.SpecVar): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtMethod(o: Stmt.Method): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtExtMethod(o: Stmt.ExtMethod): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtSpecMethod(o: Stmt.SpecMethod): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtEnum(o: Stmt.Enum): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtObject(o: Stmt.Object): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtSig(o: Stmt.Sig): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtAbstractDatatype(o: Stmt.AbstractDatatype): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtRich(o: Stmt.Rich): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtTypeAlias(o: Stmt.TypeAlias): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtAssign(o: Stmt.Assign): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtAssignUp(o: Stmt.AssignUp): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtAssignPattern(o: Stmt.AssignPattern): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtBlock(o: Stmt.Block): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtIf(o: Stmt.If): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtMatch(o: Stmt.Match): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtWhile(o: Stmt.While): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtDoWhile(o: Stmt.DoWhile): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtFor(o: Stmt.For): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtReturn(o: Stmt.Return): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtLStmt(o: Stmt.LStmt): MOption[Stmt] = {
      return MNone()
    }

    def transformStmtExpr(o: Stmt.Expr): MOption[Stmt] = {
      return MNone()
    }

    def transformLClause(o: LClause): MOption[LClause] = {
      o match {
        case o: LClause.Invariants => return transformLClauseInvariants(o)
        case o: LClause.Facts => return transformLClauseFacts(o)
        case o: LClause.Theorems => return transformLClauseTheorems(o)
        case o: LClause.Sequent => return transformLClauseSequent(o)
        case o: LClause.Proof => return transformLClauseProof(o)
      }
    }

    def transformLClauseInvariants(o: LClause.Invariants): MOption[LClause] = {
      return MNone()
    }

    def transformLClauseFacts(o: LClause.Facts): MOption[LClause] = {
      return MNone()
    }

    def transformLClauseFact(o: LClause.Fact): MOption[LClause.Fact] = {
      return MNone()
    }

    def transformLClauseTheorems(o: LClause.Theorems): MOption[LClause] = {
      return MNone()
    }

    def transformLClauseTheorem(o: LClause.Theorem): MOption[LClause.Theorem] = {
      return MNone()
    }

    def transformLClauseSequent(o: LClause.Sequent): MOption[LClause] = {
      return MNone()
    }

    def transformLClauseProof(o: LClause.Proof): MOption[LClause] = {
      return MNone()
    }

    def transformContractExp(o: ContractExp): MOption[ContractExp] = {
      return MNone()
    }

    def transformCase(o: Case): MOption[Case] = {
      return MNone()
    }

    def transformRange(o: Range): MOption[Range] = {
      o match {
        case o: Range.Expr => return transformRangeExpr(o)
        case o: Range.Indices => return transformRangeIndices(o)
        case o: Range.Step => return transformRangeStep(o)
      }
    }

    def transformRangeExpr(o: Range.Expr): MOption[Range] = {
      return MNone()
    }

    def transformRangeIndices(o: Range.Indices): MOption[Range] = {
      return MNone()
    }

    def transformRangeStep(o: Range.Step): MOption[Range] = {
      return MNone()
    }

    def transformType(o: Type): MOption[Type] = {
      o match {
        case o: Type.Named => return transformTypeNamed(o)
        case o: Type.Fun => return transformTypeFun(o)
        case o: Type.Tuple => return transformTypeTuple(o)
      }
    }

    def transformTypeNamed(o: Type.Named): MOption[Type] = {
      return MNone()
    }

    def transformTypeFun(o: Type.Fun): MOption[Type] = {
      return MNone()
    }

    def transformTypeTuple(o: Type.Tuple): MOption[Type] = {
      return MNone()
    }

    def transformPattern(o: Pattern): MOption[Pattern] = {
      o match {
        case o: Pattern.Literal => return transformPatternLiteral(o)
        case o: Pattern.Ref => return transformPatternRef(o)
        case o: Pattern.Variable => return transformPatternVariable(o)
        case o: Pattern.Wildcard => return transformPatternWildcard(o)
        case o: Pattern.SeqWildcard => return transformPatternSeqWildcard(o)
        case o: Pattern.Structure => return transformPatternStructure(o)
      }
    }

    def transformPatternLiteral(o: Pattern.Literal): MOption[Pattern] = {
      return MNone()
    }

    def transformPatternRef(o: Pattern.Ref): MOption[Pattern] = {
      return MNone()
    }

    def transformPatternVariable(o: Pattern.Variable): MOption[Pattern] = {
      return MNone()
    }

    def transformPatternWildcard(o: Pattern.Wildcard): MOption[Pattern] = {
      return MNone()
    }

    def transformPatternSeqWildcard(o: Pattern.SeqWildcard): MOption[Pattern] = {
      return MNone()
    }

    def transformPatternStructure(o: Pattern.Structure): MOption[Pattern] = {
      return MNone()
    }

    def transformExp(o: Exp): MOption[Exp] = {
      o match {
        case o: Exp.LitB => return transformExpLitB(o)
        case o: Exp.LitC => return transformExpLitC(o)
        case o: Exp.LitZ => return transformExpLitZ(o)
        case o: Exp.LitZ8 => return transformExpLitZ8(o)
        case o: Exp.LitZ16 => return transformExpLitZ16(o)
        case o: Exp.LitZ32 => return transformExpLitZ32(o)
        case o: Exp.LitZ64 => return transformExpLitZ64(o)
        case o: Exp.LitN => return transformExpLitN(o)
        case o: Exp.LitN8 => return transformExpLitN8(o)
        case o: Exp.LitN16 => return transformExpLitN16(o)
        case o: Exp.LitN32 => return transformExpLitN32(o)
        case o: Exp.LitN64 => return transformExpLitN64(o)
        case o: Exp.LitS8 => return transformExpLitS8(o)
        case o: Exp.LitS16 => return transformExpLitS16(o)
        case o: Exp.LitS32 => return transformExpLitS32(o)
        case o: Exp.LitS64 => return transformExpLitS64(o)
        case o: Exp.LitU8 => return transformExpLitU8(o)
        case o: Exp.LitU16 => return transformExpLitU16(o)
        case o: Exp.LitU32 => return transformExpLitU32(o)
        case o: Exp.LitU64 => return transformExpLitU64(o)
        case o: Exp.LitF32 => return transformExpLitF32(o)
        case o: Exp.LitF64 => return transformExpLitF64(o)
        case o: Exp.LitR => return transformExpLitR(o)
        case o: Exp.LitBv => return transformExpLitBv(o)
        case o: Exp.LitString => return transformExpLitString(o)
        case o: Exp.StringInterpolate => return transformExpStringInterpolate(o)
        case o: Exp.This => return transformExpThis(o)
        case o: Exp.Unary => return transformExpUnary(o)
        case o: Exp.Binary => return transformExpBinary(o)
        case o: Exp.Ident => return transformExpIdent(o)
        case o: Exp.Eta => return transformExpEta(o)
        case o: Exp.Tuple => return transformExpTuple(o)
        case o: Exp.Select => return transformExpSelect(o)
        case o: Exp.Invoke => return transformExpInvoke(o)
        case o: Exp.InvokeNamed => return transformExpInvokeNamed(o)
        case o: Exp.If => return transformExpIf(o)
        case o: Exp.Quant => return transformExpQuant(o)
      }
    }

    def transformExpLitB(o: Exp.LitB): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitC(o: Exp.LitC): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitZ(o: Exp.LitZ): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitZ8(o: Exp.LitZ8): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitZ16(o: Exp.LitZ16): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitZ32(o: Exp.LitZ32): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitZ64(o: Exp.LitZ64): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitN(o: Exp.LitN): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitN8(o: Exp.LitN8): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitN16(o: Exp.LitN16): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitN32(o: Exp.LitN32): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitN64(o: Exp.LitN64): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitS8(o: Exp.LitS8): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitS16(o: Exp.LitS16): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitS32(o: Exp.LitS32): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitS64(o: Exp.LitS64): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitU8(o: Exp.LitU8): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitU16(o: Exp.LitU16): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitU32(o: Exp.LitU32): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitU64(o: Exp.LitU64): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitF32(o: Exp.LitF32): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitF64(o: Exp.LitF64): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitR(o: Exp.LitR): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitBv(o: Exp.LitBv): MOption[Exp] = {
      return MNone()
    }

    def transformExpLitString(o: Exp.LitString): MOption[Exp] = {
      return MNone()
    }

    def transformExpStringInterpolate(o: Exp.StringInterpolate): MOption[Exp] = {
      return MNone()
    }

    def transformExpThis(o: Exp.This): MOption[Exp] = {
      return MNone()
    }

    def transformExpUnary(o: Exp.Unary): MOption[Exp] = {
      return MNone()
    }

    def transformExpBinary(o: Exp.Binary): MOption[Exp] = {
      return MNone()
    }

    def transformExpIdent(o: Exp.Ident): MOption[Exp] = {
      return MNone()
    }

    def transformExpEta(o: Exp.Eta): MOption[Exp] = {
      return MNone()
    }

    def transformExpTuple(o: Exp.Tuple): MOption[Exp] = {
      return MNone()
    }

    def transformExpSelect(o: Exp.Select): MOption[Exp] = {
      return MNone()
    }

    def transformExpInvoke(o: Exp.Invoke): MOption[Exp] = {
      return MNone()
    }

    def transformExpInvokeNamed(o: Exp.InvokeNamed): MOption[Exp] = {
      return MNone()
    }

    def transformExpIf(o: Exp.If): MOption[Exp] = {
      return MNone()
    }

    def transformExpQuant(o: Exp.Quant): MOption[Exp] = {
      return MNone()
    }

    def transformNamedArg(o: NamedArg): MOption[NamedArg] = {
      return MNone()
    }

    def transformVarFragment(o: VarFragment): MOption[VarFragment] = {
      return MNone()
    }

    def transformDomain(o: Domain): MOption[Domain] = {
      o match {
        case o: Domain.Type => return transformDomainType(o)
        case o: Domain.Range => return transformDomainRange(o)
      }
    }

    def transformDomainType(o: Domain.Type): MOption[Domain] = {
      return MNone()
    }

    def transformDomainRange(o: Domain.Range): MOption[Domain] = {
      return MNone()
    }

    def transformId(o: Id): MOption[Id] = {
      return MNone()
    }

    def transformName(o: Name): MOption[Name] = {
      return MNone()
    }

    def transformBody(o: Body): MOption[Body] = {
      return MNone()
    }

    def transformAbstractDatatypeParam(o: AbstractDatatypeParam): MOption[AbstractDatatypeParam] = {
      return MNone()
    }

    def transformMethodSig(o: MethodSig): MOption[MethodSig] = {
      return MNone()
    }

    def transformParam(o: Param): MOption[Param] = {
      return MNone()
    }

    def transformTypeParam(o: TypeParam): MOption[TypeParam] = {
      return MNone()
    }

    def transformContract(o: Contract): MOption[Contract] = {
      return MNone()
    }

    def transformSubContract(o: SubContract): MOption[SubContract] = {
      return MNone()
    }

    def transformSubContractParam(o: SubContractParam): MOption[SubContractParam] = {
      return MNone()
    }

    def transformWhereDef(o: WhereDef): MOption[WhereDef] = {
      o match {
        case o: WhereDef.Val => return transformWhereDefVal(o)
        case o: WhereDef.Def => return transformWhereDefDef(o)
      }
    }

    def transformWhereDefVal(o: WhereDef.Val): MOption[WhereDef] = {
      return MNone()
    }

    def transformWhereDefDef(o: WhereDef.Def): MOption[WhereDef] = {
      return MNone()
    }

    def transformSpecDef(o: SpecDef): MOption[SpecDef] = {
      return MNone()
    }

    def transformProofStep(o: ProofStep): MOption[ProofStep] = {
      o match {
        case o: ProofStep.Basic => return transformProofStepBasic(o)
        case o: ProofStep.SubProof => return transformProofStepSubProof(o)
      }
    }

    def transformProofStepBasic(o: ProofStep.Basic): MOption[ProofStep] = {
      return MNone()
    }

    def transformProofStepSubProof(o: ProofStep.SubProof): MOption[ProofStep] = {
      return MNone()
    }

    def transformAssumeProofStep(o: AssumeProofStep): MOption[AssumeProofStep] = {
      o match {
        case o: AssumeProofStep.Regular => return transformAssumeProofStepRegular(o)
        case o: AssumeProofStep.ForallIntroAps => return transformAssumeProofStepForallIntroAps(o)
        case o: AssumeProofStep.ExistsElimAps => return transformAssumeProofStepExistsElimAps(o)
      }
    }

    def transformAssumeProofStepRegular(o: AssumeProofStep.Regular): MOption[AssumeProofStep] = {
      return MNone()
    }

    def transformAssumeProofStepForallIntroAps(o: AssumeProofStep.ForallIntroAps): MOption[AssumeProofStep] = {
      return MNone()
    }

    def transformAssumeProofStepExistsElimAps(o: AssumeProofStep.ExistsElimAps): MOption[AssumeProofStep] = {
      return MNone()
    }

    def transformJust(o: Just): MOption[Just] = {
      o match {
        case o: Just.Premise => return transformJustPremise(o)
        case o: Just.AndIntro => return transformJustAndIntro(o)
        case o: Just.AndElim => return transformJustAndElim(o)
        case o: Just.OrIntro => return transformJustOrIntro(o)
        case o: Just.OrElim => return transformJustOrElim(o)
        case o: Just.ImplyIntro => return transformJustImplyIntro(o)
        case o: Just.ImplyElim => return transformJustImplyElim(o)
        case o: Just.NegIntro => return transformJustNegIntro(o)
        case o: Just.NegElim => return transformJustNegElim(o)
        case o: Just.BottomElim => return transformJustBottomElim(o)
        case o: Just.Pbc => return transformJustPbc(o)
        case o: Just.ForallIntro => return transformJustForallIntro(o)
        case o: Just.ForallElim => return transformJustForallElim(o)
        case o: Just.ExistsIntro => return transformJustExistsIntro(o)
        case o: Just.ExistsElim => return transformJustExistsElim(o)
        case o: Just.Fact => return transformJustFact(o)
        case o: Just.Invariant => return transformJustInvariant(o)
        case o: Just.Subst => return transformJustSubst(o)
        case o: Just.Auto => return transformJustAuto(o)
        case o: Just.Coq => return transformJustCoq(o)
      }
    }

    def transformJustPremise(o: Just.Premise): MOption[Just] = {
      return MNone()
    }

    def transformJustAndIntro(o: Just.AndIntro): MOption[Just] = {
      return MNone()
    }

    def transformJustAndElim(o: Just.AndElim): MOption[Just] = {
      return MNone()
    }

    def transformJustOrIntro(o: Just.OrIntro): MOption[Just] = {
      return MNone()
    }

    def transformJustOrElim(o: Just.OrElim): MOption[Just] = {
      return MNone()
    }

    def transformJustImplyIntro(o: Just.ImplyIntro): MOption[Just] = {
      return MNone()
    }

    def transformJustImplyElim(o: Just.ImplyElim): MOption[Just] = {
      return MNone()
    }

    def transformJustNegIntro(o: Just.NegIntro): MOption[Just] = {
      return MNone()
    }

    def transformJustNegElim(o: Just.NegElim): MOption[Just] = {
      return MNone()
    }

    def transformJustBottomElim(o: Just.BottomElim): MOption[Just] = {
      return MNone()
    }

    def transformJustPbc(o: Just.Pbc): MOption[Just] = {
      return MNone()
    }

    def transformJustForallIntro(o: Just.ForallIntro): MOption[Just] = {
      return MNone()
    }

    def transformJustForallElim(o: Just.ForallElim): MOption[Just] = {
      return MNone()
    }

    def transformJustExistsIntro(o: Just.ExistsIntro): MOption[Just] = {
      return MNone()
    }

    def transformJustExistsElim(o: Just.ExistsElim): MOption[Just] = {
      return MNone()
    }

    def transformJustFact(o: Just.Fact): MOption[Just] = {
      return MNone()
    }

    def transformJustInvariant(o: Just.Invariant): MOption[Just] = {
      return MNone()
    }

    def transformJustSubst(o: Just.Subst): MOption[Just] = {
      return MNone()
    }

    def transformJustAuto(o: Just.Auto): MOption[Just] = {
      return MNone()
    }

    def transformJustCoq(o: Just.Coq): MOption[Just] = {
      return MNone()
    }

    def transformTruthTableRow(o: TruthTable.Row): MOption[TruthTable.Row] = {
      return MNone()
    }

    def transformTruthTableConclusion(o: TruthTable.Conclusion): MOption[TruthTable.Conclusion] = {
      o match {
        case o: TruthTable.Conclusion.Validity => return transformTruthTableConclusionValidity(o)
        case o: TruthTable.Conclusion.Tautology => return transformTruthTableConclusionTautology(o)
        case o: TruthTable.Conclusion.Contradictory => return transformTruthTableConclusionContradictory(o)
        case o: TruthTable.Conclusion.Contingent => return transformTruthTableConclusionContingent(o)
      }
    }

    def transformTruthTableConclusionValidity(o: TruthTable.Conclusion.Validity): MOption[TruthTable.Conclusion] = {
      return MNone()
    }

    def transformTruthTableConclusionTautology(o: TruthTable.Conclusion.Tautology): MOption[TruthTable.Conclusion] = {
      return MNone()
    }

    def transformTruthTableConclusionContradictory(o: TruthTable.Conclusion.Contradictory): MOption[TruthTable.Conclusion] = {
      return MNone()
    }

    def transformTruthTableConclusionContingent(o: TruthTable.Conclusion.Contingent): MOption[TruthTable.Conclusion] = {
      return MNone()
    }

    def transformAttr(o: Attr): MOption[Attr] = {
      return MNone()
    }

    def transformTypedAttr(o: TypedAttr): MOption[TypedAttr] = {
      return MNone()
    }

    def transformResolvedAttr(o: ResolvedAttr): MOption[ResolvedAttr] = {
      return MNone()
    }

    def transformResolvedInfo(o: ResolvedInfo): MOption[ResolvedInfo] = {
      return MNone()
    }

    def transformPosInfo(o: PosInfo): MOption[PosInfo] = {
      return MNone()
    }

  }

  def transformISZ[T](s: IS[Z, T], f: T => MOption[T]): MOption[IS[Z, T]] = {
    val s2: MS[Z, T] = SI.toMS(s)
    var changed: B = F
    for (i <- s2.indices) {
      val e: T = s(i)
      val r: MOption[T] = f(e)
      changed = changed | r.nonEmpty
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

@record class MTransformer(pre: Pre, post: Post) {

  def transformTopUnit(o: TopUnit): MOption[TopUnit] = {
    val preR: PreResult[TopUnit] = pre.transformTopUnit(o)
    val r: MOption[TopUnit] = if (preR.continue) {
      val o2: TopUnit = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[TopUnit] = o2 match {
        case o2: TopUnit.Program =>
          val r0: MOption[Name] = transformName(o2.packageName)
          val r1: MOption[Body] = transformBody(o2.body)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(packageName = r0.getOrElse(o2.packageName), body = r1.getOrElse(o2.body)))
          else
            MNone()
        case o2: TopUnit.SequentUnit =>
          val r0: MOption[LClause.Sequent] = transformLClauseSequent(o2.sequent)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(sequent = r0.getOrElse(o2.sequent)))
          else
            MNone()
        case o2: TopUnit.TruthTableUnit =>
          val r0: MOption[IS[Z, Id]] = transformISZ(o2.vars, transformId _)
          val r1: MOption[LClause.Sequent] = transformLClauseSequent(o2.sequent)
          val r2: MOption[IS[Z, TruthTable.Row]] = transformISZ(o2.rows, transformTruthTableRow _)
          val r3: MOption[Option[TruthTable.Conclusion]] = transformOption(o2.conclusionOpt, transformTruthTableConclusion _)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
            MSome(o2(vars = r0.getOrElse(o2.vars), sequent = r1.getOrElse(o2.sequent), rows = r2.getOrElse(o2.rows), conclusionOpt = r3.getOrElse(o2.conclusionOpt)))
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
    val postR: MOption[TopUnit] = post.transformTopUnit(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformLClauseSequent(o: LClause.Sequent): MOption[LClause.Sequent] = {
    val preR: PreResult[LClause.Sequent] = pre.transformLClauseSequent(o) match {
      case PreResult(continue, MSome(r: LClause.Sequent)) => PreResult(continue, MSome[LClause.Sequent](r))
      case _ => assert(F); PreResult(F, MNone[LClause.Sequent]())
    }
    val r: MOption[LClause.Sequent] = if (preR.continue) {
      val o2: LClause.Sequent = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Exp]] = transformISZ(o2.premises, transformExp _)
      val r1: MOption[IS[Z, Exp]] = transformISZ(o2.conclusions, transformExp _)
      val r2: MOption[Option[LClause.Proof]] = transformOption(o2.proofOpt, transformLClauseProof _)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
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
    val postR: MOption[LClause.Sequent] = post.transformLClauseSequent(o2) match {
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

  def transformLClauseProof(o: LClause.Proof): MOption[LClause.Proof] = {
    val preR: PreResult[LClause.Proof] = pre.transformLClauseProof(o) match {
      case PreResult(continue, MSome(r: LClause.Proof)) => PreResult(continue, MSome[LClause.Proof](r))
      case _ => assert(F); PreResult(F, MNone[LClause.Proof]())
    }
    val r: MOption[LClause.Proof] = if (preR.continue) {
      val o2: LClause.Proof = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, ProofStep]] = transformISZ(o2.steps, transformProofStep _)
      if (hasChanged | r0.nonEmpty)
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
    val postR: MOption[LClause.Proof] = post.transformLClauseProof(o2) match {
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

  def transformStmt(o: Stmt): MOption[Stmt] = {
    val preR: PreResult[Stmt] = pre.transformStmt(o)
    val r: MOption[Stmt] = if (preR.continue) {
      val o2: Stmt = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Stmt] = o2 match {
        case o2: Stmt.Import =>
          val r0: MOption[IS[Z, Stmt.Import.Importer]] = transformISZ(o2.importers, transformStmtImportImporter _)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(importers = r0.getOrElse(o2.importers), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Var =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[Option[Type]] = transformOption(o2.tipeOpt, transformType _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), tipeOpt = r1.getOrElse(o2.tipeOpt), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.VarPattern =>
          val r0: MOption[Pattern] = transformPattern(o2.pattern)
          val r1: MOption[Option[Type]] = transformOption(o2.tipeOpt, transformType _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(pattern = r0.getOrElse(o2.pattern), tipeOpt = r1.getOrElse(o2.tipeOpt), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.SpecVar =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[Type] = transformType(o2.tipe)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), tipe = r1.getOrElse(o2.tipe), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Method =>
          val r0: MOption[MethodSig] = transformMethodSig(o2.sig)
          val r1: MOption[Contract] = transformContract(o2.contract)
          val r2: MOption[Option[Body]] = transformOption(o2.bodyOpt, transformBody _)
          val r3: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
            MSome(o2(sig = r0.getOrElse(o2.sig), contract = r1.getOrElse(o2.contract), bodyOpt = r2.getOrElse(o2.bodyOpt), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.ExtMethod =>
          val r0: MOption[MethodSig] = transformMethodSig(o2.sig)
          val r1: MOption[Contract] = transformContract(o2.contract)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(sig = r0.getOrElse(o2.sig), contract = r1.getOrElse(o2.contract), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.SpecMethod =>
          val r0: MOption[MethodSig] = transformMethodSig(o2.sig)
          val r1: MOption[IS[Z, SpecDef]] = transformISZ(o2.defs, transformSpecDef _)
          val r2: MOption[IS[Z, WhereDef]] = transformISZ(o2.where, transformWhereDef _)
          val r3: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
            MSome(o2(sig = r0.getOrElse(o2.sig), defs = r1.getOrElse(o2.defs), where = r2.getOrElse(o2.where), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Enum =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[IS[Z, Id]] = transformISZ(o2.elements, transformId _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), elements = r1.getOrElse(o2.elements), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Object =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[IS[Z, Type]] = transformISZ(o2.parents, transformType _)
          val r2: MOption[IS[Z, Stmt]] = transformISZ(o2.stmts, transformStmt _)
          val r3: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
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
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty| r4.nonEmpty| r5.nonEmpty)
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
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty| r4.nonEmpty| r5.nonEmpty)
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
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty| r4.nonEmpty| r5.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), typeParams = r1.getOrElse(o2.typeParams), params = r2.getOrElse(o2.params), parents = r3.getOrElse(o2.parents), stmts = r4.getOrElse(o2.stmts), attr = r5.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.TypeAlias =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[IS[Z, TypeParam]] = transformISZ(o2.typeParams, transformTypeParam _)
          val r2: MOption[Type] = transformType(o2.tipe)
          val r3: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), typeParams = r1.getOrElse(o2.typeParams), tipe = r2.getOrElse(o2.tipe), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Assign =>
          val r0: MOption[Exp] = transformExp(o2.lhs)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(lhs = r0.getOrElse(o2.lhs), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.AssignUp =>
          val r0: MOption[Exp] = transformExp(o2.lhs)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(lhs = r0.getOrElse(o2.lhs), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.AssignPattern =>
          val r0: MOption[Pattern] = transformPattern(o2.lhs)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(lhs = r0.getOrElse(o2.lhs), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Block =>
          val r0: MOption[Body] = transformBody(o2.body)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(body = r0.getOrElse(o2.body), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.If =>
          val r0: MOption[Exp] = transformExp(o2.cond)
          val r1: MOption[Body] = transformBody(o2.thenbody)
          val r2: MOption[Body] = transformBody(o2.elsebody)
          val r3: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
            MSome(o2(cond = r0.getOrElse(o2.cond), thenbody = r1.getOrElse(o2.thenbody), elsebody = r2.getOrElse(o2.elsebody), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Match =>
          val r0: MOption[Exp] = transformExp(o2.cond)
          val r1: MOption[IS[Z, Case]] = transformISZ(o2.cases, transformCase _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(cond = r0.getOrElse(o2.cond), cases = r1.getOrElse(o2.cases), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.While =>
          val r0: MOption[Exp] = transformExp(o2.cond)
          val r1: MOption[IS[Z, ContractExp]] = transformISZ(o2.invariants, transformContractExp _)
          val r2: MOption[IS[Z, Exp]] = transformISZ(o2.modifies, transformExp _)
          val r3: MOption[Body] = transformBody(o2.body)
          val r4: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty| r4.nonEmpty)
            MSome(o2(cond = r0.getOrElse(o2.cond), invariants = r1.getOrElse(o2.invariants), modifies = r2.getOrElse(o2.modifies), body = r3.getOrElse(o2.body), attr = r4.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.DoWhile =>
          val r0: MOption[Exp] = transformExp(o2.cond)
          val r1: MOption[IS[Z, ContractExp]] = transformISZ(o2.invariants, transformContractExp _)
          val r2: MOption[IS[Z, Exp]] = transformISZ(o2.modifies, transformExp _)
          val r3: MOption[Body] = transformBody(o2.body)
          val r4: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty| r4.nonEmpty)
            MSome(o2(cond = r0.getOrElse(o2.cond), invariants = r1.getOrElse(o2.invariants), modifies = r2.getOrElse(o2.modifies), body = r3.getOrElse(o2.body), attr = r4.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.For =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[Range] = transformRange(o2.range)
          val r2: MOption[Option[Exp]] = transformOption(o2.condOpt, transformExp _)
          val r3: MOption[IS[Z, ContractExp]] = transformISZ(o2.invariants, transformContractExp _)
          val r4: MOption[IS[Z, Exp]] = transformISZ(o2.modifies, transformExp _)
          val r5: MOption[Body] = transformBody(o2.body)
          val r6: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty| r4.nonEmpty| r5.nonEmpty| r6.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), range = r1.getOrElse(o2.range), condOpt = r2.getOrElse(o2.condOpt), invariants = r3.getOrElse(o2.invariants), modifies = r4.getOrElse(o2.modifies), body = r5.getOrElse(o2.body), attr = r6.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Return =>
          val r0: MOption[Option[Exp]] = transformOption(o2.expOpt, transformExp _)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(expOpt = r0.getOrElse(o2.expOpt), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.LStmt =>
          val r0: MOption[LClause] = transformLClause(o2.clause)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(clause = r0.getOrElse(o2.clause), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Expr =>
          val r0: MOption[Exp] = transformExp(o2.exp)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
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
    val postR: MOption[Stmt] = post.transformStmt(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformTypeNamed(o: Type.Named): MOption[Type.Named] = {
    val preR: PreResult[Type.Named] = pre.transformTypeNamed(o) match {
      case PreResult(continue, MSome(r: Type.Named)) => PreResult(continue, MSome[Type.Named](r))
      case _ => assert(F); PreResult(F, MNone[Type.Named]())
    }
    val r: MOption[Type.Named] = if (preR.continue) {
      val o2: Type.Named = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Name] = transformName(o2.name)
      val r1: MOption[IS[Z, Type]] = transformISZ(o2.typeArgs, transformType _)
      val r2: MOption[TypedAttr] = transformTypedAttr(o2.attr)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
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
    val postR: MOption[Type.Named] = post.transformTypeNamed(o2) match {
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

  def transformStmtImportImporter(o: Stmt.Import.Importer): MOption[Stmt.Import.Importer] = {
    val preR: PreResult[Stmt.Import.Importer] = pre.transformStmtImportImporter(o)
    val r: MOption[Stmt.Import.Importer] = if (preR.continue) {
      val o2: Stmt.Import.Importer = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Name] = transformName(o2.name)
      val r1: MOption[Option[Stmt.Import.Selector]] = transformOption(o2.selectorOpt, transformStmtImportSelector _)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty)
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
    val postR: MOption[Stmt.Import.Importer] = post.transformStmtImportImporter(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformStmtImportSelector(o: Stmt.Import.Selector): MOption[Stmt.Import.Selector] = {
    val preR: PreResult[Stmt.Import.Selector] = pre.transformStmtImportSelector(o)
    val r: MOption[Stmt.Import.Selector] = if (preR.continue) {
      val o2: Stmt.Import.Selector = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Stmt.Import.Selector] = o2 match {
        case o2: Stmt.Import.MultiSelector =>
          val r0: MOption[IS[Z, Stmt.Import.NamedSelector]] = transformISZ(o2.selectors, transformStmtImportNamedSelector _)
          if (hasChanged | r0.nonEmpty)
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
    val postR: MOption[Stmt.Import.Selector] = post.transformStmtImportSelector(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformStmtImportNamedSelector(o: Stmt.Import.NamedSelector): MOption[Stmt.Import.NamedSelector] = {
    val preR: PreResult[Stmt.Import.NamedSelector] = pre.transformStmtImportNamedSelector(o)
    val r: MOption[Stmt.Import.NamedSelector] = if (preR.continue) {
      val o2: Stmt.Import.NamedSelector = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.from)
      val r1: MOption[Id] = transformId(o2.to)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty)
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
    val postR: MOption[Stmt.Import.NamedSelector] = post.transformStmtImportNamedSelector(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformLClause(o: LClause): MOption[LClause] = {
    val preR: PreResult[LClause] = pre.transformLClause(o)
    val r: MOption[LClause] = if (preR.continue) {
      val o2: LClause = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[LClause] = o2 match {
        case o2: LClause.Invariants =>
          val r0: MOption[IS[Z, ContractExp]] = transformISZ(o2.value, transformContractExp _)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(value = r0.getOrElse(o2.value)))
          else
            MNone()
        case o2: LClause.Facts =>
          val r0: MOption[IS[Z, LClause.Fact]] = transformISZ(o2.value, transformLClauseFact _)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(value = r0.getOrElse(o2.value)))
          else
            MNone()
        case o2: LClause.Theorems =>
          val r0: MOption[IS[Z, LClause.Theorem]] = transformISZ(o2.value, transformLClauseTheorem _)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(value = r0.getOrElse(o2.value)))
          else
            MNone()
        case o2: LClause.Sequent =>
          val r0: MOption[IS[Z, Exp]] = transformISZ(o2.premises, transformExp _)
          val r1: MOption[IS[Z, Exp]] = transformISZ(o2.conclusions, transformExp _)
          val r2: MOption[Option[LClause.Proof]] = transformOption(o2.proofOpt, transformLClauseProof _)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(premises = r0.getOrElse(o2.premises), conclusions = r1.getOrElse(o2.conclusions), proofOpt = r2.getOrElse(o2.proofOpt)))
          else
            MNone()
        case o2: LClause.Proof =>
          val r0: MOption[IS[Z, ProofStep]] = transformISZ(o2.steps, transformProofStep _)
          if (hasChanged | r0.nonEmpty)
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
    val postR: MOption[LClause] = post.transformLClause(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformLClauseFact(o: LClause.Fact): MOption[LClause.Fact] = {
    val preR: PreResult[LClause.Fact] = pre.transformLClauseFact(o)
    val r: MOption[LClause.Fact] = if (preR.continue) {
      val o2: LClause.Fact = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[Exp] = transformExp(o2.exp)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty)
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
    val postR: MOption[LClause.Fact] = post.transformLClauseFact(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformLClauseTheorem(o: LClause.Theorem): MOption[LClause.Theorem] = {
    val preR: PreResult[LClause.Theorem] = pre.transformLClauseTheorem(o)
    val r: MOption[LClause.Theorem] = if (preR.continue) {
      val o2: LClause.Theorem = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[LClause.Sequent] = transformLClauseSequent(o2.sequent)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty)
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
    val postR: MOption[LClause.Theorem] = post.transformLClauseTheorem(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformContractExp(o: ContractExp): MOption[ContractExp] = {
    val preR: PreResult[ContractExp] = pre.transformContractExp(o)
    val r: MOption[ContractExp] = if (preR.continue) {
      val o2: ContractExp = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Option[Id]] = transformOption(o2.idOpt, transformId _)
      val r1: MOption[Exp] = transformExp(o2.exp)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty)
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
    val postR: MOption[ContractExp] = post.transformContractExp(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformCase(o: Case): MOption[Case] = {
    val preR: PreResult[Case] = pre.transformCase(o)
    val r: MOption[Case] = if (preR.continue) {
      val o2: Case = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Pattern] = transformPattern(o2.pattern)
      val r1: MOption[Option[Exp]] = transformOption(o2.condOpt, transformExp _)
      val r2: MOption[Body] = transformBody(o2.body)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
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
    val postR: MOption[Case] = post.transformCase(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformRange(o: Range): MOption[Range] = {
    val preR: PreResult[Range] = pre.transformRange(o)
    val r: MOption[Range] = if (preR.continue) {
      val o2: Range = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Range] = o2 match {
        case o2: Range.Expr =>
          val r0: MOption[Exp] = transformExp(o2.exp)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(exp = r0.getOrElse(o2.exp)))
          else
            MNone()
        case o2: Range.Indices =>
          val r0: MOption[Exp] = transformExp(o2.exp)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(exp = r0.getOrElse(o2.exp)))
          else
            MNone()
        case o2: Range.Step =>
          val r0: MOption[Exp] = transformExp(o2.start)
          val r1: MOption[Exp] = transformExp(o2.end)
          val r2: MOption[Option[Exp]] = transformOption(o2.byOpt, transformExp _)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
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
    val o2: Range = r.getOrElse(o)
    val postR: MOption[Range] = post.transformRange(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformType(o: Type): MOption[Type] = {
    val preR: PreResult[Type] = pre.transformType(o)
    val r: MOption[Type] = if (preR.continue) {
      val o2: Type = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Type] = o2 match {
        case o2: Type.Named =>
          val r0: MOption[Name] = transformName(o2.name)
          val r1: MOption[IS[Z, Type]] = transformISZ(o2.typeArgs, transformType _)
          val r2: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(name = r0.getOrElse(o2.name), typeArgs = r1.getOrElse(o2.typeArgs), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Type.Fun =>
          val r0: MOption[IS[Z, Type]] = transformISZ(o2.args, transformType _)
          val r1: MOption[Type] = transformType(o2.ret)
          val r2: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(args = r0.getOrElse(o2.args), ret = r1.getOrElse(o2.ret), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Type.Tuple =>
          val r0: MOption[IS[Z, Type]] = transformISZ(o2.args, transformType _)
          val r1: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
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
    val postR: MOption[Type] = post.transformType(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformPattern(o: Pattern): MOption[Pattern] = {
    val preR: PreResult[Pattern] = pre.transformPattern(o)
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
          if (hasChanged | r0.nonEmpty)
            MSome(o2(name = r0.getOrElse(o2.name)))
          else
            MNone()
        case o2: Pattern.Variable =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[Option[Type]] = transformOption(o2.typeOpt, transformType _)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), typeOpt = r1.getOrElse(o2.typeOpt)))
          else
            MNone()
        case o2: Pattern.Wildcard =>
          val r0: MOption[Option[Type]] = transformOption(o2.typeOpt, transformType _)
          if (hasChanged | r0.nonEmpty)
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
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
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
    val postR: MOption[Pattern] = post.transformPattern(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformExp(o: Exp): MOption[Exp] = {
    val preR: PreResult[Exp] = pre.transformExp(o)
    val r: MOption[Exp] = if (preR.continue) {
      val o2: Exp = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Exp] = o2 match {
        case o2: Exp.LitB =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitC =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitZ =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitZ8 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitZ16 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitZ32 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitZ64 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitN =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitN8 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitN16 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitN32 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitN64 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitS8 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitS16 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitS32 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitS64 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitU8 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitU16 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitU32 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitU64 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitF32 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitF64 =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitR =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitBv =>
          val r0: MOption[Type] = transformType(o2.tipe)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(tipe = r0.getOrElse(o2.tipe), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.LitString =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.StringInterpolate =>
          val r0: MOption[IS[Z, Exp.LitString]] = transformISZ(o2.lits, transformExpLitString _)
          val r1: MOption[IS[Z, Exp]] = transformISZ(o2.args, transformExp _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(lits = r0.getOrElse(o2.lits), args = r1.getOrElse(o2.args), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.This =>
          val r0: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Unary =>
          val r0: MOption[Exp] = transformExp(o2.exp)
          val r1: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(exp = r0.getOrElse(o2.exp), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Binary =>
          val r0: MOption[Exp] = transformExp(o2.left)
          val r1: MOption[Exp] = transformExp(o2.right)
          val r2: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(left = r0.getOrElse(o2.left), right = r1.getOrElse(o2.right), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Ident =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Eta =>
          val r0: MOption[Exp] = transformExp(o2.exp)
          val r1: MOption[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(exp = r0.getOrElse(o2.exp), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Tuple =>
          val r0: MOption[IS[Z, Exp]] = transformISZ(o2.args, transformExp _)
          val r1: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(args = r0.getOrElse(o2.args), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Select =>
          val r0: MOption[Option[Exp]] = transformOption(o2.receiverOpt, transformExp _)
          val r1: MOption[Id] = transformId(o2.id)
          val r2: MOption[IS[Z, Type]] = transformISZ(o2.targs, transformType _)
          val r3: MOption[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
            MSome(o2(receiverOpt = r0.getOrElse(o2.receiverOpt), id = r1.getOrElse(o2.id), targs = r2.getOrElse(o2.targs), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Invoke =>
          val r0: MOption[Option[Exp]] = transformOption(o2.receiverOpt, transformExp _)
          val r1: MOption[Id] = transformId(o2.id)
          val r2: MOption[IS[Z, Type]] = transformISZ(o2.targs, transformType _)
          val r3: MOption[IS[Z, Exp]] = transformISZ(o2.args, transformExp _)
          val r4: MOption[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty| r4.nonEmpty)
            MSome(o2(receiverOpt = r0.getOrElse(o2.receiverOpt), id = r1.getOrElse(o2.id), targs = r2.getOrElse(o2.targs), args = r3.getOrElse(o2.args), attr = r4.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.InvokeNamed =>
          val r0: MOption[Option[Exp]] = transformOption(o2.receiverOpt, transformExp _)
          val r1: MOption[Id] = transformId(o2.id)
          val r2: MOption[IS[Z, Type]] = transformISZ(o2.targs, transformType _)
          val r3: MOption[IS[Z, NamedArg]] = transformISZ(o2.args, transformNamedArg _)
          val r4: MOption[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty| r4.nonEmpty)
            MSome(o2(receiverOpt = r0.getOrElse(o2.receiverOpt), id = r1.getOrElse(o2.id), targs = r2.getOrElse(o2.targs), args = r3.getOrElse(o2.args), attr = r4.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.If =>
          val r0: MOption[Exp] = transformExp(o2.cond)
          val r1: MOption[Exp] = transformExp(o2.thenExp)
          val r2: MOption[Exp] = transformExp(o2.elseExp)
          val r3: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
            MSome(o2(cond = r0.getOrElse(o2.cond), thenExp = r1.getOrElse(o2.thenExp), elseExp = r2.getOrElse(o2.elseExp), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Quant =>
          val r0: MOption[IS[Z, VarFragment]] = transformISZ(o2.varFragments, transformVarFragment _)
          val r1: MOption[Exp] = transformExp(o2.exp)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(varFragments = r0.getOrElse(o2.varFragments), exp = r1.getOrElse(o2.exp)))
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
    val postR: MOption[Exp] = post.transformExp(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformExpLitString(o: Exp.LitString): MOption[Exp.LitString] = {
    val preR: PreResult[Exp.LitString] = pre.transformExpLitString(o) match {
      case PreResult(continue, MSome(r: Exp.LitString)) => PreResult(continue, MSome[Exp.LitString](r))
      case _ => assert(F); PreResult(F, MNone[Exp.LitString]())
    }
    val r: MOption[Exp.LitString] = if (preR.continue) {
      val o2: Exp.LitString = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Attr] = transformAttr(o2.attr)
      if (hasChanged | r0.nonEmpty)
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
    val postR: MOption[Exp.LitString] = post.transformExpLitString(o2) match {
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

  def transformNamedArg(o: NamedArg): MOption[NamedArg] = {
    val preR: PreResult[NamedArg] = pre.transformNamedArg(o)
    val r: MOption[NamedArg] = if (preR.continue) {
      val o2: NamedArg = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[Exp] = transformExp(o2.arg)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty)
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
    val postR: MOption[NamedArg] = post.transformNamedArg(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformVarFragment(o: VarFragment): MOption[VarFragment] = {
    val preR: PreResult[VarFragment] = pre.transformVarFragment(o)
    val r: MOption[VarFragment] = if (preR.continue) {
      val o2: VarFragment = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Id]] = transformISZ(o2.ids, transformId _)
      val r1: MOption[Option[Domain]] = transformOption(o2.domainOpt, transformDomain _)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty)
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
    val postR: MOption[VarFragment] = post.transformVarFragment(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformDomain(o: Domain): MOption[Domain] = {
    val preR: PreResult[Domain] = pre.transformDomain(o)
    val r: MOption[Domain] = if (preR.continue) {
      val o2: Domain = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Domain] = o2 match {
        case o2: Domain.Type =>
          val r0: MOption[Type] = transformType(o2.tipe)
          val r1: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(tipe = r0.getOrElse(o2.tipe), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Domain.Range =>
          val r0: MOption[Exp] = transformExp(o2.lo)
          val r1: MOption[Exp] = transformExp(o2.hi)
          val r2: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
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
    val postR: MOption[Domain] = post.transformDomain(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformId(o: Id): MOption[Id] = {
    val preR: PreResult[Id] = pre.transformId(o)
    val r: MOption[Id] = if (preR.continue) {
      val o2: Id = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Attr] = transformAttr(o2.attr)
      if (hasChanged | r0.nonEmpty)
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
    val postR: MOption[Id] = post.transformId(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformName(o: Name): MOption[Name] = {
    val preR: PreResult[Name] = pre.transformName(o)
    val r: MOption[Name] = if (preR.continue) {
      val o2: Name = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Id]] = transformISZ(o2.ids, transformId _)
      val r1: MOption[Attr] = transformAttr(o2.attr)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty)
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
    val postR: MOption[Name] = post.transformName(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformBody(o: Body): MOption[Body] = {
    val preR: PreResult[Body] = pre.transformBody(o)
    val r: MOption[Body] = if (preR.continue) {
      val o2: Body = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Stmt]] = transformISZ(o2.stmts, transformStmt _)
      if (hasChanged | r0.nonEmpty)
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
    val postR: MOption[Body] = post.transformBody(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformAbstractDatatypeParam(o: AbstractDatatypeParam): MOption[AbstractDatatypeParam] = {
    val preR: PreResult[AbstractDatatypeParam] = pre.transformAbstractDatatypeParam(o)
    val r: MOption[AbstractDatatypeParam] = if (preR.continue) {
      val o2: AbstractDatatypeParam = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[Type] = transformType(o2.tipe)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty)
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
    val postR: MOption[AbstractDatatypeParam] = post.transformAbstractDatatypeParam(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformMethodSig(o: MethodSig): MOption[MethodSig] = {
    val preR: PreResult[MethodSig] = pre.transformMethodSig(o)
    val r: MOption[MethodSig] = if (preR.continue) {
      val o2: MethodSig = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[IS[Z, TypeParam]] = transformISZ(o2.typeParams, transformTypeParam _)
      val r2: MOption[Type] = transformType(o2.returnType)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
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
    val postR: MOption[MethodSig] = post.transformMethodSig(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformParam(o: Param): MOption[Param] = {
    val preR: PreResult[Param] = pre.transformParam(o)
    val r: MOption[Param] = if (preR.continue) {
      val o2: Param = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[Type] = transformType(o2.tipe)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty)
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
    val postR: MOption[Param] = post.transformParam(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformTypeParam(o: TypeParam): MOption[TypeParam] = {
    val preR: PreResult[TypeParam] = pre.transformTypeParam(o)
    val r: MOption[TypeParam] = if (preR.continue) {
      val o2: TypeParam = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[Option[Type]] = transformOption(o2.superTypeOpt, transformType _)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty)
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
    val postR: MOption[TypeParam] = post.transformTypeParam(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformContract(o: Contract): MOption[Contract] = {
    val preR: PreResult[Contract] = pre.transformContract(o)
    val r: MOption[Contract] = if (preR.continue) {
      val o2: Contract = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Exp]] = transformISZ(o2.reads, transformExp _)
      val r1: MOption[IS[Z, ContractExp]] = transformISZ(o2.requires, transformContractExp _)
      val r2: MOption[IS[Z, Exp]] = transformISZ(o2.modifies, transformExp _)
      val r3: MOption[IS[Z, ContractExp]] = transformISZ(o2.ensures, transformContractExp _)
      val r4: MOption[IS[Z, SubContract]] = transformISZ(o2.subs, transformSubContract _)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty| r4.nonEmpty)
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
    val postR: MOption[Contract] = post.transformContract(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformSubContract(o: SubContract): MOption[SubContract] = {
    val preR: PreResult[SubContract] = pre.transformSubContract(o)
    val r: MOption[SubContract] = if (preR.continue) {
      val o2: SubContract = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[IS[Z, SubContractParam]] = transformISZ(o2.params, transformSubContractParam _)
      val r2: MOption[Contract] = transformContract(o2.contract)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
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
    val postR: MOption[SubContract] = post.transformSubContract(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformSubContractParam(o: SubContractParam): MOption[SubContractParam] = {
    val preR: PreResult[SubContractParam] = pre.transformSubContractParam(o)
    val r: MOption[SubContractParam] = if (preR.continue) {
      val o2: SubContractParam = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      if (hasChanged | r0.nonEmpty)
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
    val postR: MOption[SubContractParam] = post.transformSubContractParam(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformWhereDef(o: WhereDef): MOption[WhereDef] = {
    val preR: PreResult[WhereDef] = pre.transformWhereDef(o)
    val r: MOption[WhereDef] = if (preR.continue) {
      val o2: WhereDef = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[WhereDef] = o2 match {
        case o2: WhereDef.Val =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[Type] = transformType(o2.tipe)
          val r2: MOption[Exp] = transformExp(o2.exp)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), tipe = r1.getOrElse(o2.tipe), exp = r2.getOrElse(o2.exp)))
          else
            MNone()
        case o2: WhereDef.Def =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[IS[Z, Param]] = transformISZ(o2.params, transformParam _)
          val r2: MOption[Type] = transformType(o2.rTipe)
          val r3: MOption[IS[Z, SpecDef]] = transformISZ(o2.defs, transformSpecDef _)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
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
    val postR: MOption[WhereDef] = post.transformWhereDef(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformSpecDef(o: SpecDef): MOption[SpecDef] = {
    val preR: PreResult[SpecDef] = pre.transformSpecDef(o)
    val r: MOption[SpecDef] = if (preR.continue) {
      val o2: SpecDef = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Option[Id]] = transformOption(o2.idOpt, transformId _)
      val r1: MOption[Exp] = transformExp(o2.exp)
      val r2: MOption[Option[Pattern]] = transformOption(o2.patternOpt, transformPattern _)
      val r3: MOption[Option[Exp]] = transformOption(o2.guardOpt, transformExp _)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
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
    val postR: MOption[SpecDef] = post.transformSpecDef(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformProofStep(o: ProofStep): MOption[ProofStep] = {
    val preR: PreResult[ProofStep] = pre.transformProofStep(o)
    val r: MOption[ProofStep] = if (preR.continue) {
      val o2: ProofStep = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[ProofStep] = o2 match {
        case o2: ProofStep.Basic =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: MOption[Exp] = transformExp(o2.exp)
          val r2: MOption[Just] = transformJust(o2.just)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(step = r0.getOrElse(o2.step), exp = r1.getOrElse(o2.exp), just = r2.getOrElse(o2.just)))
          else
            MNone()
        case o2: ProofStep.SubProof =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: MOption[AssumeProofStep] = transformAssumeProofStep(o2.assumeStep)
          val r2: MOption[IS[Z, ProofStep]] = transformISZ(o2.steps, transformProofStep _)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
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
    val postR: MOption[ProofStep] = post.transformProofStep(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformExpLitZ(o: Exp.LitZ): MOption[Exp.LitZ] = {
    val preR: PreResult[Exp.LitZ] = pre.transformExpLitZ(o) match {
      case PreResult(continue, MSome(r: Exp.LitZ)) => PreResult(continue, MSome[Exp.LitZ](r))
      case _ => assert(F); PreResult(F, MNone[Exp.LitZ]())
    }
    val r: MOption[Exp.LitZ] = if (preR.continue) {
      val o2: Exp.LitZ = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Attr] = transformAttr(o2.attr)
      if (hasChanged | r0.nonEmpty)
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
    val postR: MOption[Exp.LitZ] = post.transformExpLitZ(o2) match {
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

  def transformAssumeProofStep(o: AssumeProofStep): MOption[AssumeProofStep] = {
    val preR: PreResult[AssumeProofStep] = pre.transformAssumeProofStep(o)
    val r: MOption[AssumeProofStep] = if (preR.continue) {
      val o2: AssumeProofStep = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[AssumeProofStep] = o2 match {
        case o2: AssumeProofStep.Regular =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: MOption[Exp] = transformExp(o2.exp)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(step = r0.getOrElse(o2.step), exp = r1.getOrElse(o2.exp)))
          else
            MNone()
        case o2: AssumeProofStep.ForallIntroAps =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: MOption[IS[Z, VarFragment]] = transformISZ(o2.varFragments, transformVarFragment _)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(step = r0.getOrElse(o2.step), varFragments = r1.getOrElse(o2.varFragments)))
          else
            MNone()
        case o2: AssumeProofStep.ExistsElimAps =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: MOption[IS[Z, VarFragment]] = transformISZ(o2.varFragments, transformVarFragment _)
          val r2: MOption[Exp] = transformExp(o2.exp)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
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
    val postR: MOption[AssumeProofStep] = post.transformAssumeProofStep(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformJust(o: Just): MOption[Just] = {
    val preR: PreResult[Just] = pre.transformJust(o)
    val r: MOption[Just] = if (preR.continue) {
      val o2: Just = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Just] = o2 match {
        case o2: Just.Premise =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.AndIntro =>
          val r0: MOption[IS[Z, Exp.LitZ]] = transformISZ(o2.steps, transformExpLitZ _)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(steps = r0.getOrElse(o2.steps), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.AndElim =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.andStep)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(andStep = r0.getOrElse(o2.andStep), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.OrIntro =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(step = r0.getOrElse(o2.step), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.OrElim =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.orStep)
          val r1: MOption[IS[Z, Exp.LitZ]] = transformISZ(o2.subProofSteps, transformExpLitZ _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(orStep = r0.getOrElse(o2.orStep), subProofSteps = r1.getOrElse(o2.subProofSteps), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.ImplyIntro =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.subProofStep)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(subProofStep = r0.getOrElse(o2.subProofStep), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.ImplyElim =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.implyStep)
          val r1: MOption[IS[Z, Exp.LitZ]] = transformISZ(o2.steps, transformExpLitZ _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(implyStep = r0.getOrElse(o2.implyStep), steps = r1.getOrElse(o2.steps), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.NegIntro =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.subProofStep)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(subProofStep = r0.getOrElse(o2.subProofStep), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.NegElim =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: MOption[Exp.LitZ] = transformExpLitZ(o2.negStep)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(step = r0.getOrElse(o2.step), negStep = r1.getOrElse(o2.negStep), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.BottomElim =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.subProofStep)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(subProofStep = r0.getOrElse(o2.subProofStep), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.Pbc =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.subProofStep)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(subProofStep = r0.getOrElse(o2.subProofStep), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.ForallIntro =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.subProofStep)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(subProofStep = r0.getOrElse(o2.subProofStep), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.ForallElim =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.forallStep)
          val r1: MOption[IS[Z, Exp]] = transformISZ(o2.args, transformExp _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(forallStep = r0.getOrElse(o2.forallStep), args = r1.getOrElse(o2.args), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.ExistsIntro =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.existsStep)
          val r1: MOption[IS[Z, Exp]] = transformISZ(o2.args, transformExp _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(existsStep = r0.getOrElse(o2.existsStep), args = r1.getOrElse(o2.args), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.ExistsElim =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.existsStep)
          val r1: MOption[Exp.LitZ] = transformExpLitZ(o2.subProofStep)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(existsStep = r0.getOrElse(o2.existsStep), subProofStep = r1.getOrElse(o2.subProofStep), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.Fact =>
          val r0: MOption[Name] = transformName(o2.name)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(name = r0.getOrElse(o2.name), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.Invariant =>
          val r0: MOption[Option[Name]] = transformOption(o2.nameOpt, transformName _)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(nameOpt = r0.getOrElse(o2.nameOpt), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.Subst =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.eqStep)
          val r1: MOption[Exp.LitZ] = transformExpLitZ(o2.step)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            MSome(o2(eqStep = r0.getOrElse(o2.eqStep), step = r1.getOrElse(o2.step), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.Auto =>
          val r0: MOption[IS[Z, Exp.LitZ]] = transformISZ(o2.steps, transformExpLitZ _)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty)
            MSome(o2(steps = r0.getOrElse(o2.steps), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.Coq =>
          val r0: MOption[Exp.LitString] = transformExpLitString(o2.path)
          val r1: MOption[IS[Z, Exp.LitZ]] = transformISZ(o2.steps, transformExpLitZ _)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
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
    val postR: MOption[Just] = post.transformJust(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformTruthTableRow(o: TruthTable.Row): MOption[TruthTable.Row] = {
    val preR: PreResult[TruthTable.Row] = pre.transformTruthTableRow(o)
    val r: MOption[TruthTable.Row] = if (preR.continue) {
      val o2: TruthTable.Row = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Exp.LitB]] = transformISZ(o2.assignment, transformExpLitB _)
      val r1: MOption[IS[Z, Exp.LitB]] = transformISZ(o2.values, transformExpLitB _)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty)
        MSome(o2(assignment = r0.getOrElse(o2.assignment), values = r1.getOrElse(o2.values)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: TruthTable.Row = r.getOrElse(o)
    val postR: MOption[TruthTable.Row] = post.transformTruthTableRow(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformExpLitB(o: Exp.LitB): MOption[Exp.LitB] = {
    val preR: PreResult[Exp.LitB] = pre.transformExpLitB(o) match {
      case PreResult(continue, MSome(r: Exp.LitB)) => PreResult(continue, MSome[Exp.LitB](r))
      case _ => assert(F); PreResult(F, MNone[Exp.LitB]())
    }
    val r: MOption[Exp.LitB] = if (preR.continue) {
      val o2: Exp.LitB = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Attr] = transformAttr(o2.attr)
      if (hasChanged | r0.nonEmpty)
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
    val postR: MOption[Exp.LitB] = post.transformExpLitB(o2) match {
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

  def transformTruthTableConclusion(o: TruthTable.Conclusion): MOption[TruthTable.Conclusion] = {
    val preR: PreResult[TruthTable.Conclusion] = pre.transformTruthTableConclusion(o)
    val r: MOption[TruthTable.Conclusion] = if (preR.continue) {
      val o2: TruthTable.Conclusion = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[TruthTable.Conclusion] = o2 match {
        case o2: TruthTable.Conclusion.Validity =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: TruthTable.Conclusion.Tautology =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: TruthTable.Conclusion.Contradictory =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: TruthTable.Conclusion.Contingent =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged | r0.nonEmpty)
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
    val postR: MOption[TruthTable.Conclusion] = post.transformTruthTableConclusion(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformAttr(o: Attr): MOption[Attr] = {
    val preR: PreResult[Attr] = pre.transformAttr(o)
    val r: MOption[Attr] = if (preR.continue) {
      val o2: Attr = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Option[PosInfo]] = transformOption(o2.posInfoOpt, transformPosInfo _)
      if (hasChanged | r0.nonEmpty)
        MSome(o2(posInfoOpt = r0.getOrElse(o2.posInfoOpt)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Attr = r.getOrElse(o)
    val postR: MOption[Attr] = post.transformAttr(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformTypedAttr(o: TypedAttr): MOption[TypedAttr] = {
    val preR: PreResult[TypedAttr] = pre.transformTypedAttr(o)
    val r: MOption[TypedAttr] = if (preR.continue) {
      val o2: TypedAttr = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Option[PosInfo]] = transformOption(o2.posInfoOpt, transformPosInfo _)
      val r1: MOption[Option[Type]] = transformOption(o2.typeOpt, transformType _)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty)
        MSome(o2(posInfoOpt = r0.getOrElse(o2.posInfoOpt), typeOpt = r1.getOrElse(o2.typeOpt)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: TypedAttr = r.getOrElse(o)
    val postR: MOption[TypedAttr] = post.transformTypedAttr(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformResolvedAttr(o: ResolvedAttr): MOption[ResolvedAttr] = {
    val preR: PreResult[ResolvedAttr] = pre.transformResolvedAttr(o)
    val r: MOption[ResolvedAttr] = if (preR.continue) {
      val o2: ResolvedAttr = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Option[PosInfo]] = transformOption(o2.posInfoOpt, transformPosInfo _)
      val r1: MOption[Option[ResolvedInfo]] = transformOption(o2.resOpt, transformResolvedInfo _)
      val r2: MOption[Option[Type]] = transformOption(o2.typeOpt, transformType _)
      if (hasChanged | r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
        MSome(o2(posInfoOpt = r0.getOrElse(o2.posInfoOpt), resOpt = r1.getOrElse(o2.resOpt), typeOpt = r2.getOrElse(o2.typeOpt)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: ResolvedAttr = r.getOrElse(o)
    val postR: MOption[ResolvedAttr] = post.transformResolvedAttr(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformResolvedInfo(o: ResolvedInfo): MOption[ResolvedInfo] = {
    val preR: PreResult[ResolvedInfo] = pre.transformResolvedInfo(o)
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
    val postR: MOption[ResolvedInfo] = post.transformResolvedInfo(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformPosInfo(o: PosInfo): MOption[PosInfo] = {
    val preR: PreResult[PosInfo] = pre.transformPosInfo(o)
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
    val postR: MOption[PosInfo] = post.transformPosInfo(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

}