package Model.Expressions;

import Model.Data.MyIDictionary;
import Model.Exception.MyException;
import Model.Types.BoolType;
import Model.Values.BoolValue;
import Model.Values.Value;

public class LogicExp implements Exp {
    private Exp e1,e2;
    private int op;//1-&&, 2-||
    public LogicExp(Exp e1,Exp e2, int op){
        this.e1=e1;
        this.e2=e2;
        this.op=op;
    }

    private String getOpSign(){
        if (this.op==1) return "&&";
        if (this.op==2) return "||";
        return null;
    }

    public Value eval(MyIDictionary<String, Value> tbl) throws MyException{
        Value v1,v2;
        v1=e1.eval(tbl);
        if (v1.getType().equals(new BoolType())){
            v2=e2.eval(tbl);
            if (v2.getType().equals(new BoolType())){
                BoolValue b1=(BoolValue)v1;
                BoolValue b2=(BoolValue)v2;
                boolean n1,n2;
                n1=b1.getVal();
                n2=b2.getVal();
                if (this.op==1){
                    return new BoolValue(n1&&n2);
                }
                if (this.op==2){
                    return new BoolValue(n1||n2);
                }

            }
            else throw new MyException("second operand is not bool type");
        }
        else throw new MyException("first operand is not bool type");
        return v1;
    }

    @Override
    public String toString(){
        return e1.toString()+getOpSign()+e2.toString();
    }
}
