package jw795.asmgenerator;

import edu.cornell.cs.cs4120.xic.ir.*;
import edu.cornell.cs.cs4120.xic.ir.visit.IRVisitor;
import jw795.Compiler;
import jw795.assembly.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * A visitor that traverse an IR tree and translate IR into tiles of abstract assembly.
 */
public class Tiler extends IRVisitor {
    public TempSpiller tempSpiller;
    private final AAReg rax = new AAReg("rax");
    private final AAReg rbx = new AAReg("rbx");
    private final AAReg rcx = new AAReg("rcx");
    private final AAReg rdx = new AAReg("rdx");
    private final AAReg rsp = new AAReg("rsp");
    private final AAReg rbp = new AAReg("rbp");
    private final AAReg rsi = new AAReg("rsi");
    private final AAReg rdi = new AAReg("rdi");
    private final AAReg r8 = new AAReg("r8");
    private final AAReg r9 = new AAReg("r9");
    private final AAReg r10 = new AAReg("r10");
    private final AAReg r11 = new AAReg("r11");
    private final AAReg r12 = new AAReg("r12");
    private final AAReg r13 = new AAReg("r13");
    private final AAReg r14 = new AAReg("r14");
    private final AAReg r15 = new AAReg("r15");

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
            return tileCompUnit((IRCompUnit) n2);
        } else if (n2 instanceof IRFuncDecl) {
            return tileFuncDecl((IRFuncDecl) n2);
        } else if (n2 instanceof IRSeq){
            return tileSeq((IRSeq) n2);
        } else if (n2 instanceof IRMove) {
            return tileMove((IRMove) n2);
        } else if (n2 instanceof IRCallStmt) {
            return tileCallStmt((IRCallStmt) n2);
        } else if (n2 instanceof IRJump) {
            return tileJump((IRJump) n2);
        } else if (n2 instanceof IRCJump) {
            return tileCJump((IRCJump) n2);
        } else if (n2 instanceof IRLabel) {
            return tileLabel((IRLabel) n2);
        } else if (n2 instanceof IRReturn) {
            return tileReturn((IRReturn) n2);
        }
        // expressions
        else if (n2 instanceof IRConst) {
            return tileConst((IRConst) n2);
        } else if (n2 instanceof IRTemp) {
            return tileTemp((IRTemp) n2);
        } else if (n2 instanceof IRMem) {
            return tileMem((IRMem) n2);
        } else if (n2 instanceof IRName) {
            return tileName((IRName) n2);
        } else if (n2 instanceof IRBinOp) {
            return tileBinop((IRBinOp) n2);
        } else {
            System.out.println("IR is not lowered.");
            return null;
        }
    }

    /**
     * Tile a Seq IR instruction
     * @param node a IRSeq node
     * @return a Seq IR node labeled with its tile of assembly
     */
    private IRNode tileSeq(IRSeq node) {
        List <AAInstruction> ins = new ArrayList<>();
        List<IRNode> neighbors = new ArrayList<>();
        for(IRStmt s: node.stmts()){
            neighbors.add(s);
        }
        Tile result = new Tile(ins,neighbors);
        node.setTile(result);
        return node;
    }

    /**
     * Tile a FuncDecl IR instruction
     * @param node a FuncDecl IR node
     * @return a move IR node labeled with its tile of assembly
     */
    private IRNode tileFuncDecl(IRFuncDecl node) {
        String name = node.name();
        IRStmt body = node.body();
        List<IRNode> neighbors = new ArrayList<>();
        List<AAInstruction> asm = new ArrayList<>();
        asm.add(new AALabelInstr(name));
        asm.add(new AAPush(rdi));
        asm.add(new AAPush(rbp));
        asm.add(new AAMove(rbp, rsp));
        asm.add(new AAAdd(rbp, new AAImm(8)));
        asm.add(new AAPush(rbx));
        asm.add(new AAPush(r12));
        asm.add(new AAPush(r13));
        asm.add(new AAPush(r14));
        asm.add(new AAPush(r15));
        TempSpiller tmpsp = new TempSpiller();
        long l = spilledTemps(body, tmpsp);
        if (l % 2 != 0) {
            l += 1;
        }
        asm.add(new AASub(rsp, new AAImm(8*l)));
        asm.addAll(body.getTile().getAssembly());
        asm.add(new AAAdd(rsp, new AAImm(8*l)));
        asm.add(new AAPop(r15));
        asm.add(new AAPop(r14));
        asm.add(new AAPop(r13));
        asm.add(new AAPop(r12));
        asm.add(new AAPop(rbx));
        asm.add(new AAPop(rbp));
        asm.add(new AAAdd(rsp, new AAImm(8)));
        asm.add(new AARet());
        node.setTile(new Tile(asm, neighbors));
        return node;
    }

    /**
     * traverse the tile to get tmp number and replace tmp name with mem
     * @param node root node
     * @return how many temps are spilled to stack
     */
    private long spilledTemps(IRNode node, TempSpiller tmpsp){
        Tile cur = node.getTile();
        for(AAInstruction a : cur.getAssembly()){
            AAOperand a1;
            AAOperand a2;
            if(a.operand1.isPresent()){
                a1 =  a.operand1.get();
                if(a1 instanceof AATemp) {
                    tmpsp.spillTemp((AATemp) a1);
                    a1 = tmpsp.getMemOfTemp((AATemp) a1);
                    a.reseta1(a1);
                }
            }
            if(a.operand2.isPresent()){
                a2 = a.operand2.get();
                if(a2 instanceof AATemp){
                    tmpsp.spillTemp((AATemp) a2);
                    a2 = tmpsp.getMemOfTemp((AATemp) a2);
                    a.reseta2(a2);
                }
            }
            for(IRNode irn: cur.getNeighborIRs()){
                spilledTemps(irn,tmpsp);
            }
        }
        return tmpsp.tempCounter;
    }

    /**
     * Translate CompUnit.
     * @param node compile unit
     * @return translated compile unit
     */
    private IRNode tileCompUnit(IRCompUnit node) {
        List<AAInstruction> aasm = new ArrayList<>();
        aasm.add(new AADirective(AADirective.DirType.DATA));
        // data section
        for (Map.Entry<String, IRData> data : node.dataMap().entrySet()) {
            aasm.add(new AALabelInstr(data.getKey()));
            for (Long d : data.getValue().data()) {
                aasm.add(new AADataDecl(d));
            }
        }

        aasm.add(new AADirective(AADirective.DirType.TEXT));
        List<IRNode> neighbors = new ArrayList<>();

        for (Map.Entry<String, IRFuncDecl> function : node.functions().entrySet()) {
            neighbors.add(function.getValue());
        }

        Tile compUnitTile = new Tile(aasm, neighbors);
        node.setTile(compUnitTile);
        return node;
    }

    /**
     * Tile a return IR instruction
     * @param node a Return IR node
     * @return a Return IR node labeled with its tile of assembly
     */
    private IRNode tileReturn(IRReturn node) {
        ArrayList<IRExpr> rets = new ArrayList<>(node.rets());
        int ret_size = rets.size();

        List<AAInstruction> asm = new ArrayList<>();
        List<IRNode> neighbors = new ArrayList<>(rets);
        if (ret_size == 0) {
            //do nothing
        } else if (ret_size == 1) {
            asm.add(new AAMove(rax, rets.get(0).getTile().getReturnTemp()));
        } else if (ret_size == 2) {
            asm.add(new AAMove(rax, rets.get(0).getTile().getReturnTemp()));
            asm.add(new AAMove(rdx, rets.get(1).getTile().getReturnTemp()));
        } else {
            asm.add(new AAMove(rax, rets.get(0).getTile().getReturnTemp()));
            asm.add(new AAMove(rdx, rets.get(1).getTile().getReturnTemp()));
            AAMem ret_pt = new AAMem();
            ret_pt.setBase(rdi);
            for (int i = 2; i < ret_size; i++) {
                asm.add(new AAMove(ret_pt, rets.get(i).getTile().getReturnTemp()));
            }
        }
        node.setTile(new Tile(asm, neighbors));
        return node;
    }

    /**
     * Tile a move IR instruction
     * @param node a move IR node
     * @return a move IR node labeled with its tile of assembly
     */
    private IRNode tileMove(IRMove node) {
        //TODO: optimization
//        if (node.source() instanceof IRBinOp && node.target().equals(node.source())) {
//            List<IRNode> neighbors = new ArrayList<>();
//            neighbors.add(node.source());
//            node.setTile(new Tile(new ArrayList<>(), neighbors));
//        } else {
        AAOperand operand1;
        AAOperand operand2;
        Tile t1 = node.target().getTile();
        Tile t2 = node.source().getTile();
        operand1 = t1.getReturnTemp();
        operand2 = t2.getReturnTemp();
        AAMove m1 = new AAMove(rdx, operand2);
        AAMove m2 = new AAMove(operand1, rdx);

        ArrayList<AAInstruction> asm = new ArrayList<>();
        asm.addAll(t1.getAssembly());
        asm.addAll(t2.getAssembly());
        asm.add(m1);
        asm.add(m2);

        List<IRNode> neighbors = new ArrayList<>();
        Tile t = new Tile (asm, neighbors);
        node.setTile(t);
        return node;
    }

    /**
     * Tile a label node into an assembly label
     * @param node label IR node
     * @return node with label tile
     */
    private IRNode tileLabel(IRLabel node) {
        List<AAInstruction> aasm = new ArrayList<>();
        aasm.add(new AALabelInstr(node.name()));
        Tile labelTile = new Tile(aasm, new ArrayList<>());
        node.setTile(labelTile);
        return node;
    }

    /**
     * Tile an IR Name into assembly
     * @param node IR Name node
     * @return node tiled with assembly name
     */
    private IRNode tileName(IRName node) {
        // For an IR of Name(l), assembly need the label l
        List<AAInstruction> aasm = new ArrayList<>();
        AATemp target = tempSpiller.newTemp();
        aasm.add(new AAMove(target, new AALabel(node.name())));
        Tile labelTile = new Tile(aasm, new ArrayList<>());
        labelTile.setReturnTemp(target);
        node.setTile(labelTile);
        return node;
    }

    /**
     * Tile a const IR expression by moving it to the target temp.
     * @param node const
     * @return const annotated with assembly tile
     */
    private IRNode tileConst(IRConst node) {
        AATemp returnTemp = tempSpiller.newTemp();
        List<AAInstruction> aasm = new ArrayList<>();
        aasm.add(new AAMove(returnTemp, new AAImm(node.value())));
        Tile constTile = new Tile(aasm, new ArrayList<>());
        node.setTile(constTile);
        return node;
    }

    /**
     * Tile a temp IR expression by moving it to the target temp
     * @param node temp
     * @return temp annotated with assembly tile.
     */
    private IRNode tileTemp(IRTemp node) {
        AATemp returnTemp = tempSpiller.newTemp();
        List<AAInstruction> aasm = new ArrayList<>();
        aasm.add(new AAMove(returnTemp, new AATemp(node.name())));
        Tile constTile = new Tile(aasm, new ArrayList<>());
        node.setTile(constTile);
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
        // TODO: some optimization stuff temporarily commented out for now do not delete these!!
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
                aasm.add(new AAMove(rax, operand1));
                aasm.add(new AAMul(operand2));
                aasm.add(new AAMove(returnTemp, rax));
                break;
            case HMUL:
                // mul puts higher part in rdx
                aasm.add(new AAMove(rdx, operand1));
                aasm.add(new AAMul(operand2));
                aasm.add(new AAMove(returnTemp, rdx));
                break;
            case DIV:
                // op1 = dividend in rax, result in rax
                aasm.add(new AAMove(rax, operand1));
                aasm.add(new AADiv(operand2));
                aasm.add(new AAMove(returnTemp, rax));
                break;
            case MOD:
                // div puts remainder in rdx
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
            case EQ:
                AATemp target = tempSpiller.newTemp();
                aasm.add(new AACmp(operand1, operand2));
                aasm.add(new AASetcc(target, AASetcc.Condition.EQ));
                returnTemp = target;
                break;
            case NEQ:
                target = tempSpiller.newTemp();
                aasm.add(new AACmp(operand1, operand2));
                aasm.add(new AASetcc(target, AASetcc.Condition.NEQ));
                returnTemp = target;
                break;
            case LT:
                target = tempSpiller.newTemp();
                aasm.add(new AACmp(operand1, operand2));
                aasm.add(new AASetcc(target, AASetcc.Condition.LT));
                returnTemp = target;
                break;
            case ULT:
                target = tempSpiller.newTemp();
                aasm.add(new AACmp(operand1, operand2));
                aasm.add(new AASetcc(target, AASetcc.Condition.ULT));
                returnTemp = target;
                break;
            case GT:
                target = tempSpiller.newTemp();
                aasm.add(new AACmp(operand1, operand2));
                aasm.add(new AASetcc(target, AASetcc.Condition.GT));
                returnTemp = target;
                break;
            case LEQ:
                target = tempSpiller.newTemp();
                aasm.add(new AACmp(operand1, operand2));
                aasm.add(new AASetcc(target, AASetcc.Condition.LEQ));
                returnTemp = target;
                break;
            case GEQ:
                target = tempSpiller.newTemp();
                aasm.add(new AACmp(operand1, operand2));
                aasm.add(new AASetcc(target, AASetcc.Condition.GEQ));
                returnTemp = target;
                break;
            default:
                break;
        }
        basicTile = new Tile(aasm, neighbors);
        basicTile.setReturnTemp(returnTemp);
        node.setTile(basicTile);

        return node;
    }

    /**
     * Tile a IR Mem node
     * @param n2 the node to tile
     * @return  n2 with tile being set
     */
    private IRNode tileMem(IRMem n2){
        List<IRNode> neighbors = new ArrayList<>();
        List<AAInstruction> instructs = new ArrayList<>();
        AATemp ret = this.tempSpiller.newTemp();

        AAMem result = new AAMem();
        boolean canbeshortcut = false;
        //there are three case
        // 1: global data // this case is handle by IRNAMe itself
        // 2: an string or an array
        // 3: user just want to use mem...[is there really this case?] --> yes, all the time, e.g. add 1, [rpx + 8]

        if(n2.expr() instanceof IRBinOp){
            IRBinOp thechild = (IRBinOp) n2.expr();
            if(thechild.opType() == IRBinOp.OpType.ADD){
                if(thechild.right() instanceof IRBinOp){
                    if(((IRBinOp) thechild.right()).opType() == IRBinOp.OpType.MUL){
                        if(((IRBinOp) thechild.right()).left() instanceof IRConst){
                            canbeshortcut = true;
                        }
                    }
                }
            }
        }
        if(canbeshortcut){
            // having an extra move to deal with the problem that arr pos become rsp + sth
            IRBinOp thechild = (IRBinOp) n2.expr();
            instructs.add(new AAMove(rax, thechild.left().getTile().getReturnTemp()));
            result.setBase(rax);
            result.setScale(((IRConst) ((IRBinOp) thechild.right()).left()).value());
            if(((IRBinOp) thechild.right()).right() instanceof IRConst){
                result.setImmediate(new AAImm(((IRConst) ((IRBinOp) thechild.right()).right()).value()));
            }else{
                instructs.add(new AAMove(rcx, thechild.right().getTile().getReturnTemp()));
                result.setIndex(rcx);
            }

        }else if(n2.expr() instanceof IRConst){
            result.setImmediate(new AAImm(((IRConst) n2.expr()).value()));
        }else{
            result.setBase(rdx);
            neighbors.add(n2.expr());
        }

        instructs.add(new AAMove(ret, result));
        Tile newtile = new Tile(instructs,neighbors);

        newtile.setReturnTemp(ret);
        n2.setTile(newtile);
        return n2;
    }

    /**
     * Tile a jump stmt IR instruction
     * @param node a jump IR node
     * @return a jump IR node labeled with its tile of assembly
     */
    private IRNode tileJump(IRJump node) {
        List<AAInstruction> aasm = new ArrayList<>();
        aasm.add(new AAJmp(node.target().getTile().getReturnTemp()));
        Tile jumpTile = new Tile(aasm, new ArrayList<>());
        node.setTile(jumpTile);
        return node;
    }

    /**
     * Tile a CJump IR instruction
     * @param node a CJump IR node
     * @return a CJump IR node labeled with its tile of assembly
     */
    private IRNode tileCJump(IRCJump node) {
        List<AAInstruction> aasm = new ArrayList<>();
        List<IRNode> neighbors = new ArrayList<>();
        neighbors.add(node.cond());

        String target = node.trueLabel();
        if (node.cond() instanceof IRBinOp){
            switch (((IRBinOp)node.cond()).opType()) {
                case XOR:
                    //XOR (binop) (const 1) due to jump reorder
                    if (((IRBinOp)node.cond()).left() instanceof IRBinOp
                            && ((IRBinOp)node.cond()).right() instanceof IRTemp) {
                        switch ((((IRBinOp) ((IRBinOp)node.cond()).left()).opType())){
                            case EQ:
                                aasm.add(new AAJne(new AALabel(target)));
                                break;
                            case NEQ:
                                aasm.add(new AAJe(new AALabel(target)));
                                break;
                            case LT:
                                aasm.add(new AAJg(new AALabel(target)));
                                break;
                            case ULT:
                                aasm.add(new AAJa(new AALabel(target)));
                                break;
                            case GT:
                                aasm.add(new AAJl(new AALabel(target)));
                                break;
                            case LEQ:
                                aasm.add(new AAJge(new AALabel(target)));
                                break;
                            case GEQ:
                                aasm.add(new AAJle(new AALabel(target)));
                                break;
                            default:
                                break;
                        }
                    } else {
                        aasm.add(new AACmp(node.cond().getTile().getReturnTemp(), new AAImm(1)));
                        aasm.add(new AAJe(new AALabel(target)));
                    }
                    break;
                case AND:
                case OR:
                    aasm.add(new AACmp(node.cond().getTile().getReturnTemp(), new AAImm(1)));
                    aasm.add(new AAJe(new AALabel(target)));
                    break;
                case EQ:
                    aasm.add(new AAJe(new AALabel(target)));
                    break;
                case NEQ:
                    aasm.add(new AAJne(new AALabel(target)));
                    break;
                case LT:
                    aasm.add(new AAJl(new AALabel(target)));
                    break;
                case ULT:
                    aasm.add(new AAJb(new AALabel(target)));
                    break;
                case GT:
                    aasm.add(new AAJg(new AALabel(target)));
                    break;
                case LEQ:
                    aasm.add(new AAJle(new AALabel(target)));
                    break;
                case GEQ:
                    aasm.add(new AAJge(new AALabel(target)));
                    break;
                default:
                    break;
            }
        } else if (node.cond() instanceof IRTemp){ //true, false IRTemp
            aasm.add(new AACmp(node.cond().getTile().getReturnTemp(), new AAImm(1)));
            aasm.add(new AAJe(new AALabel(target)));
        } else {
            System.out.println("should not enter this branch");
        }

        Tile jumpTile = new Tile(aasm, neighbors);
        node.setTile(jumpTile);
        return node;
    }

    /**
     * Tile a call stmt IR instruction
     * @param node a call stmt IR node
     * @return a call stmt IR node labeled with its tile of assembly
     */
    private IRNode tileCallStmt(IRCallStmt node){
        List<AAInstruction> instructs = new ArrayList<>();
        List<IRNode> neighbors = new ArrayList<>();
        List<AATemp> exprTemps = new ArrayList<>();

        //T[t1, e2] == move(temp(t1), e), T[t2, e2], ..., T[tn, en]
        for (IRExpr e : node.args()){
            neighbors.add(e);
            exprTemps.add(0, e.getTile().getReturnTemp()); // tn, tn-1, ... t1
        }

        // if returning more than two, manually reserve space for ret2
        Long nReturns = node.n_returns();
        boolean multiRet = false;
        if (nReturns > 2){
            instructs.add(new AASub(rsp, new AAImm(8 * (nReturns - 2))));
            instructs.add(new AAMove(rdi, rsp));
            multiRet = true;
        }

        // push excess args onto stack in reverse order
        int nArgs = node.args().size();
        int excessArgs = multiRet ? Math.max(0, nArgs-6) : Math.max(0, nArgs-5);
        for (int i = 0; i < excessArgs; i++){
            instructs.add(new AAPush(exprTemps.get(i)));// push tn ... t7/6
        }

        AAReg[] argRegs = new AAReg[] {rdi, rsi, rdx, rcx, r8, r9};

        // move up to first 6 args to registers
        for (int i = 0; i < nArgs-excessArgs; i++){
            instructs.add(new AASub(argRegs[i], new AAImm(8)));
            instructs.add(new AAMove(rsp, exprTemps.get(excessArgs+i-1)));
        }

        //make sure stack is 16 byte aligned before func call
        int excessRets = multiRet ? nReturns.intValue()-2 : 0;
        if (excessRets % 2 == 1){
            instructs.add(new AASub(rsp, new AAImm(8)));
        }

        // store rip on stack, jumps to specific destination
        instructs.add(new AACall(node.target().getTile().getReturnTemp()));

        if (multiRet && excessArgs != 0){
            instructs.add(new AAAdd(rsp, new AAImm(8L * excessArgs)));
        }

        AAReg[] funcRegs = new AAReg[] {rax, rdx};
        for (int i = 0; i < Math.min(2, nReturns); i++){
            instructs.add(new AAMove(tempSpiller.newTemp(), funcRegs[i]));
        }

        if (!multiRet && excessArgs != 0){
            instructs.add(new AAAdd(rsp, new AAImm(8L * excessArgs)));
        }

        //pop
        if (multiRet){
            for (int i = 0; i < nReturns-2; i++){
                //pop rv3...n
                instructs.add(new AAPop(tempSpiller.newTemp()));
            }
        }

        Tile callStmtTile = new Tile(instructs, neighbors);
        node.setTile(callStmtTile);
        return node;
    }


}
