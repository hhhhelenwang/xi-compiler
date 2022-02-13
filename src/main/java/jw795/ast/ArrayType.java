package jw795.ast;

/**
 * Representation of array type. Contains the type of the array's elements.
 */
public class ArrayType implements Type {
    Type elemType;

    ArrayType(Type type) {
        elemType = type;
    }
}
