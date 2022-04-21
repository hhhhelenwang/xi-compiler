package jw795.asmgenerator;

import edu.cornell.cs.cs4120.xic.ir.*;
import edu.cornell.cs.cs4120.xic.ir.visit.IRVisitor;
import jw795.assembly.*;

import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * A visitor that traverse an IR tree and translate IR into tiles of abstract assembly.
 */
public class Tiler extends IRVisitor {
    public TempSpiller tempSpiller;
    HashMap<String, Long> funcArgLengths;
    HashMap<String, Long> funcRetLengths;

    String[] argNames = new String[6];

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
    private final AAReg rip = new AAReg("rip");

    public Tiler(IRNodeFactory inf, TempSpiller tsp, HashMap<String, Long> funcArg, HashMap<String, Long> funcRet, HashMap<String, String> names) {
        super(inf);
        tempSpiller = tsp;
        for (int i = 0; i < 6; i++) {
            argNames[i] = "_ARG" + (i + 1);
        }
        funcArgLengths = new HashMap<>();
        funcRetLengths = new HashMap<>();
        for (String key : funcArg.keySet()) {
            funcArgLengths.put(names.get(key), funcArg.get(key));
            funcRetLengths.put(names.get(key), funcRet.get(key));
        }
        funcArgLengths.put("_xi_alloc", 1L);
        funcRetLengths.put("_xi_alloc", 1L);

        funcArgLengths.put("_xi_out_of_bounds", 0L);
        funcRetLengths.put("_xi_out_of_bounds", 0L);

        funcArgLengths.put("_Iassert_pb", 1L);
        funcRetLengths.put("_Iassert_pb", 0L);
    }

    /**
     * Translate an IR node into a tile of abstract assembly instructions.
     *
     * @param parent The parent AST node of {@code n} or {@code null} when it is the root.
     * @param n      The original node in the input AST
     * @param n2     The node returned by {@link IRNode#visitChildren(IRVisitor)}, which should
     *               look like n except that the children have been visited.
     * @param v2     The new node visitor created by {@link #enter(IRNode, IRNode)}, or {@code this}.
     * @return this node but visited
     */
    @Override
    protected IRNode leave(IRNode parent, IRNode n, IRNode n2, IRVisitor v2) {
        if (n2 instanceof IRCompUnit) {
            // whatever need to be done for CompUnit
            return tileCompUnit((IRCompUnit) n2);
        } else if (n2 instanceof IRFuncDecl) {
            return tileFuncDecl((IRFuncDecl) n2);
        } else if (n2 instanceof IRSeq) {
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
     *
     * @param node a IRSeq node
     * @return a Seq IR node labeled with its tile of assembly
     */
    private IRNode tileSeq(IRSeq node) {
        List<AAInstruction> ins = new ArrayList<>();
        List<IRNode> neighbors = new ArrayList<>(node.stmts());
        Tile result = new Tile(ins, neighbors);
        node.setTile(result);
        return node;
    }

    /**
     * Tile a FuncDecl IR instruction
     *
     * @param node a FuncDecl IR node
     * @return a FuncDecl IR node labeled with its tile
     */
    private IRNode tileFuncDecl(IRFuncDecl node) {
        String name = node.name();
        IRStmt body = node.body();
        List<IRNode> neighbors = new ArrayList<>();
        List<AAInstruction> asm = new ArrayList<>();
        asm.add(new AADirective(AADirective.DirType.TEXT));
        asm.add(new AADirective(AADirective.DirType.GLOBAL, name));
        asm.add(new AALabelInstr(name));

        // return adress
        asm.add(new AAPush(rdi));

        //frame pointer
        asm.add(new AAPush(rbp));

        //save callee-saved registers
        asm.add(new AAMove(rbp, rsp));
        asm.add(new AAAdd(rbp, new AAImm(8L)));
        asm.add(new AAPush(rbx));
        asm.add(new AAPush(r12));
        asm.add(new AAPush(r13));
        asm.add(new AAPush(r14));
        asm.add(new AAPush(r15));

        //move function arguments from caller stack and registers to _ARG temps
        AAReg[] argRegs = new AAReg[]{rsi, rdx, rcx, r8, r9};
        long argSize = funcArgLengths.get(name);
        for (long i = 0L; i < argSize; i++) {
            if (i < 5) {
                asm.add(new AAMove(tempSpiller.newTemp("_ARG" + (i + 1)), argRegs[(int) i]));
            } else {
                long index = i - 4;
                AAMem mem = new AAMem();
                mem.setBase(rbp);
                mem.setImmediate(new AAImm(index * 8));
                asm.add(new AAMove(rax, mem));
                asm.add(new AAMove(tempSpiller.newTemp("_ARG" + (i + 1)), rax));
            }
        }

        // let body be fundecl node's neighbor for now in order to calculate number of temp
        // and translate temp in both asm
        neighbors.add(body);
        node.setTile(new Tile(asm, neighbors));
        long l = allocate(node, tempSpiller);
        // for alignment
        if (l % 2 == 0) {
            l += 1;
        }

        List<AAInstruction> curAsm = node.getTile().getAssembly();

        // allocate space for spilled temps + alignment for all the function calls
        curAsm.add(new AASub(rsp, new AAImm(8 * l)));

        // add body's asm to fundecl's asm
        curAsm.addAll(concatAsm(body));

        // destroy stack up to callee-saved registers
        curAsm.add(new AAAdd(rsp, new AAImm(8 * l)));

        //restore callee-saved registers
        curAsm.add(new AAPop(r15));
        curAsm.add(new AAPop(r14));
        curAsm.add(new AAPop(r13));
        curAsm.add(new AAPop(r12));
        curAsm.add(new AAPop(rbx));
        curAsm.add(new AAPop(rbp));

        //destroy the stack for the return adress
        curAsm.add(new AAAdd(rsp, new AAImm(8)));

        //final ret
        curAsm.add(new AARet());

        // set the final tile of funcdecl with no neighbor
        node.setTile(new Tile(curAsm, new ArrayList<>()));

        // reset temp spiller for the next fundecl to use
        tempSpiller = new TempSpiller();
        return node;
    }

    /**
     * Recursively traverse root node to get their assembly code
     *
     * @param node root node
     * @return List of instructions of concatenated optimal assembly code
     */
    private List<AAInstruction> concatAsm(IRNode node) {
        List<AAInstruction> asm = new ArrayList<>();
        for (IRNode neighbor : node.getTile().getNeighborIRs()) {
            asm.addAll(concatAsm(neighbor));
        }
        asm.addAll(node.getTile().getAssembly());
        return asm;
    }

    /**
     * traverse the root node and replace tmp name with mem
     *
     * @param node  root node
     * @param tmpsp temp spiller
     * @return how many temps are spilled to stack
     */
    private long allocate(IRNode node, TempSpiller tmpsp) {
        Tile cur = node.getTile();
        for (IRNode irn : cur.getNeighborIRs()) {
            allocate(irn, tmpsp);
        }
        for (AAInstruction a : cur.getAssembly()) {
            AAOperand a1;
            AAOperand a2;
            if (a.operand1.isPresent()) {
                a1 = a.operand1.get();
                if (a1 instanceof AATemp) {
                    tmpsp.spillTemp((AATemp) a1);
                    AAImm offset = tmpsp.getOffsetOfTemp((AATemp) a1);
                    AAMem mem = new AAMem();
                    mem.setBase(rbp);
                    mem.setImmediate(offset);
                    mem.setScale(-1L);
                    a.reseta1(mem);
                }
            }
            if (a.operand2.isPresent()) {
                a2 = a.operand2.get();
                if (a2 instanceof AATemp) {
                    tmpsp.spillTemp((AATemp) a2);
                    AAImm offset = tmpsp.getOffsetOfTemp((AATemp) a2);
                    AAMem mem = new AAMem();
                    mem.setBase(rbp);
                    mem.setImmediate(offset);
                    mem.setScale(-1L);
                    a.reseta2(mem);
                }
            }
        }
        return tmpsp.tempCounter;
    }

    /**
     * Translate CompUnit.
     *
     * @param node compile unit
     * @return translated compile unit
     */
    private IRNode tileCompUnit(IRCompUnit node) {
        List<AAInstruction> aasm = new ArrayList<>();
        aasm.add(new AADirective(AADirective.DirType.INTEL));
        aasm.add(new AADirective(AADirective.DirType.DATA));
        // data section
        for (Map.Entry<String, IRData> data : node.dataMap().entrySet()) {
            if ( data.getValue().data().length > 1) {
                aasm.add(new AALabelInstr(data.getKey()));
                aasm.add(new AADataDecl(data.getValue().data()[0]));
                for (int i = 1; i < data.getValue().data().length; i++) {
                    aasm.add(new AADataDecl(data.getValue().data()[i]));
                }
            } else {
                aasm.add(new AALabelInstr(data.getKey()));
                for (Long d : data.getValue().data()){
                    aasm.add(new AADataDecl(d));
                }
            }
        }

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
     *
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
            ret_pt.setBase(rbp);
            asm.add(new AAMove(rcx, ret_pt)); //load the return adress from stack to register rcx
            for (int i = 2; i < ret_size; i++) {
                // move (i + 1)'th return value to rdi
                asm.add(new AAMove(rdi, rets.get(i).getTile().getReturnTemp()));
                // move return value in rdi to designated address
                AAMem m = new AAMem();
                m.setBase(rcx);
                asm.add(new AAMove(m, rdi));
                // increment return address by 8
                asm.add(new AAAdd(rcx, new AAImm(8L)));
            }
        }
        node.setTile(new Tile(asm, neighbors));
        return node;
    }

    /**
     * Tile a move IR instruction
     *
     * @param node a move IR node
     * @return a move IR node labeled with its tile of assembly
     */
    private IRNode tileMove(IRMove node) {
        // naive
        AAOperand destNaive;
        AAOperand srcNaive;
        ArrayList<IRNode> neighborsNaive = new ArrayList<>();

        IRNode target = node.target();
        IRNode source = node.source();

        Tile t2 = source.getTile();
        srcNaive = t2.getReturnTemp();
        neighborsNaive.add(source);

        Tile t1 = target.getTile();
        destNaive = t1.getReturnTemp();
        neighborsNaive.add(node.target());

        AAMove m1 = new AAMove(rcx, srcNaive);
        AAMove m2 = new AAMove(destNaive, rcx);

        ArrayList<AAInstruction> asmNaive = new ArrayList<>();
        asmNaive.add(m1);
        asmNaive.add(m2);

        Tile tileNaive = new Tile(asmNaive, neighborsNaive);

        // check for possible inc or dec uses
        List<AAInstruction> asmIncDec = new ArrayList<>();
        Tile tileIncDec = null;
        if (target instanceof IRTemp && source instanceof IRBinOp
                && (((IRBinOp) source).opType() == IRBinOp.OpType.ADD
                    || ((IRBinOp) source).opType() == IRBinOp.OpType.SUB)) {
            IRNode left = ((IRBinOp) source).left();
            IRNode right = ((IRBinOp) source).right();

            boolean isIncOrDec =
                    left instanceof IRConst
                        && ((IRConst) left).value() == 1
                        && right instanceof IRTemp
                        && ((IRTemp) right).name().equals(((IRTemp) target).name())
                    ||
                    right instanceof IRConst
                            && ((IRConst) right).value() == 1
                            && left instanceof IRTemp
                            && ((IRTemp) left).name().equals(((IRTemp) target).name());

            if (isIncOrDec) {
                AATemp targetTemp = tempSpiller.newTemp(((IRTemp) target).name());
                if (((IRBinOp) source).opType() == IRBinOp.OpType.ADD) {
                    asmIncDec.add(new AAInc(targetTemp));
                } else {
                    asmIncDec.add(new AADec(targetTemp));
                }
                tileIncDec = new Tile(asmIncDec, new ArrayList<>());

            } else {
                tileIncDec = null;
            }
        }

        // check for possible addressing shorthand
        // possible combinations:
        // target = mem, source = mem --> check on both
        // target = temp, source = mem --> check for binop optimization on source
        // target = mem, source = temp --> check for binop optimization on target
        // target = temp, source = imm --> use single line command
        // target = temp, source = temp --> no optimization, use naive
        AAOperand destOpt;
        AAOperand srcOpt;
        List<AAInstruction> asmOpt = new ArrayList<>();
        List<IRNode> neighborsOpt = new ArrayList<>();
        Tile tileOpt = null;
        if (target instanceof IRMem && source instanceof IRMem) {
            // check on target
            destOpt = getOptMem((IRMem) target, asmOpt, neighborsOpt);
            // check on source
            srcOpt = getOptMem((IRMem) source, asmOpt, neighborsOpt);
            // since both target and source are mem, mov to a register in between
            asmOpt.add(new AAMove(rdi, srcOpt)); // optimized binop uses rax and rbx so use rdx to avoid conflict
            asmOpt.add(new AAMove(destOpt, rdi));
            tileOpt = new Tile(asmOpt, neighborsOpt);
        } else if (target instanceof IRTemp && source instanceof IRMem) {
            // target is a temp, use it directly
            destOpt = tempSpiller.newTemp(((IRTemp) target).name());
            // check on source
            srcOpt = getOptMem((IRMem) source, asmOpt, neighborsOpt);
            asmOpt.add(new AAMove(rdi, srcOpt)); // optimized binop uses rcx and rsi so use rdi to avoid conflict
            asmOpt.add(new AAMove(destOpt, rdi));
            tileOpt = new Tile(asmOpt, neighborsOpt);
        } else if (target instanceof IRMem && source instanceof IRTemp) {
            // check on target
            destOpt = getOptMem((IRMem) target, asmOpt, neighborsOpt);
            // source is a temp, use it directly
            srcOpt = tempSpiller.newTemp(((IRTemp) source).name());
            asmOpt.add(new AAMove(rdi, srcOpt)); // optimized binop uses rax and rbx so use rdx to avoid conflict
            asmOpt.add(new AAMove(destOpt, rdi));
            tileOpt = new Tile(asmOpt, neighborsOpt);
        } else if (target instanceof IRTemp && source instanceof IRConst){
            asmOpt.add(new AAMove(tempSpiller.newTemp(((IRTemp) target).name()),
                            new AAImm (((IRConst) source).value())));
            tileOpt = new Tile(asmOpt,neighborsOpt);
        }

        List<Tile> allOptions = new ArrayList<>();
        if (tileIncDec != null) {
            allOptions.add(tileIncDec);
        }
        if (tileOpt != null) {
            allOptions.add(tileOpt);
        }
        allOptions.add(tileNaive);

        Tile best = tileNaive;
        for (Tile option : allOptions) {
            if (option.getCostOfSubTree() <= best.getCostOfSubTree()) {
                best = option;
            }
        }
        node.setTile(best);

        return node;
    }

    /**
     * Helper to check for Mem(Binop) optimization into single memory address
     * Requires: oldOpr has already been tiled
     * @param oldOpr       the old mem node, not optimized
     * @param asmOpt       list of assembly code
     * @param neighborsOpt list of neighbors later used by the tile
     * @return the possibly optimized mem, can be a short-handed mem address, or a temp (no optimization)
     */
    private AAOperand getOptMem(IRMem oldOpr, List<AAInstruction> asmOpt, List<IRNode> neighborsOpt) {
        AAOperand optOpr;
        IRExpr targetAddr = oldOpr.expr();
        if (targetAddr instanceof IRBinOp) {
            BinOpToAddrParams targetAddrParams = binopToAddrMode((IRBinOp) targetAddr);
            if (targetAddrParams.optimized) {
                optOpr = targetAddrParams.address;
                asmOpt.addAll(targetAddrParams.assembly);
            } else {
                optOpr = oldOpr.expr().getTile().getReturnTemp();
                neighborsOpt.add(oldOpr);
            }
        } else {
            optOpr = oldOpr.getTile().getReturnTemp();
            neighborsOpt.add(oldOpr);
        }
        return optOpr;
    }


    /**
     * Tile a label node into an assembly label
     *
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
     *
     * @param node IR Name node
     * @return node tiled with assembly name
     */
    private IRNode tileName(IRName node) {
        // For an IR of Name(l), assembly need the label l
        //there are two case：
        //1: string
        //2: label
        List<AAInstruction> aasm = new ArrayList<>();
        AATemp target = tempSpiller.newTemp();
//        if (node.name().length() > 12 && node.name().startsWith("string_")) {
        aasm.add(new AAMove(rdx, tempSpiller.newTemp(node.name())));
        AAMem mem = new AAMem();
        mem.setBase(rip);
        mem.setLabel(new AALabel(node.name()));
        aasm.add(new AALea(rdx, mem));
        aasm.add(new AAMove(target, rdx));
//        } else {
//            aasm.add(new AAMove(target, new AALabel(node.name())));
//        }
        Tile labelTile = new Tile(aasm, new ArrayList<>());
        labelTile.setReturnTemp(target);
        node.setTile(labelTile);
        return node;
    }

    /**
     * Tile a const IR expression by moving it to the target temp.
     *
     * @param node const
     * @return const annotated with assembly tile
     */
    private IRNode tileConst(IRConst node) {
        AATemp returnTemp = tempSpiller.newTemp();
        List<AAInstruction> aasm = new ArrayList<>();
        aasm.add(new AAMove(returnTemp, new AAImm(node.value())));
        Tile constTile = new Tile(aasm, new ArrayList<>());
        constTile.setReturnTemp(returnTemp);
        node.setTile(constTile);
        return node;
    }

    /**
     * Tile a temp IR expression by moving it to the target temp
     *
     * @param node temp
     * @return temp annotated with assembly tile.
     */
    private IRNode tileTemp(IRTemp node) {
        node.setTile(new Tile(new ArrayList<>(), new ArrayList<>()));
        node.getTile().setReturnTemp(tempSpiller.newTemp(node.name()));
        return node;
    }

    /**
     * Tile a binop IR instruction
     *
     * @param node a binop IR node
     * @return a binop IR node labeled with its tile of assembly
     */
    private IRNode tileBinop(IRBinOp node) {
        AAOperand destNaive;
        AAOperand srcNaive;
        List<IRNode> neighborsNaive = new ArrayList<>();
        AATemp returnTempNaive;
        List<AAInstruction> aasmNaive = new ArrayList<>();

        // basic tiling for binop, no optimization
        // first decides the two operands
        IRNode left = node.left();
        IRNode right = node.right();
        if (left instanceof IRConst) {
            if (right instanceof IRConst) {
                // both are const, so move one into a temp, this tile has no neighbors
                returnTempNaive = tempSpiller.newTemp();
                AAImm rImm = new AAImm(((IRConst) left).value());
                aasmNaive.add(new AAMove(returnTempNaive, rImm));
                destNaive = returnTempNaive;
                srcNaive = new AAImm(((IRConst) right).value());

            } else if (right instanceof IRTemp) {
                // move content of right into a fresh temp, use the fresh temp as return temp
                AATemp newTemp = tempSpiller.newTemp();
                AATemp rightTemp = tempSpiller.newTemp(((IRTemp) right).name());
                aasmNaive.add(new AAMove(rcx, rightTemp));
                aasmNaive.add(new AAMove(newTemp, rcx));
                // dest = the new temp with rightTemp's value
                destNaive = newTemp;
                srcNaive = new AAImm(((IRConst) left).value());
                returnTempNaive = newTemp;
            } else {
                // move content of right temp into a fresh temp
                Tile rightTile = right.getTile();
                AATemp rightTemp = rightTile.getReturnTemp();
                AATemp newTemp = tempSpiller.newTemp();
                aasmNaive.add(new AAMove(rcx, rightTemp));
                aasmNaive.add(new AAMove(newTemp, rcx));
                // dest = the new temp with rightTemp's value
                destNaive = newTemp;
                srcNaive = new AAImm(((IRConst) left).value());
                returnTempNaive = newTemp;
                // right is the neighbor
                neighborsNaive.add(right);
            }
        } else if (left instanceof IRTemp) {
            if (right instanceof IRConst) {
                // move content of left temp into a new temp
                AATemp leftTemp = tempSpiller.newTemp(((IRTemp) left).name());
                AATemp newTemp = tempSpiller.newTemp();
                aasmNaive.add(new AAMove(rcx, leftTemp));
                aasmNaive.add(new AAMove(newTemp, rcx));

                destNaive = newTemp;
                srcNaive = new AAImm(((IRConst) right).value());
                returnTempNaive = newTemp;
            } else if (right instanceof IRTemp) {
                // both are temps, we need to move one temp into a register and binop with that register,
                // this tile has no neighbors
                AATemp leftTemp = tempSpiller.newTemp(((IRTemp) left).name());
                AAMove movRegTemp = new AAMove(rcx, leftTemp);
                aasmNaive.add(movRegTemp);
                destNaive = rcx;
                srcNaive = tempSpiller.newTemp(((IRTemp) right).name());
                // later we need to move result from rbx to return temp for which we create a fresh temp
                returnTempNaive = tempSpiller.newTemp();
            } else {
                // use left as dest, mov left into rbx, and use right return temp as source
                AATemp leftTemp = tempSpiller.newTemp(((IRTemp) left).name());
                AAMove movRegTemp = new AAMove(rcx, leftTemp);
                aasmNaive.add(movRegTemp);
                destNaive = rcx;
                srcNaive = right.getTile().getReturnTemp();
                // right is the neighbor
                neighborsNaive.add(right);
                // later we need to move result from rbx to return temp,
                // for which we continue to use a new temp
                returnTempNaive = tempSpiller.newTemp();
            }
        } else {
            if (right instanceof IRConst) {
                // move left return temp into a fresh temp
                AATemp newTemp = tempSpiller.newTemp();
                AATemp leftTemp = left.getTile().getReturnTemp();
                aasmNaive.add(new AAMove(rcx, leftTemp));
                aasmNaive.add(new AAMove(newTemp, rcx));

                destNaive = newTemp;
                srcNaive = new AAImm(((IRConst) right).value());
                returnTempNaive = newTemp;
                // the left is the neighbor node
                neighborsNaive.add(left);
            } else if (right instanceof IRTemp) {
                // need one temp to be moved to a register
                AATemp leftTemp = left.getTile().getReturnTemp();
                AAMove movRegTemp = new AAMove(rcx, leftTemp);
                aasmNaive.add(movRegTemp);
                // dest is the register
                destNaive = rcx;
                srcNaive = tempSpiller.newTemp(((IRTemp) right).name());
                // need to move result back in a new temp later
                returnTempNaive = tempSpiller.newTemp();
                // neighbor is left node
                neighborsNaive.add(left);
            } else {
                AATemp leftTemp = left.getTile().getReturnTemp();
                AATemp rightTemp = right.getTile().getReturnTemp();
                // need one temp to be moved to a register
                AAMove movRegTemp = new AAMove(rcx, leftTemp);
                aasmNaive.add(movRegTemp);
                // dest is the register
                destNaive = rcx;
                srcNaive = rightTemp;
                // need to move result back in temp later, so return temp is left temp
                returnTempNaive = tempSpiller.newTemp();
                // both are neighbors
                neighborsNaive.add(left);
                neighborsNaive.add(right);
            }
        }

        Tile tileNaive;
        switch (node.opType()) {
            case ADD:
                // for later use of inc, but since we do not want the normal add
                // but still want the previous instruction we do it here
                List<AAInstruction> aasmInc = new ArrayList<>(aasmNaive);

                // basic case
                AAAdd add = new AAAdd(destNaive, srcNaive);
                aasmNaive.add(add);
                // if dest and return temp do not points to the same thing, move dest into return temp
                if (destNaive != returnTempNaive) {
                    // means dest is a register, move the result into a temp
                    aasmNaive.add(new AAMove(returnTempNaive, destNaive));
                }
                tileNaive = new Tile(aasmNaive, neighborsNaive);
                tileNaive.setReturnTemp(returnTempNaive);

                // check for possible lea
                BinOpToAddrParams params = binopToAddrMode(node);
                Tile tileLea = null;
                if (params.optimized) {
                    List<AAInstruction> aasmLea = new ArrayList<>(params.assembly);
                    AATemp returnTempLea = tempSpiller.newTemp();
                    aasmLea.add(new AALea(rcx, params.address)); // the lea instruction (always use rax as dest)
                    aasmLea.add(new AAMove(returnTempLea, rcx)); // mov result to return temp after lea
                    tileLea = new Tile(aasmLea, new ArrayList<>()); // lea do not have neighbors
                    tileLea.setReturnTemp(returnTempLea);
                }

                // pick the best one
                if (tileLea != null && tileLea.getCostOfSubTree() <= tileNaive.getCostOfSubTree()) {
                    node.setTile(tileLea);
                } else {
                    node.setTile(tileNaive);
                }

                return node;

            case SUB:
                // for later use of dec, but since we do not want the normal sub
                // but still want the previous instructions so we do it here
                List<AAInstruction> aasmDec = new ArrayList<>(aasmNaive);

                AASub sub = new AASub(destNaive, srcNaive);
                aasmNaive.add(sub);
                if (destNaive != returnTempNaive) {
                    // means dest is a register, move the result into a temp
                    aasmNaive.add(new AAMove(returnTempNaive, destNaive));
                }

                tileNaive = new Tile(aasmNaive, neighborsNaive);
                tileNaive.setReturnTemp(returnTempNaive);
                break;
            case MUL:
                // multiplier in rax, result in rax
                aasmNaive.add(new AAMove(rax, destNaive));
                if (srcNaive instanceof AAImm) {
                    // mul only takes register or memory location
                    AATemp tmp = tempSpiller.newTemp();
                    aasmNaive.add(new AAMove(tmp, srcNaive));
                    aasmNaive.add(new AAImul(tmp));
                } else {
                    aasmNaive.add(new AAImul(srcNaive));
                }
                aasmNaive.add(new AAMove(returnTempNaive, rax));
                break;
            case HMUL:
                // mul puts higher part in rdx
                aasmNaive.add(new AAMove(rax, destNaive));
                if (srcNaive instanceof AAImm) {
                    // mul only takes register or memory location
                    AATemp tmp = tempSpiller.newTemp();
                    aasmNaive.add(new AAMove(tmp, srcNaive));
                    aasmNaive.add(new AAImul(tmp));
                } else {
                    aasmNaive.add(new AAImul(srcNaive));
                }
                aasmNaive.add(new AAMove(returnTempNaive, rdx));
                break;
            case DIV:
                // op1 = dividend in rax, result in rax
                aasmNaive.add(new AAMove(rax, destNaive));
                if (srcNaive instanceof AAImm) {
                    // div only takes register or memory location
                    AATemp tmp = tempSpiller.newTemp();
                    aasmNaive.add(new AAMove(tmp, srcNaive));
                    aasmNaive.add(new AAIdiv(tmp));
                } else {
                    aasmNaive.add(new AAIdiv(srcNaive));
                }
                aasmNaive.add(new AAMove(returnTempNaive, rax));
                break;
            case MOD:
                // div puts remainder in rdx
                aasmNaive.add(new AAMove(rax, destNaive));
                if (srcNaive instanceof AAImm) {
                    // div only takes register or memory location
                    AATemp tmp = tempSpiller.newTemp();
                    aasmNaive.add(new AAMove(tmp, srcNaive));
                    aasmNaive.add(new AAIdiv(tmp));
                } else {
                    aasmNaive.add(new AAIdiv(srcNaive));
                }
                aasmNaive.add(new AAMove(returnTempNaive, rdx));
                break;
            case AND:
                aasmNaive.add(new AAAnd(destNaive, srcNaive));
                if (destNaive != returnTempNaive) {
                    // means dest is a register, move the result into a temp
                    aasmNaive.add(new AAMove(returnTempNaive, destNaive));
                }
                break;
            case OR:
                aasmNaive.add(new AAOr(destNaive, srcNaive));
                if (destNaive != returnTempNaive) {
                    // means dest is a register, move the result into a temp
                    aasmNaive.add(new AAMove(returnTempNaive, destNaive));
                }
                break;
            case XOR:
                aasmNaive.add(new AAXor(destNaive, srcNaive));
                if (destNaive != returnTempNaive) {
                    // means dest is a register, move the result into a temp
                    aasmNaive.add(new AAMove(returnTempNaive, destNaive));
                }
                break;
            case LSHIFT:
                aasmNaive.add(new AAShl(destNaive, srcNaive));
                if (destNaive != returnTempNaive) {
                    // means dest is a register, move the result into a temp
                    aasmNaive.add(new AAMove(returnTempNaive, destNaive));
                }
                break;
            case RSHIFT:
                aasmNaive.add(new AAShr(destNaive, srcNaive));
                if (destNaive != returnTempNaive) {
                    // means dest is a register, move the result into a temp
                    aasmNaive.add(new AAMove(returnTempNaive, destNaive));
                }
                break;
            case ARSHIFT:
                aasmNaive.add(new AASar(destNaive, srcNaive));
                if (destNaive != returnTempNaive) {
                    // means dest is a register, move the result into a temp
                    aasmNaive.add(new AAMove(returnTempNaive, destNaive));
                }
                break;
            case EQ:
                aasmNaive.add(new AACmp(destNaive, srcNaive));
                aasmNaive.add(new AASetcc(returnTempNaive, AASetcc.Condition.EQ));
                break;
            case NEQ:
                aasmNaive.add(new AACmp(destNaive, srcNaive));
                aasmNaive.add(new AASetcc(returnTempNaive, AASetcc.Condition.NEQ));
                break;
            case LT:
                aasmNaive.add(new AACmp(destNaive, srcNaive));
                aasmNaive.add(new AASetcc(returnTempNaive, AASetcc.Condition.LT));
                break;
            case ULT:
                aasmNaive.add(new AACmp(destNaive, srcNaive));
                aasmNaive.add(new AASetcc(returnTempNaive, AASetcc.Condition.ULT));
                break;
            case GT:
                aasmNaive.add(new AACmp(destNaive, srcNaive));
                aasmNaive.add(new AASetcc(returnTempNaive, AASetcc.Condition.GT));
                break;
            case LEQ:
                aasmNaive.add(new AACmp(destNaive, srcNaive));
                aasmNaive.add(new AASetcc(returnTempNaive, AASetcc.Condition.LEQ));
                break;
            case GEQ:
                aasmNaive.add(new AACmp(destNaive, srcNaive));
                aasmNaive.add(new AASetcc(returnTempNaive, AASetcc.Condition.GEQ));
                break;
            default:
                break;
        }
        tileNaive = new Tile(aasmNaive, neighborsNaive);
        tileNaive.setReturnTemp(returnTempNaive);
        node.setTile(tileNaive);

        return node;
    }


    /**
     * Tile a IR Mem node
     *
     * @param node the node to tile
     * @return node with tile being set
     */
    private IRNode tileMem(IRMem node) {
        List<IRNode> neighborsNaive = new ArrayList<>();
        List<AAInstruction> asmNaive = new ArrayList<>();
        AAOperand addrNaive; // the address
        AAMem mem = new AAMem(); // the final mem = [addrNaive]
        AATemp returnTemp = tempSpiller.newTemp();
        IRExpr addr = node.expr();
        if (addr instanceof IRConst) {
            addrNaive = new AAImm(((IRConst) addr).value());
            mem.setImmediate((AAImm) addrNaive);
            asmNaive.add(new AAMove(rcx, mem));
            asmNaive.add(new AAMove(returnTemp, rcx)); // no neighbors
        } else if (addr instanceof IRTemp) {
            // the content of this temp is our addrNaive
            addrNaive = tempSpiller.newTemp(((IRTemp) addr).name());
            asmNaive.add(new AAMove(rcx, addrNaive)); // move content of temp into a register to be used in mem
            mem.setBase(rcx);
            asmNaive.add(new AAMove(returnTemp, rcx));
        } else {
            addrNaive = addr.getTile().getReturnTemp();
            asmNaive.add(new AAMove(rcx, addrNaive)); // move content of ret temp into a register to be used in mem
            mem.setBase(rcx);
            asmNaive.add(new AAMove(returnTemp, rcx));
            neighborsNaive.add(addr);
        }
        Tile tileNaive = new Tile(asmNaive, neighborsNaive);
        tileNaive.setReturnTemp(returnTemp);

        // optimize for shorthand-ing binop address
        List<IRNode> neighborsOpt = new ArrayList<>();
        List<AAInstruction> asmOpt = new ArrayList<>();
        Tile tileOpt = null;

        if (addr instanceof IRBinOp) {
            BinOpToAddrParams addrParams = binopToAddrMode((IRBinOp) addr);
            AAMem optMem;
            if (addrParams.optimized){
                optMem = addrParams.address;
                asmOpt.addAll(addrParams.assembly);
                asmOpt.add(new AAMove(rcx, optMem));
                asmOpt.add(new AAMove(returnTemp, rcx));
                tileOpt = new Tile(asmOpt, neighborsOpt);
                tileOpt.setReturnTemp(returnTemp);
            } else {
                tileOpt = null; // no optimization
            }
        }

        if (tileOpt != null && tileOpt.getCostOfSubTree() <= tileNaive.getCostOfSubTree()) {
            node.setTile(tileOpt);
        } else {
            node.setTile(tileNaive);
        }

        return node;
    }

    /**
     * Tile a jump stmt IR instruction
     *
     * @param node a jump IR node
     * @return a jump IR node labeled with its tile of assembly
     */
    private IRNode tileJump(IRJump node) {
        List<AAInstruction> aasm = new ArrayList<>();
        aasm.add(new AAJmp(new AALabel(((IRName)node.target()).name())));
        Tile jumpTile = new Tile(aasm, new ArrayList<>());
        node.setTile(jumpTile);
        return node;
    }

    /**
     * Tile a CJump IR instruction
     *
     * @param node a  IR node
     * @return a CJump IR node labeled with its tile of assembly
     */
    private IRNode tileCJump(IRCJump node) {
        List<AAInstruction> aasm = new ArrayList<>();
        List<IRNode> neighbors = new ArrayList<>();
        neighbors.add(node.cond());

        String target = node.trueLabel();
        if (node.cond() instanceof IRBinOp) {
            switch (((IRBinOp) node.cond()).opType()) {
                case XOR:
                    //XOR (binop) (const 1) due to jump reorder
                    if (((IRBinOp) node.cond()).left() instanceof IRBinOp
                            && ((IRBinOp) node.cond()).right() instanceof IRTemp) {
                        switch ((((IRBinOp) ((IRBinOp) node.cond()).left()).opType())) {
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
        } else if (node.cond() instanceof IRTemp) { //true, false IRTemp
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
     *
     * @param node a call stmt IR node
     * @return a call stmt IR node labeled with its tile of assembly
     */
    private IRNode tileCallStmt(IRCallStmt node) {
        String name = ((IRName) node.target()).name();
        long curRetSize = funcRetLengths.get(name);
        long curArgSize = funcArgLengths.get(name);
        boolean aligned = false;

        List<AAInstruction> instructs = new ArrayList<>();

        //save caller saved registers rax, rcx, rdx, rsi, rdi, and r8–r11
        AAReg[] callerRegs = new AAReg[]{rax, rcx, rdx, rsp, rsi, rdi, r8, r9, r10, r11};
        AATemp[] savedRegs = new AATemp[10];
        for (int i = 0; i < 10; i++) {
            savedRegs[i] = tempSpiller.newTemp();
            instructs.add(new AAMove(savedRegs[i], callerRegs[i]));
        }

        long l = curRetSize - 2 + curArgSize - 5;
        if (l % 2 != 0) {
            // alignment for scratch spaces
            aligned = true;
            instructs.add(new AASub(rsp, new AAImm(8L)));
        }

        // allocate scratch spaces for excess return from the callee
        if (curRetSize > 2) {
            instructs.add(new AASub(rsp, new AAImm((curRetSize - 2) * 8)));
        }

        if (curRetSize > 2) {
            // put return address into register rdi
            long offset = max(curArgSize - 5, 0);
            instructs.add(new AAMove(rdi, rsp));
            instructs.add(new AAAdd(rdi, new AAImm(offset * 8)));
            // put first five arguments, not including the return address argument,
            // into corresponding registers if there is any
            AAReg[] argRegs = {rsi, rdx, rcx, r8, r9};
            for (int i = 0; i < min(curArgSize, 5); i++) {
                instructs.add(new AAMove(argRegs[i], node.args().get(i).getTile().getReturnTemp()));
            }
        } else {
            AAReg[] argRegs = {rdi, rsi, rdx, rcx, r8, r9};
            for (int i = 0; i < min(curArgSize, 6); i++) {
                instructs.add(new AAMove(argRegs[i], node.args().get(i).getTile().getReturnTemp()));
            }
        }

        // push any excess args on to stack
        for (long i = curArgSize - 1; i > 4; i--) {
            IRExpr e = node.args().get((int) i);
            instructs.addAll(concatAsm(e));
            instructs.add(new AAPush(e.getTile().getReturnTemp()));
        }

        // store rip on stack, jumps to specific destination
        instructs.add(new AACall(new AALabel(((IRName)node.target()).name())));

        // destroy the scratch space for arguments after call
        instructs.add(new AAAdd(rsp, new AAImm(max(curArgSize - 5, 0) * 8L)));

        // put the first two returns into RV temps if there is any
        if (curRetSize >= 1) {
            instructs.add(new AAMove(tempSpiller.newTemp("_RV1"), rax));
        }
        if (curRetSize >= 2) {
            instructs.add(new AAMove(tempSpiller.newTemp("_RV2"), rdx));
        }

        // pop excess returns into RV temps
        for (int i = 0; i < curRetSize - 2; i++) {
            instructs.add(new AAPop(tempSpiller.newTemp("_RV" + (i + 3))));
        }

        // remove any alignment
        if (aligned) {
            instructs.add(new AAAdd(rsp, new AAImm(8L)));
        }

        //restore caller saved registers
        for (int i = 0; i < callerRegs.length; i++) {
            instructs.add(new AAMove(callerRegs[i], savedRegs[i]));
        }

        Tile callStmtTile = new Tile(instructs, new ArrayList<>());
        node.setTile(callStmtTile);
        return node;
    }


    /**
     * This is an record that contains the information gathered as we translate a binop into memory operand form.
     * It contains:
     * - address: the translated address,
     * - assembly: the assembly instructions needed for the address to work with the original binop,
     * - whether the binop can be optimized into a memory operand, and,
     * - returnTemp: for the case when the binop is checked for a possible lea, the place where the result
     * of the lea should be returned to
     */
    private static class BinOpToAddrParams {
        public AAMem address;
        public List<AAInstruction> assembly;
        public boolean optimized;


        public BinOpToAddrParams(AAMem addr, List<AAInstruction> asm) {
            address = addr;
            assembly = asm;
            optimized = (addr != null);
        }

    }

    /**
     * A helper function that determines if a binop expression can be shortened into a single mem operand
     * and carry out the shortening if possible.
     *
     * @return a record that contains the translated address and other useful information
     */
    private BinOpToAddrParams binopToAddrMode(IRBinOp node) {
        // base = rcx
        // index = rsi

        List<AAInstruction> aasm = new ArrayList<>();
        AAMem finalAddr = null;

        Set<Long> validScales = new HashSet<>();
        validScales.add((long) 1);
        validScales.add((long) 2);
        validScales.add((long) 4);
        validScales.add((long) 8);

        AAReg base;
        AAReg index;
        long scale;

        IRNode left = node.left();
        IRNode right = node.right();

        // binop looks like a + b * c --> do not know which of b/c is scale/index yet
        if (left instanceof IRTemp
                && right instanceof IRBinOp
                && ((IRBinOp) right).opType() == IRBinOp.OpType.MUL) {
            // left temp is the base and dest (for lea)
            // mov left into rax = base
            AATemp leftTemp = tempSpiller.newTemp((((IRTemp) left).name()));
            aasm.add(new AAMove(rcx, leftTemp));
            base = rcx;

            IRNode rLeft = ((IRBinOp) right).left();
            IRNode rRight = ((IRBinOp) right).right();
            // base + scale * index
            if (rLeft instanceof IRConst
                    && validScales.contains(((IRConst) rLeft).value())
                    && rRight instanceof IRTemp) {
                // mov rRight into rbx = index
                aasm.add(new AAMove(rsi, tempSpiller.newTemp(((IRTemp) rRight).name())));
                index = rsi;
                scale = ((IRConst) rLeft).value();
                finalAddr = new AAMem();
                finalAddr.setBase(base);
                finalAddr.setScale(scale);
                finalAddr.setIndex(index);
            }
            // base + index * scale
            else if (rRight instanceof IRConst
                    && validScales.contains(((IRConst) rRight).value())
                    && rLeft instanceof IRTemp) {
                // mov rLeft into rbx = index
                aasm.add(new AAMove(rsi, tempSpiller.newTemp(((IRTemp) rLeft).name())));
                index = rsi;
                scale = ((IRConst) rRight).value();
                finalAddr = new AAMem();
                finalAddr.setBase(base);
                finalAddr.setScale(scale);
                finalAddr.setIndex(index);
            }

        }

        // looks like a * b + c
        else if (right instanceof IRTemp
                && left instanceof IRBinOp
                && ((IRBinOp) left).opType() == IRBinOp.OpType.MUL) {
            // base and dest is now c which is right
            AATemp rightTemp = tempSpiller.newTemp((((IRTemp) right).name()));
            aasm.add(new AAMove(rcx, rightTemp));
            base = rcx;

            IRNode lLeft = ((IRBinOp) left).left();
            IRNode lRight = ((IRBinOp) left).right();

            // scale * index + base
            if (lLeft instanceof IRConst
                    && validScales.contains(((IRConst) lLeft).value())
                    && lRight instanceof IRTemp) {
                // mov lRight into rbx = index
                aasm.add(new AAMove(rsi, tempSpiller.newTemp(((IRTemp) lRight).name())));
                index = rsi;
                scale = ((IRConst) lLeft).value();
                finalAddr = new AAMem();
                finalAddr.setBase(base);
                finalAddr.setScale(scale);
                finalAddr.setIndex(index);

            }
            // index * scale + base
            else if (lRight instanceof IRConst
                    && validScales.contains(((IRConst) lRight).value())
                    && lLeft instanceof IRTemp) {
                // mov rLeft into rbx = index
                aasm.add(new AAMove(rsi, tempSpiller.newTemp(((IRTemp) lLeft).name())));
                index = rsi;
                scale = ((IRConst) lRight).value();
                finalAddr = new AAMem();
                finalAddr.setBase(base);
                finalAddr.setScale(scale);
                finalAddr.setIndex(index);

            }

        }

        return new BinOpToAddrParams(finalAddr, aasm);
    }


}
