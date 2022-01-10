package ast;


import java.util.ArrayList;

public class List implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ast> astlist;

    public List(ArrayList<Ast> astlist){

        this.astlist = astlist;
    }

}