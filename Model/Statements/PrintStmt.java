package Model.Statements;

import Model.Data.MyIDictionary;
import Model.Data.MyIList;

import Model.Exception.MyException;
import Model.Expressions.Exp;
import Model.State.PrgState;

import Model.Values.Value;

public class PrintStmt implements IStmt {
    private Exp exp;

    public PrintStmt(Exp exp){
        this.exp=exp;
    }
    @Override
    public String toString(){
        return "print("+exp.toString()+")";
    }

    public PrgState execute(PrgState state) throws MyException {
        MyIList<Value> out=state.getOut();
        MyIDictionary<String, Value> symTbl=state.getSymTable();
        Value v=exp.eval(symTbl);
        out.add(v);

        return state;
    }
}
