package jw795.irgenerator;

import jw795.ast.*;
import jw795.typechecker.Int;

import java.math.BigInteger;

public class ConstantFoldingAst {
    Program node;

    ConstantFoldingAst(Program node){
        this.node = node;
    }

    public Expr foldExpr(Expr node){
        if(node instanceof BinOpExpr){
            return foldBinop((BinOpExpr) node);
        }else if(node instanceof BoolLiteral){
//            BigInteger val =  new BigInteger(String.valueOf(1));
//            if(((BoolLiteral) node).value){
//                return new IntLiteral( val, node.getLine(), node.getCol());
//            }
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
            return node;
        }else if(node instanceof ArrayExpr){
            return node;
        }else if(node instanceof ArrIndexExpr){
            return node;
        }else if(node instanceof ArrayExpr){
            return node;
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
                    return new IntLiteral(new BigInteger(String.valueOf(0)),node.getLine(),node.getCol());
                }else if(node instanceof Div) {
                    return new IntLiteral(new BigInteger(String.valueOf(0)),node.getLine(),node.getCol());
                }else if(node instanceof Mod) {
                    return new IntLiteral(new BigInteger(String.valueOf(0)),node.getLine(),node.getCol());
                }else if(node instanceof HighMult) {
                    return new IntLiteral(new BigInteger(String.valueOf(0)),node.getLine(),node.getCol());
                }
            }
        }else if(val2 instanceof IntLiteral){
            if (((IntLiteral) val2).value.intValue() == 0){
                if(node instanceof Add){
                    return val1;
                }else if(node instanceof Sub){
                    return val1;
                }else if(node instanceof Mult) {
                    return new IntLiteral(new BigInteger(String.valueOf(0)),node.getLine(),node.getCol());
                }else if(node instanceof HighMult) {
                    return new IntLiteral(new BigInteger(String.valueOf(0)),node.getLine(),node.getCol());
                }
            }else if (((IntLiteral) val2).value.intValue() == 1){
                if(node instanceof Mult) {
                    return val1;
                }
            }

        }
        return node;
    }


}
