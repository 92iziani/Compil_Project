package tds;

import ast.*;

public class LigneFonction extends Ligne{

    private Ident ident=null,ident1=null,ident2=null;
    private String type;

    public LigneFonction(IntParam intparam){
        this.ident = intparam.ident;
        this.type = "INT";
    }

    public LigneFonction(StructParam fct){
        this.ident1 = fct.ident1;
        this.ident2 = fct.ident2;
        this.type = "STRUCT";
    }
    
    public String toString() {
        if (ident !=null){
            return "function " +" nom: "+ ident.name + " type retour: " + type;
        }
        else {
            if (ident1 != null && ident2 != null){
                return "function " + "nom:" +ident2.name + " retour : "+ident1.name  +" type retour: " + type;
            }
        }
        return null;
    }

}
