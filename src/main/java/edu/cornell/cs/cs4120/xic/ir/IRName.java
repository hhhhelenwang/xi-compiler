package edu.cornell.cs.cs4120.xic.ir;

import edu.cornell.cs.cs4120.util.SExpPrinter;

import java.util.HashSet;

/** An intermediate representation for named memory address NAME(n) */
public class IRName extends IRExpr_c {
    private String name;

    /** @param name name of this memory address */
    public IRName(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public String label() {
        return "NAME(" + name + ")";
    }

    @Override
    public void printSExp(SExpPrinter p) {
        p.startList();
        p.printAtom("NAME");
        p.printAtom(name);
        p.endList();
    }

    @Override
    public HashSet<IRTemp> vars() {
        return new HashSet<>();
    }
}
