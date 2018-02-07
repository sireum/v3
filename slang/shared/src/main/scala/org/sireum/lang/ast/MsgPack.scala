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

    val StmtBlock: Z = 21

    val StmtIf: Z = 22

    val StmtMatch: Z = 23

    val StmtWhile: Z = 24

    val StmtDoWhile: Z = 25

    val StmtFor: Z = 26

    val StmtReturn: Z = 27

    val StmtLStmt: Z = 28

    val StmtExpr: Z = 29

    val LClauseInvariants: Z = 30

    val LClauseFacts: Z = 31

    val LClauseFact: Z = 32

    val LClauseTheorems: Z = 33

    val LClauseTheorem: Z = 34

    val LClauseSequent: Z = 35

    val LClauseProof: Z = 36

    val ContractExp: Z = 37

    val Case: Z = 38

    val EnumGenRangeExpr: Z = 39

    val EnumGenRangeIndices: Z = 40

    val EnumGenRangeStep: Z = 41

    val EnumGenFor: Z = 42

    val TypeNamed: Z = 43

    val TypeFun: Z = 44

    val TypeTuple: Z = 45

    val PatternLiteral: Z = 46

    val PatternLitInterpolate: Z = 47

    val PatternRef: Z = 48

    val PatternVarBinding: Z = 49

    val PatternWildcard: Z = 50

    val PatternSeqWildcard: Z = 51

    val PatternStructure: Z = 52

    val ExpLitB: Z = 53

    val ExpLitC: Z = 54

    val ExpLitZ: Z = 55

    val ExpLitF32: Z = 56

    val ExpLitF64: Z = 57

    val ExpLitR: Z = 58

    val ExpLitString: Z = 59

    val ExpStringInterpolate: Z = 60

    val ExpThis: Z = 61

    val ExpSuper: Z = 62

    val ExpUnary: Z = 63

    val ExpBinary: Z = 64

    val ExpIdent: Z = 65

    val ExpEta: Z = 66

    val ExpTuple: Z = 67

    val ExpSelect: Z = 68

    val ExpInvoke: Z = 69

    val ExpInvokeNamed: Z = 70

    val ExpIf: Z = 71

    val ExpFunParam: Z = 72

    val ExpFun: Z = 73

    val ExpForYield: Z = 74

    val ExpQuant: Z = 75

    val NamedArg: Z = 76

    val VarFragment: Z = 77

    val DomainType: Z = 78

    val DomainRange: Z = 79

    val Id: Z = 80

    val Name: Z = 81

    val Body: Z = 82

    val AbstractDatatypeParam: Z = 83

    val MethodSig: Z = 84

    val Param: Z = 85

    val TypeParam: Z = 86

    val Contract: Z = 87

    val SubContract: Z = 88

    val WhereDefVal: Z = 89

    val WhereDefDef: Z = 90

    val SpecDef: Z = 91

    val ProofStepBasic: Z = 92

    val ProofStepSubProof: Z = 93

    val AssumeProofStepRegular: Z = 94

    val AssumeProofStepForallIntroAps: Z = 95

    val AssumeProofStepExistsElimAps: Z = 96

    val JustPremise: Z = 97

    val JustAndIntro: Z = 98

    val JustAndElim: Z = 99

    val JustOrIntro: Z = 100

    val JustOrElim: Z = 101

    val JustImplyIntro: Z = 102

    val JustImplyElim: Z = 103

    val JustNegIntro: Z = 104

    val JustNegElim: Z = 105

    val JustBottomElim: Z = 106

    val JustPbc: Z = 107

    val JustForallIntro: Z = 108

    val JustForallElim: Z = 109

    val JustExistsIntro: Z = 110

    val JustExistsElim: Z = 111

    val JustFact: Z = 112

    val JustInvariant: Z = 113

    val JustSubst: Z = 114

    val JustAuto: Z = 115

    val JustCoq: Z = 116

    val TruthTableRow: Z = 117

    val TruthTableAssignment: Z = 118

    val TruthTableConclusionValidity: Z = 119

    val TruthTableConclusionTautology: Z = 120

    val TruthTableConclusionContradictory: Z = 121

    val TruthTableConclusionContingent: Z = 122

    val TypedName: Z = 123

    val TypedTuple: Z = 124

    val TypedFun: Z = 125

    val TypedTypeVar: Z = 126

    val TypedPackage: Z = 127

    val TypedObject: Z = 128

    val TypedEnum: Z = 129

    val TypedMethodSubst: Z = 130

    val TypedMethod: Z = 131

    val TypedMethods: Z = 132

    val Attr: Z = 133

    val TypedAttr: Z = 134

    val ResolvedAttr: Z = 135

    val ResolvedInfoBuiltIn: Z = 136

    val ResolvedInfoPackage: Z = 137

    val ResolvedInfoEnum: Z = 138

    val ResolvedInfoEnumElement: Z = 139

    val ResolvedInfoObject: Z = 140

    val ResolvedInfoVar: Z = 141

    val ResolvedInfoMethod: Z = 142

    val ResolvedInfoType: Z = 143

    val ResolvedInfoTuple: Z = 144

    val ResolvedInfoLocalVar: Z = 145

    val PosInfo: Z = 146

  }

  object Writer {

    @record class Default(val writer: MessagePack.Writer) extends Writer

  }

  @msig trait Writer {

    def writer: MessagePack.Writer

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
        case o: Stmt.Return => writeStmtReturn(o)
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

    def writeStmtBlock(o: Stmt.Block): Unit = {
      writer.writeZ(Constants.StmtBlock)
      writeBody(o.body)
      writeAttr(o.attr)
    }

    def writeStmtIf(o: Stmt.If): Unit = {
      writer.writeZ(Constants.StmtIf)
      writeExp(o.cond)
      writeBody(o.thenBody)
      writeBody(o.elseBody)
      writeAttr(o.attr)
    }

    def writeStmtMatch(o: Stmt.Match): Unit = {
      writer.writeZ(Constants.StmtMatch)
      writeExp(o.exp)
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
      writeTypedAttr(o.attr)
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
      writer.writeOption(o.idOpt, writeId)
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
      writeB(o.isPure)
      writeB(o.isByName)
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
        case o: Pattern.LitInterpolate => writePatternLitInterpolate(o)
        case o: Pattern.Ref => writePatternRef(o)
        case o: Pattern.VarBinding => writePatternVarBinding(o)
        case o: Pattern.Wildcard => writePatternWildcard(o)
        case o: Pattern.SeqWildcard => writePatternSeqWildcard(o)
        case o: Pattern.Structure => writePatternStructure(o)
      }
    }

    def writePatternLiteral(o: Pattern.Literal): Unit = {
      writer.writeZ(Constants.PatternLiteral)
      writeLit(o.lit)
    }

    def writePatternLitInterpolate(o: Pattern.LitInterpolate): Unit = {
      writer.writeZ(Constants.PatternLitInterpolate)
      writeString(o.prefix)
      writeString(o.value)
      writeTypedAttr(o.attr)
    }

    def writePatternRef(o: Pattern.Ref): Unit = {
      writer.writeZ(Constants.PatternRef)
      writeName(o.name)
      writeResolvedAttr(o.attr)
    }

    def writePatternVarBinding(o: Pattern.VarBinding): Unit = {
      writer.writeZ(Constants.PatternVarBinding)
      writeId(o.id)
      writer.writeOption(o.typeOpt, writeType)
      writeAttr(o.attr)
    }

    def writePatternWildcard(o: Pattern.Wildcard): Unit = {
      writer.writeZ(Constants.PatternWildcard)
      writer.writeOption(o.typeOpt, writeType)
      writeAttr(o.attr)
    }

    def writePatternSeqWildcard(o: Pattern.SeqWildcard): Unit = {
      writer.writeZ(Constants.PatternSeqWildcard)
      writeTypedAttr(o.attr)
    }

    def writePatternStructure(o: Pattern.Structure): Unit = {
      writer.writeZ(Constants.PatternStructure)
      writer.writeOption(o.idOpt, writeId)
      writer.writeOption(o.nameOpt, writeName)
      writer.writeISZ(o.patterns, writePattern)
      writeResolvedAttr(o.attr)
    }

    def writeExp(o: Exp): Unit = {
      o match {
        case o: Exp.LitB => writeExpLitB(o)
        case o: Exp.LitC => writeExpLitC(o)
        case o: Exp.LitZ => writeExpLitZ(o)
        case o: Exp.LitF32 => writeExpLitF32(o)
        case o: Exp.LitF64 => writeExpLitF64(o)
        case o: Exp.LitR => writeExpLitR(o)
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
      writeTypedAttr(o.attr)
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

    def writeExpRef(o: Exp.Ref): Unit = {
      o match {
        case o: Exp.Ident => writeExpIdent(o)
        case o: Exp.Select => writeExpSelect(o)
      }
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
      writeExpRef(o.ref)
      writeTypedAttr(o.attr)
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

    def writeExpFunParam(o: Exp.Fun.Param): Unit = {
      writer.writeZ(Constants.ExpFunParam)
      writeId(o.id)
      writer.writeOption(o.tipeOpt, writeType)
    }

    def writeExpFun(o: Exp.Fun): Unit = {
      writer.writeZ(Constants.ExpFun)
      writer.writeISZ(o.params, writeExpFunParam)
      writeContract(o.contract)
      writeAssignExp(o.exp)
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
      writeZ(o.index)
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
      writer.writeISZ(o.undecls, writeString)
    }

    def writeAbstractDatatypeParam(o: AbstractDatatypeParam): Unit = {
      writer.writeZ(Constants.AbstractDatatypeParam)
      writeB(o.isHidden)
      writeB(o.isVal)
      writeId(o.id)
      writeType(o.tipe)
    }

    def writeMethodSig(o: MethodSig): Unit = {
      writer.writeZ(Constants.MethodSig)
      writeB(o.isPure)
      writeId(o.id)
      writer.writeISZ(o.typeParams, writeTypeParam)
      writeB(o.hasParams)
      writer.writeISZ(o.params, writeParam)
      writeType(o.returnType)
    }

    def writeParam(o: Param): Unit = {
      writer.writeZ(Constants.Param)
      writeB(o.isHidden)
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
      writer.writeISZ(o.params, writeId)
      writeContract(o.contract)
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
        case o: Typed.TypeVar => writeTypedTypeVar(o)
        case o: Typed.Package => writeTypedPackage(o)
        case o: Typed.Object => writeTypedObject(o)
        case o: Typed.Enum => writeTypedEnum(o)
        case o: Typed.Method => writeTypedMethod(o)
        case o: Typed.Methods => writeTypedMethods(o)
      }
    }

    def writeTypedName(o: Typed.Name): Unit = {
      writer.writeZ(Constants.TypedName)
      writer.writeISZ(o.ids, writeString)
      writer.writeISZ(o.args, writeTyped)
    }

    def writeTypedTuple(o: Typed.Tuple): Unit = {
      writer.writeZ(Constants.TypedTuple)
      writer.writeISZ(o.args, writeTyped)
    }

    def writeTypedFun(o: Typed.Fun): Unit = {
      writer.writeZ(Constants.TypedFun)
      writeB(o.isPure)
      writeB(o.isByName)
      writer.writeISZ(o.args, writeTyped)
      writeTyped(o.ret)
    }

    def writeTypedTypeVar(o: Typed.TypeVar): Unit = {
      writer.writeZ(Constants.TypedTypeVar)
      writeString(o.id)
    }

    def writeTypedPackage(o: Typed.Package): Unit = {
      writer.writeZ(Constants.TypedPackage)
      writer.writeISZ(o.name, writeString)
    }

    def writeTypedObject(o: Typed.Object): Unit = {
      writer.writeZ(Constants.TypedObject)
      writer.writeISZ(o.owner, writeString)
      writeString(o.id)
    }

    def writeTypedEnum(o: Typed.Enum): Unit = {
      writer.writeZ(Constants.TypedEnum)
      writer.writeISZ(o.name, writeString)
    }

    def writeTypedMethodMode(o: Typed.Method.Mode.Type): Unit = {
      writer.writeZ(o.ordinal)
    }

    def writeTypedMethodSubst(o: Typed.Method.Subst): Unit = {
      writer.writeZ(Constants.TypedMethodSubst)
      writeString(o.id)
      writeTyped(o.tipe)
    }

    def writeTypedMethod(o: Typed.Method): Unit = {
      writer.writeZ(Constants.TypedMethod)
      writeB(o.isInObject)
      writeTypedMethodMode(o.mode)
      writer.writeISZ(o.typeParams, writeString)
      writer.writeISZ(o.owner, writeString)
      writeString(o.name)
      writer.writeISZ(o.paramNames, writeString)
      writer.writeISZ(o.substs, writeTypedMethodSubst)
      writeTypedFun(o.tpe)
    }

    def writeTypedMethods(o: Typed.Methods): Unit = {
      writer.writeZ(Constants.TypedMethods)
      writer.writeISZ(o.methods, writeTypedMethod)
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
      o match {
        case o: ResolvedInfo.BuiltIn => writeResolvedInfoBuiltIn(o)
        case o: ResolvedInfo.Package => writeResolvedInfoPackage(o)
        case o: ResolvedInfo.Enum => writeResolvedInfoEnum(o)
        case o: ResolvedInfo.EnumElement => writeResolvedInfoEnumElement(o)
        case o: ResolvedInfo.Object => writeResolvedInfoObject(o)
        case o: ResolvedInfo.Var => writeResolvedInfoVar(o)
        case o: ResolvedInfo.Method => writeResolvedInfoMethod(o)
        case o: ResolvedInfo.Type => writeResolvedInfoType(o)
        case o: ResolvedInfo.Tuple => writeResolvedInfoTuple(o)
        case o: ResolvedInfo.LocalVar => writeResolvedInfoLocalVar(o)
      }
    }

    def writeResolvedInfoBuiltIn(o: ResolvedInfo.BuiltIn): Unit = {
      writer.writeZ(Constants.ResolvedInfoBuiltIn)
      writeString(o.name)
    }

    def writeResolvedInfoPackage(o: ResolvedInfo.Package): Unit = {
      writer.writeZ(Constants.ResolvedInfoPackage)
      writer.writeISZ(o.name, writeString)
    }

    def writeResolvedInfoEnum(o: ResolvedInfo.Enum): Unit = {
      writer.writeZ(Constants.ResolvedInfoEnum)
      writer.writeISZ(o.name, writeString)
    }

    def writeResolvedInfoEnumElement(o: ResolvedInfo.EnumElement): Unit = {
      writer.writeZ(Constants.ResolvedInfoEnumElement)
      writer.writeISZ(o.owner, writeString)
      writeString(o.name)
      writeZ(o.ordinal)
    }

    def writeResolvedInfoObject(o: ResolvedInfo.Object): Unit = {
      writer.writeZ(Constants.ResolvedInfoObject)
      writer.writeISZ(o.name, writeString)
    }

    def writeResolvedInfoVar(o: ResolvedInfo.Var): Unit = {
      writer.writeZ(Constants.ResolvedInfoVar)
      writeB(o.isInObject)
      writeB(o.isSpec)
      writer.writeISZ(o.owner, writeString)
      writeString(o.id)
    }

    def writeResolvedInfoMethod(o: ResolvedInfo.Method): Unit = {
      writer.writeZ(Constants.ResolvedInfoMethod)
      writeB(o.isInObject)
      writeB(o.isConstructor)
      writeB(o.isSpec)
      writer.writeISZ(o.owner, writeString)
      writeString(o.id)
    }

    def writeResolvedInfoType(o: ResolvedInfo.Type): Unit = {
      writer.writeZ(Constants.ResolvedInfoType)
      writer.writeISZ(o.name, writeString)
    }

    def writeResolvedInfoTuple(o: ResolvedInfo.Tuple): Unit = {
      writer.writeZ(Constants.ResolvedInfoTuple)
      writeZ(o.size)
      writeZ(o.index)
    }

    def writeResolvedInfoLocalVar(o: ResolvedInfo.LocalVar): Unit = {
      writer.writeZ(Constants.ResolvedInfoLocalVar)
      writer.writeISZ(o.context, writeString)
      writeString(o.id)
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

  }

  object Reader {

    @record class Default(val reader: MessagePack.Reader) extends Reader

  }

  @msig trait Reader {

    def reader: MessagePack.Reader

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
        case Constants.StmtReturn => val r = readStmtReturnT(T); return r
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
      val stmts = reader.readISZ(readStmt _)
      val attr = readAttr()
      return Stmt.Sig(isImmutable, isExt, id, typeParams, parents, stmts, attr)
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
      val thenBody = readBody()
      val elseBody = readBody()
      val attr = readAttr()
      return Stmt.If(cond, thenBody, elseBody, attr)
    }

    def readStmtMatch(): Stmt.Match = {
      val r = readStmtMatchT(F)
      return r
    }

    def readStmtMatchT(typeParsed: B): Stmt.Match = {
      if (!typeParsed) {
        reader.expectZ(Constants.StmtMatch)
      }
      val exp = readExp()
      val cases = reader.readISZ(readCase _)
      val attr = readAttr()
      return Stmt.Match(exp, cases, attr)
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
      val attr = readTypedAttr()
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
      val idOpt = reader.readOption(readId _)
      val range = readEnumGenRange()
      val condOpt = reader.readOption(readExp _)
      return EnumGen.For(idOpt, range, condOpt)
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
      val isPure = reader.readB()
      val isByName = reader.readB()
      val args = reader.readISZ(readType _)
      val ret = readType()
      val attr = readTypedAttr()
      return Type.Fun(isPure, isByName, args, ret, attr)
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
        case Constants.PatternLitInterpolate => val r = readPatternLitInterpolateT(T); return r
        case Constants.PatternRef => val r = readPatternRefT(T); return r
        case Constants.PatternVarBinding => val r = readPatternVarBindingT(T); return r
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

    def readPatternLitInterpolate(): Pattern.LitInterpolate = {
      val r = readPatternLitInterpolateT(F)
      return r
    }

    def readPatternLitInterpolateT(typeParsed: B): Pattern.LitInterpolate = {
      if (!typeParsed) {
        reader.expectZ(Constants.PatternLitInterpolate)
      }
      val prefix = reader.readString()
      val value = reader.readString()
      val attr = readTypedAttr()
      return Pattern.LitInterpolate(prefix, value, attr)
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
      val attr = readResolvedAttr()
      return Pattern.Ref(name, attr)
    }

    def readPatternVarBinding(): Pattern.VarBinding = {
      val r = readPatternVarBindingT(F)
      return r
    }

    def readPatternVarBindingT(typeParsed: B): Pattern.VarBinding = {
      if (!typeParsed) {
        reader.expectZ(Constants.PatternVarBinding)
      }
      val id = readId()
      val typeOpt = reader.readOption(readType _)
      val attr = readAttr()
      return Pattern.VarBinding(id, typeOpt, attr)
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
      val attr = readAttr()
      return Pattern.Wildcard(typeOpt, attr)
    }

    def readPatternSeqWildcard(): Pattern.SeqWildcard = {
      val r = readPatternSeqWildcardT(F)
      return r
    }

    def readPatternSeqWildcardT(typeParsed: B): Pattern.SeqWildcard = {
      if (!typeParsed) {
        reader.expectZ(Constants.PatternSeqWildcard)
      }
      val attr = readTypedAttr()
      return Pattern.SeqWildcard(attr)
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
      val attr = readResolvedAttr()
      return Pattern.Structure(idOpt, nameOpt, patterns, attr)
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
      val attr = readTypedAttr()
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

    def readExpRef(): Exp.Ref = {
      val t = reader.readZ()
      t match {
        case Constants.ExpIdent => val r = readExpIdentT(T); return r
        case Constants.ExpSelect => val r = readExpSelectT(T); return r
        case _ => halt(s"Unexpected type code $t.")
      }
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
      val ref = readExpRef()
      val attr = readTypedAttr()
      return Exp.Eta(ref, attr)
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

    def readExpFunParam(): Exp.Fun.Param = {
      val r = readExpFunParamT(F)
      return r
    }

    def readExpFunParamT(typeParsed: B): Exp.Fun.Param = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpFunParam)
      }
      val id = readId()
      val tipeOpt = reader.readOption(readType _)
      return Exp.Fun.Param(id, tipeOpt)
    }

    def readExpFun(): Exp.Fun = {
      val r = readExpFunT(F)
      return r
    }

    def readExpFunT(typeParsed: B): Exp.Fun = {
      if (!typeParsed) {
        reader.expectZ(Constants.ExpFun)
      }
      val params = reader.readISZ(readExpFunParam _)
      val contract = readContract()
      val exp = readAssignExp()
      val attr = readTypedAttr()
      return Exp.Fun(params, contract, exp, attr)
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
      val index = reader.readZ()
      return NamedArg(id, arg, index)
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
      val undecls = reader.readISZ(reader.readString _)
      return Body(stmts, undecls)
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
      val isVal = reader.readB()
      val id = readId()
      val tipe = readType()
      return AbstractDatatypeParam(isHidden, isVal, id, tipe)
    }

    def readMethodSig(): MethodSig = {
      val r = readMethodSigT(F)
      return r
    }

    def readMethodSigT(typeParsed: B): MethodSig = {
      if (!typeParsed) {
        reader.expectZ(Constants.MethodSig)
      }
      val isPure = reader.readB()
      val id = readId()
      val typeParams = reader.readISZ(readTypeParam _)
      val hasParams = reader.readB()
      val params = reader.readISZ(readParam _)
      val returnType = readType()
      return MethodSig(isPure, id, typeParams, hasParams, params, returnType)
    }

    def readParam(): Param = {
      val r = readParamT(F)
      return r
    }

    def readParamT(typeParsed: B): Param = {
      if (!typeParsed) {
        reader.expectZ(Constants.Param)
      }
      val isHidden = reader.readB()
      val id = readId()
      val tipe = readType()
      return Param(isHidden, id, tipe)
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
      val params = reader.readISZ(readId _)
      val contract = readContract()
      return SubContract(id, params, contract)
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
        case Constants.TypedTypeVar => val r = readTypedTypeVarT(T); return r
        case Constants.TypedPackage => val r = readTypedPackageT(T); return r
        case Constants.TypedObject => val r = readTypedObjectT(T); return r
        case Constants.TypedEnum => val r = readTypedEnumT(T); return r
        case Constants.TypedMethod => val r = readTypedMethodT(T); return r
        case Constants.TypedMethods => val r = readTypedMethodsT(T); return r
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
      return Typed.Name(ids, args)
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
      return Typed.Tuple(args)
    }

    def readTypedFun(): Typed.Fun = {
      val r = readTypedFunT(F)
      return r
    }

    def readTypedFunT(typeParsed: B): Typed.Fun = {
      if (!typeParsed) {
        reader.expectZ(Constants.TypedFun)
      }
      val isPure = reader.readB()
      val isByName = reader.readB()
      val args = reader.readISZ(readTyped _)
      val ret = readTyped()
      return Typed.Fun(isPure, isByName, args, ret)
    }

    def readTypedTypeVar(): Typed.TypeVar = {
      val r = readTypedTypeVarT(F)
      return r
    }

    def readTypedTypeVarT(typeParsed: B): Typed.TypeVar = {
      if (!typeParsed) {
        reader.expectZ(Constants.TypedTypeVar)
      }
      val id = reader.readString()
      return Typed.TypeVar(id)
    }

    def readTypedPackage(): Typed.Package = {
      val r = readTypedPackageT(F)
      return r
    }

    def readTypedPackageT(typeParsed: B): Typed.Package = {
      if (!typeParsed) {
        reader.expectZ(Constants.TypedPackage)
      }
      val name = reader.readISZ(reader.readString _)
      return Typed.Package(name)
    }

    def readTypedObject(): Typed.Object = {
      val r = readTypedObjectT(F)
      return r
    }

    def readTypedObjectT(typeParsed: B): Typed.Object = {
      if (!typeParsed) {
        reader.expectZ(Constants.TypedObject)
      }
      val owner = reader.readISZ(reader.readString _)
      val id = reader.readString()
      return Typed.Object(owner, id)
    }

    def readTypedEnum(): Typed.Enum = {
      val r = readTypedEnumT(F)
      return r
    }

    def readTypedEnumT(typeParsed: B): Typed.Enum = {
      if (!typeParsed) {
        reader.expectZ(Constants.TypedEnum)
      }
      val name = reader.readISZ(reader.readString _)
      return Typed.Enum(name)
    }

    def readTypedMethodMode(): Typed.Method.Mode.Type = {
      val r = reader.readZ()
      return Typed.Method.Mode.byOrdinal(r).get
    }

    def readTypedMethodSubst(): Typed.Method.Subst = {
      val r = readTypedMethodSubstT(F)
      return r
    }

    def readTypedMethodSubstT(typeParsed: B): Typed.Method.Subst = {
      if (!typeParsed) {
        reader.expectZ(Constants.TypedMethodSubst)
      }
      val id = reader.readString()
      val tipe = readTyped()
      return Typed.Method.Subst(id, tipe)
    }

    def readTypedMethod(): Typed.Method = {
      val r = readTypedMethodT(F)
      return r
    }

    def readTypedMethodT(typeParsed: B): Typed.Method = {
      if (!typeParsed) {
        reader.expectZ(Constants.TypedMethod)
      }
      val isInObject = reader.readB()
      val mode = readTypedMethodMode()
      val typeParams = reader.readISZ(reader.readString _)
      val owner = reader.readISZ(reader.readString _)
      val name = reader.readString()
      val paramNames = reader.readISZ(reader.readString _)
      val substs = reader.readISZ(readTypedMethodSubst _)
      val tpe = readTypedFun()
      return Typed.Method(isInObject, mode, typeParams, owner, name, paramNames, substs, tpe)
    }

    def readTypedMethods(): Typed.Methods = {
      val r = readTypedMethodsT(F)
      return r
    }

    def readTypedMethodsT(typeParsed: B): Typed.Methods = {
      if (!typeParsed) {
        reader.expectZ(Constants.TypedMethods)
      }
      val methods = reader.readISZ(readTypedMethod _)
      return Typed.Methods(methods)
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
      val t = reader.readZ()
      t match {
        case Constants.ResolvedInfoBuiltIn => val r = readResolvedInfoBuiltInT(T); return r
        case Constants.ResolvedInfoPackage => val r = readResolvedInfoPackageT(T); return r
        case Constants.ResolvedInfoEnum => val r = readResolvedInfoEnumT(T); return r
        case Constants.ResolvedInfoEnumElement => val r = readResolvedInfoEnumElementT(T); return r
        case Constants.ResolvedInfoObject => val r = readResolvedInfoObjectT(T); return r
        case Constants.ResolvedInfoVar => val r = readResolvedInfoVarT(T); return r
        case Constants.ResolvedInfoMethod => val r = readResolvedInfoMethodT(T); return r
        case Constants.ResolvedInfoType => val r = readResolvedInfoTypeT(T); return r
        case Constants.ResolvedInfoTuple => val r = readResolvedInfoTupleT(T); return r
        case Constants.ResolvedInfoLocalVar => val r = readResolvedInfoLocalVarT(T); return r
        case _ => halt(s"Unexpected type code $t.")
      }
    }

    def readResolvedInfoBuiltIn(): ResolvedInfo.BuiltIn = {
      val r = readResolvedInfoBuiltInT(F)
      return r
    }

    def readResolvedInfoBuiltInT(typeParsed: B): ResolvedInfo.BuiltIn = {
      if (!typeParsed) {
        reader.expectZ(Constants.ResolvedInfoBuiltIn)
      }
      val name = reader.readString()
      return ResolvedInfo.BuiltIn(name)
    }

    def readResolvedInfoPackage(): ResolvedInfo.Package = {
      val r = readResolvedInfoPackageT(F)
      return r
    }

    def readResolvedInfoPackageT(typeParsed: B): ResolvedInfo.Package = {
      if (!typeParsed) {
        reader.expectZ(Constants.ResolvedInfoPackage)
      }
      val name = reader.readISZ(reader.readString _)
      return ResolvedInfo.Package(name)
    }

    def readResolvedInfoEnum(): ResolvedInfo.Enum = {
      val r = readResolvedInfoEnumT(F)
      return r
    }

    def readResolvedInfoEnumT(typeParsed: B): ResolvedInfo.Enum = {
      if (!typeParsed) {
        reader.expectZ(Constants.ResolvedInfoEnum)
      }
      val name = reader.readISZ(reader.readString _)
      return ResolvedInfo.Enum(name)
    }

    def readResolvedInfoEnumElement(): ResolvedInfo.EnumElement = {
      val r = readResolvedInfoEnumElementT(F)
      return r
    }

    def readResolvedInfoEnumElementT(typeParsed: B): ResolvedInfo.EnumElement = {
      if (!typeParsed) {
        reader.expectZ(Constants.ResolvedInfoEnumElement)
      }
      val owner = reader.readISZ(reader.readString _)
      val name = reader.readString()
      val ordinal = reader.readZ()
      return ResolvedInfo.EnumElement(owner, name, ordinal)
    }

    def readResolvedInfoObject(): ResolvedInfo.Object = {
      val r = readResolvedInfoObjectT(F)
      return r
    }

    def readResolvedInfoObjectT(typeParsed: B): ResolvedInfo.Object = {
      if (!typeParsed) {
        reader.expectZ(Constants.ResolvedInfoObject)
      }
      val name = reader.readISZ(reader.readString _)
      return ResolvedInfo.Object(name)
    }

    def readResolvedInfoVar(): ResolvedInfo.Var = {
      val r = readResolvedInfoVarT(F)
      return r
    }

    def readResolvedInfoVarT(typeParsed: B): ResolvedInfo.Var = {
      if (!typeParsed) {
        reader.expectZ(Constants.ResolvedInfoVar)
      }
      val isInObject = reader.readB()
      val isSpec = reader.readB()
      val owner = reader.readISZ(reader.readString _)
      val id = reader.readString()
      return ResolvedInfo.Var(isInObject, isSpec, owner, id)
    }

    def readResolvedInfoMethod(): ResolvedInfo.Method = {
      val r = readResolvedInfoMethodT(F)
      return r
    }

    def readResolvedInfoMethodT(typeParsed: B): ResolvedInfo.Method = {
      if (!typeParsed) {
        reader.expectZ(Constants.ResolvedInfoMethod)
      }
      val isInObject = reader.readB()
      val isConstructor = reader.readB()
      val isSpec = reader.readB()
      val owner = reader.readISZ(reader.readString _)
      val id = reader.readString()
      return ResolvedInfo.Method(isInObject, isConstructor, isSpec, owner, id)
    }

    def readResolvedInfoType(): ResolvedInfo.Type = {
      val r = readResolvedInfoTypeT(F)
      return r
    }

    def readResolvedInfoTypeT(typeParsed: B): ResolvedInfo.Type = {
      if (!typeParsed) {
        reader.expectZ(Constants.ResolvedInfoType)
      }
      val name = reader.readISZ(reader.readString _)
      return ResolvedInfo.Type(name)
    }

    def readResolvedInfoTuple(): ResolvedInfo.Tuple = {
      val r = readResolvedInfoTupleT(F)
      return r
    }

    def readResolvedInfoTupleT(typeParsed: B): ResolvedInfo.Tuple = {
      if (!typeParsed) {
        reader.expectZ(Constants.ResolvedInfoTuple)
      }
      val size = reader.readZ()
      val index = reader.readZ()
      return ResolvedInfo.Tuple(size, index)
    }

    def readResolvedInfoLocalVar(): ResolvedInfo.LocalVar = {
      val r = readResolvedInfoLocalVarT(F)
      return r
    }

    def readResolvedInfoLocalVarT(typeParsed: B): ResolvedInfo.LocalVar = {
      if (!typeParsed) {
        reader.expectZ(Constants.ResolvedInfoLocalVar)
      }
      val context = reader.readISZ(reader.readString _)
      val id = reader.readString()
      return ResolvedInfo.LocalVar(context, id)
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
    val rd = Reader.Default(MessagePack.reader(data))
    rd.reader.init()
    val r = f(rd)
    return r
  }

  def fromTopUnit(o: TopUnit, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTopUnit(o)
    return w.result
  }

  def toTopUnit(data: ISZ[U8]): TopUnit = {
    def fTopUnit(reader: Reader): TopUnit = {
      val r = reader.readTopUnit()
      return r
    }
    val r = to(data, fTopUnit)
    return r
  }

  def fromTopUnitProgram(o: TopUnit.Program, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTopUnitProgram(o)
    return w.result
  }

  def toTopUnitProgram(data: ISZ[U8]): TopUnit.Program = {
    def fTopUnitProgram(reader: Reader): TopUnit.Program = {
      val r = reader.readTopUnitProgram()
      return r
    }
    val r = to(data, fTopUnitProgram)
    return r
  }

  def fromTopUnitSequentUnit(o: TopUnit.SequentUnit, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTopUnitSequentUnit(o)
    return w.result
  }

  def toTopUnitSequentUnit(data: ISZ[U8]): TopUnit.SequentUnit = {
    def fTopUnitSequentUnit(reader: Reader): TopUnit.SequentUnit = {
      val r = reader.readTopUnitSequentUnit()
      return r
    }
    val r = to(data, fTopUnitSequentUnit)
    return r
  }

  def fromTopUnitTruthTableUnit(o: TopUnit.TruthTableUnit, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTopUnitTruthTableUnit(o)
    return w.result
  }

  def toTopUnitTruthTableUnit(data: ISZ[U8]): TopUnit.TruthTableUnit = {
    def fTopUnitTruthTableUnit(reader: Reader): TopUnit.TruthTableUnit = {
      val r = reader.readTopUnitTruthTableUnit()
      return r
    }
    val r = to(data, fTopUnitTruthTableUnit)
    return r
  }

  def fromStmt(o: Stmt, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmt(o)
    return w.result
  }

  def toStmt(data: ISZ[U8]): Stmt = {
    def fStmt(reader: Reader): Stmt = {
      val r = reader.readStmt()
      return r
    }
    val r = to(data, fStmt)
    return r
  }

  def fromAssignExp(o: AssignExp, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeAssignExp(o)
    return w.result
  }

  def toAssignExp(data: ISZ[U8]): AssignExp = {
    def fAssignExp(reader: Reader): AssignExp = {
      val r = reader.readAssignExp()
      return r
    }
    val r = to(data, fAssignExp)
    return r
  }

  def fromStmtImport(o: Stmt.Import, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtImport(o)
    return w.result
  }

  def toStmtImport(data: ISZ[U8]): Stmt.Import = {
    def fStmtImport(reader: Reader): Stmt.Import = {
      val r = reader.readStmtImport()
      return r
    }
    val r = to(data, fStmtImport)
    return r
  }

  def fromStmtImportImporter(o: Stmt.Import.Importer, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtImportImporter(o)
    return w.result
  }

  def toStmtImportImporter(data: ISZ[U8]): Stmt.Import.Importer = {
    def fStmtImportImporter(reader: Reader): Stmt.Import.Importer = {
      val r = reader.readStmtImportImporter()
      return r
    }
    val r = to(data, fStmtImportImporter)
    return r
  }

  def fromStmtImportSelector(o: Stmt.Import.Selector, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtImportSelector(o)
    return w.result
  }

  def toStmtImportSelector(data: ISZ[U8]): Stmt.Import.Selector = {
    def fStmtImportSelector(reader: Reader): Stmt.Import.Selector = {
      val r = reader.readStmtImportSelector()
      return r
    }
    val r = to(data, fStmtImportSelector)
    return r
  }

  def fromStmtImportMultiSelector(o: Stmt.Import.MultiSelector, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtImportMultiSelector(o)
    return w.result
  }

  def toStmtImportMultiSelector(data: ISZ[U8]): Stmt.Import.MultiSelector = {
    def fStmtImportMultiSelector(reader: Reader): Stmt.Import.MultiSelector = {
      val r = reader.readStmtImportMultiSelector()
      return r
    }
    val r = to(data, fStmtImportMultiSelector)
    return r
  }

  def fromStmtImportWildcardSelector(o: Stmt.Import.WildcardSelector, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtImportWildcardSelector(o)
    return w.result
  }

  def toStmtImportWildcardSelector(data: ISZ[U8]): Stmt.Import.WildcardSelector = {
    def fStmtImportWildcardSelector(reader: Reader): Stmt.Import.WildcardSelector = {
      val r = reader.readStmtImportWildcardSelector()
      return r
    }
    val r = to(data, fStmtImportWildcardSelector)
    return r
  }

  def fromStmtImportNamedSelector(o: Stmt.Import.NamedSelector, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtImportNamedSelector(o)
    return w.result
  }

  def toStmtImportNamedSelector(data: ISZ[U8]): Stmt.Import.NamedSelector = {
    def fStmtImportNamedSelector(reader: Reader): Stmt.Import.NamedSelector = {
      val r = reader.readStmtImportNamedSelector()
      return r
    }
    val r = to(data, fStmtImportNamedSelector)
    return r
  }

  def fromStmtVar(o: Stmt.Var, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtVar(o)
    return w.result
  }

  def toStmtVar(data: ISZ[U8]): Stmt.Var = {
    def fStmtVar(reader: Reader): Stmt.Var = {
      val r = reader.readStmtVar()
      return r
    }
    val r = to(data, fStmtVar)
    return r
  }

  def fromStmtVarPattern(o: Stmt.VarPattern, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtVarPattern(o)
    return w.result
  }

  def toStmtVarPattern(data: ISZ[U8]): Stmt.VarPattern = {
    def fStmtVarPattern(reader: Reader): Stmt.VarPattern = {
      val r = reader.readStmtVarPattern()
      return r
    }
    val r = to(data, fStmtVarPattern)
    return r
  }

  def fromStmtSpecVar(o: Stmt.SpecVar, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtSpecVar(o)
    return w.result
  }

  def toStmtSpecVar(data: ISZ[U8]): Stmt.SpecVar = {
    def fStmtSpecVar(reader: Reader): Stmt.SpecVar = {
      val r = reader.readStmtSpecVar()
      return r
    }
    val r = to(data, fStmtSpecVar)
    return r
  }

  def fromStmtMethod(o: Stmt.Method, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtMethod(o)
    return w.result
  }

  def toStmtMethod(data: ISZ[U8]): Stmt.Method = {
    def fStmtMethod(reader: Reader): Stmt.Method = {
      val r = reader.readStmtMethod()
      return r
    }
    val r = to(data, fStmtMethod)
    return r
  }

  def fromStmtExtMethod(o: Stmt.ExtMethod, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtExtMethod(o)
    return w.result
  }

  def toStmtExtMethod(data: ISZ[U8]): Stmt.ExtMethod = {
    def fStmtExtMethod(reader: Reader): Stmt.ExtMethod = {
      val r = reader.readStmtExtMethod()
      return r
    }
    val r = to(data, fStmtExtMethod)
    return r
  }

  def fromStmtSpecMethod(o: Stmt.SpecMethod, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtSpecMethod(o)
    return w.result
  }

  def toStmtSpecMethod(data: ISZ[U8]): Stmt.SpecMethod = {
    def fStmtSpecMethod(reader: Reader): Stmt.SpecMethod = {
      val r = reader.readStmtSpecMethod()
      return r
    }
    val r = to(data, fStmtSpecMethod)
    return r
  }

  def fromStmtEnum(o: Stmt.Enum, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtEnum(o)
    return w.result
  }

  def toStmtEnum(data: ISZ[U8]): Stmt.Enum = {
    def fStmtEnum(reader: Reader): Stmt.Enum = {
      val r = reader.readStmtEnum()
      return r
    }
    val r = to(data, fStmtEnum)
    return r
  }

  def fromStmtSubZ(o: Stmt.SubZ, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtSubZ(o)
    return w.result
  }

  def toStmtSubZ(data: ISZ[U8]): Stmt.SubZ = {
    def fStmtSubZ(reader: Reader): Stmt.SubZ = {
      val r = reader.readStmtSubZ()
      return r
    }
    val r = to(data, fStmtSubZ)
    return r
  }

  def fromStmtObject(o: Stmt.Object, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtObject(o)
    return w.result
  }

  def toStmtObject(data: ISZ[U8]): Stmt.Object = {
    def fStmtObject(reader: Reader): Stmt.Object = {
      val r = reader.readStmtObject()
      return r
    }
    val r = to(data, fStmtObject)
    return r
  }

  def fromStmtSig(o: Stmt.Sig, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtSig(o)
    return w.result
  }

  def toStmtSig(data: ISZ[U8]): Stmt.Sig = {
    def fStmtSig(reader: Reader): Stmt.Sig = {
      val r = reader.readStmtSig()
      return r
    }
    val r = to(data, fStmtSig)
    return r
  }

  def fromStmtAbstractDatatype(o: Stmt.AbstractDatatype, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtAbstractDatatype(o)
    return w.result
  }

  def toStmtAbstractDatatype(data: ISZ[U8]): Stmt.AbstractDatatype = {
    def fStmtAbstractDatatype(reader: Reader): Stmt.AbstractDatatype = {
      val r = reader.readStmtAbstractDatatype()
      return r
    }
    val r = to(data, fStmtAbstractDatatype)
    return r
  }

  def fromStmtTypeAlias(o: Stmt.TypeAlias, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtTypeAlias(o)
    return w.result
  }

  def toStmtTypeAlias(data: ISZ[U8]): Stmt.TypeAlias = {
    def fStmtTypeAlias(reader: Reader): Stmt.TypeAlias = {
      val r = reader.readStmtTypeAlias()
      return r
    }
    val r = to(data, fStmtTypeAlias)
    return r
  }

  def fromStmtAssign(o: Stmt.Assign, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtAssign(o)
    return w.result
  }

  def toStmtAssign(data: ISZ[U8]): Stmt.Assign = {
    def fStmtAssign(reader: Reader): Stmt.Assign = {
      val r = reader.readStmtAssign()
      return r
    }
    val r = to(data, fStmtAssign)
    return r
  }

  def fromStmtBlock(o: Stmt.Block, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtBlock(o)
    return w.result
  }

  def toStmtBlock(data: ISZ[U8]): Stmt.Block = {
    def fStmtBlock(reader: Reader): Stmt.Block = {
      val r = reader.readStmtBlock()
      return r
    }
    val r = to(data, fStmtBlock)
    return r
  }

  def fromStmtIf(o: Stmt.If, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtIf(o)
    return w.result
  }

  def toStmtIf(data: ISZ[U8]): Stmt.If = {
    def fStmtIf(reader: Reader): Stmt.If = {
      val r = reader.readStmtIf()
      return r
    }
    val r = to(data, fStmtIf)
    return r
  }

  def fromStmtMatch(o: Stmt.Match, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtMatch(o)
    return w.result
  }

  def toStmtMatch(data: ISZ[U8]): Stmt.Match = {
    def fStmtMatch(reader: Reader): Stmt.Match = {
      val r = reader.readStmtMatch()
      return r
    }
    val r = to(data, fStmtMatch)
    return r
  }

  def fromStmtWhile(o: Stmt.While, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtWhile(o)
    return w.result
  }

  def toStmtWhile(data: ISZ[U8]): Stmt.While = {
    def fStmtWhile(reader: Reader): Stmt.While = {
      val r = reader.readStmtWhile()
      return r
    }
    val r = to(data, fStmtWhile)
    return r
  }

  def fromStmtDoWhile(o: Stmt.DoWhile, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtDoWhile(o)
    return w.result
  }

  def toStmtDoWhile(data: ISZ[U8]): Stmt.DoWhile = {
    def fStmtDoWhile(reader: Reader): Stmt.DoWhile = {
      val r = reader.readStmtDoWhile()
      return r
    }
    val r = to(data, fStmtDoWhile)
    return r
  }

  def fromStmtFor(o: Stmt.For, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtFor(o)
    return w.result
  }

  def toStmtFor(data: ISZ[U8]): Stmt.For = {
    def fStmtFor(reader: Reader): Stmt.For = {
      val r = reader.readStmtFor()
      return r
    }
    val r = to(data, fStmtFor)
    return r
  }

  def fromStmtReturn(o: Stmt.Return, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtReturn(o)
    return w.result
  }

  def toStmtReturn(data: ISZ[U8]): Stmt.Return = {
    def fStmtReturn(reader: Reader): Stmt.Return = {
      val r = reader.readStmtReturn()
      return r
    }
    val r = to(data, fStmtReturn)
    return r
  }

  def fromStmtLStmt(o: Stmt.LStmt, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtLStmt(o)
    return w.result
  }

  def toStmtLStmt(data: ISZ[U8]): Stmt.LStmt = {
    def fStmtLStmt(reader: Reader): Stmt.LStmt = {
      val r = reader.readStmtLStmt()
      return r
    }
    val r = to(data, fStmtLStmt)
    return r
  }

  def fromStmtExpr(o: Stmt.Expr, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeStmtExpr(o)
    return w.result
  }

  def toStmtExpr(data: ISZ[U8]): Stmt.Expr = {
    def fStmtExpr(reader: Reader): Stmt.Expr = {
      val r = reader.readStmtExpr()
      return r
    }
    val r = to(data, fStmtExpr)
    return r
  }

  def fromLClause(o: LClause, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeLClause(o)
    return w.result
  }

  def toLClause(data: ISZ[U8]): LClause = {
    def fLClause(reader: Reader): LClause = {
      val r = reader.readLClause()
      return r
    }
    val r = to(data, fLClause)
    return r
  }

  def fromLClauseInvariants(o: LClause.Invariants, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeLClauseInvariants(o)
    return w.result
  }

  def toLClauseInvariants(data: ISZ[U8]): LClause.Invariants = {
    def fLClauseInvariants(reader: Reader): LClause.Invariants = {
      val r = reader.readLClauseInvariants()
      return r
    }
    val r = to(data, fLClauseInvariants)
    return r
  }

  def fromLClauseFacts(o: LClause.Facts, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeLClauseFacts(o)
    return w.result
  }

  def toLClauseFacts(data: ISZ[U8]): LClause.Facts = {
    def fLClauseFacts(reader: Reader): LClause.Facts = {
      val r = reader.readLClauseFacts()
      return r
    }
    val r = to(data, fLClauseFacts)
    return r
  }

  def fromLClauseFact(o: LClause.Fact, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeLClauseFact(o)
    return w.result
  }

  def toLClauseFact(data: ISZ[U8]): LClause.Fact = {
    def fLClauseFact(reader: Reader): LClause.Fact = {
      val r = reader.readLClauseFact()
      return r
    }
    val r = to(data, fLClauseFact)
    return r
  }

  def fromLClauseTheorems(o: LClause.Theorems, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeLClauseTheorems(o)
    return w.result
  }

  def toLClauseTheorems(data: ISZ[U8]): LClause.Theorems = {
    def fLClauseTheorems(reader: Reader): LClause.Theorems = {
      val r = reader.readLClauseTheorems()
      return r
    }
    val r = to(data, fLClauseTheorems)
    return r
  }

  def fromLClauseTheorem(o: LClause.Theorem, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeLClauseTheorem(o)
    return w.result
  }

  def toLClauseTheorem(data: ISZ[U8]): LClause.Theorem = {
    def fLClauseTheorem(reader: Reader): LClause.Theorem = {
      val r = reader.readLClauseTheorem()
      return r
    }
    val r = to(data, fLClauseTheorem)
    return r
  }

  def fromLClauseSequent(o: LClause.Sequent, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeLClauseSequent(o)
    return w.result
  }

  def toLClauseSequent(data: ISZ[U8]): LClause.Sequent = {
    def fLClauseSequent(reader: Reader): LClause.Sequent = {
      val r = reader.readLClauseSequent()
      return r
    }
    val r = to(data, fLClauseSequent)
    return r
  }

  def fromLClauseProof(o: LClause.Proof, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeLClauseProof(o)
    return w.result
  }

  def toLClauseProof(data: ISZ[U8]): LClause.Proof = {
    def fLClauseProof(reader: Reader): LClause.Proof = {
      val r = reader.readLClauseProof()
      return r
    }
    val r = to(data, fLClauseProof)
    return r
  }

  def fromContractExp(o: ContractExp, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeContractExp(o)
    return w.result
  }

  def toContractExp(data: ISZ[U8]): ContractExp = {
    def fContractExp(reader: Reader): ContractExp = {
      val r = reader.readContractExp()
      return r
    }
    val r = to(data, fContractExp)
    return r
  }

  def fromCase(o: Case, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeCase(o)
    return w.result
  }

  def toCase(data: ISZ[U8]): Case = {
    def fCase(reader: Reader): Case = {
      val r = reader.readCase()
      return r
    }
    val r = to(data, fCase)
    return r
  }

  def fromEnumGenRange(o: EnumGen.Range, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeEnumGenRange(o)
    return w.result
  }

  def toEnumGenRange(data: ISZ[U8]): EnumGen.Range = {
    def fEnumGenRange(reader: Reader): EnumGen.Range = {
      val r = reader.readEnumGenRange()
      return r
    }
    val r = to(data, fEnumGenRange)
    return r
  }

  def fromEnumGenRangeExpr(o: EnumGen.Range.Expr, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeEnumGenRangeExpr(o)
    return w.result
  }

  def toEnumGenRangeExpr(data: ISZ[U8]): EnumGen.Range.Expr = {
    def fEnumGenRangeExpr(reader: Reader): EnumGen.Range.Expr = {
      val r = reader.readEnumGenRangeExpr()
      return r
    }
    val r = to(data, fEnumGenRangeExpr)
    return r
  }

  def fromEnumGenRangeIndices(o: EnumGen.Range.Indices, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeEnumGenRangeIndices(o)
    return w.result
  }

  def toEnumGenRangeIndices(data: ISZ[U8]): EnumGen.Range.Indices = {
    def fEnumGenRangeIndices(reader: Reader): EnumGen.Range.Indices = {
      val r = reader.readEnumGenRangeIndices()
      return r
    }
    val r = to(data, fEnumGenRangeIndices)
    return r
  }

  def fromEnumGenRangeStep(o: EnumGen.Range.Step, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeEnumGenRangeStep(o)
    return w.result
  }

  def toEnumGenRangeStep(data: ISZ[U8]): EnumGen.Range.Step = {
    def fEnumGenRangeStep(reader: Reader): EnumGen.Range.Step = {
      val r = reader.readEnumGenRangeStep()
      return r
    }
    val r = to(data, fEnumGenRangeStep)
    return r
  }

  def fromEnumGenFor(o: EnumGen.For, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeEnumGenFor(o)
    return w.result
  }

  def toEnumGenFor(data: ISZ[U8]): EnumGen.For = {
    def fEnumGenFor(reader: Reader): EnumGen.For = {
      val r = reader.readEnumGenFor()
      return r
    }
    val r = to(data, fEnumGenFor)
    return r
  }

  def fromType(o: Type, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeType(o)
    return w.result
  }

  def toType(data: ISZ[U8]): Type = {
    def fType(reader: Reader): Type = {
      val r = reader.readType()
      return r
    }
    val r = to(data, fType)
    return r
  }

  def fromTypeNamed(o: Type.Named, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTypeNamed(o)
    return w.result
  }

  def toTypeNamed(data: ISZ[U8]): Type.Named = {
    def fTypeNamed(reader: Reader): Type.Named = {
      val r = reader.readTypeNamed()
      return r
    }
    val r = to(data, fTypeNamed)
    return r
  }

  def fromTypeFun(o: Type.Fun, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTypeFun(o)
    return w.result
  }

  def toTypeFun(data: ISZ[U8]): Type.Fun = {
    def fTypeFun(reader: Reader): Type.Fun = {
      val r = reader.readTypeFun()
      return r
    }
    val r = to(data, fTypeFun)
    return r
  }

  def fromTypeTuple(o: Type.Tuple, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTypeTuple(o)
    return w.result
  }

  def toTypeTuple(data: ISZ[U8]): Type.Tuple = {
    def fTypeTuple(reader: Reader): Type.Tuple = {
      val r = reader.readTypeTuple()
      return r
    }
    val r = to(data, fTypeTuple)
    return r
  }

  def fromPattern(o: Pattern, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writePattern(o)
    return w.result
  }

  def toPattern(data: ISZ[U8]): Pattern = {
    def fPattern(reader: Reader): Pattern = {
      val r = reader.readPattern()
      return r
    }
    val r = to(data, fPattern)
    return r
  }

  def fromPatternLiteral(o: Pattern.Literal, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writePatternLiteral(o)
    return w.result
  }

  def toPatternLiteral(data: ISZ[U8]): Pattern.Literal = {
    def fPatternLiteral(reader: Reader): Pattern.Literal = {
      val r = reader.readPatternLiteral()
      return r
    }
    val r = to(data, fPatternLiteral)
    return r
  }

  def fromPatternLitInterpolate(o: Pattern.LitInterpolate, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writePatternLitInterpolate(o)
    return w.result
  }

  def toPatternLitInterpolate(data: ISZ[U8]): Pattern.LitInterpolate = {
    def fPatternLitInterpolate(reader: Reader): Pattern.LitInterpolate = {
      val r = reader.readPatternLitInterpolate()
      return r
    }
    val r = to(data, fPatternLitInterpolate)
    return r
  }

  def fromPatternRef(o: Pattern.Ref, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writePatternRef(o)
    return w.result
  }

  def toPatternRef(data: ISZ[U8]): Pattern.Ref = {
    def fPatternRef(reader: Reader): Pattern.Ref = {
      val r = reader.readPatternRef()
      return r
    }
    val r = to(data, fPatternRef)
    return r
  }

  def fromPatternVarBinding(o: Pattern.VarBinding, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writePatternVarBinding(o)
    return w.result
  }

  def toPatternVarBinding(data: ISZ[U8]): Pattern.VarBinding = {
    def fPatternVarBinding(reader: Reader): Pattern.VarBinding = {
      val r = reader.readPatternVarBinding()
      return r
    }
    val r = to(data, fPatternVarBinding)
    return r
  }

  def fromPatternWildcard(o: Pattern.Wildcard, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writePatternWildcard(o)
    return w.result
  }

  def toPatternWildcard(data: ISZ[U8]): Pattern.Wildcard = {
    def fPatternWildcard(reader: Reader): Pattern.Wildcard = {
      val r = reader.readPatternWildcard()
      return r
    }
    val r = to(data, fPatternWildcard)
    return r
  }

  def fromPatternSeqWildcard(o: Pattern.SeqWildcard, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writePatternSeqWildcard(o)
    return w.result
  }

  def toPatternSeqWildcard(data: ISZ[U8]): Pattern.SeqWildcard = {
    def fPatternSeqWildcard(reader: Reader): Pattern.SeqWildcard = {
      val r = reader.readPatternSeqWildcard()
      return r
    }
    val r = to(data, fPatternSeqWildcard)
    return r
  }

  def fromPatternStructure(o: Pattern.Structure, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writePatternStructure(o)
    return w.result
  }

  def toPatternStructure(data: ISZ[U8]): Pattern.Structure = {
    def fPatternStructure(reader: Reader): Pattern.Structure = {
      val r = reader.readPatternStructure()
      return r
    }
    val r = to(data, fPatternStructure)
    return r
  }

  def fromExp(o: Exp, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExp(o)
    return w.result
  }

  def toExp(data: ISZ[U8]): Exp = {
    def fExp(reader: Reader): Exp = {
      val r = reader.readExp()
      return r
    }
    val r = to(data, fExp)
    return r
  }

  def fromLit(o: Lit, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeLit(o)
    return w.result
  }

  def toLit(data: ISZ[U8]): Lit = {
    def fLit(reader: Reader): Lit = {
      val r = reader.readLit()
      return r
    }
    val r = to(data, fLit)
    return r
  }

  def fromExpLitB(o: Exp.LitB, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpLitB(o)
    return w.result
  }

  def toExpLitB(data: ISZ[U8]): Exp.LitB = {
    def fExpLitB(reader: Reader): Exp.LitB = {
      val r = reader.readExpLitB()
      return r
    }
    val r = to(data, fExpLitB)
    return r
  }

  def fromExpLitC(o: Exp.LitC, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpLitC(o)
    return w.result
  }

  def toExpLitC(data: ISZ[U8]): Exp.LitC = {
    def fExpLitC(reader: Reader): Exp.LitC = {
      val r = reader.readExpLitC()
      return r
    }
    val r = to(data, fExpLitC)
    return r
  }

  def fromExpLitZ(o: Exp.LitZ, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpLitZ(o)
    return w.result
  }

  def toExpLitZ(data: ISZ[U8]): Exp.LitZ = {
    def fExpLitZ(reader: Reader): Exp.LitZ = {
      val r = reader.readExpLitZ()
      return r
    }
    val r = to(data, fExpLitZ)
    return r
  }

  def fromExpLitF32(o: Exp.LitF32, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpLitF32(o)
    return w.result
  }

  def toExpLitF32(data: ISZ[U8]): Exp.LitF32 = {
    def fExpLitF32(reader: Reader): Exp.LitF32 = {
      val r = reader.readExpLitF32()
      return r
    }
    val r = to(data, fExpLitF32)
    return r
  }

  def fromExpLitF64(o: Exp.LitF64, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpLitF64(o)
    return w.result
  }

  def toExpLitF64(data: ISZ[U8]): Exp.LitF64 = {
    def fExpLitF64(reader: Reader): Exp.LitF64 = {
      val r = reader.readExpLitF64()
      return r
    }
    val r = to(data, fExpLitF64)
    return r
  }

  def fromExpLitR(o: Exp.LitR, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpLitR(o)
    return w.result
  }

  def toExpLitR(data: ISZ[U8]): Exp.LitR = {
    def fExpLitR(reader: Reader): Exp.LitR = {
      val r = reader.readExpLitR()
      return r
    }
    val r = to(data, fExpLitR)
    return r
  }

  def fromExpLitString(o: Exp.LitString, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpLitString(o)
    return w.result
  }

  def toExpLitString(data: ISZ[U8]): Exp.LitString = {
    def fExpLitString(reader: Reader): Exp.LitString = {
      val r = reader.readExpLitString()
      return r
    }
    val r = to(data, fExpLitString)
    return r
  }

  def fromExpStringInterpolate(o: Exp.StringInterpolate, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpStringInterpolate(o)
    return w.result
  }

  def toExpStringInterpolate(data: ISZ[U8]): Exp.StringInterpolate = {
    def fExpStringInterpolate(reader: Reader): Exp.StringInterpolate = {
      val r = reader.readExpStringInterpolate()
      return r
    }
    val r = to(data, fExpStringInterpolate)
    return r
  }

  def fromExpThis(o: Exp.This, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpThis(o)
    return w.result
  }

  def toExpThis(data: ISZ[U8]): Exp.This = {
    def fExpThis(reader: Reader): Exp.This = {
      val r = reader.readExpThis()
      return r
    }
    val r = to(data, fExpThis)
    return r
  }

  def fromExpSuper(o: Exp.Super, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpSuper(o)
    return w.result
  }

  def toExpSuper(data: ISZ[U8]): Exp.Super = {
    def fExpSuper(reader: Reader): Exp.Super = {
      val r = reader.readExpSuper()
      return r
    }
    val r = to(data, fExpSuper)
    return r
  }

  def fromExpUnary(o: Exp.Unary, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpUnary(o)
    return w.result
  }

  def toExpUnary(data: ISZ[U8]): Exp.Unary = {
    def fExpUnary(reader: Reader): Exp.Unary = {
      val r = reader.readExpUnary()
      return r
    }
    val r = to(data, fExpUnary)
    return r
  }

  def fromExpRef(o: Exp.Ref, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpRef(o)
    return w.result
  }

  def toExpRef(data: ISZ[U8]): Exp.Ref = {
    def fExpRef(reader: Reader): Exp.Ref = {
      val r = reader.readExpRef()
      return r
    }
    val r = to(data, fExpRef)
    return r
  }

  def fromExpBinary(o: Exp.Binary, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpBinary(o)
    return w.result
  }

  def toExpBinary(data: ISZ[U8]): Exp.Binary = {
    def fExpBinary(reader: Reader): Exp.Binary = {
      val r = reader.readExpBinary()
      return r
    }
    val r = to(data, fExpBinary)
    return r
  }

  def fromExpIdent(o: Exp.Ident, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpIdent(o)
    return w.result
  }

  def toExpIdent(data: ISZ[U8]): Exp.Ident = {
    def fExpIdent(reader: Reader): Exp.Ident = {
      val r = reader.readExpIdent()
      return r
    }
    val r = to(data, fExpIdent)
    return r
  }

  def fromExpEta(o: Exp.Eta, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpEta(o)
    return w.result
  }

  def toExpEta(data: ISZ[U8]): Exp.Eta = {
    def fExpEta(reader: Reader): Exp.Eta = {
      val r = reader.readExpEta()
      return r
    }
    val r = to(data, fExpEta)
    return r
  }

  def fromExpTuple(o: Exp.Tuple, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpTuple(o)
    return w.result
  }

  def toExpTuple(data: ISZ[U8]): Exp.Tuple = {
    def fExpTuple(reader: Reader): Exp.Tuple = {
      val r = reader.readExpTuple()
      return r
    }
    val r = to(data, fExpTuple)
    return r
  }

  def fromExpSelect(o: Exp.Select, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpSelect(o)
    return w.result
  }

  def toExpSelect(data: ISZ[U8]): Exp.Select = {
    def fExpSelect(reader: Reader): Exp.Select = {
      val r = reader.readExpSelect()
      return r
    }
    val r = to(data, fExpSelect)
    return r
  }

  def fromExpInvoke(o: Exp.Invoke, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpInvoke(o)
    return w.result
  }

  def toExpInvoke(data: ISZ[U8]): Exp.Invoke = {
    def fExpInvoke(reader: Reader): Exp.Invoke = {
      val r = reader.readExpInvoke()
      return r
    }
    val r = to(data, fExpInvoke)
    return r
  }

  def fromExpInvokeNamed(o: Exp.InvokeNamed, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpInvokeNamed(o)
    return w.result
  }

  def toExpInvokeNamed(data: ISZ[U8]): Exp.InvokeNamed = {
    def fExpInvokeNamed(reader: Reader): Exp.InvokeNamed = {
      val r = reader.readExpInvokeNamed()
      return r
    }
    val r = to(data, fExpInvokeNamed)
    return r
  }

  def fromExpIf(o: Exp.If, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpIf(o)
    return w.result
  }

  def toExpIf(data: ISZ[U8]): Exp.If = {
    def fExpIf(reader: Reader): Exp.If = {
      val r = reader.readExpIf()
      return r
    }
    val r = to(data, fExpIf)
    return r
  }

  def fromExpFunParam(o: Exp.Fun.Param, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpFunParam(o)
    return w.result
  }

  def toExpFunParam(data: ISZ[U8]): Exp.Fun.Param = {
    def fExpFunParam(reader: Reader): Exp.Fun.Param = {
      val r = reader.readExpFunParam()
      return r
    }
    val r = to(data, fExpFunParam)
    return r
  }

  def fromExpFun(o: Exp.Fun, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpFun(o)
    return w.result
  }

  def toExpFun(data: ISZ[U8]): Exp.Fun = {
    def fExpFun(reader: Reader): Exp.Fun = {
      val r = reader.readExpFun()
      return r
    }
    val r = to(data, fExpFun)
    return r
  }

  def fromExpForYield(o: Exp.ForYield, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpForYield(o)
    return w.result
  }

  def toExpForYield(data: ISZ[U8]): Exp.ForYield = {
    def fExpForYield(reader: Reader): Exp.ForYield = {
      val r = reader.readExpForYield()
      return r
    }
    val r = to(data, fExpForYield)
    return r
  }

  def fromExpQuant(o: Exp.Quant, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeExpQuant(o)
    return w.result
  }

  def toExpQuant(data: ISZ[U8]): Exp.Quant = {
    def fExpQuant(reader: Reader): Exp.Quant = {
      val r = reader.readExpQuant()
      return r
    }
    val r = to(data, fExpQuant)
    return r
  }

  def fromNamedArg(o: NamedArg, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeNamedArg(o)
    return w.result
  }

  def toNamedArg(data: ISZ[U8]): NamedArg = {
    def fNamedArg(reader: Reader): NamedArg = {
      val r = reader.readNamedArg()
      return r
    }
    val r = to(data, fNamedArg)
    return r
  }

  def fromVarFragment(o: VarFragment, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeVarFragment(o)
    return w.result
  }

  def toVarFragment(data: ISZ[U8]): VarFragment = {
    def fVarFragment(reader: Reader): VarFragment = {
      val r = reader.readVarFragment()
      return r
    }
    val r = to(data, fVarFragment)
    return r
  }

  def fromDomain(o: Domain, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeDomain(o)
    return w.result
  }

  def toDomain(data: ISZ[U8]): Domain = {
    def fDomain(reader: Reader): Domain = {
      val r = reader.readDomain()
      return r
    }
    val r = to(data, fDomain)
    return r
  }

  def fromDomainType(o: Domain.Type, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeDomainType(o)
    return w.result
  }

  def toDomainType(data: ISZ[U8]): Domain.Type = {
    def fDomainType(reader: Reader): Domain.Type = {
      val r = reader.readDomainType()
      return r
    }
    val r = to(data, fDomainType)
    return r
  }

  def fromDomainRange(o: Domain.Range, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeDomainRange(o)
    return w.result
  }

  def toDomainRange(data: ISZ[U8]): Domain.Range = {
    def fDomainRange(reader: Reader): Domain.Range = {
      val r = reader.readDomainRange()
      return r
    }
    val r = to(data, fDomainRange)
    return r
  }

  def fromId(o: Id, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeId(o)
    return w.result
  }

  def toId(data: ISZ[U8]): Id = {
    def fId(reader: Reader): Id = {
      val r = reader.readId()
      return r
    }
    val r = to(data, fId)
    return r
  }

  def fromName(o: Name, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeName(o)
    return w.result
  }

  def toName(data: ISZ[U8]): Name = {
    def fName(reader: Reader): Name = {
      val r = reader.readName()
      return r
    }
    val r = to(data, fName)
    return r
  }

  def fromBody(o: Body, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeBody(o)
    return w.result
  }

  def toBody(data: ISZ[U8]): Body = {
    def fBody(reader: Reader): Body = {
      val r = reader.readBody()
      return r
    }
    val r = to(data, fBody)
    return r
  }

  def fromAbstractDatatypeParam(o: AbstractDatatypeParam, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeAbstractDatatypeParam(o)
    return w.result
  }

  def toAbstractDatatypeParam(data: ISZ[U8]): AbstractDatatypeParam = {
    def fAbstractDatatypeParam(reader: Reader): AbstractDatatypeParam = {
      val r = reader.readAbstractDatatypeParam()
      return r
    }
    val r = to(data, fAbstractDatatypeParam)
    return r
  }

  def fromMethodSig(o: MethodSig, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeMethodSig(o)
    return w.result
  }

  def toMethodSig(data: ISZ[U8]): MethodSig = {
    def fMethodSig(reader: Reader): MethodSig = {
      val r = reader.readMethodSig()
      return r
    }
    val r = to(data, fMethodSig)
    return r
  }

  def fromParam(o: Param, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeParam(o)
    return w.result
  }

  def toParam(data: ISZ[U8]): Param = {
    def fParam(reader: Reader): Param = {
      val r = reader.readParam()
      return r
    }
    val r = to(data, fParam)
    return r
  }

  def fromTypeParam(o: TypeParam, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTypeParam(o)
    return w.result
  }

  def toTypeParam(data: ISZ[U8]): TypeParam = {
    def fTypeParam(reader: Reader): TypeParam = {
      val r = reader.readTypeParam()
      return r
    }
    val r = to(data, fTypeParam)
    return r
  }

  def fromContract(o: Contract, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeContract(o)
    return w.result
  }

  def toContract(data: ISZ[U8]): Contract = {
    def fContract(reader: Reader): Contract = {
      val r = reader.readContract()
      return r
    }
    val r = to(data, fContract)
    return r
  }

  def fromSubContract(o: SubContract, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeSubContract(o)
    return w.result
  }

  def toSubContract(data: ISZ[U8]): SubContract = {
    def fSubContract(reader: Reader): SubContract = {
      val r = reader.readSubContract()
      return r
    }
    val r = to(data, fSubContract)
    return r
  }

  def fromWhereDef(o: WhereDef, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeWhereDef(o)
    return w.result
  }

  def toWhereDef(data: ISZ[U8]): WhereDef = {
    def fWhereDef(reader: Reader): WhereDef = {
      val r = reader.readWhereDef()
      return r
    }
    val r = to(data, fWhereDef)
    return r
  }

  def fromWhereDefVal(o: WhereDef.Val, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeWhereDefVal(o)
    return w.result
  }

  def toWhereDefVal(data: ISZ[U8]): WhereDef.Val = {
    def fWhereDefVal(reader: Reader): WhereDef.Val = {
      val r = reader.readWhereDefVal()
      return r
    }
    val r = to(data, fWhereDefVal)
    return r
  }

  def fromWhereDefDef(o: WhereDef.Def, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeWhereDefDef(o)
    return w.result
  }

  def toWhereDefDef(data: ISZ[U8]): WhereDef.Def = {
    def fWhereDefDef(reader: Reader): WhereDef.Def = {
      val r = reader.readWhereDefDef()
      return r
    }
    val r = to(data, fWhereDefDef)
    return r
  }

  def fromSpecDef(o: SpecDef, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeSpecDef(o)
    return w.result
  }

  def toSpecDef(data: ISZ[U8]): SpecDef = {
    def fSpecDef(reader: Reader): SpecDef = {
      val r = reader.readSpecDef()
      return r
    }
    val r = to(data, fSpecDef)
    return r
  }

  def fromProofStep(o: ProofStep, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeProofStep(o)
    return w.result
  }

  def toProofStep(data: ISZ[U8]): ProofStep = {
    def fProofStep(reader: Reader): ProofStep = {
      val r = reader.readProofStep()
      return r
    }
    val r = to(data, fProofStep)
    return r
  }

  def fromProofStepBasic(o: ProofStep.Basic, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeProofStepBasic(o)
    return w.result
  }

  def toProofStepBasic(data: ISZ[U8]): ProofStep.Basic = {
    def fProofStepBasic(reader: Reader): ProofStep.Basic = {
      val r = reader.readProofStepBasic()
      return r
    }
    val r = to(data, fProofStepBasic)
    return r
  }

  def fromProofStepSubProof(o: ProofStep.SubProof, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeProofStepSubProof(o)
    return w.result
  }

  def toProofStepSubProof(data: ISZ[U8]): ProofStep.SubProof = {
    def fProofStepSubProof(reader: Reader): ProofStep.SubProof = {
      val r = reader.readProofStepSubProof()
      return r
    }
    val r = to(data, fProofStepSubProof)
    return r
  }

  def fromAssumeProofStep(o: AssumeProofStep, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeAssumeProofStep(o)
    return w.result
  }

  def toAssumeProofStep(data: ISZ[U8]): AssumeProofStep = {
    def fAssumeProofStep(reader: Reader): AssumeProofStep = {
      val r = reader.readAssumeProofStep()
      return r
    }
    val r = to(data, fAssumeProofStep)
    return r
  }

  def fromAssumeProofStepRegular(o: AssumeProofStep.Regular, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeAssumeProofStepRegular(o)
    return w.result
  }

  def toAssumeProofStepRegular(data: ISZ[U8]): AssumeProofStep.Regular = {
    def fAssumeProofStepRegular(reader: Reader): AssumeProofStep.Regular = {
      val r = reader.readAssumeProofStepRegular()
      return r
    }
    val r = to(data, fAssumeProofStepRegular)
    return r
  }

  def fromAssumeProofStepForallIntroAps(o: AssumeProofStep.ForallIntroAps, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeAssumeProofStepForallIntroAps(o)
    return w.result
  }

  def toAssumeProofStepForallIntroAps(data: ISZ[U8]): AssumeProofStep.ForallIntroAps = {
    def fAssumeProofStepForallIntroAps(reader: Reader): AssumeProofStep.ForallIntroAps = {
      val r = reader.readAssumeProofStepForallIntroAps()
      return r
    }
    val r = to(data, fAssumeProofStepForallIntroAps)
    return r
  }

  def fromAssumeProofStepExistsElimAps(o: AssumeProofStep.ExistsElimAps, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeAssumeProofStepExistsElimAps(o)
    return w.result
  }

  def toAssumeProofStepExistsElimAps(data: ISZ[U8]): AssumeProofStep.ExistsElimAps = {
    def fAssumeProofStepExistsElimAps(reader: Reader): AssumeProofStep.ExistsElimAps = {
      val r = reader.readAssumeProofStepExistsElimAps()
      return r
    }
    val r = to(data, fAssumeProofStepExistsElimAps)
    return r
  }

  def fromJust(o: Just, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJust(o)
    return w.result
  }

  def toJust(data: ISZ[U8]): Just = {
    def fJust(reader: Reader): Just = {
      val r = reader.readJust()
      return r
    }
    val r = to(data, fJust)
    return r
  }

  def fromJustPremise(o: Just.Premise, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustPremise(o)
    return w.result
  }

  def toJustPremise(data: ISZ[U8]): Just.Premise = {
    def fJustPremise(reader: Reader): Just.Premise = {
      val r = reader.readJustPremise()
      return r
    }
    val r = to(data, fJustPremise)
    return r
  }

  def fromJustAndIntro(o: Just.AndIntro, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustAndIntro(o)
    return w.result
  }

  def toJustAndIntro(data: ISZ[U8]): Just.AndIntro = {
    def fJustAndIntro(reader: Reader): Just.AndIntro = {
      val r = reader.readJustAndIntro()
      return r
    }
    val r = to(data, fJustAndIntro)
    return r
  }

  def fromJustAndElim(o: Just.AndElim, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustAndElim(o)
    return w.result
  }

  def toJustAndElim(data: ISZ[U8]): Just.AndElim = {
    def fJustAndElim(reader: Reader): Just.AndElim = {
      val r = reader.readJustAndElim()
      return r
    }
    val r = to(data, fJustAndElim)
    return r
  }

  def fromJustOrIntro(o: Just.OrIntro, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustOrIntro(o)
    return w.result
  }

  def toJustOrIntro(data: ISZ[U8]): Just.OrIntro = {
    def fJustOrIntro(reader: Reader): Just.OrIntro = {
      val r = reader.readJustOrIntro()
      return r
    }
    val r = to(data, fJustOrIntro)
    return r
  }

  def fromJustOrElim(o: Just.OrElim, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustOrElim(o)
    return w.result
  }

  def toJustOrElim(data: ISZ[U8]): Just.OrElim = {
    def fJustOrElim(reader: Reader): Just.OrElim = {
      val r = reader.readJustOrElim()
      return r
    }
    val r = to(data, fJustOrElim)
    return r
  }

  def fromJustImplyIntro(o: Just.ImplyIntro, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustImplyIntro(o)
    return w.result
  }

  def toJustImplyIntro(data: ISZ[U8]): Just.ImplyIntro = {
    def fJustImplyIntro(reader: Reader): Just.ImplyIntro = {
      val r = reader.readJustImplyIntro()
      return r
    }
    val r = to(data, fJustImplyIntro)
    return r
  }

  def fromJustImplyElim(o: Just.ImplyElim, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustImplyElim(o)
    return w.result
  }

  def toJustImplyElim(data: ISZ[U8]): Just.ImplyElim = {
    def fJustImplyElim(reader: Reader): Just.ImplyElim = {
      val r = reader.readJustImplyElim()
      return r
    }
    val r = to(data, fJustImplyElim)
    return r
  }

  def fromJustNegIntro(o: Just.NegIntro, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustNegIntro(o)
    return w.result
  }

  def toJustNegIntro(data: ISZ[U8]): Just.NegIntro = {
    def fJustNegIntro(reader: Reader): Just.NegIntro = {
      val r = reader.readJustNegIntro()
      return r
    }
    val r = to(data, fJustNegIntro)
    return r
  }

  def fromJustNegElim(o: Just.NegElim, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustNegElim(o)
    return w.result
  }

  def toJustNegElim(data: ISZ[U8]): Just.NegElim = {
    def fJustNegElim(reader: Reader): Just.NegElim = {
      val r = reader.readJustNegElim()
      return r
    }
    val r = to(data, fJustNegElim)
    return r
  }

  def fromJustBottomElim(o: Just.BottomElim, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustBottomElim(o)
    return w.result
  }

  def toJustBottomElim(data: ISZ[U8]): Just.BottomElim = {
    def fJustBottomElim(reader: Reader): Just.BottomElim = {
      val r = reader.readJustBottomElim()
      return r
    }
    val r = to(data, fJustBottomElim)
    return r
  }

  def fromJustPbc(o: Just.Pbc, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustPbc(o)
    return w.result
  }

  def toJustPbc(data: ISZ[U8]): Just.Pbc = {
    def fJustPbc(reader: Reader): Just.Pbc = {
      val r = reader.readJustPbc()
      return r
    }
    val r = to(data, fJustPbc)
    return r
  }

  def fromJustForallIntro(o: Just.ForallIntro, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustForallIntro(o)
    return w.result
  }

  def toJustForallIntro(data: ISZ[U8]): Just.ForallIntro = {
    def fJustForallIntro(reader: Reader): Just.ForallIntro = {
      val r = reader.readJustForallIntro()
      return r
    }
    val r = to(data, fJustForallIntro)
    return r
  }

  def fromJustForallElim(o: Just.ForallElim, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustForallElim(o)
    return w.result
  }

  def toJustForallElim(data: ISZ[U8]): Just.ForallElim = {
    def fJustForallElim(reader: Reader): Just.ForallElim = {
      val r = reader.readJustForallElim()
      return r
    }
    val r = to(data, fJustForallElim)
    return r
  }

  def fromJustExistsIntro(o: Just.ExistsIntro, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustExistsIntro(o)
    return w.result
  }

  def toJustExistsIntro(data: ISZ[U8]): Just.ExistsIntro = {
    def fJustExistsIntro(reader: Reader): Just.ExistsIntro = {
      val r = reader.readJustExistsIntro()
      return r
    }
    val r = to(data, fJustExistsIntro)
    return r
  }

  def fromJustExistsElim(o: Just.ExistsElim, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustExistsElim(o)
    return w.result
  }

  def toJustExistsElim(data: ISZ[U8]): Just.ExistsElim = {
    def fJustExistsElim(reader: Reader): Just.ExistsElim = {
      val r = reader.readJustExistsElim()
      return r
    }
    val r = to(data, fJustExistsElim)
    return r
  }

  def fromJustFact(o: Just.Fact, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustFact(o)
    return w.result
  }

  def toJustFact(data: ISZ[U8]): Just.Fact = {
    def fJustFact(reader: Reader): Just.Fact = {
      val r = reader.readJustFact()
      return r
    }
    val r = to(data, fJustFact)
    return r
  }

  def fromJustInvariant(o: Just.Invariant, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustInvariant(o)
    return w.result
  }

  def toJustInvariant(data: ISZ[U8]): Just.Invariant = {
    def fJustInvariant(reader: Reader): Just.Invariant = {
      val r = reader.readJustInvariant()
      return r
    }
    val r = to(data, fJustInvariant)
    return r
  }

  def fromJustSubst(o: Just.Subst, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustSubst(o)
    return w.result
  }

  def toJustSubst(data: ISZ[U8]): Just.Subst = {
    def fJustSubst(reader: Reader): Just.Subst = {
      val r = reader.readJustSubst()
      return r
    }
    val r = to(data, fJustSubst)
    return r
  }

  def fromJustAuto(o: Just.Auto, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustAuto(o)
    return w.result
  }

  def toJustAuto(data: ISZ[U8]): Just.Auto = {
    def fJustAuto(reader: Reader): Just.Auto = {
      val r = reader.readJustAuto()
      return r
    }
    val r = to(data, fJustAuto)
    return r
  }

  def fromJustCoq(o: Just.Coq, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeJustCoq(o)
    return w.result
  }

  def toJustCoq(data: ISZ[U8]): Just.Coq = {
    def fJustCoq(reader: Reader): Just.Coq = {
      val r = reader.readJustCoq()
      return r
    }
    val r = to(data, fJustCoq)
    return r
  }

  def fromTruthTableRow(o: TruthTable.Row, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTruthTableRow(o)
    return w.result
  }

  def toTruthTableRow(data: ISZ[U8]): TruthTable.Row = {
    def fTruthTableRow(reader: Reader): TruthTable.Row = {
      val r = reader.readTruthTableRow()
      return r
    }
    val r = to(data, fTruthTableRow)
    return r
  }

  def fromTruthTableAssignment(o: TruthTable.Assignment, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTruthTableAssignment(o)
    return w.result
  }

  def toTruthTableAssignment(data: ISZ[U8]): TruthTable.Assignment = {
    def fTruthTableAssignment(reader: Reader): TruthTable.Assignment = {
      val r = reader.readTruthTableAssignment()
      return r
    }
    val r = to(data, fTruthTableAssignment)
    return r
  }

  def fromTruthTableConclusion(o: TruthTable.Conclusion, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTruthTableConclusion(o)
    return w.result
  }

  def toTruthTableConclusion(data: ISZ[U8]): TruthTable.Conclusion = {
    def fTruthTableConclusion(reader: Reader): TruthTable.Conclusion = {
      val r = reader.readTruthTableConclusion()
      return r
    }
    val r = to(data, fTruthTableConclusion)
    return r
  }

  def fromTruthTableConclusionValidity(o: TruthTable.Conclusion.Validity, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTruthTableConclusionValidity(o)
    return w.result
  }

  def toTruthTableConclusionValidity(data: ISZ[U8]): TruthTable.Conclusion.Validity = {
    def fTruthTableConclusionValidity(reader: Reader): TruthTable.Conclusion.Validity = {
      val r = reader.readTruthTableConclusionValidity()
      return r
    }
    val r = to(data, fTruthTableConclusionValidity)
    return r
  }

  def fromTruthTableConclusionTautology(o: TruthTable.Conclusion.Tautology, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTruthTableConclusionTautology(o)
    return w.result
  }

  def toTruthTableConclusionTautology(data: ISZ[U8]): TruthTable.Conclusion.Tautology = {
    def fTruthTableConclusionTautology(reader: Reader): TruthTable.Conclusion.Tautology = {
      val r = reader.readTruthTableConclusionTautology()
      return r
    }
    val r = to(data, fTruthTableConclusionTautology)
    return r
  }

  def fromTruthTableConclusionContradictory(o: TruthTable.Conclusion.Contradictory, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTruthTableConclusionContradictory(o)
    return w.result
  }

  def toTruthTableConclusionContradictory(data: ISZ[U8]): TruthTable.Conclusion.Contradictory = {
    def fTruthTableConclusionContradictory(reader: Reader): TruthTable.Conclusion.Contradictory = {
      val r = reader.readTruthTableConclusionContradictory()
      return r
    }
    val r = to(data, fTruthTableConclusionContradictory)
    return r
  }

  def fromTruthTableConclusionContingent(o: TruthTable.Conclusion.Contingent, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTruthTableConclusionContingent(o)
    return w.result
  }

  def toTruthTableConclusionContingent(data: ISZ[U8]): TruthTable.Conclusion.Contingent = {
    def fTruthTableConclusionContingent(reader: Reader): TruthTable.Conclusion.Contingent = {
      val r = reader.readTruthTableConclusionContingent()
      return r
    }
    val r = to(data, fTruthTableConclusionContingent)
    return r
  }

  def fromTyped(o: Typed, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTyped(o)
    return w.result
  }

  def toTyped(data: ISZ[U8]): Typed = {
    def fTyped(reader: Reader): Typed = {
      val r = reader.readTyped()
      return r
    }
    val r = to(data, fTyped)
    return r
  }

  def fromTypedName(o: Typed.Name, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTypedName(o)
    return w.result
  }

  def toTypedName(data: ISZ[U8]): Typed.Name = {
    def fTypedName(reader: Reader): Typed.Name = {
      val r = reader.readTypedName()
      return r
    }
    val r = to(data, fTypedName)
    return r
  }

  def fromTypedTuple(o: Typed.Tuple, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTypedTuple(o)
    return w.result
  }

  def toTypedTuple(data: ISZ[U8]): Typed.Tuple = {
    def fTypedTuple(reader: Reader): Typed.Tuple = {
      val r = reader.readTypedTuple()
      return r
    }
    val r = to(data, fTypedTuple)
    return r
  }

  def fromTypedFun(o: Typed.Fun, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTypedFun(o)
    return w.result
  }

  def toTypedFun(data: ISZ[U8]): Typed.Fun = {
    def fTypedFun(reader: Reader): Typed.Fun = {
      val r = reader.readTypedFun()
      return r
    }
    val r = to(data, fTypedFun)
    return r
  }

  def fromTypedTypeVar(o: Typed.TypeVar, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTypedTypeVar(o)
    return w.result
  }

  def toTypedTypeVar(data: ISZ[U8]): Typed.TypeVar = {
    def fTypedTypeVar(reader: Reader): Typed.TypeVar = {
      val r = reader.readTypedTypeVar()
      return r
    }
    val r = to(data, fTypedTypeVar)
    return r
  }

  def fromTypedPackage(o: Typed.Package, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTypedPackage(o)
    return w.result
  }

  def toTypedPackage(data: ISZ[U8]): Typed.Package = {
    def fTypedPackage(reader: Reader): Typed.Package = {
      val r = reader.readTypedPackage()
      return r
    }
    val r = to(data, fTypedPackage)
    return r
  }

  def fromTypedObject(o: Typed.Object, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTypedObject(o)
    return w.result
  }

  def toTypedObject(data: ISZ[U8]): Typed.Object = {
    def fTypedObject(reader: Reader): Typed.Object = {
      val r = reader.readTypedObject()
      return r
    }
    val r = to(data, fTypedObject)
    return r
  }

  def fromTypedEnum(o: Typed.Enum, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTypedEnum(o)
    return w.result
  }

  def toTypedEnum(data: ISZ[U8]): Typed.Enum = {
    def fTypedEnum(reader: Reader): Typed.Enum = {
      val r = reader.readTypedEnum()
      return r
    }
    val r = to(data, fTypedEnum)
    return r
  }

  def fromTypedMethodSubst(o: Typed.Method.Subst, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTypedMethodSubst(o)
    return w.result
  }

  def toTypedMethodSubst(data: ISZ[U8]): Typed.Method.Subst = {
    def fTypedMethodSubst(reader: Reader): Typed.Method.Subst = {
      val r = reader.readTypedMethodSubst()
      return r
    }
    val r = to(data, fTypedMethodSubst)
    return r
  }

  def fromTypedMethod(o: Typed.Method, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTypedMethod(o)
    return w.result
  }

  def toTypedMethod(data: ISZ[U8]): Typed.Method = {
    def fTypedMethod(reader: Reader): Typed.Method = {
      val r = reader.readTypedMethod()
      return r
    }
    val r = to(data, fTypedMethod)
    return r
  }

  def fromTypedMethods(o: Typed.Methods, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTypedMethods(o)
    return w.result
  }

  def toTypedMethods(data: ISZ[U8]): Typed.Methods = {
    def fTypedMethods(reader: Reader): Typed.Methods = {
      val r = reader.readTypedMethods()
      return r
    }
    val r = to(data, fTypedMethods)
    return r
  }

  def fromAttr(o: Attr, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeAttr(o)
    return w.result
  }

  def toAttr(data: ISZ[U8]): Attr = {
    def fAttr(reader: Reader): Attr = {
      val r = reader.readAttr()
      return r
    }
    val r = to(data, fAttr)
    return r
  }

  def fromTypedAttr(o: TypedAttr, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeTypedAttr(o)
    return w.result
  }

  def toTypedAttr(data: ISZ[U8]): TypedAttr = {
    def fTypedAttr(reader: Reader): TypedAttr = {
      val r = reader.readTypedAttr()
      return r
    }
    val r = to(data, fTypedAttr)
    return r
  }

  def fromResolvedAttr(o: ResolvedAttr, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeResolvedAttr(o)
    return w.result
  }

  def toResolvedAttr(data: ISZ[U8]): ResolvedAttr = {
    def fResolvedAttr(reader: Reader): ResolvedAttr = {
      val r = reader.readResolvedAttr()
      return r
    }
    val r = to(data, fResolvedAttr)
    return r
  }

  def fromResolvedInfo(o: ResolvedInfo, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeResolvedInfo(o)
    return w.result
  }

  def toResolvedInfo(data: ISZ[U8]): ResolvedInfo = {
    def fResolvedInfo(reader: Reader): ResolvedInfo = {
      val r = reader.readResolvedInfo()
      return r
    }
    val r = to(data, fResolvedInfo)
    return r
  }

  def fromResolvedInfoBuiltIn(o: ResolvedInfo.BuiltIn, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeResolvedInfoBuiltIn(o)
    return w.result
  }

  def toResolvedInfoBuiltIn(data: ISZ[U8]): ResolvedInfo.BuiltIn = {
    def fResolvedInfoBuiltIn(reader: Reader): ResolvedInfo.BuiltIn = {
      val r = reader.readResolvedInfoBuiltIn()
      return r
    }
    val r = to(data, fResolvedInfoBuiltIn)
    return r
  }

  def fromResolvedInfoPackage(o: ResolvedInfo.Package, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeResolvedInfoPackage(o)
    return w.result
  }

  def toResolvedInfoPackage(data: ISZ[U8]): ResolvedInfo.Package = {
    def fResolvedInfoPackage(reader: Reader): ResolvedInfo.Package = {
      val r = reader.readResolvedInfoPackage()
      return r
    }
    val r = to(data, fResolvedInfoPackage)
    return r
  }

  def fromResolvedInfoEnum(o: ResolvedInfo.Enum, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeResolvedInfoEnum(o)
    return w.result
  }

  def toResolvedInfoEnum(data: ISZ[U8]): ResolvedInfo.Enum = {
    def fResolvedInfoEnum(reader: Reader): ResolvedInfo.Enum = {
      val r = reader.readResolvedInfoEnum()
      return r
    }
    val r = to(data, fResolvedInfoEnum)
    return r
  }

  def fromResolvedInfoEnumElement(o: ResolvedInfo.EnumElement, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeResolvedInfoEnumElement(o)
    return w.result
  }

  def toResolvedInfoEnumElement(data: ISZ[U8]): ResolvedInfo.EnumElement = {
    def fResolvedInfoEnumElement(reader: Reader): ResolvedInfo.EnumElement = {
      val r = reader.readResolvedInfoEnumElement()
      return r
    }
    val r = to(data, fResolvedInfoEnumElement)
    return r
  }

  def fromResolvedInfoObject(o: ResolvedInfo.Object, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeResolvedInfoObject(o)
    return w.result
  }

  def toResolvedInfoObject(data: ISZ[U8]): ResolvedInfo.Object = {
    def fResolvedInfoObject(reader: Reader): ResolvedInfo.Object = {
      val r = reader.readResolvedInfoObject()
      return r
    }
    val r = to(data, fResolvedInfoObject)
    return r
  }

  def fromResolvedInfoVar(o: ResolvedInfo.Var, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeResolvedInfoVar(o)
    return w.result
  }

  def toResolvedInfoVar(data: ISZ[U8]): ResolvedInfo.Var = {
    def fResolvedInfoVar(reader: Reader): ResolvedInfo.Var = {
      val r = reader.readResolvedInfoVar()
      return r
    }
    val r = to(data, fResolvedInfoVar)
    return r
  }

  def fromResolvedInfoMethod(o: ResolvedInfo.Method, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeResolvedInfoMethod(o)
    return w.result
  }

  def toResolvedInfoMethod(data: ISZ[U8]): ResolvedInfo.Method = {
    def fResolvedInfoMethod(reader: Reader): ResolvedInfo.Method = {
      val r = reader.readResolvedInfoMethod()
      return r
    }
    val r = to(data, fResolvedInfoMethod)
    return r
  }

  def fromResolvedInfoType(o: ResolvedInfo.Type, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeResolvedInfoType(o)
    return w.result
  }

  def toResolvedInfoType(data: ISZ[U8]): ResolvedInfo.Type = {
    def fResolvedInfoType(reader: Reader): ResolvedInfo.Type = {
      val r = reader.readResolvedInfoType()
      return r
    }
    val r = to(data, fResolvedInfoType)
    return r
  }

  def fromResolvedInfoTuple(o: ResolvedInfo.Tuple, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeResolvedInfoTuple(o)
    return w.result
  }

  def toResolvedInfoTuple(data: ISZ[U8]): ResolvedInfo.Tuple = {
    def fResolvedInfoTuple(reader: Reader): ResolvedInfo.Tuple = {
      val r = reader.readResolvedInfoTuple()
      return r
    }
    val r = to(data, fResolvedInfoTuple)
    return r
  }

  def fromResolvedInfoLocalVar(o: ResolvedInfo.LocalVar, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writeResolvedInfoLocalVar(o)
    return w.result
  }

  def toResolvedInfoLocalVar(data: ISZ[U8]): ResolvedInfo.LocalVar = {
    def fResolvedInfoLocalVar(reader: Reader): ResolvedInfo.LocalVar = {
      val r = reader.readResolvedInfoLocalVar()
      return r
    }
    val r = to(data, fResolvedInfoLocalVar)
    return r
  }

  def fromPosInfo(o: PosInfo, poolString: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(poolString))
    w.writePosInfo(o)
    return w.result
  }

  def toPosInfo(data: ISZ[U8]): PosInfo = {
    def fPosInfo(reader: Reader): PosInfo = {
      val r = reader.readPosInfo()
      return r
    }
    val r = to(data, fPosInfo)
    return r
  }

}