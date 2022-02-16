package jw795.ast;

import java.util.Optional;

/**
 * Representation of array type. Contains the type of the array's elements.
 */
public class ArrayType extends Type {
    Type elemType;
    Optional<Integer> length;

    ArrayType(Type type, int line, int col) {
        super(line, col);
        elemType = type;
        length = Optional.empty();
    }

    ArrayType(Type type, int len, int line, int col) {
        super(line, col);
        elemType = type;
        length = Optional.of(len);
    }
}
