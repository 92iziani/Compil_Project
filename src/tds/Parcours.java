package tds;

import ast.*;

public class Parcours implements AstVisitor {

    Tds parent;
    @Override
    public Object visit(Program program) {
        parent = new Tds("Tds principale");
        return parent;
    }

    @Override
    public Object visit(IfThen ifthen) {
        //comment trouver son father ?
        Tds tdsIf = new Tds("tds if then", parent);
        //je dois ajouter le contenu

        return tdsIf;
    }

    @Override
    public Object visit(IfThenElse ifthenelse) {
        //comment trouver son father ?

        Tds tdsifthenelse =  new Tds("tds if then else",parent);
        //je dois ajouter le contenu
        return tdsifthenelse;
    }

    @Override
    public Object visit(While whil) {
        //comment trouver son father ?

        Tds tdswhile = new Tds("tds While", parent);
        return null;
    }

    @Override
    public Object visit(Return retur) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Affectation affect) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Ident ident) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(ListeDeclVars liste) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(ListeInstruction liste) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Bloc bloc) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Plus plus) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Minus minus) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Divide divide) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Mult mult) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(DeclaList declaList) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(DeclTyp declTyp) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(DeclaAffect dAffect) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Entier entier) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(IntParam intParam) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Struct struct) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(StructParam structParam) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(ExclaExpr x) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Fleche x) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(IdentExprPointeur x) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Operateur x) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(OpExpr x) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(ParenthExpr x) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Sizeof x) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(TiretExpr x) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(ListeExpr listexpr) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Paramint x) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Paramstruct x) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(List x) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visit(Vide x) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
