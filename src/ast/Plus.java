package ast;

import tds.Parcours;
import tds.Tds;

public class Plus implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;

    public Plus(Ast left, Ast right){
        this.left = left;
        this.right = right;
    }

    public void acceptTDS(Parcours p, Tds tds){
        p.visit(this, tds);
    }

}
