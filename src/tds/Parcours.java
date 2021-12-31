package tds;

import ast.*;

public class Parcours {

    //constructeur de parcours
    public Parcours(){

    }

    //en paramètre la tds que je dois remplir
    // ici ça va être la tds parent
    public void visit(Program program, Tds tds) {
        // créer la tds si besoin
        Tds principale = new Tds("Tds principale");
    }

    public void visit(IfThen ifthen, Tds tds) {
        //je suis dans tds donc c'est le pere  de tdsThen
        Tds tdsifthen = new Tds("tds if then", tds);
        //je dois ajouter le contenu

        ifthen.condition.acceptTDS(this,tdsifthen);
        ifthen.thenBlock.acceptTDS(this,tdsifthen);


    }

    public void visit(IfThenElse ifthenelse, Tds tds) {
        // creation de deux TDS, une pour then et une pour else
        Tds tdsifthenelse =  new Tds("tds if then else",tds);
        //je dois ajouter le contenu
        ifthenelse.condition.acceptTDS(this,tdsifthenelse);
        ifthenelse.elseBlock.acceptTDS(this,tdsifthenelse);
        ifthenelse.thenBlock.acceptTDS(this,tdsifthenelse);

    }

    public void visit(While whil, Tds tds) {
        //comment trouver son father ?
        Tds tdswhile = new Tds("tds While", tds);
        LigneBloc ligne = new LigneBloc(this);
        //je fais des acceptTDS sur ce que j'ai dans mon instance de While
        whil.condition.acceptTDS(this,tdswhile);
        whil.instruction.acceptTDS(this,tdswhile);
    }

    public void visit(Return retur, Tds tds) {
        //il fait rien
    }

    public void visit(Affectation affect, Tds tds) {
        
    }

    public void visit(Ident ident, Tds tds) {
        // TODO Auto-generated method stub
    }

    public void visit(ListeDeclVars liste, Tds tds) {
        // TODO Auto-generated method stub
    }

    public void visit(ListeInstruction liste, Tds tds) {
        // TODO Auto-generated method stub
    }

    public void visit(Bloc bloc, Tds tds) {
        Tds tdsbloc = new Tds("tds Bloc", tds);
        bloc.declarations.acceptTDS(this,tdsbloc);
        bloc.instructions.acceptTDS(this,tdsbloc);

        //return null;
    }

    public void visit(Plus plus, Tds tds) {
        // TODO Auto-generated method stub
    }

    public void visit(Minus minus, Tds tds) {
        // TODO Auto-generated method stub
    }

    public void visit(Divide divide, Tds tds) {
        // TODO Auto-generated method stub
    }

    public void visit(Mult mult, Tds tds) {
        // TODO Auto-generated method stub
    }

    public void visit(DeclaList declaList, Tds tds) {
        // TODO Auto-generated method stub
    }

    public void visit(DeclTyp declTyp, Tds tds) {
        // creation ligne
    }

    public void visit(DeclaAffect dAffect, Tds tds) {
        // creation ligne
    }

    public void visit(Entier entier, Tds tds) {
        // TODO Auto-generated method stub
    }

    public void visit(IntParam intParam, Tds tds) {
        // creation de tds ?
        // creation de ligne fonction
    }

    public void visit(Struct struct, Tds tds) {
        // creation ligne
    }

    public void visit(StructParam structParam, Tds tds) {
        // creation d'une tds ?
        // creation ligne fonction avec type de retour struct
    }

    public void visit(ExclaExpr x, Tds tds) {
        // TODO Auto-generated method stub
    }

    public void visit(Fleche x, Tds tds) {
        // TODO Auto-generated method stub
    }

    public void visit(IdentExprPointeur x, Tds tds) {
        // TODO Auto-generated method stub
    }

    public void visit(Operateur x, Tds tds) {
        // TODO Auto-generated method stub
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

    public void visit(List x, Tds tds) {
        // TODO Auto-generated method stub
    }

    public void visit(Vide x, Tds tds) {
        // TODO Auto-generated method stub
    }
    
}
