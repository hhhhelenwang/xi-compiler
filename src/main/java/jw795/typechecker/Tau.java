package jw795.typechecker;

public class Tau implements T{

    @Override
    public boolean equals(T type) {
        if (type instanceof Tau) {
            if (!(this instanceof Array)) {
                if ((this instanceof Int && type instanceof Int) || (this instanceof Bool && type instanceof Bool)){
                    return true;
                } else {
                    return false;
                }
            } else {
                if (!(type instanceof Array)) {
                    return false;   // first type is an array, second type is not an array
                } else {
                    return ((Array)this).compare((Array)type) || ((Array)type).compare((Array)this);
                }
            }
        } else {
            return false;
        }
    }

    public boolean isSubOf (T t) {
        return ((this.getClass() == t.getClass()) || (t instanceof Unit));
    }

    public String toStr(){
        return "tau";
    }
}

