package Model.Values;

import Model.Types.BoolType;
import Model.Types.Type;

public class BoolValue implements Value {
    private boolean val;
    public BoolValue(boolean value){
        this.val=value;
    }

    public boolean getVal(){
        return this.val;
    }

    public Type getType() {
        return new BoolType();
    }

    @Override
    public String toString(){
        return (Boolean.toString(this.val));
    }
}
