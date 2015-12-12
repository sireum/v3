// Generated from /Users/robby/Repositories/Sireum-Private/sireum-v3/logika/sireum-logika-parser-antlr4/src/main/resources/org/sireum/logika/parser/Antlr4Logika.g4 by ANTLR 4.5.1
package org.sireum.logika.parser;

// @formatter:off

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Antlr4LogikaParser}.
 */
public interface Antlr4LogikaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Antlr4LogikaParser#sequent}.
	 * @param ctx the parse tree
	 */
	void enterSequent(Antlr4LogikaParser.SequentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Antlr4LogikaParser#sequent}.
	 * @param ctx the parse tree
	 */
	void exitSequent(Antlr4LogikaParser.SequentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Antlr4LogikaParser#proof}.
	 * @param ctx the parse tree
	 */
	void enterProof(Antlr4LogikaParser.ProofContext ctx);
	/**
	 * Exit a parse tree produced by {@link Antlr4LogikaParser#proof}.
	 * @param ctx the parse tree
	 */
	void exitProof(Antlr4LogikaParser.ProofContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Step}
	 * labeled alternative in {@link Antlr4LogikaParser#proofStep}.
	 * @param ctx the parse tree
	 */
	void enterStep(Antlr4LogikaParser.StepContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Step}
	 * labeled alternative in {@link Antlr4LogikaParser#proofStep}.
	 * @param ctx the parse tree
	 */
	void exitStep(Antlr4LogikaParser.StepContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SubProof}
	 * labeled alternative in {@link Antlr4LogikaParser#proofStep}.
	 * @param ctx the parse tree
	 */
	void enterSubProof(Antlr4LogikaParser.SubProofContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SubProof}
	 * labeled alternative in {@link Antlr4LogikaParser#proofStep}.
	 * @param ctx the parse tree
	 */
	void exitSubProof(Antlr4LogikaParser.SubProofContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link Antlr4LogikaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterVar(Antlr4LogikaParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link Antlr4LogikaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitVar(Antlr4LogikaParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Apply}
	 * labeled alternative in {@link Antlr4LogikaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterApply(Antlr4LogikaParser.ApplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Apply}
	 * labeled alternative in {@link Antlr4LogikaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitApply(Antlr4LogikaParser.ApplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bottom}
	 * labeled alternative in {@link Antlr4LogikaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterBottom(Antlr4LogikaParser.BottomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bottom}
	 * labeled alternative in {@link Antlr4LogikaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitBottom(Antlr4LogikaParser.BottomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Binary}
	 * labeled alternative in {@link Antlr4LogikaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterBinary(Antlr4LogikaParser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Binary}
	 * labeled alternative in {@link Antlr4LogikaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitBinary(Antlr4LogikaParser.BinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link Antlr4LogikaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterUnary(Antlr4LogikaParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link Antlr4LogikaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitUnary(Antlr4LogikaParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link Antlr4LogikaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterInt(Antlr4LogikaParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link Antlr4LogikaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitInt(Antlr4LogikaParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link Antlr4LogikaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterParen(Antlr4LogikaParser.ParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link Antlr4LogikaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitParen(Antlr4LogikaParser.ParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Result}
	 * labeled alternative in {@link Antlr4LogikaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterResult(Antlr4LogikaParser.ResultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Result}
	 * labeled alternative in {@link Antlr4LogikaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitResult(Antlr4LogikaParser.ResultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Quant}
	 * labeled alternative in {@link Antlr4LogikaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterQuant(Antlr4LogikaParser.QuantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Quant}
	 * labeled alternative in {@link Antlr4LogikaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitQuant(Antlr4LogikaParser.QuantContext ctx);
	/**
	 * Enter a parse tree produced by {@link Antlr4LogikaParser#qformula}.
	 * @param ctx the parse tree
	 */
	void enterQformula(Antlr4LogikaParser.QformulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link Antlr4LogikaParser#qformula}.
	 * @param ctx the parse tree
	 */
	void exitQformula(Antlr4LogikaParser.QformulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Premise}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void enterPremise(Antlr4LogikaParser.PremiseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Premise}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void exitPremise(Antlr4LogikaParser.PremiseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndIntro}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void enterAndIntro(Antlr4LogikaParser.AndIntroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndIntro}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void exitAndIntro(Antlr4LogikaParser.AndIntroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndElim1}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void enterAndElim1(Antlr4LogikaParser.AndElim1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code AndElim1}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void exitAndElim1(Antlr4LogikaParser.AndElim1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code AndElim2}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void enterAndElim2(Antlr4LogikaParser.AndElim2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code AndElim2}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void exitAndElim2(Antlr4LogikaParser.AndElim2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code OrIntro1}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void enterOrIntro1(Antlr4LogikaParser.OrIntro1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code OrIntro1}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void exitOrIntro1(Antlr4LogikaParser.OrIntro1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code OrIntro2}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void enterOrIntro2(Antlr4LogikaParser.OrIntro2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code OrIntro2}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void exitOrIntro2(Antlr4LogikaParser.OrIntro2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code OrElim}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void enterOrElim(Antlr4LogikaParser.OrElimContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrElim}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void exitOrElim(Antlr4LogikaParser.OrElimContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImpliesIntro}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void enterImpliesIntro(Antlr4LogikaParser.ImpliesIntroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImpliesIntro}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void exitImpliesIntro(Antlr4LogikaParser.ImpliesIntroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImpliesElim}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void enterImpliesElim(Antlr4LogikaParser.ImpliesElimContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImpliesElim}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void exitImpliesElim(Antlr4LogikaParser.ImpliesElimContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegIntro}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void enterNegIntro(Antlr4LogikaParser.NegIntroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegIntro}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void exitNegIntro(Antlr4LogikaParser.NegIntroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegElim}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void enterNegElim(Antlr4LogikaParser.NegElimContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegElim}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void exitNegElim(Antlr4LogikaParser.NegElimContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BottomElim}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void enterBottomElim(Antlr4LogikaParser.BottomElimContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BottomElim}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void exitBottomElim(Antlr4LogikaParser.BottomElimContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Pbc}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void enterPbc(Antlr4LogikaParser.PbcContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Pbc}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void exitPbc(Antlr4LogikaParser.PbcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForallIntro}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void enterForallIntro(Antlr4LogikaParser.ForallIntroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForallIntro}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void exitForallIntro(Antlr4LogikaParser.ForallIntroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForallElim}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void enterForallElim(Antlr4LogikaParser.ForallElimContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForallElim}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void exitForallElim(Antlr4LogikaParser.ForallElimContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExistsIntro}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void enterExistsIntro(Antlr4LogikaParser.ExistsIntroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExistsIntro}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void exitExistsIntro(Antlr4LogikaParser.ExistsIntroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Exists}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void enterExists(Antlr4LogikaParser.ExistsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exists}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void exitExists(Antlr4LogikaParser.ExistsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Algebra}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void enterAlgebra(Antlr4LogikaParser.AlgebraContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Algebra}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void exitAlgebra(Antlr4LogikaParser.AlgebraContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Auto}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void enterAuto(Antlr4LogikaParser.AutoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Auto}
	 * labeled alternative in {@link Antlr4LogikaParser#justification}.
	 * @param ctx the parse tree
	 */
	void exitAuto(Antlr4LogikaParser.AutoContext ctx);
	/**
	 * Enter a parse tree produced by {@link Antlr4LogikaParser#numOrId}.
	 * @param ctx the parse tree
	 */
	void enterNumOrId(Antlr4LogikaParser.NumOrIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link Antlr4LogikaParser#numOrId}.
	 * @param ctx the parse tree
	 */
	void exitNumOrId(Antlr4LogikaParser.NumOrIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link Antlr4LogikaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(Antlr4LogikaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link Antlr4LogikaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(Antlr4LogikaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarDeclStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclStmt(Antlr4LogikaParser.VarDeclStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarDeclStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclStmt(Antlr4LogikaParser.VarDeclStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignVarStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignVarStmt(Antlr4LogikaParser.AssignVarStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignVarStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignVarStmt(Antlr4LogikaParser.AssignVarStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssertStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssertStmt(Antlr4LogikaParser.AssertStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssertStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssertStmt(Antlr4LogikaParser.AssertStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(Antlr4LogikaParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(Antlr4LogikaParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(Antlr4LogikaParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(Antlr4LogikaParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReadIntStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterReadIntStmt(Antlr4LogikaParser.ReadIntStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReadIntStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitReadIntStmt(Antlr4LogikaParser.ReadIntStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(Antlr4LogikaParser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(Antlr4LogikaParser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodInvocationStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocationStmt(Antlr4LogikaParser.MethodInvocationStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodInvocationStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocationStmt(Antlr4LogikaParser.MethodInvocationStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayCloneStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterArrayCloneStmt(Antlr4LogikaParser.ArrayCloneStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayCloneStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitArrayCloneStmt(Antlr4LogikaParser.ArrayCloneStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignArrayStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignArrayStmt(Antlr4LogikaParser.AssignArrayStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignArrayStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignArrayStmt(Antlr4LogikaParser.AssignArrayStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodDeclStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclStmt(Antlr4LogikaParser.MethodDeclStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodDeclStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclStmt(Antlr4LogikaParser.MethodDeclStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogikaStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterLogikaStmt(Antlr4LogikaParser.LogikaStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogikaStmt}
	 * labeled alternative in {@link Antlr4LogikaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitLogikaStmt(Antlr4LogikaParser.LogikaStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdExp}
	 * labeled alternative in {@link Antlr4LogikaParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIdExp(Antlr4LogikaParser.IdExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdExp}
	 * labeled alternative in {@link Antlr4LogikaParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIdExp(Antlr4LogikaParser.IdExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExp}
	 * labeled alternative in {@link Antlr4LogikaParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterParenExp(Antlr4LogikaParser.ParenExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExp}
	 * labeled alternative in {@link Antlr4LogikaParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitParenExp(Antlr4LogikaParser.ParenExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BigIntExp}
	 * labeled alternative in {@link Antlr4LogikaParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBigIntExp(Antlr4LogikaParser.BigIntExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BigIntExp}
	 * labeled alternative in {@link Antlr4LogikaParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBigIntExp(Antlr4LogikaParser.BigIntExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExp}
	 * labeled alternative in {@link Antlr4LogikaParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExp(Antlr4LogikaParser.UnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExp}
	 * labeled alternative in {@link Antlr4LogikaParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExp(Antlr4LogikaParser.UnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntExp}
	 * labeled alternative in {@link Antlr4LogikaParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIntExp(Antlr4LogikaParser.IntExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntExp}
	 * labeled alternative in {@link Antlr4LogikaParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIntExp(Antlr4LogikaParser.IntExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SeqExp}
	 * labeled alternative in {@link Antlr4LogikaParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSeqExp(Antlr4LogikaParser.SeqExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SeqExp}
	 * labeled alternative in {@link Antlr4LogikaParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSeqExp(Antlr4LogikaParser.SeqExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryExp}
	 * labeled alternative in {@link Antlr4LogikaParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExp(Antlr4LogikaParser.BinaryExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryExp}
	 * labeled alternative in {@link Antlr4LogikaParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExp(Antlr4LogikaParser.BinaryExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link Antlr4LogikaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntType(Antlr4LogikaParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link Antlr4LogikaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntType(Antlr4LogikaParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntSeqType}
	 * labeled alternative in {@link Antlr4LogikaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntSeqType(Antlr4LogikaParser.IntSeqTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntSeqType}
	 * labeled alternative in {@link Antlr4LogikaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntSeqType(Antlr4LogikaParser.IntSeqTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Antlr4LogikaParser#loopInvariant}.
	 * @param ctx the parse tree
	 */
	void enterLoopInvariant(Antlr4LogikaParser.LoopInvariantContext ctx);
	/**
	 * Exit a parse tree produced by {@link Antlr4LogikaParser#loopInvariant}.
	 * @param ctx the parse tree
	 */
	void exitLoopInvariant(Antlr4LogikaParser.LoopInvariantContext ctx);
	/**
	 * Enter a parse tree produced by {@link Antlr4LogikaParser#modifies}.
	 * @param ctx the parse tree
	 */
	void enterModifies(Antlr4LogikaParser.ModifiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Antlr4LogikaParser#modifies}.
	 * @param ctx the parse tree
	 */
	void exitModifies(Antlr4LogikaParser.ModifiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Antlr4LogikaParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(Antlr4LogikaParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Antlr4LogikaParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(Antlr4LogikaParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link Antlr4LogikaParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(Antlr4LogikaParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link Antlr4LogikaParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(Antlr4LogikaParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link Antlr4LogikaParser#methodContract}.
	 * @param ctx the parse tree
	 */
	void enterMethodContract(Antlr4LogikaParser.MethodContractContext ctx);
	/**
	 * Exit a parse tree produced by {@link Antlr4LogikaParser#methodContract}.
	 * @param ctx the parse tree
	 */
	void exitMethodContract(Antlr4LogikaParser.MethodContractContext ctx);
	/**
	 * Enter a parse tree produced by {@link Antlr4LogikaParser#invariants}.
	 * @param ctx the parse tree
	 */
	void enterInvariants(Antlr4LogikaParser.InvariantsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Antlr4LogikaParser#invariants}.
	 * @param ctx the parse tree
	 */
	void exitInvariants(Antlr4LogikaParser.InvariantsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Antlr4LogikaParser#facts}.
	 * @param ctx the parse tree
	 */
	void enterFacts(Antlr4LogikaParser.FactsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Antlr4LogikaParser#facts}.
	 * @param ctx the parse tree
	 */
	void exitFacts(Antlr4LogikaParser.FactsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Antlr4LogikaParser#fact}.
	 * @param ctx the parse tree
	 */
	void enterFact(Antlr4LogikaParser.FactContext ctx);
	/**
	 * Exit a parse tree produced by {@link Antlr4LogikaParser#fact}.
	 * @param ctx the parse tree
	 */
	void exitFact(Antlr4LogikaParser.FactContext ctx);
	/**
	 * Enter a parse tree produced by {@link Antlr4LogikaParser#sequentFile}.
	 * @param ctx the parse tree
	 */
	void enterSequentFile(Antlr4LogikaParser.SequentFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link Antlr4LogikaParser#sequentFile}.
	 * @param ctx the parse tree
	 */
	void exitSequentFile(Antlr4LogikaParser.SequentFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link Antlr4LogikaParser#proofFile}.
	 * @param ctx the parse tree
	 */
	void enterProofFile(Antlr4LogikaParser.ProofFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link Antlr4LogikaParser#proofFile}.
	 * @param ctx the parse tree
	 */
	void exitProofFile(Antlr4LogikaParser.ProofFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link Antlr4LogikaParser#programFile}.
	 * @param ctx the parse tree
	 */
	void enterProgramFile(Antlr4LogikaParser.ProgramFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link Antlr4LogikaParser#programFile}.
	 * @param ctx the parse tree
	 */
	void exitProgramFile(Antlr4LogikaParser.ProgramFileContext ctx);
}