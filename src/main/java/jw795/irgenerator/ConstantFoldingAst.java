package jw795.irgenerator;

import jw795.ast.*;
import jw795.typechecker.Int;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class ConstantFoldingAst {
    Program node;

    ConstantFoldingAst(Program node){
        this.node = node;
    }

    public Program fold(){
        List<Definition> result = new LinkedList<>();
        for(Definition d : node.definitions){
            result.add(foldDefinition(d));
        }
        return new Program(node.uses,result,node.getLine(), node.getCol());
    }

    public Definition foldDefinition(Definition def){
        if (def instanceof FunctionDefine){
            return new FunctionDefine(((FunctionDefine) def).name,
                    ((FunctionDefine) def).returnTypes,
                    ((FunctionDefine) def).arguments,
                    (BlockStmt) foldStmt(((FunctionDefine) def).functionBody),
                    node.getLine(), node.getCol()
            );
        }
        return def;
    }

    public Statement foldStmt(Statement node){
        if(node instanceof AssignStmt){
            return new AssignStmt(((AssignStmt) node).leftVal,
                    foldExpr(((AssignStmt) node).expr),
                    node.getLine(), node.getCol());
        }else if(node instanceof IfStmt){
            Expr e = foldExpr(((IfStmt) node).condition);
            if (e instanceof BoolLiteral){
                if (((BoolLiteral) e).value == true){
                    return foldStmt(((IfStmt) node).clause);
                }else{
                    return new BlockStmt(new LinkedList<>(),node.getLine(),node.getCol() );
                }
            }
            return new IfStmt(e,
                    foldStmt(((IfStmt) node).clause),
                    node.getLine(), node.getCol()
            );
        }else if(node instanceof IfElseStmt){
            Expr e = foldExpr(((IfElseStmt) node).condition);
            if (e instanceof BoolLiteral){
                if (((BoolLiteral) e).value == true){
                    return foldStmt(((IfElseStmt) node).ifClause);
                }else{
                    return foldStmt(((IfElseStmt) node).elseClause);
                }
            }
            return new IfElseStmt(e,
                    foldStmt(((IfElseStmt) node).ifClause),
                    foldStmt(((IfElseStmt) node).elseClause),
                    node.getLine(), node.getCol()
            );
        }else if(node instanceof WhileStmt){
            Expr e = foldExpr(((WhileStmt) node).condition);
            if (e instanceof BoolLiteral){
                if(((BoolLiteral) e).value == false){
                    return new BlockStmt(new LinkedList<>(),node.getLine(),node.getCol() );
                }
            }
            return new WhileStmt(e, foldStmt(((WhileStmt) node).loopBody), node.getLine(), node.getCol());
        }else if(node instanceof ReturnStmt){
            List<Expr> retvals = new LinkedList<>();
            for(Expr e: ((ReturnStmt) node).returnVals){
                retvals.add(foldExpr(e));
            }
            return new ReturnStmt(retvals, node.getLine(), node.getCol());
        }else if(node instanceof ProcCallStmt){
            List<Expr> retvals = new LinkedList<>();
            for(Expr e: ((ProcCallStmt) node).arguments){
                retvals.add(foldExpr(e));
            }
            return new ProcCallStmt(((ProcCallStmt) node).name,
                        retvals,node.getLine(), node.getCol()
                    );
        }else if(node instanceof BlockStmt){
            List<Statement> retvals = new LinkedList<>();
            for(Statement s: ((BlockStmt) node).statements){
                retvals.add(foldStmt(s));
            }
            return new BlockStmt(retvals, node.getLine(), node.getCol()
            );
        }
        System.out.println("Unhandle statement type in constant fold ast");
        return node;
    }

    public Expr foldExpr(Expr node){
        if(node instanceof BinOpExpr){
            return foldBinop((BinOpExpr) node);
        }else if(node instanceof BoolLiteral){
            return node;
        }else if(node instanceof IntLiteral){
            return node;
        }else if(node instanceof CharLiteral){
            int i = ((CharLiteral) node).value;
            BigInteger val =  new BigInteger(String.valueOf(i));
            return new IntLiteral( val, node.getLine(), node.getCol());
        }
        else if(node instanceof StringLit){
            return node;
        }else if(node instanceof FunCallExpr){
            List<Expr> lst = new LinkedList<>();
            for(Expr e: ((FunCallExpr) node).arguments){
                lst.add(foldExpr(e));
            }
            return new FunCallExpr(((FunCallExpr) node).name,lst, node.getLine(), node.getCol());
        }else if(node instanceof ArrayExpr){
            return node;
        }else if(node instanceof ArrIndexExpr){
            return node;
        }else if(node instanceof IntNeg){
            if(((IntNeg) node).expr instanceof IntLiteral){
                int val = -((IntLiteral) ((IntNeg) node).expr).value.intValue();
                return new IntLiteral(new BigInteger(String.valueOf(val)), node.getLine(), node.getCol());
            }
        }else if(node instanceof Not){
            if(((Not) node).expr instanceof BoolLiteral){
                return new BoolLiteral(!((BoolLiteral) ((Not) node).expr).value, node.getLine(),node.getCol());
            }
        }
        return node;
    }

    public Expr foldBinop(BinOpExpr node){
        Expr val1 =  foldExpr(node.expr1);
        Expr val2 = foldExpr(node.expr2);
        if(val1 instanceof IntLiteral){
            if(val2 instanceof IntLiteral) {
                if (node instanceof Add) {
                    BigInteger val = ((IntLiteral) val1).value.add(((IntLiteral) val2).value);
                    return new IntLiteral(val, node.getLine(), node.getCol());
                }if (node instanceof Sub) {
                    BigInteger val = ((IntLiteral) val1).value.subtract(((IntLiteral) val2).value);
                    return new IntLiteral(val, node.getLine(), node.getCol());
                }if (node instanceof Mult) {
                    BigInteger val = ((IntLiteral) val1).value.multiply(((IntLiteral) val2).value);
                    return new IntLiteral(val, node.getLine(), node.getCol());
                }if (node instanceof Div) {
                    BigInteger val = ((IntLiteral) val1).value.divide(((IntLiteral) val2).value);
                    return new IntLiteral(val, node.getLine(), node.getCol());
                }if (node instanceof HighMult) {
                    BigInteger val = ((IntLiteral) val1).value.pow(((IntLiteral) val2).value.intValue());
                    return new IntLiteral(val, node.getLine(), node.getCol());
                }if (node instanceof Mod) {
                    BigInteger val = ((IntLiteral) val1).value.mod(((IntLiteral) val2).value);
                    return new IntLiteral(val, node.getLine(), node.getCol());
                }
            }else if(((IntLiteral) val1).value.intValue() == 1){
                if(node instanceof Mult) {
                    return val2;
                }
            }else if(((IntLiteral) val1).value.intValue() == 0){
                if(node instanceof Add) {
                    return val2;
                }else if(node instanceof Mult) {
                    return val1;
                }else if(node instanceof Div) {
                    return val1;
                }else if(node instanceof Mod) {
                    return val1;
                }else if(node instanceof HighMult) {
                    return val1;
                }
            }
        }else if(val2 instanceof IntLiteral){
            if (((IntLiteral) val2).value.intValue() == 0){
                if(node instanceof Add){
                    return val1;
                }else if(node instanceof Sub){
                    return val1;
                }else if(node instanceof Mult) {
                    return val2;
                }else if(node instanceof HighMult) {
                    return val2;
                }
            }else if (((IntLiteral) val2).value.intValue() == 1){
                if(node instanceof Mult) {
                    return val1;
                }else if(node instanceof Div) {
                    return val1;
                }else if(node instanceof Mod) {
                    return val1;
                }
            }

        }else if(val1 instanceof BoolLiteral){
            if(val2 instanceof BoolLiteral){
                boolean b1 = ((BoolLiteral) val1).value;
                boolean b2 = ((BoolLiteral) val2).value;
                if(node instanceof And){
                    return new BoolLiteral(b1&b2, node.getLine(), node.getCol());
                }else if(node instanceof Or){
                    return new BoolLiteral(b1|b2, node.getLine(), node.getCol());
                }
            }else{
                if(((BoolLiteral) val1).value == true){
                    if(node instanceof And){
                        return val2;
                    }else if(node instanceof Or){
                        return val1;
                    }
                }else{
                    if(node instanceof And){
                        return val1;
                    }else if(node instanceof Or){
                        return val2;
                    }
                }
            }
        }else if(val2 instanceof BoolLiteral){
            if(((BoolLiteral) val2).value == true){
                if(node instanceof And){
                    return val1;
                }else if(node instanceof Or){
                    return val2;
                }}
            else{
                if(node instanceof And){
                    return val2;
                }else if(node instanceof Or){
                    return val1;
                }
            }
        }
        return node;
    }


}
