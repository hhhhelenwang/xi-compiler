package jw795.assembly;

/**
 * A temp in abstract assembly
 */
public class AAReg extends AAOperand{
    String regName;
    //caller-saved rax, rcx, rdx
    //callee-saved rdi, rsi, rbx, rbp, r12-r15
    public AAReg(String name) {
        regName = name;
    }

    public String name() {
        return  regName;
    }

    @Override
    public String toString() {
        return regName;
    }
}
