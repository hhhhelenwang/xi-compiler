package jw795.assembly;

import java.util.HashSet;

/**
 * bogus AAInstruction for representing start and exit node in AsmCFG
 */
public class AABogus extends AAInstruction {
    // either start or end
    String name;

    public AABogus(String name) {
        this.name = name;
    }

    @Override
    public HashSet<AAOperand> use() {
        return new HashSet<>();
    }

    @Override
    public HashSet<AAOperand> def() {
        return new HashSet<>();
    }

    @Override
    public String toString() {
        return name;
    }
}
