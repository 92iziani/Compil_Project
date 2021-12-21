package ast;

import java.util.ArrayList;

public class Program implements Ast {


    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ast> declarations;

    public Program(ArrayList<Ast> decl){
        this.declarations = decl;
    }

}
