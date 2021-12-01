package ast;

import java.util.ArrayList;

public class ListExpr implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ast> list;

    public ListeExpr(ArrayList<Ast> list){

        this.list = list;
    }
}
