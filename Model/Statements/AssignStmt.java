package Model.Statements;

import Model.Data.MyIDictionary;
import Model.Data.MyIStack;
import Model.Exception.MyException;
import Model.Expressions.Exp;
import Model.State.PrgState;
import Model.Types.Type;
import Model.Values.Value;

public class AssignStmt implements IStmt {
    private String id;
    private Exp exp;

    public AssignStmt(String id, Exp exp){
        this.id=id;
        this.exp=exp;
    }
    @Override
    public String toString() {
        return id+"=" + exp.toString();
    }

    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk=state.getExeStack();
        MyIDictionary<String, Value> symTbl=state.getSymTable();
        Value val=exp.eval(symTbl);
        if (symTbl.isDefined(id)){
            Type typId=(symTbl.get(id)).getType();
            if ((val.getType()).equals(typId)) {
                symTbl.update(id, val);
            }
            else throw new MyException("declared type of variable"+id+" and type of the assigned expression do not match");
        }
        else throw new MyException("the used variable"+id+" was not declared before");
        return state;
    }


}
