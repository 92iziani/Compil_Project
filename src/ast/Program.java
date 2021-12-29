package ast;

import java.util.ArrayList;

import tds.Parcours;
import tds.Tds;

public class Program implements Ast {


    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ast> declarations;

    public Program(ArrayList<Ast> decl){
        this.declarations = decl;
    }

    public void acceptTDS(Parcours p, Tds tds){
        p.visit(this, tds);
    }
}
