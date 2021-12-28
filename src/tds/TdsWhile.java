package tds;

public class TdsWhile extends TdsAbs{

    public TdsWhile(TdsAbs parent){
        super(parent);
    }
    public TdsWhile(){
        super();
    }

    @Override
    protected String nomBloc() {
        return "while";
    }

}
