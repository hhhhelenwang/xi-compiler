package jw795.typechecker;

public class Fn implements Sigma{
    T inputType;
    T outputType;

    public Fn(T inputType, T outputType) {
        this.inputType = inputType;
        this.outputType = outputType;
    }

    public boolean equals(Fn t) {
        return this.inputType.getClass() == t.inputType.getClass()
                && this.outputType.getClass() == t.outputType.getClass();
    }

    @Override
    public String toString() {
        return "fn " + inputType.tostr() + " => " + outputType.tostr();
    }
}
