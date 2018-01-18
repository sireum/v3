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

object MsgPack {

  object Constants {

    val TopUnitProgram: Z = 0

    val TopUnitSequentUnit: Z = 1

    val TopUnitTruthTableUnit: Z = 2

    val StmtImport: Z = 3

    val StmtImportImporter: Z = 4

    val StmtImportMultiSelector: Z = 5

    val StmtImportWildcardSelector: Z = 6

    val StmtImportNamedSelector: Z = 7

    val StmtVar: Z = 8

    val StmtVarPattern: Z = 9

    val StmtSpecVar: Z = 10

    val StmtMethod: Z = 11

    val StmtExtMethod: Z = 12

    val StmtSpecMethod: Z = 13

    val StmtEnum: Z = 14

    val StmtSubZ: Z = 15

    val StmtObject: Z = 16

    val StmtSig: Z = 17

    val StmtAbstractDatatype: Z = 18

    val StmtTypeAlias: Z = 19

    val StmtAssign: Z = 20

    val StmtAssignUp: Z = 21

    val StmtAssignPattern: Z = 22

    val StmtBlock: Z = 23

    val StmtIf: Z = 24

    val StmtMatch: Z = 25

    val StmtWhile: Z = 26

    val StmtDoWhile: Z = 27

    val StmtFor: Z = 28

    val StmtReturn: Z = 29

    val StmtLStmt: Z = 30

    val StmtExpr: Z = 31

    val LClauseInvariants: Z = 32

    val LClauseFacts: Z = 33

    val LClauseFact: Z = 34

    val LClauseTheorems: Z = 35

    val LClauseTheorem: Z = 36

    val LClauseSequent: Z = 37

    val LClauseProof: Z = 38

    val ContractExp: Z = 39

    val Case: Z = 40

    val EnumGenRangeExpr: Z = 41

    val EnumGenRangeIndices: Z = 42

    val EnumGenRangeStep: Z = 43

    val EnumGenFor: Z = 44

    val TypeNamed: Z = 45

    val TypeFun: Z = 46

    val TypeTuple: Z = 47

    val PatternLiteral: Z = 48

    val PatternRef: Z = 49

    val PatternVariable: Z = 50

    val PatternWildcard: Z = 51

    val PatternSeqWildcard: Z = 52

    val PatternStructure: Z = 53

    val ExpLitB: Z = 54

    val ExpLitC: Z = 55

    val ExpLitZ: Z = 56

    val ExpLitF32: Z = 57

    val ExpLitF64: Z = 58

    val ExpLitR: Z = 59

    val ExpLitBv: Z = 60

    val ExpLitString: Z = 61

    val ExpStringInterpolate: Z = 62

    val ExpThis: Z = 63

    val ExpSuper: Z = 64

    val ExpUnary: Z = 65

    val ExpBinary: Z = 66

    val ExpIdent: Z = 67

    val ExpEta: Z = 68

    val ExpTuple: Z = 69

    val ExpSelect: Z = 70

    val ExpInvoke: Z = 71

    val ExpInvokeNamed: Z = 72

    val ExpIf: Z = 73

    val ExpFun: Z = 74

    val ExpForYield: Z = 75

    val ExpQuant: Z = 76

    val NamedArg: Z = 77

    val VarFragment: Z = 78

    val DomainType: Z = 79

    val DomainRange: Z = 80

    val Id: Z = 81

    val Name: Z = 82

    val Body: Z = 83

    val AbstractDatatypeParam: Z = 84

    val MethodSig: Z = 85

    val Param: Z = 86

    val TypeParam: Z = 87

    val Contract: Z = 88

    val SubContract: Z = 89

    val SubContractParam: Z = 90

    val WhereDefVal: Z = 91

    val WhereDefDef: Z = 92

    val SpecDef: Z = 93

    val ProofStepBasic: Z = 94

    val ProofStepSubProof: Z = 95

    val AssumeProofStepRegular: Z = 96

    val AssumeProofStepForallIntroAps: Z = 97

    val AssumeProofStepExistsElimAps: Z = 98

    val JustPremise: Z = 99

    val JustAndIntro: Z = 100

    val JustAndElim: Z = 101

    val JustOrIntro: Z = 102

    val JustOrElim: Z = 103

    val JustImplyIntro: Z = 104

    val JustImplyElim: Z = 105

    val JustNegIntro: Z = 106

    val JustNegElim: Z = 107

    val JustBottomElim: Z = 108

    val JustPbc: Z = 109

    val JustForallIntro: Z = 110

    val JustForallElim: Z = 111

    val JustExistsIntro: Z = 112

    val JustExistsElim: Z = 113

    val JustFact: Z = 114

    val JustInvariant: Z = 115

    val JustSubst: Z = 116

    val JustAuto: Z = 117

    val JustCoq: Z = 118

    val TruthTableRow: Z = 119

    val TruthTableAssignment: Z = 120

    val TruthTableConclusionValidity: Z = 121

    val TruthTableConclusionTautology: Z = 122

    val TruthTableConclusionContradictory: Z = 123

    val TruthTableConclusionContingent: Z = 124

    val TypedName: Z = 125

    val TypedTuple: Z = 126

    val TypedFun: Z = 127

    val Attr: Z = 128

    val TypedAttr: Z = 129

    val ResolvedAttr: Z = 130

    val ResolvedInfo: Z = 131

    val PosInfo: Z = 132

  }

  @record class Writer(writer: MessagePack.Writer) {

    def writeTopUnit(o: TopUnit): Unit = {
      o match {
        case o: TopUnit.Program => writeTopUnitProgram(o)
        case o: TopUnit.SequentUnit => writeTopUnitSequentUnit(o)
        case o: TopUnit.TruthTableUnit => writeTopUnitTruthTableUnit(o)
      }
    }

    def writeTopUnitProgram(o: TopUnit.Program): Unit = {
      writer.writeZ(Constants.TopUnitProgram)
      writer.writeOption(o.fileUriOpt, writeString)
      writeName(o.packageName)
      writeBody(o.body)
    }

    def writeTopUnitSequentUnit(o: TopUnit.SequentUnit): Unit = {
      writer.writeZ(Constants.TopUnitSequentUnit)
      writer.writeOption(o.fileUriOpt, writeString)
      writeLClauseSequent(o.sequent)
    }

    def writeTopUnitTruthTableUnit(o: TopUnit.TruthTableUnit): Unit = {
      writer.writeZ(Constants.TopUnitTruthTableUnit)
      writer.writeOption(o.fileUriOpt, writeString)
      writer.writeISZ(o.stars, writePosInfo)
      writer.writeISZ(o.vars, writeId)
      writePosInfo(o.separator)
      writeB(o.isSequent)
      writeLClauseSequent(o.sequent)
      writer.writeISZ(o.rows, writeTruthTableRow)
      writer.writeOption(o.conclusionOpt, writeTruthTableConclusion)
    }

    def writeStmt(o: Stmt): Unit = {
      o match {
        case o: Stmt.Import => writeStmtImport(o)
        case o: Stmt.Var => writeStmtVar(o)
        case o: Stmt.VarPattern => writeStmtVarPattern(o)
        case o: Stmt.SpecVar => writeStmtSpecVar(o)
        case o: Stmt.Method => writeStmtMethod(o)
        case o: Stmt.ExtMethod => writeStmtExtMethod(o)
        case o: Stmt.SpecMethod => writeStmtSpecMethod(o)
        case o: Stmt.Enum => writeStmtEnum(o)
        case o: Stmt.SubZ => writeStmtSubZ(o)
        case o: Stmt.Object => writeStmtObject(o)
        case o: Stmt.Sig => writeStmtSig(o)
        case o: Stmt.AbstractDatatype => writeStmtAbstractDatatype(o)
        case o: Stmt.TypeAlias => writeStmtTypeAlias(o)
        case o: Stmt.Assign => writeStmtAssign(o)
        case o: Stmt.AssignUp => writeStmtAssignUp(o)
        case o: Stmt.AssignPattern => writeStmtAssignPattern(o)
        case o: Stmt.Block => writeStmtBlock(o)
        case o: Stmt.If => writeStmtIf(o)
        case o: Stmt.Match => writeStmtMatch(o)
        case o: Stmt.While => writeStmtWhile(o)
        case o: Stmt.DoWhile => writeStmtDoWhile(o)
        case o: Stmt.For => writeStmtFor(o)
        case o: Stmt.Return => writeStmtReturn(o)
        case o: Stmt.LStmt => writeStmtLStmt(o)
        case o: Stmt.Expr => writeStmtExpr(o)
      }
    }

    def writeAssignExp(o: AssignExp): Unit = {
      o match {
        case o: Stmt.Block => writeStmtBlock(o)
        case o: Stmt.If => writeStmtIf(o)
        case o: Stmt.Match => writeStmtMatch(o)
        case o: Stmt.Expr => writeStmtExpr(o)
      }
    }

    def writePurity(o: Purity.Type): Unit = {
      writer.writeZ(o.ordinal)
    }

    def writeStmtImport(o: Stmt.Import): Unit = {
      writer.writeZ(Constants.StmtImport)
      writer.writeISZ(o.importers, writeStmtImportImporter)
      writeAttr(o.attr)
    }

    def writeStmtImportImporter(o: Stmt.Import.Importer): Unit = {
      writer.writeZ(Constants.StmtImportImporter)
      writeName(o.name)
      writer.writeOption(o.selectorOpt, writeStmtImportSelector)
    }

    def writeStmtImportSelector(o: Stmt.Import.Selector): Unit = {
      o match {
        case o: Stmt.Import.MultiSelector => writeStmtImportMultiSelector(o)
        case o: Stmt.Import.WildcardSelector => writeStmtImportWildcardSelector(o)
      }
    }

    def writeStmtImportMultiSelector(o: Stmt.Import.MultiSelector): Unit = {
      writer.writeZ(Constants.StmtImportMultiSelector)
      writer.writeISZ(o.selectors, writeStmtImportNamedSelector)
    }

    def writeStmtImportWildcardSelector(o: Stmt.Import.WildcardSelector): Unit = {
      writer.writeZ(Constants.StmtImportWildcardSelector)
    }

    def writeStmtImportNamedSelector(o: Stmt.Import.NamedSelector): Unit = {
      writer.writeZ(Constants.StmtImportNamedSelector)
      writeId(o.from)
      writeId(o.to)
    }

    def writeStmtVar(o: Stmt.Var): Unit = {
      writer.writeZ(Constants.StmtVar)
      writeB(o.isVal)
      writeId(o.id)
      writer.writeOption(o.tipeOpt, writeType)
      writer.writeOption(o.initOpt, writeAssignExp)
      writeAttr(o.attr)
    }

    def writeStmtVarPattern(o: Stmt.VarPattern): Unit = {
      writer.writeZ(Constants.StmtVarPattern)
      writeB(o.isVal)
      writePattern(o.pattern)
      writeAssignExp(o.init)
      writeAttr(o.attr)
    }

    def writeStmtSpecVar(o: Stmt.SpecVar): Unit = {
      writer.writeZ(Constants.StmtSpecVar)
      writeB(o.isVal)
      writeId(o.id)
      writeType(o.tipe)
      writeAttr(o.attr)
    }

    def writeStmtMethod(o: Stmt.Method): Unit = {
      writer.writeZ(Constants.StmtMethod)
      writePurity(o.purity)
      writeB(o.hasOverride)
      writeB(o.isHelper)
      writeMethodSig(o.sig)
      writeContract(o.contract)
      writer.writeOption(o.bodyOpt, writeBody)
      writeAttr(o.attr)
    }

    def writeStmtExtMethod(o: Stmt.ExtMethod): Unit = {
      writer.writeZ(Constants.StmtExtMethod)
      writeB(o.isPure)
      writeMethodSig(o.sig)
      writeContract(o.contract)
      writeAttr(o.attr)
    }

    def writeStmtSpecMethod(o: Stmt.SpecMethod): Unit = {
      writer.writeZ(Constants.StmtSpecMethod)
      writeMethodSig(o.sig)
      writer.writeISZ(o.defs, writeSpecDef)
      writer.writeISZ(o.where, writeWhereDef)
      writeAttr(o.attr)
    }

    def writeStmtEnum(o: Stmt.Enum): Unit = {
      writer.writeZ(Constants.StmtEnum)
      writeId(o.id)
      writer.writeISZ(o.elements, writeId)
      writeAttr(o.attr)
    }

    def writeStmtSubZ(o: Stmt.SubZ): Unit = {
      writer.writeZ(Constants.StmtSubZ)
      writeId(o.id)
      writeB(o.isSigned)
      writeB(o.isBitVector)
      writeB(o.isWrapped)
      writeB(o.hasMin)
      writeB(o.hasMax)
      writeZ(o.bitWidth)
      writeZ(o.min)
      writeZ(o.max)
      writeZ(o.index)
      writeAttr(o.attr)
    }

    def writeStmtObject(o: Stmt.Object): Unit = {
      writer.writeZ(Constants.StmtObject)
      writeB(o.isExt)
      writeId(o.id)
      writer.writeISZ(o.parents, writeType)
      writer.writeISZ(o.stmts, writeStmt)
      writeAttr(o.attr)
    }

    def writeStmtSig(o: Stmt.Sig): Unit = {
      writer.writeZ(Constants.StmtSig)
      writeB(o.isImmutable)
      writeB(o.isExt)
      writeId(o.id)
      writer.writeISZ(o.typeParams, writeTypeParam)
      writer.writeISZ(o.parents, writeTypeNamed)
      writer.writeOption(o.selfTypeOpt, writeType)
      writer.writeISZ(o.stmts, writeStmt)
      writeAttr(o.attr)
    }

    def writeStmtAbstractDatatype(o: Stmt.AbstractDatatype): Unit = {
      writer.writeZ(Constants.StmtAbstractDatatype)
      writeB(o.isRoot)
      writeB(o.isDatatype)
      writeId(o.id)
      writer.writeISZ(o.typeParams, writeTypeParam)
      writer.writeISZ(o.params, writeAbstractDatatypeParam)
      writer.writeISZ(o.parents, writeTypeNamed)
      writer.writeISZ(o.stmts, writeStmt)
      writeAttr(o.attr)
    }

    def writeStmtTypeAlias(o: Stmt.TypeAlias): Unit = {
      writer.writeZ(Constants.StmtTypeAlias)
      writeId(o.id)
      writer.writeISZ(o.typeParams, writeTypeParam)
      writeType(o.tipe)
      writeAttr(o.attr)
    }

    def writeStmtAssign(o: Stmt.Assign): Unit = {
      writer.writeZ(Constants.StmtAssign)
      writeExp(o.lhs)
      writeAssignExp(o.rhs)
      writeAttr(o.attr)
    }

    def writeStmtAssignUp(o: Stmt.AssignUp): Unit = {
      writer.writeZ(Constants.StmtAssignUp)
      writeExp(o.lhs)
      writeAssignExp(o.rhs)
      writeAttr(o.attr)
    }

    def writeStmtAssignPattern(o: Stmt.AssignPattern): Unit = {
      writer.writeZ(Constants.StmtAssignPattern)
      writePattern(o.lhs)
      writeAssignExp(o.rhs)
      writeAttr(o.attr)
    }

    def writeStmtBlock(o: Stmt.Block): Unit = {
      writer.writeZ(Constants.StmtBlock)
      writeBody(o.body)
      writeAttr(o.attr)
    }

    def writeStmtIf(o: Stmt.If): Unit = {
      writer.writeZ(Constants.StmtIf)
      writeExp(o.cond)
      writeBody(o.thenbody)
      writeBody(o.elsebody)
      writeAttr(o.attr)
    }

    def writeStmtMatch(o: Stmt.Match): Unit = {
      writer.writeZ(Constants.StmtMatch)
      writeExp(o.cond)
      writer.writeISZ(o.cases, writeCase)
      writeAttr(o.attr)
    }

    def writeStmtWhile(o: Stmt.While): Unit = {
      writer.writeZ(Constants.StmtWhile)
      writeExp(o.cond)
      writer.writeISZ(o.invariants, writeContractExp)
      writer.writeISZ(o.modifies, writeExp)
      writeBody(o.body)
      writeAttr(o.attr)
    }

    def writeStmtDoWhile(o: Stmt.DoWhile): Unit = {
      writer.writeZ(Constants.StmtDoWhile)
      writeExp(o.cond)
      writer.writeISZ(o.invariants, writeContractExp)
      writer.writeISZ(o.modifies, writeExp)
      writeBody(o.body)
      writeAttr(o.attr)
    }

    def writeStmtFor(o: Stmt.For): Unit = {
      writer.writeZ(Constants.StmtFor)
      writeEnumGenFor(o.enumGen)
      writer.writeISZ(o.invariants, writeContractExp)
      writer.writeISZ(o.modifies, writeExp)
      writeBody(o.body)
      writeAttr(o.attr)
    }

    def writeStmtReturn(o: Stmt.Return): Unit = {
      writer.writeZ(Constants.StmtReturn)
      writer.writeOption(o.expOpt, writeExp)
      writeAttr(o.attr)
    }

    def writeStmtLStmt(o: Stmt.LStmt): Unit = {
      writer.writeZ(Constants.StmtLStmt)
      writeLClause(o.clause)
      writeAttr(o.attr)
    }

    def writeStmtExpr(o: Stmt.Expr): Unit = {
      writer.writeZ(Constants.StmtExpr)
      writeExp(o.exp)
      writeAttr(o.attr)
    }

    def writeLClause(o: LClause): Unit = {
      o match {
        case o: LClause.Invariants => writeLClauseInvariants(o)
        case o: LClause.Facts => writeLClauseFacts(o)
        case o: LClause.Theorems => writeLClauseTheorems(o)
        case o: LClause.Sequent => writeLClauseSequent(o)
        case o: LClause.Proof => writeLClauseProof(o)
      }
    }

    def writeLClauseInvariants(o: LClause.Invariants): Unit = {
      writer.writeZ(Constants.LClauseInvariants)
      writer.writeISZ(o.value, writeContractExp)
    }

    def writeLClauseFacts(o: LClause.Facts): Unit = {
      writer.writeZ(Constants.LClauseFacts)
      writer.writeISZ(o.value, writeLClauseFact)
    }

    def writeLClauseFact(o: LClause.Fact): Unit = {
      writer.writeZ(Constants.LClauseFact)
      writeId(o.id)
      writeExp(o.exp)
    }

    def writeLClauseTheorems(o: LClause.Theorems): Unit = {
      writer.writeZ(Constants.LClauseTheorems)
      writer.writeISZ(o.value, writeLClauseTheorem)
    }

    def writeLClauseTheorem(o: LClause.Theorem): Unit = {
      writer.writeZ(Constants.LClauseTheorem)
      writeId(o.id)
      writeLClauseSequent(o.sequent)
    }

    def writeLClauseSequent(o: LClause.Sequent): Unit = {
      writer.writeZ(Constants.LClauseSequent)
      writer.writeISZ(o.premises, writeExp)
      writer.writeISZ(o.conclusions, writeExp)
      writer.writeOption(o.proofOpt, writeLClauseProof)
    }

    def writeLClauseProof(o: LClause.Proof): Unit = {
      writer.writeZ(Constants.LClauseProof)
      writer.writeISZ(o.steps, writeProofStep)
    }

    def writeContractExp(o: ContractExp): Unit = {
      writer.writeZ(Constants.ContractExp)
      writer.writeOption(o.idOpt, writeId)
      writeExp(o.exp)
    }

    def writeCase(o: Case): Unit = {
      writer.writeZ(Constants.Case)
      writePattern(o.pattern)
      writer.writeOption(o.condOpt, writeExp)
      writeBody(o.body)
    }

    def writeEnumGenRange(o: EnumGen.Range): Unit = {
      o match {
        case o: EnumGen.Range.Expr => writeEnumGenRangeExpr(o)
        case o: EnumGen.Range.Indices => writeEnumGenRangeIndices(o)
        case o: EnumGen.Range.Step => writeEnumGenRangeStep(o)
      }
    }

    def writeEnumGenRangeExpr(o: EnumGen.Range.Expr): Unit = {
      writer.writeZ(Constants.EnumGenRangeExpr)
      writeB(o.isReverse)
      writeExp(o.exp)
    }

    def writeEnumGenRangeIndices(o: EnumGen.Range.Indices): Unit = {
      writer.writeZ(Constants.EnumGenRangeIndices)
      writeB(o.isReverse)
      writeExp(o.exp)
    }

    def writeEnumGenRangeStep(o: EnumGen.Range.Step): Unit = {
      writer.writeZ(Constants.EnumGenRangeStep)
      writeB(o.isInclusive)
      writeExp(o.start)
      writeExp(o.end)
      writer.writeOption(o.byOpt, writeExp)
    }

    def writeEnumGenFor(o: EnumGen.For): Unit = {
      writer.writeZ(Constants.EnumGenFor)
      writeId(o.id)
      writeEnumGenRange(o.range)
      writer.writeOption(o.condOpt, writeExp)
    }

    def writeType(o: Type): Unit = {
      o match {
        case o: Type.Named => writeTypeNamed(o)
        case o: Type.Fun => writeTypeFun(o)
        case o: Type.Tuple => writeTypeTuple(o)
      }
    }

    def writeTypeNamed(o: Type.Named): Unit = {
      writer.writeZ(Constants.TypeNamed)
      writeName(o.name)
      writer.writeISZ(o.typeArgs, writeType)
      writeTypedAttr(o.attr)
    }

    def writeTypeFun(o: Type.Fun): Unit = {
      writer.writeZ(Constants.TypeFun)
      writer.writeISZ(o.args, writeType)
      writeType(o.ret)
      writeTypedAttr(o.attr)
    }

    def writeTypeTuple(o: Type.Tuple): Unit = {
      writer.writeZ(Constants.TypeTuple)
      writer.writeISZ(o.args, writeType)
      writeTypedAttr(o.attr)
    }

    def writePattern(o: Pattern): Unit = {
      o match {
        case o: Pattern.Literal => writePatternLiteral(o)
        case o: Pattern.Ref => writePatternRef(o)
        case o: Pattern.Variable => writePatternVariable(o)
        case o: Pattern.Wildcard => writePatternWildcard(o)
        case o: Pattern.SeqWildcard => writePatternSeqWildcard(o)
        case o: Pattern.Structure => writePatternStructure(o)
      }
    }

    def writePatternLiteral(o: Pattern.Literal): Unit = {
      writer.writeZ(Constants.PatternLiteral)
      writeLit(o.lit)
    }

    def writePatternRef(o: Pattern.Ref): Unit = {
      writer.writeZ(Constants.PatternRef)
      writeName(o.name)
    }

    def writePatternVariable(o: Pattern.Variable): Unit = {
      writer.writeZ(Constants.PatternVariable)
      writeId(o.id)
      writer.writeOption(o.typeOpt, writeType)
    }

    def writePatternWildcard(o: Pattern.Wildcard): Unit = {
      writer.writeZ(Constants.PatternWildcard)
      writer.writeOption(o.typeOpt, writeType)
    }

    def writePatternSeqWildcard(o: Pattern.SeqWildcard): Unit = {
      writer.writeZ(Constants.PatternSeqWildcard)
    }

    def writePatternStructure(o: Pattern.Structure): Unit = {
      writer.writeZ(Constants.PatternStructure)
      writer.writeOption(o.idOpt, writeId)
      writer.writeOption(o.nameOpt, writeName)
      writer.writeISZ(o.patterns, writePattern)
    }

    def writeExp(o: Exp): Unit = {
      o match {
        case o: Exp.LitB => writeExpLitB(o)
        case o: Exp.LitC => writeExpLitC(o)
        case o: Exp.LitZ => writeExpLitZ(o)
        case o: Exp.LitF32 => writeExpLitF32(o)
        case o: Exp.LitF64 => writeExpLitF64(o)
        case o: Exp.LitR => writeExpLitR(o)
        case o: Exp.LitBv => writeExpLitBv(o)
        case o: Exp.LitString => writeExpLitString(o)
        case o: Exp.StringInterpolate => writeExpStringInterpolate(o)
        case o: Exp.This => writeExpThis(o)
        case o: Exp.Super => writeExpSuper(o)
        case o: Exp.Unary => writeExpUnary(o)
        case o: Exp.Binary => writeExpBinary(o)
        case o: Exp.Ident => writeExpIdent(o)
        case o: Exp.Eta => writeExpEta(o)
        case o: Exp.Tuple => writeExpTuple(o)
        case o: Exp.Select => writeExpSelect(o)
        case o: Exp.Invoke => writeExpInvoke(o)
        case o: Exp.InvokeNamed => writeExpInvokeNamed(o)
        case o: Exp.If => writeExpIf(o)
        case o: Exp.Fun => writeExpFun(o)
        case o: Exp.ForYield => writeExpForYield(o)
        case o: Exp.Quant => writeExpQuant(o)
      }
    }

    def writeLit(o: Lit): Unit = {
      o match {
        case o: Exp.LitB => writeExpLitB(o)
        case o: Exp.LitC => writeExpLitC(o)
        case o: Exp.LitZ => writeExpLitZ(o)
        case o: Exp.LitF32 => writeExpLitF32(o)
        case o: Exp.LitF64 => writeExpLitF64(o)
        case o: Exp.LitR => writeExpLitR(o)
        case o: Exp.LitBv => writeExpLitBv(o)
        case o: Exp.LitString => writeExpLitString(o)
      }
    }

    def writeExpLitB(o: Exp.LitB): Unit = {
      writer.writeZ(Constants.ExpLitB)
      writeB(o.value)
      writeAttr(o.attr)
    }

    def writeExpLitC(o: Exp.LitC): Unit = {
      writer.writeZ(Constants.ExpLitC)
      writeC(o.value)
      writeAttr(o.attr)
    }

    def writeExpLitZ(o: Exp.LitZ): Unit = {
      writer.writeZ(Constants.ExpLitZ)
      writeZ(o.value)
      writeAttr(o.attr)
    }

    def writeExpLitF32(o: Exp.LitF32): Unit = {
      writer.writeZ(Constants.ExpLitF32)
      writeF32(o.value)
      writeAttr(o.attr)
    }

    def writeExpLitF64(o: Exp.LitF64): Unit = {
      writer.writeZ(Constants.ExpLitF64)
      writeF64(o.value)
      writeAttr(o.attr)
    }

    def writeExpLitR(o: Exp.LitR): Unit = {
      writer.writeZ(Constants.ExpLitR)
      writeR(o.value)
      writeAttr(o.attr)
    }

    def writeExpLitBv(o: Exp.LitBv): Unit = {
      writer.writeZ(Constants.ExpLitBv)
      writer.writeISZ(o.value, writeB)
      writeType(o.tipe)
      writeAttr(o.attr)
    }

    def writeExpLitString(o: Exp.LitString): Unit = {
      writer.writeZ(Constants.ExpLitString)
      writeString(o.value)
      writeAttr(o.attr)
    }

    def writeExpStringInterpolate(o: Exp.StringInterpolate): Unit = {
      writer.writeZ(Constants.ExpStringInterpolate)
      writeString(o.prefix)
      writer.writeISZ(o.lits, writeExpLitString)
      writer.writeISZ(o.args, writeExp)
      writeAttr(o.attr)
    }

    def writeExpThis(o: Exp.This): Unit = {
      writer.writeZ(Constants.ExpThis)
      writeTypedAttr(o.attr)
    }

    def writeExpSuper(o: Exp.Super): Unit = {
      writer.writeZ(Constants.ExpSuper)
      writeTypedAttr(o.attr)
    }

    def writeExpUnaryOp(o: Exp.UnaryOp.Type): Unit = {
      writer.writeZ(o.ordinal)
    }

    def writeExpUnary(o: Exp.Unary): Unit = {
      writer.writeZ(Constants.ExpUnary)
      writeExpUnaryOp(o.op)
      writeExp(o.exp)
      writeTypedAttr(o.attr)
    }

    def writeExpBinaryOp(o: Exp.BinaryOp.Type): Unit = {
      writer.writeZ(o.ordinal)
    }

    def writeExpBinary(o: Exp.Binary): Unit = {
      writer.writeZ(Constants.ExpBinary)
      writeExp(o.left)
      writeExpBinaryOp(o.op)
      writeExp(o.right)
      writeTypedAttr(o.attr)
    }

    def writeExpIdent(o: Exp.Ident): Unit = {
      writer.writeZ(Constants.ExpIdent)
      writeId(o.id)
      writeResolvedAttr(o.attr)
    }

    def writeExpEta(o: Exp.Eta): Unit = {
      writer.writeZ(Constants.ExpEta)
      writeExp(o.exp)
      writeResolvedAttr(o.attr)
    }

    def writeExpTuple(o: Exp.Tuple): Unit = {
      writer.writeZ(Constants.ExpTuple)
      writer.writeISZ(o.args, writeExp)
      writeTypedAttr(o.attr)
    }

    def writeExpSelect(o: Exp.Select): Unit = {
      writer.writeZ(Constants.ExpSelect)
      writer.writeOption(o.receiverOpt, writeExp)
      writeId(o.id)
      writer.writeISZ(o.targs, writeType)
      writeResolvedAttr(o.attr)
    }

    def writeExpInvoke(o: Exp.Invoke): Unit = {
      writer.writeZ(Constants.ExpInvoke)
      writer.writeOption(o.receiverOpt, writeExp)
      writeId(o.id)
      writer.writeISZ(o.targs, writeType)
      writer.writeISZ(o.args, writeExp)
      writeResolvedAttr(o.attr)
    }

    def writeExpInvokeNamed(o: Exp.InvokeNamed): Unit = {
      writer.writeZ(Constants.ExpInvokeNamed)
      writer.writeOption(o.receiverOpt, writeExp)
      writeId(o.id)
      writer.writeISZ(o.targs, writeType)
      writer.writeISZ(o.args, writeNamedArg)
      writeResolvedAttr(o.attr)
    }

    def writeExpIf(o: Exp.If): Unit = {
      writer.writeZ(Constants.ExpIf)
      writeExp(o.cond)
      writeExp(o.thenExp)
      writeExp(o.elseExp)
      writeTypedAttr(o.attr)
    }

    def writeExpFun(o: Exp.Fun): Unit = {
      writer.writeZ(Constants.ExpFun)
      writer.writeISZ(o.params, writeParam)
      writeExp(o.exp)
      writeTypedAttr(o.attr)
    }

    def writeExpForYield(o: Exp.ForYield): Unit = {
      writer.writeZ(Constants.ExpForYield)
      writer.writeISZ(o.enumGens, writeEnumGenFor)
      writeExp(o.exp)
      writeTypedAttr(o.attr)
    }

    def writeExpQuant(o: Exp.Quant): Unit = {
      writer.writeZ(Constants.ExpQuant)
      writeB(o.isForall)
      writer.writeISZ(o.varFragments, writeVarFragment)
      writeExp(o.exp)
      writeAttr(o.attr)
    }

    def writeNamedArg(o: NamedArg): Unit = {
      writer.writeZ(Constants.NamedArg)
      writeId(o.id)
      writeExp(o.arg)
    }

    def writeVarFragment(o: VarFragment): Unit = {
      writer.writeZ(Constants.VarFragment)
      writer.writeISZ(o.ids, writeId)
      writer.writeOption(o.domainOpt, writeDomain)
    }

    def writeDomain(o: Domain): Unit = {
      o match {
        case o: Domain.Type => writeDomainType(o)
        case o: Domain.Range => writeDomainRange(o)
      }
    }

    def writeDomainType(o: Domain.Type): Unit = {
      writer.writeZ(Constants.DomainType)
      writeType(o.tipe)
      writeTypedAttr(o.attr)
    }

    def writeDomainRange(o: Domain.Range): Unit = {
      writer.writeZ(Constants.DomainRange)
      writeExp(o.lo)
      writeB(o.loExact)
      writeExp(o.hi)
      writeB(o.hiExact)
      writeTypedAttr(o.attr)
    }

    def writeId(o: Id): Unit = {
      writer.writeZ(Constants.Id)
      writeString(o.value)
      writeAttr(o.attr)
    }

    def writeName(o: Name): Unit = {
      writer.writeZ(Constants.Name)
      writer.writeISZ(o.ids, writeId)
      writeAttr(o.attr)
    }

    def writeBody(o: Body): Unit = {
      writer.writeZ(Constants.Body)
      writer.writeISZ(o.stmts, writeStmt)
    }

    def writeAbstractDatatypeParam(o: AbstractDatatypeParam): Unit = {
      writer.writeZ(Constants.AbstractDatatypeParam)
      writeB(o.isHidden)
      writeB(o.isPure)
      writeId(o.id)
      writeType(o.tipe)
    }

    def writeMethodSig(o: MethodSig): Unit = {
      writer.writeZ(Constants.MethodSig)
      writeId(o.id)
      writer.writeISZ(o.typeParams, writeTypeParam)
      writeB(o.hasParams)
      writer.writeISZ(o.params, writeParam)
      writeType(o.returnType)
    }

    def writeParamMod(o: ParamMod.Type): Unit = {
      writer.writeZ(o.ordinal)
    }

    def writeParam(o: Param): Unit = {
      writer.writeZ(Constants.Param)
      writeParamMod(o.mod)
      writeId(o.id)
      writeType(o.tipe)
    }

    def writeTypeParam(o: TypeParam): Unit = {
      writer.writeZ(Constants.TypeParam)
      writeId(o.id)
    }

    def writeContract(o: Contract): Unit = {
      writer.writeZ(Constants.Contract)
      writer.writeISZ(o.reads, writeExp)
      writer.writeISZ(o.requires, writeContractExp)
      writer.writeISZ(o.modifies, writeExp)
      writer.writeISZ(o.ensures, writeContractExp)
      writer.writeISZ(o.subs, writeSubContract)
    }

    def writeSubContract(o: SubContract): Unit = {
      writer.writeZ(Constants.SubContract)
      writeId(o.id)
      writer.writeISZ(o.params, writeSubContractParam)
      writeContract(o.contract)
    }

    def writeSubContractParam(o: SubContractParam): Unit = {
      writer.writeZ(Constants.SubContractParam)
      writeB(o.isPure)
      writeId(o.id)
    }

    def writeWhereDef(o: WhereDef): Unit = {
      o match {
        case o: WhereDef.Val => writeWhereDefVal(o)
        case o: WhereDef.Def => writeWhereDefDef(o)
      }
    }

    def writeWhereDefVal(o: WhereDef.Val): Unit = {
      writer.writeZ(Constants.WhereDefVal)
      writeId(o.id)
      writeType(o.tipe)
      writeExp(o.exp)
    }

    def writeWhereDefDef(o: WhereDef.Def): Unit = {
      writer.writeZ(Constants.WhereDefDef)
      writeId(o.id)
      writer.writeISZ(o.params, writeParam)
      writeType(o.rTipe)
      writer.writeISZ(o.defs, writeSpecDef)
    }

    def writeSpecDef(o: SpecDef): Unit = {
      writer.writeZ(Constants.SpecDef)
      writer.writeOption(o.idOpt, writeId)
      writeExp(o.exp)
      writeB(o.isOtherwise)
      writer.writeOption(o.patternOpt, writePattern)
      writer.writeOption(o.guardOpt, writeExp)
    }

    def writeProofStep(o: ProofStep): Unit = {
      o match {
        case o: ProofStep.Basic => writeProofStepBasic(o)
        case o: ProofStep.SubProof => writeProofStepSubProof(o)
      }
    }

    def writeProofStepBasic(o: ProofStep.Basic): Unit = {
      writer.writeZ(Constants.ProofStepBasic)
      writeExpLitZ(o.step)
      writeExp(o.exp)
      writeJust(o.just)
    }

    def writeProofStepSubProof(o: ProofStep.SubProof): Unit = {
      writer.writeZ(Constants.ProofStepSubProof)
      writeExpLitZ(o.step)
      writeAssumeProofStep(o.assumeStep)
      writer.writeISZ(o.steps, writeProofStep)
    }

    def writeAssumeProofStep(o: AssumeProofStep): Unit = {
      o match {
        case o: AssumeProofStep.Regular => writeAssumeProofStepRegular(o)
        case o: AssumeProofStep.ForallIntroAps => writeAssumeProofStepForallIntroAps(o)
        case o: AssumeProofStep.ExistsElimAps => writeAssumeProofStepExistsElimAps(o)
      }
    }

    def writeAssumeProofStepRegular(o: AssumeProofStep.Regular): Unit = {
      writer.writeZ(Constants.AssumeProofStepRegular)
      writeExpLitZ(o.step)
      writeExp(o.exp)
    }

    def writeAssumeProofStepForallIntroAps(o: AssumeProofStep.ForallIntroAps): Unit = {
      writer.writeZ(Constants.AssumeProofStepForallIntroAps)
      writeExpLitZ(o.step)
      writer.writeISZ(o.varFragments, writeVarFragment)
    }

    def writeAssumeProofStepExistsElimAps(o: AssumeProofStep.ExistsElimAps): Unit = {
      writer.writeZ(Constants.AssumeProofStepExistsElimAps)
      writeExpLitZ(o.step)
      writer.writeISZ(o.varFragments, writeVarFragment)
      writeExp(o.exp)
    }

    def writeJust(o: Just): Unit = {
      o match {
        case o: Just.Premise => writeJustPremise(o)
        case o: Just.AndIntro => writeJustAndIntro(o)
        case o: Just.AndElim => writeJustAndElim(o)
        case o: Just.OrIntro => writeJustOrIntro(o)
        case o: Just.OrElim => writeJustOrElim(o)
        case o: Just.ImplyIntro => writeJustImplyIntro(o)
        case o: Just.ImplyElim => writeJustImplyElim(o)
        case o: Just.NegIntro => writeJustNegIntro(o)
        case o: Just.NegElim => writeJustNegElim(o)
        case o: Just.BottomElim => writeJustBottomElim(o)
        case o: Just.Pbc => writeJustPbc(o)
        case o: Just.ForallIntro => writeJustForallIntro(o)
        case o: Just.ForallElim => writeJustForallElim(o)
        case o: Just.ExistsIntro => writeJustExistsIntro(o)
        case o: Just.ExistsElim => writeJustExistsElim(o)
        case o: Just.Fact => writeJustFact(o)
        case o: Just.Invariant => writeJustInvariant(o)
        case o: Just.Subst => writeJustSubst(o)
        case o: Just.Auto => writeJustAuto(o)
        case o: Just.Coq => writeJustCoq(o)
      }
    }

    def writeJustPremise(o: Just.Premise): Unit = {
      writer.writeZ(Constants.JustPremise)
      writeAttr(o.attr)
    }

    def writeJustAndIntro(o: Just.AndIntro): Unit = {
      writer.writeZ(Constants.JustAndIntro)
      writer.writeISZ(o.steps, writeExpLitZ)
      writeAttr(o.attr)
    }

    def writeJustAndElim(o: Just.AndElim): Unit = {
      writer.writeZ(Constants.JustAndElim)
      writeB(o.is1)
      writeExpLitZ(o.andStep)
      writeAttr(o.attr)
    }

    def writeJustOrIntro(o: Just.OrIntro): Unit = {
      writer.writeZ(Constants.JustOrIntro)
      writeB(o.is1)
      writeExpLitZ(o.step)
      writeAttr(o.attr)
    }

    def writeJustOrElim(o: Just.OrElim): Unit = {
      writer.writeZ(Constants.JustOrElim)
      writeExpLitZ(o.orStep)
      writer.writeISZ(o.subProofSteps, writeExpLitZ)
      writeAttr(o.attr)
    }

    def writeJustImplyIntro(o: Just.ImplyIntro): Unit = {
      writer.writeZ(Constants.JustImplyIntro)
      writeExpLitZ(o.subProofStep)
      writeAttr(o.attr)
    }

    def writeJustImplyElim(o: Just.ImplyElim): Unit = {
      writer.writeZ(Constants.JustImplyElim)
      writeExpLitZ(o.implyStep)
      writer.writeISZ(o.steps, writeExpLitZ)
      writeAttr(o.attr)
    }

    def writeJustNegIntro(o: Just.NegIntro): Unit = {
      writer.writeZ(Constants.JustNegIntro)
      writeExpLitZ(o.subProofStep)
      writeAttr(o.attr)
    }

    def writeJustNegElim(o: Just.NegElim): Unit = {
      writer.writeZ(Constants.JustNegElim)
      writeExpLitZ(o.step)
      writeExpLitZ(o.negStep)
      writeAttr(o.attr)
    }

    def writeJustBottomElim(o: Just.BottomElim): Unit = {
      writer.writeZ(Constants.JustBottomElim)
      writeExpLitZ(o.subProofStep)
      writeAttr(o.attr)
    }

    def writeJustPbc(o: Just.Pbc): Unit = {
      writer.writeZ(Constants.JustPbc)
      writeExpLitZ(o.subProofStep)
      writeAttr(o.attr)
    }

    def writeJustForallIntro(o: Just.ForallIntro): Unit = {
      writer.writeZ(Constants.JustForallIntro)
      writeExpLitZ(o.subProofStep)
      writeAttr(o.attr)
    }

    def writeJustForallElim(o: Just.ForallElim): Unit = {
      writer.writeZ(Constants.JustForallElim)
      writeExpLitZ(o.forallStep)
      writer.writeISZ(o.args, writeExp)
      writeAttr(o.attr)
    }

    def writeJustExistsIntro(o: Just.ExistsIntro): Unit = {
      writer.writeZ(Constants.JustExistsIntro)
      writeExpLitZ(o.existsStep)
      writer.writeISZ(o.args, writeExp)
      writeAttr(o.attr)
    }

    def writeJustExistsElim(o: Just.ExistsElim): Unit = {
      writer.writeZ(Constants.JustExistsElim)
      writeExpLitZ(o.existsStep)
      writeExpLitZ(o.subProofStep)
      writeAttr(o.attr)
    }

    def writeJustFact(o: Just.Fact): Unit = {
      writer.writeZ(Constants.JustFact)
      writeName(o.name)
      writeAttr(o.attr)
    }

    def writeJustInvariant(o: Just.Invariant): Unit = {
      writer.writeZ(Constants.JustInvariant)
      writer.writeOption(o.nameOpt, writeName)
      writeAttr(o.attr)
    }

    def writeJustSubst(o: Just.Subst): Unit = {
      writer.writeZ(Constants.JustSubst)
      writeB(o.isRight)
      writeExpLitZ(o.eqStep)
      writeExpLitZ(o.step)
      writeAttr(o.attr)
    }

    def writeJustAuto(o: Just.Auto): Unit = {
      writer.writeZ(Constants.JustAuto)
      writeB(o.isAlgebra)
      writer.writeISZ(o.steps, writeExpLitZ)
      writeAttr(o.attr)
    }

    def writeJustCoq(o: Just.Coq): Unit = {
      writer.writeZ(Constants.JustCoq)
      writeExpLitString(o.path)
      writer.writeISZ(o.steps, writeExpLitZ)
      writeAttr(o.attr)
    }

    def writeTruthTableRow(o: TruthTable.Row): Unit = {
      writer.writeZ(Constants.TruthTableRow)
      writeTruthTableAssignment(o.assignment)
      writePosInfo(o.separator)
      writeTruthTableAssignment(o.values)
    }

    def writeTruthTableAssignment(o: TruthTable.Assignment): Unit = {
      writer.writeZ(Constants.TruthTableAssignment)
      writer.writeISZ(o.values, writeExpLitB)
      writeAttr(o.attr)
    }

    def writeTruthTableConclusion(o: TruthTable.Conclusion): Unit = {
      o match {
        case o: TruthTable.Conclusion.Validity => writeTruthTableConclusionValidity(o)
        case o: TruthTable.Conclusion.Tautology => writeTruthTableConclusionTautology(o)
        case o: TruthTable.Conclusion.Contradictory => writeTruthTableConclusionContradictory(o)
        case o: TruthTable.Conclusion.Contingent => writeTruthTableConclusionContingent(o)
      }
    }

    def writeTruthTableConclusionValidity(o: TruthTable.Conclusion.Validity): Unit = {
      writer.writeZ(Constants.TruthTableConclusionValidity)
      writeB(o.isValid)
      writer.writeISZ(o.assignments, writeTruthTableAssignment)
      writeAttr(o.attr)
    }

    def writeTruthTableConclusionTautology(o: TruthTable.Conclusion.Tautology): Unit = {
      writer.writeZ(Constants.TruthTableConclusionTautology)
      writeAttr(o.attr)
    }

    def writeTruthTableConclusionContradictory(o: TruthTable.Conclusion.Contradictory): Unit = {
      writer.writeZ(Constants.TruthTableConclusionContradictory)
      writeAttr(o.attr)
    }

    def writeTruthTableConclusionContingent(o: TruthTable.Conclusion.Contingent): Unit = {
      writer.writeZ(Constants.TruthTableConclusionContingent)
      writer.writeISZ(o.trueAssignments, writeTruthTableAssignment)
      writer.writeISZ(o.falseAssignments, writeTruthTableAssignment)
      writeAttr(o.attr)
    }

    def writeTyped(o: Typed): Unit = {
      o match {
        case o: Typed.Name => writeTypedName(o)
        case o: Typed.Tuple => writeTypedTuple(o)
        case o: Typed.Fun => writeTypedFun(o)
      }
    }

    def writeTypedName(o: Typed.Name): Unit = {
      writer.writeZ(Constants.TypedName)
      writer.writeISZ(o.ids, writeString)
      writer.writeISZ(o.args, writeTyped)
      writer.writeOption(o.posOpt, writePosInfo)
    }

    def writeTypedTuple(o: Typed.Tuple): Unit = {
      writer.writeZ(Constants.TypedTuple)
      writer.writeISZ(o.args, writeTyped)
      writer.writeOption(o.posOpt, writePosInfo)
    }

    def writeTypedFun(o: Typed.Fun): Unit = {
      writer.writeZ(Constants.TypedFun)
      writer.writeISZ(o.args, writeTyped)
      writeTyped(o.ret)
      writer.writeOption(o.posOpt, writePosInfo)
    }

    def writeAttr(o: Attr): Unit = {
      writer.writeZ(Constants.Attr)
      writer.writeOption(o.posOpt, writePosInfo)
    }

    def writeTypedAttr(o: TypedAttr): Unit = {
      writer.writeZ(Constants.TypedAttr)
      writer.writeOption(o.posOpt, writePosInfo)
      writer.writeOption(o.typedOpt, writeTyped)
    }

    def writeResolvedAttr(o: ResolvedAttr): Unit = {
      writer.writeZ(Constants.ResolvedAttr)
      writer.writeOption(o.posOpt, writePosInfo)
      writer.writeOption(o.resOpt, writeResolvedInfo)
      writer.writeOption(o.typedOpt, writeTyped)
    }

    def writeResolvedInfo(o: ResolvedInfo): Unit = {
      writer.writeZ(Constants.ResolvedInfo)
      writeSymbolKind(o.kind)
      writer.writeISZ(o.ids, writeString)
      writer.writeOption(o.externFileUriOpt, writeString)
    }

    def writeSymbolKind(o: SymbolKind.Type): Unit = {
      writer.writeZ(o.ordinal)
    }

    def writePosInfo(o: PosInfo): Unit = {
      writer.writeZ(Constants.PosInfo)
      writer.writeOption(o.fileUriOpt, writeString)
      writeZ(o.beginLine)
      writeZ(o.beginColumn)
      writeZ(o.endLine)
      writeZ(o.endColumn)
      writeZ(o.offset)
      writeZ(o.length)
    }

    def writeB(b: B): Unit = {
      writer.writeB(b)
    }

    def writeC(c: C): Unit = {
      writer.writeC(c)
    }

    def writeZ(n: Z): Unit = {
      writer.writeZ(n)
    }

    def writeZ8(n: Z8): Unit = {
      writer.writeZ8(n)
    }

    def writeZ16(n: Z16): Unit = {
      writer.writeZ16(n)
    }

    def writeZ32(n: Z32): Unit = {
      writer.writeZ32(n)
    }

    def writeZ64(n: Z64): Unit = {
      writer.writeZ64(n)
    }

    def writeN(n: N): Unit = {
      writer.writeN(n)
    }

    def writeN8(n: N8): Unit = {
      writer.writeN8(n)
    }

    def writeN16(n: N16): Unit = {
      writer.writeN16(n)
    }

    def writeN32(n: N32): Unit = {
      writer.writeN32(n)
    }

    def writeN64(n: N64): Unit = {
      writer.writeN64(n)
    }

    def writeS8(n: S8): Unit = {
      writer.writeS8(n)
    }

    def writeS16(n: S16): Unit = {
      writer.writeS16(n)
    }

    def writeS32(n: S32): Unit = {
      writer.writeS32(n)
    }

    def writeS64(n: S64): Unit = {
      writer.writeS64(n)
    }

    def writeU8(n: U8): Unit = {
      writer.writeU8(n)
    }

    def writeU16(n: U16): Unit = {
      writer.writeU16(n)
    }

    def writeU32(n: U32): Unit = {
      writer.writeU32(n)
    }

    def writeU64(n: U64): Unit = {
      writer.writeU64(n)
    }

    def writeR(n: R): Unit = {
      writer.writeR(n)
    }

    def writeF32(n: F32): Unit = {
      writer.writeF32(n)
    }

    def writeF64(n: F64): Unit = {
      writer.writeF64(n)
    }

    def writeString(s: String): Unit = {
      writer.writeString(s)
    }

    def result: ISZ[U8] = {
      return writer.result
    }

    def resultBase64: String = {
      return writer.resultBase64
    }

  }

  @record class Reader(reader: MessagePack.Reader) {

    def readTopUnit(): TopUnit = {
      val t = reader.readZ()
      t match {
        case Constants.TopUnitProgram => val r = readTopUnitProgramT(T); return r
        case Constants.TopUnitSequentUnit => val r = readTopUnitSequentUnitT(T); return r
        case Constants.TopUnitTruthTableUnit => val r = readTopUnitTruthTableUnitT(T); return r
        case _ => halt(s"Unexpected type code $t.")
      }
    }

    def readTopUnitProgram(): TopUnit.Program = {
      val r = readTopUnitProgramT(F)
      return r
    }

    def readTopUnitProgramT(typeParsed: B): TopUnit.Program = {
      if (!typeParsed) {
        reader.expectZ(Constants.TopUnitProgram)
      }
      val fileUriOpt = reader.readOption(reader.readString _)
      val packageName = readName()
      val body = readBody()
      return TopUnit.Program(fileUriOpt, packageName, body)
    }

    def readTopUnitSequentUnit(): TopUnit.SequentUnit = {
      val r = readTopUnitSequentUnitT(F)
      return r
    }

    def readTopUnitSequentUnitT(typeParsed: B): TopUnit.SequentUnit = {
      if (!typeParsed) {
        reader.expectZ(Constants.TopUnitSequentUnit)
      }
      val fileUriOpt = reader.readOption(reader.readString _)
      val sequent = readLClauseSequent()
      return TopUnit.SequentUnit(fileUriOpt, sequent)
    }

    def readTopUnitTruthTableUnit(): TopUnit.TruthTableUnit = {
      val r = readTopUnitTruthTableUnitT(F)
      return r
    }

    def readTopUnitTruthTableUnitT(typeParsed: B): TopUnit.TruthTableUnit = {
      if (!typeParsed) {
        reader.expectZ(Constants.TopUnitTruthTableUnit)
      }
      val fileUriOpt = reader.readOption(reader.readString _)
      val stars = reader.readISZ(readPosInfo _)
      val vars = reader.readISZ(readId _)
      val separator = readPosInfo()
      val isSequent = reader.readB()
      val sequent = readLClauseSequent()
      val rows = reader.readISZ(readTruthTableRow _)
      val conclusionOpt = reader.readOption(readTruthTableConclusion _)
      return TopUnit.TruthTableUnit(fileUriOpt, stars, vars, separator, isSequent, sequent, rows, conclusionOpt)
    }

    def readStmt(): Stmt = {
      val t = reader.readZ()
      t match {
        case Constants.StmtImport => val r = readStmtImportT(T); return r
        case Constants.StmtVar => val r = readStmtVarT(T); return r
        case Constants.StmtVarPattern => val r = readStmtVarPatternT(T); return r
        case Constants.StmtSpecVar => val r = readStmtSpecVarT(T); return r
        case Constants.StmtMethod => val r = readStmtMethodT(T); return r
        case Constants.StmtExtMethod => val r = readStmtExtMethodT(T); return r
        case Constants.StmtSpecMethod => val r = readStmtSpecMethodT(T); return r
        case Constants.StmtEnum => val r = readStmtEnumT(T); return r
        case Constants.StmtSubZ => val r = readStmtSubZT(T); return r
        case Constants.StmtObject => val r = readStmtObjectT(T); return r
        case Constants.StmtSig => val r = readStmtSigT(T); return r
        case Constants.StmtAbstractDatatype => val r = readStmtAbstractDatatypeT(T); return r
        case Constants.StmtTypeAlias => val r = readStmtTypeAliasT(T); return r
        case Constants.StmtAssign => val r = readStmtAssignT(T); return r
        case Constants.StmtAssignUp => val r = readStmtAssignUpT(T); return r
        case Constants.StmtAssignPattern => val r = readStmtAssignPatternT(T); return r
        case Constants.StmtBlock => val r = readStmtBlockT(T); return r
        case Constants.StmtIf => val r = readStmtIfT(T); return r
        case Constants.StmtMatch => val r = readStmtMatchT(T); return r
        case Constants.StmtWhile => val r = readStmtWhileT(T); return r
        case Constants.StmtDoWhile => val r = readStmtDoWhileT(T); return r
        case Constants.StmtFor => val r = readStmtForT(T); return r
        case Constants.StmtReturn => val r = readStmtReturnT(T); return r
        case Constants.StmtLStmt => val r = readStmtLStmtT(T); return r
        case Constants.StmtExpr => val r = readStmtExprT(T); return r
        case _ => halt(s"Unexpected type code $t.")
      }
    }

    def readAssignExp(): AssignExp = {
      val t = reader.readZ()
      t match {
        case Constants.StmtBlock => val r = readStmtBlockT(T); return r
        case Constants.StmtIf => val r = readStmtIfT(T); return r
        case Constants.StmtMatch => val r = readStmtMatchT(T); return r
        case Constants.StmtExpr => val r = readStmtExprT(T); return r
        case _ => halt(s"Unexpected type code $t.")
      }
    }

    def readPurity(): Purity.Type = {
      val r = reader.readZ()
      return Purity.byOrdinal(r).get
    }

    def readStmtImport(): Stmt.Import = {
      val r = readStmtImportT(F)
      return r
    }

    def readStmtImportT(typeParsed: B): Stmt.Import = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtImport)
      }
      val importers = reader.readISZ(readStmtImportImporter _)
      val attr = readAttr()
      return Stmt.Import(importers, attr)
    }

    def readStmtImportImporter(): Stmt.Import.Importer = {
      val r = readStmtImportImporterT(F)
      return r
    }

    def readStmtImportImporterT(typeParsed: B): Stmt.Import.Importer = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtImportImporter)
      }
      val name = readName()
      val selectorOpt = reader.readOption(readStmtImportSelector _)
      return Stmt.Import.Importer(name, selectorOpt)
    }

    def readStmtImportSelector(): Stmt.Import.Selector = {
      val t = reader.readZ()
      t match {
        case Constants.StmtImportMultiSelector => val r = readStmtImportMultiSelectorT(T); return r
        case Constants.StmtImportWildcardSelector => val r = readStmtImportWildcardSelectorT(T); return r
        case _ => halt(s"Unexpected type code $t.")
      }
    }

    def readStmtImportMultiSelector(): Stmt.Import.MultiSelector = {
      val r = readStmtImportMultiSelectorT(F)
      return r
    }

    def readStmtImportMultiSelectorT(typeParsed: B): Stmt.Import.MultiSelector = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtImportMultiSelector)
      }
      val selectors = reader.readISZ(readStmtImportNamedSelector _)
      return Stmt.Import.MultiSelector(selectors)
    }

    def readStmtImportWildcardSelector(): Stmt.Import.WildcardSelector = {
      val r = readStmtImportWildcardSelectorT(F)
      return r
    }

    def readStmtImportWildcardSelectorT(typeParsed: B): Stmt.Import.WildcardSelector = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtImportWildcardSelector)
      }
      return Stmt.Import.WildcardSelector()
    }

    def readStmtImportNamedSelector(): Stmt.Import.NamedSelector = {
      val r = readStmtImportNamedSelectorT(F)
      return r
    }

    def readStmtImportNamedSelectorT(typeParsed: B): Stmt.Import.NamedSelector = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtImportNamedSelector)
      }
      val from = readId()
      val to = readId()
      return Stmt.Import.NamedSelector(from, to)
    }

    def readStmtVar(): Stmt.Var = {
      val r = readStmtVarT(F)
      return r
    }

    def readStmtVarT(typeParsed: B): Stmt.Var = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtVar)
      }
      val isVal = reader.readB()
      val id = readId()
      val tipeOpt = reader.readOption(readType _)
      val initOpt = reader.readOption(readAssignExp _)
      val attr = readAttr()
      return Stmt.Var(isVal, id, tipeOpt, initOpt, attr)
    }

    def readStmtVarPattern(): Stmt.VarPattern = {
      val r = readStmtVarPatternT(F)
      return r
    }

    def readStmtVarPatternT(typeParsed: B): Stmt.VarPattern = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtVarPattern)
      }
      val isVal = reader.readB()
      val pattern = readPattern()
      val init = readAssignExp()
      val attr = readAttr()
      return Stmt.VarPattern(isVal, pattern, init, attr)
    }

    def readStmtSpecVar(): Stmt.SpecVar = {
      val r = readStmtSpecVarT(F)
      return r
    }

    def readStmtSpecVarT(typeParsed: B): Stmt.SpecVar = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtSpecVar)
      }
      val isVal = reader.readB()
      val id = readId()
      val tipe = readType()
      val attr = readAttr()
      return Stmt.SpecVar(isVal, id, tipe, attr)
    }

    def readStmtMethod(): Stmt.Method = {
      val r = readStmtMethodT(F)
      return r
    }

    def readStmtMethodT(typeParsed: B): Stmt.Method = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtMethod)
      }
      val purity = readPurity()
      val hasOverride = reader.readB()
      val isHelper = reader.readB()
      val sig = readMethodSig()
      val contract = readContract()
      val bodyOpt = reader.readOption(readBody _)
      val attr = readAttr()
      return Stmt.Method(purity, hasOverride, isHelper, sig, contract, bodyOpt, attr)
    }

    def readStmtExtMethod(): Stmt.ExtMethod = {
      val r = readStmtExtMethodT(F)
      return r
    }

    def readStmtExtMethodT(typeParsed: B): Stmt.ExtMethod = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtExtMethod)
      }
      val isPure = reader.readB()
      val sig = readMethodSig()
      val contract = readContract()
      val attr = readAttr()
      return Stmt.ExtMethod(isPure, sig, contract, attr)
    }

    def readStmtSpecMethod(): Stmt.SpecMethod = {
      val r = readStmtSpecMethodT(F)
      return r
    }

    def readStmtSpecMethodT(typeParsed: B): Stmt.SpecMethod = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtSpecMethod)
      }
      val sig = readMethodSig()
      val defs = reader.readISZ(readSpecDef _)
      val where = reader.readISZ(readWhereDef _)
      val attr = readAttr()
      return Stmt.SpecMethod(sig, defs, where, attr)
    }

    def readStmtEnum(): Stmt.Enum = {
      val r = readStmtEnumT(F)
      return r
    }

    def readStmtEnumT(typeParsed: B): Stmt.Enum = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtEnum)
      }
      val id = readId()
      val elements = reader.readISZ(readId _)
      val attr = readAttr()
      return Stmt.Enum(id, elements, attr)
    }

    def readStmtSubZ(): Stmt.SubZ = {
      val r = readStmtSubZT(F)
      return r
    }

    def readStmtSubZT(typeParsed: B): Stmt.SubZ = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtSubZ)
      }
      val id = readId()
      val isSigned = reader.readB()
      val isBitVector = reader.readB()
      val isWrapped = reader.readB()
      val hasMin = reader.readB()
      val hasMax = reader.readB()
      val bitWidth = reader.readZ()
      val min = reader.readZ()
      val max = reader.readZ()
      val index = reader.readZ()
      val attr = readAttr()
      return Stmt.SubZ(id, isSigned, isBitVector, isWrapped, hasMin, hasMax, bitWidth, min, max, index, attr)
    }

    def readStmtObject(): Stmt.Object = {
      val r = readStmtObjectT(F)
      return r
    }

    def readStmtObjectT(typeParsed: B): Stmt.Object = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtObject)
      }
      val isExt = reader.readB()
      val id = readId()
      val parents = reader.readISZ(readType _)
      val stmts = reader.readISZ(readStmt _)
      val attr = readAttr()
      return Stmt.Object(isExt, id, parents, stmts, attr)
    }

    def readStmtSig(): Stmt.Sig = {
      val r = readStmtSigT(F)
      return r
    }

    def readStmtSigT(typeParsed: B): Stmt.Sig = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtSig)
      }
      val isImmutable = reader.readB()
      val isExt = reader.readB()
      val id = readId()
      val typeParams = reader.readISZ(readTypeParam _)
      val parents = reader.readISZ(readTypeNamed _)
      val selfTypeOpt = reader.readOption(readType _)
      val stmts = reader.readISZ(readStmt _)
      val attr = readAttr()
      return Stmt.Sig(isImmutable, isExt, id, typeParams, parents, selfTypeOpt, stmts, attr)
    }

    def readStmtAbstractDatatype(): Stmt.AbstractDatatype = {
      val r = readStmtAbstractDatatypeT(F)
      return r
    }

    def readStmtAbstractDatatypeT(typeParsed: B): Stmt.AbstractDatatype = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtAbstractDatatype)
      }
      val isRoot = reader.readB()
      val isDatatype = reader.readB()
      val id = readId()
      val typeParams = reader.readISZ(readTypeParam _)
      val params = reader.readISZ(readAbstractDatatypeParam _)
      val parents = reader.readISZ(readTypeNamed _)
      val stmts = reader.readISZ(readStmt _)
      val attr = readAttr()
      return Stmt.AbstractDatatype(isRoot, isDatatype, id, typeParams, params, parents, stmts, attr)
    }

    def readStmtTypeAlias(): Stmt.TypeAlias = {
      val r = readStmtTypeAliasT(F)
      return r
    }

    def readStmtTypeAliasT(typeParsed: B): Stmt.TypeAlias = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtTypeAlias)
      }
      val id = readId()
      val typeParams = reader.readISZ(readTypeParam _)
      val tipe = readType()
      val attr = readAttr()
      return Stmt.TypeAlias(id, typeParams, tipe, attr)
    }

    def readStmtAssign(): Stmt.Assign = {
      val r = readStmtAssignT(F)
      return r
    }

    def readStmtAssignT(typeParsed: B): Stmt.Assign = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtAssign)
      }
      val lhs = readExp()
      val rhs = readAssignExp()
      val attr = readAttr()
      return Stmt.Assign(lhs, rhs, attr)
    }

    def readStmtAssignUp(): Stmt.AssignUp = {
      val r = readStmtAssignUpT(F)
      return r
    }

    def readStmtAssignUpT(typeParsed: B): Stmt.AssignUp = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtAssignUp)
      }
      val lhs = readExp()
      val rhs = readAssignExp()
      val attr = readAttr()
      return Stmt.AssignUp(lhs, rhs, attr)
    }

    def readStmtAssignPattern(): Stmt.AssignPattern = {
      val r = readStmtAssignPatternT(F)
      return r
    }

    def readStmtAssignPatternT(typeParsed: B): Stmt.AssignPattern = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtAssignPattern)
      }
      val lhs = readPattern()
      val rhs = readAssignExp()
      val attr = readAttr()
      return Stmt.AssignPattern(lhs, rhs, attr)
    }

    def readStmtBlock(): Stmt.Block = {
      val r = readStmtBlockT(F)
      return r
    }

    def readStmtBlockT(typeParsed: B): Stmt.Block = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtBlock)
      }
      val body = readBody()
      val attr = readAttr()
      return Stmt.Block(body, attr)
    }

    def readStmtIf(): Stmt.If = {
      val r = readStmtIfT(F)
      return r
    }

    def readStmtIfT(typeParsed: B): Stmt.If = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtIf)
      }
      val cond = readExp()
      val thenbody = readBody()
      val elsebody = readBody()
      val attr = readAttr()
      return Stmt.If(cond, thenbody, elsebody, attr)
    }

    def readStmtMatch(): Stmt.Match = {
      val r = readStmtMatchT(F)
      return r
    }

    def readStmtMatchT(typeParsed: B): Stmt.Match = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtMatch)
      }
      val cond = readExp()
      val cases = reader.readISZ(readCase _)
      val attr = readAttr()
      return Stmt.Match(cond, cases, attr)
    }

    def readStmtWhile(): Stmt.While = {
      val r = readStmtWhileT(F)
      return r
    }

    def readStmtWhileT(typeParsed: B): Stmt.While = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtWhile)
      }
      val cond = readExp()
      val invariants = reader.readISZ(readContractExp _)
      val modifies = reader.readISZ(readExp _)
      val body = readBody()
      val attr = readAttr()
      return Stmt.While(cond, invariants, modifies, body, attr)
    }

    def readStmtDoWhile(): Stmt.DoWhile = {
      val r = readStmtDoWhileT(F)
      return r
    }

    def readStmtDoWhileT(typeParsed: B): Stmt.DoWhile = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtDoWhile)
      }
      val cond = readExp()
      val invariants = reader.readISZ(readContractExp _)
      val modifies = reader.readISZ(readExp _)
      val body = readBody()
      val attr = readAttr()
      return Stmt.DoWhile(cond, invariants, modifies, body, attr)
    }

    def readStmtFor(): Stmt.For = {
      val r = readStmtForT(F)
      return r
    }

    def readStmtForT(typeParsed: B): Stmt.For = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtFor)
      }
      val enumGen = readEnumGenFor()
      val invariants = reader.readISZ(readContractExp _)
      val modifies = reader.readISZ(readExp _)
      val body = readBody()
      val attr = readAttr()
      return Stmt.For(enumGen, invariants, modifies, body, attr)
    }

    def readStmtReturn(): Stmt.Return = {
      val r = readStmtReturnT(F)
      return r
    }

    def readStmtReturnT(typeParsed: B): Stmt.Return = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtReturn)
      }
      val expOpt = reader.readOption(readExp _)
      val attr = readAttr()
      return Stmt.Return(expOpt, attr)
    }

    def readStmtLStmt(): Stmt.LStmt = {
      val r = readStmtLStmtT(F)
      return r
    }

    def readStmtLStmtT(typeParsed: B): Stmt.LStmt = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtLStmt)
      }
      val clause = readLClause()
      val attr = readAttr()
      return Stmt.LStmt(clause, attr)
    }

    def readStmtExpr(): Stmt.Expr = {
      val r = readStmtExprT(F)
      return r
    }

    def readStmtExprT(typeParsed: B): Stmt.Expr = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtExpr)
      }
      val exp = readExp()
      val attr = readAttr()
      return Stmt.Expr(exp, attr)
    }

    def readLClause(): LClause = {
      val t = reader.readZ()
      t match {
        case Constants.LClauseInvariants => val r = readLClauseInvariantsT(T); return r
        case Constants.LClauseFacts => val r = readLClauseFactsT(T); return r
        case Constants.LClauseTheorems => val r = readLClauseTheoremsT(T); return r
        case Constants.LClauseSequent => val r = readLClauseSequentT(T); return r
        case Constants.LClauseProof => val r = readLClauseProofT(T); return r
        case _ => halt(s"Unexpected type code $t.")
      }
    }

    def readLClauseInvariants(): LClause.Invariants = {
      val r = readLClauseInvariantsT(F)
      return r
    }

    def readLClauseInvariantsT(typeParsed: B): LClause.Invariants = {
      if (!typeParsed) {
        reader.expectZ(Constants.LClauseInvariants)
      }
      val value = reader.readISZ(readContractExp _)
      return LClause.Invariants(value)
    }

    def readLClauseFacts(): LClause.Facts = {
      val r = readLClauseFactsT(F)
      return r
    }

    def readLClauseFactsT(typeParsed: B): LClause.Facts = {
      if (!typeParsed) {
        reader.expectZ(Constants.LClauseFacts)
      }
      val value = reader.readISZ(readLClauseFact _)
      return LClause.Facts(value)
    }

    def readLClauseFact(): LClause.Fact = {
      val r = readLClauseFactT(F)
      return r
    }

    def readLClauseFactT(typeParsed: B): LClause.Fact = {
      if (!typeParsed) {
        reader.expectZ(Constants.LClauseFact)
      }
      val id = readId()
      val exp = readExp()
      return LClause.Fact(id, exp)
    }

    def readLClauseTheorems(): LClause.Theorems = {
      val r = readLClauseTheoremsT(F)
      return r
    }

    def readLClauseTheoremsT(typeParsed: B): LClause.Theorems = {
      if (!typeParsed) {
        reader.expectZ(Constants.LClauseTheorems)
      }
      val value = reader.readISZ(readLClauseTheorem _)
      return LClause.Theorems(value)
    }

    def readLClauseTheorem(): LClause.Theorem = {
      val r = readLClauseTheoremT(F)
      return r
    }

    def readLClauseTheoremT(typeParsed: B): LClause.Theorem = {
      if (!typeParsed) {
        reader.expectZ(Constants.LClauseTheorem)
      }
      val id = readId()
      val sequent = readLClauseSequent()
      return LClause.Theorem(id, sequent)
    }

    def readLClauseSequent(): LClause.Sequent = {
      val r = readLClauseSequentT(F)
      return r
    }

    def readLClauseSequentT(typeParsed: B): LClause.Sequent = {
      if (!typeParsed) {
        reader.expectZ(Constants.LClauseSequent)
      }
      val premises = reader.readISZ(readExp _)
      val conclusions = reader.readISZ(readExp _)
      val proofOpt = reader.readOption(readLClauseProof _)
      return LClause.Sequent(premises, conclusions, proofOpt)
    }

    def readLClauseProof(): LClause.Proof = {
      val r = readLClauseProofT(F)
      return r
    }

    def readLClauseProofT(typeParsed: B): LClause.Proof = {
      if (!typeParsed) {
        reader.expectZ(Constants.LClauseProof)
      }
      val steps = reader.readISZ(readProofStep _)
      return LClause.Proof(steps)
    }

    def readContractExp(): ContractExp = {
      val r = readContractExpT(F)
      return r
    }

    def readContractExpT(typeParsed: B): ContractExp = {
      if (!typeParsed) {
        reader.expectZ(Constants.ContractExp)
      }
      val idOpt = reader.readOption(readId _)
      val exp = readExp()
      return ContractExp(idOpt, exp)
    }

    def readCase(): Case = {
      val r = readCaseT(F)
      return r
    }

    def readCaseT(typeParsed: B): Case = {
      if (!typeParsed) {
        reader.expectZ(Constants.Case)
      }
      val pattern = readPattern()
      val condOpt = reader.readOption(readExp _)
      val body = readBody()
      return Case(pattern, condOpt, body)
    }

    def readEnumGenRange(): EnumGen.Range = {
      val t = reader.readZ()
      t match {
        case Constants.EnumGenRangeExpr => val r = readEnumGenRangeExprT(T); return r
        case Constants.EnumGenRangeIndices => val r = readEnumGenRangeIndicesT(T); return r
        case Constants.EnumGenRangeStep => val r = readEnumGenRangeStepT(T); return r
        case _ => halt(s"Unexpected type code $t.")
      }
    }

    def readEnumGenRangeExpr(): EnumGen.Range.Expr = {
      val r = readEnumGenRangeExprT(F)
      return r
    }

    def readEnumGenRangeExprT(typeParsed: B): EnumGen.Range.Expr = {
      if (!typeParsed) {
        reader.expectZ(Constants.EnumGenRangeExpr)
      }
      val isReverse = reader.readB()
      val exp = readExp()
      return EnumGen.Range.Expr(isReverse, exp)
    }

    def readEnumGenRangeIndices(): EnumGen.Range.Indices = {
      val r = readEnumGenRangeIndicesT(F)
      return r
    }

    def readEnumGenRangeIndicesT(typeParsed: B): EnumGen.Range.Indices = {
      if (!typeParsed) {
        reader.expectZ(Constants.EnumGenRangeIndices)
      }
      val isReverse = reader.readB()
      val exp = readExp()
      return EnumGen.Range.Indices(isReverse, exp)
    }

    def readEnumGenRangeStep(): EnumGen.Range.Step = {
      val r = readEnumGenRangeStepT(F)
      return r
    }

    def readEnumGenRangeStepT(typeParsed: B): EnumGen.Range.Step = {
      if (!typeParsed) {
        reader.expectZ(Constants.EnumGenRangeStep)
      }
      val isInclusive = reader.readB()
      val start = readExp()
      val end = readExp()
      val byOpt = reader.readOption(readExp _)
      return EnumGen.Range.Step(isInclusive, start, end, byOpt)
    }

    def readEnumGenFor(): EnumGen.For = {
      val r = readEnumGenForT(F)
      return r
    }

    def readEnumGenForT(typeParsed: B): EnumGen.For = {
      if (!typeParsed) {
        reader.expectZ(Constants.EnumGenFor)
      }
      val id = readId()
      val range = readEnumGenRange()
      val condOpt = reader.readOption(readExp _)
      return EnumGen.For(id, range, condOpt)
    }

    def readType(): Type = {
      val t = reader.readZ()
      t match {
        case Constants.TypeNamed => val r = readTypeNamedT(T); return r
        case Constants.TypeFun => val r = readTypeFunT(T); return r
        case Constants.TypeTuple => val r = readTypeTupleT(T); return r
        case _ => halt(s"Unexpected type code $t.")
      }
    }

    def readTypeNamed(): Type.Named = {
      val r = readTypeNamedT(F)
      return r
    }

    def readTypeNamedT(typeParsed: B): Type.Named = {
      if (!typeParsed) {
        reader.expectZ(Constants.TypeNamed)
      }
      val name = readName()
      val typeArgs = reader.readISZ(readType _)
      val attr = readTypedAttr()
      return Type.Named(name, typeArgs, attr)
    }

    def readTypeFun(): Type.Fun = {
      val r = readTypeFunT(F)
      return r
    }

    def readTypeFunT(typeParsed: B): Type.Fun = {
      if (!typeParsed) {
        reader.expectZ(Constants.TypeFun)
      }
      val args = reader.readISZ(readType _)
      val ret = readType()
      val attr = readTypedAttr()
      return Type.Fun(args, ret, attr)
    }

    def readTypeTuple(): Type.Tuple = {
      val r = readTypeTupleT(F)
      return r
    }

    def readTypeTupleT(typeParsed: B): Type.Tuple = {
      if (!typeParsed) {
        reader.expectZ(Constants.TypeTuple)
      }
      val args = reader.readISZ(readType _)
      val attr = readTypedAttr()
      return Type.Tuple(args, attr)
    }

    def readPattern(): Pattern = {
      val t = reader.readZ()
      t match {
        case Constants.PatternLiteral => val r = readPatternLiteralT(T); return r
        case Constants.PatternRef => val r = readPatternRefT(T); return r
        case Constants.PatternVariable => val r = readPatternVariableT(T); return r
        case Constants.PatternWildcard => val r = readPatternWildcardT(T); return r
        case Constants.PatternSeqWildcard => val r = readPatternSeqWildcardT(T); return r
        case Constants.PatternStructure => val r = readPatternStructureT(T); return r
        case _ => halt(s"Unexpected type code $t.")
      }
    }

    def readPatternLiteral(): Pattern.Literal = {
      val r = readPatternLiteralT(F)
      return r
    }

    def readPatternLiteralT(typeParsed: B): Pattern.Literal = {
      if (!typeParsed) {
        reader.expectZ(Constants.PatternLiteral)
      }
      val lit = readLit()
      return Pattern.Literal(lit)
    }

    def readPatternRef(): Pattern.Ref = {
      val r = readPatternRefT(F)
      return r
    }

    def readPatternRefT(typeParsed: B): Pattern.Ref = {
      if (!typeParsed) {
        reader.expectZ(Constants.PatternRef)
      }
      val name = readName()
      return Pattern.Ref(name)
    }

    def readPatternVariable(): Pattern.Variable = {
      val r = readPatternVariableT(F)
      return r
    }

    def readPatternVariableT(typeParsed: B): Pattern.Variable = {
      if (!typeParsed) {
        reader.expectZ(Constants.PatternVariable)
      }
      val id = readId()
      val typeOpt = reader.readOption(readType _)
      return Pattern.Variable(id, typeOpt)
    }

    def readPatternWildcard(): Pattern.Wildcard = {
      val r = readPatternWildcardT(F)
      return r
    }

    def readPatternWildcardT(typeParsed: B): Pattern.Wildcard = {
      if (!typeParsed) {
        reader.expectZ(Constants.PatternWildcard)
      }
      val typeOpt = reader.readOption(readType _)
      return Pattern.Wildcard(typeOpt)
    }

    def readPatternSeqWildcard(): Pattern.SeqWildcard = {
      val r = readPatternSeqWildcardT(F)
      return r
    }

    def readPatternSeqWildcardT(typeParsed: B): Pattern.SeqWildcard = {
      if (!typeParsed) {
        reader.expectZ(Constants.PatternSeqWildcard)
      }
      return Pattern.SeqWildcard()
    }

    def readPatternStructure(): Pattern.Structure = {
      val r = readPatternStructureT(F)
      return r
    }

    def readPatternStructureT(typeParsed: B): Pattern.Structure = {
      if (!typeParsed) {
        reader.expectZ(Constants.PatternStructure)
      }
      val idOpt = reader.readOption(readId _)
      val nameOpt = reader.readOption(readName _)
      val patterns = reader.readISZ(readPattern _)
      return Pattern.Structure(idOpt, nameOpt, patterns)
    }

    def readExp(): Exp = {
      val t = reader.readZ()
      t match {
        case Constants.ExpLitB => val r = readExpLitBT(T); return r
        case Constants.ExpLitC => val r = readExpLitCT(T); return r
        case Constants.ExpLitZ => val r = readExpLitZT(T); return r
        case Constants.ExpLitF32 => val r = readExpLitF32T(T); return r
        case Constants.ExpLitF64 => val r = readExpLitF64T(T); return r
        case Constants.ExpLitR => val r = readExpLitRT(T); return r
        case Constants.ExpLitBv => val r = readExpLitBvT(T); return r
        case Constants.ExpLitString => val r = readExpLitStringT(T); return r
        case Constants.ExpStringInterpolate => val r = readExpStringInterpolateT(T); return r
        case Constants.ExpThis => val r = readExpThisT(T); return r
        case Constants.ExpSuper => val r = readExpSuperT(T); return r
        case Constants.ExpUnary => val r = readExpUnaryT(T); return r
        case Constants.ExpBinary => val r = readExpBinaryT(T); return r
        case Constants.ExpIdent => val r = readExpIdentT(T); return r
        case Constants.ExpEta => val r = readExpEtaT(T); return r
        case Constants.ExpTuple => val r = readExpTupleT(T); return r
        case Constants.ExpSelect => val r = readExpSelectT(T); return r
        case Constants.ExpInvoke => val r = readExpInvokeT(T); return r
        case Constants.ExpInvokeNamed => val r = readExpInvokeNamedT(T); return r
        case Constants.ExpIf => val r = readExpIfT(T); return r
        case Constants.ExpFun => val r = readExpFunT(T); return r
        case Constants.ExpForYield => val r = readExpForYieldT(T); return r
        case Constants.ExpQuant => val r = readExpQuantT(T); return r
        case _ => halt(s"Unexpected type code $t.")
      }
    }

    def readLit(): Lit = {
      val t = reader.readZ()
      t match {
        case Constants.ExpLitB => val r = readExpLitBT(T); return r
        case Constants.ExpLitC => val r = readExpLitCT(T); return r
        case Constants.ExpLitZ => val r = readExpLitZT(T); return r
        case Constants.ExpLitF32 => val r = readExpLitF32T(T); return r
        case Constants.ExpLitF64 => val r = readExpLitF64T(T); return r
        case Constants.ExpLitR => val r = readExpLitRT(T); return r
        case Constants.ExpLitBv => val r = readExpLitBvT(T); return r
        case Constants.ExpLitString => val r = readExpLitStringT(T); return r
        case _ => halt(s"Unexpected type code $t.")
      }
    }

    def readExpLitB(): Exp.LitB = {
      val r = readExpLitBT(F)
      return r
    }

    def readExpLitBT(typeParsed: B): Exp.LitB = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpLitB)
      }
      val value = reader.readB()
      val attr = readAttr()
      return Exp.LitB(value, attr)
    }

    def readExpLitC(): Exp.LitC = {
      val r = readExpLitCT(F)
      return r
    }

    def readExpLitCT(typeParsed: B): Exp.LitC = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpLitC)
      }
      val value = reader.readC()
      val attr = readAttr()
      return Exp.LitC(value, attr)
    }

    def readExpLitZ(): Exp.LitZ = {
      val r = readExpLitZT(F)
      return r
    }

    def readExpLitZT(typeParsed: B): Exp.LitZ = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpLitZ)
      }
      val value = reader.readZ()
      val attr = readAttr()
      return Exp.LitZ(value, attr)
    }

    def readExpLitF32(): Exp.LitF32 = {
      val r = readExpLitF32T(F)
      return r
    }

    def readExpLitF32T(typeParsed: B): Exp.LitF32 = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpLitF32)
      }
      val value = reader.readF32()
      val attr = readAttr()
      return Exp.LitF32(value, attr)
    }

    def readExpLitF64(): Exp.LitF64 = {
      val r = readExpLitF64T(F)
      return r
    }

    def readExpLitF64T(typeParsed: B): Exp.LitF64 = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpLitF64)
      }
      val value = reader.readF64()
      val attr = readAttr()
      return Exp.LitF64(value, attr)
    }

    def readExpLitR(): Exp.LitR = {
      val r = readExpLitRT(F)
      return r
    }

    def readExpLitRT(typeParsed: B): Exp.LitR = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpLitR)
      }
      val value = reader.readR()
      val attr = readAttr()
      return Exp.LitR(value, attr)
    }

    def readExpLitBv(): Exp.LitBv = {
      val r = readExpLitBvT(F)
      return r
    }

    def readExpLitBvT(typeParsed: B): Exp.LitBv = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpLitBv)
      }
      val value = reader.readISZ(reader.readB _)
      val tipe = readType()
      val attr = readAttr()
      return Exp.LitBv(value, tipe, attr)
    }

    def readExpLitString(): Exp.LitString = {
      val r = readExpLitStringT(F)
      return r
    }

    def readExpLitStringT(typeParsed: B): Exp.LitString = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpLitString)
      }
      val value = reader.readString()
      val attr = readAttr()
      return Exp.LitString(value, attr)
    }

    def readExpStringInterpolate(): Exp.StringInterpolate = {
      val r = readExpStringInterpolateT(F)
      return r
    }

    def readExpStringInterpolateT(typeParsed: B): Exp.StringInterpolate = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpStringInterpolate)
      }
      val prefix = reader.readString()
      val lits = reader.readISZ(readExpLitString _)
      val args = reader.readISZ(readExp _)
      val attr = readAttr()
      return Exp.StringInterpolate(prefix, lits, args, attr)
    }

    def readExpThis(): Exp.This = {
      val r = readExpThisT(F)
      return r
    }

    def readExpThisT(typeParsed: B): Exp.This = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpThis)
      }
      val attr = readTypedAttr()
      return Exp.This(attr)
    }

    def readExpSuper(): Exp.Super = {
      val r = readExpSuperT(F)
      return r
    }

    def readExpSuperT(typeParsed: B): Exp.Super = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpSuper)
      }
      val attr = readTypedAttr()
      return Exp.Super(attr)
    }

    def readExpUnaryOp(): Exp.UnaryOp.Type = {
      val r = reader.readZ()
      return Exp.UnaryOp.byOrdinal(r).get
    }

    def readExpUnary(): Exp.Unary = {
      val r = readExpUnaryT(F)
      return r
    }

    def readExpUnaryT(typeParsed: B): Exp.Unary = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpUnary)
      }
      val op = readExpUnaryOp()
      val exp = readExp()
      val attr = readTypedAttr()
      return Exp.Unary(op, exp, attr)
    }

    def readExpBinaryOp(): Exp.BinaryOp.Type = {
      val r = reader.readZ()
      return Exp.BinaryOp.byOrdinal(r).get
    }

    def readExpBinary(): Exp.Binary = {
      val r = readExpBinaryT(F)
      return r
    }

    def readExpBinaryT(typeParsed: B): Exp.Binary = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpBinary)
      }
      val left = readExp()
      val op = readExpBinaryOp()
      val right = readExp()
      val attr = readTypedAttr()
      return Exp.Binary(left, op, right, attr)
    }

    def readExpIdent(): Exp.Ident = {
      val r = readExpIdentT(F)
      return r
    }

    def readExpIdentT(typeParsed: B): Exp.Ident = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpIdent)
      }
      val id = readId()
      val attr = readResolvedAttr()
      return Exp.Ident(id, attr)
    }

    def readExpEta(): Exp.Eta = {
      val r = readExpEtaT(F)
      return r
    }

    def readExpEtaT(typeParsed: B): Exp.Eta = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpEta)
      }
      val exp = readExp()
      val attr = readResolvedAttr()
      return Exp.Eta(exp, attr)
    }

    def readExpTuple(): Exp.Tuple = {
      val r = readExpTupleT(F)
      return r
    }

    def readExpTupleT(typeParsed: B): Exp.Tuple = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpTuple)
      }
      val args = reader.readISZ(readExp _)
      val attr = readTypedAttr()
      return Exp.Tuple(args, attr)
    }

    def readExpSelect(): Exp.Select = {
      val r = readExpSelectT(F)
      return r
    }

    def readExpSelectT(typeParsed: B): Exp.Select = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpSelect)
      }
      val receiverOpt = reader.readOption(readExp _)
      val id = readId()
      val targs = reader.readISZ(readType _)
      val attr = readResolvedAttr()
      return Exp.Select(receiverOpt, id, targs, attr)
    }

    def readExpInvoke(): Exp.Invoke = {
      val r = readExpInvokeT(F)
      return r
    }

    def readExpInvokeT(typeParsed: B): Exp.Invoke = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpInvoke)
      }
      val receiverOpt = reader.readOption(readExp _)
      val id = readId()
      val targs = reader.readISZ(readType _)
      val args = reader.readISZ(readExp _)
      val attr = readResolvedAttr()
      return Exp.Invoke(receiverOpt, id, targs, args, attr)
    }

    def readExpInvokeNamed(): Exp.InvokeNamed = {
      val r = readExpInvokeNamedT(F)
      return r
    }

    def readExpInvokeNamedT(typeParsed: B): Exp.InvokeNamed = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpInvokeNamed)
      }
      val receiverOpt = reader.readOption(readExp _)
      val id = readId()
      val targs = reader.readISZ(readType _)
      val args = reader.readISZ(readNamedArg _)
      val attr = readResolvedAttr()
      return Exp.InvokeNamed(receiverOpt, id, targs, args, attr)
    }

    def readExpIf(): Exp.If = {
      val r = readExpIfT(F)
      return r
    }

    def readExpIfT(typeParsed: B): Exp.If = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpIf)
      }
      val cond = readExp()
      val thenExp = readExp()
      val elseExp = readExp()
      val attr = readTypedAttr()
      return Exp.If(cond, thenExp, elseExp, attr)
    }

    def readExpFun(): Exp.Fun = {
      val r = readExpFunT(F)
      return r
    }

    def readExpFunT(typeParsed: B): Exp.Fun = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpFun)
      }
      val params = reader.readISZ(readParam _)
      val exp = readExp()
      val attr = readTypedAttr()
      return Exp.Fun(params, exp, attr)
    }

    def readExpForYield(): Exp.ForYield = {
      val r = readExpForYieldT(F)
      return r
    }

    def readExpForYieldT(typeParsed: B): Exp.ForYield = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpForYield)
      }
      val enumGens = reader.readISZ(readEnumGenFor _)
      val exp = readExp()
      val attr = readTypedAttr()
      return Exp.ForYield(enumGens, exp, attr)
    }

    def readExpQuant(): Exp.Quant = {
      val r = readExpQuantT(F)
      return r
    }

    def readExpQuantT(typeParsed: B): Exp.Quant = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpQuant)
      }
      val isForall = reader.readB()
      val varFragments = reader.readISZ(readVarFragment _)
      val exp = readExp()
      val attr = readAttr()
      return Exp.Quant(isForall, varFragments, exp, attr)
    }

    def readNamedArg(): NamedArg = {
      val r = readNamedArgT(F)
      return r
    }

    def readNamedArgT(typeParsed: B): NamedArg = {
      if (!typeParsed) {
        reader.expectZ(Constants.NamedArg)
      }
      val id = readId()
      val arg = readExp()
      return NamedArg(id, arg)
    }

    def readVarFragment(): VarFragment = {
      val r = readVarFragmentT(F)
      return r
    }

    def readVarFragmentT(typeParsed: B): VarFragment = {
      if (!typeParsed) {
        reader.expectZ(Constants.VarFragment)
      }
      val ids = reader.readISZ(readId _)
      val domainOpt = reader.readOption(readDomain _)
      return VarFragment(ids, domainOpt)
    }

    def readDomain(): Domain = {
      val t = reader.readZ()
      t match {
        case Constants.DomainType => val r = readDomainTypeT(T); return r
        case Constants.DomainRange => val r = readDomainRangeT(T); return r
        case _ => halt(s"Unexpected type code $t.")
      }
    }

    def readDomainType(): Domain.Type = {
      val r = readDomainTypeT(F)
      return r
    }

    def readDomainTypeT(typeParsed: B): Domain.Type = {
      if (!typeParsed) {
        reader.expectZ(Constants.DomainType)
      }
      val tipe = readType()
      val attr = readTypedAttr()
      return Domain.Type(tipe, attr)
    }

    def readDomainRange(): Domain.Range = {
      val r = readDomainRangeT(F)
      return r
    }

    def readDomainRangeT(typeParsed: B): Domain.Range = {
      if (!typeParsed) {
        reader.expectZ(Constants.DomainRange)
      }
      val lo = readExp()
      val loExact = reader.readB()
      val hi = readExp()
      val hiExact = reader.readB()
      val attr = readTypedAttr()
      return Domain.Range(lo, loExact, hi, hiExact, attr)
    }

    def readId(): Id = {
      val r = readIdT(F)
      return r
    }

    def readIdT(typeParsed: B): Id = {
      if (!typeParsed) {
        reader.expectZ(Constants.Id)
      }
      val value = reader.readString()
      val attr = readAttr()
      return Id(value, attr)
    }

    def readName(): Name = {
      val r = readNameT(F)
      return r
    }

    def readNameT(typeParsed: B): Name = {
      if (!typeParsed) {
        reader.expectZ(Constants.Name)
      }
      val ids = reader.readISZ(readId _)
      val attr = readAttr()
      return Name(ids, attr)
    }

    def readBody(): Body = {
      val r = readBodyT(F)
      return r
    }

    def readBodyT(typeParsed: B): Body = {
      if (!typeParsed) {
        reader.expectZ(Constants.Body)
      }
      val stmts = reader.readISZ(readStmt _)
      return Body(stmts)
    }

    def readAbstractDatatypeParam(): AbstractDatatypeParam = {
      val r = readAbstractDatatypeParamT(F)
      return r
    }

    def readAbstractDatatypeParamT(typeParsed: B): AbstractDatatypeParam = {
      if (!typeParsed) {
        reader.expectZ(Constants.AbstractDatatypeParam)
      }
      val isHidden = reader.readB()
      val isPure = reader.readB()
      val id = readId()
      val tipe = readType()
      return AbstractDatatypeParam(isHidden, isPure, id, tipe)
    }

    def readMethodSig(): MethodSig = {
      val r = readMethodSigT(F)
      return r
    }

    def readMethodSigT(typeParsed: B): MethodSig = {
      if (!typeParsed) {
        reader.expectZ(Constants.MethodSig)
      }
      val id = readId()
      val typeParams = reader.readISZ(readTypeParam _)
      val hasParams = reader.readB()
      val params = reader.readISZ(readParam _)
      val returnType = readType()
      return MethodSig(id, typeParams, hasParams, params, returnType)
    }

    def readParamMod(): ParamMod.Type = {
      val r = reader.readZ()
      return ParamMod.byOrdinal(r).get
    }

    def readParam(): Param = {
      val r = readParamT(F)
      return r
    }

    def readParamT(typeParsed: B): Param = {
      if (!typeParsed) {
        reader.expectZ(Constants.Param)
      }
      val mod = readParamMod()
      val id = readId()
      val tipe = readType()
      return Param(mod, id, tipe)
    }

    def readTypeParam(): TypeParam = {
      val r = readTypeParamT(F)
      return r
    }

    def readTypeParamT(typeParsed: B): TypeParam = {
      if (!typeParsed) {
        reader.expectZ(Constants.TypeParam)
      }
      val id = readId()
      return TypeParam(id)
    }

    def readContract(): Contract = {
      val r = readContractT(F)
      return r
    }

    def readContractT(typeParsed: B): Contract = {
      if (!typeParsed) {
        reader.expectZ(Constants.Contract)
      }
      val reads = reader.readISZ(readExp _)
      val requires = reader.readISZ(readContractExp _)
      val modifies = reader.readISZ(readExp _)
      val ensures = reader.readISZ(readContractExp _)
      val subs = reader.readISZ(readSubContract _)
      return Contract(reads, requires, modifies, ensures, subs)
    }

    def readSubContract(): SubContract = {
      val r = readSubContractT(F)
      return r
    }

    def readSubContractT(typeParsed: B): SubContract = {
      if (!typeParsed) {
        reader.expectZ(Constants.SubContract)
      }
      val id = readId()
      val params = reader.readISZ(readSubContractParam _)
      val contract = readContract()
      return SubContract(id, params, contract)
    }

    def readSubContractParam(): SubContractParam = {
      val r = readSubContractParamT(F)
      return r
    }

    def readSubContractParamT(typeParsed: B): SubContractParam = {
      if (!typeParsed) {
        reader.expectZ(Constants.SubContractParam)
      }
      val isPure = reader.readB()
      val id = readId()
      return SubContractParam(isPure, id)
    }

    def readWhereDef(): WhereDef = {
      val t = reader.readZ()
      t match {
        case Constants.WhereDefVal => val r = readWhereDefValT(T); return r
        case Constants.WhereDefDef => val r = readWhereDefDefT(T); return r
        case _ => halt(s"Unexpected type code $t.")
      }
    }

    def readWhereDefVal(): WhereDef.Val = {
      val r = readWhereDefValT(F)
      return r
    }

    def readWhereDefValT(typeParsed: B): WhereDef.Val = {
      if (!typeParsed) {
        reader.expectZ(Constants.WhereDefVal)
      }
      val id = readId()
      val tipe = readType()
      val exp = readExp()
      return WhereDef.Val(id, tipe, exp)
    }

    def readWhereDefDef(): WhereDef.Def = {
      val r = readWhereDefDefT(F)
      return r
    }

    def readWhereDefDefT(typeParsed: B): WhereDef.Def = {
      if (!typeParsed) {
        reader.expectZ(Constants.WhereDefDef)
      }
      val id = readId()
      val params = reader.readISZ(readParam _)
      val rTipe = readType()
      val defs = reader.readISZ(readSpecDef _)
      return WhereDef.Def(id, params, rTipe, defs)
    }

    def readSpecDef(): SpecDef = {
      val r = readSpecDefT(F)
      return r
    }

    def readSpecDefT(typeParsed: B): SpecDef = {
      if (!typeParsed) {
        reader.expectZ(Constants.SpecDef)
      }
      val idOpt = reader.readOption(readId _)
      val exp = readExp()
      val isOtherwise = reader.readB()
      val patternOpt = reader.readOption(readPattern _)
      val guardOpt = reader.readOption(readExp _)
      return SpecDef(idOpt, exp, isOtherwise, patternOpt, guardOpt)
    }

    def readProofStep(): ProofStep = {
      val t = reader.readZ()
      t match {
        case Constants.ProofStepBasic => val r = readProofStepBasicT(T); return r
        case Constants.ProofStepSubProof => val r = readProofStepSubProofT(T); return r
        case _ => halt(s"Unexpected type code $t.")
      }
    }

    def readProofStepBasic(): ProofStep.Basic = {
      val r = readProofStepBasicT(F)
      return r
    }

    def readProofStepBasicT(typeParsed: B): ProofStep.Basic = {
      if (!typeParsed) {
        reader.expectZ(Constants.ProofStepBasic)
      }
      val step = readExpLitZ()
      val exp = readExp()
      val just = readJust()
      return ProofStep.Basic(step, exp, just)
    }

    def readProofStepSubProof(): ProofStep.SubProof = {
      val r = readProofStepSubProofT(F)
      return r
    }

    def readProofStepSubProofT(typeParsed: B): ProofStep.SubProof = {
      if (!typeParsed) {
        reader.expectZ(Constants.ProofStepSubProof)
      }
      val step = readExpLitZ()
      val assumeStep = readAssumeProofStep()
      val steps = reader.readISZ(readProofStep _)
      return ProofStep.SubProof(step, assumeStep, steps)
    }

    def readAssumeProofStep(): AssumeProofStep = {
      val t = reader.readZ()
      t match {
        case Constants.AssumeProofStepRegular => val r = readAssumeProofStepRegularT(T); return r
        case Constants.AssumeProofStepForallIntroAps => val r = readAssumeProofStepForallIntroApsT(T); return r
        case Constants.AssumeProofStepExistsElimAps => val r = readAssumeProofStepExistsElimApsT(T); return r
        case _ => halt(s"Unexpected type code $t.")
      }
    }

    def readAssumeProofStepRegular(): AssumeProofStep.Regular = {
      val r = readAssumeProofStepRegularT(F)
      return r
    }

    def readAssumeProofStepRegularT(typeParsed: B): AssumeProofStep.Regular = {
      if (!typeParsed) {
        reader.expectZ(Constants.AssumeProofStepRegular)
      }
      val step = readExpLitZ()
      val exp = readExp()
      return AssumeProofStep.Regular(step, exp)
    }

    def readAssumeProofStepForallIntroAps(): AssumeProofStep.ForallIntroAps = {
      val r = readAssumeProofStepForallIntroApsT(F)
      return r
    }

    def readAssumeProofStepForallIntroApsT(typeParsed: B): AssumeProofStep.ForallIntroAps = {
      if (!typeParsed) {
        reader.expectZ(Constants.AssumeProofStepForallIntroAps)
      }
      val step = readExpLitZ()
      val varFragments = reader.readISZ(readVarFragment _)
      return AssumeProofStep.ForallIntroAps(step, varFragments)
    }

    def readAssumeProofStepExistsElimAps(): AssumeProofStep.ExistsElimAps = {
      val r = readAssumeProofStepExistsElimApsT(F)
      return r
    }

    def readAssumeProofStepExistsElimApsT(typeParsed: B): AssumeProofStep.ExistsElimAps = {
      if (!typeParsed) {
        reader.expectZ(Constants.AssumeProofStepExistsElimAps)
      }
      val step = readExpLitZ()
      val varFragments = reader.readISZ(readVarFragment _)
      val exp = readExp()
      return AssumeProofStep.ExistsElimAps(step, varFragments, exp)
    }

    def readJust(): Just = {
      val t = reader.readZ()
      t match {
        case Constants.JustPremise => val r = readJustPremiseT(T); return r
        case Constants.JustAndIntro => val r = readJustAndIntroT(T); return r
        case Constants.JustAndElim => val r = readJustAndElimT(T); return r
        case Constants.JustOrIntro => val r = readJustOrIntroT(T); return r
        case Constants.JustOrElim => val r = readJustOrElimT(T); return r
        case Constants.JustImplyIntro => val r = readJustImplyIntroT(T); return r
        case Constants.JustImplyElim => val r = readJustImplyElimT(T); return r
        case Constants.JustNegIntro => val r = readJustNegIntroT(T); return r
        case Constants.JustNegElim => val r = readJustNegElimT(T); return r
        case Constants.JustBottomElim => val r = readJustBottomElimT(T); return r
        case Constants.JustPbc => val r = readJustPbcT(T); return r
        case Constants.JustForallIntro => val r = readJustForallIntroT(T); return r
        case Constants.JustForallElim => val r = readJustForallElimT(T); return r
        case Constants.JustExistsIntro => val r = readJustExistsIntroT(T); return r
        case Constants.JustExistsElim => val r = readJustExistsElimT(T); return r
        case Constants.JustFact => val r = readJustFactT(T); return r
        case Constants.JustInvariant => val r = readJustInvariantT(T); return r
        case Constants.JustSubst => val r = readJustSubstT(T); return r
        case Constants.JustAuto => val r = readJustAutoT(T); return r
        case Constants.JustCoq => val r = readJustCoqT(T); return r
        case _ => halt(s"Unexpected type code $t.")
      }
    }

    def readJustPremise(): Just.Premise = {
      val r = readJustPremiseT(F)
      return r
    }

    def readJustPremiseT(typeParsed: B): Just.Premise = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustPremise)
      }
      val attr = readAttr()
      return Just.Premise(attr)
    }

    def readJustAndIntro(): Just.AndIntro = {
      val r = readJustAndIntroT(F)
      return r
    }

    def readJustAndIntroT(typeParsed: B): Just.AndIntro = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustAndIntro)
      }
      val steps = reader.readISZ(readExpLitZ _)
      val attr = readAttr()
      return Just.AndIntro(steps, attr)
    }

    def readJustAndElim(): Just.AndElim = {
      val r = readJustAndElimT(F)
      return r
    }

    def readJustAndElimT(typeParsed: B): Just.AndElim = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustAndElim)
      }
      val is1 = reader.readB()
      val andStep = readExpLitZ()
      val attr = readAttr()
      return Just.AndElim(is1, andStep, attr)
    }

    def readJustOrIntro(): Just.OrIntro = {
      val r = readJustOrIntroT(F)
      return r
    }

    def readJustOrIntroT(typeParsed: B): Just.OrIntro = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustOrIntro)
      }
      val is1 = reader.readB()
      val step = readExpLitZ()
      val attr = readAttr()
      return Just.OrIntro(is1, step, attr)
    }

    def readJustOrElim(): Just.OrElim = {
      val r = readJustOrElimT(F)
      return r
    }

    def readJustOrElimT(typeParsed: B): Just.OrElim = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustOrElim)
      }
      val orStep = readExpLitZ()
      val subProofSteps = reader.readISZ(readExpLitZ _)
      val attr = readAttr()
      return Just.OrElim(orStep, subProofSteps, attr)
    }

    def readJustImplyIntro(): Just.ImplyIntro = {
      val r = readJustImplyIntroT(F)
      return r
    }

    def readJustImplyIntroT(typeParsed: B): Just.ImplyIntro = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustImplyIntro)
      }
      val subProofStep = readExpLitZ()
      val attr = readAttr()
      return Just.ImplyIntro(subProofStep, attr)
    }

    def readJustImplyElim(): Just.ImplyElim = {
      val r = readJustImplyElimT(F)
      return r
    }

    def readJustImplyElimT(typeParsed: B): Just.ImplyElim = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustImplyElim)
      }
      val implyStep = readExpLitZ()
      val steps = reader.readISZ(readExpLitZ _)
      val attr = readAttr()
      return Just.ImplyElim(implyStep, steps, attr)
    }

    def readJustNegIntro(): Just.NegIntro = {
      val r = readJustNegIntroT(F)
      return r
    }

    def readJustNegIntroT(typeParsed: B): Just.NegIntro = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustNegIntro)
      }
      val subProofStep = readExpLitZ()
      val attr = readAttr()
      return Just.NegIntro(subProofStep, attr)
    }

    def readJustNegElim(): Just.NegElim = {
      val r = readJustNegElimT(F)
      return r
    }

    def readJustNegElimT(typeParsed: B): Just.NegElim = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustNegElim)
      }
      val step = readExpLitZ()
      val negStep = readExpLitZ()
      val attr = readAttr()
      return Just.NegElim(step, negStep, attr)
    }

    def readJustBottomElim(): Just.BottomElim = {
      val r = readJustBottomElimT(F)
      return r
    }

    def readJustBottomElimT(typeParsed: B): Just.BottomElim = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustBottomElim)
      }
      val subProofStep = readExpLitZ()
      val attr = readAttr()
      return Just.BottomElim(subProofStep, attr)
    }

    def readJustPbc(): Just.Pbc = {
      val r = readJustPbcT(F)
      return r
    }

    def readJustPbcT(typeParsed: B): Just.Pbc = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustPbc)
      }
      val subProofStep = readExpLitZ()
      val attr = readAttr()
      return Just.Pbc(subProofStep, attr)
    }

    def readJustForallIntro(): Just.ForallIntro = {
      val r = readJustForallIntroT(F)
      return r
    }

    def readJustForallIntroT(typeParsed: B): Just.ForallIntro = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustForallIntro)
      }
      val subProofStep = readExpLitZ()
      val attr = readAttr()
      return Just.ForallIntro(subProofStep, attr)
    }

    def readJustForallElim(): Just.ForallElim = {
      val r = readJustForallElimT(F)
      return r
    }

    def readJustForallElimT(typeParsed: B): Just.ForallElim = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustForallElim)
      }
      val forallStep = readExpLitZ()
      val args = reader.readISZ(readExp _)
      val attr = readAttr()
      return Just.ForallElim(forallStep, args, attr)
    }

    def readJustExistsIntro(): Just.ExistsIntro = {
      val r = readJustExistsIntroT(F)
      return r
    }

    def readJustExistsIntroT(typeParsed: B): Just.ExistsIntro = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustExistsIntro)
      }
      val existsStep = readExpLitZ()
      val args = reader.readISZ(readExp _)
      val attr = readAttr()
      return Just.ExistsIntro(existsStep, args, attr)
    }

    def readJustExistsElim(): Just.ExistsElim = {
      val r = readJustExistsElimT(F)
      return r
    }

    def readJustExistsElimT(typeParsed: B): Just.ExistsElim = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustExistsElim)
      }
      val existsStep = readExpLitZ()
      val subProofStep = readExpLitZ()
      val attr = readAttr()
      return Just.ExistsElim(existsStep, subProofStep, attr)
    }

    def readJustFact(): Just.Fact = {
      val r = readJustFactT(F)
      return r
    }

    def readJustFactT(typeParsed: B): Just.Fact = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustFact)
      }
      val name = readName()
      val attr = readAttr()
      return Just.Fact(name, attr)
    }

    def readJustInvariant(): Just.Invariant = {
      val r = readJustInvariantT(F)
      return r
    }

    def readJustInvariantT(typeParsed: B): Just.Invariant = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustInvariant)
      }
      val nameOpt = reader.readOption(readName _)
      val attr = readAttr()
      return Just.Invariant(nameOpt, attr)
    }

    def readJustSubst(): Just.Subst = {
      val r = readJustSubstT(F)
      return r
    }

    def readJustSubstT(typeParsed: B): Just.Subst = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustSubst)
      }
      val isRight = reader.readB()
      val eqStep = readExpLitZ()
      val step = readExpLitZ()
      val attr = readAttr()
      return Just.Subst(isRight, eqStep, step, attr)
    }

    def readJustAuto(): Just.Auto = {
      val r = readJustAutoT(F)
      return r
    }

    def readJustAutoT(typeParsed: B): Just.Auto = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustAuto)
      }
      val isAlgebra = reader.readB()
      val steps = reader.readISZ(readExpLitZ _)
      val attr = readAttr()
      return Just.Auto(isAlgebra, steps, attr)
    }

    def readJustCoq(): Just.Coq = {
      val r = readJustCoqT(F)
      return r
    }

    def readJustCoqT(typeParsed: B): Just.Coq = {
      if (!typeParsed) {
        reader.expectZ(Constants.JustCoq)
      }
      val path = readExpLitString()
      val steps = reader.readISZ(readExpLitZ _)
      val attr = readAttr()
      return Just.Coq(path, steps, attr)
    }

    def readTruthTableRow(): TruthTable.Row = {
      val r = readTruthTableRowT(F)
      return r
    }

    def readTruthTableRowT(typeParsed: B): TruthTable.Row = {
      if (!typeParsed) {
        reader.expectZ(Constants.TruthTableRow)
      }
      val assignment = readTruthTableAssignment()
      val separator = readPosInfo()
      val values = readTruthTableAssignment()
      return TruthTable.Row(assignment, separator, values)
    }

    def readTruthTableAssignment(): TruthTable.Assignment = {
      val r = readTruthTableAssignmentT(F)
      return r
    }

    def readTruthTableAssignmentT(typeParsed: B): TruthTable.Assignment = {
      if (!typeParsed) {
        reader.expectZ(Constants.TruthTableAssignment)
      }
      val values = reader.readISZ(readExpLitB _)
      val attr = readAttr()
      return TruthTable.Assignment(values, attr)
    }

    def readTruthTableConclusion(): TruthTable.Conclusion = {
      val t = reader.readZ()
      t match {
        case Constants.TruthTableConclusionValidity => val r = readTruthTableConclusionValidityT(T); return r
        case Constants.TruthTableConclusionTautology => val r = readTruthTableConclusionTautologyT(T); return r
        case Constants.TruthTableConclusionContradictory => val r = readTruthTableConclusionContradictoryT(T); return r
        case Constants.TruthTableConclusionContingent => val r = readTruthTableConclusionContingentT(T); return r
        case _ => halt(s"Unexpected type code $t.")
      }
    }

    def readTruthTableConclusionValidity(): TruthTable.Conclusion.Validity = {
      val r = readTruthTableConclusionValidityT(F)
      return r
    }

    def readTruthTableConclusionValidityT(typeParsed: B): TruthTable.Conclusion.Validity = {
      if (!typeParsed) {
        reader.expectZ(Constants.TruthTableConclusionValidity)
      }
      val isValid = reader.readB()
      val assignments = reader.readISZ(readTruthTableAssignment _)
      val attr = readAttr()
      return TruthTable.Conclusion.Validity(isValid, assignments, attr)
    }

    def readTruthTableConclusionTautology(): TruthTable.Conclusion.Tautology = {
      val r = readTruthTableConclusionTautologyT(F)
      return r
    }

    def readTruthTableConclusionTautologyT(typeParsed: B): TruthTable.Conclusion.Tautology = {
      if (!typeParsed) {
        reader.expectZ(Constants.TruthTableConclusionTautology)
      }
      val attr = readAttr()
      return TruthTable.Conclusion.Tautology(attr)
    }

    def readTruthTableConclusionContradictory(): TruthTable.Conclusion.Contradictory = {
      val r = readTruthTableConclusionContradictoryT(F)
      return r
    }

    def readTruthTableConclusionContradictoryT(typeParsed: B): TruthTable.Conclusion.Contradictory = {
      if (!typeParsed) {
        reader.expectZ(Constants.TruthTableConclusionContradictory)
      }
      val attr = readAttr()
      return TruthTable.Conclusion.Contradictory(attr)
    }

    def readTruthTableConclusionContingent(): TruthTable.Conclusion.Contingent = {
      val r = readTruthTableConclusionContingentT(F)
      return r
    }

    def readTruthTableConclusionContingentT(typeParsed: B): TruthTable.Conclusion.Contingent = {
      if (!typeParsed) {
        reader.expectZ(Constants.TruthTableConclusionContingent)
      }
      val trueAssignments = reader.readISZ(readTruthTableAssignment _)
      val falseAssignments = reader.readISZ(readTruthTableAssignment _)
      val attr = readAttr()
      return TruthTable.Conclusion.Contingent(trueAssignments, falseAssignments, attr)
    }

    def readTyped(): Typed = {
      val t = reader.readZ()
      t match {
        case Constants.TypedName => val r = readTypedNameT(T); return r
        case Constants.TypedTuple => val r = readTypedTupleT(T); return r
        case Constants.TypedFun => val r = readTypedFunT(T); return r
        case _ => halt(s"Unexpected type code $t.")
      }
    }

    def readTypedName(): Typed.Name = {
      val r = readTypedNameT(F)
      return r
    }

    def readTypedNameT(typeParsed: B): Typed.Name = {
      if (!typeParsed) {
        reader.expectZ(Constants.TypedName)
      }
      val ids = reader.readISZ(reader.readString _)
      val args = reader.readISZ(readTyped _)
      val posOpt = reader.readOption(readPosInfo _)
      return Typed.Name(ids, args, posOpt)
    }

    def readTypedTuple(): Typed.Tuple = {
      val r = readTypedTupleT(F)
      return r
    }

    def readTypedTupleT(typeParsed: B): Typed.Tuple = {
      if (!typeParsed) {
        reader.expectZ(Constants.TypedTuple)
      }
      val args = reader.readISZ(readTyped _)
      val posOpt = reader.readOption(readPosInfo _)
      return Typed.Tuple(args, posOpt)
    }

    def readTypedFun(): Typed.Fun = {
      val r = readTypedFunT(F)
      return r
    }

    def readTypedFunT(typeParsed: B): Typed.Fun = {
      if (!typeParsed) {
        reader.expectZ(Constants.TypedFun)
      }
      val args = reader.readISZ(readTyped _)
      val ret = readTyped()
      val posOpt = reader.readOption(readPosInfo _)
      return Typed.Fun(args, ret, posOpt)
    }

    def readAttr(): Attr = {
      val r = readAttrT(F)
      return r
    }

    def readAttrT(typeParsed: B): Attr = {
      if (!typeParsed) {
        reader.expectZ(Constants.Attr)
      }
      val posOpt = reader.readOption(readPosInfo _)
      return Attr(posOpt)
    }

    def readTypedAttr(): TypedAttr = {
      val r = readTypedAttrT(F)
      return r
    }

    def readTypedAttrT(typeParsed: B): TypedAttr = {
      if (!typeParsed) {
        reader.expectZ(Constants.TypedAttr)
      }
      val posOpt = reader.readOption(readPosInfo _)
      val typedOpt = reader.readOption(readTyped _)
      return TypedAttr(posOpt, typedOpt)
    }

    def readResolvedAttr(): ResolvedAttr = {
      val r = readResolvedAttrT(F)
      return r
    }

    def readResolvedAttrT(typeParsed: B): ResolvedAttr = {
      if (!typeParsed) {
        reader.expectZ(Constants.ResolvedAttr)
      }
      val posOpt = reader.readOption(readPosInfo _)
      val resOpt = reader.readOption(readResolvedInfo _)
      val typedOpt = reader.readOption(readTyped _)
      return ResolvedAttr(posOpt, resOpt, typedOpt)
    }

    def readResolvedInfo(): ResolvedInfo = {
      val r = readResolvedInfoT(F)
      return r
    }

    def readResolvedInfoT(typeParsed: B): ResolvedInfo = {
      if (!typeParsed) {
        reader.expectZ(Constants.ResolvedInfo)
      }
      val kind = readSymbolKind()
      val ids = reader.readISZ(reader.readString _)
      val externFileUriOpt = reader.readOption(reader.readString _)
      return ResolvedInfo(kind, ids, externFileUriOpt)
    }

    def readSymbolKind(): SymbolKind.Type = {
      val r = reader.readZ()
      return SymbolKind.byOrdinal(r).get
    }

    def readPosInfo(): PosInfo = {
      val r = readPosInfoT(F)
      return r
    }

    def readPosInfoT(typeParsed: B): PosInfo = {
      if (!typeParsed) {
        reader.expectZ(Constants.PosInfo)
      }
      val fileUriOpt = reader.readOption(reader.readString _)
      val beginLine = reader.readZ()
      val beginColumn = reader.readZ()
      val endLine = reader.readZ()
      val endColumn = reader.readZ()
      val offset = reader.readZ()
      val length = reader.readZ()
      return PosInfo(fileUriOpt, beginLine, beginColumn, endLine, endColumn, offset, length)
    }

  }

  def to[T](data: ISZ[U8], f: Reader => T): T = {
    val r = f(Reader(MessagePack.reader(data)))
    return r
  }

  def toBase64[T](s: String, f: Reader => T): T = {
    val r = f(Reader(MessagePack.readerBase64(s)))
    return r
  }

  def fromTopUnit(o: TopUnit): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTopUnit(o)
    return w.result
  }

  def fromTopUnitBase64(o: TopUnit): String = {
    val w = Writer(MessagePack.writer)
    w.writeTopUnit(o)
    return w.resultBase64
  }

  def toTopUnit(data: ISZ[U8]): TopUnit = {
    def fTopUnit(reader: Reader): TopUnit = {
      val r = reader.readTopUnit()
      return r
    }
    val r = to(data, fTopUnit)
    return r
  }

  def toTopUnitBase64(s: String): TopUnit = {
    def fTopUnit(reader: Reader): TopUnit = {
      val r = reader.readTopUnit()
      return r
    }
    val r = toBase64(s, fTopUnit)
    return r
  }

  def fromTopUnitProgram(o: TopUnit.Program): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTopUnitProgram(o)
    return w.result
  }

  def fromTopUnitProgramBase64(o: TopUnit.Program): String = {
    val w = Writer(MessagePack.writer)
    w.writeTopUnitProgram(o)
    return w.resultBase64
  }

  def toTopUnitProgram(data: ISZ[U8]): TopUnit.Program = {
    def fTopUnitProgram(reader: Reader): TopUnit.Program = {
      val r = reader.readTopUnitProgram()
      return r
    }
    val r = to(data, fTopUnitProgram)
    return r
  }

  def toTopUnitProgramBase64(s: String): TopUnit.Program = {
    def fTopUnitProgram(reader: Reader): TopUnit.Program = {
      val r = reader.readTopUnitProgram()
      return r
    }
    val r = toBase64(s, fTopUnitProgram)
    return r
  }

  def fromTopUnitSequentUnit(o: TopUnit.SequentUnit): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTopUnitSequentUnit(o)
    return w.result
  }

  def fromTopUnitSequentUnitBase64(o: TopUnit.SequentUnit): String = {
    val w = Writer(MessagePack.writer)
    w.writeTopUnitSequentUnit(o)
    return w.resultBase64
  }

  def toTopUnitSequentUnit(data: ISZ[U8]): TopUnit.SequentUnit = {
    def fTopUnitSequentUnit(reader: Reader): TopUnit.SequentUnit = {
      val r = reader.readTopUnitSequentUnit()
      return r
    }
    val r = to(data, fTopUnitSequentUnit)
    return r
  }

  def toTopUnitSequentUnitBase64(s: String): TopUnit.SequentUnit = {
    def fTopUnitSequentUnit(reader: Reader): TopUnit.SequentUnit = {
      val r = reader.readTopUnitSequentUnit()
      return r
    }
    val r = toBase64(s, fTopUnitSequentUnit)
    return r
  }

  def fromTopUnitTruthTableUnit(o: TopUnit.TruthTableUnit): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTopUnitTruthTableUnit(o)
    return w.result
  }

  def fromTopUnitTruthTableUnitBase64(o: TopUnit.TruthTableUnit): String = {
    val w = Writer(MessagePack.writer)
    w.writeTopUnitTruthTableUnit(o)
    return w.resultBase64
  }

  def toTopUnitTruthTableUnit(data: ISZ[U8]): TopUnit.TruthTableUnit = {
    def fTopUnitTruthTableUnit(reader: Reader): TopUnit.TruthTableUnit = {
      val r = reader.readTopUnitTruthTableUnit()
      return r
    }
    val r = to(data, fTopUnitTruthTableUnit)
    return r
  }

  def toTopUnitTruthTableUnitBase64(s: String): TopUnit.TruthTableUnit = {
    def fTopUnitTruthTableUnit(reader: Reader): TopUnit.TruthTableUnit = {
      val r = reader.readTopUnitTruthTableUnit()
      return r
    }
    val r = toBase64(s, fTopUnitTruthTableUnit)
    return r
  }

  def fromStmt(o: Stmt): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmt(o)
    return w.result
  }

  def fromStmtBase64(o: Stmt): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmt(o)
    return w.resultBase64
  }

  def toStmt(data: ISZ[U8]): Stmt = {
    def fStmt(reader: Reader): Stmt = {
      val r = reader.readStmt()
      return r
    }
    val r = to(data, fStmt)
    return r
  }

  def toStmtBase64(s: String): Stmt = {
    def fStmt(reader: Reader): Stmt = {
      val r = reader.readStmt()
      return r
    }
    val r = toBase64(s, fStmt)
    return r
  }

  def fromAssignExp(o: AssignExp): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeAssignExp(o)
    return w.result
  }

  def fromAssignExpBase64(o: AssignExp): String = {
    val w = Writer(MessagePack.writer)
    w.writeAssignExp(o)
    return w.resultBase64
  }

  def toAssignExp(data: ISZ[U8]): AssignExp = {
    def fAssignExp(reader: Reader): AssignExp = {
      val r = reader.readAssignExp()
      return r
    }
    val r = to(data, fAssignExp)
    return r
  }

  def toAssignExpBase64(s: String): AssignExp = {
    def fAssignExp(reader: Reader): AssignExp = {
      val r = reader.readAssignExp()
      return r
    }
    val r = toBase64(s, fAssignExp)
    return r
  }

  def fromStmtImport(o: Stmt.Import): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtImport(o)
    return w.result
  }

  def fromStmtImportBase64(o: Stmt.Import): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtImport(o)
    return w.resultBase64
  }

  def toStmtImport(data: ISZ[U8]): Stmt.Import = {
    def fStmtImport(reader: Reader): Stmt.Import = {
      val r = reader.readStmtImport()
      return r
    }
    val r = to(data, fStmtImport)
    return r
  }

  def toStmtImportBase64(s: String): Stmt.Import = {
    def fStmtImport(reader: Reader): Stmt.Import = {
      val r = reader.readStmtImport()
      return r
    }
    val r = toBase64(s, fStmtImport)
    return r
  }

  def fromStmtImportImporter(o: Stmt.Import.Importer): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtImportImporter(o)
    return w.result
  }

  def fromStmtImportImporterBase64(o: Stmt.Import.Importer): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtImportImporter(o)
    return w.resultBase64
  }

  def toStmtImportImporter(data: ISZ[U8]): Stmt.Import.Importer = {
    def fStmtImportImporter(reader: Reader): Stmt.Import.Importer = {
      val r = reader.readStmtImportImporter()
      return r
    }
    val r = to(data, fStmtImportImporter)
    return r
  }

  def toStmtImportImporterBase64(s: String): Stmt.Import.Importer = {
    def fStmtImportImporter(reader: Reader): Stmt.Import.Importer = {
      val r = reader.readStmtImportImporter()
      return r
    }
    val r = toBase64(s, fStmtImportImporter)
    return r
  }

  def fromStmtImportSelector(o: Stmt.Import.Selector): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtImportSelector(o)
    return w.result
  }

  def fromStmtImportSelectorBase64(o: Stmt.Import.Selector): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtImportSelector(o)
    return w.resultBase64
  }

  def toStmtImportSelector(data: ISZ[U8]): Stmt.Import.Selector = {
    def fStmtImportSelector(reader: Reader): Stmt.Import.Selector = {
      val r = reader.readStmtImportSelector()
      return r
    }
    val r = to(data, fStmtImportSelector)
    return r
  }

  def toStmtImportSelectorBase64(s: String): Stmt.Import.Selector = {
    def fStmtImportSelector(reader: Reader): Stmt.Import.Selector = {
      val r = reader.readStmtImportSelector()
      return r
    }
    val r = toBase64(s, fStmtImportSelector)
    return r
  }

  def fromStmtImportMultiSelector(o: Stmt.Import.MultiSelector): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtImportMultiSelector(o)
    return w.result
  }

  def fromStmtImportMultiSelectorBase64(o: Stmt.Import.MultiSelector): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtImportMultiSelector(o)
    return w.resultBase64
  }

  def toStmtImportMultiSelector(data: ISZ[U8]): Stmt.Import.MultiSelector = {
    def fStmtImportMultiSelector(reader: Reader): Stmt.Import.MultiSelector = {
      val r = reader.readStmtImportMultiSelector()
      return r
    }
    val r = to(data, fStmtImportMultiSelector)
    return r
  }

  def toStmtImportMultiSelectorBase64(s: String): Stmt.Import.MultiSelector = {
    def fStmtImportMultiSelector(reader: Reader): Stmt.Import.MultiSelector = {
      val r = reader.readStmtImportMultiSelector()
      return r
    }
    val r = toBase64(s, fStmtImportMultiSelector)
    return r
  }

  def fromStmtImportWildcardSelector(o: Stmt.Import.WildcardSelector): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtImportWildcardSelector(o)
    return w.result
  }

  def fromStmtImportWildcardSelectorBase64(o: Stmt.Import.WildcardSelector): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtImportWildcardSelector(o)
    return w.resultBase64
  }

  def toStmtImportWildcardSelector(data: ISZ[U8]): Stmt.Import.WildcardSelector = {
    def fStmtImportWildcardSelector(reader: Reader): Stmt.Import.WildcardSelector = {
      val r = reader.readStmtImportWildcardSelector()
      return r
    }
    val r = to(data, fStmtImportWildcardSelector)
    return r
  }

  def toStmtImportWildcardSelectorBase64(s: String): Stmt.Import.WildcardSelector = {
    def fStmtImportWildcardSelector(reader: Reader): Stmt.Import.WildcardSelector = {
      val r = reader.readStmtImportWildcardSelector()
      return r
    }
    val r = toBase64(s, fStmtImportWildcardSelector)
    return r
  }

  def fromStmtImportNamedSelector(o: Stmt.Import.NamedSelector): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtImportNamedSelector(o)
    return w.result
  }

  def fromStmtImportNamedSelectorBase64(o: Stmt.Import.NamedSelector): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtImportNamedSelector(o)
    return w.resultBase64
  }

  def toStmtImportNamedSelector(data: ISZ[U8]): Stmt.Import.NamedSelector = {
    def fStmtImportNamedSelector(reader: Reader): Stmt.Import.NamedSelector = {
      val r = reader.readStmtImportNamedSelector()
      return r
    }
    val r = to(data, fStmtImportNamedSelector)
    return r
  }

  def toStmtImportNamedSelectorBase64(s: String): Stmt.Import.NamedSelector = {
    def fStmtImportNamedSelector(reader: Reader): Stmt.Import.NamedSelector = {
      val r = reader.readStmtImportNamedSelector()
      return r
    }
    val r = toBase64(s, fStmtImportNamedSelector)
    return r
  }

  def fromStmtVar(o: Stmt.Var): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtVar(o)
    return w.result
  }

  def fromStmtVarBase64(o: Stmt.Var): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtVar(o)
    return w.resultBase64
  }

  def toStmtVar(data: ISZ[U8]): Stmt.Var = {
    def fStmtVar(reader: Reader): Stmt.Var = {
      val r = reader.readStmtVar()
      return r
    }
    val r = to(data, fStmtVar)
    return r
  }

  def toStmtVarBase64(s: String): Stmt.Var = {
    def fStmtVar(reader: Reader): Stmt.Var = {
      val r = reader.readStmtVar()
      return r
    }
    val r = toBase64(s, fStmtVar)
    return r
  }

  def fromStmtVarPattern(o: Stmt.VarPattern): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtVarPattern(o)
    return w.result
  }

  def fromStmtVarPatternBase64(o: Stmt.VarPattern): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtVarPattern(o)
    return w.resultBase64
  }

  def toStmtVarPattern(data: ISZ[U8]): Stmt.VarPattern = {
    def fStmtVarPattern(reader: Reader): Stmt.VarPattern = {
      val r = reader.readStmtVarPattern()
      return r
    }
    val r = to(data, fStmtVarPattern)
    return r
  }

  def toStmtVarPatternBase64(s: String): Stmt.VarPattern = {
    def fStmtVarPattern(reader: Reader): Stmt.VarPattern = {
      val r = reader.readStmtVarPattern()
      return r
    }
    val r = toBase64(s, fStmtVarPattern)
    return r
  }

  def fromStmtSpecVar(o: Stmt.SpecVar): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtSpecVar(o)
    return w.result
  }

  def fromStmtSpecVarBase64(o: Stmt.SpecVar): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtSpecVar(o)
    return w.resultBase64
  }

  def toStmtSpecVar(data: ISZ[U8]): Stmt.SpecVar = {
    def fStmtSpecVar(reader: Reader): Stmt.SpecVar = {
      val r = reader.readStmtSpecVar()
      return r
    }
    val r = to(data, fStmtSpecVar)
    return r
  }

  def toStmtSpecVarBase64(s: String): Stmt.SpecVar = {
    def fStmtSpecVar(reader: Reader): Stmt.SpecVar = {
      val r = reader.readStmtSpecVar()
      return r
    }
    val r = toBase64(s, fStmtSpecVar)
    return r
  }

  def fromStmtMethod(o: Stmt.Method): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtMethod(o)
    return w.result
  }

  def fromStmtMethodBase64(o: Stmt.Method): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtMethod(o)
    return w.resultBase64
  }

  def toStmtMethod(data: ISZ[U8]): Stmt.Method = {
    def fStmtMethod(reader: Reader): Stmt.Method = {
      val r = reader.readStmtMethod()
      return r
    }
    val r = to(data, fStmtMethod)
    return r
  }

  def toStmtMethodBase64(s: String): Stmt.Method = {
    def fStmtMethod(reader: Reader): Stmt.Method = {
      val r = reader.readStmtMethod()
      return r
    }
    val r = toBase64(s, fStmtMethod)
    return r
  }

  def fromStmtExtMethod(o: Stmt.ExtMethod): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtExtMethod(o)
    return w.result
  }

  def fromStmtExtMethodBase64(o: Stmt.ExtMethod): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtExtMethod(o)
    return w.resultBase64
  }

  def toStmtExtMethod(data: ISZ[U8]): Stmt.ExtMethod = {
    def fStmtExtMethod(reader: Reader): Stmt.ExtMethod = {
      val r = reader.readStmtExtMethod()
      return r
    }
    val r = to(data, fStmtExtMethod)
    return r
  }

  def toStmtExtMethodBase64(s: String): Stmt.ExtMethod = {
    def fStmtExtMethod(reader: Reader): Stmt.ExtMethod = {
      val r = reader.readStmtExtMethod()
      return r
    }
    val r = toBase64(s, fStmtExtMethod)
    return r
  }

  def fromStmtSpecMethod(o: Stmt.SpecMethod): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtSpecMethod(o)
    return w.result
  }

  def fromStmtSpecMethodBase64(o: Stmt.SpecMethod): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtSpecMethod(o)
    return w.resultBase64
  }

  def toStmtSpecMethod(data: ISZ[U8]): Stmt.SpecMethod = {
    def fStmtSpecMethod(reader: Reader): Stmt.SpecMethod = {
      val r = reader.readStmtSpecMethod()
      return r
    }
    val r = to(data, fStmtSpecMethod)
    return r
  }

  def toStmtSpecMethodBase64(s: String): Stmt.SpecMethod = {
    def fStmtSpecMethod(reader: Reader): Stmt.SpecMethod = {
      val r = reader.readStmtSpecMethod()
      return r
    }
    val r = toBase64(s, fStmtSpecMethod)
    return r
  }

  def fromStmtEnum(o: Stmt.Enum): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtEnum(o)
    return w.result
  }

  def fromStmtEnumBase64(o: Stmt.Enum): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtEnum(o)
    return w.resultBase64
  }

  def toStmtEnum(data: ISZ[U8]): Stmt.Enum = {
    def fStmtEnum(reader: Reader): Stmt.Enum = {
      val r = reader.readStmtEnum()
      return r
    }
    val r = to(data, fStmtEnum)
    return r
  }

  def toStmtEnumBase64(s: String): Stmt.Enum = {
    def fStmtEnum(reader: Reader): Stmt.Enum = {
      val r = reader.readStmtEnum()
      return r
    }
    val r = toBase64(s, fStmtEnum)
    return r
  }

  def fromStmtSubZ(o: Stmt.SubZ): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtSubZ(o)
    return w.result
  }

  def fromStmtSubZBase64(o: Stmt.SubZ): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtSubZ(o)
    return w.resultBase64
  }

  def toStmtSubZ(data: ISZ[U8]): Stmt.SubZ = {
    def fStmtSubZ(reader: Reader): Stmt.SubZ = {
      val r = reader.readStmtSubZ()
      return r
    }
    val r = to(data, fStmtSubZ)
    return r
  }

  def toStmtSubZBase64(s: String): Stmt.SubZ = {
    def fStmtSubZ(reader: Reader): Stmt.SubZ = {
      val r = reader.readStmtSubZ()
      return r
    }
    val r = toBase64(s, fStmtSubZ)
    return r
  }

  def fromStmtObject(o: Stmt.Object): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtObject(o)
    return w.result
  }

  def fromStmtObjectBase64(o: Stmt.Object): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtObject(o)
    return w.resultBase64
  }

  def toStmtObject(data: ISZ[U8]): Stmt.Object = {
    def fStmtObject(reader: Reader): Stmt.Object = {
      val r = reader.readStmtObject()
      return r
    }
    val r = to(data, fStmtObject)
    return r
  }

  def toStmtObjectBase64(s: String): Stmt.Object = {
    def fStmtObject(reader: Reader): Stmt.Object = {
      val r = reader.readStmtObject()
      return r
    }
    val r = toBase64(s, fStmtObject)
    return r
  }

  def fromStmtSig(o: Stmt.Sig): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtSig(o)
    return w.result
  }

  def fromStmtSigBase64(o: Stmt.Sig): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtSig(o)
    return w.resultBase64
  }

  def toStmtSig(data: ISZ[U8]): Stmt.Sig = {
    def fStmtSig(reader: Reader): Stmt.Sig = {
      val r = reader.readStmtSig()
      return r
    }
    val r = to(data, fStmtSig)
    return r
  }

  def toStmtSigBase64(s: String): Stmt.Sig = {
    def fStmtSig(reader: Reader): Stmt.Sig = {
      val r = reader.readStmtSig()
      return r
    }
    val r = toBase64(s, fStmtSig)
    return r
  }

  def fromStmtAbstractDatatype(o: Stmt.AbstractDatatype): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtAbstractDatatype(o)
    return w.result
  }

  def fromStmtAbstractDatatypeBase64(o: Stmt.AbstractDatatype): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtAbstractDatatype(o)
    return w.resultBase64
  }

  def toStmtAbstractDatatype(data: ISZ[U8]): Stmt.AbstractDatatype = {
    def fStmtAbstractDatatype(reader: Reader): Stmt.AbstractDatatype = {
      val r = reader.readStmtAbstractDatatype()
      return r
    }
    val r = to(data, fStmtAbstractDatatype)
    return r
  }

  def toStmtAbstractDatatypeBase64(s: String): Stmt.AbstractDatatype = {
    def fStmtAbstractDatatype(reader: Reader): Stmt.AbstractDatatype = {
      val r = reader.readStmtAbstractDatatype()
      return r
    }
    val r = toBase64(s, fStmtAbstractDatatype)
    return r
  }

  def fromStmtTypeAlias(o: Stmt.TypeAlias): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtTypeAlias(o)
    return w.result
  }

  def fromStmtTypeAliasBase64(o: Stmt.TypeAlias): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtTypeAlias(o)
    return w.resultBase64
  }

  def toStmtTypeAlias(data: ISZ[U8]): Stmt.TypeAlias = {
    def fStmtTypeAlias(reader: Reader): Stmt.TypeAlias = {
      val r = reader.readStmtTypeAlias()
      return r
    }
    val r = to(data, fStmtTypeAlias)
    return r
  }

  def toStmtTypeAliasBase64(s: String): Stmt.TypeAlias = {
    def fStmtTypeAlias(reader: Reader): Stmt.TypeAlias = {
      val r = reader.readStmtTypeAlias()
      return r
    }
    val r = toBase64(s, fStmtTypeAlias)
    return r
  }

  def fromStmtAssign(o: Stmt.Assign): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtAssign(o)
    return w.result
  }

  def fromStmtAssignBase64(o: Stmt.Assign): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtAssign(o)
    return w.resultBase64
  }

  def toStmtAssign(data: ISZ[U8]): Stmt.Assign = {
    def fStmtAssign(reader: Reader): Stmt.Assign = {
      val r = reader.readStmtAssign()
      return r
    }
    val r = to(data, fStmtAssign)
    return r
  }

  def toStmtAssignBase64(s: String): Stmt.Assign = {
    def fStmtAssign(reader: Reader): Stmt.Assign = {
      val r = reader.readStmtAssign()
      return r
    }
    val r = toBase64(s, fStmtAssign)
    return r
  }

  def fromStmtAssignUp(o: Stmt.AssignUp): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtAssignUp(o)
    return w.result
  }

  def fromStmtAssignUpBase64(o: Stmt.AssignUp): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtAssignUp(o)
    return w.resultBase64
  }

  def toStmtAssignUp(data: ISZ[U8]): Stmt.AssignUp = {
    def fStmtAssignUp(reader: Reader): Stmt.AssignUp = {
      val r = reader.readStmtAssignUp()
      return r
    }
    val r = to(data, fStmtAssignUp)
    return r
  }

  def toStmtAssignUpBase64(s: String): Stmt.AssignUp = {
    def fStmtAssignUp(reader: Reader): Stmt.AssignUp = {
      val r = reader.readStmtAssignUp()
      return r
    }
    val r = toBase64(s, fStmtAssignUp)
    return r
  }

  def fromStmtAssignPattern(o: Stmt.AssignPattern): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtAssignPattern(o)
    return w.result
  }

  def fromStmtAssignPatternBase64(o: Stmt.AssignPattern): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtAssignPattern(o)
    return w.resultBase64
  }

  def toStmtAssignPattern(data: ISZ[U8]): Stmt.AssignPattern = {
    def fStmtAssignPattern(reader: Reader): Stmt.AssignPattern = {
      val r = reader.readStmtAssignPattern()
      return r
    }
    val r = to(data, fStmtAssignPattern)
    return r
  }

  def toStmtAssignPatternBase64(s: String): Stmt.AssignPattern = {
    def fStmtAssignPattern(reader: Reader): Stmt.AssignPattern = {
      val r = reader.readStmtAssignPattern()
      return r
    }
    val r = toBase64(s, fStmtAssignPattern)
    return r
  }

  def fromStmtBlock(o: Stmt.Block): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtBlock(o)
    return w.result
  }

  def fromStmtBlockBase64(o: Stmt.Block): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtBlock(o)
    return w.resultBase64
  }

  def toStmtBlock(data: ISZ[U8]): Stmt.Block = {
    def fStmtBlock(reader: Reader): Stmt.Block = {
      val r = reader.readStmtBlock()
      return r
    }
    val r = to(data, fStmtBlock)
    return r
  }

  def toStmtBlockBase64(s: String): Stmt.Block = {
    def fStmtBlock(reader: Reader): Stmt.Block = {
      val r = reader.readStmtBlock()
      return r
    }
    val r = toBase64(s, fStmtBlock)
    return r
  }

  def fromStmtIf(o: Stmt.If): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtIf(o)
    return w.result
  }

  def fromStmtIfBase64(o: Stmt.If): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtIf(o)
    return w.resultBase64
  }

  def toStmtIf(data: ISZ[U8]): Stmt.If = {
    def fStmtIf(reader: Reader): Stmt.If = {
      val r = reader.readStmtIf()
      return r
    }
    val r = to(data, fStmtIf)
    return r
  }

  def toStmtIfBase64(s: String): Stmt.If = {
    def fStmtIf(reader: Reader): Stmt.If = {
      val r = reader.readStmtIf()
      return r
    }
    val r = toBase64(s, fStmtIf)
    return r
  }

  def fromStmtMatch(o: Stmt.Match): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtMatch(o)
    return w.result
  }

  def fromStmtMatchBase64(o: Stmt.Match): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtMatch(o)
    return w.resultBase64
  }

  def toStmtMatch(data: ISZ[U8]): Stmt.Match = {
    def fStmtMatch(reader: Reader): Stmt.Match = {
      val r = reader.readStmtMatch()
      return r
    }
    val r = to(data, fStmtMatch)
    return r
  }

  def toStmtMatchBase64(s: String): Stmt.Match = {
    def fStmtMatch(reader: Reader): Stmt.Match = {
      val r = reader.readStmtMatch()
      return r
    }
    val r = toBase64(s, fStmtMatch)
    return r
  }

  def fromStmtWhile(o: Stmt.While): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtWhile(o)
    return w.result
  }

  def fromStmtWhileBase64(o: Stmt.While): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtWhile(o)
    return w.resultBase64
  }

  def toStmtWhile(data: ISZ[U8]): Stmt.While = {
    def fStmtWhile(reader: Reader): Stmt.While = {
      val r = reader.readStmtWhile()
      return r
    }
    val r = to(data, fStmtWhile)
    return r
  }

  def toStmtWhileBase64(s: String): Stmt.While = {
    def fStmtWhile(reader: Reader): Stmt.While = {
      val r = reader.readStmtWhile()
      return r
    }
    val r = toBase64(s, fStmtWhile)
    return r
  }

  def fromStmtDoWhile(o: Stmt.DoWhile): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtDoWhile(o)
    return w.result
  }

  def fromStmtDoWhileBase64(o: Stmt.DoWhile): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtDoWhile(o)
    return w.resultBase64
  }

  def toStmtDoWhile(data: ISZ[U8]): Stmt.DoWhile = {
    def fStmtDoWhile(reader: Reader): Stmt.DoWhile = {
      val r = reader.readStmtDoWhile()
      return r
    }
    val r = to(data, fStmtDoWhile)
    return r
  }

  def toStmtDoWhileBase64(s: String): Stmt.DoWhile = {
    def fStmtDoWhile(reader: Reader): Stmt.DoWhile = {
      val r = reader.readStmtDoWhile()
      return r
    }
    val r = toBase64(s, fStmtDoWhile)
    return r
  }

  def fromStmtFor(o: Stmt.For): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtFor(o)
    return w.result
  }

  def fromStmtForBase64(o: Stmt.For): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtFor(o)
    return w.resultBase64
  }

  def toStmtFor(data: ISZ[U8]): Stmt.For = {
    def fStmtFor(reader: Reader): Stmt.For = {
      val r = reader.readStmtFor()
      return r
    }
    val r = to(data, fStmtFor)
    return r
  }

  def toStmtForBase64(s: String): Stmt.For = {
    def fStmtFor(reader: Reader): Stmt.For = {
      val r = reader.readStmtFor()
      return r
    }
    val r = toBase64(s, fStmtFor)
    return r
  }

  def fromStmtReturn(o: Stmt.Return): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtReturn(o)
    return w.result
  }

  def fromStmtReturnBase64(o: Stmt.Return): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtReturn(o)
    return w.resultBase64
  }

  def toStmtReturn(data: ISZ[U8]): Stmt.Return = {
    def fStmtReturn(reader: Reader): Stmt.Return = {
      val r = reader.readStmtReturn()
      return r
    }
    val r = to(data, fStmtReturn)
    return r
  }

  def toStmtReturnBase64(s: String): Stmt.Return = {
    def fStmtReturn(reader: Reader): Stmt.Return = {
      val r = reader.readStmtReturn()
      return r
    }
    val r = toBase64(s, fStmtReturn)
    return r
  }

  def fromStmtLStmt(o: Stmt.LStmt): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtLStmt(o)
    return w.result
  }

  def fromStmtLStmtBase64(o: Stmt.LStmt): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtLStmt(o)
    return w.resultBase64
  }

  def toStmtLStmt(data: ISZ[U8]): Stmt.LStmt = {
    def fStmtLStmt(reader: Reader): Stmt.LStmt = {
      val r = reader.readStmtLStmt()
      return r
    }
    val r = to(data, fStmtLStmt)
    return r
  }

  def toStmtLStmtBase64(s: String): Stmt.LStmt = {
    def fStmtLStmt(reader: Reader): Stmt.LStmt = {
      val r = reader.readStmtLStmt()
      return r
    }
    val r = toBase64(s, fStmtLStmt)
    return r
  }

  def fromStmtExpr(o: Stmt.Expr): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeStmtExpr(o)
    return w.result
  }

  def fromStmtExprBase64(o: Stmt.Expr): String = {
    val w = Writer(MessagePack.writer)
    w.writeStmtExpr(o)
    return w.resultBase64
  }

  def toStmtExpr(data: ISZ[U8]): Stmt.Expr = {
    def fStmtExpr(reader: Reader): Stmt.Expr = {
      val r = reader.readStmtExpr()
      return r
    }
    val r = to(data, fStmtExpr)
    return r
  }

  def toStmtExprBase64(s: String): Stmt.Expr = {
    def fStmtExpr(reader: Reader): Stmt.Expr = {
      val r = reader.readStmtExpr()
      return r
    }
    val r = toBase64(s, fStmtExpr)
    return r
  }

  def fromLClause(o: LClause): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeLClause(o)
    return w.result
  }

  def fromLClauseBase64(o: LClause): String = {
    val w = Writer(MessagePack.writer)
    w.writeLClause(o)
    return w.resultBase64
  }

  def toLClause(data: ISZ[U8]): LClause = {
    def fLClause(reader: Reader): LClause = {
      val r = reader.readLClause()
      return r
    }
    val r = to(data, fLClause)
    return r
  }

  def toLClauseBase64(s: String): LClause = {
    def fLClause(reader: Reader): LClause = {
      val r = reader.readLClause()
      return r
    }
    val r = toBase64(s, fLClause)
    return r
  }

  def fromLClauseInvariants(o: LClause.Invariants): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeLClauseInvariants(o)
    return w.result
  }

  def fromLClauseInvariantsBase64(o: LClause.Invariants): String = {
    val w = Writer(MessagePack.writer)
    w.writeLClauseInvariants(o)
    return w.resultBase64
  }

  def toLClauseInvariants(data: ISZ[U8]): LClause.Invariants = {
    def fLClauseInvariants(reader: Reader): LClause.Invariants = {
      val r = reader.readLClauseInvariants()
      return r
    }
    val r = to(data, fLClauseInvariants)
    return r
  }

  def toLClauseInvariantsBase64(s: String): LClause.Invariants = {
    def fLClauseInvariants(reader: Reader): LClause.Invariants = {
      val r = reader.readLClauseInvariants()
      return r
    }
    val r = toBase64(s, fLClauseInvariants)
    return r
  }

  def fromLClauseFacts(o: LClause.Facts): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeLClauseFacts(o)
    return w.result
  }

  def fromLClauseFactsBase64(o: LClause.Facts): String = {
    val w = Writer(MessagePack.writer)
    w.writeLClauseFacts(o)
    return w.resultBase64
  }

  def toLClauseFacts(data: ISZ[U8]): LClause.Facts = {
    def fLClauseFacts(reader: Reader): LClause.Facts = {
      val r = reader.readLClauseFacts()
      return r
    }
    val r = to(data, fLClauseFacts)
    return r
  }

  def toLClauseFactsBase64(s: String): LClause.Facts = {
    def fLClauseFacts(reader: Reader): LClause.Facts = {
      val r = reader.readLClauseFacts()
      return r
    }
    val r = toBase64(s, fLClauseFacts)
    return r
  }

  def fromLClauseFact(o: LClause.Fact): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeLClauseFact(o)
    return w.result
  }

  def fromLClauseFactBase64(o: LClause.Fact): String = {
    val w = Writer(MessagePack.writer)
    w.writeLClauseFact(o)
    return w.resultBase64
  }

  def toLClauseFact(data: ISZ[U8]): LClause.Fact = {
    def fLClauseFact(reader: Reader): LClause.Fact = {
      val r = reader.readLClauseFact()
      return r
    }
    val r = to(data, fLClauseFact)
    return r
  }

  def toLClauseFactBase64(s: String): LClause.Fact = {
    def fLClauseFact(reader: Reader): LClause.Fact = {
      val r = reader.readLClauseFact()
      return r
    }
    val r = toBase64(s, fLClauseFact)
    return r
  }

  def fromLClauseTheorems(o: LClause.Theorems): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeLClauseTheorems(o)
    return w.result
  }

  def fromLClauseTheoremsBase64(o: LClause.Theorems): String = {
    val w = Writer(MessagePack.writer)
    w.writeLClauseTheorems(o)
    return w.resultBase64
  }

  def toLClauseTheorems(data: ISZ[U8]): LClause.Theorems = {
    def fLClauseTheorems(reader: Reader): LClause.Theorems = {
      val r = reader.readLClauseTheorems()
      return r
    }
    val r = to(data, fLClauseTheorems)
    return r
  }

  def toLClauseTheoremsBase64(s: String): LClause.Theorems = {
    def fLClauseTheorems(reader: Reader): LClause.Theorems = {
      val r = reader.readLClauseTheorems()
      return r
    }
    val r = toBase64(s, fLClauseTheorems)
    return r
  }

  def fromLClauseTheorem(o: LClause.Theorem): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeLClauseTheorem(o)
    return w.result
  }

  def fromLClauseTheoremBase64(o: LClause.Theorem): String = {
    val w = Writer(MessagePack.writer)
    w.writeLClauseTheorem(o)
    return w.resultBase64
  }

  def toLClauseTheorem(data: ISZ[U8]): LClause.Theorem = {
    def fLClauseTheorem(reader: Reader): LClause.Theorem = {
      val r = reader.readLClauseTheorem()
      return r
    }
    val r = to(data, fLClauseTheorem)
    return r
  }

  def toLClauseTheoremBase64(s: String): LClause.Theorem = {
    def fLClauseTheorem(reader: Reader): LClause.Theorem = {
      val r = reader.readLClauseTheorem()
      return r
    }
    val r = toBase64(s, fLClauseTheorem)
    return r
  }

  def fromLClauseSequent(o: LClause.Sequent): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeLClauseSequent(o)
    return w.result
  }

  def fromLClauseSequentBase64(o: LClause.Sequent): String = {
    val w = Writer(MessagePack.writer)
    w.writeLClauseSequent(o)
    return w.resultBase64
  }

  def toLClauseSequent(data: ISZ[U8]): LClause.Sequent = {
    def fLClauseSequent(reader: Reader): LClause.Sequent = {
      val r = reader.readLClauseSequent()
      return r
    }
    val r = to(data, fLClauseSequent)
    return r
  }

  def toLClauseSequentBase64(s: String): LClause.Sequent = {
    def fLClauseSequent(reader: Reader): LClause.Sequent = {
      val r = reader.readLClauseSequent()
      return r
    }
    val r = toBase64(s, fLClauseSequent)
    return r
  }

  def fromLClauseProof(o: LClause.Proof): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeLClauseProof(o)
    return w.result
  }

  def fromLClauseProofBase64(o: LClause.Proof): String = {
    val w = Writer(MessagePack.writer)
    w.writeLClauseProof(o)
    return w.resultBase64
  }

  def toLClauseProof(data: ISZ[U8]): LClause.Proof = {
    def fLClauseProof(reader: Reader): LClause.Proof = {
      val r = reader.readLClauseProof()
      return r
    }
    val r = to(data, fLClauseProof)
    return r
  }

  def toLClauseProofBase64(s: String): LClause.Proof = {
    def fLClauseProof(reader: Reader): LClause.Proof = {
      val r = reader.readLClauseProof()
      return r
    }
    val r = toBase64(s, fLClauseProof)
    return r
  }

  def fromContractExp(o: ContractExp): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeContractExp(o)
    return w.result
  }

  def fromContractExpBase64(o: ContractExp): String = {
    val w = Writer(MessagePack.writer)
    w.writeContractExp(o)
    return w.resultBase64
  }

  def toContractExp(data: ISZ[U8]): ContractExp = {
    def fContractExp(reader: Reader): ContractExp = {
      val r = reader.readContractExp()
      return r
    }
    val r = to(data, fContractExp)
    return r
  }

  def toContractExpBase64(s: String): ContractExp = {
    def fContractExp(reader: Reader): ContractExp = {
      val r = reader.readContractExp()
      return r
    }
    val r = toBase64(s, fContractExp)
    return r
  }

  def fromCase(o: Case): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeCase(o)
    return w.result
  }

  def fromCaseBase64(o: Case): String = {
    val w = Writer(MessagePack.writer)
    w.writeCase(o)
    return w.resultBase64
  }

  def toCase(data: ISZ[U8]): Case = {
    def fCase(reader: Reader): Case = {
      val r = reader.readCase()
      return r
    }
    val r = to(data, fCase)
    return r
  }

  def toCaseBase64(s: String): Case = {
    def fCase(reader: Reader): Case = {
      val r = reader.readCase()
      return r
    }
    val r = toBase64(s, fCase)
    return r
  }

  def fromEnumGenRange(o: EnumGen.Range): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeEnumGenRange(o)
    return w.result
  }

  def fromEnumGenRangeBase64(o: EnumGen.Range): String = {
    val w = Writer(MessagePack.writer)
    w.writeEnumGenRange(o)
    return w.resultBase64
  }

  def toEnumGenRange(data: ISZ[U8]): EnumGen.Range = {
    def fEnumGenRange(reader: Reader): EnumGen.Range = {
      val r = reader.readEnumGenRange()
      return r
    }
    val r = to(data, fEnumGenRange)
    return r
  }

  def toEnumGenRangeBase64(s: String): EnumGen.Range = {
    def fEnumGenRange(reader: Reader): EnumGen.Range = {
      val r = reader.readEnumGenRange()
      return r
    }
    val r = toBase64(s, fEnumGenRange)
    return r
  }

  def fromEnumGenRangeExpr(o: EnumGen.Range.Expr): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeEnumGenRangeExpr(o)
    return w.result
  }

  def fromEnumGenRangeExprBase64(o: EnumGen.Range.Expr): String = {
    val w = Writer(MessagePack.writer)
    w.writeEnumGenRangeExpr(o)
    return w.resultBase64
  }

  def toEnumGenRangeExpr(data: ISZ[U8]): EnumGen.Range.Expr = {
    def fEnumGenRangeExpr(reader: Reader): EnumGen.Range.Expr = {
      val r = reader.readEnumGenRangeExpr()
      return r
    }
    val r = to(data, fEnumGenRangeExpr)
    return r
  }

  def toEnumGenRangeExprBase64(s: String): EnumGen.Range.Expr = {
    def fEnumGenRangeExpr(reader: Reader): EnumGen.Range.Expr = {
      val r = reader.readEnumGenRangeExpr()
      return r
    }
    val r = toBase64(s, fEnumGenRangeExpr)
    return r
  }

  def fromEnumGenRangeIndices(o: EnumGen.Range.Indices): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeEnumGenRangeIndices(o)
    return w.result
  }

  def fromEnumGenRangeIndicesBase64(o: EnumGen.Range.Indices): String = {
    val w = Writer(MessagePack.writer)
    w.writeEnumGenRangeIndices(o)
    return w.resultBase64
  }

  def toEnumGenRangeIndices(data: ISZ[U8]): EnumGen.Range.Indices = {
    def fEnumGenRangeIndices(reader: Reader): EnumGen.Range.Indices = {
      val r = reader.readEnumGenRangeIndices()
      return r
    }
    val r = to(data, fEnumGenRangeIndices)
    return r
  }

  def toEnumGenRangeIndicesBase64(s: String): EnumGen.Range.Indices = {
    def fEnumGenRangeIndices(reader: Reader): EnumGen.Range.Indices = {
      val r = reader.readEnumGenRangeIndices()
      return r
    }
    val r = toBase64(s, fEnumGenRangeIndices)
    return r
  }

  def fromEnumGenRangeStep(o: EnumGen.Range.Step): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeEnumGenRangeStep(o)
    return w.result
  }

  def fromEnumGenRangeStepBase64(o: EnumGen.Range.Step): String = {
    val w = Writer(MessagePack.writer)
    w.writeEnumGenRangeStep(o)
    return w.resultBase64
  }

  def toEnumGenRangeStep(data: ISZ[U8]): EnumGen.Range.Step = {
    def fEnumGenRangeStep(reader: Reader): EnumGen.Range.Step = {
      val r = reader.readEnumGenRangeStep()
      return r
    }
    val r = to(data, fEnumGenRangeStep)
    return r
  }

  def toEnumGenRangeStepBase64(s: String): EnumGen.Range.Step = {
    def fEnumGenRangeStep(reader: Reader): EnumGen.Range.Step = {
      val r = reader.readEnumGenRangeStep()
      return r
    }
    val r = toBase64(s, fEnumGenRangeStep)
    return r
  }

  def fromEnumGenFor(o: EnumGen.For): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeEnumGenFor(o)
    return w.result
  }

  def fromEnumGenForBase64(o: EnumGen.For): String = {
    val w = Writer(MessagePack.writer)
    w.writeEnumGenFor(o)
    return w.resultBase64
  }

  def toEnumGenFor(data: ISZ[U8]): EnumGen.For = {
    def fEnumGenFor(reader: Reader): EnumGen.For = {
      val r = reader.readEnumGenFor()
      return r
    }
    val r = to(data, fEnumGenFor)
    return r
  }

  def toEnumGenForBase64(s: String): EnumGen.For = {
    def fEnumGenFor(reader: Reader): EnumGen.For = {
      val r = reader.readEnumGenFor()
      return r
    }
    val r = toBase64(s, fEnumGenFor)
    return r
  }

  def fromType(o: Type): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeType(o)
    return w.result
  }

  def fromTypeBase64(o: Type): String = {
    val w = Writer(MessagePack.writer)
    w.writeType(o)
    return w.resultBase64
  }

  def toType(data: ISZ[U8]): Type = {
    def fType(reader: Reader): Type = {
      val r = reader.readType()
      return r
    }
    val r = to(data, fType)
    return r
  }

  def toTypeBase64(s: String): Type = {
    def fType(reader: Reader): Type = {
      val r = reader.readType()
      return r
    }
    val r = toBase64(s, fType)
    return r
  }

  def fromTypeNamed(o: Type.Named): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTypeNamed(o)
    return w.result
  }

  def fromTypeNamedBase64(o: Type.Named): String = {
    val w = Writer(MessagePack.writer)
    w.writeTypeNamed(o)
    return w.resultBase64
  }

  def toTypeNamed(data: ISZ[U8]): Type.Named = {
    def fTypeNamed(reader: Reader): Type.Named = {
      val r = reader.readTypeNamed()
      return r
    }
    val r = to(data, fTypeNamed)
    return r
  }

  def toTypeNamedBase64(s: String): Type.Named = {
    def fTypeNamed(reader: Reader): Type.Named = {
      val r = reader.readTypeNamed()
      return r
    }
    val r = toBase64(s, fTypeNamed)
    return r
  }

  def fromTypeFun(o: Type.Fun): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTypeFun(o)
    return w.result
  }

  def fromTypeFunBase64(o: Type.Fun): String = {
    val w = Writer(MessagePack.writer)
    w.writeTypeFun(o)
    return w.resultBase64
  }

  def toTypeFun(data: ISZ[U8]): Type.Fun = {
    def fTypeFun(reader: Reader): Type.Fun = {
      val r = reader.readTypeFun()
      return r
    }
    val r = to(data, fTypeFun)
    return r
  }

  def toTypeFunBase64(s: String): Type.Fun = {
    def fTypeFun(reader: Reader): Type.Fun = {
      val r = reader.readTypeFun()
      return r
    }
    val r = toBase64(s, fTypeFun)
    return r
  }

  def fromTypeTuple(o: Type.Tuple): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTypeTuple(o)
    return w.result
  }

  def fromTypeTupleBase64(o: Type.Tuple): String = {
    val w = Writer(MessagePack.writer)
    w.writeTypeTuple(o)
    return w.resultBase64
  }

  def toTypeTuple(data: ISZ[U8]): Type.Tuple = {
    def fTypeTuple(reader: Reader): Type.Tuple = {
      val r = reader.readTypeTuple()
      return r
    }
    val r = to(data, fTypeTuple)
    return r
  }

  def toTypeTupleBase64(s: String): Type.Tuple = {
    def fTypeTuple(reader: Reader): Type.Tuple = {
      val r = reader.readTypeTuple()
      return r
    }
    val r = toBase64(s, fTypeTuple)
    return r
  }

  def fromPattern(o: Pattern): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writePattern(o)
    return w.result
  }

  def fromPatternBase64(o: Pattern): String = {
    val w = Writer(MessagePack.writer)
    w.writePattern(o)
    return w.resultBase64
  }

  def toPattern(data: ISZ[U8]): Pattern = {
    def fPattern(reader: Reader): Pattern = {
      val r = reader.readPattern()
      return r
    }
    val r = to(data, fPattern)
    return r
  }

  def toPatternBase64(s: String): Pattern = {
    def fPattern(reader: Reader): Pattern = {
      val r = reader.readPattern()
      return r
    }
    val r = toBase64(s, fPattern)
    return r
  }

  def fromPatternLiteral(o: Pattern.Literal): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writePatternLiteral(o)
    return w.result
  }

  def fromPatternLiteralBase64(o: Pattern.Literal): String = {
    val w = Writer(MessagePack.writer)
    w.writePatternLiteral(o)
    return w.resultBase64
  }

  def toPatternLiteral(data: ISZ[U8]): Pattern.Literal = {
    def fPatternLiteral(reader: Reader): Pattern.Literal = {
      val r = reader.readPatternLiteral()
      return r
    }
    val r = to(data, fPatternLiteral)
    return r
  }

  def toPatternLiteralBase64(s: String): Pattern.Literal = {
    def fPatternLiteral(reader: Reader): Pattern.Literal = {
      val r = reader.readPatternLiteral()
      return r
    }
    val r = toBase64(s, fPatternLiteral)
    return r
  }

  def fromPatternRef(o: Pattern.Ref): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writePatternRef(o)
    return w.result
  }

  def fromPatternRefBase64(o: Pattern.Ref): String = {
    val w = Writer(MessagePack.writer)
    w.writePatternRef(o)
    return w.resultBase64
  }

  def toPatternRef(data: ISZ[U8]): Pattern.Ref = {
    def fPatternRef(reader: Reader): Pattern.Ref = {
      val r = reader.readPatternRef()
      return r
    }
    val r = to(data, fPatternRef)
    return r
  }

  def toPatternRefBase64(s: String): Pattern.Ref = {
    def fPatternRef(reader: Reader): Pattern.Ref = {
      val r = reader.readPatternRef()
      return r
    }
    val r = toBase64(s, fPatternRef)
    return r
  }

  def fromPatternVariable(o: Pattern.Variable): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writePatternVariable(o)
    return w.result
  }

  def fromPatternVariableBase64(o: Pattern.Variable): String = {
    val w = Writer(MessagePack.writer)
    w.writePatternVariable(o)
    return w.resultBase64
  }

  def toPatternVariable(data: ISZ[U8]): Pattern.Variable = {
    def fPatternVariable(reader: Reader): Pattern.Variable = {
      val r = reader.readPatternVariable()
      return r
    }
    val r = to(data, fPatternVariable)
    return r
  }

  def toPatternVariableBase64(s: String): Pattern.Variable = {
    def fPatternVariable(reader: Reader): Pattern.Variable = {
      val r = reader.readPatternVariable()
      return r
    }
    val r = toBase64(s, fPatternVariable)
    return r
  }

  def fromPatternWildcard(o: Pattern.Wildcard): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writePatternWildcard(o)
    return w.result
  }

  def fromPatternWildcardBase64(o: Pattern.Wildcard): String = {
    val w = Writer(MessagePack.writer)
    w.writePatternWildcard(o)
    return w.resultBase64
  }

  def toPatternWildcard(data: ISZ[U8]): Pattern.Wildcard = {
    def fPatternWildcard(reader: Reader): Pattern.Wildcard = {
      val r = reader.readPatternWildcard()
      return r
    }
    val r = to(data, fPatternWildcard)
    return r
  }

  def toPatternWildcardBase64(s: String): Pattern.Wildcard = {
    def fPatternWildcard(reader: Reader): Pattern.Wildcard = {
      val r = reader.readPatternWildcard()
      return r
    }
    val r = toBase64(s, fPatternWildcard)
    return r
  }

  def fromPatternSeqWildcard(o: Pattern.SeqWildcard): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writePatternSeqWildcard(o)
    return w.result
  }

  def fromPatternSeqWildcardBase64(o: Pattern.SeqWildcard): String = {
    val w = Writer(MessagePack.writer)
    w.writePatternSeqWildcard(o)
    return w.resultBase64
  }

  def toPatternSeqWildcard(data: ISZ[U8]): Pattern.SeqWildcard = {
    def fPatternSeqWildcard(reader: Reader): Pattern.SeqWildcard = {
      val r = reader.readPatternSeqWildcard()
      return r
    }
    val r = to(data, fPatternSeqWildcard)
    return r
  }

  def toPatternSeqWildcardBase64(s: String): Pattern.SeqWildcard = {
    def fPatternSeqWildcard(reader: Reader): Pattern.SeqWildcard = {
      val r = reader.readPatternSeqWildcard()
      return r
    }
    val r = toBase64(s, fPatternSeqWildcard)
    return r
  }

  def fromPatternStructure(o: Pattern.Structure): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writePatternStructure(o)
    return w.result
  }

  def fromPatternStructureBase64(o: Pattern.Structure): String = {
    val w = Writer(MessagePack.writer)
    w.writePatternStructure(o)
    return w.resultBase64
  }

  def toPatternStructure(data: ISZ[U8]): Pattern.Structure = {
    def fPatternStructure(reader: Reader): Pattern.Structure = {
      val r = reader.readPatternStructure()
      return r
    }
    val r = to(data, fPatternStructure)
    return r
  }

  def toPatternStructureBase64(s: String): Pattern.Structure = {
    def fPatternStructure(reader: Reader): Pattern.Structure = {
      val r = reader.readPatternStructure()
      return r
    }
    val r = toBase64(s, fPatternStructure)
    return r
  }

  def fromExp(o: Exp): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExp(o)
    return w.result
  }

  def fromExpBase64(o: Exp): String = {
    val w = Writer(MessagePack.writer)
    w.writeExp(o)
    return w.resultBase64
  }

  def toExp(data: ISZ[U8]): Exp = {
    def fExp(reader: Reader): Exp = {
      val r = reader.readExp()
      return r
    }
    val r = to(data, fExp)
    return r
  }

  def toExpBase64(s: String): Exp = {
    def fExp(reader: Reader): Exp = {
      val r = reader.readExp()
      return r
    }
    val r = toBase64(s, fExp)
    return r
  }

  def fromLit(o: Lit): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeLit(o)
    return w.result
  }

  def fromLitBase64(o: Lit): String = {
    val w = Writer(MessagePack.writer)
    w.writeLit(o)
    return w.resultBase64
  }

  def toLit(data: ISZ[U8]): Lit = {
    def fLit(reader: Reader): Lit = {
      val r = reader.readLit()
      return r
    }
    val r = to(data, fLit)
    return r
  }

  def toLitBase64(s: String): Lit = {
    def fLit(reader: Reader): Lit = {
      val r = reader.readLit()
      return r
    }
    val r = toBase64(s, fLit)
    return r
  }

  def fromExpLitB(o: Exp.LitB): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpLitB(o)
    return w.result
  }

  def fromExpLitBBase64(o: Exp.LitB): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpLitB(o)
    return w.resultBase64
  }

  def toExpLitB(data: ISZ[U8]): Exp.LitB = {
    def fExpLitB(reader: Reader): Exp.LitB = {
      val r = reader.readExpLitB()
      return r
    }
    val r = to(data, fExpLitB)
    return r
  }

  def toExpLitBBase64(s: String): Exp.LitB = {
    def fExpLitB(reader: Reader): Exp.LitB = {
      val r = reader.readExpLitB()
      return r
    }
    val r = toBase64(s, fExpLitB)
    return r
  }

  def fromExpLitC(o: Exp.LitC): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpLitC(o)
    return w.result
  }

  def fromExpLitCBase64(o: Exp.LitC): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpLitC(o)
    return w.resultBase64
  }

  def toExpLitC(data: ISZ[U8]): Exp.LitC = {
    def fExpLitC(reader: Reader): Exp.LitC = {
      val r = reader.readExpLitC()
      return r
    }
    val r = to(data, fExpLitC)
    return r
  }

  def toExpLitCBase64(s: String): Exp.LitC = {
    def fExpLitC(reader: Reader): Exp.LitC = {
      val r = reader.readExpLitC()
      return r
    }
    val r = toBase64(s, fExpLitC)
    return r
  }

  def fromExpLitZ(o: Exp.LitZ): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpLitZ(o)
    return w.result
  }

  def fromExpLitZBase64(o: Exp.LitZ): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpLitZ(o)
    return w.resultBase64
  }

  def toExpLitZ(data: ISZ[U8]): Exp.LitZ = {
    def fExpLitZ(reader: Reader): Exp.LitZ = {
      val r = reader.readExpLitZ()
      return r
    }
    val r = to(data, fExpLitZ)
    return r
  }

  def toExpLitZBase64(s: String): Exp.LitZ = {
    def fExpLitZ(reader: Reader): Exp.LitZ = {
      val r = reader.readExpLitZ()
      return r
    }
    val r = toBase64(s, fExpLitZ)
    return r
  }

  def fromExpLitF32(o: Exp.LitF32): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpLitF32(o)
    return w.result
  }

  def fromExpLitF32Base64(o: Exp.LitF32): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpLitF32(o)
    return w.resultBase64
  }

  def toExpLitF32(data: ISZ[U8]): Exp.LitF32 = {
    def fExpLitF32(reader: Reader): Exp.LitF32 = {
      val r = reader.readExpLitF32()
      return r
    }
    val r = to(data, fExpLitF32)
    return r
  }

  def toExpLitF32Base64(s: String): Exp.LitF32 = {
    def fExpLitF32(reader: Reader): Exp.LitF32 = {
      val r = reader.readExpLitF32()
      return r
    }
    val r = toBase64(s, fExpLitF32)
    return r
  }

  def fromExpLitF64(o: Exp.LitF64): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpLitF64(o)
    return w.result
  }

  def fromExpLitF64Base64(o: Exp.LitF64): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpLitF64(o)
    return w.resultBase64
  }

  def toExpLitF64(data: ISZ[U8]): Exp.LitF64 = {
    def fExpLitF64(reader: Reader): Exp.LitF64 = {
      val r = reader.readExpLitF64()
      return r
    }
    val r = to(data, fExpLitF64)
    return r
  }

  def toExpLitF64Base64(s: String): Exp.LitF64 = {
    def fExpLitF64(reader: Reader): Exp.LitF64 = {
      val r = reader.readExpLitF64()
      return r
    }
    val r = toBase64(s, fExpLitF64)
    return r
  }

  def fromExpLitR(o: Exp.LitR): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpLitR(o)
    return w.result
  }

  def fromExpLitRBase64(o: Exp.LitR): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpLitR(o)
    return w.resultBase64
  }

  def toExpLitR(data: ISZ[U8]): Exp.LitR = {
    def fExpLitR(reader: Reader): Exp.LitR = {
      val r = reader.readExpLitR()
      return r
    }
    val r = to(data, fExpLitR)
    return r
  }

  def toExpLitRBase64(s: String): Exp.LitR = {
    def fExpLitR(reader: Reader): Exp.LitR = {
      val r = reader.readExpLitR()
      return r
    }
    val r = toBase64(s, fExpLitR)
    return r
  }

  def fromExpLitBv(o: Exp.LitBv): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpLitBv(o)
    return w.result
  }

  def fromExpLitBvBase64(o: Exp.LitBv): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpLitBv(o)
    return w.resultBase64
  }

  def toExpLitBv(data: ISZ[U8]): Exp.LitBv = {
    def fExpLitBv(reader: Reader): Exp.LitBv = {
      val r = reader.readExpLitBv()
      return r
    }
    val r = to(data, fExpLitBv)
    return r
  }

  def toExpLitBvBase64(s: String): Exp.LitBv = {
    def fExpLitBv(reader: Reader): Exp.LitBv = {
      val r = reader.readExpLitBv()
      return r
    }
    val r = toBase64(s, fExpLitBv)
    return r
  }

  def fromExpLitString(o: Exp.LitString): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpLitString(o)
    return w.result
  }

  def fromExpLitStringBase64(o: Exp.LitString): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpLitString(o)
    return w.resultBase64
  }

  def toExpLitString(data: ISZ[U8]): Exp.LitString = {
    def fExpLitString(reader: Reader): Exp.LitString = {
      val r = reader.readExpLitString()
      return r
    }
    val r = to(data, fExpLitString)
    return r
  }

  def toExpLitStringBase64(s: String): Exp.LitString = {
    def fExpLitString(reader: Reader): Exp.LitString = {
      val r = reader.readExpLitString()
      return r
    }
    val r = toBase64(s, fExpLitString)
    return r
  }

  def fromExpStringInterpolate(o: Exp.StringInterpolate): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpStringInterpolate(o)
    return w.result
  }

  def fromExpStringInterpolateBase64(o: Exp.StringInterpolate): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpStringInterpolate(o)
    return w.resultBase64
  }

  def toExpStringInterpolate(data: ISZ[U8]): Exp.StringInterpolate = {
    def fExpStringInterpolate(reader: Reader): Exp.StringInterpolate = {
      val r = reader.readExpStringInterpolate()
      return r
    }
    val r = to(data, fExpStringInterpolate)
    return r
  }

  def toExpStringInterpolateBase64(s: String): Exp.StringInterpolate = {
    def fExpStringInterpolate(reader: Reader): Exp.StringInterpolate = {
      val r = reader.readExpStringInterpolate()
      return r
    }
    val r = toBase64(s, fExpStringInterpolate)
    return r
  }

  def fromExpThis(o: Exp.This): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpThis(o)
    return w.result
  }

  def fromExpThisBase64(o: Exp.This): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpThis(o)
    return w.resultBase64
  }

  def toExpThis(data: ISZ[U8]): Exp.This = {
    def fExpThis(reader: Reader): Exp.This = {
      val r = reader.readExpThis()
      return r
    }
    val r = to(data, fExpThis)
    return r
  }

  def toExpThisBase64(s: String): Exp.This = {
    def fExpThis(reader: Reader): Exp.This = {
      val r = reader.readExpThis()
      return r
    }
    val r = toBase64(s, fExpThis)
    return r
  }

  def fromExpSuper(o: Exp.Super): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpSuper(o)
    return w.result
  }

  def fromExpSuperBase64(o: Exp.Super): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpSuper(o)
    return w.resultBase64
  }

  def toExpSuper(data: ISZ[U8]): Exp.Super = {
    def fExpSuper(reader: Reader): Exp.Super = {
      val r = reader.readExpSuper()
      return r
    }
    val r = to(data, fExpSuper)
    return r
  }

  def toExpSuperBase64(s: String): Exp.Super = {
    def fExpSuper(reader: Reader): Exp.Super = {
      val r = reader.readExpSuper()
      return r
    }
    val r = toBase64(s, fExpSuper)
    return r
  }

  def fromExpUnary(o: Exp.Unary): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpUnary(o)
    return w.result
  }

  def fromExpUnaryBase64(o: Exp.Unary): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpUnary(o)
    return w.resultBase64
  }

  def toExpUnary(data: ISZ[U8]): Exp.Unary = {
    def fExpUnary(reader: Reader): Exp.Unary = {
      val r = reader.readExpUnary()
      return r
    }
    val r = to(data, fExpUnary)
    return r
  }

  def toExpUnaryBase64(s: String): Exp.Unary = {
    def fExpUnary(reader: Reader): Exp.Unary = {
      val r = reader.readExpUnary()
      return r
    }
    val r = toBase64(s, fExpUnary)
    return r
  }

  def fromExpBinary(o: Exp.Binary): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpBinary(o)
    return w.result
  }

  def fromExpBinaryBase64(o: Exp.Binary): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpBinary(o)
    return w.resultBase64
  }

  def toExpBinary(data: ISZ[U8]): Exp.Binary = {
    def fExpBinary(reader: Reader): Exp.Binary = {
      val r = reader.readExpBinary()
      return r
    }
    val r = to(data, fExpBinary)
    return r
  }

  def toExpBinaryBase64(s: String): Exp.Binary = {
    def fExpBinary(reader: Reader): Exp.Binary = {
      val r = reader.readExpBinary()
      return r
    }
    val r = toBase64(s, fExpBinary)
    return r
  }

  def fromExpIdent(o: Exp.Ident): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpIdent(o)
    return w.result
  }

  def fromExpIdentBase64(o: Exp.Ident): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpIdent(o)
    return w.resultBase64
  }

  def toExpIdent(data: ISZ[U8]): Exp.Ident = {
    def fExpIdent(reader: Reader): Exp.Ident = {
      val r = reader.readExpIdent()
      return r
    }
    val r = to(data, fExpIdent)
    return r
  }

  def toExpIdentBase64(s: String): Exp.Ident = {
    def fExpIdent(reader: Reader): Exp.Ident = {
      val r = reader.readExpIdent()
      return r
    }
    val r = toBase64(s, fExpIdent)
    return r
  }

  def fromExpEta(o: Exp.Eta): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpEta(o)
    return w.result
  }

  def fromExpEtaBase64(o: Exp.Eta): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpEta(o)
    return w.resultBase64
  }

  def toExpEta(data: ISZ[U8]): Exp.Eta = {
    def fExpEta(reader: Reader): Exp.Eta = {
      val r = reader.readExpEta()
      return r
    }
    val r = to(data, fExpEta)
    return r
  }

  def toExpEtaBase64(s: String): Exp.Eta = {
    def fExpEta(reader: Reader): Exp.Eta = {
      val r = reader.readExpEta()
      return r
    }
    val r = toBase64(s, fExpEta)
    return r
  }

  def fromExpTuple(o: Exp.Tuple): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpTuple(o)
    return w.result
  }

  def fromExpTupleBase64(o: Exp.Tuple): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpTuple(o)
    return w.resultBase64
  }

  def toExpTuple(data: ISZ[U8]): Exp.Tuple = {
    def fExpTuple(reader: Reader): Exp.Tuple = {
      val r = reader.readExpTuple()
      return r
    }
    val r = to(data, fExpTuple)
    return r
  }

  def toExpTupleBase64(s: String): Exp.Tuple = {
    def fExpTuple(reader: Reader): Exp.Tuple = {
      val r = reader.readExpTuple()
      return r
    }
    val r = toBase64(s, fExpTuple)
    return r
  }

  def fromExpSelect(o: Exp.Select): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpSelect(o)
    return w.result
  }

  def fromExpSelectBase64(o: Exp.Select): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpSelect(o)
    return w.resultBase64
  }

  def toExpSelect(data: ISZ[U8]): Exp.Select = {
    def fExpSelect(reader: Reader): Exp.Select = {
      val r = reader.readExpSelect()
      return r
    }
    val r = to(data, fExpSelect)
    return r
  }

  def toExpSelectBase64(s: String): Exp.Select = {
    def fExpSelect(reader: Reader): Exp.Select = {
      val r = reader.readExpSelect()
      return r
    }
    val r = toBase64(s, fExpSelect)
    return r
  }

  def fromExpInvoke(o: Exp.Invoke): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpInvoke(o)
    return w.result
  }

  def fromExpInvokeBase64(o: Exp.Invoke): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpInvoke(o)
    return w.resultBase64
  }

  def toExpInvoke(data: ISZ[U8]): Exp.Invoke = {
    def fExpInvoke(reader: Reader): Exp.Invoke = {
      val r = reader.readExpInvoke()
      return r
    }
    val r = to(data, fExpInvoke)
    return r
  }

  def toExpInvokeBase64(s: String): Exp.Invoke = {
    def fExpInvoke(reader: Reader): Exp.Invoke = {
      val r = reader.readExpInvoke()
      return r
    }
    val r = toBase64(s, fExpInvoke)
    return r
  }

  def fromExpInvokeNamed(o: Exp.InvokeNamed): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpInvokeNamed(o)
    return w.result
  }

  def fromExpInvokeNamedBase64(o: Exp.InvokeNamed): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpInvokeNamed(o)
    return w.resultBase64
  }

  def toExpInvokeNamed(data: ISZ[U8]): Exp.InvokeNamed = {
    def fExpInvokeNamed(reader: Reader): Exp.InvokeNamed = {
      val r = reader.readExpInvokeNamed()
      return r
    }
    val r = to(data, fExpInvokeNamed)
    return r
  }

  def toExpInvokeNamedBase64(s: String): Exp.InvokeNamed = {
    def fExpInvokeNamed(reader: Reader): Exp.InvokeNamed = {
      val r = reader.readExpInvokeNamed()
      return r
    }
    val r = toBase64(s, fExpInvokeNamed)
    return r
  }

  def fromExpIf(o: Exp.If): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpIf(o)
    return w.result
  }

  def fromExpIfBase64(o: Exp.If): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpIf(o)
    return w.resultBase64
  }

  def toExpIf(data: ISZ[U8]): Exp.If = {
    def fExpIf(reader: Reader): Exp.If = {
      val r = reader.readExpIf()
      return r
    }
    val r = to(data, fExpIf)
    return r
  }

  def toExpIfBase64(s: String): Exp.If = {
    def fExpIf(reader: Reader): Exp.If = {
      val r = reader.readExpIf()
      return r
    }
    val r = toBase64(s, fExpIf)
    return r
  }

  def fromExpFun(o: Exp.Fun): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpFun(o)
    return w.result
  }

  def fromExpFunBase64(o: Exp.Fun): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpFun(o)
    return w.resultBase64
  }

  def toExpFun(data: ISZ[U8]): Exp.Fun = {
    def fExpFun(reader: Reader): Exp.Fun = {
      val r = reader.readExpFun()
      return r
    }
    val r = to(data, fExpFun)
    return r
  }

  def toExpFunBase64(s: String): Exp.Fun = {
    def fExpFun(reader: Reader): Exp.Fun = {
      val r = reader.readExpFun()
      return r
    }
    val r = toBase64(s, fExpFun)
    return r
  }

  def fromExpForYield(o: Exp.ForYield): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpForYield(o)
    return w.result
  }

  def fromExpForYieldBase64(o: Exp.ForYield): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpForYield(o)
    return w.resultBase64
  }

  def toExpForYield(data: ISZ[U8]): Exp.ForYield = {
    def fExpForYield(reader: Reader): Exp.ForYield = {
      val r = reader.readExpForYield()
      return r
    }
    val r = to(data, fExpForYield)
    return r
  }

  def toExpForYieldBase64(s: String): Exp.ForYield = {
    def fExpForYield(reader: Reader): Exp.ForYield = {
      val r = reader.readExpForYield()
      return r
    }
    val r = toBase64(s, fExpForYield)
    return r
  }

  def fromExpQuant(o: Exp.Quant): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeExpQuant(o)
    return w.result
  }

  def fromExpQuantBase64(o: Exp.Quant): String = {
    val w = Writer(MessagePack.writer)
    w.writeExpQuant(o)
    return w.resultBase64
  }

  def toExpQuant(data: ISZ[U8]): Exp.Quant = {
    def fExpQuant(reader: Reader): Exp.Quant = {
      val r = reader.readExpQuant()
      return r
    }
    val r = to(data, fExpQuant)
    return r
  }

  def toExpQuantBase64(s: String): Exp.Quant = {
    def fExpQuant(reader: Reader): Exp.Quant = {
      val r = reader.readExpQuant()
      return r
    }
    val r = toBase64(s, fExpQuant)
    return r
  }

  def fromNamedArg(o: NamedArg): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeNamedArg(o)
    return w.result
  }

  def fromNamedArgBase64(o: NamedArg): String = {
    val w = Writer(MessagePack.writer)
    w.writeNamedArg(o)
    return w.resultBase64
  }

  def toNamedArg(data: ISZ[U8]): NamedArg = {
    def fNamedArg(reader: Reader): NamedArg = {
      val r = reader.readNamedArg()
      return r
    }
    val r = to(data, fNamedArg)
    return r
  }

  def toNamedArgBase64(s: String): NamedArg = {
    def fNamedArg(reader: Reader): NamedArg = {
      val r = reader.readNamedArg()
      return r
    }
    val r = toBase64(s, fNamedArg)
    return r
  }

  def fromVarFragment(o: VarFragment): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeVarFragment(o)
    return w.result
  }

  def fromVarFragmentBase64(o: VarFragment): String = {
    val w = Writer(MessagePack.writer)
    w.writeVarFragment(o)
    return w.resultBase64
  }

  def toVarFragment(data: ISZ[U8]): VarFragment = {
    def fVarFragment(reader: Reader): VarFragment = {
      val r = reader.readVarFragment()
      return r
    }
    val r = to(data, fVarFragment)
    return r
  }

  def toVarFragmentBase64(s: String): VarFragment = {
    def fVarFragment(reader: Reader): VarFragment = {
      val r = reader.readVarFragment()
      return r
    }
    val r = toBase64(s, fVarFragment)
    return r
  }

  def fromDomain(o: Domain): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeDomain(o)
    return w.result
  }

  def fromDomainBase64(o: Domain): String = {
    val w = Writer(MessagePack.writer)
    w.writeDomain(o)
    return w.resultBase64
  }

  def toDomain(data: ISZ[U8]): Domain = {
    def fDomain(reader: Reader): Domain = {
      val r = reader.readDomain()
      return r
    }
    val r = to(data, fDomain)
    return r
  }

  def toDomainBase64(s: String): Domain = {
    def fDomain(reader: Reader): Domain = {
      val r = reader.readDomain()
      return r
    }
    val r = toBase64(s, fDomain)
    return r
  }

  def fromDomainType(o: Domain.Type): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeDomainType(o)
    return w.result
  }

  def fromDomainTypeBase64(o: Domain.Type): String = {
    val w = Writer(MessagePack.writer)
    w.writeDomainType(o)
    return w.resultBase64
  }

  def toDomainType(data: ISZ[U8]): Domain.Type = {
    def fDomainType(reader: Reader): Domain.Type = {
      val r = reader.readDomainType()
      return r
    }
    val r = to(data, fDomainType)
    return r
  }

  def toDomainTypeBase64(s: String): Domain.Type = {
    def fDomainType(reader: Reader): Domain.Type = {
      val r = reader.readDomainType()
      return r
    }
    val r = toBase64(s, fDomainType)
    return r
  }

  def fromDomainRange(o: Domain.Range): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeDomainRange(o)
    return w.result
  }

  def fromDomainRangeBase64(o: Domain.Range): String = {
    val w = Writer(MessagePack.writer)
    w.writeDomainRange(o)
    return w.resultBase64
  }

  def toDomainRange(data: ISZ[U8]): Domain.Range = {
    def fDomainRange(reader: Reader): Domain.Range = {
      val r = reader.readDomainRange()
      return r
    }
    val r = to(data, fDomainRange)
    return r
  }

  def toDomainRangeBase64(s: String): Domain.Range = {
    def fDomainRange(reader: Reader): Domain.Range = {
      val r = reader.readDomainRange()
      return r
    }
    val r = toBase64(s, fDomainRange)
    return r
  }

  def fromId(o: Id): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeId(o)
    return w.result
  }

  def fromIdBase64(o: Id): String = {
    val w = Writer(MessagePack.writer)
    w.writeId(o)
    return w.resultBase64
  }

  def toId(data: ISZ[U8]): Id = {
    def fId(reader: Reader): Id = {
      val r = reader.readId()
      return r
    }
    val r = to(data, fId)
    return r
  }

  def toIdBase64(s: String): Id = {
    def fId(reader: Reader): Id = {
      val r = reader.readId()
      return r
    }
    val r = toBase64(s, fId)
    return r
  }

  def fromName(o: Name): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeName(o)
    return w.result
  }

  def fromNameBase64(o: Name): String = {
    val w = Writer(MessagePack.writer)
    w.writeName(o)
    return w.resultBase64
  }

  def toName(data: ISZ[U8]): Name = {
    def fName(reader: Reader): Name = {
      val r = reader.readName()
      return r
    }
    val r = to(data, fName)
    return r
  }

  def toNameBase64(s: String): Name = {
    def fName(reader: Reader): Name = {
      val r = reader.readName()
      return r
    }
    val r = toBase64(s, fName)
    return r
  }

  def fromBody(o: Body): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeBody(o)
    return w.result
  }

  def fromBodyBase64(o: Body): String = {
    val w = Writer(MessagePack.writer)
    w.writeBody(o)
    return w.resultBase64
  }

  def toBody(data: ISZ[U8]): Body = {
    def fBody(reader: Reader): Body = {
      val r = reader.readBody()
      return r
    }
    val r = to(data, fBody)
    return r
  }

  def toBodyBase64(s: String): Body = {
    def fBody(reader: Reader): Body = {
      val r = reader.readBody()
      return r
    }
    val r = toBase64(s, fBody)
    return r
  }

  def fromAbstractDatatypeParam(o: AbstractDatatypeParam): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeAbstractDatatypeParam(o)
    return w.result
  }

  def fromAbstractDatatypeParamBase64(o: AbstractDatatypeParam): String = {
    val w = Writer(MessagePack.writer)
    w.writeAbstractDatatypeParam(o)
    return w.resultBase64
  }

  def toAbstractDatatypeParam(data: ISZ[U8]): AbstractDatatypeParam = {
    def fAbstractDatatypeParam(reader: Reader): AbstractDatatypeParam = {
      val r = reader.readAbstractDatatypeParam()
      return r
    }
    val r = to(data, fAbstractDatatypeParam)
    return r
  }

  def toAbstractDatatypeParamBase64(s: String): AbstractDatatypeParam = {
    def fAbstractDatatypeParam(reader: Reader): AbstractDatatypeParam = {
      val r = reader.readAbstractDatatypeParam()
      return r
    }
    val r = toBase64(s, fAbstractDatatypeParam)
    return r
  }

  def fromMethodSig(o: MethodSig): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeMethodSig(o)
    return w.result
  }

  def fromMethodSigBase64(o: MethodSig): String = {
    val w = Writer(MessagePack.writer)
    w.writeMethodSig(o)
    return w.resultBase64
  }

  def toMethodSig(data: ISZ[U8]): MethodSig = {
    def fMethodSig(reader: Reader): MethodSig = {
      val r = reader.readMethodSig()
      return r
    }
    val r = to(data, fMethodSig)
    return r
  }

  def toMethodSigBase64(s: String): MethodSig = {
    def fMethodSig(reader: Reader): MethodSig = {
      val r = reader.readMethodSig()
      return r
    }
    val r = toBase64(s, fMethodSig)
    return r
  }

  def fromParam(o: Param): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeParam(o)
    return w.result
  }

  def fromParamBase64(o: Param): String = {
    val w = Writer(MessagePack.writer)
    w.writeParam(o)
    return w.resultBase64
  }

  def toParam(data: ISZ[U8]): Param = {
    def fParam(reader: Reader): Param = {
      val r = reader.readParam()
      return r
    }
    val r = to(data, fParam)
    return r
  }

  def toParamBase64(s: String): Param = {
    def fParam(reader: Reader): Param = {
      val r = reader.readParam()
      return r
    }
    val r = toBase64(s, fParam)
    return r
  }

  def fromTypeParam(o: TypeParam): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTypeParam(o)
    return w.result
  }

  def fromTypeParamBase64(o: TypeParam): String = {
    val w = Writer(MessagePack.writer)
    w.writeTypeParam(o)
    return w.resultBase64
  }

  def toTypeParam(data: ISZ[U8]): TypeParam = {
    def fTypeParam(reader: Reader): TypeParam = {
      val r = reader.readTypeParam()
      return r
    }
    val r = to(data, fTypeParam)
    return r
  }

  def toTypeParamBase64(s: String): TypeParam = {
    def fTypeParam(reader: Reader): TypeParam = {
      val r = reader.readTypeParam()
      return r
    }
    val r = toBase64(s, fTypeParam)
    return r
  }

  def fromContract(o: Contract): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeContract(o)
    return w.result
  }

  def fromContractBase64(o: Contract): String = {
    val w = Writer(MessagePack.writer)
    w.writeContract(o)
    return w.resultBase64
  }

  def toContract(data: ISZ[U8]): Contract = {
    def fContract(reader: Reader): Contract = {
      val r = reader.readContract()
      return r
    }
    val r = to(data, fContract)
    return r
  }

  def toContractBase64(s: String): Contract = {
    def fContract(reader: Reader): Contract = {
      val r = reader.readContract()
      return r
    }
    val r = toBase64(s, fContract)
    return r
  }

  def fromSubContract(o: SubContract): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeSubContract(o)
    return w.result
  }

  def fromSubContractBase64(o: SubContract): String = {
    val w = Writer(MessagePack.writer)
    w.writeSubContract(o)
    return w.resultBase64
  }

  def toSubContract(data: ISZ[U8]): SubContract = {
    def fSubContract(reader: Reader): SubContract = {
      val r = reader.readSubContract()
      return r
    }
    val r = to(data, fSubContract)
    return r
  }

  def toSubContractBase64(s: String): SubContract = {
    def fSubContract(reader: Reader): SubContract = {
      val r = reader.readSubContract()
      return r
    }
    val r = toBase64(s, fSubContract)
    return r
  }

  def fromSubContractParam(o: SubContractParam): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeSubContractParam(o)
    return w.result
  }

  def fromSubContractParamBase64(o: SubContractParam): String = {
    val w = Writer(MessagePack.writer)
    w.writeSubContractParam(o)
    return w.resultBase64
  }

  def toSubContractParam(data: ISZ[U8]): SubContractParam = {
    def fSubContractParam(reader: Reader): SubContractParam = {
      val r = reader.readSubContractParam()
      return r
    }
    val r = to(data, fSubContractParam)
    return r
  }

  def toSubContractParamBase64(s: String): SubContractParam = {
    def fSubContractParam(reader: Reader): SubContractParam = {
      val r = reader.readSubContractParam()
      return r
    }
    val r = toBase64(s, fSubContractParam)
    return r
  }

  def fromWhereDef(o: WhereDef): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeWhereDef(o)
    return w.result
  }

  def fromWhereDefBase64(o: WhereDef): String = {
    val w = Writer(MessagePack.writer)
    w.writeWhereDef(o)
    return w.resultBase64
  }

  def toWhereDef(data: ISZ[U8]): WhereDef = {
    def fWhereDef(reader: Reader): WhereDef = {
      val r = reader.readWhereDef()
      return r
    }
    val r = to(data, fWhereDef)
    return r
  }

  def toWhereDefBase64(s: String): WhereDef = {
    def fWhereDef(reader: Reader): WhereDef = {
      val r = reader.readWhereDef()
      return r
    }
    val r = toBase64(s, fWhereDef)
    return r
  }

  def fromWhereDefVal(o: WhereDef.Val): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeWhereDefVal(o)
    return w.result
  }

  def fromWhereDefValBase64(o: WhereDef.Val): String = {
    val w = Writer(MessagePack.writer)
    w.writeWhereDefVal(o)
    return w.resultBase64
  }

  def toWhereDefVal(data: ISZ[U8]): WhereDef.Val = {
    def fWhereDefVal(reader: Reader): WhereDef.Val = {
      val r = reader.readWhereDefVal()
      return r
    }
    val r = to(data, fWhereDefVal)
    return r
  }

  def toWhereDefValBase64(s: String): WhereDef.Val = {
    def fWhereDefVal(reader: Reader): WhereDef.Val = {
      val r = reader.readWhereDefVal()
      return r
    }
    val r = toBase64(s, fWhereDefVal)
    return r
  }

  def fromWhereDefDef(o: WhereDef.Def): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeWhereDefDef(o)
    return w.result
  }

  def fromWhereDefDefBase64(o: WhereDef.Def): String = {
    val w = Writer(MessagePack.writer)
    w.writeWhereDefDef(o)
    return w.resultBase64
  }

  def toWhereDefDef(data: ISZ[U8]): WhereDef.Def = {
    def fWhereDefDef(reader: Reader): WhereDef.Def = {
      val r = reader.readWhereDefDef()
      return r
    }
    val r = to(data, fWhereDefDef)
    return r
  }

  def toWhereDefDefBase64(s: String): WhereDef.Def = {
    def fWhereDefDef(reader: Reader): WhereDef.Def = {
      val r = reader.readWhereDefDef()
      return r
    }
    val r = toBase64(s, fWhereDefDef)
    return r
  }

  def fromSpecDef(o: SpecDef): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeSpecDef(o)
    return w.result
  }

  def fromSpecDefBase64(o: SpecDef): String = {
    val w = Writer(MessagePack.writer)
    w.writeSpecDef(o)
    return w.resultBase64
  }

  def toSpecDef(data: ISZ[U8]): SpecDef = {
    def fSpecDef(reader: Reader): SpecDef = {
      val r = reader.readSpecDef()
      return r
    }
    val r = to(data, fSpecDef)
    return r
  }

  def toSpecDefBase64(s: String): SpecDef = {
    def fSpecDef(reader: Reader): SpecDef = {
      val r = reader.readSpecDef()
      return r
    }
    val r = toBase64(s, fSpecDef)
    return r
  }

  def fromProofStep(o: ProofStep): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeProofStep(o)
    return w.result
  }

  def fromProofStepBase64(o: ProofStep): String = {
    val w = Writer(MessagePack.writer)
    w.writeProofStep(o)
    return w.resultBase64
  }

  def toProofStep(data: ISZ[U8]): ProofStep = {
    def fProofStep(reader: Reader): ProofStep = {
      val r = reader.readProofStep()
      return r
    }
    val r = to(data, fProofStep)
    return r
  }

  def toProofStepBase64(s: String): ProofStep = {
    def fProofStep(reader: Reader): ProofStep = {
      val r = reader.readProofStep()
      return r
    }
    val r = toBase64(s, fProofStep)
    return r
  }

  def fromProofStepBasic(o: ProofStep.Basic): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeProofStepBasic(o)
    return w.result
  }

  def fromProofStepBasicBase64(o: ProofStep.Basic): String = {
    val w = Writer(MessagePack.writer)
    w.writeProofStepBasic(o)
    return w.resultBase64
  }

  def toProofStepBasic(data: ISZ[U8]): ProofStep.Basic = {
    def fProofStepBasic(reader: Reader): ProofStep.Basic = {
      val r = reader.readProofStepBasic()
      return r
    }
    val r = to(data, fProofStepBasic)
    return r
  }

  def toProofStepBasicBase64(s: String): ProofStep.Basic = {
    def fProofStepBasic(reader: Reader): ProofStep.Basic = {
      val r = reader.readProofStepBasic()
      return r
    }
    val r = toBase64(s, fProofStepBasic)
    return r
  }

  def fromProofStepSubProof(o: ProofStep.SubProof): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeProofStepSubProof(o)
    return w.result
  }

  def fromProofStepSubProofBase64(o: ProofStep.SubProof): String = {
    val w = Writer(MessagePack.writer)
    w.writeProofStepSubProof(o)
    return w.resultBase64
  }

  def toProofStepSubProof(data: ISZ[U8]): ProofStep.SubProof = {
    def fProofStepSubProof(reader: Reader): ProofStep.SubProof = {
      val r = reader.readProofStepSubProof()
      return r
    }
    val r = to(data, fProofStepSubProof)
    return r
  }

  def toProofStepSubProofBase64(s: String): ProofStep.SubProof = {
    def fProofStepSubProof(reader: Reader): ProofStep.SubProof = {
      val r = reader.readProofStepSubProof()
      return r
    }
    val r = toBase64(s, fProofStepSubProof)
    return r
  }

  def fromAssumeProofStep(o: AssumeProofStep): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeAssumeProofStep(o)
    return w.result
  }

  def fromAssumeProofStepBase64(o: AssumeProofStep): String = {
    val w = Writer(MessagePack.writer)
    w.writeAssumeProofStep(o)
    return w.resultBase64
  }

  def toAssumeProofStep(data: ISZ[U8]): AssumeProofStep = {
    def fAssumeProofStep(reader: Reader): AssumeProofStep = {
      val r = reader.readAssumeProofStep()
      return r
    }
    val r = to(data, fAssumeProofStep)
    return r
  }

  def toAssumeProofStepBase64(s: String): AssumeProofStep = {
    def fAssumeProofStep(reader: Reader): AssumeProofStep = {
      val r = reader.readAssumeProofStep()
      return r
    }
    val r = toBase64(s, fAssumeProofStep)
    return r
  }

  def fromAssumeProofStepRegular(o: AssumeProofStep.Regular): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeAssumeProofStepRegular(o)
    return w.result
  }

  def fromAssumeProofStepRegularBase64(o: AssumeProofStep.Regular): String = {
    val w = Writer(MessagePack.writer)
    w.writeAssumeProofStepRegular(o)
    return w.resultBase64
  }

  def toAssumeProofStepRegular(data: ISZ[U8]): AssumeProofStep.Regular = {
    def fAssumeProofStepRegular(reader: Reader): AssumeProofStep.Regular = {
      val r = reader.readAssumeProofStepRegular()
      return r
    }
    val r = to(data, fAssumeProofStepRegular)
    return r
  }

  def toAssumeProofStepRegularBase64(s: String): AssumeProofStep.Regular = {
    def fAssumeProofStepRegular(reader: Reader): AssumeProofStep.Regular = {
      val r = reader.readAssumeProofStepRegular()
      return r
    }
    val r = toBase64(s, fAssumeProofStepRegular)
    return r
  }

  def fromAssumeProofStepForallIntroAps(o: AssumeProofStep.ForallIntroAps): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeAssumeProofStepForallIntroAps(o)
    return w.result
  }

  def fromAssumeProofStepForallIntroApsBase64(o: AssumeProofStep.ForallIntroAps): String = {
    val w = Writer(MessagePack.writer)
    w.writeAssumeProofStepForallIntroAps(o)
    return w.resultBase64
  }

  def toAssumeProofStepForallIntroAps(data: ISZ[U8]): AssumeProofStep.ForallIntroAps = {
    def fAssumeProofStepForallIntroAps(reader: Reader): AssumeProofStep.ForallIntroAps = {
      val r = reader.readAssumeProofStepForallIntroAps()
      return r
    }
    val r = to(data, fAssumeProofStepForallIntroAps)
    return r
  }

  def toAssumeProofStepForallIntroApsBase64(s: String): AssumeProofStep.ForallIntroAps = {
    def fAssumeProofStepForallIntroAps(reader: Reader): AssumeProofStep.ForallIntroAps = {
      val r = reader.readAssumeProofStepForallIntroAps()
      return r
    }
    val r = toBase64(s, fAssumeProofStepForallIntroAps)
    return r
  }

  def fromAssumeProofStepExistsElimAps(o: AssumeProofStep.ExistsElimAps): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeAssumeProofStepExistsElimAps(o)
    return w.result
  }

  def fromAssumeProofStepExistsElimApsBase64(o: AssumeProofStep.ExistsElimAps): String = {
    val w = Writer(MessagePack.writer)
    w.writeAssumeProofStepExistsElimAps(o)
    return w.resultBase64
  }

  def toAssumeProofStepExistsElimAps(data: ISZ[U8]): AssumeProofStep.ExistsElimAps = {
    def fAssumeProofStepExistsElimAps(reader: Reader): AssumeProofStep.ExistsElimAps = {
      val r = reader.readAssumeProofStepExistsElimAps()
      return r
    }
    val r = to(data, fAssumeProofStepExistsElimAps)
    return r
  }

  def toAssumeProofStepExistsElimApsBase64(s: String): AssumeProofStep.ExistsElimAps = {
    def fAssumeProofStepExistsElimAps(reader: Reader): AssumeProofStep.ExistsElimAps = {
      val r = reader.readAssumeProofStepExistsElimAps()
      return r
    }
    val r = toBase64(s, fAssumeProofStepExistsElimAps)
    return r
  }

  def fromJust(o: Just): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJust(o)
    return w.result
  }

  def fromJustBase64(o: Just): String = {
    val w = Writer(MessagePack.writer)
    w.writeJust(o)
    return w.resultBase64
  }

  def toJust(data: ISZ[U8]): Just = {
    def fJust(reader: Reader): Just = {
      val r = reader.readJust()
      return r
    }
    val r = to(data, fJust)
    return r
  }

  def toJustBase64(s: String): Just = {
    def fJust(reader: Reader): Just = {
      val r = reader.readJust()
      return r
    }
    val r = toBase64(s, fJust)
    return r
  }

  def fromJustPremise(o: Just.Premise): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustPremise(o)
    return w.result
  }

  def fromJustPremiseBase64(o: Just.Premise): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustPremise(o)
    return w.resultBase64
  }

  def toJustPremise(data: ISZ[U8]): Just.Premise = {
    def fJustPremise(reader: Reader): Just.Premise = {
      val r = reader.readJustPremise()
      return r
    }
    val r = to(data, fJustPremise)
    return r
  }

  def toJustPremiseBase64(s: String): Just.Premise = {
    def fJustPremise(reader: Reader): Just.Premise = {
      val r = reader.readJustPremise()
      return r
    }
    val r = toBase64(s, fJustPremise)
    return r
  }

  def fromJustAndIntro(o: Just.AndIntro): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustAndIntro(o)
    return w.result
  }

  def fromJustAndIntroBase64(o: Just.AndIntro): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustAndIntro(o)
    return w.resultBase64
  }

  def toJustAndIntro(data: ISZ[U8]): Just.AndIntro = {
    def fJustAndIntro(reader: Reader): Just.AndIntro = {
      val r = reader.readJustAndIntro()
      return r
    }
    val r = to(data, fJustAndIntro)
    return r
  }

  def toJustAndIntroBase64(s: String): Just.AndIntro = {
    def fJustAndIntro(reader: Reader): Just.AndIntro = {
      val r = reader.readJustAndIntro()
      return r
    }
    val r = toBase64(s, fJustAndIntro)
    return r
  }

  def fromJustAndElim(o: Just.AndElim): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustAndElim(o)
    return w.result
  }

  def fromJustAndElimBase64(o: Just.AndElim): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustAndElim(o)
    return w.resultBase64
  }

  def toJustAndElim(data: ISZ[U8]): Just.AndElim = {
    def fJustAndElim(reader: Reader): Just.AndElim = {
      val r = reader.readJustAndElim()
      return r
    }
    val r = to(data, fJustAndElim)
    return r
  }

  def toJustAndElimBase64(s: String): Just.AndElim = {
    def fJustAndElim(reader: Reader): Just.AndElim = {
      val r = reader.readJustAndElim()
      return r
    }
    val r = toBase64(s, fJustAndElim)
    return r
  }

  def fromJustOrIntro(o: Just.OrIntro): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustOrIntro(o)
    return w.result
  }

  def fromJustOrIntroBase64(o: Just.OrIntro): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustOrIntro(o)
    return w.resultBase64
  }

  def toJustOrIntro(data: ISZ[U8]): Just.OrIntro = {
    def fJustOrIntro(reader: Reader): Just.OrIntro = {
      val r = reader.readJustOrIntro()
      return r
    }
    val r = to(data, fJustOrIntro)
    return r
  }

  def toJustOrIntroBase64(s: String): Just.OrIntro = {
    def fJustOrIntro(reader: Reader): Just.OrIntro = {
      val r = reader.readJustOrIntro()
      return r
    }
    val r = toBase64(s, fJustOrIntro)
    return r
  }

  def fromJustOrElim(o: Just.OrElim): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustOrElim(o)
    return w.result
  }

  def fromJustOrElimBase64(o: Just.OrElim): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustOrElim(o)
    return w.resultBase64
  }

  def toJustOrElim(data: ISZ[U8]): Just.OrElim = {
    def fJustOrElim(reader: Reader): Just.OrElim = {
      val r = reader.readJustOrElim()
      return r
    }
    val r = to(data, fJustOrElim)
    return r
  }

  def toJustOrElimBase64(s: String): Just.OrElim = {
    def fJustOrElim(reader: Reader): Just.OrElim = {
      val r = reader.readJustOrElim()
      return r
    }
    val r = toBase64(s, fJustOrElim)
    return r
  }

  def fromJustImplyIntro(o: Just.ImplyIntro): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustImplyIntro(o)
    return w.result
  }

  def fromJustImplyIntroBase64(o: Just.ImplyIntro): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustImplyIntro(o)
    return w.resultBase64
  }

  def toJustImplyIntro(data: ISZ[U8]): Just.ImplyIntro = {
    def fJustImplyIntro(reader: Reader): Just.ImplyIntro = {
      val r = reader.readJustImplyIntro()
      return r
    }
    val r = to(data, fJustImplyIntro)
    return r
  }

  def toJustImplyIntroBase64(s: String): Just.ImplyIntro = {
    def fJustImplyIntro(reader: Reader): Just.ImplyIntro = {
      val r = reader.readJustImplyIntro()
      return r
    }
    val r = toBase64(s, fJustImplyIntro)
    return r
  }

  def fromJustImplyElim(o: Just.ImplyElim): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustImplyElim(o)
    return w.result
  }

  def fromJustImplyElimBase64(o: Just.ImplyElim): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustImplyElim(o)
    return w.resultBase64
  }

  def toJustImplyElim(data: ISZ[U8]): Just.ImplyElim = {
    def fJustImplyElim(reader: Reader): Just.ImplyElim = {
      val r = reader.readJustImplyElim()
      return r
    }
    val r = to(data, fJustImplyElim)
    return r
  }

  def toJustImplyElimBase64(s: String): Just.ImplyElim = {
    def fJustImplyElim(reader: Reader): Just.ImplyElim = {
      val r = reader.readJustImplyElim()
      return r
    }
    val r = toBase64(s, fJustImplyElim)
    return r
  }

  def fromJustNegIntro(o: Just.NegIntro): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustNegIntro(o)
    return w.result
  }

  def fromJustNegIntroBase64(o: Just.NegIntro): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustNegIntro(o)
    return w.resultBase64
  }

  def toJustNegIntro(data: ISZ[U8]): Just.NegIntro = {
    def fJustNegIntro(reader: Reader): Just.NegIntro = {
      val r = reader.readJustNegIntro()
      return r
    }
    val r = to(data, fJustNegIntro)
    return r
  }

  def toJustNegIntroBase64(s: String): Just.NegIntro = {
    def fJustNegIntro(reader: Reader): Just.NegIntro = {
      val r = reader.readJustNegIntro()
      return r
    }
    val r = toBase64(s, fJustNegIntro)
    return r
  }

  def fromJustNegElim(o: Just.NegElim): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustNegElim(o)
    return w.result
  }

  def fromJustNegElimBase64(o: Just.NegElim): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustNegElim(o)
    return w.resultBase64
  }

  def toJustNegElim(data: ISZ[U8]): Just.NegElim = {
    def fJustNegElim(reader: Reader): Just.NegElim = {
      val r = reader.readJustNegElim()
      return r
    }
    val r = to(data, fJustNegElim)
    return r
  }

  def toJustNegElimBase64(s: String): Just.NegElim = {
    def fJustNegElim(reader: Reader): Just.NegElim = {
      val r = reader.readJustNegElim()
      return r
    }
    val r = toBase64(s, fJustNegElim)
    return r
  }

  def fromJustBottomElim(o: Just.BottomElim): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustBottomElim(o)
    return w.result
  }

  def fromJustBottomElimBase64(o: Just.BottomElim): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustBottomElim(o)
    return w.resultBase64
  }

  def toJustBottomElim(data: ISZ[U8]): Just.BottomElim = {
    def fJustBottomElim(reader: Reader): Just.BottomElim = {
      val r = reader.readJustBottomElim()
      return r
    }
    val r = to(data, fJustBottomElim)
    return r
  }

  def toJustBottomElimBase64(s: String): Just.BottomElim = {
    def fJustBottomElim(reader: Reader): Just.BottomElim = {
      val r = reader.readJustBottomElim()
      return r
    }
    val r = toBase64(s, fJustBottomElim)
    return r
  }

  def fromJustPbc(o: Just.Pbc): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustPbc(o)
    return w.result
  }

  def fromJustPbcBase64(o: Just.Pbc): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustPbc(o)
    return w.resultBase64
  }

  def toJustPbc(data: ISZ[U8]): Just.Pbc = {
    def fJustPbc(reader: Reader): Just.Pbc = {
      val r = reader.readJustPbc()
      return r
    }
    val r = to(data, fJustPbc)
    return r
  }

  def toJustPbcBase64(s: String): Just.Pbc = {
    def fJustPbc(reader: Reader): Just.Pbc = {
      val r = reader.readJustPbc()
      return r
    }
    val r = toBase64(s, fJustPbc)
    return r
  }

  def fromJustForallIntro(o: Just.ForallIntro): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustForallIntro(o)
    return w.result
  }

  def fromJustForallIntroBase64(o: Just.ForallIntro): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustForallIntro(o)
    return w.resultBase64
  }

  def toJustForallIntro(data: ISZ[U8]): Just.ForallIntro = {
    def fJustForallIntro(reader: Reader): Just.ForallIntro = {
      val r = reader.readJustForallIntro()
      return r
    }
    val r = to(data, fJustForallIntro)
    return r
  }

  def toJustForallIntroBase64(s: String): Just.ForallIntro = {
    def fJustForallIntro(reader: Reader): Just.ForallIntro = {
      val r = reader.readJustForallIntro()
      return r
    }
    val r = toBase64(s, fJustForallIntro)
    return r
  }

  def fromJustForallElim(o: Just.ForallElim): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustForallElim(o)
    return w.result
  }

  def fromJustForallElimBase64(o: Just.ForallElim): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustForallElim(o)
    return w.resultBase64
  }

  def toJustForallElim(data: ISZ[U8]): Just.ForallElim = {
    def fJustForallElim(reader: Reader): Just.ForallElim = {
      val r = reader.readJustForallElim()
      return r
    }
    val r = to(data, fJustForallElim)
    return r
  }

  def toJustForallElimBase64(s: String): Just.ForallElim = {
    def fJustForallElim(reader: Reader): Just.ForallElim = {
      val r = reader.readJustForallElim()
      return r
    }
    val r = toBase64(s, fJustForallElim)
    return r
  }

  def fromJustExistsIntro(o: Just.ExistsIntro): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustExistsIntro(o)
    return w.result
  }

  def fromJustExistsIntroBase64(o: Just.ExistsIntro): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustExistsIntro(o)
    return w.resultBase64
  }

  def toJustExistsIntro(data: ISZ[U8]): Just.ExistsIntro = {
    def fJustExistsIntro(reader: Reader): Just.ExistsIntro = {
      val r = reader.readJustExistsIntro()
      return r
    }
    val r = to(data, fJustExistsIntro)
    return r
  }

  def toJustExistsIntroBase64(s: String): Just.ExistsIntro = {
    def fJustExistsIntro(reader: Reader): Just.ExistsIntro = {
      val r = reader.readJustExistsIntro()
      return r
    }
    val r = toBase64(s, fJustExistsIntro)
    return r
  }

  def fromJustExistsElim(o: Just.ExistsElim): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustExistsElim(o)
    return w.result
  }

  def fromJustExistsElimBase64(o: Just.ExistsElim): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustExistsElim(o)
    return w.resultBase64
  }

  def toJustExistsElim(data: ISZ[U8]): Just.ExistsElim = {
    def fJustExistsElim(reader: Reader): Just.ExistsElim = {
      val r = reader.readJustExistsElim()
      return r
    }
    val r = to(data, fJustExistsElim)
    return r
  }

  def toJustExistsElimBase64(s: String): Just.ExistsElim = {
    def fJustExistsElim(reader: Reader): Just.ExistsElim = {
      val r = reader.readJustExistsElim()
      return r
    }
    val r = toBase64(s, fJustExistsElim)
    return r
  }

  def fromJustFact(o: Just.Fact): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustFact(o)
    return w.result
  }

  def fromJustFactBase64(o: Just.Fact): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustFact(o)
    return w.resultBase64
  }

  def toJustFact(data: ISZ[U8]): Just.Fact = {
    def fJustFact(reader: Reader): Just.Fact = {
      val r = reader.readJustFact()
      return r
    }
    val r = to(data, fJustFact)
    return r
  }

  def toJustFactBase64(s: String): Just.Fact = {
    def fJustFact(reader: Reader): Just.Fact = {
      val r = reader.readJustFact()
      return r
    }
    val r = toBase64(s, fJustFact)
    return r
  }

  def fromJustInvariant(o: Just.Invariant): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustInvariant(o)
    return w.result
  }

  def fromJustInvariantBase64(o: Just.Invariant): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustInvariant(o)
    return w.resultBase64
  }

  def toJustInvariant(data: ISZ[U8]): Just.Invariant = {
    def fJustInvariant(reader: Reader): Just.Invariant = {
      val r = reader.readJustInvariant()
      return r
    }
    val r = to(data, fJustInvariant)
    return r
  }

  def toJustInvariantBase64(s: String): Just.Invariant = {
    def fJustInvariant(reader: Reader): Just.Invariant = {
      val r = reader.readJustInvariant()
      return r
    }
    val r = toBase64(s, fJustInvariant)
    return r
  }

  def fromJustSubst(o: Just.Subst): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustSubst(o)
    return w.result
  }

  def fromJustSubstBase64(o: Just.Subst): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustSubst(o)
    return w.resultBase64
  }

  def toJustSubst(data: ISZ[U8]): Just.Subst = {
    def fJustSubst(reader: Reader): Just.Subst = {
      val r = reader.readJustSubst()
      return r
    }
    val r = to(data, fJustSubst)
    return r
  }

  def toJustSubstBase64(s: String): Just.Subst = {
    def fJustSubst(reader: Reader): Just.Subst = {
      val r = reader.readJustSubst()
      return r
    }
    val r = toBase64(s, fJustSubst)
    return r
  }

  def fromJustAuto(o: Just.Auto): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustAuto(o)
    return w.result
  }

  def fromJustAutoBase64(o: Just.Auto): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustAuto(o)
    return w.resultBase64
  }

  def toJustAuto(data: ISZ[U8]): Just.Auto = {
    def fJustAuto(reader: Reader): Just.Auto = {
      val r = reader.readJustAuto()
      return r
    }
    val r = to(data, fJustAuto)
    return r
  }

  def toJustAutoBase64(s: String): Just.Auto = {
    def fJustAuto(reader: Reader): Just.Auto = {
      val r = reader.readJustAuto()
      return r
    }
    val r = toBase64(s, fJustAuto)
    return r
  }

  def fromJustCoq(o: Just.Coq): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeJustCoq(o)
    return w.result
  }

  def fromJustCoqBase64(o: Just.Coq): String = {
    val w = Writer(MessagePack.writer)
    w.writeJustCoq(o)
    return w.resultBase64
  }

  def toJustCoq(data: ISZ[U8]): Just.Coq = {
    def fJustCoq(reader: Reader): Just.Coq = {
      val r = reader.readJustCoq()
      return r
    }
    val r = to(data, fJustCoq)
    return r
  }

  def toJustCoqBase64(s: String): Just.Coq = {
    def fJustCoq(reader: Reader): Just.Coq = {
      val r = reader.readJustCoq()
      return r
    }
    val r = toBase64(s, fJustCoq)
    return r
  }

  def fromTruthTableRow(o: TruthTable.Row): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTruthTableRow(o)
    return w.result
  }

  def fromTruthTableRowBase64(o: TruthTable.Row): String = {
    val w = Writer(MessagePack.writer)
    w.writeTruthTableRow(o)
    return w.resultBase64
  }

  def toTruthTableRow(data: ISZ[U8]): TruthTable.Row = {
    def fTruthTableRow(reader: Reader): TruthTable.Row = {
      val r = reader.readTruthTableRow()
      return r
    }
    val r = to(data, fTruthTableRow)
    return r
  }

  def toTruthTableRowBase64(s: String): TruthTable.Row = {
    def fTruthTableRow(reader: Reader): TruthTable.Row = {
      val r = reader.readTruthTableRow()
      return r
    }
    val r = toBase64(s, fTruthTableRow)
    return r
  }

  def fromTruthTableAssignment(o: TruthTable.Assignment): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTruthTableAssignment(o)
    return w.result
  }

  def fromTruthTableAssignmentBase64(o: TruthTable.Assignment): String = {
    val w = Writer(MessagePack.writer)
    w.writeTruthTableAssignment(o)
    return w.resultBase64
  }

  def toTruthTableAssignment(data: ISZ[U8]): TruthTable.Assignment = {
    def fTruthTableAssignment(reader: Reader): TruthTable.Assignment = {
      val r = reader.readTruthTableAssignment()
      return r
    }
    val r = to(data, fTruthTableAssignment)
    return r
  }

  def toTruthTableAssignmentBase64(s: String): TruthTable.Assignment = {
    def fTruthTableAssignment(reader: Reader): TruthTable.Assignment = {
      val r = reader.readTruthTableAssignment()
      return r
    }
    val r = toBase64(s, fTruthTableAssignment)
    return r
  }

  def fromTruthTableConclusion(o: TruthTable.Conclusion): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTruthTableConclusion(o)
    return w.result
  }

  def fromTruthTableConclusionBase64(o: TruthTable.Conclusion): String = {
    val w = Writer(MessagePack.writer)
    w.writeTruthTableConclusion(o)
    return w.resultBase64
  }

  def toTruthTableConclusion(data: ISZ[U8]): TruthTable.Conclusion = {
    def fTruthTableConclusion(reader: Reader): TruthTable.Conclusion = {
      val r = reader.readTruthTableConclusion()
      return r
    }
    val r = to(data, fTruthTableConclusion)
    return r
  }

  def toTruthTableConclusionBase64(s: String): TruthTable.Conclusion = {
    def fTruthTableConclusion(reader: Reader): TruthTable.Conclusion = {
      val r = reader.readTruthTableConclusion()
      return r
    }
    val r = toBase64(s, fTruthTableConclusion)
    return r
  }

  def fromTruthTableConclusionValidity(o: TruthTable.Conclusion.Validity): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTruthTableConclusionValidity(o)
    return w.result
  }

  def fromTruthTableConclusionValidityBase64(o: TruthTable.Conclusion.Validity): String = {
    val w = Writer(MessagePack.writer)
    w.writeTruthTableConclusionValidity(o)
    return w.resultBase64
  }

  def toTruthTableConclusionValidity(data: ISZ[U8]): TruthTable.Conclusion.Validity = {
    def fTruthTableConclusionValidity(reader: Reader): TruthTable.Conclusion.Validity = {
      val r = reader.readTruthTableConclusionValidity()
      return r
    }
    val r = to(data, fTruthTableConclusionValidity)
    return r
  }

  def toTruthTableConclusionValidityBase64(s: String): TruthTable.Conclusion.Validity = {
    def fTruthTableConclusionValidity(reader: Reader): TruthTable.Conclusion.Validity = {
      val r = reader.readTruthTableConclusionValidity()
      return r
    }
    val r = toBase64(s, fTruthTableConclusionValidity)
    return r
  }

  def fromTruthTableConclusionTautology(o: TruthTable.Conclusion.Tautology): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTruthTableConclusionTautology(o)
    return w.result
  }

  def fromTruthTableConclusionTautologyBase64(o: TruthTable.Conclusion.Tautology): String = {
    val w = Writer(MessagePack.writer)
    w.writeTruthTableConclusionTautology(o)
    return w.resultBase64
  }

  def toTruthTableConclusionTautology(data: ISZ[U8]): TruthTable.Conclusion.Tautology = {
    def fTruthTableConclusionTautology(reader: Reader): TruthTable.Conclusion.Tautology = {
      val r = reader.readTruthTableConclusionTautology()
      return r
    }
    val r = to(data, fTruthTableConclusionTautology)
    return r
  }

  def toTruthTableConclusionTautologyBase64(s: String): TruthTable.Conclusion.Tautology = {
    def fTruthTableConclusionTautology(reader: Reader): TruthTable.Conclusion.Tautology = {
      val r = reader.readTruthTableConclusionTautology()
      return r
    }
    val r = toBase64(s, fTruthTableConclusionTautology)
    return r
  }

  def fromTruthTableConclusionContradictory(o: TruthTable.Conclusion.Contradictory): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTruthTableConclusionContradictory(o)
    return w.result
  }

  def fromTruthTableConclusionContradictoryBase64(o: TruthTable.Conclusion.Contradictory): String = {
    val w = Writer(MessagePack.writer)
    w.writeTruthTableConclusionContradictory(o)
    return w.resultBase64
  }

  def toTruthTableConclusionContradictory(data: ISZ[U8]): TruthTable.Conclusion.Contradictory = {
    def fTruthTableConclusionContradictory(reader: Reader): TruthTable.Conclusion.Contradictory = {
      val r = reader.readTruthTableConclusionContradictory()
      return r
    }
    val r = to(data, fTruthTableConclusionContradictory)
    return r
  }

  def toTruthTableConclusionContradictoryBase64(s: String): TruthTable.Conclusion.Contradictory = {
    def fTruthTableConclusionContradictory(reader: Reader): TruthTable.Conclusion.Contradictory = {
      val r = reader.readTruthTableConclusionContradictory()
      return r
    }
    val r = toBase64(s, fTruthTableConclusionContradictory)
    return r
  }

  def fromTruthTableConclusionContingent(o: TruthTable.Conclusion.Contingent): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTruthTableConclusionContingent(o)
    return w.result
  }

  def fromTruthTableConclusionContingentBase64(o: TruthTable.Conclusion.Contingent): String = {
    val w = Writer(MessagePack.writer)
    w.writeTruthTableConclusionContingent(o)
    return w.resultBase64
  }

  def toTruthTableConclusionContingent(data: ISZ[U8]): TruthTable.Conclusion.Contingent = {
    def fTruthTableConclusionContingent(reader: Reader): TruthTable.Conclusion.Contingent = {
      val r = reader.readTruthTableConclusionContingent()
      return r
    }
    val r = to(data, fTruthTableConclusionContingent)
    return r
  }

  def toTruthTableConclusionContingentBase64(s: String): TruthTable.Conclusion.Contingent = {
    def fTruthTableConclusionContingent(reader: Reader): TruthTable.Conclusion.Contingent = {
      val r = reader.readTruthTableConclusionContingent()
      return r
    }
    val r = toBase64(s, fTruthTableConclusionContingent)
    return r
  }

  def fromTyped(o: Typed): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTyped(o)
    return w.result
  }

  def fromTypedBase64(o: Typed): String = {
    val w = Writer(MessagePack.writer)
    w.writeTyped(o)
    return w.resultBase64
  }

  def toTyped(data: ISZ[U8]): Typed = {
    def fTyped(reader: Reader): Typed = {
      val r = reader.readTyped()
      return r
    }
    val r = to(data, fTyped)
    return r
  }

  def toTypedBase64(s: String): Typed = {
    def fTyped(reader: Reader): Typed = {
      val r = reader.readTyped()
      return r
    }
    val r = toBase64(s, fTyped)
    return r
  }

  def fromTypedName(o: Typed.Name): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTypedName(o)
    return w.result
  }

  def fromTypedNameBase64(o: Typed.Name): String = {
    val w = Writer(MessagePack.writer)
    w.writeTypedName(o)
    return w.resultBase64
  }

  def toTypedName(data: ISZ[U8]): Typed.Name = {
    def fTypedName(reader: Reader): Typed.Name = {
      val r = reader.readTypedName()
      return r
    }
    val r = to(data, fTypedName)
    return r
  }

  def toTypedNameBase64(s: String): Typed.Name = {
    def fTypedName(reader: Reader): Typed.Name = {
      val r = reader.readTypedName()
      return r
    }
    val r = toBase64(s, fTypedName)
    return r
  }

  def fromTypedTuple(o: Typed.Tuple): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTypedTuple(o)
    return w.result
  }

  def fromTypedTupleBase64(o: Typed.Tuple): String = {
    val w = Writer(MessagePack.writer)
    w.writeTypedTuple(o)
    return w.resultBase64
  }

  def toTypedTuple(data: ISZ[U8]): Typed.Tuple = {
    def fTypedTuple(reader: Reader): Typed.Tuple = {
      val r = reader.readTypedTuple()
      return r
    }
    val r = to(data, fTypedTuple)
    return r
  }

  def toTypedTupleBase64(s: String): Typed.Tuple = {
    def fTypedTuple(reader: Reader): Typed.Tuple = {
      val r = reader.readTypedTuple()
      return r
    }
    val r = toBase64(s, fTypedTuple)
    return r
  }

  def fromTypedFun(o: Typed.Fun): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTypedFun(o)
    return w.result
  }

  def fromTypedFunBase64(o: Typed.Fun): String = {
    val w = Writer(MessagePack.writer)
    w.writeTypedFun(o)
    return w.resultBase64
  }

  def toTypedFun(data: ISZ[U8]): Typed.Fun = {
    def fTypedFun(reader: Reader): Typed.Fun = {
      val r = reader.readTypedFun()
      return r
    }
    val r = to(data, fTypedFun)
    return r
  }

  def toTypedFunBase64(s: String): Typed.Fun = {
    def fTypedFun(reader: Reader): Typed.Fun = {
      val r = reader.readTypedFun()
      return r
    }
    val r = toBase64(s, fTypedFun)
    return r
  }

  def fromAttr(o: Attr): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeAttr(o)
    return w.result
  }

  def fromAttrBase64(o: Attr): String = {
    val w = Writer(MessagePack.writer)
    w.writeAttr(o)
    return w.resultBase64
  }

  def toAttr(data: ISZ[U8]): Attr = {
    def fAttr(reader: Reader): Attr = {
      val r = reader.readAttr()
      return r
    }
    val r = to(data, fAttr)
    return r
  }

  def toAttrBase64(s: String): Attr = {
    def fAttr(reader: Reader): Attr = {
      val r = reader.readAttr()
      return r
    }
    val r = toBase64(s, fAttr)
    return r
  }

  def fromTypedAttr(o: TypedAttr): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeTypedAttr(o)
    return w.result
  }

  def fromTypedAttrBase64(o: TypedAttr): String = {
    val w = Writer(MessagePack.writer)
    w.writeTypedAttr(o)
    return w.resultBase64
  }

  def toTypedAttr(data: ISZ[U8]): TypedAttr = {
    def fTypedAttr(reader: Reader): TypedAttr = {
      val r = reader.readTypedAttr()
      return r
    }
    val r = to(data, fTypedAttr)
    return r
  }

  def toTypedAttrBase64(s: String): TypedAttr = {
    def fTypedAttr(reader: Reader): TypedAttr = {
      val r = reader.readTypedAttr()
      return r
    }
    val r = toBase64(s, fTypedAttr)
    return r
  }

  def fromResolvedAttr(o: ResolvedAttr): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeResolvedAttr(o)
    return w.result
  }

  def fromResolvedAttrBase64(o: ResolvedAttr): String = {
    val w = Writer(MessagePack.writer)
    w.writeResolvedAttr(o)
    return w.resultBase64
  }

  def toResolvedAttr(data: ISZ[U8]): ResolvedAttr = {
    def fResolvedAttr(reader: Reader): ResolvedAttr = {
      val r = reader.readResolvedAttr()
      return r
    }
    val r = to(data, fResolvedAttr)
    return r
  }

  def toResolvedAttrBase64(s: String): ResolvedAttr = {
    def fResolvedAttr(reader: Reader): ResolvedAttr = {
      val r = reader.readResolvedAttr()
      return r
    }
    val r = toBase64(s, fResolvedAttr)
    return r
  }

  def fromResolvedInfo(o: ResolvedInfo): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writeResolvedInfo(o)
    return w.result
  }

  def fromResolvedInfoBase64(o: ResolvedInfo): String = {
    val w = Writer(MessagePack.writer)
    w.writeResolvedInfo(o)
    return w.resultBase64
  }

  def toResolvedInfo(data: ISZ[U8]): ResolvedInfo = {
    def fResolvedInfo(reader: Reader): ResolvedInfo = {
      val r = reader.readResolvedInfo()
      return r
    }
    val r = to(data, fResolvedInfo)
    return r
  }

  def toResolvedInfoBase64(s: String): ResolvedInfo = {
    def fResolvedInfo(reader: Reader): ResolvedInfo = {
      val r = reader.readResolvedInfo()
      return r
    }
    val r = toBase64(s, fResolvedInfo)
    return r
  }

  def fromPosInfo(o: PosInfo): ISZ[U8] = {
    val w = Writer(MessagePack.writer)
    w.writePosInfo(o)
    return w.result
  }

  def fromPosInfoBase64(o: PosInfo): String = {
    val w = Writer(MessagePack.writer)
    w.writePosInfo(o)
    return w.resultBase64
  }

  def toPosInfo(data: ISZ[U8]): PosInfo = {
    def fPosInfo(reader: Reader): PosInfo = {
      val r = reader.readPosInfo()
      return r
    }
    val r = to(data, fPosInfo)
    return r
  }

  def toPosInfoBase64(s: String): PosInfo = {
    def fPosInfo(reader: Reader): PosInfo = {
      val r = reader.readPosInfo()
      return r
    }
    val r = toBase64(s, fPosInfo)
    return r
  }

}