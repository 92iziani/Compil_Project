package tds;

import ast.DeclTyp;
import ast.Ident;

public class LigneStruct extends Ligne{
    public String name;
    private Ident type;
    

    public LigneStruct(DeclTyp declTyp) {
        this.name = declTyp.ident.name;

    }

    public String getName(){
        return this.name;
    }

    public String getType(){
        return this.type.name;
    }

    public String toString() {

        return "Struct "+name;
    }
}
