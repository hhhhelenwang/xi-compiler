package jw795.typechecker;

import jw795.ast.*;

public class TypeChecker extends Visitor{

    SymbolTable env;

    @Override
    // TODO: naming a bit confusing, can confuse with an int type keyword
    public void visitIntLiteral(IntLiteral node) {
        node.type = new Int();
    }

    @Override
    public void visitBoolLiteral(BoolLiteral node) {
        node.type = new Bool();
    }

    @Override
    public void visitStringLit(StringLit node) {
        if (node.type instanceof Array && ((Array) node.type).elementType instanceof Int ) {
            node.type = new Array(new Int()); //TODO: should be int[]
        }
    }

    @Override
    public void visitCharLiteral(CharLiteral node) {
        if (node.type instanceof Int ) {
            node.type = new Int();
        }
    }

    @Override
    public void visitFunCallExpr(FunCallExpr node) {
        //evaluates to new context, new conext != unit
    }

    @Override
    public void visitVar(VarExpr node) {
        if (env.contains(node.identifier)) {
            node.type = env.findType(node.identifier);
        }
    }

    @Override
    public void visitIntNeg(IntNeg node) {
        if (node.expr.type instanceof Int) {
            node.type = new Int();
        }
    }

    // helper check the type of the subexpressions of algebraic and comparison binop
    private void setBinOpIntType(BinOpExpr node) {
        if ((node.expr1.type instanceof Int) && (node.expr2.type instanceof Int)) {
            node.type = new Int();
        }
    }

    @Override
    public void visitAdd(Add node) {
        setBinOpIntType(node);
    }

    @Override
    public void visitSub(Sub node) {
        setBinOpIntType(node);
    }

    @Override
    public void visitMult(Mult node) {
        setBinOpIntType(node);
    }

    @Override
    public void visitHighMult(HighMult node) {
        setBinOpIntType(node);
    }

    @Override
    public void visitDiv(Div node) {
        setBinOpIntType(node);
    }

    @Override
    public void visitMod(Mod node) {
        setBinOpIntType(node);
    }

    @Override
    public void visitEqual(Equal node) {
        setBinOpIntType(node);
    }

    @Override
    public void visitNotEqual(NotEqual node) {
        setBinOpIntType(node);
    }

    @Override
    public void visitLessThan(LessThan node) {
        setBinOpIntType(node);
    }

    @Override
    public void visitLessEq(LessEq node) {
        setBinOpIntType(node);
    }

    @Override
    public void visitGreaterThan(GreaterThan node) {
        setBinOpIntType(node);
    }

    @Override
    public void visitGreaterEq(GreaterEq node) {
        setBinOpIntType(node);
    }

    @Override
    public void visitArrayExpr(ArrayExpr node) {
        for (Expr e: node.arrayElements) {

        }
    }

}
