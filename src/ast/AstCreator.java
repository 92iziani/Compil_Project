package ast;

import parser.circBaseVisitor;
import parser.circParser;
import parser.circParser.*;

import java.util.ArrayList;

public class AstCreator extends circBaseVisitor<Ast> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override
	public Ast visitProgram(circParser.ProgramContext ctx) {
		Ast decl_list = ctx.getChild(0).accept(this);
		return new Program(decl_list);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override
	public Ast visitDecl(circParser.DeclContext ctx) {
		return ctx.getChild(0).accept(this); //retourne l'ast produit par le noeud fils
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	//Laury
	@Override
	public Ast visitExprSeule(circParser.ExprSeuleContext ctx) {
		return ctx.getChild(0).accept(this);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override
	public Ast visitIfThen(circParser.IfThenContext ctx) {
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
	@Override
	public Ast visitIfThenElse(circParser.IfThenElseContext ctx) {
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
	@Override
	public Ast visitWhile(circParser.WhileContext ctx) {
		Ast condition = ctx.getChild(2).accept(this);
		Ast instruction = ctx.getChild(4).accept(this);
		return new While(condition, instruction);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override
	public Ast visitBlocInstruct(circParser.BlocInstructContext ctx) {
		return ctx.getChild(0).accept(this);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override
	public Ast visitAffectInstruct(circParser.AffectInstructContext ctx) {
		return ctx.getChild(0).accept(this);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override
	public Ast visitReturn(circParser.ReturnContext ctx) {
		Ast retour = ctx.getChild(1).accept(this);
		return new Return(retour);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override
	public Ast visitAffectation(circParser.AffectationContext ctx) {
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
	@Override
	public Ast visitListe_decl_vars(circParser.Liste_decl_varsContext ctx) {
		ArrayList<Ast> liste = new ArrayList<Ast>();
		int i = 0;
		while (ctx.getChild(i) != null) {
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
	@Override
	public Ast visitListe_instruction(circParser.Liste_instructionContext ctx) {
		ArrayList<Ast> liste = new ArrayList<Ast>();
		int i = 0;
		while (ctx.getChild(i) != null) {
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
	@Override
	public Ast visitBloc(circParser.BlocContext ctx) {
		Ast declarations = ctx.getChild(1).accept(this); //condition
		Ast instructions = ctx.getChild(2).accept(this);
		return new Bloc(declarations, instructions);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override
	public Ast visitExpr2(circParser.Expr2Context ctx) {
		return ctx.getChild(0).accept(this);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override
	public Ast visitPlus(circParser.PlusContext ctx) {
		Ast noeudTemporaire = ctx.getChild(0).accept(this);

		for (int i = 0; 2 * i < ctx.getChildCount() - 1; i++) {

			String operation = ctx.getChild(2 * i + 1).toString();
			Ast right = ctx.getChild(2 * (i + 1)).accept(this);

			switch (operation) {
				case "-":
					noeudTemporaire = new Minus(noeudTemporaire, right);
					break;
				case "+":
					noeudTemporaire = new Plus(noeudTemporaire, right);
					break;
				default:
					//gérer quand c'est ni un moins ni un plus
					break;
			}
		}
		return noeudTemporaire;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override
	public Ast visitMult(circParser.MultContext ctx) {
		Ast noeudTemporaire = ctx.getChild(0).accept(this);

		for (int i = 0; 2 * i < ctx.getChildCount() - 1; i++) {

			String operation = ctx.getChild(2 * i + 1).toString();
			Ast right = ctx.getChild(2 * (i + 1)).accept(this);

			switch (operation) {
				case "*":
					noeudTemporaire = new Mult(noeudTemporaire, right);
					break;
				case "/":
					noeudTemporaire = new Divide(noeudTemporaire, right);
					break;
				default:
					//gérer quand c'est ni un moins ni un plus
					break;
			}
		}
		return noeudTemporaire;
	}
	@Override
	public Ast visitDecla(circParser.DeclaContext ctx) {

		int sizea = ctx.getChildCount();
		int sizeb = sizea - 3;
		ArrayList<Ident> Listedident = new ArrayList<>();

		for (int i=1 ; i< sizeb; i++) {
			if (i%2==1){
				String identString = ctx.getChild(i).toString();
				Ident ident = new Ident(identString);
				Listedident.add(ident);
			}
		}

		String identString = ctx.getChild(sizea-1).toString();
		Ident ident = new Ident(identString);
		Listedident.add(ident);
		return new DeclaList(Listedident); }

	@Override
	public Ast visitStruct(circParser.StructContext ctx) {
		int sizea = ctx.getChildCount();
		String a = new String("");
		ArrayList<Ident> ListeStruct = new ArrayList<>();

		String identString = ctx.getChild(1).toString();
		Ident ident = new Ident(identString);
		ListeStruct.add(ident);
	

		for (int i=1 ; i< sizea-1; i++) {

			a=ctx.getChild(i).toString();

			if ((a!="(")&(a!=")")&(a!="*")&(a!=",")){
				Ident ident2 = new Ident(a);
				ListeStruct.add(ident2);
			}
		}

		return new Struct(ListeStruct); 

	}
	@Override
	public Ast visitDeclaAffect(circParser.DeclaAffectContext ctx) {
		String identString = ctx.getChild(1).toString();
		String entierString = ctx.getChild(2).toString();

		Ident ident = new Ident(identString);
		Entier entier = new Entier(entierString);
		return new DeclaAffect(ident,entier);
	}

	@Override
	public Ast visitDecl_typ(circParser.Decl_typContext ctx) {
		String identString = ctx.getChild(1).toString();
		Ident ident = new Ident(identString);
		Ast liste_decl_vars =ctx.getChild(3).accept(this);

	return new DeclTyp(ident,liste_decl_vars);
	}

	@Override
	public Ast visitIntParam(circParser.IntParamContext ctx) {
		String identString = ctx.getChild(1).toString();
		Ident ident = new Ident(identString);

		Ast liste_param =ctx.getChild(3).accept(this);
		Ast bloc=ctx.getChild(5).accept(this);

	return new IntParam(ident,liste_param,bloc);
	}

	@Override
	public Ast visitStructParam(circParser.StructParamContext ctx) {
		String identString1 = ctx.getChild(1).toString();
		Ident ident1 = new Ident(identString1);

		String identString2 = ctx.getChild(3).toString();
		Ident ident2 = new Ident(identString2);

		Ast listeParam =ctx.getChild(5).accept(this);
		Ast bloc=ctx.getChild(7).accept(this);

	return new StructParam(ident1,ident2,listeParam,bloc);
	}

	@Override
	public Ast visitListeParam(circParser.Liste_paramContext ctx) {
		ArrayList<Ast> listeparam = new ArrayList<Ast>();
		int i = 0;
		while (ctx.getChild(i) != null) {
		Ast param = ctx.getChild(i).accept(this);
		listeparam.add(param);
		i++;
		}
		return new ListeParam(listeparam);
	}
}