package ast;

import tds.Parcours;
import tds.Tds;

import java.util.ArrayList;

public class Vide implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }


    public Vide(){

    }

    public void acceptTDS(Parcours p, Tds tds){
        p.visit(this, tds);
    }

}