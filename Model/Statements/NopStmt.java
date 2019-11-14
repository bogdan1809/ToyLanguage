package Model.Statements;

import Model.State.PrgState;

public class NopStmt implements IStmt {

    @Override
    public String toString(){
        return "Nop";
    }

    @Override
    public PrgState execute(PrgState state){
        return state;
    }
}
