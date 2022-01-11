package ast;


import java.util.ArrayList;

public class List implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ast> astlist;
    public int ligne;

    public List(int ligne, ArrayList<Ast> astlist){

        this.astlist = astlist;
        this.ligne = ligne;
    }

}