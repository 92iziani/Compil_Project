package tds;

import java.util.ArrayList;

import ast.Ast;

public class Tds{

    private String nom;
    private static int num_region = 0;
    private int nv_imbrication;
    private ArrayList<Tds> sons;
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

    public void addChild(Tds tds) { this.sons.add(tds); }

    public Tds getFather() { return this.father;}

    public int getNum_region() { return this.num_region; }


    public void setFatherTDS(Tds father) { this.father = father;
    }
}
