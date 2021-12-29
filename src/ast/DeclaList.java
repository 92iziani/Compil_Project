package ast;

import java.util.ArrayList;

import tds.Parcours;
import tds.Tds;

public class DeclaList implements Ast {
    
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ident> declaList;

    public DeclaList(ArrayList<Ident> declaList) {
        this.declaList = declaList;

    }

    public void acceptTDS(Parcours p, Tds tds){
        p.visit(this, tds);
    }


}
