package ast;

import java.util.ArrayList;

public class ListeInstruction implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ast> instrList;
    public int ligne;

    public ListeInstruction(int ligne, ArrayList<Ast> instrList){
        this.instrList = instrList;
        this.ligne = ligne;
    }

}