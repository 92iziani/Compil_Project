package ast;

import parser.circBaseVisitor;
import parser.circParser;
import parser.circParser.*;

import java.util.ArrayList;

public class AstCreator extends circBaseVisitor<Ast> {

	//DONE
	@Override
	public Ast visitProgram(circParser.ProgramContext ctx) {
		ArrayList<Ast> liste = new ArrayList<Ast>();
		int i = 0;
		while (ctx.getChild(i) != null) {
			Ast expr = ctx.getChild(i).accept(this);
			liste.add(expr);
			i++;
		}
		return new Program(liste);
	}

	//DONE ?
	@Override
	public Ast visitDecl(circParser.DeclContext ctx) {
		return ctx.getChild(0).accept(this); //retourne l'ast produit par le noeud fils
	}

	//DONE
	@Override
	public Ast visitExprSeule(circParser.ExprSeuleContext ctx) {
		return ctx.getChild(0).accept(this);
	}

	//DONE
	@Override
	public Ast visitIfThen(circParser.IfThenContext ctx) {
		Ast condition = ctx.getChild(2).accept(this); //condition
		Ast thenB = ctx.getChild(4).accept(this);

		return new IfThen(ctx.start.getLine(),condition, thenB);
	}

	//DONE
	@Override
	public Ast visitIfThenElse(circParser.IfThenElseContext ctx) {
		Ast condition = ctx.getChild(2).accept(this); //condition
		Ast thenB = ctx.getChild(4).accept(this);
		Ast elseB = ctx.getChild(6).accept(this);

		return new IfThenElse(ctx.start.getLine(),condition, thenB, elseB);
	}

	//DONE
	@Override
	public Ast visitWhile(circParser.WhileContext ctx) {
		Ast condition = ctx.getChild(2).accept(this);
		Ast instruction = ctx.getChild(4).accept(this);
		return new While(ctx.start.getLine(),condition, instruction);
	}

	//DONE
	@Override
	public Ast visitBlocInstruct(circParser.BlocInstructContext ctx) {
		return ctx.getChild(0).accept(this);
	}

	//DONE
	@Override
	public Ast visitAffectInstruct(circParser.AffectInstructContext ctx) {
		return ctx.getChild(0).accept(this);
	}

	@Override
	public Ast visitAffectExpr(circParser.AffectExprContext ctx) {
		return ctx.getChild(0).accept(this);
	}


	//DONE
	@Override
	public Ast visitReturn(circParser.ReturnContext ctx) {
		Ast retour = ctx.getChild(1).accept(this);
		return new Return(ctx.start.getLine(),retour);
	}

	//DONE
	@Override
	public Ast visitAffectation(circParser.AffectationContext ctx) {
		String identString = ctx.getChild(0).toString(); // récupère la valeur du terminal Ident
		Ast expr = ctx.getChild(2).accept(this); //on génère l'AST

		//creation des sous AST
		Ident ident = new Ident(ctx.start.getLine(),identString);

		return new Affectation(ctx.start.getLine(),ident, expr);
	}

	//DONE
	@Override
	public Ast visitListe_decl_vars(circParser.Liste_decl_varsContext ctx) {
		ArrayList<Ast> liste = new ArrayList<Ast>();
		int i = 0;
		while (ctx.getChild(i) != null) {
			Ast expr = ctx.getChild(i).accept(this);
			liste.add(expr);
			i++;
		}
		return new ListeDeclVars(ctx.start.getLine(),liste);
	}

	//DONE
	@Override
	public Ast visitListe_instruction(circParser.Liste_instructionContext ctx) {
		ArrayList<Ast> liste = new ArrayList<Ast>();
		int i = 0;
		while (ctx.getChild(i) != null) {
			Ast expr = ctx.getChild(i).accept(this);
			liste.add(expr);
			i++;
		}
		return new ListeInstruction(ctx.start.getLine(),liste);
	}


	//DONE
	@Override
	public Ast visitBloc(circParser.BlocContext ctx) {
		Ast declarations = ctx.getChild(1).accept(this); //condition
		Ast instructions = ctx.getChild(2).accept(this);
		return new Bloc(declarations, instructions);
	}


	@Override
	public Ast visitExpr2(circParser.Expr2Context ctx) {
		return ctx.getChild(0).accept(this);
	}

	//DONE
	@Override
	public Ast visitPlus(circParser.PlusContext ctx) {
		Ast noeudTemporaire = ctx.getChild(0).accept(this);

		for (int i = 0; 2 * i < ctx.getChildCount() - 1; i++) {

			String operation = ctx.getChild(2 * i + 1).toString();
			Ast right = ctx.getChild(2 * (i + 1)).accept(this);

			switch (operation) {
				case "-":
					noeudTemporaire = new Minus(ctx.start.getLine(),noeudTemporaire, right);
					break;
				case "+":
					noeudTemporaire = new Plus(ctx.start.getLine(),noeudTemporaire, right);
					break;
				default:
					//gérer quand c'est ni un moins ni un plus
					break;
			}
		}
		return noeudTemporaire;
	}

	//DONE
	@Override
	public Ast visitMult(circParser.MultContext ctx) {
		Ast noeudTemporaire = ctx.getChild(0).accept(this);

		for (int i = 0; 2 * i < ctx.getChildCount() - 1; i++) {

			String operation = ctx.getChild(2 * i + 1).toString();
			Ast right = ctx.getChild(2 * (i + 1)).accept(this);

			switch (operation) {
				case "*":
					noeudTemporaire = new Mult(ctx.start.getLine(),noeudTemporaire, right);
					break;
				case "/":
					noeudTemporaire = new Divide(ctx.start.getLine(),noeudTemporaire, right);
					break;
				default:
					//gérer quand c'est ni un moins ni un plus
					break;
			}
		}
		return noeudTemporaire;
	}

	//DONE
	@Override
	public Ast visitDecla(circParser.DeclaContext ctx) {

		int sizea = ctx.getChildCount();
		//int sizeb = sizea - 3;
		int sizeb = sizea - 2;
		ArrayList<Ident> Listedident = new ArrayList<>();

		for (int i=0 ; i< sizeb+1; i++) {
			if (i%2==1){
				String identString = ctx.getChild(i).toString();
				Ident ident = new Ident(ctx.start.getLine(),identString);
				Listedident.add(ident);
			}
		}

		return new DeclaList(ctx.start.getLine(),Listedident); }

	//XXXXXXXX NOT DONE
	@Override
	public Ast visitStruct(circParser.StructContext ctx) {
		int size = ctx.getChildCount();
		ArrayList<Ident> list = new ArrayList<Ident>();
		int i=1;
		//String a = ctx.getChild(1).toString();
		while(i<size){
			if (i==1){
				String a = ctx.getChild(1).toString();
				Ident id = new Ident(ctx.start.getLine(),a);
				list.add(id);
				i = i+2;
			}
			String a = ctx.getChild(i).toString();
			Ident id = new Ident(ctx.start.getLine(),a);
			list.add(id);
			i = i + 3 ;
		}
		return new Struct(ctx.start.getLine(),list);

	}

	//DONE
	@Override
	public Ast visitDeclaAffect(circParser.DeclaAffectContext ctx) {
		String identString = ctx.getChild(1).toString();
		String entierString = ctx.getChild(3).toString();
		Ident ident = new Ident(ctx.start.getLine(),identString);
		Entier entier = new Entier(ctx.start.getLine(),entierString);
		return new DeclaAffect(ctx.start.getLine(),ident,entier);
	}

	//DONE
	@Override
	public Ast visitDecl_typ(circParser.Decl_typContext ctx) {
		String identString = ctx.getChild(1).toString();
		Ident ident = new Ident(ctx.start.getLine(),identString);
		Ast liste_decl_vars =ctx.getChild(3).accept(this);

	return new DeclTyp(ctx.start.getLine(),ident,liste_decl_vars);
	}

	//DONE
	@Override
	public Ast visitIntParam(circParser.IntParamContext ctx) {
		String identString = ctx.getChild(1).toString();
		Ident ident = new Ident(ctx.start.getLine(),identString);

		Ast liste_param = ctx.getChild(3).accept(this);
		Ast bloc = ctx.getChild(5).accept(this);

	return new IntParam(ctx.start.getLine(),ident,liste_param,bloc);
	}

	//DONE
	@Override
	public Ast visitStructParam(circParser.StructParamContext ctx) {
		String identString1 = ctx.getChild(1).toString();
		Ident ident1 = new Ident(ctx.start.getLine(),identString1);

		String identString2 = ctx.getChild(3).toString();
		Ident ident2 = new Ident(ctx.start.getLine(),identString2);

		Ast listeParam =ctx.getChild(5).accept(this);
		Ast bloc=ctx.getChild(7).accept(this);

	return new StructParam(ctx.start.getLine(),ident1,ident2,listeParam,bloc);
	}

	//DONE
	/*@Override
	public Ast visitListe_param(circParser.Liste_paramContext ctx) {
		Ast ast =  ctx.getChild(0).accept(this);
		return new ListeParam(ast);
	}*/

	//DONE
	@Override public Ast visitEntier(circParser.EntierContext ctx) { 
		
		String integer = ctx.getChild(0).toString();
		return new Entier(ctx.start.getLine(),integer);
	 }

	//DONE
	@Override public Ast visitIdent(circParser.IdentContext ctx) { 
		
		String ident = ctx.getChild(0).toString();
		return new Ident(ctx.start.getLine(),ident);
	 }

	//DONE
	 @Override public Ast visitParenthExpr(circParser.ParenthExprContext ctx) { 
		Ast expr = ctx.getChild(1).accept(this);
		return new ParenthExpr(ctx.start.getLine(),expr);
	 }

	//DONE
	 @Override public Ast visitExclaExpr(circParser.ExclaExprContext ctx) { 
		
		Ast expr = ctx.getChild(1).accept(this);
		return new ExclaExpr(ctx.start.getLine(),expr);
	 }

	//DONE
	@Override public Ast visitTiretExpr(circParser.TiretExprContext ctx) {
		
		Ast expr = ctx.getChild(1).accept(this);
		return new TiretExpr(ctx.start.getLine(),expr);
	 }

	//DONE
	@Override public Ast visitSizeof(circParser.SizeofContext ctx) {
		
		String idf = ctx.getChild(3).toString();
		Ident ident = new Ident(ctx.start.getLine(),idf);
		return new Sizeof(ctx.start.getLine(),ident);
	 }
	 //not sure
	 @Override public Ast visitIdentExprPointeur(circParser.IdentExprPointeurContext ctx) { 
		
		String idf = ctx.getChild(0).toString();
		Ident ident = new Ident(ctx.start.getLine(),idf);
		Ast listexpr = ctx.getChild(2).accept(this);
		return new IdentExprPointeur(ctx.start.getLine(),ident, listexpr);
	 }

//2eme partie de expr (avec les expr1) c'est la meme chose car on prends pas les expr1 dans l'ast (i think so..)
	/* @Override public Ast visitEntierExpr(circParser.EntierExprContext ctx) {
		
		String integer = ctx.getChild(0).toString();
		//Ast expr = ctx.getChild(1).accept(this);
		return new IntNode(integer);
	 }

	@Override public Ast visitIdentExpr(circParser.IdentExprContext ctx) { 
		
		String idf = ctx.getChild(0).toString();
		Ident ident = new Ident(idf);
		return ident;
	 }

	 @Override public Ast visitParenthExprExpr(circParser.ParenthExprExprContext ctx) { 
		
		return ctx.getChild(1).accept(this);
	 }

	 @Override public Ast visitExclaExprExpr(circParser.ExclaExprExprContext ctx) { 
		
		Ast expr = ctx.getChild(1).accept(this);
		return new ExclaExpr(expr);
	 }

	 @Override public Ast visitTiretExprExpr(circParser.TiretExprExprContext ctx) { 
		
		Ast expr = ctx.getChild(1).accept(this);
		return new TiretExpr(expr);
	 }*/

	 /*@Override public Ast visitSizeofExpr(circParser.SizeofExprContext ctx) {
		
		String idf = ctx.getChild(3).toString();
		Ident ident = new Ident(idf);
		return new Sizeof(ident);
	 }
	 @Override public Ast visitIdentExprPointeurExpr(circParser.IdentExprPointeurExprContext ctx) { 
		
		String idf = ctx.getChild(0).toString();
		Ident ident = new Ident(idf);
		Ast listexpr = ctx.getChild(2).accept(this);
		return new IdentExprPointeur(ident, listexpr);
	 }*/

	//DONE
	@Override public Ast visitListe_expr(circParser.Liste_exprContext ctx) {
		ArrayList<Ast> liste = new ArrayList<Ast>();
		int nb = ctx.getChildCount();
		for(int j =0 ; j < nb ; j=j+2) {   //j=j+2 car les expr ont un indice paire
			Ast expr = ctx.getChild(j).accept(this);
			liste.add(expr);
		}
		return new ListeExpr(ctx.start.getLine(),liste);
	 }

	 ////règle expr1

	//DONE
	@Override public Ast visitFleche(circParser.FlecheContext ctx) {
		Ast expr = ctx.getChild(0).accept(this);
		String idf = ctx.getChild(2).toString();
		Ident ident = new Ident(ctx.start.getLine(),idf);
		return new Fleche(ctx.start.getLine(),expr,ident);
	 }

	//DONE
	@Override public Ast visitOpExpr(circParser.OpExprContext ctx) {
		
		String op = ctx.getChild(1).toString();
		Operateur operateur = new Operateur(ctx.start.getLine(),op);
		Ast expr1 = ctx.getChild(0).accept(this);
		Ast expr2 = ctx.getChild(2).accept(this);
		return new OpExpr(ctx.start.getLine(),expr1,operateur,expr2);
	 }

	/* @Override public Ast visitFlecheExpr(circParser.FlecheExprContext ctx) {
		
		String idf = ctx.getChild(1).toString();
		Ident ident = new Ident(idf);
		Ast expr1 = ctx.getChild(2).accept(this);
		return new FlecheExpr(ident,expr1);
	 }*/

	/* @Override public Ast visitOpExprExpr(circParser.OpExprExprContext ctx) {
		
		String op = ctx.getChild(0).toString();
		Operateur operateur = new Operateur(op);
		Ast expr = ctx.getChild(1).accept(this);
		 Ast expr1 = ctx.getChild(2).accept(this);
		 return new OpExprExpr(operateur,expr,expr1);
	 }*/


	//DONE
	@Override public Ast visitParamint(circParser.ParamintContext ctx) {
		String a = ctx.getChild(1).toString();
		Ident id = new Ident(ctx.start.getLine(),a);
		return new Paramint(ctx.start.getLine(),id);
	}


	//DONE
	@Override public Ast visitParamstruct(circParser.ParamstructContext ctx) {

		String op1 = ctx.getChild(1).toString();
		String op2 = ctx.getChild(3).toString();
		Ident ident1 = new Ident(ctx.start.getLine(),op1);
		Ident ident2 = new Ident(ctx.start.getLine(),op2);
		//Ast expr = ctx.getChild(1).accept(this);
		return new Paramstruct(ctx.start.getLine(),ident1,ident2);
	}

	@Override public Ast visitList(circParser.ListContext ctx) {
		ArrayList<Ast> list = new ArrayList<Ast>();
		int size = ctx.getChildCount();
		for (int i=0 ; i<size ; i=i+2){
			Ast expr = ctx.getChild(i).accept(this);
			list.add(expr);
		}
		return new List(ctx.start.getLine(),list);
	}

	@Override public Ast visitVide(circParser.VideContext ctx) {

		return new Vide(ctx.start.getLine());
	}


}