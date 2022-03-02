package jw795.typechecker;

public class Tau implements T{

    public boolean equals (Tau type) {
        if (!(this instanceof Array)) {
            return this.getClass() == type.getClass();  // first type is not an array
        } else {
            if (!(type instanceof Array)) {
                return false;   // first type is an array, second type is not an array
            } else {
                return ((Array)this).compare((Array)type) || ((Array)type).compare((Array)this);
            }
        }
    }

    public boolean isSubOf (T t) {
        return ((this.getClass() == t.getClass()) || (t instanceof Unit));
    }

    public String tostr(){
        return "tau";
    }
}

