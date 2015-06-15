// Generated from /Users/robby/Repositories/Sireum-Private/sireumv3/core/sireum-pilar-parser/src/main/resources/org/sireum/pilar/parser/Pilar.g4 by ANTLR 4.5
package org.sireum.pilar.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PilarParser}.
 */
public interface PilarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PilarParser#model}.
	 * @param ctx the parse tree
	 */
	void enterModel(@NotNull PilarParser.ModelContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilarParser#model}.
	 * @param ctx the parse tree
	 */
	void exitModel(@NotNull PilarParser.ModelContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilarParser#modelElement}.
	 * @param ctx the parse tree
	 */
	void enterModelElement(@NotNull PilarParser.ModelElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilarParser#modelElement}.
	 * @param ctx the parse tree
	 */
	void exitModelElement(@NotNull PilarParser.ModelElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilarParser#globalVarDecl}.
	 * @param ctx the parse tree
	 */
	void enterGlobalVarDecl(@NotNull PilarParser.GlobalVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilarParser#globalVarDecl}.
	 * @param ctx the parse tree
	 */
	void exitGlobalVarDecl(@NotNull PilarParser.GlobalVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilarParser#procDecl}.
	 * @param ctx the parse tree
	 */
	void enterProcDecl(@NotNull PilarParser.ProcDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilarParser#procDecl}.
	 * @param ctx the parse tree
	 */
	void exitProcDecl(@NotNull PilarParser.ProcDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilarParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(@NotNull PilarParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilarParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(@NotNull PilarParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilarParser#procBody}.
	 * @param ctx the parse tree
	 */
	void enterProcBody(@NotNull PilarParser.ProcBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilarParser#procBody}.
	 * @param ctx the parse tree
	 */
	void exitProcBody(@NotNull PilarParser.ProcBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilarParser#localVarDecl}.
	 * @param ctx the parse tree
	 */
	void enterLocalVarDecl(@NotNull PilarParser.LocalVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilarParser#localVarDecl}.
	 * @param ctx the parse tree
	 */
	void exitLocalVarDecl(@NotNull PilarParser.LocalVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilarParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(@NotNull PilarParser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilarParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(@NotNull PilarParser.LocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilarParser#transformation}.
	 * @param ctx the parse tree
	 */
	void enterTransformation(@NotNull PilarParser.TransformationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilarParser#transformation}.
	 * @param ctx the parse tree
	 */
	void exitTransformation(@NotNull PilarParser.TransformationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilarParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(@NotNull PilarParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilarParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(@NotNull PilarParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilarParser#jump}.
	 * @param ctx the parse tree
	 */
	void enterJump(@NotNull PilarParser.JumpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilarParser#jump}.
	 * @param ctx the parse tree
	 */
	void exitJump(@NotNull PilarParser.JumpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilarParser#switchCase}.
	 * @param ctx the parse tree
	 */
	void enterSwitchCase(@NotNull PilarParser.SwitchCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilarParser#switchCase}.
	 * @param ctx the parse tree
	 */
	void exitSwitchCase(@NotNull PilarParser.SwitchCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilarParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(@NotNull PilarParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilarParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(@NotNull PilarParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilarParser#prim}.
	 * @param ctx the parse tree
	 */
	void enterPrim(@NotNull PilarParser.PrimContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilarParser#prim}.
	 * @param ctx the parse tree
	 */
	void exitPrim(@NotNull PilarParser.PrimContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilarParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(@NotNull PilarParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilarParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(@NotNull PilarParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilarParser#lit}.
	 * @param ctx the parse tree
	 */
	void enterLit(@NotNull PilarParser.LitContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilarParser#lit}.
	 * @param ctx the parse tree
	 */
	void exitLit(@NotNull PilarParser.LitContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilarParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(@NotNull PilarParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilarParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(@NotNull PilarParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilarParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(@NotNull PilarParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilarParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(@NotNull PilarParser.AnnotationContext ctx);
}