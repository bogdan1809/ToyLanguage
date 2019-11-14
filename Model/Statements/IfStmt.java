package Model.Statements;

import Model.Data.MyIDictionary;
import Model.Data.MyIStack;
import Model.Exception.MyException;
import Model.Expressions.Exp;
import Model.State.PrgState;
import Model.Types.BoolType;
import Model.Values.BoolValue;
import Model.Values.Value;

public class IfStmt implements IStmt {
    private Exp exp;
    private IStmt thenS;
    private IStmt elseS;

    public IfStmt(Exp e, IStmt t, IStmt el) {
        this.exp=e;
        this.thenS=t;
        this.elseS=el;
    }

    public String toString(){
        return "(IF("+this.exp.toString()+")THEN (" +this.thenS.toString()+")ELSE("+this.elseS.toString()+"))";

    }

    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk= state.getExeStack();
        MyIDictionary<String, Value> symTbl=state.getSymTable();
        Value val=exp.eval(symTbl);
        if (!val.getType().equals(new BoolType())){
            throw new MyException("Conditional expr is not boolean");
        }
        else {
            BoolValue value=(BoolValue)val;
            if (value.getVal()) stk.push(thenS);
            else stk.push(elseS);
        }
        return state;
    }
}
