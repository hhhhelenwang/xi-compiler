package edu.cornell.cs.cs4120.xic.ir;

import edu.cornell.cs.cs4120.util.SExpPrinter;

import java.util.HashSet;

/** An intermediate representation for a temporary register TEMP(name) */
public class IRTemp extends IRExpr_c {
    private String name;

    /** @param name name of this temporary register */
    public IRTemp(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public String label() {
        return "TEMP(" + name + ")";
    }

    @Override
    public void printSExp(SExpPrinter p) {
        p.startList();
        p.printAtom("TEMP");
        p.printAtom(name);
        p.endList();
    }

    @Override
    public boolean equals(Object t) {
        if (!(t instanceof IRTemp)) {
            return false;
        } else {
            if (this.name != ((IRTemp) t).name) {
                return false;
            } else{
                return true;
            }
        }
    }

    @Override
    public HashSet<IRTemp> vars() {
        HashSet<IRTemp> vars = new HashSet<>();
        vars.add(this);
        return vars;
    }
}
