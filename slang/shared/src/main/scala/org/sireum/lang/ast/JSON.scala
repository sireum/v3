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
import org.sireum.Json.Printer._

object JSON {

  object Printer {

    @pure def printTopUnit(o: TopUnit): ST = {
      o match {
        case o: TopUnit.Program => return printTopUnitProgram(o)
        case o: TopUnit.SequentUnit => return printTopUnitSequentUnit(o)
        case o: TopUnit.TruthTableUnit => return printTopUnitTruthTableUnit(o)
      }
    }

    @pure def printTopUnitProgram(o: TopUnit.Program): ST = {
      return printObject(ISZ(
        ("fileUriOpt", printOption(o.fileUriOpt, printString)),
        ("packageName", printName(o.packageName)),
        ("body", printBody(o.body))
      ))
    }

    @pure def printTopUnitSequentUnit(o: TopUnit.SequentUnit): ST = {
      return printObject(ISZ(
        ("fileUriOpt", printOption(o.fileUriOpt, printString)),
        ("sequent", printLClauseSequent(o.sequent))
      ))
    }

    @pure def printTopUnitTruthTableUnit(o: TopUnit.TruthTableUnit): ST = {
      return printObject(ISZ(
        ("fileUriOpt", printOption(o.fileUriOpt, printString)),
        ("stars", printISZ(F, o.stars, printPosInfo)),
        ("vars", printISZ(F, o.vars, printId)),
        ("separator", printPosInfo(o.separator)),
        ("isSequent", printB(o.isSequent)),
        ("sequent", printLClauseSequent(o.sequent)),
        ("rows", printISZ(F, o.rows, printTruthTableRow)),
        ("conclusionOpt", printOption(o.conclusionOpt, printTruthTableConclusion))
      ))
    }

    @pure def printStmt(o: Stmt): ST = {
      o match {
        case o: Stmt.Import => return printStmtImport(o)
        case o: Stmt.Var => return printStmtVar(o)
        case o: Stmt.VarPattern => return printStmtVarPattern(o)
        case o: Stmt.SpecVar => return printStmtSpecVar(o)
        case o: Stmt.Method => return printStmtMethod(o)
        case o: Stmt.ExtMethod => return printStmtExtMethod(o)
        case o: Stmt.SpecMethod => return printStmtSpecMethod(o)
        case o: Stmt.Enum => return printStmtEnum(o)
        case o: Stmt.Object => return printStmtObject(o)
        case o: Stmt.Sig => return printStmtSig(o)
        case o: Stmt.AbstractDatatype => return printStmtAbstractDatatype(o)
        case o: Stmt.Rich => return printStmtRich(o)
        case o: Stmt.TypeAlias => return printStmtTypeAlias(o)
        case o: Stmt.Assign => return printStmtAssign(o)
        case o: Stmt.AssignUp => return printStmtAssignUp(o)
        case o: Stmt.AssignPattern => return printStmtAssignPattern(o)
        case o: Stmt.Block => return printStmtBlock(o)
        case o: Stmt.If => return printStmtIf(o)
        case o: Stmt.Match => return printStmtMatch(o)
        case o: Stmt.While => return printStmtWhile(o)
        case o: Stmt.DoWhile => return printStmtDoWhile(o)
        case o: Stmt.For => return printStmtFor(o)
        case o: Stmt.Return => return printStmtReturn(o)
        case o: Stmt.LStmt => return printStmtLStmt(o)
        case o: Stmt.Expr => return printStmtExpr(o)
      }
    }

    @pure def printAssignExp(o: AssignExp): ST = {
      o match {
        case o: Stmt.Block => return printStmtBlock(o)
        case o: Stmt.If => return printStmtIf(o)
        case o: Stmt.Match => return printStmtMatch(o)
        case o: Stmt.Expr => return printStmtExpr(o)
      }
    }

    @pure def printPurity(o: Purity.Type): ST = {
      val value: String = o match {
        case Purity.Impure => "Impure"
        case Purity.Pure => "Pure"
        case Purity.Memoize => "Memoize"
      }
      return printObject(ISZ(
        ("type", printString("Purity")),
        ("value", printString(value))
      ))
    }

    @pure def printStmtImport(o: Stmt.Import): ST = {
      return printObject(ISZ(
        ("importers", printISZ(F, o.importers, printStmtImportImporter)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtImportImporter(o: Stmt.Import.Importer): ST = {
      return printObject(ISZ(
        ("name", printName(o.name)),
        ("selectorOpt", printOption(o.selectorOpt, printStmtImportSelector))
      ))
    }

    @pure def printStmtImportSelector(o: Stmt.Import.Selector): ST = {
      o match {
        case o: Stmt.Import.MultiSelector => return printStmtImportMultiSelector(o)
        case o: Stmt.Import.WildcardSelector => return printStmtImportWildcardSelector(o)
      }
    }

    @pure def printStmtImportMultiSelector(o: Stmt.Import.MultiSelector): ST = {
      return printObject(ISZ(
        ("selectors", printISZ(F, o.selectors, printStmtImportNamedSelector))
      ))
    }

    @pure def printStmtImportWildcardSelector(o: Stmt.Import.WildcardSelector): ST = {
      return printObject(ISZ(
      ))
    }

    @pure def printStmtImportNamedSelector(o: Stmt.Import.NamedSelector): ST = {
      return printObject(ISZ(
        ("from", printId(o.from)),
        ("to", printId(o.to))
      ))
    }

    @pure def printStmtVar(o: Stmt.Var): ST = {
      return printObject(ISZ(
        ("isVal", printB(o.isVal)),
        ("id", printId(o.id)),
        ("tipeOpt", printOption(o.tipeOpt, printType)),
        ("initOpt", printOption(o.initOpt, printAssignExp)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtVarPattern(o: Stmt.VarPattern): ST = {
      return printObject(ISZ(
        ("isVal", printB(o.isVal)),
        ("pattern", printPattern(o.pattern)),
        ("tipeOpt", printOption(o.tipeOpt, printType)),
        ("initOpt", printOption(o.initOpt, printAssignExp)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtSpecVar(o: Stmt.SpecVar): ST = {
      return printObject(ISZ(
        ("isVal", printB(o.isVal)),
        ("id", printId(o.id)),
        ("tipe", printType(o.tipe)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtMethod(o: Stmt.Method): ST = {
      return printObject(ISZ(
        ("purity", printPurity(o.purity)),
        ("hasOverride", printB(o.hasOverride)),
        ("sig", printMethodSig(o.sig)),
        ("contract", printContract(o.contract)),
        ("bodyOpt", printOption(o.bodyOpt, printBody)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtExtMethod(o: Stmt.ExtMethod): ST = {
      return printObject(ISZ(
        ("isPure", printB(o.isPure)),
        ("sig", printMethodSig(o.sig)),
        ("contract", printContract(o.contract)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtSpecMethod(o: Stmt.SpecMethod): ST = {
      return printObject(ISZ(
        ("sig", printMethodSig(o.sig)),
        ("defs", printISZ(F, o.defs, printSpecDef)),
        ("where", printISZ(F, o.where, printWhereDef)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtEnum(o: Stmt.Enum): ST = {
      return printObject(ISZ(
        ("id", printId(o.id)),
        ("elements", printISZ(F, o.elements, printId)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtObject(o: Stmt.Object): ST = {
      return printObject(ISZ(
        ("isExt", printB(o.isExt)),
        ("id", printId(o.id)),
        ("parents", printISZ(F, o.parents, printType)),
        ("stmts", printISZ(F, o.stmts, printStmt)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtSig(o: Stmt.Sig): ST = {
      return printObject(ISZ(
        ("isImmutable", printB(o.isImmutable)),
        ("id", printId(o.id)),
        ("typeParams", printISZ(F, o.typeParams, printTypeParam)),
        ("parents", printISZ(F, o.parents, printTypeNamed)),
        ("selfTypeOpt", printOption(o.selfTypeOpt, printType)),
        ("stmts", printISZ(F, o.stmts, printStmt)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtAbstractDatatype(o: Stmt.AbstractDatatype): ST = {
      return printObject(ISZ(
        ("isRoot", printB(o.isRoot)),
        ("isDatatype", printB(o.isDatatype)),
        ("id", printId(o.id)),
        ("typeParams", printISZ(F, o.typeParams, printTypeParam)),
        ("params", printISZ(F, o.params, printAbstractDatatypeParam)),
        ("parents", printISZ(F, o.parents, printTypeNamed)),
        ("stmts", printISZ(F, o.stmts, printStmt)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtRich(o: Stmt.Rich): ST = {
      return printObject(ISZ(
        ("isRoot", printB(o.isRoot)),
        ("id", printId(o.id)),
        ("typeParams", printISZ(F, o.typeParams, printTypeParam)),
        ("params", printISZ(F, o.params, printParam)),
        ("parents", printISZ(F, o.parents, printTypeNamed)),
        ("stmts", printISZ(F, o.stmts, printStmt)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtTypeAlias(o: Stmt.TypeAlias): ST = {
      return printObject(ISZ(
        ("id", printId(o.id)),
        ("typeParams", printISZ(F, o.typeParams, printTypeParam)),
        ("tipe", printType(o.tipe)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtAssign(o: Stmt.Assign): ST = {
      return printObject(ISZ(
        ("lhs", printExp(o.lhs)),
        ("rhs", printAssignExp(o.rhs)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtAssignUp(o: Stmt.AssignUp): ST = {
      return printObject(ISZ(
        ("lhs", printExp(o.lhs)),
        ("rhs", printAssignExp(o.rhs)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtAssignPattern(o: Stmt.AssignPattern): ST = {
      return printObject(ISZ(
        ("lhs", printPattern(o.lhs)),
        ("rhs", printAssignExp(o.rhs)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtBlock(o: Stmt.Block): ST = {
      return printObject(ISZ(
        ("body", printBody(o.body)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtIf(o: Stmt.If): ST = {
      return printObject(ISZ(
        ("cond", printExp(o.cond)),
        ("thenbody", printBody(o.thenbody)),
        ("elsebody", printBody(o.elsebody)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtMatch(o: Stmt.Match): ST = {
      return printObject(ISZ(
        ("cond", printExp(o.cond)),
        ("cases", printISZ(F, o.cases, printCase)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtWhile(o: Stmt.While): ST = {
      return printObject(ISZ(
        ("cond", printExp(o.cond)),
        ("invariants", printISZ(F, o.invariants, printContractExp)),
        ("modifies", printISZ(F, o.modifies, printExp)),
        ("body", printBody(o.body)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtDoWhile(o: Stmt.DoWhile): ST = {
      return printObject(ISZ(
        ("cond", printExp(o.cond)),
        ("invariants", printISZ(F, o.invariants, printContractExp)),
        ("modifies", printISZ(F, o.modifies, printExp)),
        ("body", printBody(o.body)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtFor(o: Stmt.For): ST = {
      return printObject(ISZ(
        ("enumGen", printEnumGenFor(o.enumGen)),
        ("invariants", printISZ(F, o.invariants, printContractExp)),
        ("modifies", printISZ(F, o.modifies, printExp)),
        ("body", printBody(o.body)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtReturn(o: Stmt.Return): ST = {
      return printObject(ISZ(
        ("expOpt", printOption(o.expOpt, printExp)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtLStmt(o: Stmt.LStmt): ST = {
      return printObject(ISZ(
        ("clause", printLClause(o.clause)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtExpr(o: Stmt.Expr): ST = {
      return printObject(ISZ(
        ("exp", printExp(o.exp)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printLClause(o: LClause): ST = {
      o match {
        case o: LClause.Invariants => return printLClauseInvariants(o)
        case o: LClause.Facts => return printLClauseFacts(o)
        case o: LClause.Theorems => return printLClauseTheorems(o)
        case o: LClause.Sequent => return printLClauseSequent(o)
        case o: LClause.Proof => return printLClauseProof(o)
      }
    }

    @pure def printLClauseInvariants(o: LClause.Invariants): ST = {
      return printObject(ISZ(
        ("value", printISZ(F, o.value, printContractExp))
      ))
    }

    @pure def printLClauseFacts(o: LClause.Facts): ST = {
      return printObject(ISZ(
        ("value", printISZ(F, o.value, printLClauseFact))
      ))
    }

    @pure def printLClauseFact(o: LClause.Fact): ST = {
      return printObject(ISZ(
        ("id", printId(o.id)),
        ("exp", printExp(o.exp))
      ))
    }

    @pure def printLClauseTheorems(o: LClause.Theorems): ST = {
      return printObject(ISZ(
        ("value", printISZ(F, o.value, printLClauseTheorem))
      ))
    }

    @pure def printLClauseTheorem(o: LClause.Theorem): ST = {
      return printObject(ISZ(
        ("id", printId(o.id)),
        ("sequent", printLClauseSequent(o.sequent))
      ))
    }

    @pure def printLClauseSequent(o: LClause.Sequent): ST = {
      return printObject(ISZ(
        ("premises", printISZ(F, o.premises, printExp)),
        ("conclusions", printISZ(F, o.conclusions, printExp)),
        ("proofOpt", printOption(o.proofOpt, printLClauseProof))
      ))
    }

    @pure def printLClauseProof(o: LClause.Proof): ST = {
      return printObject(ISZ(
        ("steps", printISZ(F, o.steps, printProofStep))
      ))
    }

    @pure def printContractExp(o: ContractExp): ST = {
      return printObject(ISZ(
        ("idOpt", printOption(o.idOpt, printId)),
        ("exp", printExp(o.exp))
      ))
    }

    @pure def printCase(o: Case): ST = {
      return printObject(ISZ(
        ("pattern", printPattern(o.pattern)),
        ("condOpt", printOption(o.condOpt, printExp)),
        ("body", printBody(o.body))
      ))
    }

    @pure def printEnumGenRange(o: EnumGen.Range): ST = {
      o match {
        case o: EnumGen.Range.Expr => return printEnumGenRangeExpr(o)
        case o: EnumGen.Range.Indices => return printEnumGenRangeIndices(o)
        case o: EnumGen.Range.Step => return printEnumGenRangeStep(o)
      }
    }

    @pure def printEnumGenRangeExpr(o: EnumGen.Range.Expr): ST = {
      return printObject(ISZ(
        ("isReverse", printB(o.isReverse)),
        ("exp", printExp(o.exp))
      ))
    }

    @pure def printEnumGenRangeIndices(o: EnumGen.Range.Indices): ST = {
      return printObject(ISZ(
        ("isReverse", printB(o.isReverse)),
        ("exp", printExp(o.exp))
      ))
    }

    @pure def printEnumGenRangeStep(o: EnumGen.Range.Step): ST = {
      return printObject(ISZ(
        ("isInclusive", printB(o.isInclusive)),
        ("start", printExp(o.start)),
        ("end", printExp(o.end)),
        ("byOpt", printOption(o.byOpt, printExp))
      ))
    }

    @pure def printEnumGenFor(o: EnumGen.For): ST = {
      return printObject(ISZ(
        ("id", printId(o.id)),
        ("range", printEnumGenRange(o.range)),
        ("condOpt", printOption(o.condOpt, printExp))
      ))
    }

    @pure def printType(o: Type): ST = {
      o match {
        case o: Type.Named => return printTypeNamed(o)
        case o: Type.Fun => return printTypeFun(o)
        case o: Type.Tuple => return printTypeTuple(o)
      }
    }

    @pure def printTypeNamed(o: Type.Named): ST = {
      return printObject(ISZ(
        ("name", printName(o.name)),
        ("typeArgs", printISZ(F, o.typeArgs, printType)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printTypeFun(o: Type.Fun): ST = {
      return printObject(ISZ(
        ("args", printISZ(F, o.args, printType)),
        ("ret", printType(o.ret)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printTypeTuple(o: Type.Tuple): ST = {
      return printObject(ISZ(
        ("args", printISZ(F, o.args, printType)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printPattern(o: Pattern): ST = {
      o match {
        case o: Pattern.Literal => return printPatternLiteral(o)
        case o: Pattern.Ref => return printPatternRef(o)
        case o: Pattern.Variable => return printPatternVariable(o)
        case o: Pattern.Wildcard => return printPatternWildcard(o)
        case o: Pattern.SeqWildcard => return printPatternSeqWildcard(o)
        case o: Pattern.Structure => return printPatternStructure(o)
      }
    }

    @pure def printPatternLiteral(o: Pattern.Literal): ST = {
      return printObject(ISZ(
        ("lit", printLit(o.lit))
      ))
    }

    @pure def printPatternRef(o: Pattern.Ref): ST = {
      return printObject(ISZ(
        ("name", printName(o.name))
      ))
    }

    @pure def printPatternVariable(o: Pattern.Variable): ST = {
      return printObject(ISZ(
        ("id", printId(o.id)),
        ("typeOpt", printOption(o.typeOpt, printType))
      ))
    }

    @pure def printPatternWildcard(o: Pattern.Wildcard): ST = {
      return printObject(ISZ(
        ("typeOpt", printOption(o.typeOpt, printType))
      ))
    }

    @pure def printPatternSeqWildcard(o: Pattern.SeqWildcard): ST = {
      return printObject(ISZ(
      ))
    }

    @pure def printPatternStructure(o: Pattern.Structure): ST = {
      return printObject(ISZ(
        ("idOpt", printOption(o.idOpt, printId)),
        ("nameOpt", printOption(o.nameOpt, printName)),
        ("patterns", printISZ(F, o.patterns, printPattern))
      ))
    }

    @pure def printExp(o: Exp): ST = {
      o match {
        case o: Exp.LitB => return printExpLitB(o)
        case o: Exp.LitC => return printExpLitC(o)
        case o: Exp.LitZ => return printExpLitZ(o)
        case o: Exp.LitZ8 => return printExpLitZ8(o)
        case o: Exp.LitZ16 => return printExpLitZ16(o)
        case o: Exp.LitZ32 => return printExpLitZ32(o)
        case o: Exp.LitZ64 => return printExpLitZ64(o)
        case o: Exp.LitN => return printExpLitN(o)
        case o: Exp.LitN8 => return printExpLitN8(o)
        case o: Exp.LitN16 => return printExpLitN16(o)
        case o: Exp.LitN32 => return printExpLitN32(o)
        case o: Exp.LitN64 => return printExpLitN64(o)
        case o: Exp.LitS8 => return printExpLitS8(o)
        case o: Exp.LitS16 => return printExpLitS16(o)
        case o: Exp.LitS32 => return printExpLitS32(o)
        case o: Exp.LitS64 => return printExpLitS64(o)
        case o: Exp.LitU8 => return printExpLitU8(o)
        case o: Exp.LitU16 => return printExpLitU16(o)
        case o: Exp.LitU32 => return printExpLitU32(o)
        case o: Exp.LitU64 => return printExpLitU64(o)
        case o: Exp.LitF32 => return printExpLitF32(o)
        case o: Exp.LitF64 => return printExpLitF64(o)
        case o: Exp.LitR => return printExpLitR(o)
        case o: Exp.LitBv => return printExpLitBv(o)
        case o: Exp.LitString => return printExpLitString(o)
        case o: Exp.StringInterpolate => return printExpStringInterpolate(o)
        case o: Exp.This => return printExpThis(o)
        case o: Exp.Super => return printExpSuper(o)
        case o: Exp.Unary => return printExpUnary(o)
        case o: Exp.Binary => return printExpBinary(o)
        case o: Exp.Ident => return printExpIdent(o)
        case o: Exp.Eta => return printExpEta(o)
        case o: Exp.Tuple => return printExpTuple(o)
        case o: Exp.Select => return printExpSelect(o)
        case o: Exp.Invoke => return printExpInvoke(o)
        case o: Exp.InvokeNamed => return printExpInvokeNamed(o)
        case o: Exp.If => return printExpIf(o)
        case o: Exp.Fun => return printExpFun(o)
        case o: Exp.ForYield => return printExpForYield(o)
        case o: Exp.Quant => return printExpQuant(o)
      }
    }

    @pure def printLit(o: Lit): ST = {
      o match {
        case o: Exp.LitB => return printExpLitB(o)
        case o: Exp.LitC => return printExpLitC(o)
        case o: Exp.LitZ => return printExpLitZ(o)
        case o: Exp.LitZ8 => return printExpLitZ8(o)
        case o: Exp.LitZ16 => return printExpLitZ16(o)
        case o: Exp.LitZ32 => return printExpLitZ32(o)
        case o: Exp.LitZ64 => return printExpLitZ64(o)
        case o: Exp.LitN => return printExpLitN(o)
        case o: Exp.LitN8 => return printExpLitN8(o)
        case o: Exp.LitN16 => return printExpLitN16(o)
        case o: Exp.LitN32 => return printExpLitN32(o)
        case o: Exp.LitN64 => return printExpLitN64(o)
        case o: Exp.LitS8 => return printExpLitS8(o)
        case o: Exp.LitS16 => return printExpLitS16(o)
        case o: Exp.LitS32 => return printExpLitS32(o)
        case o: Exp.LitS64 => return printExpLitS64(o)
        case o: Exp.LitU8 => return printExpLitU8(o)
        case o: Exp.LitU16 => return printExpLitU16(o)
        case o: Exp.LitU32 => return printExpLitU32(o)
        case o: Exp.LitU64 => return printExpLitU64(o)
        case o: Exp.LitF32 => return printExpLitF32(o)
        case o: Exp.LitF64 => return printExpLitF64(o)
        case o: Exp.LitR => return printExpLitR(o)
        case o: Exp.LitBv => return printExpLitBv(o)
        case o: Exp.LitString => return printExpLitString(o)
      }
    }

    @pure def printExpLitB(o: Exp.LitB): ST = {
      return printObject(ISZ(
        ("value", printB(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitC(o: Exp.LitC): ST = {
      return printObject(ISZ(
        ("value", printC(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitZ(o: Exp.LitZ): ST = {
      return printObject(ISZ(
        ("value", printZ(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitZ8(o: Exp.LitZ8): ST = {
      return printObject(ISZ(
        ("value", printZ8(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitZ16(o: Exp.LitZ16): ST = {
      return printObject(ISZ(
        ("value", printZ16(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitZ32(o: Exp.LitZ32): ST = {
      return printObject(ISZ(
        ("value", printZ32(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitZ64(o: Exp.LitZ64): ST = {
      return printObject(ISZ(
        ("value", printZ64(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitN(o: Exp.LitN): ST = {
      return printObject(ISZ(
        ("value", printN(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitN8(o: Exp.LitN8): ST = {
      return printObject(ISZ(
        ("value", printN8(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitN16(o: Exp.LitN16): ST = {
      return printObject(ISZ(
        ("value", printN16(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitN32(o: Exp.LitN32): ST = {
      return printObject(ISZ(
        ("value", printN32(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitN64(o: Exp.LitN64): ST = {
      return printObject(ISZ(
        ("value", printN64(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitS8(o: Exp.LitS8): ST = {
      return printObject(ISZ(
        ("value", printS8(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitS16(o: Exp.LitS16): ST = {
      return printObject(ISZ(
        ("value", printS16(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitS32(o: Exp.LitS32): ST = {
      return printObject(ISZ(
        ("value", printS32(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitS64(o: Exp.LitS64): ST = {
      return printObject(ISZ(
        ("value", printS64(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitU8(o: Exp.LitU8): ST = {
      return printObject(ISZ(
        ("value", printU8(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitU16(o: Exp.LitU16): ST = {
      return printObject(ISZ(
        ("value", printU16(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitU32(o: Exp.LitU32): ST = {
      return printObject(ISZ(
        ("value", printU32(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitU64(o: Exp.LitU64): ST = {
      return printObject(ISZ(
        ("value", printU64(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitF32(o: Exp.LitF32): ST = {
      return printObject(ISZ(
        ("value", printF32(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitF64(o: Exp.LitF64): ST = {
      return printObject(ISZ(
        ("value", printF64(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitR(o: Exp.LitR): ST = {
      return printObject(ISZ(
        ("value", printR(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitBv(o: Exp.LitBv): ST = {
      return printObject(ISZ(
        ("value", printISZ(T, o.value, printB)),
        ("tipe", printType(o.tipe)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitString(o: Exp.LitString): ST = {
      return printObject(ISZ(
        ("value", printString(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpStringInterpolate(o: Exp.StringInterpolate): ST = {
      return printObject(ISZ(
        ("prefix", printString(o.prefix)),
        ("lits", printISZ(F, o.lits, printExpLitString)),
        ("args", printISZ(F, o.args, printExp)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpThis(o: Exp.This): ST = {
      return printObject(ISZ(
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printExpSuper(o: Exp.Super): ST = {
      return printObject(ISZ(
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printExpUnaryOp(o: Exp.UnaryOp.Type): ST = {
      val value: String = o match {
        case Exp.UnaryOp.Not => "Not"
        case Exp.UnaryOp.Plus => "Plus"
        case Exp.UnaryOp.Minus => "Minus"
        case Exp.UnaryOp.Complement => "Complement"
      }
      return printObject(ISZ(
        ("type", printString("Exp.UnaryOp")),
        ("value", printString(value))
      ))
    }

    @pure def printExpUnary(o: Exp.Unary): ST = {
      return printObject(ISZ(
        ("op", printExpUnaryOp(o.op)),
        ("exp", printExp(o.exp)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printExpBinaryOp(o: Exp.BinaryOp.Type): ST = {
      val value: String = o match {
        case Exp.BinaryOp.Add => "Add"
        case Exp.BinaryOp.Sub => "Sub"
        case Exp.BinaryOp.Mul => "Mul"
        case Exp.BinaryOp.Div => "Div"
        case Exp.BinaryOp.Rem => "Rem"
        case Exp.BinaryOp.Eq => "Eq"
        case Exp.BinaryOp.Ne => "Ne"
        case Exp.BinaryOp.Shl => "Shl"
        case Exp.BinaryOp.Shr => "Shr"
        case Exp.BinaryOp.Ushr => "Ushr"
        case Exp.BinaryOp.Lt => "Lt"
        case Exp.BinaryOp.Le => "Le"
        case Exp.BinaryOp.Gt => "Gt"
        case Exp.BinaryOp.Ge => "Ge"
        case Exp.BinaryOp.And => "And"
        case Exp.BinaryOp.Or => "Or"
        case Exp.BinaryOp.Xor => "Xor"
        case Exp.BinaryOp.Imply => "Imply"
        case Exp.BinaryOp.CondAnd => "CondAnd"
        case Exp.BinaryOp.CondOr => "CondOr"
        case Exp.BinaryOp.Append => "Append"
        case Exp.BinaryOp.Prepend => "Prepend"
        case Exp.BinaryOp.AppendAll => "AppendAll"
        case Exp.BinaryOp.RemoveAll => "RemoveAll"
      }
      return printObject(ISZ(
        ("type", printString("Exp.BinaryOp")),
        ("value", printString(value))
      ))
    }

    @pure def printExpBinary(o: Exp.Binary): ST = {
      return printObject(ISZ(
        ("left", printExp(o.left)),
        ("op", printExpBinaryOp(o.op)),
        ("right", printExp(o.right)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printExpIdent(o: Exp.Ident): ST = {
      return printObject(ISZ(
        ("id", printId(o.id)),
        ("attr", printResolvedAttr(o.attr))
      ))
    }

    @pure def printExpEta(o: Exp.Eta): ST = {
      return printObject(ISZ(
        ("exp", printExp(o.exp)),
        ("attr", printResolvedAttr(o.attr))
      ))
    }

    @pure def printExpTuple(o: Exp.Tuple): ST = {
      return printObject(ISZ(
        ("args", printISZ(F, o.args, printExp)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printExpSelect(o: Exp.Select): ST = {
      return printObject(ISZ(
        ("receiverOpt", printOption(o.receiverOpt, printExp)),
        ("id", printId(o.id)),
        ("targs", printISZ(F, o.targs, printType)),
        ("attr", printResolvedAttr(o.attr))
      ))
    }

    @pure def printExpInvoke(o: Exp.Invoke): ST = {
      return printObject(ISZ(
        ("receiverOpt", printOption(o.receiverOpt, printExp)),
        ("id", printId(o.id)),
        ("targs", printISZ(F, o.targs, printType)),
        ("args", printISZ(F, o.args, printExp)),
        ("attr", printResolvedAttr(o.attr))
      ))
    }

    @pure def printExpInvokeNamed(o: Exp.InvokeNamed): ST = {
      return printObject(ISZ(
        ("receiverOpt", printOption(o.receiverOpt, printExp)),
        ("id", printId(o.id)),
        ("targs", printISZ(F, o.targs, printType)),
        ("args", printISZ(F, o.args, printNamedArg)),
        ("attr", printResolvedAttr(o.attr))
      ))
    }

    @pure def printExpIf(o: Exp.If): ST = {
      return printObject(ISZ(
        ("cond", printExp(o.cond)),
        ("thenExp", printExp(o.thenExp)),
        ("elseExp", printExp(o.elseExp)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printExpFun(o: Exp.Fun): ST = {
      return printObject(ISZ(
        ("params", printISZ(F, o.params, printParam)),
        ("exp", printExp(o.exp)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printExpForYield(o: Exp.ForYield): ST = {
      return printObject(ISZ(
        ("enumGens", printISZ(F, o.enumGens, printEnumGenFor)),
        ("exp", printExp(o.exp)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printExpQuant(o: Exp.Quant): ST = {
      return printObject(ISZ(
        ("isForall", printB(o.isForall)),
        ("varFragments", printISZ(F, o.varFragments, printVarFragment)),
        ("exp", printExp(o.exp)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printNamedArg(o: NamedArg): ST = {
      return printObject(ISZ(
        ("id", printId(o.id)),
        ("arg", printExp(o.arg))
      ))
    }

    @pure def printVarFragment(o: VarFragment): ST = {
      return printObject(ISZ(
        ("ids", printISZ(F, o.ids, printId)),
        ("domainOpt", printOption(o.domainOpt, printDomain))
      ))
    }

    @pure def printDomain(o: Domain): ST = {
      o match {
        case o: Domain.Type => return printDomainType(o)
        case o: Domain.Range => return printDomainRange(o)
      }
    }

    @pure def printDomainType(o: Domain.Type): ST = {
      return printObject(ISZ(
        ("tipe", printType(o.tipe)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printDomainRange(o: Domain.Range): ST = {
      return printObject(ISZ(
        ("lo", printExp(o.lo)),
        ("loExact", printB(o.loExact)),
        ("hi", printExp(o.hi)),
        ("hiExact", printB(o.hiExact)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printId(o: Id): ST = {
      return printObject(ISZ(
        ("value", printString(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printName(o: Name): ST = {
      return printObject(ISZ(
        ("ids", printISZ(F, o.ids, printId)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printBody(o: Body): ST = {
      return printObject(ISZ(
        ("stmts", printISZ(F, o.stmts, printStmt))
      ))
    }

    @pure def printAbstractDatatypeParam(o: AbstractDatatypeParam): ST = {
      return printObject(ISZ(
        ("isHidden", printB(o.isHidden)),
        ("isPure", printB(o.isPure)),
        ("id", printId(o.id)),
        ("tipe", printType(o.tipe))
      ))
    }

    @pure def printMethodSig(o: MethodSig): ST = {
      return printObject(ISZ(
        ("id", printId(o.id)),
        ("typeParams", printISZ(F, o.typeParams, printTypeParam)),
        ("hasParams", printB(o.hasParams)),
        ("params", printISZ(F, o.params, printParam)),
        ("returnType", printType(o.returnType))
      ))
    }

    @pure def printParamMod(o: ParamMod.Type): ST = {
      val value: String = o match {
        case ParamMod.NoMod => "NoMod"
        case ParamMod.Pure => "Pure"
        case ParamMod.Hidden => "Hidden"
      }
      return printObject(ISZ(
        ("type", printString("ParamMod")),
        ("value", printString(value))
      ))
    }

    @pure def printParam(o: Param): ST = {
      return printObject(ISZ(
        ("mod", printParamMod(o.mod)),
        ("id", printId(o.id)),
        ("tipe", printType(o.tipe))
      ))
    }

    @pure def printTypeParam(o: TypeParam): ST = {
      return printObject(ISZ(
        ("id", printId(o.id)),
        ("superTypeOpt", printOption(o.superTypeOpt, printType))
      ))
    }

    @pure def printContract(o: Contract): ST = {
      return printObject(ISZ(
        ("reads", printISZ(F, o.reads, printExp)),
        ("requires", printISZ(F, o.requires, printContractExp)),
        ("modifies", printISZ(F, o.modifies, printExp)),
        ("ensures", printISZ(F, o.ensures, printContractExp)),
        ("subs", printISZ(F, o.subs, printSubContract))
      ))
    }

    @pure def printSubContract(o: SubContract): ST = {
      return printObject(ISZ(
        ("id", printId(o.id)),
        ("params", printISZ(F, o.params, printSubContractParam)),
        ("contract", printContract(o.contract))
      ))
    }

    @pure def printSubContractParam(o: SubContractParam): ST = {
      return printObject(ISZ(
        ("isPure", printB(o.isPure)),
        ("id", printId(o.id))
      ))
    }

    @pure def printWhereDef(o: WhereDef): ST = {
      o match {
        case o: WhereDef.Val => return printWhereDefVal(o)
        case o: WhereDef.Def => return printWhereDefDef(o)
      }
    }

    @pure def printWhereDefVal(o: WhereDef.Val): ST = {
      return printObject(ISZ(
        ("id", printId(o.id)),
        ("tipe", printType(o.tipe)),
        ("exp", printExp(o.exp))
      ))
    }

    @pure def printWhereDefDef(o: WhereDef.Def): ST = {
      return printObject(ISZ(
        ("id", printId(o.id)),
        ("params", printISZ(F, o.params, printParam)),
        ("rTipe", printType(o.rTipe)),
        ("defs", printISZ(F, o.defs, printSpecDef))
      ))
    }

    @pure def printSpecDef(o: SpecDef): ST = {
      return printObject(ISZ(
        ("idOpt", printOption(o.idOpt, printId)),
        ("exp", printExp(o.exp)),
        ("isOtherwise", printB(o.isOtherwise)),
        ("patternOpt", printOption(o.patternOpt, printPattern)),
        ("guardOpt", printOption(o.guardOpt, printExp))
      ))
    }

    @pure def printProofStep(o: ProofStep): ST = {
      o match {
        case o: ProofStep.Basic => return printProofStepBasic(o)
        case o: ProofStep.SubProof => return printProofStepSubProof(o)
      }
    }

    @pure def printProofStepBasic(o: ProofStep.Basic): ST = {
      return printObject(ISZ(
        ("step", printExpLitZ(o.step)),
        ("exp", printExp(o.exp)),
        ("just", printJust(o.just))
      ))
    }

    @pure def printProofStepSubProof(o: ProofStep.SubProof): ST = {
      return printObject(ISZ(
        ("step", printExpLitZ(o.step)),
        ("assumeStep", printAssumeProofStep(o.assumeStep)),
        ("steps", printISZ(F, o.steps, printProofStep))
      ))
    }

    @pure def printAssumeProofStep(o: AssumeProofStep): ST = {
      o match {
        case o: AssumeProofStep.Regular => return printAssumeProofStepRegular(o)
        case o: AssumeProofStep.ForallIntroAps => return printAssumeProofStepForallIntroAps(o)
        case o: AssumeProofStep.ExistsElimAps => return printAssumeProofStepExistsElimAps(o)
      }
    }

    @pure def printAssumeProofStepRegular(o: AssumeProofStep.Regular): ST = {
      return printObject(ISZ(
        ("step", printExpLitZ(o.step)),
        ("exp", printExp(o.exp))
      ))
    }

    @pure def printAssumeProofStepForallIntroAps(o: AssumeProofStep.ForallIntroAps): ST = {
      return printObject(ISZ(
        ("step", printExpLitZ(o.step)),
        ("varFragments", printISZ(F, o.varFragments, printVarFragment))
      ))
    }

    @pure def printAssumeProofStepExistsElimAps(o: AssumeProofStep.ExistsElimAps): ST = {
      return printObject(ISZ(
        ("step", printExpLitZ(o.step)),
        ("varFragments", printISZ(F, o.varFragments, printVarFragment)),
        ("exp", printExp(o.exp))
      ))
    }

    @pure def printJust(o: Just): ST = {
      o match {
        case o: Just.Premise => return printJustPremise(o)
        case o: Just.AndIntro => return printJustAndIntro(o)
        case o: Just.AndElim => return printJustAndElim(o)
        case o: Just.OrIntro => return printJustOrIntro(o)
        case o: Just.OrElim => return printJustOrElim(o)
        case o: Just.ImplyIntro => return printJustImplyIntro(o)
        case o: Just.ImplyElim => return printJustImplyElim(o)
        case o: Just.NegIntro => return printJustNegIntro(o)
        case o: Just.NegElim => return printJustNegElim(o)
        case o: Just.BottomElim => return printJustBottomElim(o)
        case o: Just.Pbc => return printJustPbc(o)
        case o: Just.ForallIntro => return printJustForallIntro(o)
        case o: Just.ForallElim => return printJustForallElim(o)
        case o: Just.ExistsIntro => return printJustExistsIntro(o)
        case o: Just.ExistsElim => return printJustExistsElim(o)
        case o: Just.Fact => return printJustFact(o)
        case o: Just.Invariant => return printJustInvariant(o)
        case o: Just.Subst => return printJustSubst(o)
        case o: Just.Auto => return printJustAuto(o)
        case o: Just.Coq => return printJustCoq(o)
      }
    }

    @pure def printJustPremise(o: Just.Premise): ST = {
      return printObject(ISZ(
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustAndIntro(o: Just.AndIntro): ST = {
      return printObject(ISZ(
        ("steps", printISZ(F, o.steps, printExpLitZ)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustAndElim(o: Just.AndElim): ST = {
      return printObject(ISZ(
        ("is1", printB(o.is1)),
        ("andStep", printExpLitZ(o.andStep)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustOrIntro(o: Just.OrIntro): ST = {
      return printObject(ISZ(
        ("is1", printB(o.is1)),
        ("step", printExpLitZ(o.step)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustOrElim(o: Just.OrElim): ST = {
      return printObject(ISZ(
        ("orStep", printExpLitZ(o.orStep)),
        ("subProofSteps", printISZ(F, o.subProofSteps, printExpLitZ)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustImplyIntro(o: Just.ImplyIntro): ST = {
      return printObject(ISZ(
        ("subProofStep", printExpLitZ(o.subProofStep)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustImplyElim(o: Just.ImplyElim): ST = {
      return printObject(ISZ(
        ("implyStep", printExpLitZ(o.implyStep)),
        ("steps", printISZ(F, o.steps, printExpLitZ)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustNegIntro(o: Just.NegIntro): ST = {
      return printObject(ISZ(
        ("subProofStep", printExpLitZ(o.subProofStep)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustNegElim(o: Just.NegElim): ST = {
      return printObject(ISZ(
        ("step", printExpLitZ(o.step)),
        ("negStep", printExpLitZ(o.negStep)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustBottomElim(o: Just.BottomElim): ST = {
      return printObject(ISZ(
        ("subProofStep", printExpLitZ(o.subProofStep)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustPbc(o: Just.Pbc): ST = {
      return printObject(ISZ(
        ("subProofStep", printExpLitZ(o.subProofStep)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustForallIntro(o: Just.ForallIntro): ST = {
      return printObject(ISZ(
        ("subProofStep", printExpLitZ(o.subProofStep)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustForallElim(o: Just.ForallElim): ST = {
      return printObject(ISZ(
        ("forallStep", printExpLitZ(o.forallStep)),
        ("args", printISZ(F, o.args, printExp)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustExistsIntro(o: Just.ExistsIntro): ST = {
      return printObject(ISZ(
        ("existsStep", printExpLitZ(o.existsStep)),
        ("args", printISZ(F, o.args, printExp)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustExistsElim(o: Just.ExistsElim): ST = {
      return printObject(ISZ(
        ("existsStep", printExpLitZ(o.existsStep)),
        ("subProofStep", printExpLitZ(o.subProofStep)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustFact(o: Just.Fact): ST = {
      return printObject(ISZ(
        ("name", printName(o.name)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustInvariant(o: Just.Invariant): ST = {
      return printObject(ISZ(
        ("nameOpt", printOption(o.nameOpt, printName)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustSubst(o: Just.Subst): ST = {
      return printObject(ISZ(
        ("isRight", printB(o.isRight)),
        ("eqStep", printExpLitZ(o.eqStep)),
        ("step", printExpLitZ(o.step)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustAuto(o: Just.Auto): ST = {
      return printObject(ISZ(
        ("isAlgebra", printB(o.isAlgebra)),
        ("steps", printISZ(F, o.steps, printExpLitZ)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustCoq(o: Just.Coq): ST = {
      return printObject(ISZ(
        ("path", printExpLitString(o.path)),
        ("steps", printISZ(F, o.steps, printExpLitZ)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printTruthTableRow(o: TruthTable.Row): ST = {
      return printObject(ISZ(
        ("assignment", printTruthTableAssignment(o.assignment)),
        ("separator", printPosInfo(o.separator)),
        ("values", printTruthTableAssignment(o.values))
      ))
    }

    @pure def printTruthTableAssignment(o: TruthTable.Assignment): ST = {
      return printObject(ISZ(
        ("values", printISZ(F, o.values, printExpLitB)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printTruthTableConclusion(o: TruthTable.Conclusion): ST = {
      o match {
        case o: TruthTable.Conclusion.Validity => return printTruthTableConclusionValidity(o)
        case o: TruthTable.Conclusion.Tautology => return printTruthTableConclusionTautology(o)
        case o: TruthTable.Conclusion.Contradictory => return printTruthTableConclusionContradictory(o)
        case o: TruthTable.Conclusion.Contingent => return printTruthTableConclusionContingent(o)
      }
    }

    @pure def printTruthTableConclusionValidity(o: TruthTable.Conclusion.Validity): ST = {
      return printObject(ISZ(
        ("isValid", printB(o.isValid)),
        ("assignments", printISZ(F, o.assignments, printTruthTableAssignment)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printTruthTableConclusionTautology(o: TruthTable.Conclusion.Tautology): ST = {
      return printObject(ISZ(
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printTruthTableConclusionContradictory(o: TruthTable.Conclusion.Contradictory): ST = {
      return printObject(ISZ(
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printTruthTableConclusionContingent(o: TruthTable.Conclusion.Contingent): ST = {
      return printObject(ISZ(
        ("trueAssignments", printISZ(F, o.trueAssignments, printTruthTableAssignment)),
        ("falseAssignments", printISZ(F, o.falseAssignments, printTruthTableAssignment)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printAttr(o: Attr): ST = {
      return printObject(ISZ(
        ("posOpt", printOption(o.posOpt, printPosInfo))
      ))
    }

    @pure def printTypedAttr(o: TypedAttr): ST = {
      return printObject(ISZ(
        ("posOpt", printOption(o.posOpt, printPosInfo)),
        ("typeOpt", printOption(o.typeOpt, printType))
      ))
    }

    @pure def printResolvedAttr(o: ResolvedAttr): ST = {
      return printObject(ISZ(
        ("posOpt", printOption(o.posOpt, printPosInfo)),
        ("resOpt", printOption(o.resOpt, printResolvedInfo)),
        ("typeOpt", printOption(o.typeOpt, printType))
      ))
    }

    @pure def printResolvedInfo(o: ResolvedInfo): ST = {
      return printObject(ISZ(
        ("kind", printSymbolKind(o.kind)),
        ("ids", printISZ(T, o.ids, printString)),
        ("externFileUriOpt", printOption(o.externFileUriOpt, printString))
      ))
    }

    @pure def printSymbolKind(o: SymbolKind.Type): ST = {
      val value: String = o match {
        case SymbolKind.Package => "Package"
        case SymbolKind.Val => "Val"
        case SymbolKind.Var => "Var"
        case SymbolKind.Method => "Method"
        case SymbolKind.ExtMethod => "ExtMethod"
        case SymbolKind.SpecMethod => "SpecMethod"
        case SymbolKind.Object => "Object"
        case SymbolKind.Sig => "Sig"
        case SymbolKind.DatatypeTrait => "DatatypeTrait"
        case SymbolKind.DatatypeClass => "DatatypeClass"
        case SymbolKind.RecordTrait => "RecordTrait"
        case SymbolKind.RecordClass => "RecordClass"
        case SymbolKind.RichTrait => "RichTrait"
        case SymbolKind.RichClass => "RichClass"
        case SymbolKind.Enum => "Enum"
        case SymbolKind.TypeAlias => "TypeAlias"
        case SymbolKind.FreshVar => "FreshVar"
        case SymbolKind.QuantVar => "QuantVar"
      }
      return printObject(ISZ(
        ("type", printString("SymbolKind")),
        ("value", printString(value))
      ))
    }

    @pure def printPosInfo(o: PosInfo): ST = {
      return printObject(ISZ(
        ("fileUriOpt", printOption(o.fileUriOpt, printString)),
        ("beginLine", printZ(o.beginLine)),
        ("beginColumn", printZ(o.beginColumn)),
        ("endLine", printZ(o.endLine)),
        ("endColumn", printZ(o.endColumn)),
        ("offset", printZ(o.offset)),
        ("length", printZ(o.length))
      ))
    }

  }

  @record class Parser(input: String) {
    val parser: Json.Parser = Json.Parser.create(input)

    def parseTopUnit(): TopUnit = {
      val t = parser.parseObjectTypes(ISZ("TopUnitProgram", "TopUnitSequentUnit", "TopUnitTruthTableUnit"))
      t match {
        case "TopUnit.Program" => val r = parseTopUnitProgramT(T); return r
        case "TopUnit.SequentUnit" => val r = parseTopUnitSequentUnitT(T); return r
        case "TopUnit.TruthTableUnit" => val r = parseTopUnitTruthTableUnitT(T); return r
      }
    }

    def parseTopUnitProgram(): TopUnit.Program = {
      val r = parseTopUnitProgramT(F)
      return r
    }

    def parseTopUnitProgramT(typeParsed: B): TopUnit.Program = {
      if (!typeParsed) {
        parser.parseObjectType("TopUnit.Program")
      }
      parser.parseObjectKey("fileUriOpt")
      val fileUriOpt = parser.parseOption(parser.parseString _)
      parser.parseObjectNext()
      parser.parseObjectKey("packageName")
      val packageName = parseName()
      parser.parseObjectNext()
      parser.parseObjectKey("body")
      val body = parseBody()
      parser.parseObjectNext()
      return TopUnit.Program(fileUriOpt, packageName, body)
    }

    def parseTopUnitSequentUnit(): TopUnit.SequentUnit = {
      val r = parseTopUnitSequentUnitT(F)
      return r
    }

    def parseTopUnitSequentUnitT(typeParsed: B): TopUnit.SequentUnit = {
      if (!typeParsed) {
        parser.parseObjectType("TopUnit.SequentUnit")
      }
      parser.parseObjectKey("fileUriOpt")
      val fileUriOpt = parser.parseOption(parser.parseString _)
      parser.parseObjectNext()
      parser.parseObjectKey("sequent")
      val sequent = parseLClauseSequent()
      parser.parseObjectNext()
      return TopUnit.SequentUnit(fileUriOpt, sequent)
    }

    def parseTopUnitTruthTableUnit(): TopUnit.TruthTableUnit = {
      val r = parseTopUnitTruthTableUnitT(F)
      return r
    }

    def parseTopUnitTruthTableUnitT(typeParsed: B): TopUnit.TruthTableUnit = {
      if (!typeParsed) {
        parser.parseObjectType("TopUnit.TruthTableUnit")
      }
      parser.parseObjectKey("fileUriOpt")
      val fileUriOpt = parser.parseOption(parser.parseString _)
      parser.parseObjectNext()
      parser.parseObjectKey("stars")
      val stars = parser.parseISZ(parsePosInfo _)
      parser.parseObjectNext()
      parser.parseObjectKey("vars")
      val vars = parser.parseISZ(parseId _)
      parser.parseObjectNext()
      parser.parseObjectKey("separator")
      val separator = parsePosInfo()
      parser.parseObjectNext()
      parser.parseObjectKey("isSequent")
      val isSequent = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("sequent")
      val sequent = parseLClauseSequent()
      parser.parseObjectNext()
      parser.parseObjectKey("rows")
      val rows = parser.parseISZ(parseTruthTableRow _)
      parser.parseObjectNext()
      parser.parseObjectKey("conclusionOpt")
      val conclusionOpt = parser.parseOption(parseTruthTableConclusion _)
      parser.parseObjectNext()
      return TopUnit.TruthTableUnit(fileUriOpt, stars, vars, separator, isSequent, sequent, rows, conclusionOpt)
    }

    def parseStmt(): Stmt = {
      val t = parser.parseObjectTypes(ISZ("StmtImport", "StmtVar", "StmtVarPattern", "StmtSpecVar", "StmtMethod", "StmtExtMethod", "StmtSpecMethod", "StmtEnum", "StmtObject", "StmtSig", "StmtAbstractDatatype", "StmtRich", "StmtTypeAlias", "StmtAssign", "StmtAssignUp", "StmtAssignPattern", "StmtBlock", "StmtIf", "StmtMatch", "StmtWhile", "StmtDoWhile", "StmtFor", "StmtReturn", "StmtLStmt", "StmtExpr"))
      t match {
        case "Stmt.Import" => val r = parseStmtImportT(T); return r
        case "Stmt.Var" => val r = parseStmtVarT(T); return r
        case "Stmt.VarPattern" => val r = parseStmtVarPatternT(T); return r
        case "Stmt.SpecVar" => val r = parseStmtSpecVarT(T); return r
        case "Stmt.Method" => val r = parseStmtMethodT(T); return r
        case "Stmt.ExtMethod" => val r = parseStmtExtMethodT(T); return r
        case "Stmt.SpecMethod" => val r = parseStmtSpecMethodT(T); return r
        case "Stmt.Enum" => val r = parseStmtEnumT(T); return r
        case "Stmt.Object" => val r = parseStmtObjectT(T); return r
        case "Stmt.Sig" => val r = parseStmtSigT(T); return r
        case "Stmt.AbstractDatatype" => val r = parseStmtAbstractDatatypeT(T); return r
        case "Stmt.Rich" => val r = parseStmtRichT(T); return r
        case "Stmt.TypeAlias" => val r = parseStmtTypeAliasT(T); return r
        case "Stmt.Assign" => val r = parseStmtAssignT(T); return r
        case "Stmt.AssignUp" => val r = parseStmtAssignUpT(T); return r
        case "Stmt.AssignPattern" => val r = parseStmtAssignPatternT(T); return r
        case "Stmt.Block" => val r = parseStmtBlockT(T); return r
        case "Stmt.If" => val r = parseStmtIfT(T); return r
        case "Stmt.Match" => val r = parseStmtMatchT(T); return r
        case "Stmt.While" => val r = parseStmtWhileT(T); return r
        case "Stmt.DoWhile" => val r = parseStmtDoWhileT(T); return r
        case "Stmt.For" => val r = parseStmtForT(T); return r
        case "Stmt.Return" => val r = parseStmtReturnT(T); return r
        case "Stmt.LStmt" => val r = parseStmtLStmtT(T); return r
        case "Stmt.Expr" => val r = parseStmtExprT(T); return r
      }
    }

    def parseAssignExp(): AssignExp = {
      val t = parser.parseObjectTypes(ISZ("StmtBlock", "StmtIf", "StmtMatch", "StmtExpr"))
      t match {
        case "Stmt.Block" => val r = parseStmtBlockT(T); return r
        case "Stmt.If" => val r = parseStmtIfT(T); return r
        case "Stmt.Match" => val r = parseStmtMatchT(T); return r
        case "Stmt.Expr" => val r = parseStmtExprT(T); return r
      }
    }

    def parsePurity(): Purity.Type = {
      val r = parsePurityT(F)
      return r
    }

    def parsePurityT(typeParsed: B): Purity.Type = {
      if (!typeParsed) {
        parser.parseObjectType("Purity")
      }
      parser.parseObjectKey("value")
      val s = parser.parseString()
      s match {
        case "Impure" => return Purity.Impure
        case "Pure" => return Purity.Pure
        case "Memoize" => return Purity.Memoize
      }
    }

    def parseStmtImport(): Stmt.Import = {
      val r = parseStmtImportT(F)
      return r
    }

    def parseStmtImportT(typeParsed: B): Stmt.Import = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.Import")
      }
      parser.parseObjectKey("importers")
      val importers = parser.parseISZ(parseStmtImportImporter _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.Import(importers, attr)
    }

    def parseStmtImportImporter(): Stmt.Import.Importer = {
      val r = parseStmtImportImporterT(F)
      return r
    }

    def parseStmtImportImporterT(typeParsed: B): Stmt.Import.Importer = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.Import.Importer")
      }
      parser.parseObjectKey("name")
      val name = parseName()
      parser.parseObjectNext()
      parser.parseObjectKey("selectorOpt")
      val selectorOpt = parser.parseOption(parseStmtImportSelector _)
      parser.parseObjectNext()
      return Stmt.Import.Importer(name, selectorOpt)
    }

    def parseStmtImportSelector(): Stmt.Import.Selector = {
      val t = parser.parseObjectTypes(ISZ("StmtImportMultiSelector", "StmtImportWildcardSelector"))
      t match {
        case "Stmt.Import.MultiSelector" => val r = parseStmtImportMultiSelectorT(T); return r
        case "Stmt.Import.WildcardSelector" => val r = parseStmtImportWildcardSelectorT(T); return r
      }
    }

    def parseStmtImportMultiSelector(): Stmt.Import.MultiSelector = {
      val r = parseStmtImportMultiSelectorT(F)
      return r
    }

    def parseStmtImportMultiSelectorT(typeParsed: B): Stmt.Import.MultiSelector = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.Import.MultiSelector")
      }
      parser.parseObjectKey("selectors")
      val selectors = parser.parseISZ(parseStmtImportNamedSelector _)
      parser.parseObjectNext()
      return Stmt.Import.MultiSelector(selectors)
    }

    def parseStmtImportWildcardSelector(): Stmt.Import.WildcardSelector = {
      val r = parseStmtImportWildcardSelectorT(F)
      return r
    }

    def parseStmtImportWildcardSelectorT(typeParsed: B): Stmt.Import.WildcardSelector = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.Import.WildcardSelector")
      }
      return Stmt.Import.WildcardSelector()
    }

    def parseStmtImportNamedSelector(): Stmt.Import.NamedSelector = {
      val r = parseStmtImportNamedSelectorT(F)
      return r
    }

    def parseStmtImportNamedSelectorT(typeParsed: B): Stmt.Import.NamedSelector = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.Import.NamedSelector")
      }
      parser.parseObjectKey("from")
      val from = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("to")
      val to = parseId()
      parser.parseObjectNext()
      return Stmt.Import.NamedSelector(from, to)
    }

    def parseStmtVar(): Stmt.Var = {
      val r = parseStmtVarT(F)
      return r
    }

    def parseStmtVarT(typeParsed: B): Stmt.Var = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.Var")
      }
      parser.parseObjectKey("isVal")
      val isVal = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("tipeOpt")
      val tipeOpt = parser.parseOption(parseType _)
      parser.parseObjectNext()
      parser.parseObjectKey("initOpt")
      val initOpt = parser.parseOption(parseAssignExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.Var(isVal, id, tipeOpt, initOpt, attr)
    }

    def parseStmtVarPattern(): Stmt.VarPattern = {
      val r = parseStmtVarPatternT(F)
      return r
    }

    def parseStmtVarPatternT(typeParsed: B): Stmt.VarPattern = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.VarPattern")
      }
      parser.parseObjectKey("isVal")
      val isVal = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("pattern")
      val pattern = parsePattern()
      parser.parseObjectNext()
      parser.parseObjectKey("tipeOpt")
      val tipeOpt = parser.parseOption(parseType _)
      parser.parseObjectNext()
      parser.parseObjectKey("initOpt")
      val initOpt = parser.parseOption(parseAssignExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.VarPattern(isVal, pattern, tipeOpt, initOpt, attr)
    }

    def parseStmtSpecVar(): Stmt.SpecVar = {
      val r = parseStmtSpecVarT(F)
      return r
    }

    def parseStmtSpecVarT(typeParsed: B): Stmt.SpecVar = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.SpecVar")
      }
      parser.parseObjectKey("isVal")
      val isVal = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("tipe")
      val tipe = parseType()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.SpecVar(isVal, id, tipe, attr)
    }

    def parseStmtMethod(): Stmt.Method = {
      val r = parseStmtMethodT(F)
      return r
    }

    def parseStmtMethodT(typeParsed: B): Stmt.Method = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.Method")
      }
      parser.parseObjectKey("purity")
      val purity = parsePurity()
      parser.parseObjectNext()
      parser.parseObjectKey("hasOverride")
      val hasOverride = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("sig")
      val sig = parseMethodSig()
      parser.parseObjectNext()
      parser.parseObjectKey("contract")
      val contract = parseContract()
      parser.parseObjectNext()
      parser.parseObjectKey("bodyOpt")
      val bodyOpt = parser.parseOption(parseBody _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.Method(purity, hasOverride, sig, contract, bodyOpt, attr)
    }

    def parseStmtExtMethod(): Stmt.ExtMethod = {
      val r = parseStmtExtMethodT(F)
      return r
    }

    def parseStmtExtMethodT(typeParsed: B): Stmt.ExtMethod = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.ExtMethod")
      }
      parser.parseObjectKey("isPure")
      val isPure = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("sig")
      val sig = parseMethodSig()
      parser.parseObjectNext()
      parser.parseObjectKey("contract")
      val contract = parseContract()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.ExtMethod(isPure, sig, contract, attr)
    }

    def parseStmtSpecMethod(): Stmt.SpecMethod = {
      val r = parseStmtSpecMethodT(F)
      return r
    }

    def parseStmtSpecMethodT(typeParsed: B): Stmt.SpecMethod = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.SpecMethod")
      }
      parser.parseObjectKey("sig")
      val sig = parseMethodSig()
      parser.parseObjectNext()
      parser.parseObjectKey("defs")
      val defs = parser.parseISZ(parseSpecDef _)
      parser.parseObjectNext()
      parser.parseObjectKey("where")
      val where = parser.parseISZ(parseWhereDef _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.SpecMethod(sig, defs, where, attr)
    }

    def parseStmtEnum(): Stmt.Enum = {
      val r = parseStmtEnumT(F)
      return r
    }

    def parseStmtEnumT(typeParsed: B): Stmt.Enum = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.Enum")
      }
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("elements")
      val elements = parser.parseISZ(parseId _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.Enum(id, elements, attr)
    }

    def parseStmtObject(): Stmt.Object = {
      val r = parseStmtObjectT(F)
      return r
    }

    def parseStmtObjectT(typeParsed: B): Stmt.Object = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.Object")
      }
      parser.parseObjectKey("isExt")
      val isExt = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("parents")
      val parents = parser.parseISZ(parseType _)
      parser.parseObjectNext()
      parser.parseObjectKey("stmts")
      val stmts = parser.parseISZ(parseStmt _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.Object(isExt, id, parents, stmts, attr)
    }

    def parseStmtSig(): Stmt.Sig = {
      val r = parseStmtSigT(F)
      return r
    }

    def parseStmtSigT(typeParsed: B): Stmt.Sig = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.Sig")
      }
      parser.parseObjectKey("isImmutable")
      val isImmutable = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("typeParams")
      val typeParams = parser.parseISZ(parseTypeParam _)
      parser.parseObjectNext()
      parser.parseObjectKey("parents")
      val parents = parser.parseISZ(parseTypeNamed _)
      parser.parseObjectNext()
      parser.parseObjectKey("selfTypeOpt")
      val selfTypeOpt = parser.parseOption(parseType _)
      parser.parseObjectNext()
      parser.parseObjectKey("stmts")
      val stmts = parser.parseISZ(parseStmt _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.Sig(isImmutable, id, typeParams, parents, selfTypeOpt, stmts, attr)
    }

    def parseStmtAbstractDatatype(): Stmt.AbstractDatatype = {
      val r = parseStmtAbstractDatatypeT(F)
      return r
    }

    def parseStmtAbstractDatatypeT(typeParsed: B): Stmt.AbstractDatatype = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.AbstractDatatype")
      }
      parser.parseObjectKey("isRoot")
      val isRoot = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("isDatatype")
      val isDatatype = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("typeParams")
      val typeParams = parser.parseISZ(parseTypeParam _)
      parser.parseObjectNext()
      parser.parseObjectKey("params")
      val params = parser.parseISZ(parseAbstractDatatypeParam _)
      parser.parseObjectNext()
      parser.parseObjectKey("parents")
      val parents = parser.parseISZ(parseTypeNamed _)
      parser.parseObjectNext()
      parser.parseObjectKey("stmts")
      val stmts = parser.parseISZ(parseStmt _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.AbstractDatatype(isRoot, isDatatype, id, typeParams, params, parents, stmts, attr)
    }

    def parseStmtRich(): Stmt.Rich = {
      val r = parseStmtRichT(F)
      return r
    }

    def parseStmtRichT(typeParsed: B): Stmt.Rich = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.Rich")
      }
      parser.parseObjectKey("isRoot")
      val isRoot = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("typeParams")
      val typeParams = parser.parseISZ(parseTypeParam _)
      parser.parseObjectNext()
      parser.parseObjectKey("params")
      val params = parser.parseISZ(parseParam _)
      parser.parseObjectNext()
      parser.parseObjectKey("parents")
      val parents = parser.parseISZ(parseTypeNamed _)
      parser.parseObjectNext()
      parser.parseObjectKey("stmts")
      val stmts = parser.parseISZ(parseStmt _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.Rich(isRoot, id, typeParams, params, parents, stmts, attr)
    }

    def parseStmtTypeAlias(): Stmt.TypeAlias = {
      val r = parseStmtTypeAliasT(F)
      return r
    }

    def parseStmtTypeAliasT(typeParsed: B): Stmt.TypeAlias = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.TypeAlias")
      }
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("typeParams")
      val typeParams = parser.parseISZ(parseTypeParam _)
      parser.parseObjectNext()
      parser.parseObjectKey("tipe")
      val tipe = parseType()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.TypeAlias(id, typeParams, tipe, attr)
    }

    def parseStmtAssign(): Stmt.Assign = {
      val r = parseStmtAssignT(F)
      return r
    }

    def parseStmtAssignT(typeParsed: B): Stmt.Assign = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.Assign")
      }
      parser.parseObjectKey("lhs")
      val lhs = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("rhs")
      val rhs = parseAssignExp()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.Assign(lhs, rhs, attr)
    }

    def parseStmtAssignUp(): Stmt.AssignUp = {
      val r = parseStmtAssignUpT(F)
      return r
    }

    def parseStmtAssignUpT(typeParsed: B): Stmt.AssignUp = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.AssignUp")
      }
      parser.parseObjectKey("lhs")
      val lhs = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("rhs")
      val rhs = parseAssignExp()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.AssignUp(lhs, rhs, attr)
    }

    def parseStmtAssignPattern(): Stmt.AssignPattern = {
      val r = parseStmtAssignPatternT(F)
      return r
    }

    def parseStmtAssignPatternT(typeParsed: B): Stmt.AssignPattern = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.AssignPattern")
      }
      parser.parseObjectKey("lhs")
      val lhs = parsePattern()
      parser.parseObjectNext()
      parser.parseObjectKey("rhs")
      val rhs = parseAssignExp()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.AssignPattern(lhs, rhs, attr)
    }

    def parseStmtBlock(): Stmt.Block = {
      val r = parseStmtBlockT(F)
      return r
    }

    def parseStmtBlockT(typeParsed: B): Stmt.Block = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.Block")
      }
      parser.parseObjectKey("body")
      val body = parseBody()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.Block(body, attr)
    }

    def parseStmtIf(): Stmt.If = {
      val r = parseStmtIfT(F)
      return r
    }

    def parseStmtIfT(typeParsed: B): Stmt.If = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.If")
      }
      parser.parseObjectKey("cond")
      val cond = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("thenbody")
      val thenbody = parseBody()
      parser.parseObjectNext()
      parser.parseObjectKey("elsebody")
      val elsebody = parseBody()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.If(cond, thenbody, elsebody, attr)
    }

    def parseStmtMatch(): Stmt.Match = {
      val r = parseStmtMatchT(F)
      return r
    }

    def parseStmtMatchT(typeParsed: B): Stmt.Match = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.Match")
      }
      parser.parseObjectKey("cond")
      val cond = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("cases")
      val cases = parser.parseISZ(parseCase _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.Match(cond, cases, attr)
    }

    def parseStmtWhile(): Stmt.While = {
      val r = parseStmtWhileT(F)
      return r
    }

    def parseStmtWhileT(typeParsed: B): Stmt.While = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.While")
      }
      parser.parseObjectKey("cond")
      val cond = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("invariants")
      val invariants = parser.parseISZ(parseContractExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("modifies")
      val modifies = parser.parseISZ(parseExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("body")
      val body = parseBody()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.While(cond, invariants, modifies, body, attr)
    }

    def parseStmtDoWhile(): Stmt.DoWhile = {
      val r = parseStmtDoWhileT(F)
      return r
    }

    def parseStmtDoWhileT(typeParsed: B): Stmt.DoWhile = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.DoWhile")
      }
      parser.parseObjectKey("cond")
      val cond = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("invariants")
      val invariants = parser.parseISZ(parseContractExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("modifies")
      val modifies = parser.parseISZ(parseExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("body")
      val body = parseBody()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.DoWhile(cond, invariants, modifies, body, attr)
    }

    def parseStmtFor(): Stmt.For = {
      val r = parseStmtForT(F)
      return r
    }

    def parseStmtForT(typeParsed: B): Stmt.For = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.For")
      }
      parser.parseObjectKey("enumGen")
      val enumGen = parseEnumGenFor()
      parser.parseObjectNext()
      parser.parseObjectKey("invariants")
      val invariants = parser.parseISZ(parseContractExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("modifies")
      val modifies = parser.parseISZ(parseExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("body")
      val body = parseBody()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.For(enumGen, invariants, modifies, body, attr)
    }

    def parseStmtReturn(): Stmt.Return = {
      val r = parseStmtReturnT(F)
      return r
    }

    def parseStmtReturnT(typeParsed: B): Stmt.Return = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.Return")
      }
      parser.parseObjectKey("expOpt")
      val expOpt = parser.parseOption(parseExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.Return(expOpt, attr)
    }

    def parseStmtLStmt(): Stmt.LStmt = {
      val r = parseStmtLStmtT(F)
      return r
    }

    def parseStmtLStmtT(typeParsed: B): Stmt.LStmt = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.LStmt")
      }
      parser.parseObjectKey("clause")
      val clause = parseLClause()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.LStmt(clause, attr)
    }

    def parseStmtExpr(): Stmt.Expr = {
      val r = parseStmtExprT(F)
      return r
    }

    def parseStmtExprT(typeParsed: B): Stmt.Expr = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.Expr")
      }
      parser.parseObjectKey("exp")
      val exp = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.Expr(exp, attr)
    }

    def parseLClause(): LClause = {
      val t = parser.parseObjectTypes(ISZ("LClauseInvariants", "LClauseFacts", "LClauseTheorems", "LClauseSequent", "LClauseProof"))
      t match {
        case "LClause.Invariants" => val r = parseLClauseInvariantsT(T); return r
        case "LClause.Facts" => val r = parseLClauseFactsT(T); return r
        case "LClause.Theorems" => val r = parseLClauseTheoremsT(T); return r
        case "LClause.Sequent" => val r = parseLClauseSequentT(T); return r
        case "LClause.Proof" => val r = parseLClauseProofT(T); return r
      }
    }

    def parseLClauseInvariants(): LClause.Invariants = {
      val r = parseLClauseInvariantsT(F)
      return r
    }

    def parseLClauseInvariantsT(typeParsed: B): LClause.Invariants = {
      if (!typeParsed) {
        parser.parseObjectType("LClause.Invariants")
      }
      parser.parseObjectKey("value")
      val value = parser.parseISZ(parseContractExp _)
      parser.parseObjectNext()
      return LClause.Invariants(value)
    }

    def parseLClauseFacts(): LClause.Facts = {
      val r = parseLClauseFactsT(F)
      return r
    }

    def parseLClauseFactsT(typeParsed: B): LClause.Facts = {
      if (!typeParsed) {
        parser.parseObjectType("LClause.Facts")
      }
      parser.parseObjectKey("value")
      val value = parser.parseISZ(parseLClauseFact _)
      parser.parseObjectNext()
      return LClause.Facts(value)
    }

    def parseLClauseFact(): LClause.Fact = {
      val r = parseLClauseFactT(F)
      return r
    }

    def parseLClauseFactT(typeParsed: B): LClause.Fact = {
      if (!typeParsed) {
        parser.parseObjectType("LClause.Fact")
      }
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("exp")
      val exp = parseExp()
      parser.parseObjectNext()
      return LClause.Fact(id, exp)
    }

    def parseLClauseTheorems(): LClause.Theorems = {
      val r = parseLClauseTheoremsT(F)
      return r
    }

    def parseLClauseTheoremsT(typeParsed: B): LClause.Theorems = {
      if (!typeParsed) {
        parser.parseObjectType("LClause.Theorems")
      }
      parser.parseObjectKey("value")
      val value = parser.parseISZ(parseLClauseTheorem _)
      parser.parseObjectNext()
      return LClause.Theorems(value)
    }

    def parseLClauseTheorem(): LClause.Theorem = {
      val r = parseLClauseTheoremT(F)
      return r
    }

    def parseLClauseTheoremT(typeParsed: B): LClause.Theorem = {
      if (!typeParsed) {
        parser.parseObjectType("LClause.Theorem")
      }
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("sequent")
      val sequent = parseLClauseSequent()
      parser.parseObjectNext()
      return LClause.Theorem(id, sequent)
    }

    def parseLClauseSequent(): LClause.Sequent = {
      val r = parseLClauseSequentT(F)
      return r
    }

    def parseLClauseSequentT(typeParsed: B): LClause.Sequent = {
      if (!typeParsed) {
        parser.parseObjectType("LClause.Sequent")
      }
      parser.parseObjectKey("premises")
      val premises = parser.parseISZ(parseExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("conclusions")
      val conclusions = parser.parseISZ(parseExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("proofOpt")
      val proofOpt = parser.parseOption(parseLClauseProof _)
      parser.parseObjectNext()
      return LClause.Sequent(premises, conclusions, proofOpt)
    }

    def parseLClauseProof(): LClause.Proof = {
      val r = parseLClauseProofT(F)
      return r
    }

    def parseLClauseProofT(typeParsed: B): LClause.Proof = {
      if (!typeParsed) {
        parser.parseObjectType("LClause.Proof")
      }
      parser.parseObjectKey("steps")
      val steps = parser.parseISZ(parseProofStep _)
      parser.parseObjectNext()
      return LClause.Proof(steps)
    }

    def parseContractExp(): ContractExp = {
      val r = parseContractExpT(F)
      return r
    }

    def parseContractExpT(typeParsed: B): ContractExp = {
      if (!typeParsed) {
        parser.parseObjectType("ContractExp")
      }
      parser.parseObjectKey("idOpt")
      val idOpt = parser.parseOption(parseId _)
      parser.parseObjectNext()
      parser.parseObjectKey("exp")
      val exp = parseExp()
      parser.parseObjectNext()
      return ContractExp(idOpt, exp)
    }

    def parseCase(): Case = {
      val r = parseCaseT(F)
      return r
    }

    def parseCaseT(typeParsed: B): Case = {
      if (!typeParsed) {
        parser.parseObjectType("Case")
      }
      parser.parseObjectKey("pattern")
      val pattern = parsePattern()
      parser.parseObjectNext()
      parser.parseObjectKey("condOpt")
      val condOpt = parser.parseOption(parseExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("body")
      val body = parseBody()
      parser.parseObjectNext()
      return Case(pattern, condOpt, body)
    }

    def parseEnumGenRange(): EnumGen.Range = {
      val t = parser.parseObjectTypes(ISZ("EnumGenRangeExpr", "EnumGenRangeIndices", "EnumGenRangeStep"))
      t match {
        case "EnumGen.Range.Expr" => val r = parseEnumGenRangeExprT(T); return r
        case "EnumGen.Range.Indices" => val r = parseEnumGenRangeIndicesT(T); return r
        case "EnumGen.Range.Step" => val r = parseEnumGenRangeStepT(T); return r
      }
    }

    def parseEnumGenRangeExpr(): EnumGen.Range.Expr = {
      val r = parseEnumGenRangeExprT(F)
      return r
    }

    def parseEnumGenRangeExprT(typeParsed: B): EnumGen.Range.Expr = {
      if (!typeParsed) {
        parser.parseObjectType("EnumGen.Range.Expr")
      }
      parser.parseObjectKey("isReverse")
      val isReverse = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("exp")
      val exp = parseExp()
      parser.parseObjectNext()
      return EnumGen.Range.Expr(isReverse, exp)
    }

    def parseEnumGenRangeIndices(): EnumGen.Range.Indices = {
      val r = parseEnumGenRangeIndicesT(F)
      return r
    }

    def parseEnumGenRangeIndicesT(typeParsed: B): EnumGen.Range.Indices = {
      if (!typeParsed) {
        parser.parseObjectType("EnumGen.Range.Indices")
      }
      parser.parseObjectKey("isReverse")
      val isReverse = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("exp")
      val exp = parseExp()
      parser.parseObjectNext()
      return EnumGen.Range.Indices(isReverse, exp)
    }

    def parseEnumGenRangeStep(): EnumGen.Range.Step = {
      val r = parseEnumGenRangeStepT(F)
      return r
    }

    def parseEnumGenRangeStepT(typeParsed: B): EnumGen.Range.Step = {
      if (!typeParsed) {
        parser.parseObjectType("EnumGen.Range.Step")
      }
      parser.parseObjectKey("isInclusive")
      val isInclusive = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("start")
      val start = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("end")
      val end = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("byOpt")
      val byOpt = parser.parseOption(parseExp _)
      parser.parseObjectNext()
      return EnumGen.Range.Step(isInclusive, start, end, byOpt)
    }

    def parseEnumGenFor(): EnumGen.For = {
      val r = parseEnumGenForT(F)
      return r
    }

    def parseEnumGenForT(typeParsed: B): EnumGen.For = {
      if (!typeParsed) {
        parser.parseObjectType("EnumGen.For")
      }
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("range")
      val range = parseEnumGenRange()
      parser.parseObjectNext()
      parser.parseObjectKey("condOpt")
      val condOpt = parser.parseOption(parseExp _)
      parser.parseObjectNext()
      return EnumGen.For(id, range, condOpt)
    }

    def parseType(): Type = {
      val t = parser.parseObjectTypes(ISZ("TypeNamed", "TypeFun", "TypeTuple"))
      t match {
        case "Type.Named" => val r = parseTypeNamedT(T); return r
        case "Type.Fun" => val r = parseTypeFunT(T); return r
        case "Type.Tuple" => val r = parseTypeTupleT(T); return r
      }
    }

    def parseTypeNamed(): Type.Named = {
      val r = parseTypeNamedT(F)
      return r
    }

    def parseTypeNamedT(typeParsed: B): Type.Named = {
      if (!typeParsed) {
        parser.parseObjectType("Type.Named")
      }
      parser.parseObjectKey("name")
      val name = parseName()
      parser.parseObjectNext()
      parser.parseObjectKey("typeArgs")
      val typeArgs = parser.parseISZ(parseType _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseTypedAttr()
      parser.parseObjectNext()
      return Type.Named(name, typeArgs, attr)
    }

    def parseTypeFun(): Type.Fun = {
      val r = parseTypeFunT(F)
      return r
    }

    def parseTypeFunT(typeParsed: B): Type.Fun = {
      if (!typeParsed) {
        parser.parseObjectType("Type.Fun")
      }
      parser.parseObjectKey("args")
      val args = parser.parseISZ(parseType _)
      parser.parseObjectNext()
      parser.parseObjectKey("ret")
      val ret = parseType()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseTypedAttr()
      parser.parseObjectNext()
      return Type.Fun(args, ret, attr)
    }

    def parseTypeTuple(): Type.Tuple = {
      val r = parseTypeTupleT(F)
      return r
    }

    def parseTypeTupleT(typeParsed: B): Type.Tuple = {
      if (!typeParsed) {
        parser.parseObjectType("Type.Tuple")
      }
      parser.parseObjectKey("args")
      val args = parser.parseISZ(parseType _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseTypedAttr()
      parser.parseObjectNext()
      return Type.Tuple(args, attr)
    }

    def parsePattern(): Pattern = {
      val t = parser.parseObjectTypes(ISZ("PatternLiteral", "PatternRef", "PatternVariable", "PatternWildcard", "PatternSeqWildcard", "PatternStructure"))
      t match {
        case "Pattern.Literal" => val r = parsePatternLiteralT(T); return r
        case "Pattern.Ref" => val r = parsePatternRefT(T); return r
        case "Pattern.Variable" => val r = parsePatternVariableT(T); return r
        case "Pattern.Wildcard" => val r = parsePatternWildcardT(T); return r
        case "Pattern.SeqWildcard" => val r = parsePatternSeqWildcardT(T); return r
        case "Pattern.Structure" => val r = parsePatternStructureT(T); return r
      }
    }

    def parsePatternLiteral(): Pattern.Literal = {
      val r = parsePatternLiteralT(F)
      return r
    }

    def parsePatternLiteralT(typeParsed: B): Pattern.Literal = {
      if (!typeParsed) {
        parser.parseObjectType("Pattern.Literal")
      }
      parser.parseObjectKey("lit")
      val lit = parseLit()
      parser.parseObjectNext()
      return Pattern.Literal(lit)
    }

    def parsePatternRef(): Pattern.Ref = {
      val r = parsePatternRefT(F)
      return r
    }

    def parsePatternRefT(typeParsed: B): Pattern.Ref = {
      if (!typeParsed) {
        parser.parseObjectType("Pattern.Ref")
      }
      parser.parseObjectKey("name")
      val name = parseName()
      parser.parseObjectNext()
      return Pattern.Ref(name)
    }

    def parsePatternVariable(): Pattern.Variable = {
      val r = parsePatternVariableT(F)
      return r
    }

    def parsePatternVariableT(typeParsed: B): Pattern.Variable = {
      if (!typeParsed) {
        parser.parseObjectType("Pattern.Variable")
      }
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("typeOpt")
      val typeOpt = parser.parseOption(parseType _)
      parser.parseObjectNext()
      return Pattern.Variable(id, typeOpt)
    }

    def parsePatternWildcard(): Pattern.Wildcard = {
      val r = parsePatternWildcardT(F)
      return r
    }

    def parsePatternWildcardT(typeParsed: B): Pattern.Wildcard = {
      if (!typeParsed) {
        parser.parseObjectType("Pattern.Wildcard")
      }
      parser.parseObjectKey("typeOpt")
      val typeOpt = parser.parseOption(parseType _)
      parser.parseObjectNext()
      return Pattern.Wildcard(typeOpt)
    }

    def parsePatternSeqWildcard(): Pattern.SeqWildcard = {
      val r = parsePatternSeqWildcardT(F)
      return r
    }

    def parsePatternSeqWildcardT(typeParsed: B): Pattern.SeqWildcard = {
      if (!typeParsed) {
        parser.parseObjectType("Pattern.SeqWildcard")
      }
      return Pattern.SeqWildcard()
    }

    def parsePatternStructure(): Pattern.Structure = {
      val r = parsePatternStructureT(F)
      return r
    }

    def parsePatternStructureT(typeParsed: B): Pattern.Structure = {
      if (!typeParsed) {
        parser.parseObjectType("Pattern.Structure")
      }
      parser.parseObjectKey("idOpt")
      val idOpt = parser.parseOption(parseId _)
      parser.parseObjectNext()
      parser.parseObjectKey("nameOpt")
      val nameOpt = parser.parseOption(parseName _)
      parser.parseObjectNext()
      parser.parseObjectKey("patterns")
      val patterns = parser.parseISZ(parsePattern _)
      parser.parseObjectNext()
      return Pattern.Structure(idOpt, nameOpt, patterns)
    }

    def parseExp(): Exp = {
      val t = parser.parseObjectTypes(ISZ("ExpLitB", "ExpLitC", "ExpLitZ", "ExpLitZ8", "ExpLitZ16", "ExpLitZ32", "ExpLitZ64", "ExpLitN", "ExpLitN8", "ExpLitN16", "ExpLitN32", "ExpLitN64", "ExpLitS8", "ExpLitS16", "ExpLitS32", "ExpLitS64", "ExpLitU8", "ExpLitU16", "ExpLitU32", "ExpLitU64", "ExpLitF32", "ExpLitF64", "ExpLitR", "ExpLitBv", "ExpLitString", "ExpStringInterpolate", "ExpThis", "ExpSuper", "ExpUnary", "ExpBinary", "ExpIdent", "ExpEta", "ExpTuple", "ExpSelect", "ExpInvoke", "ExpInvokeNamed", "ExpIf", "ExpFun", "ExpForYield", "ExpQuant"))
      t match {
        case "Exp.LitB" => val r = parseExpLitBT(T); return r
        case "Exp.LitC" => val r = parseExpLitCT(T); return r
        case "Exp.LitZ" => val r = parseExpLitZT(T); return r
        case "Exp.LitZ8" => val r = parseExpLitZ8T(T); return r
        case "Exp.LitZ16" => val r = parseExpLitZ16T(T); return r
        case "Exp.LitZ32" => val r = parseExpLitZ32T(T); return r
        case "Exp.LitZ64" => val r = parseExpLitZ64T(T); return r
        case "Exp.LitN" => val r = parseExpLitNT(T); return r
        case "Exp.LitN8" => val r = parseExpLitN8T(T); return r
        case "Exp.LitN16" => val r = parseExpLitN16T(T); return r
        case "Exp.LitN32" => val r = parseExpLitN32T(T); return r
        case "Exp.LitN64" => val r = parseExpLitN64T(T); return r
        case "Exp.LitS8" => val r = parseExpLitS8T(T); return r
        case "Exp.LitS16" => val r = parseExpLitS16T(T); return r
        case "Exp.LitS32" => val r = parseExpLitS32T(T); return r
        case "Exp.LitS64" => val r = parseExpLitS64T(T); return r
        case "Exp.LitU8" => val r = parseExpLitU8T(T); return r
        case "Exp.LitU16" => val r = parseExpLitU16T(T); return r
        case "Exp.LitU32" => val r = parseExpLitU32T(T); return r
        case "Exp.LitU64" => val r = parseExpLitU64T(T); return r
        case "Exp.LitF32" => val r = parseExpLitF32T(T); return r
        case "Exp.LitF64" => val r = parseExpLitF64T(T); return r
        case "Exp.LitR" => val r = parseExpLitRT(T); return r
        case "Exp.LitBv" => val r = parseExpLitBvT(T); return r
        case "Exp.LitString" => val r = parseExpLitStringT(T); return r
        case "Exp.StringInterpolate" => val r = parseExpStringInterpolateT(T); return r
        case "Exp.This" => val r = parseExpThisT(T); return r
        case "Exp.Super" => val r = parseExpSuperT(T); return r
        case "Exp.Unary" => val r = parseExpUnaryT(T); return r
        case "Exp.Binary" => val r = parseExpBinaryT(T); return r
        case "Exp.Ident" => val r = parseExpIdentT(T); return r
        case "Exp.Eta" => val r = parseExpEtaT(T); return r
        case "Exp.Tuple" => val r = parseExpTupleT(T); return r
        case "Exp.Select" => val r = parseExpSelectT(T); return r
        case "Exp.Invoke" => val r = parseExpInvokeT(T); return r
        case "Exp.InvokeNamed" => val r = parseExpInvokeNamedT(T); return r
        case "Exp.If" => val r = parseExpIfT(T); return r
        case "Exp.Fun" => val r = parseExpFunT(T); return r
        case "Exp.ForYield" => val r = parseExpForYieldT(T); return r
        case "Exp.Quant" => val r = parseExpQuantT(T); return r
      }
    }

    def parseLit(): Lit = {
      val t = parser.parseObjectTypes(ISZ("ExpLitB", "ExpLitC", "ExpLitZ", "ExpLitZ8", "ExpLitZ16", "ExpLitZ32", "ExpLitZ64", "ExpLitN", "ExpLitN8", "ExpLitN16", "ExpLitN32", "ExpLitN64", "ExpLitS8", "ExpLitS16", "ExpLitS32", "ExpLitS64", "ExpLitU8", "ExpLitU16", "ExpLitU32", "ExpLitU64", "ExpLitF32", "ExpLitF64", "ExpLitR", "ExpLitBv", "ExpLitString"))
      t match {
        case "Exp.LitB" => val r = parseExpLitBT(T); return r
        case "Exp.LitC" => val r = parseExpLitCT(T); return r
        case "Exp.LitZ" => val r = parseExpLitZT(T); return r
        case "Exp.LitZ8" => val r = parseExpLitZ8T(T); return r
        case "Exp.LitZ16" => val r = parseExpLitZ16T(T); return r
        case "Exp.LitZ32" => val r = parseExpLitZ32T(T); return r
        case "Exp.LitZ64" => val r = parseExpLitZ64T(T); return r
        case "Exp.LitN" => val r = parseExpLitNT(T); return r
        case "Exp.LitN8" => val r = parseExpLitN8T(T); return r
        case "Exp.LitN16" => val r = parseExpLitN16T(T); return r
        case "Exp.LitN32" => val r = parseExpLitN32T(T); return r
        case "Exp.LitN64" => val r = parseExpLitN64T(T); return r
        case "Exp.LitS8" => val r = parseExpLitS8T(T); return r
        case "Exp.LitS16" => val r = parseExpLitS16T(T); return r
        case "Exp.LitS32" => val r = parseExpLitS32T(T); return r
        case "Exp.LitS64" => val r = parseExpLitS64T(T); return r
        case "Exp.LitU8" => val r = parseExpLitU8T(T); return r
        case "Exp.LitU16" => val r = parseExpLitU16T(T); return r
        case "Exp.LitU32" => val r = parseExpLitU32T(T); return r
        case "Exp.LitU64" => val r = parseExpLitU64T(T); return r
        case "Exp.LitF32" => val r = parseExpLitF32T(T); return r
        case "Exp.LitF64" => val r = parseExpLitF64T(T); return r
        case "Exp.LitR" => val r = parseExpLitRT(T); return r
        case "Exp.LitBv" => val r = parseExpLitBvT(T); return r
        case "Exp.LitString" => val r = parseExpLitStringT(T); return r
      }
    }

    def parseExpLitB(): Exp.LitB = {
      val r = parseExpLitBT(F)
      return r
    }

    def parseExpLitBT(typeParsed: B): Exp.LitB = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitB")
      }
      parser.parseObjectKey("value")
      val value = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitB(value, attr)
    }

    def parseExpLitC(): Exp.LitC = {
      val r = parseExpLitCT(F)
      return r
    }

    def parseExpLitCT(typeParsed: B): Exp.LitC = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitC")
      }
      parser.parseObjectKey("value")
      val value = parser.parseC()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitC(value, attr)
    }

    def parseExpLitZ(): Exp.LitZ = {
      val r = parseExpLitZT(F)
      return r
    }

    def parseExpLitZT(typeParsed: B): Exp.LitZ = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitZ")
      }
      parser.parseObjectKey("value")
      val value = parser.parseZ()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitZ(value, attr)
    }

    def parseExpLitZ8(): Exp.LitZ8 = {
      val r = parseExpLitZ8T(F)
      return r
    }

    def parseExpLitZ8T(typeParsed: B): Exp.LitZ8 = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitZ8")
      }
      parser.parseObjectKey("value")
      val value = parser.parseZ8()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitZ8(value, attr)
    }

    def parseExpLitZ16(): Exp.LitZ16 = {
      val r = parseExpLitZ16T(F)
      return r
    }

    def parseExpLitZ16T(typeParsed: B): Exp.LitZ16 = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitZ16")
      }
      parser.parseObjectKey("value")
      val value = parser.parseZ16()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitZ16(value, attr)
    }

    def parseExpLitZ32(): Exp.LitZ32 = {
      val r = parseExpLitZ32T(F)
      return r
    }

    def parseExpLitZ32T(typeParsed: B): Exp.LitZ32 = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitZ32")
      }
      parser.parseObjectKey("value")
      val value = parser.parseZ32()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitZ32(value, attr)
    }

    def parseExpLitZ64(): Exp.LitZ64 = {
      val r = parseExpLitZ64T(F)
      return r
    }

    def parseExpLitZ64T(typeParsed: B): Exp.LitZ64 = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitZ64")
      }
      parser.parseObjectKey("value")
      val value = parser.parseZ64()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitZ64(value, attr)
    }

    def parseExpLitN(): Exp.LitN = {
      val r = parseExpLitNT(F)
      return r
    }

    def parseExpLitNT(typeParsed: B): Exp.LitN = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitN")
      }
      parser.parseObjectKey("value")
      val value = parser.parseN()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitN(value, attr)
    }

    def parseExpLitN8(): Exp.LitN8 = {
      val r = parseExpLitN8T(F)
      return r
    }

    def parseExpLitN8T(typeParsed: B): Exp.LitN8 = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitN8")
      }
      parser.parseObjectKey("value")
      val value = parser.parseN8()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitN8(value, attr)
    }

    def parseExpLitN16(): Exp.LitN16 = {
      val r = parseExpLitN16T(F)
      return r
    }

    def parseExpLitN16T(typeParsed: B): Exp.LitN16 = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitN16")
      }
      parser.parseObjectKey("value")
      val value = parser.parseN16()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitN16(value, attr)
    }

    def parseExpLitN32(): Exp.LitN32 = {
      val r = parseExpLitN32T(F)
      return r
    }

    def parseExpLitN32T(typeParsed: B): Exp.LitN32 = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitN32")
      }
      parser.parseObjectKey("value")
      val value = parser.parseN32()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitN32(value, attr)
    }

    def parseExpLitN64(): Exp.LitN64 = {
      val r = parseExpLitN64T(F)
      return r
    }

    def parseExpLitN64T(typeParsed: B): Exp.LitN64 = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitN64")
      }
      parser.parseObjectKey("value")
      val value = parser.parseN64()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitN64(value, attr)
    }

    def parseExpLitS8(): Exp.LitS8 = {
      val r = parseExpLitS8T(F)
      return r
    }

    def parseExpLitS8T(typeParsed: B): Exp.LitS8 = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitS8")
      }
      parser.parseObjectKey("value")
      val value = parser.parseS8()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitS8(value, attr)
    }

    def parseExpLitS16(): Exp.LitS16 = {
      val r = parseExpLitS16T(F)
      return r
    }

    def parseExpLitS16T(typeParsed: B): Exp.LitS16 = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitS16")
      }
      parser.parseObjectKey("value")
      val value = parser.parseS16()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitS16(value, attr)
    }

    def parseExpLitS32(): Exp.LitS32 = {
      val r = parseExpLitS32T(F)
      return r
    }

    def parseExpLitS32T(typeParsed: B): Exp.LitS32 = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitS32")
      }
      parser.parseObjectKey("value")
      val value = parser.parseS32()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitS32(value, attr)
    }

    def parseExpLitS64(): Exp.LitS64 = {
      val r = parseExpLitS64T(F)
      return r
    }

    def parseExpLitS64T(typeParsed: B): Exp.LitS64 = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitS64")
      }
      parser.parseObjectKey("value")
      val value = parser.parseS64()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitS64(value, attr)
    }

    def parseExpLitU8(): Exp.LitU8 = {
      val r = parseExpLitU8T(F)
      return r
    }

    def parseExpLitU8T(typeParsed: B): Exp.LitU8 = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitU8")
      }
      parser.parseObjectKey("value")
      val value = parser.parseU8()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitU8(value, attr)
    }

    def parseExpLitU16(): Exp.LitU16 = {
      val r = parseExpLitU16T(F)
      return r
    }

    def parseExpLitU16T(typeParsed: B): Exp.LitU16 = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitU16")
      }
      parser.parseObjectKey("value")
      val value = parser.parseU16()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitU16(value, attr)
    }

    def parseExpLitU32(): Exp.LitU32 = {
      val r = parseExpLitU32T(F)
      return r
    }

    def parseExpLitU32T(typeParsed: B): Exp.LitU32 = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitU32")
      }
      parser.parseObjectKey("value")
      val value = parser.parseU32()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitU32(value, attr)
    }

    def parseExpLitU64(): Exp.LitU64 = {
      val r = parseExpLitU64T(F)
      return r
    }

    def parseExpLitU64T(typeParsed: B): Exp.LitU64 = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitU64")
      }
      parser.parseObjectKey("value")
      val value = parser.parseU64()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitU64(value, attr)
    }

    def parseExpLitF32(): Exp.LitF32 = {
      val r = parseExpLitF32T(F)
      return r
    }

    def parseExpLitF32T(typeParsed: B): Exp.LitF32 = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitF32")
      }
      parser.parseObjectKey("value")
      val value = parser.parseF32()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitF32(value, attr)
    }

    def parseExpLitF64(): Exp.LitF64 = {
      val r = parseExpLitF64T(F)
      return r
    }

    def parseExpLitF64T(typeParsed: B): Exp.LitF64 = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitF64")
      }
      parser.parseObjectKey("value")
      val value = parser.parseF64()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitF64(value, attr)
    }

    def parseExpLitR(): Exp.LitR = {
      val r = parseExpLitRT(F)
      return r
    }

    def parseExpLitRT(typeParsed: B): Exp.LitR = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitR")
      }
      parser.parseObjectKey("value")
      val value = parser.parseR()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitR(value, attr)
    }

    def parseExpLitBv(): Exp.LitBv = {
      val r = parseExpLitBvT(F)
      return r
    }

    def parseExpLitBvT(typeParsed: B): Exp.LitBv = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitBv")
      }
      parser.parseObjectKey("value")
      val value = parser.parseISZ(parser.parseB _)
      parser.parseObjectNext()
      parser.parseObjectKey("tipe")
      val tipe = parseType()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitBv(value, tipe, attr)
    }

    def parseExpLitString(): Exp.LitString = {
      val r = parseExpLitStringT(F)
      return r
    }

    def parseExpLitStringT(typeParsed: B): Exp.LitString = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.LitString")
      }
      parser.parseObjectKey("value")
      val value = parser.parseString()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.LitString(value, attr)
    }

    def parseExpStringInterpolate(): Exp.StringInterpolate = {
      val r = parseExpStringInterpolateT(F)
      return r
    }

    def parseExpStringInterpolateT(typeParsed: B): Exp.StringInterpolate = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.StringInterpolate")
      }
      parser.parseObjectKey("prefix")
      val prefix = parser.parseString()
      parser.parseObjectNext()
      parser.parseObjectKey("lits")
      val lits = parser.parseISZ(parseExpLitString _)
      parser.parseObjectNext()
      parser.parseObjectKey("args")
      val args = parser.parseISZ(parseExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.StringInterpolate(prefix, lits, args, attr)
    }

    def parseExpThis(): Exp.This = {
      val r = parseExpThisT(F)
      return r
    }

    def parseExpThisT(typeParsed: B): Exp.This = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.This")
      }
      parser.parseObjectKey("attr")
      val attr = parseTypedAttr()
      parser.parseObjectNext()
      return Exp.This(attr)
    }

    def parseExpSuper(): Exp.Super = {
      val r = parseExpSuperT(F)
      return r
    }

    def parseExpSuperT(typeParsed: B): Exp.Super = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.Super")
      }
      parser.parseObjectKey("attr")
      val attr = parseTypedAttr()
      parser.parseObjectNext()
      return Exp.Super(attr)
    }

    def parseExpUnaryOp(): Exp.UnaryOp.Type = {
      val r = parseExpUnaryOpT(F)
      return r
    }

    def parseExpUnaryOpT(typeParsed: B): Exp.UnaryOp.Type = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.UnaryOp")
      }
      parser.parseObjectKey("value")
      val s = parser.parseString()
      s match {
        case "Not" => return Exp.UnaryOp.Not
        case "Plus" => return Exp.UnaryOp.Plus
        case "Minus" => return Exp.UnaryOp.Minus
        case "Complement" => return Exp.UnaryOp.Complement
      }
    }

    def parseExpUnary(): Exp.Unary = {
      val r = parseExpUnaryT(F)
      return r
    }

    def parseExpUnaryT(typeParsed: B): Exp.Unary = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.Unary")
      }
      parser.parseObjectKey("op")
      val op = parseExpUnaryOp()
      parser.parseObjectNext()
      parser.parseObjectKey("exp")
      val exp = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseTypedAttr()
      parser.parseObjectNext()
      return Exp.Unary(op, exp, attr)
    }

    def parseExpBinaryOp(): Exp.BinaryOp.Type = {
      val r = parseExpBinaryOpT(F)
      return r
    }

    def parseExpBinaryOpT(typeParsed: B): Exp.BinaryOp.Type = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.BinaryOp")
      }
      parser.parseObjectKey("value")
      val s = parser.parseString()
      s match {
        case "Add" => return Exp.BinaryOp.Add
        case "Sub" => return Exp.BinaryOp.Sub
        case "Mul" => return Exp.BinaryOp.Mul
        case "Div" => return Exp.BinaryOp.Div
        case "Rem" => return Exp.BinaryOp.Rem
        case "Eq" => return Exp.BinaryOp.Eq
        case "Ne" => return Exp.BinaryOp.Ne
        case "Shl" => return Exp.BinaryOp.Shl
        case "Shr" => return Exp.BinaryOp.Shr
        case "Ushr" => return Exp.BinaryOp.Ushr
        case "Lt" => return Exp.BinaryOp.Lt
        case "Le" => return Exp.BinaryOp.Le
        case "Gt" => return Exp.BinaryOp.Gt
        case "Ge" => return Exp.BinaryOp.Ge
        case "And" => return Exp.BinaryOp.And
        case "Or" => return Exp.BinaryOp.Or
        case "Xor" => return Exp.BinaryOp.Xor
        case "Imply" => return Exp.BinaryOp.Imply
        case "CondAnd" => return Exp.BinaryOp.CondAnd
        case "CondOr" => return Exp.BinaryOp.CondOr
        case "Append" => return Exp.BinaryOp.Append
        case "Prepend" => return Exp.BinaryOp.Prepend
        case "AppendAll" => return Exp.BinaryOp.AppendAll
        case "RemoveAll" => return Exp.BinaryOp.RemoveAll
      }
    }

    def parseExpBinary(): Exp.Binary = {
      val r = parseExpBinaryT(F)
      return r
    }

    def parseExpBinaryT(typeParsed: B): Exp.Binary = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.Binary")
      }
      parser.parseObjectKey("left")
      val left = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("op")
      val op = parseExpBinaryOp()
      parser.parseObjectNext()
      parser.parseObjectKey("right")
      val right = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseTypedAttr()
      parser.parseObjectNext()
      return Exp.Binary(left, op, right, attr)
    }

    def parseExpIdent(): Exp.Ident = {
      val r = parseExpIdentT(F)
      return r
    }

    def parseExpIdentT(typeParsed: B): Exp.Ident = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.Ident")
      }
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseResolvedAttr()
      parser.parseObjectNext()
      return Exp.Ident(id, attr)
    }

    def parseExpEta(): Exp.Eta = {
      val r = parseExpEtaT(F)
      return r
    }

    def parseExpEtaT(typeParsed: B): Exp.Eta = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.Eta")
      }
      parser.parseObjectKey("exp")
      val exp = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseResolvedAttr()
      parser.parseObjectNext()
      return Exp.Eta(exp, attr)
    }

    def parseExpTuple(): Exp.Tuple = {
      val r = parseExpTupleT(F)
      return r
    }

    def parseExpTupleT(typeParsed: B): Exp.Tuple = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.Tuple")
      }
      parser.parseObjectKey("args")
      val args = parser.parseISZ(parseExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseTypedAttr()
      parser.parseObjectNext()
      return Exp.Tuple(args, attr)
    }

    def parseExpSelect(): Exp.Select = {
      val r = parseExpSelectT(F)
      return r
    }

    def parseExpSelectT(typeParsed: B): Exp.Select = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.Select")
      }
      parser.parseObjectKey("receiverOpt")
      val receiverOpt = parser.parseOption(parseExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("targs")
      val targs = parser.parseISZ(parseType _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseResolvedAttr()
      parser.parseObjectNext()
      return Exp.Select(receiverOpt, id, targs, attr)
    }

    def parseExpInvoke(): Exp.Invoke = {
      val r = parseExpInvokeT(F)
      return r
    }

    def parseExpInvokeT(typeParsed: B): Exp.Invoke = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.Invoke")
      }
      parser.parseObjectKey("receiverOpt")
      val receiverOpt = parser.parseOption(parseExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("targs")
      val targs = parser.parseISZ(parseType _)
      parser.parseObjectNext()
      parser.parseObjectKey("args")
      val args = parser.parseISZ(parseExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseResolvedAttr()
      parser.parseObjectNext()
      return Exp.Invoke(receiverOpt, id, targs, args, attr)
    }

    def parseExpInvokeNamed(): Exp.InvokeNamed = {
      val r = parseExpInvokeNamedT(F)
      return r
    }

    def parseExpInvokeNamedT(typeParsed: B): Exp.InvokeNamed = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.InvokeNamed")
      }
      parser.parseObjectKey("receiverOpt")
      val receiverOpt = parser.parseOption(parseExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("targs")
      val targs = parser.parseISZ(parseType _)
      parser.parseObjectNext()
      parser.parseObjectKey("args")
      val args = parser.parseISZ(parseNamedArg _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseResolvedAttr()
      parser.parseObjectNext()
      return Exp.InvokeNamed(receiverOpt, id, targs, args, attr)
    }

    def parseExpIf(): Exp.If = {
      val r = parseExpIfT(F)
      return r
    }

    def parseExpIfT(typeParsed: B): Exp.If = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.If")
      }
      parser.parseObjectKey("cond")
      val cond = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("thenExp")
      val thenExp = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("elseExp")
      val elseExp = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseTypedAttr()
      parser.parseObjectNext()
      return Exp.If(cond, thenExp, elseExp, attr)
    }

    def parseExpFun(): Exp.Fun = {
      val r = parseExpFunT(F)
      return r
    }

    def parseExpFunT(typeParsed: B): Exp.Fun = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.Fun")
      }
      parser.parseObjectKey("params")
      val params = parser.parseISZ(parseParam _)
      parser.parseObjectNext()
      parser.parseObjectKey("exp")
      val exp = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseTypedAttr()
      parser.parseObjectNext()
      return Exp.Fun(params, exp, attr)
    }

    def parseExpForYield(): Exp.ForYield = {
      val r = parseExpForYieldT(F)
      return r
    }

    def parseExpForYieldT(typeParsed: B): Exp.ForYield = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.ForYield")
      }
      parser.parseObjectKey("enumGens")
      val enumGens = parser.parseISZ(parseEnumGenFor _)
      parser.parseObjectNext()
      parser.parseObjectKey("exp")
      val exp = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseTypedAttr()
      parser.parseObjectNext()
      return Exp.ForYield(enumGens, exp, attr)
    }

    def parseExpQuant(): Exp.Quant = {
      val r = parseExpQuantT(F)
      return r
    }

    def parseExpQuantT(typeParsed: B): Exp.Quant = {
      if (!typeParsed) {
        parser.parseObjectType("Exp.Quant")
      }
      parser.parseObjectKey("isForall")
      val isForall = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("varFragments")
      val varFragments = parser.parseISZ(parseVarFragment _)
      parser.parseObjectNext()
      parser.parseObjectKey("exp")
      val exp = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Exp.Quant(isForall, varFragments, exp, attr)
    }

    def parseNamedArg(): NamedArg = {
      val r = parseNamedArgT(F)
      return r
    }

    def parseNamedArgT(typeParsed: B): NamedArg = {
      if (!typeParsed) {
        parser.parseObjectType("NamedArg")
      }
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("arg")
      val arg = parseExp()
      parser.parseObjectNext()
      return NamedArg(id, arg)
    }

    def parseVarFragment(): VarFragment = {
      val r = parseVarFragmentT(F)
      return r
    }

    def parseVarFragmentT(typeParsed: B): VarFragment = {
      if (!typeParsed) {
        parser.parseObjectType("VarFragment")
      }
      parser.parseObjectKey("ids")
      val ids = parser.parseISZ(parseId _)
      parser.parseObjectNext()
      parser.parseObjectKey("domainOpt")
      val domainOpt = parser.parseOption(parseDomain _)
      parser.parseObjectNext()
      return VarFragment(ids, domainOpt)
    }

    def parseDomain(): Domain = {
      val t = parser.parseObjectTypes(ISZ("DomainType", "DomainRange"))
      t match {
        case "Domain.Type" => val r = parseDomainTypeT(T); return r
        case "Domain.Range" => val r = parseDomainRangeT(T); return r
      }
    }

    def parseDomainType(): Domain.Type = {
      val r = parseDomainTypeT(F)
      return r
    }

    def parseDomainTypeT(typeParsed: B): Domain.Type = {
      if (!typeParsed) {
        parser.parseObjectType("Domain.Type")
      }
      parser.parseObjectKey("tipe")
      val tipe = parseType()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseTypedAttr()
      parser.parseObjectNext()
      return Domain.Type(tipe, attr)
    }

    def parseDomainRange(): Domain.Range = {
      val r = parseDomainRangeT(F)
      return r
    }

    def parseDomainRangeT(typeParsed: B): Domain.Range = {
      if (!typeParsed) {
        parser.parseObjectType("Domain.Range")
      }
      parser.parseObjectKey("lo")
      val lo = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("loExact")
      val loExact = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("hi")
      val hi = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("hiExact")
      val hiExact = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseTypedAttr()
      parser.parseObjectNext()
      return Domain.Range(lo, loExact, hi, hiExact, attr)
    }

    def parseId(): Id = {
      val r = parseIdT(F)
      return r
    }

    def parseIdT(typeParsed: B): Id = {
      if (!typeParsed) {
        parser.parseObjectType("Id")
      }
      parser.parseObjectKey("value")
      val value = parser.parseString()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Id(value, attr)
    }

    def parseName(): Name = {
      val r = parseNameT(F)
      return r
    }

    def parseNameT(typeParsed: B): Name = {
      if (!typeParsed) {
        parser.parseObjectType("Name")
      }
      parser.parseObjectKey("ids")
      val ids = parser.parseISZ(parseId _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Name(ids, attr)
    }

    def parseBody(): Body = {
      val r = parseBodyT(F)
      return r
    }

    def parseBodyT(typeParsed: B): Body = {
      if (!typeParsed) {
        parser.parseObjectType("Body")
      }
      parser.parseObjectKey("stmts")
      val stmts = parser.parseISZ(parseStmt _)
      parser.parseObjectNext()
      return Body(stmts)
    }

    def parseAbstractDatatypeParam(): AbstractDatatypeParam = {
      val r = parseAbstractDatatypeParamT(F)
      return r
    }

    def parseAbstractDatatypeParamT(typeParsed: B): AbstractDatatypeParam = {
      if (!typeParsed) {
        parser.parseObjectType("AbstractDatatypeParam")
      }
      parser.parseObjectKey("isHidden")
      val isHidden = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("isPure")
      val isPure = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("tipe")
      val tipe = parseType()
      parser.parseObjectNext()
      return AbstractDatatypeParam(isHidden, isPure, id, tipe)
    }

    def parseMethodSig(): MethodSig = {
      val r = parseMethodSigT(F)
      return r
    }

    def parseMethodSigT(typeParsed: B): MethodSig = {
      if (!typeParsed) {
        parser.parseObjectType("MethodSig")
      }
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("typeParams")
      val typeParams = parser.parseISZ(parseTypeParam _)
      parser.parseObjectNext()
      parser.parseObjectKey("hasParams")
      val hasParams = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("params")
      val params = parser.parseISZ(parseParam _)
      parser.parseObjectNext()
      parser.parseObjectKey("returnType")
      val returnType = parseType()
      parser.parseObjectNext()
      return MethodSig(id, typeParams, hasParams, params, returnType)
    }

    def parseParamMod(): ParamMod.Type = {
      val r = parseParamModT(F)
      return r
    }

    def parseParamModT(typeParsed: B): ParamMod.Type = {
      if (!typeParsed) {
        parser.parseObjectType("ParamMod")
      }
      parser.parseObjectKey("value")
      val s = parser.parseString()
      s match {
        case "NoMod" => return ParamMod.NoMod
        case "Pure" => return ParamMod.Pure
        case "Hidden" => return ParamMod.Hidden
      }
    }

    def parseParam(): Param = {
      val r = parseParamT(F)
      return r
    }

    def parseParamT(typeParsed: B): Param = {
      if (!typeParsed) {
        parser.parseObjectType("Param")
      }
      parser.parseObjectKey("mod")
      val mod = parseParamMod()
      parser.parseObjectNext()
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("tipe")
      val tipe = parseType()
      parser.parseObjectNext()
      return Param(mod, id, tipe)
    }

    def parseTypeParam(): TypeParam = {
      val r = parseTypeParamT(F)
      return r
    }

    def parseTypeParamT(typeParsed: B): TypeParam = {
      if (!typeParsed) {
        parser.parseObjectType("TypeParam")
      }
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("superTypeOpt")
      val superTypeOpt = parser.parseOption(parseType _)
      parser.parseObjectNext()
      return TypeParam(id, superTypeOpt)
    }

    def parseContract(): Contract = {
      val r = parseContractT(F)
      return r
    }

    def parseContractT(typeParsed: B): Contract = {
      if (!typeParsed) {
        parser.parseObjectType("Contract")
      }
      parser.parseObjectKey("reads")
      val reads = parser.parseISZ(parseExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("requires")
      val requires = parser.parseISZ(parseContractExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("modifies")
      val modifies = parser.parseISZ(parseExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("ensures")
      val ensures = parser.parseISZ(parseContractExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("subs")
      val subs = parser.parseISZ(parseSubContract _)
      parser.parseObjectNext()
      return Contract(reads, requires, modifies, ensures, subs)
    }

    def parseSubContract(): SubContract = {
      val r = parseSubContractT(F)
      return r
    }

    def parseSubContractT(typeParsed: B): SubContract = {
      if (!typeParsed) {
        parser.parseObjectType("SubContract")
      }
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("params")
      val params = parser.parseISZ(parseSubContractParam _)
      parser.parseObjectNext()
      parser.parseObjectKey("contract")
      val contract = parseContract()
      parser.parseObjectNext()
      return SubContract(id, params, contract)
    }

    def parseSubContractParam(): SubContractParam = {
      val r = parseSubContractParamT(F)
      return r
    }

    def parseSubContractParamT(typeParsed: B): SubContractParam = {
      if (!typeParsed) {
        parser.parseObjectType("SubContractParam")
      }
      parser.parseObjectKey("isPure")
      val isPure = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      return SubContractParam(isPure, id)
    }

    def parseWhereDef(): WhereDef = {
      val t = parser.parseObjectTypes(ISZ("WhereDefVal", "WhereDefDef"))
      t match {
        case "WhereDef.Val" => val r = parseWhereDefValT(T); return r
        case "WhereDef.Def" => val r = parseWhereDefDefT(T); return r
      }
    }

    def parseWhereDefVal(): WhereDef.Val = {
      val r = parseWhereDefValT(F)
      return r
    }

    def parseWhereDefValT(typeParsed: B): WhereDef.Val = {
      if (!typeParsed) {
        parser.parseObjectType("WhereDef.Val")
      }
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("tipe")
      val tipe = parseType()
      parser.parseObjectNext()
      parser.parseObjectKey("exp")
      val exp = parseExp()
      parser.parseObjectNext()
      return WhereDef.Val(id, tipe, exp)
    }

    def parseWhereDefDef(): WhereDef.Def = {
      val r = parseWhereDefDefT(F)
      return r
    }

    def parseWhereDefDefT(typeParsed: B): WhereDef.Def = {
      if (!typeParsed) {
        parser.parseObjectType("WhereDef.Def")
      }
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("params")
      val params = parser.parseISZ(parseParam _)
      parser.parseObjectNext()
      parser.parseObjectKey("rTipe")
      val rTipe = parseType()
      parser.parseObjectNext()
      parser.parseObjectKey("defs")
      val defs = parser.parseISZ(parseSpecDef _)
      parser.parseObjectNext()
      return WhereDef.Def(id, params, rTipe, defs)
    }

    def parseSpecDef(): SpecDef = {
      val r = parseSpecDefT(F)
      return r
    }

    def parseSpecDefT(typeParsed: B): SpecDef = {
      if (!typeParsed) {
        parser.parseObjectType("SpecDef")
      }
      parser.parseObjectKey("idOpt")
      val idOpt = parser.parseOption(parseId _)
      parser.parseObjectNext()
      parser.parseObjectKey("exp")
      val exp = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("isOtherwise")
      val isOtherwise = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("patternOpt")
      val patternOpt = parser.parseOption(parsePattern _)
      parser.parseObjectNext()
      parser.parseObjectKey("guardOpt")
      val guardOpt = parser.parseOption(parseExp _)
      parser.parseObjectNext()
      return SpecDef(idOpt, exp, isOtherwise, patternOpt, guardOpt)
    }

    def parseProofStep(): ProofStep = {
      val t = parser.parseObjectTypes(ISZ("ProofStepBasic", "ProofStepSubProof"))
      t match {
        case "ProofStep.Basic" => val r = parseProofStepBasicT(T); return r
        case "ProofStep.SubProof" => val r = parseProofStepSubProofT(T); return r
      }
    }

    def parseProofStepBasic(): ProofStep.Basic = {
      val r = parseProofStepBasicT(F)
      return r
    }

    def parseProofStepBasicT(typeParsed: B): ProofStep.Basic = {
      if (!typeParsed) {
        parser.parseObjectType("ProofStep.Basic")
      }
      parser.parseObjectKey("step")
      val step = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("exp")
      val exp = parseExp()
      parser.parseObjectNext()
      parser.parseObjectKey("just")
      val just = parseJust()
      parser.parseObjectNext()
      return ProofStep.Basic(step, exp, just)
    }

    def parseProofStepSubProof(): ProofStep.SubProof = {
      val r = parseProofStepSubProofT(F)
      return r
    }

    def parseProofStepSubProofT(typeParsed: B): ProofStep.SubProof = {
      if (!typeParsed) {
        parser.parseObjectType("ProofStep.SubProof")
      }
      parser.parseObjectKey("step")
      val step = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("assumeStep")
      val assumeStep = parseAssumeProofStep()
      parser.parseObjectNext()
      parser.parseObjectKey("steps")
      val steps = parser.parseISZ(parseProofStep _)
      parser.parseObjectNext()
      return ProofStep.SubProof(step, assumeStep, steps)
    }

    def parseAssumeProofStep(): AssumeProofStep = {
      val t = parser.parseObjectTypes(ISZ("AssumeProofStepRegular", "AssumeProofStepForallIntroAps", "AssumeProofStepExistsElimAps"))
      t match {
        case "AssumeProofStep.Regular" => val r = parseAssumeProofStepRegularT(T); return r
        case "AssumeProofStep.ForallIntroAps" => val r = parseAssumeProofStepForallIntroApsT(T); return r
        case "AssumeProofStep.ExistsElimAps" => val r = parseAssumeProofStepExistsElimApsT(T); return r
      }
    }

    def parseAssumeProofStepRegular(): AssumeProofStep.Regular = {
      val r = parseAssumeProofStepRegularT(F)
      return r
    }

    def parseAssumeProofStepRegularT(typeParsed: B): AssumeProofStep.Regular = {
      if (!typeParsed) {
        parser.parseObjectType("AssumeProofStep.Regular")
      }
      parser.parseObjectKey("step")
      val step = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("exp")
      val exp = parseExp()
      parser.parseObjectNext()
      return AssumeProofStep.Regular(step, exp)
    }

    def parseAssumeProofStepForallIntroAps(): AssumeProofStep.ForallIntroAps = {
      val r = parseAssumeProofStepForallIntroApsT(F)
      return r
    }

    def parseAssumeProofStepForallIntroApsT(typeParsed: B): AssumeProofStep.ForallIntroAps = {
      if (!typeParsed) {
        parser.parseObjectType("AssumeProofStep.ForallIntroAps")
      }
      parser.parseObjectKey("step")
      val step = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("varFragments")
      val varFragments = parser.parseISZ(parseVarFragment _)
      parser.parseObjectNext()
      return AssumeProofStep.ForallIntroAps(step, varFragments)
    }

    def parseAssumeProofStepExistsElimAps(): AssumeProofStep.ExistsElimAps = {
      val r = parseAssumeProofStepExistsElimApsT(F)
      return r
    }

    def parseAssumeProofStepExistsElimApsT(typeParsed: B): AssumeProofStep.ExistsElimAps = {
      if (!typeParsed) {
        parser.parseObjectType("AssumeProofStep.ExistsElimAps")
      }
      parser.parseObjectKey("step")
      val step = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("varFragments")
      val varFragments = parser.parseISZ(parseVarFragment _)
      parser.parseObjectNext()
      parser.parseObjectKey("exp")
      val exp = parseExp()
      parser.parseObjectNext()
      return AssumeProofStep.ExistsElimAps(step, varFragments, exp)
    }

    def parseJust(): Just = {
      val t = parser.parseObjectTypes(ISZ("JustPremise", "JustAndIntro", "JustAndElim", "JustOrIntro", "JustOrElim", "JustImplyIntro", "JustImplyElim", "JustNegIntro", "JustNegElim", "JustBottomElim", "JustPbc", "JustForallIntro", "JustForallElim", "JustExistsIntro", "JustExistsElim", "JustFact", "JustInvariant", "JustSubst", "JustAuto", "JustCoq"))
      t match {
        case "Just.Premise" => val r = parseJustPremiseT(T); return r
        case "Just.AndIntro" => val r = parseJustAndIntroT(T); return r
        case "Just.AndElim" => val r = parseJustAndElimT(T); return r
        case "Just.OrIntro" => val r = parseJustOrIntroT(T); return r
        case "Just.OrElim" => val r = parseJustOrElimT(T); return r
        case "Just.ImplyIntro" => val r = parseJustImplyIntroT(T); return r
        case "Just.ImplyElim" => val r = parseJustImplyElimT(T); return r
        case "Just.NegIntro" => val r = parseJustNegIntroT(T); return r
        case "Just.NegElim" => val r = parseJustNegElimT(T); return r
        case "Just.BottomElim" => val r = parseJustBottomElimT(T); return r
        case "Just.Pbc" => val r = parseJustPbcT(T); return r
        case "Just.ForallIntro" => val r = parseJustForallIntroT(T); return r
        case "Just.ForallElim" => val r = parseJustForallElimT(T); return r
        case "Just.ExistsIntro" => val r = parseJustExistsIntroT(T); return r
        case "Just.ExistsElim" => val r = parseJustExistsElimT(T); return r
        case "Just.Fact" => val r = parseJustFactT(T); return r
        case "Just.Invariant" => val r = parseJustInvariantT(T); return r
        case "Just.Subst" => val r = parseJustSubstT(T); return r
        case "Just.Auto" => val r = parseJustAutoT(T); return r
        case "Just.Coq" => val r = parseJustCoqT(T); return r
      }
    }

    def parseJustPremise(): Just.Premise = {
      val r = parseJustPremiseT(F)
      return r
    }

    def parseJustPremiseT(typeParsed: B): Just.Premise = {
      if (!typeParsed) {
        parser.parseObjectType("Just.Premise")
      }
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.Premise(attr)
    }

    def parseJustAndIntro(): Just.AndIntro = {
      val r = parseJustAndIntroT(F)
      return r
    }

    def parseJustAndIntroT(typeParsed: B): Just.AndIntro = {
      if (!typeParsed) {
        parser.parseObjectType("Just.AndIntro")
      }
      parser.parseObjectKey("steps")
      val steps = parser.parseISZ(parseExpLitZ _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.AndIntro(steps, attr)
    }

    def parseJustAndElim(): Just.AndElim = {
      val r = parseJustAndElimT(F)
      return r
    }

    def parseJustAndElimT(typeParsed: B): Just.AndElim = {
      if (!typeParsed) {
        parser.parseObjectType("Just.AndElim")
      }
      parser.parseObjectKey("is1")
      val is1 = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("andStep")
      val andStep = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.AndElim(is1, andStep, attr)
    }

    def parseJustOrIntro(): Just.OrIntro = {
      val r = parseJustOrIntroT(F)
      return r
    }

    def parseJustOrIntroT(typeParsed: B): Just.OrIntro = {
      if (!typeParsed) {
        parser.parseObjectType("Just.OrIntro")
      }
      parser.parseObjectKey("is1")
      val is1 = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("step")
      val step = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.OrIntro(is1, step, attr)
    }

    def parseJustOrElim(): Just.OrElim = {
      val r = parseJustOrElimT(F)
      return r
    }

    def parseJustOrElimT(typeParsed: B): Just.OrElim = {
      if (!typeParsed) {
        parser.parseObjectType("Just.OrElim")
      }
      parser.parseObjectKey("orStep")
      val orStep = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("subProofSteps")
      val subProofSteps = parser.parseISZ(parseExpLitZ _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.OrElim(orStep, subProofSteps, attr)
    }

    def parseJustImplyIntro(): Just.ImplyIntro = {
      val r = parseJustImplyIntroT(F)
      return r
    }

    def parseJustImplyIntroT(typeParsed: B): Just.ImplyIntro = {
      if (!typeParsed) {
        parser.parseObjectType("Just.ImplyIntro")
      }
      parser.parseObjectKey("subProofStep")
      val subProofStep = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.ImplyIntro(subProofStep, attr)
    }

    def parseJustImplyElim(): Just.ImplyElim = {
      val r = parseJustImplyElimT(F)
      return r
    }

    def parseJustImplyElimT(typeParsed: B): Just.ImplyElim = {
      if (!typeParsed) {
        parser.parseObjectType("Just.ImplyElim")
      }
      parser.parseObjectKey("implyStep")
      val implyStep = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("steps")
      val steps = parser.parseISZ(parseExpLitZ _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.ImplyElim(implyStep, steps, attr)
    }

    def parseJustNegIntro(): Just.NegIntro = {
      val r = parseJustNegIntroT(F)
      return r
    }

    def parseJustNegIntroT(typeParsed: B): Just.NegIntro = {
      if (!typeParsed) {
        parser.parseObjectType("Just.NegIntro")
      }
      parser.parseObjectKey("subProofStep")
      val subProofStep = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.NegIntro(subProofStep, attr)
    }

    def parseJustNegElim(): Just.NegElim = {
      val r = parseJustNegElimT(F)
      return r
    }

    def parseJustNegElimT(typeParsed: B): Just.NegElim = {
      if (!typeParsed) {
        parser.parseObjectType("Just.NegElim")
      }
      parser.parseObjectKey("step")
      val step = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("negStep")
      val negStep = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.NegElim(step, negStep, attr)
    }

    def parseJustBottomElim(): Just.BottomElim = {
      val r = parseJustBottomElimT(F)
      return r
    }

    def parseJustBottomElimT(typeParsed: B): Just.BottomElim = {
      if (!typeParsed) {
        parser.parseObjectType("Just.BottomElim")
      }
      parser.parseObjectKey("subProofStep")
      val subProofStep = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.BottomElim(subProofStep, attr)
    }

    def parseJustPbc(): Just.Pbc = {
      val r = parseJustPbcT(F)
      return r
    }

    def parseJustPbcT(typeParsed: B): Just.Pbc = {
      if (!typeParsed) {
        parser.parseObjectType("Just.Pbc")
      }
      parser.parseObjectKey("subProofStep")
      val subProofStep = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.Pbc(subProofStep, attr)
    }

    def parseJustForallIntro(): Just.ForallIntro = {
      val r = parseJustForallIntroT(F)
      return r
    }

    def parseJustForallIntroT(typeParsed: B): Just.ForallIntro = {
      if (!typeParsed) {
        parser.parseObjectType("Just.ForallIntro")
      }
      parser.parseObjectKey("subProofStep")
      val subProofStep = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.ForallIntro(subProofStep, attr)
    }

    def parseJustForallElim(): Just.ForallElim = {
      val r = parseJustForallElimT(F)
      return r
    }

    def parseJustForallElimT(typeParsed: B): Just.ForallElim = {
      if (!typeParsed) {
        parser.parseObjectType("Just.ForallElim")
      }
      parser.parseObjectKey("forallStep")
      val forallStep = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("args")
      val args = parser.parseISZ(parseExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.ForallElim(forallStep, args, attr)
    }

    def parseJustExistsIntro(): Just.ExistsIntro = {
      val r = parseJustExistsIntroT(F)
      return r
    }

    def parseJustExistsIntroT(typeParsed: B): Just.ExistsIntro = {
      if (!typeParsed) {
        parser.parseObjectType("Just.ExistsIntro")
      }
      parser.parseObjectKey("existsStep")
      val existsStep = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("args")
      val args = parser.parseISZ(parseExp _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.ExistsIntro(existsStep, args, attr)
    }

    def parseJustExistsElim(): Just.ExistsElim = {
      val r = parseJustExistsElimT(F)
      return r
    }

    def parseJustExistsElimT(typeParsed: B): Just.ExistsElim = {
      if (!typeParsed) {
        parser.parseObjectType("Just.ExistsElim")
      }
      parser.parseObjectKey("existsStep")
      val existsStep = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("subProofStep")
      val subProofStep = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.ExistsElim(existsStep, subProofStep, attr)
    }

    def parseJustFact(): Just.Fact = {
      val r = parseJustFactT(F)
      return r
    }

    def parseJustFactT(typeParsed: B): Just.Fact = {
      if (!typeParsed) {
        parser.parseObjectType("Just.Fact")
      }
      parser.parseObjectKey("name")
      val name = parseName()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.Fact(name, attr)
    }

    def parseJustInvariant(): Just.Invariant = {
      val r = parseJustInvariantT(F)
      return r
    }

    def parseJustInvariantT(typeParsed: B): Just.Invariant = {
      if (!typeParsed) {
        parser.parseObjectType("Just.Invariant")
      }
      parser.parseObjectKey("nameOpt")
      val nameOpt = parser.parseOption(parseName _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.Invariant(nameOpt, attr)
    }

    def parseJustSubst(): Just.Subst = {
      val r = parseJustSubstT(F)
      return r
    }

    def parseJustSubstT(typeParsed: B): Just.Subst = {
      if (!typeParsed) {
        parser.parseObjectType("Just.Subst")
      }
      parser.parseObjectKey("isRight")
      val isRight = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("eqStep")
      val eqStep = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("step")
      val step = parseExpLitZ()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.Subst(isRight, eqStep, step, attr)
    }

    def parseJustAuto(): Just.Auto = {
      val r = parseJustAutoT(F)
      return r
    }

    def parseJustAutoT(typeParsed: B): Just.Auto = {
      if (!typeParsed) {
        parser.parseObjectType("Just.Auto")
      }
      parser.parseObjectKey("isAlgebra")
      val isAlgebra = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("steps")
      val steps = parser.parseISZ(parseExpLitZ _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.Auto(isAlgebra, steps, attr)
    }

    def parseJustCoq(): Just.Coq = {
      val r = parseJustCoqT(F)
      return r
    }

    def parseJustCoqT(typeParsed: B): Just.Coq = {
      if (!typeParsed) {
        parser.parseObjectType("Just.Coq")
      }
      parser.parseObjectKey("path")
      val path = parseExpLitString()
      parser.parseObjectNext()
      parser.parseObjectKey("steps")
      val steps = parser.parseISZ(parseExpLitZ _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Just.Coq(path, steps, attr)
    }

    def parseTruthTableRow(): TruthTable.Row = {
      val r = parseTruthTableRowT(F)
      return r
    }

    def parseTruthTableRowT(typeParsed: B): TruthTable.Row = {
      if (!typeParsed) {
        parser.parseObjectType("TruthTable.Row")
      }
      parser.parseObjectKey("assignment")
      val assignment = parseTruthTableAssignment()
      parser.parseObjectNext()
      parser.parseObjectKey("separator")
      val separator = parsePosInfo()
      parser.parseObjectNext()
      parser.parseObjectKey("values")
      val values = parseTruthTableAssignment()
      parser.parseObjectNext()
      return TruthTable.Row(assignment, separator, values)
    }

    def parseTruthTableAssignment(): TruthTable.Assignment = {
      val r = parseTruthTableAssignmentT(F)
      return r
    }

    def parseTruthTableAssignmentT(typeParsed: B): TruthTable.Assignment = {
      if (!typeParsed) {
        parser.parseObjectType("TruthTable.Assignment")
      }
      parser.parseObjectKey("values")
      val values = parser.parseISZ(parseExpLitB _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return TruthTable.Assignment(values, attr)
    }

    def parseTruthTableConclusion(): TruthTable.Conclusion = {
      val t = parser.parseObjectTypes(ISZ("TruthTableConclusionValidity", "TruthTableConclusionTautology", "TruthTableConclusionContradictory", "TruthTableConclusionContingent"))
      t match {
        case "TruthTable.Conclusion.Validity" => val r = parseTruthTableConclusionValidityT(T); return r
        case "TruthTable.Conclusion.Tautology" => val r = parseTruthTableConclusionTautologyT(T); return r
        case "TruthTable.Conclusion.Contradictory" => val r = parseTruthTableConclusionContradictoryT(T); return r
        case "TruthTable.Conclusion.Contingent" => val r = parseTruthTableConclusionContingentT(T); return r
      }
    }

    def parseTruthTableConclusionValidity(): TruthTable.Conclusion.Validity = {
      val r = parseTruthTableConclusionValidityT(F)
      return r
    }

    def parseTruthTableConclusionValidityT(typeParsed: B): TruthTable.Conclusion.Validity = {
      if (!typeParsed) {
        parser.parseObjectType("TruthTable.Conclusion.Validity")
      }
      parser.parseObjectKey("isValid")
      val isValid = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("assignments")
      val assignments = parser.parseISZ(parseTruthTableAssignment _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return TruthTable.Conclusion.Validity(isValid, assignments, attr)
    }

    def parseTruthTableConclusionTautology(): TruthTable.Conclusion.Tautology = {
      val r = parseTruthTableConclusionTautologyT(F)
      return r
    }

    def parseTruthTableConclusionTautologyT(typeParsed: B): TruthTable.Conclusion.Tautology = {
      if (!typeParsed) {
        parser.parseObjectType("TruthTable.Conclusion.Tautology")
      }
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return TruthTable.Conclusion.Tautology(attr)
    }

    def parseTruthTableConclusionContradictory(): TruthTable.Conclusion.Contradictory = {
      val r = parseTruthTableConclusionContradictoryT(F)
      return r
    }

    def parseTruthTableConclusionContradictoryT(typeParsed: B): TruthTable.Conclusion.Contradictory = {
      if (!typeParsed) {
        parser.parseObjectType("TruthTable.Conclusion.Contradictory")
      }
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return TruthTable.Conclusion.Contradictory(attr)
    }

    def parseTruthTableConclusionContingent(): TruthTable.Conclusion.Contingent = {
      val r = parseTruthTableConclusionContingentT(F)
      return r
    }

    def parseTruthTableConclusionContingentT(typeParsed: B): TruthTable.Conclusion.Contingent = {
      if (!typeParsed) {
        parser.parseObjectType("TruthTable.Conclusion.Contingent")
      }
      parser.parseObjectKey("trueAssignments")
      val trueAssignments = parser.parseISZ(parseTruthTableAssignment _)
      parser.parseObjectNext()
      parser.parseObjectKey("falseAssignments")
      val falseAssignments = parser.parseISZ(parseTruthTableAssignment _)
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return TruthTable.Conclusion.Contingent(trueAssignments, falseAssignments, attr)
    }

    def parseAttr(): Attr = {
      val r = parseAttrT(F)
      return r
    }

    def parseAttrT(typeParsed: B): Attr = {
      if (!typeParsed) {
        parser.parseObjectType("Attr")
      }
      parser.parseObjectKey("posOpt")
      val posOpt = parser.parseOption(parsePosInfo _)
      parser.parseObjectNext()
      return Attr(posOpt)
    }

    def parseTypedAttr(): TypedAttr = {
      val r = parseTypedAttrT(F)
      return r
    }

    def parseTypedAttrT(typeParsed: B): TypedAttr = {
      if (!typeParsed) {
        parser.parseObjectType("TypedAttr")
      }
      parser.parseObjectKey("posOpt")
      val posOpt = parser.parseOption(parsePosInfo _)
      parser.parseObjectNext()
      parser.parseObjectKey("typeOpt")
      val typeOpt = parser.parseOption(parseType _)
      parser.parseObjectNext()
      return TypedAttr(posOpt, typeOpt)
    }

    def parseResolvedAttr(): ResolvedAttr = {
      val r = parseResolvedAttrT(F)
      return r
    }

    def parseResolvedAttrT(typeParsed: B): ResolvedAttr = {
      if (!typeParsed) {
        parser.parseObjectType("ResolvedAttr")
      }
      parser.parseObjectKey("posOpt")
      val posOpt = parser.parseOption(parsePosInfo _)
      parser.parseObjectNext()
      parser.parseObjectKey("resOpt")
      val resOpt = parser.parseOption(parseResolvedInfo _)
      parser.parseObjectNext()
      parser.parseObjectKey("typeOpt")
      val typeOpt = parser.parseOption(parseType _)
      parser.parseObjectNext()
      return ResolvedAttr(posOpt, resOpt, typeOpt)
    }

    def parseResolvedInfo(): ResolvedInfo = {
      val r = parseResolvedInfoT(F)
      return r
    }

    def parseResolvedInfoT(typeParsed: B): ResolvedInfo = {
      if (!typeParsed) {
        parser.parseObjectType("ResolvedInfo")
      }
      parser.parseObjectKey("kind")
      val kind = parseSymbolKind()
      parser.parseObjectNext()
      parser.parseObjectKey("ids")
      val ids = parser.parseISZ(parser.parseString _)
      parser.parseObjectNext()
      parser.parseObjectKey("externFileUriOpt")
      val externFileUriOpt = parser.parseOption(parser.parseString _)
      parser.parseObjectNext()
      return ResolvedInfo(kind, ids, externFileUriOpt)
    }

    def parseSymbolKind(): SymbolKind.Type = {
      val r = parseSymbolKindT(F)
      return r
    }

    def parseSymbolKindT(typeParsed: B): SymbolKind.Type = {
      if (!typeParsed) {
        parser.parseObjectType("SymbolKind")
      }
      parser.parseObjectKey("value")
      val s = parser.parseString()
      s match {
        case "Package" => return SymbolKind.Package
        case "Val" => return SymbolKind.Val
        case "Var" => return SymbolKind.Var
        case "Method" => return SymbolKind.Method
        case "ExtMethod" => return SymbolKind.ExtMethod
        case "SpecMethod" => return SymbolKind.SpecMethod
        case "Object" => return SymbolKind.Object
        case "Sig" => return SymbolKind.Sig
        case "DatatypeTrait" => return SymbolKind.DatatypeTrait
        case "DatatypeClass" => return SymbolKind.DatatypeClass
        case "RecordTrait" => return SymbolKind.RecordTrait
        case "RecordClass" => return SymbolKind.RecordClass
        case "RichTrait" => return SymbolKind.RichTrait
        case "RichClass" => return SymbolKind.RichClass
        case "Enum" => return SymbolKind.Enum
        case "TypeAlias" => return SymbolKind.TypeAlias
        case "FreshVar" => return SymbolKind.FreshVar
        case "QuantVar" => return SymbolKind.QuantVar
      }
    }

    def parsePosInfo(): PosInfo = {
      val r = parsePosInfoT(F)
      return r
    }

    def parsePosInfoT(typeParsed: B): PosInfo = {
      if (!typeParsed) {
        parser.parseObjectType("PosInfo")
      }
      parser.parseObjectKey("fileUriOpt")
      val fileUriOpt = parser.parseOption(parser.parseString _)
      parser.parseObjectNext()
      parser.parseObjectKey("beginLine")
      val beginLine = parser.parseZ()
      parser.parseObjectNext()
      parser.parseObjectKey("beginColumn")
      val beginColumn = parser.parseZ()
      parser.parseObjectNext()
      parser.parseObjectKey("endLine")
      val endLine = parser.parseZ()
      parser.parseObjectNext()
      parser.parseObjectKey("endColumn")
      val endColumn = parser.parseZ()
      parser.parseObjectNext()
      parser.parseObjectKey("offset")
      val offset = parser.parseZ()
      parser.parseObjectNext()
      parser.parseObjectKey("length")
      val length = parser.parseZ()
      parser.parseObjectNext()
      return PosInfo(fileUriOpt, beginLine, beginColumn, endLine, endColumn, offset, length)
    }

    def eof(): B = {
      val r = parser.eof()
      return r
    }

    def errorOpt: Option[Json.ErrorMsg] = {
      return parser.errorOpt
    }

  }

  def to[T](s: String, f: Parser => T): Either[T, Json.ErrorMsg] = {
    val parser = Parser(s)
    val r = f(parser)
    parser.eof()
    val eOpt = parser.errorOpt
    eOpt match {
      case Some(e) => return Either(None(), Some(e))
      case _ => return Either(Some(r), None())
    }
  }

  def fromTopUnit(o: TopUnit): String = {
    return Printer.printTopUnit(o).render
  }

  def toTopUnit(s: String): Either[TopUnit, Json.ErrorMsg] = {
    def fTopUnit(parser: Parser): TopUnit = {
      var r = parser.parseTopUnit()
      return r
    }
    val r = to(s, fTopUnit)
    return r
  }

  def fromTopUnitProgram(o: TopUnit.Program): String = {
    return Printer.printTopUnitProgram(o).render
  }

  def toTopUnitProgram(s: String): Either[TopUnit.Program, Json.ErrorMsg] = {
    def fTopUnitProgram(parser: Parser): TopUnit.Program = {
      var r = parser.parseTopUnitProgram()
      return r
    }
    val r = to(s, fTopUnitProgram)
    return r
  }

  def fromTopUnitSequentUnit(o: TopUnit.SequentUnit): String = {
    return Printer.printTopUnitSequentUnit(o).render
  }

  def toTopUnitSequentUnit(s: String): Either[TopUnit.SequentUnit, Json.ErrorMsg] = {
    def fTopUnitSequentUnit(parser: Parser): TopUnit.SequentUnit = {
      var r = parser.parseTopUnitSequentUnit()
      return r
    }
    val r = to(s, fTopUnitSequentUnit)
    return r
  }

  def fromTopUnitTruthTableUnit(o: TopUnit.TruthTableUnit): String = {
    return Printer.printTopUnitTruthTableUnit(o).render
  }

  def toTopUnitTruthTableUnit(s: String): Either[TopUnit.TruthTableUnit, Json.ErrorMsg] = {
    def fTopUnitTruthTableUnit(parser: Parser): TopUnit.TruthTableUnit = {
      var r = parser.parseTopUnitTruthTableUnit()
      return r
    }
    val r = to(s, fTopUnitTruthTableUnit)
    return r
  }

  def fromStmt(o: Stmt): String = {
    return Printer.printStmt(o).render
  }

  def toStmt(s: String): Either[Stmt, Json.ErrorMsg] = {
    def fStmt(parser: Parser): Stmt = {
      var r = parser.parseStmt()
      return r
    }
    val r = to(s, fStmt)
    return r
  }

  def fromAssignExp(o: AssignExp): String = {
    return Printer.printAssignExp(o).render
  }

  def toAssignExp(s: String): Either[AssignExp, Json.ErrorMsg] = {
    def fAssignExp(parser: Parser): AssignExp = {
      var r = parser.parseAssignExp()
      return r
    }
    val r = to(s, fAssignExp)
    return r
  }

  def fromStmtImport(o: Stmt.Import): String = {
    return Printer.printStmtImport(o).render
  }

  def toStmtImport(s: String): Either[Stmt.Import, Json.ErrorMsg] = {
    def fStmtImport(parser: Parser): Stmt.Import = {
      var r = parser.parseStmtImport()
      return r
    }
    val r = to(s, fStmtImport)
    return r
  }

  def fromStmtImportImporter(o: Stmt.Import.Importer): String = {
    return Printer.printStmtImportImporter(o).render
  }

  def toStmtImportImporter(s: String): Either[Stmt.Import.Importer, Json.ErrorMsg] = {
    def fStmtImportImporter(parser: Parser): Stmt.Import.Importer = {
      var r = parser.parseStmtImportImporter()
      return r
    }
    val r = to(s, fStmtImportImporter)
    return r
  }

  def fromStmtImportSelector(o: Stmt.Import.Selector): String = {
    return Printer.printStmtImportSelector(o).render
  }

  def toStmtImportSelector(s: String): Either[Stmt.Import.Selector, Json.ErrorMsg] = {
    def fStmtImportSelector(parser: Parser): Stmt.Import.Selector = {
      var r = parser.parseStmtImportSelector()
      return r
    }
    val r = to(s, fStmtImportSelector)
    return r
  }

  def fromStmtImportMultiSelector(o: Stmt.Import.MultiSelector): String = {
    return Printer.printStmtImportMultiSelector(o).render
  }

  def toStmtImportMultiSelector(s: String): Either[Stmt.Import.MultiSelector, Json.ErrorMsg] = {
    def fStmtImportMultiSelector(parser: Parser): Stmt.Import.MultiSelector = {
      var r = parser.parseStmtImportMultiSelector()
      return r
    }
    val r = to(s, fStmtImportMultiSelector)
    return r
  }

  def fromStmtImportWildcardSelector(o: Stmt.Import.WildcardSelector): String = {
    return Printer.printStmtImportWildcardSelector(o).render
  }

  def toStmtImportWildcardSelector(s: String): Either[Stmt.Import.WildcardSelector, Json.ErrorMsg] = {
    def fStmtImportWildcardSelector(parser: Parser): Stmt.Import.WildcardSelector = {
      var r = parser.parseStmtImportWildcardSelector()
      return r
    }
    val r = to(s, fStmtImportWildcardSelector)
    return r
  }

  def fromStmtImportNamedSelector(o: Stmt.Import.NamedSelector): String = {
    return Printer.printStmtImportNamedSelector(o).render
  }

  def toStmtImportNamedSelector(s: String): Either[Stmt.Import.NamedSelector, Json.ErrorMsg] = {
    def fStmtImportNamedSelector(parser: Parser): Stmt.Import.NamedSelector = {
      var r = parser.parseStmtImportNamedSelector()
      return r
    }
    val r = to(s, fStmtImportNamedSelector)
    return r
  }

  def fromStmtVar(o: Stmt.Var): String = {
    return Printer.printStmtVar(o).render
  }

  def toStmtVar(s: String): Either[Stmt.Var, Json.ErrorMsg] = {
    def fStmtVar(parser: Parser): Stmt.Var = {
      var r = parser.parseStmtVar()
      return r
    }
    val r = to(s, fStmtVar)
    return r
  }

  def fromStmtVarPattern(o: Stmt.VarPattern): String = {
    return Printer.printStmtVarPattern(o).render
  }

  def toStmtVarPattern(s: String): Either[Stmt.VarPattern, Json.ErrorMsg] = {
    def fStmtVarPattern(parser: Parser): Stmt.VarPattern = {
      var r = parser.parseStmtVarPattern()
      return r
    }
    val r = to(s, fStmtVarPattern)
    return r
  }

  def fromStmtSpecVar(o: Stmt.SpecVar): String = {
    return Printer.printStmtSpecVar(o).render
  }

  def toStmtSpecVar(s: String): Either[Stmt.SpecVar, Json.ErrorMsg] = {
    def fStmtSpecVar(parser: Parser): Stmt.SpecVar = {
      var r = parser.parseStmtSpecVar()
      return r
    }
    val r = to(s, fStmtSpecVar)
    return r
  }

  def fromStmtMethod(o: Stmt.Method): String = {
    return Printer.printStmtMethod(o).render
  }

  def toStmtMethod(s: String): Either[Stmt.Method, Json.ErrorMsg] = {
    def fStmtMethod(parser: Parser): Stmt.Method = {
      var r = parser.parseStmtMethod()
      return r
    }
    val r = to(s, fStmtMethod)
    return r
  }

  def fromStmtExtMethod(o: Stmt.ExtMethod): String = {
    return Printer.printStmtExtMethod(o).render
  }

  def toStmtExtMethod(s: String): Either[Stmt.ExtMethod, Json.ErrorMsg] = {
    def fStmtExtMethod(parser: Parser): Stmt.ExtMethod = {
      var r = parser.parseStmtExtMethod()
      return r
    }
    val r = to(s, fStmtExtMethod)
    return r
  }

  def fromStmtSpecMethod(o: Stmt.SpecMethod): String = {
    return Printer.printStmtSpecMethod(o).render
  }

  def toStmtSpecMethod(s: String): Either[Stmt.SpecMethod, Json.ErrorMsg] = {
    def fStmtSpecMethod(parser: Parser): Stmt.SpecMethod = {
      var r = parser.parseStmtSpecMethod()
      return r
    }
    val r = to(s, fStmtSpecMethod)
    return r
  }

  def fromStmtEnum(o: Stmt.Enum): String = {
    return Printer.printStmtEnum(o).render
  }

  def toStmtEnum(s: String): Either[Stmt.Enum, Json.ErrorMsg] = {
    def fStmtEnum(parser: Parser): Stmt.Enum = {
      var r = parser.parseStmtEnum()
      return r
    }
    val r = to(s, fStmtEnum)
    return r
  }

  def fromStmtObject(o: Stmt.Object): String = {
    return Printer.printStmtObject(o).render
  }

  def toStmtObject(s: String): Either[Stmt.Object, Json.ErrorMsg] = {
    def fStmtObject(parser: Parser): Stmt.Object = {
      var r = parser.parseStmtObject()
      return r
    }
    val r = to(s, fStmtObject)
    return r
  }

  def fromStmtSig(o: Stmt.Sig): String = {
    return Printer.printStmtSig(o).render
  }

  def toStmtSig(s: String): Either[Stmt.Sig, Json.ErrorMsg] = {
    def fStmtSig(parser: Parser): Stmt.Sig = {
      var r = parser.parseStmtSig()
      return r
    }
    val r = to(s, fStmtSig)
    return r
  }

  def fromStmtAbstractDatatype(o: Stmt.AbstractDatatype): String = {
    return Printer.printStmtAbstractDatatype(o).render
  }

  def toStmtAbstractDatatype(s: String): Either[Stmt.AbstractDatatype, Json.ErrorMsg] = {
    def fStmtAbstractDatatype(parser: Parser): Stmt.AbstractDatatype = {
      var r = parser.parseStmtAbstractDatatype()
      return r
    }
    val r = to(s, fStmtAbstractDatatype)
    return r
  }

  def fromStmtRich(o: Stmt.Rich): String = {
    return Printer.printStmtRich(o).render
  }

  def toStmtRich(s: String): Either[Stmt.Rich, Json.ErrorMsg] = {
    def fStmtRich(parser: Parser): Stmt.Rich = {
      var r = parser.parseStmtRich()
      return r
    }
    val r = to(s, fStmtRich)
    return r
  }

  def fromStmtTypeAlias(o: Stmt.TypeAlias): String = {
    return Printer.printStmtTypeAlias(o).render
  }

  def toStmtTypeAlias(s: String): Either[Stmt.TypeAlias, Json.ErrorMsg] = {
    def fStmtTypeAlias(parser: Parser): Stmt.TypeAlias = {
      var r = parser.parseStmtTypeAlias()
      return r
    }
    val r = to(s, fStmtTypeAlias)
    return r
  }

  def fromStmtAssign(o: Stmt.Assign): String = {
    return Printer.printStmtAssign(o).render
  }

  def toStmtAssign(s: String): Either[Stmt.Assign, Json.ErrorMsg] = {
    def fStmtAssign(parser: Parser): Stmt.Assign = {
      var r = parser.parseStmtAssign()
      return r
    }
    val r = to(s, fStmtAssign)
    return r
  }

  def fromStmtAssignUp(o: Stmt.AssignUp): String = {
    return Printer.printStmtAssignUp(o).render
  }

  def toStmtAssignUp(s: String): Either[Stmt.AssignUp, Json.ErrorMsg] = {
    def fStmtAssignUp(parser: Parser): Stmt.AssignUp = {
      var r = parser.parseStmtAssignUp()
      return r
    }
    val r = to(s, fStmtAssignUp)
    return r
  }

  def fromStmtAssignPattern(o: Stmt.AssignPattern): String = {
    return Printer.printStmtAssignPattern(o).render
  }

  def toStmtAssignPattern(s: String): Either[Stmt.AssignPattern, Json.ErrorMsg] = {
    def fStmtAssignPattern(parser: Parser): Stmt.AssignPattern = {
      var r = parser.parseStmtAssignPattern()
      return r
    }
    val r = to(s, fStmtAssignPattern)
    return r
  }

  def fromStmtBlock(o: Stmt.Block): String = {
    return Printer.printStmtBlock(o).render
  }

  def toStmtBlock(s: String): Either[Stmt.Block, Json.ErrorMsg] = {
    def fStmtBlock(parser: Parser): Stmt.Block = {
      var r = parser.parseStmtBlock()
      return r
    }
    val r = to(s, fStmtBlock)
    return r
  }

  def fromStmtIf(o: Stmt.If): String = {
    return Printer.printStmtIf(o).render
  }

  def toStmtIf(s: String): Either[Stmt.If, Json.ErrorMsg] = {
    def fStmtIf(parser: Parser): Stmt.If = {
      var r = parser.parseStmtIf()
      return r
    }
    val r = to(s, fStmtIf)
    return r
  }

  def fromStmtMatch(o: Stmt.Match): String = {
    return Printer.printStmtMatch(o).render
  }

  def toStmtMatch(s: String): Either[Stmt.Match, Json.ErrorMsg] = {
    def fStmtMatch(parser: Parser): Stmt.Match = {
      var r = parser.parseStmtMatch()
      return r
    }
    val r = to(s, fStmtMatch)
    return r
  }

  def fromStmtWhile(o: Stmt.While): String = {
    return Printer.printStmtWhile(o).render
  }

  def toStmtWhile(s: String): Either[Stmt.While, Json.ErrorMsg] = {
    def fStmtWhile(parser: Parser): Stmt.While = {
      var r = parser.parseStmtWhile()
      return r
    }
    val r = to(s, fStmtWhile)
    return r
  }

  def fromStmtDoWhile(o: Stmt.DoWhile): String = {
    return Printer.printStmtDoWhile(o).render
  }

  def toStmtDoWhile(s: String): Either[Stmt.DoWhile, Json.ErrorMsg] = {
    def fStmtDoWhile(parser: Parser): Stmt.DoWhile = {
      var r = parser.parseStmtDoWhile()
      return r
    }
    val r = to(s, fStmtDoWhile)
    return r
  }

  def fromStmtFor(o: Stmt.For): String = {
    return Printer.printStmtFor(o).render
  }

  def toStmtFor(s: String): Either[Stmt.For, Json.ErrorMsg] = {
    def fStmtFor(parser: Parser): Stmt.For = {
      var r = parser.parseStmtFor()
      return r
    }
    val r = to(s, fStmtFor)
    return r
  }

  def fromStmtReturn(o: Stmt.Return): String = {
    return Printer.printStmtReturn(o).render
  }

  def toStmtReturn(s: String): Either[Stmt.Return, Json.ErrorMsg] = {
    def fStmtReturn(parser: Parser): Stmt.Return = {
      var r = parser.parseStmtReturn()
      return r
    }
    val r = to(s, fStmtReturn)
    return r
  }

  def fromStmtLStmt(o: Stmt.LStmt): String = {
    return Printer.printStmtLStmt(o).render
  }

  def toStmtLStmt(s: String): Either[Stmt.LStmt, Json.ErrorMsg] = {
    def fStmtLStmt(parser: Parser): Stmt.LStmt = {
      var r = parser.parseStmtLStmt()
      return r
    }
    val r = to(s, fStmtLStmt)
    return r
  }

  def fromStmtExpr(o: Stmt.Expr): String = {
    return Printer.printStmtExpr(o).render
  }

  def toStmtExpr(s: String): Either[Stmt.Expr, Json.ErrorMsg] = {
    def fStmtExpr(parser: Parser): Stmt.Expr = {
      var r = parser.parseStmtExpr()
      return r
    }
    val r = to(s, fStmtExpr)
    return r
  }

  def fromLClause(o: LClause): String = {
    return Printer.printLClause(o).render
  }

  def toLClause(s: String): Either[LClause, Json.ErrorMsg] = {
    def fLClause(parser: Parser): LClause = {
      var r = parser.parseLClause()
      return r
    }
    val r = to(s, fLClause)
    return r
  }

  def fromLClauseInvariants(o: LClause.Invariants): String = {
    return Printer.printLClauseInvariants(o).render
  }

  def toLClauseInvariants(s: String): Either[LClause.Invariants, Json.ErrorMsg] = {
    def fLClauseInvariants(parser: Parser): LClause.Invariants = {
      var r = parser.parseLClauseInvariants()
      return r
    }
    val r = to(s, fLClauseInvariants)
    return r
  }

  def fromLClauseFacts(o: LClause.Facts): String = {
    return Printer.printLClauseFacts(o).render
  }

  def toLClauseFacts(s: String): Either[LClause.Facts, Json.ErrorMsg] = {
    def fLClauseFacts(parser: Parser): LClause.Facts = {
      var r = parser.parseLClauseFacts()
      return r
    }
    val r = to(s, fLClauseFacts)
    return r
  }

  def fromLClauseFact(o: LClause.Fact): String = {
    return Printer.printLClauseFact(o).render
  }

  def toLClauseFact(s: String): Either[LClause.Fact, Json.ErrorMsg] = {
    def fLClauseFact(parser: Parser): LClause.Fact = {
      var r = parser.parseLClauseFact()
      return r
    }
    val r = to(s, fLClauseFact)
    return r
  }

  def fromLClauseTheorems(o: LClause.Theorems): String = {
    return Printer.printLClauseTheorems(o).render
  }

  def toLClauseTheorems(s: String): Either[LClause.Theorems, Json.ErrorMsg] = {
    def fLClauseTheorems(parser: Parser): LClause.Theorems = {
      var r = parser.parseLClauseTheorems()
      return r
    }
    val r = to(s, fLClauseTheorems)
    return r
  }

  def fromLClauseTheorem(o: LClause.Theorem): String = {
    return Printer.printLClauseTheorem(o).render
  }

  def toLClauseTheorem(s: String): Either[LClause.Theorem, Json.ErrorMsg] = {
    def fLClauseTheorem(parser: Parser): LClause.Theorem = {
      var r = parser.parseLClauseTheorem()
      return r
    }
    val r = to(s, fLClauseTheorem)
    return r
  }

  def fromLClauseSequent(o: LClause.Sequent): String = {
    return Printer.printLClauseSequent(o).render
  }

  def toLClauseSequent(s: String): Either[LClause.Sequent, Json.ErrorMsg] = {
    def fLClauseSequent(parser: Parser): LClause.Sequent = {
      var r = parser.parseLClauseSequent()
      return r
    }
    val r = to(s, fLClauseSequent)
    return r
  }

  def fromLClauseProof(o: LClause.Proof): String = {
    return Printer.printLClauseProof(o).render
  }

  def toLClauseProof(s: String): Either[LClause.Proof, Json.ErrorMsg] = {
    def fLClauseProof(parser: Parser): LClause.Proof = {
      var r = parser.parseLClauseProof()
      return r
    }
    val r = to(s, fLClauseProof)
    return r
  }

  def fromContractExp(o: ContractExp): String = {
    return Printer.printContractExp(o).render
  }

  def toContractExp(s: String): Either[ContractExp, Json.ErrorMsg] = {
    def fContractExp(parser: Parser): ContractExp = {
      var r = parser.parseContractExp()
      return r
    }
    val r = to(s, fContractExp)
    return r
  }

  def fromCase(o: Case): String = {
    return Printer.printCase(o).render
  }

  def toCase(s: String): Either[Case, Json.ErrorMsg] = {
    def fCase(parser: Parser): Case = {
      var r = parser.parseCase()
      return r
    }
    val r = to(s, fCase)
    return r
  }

  def fromEnumGenRange(o: EnumGen.Range): String = {
    return Printer.printEnumGenRange(o).render
  }

  def toEnumGenRange(s: String): Either[EnumGen.Range, Json.ErrorMsg] = {
    def fEnumGenRange(parser: Parser): EnumGen.Range = {
      var r = parser.parseEnumGenRange()
      return r
    }
    val r = to(s, fEnumGenRange)
    return r
  }

  def fromEnumGenRangeExpr(o: EnumGen.Range.Expr): String = {
    return Printer.printEnumGenRangeExpr(o).render
  }

  def toEnumGenRangeExpr(s: String): Either[EnumGen.Range.Expr, Json.ErrorMsg] = {
    def fEnumGenRangeExpr(parser: Parser): EnumGen.Range.Expr = {
      var r = parser.parseEnumGenRangeExpr()
      return r
    }
    val r = to(s, fEnumGenRangeExpr)
    return r
  }

  def fromEnumGenRangeIndices(o: EnumGen.Range.Indices): String = {
    return Printer.printEnumGenRangeIndices(o).render
  }

  def toEnumGenRangeIndices(s: String): Either[EnumGen.Range.Indices, Json.ErrorMsg] = {
    def fEnumGenRangeIndices(parser: Parser): EnumGen.Range.Indices = {
      var r = parser.parseEnumGenRangeIndices()
      return r
    }
    val r = to(s, fEnumGenRangeIndices)
    return r
  }

  def fromEnumGenRangeStep(o: EnumGen.Range.Step): String = {
    return Printer.printEnumGenRangeStep(o).render
  }

  def toEnumGenRangeStep(s: String): Either[EnumGen.Range.Step, Json.ErrorMsg] = {
    def fEnumGenRangeStep(parser: Parser): EnumGen.Range.Step = {
      var r = parser.parseEnumGenRangeStep()
      return r
    }
    val r = to(s, fEnumGenRangeStep)
    return r
  }

  def fromEnumGenFor(o: EnumGen.For): String = {
    return Printer.printEnumGenFor(o).render
  }

  def toEnumGenFor(s: String): Either[EnumGen.For, Json.ErrorMsg] = {
    def fEnumGenFor(parser: Parser): EnumGen.For = {
      var r = parser.parseEnumGenFor()
      return r
    }
    val r = to(s, fEnumGenFor)
    return r
  }

  def fromType(o: Type): String = {
    return Printer.printType(o).render
  }

  def toType(s: String): Either[Type, Json.ErrorMsg] = {
    def fType(parser: Parser): Type = {
      var r = parser.parseType()
      return r
    }
    val r = to(s, fType)
    return r
  }

  def fromTypeNamed(o: Type.Named): String = {
    return Printer.printTypeNamed(o).render
  }

  def toTypeNamed(s: String): Either[Type.Named, Json.ErrorMsg] = {
    def fTypeNamed(parser: Parser): Type.Named = {
      var r = parser.parseTypeNamed()
      return r
    }
    val r = to(s, fTypeNamed)
    return r
  }

  def fromTypeFun(o: Type.Fun): String = {
    return Printer.printTypeFun(o).render
  }

  def toTypeFun(s: String): Either[Type.Fun, Json.ErrorMsg] = {
    def fTypeFun(parser: Parser): Type.Fun = {
      var r = parser.parseTypeFun()
      return r
    }
    val r = to(s, fTypeFun)
    return r
  }

  def fromTypeTuple(o: Type.Tuple): String = {
    return Printer.printTypeTuple(o).render
  }

  def toTypeTuple(s: String): Either[Type.Tuple, Json.ErrorMsg] = {
    def fTypeTuple(parser: Parser): Type.Tuple = {
      var r = parser.parseTypeTuple()
      return r
    }
    val r = to(s, fTypeTuple)
    return r
  }

  def fromPattern(o: Pattern): String = {
    return Printer.printPattern(o).render
  }

  def toPattern(s: String): Either[Pattern, Json.ErrorMsg] = {
    def fPattern(parser: Parser): Pattern = {
      var r = parser.parsePattern()
      return r
    }
    val r = to(s, fPattern)
    return r
  }

  def fromPatternLiteral(o: Pattern.Literal): String = {
    return Printer.printPatternLiteral(o).render
  }

  def toPatternLiteral(s: String): Either[Pattern.Literal, Json.ErrorMsg] = {
    def fPatternLiteral(parser: Parser): Pattern.Literal = {
      var r = parser.parsePatternLiteral()
      return r
    }
    val r = to(s, fPatternLiteral)
    return r
  }

  def fromPatternRef(o: Pattern.Ref): String = {
    return Printer.printPatternRef(o).render
  }

  def toPatternRef(s: String): Either[Pattern.Ref, Json.ErrorMsg] = {
    def fPatternRef(parser: Parser): Pattern.Ref = {
      var r = parser.parsePatternRef()
      return r
    }
    val r = to(s, fPatternRef)
    return r
  }

  def fromPatternVariable(o: Pattern.Variable): String = {
    return Printer.printPatternVariable(o).render
  }

  def toPatternVariable(s: String): Either[Pattern.Variable, Json.ErrorMsg] = {
    def fPatternVariable(parser: Parser): Pattern.Variable = {
      var r = parser.parsePatternVariable()
      return r
    }
    val r = to(s, fPatternVariable)
    return r
  }

  def fromPatternWildcard(o: Pattern.Wildcard): String = {
    return Printer.printPatternWildcard(o).render
  }

  def toPatternWildcard(s: String): Either[Pattern.Wildcard, Json.ErrorMsg] = {
    def fPatternWildcard(parser: Parser): Pattern.Wildcard = {
      var r = parser.parsePatternWildcard()
      return r
    }
    val r = to(s, fPatternWildcard)
    return r
  }

  def fromPatternSeqWildcard(o: Pattern.SeqWildcard): String = {
    return Printer.printPatternSeqWildcard(o).render
  }

  def toPatternSeqWildcard(s: String): Either[Pattern.SeqWildcard, Json.ErrorMsg] = {
    def fPatternSeqWildcard(parser: Parser): Pattern.SeqWildcard = {
      var r = parser.parsePatternSeqWildcard()
      return r
    }
    val r = to(s, fPatternSeqWildcard)
    return r
  }

  def fromPatternStructure(o: Pattern.Structure): String = {
    return Printer.printPatternStructure(o).render
  }

  def toPatternStructure(s: String): Either[Pattern.Structure, Json.ErrorMsg] = {
    def fPatternStructure(parser: Parser): Pattern.Structure = {
      var r = parser.parsePatternStructure()
      return r
    }
    val r = to(s, fPatternStructure)
    return r
  }

  def fromExp(o: Exp): String = {
    return Printer.printExp(o).render
  }

  def toExp(s: String): Either[Exp, Json.ErrorMsg] = {
    def fExp(parser: Parser): Exp = {
      var r = parser.parseExp()
      return r
    }
    val r = to(s, fExp)
    return r
  }

  def fromLit(o: Lit): String = {
    return Printer.printLit(o).render
  }

  def toLit(s: String): Either[Lit, Json.ErrorMsg] = {
    def fLit(parser: Parser): Lit = {
      var r = parser.parseLit()
      return r
    }
    val r = to(s, fLit)
    return r
  }

  def fromExpLitB(o: Exp.LitB): String = {
    return Printer.printExpLitB(o).render
  }

  def toExpLitB(s: String): Either[Exp.LitB, Json.ErrorMsg] = {
    def fExpLitB(parser: Parser): Exp.LitB = {
      var r = parser.parseExpLitB()
      return r
    }
    val r = to(s, fExpLitB)
    return r
  }

  def fromExpLitC(o: Exp.LitC): String = {
    return Printer.printExpLitC(o).render
  }

  def toExpLitC(s: String): Either[Exp.LitC, Json.ErrorMsg] = {
    def fExpLitC(parser: Parser): Exp.LitC = {
      var r = parser.parseExpLitC()
      return r
    }
    val r = to(s, fExpLitC)
    return r
  }

  def fromExpLitZ(o: Exp.LitZ): String = {
    return Printer.printExpLitZ(o).render
  }

  def toExpLitZ(s: String): Either[Exp.LitZ, Json.ErrorMsg] = {
    def fExpLitZ(parser: Parser): Exp.LitZ = {
      var r = parser.parseExpLitZ()
      return r
    }
    val r = to(s, fExpLitZ)
    return r
  }

  def fromExpLitZ8(o: Exp.LitZ8): String = {
    return Printer.printExpLitZ8(o).render
  }

  def toExpLitZ8(s: String): Either[Exp.LitZ8, Json.ErrorMsg] = {
    def fExpLitZ8(parser: Parser): Exp.LitZ8 = {
      var r = parser.parseExpLitZ8()
      return r
    }
    val r = to(s, fExpLitZ8)
    return r
  }

  def fromExpLitZ16(o: Exp.LitZ16): String = {
    return Printer.printExpLitZ16(o).render
  }

  def toExpLitZ16(s: String): Either[Exp.LitZ16, Json.ErrorMsg] = {
    def fExpLitZ16(parser: Parser): Exp.LitZ16 = {
      var r = parser.parseExpLitZ16()
      return r
    }
    val r = to(s, fExpLitZ16)
    return r
  }

  def fromExpLitZ32(o: Exp.LitZ32): String = {
    return Printer.printExpLitZ32(o).render
  }

  def toExpLitZ32(s: String): Either[Exp.LitZ32, Json.ErrorMsg] = {
    def fExpLitZ32(parser: Parser): Exp.LitZ32 = {
      var r = parser.parseExpLitZ32()
      return r
    }
    val r = to(s, fExpLitZ32)
    return r
  }

  def fromExpLitZ64(o: Exp.LitZ64): String = {
    return Printer.printExpLitZ64(o).render
  }

  def toExpLitZ64(s: String): Either[Exp.LitZ64, Json.ErrorMsg] = {
    def fExpLitZ64(parser: Parser): Exp.LitZ64 = {
      var r = parser.parseExpLitZ64()
      return r
    }
    val r = to(s, fExpLitZ64)
    return r
  }

  def fromExpLitN(o: Exp.LitN): String = {
    return Printer.printExpLitN(o).render
  }

  def toExpLitN(s: String): Either[Exp.LitN, Json.ErrorMsg] = {
    def fExpLitN(parser: Parser): Exp.LitN = {
      var r = parser.parseExpLitN()
      return r
    }
    val r = to(s, fExpLitN)
    return r
  }

  def fromExpLitN8(o: Exp.LitN8): String = {
    return Printer.printExpLitN8(o).render
  }

  def toExpLitN8(s: String): Either[Exp.LitN8, Json.ErrorMsg] = {
    def fExpLitN8(parser: Parser): Exp.LitN8 = {
      var r = parser.parseExpLitN8()
      return r
    }
    val r = to(s, fExpLitN8)
    return r
  }

  def fromExpLitN16(o: Exp.LitN16): String = {
    return Printer.printExpLitN16(o).render
  }

  def toExpLitN16(s: String): Either[Exp.LitN16, Json.ErrorMsg] = {
    def fExpLitN16(parser: Parser): Exp.LitN16 = {
      var r = parser.parseExpLitN16()
      return r
    }
    val r = to(s, fExpLitN16)
    return r
  }

  def fromExpLitN32(o: Exp.LitN32): String = {
    return Printer.printExpLitN32(o).render
  }

  def toExpLitN32(s: String): Either[Exp.LitN32, Json.ErrorMsg] = {
    def fExpLitN32(parser: Parser): Exp.LitN32 = {
      var r = parser.parseExpLitN32()
      return r
    }
    val r = to(s, fExpLitN32)
    return r
  }

  def fromExpLitN64(o: Exp.LitN64): String = {
    return Printer.printExpLitN64(o).render
  }

  def toExpLitN64(s: String): Either[Exp.LitN64, Json.ErrorMsg] = {
    def fExpLitN64(parser: Parser): Exp.LitN64 = {
      var r = parser.parseExpLitN64()
      return r
    }
    val r = to(s, fExpLitN64)
    return r
  }

  def fromExpLitS8(o: Exp.LitS8): String = {
    return Printer.printExpLitS8(o).render
  }

  def toExpLitS8(s: String): Either[Exp.LitS8, Json.ErrorMsg] = {
    def fExpLitS8(parser: Parser): Exp.LitS8 = {
      var r = parser.parseExpLitS8()
      return r
    }
    val r = to(s, fExpLitS8)
    return r
  }

  def fromExpLitS16(o: Exp.LitS16): String = {
    return Printer.printExpLitS16(o).render
  }

  def toExpLitS16(s: String): Either[Exp.LitS16, Json.ErrorMsg] = {
    def fExpLitS16(parser: Parser): Exp.LitS16 = {
      var r = parser.parseExpLitS16()
      return r
    }
    val r = to(s, fExpLitS16)
    return r
  }

  def fromExpLitS32(o: Exp.LitS32): String = {
    return Printer.printExpLitS32(o).render
  }

  def toExpLitS32(s: String): Either[Exp.LitS32, Json.ErrorMsg] = {
    def fExpLitS32(parser: Parser): Exp.LitS32 = {
      var r = parser.parseExpLitS32()
      return r
    }
    val r = to(s, fExpLitS32)
    return r
  }

  def fromExpLitS64(o: Exp.LitS64): String = {
    return Printer.printExpLitS64(o).render
  }

  def toExpLitS64(s: String): Either[Exp.LitS64, Json.ErrorMsg] = {
    def fExpLitS64(parser: Parser): Exp.LitS64 = {
      var r = parser.parseExpLitS64()
      return r
    }
    val r = to(s, fExpLitS64)
    return r
  }

  def fromExpLitU8(o: Exp.LitU8): String = {
    return Printer.printExpLitU8(o).render
  }

  def toExpLitU8(s: String): Either[Exp.LitU8, Json.ErrorMsg] = {
    def fExpLitU8(parser: Parser): Exp.LitU8 = {
      var r = parser.parseExpLitU8()
      return r
    }
    val r = to(s, fExpLitU8)
    return r
  }

  def fromExpLitU16(o: Exp.LitU16): String = {
    return Printer.printExpLitU16(o).render
  }

  def toExpLitU16(s: String): Either[Exp.LitU16, Json.ErrorMsg] = {
    def fExpLitU16(parser: Parser): Exp.LitU16 = {
      var r = parser.parseExpLitU16()
      return r
    }
    val r = to(s, fExpLitU16)
    return r
  }

  def fromExpLitU32(o: Exp.LitU32): String = {
    return Printer.printExpLitU32(o).render
  }

  def toExpLitU32(s: String): Either[Exp.LitU32, Json.ErrorMsg] = {
    def fExpLitU32(parser: Parser): Exp.LitU32 = {
      var r = parser.parseExpLitU32()
      return r
    }
    val r = to(s, fExpLitU32)
    return r
  }

  def fromExpLitU64(o: Exp.LitU64): String = {
    return Printer.printExpLitU64(o).render
  }

  def toExpLitU64(s: String): Either[Exp.LitU64, Json.ErrorMsg] = {
    def fExpLitU64(parser: Parser): Exp.LitU64 = {
      var r = parser.parseExpLitU64()
      return r
    }
    val r = to(s, fExpLitU64)
    return r
  }

  def fromExpLitF32(o: Exp.LitF32): String = {
    return Printer.printExpLitF32(o).render
  }

  def toExpLitF32(s: String): Either[Exp.LitF32, Json.ErrorMsg] = {
    def fExpLitF32(parser: Parser): Exp.LitF32 = {
      var r = parser.parseExpLitF32()
      return r
    }
    val r = to(s, fExpLitF32)
    return r
  }

  def fromExpLitF64(o: Exp.LitF64): String = {
    return Printer.printExpLitF64(o).render
  }

  def toExpLitF64(s: String): Either[Exp.LitF64, Json.ErrorMsg] = {
    def fExpLitF64(parser: Parser): Exp.LitF64 = {
      var r = parser.parseExpLitF64()
      return r
    }
    val r = to(s, fExpLitF64)
    return r
  }

  def fromExpLitR(o: Exp.LitR): String = {
    return Printer.printExpLitR(o).render
  }

  def toExpLitR(s: String): Either[Exp.LitR, Json.ErrorMsg] = {
    def fExpLitR(parser: Parser): Exp.LitR = {
      var r = parser.parseExpLitR()
      return r
    }
    val r = to(s, fExpLitR)
    return r
  }

  def fromExpLitBv(o: Exp.LitBv): String = {
    return Printer.printExpLitBv(o).render
  }

  def toExpLitBv(s: String): Either[Exp.LitBv, Json.ErrorMsg] = {
    def fExpLitBv(parser: Parser): Exp.LitBv = {
      var r = parser.parseExpLitBv()
      return r
    }
    val r = to(s, fExpLitBv)
    return r
  }

  def fromExpLitString(o: Exp.LitString): String = {
    return Printer.printExpLitString(o).render
  }

  def toExpLitString(s: String): Either[Exp.LitString, Json.ErrorMsg] = {
    def fExpLitString(parser: Parser): Exp.LitString = {
      var r = parser.parseExpLitString()
      return r
    }
    val r = to(s, fExpLitString)
    return r
  }

  def fromExpStringInterpolate(o: Exp.StringInterpolate): String = {
    return Printer.printExpStringInterpolate(o).render
  }

  def toExpStringInterpolate(s: String): Either[Exp.StringInterpolate, Json.ErrorMsg] = {
    def fExpStringInterpolate(parser: Parser): Exp.StringInterpolate = {
      var r = parser.parseExpStringInterpolate()
      return r
    }
    val r = to(s, fExpStringInterpolate)
    return r
  }

  def fromExpThis(o: Exp.This): String = {
    return Printer.printExpThis(o).render
  }

  def toExpThis(s: String): Either[Exp.This, Json.ErrorMsg] = {
    def fExpThis(parser: Parser): Exp.This = {
      var r = parser.parseExpThis()
      return r
    }
    val r = to(s, fExpThis)
    return r
  }

  def fromExpSuper(o: Exp.Super): String = {
    return Printer.printExpSuper(o).render
  }

  def toExpSuper(s: String): Either[Exp.Super, Json.ErrorMsg] = {
    def fExpSuper(parser: Parser): Exp.Super = {
      var r = parser.parseExpSuper()
      return r
    }
    val r = to(s, fExpSuper)
    return r
  }

  def fromExpUnary(o: Exp.Unary): String = {
    return Printer.printExpUnary(o).render
  }

  def toExpUnary(s: String): Either[Exp.Unary, Json.ErrorMsg] = {
    def fExpUnary(parser: Parser): Exp.Unary = {
      var r = parser.parseExpUnary()
      return r
    }
    val r = to(s, fExpUnary)
    return r
  }

  def fromExpBinary(o: Exp.Binary): String = {
    return Printer.printExpBinary(o).render
  }

  def toExpBinary(s: String): Either[Exp.Binary, Json.ErrorMsg] = {
    def fExpBinary(parser: Parser): Exp.Binary = {
      var r = parser.parseExpBinary()
      return r
    }
    val r = to(s, fExpBinary)
    return r
  }

  def fromExpIdent(o: Exp.Ident): String = {
    return Printer.printExpIdent(o).render
  }

  def toExpIdent(s: String): Either[Exp.Ident, Json.ErrorMsg] = {
    def fExpIdent(parser: Parser): Exp.Ident = {
      var r = parser.parseExpIdent()
      return r
    }
    val r = to(s, fExpIdent)
    return r
  }

  def fromExpEta(o: Exp.Eta): String = {
    return Printer.printExpEta(o).render
  }

  def toExpEta(s: String): Either[Exp.Eta, Json.ErrorMsg] = {
    def fExpEta(parser: Parser): Exp.Eta = {
      var r = parser.parseExpEta()
      return r
    }
    val r = to(s, fExpEta)
    return r
  }

  def fromExpTuple(o: Exp.Tuple): String = {
    return Printer.printExpTuple(o).render
  }

  def toExpTuple(s: String): Either[Exp.Tuple, Json.ErrorMsg] = {
    def fExpTuple(parser: Parser): Exp.Tuple = {
      var r = parser.parseExpTuple()
      return r
    }
    val r = to(s, fExpTuple)
    return r
  }

  def fromExpSelect(o: Exp.Select): String = {
    return Printer.printExpSelect(o).render
  }

  def toExpSelect(s: String): Either[Exp.Select, Json.ErrorMsg] = {
    def fExpSelect(parser: Parser): Exp.Select = {
      var r = parser.parseExpSelect()
      return r
    }
    val r = to(s, fExpSelect)
    return r
  }

  def fromExpInvoke(o: Exp.Invoke): String = {
    return Printer.printExpInvoke(o).render
  }

  def toExpInvoke(s: String): Either[Exp.Invoke, Json.ErrorMsg] = {
    def fExpInvoke(parser: Parser): Exp.Invoke = {
      var r = parser.parseExpInvoke()
      return r
    }
    val r = to(s, fExpInvoke)
    return r
  }

  def fromExpInvokeNamed(o: Exp.InvokeNamed): String = {
    return Printer.printExpInvokeNamed(o).render
  }

  def toExpInvokeNamed(s: String): Either[Exp.InvokeNamed, Json.ErrorMsg] = {
    def fExpInvokeNamed(parser: Parser): Exp.InvokeNamed = {
      var r = parser.parseExpInvokeNamed()
      return r
    }
    val r = to(s, fExpInvokeNamed)
    return r
  }

  def fromExpIf(o: Exp.If): String = {
    return Printer.printExpIf(o).render
  }

  def toExpIf(s: String): Either[Exp.If, Json.ErrorMsg] = {
    def fExpIf(parser: Parser): Exp.If = {
      var r = parser.parseExpIf()
      return r
    }
    val r = to(s, fExpIf)
    return r
  }

  def fromExpFun(o: Exp.Fun): String = {
    return Printer.printExpFun(o).render
  }

  def toExpFun(s: String): Either[Exp.Fun, Json.ErrorMsg] = {
    def fExpFun(parser: Parser): Exp.Fun = {
      var r = parser.parseExpFun()
      return r
    }
    val r = to(s, fExpFun)
    return r
  }

  def fromExpForYield(o: Exp.ForYield): String = {
    return Printer.printExpForYield(o).render
  }

  def toExpForYield(s: String): Either[Exp.ForYield, Json.ErrorMsg] = {
    def fExpForYield(parser: Parser): Exp.ForYield = {
      var r = parser.parseExpForYield()
      return r
    }
    val r = to(s, fExpForYield)
    return r
  }

  def fromExpQuant(o: Exp.Quant): String = {
    return Printer.printExpQuant(o).render
  }

  def toExpQuant(s: String): Either[Exp.Quant, Json.ErrorMsg] = {
    def fExpQuant(parser: Parser): Exp.Quant = {
      var r = parser.parseExpQuant()
      return r
    }
    val r = to(s, fExpQuant)
    return r
  }

  def fromNamedArg(o: NamedArg): String = {
    return Printer.printNamedArg(o).render
  }

  def toNamedArg(s: String): Either[NamedArg, Json.ErrorMsg] = {
    def fNamedArg(parser: Parser): NamedArg = {
      var r = parser.parseNamedArg()
      return r
    }
    val r = to(s, fNamedArg)
    return r
  }

  def fromVarFragment(o: VarFragment): String = {
    return Printer.printVarFragment(o).render
  }

  def toVarFragment(s: String): Either[VarFragment, Json.ErrorMsg] = {
    def fVarFragment(parser: Parser): VarFragment = {
      var r = parser.parseVarFragment()
      return r
    }
    val r = to(s, fVarFragment)
    return r
  }

  def fromDomain(o: Domain): String = {
    return Printer.printDomain(o).render
  }

  def toDomain(s: String): Either[Domain, Json.ErrorMsg] = {
    def fDomain(parser: Parser): Domain = {
      var r = parser.parseDomain()
      return r
    }
    val r = to(s, fDomain)
    return r
  }

  def fromDomainType(o: Domain.Type): String = {
    return Printer.printDomainType(o).render
  }

  def toDomainType(s: String): Either[Domain.Type, Json.ErrorMsg] = {
    def fDomainType(parser: Parser): Domain.Type = {
      var r = parser.parseDomainType()
      return r
    }
    val r = to(s, fDomainType)
    return r
  }

  def fromDomainRange(o: Domain.Range): String = {
    return Printer.printDomainRange(o).render
  }

  def toDomainRange(s: String): Either[Domain.Range, Json.ErrorMsg] = {
    def fDomainRange(parser: Parser): Domain.Range = {
      var r = parser.parseDomainRange()
      return r
    }
    val r = to(s, fDomainRange)
    return r
  }

  def fromId(o: Id): String = {
    return Printer.printId(o).render
  }

  def toId(s: String): Either[Id, Json.ErrorMsg] = {
    def fId(parser: Parser): Id = {
      var r = parser.parseId()
      return r
    }
    val r = to(s, fId)
    return r
  }

  def fromName(o: Name): String = {
    return Printer.printName(o).render
  }

  def toName(s: String): Either[Name, Json.ErrorMsg] = {
    def fName(parser: Parser): Name = {
      var r = parser.parseName()
      return r
    }
    val r = to(s, fName)
    return r
  }

  def fromBody(o: Body): String = {
    return Printer.printBody(o).render
  }

  def toBody(s: String): Either[Body, Json.ErrorMsg] = {
    def fBody(parser: Parser): Body = {
      var r = parser.parseBody()
      return r
    }
    val r = to(s, fBody)
    return r
  }

  def fromAbstractDatatypeParam(o: AbstractDatatypeParam): String = {
    return Printer.printAbstractDatatypeParam(o).render
  }

  def toAbstractDatatypeParam(s: String): Either[AbstractDatatypeParam, Json.ErrorMsg] = {
    def fAbstractDatatypeParam(parser: Parser): AbstractDatatypeParam = {
      var r = parser.parseAbstractDatatypeParam()
      return r
    }
    val r = to(s, fAbstractDatatypeParam)
    return r
  }

  def fromMethodSig(o: MethodSig): String = {
    return Printer.printMethodSig(o).render
  }

  def toMethodSig(s: String): Either[MethodSig, Json.ErrorMsg] = {
    def fMethodSig(parser: Parser): MethodSig = {
      var r = parser.parseMethodSig()
      return r
    }
    val r = to(s, fMethodSig)
    return r
  }

  def fromParam(o: Param): String = {
    return Printer.printParam(o).render
  }

  def toParam(s: String): Either[Param, Json.ErrorMsg] = {
    def fParam(parser: Parser): Param = {
      var r = parser.parseParam()
      return r
    }
    val r = to(s, fParam)
    return r
  }

  def fromTypeParam(o: TypeParam): String = {
    return Printer.printTypeParam(o).render
  }

  def toTypeParam(s: String): Either[TypeParam, Json.ErrorMsg] = {
    def fTypeParam(parser: Parser): TypeParam = {
      var r = parser.parseTypeParam()
      return r
    }
    val r = to(s, fTypeParam)
    return r
  }

  def fromContract(o: Contract): String = {
    return Printer.printContract(o).render
  }

  def toContract(s: String): Either[Contract, Json.ErrorMsg] = {
    def fContract(parser: Parser): Contract = {
      var r = parser.parseContract()
      return r
    }
    val r = to(s, fContract)
    return r
  }

  def fromSubContract(o: SubContract): String = {
    return Printer.printSubContract(o).render
  }

  def toSubContract(s: String): Either[SubContract, Json.ErrorMsg] = {
    def fSubContract(parser: Parser): SubContract = {
      var r = parser.parseSubContract()
      return r
    }
    val r = to(s, fSubContract)
    return r
  }

  def fromSubContractParam(o: SubContractParam): String = {
    return Printer.printSubContractParam(o).render
  }

  def toSubContractParam(s: String): Either[SubContractParam, Json.ErrorMsg] = {
    def fSubContractParam(parser: Parser): SubContractParam = {
      var r = parser.parseSubContractParam()
      return r
    }
    val r = to(s, fSubContractParam)
    return r
  }

  def fromWhereDef(o: WhereDef): String = {
    return Printer.printWhereDef(o).render
  }

  def toWhereDef(s: String): Either[WhereDef, Json.ErrorMsg] = {
    def fWhereDef(parser: Parser): WhereDef = {
      var r = parser.parseWhereDef()
      return r
    }
    val r = to(s, fWhereDef)
    return r
  }

  def fromWhereDefVal(o: WhereDef.Val): String = {
    return Printer.printWhereDefVal(o).render
  }

  def toWhereDefVal(s: String): Either[WhereDef.Val, Json.ErrorMsg] = {
    def fWhereDefVal(parser: Parser): WhereDef.Val = {
      var r = parser.parseWhereDefVal()
      return r
    }
    val r = to(s, fWhereDefVal)
    return r
  }

  def fromWhereDefDef(o: WhereDef.Def): String = {
    return Printer.printWhereDefDef(o).render
  }

  def toWhereDefDef(s: String): Either[WhereDef.Def, Json.ErrorMsg] = {
    def fWhereDefDef(parser: Parser): WhereDef.Def = {
      var r = parser.parseWhereDefDef()
      return r
    }
    val r = to(s, fWhereDefDef)
    return r
  }

  def fromSpecDef(o: SpecDef): String = {
    return Printer.printSpecDef(o).render
  }

  def toSpecDef(s: String): Either[SpecDef, Json.ErrorMsg] = {
    def fSpecDef(parser: Parser): SpecDef = {
      var r = parser.parseSpecDef()
      return r
    }
    val r = to(s, fSpecDef)
    return r
  }

  def fromProofStep(o: ProofStep): String = {
    return Printer.printProofStep(o).render
  }

  def toProofStep(s: String): Either[ProofStep, Json.ErrorMsg] = {
    def fProofStep(parser: Parser): ProofStep = {
      var r = parser.parseProofStep()
      return r
    }
    val r = to(s, fProofStep)
    return r
  }

  def fromProofStepBasic(o: ProofStep.Basic): String = {
    return Printer.printProofStepBasic(o).render
  }

  def toProofStepBasic(s: String): Either[ProofStep.Basic, Json.ErrorMsg] = {
    def fProofStepBasic(parser: Parser): ProofStep.Basic = {
      var r = parser.parseProofStepBasic()
      return r
    }
    val r = to(s, fProofStepBasic)
    return r
  }

  def fromProofStepSubProof(o: ProofStep.SubProof): String = {
    return Printer.printProofStepSubProof(o).render
  }

  def toProofStepSubProof(s: String): Either[ProofStep.SubProof, Json.ErrorMsg] = {
    def fProofStepSubProof(parser: Parser): ProofStep.SubProof = {
      var r = parser.parseProofStepSubProof()
      return r
    }
    val r = to(s, fProofStepSubProof)
    return r
  }

  def fromAssumeProofStep(o: AssumeProofStep): String = {
    return Printer.printAssumeProofStep(o).render
  }

  def toAssumeProofStep(s: String): Either[AssumeProofStep, Json.ErrorMsg] = {
    def fAssumeProofStep(parser: Parser): AssumeProofStep = {
      var r = parser.parseAssumeProofStep()
      return r
    }
    val r = to(s, fAssumeProofStep)
    return r
  }

  def fromAssumeProofStepRegular(o: AssumeProofStep.Regular): String = {
    return Printer.printAssumeProofStepRegular(o).render
  }

  def toAssumeProofStepRegular(s: String): Either[AssumeProofStep.Regular, Json.ErrorMsg] = {
    def fAssumeProofStepRegular(parser: Parser): AssumeProofStep.Regular = {
      var r = parser.parseAssumeProofStepRegular()
      return r
    }
    val r = to(s, fAssumeProofStepRegular)
    return r
  }

  def fromAssumeProofStepForallIntroAps(o: AssumeProofStep.ForallIntroAps): String = {
    return Printer.printAssumeProofStepForallIntroAps(o).render
  }

  def toAssumeProofStepForallIntroAps(s: String): Either[AssumeProofStep.ForallIntroAps, Json.ErrorMsg] = {
    def fAssumeProofStepForallIntroAps(parser: Parser): AssumeProofStep.ForallIntroAps = {
      var r = parser.parseAssumeProofStepForallIntroAps()
      return r
    }
    val r = to(s, fAssumeProofStepForallIntroAps)
    return r
  }

  def fromAssumeProofStepExistsElimAps(o: AssumeProofStep.ExistsElimAps): String = {
    return Printer.printAssumeProofStepExistsElimAps(o).render
  }

  def toAssumeProofStepExistsElimAps(s: String): Either[AssumeProofStep.ExistsElimAps, Json.ErrorMsg] = {
    def fAssumeProofStepExistsElimAps(parser: Parser): AssumeProofStep.ExistsElimAps = {
      var r = parser.parseAssumeProofStepExistsElimAps()
      return r
    }
    val r = to(s, fAssumeProofStepExistsElimAps)
    return r
  }

  def fromJust(o: Just): String = {
    return Printer.printJust(o).render
  }

  def toJust(s: String): Either[Just, Json.ErrorMsg] = {
    def fJust(parser: Parser): Just = {
      var r = parser.parseJust()
      return r
    }
    val r = to(s, fJust)
    return r
  }

  def fromJustPremise(o: Just.Premise): String = {
    return Printer.printJustPremise(o).render
  }

  def toJustPremise(s: String): Either[Just.Premise, Json.ErrorMsg] = {
    def fJustPremise(parser: Parser): Just.Premise = {
      var r = parser.parseJustPremise()
      return r
    }
    val r = to(s, fJustPremise)
    return r
  }

  def fromJustAndIntro(o: Just.AndIntro): String = {
    return Printer.printJustAndIntro(o).render
  }

  def toJustAndIntro(s: String): Either[Just.AndIntro, Json.ErrorMsg] = {
    def fJustAndIntro(parser: Parser): Just.AndIntro = {
      var r = parser.parseJustAndIntro()
      return r
    }
    val r = to(s, fJustAndIntro)
    return r
  }

  def fromJustAndElim(o: Just.AndElim): String = {
    return Printer.printJustAndElim(o).render
  }

  def toJustAndElim(s: String): Either[Just.AndElim, Json.ErrorMsg] = {
    def fJustAndElim(parser: Parser): Just.AndElim = {
      var r = parser.parseJustAndElim()
      return r
    }
    val r = to(s, fJustAndElim)
    return r
  }

  def fromJustOrIntro(o: Just.OrIntro): String = {
    return Printer.printJustOrIntro(o).render
  }

  def toJustOrIntro(s: String): Either[Just.OrIntro, Json.ErrorMsg] = {
    def fJustOrIntro(parser: Parser): Just.OrIntro = {
      var r = parser.parseJustOrIntro()
      return r
    }
    val r = to(s, fJustOrIntro)
    return r
  }

  def fromJustOrElim(o: Just.OrElim): String = {
    return Printer.printJustOrElim(o).render
  }

  def toJustOrElim(s: String): Either[Just.OrElim, Json.ErrorMsg] = {
    def fJustOrElim(parser: Parser): Just.OrElim = {
      var r = parser.parseJustOrElim()
      return r
    }
    val r = to(s, fJustOrElim)
    return r
  }

  def fromJustImplyIntro(o: Just.ImplyIntro): String = {
    return Printer.printJustImplyIntro(o).render
  }

  def toJustImplyIntro(s: String): Either[Just.ImplyIntro, Json.ErrorMsg] = {
    def fJustImplyIntro(parser: Parser): Just.ImplyIntro = {
      var r = parser.parseJustImplyIntro()
      return r
    }
    val r = to(s, fJustImplyIntro)
    return r
  }

  def fromJustImplyElim(o: Just.ImplyElim): String = {
    return Printer.printJustImplyElim(o).render
  }

  def toJustImplyElim(s: String): Either[Just.ImplyElim, Json.ErrorMsg] = {
    def fJustImplyElim(parser: Parser): Just.ImplyElim = {
      var r = parser.parseJustImplyElim()
      return r
    }
    val r = to(s, fJustImplyElim)
    return r
  }

  def fromJustNegIntro(o: Just.NegIntro): String = {
    return Printer.printJustNegIntro(o).render
  }

  def toJustNegIntro(s: String): Either[Just.NegIntro, Json.ErrorMsg] = {
    def fJustNegIntro(parser: Parser): Just.NegIntro = {
      var r = parser.parseJustNegIntro()
      return r
    }
    val r = to(s, fJustNegIntro)
    return r
  }

  def fromJustNegElim(o: Just.NegElim): String = {
    return Printer.printJustNegElim(o).render
  }

  def toJustNegElim(s: String): Either[Just.NegElim, Json.ErrorMsg] = {
    def fJustNegElim(parser: Parser): Just.NegElim = {
      var r = parser.parseJustNegElim()
      return r
    }
    val r = to(s, fJustNegElim)
    return r
  }

  def fromJustBottomElim(o: Just.BottomElim): String = {
    return Printer.printJustBottomElim(o).render
  }

  def toJustBottomElim(s: String): Either[Just.BottomElim, Json.ErrorMsg] = {
    def fJustBottomElim(parser: Parser): Just.BottomElim = {
      var r = parser.parseJustBottomElim()
      return r
    }
    val r = to(s, fJustBottomElim)
    return r
  }

  def fromJustPbc(o: Just.Pbc): String = {
    return Printer.printJustPbc(o).render
  }

  def toJustPbc(s: String): Either[Just.Pbc, Json.ErrorMsg] = {
    def fJustPbc(parser: Parser): Just.Pbc = {
      var r = parser.parseJustPbc()
      return r
    }
    val r = to(s, fJustPbc)
    return r
  }

  def fromJustForallIntro(o: Just.ForallIntro): String = {
    return Printer.printJustForallIntro(o).render
  }

  def toJustForallIntro(s: String): Either[Just.ForallIntro, Json.ErrorMsg] = {
    def fJustForallIntro(parser: Parser): Just.ForallIntro = {
      var r = parser.parseJustForallIntro()
      return r
    }
    val r = to(s, fJustForallIntro)
    return r
  }

  def fromJustForallElim(o: Just.ForallElim): String = {
    return Printer.printJustForallElim(o).render
  }

  def toJustForallElim(s: String): Either[Just.ForallElim, Json.ErrorMsg] = {
    def fJustForallElim(parser: Parser): Just.ForallElim = {
      var r = parser.parseJustForallElim()
      return r
    }
    val r = to(s, fJustForallElim)
    return r
  }

  def fromJustExistsIntro(o: Just.ExistsIntro): String = {
    return Printer.printJustExistsIntro(o).render
  }

  def toJustExistsIntro(s: String): Either[Just.ExistsIntro, Json.ErrorMsg] = {
    def fJustExistsIntro(parser: Parser): Just.ExistsIntro = {
      var r = parser.parseJustExistsIntro()
      return r
    }
    val r = to(s, fJustExistsIntro)
    return r
  }

  def fromJustExistsElim(o: Just.ExistsElim): String = {
    return Printer.printJustExistsElim(o).render
  }

  def toJustExistsElim(s: String): Either[Just.ExistsElim, Json.ErrorMsg] = {
    def fJustExistsElim(parser: Parser): Just.ExistsElim = {
      var r = parser.parseJustExistsElim()
      return r
    }
    val r = to(s, fJustExistsElim)
    return r
  }

  def fromJustFact(o: Just.Fact): String = {
    return Printer.printJustFact(o).render
  }

  def toJustFact(s: String): Either[Just.Fact, Json.ErrorMsg] = {
    def fJustFact(parser: Parser): Just.Fact = {
      var r = parser.parseJustFact()
      return r
    }
    val r = to(s, fJustFact)
    return r
  }

  def fromJustInvariant(o: Just.Invariant): String = {
    return Printer.printJustInvariant(o).render
  }

  def toJustInvariant(s: String): Either[Just.Invariant, Json.ErrorMsg] = {
    def fJustInvariant(parser: Parser): Just.Invariant = {
      var r = parser.parseJustInvariant()
      return r
    }
    val r = to(s, fJustInvariant)
    return r
  }

  def fromJustSubst(o: Just.Subst): String = {
    return Printer.printJustSubst(o).render
  }

  def toJustSubst(s: String): Either[Just.Subst, Json.ErrorMsg] = {
    def fJustSubst(parser: Parser): Just.Subst = {
      var r = parser.parseJustSubst()
      return r
    }
    val r = to(s, fJustSubst)
    return r
  }

  def fromJustAuto(o: Just.Auto): String = {
    return Printer.printJustAuto(o).render
  }

  def toJustAuto(s: String): Either[Just.Auto, Json.ErrorMsg] = {
    def fJustAuto(parser: Parser): Just.Auto = {
      var r = parser.parseJustAuto()
      return r
    }
    val r = to(s, fJustAuto)
    return r
  }

  def fromJustCoq(o: Just.Coq): String = {
    return Printer.printJustCoq(o).render
  }

  def toJustCoq(s: String): Either[Just.Coq, Json.ErrorMsg] = {
    def fJustCoq(parser: Parser): Just.Coq = {
      var r = parser.parseJustCoq()
      return r
    }
    val r = to(s, fJustCoq)
    return r
  }

  def fromTruthTableRow(o: TruthTable.Row): String = {
    return Printer.printTruthTableRow(o).render
  }

  def toTruthTableRow(s: String): Either[TruthTable.Row, Json.ErrorMsg] = {
    def fTruthTableRow(parser: Parser): TruthTable.Row = {
      var r = parser.parseTruthTableRow()
      return r
    }
    val r = to(s, fTruthTableRow)
    return r
  }

  def fromTruthTableAssignment(o: TruthTable.Assignment): String = {
    return Printer.printTruthTableAssignment(o).render
  }

  def toTruthTableAssignment(s: String): Either[TruthTable.Assignment, Json.ErrorMsg] = {
    def fTruthTableAssignment(parser: Parser): TruthTable.Assignment = {
      var r = parser.parseTruthTableAssignment()
      return r
    }
    val r = to(s, fTruthTableAssignment)
    return r
  }

  def fromTruthTableConclusion(o: TruthTable.Conclusion): String = {
    return Printer.printTruthTableConclusion(o).render
  }

  def toTruthTableConclusion(s: String): Either[TruthTable.Conclusion, Json.ErrorMsg] = {
    def fTruthTableConclusion(parser: Parser): TruthTable.Conclusion = {
      var r = parser.parseTruthTableConclusion()
      return r
    }
    val r = to(s, fTruthTableConclusion)
    return r
  }

  def fromTruthTableConclusionValidity(o: TruthTable.Conclusion.Validity): String = {
    return Printer.printTruthTableConclusionValidity(o).render
  }

  def toTruthTableConclusionValidity(s: String): Either[TruthTable.Conclusion.Validity, Json.ErrorMsg] = {
    def fTruthTableConclusionValidity(parser: Parser): TruthTable.Conclusion.Validity = {
      var r = parser.parseTruthTableConclusionValidity()
      return r
    }
    val r = to(s, fTruthTableConclusionValidity)
    return r
  }

  def fromTruthTableConclusionTautology(o: TruthTable.Conclusion.Tautology): String = {
    return Printer.printTruthTableConclusionTautology(o).render
  }

  def toTruthTableConclusionTautology(s: String): Either[TruthTable.Conclusion.Tautology, Json.ErrorMsg] = {
    def fTruthTableConclusionTautology(parser: Parser): TruthTable.Conclusion.Tautology = {
      var r = parser.parseTruthTableConclusionTautology()
      return r
    }
    val r = to(s, fTruthTableConclusionTautology)
    return r
  }

  def fromTruthTableConclusionContradictory(o: TruthTable.Conclusion.Contradictory): String = {
    return Printer.printTruthTableConclusionContradictory(o).render
  }

  def toTruthTableConclusionContradictory(s: String): Either[TruthTable.Conclusion.Contradictory, Json.ErrorMsg] = {
    def fTruthTableConclusionContradictory(parser: Parser): TruthTable.Conclusion.Contradictory = {
      var r = parser.parseTruthTableConclusionContradictory()
      return r
    }
    val r = to(s, fTruthTableConclusionContradictory)
    return r
  }

  def fromTruthTableConclusionContingent(o: TruthTable.Conclusion.Contingent): String = {
    return Printer.printTruthTableConclusionContingent(o).render
  }

  def toTruthTableConclusionContingent(s: String): Either[TruthTable.Conclusion.Contingent, Json.ErrorMsg] = {
    def fTruthTableConclusionContingent(parser: Parser): TruthTable.Conclusion.Contingent = {
      var r = parser.parseTruthTableConclusionContingent()
      return r
    }
    val r = to(s, fTruthTableConclusionContingent)
    return r
  }

  def fromAttr(o: Attr): String = {
    return Printer.printAttr(o).render
  }

  def toAttr(s: String): Either[Attr, Json.ErrorMsg] = {
    def fAttr(parser: Parser): Attr = {
      var r = parser.parseAttr()
      return r
    }
    val r = to(s, fAttr)
    return r
  }

  def fromTypedAttr(o: TypedAttr): String = {
    return Printer.printTypedAttr(o).render
  }

  def toTypedAttr(s: String): Either[TypedAttr, Json.ErrorMsg] = {
    def fTypedAttr(parser: Parser): TypedAttr = {
      var r = parser.parseTypedAttr()
      return r
    }
    val r = to(s, fTypedAttr)
    return r
  }

  def fromResolvedAttr(o: ResolvedAttr): String = {
    return Printer.printResolvedAttr(o).render
  }

  def toResolvedAttr(s: String): Either[ResolvedAttr, Json.ErrorMsg] = {
    def fResolvedAttr(parser: Parser): ResolvedAttr = {
      var r = parser.parseResolvedAttr()
      return r
    }
    val r = to(s, fResolvedAttr)
    return r
  }

  def fromResolvedInfo(o: ResolvedInfo): String = {
    return Printer.printResolvedInfo(o).render
  }

  def toResolvedInfo(s: String): Either[ResolvedInfo, Json.ErrorMsg] = {
    def fResolvedInfo(parser: Parser): ResolvedInfo = {
      var r = parser.parseResolvedInfo()
      return r
    }
    val r = to(s, fResolvedInfo)
    return r
  }

  def fromPosInfo(o: PosInfo): String = {
    return Printer.printPosInfo(o).render
  }

  def toPosInfo(s: String): Either[PosInfo, Json.ErrorMsg] = {
    def fPosInfo(parser: Parser): PosInfo = {
      var r = parser.parsePosInfo()
      return r
    }
    val r = to(s, fPosInfo)
    return r
  }

}