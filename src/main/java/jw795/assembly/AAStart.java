package jw795.assembly;

import java.util.HashSet;

/**
 * Represent the start node in an asm cfg
 */
public class AAStart extends AAInstruction{

    @Override
    public String toString() {
        return "start";
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
