package jw795.typechecker;

/**
 * Representation of a variable type that exist in the context
 */
public class Var implements Sigma{
    Tau varType;

    public Var(Tau varType) {
        this.varType = varType;
    }

    public String toStr() {
        return "var " + varType.toStr();
    }
}
