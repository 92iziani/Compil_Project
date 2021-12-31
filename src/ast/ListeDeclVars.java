package ast;

import java.util.ArrayList;

public class ListeDeclVars implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ast> instrList;

    public ListeDeclVars(ArrayList<Ast> instrList){
        this.instrList = instrList;
    }

}
