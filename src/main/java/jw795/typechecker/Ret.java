package jw795.typechecker;

/**
 * A representation of return type that store the function return types in context.
 */
public class Ret implements Sigma{
    T retType;

    public Ret(T retType) {
        this.retType = retType;
    }

    public String toStr() {
        return "ret " + retType.toStr();
    }
}
