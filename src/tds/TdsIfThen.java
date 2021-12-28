package tds;
import ast.IfThen;

public class TdsIfThen extends Tds {
    private TdsVisitor visitor;

    /*public TdsIfThen(IfThen ifthen){
        this.visitor = new TdsVisitor();
        for (ast.Ast child : ifthen.child)
    }*/
    public TdsIfThen(){
        super();
    }
    public TdsIfThen(Tds parent){
        super(parent);
    }



    @Override
    protected String nomBloc() {
        return "ifthen";
    }
}
