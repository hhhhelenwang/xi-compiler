package jw795.typechecker;

public class Array extends Tau {
    Tau elementType;

    public Array(Tau type) {
        elementType = type;
    }

}
