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

    private ArrayList<Ident> id2 = new ArrayList<Ident>(); //pour declaffect
    private ArrayList<Entier> entier = new ArrayList<Entier>(); //pour stocker les affect

   public LigneVariable(DeclaList dcl){
       this.id1.addAll(dcl.declaList);
        //father.addLigne(this); //ici?
   }
   public LigneVariable(DeclaAffect dcl){
       this.id2.add(dcl.ident);
       if(dcl.entier instanceof Entier){
           this.entier.add((Entier) dcl.entier);
       }
        //father.addLigne(this); //on l'ajoute au père ici ?
   }
   public String toString(){
    //afficher les infos
   }
}
