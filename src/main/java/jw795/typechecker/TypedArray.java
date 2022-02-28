package jw795.typechecker;

public class TypedArray extends Array {
    Tau elementType;

    public TypedArray(Tau type) {
        elementType = type;
    }

    public boolean compare (Array a) {
        if (a instanceof EmptyArray) {
            return false;
        } else {
            Tau t = ((TypedArray)a).elementType;
            if (elementType instanceof EmptyArray && (t instanceof TypedArray || t instanceof EmptyArray)) {
                return true;
            } else if (elementType instanceof TypedArray && t instanceof TypedArray) {
                return ((TypedArray)elementType).compare((TypedArray)t);
            } else if (elementType.equals(t)){
                return true;
            } else {
                return false;
            }
        }
    }
}
