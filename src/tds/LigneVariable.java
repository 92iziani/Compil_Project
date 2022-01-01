package tds;

import ast.DeclaAffect;
import ast.DeclaList;
import ast.Entier;
import ast.Ident;

import java.util.ArrayList;

public class LigneVariable extends Ligne{

    private Parcours visitor;
    private String nomvar; //nom de la variable
    private String nom="variable";

    private ArrayList<Ident> id1 = new ArrayList<Ident>(); //pour declalist
    private Ident id2 = null ; //pour declaffect
    private Entier entier ; //pour stocker les affect

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
               res += " Variable de type int, nom = " + id1.get(i).name + "\n";

           }
       }
       if (id2 != null) {
           res += " Variable de type int, nom = " +id2.name + ", valeur = "+ entier.value + "\n";
       }
        return res;
   }

}

