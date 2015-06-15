// Generated from /Users/robby/Repositories/Sireum-Private/sireumv3/core/sireum-pilar-parser/src/main/resources/org/sireum/pilar/parser/Pilar.g4 by ANTLR 4.5
package org.sireum.pilar.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PilarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PilarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PilarParser#model}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModel(@NotNull PilarParser.ModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilarParser#modelElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelElement(@NotNull PilarParser.ModelElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilarParser#globalVarDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalVarDecl(@NotNull PilarParser.GlobalVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilarParser#procDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcDecl(@NotNull PilarParser.ProcDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilarParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(@NotNull PilarParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilarParser#procBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcBody(@NotNull PilarParser.ProcBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilarParser#localVarDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVarDecl(@NotNull PilarParser.LocalVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilarParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation(@NotNull PilarParser.LocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilarParser#transformation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransformation(@NotNull PilarParser.TransformationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilarParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction(@NotNull PilarParser.ActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilarParser#jump}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump(@NotNull PilarParser.JumpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilarParser#switchCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchCase(@NotNull PilarParser.SwitchCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(@NotNull PilarParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilarParser#prim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrim(@NotNull PilarParser.PrimContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilarParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(@NotNull PilarParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilarParser#lit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLit(@NotNull PilarParser.LitContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilarParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(@NotNull PilarParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilarParser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(@NotNull PilarParser.AnnotationContext ctx);
}