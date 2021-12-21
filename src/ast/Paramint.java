package ast;

import java.util.ArrayList;

public class Paramint implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ident> list;

    public Paramint(ArrayList<Ident> list){

        this.list = list;
    }
}
