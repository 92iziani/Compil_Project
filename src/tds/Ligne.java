package tds;


//représente une ligne de la tds par exemple une variable
// chaque type de ligne extends cette classe car chaque ligne n'a pas les mêmes informations

import ast.Ident;
import java.util.ArrayList;

import java.util.HashMap;

public abstract class Ligne {

    private static int numero = 0; //num de la ligne
    private String type; //type = int, fonction, struct, param..
    private HashMap<String, Ident> map;

    public Ligne() {
        this.numero++;
        this.map = new HashMap<String, Ident>();
    }


    //normalement, on peut mettre la chaîne qu'on veut ici vu qu'on a une toString dans chaque Ligneqqchose
    public String toString() {
        return "abcd";
    }





}
