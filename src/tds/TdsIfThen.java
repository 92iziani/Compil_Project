package tds;
import ast.IfThen;

public class TdsIfThen extends TdsAbs {
    private TdsVisitor visitor;

    /*public TdsIfThen(IfThen ifthen){
        this.visitor = new TdsVisitor();
        for (ast.Ast child : ifthen.child)
    }*/
    public TdsIfThen(){
        super();
    }
    public TdsIfThen(TdsAbs parent){
        super(parent);
    }



    @Override
    protected String nomBloc() {
        return "ifthen";
    }
}
