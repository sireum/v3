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
        ("type", st""""TopUnit.Program""""),
        ("fileUriOpt", printOption(o.fileUriOpt, printString)),
        ("packageName", printName(o.packageName)),
        ("body", printBody(o.body))
      ))
    }

    @pure def printTopUnitSequentUnit(o: TopUnit.SequentUnit): ST = {
      return printObject(ISZ(
        ("type", st""""TopUnit.SequentUnit""""),
        ("fileUriOpt", printOption(o.fileUriOpt, printString)),
        ("sequent", printLClauseSequent(o.sequent))
      ))
    }

    @pure def printTopUnitTruthTableUnit(o: TopUnit.TruthTableUnit): ST = {
      return printObject(ISZ(
        ("type", st""""TopUnit.TruthTableUnit""""),
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
        case o: Stmt.SubZ => return printStmtSubZ(o)
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
        ("type", st""""Stmt.Import""""),
        ("importers", printISZ(F, o.importers, printStmtImportImporter)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtImportImporter(o: Stmt.Import.Importer): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.Import.Importer""""),
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
        ("type", st""""Stmt.Import.MultiSelector""""),
        ("selectors", printISZ(F, o.selectors, printStmtImportNamedSelector))
      ))
    }

    @pure def printStmtImportWildcardSelector(o: Stmt.Import.WildcardSelector): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.Import.WildcardSelector"""")
      ))
    }

    @pure def printStmtImportNamedSelector(o: Stmt.Import.NamedSelector): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.Import.NamedSelector""""),
        ("from", printId(o.from)),
        ("to", printId(o.to))
      ))
    }

    @pure def printStmtVar(o: Stmt.Var): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.Var""""),
        ("isVal", printB(o.isVal)),
        ("id", printId(o.id)),
        ("tipeOpt", printOption(o.tipeOpt, printType)),
        ("initOpt", printOption(o.initOpt, printAssignExp)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtVarPattern(o: Stmt.VarPattern): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.VarPattern""""),
        ("isVal", printB(o.isVal)),
        ("pattern", printPattern(o.pattern)),
        ("init", printAssignExp(o.init)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtSpecVar(o: Stmt.SpecVar): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.SpecVar""""),
        ("isVal", printB(o.isVal)),
        ("id", printId(o.id)),
        ("tipe", printType(o.tipe)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtMethod(o: Stmt.Method): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.Method""""),
        ("purity", printPurity(o.purity)),
        ("hasOverride", printB(o.hasOverride)),
        ("isHelper", printB(o.isHelper)),
        ("sig", printMethodSig(o.sig)),
        ("contract", printContract(o.contract)),
        ("bodyOpt", printOption(o.bodyOpt, printBody)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtExtMethod(o: Stmt.ExtMethod): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.ExtMethod""""),
        ("isPure", printB(o.isPure)),
        ("sig", printMethodSig(o.sig)),
        ("contract", printContract(o.contract)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtSpecMethod(o: Stmt.SpecMethod): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.SpecMethod""""),
        ("sig", printMethodSig(o.sig)),
        ("defs", printISZ(F, o.defs, printSpecDef)),
        ("where", printISZ(F, o.where, printWhereDef)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtEnum(o: Stmt.Enum): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.Enum""""),
        ("id", printId(o.id)),
        ("elements", printISZ(F, o.elements, printId)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtSubZ(o: Stmt.SubZ): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.SubZ""""),
        ("id", printId(o.id)),
        ("isSigned", printB(o.isSigned)),
        ("isBitVector", printB(o.isBitVector)),
        ("isWrapped", printB(o.isWrapped)),
        ("hasMin", printB(o.hasMin)),
        ("hasMax", printB(o.hasMax)),
        ("bitWidth", printZ(o.bitWidth)),
        ("min", printZ(o.min)),
        ("max", printZ(o.max)),
        ("index", printZ(o.index)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtObject(o: Stmt.Object): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.Object""""),
        ("isExt", printB(o.isExt)),
        ("id", printId(o.id)),
        ("parents", printISZ(F, o.parents, printType)),
        ("stmts", printISZ(F, o.stmts, printStmt)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtSig(o: Stmt.Sig): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.Sig""""),
        ("isImmutable", printB(o.isImmutable)),
        ("isExt", printB(o.isExt)),
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
        ("type", st""""Stmt.AbstractDatatype""""),
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
        ("type", st""""Stmt.Rich""""),
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
        ("type", st""""Stmt.TypeAlias""""),
        ("id", printId(o.id)),
        ("typeParams", printISZ(F, o.typeParams, printTypeParam)),
        ("tipe", printType(o.tipe)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtAssign(o: Stmt.Assign): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.Assign""""),
        ("lhs", printExp(o.lhs)),
        ("rhs", printAssignExp(o.rhs)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtAssignUp(o: Stmt.AssignUp): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.AssignUp""""),
        ("lhs", printExp(o.lhs)),
        ("rhs", printAssignExp(o.rhs)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtAssignPattern(o: Stmt.AssignPattern): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.AssignPattern""""),
        ("lhs", printPattern(o.lhs)),
        ("rhs", printAssignExp(o.rhs)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtBlock(o: Stmt.Block): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.Block""""),
        ("body", printBody(o.body)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtIf(o: Stmt.If): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.If""""),
        ("cond", printExp(o.cond)),
        ("thenbody", printBody(o.thenbody)),
        ("elsebody", printBody(o.elsebody)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtMatch(o: Stmt.Match): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.Match""""),
        ("cond", printExp(o.cond)),
        ("cases", printISZ(F, o.cases, printCase)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtWhile(o: Stmt.While): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.While""""),
        ("cond", printExp(o.cond)),
        ("invariants", printISZ(F, o.invariants, printContractExp)),
        ("modifies", printISZ(F, o.modifies, printExp)),
        ("body", printBody(o.body)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtDoWhile(o: Stmt.DoWhile): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.DoWhile""""),
        ("cond", printExp(o.cond)),
        ("invariants", printISZ(F, o.invariants, printContractExp)),
        ("modifies", printISZ(F, o.modifies, printExp)),
        ("body", printBody(o.body)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtFor(o: Stmt.For): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.For""""),
        ("enumGen", printEnumGenFor(o.enumGen)),
        ("invariants", printISZ(F, o.invariants, printContractExp)),
        ("modifies", printISZ(F, o.modifies, printExp)),
        ("body", printBody(o.body)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtReturn(o: Stmt.Return): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.Return""""),
        ("expOpt", printOption(o.expOpt, printExp)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtLStmt(o: Stmt.LStmt): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.LStmt""""),
        ("clause", printLClause(o.clause)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printStmtExpr(o: Stmt.Expr): ST = {
      return printObject(ISZ(
        ("type", st""""Stmt.Expr""""),
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
        ("type", st""""LClause.Invariants""""),
        ("value", printISZ(F, o.value, printContractExp))
      ))
    }

    @pure def printLClauseFacts(o: LClause.Facts): ST = {
      return printObject(ISZ(
        ("type", st""""LClause.Facts""""),
        ("value", printISZ(F, o.value, printLClauseFact))
      ))
    }

    @pure def printLClauseFact(o: LClause.Fact): ST = {
      return printObject(ISZ(
        ("type", st""""LClause.Fact""""),
        ("id", printId(o.id)),
        ("exp", printExp(o.exp))
      ))
    }

    @pure def printLClauseTheorems(o: LClause.Theorems): ST = {
      return printObject(ISZ(
        ("type", st""""LClause.Theorems""""),
        ("value", printISZ(F, o.value, printLClauseTheorem))
      ))
    }

    @pure def printLClauseTheorem(o: LClause.Theorem): ST = {
      return printObject(ISZ(
        ("type", st""""LClause.Theorem""""),
        ("id", printId(o.id)),
        ("sequent", printLClauseSequent(o.sequent))
      ))
    }

    @pure def printLClauseSequent(o: LClause.Sequent): ST = {
      return printObject(ISZ(
        ("type", st""""LClause.Sequent""""),
        ("premises", printISZ(F, o.premises, printExp)),
        ("conclusions", printISZ(F, o.conclusions, printExp)),
        ("proofOpt", printOption(o.proofOpt, printLClauseProof))
      ))
    }

    @pure def printLClauseProof(o: LClause.Proof): ST = {
      return printObject(ISZ(
        ("type", st""""LClause.Proof""""),
        ("steps", printISZ(F, o.steps, printProofStep))
      ))
    }

    @pure def printContractExp(o: ContractExp): ST = {
      return printObject(ISZ(
        ("type", st""""ContractExp""""),
        ("idOpt", printOption(o.idOpt, printId)),
        ("exp", printExp(o.exp))
      ))
    }

    @pure def printCase(o: Case): ST = {
      return printObject(ISZ(
        ("type", st""""Case""""),
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
        ("type", st""""EnumGen.Range.Expr""""),
        ("isReverse", printB(o.isReverse)),
        ("exp", printExp(o.exp))
      ))
    }

    @pure def printEnumGenRangeIndices(o: EnumGen.Range.Indices): ST = {
      return printObject(ISZ(
        ("type", st""""EnumGen.Range.Indices""""),
        ("isReverse", printB(o.isReverse)),
        ("exp", printExp(o.exp))
      ))
    }

    @pure def printEnumGenRangeStep(o: EnumGen.Range.Step): ST = {
      return printObject(ISZ(
        ("type", st""""EnumGen.Range.Step""""),
        ("isInclusive", printB(o.isInclusive)),
        ("start", printExp(o.start)),
        ("end", printExp(o.end)),
        ("byOpt", printOption(o.byOpt, printExp))
      ))
    }

    @pure def printEnumGenFor(o: EnumGen.For): ST = {
      return printObject(ISZ(
        ("type", st""""EnumGen.For""""),
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
        ("type", st""""Type.Named""""),
        ("name", printName(o.name)),
        ("typeArgs", printISZ(F, o.typeArgs, printType)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printTypeFun(o: Type.Fun): ST = {
      return printObject(ISZ(
        ("type", st""""Type.Fun""""),
        ("args", printISZ(F, o.args, printType)),
        ("ret", printType(o.ret)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printTypeTuple(o: Type.Tuple): ST = {
      return printObject(ISZ(
        ("type", st""""Type.Tuple""""),
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
        ("type", st""""Pattern.Literal""""),
        ("lit", printLit(o.lit))
      ))
    }

    @pure def printPatternRef(o: Pattern.Ref): ST = {
      return printObject(ISZ(
        ("type", st""""Pattern.Ref""""),
        ("name", printName(o.name))
      ))
    }

    @pure def printPatternVariable(o: Pattern.Variable): ST = {
      return printObject(ISZ(
        ("type", st""""Pattern.Variable""""),
        ("id", printId(o.id)),
        ("typeOpt", printOption(o.typeOpt, printType))
      ))
    }

    @pure def printPatternWildcard(o: Pattern.Wildcard): ST = {
      return printObject(ISZ(
        ("type", st""""Pattern.Wildcard""""),
        ("typeOpt", printOption(o.typeOpt, printType))
      ))
    }

    @pure def printPatternSeqWildcard(o: Pattern.SeqWildcard): ST = {
      return printObject(ISZ(
        ("type", st""""Pattern.SeqWildcard"""")
      ))
    }

    @pure def printPatternStructure(o: Pattern.Structure): ST = {
      return printObject(ISZ(
        ("type", st""""Pattern.Structure""""),
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
        case o: Exp.LitF32 => return printExpLitF32(o)
        case o: Exp.LitF64 => return printExpLitF64(o)
        case o: Exp.LitR => return printExpLitR(o)
        case o: Exp.LitBv => return printExpLitBv(o)
        case o: Exp.LitString => return printExpLitString(o)
      }
    }

    @pure def printExpLitB(o: Exp.LitB): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.LitB""""),
        ("value", printB(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitC(o: Exp.LitC): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.LitC""""),
        ("value", printC(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitZ(o: Exp.LitZ): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.LitZ""""),
        ("value", printZ(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitF32(o: Exp.LitF32): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.LitF32""""),
        ("value", printF32(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitF64(o: Exp.LitF64): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.LitF64""""),
        ("value", printF64(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitR(o: Exp.LitR): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.LitR""""),
        ("value", printR(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitBv(o: Exp.LitBv): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.LitBv""""),
        ("value", printISZ(T, o.value, printB)),
        ("tipe", printType(o.tipe)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpLitString(o: Exp.LitString): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.LitString""""),
        ("value", printString(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpStringInterpolate(o: Exp.StringInterpolate): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.StringInterpolate""""),
        ("prefix", printString(o.prefix)),
        ("lits", printISZ(F, o.lits, printExpLitString)),
        ("args", printISZ(F, o.args, printExp)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printExpThis(o: Exp.This): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.This""""),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printExpSuper(o: Exp.Super): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.Super""""),
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
        ("type", st""""Exp.Unary""""),
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
        ("type", st""""Exp.Binary""""),
        ("left", printExp(o.left)),
        ("op", printExpBinaryOp(o.op)),
        ("right", printExp(o.right)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printExpIdent(o: Exp.Ident): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.Ident""""),
        ("id", printId(o.id)),
        ("attr", printResolvedAttr(o.attr))
      ))
    }

    @pure def printExpEta(o: Exp.Eta): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.Eta""""),
        ("exp", printExp(o.exp)),
        ("attr", printResolvedAttr(o.attr))
      ))
    }

    @pure def printExpTuple(o: Exp.Tuple): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.Tuple""""),
        ("args", printISZ(F, o.args, printExp)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printExpSelect(o: Exp.Select): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.Select""""),
        ("receiverOpt", printOption(o.receiverOpt, printExp)),
        ("id", printId(o.id)),
        ("targs", printISZ(F, o.targs, printType)),
        ("attr", printResolvedAttr(o.attr))
      ))
    }

    @pure def printExpInvoke(o: Exp.Invoke): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.Invoke""""),
        ("receiverOpt", printOption(o.receiverOpt, printExp)),
        ("id", printId(o.id)),
        ("targs", printISZ(F, o.targs, printType)),
        ("args", printISZ(F, o.args, printExp)),
        ("attr", printResolvedAttr(o.attr))
      ))
    }

    @pure def printExpInvokeNamed(o: Exp.InvokeNamed): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.InvokeNamed""""),
        ("receiverOpt", printOption(o.receiverOpt, printExp)),
        ("id", printId(o.id)),
        ("targs", printISZ(F, o.targs, printType)),
        ("args", printISZ(F, o.args, printNamedArg)),
        ("attr", printResolvedAttr(o.attr))
      ))
    }

    @pure def printExpIf(o: Exp.If): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.If""""),
        ("cond", printExp(o.cond)),
        ("thenExp", printExp(o.thenExp)),
        ("elseExp", printExp(o.elseExp)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printExpFun(o: Exp.Fun): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.Fun""""),
        ("params", printISZ(F, o.params, printParam)),
        ("exp", printExp(o.exp)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printExpForYield(o: Exp.ForYield): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.ForYield""""),
        ("enumGens", printISZ(F, o.enumGens, printEnumGenFor)),
        ("exp", printExp(o.exp)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printExpQuant(o: Exp.Quant): ST = {
      return printObject(ISZ(
        ("type", st""""Exp.Quant""""),
        ("isForall", printB(o.isForall)),
        ("varFragments", printISZ(F, o.varFragments, printVarFragment)),
        ("exp", printExp(o.exp)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printNamedArg(o: NamedArg): ST = {
      return printObject(ISZ(
        ("type", st""""NamedArg""""),
        ("id", printId(o.id)),
        ("arg", printExp(o.arg))
      ))
    }

    @pure def printVarFragment(o: VarFragment): ST = {
      return printObject(ISZ(
        ("type", st""""VarFragment""""),
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
        ("type", st""""Domain.Type""""),
        ("tipe", printType(o.tipe)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printDomainRange(o: Domain.Range): ST = {
      return printObject(ISZ(
        ("type", st""""Domain.Range""""),
        ("lo", printExp(o.lo)),
        ("loExact", printB(o.loExact)),
        ("hi", printExp(o.hi)),
        ("hiExact", printB(o.hiExact)),
        ("attr", printTypedAttr(o.attr))
      ))
    }

    @pure def printId(o: Id): ST = {
      return printObject(ISZ(
        ("type", st""""Id""""),
        ("value", printString(o.value)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printName(o: Name): ST = {
      return printObject(ISZ(
        ("type", st""""Name""""),
        ("ids", printISZ(F, o.ids, printId)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printBody(o: Body): ST = {
      return printObject(ISZ(
        ("type", st""""Body""""),
        ("stmts", printISZ(F, o.stmts, printStmt))
      ))
    }

    @pure def printAbstractDatatypeParam(o: AbstractDatatypeParam): ST = {
      return printObject(ISZ(
        ("type", st""""AbstractDatatypeParam""""),
        ("isHidden", printB(o.isHidden)),
        ("isPure", printB(o.isPure)),
        ("id", printId(o.id)),
        ("tipe", printType(o.tipe))
      ))
    }

    @pure def printMethodSig(o: MethodSig): ST = {
      return printObject(ISZ(
        ("type", st""""MethodSig""""),
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
        ("type", st""""Param""""),
        ("mod", printParamMod(o.mod)),
        ("id", printId(o.id)),
        ("tipe", printType(o.tipe))
      ))
    }

    @pure def printTypeParam(o: TypeParam): ST = {
      return printObject(ISZ(
        ("type", st""""TypeParam""""),
        ("id", printId(o.id))
      ))
    }

    @pure def printContract(o: Contract): ST = {
      return printObject(ISZ(
        ("type", st""""Contract""""),
        ("reads", printISZ(F, o.reads, printExp)),
        ("requires", printISZ(F, o.requires, printContractExp)),
        ("modifies", printISZ(F, o.modifies, printExp)),
        ("ensures", printISZ(F, o.ensures, printContractExp)),
        ("subs", printISZ(F, o.subs, printSubContract))
      ))
    }

    @pure def printSubContract(o: SubContract): ST = {
      return printObject(ISZ(
        ("type", st""""SubContract""""),
        ("id", printId(o.id)),
        ("params", printISZ(F, o.params, printSubContractParam)),
        ("contract", printContract(o.contract))
      ))
    }

    @pure def printSubContractParam(o: SubContractParam): ST = {
      return printObject(ISZ(
        ("type", st""""SubContractParam""""),
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
        ("type", st""""WhereDef.Val""""),
        ("id", printId(o.id)),
        ("tipe", printType(o.tipe)),
        ("exp", printExp(o.exp))
      ))
    }

    @pure def printWhereDefDef(o: WhereDef.Def): ST = {
      return printObject(ISZ(
        ("type", st""""WhereDef.Def""""),
        ("id", printId(o.id)),
        ("params", printISZ(F, o.params, printParam)),
        ("rTipe", printType(o.rTipe)),
        ("defs", printISZ(F, o.defs, printSpecDef))
      ))
    }

    @pure def printSpecDef(o: SpecDef): ST = {
      return printObject(ISZ(
        ("type", st""""SpecDef""""),
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
        ("type", st""""ProofStep.Basic""""),
        ("step", printExpLitZ(o.step)),
        ("exp", printExp(o.exp)),
        ("just", printJust(o.just))
      ))
    }

    @pure def printProofStepSubProof(o: ProofStep.SubProof): ST = {
      return printObject(ISZ(
        ("type", st""""ProofStep.SubProof""""),
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
        ("type", st""""AssumeProofStep.Regular""""),
        ("step", printExpLitZ(o.step)),
        ("exp", printExp(o.exp))
      ))
    }

    @pure def printAssumeProofStepForallIntroAps(o: AssumeProofStep.ForallIntroAps): ST = {
      return printObject(ISZ(
        ("type", st""""AssumeProofStep.ForallIntroAps""""),
        ("step", printExpLitZ(o.step)),
        ("varFragments", printISZ(F, o.varFragments, printVarFragment))
      ))
    }

    @pure def printAssumeProofStepExistsElimAps(o: AssumeProofStep.ExistsElimAps): ST = {
      return printObject(ISZ(
        ("type", st""""AssumeProofStep.ExistsElimAps""""),
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
        ("type", st""""Just.Premise""""),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustAndIntro(o: Just.AndIntro): ST = {
      return printObject(ISZ(
        ("type", st""""Just.AndIntro""""),
        ("steps", printISZ(F, o.steps, printExpLitZ)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustAndElim(o: Just.AndElim): ST = {
      return printObject(ISZ(
        ("type", st""""Just.AndElim""""),
        ("is1", printB(o.is1)),
        ("andStep", printExpLitZ(o.andStep)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustOrIntro(o: Just.OrIntro): ST = {
      return printObject(ISZ(
        ("type", st""""Just.OrIntro""""),
        ("is1", printB(o.is1)),
        ("step", printExpLitZ(o.step)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustOrElim(o: Just.OrElim): ST = {
      return printObject(ISZ(
        ("type", st""""Just.OrElim""""),
        ("orStep", printExpLitZ(o.orStep)),
        ("subProofSteps", printISZ(F, o.subProofSteps, printExpLitZ)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustImplyIntro(o: Just.ImplyIntro): ST = {
      return printObject(ISZ(
        ("type", st""""Just.ImplyIntro""""),
        ("subProofStep", printExpLitZ(o.subProofStep)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustImplyElim(o: Just.ImplyElim): ST = {
      return printObject(ISZ(
        ("type", st""""Just.ImplyElim""""),
        ("implyStep", printExpLitZ(o.implyStep)),
        ("steps", printISZ(F, o.steps, printExpLitZ)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustNegIntro(o: Just.NegIntro): ST = {
      return printObject(ISZ(
        ("type", st""""Just.NegIntro""""),
        ("subProofStep", printExpLitZ(o.subProofStep)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustNegElim(o: Just.NegElim): ST = {
      return printObject(ISZ(
        ("type", st""""Just.NegElim""""),
        ("step", printExpLitZ(o.step)),
        ("negStep", printExpLitZ(o.negStep)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustBottomElim(o: Just.BottomElim): ST = {
      return printObject(ISZ(
        ("type", st""""Just.BottomElim""""),
        ("subProofStep", printExpLitZ(o.subProofStep)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustPbc(o: Just.Pbc): ST = {
      return printObject(ISZ(
        ("type", st""""Just.Pbc""""),
        ("subProofStep", printExpLitZ(o.subProofStep)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustForallIntro(o: Just.ForallIntro): ST = {
      return printObject(ISZ(
        ("type", st""""Just.ForallIntro""""),
        ("subProofStep", printExpLitZ(o.subProofStep)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustForallElim(o: Just.ForallElim): ST = {
      return printObject(ISZ(
        ("type", st""""Just.ForallElim""""),
        ("forallStep", printExpLitZ(o.forallStep)),
        ("args", printISZ(F, o.args, printExp)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustExistsIntro(o: Just.ExistsIntro): ST = {
      return printObject(ISZ(
        ("type", st""""Just.ExistsIntro""""),
        ("existsStep", printExpLitZ(o.existsStep)),
        ("args", printISZ(F, o.args, printExp)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustExistsElim(o: Just.ExistsElim): ST = {
      return printObject(ISZ(
        ("type", st""""Just.ExistsElim""""),
        ("existsStep", printExpLitZ(o.existsStep)),
        ("subProofStep", printExpLitZ(o.subProofStep)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustFact(o: Just.Fact): ST = {
      return printObject(ISZ(
        ("type", st""""Just.Fact""""),
        ("name", printName(o.name)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustInvariant(o: Just.Invariant): ST = {
      return printObject(ISZ(
        ("type", st""""Just.Invariant""""),
        ("nameOpt", printOption(o.nameOpt, printName)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustSubst(o: Just.Subst): ST = {
      return printObject(ISZ(
        ("type", st""""Just.Subst""""),
        ("isRight", printB(o.isRight)),
        ("eqStep", printExpLitZ(o.eqStep)),
        ("step", printExpLitZ(o.step)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustAuto(o: Just.Auto): ST = {
      return printObject(ISZ(
        ("type", st""""Just.Auto""""),
        ("isAlgebra", printB(o.isAlgebra)),
        ("steps", printISZ(F, o.steps, printExpLitZ)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printJustCoq(o: Just.Coq): ST = {
      return printObject(ISZ(
        ("type", st""""Just.Coq""""),
        ("path", printExpLitString(o.path)),
        ("steps", printISZ(F, o.steps, printExpLitZ)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printTruthTableRow(o: TruthTable.Row): ST = {
      return printObject(ISZ(
        ("type", st""""TruthTable.Row""""),
        ("assignment", printTruthTableAssignment(o.assignment)),
        ("separator", printPosInfo(o.separator)),
        ("values", printTruthTableAssignment(o.values))
      ))
    }

    @pure def printTruthTableAssignment(o: TruthTable.Assignment): ST = {
      return printObject(ISZ(
        ("type", st""""TruthTable.Assignment""""),
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
        ("type", st""""TruthTable.Conclusion.Validity""""),
        ("isValid", printB(o.isValid)),
        ("assignments", printISZ(F, o.assignments, printTruthTableAssignment)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printTruthTableConclusionTautology(o: TruthTable.Conclusion.Tautology): ST = {
      return printObject(ISZ(
        ("type", st""""TruthTable.Conclusion.Tautology""""),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printTruthTableConclusionContradictory(o: TruthTable.Conclusion.Contradictory): ST = {
      return printObject(ISZ(
        ("type", st""""TruthTable.Conclusion.Contradictory""""),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printTruthTableConclusionContingent(o: TruthTable.Conclusion.Contingent): ST = {
      return printObject(ISZ(
        ("type", st""""TruthTable.Conclusion.Contingent""""),
        ("trueAssignments", printISZ(F, o.trueAssignments, printTruthTableAssignment)),
        ("falseAssignments", printISZ(F, o.falseAssignments, printTruthTableAssignment)),
        ("attr", printAttr(o.attr))
      ))
    }

    @pure def printTyped(o: Typed): ST = {
      o match {
        case o: Typed.Name => return printTypedName(o)
        case o: Typed.Tuple => return printTypedTuple(o)
        case o: Typed.Fun => return printTypedFun(o)
      }
    }

    @pure def printTypedName(o: Typed.Name): ST = {
      return printObject(ISZ(
        ("type", st""""Typed.Name""""),
        ("ids", printISZ(T, o.ids, printString)),
        ("args", printISZ(F, o.args, printTyped)),
        ("posOpt", printOption(o.posOpt, printPosInfo))
      ))
    }

    @pure def printTypedTuple(o: Typed.Tuple): ST = {
      return printObject(ISZ(
        ("type", st""""Typed.Tuple""""),
        ("args", printISZ(F, o.args, printTyped)),
        ("posOpt", printOption(o.posOpt, printPosInfo))
      ))
    }

    @pure def printTypedFun(o: Typed.Fun): ST = {
      return printObject(ISZ(
        ("type", st""""Typed.Fun""""),
        ("args", printISZ(F, o.args, printTyped)),
        ("ret", printTyped(o.ret)),
        ("posOpt", printOption(o.posOpt, printPosInfo))
      ))
    }

    @pure def printAttr(o: Attr): ST = {
      return printObject(ISZ(
        ("type", st""""Attr""""),
        ("posOpt", printOption(o.posOpt, printPosInfo))
      ))
    }

    @pure def printTypedAttr(o: TypedAttr): ST = {
      return printObject(ISZ(
        ("type", st""""TypedAttr""""),
        ("posOpt", printOption(o.posOpt, printPosInfo)),
        ("typedOpt", printOption(o.typedOpt, printTyped))
      ))
    }

    @pure def printResolvedAttr(o: ResolvedAttr): ST = {
      return printObject(ISZ(
        ("type", st""""ResolvedAttr""""),
        ("posOpt", printOption(o.posOpt, printPosInfo)),
        ("resOpt", printOption(o.resOpt, printResolvedInfo)),
        ("typedOpt", printOption(o.typedOpt, printTyped))
      ))
    }

    @pure def printResolvedInfo(o: ResolvedInfo): ST = {
      return printObject(ISZ(
        ("type", st""""ResolvedInfo""""),
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
        ("type", st""""PosInfo""""),
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
      val t = parser.parseObjectTypes(ISZ("TopUnit.Program", "TopUnit.SequentUnit", "TopUnit.TruthTableUnit"))
      t.native match {
        case "TopUnit.Program" => val r = parseTopUnitProgramT(T); return r
        case "TopUnit.SequentUnit" => val r = parseTopUnitSequentUnitT(T); return r
        case "TopUnit.TruthTableUnit" => val r = parseTopUnitTruthTableUnitT(T); return r
        case _ => halt(parser.errorMessage)
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
      val t = parser.parseObjectTypes(ISZ("Stmt.Import", "Stmt.Var", "Stmt.VarPattern", "Stmt.SpecVar", "Stmt.Method", "Stmt.ExtMethod", "Stmt.SpecMethod", "Stmt.Enum", "Stmt.SubZ", "Stmt.Object", "Stmt.Sig", "Stmt.AbstractDatatype", "Stmt.Rich", "Stmt.TypeAlias", "Stmt.Assign", "Stmt.AssignUp", "Stmt.AssignPattern", "Stmt.Block", "Stmt.If", "Stmt.Match", "Stmt.While", "Stmt.DoWhile", "Stmt.For", "Stmt.Return", "Stmt.LStmt", "Stmt.Expr"))
      t.native match {
        case "Stmt.Import" => val r = parseStmtImportT(T); return r
        case "Stmt.Var" => val r = parseStmtVarT(T); return r
        case "Stmt.VarPattern" => val r = parseStmtVarPatternT(T); return r
        case "Stmt.SpecVar" => val r = parseStmtSpecVarT(T); return r
        case "Stmt.Method" => val r = parseStmtMethodT(T); return r
        case "Stmt.ExtMethod" => val r = parseStmtExtMethodT(T); return r
        case "Stmt.SpecMethod" => val r = parseStmtSpecMethodT(T); return r
        case "Stmt.Enum" => val r = parseStmtEnumT(T); return r
        case "Stmt.SubZ" => val r = parseStmtSubZT(T); return r
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
        case _ => halt(parser.errorMessage)
      }
    }

    def parseAssignExp(): AssignExp = {
      val t = parser.parseObjectTypes(ISZ("Stmt.Block", "Stmt.If", "Stmt.Match", "Stmt.Expr"))
      t.native match {
        case "Stmt.Block" => val r = parseStmtBlockT(T); return r
        case "Stmt.If" => val r = parseStmtIfT(T); return r
        case "Stmt.Match" => val r = parseStmtMatchT(T); return r
        case "Stmt.Expr" => val r = parseStmtExprT(T); return r
        case _ => halt(parser.errorMessage)
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
      parser.parseObjectNext()
      s.native match {
        case "Impure" => return Purity.Impure
        case "Pure" => return Purity.Pure
        case "Memoize" => return Purity.Memoize
        case _ => halt(parser.errorMessage)
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
      val t = parser.parseObjectTypes(ISZ("Stmt.Import.MultiSelector", "Stmt.Import.WildcardSelector"))
      t.native match {
        case "Stmt.Import.MultiSelector" => val r = parseStmtImportMultiSelectorT(T); return r
        case "Stmt.Import.WildcardSelector" => val r = parseStmtImportWildcardSelectorT(T); return r
        case _ => halt(parser.errorMessage)
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
      parser.parseObjectKey("init")
      val init = parseAssignExp()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.VarPattern(isVal, pattern, init, attr)
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
      parser.parseObjectKey("isHelper")
      val isHelper = parser.parseB()
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
      return Stmt.Method(purity, hasOverride, isHelper, sig, contract, bodyOpt, attr)
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

    def parseStmtSubZ(): Stmt.SubZ = {
      val r = parseStmtSubZT(F)
      return r
    }

    def parseStmtSubZT(typeParsed: B): Stmt.SubZ = {
      if (!typeParsed) {
        parser.parseObjectType("Stmt.SubZ")
      }
      parser.parseObjectKey("id")
      val id = parseId()
      parser.parseObjectNext()
      parser.parseObjectKey("isSigned")
      val isSigned = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("isBitVector")
      val isBitVector = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("isWrapped")
      val isWrapped = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("hasMin")
      val hasMin = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("hasMax")
      val hasMax = parser.parseB()
      parser.parseObjectNext()
      parser.parseObjectKey("bitWidth")
      val bitWidth = parser.parseZ()
      parser.parseObjectNext()
      parser.parseObjectKey("min")
      val min = parser.parseZ()
      parser.parseObjectNext()
      parser.parseObjectKey("max")
      val max = parser.parseZ()
      parser.parseObjectNext()
      parser.parseObjectKey("index")
      val index = parser.parseZ()
      parser.parseObjectNext()
      parser.parseObjectKey("attr")
      val attr = parseAttr()
      parser.parseObjectNext()
      return Stmt.SubZ(id, isSigned, isBitVector, isWrapped, hasMin, hasMax, bitWidth, min, max, index, attr)
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
      parser.parseObjectKey("isExt")
      val isExt = parser.parseB()
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
      return Stmt.Sig(isImmutable, isExt, id, typeParams, parents, selfTypeOpt, stmts, attr)
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
      val t = parser.parseObjectTypes(ISZ("LClause.Invariants", "LClause.Facts", "LClause.Theorems", "LClause.Sequent", "LClause.Proof"))
      t.native match {
        case "LClause.Invariants" => val r = parseLClauseInvariantsT(T); return r
        case "LClause.Facts" => val r = parseLClauseFactsT(T); return r
        case "LClause.Theorems" => val r = parseLClauseTheoremsT(T); return r
        case "LClause.Sequent" => val r = parseLClauseSequentT(T); return r
        case "LClause.Proof" => val r = parseLClauseProofT(T); return r
        case _ => halt(parser.errorMessage)
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
      val t = parser.parseObjectTypes(ISZ("EnumGen.Range.Expr", "EnumGen.Range.Indices", "EnumGen.Range.Step"))
      t.native match {
        case "EnumGen.Range.Expr" => val r = parseEnumGenRangeExprT(T); return r
        case "EnumGen.Range.Indices" => val r = parseEnumGenRangeIndicesT(T); return r
        case "EnumGen.Range.Step" => val r = parseEnumGenRangeStepT(T); return r
        case _ => halt(parser.errorMessage)
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
      val t = parser.parseObjectTypes(ISZ("Type.Named", "Type.Fun", "Type.Tuple"))
      t.native match {
        case "Type.Named" => val r = parseTypeNamedT(T); return r
        case "Type.Fun" => val r = parseTypeFunT(T); return r
        case "Type.Tuple" => val r = parseTypeTupleT(T); return r
        case _ => halt(parser.errorMessage)
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
      val t = parser.parseObjectTypes(ISZ("Pattern.Literal", "Pattern.Ref", "Pattern.Variable", "Pattern.Wildcard", "Pattern.SeqWildcard", "Pattern.Structure"))
      t.native match {
        case "Pattern.Literal" => val r = parsePatternLiteralT(T); return r
        case "Pattern.Ref" => val r = parsePatternRefT(T); return r
        case "Pattern.Variable" => val r = parsePatternVariableT(T); return r
        case "Pattern.Wildcard" => val r = parsePatternWildcardT(T); return r
        case "Pattern.SeqWildcard" => val r = parsePatternSeqWildcardT(T); return r
        case "Pattern.Structure" => val r = parsePatternStructureT(T); return r
        case _ => halt(parser.errorMessage)
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
      val t = parser.parseObjectTypes(ISZ("Exp.LitB", "Exp.LitC", "Exp.LitZ", "Exp.LitF32", "Exp.LitF64", "Exp.LitR", "Exp.LitBv", "Exp.LitString", "Exp.StringInterpolate", "Exp.This", "Exp.Super", "Exp.Unary", "Exp.Binary", "Exp.Ident", "Exp.Eta", "Exp.Tuple", "Exp.Select", "Exp.Invoke", "Exp.InvokeNamed", "Exp.If", "Exp.Fun", "Exp.ForYield", "Exp.Quant"))
      t.native match {
        case "Exp.LitB" => val r = parseExpLitBT(T); return r
        case "Exp.LitC" => val r = parseExpLitCT(T); return r
        case "Exp.LitZ" => val r = parseExpLitZT(T); return r
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
        case _ => halt(parser.errorMessage)
      }
    }

    def parseLit(): Lit = {
      val t = parser.parseObjectTypes(ISZ("Exp.LitB", "Exp.LitC", "Exp.LitZ", "Exp.LitF32", "Exp.LitF64", "Exp.LitR", "Exp.LitBv", "Exp.LitString"))
      t.native match {
        case "Exp.LitB" => val r = parseExpLitBT(T); return r
        case "Exp.LitC" => val r = parseExpLitCT(T); return r
        case "Exp.LitZ" => val r = parseExpLitZT(T); return r
        case "Exp.LitF32" => val r = parseExpLitF32T(T); return r
        case "Exp.LitF64" => val r = parseExpLitF64T(T); return r
        case "Exp.LitR" => val r = parseExpLitRT(T); return r
        case "Exp.LitBv" => val r = parseExpLitBvT(T); return r
        case "Exp.LitString" => val r = parseExpLitStringT(T); return r
        case _ => halt(parser.errorMessage)
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
      parser.parseObjectNext()
      s.native match {
        case "Not" => return Exp.UnaryOp.Not
        case "Plus" => return Exp.UnaryOp.Plus
        case "Minus" => return Exp.UnaryOp.Minus
        case "Complement" => return Exp.UnaryOp.Complement
        case _ => halt(parser.errorMessage)
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
      parser.parseObjectNext()
      s.native match {
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
        case _ => halt(parser.errorMessage)
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
      val t = parser.parseObjectTypes(ISZ("Domain.Type", "Domain.Range"))
      t.native match {
        case "Domain.Type" => val r = parseDomainTypeT(T); return r
        case "Domain.Range" => val r = parseDomainRangeT(T); return r
        case _ => halt(parser.errorMessage)
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
      parser.parseObjectNext()
      s.native match {
        case "NoMod" => return ParamMod.NoMod
        case "Pure" => return ParamMod.Pure
        case "Hidden" => return ParamMod.Hidden
        case _ => halt(parser.errorMessage)
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
      return TypeParam(id)
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
      val t = parser.parseObjectTypes(ISZ("WhereDef.Val", "WhereDef.Def"))
      t.native match {
        case "WhereDef.Val" => val r = parseWhereDefValT(T); return r
        case "WhereDef.Def" => val r = parseWhereDefDefT(T); return r
        case _ => halt(parser.errorMessage)
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
      val t = parser.parseObjectTypes(ISZ("ProofStep.Basic", "ProofStep.SubProof"))
      t.native match {
        case "ProofStep.Basic" => val r = parseProofStepBasicT(T); return r
        case "ProofStep.SubProof" => val r = parseProofStepSubProofT(T); return r
        case _ => halt(parser.errorMessage)
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
      val t = parser.parseObjectTypes(ISZ("AssumeProofStep.Regular", "AssumeProofStep.ForallIntroAps", "AssumeProofStep.ExistsElimAps"))
      t.native match {
        case "AssumeProofStep.Regular" => val r = parseAssumeProofStepRegularT(T); return r
        case "AssumeProofStep.ForallIntroAps" => val r = parseAssumeProofStepForallIntroApsT(T); return r
        case "AssumeProofStep.ExistsElimAps" => val r = parseAssumeProofStepExistsElimApsT(T); return r
        case _ => halt(parser.errorMessage)
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
      val t = parser.parseObjectTypes(ISZ("Just.Premise", "Just.AndIntro", "Just.AndElim", "Just.OrIntro", "Just.OrElim", "Just.ImplyIntro", "Just.ImplyElim", "Just.NegIntro", "Just.NegElim", "Just.BottomElim", "Just.Pbc", "Just.ForallIntro", "Just.ForallElim", "Just.ExistsIntro", "Just.ExistsElim", "Just.Fact", "Just.Invariant", "Just.Subst", "Just.Auto", "Just.Coq"))
      t.native match {
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
        case _ => halt(parser.errorMessage)
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
      val t = parser.parseObjectTypes(ISZ("TruthTable.Conclusion.Validity", "TruthTable.Conclusion.Tautology", "TruthTable.Conclusion.Contradictory", "TruthTable.Conclusion.Contingent"))
      t.native match {
        case "TruthTable.Conclusion.Validity" => val r = parseTruthTableConclusionValidityT(T); return r
        case "TruthTable.Conclusion.Tautology" => val r = parseTruthTableConclusionTautologyT(T); return r
        case "TruthTable.Conclusion.Contradictory" => val r = parseTruthTableConclusionContradictoryT(T); return r
        case "TruthTable.Conclusion.Contingent" => val r = parseTruthTableConclusionContingentT(T); return r
        case _ => halt(parser.errorMessage)
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

    def parseTyped(): Typed = {
      val t = parser.parseObjectTypes(ISZ("Typed.Name", "Typed.Tuple", "Typed.Fun"))
      t.native match {
        case "Typed.Name" => val r = parseTypedNameT(T); return r
        case "Typed.Tuple" => val r = parseTypedTupleT(T); return r
        case "Typed.Fun" => val r = parseTypedFunT(T); return r
        case _ => halt(parser.errorMessage)
      }
    }

    def parseTypedName(): Typed.Name = {
      val r = parseTypedNameT(F)
      return r
    }

    def parseTypedNameT(typeParsed: B): Typed.Name = {
      if (!typeParsed) {
        parser.parseObjectType("Typed.Name")
      }
      parser.parseObjectKey("ids")
      val ids = parser.parseISZ(parser.parseString _)
      parser.parseObjectNext()
      parser.parseObjectKey("args")
      val args = parser.parseISZ(parseTyped _)
      parser.parseObjectNext()
      parser.parseObjectKey("posOpt")
      val posOpt = parser.parseOption(parsePosInfo _)
      parser.parseObjectNext()
      return Typed.Name(ids, args, posOpt)
    }

    def parseTypedTuple(): Typed.Tuple = {
      val r = parseTypedTupleT(F)
      return r
    }

    def parseTypedTupleT(typeParsed: B): Typed.Tuple = {
      if (!typeParsed) {
        parser.parseObjectType("Typed.Tuple")
      }
      parser.parseObjectKey("args")
      val args = parser.parseISZ(parseTyped _)
      parser.parseObjectNext()
      parser.parseObjectKey("posOpt")
      val posOpt = parser.parseOption(parsePosInfo _)
      parser.parseObjectNext()
      return Typed.Tuple(args, posOpt)
    }

    def parseTypedFun(): Typed.Fun = {
      val r = parseTypedFunT(F)
      return r
    }

    def parseTypedFunT(typeParsed: B): Typed.Fun = {
      if (!typeParsed) {
        parser.parseObjectType("Typed.Fun")
      }
      parser.parseObjectKey("args")
      val args = parser.parseISZ(parseTyped _)
      parser.parseObjectNext()
      parser.parseObjectKey("ret")
      val ret = parseTyped()
      parser.parseObjectNext()
      parser.parseObjectKey("posOpt")
      val posOpt = parser.parseOption(parsePosInfo _)
      parser.parseObjectNext()
      return Typed.Fun(args, ret, posOpt)
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
      parser.parseObjectKey("typedOpt")
      val typedOpt = parser.parseOption(parseTyped _)
      parser.parseObjectNext()
      return TypedAttr(posOpt, typedOpt)
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
      parser.parseObjectKey("typedOpt")
      val typedOpt = parser.parseOption(parseTyped _)
      parser.parseObjectNext()
      return ResolvedAttr(posOpt, resOpt, typedOpt)
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
      parser.parseObjectNext()
      s.native match {
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
        case _ => halt(parser.errorMessage)
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

  def to[T](s: String, f: Parser => T): T = {
    val parser = Parser(s)
    val r = f(parser)
    parser.eof()
    return r
  }

  def fromTopUnit(o: TopUnit, isCompact: B): String = {
    val st = Printer.printTopUnit(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTopUnit(s: String): TopUnit = {
    def fTopUnit(parser: Parser): TopUnit = {
      val r = parser.parseTopUnit()
      return r
    }
    val r = to(s, fTopUnit)
    return r
  }

  def fromTopUnitProgram(o: TopUnit.Program, isCompact: B): String = {
    val st = Printer.printTopUnitProgram(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTopUnitProgram(s: String): TopUnit.Program = {
    def fTopUnitProgram(parser: Parser): TopUnit.Program = {
      val r = parser.parseTopUnitProgram()
      return r
    }
    val r = to(s, fTopUnitProgram)
    return r
  }

  def fromTopUnitSequentUnit(o: TopUnit.SequentUnit, isCompact: B): String = {
    val st = Printer.printTopUnitSequentUnit(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTopUnitSequentUnit(s: String): TopUnit.SequentUnit = {
    def fTopUnitSequentUnit(parser: Parser): TopUnit.SequentUnit = {
      val r = parser.parseTopUnitSequentUnit()
      return r
    }
    val r = to(s, fTopUnitSequentUnit)
    return r
  }

  def fromTopUnitTruthTableUnit(o: TopUnit.TruthTableUnit, isCompact: B): String = {
    val st = Printer.printTopUnitTruthTableUnit(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTopUnitTruthTableUnit(s: String): TopUnit.TruthTableUnit = {
    def fTopUnitTruthTableUnit(parser: Parser): TopUnit.TruthTableUnit = {
      val r = parser.parseTopUnitTruthTableUnit()
      return r
    }
    val r = to(s, fTopUnitTruthTableUnit)
    return r
  }

  def fromStmt(o: Stmt, isCompact: B): String = {
    val st = Printer.printStmt(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmt(s: String): Stmt = {
    def fStmt(parser: Parser): Stmt = {
      val r = parser.parseStmt()
      return r
    }
    val r = to(s, fStmt)
    return r
  }

  def fromAssignExp(o: AssignExp, isCompact: B): String = {
    val st = Printer.printAssignExp(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toAssignExp(s: String): AssignExp = {
    def fAssignExp(parser: Parser): AssignExp = {
      val r = parser.parseAssignExp()
      return r
    }
    val r = to(s, fAssignExp)
    return r
  }

  def fromStmtImport(o: Stmt.Import, isCompact: B): String = {
    val st = Printer.printStmtImport(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtImport(s: String): Stmt.Import = {
    def fStmtImport(parser: Parser): Stmt.Import = {
      val r = parser.parseStmtImport()
      return r
    }
    val r = to(s, fStmtImport)
    return r
  }

  def fromStmtImportImporter(o: Stmt.Import.Importer, isCompact: B): String = {
    val st = Printer.printStmtImportImporter(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtImportImporter(s: String): Stmt.Import.Importer = {
    def fStmtImportImporter(parser: Parser): Stmt.Import.Importer = {
      val r = parser.parseStmtImportImporter()
      return r
    }
    val r = to(s, fStmtImportImporter)
    return r
  }

  def fromStmtImportSelector(o: Stmt.Import.Selector, isCompact: B): String = {
    val st = Printer.printStmtImportSelector(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtImportSelector(s: String): Stmt.Import.Selector = {
    def fStmtImportSelector(parser: Parser): Stmt.Import.Selector = {
      val r = parser.parseStmtImportSelector()
      return r
    }
    val r = to(s, fStmtImportSelector)
    return r
  }

  def fromStmtImportMultiSelector(o: Stmt.Import.MultiSelector, isCompact: B): String = {
    val st = Printer.printStmtImportMultiSelector(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtImportMultiSelector(s: String): Stmt.Import.MultiSelector = {
    def fStmtImportMultiSelector(parser: Parser): Stmt.Import.MultiSelector = {
      val r = parser.parseStmtImportMultiSelector()
      return r
    }
    val r = to(s, fStmtImportMultiSelector)
    return r
  }

  def fromStmtImportWildcardSelector(o: Stmt.Import.WildcardSelector, isCompact: B): String = {
    val st = Printer.printStmtImportWildcardSelector(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtImportWildcardSelector(s: String): Stmt.Import.WildcardSelector = {
    def fStmtImportWildcardSelector(parser: Parser): Stmt.Import.WildcardSelector = {
      val r = parser.parseStmtImportWildcardSelector()
      return r
    }
    val r = to(s, fStmtImportWildcardSelector)
    return r
  }

  def fromStmtImportNamedSelector(o: Stmt.Import.NamedSelector, isCompact: B): String = {
    val st = Printer.printStmtImportNamedSelector(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtImportNamedSelector(s: String): Stmt.Import.NamedSelector = {
    def fStmtImportNamedSelector(parser: Parser): Stmt.Import.NamedSelector = {
      val r = parser.parseStmtImportNamedSelector()
      return r
    }
    val r = to(s, fStmtImportNamedSelector)
    return r
  }

  def fromStmtVar(o: Stmt.Var, isCompact: B): String = {
    val st = Printer.printStmtVar(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtVar(s: String): Stmt.Var = {
    def fStmtVar(parser: Parser): Stmt.Var = {
      val r = parser.parseStmtVar()
      return r
    }
    val r = to(s, fStmtVar)
    return r
  }

  def fromStmtVarPattern(o: Stmt.VarPattern, isCompact: B): String = {
    val st = Printer.printStmtVarPattern(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtVarPattern(s: String): Stmt.VarPattern = {
    def fStmtVarPattern(parser: Parser): Stmt.VarPattern = {
      val r = parser.parseStmtVarPattern()
      return r
    }
    val r = to(s, fStmtVarPattern)
    return r
  }

  def fromStmtSpecVar(o: Stmt.SpecVar, isCompact: B): String = {
    val st = Printer.printStmtSpecVar(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtSpecVar(s: String): Stmt.SpecVar = {
    def fStmtSpecVar(parser: Parser): Stmt.SpecVar = {
      val r = parser.parseStmtSpecVar()
      return r
    }
    val r = to(s, fStmtSpecVar)
    return r
  }

  def fromStmtMethod(o: Stmt.Method, isCompact: B): String = {
    val st = Printer.printStmtMethod(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtMethod(s: String): Stmt.Method = {
    def fStmtMethod(parser: Parser): Stmt.Method = {
      val r = parser.parseStmtMethod()
      return r
    }
    val r = to(s, fStmtMethod)
    return r
  }

  def fromStmtExtMethod(o: Stmt.ExtMethod, isCompact: B): String = {
    val st = Printer.printStmtExtMethod(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtExtMethod(s: String): Stmt.ExtMethod = {
    def fStmtExtMethod(parser: Parser): Stmt.ExtMethod = {
      val r = parser.parseStmtExtMethod()
      return r
    }
    val r = to(s, fStmtExtMethod)
    return r
  }

  def fromStmtSpecMethod(o: Stmt.SpecMethod, isCompact: B): String = {
    val st = Printer.printStmtSpecMethod(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtSpecMethod(s: String): Stmt.SpecMethod = {
    def fStmtSpecMethod(parser: Parser): Stmt.SpecMethod = {
      val r = parser.parseStmtSpecMethod()
      return r
    }
    val r = to(s, fStmtSpecMethod)
    return r
  }

  def fromStmtEnum(o: Stmt.Enum, isCompact: B): String = {
    val st = Printer.printStmtEnum(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtEnum(s: String): Stmt.Enum = {
    def fStmtEnum(parser: Parser): Stmt.Enum = {
      val r = parser.parseStmtEnum()
      return r
    }
    val r = to(s, fStmtEnum)
    return r
  }

  def fromStmtSubZ(o: Stmt.SubZ, isCompact: B): String = {
    val st = Printer.printStmtSubZ(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtSubZ(s: String): Stmt.SubZ = {
    def fStmtSubZ(parser: Parser): Stmt.SubZ = {
      val r = parser.parseStmtSubZ()
      return r
    }
    val r = to(s, fStmtSubZ)
    return r
  }

  def fromStmtObject(o: Stmt.Object, isCompact: B): String = {
    val st = Printer.printStmtObject(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtObject(s: String): Stmt.Object = {
    def fStmtObject(parser: Parser): Stmt.Object = {
      val r = parser.parseStmtObject()
      return r
    }
    val r = to(s, fStmtObject)
    return r
  }

  def fromStmtSig(o: Stmt.Sig, isCompact: B): String = {
    val st = Printer.printStmtSig(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtSig(s: String): Stmt.Sig = {
    def fStmtSig(parser: Parser): Stmt.Sig = {
      val r = parser.parseStmtSig()
      return r
    }
    val r = to(s, fStmtSig)
    return r
  }

  def fromStmtAbstractDatatype(o: Stmt.AbstractDatatype, isCompact: B): String = {
    val st = Printer.printStmtAbstractDatatype(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtAbstractDatatype(s: String): Stmt.AbstractDatatype = {
    def fStmtAbstractDatatype(parser: Parser): Stmt.AbstractDatatype = {
      val r = parser.parseStmtAbstractDatatype()
      return r
    }
    val r = to(s, fStmtAbstractDatatype)
    return r
  }

  def fromStmtRich(o: Stmt.Rich, isCompact: B): String = {
    val st = Printer.printStmtRich(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtRich(s: String): Stmt.Rich = {
    def fStmtRich(parser: Parser): Stmt.Rich = {
      val r = parser.parseStmtRich()
      return r
    }
    val r = to(s, fStmtRich)
    return r
  }

  def fromStmtTypeAlias(o: Stmt.TypeAlias, isCompact: B): String = {
    val st = Printer.printStmtTypeAlias(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtTypeAlias(s: String): Stmt.TypeAlias = {
    def fStmtTypeAlias(parser: Parser): Stmt.TypeAlias = {
      val r = parser.parseStmtTypeAlias()
      return r
    }
    val r = to(s, fStmtTypeAlias)
    return r
  }

  def fromStmtAssign(o: Stmt.Assign, isCompact: B): String = {
    val st = Printer.printStmtAssign(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtAssign(s: String): Stmt.Assign = {
    def fStmtAssign(parser: Parser): Stmt.Assign = {
      val r = parser.parseStmtAssign()
      return r
    }
    val r = to(s, fStmtAssign)
    return r
  }

  def fromStmtAssignUp(o: Stmt.AssignUp, isCompact: B): String = {
    val st = Printer.printStmtAssignUp(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtAssignUp(s: String): Stmt.AssignUp = {
    def fStmtAssignUp(parser: Parser): Stmt.AssignUp = {
      val r = parser.parseStmtAssignUp()
      return r
    }
    val r = to(s, fStmtAssignUp)
    return r
  }

  def fromStmtAssignPattern(o: Stmt.AssignPattern, isCompact: B): String = {
    val st = Printer.printStmtAssignPattern(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtAssignPattern(s: String): Stmt.AssignPattern = {
    def fStmtAssignPattern(parser: Parser): Stmt.AssignPattern = {
      val r = parser.parseStmtAssignPattern()
      return r
    }
    val r = to(s, fStmtAssignPattern)
    return r
  }

  def fromStmtBlock(o: Stmt.Block, isCompact: B): String = {
    val st = Printer.printStmtBlock(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtBlock(s: String): Stmt.Block = {
    def fStmtBlock(parser: Parser): Stmt.Block = {
      val r = parser.parseStmtBlock()
      return r
    }
    val r = to(s, fStmtBlock)
    return r
  }

  def fromStmtIf(o: Stmt.If, isCompact: B): String = {
    val st = Printer.printStmtIf(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtIf(s: String): Stmt.If = {
    def fStmtIf(parser: Parser): Stmt.If = {
      val r = parser.parseStmtIf()
      return r
    }
    val r = to(s, fStmtIf)
    return r
  }

  def fromStmtMatch(o: Stmt.Match, isCompact: B): String = {
    val st = Printer.printStmtMatch(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtMatch(s: String): Stmt.Match = {
    def fStmtMatch(parser: Parser): Stmt.Match = {
      val r = parser.parseStmtMatch()
      return r
    }
    val r = to(s, fStmtMatch)
    return r
  }

  def fromStmtWhile(o: Stmt.While, isCompact: B): String = {
    val st = Printer.printStmtWhile(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtWhile(s: String): Stmt.While = {
    def fStmtWhile(parser: Parser): Stmt.While = {
      val r = parser.parseStmtWhile()
      return r
    }
    val r = to(s, fStmtWhile)
    return r
  }

  def fromStmtDoWhile(o: Stmt.DoWhile, isCompact: B): String = {
    val st = Printer.printStmtDoWhile(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtDoWhile(s: String): Stmt.DoWhile = {
    def fStmtDoWhile(parser: Parser): Stmt.DoWhile = {
      val r = parser.parseStmtDoWhile()
      return r
    }
    val r = to(s, fStmtDoWhile)
    return r
  }

  def fromStmtFor(o: Stmt.For, isCompact: B): String = {
    val st = Printer.printStmtFor(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtFor(s: String): Stmt.For = {
    def fStmtFor(parser: Parser): Stmt.For = {
      val r = parser.parseStmtFor()
      return r
    }
    val r = to(s, fStmtFor)
    return r
  }

  def fromStmtReturn(o: Stmt.Return, isCompact: B): String = {
    val st = Printer.printStmtReturn(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtReturn(s: String): Stmt.Return = {
    def fStmtReturn(parser: Parser): Stmt.Return = {
      val r = parser.parseStmtReturn()
      return r
    }
    val r = to(s, fStmtReturn)
    return r
  }

  def fromStmtLStmt(o: Stmt.LStmt, isCompact: B): String = {
    val st = Printer.printStmtLStmt(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtLStmt(s: String): Stmt.LStmt = {
    def fStmtLStmt(parser: Parser): Stmt.LStmt = {
      val r = parser.parseStmtLStmt()
      return r
    }
    val r = to(s, fStmtLStmt)
    return r
  }

  def fromStmtExpr(o: Stmt.Expr, isCompact: B): String = {
    val st = Printer.printStmtExpr(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStmtExpr(s: String): Stmt.Expr = {
    def fStmtExpr(parser: Parser): Stmt.Expr = {
      val r = parser.parseStmtExpr()
      return r
    }
    val r = to(s, fStmtExpr)
    return r
  }

  def fromLClause(o: LClause, isCompact: B): String = {
    val st = Printer.printLClause(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toLClause(s: String): LClause = {
    def fLClause(parser: Parser): LClause = {
      val r = parser.parseLClause()
      return r
    }
    val r = to(s, fLClause)
    return r
  }

  def fromLClauseInvariants(o: LClause.Invariants, isCompact: B): String = {
    val st = Printer.printLClauseInvariants(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toLClauseInvariants(s: String): LClause.Invariants = {
    def fLClauseInvariants(parser: Parser): LClause.Invariants = {
      val r = parser.parseLClauseInvariants()
      return r
    }
    val r = to(s, fLClauseInvariants)
    return r
  }

  def fromLClauseFacts(o: LClause.Facts, isCompact: B): String = {
    val st = Printer.printLClauseFacts(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toLClauseFacts(s: String): LClause.Facts = {
    def fLClauseFacts(parser: Parser): LClause.Facts = {
      val r = parser.parseLClauseFacts()
      return r
    }
    val r = to(s, fLClauseFacts)
    return r
  }

  def fromLClauseFact(o: LClause.Fact, isCompact: B): String = {
    val st = Printer.printLClauseFact(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toLClauseFact(s: String): LClause.Fact = {
    def fLClauseFact(parser: Parser): LClause.Fact = {
      val r = parser.parseLClauseFact()
      return r
    }
    val r = to(s, fLClauseFact)
    return r
  }

  def fromLClauseTheorems(o: LClause.Theorems, isCompact: B): String = {
    val st = Printer.printLClauseTheorems(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toLClauseTheorems(s: String): LClause.Theorems = {
    def fLClauseTheorems(parser: Parser): LClause.Theorems = {
      val r = parser.parseLClauseTheorems()
      return r
    }
    val r = to(s, fLClauseTheorems)
    return r
  }

  def fromLClauseTheorem(o: LClause.Theorem, isCompact: B): String = {
    val st = Printer.printLClauseTheorem(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toLClauseTheorem(s: String): LClause.Theorem = {
    def fLClauseTheorem(parser: Parser): LClause.Theorem = {
      val r = parser.parseLClauseTheorem()
      return r
    }
    val r = to(s, fLClauseTheorem)
    return r
  }

  def fromLClauseSequent(o: LClause.Sequent, isCompact: B): String = {
    val st = Printer.printLClauseSequent(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toLClauseSequent(s: String): LClause.Sequent = {
    def fLClauseSequent(parser: Parser): LClause.Sequent = {
      val r = parser.parseLClauseSequent()
      return r
    }
    val r = to(s, fLClauseSequent)
    return r
  }

  def fromLClauseProof(o: LClause.Proof, isCompact: B): String = {
    val st = Printer.printLClauseProof(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toLClauseProof(s: String): LClause.Proof = {
    def fLClauseProof(parser: Parser): LClause.Proof = {
      val r = parser.parseLClauseProof()
      return r
    }
    val r = to(s, fLClauseProof)
    return r
  }

  def fromContractExp(o: ContractExp, isCompact: B): String = {
    val st = Printer.printContractExp(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toContractExp(s: String): ContractExp = {
    def fContractExp(parser: Parser): ContractExp = {
      val r = parser.parseContractExp()
      return r
    }
    val r = to(s, fContractExp)
    return r
  }

  def fromCase(o: Case, isCompact: B): String = {
    val st = Printer.printCase(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toCase(s: String): Case = {
    def fCase(parser: Parser): Case = {
      val r = parser.parseCase()
      return r
    }
    val r = to(s, fCase)
    return r
  }

  def fromEnumGenRange(o: EnumGen.Range, isCompact: B): String = {
    val st = Printer.printEnumGenRange(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toEnumGenRange(s: String): EnumGen.Range = {
    def fEnumGenRange(parser: Parser): EnumGen.Range = {
      val r = parser.parseEnumGenRange()
      return r
    }
    val r = to(s, fEnumGenRange)
    return r
  }

  def fromEnumGenRangeExpr(o: EnumGen.Range.Expr, isCompact: B): String = {
    val st = Printer.printEnumGenRangeExpr(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toEnumGenRangeExpr(s: String): EnumGen.Range.Expr = {
    def fEnumGenRangeExpr(parser: Parser): EnumGen.Range.Expr = {
      val r = parser.parseEnumGenRangeExpr()
      return r
    }
    val r = to(s, fEnumGenRangeExpr)
    return r
  }

  def fromEnumGenRangeIndices(o: EnumGen.Range.Indices, isCompact: B): String = {
    val st = Printer.printEnumGenRangeIndices(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toEnumGenRangeIndices(s: String): EnumGen.Range.Indices = {
    def fEnumGenRangeIndices(parser: Parser): EnumGen.Range.Indices = {
      val r = parser.parseEnumGenRangeIndices()
      return r
    }
    val r = to(s, fEnumGenRangeIndices)
    return r
  }

  def fromEnumGenRangeStep(o: EnumGen.Range.Step, isCompact: B): String = {
    val st = Printer.printEnumGenRangeStep(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toEnumGenRangeStep(s: String): EnumGen.Range.Step = {
    def fEnumGenRangeStep(parser: Parser): EnumGen.Range.Step = {
      val r = parser.parseEnumGenRangeStep()
      return r
    }
    val r = to(s, fEnumGenRangeStep)
    return r
  }

  def fromEnumGenFor(o: EnumGen.For, isCompact: B): String = {
    val st = Printer.printEnumGenFor(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toEnumGenFor(s: String): EnumGen.For = {
    def fEnumGenFor(parser: Parser): EnumGen.For = {
      val r = parser.parseEnumGenFor()
      return r
    }
    val r = to(s, fEnumGenFor)
    return r
  }

  def fromType(o: Type, isCompact: B): String = {
    val st = Printer.printType(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toType(s: String): Type = {
    def fType(parser: Parser): Type = {
      val r = parser.parseType()
      return r
    }
    val r = to(s, fType)
    return r
  }

  def fromTypeNamed(o: Type.Named, isCompact: B): String = {
    val st = Printer.printTypeNamed(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTypeNamed(s: String): Type.Named = {
    def fTypeNamed(parser: Parser): Type.Named = {
      val r = parser.parseTypeNamed()
      return r
    }
    val r = to(s, fTypeNamed)
    return r
  }

  def fromTypeFun(o: Type.Fun, isCompact: B): String = {
    val st = Printer.printTypeFun(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTypeFun(s: String): Type.Fun = {
    def fTypeFun(parser: Parser): Type.Fun = {
      val r = parser.parseTypeFun()
      return r
    }
    val r = to(s, fTypeFun)
    return r
  }

  def fromTypeTuple(o: Type.Tuple, isCompact: B): String = {
    val st = Printer.printTypeTuple(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTypeTuple(s: String): Type.Tuple = {
    def fTypeTuple(parser: Parser): Type.Tuple = {
      val r = parser.parseTypeTuple()
      return r
    }
    val r = to(s, fTypeTuple)
    return r
  }

  def fromPattern(o: Pattern, isCompact: B): String = {
    val st = Printer.printPattern(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPattern(s: String): Pattern = {
    def fPattern(parser: Parser): Pattern = {
      val r = parser.parsePattern()
      return r
    }
    val r = to(s, fPattern)
    return r
  }

  def fromPatternLiteral(o: Pattern.Literal, isCompact: B): String = {
    val st = Printer.printPatternLiteral(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPatternLiteral(s: String): Pattern.Literal = {
    def fPatternLiteral(parser: Parser): Pattern.Literal = {
      val r = parser.parsePatternLiteral()
      return r
    }
    val r = to(s, fPatternLiteral)
    return r
  }

  def fromPatternRef(o: Pattern.Ref, isCompact: B): String = {
    val st = Printer.printPatternRef(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPatternRef(s: String): Pattern.Ref = {
    def fPatternRef(parser: Parser): Pattern.Ref = {
      val r = parser.parsePatternRef()
      return r
    }
    val r = to(s, fPatternRef)
    return r
  }

  def fromPatternVariable(o: Pattern.Variable, isCompact: B): String = {
    val st = Printer.printPatternVariable(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPatternVariable(s: String): Pattern.Variable = {
    def fPatternVariable(parser: Parser): Pattern.Variable = {
      val r = parser.parsePatternVariable()
      return r
    }
    val r = to(s, fPatternVariable)
    return r
  }

  def fromPatternWildcard(o: Pattern.Wildcard, isCompact: B): String = {
    val st = Printer.printPatternWildcard(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPatternWildcard(s: String): Pattern.Wildcard = {
    def fPatternWildcard(parser: Parser): Pattern.Wildcard = {
      val r = parser.parsePatternWildcard()
      return r
    }
    val r = to(s, fPatternWildcard)
    return r
  }

  def fromPatternSeqWildcard(o: Pattern.SeqWildcard, isCompact: B): String = {
    val st = Printer.printPatternSeqWildcard(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPatternSeqWildcard(s: String): Pattern.SeqWildcard = {
    def fPatternSeqWildcard(parser: Parser): Pattern.SeqWildcard = {
      val r = parser.parsePatternSeqWildcard()
      return r
    }
    val r = to(s, fPatternSeqWildcard)
    return r
  }

  def fromPatternStructure(o: Pattern.Structure, isCompact: B): String = {
    val st = Printer.printPatternStructure(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPatternStructure(s: String): Pattern.Structure = {
    def fPatternStructure(parser: Parser): Pattern.Structure = {
      val r = parser.parsePatternStructure()
      return r
    }
    val r = to(s, fPatternStructure)
    return r
  }

  def fromExp(o: Exp, isCompact: B): String = {
    val st = Printer.printExp(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExp(s: String): Exp = {
    def fExp(parser: Parser): Exp = {
      val r = parser.parseExp()
      return r
    }
    val r = to(s, fExp)
    return r
  }

  def fromLit(o: Lit, isCompact: B): String = {
    val st = Printer.printLit(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toLit(s: String): Lit = {
    def fLit(parser: Parser): Lit = {
      val r = parser.parseLit()
      return r
    }
    val r = to(s, fLit)
    return r
  }

  def fromExpLitB(o: Exp.LitB, isCompact: B): String = {
    val st = Printer.printExpLitB(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpLitB(s: String): Exp.LitB = {
    def fExpLitB(parser: Parser): Exp.LitB = {
      val r = parser.parseExpLitB()
      return r
    }
    val r = to(s, fExpLitB)
    return r
  }

  def fromExpLitC(o: Exp.LitC, isCompact: B): String = {
    val st = Printer.printExpLitC(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpLitC(s: String): Exp.LitC = {
    def fExpLitC(parser: Parser): Exp.LitC = {
      val r = parser.parseExpLitC()
      return r
    }
    val r = to(s, fExpLitC)
    return r
  }

  def fromExpLitZ(o: Exp.LitZ, isCompact: B): String = {
    val st = Printer.printExpLitZ(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpLitZ(s: String): Exp.LitZ = {
    def fExpLitZ(parser: Parser): Exp.LitZ = {
      val r = parser.parseExpLitZ()
      return r
    }
    val r = to(s, fExpLitZ)
    return r
  }

  def fromExpLitF32(o: Exp.LitF32, isCompact: B): String = {
    val st = Printer.printExpLitF32(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpLitF32(s: String): Exp.LitF32 = {
    def fExpLitF32(parser: Parser): Exp.LitF32 = {
      val r = parser.parseExpLitF32()
      return r
    }
    val r = to(s, fExpLitF32)
    return r
  }

  def fromExpLitF64(o: Exp.LitF64, isCompact: B): String = {
    val st = Printer.printExpLitF64(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpLitF64(s: String): Exp.LitF64 = {
    def fExpLitF64(parser: Parser): Exp.LitF64 = {
      val r = parser.parseExpLitF64()
      return r
    }
    val r = to(s, fExpLitF64)
    return r
  }

  def fromExpLitR(o: Exp.LitR, isCompact: B): String = {
    val st = Printer.printExpLitR(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpLitR(s: String): Exp.LitR = {
    def fExpLitR(parser: Parser): Exp.LitR = {
      val r = parser.parseExpLitR()
      return r
    }
    val r = to(s, fExpLitR)
    return r
  }

  def fromExpLitBv(o: Exp.LitBv, isCompact: B): String = {
    val st = Printer.printExpLitBv(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpLitBv(s: String): Exp.LitBv = {
    def fExpLitBv(parser: Parser): Exp.LitBv = {
      val r = parser.parseExpLitBv()
      return r
    }
    val r = to(s, fExpLitBv)
    return r
  }

  def fromExpLitString(o: Exp.LitString, isCompact: B): String = {
    val st = Printer.printExpLitString(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpLitString(s: String): Exp.LitString = {
    def fExpLitString(parser: Parser): Exp.LitString = {
      val r = parser.parseExpLitString()
      return r
    }
    val r = to(s, fExpLitString)
    return r
  }

  def fromExpStringInterpolate(o: Exp.StringInterpolate, isCompact: B): String = {
    val st = Printer.printExpStringInterpolate(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpStringInterpolate(s: String): Exp.StringInterpolate = {
    def fExpStringInterpolate(parser: Parser): Exp.StringInterpolate = {
      val r = parser.parseExpStringInterpolate()
      return r
    }
    val r = to(s, fExpStringInterpolate)
    return r
  }

  def fromExpThis(o: Exp.This, isCompact: B): String = {
    val st = Printer.printExpThis(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpThis(s: String): Exp.This = {
    def fExpThis(parser: Parser): Exp.This = {
      val r = parser.parseExpThis()
      return r
    }
    val r = to(s, fExpThis)
    return r
  }

  def fromExpSuper(o: Exp.Super, isCompact: B): String = {
    val st = Printer.printExpSuper(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpSuper(s: String): Exp.Super = {
    def fExpSuper(parser: Parser): Exp.Super = {
      val r = parser.parseExpSuper()
      return r
    }
    val r = to(s, fExpSuper)
    return r
  }

  def fromExpUnary(o: Exp.Unary, isCompact: B): String = {
    val st = Printer.printExpUnary(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpUnary(s: String): Exp.Unary = {
    def fExpUnary(parser: Parser): Exp.Unary = {
      val r = parser.parseExpUnary()
      return r
    }
    val r = to(s, fExpUnary)
    return r
  }

  def fromExpBinary(o: Exp.Binary, isCompact: B): String = {
    val st = Printer.printExpBinary(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpBinary(s: String): Exp.Binary = {
    def fExpBinary(parser: Parser): Exp.Binary = {
      val r = parser.parseExpBinary()
      return r
    }
    val r = to(s, fExpBinary)
    return r
  }

  def fromExpIdent(o: Exp.Ident, isCompact: B): String = {
    val st = Printer.printExpIdent(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpIdent(s: String): Exp.Ident = {
    def fExpIdent(parser: Parser): Exp.Ident = {
      val r = parser.parseExpIdent()
      return r
    }
    val r = to(s, fExpIdent)
    return r
  }

  def fromExpEta(o: Exp.Eta, isCompact: B): String = {
    val st = Printer.printExpEta(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpEta(s: String): Exp.Eta = {
    def fExpEta(parser: Parser): Exp.Eta = {
      val r = parser.parseExpEta()
      return r
    }
    val r = to(s, fExpEta)
    return r
  }

  def fromExpTuple(o: Exp.Tuple, isCompact: B): String = {
    val st = Printer.printExpTuple(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpTuple(s: String): Exp.Tuple = {
    def fExpTuple(parser: Parser): Exp.Tuple = {
      val r = parser.parseExpTuple()
      return r
    }
    val r = to(s, fExpTuple)
    return r
  }

  def fromExpSelect(o: Exp.Select, isCompact: B): String = {
    val st = Printer.printExpSelect(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpSelect(s: String): Exp.Select = {
    def fExpSelect(parser: Parser): Exp.Select = {
      val r = parser.parseExpSelect()
      return r
    }
    val r = to(s, fExpSelect)
    return r
  }

  def fromExpInvoke(o: Exp.Invoke, isCompact: B): String = {
    val st = Printer.printExpInvoke(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpInvoke(s: String): Exp.Invoke = {
    def fExpInvoke(parser: Parser): Exp.Invoke = {
      val r = parser.parseExpInvoke()
      return r
    }
    val r = to(s, fExpInvoke)
    return r
  }

  def fromExpInvokeNamed(o: Exp.InvokeNamed, isCompact: B): String = {
    val st = Printer.printExpInvokeNamed(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpInvokeNamed(s: String): Exp.InvokeNamed = {
    def fExpInvokeNamed(parser: Parser): Exp.InvokeNamed = {
      val r = parser.parseExpInvokeNamed()
      return r
    }
    val r = to(s, fExpInvokeNamed)
    return r
  }

  def fromExpIf(o: Exp.If, isCompact: B): String = {
    val st = Printer.printExpIf(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpIf(s: String): Exp.If = {
    def fExpIf(parser: Parser): Exp.If = {
      val r = parser.parseExpIf()
      return r
    }
    val r = to(s, fExpIf)
    return r
  }

  def fromExpFun(o: Exp.Fun, isCompact: B): String = {
    val st = Printer.printExpFun(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpFun(s: String): Exp.Fun = {
    def fExpFun(parser: Parser): Exp.Fun = {
      val r = parser.parseExpFun()
      return r
    }
    val r = to(s, fExpFun)
    return r
  }

  def fromExpForYield(o: Exp.ForYield, isCompact: B): String = {
    val st = Printer.printExpForYield(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpForYield(s: String): Exp.ForYield = {
    def fExpForYield(parser: Parser): Exp.ForYield = {
      val r = parser.parseExpForYield()
      return r
    }
    val r = to(s, fExpForYield)
    return r
  }

  def fromExpQuant(o: Exp.Quant, isCompact: B): String = {
    val st = Printer.printExpQuant(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toExpQuant(s: String): Exp.Quant = {
    def fExpQuant(parser: Parser): Exp.Quant = {
      val r = parser.parseExpQuant()
      return r
    }
    val r = to(s, fExpQuant)
    return r
  }

  def fromNamedArg(o: NamedArg, isCompact: B): String = {
    val st = Printer.printNamedArg(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toNamedArg(s: String): NamedArg = {
    def fNamedArg(parser: Parser): NamedArg = {
      val r = parser.parseNamedArg()
      return r
    }
    val r = to(s, fNamedArg)
    return r
  }

  def fromVarFragment(o: VarFragment, isCompact: B): String = {
    val st = Printer.printVarFragment(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toVarFragment(s: String): VarFragment = {
    def fVarFragment(parser: Parser): VarFragment = {
      val r = parser.parseVarFragment()
      return r
    }
    val r = to(s, fVarFragment)
    return r
  }

  def fromDomain(o: Domain, isCompact: B): String = {
    val st = Printer.printDomain(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toDomain(s: String): Domain = {
    def fDomain(parser: Parser): Domain = {
      val r = parser.parseDomain()
      return r
    }
    val r = to(s, fDomain)
    return r
  }

  def fromDomainType(o: Domain.Type, isCompact: B): String = {
    val st = Printer.printDomainType(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toDomainType(s: String): Domain.Type = {
    def fDomainType(parser: Parser): Domain.Type = {
      val r = parser.parseDomainType()
      return r
    }
    val r = to(s, fDomainType)
    return r
  }

  def fromDomainRange(o: Domain.Range, isCompact: B): String = {
    val st = Printer.printDomainRange(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toDomainRange(s: String): Domain.Range = {
    def fDomainRange(parser: Parser): Domain.Range = {
      val r = parser.parseDomainRange()
      return r
    }
    val r = to(s, fDomainRange)
    return r
  }

  def fromId(o: Id, isCompact: B): String = {
    val st = Printer.printId(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toId(s: String): Id = {
    def fId(parser: Parser): Id = {
      val r = parser.parseId()
      return r
    }
    val r = to(s, fId)
    return r
  }

  def fromName(o: Name, isCompact: B): String = {
    val st = Printer.printName(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toName(s: String): Name = {
    def fName(parser: Parser): Name = {
      val r = parser.parseName()
      return r
    }
    val r = to(s, fName)
    return r
  }

  def fromBody(o: Body, isCompact: B): String = {
    val st = Printer.printBody(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toBody(s: String): Body = {
    def fBody(parser: Parser): Body = {
      val r = parser.parseBody()
      return r
    }
    val r = to(s, fBody)
    return r
  }

  def fromAbstractDatatypeParam(o: AbstractDatatypeParam, isCompact: B): String = {
    val st = Printer.printAbstractDatatypeParam(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toAbstractDatatypeParam(s: String): AbstractDatatypeParam = {
    def fAbstractDatatypeParam(parser: Parser): AbstractDatatypeParam = {
      val r = parser.parseAbstractDatatypeParam()
      return r
    }
    val r = to(s, fAbstractDatatypeParam)
    return r
  }

  def fromMethodSig(o: MethodSig, isCompact: B): String = {
    val st = Printer.printMethodSig(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toMethodSig(s: String): MethodSig = {
    def fMethodSig(parser: Parser): MethodSig = {
      val r = parser.parseMethodSig()
      return r
    }
    val r = to(s, fMethodSig)
    return r
  }

  def fromParam(o: Param, isCompact: B): String = {
    val st = Printer.printParam(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toParam(s: String): Param = {
    def fParam(parser: Parser): Param = {
      val r = parser.parseParam()
      return r
    }
    val r = to(s, fParam)
    return r
  }

  def fromTypeParam(o: TypeParam, isCompact: B): String = {
    val st = Printer.printTypeParam(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTypeParam(s: String): TypeParam = {
    def fTypeParam(parser: Parser): TypeParam = {
      val r = parser.parseTypeParam()
      return r
    }
    val r = to(s, fTypeParam)
    return r
  }

  def fromContract(o: Contract, isCompact: B): String = {
    val st = Printer.printContract(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toContract(s: String): Contract = {
    def fContract(parser: Parser): Contract = {
      val r = parser.parseContract()
      return r
    }
    val r = to(s, fContract)
    return r
  }

  def fromSubContract(o: SubContract, isCompact: B): String = {
    val st = Printer.printSubContract(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toSubContract(s: String): SubContract = {
    def fSubContract(parser: Parser): SubContract = {
      val r = parser.parseSubContract()
      return r
    }
    val r = to(s, fSubContract)
    return r
  }

  def fromSubContractParam(o: SubContractParam, isCompact: B): String = {
    val st = Printer.printSubContractParam(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toSubContractParam(s: String): SubContractParam = {
    def fSubContractParam(parser: Parser): SubContractParam = {
      val r = parser.parseSubContractParam()
      return r
    }
    val r = to(s, fSubContractParam)
    return r
  }

  def fromWhereDef(o: WhereDef, isCompact: B): String = {
    val st = Printer.printWhereDef(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toWhereDef(s: String): WhereDef = {
    def fWhereDef(parser: Parser): WhereDef = {
      val r = parser.parseWhereDef()
      return r
    }
    val r = to(s, fWhereDef)
    return r
  }

  def fromWhereDefVal(o: WhereDef.Val, isCompact: B): String = {
    val st = Printer.printWhereDefVal(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toWhereDefVal(s: String): WhereDef.Val = {
    def fWhereDefVal(parser: Parser): WhereDef.Val = {
      val r = parser.parseWhereDefVal()
      return r
    }
    val r = to(s, fWhereDefVal)
    return r
  }

  def fromWhereDefDef(o: WhereDef.Def, isCompact: B): String = {
    val st = Printer.printWhereDefDef(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toWhereDefDef(s: String): WhereDef.Def = {
    def fWhereDefDef(parser: Parser): WhereDef.Def = {
      val r = parser.parseWhereDefDef()
      return r
    }
    val r = to(s, fWhereDefDef)
    return r
  }

  def fromSpecDef(o: SpecDef, isCompact: B): String = {
    val st = Printer.printSpecDef(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toSpecDef(s: String): SpecDef = {
    def fSpecDef(parser: Parser): SpecDef = {
      val r = parser.parseSpecDef()
      return r
    }
    val r = to(s, fSpecDef)
    return r
  }

  def fromProofStep(o: ProofStep, isCompact: B): String = {
    val st = Printer.printProofStep(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toProofStep(s: String): ProofStep = {
    def fProofStep(parser: Parser): ProofStep = {
      val r = parser.parseProofStep()
      return r
    }
    val r = to(s, fProofStep)
    return r
  }

  def fromProofStepBasic(o: ProofStep.Basic, isCompact: B): String = {
    val st = Printer.printProofStepBasic(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toProofStepBasic(s: String): ProofStep.Basic = {
    def fProofStepBasic(parser: Parser): ProofStep.Basic = {
      val r = parser.parseProofStepBasic()
      return r
    }
    val r = to(s, fProofStepBasic)
    return r
  }

  def fromProofStepSubProof(o: ProofStep.SubProof, isCompact: B): String = {
    val st = Printer.printProofStepSubProof(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toProofStepSubProof(s: String): ProofStep.SubProof = {
    def fProofStepSubProof(parser: Parser): ProofStep.SubProof = {
      val r = parser.parseProofStepSubProof()
      return r
    }
    val r = to(s, fProofStepSubProof)
    return r
  }

  def fromAssumeProofStep(o: AssumeProofStep, isCompact: B): String = {
    val st = Printer.printAssumeProofStep(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toAssumeProofStep(s: String): AssumeProofStep = {
    def fAssumeProofStep(parser: Parser): AssumeProofStep = {
      val r = parser.parseAssumeProofStep()
      return r
    }
    val r = to(s, fAssumeProofStep)
    return r
  }

  def fromAssumeProofStepRegular(o: AssumeProofStep.Regular, isCompact: B): String = {
    val st = Printer.printAssumeProofStepRegular(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toAssumeProofStepRegular(s: String): AssumeProofStep.Regular = {
    def fAssumeProofStepRegular(parser: Parser): AssumeProofStep.Regular = {
      val r = parser.parseAssumeProofStepRegular()
      return r
    }
    val r = to(s, fAssumeProofStepRegular)
    return r
  }

  def fromAssumeProofStepForallIntroAps(o: AssumeProofStep.ForallIntroAps, isCompact: B): String = {
    val st = Printer.printAssumeProofStepForallIntroAps(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toAssumeProofStepForallIntroAps(s: String): AssumeProofStep.ForallIntroAps = {
    def fAssumeProofStepForallIntroAps(parser: Parser): AssumeProofStep.ForallIntroAps = {
      val r = parser.parseAssumeProofStepForallIntroAps()
      return r
    }
    val r = to(s, fAssumeProofStepForallIntroAps)
    return r
  }

  def fromAssumeProofStepExistsElimAps(o: AssumeProofStep.ExistsElimAps, isCompact: B): String = {
    val st = Printer.printAssumeProofStepExistsElimAps(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toAssumeProofStepExistsElimAps(s: String): AssumeProofStep.ExistsElimAps = {
    def fAssumeProofStepExistsElimAps(parser: Parser): AssumeProofStep.ExistsElimAps = {
      val r = parser.parseAssumeProofStepExistsElimAps()
      return r
    }
    val r = to(s, fAssumeProofStepExistsElimAps)
    return r
  }

  def fromJust(o: Just, isCompact: B): String = {
    val st = Printer.printJust(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJust(s: String): Just = {
    def fJust(parser: Parser): Just = {
      val r = parser.parseJust()
      return r
    }
    val r = to(s, fJust)
    return r
  }

  def fromJustPremise(o: Just.Premise, isCompact: B): String = {
    val st = Printer.printJustPremise(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustPremise(s: String): Just.Premise = {
    def fJustPremise(parser: Parser): Just.Premise = {
      val r = parser.parseJustPremise()
      return r
    }
    val r = to(s, fJustPremise)
    return r
  }

  def fromJustAndIntro(o: Just.AndIntro, isCompact: B): String = {
    val st = Printer.printJustAndIntro(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustAndIntro(s: String): Just.AndIntro = {
    def fJustAndIntro(parser: Parser): Just.AndIntro = {
      val r = parser.parseJustAndIntro()
      return r
    }
    val r = to(s, fJustAndIntro)
    return r
  }

  def fromJustAndElim(o: Just.AndElim, isCompact: B): String = {
    val st = Printer.printJustAndElim(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustAndElim(s: String): Just.AndElim = {
    def fJustAndElim(parser: Parser): Just.AndElim = {
      val r = parser.parseJustAndElim()
      return r
    }
    val r = to(s, fJustAndElim)
    return r
  }

  def fromJustOrIntro(o: Just.OrIntro, isCompact: B): String = {
    val st = Printer.printJustOrIntro(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustOrIntro(s: String): Just.OrIntro = {
    def fJustOrIntro(parser: Parser): Just.OrIntro = {
      val r = parser.parseJustOrIntro()
      return r
    }
    val r = to(s, fJustOrIntro)
    return r
  }

  def fromJustOrElim(o: Just.OrElim, isCompact: B): String = {
    val st = Printer.printJustOrElim(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustOrElim(s: String): Just.OrElim = {
    def fJustOrElim(parser: Parser): Just.OrElim = {
      val r = parser.parseJustOrElim()
      return r
    }
    val r = to(s, fJustOrElim)
    return r
  }

  def fromJustImplyIntro(o: Just.ImplyIntro, isCompact: B): String = {
    val st = Printer.printJustImplyIntro(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustImplyIntro(s: String): Just.ImplyIntro = {
    def fJustImplyIntro(parser: Parser): Just.ImplyIntro = {
      val r = parser.parseJustImplyIntro()
      return r
    }
    val r = to(s, fJustImplyIntro)
    return r
  }

  def fromJustImplyElim(o: Just.ImplyElim, isCompact: B): String = {
    val st = Printer.printJustImplyElim(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustImplyElim(s: String): Just.ImplyElim = {
    def fJustImplyElim(parser: Parser): Just.ImplyElim = {
      val r = parser.parseJustImplyElim()
      return r
    }
    val r = to(s, fJustImplyElim)
    return r
  }

  def fromJustNegIntro(o: Just.NegIntro, isCompact: B): String = {
    val st = Printer.printJustNegIntro(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustNegIntro(s: String): Just.NegIntro = {
    def fJustNegIntro(parser: Parser): Just.NegIntro = {
      val r = parser.parseJustNegIntro()
      return r
    }
    val r = to(s, fJustNegIntro)
    return r
  }

  def fromJustNegElim(o: Just.NegElim, isCompact: B): String = {
    val st = Printer.printJustNegElim(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustNegElim(s: String): Just.NegElim = {
    def fJustNegElim(parser: Parser): Just.NegElim = {
      val r = parser.parseJustNegElim()
      return r
    }
    val r = to(s, fJustNegElim)
    return r
  }

  def fromJustBottomElim(o: Just.BottomElim, isCompact: B): String = {
    val st = Printer.printJustBottomElim(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustBottomElim(s: String): Just.BottomElim = {
    def fJustBottomElim(parser: Parser): Just.BottomElim = {
      val r = parser.parseJustBottomElim()
      return r
    }
    val r = to(s, fJustBottomElim)
    return r
  }

  def fromJustPbc(o: Just.Pbc, isCompact: B): String = {
    val st = Printer.printJustPbc(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustPbc(s: String): Just.Pbc = {
    def fJustPbc(parser: Parser): Just.Pbc = {
      val r = parser.parseJustPbc()
      return r
    }
    val r = to(s, fJustPbc)
    return r
  }

  def fromJustForallIntro(o: Just.ForallIntro, isCompact: B): String = {
    val st = Printer.printJustForallIntro(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustForallIntro(s: String): Just.ForallIntro = {
    def fJustForallIntro(parser: Parser): Just.ForallIntro = {
      val r = parser.parseJustForallIntro()
      return r
    }
    val r = to(s, fJustForallIntro)
    return r
  }

  def fromJustForallElim(o: Just.ForallElim, isCompact: B): String = {
    val st = Printer.printJustForallElim(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustForallElim(s: String): Just.ForallElim = {
    def fJustForallElim(parser: Parser): Just.ForallElim = {
      val r = parser.parseJustForallElim()
      return r
    }
    val r = to(s, fJustForallElim)
    return r
  }

  def fromJustExistsIntro(o: Just.ExistsIntro, isCompact: B): String = {
    val st = Printer.printJustExistsIntro(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustExistsIntro(s: String): Just.ExistsIntro = {
    def fJustExistsIntro(parser: Parser): Just.ExistsIntro = {
      val r = parser.parseJustExistsIntro()
      return r
    }
    val r = to(s, fJustExistsIntro)
    return r
  }

  def fromJustExistsElim(o: Just.ExistsElim, isCompact: B): String = {
    val st = Printer.printJustExistsElim(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustExistsElim(s: String): Just.ExistsElim = {
    def fJustExistsElim(parser: Parser): Just.ExistsElim = {
      val r = parser.parseJustExistsElim()
      return r
    }
    val r = to(s, fJustExistsElim)
    return r
  }

  def fromJustFact(o: Just.Fact, isCompact: B): String = {
    val st = Printer.printJustFact(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustFact(s: String): Just.Fact = {
    def fJustFact(parser: Parser): Just.Fact = {
      val r = parser.parseJustFact()
      return r
    }
    val r = to(s, fJustFact)
    return r
  }

  def fromJustInvariant(o: Just.Invariant, isCompact: B): String = {
    val st = Printer.printJustInvariant(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustInvariant(s: String): Just.Invariant = {
    def fJustInvariant(parser: Parser): Just.Invariant = {
      val r = parser.parseJustInvariant()
      return r
    }
    val r = to(s, fJustInvariant)
    return r
  }

  def fromJustSubst(o: Just.Subst, isCompact: B): String = {
    val st = Printer.printJustSubst(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustSubst(s: String): Just.Subst = {
    def fJustSubst(parser: Parser): Just.Subst = {
      val r = parser.parseJustSubst()
      return r
    }
    val r = to(s, fJustSubst)
    return r
  }

  def fromJustAuto(o: Just.Auto, isCompact: B): String = {
    val st = Printer.printJustAuto(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustAuto(s: String): Just.Auto = {
    def fJustAuto(parser: Parser): Just.Auto = {
      val r = parser.parseJustAuto()
      return r
    }
    val r = to(s, fJustAuto)
    return r
  }

  def fromJustCoq(o: Just.Coq, isCompact: B): String = {
    val st = Printer.printJustCoq(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toJustCoq(s: String): Just.Coq = {
    def fJustCoq(parser: Parser): Just.Coq = {
      val r = parser.parseJustCoq()
      return r
    }
    val r = to(s, fJustCoq)
    return r
  }

  def fromTruthTableRow(o: TruthTable.Row, isCompact: B): String = {
    val st = Printer.printTruthTableRow(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTruthTableRow(s: String): TruthTable.Row = {
    def fTruthTableRow(parser: Parser): TruthTable.Row = {
      val r = parser.parseTruthTableRow()
      return r
    }
    val r = to(s, fTruthTableRow)
    return r
  }

  def fromTruthTableAssignment(o: TruthTable.Assignment, isCompact: B): String = {
    val st = Printer.printTruthTableAssignment(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTruthTableAssignment(s: String): TruthTable.Assignment = {
    def fTruthTableAssignment(parser: Parser): TruthTable.Assignment = {
      val r = parser.parseTruthTableAssignment()
      return r
    }
    val r = to(s, fTruthTableAssignment)
    return r
  }

  def fromTruthTableConclusion(o: TruthTable.Conclusion, isCompact: B): String = {
    val st = Printer.printTruthTableConclusion(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTruthTableConclusion(s: String): TruthTable.Conclusion = {
    def fTruthTableConclusion(parser: Parser): TruthTable.Conclusion = {
      val r = parser.parseTruthTableConclusion()
      return r
    }
    val r = to(s, fTruthTableConclusion)
    return r
  }

  def fromTruthTableConclusionValidity(o: TruthTable.Conclusion.Validity, isCompact: B): String = {
    val st = Printer.printTruthTableConclusionValidity(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTruthTableConclusionValidity(s: String): TruthTable.Conclusion.Validity = {
    def fTruthTableConclusionValidity(parser: Parser): TruthTable.Conclusion.Validity = {
      val r = parser.parseTruthTableConclusionValidity()
      return r
    }
    val r = to(s, fTruthTableConclusionValidity)
    return r
  }

  def fromTruthTableConclusionTautology(o: TruthTable.Conclusion.Tautology, isCompact: B): String = {
    val st = Printer.printTruthTableConclusionTautology(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTruthTableConclusionTautology(s: String): TruthTable.Conclusion.Tautology = {
    def fTruthTableConclusionTautology(parser: Parser): TruthTable.Conclusion.Tautology = {
      val r = parser.parseTruthTableConclusionTautology()
      return r
    }
    val r = to(s, fTruthTableConclusionTautology)
    return r
  }

  def fromTruthTableConclusionContradictory(o: TruthTable.Conclusion.Contradictory, isCompact: B): String = {
    val st = Printer.printTruthTableConclusionContradictory(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTruthTableConclusionContradictory(s: String): TruthTable.Conclusion.Contradictory = {
    def fTruthTableConclusionContradictory(parser: Parser): TruthTable.Conclusion.Contradictory = {
      val r = parser.parseTruthTableConclusionContradictory()
      return r
    }
    val r = to(s, fTruthTableConclusionContradictory)
    return r
  }

  def fromTruthTableConclusionContingent(o: TruthTable.Conclusion.Contingent, isCompact: B): String = {
    val st = Printer.printTruthTableConclusionContingent(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTruthTableConclusionContingent(s: String): TruthTable.Conclusion.Contingent = {
    def fTruthTableConclusionContingent(parser: Parser): TruthTable.Conclusion.Contingent = {
      val r = parser.parseTruthTableConclusionContingent()
      return r
    }
    val r = to(s, fTruthTableConclusionContingent)
    return r
  }

  def fromTyped(o: Typed, isCompact: B): String = {
    val st = Printer.printTyped(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTyped(s: String): Typed = {
    def fTyped(parser: Parser): Typed = {
      val r = parser.parseTyped()
      return r
    }
    val r = to(s, fTyped)
    return r
  }

  def fromTypedName(o: Typed.Name, isCompact: B): String = {
    val st = Printer.printTypedName(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTypedName(s: String): Typed.Name = {
    def fTypedName(parser: Parser): Typed.Name = {
      val r = parser.parseTypedName()
      return r
    }
    val r = to(s, fTypedName)
    return r
  }

  def fromTypedTuple(o: Typed.Tuple, isCompact: B): String = {
    val st = Printer.printTypedTuple(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTypedTuple(s: String): Typed.Tuple = {
    def fTypedTuple(parser: Parser): Typed.Tuple = {
      val r = parser.parseTypedTuple()
      return r
    }
    val r = to(s, fTypedTuple)
    return r
  }

  def fromTypedFun(o: Typed.Fun, isCompact: B): String = {
    val st = Printer.printTypedFun(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTypedFun(s: String): Typed.Fun = {
    def fTypedFun(parser: Parser): Typed.Fun = {
      val r = parser.parseTypedFun()
      return r
    }
    val r = to(s, fTypedFun)
    return r
  }

  def fromAttr(o: Attr, isCompact: B): String = {
    val st = Printer.printAttr(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toAttr(s: String): Attr = {
    def fAttr(parser: Parser): Attr = {
      val r = parser.parseAttr()
      return r
    }
    val r = to(s, fAttr)
    return r
  }

  def fromTypedAttr(o: TypedAttr, isCompact: B): String = {
    val st = Printer.printTypedAttr(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toTypedAttr(s: String): TypedAttr = {
    def fTypedAttr(parser: Parser): TypedAttr = {
      val r = parser.parseTypedAttr()
      return r
    }
    val r = to(s, fTypedAttr)
    return r
  }

  def fromResolvedAttr(o: ResolvedAttr, isCompact: B): String = {
    val st = Printer.printResolvedAttr(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toResolvedAttr(s: String): ResolvedAttr = {
    def fResolvedAttr(parser: Parser): ResolvedAttr = {
      val r = parser.parseResolvedAttr()
      return r
    }
    val r = to(s, fResolvedAttr)
    return r
  }

  def fromResolvedInfo(o: ResolvedInfo, isCompact: B): String = {
    val st = Printer.printResolvedInfo(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toResolvedInfo(s: String): ResolvedInfo = {
    def fResolvedInfo(parser: Parser): ResolvedInfo = {
      val r = parser.parseResolvedInfo()
      return r
    }
    val r = to(s, fResolvedInfo)
    return r
  }

  def fromPosInfo(o: PosInfo, isCompact: B): String = {
    val st = Printer.printPosInfo(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPosInfo(s: String): PosInfo = {
    def fPosInfo(parser: Parser): PosInfo = {
      val r = parser.parsePosInfo()
      return r
    }
    val r = to(s, fPosInfo)
    return r
  }

}