package ast;

import tds.Parcours;
import tds.Tds;

import java.util.ArrayList;

public class ListeExpr implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ast> list;

    public ListeExpr(ArrayList<Ast> list){

        this.list = list;
    }

    public void acceptTDS(Parcours p, Tds tds){
        p.visit(this, tds);
    }
}
