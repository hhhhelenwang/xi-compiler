package jw795.typechecker;

public class Tau implements T{

    public boolean equals (Tau type) {
        if (!(this instanceof Array)) { // first type is an array
            return this.getClass() == type.getClass();
        } else { // first type is not an array
            if (!(type instanceof Array)) { // second type is not an array
                return false;
            } else {
                return (!((Array)this).elementType.equals(((Array) type).elementType));
            }
        }
    }

    public boolean isSubOf (XiType t) {
        return ((this.getClass() == t.getClass()) || (t instanceof Unit));
    }
}
