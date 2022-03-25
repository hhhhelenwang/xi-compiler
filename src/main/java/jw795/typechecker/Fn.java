package jw795.typechecker;

/**
 * Representation of a function's type
 */
public class Fn implements Sigma{
    public T inputType;
    public T outputType;

    public Fn(T inputType, T outputType) {
        this.inputType = inputType;
        this.outputType = outputType;
    }

    public boolean functionEquals(Fn t) {
        return this.inputType.equals(t.inputType)
                && this.outputType.equals(t.outputType);
    }

    public String toStr() {
        return "fn " + inputType.toStr() + " => " + outputType.toStr();
    }
}
