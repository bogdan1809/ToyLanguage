package Model.Expressions;

import Model.Data.MyIDictionary;
import Model.Exception.MyException;
import Model.Values.Value;

public class VarExp implements Exp {
    private String id;
    public VarExp(String id){
        this.id=id;
    }

    public Value eval(MyIDictionary<String, Value> tbl) throws MyException{
        return tbl.get(id);
    }

    @Override
    public String toString(){
        return this.id;
    }
}
