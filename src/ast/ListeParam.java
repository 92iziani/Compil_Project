package ast;

import java.util.ArrayList;

public class ListeParam implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ast> paramList;

    public ListeParam(ArrayList<Ast> paramList){

        this.paramList = paramList;
    }
}