package tds;

import ast.*;

public class Parcours {

    Tds parent;

    //en paramètre la tds que je dois remplir
    // ici ça va être la tds parent
    public Object visit(Program program, Tds tds) {
        parent = new Tds("Tds principale");
        return parent;
    }

    public Object visit(IfThen ifthen, Tds tds) {
        //comment trouver son father ?
        Tds tdsIf = new Tds("tds if then", parent);
        //je dois ajouter le contenu

        return tdsIf;
    }

    public Object visit(IfThenElse ifthenelse, Tds tds) {
        //comment trouver son father ?

        Tds tdsifthenelse =  new Tds("tds if then else",parent);
        //je dois ajouter le contenu
        return tdsifthenelse;
    }

    public Object visit(While whil, Tds tds) {
        //comment trouver son father ?

        Tds tdswhile = new Tds("tds While", parent);
        return null;
    }

    public void visit(Return retur, Tds tds) {
        //il fait rien
    }

    public Object visit(Affectation affect, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(Ident ident, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(ListeDeclVars liste, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(ListeInstruction liste, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(Bloc bloc, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(Plus plus, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(Minus minus, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(Divide divide, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(Mult mult, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(DeclaList declaList, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(DeclTyp declTyp, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(DeclaAffect dAffect, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(Entier entier, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(IntParam intParam, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(Struct struct, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(StructParam structParam, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(ExclaExpr x, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(Fleche x, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(IdentExprPointeur x, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(Operateur x, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public void visit(OpExpr x, Tds tds) {
        //utile pour sémantique
    }

    public void visit(ParenthExpr x, Tds tds) {
        //utile pour sémantique
    }

    public void visit(Sizeof x, Tds tds) {
        //utile pour semantique
    }

    public void visit(TiretExpr x, Tds tds) {
        //utile pour semantique
    }

    public void visit(ListeExpr listexpr, Tds tds) {
        // utile pour semantique
    }

    public void visit(Paramint x, Tds tds) {
        // utile pour semantique
    }

    public void visit(Paramstruct x, Tds tds) {
        // utile pour semantique
    }

    public Object visit(List x, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object visit(Vide x, Tds tds) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
