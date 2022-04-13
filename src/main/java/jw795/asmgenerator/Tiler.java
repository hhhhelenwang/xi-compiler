package jw795.asmgenerator;

import edu.cornell.cs.cs4120.xic.ir.*;
import edu.cornell.cs.cs4120.xic.ir.visit.IRVisitor;
import jw795.assembly.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A visitor that traverse an IR tree and translate IR into tiles of abstract assembly.
 */
public class Tiler extends IRVisitor {
    public TempSpiller tempSpiller;

    public Tiler(IRNodeFactory inf, TempSpiller tsp) {
        super(inf);
        tempSpiller = tsp;

    }

    /**
     * Translate an IR node into a tile of abstract assembly instructions.
     * @param parent The parent AST node of {@code n} or {@code null} when it is the root.
     * @param n The original node in the input AST
     * @param n2 The node returned by {@link IRNode#visitChildren(IRVisitor)}, which should
     *    look like n except that the children have been visited.
     * @param v2 The new node visitor created by {@link #enter(IRNode, IRNode)}, or {@code this}.
     * @return this node but visited
     */
    @Override
    protected IRNode leave(IRNode parent, IRNode n, IRNode n2, IRVisitor v2) {
        // TODO: translate IR node to tile for each kinds of IR node:
        //  (lower IR only)
        //  stmt: move, call_m, jump, cjump, label, return, seq
        //  expr: const, temp, mem, name, binop

        //  can have helper functions for each nodes if this methods gets too big

        if (n2 instanceof IRCompUnit) {
            // whatever need to be done for CompUnit
        } else if (n2 instanceof IRFuncDecl) {

        } else if (n2 instanceof IRSeq){
            // do nothing
        } else if (n2 instanceof IRMove) {
            return tileMove((IRMove) n2);
        } else if (n2 instanceof IRCallStmt) {

        } else if (n2 instanceof IRJump) {

        } else if (n2 instanceof IRCJump) {

        } else if (n2 instanceof IRLabel) {

        } else if (n2 instanceof IRReturn) {

        }
        // expressions
        else if (n2 instanceof IRConst) {

        } else if (n2 instanceof IRTemp) {

        } else if (n2 instanceof IRMem) {

        } else if (n2 instanceof IRName) {

        } else if (n2 instanceof IRBinOp) {
            return tileBinop((IRBinOp) n2);

        } else {
            System.out.println("IR is not lowered.");
            return null;
        }
        return null;
    }

    /**
     * Tile a move IR instruction
     * @param node a move IR node
     * @return a move IR node labeled with its tile of assembly
     */
    private IRNode tileMove(IRMove node) {
        if (node.source() instanceof IRBinOp && node.target().equals(node.source())) {
            List<IRNode> neighbors = new ArrayList<>();
            neighbors.add(node.source());
            node.optTile = new Tile(new ArrayList<>(), neighbors);
        } else {
            AAOperand operand1;
            AAOperand operand2;
            operand1 = node.target().getTile().returnTemp;
            operand2 = node.source().getTile().returnTemp;
            AAMove m = new AAMove(operand1, operand2);

            ArrayList<AAInstruction> asm = new ArrayList<>();
            asm.add(m);

            List<IRNode> neighbors = new ArrayList<>();
            neighbors.add(node.target());
            neighbors.add(node.source());
            Tile t = new Tile (asm, neighbors);
            node.optTile = t;
        }
        return node;
    }

    /**
     * Tile a binop IR instruction
     * @param node a binop IR node
     * @return a binop IR node labeled with its tile of assembly
     */
    private IRNode tileBinop(IRBinOp node) {
        AAOperand operand1;
        AAOperand operand2;
        List<IRNode> neighbors = new ArrayList<>();
        AATemp returnTemp;
        List<AAInstruction> aasm = new ArrayList<>();

        // basic tiling for binop, no optimization
        // first decides the two operands

        IRNode left = node.left();
        IRNode right = node.right();
//        if (left instanceof IRConst) {
//            if (right instanceof IRConst) {
//                // both are const, so move one into a temp
//                returnTemp = tempSpiller.newTemp();
//                AAImm rImm =  new AAImm(((IRConst) left).value());
//                aasm.add(new AAMove(returnTemp, rImm));
//                operand1 = returnTemp;
//                operand2 = rImm;
//            } else if (right instanceof IRTemp) {
//                operand1 = new AATemp(((IRTemp) right).name());
//                operand2 = new AAImm(((IRConst) left).value());
//                returnTemp = (AATemp) operand1;
//            } else {
//                Tile childTile = node.getTile();
//                operand1 = childTile.getReturnTemp();
//                operand2 = new AAImm(((IRConst) left).value());
//                returnTemp = (AATemp) operand1;
//            }
//        } else if (left instanceof IRTemp) {
//            // TODO: ok this is wrong
//            operand1 = new AATemp(((IRTemp) node.left()).name());
//            if (right instanceof IRConst) {
//
//            } else if (right instanceof IRTemp) {
//
//            } else {
//
//            }
//        } else {
////            Tile childTile = node.getTile();
////            operand1 = childTile.getReturnTemp();
////            neighbors.add(node.left());
//        }

        // the least optimal
        Tile leftChildTile = left.getTile();
        Tile rightChildTile = right.getTile();
        operand1 = leftChildTile.getReturnTemp();
        operand2 = rightChildTile.getReturnTemp();
        returnTemp = (AATemp) operand1;
        neighbors.add(left);
        neighbors.add(right);

        Tile basicTile;
        switch (node.opType()){
            case ADD:
                // basic tiling, no optimization yet
                // TODO: match node against some patterns where optimization is possible through if-else
                AAAdd add = new AAAdd(operand1, operand2);
                aasm.add(add);
                break;
            case SUB:
                AASub sub = new AASub(operand1, operand2);
                aasm.add(sub);
                break;
            case MUL:
                // multiplier in rax, result in rax
                AATemp rax = new AATemp("rax");
                aasm.add(new AAMove(rax, operand1));
                aasm.add(new AAMul(operand2));
                aasm.add(new AAMove(returnTemp, rax));
                break;
            case HMUL:
                // mul puts higher part in rdx
                AATemp rdx = new AATemp("rdx");
                aasm.add(new AAMove(rdx, operand1));
                aasm.add(new AAMul(operand2));
                aasm.add(new AAMove(returnTemp, rdx));
                break;
            case DIV:
                // op1 = dividend in rax, result in rax
                rax = new AATemp("rax");
                aasm.add(new AAMove(rax, operand1));
                aasm.add(new AADiv(operand2));
                aasm.add(new AAMove(returnTemp, rax));
                break;
            case MOD:
                // div puts remainder in rdx
                rdx = new AATemp("rdx");
                aasm.add(new AAMove(rdx, operand1));
                aasm.add(new AADiv(operand2));
                aasm.add(new AAMove(returnTemp, rdx));
                break;
            case AND:
                aasm.add(new AAAnd(operand1, operand2));
                break;
            case OR:
                aasm.add(new AAOr(operand1, operand2));
                break;
            case XOR:
                aasm.add(new AAXor(operand1, operand2));
                break;
            case LSHIFT:
                aasm.add(new AAShl(operand1, operand2));
                break;
            case RSHIFT:
                aasm.add(new AAShr(operand1, operand2));
                break;
            case ARSHIFT:
                aasm.add(new AASar(operand1, operand2));
                break;
            case EQ: case NEQ: case LT: case ULT: case GT: case LEQ: case GEQ:
                // TODO: cmp only set flags. no return value needed here?
                break;
            default:
                break;

        }
        basicTile = new Tile(aasm, neighbors);
        node.setTile(basicTile);

        return node;
    }

    private IRNode tileMem(IRMem n2 ){
        List<IRNode> neighbors = new ArrayList<>();
        List<AAInstruction> instructs = new ArrayList<>();
        AATemp ret = this.tempSpiller.newTemp();

        neighbors.add(n2.expr());
        AAMem result = new AAMem();
        //there are three case
        // 1: global data
        // 2: an string or an array
        // user just want to use mem...[is there really this case?] --> yes, all the time, e.g. add 1, [rpx + 8]

        if(n2.expr() instanceof IRBinOp){
            IRBinOp thechild = (IRBinOp) n2.expr();
            if(thechild.opType() == IRBinOp.OpType.ADD){
                if(thechild.right() instanceof  IRBinOp){
                    if(((IRBinOp) thechild.right()).opType() == IRBinOp.OpType.MUL){
                        result.setBase(thechild.left().getTile().returnTemp);
                        result.setIndex(((IRBinOp) thechild.right()).left().getTile().returnTemp);
                        if(((IRBinOp) thechild.right()).right() instanceof IRConst){
                            result.setImmediate(new AAImm(((IRConst) ((IRBinOp) thechild.right()).right()).value()));
                        }else{
                            result.setIndex(thechild.right().getTile().returnTemp);
                        }
                    }
                }
            }
        }else if(n2.expr() instanceof  IRLabel){
            // how to get to know the position of a global data

            //TODO:find global data place
        }else{
            result.setBase(n2.expr().getTile().returnTemp);
            result.setScale(0);
        }

        instructs.add(new AAMove(ret, result));
        Tile newtile = new Tile(instructs,neighbors);

        newtile.returnTemp = ret;

        n2.setTile(newtile);
        return n2;
    }



}
