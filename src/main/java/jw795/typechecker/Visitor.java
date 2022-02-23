package jw795.typechecker;
import jw795.ast.*;

public abstract class Visitor {
    public abstract void visitAdd(Add node);
    public abstract void visitArrayExpr(ArrayExpr node);
}
