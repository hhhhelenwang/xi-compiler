package jw795.typechecker;

public class Array implements XiType {
    XiType elementType;

    public Array(XiType type) {
        elementType = type;
    }
}
