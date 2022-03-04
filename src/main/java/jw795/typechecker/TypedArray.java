package jw795.typechecker;

public class TypedArray extends Array {
    public Tau elementType;

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
            Tau atype = ((TypedArray)a).elementType;
            if (this.elementType instanceof EmptyArray && (atype instanceof TypedArray || atype instanceof EmptyArray)) {
                return true;
            } else if (elementType instanceof TypedArray && atype instanceof TypedArray) {
                return ((TypedArray)elementType).compare(((TypedArray) atype));
            } else if (elementType.equals(atype)){
                return true;
            } else {
                return false;
            }
        }
    }


    public String tostr(){
        return elementType.tostr()+"[]";
    }
}
