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

  @record class PreResult[T](continu: B,
                             resultOpt: MOption[T])

  def transformISZ[T](s: IS[Z, T], f: T => MOption[T]): MOption[IS[Z, T]] = {
    val s2: MS[Z, T] = s.toMS
    var changed: B = F
    for (i <- s2.indices) {
      val e: T = s(i)
      val r: MOption[T] = f(e)
      changed = changed || r.nonEmpty
      s2(i) = r.getOrElse(e)
    }
    if (changed) {
      return MSome(s2.toIS)
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

  val PreResultTopUnitProgram: PreResult[TopUnit] = PreResult(T, MNone())

  val PostResultTopUnitProgram: MOption[TopUnit] = MNone()

  val PreResultTopUnitSequentUnit: PreResult[TopUnit] = PreResult(T, MNone())

  val PostResultTopUnitSequentUnit: MOption[TopUnit] = MNone()

  val PreResultTopUnitTruthTableUnit: PreResult[TopUnit] = PreResult(T, MNone())

  val PostResultTopUnitTruthTableUnit: MOption[TopUnit] = MNone()

  val PreResultStmtImport: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtImport: MOption[Stmt] = MNone()

  val PreResultStmtImportImporter: PreResult[Stmt.Import.Importer] = PreResult(T, MNone())

  val PostResultStmtImportImporter: MOption[Stmt.Import.Importer] = MNone()

  val PreResultStmtImportMultiSelector: PreResult[Stmt.Import.Selector] = PreResult(T, MNone())

  val PostResultStmtImportMultiSelector: MOption[Stmt.Import.Selector] = MNone()

  val PreResultStmtImportWildcardSelector: PreResult[Stmt.Import.Selector] = PreResult(T, MNone())

  val PostResultStmtImportWildcardSelector: MOption[Stmt.Import.Selector] = MNone()

  val PreResultStmtImportNamedSelector: PreResult[Stmt.Import.NamedSelector] = PreResult(T, MNone())

  val PostResultStmtImportNamedSelector: MOption[Stmt.Import.NamedSelector] = MNone()

  val PreResultStmtVar: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtVar: MOption[Stmt] = MNone()

  val PreResultStmtVarPattern: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtVarPattern: MOption[Stmt] = MNone()

  val PreResultStmtSpecVar: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtSpecVar: MOption[Stmt] = MNone()

  val PreResultStmtMethod: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtMethod: MOption[Stmt] = MNone()

  val PreResultStmtExtMethod: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtExtMethod: MOption[Stmt] = MNone()

  val PreResultStmtSpecMethod: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtSpecMethod: MOption[Stmt] = MNone()

  val PreResultStmtEnum: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtEnum: MOption[Stmt] = MNone()

  val PreResultStmtSubZ: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtSubZ: MOption[Stmt] = MNone()

  val PreResultStmtObject: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtObject: MOption[Stmt] = MNone()

  val PreResultStmtSig: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtSig: MOption[Stmt] = MNone()

  val PreResultStmtAbstractDatatype: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtAbstractDatatype: MOption[Stmt] = MNone()

  val PreResultStmtTypeAlias: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtTypeAlias: MOption[Stmt] = MNone()

  val PreResultStmtAssign: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtAssign: MOption[Stmt] = MNone()

  val PreResultStmtBlock: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtBlock: MOption[Stmt] = MNone()

  val PreResultStmtIf: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtIf: MOption[Stmt] = MNone()

  val PreResultStmtMatch: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtMatch: MOption[Stmt] = MNone()

  val PreResultStmtWhile: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtWhile: MOption[Stmt] = MNone()

  val PreResultStmtDoWhile: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtDoWhile: MOption[Stmt] = MNone()

  val PreResultStmtFor: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtFor: MOption[Stmt] = MNone()

  val PreResultStmtReturn: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtReturn: MOption[Stmt] = MNone()

  val PreResultStmtLStmt: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtLStmt: MOption[Stmt] = MNone()

  val PreResultStmtExpr: PreResult[Stmt] = PreResult(T, MNone())

  val PostResultStmtExpr: MOption[Stmt] = MNone()

  val PreResultLClauseInvariants: PreResult[LClause] = PreResult(T, MNone())

  val PostResultLClauseInvariants: MOption[LClause] = MNone()

  val PreResultLClauseFacts: PreResult[LClause] = PreResult(T, MNone())

  val PostResultLClauseFacts: MOption[LClause] = MNone()

  val PreResultLClauseFact: PreResult[LClause.Fact] = PreResult(T, MNone())

  val PostResultLClauseFact: MOption[LClause.Fact] = MNone()

  val PreResultLClauseTheorems: PreResult[LClause] = PreResult(T, MNone())

  val PostResultLClauseTheorems: MOption[LClause] = MNone()

  val PreResultLClauseTheorem: PreResult[LClause.Theorem] = PreResult(T, MNone())

  val PostResultLClauseTheorem: MOption[LClause.Theorem] = MNone()

  val PreResultLClauseSequent: PreResult[LClause] = PreResult(T, MNone())

  val PostResultLClauseSequent: MOption[LClause] = MNone()

  val PreResultLClauseProof: PreResult[LClause] = PreResult(T, MNone())

  val PostResultLClauseProof: MOption[LClause] = MNone()

  val PreResultContractExp: PreResult[ContractExp] = PreResult(T, MNone())

  val PostResultContractExp: MOption[ContractExp] = MNone()

  val PreResultCase: PreResult[Case] = PreResult(T, MNone())

  val PostResultCase: MOption[Case] = MNone()

  val PreResultEnumGenRangeExpr: PreResult[EnumGen.Range] = PreResult(T, MNone())

  val PostResultEnumGenRangeExpr: MOption[EnumGen.Range] = MNone()

  val PreResultEnumGenRangeStep: PreResult[EnumGen.Range] = PreResult(T, MNone())

  val PostResultEnumGenRangeStep: MOption[EnumGen.Range] = MNone()

  val PreResultEnumGenFor: PreResult[EnumGen.For] = PreResult(T, MNone())

  val PostResultEnumGenFor: MOption[EnumGen.For] = MNone()

  val PreResultTypeNamed: PreResult[Type] = PreResult(T, MNone())

  val PostResultTypeNamed: MOption[Type] = MNone()

  val PreResultTypeFun: PreResult[Type] = PreResult(T, MNone())

  val PostResultTypeFun: MOption[Type] = MNone()

  val PreResultTypeTuple: PreResult[Type] = PreResult(T, MNone())

  val PostResultTypeTuple: MOption[Type] = MNone()

  val PreResultPatternLiteral: PreResult[Pattern] = PreResult(T, MNone())

  val PostResultPatternLiteral: MOption[Pattern] = MNone()

  val PreResultPatternLitInterpolate: PreResult[Pattern] = PreResult(T, MNone())

  val PostResultPatternLitInterpolate: MOption[Pattern] = MNone()

  val PreResultPatternRef: PreResult[Pattern] = PreResult(T, MNone())

  val PostResultPatternRef: MOption[Pattern] = MNone()

  val PreResultPatternVarBinding: PreResult[Pattern] = PreResult(T, MNone())

  val PostResultPatternVarBinding: MOption[Pattern] = MNone()

  val PreResultPatternWildcard: PreResult[Pattern] = PreResult(T, MNone())

  val PostResultPatternWildcard: MOption[Pattern] = MNone()

  val PreResultPatternSeqWildcard: PreResult[Pattern] = PreResult(T, MNone())

  val PostResultPatternSeqWildcard: MOption[Pattern] = MNone()

  val PreResultPatternStructure: PreResult[Pattern] = PreResult(T, MNone())

  val PostResultPatternStructure: MOption[Pattern] = MNone()

  val PreResultExpLitB: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpLitB: MOption[Exp] = MNone()

  val PreResultExpLitC: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpLitC: MOption[Exp] = MNone()

  val PreResultExpLitZ: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpLitZ: MOption[Exp] = MNone()

  val PreResultExpLitF32: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpLitF32: MOption[Exp] = MNone()

  val PreResultExpLitF64: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpLitF64: MOption[Exp] = MNone()

  val PreResultExpLitR: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpLitR: MOption[Exp] = MNone()

  val PreResultExpLitString: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpLitString: MOption[Exp] = MNone()

  val PreResultExpStringInterpolate: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpStringInterpolate: MOption[Exp] = MNone()

  val PreResultExpThis: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpThis: MOption[Exp] = MNone()

  val PreResultExpSuper: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpSuper: MOption[Exp] = MNone()

  val PreResultExpUnary: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpUnary: MOption[Exp] = MNone()

  val PreResultExpBinary: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpBinary: MOption[Exp] = MNone()

  val PreResultExpIdent: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpIdent: MOption[Exp] = MNone()

  val PreResultExpEta: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpEta: MOption[Exp] = MNone()

  val PreResultExpTuple: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpTuple: MOption[Exp] = MNone()

  val PreResultExpSelect: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpSelect: MOption[Exp] = MNone()

  val PreResultExpInvoke: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpInvoke: MOption[Exp] = MNone()

  val PreResultExpInvokeNamed: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpInvokeNamed: MOption[Exp] = MNone()

  val PreResultExpIf: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpIf: MOption[Exp] = MNone()

  val PreResultExpFunParam: PreResult[Exp.Fun.Param] = PreResult(T, MNone())

  val PostResultExpFunParam: MOption[Exp.Fun.Param] = MNone()

  val PreResultExpFun: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpFun: MOption[Exp] = MNone()

  val PreResultExpForYield: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpForYield: MOption[Exp] = MNone()

  val PreResultExpQuant: PreResult[Exp] = PreResult(T, MNone())

  val PostResultExpQuant: MOption[Exp] = MNone()

  val PreResultNamedArg: PreResult[NamedArg] = PreResult(T, MNone())

  val PostResultNamedArg: MOption[NamedArg] = MNone()

  val PreResultVarFragment: PreResult[VarFragment] = PreResult(T, MNone())

  val PostResultVarFragment: MOption[VarFragment] = MNone()

  val PreResultDomainType: PreResult[Domain] = PreResult(T, MNone())

  val PostResultDomainType: MOption[Domain] = MNone()

  val PreResultDomainRange: PreResult[Domain] = PreResult(T, MNone())

  val PostResultDomainRange: MOption[Domain] = MNone()

  val PreResultId: PreResult[Id] = PreResult(T, MNone())

  val PostResultId: MOption[Id] = MNone()

  val PreResultName: PreResult[Name] = PreResult(T, MNone())

  val PostResultName: MOption[Name] = MNone()

  val PreResultBody: PreResult[Body] = PreResult(T, MNone())

  val PostResultBody: MOption[Body] = MNone()

  val PreResultAbstractDatatypeParam: PreResult[AbstractDatatypeParam] = PreResult(T, MNone())

  val PostResultAbstractDatatypeParam: MOption[AbstractDatatypeParam] = MNone()

  val PreResultMethodSig: PreResult[MethodSig] = PreResult(T, MNone())

  val PostResultMethodSig: MOption[MethodSig] = MNone()

  val PreResultParam: PreResult[Param] = PreResult(T, MNone())

  val PostResultParam: MOption[Param] = MNone()

  val PreResultTypeParam: PreResult[TypeParam] = PreResult(T, MNone())

  val PostResultTypeParam: MOption[TypeParam] = MNone()

  val PreResultContract: PreResult[Contract] = PreResult(T, MNone())

  val PostResultContract: MOption[Contract] = MNone()

  val PreResultSubContract: PreResult[SubContract] = PreResult(T, MNone())

  val PostResultSubContract: MOption[SubContract] = MNone()

  val PreResultWhereDefVal: PreResult[WhereDef] = PreResult(T, MNone())

  val PostResultWhereDefVal: MOption[WhereDef] = MNone()

  val PreResultWhereDefDef: PreResult[WhereDef] = PreResult(T, MNone())

  val PostResultWhereDefDef: MOption[WhereDef] = MNone()

  val PreResultSpecDef: PreResult[SpecDef] = PreResult(T, MNone())

  val PostResultSpecDef: MOption[SpecDef] = MNone()

  val PreResultProofStepBasic: PreResult[ProofStep] = PreResult(T, MNone())

  val PostResultProofStepBasic: MOption[ProofStep] = MNone()

  val PreResultProofStepSubProof: PreResult[ProofStep] = PreResult(T, MNone())

  val PostResultProofStepSubProof: MOption[ProofStep] = MNone()

  val PreResultAssumeProofStepRegular: PreResult[AssumeProofStep] = PreResult(T, MNone())

  val PostResultAssumeProofStepRegular: MOption[AssumeProofStep] = MNone()

  val PreResultAssumeProofStepForallIntroAps: PreResult[AssumeProofStep] = PreResult(T, MNone())

  val PostResultAssumeProofStepForallIntroAps: MOption[AssumeProofStep] = MNone()

  val PreResultAssumeProofStepExistsElimAps: PreResult[AssumeProofStep] = PreResult(T, MNone())

  val PostResultAssumeProofStepExistsElimAps: MOption[AssumeProofStep] = MNone()

  val PreResultJustPremise: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustPremise: MOption[Just] = MNone()

  val PreResultJustAndIntro: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustAndIntro: MOption[Just] = MNone()

  val PreResultJustAndElim: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustAndElim: MOption[Just] = MNone()

  val PreResultJustOrIntro: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustOrIntro: MOption[Just] = MNone()

  val PreResultJustOrElim: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustOrElim: MOption[Just] = MNone()

  val PreResultJustImplyIntro: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustImplyIntro: MOption[Just] = MNone()

  val PreResultJustImplyElim: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustImplyElim: MOption[Just] = MNone()

  val PreResultJustNegIntro: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustNegIntro: MOption[Just] = MNone()

  val PreResultJustNegElim: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustNegElim: MOption[Just] = MNone()

  val PreResultJustBottomElim: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustBottomElim: MOption[Just] = MNone()

  val PreResultJustPbc: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustPbc: MOption[Just] = MNone()

  val PreResultJustForallIntro: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustForallIntro: MOption[Just] = MNone()

  val PreResultJustForallElim: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustForallElim: MOption[Just] = MNone()

  val PreResultJustExistsIntro: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustExistsIntro: MOption[Just] = MNone()

  val PreResultJustExistsElim: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustExistsElim: MOption[Just] = MNone()

  val PreResultJustFact: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustFact: MOption[Just] = MNone()

  val PreResultJustInvariant: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustInvariant: MOption[Just] = MNone()

  val PreResultJustSubst: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustSubst: MOption[Just] = MNone()

  val PreResultJustAuto: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustAuto: MOption[Just] = MNone()

  val PreResultJustCoq: PreResult[Just] = PreResult(T, MNone())

  val PostResultJustCoq: MOption[Just] = MNone()

  val PreResultTruthTableRow: PreResult[TruthTable.Row] = PreResult(T, MNone())

  val PostResultTruthTableRow: MOption[TruthTable.Row] = MNone()

  val PreResultTruthTableAssignment: PreResult[TruthTable.Assignment] = PreResult(T, MNone())

  val PostResultTruthTableAssignment: MOption[TruthTable.Assignment] = MNone()

  val PreResultTruthTableConclusionValidity: PreResult[TruthTable.Conclusion] = PreResult(T, MNone())

  val PostResultTruthTableConclusionValidity: MOption[TruthTable.Conclusion] = MNone()

  val PreResultTruthTableConclusionTautology: PreResult[TruthTable.Conclusion] = PreResult(T, MNone())

  val PostResultTruthTableConclusionTautology: MOption[TruthTable.Conclusion] = MNone()

  val PreResultTruthTableConclusionContradictory: PreResult[TruthTable.Conclusion] = PreResult(T, MNone())

  val PostResultTruthTableConclusionContradictory: MOption[TruthTable.Conclusion] = MNone()

  val PreResultTruthTableConclusionContingent: PreResult[TruthTable.Conclusion] = PreResult(T, MNone())

  val PostResultTruthTableConclusionContingent: MOption[TruthTable.Conclusion] = MNone()

  val PreResultTypedName: PreResult[Typed] = PreResult(T, MNone())

  val PostResultTypedName: MOption[Typed] = MNone()

  val PreResultTypedTuple: PreResult[Typed] = PreResult(T, MNone())

  val PostResultTypedTuple: MOption[Typed] = MNone()

  val PreResultTypedFun: PreResult[Typed] = PreResult(T, MNone())

  val PostResultTypedFun: MOption[Typed] = MNone()

  val PreResultTypedTypeVar: PreResult[Typed] = PreResult(T, MNone())

  val PostResultTypedTypeVar: MOption[Typed] = MNone()

  val PreResultTypedPackage: PreResult[Typed] = PreResult(T, MNone())

  val PostResultTypedPackage: MOption[Typed] = MNone()

  val PreResultTypedObject: PreResult[Typed] = PreResult(T, MNone())

  val PostResultTypedObject: MOption[Typed] = MNone()

  val PreResultTypedEnum: PreResult[Typed] = PreResult(T, MNone())

  val PostResultTypedEnum: MOption[Typed] = MNone()

  val PreResultTypedMethodSubst: PreResult[Typed.Method.Subst] = PreResult(T, MNone())

  val PostResultTypedMethodSubst: MOption[Typed.Method.Subst] = MNone()

  val PreResultTypedMethod: PreResult[Typed] = PreResult(T, MNone())

  val PostResultTypedMethod: MOption[Typed] = MNone()

  val PreResultTypedMethods: PreResult[Typed] = PreResult(T, MNone())

  val PostResultTypedMethods: MOption[Typed] = MNone()

  val PreResultAttr: PreResult[Attr] = PreResult(T, MNone())

  val PostResultAttr: MOption[Attr] = MNone()

  val PreResultTypedAttr: PreResult[TypedAttr] = PreResult(T, MNone())

  val PostResultTypedAttr: MOption[TypedAttr] = MNone()

  val PreResultResolvedAttr: PreResult[ResolvedAttr] = PreResult(T, MNone())

  val PostResultResolvedAttr: MOption[ResolvedAttr] = MNone()

  val PreResultResolvedInfoBuiltIn: PreResult[ResolvedInfo] = PreResult(T, MNone())

  val PostResultResolvedInfoBuiltIn: MOption[ResolvedInfo] = MNone()

  val PreResultResolvedInfoPackage: PreResult[ResolvedInfo] = PreResult(T, MNone())

  val PostResultResolvedInfoPackage: MOption[ResolvedInfo] = MNone()

  val PreResultResolvedInfoEnum: PreResult[ResolvedInfo] = PreResult(T, MNone())

  val PostResultResolvedInfoEnum: MOption[ResolvedInfo] = MNone()

  val PreResultResolvedInfoEnumElement: PreResult[ResolvedInfo] = PreResult(T, MNone())

  val PostResultResolvedInfoEnumElement: MOption[ResolvedInfo] = MNone()

  val PreResultResolvedInfoObject: PreResult[ResolvedInfo] = PreResult(T, MNone())

  val PostResultResolvedInfoObject: MOption[ResolvedInfo] = MNone()

  val PreResultResolvedInfoVar: PreResult[ResolvedInfo] = PreResult(T, MNone())

  val PostResultResolvedInfoVar: MOption[ResolvedInfo] = MNone()

  val PreResultResolvedInfoMethod: PreResult[ResolvedInfo] = PreResult(T, MNone())

  val PostResultResolvedInfoMethod: MOption[ResolvedInfo] = MNone()

  val PreResultResolvedInfoMethods: PreResult[ResolvedInfo] = PreResult(T, MNone())

  val PostResultResolvedInfoMethods: MOption[ResolvedInfo] = MNone()

  val PreResultResolvedInfoType: PreResult[ResolvedInfo] = PreResult(T, MNone())

  val PostResultResolvedInfoType: MOption[ResolvedInfo] = MNone()

  val PreResultResolvedInfoTuple: PreResult[ResolvedInfo] = PreResult(T, MNone())

  val PostResultResolvedInfoTuple: MOption[ResolvedInfo] = MNone()

  val PreResultResolvedInfoLocalVar: PreResult[ResolvedInfo] = PreResult(T, MNone())

  val PostResultResolvedInfoLocalVar: MOption[ResolvedInfo] = MNone()

}

import MTransformer._

@msig trait MTransformer {

  def preTopUnit(o: TopUnit): PreResult[TopUnit] = {
    o match {
      case o: TopUnit.Program => return preTopUnitProgram(o)
      case o: TopUnit.SequentUnit => return preTopUnitSequentUnit(o)
      case o: TopUnit.TruthTableUnit => return preTopUnitTruthTableUnit(o)
    }
  }

  def preTopUnitProgram(o: TopUnit.Program): PreResult[TopUnit] = {
    return PreResultTopUnitProgram
  }

  def preTopUnitSequentUnit(o: TopUnit.SequentUnit): PreResult[TopUnit] = {
    return PreResultTopUnitSequentUnit
  }

  def preTopUnitTruthTableUnit(o: TopUnit.TruthTableUnit): PreResult[TopUnit] = {
    return PreResultTopUnitTruthTableUnit
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
      case o: Stmt.SubZ => return preStmtSubZ(o)
      case o: Stmt.Object => return preStmtObject(o)
      case o: Stmt.Sig => return preStmtSig(o)
      case o: Stmt.AbstractDatatype => return preStmtAbstractDatatype(o)
      case o: Stmt.TypeAlias => return preStmtTypeAlias(o)
      case o: Stmt.Assign => return preStmtAssign(o)
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

  def preAssignExp(o: AssignExp): PreResult[AssignExp] = {
    o match {
      case o: Stmt.Block =>
        val r: PreResult[AssignExp] = preStmtBlock(o) match {
         case PreResult(continu, MSome(r: AssignExp)) => PreResult(continu, MSome[AssignExp](r))
         case PreResult(_, MSome(_)) => halt("Can only produce object of type AssignExp")
         case PreResult(continu, _) => PreResult(continu, MNone[AssignExp]())
        }
        return r
      case o: Stmt.If =>
        val r: PreResult[AssignExp] = preStmtIf(o) match {
         case PreResult(continu, MSome(r: AssignExp)) => PreResult(continu, MSome[AssignExp](r))
         case PreResult(_, MSome(_)) => halt("Can only produce object of type AssignExp")
         case PreResult(continu, _) => PreResult(continu, MNone[AssignExp]())
        }
        return r
      case o: Stmt.Match =>
        val r: PreResult[AssignExp] = preStmtMatch(o) match {
         case PreResult(continu, MSome(r: AssignExp)) => PreResult(continu, MSome[AssignExp](r))
         case PreResult(_, MSome(_)) => halt("Can only produce object of type AssignExp")
         case PreResult(continu, _) => PreResult(continu, MNone[AssignExp]())
        }
        return r
      case o: Stmt.Return =>
        val r: PreResult[AssignExp] = preStmtReturn(o) match {
         case PreResult(continu, MSome(r: AssignExp)) => PreResult(continu, MSome[AssignExp](r))
         case PreResult(_, MSome(_)) => halt("Can only produce object of type AssignExp")
         case PreResult(continu, _) => PreResult(continu, MNone[AssignExp]())
        }
        return r
      case o: Stmt.Expr =>
        val r: PreResult[AssignExp] = preStmtExpr(o) match {
         case PreResult(continu, MSome(r: AssignExp)) => PreResult(continu, MSome[AssignExp](r))
         case PreResult(_, MSome(_)) => halt("Can only produce object of type AssignExp")
         case PreResult(continu, _) => PreResult(continu, MNone[AssignExp]())
        }
        return r
    }
  }

  def preStmtImport(o: Stmt.Import): PreResult[Stmt] = {
    return PreResultStmtImport
  }

  def preStmtImportImporter(o: Stmt.Import.Importer): PreResult[Stmt.Import.Importer] = {
    return PreResultStmtImportImporter
  }

  def preStmtImportSelector(o: Stmt.Import.Selector): PreResult[Stmt.Import.Selector] = {
    o match {
      case o: Stmt.Import.MultiSelector => return preStmtImportMultiSelector(o)
      case o: Stmt.Import.WildcardSelector => return preStmtImportWildcardSelector(o)
    }
  }

  def preStmtImportMultiSelector(o: Stmt.Import.MultiSelector): PreResult[Stmt.Import.Selector] = {
    return PreResultStmtImportMultiSelector
  }

  def preStmtImportWildcardSelector(o: Stmt.Import.WildcardSelector): PreResult[Stmt.Import.Selector] = {
    return PreResultStmtImportWildcardSelector
  }

  def preStmtImportNamedSelector(o: Stmt.Import.NamedSelector): PreResult[Stmt.Import.NamedSelector] = {
    return PreResultStmtImportNamedSelector
  }

  def preStmtVar(o: Stmt.Var): PreResult[Stmt] = {
    return PreResultStmtVar
  }

  def preStmtVarPattern(o: Stmt.VarPattern): PreResult[Stmt] = {
    return PreResultStmtVarPattern
  }

  def preStmtSpecVar(o: Stmt.SpecVar): PreResult[Stmt] = {
    return PreResultStmtSpecVar
  }

  def preStmtMethod(o: Stmt.Method): PreResult[Stmt] = {
    return PreResultStmtMethod
  }

  def preStmtExtMethod(o: Stmt.ExtMethod): PreResult[Stmt] = {
    return PreResultStmtExtMethod
  }

  def preStmtSpecMethod(o: Stmt.SpecMethod): PreResult[Stmt] = {
    return PreResultStmtSpecMethod
  }

  def preStmtEnum(o: Stmt.Enum): PreResult[Stmt] = {
    return PreResultStmtEnum
  }

  def preStmtSubZ(o: Stmt.SubZ): PreResult[Stmt] = {
    return PreResultStmtSubZ
  }

  def preStmtObject(o: Stmt.Object): PreResult[Stmt] = {
    return PreResultStmtObject
  }

  def preStmtSig(o: Stmt.Sig): PreResult[Stmt] = {
    return PreResultStmtSig
  }

  def preStmtAbstractDatatype(o: Stmt.AbstractDatatype): PreResult[Stmt] = {
    return PreResultStmtAbstractDatatype
  }

  def preStmtTypeAlias(o: Stmt.TypeAlias): PreResult[Stmt] = {
    return PreResultStmtTypeAlias
  }

  def preStmtAssign(o: Stmt.Assign): PreResult[Stmt] = {
    return PreResultStmtAssign
  }

  def preStmtBlock(o: Stmt.Block): PreResult[Stmt] = {
    return PreResultStmtBlock
  }

  def preStmtIf(o: Stmt.If): PreResult[Stmt] = {
    return PreResultStmtIf
  }

  def preStmtMatch(o: Stmt.Match): PreResult[Stmt] = {
    return PreResultStmtMatch
  }

  def preStmtWhile(o: Stmt.While): PreResult[Stmt] = {
    return PreResultStmtWhile
  }

  def preStmtDoWhile(o: Stmt.DoWhile): PreResult[Stmt] = {
    return PreResultStmtDoWhile
  }

  def preStmtFor(o: Stmt.For): PreResult[Stmt] = {
    return PreResultStmtFor
  }

  def preStmtReturn(o: Stmt.Return): PreResult[Stmt] = {
    return PreResultStmtReturn
  }

  def preStmtLStmt(o: Stmt.LStmt): PreResult[Stmt] = {
    return PreResultStmtLStmt
  }

  def preStmtExpr(o: Stmt.Expr): PreResult[Stmt] = {
    return PreResultStmtExpr
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
    return PreResultLClauseInvariants
  }

  def preLClauseFacts(o: LClause.Facts): PreResult[LClause] = {
    return PreResultLClauseFacts
  }

  def preLClauseFact(o: LClause.Fact): PreResult[LClause.Fact] = {
    return PreResultLClauseFact
  }

  def preLClauseTheorems(o: LClause.Theorems): PreResult[LClause] = {
    return PreResultLClauseTheorems
  }

  def preLClauseTheorem(o: LClause.Theorem): PreResult[LClause.Theorem] = {
    return PreResultLClauseTheorem
  }

  def preLClauseSequent(o: LClause.Sequent): PreResult[LClause] = {
    return PreResultLClauseSequent
  }

  def preLClauseProof(o: LClause.Proof): PreResult[LClause] = {
    return PreResultLClauseProof
  }

  def preContractExp(o: ContractExp): PreResult[ContractExp] = {
    return PreResultContractExp
  }

  def preCase(o: Case): PreResult[Case] = {
    return PreResultCase
  }

  def preEnumGenRange(o: EnumGen.Range): PreResult[EnumGen.Range] = {
    o match {
      case o: EnumGen.Range.Expr => return preEnumGenRangeExpr(o)
      case o: EnumGen.Range.Step => return preEnumGenRangeStep(o)
    }
  }

  def preEnumGenRangeExpr(o: EnumGen.Range.Expr): PreResult[EnumGen.Range] = {
    return PreResultEnumGenRangeExpr
  }

  def preEnumGenRangeStep(o: EnumGen.Range.Step): PreResult[EnumGen.Range] = {
    return PreResultEnumGenRangeStep
  }

  def preEnumGenFor(o: EnumGen.For): PreResult[EnumGen.For] = {
    return PreResultEnumGenFor
  }

  def preType(o: Type): PreResult[Type] = {
    o match {
      case o: Type.Named => return preTypeNamed(o)
      case o: Type.Fun => return preTypeFun(o)
      case o: Type.Tuple => return preTypeTuple(o)
    }
  }

  def preTypeNamed(o: Type.Named): PreResult[Type] = {
    return PreResultTypeNamed
  }

  def preTypeFun(o: Type.Fun): PreResult[Type] = {
    return PreResultTypeFun
  }

  def preTypeTuple(o: Type.Tuple): PreResult[Type] = {
    return PreResultTypeTuple
  }

  def prePattern(o: Pattern): PreResult[Pattern] = {
    o match {
      case o: Pattern.Literal => return prePatternLiteral(o)
      case o: Pattern.LitInterpolate => return prePatternLitInterpolate(o)
      case o: Pattern.Ref => return prePatternRef(o)
      case o: Pattern.VarBinding => return prePatternVarBinding(o)
      case o: Pattern.Wildcard => return prePatternWildcard(o)
      case o: Pattern.SeqWildcard => return prePatternSeqWildcard(o)
      case o: Pattern.Structure => return prePatternStructure(o)
    }
  }

  def prePatternLiteral(o: Pattern.Literal): PreResult[Pattern] = {
    return PreResultPatternLiteral
  }

  def prePatternLitInterpolate(o: Pattern.LitInterpolate): PreResult[Pattern] = {
    return PreResultPatternLitInterpolate
  }

  def prePatternRef(o: Pattern.Ref): PreResult[Pattern] = {
    return PreResultPatternRef
  }

  def prePatternVarBinding(o: Pattern.VarBinding): PreResult[Pattern] = {
    return PreResultPatternVarBinding
  }

  def prePatternWildcard(o: Pattern.Wildcard): PreResult[Pattern] = {
    return PreResultPatternWildcard
  }

  def prePatternSeqWildcard(o: Pattern.SeqWildcard): PreResult[Pattern] = {
    return PreResultPatternSeqWildcard
  }

  def prePatternStructure(o: Pattern.Structure): PreResult[Pattern] = {
    return PreResultPatternStructure
  }

  def preExp(o: Exp): PreResult[Exp] = {
    o match {
      case o: Exp.LitB => return preExpLitB(o)
      case o: Exp.LitC => return preExpLitC(o)
      case o: Exp.LitZ => return preExpLitZ(o)
      case o: Exp.LitF32 => return preExpLitF32(o)
      case o: Exp.LitF64 => return preExpLitF64(o)
      case o: Exp.LitR => return preExpLitR(o)
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

  def preLit(o: Lit): PreResult[Lit] = {
    o match {
      case o: Exp.LitB =>
        val r: PreResult[Lit] = preExpLitB(o) match {
         case PreResult(continu, MSome(r: Lit)) => PreResult(continu, MSome[Lit](r))
         case PreResult(_, MSome(_)) => halt("Can only produce object of type Lit")
         case PreResult(continu, _) => PreResult(continu, MNone[Lit]())
        }
        return r
      case o: Exp.LitC =>
        val r: PreResult[Lit] = preExpLitC(o) match {
         case PreResult(continu, MSome(r: Lit)) => PreResult(continu, MSome[Lit](r))
         case PreResult(_, MSome(_)) => halt("Can only produce object of type Lit")
         case PreResult(continu, _) => PreResult(continu, MNone[Lit]())
        }
        return r
      case o: Exp.LitZ =>
        val r: PreResult[Lit] = preExpLitZ(o) match {
         case PreResult(continu, MSome(r: Lit)) => PreResult(continu, MSome[Lit](r))
         case PreResult(_, MSome(_)) => halt("Can only produce object of type Lit")
         case PreResult(continu, _) => PreResult(continu, MNone[Lit]())
        }
        return r
      case o: Exp.LitF32 =>
        val r: PreResult[Lit] = preExpLitF32(o) match {
         case PreResult(continu, MSome(r: Lit)) => PreResult(continu, MSome[Lit](r))
         case PreResult(_, MSome(_)) => halt("Can only produce object of type Lit")
         case PreResult(continu, _) => PreResult(continu, MNone[Lit]())
        }
        return r
      case o: Exp.LitF64 =>
        val r: PreResult[Lit] = preExpLitF64(o) match {
         case PreResult(continu, MSome(r: Lit)) => PreResult(continu, MSome[Lit](r))
         case PreResult(_, MSome(_)) => halt("Can only produce object of type Lit")
         case PreResult(continu, _) => PreResult(continu, MNone[Lit]())
        }
        return r
      case o: Exp.LitR =>
        val r: PreResult[Lit] = preExpLitR(o) match {
         case PreResult(continu, MSome(r: Lit)) => PreResult(continu, MSome[Lit](r))
         case PreResult(_, MSome(_)) => halt("Can only produce object of type Lit")
         case PreResult(continu, _) => PreResult(continu, MNone[Lit]())
        }
        return r
      case o: Exp.LitString =>
        val r: PreResult[Lit] = preExpLitString(o) match {
         case PreResult(continu, MSome(r: Lit)) => PreResult(continu, MSome[Lit](r))
         case PreResult(_, MSome(_)) => halt("Can only produce object of type Lit")
         case PreResult(continu, _) => PreResult(continu, MNone[Lit]())
        }
        return r
    }
  }

  def preExpLitB(o: Exp.LitB): PreResult[Exp] = {
    return PreResultExpLitB
  }

  def preExpLitC(o: Exp.LitC): PreResult[Exp] = {
    return PreResultExpLitC
  }

  def preExpLitZ(o: Exp.LitZ): PreResult[Exp] = {
    return PreResultExpLitZ
  }

  def preExpLitF32(o: Exp.LitF32): PreResult[Exp] = {
    return PreResultExpLitF32
  }

  def preExpLitF64(o: Exp.LitF64): PreResult[Exp] = {
    return PreResultExpLitF64
  }

  def preExpLitR(o: Exp.LitR): PreResult[Exp] = {
    return PreResultExpLitR
  }

  def preExpLitString(o: Exp.LitString): PreResult[Exp] = {
    return PreResultExpLitString
  }

  def preExpStringInterpolate(o: Exp.StringInterpolate): PreResult[Exp] = {
    return PreResultExpStringInterpolate
  }

  def preExpThis(o: Exp.This): PreResult[Exp] = {
    return PreResultExpThis
  }

  def preExpSuper(o: Exp.Super): PreResult[Exp] = {
    return PreResultExpSuper
  }

  def preExpUnary(o: Exp.Unary): PreResult[Exp] = {
    return PreResultExpUnary
  }

  def preExpRef(o: Exp.Ref): PreResult[Exp.Ref] = {
    o match {
      case o: Exp.Ident =>
        val r: PreResult[Exp.Ref] = preExpIdent(o) match {
         case PreResult(continu, MSome(r: Exp.Ref)) => PreResult(continu, MSome[Exp.Ref](r))
         case PreResult(_, MSome(_)) => halt("Can only produce object of type Exp.Ref")
         case PreResult(continu, _) => PreResult(continu, MNone[Exp.Ref]())
        }
        return r
      case o: Exp.Select =>
        val r: PreResult[Exp.Ref] = preExpSelect(o) match {
         case PreResult(continu, MSome(r: Exp.Ref)) => PreResult(continu, MSome[Exp.Ref](r))
         case PreResult(_, MSome(_)) => halt("Can only produce object of type Exp.Ref")
         case PreResult(continu, _) => PreResult(continu, MNone[Exp.Ref]())
        }
        return r
    }
  }

  def preExpBinary(o: Exp.Binary): PreResult[Exp] = {
    return PreResultExpBinary
  }

  def preExpIdent(o: Exp.Ident): PreResult[Exp] = {
    return PreResultExpIdent
  }

  def preExpEta(o: Exp.Eta): PreResult[Exp] = {
    return PreResultExpEta
  }

  def preExpTuple(o: Exp.Tuple): PreResult[Exp] = {
    return PreResultExpTuple
  }

  def preExpSelect(o: Exp.Select): PreResult[Exp] = {
    return PreResultExpSelect
  }

  def preExpInvoke(o: Exp.Invoke): PreResult[Exp] = {
    return PreResultExpInvoke
  }

  def preExpInvokeNamed(o: Exp.InvokeNamed): PreResult[Exp] = {
    return PreResultExpInvokeNamed
  }

  def preExpIf(o: Exp.If): PreResult[Exp] = {
    return PreResultExpIf
  }

  def preExpFunParam(o: Exp.Fun.Param): PreResult[Exp.Fun.Param] = {
    return PreResultExpFunParam
  }

  def preExpFun(o: Exp.Fun): PreResult[Exp] = {
    return PreResultExpFun
  }

  def preExpForYield(o: Exp.ForYield): PreResult[Exp] = {
    return PreResultExpForYield
  }

  def preExpQuant(o: Exp.Quant): PreResult[Exp] = {
    return PreResultExpQuant
  }

  def preNamedArg(o: NamedArg): PreResult[NamedArg] = {
    return PreResultNamedArg
  }

  def preVarFragment(o: VarFragment): PreResult[VarFragment] = {
    return PreResultVarFragment
  }

  def preDomain(o: Domain): PreResult[Domain] = {
    o match {
      case o: Domain.Type => return preDomainType(o)
      case o: Domain.Range => return preDomainRange(o)
    }
  }

  def preDomainType(o: Domain.Type): PreResult[Domain] = {
    return PreResultDomainType
  }

  def preDomainRange(o: Domain.Range): PreResult[Domain] = {
    return PreResultDomainRange
  }

  def preId(o: Id): PreResult[Id] = {
    return PreResultId
  }

  def preName(o: Name): PreResult[Name] = {
    return PreResultName
  }

  def preBody(o: Body): PreResult[Body] = {
    return PreResultBody
  }

  def preAbstractDatatypeParam(o: AbstractDatatypeParam): PreResult[AbstractDatatypeParam] = {
    return PreResultAbstractDatatypeParam
  }

  def preMethodSig(o: MethodSig): PreResult[MethodSig] = {
    return PreResultMethodSig
  }

  def preParam(o: Param): PreResult[Param] = {
    return PreResultParam
  }

  def preTypeParam(o: TypeParam): PreResult[TypeParam] = {
    return PreResultTypeParam
  }

  def preContract(o: Contract): PreResult[Contract] = {
    return PreResultContract
  }

  def preSubContract(o: SubContract): PreResult[SubContract] = {
    return PreResultSubContract
  }

  def preWhereDef(o: WhereDef): PreResult[WhereDef] = {
    o match {
      case o: WhereDef.Val => return preWhereDefVal(o)
      case o: WhereDef.Def => return preWhereDefDef(o)
    }
  }

  def preWhereDefVal(o: WhereDef.Val): PreResult[WhereDef] = {
    return PreResultWhereDefVal
  }

  def preWhereDefDef(o: WhereDef.Def): PreResult[WhereDef] = {
    return PreResultWhereDefDef
  }

  def preSpecDef(o: SpecDef): PreResult[SpecDef] = {
    return PreResultSpecDef
  }

  def preProofStep(o: ProofStep): PreResult[ProofStep] = {
    o match {
      case o: ProofStep.Basic => return preProofStepBasic(o)
      case o: ProofStep.SubProof => return preProofStepSubProof(o)
    }
  }

  def preProofStepBasic(o: ProofStep.Basic): PreResult[ProofStep] = {
    return PreResultProofStepBasic
  }

  def preProofStepSubProof(o: ProofStep.SubProof): PreResult[ProofStep] = {
    return PreResultProofStepSubProof
  }

  def preAssumeProofStep(o: AssumeProofStep): PreResult[AssumeProofStep] = {
    o match {
      case o: AssumeProofStep.Regular => return preAssumeProofStepRegular(o)
      case o: AssumeProofStep.ForallIntroAps => return preAssumeProofStepForallIntroAps(o)
      case o: AssumeProofStep.ExistsElimAps => return preAssumeProofStepExistsElimAps(o)
    }
  }

  def preAssumeProofStepRegular(o: AssumeProofStep.Regular): PreResult[AssumeProofStep] = {
    return PreResultAssumeProofStepRegular
  }

  def preAssumeProofStepForallIntroAps(o: AssumeProofStep.ForallIntroAps): PreResult[AssumeProofStep] = {
    return PreResultAssumeProofStepForallIntroAps
  }

  def preAssumeProofStepExistsElimAps(o: AssumeProofStep.ExistsElimAps): PreResult[AssumeProofStep] = {
    return PreResultAssumeProofStepExistsElimAps
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
    return PreResultJustPremise
  }

  def preJustAndIntro(o: Just.AndIntro): PreResult[Just] = {
    return PreResultJustAndIntro
  }

  def preJustAndElim(o: Just.AndElim): PreResult[Just] = {
    return PreResultJustAndElim
  }

  def preJustOrIntro(o: Just.OrIntro): PreResult[Just] = {
    return PreResultJustOrIntro
  }

  def preJustOrElim(o: Just.OrElim): PreResult[Just] = {
    return PreResultJustOrElim
  }

  def preJustImplyIntro(o: Just.ImplyIntro): PreResult[Just] = {
    return PreResultJustImplyIntro
  }

  def preJustImplyElim(o: Just.ImplyElim): PreResult[Just] = {
    return PreResultJustImplyElim
  }

  def preJustNegIntro(o: Just.NegIntro): PreResult[Just] = {
    return PreResultJustNegIntro
  }

  def preJustNegElim(o: Just.NegElim): PreResult[Just] = {
    return PreResultJustNegElim
  }

  def preJustBottomElim(o: Just.BottomElim): PreResult[Just] = {
    return PreResultJustBottomElim
  }

  def preJustPbc(o: Just.Pbc): PreResult[Just] = {
    return PreResultJustPbc
  }

  def preJustForallIntro(o: Just.ForallIntro): PreResult[Just] = {
    return PreResultJustForallIntro
  }

  def preJustForallElim(o: Just.ForallElim): PreResult[Just] = {
    return PreResultJustForallElim
  }

  def preJustExistsIntro(o: Just.ExistsIntro): PreResult[Just] = {
    return PreResultJustExistsIntro
  }

  def preJustExistsElim(o: Just.ExistsElim): PreResult[Just] = {
    return PreResultJustExistsElim
  }

  def preJustFact(o: Just.Fact): PreResult[Just] = {
    return PreResultJustFact
  }

  def preJustInvariant(o: Just.Invariant): PreResult[Just] = {
    return PreResultJustInvariant
  }

  def preJustSubst(o: Just.Subst): PreResult[Just] = {
    return PreResultJustSubst
  }

  def preJustAuto(o: Just.Auto): PreResult[Just] = {
    return PreResultJustAuto
  }

  def preJustCoq(o: Just.Coq): PreResult[Just] = {
    return PreResultJustCoq
  }

  def preTruthTableRow(o: TruthTable.Row): PreResult[TruthTable.Row] = {
    return PreResultTruthTableRow
  }

  def preTruthTableAssignment(o: TruthTable.Assignment): PreResult[TruthTable.Assignment] = {
    return PreResultTruthTableAssignment
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
    return PreResultTruthTableConclusionValidity
  }

  def preTruthTableConclusionTautology(o: TruthTable.Conclusion.Tautology): PreResult[TruthTable.Conclusion] = {
    return PreResultTruthTableConclusionTautology
  }

  def preTruthTableConclusionContradictory(o: TruthTable.Conclusion.Contradictory): PreResult[TruthTable.Conclusion] = {
    return PreResultTruthTableConclusionContradictory
  }

  def preTruthTableConclusionContingent(o: TruthTable.Conclusion.Contingent): PreResult[TruthTable.Conclusion] = {
    return PreResultTruthTableConclusionContingent
  }

  def preTyped(o: Typed): PreResult[Typed] = {
    o match {
      case o: Typed.Name => return preTypedName(o)
      case o: Typed.Tuple => return preTypedTuple(o)
      case o: Typed.Fun => return preTypedFun(o)
      case o: Typed.TypeVar => return preTypedTypeVar(o)
      case o: Typed.Package => return preTypedPackage(o)
      case o: Typed.Object => return preTypedObject(o)
      case o: Typed.Enum => return preTypedEnum(o)
      case o: Typed.Method => return preTypedMethod(o)
      case o: Typed.Methods => return preTypedMethods(o)
    }
  }

  def preTypedName(o: Typed.Name): PreResult[Typed] = {
    return PreResultTypedName
  }

  def preTypedTuple(o: Typed.Tuple): PreResult[Typed] = {
    return PreResultTypedTuple
  }

  def preTypedFun(o: Typed.Fun): PreResult[Typed] = {
    return PreResultTypedFun
  }

  def preTypedTypeVar(o: Typed.TypeVar): PreResult[Typed] = {
    return PreResultTypedTypeVar
  }

  def preTypedPackage(o: Typed.Package): PreResult[Typed] = {
    return PreResultTypedPackage
  }

  def preTypedObject(o: Typed.Object): PreResult[Typed] = {
    return PreResultTypedObject
  }

  def preTypedEnum(o: Typed.Enum): PreResult[Typed] = {
    return PreResultTypedEnum
  }

  def preTypedMethodSubst(o: Typed.Method.Subst): PreResult[Typed.Method.Subst] = {
    return PreResultTypedMethodSubst
  }

  def preTypedMethod(o: Typed.Method): PreResult[Typed] = {
    return PreResultTypedMethod
  }

  def preTypedMethods(o: Typed.Methods): PreResult[Typed] = {
    return PreResultTypedMethods
  }

  def preAttr(o: Attr): PreResult[Attr] = {
    return PreResultAttr
  }

  def preTypedAttr(o: TypedAttr): PreResult[TypedAttr] = {
    return PreResultTypedAttr
  }

  def preResolvedAttr(o: ResolvedAttr): PreResult[ResolvedAttr] = {
    return PreResultResolvedAttr
  }

  def preResolvedInfo(o: ResolvedInfo): PreResult[ResolvedInfo] = {
    o match {
      case o: ResolvedInfo.BuiltIn => return preResolvedInfoBuiltIn(o)
      case o: ResolvedInfo.Package => return preResolvedInfoPackage(o)
      case o: ResolvedInfo.Enum => return preResolvedInfoEnum(o)
      case o: ResolvedInfo.EnumElement => return preResolvedInfoEnumElement(o)
      case o: ResolvedInfo.Object => return preResolvedInfoObject(o)
      case o: ResolvedInfo.Var => return preResolvedInfoVar(o)
      case o: ResolvedInfo.Method => return preResolvedInfoMethod(o)
      case o: ResolvedInfo.Methods => return preResolvedInfoMethods(o)
      case o: ResolvedInfo.Type => return preResolvedInfoType(o)
      case o: ResolvedInfo.Tuple => return preResolvedInfoTuple(o)
      case o: ResolvedInfo.LocalVar => return preResolvedInfoLocalVar(o)
    }
  }

  def preResolvedInfoBuiltIn(o: ResolvedInfo.BuiltIn): PreResult[ResolvedInfo] = {
    return PreResultResolvedInfoBuiltIn
  }

  def preResolvedInfoPackage(o: ResolvedInfo.Package): PreResult[ResolvedInfo] = {
    return PreResultResolvedInfoPackage
  }

  def preResolvedInfoEnum(o: ResolvedInfo.Enum): PreResult[ResolvedInfo] = {
    return PreResultResolvedInfoEnum
  }

  def preResolvedInfoEnumElement(o: ResolvedInfo.EnumElement): PreResult[ResolvedInfo] = {
    return PreResultResolvedInfoEnumElement
  }

  def preResolvedInfoObject(o: ResolvedInfo.Object): PreResult[ResolvedInfo] = {
    return PreResultResolvedInfoObject
  }

  def preResolvedInfoVar(o: ResolvedInfo.Var): PreResult[ResolvedInfo] = {
    return PreResultResolvedInfoVar
  }

  def preResolvedInfoMethod(o: ResolvedInfo.Method): PreResult[ResolvedInfo] = {
    return PreResultResolvedInfoMethod
  }

  def preResolvedInfoMethods(o: ResolvedInfo.Methods): PreResult[ResolvedInfo] = {
    return PreResultResolvedInfoMethods
  }

  def preResolvedInfoType(o: ResolvedInfo.Type): PreResult[ResolvedInfo] = {
    return PreResultResolvedInfoType
  }

  def preResolvedInfoTuple(o: ResolvedInfo.Tuple): PreResult[ResolvedInfo] = {
    return PreResultResolvedInfoTuple
  }

  def preResolvedInfoLocalVar(o: ResolvedInfo.LocalVar): PreResult[ResolvedInfo] = {
    return PreResultResolvedInfoLocalVar
  }

  def postTopUnit(o: TopUnit): MOption[TopUnit] = {
    o match {
      case o: TopUnit.Program => return postTopUnitProgram(o)
      case o: TopUnit.SequentUnit => return postTopUnitSequentUnit(o)
      case o: TopUnit.TruthTableUnit => return postTopUnitTruthTableUnit(o)
    }
  }

  def postTopUnitProgram(o: TopUnit.Program): MOption[TopUnit] = {
    return PostResultTopUnitProgram
  }

  def postTopUnitSequentUnit(o: TopUnit.SequentUnit): MOption[TopUnit] = {
    return PostResultTopUnitSequentUnit
  }

  def postTopUnitTruthTableUnit(o: TopUnit.TruthTableUnit): MOption[TopUnit] = {
    return PostResultTopUnitTruthTableUnit
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
      case o: Stmt.SubZ => return postStmtSubZ(o)
      case o: Stmt.Object => return postStmtObject(o)
      case o: Stmt.Sig => return postStmtSig(o)
      case o: Stmt.AbstractDatatype => return postStmtAbstractDatatype(o)
      case o: Stmt.TypeAlias => return postStmtTypeAlias(o)
      case o: Stmt.Assign => return postStmtAssign(o)
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

  def postAssignExp(o: AssignExp): MOption[AssignExp] = {
    o match {
      case o: Stmt.Block =>
        val r: MOption[AssignExp] = postStmtBlock(o) match {
         case MSome(result: AssignExp) => MSome[AssignExp](result)
         case MSome(_) => halt("Can only produce object of type AssignExp")
         case _ => MNone[AssignExp]()
        }
        return r
      case o: Stmt.If =>
        val r: MOption[AssignExp] = postStmtIf(o) match {
         case MSome(result: AssignExp) => MSome[AssignExp](result)
         case MSome(_) => halt("Can only produce object of type AssignExp")
         case _ => MNone[AssignExp]()
        }
        return r
      case o: Stmt.Match =>
        val r: MOption[AssignExp] = postStmtMatch(o) match {
         case MSome(result: AssignExp) => MSome[AssignExp](result)
         case MSome(_) => halt("Can only produce object of type AssignExp")
         case _ => MNone[AssignExp]()
        }
        return r
      case o: Stmt.Return =>
        val r: MOption[AssignExp] = postStmtReturn(o) match {
         case MSome(result: AssignExp) => MSome[AssignExp](result)
         case MSome(_) => halt("Can only produce object of type AssignExp")
         case _ => MNone[AssignExp]()
        }
        return r
      case o: Stmt.Expr =>
        val r: MOption[AssignExp] = postStmtExpr(o) match {
         case MSome(result: AssignExp) => MSome[AssignExp](result)
         case MSome(_) => halt("Can only produce object of type AssignExp")
         case _ => MNone[AssignExp]()
        }
        return r
    }
  }

  def postStmtImport(o: Stmt.Import): MOption[Stmt] = {
    return PostResultStmtImport
  }

  def postStmtImportImporter(o: Stmt.Import.Importer): MOption[Stmt.Import.Importer] = {
    return PostResultStmtImportImporter
  }

  def postStmtImportSelector(o: Stmt.Import.Selector): MOption[Stmt.Import.Selector] = {
    o match {
      case o: Stmt.Import.MultiSelector => return postStmtImportMultiSelector(o)
      case o: Stmt.Import.WildcardSelector => return postStmtImportWildcardSelector(o)
    }
  }

  def postStmtImportMultiSelector(o: Stmt.Import.MultiSelector): MOption[Stmt.Import.Selector] = {
    return PostResultStmtImportMultiSelector
  }

  def postStmtImportWildcardSelector(o: Stmt.Import.WildcardSelector): MOption[Stmt.Import.Selector] = {
    return PostResultStmtImportWildcardSelector
  }

  def postStmtImportNamedSelector(o: Stmt.Import.NamedSelector): MOption[Stmt.Import.NamedSelector] = {
    return PostResultStmtImportNamedSelector
  }

  def postStmtVar(o: Stmt.Var): MOption[Stmt] = {
    return PostResultStmtVar
  }

  def postStmtVarPattern(o: Stmt.VarPattern): MOption[Stmt] = {
    return PostResultStmtVarPattern
  }

  def postStmtSpecVar(o: Stmt.SpecVar): MOption[Stmt] = {
    return PostResultStmtSpecVar
  }

  def postStmtMethod(o: Stmt.Method): MOption[Stmt] = {
    return PostResultStmtMethod
  }

  def postStmtExtMethod(o: Stmt.ExtMethod): MOption[Stmt] = {
    return PostResultStmtExtMethod
  }

  def postStmtSpecMethod(o: Stmt.SpecMethod): MOption[Stmt] = {
    return PostResultStmtSpecMethod
  }

  def postStmtEnum(o: Stmt.Enum): MOption[Stmt] = {
    return PostResultStmtEnum
  }

  def postStmtSubZ(o: Stmt.SubZ): MOption[Stmt] = {
    return PostResultStmtSubZ
  }

  def postStmtObject(o: Stmt.Object): MOption[Stmt] = {
    return PostResultStmtObject
  }

  def postStmtSig(o: Stmt.Sig): MOption[Stmt] = {
    return PostResultStmtSig
  }

  def postStmtAbstractDatatype(o: Stmt.AbstractDatatype): MOption[Stmt] = {
    return PostResultStmtAbstractDatatype
  }

  def postStmtTypeAlias(o: Stmt.TypeAlias): MOption[Stmt] = {
    return PostResultStmtTypeAlias
  }

  def postStmtAssign(o: Stmt.Assign): MOption[Stmt] = {
    return PostResultStmtAssign
  }

  def postStmtBlock(o: Stmt.Block): MOption[Stmt] = {
    return PostResultStmtBlock
  }

  def postStmtIf(o: Stmt.If): MOption[Stmt] = {
    return PostResultStmtIf
  }

  def postStmtMatch(o: Stmt.Match): MOption[Stmt] = {
    return PostResultStmtMatch
  }

  def postStmtWhile(o: Stmt.While): MOption[Stmt] = {
    return PostResultStmtWhile
  }

  def postStmtDoWhile(o: Stmt.DoWhile): MOption[Stmt] = {
    return PostResultStmtDoWhile
  }

  def postStmtFor(o: Stmt.For): MOption[Stmt] = {
    return PostResultStmtFor
  }

  def postStmtReturn(o: Stmt.Return): MOption[Stmt] = {
    return PostResultStmtReturn
  }

  def postStmtLStmt(o: Stmt.LStmt): MOption[Stmt] = {
    return PostResultStmtLStmt
  }

  def postStmtExpr(o: Stmt.Expr): MOption[Stmt] = {
    return PostResultStmtExpr
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
    return PostResultLClauseInvariants
  }

  def postLClauseFacts(o: LClause.Facts): MOption[LClause] = {
    return PostResultLClauseFacts
  }

  def postLClauseFact(o: LClause.Fact): MOption[LClause.Fact] = {
    return PostResultLClauseFact
  }

  def postLClauseTheorems(o: LClause.Theorems): MOption[LClause] = {
    return PostResultLClauseTheorems
  }

  def postLClauseTheorem(o: LClause.Theorem): MOption[LClause.Theorem] = {
    return PostResultLClauseTheorem
  }

  def postLClauseSequent(o: LClause.Sequent): MOption[LClause] = {
    return PostResultLClauseSequent
  }

  def postLClauseProof(o: LClause.Proof): MOption[LClause] = {
    return PostResultLClauseProof
  }

  def postContractExp(o: ContractExp): MOption[ContractExp] = {
    return PostResultContractExp
  }

  def postCase(o: Case): MOption[Case] = {
    return PostResultCase
  }

  def postEnumGenRange(o: EnumGen.Range): MOption[EnumGen.Range] = {
    o match {
      case o: EnumGen.Range.Expr => return postEnumGenRangeExpr(o)
      case o: EnumGen.Range.Step => return postEnumGenRangeStep(o)
    }
  }

  def postEnumGenRangeExpr(o: EnumGen.Range.Expr): MOption[EnumGen.Range] = {
    return PostResultEnumGenRangeExpr
  }

  def postEnumGenRangeStep(o: EnumGen.Range.Step): MOption[EnumGen.Range] = {
    return PostResultEnumGenRangeStep
  }

  def postEnumGenFor(o: EnumGen.For): MOption[EnumGen.For] = {
    return PostResultEnumGenFor
  }

  def postType(o: Type): MOption[Type] = {
    o match {
      case o: Type.Named => return postTypeNamed(o)
      case o: Type.Fun => return postTypeFun(o)
      case o: Type.Tuple => return postTypeTuple(o)
    }
  }

  def postTypeNamed(o: Type.Named): MOption[Type] = {
    return PostResultTypeNamed
  }

  def postTypeFun(o: Type.Fun): MOption[Type] = {
    return PostResultTypeFun
  }

  def postTypeTuple(o: Type.Tuple): MOption[Type] = {
    return PostResultTypeTuple
  }

  def postPattern(o: Pattern): MOption[Pattern] = {
    o match {
      case o: Pattern.Literal => return postPatternLiteral(o)
      case o: Pattern.LitInterpolate => return postPatternLitInterpolate(o)
      case o: Pattern.Ref => return postPatternRef(o)
      case o: Pattern.VarBinding => return postPatternVarBinding(o)
      case o: Pattern.Wildcard => return postPatternWildcard(o)
      case o: Pattern.SeqWildcard => return postPatternSeqWildcard(o)
      case o: Pattern.Structure => return postPatternStructure(o)
    }
  }

  def postPatternLiteral(o: Pattern.Literal): MOption[Pattern] = {
    return PostResultPatternLiteral
  }

  def postPatternLitInterpolate(o: Pattern.LitInterpolate): MOption[Pattern] = {
    return PostResultPatternLitInterpolate
  }

  def postPatternRef(o: Pattern.Ref): MOption[Pattern] = {
    return PostResultPatternRef
  }

  def postPatternVarBinding(o: Pattern.VarBinding): MOption[Pattern] = {
    return PostResultPatternVarBinding
  }

  def postPatternWildcard(o: Pattern.Wildcard): MOption[Pattern] = {
    return PostResultPatternWildcard
  }

  def postPatternSeqWildcard(o: Pattern.SeqWildcard): MOption[Pattern] = {
    return PostResultPatternSeqWildcard
  }

  def postPatternStructure(o: Pattern.Structure): MOption[Pattern] = {
    return PostResultPatternStructure
  }

  def postExp(o: Exp): MOption[Exp] = {
    o match {
      case o: Exp.LitB => return postExpLitB(o)
      case o: Exp.LitC => return postExpLitC(o)
      case o: Exp.LitZ => return postExpLitZ(o)
      case o: Exp.LitF32 => return postExpLitF32(o)
      case o: Exp.LitF64 => return postExpLitF64(o)
      case o: Exp.LitR => return postExpLitR(o)
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

  def postLit(o: Lit): MOption[Lit] = {
    o match {
      case o: Exp.LitB =>
        val r: MOption[Lit] = postExpLitB(o) match {
         case MSome(result: Lit) => MSome[Lit](result)
         case MSome(_) => halt("Can only produce object of type Lit")
         case _ => MNone[Lit]()
        }
        return r
      case o: Exp.LitC =>
        val r: MOption[Lit] = postExpLitC(o) match {
         case MSome(result: Lit) => MSome[Lit](result)
         case MSome(_) => halt("Can only produce object of type Lit")
         case _ => MNone[Lit]()
        }
        return r
      case o: Exp.LitZ =>
        val r: MOption[Lit] = postExpLitZ(o) match {
         case MSome(result: Lit) => MSome[Lit](result)
         case MSome(_) => halt("Can only produce object of type Lit")
         case _ => MNone[Lit]()
        }
        return r
      case o: Exp.LitF32 =>
        val r: MOption[Lit] = postExpLitF32(o) match {
         case MSome(result: Lit) => MSome[Lit](result)
         case MSome(_) => halt("Can only produce object of type Lit")
         case _ => MNone[Lit]()
        }
        return r
      case o: Exp.LitF64 =>
        val r: MOption[Lit] = postExpLitF64(o) match {
         case MSome(result: Lit) => MSome[Lit](result)
         case MSome(_) => halt("Can only produce object of type Lit")
         case _ => MNone[Lit]()
        }
        return r
      case o: Exp.LitR =>
        val r: MOption[Lit] = postExpLitR(o) match {
         case MSome(result: Lit) => MSome[Lit](result)
         case MSome(_) => halt("Can only produce object of type Lit")
         case _ => MNone[Lit]()
        }
        return r
      case o: Exp.LitString =>
        val r: MOption[Lit] = postExpLitString(o) match {
         case MSome(result: Lit) => MSome[Lit](result)
         case MSome(_) => halt("Can only produce object of type Lit")
         case _ => MNone[Lit]()
        }
        return r
    }
  }

  def postExpLitB(o: Exp.LitB): MOption[Exp] = {
    return PostResultExpLitB
  }

  def postExpLitC(o: Exp.LitC): MOption[Exp] = {
    return PostResultExpLitC
  }

  def postExpLitZ(o: Exp.LitZ): MOption[Exp] = {
    return PostResultExpLitZ
  }

  def postExpLitF32(o: Exp.LitF32): MOption[Exp] = {
    return PostResultExpLitF32
  }

  def postExpLitF64(o: Exp.LitF64): MOption[Exp] = {
    return PostResultExpLitF64
  }

  def postExpLitR(o: Exp.LitR): MOption[Exp] = {
    return PostResultExpLitR
  }

  def postExpLitString(o: Exp.LitString): MOption[Exp] = {
    return PostResultExpLitString
  }

  def postExpStringInterpolate(o: Exp.StringInterpolate): MOption[Exp] = {
    return PostResultExpStringInterpolate
  }

  def postExpThis(o: Exp.This): MOption[Exp] = {
    return PostResultExpThis
  }

  def postExpSuper(o: Exp.Super): MOption[Exp] = {
    return PostResultExpSuper
  }

  def postExpUnary(o: Exp.Unary): MOption[Exp] = {
    return PostResultExpUnary
  }

  def postExpRef(o: Exp.Ref): MOption[Exp.Ref] = {
    o match {
      case o: Exp.Ident =>
        val r: MOption[Exp.Ref] = postExpIdent(o) match {
         case MSome(result: Exp.Ref) => MSome[Exp.Ref](result)
         case MSome(_) => halt("Can only produce object of type Exp.Ref")
         case _ => MNone[Exp.Ref]()
        }
        return r
      case o: Exp.Select =>
        val r: MOption[Exp.Ref] = postExpSelect(o) match {
         case MSome(result: Exp.Ref) => MSome[Exp.Ref](result)
         case MSome(_) => halt("Can only produce object of type Exp.Ref")
         case _ => MNone[Exp.Ref]()
        }
        return r
    }
  }

  def postExpBinary(o: Exp.Binary): MOption[Exp] = {
    return PostResultExpBinary
  }

  def postExpIdent(o: Exp.Ident): MOption[Exp] = {
    return PostResultExpIdent
  }

  def postExpEta(o: Exp.Eta): MOption[Exp] = {
    return PostResultExpEta
  }

  def postExpTuple(o: Exp.Tuple): MOption[Exp] = {
    return PostResultExpTuple
  }

  def postExpSelect(o: Exp.Select): MOption[Exp] = {
    return PostResultExpSelect
  }

  def postExpInvoke(o: Exp.Invoke): MOption[Exp] = {
    return PostResultExpInvoke
  }

  def postExpInvokeNamed(o: Exp.InvokeNamed): MOption[Exp] = {
    return PostResultExpInvokeNamed
  }

  def postExpIf(o: Exp.If): MOption[Exp] = {
    return PostResultExpIf
  }

  def postExpFunParam(o: Exp.Fun.Param): MOption[Exp.Fun.Param] = {
    return PostResultExpFunParam
  }

  def postExpFun(o: Exp.Fun): MOption[Exp] = {
    return PostResultExpFun
  }

  def postExpForYield(o: Exp.ForYield): MOption[Exp] = {
    return PostResultExpForYield
  }

  def postExpQuant(o: Exp.Quant): MOption[Exp] = {
    return PostResultExpQuant
  }

  def postNamedArg(o: NamedArg): MOption[NamedArg] = {
    return PostResultNamedArg
  }

  def postVarFragment(o: VarFragment): MOption[VarFragment] = {
    return PostResultVarFragment
  }

  def postDomain(o: Domain): MOption[Domain] = {
    o match {
      case o: Domain.Type => return postDomainType(o)
      case o: Domain.Range => return postDomainRange(o)
    }
  }

  def postDomainType(o: Domain.Type): MOption[Domain] = {
    return PostResultDomainType
  }

  def postDomainRange(o: Domain.Range): MOption[Domain] = {
    return PostResultDomainRange
  }

  def postId(o: Id): MOption[Id] = {
    return PostResultId
  }

  def postName(o: Name): MOption[Name] = {
    return PostResultName
  }

  def postBody(o: Body): MOption[Body] = {
    return PostResultBody
  }

  def postAbstractDatatypeParam(o: AbstractDatatypeParam): MOption[AbstractDatatypeParam] = {
    return PostResultAbstractDatatypeParam
  }

  def postMethodSig(o: MethodSig): MOption[MethodSig] = {
    return PostResultMethodSig
  }

  def postParam(o: Param): MOption[Param] = {
    return PostResultParam
  }

  def postTypeParam(o: TypeParam): MOption[TypeParam] = {
    return PostResultTypeParam
  }

  def postContract(o: Contract): MOption[Contract] = {
    return PostResultContract
  }

  def postSubContract(o: SubContract): MOption[SubContract] = {
    return PostResultSubContract
  }

  def postWhereDef(o: WhereDef): MOption[WhereDef] = {
    o match {
      case o: WhereDef.Val => return postWhereDefVal(o)
      case o: WhereDef.Def => return postWhereDefDef(o)
    }
  }

  def postWhereDefVal(o: WhereDef.Val): MOption[WhereDef] = {
    return PostResultWhereDefVal
  }

  def postWhereDefDef(o: WhereDef.Def): MOption[WhereDef] = {
    return PostResultWhereDefDef
  }

  def postSpecDef(o: SpecDef): MOption[SpecDef] = {
    return PostResultSpecDef
  }

  def postProofStep(o: ProofStep): MOption[ProofStep] = {
    o match {
      case o: ProofStep.Basic => return postProofStepBasic(o)
      case o: ProofStep.SubProof => return postProofStepSubProof(o)
    }
  }

  def postProofStepBasic(o: ProofStep.Basic): MOption[ProofStep] = {
    return PostResultProofStepBasic
  }

  def postProofStepSubProof(o: ProofStep.SubProof): MOption[ProofStep] = {
    return PostResultProofStepSubProof
  }

  def postAssumeProofStep(o: AssumeProofStep): MOption[AssumeProofStep] = {
    o match {
      case o: AssumeProofStep.Regular => return postAssumeProofStepRegular(o)
      case o: AssumeProofStep.ForallIntroAps => return postAssumeProofStepForallIntroAps(o)
      case o: AssumeProofStep.ExistsElimAps => return postAssumeProofStepExistsElimAps(o)
    }
  }

  def postAssumeProofStepRegular(o: AssumeProofStep.Regular): MOption[AssumeProofStep] = {
    return PostResultAssumeProofStepRegular
  }

  def postAssumeProofStepForallIntroAps(o: AssumeProofStep.ForallIntroAps): MOption[AssumeProofStep] = {
    return PostResultAssumeProofStepForallIntroAps
  }

  def postAssumeProofStepExistsElimAps(o: AssumeProofStep.ExistsElimAps): MOption[AssumeProofStep] = {
    return PostResultAssumeProofStepExistsElimAps
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
    return PostResultJustPremise
  }

  def postJustAndIntro(o: Just.AndIntro): MOption[Just] = {
    return PostResultJustAndIntro
  }

  def postJustAndElim(o: Just.AndElim): MOption[Just] = {
    return PostResultJustAndElim
  }

  def postJustOrIntro(o: Just.OrIntro): MOption[Just] = {
    return PostResultJustOrIntro
  }

  def postJustOrElim(o: Just.OrElim): MOption[Just] = {
    return PostResultJustOrElim
  }

  def postJustImplyIntro(o: Just.ImplyIntro): MOption[Just] = {
    return PostResultJustImplyIntro
  }

  def postJustImplyElim(o: Just.ImplyElim): MOption[Just] = {
    return PostResultJustImplyElim
  }

  def postJustNegIntro(o: Just.NegIntro): MOption[Just] = {
    return PostResultJustNegIntro
  }

  def postJustNegElim(o: Just.NegElim): MOption[Just] = {
    return PostResultJustNegElim
  }

  def postJustBottomElim(o: Just.BottomElim): MOption[Just] = {
    return PostResultJustBottomElim
  }

  def postJustPbc(o: Just.Pbc): MOption[Just] = {
    return PostResultJustPbc
  }

  def postJustForallIntro(o: Just.ForallIntro): MOption[Just] = {
    return PostResultJustForallIntro
  }

  def postJustForallElim(o: Just.ForallElim): MOption[Just] = {
    return PostResultJustForallElim
  }

  def postJustExistsIntro(o: Just.ExistsIntro): MOption[Just] = {
    return PostResultJustExistsIntro
  }

  def postJustExistsElim(o: Just.ExistsElim): MOption[Just] = {
    return PostResultJustExistsElim
  }

  def postJustFact(o: Just.Fact): MOption[Just] = {
    return PostResultJustFact
  }

  def postJustInvariant(o: Just.Invariant): MOption[Just] = {
    return PostResultJustInvariant
  }

  def postJustSubst(o: Just.Subst): MOption[Just] = {
    return PostResultJustSubst
  }

  def postJustAuto(o: Just.Auto): MOption[Just] = {
    return PostResultJustAuto
  }

  def postJustCoq(o: Just.Coq): MOption[Just] = {
    return PostResultJustCoq
  }

  def postTruthTableRow(o: TruthTable.Row): MOption[TruthTable.Row] = {
    return PostResultTruthTableRow
  }

  def postTruthTableAssignment(o: TruthTable.Assignment): MOption[TruthTable.Assignment] = {
    return PostResultTruthTableAssignment
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
    return PostResultTruthTableConclusionValidity
  }

  def postTruthTableConclusionTautology(o: TruthTable.Conclusion.Tautology): MOption[TruthTable.Conclusion] = {
    return PostResultTruthTableConclusionTautology
  }

  def postTruthTableConclusionContradictory(o: TruthTable.Conclusion.Contradictory): MOption[TruthTable.Conclusion] = {
    return PostResultTruthTableConclusionContradictory
  }

  def postTruthTableConclusionContingent(o: TruthTable.Conclusion.Contingent): MOption[TruthTable.Conclusion] = {
    return PostResultTruthTableConclusionContingent
  }

  def postTyped(o: Typed): MOption[Typed] = {
    o match {
      case o: Typed.Name => return postTypedName(o)
      case o: Typed.Tuple => return postTypedTuple(o)
      case o: Typed.Fun => return postTypedFun(o)
      case o: Typed.TypeVar => return postTypedTypeVar(o)
      case o: Typed.Package => return postTypedPackage(o)
      case o: Typed.Object => return postTypedObject(o)
      case o: Typed.Enum => return postTypedEnum(o)
      case o: Typed.Method => return postTypedMethod(o)
      case o: Typed.Methods => return postTypedMethods(o)
    }
  }

  def postTypedName(o: Typed.Name): MOption[Typed] = {
    return PostResultTypedName
  }

  def postTypedTuple(o: Typed.Tuple): MOption[Typed] = {
    return PostResultTypedTuple
  }

  def postTypedFun(o: Typed.Fun): MOption[Typed] = {
    return PostResultTypedFun
  }

  def postTypedTypeVar(o: Typed.TypeVar): MOption[Typed] = {
    return PostResultTypedTypeVar
  }

  def postTypedPackage(o: Typed.Package): MOption[Typed] = {
    return PostResultTypedPackage
  }

  def postTypedObject(o: Typed.Object): MOption[Typed] = {
    return PostResultTypedObject
  }

  def postTypedEnum(o: Typed.Enum): MOption[Typed] = {
    return PostResultTypedEnum
  }

  def postTypedMethodSubst(o: Typed.Method.Subst): MOption[Typed.Method.Subst] = {
    return PostResultTypedMethodSubst
  }

  def postTypedMethod(o: Typed.Method): MOption[Typed] = {
    return PostResultTypedMethod
  }

  def postTypedMethods(o: Typed.Methods): MOption[Typed] = {
    return PostResultTypedMethods
  }

  def postAttr(o: Attr): MOption[Attr] = {
    return PostResultAttr
  }

  def postTypedAttr(o: TypedAttr): MOption[TypedAttr] = {
    return PostResultTypedAttr
  }

  def postResolvedAttr(o: ResolvedAttr): MOption[ResolvedAttr] = {
    return PostResultResolvedAttr
  }

  def postResolvedInfo(o: ResolvedInfo): MOption[ResolvedInfo] = {
    o match {
      case o: ResolvedInfo.BuiltIn => return postResolvedInfoBuiltIn(o)
      case o: ResolvedInfo.Package => return postResolvedInfoPackage(o)
      case o: ResolvedInfo.Enum => return postResolvedInfoEnum(o)
      case o: ResolvedInfo.EnumElement => return postResolvedInfoEnumElement(o)
      case o: ResolvedInfo.Object => return postResolvedInfoObject(o)
      case o: ResolvedInfo.Var => return postResolvedInfoVar(o)
      case o: ResolvedInfo.Method => return postResolvedInfoMethod(o)
      case o: ResolvedInfo.Methods => return postResolvedInfoMethods(o)
      case o: ResolvedInfo.Type => return postResolvedInfoType(o)
      case o: ResolvedInfo.Tuple => return postResolvedInfoTuple(o)
      case o: ResolvedInfo.LocalVar => return postResolvedInfoLocalVar(o)
    }
  }

  def postResolvedInfoBuiltIn(o: ResolvedInfo.BuiltIn): MOption[ResolvedInfo] = {
    return PostResultResolvedInfoBuiltIn
  }

  def postResolvedInfoPackage(o: ResolvedInfo.Package): MOption[ResolvedInfo] = {
    return PostResultResolvedInfoPackage
  }

  def postResolvedInfoEnum(o: ResolvedInfo.Enum): MOption[ResolvedInfo] = {
    return PostResultResolvedInfoEnum
  }

  def postResolvedInfoEnumElement(o: ResolvedInfo.EnumElement): MOption[ResolvedInfo] = {
    return PostResultResolvedInfoEnumElement
  }

  def postResolvedInfoObject(o: ResolvedInfo.Object): MOption[ResolvedInfo] = {
    return PostResultResolvedInfoObject
  }

  def postResolvedInfoVar(o: ResolvedInfo.Var): MOption[ResolvedInfo] = {
    return PostResultResolvedInfoVar
  }

  def postResolvedInfoMethod(o: ResolvedInfo.Method): MOption[ResolvedInfo] = {
    return PostResultResolvedInfoMethod
  }

  def postResolvedInfoMethods(o: ResolvedInfo.Methods): MOption[ResolvedInfo] = {
    return PostResultResolvedInfoMethods
  }

  def postResolvedInfoType(o: ResolvedInfo.Type): MOption[ResolvedInfo] = {
    return PostResultResolvedInfoType
  }

  def postResolvedInfoTuple(o: ResolvedInfo.Tuple): MOption[ResolvedInfo] = {
    return PostResultResolvedInfoTuple
  }

  def postResolvedInfoLocalVar(o: ResolvedInfo.LocalVar): MOption[ResolvedInfo] = {
    return PostResultResolvedInfoLocalVar
  }

  def transformTopUnit(o: TopUnit): MOption[TopUnit] = {
    val preR: PreResult[TopUnit] = preTopUnit(o)
    val r: MOption[TopUnit] = if (preR.continu) {
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
          val r0: MOption[IS[Z, Id]] = transformISZ(o2.vars, transformId)
          val r1: MOption[LClause.Sequent] = transformLClauseSequent(o2.sequent)
          val r2: MOption[IS[Z, TruthTable.Row]] = transformISZ(o2.rows, transformTruthTableRow)
          val r3: MOption[Option[TruthTable.Conclusion]] = transformOption(o2.conclusionOpt, transformTruthTableConclusion)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
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
    val postR: MOption[TopUnit] = postTopUnit(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformStmt(o: Stmt): MOption[Stmt] = {
    val preR: PreResult[Stmt] = preStmt(o)
    val r: MOption[Stmt] = if (preR.continu) {
      val o2: Stmt = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Stmt] = o2 match {
        case o2: Stmt.Import =>
          val r0: MOption[IS[Z, Stmt.Import.Importer]] = transformISZ(o2.importers, transformStmtImportImporter)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(importers = r0.getOrElse(o2.importers), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Var =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[Option[Type]] = transformOption(o2.tipeOpt, transformType)
          val r2: MOption[Option[AssignExp]] = transformOption(o2.initOpt, transformAssignExp)
          val r3: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), tipeOpt = r1.getOrElse(o2.tipeOpt), initOpt = r2.getOrElse(o2.initOpt), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.VarPattern =>
          val r0: MOption[Pattern] = transformPattern(o2.pattern)
          val r1: MOption[Option[Type]] = transformOption(o2.tipeOpt, transformType)
          val r2: MOption[AssignExp] = transformAssignExp(o2.init)
          val r3: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(pattern = r0.getOrElse(o2.pattern), tipeOpt = r1.getOrElse(o2.tipeOpt), init = r2.getOrElse(o2.init), attr = r3.getOrElse(o2.attr)))
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
          val r2: MOption[Option[Body]] = transformOption(o2.bodyOpt, transformBody)
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
          val r1: MOption[IS[Z, SpecDef]] = transformISZ(o2.defs, transformSpecDef)
          val r2: MOption[IS[Z, WhereDef]] = transformISZ(o2.where, transformWhereDef)
          val r3: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(sig = r0.getOrElse(o2.sig), defs = r1.getOrElse(o2.defs), where = r2.getOrElse(o2.where), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Enum =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[IS[Z, Id]] = transformISZ(o2.elements, transformId)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), elements = r1.getOrElse(o2.elements), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.SubZ =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Object =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[IS[Z, Type]] = transformISZ(o2.parents, transformType)
          val r2: MOption[IS[Z, Stmt]] = transformISZ(o2.stmts, transformStmt)
          val r3: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), parents = r1.getOrElse(o2.parents), stmts = r2.getOrElse(o2.stmts), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Sig =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[IS[Z, TypeParam]] = transformISZ(o2.typeParams, transformTypeParam)
          val r2: MOption[IS[Z, Type.Named]] = transformISZ(o2.parents, transformTypeNamed)
          val r3: MOption[IS[Z, Stmt]] = transformISZ(o2.stmts, transformStmt)
          val r4: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty || r4.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), typeParams = r1.getOrElse(o2.typeParams), parents = r2.getOrElse(o2.parents), stmts = r3.getOrElse(o2.stmts), attr = r4.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.AbstractDatatype =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[IS[Z, TypeParam]] = transformISZ(o2.typeParams, transformTypeParam)
          val r2: MOption[IS[Z, AbstractDatatypeParam]] = transformISZ(o2.params, transformAbstractDatatypeParam)
          val r3: MOption[IS[Z, Type.Named]] = transformISZ(o2.parents, transformTypeNamed)
          val r4: MOption[IS[Z, Stmt]] = transformISZ(o2.stmts, transformStmt)
          val r5: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty || r4.nonEmpty || r5.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), typeParams = r1.getOrElse(o2.typeParams), params = r2.getOrElse(o2.params), parents = r3.getOrElse(o2.parents), stmts = r4.getOrElse(o2.stmts), attr = r5.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.TypeAlias =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[IS[Z, TypeParam]] = transformISZ(o2.typeParams, transformTypeParam)
          val r2: MOption[Type] = transformType(o2.tipe)
          val r3: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), typeParams = r1.getOrElse(o2.typeParams), tipe = r2.getOrElse(o2.tipe), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Assign =>
          val r0: MOption[Exp] = transformExp(o2.lhs)
          val r1: MOption[AssignExp] = transformAssignExp(o2.rhs)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(lhs = r0.getOrElse(o2.lhs), rhs = r1.getOrElse(o2.rhs), attr = r2.getOrElse(o2.attr)))
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
          val r1: MOption[Body] = transformBody(o2.thenBody)
          val r2: MOption[Body] = transformBody(o2.elseBody)
          val r3: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(cond = r0.getOrElse(o2.cond), thenBody = r1.getOrElse(o2.thenBody), elseBody = r2.getOrElse(o2.elseBody), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Match =>
          val r0: MOption[Exp] = transformExp(o2.exp)
          val r1: MOption[IS[Z, Case]] = transformISZ(o2.cases, transformCase)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(exp = r0.getOrElse(o2.exp), cases = r1.getOrElse(o2.cases), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.While =>
          val r0: MOption[Exp] = transformExp(o2.cond)
          val r1: MOption[IS[Z, ContractExp]] = transformISZ(o2.invariants, transformContractExp)
          val r2: MOption[IS[Z, Exp]] = transformISZ(o2.modifies, transformExp)
          val r3: MOption[Body] = transformBody(o2.body)
          val r4: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty || r4.nonEmpty)
            MSome(o2(cond = r0.getOrElse(o2.cond), invariants = r1.getOrElse(o2.invariants), modifies = r2.getOrElse(o2.modifies), body = r3.getOrElse(o2.body), attr = r4.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.DoWhile =>
          val r0: MOption[Exp] = transformExp(o2.cond)
          val r1: MOption[IS[Z, ContractExp]] = transformISZ(o2.invariants, transformContractExp)
          val r2: MOption[IS[Z, Exp]] = transformISZ(o2.modifies, transformExp)
          val r3: MOption[Body] = transformBody(o2.body)
          val r4: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty || r4.nonEmpty)
            MSome(o2(cond = r0.getOrElse(o2.cond), invariants = r1.getOrElse(o2.invariants), modifies = r2.getOrElse(o2.modifies), body = r3.getOrElse(o2.body), attr = r4.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.For =>
          val r0: MOption[IS[Z, EnumGen.For]] = transformISZ(o2.enumGens, transformEnumGenFor)
          val r1: MOption[IS[Z, ContractExp]] = transformISZ(o2.invariants, transformContractExp)
          val r2: MOption[IS[Z, Exp]] = transformISZ(o2.modifies, transformExp)
          val r3: MOption[Body] = transformBody(o2.body)
          val r4: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty || r4.nonEmpty)
            MSome(o2(enumGens = r0.getOrElse(o2.enumGens), invariants = r1.getOrElse(o2.invariants), modifies = r2.getOrElse(o2.modifies), body = r3.getOrElse(o2.body), attr = r4.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Return =>
          val r0: MOption[Option[Exp]] = transformOption(o2.expOpt, transformExp)
          val r1: MOption[TypedAttr] = transformTypedAttr(o2.attr)
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
          val r1: MOption[TypedAttr] = transformTypedAttr(o2.attr)
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
    val postR: MOption[Stmt] = postStmt(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformAssignExp(o: AssignExp): MOption[AssignExp] = {
    val preR: PreResult[AssignExp] = preAssignExp(o)
    val r: MOption[AssignExp] = if (preR.continu) {
      val o2: AssignExp = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[AssignExp] = o2 match {
        case o2: Stmt.Block =>
          val r0: MOption[Body] = transformBody(o2.body)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(body = r0.getOrElse(o2.body), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.If =>
          val r0: MOption[Exp] = transformExp(o2.cond)
          val r1: MOption[Body] = transformBody(o2.thenBody)
          val r2: MOption[Body] = transformBody(o2.elseBody)
          val r3: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(cond = r0.getOrElse(o2.cond), thenBody = r1.getOrElse(o2.thenBody), elseBody = r2.getOrElse(o2.elseBody), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Match =>
          val r0: MOption[Exp] = transformExp(o2.exp)
          val r1: MOption[IS[Z, Case]] = transformISZ(o2.cases, transformCase)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(exp = r0.getOrElse(o2.exp), cases = r1.getOrElse(o2.cases), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Return =>
          val r0: MOption[Option[Exp]] = transformOption(o2.expOpt, transformExp)
          val r1: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(expOpt = r0.getOrElse(o2.expOpt), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Stmt.Expr =>
          val r0: MOption[Exp] = transformExp(o2.exp)
          val r1: MOption[TypedAttr] = transformTypedAttr(o2.attr)
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
    val o2: AssignExp = r.getOrElse(o)
    val postR: MOption[AssignExp] = postAssignExp(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformStmtImportImporter(o: Stmt.Import.Importer): MOption[Stmt.Import.Importer] = {
    val preR: PreResult[Stmt.Import.Importer] = preStmtImportImporter(o)
    val r: MOption[Stmt.Import.Importer] = if (preR.continu) {
      val o2: Stmt.Import.Importer = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Name] = transformName(o2.name)
      val r1: MOption[Option[Stmt.Import.Selector]] = transformOption(o2.selectorOpt, transformStmtImportSelector)
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
    val postR: MOption[Stmt.Import.Importer] = postStmtImportImporter(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformStmtImportSelector(o: Stmt.Import.Selector): MOption[Stmt.Import.Selector] = {
    val preR: PreResult[Stmt.Import.Selector] = preStmtImportSelector(o)
    val r: MOption[Stmt.Import.Selector] = if (preR.continu) {
      val o2: Stmt.Import.Selector = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Stmt.Import.Selector] = o2 match {
        case o2: Stmt.Import.MultiSelector =>
          val r0: MOption[IS[Z, Stmt.Import.NamedSelector]] = transformISZ(o2.selectors, transformStmtImportNamedSelector)
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
    val postR: MOption[Stmt.Import.Selector] = postStmtImportSelector(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformStmtImportNamedSelector(o: Stmt.Import.NamedSelector): MOption[Stmt.Import.NamedSelector] = {
    val preR: PreResult[Stmt.Import.NamedSelector] = preStmtImportNamedSelector(o)
    val r: MOption[Stmt.Import.NamedSelector] = if (preR.continu) {
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
    val postR: MOption[Stmt.Import.NamedSelector] = postStmtImportNamedSelector(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformLClause(o: LClause): MOption[LClause] = {
    val preR: PreResult[LClause] = preLClause(o)
    val r: MOption[LClause] = if (preR.continu) {
      val o2: LClause = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[LClause] = o2 match {
        case o2: LClause.Invariants =>
          val r0: MOption[IS[Z, ContractExp]] = transformISZ(o2.value, transformContractExp)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(value = r0.getOrElse(o2.value)))
          else
            MNone()
        case o2: LClause.Facts =>
          val r0: MOption[IS[Z, LClause.Fact]] = transformISZ(o2.value, transformLClauseFact)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(value = r0.getOrElse(o2.value)))
          else
            MNone()
        case o2: LClause.Theorems =>
          val r0: MOption[IS[Z, LClause.Theorem]] = transformISZ(o2.value, transformLClauseTheorem)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(value = r0.getOrElse(o2.value)))
          else
            MNone()
        case o2: LClause.Sequent =>
          val r0: MOption[IS[Z, Exp]] = transformISZ(o2.premises, transformExp)
          val r1: MOption[IS[Z, Exp]] = transformISZ(o2.conclusions, transformExp)
          val r2: MOption[Option[LClause.Proof]] = transformOption(o2.proofOpt, transformLClauseProof)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(premises = r0.getOrElse(o2.premises), conclusions = r1.getOrElse(o2.conclusions), proofOpt = r2.getOrElse(o2.proofOpt)))
          else
            MNone()
        case o2: LClause.Proof =>
          val r0: MOption[IS[Z, ProofStep]] = transformISZ(o2.steps, transformProofStep)
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
    val postR: MOption[LClause] = postLClause(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformLClauseFact(o: LClause.Fact): MOption[LClause.Fact] = {
    val preR: PreResult[LClause.Fact] = preLClauseFact(o)
    val r: MOption[LClause.Fact] = if (preR.continu) {
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
    val postR: MOption[LClause.Fact] = postLClauseFact(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformLClauseTheorem(o: LClause.Theorem): MOption[LClause.Theorem] = {
    val preR: PreResult[LClause.Theorem] = preLClauseTheorem(o)
    val r: MOption[LClause.Theorem] = if (preR.continu) {
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
    val postR: MOption[LClause.Theorem] = postLClauseTheorem(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformContractExp(o: ContractExp): MOption[ContractExp] = {
    val preR: PreResult[ContractExp] = preContractExp(o)
    val r: MOption[ContractExp] = if (preR.continu) {
      val o2: ContractExp = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Option[Id]] = transformOption(o2.idOpt, transformId)
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
    val postR: MOption[ContractExp] = postContractExp(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformCase(o: Case): MOption[Case] = {
    val preR: PreResult[Case] = preCase(o)
    val r: MOption[Case] = if (preR.continu) {
      val o2: Case = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Pattern] = transformPattern(o2.pattern)
      val r1: MOption[Option[Exp]] = transformOption(o2.condOpt, transformExp)
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
    val postR: MOption[Case] = postCase(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformEnumGenRange(o: EnumGen.Range): MOption[EnumGen.Range] = {
    val preR: PreResult[EnumGen.Range] = preEnumGenRange(o)
    val r: MOption[EnumGen.Range] = if (preR.continu) {
      val o2: EnumGen.Range = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[EnumGen.Range] = o2 match {
        case o2: EnumGen.Range.Expr =>
          val r0: MOption[Exp] = transformExp(o2.exp)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(exp = r0.getOrElse(o2.exp), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: EnumGen.Range.Step =>
          val r0: MOption[Exp] = transformExp(o2.start)
          val r1: MOption[Exp] = transformExp(o2.end)
          val r2: MOption[Option[Exp]] = transformOption(o2.byOpt, transformExp)
          val r3: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(start = r0.getOrElse(o2.start), end = r1.getOrElse(o2.end), byOpt = r2.getOrElse(o2.byOpt), attr = r3.getOrElse(o2.attr)))
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
    val postR: MOption[EnumGen.Range] = postEnumGenRange(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformEnumGenFor(o: EnumGen.For): MOption[EnumGen.For] = {
    val preR: PreResult[EnumGen.For] = preEnumGenFor(o)
    val r: MOption[EnumGen.For] = if (preR.continu) {
      val o2: EnumGen.For = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Option[Id]] = transformOption(o2.idOpt, transformId)
      val r1: MOption[EnumGen.Range] = transformEnumGenRange(o2.range)
      val r2: MOption[Option[Exp]] = transformOption(o2.condOpt, transformExp)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
        MSome(o2(idOpt = r0.getOrElse(o2.idOpt), range = r1.getOrElse(o2.range), condOpt = r2.getOrElse(o2.condOpt)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: EnumGen.For = r.getOrElse(o)
    val postR: MOption[EnumGen.For] = postEnumGenFor(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformType(o: Type): MOption[Type] = {
    val preR: PreResult[Type] = preType(o)
    val r: MOption[Type] = if (preR.continu) {
      val o2: Type = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Type] = o2 match {
        case o2: Type.Named =>
          val r0: MOption[Name] = transformName(o2.name)
          val r1: MOption[IS[Z, Type]] = transformISZ(o2.typeArgs, transformType)
          val r2: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(name = r0.getOrElse(o2.name), typeArgs = r1.getOrElse(o2.typeArgs), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Type.Fun =>
          val r0: MOption[IS[Z, Type]] = transformISZ(o2.args, transformType)
          val r1: MOption[Type] = transformType(o2.ret)
          val r2: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(args = r0.getOrElse(o2.args), ret = r1.getOrElse(o2.ret), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Type.Tuple =>
          val r0: MOption[IS[Z, Type]] = transformISZ(o2.args, transformType)
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
    val postR: MOption[Type] = postType(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformPattern(o: Pattern): MOption[Pattern] = {
    val preR: PreResult[Pattern] = prePattern(o)
    val r: MOption[Pattern] = if (preR.continu) {
      val o2: Pattern = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Pattern] = o2 match {
        case o2: Pattern.Literal =>
          val r0: MOption[Lit] = transformLit(o2.lit)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(lit = r0.getOrElse(o2.lit)))
          else
            MNone()
        case o2: Pattern.LitInterpolate =>
          val r0: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Pattern.Ref =>
          val r0: MOption[Name] = transformName(o2.name)
          val r1: MOption[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(name = r0.getOrElse(o2.name), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Pattern.VarBinding =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[Option[Type]] = transformOption(o2.tipeOpt, transformType)
          val r2: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), tipeOpt = r1.getOrElse(o2.tipeOpt), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Pattern.Wildcard =>
          val r0: MOption[Option[Type]] = transformOption(o2.typeOpt, transformType)
          val r1: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(typeOpt = r0.getOrElse(o2.typeOpt), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Pattern.SeqWildcard =>
          val r0: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Pattern.Structure =>
          val r0: MOption[Option[Id]] = transformOption(o2.idOpt, transformId)
          val r1: MOption[Option[Name]] = transformOption(o2.nameOpt, transformName)
          val r2: MOption[IS[Z, Pattern]] = transformISZ(o2.patterns, transformPattern)
          val r3: MOption[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(idOpt = r0.getOrElse(o2.idOpt), nameOpt = r1.getOrElse(o2.nameOpt), patterns = r2.getOrElse(o2.patterns), attr = r3.getOrElse(o2.attr)))
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
    val postR: MOption[Pattern] = postPattern(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformExp(o: Exp): MOption[Exp] = {
    val preR: PreResult[Exp] = preExp(o)
    val r: MOption[Exp] = if (preR.continu) {
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
        case o2: Exp.LitString =>
          val r0: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(attr = r0.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.StringInterpolate =>
          val r0: MOption[IS[Z, Exp.LitString]] = transformISZ(o2.lits, transformExpLitString)
          val r1: MOption[IS[Z, Exp]] = transformISZ(o2.args, transformExp)
          val r2: MOption[TypedAttr] = transformTypedAttr(o2.attr)
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
          val r0: MOption[Option[Id]] = transformOption(o2.idOpt, transformId)
          val r1: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(idOpt = r0.getOrElse(o2.idOpt), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Unary =>
          val r0: MOption[Exp] = transformExp(o2.exp)
          val r1: MOption[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(exp = r0.getOrElse(o2.exp), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Binary =>
          val r0: MOption[Exp] = transformExp(o2.left)
          val r1: MOption[Exp] = transformExp(o2.right)
          val r2: MOption[ResolvedAttr] = transformResolvedAttr(o2.attr)
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
          val r0: MOption[Exp.Ref] = transformExpRef(o2.ref)
          val r1: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(ref = r0.getOrElse(o2.ref), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Tuple =>
          val r0: MOption[IS[Z, Exp]] = transformISZ(o2.args, transformExp)
          val r1: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(args = r0.getOrElse(o2.args), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Select =>
          val r0: MOption[Option[Exp]] = transformOption(o2.receiverOpt, transformExp)
          val r1: MOption[Id] = transformId(o2.id)
          val r2: MOption[IS[Z, Type]] = transformISZ(o2.targs, transformType)
          val r3: MOption[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(receiverOpt = r0.getOrElse(o2.receiverOpt), id = r1.getOrElse(o2.id), targs = r2.getOrElse(o2.targs), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Invoke =>
          val r0: MOption[Option[Exp]] = transformOption(o2.receiverOpt, transformExp)
          val r1: MOption[Id] = transformId(o2.id)
          val r2: MOption[IS[Z, Type]] = transformISZ(o2.targs, transformType)
          val r3: MOption[IS[Z, Exp]] = transformISZ(o2.args, transformExp)
          val r4: MOption[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty || r4.nonEmpty)
            MSome(o2(receiverOpt = r0.getOrElse(o2.receiverOpt), id = r1.getOrElse(o2.id), targs = r2.getOrElse(o2.targs), args = r3.getOrElse(o2.args), attr = r4.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.InvokeNamed =>
          val r0: MOption[Option[Exp]] = transformOption(o2.receiverOpt, transformExp)
          val r1: MOption[Id] = transformId(o2.id)
          val r2: MOption[IS[Z, Type]] = transformISZ(o2.targs, transformType)
          val r3: MOption[IS[Z, NamedArg]] = transformISZ(o2.args, transformNamedArg)
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
          val r0: MOption[IS[Z, Exp.Fun.Param]] = transformISZ(o2.params, transformExpFunParam)
          val r1: MOption[Contract] = transformContract(o2.contract)
          val r2: MOption[AssignExp] = transformAssignExp(o2.exp)
          val r3: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(params = r0.getOrElse(o2.params), contract = r1.getOrElse(o2.contract), exp = r2.getOrElse(o2.exp), attr = r3.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.ForYield =>
          val r0: MOption[IS[Z, EnumGen.For]] = transformISZ(o2.enumGens, transformEnumGenFor)
          val r1: MOption[Exp] = transformExp(o2.exp)
          val r2: MOption[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(enumGens = r0.getOrElse(o2.enumGens), exp = r1.getOrElse(o2.exp), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Quant =>
          val r0: MOption[IS[Z, VarFragment]] = transformISZ(o2.varFragments, transformVarFragment)
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
    val postR: MOption[Exp] = postExp(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformLit(o: Lit): MOption[Lit] = {
    val preR: PreResult[Lit] = preLit(o)
    val r: MOption[Lit] = if (preR.continu) {
      val o2: Lit = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Lit] = o2 match {
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
        case o2: Exp.LitString =>
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
    val o2: Lit = r.getOrElse(o)
    val postR: MOption[Lit] = postLit(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformExpRef(o: Exp.Ref): MOption[Exp.Ref] = {
    val preR: PreResult[Exp.Ref] = preExpRef(o)
    val r: MOption[Exp.Ref] = if (preR.continu) {
      val o2: Exp.Ref = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Exp.Ref] = o2 match {
        case o2: Exp.Ident =>
          val r0: MOption[Id] = transformId(o2.id)
          val r1: MOption[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(id = r0.getOrElse(o2.id), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Exp.Select =>
          val r0: MOption[Option[Exp]] = transformOption(o2.receiverOpt, transformExp)
          val r1: MOption[Id] = transformId(o2.id)
          val r2: MOption[IS[Z, Type]] = transformISZ(o2.targs, transformType)
          val r3: MOption[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
            MSome(o2(receiverOpt = r0.getOrElse(o2.receiverOpt), id = r1.getOrElse(o2.id), targs = r2.getOrElse(o2.targs), attr = r3.getOrElse(o2.attr)))
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
    val o2: Exp.Ref = r.getOrElse(o)
    val postR: MOption[Exp.Ref] = postExpRef(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformExpFunParam(o: Exp.Fun.Param): MOption[Exp.Fun.Param] = {
    val preR: PreResult[Exp.Fun.Param] = preExpFunParam(o)
    val r: MOption[Exp.Fun.Param] = if (preR.continu) {
      val o2: Exp.Fun.Param = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[Option[Type]] = transformOption(o2.tipeOpt, transformType)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty)
        MSome(o2(id = r0.getOrElse(o2.id), tipeOpt = r1.getOrElse(o2.tipeOpt)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Exp.Fun.Param = r.getOrElse(o)
    val postR: MOption[Exp.Fun.Param] = postExpFunParam(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformNamedArg(o: NamedArg): MOption[NamedArg] = {
    val preR: PreResult[NamedArg] = preNamedArg(o)
    val r: MOption[NamedArg] = if (preR.continu) {
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
    val postR: MOption[NamedArg] = postNamedArg(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformVarFragment(o: VarFragment): MOption[VarFragment] = {
    val preR: PreResult[VarFragment] = preVarFragment(o)
    val r: MOption[VarFragment] = if (preR.continu) {
      val o2: VarFragment = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Id]] = transformISZ(o2.ids, transformId)
      val r1: MOption[Option[Domain]] = transformOption(o2.domainOpt, transformDomain)
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
    val postR: MOption[VarFragment] = postVarFragment(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformDomain(o: Domain): MOption[Domain] = {
    val preR: PreResult[Domain] = preDomain(o)
    val r: MOption[Domain] = if (preR.continu) {
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
    val postR: MOption[Domain] = postDomain(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformId(o: Id): MOption[Id] = {
    val preR: PreResult[Id] = preId(o)
    val r: MOption[Id] = if (preR.continu) {
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
    val postR: MOption[Id] = postId(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformName(o: Name): MOption[Name] = {
    val preR: PreResult[Name] = preName(o)
    val r: MOption[Name] = if (preR.continu) {
      val o2: Name = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Id]] = transformISZ(o2.ids, transformId)
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
    val postR: MOption[Name] = postName(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformBody(o: Body): MOption[Body] = {
    val preR: PreResult[Body] = preBody(o)
    val r: MOption[Body] = if (preR.continu) {
      val o2: Body = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Stmt]] = transformISZ(o2.stmts, transformStmt)
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
    val postR: MOption[Body] = postBody(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformAbstractDatatypeParam(o: AbstractDatatypeParam): MOption[AbstractDatatypeParam] = {
    val preR: PreResult[AbstractDatatypeParam] = preAbstractDatatypeParam(o)
    val r: MOption[AbstractDatatypeParam] = if (preR.continu) {
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
    val postR: MOption[AbstractDatatypeParam] = postAbstractDatatypeParam(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformMethodSig(o: MethodSig): MOption[MethodSig] = {
    val preR: PreResult[MethodSig] = preMethodSig(o)
    val r: MOption[MethodSig] = if (preR.continu) {
      val o2: MethodSig = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[IS[Z, TypeParam]] = transformISZ(o2.typeParams, transformTypeParam)
      val r2: MOption[IS[Z, Param]] = transformISZ(o2.params, transformParam)
      val r3: MOption[Type] = transformType(o2.returnType)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty || r3.nonEmpty)
        MSome(o2(id = r0.getOrElse(o2.id), typeParams = r1.getOrElse(o2.typeParams), params = r2.getOrElse(o2.params), returnType = r3.getOrElse(o2.returnType)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: MethodSig = r.getOrElse(o)
    val postR: MOption[MethodSig] = postMethodSig(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformParam(o: Param): MOption[Param] = {
    val preR: PreResult[Param] = preParam(o)
    val r: MOption[Param] = if (preR.continu) {
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
    val postR: MOption[Param] = postParam(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformTypeParam(o: TypeParam): MOption[TypeParam] = {
    val preR: PreResult[TypeParam] = preTypeParam(o)
    val r: MOption[TypeParam] = if (preR.continu) {
      val o2: TypeParam = preR.resultOpt.getOrElse(o)
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
    val o2: TypeParam = r.getOrElse(o)
    val postR: MOption[TypeParam] = postTypeParam(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformContract(o: Contract): MOption[Contract] = {
    val preR: PreResult[Contract] = preContract(o)
    val r: MOption[Contract] = if (preR.continu) {
      val o2: Contract = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Exp]] = transformISZ(o2.reads, transformExp)
      val r1: MOption[IS[Z, ContractExp]] = transformISZ(o2.requires, transformContractExp)
      val r2: MOption[IS[Z, Exp]] = transformISZ(o2.modifies, transformExp)
      val r3: MOption[IS[Z, ContractExp]] = transformISZ(o2.ensures, transformContractExp)
      val r4: MOption[IS[Z, SubContract]] = transformISZ(o2.subs, transformSubContract)
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
    val postR: MOption[Contract] = postContract(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformSubContract(o: SubContract): MOption[SubContract] = {
    val preR: PreResult[SubContract] = preSubContract(o)
    val r: MOption[SubContract] = if (preR.continu) {
      val o2: SubContract = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Id] = transformId(o2.id)
      val r1: MOption[IS[Z, Id]] = transformISZ(o2.params, transformId)
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
    val postR: MOption[SubContract] = postSubContract(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformWhereDef(o: WhereDef): MOption[WhereDef] = {
    val preR: PreResult[WhereDef] = preWhereDef(o)
    val r: MOption[WhereDef] = if (preR.continu) {
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
          val r1: MOption[IS[Z, Param]] = transformISZ(o2.params, transformParam)
          val r2: MOption[Type] = transformType(o2.rTipe)
          val r3: MOption[IS[Z, SpecDef]] = transformISZ(o2.defs, transformSpecDef)
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
    val postR: MOption[WhereDef] = postWhereDef(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformSpecDef(o: SpecDef): MOption[SpecDef] = {
    val preR: PreResult[SpecDef] = preSpecDef(o)
    val r: MOption[SpecDef] = if (preR.continu) {
      val o2: SpecDef = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Option[Id]] = transformOption(o2.idOpt, transformId)
      val r1: MOption[Exp] = transformExp(o2.exp)
      val r2: MOption[Option[Pattern]] = transformOption(o2.patternOpt, transformPattern)
      val r3: MOption[Option[Exp]] = transformOption(o2.guardOpt, transformExp)
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
    val postR: MOption[SpecDef] = postSpecDef(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformProofStep(o: ProofStep): MOption[ProofStep] = {
    val preR: PreResult[ProofStep] = preProofStep(o)
    val r: MOption[ProofStep] = if (preR.continu) {
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
          val r2: MOption[IS[Z, ProofStep]] = transformISZ(o2.steps, transformProofStep)
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
    val postR: MOption[ProofStep] = postProofStep(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformAssumeProofStep(o: AssumeProofStep): MOption[AssumeProofStep] = {
    val preR: PreResult[AssumeProofStep] = preAssumeProofStep(o)
    val r: MOption[AssumeProofStep] = if (preR.continu) {
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
          val r1: MOption[IS[Z, VarFragment]] = transformISZ(o2.varFragments, transformVarFragment)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(step = r0.getOrElse(o2.step), varFragments = r1.getOrElse(o2.varFragments)))
          else
            MNone()
        case o2: AssumeProofStep.ExistsElimAps =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: MOption[IS[Z, VarFragment]] = transformISZ(o2.varFragments, transformVarFragment)
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
    val postR: MOption[AssumeProofStep] = postAssumeProofStep(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformJust(o: Just): MOption[Just] = {
    val preR: PreResult[Just] = preJust(o)
    val r: MOption[Just] = if (preR.continu) {
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
          val r0: MOption[IS[Z, Exp.LitZ]] = transformISZ(o2.steps, transformExpLitZ)
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
          val r1: MOption[IS[Z, Exp.LitZ]] = transformISZ(o2.subProofSteps, transformExpLitZ)
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
          val r1: MOption[IS[Z, Exp.LitZ]] = transformISZ(o2.steps, transformExpLitZ)
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
          val r1: MOption[IS[Z, Exp]] = transformISZ(o2.args, transformExp)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(forallStep = r0.getOrElse(o2.forallStep), args = r1.getOrElse(o2.args), attr = r2.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.ExistsIntro =>
          val r0: MOption[Exp.LitZ] = transformExpLitZ(o2.existsStep)
          val r1: MOption[IS[Z, Exp]] = transformISZ(o2.args, transformExp)
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
          val r0: MOption[Option[Name]] = transformOption(o2.nameOpt, transformName)
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
          val r0: MOption[IS[Z, Exp.LitZ]] = transformISZ(o2.steps, transformExpLitZ)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(steps = r0.getOrElse(o2.steps), attr = r1.getOrElse(o2.attr)))
          else
            MNone()
        case o2: Just.Coq =>
          val r0: MOption[Exp.LitString] = transformExpLitString(o2.path)
          val r1: MOption[IS[Z, Exp.LitZ]] = transformISZ(o2.steps, transformExpLitZ)
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
    val postR: MOption[Just] = postJust(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformTruthTableRow(o: TruthTable.Row): MOption[TruthTable.Row] = {
    val preR: PreResult[TruthTable.Row] = preTruthTableRow(o)
    val r: MOption[TruthTable.Row] = if (preR.continu) {
      val o2: TruthTable.Row = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[TruthTable.Assignment] = transformTruthTableAssignment(o2.assignment)
      val r1: MOption[TruthTable.Assignment] = transformTruthTableAssignment(o2.values)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty)
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
    val postR: MOption[TruthTable.Row] = postTruthTableRow(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformTruthTableAssignment(o: TruthTable.Assignment): MOption[TruthTable.Assignment] = {
    val preR: PreResult[TruthTable.Assignment] = preTruthTableAssignment(o)
    val r: MOption[TruthTable.Assignment] = if (preR.continu) {
      val o2: TruthTable.Assignment = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Exp.LitB]] = transformISZ(o2.values, transformExpLitB)
      val r1: MOption[Attr] = transformAttr(o2.attr)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty)
        MSome(o2(values = r0.getOrElse(o2.values), attr = r1.getOrElse(o2.attr)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: TruthTable.Assignment = r.getOrElse(o)
    val postR: MOption[TruthTable.Assignment] = postTruthTableAssignment(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformTruthTableConclusion(o: TruthTable.Conclusion): MOption[TruthTable.Conclusion] = {
    val preR: PreResult[TruthTable.Conclusion] = preTruthTableConclusion(o)
    val r: MOption[TruthTable.Conclusion] = if (preR.continu) {
      val o2: TruthTable.Conclusion = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[TruthTable.Conclusion] = o2 match {
        case o2: TruthTable.Conclusion.Validity =>
          val r0: MOption[IS[Z, TruthTable.Assignment]] = transformISZ(o2.assignments, transformTruthTableAssignment)
          val r1: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(assignments = r0.getOrElse(o2.assignments), attr = r1.getOrElse(o2.attr)))
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
          val r0: MOption[IS[Z, TruthTable.Assignment]] = transformISZ(o2.trueAssignments, transformTruthTableAssignment)
          val r1: MOption[IS[Z, TruthTable.Assignment]] = transformISZ(o2.falseAssignments, transformTruthTableAssignment)
          val r2: MOption[Attr] = transformAttr(o2.attr)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty || r2.nonEmpty)
            MSome(o2(trueAssignments = r0.getOrElse(o2.trueAssignments), falseAssignments = r1.getOrElse(o2.falseAssignments), attr = r2.getOrElse(o2.attr)))
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
    val postR: MOption[TruthTable.Conclusion] = postTruthTableConclusion(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformTyped(o: Typed): MOption[Typed] = {
    val preR: PreResult[Typed] = preTyped(o)
    val r: MOption[Typed] = if (preR.continu) {
      val o2: Typed = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[Typed] = o2 match {
        case o2: Typed.Name =>
          val r0: MOption[IS[Z, Typed]] = transformISZ(o2.args, transformTyped)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(args = r0.getOrElse(o2.args)))
          else
            MNone()
        case o2: Typed.Tuple =>
          val r0: MOption[IS[Z, Typed]] = transformISZ(o2.args, transformTyped)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(args = r0.getOrElse(o2.args)))
          else
            MNone()
        case o2: Typed.Fun =>
          val r0: MOption[IS[Z, Typed]] = transformISZ(o2.args, transformTyped)
          val r1: MOption[Typed] = transformTyped(o2.ret)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(args = r0.getOrElse(o2.args), ret = r1.getOrElse(o2.ret)))
          else
            MNone()
        case o2: Typed.TypeVar =>
          if (hasChanged)
            MSome(o2)
          else
            MNone()
        case o2: Typed.Package =>
          if (hasChanged)
            MSome(o2)
          else
            MNone()
        case o2: Typed.Object =>
          if (hasChanged)
            MSome(o2)
          else
            MNone()
        case o2: Typed.Enum =>
          if (hasChanged)
            MSome(o2)
          else
            MNone()
        case o2: Typed.Method =>
          val r0: MOption[IS[Z, Typed.Method.Subst]] = transformISZ(o2.substs, transformTypedMethodSubst)
          val r1: MOption[Typed.Fun] = transformTypedFun(o2.tpe)
          if (hasChanged || r0.nonEmpty || r1.nonEmpty)
            MSome(o2(substs = r0.getOrElse(o2.substs), tpe = r1.getOrElse(o2.tpe)))
          else
            MNone()
        case o2: Typed.Methods =>
          val r0: MOption[IS[Z, Typed.Method]] = transformISZ(o2.methods, transformTypedMethod)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(methods = r0.getOrElse(o2.methods)))
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
    val o2: Typed = r.getOrElse(o)
    val postR: MOption[Typed] = postTyped(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformTypedMethodSubst(o: Typed.Method.Subst): MOption[Typed.Method.Subst] = {
    val preR: PreResult[Typed.Method.Subst] = preTypedMethodSubst(o)
    val r: MOption[Typed.Method.Subst] = if (preR.continu) {
      val o2: Typed.Method.Subst = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Typed] = transformTyped(o2.tipe)
      if (hasChanged || r0.nonEmpty)
        MSome(o2(tipe = r0.getOrElse(o2.tipe)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Typed.Method.Subst = r.getOrElse(o)
    val postR: MOption[Typed.Method.Subst] = postTypedMethodSubst(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformAttr(o: Attr): MOption[Attr] = {
    val preR: PreResult[Attr] = preAttr(o)
    val r: MOption[Attr] = if (preR.continu) {
      val o2: Attr = preR.resultOpt.getOrElse(o)
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
    val o2: Attr = r.getOrElse(o)
    val postR: MOption[Attr] = postAttr(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformTypedAttr(o: TypedAttr): MOption[TypedAttr] = {
    val preR: PreResult[TypedAttr] = preTypedAttr(o)
    val r: MOption[TypedAttr] = if (preR.continu) {
      val o2: TypedAttr = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Option[Typed]] = transformOption(o2.typedOpt, transformTyped)
      if (hasChanged || r0.nonEmpty)
        MSome(o2(typedOpt = r0.getOrElse(o2.typedOpt)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: TypedAttr = r.getOrElse(o)
    val postR: MOption[TypedAttr] = postTypedAttr(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformResolvedAttr(o: ResolvedAttr): MOption[ResolvedAttr] = {
    val preR: PreResult[ResolvedAttr] = preResolvedAttr(o)
    val r: MOption[ResolvedAttr] = if (preR.continu) {
      val o2: ResolvedAttr = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Option[ResolvedInfo]] = transformOption(o2.resOpt, transformResolvedInfo)
      val r1: MOption[Option[Typed]] = transformOption(o2.typedOpt, transformTyped)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty)
        MSome(o2(resOpt = r0.getOrElse(o2.resOpt), typedOpt = r1.getOrElse(o2.typedOpt)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: ResolvedAttr = r.getOrElse(o)
    val postR: MOption[ResolvedAttr] = postResolvedAttr(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformResolvedInfo(o: ResolvedInfo): MOption[ResolvedInfo] = {
    val preR: PreResult[ResolvedInfo] = preResolvedInfo(o)
    val r: MOption[ResolvedInfo] = if (preR.continu) {
      val o2: ResolvedInfo = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: MOption[ResolvedInfo] = o2 match {
        case o2: ResolvedInfo.BuiltIn =>
          if (hasChanged)
            MSome(o2)
          else
            MNone()
        case o2: ResolvedInfo.Package =>
          if (hasChanged)
            MSome(o2)
          else
            MNone()
        case o2: ResolvedInfo.Enum =>
          if (hasChanged)
            MSome(o2)
          else
            MNone()
        case o2: ResolvedInfo.EnumElement =>
          if (hasChanged)
            MSome(o2)
          else
            MNone()
        case o2: ResolvedInfo.Object =>
          if (hasChanged)
            MSome(o2)
          else
            MNone()
        case o2: ResolvedInfo.Var =>
          if (hasChanged)
            MSome(o2)
          else
            MNone()
        case o2: ResolvedInfo.Method =>
          val r0: MOption[Option[Typed.Fun]] = transformOption(o2.tpeOpt, transformTypedFun)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(tpeOpt = r0.getOrElse(o2.tpeOpt)))
          else
            MNone()
        case o2: ResolvedInfo.Methods =>
          val r0: MOption[IS[Z, ResolvedInfo.Method]] = transformISZ(o2.methods, transformResolvedInfoMethod)
          if (hasChanged || r0.nonEmpty)
            MSome(o2(methods = r0.getOrElse(o2.methods)))
          else
            MNone()
        case o2: ResolvedInfo.Type =>
          if (hasChanged)
            MSome(o2)
          else
            MNone()
        case o2: ResolvedInfo.Tuple =>
          if (hasChanged)
            MSome(o2)
          else
            MNone()
        case o2: ResolvedInfo.LocalVar =>
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
    val o2: ResolvedInfo = r.getOrElse(o)
    val postR: MOption[ResolvedInfo] = postResolvedInfo(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformLClauseProof(o: LClause.Proof): MOption[LClause.Proof] = {
    val preR: PreResult[LClause.Proof] = preLClauseProof(o) match {
     case PreResult(continu, MSome(r: LClause.Proof)) => PreResult(continu, MSome[LClause.Proof](r))
     case PreResult(_, MSome(_)) => halt("Can only produce object of type LClause.Proof")
     case PreResult(continu, _) => PreResult(continu, MNone[LClause.Proof]())
    }
    val r: MOption[LClause.Proof] = if (preR.continu) {
      val o2: LClause.Proof = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, ProofStep]] = transformISZ(o2.steps, transformProofStep)
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
    val postR: MOption[LClause.Proof] = postLClauseProof(o2) match {
     case MSome(result: LClause.Proof) => MSome[LClause.Proof](result)
     case MSome(_) => halt("Can only produce object of type LClause.Proof")
     case _ => MNone[LClause.Proof]()
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
    val preR: PreResult[LClause.Sequent] = preLClauseSequent(o) match {
     case PreResult(continu, MSome(r: LClause.Sequent)) => PreResult(continu, MSome[LClause.Sequent](r))
     case PreResult(_, MSome(_)) => halt("Can only produce object of type LClause.Sequent")
     case PreResult(continu, _) => PreResult(continu, MNone[LClause.Sequent]())
    }
    val r: MOption[LClause.Sequent] = if (preR.continu) {
      val o2: LClause.Sequent = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Exp]] = transformISZ(o2.premises, transformExp)
      val r1: MOption[IS[Z, Exp]] = transformISZ(o2.conclusions, transformExp)
      val r2: MOption[Option[LClause.Proof]] = transformOption(o2.proofOpt, transformLClauseProof)
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
    val postR: MOption[LClause.Sequent] = postLClauseSequent(o2) match {
     case MSome(result: LClause.Sequent) => MSome[LClause.Sequent](result)
     case MSome(_) => halt("Can only produce object of type LClause.Sequent")
     case _ => MNone[LClause.Sequent]()
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
    val preR: PreResult[Type.Named] = preTypeNamed(o) match {
     case PreResult(continu, MSome(r: Type.Named)) => PreResult(continu, MSome[Type.Named](r))
     case PreResult(_, MSome(_)) => halt("Can only produce object of type Type.Named")
     case PreResult(continu, _) => PreResult(continu, MNone[Type.Named]())
    }
    val r: MOption[Type.Named] = if (preR.continu) {
      val o2: Type.Named = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Name] = transformName(o2.name)
      val r1: MOption[IS[Z, Type]] = transformISZ(o2.typeArgs, transformType)
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
    val postR: MOption[Type.Named] = postTypeNamed(o2) match {
     case MSome(result: Type.Named) => MSome[Type.Named](result)
     case MSome(_) => halt("Can only produce object of type Type.Named")
     case _ => MNone[Type.Named]()
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
    val preR: PreResult[Exp.LitString] = preExpLitString(o) match {
     case PreResult(continu, MSome(r: Exp.LitString)) => PreResult(continu, MSome[Exp.LitString](r))
     case PreResult(_, MSome(_)) => halt("Can only produce object of type Exp.LitString")
     case PreResult(continu, _) => PreResult(continu, MNone[Exp.LitString]())
    }
    val r: MOption[Exp.LitString] = if (preR.continu) {
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
    val postR: MOption[Exp.LitString] = postExpLitString(o2) match {
     case MSome(result: Exp.LitString) => MSome[Exp.LitString](result)
     case MSome(_) => halt("Can only produce object of type Exp.LitString")
     case _ => MNone[Exp.LitString]()
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
    val preR: PreResult[Exp.LitZ] = preExpLitZ(o) match {
     case PreResult(continu, MSome(r: Exp.LitZ)) => PreResult(continu, MSome[Exp.LitZ](r))
     case PreResult(_, MSome(_)) => halt("Can only produce object of type Exp.LitZ")
     case PreResult(continu, _) => PreResult(continu, MNone[Exp.LitZ]())
    }
    val r: MOption[Exp.LitZ] = if (preR.continu) {
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
    val postR: MOption[Exp.LitZ] = postExpLitZ(o2) match {
     case MSome(result: Exp.LitZ) => MSome[Exp.LitZ](result)
     case MSome(_) => halt("Can only produce object of type Exp.LitZ")
     case _ => MNone[Exp.LitZ]()
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
    val preR: PreResult[Exp.LitB] = preExpLitB(o) match {
     case PreResult(continu, MSome(r: Exp.LitB)) => PreResult(continu, MSome[Exp.LitB](r))
     case PreResult(_, MSome(_)) => halt("Can only produce object of type Exp.LitB")
     case PreResult(continu, _) => PreResult(continu, MNone[Exp.LitB]())
    }
    val r: MOption[Exp.LitB] = if (preR.continu) {
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
    val postR: MOption[Exp.LitB] = postExpLitB(o2) match {
     case MSome(result: Exp.LitB) => MSome[Exp.LitB](result)
     case MSome(_) => halt("Can only produce object of type Exp.LitB")
     case _ => MNone[Exp.LitB]()
    }
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformTypedFun(o: Typed.Fun): MOption[Typed.Fun] = {
    val preR: PreResult[Typed.Fun] = preTypedFun(o) match {
     case PreResult(continu, MSome(r: Typed.Fun)) => PreResult(continu, MSome[Typed.Fun](r))
     case PreResult(_, MSome(_)) => halt("Can only produce object of type Typed.Fun")
     case PreResult(continu, _) => PreResult(continu, MNone[Typed.Fun]())
    }
    val r: MOption[Typed.Fun] = if (preR.continu) {
      val o2: Typed.Fun = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Typed]] = transformISZ(o2.args, transformTyped)
      val r1: MOption[Typed] = transformTyped(o2.ret)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty)
        MSome(o2(args = r0.getOrElse(o2.args), ret = r1.getOrElse(o2.ret)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Typed.Fun = r.getOrElse(o)
    val postR: MOption[Typed.Fun] = postTypedFun(o2) match {
     case MSome(result: Typed.Fun) => MSome[Typed.Fun](result)
     case MSome(_) => halt("Can only produce object of type Typed.Fun")
     case _ => MNone[Typed.Fun]()
    }
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformTypedMethod(o: Typed.Method): MOption[Typed.Method] = {
    val preR: PreResult[Typed.Method] = preTypedMethod(o) match {
     case PreResult(continu, MSome(r: Typed.Method)) => PreResult(continu, MSome[Typed.Method](r))
     case PreResult(_, MSome(_)) => halt("Can only produce object of type Typed.Method")
     case PreResult(continu, _) => PreResult(continu, MNone[Typed.Method]())
    }
    val r: MOption[Typed.Method] = if (preR.continu) {
      val o2: Typed.Method = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[IS[Z, Typed.Method.Subst]] = transformISZ(o2.substs, transformTypedMethodSubst)
      val r1: MOption[Typed.Fun] = transformTypedFun(o2.tpe)
      if (hasChanged || r0.nonEmpty || r1.nonEmpty)
        MSome(o2(substs = r0.getOrElse(o2.substs), tpe = r1.getOrElse(o2.tpe)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Typed.Method = r.getOrElse(o)
    val postR: MOption[Typed.Method] = postTypedMethod(o2) match {
     case MSome(result: Typed.Method) => MSome[Typed.Method](result)
     case MSome(_) => halt("Can only produce object of type Typed.Method")
     case _ => MNone[Typed.Method]()
    }
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return MSome(o2)
    } else {
      return MNone()
    }
  }

  def transformResolvedInfoMethod(o: ResolvedInfo.Method): MOption[ResolvedInfo.Method] = {
    val preR: PreResult[ResolvedInfo.Method] = preResolvedInfoMethod(o) match {
     case PreResult(continu, MSome(r: ResolvedInfo.Method)) => PreResult(continu, MSome[ResolvedInfo.Method](r))
     case PreResult(_, MSome(_)) => halt("Can only produce object of type ResolvedInfo.Method")
     case PreResult(continu, _) => PreResult(continu, MNone[ResolvedInfo.Method]())
    }
    val r: MOption[ResolvedInfo.Method] = if (preR.continu) {
      val o2: ResolvedInfo.Method = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: MOption[Option[Typed.Fun]] = transformOption(o2.tpeOpt, transformTypedFun)
      if (hasChanged || r0.nonEmpty)
        MSome(o2(tpeOpt = r0.getOrElse(o2.tpeOpt)))
      else
        MNone()
    } else if (preR.resultOpt.nonEmpty) {
      MSome(preR.resultOpt.getOrElse(o))
    } else {
      MNone()
    }
    val hasChanged: B = r.nonEmpty
    val o2: ResolvedInfo.Method = r.getOrElse(o)
    val postR: MOption[ResolvedInfo.Method] = postResolvedInfoMethod(o2) match {
     case MSome(result: ResolvedInfo.Method) => MSome[ResolvedInfo.Method](result)
     case MSome(_) => halt("Can only produce object of type ResolvedInfo.Method")
     case _ => MNone[ResolvedInfo.Method]()
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