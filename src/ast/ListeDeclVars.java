package ast;

import java.util.ArrayList;

public class ListeDeclVars implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ast> instrList;
    public int ligne;

    public ListeDeclVars(int ligne, ArrayList<Ast> instrList){
        this.instrList = instrList;
        this.ligne = ligne;
    }

}
