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

object Transformer {

  @datatype class PreResult[Context, T](ctx: Context,
                                        continue: B,
                                        resultOpt: Option[T])

  @datatype class Result[Context, T](ctx: Context,
                                     resultOpt: Option[T])

  @sig trait Pre[Context] {

    @pure def transformTopUnit(ctx: Context, o: TopUnit): PreResult[Context, TopUnit] = {
      o match {
        case o: TopUnit.Program => return transformTopUnitProgram(ctx, o)
        case o: TopUnit.SequentUnit => return transformTopUnitSequentUnit(ctx, o)
        case o: TopUnit.TruthTableUnit => return transformTopUnitTruthTableUnit(ctx, o)
      }
    }

    @pure def transformTopUnitProgram(ctx: Context, o: TopUnit.Program): PreResult[Context, TopUnit] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformTopUnitSequentUnit(ctx: Context, o: TopUnit.SequentUnit): PreResult[Context, TopUnit] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformTopUnitTruthTableUnit(ctx: Context, o: TopUnit.TruthTableUnit): PreResult[Context, TopUnit] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmt(ctx: Context, o: Stmt): PreResult[Context, Stmt] = {
      o match {
        case o: Stmt.Import => return transformStmtImport(ctx, o)
        case o: Stmt.Var => return transformStmtVar(ctx, o)
        case o: Stmt.VarPattern => return transformStmtVarPattern(ctx, o)
        case o: Stmt.SpecVar => return transformStmtSpecVar(ctx, o)
        case o: Stmt.Method => return transformStmtMethod(ctx, o)
        case o: Stmt.ExtMethod => return transformStmtExtMethod(ctx, o)
        case o: Stmt.SpecMethod => return transformStmtSpecMethod(ctx, o)
        case o: Stmt.Enum => return transformStmtEnum(ctx, o)
        case o: Stmt.Object => return transformStmtObject(ctx, o)
        case o: Stmt.Sig => return transformStmtSig(ctx, o)
        case o: Stmt.AbstractDatatype => return transformStmtAbstractDatatype(ctx, o)
        case o: Stmt.Rich => return transformStmtRich(ctx, o)
        case o: Stmt.TypeAlias => return transformStmtTypeAlias(ctx, o)
        case o: Stmt.Assign => return transformStmtAssign(ctx, o)
        case o: Stmt.AssignUp => return transformStmtAssignUp(ctx, o)
        case o: Stmt.AssignPattern => return transformStmtAssignPattern(ctx, o)
        case o: Stmt.Block => return transformStmtBlock(ctx, o)
        case o: Stmt.If => return transformStmtIf(ctx, o)
        case o: Stmt.Match => return transformStmtMatch(ctx, o)
        case o: Stmt.While => return transformStmtWhile(ctx, o)
        case o: Stmt.DoWhile => return transformStmtDoWhile(ctx, o)
        case o: Stmt.For => return transformStmtFor(ctx, o)
        case o: Stmt.Return => return transformStmtReturn(ctx, o)
        case o: Stmt.LStmt => return transformStmtLStmt(ctx, o)
        case o: Stmt.Expr => return transformStmtExpr(ctx, o)
      }
    }

    @pure def transformStmtImport(ctx: Context, o: Stmt.Import): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtImportImporter(ctx: Context, o: Stmt.Import.Importer): PreResult[Context, Stmt.Import.Importer] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtImportSelector(ctx: Context, o: Stmt.Import.Selector): PreResult[Context, Stmt.Import.Selector] = {
      o match {
        case o: Stmt.Import.MultiSelector => return transformStmtImportMultiSelector(ctx, o)
        case o: Stmt.Import.WildcardSelector => return transformStmtImportWildcardSelector(ctx, o)
      }
    }

    @pure def transformStmtImportMultiSelector(ctx: Context, o: Stmt.Import.MultiSelector): PreResult[Context, Stmt.Import.Selector] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtImportWildcardSelector(ctx: Context, o: Stmt.Import.WildcardSelector): PreResult[Context, Stmt.Import.Selector] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtImportNamedSelector(ctx: Context, o: Stmt.Import.NamedSelector): PreResult[Context, Stmt.Import.NamedSelector] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtVar(ctx: Context, o: Stmt.Var): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtVarPattern(ctx: Context, o: Stmt.VarPattern): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtSpecVar(ctx: Context, o: Stmt.SpecVar): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtMethod(ctx: Context, o: Stmt.Method): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtExtMethod(ctx: Context, o: Stmt.ExtMethod): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtSpecMethod(ctx: Context, o: Stmt.SpecMethod): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtEnum(ctx: Context, o: Stmt.Enum): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtObject(ctx: Context, o: Stmt.Object): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtSig(ctx: Context, o: Stmt.Sig): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtAbstractDatatype(ctx: Context, o: Stmt.AbstractDatatype): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtRich(ctx: Context, o: Stmt.Rich): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtTypeAlias(ctx: Context, o: Stmt.TypeAlias): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtAssign(ctx: Context, o: Stmt.Assign): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtAssignUp(ctx: Context, o: Stmt.AssignUp): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtAssignPattern(ctx: Context, o: Stmt.AssignPattern): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtBlock(ctx: Context, o: Stmt.Block): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtIf(ctx: Context, o: Stmt.If): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtMatch(ctx: Context, o: Stmt.Match): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtWhile(ctx: Context, o: Stmt.While): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtDoWhile(ctx: Context, o: Stmt.DoWhile): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtFor(ctx: Context, o: Stmt.For): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtReturn(ctx: Context, o: Stmt.Return): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtLStmt(ctx: Context, o: Stmt.LStmt): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformStmtExpr(ctx: Context, o: Stmt.Expr): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformLClause(ctx: Context, o: LClause): PreResult[Context, LClause] = {
      o match {
        case o: LClause.Invariants => return transformLClauseInvariants(ctx, o)
        case o: LClause.Facts => return transformLClauseFacts(ctx, o)
        case o: LClause.Theorems => return transformLClauseTheorems(ctx, o)
        case o: LClause.Sequent => return transformLClauseSequent(ctx, o)
        case o: LClause.Proof => return transformLClauseProof(ctx, o)
      }
    }

    @pure def transformLClauseInvariants(ctx: Context, o: LClause.Invariants): PreResult[Context, LClause] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformLClauseFacts(ctx: Context, o: LClause.Facts): PreResult[Context, LClause] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformLClauseFact(ctx: Context, o: LClause.Fact): PreResult[Context, LClause.Fact] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformLClauseTheorems(ctx: Context, o: LClause.Theorems): PreResult[Context, LClause] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformLClauseTheorem(ctx: Context, o: LClause.Theorem): PreResult[Context, LClause.Theorem] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformLClauseSequent(ctx: Context, o: LClause.Sequent): PreResult[Context, LClause] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformLClauseProof(ctx: Context, o: LClause.Proof): PreResult[Context, LClause] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformContractExp(ctx: Context, o: ContractExp): PreResult[Context, ContractExp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformCase(ctx: Context, o: Case): PreResult[Context, Case] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformRange(ctx: Context, o: Range): PreResult[Context, Range] = {
      o match {
        case o: Range.Expr => return transformRangeExpr(ctx, o)
        case o: Range.Indices => return transformRangeIndices(ctx, o)
        case o: Range.Step => return transformRangeStep(ctx, o)
      }
    }

    @pure def transformRangeExpr(ctx: Context, o: Range.Expr): PreResult[Context, Range] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformRangeIndices(ctx: Context, o: Range.Indices): PreResult[Context, Range] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformRangeStep(ctx: Context, o: Range.Step): PreResult[Context, Range] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformType(ctx: Context, o: Type): PreResult[Context, Type] = {
      o match {
        case o: Type.Named => return transformTypeNamed(ctx, o)
        case o: Type.Fun => return transformTypeFun(ctx, o)
        case o: Type.Tuple => return transformTypeTuple(ctx, o)
      }
    }

    @pure def transformTypeNamed(ctx: Context, o: Type.Named): PreResult[Context, Type] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformTypeFun(ctx: Context, o: Type.Fun): PreResult[Context, Type] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformTypeTuple(ctx: Context, o: Type.Tuple): PreResult[Context, Type] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformPattern(ctx: Context, o: Pattern): PreResult[Context, Pattern] = {
      o match {
        case o: Pattern.Literal => return transformPatternLiteral(ctx, o)
        case o: Pattern.Ref => return transformPatternRef(ctx, o)
        case o: Pattern.Variable => return transformPatternVariable(ctx, o)
        case o: Pattern.Wildcard => return transformPatternWildcard(ctx, o)
        case o: Pattern.SeqWildcard => return transformPatternSeqWildcard(ctx, o)
        case o: Pattern.Structure => return transformPatternStructure(ctx, o)
      }
    }

    @pure def transformPatternLiteral(ctx: Context, o: Pattern.Literal): PreResult[Context, Pattern] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformPatternRef(ctx: Context, o: Pattern.Ref): PreResult[Context, Pattern] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformPatternVariable(ctx: Context, o: Pattern.Variable): PreResult[Context, Pattern] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformPatternWildcard(ctx: Context, o: Pattern.Wildcard): PreResult[Context, Pattern] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformPatternSeqWildcard(ctx: Context, o: Pattern.SeqWildcard): PreResult[Context, Pattern] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformPatternStructure(ctx: Context, o: Pattern.Structure): PreResult[Context, Pattern] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExp(ctx: Context, o: Exp): PreResult[Context, Exp] = {
      o match {
        case o: Exp.LitB => return transformExpLitB(ctx, o)
        case o: Exp.LitC => return transformExpLitC(ctx, o)
        case o: Exp.LitZ => return transformExpLitZ(ctx, o)
        case o: Exp.LitZ8 => return transformExpLitZ8(ctx, o)
        case o: Exp.LitZ16 => return transformExpLitZ16(ctx, o)
        case o: Exp.LitZ32 => return transformExpLitZ32(ctx, o)
        case o: Exp.LitZ64 => return transformExpLitZ64(ctx, o)
        case o: Exp.LitN => return transformExpLitN(ctx, o)
        case o: Exp.LitN8 => return transformExpLitN8(ctx, o)
        case o: Exp.LitN16 => return transformExpLitN16(ctx, o)
        case o: Exp.LitN32 => return transformExpLitN32(ctx, o)
        case o: Exp.LitN64 => return transformExpLitN64(ctx, o)
        case o: Exp.LitS8 => return transformExpLitS8(ctx, o)
        case o: Exp.LitS16 => return transformExpLitS16(ctx, o)
        case o: Exp.LitS32 => return transformExpLitS32(ctx, o)
        case o: Exp.LitS64 => return transformExpLitS64(ctx, o)
        case o: Exp.LitU8 => return transformExpLitU8(ctx, o)
        case o: Exp.LitU16 => return transformExpLitU16(ctx, o)
        case o: Exp.LitU32 => return transformExpLitU32(ctx, o)
        case o: Exp.LitU64 => return transformExpLitU64(ctx, o)
        case o: Exp.LitF32 => return transformExpLitF32(ctx, o)
        case o: Exp.LitF64 => return transformExpLitF64(ctx, o)
        case o: Exp.LitR => return transformExpLitR(ctx, o)
        case o: Exp.LitBv => return transformExpLitBv(ctx, o)
        case o: Exp.LitString => return transformExpLitString(ctx, o)
        case o: Exp.StringInterpolate => return transformExpStringInterpolate(ctx, o)
        case o: Exp.This => return transformExpThis(ctx, o)
        case o: Exp.Unary => return transformExpUnary(ctx, o)
        case o: Exp.Binary => return transformExpBinary(ctx, o)
        case o: Exp.Ident => return transformExpIdent(ctx, o)
        case o: Exp.Eta => return transformExpEta(ctx, o)
        case o: Exp.Tuple => return transformExpTuple(ctx, o)
        case o: Exp.Select => return transformExpSelect(ctx, o)
        case o: Exp.Invoke => return transformExpInvoke(ctx, o)
        case o: Exp.InvokeNamed => return transformExpInvokeNamed(ctx, o)
        case o: Exp.If => return transformExpIf(ctx, o)
        case o: Exp.Quant => return transformExpQuant(ctx, o)
      }
    }

    @pure def transformExpLitB(ctx: Context, o: Exp.LitB): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitC(ctx: Context, o: Exp.LitC): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitZ(ctx: Context, o: Exp.LitZ): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitZ8(ctx: Context, o: Exp.LitZ8): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitZ16(ctx: Context, o: Exp.LitZ16): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitZ32(ctx: Context, o: Exp.LitZ32): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitZ64(ctx: Context, o: Exp.LitZ64): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitN(ctx: Context, o: Exp.LitN): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitN8(ctx: Context, o: Exp.LitN8): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitN16(ctx: Context, o: Exp.LitN16): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitN32(ctx: Context, o: Exp.LitN32): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitN64(ctx: Context, o: Exp.LitN64): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitS8(ctx: Context, o: Exp.LitS8): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitS16(ctx: Context, o: Exp.LitS16): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitS32(ctx: Context, o: Exp.LitS32): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitS64(ctx: Context, o: Exp.LitS64): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitU8(ctx: Context, o: Exp.LitU8): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitU16(ctx: Context, o: Exp.LitU16): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitU32(ctx: Context, o: Exp.LitU32): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitU64(ctx: Context, o: Exp.LitU64): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitF32(ctx: Context, o: Exp.LitF32): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitF64(ctx: Context, o: Exp.LitF64): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitR(ctx: Context, o: Exp.LitR): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitBv(ctx: Context, o: Exp.LitBv): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpLitString(ctx: Context, o: Exp.LitString): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpStringInterpolate(ctx: Context, o: Exp.StringInterpolate): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpThis(ctx: Context, o: Exp.This): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpUnary(ctx: Context, o: Exp.Unary): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpBinary(ctx: Context, o: Exp.Binary): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpIdent(ctx: Context, o: Exp.Ident): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpEta(ctx: Context, o: Exp.Eta): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpTuple(ctx: Context, o: Exp.Tuple): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpSelect(ctx: Context, o: Exp.Select): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpInvoke(ctx: Context, o: Exp.Invoke): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpInvokeNamed(ctx: Context, o: Exp.InvokeNamed): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpIf(ctx: Context, o: Exp.If): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformExpQuant(ctx: Context, o: Exp.Quant): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformNamedArg(ctx: Context, o: NamedArg): PreResult[Context, NamedArg] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformVarFragment(ctx: Context, o: VarFragment): PreResult[Context, VarFragment] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformDomain(ctx: Context, o: Domain): PreResult[Context, Domain] = {
      o match {
        case o: Domain.Type => return transformDomainType(ctx, o)
        case o: Domain.Range => return transformDomainRange(ctx, o)
      }
    }

    @pure def transformDomainType(ctx: Context, o: Domain.Type): PreResult[Context, Domain] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformDomainRange(ctx: Context, o: Domain.Range): PreResult[Context, Domain] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformId(ctx: Context, o: Id): PreResult[Context, Id] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformName(ctx: Context, o: Name): PreResult[Context, Name] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformBody(ctx: Context, o: Body): PreResult[Context, Body] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformAbstractDatatypeParam(ctx: Context, o: AbstractDatatypeParam): PreResult[Context, AbstractDatatypeParam] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformMethodSig(ctx: Context, o: MethodSig): PreResult[Context, MethodSig] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformParam(ctx: Context, o: Param): PreResult[Context, Param] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformTypeParam(ctx: Context, o: TypeParam): PreResult[Context, TypeParam] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformContract(ctx: Context, o: Contract): PreResult[Context, Contract] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformSubContract(ctx: Context, o: SubContract): PreResult[Context, SubContract] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformSubContractParam(ctx: Context, o: SubContractParam): PreResult[Context, SubContractParam] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformWhereDef(ctx: Context, o: WhereDef): PreResult[Context, WhereDef] = {
      o match {
        case o: WhereDef.Val => return transformWhereDefVal(ctx, o)
        case o: WhereDef.Def => return transformWhereDefDef(ctx, o)
      }
    }

    @pure def transformWhereDefVal(ctx: Context, o: WhereDef.Val): PreResult[Context, WhereDef] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformWhereDefDef(ctx: Context, o: WhereDef.Def): PreResult[Context, WhereDef] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformSpecDef(ctx: Context, o: SpecDef): PreResult[Context, SpecDef] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformProofStep(ctx: Context, o: ProofStep): PreResult[Context, ProofStep] = {
      o match {
        case o: ProofStep.Basic => return transformProofStepBasic(ctx, o)
        case o: ProofStep.SubProof => return transformProofStepSubProof(ctx, o)
      }
    }

    @pure def transformProofStepBasic(ctx: Context, o: ProofStep.Basic): PreResult[Context, ProofStep] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformProofStepSubProof(ctx: Context, o: ProofStep.SubProof): PreResult[Context, ProofStep] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformAssumeProofStep(ctx: Context, o: AssumeProofStep): PreResult[Context, AssumeProofStep] = {
      o match {
        case o: AssumeProofStep.Regular => return transformAssumeProofStepRegular(ctx, o)
        case o: AssumeProofStep.ForallIntroAps => return transformAssumeProofStepForallIntroAps(ctx, o)
        case o: AssumeProofStep.ExistsElimAps => return transformAssumeProofStepExistsElimAps(ctx, o)
      }
    }

    @pure def transformAssumeProofStepRegular(ctx: Context, o: AssumeProofStep.Regular): PreResult[Context, AssumeProofStep] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformAssumeProofStepForallIntroAps(ctx: Context, o: AssumeProofStep.ForallIntroAps): PreResult[Context, AssumeProofStep] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformAssumeProofStepExistsElimAps(ctx: Context, o: AssumeProofStep.ExistsElimAps): PreResult[Context, AssumeProofStep] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJust(ctx: Context, o: Just): PreResult[Context, Just] = {
      o match {
        case o: Just.Premise => return transformJustPremise(ctx, o)
        case o: Just.AndIntro => return transformJustAndIntro(ctx, o)
        case o: Just.AndElim => return transformJustAndElim(ctx, o)
        case o: Just.OrIntro => return transformJustOrIntro(ctx, o)
        case o: Just.OrElim => return transformJustOrElim(ctx, o)
        case o: Just.ImplyIntro => return transformJustImplyIntro(ctx, o)
        case o: Just.ImplyElim => return transformJustImplyElim(ctx, o)
        case o: Just.NegIntro => return transformJustNegIntro(ctx, o)
        case o: Just.NegElim => return transformJustNegElim(ctx, o)
        case o: Just.BottomElim => return transformJustBottomElim(ctx, o)
        case o: Just.Pbc => return transformJustPbc(ctx, o)
        case o: Just.ForallIntro => return transformJustForallIntro(ctx, o)
        case o: Just.ForallElim => return transformJustForallElim(ctx, o)
        case o: Just.ExistsIntro => return transformJustExistsIntro(ctx, o)
        case o: Just.ExistsElim => return transformJustExistsElim(ctx, o)
        case o: Just.Fact => return transformJustFact(ctx, o)
        case o: Just.Invariant => return transformJustInvariant(ctx, o)
        case o: Just.Subst => return transformJustSubst(ctx, o)
        case o: Just.Auto => return transformJustAuto(ctx, o)
        case o: Just.Coq => return transformJustCoq(ctx, o)
      }
    }

    @pure def transformJustPremise(ctx: Context, o: Just.Premise): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJustAndIntro(ctx: Context, o: Just.AndIntro): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJustAndElim(ctx: Context, o: Just.AndElim): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJustOrIntro(ctx: Context, o: Just.OrIntro): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJustOrElim(ctx: Context, o: Just.OrElim): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJustImplyIntro(ctx: Context, o: Just.ImplyIntro): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJustImplyElim(ctx: Context, o: Just.ImplyElim): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJustNegIntro(ctx: Context, o: Just.NegIntro): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJustNegElim(ctx: Context, o: Just.NegElim): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJustBottomElim(ctx: Context, o: Just.BottomElim): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJustPbc(ctx: Context, o: Just.Pbc): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJustForallIntro(ctx: Context, o: Just.ForallIntro): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJustForallElim(ctx: Context, o: Just.ForallElim): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJustExistsIntro(ctx: Context, o: Just.ExistsIntro): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJustExistsElim(ctx: Context, o: Just.ExistsElim): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJustFact(ctx: Context, o: Just.Fact): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJustInvariant(ctx: Context, o: Just.Invariant): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJustSubst(ctx: Context, o: Just.Subst): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJustAuto(ctx: Context, o: Just.Auto): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformJustCoq(ctx: Context, o: Just.Coq): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformTruthTableRow(ctx: Context, o: TruthTable.Row): PreResult[Context, TruthTable.Row] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformTruthTableConclusion(ctx: Context, o: TruthTable.Conclusion): PreResult[Context, TruthTable.Conclusion] = {
      o match {
        case o: TruthTable.Conclusion.Validity => return transformTruthTableConclusionValidity(ctx, o)
        case o: TruthTable.Conclusion.Tautology => return transformTruthTableConclusionTautology(ctx, o)
        case o: TruthTable.Conclusion.Contradictory => return transformTruthTableConclusionContradictory(ctx, o)
        case o: TruthTable.Conclusion.Contingent => return transformTruthTableConclusionContingent(ctx, o)
      }
    }

    @pure def transformTruthTableConclusionValidity(ctx: Context, o: TruthTable.Conclusion.Validity): PreResult[Context, TruthTable.Conclusion] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformTruthTableConclusionTautology(ctx: Context, o: TruthTable.Conclusion.Tautology): PreResult[Context, TruthTable.Conclusion] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformTruthTableConclusionContradictory(ctx: Context, o: TruthTable.Conclusion.Contradictory): PreResult[Context, TruthTable.Conclusion] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformTruthTableConclusionContingent(ctx: Context, o: TruthTable.Conclusion.Contingent): PreResult[Context, TruthTable.Conclusion] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformAttr(ctx: Context, o: Attr): PreResult[Context, Attr] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformTypedAttr(ctx: Context, o: TypedAttr): PreResult[Context, TypedAttr] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformResolvedAttr(ctx: Context, o: ResolvedAttr): PreResult[Context, ResolvedAttr] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformResolvedInfo(ctx: Context, o: ResolvedInfo): PreResult[Context, ResolvedInfo] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformPosInfo(ctx: Context, o: PosInfo): PreResult[Context, PosInfo] = {
      return PreResult(ctx, T, None())
    }

  }

  @sig trait Post[Context] {

    @pure def transformTopUnit(ctx: Context, o: TopUnit): Result[Context, TopUnit] = {
      o match {
        case o: TopUnit.Program => return transformTopUnitProgram(ctx, o)
        case o: TopUnit.SequentUnit => return transformTopUnitSequentUnit(ctx, o)
        case o: TopUnit.TruthTableUnit => return transformTopUnitTruthTableUnit(ctx, o)
      }
    }

    @pure def transformTopUnitProgram(ctx: Context, o: TopUnit.Program): Result[Context, TopUnit] = {
      return Result(ctx, None())
    }

    @pure def transformTopUnitSequentUnit(ctx: Context, o: TopUnit.SequentUnit): Result[Context, TopUnit] = {
      return Result(ctx, None())
    }

    @pure def transformTopUnitTruthTableUnit(ctx: Context, o: TopUnit.TruthTableUnit): Result[Context, TopUnit] = {
      return Result(ctx, None())
    }

    @pure def transformStmt(ctx: Context, o: Stmt): Result[Context, Stmt] = {
      o match {
        case o: Stmt.Import => return transformStmtImport(ctx, o)
        case o: Stmt.Var => return transformStmtVar(ctx, o)
        case o: Stmt.VarPattern => return transformStmtVarPattern(ctx, o)
        case o: Stmt.SpecVar => return transformStmtSpecVar(ctx, o)
        case o: Stmt.Method => return transformStmtMethod(ctx, o)
        case o: Stmt.ExtMethod => return transformStmtExtMethod(ctx, o)
        case o: Stmt.SpecMethod => return transformStmtSpecMethod(ctx, o)
        case o: Stmt.Enum => return transformStmtEnum(ctx, o)
        case o: Stmt.Object => return transformStmtObject(ctx, o)
        case o: Stmt.Sig => return transformStmtSig(ctx, o)
        case o: Stmt.AbstractDatatype => return transformStmtAbstractDatatype(ctx, o)
        case o: Stmt.Rich => return transformStmtRich(ctx, o)
        case o: Stmt.TypeAlias => return transformStmtTypeAlias(ctx, o)
        case o: Stmt.Assign => return transformStmtAssign(ctx, o)
        case o: Stmt.AssignUp => return transformStmtAssignUp(ctx, o)
        case o: Stmt.AssignPattern => return transformStmtAssignPattern(ctx, o)
        case o: Stmt.Block => return transformStmtBlock(ctx, o)
        case o: Stmt.If => return transformStmtIf(ctx, o)
        case o: Stmt.Match => return transformStmtMatch(ctx, o)
        case o: Stmt.While => return transformStmtWhile(ctx, o)
        case o: Stmt.DoWhile => return transformStmtDoWhile(ctx, o)
        case o: Stmt.For => return transformStmtFor(ctx, o)
        case o: Stmt.Return => return transformStmtReturn(ctx, o)
        case o: Stmt.LStmt => return transformStmtLStmt(ctx, o)
        case o: Stmt.Expr => return transformStmtExpr(ctx, o)
      }
    }

    @pure def transformStmtImport(ctx: Context, o: Stmt.Import): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtImportImporter(ctx: Context, o: Stmt.Import.Importer): Result[Context, Stmt.Import.Importer] = {
      return Result(ctx, None())
    }

    @pure def transformStmtImportSelector(ctx: Context, o: Stmt.Import.Selector): Result[Context, Stmt.Import.Selector] = {
      o match {
        case o: Stmt.Import.MultiSelector => return transformStmtImportMultiSelector(ctx, o)
        case o: Stmt.Import.WildcardSelector => return transformStmtImportWildcardSelector(ctx, o)
      }
    }

    @pure def transformStmtImportMultiSelector(ctx: Context, o: Stmt.Import.MultiSelector): Result[Context, Stmt.Import.Selector] = {
      return Result(ctx, None())
    }

    @pure def transformStmtImportWildcardSelector(ctx: Context, o: Stmt.Import.WildcardSelector): Result[Context, Stmt.Import.Selector] = {
      return Result(ctx, None())
    }

    @pure def transformStmtImportNamedSelector(ctx: Context, o: Stmt.Import.NamedSelector): Result[Context, Stmt.Import.NamedSelector] = {
      return Result(ctx, None())
    }

    @pure def transformStmtVar(ctx: Context, o: Stmt.Var): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtVarPattern(ctx: Context, o: Stmt.VarPattern): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtSpecVar(ctx: Context, o: Stmt.SpecVar): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtMethod(ctx: Context, o: Stmt.Method): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtExtMethod(ctx: Context, o: Stmt.ExtMethod): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtSpecMethod(ctx: Context, o: Stmt.SpecMethod): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtEnum(ctx: Context, o: Stmt.Enum): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtObject(ctx: Context, o: Stmt.Object): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtSig(ctx: Context, o: Stmt.Sig): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtAbstractDatatype(ctx: Context, o: Stmt.AbstractDatatype): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtRich(ctx: Context, o: Stmt.Rich): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtTypeAlias(ctx: Context, o: Stmt.TypeAlias): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtAssign(ctx: Context, o: Stmt.Assign): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtAssignUp(ctx: Context, o: Stmt.AssignUp): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtAssignPattern(ctx: Context, o: Stmt.AssignPattern): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtBlock(ctx: Context, o: Stmt.Block): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtIf(ctx: Context, o: Stmt.If): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtMatch(ctx: Context, o: Stmt.Match): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtWhile(ctx: Context, o: Stmt.While): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtDoWhile(ctx: Context, o: Stmt.DoWhile): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtFor(ctx: Context, o: Stmt.For): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtReturn(ctx: Context, o: Stmt.Return): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtLStmt(ctx: Context, o: Stmt.LStmt): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformStmtExpr(ctx: Context, o: Stmt.Expr): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def transformLClause(ctx: Context, o: LClause): Result[Context, LClause] = {
      o match {
        case o: LClause.Invariants => return transformLClauseInvariants(ctx, o)
        case o: LClause.Facts => return transformLClauseFacts(ctx, o)
        case o: LClause.Theorems => return transformLClauseTheorems(ctx, o)
        case o: LClause.Sequent => return transformLClauseSequent(ctx, o)
        case o: LClause.Proof => return transformLClauseProof(ctx, o)
      }
    }

    @pure def transformLClauseInvariants(ctx: Context, o: LClause.Invariants): Result[Context, LClause] = {
      return Result(ctx, None())
    }

    @pure def transformLClauseFacts(ctx: Context, o: LClause.Facts): Result[Context, LClause] = {
      return Result(ctx, None())
    }

    @pure def transformLClauseFact(ctx: Context, o: LClause.Fact): Result[Context, LClause.Fact] = {
      return Result(ctx, None())
    }

    @pure def transformLClauseTheorems(ctx: Context, o: LClause.Theorems): Result[Context, LClause] = {
      return Result(ctx, None())
    }

    @pure def transformLClauseTheorem(ctx: Context, o: LClause.Theorem): Result[Context, LClause.Theorem] = {
      return Result(ctx, None())
    }

    @pure def transformLClauseSequent(ctx: Context, o: LClause.Sequent): Result[Context, LClause] = {
      return Result(ctx, None())
    }

    @pure def transformLClauseProof(ctx: Context, o: LClause.Proof): Result[Context, LClause] = {
      return Result(ctx, None())
    }

    @pure def transformContractExp(ctx: Context, o: ContractExp): Result[Context, ContractExp] = {
      return Result(ctx, None())
    }

    @pure def transformCase(ctx: Context, o: Case): Result[Context, Case] = {
      return Result(ctx, None())
    }

    @pure def transformRange(ctx: Context, o: Range): Result[Context, Range] = {
      o match {
        case o: Range.Expr => return transformRangeExpr(ctx, o)
        case o: Range.Indices => return transformRangeIndices(ctx, o)
        case o: Range.Step => return transformRangeStep(ctx, o)
      }
    }

    @pure def transformRangeExpr(ctx: Context, o: Range.Expr): Result[Context, Range] = {
      return Result(ctx, None())
    }

    @pure def transformRangeIndices(ctx: Context, o: Range.Indices): Result[Context, Range] = {
      return Result(ctx, None())
    }

    @pure def transformRangeStep(ctx: Context, o: Range.Step): Result[Context, Range] = {
      return Result(ctx, None())
    }

    @pure def transformType(ctx: Context, o: Type): Result[Context, Type] = {
      o match {
        case o: Type.Named => return transformTypeNamed(ctx, o)
        case o: Type.Fun => return transformTypeFun(ctx, o)
        case o: Type.Tuple => return transformTypeTuple(ctx, o)
      }
    }

    @pure def transformTypeNamed(ctx: Context, o: Type.Named): Result[Context, Type] = {
      return Result(ctx, None())
    }

    @pure def transformTypeFun(ctx: Context, o: Type.Fun): Result[Context, Type] = {
      return Result(ctx, None())
    }

    @pure def transformTypeTuple(ctx: Context, o: Type.Tuple): Result[Context, Type] = {
      return Result(ctx, None())
    }

    @pure def transformPattern(ctx: Context, o: Pattern): Result[Context, Pattern] = {
      o match {
        case o: Pattern.Literal => return transformPatternLiteral(ctx, o)
        case o: Pattern.Ref => return transformPatternRef(ctx, o)
        case o: Pattern.Variable => return transformPatternVariable(ctx, o)
        case o: Pattern.Wildcard => return transformPatternWildcard(ctx, o)
        case o: Pattern.SeqWildcard => return transformPatternSeqWildcard(ctx, o)
        case o: Pattern.Structure => return transformPatternStructure(ctx, o)
      }
    }

    @pure def transformPatternLiteral(ctx: Context, o: Pattern.Literal): Result[Context, Pattern] = {
      return Result(ctx, None())
    }

    @pure def transformPatternRef(ctx: Context, o: Pattern.Ref): Result[Context, Pattern] = {
      return Result(ctx, None())
    }

    @pure def transformPatternVariable(ctx: Context, o: Pattern.Variable): Result[Context, Pattern] = {
      return Result(ctx, None())
    }

    @pure def transformPatternWildcard(ctx: Context, o: Pattern.Wildcard): Result[Context, Pattern] = {
      return Result(ctx, None())
    }

    @pure def transformPatternSeqWildcard(ctx: Context, o: Pattern.SeqWildcard): Result[Context, Pattern] = {
      return Result(ctx, None())
    }

    @pure def transformPatternStructure(ctx: Context, o: Pattern.Structure): Result[Context, Pattern] = {
      return Result(ctx, None())
    }

    @pure def transformExp(ctx: Context, o: Exp): Result[Context, Exp] = {
      o match {
        case o: Exp.LitB => return transformExpLitB(ctx, o)
        case o: Exp.LitC => return transformExpLitC(ctx, o)
        case o: Exp.LitZ => return transformExpLitZ(ctx, o)
        case o: Exp.LitZ8 => return transformExpLitZ8(ctx, o)
        case o: Exp.LitZ16 => return transformExpLitZ16(ctx, o)
        case o: Exp.LitZ32 => return transformExpLitZ32(ctx, o)
        case o: Exp.LitZ64 => return transformExpLitZ64(ctx, o)
        case o: Exp.LitN => return transformExpLitN(ctx, o)
        case o: Exp.LitN8 => return transformExpLitN8(ctx, o)
        case o: Exp.LitN16 => return transformExpLitN16(ctx, o)
        case o: Exp.LitN32 => return transformExpLitN32(ctx, o)
        case o: Exp.LitN64 => return transformExpLitN64(ctx, o)
        case o: Exp.LitS8 => return transformExpLitS8(ctx, o)
        case o: Exp.LitS16 => return transformExpLitS16(ctx, o)
        case o: Exp.LitS32 => return transformExpLitS32(ctx, o)
        case o: Exp.LitS64 => return transformExpLitS64(ctx, o)
        case o: Exp.LitU8 => return transformExpLitU8(ctx, o)
        case o: Exp.LitU16 => return transformExpLitU16(ctx, o)
        case o: Exp.LitU32 => return transformExpLitU32(ctx, o)
        case o: Exp.LitU64 => return transformExpLitU64(ctx, o)
        case o: Exp.LitF32 => return transformExpLitF32(ctx, o)
        case o: Exp.LitF64 => return transformExpLitF64(ctx, o)
        case o: Exp.LitR => return transformExpLitR(ctx, o)
        case o: Exp.LitBv => return transformExpLitBv(ctx, o)
        case o: Exp.LitString => return transformExpLitString(ctx, o)
        case o: Exp.StringInterpolate => return transformExpStringInterpolate(ctx, o)
        case o: Exp.This => return transformExpThis(ctx, o)
        case o: Exp.Unary => return transformExpUnary(ctx, o)
        case o: Exp.Binary => return transformExpBinary(ctx, o)
        case o: Exp.Ident => return transformExpIdent(ctx, o)
        case o: Exp.Eta => return transformExpEta(ctx, o)
        case o: Exp.Tuple => return transformExpTuple(ctx, o)
        case o: Exp.Select => return transformExpSelect(ctx, o)
        case o: Exp.Invoke => return transformExpInvoke(ctx, o)
        case o: Exp.InvokeNamed => return transformExpInvokeNamed(ctx, o)
        case o: Exp.If => return transformExpIf(ctx, o)
        case o: Exp.Quant => return transformExpQuant(ctx, o)
      }
    }

    @pure def transformExpLitB(ctx: Context, o: Exp.LitB): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitC(ctx: Context, o: Exp.LitC): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitZ(ctx: Context, o: Exp.LitZ): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitZ8(ctx: Context, o: Exp.LitZ8): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitZ16(ctx: Context, o: Exp.LitZ16): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitZ32(ctx: Context, o: Exp.LitZ32): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitZ64(ctx: Context, o: Exp.LitZ64): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitN(ctx: Context, o: Exp.LitN): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitN8(ctx: Context, o: Exp.LitN8): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitN16(ctx: Context, o: Exp.LitN16): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitN32(ctx: Context, o: Exp.LitN32): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitN64(ctx: Context, o: Exp.LitN64): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitS8(ctx: Context, o: Exp.LitS8): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitS16(ctx: Context, o: Exp.LitS16): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitS32(ctx: Context, o: Exp.LitS32): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitS64(ctx: Context, o: Exp.LitS64): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitU8(ctx: Context, o: Exp.LitU8): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitU16(ctx: Context, o: Exp.LitU16): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitU32(ctx: Context, o: Exp.LitU32): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitU64(ctx: Context, o: Exp.LitU64): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitF32(ctx: Context, o: Exp.LitF32): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitF64(ctx: Context, o: Exp.LitF64): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitR(ctx: Context, o: Exp.LitR): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitBv(ctx: Context, o: Exp.LitBv): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpLitString(ctx: Context, o: Exp.LitString): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpStringInterpolate(ctx: Context, o: Exp.StringInterpolate): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpThis(ctx: Context, o: Exp.This): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpUnary(ctx: Context, o: Exp.Unary): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpBinary(ctx: Context, o: Exp.Binary): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpIdent(ctx: Context, o: Exp.Ident): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpEta(ctx: Context, o: Exp.Eta): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpTuple(ctx: Context, o: Exp.Tuple): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpSelect(ctx: Context, o: Exp.Select): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpInvoke(ctx: Context, o: Exp.Invoke): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpInvokeNamed(ctx: Context, o: Exp.InvokeNamed): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpIf(ctx: Context, o: Exp.If): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformExpQuant(ctx: Context, o: Exp.Quant): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def transformNamedArg(ctx: Context, o: NamedArg): Result[Context, NamedArg] = {
      return Result(ctx, None())
    }

    @pure def transformVarFragment(ctx: Context, o: VarFragment): Result[Context, VarFragment] = {
      return Result(ctx, None())
    }

    @pure def transformDomain(ctx: Context, o: Domain): Result[Context, Domain] = {
      o match {
        case o: Domain.Type => return transformDomainType(ctx, o)
        case o: Domain.Range => return transformDomainRange(ctx, o)
      }
    }

    @pure def transformDomainType(ctx: Context, o: Domain.Type): Result[Context, Domain] = {
      return Result(ctx, None())
    }

    @pure def transformDomainRange(ctx: Context, o: Domain.Range): Result[Context, Domain] = {
      return Result(ctx, None())
    }

    @pure def transformId(ctx: Context, o: Id): Result[Context, Id] = {
      return Result(ctx, None())
    }

    @pure def transformName(ctx: Context, o: Name): Result[Context, Name] = {
      return Result(ctx, None())
    }

    @pure def transformBody(ctx: Context, o: Body): Result[Context, Body] = {
      return Result(ctx, None())
    }

    @pure def transformAbstractDatatypeParam(ctx: Context, o: AbstractDatatypeParam): Result[Context, AbstractDatatypeParam] = {
      return Result(ctx, None())
    }

    @pure def transformMethodSig(ctx: Context, o: MethodSig): Result[Context, MethodSig] = {
      return Result(ctx, None())
    }

    @pure def transformParam(ctx: Context, o: Param): Result[Context, Param] = {
      return Result(ctx, None())
    }

    @pure def transformTypeParam(ctx: Context, o: TypeParam): Result[Context, TypeParam] = {
      return Result(ctx, None())
    }

    @pure def transformContract(ctx: Context, o: Contract): Result[Context, Contract] = {
      return Result(ctx, None())
    }

    @pure def transformSubContract(ctx: Context, o: SubContract): Result[Context, SubContract] = {
      return Result(ctx, None())
    }

    @pure def transformSubContractParam(ctx: Context, o: SubContractParam): Result[Context, SubContractParam] = {
      return Result(ctx, None())
    }

    @pure def transformWhereDef(ctx: Context, o: WhereDef): Result[Context, WhereDef] = {
      o match {
        case o: WhereDef.Val => return transformWhereDefVal(ctx, o)
        case o: WhereDef.Def => return transformWhereDefDef(ctx, o)
      }
    }

    @pure def transformWhereDefVal(ctx: Context, o: WhereDef.Val): Result[Context, WhereDef] = {
      return Result(ctx, None())
    }

    @pure def transformWhereDefDef(ctx: Context, o: WhereDef.Def): Result[Context, WhereDef] = {
      return Result(ctx, None())
    }

    @pure def transformSpecDef(ctx: Context, o: SpecDef): Result[Context, SpecDef] = {
      return Result(ctx, None())
    }

    @pure def transformProofStep(ctx: Context, o: ProofStep): Result[Context, ProofStep] = {
      o match {
        case o: ProofStep.Basic => return transformProofStepBasic(ctx, o)
        case o: ProofStep.SubProof => return transformProofStepSubProof(ctx, o)
      }
    }

    @pure def transformProofStepBasic(ctx: Context, o: ProofStep.Basic): Result[Context, ProofStep] = {
      return Result(ctx, None())
    }

    @pure def transformProofStepSubProof(ctx: Context, o: ProofStep.SubProof): Result[Context, ProofStep] = {
      return Result(ctx, None())
    }

    @pure def transformAssumeProofStep(ctx: Context, o: AssumeProofStep): Result[Context, AssumeProofStep] = {
      o match {
        case o: AssumeProofStep.Regular => return transformAssumeProofStepRegular(ctx, o)
        case o: AssumeProofStep.ForallIntroAps => return transformAssumeProofStepForallIntroAps(ctx, o)
        case o: AssumeProofStep.ExistsElimAps => return transformAssumeProofStepExistsElimAps(ctx, o)
      }
    }

    @pure def transformAssumeProofStepRegular(ctx: Context, o: AssumeProofStep.Regular): Result[Context, AssumeProofStep] = {
      return Result(ctx, None())
    }

    @pure def transformAssumeProofStepForallIntroAps(ctx: Context, o: AssumeProofStep.ForallIntroAps): Result[Context, AssumeProofStep] = {
      return Result(ctx, None())
    }

    @pure def transformAssumeProofStepExistsElimAps(ctx: Context, o: AssumeProofStep.ExistsElimAps): Result[Context, AssumeProofStep] = {
      return Result(ctx, None())
    }

    @pure def transformJust(ctx: Context, o: Just): Result[Context, Just] = {
      o match {
        case o: Just.Premise => return transformJustPremise(ctx, o)
        case o: Just.AndIntro => return transformJustAndIntro(ctx, o)
        case o: Just.AndElim => return transformJustAndElim(ctx, o)
        case o: Just.OrIntro => return transformJustOrIntro(ctx, o)
        case o: Just.OrElim => return transformJustOrElim(ctx, o)
        case o: Just.ImplyIntro => return transformJustImplyIntro(ctx, o)
        case o: Just.ImplyElim => return transformJustImplyElim(ctx, o)
        case o: Just.NegIntro => return transformJustNegIntro(ctx, o)
        case o: Just.NegElim => return transformJustNegElim(ctx, o)
        case o: Just.BottomElim => return transformJustBottomElim(ctx, o)
        case o: Just.Pbc => return transformJustPbc(ctx, o)
        case o: Just.ForallIntro => return transformJustForallIntro(ctx, o)
        case o: Just.ForallElim => return transformJustForallElim(ctx, o)
        case o: Just.ExistsIntro => return transformJustExistsIntro(ctx, o)
        case o: Just.ExistsElim => return transformJustExistsElim(ctx, o)
        case o: Just.Fact => return transformJustFact(ctx, o)
        case o: Just.Invariant => return transformJustInvariant(ctx, o)
        case o: Just.Subst => return transformJustSubst(ctx, o)
        case o: Just.Auto => return transformJustAuto(ctx, o)
        case o: Just.Coq => return transformJustCoq(ctx, o)
      }
    }

    @pure def transformJustPremise(ctx: Context, o: Just.Premise): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformJustAndIntro(ctx: Context, o: Just.AndIntro): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformJustAndElim(ctx: Context, o: Just.AndElim): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformJustOrIntro(ctx: Context, o: Just.OrIntro): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformJustOrElim(ctx: Context, o: Just.OrElim): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformJustImplyIntro(ctx: Context, o: Just.ImplyIntro): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformJustImplyElim(ctx: Context, o: Just.ImplyElim): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformJustNegIntro(ctx: Context, o: Just.NegIntro): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformJustNegElim(ctx: Context, o: Just.NegElim): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformJustBottomElim(ctx: Context, o: Just.BottomElim): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformJustPbc(ctx: Context, o: Just.Pbc): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformJustForallIntro(ctx: Context, o: Just.ForallIntro): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformJustForallElim(ctx: Context, o: Just.ForallElim): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformJustExistsIntro(ctx: Context, o: Just.ExistsIntro): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformJustExistsElim(ctx: Context, o: Just.ExistsElim): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformJustFact(ctx: Context, o: Just.Fact): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformJustInvariant(ctx: Context, o: Just.Invariant): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformJustSubst(ctx: Context, o: Just.Subst): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformJustAuto(ctx: Context, o: Just.Auto): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformJustCoq(ctx: Context, o: Just.Coq): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def transformTruthTableRow(ctx: Context, o: TruthTable.Row): Result[Context, TruthTable.Row] = {
      return Result(ctx, None())
    }

    @pure def transformTruthTableConclusion(ctx: Context, o: TruthTable.Conclusion): Result[Context, TruthTable.Conclusion] = {
      o match {
        case o: TruthTable.Conclusion.Validity => return transformTruthTableConclusionValidity(ctx, o)
        case o: TruthTable.Conclusion.Tautology => return transformTruthTableConclusionTautology(ctx, o)
        case o: TruthTable.Conclusion.Contradictory => return transformTruthTableConclusionContradictory(ctx, o)
        case o: TruthTable.Conclusion.Contingent => return transformTruthTableConclusionContingent(ctx, o)
      }
    }

    @pure def transformTruthTableConclusionValidity(ctx: Context, o: TruthTable.Conclusion.Validity): Result[Context, TruthTable.Conclusion] = {
      return Result(ctx, None())
    }

    @pure def transformTruthTableConclusionTautology(ctx: Context, o: TruthTable.Conclusion.Tautology): Result[Context, TruthTable.Conclusion] = {
      return Result(ctx, None())
    }

    @pure def transformTruthTableConclusionContradictory(ctx: Context, o: TruthTable.Conclusion.Contradictory): Result[Context, TruthTable.Conclusion] = {
      return Result(ctx, None())
    }

    @pure def transformTruthTableConclusionContingent(ctx: Context, o: TruthTable.Conclusion.Contingent): Result[Context, TruthTable.Conclusion] = {
      return Result(ctx, None())
    }

    @pure def transformAttr(ctx: Context, o: Attr): Result[Context, Attr] = {
      return Result(ctx, None())
    }

    @pure def transformTypedAttr(ctx: Context, o: TypedAttr): Result[Context, TypedAttr] = {
      return Result(ctx, None())
    }

    @pure def transformResolvedAttr(ctx: Context, o: ResolvedAttr): Result[Context, ResolvedAttr] = {
      return Result(ctx, None())
    }

    @pure def transformResolvedInfo(ctx: Context, o: ResolvedInfo): Result[Context, ResolvedInfo] = {
      return Result(ctx, None())
    }

    @pure def transformPosInfo(ctx: Context, o: PosInfo): Result[Context, PosInfo] = {
      return Result(ctx, None())
    }

  }

  @pure def transformISZ[Context, T](ctx: Context, s: IS[Z, T], f: (Context, T) => Result[Context, T]): Result[Context, IS[Z, T]] = {
    val s2: MS[Z, T] = SI.toMS(s)
    var changed: B = F
    var ctxi = ctx
    for (i <- s2.indices) {
      val e: T = s(i)
      val r: Result[Context, T] = f(ctxi, e)
      ctxi = r.ctx
      changed = changed | r.resultOpt.nonEmpty
      s2(i) = r.resultOpt.getOrElse(e)
    }
    if (changed) {
      return Result(ctxi, Some(SM.toIS(s2)))
    } else {
      return Result(ctxi, None())
    }
  }

  @pure def transformOption[Context, T](ctx: Context, option: Option[T], @pure f: (Context, T) => Result[Context, T]): Result[Context, Option[T]] = {
    option match {
      case Some(v) =>
        val r = f(ctx, v)
        r.resultOpt match {
          case Some(_) => return Result(r.ctx, Some(r.resultOpt))
          case _ => return Result(r.ctx, None())
        }
      case _ => return Result(ctx, None())
    }
  }

}

import Transformer._

@record class Transformer[Context](pre: Pre[Context], post: Post[Context]) {

  @pure def transformTopUnit(ctx: Context, o: TopUnit): Result[Context, TopUnit] = {
    val preR: PreResult[Context, TopUnit] = pre.transformTopUnit(ctx, o)
    val r: Result[Context, TopUnit] = if (preR.continue) {
      val o2: TopUnit = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, TopUnit] = o2 match {
        case o2: TopUnit.Program =>
          val r0: Result[Context, Name] = transformName(ctx, o2.packageName)
          val r1: Result[Context, Body] = transformBody(r0.ctx, o2.body)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(packageName = r0.resultOpt.getOrElse(o2.packageName), body = r1.resultOpt.getOrElse(o2.body))))
          else
            Result(r1.ctx, None())
        case o2: TopUnit.SequentUnit =>
          val r0: Result[Context, LClause.Sequent] = transformLClauseSequent(ctx, o2.sequent)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(sequent = r0.resultOpt.getOrElse(o2.sequent))))
          else
            Result(r0.ctx, None())
        case o2: TopUnit.TruthTableUnit =>
          val r0: Result[Context, IS[Z, Id]] = transformISZ(ctx, o2.vars, transformId _)
          val r1: Result[Context, LClause.Sequent] = transformLClauseSequent(r0.ctx, o2.sequent)
          val r2: Result[Context, IS[Z, TruthTable.Row]] = transformISZ(r1.ctx, o2.rows, transformTruthTableRow _)
          val r3: Result[Context, Option[TruthTable.Conclusion]] = transformOption(r2.ctx, o2.conclusionOpt, transformTruthTableConclusion _)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty| r3.resultOpt.nonEmpty)
            Result(r3.ctx, Some(o2(vars = r0.resultOpt.getOrElse(o2.vars), sequent = r1.resultOpt.getOrElse(o2.sequent), rows = r2.resultOpt.getOrElse(o2.rows), conclusionOpt = r3.resultOpt.getOrElse(o2.conclusionOpt))))
          else
            Result(r3.ctx, None())
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: TopUnit = r.resultOpt.getOrElse(o)
    val postR: Result[Context, TopUnit] = post.transformTopUnit(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformLClauseSequent(ctx: Context, o: LClause.Sequent): Result[Context, LClause.Sequent] = {
    val preR: PreResult[Context, LClause.Sequent] = pre.transformLClauseSequent(ctx, o) match {
      case PreResult(preCtx, continue, Some(r: LClause.Sequent)) => PreResult(preCtx, continue, Some[LClause.Sequent](r))
      case PreResult(preCtx, continue, _) => assert(F); PreResult(preCtx, F, None[LClause.Sequent]())
    }
    val r: Result[Context, LClause.Sequent] = if (preR.continue) {
      val o2: LClause.Sequent = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, IS[Z, Exp]] = transformISZ(ctx, o2.premises, transformExp _)
      val r1: Result[Context, IS[Z, Exp]] = transformISZ(r0.ctx, o2.conclusions, transformExp _)
      val r2: Result[Context, Option[LClause.Proof]] = transformOption(r1.ctx, o2.proofOpt, transformLClauseProof _)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
        Result(r2.ctx, Some(o2(premises = r0.resultOpt.getOrElse(o2.premises), conclusions = r1.resultOpt.getOrElse(o2.conclusions), proofOpt = r2.resultOpt.getOrElse(o2.proofOpt))))
      else
        Result(r2.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: LClause.Sequent = r.resultOpt.getOrElse(o)
    val postR: Result[Context, LClause.Sequent] = post.transformLClauseSequent(r.ctx, o2) match {
      case Result(postCtx, Some(result: LClause.Sequent)) => Result(postCtx, Some[LClause.Sequent](result))
      case Result(postCtx, _) => assert(F); Result(postCtx, None[LClause.Sequent]())
    }
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformLClauseProof(ctx: Context, o: LClause.Proof): Result[Context, LClause.Proof] = {
    val preR: PreResult[Context, LClause.Proof] = pre.transformLClauseProof(ctx, o) match {
      case PreResult(preCtx, continue, Some(r: LClause.Proof)) => PreResult(preCtx, continue, Some[LClause.Proof](r))
      case PreResult(preCtx, continue, _) => assert(F); PreResult(preCtx, F, None[LClause.Proof]())
    }
    val r: Result[Context, LClause.Proof] = if (preR.continue) {
      val o2: LClause.Proof = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, IS[Z, ProofStep]] = transformISZ(ctx, o2.steps, transformProofStep _)
      if (hasChanged | r0.resultOpt.nonEmpty)
        Result(r0.ctx, Some(o2(steps = r0.resultOpt.getOrElse(o2.steps))))
      else
        Result(r0.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: LClause.Proof = r.resultOpt.getOrElse(o)
    val postR: Result[Context, LClause.Proof] = post.transformLClauseProof(r.ctx, o2) match {
      case Result(postCtx, Some(result: LClause.Proof)) => Result(postCtx, Some[LClause.Proof](result))
      case Result(postCtx, _) => assert(F); Result(postCtx, None[LClause.Proof]())
    }
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformStmt(ctx: Context, o: Stmt): Result[Context, Stmt] = {
    val preR: PreResult[Context, Stmt] = pre.transformStmt(ctx, o)
    val r: Result[Context, Stmt] = if (preR.continue) {
      val o2: Stmt = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, Stmt] = o2 match {
        case o2: Stmt.Import =>
          val r0: Result[Context, IS[Z, Stmt.Import.Importer]] = transformISZ(ctx, o2.importers, transformStmtImportImporter _)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(importers = r0.resultOpt.getOrElse(o2.importers), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Stmt.Var =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, Option[Type]] = transformOption(r0.ctx, o2.tipeOpt, transformType _)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), tipeOpt = r1.resultOpt.getOrElse(o2.tipeOpt), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Stmt.VarPattern =>
          val r0: Result[Context, Pattern] = transformPattern(ctx, o2.pattern)
          val r1: Result[Context, Option[Type]] = transformOption(r0.ctx, o2.tipeOpt, transformType _)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(pattern = r0.resultOpt.getOrElse(o2.pattern), tipeOpt = r1.resultOpt.getOrElse(o2.tipeOpt), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Stmt.SpecVar =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, Type] = transformType(r0.ctx, o2.tipe)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), tipe = r1.resultOpt.getOrElse(o2.tipe), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Stmt.Method =>
          val r0: Result[Context, MethodSig] = transformMethodSig(ctx, o2.sig)
          val r1: Result[Context, Contract] = transformContract(r0.ctx, o2.contract)
          val r2: Result[Context, Option[Body]] = transformOption(r1.ctx, o2.bodyOpt, transformBody _)
          val r3: Result[Context, Attr] = transformAttr(r2.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty| r3.resultOpt.nonEmpty)
            Result(r3.ctx, Some(o2(sig = r0.resultOpt.getOrElse(o2.sig), contract = r1.resultOpt.getOrElse(o2.contract), bodyOpt = r2.resultOpt.getOrElse(o2.bodyOpt), attr = r3.resultOpt.getOrElse(o2.attr))))
          else
            Result(r3.ctx, None())
        case o2: Stmt.ExtMethod =>
          val r0: Result[Context, MethodSig] = transformMethodSig(ctx, o2.sig)
          val r1: Result[Context, Contract] = transformContract(r0.ctx, o2.contract)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(sig = r0.resultOpt.getOrElse(o2.sig), contract = r1.resultOpt.getOrElse(o2.contract), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Stmt.SpecMethod =>
          val r0: Result[Context, MethodSig] = transformMethodSig(ctx, o2.sig)
          val r1: Result[Context, IS[Z, SpecDef]] = transformISZ(r0.ctx, o2.defs, transformSpecDef _)
          val r2: Result[Context, IS[Z, WhereDef]] = transformISZ(r1.ctx, o2.where, transformWhereDef _)
          val r3: Result[Context, Attr] = transformAttr(r2.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty| r3.resultOpt.nonEmpty)
            Result(r3.ctx, Some(o2(sig = r0.resultOpt.getOrElse(o2.sig), defs = r1.resultOpt.getOrElse(o2.defs), where = r2.resultOpt.getOrElse(o2.where), attr = r3.resultOpt.getOrElse(o2.attr))))
          else
            Result(r3.ctx, None())
        case o2: Stmt.Enum =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, IS[Z, Id]] = transformISZ(r0.ctx, o2.elements, transformId _)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), elements = r1.resultOpt.getOrElse(o2.elements), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Stmt.Object =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, IS[Z, Type]] = transformISZ(r0.ctx, o2.parents, transformType _)
          val r2: Result[Context, IS[Z, Stmt]] = transformISZ(r1.ctx, o2.stmts, transformStmt _)
          val r3: Result[Context, Attr] = transformAttr(r2.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty| r3.resultOpt.nonEmpty)
            Result(r3.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), parents = r1.resultOpt.getOrElse(o2.parents), stmts = r2.resultOpt.getOrElse(o2.stmts), attr = r3.resultOpt.getOrElse(o2.attr))))
          else
            Result(r3.ctx, None())
        case o2: Stmt.Sig =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, IS[Z, TypeParam]] = transformISZ(r0.ctx, o2.typeParams, transformTypeParam _)
          val r2: Result[Context, IS[Z, Type.Named]] = transformISZ(r1.ctx, o2.parents, transformTypeNamed _)
          val r3: Result[Context, Option[Type]] = transformOption(r2.ctx, o2.selfTypeOpt, transformType _)
          val r4: Result[Context, IS[Z, Stmt]] = transformISZ(r3.ctx, o2.stmts, transformStmt _)
          val r5: Result[Context, Attr] = transformAttr(r4.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty| r3.resultOpt.nonEmpty| r4.resultOpt.nonEmpty| r5.resultOpt.nonEmpty)
            Result(r5.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), typeParams = r1.resultOpt.getOrElse(o2.typeParams), parents = r2.resultOpt.getOrElse(o2.parents), selfTypeOpt = r3.resultOpt.getOrElse(o2.selfTypeOpt), stmts = r4.resultOpt.getOrElse(o2.stmts), attr = r5.resultOpt.getOrElse(o2.attr))))
          else
            Result(r5.ctx, None())
        case o2: Stmt.AbstractDatatype =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, IS[Z, TypeParam]] = transformISZ(r0.ctx, o2.typeParams, transformTypeParam _)
          val r2: Result[Context, IS[Z, AbstractDatatypeParam]] = transformISZ(r1.ctx, o2.params, transformAbstractDatatypeParam _)
          val r3: Result[Context, IS[Z, Type.Named]] = transformISZ(r2.ctx, o2.parents, transformTypeNamed _)
          val r4: Result[Context, IS[Z, Stmt]] = transformISZ(r3.ctx, o2.stmts, transformStmt _)
          val r5: Result[Context, Attr] = transformAttr(r4.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty| r3.resultOpt.nonEmpty| r4.resultOpt.nonEmpty| r5.resultOpt.nonEmpty)
            Result(r5.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), typeParams = r1.resultOpt.getOrElse(o2.typeParams), params = r2.resultOpt.getOrElse(o2.params), parents = r3.resultOpt.getOrElse(o2.parents), stmts = r4.resultOpt.getOrElse(o2.stmts), attr = r5.resultOpt.getOrElse(o2.attr))))
          else
            Result(r5.ctx, None())
        case o2: Stmt.Rich =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, IS[Z, TypeParam]] = transformISZ(r0.ctx, o2.typeParams, transformTypeParam _)
          val r2: Result[Context, IS[Z, Param]] = transformISZ(r1.ctx, o2.params, transformParam _)
          val r3: Result[Context, IS[Z, Type.Named]] = transformISZ(r2.ctx, o2.parents, transformTypeNamed _)
          val r4: Result[Context, IS[Z, Stmt]] = transformISZ(r3.ctx, o2.stmts, transformStmt _)
          val r5: Result[Context, Attr] = transformAttr(r4.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty| r3.resultOpt.nonEmpty| r4.resultOpt.nonEmpty| r5.resultOpt.nonEmpty)
            Result(r5.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), typeParams = r1.resultOpt.getOrElse(o2.typeParams), params = r2.resultOpt.getOrElse(o2.params), parents = r3.resultOpt.getOrElse(o2.parents), stmts = r4.resultOpt.getOrElse(o2.stmts), attr = r5.resultOpt.getOrElse(o2.attr))))
          else
            Result(r5.ctx, None())
        case o2: Stmt.TypeAlias =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, IS[Z, TypeParam]] = transformISZ(r0.ctx, o2.typeParams, transformTypeParam _)
          val r2: Result[Context, Type] = transformType(r1.ctx, o2.tipe)
          val r3: Result[Context, Attr] = transformAttr(r2.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty| r3.resultOpt.nonEmpty)
            Result(r3.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), typeParams = r1.resultOpt.getOrElse(o2.typeParams), tipe = r2.resultOpt.getOrElse(o2.tipe), attr = r3.resultOpt.getOrElse(o2.attr))))
          else
            Result(r3.ctx, None())
        case o2: Stmt.Assign =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.lhs)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(lhs = r0.resultOpt.getOrElse(o2.lhs), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Stmt.AssignUp =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.lhs)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(lhs = r0.resultOpt.getOrElse(o2.lhs), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Stmt.AssignPattern =>
          val r0: Result[Context, Pattern] = transformPattern(ctx, o2.lhs)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(lhs = r0.resultOpt.getOrElse(o2.lhs), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Stmt.Block =>
          val r0: Result[Context, Body] = transformBody(ctx, o2.body)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(body = r0.resultOpt.getOrElse(o2.body), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Stmt.If =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.cond)
          val r1: Result[Context, Body] = transformBody(r0.ctx, o2.thenbody)
          val r2: Result[Context, Body] = transformBody(r1.ctx, o2.elsebody)
          val r3: Result[Context, Attr] = transformAttr(r2.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty| r3.resultOpt.nonEmpty)
            Result(r3.ctx, Some(o2(cond = r0.resultOpt.getOrElse(o2.cond), thenbody = r1.resultOpt.getOrElse(o2.thenbody), elsebody = r2.resultOpt.getOrElse(o2.elsebody), attr = r3.resultOpt.getOrElse(o2.attr))))
          else
            Result(r3.ctx, None())
        case o2: Stmt.Match =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.cond)
          val r1: Result[Context, IS[Z, Case]] = transformISZ(r0.ctx, o2.cases, transformCase _)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(cond = r0.resultOpt.getOrElse(o2.cond), cases = r1.resultOpt.getOrElse(o2.cases), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Stmt.While =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.cond)
          val r1: Result[Context, IS[Z, ContractExp]] = transformISZ(r0.ctx, o2.invariants, transformContractExp _)
          val r2: Result[Context, IS[Z, Exp]] = transformISZ(r1.ctx, o2.modifies, transformExp _)
          val r3: Result[Context, Body] = transformBody(r2.ctx, o2.body)
          val r4: Result[Context, Attr] = transformAttr(r3.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty| r3.resultOpt.nonEmpty| r4.resultOpt.nonEmpty)
            Result(r4.ctx, Some(o2(cond = r0.resultOpt.getOrElse(o2.cond), invariants = r1.resultOpt.getOrElse(o2.invariants), modifies = r2.resultOpt.getOrElse(o2.modifies), body = r3.resultOpt.getOrElse(o2.body), attr = r4.resultOpt.getOrElse(o2.attr))))
          else
            Result(r4.ctx, None())
        case o2: Stmt.DoWhile =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.cond)
          val r1: Result[Context, IS[Z, ContractExp]] = transformISZ(r0.ctx, o2.invariants, transformContractExp _)
          val r2: Result[Context, IS[Z, Exp]] = transformISZ(r1.ctx, o2.modifies, transformExp _)
          val r3: Result[Context, Body] = transformBody(r2.ctx, o2.body)
          val r4: Result[Context, Attr] = transformAttr(r3.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty| r3.resultOpt.nonEmpty| r4.resultOpt.nonEmpty)
            Result(r4.ctx, Some(o2(cond = r0.resultOpt.getOrElse(o2.cond), invariants = r1.resultOpt.getOrElse(o2.invariants), modifies = r2.resultOpt.getOrElse(o2.modifies), body = r3.resultOpt.getOrElse(o2.body), attr = r4.resultOpt.getOrElse(o2.attr))))
          else
            Result(r4.ctx, None())
        case o2: Stmt.For =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, Range] = transformRange(r0.ctx, o2.range)
          val r2: Result[Context, Option[Exp]] = transformOption(r1.ctx, o2.condOpt, transformExp _)
          val r3: Result[Context, IS[Z, ContractExp]] = transformISZ(r2.ctx, o2.invariants, transformContractExp _)
          val r4: Result[Context, IS[Z, Exp]] = transformISZ(r3.ctx, o2.modifies, transformExp _)
          val r5: Result[Context, Body] = transformBody(r4.ctx, o2.body)
          val r6: Result[Context, Attr] = transformAttr(r5.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty| r3.resultOpt.nonEmpty| r4.resultOpt.nonEmpty| r5.resultOpt.nonEmpty| r6.resultOpt.nonEmpty)
            Result(r6.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), range = r1.resultOpt.getOrElse(o2.range), condOpt = r2.resultOpt.getOrElse(o2.condOpt), invariants = r3.resultOpt.getOrElse(o2.invariants), modifies = r4.resultOpt.getOrElse(o2.modifies), body = r5.resultOpt.getOrElse(o2.body), attr = r6.resultOpt.getOrElse(o2.attr))))
          else
            Result(r6.ctx, None())
        case o2: Stmt.Return =>
          val r0: Result[Context, Option[Exp]] = transformOption(ctx, o2.expOpt, transformExp _)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(expOpt = r0.resultOpt.getOrElse(o2.expOpt), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Stmt.LStmt =>
          val r0: Result[Context, LClause] = transformLClause(ctx, o2.clause)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(clause = r0.resultOpt.getOrElse(o2.clause), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Stmt.Expr =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.exp)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(exp = r0.resultOpt.getOrElse(o2.exp), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Stmt = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Stmt] = post.transformStmt(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformTypeNamed(ctx: Context, o: Type.Named): Result[Context, Type.Named] = {
    val preR: PreResult[Context, Type.Named] = pre.transformTypeNamed(ctx, o) match {
      case PreResult(preCtx, continue, Some(r: Type.Named)) => PreResult(preCtx, continue, Some[Type.Named](r))
      case PreResult(preCtx, continue, _) => assert(F); PreResult(preCtx, F, None[Type.Named]())
    }
    val r: Result[Context, Type.Named] = if (preR.continue) {
      val o2: Type.Named = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Name] = transformName(ctx, o2.name)
      val r1: Result[Context, IS[Z, Type]] = transformISZ(r0.ctx, o2.typeArgs, transformType _)
      val r2: Result[Context, TypedAttr] = transformTypedAttr(r1.ctx, o2.attr)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
        Result(r2.ctx, Some(o2(name = r0.resultOpt.getOrElse(o2.name), typeArgs = r1.resultOpt.getOrElse(o2.typeArgs), attr = r2.resultOpt.getOrElse(o2.attr))))
      else
        Result(r2.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Type.Named = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Type.Named] = post.transformTypeNamed(r.ctx, o2) match {
      case Result(postCtx, Some(result: Type.Named)) => Result(postCtx, Some[Type.Named](result))
      case Result(postCtx, _) => assert(F); Result(postCtx, None[Type.Named]())
    }
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformStmtImportImporter(ctx: Context, o: Stmt.Import.Importer): Result[Context, Stmt.Import.Importer] = {
    val preR: PreResult[Context, Stmt.Import.Importer] = pre.transformStmtImportImporter(ctx, o)
    val r: Result[Context, Stmt.Import.Importer] = if (preR.continue) {
      val o2: Stmt.Import.Importer = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Name] = transformName(ctx, o2.name)
      val r1: Result[Context, Option[Stmt.Import.Selector]] = transformOption(r0.ctx, o2.selector, transformStmtImportSelector _)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
        Result(r1.ctx, Some(o2(name = r0.resultOpt.getOrElse(o2.name), selector = r1.resultOpt.getOrElse(o2.selector))))
      else
        Result(r1.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Stmt.Import.Importer = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Stmt.Import.Importer] = post.transformStmtImportImporter(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformStmtImportSelector(ctx: Context, o: Stmt.Import.Selector): Result[Context, Stmt.Import.Selector] = {
    val preR: PreResult[Context, Stmt.Import.Selector] = pre.transformStmtImportSelector(ctx, o)
    val r: Result[Context, Stmt.Import.Selector] = if (preR.continue) {
      val o2: Stmt.Import.Selector = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, Stmt.Import.Selector] = o2 match {
        case o2: Stmt.Import.MultiSelector =>
          val r0: Result[Context, IS[Z, Stmt.Import.NamedSelector]] = transformISZ(ctx, o2.selectors, transformStmtImportNamedSelector _)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(selectors = r0.resultOpt.getOrElse(o2.selectors))))
          else
            Result(r0.ctx, None())
        case o2: Stmt.Import.WildcardSelector =>
          if (hasChanged)
            Result(ctx, Some(o2))
          else
            Result(ctx, None())
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Stmt.Import.Selector = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Stmt.Import.Selector] = post.transformStmtImportSelector(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformStmtImportNamedSelector(ctx: Context, o: Stmt.Import.NamedSelector): Result[Context, Stmt.Import.NamedSelector] = {
    val preR: PreResult[Context, Stmt.Import.NamedSelector] = pre.transformStmtImportNamedSelector(ctx, o)
    val r: Result[Context, Stmt.Import.NamedSelector] = if (preR.continue) {
      val o2: Stmt.Import.NamedSelector = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.from)
      val r1: Result[Context, Id] = transformId(r0.ctx, o2.to)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
        Result(r1.ctx, Some(o2(from = r0.resultOpt.getOrElse(o2.from), to = r1.resultOpt.getOrElse(o2.to))))
      else
        Result(r1.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Stmt.Import.NamedSelector = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Stmt.Import.NamedSelector] = post.transformStmtImportNamedSelector(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformLClause(ctx: Context, o: LClause): Result[Context, LClause] = {
    val preR: PreResult[Context, LClause] = pre.transformLClause(ctx, o)
    val r: Result[Context, LClause] = if (preR.continue) {
      val o2: LClause = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, LClause] = o2 match {
        case o2: LClause.Invariants =>
          val r0: Result[Context, IS[Z, ContractExp]] = transformISZ(ctx, o2.value, transformContractExp _)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(value = r0.resultOpt.getOrElse(o2.value))))
          else
            Result(r0.ctx, None())
        case o2: LClause.Facts =>
          val r0: Result[Context, IS[Z, LClause.Fact]] = transformISZ(ctx, o2.value, transformLClauseFact _)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(value = r0.resultOpt.getOrElse(o2.value))))
          else
            Result(r0.ctx, None())
        case o2: LClause.Theorems =>
          val r0: Result[Context, IS[Z, LClause.Theorem]] = transformISZ(ctx, o2.value, transformLClauseTheorem _)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(value = r0.resultOpt.getOrElse(o2.value))))
          else
            Result(r0.ctx, None())
        case o2: LClause.Sequent =>
          val r0: Result[Context, IS[Z, Exp]] = transformISZ(ctx, o2.premises, transformExp _)
          val r1: Result[Context, IS[Z, Exp]] = transformISZ(r0.ctx, o2.conclusions, transformExp _)
          val r2: Result[Context, Option[LClause.Proof]] = transformOption(r1.ctx, o2.proofOpt, transformLClauseProof _)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(premises = r0.resultOpt.getOrElse(o2.premises), conclusions = r1.resultOpt.getOrElse(o2.conclusions), proofOpt = r2.resultOpt.getOrElse(o2.proofOpt))))
          else
            Result(r2.ctx, None())
        case o2: LClause.Proof =>
          val r0: Result[Context, IS[Z, ProofStep]] = transformISZ(ctx, o2.steps, transformProofStep _)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(steps = r0.resultOpt.getOrElse(o2.steps))))
          else
            Result(r0.ctx, None())
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: LClause = r.resultOpt.getOrElse(o)
    val postR: Result[Context, LClause] = post.transformLClause(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformLClauseFact(ctx: Context, o: LClause.Fact): Result[Context, LClause.Fact] = {
    val preR: PreResult[Context, LClause.Fact] = pre.transformLClauseFact(ctx, o)
    val r: Result[Context, LClause.Fact] = if (preR.continue) {
      val o2: LClause.Fact = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.id)
      val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.exp)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
        Result(r1.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), exp = r1.resultOpt.getOrElse(o2.exp))))
      else
        Result(r1.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: LClause.Fact = r.resultOpt.getOrElse(o)
    val postR: Result[Context, LClause.Fact] = post.transformLClauseFact(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformLClauseTheorem(ctx: Context, o: LClause.Theorem): Result[Context, LClause.Theorem] = {
    val preR: PreResult[Context, LClause.Theorem] = pre.transformLClauseTheorem(ctx, o)
    val r: Result[Context, LClause.Theorem] = if (preR.continue) {
      val o2: LClause.Theorem = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.id)
      val r1: Result[Context, LClause.Sequent] = transformLClauseSequent(r0.ctx, o2.sequent)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
        Result(r1.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), sequent = r1.resultOpt.getOrElse(o2.sequent))))
      else
        Result(r1.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: LClause.Theorem = r.resultOpt.getOrElse(o)
    val postR: Result[Context, LClause.Theorem] = post.transformLClauseTheorem(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformContractExp(ctx: Context, o: ContractExp): Result[Context, ContractExp] = {
    val preR: PreResult[Context, ContractExp] = pre.transformContractExp(ctx, o)
    val r: Result[Context, ContractExp] = if (preR.continue) {
      val o2: ContractExp = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Option[Id]] = transformOption(ctx, o2.idOpt, transformId _)
      val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.exp)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
        Result(r1.ctx, Some(o2(idOpt = r0.resultOpt.getOrElse(o2.idOpt), exp = r1.resultOpt.getOrElse(o2.exp))))
      else
        Result(r1.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: ContractExp = r.resultOpt.getOrElse(o)
    val postR: Result[Context, ContractExp] = post.transformContractExp(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformCase(ctx: Context, o: Case): Result[Context, Case] = {
    val preR: PreResult[Context, Case] = pre.transformCase(ctx, o)
    val r: Result[Context, Case] = if (preR.continue) {
      val o2: Case = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Pattern] = transformPattern(ctx, o2.pattern)
      val r1: Result[Context, Option[Exp]] = transformOption(r0.ctx, o2.condOpt, transformExp _)
      val r2: Result[Context, Body] = transformBody(r1.ctx, o2.body)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
        Result(r2.ctx, Some(o2(pattern = r0.resultOpt.getOrElse(o2.pattern), condOpt = r1.resultOpt.getOrElse(o2.condOpt), body = r2.resultOpt.getOrElse(o2.body))))
      else
        Result(r2.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Case = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Case] = post.transformCase(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformRange(ctx: Context, o: Range): Result[Context, Range] = {
    val preR: PreResult[Context, Range] = pre.transformRange(ctx, o)
    val r: Result[Context, Range] = if (preR.continue) {
      val o2: Range = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, Range] = o2 match {
        case o2: Range.Expr =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.exp)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(exp = r0.resultOpt.getOrElse(o2.exp))))
          else
            Result(r0.ctx, None())
        case o2: Range.Indices =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.exp)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(exp = r0.resultOpt.getOrElse(o2.exp))))
          else
            Result(r0.ctx, None())
        case o2: Range.Step =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.start)
          val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.end)
          val r2: Result[Context, Option[Exp]] = transformOption(r1.ctx, o2.byOpt, transformExp _)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(start = r0.resultOpt.getOrElse(o2.start), end = r1.resultOpt.getOrElse(o2.end), byOpt = r2.resultOpt.getOrElse(o2.byOpt))))
          else
            Result(r2.ctx, None())
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Range = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Range] = post.transformRange(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformType(ctx: Context, o: Type): Result[Context, Type] = {
    val preR: PreResult[Context, Type] = pre.transformType(ctx, o)
    val r: Result[Context, Type] = if (preR.continue) {
      val o2: Type = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, Type] = o2 match {
        case o2: Type.Named =>
          val r0: Result[Context, Name] = transformName(ctx, o2.name)
          val r1: Result[Context, IS[Z, Type]] = transformISZ(r0.ctx, o2.typeArgs, transformType _)
          val r2: Result[Context, TypedAttr] = transformTypedAttr(r1.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(name = r0.resultOpt.getOrElse(o2.name), typeArgs = r1.resultOpt.getOrElse(o2.typeArgs), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Type.Fun =>
          val r0: Result[Context, IS[Z, Type]] = transformISZ(ctx, o2.args, transformType _)
          val r1: Result[Context, Type] = transformType(r0.ctx, o2.ret)
          val r2: Result[Context, TypedAttr] = transformTypedAttr(r1.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(args = r0.resultOpt.getOrElse(o2.args), ret = r1.resultOpt.getOrElse(o2.ret), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Type.Tuple =>
          val r0: Result[Context, IS[Z, Type]] = transformISZ(ctx, o2.args, transformType _)
          val r1: Result[Context, TypedAttr] = transformTypedAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(args = r0.resultOpt.getOrElse(o2.args), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Type = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Type] = post.transformType(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformPattern(ctx: Context, o: Pattern): Result[Context, Pattern] = {
    val preR: PreResult[Context, Pattern] = pre.transformPattern(ctx, o)
    val r: Result[Context, Pattern] = if (preR.continue) {
      val o2: Pattern = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, Pattern] = o2 match {
        case o2: Pattern.Literal =>
          if (hasChanged)
            Result(ctx, Some(o2))
          else
            Result(ctx, None())
        case o2: Pattern.Ref =>
          val r0: Result[Context, Name] = transformName(ctx, o2.name)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(name = r0.resultOpt.getOrElse(o2.name))))
          else
            Result(r0.ctx, None())
        case o2: Pattern.Variable =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, Option[Type]] = transformOption(r0.ctx, o2.typeOpt, transformType _)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), typeOpt = r1.resultOpt.getOrElse(o2.typeOpt))))
          else
            Result(r1.ctx, None())
        case o2: Pattern.Wildcard =>
          val r0: Result[Context, Option[Type]] = transformOption(ctx, o2.typeOpt, transformType _)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(typeOpt = r0.resultOpt.getOrElse(o2.typeOpt))))
          else
            Result(r0.ctx, None())
        case o2: Pattern.SeqWildcard =>
          if (hasChanged)
            Result(ctx, Some(o2))
          else
            Result(ctx, None())
        case o2: Pattern.Structure =>
          val r0: Result[Context, Option[Id]] = transformOption(ctx, o2.idOpt, transformId _)
          val r1: Result[Context, Option[Name]] = transformOption(r0.ctx, o2.nameOpt, transformName _)
          val r2: Result[Context, IS[Z, Pattern]] = transformISZ(r1.ctx, o2.patterns, transformPattern _)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(idOpt = r0.resultOpt.getOrElse(o2.idOpt), nameOpt = r1.resultOpt.getOrElse(o2.nameOpt), patterns = r2.resultOpt.getOrElse(o2.patterns))))
          else
            Result(r2.ctx, None())
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Pattern = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Pattern] = post.transformPattern(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformExp(ctx: Context, o: Exp): Result[Context, Exp] = {
    val preR: PreResult[Context, Exp] = pre.transformExp(ctx, o)
    val r: Result[Context, Exp] = if (preR.continue) {
      val o2: Exp = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, Exp] = o2 match {
        case o2: Exp.LitB =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitC =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitZ =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitZ8 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitZ16 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitZ32 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitZ64 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitN =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitN8 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitN16 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitN32 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitN64 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitS8 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitS16 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitS32 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitS64 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitU8 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitU16 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitU32 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitU64 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitF32 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitF64 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitR =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitBv =>
          val r0: Result[Context, Type] = transformType(ctx, o2.tipe)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(tipe = r0.resultOpt.getOrElse(o2.tipe), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Exp.LitString =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.StringInterpolate =>
          val r0: Result[Context, IS[Z, Exp.LitString]] = transformISZ(ctx, o2.lits, transformExpLitString _)
          val r1: Result[Context, IS[Z, Exp]] = transformISZ(r0.ctx, o2.args, transformExp _)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(lits = r0.resultOpt.getOrElse(o2.lits), args = r1.resultOpt.getOrElse(o2.args), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Exp.This =>
          val r0: Result[Context, TypedAttr] = transformTypedAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.Unary =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.exp)
          val r1: Result[Context, TypedAttr] = transformTypedAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(exp = r0.resultOpt.getOrElse(o2.exp), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Exp.Binary =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.left)
          val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.right)
          val r2: Result[Context, TypedAttr] = transformTypedAttr(r1.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(left = r0.resultOpt.getOrElse(o2.left), right = r1.resultOpt.getOrElse(o2.right), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Exp.Ident =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, ResolvedAttr] = transformResolvedAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Exp.Eta =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.exp)
          val r1: Result[Context, ResolvedAttr] = transformResolvedAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(exp = r0.resultOpt.getOrElse(o2.exp), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Exp.Tuple =>
          val r0: Result[Context, IS[Z, Exp]] = transformISZ(ctx, o2.args, transformExp _)
          val r1: Result[Context, TypedAttr] = transformTypedAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(args = r0.resultOpt.getOrElse(o2.args), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Exp.Select =>
          val r0: Result[Context, Option[Exp]] = transformOption(ctx, o2.receiverOpt, transformExp _)
          val r1: Result[Context, Id] = transformId(r0.ctx, o2.id)
          val r2: Result[Context, IS[Z, Type]] = transformISZ(r1.ctx, o2.targs, transformType _)
          val r3: Result[Context, ResolvedAttr] = transformResolvedAttr(r2.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty| r3.resultOpt.nonEmpty)
            Result(r3.ctx, Some(o2(receiverOpt = r0.resultOpt.getOrElse(o2.receiverOpt), id = r1.resultOpt.getOrElse(o2.id), targs = r2.resultOpt.getOrElse(o2.targs), attr = r3.resultOpt.getOrElse(o2.attr))))
          else
            Result(r3.ctx, None())
        case o2: Exp.Invoke =>
          val r0: Result[Context, Option[Exp]] = transformOption(ctx, o2.receiverOpt, transformExp _)
          val r1: Result[Context, Id] = transformId(r0.ctx, o2.id)
          val r2: Result[Context, IS[Z, Type]] = transformISZ(r1.ctx, o2.targs, transformType _)
          val r3: Result[Context, IS[Z, Exp]] = transformISZ(r2.ctx, o2.args, transformExp _)
          val r4: Result[Context, ResolvedAttr] = transformResolvedAttr(r3.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty| r3.resultOpt.nonEmpty| r4.resultOpt.nonEmpty)
            Result(r4.ctx, Some(o2(receiverOpt = r0.resultOpt.getOrElse(o2.receiverOpt), id = r1.resultOpt.getOrElse(o2.id), targs = r2.resultOpt.getOrElse(o2.targs), args = r3.resultOpt.getOrElse(o2.args), attr = r4.resultOpt.getOrElse(o2.attr))))
          else
            Result(r4.ctx, None())
        case o2: Exp.InvokeNamed =>
          val r0: Result[Context, Option[Exp]] = transformOption(ctx, o2.receiverOpt, transformExp _)
          val r1: Result[Context, Id] = transformId(r0.ctx, o2.id)
          val r2: Result[Context, IS[Z, Type]] = transformISZ(r1.ctx, o2.targs, transformType _)
          val r3: Result[Context, IS[Z, NamedArg]] = transformISZ(r2.ctx, o2.args, transformNamedArg _)
          val r4: Result[Context, ResolvedAttr] = transformResolvedAttr(r3.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty| r3.resultOpt.nonEmpty| r4.resultOpt.nonEmpty)
            Result(r4.ctx, Some(o2(receiverOpt = r0.resultOpt.getOrElse(o2.receiverOpt), id = r1.resultOpt.getOrElse(o2.id), targs = r2.resultOpt.getOrElse(o2.targs), args = r3.resultOpt.getOrElse(o2.args), attr = r4.resultOpt.getOrElse(o2.attr))))
          else
            Result(r4.ctx, None())
        case o2: Exp.If =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.cond)
          val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.thenExp)
          val r2: Result[Context, Exp] = transformExp(r1.ctx, o2.elseExp)
          val r3: Result[Context, TypedAttr] = transformTypedAttr(r2.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty| r3.resultOpt.nonEmpty)
            Result(r3.ctx, Some(o2(cond = r0.resultOpt.getOrElse(o2.cond), thenExp = r1.resultOpt.getOrElse(o2.thenExp), elseExp = r2.resultOpt.getOrElse(o2.elseExp), attr = r3.resultOpt.getOrElse(o2.attr))))
          else
            Result(r3.ctx, None())
        case o2: Exp.Quant =>
          val r0: Result[Context, IS[Z, VarFragment]] = transformISZ(ctx, o2.varFragments, transformVarFragment _)
          val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.exp)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(varFragments = r0.resultOpt.getOrElse(o2.varFragments), exp = r1.resultOpt.getOrElse(o2.exp))))
          else
            Result(r1.ctx, None())
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Exp = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Exp] = post.transformExp(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformExpLitString(ctx: Context, o: Exp.LitString): Result[Context, Exp.LitString] = {
    val preR: PreResult[Context, Exp.LitString] = pre.transformExpLitString(ctx, o) match {
      case PreResult(preCtx, continue, Some(r: Exp.LitString)) => PreResult(preCtx, continue, Some[Exp.LitString](r))
      case PreResult(preCtx, continue, _) => assert(F); PreResult(preCtx, F, None[Exp.LitString]())
    }
    val r: Result[Context, Exp.LitString] = if (preR.continue) {
      val o2: Exp.LitString = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
      if (hasChanged | r0.resultOpt.nonEmpty)
        Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
      else
        Result(r0.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Exp.LitString = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Exp.LitString] = post.transformExpLitString(r.ctx, o2) match {
      case Result(postCtx, Some(result: Exp.LitString)) => Result(postCtx, Some[Exp.LitString](result))
      case Result(postCtx, _) => assert(F); Result(postCtx, None[Exp.LitString]())
    }
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformNamedArg(ctx: Context, o: NamedArg): Result[Context, NamedArg] = {
    val preR: PreResult[Context, NamedArg] = pre.transformNamedArg(ctx, o)
    val r: Result[Context, NamedArg] = if (preR.continue) {
      val o2: NamedArg = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.id)
      val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.arg)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
        Result(r1.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), arg = r1.resultOpt.getOrElse(o2.arg))))
      else
        Result(r1.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: NamedArg = r.resultOpt.getOrElse(o)
    val postR: Result[Context, NamedArg] = post.transformNamedArg(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformVarFragment(ctx: Context, o: VarFragment): Result[Context, VarFragment] = {
    val preR: PreResult[Context, VarFragment] = pre.transformVarFragment(ctx, o)
    val r: Result[Context, VarFragment] = if (preR.continue) {
      val o2: VarFragment = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, IS[Z, Id]] = transformISZ(ctx, o2.ids, transformId _)
      val r1: Result[Context, Option[Domain]] = transformOption(r0.ctx, o2.domainOpt, transformDomain _)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
        Result(r1.ctx, Some(o2(ids = r0.resultOpt.getOrElse(o2.ids), domainOpt = r1.resultOpt.getOrElse(o2.domainOpt))))
      else
        Result(r1.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: VarFragment = r.resultOpt.getOrElse(o)
    val postR: Result[Context, VarFragment] = post.transformVarFragment(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformDomain(ctx: Context, o: Domain): Result[Context, Domain] = {
    val preR: PreResult[Context, Domain] = pre.transformDomain(ctx, o)
    val r: Result[Context, Domain] = if (preR.continue) {
      val o2: Domain = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, Domain] = o2 match {
        case o2: Domain.Type =>
          val r0: Result[Context, Type] = transformType(ctx, o2.tipe)
          val r1: Result[Context, TypedAttr] = transformTypedAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(tipe = r0.resultOpt.getOrElse(o2.tipe), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Domain.Range =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.lo)
          val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.hi)
          val r2: Result[Context, TypedAttr] = transformTypedAttr(r1.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(lo = r0.resultOpt.getOrElse(o2.lo), hi = r1.resultOpt.getOrElse(o2.hi), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Domain = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Domain] = post.transformDomain(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformId(ctx: Context, o: Id): Result[Context, Id] = {
    val preR: PreResult[Context, Id] = pre.transformId(ctx, o)
    val r: Result[Context, Id] = if (preR.continue) {
      val o2: Id = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
      if (hasChanged | r0.resultOpt.nonEmpty)
        Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
      else
        Result(r0.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Id = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Id] = post.transformId(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformName(ctx: Context, o: Name): Result[Context, Name] = {
    val preR: PreResult[Context, Name] = pre.transformName(ctx, o)
    val r: Result[Context, Name] = if (preR.continue) {
      val o2: Name = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, IS[Z, Id]] = transformISZ(ctx, o2.ids, transformId _)
      val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
        Result(r1.ctx, Some(o2(ids = r0.resultOpt.getOrElse(o2.ids), attr = r1.resultOpt.getOrElse(o2.attr))))
      else
        Result(r1.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Name = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Name] = post.transformName(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformBody(ctx: Context, o: Body): Result[Context, Body] = {
    val preR: PreResult[Context, Body] = pre.transformBody(ctx, o)
    val r: Result[Context, Body] = if (preR.continue) {
      val o2: Body = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, IS[Z, Stmt]] = transformISZ(ctx, o2.stmts, transformStmt _)
      if (hasChanged | r0.resultOpt.nonEmpty)
        Result(r0.ctx, Some(o2(stmts = r0.resultOpt.getOrElse(o2.stmts))))
      else
        Result(r0.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Body = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Body] = post.transformBody(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformAbstractDatatypeParam(ctx: Context, o: AbstractDatatypeParam): Result[Context, AbstractDatatypeParam] = {
    val preR: PreResult[Context, AbstractDatatypeParam] = pre.transformAbstractDatatypeParam(ctx, o)
    val r: Result[Context, AbstractDatatypeParam] = if (preR.continue) {
      val o2: AbstractDatatypeParam = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.id)
      val r1: Result[Context, Type] = transformType(r0.ctx, o2.tipe)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
        Result(r1.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), tipe = r1.resultOpt.getOrElse(o2.tipe))))
      else
        Result(r1.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: AbstractDatatypeParam = r.resultOpt.getOrElse(o)
    val postR: Result[Context, AbstractDatatypeParam] = post.transformAbstractDatatypeParam(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformMethodSig(ctx: Context, o: MethodSig): Result[Context, MethodSig] = {
    val preR: PreResult[Context, MethodSig] = pre.transformMethodSig(ctx, o)
    val r: Result[Context, MethodSig] = if (preR.continue) {
      val o2: MethodSig = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.id)
      val r1: Result[Context, IS[Z, TypeParam]] = transformISZ(r0.ctx, o2.typeParams, transformTypeParam _)
      val r2: Result[Context, Type] = transformType(r1.ctx, o2.returnType)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
        Result(r2.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), typeParams = r1.resultOpt.getOrElse(o2.typeParams), returnType = r2.resultOpt.getOrElse(o2.returnType))))
      else
        Result(r2.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: MethodSig = r.resultOpt.getOrElse(o)
    val postR: Result[Context, MethodSig] = post.transformMethodSig(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformParam(ctx: Context, o: Param): Result[Context, Param] = {
    val preR: PreResult[Context, Param] = pre.transformParam(ctx, o)
    val r: Result[Context, Param] = if (preR.continue) {
      val o2: Param = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.id)
      val r1: Result[Context, Type] = transformType(r0.ctx, o2.tipe)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
        Result(r1.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), tipe = r1.resultOpt.getOrElse(o2.tipe))))
      else
        Result(r1.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Param = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Param] = post.transformParam(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformTypeParam(ctx: Context, o: TypeParam): Result[Context, TypeParam] = {
    val preR: PreResult[Context, TypeParam] = pre.transformTypeParam(ctx, o)
    val r: Result[Context, TypeParam] = if (preR.continue) {
      val o2: TypeParam = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.id)
      val r1: Result[Context, Option[Type]] = transformOption(r0.ctx, o2.superTypeOpt, transformType _)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
        Result(r1.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), superTypeOpt = r1.resultOpt.getOrElse(o2.superTypeOpt))))
      else
        Result(r1.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: TypeParam = r.resultOpt.getOrElse(o)
    val postR: Result[Context, TypeParam] = post.transformTypeParam(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformContract(ctx: Context, o: Contract): Result[Context, Contract] = {
    val preR: PreResult[Context, Contract] = pre.transformContract(ctx, o)
    val r: Result[Context, Contract] = if (preR.continue) {
      val o2: Contract = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, IS[Z, Exp]] = transformISZ(ctx, o2.reads, transformExp _)
      val r1: Result[Context, IS[Z, ContractExp]] = transformISZ(r0.ctx, o2.requires, transformContractExp _)
      val r2: Result[Context, IS[Z, Exp]] = transformISZ(r1.ctx, o2.modifies, transformExp _)
      val r3: Result[Context, IS[Z, ContractExp]] = transformISZ(r2.ctx, o2.ensures, transformContractExp _)
      val r4: Result[Context, IS[Z, SubContract]] = transformISZ(r3.ctx, o2.subs, transformSubContract _)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty| r3.resultOpt.nonEmpty| r4.resultOpt.nonEmpty)
        Result(r4.ctx, Some(o2(reads = r0.resultOpt.getOrElse(o2.reads), requires = r1.resultOpt.getOrElse(o2.requires), modifies = r2.resultOpt.getOrElse(o2.modifies), ensures = r3.resultOpt.getOrElse(o2.ensures), subs = r4.resultOpt.getOrElse(o2.subs))))
      else
        Result(r4.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Contract = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Contract] = post.transformContract(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformSubContract(ctx: Context, o: SubContract): Result[Context, SubContract] = {
    val preR: PreResult[Context, SubContract] = pre.transformSubContract(ctx, o)
    val r: Result[Context, SubContract] = if (preR.continue) {
      val o2: SubContract = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.id)
      val r1: Result[Context, IS[Z, SubContractParam]] = transformISZ(r0.ctx, o2.params, transformSubContractParam _)
      val r2: Result[Context, Contract] = transformContract(r1.ctx, o2.contract)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
        Result(r2.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), params = r1.resultOpt.getOrElse(o2.params), contract = r2.resultOpt.getOrElse(o2.contract))))
      else
        Result(r2.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: SubContract = r.resultOpt.getOrElse(o)
    val postR: Result[Context, SubContract] = post.transformSubContract(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformSubContractParam(ctx: Context, o: SubContractParam): Result[Context, SubContractParam] = {
    val preR: PreResult[Context, SubContractParam] = pre.transformSubContractParam(ctx, o)
    val r: Result[Context, SubContractParam] = if (preR.continue) {
      val o2: SubContractParam = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.id)
      if (hasChanged | r0.resultOpt.nonEmpty)
        Result(r0.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id))))
      else
        Result(r0.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: SubContractParam = r.resultOpt.getOrElse(o)
    val postR: Result[Context, SubContractParam] = post.transformSubContractParam(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformWhereDef(ctx: Context, o: WhereDef): Result[Context, WhereDef] = {
    val preR: PreResult[Context, WhereDef] = pre.transformWhereDef(ctx, o)
    val r: Result[Context, WhereDef] = if (preR.continue) {
      val o2: WhereDef = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, WhereDef] = o2 match {
        case o2: WhereDef.Val =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, Type] = transformType(r0.ctx, o2.tipe)
          val r2: Result[Context, Exp] = transformExp(r1.ctx, o2.exp)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), tipe = r1.resultOpt.getOrElse(o2.tipe), exp = r2.resultOpt.getOrElse(o2.exp))))
          else
            Result(r2.ctx, None())
        case o2: WhereDef.Def =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, IS[Z, Param]] = transformISZ(r0.ctx, o2.params, transformParam _)
          val r2: Result[Context, Type] = transformType(r1.ctx, o2.rTipe)
          val r3: Result[Context, IS[Z, SpecDef]] = transformISZ(r2.ctx, o2.defs, transformSpecDef _)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty| r3.resultOpt.nonEmpty)
            Result(r3.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), params = r1.resultOpt.getOrElse(o2.params), rTipe = r2.resultOpt.getOrElse(o2.rTipe), defs = r3.resultOpt.getOrElse(o2.defs))))
          else
            Result(r3.ctx, None())
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: WhereDef = r.resultOpt.getOrElse(o)
    val postR: Result[Context, WhereDef] = post.transformWhereDef(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformSpecDef(ctx: Context, o: SpecDef): Result[Context, SpecDef] = {
    val preR: PreResult[Context, SpecDef] = pre.transformSpecDef(ctx, o)
    val r: Result[Context, SpecDef] = if (preR.continue) {
      val o2: SpecDef = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Option[Id]] = transformOption(ctx, o2.idOpt, transformId _)
      val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.exp)
      val r2: Result[Context, Option[Pattern]] = transformOption(r1.ctx, o2.patternOpt, transformPattern _)
      val r3: Result[Context, Option[Exp]] = transformOption(r2.ctx, o2.guardOpt, transformExp _)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty| r3.resultOpt.nonEmpty)
        Result(r3.ctx, Some(o2(idOpt = r0.resultOpt.getOrElse(o2.idOpt), exp = r1.resultOpt.getOrElse(o2.exp), patternOpt = r2.resultOpt.getOrElse(o2.patternOpt), guardOpt = r3.resultOpt.getOrElse(o2.guardOpt))))
      else
        Result(r3.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: SpecDef = r.resultOpt.getOrElse(o)
    val postR: Result[Context, SpecDef] = post.transformSpecDef(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformProofStep(ctx: Context, o: ProofStep): Result[Context, ProofStep] = {
    val preR: PreResult[Context, ProofStep] = pre.transformProofStep(ctx, o)
    val r: Result[Context, ProofStep] = if (preR.continue) {
      val o2: ProofStep = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, ProofStep] = o2 match {
        case o2: ProofStep.Basic =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.step)
          val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.exp)
          val r2: Result[Context, Just] = transformJust(r1.ctx, o2.just)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(step = r0.resultOpt.getOrElse(o2.step), exp = r1.resultOpt.getOrElse(o2.exp), just = r2.resultOpt.getOrElse(o2.just))))
          else
            Result(r2.ctx, None())
        case o2: ProofStep.SubProof =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.step)
          val r1: Result[Context, AssumeProofStep] = transformAssumeProofStep(r0.ctx, o2.assumeStep)
          val r2: Result[Context, IS[Z, ProofStep]] = transformISZ(r1.ctx, o2.steps, transformProofStep _)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(step = r0.resultOpt.getOrElse(o2.step), assumeStep = r1.resultOpt.getOrElse(o2.assumeStep), steps = r2.resultOpt.getOrElse(o2.steps))))
          else
            Result(r2.ctx, None())
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: ProofStep = r.resultOpt.getOrElse(o)
    val postR: Result[Context, ProofStep] = post.transformProofStep(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformExpLitZ(ctx: Context, o: Exp.LitZ): Result[Context, Exp.LitZ] = {
    val preR: PreResult[Context, Exp.LitZ] = pre.transformExpLitZ(ctx, o) match {
      case PreResult(preCtx, continue, Some(r: Exp.LitZ)) => PreResult(preCtx, continue, Some[Exp.LitZ](r))
      case PreResult(preCtx, continue, _) => assert(F); PreResult(preCtx, F, None[Exp.LitZ]())
    }
    val r: Result[Context, Exp.LitZ] = if (preR.continue) {
      val o2: Exp.LitZ = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
      if (hasChanged | r0.resultOpt.nonEmpty)
        Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
      else
        Result(r0.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Exp.LitZ = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Exp.LitZ] = post.transformExpLitZ(r.ctx, o2) match {
      case Result(postCtx, Some(result: Exp.LitZ)) => Result(postCtx, Some[Exp.LitZ](result))
      case Result(postCtx, _) => assert(F); Result(postCtx, None[Exp.LitZ]())
    }
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformAssumeProofStep(ctx: Context, o: AssumeProofStep): Result[Context, AssumeProofStep] = {
    val preR: PreResult[Context, AssumeProofStep] = pre.transformAssumeProofStep(ctx, o)
    val r: Result[Context, AssumeProofStep] = if (preR.continue) {
      val o2: AssumeProofStep = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, AssumeProofStep] = o2 match {
        case o2: AssumeProofStep.Regular =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.step)
          val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.exp)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(step = r0.resultOpt.getOrElse(o2.step), exp = r1.resultOpt.getOrElse(o2.exp))))
          else
            Result(r1.ctx, None())
        case o2: AssumeProofStep.ForallIntroAps =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.step)
          val r1: Result[Context, IS[Z, VarFragment]] = transformISZ(r0.ctx, o2.varFragments, transformVarFragment _)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(step = r0.resultOpt.getOrElse(o2.step), varFragments = r1.resultOpt.getOrElse(o2.varFragments))))
          else
            Result(r1.ctx, None())
        case o2: AssumeProofStep.ExistsElimAps =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.step)
          val r1: Result[Context, IS[Z, VarFragment]] = transformISZ(r0.ctx, o2.varFragments, transformVarFragment _)
          val r2: Result[Context, Exp] = transformExp(r1.ctx, o2.exp)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(step = r0.resultOpt.getOrElse(o2.step), varFragments = r1.resultOpt.getOrElse(o2.varFragments), exp = r2.resultOpt.getOrElse(o2.exp))))
          else
            Result(r2.ctx, None())
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: AssumeProofStep = r.resultOpt.getOrElse(o)
    val postR: Result[Context, AssumeProofStep] = post.transformAssumeProofStep(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformJust(ctx: Context, o: Just): Result[Context, Just] = {
    val preR: PreResult[Context, Just] = pre.transformJust(ctx, o)
    val r: Result[Context, Just] = if (preR.continue) {
      val o2: Just = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, Just] = o2 match {
        case o2: Just.Premise =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Just.AndIntro =>
          val r0: Result[Context, IS[Z, Exp.LitZ]] = transformISZ(ctx, o2.steps, transformExpLitZ _)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(steps = r0.resultOpt.getOrElse(o2.steps), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.AndElim =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.andStep)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(andStep = r0.resultOpt.getOrElse(o2.andStep), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.OrIntro =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.step)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(step = r0.resultOpt.getOrElse(o2.step), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.OrElim =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.orStep)
          val r1: Result[Context, IS[Z, Exp.LitZ]] = transformISZ(r0.ctx, o2.subProofSteps, transformExpLitZ _)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(orStep = r0.resultOpt.getOrElse(o2.orStep), subProofSteps = r1.resultOpt.getOrElse(o2.subProofSteps), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Just.ImplyIntro =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.subProofStep)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(subProofStep = r0.resultOpt.getOrElse(o2.subProofStep), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.ImplyElim =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.implyStep)
          val r1: Result[Context, IS[Z, Exp.LitZ]] = transformISZ(r0.ctx, o2.steps, transformExpLitZ _)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(implyStep = r0.resultOpt.getOrElse(o2.implyStep), steps = r1.resultOpt.getOrElse(o2.steps), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Just.NegIntro =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.subProofStep)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(subProofStep = r0.resultOpt.getOrElse(o2.subProofStep), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.NegElim =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.step)
          val r1: Result[Context, Exp.LitZ] = transformExpLitZ(r0.ctx, o2.negStep)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(step = r0.resultOpt.getOrElse(o2.step), negStep = r1.resultOpt.getOrElse(o2.negStep), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Just.BottomElim =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.subProofStep)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(subProofStep = r0.resultOpt.getOrElse(o2.subProofStep), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.Pbc =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.subProofStep)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(subProofStep = r0.resultOpt.getOrElse(o2.subProofStep), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.ForallIntro =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.subProofStep)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(subProofStep = r0.resultOpt.getOrElse(o2.subProofStep), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.ForallElim =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.forallStep)
          val r1: Result[Context, IS[Z, Exp]] = transformISZ(r0.ctx, o2.args, transformExp _)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(forallStep = r0.resultOpt.getOrElse(o2.forallStep), args = r1.resultOpt.getOrElse(o2.args), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Just.ExistsIntro =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.existsStep)
          val r1: Result[Context, IS[Z, Exp]] = transformISZ(r0.ctx, o2.args, transformExp _)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(existsStep = r0.resultOpt.getOrElse(o2.existsStep), args = r1.resultOpt.getOrElse(o2.args), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Just.ExistsElim =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.existsStep)
          val r1: Result[Context, Exp.LitZ] = transformExpLitZ(r0.ctx, o2.subProofStep)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(existsStep = r0.resultOpt.getOrElse(o2.existsStep), subProofStep = r1.resultOpt.getOrElse(o2.subProofStep), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Just.Fact =>
          val r0: Result[Context, Name] = transformName(ctx, o2.name)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(name = r0.resultOpt.getOrElse(o2.name), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.Invariant =>
          val r0: Result[Context, Option[Name]] = transformOption(ctx, o2.nameOpt, transformName _)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(nameOpt = r0.resultOpt.getOrElse(o2.nameOpt), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.Subst =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.eqStep)
          val r1: Result[Context, Exp.LitZ] = transformExpLitZ(r0.ctx, o2.step)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(eqStep = r0.resultOpt.getOrElse(o2.eqStep), step = r1.resultOpt.getOrElse(o2.step), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Just.Auto =>
          val r0: Result[Context, IS[Z, Exp.LitZ]] = transformISZ(ctx, o2.steps, transformExpLitZ _)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(steps = r0.resultOpt.getOrElse(o2.steps), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.Coq =>
          val r0: Result[Context, Exp.LitString] = transformExpLitString(ctx, o2.path)
          val r1: Result[Context, IS[Z, Exp.LitZ]] = transformISZ(r0.ctx, o2.steps, transformExpLitZ _)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(path = r0.resultOpt.getOrElse(o2.path), steps = r1.resultOpt.getOrElse(o2.steps), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Just = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Just] = post.transformJust(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformTruthTableRow(ctx: Context, o: TruthTable.Row): Result[Context, TruthTable.Row] = {
    val preR: PreResult[Context, TruthTable.Row] = pre.transformTruthTableRow(ctx, o)
    val r: Result[Context, TruthTable.Row] = if (preR.continue) {
      val o2: TruthTable.Row = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, IS[Z, Exp.LitB]] = transformISZ(ctx, o2.assignment, transformExpLitB _)
      val r1: Result[Context, IS[Z, Exp.LitB]] = transformISZ(r0.ctx, o2.values, transformExpLitB _)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
        Result(r1.ctx, Some(o2(assignment = r0.resultOpt.getOrElse(o2.assignment), values = r1.resultOpt.getOrElse(o2.values))))
      else
        Result(r1.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: TruthTable.Row = r.resultOpt.getOrElse(o)
    val postR: Result[Context, TruthTable.Row] = post.transformTruthTableRow(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformExpLitB(ctx: Context, o: Exp.LitB): Result[Context, Exp.LitB] = {
    val preR: PreResult[Context, Exp.LitB] = pre.transformExpLitB(ctx, o) match {
      case PreResult(preCtx, continue, Some(r: Exp.LitB)) => PreResult(preCtx, continue, Some[Exp.LitB](r))
      case PreResult(preCtx, continue, _) => assert(F); PreResult(preCtx, F, None[Exp.LitB]())
    }
    val r: Result[Context, Exp.LitB] = if (preR.continue) {
      val o2: Exp.LitB = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
      if (hasChanged | r0.resultOpt.nonEmpty)
        Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
      else
        Result(r0.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Exp.LitB = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Exp.LitB] = post.transformExpLitB(r.ctx, o2) match {
      case Result(postCtx, Some(result: Exp.LitB)) => Result(postCtx, Some[Exp.LitB](result))
      case Result(postCtx, _) => assert(F); Result(postCtx, None[Exp.LitB]())
    }
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformTruthTableConclusion(ctx: Context, o: TruthTable.Conclusion): Result[Context, TruthTable.Conclusion] = {
    val preR: PreResult[Context, TruthTable.Conclusion] = pre.transformTruthTableConclusion(ctx, o)
    val r: Result[Context, TruthTable.Conclusion] = if (preR.continue) {
      val o2: TruthTable.Conclusion = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, TruthTable.Conclusion] = o2 match {
        case o2: TruthTable.Conclusion.Validity =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: TruthTable.Conclusion.Tautology =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: TruthTable.Conclusion.Contradictory =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: TruthTable.Conclusion.Contingent =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged | r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: TruthTable.Conclusion = r.resultOpt.getOrElse(o)
    val postR: Result[Context, TruthTable.Conclusion] = post.transformTruthTableConclusion(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformAttr(ctx: Context, o: Attr): Result[Context, Attr] = {
    val preR: PreResult[Context, Attr] = pre.transformAttr(ctx, o)
    val r: Result[Context, Attr] = if (preR.continue) {
      val o2: Attr = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Option[PosInfo]] = transformOption(ctx, o2.posInfoOpt, transformPosInfo _)
      if (hasChanged | r0.resultOpt.nonEmpty)
        Result(r0.ctx, Some(o2(posInfoOpt = r0.resultOpt.getOrElse(o2.posInfoOpt))))
      else
        Result(r0.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Attr = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Attr] = post.transformAttr(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformTypedAttr(ctx: Context, o: TypedAttr): Result[Context, TypedAttr] = {
    val preR: PreResult[Context, TypedAttr] = pre.transformTypedAttr(ctx, o)
    val r: Result[Context, TypedAttr] = if (preR.continue) {
      val o2: TypedAttr = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Option[PosInfo]] = transformOption(ctx, o2.posInfoOpt, transformPosInfo _)
      val r1: Result[Context, Option[Type]] = transformOption(r0.ctx, o2.typeOpt, transformType _)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty)
        Result(r1.ctx, Some(o2(posInfoOpt = r0.resultOpt.getOrElse(o2.posInfoOpt), typeOpt = r1.resultOpt.getOrElse(o2.typeOpt))))
      else
        Result(r1.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: TypedAttr = r.resultOpt.getOrElse(o)
    val postR: Result[Context, TypedAttr] = post.transformTypedAttr(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformResolvedAttr(ctx: Context, o: ResolvedAttr): Result[Context, ResolvedAttr] = {
    val preR: PreResult[Context, ResolvedAttr] = pre.transformResolvedAttr(ctx, o)
    val r: Result[Context, ResolvedAttr] = if (preR.continue) {
      val o2: ResolvedAttr = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Option[PosInfo]] = transformOption(ctx, o2.posInfoOpt, transformPosInfo _)
      val r1: Result[Context, Option[ResolvedInfo]] = transformOption(r0.ctx, o2.resOpt, transformResolvedInfo _)
      val r2: Result[Context, Option[Type]] = transformOption(r1.ctx, o2.typeOpt, transformType _)
      if (hasChanged | r0.resultOpt.nonEmpty| r1.resultOpt.nonEmpty| r2.resultOpt.nonEmpty)
        Result(r2.ctx, Some(o2(posInfoOpt = r0.resultOpt.getOrElse(o2.posInfoOpt), resOpt = r1.resultOpt.getOrElse(o2.resOpt), typeOpt = r2.resultOpt.getOrElse(o2.typeOpt))))
      else
        Result(r2.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: ResolvedAttr = r.resultOpt.getOrElse(o)
    val postR: Result[Context, ResolvedAttr] = post.transformResolvedAttr(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformResolvedInfo(ctx: Context, o: ResolvedInfo): Result[Context, ResolvedInfo] = {
    val preR: PreResult[Context, ResolvedInfo] = pre.transformResolvedInfo(ctx, o)
    val r: Result[Context, ResolvedInfo] = if (preR.continue) {
      val o2: ResolvedInfo = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      if (hasChanged)
        Result(ctx, Some(o2))
      else
        Result(ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: ResolvedInfo = r.resultOpt.getOrElse(o)
    val postR: Result[Context, ResolvedInfo] = post.transformResolvedInfo(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformPosInfo(ctx: Context, o: PosInfo): Result[Context, PosInfo] = {
    val preR: PreResult[Context, PosInfo] = pre.transformPosInfo(ctx, o)
    val r: Result[Context, PosInfo] = if (preR.continue) {
      val o2: PosInfo = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      if (hasChanged)
        Result(ctx, Some(o2))
      else
        Result(ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: PosInfo = r.resultOpt.getOrElse(o)
    val postR: Result[Context, PosInfo] = post.transformPosInfo(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

}