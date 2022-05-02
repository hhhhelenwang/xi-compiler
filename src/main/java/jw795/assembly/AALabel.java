package jw795.assembly;

/**
 * A label that can be passed into control flow instructions to be used as an operand.
 * For example, l1 in an instruction "jmp l1" is an AALabel.
 * For labels used for marking code, see AALabelInstr.
 */
public class AALabel extends AAOperand{

    private String name;

    public AALabel(String labelName) {
        super();
        name = labelName;
    }

    @Override
    public String toString() {
        return name;
    }
}
