package edu.cornell.cs.cs4120.xic.ir;

import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import edu.cornell.cs.cs4120.util.SExpPrinter;
import edu.cornell.cs.cs4120.xic.ir.visit.*;
import jw795.asmgenerator.Tile;

import java.io.PrintWriter;
import java.io.StringWriter;

/** A node in an intermediate-representation abstract syntax tree. */
public abstract class IRNode_c implements IRNode {

    public Tile optTile;

    public void setTile(Tile tile) {
        optTile = tile;
    }

    @Override
    public IRNode visitChildren(IRVisitor v) {
        return this;
    }

    @Override
    public <T> T aggregateChildren(AggregateVisitor<T> v) {
        return v.unit();
    }

    @Override
    public InsnMapsBuilder buildInsnMapsEnter(InsnMapsBuilder v) {
        return v;
    }

    @Override
    public IRNode buildInsnMaps(InsnMapsBuilder v) {
        v.addInsn(this);
        return this;
    }

    @Override
    public CheckCanonicalIRVisitor checkCanonicalEnter(CheckCanonicalIRVisitor v) {
        return v;
    }

    @Override
    public boolean isCanonical(CheckCanonicalIRVisitor v) {
        return true;
    }

    @Override
    public boolean isConstFolded(CheckConstFoldedIRVisitor v) {
        return true;
    }

    @Override
    public abstract String label();

    @Override
    public abstract void printSExp(SExpPrinter p);

    @Override
    public String toString() {
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw);
                SExpPrinter sp = new CodeWriterSExpPrinter(pw)) {
            printSExp(sp);
        }
        return sw.toString();
    }
}
