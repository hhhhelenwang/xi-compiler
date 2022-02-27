package jw795.typechecker;

public class TypedArray extends Tau {
    Tau elementType;

    public TypedArray(Tau type) {
        elementType = type;
    }

}
