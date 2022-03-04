package jw795.typechecker;

public class EmptyArray extends Array {
    /**
     * Type of the empty array
     */
    public EmptyArray() {
    }
    /**
     *
     * @param a Array this is compared with
     * @return whether this is "subtype or equal to" a. If both have the exact same type, return true.
     * If a is more informative than this, return true. Else return false (If this and a doesn't match, return false).
     */
    public boolean compare (Array a) {
        return true;
    }

    public String toStr(){
        return "tau" + "[]";
    }
}
