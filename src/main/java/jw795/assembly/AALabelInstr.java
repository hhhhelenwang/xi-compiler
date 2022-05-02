package jw795.assembly;

/**
 * The label instruction that can be used to mark a location in the code. For example,
 * l1: add t1, 2
 *     add t1, 3
 *
 * Here, l1 is an AALabelInstr
 */
public class AALabelInstr extends AAInstruction{

    private String name;

    public AALabelInstr(String labelName) {
        super();
        name = labelName;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return name + ":";
    }
}
