package Model.Types;

public class BoolType implements Type {
    public boolean equals(Object another){
        return another instanceof BoolType;
    }

    @Override
    public String toString() {return "bool";}
}

