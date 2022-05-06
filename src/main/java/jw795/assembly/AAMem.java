package jw795.assembly;

import java.util.Optional;

/**
 * A memory address in abstract assembly
 */
public class AAMem extends AAOperand{
    // a memory operand can contain two registers: base and index
    // and one immediate offset: immediate
    // and a constant scale that can be (+/-) (1, 2, 4, 8) can can be applied to index
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
                    if (scale.get() == 1) {
                        strOfMem += "+";
                    } else {
                        strOfMem += "+" + scale.get() + "*";
                    }
                } else {
                    if (scale.get() == -1) {
                        strOfMem += "-";
                    } else {
                        strOfMem += scale.get() + "*";
                    }
                }

                if (index.isPresent()) {
                    strOfMem += index.get(); //base + scale * index
                }

            } else {
                if (index.isPresent()) {
                    strOfMem += "+" + index.get(); //base + index
                }
            }

            if (immediate.isPresent()) {
                if (immediate.get().val() >= 0) {
                    strOfMem += "+" + immediate.get(); // base + imm
                } else {
                    strOfMem += immediate.get();
                }
            }
            if (label.isPresent()) {
                strOfMem += "+" + label.get(); //base + label
            }
        } else {
            if (scale.isPresent()) {
                if (scale.get() >= 0) {
                    if (scale.get() == 1) {
                        strOfMem += "+";
                    } else {
                        strOfMem += scale.get() + "*";
                    }
                } else {
                    if (scale.get() == -1) {
                        strOfMem += "-";
                    } else {
                        strOfMem += scale.get() + "*";
                    }
                }
            }
            //  no base so add index directly if present
            if (index.isPresent()) {
                strOfMem += index.get(); //scale * index
            }

            if (immediate.isPresent()) {
               strOfMem += immediate.get(); //imm
            }

        }

        strOfMem += "]";

        return strOfMem;
    }
}
