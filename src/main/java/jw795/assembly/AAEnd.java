package jw795.assembly;

import java.util.HashSet;

/**
 * Represent an end node in asm cfg
 */
public class AAEnd extends AAInstruction{
    @Override
    public String toString() {
        return "end";
    }

    @Override
    public HashSet<AAOperand> use() {
        return new HashSet<>();
    }

    @Override
    public HashSet<AAOperand> def() {
        return new HashSet<>();
    }
}
