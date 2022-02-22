package jw795.typechecker;

import jw795.ast.*;

public class TypeChecker extends Visitor{

    @Override
    public void visitAdd(Add node) {
        if ((node.expr1.type() instanceof Int) && (node.expr2.type() instanceof Int)) {
            node.type = new Int();
        }
    }
}
