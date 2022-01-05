package tds;

import ast.*;

import java.util.ArrayList;

public class LigneStructParam extends Ligne{

    //public Parcours visitor;
    //public String nom="variable";
    public Ident ident1,ident2;


    public LigneStructParam(Paramstruct dcl){
        this.ident1 = dcl.ident1;
        this.ident2 = dcl.ident2;
    }


    public String toString() {
        //afficher les infos
        String res="";
        res += " Variable de type: "+ident1.name+" , nom = " +ident1.name ;
        return res;
    }

}

