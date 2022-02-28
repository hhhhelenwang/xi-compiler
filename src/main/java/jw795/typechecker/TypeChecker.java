package jw795.typechecker;

import jw795.ast.*;

import java.util.List;

public class TypeChecker extends Visitor{

    SymbolTable env;

    // Visit functions for Expressions =================================
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
        if (node.type instanceof TypedArray && ((TypedArray) node.type).elementType instanceof Int ) {
            node.type = new TypedArray(new Int()); //TODO: should be int[]
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
            node.type = (T) env.findType(node.identifier);
        }
    }

    @Override
    public void visitIntNeg(IntNeg node) {
        if (node.expr.type instanceof Int) {
            node.type = new Int();
        }
    }

    // helper to check the type of the subexpressions of algebraic and comparison binop
    private void setBinOpIntType(BinOpExpr node) {
        if ((node.expr1.type instanceof Int) && (node.expr2.type instanceof Int)) {
            node.type = new Int();
        }
    }

    // helper to check the type of the subexpressions of logical binop
    private void setBinOpBoolType(BinOpExpr node) {
        if ((node.expr1.type instanceof Bool) && (node.expr2.type instanceof Bool)) {
            node.type = new Bool();
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
    public void visitAnd(And node){setBinOpBoolType(node);}

    @Override
    public void visitOr(Or node){setBinOpBoolType(node);}

    @Override
    public void visitEqual(Equal node) {
        setBinOpIntType(node);
        setBinOpBoolType(node);
    }

    @Override
    public void visitNotEqual(NotEqual node) {
        setBinOpIntType(node);
        setBinOpBoolType(node);
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
        if (node.arrayElements.isEmpty()) {
            node.type = new EmptyArray();
        } else {
            XiType t;
            for (Expr e: node.arrayElements) {
                
            }
        }
    }

    @Override
    public void visitLength(FunCallExpr node){
        if(node.name.equals("length") ){
            if((node.arguments.size() == 1)) {
                Expr argu =node.arguments.get(0);
                if(argu instanceof VarExpr){
                    if(this.env.findType(((VarExpr) argu).identifier) instanceof TypedArray){
                        node.type = new Int();
                    }
                }

            }
        }
    }

    @Override
    public void visitNot(Not node){
        if(node.expr.type instanceof Bool){
            node.type = new Bool();
        }
    }

    // Visit functions for Statements =================================
    @Override
    public void visitPrCall(ProcCallStmt node) {
        // check if f exist, and if f evaluate to unit
        boolean valid = false;
        XiType arglst = this.env.findType(node.name);
        if(arglst instanceof Prod) {
            valid = true;
            List<Expr> l1 = node.arguments;
            List<Tau> l2 = ((Prod) arglst).elementTypes;

            if(l1.size() == l2.size()){
                for(int i =0; i<l1.size(); i++){
                    if(! l2.get(i).equals(l1.get(i).type)){
                        valid = false;
                    }
                }
            }
        }
        if(valid){
            node.type = new Unit();
        }
    }

    @Override
    public void visitRet(ReturnStmt node) {
        boolean isvalid =true;
        for (Expr e: node.returnVals){

        }
    }


}
