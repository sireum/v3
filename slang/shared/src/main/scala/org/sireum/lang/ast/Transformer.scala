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

  @sig trait PrePost[Context] {

    @pure def preTopUnit(ctx: Context, o: TopUnit): PreResult[Context, TopUnit] = {
      o match {
        case o: TopUnit.Program => return preTopUnitProgram(ctx, o)
        case o: TopUnit.SequentUnit => return preTopUnitSequentUnit(ctx, o)
        case o: TopUnit.TruthTableUnit => return preTopUnitTruthTableUnit(ctx, o)
      }
    }

    @pure def preTopUnitProgram(ctx: Context, o: TopUnit.Program): PreResult[Context, TopUnit] = {
      return PreResult(ctx, T, None())
    }

    @pure def preTopUnitSequentUnit(ctx: Context, o: TopUnit.SequentUnit): PreResult[Context, TopUnit] = {
      return PreResult(ctx, T, None())
    }

    @pure def preTopUnitTruthTableUnit(ctx: Context, o: TopUnit.TruthTableUnit): PreResult[Context, TopUnit] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmt(ctx: Context, o: Stmt): PreResult[Context, Stmt] = {
      o match {
        case o: Stmt.Import => return preStmtImport(ctx, o)
        case o: Stmt.Var => return preStmtVar(ctx, o)
        case o: Stmt.VarPattern => return preStmtVarPattern(ctx, o)
        case o: Stmt.SpecVar => return preStmtSpecVar(ctx, o)
        case o: Stmt.Method => return preStmtMethod(ctx, o)
        case o: Stmt.ExtMethod => return preStmtExtMethod(ctx, o)
        case o: Stmt.SpecMethod => return preStmtSpecMethod(ctx, o)
        case o: Stmt.Enum => return preStmtEnum(ctx, o)
        case o: Stmt.SubZ => return preStmtSubZ(ctx, o)
        case o: Stmt.Object => return preStmtObject(ctx, o)
        case o: Stmt.Sig => return preStmtSig(ctx, o)
        case o: Stmt.AbstractDatatype => return preStmtAbstractDatatype(ctx, o)
        case o: Stmt.Rich => return preStmtRich(ctx, o)
        case o: Stmt.TypeAlias => return preStmtTypeAlias(ctx, o)
        case o: Stmt.Assign => return preStmtAssign(ctx, o)
        case o: Stmt.AssignUp => return preStmtAssignUp(ctx, o)
        case o: Stmt.AssignPattern => return preStmtAssignPattern(ctx, o)
        case o: Stmt.Block => return preStmtBlock(ctx, o)
        case o: Stmt.If => return preStmtIf(ctx, o)
        case o: Stmt.Match => return preStmtMatch(ctx, o)
        case o: Stmt.While => return preStmtWhile(ctx, o)
        case o: Stmt.DoWhile => return preStmtDoWhile(ctx, o)
        case o: Stmt.For => return preStmtFor(ctx, o)
        case o: Stmt.Return => return preStmtReturn(ctx, o)
        case o: Stmt.LStmt => return preStmtLStmt(ctx, o)
        case o: Stmt.Expr => return preStmtExpr(ctx, o)
      }
    }

    @pure def preStmtImport(ctx: Context, o: Stmt.Import): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtImportImporter(ctx: Context, o: Stmt.Import.Importer): PreResult[Context, Stmt.Import.Importer] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtImportSelector(ctx: Context, o: Stmt.Import.Selector): PreResult[Context, Stmt.Import.Selector] = {
      o match {
        case o: Stmt.Import.MultiSelector => return preStmtImportMultiSelector(ctx, o)
        case o: Stmt.Import.WildcardSelector => return preStmtImportWildcardSelector(ctx, o)
      }
    }

    @pure def preStmtImportMultiSelector(ctx: Context, o: Stmt.Import.MultiSelector): PreResult[Context, Stmt.Import.Selector] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtImportWildcardSelector(ctx: Context, o: Stmt.Import.WildcardSelector): PreResult[Context, Stmt.Import.Selector] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtImportNamedSelector(ctx: Context, o: Stmt.Import.NamedSelector): PreResult[Context, Stmt.Import.NamedSelector] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtVar(ctx: Context, o: Stmt.Var): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtVarPattern(ctx: Context, o: Stmt.VarPattern): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtSpecVar(ctx: Context, o: Stmt.SpecVar): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtMethod(ctx: Context, o: Stmt.Method): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtExtMethod(ctx: Context, o: Stmt.ExtMethod): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtSpecMethod(ctx: Context, o: Stmt.SpecMethod): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtEnum(ctx: Context, o: Stmt.Enum): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtSubZ(ctx: Context, o: Stmt.SubZ): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtObject(ctx: Context, o: Stmt.Object): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtSig(ctx: Context, o: Stmt.Sig): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtAbstractDatatype(ctx: Context, o: Stmt.AbstractDatatype): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtRich(ctx: Context, o: Stmt.Rich): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtTypeAlias(ctx: Context, o: Stmt.TypeAlias): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtAssign(ctx: Context, o: Stmt.Assign): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtAssignUp(ctx: Context, o: Stmt.AssignUp): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtAssignPattern(ctx: Context, o: Stmt.AssignPattern): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtBlock(ctx: Context, o: Stmt.Block): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtIf(ctx: Context, o: Stmt.If): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtMatch(ctx: Context, o: Stmt.Match): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtWhile(ctx: Context, o: Stmt.While): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtDoWhile(ctx: Context, o: Stmt.DoWhile): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtFor(ctx: Context, o: Stmt.For): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtReturn(ctx: Context, o: Stmt.Return): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtLStmt(ctx: Context, o: Stmt.LStmt): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preStmtExpr(ctx: Context, o: Stmt.Expr): PreResult[Context, Stmt] = {
      return PreResult(ctx, T, None())
    }

    @pure def preLClause(ctx: Context, o: LClause): PreResult[Context, LClause] = {
      o match {
        case o: LClause.Invariants => return preLClauseInvariants(ctx, o)
        case o: LClause.Facts => return preLClauseFacts(ctx, o)
        case o: LClause.Theorems => return preLClauseTheorems(ctx, o)
        case o: LClause.Sequent => return preLClauseSequent(ctx, o)
        case o: LClause.Proof => return preLClauseProof(ctx, o)
      }
    }

    @pure def preLClauseInvariants(ctx: Context, o: LClause.Invariants): PreResult[Context, LClause] = {
      return PreResult(ctx, T, None())
    }

    @pure def preLClauseFacts(ctx: Context, o: LClause.Facts): PreResult[Context, LClause] = {
      return PreResult(ctx, T, None())
    }

    @pure def preLClauseFact(ctx: Context, o: LClause.Fact): PreResult[Context, LClause.Fact] = {
      return PreResult(ctx, T, None())
    }

    @pure def preLClauseTheorems(ctx: Context, o: LClause.Theorems): PreResult[Context, LClause] = {
      return PreResult(ctx, T, None())
    }

    @pure def preLClauseTheorem(ctx: Context, o: LClause.Theorem): PreResult[Context, LClause.Theorem] = {
      return PreResult(ctx, T, None())
    }

    @pure def preLClauseSequent(ctx: Context, o: LClause.Sequent): PreResult[Context, LClause] = {
      return PreResult(ctx, T, None())
    }

    @pure def preLClauseProof(ctx: Context, o: LClause.Proof): PreResult[Context, LClause] = {
      return PreResult(ctx, T, None())
    }

    @pure def preContractExp(ctx: Context, o: ContractExp): PreResult[Context, ContractExp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preCase(ctx: Context, o: Case): PreResult[Context, Case] = {
      return PreResult(ctx, T, None())
    }

    @pure def preEnumGenRange(ctx: Context, o: EnumGen.Range): PreResult[Context, EnumGen.Range] = {
      o match {
        case o: EnumGen.Range.Expr => return preEnumGenRangeExpr(ctx, o)
        case o: EnumGen.Range.Indices => return preEnumGenRangeIndices(ctx, o)
        case o: EnumGen.Range.Step => return preEnumGenRangeStep(ctx, o)
      }
    }

    @pure def preEnumGenRangeExpr(ctx: Context, o: EnumGen.Range.Expr): PreResult[Context, EnumGen.Range] = {
      return PreResult(ctx, T, None())
    }

    @pure def preEnumGenRangeIndices(ctx: Context, o: EnumGen.Range.Indices): PreResult[Context, EnumGen.Range] = {
      return PreResult(ctx, T, None())
    }

    @pure def preEnumGenRangeStep(ctx: Context, o: EnumGen.Range.Step): PreResult[Context, EnumGen.Range] = {
      return PreResult(ctx, T, None())
    }

    @pure def preEnumGenFor(ctx: Context, o: EnumGen.For): PreResult[Context, EnumGen.For] = {
      return PreResult(ctx, T, None())
    }

    @pure def preType(ctx: Context, o: Type): PreResult[Context, Type] = {
      o match {
        case o: Type.Named => return preTypeNamed(ctx, o)
        case o: Type.Fun => return preTypeFun(ctx, o)
        case o: Type.Tuple => return preTypeTuple(ctx, o)
      }
    }

    @pure def preTypeNamed(ctx: Context, o: Type.Named): PreResult[Context, Type] = {
      return PreResult(ctx, T, None())
    }

    @pure def preTypeFun(ctx: Context, o: Type.Fun): PreResult[Context, Type] = {
      return PreResult(ctx, T, None())
    }

    @pure def preTypeTuple(ctx: Context, o: Type.Tuple): PreResult[Context, Type] = {
      return PreResult(ctx, T, None())
    }

    @pure def prePattern(ctx: Context, o: Pattern): PreResult[Context, Pattern] = {
      o match {
        case o: Pattern.Literal => return prePatternLiteral(ctx, o)
        case o: Pattern.Ref => return prePatternRef(ctx, o)
        case o: Pattern.Variable => return prePatternVariable(ctx, o)
        case o: Pattern.Wildcard => return prePatternWildcard(ctx, o)
        case o: Pattern.SeqWildcard => return prePatternSeqWildcard(ctx, o)
        case o: Pattern.Structure => return prePatternStructure(ctx, o)
      }
    }

    @pure def prePatternLiteral(ctx: Context, o: Pattern.Literal): PreResult[Context, Pattern] = {
      return PreResult(ctx, T, None())
    }

    @pure def prePatternRef(ctx: Context, o: Pattern.Ref): PreResult[Context, Pattern] = {
      return PreResult(ctx, T, None())
    }

    @pure def prePatternVariable(ctx: Context, o: Pattern.Variable): PreResult[Context, Pattern] = {
      return PreResult(ctx, T, None())
    }

    @pure def prePatternWildcard(ctx: Context, o: Pattern.Wildcard): PreResult[Context, Pattern] = {
      return PreResult(ctx, T, None())
    }

    @pure def prePatternSeqWildcard(ctx: Context, o: Pattern.SeqWildcard): PreResult[Context, Pattern] = {
      return PreResult(ctx, T, None())
    }

    @pure def prePatternStructure(ctx: Context, o: Pattern.Structure): PreResult[Context, Pattern] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExp(ctx: Context, o: Exp): PreResult[Context, Exp] = {
      o match {
        case o: Exp.LitB => return preExpLitB(ctx, o)
        case o: Exp.LitC => return preExpLitC(ctx, o)
        case o: Exp.LitZ => return preExpLitZ(ctx, o)
        case o: Exp.LitZ8 => return preExpLitZ8(ctx, o)
        case o: Exp.LitZ16 => return preExpLitZ16(ctx, o)
        case o: Exp.LitZ32 => return preExpLitZ32(ctx, o)
        case o: Exp.LitZ64 => return preExpLitZ64(ctx, o)
        case o: Exp.LitN => return preExpLitN(ctx, o)
        case o: Exp.LitN8 => return preExpLitN8(ctx, o)
        case o: Exp.LitN16 => return preExpLitN16(ctx, o)
        case o: Exp.LitN32 => return preExpLitN32(ctx, o)
        case o: Exp.LitN64 => return preExpLitN64(ctx, o)
        case o: Exp.LitS8 => return preExpLitS8(ctx, o)
        case o: Exp.LitS16 => return preExpLitS16(ctx, o)
        case o: Exp.LitS32 => return preExpLitS32(ctx, o)
        case o: Exp.LitS64 => return preExpLitS64(ctx, o)
        case o: Exp.LitU8 => return preExpLitU8(ctx, o)
        case o: Exp.LitU16 => return preExpLitU16(ctx, o)
        case o: Exp.LitU32 => return preExpLitU32(ctx, o)
        case o: Exp.LitU64 => return preExpLitU64(ctx, o)
        case o: Exp.LitF32 => return preExpLitF32(ctx, o)
        case o: Exp.LitF64 => return preExpLitF64(ctx, o)
        case o: Exp.LitR => return preExpLitR(ctx, o)
        case o: Exp.LitBv => return preExpLitBv(ctx, o)
        case o: Exp.LitString => return preExpLitString(ctx, o)
        case o: Exp.StringInterpolate => return preExpStringInterpolate(ctx, o)
        case o: Exp.This => return preExpThis(ctx, o)
        case o: Exp.Super => return preExpSuper(ctx, o)
        case o: Exp.Unary => return preExpUnary(ctx, o)
        case o: Exp.Binary => return preExpBinary(ctx, o)
        case o: Exp.Ident => return preExpIdent(ctx, o)
        case o: Exp.Eta => return preExpEta(ctx, o)
        case o: Exp.Tuple => return preExpTuple(ctx, o)
        case o: Exp.Select => return preExpSelect(ctx, o)
        case o: Exp.Invoke => return preExpInvoke(ctx, o)
        case o: Exp.InvokeNamed => return preExpInvokeNamed(ctx, o)
        case o: Exp.If => return preExpIf(ctx, o)
        case o: Exp.Fun => return preExpFun(ctx, o)
        case o: Exp.ForYield => return preExpForYield(ctx, o)
        case o: Exp.Quant => return preExpQuant(ctx, o)
      }
    }

    @pure def preExpLitB(ctx: Context, o: Exp.LitB): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitC(ctx: Context, o: Exp.LitC): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitZ(ctx: Context, o: Exp.LitZ): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitZ8(ctx: Context, o: Exp.LitZ8): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitZ16(ctx: Context, o: Exp.LitZ16): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitZ32(ctx: Context, o: Exp.LitZ32): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitZ64(ctx: Context, o: Exp.LitZ64): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitN(ctx: Context, o: Exp.LitN): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitN8(ctx: Context, o: Exp.LitN8): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitN16(ctx: Context, o: Exp.LitN16): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitN32(ctx: Context, o: Exp.LitN32): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitN64(ctx: Context, o: Exp.LitN64): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitS8(ctx: Context, o: Exp.LitS8): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitS16(ctx: Context, o: Exp.LitS16): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitS32(ctx: Context, o: Exp.LitS32): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitS64(ctx: Context, o: Exp.LitS64): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitU8(ctx: Context, o: Exp.LitU8): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitU16(ctx: Context, o: Exp.LitU16): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitU32(ctx: Context, o: Exp.LitU32): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitU64(ctx: Context, o: Exp.LitU64): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitF32(ctx: Context, o: Exp.LitF32): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitF64(ctx: Context, o: Exp.LitF64): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitR(ctx: Context, o: Exp.LitR): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitBv(ctx: Context, o: Exp.LitBv): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpLitString(ctx: Context, o: Exp.LitString): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpStringInterpolate(ctx: Context, o: Exp.StringInterpolate): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpThis(ctx: Context, o: Exp.This): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpSuper(ctx: Context, o: Exp.Super): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpUnary(ctx: Context, o: Exp.Unary): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpBinary(ctx: Context, o: Exp.Binary): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpIdent(ctx: Context, o: Exp.Ident): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpEta(ctx: Context, o: Exp.Eta): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpTuple(ctx: Context, o: Exp.Tuple): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpSelect(ctx: Context, o: Exp.Select): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpInvoke(ctx: Context, o: Exp.Invoke): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpInvokeNamed(ctx: Context, o: Exp.InvokeNamed): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpIf(ctx: Context, o: Exp.If): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpFun(ctx: Context, o: Exp.Fun): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpForYield(ctx: Context, o: Exp.ForYield): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preExpQuant(ctx: Context, o: Exp.Quant): PreResult[Context, Exp] = {
      return PreResult(ctx, T, None())
    }

    @pure def preNamedArg(ctx: Context, o: NamedArg): PreResult[Context, NamedArg] = {
      return PreResult(ctx, T, None())
    }

    @pure def preVarFragment(ctx: Context, o: VarFragment): PreResult[Context, VarFragment] = {
      return PreResult(ctx, T, None())
    }

    @pure def preDomain(ctx: Context, o: Domain): PreResult[Context, Domain] = {
      o match {
        case o: Domain.Type => return preDomainType(ctx, o)
        case o: Domain.Range => return preDomainRange(ctx, o)
      }
    }

    @pure def preDomainType(ctx: Context, o: Domain.Type): PreResult[Context, Domain] = {
      return PreResult(ctx, T, None())
    }

    @pure def preDomainRange(ctx: Context, o: Domain.Range): PreResult[Context, Domain] = {
      return PreResult(ctx, T, None())
    }

    @pure def preId(ctx: Context, o: Id): PreResult[Context, Id] = {
      return PreResult(ctx, T, None())
    }

    @pure def preName(ctx: Context, o: Name): PreResult[Context, Name] = {
      return PreResult(ctx, T, None())
    }

    @pure def preBody(ctx: Context, o: Body): PreResult[Context, Body] = {
      return PreResult(ctx, T, None())
    }

    @pure def preAbstractDatatypeParam(ctx: Context, o: AbstractDatatypeParam): PreResult[Context, AbstractDatatypeParam] = {
      return PreResult(ctx, T, None())
    }

    @pure def preMethodSig(ctx: Context, o: MethodSig): PreResult[Context, MethodSig] = {
      return PreResult(ctx, T, None())
    }

    @pure def preParam(ctx: Context, o: Param): PreResult[Context, Param] = {
      return PreResult(ctx, T, None())
    }

    @pure def preTypeParam(ctx: Context, o: TypeParam): PreResult[Context, TypeParam] = {
      return PreResult(ctx, T, None())
    }

    @pure def preContract(ctx: Context, o: Contract): PreResult[Context, Contract] = {
      return PreResult(ctx, T, None())
    }

    @pure def preSubContract(ctx: Context, o: SubContract): PreResult[Context, SubContract] = {
      return PreResult(ctx, T, None())
    }

    @pure def preSubContractParam(ctx: Context, o: SubContractParam): PreResult[Context, SubContractParam] = {
      return PreResult(ctx, T, None())
    }

    @pure def preWhereDef(ctx: Context, o: WhereDef): PreResult[Context, WhereDef] = {
      o match {
        case o: WhereDef.Val => return preWhereDefVal(ctx, o)
        case o: WhereDef.Def => return preWhereDefDef(ctx, o)
      }
    }

    @pure def preWhereDefVal(ctx: Context, o: WhereDef.Val): PreResult[Context, WhereDef] = {
      return PreResult(ctx, T, None())
    }

    @pure def preWhereDefDef(ctx: Context, o: WhereDef.Def): PreResult[Context, WhereDef] = {
      return PreResult(ctx, T, None())
    }

    @pure def preSpecDef(ctx: Context, o: SpecDef): PreResult[Context, SpecDef] = {
      return PreResult(ctx, T, None())
    }

    @pure def preProofStep(ctx: Context, o: ProofStep): PreResult[Context, ProofStep] = {
      o match {
        case o: ProofStep.Basic => return preProofStepBasic(ctx, o)
        case o: ProofStep.SubProof => return preProofStepSubProof(ctx, o)
      }
    }

    @pure def preProofStepBasic(ctx: Context, o: ProofStep.Basic): PreResult[Context, ProofStep] = {
      return PreResult(ctx, T, None())
    }

    @pure def preProofStepSubProof(ctx: Context, o: ProofStep.SubProof): PreResult[Context, ProofStep] = {
      return PreResult(ctx, T, None())
    }

    @pure def preAssumeProofStep(ctx: Context, o: AssumeProofStep): PreResult[Context, AssumeProofStep] = {
      o match {
        case o: AssumeProofStep.Regular => return preAssumeProofStepRegular(ctx, o)
        case o: AssumeProofStep.ForallIntroAps => return preAssumeProofStepForallIntroAps(ctx, o)
        case o: AssumeProofStep.ExistsElimAps => return preAssumeProofStepExistsElimAps(ctx, o)
      }
    }

    @pure def preAssumeProofStepRegular(ctx: Context, o: AssumeProofStep.Regular): PreResult[Context, AssumeProofStep] = {
      return PreResult(ctx, T, None())
    }

    @pure def preAssumeProofStepForallIntroAps(ctx: Context, o: AssumeProofStep.ForallIntroAps): PreResult[Context, AssumeProofStep] = {
      return PreResult(ctx, T, None())
    }

    @pure def preAssumeProofStepExistsElimAps(ctx: Context, o: AssumeProofStep.ExistsElimAps): PreResult[Context, AssumeProofStep] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJust(ctx: Context, o: Just): PreResult[Context, Just] = {
      o match {
        case o: Just.Premise => return preJustPremise(ctx, o)
        case o: Just.AndIntro => return preJustAndIntro(ctx, o)
        case o: Just.AndElim => return preJustAndElim(ctx, o)
        case o: Just.OrIntro => return preJustOrIntro(ctx, o)
        case o: Just.OrElim => return preJustOrElim(ctx, o)
        case o: Just.ImplyIntro => return preJustImplyIntro(ctx, o)
        case o: Just.ImplyElim => return preJustImplyElim(ctx, o)
        case o: Just.NegIntro => return preJustNegIntro(ctx, o)
        case o: Just.NegElim => return preJustNegElim(ctx, o)
        case o: Just.BottomElim => return preJustBottomElim(ctx, o)
        case o: Just.Pbc => return preJustPbc(ctx, o)
        case o: Just.ForallIntro => return preJustForallIntro(ctx, o)
        case o: Just.ForallElim => return preJustForallElim(ctx, o)
        case o: Just.ExistsIntro => return preJustExistsIntro(ctx, o)
        case o: Just.ExistsElim => return preJustExistsElim(ctx, o)
        case o: Just.Fact => return preJustFact(ctx, o)
        case o: Just.Invariant => return preJustInvariant(ctx, o)
        case o: Just.Subst => return preJustSubst(ctx, o)
        case o: Just.Auto => return preJustAuto(ctx, o)
        case o: Just.Coq => return preJustCoq(ctx, o)
      }
    }

    @pure def preJustPremise(ctx: Context, o: Just.Premise): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJustAndIntro(ctx: Context, o: Just.AndIntro): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJustAndElim(ctx: Context, o: Just.AndElim): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJustOrIntro(ctx: Context, o: Just.OrIntro): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJustOrElim(ctx: Context, o: Just.OrElim): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJustImplyIntro(ctx: Context, o: Just.ImplyIntro): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJustImplyElim(ctx: Context, o: Just.ImplyElim): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJustNegIntro(ctx: Context, o: Just.NegIntro): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJustNegElim(ctx: Context, o: Just.NegElim): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJustBottomElim(ctx: Context, o: Just.BottomElim): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJustPbc(ctx: Context, o: Just.Pbc): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJustForallIntro(ctx: Context, o: Just.ForallIntro): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJustForallElim(ctx: Context, o: Just.ForallElim): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJustExistsIntro(ctx: Context, o: Just.ExistsIntro): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJustExistsElim(ctx: Context, o: Just.ExistsElim): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJustFact(ctx: Context, o: Just.Fact): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJustInvariant(ctx: Context, o: Just.Invariant): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJustSubst(ctx: Context, o: Just.Subst): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJustAuto(ctx: Context, o: Just.Auto): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preJustCoq(ctx: Context, o: Just.Coq): PreResult[Context, Just] = {
      return PreResult(ctx, T, None())
    }

    @pure def preTruthTableRow(ctx: Context, o: TruthTable.Row): PreResult[Context, TruthTable.Row] = {
      return PreResult(ctx, T, None())
    }

    @pure def preTruthTableAssignment(ctx: Context, o: TruthTable.Assignment): PreResult[Context, TruthTable.Assignment] = {
      return PreResult(ctx, T, None())
    }

    @pure def preTruthTableConclusion(ctx: Context, o: TruthTable.Conclusion): PreResult[Context, TruthTable.Conclusion] = {
      o match {
        case o: TruthTable.Conclusion.Validity => return preTruthTableConclusionValidity(ctx, o)
        case o: TruthTable.Conclusion.Tautology => return preTruthTableConclusionTautology(ctx, o)
        case o: TruthTable.Conclusion.Contradictory => return preTruthTableConclusionContradictory(ctx, o)
        case o: TruthTable.Conclusion.Contingent => return preTruthTableConclusionContingent(ctx, o)
      }
    }

    @pure def preTruthTableConclusionValidity(ctx: Context, o: TruthTable.Conclusion.Validity): PreResult[Context, TruthTable.Conclusion] = {
      return PreResult(ctx, T, None())
    }

    @pure def preTruthTableConclusionTautology(ctx: Context, o: TruthTable.Conclusion.Tautology): PreResult[Context, TruthTable.Conclusion] = {
      return PreResult(ctx, T, None())
    }

    @pure def preTruthTableConclusionContradictory(ctx: Context, o: TruthTable.Conclusion.Contradictory): PreResult[Context, TruthTable.Conclusion] = {
      return PreResult(ctx, T, None())
    }

    @pure def preTruthTableConclusionContingent(ctx: Context, o: TruthTable.Conclusion.Contingent): PreResult[Context, TruthTable.Conclusion] = {
      return PreResult(ctx, T, None())
    }

    @pure def preAttr(ctx: Context, o: Attr): PreResult[Context, Attr] = {
      return PreResult(ctx, T, None())
    }

    @pure def preTypedAttr(ctx: Context, o: TypedAttr): PreResult[Context, TypedAttr] = {
      return PreResult(ctx, T, None())
    }

    @pure def preResolvedAttr(ctx: Context, o: ResolvedAttr): PreResult[Context, ResolvedAttr] = {
      return PreResult(ctx, T, None())
    }

    @pure def preResolvedInfo(ctx: Context, o: ResolvedInfo): PreResult[Context, ResolvedInfo] = {
      return PreResult(ctx, T, None())
    }

    @pure def prePosInfo(ctx: Context, o: PosInfo): PreResult[Context, PosInfo] = {
      return PreResult(ctx, T, None())
    }

    @pure def postTopUnit(ctx: Context, o: TopUnit): Result[Context, TopUnit] = {
      o match {
        case o: TopUnit.Program => return postTopUnitProgram(ctx, o)
        case o: TopUnit.SequentUnit => return postTopUnitSequentUnit(ctx, o)
        case o: TopUnit.TruthTableUnit => return postTopUnitTruthTableUnit(ctx, o)
      }
    }

    @pure def postTopUnitProgram(ctx: Context, o: TopUnit.Program): Result[Context, TopUnit] = {
      return Result(ctx, None())
    }

    @pure def postTopUnitSequentUnit(ctx: Context, o: TopUnit.SequentUnit): Result[Context, TopUnit] = {
      return Result(ctx, None())
    }

    @pure def postTopUnitTruthTableUnit(ctx: Context, o: TopUnit.TruthTableUnit): Result[Context, TopUnit] = {
      return Result(ctx, None())
    }

    @pure def postStmt(ctx: Context, o: Stmt): Result[Context, Stmt] = {
      o match {
        case o: Stmt.Import => return postStmtImport(ctx, o)
        case o: Stmt.Var => return postStmtVar(ctx, o)
        case o: Stmt.VarPattern => return postStmtVarPattern(ctx, o)
        case o: Stmt.SpecVar => return postStmtSpecVar(ctx, o)
        case o: Stmt.Method => return postStmtMethod(ctx, o)
        case o: Stmt.ExtMethod => return postStmtExtMethod(ctx, o)
        case o: Stmt.SpecMethod => return postStmtSpecMethod(ctx, o)
        case o: Stmt.Enum => return postStmtEnum(ctx, o)
        case o: Stmt.SubZ => return postStmtSubZ(ctx, o)
        case o: Stmt.Object => return postStmtObject(ctx, o)
        case o: Stmt.Sig => return postStmtSig(ctx, o)
        case o: Stmt.AbstractDatatype => return postStmtAbstractDatatype(ctx, o)
        case o: Stmt.Rich => return postStmtRich(ctx, o)
        case o: Stmt.TypeAlias => return postStmtTypeAlias(ctx, o)
        case o: Stmt.Assign => return postStmtAssign(ctx, o)
        case o: Stmt.AssignUp => return postStmtAssignUp(ctx, o)
        case o: Stmt.AssignPattern => return postStmtAssignPattern(ctx, o)
        case o: Stmt.Block => return postStmtBlock(ctx, o)
        case o: Stmt.If => return postStmtIf(ctx, o)
        case o: Stmt.Match => return postStmtMatch(ctx, o)
        case o: Stmt.While => return postStmtWhile(ctx, o)
        case o: Stmt.DoWhile => return postStmtDoWhile(ctx, o)
        case o: Stmt.For => return postStmtFor(ctx, o)
        case o: Stmt.Return => return postStmtReturn(ctx, o)
        case o: Stmt.LStmt => return postStmtLStmt(ctx, o)
        case o: Stmt.Expr => return postStmtExpr(ctx, o)
      }
    }

    @pure def postStmtImport(ctx: Context, o: Stmt.Import): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtImportImporter(ctx: Context, o: Stmt.Import.Importer): Result[Context, Stmt.Import.Importer] = {
      return Result(ctx, None())
    }

    @pure def postStmtImportSelector(ctx: Context, o: Stmt.Import.Selector): Result[Context, Stmt.Import.Selector] = {
      o match {
        case o: Stmt.Import.MultiSelector => return postStmtImportMultiSelector(ctx, o)
        case o: Stmt.Import.WildcardSelector => return postStmtImportWildcardSelector(ctx, o)
      }
    }

    @pure def postStmtImportMultiSelector(ctx: Context, o: Stmt.Import.MultiSelector): Result[Context, Stmt.Import.Selector] = {
      return Result(ctx, None())
    }

    @pure def postStmtImportWildcardSelector(ctx: Context, o: Stmt.Import.WildcardSelector): Result[Context, Stmt.Import.Selector] = {
      return Result(ctx, None())
    }

    @pure def postStmtImportNamedSelector(ctx: Context, o: Stmt.Import.NamedSelector): Result[Context, Stmt.Import.NamedSelector] = {
      return Result(ctx, None())
    }

    @pure def postStmtVar(ctx: Context, o: Stmt.Var): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtVarPattern(ctx: Context, o: Stmt.VarPattern): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtSpecVar(ctx: Context, o: Stmt.SpecVar): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtMethod(ctx: Context, o: Stmt.Method): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtExtMethod(ctx: Context, o: Stmt.ExtMethod): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtSpecMethod(ctx: Context, o: Stmt.SpecMethod): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtEnum(ctx: Context, o: Stmt.Enum): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtSubZ(ctx: Context, o: Stmt.SubZ): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtObject(ctx: Context, o: Stmt.Object): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtSig(ctx: Context, o: Stmt.Sig): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtAbstractDatatype(ctx: Context, o: Stmt.AbstractDatatype): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtRich(ctx: Context, o: Stmt.Rich): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtTypeAlias(ctx: Context, o: Stmt.TypeAlias): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtAssign(ctx: Context, o: Stmt.Assign): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtAssignUp(ctx: Context, o: Stmt.AssignUp): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtAssignPattern(ctx: Context, o: Stmt.AssignPattern): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtBlock(ctx: Context, o: Stmt.Block): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtIf(ctx: Context, o: Stmt.If): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtMatch(ctx: Context, o: Stmt.Match): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtWhile(ctx: Context, o: Stmt.While): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtDoWhile(ctx: Context, o: Stmt.DoWhile): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtFor(ctx: Context, o: Stmt.For): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtReturn(ctx: Context, o: Stmt.Return): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtLStmt(ctx: Context, o: Stmt.LStmt): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postStmtExpr(ctx: Context, o: Stmt.Expr): Result[Context, Stmt] = {
      return Result(ctx, None())
    }

    @pure def postLClause(ctx: Context, o: LClause): Result[Context, LClause] = {
      o match {
        case o: LClause.Invariants => return postLClauseInvariants(ctx, o)
        case o: LClause.Facts => return postLClauseFacts(ctx, o)
        case o: LClause.Theorems => return postLClauseTheorems(ctx, o)
        case o: LClause.Sequent => return postLClauseSequent(ctx, o)
        case o: LClause.Proof => return postLClauseProof(ctx, o)
      }
    }

    @pure def postLClauseInvariants(ctx: Context, o: LClause.Invariants): Result[Context, LClause] = {
      return Result(ctx, None())
    }

    @pure def postLClauseFacts(ctx: Context, o: LClause.Facts): Result[Context, LClause] = {
      return Result(ctx, None())
    }

    @pure def postLClauseFact(ctx: Context, o: LClause.Fact): Result[Context, LClause.Fact] = {
      return Result(ctx, None())
    }

    @pure def postLClauseTheorems(ctx: Context, o: LClause.Theorems): Result[Context, LClause] = {
      return Result(ctx, None())
    }

    @pure def postLClauseTheorem(ctx: Context, o: LClause.Theorem): Result[Context, LClause.Theorem] = {
      return Result(ctx, None())
    }

    @pure def postLClauseSequent(ctx: Context, o: LClause.Sequent): Result[Context, LClause] = {
      return Result(ctx, None())
    }

    @pure def postLClauseProof(ctx: Context, o: LClause.Proof): Result[Context, LClause] = {
      return Result(ctx, None())
    }

    @pure def postContractExp(ctx: Context, o: ContractExp): Result[Context, ContractExp] = {
      return Result(ctx, None())
    }

    @pure def postCase(ctx: Context, o: Case): Result[Context, Case] = {
      return Result(ctx, None())
    }

    @pure def postEnumGenRange(ctx: Context, o: EnumGen.Range): Result[Context, EnumGen.Range] = {
      o match {
        case o: EnumGen.Range.Expr => return postEnumGenRangeExpr(ctx, o)
        case o: EnumGen.Range.Indices => return postEnumGenRangeIndices(ctx, o)
        case o: EnumGen.Range.Step => return postEnumGenRangeStep(ctx, o)
      }
    }

    @pure def postEnumGenRangeExpr(ctx: Context, o: EnumGen.Range.Expr): Result[Context, EnumGen.Range] = {
      return Result(ctx, None())
    }

    @pure def postEnumGenRangeIndices(ctx: Context, o: EnumGen.Range.Indices): Result[Context, EnumGen.Range] = {
      return Result(ctx, None())
    }

    @pure def postEnumGenRangeStep(ctx: Context, o: EnumGen.Range.Step): Result[Context, EnumGen.Range] = {
      return Result(ctx, None())
    }

    @pure def postEnumGenFor(ctx: Context, o: EnumGen.For): Result[Context, EnumGen.For] = {
      return Result(ctx, None())
    }

    @pure def postType(ctx: Context, o: Type): Result[Context, Type] = {
      o match {
        case o: Type.Named => return postTypeNamed(ctx, o)
        case o: Type.Fun => return postTypeFun(ctx, o)
        case o: Type.Tuple => return postTypeTuple(ctx, o)
      }
    }

    @pure def postTypeNamed(ctx: Context, o: Type.Named): Result[Context, Type] = {
      return Result(ctx, None())
    }

    @pure def postTypeFun(ctx: Context, o: Type.Fun): Result[Context, Type] = {
      return Result(ctx, None())
    }

    @pure def postTypeTuple(ctx: Context, o: Type.Tuple): Result[Context, Type] = {
      return Result(ctx, None())
    }

    @pure def postPattern(ctx: Context, o: Pattern): Result[Context, Pattern] = {
      o match {
        case o: Pattern.Literal => return postPatternLiteral(ctx, o)
        case o: Pattern.Ref => return postPatternRef(ctx, o)
        case o: Pattern.Variable => return postPatternVariable(ctx, o)
        case o: Pattern.Wildcard => return postPatternWildcard(ctx, o)
        case o: Pattern.SeqWildcard => return postPatternSeqWildcard(ctx, o)
        case o: Pattern.Structure => return postPatternStructure(ctx, o)
      }
    }

    @pure def postPatternLiteral(ctx: Context, o: Pattern.Literal): Result[Context, Pattern] = {
      return Result(ctx, None())
    }

    @pure def postPatternRef(ctx: Context, o: Pattern.Ref): Result[Context, Pattern] = {
      return Result(ctx, None())
    }

    @pure def postPatternVariable(ctx: Context, o: Pattern.Variable): Result[Context, Pattern] = {
      return Result(ctx, None())
    }

    @pure def postPatternWildcard(ctx: Context, o: Pattern.Wildcard): Result[Context, Pattern] = {
      return Result(ctx, None())
    }

    @pure def postPatternSeqWildcard(ctx: Context, o: Pattern.SeqWildcard): Result[Context, Pattern] = {
      return Result(ctx, None())
    }

    @pure def postPatternStructure(ctx: Context, o: Pattern.Structure): Result[Context, Pattern] = {
      return Result(ctx, None())
    }

    @pure def postExp(ctx: Context, o: Exp): Result[Context, Exp] = {
      o match {
        case o: Exp.LitB => return postExpLitB(ctx, o)
        case o: Exp.LitC => return postExpLitC(ctx, o)
        case o: Exp.LitZ => return postExpLitZ(ctx, o)
        case o: Exp.LitZ8 => return postExpLitZ8(ctx, o)
        case o: Exp.LitZ16 => return postExpLitZ16(ctx, o)
        case o: Exp.LitZ32 => return postExpLitZ32(ctx, o)
        case o: Exp.LitZ64 => return postExpLitZ64(ctx, o)
        case o: Exp.LitN => return postExpLitN(ctx, o)
        case o: Exp.LitN8 => return postExpLitN8(ctx, o)
        case o: Exp.LitN16 => return postExpLitN16(ctx, o)
        case o: Exp.LitN32 => return postExpLitN32(ctx, o)
        case o: Exp.LitN64 => return postExpLitN64(ctx, o)
        case o: Exp.LitS8 => return postExpLitS8(ctx, o)
        case o: Exp.LitS16 => return postExpLitS16(ctx, o)
        case o: Exp.LitS32 => return postExpLitS32(ctx, o)
        case o: Exp.LitS64 => return postExpLitS64(ctx, o)
        case o: Exp.LitU8 => return postExpLitU8(ctx, o)
        case o: Exp.LitU16 => return postExpLitU16(ctx, o)
        case o: Exp.LitU32 => return postExpLitU32(ctx, o)
        case o: Exp.LitU64 => return postExpLitU64(ctx, o)
        case o: Exp.LitF32 => return postExpLitF32(ctx, o)
        case o: Exp.LitF64 => return postExpLitF64(ctx, o)
        case o: Exp.LitR => return postExpLitR(ctx, o)
        case o: Exp.LitBv => return postExpLitBv(ctx, o)
        case o: Exp.LitString => return postExpLitString(ctx, o)
        case o: Exp.StringInterpolate => return postExpStringInterpolate(ctx, o)
        case o: Exp.This => return postExpThis(ctx, o)
        case o: Exp.Super => return postExpSuper(ctx, o)
        case o: Exp.Unary => return postExpUnary(ctx, o)
        case o: Exp.Binary => return postExpBinary(ctx, o)
        case o: Exp.Ident => return postExpIdent(ctx, o)
        case o: Exp.Eta => return postExpEta(ctx, o)
        case o: Exp.Tuple => return postExpTuple(ctx, o)
        case o: Exp.Select => return postExpSelect(ctx, o)
        case o: Exp.Invoke => return postExpInvoke(ctx, o)
        case o: Exp.InvokeNamed => return postExpInvokeNamed(ctx, o)
        case o: Exp.If => return postExpIf(ctx, o)
        case o: Exp.Fun => return postExpFun(ctx, o)
        case o: Exp.ForYield => return postExpForYield(ctx, o)
        case o: Exp.Quant => return postExpQuant(ctx, o)
      }
    }

    @pure def postExpLitB(ctx: Context, o: Exp.LitB): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitC(ctx: Context, o: Exp.LitC): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitZ(ctx: Context, o: Exp.LitZ): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitZ8(ctx: Context, o: Exp.LitZ8): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitZ16(ctx: Context, o: Exp.LitZ16): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitZ32(ctx: Context, o: Exp.LitZ32): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitZ64(ctx: Context, o: Exp.LitZ64): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitN(ctx: Context, o: Exp.LitN): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitN8(ctx: Context, o: Exp.LitN8): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitN16(ctx: Context, o: Exp.LitN16): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitN32(ctx: Context, o: Exp.LitN32): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitN64(ctx: Context, o: Exp.LitN64): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitS8(ctx: Context, o: Exp.LitS8): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitS16(ctx: Context, o: Exp.LitS16): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitS32(ctx: Context, o: Exp.LitS32): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitS64(ctx: Context, o: Exp.LitS64): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitU8(ctx: Context, o: Exp.LitU8): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitU16(ctx: Context, o: Exp.LitU16): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitU32(ctx: Context, o: Exp.LitU32): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitU64(ctx: Context, o: Exp.LitU64): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitF32(ctx: Context, o: Exp.LitF32): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitF64(ctx: Context, o: Exp.LitF64): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitR(ctx: Context, o: Exp.LitR): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitBv(ctx: Context, o: Exp.LitBv): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpLitString(ctx: Context, o: Exp.LitString): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpStringInterpolate(ctx: Context, o: Exp.StringInterpolate): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpThis(ctx: Context, o: Exp.This): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpSuper(ctx: Context, o: Exp.Super): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpUnary(ctx: Context, o: Exp.Unary): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpBinary(ctx: Context, o: Exp.Binary): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpIdent(ctx: Context, o: Exp.Ident): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpEta(ctx: Context, o: Exp.Eta): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpTuple(ctx: Context, o: Exp.Tuple): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpSelect(ctx: Context, o: Exp.Select): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpInvoke(ctx: Context, o: Exp.Invoke): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpInvokeNamed(ctx: Context, o: Exp.InvokeNamed): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpIf(ctx: Context, o: Exp.If): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpFun(ctx: Context, o: Exp.Fun): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpForYield(ctx: Context, o: Exp.ForYield): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postExpQuant(ctx: Context, o: Exp.Quant): Result[Context, Exp] = {
      return Result(ctx, None())
    }

    @pure def postNamedArg(ctx: Context, o: NamedArg): Result[Context, NamedArg] = {
      return Result(ctx, None())
    }

    @pure def postVarFragment(ctx: Context, o: VarFragment): Result[Context, VarFragment] = {
      return Result(ctx, None())
    }

    @pure def postDomain(ctx: Context, o: Domain): Result[Context, Domain] = {
      o match {
        case o: Domain.Type => return postDomainType(ctx, o)
        case o: Domain.Range => return postDomainRange(ctx, o)
      }
    }

    @pure def postDomainType(ctx: Context, o: Domain.Type): Result[Context, Domain] = {
      return Result(ctx, None())
    }

    @pure def postDomainRange(ctx: Context, o: Domain.Range): Result[Context, Domain] = {
      return Result(ctx, None())
    }

    @pure def postId(ctx: Context, o: Id): Result[Context, Id] = {
      return Result(ctx, None())
    }

    @pure def postName(ctx: Context, o: Name): Result[Context, Name] = {
      return Result(ctx, None())
    }

    @pure def postBody(ctx: Context, o: Body): Result[Context, Body] = {
      return Result(ctx, None())
    }

    @pure def postAbstractDatatypeParam(ctx: Context, o: AbstractDatatypeParam): Result[Context, AbstractDatatypeParam] = {
      return Result(ctx, None())
    }

    @pure def postMethodSig(ctx: Context, o: MethodSig): Result[Context, MethodSig] = {
      return Result(ctx, None())
    }

    @pure def postParam(ctx: Context, o: Param): Result[Context, Param] = {
      return Result(ctx, None())
    }

    @pure def postTypeParam(ctx: Context, o: TypeParam): Result[Context, TypeParam] = {
      return Result(ctx, None())
    }

    @pure def postContract(ctx: Context, o: Contract): Result[Context, Contract] = {
      return Result(ctx, None())
    }

    @pure def postSubContract(ctx: Context, o: SubContract): Result[Context, SubContract] = {
      return Result(ctx, None())
    }

    @pure def postSubContractParam(ctx: Context, o: SubContractParam): Result[Context, SubContractParam] = {
      return Result(ctx, None())
    }

    @pure def postWhereDef(ctx: Context, o: WhereDef): Result[Context, WhereDef] = {
      o match {
        case o: WhereDef.Val => return postWhereDefVal(ctx, o)
        case o: WhereDef.Def => return postWhereDefDef(ctx, o)
      }
    }

    @pure def postWhereDefVal(ctx: Context, o: WhereDef.Val): Result[Context, WhereDef] = {
      return Result(ctx, None())
    }

    @pure def postWhereDefDef(ctx: Context, o: WhereDef.Def): Result[Context, WhereDef] = {
      return Result(ctx, None())
    }

    @pure def postSpecDef(ctx: Context, o: SpecDef): Result[Context, SpecDef] = {
      return Result(ctx, None())
    }

    @pure def postProofStep(ctx: Context, o: ProofStep): Result[Context, ProofStep] = {
      o match {
        case o: ProofStep.Basic => return postProofStepBasic(ctx, o)
        case o: ProofStep.SubProof => return postProofStepSubProof(ctx, o)
      }
    }

    @pure def postProofStepBasic(ctx: Context, o: ProofStep.Basic): Result[Context, ProofStep] = {
      return Result(ctx, None())
    }

    @pure def postProofStepSubProof(ctx: Context, o: ProofStep.SubProof): Result[Context, ProofStep] = {
      return Result(ctx, None())
    }

    @pure def postAssumeProofStep(ctx: Context, o: AssumeProofStep): Result[Context, AssumeProofStep] = {
      o match {
        case o: AssumeProofStep.Regular => return postAssumeProofStepRegular(ctx, o)
        case o: AssumeProofStep.ForallIntroAps => return postAssumeProofStepForallIntroAps(ctx, o)
        case o: AssumeProofStep.ExistsElimAps => return postAssumeProofStepExistsElimAps(ctx, o)
      }
    }

    @pure def postAssumeProofStepRegular(ctx: Context, o: AssumeProofStep.Regular): Result[Context, AssumeProofStep] = {
      return Result(ctx, None())
    }

    @pure def postAssumeProofStepForallIntroAps(ctx: Context, o: AssumeProofStep.ForallIntroAps): Result[Context, AssumeProofStep] = {
      return Result(ctx, None())
    }

    @pure def postAssumeProofStepExistsElimAps(ctx: Context, o: AssumeProofStep.ExistsElimAps): Result[Context, AssumeProofStep] = {
      return Result(ctx, None())
    }

    @pure def postJust(ctx: Context, o: Just): Result[Context, Just] = {
      o match {
        case o: Just.Premise => return postJustPremise(ctx, o)
        case o: Just.AndIntro => return postJustAndIntro(ctx, o)
        case o: Just.AndElim => return postJustAndElim(ctx, o)
        case o: Just.OrIntro => return postJustOrIntro(ctx, o)
        case o: Just.OrElim => return postJustOrElim(ctx, o)
        case o: Just.ImplyIntro => return postJustImplyIntro(ctx, o)
        case o: Just.ImplyElim => return postJustImplyElim(ctx, o)
        case o: Just.NegIntro => return postJustNegIntro(ctx, o)
        case o: Just.NegElim => return postJustNegElim(ctx, o)
        case o: Just.BottomElim => return postJustBottomElim(ctx, o)
        case o: Just.Pbc => return postJustPbc(ctx, o)
        case o: Just.ForallIntro => return postJustForallIntro(ctx, o)
        case o: Just.ForallElim => return postJustForallElim(ctx, o)
        case o: Just.ExistsIntro => return postJustExistsIntro(ctx, o)
        case o: Just.ExistsElim => return postJustExistsElim(ctx, o)
        case o: Just.Fact => return postJustFact(ctx, o)
        case o: Just.Invariant => return postJustInvariant(ctx, o)
        case o: Just.Subst => return postJustSubst(ctx, o)
        case o: Just.Auto => return postJustAuto(ctx, o)
        case o: Just.Coq => return postJustCoq(ctx, o)
      }
    }

    @pure def postJustPremise(ctx: Context, o: Just.Premise): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postJustAndIntro(ctx: Context, o: Just.AndIntro): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postJustAndElim(ctx: Context, o: Just.AndElim): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postJustOrIntro(ctx: Context, o: Just.OrIntro): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postJustOrElim(ctx: Context, o: Just.OrElim): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postJustImplyIntro(ctx: Context, o: Just.ImplyIntro): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postJustImplyElim(ctx: Context, o: Just.ImplyElim): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postJustNegIntro(ctx: Context, o: Just.NegIntro): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postJustNegElim(ctx: Context, o: Just.NegElim): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postJustBottomElim(ctx: Context, o: Just.BottomElim): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postJustPbc(ctx: Context, o: Just.Pbc): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postJustForallIntro(ctx: Context, o: Just.ForallIntro): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postJustForallElim(ctx: Context, o: Just.ForallElim): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postJustExistsIntro(ctx: Context, o: Just.ExistsIntro): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postJustExistsElim(ctx: Context, o: Just.ExistsElim): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postJustFact(ctx: Context, o: Just.Fact): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postJustInvariant(ctx: Context, o: Just.Invariant): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postJustSubst(ctx: Context, o: Just.Subst): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postJustAuto(ctx: Context, o: Just.Auto): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postJustCoq(ctx: Context, o: Just.Coq): Result[Context, Just] = {
      return Result(ctx, None())
    }

    @pure def postTruthTableRow(ctx: Context, o: TruthTable.Row): Result[Context, TruthTable.Row] = {
      return Result(ctx, None())
    }

    @pure def postTruthTableAssignment(ctx: Context, o: TruthTable.Assignment): Result[Context, TruthTable.Assignment] = {
      return Result(ctx, None())
    }

    @pure def postTruthTableConclusion(ctx: Context, o: TruthTable.Conclusion): Result[Context, TruthTable.Conclusion] = {
      o match {
        case o: TruthTable.Conclusion.Validity => return postTruthTableConclusionValidity(ctx, o)
        case o: TruthTable.Conclusion.Tautology => return postTruthTableConclusionTautology(ctx, o)
        case o: TruthTable.Conclusion.Contradictory => return postTruthTableConclusionContradictory(ctx, o)
        case o: TruthTable.Conclusion.Contingent => return postTruthTableConclusionContingent(ctx, o)
      }
    }

    @pure def postTruthTableConclusionValidity(ctx: Context, o: TruthTable.Conclusion.Validity): Result[Context, TruthTable.Conclusion] = {
      return Result(ctx, None())
    }

    @pure def postTruthTableConclusionTautology(ctx: Context, o: TruthTable.Conclusion.Tautology): Result[Context, TruthTable.Conclusion] = {
      return Result(ctx, None())
    }

    @pure def postTruthTableConclusionContradictory(ctx: Context, o: TruthTable.Conclusion.Contradictory): Result[Context, TruthTable.Conclusion] = {
      return Result(ctx, None())
    }

    @pure def postTruthTableConclusionContingent(ctx: Context, o: TruthTable.Conclusion.Contingent): Result[Context, TruthTable.Conclusion] = {
      return Result(ctx, None())
    }

    @pure def postAttr(ctx: Context, o: Attr): Result[Context, Attr] = {
      return Result(ctx, None())
    }

    @pure def postTypedAttr(ctx: Context, o: TypedAttr): Result[Context, TypedAttr] = {
      return Result(ctx, None())
    }

    @pure def postResolvedAttr(ctx: Context, o: ResolvedAttr): Result[Context, ResolvedAttr] = {
      return Result(ctx, None())
    }

    @pure def postResolvedInfo(ctx: Context, o: ResolvedInfo): Result[Context, ResolvedInfo] = {
      return Result(ctx, None())
    }

    @pure def postPosInfo(ctx: Context, o: PosInfo): Result[Context, PosInfo] = {
      return Result(ctx, None())
    }

  }

  @pure def transformISZ[Context, T](ctx: Context, s: IS[Z, T], f: (Context, T) => Result[Context, T]): Result[Context, IS[Z, T]] = {
    val s2: MS[Z, T] = s.toMS
    var changed: B = F
    var ctxi = ctx
    for (i <- s2.indices) {
      val e: T = s(i)
      val r: Result[Context, T] = f(ctxi, e)
      ctxi = r.ctx
      changed = changed || r.resultOpt.nonEmpty
      s2(i) = r.resultOpt.getOrElse(e)
    }
    if (changed) {
      return Result(ctxi, Some(s2.toIS))
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

@datatype class Transformer[Context](pp: PrePost[Context]) {

  @pure def transformTopUnit(ctx: Context, o: TopUnit): Result[Context, TopUnit] = {
    val preR: PreResult[Context, TopUnit] = pp.preTopUnit(ctx, o)
    val r: Result[Context, TopUnit] = if (preR.continue) {
      val o2: TopUnit = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, TopUnit] = o2 match {
        case o2: TopUnit.Program =>
          val r0: Result[Context, Name] = transformName(ctx, o2.packageName)
          val r1: Result[Context, Body] = transformBody(r0.ctx, o2.body)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(packageName = r0.resultOpt.getOrElse(o2.packageName), body = r1.resultOpt.getOrElse(o2.body))))
          else
            Result(r1.ctx, None())
        case o2: TopUnit.SequentUnit =>
          val r0: Result[Context, LClause.Sequent] = transformLClauseSequent(ctx, o2.sequent)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(sequent = r0.resultOpt.getOrElse(o2.sequent))))
          else
            Result(r0.ctx, None())
        case o2: TopUnit.TruthTableUnit =>
          val r0: Result[Context, IS[Z, PosInfo]] = transformISZ(ctx, o2.stars, transformPosInfo)
          val r1: Result[Context, IS[Z, Id]] = transformISZ(r0.ctx, o2.vars, transformId)
          val r2: Result[Context, PosInfo] = transformPosInfo(r1.ctx, o2.separator)
          val r3: Result[Context, LClause.Sequent] = transformLClauseSequent(r2.ctx, o2.sequent)
          val r4: Result[Context, IS[Z, TruthTable.Row]] = transformISZ(r3.ctx, o2.rows, transformTruthTableRow)
          val r5: Result[Context, Option[TruthTable.Conclusion]] = transformOption(r4.ctx, o2.conclusionOpt, transformTruthTableConclusion)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty || r4.resultOpt.nonEmpty || r5.resultOpt.nonEmpty)
            Result(r5.ctx, Some(o2(stars = r0.resultOpt.getOrElse(o2.stars), vars = r1.resultOpt.getOrElse(o2.vars), separator = r2.resultOpt.getOrElse(o2.separator), sequent = r3.resultOpt.getOrElse(o2.sequent), rows = r4.resultOpt.getOrElse(o2.rows), conclusionOpt = r5.resultOpt.getOrElse(o2.conclusionOpt))))
          else
            Result(r5.ctx, None())
      }
      rOpt
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: TopUnit = r.resultOpt.getOrElse(o)
    val postR: Result[Context, TopUnit] = pp.postTopUnit(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformStmt(ctx: Context, o: Stmt): Result[Context, Stmt] = {
    val preR: PreResult[Context, Stmt] = pp.preStmt(ctx, o)
    val r: Result[Context, Stmt] = if (preR.continue) {
      val o2: Stmt = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, Stmt] = o2 match {
        case o2: Stmt.Import =>
          val r0: Result[Context, IS[Z, Stmt.Import.Importer]] = transformISZ(ctx, o2.importers, transformStmtImportImporter)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(importers = r0.resultOpt.getOrElse(o2.importers), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Stmt.Var =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, Option[Type]] = transformOption(r0.ctx, o2.tipeOpt, transformType)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), tipeOpt = r1.resultOpt.getOrElse(o2.tipeOpt), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Stmt.VarPattern =>
          val r0: Result[Context, Pattern] = transformPattern(ctx, o2.pattern)
          val r1: Result[Context, Option[Type]] = transformOption(r0.ctx, o2.tipeOpt, transformType)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(pattern = r0.resultOpt.getOrElse(o2.pattern), tipeOpt = r1.resultOpt.getOrElse(o2.tipeOpt), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Stmt.SpecVar =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, Type] = transformType(r0.ctx, o2.tipe)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), tipe = r1.resultOpt.getOrElse(o2.tipe), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Stmt.Method =>
          val r0: Result[Context, MethodSig] = transformMethodSig(ctx, o2.sig)
          val r1: Result[Context, Contract] = transformContract(r0.ctx, o2.contract)
          val r2: Result[Context, Option[Body]] = transformOption(r1.ctx, o2.bodyOpt, transformBody)
          val r3: Result[Context, Attr] = transformAttr(r2.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty)
            Result(r3.ctx, Some(o2(sig = r0.resultOpt.getOrElse(o2.sig), contract = r1.resultOpt.getOrElse(o2.contract), bodyOpt = r2.resultOpt.getOrElse(o2.bodyOpt), attr = r3.resultOpt.getOrElse(o2.attr))))
          else
            Result(r3.ctx, None())
        case o2: Stmt.ExtMethod =>
          val r0: Result[Context, MethodSig] = transformMethodSig(ctx, o2.sig)
          val r1: Result[Context, Contract] = transformContract(r0.ctx, o2.contract)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(sig = r0.resultOpt.getOrElse(o2.sig), contract = r1.resultOpt.getOrElse(o2.contract), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Stmt.SpecMethod =>
          val r0: Result[Context, MethodSig] = transformMethodSig(ctx, o2.sig)
          val r1: Result[Context, IS[Z, SpecDef]] = transformISZ(r0.ctx, o2.defs, transformSpecDef)
          val r2: Result[Context, IS[Z, WhereDef]] = transformISZ(r1.ctx, o2.where, transformWhereDef)
          val r3: Result[Context, Attr] = transformAttr(r2.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty)
            Result(r3.ctx, Some(o2(sig = r0.resultOpt.getOrElse(o2.sig), defs = r1.resultOpt.getOrElse(o2.defs), where = r2.resultOpt.getOrElse(o2.where), attr = r3.resultOpt.getOrElse(o2.attr))))
          else
            Result(r3.ctx, None())
        case o2: Stmt.Enum =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, IS[Z, Id]] = transformISZ(r0.ctx, o2.elements, transformId)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), elements = r1.resultOpt.getOrElse(o2.elements), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Stmt.SubZ =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Stmt.Object =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, IS[Z, Type]] = transformISZ(r0.ctx, o2.parents, transformType)
          val r2: Result[Context, IS[Z, Stmt]] = transformISZ(r1.ctx, o2.stmts, transformStmt)
          val r3: Result[Context, Attr] = transformAttr(r2.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty)
            Result(r3.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), parents = r1.resultOpt.getOrElse(o2.parents), stmts = r2.resultOpt.getOrElse(o2.stmts), attr = r3.resultOpt.getOrElse(o2.attr))))
          else
            Result(r3.ctx, None())
        case o2: Stmt.Sig =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, IS[Z, TypeParam]] = transformISZ(r0.ctx, o2.typeParams, transformTypeParam)
          val r2: Result[Context, IS[Z, Type.Named]] = transformISZ(r1.ctx, o2.parents, transformTypeNamed)
          val r3: Result[Context, Option[Type]] = transformOption(r2.ctx, o2.selfTypeOpt, transformType)
          val r4: Result[Context, IS[Z, Stmt]] = transformISZ(r3.ctx, o2.stmts, transformStmt)
          val r5: Result[Context, Attr] = transformAttr(r4.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty || r4.resultOpt.nonEmpty || r5.resultOpt.nonEmpty)
            Result(r5.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), typeParams = r1.resultOpt.getOrElse(o2.typeParams), parents = r2.resultOpt.getOrElse(o2.parents), selfTypeOpt = r3.resultOpt.getOrElse(o2.selfTypeOpt), stmts = r4.resultOpt.getOrElse(o2.stmts), attr = r5.resultOpt.getOrElse(o2.attr))))
          else
            Result(r5.ctx, None())
        case o2: Stmt.AbstractDatatype =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, IS[Z, TypeParam]] = transformISZ(r0.ctx, o2.typeParams, transformTypeParam)
          val r2: Result[Context, IS[Z, AbstractDatatypeParam]] = transformISZ(r1.ctx, o2.params, transformAbstractDatatypeParam)
          val r3: Result[Context, IS[Z, Type.Named]] = transformISZ(r2.ctx, o2.parents, transformTypeNamed)
          val r4: Result[Context, IS[Z, Stmt]] = transformISZ(r3.ctx, o2.stmts, transformStmt)
          val r5: Result[Context, Attr] = transformAttr(r4.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty || r4.resultOpt.nonEmpty || r5.resultOpt.nonEmpty)
            Result(r5.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), typeParams = r1.resultOpt.getOrElse(o2.typeParams), params = r2.resultOpt.getOrElse(o2.params), parents = r3.resultOpt.getOrElse(o2.parents), stmts = r4.resultOpt.getOrElse(o2.stmts), attr = r5.resultOpt.getOrElse(o2.attr))))
          else
            Result(r5.ctx, None())
        case o2: Stmt.Rich =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, IS[Z, TypeParam]] = transformISZ(r0.ctx, o2.typeParams, transformTypeParam)
          val r2: Result[Context, IS[Z, Param]] = transformISZ(r1.ctx, o2.params, transformParam)
          val r3: Result[Context, IS[Z, Type.Named]] = transformISZ(r2.ctx, o2.parents, transformTypeNamed)
          val r4: Result[Context, IS[Z, Stmt]] = transformISZ(r3.ctx, o2.stmts, transformStmt)
          val r5: Result[Context, Attr] = transformAttr(r4.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty || r4.resultOpt.nonEmpty || r5.resultOpt.nonEmpty)
            Result(r5.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), typeParams = r1.resultOpt.getOrElse(o2.typeParams), params = r2.resultOpt.getOrElse(o2.params), parents = r3.resultOpt.getOrElse(o2.parents), stmts = r4.resultOpt.getOrElse(o2.stmts), attr = r5.resultOpt.getOrElse(o2.attr))))
          else
            Result(r5.ctx, None())
        case o2: Stmt.TypeAlias =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, IS[Z, TypeParam]] = transformISZ(r0.ctx, o2.typeParams, transformTypeParam)
          val r2: Result[Context, Type] = transformType(r1.ctx, o2.tipe)
          val r3: Result[Context, Attr] = transformAttr(r2.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty)
            Result(r3.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), typeParams = r1.resultOpt.getOrElse(o2.typeParams), tipe = r2.resultOpt.getOrElse(o2.tipe), attr = r3.resultOpt.getOrElse(o2.attr))))
          else
            Result(r3.ctx, None())
        case o2: Stmt.Assign =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.lhs)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(lhs = r0.resultOpt.getOrElse(o2.lhs), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Stmt.AssignUp =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.lhs)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(lhs = r0.resultOpt.getOrElse(o2.lhs), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Stmt.AssignPattern =>
          val r0: Result[Context, Pattern] = transformPattern(ctx, o2.lhs)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(lhs = r0.resultOpt.getOrElse(o2.lhs), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Stmt.Block =>
          val r0: Result[Context, Body] = transformBody(ctx, o2.body)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(body = r0.resultOpt.getOrElse(o2.body), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Stmt.If =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.cond)
          val r1: Result[Context, Body] = transformBody(r0.ctx, o2.thenbody)
          val r2: Result[Context, Body] = transformBody(r1.ctx, o2.elsebody)
          val r3: Result[Context, Attr] = transformAttr(r2.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty)
            Result(r3.ctx, Some(o2(cond = r0.resultOpt.getOrElse(o2.cond), thenbody = r1.resultOpt.getOrElse(o2.thenbody), elsebody = r2.resultOpt.getOrElse(o2.elsebody), attr = r3.resultOpt.getOrElse(o2.attr))))
          else
            Result(r3.ctx, None())
        case o2: Stmt.Match =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.cond)
          val r1: Result[Context, IS[Z, Case]] = transformISZ(r0.ctx, o2.cases, transformCase)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(cond = r0.resultOpt.getOrElse(o2.cond), cases = r1.resultOpt.getOrElse(o2.cases), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Stmt.While =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.cond)
          val r1: Result[Context, IS[Z, ContractExp]] = transformISZ(r0.ctx, o2.invariants, transformContractExp)
          val r2: Result[Context, IS[Z, Exp]] = transformISZ(r1.ctx, o2.modifies, transformExp)
          val r3: Result[Context, Body] = transformBody(r2.ctx, o2.body)
          val r4: Result[Context, Attr] = transformAttr(r3.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty || r4.resultOpt.nonEmpty)
            Result(r4.ctx, Some(o2(cond = r0.resultOpt.getOrElse(o2.cond), invariants = r1.resultOpt.getOrElse(o2.invariants), modifies = r2.resultOpt.getOrElse(o2.modifies), body = r3.resultOpt.getOrElse(o2.body), attr = r4.resultOpt.getOrElse(o2.attr))))
          else
            Result(r4.ctx, None())
        case o2: Stmt.DoWhile =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.cond)
          val r1: Result[Context, IS[Z, ContractExp]] = transformISZ(r0.ctx, o2.invariants, transformContractExp)
          val r2: Result[Context, IS[Z, Exp]] = transformISZ(r1.ctx, o2.modifies, transformExp)
          val r3: Result[Context, Body] = transformBody(r2.ctx, o2.body)
          val r4: Result[Context, Attr] = transformAttr(r3.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty || r4.resultOpt.nonEmpty)
            Result(r4.ctx, Some(o2(cond = r0.resultOpt.getOrElse(o2.cond), invariants = r1.resultOpt.getOrElse(o2.invariants), modifies = r2.resultOpt.getOrElse(o2.modifies), body = r3.resultOpt.getOrElse(o2.body), attr = r4.resultOpt.getOrElse(o2.attr))))
          else
            Result(r4.ctx, None())
        case o2: Stmt.For =>
          val r0: Result[Context, EnumGen.For] = transformEnumGenFor(ctx, o2.enumGen)
          val r1: Result[Context, IS[Z, ContractExp]] = transformISZ(r0.ctx, o2.invariants, transformContractExp)
          val r2: Result[Context, IS[Z, Exp]] = transformISZ(r1.ctx, o2.modifies, transformExp)
          val r3: Result[Context, Body] = transformBody(r2.ctx, o2.body)
          val r4: Result[Context, Attr] = transformAttr(r3.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty || r4.resultOpt.nonEmpty)
            Result(r4.ctx, Some(o2(enumGen = r0.resultOpt.getOrElse(o2.enumGen), invariants = r1.resultOpt.getOrElse(o2.invariants), modifies = r2.resultOpt.getOrElse(o2.modifies), body = r3.resultOpt.getOrElse(o2.body), attr = r4.resultOpt.getOrElse(o2.attr))))
          else
            Result(r4.ctx, None())
        case o2: Stmt.Return =>
          val r0: Result[Context, Option[Exp]] = transformOption(ctx, o2.expOpt, transformExp)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(expOpt = r0.resultOpt.getOrElse(o2.expOpt), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Stmt.LStmt =>
          val r0: Result[Context, LClause] = transformLClause(ctx, o2.clause)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(clause = r0.resultOpt.getOrElse(o2.clause), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Stmt.Expr =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.exp)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
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
    val postR: Result[Context, Stmt] = pp.postStmt(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformStmtImportImporter(ctx: Context, o: Stmt.Import.Importer): Result[Context, Stmt.Import.Importer] = {
    val preR: PreResult[Context, Stmt.Import.Importer] = pp.preStmtImportImporter(ctx, o)
    val r: Result[Context, Stmt.Import.Importer] = if (preR.continue) {
      val o2: Stmt.Import.Importer = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Name] = transformName(ctx, o2.name)
      val r1: Result[Context, Option[Stmt.Import.Selector]] = transformOption(r0.ctx, o2.selectorOpt, transformStmtImportSelector)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
        Result(r1.ctx, Some(o2(name = r0.resultOpt.getOrElse(o2.name), selectorOpt = r1.resultOpt.getOrElse(o2.selectorOpt))))
      else
        Result(r1.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Stmt.Import.Importer = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Stmt.Import.Importer] = pp.postStmtImportImporter(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformStmtImportSelector(ctx: Context, o: Stmt.Import.Selector): Result[Context, Stmt.Import.Selector] = {
    val preR: PreResult[Context, Stmt.Import.Selector] = pp.preStmtImportSelector(ctx, o)
    val r: Result[Context, Stmt.Import.Selector] = if (preR.continue) {
      val o2: Stmt.Import.Selector = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, Stmt.Import.Selector] = o2 match {
        case o2: Stmt.Import.MultiSelector =>
          val r0: Result[Context, IS[Z, Stmt.Import.NamedSelector]] = transformISZ(ctx, o2.selectors, transformStmtImportNamedSelector)
          if (hasChanged || r0.resultOpt.nonEmpty)
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
    val postR: Result[Context, Stmt.Import.Selector] = pp.postStmtImportSelector(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformStmtImportNamedSelector(ctx: Context, o: Stmt.Import.NamedSelector): Result[Context, Stmt.Import.NamedSelector] = {
    val preR: PreResult[Context, Stmt.Import.NamedSelector] = pp.preStmtImportNamedSelector(ctx, o)
    val r: Result[Context, Stmt.Import.NamedSelector] = if (preR.continue) {
      val o2: Stmt.Import.NamedSelector = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.from)
      val r1: Result[Context, Id] = transformId(r0.ctx, o2.to)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
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
    val postR: Result[Context, Stmt.Import.NamedSelector] = pp.postStmtImportNamedSelector(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformLClause(ctx: Context, o: LClause): Result[Context, LClause] = {
    val preR: PreResult[Context, LClause] = pp.preLClause(ctx, o)
    val r: Result[Context, LClause] = if (preR.continue) {
      val o2: LClause = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, LClause] = o2 match {
        case o2: LClause.Invariants =>
          val r0: Result[Context, IS[Z, ContractExp]] = transformISZ(ctx, o2.value, transformContractExp)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(value = r0.resultOpt.getOrElse(o2.value))))
          else
            Result(r0.ctx, None())
        case o2: LClause.Facts =>
          val r0: Result[Context, IS[Z, LClause.Fact]] = transformISZ(ctx, o2.value, transformLClauseFact)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(value = r0.resultOpt.getOrElse(o2.value))))
          else
            Result(r0.ctx, None())
        case o2: LClause.Theorems =>
          val r0: Result[Context, IS[Z, LClause.Theorem]] = transformISZ(ctx, o2.value, transformLClauseTheorem)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(value = r0.resultOpt.getOrElse(o2.value))))
          else
            Result(r0.ctx, None())
        case o2: LClause.Sequent =>
          val r0: Result[Context, IS[Z, Exp]] = transformISZ(ctx, o2.premises, transformExp)
          val r1: Result[Context, IS[Z, Exp]] = transformISZ(r0.ctx, o2.conclusions, transformExp)
          val r2: Result[Context, Option[LClause.Proof]] = transformOption(r1.ctx, o2.proofOpt, transformLClauseProof)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(premises = r0.resultOpt.getOrElse(o2.premises), conclusions = r1.resultOpt.getOrElse(o2.conclusions), proofOpt = r2.resultOpt.getOrElse(o2.proofOpt))))
          else
            Result(r2.ctx, None())
        case o2: LClause.Proof =>
          val r0: Result[Context, IS[Z, ProofStep]] = transformISZ(ctx, o2.steps, transformProofStep)
          if (hasChanged || r0.resultOpt.nonEmpty)
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
    val postR: Result[Context, LClause] = pp.postLClause(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformLClauseFact(ctx: Context, o: LClause.Fact): Result[Context, LClause.Fact] = {
    val preR: PreResult[Context, LClause.Fact] = pp.preLClauseFact(ctx, o)
    val r: Result[Context, LClause.Fact] = if (preR.continue) {
      val o2: LClause.Fact = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.id)
      val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.exp)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
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
    val postR: Result[Context, LClause.Fact] = pp.postLClauseFact(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformLClauseTheorem(ctx: Context, o: LClause.Theorem): Result[Context, LClause.Theorem] = {
    val preR: PreResult[Context, LClause.Theorem] = pp.preLClauseTheorem(ctx, o)
    val r: Result[Context, LClause.Theorem] = if (preR.continue) {
      val o2: LClause.Theorem = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.id)
      val r1: Result[Context, LClause.Sequent] = transformLClauseSequent(r0.ctx, o2.sequent)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
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
    val postR: Result[Context, LClause.Theorem] = pp.postLClauseTheorem(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformContractExp(ctx: Context, o: ContractExp): Result[Context, ContractExp] = {
    val preR: PreResult[Context, ContractExp] = pp.preContractExp(ctx, o)
    val r: Result[Context, ContractExp] = if (preR.continue) {
      val o2: ContractExp = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Option[Id]] = transformOption(ctx, o2.idOpt, transformId)
      val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.exp)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
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
    val postR: Result[Context, ContractExp] = pp.postContractExp(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformCase(ctx: Context, o: Case): Result[Context, Case] = {
    val preR: PreResult[Context, Case] = pp.preCase(ctx, o)
    val r: Result[Context, Case] = if (preR.continue) {
      val o2: Case = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Pattern] = transformPattern(ctx, o2.pattern)
      val r1: Result[Context, Option[Exp]] = transformOption(r0.ctx, o2.condOpt, transformExp)
      val r2: Result[Context, Body] = transformBody(r1.ctx, o2.body)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
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
    val postR: Result[Context, Case] = pp.postCase(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformEnumGenRange(ctx: Context, o: EnumGen.Range): Result[Context, EnumGen.Range] = {
    val preR: PreResult[Context, EnumGen.Range] = pp.preEnumGenRange(ctx, o)
    val r: Result[Context, EnumGen.Range] = if (preR.continue) {
      val o2: EnumGen.Range = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, EnumGen.Range] = o2 match {
        case o2: EnumGen.Range.Expr =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.exp)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(exp = r0.resultOpt.getOrElse(o2.exp))))
          else
            Result(r0.ctx, None())
        case o2: EnumGen.Range.Indices =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.exp)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(exp = r0.resultOpt.getOrElse(o2.exp))))
          else
            Result(r0.ctx, None())
        case o2: EnumGen.Range.Step =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.start)
          val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.end)
          val r2: Result[Context, Option[Exp]] = transformOption(r1.ctx, o2.byOpt, transformExp)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
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
    val o2: EnumGen.Range = r.resultOpt.getOrElse(o)
    val postR: Result[Context, EnumGen.Range] = pp.postEnumGenRange(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformEnumGenFor(ctx: Context, o: EnumGen.For): Result[Context, EnumGen.For] = {
    val preR: PreResult[Context, EnumGen.For] = pp.preEnumGenFor(ctx, o)
    val r: Result[Context, EnumGen.For] = if (preR.continue) {
      val o2: EnumGen.For = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.id)
      val r1: Result[Context, EnumGen.Range] = transformEnumGenRange(r0.ctx, o2.range)
      val r2: Result[Context, Option[Exp]] = transformOption(r1.ctx, o2.condOpt, transformExp)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
        Result(r2.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), range = r1.resultOpt.getOrElse(o2.range), condOpt = r2.resultOpt.getOrElse(o2.condOpt))))
      else
        Result(r2.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: EnumGen.For = r.resultOpt.getOrElse(o)
    val postR: Result[Context, EnumGen.For] = pp.postEnumGenFor(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformType(ctx: Context, o: Type): Result[Context, Type] = {
    val preR: PreResult[Context, Type] = pp.preType(ctx, o)
    val r: Result[Context, Type] = if (preR.continue) {
      val o2: Type = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, Type] = o2 match {
        case o2: Type.Named =>
          val r0: Result[Context, Name] = transformName(ctx, o2.name)
          val r1: Result[Context, IS[Z, Type]] = transformISZ(r0.ctx, o2.typeArgs, transformType)
          val r2: Result[Context, TypedAttr] = transformTypedAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(name = r0.resultOpt.getOrElse(o2.name), typeArgs = r1.resultOpt.getOrElse(o2.typeArgs), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Type.Fun =>
          val r0: Result[Context, IS[Z, Type]] = transformISZ(ctx, o2.args, transformType)
          val r1: Result[Context, Type] = transformType(r0.ctx, o2.ret)
          val r2: Result[Context, TypedAttr] = transformTypedAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(args = r0.resultOpt.getOrElse(o2.args), ret = r1.resultOpt.getOrElse(o2.ret), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Type.Tuple =>
          val r0: Result[Context, IS[Z, Type]] = transformISZ(ctx, o2.args, transformType)
          val r1: Result[Context, TypedAttr] = transformTypedAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
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
    val postR: Result[Context, Type] = pp.postType(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformPattern(ctx: Context, o: Pattern): Result[Context, Pattern] = {
    val preR: PreResult[Context, Pattern] = pp.prePattern(ctx, o)
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
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(name = r0.resultOpt.getOrElse(o2.name))))
          else
            Result(r0.ctx, None())
        case o2: Pattern.Variable =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, Option[Type]] = transformOption(r0.ctx, o2.typeOpt, transformType)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), typeOpt = r1.resultOpt.getOrElse(o2.typeOpt))))
          else
            Result(r1.ctx, None())
        case o2: Pattern.Wildcard =>
          val r0: Result[Context, Option[Type]] = transformOption(ctx, o2.typeOpt, transformType)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(typeOpt = r0.resultOpt.getOrElse(o2.typeOpt))))
          else
            Result(r0.ctx, None())
        case o2: Pattern.SeqWildcard =>
          if (hasChanged)
            Result(ctx, Some(o2))
          else
            Result(ctx, None())
        case o2: Pattern.Structure =>
          val r0: Result[Context, Option[Id]] = transformOption(ctx, o2.idOpt, transformId)
          val r1: Result[Context, Option[Name]] = transformOption(r0.ctx, o2.nameOpt, transformName)
          val r2: Result[Context, IS[Z, Pattern]] = transformISZ(r1.ctx, o2.patterns, transformPattern)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
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
    val postR: Result[Context, Pattern] = pp.postPattern(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformExp(ctx: Context, o: Exp): Result[Context, Exp] = {
    val preR: PreResult[Context, Exp] = pp.preExp(ctx, o)
    val r: Result[Context, Exp] = if (preR.continue) {
      val o2: Exp = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, Exp] = o2 match {
        case o2: Exp.LitB =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitC =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitZ =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitZ8 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitZ16 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitZ32 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitZ64 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitN =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitN8 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitN16 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitN32 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitN64 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitS8 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitS16 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitS32 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitS64 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitU8 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitU16 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitU32 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitU64 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitF32 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitF64 =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitR =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.LitBv =>
          val r0: Result[Context, Type] = transformType(ctx, o2.tipe)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(tipe = r0.resultOpt.getOrElse(o2.tipe), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Exp.LitString =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.StringInterpolate =>
          val r0: Result[Context, IS[Z, Exp.LitString]] = transformISZ(ctx, o2.lits, transformExpLitString)
          val r1: Result[Context, IS[Z, Exp]] = transformISZ(r0.ctx, o2.args, transformExp)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(lits = r0.resultOpt.getOrElse(o2.lits), args = r1.resultOpt.getOrElse(o2.args), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Exp.This =>
          val r0: Result[Context, TypedAttr] = transformTypedAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.Super =>
          val r0: Result[Context, TypedAttr] = transformTypedAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Exp.Unary =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.exp)
          val r1: Result[Context, TypedAttr] = transformTypedAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(exp = r0.resultOpt.getOrElse(o2.exp), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Exp.Binary =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.left)
          val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.right)
          val r2: Result[Context, TypedAttr] = transformTypedAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(left = r0.resultOpt.getOrElse(o2.left), right = r1.resultOpt.getOrElse(o2.right), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Exp.Ident =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, ResolvedAttr] = transformResolvedAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Exp.Eta =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.exp)
          val r1: Result[Context, ResolvedAttr] = transformResolvedAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(exp = r0.resultOpt.getOrElse(o2.exp), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Exp.Tuple =>
          val r0: Result[Context, IS[Z, Exp]] = transformISZ(ctx, o2.args, transformExp)
          val r1: Result[Context, TypedAttr] = transformTypedAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(args = r0.resultOpt.getOrElse(o2.args), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Exp.Select =>
          val r0: Result[Context, Option[Exp]] = transformOption(ctx, o2.receiverOpt, transformExp)
          val r1: Result[Context, Id] = transformId(r0.ctx, o2.id)
          val r2: Result[Context, IS[Z, Type]] = transformISZ(r1.ctx, o2.targs, transformType)
          val r3: Result[Context, ResolvedAttr] = transformResolvedAttr(r2.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty)
            Result(r3.ctx, Some(o2(receiverOpt = r0.resultOpt.getOrElse(o2.receiverOpt), id = r1.resultOpt.getOrElse(o2.id), targs = r2.resultOpt.getOrElse(o2.targs), attr = r3.resultOpt.getOrElse(o2.attr))))
          else
            Result(r3.ctx, None())
        case o2: Exp.Invoke =>
          val r0: Result[Context, Option[Exp]] = transformOption(ctx, o2.receiverOpt, transformExp)
          val r1: Result[Context, Id] = transformId(r0.ctx, o2.id)
          val r2: Result[Context, IS[Z, Type]] = transformISZ(r1.ctx, o2.targs, transformType)
          val r3: Result[Context, IS[Z, Exp]] = transformISZ(r2.ctx, o2.args, transformExp)
          val r4: Result[Context, ResolvedAttr] = transformResolvedAttr(r3.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty || r4.resultOpt.nonEmpty)
            Result(r4.ctx, Some(o2(receiverOpt = r0.resultOpt.getOrElse(o2.receiverOpt), id = r1.resultOpt.getOrElse(o2.id), targs = r2.resultOpt.getOrElse(o2.targs), args = r3.resultOpt.getOrElse(o2.args), attr = r4.resultOpt.getOrElse(o2.attr))))
          else
            Result(r4.ctx, None())
        case o2: Exp.InvokeNamed =>
          val r0: Result[Context, Option[Exp]] = transformOption(ctx, o2.receiverOpt, transformExp)
          val r1: Result[Context, Id] = transformId(r0.ctx, o2.id)
          val r2: Result[Context, IS[Z, Type]] = transformISZ(r1.ctx, o2.targs, transformType)
          val r3: Result[Context, IS[Z, NamedArg]] = transformISZ(r2.ctx, o2.args, transformNamedArg)
          val r4: Result[Context, ResolvedAttr] = transformResolvedAttr(r3.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty || r4.resultOpt.nonEmpty)
            Result(r4.ctx, Some(o2(receiverOpt = r0.resultOpt.getOrElse(o2.receiverOpt), id = r1.resultOpt.getOrElse(o2.id), targs = r2.resultOpt.getOrElse(o2.targs), args = r3.resultOpt.getOrElse(o2.args), attr = r4.resultOpt.getOrElse(o2.attr))))
          else
            Result(r4.ctx, None())
        case o2: Exp.If =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.cond)
          val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.thenExp)
          val r2: Result[Context, Exp] = transformExp(r1.ctx, o2.elseExp)
          val r3: Result[Context, TypedAttr] = transformTypedAttr(r2.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty)
            Result(r3.ctx, Some(o2(cond = r0.resultOpt.getOrElse(o2.cond), thenExp = r1.resultOpt.getOrElse(o2.thenExp), elseExp = r2.resultOpt.getOrElse(o2.elseExp), attr = r3.resultOpt.getOrElse(o2.attr))))
          else
            Result(r3.ctx, None())
        case o2: Exp.Fun =>
          val r0: Result[Context, IS[Z, Param]] = transformISZ(ctx, o2.params, transformParam)
          val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.exp)
          val r2: Result[Context, TypedAttr] = transformTypedAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(params = r0.resultOpt.getOrElse(o2.params), exp = r1.resultOpt.getOrElse(o2.exp), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Exp.ForYield =>
          val r0: Result[Context, IS[Z, EnumGen.For]] = transformISZ(ctx, o2.enumGens, transformEnumGenFor)
          val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.exp)
          val r2: Result[Context, TypedAttr] = transformTypedAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(enumGens = r0.resultOpt.getOrElse(o2.enumGens), exp = r1.resultOpt.getOrElse(o2.exp), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Exp.Quant =>
          val r0: Result[Context, IS[Z, VarFragment]] = transformISZ(ctx, o2.varFragments, transformVarFragment)
          val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.exp)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(varFragments = r0.resultOpt.getOrElse(o2.varFragments), exp = r1.resultOpt.getOrElse(o2.exp), attr = r2.resultOpt.getOrElse(o2.attr))))
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
    val o2: Exp = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Exp] = pp.postExp(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformNamedArg(ctx: Context, o: NamedArg): Result[Context, NamedArg] = {
    val preR: PreResult[Context, NamedArg] = pp.preNamedArg(ctx, o)
    val r: Result[Context, NamedArg] = if (preR.continue) {
      val o2: NamedArg = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.id)
      val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.arg)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
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
    val postR: Result[Context, NamedArg] = pp.postNamedArg(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformVarFragment(ctx: Context, o: VarFragment): Result[Context, VarFragment] = {
    val preR: PreResult[Context, VarFragment] = pp.preVarFragment(ctx, o)
    val r: Result[Context, VarFragment] = if (preR.continue) {
      val o2: VarFragment = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, IS[Z, Id]] = transformISZ(ctx, o2.ids, transformId)
      val r1: Result[Context, Option[Domain]] = transformOption(r0.ctx, o2.domainOpt, transformDomain)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
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
    val postR: Result[Context, VarFragment] = pp.postVarFragment(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformDomain(ctx: Context, o: Domain): Result[Context, Domain] = {
    val preR: PreResult[Context, Domain] = pp.preDomain(ctx, o)
    val r: Result[Context, Domain] = if (preR.continue) {
      val o2: Domain = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, Domain] = o2 match {
        case o2: Domain.Type =>
          val r0: Result[Context, Type] = transformType(ctx, o2.tipe)
          val r1: Result[Context, TypedAttr] = transformTypedAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(tipe = r0.resultOpt.getOrElse(o2.tipe), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Domain.Range =>
          val r0: Result[Context, Exp] = transformExp(ctx, o2.lo)
          val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.hi)
          val r2: Result[Context, TypedAttr] = transformTypedAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
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
    val postR: Result[Context, Domain] = pp.postDomain(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformId(ctx: Context, o: Id): Result[Context, Id] = {
    val preR: PreResult[Context, Id] = pp.preId(ctx, o)
    val r: Result[Context, Id] = if (preR.continue) {
      val o2: Id = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
      if (hasChanged || r0.resultOpt.nonEmpty)
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
    val postR: Result[Context, Id] = pp.postId(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformName(ctx: Context, o: Name): Result[Context, Name] = {
    val preR: PreResult[Context, Name] = pp.preName(ctx, o)
    val r: Result[Context, Name] = if (preR.continue) {
      val o2: Name = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, IS[Z, Id]] = transformISZ(ctx, o2.ids, transformId)
      val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
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
    val postR: Result[Context, Name] = pp.postName(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformBody(ctx: Context, o: Body): Result[Context, Body] = {
    val preR: PreResult[Context, Body] = pp.preBody(ctx, o)
    val r: Result[Context, Body] = if (preR.continue) {
      val o2: Body = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, IS[Z, Stmt]] = transformISZ(ctx, o2.stmts, transformStmt)
      if (hasChanged || r0.resultOpt.nonEmpty)
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
    val postR: Result[Context, Body] = pp.postBody(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformAbstractDatatypeParam(ctx: Context, o: AbstractDatatypeParam): Result[Context, AbstractDatatypeParam] = {
    val preR: PreResult[Context, AbstractDatatypeParam] = pp.preAbstractDatatypeParam(ctx, o)
    val r: Result[Context, AbstractDatatypeParam] = if (preR.continue) {
      val o2: AbstractDatatypeParam = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.id)
      val r1: Result[Context, Type] = transformType(r0.ctx, o2.tipe)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
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
    val postR: Result[Context, AbstractDatatypeParam] = pp.postAbstractDatatypeParam(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformMethodSig(ctx: Context, o: MethodSig): Result[Context, MethodSig] = {
    val preR: PreResult[Context, MethodSig] = pp.preMethodSig(ctx, o)
    val r: Result[Context, MethodSig] = if (preR.continue) {
      val o2: MethodSig = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.id)
      val r1: Result[Context, IS[Z, TypeParam]] = transformISZ(r0.ctx, o2.typeParams, transformTypeParam)
      val r2: Result[Context, IS[Z, Param]] = transformISZ(r1.ctx, o2.params, transformParam)
      val r3: Result[Context, Type] = transformType(r2.ctx, o2.returnType)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty)
        Result(r3.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), typeParams = r1.resultOpt.getOrElse(o2.typeParams), params = r2.resultOpt.getOrElse(o2.params), returnType = r3.resultOpt.getOrElse(o2.returnType))))
      else
        Result(r3.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: MethodSig = r.resultOpt.getOrElse(o)
    val postR: Result[Context, MethodSig] = pp.postMethodSig(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformParam(ctx: Context, o: Param): Result[Context, Param] = {
    val preR: PreResult[Context, Param] = pp.preParam(ctx, o)
    val r: Result[Context, Param] = if (preR.continue) {
      val o2: Param = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.id)
      val r1: Result[Context, Type] = transformType(r0.ctx, o2.tipe)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
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
    val postR: Result[Context, Param] = pp.postParam(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformTypeParam(ctx: Context, o: TypeParam): Result[Context, TypeParam] = {
    val preR: PreResult[Context, TypeParam] = pp.preTypeParam(ctx, o)
    val r: Result[Context, TypeParam] = if (preR.continue) {
      val o2: TypeParam = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.id)
      val r1: Result[Context, Option[Type]] = transformOption(r0.ctx, o2.superTypeOpt, transformType)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
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
    val postR: Result[Context, TypeParam] = pp.postTypeParam(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformContract(ctx: Context, o: Contract): Result[Context, Contract] = {
    val preR: PreResult[Context, Contract] = pp.preContract(ctx, o)
    val r: Result[Context, Contract] = if (preR.continue) {
      val o2: Contract = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, IS[Z, Exp]] = transformISZ(ctx, o2.reads, transformExp)
      val r1: Result[Context, IS[Z, ContractExp]] = transformISZ(r0.ctx, o2.requires, transformContractExp)
      val r2: Result[Context, IS[Z, Exp]] = transformISZ(r1.ctx, o2.modifies, transformExp)
      val r3: Result[Context, IS[Z, ContractExp]] = transformISZ(r2.ctx, o2.ensures, transformContractExp)
      val r4: Result[Context, IS[Z, SubContract]] = transformISZ(r3.ctx, o2.subs, transformSubContract)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty || r4.resultOpt.nonEmpty)
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
    val postR: Result[Context, Contract] = pp.postContract(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformSubContract(ctx: Context, o: SubContract): Result[Context, SubContract] = {
    val preR: PreResult[Context, SubContract] = pp.preSubContract(ctx, o)
    val r: Result[Context, SubContract] = if (preR.continue) {
      val o2: SubContract = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.id)
      val r1: Result[Context, IS[Z, SubContractParam]] = transformISZ(r0.ctx, o2.params, transformSubContractParam)
      val r2: Result[Context, Contract] = transformContract(r1.ctx, o2.contract)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
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
    val postR: Result[Context, SubContract] = pp.postSubContract(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformSubContractParam(ctx: Context, o: SubContractParam): Result[Context, SubContractParam] = {
    val preR: PreResult[Context, SubContractParam] = pp.preSubContractParam(ctx, o)
    val r: Result[Context, SubContractParam] = if (preR.continue) {
      val o2: SubContractParam = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Id] = transformId(ctx, o2.id)
      if (hasChanged || r0.resultOpt.nonEmpty)
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
    val postR: Result[Context, SubContractParam] = pp.postSubContractParam(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformWhereDef(ctx: Context, o: WhereDef): Result[Context, WhereDef] = {
    val preR: PreResult[Context, WhereDef] = pp.preWhereDef(ctx, o)
    val r: Result[Context, WhereDef] = if (preR.continue) {
      val o2: WhereDef = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, WhereDef] = o2 match {
        case o2: WhereDef.Val =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, Type] = transformType(r0.ctx, o2.tipe)
          val r2: Result[Context, Exp] = transformExp(r1.ctx, o2.exp)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(id = r0.resultOpt.getOrElse(o2.id), tipe = r1.resultOpt.getOrElse(o2.tipe), exp = r2.resultOpt.getOrElse(o2.exp))))
          else
            Result(r2.ctx, None())
        case o2: WhereDef.Def =>
          val r0: Result[Context, Id] = transformId(ctx, o2.id)
          val r1: Result[Context, IS[Z, Param]] = transformISZ(r0.ctx, o2.params, transformParam)
          val r2: Result[Context, Type] = transformType(r1.ctx, o2.rTipe)
          val r3: Result[Context, IS[Z, SpecDef]] = transformISZ(r2.ctx, o2.defs, transformSpecDef)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty)
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
    val postR: Result[Context, WhereDef] = pp.postWhereDef(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformSpecDef(ctx: Context, o: SpecDef): Result[Context, SpecDef] = {
    val preR: PreResult[Context, SpecDef] = pp.preSpecDef(ctx, o)
    val r: Result[Context, SpecDef] = if (preR.continue) {
      val o2: SpecDef = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Option[Id]] = transformOption(ctx, o2.idOpt, transformId)
      val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.exp)
      val r2: Result[Context, Option[Pattern]] = transformOption(r1.ctx, o2.patternOpt, transformPattern)
      val r3: Result[Context, Option[Exp]] = transformOption(r2.ctx, o2.guardOpt, transformExp)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty || r3.resultOpt.nonEmpty)
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
    val postR: Result[Context, SpecDef] = pp.postSpecDef(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformProofStep(ctx: Context, o: ProofStep): Result[Context, ProofStep] = {
    val preR: PreResult[Context, ProofStep] = pp.preProofStep(ctx, o)
    val r: Result[Context, ProofStep] = if (preR.continue) {
      val o2: ProofStep = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, ProofStep] = o2 match {
        case o2: ProofStep.Basic =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.step)
          val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.exp)
          val r2: Result[Context, Just] = transformJust(r1.ctx, o2.just)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(step = r0.resultOpt.getOrElse(o2.step), exp = r1.resultOpt.getOrElse(o2.exp), just = r2.resultOpt.getOrElse(o2.just))))
          else
            Result(r2.ctx, None())
        case o2: ProofStep.SubProof =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.step)
          val r1: Result[Context, AssumeProofStep] = transformAssumeProofStep(r0.ctx, o2.assumeStep)
          val r2: Result[Context, IS[Z, ProofStep]] = transformISZ(r1.ctx, o2.steps, transformProofStep)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
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
    val postR: Result[Context, ProofStep] = pp.postProofStep(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformAssumeProofStep(ctx: Context, o: AssumeProofStep): Result[Context, AssumeProofStep] = {
    val preR: PreResult[Context, AssumeProofStep] = pp.preAssumeProofStep(ctx, o)
    val r: Result[Context, AssumeProofStep] = if (preR.continue) {
      val o2: AssumeProofStep = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, AssumeProofStep] = o2 match {
        case o2: AssumeProofStep.Regular =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.step)
          val r1: Result[Context, Exp] = transformExp(r0.ctx, o2.exp)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(step = r0.resultOpt.getOrElse(o2.step), exp = r1.resultOpt.getOrElse(o2.exp))))
          else
            Result(r1.ctx, None())
        case o2: AssumeProofStep.ForallIntroAps =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.step)
          val r1: Result[Context, IS[Z, VarFragment]] = transformISZ(r0.ctx, o2.varFragments, transformVarFragment)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(step = r0.resultOpt.getOrElse(o2.step), varFragments = r1.resultOpt.getOrElse(o2.varFragments))))
          else
            Result(r1.ctx, None())
        case o2: AssumeProofStep.ExistsElimAps =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.step)
          val r1: Result[Context, IS[Z, VarFragment]] = transformISZ(r0.ctx, o2.varFragments, transformVarFragment)
          val r2: Result[Context, Exp] = transformExp(r1.ctx, o2.exp)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
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
    val postR: Result[Context, AssumeProofStep] = pp.postAssumeProofStep(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformJust(ctx: Context, o: Just): Result[Context, Just] = {
    val preR: PreResult[Context, Just] = pp.preJust(ctx, o)
    val r: Result[Context, Just] = if (preR.continue) {
      val o2: Just = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, Just] = o2 match {
        case o2: Just.Premise =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: Just.AndIntro =>
          val r0: Result[Context, IS[Z, Exp.LitZ]] = transformISZ(ctx, o2.steps, transformExpLitZ)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(steps = r0.resultOpt.getOrElse(o2.steps), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.AndElim =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.andStep)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(andStep = r0.resultOpt.getOrElse(o2.andStep), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.OrIntro =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.step)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(step = r0.resultOpt.getOrElse(o2.step), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.OrElim =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.orStep)
          val r1: Result[Context, IS[Z, Exp.LitZ]] = transformISZ(r0.ctx, o2.subProofSteps, transformExpLitZ)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(orStep = r0.resultOpt.getOrElse(o2.orStep), subProofSteps = r1.resultOpt.getOrElse(o2.subProofSteps), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Just.ImplyIntro =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.subProofStep)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(subProofStep = r0.resultOpt.getOrElse(o2.subProofStep), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.ImplyElim =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.implyStep)
          val r1: Result[Context, IS[Z, Exp.LitZ]] = transformISZ(r0.ctx, o2.steps, transformExpLitZ)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(implyStep = r0.resultOpt.getOrElse(o2.implyStep), steps = r1.resultOpt.getOrElse(o2.steps), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Just.NegIntro =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.subProofStep)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(subProofStep = r0.resultOpt.getOrElse(o2.subProofStep), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.NegElim =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.step)
          val r1: Result[Context, Exp.LitZ] = transformExpLitZ(r0.ctx, o2.negStep)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(step = r0.resultOpt.getOrElse(o2.step), negStep = r1.resultOpt.getOrElse(o2.negStep), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Just.BottomElim =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.subProofStep)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(subProofStep = r0.resultOpt.getOrElse(o2.subProofStep), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.Pbc =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.subProofStep)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(subProofStep = r0.resultOpt.getOrElse(o2.subProofStep), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.ForallIntro =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.subProofStep)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(subProofStep = r0.resultOpt.getOrElse(o2.subProofStep), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.ForallElim =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.forallStep)
          val r1: Result[Context, IS[Z, Exp]] = transformISZ(r0.ctx, o2.args, transformExp)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(forallStep = r0.resultOpt.getOrElse(o2.forallStep), args = r1.resultOpt.getOrElse(o2.args), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Just.ExistsIntro =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.existsStep)
          val r1: Result[Context, IS[Z, Exp]] = transformISZ(r0.ctx, o2.args, transformExp)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(existsStep = r0.resultOpt.getOrElse(o2.existsStep), args = r1.resultOpt.getOrElse(o2.args), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Just.ExistsElim =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.existsStep)
          val r1: Result[Context, Exp.LitZ] = transformExpLitZ(r0.ctx, o2.subProofStep)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(existsStep = r0.resultOpt.getOrElse(o2.existsStep), subProofStep = r1.resultOpt.getOrElse(o2.subProofStep), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Just.Fact =>
          val r0: Result[Context, Name] = transformName(ctx, o2.name)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(name = r0.resultOpt.getOrElse(o2.name), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.Invariant =>
          val r0: Result[Context, Option[Name]] = transformOption(ctx, o2.nameOpt, transformName)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(nameOpt = r0.resultOpt.getOrElse(o2.nameOpt), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.Subst =>
          val r0: Result[Context, Exp.LitZ] = transformExpLitZ(ctx, o2.eqStep)
          val r1: Result[Context, Exp.LitZ] = transformExpLitZ(r0.ctx, o2.step)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(eqStep = r0.resultOpt.getOrElse(o2.eqStep), step = r1.resultOpt.getOrElse(o2.step), attr = r2.resultOpt.getOrElse(o2.attr))))
          else
            Result(r2.ctx, None())
        case o2: Just.Auto =>
          val r0: Result[Context, IS[Z, Exp.LitZ]] = transformISZ(ctx, o2.steps, transformExpLitZ)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(steps = r0.resultOpt.getOrElse(o2.steps), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: Just.Coq =>
          val r0: Result[Context, Exp.LitString] = transformExpLitString(ctx, o2.path)
          val r1: Result[Context, IS[Z, Exp.LitZ]] = transformISZ(r0.ctx, o2.steps, transformExpLitZ)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
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
    val postR: Result[Context, Just] = pp.postJust(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformTruthTableRow(ctx: Context, o: TruthTable.Row): Result[Context, TruthTable.Row] = {
    val preR: PreResult[Context, TruthTable.Row] = pp.preTruthTableRow(ctx, o)
    val r: Result[Context, TruthTable.Row] = if (preR.continue) {
      val o2: TruthTable.Row = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, TruthTable.Assignment] = transformTruthTableAssignment(ctx, o2.assignment)
      val r1: Result[Context, PosInfo] = transformPosInfo(r0.ctx, o2.separator)
      val r2: Result[Context, TruthTable.Assignment] = transformTruthTableAssignment(r1.ctx, o2.values)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
        Result(r2.ctx, Some(o2(assignment = r0.resultOpt.getOrElse(o2.assignment), separator = r1.resultOpt.getOrElse(o2.separator), values = r2.resultOpt.getOrElse(o2.values))))
      else
        Result(r2.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: TruthTable.Row = r.resultOpt.getOrElse(o)
    val postR: Result[Context, TruthTable.Row] = pp.postTruthTableRow(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformTruthTableAssignment(ctx: Context, o: TruthTable.Assignment): Result[Context, TruthTable.Assignment] = {
    val preR: PreResult[Context, TruthTable.Assignment] = pp.preTruthTableAssignment(ctx, o)
    val r: Result[Context, TruthTable.Assignment] = if (preR.continue) {
      val o2: TruthTable.Assignment = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, IS[Z, Exp.LitB]] = transformISZ(ctx, o2.values, transformExpLitB)
      val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
        Result(r1.ctx, Some(o2(values = r0.resultOpt.getOrElse(o2.values), attr = r1.resultOpt.getOrElse(o2.attr))))
      else
        Result(r1.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: TruthTable.Assignment = r.resultOpt.getOrElse(o)
    val postR: Result[Context, TruthTable.Assignment] = pp.postTruthTableAssignment(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformTruthTableConclusion(ctx: Context, o: TruthTable.Conclusion): Result[Context, TruthTable.Conclusion] = {
    val preR: PreResult[Context, TruthTable.Conclusion] = pp.preTruthTableConclusion(ctx, o)
    val r: Result[Context, TruthTable.Conclusion] = if (preR.continue) {
      val o2: TruthTable.Conclusion = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val rOpt: Result[Context, TruthTable.Conclusion] = o2 match {
        case o2: TruthTable.Conclusion.Validity =>
          val r0: Result[Context, IS[Z, TruthTable.Assignment]] = transformISZ(ctx, o2.assignments, transformTruthTableAssignment)
          val r1: Result[Context, Attr] = transformAttr(r0.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
            Result(r1.ctx, Some(o2(assignments = r0.resultOpt.getOrElse(o2.assignments), attr = r1.resultOpt.getOrElse(o2.attr))))
          else
            Result(r1.ctx, None())
        case o2: TruthTable.Conclusion.Tautology =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: TruthTable.Conclusion.Contradictory =>
          val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty)
            Result(r0.ctx, Some(o2(attr = r0.resultOpt.getOrElse(o2.attr))))
          else
            Result(r0.ctx, None())
        case o2: TruthTable.Conclusion.Contingent =>
          val r0: Result[Context, IS[Z, TruthTable.Assignment]] = transformISZ(ctx, o2.trueAssignments, transformTruthTableAssignment)
          val r1: Result[Context, IS[Z, TruthTable.Assignment]] = transformISZ(r0.ctx, o2.falseAssignments, transformTruthTableAssignment)
          val r2: Result[Context, Attr] = transformAttr(r1.ctx, o2.attr)
          if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
            Result(r2.ctx, Some(o2(trueAssignments = r0.resultOpt.getOrElse(o2.trueAssignments), falseAssignments = r1.resultOpt.getOrElse(o2.falseAssignments), attr = r2.resultOpt.getOrElse(o2.attr))))
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
    val o2: TruthTable.Conclusion = r.resultOpt.getOrElse(o)
    val postR: Result[Context, TruthTable.Conclusion] = pp.postTruthTableConclusion(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformAttr(ctx: Context, o: Attr): Result[Context, Attr] = {
    val preR: PreResult[Context, Attr] = pp.preAttr(ctx, o)
    val r: Result[Context, Attr] = if (preR.continue) {
      val o2: Attr = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Option[PosInfo]] = transformOption(ctx, o2.posOpt, transformPosInfo)
      if (hasChanged || r0.resultOpt.nonEmpty)
        Result(r0.ctx, Some(o2(posOpt = r0.resultOpt.getOrElse(o2.posOpt))))
      else
        Result(r0.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: Attr = r.resultOpt.getOrElse(o)
    val postR: Result[Context, Attr] = pp.postAttr(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformTypedAttr(ctx: Context, o: TypedAttr): Result[Context, TypedAttr] = {
    val preR: PreResult[Context, TypedAttr] = pp.preTypedAttr(ctx, o)
    val r: Result[Context, TypedAttr] = if (preR.continue) {
      val o2: TypedAttr = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Option[PosInfo]] = transformOption(ctx, o2.posOpt, transformPosInfo)
      val r1: Result[Context, Option[Type]] = transformOption(r0.ctx, o2.typeOpt, transformType)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty)
        Result(r1.ctx, Some(o2(posOpt = r0.resultOpt.getOrElse(o2.posOpt), typeOpt = r1.resultOpt.getOrElse(o2.typeOpt))))
      else
        Result(r1.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: TypedAttr = r.resultOpt.getOrElse(o)
    val postR: Result[Context, TypedAttr] = pp.postTypedAttr(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformResolvedAttr(ctx: Context, o: ResolvedAttr): Result[Context, ResolvedAttr] = {
    val preR: PreResult[Context, ResolvedAttr] = pp.preResolvedAttr(ctx, o)
    val r: Result[Context, ResolvedAttr] = if (preR.continue) {
      val o2: ResolvedAttr = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Option[PosInfo]] = transformOption(ctx, o2.posOpt, transformPosInfo)
      val r1: Result[Context, Option[ResolvedInfo]] = transformOption(r0.ctx, o2.resOpt, transformResolvedInfo)
      val r2: Result[Context, Option[Type]] = transformOption(r1.ctx, o2.typeOpt, transformType)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
        Result(r2.ctx, Some(o2(posOpt = r0.resultOpt.getOrElse(o2.posOpt), resOpt = r1.resultOpt.getOrElse(o2.resOpt), typeOpt = r2.resultOpt.getOrElse(o2.typeOpt))))
      else
        Result(r2.ctx, None())
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(o)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged: B = r.resultOpt.nonEmpty
    val o2: ResolvedAttr = r.resultOpt.getOrElse(o)
    val postR: Result[Context, ResolvedAttr] = pp.postResolvedAttr(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformResolvedInfo(ctx: Context, o: ResolvedInfo): Result[Context, ResolvedInfo] = {
    val preR: PreResult[Context, ResolvedInfo] = pp.preResolvedInfo(ctx, o)
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
    val postR: Result[Context, ResolvedInfo] = pp.postResolvedInfo(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformPosInfo(ctx: Context, o: PosInfo): Result[Context, PosInfo] = {
    val preR: PreResult[Context, PosInfo] = pp.prePosInfo(ctx, o)
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
    val postR: Result[Context, PosInfo] = pp.postPosInfo(r.ctx, o2)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(o2))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformLClauseProof(ctx: Context, o: LClause.Proof): Result[Context, LClause.Proof] = {
    val preR: PreResult[Context, LClause.Proof] = pp.preLClauseProof(ctx, o) match {
     case PreResult(preCtx, continue, Some(r: LClause.Proof)) => PreResult(preCtx, continue, Some[LClause.Proof](r))
     case PreResult(preCtx, continue, _) => assert(F); PreResult(preCtx, F, None[LClause.Proof]())
   }
    val r: Result[Context, LClause.Proof] = if (preR.continue) {
      val o2: LClause.Proof = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, IS[Z, ProofStep]] = transformISZ(ctx, o2.steps, transformProofStep)
      if (hasChanged || r0.resultOpt.nonEmpty)
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
    val postR: Result[Context, LClause.Proof] = pp.postLClauseProof(r.ctx, o2) match {
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

  @pure def transformLClauseSequent(ctx: Context, o: LClause.Sequent): Result[Context, LClause.Sequent] = {
    val preR: PreResult[Context, LClause.Sequent] = pp.preLClauseSequent(ctx, o) match {
     case PreResult(preCtx, continue, Some(r: LClause.Sequent)) => PreResult(preCtx, continue, Some[LClause.Sequent](r))
     case PreResult(preCtx, continue, _) => assert(F); PreResult(preCtx, F, None[LClause.Sequent]())
   }
    val r: Result[Context, LClause.Sequent] = if (preR.continue) {
      val o2: LClause.Sequent = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, IS[Z, Exp]] = transformISZ(ctx, o2.premises, transformExp)
      val r1: Result[Context, IS[Z, Exp]] = transformISZ(r0.ctx, o2.conclusions, transformExp)
      val r2: Result[Context, Option[LClause.Proof]] = transformOption(r1.ctx, o2.proofOpt, transformLClauseProof)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
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
    val postR: Result[Context, LClause.Sequent] = pp.postLClauseSequent(r.ctx, o2) match {
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

  @pure def transformTypeNamed(ctx: Context, o: Type.Named): Result[Context, Type.Named] = {
    val preR: PreResult[Context, Type.Named] = pp.preTypeNamed(ctx, o) match {
     case PreResult(preCtx, continue, Some(r: Type.Named)) => PreResult(preCtx, continue, Some[Type.Named](r))
     case PreResult(preCtx, continue, _) => assert(F); PreResult(preCtx, F, None[Type.Named]())
   }
    val r: Result[Context, Type.Named] = if (preR.continue) {
      val o2: Type.Named = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Name] = transformName(ctx, o2.name)
      val r1: Result[Context, IS[Z, Type]] = transformISZ(r0.ctx, o2.typeArgs, transformType)
      val r2: Result[Context, TypedAttr] = transformTypedAttr(r1.ctx, o2.attr)
      if (hasChanged || r0.resultOpt.nonEmpty || r1.resultOpt.nonEmpty || r2.resultOpt.nonEmpty)
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
    val postR: Result[Context, Type.Named] = pp.postTypeNamed(r.ctx, o2) match {
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

  @pure def transformExpLitString(ctx: Context, o: Exp.LitString): Result[Context, Exp.LitString] = {
    val preR: PreResult[Context, Exp.LitString] = pp.preExpLitString(ctx, o) match {
     case PreResult(preCtx, continue, Some(r: Exp.LitString)) => PreResult(preCtx, continue, Some[Exp.LitString](r))
     case PreResult(preCtx, continue, _) => assert(F); PreResult(preCtx, F, None[Exp.LitString]())
   }
    val r: Result[Context, Exp.LitString] = if (preR.continue) {
      val o2: Exp.LitString = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
      if (hasChanged || r0.resultOpt.nonEmpty)
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
    val postR: Result[Context, Exp.LitString] = pp.postExpLitString(r.ctx, o2) match {
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

  @pure def transformExpLitZ(ctx: Context, o: Exp.LitZ): Result[Context, Exp.LitZ] = {
    val preR: PreResult[Context, Exp.LitZ] = pp.preExpLitZ(ctx, o) match {
     case PreResult(preCtx, continue, Some(r: Exp.LitZ)) => PreResult(preCtx, continue, Some[Exp.LitZ](r))
     case PreResult(preCtx, continue, _) => assert(F); PreResult(preCtx, F, None[Exp.LitZ]())
   }
    val r: Result[Context, Exp.LitZ] = if (preR.continue) {
      val o2: Exp.LitZ = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
      if (hasChanged || r0.resultOpt.nonEmpty)
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
    val postR: Result[Context, Exp.LitZ] = pp.postExpLitZ(r.ctx, o2) match {
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

  @pure def transformExpLitB(ctx: Context, o: Exp.LitB): Result[Context, Exp.LitB] = {
    val preR: PreResult[Context, Exp.LitB] = pp.preExpLitB(ctx, o) match {
     case PreResult(preCtx, continue, Some(r: Exp.LitB)) => PreResult(preCtx, continue, Some[Exp.LitB](r))
     case PreResult(preCtx, continue, _) => assert(F); PreResult(preCtx, F, None[Exp.LitB]())
   }
    val r: Result[Context, Exp.LitB] = if (preR.continue) {
      val o2: Exp.LitB = preR.resultOpt.getOrElse(o)
      val hasChanged: B = preR.resultOpt.nonEmpty
      val r0: Result[Context, Attr] = transformAttr(ctx, o2.attr)
      if (hasChanged || r0.resultOpt.nonEmpty)
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
    val postR: Result[Context, Exp.LitB] = pp.postExpLitB(r.ctx, o2) match {
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

}