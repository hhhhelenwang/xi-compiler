package jw795.assembly;

import java.util.Optional;

/**
 * A memory address in abstract assembly
 */
public class AAMem extends AAOperand{
    // cases: [base], [base + scale * index], [base + scale * imm], [scale * index], [scale * imm],
    // [base + index] (scale assumed to be 1), [base + imm] (scale assumed to be 1), [imm], [base + Label].
    Optional<AAReg> base;
    Optional<AAReg> index;
    Optional<Long> scale;
    Optional<AAImm> immediate;
    Optional<AALabel> label;

    public AAMem() {
        base = Optional.empty();
        index = Optional.empty();
        scale = Optional.empty();
        immediate = Optional.empty();
        label = Optional.empty();
    }

    public void setBase(AAReg b) {
        base = Optional.of(b);
    }

    public void setIndex(AAReg i) {
        index = Optional.of(i);
    }

    public void setScale(long s) {
        scale = Optional.of(s);
    }

    public void setImmediate(AAImm imm) {
        immediate = Optional.of(imm);
    }

    public void setLabel(AALabel l) {label = Optional.of(l); }

    @Override
    public String toString() {
        String strOfMem = "[";

        if (base.isPresent()) {
            strOfMem += base.get(); //base
            if (scale.isPresent()) {
                if (scale.get() >= 0) {
                    strOfMem += "+";
                }
                strOfMem += scale.get() + "*";
                if (index.isPresent()) {
                    strOfMem += index.get(); //base + scale * index
                } else {
                    strOfMem += immediate.get(); //base + scale * imm
                }
            } else {
                if (index.isPresent()) {
                    strOfMem += "+" + index.get(); //base + index
                } else if (immediate.isPresent()) {
                    strOfMem += "+" + immediate.get(); //base + imm
                } else if (label.isPresent()) {
                    strOfMem += "+" + label.get(); //base + label
                }
            }
        } else {
            if (scale.isPresent()) {
                strOfMem += scale.get() + "*";
                if (index.isPresent()) {
                    strOfMem += index.get(); //scale * index
                } else {
                    strOfMem += immediate.get(); //scale * imm
                }
            } else {
                strOfMem += immediate.get(); //imm
            }
        }

        strOfMem += "]";

        return strOfMem;
    }
}
