package jw795.typechecker;

public class Unit implements T, R {
    @Override
    public String toStr() {
        return "unit";
    }

    @Override
    public boolean equals(T t) {
        return (t instanceof Unit);
    }
}
