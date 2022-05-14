package jw795.optimizer;

import jw795.asmgenerator.Tiler;
import jw795.assembly.AAReg;

public enum NodeColor {
    rax(Tiler.rax),
    rbx(Tiler.rbx),
    rcx(Tiler.rcx),
    rdx(Tiler.rdx),
    rsi(Tiler.rsi),
    rdi(Tiler.rdi),
    r8(Tiler.r8),
    r9(Tiler.r9),
    r10(Tiler.r10),
    r11(Tiler.r11),
    r12(Tiler.r12),
    r13(Tiler.r13),
    r14(Tiler.r14),
    r15(Tiler.r15);

    private final AAReg reg;

    NodeColor(AAReg reg) {
        this.reg = reg;
    }

    public AAReg colorToReg () {
        return reg;
    }
}

