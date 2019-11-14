package Model.Expressions;

import Model.Data.MyIDictionary;
import Model.Exception.MyException;
import Model.Values.Value;

public interface Exp {
    Value eval(MyIDictionary<String,Value> tbl) throws MyException;
}
