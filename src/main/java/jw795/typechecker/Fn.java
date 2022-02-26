package jw795.typechecker;

public class Fn implements Sigma{
    T inputType;
    T outputType;

    public Fn(T inputType, T outputType) {
        this.inputType = inputType;
        this.outputType = outputType;
    }
}
