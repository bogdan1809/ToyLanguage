package Model.Statements;

import Model.Data.MyIDictionary;
import Model.Exception.MyException;
import Model.State.PrgState;
import Model.Types.BoolType;
import Model.Types.IntType;
import Model.Types.Type;
import Model.Values.BoolValue;
import Model.Values.IntValue;
import Model.Values.Value;

public class VarDeclStmt implements IStmt {
    private String name;
    private Type type;

    public VarDeclStmt(String name, Type type){
        this.name=name;
        this.type=type;
    }

    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String, Value> symTbl= state.getSymTable();

        if(symTbl.isDefined(name)){
            throw new MyException("There already exists a variable with this name");

        }
        if (type.equals(new IntType())){
            Value i=new IntValue(0);
            symTbl.add(name,i);
        }
        else{
            if (type.equals(new BoolType())){
                Value b=new BoolValue(false);
                symTbl.add(name,b);
            }

        }
        return state;
    }

    @Override
    public String toString(){
        return "Name: "+name+" Type:"+type.toString();
    }
}
