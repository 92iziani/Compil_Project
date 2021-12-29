package ast;

import tds.Parcours;
import tds.Tds;

import java.util.ArrayList;

public class ListeInstruction implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ast> instrList;

    public ListeInstruction(ArrayList<Ast> instrList){
        this.instrList = instrList;
    }

    public void acceptTDS(Parcours p, Tds tds){
        p.visit(this, tds);
    }
}