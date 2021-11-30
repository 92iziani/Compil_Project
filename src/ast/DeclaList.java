package ast;

import java.util.ArrayList;

public class DeclaList implements Ast {
    
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ident> declaList;

    public DeclaList(ArrayList<Ident> declaList) {
        this.declaList = declaList;

    }




}
