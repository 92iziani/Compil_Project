package tds;

import ast.*;

import java.util.ArrayList;

public class LigneVariable extends Ligne{

    public Parcours visitor;
    public String nom="variable";

    public ArrayList<Ident> id1 = new ArrayList<Ident>(); //pour declalist
    public Ident id2 = null ; //pour declaffect
    public Entier entier ; //pour stocker les affect
    public Ident idparam=null;
    public Ident struct = null; //pour struct
    public Ident typeStruct = null; //utile pour l'affichage

   public LigneVariable(DeclaList dcl){
       this.id1.addAll(dcl.declaList);
   }

    public LigneVariable(Paramint par){
        this.idparam = par.ident;
    }
   public LigneVariable(DeclaAffect dcl){
       this.id2=dcl.ident;
       if(dcl.entier instanceof Entier){
           this.entier=(Entier) dcl.entier;
       }
   }
   public LigneVariable(Ident ident, Ident type){
        this.typeStruct = type;
        this.struct = ident;
   }
   public String toString() {
       //afficher les infos
       String res = "";
       if (id1 != null) {
           for (int i = 0; i < id1.size(); i++) {
               res += " Variable de type: int, nom = " + id1.get(i).name ;

           }
       }
       if (id2 != null) {
           res += " Variable de type: int, nom = " +id2.name + ", valeur = "+ entier.value ;
       }

       if (idparam != null) {
           res += " Paramètre de type: int, nom = " +idparam.name  ;
       }

       if (struct != null) {
           res += " Variable de type struct: "+typeStruct.name+" , nom = "+struct.name;
       }

        return res;
   }

}

