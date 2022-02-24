package jw795.typechecker;

import jw795.ast.*;

import java.util.List;

public class TypeChecker extends Visitor{

    @Override
    public void visitAdd(Add node) {
        if ((node.expr1.type instanceof Int) && (node.expr2.type instanceof Int)) {
            node.type = new Int();
        }
    }

    @Override
    public void visitArrayExpr(ArrayExpr node) {
        for (Expr e: node.arrayElements) {

        }
    }

    @Override
    public void visitIntType(IntType node) {
        if (node.type instanceof Int){
            node.type = new Int();
        }
    }

    @Override
    public void visitBoolType(BoolType node) {
        if (node.type instanceof Bool){
            node.type = new Bool();
        }
    }

    @Override
    public void visitStringLit(StringLit node) {
        if (node.type instanceof Array && ((Array) node.type).elementType instanceof Int ) {
            node.type = new Str(); //new Array(new Int())?
        }
    }

    @Override
    public void visitCharLiteral(CharLiteral node) {
        if (node.type instanceof Int ) {
            node.type = new Char(); //new Int()?
        }
    }

    @Override
    public void visitFunCallExpr(FunCallExpr node) {
        //evaluates to new context, new conext != unit
    }
}
