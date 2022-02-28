package jw795.typechecker;
import jw795.ast.*;

public abstract class Visitor {
    // Expression =================
    // array literal
    public abstract void visitArrayExpr(ArrayExpr node);

    // int, bool, string, char literals
    public abstract void visitIntLiteral(IntLiteral node);
    public abstract void visitBoolLiteral(BoolLiteral node);
    public abstract void visitStringLit(StringLit node);
    public abstract void visitCharLiteral(CharLiteral node);
    public abstract void visitFunCallExpr(FunCallExpr node);
    public abstract void visitLength(FunCallExpr node);

    // variable
    public abstract void visitVar(VarExpr node);

    // UnOps
    public abstract void visitIntNeg(IntNeg node);
    public abstract void visitNot(Not node);

    // BinOps algebraic
    public abstract void visitAdd(Add node);
    public abstract void visitSub(Sub node);
    public abstract void visitMult(Mult node);
    public abstract void visitHighMult(HighMult node);
    public abstract void visitDiv(Div node);
    public abstract void visitMod(Mod node);
    // BinOps logical
    public abstract void visitAnd(And node);
    public abstract void visitOr(Or node);

    // BinOps compare
    public abstract void visitEqual(Equal node);
    public abstract void visitNotEqual(NotEqual node);
    public abstract void visitLessThan(LessThan node);
    public abstract void visitLessEq(LessEq node);
    public abstract void visitGreaterThan(GreaterThan node);
    public abstract void visitGreaterEq(GreaterEq node);

    // Statement =====================
    //Procedure
    public abstract void visitPrCall(ProcCallStmt node);

    //Return stmt
    public abstract void visitRet(ReturnStmt node);

}
