package jw795.assembly;

import java.util.Optional;

/**
 * A memory address in abstract assembly
 */
public class AAMem extends AAOperand{
    // Memory operands are of the form [base + scale * index] or [base + scale * imm]. All are optional.
    Optional<AATemp> base;
    Optional<AATemp> index;
    Optional<Long> scale;
    Optional<AAImm> immediate;

    public AAMem() {
        base = Optional.empty();
        index = Optional.empty();
        scale = Optional.empty();
        immediate = Optional.empty();

    }

    public void setBase(AATemp b) {
        base = Optional.of(b);
    }

    public void setIndex(AATemp i) {
        index = Optional.of(i);
    }

    public void setScale(long s) {
        scale = Optional.of(s);
    }

    public void setImmediate(AAImm imm) {
        immediate = Optional.of(imm);
    }

    @Override
    public String toString() {
        String strOfMem = "";
        if (base.isPresent()) {
            strOfMem += base.get();
        }

        if (scale.isPresent()) {

            if (index.isPresent()) {
                strOfMem += "+" + scale.get() + "*" + index.get();
            }
        } else {
            if (index.isPresent()) {
                strOfMem += "+" + index.get();
            }
        }

        if (immediate.isPresent()) {
            strOfMem += "+" + immediate.get();
        }

        return strOfMem;
    }
}
