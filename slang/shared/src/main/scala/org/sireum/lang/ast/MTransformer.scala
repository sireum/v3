// #Sireum
// @formatter:off
// This file is auto-generated from file:/Users/robby/Repositories/Sireum/sireum-v3/slang/shared/src/main/scala/org/sireum/lang/ast/AST.scala
package org.sireum.lang.ast

import org.sireum._

object MTransformer {

  @datatype class PreResult[T](continue: B,
                               resultOpt: Option[T])

  @sig trait Pre {

    def transformTopUnit(o: TopUnit): PreResult[TopUnit] = {
      o match {
        case o: TopUnit.Program => return transformTopUnitProgram(o)
        case o: TopUnit.SequentUnit => return transformTopUnitSequentUnit(o)
        case o: TopUnit.TruthTableUnit => return transformTopUnitTruthTableUnit(o)
      }
    }

    def transformTopUnitProgram(o: TopUnit.Program): PreResult[TopUnit] = {
      return PreResult(T, None())
    }

    def transformTopUnitSequentUnit(o: TopUnit.SequentUnit): PreResult[TopUnit] = {
      return PreResult(T, None())
    }

    def transformTopUnitTruthTableUnit(o: TopUnit.TruthTableUnit): PreResult[TopUnit] = {
      return PreResult(T, None())
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
      return PreResult(T, None())
    }

    def transformStmtImportImporter(o: Stmt.Import.Importer): PreResult[Stmt.Import.Importer] = {
      return PreResult(T, None())
    }

    def transformStmtImportSelector(o: Stmt.Import.Selector): PreResult[Stmt.Import.Selector] = {
      o match {
        case o: Stmt.Import.MultiSelector => return transformStmtImportMultiSelector(o)
        case o: Stmt.Import.WildcardSelector => return transformStmtImportWildcardSelector(o)
      }
    }

    def transformStmtImportMultiSelector(o: Stmt.Import.MultiSelector): PreResult[Stmt.Import.Selector] = {
      return PreResult(T, None())
    }

    def transformStmtImportWildcardSelector(o: Stmt.Import.WildcardSelector): PreResult[Stmt.Import.Selector] = {
      return PreResult(T, None())
    }

    def transformStmtImportNamedSelector(o: Stmt.Import.NamedSelector): PreResult[Stmt.Import.NamedSelector] = {
      return PreResult(T, None())
    }

    def transformStmtVar(o: Stmt.Var): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtVarPattern(o: Stmt.VarPattern): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtSpecVar(o: Stmt.SpecVar): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtMethod(o: Stmt.Method): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtExtMethod(o: Stmt.ExtMethod): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtSpecMethod(o: Stmt.SpecMethod): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtEnum(o: Stmt.Enum): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtObject(o: Stmt.Object): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtSig(o: Stmt.Sig): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtAbstractDatatype(o: Stmt.AbstractDatatype): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtRich(o: Stmt.Rich): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtTypeAlias(o: Stmt.TypeAlias): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtAssign(o: Stmt.Assign): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtAssignUp(o: Stmt.AssignUp): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtAssignPattern(o: Stmt.AssignPattern): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtBlock(o: Stmt.Block): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtIf(o: Stmt.If): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtMatch(o: Stmt.Match): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtWhile(o: Stmt.While): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtDoWhile(o: Stmt.DoWhile): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtFor(o: Stmt.For): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtReturn(o: Stmt.Return): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtLStmt(o: Stmt.LStmt): PreResult[Stmt] = {
      return PreResult(T, None())
    }

    def transformStmtExpr(o: Stmt.Expr): PreResult[Stmt] = {
      return PreResult(T, None())
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
      return PreResult(T, None())
    }

    def transformLClauseFacts(o: LClause.Facts): PreResult[LClause] = {
      return PreResult(T, None())
    }

    def transformLClauseFact(o: LClause.Fact): PreResult[LClause.Fact] = {
      return PreResult(T, None())
    }

    def transformLClauseTheorems(o: LClause.Theorems): PreResult[LClause] = {
      return PreResult(T, None())
    }

    def transformLClauseTheorem(o: LClause.Theorem): PreResult[LClause.Theorem] = {
      return PreResult(T, None())
    }

    def transformLClauseSequent(o: LClause.Sequent): PreResult[LClause] = {
      return PreResult(T, None())
    }

    def transformLClauseProof(o: LClause.Proof): PreResult[LClause] = {
      return PreResult(T, None())
    }

    def transformContractExp(o: ContractExp): PreResult[ContractExp] = {
      return PreResult(T, None())
    }

    def transformCase(o: Case): PreResult[Case] = {
      return PreResult(T, None())
    }

    def transformRange(o: Range): PreResult[Range] = {
      o match {
        case o: Range.Expr => return transformRangeExpr(o)
        case o: Range.Indices => return transformRangeIndices(o)
        case o: Range.Step => return transformRangeStep(o)
      }
    }

    def transformRangeExpr(o: Range.Expr): PreResult[Range] = {
      return PreResult(T, None())
    }

    def transformRangeIndices(o: Range.Indices): PreResult[Range] = {
      return PreResult(T, None())
    }

    def transformRangeStep(o: Range.Step): PreResult[Range] = {
      return PreResult(T, None())
    }

    def transformType(o: Type): PreResult[Type] = {
      o match {
        case o: Type.Named => return transformTypeNamed(o)
        case o: Type.Fun => return transformTypeFun(o)
        case o: Type.Tuple => return transformTypeTuple(o)
      }
    }

    def transformTypeNamed(o: Type.Named): PreResult[Type] = {
      return PreResult(T, None())
    }

    def transformTypeFun(o: Type.Fun): PreResult[Type] = {
      return PreResult(T, None())
    }

    def transformTypeTuple(o: Type.Tuple): PreResult[Type] = {
      return PreResult(T, None())
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
      return PreResult(T, None())
    }

    def transformPatternRef(o: Pattern.Ref): PreResult[Pattern] = {
      return PreResult(T, None())
    }

    def transformPatternVariable(o: Pattern.Variable): PreResult[Pattern] = {
      return PreResult(T, None())
    }

    def transformPatternWildcard(o: Pattern.Wildcard): PreResult[Pattern] = {
      return PreResult(T, None())
    }

    def transformPatternSeqWildcard(o: Pattern.SeqWildcard): PreResult[Pattern] = {
      return PreResult(T, None())
    }

    def transformPatternStructure(o: Pattern.Structure): PreResult[Pattern] = {
      return PreResult(T, None())
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
      return PreResult(T, None())
    }

    def transformExpLitC(o: Exp.LitC): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitZ(o: Exp.LitZ): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitZ8(o: Exp.LitZ8): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitZ16(o: Exp.LitZ16): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitZ32(o: Exp.LitZ32): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitZ64(o: Exp.LitZ64): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitN(o: Exp.LitN): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitN8(o: Exp.LitN8): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitN16(o: Exp.LitN16): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitN32(o: Exp.LitN32): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitN64(o: Exp.LitN64): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitS8(o: Exp.LitS8): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitS16(o: Exp.LitS16): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitS32(o: Exp.LitS32): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitS64(o: Exp.LitS64): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitU8(o: Exp.LitU8): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitU16(o: Exp.LitU16): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitU32(o: Exp.LitU32): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitU64(o: Exp.LitU64): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitF32(o: Exp.LitF32): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitF64(o: Exp.LitF64): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitR(o: Exp.LitR): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitBv(o: Exp.LitBv): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpLitString(o: Exp.LitString): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpStringInterpolate(o: Exp.StringInterpolate): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpThis(o: Exp.This): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpUnary(o: Exp.Unary): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpBinary(o: Exp.Binary): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpIdent(o: Exp.Ident): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpEta(o: Exp.Eta): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpTuple(o: Exp.Tuple): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpSelect(o: Exp.Select): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpInvoke(o: Exp.Invoke): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpInvokeNamed(o: Exp.InvokeNamed): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpIf(o: Exp.If): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformExpQuant(o: Exp.Quant): PreResult[Exp] = {
      return PreResult(T, None())
    }

    def transformNamedArg(o: NamedArg): PreResult[NamedArg] = {
      return PreResult(T, None())
    }

    def transformVarFragment(o: VarFragment): PreResult[VarFragment] = {
      return PreResult(T, None())
    }

    def transformDomain(o: Domain): PreResult[Domain] = {
      o match {
        case o: Domain.Type => return transformDomainType(o)
        case o: Domain.Range => return transformDomainRange(o)
      }
    }

    def transformDomainType(o: Domain.Type): PreResult[Domain] = {
      return PreResult(T, None())
    }

    def transformDomainRange(o: Domain.Range): PreResult[Domain] = {
      return PreResult(T, None())
    }

    def transformId(o: Id): PreResult[Id] = {
      return PreResult(T, None())
    }

    def transformName(o: Name): PreResult[Name] = {
      return PreResult(T, None())
    }

    def transformBody(o: Body): PreResult[Body] = {
      return PreResult(T, None())
    }

    def transformAbstractDatatypeParam(o: AbstractDatatypeParam): PreResult[AbstractDatatypeParam] = {
      return PreResult(T, None())
    }

    def transformMethodSig(o: MethodSig): PreResult[MethodSig] = {
      return PreResult(T, None())
    }

    def transformParam(o: Param): PreResult[Param] = {
      return PreResult(T, None())
    }

    def transformTypeParam(o: TypeParam): PreResult[TypeParam] = {
      return PreResult(T, None())
    }

    def transformContract(o: Contract): PreResult[Contract] = {
      return PreResult(T, None())
    }

    def transformSubContract(o: SubContract): PreResult[SubContract] = {
      return PreResult(T, None())
    }

    def transformSubContractParam(o: SubContractParam): PreResult[SubContractParam] = {
      return PreResult(T, None())
    }

    def transformWhereDef(o: WhereDef): PreResult[WhereDef] = {
      o match {
        case o: WhereDef.Val => return transformWhereDefVal(o)
        case o: WhereDef.Def => return transformWhereDefDef(o)
      }
    }

    def transformWhereDefVal(o: WhereDef.Val): PreResult[WhereDef] = {
      return PreResult(T, None())
    }

    def transformWhereDefDef(o: WhereDef.Def): PreResult[WhereDef] = {
      return PreResult(T, None())
    }

    def transformSpecDef(o: SpecDef): PreResult[SpecDef] = {
      return PreResult(T, None())
    }

    def transformProofStep(o: ProofStep): PreResult[ProofStep] = {
      o match {
        case o: ProofStep.Basic => return transformProofStepBasic(o)
        case o: ProofStep.SubProof => return transformProofStepSubProof(o)
      }
    }

    def transformProofStepBasic(o: ProofStep.Basic): PreResult[ProofStep] = {
      return PreResult(T, None())
    }

    def transformProofStepSubProof(o: ProofStep.SubProof): PreResult[ProofStep] = {
      return PreResult(T, None())
    }

    def transformAssumeProofStep(o: AssumeProofStep): PreResult[AssumeProofStep] = {
      o match {
        case o: AssumeProofStep.Regular => return transformAssumeProofStepRegular(o)
        case o: AssumeProofStep.ForallIntroAps => return transformAssumeProofStepForallIntroAps(o)
        case o: AssumeProofStep.ExistsElimAps => return transformAssumeProofStepExistsElimAps(o)
      }
    }

    def transformAssumeProofStepRegular(o: AssumeProofStep.Regular): PreResult[AssumeProofStep] = {
      return PreResult(T, None())
    }

    def transformAssumeProofStepForallIntroAps(o: AssumeProofStep.ForallIntroAps): PreResult[AssumeProofStep] = {
      return PreResult(T, None())
    }

    def transformAssumeProofStepExistsElimAps(o: AssumeProofStep.ExistsElimAps): PreResult[AssumeProofStep] = {
      return PreResult(T, None())
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
      return PreResult(T, None())
    }

    def transformJustAndIntro(o: Just.AndIntro): PreResult[Just] = {
      return PreResult(T, None())
    }

    def transformJustAndElim(o: Just.AndElim): PreResult[Just] = {
      return PreResult(T, None())
    }

    def transformJustOrIntro(o: Just.OrIntro): PreResult[Just] = {
      return PreResult(T, None())
    }

    def transformJustOrElim(o: Just.OrElim): PreResult[Just] = {
      return PreResult(T, None())
    }

    def transformJustImplyIntro(o: Just.ImplyIntro): PreResult[Just] = {
      return PreResult(T, None())
    }

    def transformJustImplyElim(o: Just.ImplyElim): PreResult[Just] = {
      return PreResult(T, None())
    }

    def transformJustNegIntro(o: Just.NegIntro): PreResult[Just] = {
      return PreResult(T, None())
    }

    def transformJustNegElim(o: Just.NegElim): PreResult[Just] = {
      return PreResult(T, None())
    }

    def transformJustBottomElim(o: Just.BottomElim): PreResult[Just] = {
      return PreResult(T, None())
    }

    def transformJustPbc(o: Just.Pbc): PreResult[Just] = {
      return PreResult(T, None())
    }

    def transformJustForallIntro(o: Just.ForallIntro): PreResult[Just] = {
      return PreResult(T, None())
    }

    def transformJustForallElim(o: Just.ForallElim): PreResult[Just] = {
      return PreResult(T, None())
    }

    def transformJustExistsIntro(o: Just.ExistsIntro): PreResult[Just] = {
      return PreResult(T, None())
    }

    def transformJustExistsElim(o: Just.ExistsElim): PreResult[Just] = {
      return PreResult(T, None())
    }

    def transformJustFact(o: Just.Fact): PreResult[Just] = {
      return PreResult(T, None())
    }

    def transformJustInvariant(o: Just.Invariant): PreResult[Just] = {
      return PreResult(T, None())
    }

    def transformJustSubst(o: Just.Subst): PreResult[Just] = {
      return PreResult(T, None())
    }

    def transformJustAuto(o: Just.Auto): PreResult[Just] = {
      return PreResult(T, None())
    }

    def transformJustCoq(o: Just.Coq): PreResult[Just] = {
      return PreResult(T, None())
    }

    def transformTruthTableRow(o: TruthTable.Row): PreResult[TruthTable.Row] = {
      return PreResult(T, None())
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
      return PreResult(T, None())
    }

    def transformTruthTableConclusionTautology(o: TruthTable.Conclusion.Tautology): PreResult[TruthTable.Conclusion] = {
      return PreResult(T, None())
    }

    def transformTruthTableConclusionContradictory(o: TruthTable.Conclusion.Contradictory): PreResult[TruthTable.Conclusion] = {
      return PreResult(T, None())
    }

    def transformTruthTableConclusionContingent(o: TruthTable.Conclusion.Contingent): PreResult[TruthTable.Conclusion] = {
      return PreResult(T, None())
    }

    def transformAttr(o: Attr): PreResult[Attr] = {
      return PreResult(T, None())
    }

    def transformTypedAttr(o: TypedAttr): PreResult[TypedAttr] = {
      return PreResult(T, None())
    }

    def transformResolvedAttr(o: ResolvedAttr): PreResult[ResolvedAttr] = {
      return PreResult(T, None())
    }

    def transformResolvedInfo(o: ResolvedInfo): PreResult[ResolvedInfo] = {
      return PreResult(T, None())
    }

    def transformPosInfo(o: PosInfo): PreResult[PosInfo] = {
      return PreResult(T, None())
    }

  }

  @sig trait Post {

    def transformTopUnit(o: TopUnit): Option[TopUnit] = {
      o match {
        case o: TopUnit.Program => return transformTopUnitProgram(o)
        case o: TopUnit.SequentUnit => return transformTopUnitSequentUnit(o)
        case o: TopUnit.TruthTableUnit => return transformTopUnitTruthTableUnit(o)
      }
    }

    def transformTopUnitProgram(o: TopUnit.Program): Option[TopUnit] = {
      return None()
    }

    def transformTopUnitSequentUnit(o: TopUnit.SequentUnit): Option[TopUnit] = {
      return None()
    }

    def transformTopUnitTruthTableUnit(o: TopUnit.TruthTableUnit): Option[TopUnit] = {
      return None()
    }

    def transformStmt(o: Stmt): Option[Stmt] = {
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

    def transformStmtImport(o: Stmt.Import): Option[Stmt] = {
      return None()
    }

    def transformStmtImportImporter(o: Stmt.Import.Importer): Option[Stmt.Import.Importer] = {
      return None()
    }

    def transformStmtImportSelector(o: Stmt.Import.Selector): Option[Stmt.Import.Selector] = {
      o match {
        case o: Stmt.Import.MultiSelector => return transformStmtImportMultiSelector(o)
        case o: Stmt.Import.WildcardSelector => return transformStmtImportWildcardSelector(o)
      }
    }

    def transformStmtImportMultiSelector(o: Stmt.Import.MultiSelector): Option[Stmt.Import.Selector] = {
      return None()
    }

    def transformStmtImportWildcardSelector(o: Stmt.Import.WildcardSelector): Option[Stmt.Import.Selector] = {
      return None()
    }

    def transformStmtImportNamedSelector(o: Stmt.Import.NamedSelector): Option[Stmt.Import.NamedSelector] = {
      return None()
    }

    def transformStmtVar(o: Stmt.Var): Option[Stmt] = {
      return None()
    }

    def transformStmtVarPattern(o: Stmt.VarPattern): Option[Stmt] = {
      return None()
    }

    def transformStmtSpecVar(o: Stmt.SpecVar): Option[Stmt] = {
      return None()
    }

    def transformStmtMethod(o: Stmt.Method): Option[Stmt] = {
      return None()
    }

    def transformStmtExtMethod(o: Stmt.ExtMethod): Option[Stmt] = {
      return None()
    }

    def transformStmtSpecMethod(o: Stmt.SpecMethod): Option[Stmt] = {
      return None()
    }

    def transformStmtEnum(o: Stmt.Enum): Option[Stmt] = {
      return None()
    }

    def transformStmtObject(o: Stmt.Object): Option[Stmt] = {
      return None()
    }

    def transformStmtSig(o: Stmt.Sig): Option[Stmt] = {
      return None()
    }

    def transformStmtAbstractDatatype(o: Stmt.AbstractDatatype): Option[Stmt] = {
      return None()
    }

    def transformStmtRich(o: Stmt.Rich): Option[Stmt] = {
      return None()
    }

    def transformStmtTypeAlias(o: Stmt.TypeAlias): Option[Stmt] = {
      return None()
    }

    def transformStmtAssign(o: Stmt.Assign): Option[Stmt] = {
      return None()
    }

    def transformStmtAssignUp(o: Stmt.AssignUp): Option[Stmt] = {
      return None()
    }

    def transformStmtAssignPattern(o: Stmt.AssignPattern): Option[Stmt] = {
      return None()
    }

    def transformStmtBlock(o: Stmt.Block): Option[Stmt] = {
      return None()
    }

    def transformStmtIf(o: Stmt.If): Option[Stmt] = {
      return None()
    }

    def transformStmtMatch(o: Stmt.Match): Option[Stmt] = {
      return None()
    }

    def transformStmtWhile(o: Stmt.While): Option[Stmt] = {
      return None()
    }

    def transformStmtDoWhile(o: Stmt.DoWhile): Option[Stmt] = {
      return None()
    }

    def transformStmtFor(o: Stmt.For): Option[Stmt] = {
      return None()
    }

    def transformStmtReturn(o: Stmt.Return): Option[Stmt] = {
      return None()
    }

    def transformStmtLStmt(o: Stmt.LStmt): Option[Stmt] = {
      return None()
    }

    def transformStmtExpr(o: Stmt.Expr): Option[Stmt] = {
      return None()
    }

    def transformLClause(o: LClause): Option[LClause] = {
      o match {
        case o: LClause.Invariants => return transformLClauseInvariants(o)
        case o: LClause.Facts => return transformLClauseFacts(o)
        case o: LClause.Theorems => return transformLClauseTheorems(o)
        case o: LClause.Sequent => return transformLClauseSequent(o)
        case o: LClause.Proof => return transformLClauseProof(o)
      }
    }

    def transformLClauseInvariants(o: LClause.Invariants): Option[LClause] = {
      return None()
    }

    def transformLClauseFacts(o: LClause.Facts): Option[LClause] = {
      return None()
    }

    def transformLClauseFact(o: LClause.Fact): Option[LClause.Fact] = {
      return None()
    }

    def transformLClauseTheorems(o: LClause.Theorems): Option[LClause] = {
      return None()
    }

    def transformLClauseTheorem(o: LClause.Theorem): Option[LClause.Theorem] = {
      return None()
    }

    def transformLClauseSequent(o: LClause.Sequent): Option[LClause] = {
      return None()
    }

    def transformLClauseProof(o: LClause.Proof): Option[LClause] = {
      return None()
    }

    def transformContractExp(o: ContractExp): Option[ContractExp] = {
      return None()
    }

    def transformCase(o: Case): Option[Case] = {
      return None()
    }

    def transformRange(o: Range): Option[Range] = {
      o match {
        case o: Range.Expr => return transformRangeExpr(o)
        case o: Range.Indices => return transformRangeIndices(o)
        case o: Range.Step => return transformRangeStep(o)
      }
    }

    def transformRangeExpr(o: Range.Expr): Option[Range] = {
      return None()
    }

    def transformRangeIndices(o: Range.Indices): Option[Range] = {
      return None()
    }

    def transformRangeStep(o: Range.Step): Option[Range] = {
      return None()
    }

    def transformType(o: Type): Option[Type] = {
      o match {
        case o: Type.Named => return transformTypeNamed(o)
        case o: Type.Fun => return transformTypeFun(o)
        case o: Type.Tuple => return transformTypeTuple(o)
      }
    }

    def transformTypeNamed(o: Type.Named): Option[Type] = {
      return None()
    }

    def transformTypeFun(o: Type.Fun): Option[Type] = {
      return None()
    }

    def transformTypeTuple(o: Type.Tuple): Option[Type] = {
      return None()
    }

    def transformPattern(o: Pattern): Option[Pattern] = {
      o match {
        case o: Pattern.Literal => return transformPatternLiteral(o)
        case o: Pattern.Ref => return transformPatternRef(o)
        case o: Pattern.Variable => return transformPatternVariable(o)
        case o: Pattern.Wildcard => return transformPatternWildcard(o)
        case o: Pattern.SeqWildcard => return transformPatternSeqWildcard(o)
        case o: Pattern.Structure => return transformPatternStructure(o)
      }
    }

    def transformPatternLiteral(o: Pattern.Literal): Option[Pattern] = {
      return None()
    }

    def transformPatternRef(o: Pattern.Ref): Option[Pattern] = {
      return None()
    }

    def transformPatternVariable(o: Pattern.Variable): Option[Pattern] = {
      return None()
    }

    def transformPatternWildcard(o: Pattern.Wildcard): Option[Pattern] = {
      return None()
    }

    def transformPatternSeqWildcard(o: Pattern.SeqWildcard): Option[Pattern] = {
      return None()
    }

    def transformPatternStructure(o: Pattern.Structure): Option[Pattern] = {
      return None()
    }

    def transformExp(o: Exp): Option[Exp] = {
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

    def transformExpLitB(o: Exp.LitB): Option[Exp] = {
      return None()
    }

    def transformExpLitC(o: Exp.LitC): Option[Exp] = {
      return None()
    }

    def transformExpLitZ(o: Exp.LitZ): Option[Exp] = {
      return None()
    }

    def transformExpLitZ8(o: Exp.LitZ8): Option[Exp] = {
      return None()
    }

    def transformExpLitZ16(o: Exp.LitZ16): Option[Exp] = {
      return None()
    }

    def transformExpLitZ32(o: Exp.LitZ32): Option[Exp] = {
      return None()
    }

    def transformExpLitZ64(o: Exp.LitZ64): Option[Exp] = {
      return None()
    }

    def transformExpLitN(o: Exp.LitN): Option[Exp] = {
      return None()
    }

    def transformExpLitN8(o: Exp.LitN8): Option[Exp] = {
      return None()
    }

    def transformExpLitN16(o: Exp.LitN16): Option[Exp] = {
      return None()
    }

    def transformExpLitN32(o: Exp.LitN32): Option[Exp] = {
      return None()
    }

    def transformExpLitN64(o: Exp.LitN64): Option[Exp] = {
      return None()
    }

    def transformExpLitS8(o: Exp.LitS8): Option[Exp] = {
      return None()
    }

    def transformExpLitS16(o: Exp.LitS16): Option[Exp] = {
      return None()
    }

    def transformExpLitS32(o: Exp.LitS32): Option[Exp] = {
      return None()
    }

    def transformExpLitS64(o: Exp.LitS64): Option[Exp] = {
      return None()
    }

    def transformExpLitU8(o: Exp.LitU8): Option[Exp] = {
      return None()
    }

    def transformExpLitU16(o: Exp.LitU16): Option[Exp] = {
      return None()
    }

    def transformExpLitU32(o: Exp.LitU32): Option[Exp] = {
      return None()
    }

    def transformExpLitU64(o: Exp.LitU64): Option[Exp] = {
      return None()
    }

    def transformExpLitF32(o: Exp.LitF32): Option[Exp] = {
      return None()
    }

    def transformExpLitF64(o: Exp.LitF64): Option[Exp] = {
      return None()
    }

    def transformExpLitR(o: Exp.LitR): Option[Exp] = {
      return None()
    }

    def transformExpLitBv(o: Exp.LitBv): Option[Exp] = {
      return None()
    }

    def transformExpLitString(o: Exp.LitString): Option[Exp] = {
      return None()
    }

    def transformExpStringInterpolate(o: Exp.StringInterpolate): Option[Exp] = {
      return None()
    }

    def transformExpThis(o: Exp.This): Option[Exp] = {
      return None()
    }

    def transformExpUnary(o: Exp.Unary): Option[Exp] = {
      return None()
    }

    def transformExpBinary(o: Exp.Binary): Option[Exp] = {
      return None()
    }

    def transformExpIdent(o: Exp.Ident): Option[Exp] = {
      return None()
    }

    def transformExpEta(o: Exp.Eta): Option[Exp] = {
      return None()
    }

    def transformExpTuple(o: Exp.Tuple): Option[Exp] = {
      return None()
    }

    def transformExpSelect(o: Exp.Select): Option[Exp] = {
      return None()
    }

    def transformExpInvoke(o: Exp.Invoke): Option[Exp] = {
      return None()
    }

    def transformExpInvokeNamed(o: Exp.InvokeNamed): Option[Exp] = {
      return None()
    }

    def transformExpIf(o: Exp.If): Option[Exp] = {
      return None()
    }

    def transformExpQuant(o: Exp.Quant): Option[Exp] = {
      return None()
    }

    def transformNamedArg(o: NamedArg): Option[NamedArg] = {
      return None()
    }

    def transformVarFragment(o: VarFragment): Option[VarFragment] = {
      return None()
    }

    def transformDomain(o: Domain): Option[Domain] = {
      o match {
        case o: Domain.Type => return transformDomainType(o)
        case o: Domain.Range => return transformDomainRange(o)
      }
    }

    def transformDomainType(o: Domain.Type): Option[Domain] = {
      return None()
    }

    def transformDomainRange(o: Domain.Range): Option[Domain] = {
      return None()
    }

    def transformId(o: Id): Option[Id] = {
      return None()
    }

    def transformName(o: Name): Option[Name] = {
      return None()
    }

    def transformBody(o: Body): Option[Body] = {
      return None()
    }

    def transformAbstractDatatypeParam(o: AbstractDatatypeParam): Option[AbstractDatatypeParam] = {
      return None()
    }

    def transformMethodSig(o: MethodSig): Option[MethodSig] = {
      return None()
    }

    def transformParam(o: Param): Option[Param] = {
      return None()
    }

    def transformTypeParam(o: TypeParam): Option[TypeParam] = {
      return None()
    }

    def transformContract(o: Contract): Option[Contract] = {
      return None()
    }

    def transformSubContract(o: SubContract): Option[SubContract] = {
      return None()
    }

    def transformSubContractParam(o: SubContractParam): Option[SubContractParam] = {
      return None()
    }

    def transformWhereDef(o: WhereDef): Option[WhereDef] = {
      o match {
        case o: WhereDef.Val => return transformWhereDefVal(o)
        case o: WhereDef.Def => return transformWhereDefDef(o)
      }
    }

    def transformWhereDefVal(o: WhereDef.Val): Option[WhereDef] = {
      return None()
    }

    def transformWhereDefDef(o: WhereDef.Def): Option[WhereDef] = {
      return None()
    }

    def transformSpecDef(o: SpecDef): Option[SpecDef] = {
      return None()
    }

    def transformProofStep(o: ProofStep): Option[ProofStep] = {
      o match {
        case o: ProofStep.Basic => return transformProofStepBasic(o)
        case o: ProofStep.SubProof => return transformProofStepSubProof(o)
      }
    }

    def transformProofStepBasic(o: ProofStep.Basic): Option[ProofStep] = {
      return None()
    }

    def transformProofStepSubProof(o: ProofStep.SubProof): Option[ProofStep] = {
      return None()
    }

    def transformAssumeProofStep(o: AssumeProofStep): Option[AssumeProofStep] = {
      o match {
        case o: AssumeProofStep.Regular => return transformAssumeProofStepRegular(o)
        case o: AssumeProofStep.ForallIntroAps => return transformAssumeProofStepForallIntroAps(o)
        case o: AssumeProofStep.ExistsElimAps => return transformAssumeProofStepExistsElimAps(o)
      }
    }

    def transformAssumeProofStepRegular(o: AssumeProofStep.Regular): Option[AssumeProofStep] = {
      return None()
    }

    def transformAssumeProofStepForallIntroAps(o: AssumeProofStep.ForallIntroAps): Option[AssumeProofStep] = {
      return None()
    }

    def transformAssumeProofStepExistsElimAps(o: AssumeProofStep.ExistsElimAps): Option[AssumeProofStep] = {
      return None()
    }

    def transformJust(o: Just): Option[Just] = {
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

    def transformJustPremise(o: Just.Premise): Option[Just] = {
      return None()
    }

    def transformJustAndIntro(o: Just.AndIntro): Option[Just] = {
      return None()
    }

    def transformJustAndElim(o: Just.AndElim): Option[Just] = {
      return None()
    }

    def transformJustOrIntro(o: Just.OrIntro): Option[Just] = {
      return None()
    }

    def transformJustOrElim(o: Just.OrElim): Option[Just] = {
      return None()
    }

    def transformJustImplyIntro(o: Just.ImplyIntro): Option[Just] = {
      return None()
    }

    def transformJustImplyElim(o: Just.ImplyElim): Option[Just] = {
      return None()
    }

    def transformJustNegIntro(o: Just.NegIntro): Option[Just] = {
      return None()
    }

    def transformJustNegElim(o: Just.NegElim): Option[Just] = {
      return None()
    }

    def transformJustBottomElim(o: Just.BottomElim): Option[Just] = {
      return None()
    }

    def transformJustPbc(o: Just.Pbc): Option[Just] = {
      return None()
    }

    def transformJustForallIntro(o: Just.ForallIntro): Option[Just] = {
      return None()
    }

    def transformJustForallElim(o: Just.ForallElim): Option[Just] = {
      return None()
    }

    def transformJustExistsIntro(o: Just.ExistsIntro): Option[Just] = {
      return None()
    }

    def transformJustExistsElim(o: Just.ExistsElim): Option[Just] = {
      return None()
    }

    def transformJustFact(o: Just.Fact): Option[Just] = {
      return None()
    }

    def transformJustInvariant(o: Just.Invariant): Option[Just] = {
      return None()
    }

    def transformJustSubst(o: Just.Subst): Option[Just] = {
      return None()
    }

    def transformJustAuto(o: Just.Auto): Option[Just] = {
      return None()
    }

    def transformJustCoq(o: Just.Coq): Option[Just] = {
      return None()
    }

    def transformTruthTableRow(o: TruthTable.Row): Option[TruthTable.Row] = {
      return None()
    }

    def transformTruthTableConclusion(o: TruthTable.Conclusion): Option[TruthTable.Conclusion] = {
      o match {
        case o: TruthTable.Conclusion.Validity => return transformTruthTableConclusionValidity(o)
        case o: TruthTable.Conclusion.Tautology => return transformTruthTableConclusionTautology(o)
        case o: TruthTable.Conclusion.Contradictory => return transformTruthTableConclusionContradictory(o)
        case o: TruthTable.Conclusion.Contingent => return transformTruthTableConclusionContingent(o)
      }
    }

    def transformTruthTableConclusionValidity(o: TruthTable.Conclusion.Validity): Option[TruthTable.Conclusion] = {
      return None()
    }

    def transformTruthTableConclusionTautology(o: TruthTable.Conclusion.Tautology): Option[TruthTable.Conclusion] = {
      return None()
    }

    def transformTruthTableConclusionContradictory(o: TruthTable.Conclusion.Contradictory): Option[TruthTable.Conclusion] = {
      return None()
    }

    def transformTruthTableConclusionContingent(o: TruthTable.Conclusion.Contingent): Option[TruthTable.Conclusion] = {
      return None()
    }

    def transformAttr(o: Attr): Option[Attr] = {
      return None()
    }

    def transformTypedAttr(o: TypedAttr): Option[TypedAttr] = {
      return None()
    }

    def transformResolvedAttr(o: ResolvedAttr): Option[ResolvedAttr] = {
      return None()
    }

    def transformResolvedInfo(o: ResolvedInfo): Option[ResolvedInfo] = {
      return None()
    }

    def transformPosInfo(o: PosInfo): Option[PosInfo] = {
      return None()
    }

  }

  def transformISZ[T](s: IS[Z, T], f: T => Option[T]): Option[IS[Z, T]] = {
    val s2: MS[Z, T] = SI.toMS(s)
    var changed: B = F
    for (i <- s2.indices) {
      val e: T = s(i)
      val r: Option[T] = f(e)
      changed = changed | r.nonEmpty
      s2(i) = r.getOrElse(e)
    }
    if (changed) {
      return Some(SM.toIS(s2))
    } else {
      return None()
    }
  }

  def transformOption[T](option: Option[T], f: T => Option[T]): Option[Option[T]] = {
    option match {
      case Some(v) =>
        val r = f(v)
        r match {
          case Some(_) => return Some(r)
          case _ => return None()
        }
      case _ => return None()
    }
  }

}

import MTransformer._

@record class MTransformer(pre: Pre, post: Post) {

  def transformTopUnit(o: TopUnit): Option[TopUnit] = {
    val preR: PreResult[TopUnit] = pre.transformTopUnit(o)
    val r: Option[TopUnit] = if (preR.continue) {
      val o2: TopUnit = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Option[TopUnit] = o2 match {
        case o2: TopUnit.Program =>
          val r0: Option[Name] = transformName(o2.packageName)
          val r1: Option[Body] = transformBody(o2.body)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(packageName = r0.getOrElse(o2.packageName), body = r1.getOrElse(o2.body)))
          else
            None()
        case o2: TopUnit.SequentUnit =>
          val r0: Option[LClause.Sequent] = transformLClauseSequent(o2.sequent)
          if (hasChanged| r0.nonEmpty)
            Some(o2(sequent = r0.getOrElse(o2.sequent)))
          else
            None()
        case o2: TopUnit.TruthTableUnit =>
          val r0: Option[IS[Z, Id]] = transformISZ(o2.vars, transformId _)
          val r1: Option[LClause.Sequent] = transformLClauseSequent(o2.sequent)
          val r2: Option[IS[Z, TruthTable.Row]] = transformISZ(o2.rows, transformTruthTableRow _)
          val r3: Option[Option[TruthTable.Conclusion]] = transformOption(o2.conclusionOpt, transformTruthTableConclusion _)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
            Some(o2(vars = r0.getOrElse(o2.vars), sequent = r1.getOrElse(o2.sequent), rows = r2.getOrElse(o2.rows), conclusionOpt = r3.getOrElse(o2.conclusionOpt)))
          else
            None()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: TopUnit = r.getOrElse(o)
    val postR: Option[TopUnit] = post.transformTopUnit(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformLClauseSequent(o: LClause.Sequent): Option[LClause.Sequent] = {
    val preR: PreResult[LClause.Sequent] = pre.transformLClauseSequent(o) match {
      case PreResult(continue, Some(r: LClause.Sequent)) => PreResult(continue, Some[LClause.Sequent](r))
      case _ => assert(F); PreResult(F, None[LClause.Sequent]())
    }
    val r: Option[LClause.Sequent] = if (preR.continue) {
      val o2: LClause.Sequent = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[IS[Z, Exp]] = transformISZ(o2.premises, transformExp _)
      val r1: Option[IS[Z, Exp]] = transformISZ(o2.conclusions, transformExp _)
      val r2: Option[Option[LClause.Proof]] = transformOption(o2.proofOpt, transformLClauseProof _)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
        Some(o2(premises = r0.getOrElse(o2.premises), conclusions = r1.getOrElse(o2.conclusions), proofOpt = r2.getOrElse(o2.proofOpt)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: LClause.Sequent = r.getOrElse(o)
    val postR: Option[LClause.Sequent] = post.transformLClauseSequent(o2) match {
      case Some(result: LClause.Sequent) => Some[LClause.Sequent](result)
      case _ => assert(F); None[LClause.Sequent]()
    }
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformLClauseProof(o: LClause.Proof): Option[LClause.Proof] = {
    val preR: PreResult[LClause.Proof] = pre.transformLClauseProof(o) match {
      case PreResult(continue, Some(r: LClause.Proof)) => PreResult(continue, Some[LClause.Proof](r))
      case _ => assert(F); PreResult(F, None[LClause.Proof]())
    }
    val r: Option[LClause.Proof] = if (preR.continue) {
      val o2: LClause.Proof = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[IS[Z, ProofStep]] = transformISZ(o2.steps, transformProofStep _)
      if (hasChanged| r0.nonEmpty)
        Some(o2(steps = r0.getOrElse(o2.steps)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: LClause.Proof = r.getOrElse(o)
    val postR: Option[LClause.Proof] = post.transformLClauseProof(o2) match {
      case Some(result: LClause.Proof) => Some[LClause.Proof](result)
      case _ => assert(F); None[LClause.Proof]()
    }
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformStmt(o: Stmt): Option[Stmt] = {
    val preR: PreResult[Stmt] = pre.transformStmt(o)
    val r: Option[Stmt] = if (preR.continue) {
      val o2: Stmt = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Option[Stmt] = o2 match {
        case o2: Stmt.Import =>
          val r0: Option[IS[Z, Stmt.Import.Importer]] = transformISZ(o2.importers, transformStmtImportImporter _)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(importers = r0.getOrElse(o2.importers), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.Var =>
          val r0: Option[Id] = transformId(o2.id)
          val r1: Option[Option[Type]] = transformOption(o2.tipeOpt, transformType _)
          val r2: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(id = r0.getOrElse(o2.id), tipeOpt = r1.getOrElse(o2.tipeOpt), attr = r2.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.VarPattern =>
          val r0: Option[Pattern] = transformPattern(o2.pattern)
          val r1: Option[Option[Type]] = transformOption(o2.tipeOpt, transformType _)
          val r2: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(pattern = r0.getOrElse(o2.pattern), tipeOpt = r1.getOrElse(o2.tipeOpt), attr = r2.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.SpecVar =>
          val r0: Option[Id] = transformId(o2.id)
          val r1: Option[Type] = transformType(o2.tipe)
          val r2: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(id = r0.getOrElse(o2.id), tipe = r1.getOrElse(o2.tipe), attr = r2.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.Method =>
          val r0: Option[MethodSig] = transformMethodSig(o2.sig)
          val r1: Option[Contract] = transformContract(o2.contract)
          val r2: Option[Option[Body]] = transformOption(o2.bodyOpt, transformBody _)
          val r3: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
            Some(o2(sig = r0.getOrElse(o2.sig), contract = r1.getOrElse(o2.contract), bodyOpt = r2.getOrElse(o2.bodyOpt), attr = r3.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.ExtMethod =>
          val r0: Option[MethodSig] = transformMethodSig(o2.sig)
          val r1: Option[Contract] = transformContract(o2.contract)
          val r2: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(sig = r0.getOrElse(o2.sig), contract = r1.getOrElse(o2.contract), attr = r2.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.SpecMethod =>
          val r0: Option[MethodSig] = transformMethodSig(o2.sig)
          val r1: Option[IS[Z, SpecDef]] = transformISZ(o2.defs, transformSpecDef _)
          val r2: Option[IS[Z, WhereDef]] = transformISZ(o2.where, transformWhereDef _)
          val r3: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
            Some(o2(sig = r0.getOrElse(o2.sig), defs = r1.getOrElse(o2.defs), where = r2.getOrElse(o2.where), attr = r3.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.Enum =>
          val r0: Option[Id] = transformId(o2.id)
          val r1: Option[IS[Z, Id]] = transformISZ(o2.elements, transformId _)
          val r2: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(id = r0.getOrElse(o2.id), elements = r1.getOrElse(o2.elements), attr = r2.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.Object =>
          val r0: Option[Id] = transformId(o2.id)
          val r1: Option[IS[Z, Type]] = transformISZ(o2.parents, transformType _)
          val r2: Option[IS[Z, Stmt]] = transformISZ(o2.stmts, transformStmt _)
          val r3: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
            Some(o2(id = r0.getOrElse(o2.id), parents = r1.getOrElse(o2.parents), stmts = r2.getOrElse(o2.stmts), attr = r3.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.Sig =>
          val r0: Option[Id] = transformId(o2.id)
          val r1: Option[IS[Z, TypeParam]] = transformISZ(o2.typeParams, transformTypeParam _)
          val r2: Option[IS[Z, Type.Named]] = transformISZ(o2.parents, transformTypeNamed _)
          val r3: Option[Option[Type]] = transformOption(o2.selfTypeOpt, transformType _)
          val r4: Option[IS[Z, Stmt]] = transformISZ(o2.stmts, transformStmt _)
          val r5: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty| r4.nonEmpty| r5.nonEmpty)
            Some(o2(id = r0.getOrElse(o2.id), typeParams = r1.getOrElse(o2.typeParams), parents = r2.getOrElse(o2.parents), selfTypeOpt = r3.getOrElse(o2.selfTypeOpt), stmts = r4.getOrElse(o2.stmts), attr = r5.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.AbstractDatatype =>
          val r0: Option[Id] = transformId(o2.id)
          val r1: Option[IS[Z, TypeParam]] = transformISZ(o2.typeParams, transformTypeParam _)
          val r2: Option[IS[Z, AbstractDatatypeParam]] = transformISZ(o2.params, transformAbstractDatatypeParam _)
          val r3: Option[IS[Z, Type.Named]] = transformISZ(o2.parents, transformTypeNamed _)
          val r4: Option[IS[Z, Stmt]] = transformISZ(o2.stmts, transformStmt _)
          val r5: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty| r4.nonEmpty| r5.nonEmpty)
            Some(o2(id = r0.getOrElse(o2.id), typeParams = r1.getOrElse(o2.typeParams), params = r2.getOrElse(o2.params), parents = r3.getOrElse(o2.parents), stmts = r4.getOrElse(o2.stmts), attr = r5.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.Rich =>
          val r0: Option[Id] = transformId(o2.id)
          val r1: Option[IS[Z, TypeParam]] = transformISZ(o2.typeParams, transformTypeParam _)
          val r2: Option[IS[Z, Param]] = transformISZ(o2.params, transformParam _)
          val r3: Option[IS[Z, Type.Named]] = transformISZ(o2.parents, transformTypeNamed _)
          val r4: Option[IS[Z, Stmt]] = transformISZ(o2.stmts, transformStmt _)
          val r5: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty| r4.nonEmpty| r5.nonEmpty)
            Some(o2(id = r0.getOrElse(o2.id), typeParams = r1.getOrElse(o2.typeParams), params = r2.getOrElse(o2.params), parents = r3.getOrElse(o2.parents), stmts = r4.getOrElse(o2.stmts), attr = r5.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.TypeAlias =>
          val r0: Option[Id] = transformId(o2.id)
          val r1: Option[IS[Z, TypeParam]] = transformISZ(o2.typeParams, transformTypeParam _)
          val r2: Option[Type] = transformType(o2.tipe)
          val r3: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
            Some(o2(id = r0.getOrElse(o2.id), typeParams = r1.getOrElse(o2.typeParams), tipe = r2.getOrElse(o2.tipe), attr = r3.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.Assign =>
          val r0: Option[Exp] = transformExp(o2.lhs)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(lhs = r0.getOrElse(o2.lhs), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.AssignUp =>
          val r0: Option[Exp] = transformExp(o2.lhs)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(lhs = r0.getOrElse(o2.lhs), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.AssignPattern =>
          val r0: Option[Pattern] = transformPattern(o2.lhs)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(lhs = r0.getOrElse(o2.lhs), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.Block =>
          val r0: Option[Body] = transformBody(o2.body)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(body = r0.getOrElse(o2.body), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.If =>
          val r0: Option[Exp] = transformExp(o2.cond)
          val r1: Option[Body] = transformBody(o2.thenbody)
          val r2: Option[Body] = transformBody(o2.elsebody)
          val r3: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
            Some(o2(cond = r0.getOrElse(o2.cond), thenbody = r1.getOrElse(o2.thenbody), elsebody = r2.getOrElse(o2.elsebody), attr = r3.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.Match =>
          val r0: Option[Exp] = transformExp(o2.cond)
          val r1: Option[IS[Z, Case]] = transformISZ(o2.cases, transformCase _)
          val r2: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(cond = r0.getOrElse(o2.cond), cases = r1.getOrElse(o2.cases), attr = r2.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.While =>
          val r0: Option[Exp] = transformExp(o2.cond)
          val r1: Option[IS[Z, ContractExp]] = transformISZ(o2.invariants, transformContractExp _)
          val r2: Option[IS[Z, Exp]] = transformISZ(o2.modifies, transformExp _)
          val r3: Option[Body] = transformBody(o2.body)
          val r4: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty| r4.nonEmpty)
            Some(o2(cond = r0.getOrElse(o2.cond), invariants = r1.getOrElse(o2.invariants), modifies = r2.getOrElse(o2.modifies), body = r3.getOrElse(o2.body), attr = r4.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.DoWhile =>
          val r0: Option[Exp] = transformExp(o2.cond)
          val r1: Option[IS[Z, ContractExp]] = transformISZ(o2.invariants, transformContractExp _)
          val r2: Option[IS[Z, Exp]] = transformISZ(o2.modifies, transformExp _)
          val r3: Option[Body] = transformBody(o2.body)
          val r4: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty| r4.nonEmpty)
            Some(o2(cond = r0.getOrElse(o2.cond), invariants = r1.getOrElse(o2.invariants), modifies = r2.getOrElse(o2.modifies), body = r3.getOrElse(o2.body), attr = r4.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.For =>
          val r0: Option[Id] = transformId(o2.id)
          val r1: Option[Range] = transformRange(o2.range)
          val r2: Option[Option[Exp]] = transformOption(o2.condOpt, transformExp _)
          val r3: Option[IS[Z, ContractExp]] = transformISZ(o2.invariants, transformContractExp _)
          val r4: Option[IS[Z, Exp]] = transformISZ(o2.modifies, transformExp _)
          val r5: Option[Body] = transformBody(o2.body)
          val r6: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty| r4.nonEmpty| r5.nonEmpty| r6.nonEmpty)
            Some(o2(id = r0.getOrElse(o2.id), range = r1.getOrElse(o2.range), condOpt = r2.getOrElse(o2.condOpt), invariants = r3.getOrElse(o2.invariants), modifies = r4.getOrElse(o2.modifies), body = r5.getOrElse(o2.body), attr = r6.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.Return =>
          val r0: Option[Option[Exp]] = transformOption(o2.expOpt, transformExp _)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(expOpt = r0.getOrElse(o2.expOpt), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.LStmt =>
          val r0: Option[LClause] = transformLClause(o2.clause)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(clause = r0.getOrElse(o2.clause), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Stmt.Expr =>
          val r0: Option[Exp] = transformExp(o2.exp)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(exp = r0.getOrElse(o2.exp), attr = r1.getOrElse(o2.attr)))
          else
            None()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Stmt = r.getOrElse(o)
    val postR: Option[Stmt] = post.transformStmt(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformTypeNamed(o: Type.Named): Option[Type.Named] = {
    val preR: PreResult[Type.Named] = pre.transformTypeNamed(o) match {
      case PreResult(continue, Some(r: Type.Named)) => PreResult(continue, Some[Type.Named](r))
      case _ => assert(F); PreResult(F, None[Type.Named]())
    }
    val r: Option[Type.Named] = if (preR.continue) {
      val o2: Type.Named = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Name] = transformName(o2.name)
      val r1: Option[IS[Z, Type]] = transformISZ(o2.typeArgs, transformType _)
      val r2: Option[TypedAttr] = transformTypedAttr(o2.attr)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
        Some(o2(name = r0.getOrElse(o2.name), typeArgs = r1.getOrElse(o2.typeArgs), attr = r2.getOrElse(o2.attr)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Type.Named = r.getOrElse(o)
    val postR: Option[Type.Named] = post.transformTypeNamed(o2) match {
      case Some(result: Type.Named) => Some[Type.Named](result)
      case _ => assert(F); None[Type.Named]()
    }
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformStmtImportImporter(o: Stmt.Import.Importer): Option[Stmt.Import.Importer] = {
    val preR: PreResult[Stmt.Import.Importer] = pre.transformStmtImportImporter(o)
    val r: Option[Stmt.Import.Importer] = if (preR.continue) {
      val o2: Stmt.Import.Importer = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Name] = transformName(o2.name)
      val r1: Option[Option[Stmt.Import.Selector]] = transformOption(o2.selector, transformStmtImportSelector _)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty)
        Some(o2(name = r0.getOrElse(o2.name), selector = r1.getOrElse(o2.selector)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Stmt.Import.Importer = r.getOrElse(o)
    val postR: Option[Stmt.Import.Importer] = post.transformStmtImportImporter(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformStmtImportSelector(o: Stmt.Import.Selector): Option[Stmt.Import.Selector] = {
    val preR: PreResult[Stmt.Import.Selector] = pre.transformStmtImportSelector(o)
    val r: Option[Stmt.Import.Selector] = if (preR.continue) {
      val o2: Stmt.Import.Selector = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Option[Stmt.Import.Selector] = o2 match {
        case o2: Stmt.Import.MultiSelector =>
          val r0: Option[IS[Z, Stmt.Import.NamedSelector]] = transformISZ(o2.selectors, transformStmtImportNamedSelector _)
          if (hasChanged| r0.nonEmpty)
            Some(o2(selectors = r0.getOrElse(o2.selectors)))
          else
            None()
        case o2: Stmt.Import.WildcardSelector =>
          if (hasChanged)
            Some(o2)
          else
            None()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Stmt.Import.Selector = r.getOrElse(o)
    val postR: Option[Stmt.Import.Selector] = post.transformStmtImportSelector(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformStmtImportNamedSelector(o: Stmt.Import.NamedSelector): Option[Stmt.Import.NamedSelector] = {
    val preR: PreResult[Stmt.Import.NamedSelector] = pre.transformStmtImportNamedSelector(o)
    val r: Option[Stmt.Import.NamedSelector] = if (preR.continue) {
      val o2: Stmt.Import.NamedSelector = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Id] = transformId(o2.from)
      val r1: Option[Id] = transformId(o2.to)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty)
        Some(o2(from = r0.getOrElse(o2.from), to = r1.getOrElse(o2.to)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Stmt.Import.NamedSelector = r.getOrElse(o)
    val postR: Option[Stmt.Import.NamedSelector] = post.transformStmtImportNamedSelector(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformLClause(o: LClause): Option[LClause] = {
    val preR: PreResult[LClause] = pre.transformLClause(o)
    val r: Option[LClause] = if (preR.continue) {
      val o2: LClause = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Option[LClause] = o2 match {
        case o2: LClause.Invariants =>
          val r0: Option[IS[Z, ContractExp]] = transformISZ(o2.value, transformContractExp _)
          if (hasChanged| r0.nonEmpty)
            Some(o2(value = r0.getOrElse(o2.value)))
          else
            None()
        case o2: LClause.Facts =>
          val r0: Option[IS[Z, LClause.Fact]] = transformISZ(o2.value, transformLClauseFact _)
          if (hasChanged| r0.nonEmpty)
            Some(o2(value = r0.getOrElse(o2.value)))
          else
            None()
        case o2: LClause.Theorems =>
          val r0: Option[IS[Z, LClause.Theorem]] = transformISZ(o2.value, transformLClauseTheorem _)
          if (hasChanged| r0.nonEmpty)
            Some(o2(value = r0.getOrElse(o2.value)))
          else
            None()
        case o2: LClause.Sequent =>
          val r0: Option[IS[Z, Exp]] = transformISZ(o2.premises, transformExp _)
          val r1: Option[IS[Z, Exp]] = transformISZ(o2.conclusions, transformExp _)
          val r2: Option[Option[LClause.Proof]] = transformOption(o2.proofOpt, transformLClauseProof _)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(premises = r0.getOrElse(o2.premises), conclusions = r1.getOrElse(o2.conclusions), proofOpt = r2.getOrElse(o2.proofOpt)))
          else
            None()
        case o2: LClause.Proof =>
          val r0: Option[IS[Z, ProofStep]] = transformISZ(o2.steps, transformProofStep _)
          if (hasChanged| r0.nonEmpty)
            Some(o2(steps = r0.getOrElse(o2.steps)))
          else
            None()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: LClause = r.getOrElse(o)
    val postR: Option[LClause] = post.transformLClause(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformLClauseFact(o: LClause.Fact): Option[LClause.Fact] = {
    val preR: PreResult[LClause.Fact] = pre.transformLClauseFact(o)
    val r: Option[LClause.Fact] = if (preR.continue) {
      val o2: LClause.Fact = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Id] = transformId(o2.id)
      val r1: Option[Exp] = transformExp(o2.exp)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty)
        Some(o2(id = r0.getOrElse(o2.id), exp = r1.getOrElse(o2.exp)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: LClause.Fact = r.getOrElse(o)
    val postR: Option[LClause.Fact] = post.transformLClauseFact(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformLClauseTheorem(o: LClause.Theorem): Option[LClause.Theorem] = {
    val preR: PreResult[LClause.Theorem] = pre.transformLClauseTheorem(o)
    val r: Option[LClause.Theorem] = if (preR.continue) {
      val o2: LClause.Theorem = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Id] = transformId(o2.id)
      val r1: Option[LClause.Sequent] = transformLClauseSequent(o2.sequent)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty)
        Some(o2(id = r0.getOrElse(o2.id), sequent = r1.getOrElse(o2.sequent)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: LClause.Theorem = r.getOrElse(o)
    val postR: Option[LClause.Theorem] = post.transformLClauseTheorem(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformContractExp(o: ContractExp): Option[ContractExp] = {
    val preR: PreResult[ContractExp] = pre.transformContractExp(o)
    val r: Option[ContractExp] = if (preR.continue) {
      val o2: ContractExp = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Option[Id]] = transformOption(o2.idOpt, transformId _)
      val r1: Option[Exp] = transformExp(o2.exp)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty)
        Some(o2(idOpt = r0.getOrElse(o2.idOpt), exp = r1.getOrElse(o2.exp)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: ContractExp = r.getOrElse(o)
    val postR: Option[ContractExp] = post.transformContractExp(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformCase(o: Case): Option[Case] = {
    val preR: PreResult[Case] = pre.transformCase(o)
    val r: Option[Case] = if (preR.continue) {
      val o2: Case = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Pattern] = transformPattern(o2.pattern)
      val r1: Option[Option[Exp]] = transformOption(o2.condOpt, transformExp _)
      val r2: Option[Body] = transformBody(o2.body)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
        Some(o2(pattern = r0.getOrElse(o2.pattern), condOpt = r1.getOrElse(o2.condOpt), body = r2.getOrElse(o2.body)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Case = r.getOrElse(o)
    val postR: Option[Case] = post.transformCase(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformRange(o: Range): Option[Range] = {
    val preR: PreResult[Range] = pre.transformRange(o)
    val r: Option[Range] = if (preR.continue) {
      val o2: Range = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Option[Range] = o2 match {
        case o2: Range.Expr =>
          val r0: Option[Exp] = transformExp(o2.exp)
          if (hasChanged| r0.nonEmpty)
            Some(o2(exp = r0.getOrElse(o2.exp)))
          else
            None()
        case o2: Range.Indices =>
          val r0: Option[Exp] = transformExp(o2.exp)
          if (hasChanged| r0.nonEmpty)
            Some(o2(exp = r0.getOrElse(o2.exp)))
          else
            None()
        case o2: Range.Step =>
          val r0: Option[Exp] = transformExp(o2.start)
          val r1: Option[Exp] = transformExp(o2.end)
          val r2: Option[Option[Exp]] = transformOption(o2.byOpt, transformExp _)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(start = r0.getOrElse(o2.start), end = r1.getOrElse(o2.end), byOpt = r2.getOrElse(o2.byOpt)))
          else
            None()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Range = r.getOrElse(o)
    val postR: Option[Range] = post.transformRange(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformType(o: Type): Option[Type] = {
    val preR: PreResult[Type] = pre.transformType(o)
    val r: Option[Type] = if (preR.continue) {
      val o2: Type = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Option[Type] = o2 match {
        case o2: Type.Named =>
          val r0: Option[Name] = transformName(o2.name)
          val r1: Option[IS[Z, Type]] = transformISZ(o2.typeArgs, transformType _)
          val r2: Option[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(name = r0.getOrElse(o2.name), typeArgs = r1.getOrElse(o2.typeArgs), attr = r2.getOrElse(o2.attr)))
          else
            None()
        case o2: Type.Fun =>
          val r0: Option[IS[Z, Type]] = transformISZ(o2.args, transformType _)
          val r1: Option[Type] = transformType(o2.ret)
          val r2: Option[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(args = r0.getOrElse(o2.args), ret = r1.getOrElse(o2.ret), attr = r2.getOrElse(o2.attr)))
          else
            None()
        case o2: Type.Tuple =>
          val r0: Option[IS[Z, Type]] = transformISZ(o2.args, transformType _)
          val r1: Option[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(args = r0.getOrElse(o2.args), attr = r1.getOrElse(o2.attr)))
          else
            None()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Type = r.getOrElse(o)
    val postR: Option[Type] = post.transformType(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformPattern(o: Pattern): Option[Pattern] = {
    val preR: PreResult[Pattern] = pre.transformPattern(o)
    val r: Option[Pattern] = if (preR.continue) {
      val o2: Pattern = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Option[Pattern] = o2 match {
        case o2: Pattern.Literal =>
          if (hasChanged)
            Some(o2)
          else
            None()
        case o2: Pattern.Ref =>
          val r0: Option[Name] = transformName(o2.name)
          if (hasChanged| r0.nonEmpty)
            Some(o2(name = r0.getOrElse(o2.name)))
          else
            None()
        case o2: Pattern.Variable =>
          val r0: Option[Id] = transformId(o2.id)
          val r1: Option[Option[Type]] = transformOption(o2.typeOpt, transformType _)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(id = r0.getOrElse(o2.id), typeOpt = r1.getOrElse(o2.typeOpt)))
          else
            None()
        case o2: Pattern.Wildcard =>
          val r0: Option[Option[Type]] = transformOption(o2.typeOpt, transformType _)
          if (hasChanged| r0.nonEmpty)
            Some(o2(typeOpt = r0.getOrElse(o2.typeOpt)))
          else
            None()
        case o2: Pattern.SeqWildcard =>
          if (hasChanged)
            Some(o2)
          else
            None()
        case o2: Pattern.Structure =>
          val r0: Option[Option[Id]] = transformOption(o2.idOpt, transformId _)
          val r1: Option[Option[Name]] = transformOption(o2.nameOpt, transformName _)
          val r2: Option[IS[Z, Pattern]] = transformISZ(o2.patterns, transformPattern _)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(idOpt = r0.getOrElse(o2.idOpt), nameOpt = r1.getOrElse(o2.nameOpt), patterns = r2.getOrElse(o2.patterns)))
          else
            None()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Pattern = r.getOrElse(o)
    val postR: Option[Pattern] = post.transformPattern(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformExp(o: Exp): Option[Exp] = {
    val preR: PreResult[Exp] = pre.transformExp(o)
    val r: Option[Exp] = if (preR.continue) {
      val o2: Exp = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Option[Exp] = o2 match {
        case o2: Exp.LitB =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitC =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitZ =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitZ8 =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitZ16 =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitZ32 =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitZ64 =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitN =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitN8 =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitN16 =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitN32 =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitN64 =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitS8 =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitS16 =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitS32 =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitS64 =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitU8 =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitU16 =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitU32 =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitU64 =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitF32 =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitF64 =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitR =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitBv =>
          val r0: Option[Type] = transformType(o2.tipe)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(tipe = r0.getOrElse(o2.tipe), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.LitString =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.StringInterpolate =>
          val r0: Option[IS[Z, Exp.LitString]] = transformISZ(o2.lits, transformExpLitString _)
          val r1: Option[IS[Z, Exp]] = transformISZ(o2.args, transformExp _)
          val r2: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(lits = r0.getOrElse(o2.lits), args = r1.getOrElse(o2.args), attr = r2.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.This =>
          val r0: Option[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.Unary =>
          val r0: Option[Exp] = transformExp(o2.exp)
          val r1: Option[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(exp = r0.getOrElse(o2.exp), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.Binary =>
          val r0: Option[Exp] = transformExp(o2.left)
          val r1: Option[Exp] = transformExp(o2.right)
          val r2: Option[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(left = r0.getOrElse(o2.left), right = r1.getOrElse(o2.right), attr = r2.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.Ident =>
          val r0: Option[Id] = transformId(o2.id)
          val r1: Option[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(id = r0.getOrElse(o2.id), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.Eta =>
          val r0: Option[Exp] = transformExp(o2.exp)
          val r1: Option[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(exp = r0.getOrElse(o2.exp), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.Tuple =>
          val r0: Option[IS[Z, Exp]] = transformISZ(o2.args, transformExp _)
          val r1: Option[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(args = r0.getOrElse(o2.args), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.Select =>
          val r0: Option[Option[Exp]] = transformOption(o2.receiverOpt, transformExp _)
          val r1: Option[Id] = transformId(o2.id)
          val r2: Option[IS[Z, Type]] = transformISZ(o2.targs, transformType _)
          val r3: Option[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
            Some(o2(receiverOpt = r0.getOrElse(o2.receiverOpt), id = r1.getOrElse(o2.id), targs = r2.getOrElse(o2.targs), attr = r3.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.Invoke =>
          val r0: Option[Option[Exp]] = transformOption(o2.receiverOpt, transformExp _)
          val r1: Option[Id] = transformId(o2.id)
          val r2: Option[IS[Z, Type]] = transformISZ(o2.targs, transformType _)
          val r3: Option[IS[Z, Exp]] = transformISZ(o2.args, transformExp _)
          val r4: Option[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty| r4.nonEmpty)
            Some(o2(receiverOpt = r0.getOrElse(o2.receiverOpt), id = r1.getOrElse(o2.id), targs = r2.getOrElse(o2.targs), args = r3.getOrElse(o2.args), attr = r4.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.InvokeNamed =>
          val r0: Option[Option[Exp]] = transformOption(o2.receiverOpt, transformExp _)
          val r1: Option[Id] = transformId(o2.id)
          val r2: Option[IS[Z, Type]] = transformISZ(o2.targs, transformType _)
          val r3: Option[IS[Z, NamedArg]] = transformISZ(o2.args, transformNamedArg _)
          val r4: Option[ResolvedAttr] = transformResolvedAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty| r4.nonEmpty)
            Some(o2(receiverOpt = r0.getOrElse(o2.receiverOpt), id = r1.getOrElse(o2.id), targs = r2.getOrElse(o2.targs), args = r3.getOrElse(o2.args), attr = r4.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.If =>
          val r0: Option[Exp] = transformExp(o2.cond)
          val r1: Option[Exp] = transformExp(o2.thenExp)
          val r2: Option[Exp] = transformExp(o2.elseExp)
          val r3: Option[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
            Some(o2(cond = r0.getOrElse(o2.cond), thenExp = r1.getOrElse(o2.thenExp), elseExp = r2.getOrElse(o2.elseExp), attr = r3.getOrElse(o2.attr)))
          else
            None()
        case o2: Exp.Quant =>
          val r0: Option[IS[Z, VarFragment]] = transformISZ(o2.varFragments, transformVarFragment _)
          val r1: Option[Exp] = transformExp(o2.exp)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(varFragments = r0.getOrElse(o2.varFragments), exp = r1.getOrElse(o2.exp)))
          else
            None()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Exp = r.getOrElse(o)
    val postR: Option[Exp] = post.transformExp(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformExpLitString(o: Exp.LitString): Option[Exp.LitString] = {
    val preR: PreResult[Exp.LitString] = pre.transformExpLitString(o) match {
      case PreResult(continue, Some(r: Exp.LitString)) => PreResult(continue, Some[Exp.LitString](r))
      case _ => assert(F); PreResult(F, None[Exp.LitString]())
    }
    val r: Option[Exp.LitString] = if (preR.continue) {
      val o2: Exp.LitString = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Attr] = transformAttr(o2.attr)
      if (hasChanged| r0.nonEmpty)
        Some(o2(attr = r0.getOrElse(o2.attr)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Exp.LitString = r.getOrElse(o)
    val postR: Option[Exp.LitString] = post.transformExpLitString(o2) match {
      case Some(result: Exp.LitString) => Some[Exp.LitString](result)
      case _ => assert(F); None[Exp.LitString]()
    }
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformNamedArg(o: NamedArg): Option[NamedArg] = {
    val preR: PreResult[NamedArg] = pre.transformNamedArg(o)
    val r: Option[NamedArg] = if (preR.continue) {
      val o2: NamedArg = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Id] = transformId(o2.id)
      val r1: Option[Exp] = transformExp(o2.arg)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty)
        Some(o2(id = r0.getOrElse(o2.id), arg = r1.getOrElse(o2.arg)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: NamedArg = r.getOrElse(o)
    val postR: Option[NamedArg] = post.transformNamedArg(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformVarFragment(o: VarFragment): Option[VarFragment] = {
    val preR: PreResult[VarFragment] = pre.transformVarFragment(o)
    val r: Option[VarFragment] = if (preR.continue) {
      val o2: VarFragment = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[IS[Z, Id]] = transformISZ(o2.ids, transformId _)
      val r1: Option[Option[Domain]] = transformOption(o2.domainOpt, transformDomain _)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty)
        Some(o2(ids = r0.getOrElse(o2.ids), domainOpt = r1.getOrElse(o2.domainOpt)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: VarFragment = r.getOrElse(o)
    val postR: Option[VarFragment] = post.transformVarFragment(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformDomain(o: Domain): Option[Domain] = {
    val preR: PreResult[Domain] = pre.transformDomain(o)
    val r: Option[Domain] = if (preR.continue) {
      val o2: Domain = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Option[Domain] = o2 match {
        case o2: Domain.Type =>
          val r0: Option[Type] = transformType(o2.tipe)
          val r1: Option[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(tipe = r0.getOrElse(o2.tipe), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Domain.Range =>
          val r0: Option[Exp] = transformExp(o2.lo)
          val r1: Option[Exp] = transformExp(o2.hi)
          val r2: Option[TypedAttr] = transformTypedAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(lo = r0.getOrElse(o2.lo), hi = r1.getOrElse(o2.hi), attr = r2.getOrElse(o2.attr)))
          else
            None()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Domain = r.getOrElse(o)
    val postR: Option[Domain] = post.transformDomain(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformId(o: Id): Option[Id] = {
    val preR: PreResult[Id] = pre.transformId(o)
    val r: Option[Id] = if (preR.continue) {
      val o2: Id = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Attr] = transformAttr(o2.attr)
      if (hasChanged| r0.nonEmpty)
        Some(o2(attr = r0.getOrElse(o2.attr)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Id = r.getOrElse(o)
    val postR: Option[Id] = post.transformId(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformName(o: Name): Option[Name] = {
    val preR: PreResult[Name] = pre.transformName(o)
    val r: Option[Name] = if (preR.continue) {
      val o2: Name = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[IS[Z, Id]] = transformISZ(o2.ids, transformId _)
      val r1: Option[Attr] = transformAttr(o2.attr)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty)
        Some(o2(ids = r0.getOrElse(o2.ids), attr = r1.getOrElse(o2.attr)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Name = r.getOrElse(o)
    val postR: Option[Name] = post.transformName(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformBody(o: Body): Option[Body] = {
    val preR: PreResult[Body] = pre.transformBody(o)
    val r: Option[Body] = if (preR.continue) {
      val o2: Body = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[IS[Z, Stmt]] = transformISZ(o2.stmts, transformStmt _)
      if (hasChanged| r0.nonEmpty)
        Some(o2(stmts = r0.getOrElse(o2.stmts)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Body = r.getOrElse(o)
    val postR: Option[Body] = post.transformBody(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformAbstractDatatypeParam(o: AbstractDatatypeParam): Option[AbstractDatatypeParam] = {
    val preR: PreResult[AbstractDatatypeParam] = pre.transformAbstractDatatypeParam(o)
    val r: Option[AbstractDatatypeParam] = if (preR.continue) {
      val o2: AbstractDatatypeParam = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Id] = transformId(o2.id)
      val r1: Option[Type] = transformType(o2.tipe)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty)
        Some(o2(id = r0.getOrElse(o2.id), tipe = r1.getOrElse(o2.tipe)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: AbstractDatatypeParam = r.getOrElse(o)
    val postR: Option[AbstractDatatypeParam] = post.transformAbstractDatatypeParam(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformMethodSig(o: MethodSig): Option[MethodSig] = {
    val preR: PreResult[MethodSig] = pre.transformMethodSig(o)
    val r: Option[MethodSig] = if (preR.continue) {
      val o2: MethodSig = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Id] = transformId(o2.id)
      val r1: Option[IS[Z, TypeParam]] = transformISZ(o2.typeParams, transformTypeParam _)
      val r2: Option[Type] = transformType(o2.returnType)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
        Some(o2(id = r0.getOrElse(o2.id), typeParams = r1.getOrElse(o2.typeParams), returnType = r2.getOrElse(o2.returnType)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: MethodSig = r.getOrElse(o)
    val postR: Option[MethodSig] = post.transformMethodSig(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformParam(o: Param): Option[Param] = {
    val preR: PreResult[Param] = pre.transformParam(o)
    val r: Option[Param] = if (preR.continue) {
      val o2: Param = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Id] = transformId(o2.id)
      val r1: Option[Type] = transformType(o2.tipe)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty)
        Some(o2(id = r0.getOrElse(o2.id), tipe = r1.getOrElse(o2.tipe)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Param = r.getOrElse(o)
    val postR: Option[Param] = post.transformParam(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformTypeParam(o: TypeParam): Option[TypeParam] = {
    val preR: PreResult[TypeParam] = pre.transformTypeParam(o)
    val r: Option[TypeParam] = if (preR.continue) {
      val o2: TypeParam = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Id] = transformId(o2.id)
      val r1: Option[Option[Type]] = transformOption(o2.superTypeOpt, transformType _)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty)
        Some(o2(id = r0.getOrElse(o2.id), superTypeOpt = r1.getOrElse(o2.superTypeOpt)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: TypeParam = r.getOrElse(o)
    val postR: Option[TypeParam] = post.transformTypeParam(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformContract(o: Contract): Option[Contract] = {
    val preR: PreResult[Contract] = pre.transformContract(o)
    val r: Option[Contract] = if (preR.continue) {
      val o2: Contract = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[IS[Z, Exp]] = transformISZ(o2.reads, transformExp _)
      val r1: Option[IS[Z, ContractExp]] = transformISZ(o2.requires, transformContractExp _)
      val r2: Option[IS[Z, Exp]] = transformISZ(o2.modifies, transformExp _)
      val r3: Option[IS[Z, ContractExp]] = transformISZ(o2.ensures, transformContractExp _)
      val r4: Option[IS[Z, SubContract]] = transformISZ(o2.subs, transformSubContract _)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty| r4.nonEmpty)
        Some(o2(reads = r0.getOrElse(o2.reads), requires = r1.getOrElse(o2.requires), modifies = r2.getOrElse(o2.modifies), ensures = r3.getOrElse(o2.ensures), subs = r4.getOrElse(o2.subs)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Contract = r.getOrElse(o)
    val postR: Option[Contract] = post.transformContract(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformSubContract(o: SubContract): Option[SubContract] = {
    val preR: PreResult[SubContract] = pre.transformSubContract(o)
    val r: Option[SubContract] = if (preR.continue) {
      val o2: SubContract = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Id] = transformId(o2.id)
      val r1: Option[IS[Z, SubContractParam]] = transformISZ(o2.params, transformSubContractParam _)
      val r2: Option[Contract] = transformContract(o2.contract)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
        Some(o2(id = r0.getOrElse(o2.id), params = r1.getOrElse(o2.params), contract = r2.getOrElse(o2.contract)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: SubContract = r.getOrElse(o)
    val postR: Option[SubContract] = post.transformSubContract(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformSubContractParam(o: SubContractParam): Option[SubContractParam] = {
    val preR: PreResult[SubContractParam] = pre.transformSubContractParam(o)
    val r: Option[SubContractParam] = if (preR.continue) {
      val o2: SubContractParam = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Id] = transformId(o2.id)
      if (hasChanged| r0.nonEmpty)
        Some(o2(id = r0.getOrElse(o2.id)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: SubContractParam = r.getOrElse(o)
    val postR: Option[SubContractParam] = post.transformSubContractParam(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformWhereDef(o: WhereDef): Option[WhereDef] = {
    val preR: PreResult[WhereDef] = pre.transformWhereDef(o)
    val r: Option[WhereDef] = if (preR.continue) {
      val o2: WhereDef = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Option[WhereDef] = o2 match {
        case o2: WhereDef.Val =>
          val r0: Option[Id] = transformId(o2.id)
          val r1: Option[Type] = transformType(o2.tipe)
          val r2: Option[Exp] = transformExp(o2.exp)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(id = r0.getOrElse(o2.id), tipe = r1.getOrElse(o2.tipe), exp = r2.getOrElse(o2.exp)))
          else
            None()
        case o2: WhereDef.Def =>
          val r0: Option[Id] = transformId(o2.id)
          val r1: Option[IS[Z, Param]] = transformISZ(o2.params, transformParam _)
          val r2: Option[Type] = transformType(o2.rTipe)
          val r3: Option[IS[Z, SpecDef]] = transformISZ(o2.defs, transformSpecDef _)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
            Some(o2(id = r0.getOrElse(o2.id), params = r1.getOrElse(o2.params), rTipe = r2.getOrElse(o2.rTipe), defs = r3.getOrElse(o2.defs)))
          else
            None()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: WhereDef = r.getOrElse(o)
    val postR: Option[WhereDef] = post.transformWhereDef(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformSpecDef(o: SpecDef): Option[SpecDef] = {
    val preR: PreResult[SpecDef] = pre.transformSpecDef(o)
    val r: Option[SpecDef] = if (preR.continue) {
      val o2: SpecDef = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Option[Id]] = transformOption(o2.idOpt, transformId _)
      val r1: Option[Exp] = transformExp(o2.exp)
      val r2: Option[Option[Pattern]] = transformOption(o2.patternOpt, transformPattern _)
      val r3: Option[Option[Exp]] = transformOption(o2.guardOpt, transformExp _)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty| r3.nonEmpty)
        Some(o2(idOpt = r0.getOrElse(o2.idOpt), exp = r1.getOrElse(o2.exp), patternOpt = r2.getOrElse(o2.patternOpt), guardOpt = r3.getOrElse(o2.guardOpt)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: SpecDef = r.getOrElse(o)
    val postR: Option[SpecDef] = post.transformSpecDef(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformProofStep(o: ProofStep): Option[ProofStep] = {
    val preR: PreResult[ProofStep] = pre.transformProofStep(o)
    val r: Option[ProofStep] = if (preR.continue) {
      val o2: ProofStep = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Option[ProofStep] = o2 match {
        case o2: ProofStep.Basic =>
          val r0: Option[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: Option[Exp] = transformExp(o2.exp)
          val r2: Option[Just] = transformJust(o2.just)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(step = r0.getOrElse(o2.step), exp = r1.getOrElse(o2.exp), just = r2.getOrElse(o2.just)))
          else
            None()
        case o2: ProofStep.SubProof =>
          val r0: Option[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: Option[AssumeProofStep] = transformAssumeProofStep(o2.assumeStep)
          val r2: Option[IS[Z, ProofStep]] = transformISZ(o2.steps, transformProofStep _)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(step = r0.getOrElse(o2.step), assumeStep = r1.getOrElse(o2.assumeStep), steps = r2.getOrElse(o2.steps)))
          else
            None()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: ProofStep = r.getOrElse(o)
    val postR: Option[ProofStep] = post.transformProofStep(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformExpLitZ(o: Exp.LitZ): Option[Exp.LitZ] = {
    val preR: PreResult[Exp.LitZ] = pre.transformExpLitZ(o) match {
      case PreResult(continue, Some(r: Exp.LitZ)) => PreResult(continue, Some[Exp.LitZ](r))
      case _ => assert(F); PreResult(F, None[Exp.LitZ]())
    }
    val r: Option[Exp.LitZ] = if (preR.continue) {
      val o2: Exp.LitZ = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Attr] = transformAttr(o2.attr)
      if (hasChanged| r0.nonEmpty)
        Some(o2(attr = r0.getOrElse(o2.attr)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Exp.LitZ = r.getOrElse(o)
    val postR: Option[Exp.LitZ] = post.transformExpLitZ(o2) match {
      case Some(result: Exp.LitZ) => Some[Exp.LitZ](result)
      case _ => assert(F); None[Exp.LitZ]()
    }
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformAssumeProofStep(o: AssumeProofStep): Option[AssumeProofStep] = {
    val preR: PreResult[AssumeProofStep] = pre.transformAssumeProofStep(o)
    val r: Option[AssumeProofStep] = if (preR.continue) {
      val o2: AssumeProofStep = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Option[AssumeProofStep] = o2 match {
        case o2: AssumeProofStep.Regular =>
          val r0: Option[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: Option[Exp] = transformExp(o2.exp)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(step = r0.getOrElse(o2.step), exp = r1.getOrElse(o2.exp)))
          else
            None()
        case o2: AssumeProofStep.ForallIntroAps =>
          val r0: Option[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: Option[IS[Z, VarFragment]] = transformISZ(o2.varFragments, transformVarFragment _)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(step = r0.getOrElse(o2.step), varFragments = r1.getOrElse(o2.varFragments)))
          else
            None()
        case o2: AssumeProofStep.ExistsElimAps =>
          val r0: Option[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: Option[IS[Z, VarFragment]] = transformISZ(o2.varFragments, transformVarFragment _)
          val r2: Option[Exp] = transformExp(o2.exp)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(step = r0.getOrElse(o2.step), varFragments = r1.getOrElse(o2.varFragments), exp = r2.getOrElse(o2.exp)))
          else
            None()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: AssumeProofStep = r.getOrElse(o)
    val postR: Option[AssumeProofStep] = post.transformAssumeProofStep(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformJust(o: Just): Option[Just] = {
    val preR: PreResult[Just] = pre.transformJust(o)
    val r: Option[Just] = if (preR.continue) {
      val o2: Just = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Option[Just] = o2 match {
        case o2: Just.Premise =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: Just.AndIntro =>
          val r0: Option[IS[Z, Exp.LitZ]] = transformISZ(o2.steps, transformExpLitZ _)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(steps = r0.getOrElse(o2.steps), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Just.AndElim =>
          val r0: Option[Exp.LitZ] = transformExpLitZ(o2.andStep)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(andStep = r0.getOrElse(o2.andStep), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Just.OrIntro =>
          val r0: Option[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(step = r0.getOrElse(o2.step), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Just.OrElim =>
          val r0: Option[Exp.LitZ] = transformExpLitZ(o2.orStep)
          val r1: Option[IS[Z, Exp.LitZ]] = transformISZ(o2.subProofSteps, transformExpLitZ _)
          val r2: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(orStep = r0.getOrElse(o2.orStep), subProofSteps = r1.getOrElse(o2.subProofSteps), attr = r2.getOrElse(o2.attr)))
          else
            None()
        case o2: Just.ImplyIntro =>
          val r0: Option[Exp.LitZ] = transformExpLitZ(o2.subProofStep)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(subProofStep = r0.getOrElse(o2.subProofStep), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Just.ImplyElim =>
          val r0: Option[Exp.LitZ] = transformExpLitZ(o2.implyStep)
          val r1: Option[IS[Z, Exp.LitZ]] = transformISZ(o2.steps, transformExpLitZ _)
          val r2: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(implyStep = r0.getOrElse(o2.implyStep), steps = r1.getOrElse(o2.steps), attr = r2.getOrElse(o2.attr)))
          else
            None()
        case o2: Just.NegIntro =>
          val r0: Option[Exp.LitZ] = transformExpLitZ(o2.subProofStep)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(subProofStep = r0.getOrElse(o2.subProofStep), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Just.NegElim =>
          val r0: Option[Exp.LitZ] = transformExpLitZ(o2.step)
          val r1: Option[Exp.LitZ] = transformExpLitZ(o2.negStep)
          val r2: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(step = r0.getOrElse(o2.step), negStep = r1.getOrElse(o2.negStep), attr = r2.getOrElse(o2.attr)))
          else
            None()
        case o2: Just.BottomElim =>
          val r0: Option[Exp.LitZ] = transformExpLitZ(o2.subProofStep)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(subProofStep = r0.getOrElse(o2.subProofStep), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Just.Pbc =>
          val r0: Option[Exp.LitZ] = transformExpLitZ(o2.subProofStep)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(subProofStep = r0.getOrElse(o2.subProofStep), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Just.ForallIntro =>
          val r0: Option[Exp.LitZ] = transformExpLitZ(o2.subProofStep)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(subProofStep = r0.getOrElse(o2.subProofStep), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Just.ForallElim =>
          val r0: Option[Exp.LitZ] = transformExpLitZ(o2.forallStep)
          val r1: Option[IS[Z, Exp]] = transformISZ(o2.args, transformExp _)
          val r2: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(forallStep = r0.getOrElse(o2.forallStep), args = r1.getOrElse(o2.args), attr = r2.getOrElse(o2.attr)))
          else
            None()
        case o2: Just.ExistsIntro =>
          val r0: Option[Exp.LitZ] = transformExpLitZ(o2.existsStep)
          val r1: Option[IS[Z, Exp]] = transformISZ(o2.args, transformExp _)
          val r2: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(existsStep = r0.getOrElse(o2.existsStep), args = r1.getOrElse(o2.args), attr = r2.getOrElse(o2.attr)))
          else
            None()
        case o2: Just.ExistsElim =>
          val r0: Option[Exp.LitZ] = transformExpLitZ(o2.existsStep)
          val r1: Option[Exp.LitZ] = transformExpLitZ(o2.subProofStep)
          val r2: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(existsStep = r0.getOrElse(o2.existsStep), subProofStep = r1.getOrElse(o2.subProofStep), attr = r2.getOrElse(o2.attr)))
          else
            None()
        case o2: Just.Fact =>
          val r0: Option[Name] = transformName(o2.name)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(name = r0.getOrElse(o2.name), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Just.Invariant =>
          val r0: Option[Option[Name]] = transformOption(o2.nameOpt, transformName _)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(nameOpt = r0.getOrElse(o2.nameOpt), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Just.Subst =>
          val r0: Option[Exp.LitZ] = transformExpLitZ(o2.eqStep)
          val r1: Option[Exp.LitZ] = transformExpLitZ(o2.step)
          val r2: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(eqStep = r0.getOrElse(o2.eqStep), step = r1.getOrElse(o2.step), attr = r2.getOrElse(o2.attr)))
          else
            None()
        case o2: Just.Auto =>
          val r0: Option[IS[Z, Exp.LitZ]] = transformISZ(o2.steps, transformExpLitZ _)
          val r1: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty)
            Some(o2(steps = r0.getOrElse(o2.steps), attr = r1.getOrElse(o2.attr)))
          else
            None()
        case o2: Just.Coq =>
          val r0: Option[Exp.LitString] = transformExpLitString(o2.path)
          val r1: Option[IS[Z, Exp.LitZ]] = transformISZ(o2.steps, transformExpLitZ _)
          val r2: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
            Some(o2(path = r0.getOrElse(o2.path), steps = r1.getOrElse(o2.steps), attr = r2.getOrElse(o2.attr)))
          else
            None()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Just = r.getOrElse(o)
    val postR: Option[Just] = post.transformJust(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformTruthTableRow(o: TruthTable.Row): Option[TruthTable.Row] = {
    val preR: PreResult[TruthTable.Row] = pre.transformTruthTableRow(o)
    val r: Option[TruthTable.Row] = if (preR.continue) {
      val o2: TruthTable.Row = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[IS[Z, Exp.LitB]] = transformISZ(o2.assignment, transformExpLitB _)
      val r1: Option[IS[Z, Exp.LitB]] = transformISZ(o2.values, transformExpLitB _)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty)
        Some(o2(assignment = r0.getOrElse(o2.assignment), values = r1.getOrElse(o2.values)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: TruthTable.Row = r.getOrElse(o)
    val postR: Option[TruthTable.Row] = post.transformTruthTableRow(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformExpLitB(o: Exp.LitB): Option[Exp.LitB] = {
    val preR: PreResult[Exp.LitB] = pre.transformExpLitB(o) match {
      case PreResult(continue, Some(r: Exp.LitB)) => PreResult(continue, Some[Exp.LitB](r))
      case _ => assert(F); PreResult(F, None[Exp.LitB]())
    }
    val r: Option[Exp.LitB] = if (preR.continue) {
      val o2: Exp.LitB = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Attr] = transformAttr(o2.attr)
      if (hasChanged| r0.nonEmpty)
        Some(o2(attr = r0.getOrElse(o2.attr)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Exp.LitB = r.getOrElse(o)
    val postR: Option[Exp.LitB] = post.transformExpLitB(o2) match {
      case Some(result: Exp.LitB) => Some[Exp.LitB](result)
      case _ => assert(F); None[Exp.LitB]()
    }
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformTruthTableConclusion(o: TruthTable.Conclusion): Option[TruthTable.Conclusion] = {
    val preR: PreResult[TruthTable.Conclusion] = pre.transformTruthTableConclusion(o)
    val r: Option[TruthTable.Conclusion] = if (preR.continue) {
      val o2: TruthTable.Conclusion = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Option[TruthTable.Conclusion] = o2 match {
        case o2: TruthTable.Conclusion.Validity =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: TruthTable.Conclusion.Tautology =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: TruthTable.Conclusion.Contradictory =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
        case o2: TruthTable.Conclusion.Contingent =>
          val r0: Option[Attr] = transformAttr(o2.attr)
          if (hasChanged| r0.nonEmpty)
            Some(o2(attr = r0.getOrElse(o2.attr)))
          else
            None()
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: TruthTable.Conclusion = r.getOrElse(o)
    val postR: Option[TruthTable.Conclusion] = post.transformTruthTableConclusion(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformAttr(o: Attr): Option[Attr] = {
    val preR: PreResult[Attr] = pre.transformAttr(o)
    val r: Option[Attr] = if (preR.continue) {
      val o2: Attr = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Option[PosInfo]] = transformOption(o2.posInfoOpt, transformPosInfo _)
      if (hasChanged| r0.nonEmpty)
        Some(o2(posInfoOpt = r0.getOrElse(o2.posInfoOpt)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: Attr = r.getOrElse(o)
    val postR: Option[Attr] = post.transformAttr(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformTypedAttr(o: TypedAttr): Option[TypedAttr] = {
    val preR: PreResult[TypedAttr] = pre.transformTypedAttr(o)
    val r: Option[TypedAttr] = if (preR.continue) {
      val o2: TypedAttr = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Option[PosInfo]] = transformOption(o2.posInfoOpt, transformPosInfo _)
      val r1: Option[Option[Type]] = transformOption(o2.typeOpt, transformType _)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty)
        Some(o2(posInfoOpt = r0.getOrElse(o2.posInfoOpt), typeOpt = r1.getOrElse(o2.typeOpt)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: TypedAttr = r.getOrElse(o)
    val postR: Option[TypedAttr] = post.transformTypedAttr(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformResolvedAttr(o: ResolvedAttr): Option[ResolvedAttr] = {
    val preR: PreResult[ResolvedAttr] = pre.transformResolvedAttr(o)
    val r: Option[ResolvedAttr] = if (preR.continue) {
      val o2: ResolvedAttr = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Option[Option[PosInfo]] = transformOption(o2.posInfoOpt, transformPosInfo _)
      val r1: Option[Option[ResolvedInfo]] = transformOption(o2.resOpt, transformResolvedInfo _)
      val r2: Option[Option[Type]] = transformOption(o2.typeOpt, transformType _)
      if (hasChanged| r0.nonEmpty| r1.nonEmpty| r2.nonEmpty)
        Some(o2(posInfoOpt = r0.getOrElse(o2.posInfoOpt), resOpt = r1.getOrElse(o2.resOpt), typeOpt = r2.getOrElse(o2.typeOpt)))
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: ResolvedAttr = r.getOrElse(o)
    val postR: Option[ResolvedAttr] = post.transformResolvedAttr(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformResolvedInfo(o: ResolvedInfo): Option[ResolvedInfo] = {
    val preR: PreResult[ResolvedInfo] = pre.transformResolvedInfo(o)
    val r: Option[ResolvedInfo] = if (preR.continue) {
      val o2: ResolvedInfo = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      if (hasChanged)
        Some(o2)
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: ResolvedInfo = r.getOrElse(o)
    val postR: Option[ResolvedInfo] = post.transformResolvedInfo(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

  def transformPosInfo(o: PosInfo): Option[PosInfo] = {
    val preR: PreResult[PosInfo] = pre.transformPosInfo(o)
    val r: Option[PosInfo] = if (preR.continue) {
      val o2: PosInfo = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      if (hasChanged)
        Some(o2)
      else
        None()
    } else if (preR.resultOpt.nonEmpty) {
      Some(preR.resultOpt.getOrElse(o))
    } else {
      None()
    }
    val hasChanged: B = r.nonEmpty
    val o2: PosInfo = r.getOrElse(o)
    val postR: Option[PosInfo] = post.transformPosInfo(o2)
    if (postR.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Some(o2)
    } else {
      return None()
    }
  }

}
