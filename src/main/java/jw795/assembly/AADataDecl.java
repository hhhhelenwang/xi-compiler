package jw795.assembly;

/**
 * A data declaration directive that marks a 4 byte data space
 */
public class AADataDecl extends AADirective{

    private long value;

    public AADataDecl(long val) {
        super(DirType.QUAD);
        value = val;
    }


    @Override
    public String toString() {
        return super.toString() + " " + value;

    }
}
