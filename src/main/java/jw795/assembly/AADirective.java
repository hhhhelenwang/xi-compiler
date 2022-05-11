package jw795.assembly;

import java.util.HashSet;

/**
 * An assembly directive.
 */
public class AADirective extends AAInstruction{
    String sofname = "";

    public enum DirType {
        TEXT,
        DATA,
        QUAD,
        INTEL,
        GLOBAL;

        @Override
        public String toString() {
            switch (this) {
                case TEXT:
                    return ".text";
                case DATA:
                    return ".data";
                case QUAD:
                    return ".quad";
                case INTEL:
                    return ".intel_syntax noprefix";
                case GLOBAL:
                    return ".global";
                default:
                    return null;
            }
        }
    }

    private DirType dirType;

    public AADirective(DirType type) {
        dirType = type;
    }
    public AADirective(DirType type, String name) {
        dirType = type;
        sofname = " " + name;
    }

    @Override
    public String toString() {
        return dirType.toString()+sofname;
    }

    @Override
    public HashSet<AAOperand> use() {
        return new HashSet<>();
    }
}
