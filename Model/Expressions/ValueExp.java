package Model.Expressions;

import Model.Data.MyIDictionary;
import Model.Exception.MyException;
import Model.Values.Value;

public class ValueExp implements Exp {
    private Value e;
    public ValueExp(Value e){
        this.e=e;
    }

    public Value eval(MyIDictionary<String, Value> tbl) throws MyException{
        return e;
    }

    @Override
    public String toString(){
        return e.toString();
    }
}
