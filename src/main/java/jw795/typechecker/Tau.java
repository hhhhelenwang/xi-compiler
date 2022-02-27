package jw795.typechecker;

public class Tau implements T{

    public boolean equals (Tau type) {
        if (!(this instanceof Array)) {
            return this.getClass() == type.getClass();  // first type is not an array
        } else {
            if (!(type instanceof TypedArray)) {
                return false;   // first type is an array, second type is not an array
            } else {
                if ((this instanceof EmptyArray) || (type instanceof EmptyArray)) {
                    return true;    // first type is an empty array or second type is an empty array
                } else {
                    // both are array with known element type
                    return (!((TypedArray)this).elementType.equals(((TypedArray) type).elementType));
                }
            }
        }
    }

    public boolean isSubOf (XiType t) {
        return ((this.getClass() == t.getClass()) || (t instanceof Unit));
    }
}
