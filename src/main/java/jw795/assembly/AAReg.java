package jw795.assembly;

import jw795.asmgenerator.Tiler;
import jw795.optimizer.NodeColor;

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

    public NodeColor toColor() {
        switch (regName) {
            case "rax":
                return NodeColor.rax;
            case "rbx":
                return NodeColor.rbx;
            case "rcx":
                return NodeColor.rcx;
            case "rdx":
                return NodeColor.rdx;
            case "rsi":
                return NodeColor.rsi;
            case "rdi":
                return NodeColor.rdi;
            case "r8":
                return NodeColor.r8;
            case "r9":
                return NodeColor.r9;
            case "r10":
                return NodeColor.r10;
            case "r11":
                return NodeColor.r11;
            case "r12":
                return NodeColor.r12;
            case "r13":
                return NodeColor.r13;
            case "r14":
                return NodeColor.r14;
            case "r15":
                return NodeColor.r15;
            default:
                return null;
        }
    }
}
