package tds;

import java.util.ArrayList;

import ast.Ast;

public class Tds{

    //nom associé à la tds
    private String nom;
    //numero de region
    private static int num_region = 0;
    //niveau d'imbrication
    private int nv_imbrication;
    private ArrayList<Ligne> contenu;
    private Tds father;

    public Tds(String nom){
        this.nom = nom;
        num_region++; // car nouvelle table créee
        this.father = null; //n'a pas de père
        this.nv_imbrication = 0; //car n'a pas de père
        this.contenu = new ArrayList<Ligne>();
    }

    public Tds(String nom, Tds parent){
        this(nom);
        this.father = parent;
        this.nv_imbrication = parent.getNiveau()+1;

    }

    private int getNiveau() {
        return this.nv_imbrication;
    }

    public void addLigne(Ligne elem){
        this.contenu.add(elem);
    }

    
}
