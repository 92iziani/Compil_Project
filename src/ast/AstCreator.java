package ast;

import java.util.ArrayList;

import parser.exprBaseVisitor;
import parser.exprParser;
import parser.exprParser.Instr_listContext;

public class AstCreator extends exprBaseVisitor<Ast>{

    	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitProgram(exprParser.ProgramContext ctx) { 
		Ast instr_list = ctx.getChild(0).accept(this);
		return new Program(instr_list);
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitInstr(exprParser.InstrContext ctx) { 
		return ctx.getChild(0).accept(this); //retourne l'AST produit par le noeud fils
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitPrint_litteral(exprParser.Print_litteralContext ctx) { 
		Ast value = ctx.getChild(1).accept(this);

		return new Print(value);
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitIfThenElse(exprParser.IfThenElseContext ctx) { 
		Ast condition = ctx.getChild(2).accept(this); //condition
		Ast thenB = ctx.getChild(5).accept(this); 
		Ast elseB = ctx.getChild(9).accept(this);

		return new IfThenElse(condition, thenB, elseB);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitIfThen(exprParser.IfThenContext ctx) { 
		Ast condition = ctx.getChild(2).accept(this); //condition
		Ast thenB = ctx.getChild(5).accept(this); 
		return new IfThen(condition, thenB);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitInstr_list(exprParser.Instr_listContext ctx) { 
		ArrayList<Ast> liste = new ArrayList<Ast>();
		int i=0;
		while(ctx.getChild(i) != null){
			Ast expr = ctx.getChild(i).accept(this);
			liste.add(expr);
			i++;
		}
		return new InstrList(liste);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitAffect(exprParser.AffectContext ctx) { 
		
		//Récupération des noeuds fils
		String idfString = ctx.getChild(0).toString(); // récupère la valeur du terminal Idf
		Ast expr = ctx.getChild(2).accept(this); //on génère l'AST
		
		//creation des sous AST
		Idf idf = new Idf(idfString);
		
		return new Affect(idf, expr);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitExpr(exprParser.ExprContext ctx) {
		return ctx.getChild(0).accept(this);
		}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitPlus(exprParser.PlusContext ctx) { 
		Ast noeudTemporaire = ctx.getChild(0).accept(this);

        for (int i=0;2*i<ctx.getChildCount()-1;i++){
            
            String operation = ctx.getChild(2*i+1).toString();
            Ast right = ctx.getChild(2*(i+1)).accept(this);

            switch (operation) {
                case "-":
                    noeudTemporaire = new Minus(noeudTemporaire,right);
                    break;
                case "+":
                    noeudTemporaire = new Plus(noeudTemporaire,right);
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
	@Override public Ast visitMult(exprParser.MultContext ctx) { 
		Ast noeudTemporaire = ctx.getChild(0).accept(this);

        for (int i=0;2*i<ctx.getChildCount()-1;i++){
            
            String operation = ctx.getChild(2*i+1).toString();
            Ast right = ctx.getChild(2*(i+1)).accept(this);

            switch (operation) {
                case "*":
                    noeudTemporaire = new Mult(noeudTemporaire,right);
                    break;
                case "/":
                    noeudTemporaire = new Divide(noeudTemporaire,right);
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
	@Override public Ast visitInteger(exprParser.IntegerContext ctx) { 
		int integer = Integer.parseInt(ctx.getChild(0).toString());
		return new IntNode(integer);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitIdentifier(exprParser.IdentifierContext ctx) { 
		String idf = ctx.getChild(0).toString();
		return new Idf(idf);
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitParenthesis(exprParser.ParenthesisContext ctx) { 
		return ctx.getChild(1).accept(this);
	}
}
