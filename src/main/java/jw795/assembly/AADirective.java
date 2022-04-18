package jw795.assembly;

/**
 * An assembly directive.
 */
public class AADirective extends AAInstruction{

    public enum DirType {
        TEXT,
        DATA,
        QUAD;

        @Override
        public String toString() {
            switch (this) {
                case TEXT:
                    return ".text";
                case DATA:
                    return ".data";
                case QUAD:
                    return ".quad";
                default:
                    return null;
            }
        }
    }

    private DirType dirType;

    public AADirective(DirType type) {
        dirType = type;
    }

    @Override
    public String toString() {
        return dirType.toString();
    }
}
