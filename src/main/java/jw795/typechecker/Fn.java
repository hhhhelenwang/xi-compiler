package jw795.typechecker;

public class Fn implements Sigma{
    T inputType;
    T outputType;

    public Fn(T inputType, T outputType) {
        this.inputType = inputType;
        this.outputType = outputType;
    }

    public boolean functionEquals(Fn t) {
        return this.inputType.getClass() == t.inputType.getClass()
                && this.outputType.getClass() == t.outputType.getClass();
    }

    public String toStr() {
        return "fn " + inputType.toStr() + " => " + outputType.toStr();
    }
}
