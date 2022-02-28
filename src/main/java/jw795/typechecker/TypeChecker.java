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
        //TODO: this method needs to type check the following: f(), f(e), length(e), and f(e1, ..., en)
        //TODO: one way to do this is to write *private* helper function similar to visitLength below for each of
        // f(), f(e), length(e), and f(e1, ..., en) and call them in this function
        if (node.name.equals("length")) {
            checkLength(node);
        }
    }

    /** Type check the function call of length(e) function */
    private void checkLength(FunCallExpr node){
        if((node.arguments.size() == 1)) {
            Expr argu =node.arguments.get(0);
            if(argu instanceof VarExpr){
                if(this.env.findType(((VarExpr) argu).identifier) instanceof TypedArray){
                    node.type = new Int();
                }
            }
        }
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

    /** helper to check the type of the subexpressions of algebraic and comparison binop */
    private void setBinOpIntType(BinOpExpr node) {
        if ((node.expr1.type instanceof Int) && (node.expr2.type instanceof Int)) {
            node.type = new Int();
        }
    }

    /** helper to check the type of the subexpressions of logical binop */
    private void setBinOpBoolType(BinOpExpr node) {
        if ((node.expr1.type instanceof Bool) && (node.expr2.type instanceof Bool)) {
            node.type = new Bool();
        }
    }
    private void setArrayBoolType(BinOpExpr node){
        if(node.expr1.type instanceof  Tau){
            if(node.expr2.type instanceof  Tau) {
                if (((Tau) node.expr1.type).equals(node.expr2.type)) {
                    node.type = new Bool();
                }
            }
        }
    }

    @Override
    public void visitAdd(Add node) {
        setBinOpIntType(node);
        setArrayBoolType(node);
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
        setArrayBoolType(node);

    }

    @Override
    public void visitNotEqual(NotEqual node) {
        setBinOpIntType(node);
        setBinOpBoolType(node);
        setArrayBoolType(node);
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
            T t = node.arrayElements.get(0).type;
            boolean validArray = true;
            for (Expr e: node.arrayElements) {
                T et = e.type;
                if (!(et instanceof Tau)) {
                    validArray = false;
                    break;
                } else if (((Tau) et).equals((Tau) t)) {
                    if (et instanceof Array) {
                        if (((Array)t).compare((Array)et)) {
                            t = et;
                        }
                    }
                } else {
                    validArray = false;
                    break;
                }
            }
            if (validArray) {
                node.type = new TypedArray((Tau)t);
            }
        }
    }

    @Override
    public void visitArrIndexExpr(ArrIndexExpr node) {
        if (node.array.type instanceof TypedArray && node.index.type instanceof Int) {
            node.type = ((TypedArray) node.array.type).elementType;
        } else if (node.array.type instanceof EmptyArray && node.index.type instanceof Int) {
            node.type = new Unit();
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
        XiType prType = this.env.findType(node.name);
        if(prType instanceof Fn && ((Fn) prType).outputType instanceof Unit){
            node.type = new Unit();
        }
    }

    @Override
    public void visitRet(ReturnStmt node) {
        boolean isvalid =true;
        XiType retarg = this.env.findType("return");
        if(retarg instanceof  Prod){
            if (((Prod) retarg).elementTypes.size() == node.returnVals.size() ){
                for (int i =0; i < node.returnVals.size(); i++){
                    if(! ((Prod) retarg).elementTypes.get(i).equals(node.returnVals.get(i))){
                        isvalid = false;
                    }
                }
            }
        }
        if(isvalid){
            node.type = new Void();
        }
    }

    @Override
    public void visitAssign(AssignStmt node) {
        // TODO:
        //  x = e,
        //  e1[e2] = e2,
        //  x:tau = e,
        //  _ = e
        //  d1...dn = e

    }

    @Override
    public void visitVarDecl(VarDeclareStmt node) {
        // TODO: x:tau, x:tau[]
    }

    /** Type check _ = e */
    private void checkExprStmt() {

    }


}
