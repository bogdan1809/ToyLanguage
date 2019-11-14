package Model.Expressions;

import Model.Data.MyIDictionary;
import Model.Exception.MyException;
import Model.Types.IntType;
import Model.Values.IntValue;
import Model.Values.Value;

public class ArithExp implements Exp {
    private Exp e1,e2;
    private int op;//1- plus, 2-minus, 3-star, 4-divide

    public ArithExp(int operation, Exp e1, Exp e2){
        this.e1=e1;
        this.e2=e2;
        this.op=operation;

    }

    private String getOpSign(){
        if (this.op==1) return "+";
        if (this.op==2) return "-";
        if (this.op==3) return "*";
        if (this.op==4) return "/";
        return null;
    }

    @Override
    public Value eval(MyIDictionary<String,Value> tbl) throws MyException {
        Value v1,v2;
        v1=e1.eval(tbl);
        if (v1.getType().equals(new IntType())){
            v2=e2.eval(tbl);
            if (v2.getType().equals(new IntType())){
                IntValue i1=(IntValue)v1;
                IntValue i2=(IntValue)v2;
                int n1,n2;
                n1=i1.getVal();
                n2=i2.getVal();
                if (op==1) return new IntValue(n1+n2);
                if (op==2) return new IntValue(n1-n2);
                if (op==3) return new IntValue(n1*n2);
                if (op==4) {
                    if (n2==0) throw new MyException("division by zero");
                    else return new IntValue(n1/n2);
                }
            }
            else throw new MyException("second operand is not an integer");
        }
        else throw new MyException("first operand is not an integer");
        return v1;
    }

    @Override
    public String toString(){
        return this.e1.toString()+getOpSign()+this.e2.toString();
    }
}

