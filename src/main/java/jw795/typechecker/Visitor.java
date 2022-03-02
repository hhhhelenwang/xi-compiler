package jw795.typechecker;
import jw795.ast.*;

public abstract class Visitor {

    public abstract void enterScope();
    public abstract void leaveScope();
    // Expression =================
    // array literal
    public abstract void visitArrayExpr(ArrayExpr node) throws Exception;

    //indexing
    public abstract void visitArrIndexExpr(ArrIndexExpr node) throws Exception;

    // int, bool, string, char literals
    public abstract void visitIntLiteral(IntLiteral node);
    public abstract void visitBoolLiteral(BoolLiteral node);
    public abstract void visitStringLit(StringLit node);
    public abstract void visitCharLiteral(CharLiteral node);
    public abstract void visitFunCallExpr(FunCallExpr node) throws Exception;

    // variable
    public abstract void visitVar(VarExpr node) throws Exception;

    // UnOps
    public abstract void visitIntNeg(IntNeg node) throws Exception;
    public abstract void visitNot(Not node) throws Exception;

    // BinOps algebraic
    public abstract void visitAdd(Add node) throws Exception;
    public abstract void visitSub(Sub node) throws Exception;
    public abstract void visitMult(Mult node) throws Exception;
    public abstract void visitHighMult(HighMult node) throws Exception;
    public abstract void visitDiv(Div node) throws Exception;
    public abstract void visitMod(Mod node) throws Exception;
    // BinOps logical
    public abstract void visitAnd(And node) throws Exception;
    public abstract void visitOr(Or node) throws Exception;
    // BinOps compare
    public abstract void visitEqual(Equal node) throws Exception;
    public abstract void visitNotEqual(NotEqual node) throws Exception;
    public abstract void visitLessThan(LessThan node) throws Exception;
    public abstract void visitLessEq(LessEq node) throws Exception;
    public abstract void visitGreaterThan(GreaterThan node) throws Exception;
    public abstract void visitGreaterEq(GreaterEq node) throws Exception;

    // Statement =====================
    //Procedure
    public abstract void visitPrCall(ProcCallStmt node) throws Exception;
    //Block stmt (SEQ)
    public abstract void visitBlockStmt(BlockStmt node) throws Exception;
    //If stmt
    public abstract void visitIfStmt(IfStmt node) throws Exception;
    //If Else stmt
    public abstract void visitIfElseStmt(IfElseStmt node) throws Exception;
    //While stmt
    public abstract void visitWhileStmt(WhileStmt node) throws Exception;
    //Return stmt
    public abstract void visitRet(ReturnStmt node) throws Exception;
    //Assign stmt
    public abstract void visitAssign(AssignStmt node) throws Exception;

    public abstract void visitWildCard(WildCard node);

    // Variable Declare stmt
    public abstract void visitVarDecl(VarDeclareStmt node);
    public abstract void visitFundef(FunctionDefine node);
    public abstract void visitPrdef(ProcedureDefine node);
}
