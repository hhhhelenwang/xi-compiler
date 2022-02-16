package jw795.ast;

import java.util.Optional;

/**
 * Representation of array type. Contains the type of the array's elements.
 */
public class ArrayType implements Type {
    Type elemType;
    Optional<Integer> length;

    ArrayType(Type type) {
        elemType = type;
        length = Optional.empty();
    }

    ArrayType(Type type, int len) {
        elemType = type;
        length = Optional.of(len);
    }
}
