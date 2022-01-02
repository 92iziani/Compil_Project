package tds;

import java.util.ArrayList;

import ast.Ast;

public class Tds{

    private int nv_imbrication;
    private ArrayList<Ligne> contenu;
    private Tds father=null;

    public Tds() {
        this.contenu = new ArrayList<>();
    }

    public int addEntry(Ligne entry) {
        contenu.add(entry);
        return contenu.size();
    }

   /* public Tds(String nom){
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
*/
    private int getNiveau() {
        return this.nv_imbrication;
    }

    public void addLigne(Ligne elem){
        this.contenu.add(elem);
    }

/*
    public void addChild(Tds tds) { this.sons.add(tds); }
*/

    public Tds getFather() { return this.father;}

/*
    public int getNum_region() { return this.num_region; }
*/

    public Tds getFatherTDS() {
        return this.father;
    }

    public void setFatherTDS(Tds father) { this.father = father;}


    public String toString() {
        return toString2(0);
    }

    public String toString2(int ind) {
        String strind = "";
        for (int i = 0 ; i < ind ; i++) {
            strind += " |";
        }
        String ret = strind + "TDS :";
        if (this.father == null) ret += "root\n";
        else ret += "son of another one\n";
        for (Ligne entry : contenu) {
            ret += strind + "Entry: ";
            ret += entry.toString() + "\n";
        }

        for (Ligne entry: contenu) {
            if (entry instanceof LigneWhile) {
                ret += strind + "containing following TDS (While):\n";
                LigneWhile fentry = (LigneWhile)entry;
                if (fentry.bloc != null && fentry.bloc.getTable().toString() != null) {
                    ret += strind + fentry.bloc.getTable().toString2(ind + 1);
                }
            }
        }



        for (Ligne entry: contenu) {
            if (entry instanceof LigneFonction) {
                ret += strind + "containing following TDS (Func):\n";
                LigneFonction fentry = (LigneFonction)entry;
                if (fentry.bloc != null && fentry.bloc.getTable().toString() != null) {
                    ret += strind + fentry.bloc.getTable().toString2(ind + 1);
                }
            }
        }
        return ret;
    }

}
