package jw795.assembly;

import java.util.HashSet;

public class AASetcc extends AAInstruction{

    public enum Condition {
        //case EQ: case NEQ: case LT: case ULT: case GT: case LEQ: case GEQ:
        EQ,
        NEQ,
        LT,
        ULT,
        GT,
        LEQ,
        GEQ;

        @Override
        public String toString() {
            switch (this) {
                case EQ:
                    return "e";
                case NEQ:
                    return "ne";
                case LT:
                    return "l";
                case ULT:
                    return "b"; // below = unsigned less than
                case GT:
                    return "g";
                case LEQ:
                    return "le";
                case GEQ:
                    return "ge";
                default:
                    return null;
            }
        }
    }
    private Condition cond;

    public AASetcc(AAOperand op1, Condition cc) {
        super(op1);
        cond = cc;
    }

    @Override
    public String toString() {
        return "set" + cond + " " + operand1.get();
    }

    @Override
    public HashSet<AAOperand> use() {
        return new HashSet<>();
    }
}
