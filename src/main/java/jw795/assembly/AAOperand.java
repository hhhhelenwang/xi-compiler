package jw795.assembly;

import java.util.Objects;

public abstract class AAOperand {

    @Override
    public abstract String toString();

    @Override
    public boolean equals (Object o) {
        return (o instanceof AAOperand) && this.toString().equals(o.toString());
    }

    @Override
    public int hashCode(){
        return toString().hashCode();
    }
}
