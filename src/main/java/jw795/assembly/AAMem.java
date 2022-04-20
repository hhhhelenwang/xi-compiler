package jw795.assembly;

import java.util.Optional;

/**
 * A memory address in abstract assembly
 */
public class AAMem extends AAOperand{
    // Memory operands are of the form [base + scale * index] or [base + scale * imm]. All are optional.
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
            strOfMem += base.get();
        }

        if (index.isPresent()){
                if (scale.get() > 0){
                    if (base.isPresent()){
                        strOfMem += "+";
                    }
                    strOfMem += scale.get() + "*" + index.get();
                } else {
                    strOfMem += "-" + scale.get() + "*" + index.get();
                }
//            }
//            else {
//                if (base.isPresent()){
//                    strOfMem += "+" + index.get();
//                } else {
//                    strOfMem += index.get();
//                }
//            }
        }

        //rbp - 1 * 8         + 16
        //base scale * index  imm(pos)
        if (immediate.isPresent()){
            if (scale.isPresent()){
                if (index.isPresent()){
                    if (base.isPresent()){
                        strOfMem += "+";
                    }
                    strOfMem += immediate.get();
                } else {
                    if (scale.get() < 0){
                        strOfMem += "-" + immediate.get();
                    }
                }
            }
        }

        if (label.isPresent()){
            strOfMem += "+" + label.get();
        }
        strOfMem += "]";

        return strOfMem;
    }
}
