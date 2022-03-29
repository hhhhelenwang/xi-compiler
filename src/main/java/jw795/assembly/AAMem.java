package jw795.assembly;

/**
 * A memory address in abstract assembly
 */
public class AAMem extends AAOperand{
    // Memory operands are of the form [base + scale * index] or [base + scale * imm]. All are optional.
    AATemp base;
    AATemp index;
    long scale;
    AAImm immediate;

    public AAMem() {

    }

    public void setBase(AATemp b) {
        base = b;
    }

    public void setIndex(AATemp i) {
        index = i;
    }

    public void setScale(long s) {
        scale = s;
    }

    public void setImmediate(AAImm imm) {
        immediate = imm;
    }

    @Override
    public String toString() {
        return null;
    }
}
