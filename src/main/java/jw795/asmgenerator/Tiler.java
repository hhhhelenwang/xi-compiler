package jw795.asmgenerator;

import edu.cornell.cs.cs4120.xic.ir.*;
import edu.cornell.cs.cs4120.xic.ir.visit.IRVisitor;
import jw795.assembly.*;
import jw795.optimizer.RegisterAllocator;

import java.util.*;

import static java.lang.Math.min;

/**
 * A visitor that traverse an IR tree and translate IR into tiles of abstract assembly.
 */
public class Tiler extends IRVisitor {
    HashMap<String, Long> funcArgLengths;
    HashMap<String, Long> funcRetLengths;

    String[] argNames = new String[6];

    public static AAReg rax = new AAReg("rax");
    public static AAReg rbx = new AAReg("rbx");
    public static AAReg rcx = new AAReg("rcx");
    public static AAReg rdx = new AAReg("rdx");
    public static AAReg rsp = new AAReg("rsp");
    public static AAReg rbp = new AAReg("rbp");
    public static AAReg rsi = new AAReg("rsi");
    public static AAReg rdi = new AAReg("rdi");
    public static AAReg r8 = new AAReg("r8");
    public static AAReg r9 = new AAReg("r9");
    public static AAReg r10 = new AAReg("r10");
    public static AAReg r11 = new AAReg("r11");
    public static AAReg r12 = new AAReg("r12");
    public static AAReg r13 = new AAReg("r13");
    public static AAReg r14 = new AAReg("r14");
    public static AAReg r15 = new AAReg("r15");
    public static AAReg rip = new AAReg("rip");

    public static AAReg sil = new AAReg("sil"); // lowest byte of rsi

    public TempSpiller tempSpiller;

    AADynamic spillAndAlign;

    boolean regAlloc;

    public Tiler(IRNodeFactory inf,
                 TempSpiller tsp,
                 HashMap<String, Long> funcArg,
                 HashMap<String, Long> funcRet,
                 HashMap<String, String> names,
                 boolean regAlloc) {

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

        spillAndAlign = new AADynamic();
        this.regAlloc = regAlloc;
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
        long curRetSize = funcRetLengths.get(name);
        long curArgSize = funcArgLengths.get(name);
        boolean excessArg = false;
        boolean excessRet = false;
        long argScratchSize = 0L;

        if (curRetSize > 2) {
            if (curArgSize > 5) {
                argScratchSize = curArgSize - 5;
                excessArg = true;
            }
            excessRet = true;
        } else {
            if (curArgSize > 6) {
                argScratchSize = curArgSize - 6;
                excessArg = true;
            }
        }

        List<AAInstruction> asm = new ArrayList<>();
        asm.add(new AADirective(AADirective.DirType.TEXT));
        asm.add(new AADirective(AADirective.DirType.GLOBAL, name));
        asm.add(new AALabelInstr(name));

        // push return address onto stack, if there isn't any, leave empty
        if(excessRet) {
            asm.add(new AAPush(rdi));
        } else {
            asm.add(new AASub(rsp, new AAImm(8L)));
        }

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
        if (excessRet) {
            AAReg[] argRegs = new AAReg[]{rsi, rdx, rcx, r8, r9};
            if (excessArg) {
                for (long i = 0L; i < 5; i++) {
                    asm.add(new AAMove(tempSpiller.newTemp("_ARG" + (i + 1)), argRegs[(int) i]));
                }
                for (long i = 0L; i < argScratchSize; i++) {
                    long index = i + 2;
                    AAMem mem = new AAMem();
                    mem.setBase(rbp);
                    mem.setImmediate(new AAImm(index * 8L));
                    asm.add(new AAMove(rax, mem));
                    asm.add(new AAMove(tempSpiller.newTemp("_ARG" + (i + 6)), rax));
                }
            } else {
                for (long i = 0L; i < curArgSize; i++) {
                    asm.add(new AAMove(tempSpiller.newTemp("_ARG" + (i + 1)), argRegs[(int) i]));
                }
            }
        } else {
            AAReg[] argRegs = new AAReg[]{rdi, rsi, rdx, rcx, r8, r9};
            if (excessArg) {
                for (long i = 0L; i < 6; i++) {
                    asm.add(new AAMove(tempSpiller.newTemp("_ARG" + (i + 1)), argRegs[(int) i]));
                }
                for (long i = 0L; i < argScratchSize; i++) {
                    long index = i + 2;
                    AAMem mem = new AAMem();
                    mem.setBase(rbp);
                    mem.setImmediate(new AAImm(index * 8L));
                    asm.add(new AAMove(rax, mem));
                    asm.add(new AAMove(tempSpiller.newTemp("_ARG" + (i + 7)), rax));
                }
            } else {
                for (long i = 0L; i < curArgSize; i++) {
                    asm.add(new AAMove(tempSpiller.newTemp("_ARG" + (i + 1)), argRegs[(int) i]));
                }
            }

        }

        // allocate space for spilled temps + alignment for all the function calls
        asm.add(new AASub(rsp, spillAndAlign));

        // add body's asm to fundecl's asm
        asm.addAll(concatAsm(body));

        long val;

        if (regAlloc) {
            RegisterAllocator regAlloc = new RegisterAllocator(asm, tempSpiller);
            regAlloc.registerAllocate();
            List<AAInstruction> optAsm = regAlloc.allocateAndRemove();
            node.setTile(new Tile(optAsm, new ArrayList<>()));
            val = tempSpiller.tempCounter * 8L;
        } else {
            node.setTile(new Tile(asm, new ArrayList<>()));
            val = spill(node, tempSpiller) * 8L;
        }

        if (val % 16 == 0) {
            val += 8;
        }
        spillAndAlign.setVal(val);

        // reset temp spiller and spillAndAlign for the next fundecl to use
        tempSpiller = new TempSpiller();
        spillAndAlign = new AADynamic();

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
    private long spill(IRNode node, TempSpiller tmpsp) {
        Tile cur = node.getTile();
        for (IRNode irn : cur.getNeighborIRs()) {
            spill(irn, tmpsp);
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

        asm.add(new AAAdd(rsp, spillAndAlign));
        //restore callee-saved registers
        asm.add(new AAPop(r15));
        asm.add(new AAPop(r14));
        asm.add(new AAPop(r13));
        asm.add(new AAPop(r12));
        asm.add(new AAPop(rbx));
        asm.add(new AAPop(rbp));
        asm.add(new AAAdd(rsp, new AAImm(8L)));
        asm.add(new AARet());

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
        ArrayList<AAInstruction> asmNaive = new ArrayList<>();

        IRNode target = node.target();
        IRNode source = node.source();

        if (target instanceof IRMem) {
            // the dest *address* of this move is the expression of target
            // so we need to make an AAMem from that value
            IRExpr destAddr = ((IRMem) target).expr();
            AATemp destAddrTemp = destAddr.getTile().getReturnTemp();
            asmNaive.add(new AAMove(rcx, destAddrTemp)); // now rcx holds the address
            AAMem destMem = new AAMem();
            destMem.setBase(rcx); // create a mem with that address
            destNaive = destMem;
            neighborsNaive.add(destAddr);
        } else { // should be a temp
            destNaive = tempSpiller.newTemp(((IRTemp) target).name());
        }

        if (source instanceof IRTemp) {
            srcNaive = tempSpiller.newTemp(((IRTemp) source).name());
            asmNaive.add(new AAMove(rsi, srcNaive));
            asmNaive.add(new AAMove(destNaive, rsi));
        } else if (source instanceof IRConst) {
            srcNaive = new AAImm(((IRConst) source).value());
            asmNaive.add(new AAMove(destNaive, srcNaive));
        } else {
//            System.out.println(node);
//            System.out.println("here");
            srcNaive = source.getTile().getReturnTemp();
            asmNaive.add(new AAMove(rsi, srcNaive));
            asmNaive.add(new AAMove(destNaive, rsi));
            neighborsNaive.add(source);
        }

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
        // target = temp, source = temp --> no optimization, use naive
        AAOperand destOpt;
        AAOperand srcOpt;
        List<AAInstruction> asmOpt = new ArrayList<>();
        List<IRNode> neighborsOpt = new ArrayList<>();
        Tile tileOpt = null;
        if (target instanceof IRMem && source instanceof IRMem) {
            // check on source
            srcOpt = getOptMem((IRMem) source, asmOpt, neighborsOpt, false);
            // since both target and source are mem, mov to a register in between
            asmOpt.add(new AAMove(rdi, srcOpt)); // optimized binop uses rax and rbx so use rdx to avoid conflict
            // check on target
            destOpt = getOptMem((IRMem) target, asmOpt, neighborsOpt, true);
            asmOpt.add(new AAMove(destOpt, rdi));
            tileOpt = new Tile(asmOpt, neighborsOpt);
        } else if (target instanceof IRTemp && source instanceof IRMem) {
            // target is a temp, use it directly
            destOpt = tempSpiller.newTemp(((IRTemp) target).name());
            // check on source
            srcOpt = getOptMem((IRMem) source, asmOpt, neighborsOpt, false);
            asmOpt.add(new AAMove(rdi, srcOpt)); // optimized binop uses rcx and rsi so use rdi to avoid conflict
            asmOpt.add(new AAMove(destOpt, rdi));
            tileOpt = new Tile(asmOpt, neighborsOpt);
        } else if (target instanceof IRMem && source instanceof IRTemp) {
            // check on target
            destOpt = getOptMem((IRMem) target, asmOpt, neighborsOpt, true);
            // source is a temp, use it directly
            srcOpt = tempSpiller.newTemp(((IRTemp) source).name());
            asmOpt.add(new AAMove(rdi, srcOpt)); // optimized binop uses rax and rbx so use rdx to avoid conflict
            asmOpt.add(new AAMove(destOpt, rdi));
            tileOpt = new Tile(asmOpt, neighborsOpt);
        }

//        else if (target instanceof IRTemp && source instanceof IRConst){
//            asmOpt.add(new AAMove(tempSpiller.newTemp(((IRTemp) target).name()),
//                            new AAImm (((IRConst) source).value())));
//            tileOpt = new Tile(asmOpt,neighborsOpt);
//        }

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

//        System.out.println(best);

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
    private AAOperand getOptMem(IRMem oldOpr, List<AAInstruction> asmOpt, List<IRNode> neighborsOpt, boolean isTarget) {
        AAOperand optOpr;
        IRExpr targetAddr = oldOpr.expr();
        if (targetAddr instanceof IRBinOp) {
            BinOpToAddrParams targetAddrParams = binopToAddrMode((IRBinOp) targetAddr);
            if (targetAddrParams.optimized) {
                optOpr = targetAddrParams.address;
                asmOpt.addAll(targetAddrParams.assembly);
            } else {
                if (isTarget) {
                    AATemp destAddrTemp = oldOpr.expr().getTile().getReturnTemp();
                    asmOpt.add(new AAMove(rcx, destAddrTemp)); // now rcx holds the address
                    AAMem destMem = new AAMem();
                    destMem.setBase(rcx); // create a mem with that address
                    optOpr = destMem;
                    neighborsOpt.add(oldOpr.expr());
                } else {
                    optOpr = oldOpr.expr().getTile().getReturnTemp();
                    neighborsOpt.add(oldOpr);
                }
            }
        } else {
            if (isTarget) {
                AATemp destAddrTemp = oldOpr.expr().getTile().getReturnTemp();
                asmOpt.add(new AAMove(rcx, destAddrTemp)); // now rcx holds the address
                AAMem destMem = new AAMem();
                destMem.setBase(rcx); // create a mem with that address
                optOpr = destMem;
                neighborsOpt.add(oldOpr.expr());
            } else {
                optOpr = oldOpr.expr().getTile().getReturnTemp();
                neighborsOpt.add(oldOpr);
            }
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
                // move left constant into a register
                aasmNaive.add(new AAMove(rcx, new AAImm(((IRConst) left).value())));
                returnTempNaive = tempSpiller.newTemp(); // a fresh temp for return
                destNaive = rcx;
                srcNaive = tempSpiller.newTemp(((IRTemp) right).name()); // right temp is src

            } else {
                // move left const into a register
                aasmNaive.add(new AAMove(rcx, new AAImm(((IRConst) left).value())));
                returnTempNaive = tempSpiller.newTemp(); // fresh return temp

                Tile rightTile = right.getTile();
                AATemp rightTemp = rightTile.getReturnTemp();
                destNaive = rcx; // dest is rcx which holds the constant
                srcNaive = rightTemp; // right return temp is src
                neighborsNaive.add(right); // since we use right's return temp add it to neighbors

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
                // result in rax
                // dividend for an 8-byte divisor is put in rdx + rax,
                // rdx = 63-32 bit, rax = 31-0 bit
                aasmNaive.add(new AAMove(rax, destNaive));
                // sign extend rax to rdx by copying rax to rdx and arithmetic right shift rdx by 63 bits
                aasmNaive.add(new AAMove(rdx, rax));
                aasmNaive.add(new AASar(rdx, new AAImm(63)));
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
                // dividend for an 8-byte divisor is put in rdx + rax,
                // rdx = 63-32 bit, rax = 31-0 bit
                // result in rax
                aasmNaive.add(new AAMove(rax, destNaive));
                // sign extend rax to rdx by copying rax to rdx and arithmetic right shift rdx by 63 bits
                aasmNaive.add(new AAMove(rdx, rax));
                aasmNaive.add(new AASar(rdx, new AAImm(63)));
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
                aasmNaive.add(new AAXor(rsi, rsi));
                aasmNaive.add(new AACmp(destNaive, srcNaive));
                // Fun fact: Setcc sets a *byte* according if the cc flag is set in the previous cmp instruction,
                // but we use qword through out. Setcc will only set the lowest byte of the qword and therefore
                // if there is anything left in the higher bytes it can mess with the result. So we need to clear
                // rcx, set the cl (the lowest byte of rcx) to hold the result, and move the result to return temp
                aasmNaive.add(new AASetcc(sil, AASetcc.Condition.EQ));
                aasmNaive.add(new AAMove(returnTempNaive, rsi));
                break;
            case NEQ:
                aasmNaive.add(new AAXor(rsi, rsi));
                aasmNaive.add(new AACmp(destNaive, srcNaive));
                aasmNaive.add(new AASetcc(sil, AASetcc.Condition.NEQ));
                aasmNaive.add(new AAMove(returnTempNaive, rsi));
                break;
            case LT:
                aasmNaive.add(new AAXor(rsi, rsi));
                aasmNaive.add(new AACmp(destNaive, srcNaive));
                aasmNaive.add(new AASetcc(sil, AASetcc.Condition.LT));
                aasmNaive.add(new AAMove(returnTempNaive, rsi));
                break;
            case ULT:
                aasmNaive.add(new AAXor(rsi, rsi));
                aasmNaive.add(new AACmp(destNaive, srcNaive));
                aasmNaive.add(new AASetcc(sil, AASetcc.Condition.ULT));
                aasmNaive.add(new AAMove(returnTempNaive, rsi));
                break;
            case GT:
                aasmNaive.add(new AAXor(rsi, rsi));
                aasmNaive.add(new AACmp(destNaive, srcNaive));
                aasmNaive.add(new AASetcc(sil, AASetcc.Condition.GT));
                aasmNaive.add(new AAMove(returnTempNaive, rsi));
                break;
            case LEQ:
                aasmNaive.add(new AAXor(rsi, rsi));
                aasmNaive.add(new AACmp(destNaive, srcNaive));
                aasmNaive.add(new AASetcc(sil, AASetcc.Condition.LEQ));
                aasmNaive.add(new AAMove(returnTempNaive, rsi));
                break;
            case GEQ:
                aasmNaive.add(new AAXor(rsi, rsi));
                aasmNaive.add(new AACmp(destNaive, srcNaive));
                aasmNaive.add(new AASetcc(sil, AASetcc.Condition.GEQ));
                aasmNaive.add(new AAMove(returnTempNaive, rsi));
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
            asmNaive.add(new AAMove(rsi, mem));
            asmNaive.add(new AAMove(returnTemp, rsi));

        } else {
            addrNaive = addr.getTile().getReturnTemp();
            asmNaive.add(new AAMove(rcx, addrNaive)); // move content of ret temp into a register to be used in mem
            mem.setBase(rcx);
            asmNaive.add(new AAMove(rsi, mem));
            asmNaive.add(new AAMove(returnTemp, rsi));
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

        String target = node.trueLabel();
        if (node.cond() instanceof IRBinOp) {
            switch (((IRBinOp) node.cond()).opType()) {
                case XOR:
                    if (((IRBinOp) node.cond()).left() instanceof IRBinOp
                            && ((IRBinOp) node.cond()).right() instanceof IRConst
                            && (((IRBinOp) node.cond()).right()).constant() == 1L) {
                        neighbors.add(((IRBinOp) node.cond()).left());
                        switch ((((IRBinOp) ((IRBinOp) node.cond()).left()).opType())) {
                            case EQ:
                                aasm.add(new AAJne(new AALabel(target)));
                                break;
                            case NEQ:
                                aasm.add(new AAJe(new AALabel(target)));
                                break;
                            case LT:
                                aasm.add(new AAJge(new AALabel(target)));
                                break;
                            case ULT:
                                aasm.add(new AAJae(new AALabel(target)));
                                break;
                            case GT:
                                aasm.add(new AAJle(new AALabel(target)));
                                break;
                            case LEQ:
                                aasm.add(new AAJg(new AALabel(target)));
                                break;
                            case GEQ:
                                aasm.add(new AAJl(new AALabel(target)));
                                break;
                            default:
                                break;
                        }
                    } else {
                        neighbors.add(node.cond());
                        aasm.add(new AACmp(node.cond().getTile().getReturnTemp(), new AAImm(1)));
                        aasm.add(new AAJe(new AALabel(target)));
                    }
                    break;
                case AND:
                case OR:
                    neighbors.add(node.cond());
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
            neighbors.add(node.cond());
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
        boolean excessArg = false;
        boolean excessRet = false;
        boolean aligned = false;
        long retScratchSize = 0L;
        long argScratchSize = 0L;

        if (curRetSize > 2) {
            if (curArgSize > 5) {
                argScratchSize = curArgSize - 5;
                retScratchSize = curRetSize - 2;
                excessArg = true;
            } else {
                retScratchSize = curRetSize - 2;
            }
            excessRet = true;
        } else {
            if (curArgSize > 6) {
                argScratchSize = curArgSize - 6;
                excessArg = true;
            }
        }

        List<AAInstruction> instructs = new ArrayList<>();

        //save caller saved registers rax, rcx, rdx, rsi, rdi, and r8–r11
        AAReg[] callerRegs = new AAReg[]{rax, rcx, rdx, rsp, rsi, rdi, r8, r9, r10, r11};
        AATemp[] savedRegs = new AATemp[10];
        for (int i = 0; i < 10; i++) {
            savedRegs[i] = tempSpiller.newTemp();
            instructs.add(new AAMove(savedRegs[i], callerRegs[i]));
        }

        // total scratch space, number of quad
        long l = retScratchSize + argScratchSize;

        if (l % 2 != 0) {
            // alignment for scratch spaces
            aligned = true;
            instructs.add(new AASub(rsp, new AAImm(8L)));
        }

        // allocate scratch spaces for excess return from the callee and put arguments into registers
        if (excessRet) {
            instructs.add(new AASub(rsp, new AAImm(retScratchSize * 8)));
            // put return address into register rdi
            instructs.add(new AAMove(rdi, rsp));
            // put first five arguments into corresponding registers if there is any
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
        if (excessArg) {
            if (excessRet) {
                for (long i = curArgSize - 1; i > 4; i--) {
                    IRExpr e = node.args().get((int) i);
                    instructs.add(new AAPush(e.getTile().getReturnTemp()));
                }
            } else {
                for (long i = curArgSize - 1; i > 5; i--) {
                    IRExpr e = node.args().get((int) i);
                    instructs.add(new AAPush(e.getTile().getReturnTemp()));
                }
            }
        }

        // store rip on stack, jumps to specific destination
        instructs.add(new AACall(new AALabel(((IRName)node.target()).name())));

        // destroy the scratch space for arguments after call
        if (excessArg) {
            instructs.add(new AAAdd(rsp, new AAImm(argScratchSize * 8L)));
        }
        // put the first two returns into RV temps if there is any
        if (curRetSize >= 1) {
            instructs.add(new AAMove(tempSpiller.newTemp("_RV1"), rax));
        }
        if (curRetSize >= 2) {
            instructs.add(new AAMove(tempSpiller.newTemp("_RV2"), rdx));
        }

        // pop excess returns into RV temps
        if (excessRet) {
            for (int i = 0; i < retScratchSize; i++) {
                instructs.add(new AAPop(tempSpiller.newTemp("_RV" + (i + 3))));
            }
        }

        // remove any alignment
        if (aligned) {
            instructs.add(new AAAdd(rsp, new AAImm(8L)));
        }

        //restore caller saved registers
        for (int i = 0; i < callerRegs.length; i++) {
            instructs.add(new AAMove(callerRegs[i], savedRegs[i]));
        }

        Tile callStmtTile = new Tile(instructs, new ArrayList<>(node.args()));
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