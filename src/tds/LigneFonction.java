package tds;

import ast.*;

public class LigneFonction extends Ligne{

    public Ident ident=null,ident1=null,ident2=null; //ident: nom de fonction avec int en retour
    public String type;

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
            return "function " +" nom: "+ ident.name + ", type retour: " + type;
        }
        else {
            if (ident1 != null && ident2 != null){
                return "function " + "nom:" +ident2.name +", type retour: " + type+" "+ident1.name;
            }
        }
        return null;
    }

}
