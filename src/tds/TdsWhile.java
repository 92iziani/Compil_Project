package tds;

public class TdsWhile extends Tds{

    public TdsWhile(Tds parent){
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
