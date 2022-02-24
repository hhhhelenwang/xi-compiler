package jw795.typechecker;
import jw795.ast.*;

public abstract class Visitor {
    public abstract void visitAdd(Add node);
    public abstract void visitArrayExpr(ArrayExpr node);

    public abstract void visitIntType(IntType node);
    public abstract void visitBoolType(BoolType node);
    public abstract void visitStringLit(StringLit node);
    public abstract void visitCharLiteral(CharLiteral node);
    public abstract void visitFunCallExpr(FunCallExpr node);
}
