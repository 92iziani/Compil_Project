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
		return new IfThen(condition, thenB);
	}

	//DONE
	@Override
	public Ast visitIfThenElse(circParser.IfThenElseContext ctx) {
		Ast condition = ctx.getChild(2).accept(this); //condition
		Ast thenB = ctx.getChild(4).accept(this);
		Ast elseB = ctx.getChild(6).accept(this);

		return new IfThenElse(condition, thenB, elseB);
	}

	//DONE
	@Override
	public Ast visitWhile(circParser.WhileContext ctx) {
		Ast condition = ctx.getChild(2).accept(this);
		Ast instruction = ctx.getChild(4).accept(this);
		return new While(condition, instruction);
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

	//DONE
	@Override
	public Ast visitReturn(circParser.ReturnContext ctx) {
		Ast retour = ctx.getChild(1).accept(this);
		return new Return(retour);
	}

	//DONE
	@Override
	public Ast visitAffectation(circParser.AffectationContext ctx) {
		String identString = ctx.getChild(0).toString(); // récupère la valeur du terminal Ident
		Ast expr = ctx.getChild(2).accept(this); //on génère l'AST

		//creation des sous AST
		Ident ident = new Ident(identString);

		return new Affectation(ident, expr);
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
		return new ListeDeclVars(liste);
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
		return new ListeInstruction(liste);
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

	//DONE
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
				Ident ident = new Ident(identString);
				Listedident.add(ident);
			}
		}

		return new DeclaList(Listedident); }

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
				Ident id = new Ident(a);
				list.add(id);
				i = i+2;
			}
			String a = ctx.getChild(i).toString();
			Ident id = new Ident(a);
			list.add(id);
			i = i + 3 ;
		}
		return new Struct(list);

	}

	//DONE
	@Override
	public Ast visitDeclaAffect(circParser.DeclaAffectContext ctx) {
		String identString = ctx.getChild(1).toString();
		String entierString = ctx.getChild(3).toString();
		Ident ident = new Ident(identString);
		Entier entier = new Entier(entierString);
		return new DeclaAffect(ident,entier);
	}

	//DONE
	@Override
	public Ast visitDecl_typ(circParser.Decl_typContext ctx) {
		String identString = ctx.getChild(1).toString();
		Ident ident = new Ident(identString);
		Ast liste_decl_vars =ctx.getChild(3).accept(this);

	return new DeclTyp(ident,liste_decl_vars);
	}

	//DONE
	@Override
	public Ast visitIntParam(circParser.IntParamContext ctx) {
		String identString = ctx.getChild(1).toString();
		Ident ident = new Ident(identString);

		Ast liste_param = ctx.getChild(3).accept(this);
		Ast bloc = ctx.getChild(5).accept(this);

	return new IntParam(ident,liste_param,bloc);
	}

	//DONE
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

	//DONE
	/*@Override
	public Ast visitListe_param(circParser.Liste_paramContext ctx) {
		Ast ast =  ctx.getChild(0).accept(this);
		return new ListeParam(ast);
	}*/

	//DONE
	@Override public Ast visitEntier(circParser.EntierContext ctx) { 
		
		String integer = ctx.getChild(0).toString();
		return new Entier(integer);
	 }

	//DONE
	@Override public Ast visitIdent(circParser.IdentContext ctx) { 
		
		String ident = ctx.getChild(0).toString();
		return new Ident(ident);
	 }

	//DONE
	 @Override public Ast visitParenthExpr(circParser.ParenthExprContext ctx) { 
		Ast expr = ctx.getChild(1).accept(this);
		return new ParenthExpr(expr);
	 }

	//DONE
	 @Override public Ast visitExclaExpr(circParser.ExclaExprContext ctx) { 
		
		Ast expr = ctx.getChild(1).accept(this);
		return new ExclaExpr(expr);
	 }

	//DONE
	@Override public Ast visitTiretExpr(circParser.TiretExprContext ctx) {
		
		Ast expr = ctx.getChild(1).accept(this);
		return new TiretExpr(expr);
	 }

	//DONE
	@Override public Ast visitSizeof(circParser.SizeofContext ctx) {
		
		String idf = ctx.getChild(3).toString();
		Ident ident = new Ident(idf);
		return new Sizeof(ident);
	 }
	 //not sure
	 @Override public Ast visitIdentExprPointeur(circParser.IdentExprPointeurContext ctx) { 
		
		String idf = ctx.getChild(0).toString();
		Ident ident = new Ident(idf);
		Ast listexpr = ctx.getChild(2).accept(this);
		return new IdentExprPointeur(ident, listexpr);
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
		return new ListeExpr(liste);
	 }

	 ////règle expr1

	//DONE
	@Override public Ast visitFleche(circParser.FlecheContext ctx) {
		Ast expr = ctx.getChild(0).accept(this);
		String idf = ctx.getChild(2).toString();
		Ident ident = new Ident(idf);
		return new Fleche(expr,ident);
	 }

	//DONE
	@Override public Ast visitOpExpr(circParser.OpExprContext ctx) {
		
		String op = ctx.getChild(1).toString();
		Operateur operateur = new Operateur(op);
		Ast expr1 = ctx.getChild(0).accept(this);
		Ast expr2 = ctx.getChild(2).accept(this);
		return new OpExpr(expr1,operateur,expr2);
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
		Ident id = new Ident(a);
		return new Paramint(id);
	}


	//DONE
	@Override public Ast visitParamstruct(circParser.ParamstructContext ctx) {

		String op1 = ctx.getChild(1).toString();
		String op2 = ctx.getChild(3).toString();
		Ident ident1 = new Ident(op1);
		Ident ident2 = new Ident(op2);
		//Ast expr = ctx.getChild(1).accept(this);
		return new Paramstruct(ident1,ident2);
	}

	@Override public Ast visitList(circParser.ListContext ctx) {
		ArrayList<Ast> list = new ArrayList<Ast>();
		int size = ctx.getChildCount();
		for (int i=0 ; i<size ; i=i+2){
			Ast expr = ctx.getChild(i).accept(this);
			list.add(expr);
		}
		return new List(list);
	}

	@Override public Ast visitVide(circParser.VideContext ctx) {

		return new Vide();
	}


}