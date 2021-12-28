package tds;

import ast.*;

public class TdsVisitor implements AstVisitor<Void> {
    private TdsAbs table;

    public TdsVisitor(){
        table = new TdsAbs();
    }




    @Override
    public Void visit(Program program) {
        return null;
    }

    @Override
    public Void visit(IfThen ifthen) {
        return null;
    }

    @Override
    public Void visit(IfThenElse ifthenelse) {
        return null;
    }

    @Override
    public Void visit(While whil) {
        return null;
    }

    @Override
    public Void visit(Return retur) {
        return null;
    }

    @Override
    public Void visit(Affectation affect) {
        return null;
    }

    @Override
    public Void visit(Ident ident) {
        return null;
    }

    @Override
    public Void visit(ListeDeclVars liste) {
        return null;
    }

    @Override
    public Void visit(ListeInstruction liste) {
        return null;
    }

    @Override
    public Void visit(Bloc bloc) {
        return null;
    }

    @Override
    public Void visit(Plus plus) {
        return null;
    }

    @Override
    public Void visit(Minus minus) {
        return null;
    }

    @Override
    public Void visit(Divide divide) {
        return null;
    }

    @Override
    public Void visit(Mult mult) {
        return null;
    }

    @Override
    public Void visit(DeclaList declaList) {
        return null;
    }

    @Override
    public Void visit(DeclTyp declTyp) {
        return null;
    }

    @Override
    public Void visit(DeclaAffect dAffect) {
        return null;
    }

    @Override
    public Void visit(Entier entier) {
        return null;
    }

    @Override
    public Void visit(IntParam intParam) {
        return null;
    }

    @Override
    public Void visit(Struct struct) {
        return null;
    }

    @Override
    public Void visit(StructParam structParam) {
        return null;
    }

    @Override
    public Void visit(ExclaExpr x) {
        return null;
    }

    @Override
    public Void visit(Fleche x) {
        return null;
    }

    @Override
    public Void visit(IdentExprPointeur x) {
        return null;
    }

    @Override
    public Void visit(Operateur x) {
        return null;
    }

    @Override
    public Void visit(OpExpr x) {
        return null;
    }

    @Override
    public Void visit(ParenthExpr x) {
        return null;
    }

    @Override
    public Void visit(Sizeof x) {
        return null;
    }

    @Override
    public Void visit(TiretExpr x) {
        return null;
    }

    @Override
    public Void visit(ListeExpr listexpr) {
        return null;
    }

    @Override
    public Void visit(Paramint x) {
        return null;
    }

    @Override
    public Void visit(Paramstruct x) {
        return null;
    }

    @Override
    public Void visit(List x) {
        return null;
    }

    @Override
    public Void visit(Vide x) {
        return null;
    }
}
