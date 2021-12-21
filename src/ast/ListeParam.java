package ast;

import java.util.ArrayList;

public class ListeParam implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast paramList;

    public ListeParam(Ast paramList){

        this.paramList = paramList;
    }
}