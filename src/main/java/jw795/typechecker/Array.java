package jw795.typechecker;

public abstract class Array extends Tau {
    /**
     *
     * @param a Array this is compared with
     * @return whether this is "subtype or equal to" a. If both have the exact same type, return true.
     * If a is more informative than this, return true. Else return false (If this and a doesn't match, return false).
     */
    public abstract boolean compare(Array a);
}
