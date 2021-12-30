package ast;


import tds.Parcours;
import tds.Tds;

public class Return implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }



    public Ast retour;

    public Return(Ast cond){
        this.retour = cond;
    }

    public void acceptTDS(Parcours p, Tds tds){
        p.visit(this, tds);
    }
}
