package jw795.typechecker;

public class TypedArray extends Array {
    Tau elementType;

    /**
     * Array type with the type of the element known. In other words, an array that's not an empty array
     * @param type type of the element inside the array.
     */
    public TypedArray(Tau type) {
        elementType = type;
    }

    /**
     *
     * @param a Array this is compared with
     * @return whether this is "subtype or equal to" a. If both have the exact same type, return true.
     * If a is more informative than this, return true. Else return false (If this and a doesn't match, return false).
     */
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
