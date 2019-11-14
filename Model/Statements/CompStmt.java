package Model.Statements;

import Model.Data.MyIStack;
import Model.Exception.MyException;
import Model.State.PrgState;

public class CompStmt implements IStmt {
    private IStmt first;
    private IStmt second;

    public CompStmt(IStmt first, IStmt second){
        this.first=first;
        this.second=second;
    }

    @Override
    public String toString(){
        return "("+first.toString()+";"+second.toString()+")";
    }

    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk=state.getExeStack();

        stk.push(second);
        stk.push(first);
        //System.out.println(stk);
        return state;
    }
}
