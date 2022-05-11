package jw795.assembly;

import java.util.Objects;

public abstract class AAOperand {

    @Override
    public abstract String toString();

    @Override
    public boolean equals (Object o) {
        return this.toString().equals(o.toString());
    }
}
