package jw795.irgenerator;

import jw795.ast.*;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/**
 * Perform constant folding at AST level
 */
public class ConstantFoldingAst {
    Program node;

    /**
     * Class to constant fold an AST program node
     * @param node an ast program
     */
    ConstantFoldingAst(Program node){
        this.node = node;
    }

    /**
     * Function to fold AST node
     * @return a folded program node
     */
    public Program fold(){
        List<Definition> result = new LinkedList<>();
        for(Definition d : node.definitions){
            result.add(foldDefinition(d));
        }
        return new Program(node.uses,result,node.getLine(), node.getCol());
    }

    /**
     * Constant fold a global definition which includes function and procedure definition
     * @param def a global definition
     * @return a folded defintion
     */
    public Definition foldDefinition(Definition def){
        if (def instanceof FunctionDefine){
            return new FunctionDefine(((FunctionDefine) def).name,
                    ((FunctionDefine) def).returnTypes,
                    ((FunctionDefine) def).arguments,
                    (BlockStmt) foldStmt(((FunctionDefine) def).functionBody),
                    node.getLine(), node.getCol()
            );
        }else if(def instanceof ProcedureDefine){
            return new ProcedureDefine(((ProcedureDefine) def).name,
                    ((ProcedureDefine) def).arguments,
                    (BlockStmt) foldStmt(((ProcedureDefine) def).procBody),
                    node.getLine(), node.getCol()
            );
        }
        return def;
    }


    /**
     * Helper function to fold all statement node
     * @param node an AST stmt node
     * @return folded statement
     */
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
        }else if(node instanceof VarDeclareStmt){
            return node;
        } else if(node instanceof BlockStmt){
            List<Statement> retvals = new LinkedList<>();
            for(Statement s: ((BlockStmt) node).statements){
                Statement s1 = foldStmt(s);
                s1.type = s.type;
                retvals.add(s1);
            }
            return new BlockStmt(retvals, node.getLine(), node.getCol()
            );
        }
        return node;
    }


    /**
     * Helper function to fold all Expr node
     * @param node an expression node
     * @return folded expr
     */
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
            IntLiteral result =new IntLiteral( val, node.getLine(), node.getCol());
            result.type = node.type;
            return result;
        }
        else if(node instanceof StringLit){
            return node;
        }else if(node instanceof FunCallExpr){
            List<Expr> lst = new LinkedList<>();
            for(Expr e: ((FunCallExpr) node).arguments){
                lst.add(foldExpr(e));
            }
            FunCallExpr result = new FunCallExpr(((FunCallExpr) node).name,lst, node.getLine(), node.getCol());
            result.type = node.type;
            return result;
        }else if(node instanceof ArrayExpr){
            return node;
        }else if(node instanceof ArrIndexExpr){
            ArrIndexExpr result = new ArrIndexExpr(((ArrIndexExpr) node).array,
                    foldExpr(((ArrIndexExpr) node).index),
                    node.getLine(),node.getCol());
            result.type = node.type;
            return result;
        }else if(node instanceof IntNeg){
            if(((IntNeg) node).expr instanceof IntLiteral){
                int val = -((IntLiteral) ((IntNeg) node).expr).value.intValue();
                IntLiteral result = new IntLiteral(new BigInteger(String.valueOf(val)),
                        node.getLine(), node.getCol());
                result.type = node.type;
                return result;
            }
        }else if(node instanceof Not){
            if(((Not) node).expr instanceof BoolLiteral){
                BoolLiteral result = new BoolLiteral(!((BoolLiteral) ((Not) node).expr).value,
                        node.getLine(),node.getCol());
                result.type =node.type;
                return result;
            }
        }
        return node;
    }

    /**
     * Helper function to fold binop
     * @param node an AST Binop expression
     * @return a folded binop expression
     */
    public Expr foldBinop(BinOpExpr node){
        Expr val1 =  foldExpr(node.expr1);
        Expr val2 = foldExpr(node.expr2);
        if(val1 instanceof IntLiteral){
            if(val2 instanceof IntLiteral) {
                BigInteger val;
                Expr result = null;
                if (node instanceof Add) {
                     val = ((IntLiteral) val1).value.add(((IntLiteral) val2).value);
                    result =  new IntLiteral(val, node.getLine(), node.getCol());
                }else if (node instanceof Sub) {
                     val = ((IntLiteral) val1).value.subtract(((IntLiteral) val2).value);
                    result = new IntLiteral(val, node.getLine(), node.getCol());
                }else if (node instanceof Mult) {
                    val = ((IntLiteral) val1).value.multiply(((IntLiteral) val2).value);
                    result = new IntLiteral(val, node.getLine(), node.getCol());
                }else if (node instanceof Div) {
                    val = ((IntLiteral) val1).value.divide(((IntLiteral) val2).value);
                    result = new IntLiteral(val, node.getLine(), node.getCol());
                }else if (node instanceof HighMult) {
                    val = ((IntLiteral) val1).value.multiply(((IntLiteral) val2).value);
                    BigInteger valresult = val.subtract(val.mod(BigInteger.valueOf(2).pow(64)));
                    valresult = valresult.divide(BigInteger.valueOf(2).pow(64));
                    result = new IntLiteral(valresult, node.getLine(), node.getCol());
                }else if (node instanceof Mod) {
                    val = ((IntLiteral) val1).value.mod(((IntLiteral) val2).value);
                    result = new IntLiteral(val, node.getLine(), node.getCol());
                }else if (node instanceof Equal){
                    result = new BoolLiteral (((IntLiteral) val1).value.equals(((IntLiteral) val2).value),
                                node.getLine(),node.getCol());
                }else if (node instanceof GreaterThan){
                    result = new BoolLiteral (
                            ((IntLiteral) val1).value.longValue() > ((IntLiteral) val2).value.longValue(),
                            node.getLine(),node.getCol());
                }else if (node instanceof GreaterEq){
                    result = new BoolLiteral (
                            ((IntLiteral) val1).value.longValue() >= ((IntLiteral) val2).value.longValue(),
                            node.getLine(),node.getCol());
                }else if (node instanceof LessThan){
                    result = new BoolLiteral (
                            ((IntLiteral) val1).value.longValue() < ((IntLiteral) val2).value.longValue(),
                            node.getLine(),node.getCol());
                }else if (node instanceof LessEq){
                    result = new BoolLiteral (
                            ((IntLiteral) val1).value.longValue() <= ((IntLiteral) val2).value.longValue(),
                            node.getLine(),node.getCol());
                }
                if(result ==null){
                    return node;
                }else{
                    result.type = node.type;
                    return result;
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
                    BoolLiteral result = new BoolLiteral(b1&b2, node.getLine(), node.getCol());
                    result.type = node.type;
                    return result;
                }else if(node instanceof Or){
                    BoolLiteral result =new BoolLiteral(b1|b2, node.getLine(), node.getCol());
                    result.type = node.type;
                    return result;
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
