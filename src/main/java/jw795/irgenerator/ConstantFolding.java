package jw795.irgenerator;

import edu.cornell.cs.cs4120.xic.ir.*;

import java.util.*;

public class ConstantFolding {
    IRCompUnit original;
    IRNodeFactory_c irFactory;

    ConstantFolding(IRCompUnit node){
        this.original = node;
        this.irFactory = new IRNodeFactory_c();
    }

    IRCompUnit foldComp(IRCompUnit node){
        Map<String, IRFuncDecl> functions = node.functions();
        Map<String, IRFuncDecl> foldedFunctions = new HashMap<>();

        for (Map.Entry<String, IRFuncDecl> entry : functions.entrySet()) {
            IRFuncDecl function = entry.getValue();
            IRStmt lowerdBody = foldStmt(function.body());
            IRFuncDecl loweredFunction = irFactory.IRFuncDecl(function.name(), lowerdBody);
            foldedFunctions.put(entry.getKey(), loweredFunction);
        }

        return null;
    }

    public IRStmt foldStmt(IRStmt node){
//        if (node instanceof IRSeq) {
//            return foldSeq((IRSeq) node);
//        } else if (node instanceof IRExp) {
//            return foldExp((IRExp) node);
//        } else if (node instanceof IRJump) {
//            return foldJump((IRJump) node);
//        } else if (node instanceof IRCJump) {
//            return foldCJump((IRCJump) node);
//        } else if (node instanceof IRLabel) {
//            return foldLabel((IRLabel) node);
//        } else if (node instanceof IRMove) {
//            return foldMove((IRMove) node);
//        } else if (node instanceof IRReturn) {
//            return foldReturn((IRReturn) node);
//        } else if (node instanceof IRCallStmt) {
//            return foldCallStmt((IRCallStmt) node);
//        }
        return null;
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
//            return foldCall((IRCall) node);
//        } else if (node instanceof IRMem) {
//            return foldMem((IRMem) node);
//        } else if (node instanceof IRESeq) {
//            return foldESeq((IRESeq) node);
        } else {
            return null;
        }
        return  null;
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
                return irFactory.IRConst(fleft * fright);
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
                return irFactory.IRConst((long) (fleft * Math.pow(2, fright)));
            case RSHIFT:
                return irFactory.IRConst((long) (fleft / Math.pow(2, fright)));
            case ARSHIFT:
                return irFactory.IRConst((long) (fleft / Math.pow(2, fright)));
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
                //TODO: what is ULT
                return null;
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
        return null;
    }
    public IRExpr foldoneconst (long cons, IRExpr node, IRBinOp.OpType type) {

        switch (type) {
            case ADD:
                if(cons == 0){
                    return node;
                }
            case SUB:
                if(cons == 0){
                    return node;
                }
            case MUL:
                if(cons == 0){

                }else if(cons == 1){

                }

            case HMUL:

            case DIV:

            case MOD:

            case AND:

            case OR:

            case XOR:

            case LSHIFT:

            case RSHIFT:

            case ARSHIFT:

            case EQ:

            case NEQ:

            case LT:

            case ULT:
                //TODO: what is ULT
                return null;
            case GT:

            case LEQ:

            case GEQ:

        }
        return null;
    }

}



