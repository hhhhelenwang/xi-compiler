package jw795.typechecker;

public class Var implements Sigma{
    Tau varType;

    public Var(Tau varType) {
        this.varType = varType;
    }

    @Override
    public String toString() {
        return "var tau";
    }
}
