package ast;

import java.util.ArrayList;

public class ListeExpr implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ast> list;
    public int ligne;

    public ListeExpr(int ligne, ArrayList<Ast> list){

        this.list = list;
        this.ligne=ligne;
    }

}
