package jw795.typechecker;

public class Ret implements Sigma{
    T retType;

    public Ret(T retType) {
        this.retType = retType;
    }

    @Override
    public String toString() {
        return "ret T";
    }
}
