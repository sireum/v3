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

// This file is auto-generated from ../symbol/Info.scala, ../ast/AST.scala

package org.sireum.lang.tipe

import org.sireum._

object MsgPack {

  object Constants {

    val _symbolScopeLocal: Z = -32

    val _symbolScopeGlobal: Z = -31

    val _symbolInfoPackage: Z = -30

    val _symbolInfoVar: Z = -29

    val _symbolInfoSpecVar: Z = -28

    val _symbolInfoMethod: Z = -27

    val _symbolInfoSpecMethod: Z = -26

    val _symbolInfoObject: Z = -25

    val _symbolInfoExtMethod: Z = -24

    val _symbolInfoEnum: Z = -23

    val _symbolInfoEnumElement: Z = -22

    val _symbolInfoLocalVar: Z = -21

    val _symbolInfoQuantVar: Z = -20

    val _symbolTypeInfoSubZ: Z = -19

    val _symbolTypeInfoEnum: Z = -18

    val _symbolTypeInfoSig: Z = -17

    val _symbolTypeInfoAbstractDatatype: Z = -16

    val _symbolTypeInfoTypeAlias: Z = -15

    val _symbolTypeInfoTypeVar: Z = -14

    val _symbolTypeInfoMembers: Z = -13

    val _astTopUnitProgram: Z = -12

    val _astTopUnitSequentUnit: Z = -11

    val _astTopUnitTruthTableUnit: Z = -10

    val _astStmtImport: Z = -9

    val _astStmtImportImporter: Z = -8

    val _astStmtImportMultiSelector: Z = -7

    val _astStmtImportWildcardSelector: Z = -6

    val _astStmtImportNamedSelector: Z = -5

    val _astStmtVar: Z = -4

    val _astStmtVarPattern: Z = -3

    val _astStmtSpecVar: Z = -2

    val _astStmtMethod: Z = -1

    val _astStmtExtMethod: Z = 0

    val _astStmtSpecMethod: Z = 1

    val _astStmtEnum: Z = 2

    val _astStmtSubZ: Z = 3

    val _astStmtObject: Z = 4

    val _astStmtSig: Z = 5

    val _astStmtAbstractDatatype: Z = 6

    val _astStmtTypeAlias: Z = 7

    val _astStmtAssign: Z = 8

    val _astStmtBlock: Z = 9

    val _astStmtIf: Z = 10

    val _astStmtMatch: Z = 11

    val _astStmtWhile: Z = 12

    val _astStmtDoWhile: Z = 13

    val _astStmtFor: Z = 14

    val _astStmtReturn: Z = 15

    val _astStmtLStmt: Z = 16

    val _astStmtExpr: Z = 17

    val _astLClauseInvariants: Z = 18

    val _astLClauseFacts: Z = 19

    val _astLClauseFact: Z = 20

    val _astLClauseTheorems: Z = 21

    val _astLClauseTheorem: Z = 22

    val _astLClauseSequent: Z = 23

    val _astLClauseProof: Z = 24

    val _astContractExp: Z = 25

    val _astCase: Z = 26

    val _astEnumGenRangeExpr: Z = 27

    val _astEnumGenRangeStep: Z = 28

    val _astEnumGenFor: Z = 29

    val _astTypeNamed: Z = 30

    val _astTypeFun: Z = 31

    val _astTypeTuple: Z = 32

    val _astPatternLiteral: Z = 33

    val _astPatternLitInterpolate: Z = 34

    val _astPatternRef: Z = 35

    val _astPatternVarBinding: Z = 36

    val _astPatternWildcard: Z = 37

    val _astPatternSeqWildcard: Z = 38

    val _astPatternStructure: Z = 39

    val _astExpLitB: Z = 40

    val _astExpLitC: Z = 41

    val _astExpLitZ: Z = 42

    val _astExpLitF32: Z = 43

    val _astExpLitF64: Z = 44

    val _astExpLitR: Z = 45

    val _astExpLitString: Z = 46

    val _astExpStringInterpolate: Z = 47

    val _astExpThis: Z = 48

    val _astExpSuper: Z = 49

    val _astExpUnary: Z = 50

    val _astExpBinary: Z = 51

    val _astExpIdent: Z = 52

    val _astExpEta: Z = 53

    val _astExpTuple: Z = 54

    val _astExpSelect: Z = 55

    val _astExpInvoke: Z = 56

    val _astExpInvokeNamed: Z = 57

    val _astExpIf: Z = 58

    val _astExpFunParam: Z = 59

    val _astExpFun: Z = 60

    val _astExpForYield: Z = 61

    val _astExpQuant: Z = 62

    val _astNamedArg: Z = 63

    val _astVarFragment: Z = 64

    val _astDomainType: Z = 65

    val _astDomainRange: Z = 66

    val _astId: Z = 67

    val _astName: Z = 68

    val _astBody: Z = 69

    val _astAbstractDatatypeParam: Z = 70

    val _astMethodSig: Z = 71

    val _astParam: Z = 72

    val _astTypeParam: Z = 73

    val _astContract: Z = 74

    val _astSubContract: Z = 75

    val _astWhereDefVal: Z = 76

    val _astWhereDefDef: Z = 77

    val _astSpecDef: Z = 78

    val _astTypedName: Z = 79

    val _astTypedTuple: Z = 80

    val _astTypedFun: Z = 81

    val _astTypedTypeVar: Z = 82

    val _astTypedPackage: Z = 83

    val _astTypedObject: Z = 84

    val _astTypedEnum: Z = 85

    val _astTypedMethodSubst: Z = 86

    val _astTypedMethod: Z = 87

    val _astTypedMethods: Z = 88

    val _astAttr: Z = 89

    val _astTypedAttr: Z = 90

    val _astResolvedAttr: Z = 91

    val _astResolvedInfoBuiltIn: Z = 92

    val _astResolvedInfoPackage: Z = 93

    val _astResolvedInfoEnum: Z = 94

    val _astResolvedInfoEnumElement: Z = 95

    val _astResolvedInfoObject: Z = 96

    val _astResolvedInfoVar: Z = 97

    val _astResolvedInfoMethod: Z = 98

    val _astResolvedInfoMethods: Z = 99

    val _astResolvedInfoType: Z = 100

    val _astResolvedInfoTuple: Z = 101

    val _astResolvedInfoLocalVar: Z = 102

    val _astProofStepBasic: Z = 103

    val _astProofStepSubProof: Z = 104

    val _astAssumeProofStepRegular: Z = 105

    val _astAssumeProofStepForallIntroAps: Z = 106

    val _astAssumeProofStepExistsElimAps: Z = 107

    val _astJustPremise: Z = 108

    val _astJustAuto: Z = 109

    val _astJustCoq: Z = 110

    val _astJustSubst: Z = 111

    val _astJustInvariant: Z = 112

    val _astJustFact: Z = 113

    val _astJustImplyIntro: Z = 114

    val _astJustImplyElim: Z = 115

    val _astJustNegIntro: Z = 116

    val _astJustNegElim: Z = 117

    val _astJustBottomElim: Z = 118

    val _astJustForallIntro: Z = 119

    val _astJustForallElim: Z = 120

    val _astJustExistsIntro: Z = 121

    val _astJustExistsElim: Z = 122

    val _astJustOrIntro: Z = 123

    val _astJustOrElim: Z = 124

    val _astJustAndIntro: Z = 125

    val _astJustAndElim: Z = 126

    val _astJustPbc: Z = 127

    val _astTruthTableRow: Z = 128

    val _astTruthTableAssignment: Z = 129

    val _astTruthTableConclusionValidity: Z = 130

    val _astTruthTableConclusionTautology: Z = 131

    val _astTruthTableConclusionContradictory: Z = 132

    val _astTruthTableConclusionContingent: Z = 133

  }

  object Writer {

    @record class Default(val writer: MessagePack.Writer.Impl) extends Writer

  }

  @msig trait Writer {

    def writer: MessagePack.Writer

    def write_symbolScope(o: org.sireum.lang.symbol.Scope): Unit = {
      o match {
        case o: org.sireum.lang.symbol.Scope.Local => write_symbolScopeLocal(o)
        case o: org.sireum.lang.symbol.Scope.Global => write_symbolScopeGlobal(o)
      }
    }

    def write_symbolScopeLocal(o: org.sireum.lang.symbol.Scope.Local): Unit = {
      writer.writeZ(Constants._symbolScopeLocal)
      writer.writeHashMap(o.nameMap, writer.writeString _, write_symbolInfo _)
      writer.writeHashMap(o.typeMap, writer.writeString _, write_symbolTypeInfo _)
      writer.writeOption(o.localThisOpt, write_astTyped _)
      writer.writeOption(o.methodReturnOpt, write_astTyped _)
      writer.writeOption(o.outerOpt, write_symbolScope _)
    }

    def write_symbolScopeGlobal(o: org.sireum.lang.symbol.Scope.Global): Unit = {
      writer.writeZ(Constants._symbolScopeGlobal)
      writer.writeISZ(o.packageName, writer.writeString _)
      writer.writeISZ(o.imports, write_astStmtImport _)
      writer.writeISZ(o.enclosingName, writer.writeString _)
    }

    def write_symbolInfo(o: org.sireum.lang.symbol.Info): Unit = {
      o match {
        case o: org.sireum.lang.symbol.Info.Package => write_symbolInfoPackage(o)
        case o: org.sireum.lang.symbol.Info.Var => write_symbolInfoVar(o)
        case o: org.sireum.lang.symbol.Info.SpecVar => write_symbolInfoSpecVar(o)
        case o: org.sireum.lang.symbol.Info.Method => write_symbolInfoMethod(o)
        case o: org.sireum.lang.symbol.Info.SpecMethod => write_symbolInfoSpecMethod(o)
        case o: org.sireum.lang.symbol.Info.Object => write_symbolInfoObject(o)
        case o: org.sireum.lang.symbol.Info.ExtMethod => write_symbolInfoExtMethod(o)
        case o: org.sireum.lang.symbol.Info.Enum => write_symbolInfoEnum(o)
        case o: org.sireum.lang.symbol.Info.EnumElement => write_symbolInfoEnumElement(o)
        case o: org.sireum.lang.symbol.Info.LocalVar => write_symbolInfoLocalVar(o)
        case o: org.sireum.lang.symbol.Info.QuantVar => write_symbolInfoQuantVar(o)
      }
    }

    def write_symbolInfoPackage(o: org.sireum.lang.symbol.Info.Package): Unit = {
      writer.writeZ(Constants._symbolInfoPackage)
      writer.writeISZ(o.name, writer.writeString _)
      writer.writeOption(o.typedOpt, write_astTyped _)
      writer.writeOption(o.resOpt, write_astResolvedInfo _)
    }

    def write_symbolInfoVar(o: org.sireum.lang.symbol.Info.Var): Unit = {
      writer.writeZ(Constants._symbolInfoVar)
      writer.writeISZ(o.owner, writer.writeString _)
      writer.writeB(o.isInObject)
      write_symbolScope(o.scope)
      write_astStmtVar(o.ast)
      writer.writeOption(o.typedOpt, write_astTyped _)
      writer.writeOption(o.resOpt, write_astResolvedInfo _)
    }

    def write_symbolInfoSpecVar(o: org.sireum.lang.symbol.Info.SpecVar): Unit = {
      writer.writeZ(Constants._symbolInfoSpecVar)
      writer.writeISZ(o.owner, writer.writeString _)
      writer.writeB(o.isInObject)
      write_symbolScope(o.scope)
      write_astStmtSpecVar(o.ast)
      writer.writeOption(o.typedOpt, write_astTyped _)
      writer.writeOption(o.resOpt, write_astResolvedInfo _)
    }

    def write_symbolInfoMethod(o: org.sireum.lang.symbol.Info.Method): Unit = {
      writer.writeZ(Constants._symbolInfoMethod)
      writer.writeISZ(o.owner, writer.writeString _)
      writer.writeB(o.isInObject)
      write_symbolScope(o.scope)
      writer.writeB(o.hasBody)
      write_astStmtMethod(o.ast)
      writer.writeOption(o.typedOpt, write_astTyped _)
      writer.writeOption(o.resOpt, write_astResolvedInfo _)
    }

    def write_symbolInfoSpecMethod(o: org.sireum.lang.symbol.Info.SpecMethod): Unit = {
      writer.writeZ(Constants._symbolInfoSpecMethod)
      writer.writeISZ(o.owner, writer.writeString _)
      writer.writeB(o.isInObject)
      write_symbolScope(o.scope)
      write_astStmtSpecMethod(o.ast)
      writer.writeOption(o.typedOpt, write_astTyped _)
      writer.writeOption(o.resOpt, write_astResolvedInfo _)
    }

    def write_symbolInfoObject(o: org.sireum.lang.symbol.Info.Object): Unit = {
      writer.writeZ(Constants._symbolInfoObject)
      writer.writeISZ(o.owner, writer.writeString _)
      writer.writeB(o.isSynthetic)
      write_symbolScopeGlobal(o.scope)
      writer.writeB(o.outlined)
      writer.writeB(o.typeChecked)
      write_astStmtObject(o.ast)
      writer.writeOption(o.typedOpt, write_astTyped _)
      writer.writeOption(o.resOpt, write_astResolvedInfo _)
    }

    def write_symbolInfoExtMethod(o: org.sireum.lang.symbol.Info.ExtMethod): Unit = {
      writer.writeZ(Constants._symbolInfoExtMethod)
      writer.writeISZ(o.owner, writer.writeString _)
      write_symbolScopeGlobal(o.scope)
      write_astStmtExtMethod(o.ast)
      writer.writeOption(o.typedOpt, write_astTyped _)
      writer.writeOption(o.resOpt, write_astResolvedInfo _)
    }

    def write_symbolInfoEnum(o: org.sireum.lang.symbol.Info.Enum): Unit = {
      writer.writeZ(Constants._symbolInfoEnum)
      writer.writeISZ(o.name, writer.writeString _)
      writer.writeMap(o.elements, writer.writeString _, write_astResolvedInfo _)
      writer.writeOption(o.typedOpt, write_astTyped _)
      writer.writeOption(o.resOpt, write_astResolvedInfo _)
      writer.writeOption(o.elementTypedOpt, write_astTyped _)
      writer.writeOption(o.posOpt, writer.writePosition _)
    }

    def write_symbolInfoEnumElement(o: org.sireum.lang.symbol.Info.EnumElement): Unit = {
      writer.writeZ(Constants._symbolInfoEnumElement)
      writer.writeISZ(o.owner, writer.writeString _)
      writer.writeString(o.id)
      writer.writeOption(o.typedOpt, write_astTyped _)
      writer.writeOption(o.resOpt, write_astResolvedInfo _)
      writer.writeOption(o.posOpt, writer.writePosition _)
    }

    def write_symbolInfoLocalVar(o: org.sireum.lang.symbol.Info.LocalVar): Unit = {
      writer.writeZ(Constants._symbolInfoLocalVar)
      writer.writeISZ(o.name, writer.writeString _)
      writer.writeB(o.isVal)
      write_astId(o.ast)
      writer.writeOption(o.typedOpt, write_astTyped _)
      writer.writeOption(o.resOpt, write_astResolvedInfo _)
    }

    def write_symbolInfoQuantVar(o: org.sireum.lang.symbol.Info.QuantVar): Unit = {
      writer.writeZ(Constants._symbolInfoQuantVar)
      writer.writeISZ(o.name, writer.writeString _)
      write_astId(o.ast)
      writer.writeOption(o.typedOpt, write_astTyped _)
      writer.writeOption(o.resOpt, write_astResolvedInfo _)
    }

    def write_symbolTypeInfo(o: org.sireum.lang.symbol.TypeInfo): Unit = {
      o match {
        case o: org.sireum.lang.symbol.TypeInfo.SubZ => write_symbolTypeInfoSubZ(o)
        case o: org.sireum.lang.symbol.TypeInfo.Enum => write_symbolTypeInfoEnum(o)
        case o: org.sireum.lang.symbol.TypeInfo.Sig => write_symbolTypeInfoSig(o)
        case o: org.sireum.lang.symbol.TypeInfo.AbstractDatatype => write_symbolTypeInfoAbstractDatatype(o)
        case o: org.sireum.lang.symbol.TypeInfo.TypeAlias => write_symbolTypeInfoTypeAlias(o)
        case o: org.sireum.lang.symbol.TypeInfo.TypeVar => write_symbolTypeInfoTypeVar(o)
      }
    }

    def write_symbolTypeInfoSubZ(o: org.sireum.lang.symbol.TypeInfo.SubZ): Unit = {
      writer.writeZ(Constants._symbolTypeInfoSubZ)
      writer.writeISZ(o.owner, writer.writeString _)
      write_astStmtSubZ(o.ast)
    }

    def write_symbolTypeInfoEnum(o: org.sireum.lang.symbol.TypeInfo.Enum): Unit = {
      writer.writeZ(Constants._symbolTypeInfoEnum)
      writer.writeISZ(o.owner, writer.writeString _)
      writer.writeMap(o.elements, writer.writeString _, write_astResolvedInfo _)
      writer.writeOption(o.posOpt, writer.writePosition _)
    }

    def write_symbolTypeInfoSig(o: org.sireum.lang.symbol.TypeInfo.Sig): Unit = {
      writer.writeZ(Constants._symbolTypeInfoSig)
      writer.writeISZ(o.owner, writer.writeString _)
      writer.writeB(o.outlined)
      writer.writeB(o.typeChecked)
      write_astTypedName(o.tpe)
      writer.writeISZ(o.ancestors, write_astTypedName _)
      writer.writeHashMap(o.specVars, writer.writeString _, write_symbolInfoSpecVar _)
      writer.writeHashMap(o.specMethods, writer.writeString _, write_symbolInfoSpecMethod _)
      writer.writeHashMap(o.methods, writer.writeString _, write_symbolInfoMethod _)
      write_symbolScopeGlobal(o.scope)
      write_astStmtSig(o.ast)
    }

    def write_symbolTypeInfoAbstractDatatype(o: org.sireum.lang.symbol.TypeInfo.AbstractDatatype): Unit = {
      writer.writeZ(Constants._symbolTypeInfoAbstractDatatype)
      writer.writeISZ(o.owner, writer.writeString _)
      writer.writeB(o.outlined)
      writer.writeB(o.typeChecked)
      write_astTypedName(o.tpe)
      writer.writeOption(o.constructorTypeOpt, write_astTyped _)
      writer.writeOption(o.constructorResOpt, write_astResolvedInfo _)
      writer.writeMap(o.extractorTypeMap, writer.writeString _, write_astTyped _)
      writer.writeOption(o.extractorResOpt, write_astResolvedInfo _)
      writer.writeISZ(o.ancestors, write_astTypedName _)
      writer.writeHashMap(o.specVars, writer.writeString _, write_symbolInfoSpecVar _)
      writer.writeHashMap(o.vars, writer.writeString _, write_symbolInfoVar _)
      writer.writeHashMap(o.specMethods, writer.writeString _, write_symbolInfoSpecMethod _)
      writer.writeHashMap(o.methods, writer.writeString _, write_symbolInfoMethod _)
      write_symbolScopeGlobal(o.scope)
      write_astStmtAbstractDatatype(o.ast)
    }

    def write_symbolTypeInfoTypeAlias(o: org.sireum.lang.symbol.TypeInfo.TypeAlias): Unit = {
      writer.writeZ(Constants._symbolTypeInfoTypeAlias)
      writer.writeISZ(o.name, writer.writeString _)
      write_symbolScopeGlobal(o.scope)
      write_astStmtTypeAlias(o.ast)
    }

    def write_symbolTypeInfoTypeVar(o: org.sireum.lang.symbol.TypeInfo.TypeVar): Unit = {
      writer.writeZ(Constants._symbolTypeInfoTypeVar)
      writer.writeString(o.id)
      write_astTypeParam(o.ast)
    }

    def write_symbolTypeInfoMembers(o: org.sireum.lang.symbol.TypeInfo.Members): Unit = {
      writer.writeZ(Constants._symbolTypeInfoMembers)
      writer.writeHashMap(o.specVars, writer.writeString _, write_symbolInfoSpecVar _)
      writer.writeHashMap(o.vars, writer.writeString _, write_symbolInfoVar _)
      writer.writeHashMap(o.specMethods, writer.writeString _, write_symbolInfoSpecMethod _)
      writer.writeHashMap(o.methods, writer.writeString _, write_symbolInfoMethod _)
    }

    def write_astTopUnit(o: org.sireum.lang.ast.TopUnit): Unit = {
      o match {
        case o: org.sireum.lang.ast.TopUnit.Program => write_astTopUnitProgram(o)
        case o: org.sireum.lang.ast.TopUnit.SequentUnit => write_astTopUnitSequentUnit(o)
        case o: org.sireum.lang.ast.TopUnit.TruthTableUnit => write_astTopUnitTruthTableUnit(o)
      }
    }

    def write_astTopUnitProgram(o: org.sireum.lang.ast.TopUnit.Program): Unit = {
      writer.writeZ(Constants._astTopUnitProgram)
      writer.writeOption(o.fileUriOpt, writer.writeString _)
      write_astName(o.packageName)
      write_astBody(o.body)
    }

    def write_astTopUnitSequentUnit(o: org.sireum.lang.ast.TopUnit.SequentUnit): Unit = {
      writer.writeZ(Constants._astTopUnitSequentUnit)
      writer.writeOption(o.fileUriOpt, writer.writeString _)
      write_astLClauseSequent(o.sequent)
    }

    def write_astTopUnitTruthTableUnit(o: org.sireum.lang.ast.TopUnit.TruthTableUnit): Unit = {
      writer.writeZ(Constants._astTopUnitTruthTableUnit)
      writer.writeOption(o.fileUriOpt, writer.writeString _)
      writer.writeISZ(o.stars, writer.writePosition _)
      writer.writeISZ(o.vars, write_astId _)
      writer.writePosition(o.separator)
      writer.writeB(o.isSequent)
      write_astLClauseSequent(o.sequent)
      writer.writeISZ(o.rows, write_astTruthTableRow _)
      writer.writeOption(o.conclusionOpt, write_astTruthTableConclusion _)
    }

    def write_astStmt(o: org.sireum.lang.ast.Stmt): Unit = {
      o match {
        case o: org.sireum.lang.ast.Stmt.Import => write_astStmtImport(o)
        case o: org.sireum.lang.ast.Stmt.Var => write_astStmtVar(o)
        case o: org.sireum.lang.ast.Stmt.VarPattern => write_astStmtVarPattern(o)
        case o: org.sireum.lang.ast.Stmt.SpecVar => write_astStmtSpecVar(o)
        case o: org.sireum.lang.ast.Stmt.Method => write_astStmtMethod(o)
        case o: org.sireum.lang.ast.Stmt.ExtMethod => write_astStmtExtMethod(o)
        case o: org.sireum.lang.ast.Stmt.SpecMethod => write_astStmtSpecMethod(o)
        case o: org.sireum.lang.ast.Stmt.Enum => write_astStmtEnum(o)
        case o: org.sireum.lang.ast.Stmt.SubZ => write_astStmtSubZ(o)
        case o: org.sireum.lang.ast.Stmt.Object => write_astStmtObject(o)
        case o: org.sireum.lang.ast.Stmt.Sig => write_astStmtSig(o)
        case o: org.sireum.lang.ast.Stmt.AbstractDatatype => write_astStmtAbstractDatatype(o)
        case o: org.sireum.lang.ast.Stmt.TypeAlias => write_astStmtTypeAlias(o)
        case o: org.sireum.lang.ast.Stmt.Assign => write_astStmtAssign(o)
        case o: org.sireum.lang.ast.Stmt.Block => write_astStmtBlock(o)
        case o: org.sireum.lang.ast.Stmt.If => write_astStmtIf(o)
        case o: org.sireum.lang.ast.Stmt.Match => write_astStmtMatch(o)
        case o: org.sireum.lang.ast.Stmt.While => write_astStmtWhile(o)
        case o: org.sireum.lang.ast.Stmt.DoWhile => write_astStmtDoWhile(o)
        case o: org.sireum.lang.ast.Stmt.For => write_astStmtFor(o)
        case o: org.sireum.lang.ast.Stmt.Return => write_astStmtReturn(o)
        case o: org.sireum.lang.ast.Stmt.LStmt => write_astStmtLStmt(o)
        case o: org.sireum.lang.ast.Stmt.Expr => write_astStmtExpr(o)
      }
    }

    def write_astStmtImport(o: org.sireum.lang.ast.Stmt.Import): Unit = {
      writer.writeZ(Constants._astStmtImport)
      writer.writeISZ(o.importers, write_astStmtImportImporter _)
      write_astAttr(o.attr)
    }

    def write_astStmtImportImporter(o: org.sireum.lang.ast.Stmt.Import.Importer): Unit = {
      writer.writeZ(Constants._astStmtImportImporter)
      write_astName(o.name)
      writer.writeOption(o.selectorOpt, write_astStmtImportSelector _)
    }

    def write_astStmtImportSelector(o: org.sireum.lang.ast.Stmt.Import.Selector): Unit = {
      o match {
        case o: org.sireum.lang.ast.Stmt.Import.MultiSelector => write_astStmtImportMultiSelector(o)
        case o: org.sireum.lang.ast.Stmt.Import.WildcardSelector => write_astStmtImportWildcardSelector(o)
      }
    }

    def write_astStmtImportMultiSelector(o: org.sireum.lang.ast.Stmt.Import.MultiSelector): Unit = {
      writer.writeZ(Constants._astStmtImportMultiSelector)
      writer.writeISZ(o.selectors, write_astStmtImportNamedSelector _)
    }

    def write_astStmtImportWildcardSelector(o: org.sireum.lang.ast.Stmt.Import.WildcardSelector): Unit = {
      writer.writeZ(Constants._astStmtImportWildcardSelector)
    }

    def write_astStmtImportNamedSelector(o: org.sireum.lang.ast.Stmt.Import.NamedSelector): Unit = {
      writer.writeZ(Constants._astStmtImportNamedSelector)
      write_astId(o.from)
      write_astId(o.to)
    }

    def write_astStmtVar(o: org.sireum.lang.ast.Stmt.Var): Unit = {
      writer.writeZ(Constants._astStmtVar)
      writer.writeB(o.isVal)
      write_astId(o.id)
      writer.writeOption(o.tipeOpt, write_astType _)
      writer.writeOption(o.initOpt, write_astAssignExp _)
      write_astAttr(o.attr)
    }

    def write_astStmtVarPattern(o: org.sireum.lang.ast.Stmt.VarPattern): Unit = {
      writer.writeZ(Constants._astStmtVarPattern)
      writer.writeB(o.isVal)
      write_astPattern(o.pattern)
      writer.writeOption(o.tipeOpt, write_astType _)
      write_astAssignExp(o.init)
      write_astAttr(o.attr)
    }

    def write_astStmtSpecVar(o: org.sireum.lang.ast.Stmt.SpecVar): Unit = {
      writer.writeZ(Constants._astStmtSpecVar)
      writer.writeB(o.isVal)
      write_astId(o.id)
      write_astType(o.tipe)
      write_astAttr(o.attr)
    }

    def write_astStmtMethod(o: org.sireum.lang.ast.Stmt.Method): Unit = {
      writer.writeZ(Constants._astStmtMethod)
      write_astPurityType(o.purity)
      writer.writeB(o.hasOverride)
      writer.writeB(o.isHelper)
      write_astMethodSig(o.sig)
      write_astContract(o.contract)
      writer.writeOption(o.bodyOpt, write_astBody _)
      write_astAttr(o.attr)
    }

    def write_astStmtExtMethod(o: org.sireum.lang.ast.Stmt.ExtMethod): Unit = {
      writer.writeZ(Constants._astStmtExtMethod)
      writer.writeB(o.isPure)
      write_astMethodSig(o.sig)
      write_astContract(o.contract)
      write_astAttr(o.attr)
    }

    def write_astStmtSpecMethod(o: org.sireum.lang.ast.Stmt.SpecMethod): Unit = {
      writer.writeZ(Constants._astStmtSpecMethod)
      write_astMethodSig(o.sig)
      writer.writeISZ(o.defs, write_astSpecDef _)
      writer.writeISZ(o.where, write_astWhereDef _)
      write_astAttr(o.attr)
    }

    def write_astStmtEnum(o: org.sireum.lang.ast.Stmt.Enum): Unit = {
      writer.writeZ(Constants._astStmtEnum)
      write_astId(o.id)
      writer.writeISZ(o.elements, write_astId _)
      write_astAttr(o.attr)
    }

    def write_astStmtSubZ(o: org.sireum.lang.ast.Stmt.SubZ): Unit = {
      writer.writeZ(Constants._astStmtSubZ)
      write_astId(o.id)
      writer.writeB(o.isSigned)
      writer.writeB(o.isBitVector)
      writer.writeB(o.isWrapped)
      writer.writeB(o.hasMin)
      writer.writeB(o.hasMax)
      writer.writeZ(o.bitWidth)
      writer.writeZ(o.min)
      writer.writeZ(o.max)
      writer.writeZ(o.index)
      write_astAttr(o.attr)
    }

    def write_astStmtObject(o: org.sireum.lang.ast.Stmt.Object): Unit = {
      writer.writeZ(Constants._astStmtObject)
      writer.writeB(o.isExt)
      write_astId(o.id)
      writer.writeISZ(o.parents, write_astType _)
      writer.writeISZ(o.stmts, write_astStmt _)
      write_astAttr(o.attr)
    }

    def write_astStmtSig(o: org.sireum.lang.ast.Stmt.Sig): Unit = {
      writer.writeZ(Constants._astStmtSig)
      writer.writeB(o.isImmutable)
      writer.writeB(o.isExt)
      write_astId(o.id)
      writer.writeISZ(o.typeParams, write_astTypeParam _)
      writer.writeISZ(o.parents, write_astTypeNamed _)
      writer.writeISZ(o.stmts, write_astStmt _)
      write_astAttr(o.attr)
    }

    def write_astStmtAbstractDatatype(o: org.sireum.lang.ast.Stmt.AbstractDatatype): Unit = {
      writer.writeZ(Constants._astStmtAbstractDatatype)
      writer.writeB(o.isRoot)
      writer.writeB(o.isDatatype)
      write_astId(o.id)
      writer.writeISZ(o.typeParams, write_astTypeParam _)
      writer.writeISZ(o.params, write_astAbstractDatatypeParam _)
      writer.writeISZ(o.parents, write_astTypeNamed _)
      writer.writeISZ(o.stmts, write_astStmt _)
      write_astAttr(o.attr)
    }

    def write_astStmtTypeAlias(o: org.sireum.lang.ast.Stmt.TypeAlias): Unit = {
      writer.writeZ(Constants._astStmtTypeAlias)
      write_astId(o.id)
      writer.writeISZ(o.typeParams, write_astTypeParam _)
      write_astType(o.tipe)
      write_astAttr(o.attr)
    }

    def write_astStmtAssign(o: org.sireum.lang.ast.Stmt.Assign): Unit = {
      writer.writeZ(Constants._astStmtAssign)
      write_astExp(o.lhs)
      write_astAssignExp(o.rhs)
      write_astAttr(o.attr)
    }

    def write_astStmtBlock(o: org.sireum.lang.ast.Stmt.Block): Unit = {
      writer.writeZ(Constants._astStmtBlock)
      write_astBody(o.body)
      write_astAttr(o.attr)
    }

    def write_astStmtIf(o: org.sireum.lang.ast.Stmt.If): Unit = {
      writer.writeZ(Constants._astStmtIf)
      write_astExp(o.cond)
      write_astBody(o.thenBody)
      write_astBody(o.elseBody)
      write_astAttr(o.attr)
    }

    def write_astStmtMatch(o: org.sireum.lang.ast.Stmt.Match): Unit = {
      writer.writeZ(Constants._astStmtMatch)
      write_astExp(o.exp)
      writer.writeISZ(o.cases, write_astCase _)
      write_astAttr(o.attr)
    }

    def write_astStmtWhile(o: org.sireum.lang.ast.Stmt.While): Unit = {
      writer.writeZ(Constants._astStmtWhile)
      write_astExp(o.cond)
      writer.writeISZ(o.invariants, write_astContractExp _)
      writer.writeISZ(o.modifies, write_astExp _)
      write_astBody(o.body)
      write_astAttr(o.attr)
    }

    def write_astStmtDoWhile(o: org.sireum.lang.ast.Stmt.DoWhile): Unit = {
      writer.writeZ(Constants._astStmtDoWhile)
      write_astExp(o.cond)
      writer.writeISZ(o.invariants, write_astContractExp _)
      writer.writeISZ(o.modifies, write_astExp _)
      write_astBody(o.body)
      write_astAttr(o.attr)
    }

    def write_astStmtFor(o: org.sireum.lang.ast.Stmt.For): Unit = {
      writer.writeZ(Constants._astStmtFor)
      writer.writeISZ(o.enumGens, write_astEnumGenFor _)
      writer.writeISZ(o.invariants, write_astContractExp _)
      writer.writeISZ(o.modifies, write_astExp _)
      write_astBody(o.body)
      write_astAttr(o.attr)
    }

    def write_astStmtReturn(o: org.sireum.lang.ast.Stmt.Return): Unit = {
      writer.writeZ(Constants._astStmtReturn)
      writer.writeOption(o.expOpt, write_astExp _)
      write_astTypedAttr(o.attr)
    }

    def write_astStmtLStmt(o: org.sireum.lang.ast.Stmt.LStmt): Unit = {
      writer.writeZ(Constants._astStmtLStmt)
      write_astLClause(o.clause)
      write_astAttr(o.attr)
    }

    def write_astStmtExpr(o: org.sireum.lang.ast.Stmt.Expr): Unit = {
      writer.writeZ(Constants._astStmtExpr)
      write_astExp(o.exp)
      write_astTypedAttr(o.attr)
    }

    def write_astAssignExp(o: org.sireum.lang.ast.AssignExp): Unit = {
      o match {
        case o: org.sireum.lang.ast.Stmt.Block => write_astStmtBlock(o)
        case o: org.sireum.lang.ast.Stmt.If => write_astStmtIf(o)
        case o: org.sireum.lang.ast.Stmt.Match => write_astStmtMatch(o)
        case o: org.sireum.lang.ast.Stmt.Return => write_astStmtReturn(o)
        case o: org.sireum.lang.ast.Stmt.Expr => write_astStmtExpr(o)
      }
    }

    def write_astPurityType(o: org.sireum.lang.ast.Purity.Type): Unit = {
      writer.writeZ(o.ordinal)
    }

    def write_astLClause(o: org.sireum.lang.ast.LClause): Unit = {
      o match {
        case o: org.sireum.lang.ast.LClause.Invariants => write_astLClauseInvariants(o)
        case o: org.sireum.lang.ast.LClause.Facts => write_astLClauseFacts(o)
        case o: org.sireum.lang.ast.LClause.Theorems => write_astLClauseTheorems(o)
        case o: org.sireum.lang.ast.LClause.Sequent => write_astLClauseSequent(o)
        case o: org.sireum.lang.ast.LClause.Proof => write_astLClauseProof(o)
      }
    }

    def write_astLClauseInvariants(o: org.sireum.lang.ast.LClause.Invariants): Unit = {
      writer.writeZ(Constants._astLClauseInvariants)
      writer.writeISZ(o.value, write_astContractExp _)
    }

    def write_astLClauseFacts(o: org.sireum.lang.ast.LClause.Facts): Unit = {
      writer.writeZ(Constants._astLClauseFacts)
      writer.writeISZ(o.value, write_astLClauseFact _)
    }

    def write_astLClauseFact(o: org.sireum.lang.ast.LClause.Fact): Unit = {
      writer.writeZ(Constants._astLClauseFact)
      write_astId(o.id)
      write_astExp(o.exp)
    }

    def write_astLClauseTheorems(o: org.sireum.lang.ast.LClause.Theorems): Unit = {
      writer.writeZ(Constants._astLClauseTheorems)
      writer.writeISZ(o.value, write_astLClauseTheorem _)
    }

    def write_astLClauseTheorem(o: org.sireum.lang.ast.LClause.Theorem): Unit = {
      writer.writeZ(Constants._astLClauseTheorem)
      write_astId(o.id)
      write_astLClauseSequent(o.sequent)
    }

    def write_astLClauseSequent(o: org.sireum.lang.ast.LClause.Sequent): Unit = {
      writer.writeZ(Constants._astLClauseSequent)
      writer.writeISZ(o.premises, write_astExp _)
      writer.writeISZ(o.conclusions, write_astExp _)
      writer.writeOption(o.proofOpt, write_astLClauseProof _)
    }

    def write_astLClauseProof(o: org.sireum.lang.ast.LClause.Proof): Unit = {
      writer.writeZ(Constants._astLClauseProof)
      writer.writeISZ(o.steps, write_astProofStep _)
    }

    def write_astContractExp(o: org.sireum.lang.ast.ContractExp): Unit = {
      writer.writeZ(Constants._astContractExp)
      writer.writeOption(o.idOpt, write_astId _)
      write_astExp(o.exp)
    }

    def write_astCase(o: org.sireum.lang.ast.Case): Unit = {
      writer.writeZ(Constants._astCase)
      write_astPattern(o.pattern)
      writer.writeOption(o.condOpt, write_astExp _)
      write_astBody(o.body)
    }

    def write_astEnumGenRange(o: org.sireum.lang.ast.EnumGen.Range): Unit = {
      o match {
        case o: org.sireum.lang.ast.EnumGen.Range.Expr => write_astEnumGenRangeExpr(o)
        case o: org.sireum.lang.ast.EnumGen.Range.Step => write_astEnumGenRangeStep(o)
      }
    }

    def write_astEnumGenRangeExpr(o: org.sireum.lang.ast.EnumGen.Range.Expr): Unit = {
      writer.writeZ(Constants._astEnumGenRangeExpr)
      writer.writeB(o.isReverse)
      writer.writeB(o.isIndices)
      write_astExp(o.exp)
      write_astAttr(o.attr)
    }

    def write_astEnumGenRangeStep(o: org.sireum.lang.ast.EnumGen.Range.Step): Unit = {
      writer.writeZ(Constants._astEnumGenRangeStep)
      writer.writeB(o.isInclusive)
      write_astExp(o.start)
      write_astExp(o.end)
      writer.writeOption(o.byOpt, write_astExp _)
      write_astAttr(o.attr)
    }

    def write_astEnumGenFor(o: org.sireum.lang.ast.EnumGen.For): Unit = {
      writer.writeZ(Constants._astEnumGenFor)
      writer.writeOption(o.idOpt, write_astId _)
      write_astEnumGenRange(o.range)
      writer.writeOption(o.condOpt, write_astExp _)
    }

    def write_astType(o: org.sireum.lang.ast.Type): Unit = {
      o match {
        case o: org.sireum.lang.ast.Type.Named => write_astTypeNamed(o)
        case o: org.sireum.lang.ast.Type.Fun => write_astTypeFun(o)
        case o: org.sireum.lang.ast.Type.Tuple => write_astTypeTuple(o)
      }
    }

    def write_astTypeNamed(o: org.sireum.lang.ast.Type.Named): Unit = {
      writer.writeZ(Constants._astTypeNamed)
      write_astName(o.name)
      writer.writeISZ(o.typeArgs, write_astType _)
      write_astTypedAttr(o.attr)
    }

    def write_astTypeFun(o: org.sireum.lang.ast.Type.Fun): Unit = {
      writer.writeZ(Constants._astTypeFun)
      writer.writeB(o.isPure)
      writer.writeB(o.isByName)
      writer.writeISZ(o.args, write_astType _)
      write_astType(o.ret)
      write_astTypedAttr(o.attr)
    }

    def write_astTypeTuple(o: org.sireum.lang.ast.Type.Tuple): Unit = {
      writer.writeZ(Constants._astTypeTuple)
      writer.writeISZ(o.args, write_astType _)
      write_astTypedAttr(o.attr)
    }

    def write_astPattern(o: org.sireum.lang.ast.Pattern): Unit = {
      o match {
        case o: org.sireum.lang.ast.Pattern.Literal => write_astPatternLiteral(o)
        case o: org.sireum.lang.ast.Pattern.LitInterpolate => write_astPatternLitInterpolate(o)
        case o: org.sireum.lang.ast.Pattern.Ref => write_astPatternRef(o)
        case o: org.sireum.lang.ast.Pattern.VarBinding => write_astPatternVarBinding(o)
        case o: org.sireum.lang.ast.Pattern.Wildcard => write_astPatternWildcard(o)
        case o: org.sireum.lang.ast.Pattern.SeqWildcard => write_astPatternSeqWildcard(o)
        case o: org.sireum.lang.ast.Pattern.Structure => write_astPatternStructure(o)
      }
    }

    def write_astPatternLiteral(o: org.sireum.lang.ast.Pattern.Literal): Unit = {
      writer.writeZ(Constants._astPatternLiteral)
      write_astLit(o.lit)
    }

    def write_astPatternLitInterpolate(o: org.sireum.lang.ast.Pattern.LitInterpolate): Unit = {
      writer.writeZ(Constants._astPatternLitInterpolate)
      writer.writeString(o.prefix)
      writer.writeString(o.value)
      write_astTypedAttr(o.attr)
    }

    def write_astPatternRef(o: org.sireum.lang.ast.Pattern.Ref): Unit = {
      writer.writeZ(Constants._astPatternRef)
      write_astName(o.name)
      write_astResolvedAttr(o.attr)
    }

    def write_astPatternVarBinding(o: org.sireum.lang.ast.Pattern.VarBinding): Unit = {
      writer.writeZ(Constants._astPatternVarBinding)
      write_astId(o.id)
      writer.writeOption(o.tipeOpt, write_astType _)
      write_astTypedAttr(o.attr)
    }

    def write_astPatternWildcard(o: org.sireum.lang.ast.Pattern.Wildcard): Unit = {
      writer.writeZ(Constants._astPatternWildcard)
      writer.writeOption(o.typeOpt, write_astType _)
      write_astTypedAttr(o.attr)
    }

    def write_astPatternSeqWildcard(o: org.sireum.lang.ast.Pattern.SeqWildcard): Unit = {
      writer.writeZ(Constants._astPatternSeqWildcard)
      write_astTypedAttr(o.attr)
    }

    def write_astPatternStructure(o: org.sireum.lang.ast.Pattern.Structure): Unit = {
      writer.writeZ(Constants._astPatternStructure)
      writer.writeOption(o.idOpt, write_astId _)
      writer.writeOption(o.nameOpt, write_astName _)
      writer.writeISZ(o.patterns, write_astPattern _)
      write_astResolvedAttr(o.attr)
    }

    def write_astExp(o: org.sireum.lang.ast.Exp): Unit = {
      o match {
        case o: org.sireum.lang.ast.Exp.LitB => write_astExpLitB(o)
        case o: org.sireum.lang.ast.Exp.LitC => write_astExpLitC(o)
        case o: org.sireum.lang.ast.Exp.LitZ => write_astExpLitZ(o)
        case o: org.sireum.lang.ast.Exp.LitF32 => write_astExpLitF32(o)
        case o: org.sireum.lang.ast.Exp.LitF64 => write_astExpLitF64(o)
        case o: org.sireum.lang.ast.Exp.LitR => write_astExpLitR(o)
        case o: org.sireum.lang.ast.Exp.LitString => write_astExpLitString(o)
        case o: org.sireum.lang.ast.Exp.StringInterpolate => write_astExpStringInterpolate(o)
        case o: org.sireum.lang.ast.Exp.This => write_astExpThis(o)
        case o: org.sireum.lang.ast.Exp.Super => write_astExpSuper(o)
        case o: org.sireum.lang.ast.Exp.Unary => write_astExpUnary(o)
        case o: org.sireum.lang.ast.Exp.Binary => write_astExpBinary(o)
        case o: org.sireum.lang.ast.Exp.Ident => write_astExpIdent(o)
        case o: org.sireum.lang.ast.Exp.Eta => write_astExpEta(o)
        case o: org.sireum.lang.ast.Exp.Tuple => write_astExpTuple(o)
        case o: org.sireum.lang.ast.Exp.Select => write_astExpSelect(o)
        case o: org.sireum.lang.ast.Exp.Invoke => write_astExpInvoke(o)
        case o: org.sireum.lang.ast.Exp.InvokeNamed => write_astExpInvokeNamed(o)
        case o: org.sireum.lang.ast.Exp.If => write_astExpIf(o)
        case o: org.sireum.lang.ast.Exp.Fun => write_astExpFun(o)
        case o: org.sireum.lang.ast.Exp.ForYield => write_astExpForYield(o)
        case o: org.sireum.lang.ast.Exp.Quant => write_astExpQuant(o)
      }
    }

    def write_astLit(o: org.sireum.lang.ast.Lit): Unit = {
      o match {
        case o: org.sireum.lang.ast.Exp.LitB => write_astExpLitB(o)
        case o: org.sireum.lang.ast.Exp.LitC => write_astExpLitC(o)
        case o: org.sireum.lang.ast.Exp.LitZ => write_astExpLitZ(o)
        case o: org.sireum.lang.ast.Exp.LitF32 => write_astExpLitF32(o)
        case o: org.sireum.lang.ast.Exp.LitF64 => write_astExpLitF64(o)
        case o: org.sireum.lang.ast.Exp.LitR => write_astExpLitR(o)
        case o: org.sireum.lang.ast.Exp.LitString => write_astExpLitString(o)
      }
    }

    def write_astExpLitB(o: org.sireum.lang.ast.Exp.LitB): Unit = {
      writer.writeZ(Constants._astExpLitB)
      writer.writeB(o.value)
      write_astAttr(o.attr)
    }

    def write_astExpLitC(o: org.sireum.lang.ast.Exp.LitC): Unit = {
      writer.writeZ(Constants._astExpLitC)
      writer.writeC(o.value)
      write_astAttr(o.attr)
    }

    def write_astExpLitZ(o: org.sireum.lang.ast.Exp.LitZ): Unit = {
      writer.writeZ(Constants._astExpLitZ)
      writer.writeZ(o.value)
      write_astAttr(o.attr)
    }

    def write_astExpLitF32(o: org.sireum.lang.ast.Exp.LitF32): Unit = {
      writer.writeZ(Constants._astExpLitF32)
      writer.writeF32(o.value)
      write_astAttr(o.attr)
    }

    def write_astExpLitF64(o: org.sireum.lang.ast.Exp.LitF64): Unit = {
      writer.writeZ(Constants._astExpLitF64)
      writer.writeF64(o.value)
      write_astAttr(o.attr)
    }

    def write_astExpLitR(o: org.sireum.lang.ast.Exp.LitR): Unit = {
      writer.writeZ(Constants._astExpLitR)
      writer.writeR(o.value)
      write_astAttr(o.attr)
    }

    def write_astExpLitString(o: org.sireum.lang.ast.Exp.LitString): Unit = {
      writer.writeZ(Constants._astExpLitString)
      writer.writeString(o.value)
      write_astAttr(o.attr)
    }

    def write_astExpStringInterpolate(o: org.sireum.lang.ast.Exp.StringInterpolate): Unit = {
      writer.writeZ(Constants._astExpStringInterpolate)
      writer.writeString(o.prefix)
      writer.writeISZ(o.lits, write_astExpLitString _)
      writer.writeISZ(o.args, write_astExp _)
      write_astTypedAttr(o.attr)
    }

    def write_astExpThis(o: org.sireum.lang.ast.Exp.This): Unit = {
      writer.writeZ(Constants._astExpThis)
      write_astTypedAttr(o.attr)
    }

    def write_astExpSuper(o: org.sireum.lang.ast.Exp.Super): Unit = {
      writer.writeZ(Constants._astExpSuper)
      writer.writeOption(o.idOpt, write_astId _)
      write_astTypedAttr(o.attr)
    }

    def write_astExpUnaryOpType(o: org.sireum.lang.ast.Exp.UnaryOp.Type): Unit = {
      writer.writeZ(o.ordinal)
    }

    def write_astExpUnary(o: org.sireum.lang.ast.Exp.Unary): Unit = {
      writer.writeZ(Constants._astExpUnary)
      write_astExpUnaryOpType(o.op)
      write_astExp(o.exp)
      write_astResolvedAttr(o.attr)
    }

    def write_astExpRef(o: org.sireum.lang.ast.Exp.Ref): Unit = {
      o match {
        case o: org.sireum.lang.ast.Exp.Ident => write_astExpIdent(o)
        case o: org.sireum.lang.ast.Exp.Select => write_astExpSelect(o)
      }
    }

    def write_astExpBinary(o: org.sireum.lang.ast.Exp.Binary): Unit = {
      writer.writeZ(Constants._astExpBinary)
      write_astExp(o.left)
      writer.writeString(o.op)
      write_astExp(o.right)
      write_astResolvedAttr(o.attr)
    }

    def write_astExpIdent(o: org.sireum.lang.ast.Exp.Ident): Unit = {
      writer.writeZ(Constants._astExpIdent)
      write_astId(o.id)
      write_astResolvedAttr(o.attr)
    }

    def write_astExpEta(o: org.sireum.lang.ast.Exp.Eta): Unit = {
      writer.writeZ(Constants._astExpEta)
      write_astExpRef(o.ref)
      write_astTypedAttr(o.attr)
    }

    def write_astExpTuple(o: org.sireum.lang.ast.Exp.Tuple): Unit = {
      writer.writeZ(Constants._astExpTuple)
      writer.writeISZ(o.args, write_astExp _)
      write_astTypedAttr(o.attr)
    }

    def write_astExpSelect(o: org.sireum.lang.ast.Exp.Select): Unit = {
      writer.writeZ(Constants._astExpSelect)
      writer.writeOption(o.receiverOpt, write_astExp _)
      write_astId(o.id)
      writer.writeISZ(o.targs, write_astType _)
      write_astResolvedAttr(o.attr)
    }

    def write_astExpInvoke(o: org.sireum.lang.ast.Exp.Invoke): Unit = {
      writer.writeZ(Constants._astExpInvoke)
      writer.writeOption(o.receiverOpt, write_astExp _)
      write_astId(o.id)
      writer.writeISZ(o.targs, write_astType _)
      writer.writeISZ(o.args, write_astExp _)
      write_astResolvedAttr(o.attr)
    }

    def write_astExpInvokeNamed(o: org.sireum.lang.ast.Exp.InvokeNamed): Unit = {
      writer.writeZ(Constants._astExpInvokeNamed)
      writer.writeOption(o.receiverOpt, write_astExp _)
      write_astId(o.id)
      writer.writeISZ(o.targs, write_astType _)
      writer.writeISZ(o.args, write_astNamedArg _)
      write_astResolvedAttr(o.attr)
    }

    def write_astExpIf(o: org.sireum.lang.ast.Exp.If): Unit = {
      writer.writeZ(Constants._astExpIf)
      write_astExp(o.cond)
      write_astExp(o.thenExp)
      write_astExp(o.elseExp)
      write_astTypedAttr(o.attr)
    }

    def write_astExpFunParam(o: org.sireum.lang.ast.Exp.Fun.Param): Unit = {
      writer.writeZ(Constants._astExpFunParam)
      write_astId(o.id)
      writer.writeOption(o.tipeOpt, write_astType _)
    }

    def write_astExpFun(o: org.sireum.lang.ast.Exp.Fun): Unit = {
      writer.writeZ(Constants._astExpFun)
      writer.writeISZ(o.context, writer.writeString _)
      writer.writeISZ(o.params, write_astExpFunParam _)
      write_astContract(o.contract)
      write_astAssignExp(o.exp)
      write_astTypedAttr(o.attr)
    }

    def write_astExpForYield(o: org.sireum.lang.ast.Exp.ForYield): Unit = {
      writer.writeZ(Constants._astExpForYield)
      writer.writeISZ(o.enumGens, write_astEnumGenFor _)
      write_astExp(o.exp)
      write_astTypedAttr(o.attr)
    }

    def write_astExpQuant(o: org.sireum.lang.ast.Exp.Quant): Unit = {
      writer.writeZ(Constants._astExpQuant)
      writer.writeB(o.isForall)
      writer.writeISZ(o.varFragments, write_astVarFragment _)
      write_astExp(o.exp)
      write_astAttr(o.attr)
    }

    def write_astNamedArg(o: org.sireum.lang.ast.NamedArg): Unit = {
      writer.writeZ(Constants._astNamedArg)
      write_astId(o.id)
      write_astExp(o.arg)
      writer.writeZ(o.index)
    }

    def write_astVarFragment(o: org.sireum.lang.ast.VarFragment): Unit = {
      writer.writeZ(Constants._astVarFragment)
      writer.writeISZ(o.ids, write_astId _)
      writer.writeOption(o.domainOpt, write_astDomain _)
    }

    def write_astDomain(o: org.sireum.lang.ast.Domain): Unit = {
      o match {
        case o: org.sireum.lang.ast.Domain.Type => write_astDomainType(o)
        case o: org.sireum.lang.ast.Domain.Range => write_astDomainRange(o)
      }
    }

    def write_astDomainType(o: org.sireum.lang.ast.Domain.Type): Unit = {
      writer.writeZ(Constants._astDomainType)
      write_astType(o.tipe)
      write_astTypedAttr(o.attr)
    }

    def write_astDomainRange(o: org.sireum.lang.ast.Domain.Range): Unit = {
      writer.writeZ(Constants._astDomainRange)
      write_astExp(o.lo)
      writer.writeB(o.loExact)
      write_astExp(o.hi)
      writer.writeB(o.hiExact)
      write_astTypedAttr(o.attr)
    }

    def write_astId(o: org.sireum.lang.ast.Id): Unit = {
      writer.writeZ(Constants._astId)
      writer.writeString(o.value)
      write_astAttr(o.attr)
    }

    def write_astName(o: org.sireum.lang.ast.Name): Unit = {
      writer.writeZ(Constants._astName)
      writer.writeISZ(o.ids, write_astId _)
      write_astAttr(o.attr)
    }

    def write_astBody(o: org.sireum.lang.ast.Body): Unit = {
      writer.writeZ(Constants._astBody)
      writer.writeISZ(o.stmts, write_astStmt _)
      writer.writeISZ(o.undecls, writer.writeString _)
    }

    def write_astAbstractDatatypeParam(o: org.sireum.lang.ast.AbstractDatatypeParam): Unit = {
      writer.writeZ(Constants._astAbstractDatatypeParam)
      writer.writeB(o.isHidden)
      writer.writeB(o.isVal)
      write_astId(o.id)
      write_astType(o.tipe)
    }

    def write_astMethodSig(o: org.sireum.lang.ast.MethodSig): Unit = {
      writer.writeZ(Constants._astMethodSig)
      writer.writeB(o.isPure)
      write_astId(o.id)
      writer.writeISZ(o.typeParams, write_astTypeParam _)
      writer.writeB(o.hasParams)
      writer.writeISZ(o.params, write_astParam _)
      write_astType(o.returnType)
    }

    def write_astParam(o: org.sireum.lang.ast.Param): Unit = {
      writer.writeZ(Constants._astParam)
      writer.writeB(o.isHidden)
      write_astId(o.id)
      write_astType(o.tipe)
    }

    def write_astTypeParam(o: org.sireum.lang.ast.TypeParam): Unit = {
      writer.writeZ(Constants._astTypeParam)
      write_astId(o.id)
    }

    def write_astContract(o: org.sireum.lang.ast.Contract): Unit = {
      writer.writeZ(Constants._astContract)
      writer.writeISZ(o.reads, write_astExp _)
      writer.writeISZ(o.requires, write_astContractExp _)
      writer.writeISZ(o.modifies, write_astExp _)
      writer.writeISZ(o.ensures, write_astContractExp _)
      writer.writeISZ(o.subs, write_astSubContract _)
    }

    def write_astSubContract(o: org.sireum.lang.ast.SubContract): Unit = {
      writer.writeZ(Constants._astSubContract)
      write_astId(o.id)
      writer.writeISZ(o.params, write_astId _)
      write_astContract(o.contract)
    }

    def write_astWhereDef(o: org.sireum.lang.ast.WhereDef): Unit = {
      o match {
        case o: org.sireum.lang.ast.WhereDef.Val => write_astWhereDefVal(o)
        case o: org.sireum.lang.ast.WhereDef.Def => write_astWhereDefDef(o)
      }
    }

    def write_astWhereDefVal(o: org.sireum.lang.ast.WhereDef.Val): Unit = {
      writer.writeZ(Constants._astWhereDefVal)
      write_astId(o.id)
      write_astType(o.tipe)
      write_astExp(o.exp)
    }

    def write_astWhereDefDef(o: org.sireum.lang.ast.WhereDef.Def): Unit = {
      writer.writeZ(Constants._astWhereDefDef)
      write_astId(o.id)
      writer.writeISZ(o.params, write_astParam _)
      write_astType(o.rTipe)
      writer.writeISZ(o.defs, write_astSpecDef _)
    }

    def write_astSpecDef(o: org.sireum.lang.ast.SpecDef): Unit = {
      writer.writeZ(Constants._astSpecDef)
      writer.writeOption(o.idOpt, write_astId _)
      write_astExp(o.exp)
      writer.writeB(o.isOtherwise)
      writer.writeOption(o.patternOpt, write_astPattern _)
      writer.writeOption(o.guardOpt, write_astExp _)
    }

    def write_astTyped(o: org.sireum.lang.ast.Typed): Unit = {
      o match {
        case o: org.sireum.lang.ast.Typed.Name => write_astTypedName(o)
        case o: org.sireum.lang.ast.Typed.Tuple => write_astTypedTuple(o)
        case o: org.sireum.lang.ast.Typed.Fun => write_astTypedFun(o)
        case o: org.sireum.lang.ast.Typed.TypeVar => write_astTypedTypeVar(o)
        case o: org.sireum.lang.ast.Typed.Package => write_astTypedPackage(o)
        case o: org.sireum.lang.ast.Typed.Object => write_astTypedObject(o)
        case o: org.sireum.lang.ast.Typed.Enum => write_astTypedEnum(o)
        case o: org.sireum.lang.ast.Typed.Method => write_astTypedMethod(o)
        case o: org.sireum.lang.ast.Typed.Methods => write_astTypedMethods(o)
      }
    }

    def write_astMethodModeType(o: org.sireum.lang.ast.MethodMode.Type): Unit = {
      writer.writeZ(o.ordinal)
    }

    def write_astTypedName(o: org.sireum.lang.ast.Typed.Name): Unit = {
      writer.writeZ(Constants._astTypedName)
      writer.writeISZ(o.ids, writer.writeString _)
      writer.writeISZ(o.args, write_astTyped _)
    }

    def write_astTypedTuple(o: org.sireum.lang.ast.Typed.Tuple): Unit = {
      writer.writeZ(Constants._astTypedTuple)
      writer.writeISZ(o.args, write_astTyped _)
    }

    def write_astTypedFun(o: org.sireum.lang.ast.Typed.Fun): Unit = {
      writer.writeZ(Constants._astTypedFun)
      writer.writeB(o.isPure)
      writer.writeB(o.isByName)
      writer.writeISZ(o.args, write_astTyped _)
      write_astTyped(o.ret)
    }

    def write_astTypedTypeVar(o: org.sireum.lang.ast.Typed.TypeVar): Unit = {
      writer.writeZ(Constants._astTypedTypeVar)
      writer.writeString(o.id)
    }

    def write_astTypedPackage(o: org.sireum.lang.ast.Typed.Package): Unit = {
      writer.writeZ(Constants._astTypedPackage)
      writer.writeISZ(o.name, writer.writeString _)
    }

    def write_astTypedObject(o: org.sireum.lang.ast.Typed.Object): Unit = {
      writer.writeZ(Constants._astTypedObject)
      writer.writeISZ(o.owner, writer.writeString _)
      writer.writeString(o.id)
    }

    def write_astTypedEnum(o: org.sireum.lang.ast.Typed.Enum): Unit = {
      writer.writeZ(Constants._astTypedEnum)
      writer.writeISZ(o.name, writer.writeString _)
    }

    def write_astTypedMethodSubst(o: org.sireum.lang.ast.Typed.Method.Subst): Unit = {
      writer.writeZ(Constants._astTypedMethodSubst)
      writer.writeString(o.id)
      write_astTyped(o.tipe)
    }

    def write_astTypedMethod(o: org.sireum.lang.ast.Typed.Method): Unit = {
      writer.writeZ(Constants._astTypedMethod)
      writer.writeB(o.isInObject)
      write_astMethodModeType(o.mode)
      writer.writeISZ(o.typeParams, writer.writeString _)
      writer.writeISZ(o.owner, writer.writeString _)
      writer.writeString(o.name)
      writer.writeISZ(o.paramNames, writer.writeString _)
      writer.writeISZ(o.substs, write_astTypedMethodSubst _)
      write_astTypedFun(o.tpe)
    }

    def write_astTypedMethods(o: org.sireum.lang.ast.Typed.Methods): Unit = {
      writer.writeZ(Constants._astTypedMethods)
      writer.writeISZ(o.methods, write_astTypedMethod _)
    }

    def write_astAttr(o: org.sireum.lang.ast.Attr): Unit = {
      writer.writeZ(Constants._astAttr)
      writer.writeOption(o.posOpt, writer.writePosition _)
    }

    def write_astTypedAttr(o: org.sireum.lang.ast.TypedAttr): Unit = {
      writer.writeZ(Constants._astTypedAttr)
      writer.writeOption(o.posOpt, writer.writePosition _)
      writer.writeOption(o.typedOpt, write_astTyped _)
    }

    def write_astResolvedAttr(o: org.sireum.lang.ast.ResolvedAttr): Unit = {
      writer.writeZ(Constants._astResolvedAttr)
      writer.writeOption(o.posOpt, writer.writePosition _)
      writer.writeOption(o.resOpt, write_astResolvedInfo _)
      writer.writeOption(o.typedOpt, write_astTyped _)
    }

    def write_astResolvedInfo(o: org.sireum.lang.ast.ResolvedInfo): Unit = {
      o match {
        case o: org.sireum.lang.ast.ResolvedInfo.BuiltIn => write_astResolvedInfoBuiltIn(o)
        case o: org.sireum.lang.ast.ResolvedInfo.Package => write_astResolvedInfoPackage(o)
        case o: org.sireum.lang.ast.ResolvedInfo.Enum => write_astResolvedInfoEnum(o)
        case o: org.sireum.lang.ast.ResolvedInfo.EnumElement => write_astResolvedInfoEnumElement(o)
        case o: org.sireum.lang.ast.ResolvedInfo.Object => write_astResolvedInfoObject(o)
        case o: org.sireum.lang.ast.ResolvedInfo.Var => write_astResolvedInfoVar(o)
        case o: org.sireum.lang.ast.ResolvedInfo.Method => write_astResolvedInfoMethod(o)
        case o: org.sireum.lang.ast.ResolvedInfo.Methods => write_astResolvedInfoMethods(o)
        case o: org.sireum.lang.ast.ResolvedInfo.Type => write_astResolvedInfoType(o)
        case o: org.sireum.lang.ast.ResolvedInfo.Tuple => write_astResolvedInfoTuple(o)
        case o: org.sireum.lang.ast.ResolvedInfo.LocalVar => write_astResolvedInfoLocalVar(o)
      }
    }

    def write_astResolvedInfoBuiltInKindType(o: org.sireum.lang.ast.ResolvedInfo.BuiltIn.Kind.Type): Unit = {
      writer.writeZ(o.ordinal)
    }

    def write_astResolvedInfoBuiltIn(o: org.sireum.lang.ast.ResolvedInfo.BuiltIn): Unit = {
      writer.writeZ(Constants._astResolvedInfoBuiltIn)
      write_astResolvedInfoBuiltInKindType(o.kind)
    }

    def write_astResolvedInfoPackage(o: org.sireum.lang.ast.ResolvedInfo.Package): Unit = {
      writer.writeZ(Constants._astResolvedInfoPackage)
      writer.writeISZ(o.name, writer.writeString _)
    }

    def write_astResolvedInfoEnum(o: org.sireum.lang.ast.ResolvedInfo.Enum): Unit = {
      writer.writeZ(Constants._astResolvedInfoEnum)
      writer.writeISZ(o.name, writer.writeString _)
    }

    def write_astResolvedInfoEnumElement(o: org.sireum.lang.ast.ResolvedInfo.EnumElement): Unit = {
      writer.writeZ(Constants._astResolvedInfoEnumElement)
      writer.writeISZ(o.owner, writer.writeString _)
      writer.writeString(o.name)
      writer.writeZ(o.ordinal)
    }

    def write_astResolvedInfoObject(o: org.sireum.lang.ast.ResolvedInfo.Object): Unit = {
      writer.writeZ(Constants._astResolvedInfoObject)
      writer.writeISZ(o.name, writer.writeString _)
    }

    def write_astResolvedInfoVar(o: org.sireum.lang.ast.ResolvedInfo.Var): Unit = {
      writer.writeZ(Constants._astResolvedInfoVar)
      writer.writeB(o.isInObject)
      writer.writeB(o.isSpec)
      writer.writeISZ(o.owner, writer.writeString _)
      writer.writeString(o.id)
    }

    def write_astResolvedInfoMethod(o: org.sireum.lang.ast.ResolvedInfo.Method): Unit = {
      writer.writeZ(Constants._astResolvedInfoMethod)
      writer.writeB(o.isInObject)
      write_astMethodModeType(o.mode)
      writer.writeISZ(o.typeParams, writer.writeString _)
      writer.writeISZ(o.owner, writer.writeString _)
      writer.writeString(o.name)
      writer.writeISZ(o.paramNames, writer.writeString _)
      writer.writeOption(o.tpeOpt, write_astTypedFun _)
    }

    def write_astResolvedInfoMethods(o: org.sireum.lang.ast.ResolvedInfo.Methods): Unit = {
      writer.writeZ(Constants._astResolvedInfoMethods)
      writer.writeISZ(o.methods, write_astResolvedInfoMethod _)
    }

    def write_astResolvedInfoType(o: org.sireum.lang.ast.ResolvedInfo.Type): Unit = {
      writer.writeZ(Constants._astResolvedInfoType)
      writer.writeISZ(o.name, writer.writeString _)
    }

    def write_astResolvedInfoTuple(o: org.sireum.lang.ast.ResolvedInfo.Tuple): Unit = {
      writer.writeZ(Constants._astResolvedInfoTuple)
      writer.writeZ(o.size)
      writer.writeZ(o.index)
    }

    def write_astResolvedInfoLocalVar(o: org.sireum.lang.ast.ResolvedInfo.LocalVar): Unit = {
      writer.writeZ(Constants._astResolvedInfoLocalVar)
      writer.writeISZ(o.context, writer.writeString _)
      writer.writeString(o.id)
    }

    def write_astProofStep(o: org.sireum.lang.ast.ProofStep): Unit = {
      o match {
        case o: org.sireum.lang.ast.ProofStep.Basic => write_astProofStepBasic(o)
        case o: org.sireum.lang.ast.ProofStep.SubProof => write_astProofStepSubProof(o)
      }
    }

    def write_astProofStepBasic(o: org.sireum.lang.ast.ProofStep.Basic): Unit = {
      writer.writeZ(Constants._astProofStepBasic)
      write_astExpLitZ(o.step)
      write_astExp(o.exp)
      write_astJust(o.just)
    }

    def write_astProofStepSubProof(o: org.sireum.lang.ast.ProofStep.SubProof): Unit = {
      writer.writeZ(Constants._astProofStepSubProof)
      write_astExpLitZ(o.step)
      write_astAssumeProofStep(o.assumeStep)
      writer.writeISZ(o.steps, write_astProofStep _)
    }

    def write_astAssumeProofStep(o: org.sireum.lang.ast.AssumeProofStep): Unit = {
      o match {
        case o: org.sireum.lang.ast.AssumeProofStep.Regular => write_astAssumeProofStepRegular(o)
        case o: org.sireum.lang.ast.AssumeProofStep.ForallIntroAps => write_astAssumeProofStepForallIntroAps(o)
        case o: org.sireum.lang.ast.AssumeProofStep.ExistsElimAps => write_astAssumeProofStepExistsElimAps(o)
      }
    }

    def write_astAssumeProofStepRegular(o: org.sireum.lang.ast.AssumeProofStep.Regular): Unit = {
      writer.writeZ(Constants._astAssumeProofStepRegular)
      write_astExpLitZ(o.step)
      write_astExp(o.exp)
    }

    def write_astAssumeProofStepForallIntroAps(o: org.sireum.lang.ast.AssumeProofStep.ForallIntroAps): Unit = {
      writer.writeZ(Constants._astAssumeProofStepForallIntroAps)
      write_astExpLitZ(o.step)
      writer.writeISZ(o.varFragments, write_astVarFragment _)
    }

    def write_astAssumeProofStepExistsElimAps(o: org.sireum.lang.ast.AssumeProofStep.ExistsElimAps): Unit = {
      writer.writeZ(Constants._astAssumeProofStepExistsElimAps)
      write_astExpLitZ(o.step)
      writer.writeISZ(o.varFragments, write_astVarFragment _)
      write_astExp(o.exp)
    }

    def write_astJust(o: org.sireum.lang.ast.Just): Unit = {
      o match {
        case o: org.sireum.lang.ast.Just.Premise => write_astJustPremise(o)
        case o: org.sireum.lang.ast.Just.Auto => write_astJustAuto(o)
        case o: org.sireum.lang.ast.Just.Coq => write_astJustCoq(o)
        case o: org.sireum.lang.ast.Just.Subst => write_astJustSubst(o)
        case o: org.sireum.lang.ast.Just.Invariant => write_astJustInvariant(o)
        case o: org.sireum.lang.ast.Just.Fact => write_astJustFact(o)
        case o: org.sireum.lang.ast.Just.ImplyIntro => write_astJustImplyIntro(o)
        case o: org.sireum.lang.ast.Just.ImplyElim => write_astJustImplyElim(o)
        case o: org.sireum.lang.ast.Just.NegIntro => write_astJustNegIntro(o)
        case o: org.sireum.lang.ast.Just.NegElim => write_astJustNegElim(o)
        case o: org.sireum.lang.ast.Just.BottomElim => write_astJustBottomElim(o)
        case o: org.sireum.lang.ast.Just.ForallIntro => write_astJustForallIntro(o)
        case o: org.sireum.lang.ast.Just.ForallElim => write_astJustForallElim(o)
        case o: org.sireum.lang.ast.Just.ExistsIntro => write_astJustExistsIntro(o)
        case o: org.sireum.lang.ast.Just.ExistsElim => write_astJustExistsElim(o)
        case o: org.sireum.lang.ast.Just.OrIntro => write_astJustOrIntro(o)
        case o: org.sireum.lang.ast.Just.OrElim => write_astJustOrElim(o)
        case o: org.sireum.lang.ast.Just.AndIntro => write_astJustAndIntro(o)
        case o: org.sireum.lang.ast.Just.AndElim => write_astJustAndElim(o)
        case o: org.sireum.lang.ast.Just.Pbc => write_astJustPbc(o)
      }
    }

    def write_astJustPremise(o: org.sireum.lang.ast.Just.Premise): Unit = {
      writer.writeZ(Constants._astJustPremise)
      write_astAttr(o.attr)
    }

    def write_astJustAuto(o: org.sireum.lang.ast.Just.Auto): Unit = {
      writer.writeZ(Constants._astJustAuto)
      writer.writeB(o.isAlgebra)
      writer.writeISZ(o.steps, write_astExpLitZ _)
      write_astAttr(o.attr)
    }

    def write_astJustCoq(o: org.sireum.lang.ast.Just.Coq): Unit = {
      writer.writeZ(Constants._astJustCoq)
      write_astExpLitString(o.path)
      writer.writeISZ(o.steps, write_astExpLitZ _)
      write_astAttr(o.attr)
    }

    def write_astJustSubst(o: org.sireum.lang.ast.Just.Subst): Unit = {
      writer.writeZ(Constants._astJustSubst)
      writer.writeB(o.isRight)
      write_astExpLitZ(o.eqStep)
      write_astExpLitZ(o.step)
      write_astAttr(o.attr)
    }

    def write_astJustInvariant(o: org.sireum.lang.ast.Just.Invariant): Unit = {
      writer.writeZ(Constants._astJustInvariant)
      writer.writeOption(o.nameOpt, write_astName _)
      write_astAttr(o.attr)
    }

    def write_astJustFact(o: org.sireum.lang.ast.Just.Fact): Unit = {
      writer.writeZ(Constants._astJustFact)
      write_astName(o.name)
      write_astAttr(o.attr)
    }

    def write_astJustImplyIntro(o: org.sireum.lang.ast.Just.ImplyIntro): Unit = {
      writer.writeZ(Constants._astJustImplyIntro)
      write_astExpLitZ(o.subProofStep)
      write_astAttr(o.attr)
    }

    def write_astJustImplyElim(o: org.sireum.lang.ast.Just.ImplyElim): Unit = {
      writer.writeZ(Constants._astJustImplyElim)
      write_astExpLitZ(o.implyStep)
      writer.writeISZ(o.steps, write_astExpLitZ _)
      write_astAttr(o.attr)
    }

    def write_astJustNegIntro(o: org.sireum.lang.ast.Just.NegIntro): Unit = {
      writer.writeZ(Constants._astJustNegIntro)
      write_astExpLitZ(o.subProofStep)
      write_astAttr(o.attr)
    }

    def write_astJustNegElim(o: org.sireum.lang.ast.Just.NegElim): Unit = {
      writer.writeZ(Constants._astJustNegElim)
      write_astExpLitZ(o.step)
      write_astExpLitZ(o.negStep)
      write_astAttr(o.attr)
    }

    def write_astJustBottomElim(o: org.sireum.lang.ast.Just.BottomElim): Unit = {
      writer.writeZ(Constants._astJustBottomElim)
      write_astExpLitZ(o.subProofStep)
      write_astAttr(o.attr)
    }

    def write_astJustForallIntro(o: org.sireum.lang.ast.Just.ForallIntro): Unit = {
      writer.writeZ(Constants._astJustForallIntro)
      write_astExpLitZ(o.subProofStep)
      write_astAttr(o.attr)
    }

    def write_astJustForallElim(o: org.sireum.lang.ast.Just.ForallElim): Unit = {
      writer.writeZ(Constants._astJustForallElim)
      write_astExpLitZ(o.forallStep)
      writer.writeISZ(o.args, write_astExp _)
      write_astAttr(o.attr)
    }

    def write_astJustExistsIntro(o: org.sireum.lang.ast.Just.ExistsIntro): Unit = {
      writer.writeZ(Constants._astJustExistsIntro)
      write_astExpLitZ(o.existsStep)
      writer.writeISZ(o.args, write_astExp _)
      write_astAttr(o.attr)
    }

    def write_astJustExistsElim(o: org.sireum.lang.ast.Just.ExistsElim): Unit = {
      writer.writeZ(Constants._astJustExistsElim)
      write_astExpLitZ(o.existsStep)
      write_astExpLitZ(o.subProofStep)
      write_astAttr(o.attr)
    }

    def write_astJustOrIntro(o: org.sireum.lang.ast.Just.OrIntro): Unit = {
      writer.writeZ(Constants._astJustOrIntro)
      writer.writeB(o.is1)
      write_astExpLitZ(o.step)
      write_astAttr(o.attr)
    }

    def write_astJustOrElim(o: org.sireum.lang.ast.Just.OrElim): Unit = {
      writer.writeZ(Constants._astJustOrElim)
      write_astExpLitZ(o.orStep)
      writer.writeISZ(o.subProofSteps, write_astExpLitZ _)
      write_astAttr(o.attr)
    }

    def write_astJustAndIntro(o: org.sireum.lang.ast.Just.AndIntro): Unit = {
      writer.writeZ(Constants._astJustAndIntro)
      writer.writeISZ(o.steps, write_astExpLitZ _)
      write_astAttr(o.attr)
    }

    def write_astJustAndElim(o: org.sireum.lang.ast.Just.AndElim): Unit = {
      writer.writeZ(Constants._astJustAndElim)
      writer.writeB(o.is1)
      write_astExpLitZ(o.andStep)
      write_astAttr(o.attr)
    }

    def write_astJustPbc(o: org.sireum.lang.ast.Just.Pbc): Unit = {
      writer.writeZ(Constants._astJustPbc)
      write_astExpLitZ(o.subProofStep)
      write_astAttr(o.attr)
    }

    def write_astTruthTableRow(o: org.sireum.lang.ast.TruthTable.Row): Unit = {
      writer.writeZ(Constants._astTruthTableRow)
      write_astTruthTableAssignment(o.assignment)
      writer.writePosition(o.separator)
      write_astTruthTableAssignment(o.values)
    }

    def write_astTruthTableAssignment(o: org.sireum.lang.ast.TruthTable.Assignment): Unit = {
      writer.writeZ(Constants._astTruthTableAssignment)
      writer.writeISZ(o.values, write_astExpLitB _)
      write_astAttr(o.attr)
    }

    def write_astTruthTableConclusion(o: org.sireum.lang.ast.TruthTable.Conclusion): Unit = {
      o match {
        case o: org.sireum.lang.ast.TruthTable.Conclusion.Validity => write_astTruthTableConclusionValidity(o)
        case o: org.sireum.lang.ast.TruthTable.Conclusion.Tautology => write_astTruthTableConclusionTautology(o)
        case o: org.sireum.lang.ast.TruthTable.Conclusion.Contradictory => write_astTruthTableConclusionContradictory(o)
        case o: org.sireum.lang.ast.TruthTable.Conclusion.Contingent => write_astTruthTableConclusionContingent(o)
      }
    }

    def write_astTruthTableConclusionValidity(o: org.sireum.lang.ast.TruthTable.Conclusion.Validity): Unit = {
      writer.writeZ(Constants._astTruthTableConclusionValidity)
      writer.writeB(o.isValid)
      writer.writeISZ(o.assignments, write_astTruthTableAssignment _)
      write_astAttr(o.attr)
    }

    def write_astTruthTableConclusionTautology(o: org.sireum.lang.ast.TruthTable.Conclusion.Tautology): Unit = {
      writer.writeZ(Constants._astTruthTableConclusionTautology)
      write_astAttr(o.attr)
    }

    def write_astTruthTableConclusionContradictory(o: org.sireum.lang.ast.TruthTable.Conclusion.Contradictory): Unit = {
      writer.writeZ(Constants._astTruthTableConclusionContradictory)
      write_astAttr(o.attr)
    }

    def write_astTruthTableConclusionContingent(o: org.sireum.lang.ast.TruthTable.Conclusion.Contingent): Unit = {
      writer.writeZ(Constants._astTruthTableConclusionContingent)
      writer.writeISZ(o.trueAssignments, write_astTruthTableAssignment _)
      writer.writeISZ(o.falseAssignments, write_astTruthTableAssignment _)
      write_astAttr(o.attr)
    }

    def result: ISZ[U8] = {
      return writer.result
    }

  }

  object Reader {

    @record class Default(val reader: MessagePack.Reader.Impl) extends Reader {
      def errorOpt: Option[MessagePack.ErrorMsg] = {
        return reader.errorOpt
      }
    }

  }

  @msig trait Reader {

    def reader: MessagePack.Reader

    def read_symbolScope(): org.sireum.lang.symbol.Scope = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._symbolScopeLocal => val r = read_symbolScopeLocalT(T); return r
        case Constants._symbolScopeGlobal => val r = read_symbolScopeGlobalT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.symbol.Scope.")
          val r = read_symbolScopeGlobalT(T)
          return r
      }
    }

    def read_symbolScopeLocal(): org.sireum.lang.symbol.Scope.Local = {
      val r = read_symbolScopeLocalT(F)
      return r
    }

    def read_symbolScopeLocalT(typeParsed: B): org.sireum.lang.symbol.Scope.Local = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolScopeLocal)
      }
      val nameMap = reader.readHashMap(reader.readString _, read_symbolInfo _)
      val typeMap = reader.readHashMap(reader.readString _, read_symbolTypeInfo _)
      val localThisOpt = reader.readOption(read_astTyped _)
      val methodReturnOpt = reader.readOption(read_astTyped _)
      val outerOpt = reader.readOption(read_symbolScope _)
      return org.sireum.lang.symbol.Scope.Local(nameMap, typeMap, localThisOpt, methodReturnOpt, outerOpt)
    }

    def read_symbolScopeGlobal(): org.sireum.lang.symbol.Scope.Global = {
      val r = read_symbolScopeGlobalT(F)
      return r
    }

    def read_symbolScopeGlobalT(typeParsed: B): org.sireum.lang.symbol.Scope.Global = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolScopeGlobal)
      }
      val packageName = reader.readISZ(reader.readString _)
      val imports = reader.readISZ(read_astStmtImport _)
      val enclosingName = reader.readISZ(reader.readString _)
      return org.sireum.lang.symbol.Scope.Global(packageName, imports, enclosingName)
    }

    def read_symbolInfo(): org.sireum.lang.symbol.Info = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._symbolInfoPackage => val r = read_symbolInfoPackageT(T); return r
        case Constants._symbolInfoVar => val r = read_symbolInfoVarT(T); return r
        case Constants._symbolInfoSpecVar => val r = read_symbolInfoSpecVarT(T); return r
        case Constants._symbolInfoMethod => val r = read_symbolInfoMethodT(T); return r
        case Constants._symbolInfoSpecMethod => val r = read_symbolInfoSpecMethodT(T); return r
        case Constants._symbolInfoObject => val r = read_symbolInfoObjectT(T); return r
        case Constants._symbolInfoExtMethod => val r = read_symbolInfoExtMethodT(T); return r
        case Constants._symbolInfoEnum => val r = read_symbolInfoEnumT(T); return r
        case Constants._symbolInfoEnumElement => val r = read_symbolInfoEnumElementT(T); return r
        case Constants._symbolInfoLocalVar => val r = read_symbolInfoLocalVarT(T); return r
        case Constants._symbolInfoQuantVar => val r = read_symbolInfoQuantVarT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.symbol.Info.")
          val r = read_symbolInfoQuantVarT(T)
          return r
      }
    }

    def read_symbolInfoPackage(): org.sireum.lang.symbol.Info.Package = {
      val r = read_symbolInfoPackageT(F)
      return r
    }

    def read_symbolInfoPackageT(typeParsed: B): org.sireum.lang.symbol.Info.Package = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolInfoPackage)
      }
      val name = reader.readISZ(reader.readString _)
      val typedOpt = reader.readOption(read_astTyped _)
      val resOpt = reader.readOption(read_astResolvedInfo _)
      return org.sireum.lang.symbol.Info.Package(name, typedOpt, resOpt)
    }

    def read_symbolInfoVar(): org.sireum.lang.symbol.Info.Var = {
      val r = read_symbolInfoVarT(F)
      return r
    }

    def read_symbolInfoVarT(typeParsed: B): org.sireum.lang.symbol.Info.Var = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolInfoVar)
      }
      val owner = reader.readISZ(reader.readString _)
      val isInObject = reader.readB()
      val scope = read_symbolScope()
      val ast = read_astStmtVar()
      val typedOpt = reader.readOption(read_astTyped _)
      val resOpt = reader.readOption(read_astResolvedInfo _)
      return org.sireum.lang.symbol.Info.Var(owner, isInObject, scope, ast, typedOpt, resOpt)
    }

    def read_symbolInfoSpecVar(): org.sireum.lang.symbol.Info.SpecVar = {
      val r = read_symbolInfoSpecVarT(F)
      return r
    }

    def read_symbolInfoSpecVarT(typeParsed: B): org.sireum.lang.symbol.Info.SpecVar = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolInfoSpecVar)
      }
      val owner = reader.readISZ(reader.readString _)
      val isInObject = reader.readB()
      val scope = read_symbolScope()
      val ast = read_astStmtSpecVar()
      val typedOpt = reader.readOption(read_astTyped _)
      val resOpt = reader.readOption(read_astResolvedInfo _)
      return org.sireum.lang.symbol.Info.SpecVar(owner, isInObject, scope, ast, typedOpt, resOpt)
    }

    def read_symbolInfoMethod(): org.sireum.lang.symbol.Info.Method = {
      val r = read_symbolInfoMethodT(F)
      return r
    }

    def read_symbolInfoMethodT(typeParsed: B): org.sireum.lang.symbol.Info.Method = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolInfoMethod)
      }
      val owner = reader.readISZ(reader.readString _)
      val isInObject = reader.readB()
      val scope = read_symbolScope()
      val hasBody = reader.readB()
      val ast = read_astStmtMethod()
      val typedOpt = reader.readOption(read_astTyped _)
      val resOpt = reader.readOption(read_astResolvedInfo _)
      return org.sireum.lang.symbol.Info.Method(owner, isInObject, scope, hasBody, ast, typedOpt, resOpt)
    }

    def read_symbolInfoSpecMethod(): org.sireum.lang.symbol.Info.SpecMethod = {
      val r = read_symbolInfoSpecMethodT(F)
      return r
    }

    def read_symbolInfoSpecMethodT(typeParsed: B): org.sireum.lang.symbol.Info.SpecMethod = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolInfoSpecMethod)
      }
      val owner = reader.readISZ(reader.readString _)
      val isInObject = reader.readB()
      val scope = read_symbolScope()
      val ast = read_astStmtSpecMethod()
      val typedOpt = reader.readOption(read_astTyped _)
      val resOpt = reader.readOption(read_astResolvedInfo _)
      return org.sireum.lang.symbol.Info.SpecMethod(owner, isInObject, scope, ast, typedOpt, resOpt)
    }

    def read_symbolInfoObject(): org.sireum.lang.symbol.Info.Object = {
      val r = read_symbolInfoObjectT(F)
      return r
    }

    def read_symbolInfoObjectT(typeParsed: B): org.sireum.lang.symbol.Info.Object = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolInfoObject)
      }
      val owner = reader.readISZ(reader.readString _)
      val isSynthetic = reader.readB()
      val scope = read_symbolScopeGlobal()
      val outlined = reader.readB()
      val typeChecked = reader.readB()
      val ast = read_astStmtObject()
      val typedOpt = reader.readOption(read_astTyped _)
      val resOpt = reader.readOption(read_astResolvedInfo _)
      return org.sireum.lang.symbol.Info.Object(owner, isSynthetic, scope, outlined, typeChecked, ast, typedOpt, resOpt)
    }

    def read_symbolInfoExtMethod(): org.sireum.lang.symbol.Info.ExtMethod = {
      val r = read_symbolInfoExtMethodT(F)
      return r
    }

    def read_symbolInfoExtMethodT(typeParsed: B): org.sireum.lang.symbol.Info.ExtMethod = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolInfoExtMethod)
      }
      val owner = reader.readISZ(reader.readString _)
      val scope = read_symbolScopeGlobal()
      val ast = read_astStmtExtMethod()
      val typedOpt = reader.readOption(read_astTyped _)
      val resOpt = reader.readOption(read_astResolvedInfo _)
      return org.sireum.lang.symbol.Info.ExtMethod(owner, scope, ast, typedOpt, resOpt)
    }

    def read_symbolInfoEnum(): org.sireum.lang.symbol.Info.Enum = {
      val r = read_symbolInfoEnumT(F)
      return r
    }

    def read_symbolInfoEnumT(typeParsed: B): org.sireum.lang.symbol.Info.Enum = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolInfoEnum)
      }
      val name = reader.readISZ(reader.readString _)
      val elements = reader.readMap(reader.readString _, read_astResolvedInfo _)
      val typedOpt = reader.readOption(read_astTyped _)
      val resOpt = reader.readOption(read_astResolvedInfo _)
      val elementTypedOpt = reader.readOption(read_astTyped _)
      val posOpt = reader.readOption(reader.readPosition _)
      return org.sireum.lang.symbol.Info.Enum(name, elements, typedOpt, resOpt, elementTypedOpt, posOpt)
    }

    def read_symbolInfoEnumElement(): org.sireum.lang.symbol.Info.EnumElement = {
      val r = read_symbolInfoEnumElementT(F)
      return r
    }

    def read_symbolInfoEnumElementT(typeParsed: B): org.sireum.lang.symbol.Info.EnumElement = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolInfoEnumElement)
      }
      val owner = reader.readISZ(reader.readString _)
      val id = reader.readString()
      val typedOpt = reader.readOption(read_astTyped _)
      val resOpt = reader.readOption(read_astResolvedInfo _)
      val posOpt = reader.readOption(reader.readPosition _)
      return org.sireum.lang.symbol.Info.EnumElement(owner, id, typedOpt, resOpt, posOpt)
    }

    def read_symbolInfoLocalVar(): org.sireum.lang.symbol.Info.LocalVar = {
      val r = read_symbolInfoLocalVarT(F)
      return r
    }

    def read_symbolInfoLocalVarT(typeParsed: B): org.sireum.lang.symbol.Info.LocalVar = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolInfoLocalVar)
      }
      val name = reader.readISZ(reader.readString _)
      val isVal = reader.readB()
      val ast = read_astId()
      val typedOpt = reader.readOption(read_astTyped _)
      val resOpt = reader.readOption(read_astResolvedInfo _)
      return org.sireum.lang.symbol.Info.LocalVar(name, isVal, ast, typedOpt, resOpt)
    }

    def read_symbolInfoQuantVar(): org.sireum.lang.symbol.Info.QuantVar = {
      val r = read_symbolInfoQuantVarT(F)
      return r
    }

    def read_symbolInfoQuantVarT(typeParsed: B): org.sireum.lang.symbol.Info.QuantVar = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolInfoQuantVar)
      }
      val name = reader.readISZ(reader.readString _)
      val ast = read_astId()
      val typedOpt = reader.readOption(read_astTyped _)
      val resOpt = reader.readOption(read_astResolvedInfo _)
      return org.sireum.lang.symbol.Info.QuantVar(name, ast, typedOpt, resOpt)
    }

    def read_symbolTypeInfo(): org.sireum.lang.symbol.TypeInfo = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._symbolTypeInfoSubZ => val r = read_symbolTypeInfoSubZT(T); return r
        case Constants._symbolTypeInfoEnum => val r = read_symbolTypeInfoEnumT(T); return r
        case Constants._symbolTypeInfoSig => val r = read_symbolTypeInfoSigT(T); return r
        case Constants._symbolTypeInfoAbstractDatatype => val r = read_symbolTypeInfoAbstractDatatypeT(T); return r
        case Constants._symbolTypeInfoTypeAlias => val r = read_symbolTypeInfoTypeAliasT(T); return r
        case Constants._symbolTypeInfoTypeVar => val r = read_symbolTypeInfoTypeVarT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.symbol.TypeInfo.")
          val r = read_symbolTypeInfoTypeVarT(T)
          return r
      }
    }

    def read_symbolTypeInfoSubZ(): org.sireum.lang.symbol.TypeInfo.SubZ = {
      val r = read_symbolTypeInfoSubZT(F)
      return r
    }

    def read_symbolTypeInfoSubZT(typeParsed: B): org.sireum.lang.symbol.TypeInfo.SubZ = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolTypeInfoSubZ)
      }
      val owner = reader.readISZ(reader.readString _)
      val ast = read_astStmtSubZ()
      return org.sireum.lang.symbol.TypeInfo.SubZ(owner, ast)
    }

    def read_symbolTypeInfoEnum(): org.sireum.lang.symbol.TypeInfo.Enum = {
      val r = read_symbolTypeInfoEnumT(F)
      return r
    }

    def read_symbolTypeInfoEnumT(typeParsed: B): org.sireum.lang.symbol.TypeInfo.Enum = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolTypeInfoEnum)
      }
      val owner = reader.readISZ(reader.readString _)
      val elements = reader.readMap(reader.readString _, read_astResolvedInfo _)
      val posOpt = reader.readOption(reader.readPosition _)
      return org.sireum.lang.symbol.TypeInfo.Enum(owner, elements, posOpt)
    }

    def read_symbolTypeInfoSig(): org.sireum.lang.symbol.TypeInfo.Sig = {
      val r = read_symbolTypeInfoSigT(F)
      return r
    }

    def read_symbolTypeInfoSigT(typeParsed: B): org.sireum.lang.symbol.TypeInfo.Sig = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolTypeInfoSig)
      }
      val owner = reader.readISZ(reader.readString _)
      val outlined = reader.readB()
      val typeChecked = reader.readB()
      val tpe = read_astTypedName()
      val ancestors = reader.readISZ(read_astTypedName _)
      val specVars = reader.readHashMap(reader.readString _, read_symbolInfoSpecVar _)
      val specMethods = reader.readHashMap(reader.readString _, read_symbolInfoSpecMethod _)
      val methods = reader.readHashMap(reader.readString _, read_symbolInfoMethod _)
      val scope = read_symbolScopeGlobal()
      val ast = read_astStmtSig()
      return org.sireum.lang.symbol.TypeInfo.Sig(owner, outlined, typeChecked, tpe, ancestors, specVars, specMethods, methods, scope, ast)
    }

    def read_symbolTypeInfoAbstractDatatype(): org.sireum.lang.symbol.TypeInfo.AbstractDatatype = {
      val r = read_symbolTypeInfoAbstractDatatypeT(F)
      return r
    }

    def read_symbolTypeInfoAbstractDatatypeT(typeParsed: B): org.sireum.lang.symbol.TypeInfo.AbstractDatatype = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolTypeInfoAbstractDatatype)
      }
      val owner = reader.readISZ(reader.readString _)
      val outlined = reader.readB()
      val typeChecked = reader.readB()
      val tpe = read_astTypedName()
      val constructorTypeOpt = reader.readOption(read_astTyped _)
      val constructorResOpt = reader.readOption(read_astResolvedInfo _)
      val extractorTypeMap = reader.readMap(reader.readString _, read_astTyped _)
      val extractorResOpt = reader.readOption(read_astResolvedInfo _)
      val ancestors = reader.readISZ(read_astTypedName _)
      val specVars = reader.readHashMap(reader.readString _, read_symbolInfoSpecVar _)
      val vars = reader.readHashMap(reader.readString _, read_symbolInfoVar _)
      val specMethods = reader.readHashMap(reader.readString _, read_symbolInfoSpecMethod _)
      val methods = reader.readHashMap(reader.readString _, read_symbolInfoMethod _)
      val scope = read_symbolScopeGlobal()
      val ast = read_astStmtAbstractDatatype()
      return org.sireum.lang.symbol.TypeInfo.AbstractDatatype(owner, outlined, typeChecked, tpe, constructorTypeOpt, constructorResOpt, extractorTypeMap, extractorResOpt, ancestors, specVars, vars, specMethods, methods, scope, ast)
    }

    def read_symbolTypeInfoTypeAlias(): org.sireum.lang.symbol.TypeInfo.TypeAlias = {
      val r = read_symbolTypeInfoTypeAliasT(F)
      return r
    }

    def read_symbolTypeInfoTypeAliasT(typeParsed: B): org.sireum.lang.symbol.TypeInfo.TypeAlias = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolTypeInfoTypeAlias)
      }
      val name = reader.readISZ(reader.readString _)
      val scope = read_symbolScopeGlobal()
      val ast = read_astStmtTypeAlias()
      return org.sireum.lang.symbol.TypeInfo.TypeAlias(name, scope, ast)
    }

    def read_symbolTypeInfoTypeVar(): org.sireum.lang.symbol.TypeInfo.TypeVar = {
      val r = read_symbolTypeInfoTypeVarT(F)
      return r
    }

    def read_symbolTypeInfoTypeVarT(typeParsed: B): org.sireum.lang.symbol.TypeInfo.TypeVar = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolTypeInfoTypeVar)
      }
      val id = reader.readString()
      val ast = read_astTypeParam()
      return org.sireum.lang.symbol.TypeInfo.TypeVar(id, ast)
    }

    def read_symbolTypeInfoMembers(): org.sireum.lang.symbol.TypeInfo.Members = {
      val r = read_symbolTypeInfoMembersT(F)
      return r
    }

    def read_symbolTypeInfoMembersT(typeParsed: B): org.sireum.lang.symbol.TypeInfo.Members = {
      if (!typeParsed) {
        reader.expectZ(Constants._symbolTypeInfoMembers)
      }
      val specVars = reader.readHashMap(reader.readString _, read_symbolInfoSpecVar _)
      val vars = reader.readHashMap(reader.readString _, read_symbolInfoVar _)
      val specMethods = reader.readHashMap(reader.readString _, read_symbolInfoSpecMethod _)
      val methods = reader.readHashMap(reader.readString _, read_symbolInfoMethod _)
      return org.sireum.lang.symbol.TypeInfo.Members(specVars, vars, specMethods, methods)
    }

    def read_astTopUnit(): org.sireum.lang.ast.TopUnit = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._astTopUnitProgram => val r = read_astTopUnitProgramT(T); return r
        case Constants._astTopUnitSequentUnit => val r = read_astTopUnitSequentUnitT(T); return r
        case Constants._astTopUnitTruthTableUnit => val r = read_astTopUnitTruthTableUnitT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.ast.TopUnit.")
          val r = read_astTopUnitTruthTableUnitT(T)
          return r
      }
    }

    def read_astTopUnitProgram(): org.sireum.lang.ast.TopUnit.Program = {
      val r = read_astTopUnitProgramT(F)
      return r
    }

    def read_astTopUnitProgramT(typeParsed: B): org.sireum.lang.ast.TopUnit.Program = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTopUnitProgram)
      }
      val fileUriOpt = reader.readOption(reader.readString _)
      val packageName = read_astName()
      val body = read_astBody()
      return org.sireum.lang.ast.TopUnit.Program(fileUriOpt, packageName, body)
    }

    def read_astTopUnitSequentUnit(): org.sireum.lang.ast.TopUnit.SequentUnit = {
      val r = read_astTopUnitSequentUnitT(F)
      return r
    }

    def read_astTopUnitSequentUnitT(typeParsed: B): org.sireum.lang.ast.TopUnit.SequentUnit = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTopUnitSequentUnit)
      }
      val fileUriOpt = reader.readOption(reader.readString _)
      val sequent = read_astLClauseSequent()
      return org.sireum.lang.ast.TopUnit.SequentUnit(fileUriOpt, sequent)
    }

    def read_astTopUnitTruthTableUnit(): org.sireum.lang.ast.TopUnit.TruthTableUnit = {
      val r = read_astTopUnitTruthTableUnitT(F)
      return r
    }

    def read_astTopUnitTruthTableUnitT(typeParsed: B): org.sireum.lang.ast.TopUnit.TruthTableUnit = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTopUnitTruthTableUnit)
      }
      val fileUriOpt = reader.readOption(reader.readString _)
      val stars = reader.readISZ(reader.readPosition _)
      val vars = reader.readISZ(read_astId _)
      val separator = reader.readPosition()
      val isSequent = reader.readB()
      val sequent = read_astLClauseSequent()
      val rows = reader.readISZ(read_astTruthTableRow _)
      val conclusionOpt = reader.readOption(read_astTruthTableConclusion _)
      return org.sireum.lang.ast.TopUnit.TruthTableUnit(fileUriOpt, stars, vars, separator, isSequent, sequent, rows, conclusionOpt)
    }

    def read_astStmt(): org.sireum.lang.ast.Stmt = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._astStmtImport => val r = read_astStmtImportT(T); return r
        case Constants._astStmtVar => val r = read_astStmtVarT(T); return r
        case Constants._astStmtVarPattern => val r = read_astStmtVarPatternT(T); return r
        case Constants._astStmtSpecVar => val r = read_astStmtSpecVarT(T); return r
        case Constants._astStmtMethod => val r = read_astStmtMethodT(T); return r
        case Constants._astStmtExtMethod => val r = read_astStmtExtMethodT(T); return r
        case Constants._astStmtSpecMethod => val r = read_astStmtSpecMethodT(T); return r
        case Constants._astStmtEnum => val r = read_astStmtEnumT(T); return r
        case Constants._astStmtSubZ => val r = read_astStmtSubZT(T); return r
        case Constants._astStmtObject => val r = read_astStmtObjectT(T); return r
        case Constants._astStmtSig => val r = read_astStmtSigT(T); return r
        case Constants._astStmtAbstractDatatype => val r = read_astStmtAbstractDatatypeT(T); return r
        case Constants._astStmtTypeAlias => val r = read_astStmtTypeAliasT(T); return r
        case Constants._astStmtAssign => val r = read_astStmtAssignT(T); return r
        case Constants._astStmtBlock => val r = read_astStmtBlockT(T); return r
        case Constants._astStmtIf => val r = read_astStmtIfT(T); return r
        case Constants._astStmtMatch => val r = read_astStmtMatchT(T); return r
        case Constants._astStmtWhile => val r = read_astStmtWhileT(T); return r
        case Constants._astStmtDoWhile => val r = read_astStmtDoWhileT(T); return r
        case Constants._astStmtFor => val r = read_astStmtForT(T); return r
        case Constants._astStmtReturn => val r = read_astStmtReturnT(T); return r
        case Constants._astStmtLStmt => val r = read_astStmtLStmtT(T); return r
        case Constants._astStmtExpr => val r = read_astStmtExprT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.ast.Stmt.")
          val r = read_astStmtExprT(T)
          return r
      }
    }

    def read_astStmtImport(): org.sireum.lang.ast.Stmt.Import = {
      val r = read_astStmtImportT(F)
      return r
    }

    def read_astStmtImportT(typeParsed: B): org.sireum.lang.ast.Stmt.Import = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtImport)
      }
      val importers = reader.readISZ(read_astStmtImportImporter _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.Import(importers, attr)
    }

    def read_astStmtImportImporter(): org.sireum.lang.ast.Stmt.Import.Importer = {
      val r = read_astStmtImportImporterT(F)
      return r
    }

    def read_astStmtImportImporterT(typeParsed: B): org.sireum.lang.ast.Stmt.Import.Importer = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtImportImporter)
      }
      val name = read_astName()
      val selectorOpt = reader.readOption(read_astStmtImportSelector _)
      return org.sireum.lang.ast.Stmt.Import.Importer(name, selectorOpt)
    }

    def read_astStmtImportSelector(): org.sireum.lang.ast.Stmt.Import.Selector = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._astStmtImportMultiSelector => val r = read_astStmtImportMultiSelectorT(T); return r
        case Constants._astStmtImportWildcardSelector => val r = read_astStmtImportWildcardSelectorT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.ast.Stmt.Import.Selector.")
          val r = read_astStmtImportWildcardSelectorT(T)
          return r
      }
    }

    def read_astStmtImportMultiSelector(): org.sireum.lang.ast.Stmt.Import.MultiSelector = {
      val r = read_astStmtImportMultiSelectorT(F)
      return r
    }

    def read_astStmtImportMultiSelectorT(typeParsed: B): org.sireum.lang.ast.Stmt.Import.MultiSelector = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtImportMultiSelector)
      }
      val selectors = reader.readISZ(read_astStmtImportNamedSelector _)
      return org.sireum.lang.ast.Stmt.Import.MultiSelector(selectors)
    }

    def read_astStmtImportWildcardSelector(): org.sireum.lang.ast.Stmt.Import.WildcardSelector = {
      val r = read_astStmtImportWildcardSelectorT(F)
      return r
    }

    def read_astStmtImportWildcardSelectorT(typeParsed: B): org.sireum.lang.ast.Stmt.Import.WildcardSelector = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtImportWildcardSelector)
      }
      return org.sireum.lang.ast.Stmt.Import.WildcardSelector()
    }

    def read_astStmtImportNamedSelector(): org.sireum.lang.ast.Stmt.Import.NamedSelector = {
      val r = read_astStmtImportNamedSelectorT(F)
      return r
    }

    def read_astStmtImportNamedSelectorT(typeParsed: B): org.sireum.lang.ast.Stmt.Import.NamedSelector = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtImportNamedSelector)
      }
      val from = read_astId()
      val to = read_astId()
      return org.sireum.lang.ast.Stmt.Import.NamedSelector(from, to)
    }

    def read_astStmtVar(): org.sireum.lang.ast.Stmt.Var = {
      val r = read_astStmtVarT(F)
      return r
    }

    def read_astStmtVarT(typeParsed: B): org.sireum.lang.ast.Stmt.Var = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtVar)
      }
      val isVal = reader.readB()
      val id = read_astId()
      val tipeOpt = reader.readOption(read_astType _)
      val initOpt = reader.readOption(read_astAssignExp _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.Var(isVal, id, tipeOpt, initOpt, attr)
    }

    def read_astStmtVarPattern(): org.sireum.lang.ast.Stmt.VarPattern = {
      val r = read_astStmtVarPatternT(F)
      return r
    }

    def read_astStmtVarPatternT(typeParsed: B): org.sireum.lang.ast.Stmt.VarPattern = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtVarPattern)
      }
      val isVal = reader.readB()
      val pattern = read_astPattern()
      val tipeOpt = reader.readOption(read_astType _)
      val init = read_astAssignExp()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.VarPattern(isVal, pattern, tipeOpt, init, attr)
    }

    def read_astStmtSpecVar(): org.sireum.lang.ast.Stmt.SpecVar = {
      val r = read_astStmtSpecVarT(F)
      return r
    }

    def read_astStmtSpecVarT(typeParsed: B): org.sireum.lang.ast.Stmt.SpecVar = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtSpecVar)
      }
      val isVal = reader.readB()
      val id = read_astId()
      val tipe = read_astType()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.SpecVar(isVal, id, tipe, attr)
    }

    def read_astStmtMethod(): org.sireum.lang.ast.Stmt.Method = {
      val r = read_astStmtMethodT(F)
      return r
    }

    def read_astStmtMethodT(typeParsed: B): org.sireum.lang.ast.Stmt.Method = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtMethod)
      }
      val purity = read_astPurityType()
      val hasOverride = reader.readB()
      val isHelper = reader.readB()
      val sig = read_astMethodSig()
      val contract = read_astContract()
      val bodyOpt = reader.readOption(read_astBody _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.Method(purity, hasOverride, isHelper, sig, contract, bodyOpt, attr)
    }

    def read_astStmtExtMethod(): org.sireum.lang.ast.Stmt.ExtMethod = {
      val r = read_astStmtExtMethodT(F)
      return r
    }

    def read_astStmtExtMethodT(typeParsed: B): org.sireum.lang.ast.Stmt.ExtMethod = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtExtMethod)
      }
      val isPure = reader.readB()
      val sig = read_astMethodSig()
      val contract = read_astContract()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.ExtMethod(isPure, sig, contract, attr)
    }

    def read_astStmtSpecMethod(): org.sireum.lang.ast.Stmt.SpecMethod = {
      val r = read_astStmtSpecMethodT(F)
      return r
    }

    def read_astStmtSpecMethodT(typeParsed: B): org.sireum.lang.ast.Stmt.SpecMethod = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtSpecMethod)
      }
      val sig = read_astMethodSig()
      val defs = reader.readISZ(read_astSpecDef _)
      val where = reader.readISZ(read_astWhereDef _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.SpecMethod(sig, defs, where, attr)
    }

    def read_astStmtEnum(): org.sireum.lang.ast.Stmt.Enum = {
      val r = read_astStmtEnumT(F)
      return r
    }

    def read_astStmtEnumT(typeParsed: B): org.sireum.lang.ast.Stmt.Enum = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtEnum)
      }
      val id = read_astId()
      val elements = reader.readISZ(read_astId _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.Enum(id, elements, attr)
    }

    def read_astStmtSubZ(): org.sireum.lang.ast.Stmt.SubZ = {
      val r = read_astStmtSubZT(F)
      return r
    }

    def read_astStmtSubZT(typeParsed: B): org.sireum.lang.ast.Stmt.SubZ = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtSubZ)
      }
      val id = read_astId()
      val isSigned = reader.readB()
      val isBitVector = reader.readB()
      val isWrapped = reader.readB()
      val hasMin = reader.readB()
      val hasMax = reader.readB()
      val bitWidth = reader.readZ()
      val min = reader.readZ()
      val max = reader.readZ()
      val index = reader.readZ()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.SubZ(id, isSigned, isBitVector, isWrapped, hasMin, hasMax, bitWidth, min, max, index, attr)
    }

    def read_astStmtObject(): org.sireum.lang.ast.Stmt.Object = {
      val r = read_astStmtObjectT(F)
      return r
    }

    def read_astStmtObjectT(typeParsed: B): org.sireum.lang.ast.Stmt.Object = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtObject)
      }
      val isExt = reader.readB()
      val id = read_astId()
      val parents = reader.readISZ(read_astType _)
      val stmts = reader.readISZ(read_astStmt _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.Object(isExt, id, parents, stmts, attr)
    }

    def read_astStmtSig(): org.sireum.lang.ast.Stmt.Sig = {
      val r = read_astStmtSigT(F)
      return r
    }

    def read_astStmtSigT(typeParsed: B): org.sireum.lang.ast.Stmt.Sig = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtSig)
      }
      val isImmutable = reader.readB()
      val isExt = reader.readB()
      val id = read_astId()
      val typeParams = reader.readISZ(read_astTypeParam _)
      val parents = reader.readISZ(read_astTypeNamed _)
      val stmts = reader.readISZ(read_astStmt _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.Sig(isImmutable, isExt, id, typeParams, parents, stmts, attr)
    }

    def read_astStmtAbstractDatatype(): org.sireum.lang.ast.Stmt.AbstractDatatype = {
      val r = read_astStmtAbstractDatatypeT(F)
      return r
    }

    def read_astStmtAbstractDatatypeT(typeParsed: B): org.sireum.lang.ast.Stmt.AbstractDatatype = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtAbstractDatatype)
      }
      val isRoot = reader.readB()
      val isDatatype = reader.readB()
      val id = read_astId()
      val typeParams = reader.readISZ(read_astTypeParam _)
      val params = reader.readISZ(read_astAbstractDatatypeParam _)
      val parents = reader.readISZ(read_astTypeNamed _)
      val stmts = reader.readISZ(read_astStmt _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.AbstractDatatype(isRoot, isDatatype, id, typeParams, params, parents, stmts, attr)
    }

    def read_astStmtTypeAlias(): org.sireum.lang.ast.Stmt.TypeAlias = {
      val r = read_astStmtTypeAliasT(F)
      return r
    }

    def read_astStmtTypeAliasT(typeParsed: B): org.sireum.lang.ast.Stmt.TypeAlias = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtTypeAlias)
      }
      val id = read_astId()
      val typeParams = reader.readISZ(read_astTypeParam _)
      val tipe = read_astType()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.TypeAlias(id, typeParams, tipe, attr)
    }

    def read_astStmtAssign(): org.sireum.lang.ast.Stmt.Assign = {
      val r = read_astStmtAssignT(F)
      return r
    }

    def read_astStmtAssignT(typeParsed: B): org.sireum.lang.ast.Stmt.Assign = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtAssign)
      }
      val lhs = read_astExp()
      val rhs = read_astAssignExp()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.Assign(lhs, rhs, attr)
    }

    def read_astStmtBlock(): org.sireum.lang.ast.Stmt.Block = {
      val r = read_astStmtBlockT(F)
      return r
    }

    def read_astStmtBlockT(typeParsed: B): org.sireum.lang.ast.Stmt.Block = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtBlock)
      }
      val body = read_astBody()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.Block(body, attr)
    }

    def read_astStmtIf(): org.sireum.lang.ast.Stmt.If = {
      val r = read_astStmtIfT(F)
      return r
    }

    def read_astStmtIfT(typeParsed: B): org.sireum.lang.ast.Stmt.If = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtIf)
      }
      val cond = read_astExp()
      val thenBody = read_astBody()
      val elseBody = read_astBody()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.If(cond, thenBody, elseBody, attr)
    }

    def read_astStmtMatch(): org.sireum.lang.ast.Stmt.Match = {
      val r = read_astStmtMatchT(F)
      return r
    }

    def read_astStmtMatchT(typeParsed: B): org.sireum.lang.ast.Stmt.Match = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtMatch)
      }
      val exp = read_astExp()
      val cases = reader.readISZ(read_astCase _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.Match(exp, cases, attr)
    }

    def read_astStmtWhile(): org.sireum.lang.ast.Stmt.While = {
      val r = read_astStmtWhileT(F)
      return r
    }

    def read_astStmtWhileT(typeParsed: B): org.sireum.lang.ast.Stmt.While = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtWhile)
      }
      val cond = read_astExp()
      val invariants = reader.readISZ(read_astContractExp _)
      val modifies = reader.readISZ(read_astExp _)
      val body = read_astBody()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.While(cond, invariants, modifies, body, attr)
    }

    def read_astStmtDoWhile(): org.sireum.lang.ast.Stmt.DoWhile = {
      val r = read_astStmtDoWhileT(F)
      return r
    }

    def read_astStmtDoWhileT(typeParsed: B): org.sireum.lang.ast.Stmt.DoWhile = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtDoWhile)
      }
      val cond = read_astExp()
      val invariants = reader.readISZ(read_astContractExp _)
      val modifies = reader.readISZ(read_astExp _)
      val body = read_astBody()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.DoWhile(cond, invariants, modifies, body, attr)
    }

    def read_astStmtFor(): org.sireum.lang.ast.Stmt.For = {
      val r = read_astStmtForT(F)
      return r
    }

    def read_astStmtForT(typeParsed: B): org.sireum.lang.ast.Stmt.For = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtFor)
      }
      val enumGens = reader.readISZ(read_astEnumGenFor _)
      val invariants = reader.readISZ(read_astContractExp _)
      val modifies = reader.readISZ(read_astExp _)
      val body = read_astBody()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.For(enumGens, invariants, modifies, body, attr)
    }

    def read_astStmtReturn(): org.sireum.lang.ast.Stmt.Return = {
      val r = read_astStmtReturnT(F)
      return r
    }

    def read_astStmtReturnT(typeParsed: B): org.sireum.lang.ast.Stmt.Return = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtReturn)
      }
      val expOpt = reader.readOption(read_astExp _)
      val attr = read_astTypedAttr()
      return org.sireum.lang.ast.Stmt.Return(expOpt, attr)
    }

    def read_astStmtLStmt(): org.sireum.lang.ast.Stmt.LStmt = {
      val r = read_astStmtLStmtT(F)
      return r
    }

    def read_astStmtLStmtT(typeParsed: B): org.sireum.lang.ast.Stmt.LStmt = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtLStmt)
      }
      val clause = read_astLClause()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Stmt.LStmt(clause, attr)
    }

    def read_astStmtExpr(): org.sireum.lang.ast.Stmt.Expr = {
      val r = read_astStmtExprT(F)
      return r
    }

    def read_astStmtExprT(typeParsed: B): org.sireum.lang.ast.Stmt.Expr = {
      if (!typeParsed) {
        reader.expectZ(Constants._astStmtExpr)
      }
      val exp = read_astExp()
      val attr = read_astTypedAttr()
      return org.sireum.lang.ast.Stmt.Expr(exp, attr)
    }

    def read_astAssignExp(): org.sireum.lang.ast.AssignExp = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._astStmtBlock => val r = read_astStmtBlockT(T); return r
        case Constants._astStmtIf => val r = read_astStmtIfT(T); return r
        case Constants._astStmtMatch => val r = read_astStmtMatchT(T); return r
        case Constants._astStmtReturn => val r = read_astStmtReturnT(T); return r
        case Constants._astStmtExpr => val r = read_astStmtExprT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.ast.AssignExp.")
          val r = read_astStmtExprT(T)
          return r
      }
    }

    def read_astPurityType(): org.sireum.lang.ast.Purity.Type = {
      val r = reader.readZ()
      return org.sireum.lang.ast.Purity.byOrdinal(r).get
    }

    def read_astLClause(): org.sireum.lang.ast.LClause = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._astLClauseInvariants => val r = read_astLClauseInvariantsT(T); return r
        case Constants._astLClauseFacts => val r = read_astLClauseFactsT(T); return r
        case Constants._astLClauseTheorems => val r = read_astLClauseTheoremsT(T); return r
        case Constants._astLClauseSequent => val r = read_astLClauseSequentT(T); return r
        case Constants._astLClauseProof => val r = read_astLClauseProofT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.ast.LClause.")
          val r = read_astLClauseProofT(T)
          return r
      }
    }

    def read_astLClauseInvariants(): org.sireum.lang.ast.LClause.Invariants = {
      val r = read_astLClauseInvariantsT(F)
      return r
    }

    def read_astLClauseInvariantsT(typeParsed: B): org.sireum.lang.ast.LClause.Invariants = {
      if (!typeParsed) {
        reader.expectZ(Constants._astLClauseInvariants)
      }
      val value = reader.readISZ(read_astContractExp _)
      return org.sireum.lang.ast.LClause.Invariants(value)
    }

    def read_astLClauseFacts(): org.sireum.lang.ast.LClause.Facts = {
      val r = read_astLClauseFactsT(F)
      return r
    }

    def read_astLClauseFactsT(typeParsed: B): org.sireum.lang.ast.LClause.Facts = {
      if (!typeParsed) {
        reader.expectZ(Constants._astLClauseFacts)
      }
      val value = reader.readISZ(read_astLClauseFact _)
      return org.sireum.lang.ast.LClause.Facts(value)
    }

    def read_astLClauseFact(): org.sireum.lang.ast.LClause.Fact = {
      val r = read_astLClauseFactT(F)
      return r
    }

    def read_astLClauseFactT(typeParsed: B): org.sireum.lang.ast.LClause.Fact = {
      if (!typeParsed) {
        reader.expectZ(Constants._astLClauseFact)
      }
      val id = read_astId()
      val exp = read_astExp()
      return org.sireum.lang.ast.LClause.Fact(id, exp)
    }

    def read_astLClauseTheorems(): org.sireum.lang.ast.LClause.Theorems = {
      val r = read_astLClauseTheoremsT(F)
      return r
    }

    def read_astLClauseTheoremsT(typeParsed: B): org.sireum.lang.ast.LClause.Theorems = {
      if (!typeParsed) {
        reader.expectZ(Constants._astLClauseTheorems)
      }
      val value = reader.readISZ(read_astLClauseTheorem _)
      return org.sireum.lang.ast.LClause.Theorems(value)
    }

    def read_astLClauseTheorem(): org.sireum.lang.ast.LClause.Theorem = {
      val r = read_astLClauseTheoremT(F)
      return r
    }

    def read_astLClauseTheoremT(typeParsed: B): org.sireum.lang.ast.LClause.Theorem = {
      if (!typeParsed) {
        reader.expectZ(Constants._astLClauseTheorem)
      }
      val id = read_astId()
      val sequent = read_astLClauseSequent()
      return org.sireum.lang.ast.LClause.Theorem(id, sequent)
    }

    def read_astLClauseSequent(): org.sireum.lang.ast.LClause.Sequent = {
      val r = read_astLClauseSequentT(F)
      return r
    }

    def read_astLClauseSequentT(typeParsed: B): org.sireum.lang.ast.LClause.Sequent = {
      if (!typeParsed) {
        reader.expectZ(Constants._astLClauseSequent)
      }
      val premises = reader.readISZ(read_astExp _)
      val conclusions = reader.readISZ(read_astExp _)
      val proofOpt = reader.readOption(read_astLClauseProof _)
      return org.sireum.lang.ast.LClause.Sequent(premises, conclusions, proofOpt)
    }

    def read_astLClauseProof(): org.sireum.lang.ast.LClause.Proof = {
      val r = read_astLClauseProofT(F)
      return r
    }

    def read_astLClauseProofT(typeParsed: B): org.sireum.lang.ast.LClause.Proof = {
      if (!typeParsed) {
        reader.expectZ(Constants._astLClauseProof)
      }
      val steps = reader.readISZ(read_astProofStep _)
      return org.sireum.lang.ast.LClause.Proof(steps)
    }

    def read_astContractExp(): org.sireum.lang.ast.ContractExp = {
      val r = read_astContractExpT(F)
      return r
    }

    def read_astContractExpT(typeParsed: B): org.sireum.lang.ast.ContractExp = {
      if (!typeParsed) {
        reader.expectZ(Constants._astContractExp)
      }
      val idOpt = reader.readOption(read_astId _)
      val exp = read_astExp()
      return org.sireum.lang.ast.ContractExp(idOpt, exp)
    }

    def read_astCase(): org.sireum.lang.ast.Case = {
      val r = read_astCaseT(F)
      return r
    }

    def read_astCaseT(typeParsed: B): org.sireum.lang.ast.Case = {
      if (!typeParsed) {
        reader.expectZ(Constants._astCase)
      }
      val pattern = read_astPattern()
      val condOpt = reader.readOption(read_astExp _)
      val body = read_astBody()
      return org.sireum.lang.ast.Case(pattern, condOpt, body)
    }

    def read_astEnumGenRange(): org.sireum.lang.ast.EnumGen.Range = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._astEnumGenRangeExpr => val r = read_astEnumGenRangeExprT(T); return r
        case Constants._astEnumGenRangeStep => val r = read_astEnumGenRangeStepT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.ast.EnumGen.Range.")
          val r = read_astEnumGenRangeStepT(T)
          return r
      }
    }

    def read_astEnumGenRangeExpr(): org.sireum.lang.ast.EnumGen.Range.Expr = {
      val r = read_astEnumGenRangeExprT(F)
      return r
    }

    def read_astEnumGenRangeExprT(typeParsed: B): org.sireum.lang.ast.EnumGen.Range.Expr = {
      if (!typeParsed) {
        reader.expectZ(Constants._astEnumGenRangeExpr)
      }
      val isReverse = reader.readB()
      val isIndices = reader.readB()
      val exp = read_astExp()
      val attr = read_astAttr()
      return org.sireum.lang.ast.EnumGen.Range.Expr(isReverse, isIndices, exp, attr)
    }

    def read_astEnumGenRangeStep(): org.sireum.lang.ast.EnumGen.Range.Step = {
      val r = read_astEnumGenRangeStepT(F)
      return r
    }

    def read_astEnumGenRangeStepT(typeParsed: B): org.sireum.lang.ast.EnumGen.Range.Step = {
      if (!typeParsed) {
        reader.expectZ(Constants._astEnumGenRangeStep)
      }
      val isInclusive = reader.readB()
      val start = read_astExp()
      val end = read_astExp()
      val byOpt = reader.readOption(read_astExp _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.EnumGen.Range.Step(isInclusive, start, end, byOpt, attr)
    }

    def read_astEnumGenFor(): org.sireum.lang.ast.EnumGen.For = {
      val r = read_astEnumGenForT(F)
      return r
    }

    def read_astEnumGenForT(typeParsed: B): org.sireum.lang.ast.EnumGen.For = {
      if (!typeParsed) {
        reader.expectZ(Constants._astEnumGenFor)
      }
      val idOpt = reader.readOption(read_astId _)
      val range = read_astEnumGenRange()
      val condOpt = reader.readOption(read_astExp _)
      return org.sireum.lang.ast.EnumGen.For(idOpt, range, condOpt)
    }

    def read_astType(): org.sireum.lang.ast.Type = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._astTypeNamed => val r = read_astTypeNamedT(T); return r
        case Constants._astTypeFun => val r = read_astTypeFunT(T); return r
        case Constants._astTypeTuple => val r = read_astTypeTupleT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.ast.Type.")
          val r = read_astTypeTupleT(T)
          return r
      }
    }

    def read_astTypeNamed(): org.sireum.lang.ast.Type.Named = {
      val r = read_astTypeNamedT(F)
      return r
    }

    def read_astTypeNamedT(typeParsed: B): org.sireum.lang.ast.Type.Named = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTypeNamed)
      }
      val name = read_astName()
      val typeArgs = reader.readISZ(read_astType _)
      val attr = read_astTypedAttr()
      return org.sireum.lang.ast.Type.Named(name, typeArgs, attr)
    }

    def read_astTypeFun(): org.sireum.lang.ast.Type.Fun = {
      val r = read_astTypeFunT(F)
      return r
    }

    def read_astTypeFunT(typeParsed: B): org.sireum.lang.ast.Type.Fun = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTypeFun)
      }
      val isPure = reader.readB()
      val isByName = reader.readB()
      val args = reader.readISZ(read_astType _)
      val ret = read_astType()
      val attr = read_astTypedAttr()
      return org.sireum.lang.ast.Type.Fun(isPure, isByName, args, ret, attr)
    }

    def read_astTypeTuple(): org.sireum.lang.ast.Type.Tuple = {
      val r = read_astTypeTupleT(F)
      return r
    }

    def read_astTypeTupleT(typeParsed: B): org.sireum.lang.ast.Type.Tuple = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTypeTuple)
      }
      val args = reader.readISZ(read_astType _)
      val attr = read_astTypedAttr()
      return org.sireum.lang.ast.Type.Tuple(args, attr)
    }

    def read_astPattern(): org.sireum.lang.ast.Pattern = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._astPatternLiteral => val r = read_astPatternLiteralT(T); return r
        case Constants._astPatternLitInterpolate => val r = read_astPatternLitInterpolateT(T); return r
        case Constants._astPatternRef => val r = read_astPatternRefT(T); return r
        case Constants._astPatternVarBinding => val r = read_astPatternVarBindingT(T); return r
        case Constants._astPatternWildcard => val r = read_astPatternWildcardT(T); return r
        case Constants._astPatternSeqWildcard => val r = read_astPatternSeqWildcardT(T); return r
        case Constants._astPatternStructure => val r = read_astPatternStructureT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.ast.Pattern.")
          val r = read_astPatternStructureT(T)
          return r
      }
    }

    def read_astPatternLiteral(): org.sireum.lang.ast.Pattern.Literal = {
      val r = read_astPatternLiteralT(F)
      return r
    }

    def read_astPatternLiteralT(typeParsed: B): org.sireum.lang.ast.Pattern.Literal = {
      if (!typeParsed) {
        reader.expectZ(Constants._astPatternLiteral)
      }
      val lit = read_astLit()
      return org.sireum.lang.ast.Pattern.Literal(lit)
    }

    def read_astPatternLitInterpolate(): org.sireum.lang.ast.Pattern.LitInterpolate = {
      val r = read_astPatternLitInterpolateT(F)
      return r
    }

    def read_astPatternLitInterpolateT(typeParsed: B): org.sireum.lang.ast.Pattern.LitInterpolate = {
      if (!typeParsed) {
        reader.expectZ(Constants._astPatternLitInterpolate)
      }
      val prefix = reader.readString()
      val value = reader.readString()
      val attr = read_astTypedAttr()
      return org.sireum.lang.ast.Pattern.LitInterpolate(prefix, value, attr)
    }

    def read_astPatternRef(): org.sireum.lang.ast.Pattern.Ref = {
      val r = read_astPatternRefT(F)
      return r
    }

    def read_astPatternRefT(typeParsed: B): org.sireum.lang.ast.Pattern.Ref = {
      if (!typeParsed) {
        reader.expectZ(Constants._astPatternRef)
      }
      val name = read_astName()
      val attr = read_astResolvedAttr()
      return org.sireum.lang.ast.Pattern.Ref(name, attr)
    }

    def read_astPatternVarBinding(): org.sireum.lang.ast.Pattern.VarBinding = {
      val r = read_astPatternVarBindingT(F)
      return r
    }

    def read_astPatternVarBindingT(typeParsed: B): org.sireum.lang.ast.Pattern.VarBinding = {
      if (!typeParsed) {
        reader.expectZ(Constants._astPatternVarBinding)
      }
      val id = read_astId()
      val tipeOpt = reader.readOption(read_astType _)
      val attr = read_astTypedAttr()
      return org.sireum.lang.ast.Pattern.VarBinding(id, tipeOpt, attr)
    }

    def read_astPatternWildcard(): org.sireum.lang.ast.Pattern.Wildcard = {
      val r = read_astPatternWildcardT(F)
      return r
    }

    def read_astPatternWildcardT(typeParsed: B): org.sireum.lang.ast.Pattern.Wildcard = {
      if (!typeParsed) {
        reader.expectZ(Constants._astPatternWildcard)
      }
      val typeOpt = reader.readOption(read_astType _)
      val attr = read_astTypedAttr()
      return org.sireum.lang.ast.Pattern.Wildcard(typeOpt, attr)
    }

    def read_astPatternSeqWildcard(): org.sireum.lang.ast.Pattern.SeqWildcard = {
      val r = read_astPatternSeqWildcardT(F)
      return r
    }

    def read_astPatternSeqWildcardT(typeParsed: B): org.sireum.lang.ast.Pattern.SeqWildcard = {
      if (!typeParsed) {
        reader.expectZ(Constants._astPatternSeqWildcard)
      }
      val attr = read_astTypedAttr()
      return org.sireum.lang.ast.Pattern.SeqWildcard(attr)
    }

    def read_astPatternStructure(): org.sireum.lang.ast.Pattern.Structure = {
      val r = read_astPatternStructureT(F)
      return r
    }

    def read_astPatternStructureT(typeParsed: B): org.sireum.lang.ast.Pattern.Structure = {
      if (!typeParsed) {
        reader.expectZ(Constants._astPatternStructure)
      }
      val idOpt = reader.readOption(read_astId _)
      val nameOpt = reader.readOption(read_astName _)
      val patterns = reader.readISZ(read_astPattern _)
      val attr = read_astResolvedAttr()
      return org.sireum.lang.ast.Pattern.Structure(idOpt, nameOpt, patterns, attr)
    }

    def read_astExp(): org.sireum.lang.ast.Exp = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._astExpLitB => val r = read_astExpLitBT(T); return r
        case Constants._astExpLitC => val r = read_astExpLitCT(T); return r
        case Constants._astExpLitZ => val r = read_astExpLitZT(T); return r
        case Constants._astExpLitF32 => val r = read_astExpLitF32T(T); return r
        case Constants._astExpLitF64 => val r = read_astExpLitF64T(T); return r
        case Constants._astExpLitR => val r = read_astExpLitRT(T); return r
        case Constants._astExpLitString => val r = read_astExpLitStringT(T); return r
        case Constants._astExpStringInterpolate => val r = read_astExpStringInterpolateT(T); return r
        case Constants._astExpThis => val r = read_astExpThisT(T); return r
        case Constants._astExpSuper => val r = read_astExpSuperT(T); return r
        case Constants._astExpUnary => val r = read_astExpUnaryT(T); return r
        case Constants._astExpBinary => val r = read_astExpBinaryT(T); return r
        case Constants._astExpIdent => val r = read_astExpIdentT(T); return r
        case Constants._astExpEta => val r = read_astExpEtaT(T); return r
        case Constants._astExpTuple => val r = read_astExpTupleT(T); return r
        case Constants._astExpSelect => val r = read_astExpSelectT(T); return r
        case Constants._astExpInvoke => val r = read_astExpInvokeT(T); return r
        case Constants._astExpInvokeNamed => val r = read_astExpInvokeNamedT(T); return r
        case Constants._astExpIf => val r = read_astExpIfT(T); return r
        case Constants._astExpFun => val r = read_astExpFunT(T); return r
        case Constants._astExpForYield => val r = read_astExpForYieldT(T); return r
        case Constants._astExpQuant => val r = read_astExpQuantT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.ast.Exp.")
          val r = read_astExpQuantT(T)
          return r
      }
    }

    def read_astLit(): org.sireum.lang.ast.Lit = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._astExpLitB => val r = read_astExpLitBT(T); return r
        case Constants._astExpLitC => val r = read_astExpLitCT(T); return r
        case Constants._astExpLitZ => val r = read_astExpLitZT(T); return r
        case Constants._astExpLitF32 => val r = read_astExpLitF32T(T); return r
        case Constants._astExpLitF64 => val r = read_astExpLitF64T(T); return r
        case Constants._astExpLitR => val r = read_astExpLitRT(T); return r
        case Constants._astExpLitString => val r = read_astExpLitStringT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.ast.Lit.")
          val r = read_astExpLitStringT(T)
          return r
      }
    }

    def read_astExpLitB(): org.sireum.lang.ast.Exp.LitB = {
      val r = read_astExpLitBT(F)
      return r
    }

    def read_astExpLitBT(typeParsed: B): org.sireum.lang.ast.Exp.LitB = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpLitB)
      }
      val value = reader.readB()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Exp.LitB(value, attr)
    }

    def read_astExpLitC(): org.sireum.lang.ast.Exp.LitC = {
      val r = read_astExpLitCT(F)
      return r
    }

    def read_astExpLitCT(typeParsed: B): org.sireum.lang.ast.Exp.LitC = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpLitC)
      }
      val value = reader.readC()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Exp.LitC(value, attr)
    }

    def read_astExpLitZ(): org.sireum.lang.ast.Exp.LitZ = {
      val r = read_astExpLitZT(F)
      return r
    }

    def read_astExpLitZT(typeParsed: B): org.sireum.lang.ast.Exp.LitZ = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpLitZ)
      }
      val value = reader.readZ()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Exp.LitZ(value, attr)
    }

    def read_astExpLitF32(): org.sireum.lang.ast.Exp.LitF32 = {
      val r = read_astExpLitF32T(F)
      return r
    }

    def read_astExpLitF32T(typeParsed: B): org.sireum.lang.ast.Exp.LitF32 = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpLitF32)
      }
      val value = reader.readF32()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Exp.LitF32(value, attr)
    }

    def read_astExpLitF64(): org.sireum.lang.ast.Exp.LitF64 = {
      val r = read_astExpLitF64T(F)
      return r
    }

    def read_astExpLitF64T(typeParsed: B): org.sireum.lang.ast.Exp.LitF64 = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpLitF64)
      }
      val value = reader.readF64()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Exp.LitF64(value, attr)
    }

    def read_astExpLitR(): org.sireum.lang.ast.Exp.LitR = {
      val r = read_astExpLitRT(F)
      return r
    }

    def read_astExpLitRT(typeParsed: B): org.sireum.lang.ast.Exp.LitR = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpLitR)
      }
      val value = reader.readR()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Exp.LitR(value, attr)
    }

    def read_astExpLitString(): org.sireum.lang.ast.Exp.LitString = {
      val r = read_astExpLitStringT(F)
      return r
    }

    def read_astExpLitStringT(typeParsed: B): org.sireum.lang.ast.Exp.LitString = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpLitString)
      }
      val value = reader.readString()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Exp.LitString(value, attr)
    }

    def read_astExpStringInterpolate(): org.sireum.lang.ast.Exp.StringInterpolate = {
      val r = read_astExpStringInterpolateT(F)
      return r
    }

    def read_astExpStringInterpolateT(typeParsed: B): org.sireum.lang.ast.Exp.StringInterpolate = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpStringInterpolate)
      }
      val prefix = reader.readString()
      val lits = reader.readISZ(read_astExpLitString _)
      val args = reader.readISZ(read_astExp _)
      val attr = read_astTypedAttr()
      return org.sireum.lang.ast.Exp.StringInterpolate(prefix, lits, args, attr)
    }

    def read_astExpThis(): org.sireum.lang.ast.Exp.This = {
      val r = read_astExpThisT(F)
      return r
    }

    def read_astExpThisT(typeParsed: B): org.sireum.lang.ast.Exp.This = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpThis)
      }
      val attr = read_astTypedAttr()
      return org.sireum.lang.ast.Exp.This(attr)
    }

    def read_astExpSuper(): org.sireum.lang.ast.Exp.Super = {
      val r = read_astExpSuperT(F)
      return r
    }

    def read_astExpSuperT(typeParsed: B): org.sireum.lang.ast.Exp.Super = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpSuper)
      }
      val idOpt = reader.readOption(read_astId _)
      val attr = read_astTypedAttr()
      return org.sireum.lang.ast.Exp.Super(idOpt, attr)
    }

    def read_astExpUnaryOpType(): org.sireum.lang.ast.Exp.UnaryOp.Type = {
      val r = reader.readZ()
      return org.sireum.lang.ast.Exp.UnaryOp.byOrdinal(r).get
    }

    def read_astExpUnary(): org.sireum.lang.ast.Exp.Unary = {
      val r = read_astExpUnaryT(F)
      return r
    }

    def read_astExpUnaryT(typeParsed: B): org.sireum.lang.ast.Exp.Unary = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpUnary)
      }
      val op = read_astExpUnaryOpType()
      val exp = read_astExp()
      val attr = read_astResolvedAttr()
      return org.sireum.lang.ast.Exp.Unary(op, exp, attr)
    }

    def read_astExpRef(): org.sireum.lang.ast.Exp.Ref = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._astExpIdent => val r = read_astExpIdentT(T); return r
        case Constants._astExpSelect => val r = read_astExpSelectT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.ast.Exp.Ref.")
          val r = read_astExpSelectT(T)
          return r
      }
    }

    def read_astExpBinary(): org.sireum.lang.ast.Exp.Binary = {
      val r = read_astExpBinaryT(F)
      return r
    }

    def read_astExpBinaryT(typeParsed: B): org.sireum.lang.ast.Exp.Binary = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpBinary)
      }
      val left = read_astExp()
      val op = reader.readString()
      val right = read_astExp()
      val attr = read_astResolvedAttr()
      return org.sireum.lang.ast.Exp.Binary(left, op, right, attr)
    }

    def read_astExpIdent(): org.sireum.lang.ast.Exp.Ident = {
      val r = read_astExpIdentT(F)
      return r
    }

    def read_astExpIdentT(typeParsed: B): org.sireum.lang.ast.Exp.Ident = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpIdent)
      }
      val id = read_astId()
      val attr = read_astResolvedAttr()
      return org.sireum.lang.ast.Exp.Ident(id, attr)
    }

    def read_astExpEta(): org.sireum.lang.ast.Exp.Eta = {
      val r = read_astExpEtaT(F)
      return r
    }

    def read_astExpEtaT(typeParsed: B): org.sireum.lang.ast.Exp.Eta = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpEta)
      }
      val ref = read_astExpRef()
      val attr = read_astTypedAttr()
      return org.sireum.lang.ast.Exp.Eta(ref, attr)
    }

    def read_astExpTuple(): org.sireum.lang.ast.Exp.Tuple = {
      val r = read_astExpTupleT(F)
      return r
    }

    def read_astExpTupleT(typeParsed: B): org.sireum.lang.ast.Exp.Tuple = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpTuple)
      }
      val args = reader.readISZ(read_astExp _)
      val attr = read_astTypedAttr()
      return org.sireum.lang.ast.Exp.Tuple(args, attr)
    }

    def read_astExpSelect(): org.sireum.lang.ast.Exp.Select = {
      val r = read_astExpSelectT(F)
      return r
    }

    def read_astExpSelectT(typeParsed: B): org.sireum.lang.ast.Exp.Select = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpSelect)
      }
      val receiverOpt = reader.readOption(read_astExp _)
      val id = read_astId()
      val targs = reader.readISZ(read_astType _)
      val attr = read_astResolvedAttr()
      return org.sireum.lang.ast.Exp.Select(receiverOpt, id, targs, attr)
    }

    def read_astExpInvoke(): org.sireum.lang.ast.Exp.Invoke = {
      val r = read_astExpInvokeT(F)
      return r
    }

    def read_astExpInvokeT(typeParsed: B): org.sireum.lang.ast.Exp.Invoke = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpInvoke)
      }
      val receiverOpt = reader.readOption(read_astExp _)
      val id = read_astId()
      val targs = reader.readISZ(read_astType _)
      val args = reader.readISZ(read_astExp _)
      val attr = read_astResolvedAttr()
      return org.sireum.lang.ast.Exp.Invoke(receiverOpt, id, targs, args, attr)
    }

    def read_astExpInvokeNamed(): org.sireum.lang.ast.Exp.InvokeNamed = {
      val r = read_astExpInvokeNamedT(F)
      return r
    }

    def read_astExpInvokeNamedT(typeParsed: B): org.sireum.lang.ast.Exp.InvokeNamed = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpInvokeNamed)
      }
      val receiverOpt = reader.readOption(read_astExp _)
      val id = read_astId()
      val targs = reader.readISZ(read_astType _)
      val args = reader.readISZ(read_astNamedArg _)
      val attr = read_astResolvedAttr()
      return org.sireum.lang.ast.Exp.InvokeNamed(receiverOpt, id, targs, args, attr)
    }

    def read_astExpIf(): org.sireum.lang.ast.Exp.If = {
      val r = read_astExpIfT(F)
      return r
    }

    def read_astExpIfT(typeParsed: B): org.sireum.lang.ast.Exp.If = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpIf)
      }
      val cond = read_astExp()
      val thenExp = read_astExp()
      val elseExp = read_astExp()
      val attr = read_astTypedAttr()
      return org.sireum.lang.ast.Exp.If(cond, thenExp, elseExp, attr)
    }

    def read_astExpFunParam(): org.sireum.lang.ast.Exp.Fun.Param = {
      val r = read_astExpFunParamT(F)
      return r
    }

    def read_astExpFunParamT(typeParsed: B): org.sireum.lang.ast.Exp.Fun.Param = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpFunParam)
      }
      val id = read_astId()
      val tipeOpt = reader.readOption(read_astType _)
      return org.sireum.lang.ast.Exp.Fun.Param(id, tipeOpt)
    }

    def read_astExpFun(): org.sireum.lang.ast.Exp.Fun = {
      val r = read_astExpFunT(F)
      return r
    }

    def read_astExpFunT(typeParsed: B): org.sireum.lang.ast.Exp.Fun = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpFun)
      }
      val context = reader.readISZ(reader.readString _)
      val params = reader.readISZ(read_astExpFunParam _)
      val contract = read_astContract()
      val exp = read_astAssignExp()
      val attr = read_astTypedAttr()
      return org.sireum.lang.ast.Exp.Fun(context, params, contract, exp, attr)
    }

    def read_astExpForYield(): org.sireum.lang.ast.Exp.ForYield = {
      val r = read_astExpForYieldT(F)
      return r
    }

    def read_astExpForYieldT(typeParsed: B): org.sireum.lang.ast.Exp.ForYield = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpForYield)
      }
      val enumGens = reader.readISZ(read_astEnumGenFor _)
      val exp = read_astExp()
      val attr = read_astTypedAttr()
      return org.sireum.lang.ast.Exp.ForYield(enumGens, exp, attr)
    }

    def read_astExpQuant(): org.sireum.lang.ast.Exp.Quant = {
      val r = read_astExpQuantT(F)
      return r
    }

    def read_astExpQuantT(typeParsed: B): org.sireum.lang.ast.Exp.Quant = {
      if (!typeParsed) {
        reader.expectZ(Constants._astExpQuant)
      }
      val isForall = reader.readB()
      val varFragments = reader.readISZ(read_astVarFragment _)
      val exp = read_astExp()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Exp.Quant(isForall, varFragments, exp, attr)
    }

    def read_astNamedArg(): org.sireum.lang.ast.NamedArg = {
      val r = read_astNamedArgT(F)
      return r
    }

    def read_astNamedArgT(typeParsed: B): org.sireum.lang.ast.NamedArg = {
      if (!typeParsed) {
        reader.expectZ(Constants._astNamedArg)
      }
      val id = read_astId()
      val arg = read_astExp()
      val index = reader.readZ()
      return org.sireum.lang.ast.NamedArg(id, arg, index)
    }

    def read_astVarFragment(): org.sireum.lang.ast.VarFragment = {
      val r = read_astVarFragmentT(F)
      return r
    }

    def read_astVarFragmentT(typeParsed: B): org.sireum.lang.ast.VarFragment = {
      if (!typeParsed) {
        reader.expectZ(Constants._astVarFragment)
      }
      val ids = reader.readISZ(read_astId _)
      val domainOpt = reader.readOption(read_astDomain _)
      return org.sireum.lang.ast.VarFragment(ids, domainOpt)
    }

    def read_astDomain(): org.sireum.lang.ast.Domain = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._astDomainType => val r = read_astDomainTypeT(T); return r
        case Constants._astDomainRange => val r = read_astDomainRangeT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.ast.Domain.")
          val r = read_astDomainRangeT(T)
          return r
      }
    }

    def read_astDomainType(): org.sireum.lang.ast.Domain.Type = {
      val r = read_astDomainTypeT(F)
      return r
    }

    def read_astDomainTypeT(typeParsed: B): org.sireum.lang.ast.Domain.Type = {
      if (!typeParsed) {
        reader.expectZ(Constants._astDomainType)
      }
      val tipe = read_astType()
      val attr = read_astTypedAttr()
      return org.sireum.lang.ast.Domain.Type(tipe, attr)
    }

    def read_astDomainRange(): org.sireum.lang.ast.Domain.Range = {
      val r = read_astDomainRangeT(F)
      return r
    }

    def read_astDomainRangeT(typeParsed: B): org.sireum.lang.ast.Domain.Range = {
      if (!typeParsed) {
        reader.expectZ(Constants._astDomainRange)
      }
      val lo = read_astExp()
      val loExact = reader.readB()
      val hi = read_astExp()
      val hiExact = reader.readB()
      val attr = read_astTypedAttr()
      return org.sireum.lang.ast.Domain.Range(lo, loExact, hi, hiExact, attr)
    }

    def read_astId(): org.sireum.lang.ast.Id = {
      val r = read_astIdT(F)
      return r
    }

    def read_astIdT(typeParsed: B): org.sireum.lang.ast.Id = {
      if (!typeParsed) {
        reader.expectZ(Constants._astId)
      }
      val value = reader.readString()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Id(value, attr)
    }

    def read_astName(): org.sireum.lang.ast.Name = {
      val r = read_astNameT(F)
      return r
    }

    def read_astNameT(typeParsed: B): org.sireum.lang.ast.Name = {
      if (!typeParsed) {
        reader.expectZ(Constants._astName)
      }
      val ids = reader.readISZ(read_astId _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.Name(ids, attr)
    }

    def read_astBody(): org.sireum.lang.ast.Body = {
      val r = read_astBodyT(F)
      return r
    }

    def read_astBodyT(typeParsed: B): org.sireum.lang.ast.Body = {
      if (!typeParsed) {
        reader.expectZ(Constants._astBody)
      }
      val stmts = reader.readISZ(read_astStmt _)
      val undecls = reader.readISZ(reader.readString _)
      return org.sireum.lang.ast.Body(stmts, undecls)
    }

    def read_astAbstractDatatypeParam(): org.sireum.lang.ast.AbstractDatatypeParam = {
      val r = read_astAbstractDatatypeParamT(F)
      return r
    }

    def read_astAbstractDatatypeParamT(typeParsed: B): org.sireum.lang.ast.AbstractDatatypeParam = {
      if (!typeParsed) {
        reader.expectZ(Constants._astAbstractDatatypeParam)
      }
      val isHidden = reader.readB()
      val isVal = reader.readB()
      val id = read_astId()
      val tipe = read_astType()
      return org.sireum.lang.ast.AbstractDatatypeParam(isHidden, isVal, id, tipe)
    }

    def read_astMethodSig(): org.sireum.lang.ast.MethodSig = {
      val r = read_astMethodSigT(F)
      return r
    }

    def read_astMethodSigT(typeParsed: B): org.sireum.lang.ast.MethodSig = {
      if (!typeParsed) {
        reader.expectZ(Constants._astMethodSig)
      }
      val isPure = reader.readB()
      val id = read_astId()
      val typeParams = reader.readISZ(read_astTypeParam _)
      val hasParams = reader.readB()
      val params = reader.readISZ(read_astParam _)
      val returnType = read_astType()
      return org.sireum.lang.ast.MethodSig(isPure, id, typeParams, hasParams, params, returnType)
    }

    def read_astParam(): org.sireum.lang.ast.Param = {
      val r = read_astParamT(F)
      return r
    }

    def read_astParamT(typeParsed: B): org.sireum.lang.ast.Param = {
      if (!typeParsed) {
        reader.expectZ(Constants._astParam)
      }
      val isHidden = reader.readB()
      val id = read_astId()
      val tipe = read_astType()
      return org.sireum.lang.ast.Param(isHidden, id, tipe)
    }

    def read_astTypeParam(): org.sireum.lang.ast.TypeParam = {
      val r = read_astTypeParamT(F)
      return r
    }

    def read_astTypeParamT(typeParsed: B): org.sireum.lang.ast.TypeParam = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTypeParam)
      }
      val id = read_astId()
      return org.sireum.lang.ast.TypeParam(id)
    }

    def read_astContract(): org.sireum.lang.ast.Contract = {
      val r = read_astContractT(F)
      return r
    }

    def read_astContractT(typeParsed: B): org.sireum.lang.ast.Contract = {
      if (!typeParsed) {
        reader.expectZ(Constants._astContract)
      }
      val reads = reader.readISZ(read_astExp _)
      val requires = reader.readISZ(read_astContractExp _)
      val modifies = reader.readISZ(read_astExp _)
      val ensures = reader.readISZ(read_astContractExp _)
      val subs = reader.readISZ(read_astSubContract _)
      return org.sireum.lang.ast.Contract(reads, requires, modifies, ensures, subs)
    }

    def read_astSubContract(): org.sireum.lang.ast.SubContract = {
      val r = read_astSubContractT(F)
      return r
    }

    def read_astSubContractT(typeParsed: B): org.sireum.lang.ast.SubContract = {
      if (!typeParsed) {
        reader.expectZ(Constants._astSubContract)
      }
      val id = read_astId()
      val params = reader.readISZ(read_astId _)
      val contract = read_astContract()
      return org.sireum.lang.ast.SubContract(id, params, contract)
    }

    def read_astWhereDef(): org.sireum.lang.ast.WhereDef = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._astWhereDefVal => val r = read_astWhereDefValT(T); return r
        case Constants._astWhereDefDef => val r = read_astWhereDefDefT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.ast.WhereDef.")
          val r = read_astWhereDefDefT(T)
          return r
      }
    }

    def read_astWhereDefVal(): org.sireum.lang.ast.WhereDef.Val = {
      val r = read_astWhereDefValT(F)
      return r
    }

    def read_astWhereDefValT(typeParsed: B): org.sireum.lang.ast.WhereDef.Val = {
      if (!typeParsed) {
        reader.expectZ(Constants._astWhereDefVal)
      }
      val id = read_astId()
      val tipe = read_astType()
      val exp = read_astExp()
      return org.sireum.lang.ast.WhereDef.Val(id, tipe, exp)
    }

    def read_astWhereDefDef(): org.sireum.lang.ast.WhereDef.Def = {
      val r = read_astWhereDefDefT(F)
      return r
    }

    def read_astWhereDefDefT(typeParsed: B): org.sireum.lang.ast.WhereDef.Def = {
      if (!typeParsed) {
        reader.expectZ(Constants._astWhereDefDef)
      }
      val id = read_astId()
      val params = reader.readISZ(read_astParam _)
      val rTipe = read_astType()
      val defs = reader.readISZ(read_astSpecDef _)
      return org.sireum.lang.ast.WhereDef.Def(id, params, rTipe, defs)
    }

    def read_astSpecDef(): org.sireum.lang.ast.SpecDef = {
      val r = read_astSpecDefT(F)
      return r
    }

    def read_astSpecDefT(typeParsed: B): org.sireum.lang.ast.SpecDef = {
      if (!typeParsed) {
        reader.expectZ(Constants._astSpecDef)
      }
      val idOpt = reader.readOption(read_astId _)
      val exp = read_astExp()
      val isOtherwise = reader.readB()
      val patternOpt = reader.readOption(read_astPattern _)
      val guardOpt = reader.readOption(read_astExp _)
      return org.sireum.lang.ast.SpecDef(idOpt, exp, isOtherwise, patternOpt, guardOpt)
    }

    def read_astTyped(): org.sireum.lang.ast.Typed = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._astTypedName => val r = read_astTypedNameT(T); return r
        case Constants._astTypedTuple => val r = read_astTypedTupleT(T); return r
        case Constants._astTypedFun => val r = read_astTypedFunT(T); return r
        case Constants._astTypedTypeVar => val r = read_astTypedTypeVarT(T); return r
        case Constants._astTypedPackage => val r = read_astTypedPackageT(T); return r
        case Constants._astTypedObject => val r = read_astTypedObjectT(T); return r
        case Constants._astTypedEnum => val r = read_astTypedEnumT(T); return r
        case Constants._astTypedMethod => val r = read_astTypedMethodT(T); return r
        case Constants._astTypedMethods => val r = read_astTypedMethodsT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.ast.Typed.")
          val r = read_astTypedMethodsT(T)
          return r
      }
    }

    def read_astMethodModeType(): org.sireum.lang.ast.MethodMode.Type = {
      val r = reader.readZ()
      return org.sireum.lang.ast.MethodMode.byOrdinal(r).get
    }

    def read_astTypedName(): org.sireum.lang.ast.Typed.Name = {
      val r = read_astTypedNameT(F)
      return r
    }

    def read_astTypedNameT(typeParsed: B): org.sireum.lang.ast.Typed.Name = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTypedName)
      }
      val ids = reader.readISZ(reader.readString _)
      val args = reader.readISZ(read_astTyped _)
      return org.sireum.lang.ast.Typed.Name(ids, args)
    }

    def read_astTypedTuple(): org.sireum.lang.ast.Typed.Tuple = {
      val r = read_astTypedTupleT(F)
      return r
    }

    def read_astTypedTupleT(typeParsed: B): org.sireum.lang.ast.Typed.Tuple = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTypedTuple)
      }
      val args = reader.readISZ(read_astTyped _)
      return org.sireum.lang.ast.Typed.Tuple(args)
    }

    def read_astTypedFun(): org.sireum.lang.ast.Typed.Fun = {
      val r = read_astTypedFunT(F)
      return r
    }

    def read_astTypedFunT(typeParsed: B): org.sireum.lang.ast.Typed.Fun = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTypedFun)
      }
      val isPure = reader.readB()
      val isByName = reader.readB()
      val args = reader.readISZ(read_astTyped _)
      val ret = read_astTyped()
      return org.sireum.lang.ast.Typed.Fun(isPure, isByName, args, ret)
    }

    def read_astTypedTypeVar(): org.sireum.lang.ast.Typed.TypeVar = {
      val r = read_astTypedTypeVarT(F)
      return r
    }

    def read_astTypedTypeVarT(typeParsed: B): org.sireum.lang.ast.Typed.TypeVar = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTypedTypeVar)
      }
      val id = reader.readString()
      return org.sireum.lang.ast.Typed.TypeVar(id)
    }

    def read_astTypedPackage(): org.sireum.lang.ast.Typed.Package = {
      val r = read_astTypedPackageT(F)
      return r
    }

    def read_astTypedPackageT(typeParsed: B): org.sireum.lang.ast.Typed.Package = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTypedPackage)
      }
      val name = reader.readISZ(reader.readString _)
      return org.sireum.lang.ast.Typed.Package(name)
    }

    def read_astTypedObject(): org.sireum.lang.ast.Typed.Object = {
      val r = read_astTypedObjectT(F)
      return r
    }

    def read_astTypedObjectT(typeParsed: B): org.sireum.lang.ast.Typed.Object = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTypedObject)
      }
      val owner = reader.readISZ(reader.readString _)
      val id = reader.readString()
      return org.sireum.lang.ast.Typed.Object(owner, id)
    }

    def read_astTypedEnum(): org.sireum.lang.ast.Typed.Enum = {
      val r = read_astTypedEnumT(F)
      return r
    }

    def read_astTypedEnumT(typeParsed: B): org.sireum.lang.ast.Typed.Enum = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTypedEnum)
      }
      val name = reader.readISZ(reader.readString _)
      return org.sireum.lang.ast.Typed.Enum(name)
    }

    def read_astTypedMethodSubst(): org.sireum.lang.ast.Typed.Method.Subst = {
      val r = read_astTypedMethodSubstT(F)
      return r
    }

    def read_astTypedMethodSubstT(typeParsed: B): org.sireum.lang.ast.Typed.Method.Subst = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTypedMethodSubst)
      }
      val id = reader.readString()
      val tipe = read_astTyped()
      return org.sireum.lang.ast.Typed.Method.Subst(id, tipe)
    }

    def read_astTypedMethod(): org.sireum.lang.ast.Typed.Method = {
      val r = read_astTypedMethodT(F)
      return r
    }

    def read_astTypedMethodT(typeParsed: B): org.sireum.lang.ast.Typed.Method = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTypedMethod)
      }
      val isInObject = reader.readB()
      val mode = read_astMethodModeType()
      val typeParams = reader.readISZ(reader.readString _)
      val owner = reader.readISZ(reader.readString _)
      val name = reader.readString()
      val paramNames = reader.readISZ(reader.readString _)
      val substs = reader.readISZ(read_astTypedMethodSubst _)
      val tpe = read_astTypedFun()
      return org.sireum.lang.ast.Typed.Method(isInObject, mode, typeParams, owner, name, paramNames, substs, tpe)
    }

    def read_astTypedMethods(): org.sireum.lang.ast.Typed.Methods = {
      val r = read_astTypedMethodsT(F)
      return r
    }

    def read_astTypedMethodsT(typeParsed: B): org.sireum.lang.ast.Typed.Methods = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTypedMethods)
      }
      val methods = reader.readISZ(read_astTypedMethod _)
      return org.sireum.lang.ast.Typed.Methods(methods)
    }

    def read_astAttr(): org.sireum.lang.ast.Attr = {
      val r = read_astAttrT(F)
      return r
    }

    def read_astAttrT(typeParsed: B): org.sireum.lang.ast.Attr = {
      if (!typeParsed) {
        reader.expectZ(Constants._astAttr)
      }
      val posOpt = reader.readOption(reader.readPosition _)
      return org.sireum.lang.ast.Attr(posOpt)
    }

    def read_astTypedAttr(): org.sireum.lang.ast.TypedAttr = {
      val r = read_astTypedAttrT(F)
      return r
    }

    def read_astTypedAttrT(typeParsed: B): org.sireum.lang.ast.TypedAttr = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTypedAttr)
      }
      val posOpt = reader.readOption(reader.readPosition _)
      val typedOpt = reader.readOption(read_astTyped _)
      return org.sireum.lang.ast.TypedAttr(posOpt, typedOpt)
    }

    def read_astResolvedAttr(): org.sireum.lang.ast.ResolvedAttr = {
      val r = read_astResolvedAttrT(F)
      return r
    }

    def read_astResolvedAttrT(typeParsed: B): org.sireum.lang.ast.ResolvedAttr = {
      if (!typeParsed) {
        reader.expectZ(Constants._astResolvedAttr)
      }
      val posOpt = reader.readOption(reader.readPosition _)
      val resOpt = reader.readOption(read_astResolvedInfo _)
      val typedOpt = reader.readOption(read_astTyped _)
      return org.sireum.lang.ast.ResolvedAttr(posOpt, resOpt, typedOpt)
    }

    def read_astResolvedInfo(): org.sireum.lang.ast.ResolvedInfo = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._astResolvedInfoBuiltIn => val r = read_astResolvedInfoBuiltInT(T); return r
        case Constants._astResolvedInfoPackage => val r = read_astResolvedInfoPackageT(T); return r
        case Constants._astResolvedInfoEnum => val r = read_astResolvedInfoEnumT(T); return r
        case Constants._astResolvedInfoEnumElement => val r = read_astResolvedInfoEnumElementT(T); return r
        case Constants._astResolvedInfoObject => val r = read_astResolvedInfoObjectT(T); return r
        case Constants._astResolvedInfoVar => val r = read_astResolvedInfoVarT(T); return r
        case Constants._astResolvedInfoMethod => val r = read_astResolvedInfoMethodT(T); return r
        case Constants._astResolvedInfoMethods => val r = read_astResolvedInfoMethodsT(T); return r
        case Constants._astResolvedInfoType => val r = read_astResolvedInfoTypeT(T); return r
        case Constants._astResolvedInfoTuple => val r = read_astResolvedInfoTupleT(T); return r
        case Constants._astResolvedInfoLocalVar => val r = read_astResolvedInfoLocalVarT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.ast.ResolvedInfo.")
          val r = read_astResolvedInfoLocalVarT(T)
          return r
      }
    }

    def read_astResolvedInfoBuiltInKindType(): org.sireum.lang.ast.ResolvedInfo.BuiltIn.Kind.Type = {
      val r = reader.readZ()
      return org.sireum.lang.ast.ResolvedInfo.BuiltIn.Kind.byOrdinal(r).get
    }

    def read_astResolvedInfoBuiltIn(): org.sireum.lang.ast.ResolvedInfo.BuiltIn = {
      val r = read_astResolvedInfoBuiltInT(F)
      return r
    }

    def read_astResolvedInfoBuiltInT(typeParsed: B): org.sireum.lang.ast.ResolvedInfo.BuiltIn = {
      if (!typeParsed) {
        reader.expectZ(Constants._astResolvedInfoBuiltIn)
      }
      val kind = read_astResolvedInfoBuiltInKindType()
      return org.sireum.lang.ast.ResolvedInfo.BuiltIn(kind)
    }

    def read_astResolvedInfoPackage(): org.sireum.lang.ast.ResolvedInfo.Package = {
      val r = read_astResolvedInfoPackageT(F)
      return r
    }

    def read_astResolvedInfoPackageT(typeParsed: B): org.sireum.lang.ast.ResolvedInfo.Package = {
      if (!typeParsed) {
        reader.expectZ(Constants._astResolvedInfoPackage)
      }
      val name = reader.readISZ(reader.readString _)
      return org.sireum.lang.ast.ResolvedInfo.Package(name)
    }

    def read_astResolvedInfoEnum(): org.sireum.lang.ast.ResolvedInfo.Enum = {
      val r = read_astResolvedInfoEnumT(F)
      return r
    }

    def read_astResolvedInfoEnumT(typeParsed: B): org.sireum.lang.ast.ResolvedInfo.Enum = {
      if (!typeParsed) {
        reader.expectZ(Constants._astResolvedInfoEnum)
      }
      val name = reader.readISZ(reader.readString _)
      return org.sireum.lang.ast.ResolvedInfo.Enum(name)
    }

    def read_astResolvedInfoEnumElement(): org.sireum.lang.ast.ResolvedInfo.EnumElement = {
      val r = read_astResolvedInfoEnumElementT(F)
      return r
    }

    def read_astResolvedInfoEnumElementT(typeParsed: B): org.sireum.lang.ast.ResolvedInfo.EnumElement = {
      if (!typeParsed) {
        reader.expectZ(Constants._astResolvedInfoEnumElement)
      }
      val owner = reader.readISZ(reader.readString _)
      val name = reader.readString()
      val ordinal = reader.readZ()
      return org.sireum.lang.ast.ResolvedInfo.EnumElement(owner, name, ordinal)
    }

    def read_astResolvedInfoObject(): org.sireum.lang.ast.ResolvedInfo.Object = {
      val r = read_astResolvedInfoObjectT(F)
      return r
    }

    def read_astResolvedInfoObjectT(typeParsed: B): org.sireum.lang.ast.ResolvedInfo.Object = {
      if (!typeParsed) {
        reader.expectZ(Constants._astResolvedInfoObject)
      }
      val name = reader.readISZ(reader.readString _)
      return org.sireum.lang.ast.ResolvedInfo.Object(name)
    }

    def read_astResolvedInfoVar(): org.sireum.lang.ast.ResolvedInfo.Var = {
      val r = read_astResolvedInfoVarT(F)
      return r
    }

    def read_astResolvedInfoVarT(typeParsed: B): org.sireum.lang.ast.ResolvedInfo.Var = {
      if (!typeParsed) {
        reader.expectZ(Constants._astResolvedInfoVar)
      }
      val isInObject = reader.readB()
      val isSpec = reader.readB()
      val owner = reader.readISZ(reader.readString _)
      val id = reader.readString()
      return org.sireum.lang.ast.ResolvedInfo.Var(isInObject, isSpec, owner, id)
    }

    def read_astResolvedInfoMethod(): org.sireum.lang.ast.ResolvedInfo.Method = {
      val r = read_astResolvedInfoMethodT(F)
      return r
    }

    def read_astResolvedInfoMethodT(typeParsed: B): org.sireum.lang.ast.ResolvedInfo.Method = {
      if (!typeParsed) {
        reader.expectZ(Constants._astResolvedInfoMethod)
      }
      val isInObject = reader.readB()
      val mode = read_astMethodModeType()
      val typeParams = reader.readISZ(reader.readString _)
      val owner = reader.readISZ(reader.readString _)
      val name = reader.readString()
      val paramNames = reader.readISZ(reader.readString _)
      val tpeOpt = reader.readOption(read_astTypedFun _)
      return org.sireum.lang.ast.ResolvedInfo.Method(isInObject, mode, typeParams, owner, name, paramNames, tpeOpt)
    }

    def read_astResolvedInfoMethods(): org.sireum.lang.ast.ResolvedInfo.Methods = {
      val r = read_astResolvedInfoMethodsT(F)
      return r
    }

    def read_astResolvedInfoMethodsT(typeParsed: B): org.sireum.lang.ast.ResolvedInfo.Methods = {
      if (!typeParsed) {
        reader.expectZ(Constants._astResolvedInfoMethods)
      }
      val methods = reader.readISZ(read_astResolvedInfoMethod _)
      return org.sireum.lang.ast.ResolvedInfo.Methods(methods)
    }

    def read_astResolvedInfoType(): org.sireum.lang.ast.ResolvedInfo.Type = {
      val r = read_astResolvedInfoTypeT(F)
      return r
    }

    def read_astResolvedInfoTypeT(typeParsed: B): org.sireum.lang.ast.ResolvedInfo.Type = {
      if (!typeParsed) {
        reader.expectZ(Constants._astResolvedInfoType)
      }
      val name = reader.readISZ(reader.readString _)
      return org.sireum.lang.ast.ResolvedInfo.Type(name)
    }

    def read_astResolvedInfoTuple(): org.sireum.lang.ast.ResolvedInfo.Tuple = {
      val r = read_astResolvedInfoTupleT(F)
      return r
    }

    def read_astResolvedInfoTupleT(typeParsed: B): org.sireum.lang.ast.ResolvedInfo.Tuple = {
      if (!typeParsed) {
        reader.expectZ(Constants._astResolvedInfoTuple)
      }
      val size = reader.readZ()
      val index = reader.readZ()
      return org.sireum.lang.ast.ResolvedInfo.Tuple(size, index)
    }

    def read_astResolvedInfoLocalVar(): org.sireum.lang.ast.ResolvedInfo.LocalVar = {
      val r = read_astResolvedInfoLocalVarT(F)
      return r
    }

    def read_astResolvedInfoLocalVarT(typeParsed: B): org.sireum.lang.ast.ResolvedInfo.LocalVar = {
      if (!typeParsed) {
        reader.expectZ(Constants._astResolvedInfoLocalVar)
      }
      val context = reader.readISZ(reader.readString _)
      val id = reader.readString()
      return org.sireum.lang.ast.ResolvedInfo.LocalVar(context, id)
    }

    def read_astProofStep(): org.sireum.lang.ast.ProofStep = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._astProofStepBasic => val r = read_astProofStepBasicT(T); return r
        case Constants._astProofStepSubProof => val r = read_astProofStepSubProofT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.ast.ProofStep.")
          val r = read_astProofStepSubProofT(T)
          return r
      }
    }

    def read_astProofStepBasic(): org.sireum.lang.ast.ProofStep.Basic = {
      val r = read_astProofStepBasicT(F)
      return r
    }

    def read_astProofStepBasicT(typeParsed: B): org.sireum.lang.ast.ProofStep.Basic = {
      if (!typeParsed) {
        reader.expectZ(Constants._astProofStepBasic)
      }
      val step = read_astExpLitZ()
      val exp = read_astExp()
      val just = read_astJust()
      return org.sireum.lang.ast.ProofStep.Basic(step, exp, just)
    }

    def read_astProofStepSubProof(): org.sireum.lang.ast.ProofStep.SubProof = {
      val r = read_astProofStepSubProofT(F)
      return r
    }

    def read_astProofStepSubProofT(typeParsed: B): org.sireum.lang.ast.ProofStep.SubProof = {
      if (!typeParsed) {
        reader.expectZ(Constants._astProofStepSubProof)
      }
      val step = read_astExpLitZ()
      val assumeStep = read_astAssumeProofStep()
      val steps = reader.readISZ(read_astProofStep _)
      return org.sireum.lang.ast.ProofStep.SubProof(step, assumeStep, steps)
    }

    def read_astAssumeProofStep(): org.sireum.lang.ast.AssumeProofStep = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._astAssumeProofStepRegular => val r = read_astAssumeProofStepRegularT(T); return r
        case Constants._astAssumeProofStepForallIntroAps => val r = read_astAssumeProofStepForallIntroApsT(T); return r
        case Constants._astAssumeProofStepExistsElimAps => val r = read_astAssumeProofStepExistsElimApsT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.ast.AssumeProofStep.")
          val r = read_astAssumeProofStepExistsElimApsT(T)
          return r
      }
    }

    def read_astAssumeProofStepRegular(): org.sireum.lang.ast.AssumeProofStep.Regular = {
      val r = read_astAssumeProofStepRegularT(F)
      return r
    }

    def read_astAssumeProofStepRegularT(typeParsed: B): org.sireum.lang.ast.AssumeProofStep.Regular = {
      if (!typeParsed) {
        reader.expectZ(Constants._astAssumeProofStepRegular)
      }
      val step = read_astExpLitZ()
      val exp = read_astExp()
      return org.sireum.lang.ast.AssumeProofStep.Regular(step, exp)
    }

    def read_astAssumeProofStepForallIntroAps(): org.sireum.lang.ast.AssumeProofStep.ForallIntroAps = {
      val r = read_astAssumeProofStepForallIntroApsT(F)
      return r
    }

    def read_astAssumeProofStepForallIntroApsT(typeParsed: B): org.sireum.lang.ast.AssumeProofStep.ForallIntroAps = {
      if (!typeParsed) {
        reader.expectZ(Constants._astAssumeProofStepForallIntroAps)
      }
      val step = read_astExpLitZ()
      val varFragments = reader.readISZ(read_astVarFragment _)
      return org.sireum.lang.ast.AssumeProofStep.ForallIntroAps(step, varFragments)
    }

    def read_astAssumeProofStepExistsElimAps(): org.sireum.lang.ast.AssumeProofStep.ExistsElimAps = {
      val r = read_astAssumeProofStepExistsElimApsT(F)
      return r
    }

    def read_astAssumeProofStepExistsElimApsT(typeParsed: B): org.sireum.lang.ast.AssumeProofStep.ExistsElimAps = {
      if (!typeParsed) {
        reader.expectZ(Constants._astAssumeProofStepExistsElimAps)
      }
      val step = read_astExpLitZ()
      val varFragments = reader.readISZ(read_astVarFragment _)
      val exp = read_astExp()
      return org.sireum.lang.ast.AssumeProofStep.ExistsElimAps(step, varFragments, exp)
    }

    def read_astJust(): org.sireum.lang.ast.Just = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._astJustPremise => val r = read_astJustPremiseT(T); return r
        case Constants._astJustAuto => val r = read_astJustAutoT(T); return r
        case Constants._astJustCoq => val r = read_astJustCoqT(T); return r
        case Constants._astJustSubst => val r = read_astJustSubstT(T); return r
        case Constants._astJustInvariant => val r = read_astJustInvariantT(T); return r
        case Constants._astJustFact => val r = read_astJustFactT(T); return r
        case Constants._astJustImplyIntro => val r = read_astJustImplyIntroT(T); return r
        case Constants._astJustImplyElim => val r = read_astJustImplyElimT(T); return r
        case Constants._astJustNegIntro => val r = read_astJustNegIntroT(T); return r
        case Constants._astJustNegElim => val r = read_astJustNegElimT(T); return r
        case Constants._astJustBottomElim => val r = read_astJustBottomElimT(T); return r
        case Constants._astJustForallIntro => val r = read_astJustForallIntroT(T); return r
        case Constants._astJustForallElim => val r = read_astJustForallElimT(T); return r
        case Constants._astJustExistsIntro => val r = read_astJustExistsIntroT(T); return r
        case Constants._astJustExistsElim => val r = read_astJustExistsElimT(T); return r
        case Constants._astJustOrIntro => val r = read_astJustOrIntroT(T); return r
        case Constants._astJustOrElim => val r = read_astJustOrElimT(T); return r
        case Constants._astJustAndIntro => val r = read_astJustAndIntroT(T); return r
        case Constants._astJustAndElim => val r = read_astJustAndElimT(T); return r
        case Constants._astJustPbc => val r = read_astJustPbcT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.ast.Just.")
          val r = read_astJustPbcT(T)
          return r
      }
    }

    def read_astJustPremise(): org.sireum.lang.ast.Just.Premise = {
      val r = read_astJustPremiseT(F)
      return r
    }

    def read_astJustPremiseT(typeParsed: B): org.sireum.lang.ast.Just.Premise = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustPremise)
      }
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.Premise(attr)
    }

    def read_astJustAuto(): org.sireum.lang.ast.Just.Auto = {
      val r = read_astJustAutoT(F)
      return r
    }

    def read_astJustAutoT(typeParsed: B): org.sireum.lang.ast.Just.Auto = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustAuto)
      }
      val isAlgebra = reader.readB()
      val steps = reader.readISZ(read_astExpLitZ _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.Auto(isAlgebra, steps, attr)
    }

    def read_astJustCoq(): org.sireum.lang.ast.Just.Coq = {
      val r = read_astJustCoqT(F)
      return r
    }

    def read_astJustCoqT(typeParsed: B): org.sireum.lang.ast.Just.Coq = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustCoq)
      }
      val path = read_astExpLitString()
      val steps = reader.readISZ(read_astExpLitZ _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.Coq(path, steps, attr)
    }

    def read_astJustSubst(): org.sireum.lang.ast.Just.Subst = {
      val r = read_astJustSubstT(F)
      return r
    }

    def read_astJustSubstT(typeParsed: B): org.sireum.lang.ast.Just.Subst = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustSubst)
      }
      val isRight = reader.readB()
      val eqStep = read_astExpLitZ()
      val step = read_astExpLitZ()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.Subst(isRight, eqStep, step, attr)
    }

    def read_astJustInvariant(): org.sireum.lang.ast.Just.Invariant = {
      val r = read_astJustInvariantT(F)
      return r
    }

    def read_astJustInvariantT(typeParsed: B): org.sireum.lang.ast.Just.Invariant = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustInvariant)
      }
      val nameOpt = reader.readOption(read_astName _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.Invariant(nameOpt, attr)
    }

    def read_astJustFact(): org.sireum.lang.ast.Just.Fact = {
      val r = read_astJustFactT(F)
      return r
    }

    def read_astJustFactT(typeParsed: B): org.sireum.lang.ast.Just.Fact = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustFact)
      }
      val name = read_astName()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.Fact(name, attr)
    }

    def read_astJustImplyIntro(): org.sireum.lang.ast.Just.ImplyIntro = {
      val r = read_astJustImplyIntroT(F)
      return r
    }

    def read_astJustImplyIntroT(typeParsed: B): org.sireum.lang.ast.Just.ImplyIntro = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustImplyIntro)
      }
      val subProofStep = read_astExpLitZ()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.ImplyIntro(subProofStep, attr)
    }

    def read_astJustImplyElim(): org.sireum.lang.ast.Just.ImplyElim = {
      val r = read_astJustImplyElimT(F)
      return r
    }

    def read_astJustImplyElimT(typeParsed: B): org.sireum.lang.ast.Just.ImplyElim = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustImplyElim)
      }
      val implyStep = read_astExpLitZ()
      val steps = reader.readISZ(read_astExpLitZ _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.ImplyElim(implyStep, steps, attr)
    }

    def read_astJustNegIntro(): org.sireum.lang.ast.Just.NegIntro = {
      val r = read_astJustNegIntroT(F)
      return r
    }

    def read_astJustNegIntroT(typeParsed: B): org.sireum.lang.ast.Just.NegIntro = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustNegIntro)
      }
      val subProofStep = read_astExpLitZ()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.NegIntro(subProofStep, attr)
    }

    def read_astJustNegElim(): org.sireum.lang.ast.Just.NegElim = {
      val r = read_astJustNegElimT(F)
      return r
    }

    def read_astJustNegElimT(typeParsed: B): org.sireum.lang.ast.Just.NegElim = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustNegElim)
      }
      val step = read_astExpLitZ()
      val negStep = read_astExpLitZ()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.NegElim(step, negStep, attr)
    }

    def read_astJustBottomElim(): org.sireum.lang.ast.Just.BottomElim = {
      val r = read_astJustBottomElimT(F)
      return r
    }

    def read_astJustBottomElimT(typeParsed: B): org.sireum.lang.ast.Just.BottomElim = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustBottomElim)
      }
      val subProofStep = read_astExpLitZ()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.BottomElim(subProofStep, attr)
    }

    def read_astJustForallIntro(): org.sireum.lang.ast.Just.ForallIntro = {
      val r = read_astJustForallIntroT(F)
      return r
    }

    def read_astJustForallIntroT(typeParsed: B): org.sireum.lang.ast.Just.ForallIntro = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustForallIntro)
      }
      val subProofStep = read_astExpLitZ()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.ForallIntro(subProofStep, attr)
    }

    def read_astJustForallElim(): org.sireum.lang.ast.Just.ForallElim = {
      val r = read_astJustForallElimT(F)
      return r
    }

    def read_astJustForallElimT(typeParsed: B): org.sireum.lang.ast.Just.ForallElim = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustForallElim)
      }
      val forallStep = read_astExpLitZ()
      val args = reader.readISZ(read_astExp _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.ForallElim(forallStep, args, attr)
    }

    def read_astJustExistsIntro(): org.sireum.lang.ast.Just.ExistsIntro = {
      val r = read_astJustExistsIntroT(F)
      return r
    }

    def read_astJustExistsIntroT(typeParsed: B): org.sireum.lang.ast.Just.ExistsIntro = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustExistsIntro)
      }
      val existsStep = read_astExpLitZ()
      val args = reader.readISZ(read_astExp _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.ExistsIntro(existsStep, args, attr)
    }

    def read_astJustExistsElim(): org.sireum.lang.ast.Just.ExistsElim = {
      val r = read_astJustExistsElimT(F)
      return r
    }

    def read_astJustExistsElimT(typeParsed: B): org.sireum.lang.ast.Just.ExistsElim = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustExistsElim)
      }
      val existsStep = read_astExpLitZ()
      val subProofStep = read_astExpLitZ()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.ExistsElim(existsStep, subProofStep, attr)
    }

    def read_astJustOrIntro(): org.sireum.lang.ast.Just.OrIntro = {
      val r = read_astJustOrIntroT(F)
      return r
    }

    def read_astJustOrIntroT(typeParsed: B): org.sireum.lang.ast.Just.OrIntro = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustOrIntro)
      }
      val is1 = reader.readB()
      val step = read_astExpLitZ()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.OrIntro(is1, step, attr)
    }

    def read_astJustOrElim(): org.sireum.lang.ast.Just.OrElim = {
      val r = read_astJustOrElimT(F)
      return r
    }

    def read_astJustOrElimT(typeParsed: B): org.sireum.lang.ast.Just.OrElim = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustOrElim)
      }
      val orStep = read_astExpLitZ()
      val subProofSteps = reader.readISZ(read_astExpLitZ _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.OrElim(orStep, subProofSteps, attr)
    }

    def read_astJustAndIntro(): org.sireum.lang.ast.Just.AndIntro = {
      val r = read_astJustAndIntroT(F)
      return r
    }

    def read_astJustAndIntroT(typeParsed: B): org.sireum.lang.ast.Just.AndIntro = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustAndIntro)
      }
      val steps = reader.readISZ(read_astExpLitZ _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.AndIntro(steps, attr)
    }

    def read_astJustAndElim(): org.sireum.lang.ast.Just.AndElim = {
      val r = read_astJustAndElimT(F)
      return r
    }

    def read_astJustAndElimT(typeParsed: B): org.sireum.lang.ast.Just.AndElim = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustAndElim)
      }
      val is1 = reader.readB()
      val andStep = read_astExpLitZ()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.AndElim(is1, andStep, attr)
    }

    def read_astJustPbc(): org.sireum.lang.ast.Just.Pbc = {
      val r = read_astJustPbcT(F)
      return r
    }

    def read_astJustPbcT(typeParsed: B): org.sireum.lang.ast.Just.Pbc = {
      if (!typeParsed) {
        reader.expectZ(Constants._astJustPbc)
      }
      val subProofStep = read_astExpLitZ()
      val attr = read_astAttr()
      return org.sireum.lang.ast.Just.Pbc(subProofStep, attr)
    }

    def read_astTruthTableRow(): org.sireum.lang.ast.TruthTable.Row = {
      val r = read_astTruthTableRowT(F)
      return r
    }

    def read_astTruthTableRowT(typeParsed: B): org.sireum.lang.ast.TruthTable.Row = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTruthTableRow)
      }
      val assignment = read_astTruthTableAssignment()
      val separator = reader.readPosition()
      val values = read_astTruthTableAssignment()
      return org.sireum.lang.ast.TruthTable.Row(assignment, separator, values)
    }

    def read_astTruthTableAssignment(): org.sireum.lang.ast.TruthTable.Assignment = {
      val r = read_astTruthTableAssignmentT(F)
      return r
    }

    def read_astTruthTableAssignmentT(typeParsed: B): org.sireum.lang.ast.TruthTable.Assignment = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTruthTableAssignment)
      }
      val values = reader.readISZ(read_astExpLitB _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.TruthTable.Assignment(values, attr)
    }

    def read_astTruthTableConclusion(): org.sireum.lang.ast.TruthTable.Conclusion = {
      val i = reader.curr
      val t = reader.readZ()
      t match {
        case Constants._astTruthTableConclusionValidity => val r = read_astTruthTableConclusionValidityT(T); return r
        case Constants._astTruthTableConclusionTautology => val r = read_astTruthTableConclusionTautologyT(T); return r
        case Constants._astTruthTableConclusionContradictory => val r = read_astTruthTableConclusionContradictoryT(T); return r
        case Constants._astTruthTableConclusionContingent => val r = read_astTruthTableConclusionContingentT(T); return r
        case _ =>
          reader.error(i, s"$t is not a valid type of org.sireum.lang.ast.TruthTable.Conclusion.")
          val r = read_astTruthTableConclusionContingentT(T)
          return r
      }
    }

    def read_astTruthTableConclusionValidity(): org.sireum.lang.ast.TruthTable.Conclusion.Validity = {
      val r = read_astTruthTableConclusionValidityT(F)
      return r
    }

    def read_astTruthTableConclusionValidityT(typeParsed: B): org.sireum.lang.ast.TruthTable.Conclusion.Validity = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTruthTableConclusionValidity)
      }
      val isValid = reader.readB()
      val assignments = reader.readISZ(read_astTruthTableAssignment _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.TruthTable.Conclusion.Validity(isValid, assignments, attr)
    }

    def read_astTruthTableConclusionTautology(): org.sireum.lang.ast.TruthTable.Conclusion.Tautology = {
      val r = read_astTruthTableConclusionTautologyT(F)
      return r
    }

    def read_astTruthTableConclusionTautologyT(typeParsed: B): org.sireum.lang.ast.TruthTable.Conclusion.Tautology = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTruthTableConclusionTautology)
      }
      val attr = read_astAttr()
      return org.sireum.lang.ast.TruthTable.Conclusion.Tautology(attr)
    }

    def read_astTruthTableConclusionContradictory(): org.sireum.lang.ast.TruthTable.Conclusion.Contradictory = {
      val r = read_astTruthTableConclusionContradictoryT(F)
      return r
    }

    def read_astTruthTableConclusionContradictoryT(typeParsed: B): org.sireum.lang.ast.TruthTable.Conclusion.Contradictory = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTruthTableConclusionContradictory)
      }
      val attr = read_astAttr()
      return org.sireum.lang.ast.TruthTable.Conclusion.Contradictory(attr)
    }

    def read_astTruthTableConclusionContingent(): org.sireum.lang.ast.TruthTable.Conclusion.Contingent = {
      val r = read_astTruthTableConclusionContingentT(F)
      return r
    }

    def read_astTruthTableConclusionContingentT(typeParsed: B): org.sireum.lang.ast.TruthTable.Conclusion.Contingent = {
      if (!typeParsed) {
        reader.expectZ(Constants._astTruthTableConclusionContingent)
      }
      val trueAssignments = reader.readISZ(read_astTruthTableAssignment _)
      val falseAssignments = reader.readISZ(read_astTruthTableAssignment _)
      val attr = read_astAttr()
      return org.sireum.lang.ast.TruthTable.Conclusion.Contingent(trueAssignments, falseAssignments, attr)
    }

  }

  def to[T](data: ISZ[U8], f: Reader => T): Either[T, MessagePack.ErrorMsg] = {
    val rd = Reader.Default(MessagePack.reader(data))
    rd.reader.init()
    val r = f(rd)
    rd.errorOpt match {
      case Some(e) => return Either.Right(e)
      case _ => return Either.Left(r)
    }
  }

  def from_symbolScope(o: org.sireum.lang.symbol.Scope, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolScope(o)
    return w.result
  }

  def to_symbolScope(data: ISZ[U8]): Either[org.sireum.lang.symbol.Scope, MessagePack.ErrorMsg] = {
    def f_symbolScope(reader: Reader): org.sireum.lang.symbol.Scope = {
      val r = reader.read_symbolScope()
      return r
    }
    val r = to(data, f_symbolScope _)
    return r
  }

  def from_symbolScopeLocal(o: org.sireum.lang.symbol.Scope.Local, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolScopeLocal(o)
    return w.result
  }

  def to_symbolScopeLocal(data: ISZ[U8]): Either[org.sireum.lang.symbol.Scope.Local, MessagePack.ErrorMsg] = {
    def f_symbolScopeLocal(reader: Reader): org.sireum.lang.symbol.Scope.Local = {
      val r = reader.read_symbolScopeLocal()
      return r
    }
    val r = to(data, f_symbolScopeLocal _)
    return r
  }

  def from_symbolScopeGlobal(o: org.sireum.lang.symbol.Scope.Global, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolScopeGlobal(o)
    return w.result
  }

  def to_symbolScopeGlobal(data: ISZ[U8]): Either[org.sireum.lang.symbol.Scope.Global, MessagePack.ErrorMsg] = {
    def f_symbolScopeGlobal(reader: Reader): org.sireum.lang.symbol.Scope.Global = {
      val r = reader.read_symbolScopeGlobal()
      return r
    }
    val r = to(data, f_symbolScopeGlobal _)
    return r
  }

  def from_symbolInfo(o: org.sireum.lang.symbol.Info, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolInfo(o)
    return w.result
  }

  def to_symbolInfo(data: ISZ[U8]): Either[org.sireum.lang.symbol.Info, MessagePack.ErrorMsg] = {
    def f_symbolInfo(reader: Reader): org.sireum.lang.symbol.Info = {
      val r = reader.read_symbolInfo()
      return r
    }
    val r = to(data, f_symbolInfo _)
    return r
  }

  def from_symbolInfoPackage(o: org.sireum.lang.symbol.Info.Package, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolInfoPackage(o)
    return w.result
  }

  def to_symbolInfoPackage(data: ISZ[U8]): Either[org.sireum.lang.symbol.Info.Package, MessagePack.ErrorMsg] = {
    def f_symbolInfoPackage(reader: Reader): org.sireum.lang.symbol.Info.Package = {
      val r = reader.read_symbolInfoPackage()
      return r
    }
    val r = to(data, f_symbolInfoPackage _)
    return r
  }

  def from_symbolInfoVar(o: org.sireum.lang.symbol.Info.Var, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolInfoVar(o)
    return w.result
  }

  def to_symbolInfoVar(data: ISZ[U8]): Either[org.sireum.lang.symbol.Info.Var, MessagePack.ErrorMsg] = {
    def f_symbolInfoVar(reader: Reader): org.sireum.lang.symbol.Info.Var = {
      val r = reader.read_symbolInfoVar()
      return r
    }
    val r = to(data, f_symbolInfoVar _)
    return r
  }

  def from_symbolInfoSpecVar(o: org.sireum.lang.symbol.Info.SpecVar, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolInfoSpecVar(o)
    return w.result
  }

  def to_symbolInfoSpecVar(data: ISZ[U8]): Either[org.sireum.lang.symbol.Info.SpecVar, MessagePack.ErrorMsg] = {
    def f_symbolInfoSpecVar(reader: Reader): org.sireum.lang.symbol.Info.SpecVar = {
      val r = reader.read_symbolInfoSpecVar()
      return r
    }
    val r = to(data, f_symbolInfoSpecVar _)
    return r
  }

  def from_symbolInfoMethod(o: org.sireum.lang.symbol.Info.Method, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolInfoMethod(o)
    return w.result
  }

  def to_symbolInfoMethod(data: ISZ[U8]): Either[org.sireum.lang.symbol.Info.Method, MessagePack.ErrorMsg] = {
    def f_symbolInfoMethod(reader: Reader): org.sireum.lang.symbol.Info.Method = {
      val r = reader.read_symbolInfoMethod()
      return r
    }
    val r = to(data, f_symbolInfoMethod _)
    return r
  }

  def from_symbolInfoSpecMethod(o: org.sireum.lang.symbol.Info.SpecMethod, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolInfoSpecMethod(o)
    return w.result
  }

  def to_symbolInfoSpecMethod(data: ISZ[U8]): Either[org.sireum.lang.symbol.Info.SpecMethod, MessagePack.ErrorMsg] = {
    def f_symbolInfoSpecMethod(reader: Reader): org.sireum.lang.symbol.Info.SpecMethod = {
      val r = reader.read_symbolInfoSpecMethod()
      return r
    }
    val r = to(data, f_symbolInfoSpecMethod _)
    return r
  }

  def from_symbolInfoObject(o: org.sireum.lang.symbol.Info.Object, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolInfoObject(o)
    return w.result
  }

  def to_symbolInfoObject(data: ISZ[U8]): Either[org.sireum.lang.symbol.Info.Object, MessagePack.ErrorMsg] = {
    def f_symbolInfoObject(reader: Reader): org.sireum.lang.symbol.Info.Object = {
      val r = reader.read_symbolInfoObject()
      return r
    }
    val r = to(data, f_symbolInfoObject _)
    return r
  }

  def from_symbolInfoExtMethod(o: org.sireum.lang.symbol.Info.ExtMethod, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolInfoExtMethod(o)
    return w.result
  }

  def to_symbolInfoExtMethod(data: ISZ[U8]): Either[org.sireum.lang.symbol.Info.ExtMethod, MessagePack.ErrorMsg] = {
    def f_symbolInfoExtMethod(reader: Reader): org.sireum.lang.symbol.Info.ExtMethod = {
      val r = reader.read_symbolInfoExtMethod()
      return r
    }
    val r = to(data, f_symbolInfoExtMethod _)
    return r
  }

  def from_symbolInfoEnum(o: org.sireum.lang.symbol.Info.Enum, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolInfoEnum(o)
    return w.result
  }

  def to_symbolInfoEnum(data: ISZ[U8]): Either[org.sireum.lang.symbol.Info.Enum, MessagePack.ErrorMsg] = {
    def f_symbolInfoEnum(reader: Reader): org.sireum.lang.symbol.Info.Enum = {
      val r = reader.read_symbolInfoEnum()
      return r
    }
    val r = to(data, f_symbolInfoEnum _)
    return r
  }

  def from_symbolInfoEnumElement(o: org.sireum.lang.symbol.Info.EnumElement, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolInfoEnumElement(o)
    return w.result
  }

  def to_symbolInfoEnumElement(data: ISZ[U8]): Either[org.sireum.lang.symbol.Info.EnumElement, MessagePack.ErrorMsg] = {
    def f_symbolInfoEnumElement(reader: Reader): org.sireum.lang.symbol.Info.EnumElement = {
      val r = reader.read_symbolInfoEnumElement()
      return r
    }
    val r = to(data, f_symbolInfoEnumElement _)
    return r
  }

  def from_symbolInfoLocalVar(o: org.sireum.lang.symbol.Info.LocalVar, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolInfoLocalVar(o)
    return w.result
  }

  def to_symbolInfoLocalVar(data: ISZ[U8]): Either[org.sireum.lang.symbol.Info.LocalVar, MessagePack.ErrorMsg] = {
    def f_symbolInfoLocalVar(reader: Reader): org.sireum.lang.symbol.Info.LocalVar = {
      val r = reader.read_symbolInfoLocalVar()
      return r
    }
    val r = to(data, f_symbolInfoLocalVar _)
    return r
  }

  def from_symbolInfoQuantVar(o: org.sireum.lang.symbol.Info.QuantVar, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolInfoQuantVar(o)
    return w.result
  }

  def to_symbolInfoQuantVar(data: ISZ[U8]): Either[org.sireum.lang.symbol.Info.QuantVar, MessagePack.ErrorMsg] = {
    def f_symbolInfoQuantVar(reader: Reader): org.sireum.lang.symbol.Info.QuantVar = {
      val r = reader.read_symbolInfoQuantVar()
      return r
    }
    val r = to(data, f_symbolInfoQuantVar _)
    return r
  }

  def from_symbolTypeInfo(o: org.sireum.lang.symbol.TypeInfo, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolTypeInfo(o)
    return w.result
  }

  def to_symbolTypeInfo(data: ISZ[U8]): Either[org.sireum.lang.symbol.TypeInfo, MessagePack.ErrorMsg] = {
    def f_symbolTypeInfo(reader: Reader): org.sireum.lang.symbol.TypeInfo = {
      val r = reader.read_symbolTypeInfo()
      return r
    }
    val r = to(data, f_symbolTypeInfo _)
    return r
  }

  def from_symbolTypeInfoSubZ(o: org.sireum.lang.symbol.TypeInfo.SubZ, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolTypeInfoSubZ(o)
    return w.result
  }

  def to_symbolTypeInfoSubZ(data: ISZ[U8]): Either[org.sireum.lang.symbol.TypeInfo.SubZ, MessagePack.ErrorMsg] = {
    def f_symbolTypeInfoSubZ(reader: Reader): org.sireum.lang.symbol.TypeInfo.SubZ = {
      val r = reader.read_symbolTypeInfoSubZ()
      return r
    }
    val r = to(data, f_symbolTypeInfoSubZ _)
    return r
  }

  def from_symbolTypeInfoEnum(o: org.sireum.lang.symbol.TypeInfo.Enum, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolTypeInfoEnum(o)
    return w.result
  }

  def to_symbolTypeInfoEnum(data: ISZ[U8]): Either[org.sireum.lang.symbol.TypeInfo.Enum, MessagePack.ErrorMsg] = {
    def f_symbolTypeInfoEnum(reader: Reader): org.sireum.lang.symbol.TypeInfo.Enum = {
      val r = reader.read_symbolTypeInfoEnum()
      return r
    }
    val r = to(data, f_symbolTypeInfoEnum _)
    return r
  }

  def from_symbolTypeInfoSig(o: org.sireum.lang.symbol.TypeInfo.Sig, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolTypeInfoSig(o)
    return w.result
  }

  def to_symbolTypeInfoSig(data: ISZ[U8]): Either[org.sireum.lang.symbol.TypeInfo.Sig, MessagePack.ErrorMsg] = {
    def f_symbolTypeInfoSig(reader: Reader): org.sireum.lang.symbol.TypeInfo.Sig = {
      val r = reader.read_symbolTypeInfoSig()
      return r
    }
    val r = to(data, f_symbolTypeInfoSig _)
    return r
  }

  def from_symbolTypeInfoAbstractDatatype(o: org.sireum.lang.symbol.TypeInfo.AbstractDatatype, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolTypeInfoAbstractDatatype(o)
    return w.result
  }

  def to_symbolTypeInfoAbstractDatatype(data: ISZ[U8]): Either[org.sireum.lang.symbol.TypeInfo.AbstractDatatype, MessagePack.ErrorMsg] = {
    def f_symbolTypeInfoAbstractDatatype(reader: Reader): org.sireum.lang.symbol.TypeInfo.AbstractDatatype = {
      val r = reader.read_symbolTypeInfoAbstractDatatype()
      return r
    }
    val r = to(data, f_symbolTypeInfoAbstractDatatype _)
    return r
  }

  def from_symbolTypeInfoTypeAlias(o: org.sireum.lang.symbol.TypeInfo.TypeAlias, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolTypeInfoTypeAlias(o)
    return w.result
  }

  def to_symbolTypeInfoTypeAlias(data: ISZ[U8]): Either[org.sireum.lang.symbol.TypeInfo.TypeAlias, MessagePack.ErrorMsg] = {
    def f_symbolTypeInfoTypeAlias(reader: Reader): org.sireum.lang.symbol.TypeInfo.TypeAlias = {
      val r = reader.read_symbolTypeInfoTypeAlias()
      return r
    }
    val r = to(data, f_symbolTypeInfoTypeAlias _)
    return r
  }

  def from_symbolTypeInfoTypeVar(o: org.sireum.lang.symbol.TypeInfo.TypeVar, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolTypeInfoTypeVar(o)
    return w.result
  }

  def to_symbolTypeInfoTypeVar(data: ISZ[U8]): Either[org.sireum.lang.symbol.TypeInfo.TypeVar, MessagePack.ErrorMsg] = {
    def f_symbolTypeInfoTypeVar(reader: Reader): org.sireum.lang.symbol.TypeInfo.TypeVar = {
      val r = reader.read_symbolTypeInfoTypeVar()
      return r
    }
    val r = to(data, f_symbolTypeInfoTypeVar _)
    return r
  }

  def from_symbolTypeInfoMembers(o: org.sireum.lang.symbol.TypeInfo.Members, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_symbolTypeInfoMembers(o)
    return w.result
  }

  def to_symbolTypeInfoMembers(data: ISZ[U8]): Either[org.sireum.lang.symbol.TypeInfo.Members, MessagePack.ErrorMsg] = {
    def f_symbolTypeInfoMembers(reader: Reader): org.sireum.lang.symbol.TypeInfo.Members = {
      val r = reader.read_symbolTypeInfoMembers()
      return r
    }
    val r = to(data, f_symbolTypeInfoMembers _)
    return r
  }

  def from_astTopUnit(o: org.sireum.lang.ast.TopUnit, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTopUnit(o)
    return w.result
  }

  def to_astTopUnit(data: ISZ[U8]): Either[org.sireum.lang.ast.TopUnit, MessagePack.ErrorMsg] = {
    def f_astTopUnit(reader: Reader): org.sireum.lang.ast.TopUnit = {
      val r = reader.read_astTopUnit()
      return r
    }
    val r = to(data, f_astTopUnit _)
    return r
  }

  def from_astTopUnitProgram(o: org.sireum.lang.ast.TopUnit.Program, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTopUnitProgram(o)
    return w.result
  }

  def to_astTopUnitProgram(data: ISZ[U8]): Either[org.sireum.lang.ast.TopUnit.Program, MessagePack.ErrorMsg] = {
    def f_astTopUnitProgram(reader: Reader): org.sireum.lang.ast.TopUnit.Program = {
      val r = reader.read_astTopUnitProgram()
      return r
    }
    val r = to(data, f_astTopUnitProgram _)
    return r
  }

  def from_astTopUnitSequentUnit(o: org.sireum.lang.ast.TopUnit.SequentUnit, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTopUnitSequentUnit(o)
    return w.result
  }

  def to_astTopUnitSequentUnit(data: ISZ[U8]): Either[org.sireum.lang.ast.TopUnit.SequentUnit, MessagePack.ErrorMsg] = {
    def f_astTopUnitSequentUnit(reader: Reader): org.sireum.lang.ast.TopUnit.SequentUnit = {
      val r = reader.read_astTopUnitSequentUnit()
      return r
    }
    val r = to(data, f_astTopUnitSequentUnit _)
    return r
  }

  def from_astTopUnitTruthTableUnit(o: org.sireum.lang.ast.TopUnit.TruthTableUnit, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTopUnitTruthTableUnit(o)
    return w.result
  }

  def to_astTopUnitTruthTableUnit(data: ISZ[U8]): Either[org.sireum.lang.ast.TopUnit.TruthTableUnit, MessagePack.ErrorMsg] = {
    def f_astTopUnitTruthTableUnit(reader: Reader): org.sireum.lang.ast.TopUnit.TruthTableUnit = {
      val r = reader.read_astTopUnitTruthTableUnit()
      return r
    }
    val r = to(data, f_astTopUnitTruthTableUnit _)
    return r
  }

  def from_astStmt(o: org.sireum.lang.ast.Stmt, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmt(o)
    return w.result
  }

  def to_astStmt(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt, MessagePack.ErrorMsg] = {
    def f_astStmt(reader: Reader): org.sireum.lang.ast.Stmt = {
      val r = reader.read_astStmt()
      return r
    }
    val r = to(data, f_astStmt _)
    return r
  }

  def from_astStmtImport(o: org.sireum.lang.ast.Stmt.Import, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtImport(o)
    return w.result
  }

  def to_astStmtImport(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.Import, MessagePack.ErrorMsg] = {
    def f_astStmtImport(reader: Reader): org.sireum.lang.ast.Stmt.Import = {
      val r = reader.read_astStmtImport()
      return r
    }
    val r = to(data, f_astStmtImport _)
    return r
  }

  def from_astStmtImportImporter(o: org.sireum.lang.ast.Stmt.Import.Importer, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtImportImporter(o)
    return w.result
  }

  def to_astStmtImportImporter(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.Import.Importer, MessagePack.ErrorMsg] = {
    def f_astStmtImportImporter(reader: Reader): org.sireum.lang.ast.Stmt.Import.Importer = {
      val r = reader.read_astStmtImportImporter()
      return r
    }
    val r = to(data, f_astStmtImportImporter _)
    return r
  }

  def from_astStmtImportSelector(o: org.sireum.lang.ast.Stmt.Import.Selector, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtImportSelector(o)
    return w.result
  }

  def to_astStmtImportSelector(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.Import.Selector, MessagePack.ErrorMsg] = {
    def f_astStmtImportSelector(reader: Reader): org.sireum.lang.ast.Stmt.Import.Selector = {
      val r = reader.read_astStmtImportSelector()
      return r
    }
    val r = to(data, f_astStmtImportSelector _)
    return r
  }

  def from_astStmtImportMultiSelector(o: org.sireum.lang.ast.Stmt.Import.MultiSelector, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtImportMultiSelector(o)
    return w.result
  }

  def to_astStmtImportMultiSelector(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.Import.MultiSelector, MessagePack.ErrorMsg] = {
    def f_astStmtImportMultiSelector(reader: Reader): org.sireum.lang.ast.Stmt.Import.MultiSelector = {
      val r = reader.read_astStmtImportMultiSelector()
      return r
    }
    val r = to(data, f_astStmtImportMultiSelector _)
    return r
  }

  def from_astStmtImportWildcardSelector(o: org.sireum.lang.ast.Stmt.Import.WildcardSelector, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtImportWildcardSelector(o)
    return w.result
  }

  def to_astStmtImportWildcardSelector(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.Import.WildcardSelector, MessagePack.ErrorMsg] = {
    def f_astStmtImportWildcardSelector(reader: Reader): org.sireum.lang.ast.Stmt.Import.WildcardSelector = {
      val r = reader.read_astStmtImportWildcardSelector()
      return r
    }
    val r = to(data, f_astStmtImportWildcardSelector _)
    return r
  }

  def from_astStmtImportNamedSelector(o: org.sireum.lang.ast.Stmt.Import.NamedSelector, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtImportNamedSelector(o)
    return w.result
  }

  def to_astStmtImportNamedSelector(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.Import.NamedSelector, MessagePack.ErrorMsg] = {
    def f_astStmtImportNamedSelector(reader: Reader): org.sireum.lang.ast.Stmt.Import.NamedSelector = {
      val r = reader.read_astStmtImportNamedSelector()
      return r
    }
    val r = to(data, f_astStmtImportNamedSelector _)
    return r
  }

  def from_astStmtVar(o: org.sireum.lang.ast.Stmt.Var, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtVar(o)
    return w.result
  }

  def to_astStmtVar(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.Var, MessagePack.ErrorMsg] = {
    def f_astStmtVar(reader: Reader): org.sireum.lang.ast.Stmt.Var = {
      val r = reader.read_astStmtVar()
      return r
    }
    val r = to(data, f_astStmtVar _)
    return r
  }

  def from_astStmtVarPattern(o: org.sireum.lang.ast.Stmt.VarPattern, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtVarPattern(o)
    return w.result
  }

  def to_astStmtVarPattern(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.VarPattern, MessagePack.ErrorMsg] = {
    def f_astStmtVarPattern(reader: Reader): org.sireum.lang.ast.Stmt.VarPattern = {
      val r = reader.read_astStmtVarPattern()
      return r
    }
    val r = to(data, f_astStmtVarPattern _)
    return r
  }

  def from_astStmtSpecVar(o: org.sireum.lang.ast.Stmt.SpecVar, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtSpecVar(o)
    return w.result
  }

  def to_astStmtSpecVar(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.SpecVar, MessagePack.ErrorMsg] = {
    def f_astStmtSpecVar(reader: Reader): org.sireum.lang.ast.Stmt.SpecVar = {
      val r = reader.read_astStmtSpecVar()
      return r
    }
    val r = to(data, f_astStmtSpecVar _)
    return r
  }

  def from_astStmtMethod(o: org.sireum.lang.ast.Stmt.Method, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtMethod(o)
    return w.result
  }

  def to_astStmtMethod(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.Method, MessagePack.ErrorMsg] = {
    def f_astStmtMethod(reader: Reader): org.sireum.lang.ast.Stmt.Method = {
      val r = reader.read_astStmtMethod()
      return r
    }
    val r = to(data, f_astStmtMethod _)
    return r
  }

  def from_astStmtExtMethod(o: org.sireum.lang.ast.Stmt.ExtMethod, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtExtMethod(o)
    return w.result
  }

  def to_astStmtExtMethod(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.ExtMethod, MessagePack.ErrorMsg] = {
    def f_astStmtExtMethod(reader: Reader): org.sireum.lang.ast.Stmt.ExtMethod = {
      val r = reader.read_astStmtExtMethod()
      return r
    }
    val r = to(data, f_astStmtExtMethod _)
    return r
  }

  def from_astStmtSpecMethod(o: org.sireum.lang.ast.Stmt.SpecMethod, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtSpecMethod(o)
    return w.result
  }

  def to_astStmtSpecMethod(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.SpecMethod, MessagePack.ErrorMsg] = {
    def f_astStmtSpecMethod(reader: Reader): org.sireum.lang.ast.Stmt.SpecMethod = {
      val r = reader.read_astStmtSpecMethod()
      return r
    }
    val r = to(data, f_astStmtSpecMethod _)
    return r
  }

  def from_astStmtEnum(o: org.sireum.lang.ast.Stmt.Enum, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtEnum(o)
    return w.result
  }

  def to_astStmtEnum(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.Enum, MessagePack.ErrorMsg] = {
    def f_astStmtEnum(reader: Reader): org.sireum.lang.ast.Stmt.Enum = {
      val r = reader.read_astStmtEnum()
      return r
    }
    val r = to(data, f_astStmtEnum _)
    return r
  }

  def from_astStmtSubZ(o: org.sireum.lang.ast.Stmt.SubZ, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtSubZ(o)
    return w.result
  }

  def to_astStmtSubZ(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.SubZ, MessagePack.ErrorMsg] = {
    def f_astStmtSubZ(reader: Reader): org.sireum.lang.ast.Stmt.SubZ = {
      val r = reader.read_astStmtSubZ()
      return r
    }
    val r = to(data, f_astStmtSubZ _)
    return r
  }

  def from_astStmtObject(o: org.sireum.lang.ast.Stmt.Object, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtObject(o)
    return w.result
  }

  def to_astStmtObject(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.Object, MessagePack.ErrorMsg] = {
    def f_astStmtObject(reader: Reader): org.sireum.lang.ast.Stmt.Object = {
      val r = reader.read_astStmtObject()
      return r
    }
    val r = to(data, f_astStmtObject _)
    return r
  }

  def from_astStmtSig(o: org.sireum.lang.ast.Stmt.Sig, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtSig(o)
    return w.result
  }

  def to_astStmtSig(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.Sig, MessagePack.ErrorMsg] = {
    def f_astStmtSig(reader: Reader): org.sireum.lang.ast.Stmt.Sig = {
      val r = reader.read_astStmtSig()
      return r
    }
    val r = to(data, f_astStmtSig _)
    return r
  }

  def from_astStmtAbstractDatatype(o: org.sireum.lang.ast.Stmt.AbstractDatatype, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtAbstractDatatype(o)
    return w.result
  }

  def to_astStmtAbstractDatatype(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.AbstractDatatype, MessagePack.ErrorMsg] = {
    def f_astStmtAbstractDatatype(reader: Reader): org.sireum.lang.ast.Stmt.AbstractDatatype = {
      val r = reader.read_astStmtAbstractDatatype()
      return r
    }
    val r = to(data, f_astStmtAbstractDatatype _)
    return r
  }

  def from_astStmtTypeAlias(o: org.sireum.lang.ast.Stmt.TypeAlias, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtTypeAlias(o)
    return w.result
  }

  def to_astStmtTypeAlias(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.TypeAlias, MessagePack.ErrorMsg] = {
    def f_astStmtTypeAlias(reader: Reader): org.sireum.lang.ast.Stmt.TypeAlias = {
      val r = reader.read_astStmtTypeAlias()
      return r
    }
    val r = to(data, f_astStmtTypeAlias _)
    return r
  }

  def from_astStmtAssign(o: org.sireum.lang.ast.Stmt.Assign, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtAssign(o)
    return w.result
  }

  def to_astStmtAssign(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.Assign, MessagePack.ErrorMsg] = {
    def f_astStmtAssign(reader: Reader): org.sireum.lang.ast.Stmt.Assign = {
      val r = reader.read_astStmtAssign()
      return r
    }
    val r = to(data, f_astStmtAssign _)
    return r
  }

  def from_astStmtBlock(o: org.sireum.lang.ast.Stmt.Block, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtBlock(o)
    return w.result
  }

  def to_astStmtBlock(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.Block, MessagePack.ErrorMsg] = {
    def f_astStmtBlock(reader: Reader): org.sireum.lang.ast.Stmt.Block = {
      val r = reader.read_astStmtBlock()
      return r
    }
    val r = to(data, f_astStmtBlock _)
    return r
  }

  def from_astStmtIf(o: org.sireum.lang.ast.Stmt.If, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtIf(o)
    return w.result
  }

  def to_astStmtIf(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.If, MessagePack.ErrorMsg] = {
    def f_astStmtIf(reader: Reader): org.sireum.lang.ast.Stmt.If = {
      val r = reader.read_astStmtIf()
      return r
    }
    val r = to(data, f_astStmtIf _)
    return r
  }

  def from_astStmtMatch(o: org.sireum.lang.ast.Stmt.Match, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtMatch(o)
    return w.result
  }

  def to_astStmtMatch(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.Match, MessagePack.ErrorMsg] = {
    def f_astStmtMatch(reader: Reader): org.sireum.lang.ast.Stmt.Match = {
      val r = reader.read_astStmtMatch()
      return r
    }
    val r = to(data, f_astStmtMatch _)
    return r
  }

  def from_astStmtWhile(o: org.sireum.lang.ast.Stmt.While, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtWhile(o)
    return w.result
  }

  def to_astStmtWhile(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.While, MessagePack.ErrorMsg] = {
    def f_astStmtWhile(reader: Reader): org.sireum.lang.ast.Stmt.While = {
      val r = reader.read_astStmtWhile()
      return r
    }
    val r = to(data, f_astStmtWhile _)
    return r
  }

  def from_astStmtDoWhile(o: org.sireum.lang.ast.Stmt.DoWhile, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtDoWhile(o)
    return w.result
  }

  def to_astStmtDoWhile(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.DoWhile, MessagePack.ErrorMsg] = {
    def f_astStmtDoWhile(reader: Reader): org.sireum.lang.ast.Stmt.DoWhile = {
      val r = reader.read_astStmtDoWhile()
      return r
    }
    val r = to(data, f_astStmtDoWhile _)
    return r
  }

  def from_astStmtFor(o: org.sireum.lang.ast.Stmt.For, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtFor(o)
    return w.result
  }

  def to_astStmtFor(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.For, MessagePack.ErrorMsg] = {
    def f_astStmtFor(reader: Reader): org.sireum.lang.ast.Stmt.For = {
      val r = reader.read_astStmtFor()
      return r
    }
    val r = to(data, f_astStmtFor _)
    return r
  }

  def from_astStmtReturn(o: org.sireum.lang.ast.Stmt.Return, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtReturn(o)
    return w.result
  }

  def to_astStmtReturn(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.Return, MessagePack.ErrorMsg] = {
    def f_astStmtReturn(reader: Reader): org.sireum.lang.ast.Stmt.Return = {
      val r = reader.read_astStmtReturn()
      return r
    }
    val r = to(data, f_astStmtReturn _)
    return r
  }

  def from_astStmtLStmt(o: org.sireum.lang.ast.Stmt.LStmt, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtLStmt(o)
    return w.result
  }

  def to_astStmtLStmt(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.LStmt, MessagePack.ErrorMsg] = {
    def f_astStmtLStmt(reader: Reader): org.sireum.lang.ast.Stmt.LStmt = {
      val r = reader.read_astStmtLStmt()
      return r
    }
    val r = to(data, f_astStmtLStmt _)
    return r
  }

  def from_astStmtExpr(o: org.sireum.lang.ast.Stmt.Expr, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astStmtExpr(o)
    return w.result
  }

  def to_astStmtExpr(data: ISZ[U8]): Either[org.sireum.lang.ast.Stmt.Expr, MessagePack.ErrorMsg] = {
    def f_astStmtExpr(reader: Reader): org.sireum.lang.ast.Stmt.Expr = {
      val r = reader.read_astStmtExpr()
      return r
    }
    val r = to(data, f_astStmtExpr _)
    return r
  }

  def from_astAssignExp(o: org.sireum.lang.ast.AssignExp, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astAssignExp(o)
    return w.result
  }

  def to_astAssignExp(data: ISZ[U8]): Either[org.sireum.lang.ast.AssignExp, MessagePack.ErrorMsg] = {
    def f_astAssignExp(reader: Reader): org.sireum.lang.ast.AssignExp = {
      val r = reader.read_astAssignExp()
      return r
    }
    val r = to(data, f_astAssignExp _)
    return r
  }

  def from_astLClause(o: org.sireum.lang.ast.LClause, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astLClause(o)
    return w.result
  }

  def to_astLClause(data: ISZ[U8]): Either[org.sireum.lang.ast.LClause, MessagePack.ErrorMsg] = {
    def f_astLClause(reader: Reader): org.sireum.lang.ast.LClause = {
      val r = reader.read_astLClause()
      return r
    }
    val r = to(data, f_astLClause _)
    return r
  }

  def from_astLClauseInvariants(o: org.sireum.lang.ast.LClause.Invariants, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astLClauseInvariants(o)
    return w.result
  }

  def to_astLClauseInvariants(data: ISZ[U8]): Either[org.sireum.lang.ast.LClause.Invariants, MessagePack.ErrorMsg] = {
    def f_astLClauseInvariants(reader: Reader): org.sireum.lang.ast.LClause.Invariants = {
      val r = reader.read_astLClauseInvariants()
      return r
    }
    val r = to(data, f_astLClauseInvariants _)
    return r
  }

  def from_astLClauseFacts(o: org.sireum.lang.ast.LClause.Facts, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astLClauseFacts(o)
    return w.result
  }

  def to_astLClauseFacts(data: ISZ[U8]): Either[org.sireum.lang.ast.LClause.Facts, MessagePack.ErrorMsg] = {
    def f_astLClauseFacts(reader: Reader): org.sireum.lang.ast.LClause.Facts = {
      val r = reader.read_astLClauseFacts()
      return r
    }
    val r = to(data, f_astLClauseFacts _)
    return r
  }

  def from_astLClauseFact(o: org.sireum.lang.ast.LClause.Fact, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astLClauseFact(o)
    return w.result
  }

  def to_astLClauseFact(data: ISZ[U8]): Either[org.sireum.lang.ast.LClause.Fact, MessagePack.ErrorMsg] = {
    def f_astLClauseFact(reader: Reader): org.sireum.lang.ast.LClause.Fact = {
      val r = reader.read_astLClauseFact()
      return r
    }
    val r = to(data, f_astLClauseFact _)
    return r
  }

  def from_astLClauseTheorems(o: org.sireum.lang.ast.LClause.Theorems, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astLClauseTheorems(o)
    return w.result
  }

  def to_astLClauseTheorems(data: ISZ[U8]): Either[org.sireum.lang.ast.LClause.Theorems, MessagePack.ErrorMsg] = {
    def f_astLClauseTheorems(reader: Reader): org.sireum.lang.ast.LClause.Theorems = {
      val r = reader.read_astLClauseTheorems()
      return r
    }
    val r = to(data, f_astLClauseTheorems _)
    return r
  }

  def from_astLClauseTheorem(o: org.sireum.lang.ast.LClause.Theorem, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astLClauseTheorem(o)
    return w.result
  }

  def to_astLClauseTheorem(data: ISZ[U8]): Either[org.sireum.lang.ast.LClause.Theorem, MessagePack.ErrorMsg] = {
    def f_astLClauseTheorem(reader: Reader): org.sireum.lang.ast.LClause.Theorem = {
      val r = reader.read_astLClauseTheorem()
      return r
    }
    val r = to(data, f_astLClauseTheorem _)
    return r
  }

  def from_astLClauseSequent(o: org.sireum.lang.ast.LClause.Sequent, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astLClauseSequent(o)
    return w.result
  }

  def to_astLClauseSequent(data: ISZ[U8]): Either[org.sireum.lang.ast.LClause.Sequent, MessagePack.ErrorMsg] = {
    def f_astLClauseSequent(reader: Reader): org.sireum.lang.ast.LClause.Sequent = {
      val r = reader.read_astLClauseSequent()
      return r
    }
    val r = to(data, f_astLClauseSequent _)
    return r
  }

  def from_astLClauseProof(o: org.sireum.lang.ast.LClause.Proof, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astLClauseProof(o)
    return w.result
  }

  def to_astLClauseProof(data: ISZ[U8]): Either[org.sireum.lang.ast.LClause.Proof, MessagePack.ErrorMsg] = {
    def f_astLClauseProof(reader: Reader): org.sireum.lang.ast.LClause.Proof = {
      val r = reader.read_astLClauseProof()
      return r
    }
    val r = to(data, f_astLClauseProof _)
    return r
  }

  def from_astContractExp(o: org.sireum.lang.ast.ContractExp, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astContractExp(o)
    return w.result
  }

  def to_astContractExp(data: ISZ[U8]): Either[org.sireum.lang.ast.ContractExp, MessagePack.ErrorMsg] = {
    def f_astContractExp(reader: Reader): org.sireum.lang.ast.ContractExp = {
      val r = reader.read_astContractExp()
      return r
    }
    val r = to(data, f_astContractExp _)
    return r
  }

  def from_astCase(o: org.sireum.lang.ast.Case, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astCase(o)
    return w.result
  }

  def to_astCase(data: ISZ[U8]): Either[org.sireum.lang.ast.Case, MessagePack.ErrorMsg] = {
    def f_astCase(reader: Reader): org.sireum.lang.ast.Case = {
      val r = reader.read_astCase()
      return r
    }
    val r = to(data, f_astCase _)
    return r
  }

  def from_astEnumGenRange(o: org.sireum.lang.ast.EnumGen.Range, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astEnumGenRange(o)
    return w.result
  }

  def to_astEnumGenRange(data: ISZ[U8]): Either[org.sireum.lang.ast.EnumGen.Range, MessagePack.ErrorMsg] = {
    def f_astEnumGenRange(reader: Reader): org.sireum.lang.ast.EnumGen.Range = {
      val r = reader.read_astEnumGenRange()
      return r
    }
    val r = to(data, f_astEnumGenRange _)
    return r
  }

  def from_astEnumGenRangeExpr(o: org.sireum.lang.ast.EnumGen.Range.Expr, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astEnumGenRangeExpr(o)
    return w.result
  }

  def to_astEnumGenRangeExpr(data: ISZ[U8]): Either[org.sireum.lang.ast.EnumGen.Range.Expr, MessagePack.ErrorMsg] = {
    def f_astEnumGenRangeExpr(reader: Reader): org.sireum.lang.ast.EnumGen.Range.Expr = {
      val r = reader.read_astEnumGenRangeExpr()
      return r
    }
    val r = to(data, f_astEnumGenRangeExpr _)
    return r
  }

  def from_astEnumGenRangeStep(o: org.sireum.lang.ast.EnumGen.Range.Step, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astEnumGenRangeStep(o)
    return w.result
  }

  def to_astEnumGenRangeStep(data: ISZ[U8]): Either[org.sireum.lang.ast.EnumGen.Range.Step, MessagePack.ErrorMsg] = {
    def f_astEnumGenRangeStep(reader: Reader): org.sireum.lang.ast.EnumGen.Range.Step = {
      val r = reader.read_astEnumGenRangeStep()
      return r
    }
    val r = to(data, f_astEnumGenRangeStep _)
    return r
  }

  def from_astEnumGenFor(o: org.sireum.lang.ast.EnumGen.For, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astEnumGenFor(o)
    return w.result
  }

  def to_astEnumGenFor(data: ISZ[U8]): Either[org.sireum.lang.ast.EnumGen.For, MessagePack.ErrorMsg] = {
    def f_astEnumGenFor(reader: Reader): org.sireum.lang.ast.EnumGen.For = {
      val r = reader.read_astEnumGenFor()
      return r
    }
    val r = to(data, f_astEnumGenFor _)
    return r
  }

  def from_astType(o: org.sireum.lang.ast.Type, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astType(o)
    return w.result
  }

  def to_astType(data: ISZ[U8]): Either[org.sireum.lang.ast.Type, MessagePack.ErrorMsg] = {
    def f_astType(reader: Reader): org.sireum.lang.ast.Type = {
      val r = reader.read_astType()
      return r
    }
    val r = to(data, f_astType _)
    return r
  }

  def from_astTypeNamed(o: org.sireum.lang.ast.Type.Named, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTypeNamed(o)
    return w.result
  }

  def to_astTypeNamed(data: ISZ[U8]): Either[org.sireum.lang.ast.Type.Named, MessagePack.ErrorMsg] = {
    def f_astTypeNamed(reader: Reader): org.sireum.lang.ast.Type.Named = {
      val r = reader.read_astTypeNamed()
      return r
    }
    val r = to(data, f_astTypeNamed _)
    return r
  }

  def from_astTypeFun(o: org.sireum.lang.ast.Type.Fun, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTypeFun(o)
    return w.result
  }

  def to_astTypeFun(data: ISZ[U8]): Either[org.sireum.lang.ast.Type.Fun, MessagePack.ErrorMsg] = {
    def f_astTypeFun(reader: Reader): org.sireum.lang.ast.Type.Fun = {
      val r = reader.read_astTypeFun()
      return r
    }
    val r = to(data, f_astTypeFun _)
    return r
  }

  def from_astTypeTuple(o: org.sireum.lang.ast.Type.Tuple, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTypeTuple(o)
    return w.result
  }

  def to_astTypeTuple(data: ISZ[U8]): Either[org.sireum.lang.ast.Type.Tuple, MessagePack.ErrorMsg] = {
    def f_astTypeTuple(reader: Reader): org.sireum.lang.ast.Type.Tuple = {
      val r = reader.read_astTypeTuple()
      return r
    }
    val r = to(data, f_astTypeTuple _)
    return r
  }

  def from_astPattern(o: org.sireum.lang.ast.Pattern, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astPattern(o)
    return w.result
  }

  def to_astPattern(data: ISZ[U8]): Either[org.sireum.lang.ast.Pattern, MessagePack.ErrorMsg] = {
    def f_astPattern(reader: Reader): org.sireum.lang.ast.Pattern = {
      val r = reader.read_astPattern()
      return r
    }
    val r = to(data, f_astPattern _)
    return r
  }

  def from_astPatternLiteral(o: org.sireum.lang.ast.Pattern.Literal, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astPatternLiteral(o)
    return w.result
  }

  def to_astPatternLiteral(data: ISZ[U8]): Either[org.sireum.lang.ast.Pattern.Literal, MessagePack.ErrorMsg] = {
    def f_astPatternLiteral(reader: Reader): org.sireum.lang.ast.Pattern.Literal = {
      val r = reader.read_astPatternLiteral()
      return r
    }
    val r = to(data, f_astPatternLiteral _)
    return r
  }

  def from_astPatternLitInterpolate(o: org.sireum.lang.ast.Pattern.LitInterpolate, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astPatternLitInterpolate(o)
    return w.result
  }

  def to_astPatternLitInterpolate(data: ISZ[U8]): Either[org.sireum.lang.ast.Pattern.LitInterpolate, MessagePack.ErrorMsg] = {
    def f_astPatternLitInterpolate(reader: Reader): org.sireum.lang.ast.Pattern.LitInterpolate = {
      val r = reader.read_astPatternLitInterpolate()
      return r
    }
    val r = to(data, f_astPatternLitInterpolate _)
    return r
  }

  def from_astPatternRef(o: org.sireum.lang.ast.Pattern.Ref, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astPatternRef(o)
    return w.result
  }

  def to_astPatternRef(data: ISZ[U8]): Either[org.sireum.lang.ast.Pattern.Ref, MessagePack.ErrorMsg] = {
    def f_astPatternRef(reader: Reader): org.sireum.lang.ast.Pattern.Ref = {
      val r = reader.read_astPatternRef()
      return r
    }
    val r = to(data, f_astPatternRef _)
    return r
  }

  def from_astPatternVarBinding(o: org.sireum.lang.ast.Pattern.VarBinding, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astPatternVarBinding(o)
    return w.result
  }

  def to_astPatternVarBinding(data: ISZ[U8]): Either[org.sireum.lang.ast.Pattern.VarBinding, MessagePack.ErrorMsg] = {
    def f_astPatternVarBinding(reader: Reader): org.sireum.lang.ast.Pattern.VarBinding = {
      val r = reader.read_astPatternVarBinding()
      return r
    }
    val r = to(data, f_astPatternVarBinding _)
    return r
  }

  def from_astPatternWildcard(o: org.sireum.lang.ast.Pattern.Wildcard, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astPatternWildcard(o)
    return w.result
  }

  def to_astPatternWildcard(data: ISZ[U8]): Either[org.sireum.lang.ast.Pattern.Wildcard, MessagePack.ErrorMsg] = {
    def f_astPatternWildcard(reader: Reader): org.sireum.lang.ast.Pattern.Wildcard = {
      val r = reader.read_astPatternWildcard()
      return r
    }
    val r = to(data, f_astPatternWildcard _)
    return r
  }

  def from_astPatternSeqWildcard(o: org.sireum.lang.ast.Pattern.SeqWildcard, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astPatternSeqWildcard(o)
    return w.result
  }

  def to_astPatternSeqWildcard(data: ISZ[U8]): Either[org.sireum.lang.ast.Pattern.SeqWildcard, MessagePack.ErrorMsg] = {
    def f_astPatternSeqWildcard(reader: Reader): org.sireum.lang.ast.Pattern.SeqWildcard = {
      val r = reader.read_astPatternSeqWildcard()
      return r
    }
    val r = to(data, f_astPatternSeqWildcard _)
    return r
  }

  def from_astPatternStructure(o: org.sireum.lang.ast.Pattern.Structure, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astPatternStructure(o)
    return w.result
  }

  def to_astPatternStructure(data: ISZ[U8]): Either[org.sireum.lang.ast.Pattern.Structure, MessagePack.ErrorMsg] = {
    def f_astPatternStructure(reader: Reader): org.sireum.lang.ast.Pattern.Structure = {
      val r = reader.read_astPatternStructure()
      return r
    }
    val r = to(data, f_astPatternStructure _)
    return r
  }

  def from_astExp(o: org.sireum.lang.ast.Exp, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExp(o)
    return w.result
  }

  def to_astExp(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp, MessagePack.ErrorMsg] = {
    def f_astExp(reader: Reader): org.sireum.lang.ast.Exp = {
      val r = reader.read_astExp()
      return r
    }
    val r = to(data, f_astExp _)
    return r
  }

  def from_astLit(o: org.sireum.lang.ast.Lit, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astLit(o)
    return w.result
  }

  def to_astLit(data: ISZ[U8]): Either[org.sireum.lang.ast.Lit, MessagePack.ErrorMsg] = {
    def f_astLit(reader: Reader): org.sireum.lang.ast.Lit = {
      val r = reader.read_astLit()
      return r
    }
    val r = to(data, f_astLit _)
    return r
  }

  def from_astExpLitB(o: org.sireum.lang.ast.Exp.LitB, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpLitB(o)
    return w.result
  }

  def to_astExpLitB(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.LitB, MessagePack.ErrorMsg] = {
    def f_astExpLitB(reader: Reader): org.sireum.lang.ast.Exp.LitB = {
      val r = reader.read_astExpLitB()
      return r
    }
    val r = to(data, f_astExpLitB _)
    return r
  }

  def from_astExpLitC(o: org.sireum.lang.ast.Exp.LitC, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpLitC(o)
    return w.result
  }

  def to_astExpLitC(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.LitC, MessagePack.ErrorMsg] = {
    def f_astExpLitC(reader: Reader): org.sireum.lang.ast.Exp.LitC = {
      val r = reader.read_astExpLitC()
      return r
    }
    val r = to(data, f_astExpLitC _)
    return r
  }

  def from_astExpLitZ(o: org.sireum.lang.ast.Exp.LitZ, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpLitZ(o)
    return w.result
  }

  def to_astExpLitZ(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.LitZ, MessagePack.ErrorMsg] = {
    def f_astExpLitZ(reader: Reader): org.sireum.lang.ast.Exp.LitZ = {
      val r = reader.read_astExpLitZ()
      return r
    }
    val r = to(data, f_astExpLitZ _)
    return r
  }

  def from_astExpLitF32(o: org.sireum.lang.ast.Exp.LitF32, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpLitF32(o)
    return w.result
  }

  def to_astExpLitF32(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.LitF32, MessagePack.ErrorMsg] = {
    def f_astExpLitF32(reader: Reader): org.sireum.lang.ast.Exp.LitF32 = {
      val r = reader.read_astExpLitF32()
      return r
    }
    val r = to(data, f_astExpLitF32 _)
    return r
  }

  def from_astExpLitF64(o: org.sireum.lang.ast.Exp.LitF64, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpLitF64(o)
    return w.result
  }

  def to_astExpLitF64(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.LitF64, MessagePack.ErrorMsg] = {
    def f_astExpLitF64(reader: Reader): org.sireum.lang.ast.Exp.LitF64 = {
      val r = reader.read_astExpLitF64()
      return r
    }
    val r = to(data, f_astExpLitF64 _)
    return r
  }

  def from_astExpLitR(o: org.sireum.lang.ast.Exp.LitR, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpLitR(o)
    return w.result
  }

  def to_astExpLitR(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.LitR, MessagePack.ErrorMsg] = {
    def f_astExpLitR(reader: Reader): org.sireum.lang.ast.Exp.LitR = {
      val r = reader.read_astExpLitR()
      return r
    }
    val r = to(data, f_astExpLitR _)
    return r
  }

  def from_astExpLitString(o: org.sireum.lang.ast.Exp.LitString, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpLitString(o)
    return w.result
  }

  def to_astExpLitString(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.LitString, MessagePack.ErrorMsg] = {
    def f_astExpLitString(reader: Reader): org.sireum.lang.ast.Exp.LitString = {
      val r = reader.read_astExpLitString()
      return r
    }
    val r = to(data, f_astExpLitString _)
    return r
  }

  def from_astExpStringInterpolate(o: org.sireum.lang.ast.Exp.StringInterpolate, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpStringInterpolate(o)
    return w.result
  }

  def to_astExpStringInterpolate(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.StringInterpolate, MessagePack.ErrorMsg] = {
    def f_astExpStringInterpolate(reader: Reader): org.sireum.lang.ast.Exp.StringInterpolate = {
      val r = reader.read_astExpStringInterpolate()
      return r
    }
    val r = to(data, f_astExpStringInterpolate _)
    return r
  }

  def from_astExpThis(o: org.sireum.lang.ast.Exp.This, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpThis(o)
    return w.result
  }

  def to_astExpThis(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.This, MessagePack.ErrorMsg] = {
    def f_astExpThis(reader: Reader): org.sireum.lang.ast.Exp.This = {
      val r = reader.read_astExpThis()
      return r
    }
    val r = to(data, f_astExpThis _)
    return r
  }

  def from_astExpSuper(o: org.sireum.lang.ast.Exp.Super, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpSuper(o)
    return w.result
  }

  def to_astExpSuper(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.Super, MessagePack.ErrorMsg] = {
    def f_astExpSuper(reader: Reader): org.sireum.lang.ast.Exp.Super = {
      val r = reader.read_astExpSuper()
      return r
    }
    val r = to(data, f_astExpSuper _)
    return r
  }

  def from_astExpUnary(o: org.sireum.lang.ast.Exp.Unary, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpUnary(o)
    return w.result
  }

  def to_astExpUnary(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.Unary, MessagePack.ErrorMsg] = {
    def f_astExpUnary(reader: Reader): org.sireum.lang.ast.Exp.Unary = {
      val r = reader.read_astExpUnary()
      return r
    }
    val r = to(data, f_astExpUnary _)
    return r
  }

  def from_astExpRef(o: org.sireum.lang.ast.Exp.Ref, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpRef(o)
    return w.result
  }

  def to_astExpRef(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.Ref, MessagePack.ErrorMsg] = {
    def f_astExpRef(reader: Reader): org.sireum.lang.ast.Exp.Ref = {
      val r = reader.read_astExpRef()
      return r
    }
    val r = to(data, f_astExpRef _)
    return r
  }

  def from_astExpBinary(o: org.sireum.lang.ast.Exp.Binary, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpBinary(o)
    return w.result
  }

  def to_astExpBinary(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.Binary, MessagePack.ErrorMsg] = {
    def f_astExpBinary(reader: Reader): org.sireum.lang.ast.Exp.Binary = {
      val r = reader.read_astExpBinary()
      return r
    }
    val r = to(data, f_astExpBinary _)
    return r
  }

  def from_astExpIdent(o: org.sireum.lang.ast.Exp.Ident, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpIdent(o)
    return w.result
  }

  def to_astExpIdent(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.Ident, MessagePack.ErrorMsg] = {
    def f_astExpIdent(reader: Reader): org.sireum.lang.ast.Exp.Ident = {
      val r = reader.read_astExpIdent()
      return r
    }
    val r = to(data, f_astExpIdent _)
    return r
  }

  def from_astExpEta(o: org.sireum.lang.ast.Exp.Eta, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpEta(o)
    return w.result
  }

  def to_astExpEta(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.Eta, MessagePack.ErrorMsg] = {
    def f_astExpEta(reader: Reader): org.sireum.lang.ast.Exp.Eta = {
      val r = reader.read_astExpEta()
      return r
    }
    val r = to(data, f_astExpEta _)
    return r
  }

  def from_astExpTuple(o: org.sireum.lang.ast.Exp.Tuple, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpTuple(o)
    return w.result
  }

  def to_astExpTuple(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.Tuple, MessagePack.ErrorMsg] = {
    def f_astExpTuple(reader: Reader): org.sireum.lang.ast.Exp.Tuple = {
      val r = reader.read_astExpTuple()
      return r
    }
    val r = to(data, f_astExpTuple _)
    return r
  }

  def from_astExpSelect(o: org.sireum.lang.ast.Exp.Select, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpSelect(o)
    return w.result
  }

  def to_astExpSelect(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.Select, MessagePack.ErrorMsg] = {
    def f_astExpSelect(reader: Reader): org.sireum.lang.ast.Exp.Select = {
      val r = reader.read_astExpSelect()
      return r
    }
    val r = to(data, f_astExpSelect _)
    return r
  }

  def from_astExpInvoke(o: org.sireum.lang.ast.Exp.Invoke, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpInvoke(o)
    return w.result
  }

  def to_astExpInvoke(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.Invoke, MessagePack.ErrorMsg] = {
    def f_astExpInvoke(reader: Reader): org.sireum.lang.ast.Exp.Invoke = {
      val r = reader.read_astExpInvoke()
      return r
    }
    val r = to(data, f_astExpInvoke _)
    return r
  }

  def from_astExpInvokeNamed(o: org.sireum.lang.ast.Exp.InvokeNamed, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpInvokeNamed(o)
    return w.result
  }

  def to_astExpInvokeNamed(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.InvokeNamed, MessagePack.ErrorMsg] = {
    def f_astExpInvokeNamed(reader: Reader): org.sireum.lang.ast.Exp.InvokeNamed = {
      val r = reader.read_astExpInvokeNamed()
      return r
    }
    val r = to(data, f_astExpInvokeNamed _)
    return r
  }

  def from_astExpIf(o: org.sireum.lang.ast.Exp.If, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpIf(o)
    return w.result
  }

  def to_astExpIf(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.If, MessagePack.ErrorMsg] = {
    def f_astExpIf(reader: Reader): org.sireum.lang.ast.Exp.If = {
      val r = reader.read_astExpIf()
      return r
    }
    val r = to(data, f_astExpIf _)
    return r
  }

  def from_astExpFunParam(o: org.sireum.lang.ast.Exp.Fun.Param, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpFunParam(o)
    return w.result
  }

  def to_astExpFunParam(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.Fun.Param, MessagePack.ErrorMsg] = {
    def f_astExpFunParam(reader: Reader): org.sireum.lang.ast.Exp.Fun.Param = {
      val r = reader.read_astExpFunParam()
      return r
    }
    val r = to(data, f_astExpFunParam _)
    return r
  }

  def from_astExpFun(o: org.sireum.lang.ast.Exp.Fun, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpFun(o)
    return w.result
  }

  def to_astExpFun(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.Fun, MessagePack.ErrorMsg] = {
    def f_astExpFun(reader: Reader): org.sireum.lang.ast.Exp.Fun = {
      val r = reader.read_astExpFun()
      return r
    }
    val r = to(data, f_astExpFun _)
    return r
  }

  def from_astExpForYield(o: org.sireum.lang.ast.Exp.ForYield, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpForYield(o)
    return w.result
  }

  def to_astExpForYield(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.ForYield, MessagePack.ErrorMsg] = {
    def f_astExpForYield(reader: Reader): org.sireum.lang.ast.Exp.ForYield = {
      val r = reader.read_astExpForYield()
      return r
    }
    val r = to(data, f_astExpForYield _)
    return r
  }

  def from_astExpQuant(o: org.sireum.lang.ast.Exp.Quant, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astExpQuant(o)
    return w.result
  }

  def to_astExpQuant(data: ISZ[U8]): Either[org.sireum.lang.ast.Exp.Quant, MessagePack.ErrorMsg] = {
    def f_astExpQuant(reader: Reader): org.sireum.lang.ast.Exp.Quant = {
      val r = reader.read_astExpQuant()
      return r
    }
    val r = to(data, f_astExpQuant _)
    return r
  }

  def from_astNamedArg(o: org.sireum.lang.ast.NamedArg, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astNamedArg(o)
    return w.result
  }

  def to_astNamedArg(data: ISZ[U8]): Either[org.sireum.lang.ast.NamedArg, MessagePack.ErrorMsg] = {
    def f_astNamedArg(reader: Reader): org.sireum.lang.ast.NamedArg = {
      val r = reader.read_astNamedArg()
      return r
    }
    val r = to(data, f_astNamedArg _)
    return r
  }

  def from_astVarFragment(o: org.sireum.lang.ast.VarFragment, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astVarFragment(o)
    return w.result
  }

  def to_astVarFragment(data: ISZ[U8]): Either[org.sireum.lang.ast.VarFragment, MessagePack.ErrorMsg] = {
    def f_astVarFragment(reader: Reader): org.sireum.lang.ast.VarFragment = {
      val r = reader.read_astVarFragment()
      return r
    }
    val r = to(data, f_astVarFragment _)
    return r
  }

  def from_astDomain(o: org.sireum.lang.ast.Domain, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astDomain(o)
    return w.result
  }

  def to_astDomain(data: ISZ[U8]): Either[org.sireum.lang.ast.Domain, MessagePack.ErrorMsg] = {
    def f_astDomain(reader: Reader): org.sireum.lang.ast.Domain = {
      val r = reader.read_astDomain()
      return r
    }
    val r = to(data, f_astDomain _)
    return r
  }

  def from_astDomainType(o: org.sireum.lang.ast.Domain.Type, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astDomainType(o)
    return w.result
  }

  def to_astDomainType(data: ISZ[U8]): Either[org.sireum.lang.ast.Domain.Type, MessagePack.ErrorMsg] = {
    def f_astDomainType(reader: Reader): org.sireum.lang.ast.Domain.Type = {
      val r = reader.read_astDomainType()
      return r
    }
    val r = to(data, f_astDomainType _)
    return r
  }

  def from_astDomainRange(o: org.sireum.lang.ast.Domain.Range, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astDomainRange(o)
    return w.result
  }

  def to_astDomainRange(data: ISZ[U8]): Either[org.sireum.lang.ast.Domain.Range, MessagePack.ErrorMsg] = {
    def f_astDomainRange(reader: Reader): org.sireum.lang.ast.Domain.Range = {
      val r = reader.read_astDomainRange()
      return r
    }
    val r = to(data, f_astDomainRange _)
    return r
  }

  def from_astId(o: org.sireum.lang.ast.Id, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astId(o)
    return w.result
  }

  def to_astId(data: ISZ[U8]): Either[org.sireum.lang.ast.Id, MessagePack.ErrorMsg] = {
    def f_astId(reader: Reader): org.sireum.lang.ast.Id = {
      val r = reader.read_astId()
      return r
    }
    val r = to(data, f_astId _)
    return r
  }

  def from_astName(o: org.sireum.lang.ast.Name, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astName(o)
    return w.result
  }

  def to_astName(data: ISZ[U8]): Either[org.sireum.lang.ast.Name, MessagePack.ErrorMsg] = {
    def f_astName(reader: Reader): org.sireum.lang.ast.Name = {
      val r = reader.read_astName()
      return r
    }
    val r = to(data, f_astName _)
    return r
  }

  def from_astBody(o: org.sireum.lang.ast.Body, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astBody(o)
    return w.result
  }

  def to_astBody(data: ISZ[U8]): Either[org.sireum.lang.ast.Body, MessagePack.ErrorMsg] = {
    def f_astBody(reader: Reader): org.sireum.lang.ast.Body = {
      val r = reader.read_astBody()
      return r
    }
    val r = to(data, f_astBody _)
    return r
  }

  def from_astAbstractDatatypeParam(o: org.sireum.lang.ast.AbstractDatatypeParam, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astAbstractDatatypeParam(o)
    return w.result
  }

  def to_astAbstractDatatypeParam(data: ISZ[U8]): Either[org.sireum.lang.ast.AbstractDatatypeParam, MessagePack.ErrorMsg] = {
    def f_astAbstractDatatypeParam(reader: Reader): org.sireum.lang.ast.AbstractDatatypeParam = {
      val r = reader.read_astAbstractDatatypeParam()
      return r
    }
    val r = to(data, f_astAbstractDatatypeParam _)
    return r
  }

  def from_astMethodSig(o: org.sireum.lang.ast.MethodSig, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astMethodSig(o)
    return w.result
  }

  def to_astMethodSig(data: ISZ[U8]): Either[org.sireum.lang.ast.MethodSig, MessagePack.ErrorMsg] = {
    def f_astMethodSig(reader: Reader): org.sireum.lang.ast.MethodSig = {
      val r = reader.read_astMethodSig()
      return r
    }
    val r = to(data, f_astMethodSig _)
    return r
  }

  def from_astParam(o: org.sireum.lang.ast.Param, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astParam(o)
    return w.result
  }

  def to_astParam(data: ISZ[U8]): Either[org.sireum.lang.ast.Param, MessagePack.ErrorMsg] = {
    def f_astParam(reader: Reader): org.sireum.lang.ast.Param = {
      val r = reader.read_astParam()
      return r
    }
    val r = to(data, f_astParam _)
    return r
  }

  def from_astTypeParam(o: org.sireum.lang.ast.TypeParam, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTypeParam(o)
    return w.result
  }

  def to_astTypeParam(data: ISZ[U8]): Either[org.sireum.lang.ast.TypeParam, MessagePack.ErrorMsg] = {
    def f_astTypeParam(reader: Reader): org.sireum.lang.ast.TypeParam = {
      val r = reader.read_astTypeParam()
      return r
    }
    val r = to(data, f_astTypeParam _)
    return r
  }

  def from_astContract(o: org.sireum.lang.ast.Contract, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astContract(o)
    return w.result
  }

  def to_astContract(data: ISZ[U8]): Either[org.sireum.lang.ast.Contract, MessagePack.ErrorMsg] = {
    def f_astContract(reader: Reader): org.sireum.lang.ast.Contract = {
      val r = reader.read_astContract()
      return r
    }
    val r = to(data, f_astContract _)
    return r
  }

  def from_astSubContract(o: org.sireum.lang.ast.SubContract, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astSubContract(o)
    return w.result
  }

  def to_astSubContract(data: ISZ[U8]): Either[org.sireum.lang.ast.SubContract, MessagePack.ErrorMsg] = {
    def f_astSubContract(reader: Reader): org.sireum.lang.ast.SubContract = {
      val r = reader.read_astSubContract()
      return r
    }
    val r = to(data, f_astSubContract _)
    return r
  }

  def from_astWhereDef(o: org.sireum.lang.ast.WhereDef, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astWhereDef(o)
    return w.result
  }

  def to_astWhereDef(data: ISZ[U8]): Either[org.sireum.lang.ast.WhereDef, MessagePack.ErrorMsg] = {
    def f_astWhereDef(reader: Reader): org.sireum.lang.ast.WhereDef = {
      val r = reader.read_astWhereDef()
      return r
    }
    val r = to(data, f_astWhereDef _)
    return r
  }

  def from_astWhereDefVal(o: org.sireum.lang.ast.WhereDef.Val, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astWhereDefVal(o)
    return w.result
  }

  def to_astWhereDefVal(data: ISZ[U8]): Either[org.sireum.lang.ast.WhereDef.Val, MessagePack.ErrorMsg] = {
    def f_astWhereDefVal(reader: Reader): org.sireum.lang.ast.WhereDef.Val = {
      val r = reader.read_astWhereDefVal()
      return r
    }
    val r = to(data, f_astWhereDefVal _)
    return r
  }

  def from_astWhereDefDef(o: org.sireum.lang.ast.WhereDef.Def, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astWhereDefDef(o)
    return w.result
  }

  def to_astWhereDefDef(data: ISZ[U8]): Either[org.sireum.lang.ast.WhereDef.Def, MessagePack.ErrorMsg] = {
    def f_astWhereDefDef(reader: Reader): org.sireum.lang.ast.WhereDef.Def = {
      val r = reader.read_astWhereDefDef()
      return r
    }
    val r = to(data, f_astWhereDefDef _)
    return r
  }

  def from_astSpecDef(o: org.sireum.lang.ast.SpecDef, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astSpecDef(o)
    return w.result
  }

  def to_astSpecDef(data: ISZ[U8]): Either[org.sireum.lang.ast.SpecDef, MessagePack.ErrorMsg] = {
    def f_astSpecDef(reader: Reader): org.sireum.lang.ast.SpecDef = {
      val r = reader.read_astSpecDef()
      return r
    }
    val r = to(data, f_astSpecDef _)
    return r
  }

  def from_astTyped(o: org.sireum.lang.ast.Typed, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTyped(o)
    return w.result
  }

  def to_astTyped(data: ISZ[U8]): Either[org.sireum.lang.ast.Typed, MessagePack.ErrorMsg] = {
    def f_astTyped(reader: Reader): org.sireum.lang.ast.Typed = {
      val r = reader.read_astTyped()
      return r
    }
    val r = to(data, f_astTyped _)
    return r
  }

  def from_astTypedName(o: org.sireum.lang.ast.Typed.Name, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTypedName(o)
    return w.result
  }

  def to_astTypedName(data: ISZ[U8]): Either[org.sireum.lang.ast.Typed.Name, MessagePack.ErrorMsg] = {
    def f_astTypedName(reader: Reader): org.sireum.lang.ast.Typed.Name = {
      val r = reader.read_astTypedName()
      return r
    }
    val r = to(data, f_astTypedName _)
    return r
  }

  def from_astTypedTuple(o: org.sireum.lang.ast.Typed.Tuple, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTypedTuple(o)
    return w.result
  }

  def to_astTypedTuple(data: ISZ[U8]): Either[org.sireum.lang.ast.Typed.Tuple, MessagePack.ErrorMsg] = {
    def f_astTypedTuple(reader: Reader): org.sireum.lang.ast.Typed.Tuple = {
      val r = reader.read_astTypedTuple()
      return r
    }
    val r = to(data, f_astTypedTuple _)
    return r
  }

  def from_astTypedFun(o: org.sireum.lang.ast.Typed.Fun, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTypedFun(o)
    return w.result
  }

  def to_astTypedFun(data: ISZ[U8]): Either[org.sireum.lang.ast.Typed.Fun, MessagePack.ErrorMsg] = {
    def f_astTypedFun(reader: Reader): org.sireum.lang.ast.Typed.Fun = {
      val r = reader.read_astTypedFun()
      return r
    }
    val r = to(data, f_astTypedFun _)
    return r
  }

  def from_astTypedTypeVar(o: org.sireum.lang.ast.Typed.TypeVar, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTypedTypeVar(o)
    return w.result
  }

  def to_astTypedTypeVar(data: ISZ[U8]): Either[org.sireum.lang.ast.Typed.TypeVar, MessagePack.ErrorMsg] = {
    def f_astTypedTypeVar(reader: Reader): org.sireum.lang.ast.Typed.TypeVar = {
      val r = reader.read_astTypedTypeVar()
      return r
    }
    val r = to(data, f_astTypedTypeVar _)
    return r
  }

  def from_astTypedPackage(o: org.sireum.lang.ast.Typed.Package, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTypedPackage(o)
    return w.result
  }

  def to_astTypedPackage(data: ISZ[U8]): Either[org.sireum.lang.ast.Typed.Package, MessagePack.ErrorMsg] = {
    def f_astTypedPackage(reader: Reader): org.sireum.lang.ast.Typed.Package = {
      val r = reader.read_astTypedPackage()
      return r
    }
    val r = to(data, f_astTypedPackage _)
    return r
  }

  def from_astTypedObject(o: org.sireum.lang.ast.Typed.Object, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTypedObject(o)
    return w.result
  }

  def to_astTypedObject(data: ISZ[U8]): Either[org.sireum.lang.ast.Typed.Object, MessagePack.ErrorMsg] = {
    def f_astTypedObject(reader: Reader): org.sireum.lang.ast.Typed.Object = {
      val r = reader.read_astTypedObject()
      return r
    }
    val r = to(data, f_astTypedObject _)
    return r
  }

  def from_astTypedEnum(o: org.sireum.lang.ast.Typed.Enum, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTypedEnum(o)
    return w.result
  }

  def to_astTypedEnum(data: ISZ[U8]): Either[org.sireum.lang.ast.Typed.Enum, MessagePack.ErrorMsg] = {
    def f_astTypedEnum(reader: Reader): org.sireum.lang.ast.Typed.Enum = {
      val r = reader.read_astTypedEnum()
      return r
    }
    val r = to(data, f_astTypedEnum _)
    return r
  }

  def from_astTypedMethodSubst(o: org.sireum.lang.ast.Typed.Method.Subst, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTypedMethodSubst(o)
    return w.result
  }

  def to_astTypedMethodSubst(data: ISZ[U8]): Either[org.sireum.lang.ast.Typed.Method.Subst, MessagePack.ErrorMsg] = {
    def f_astTypedMethodSubst(reader: Reader): org.sireum.lang.ast.Typed.Method.Subst = {
      val r = reader.read_astTypedMethodSubst()
      return r
    }
    val r = to(data, f_astTypedMethodSubst _)
    return r
  }

  def from_astTypedMethod(o: org.sireum.lang.ast.Typed.Method, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTypedMethod(o)
    return w.result
  }

  def to_astTypedMethod(data: ISZ[U8]): Either[org.sireum.lang.ast.Typed.Method, MessagePack.ErrorMsg] = {
    def f_astTypedMethod(reader: Reader): org.sireum.lang.ast.Typed.Method = {
      val r = reader.read_astTypedMethod()
      return r
    }
    val r = to(data, f_astTypedMethod _)
    return r
  }

  def from_astTypedMethods(o: org.sireum.lang.ast.Typed.Methods, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTypedMethods(o)
    return w.result
  }

  def to_astTypedMethods(data: ISZ[U8]): Either[org.sireum.lang.ast.Typed.Methods, MessagePack.ErrorMsg] = {
    def f_astTypedMethods(reader: Reader): org.sireum.lang.ast.Typed.Methods = {
      val r = reader.read_astTypedMethods()
      return r
    }
    val r = to(data, f_astTypedMethods _)
    return r
  }

  def from_astAttr(o: org.sireum.lang.ast.Attr, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astAttr(o)
    return w.result
  }

  def to_astAttr(data: ISZ[U8]): Either[org.sireum.lang.ast.Attr, MessagePack.ErrorMsg] = {
    def f_astAttr(reader: Reader): org.sireum.lang.ast.Attr = {
      val r = reader.read_astAttr()
      return r
    }
    val r = to(data, f_astAttr _)
    return r
  }

  def from_astTypedAttr(o: org.sireum.lang.ast.TypedAttr, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTypedAttr(o)
    return w.result
  }

  def to_astTypedAttr(data: ISZ[U8]): Either[org.sireum.lang.ast.TypedAttr, MessagePack.ErrorMsg] = {
    def f_astTypedAttr(reader: Reader): org.sireum.lang.ast.TypedAttr = {
      val r = reader.read_astTypedAttr()
      return r
    }
    val r = to(data, f_astTypedAttr _)
    return r
  }

  def from_astResolvedAttr(o: org.sireum.lang.ast.ResolvedAttr, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astResolvedAttr(o)
    return w.result
  }

  def to_astResolvedAttr(data: ISZ[U8]): Either[org.sireum.lang.ast.ResolvedAttr, MessagePack.ErrorMsg] = {
    def f_astResolvedAttr(reader: Reader): org.sireum.lang.ast.ResolvedAttr = {
      val r = reader.read_astResolvedAttr()
      return r
    }
    val r = to(data, f_astResolvedAttr _)
    return r
  }

  def from_astResolvedInfo(o: org.sireum.lang.ast.ResolvedInfo, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astResolvedInfo(o)
    return w.result
  }

  def to_astResolvedInfo(data: ISZ[U8]): Either[org.sireum.lang.ast.ResolvedInfo, MessagePack.ErrorMsg] = {
    def f_astResolvedInfo(reader: Reader): org.sireum.lang.ast.ResolvedInfo = {
      val r = reader.read_astResolvedInfo()
      return r
    }
    val r = to(data, f_astResolvedInfo _)
    return r
  }

  def from_astResolvedInfoBuiltIn(o: org.sireum.lang.ast.ResolvedInfo.BuiltIn, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astResolvedInfoBuiltIn(o)
    return w.result
  }

  def to_astResolvedInfoBuiltIn(data: ISZ[U8]): Either[org.sireum.lang.ast.ResolvedInfo.BuiltIn, MessagePack.ErrorMsg] = {
    def f_astResolvedInfoBuiltIn(reader: Reader): org.sireum.lang.ast.ResolvedInfo.BuiltIn = {
      val r = reader.read_astResolvedInfoBuiltIn()
      return r
    }
    val r = to(data, f_astResolvedInfoBuiltIn _)
    return r
  }

  def from_astResolvedInfoPackage(o: org.sireum.lang.ast.ResolvedInfo.Package, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astResolvedInfoPackage(o)
    return w.result
  }

  def to_astResolvedInfoPackage(data: ISZ[U8]): Either[org.sireum.lang.ast.ResolvedInfo.Package, MessagePack.ErrorMsg] = {
    def f_astResolvedInfoPackage(reader: Reader): org.sireum.lang.ast.ResolvedInfo.Package = {
      val r = reader.read_astResolvedInfoPackage()
      return r
    }
    val r = to(data, f_astResolvedInfoPackage _)
    return r
  }

  def from_astResolvedInfoEnum(o: org.sireum.lang.ast.ResolvedInfo.Enum, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astResolvedInfoEnum(o)
    return w.result
  }

  def to_astResolvedInfoEnum(data: ISZ[U8]): Either[org.sireum.lang.ast.ResolvedInfo.Enum, MessagePack.ErrorMsg] = {
    def f_astResolvedInfoEnum(reader: Reader): org.sireum.lang.ast.ResolvedInfo.Enum = {
      val r = reader.read_astResolvedInfoEnum()
      return r
    }
    val r = to(data, f_astResolvedInfoEnum _)
    return r
  }

  def from_astResolvedInfoEnumElement(o: org.sireum.lang.ast.ResolvedInfo.EnumElement, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astResolvedInfoEnumElement(o)
    return w.result
  }

  def to_astResolvedInfoEnumElement(data: ISZ[U8]): Either[org.sireum.lang.ast.ResolvedInfo.EnumElement, MessagePack.ErrorMsg] = {
    def f_astResolvedInfoEnumElement(reader: Reader): org.sireum.lang.ast.ResolvedInfo.EnumElement = {
      val r = reader.read_astResolvedInfoEnumElement()
      return r
    }
    val r = to(data, f_astResolvedInfoEnumElement _)
    return r
  }

  def from_astResolvedInfoObject(o: org.sireum.lang.ast.ResolvedInfo.Object, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astResolvedInfoObject(o)
    return w.result
  }

  def to_astResolvedInfoObject(data: ISZ[U8]): Either[org.sireum.lang.ast.ResolvedInfo.Object, MessagePack.ErrorMsg] = {
    def f_astResolvedInfoObject(reader: Reader): org.sireum.lang.ast.ResolvedInfo.Object = {
      val r = reader.read_astResolvedInfoObject()
      return r
    }
    val r = to(data, f_astResolvedInfoObject _)
    return r
  }

  def from_astResolvedInfoVar(o: org.sireum.lang.ast.ResolvedInfo.Var, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astResolvedInfoVar(o)
    return w.result
  }

  def to_astResolvedInfoVar(data: ISZ[U8]): Either[org.sireum.lang.ast.ResolvedInfo.Var, MessagePack.ErrorMsg] = {
    def f_astResolvedInfoVar(reader: Reader): org.sireum.lang.ast.ResolvedInfo.Var = {
      val r = reader.read_astResolvedInfoVar()
      return r
    }
    val r = to(data, f_astResolvedInfoVar _)
    return r
  }

  def from_astResolvedInfoMethod(o: org.sireum.lang.ast.ResolvedInfo.Method, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astResolvedInfoMethod(o)
    return w.result
  }

  def to_astResolvedInfoMethod(data: ISZ[U8]): Either[org.sireum.lang.ast.ResolvedInfo.Method, MessagePack.ErrorMsg] = {
    def f_astResolvedInfoMethod(reader: Reader): org.sireum.lang.ast.ResolvedInfo.Method = {
      val r = reader.read_astResolvedInfoMethod()
      return r
    }
    val r = to(data, f_astResolvedInfoMethod _)
    return r
  }

  def from_astResolvedInfoMethods(o: org.sireum.lang.ast.ResolvedInfo.Methods, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astResolvedInfoMethods(o)
    return w.result
  }

  def to_astResolvedInfoMethods(data: ISZ[U8]): Either[org.sireum.lang.ast.ResolvedInfo.Methods, MessagePack.ErrorMsg] = {
    def f_astResolvedInfoMethods(reader: Reader): org.sireum.lang.ast.ResolvedInfo.Methods = {
      val r = reader.read_astResolvedInfoMethods()
      return r
    }
    val r = to(data, f_astResolvedInfoMethods _)
    return r
  }

  def from_astResolvedInfoType(o: org.sireum.lang.ast.ResolvedInfo.Type, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astResolvedInfoType(o)
    return w.result
  }

  def to_astResolvedInfoType(data: ISZ[U8]): Either[org.sireum.lang.ast.ResolvedInfo.Type, MessagePack.ErrorMsg] = {
    def f_astResolvedInfoType(reader: Reader): org.sireum.lang.ast.ResolvedInfo.Type = {
      val r = reader.read_astResolvedInfoType()
      return r
    }
    val r = to(data, f_astResolvedInfoType _)
    return r
  }

  def from_astResolvedInfoTuple(o: org.sireum.lang.ast.ResolvedInfo.Tuple, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astResolvedInfoTuple(o)
    return w.result
  }

  def to_astResolvedInfoTuple(data: ISZ[U8]): Either[org.sireum.lang.ast.ResolvedInfo.Tuple, MessagePack.ErrorMsg] = {
    def f_astResolvedInfoTuple(reader: Reader): org.sireum.lang.ast.ResolvedInfo.Tuple = {
      val r = reader.read_astResolvedInfoTuple()
      return r
    }
    val r = to(data, f_astResolvedInfoTuple _)
    return r
  }

  def from_astResolvedInfoLocalVar(o: org.sireum.lang.ast.ResolvedInfo.LocalVar, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astResolvedInfoLocalVar(o)
    return w.result
  }

  def to_astResolvedInfoLocalVar(data: ISZ[U8]): Either[org.sireum.lang.ast.ResolvedInfo.LocalVar, MessagePack.ErrorMsg] = {
    def f_astResolvedInfoLocalVar(reader: Reader): org.sireum.lang.ast.ResolvedInfo.LocalVar = {
      val r = reader.read_astResolvedInfoLocalVar()
      return r
    }
    val r = to(data, f_astResolvedInfoLocalVar _)
    return r
  }

  def from_astProofStep(o: org.sireum.lang.ast.ProofStep, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astProofStep(o)
    return w.result
  }

  def to_astProofStep(data: ISZ[U8]): Either[org.sireum.lang.ast.ProofStep, MessagePack.ErrorMsg] = {
    def f_astProofStep(reader: Reader): org.sireum.lang.ast.ProofStep = {
      val r = reader.read_astProofStep()
      return r
    }
    val r = to(data, f_astProofStep _)
    return r
  }

  def from_astProofStepBasic(o: org.sireum.lang.ast.ProofStep.Basic, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astProofStepBasic(o)
    return w.result
  }

  def to_astProofStepBasic(data: ISZ[U8]): Either[org.sireum.lang.ast.ProofStep.Basic, MessagePack.ErrorMsg] = {
    def f_astProofStepBasic(reader: Reader): org.sireum.lang.ast.ProofStep.Basic = {
      val r = reader.read_astProofStepBasic()
      return r
    }
    val r = to(data, f_astProofStepBasic _)
    return r
  }

  def from_astProofStepSubProof(o: org.sireum.lang.ast.ProofStep.SubProof, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astProofStepSubProof(o)
    return w.result
  }

  def to_astProofStepSubProof(data: ISZ[U8]): Either[org.sireum.lang.ast.ProofStep.SubProof, MessagePack.ErrorMsg] = {
    def f_astProofStepSubProof(reader: Reader): org.sireum.lang.ast.ProofStep.SubProof = {
      val r = reader.read_astProofStepSubProof()
      return r
    }
    val r = to(data, f_astProofStepSubProof _)
    return r
  }

  def from_astAssumeProofStep(o: org.sireum.lang.ast.AssumeProofStep, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astAssumeProofStep(o)
    return w.result
  }

  def to_astAssumeProofStep(data: ISZ[U8]): Either[org.sireum.lang.ast.AssumeProofStep, MessagePack.ErrorMsg] = {
    def f_astAssumeProofStep(reader: Reader): org.sireum.lang.ast.AssumeProofStep = {
      val r = reader.read_astAssumeProofStep()
      return r
    }
    val r = to(data, f_astAssumeProofStep _)
    return r
  }

  def from_astAssumeProofStepRegular(o: org.sireum.lang.ast.AssumeProofStep.Regular, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astAssumeProofStepRegular(o)
    return w.result
  }

  def to_astAssumeProofStepRegular(data: ISZ[U8]): Either[org.sireum.lang.ast.AssumeProofStep.Regular, MessagePack.ErrorMsg] = {
    def f_astAssumeProofStepRegular(reader: Reader): org.sireum.lang.ast.AssumeProofStep.Regular = {
      val r = reader.read_astAssumeProofStepRegular()
      return r
    }
    val r = to(data, f_astAssumeProofStepRegular _)
    return r
  }

  def from_astAssumeProofStepForallIntroAps(o: org.sireum.lang.ast.AssumeProofStep.ForallIntroAps, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astAssumeProofStepForallIntroAps(o)
    return w.result
  }

  def to_astAssumeProofStepForallIntroAps(data: ISZ[U8]): Either[org.sireum.lang.ast.AssumeProofStep.ForallIntroAps, MessagePack.ErrorMsg] = {
    def f_astAssumeProofStepForallIntroAps(reader: Reader): org.sireum.lang.ast.AssumeProofStep.ForallIntroAps = {
      val r = reader.read_astAssumeProofStepForallIntroAps()
      return r
    }
    val r = to(data, f_astAssumeProofStepForallIntroAps _)
    return r
  }

  def from_astAssumeProofStepExistsElimAps(o: org.sireum.lang.ast.AssumeProofStep.ExistsElimAps, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astAssumeProofStepExistsElimAps(o)
    return w.result
  }

  def to_astAssumeProofStepExistsElimAps(data: ISZ[U8]): Either[org.sireum.lang.ast.AssumeProofStep.ExistsElimAps, MessagePack.ErrorMsg] = {
    def f_astAssumeProofStepExistsElimAps(reader: Reader): org.sireum.lang.ast.AssumeProofStep.ExistsElimAps = {
      val r = reader.read_astAssumeProofStepExistsElimAps()
      return r
    }
    val r = to(data, f_astAssumeProofStepExistsElimAps _)
    return r
  }

  def from_astJust(o: org.sireum.lang.ast.Just, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJust(o)
    return w.result
  }

  def to_astJust(data: ISZ[U8]): Either[org.sireum.lang.ast.Just, MessagePack.ErrorMsg] = {
    def f_astJust(reader: Reader): org.sireum.lang.ast.Just = {
      val r = reader.read_astJust()
      return r
    }
    val r = to(data, f_astJust _)
    return r
  }

  def from_astJustPremise(o: org.sireum.lang.ast.Just.Premise, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustPremise(o)
    return w.result
  }

  def to_astJustPremise(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.Premise, MessagePack.ErrorMsg] = {
    def f_astJustPremise(reader: Reader): org.sireum.lang.ast.Just.Premise = {
      val r = reader.read_astJustPremise()
      return r
    }
    val r = to(data, f_astJustPremise _)
    return r
  }

  def from_astJustAuto(o: org.sireum.lang.ast.Just.Auto, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustAuto(o)
    return w.result
  }

  def to_astJustAuto(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.Auto, MessagePack.ErrorMsg] = {
    def f_astJustAuto(reader: Reader): org.sireum.lang.ast.Just.Auto = {
      val r = reader.read_astJustAuto()
      return r
    }
    val r = to(data, f_astJustAuto _)
    return r
  }

  def from_astJustCoq(o: org.sireum.lang.ast.Just.Coq, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustCoq(o)
    return w.result
  }

  def to_astJustCoq(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.Coq, MessagePack.ErrorMsg] = {
    def f_astJustCoq(reader: Reader): org.sireum.lang.ast.Just.Coq = {
      val r = reader.read_astJustCoq()
      return r
    }
    val r = to(data, f_astJustCoq _)
    return r
  }

  def from_astJustSubst(o: org.sireum.lang.ast.Just.Subst, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustSubst(o)
    return w.result
  }

  def to_astJustSubst(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.Subst, MessagePack.ErrorMsg] = {
    def f_astJustSubst(reader: Reader): org.sireum.lang.ast.Just.Subst = {
      val r = reader.read_astJustSubst()
      return r
    }
    val r = to(data, f_astJustSubst _)
    return r
  }

  def from_astJustInvariant(o: org.sireum.lang.ast.Just.Invariant, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustInvariant(o)
    return w.result
  }

  def to_astJustInvariant(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.Invariant, MessagePack.ErrorMsg] = {
    def f_astJustInvariant(reader: Reader): org.sireum.lang.ast.Just.Invariant = {
      val r = reader.read_astJustInvariant()
      return r
    }
    val r = to(data, f_astJustInvariant _)
    return r
  }

  def from_astJustFact(o: org.sireum.lang.ast.Just.Fact, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustFact(o)
    return w.result
  }

  def to_astJustFact(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.Fact, MessagePack.ErrorMsg] = {
    def f_astJustFact(reader: Reader): org.sireum.lang.ast.Just.Fact = {
      val r = reader.read_astJustFact()
      return r
    }
    val r = to(data, f_astJustFact _)
    return r
  }

  def from_astJustImplyIntro(o: org.sireum.lang.ast.Just.ImplyIntro, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustImplyIntro(o)
    return w.result
  }

  def to_astJustImplyIntro(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.ImplyIntro, MessagePack.ErrorMsg] = {
    def f_astJustImplyIntro(reader: Reader): org.sireum.lang.ast.Just.ImplyIntro = {
      val r = reader.read_astJustImplyIntro()
      return r
    }
    val r = to(data, f_astJustImplyIntro _)
    return r
  }

  def from_astJustImplyElim(o: org.sireum.lang.ast.Just.ImplyElim, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustImplyElim(o)
    return w.result
  }

  def to_astJustImplyElim(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.ImplyElim, MessagePack.ErrorMsg] = {
    def f_astJustImplyElim(reader: Reader): org.sireum.lang.ast.Just.ImplyElim = {
      val r = reader.read_astJustImplyElim()
      return r
    }
    val r = to(data, f_astJustImplyElim _)
    return r
  }

  def from_astJustNegIntro(o: org.sireum.lang.ast.Just.NegIntro, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustNegIntro(o)
    return w.result
  }

  def to_astJustNegIntro(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.NegIntro, MessagePack.ErrorMsg] = {
    def f_astJustNegIntro(reader: Reader): org.sireum.lang.ast.Just.NegIntro = {
      val r = reader.read_astJustNegIntro()
      return r
    }
    val r = to(data, f_astJustNegIntro _)
    return r
  }

  def from_astJustNegElim(o: org.sireum.lang.ast.Just.NegElim, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustNegElim(o)
    return w.result
  }

  def to_astJustNegElim(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.NegElim, MessagePack.ErrorMsg] = {
    def f_astJustNegElim(reader: Reader): org.sireum.lang.ast.Just.NegElim = {
      val r = reader.read_astJustNegElim()
      return r
    }
    val r = to(data, f_astJustNegElim _)
    return r
  }

  def from_astJustBottomElim(o: org.sireum.lang.ast.Just.BottomElim, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustBottomElim(o)
    return w.result
  }

  def to_astJustBottomElim(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.BottomElim, MessagePack.ErrorMsg] = {
    def f_astJustBottomElim(reader: Reader): org.sireum.lang.ast.Just.BottomElim = {
      val r = reader.read_astJustBottomElim()
      return r
    }
    val r = to(data, f_astJustBottomElim _)
    return r
  }

  def from_astJustForallIntro(o: org.sireum.lang.ast.Just.ForallIntro, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustForallIntro(o)
    return w.result
  }

  def to_astJustForallIntro(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.ForallIntro, MessagePack.ErrorMsg] = {
    def f_astJustForallIntro(reader: Reader): org.sireum.lang.ast.Just.ForallIntro = {
      val r = reader.read_astJustForallIntro()
      return r
    }
    val r = to(data, f_astJustForallIntro _)
    return r
  }

  def from_astJustForallElim(o: org.sireum.lang.ast.Just.ForallElim, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustForallElim(o)
    return w.result
  }

  def to_astJustForallElim(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.ForallElim, MessagePack.ErrorMsg] = {
    def f_astJustForallElim(reader: Reader): org.sireum.lang.ast.Just.ForallElim = {
      val r = reader.read_astJustForallElim()
      return r
    }
    val r = to(data, f_astJustForallElim _)
    return r
  }

  def from_astJustExistsIntro(o: org.sireum.lang.ast.Just.ExistsIntro, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustExistsIntro(o)
    return w.result
  }

  def to_astJustExistsIntro(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.ExistsIntro, MessagePack.ErrorMsg] = {
    def f_astJustExistsIntro(reader: Reader): org.sireum.lang.ast.Just.ExistsIntro = {
      val r = reader.read_astJustExistsIntro()
      return r
    }
    val r = to(data, f_astJustExistsIntro _)
    return r
  }

  def from_astJustExistsElim(o: org.sireum.lang.ast.Just.ExistsElim, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustExistsElim(o)
    return w.result
  }

  def to_astJustExistsElim(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.ExistsElim, MessagePack.ErrorMsg] = {
    def f_astJustExistsElim(reader: Reader): org.sireum.lang.ast.Just.ExistsElim = {
      val r = reader.read_astJustExistsElim()
      return r
    }
    val r = to(data, f_astJustExistsElim _)
    return r
  }

  def from_astJustOrIntro(o: org.sireum.lang.ast.Just.OrIntro, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustOrIntro(o)
    return w.result
  }

  def to_astJustOrIntro(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.OrIntro, MessagePack.ErrorMsg] = {
    def f_astJustOrIntro(reader: Reader): org.sireum.lang.ast.Just.OrIntro = {
      val r = reader.read_astJustOrIntro()
      return r
    }
    val r = to(data, f_astJustOrIntro _)
    return r
  }

  def from_astJustOrElim(o: org.sireum.lang.ast.Just.OrElim, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustOrElim(o)
    return w.result
  }

  def to_astJustOrElim(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.OrElim, MessagePack.ErrorMsg] = {
    def f_astJustOrElim(reader: Reader): org.sireum.lang.ast.Just.OrElim = {
      val r = reader.read_astJustOrElim()
      return r
    }
    val r = to(data, f_astJustOrElim _)
    return r
  }

  def from_astJustAndIntro(o: org.sireum.lang.ast.Just.AndIntro, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustAndIntro(o)
    return w.result
  }

  def to_astJustAndIntro(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.AndIntro, MessagePack.ErrorMsg] = {
    def f_astJustAndIntro(reader: Reader): org.sireum.lang.ast.Just.AndIntro = {
      val r = reader.read_astJustAndIntro()
      return r
    }
    val r = to(data, f_astJustAndIntro _)
    return r
  }

  def from_astJustAndElim(o: org.sireum.lang.ast.Just.AndElim, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustAndElim(o)
    return w.result
  }

  def to_astJustAndElim(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.AndElim, MessagePack.ErrorMsg] = {
    def f_astJustAndElim(reader: Reader): org.sireum.lang.ast.Just.AndElim = {
      val r = reader.read_astJustAndElim()
      return r
    }
    val r = to(data, f_astJustAndElim _)
    return r
  }

  def from_astJustPbc(o: org.sireum.lang.ast.Just.Pbc, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astJustPbc(o)
    return w.result
  }

  def to_astJustPbc(data: ISZ[U8]): Either[org.sireum.lang.ast.Just.Pbc, MessagePack.ErrorMsg] = {
    def f_astJustPbc(reader: Reader): org.sireum.lang.ast.Just.Pbc = {
      val r = reader.read_astJustPbc()
      return r
    }
    val r = to(data, f_astJustPbc _)
    return r
  }

  def from_astTruthTableRow(o: org.sireum.lang.ast.TruthTable.Row, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTruthTableRow(o)
    return w.result
  }

  def to_astTruthTableRow(data: ISZ[U8]): Either[org.sireum.lang.ast.TruthTable.Row, MessagePack.ErrorMsg] = {
    def f_astTruthTableRow(reader: Reader): org.sireum.lang.ast.TruthTable.Row = {
      val r = reader.read_astTruthTableRow()
      return r
    }
    val r = to(data, f_astTruthTableRow _)
    return r
  }

  def from_astTruthTableAssignment(o: org.sireum.lang.ast.TruthTable.Assignment, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTruthTableAssignment(o)
    return w.result
  }

  def to_astTruthTableAssignment(data: ISZ[U8]): Either[org.sireum.lang.ast.TruthTable.Assignment, MessagePack.ErrorMsg] = {
    def f_astTruthTableAssignment(reader: Reader): org.sireum.lang.ast.TruthTable.Assignment = {
      val r = reader.read_astTruthTableAssignment()
      return r
    }
    val r = to(data, f_astTruthTableAssignment _)
    return r
  }

  def from_astTruthTableConclusion(o: org.sireum.lang.ast.TruthTable.Conclusion, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTruthTableConclusion(o)
    return w.result
  }

  def to_astTruthTableConclusion(data: ISZ[U8]): Either[org.sireum.lang.ast.TruthTable.Conclusion, MessagePack.ErrorMsg] = {
    def f_astTruthTableConclusion(reader: Reader): org.sireum.lang.ast.TruthTable.Conclusion = {
      val r = reader.read_astTruthTableConclusion()
      return r
    }
    val r = to(data, f_astTruthTableConclusion _)
    return r
  }

  def from_astTruthTableConclusionValidity(o: org.sireum.lang.ast.TruthTable.Conclusion.Validity, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTruthTableConclusionValidity(o)
    return w.result
  }

  def to_astTruthTableConclusionValidity(data: ISZ[U8]): Either[org.sireum.lang.ast.TruthTable.Conclusion.Validity, MessagePack.ErrorMsg] = {
    def f_astTruthTableConclusionValidity(reader: Reader): org.sireum.lang.ast.TruthTable.Conclusion.Validity = {
      val r = reader.read_astTruthTableConclusionValidity()
      return r
    }
    val r = to(data, f_astTruthTableConclusionValidity _)
    return r
  }

  def from_astTruthTableConclusionTautology(o: org.sireum.lang.ast.TruthTable.Conclusion.Tautology, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTruthTableConclusionTautology(o)
    return w.result
  }

  def to_astTruthTableConclusionTautology(data: ISZ[U8]): Either[org.sireum.lang.ast.TruthTable.Conclusion.Tautology, MessagePack.ErrorMsg] = {
    def f_astTruthTableConclusionTautology(reader: Reader): org.sireum.lang.ast.TruthTable.Conclusion.Tautology = {
      val r = reader.read_astTruthTableConclusionTautology()
      return r
    }
    val r = to(data, f_astTruthTableConclusionTautology _)
    return r
  }

  def from_astTruthTableConclusionContradictory(o: org.sireum.lang.ast.TruthTable.Conclusion.Contradictory, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTruthTableConclusionContradictory(o)
    return w.result
  }

  def to_astTruthTableConclusionContradictory(data: ISZ[U8]): Either[org.sireum.lang.ast.TruthTable.Conclusion.Contradictory, MessagePack.ErrorMsg] = {
    def f_astTruthTableConclusionContradictory(reader: Reader): org.sireum.lang.ast.TruthTable.Conclusion.Contradictory = {
      val r = reader.read_astTruthTableConclusionContradictory()
      return r
    }
    val r = to(data, f_astTruthTableConclusionContradictory _)
    return r
  }

  def from_astTruthTableConclusionContingent(o: org.sireum.lang.ast.TruthTable.Conclusion.Contingent, pooling: B): ISZ[U8] = {
    val w = Writer.Default(MessagePack.writer(pooling))
    w.write_astTruthTableConclusionContingent(o)
    return w.result
  }

  def to_astTruthTableConclusionContingent(data: ISZ[U8]): Either[org.sireum.lang.ast.TruthTable.Conclusion.Contingent, MessagePack.ErrorMsg] = {
    def f_astTruthTableConclusionContingent(reader: Reader): org.sireum.lang.ast.TruthTable.Conclusion.Contingent = {
      val r = reader.read_astTruthTableConclusionContingent()
      return r
    }
    val r = to(data, f_astTruthTableConclusionContingent _)
    return r
  }

}