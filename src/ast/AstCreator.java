package ast;

import parser.circBaseVisitor;
import parser.circParser;
import parser.circParser.*;

import java.util.ArrayList;

public class AstCreator extends circBaseVisitor<Ast>{
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitProgram(circParser.ProgramContext ctx) {
		Ast decl_list = ctx.getChild(0).accept(this);
		return new Program(decl_list);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitDecl(circParser.DeclContext ctx) {
		return ctx.getChild(0).accept(this); //retourne l'ast produit par le noeud fils
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	//Laury
	@Override public Ast visitExprSeule(circParser.ExprSeuleContext ctx) {
		return ctx.getChild(0).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitIfThen(circParser.IfThenContext ctx) {
		Ast condition = ctx.getChild(2).accept(this); //condition
		Ast thenB = ctx.getChild(4).accept(this);
		return new IfThen(condition, thenB);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitIfThenElse(circParser.IfThenElseContext ctx) {
		Ast condition = ctx.getChild(2).accept(this); //condition
		Ast thenB = ctx.getChild(4).accept(this);
		Ast elseB = ctx.getChild(6).accept(this);

		return new IfThenElse(condition, thenB, elseB);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitWhile(circParser.WhileContext ctx) {
		Ast condition = ctx.getChild(2).accept(this);
		Ast instruction = ctx.getChild(4).accept(this);
		return new While(condition,instruction);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitBlocInstruct(circParser.BlocInstructContext ctx) {
		return ctx.getChild(0).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitAffectInstruct(circParser.AffectInstructContext ctx) {
		return ctx.getChild(0).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitReturn(circParser.ReturnContext ctx) {
		Ast retour = ctx.getChild(1).accept(this);
		return new Return(retour);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitAffectation(circParser.AffectationContext ctx) {
		String identString = ctx.getChild(0).toString(); // récupère la valeur du terminal Ident
		Ast expr = ctx.getChild(2).accept(this); //on génère l'AST

		//creation des sous AST
		Ident ident = new Ident(identString);

		return new Affectation(ident, expr);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitListe_decl_vars(circParser.Liste_decl_varsContext ctx) {
		ArrayList<Ast> liste = new ArrayList<Ast>();
		int i=0;
		while(ctx.getChild(i) != null){
			Ast expr = ctx.getChild(i).accept(this);
			liste.add(expr);
			i++;
		}
		return new ListeDeclVars(liste);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitListe_instruction(circParser.Liste_instructionContext ctx) {
		ArrayList<Ast> liste = new ArrayList<Ast>();
		int i=0;
		while(ctx.getChild(i) != null){
			Ast expr = ctx.getChild(i).accept(this);
			liste.add(expr);
			i++;
		}
		return new ListeInstruction(liste);
	}


	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitBloc(circParser.BlocContext ctx) {
		Ast declarations = ctx.getChild(1).accept(this); //condition
		Ast instructions = ctx.getChild(2).accept(this);
		return new Bloc(declarations,instructions);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitExpr2(circParser.Expr2Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitPlus(circParser.PlusContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitMult(circParser.MultContext ctx) { return visitChildren(ctx); }
}
