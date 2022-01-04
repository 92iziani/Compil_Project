package tds;

import ast.DeclaAffect;
import ast.DeclaList;
import ast.Entier;
import ast.Ident;

import java.util.ArrayList;

public class LigneVariable extends Ligne{

    public Parcours visitor;
    public String nom="variable";

    public ArrayList<Ident> id1 = new ArrayList<Ident>(); //pour declalist
    public Ident id2 = null ; //pour declaffect
    public Entier entier ; //pour stocker les affect

   public LigneVariable(DeclaList dcl){
       this.id1.addAll(dcl.declaList);
        //father.addLigne(this); //ici?
   }
   public LigneVariable(DeclaAffect dcl){
       this.id2=dcl.ident;
       //this.id2.addAll(dcl.ident);
       if(dcl.entier instanceof Entier){
           this.entier=(Entier) dcl.entier;
       }
        //father.addLigne(this); //on l'ajoute au père ici ?
   }
   public String toString() {
       //afficher les infos
       String res = "";
       if (id1 != null) {
           for (int i = 0; i < id1.size(); i++) {
               res += " Variable de type int, nom = " + id1.get(i).name ;

           }
       }
       if (id2 != null) {
           res += " Variable de type int, nom = " +id2.name + ", valeur = "+ entier.value ;
       }
        return res;
   }

}

