package jw795.assembly;

import java.util.Optional;

public abstract class AAInstruction {

    public Optional<AAOperand> operand1;
    public Optional<AAOperand> operand2;

    public AAInstruction (AAOperand opr){
        operand1 = Optional.of(opr);
        operand2 = Optional.empty();
    }

    public AAInstruction(AAOperand opr1, AAOperand opr2) {
        operand1 = Optional.of(opr1);
        operand2 = Optional.of(opr2);
    }

    public AAInstruction() {
        operand1 = Optional.empty();
        operand1 = Optional.empty();
    }

    // TODO: build up classes for each kinds of assembly instruction that we might use.
    //  See lecture notes for a somewhat comprehensive list of opcodes we use.

    public abstract String toString();
}
