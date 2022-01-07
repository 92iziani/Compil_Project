package tds;

import java.util.ArrayList;
import java.util.HashMap;
import ast.Ast;
import ast.Ident;

public class Tds{

    private int nv_imbrication;
   // private HashMap<String,Ligne> map;
    private  int numero;
    private ArrayList<Ligne> contenu;
    private Tds father=null;
    private String name;

    public Tds(int i, String name) {
        this.numero=i;
        this.nv_imbrication=0; //car le pere
        this.contenu = new ArrayList<Ligne>();
        this.name = name;
    }
    public Tds(Tds father, int i, String name){
        this.father=father;
        this.nv_imbrication=father.getNiveau()+1;
        this.numero=i;
        this.contenu = new ArrayList<Ligne>();
        this.name=name;
    }

    public int addEntry(Ligne entry) {
        contenu.add(entry);
        return contenu.size();
    }

    private int getNiveau() {
        return this.nv_imbrication;
    }

    public void addLigne(Ligne elem){
        this.contenu.add(elem);
    }

    public Tds getFather() { return this.father;}


    public void setFatherTDS(Tds father) { this.father = father;}

        public boolean ifExists(String nom){

        if (contenu==null){
            return false;
        }
        for (Ligne lg : contenu){
            if (lg instanceof LigneVariable){
                LigneVariable var = (LigneVariable) lg;
               if( var.id2 != null && var.id2.name.equals(nom) ){
                   return true;
               }
               if (var.id1 != null){
                   for(Ident id:var.id1){
                       if (id.name.equals(nom)){
                           return true;
                       }
                   }
               }
               //verif des paramètres
               if (var.idparam != null && var.idparam.name.equals(nom)){
                    return true;
               }
               
               //je dois vérifier si le struct n'existe pas deja (plus loin pour le type)
                if( var.struct != null && var.struct.name.equals(nom)){
                    return true;
                }
            }


            if (lg instanceof LigneFonction){
                LigneFonction var = (LigneFonction) lg;
                if (var.ident != null && var.ident.name.equals(nom)){
                    return true;
                }
                if (var.ident2 != null && var.ident2.name.equals(nom)){
                    return true;
                }

            }
        }
        return false;

    }


    public boolean ifExists2(String nom){
        while (father != null){
            if (ifExists(nom)){
                return true;
            }
            else {
                return father.ifExists2(nom);
            }
        }
        if (ifExists(nom)){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean ifExistsStruct(String nom){
        for (Ligne lg : contenu){
            if (lg instanceof LigneStruct){
                LigneStruct st = (LigneStruct) lg;
                if(st.name.equals(nom)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean ifExists3(String nom){
        while (father != null){
            if (ifExistsStruct(nom)){
                return true;
            }
            else {
                return father.ifExists3(nom);
            }
        }
        if (ifExistsStruct(nom)){
            return true;
        }
        else {
            return false;
        }
    }

    public String find_type(String nom){

        
        for (Ligne lg : contenu){
            if (lg instanceof LigneVariable){
                LigneVariable var = (LigneVariable) lg;

                //verif des variables
                if(var.id2 != null && var.id2.name.equals(nom) ){
                   return "int";
                }
                if (var.id1 != null){
                   for(Ident id:var.id1){
                       if (id.name.equals(nom)){
                           return "int";
                       }
                   }
                }
                //verif des paramètres
                if (var.idparam != null && var.idparam.name.equals(nom)){
                    return "int";
                }

                //verif des struct
                if (var.struct != null && var.struct.name.equals(nom)){

                }
            } 
        }
        return "error";

    }


    public String find_type2(String nom){
        while (father != null){
            if (ifExists(nom)){
                return find_type(nom);
            }
            else {
                return father.find_type(nom);
            }
        }
        if (ifExists(nom)){
            return find_type(nom);
        }
        else {
            return find_type(nom);
        }
    }
    //FONCTION QUI DONNE LA LISTE DES TYPES DES PARAM D'UNE FCT DANS L'ORDRE (DECLARATION DE FONCTION) : CHERCHE UNIQUEMENT DANS LA TABLE COURANTE
    public ArrayList<String> listParam(){
        ArrayList<String> listtypeparam = new ArrayList<String>();
        for(Ligne lg:contenu){
            if (lg instanceof LigneStructParam){
                LigneStructParam par = (LigneStructParam)lg;
                if (par.ident1 != null){
                    listtypeparam.add(par.ident1.name);
                }
            }
            if (lg instanceof LigneVariable){
                LigneVariable par = (LigneVariable)lg;
                if(par.idparam != null){
                    listtypeparam.add("int");
                }
            }
        }
        return listtypeparam;
    }





    public String toString() {
        String result = "TDS "+name+" | Numéro: "+ numero+" | Nv imbrication: "+ this.nv_imbrication+"\n";
        result += "__________________________________________________\n";
        for (Ligne lg : contenu) {
            result += "Entry: "+lg.toString() + "\n";
        }
        return result;
    }


/*
    public String toString() {
        return toString2(0);
    }
*/

    /*public String toString2(int ind) {
        String strind = "";
        for (int i = 0 ; i < ind ; i++) {
            strind += " |";
        }
        String ret = strind + "TDS :";
        if (this.father == null) ret += "root\n";
        else ret += "son of another\n";
        for (Ligne entry : contenu) {
            ret += strind + "Entry: ";
            ret += entry.toString() + "\n";
        }

        for (Ligne entry: contenu) {
            if (entry instanceof LigneWhile) {
                ret += strind + "Nouvelle TDS (While):\n";
                LigneWhile fentry = (LigneWhile)entry;
                if (fentry.bloc != null && fentry.bloc.getTable().toString() != null) {
                    ret += strind + fentry.bloc.getTable().toString2(ind + 1);
                }
            }
        }


        for (Ligne entry: contenu) {
            if (entry instanceof LigneFonction) {
                ret += strind + "Nouvelle table de Fonction : \n";
                LigneFonction fentry = (LigneFonction)entry;
                if (fentry.bloc != null && fentry.bloc.getTable().toString() != null) {
                    ret += strind + fentry.bloc.getTable().toString2(ind + 1);
                }
            }
        }
        return ret;*/
    //}

}
