package jw795.irgenerator;

import edu.cornell.cs.cs4120.xic.ir.*;

import java.math.BigInteger;
import java.util.*;

public class ConstantFolding {
    IRCompUnit original;
    IRNodeFactory_c irFactory;

    ConstantFolding(IRCompUnit node){
        this.original = node;
        this.irFactory = new IRNodeFactory_c();
    }

    public IRCompUnit foldComp(){
        Map<String, IRFuncDecl> functions = this.original.functions();
        Map<String, IRFuncDecl> foldedFunctions = new HashMap<>();

        for (Map.Entry<String, IRFuncDecl> entry : functions.entrySet()) {
            IRFuncDecl function = entry.getValue();
            IRStmt lowerdBody = foldStmt(function.body());
            IRFuncDecl loweredFunction = irFactory.IRFuncDecl(function.name(), lowerdBody);
            foldedFunctions.put(entry.getKey(), loweredFunction);
        }
        IRCompUnit result =  new IRCompUnit(original.name(),foldedFunctions,
                                            original.ctors(),original.dataMap());

        return result;
    }

    public IRStmt foldStmt(IRStmt node){
        if (node instanceof IRSeq) {
            return foldSeq((IRSeq) node);
        } else if (node instanceof IRExp) {
            return irFactory.IRExp(foldExpr(((IRExp) node).expr()));
        } else if (node instanceof IRCJump) {
            return foldCJump((IRCJump) node);
        } else if (node instanceof IRLabel) {
            return node;
        } else if (node instanceof IRMove) {
            return irFactory.IRMove(foldExpr(((IRMove) node).target()), foldExpr(((IRMove) node).source()));
        } else if (node instanceof IRReturn) {
            return foldReturn((IRReturn) node);
        } else if (node instanceof IRCallStmt) {
            return foldCallStmt((IRCallStmt) node);
        }else if (node instanceof IRJump) {
            return node;
        }
        System.out.print("sth is left in constantfold ir");
        return node;
    }

    public IRStmt foldSeq(IRSeq node){
        LinkedList<IRStmt> lst = new LinkedList<>();
        for (IRStmt s: node.stmts()){
            lst.add(foldStmt(s));
        }
        return irFactory.IRSeq(lst);
    }
    public IRStmt foldReturn(IRReturn node){
        LinkedList<IRExpr> lst = new LinkedList<>();
        for (IRExpr e: node.rets()){
            lst.add(foldExpr(e));
        }
        return irFactory.IRReturn(lst);
    }
    public IRStmt foldCallStmt(IRCallStmt node){
        LinkedList<IRExpr> lst = new LinkedList<>();
        for (IRExpr e: node.args()){
            lst.add(foldExpr(e));
        }
        return irFactory.IRCallStmt(node.target(),node.n_returns(),lst);
    }

    public IRStmt foldCJump(IRCJump node){
        IRExpr e = foldExpr(node.cond());
        if(e instanceof IRConst){
            if ( ((IRConst) e).value() == 0){
                return irFactory.IRJump(irFactory.IRName(node.falseLabel()));
            }else{
                return irFactory.IRJump(irFactory.IRName(node.trueLabel()));
            }
        }
        return node;
    }


    public IRExpr foldExpr(IRExpr node){
        // match the node against all IR expressions
        if (node instanceof IRConst) {
            return node;
        } else if (node instanceof IRName) {
            return node;
        } else if (node instanceof IRTemp) {
            return node;
        }
        // other expressions
        else if (node instanceof IRBinOp) {
            return foldBiNop((IRBinOp) node);
        } else if (node instanceof IRCall) {
            List<IRExpr> lst = new LinkedList<>();
            for(IRExpr e : ((IRCall) node).args()) {
                lst.add(foldExpr(e));
            }
            return irFactory.IRCall(((IRCall) node).target(),lst);
        } else if (node instanceof IRMem) {
            return node;
        } else if (node instanceof IRESeq) {
            System.out.println("we should not see eseq at IR lower right?");
        }
        return  node;
    }

    public IRExpr foldBiNop(IRBinOp node) {
        IRExpr foldedleft = foldExpr(node.left());
        IRExpr foldedright = foldExpr(node.right());
        if(foldedleft instanceof IRConst && foldedright instanceof  IRConst){
            long fleft = ((IRConst) foldExpr(node.left())).value();
            long fright = ((IRConst) foldExpr(node.right())).value();
            IRExpr result = foldtwoconst(fleft, fright,node.opType());
            if(result == null){
                return node;
            }
            return result;
        }
        else if(foldedleft instanceof IRConst){
            long cons =  ((IRConst) foldedleft).value();
            IRExpr result = foldoneconst(cons, foldedright, node.opType());
            if(result == null){
                return node;
            }
            return result;
        }
        else if(foldedright instanceof IRConst){
            long cons =  ((IRConst) foldedright).value();
            IRExpr result = foldoneconst(cons, foldedleft, node.opType());
            if(result == null){
                return node;
            }
            return result;
        }

        return node;
    }

    public IRExpr foldtwoconst (long fleft, long fright, IRBinOp.OpType type) {
        switch (type) {
            case ADD:
                return irFactory.IRConst(fleft + fright);
            case SUB:
                return irFactory.IRConst(fleft - fright);
            case MUL:
                return irFactory.IRConst(fleft * fright);
            case HMUL:
                BigInteger v1 = new BigInteger(String.valueOf(fleft));
                BigInteger v2 = new BigInteger(String.valueOf(fright));
                BigInteger v64 = new BigInteger(String.valueOf(2^64));
                BigInteger val = v1.multiply(v2);
                val  = val.subtract(val.mod(v64));
                val =val.divide(v64);
                return irFactory.IRConst(val.longValue());
            case DIV:
                return irFactory.IRConst(fleft / fright);
            case MOD:
                return irFactory.IRConst(fleft % fright);
            case AND:
                return irFactory.IRConst(fleft & fright);
            case OR:
                return irFactory.IRConst(fleft | fright);
            case XOR:
                long value = ((-(fleft - 1)) & fright) | ((-(fright - 1)) & fleft);
                return irFactory.IRConst(value);
            case LSHIFT:
                return irFactory.IRConst(fleft << fright);
            case RSHIFT:
                return irFactory.IRConst(fleft >>> fright);
            case ARSHIFT:
                return irFactory.IRConst(fleft >> fright);
            case EQ:
                if (fleft == fright) {
                    return irFactory.IRConst(1);
                } else {
                    return irFactory.IRConst(0);
                }
            case NEQ:
                if (fleft == fright) {
                    return irFactory.IRConst(0);
                } else {
                    return irFactory.IRConst(1);
                }
            case LT:
                if (fleft < fright) {
                    return irFactory.IRConst(1);
                } else {
                    return irFactory.IRConst(0);
                }
            case ULT:
                return irFactory.IRConst(fleft < fright ^ fleft < 0 != fright < 0 ? 1 : 0);
            case GT:
                if (fleft > fright) {
                    return irFactory.IRConst(1);
                } else {
                    return irFactory.IRConst(0);
                }
            case LEQ:
                if (fleft <= fright) {
                    return irFactory.IRConst(1);
                } else {
                    return irFactory.IRConst(0);
                }
            case GEQ:
                if (fleft >= fright) {
                    return irFactory.IRConst(1);
                } else {
                    return irFactory.IRConst(0);
                }
        }
        return null;//should not reach here
    }
    public IRExpr foldoneconst (long cons, IRExpr expr, IRBinOp.OpType type) {
        switch (type) {
            case ADD:
                if(cons == 0){
                    return expr;
                }
            case SUB:
                if(cons == 0){
                    return expr;
                }
            case MUL:
                if(cons == 0){
                    return irFactory.IRConst(0);
                }else if(cons == 1){
                    return expr;
                }
            case AND:
                if(cons == 0){
                    return irFactory.IRConst(0);
                }else{
                    return expr;
                }
            case OR:
                if(cons == 1){
                    return irFactory.IRConst(1);
                }else{
                    return expr;
                }
        }
        return null;
    }

}



