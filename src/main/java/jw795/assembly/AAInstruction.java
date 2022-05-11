package jw795.assembly;

import java.util.HashSet;
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
        operand2 = Optional.empty();
    }

    public void reseta1(AAOperand a1){
        this.operand1 = Optional.of(a1);
    }
    public void reseta2(AAOperand a2){
        this.operand2 = Optional.of(a2);
    }


    /**
     * The use set of this instruction. This is a default implementation
     * @return use(instr)
     */
    public HashSet<AAOperand> use() {
        HashSet<AAOperand> useSet =  new HashSet<>();
        operand1.ifPresent(operand -> useSet.addAll(vars(operand)));
        operand2.ifPresent(operand -> useSet.addAll(vars(operand)));
        return useSet;
    }

    /**
     * The set of variables used by an AAOperand expr
     * @return variables used by expr
     */
    public HashSet<AAOperand> vars(AAOperand expr) {
        HashSet<AAOperand> result = new HashSet<>();
        if (expr instanceof AAImm || expr instanceof AADynamic) {
            return result;
        } else if (expr instanceof AAReg || expr instanceof AATemp) {
            result.add(expr);
        } else if (expr instanceof AAMem) {
            ((AAMem) expr).base.ifPresent(result::add);
            ((AAMem) expr).base.ifPresent(result::add);
        }
        return result;
    }

    public abstract String toString();
}
