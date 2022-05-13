package jw795.irgenerator;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import edu.cornell.cs.cs4120.xic.ir.*;

import java.util.*;

public class IRLower {

    /**
     * An intermediate data structure to represent the pair S;e, where S is a vector of *canonical* IR
     * statements that captures the side effects of evaluating e. All IR expression lowers to an SEPair.
     */
    static class SEPair extends IRExpr_c {
        public List<IRStmt> sideEffects;
        public IRExpr value;

        public SEPair(List<IRStmt> s, IRExpr val) {
            sideEffects = s;
            value = val;
        }

        @Override
        public String label() {
            return null;
        }

        @Override
        public void printSExp(SExpPrinter p) {
            // nothing to print
        }

        @Override
        public HashSet<IRTemp> vars() {
            // should not be called
            System.out.println("SEPair in cfg");
            return new HashSet<>();
        }
    }

    /**
     * A tool to generate a name for a fresh temporary.
     */
    static class TempGenerator {
        int tempCounter;
        String name;

        TempGenerator() {
            tempCounter = -1;
            name = "t_lower";
        }

        /**
         * @return a name for a fresh temp
         */
        String newTemp() {
            tempCounter ++;
            return name + tempCounter;
        }

    }

    public IRNodeFactory_c irFactory;
    public TempGenerator tempGenerator;

    public IRLower() {
        irFactory = new IRNodeFactory_c();
        tempGenerator = new TempGenerator();
    }

    /**
     * Lower a program in High-level IR into low-level IR.
     * @param node the program/interface in HIR
     * @return program in LIR
     */
    public IRCompUnit lower(IRCompUnit node) {
        Map<String, IRFuncDecl> functions = node.functions();
        Map<String, IRFuncDecl> loweredFunctions = new HashMap<>();
        // lower functions
        for (Map.Entry<String, IRFuncDecl> entry : functions.entrySet()) {
            IRFuncDecl function = entry.getValue();
            IRStmt lowerdBody = lowerStmt(function.body());
            IRFuncDecl loweredFunction = irFactory.IRFuncDecl(function.name(), lowerdBody);
            loweredFunctions.put(entry.getKey(), loweredFunction);
        }
        // put the data defined in the original IR program into the lowered program
        IRCompUnit loweredProgram = irFactory.IRCompUnit(node.name(), loweredFunctions);
        for (Map.Entry<String, IRData> dataEntry: node.dataMap().entrySet()) {
            loweredProgram.appendData(dataEntry.getValue());
        }

        return loweredProgram;
    }

    /**
     * L[e]: lower an IR expression.
     * @param node not lowered IR expression
     * @return lowered IR expression
     */
    public SEPair lowerExpr(IRExpr node) {
        // match the node against all IR expressions
        if (node instanceof IRConst) {
            return lowerConst((IRConst) node);
        } else if (node instanceof IRName) {
            return lowerName((IRName) node);
        } else if (node instanceof IRTemp) {
            return lowerTemp((IRTemp) node);
        }
        // other expressions
        else if (node instanceof IRBinOp) {
            return lowerBiNop((IRBinOp) node);
        } else if (node instanceof IRCall) {
            return lowerCall((IRCall) node);
        } else if (node instanceof IRMem) {
            return lowerMem((IRMem) node);
        } else if (node instanceof IRESeq) {
            return lowerESeq((IRESeq) node);
        } else {
            System.out.println("unhandle lower expr class");
            return null;
        }
    }

    /**
     * L[CONST(n)]: lower an IR constant expression
     * @param node IR const
     * @return lowered IR const
     */
    public SEPair lowerConst(IRConst node) {
        return new SEPair(new ArrayList<>(), node);
    }

    /**
     * L[Name(e)]: lower name expression
     * @param node name expression
     * @return lowered name expression
     */
    public SEPair lowerName(IRName node) {
        return new SEPair(new ArrayList<>(), node);
    }

    /**
     * L[Temp(e)]: lower temporary variable expression
     * @param node temp node
     * @return lowered temp node
     */
    public SEPair lowerTemp(IRTemp node) {
        return new SEPair(new ArrayList<>(), node);
    }

    /**
     * L[e1 op e2]: lower an BinOp expression.
     * @param node not-lowered IR BiNop expression
     * @return lowered IR BiNop expression
     */
    public SEPair lowerBiNop(IRBinOp node) {
        SEPair pair1 = lowerExpr(node.left());
        SEPair pair2 = lowerExpr(node.right());
        List<IRStmt> sides = new ArrayList<>();
        if (commute(pair1, pair2)) {
            sides.addAll(pair1.sideEffects);
            sides.addAll(pair2.sideEffects);
            return new SEPair(sides, irFactory.IRBinOp(node.opType(), pair1.value, pair2.value));
        } else {
            sides.addAll(pair1.sideEffects);

            IRTemp temp = irFactory.IRTemp(tempGenerator.newTemp());
            sides.add(irFactory.IRMove(temp, pair1.value));
            sides.addAll(pair2.sideEffects);

            return new SEPair(sides, irFactory.IRBinOp(node.opType(), temp, pair2.value));
        }
    }


    /**
     * L[Call(f, e1, ..., en)]: lower an IR function call expression. Evaluates to the pair (S; e) where
     * S = vector of s_i that captures the side-effect of the function call. Call(f, e1, ..., en) should
     * only has one return value.
     * @param node IRCall node
     * @return lowered IRCall with side effects hoisted out and e' = the returned value
     */
    public SEPair lowerCall(IRCall node) {
        SEPair lowerArg;
        List<IRStmt> sideOfArg; // side effect of an argument
        IRExpr valOfArg; // the value expression of the argument, without side effects

        List<IRStmt> sideOfCall = new ArrayList<>(); // all of the side effects of the call
        List<IRExpr> argTemps = new ArrayList<>();
        for (IRExpr arg : node.args()) {
            lowerArg = lowerExpr(arg);
            sideOfArg = lowerArg.sideEffects;
            valOfArg = lowerArg.value;
            sideOfCall.addAll(sideOfArg); // add side effect of argument to the overall side effects

            IRTemp argTemp = irFactory.IRTemp(tempGenerator.newTemp());
            argTemps.add(argTemp);
            sideOfCall.add(irFactory.IRMove(argTemp, valOfArg)); // add MOVE(ti, e') as a side effect
        }

        IRCallStmt callStmt = irFactory.IRCallStmt(node.target(), (long) 1, argTemps);
        IRTemp temp_t = irFactory.IRTemp(tempGenerator.newTemp());
        IRMove moveRetVal = irFactory.IRMove(temp_t, irFactory.IRTemp("_RV1"));
        sideOfCall.add(callStmt);
        sideOfCall.add(moveRetVal);

        return new SEPair(sideOfCall, temp_t);
    }

    /**
     * L[Mem(e)]: lower an IR mem expression
     * @param node not lowered IR mem expression
     * @return lowered mem expression
     */
    public SEPair lowerMem(IRMem node) {
        SEPair lowerE = lowerExpr(node.expr()); // returns an SEPair
        List<IRStmt> sideEffects = lowerE.sideEffects;

        return new SEPair(sideEffects, irFactory.IRMem(lowerE.value));
    }

    /**
     * L[ESeq(s, e)]: lower an IR ESeq expression.
     * @param node ESeq expression
     * @return pair of s and e
     */
    public SEPair lowerESeq(IRESeq node) {
        IRStmt sideOfESeq = lowerStmt(node.stmt());
        SEPair lowerESeq = lowerExpr(node.expr());
        List<IRStmt> sideOfE= lowerESeq.sideEffects;
        IRExpr exprVal = lowerESeq.value;
        sideOfE.add(sideOfESeq);

        return new SEPair(sideOfE, exprVal);
    }

    /**
     * L[s]: lower an IR statement into a sequence of statements.
     * @param node not lowered IR statement
     * @return an IRSeq that represent the lowered statement
     */
    public IRSeq lowerStmt(IRStmt node) {
        if (node instanceof IRSeq) {
            return lowerSeq((IRSeq) node);
        } else if (node instanceof IRExp) {
            return lowerExp((IRExp) node);
        } else if (node instanceof IRJump) {
            return lowerJump((IRJump) node);
        } else if (node instanceof IRCJump) {
            return lowerCJump((IRCJump) node);
        } else if (node instanceof IRLabel) {
            return lowerLabel((IRLabel) node);
        } else if (node instanceof IRMove) {
            return lowerMove((IRMove) node);
        } else if (node instanceof IRReturn) {
            return lowerReturn((IRReturn) node);
        } else if (node instanceof IRCallStmt) {
            return lowerCallStmt((IRCallStmt) node);
        }
        return null;
    }

    /**
     * L[Seq(s1, ..., sn)]: lower an IR sequence. Lowers s1, .., sn into sequences and flattens
     * them into a large top-level sequence.
     * @param node an IRSeq sequence
     * @return a single IRSeq node that contains all statements resulted from lowering s1, ..., s2
     */
    public IRSeq lowerSeq(IRSeq node) {
        List<IRStmt> sequence = new ArrayList<>(); // the list of stmts that form the one large result sequence
        for (IRStmt stmt : node.stmts()) {
            sequence.addAll(flattenSeq(lowerStmt(stmt)));
        }
        return irFactory.IRSeq(sequence);
    }

    /**
     * L[EXP(e)]: lower an IR Exp to extract the statement and throw away the expression.
     * @param node IRExp node
     * @return IRSeq that contains the statement in node
     */
    public IRSeq lowerExp(IRExp node) {
        SEPair lowerE = lowerExpr(node.expr()); // get the side effect of evaluating e
        return irFactory.IRSeq(lowerE.sideEffects);

    }

    /**
     * L[Jump(e)]: lower an IRJump stmt into a sequence of side effects of e followed by a Jump to the lowered e'
     * @param node IRJump stmt
     * @return lowered Jump stmt
     */
    public IRSeq lowerJump(IRJump node) {
        SEPair lowerE = lowerExpr(node.target());
        List<IRStmt> seq = lowerE.sideEffects;
        seq.add(irFactory.IRJump(lowerE.value));
        return irFactory.IRSeq(seq);
    }

    /**
     * L[CJump(e)]: lower an IRCJump stmt into a sequence of side effects of e followed by a CJump to the lowered e'
     * @param node IRCJump node
     * @return lowered CJump stmt
     */
    public IRSeq lowerCJump(IRCJump node) {
        SEPair lowerE = lowerExpr(node.cond());
        List<IRStmt> seq = lowerE.sideEffects;
        seq.add(irFactory.IRCJump(lowerE.value, node.trueLabel(), node.falseLabel()));
        return irFactory.IRSeq(seq);
    }

    /**
     * L[Label(l)]: lower an IRLabel stmt by giving back the same stmt and wrapping the stmt into an IRSeq.
     * @param node IRLabel node
     * @return lowered IRLabel
     */
    public IRSeq lowerLabel(IRLabel node) {
        return irFactory.IRSeq(node);
    }

    /**
     * L[Move(dest, e)]: lower the move statement
     * @param node Move node
     * @return lowered move
     */
    public IRSeq lowerMove(IRMove node) {
        // if the target is a temp, hoist out the side effect s and append it in front of a Move to e'
        if (node.target() instanceof IRTemp) {
            SEPair lowerE = lowerExpr(node.source());
            List<IRStmt> seq = lowerE.sideEffects;
            seq.add(irFactory.IRMove(node.target(), lowerE.value));
            return irFactory.IRSeq(seq);
        } else { // target is a memory location
            // otherwise, check if e2's side effects can affect dest in Move(dest, e2)
            SEPair destPair = lowerExpr(node.target());
            SEPair exprPair = lowerExpr(node.source());
            if (commute(destPair, exprPair)) { // move-commuting
                List<IRStmt> seq = new ArrayList<>();
                seq.addAll(destPair.sideEffects);
                seq.addAll(exprPair.sideEffects);
                seq.add(irFactory.IRMove(destPair.value, exprPair.value));
                return irFactory.IRSeq(seq);
            } else {
                SEPair e1 = lowerExpr(((IRMem) node.target()).expr());
                SEPair e2 = lowerExpr(node.source());
                List<IRStmt> seq = new ArrayList<>(e1.sideEffects);
                // new temp to store e1'
                IRTemp temp = irFactory.IRTemp(tempGenerator.newTemp());
                seq.add(irFactory.IRMove(temp, e1.value));
                seq.addAll(e2.sideEffects);
                // create new move statement
                IRMem mem = irFactory.IRMem(temp); // memory location represented by e1
                seq.add(irFactory.IRMove(mem, e2.value));
                return irFactory.IRSeq(seq);
            }
        }
    }

    /**
     * L[Return(e1, ..., en)]: lower IRReturn by hoisting out side effects of e1, ..., en and append
     * a new Return(e1', ..., en')
     * @param node IRReturn node
     * @return lowered return stmt
     */
    public IRSeq lowerReturn(IRReturn node) {
        List<IRStmt> sequence = new ArrayList<>();
        List<IRExpr> returns = new ArrayList<>();
        SEPair lowerRet;
        for (IRExpr ret : node.rets()) {
            lowerRet = lowerExpr(ret);
            sequence.addAll(lowerRet.sideEffects);
            // move value of ei into a temp to avoid later side effects affecting the value of ei
            IRTemp temp = irFactory.IRTemp(tempGenerator.newTemp());
            sequence.add(irFactory.IRMove(temp, lowerRet.value));
            // gather the lowered ei'
            returns.add(lowerRet.value);
        }
        // add the return stmt that returns the lowered expressions
        sequence.add(irFactory.IRReturn(returns));

        return irFactory.IRSeq(sequence);
    }

    /**
     * L[Call_m(f, e1, ..., e2)]: lower a call_stmt. This should hoist out the side effects of evaluating its
     * @param node IRCallStmt node
     * @return lowered Call_Stmt sequence
     */
    public IRSeq lowerCallStmt(IRCallStmt node) {
        List<IRStmt> sequence = new ArrayList<>();
        List<IRExpr> resultArgs = new ArrayList<>();
        SEPair lowerArg;
        for (IRExpr arg: node.args()) {
            lowerArg = lowerExpr(arg);
            // add the side effect of evaluating a function argument
            sequence.addAll(lowerArg.sideEffects);
            // move the value into a temp
            IRTemp temp_i = irFactory.IRTemp(tempGenerator.newTemp());
            sequence.add(irFactory.IRMove(temp_i, lowerArg.value));
            resultArgs.add(temp_i); // new call_stmt should pass in the temps
        }
        sequence.add(irFactory.IRCallStmt(node.target(), node.n_returns(), resultArgs));
        return irFactory.IRSeq(sequence);
    }


    /**
     * Flatten a possibly nested IRSeq
     * @param node IRSeq
     * @return flattened IRSeq
     */
    public List<IRStmt> flattenSeq(IRSeq node) {
        List<IRStmt> stmts = new ArrayList<>();
        flattenSeqRec(node, stmts);
        return stmts;
    }

    /** a recursive helper for flattenSeq(node). */
    public void flattenSeqRec(IRSeq node, List<IRStmt> stmts) {
        for (IRStmt stmt : node.stmts()) {
            if (stmt instanceof IRSeq) {
                flattenSeqRec((IRSeq) stmt, stmts);
            } else {
                stmts.add(stmt);
            }
        }
    }

    /**
     * Decides whether e1 and e2 commute.
     * @param e1 the first expression after being lowered into its side effects + value
     * @param e2 the second expression e2
     * @return true if e1 and e2 commute, false otherwise.
     */
    private boolean commute(SEPair e1, SEPair e2) {
        IRExpr e1Prime = e1.value;
        List<IRStmt> e2Sides = e2.sideEffects;
        Set<String> tempsUpdated = getTemps(e2Sides); // the temps that are updated by e2's side effects
        boolean hasMem = containsMem(e2Sides);

        return checkCommute(e1Prime, tempsUpdated, hasMem);
    }

    /**
     * Check if e is affected by side effects from another expression, given a set of temporaries updated
     * by those side effects. This is a conservative approximation. If e involves a mem operation then return false.
     * @param e a lowered expression
     * @param temps temporaries updated
     * @param hasMem if the stmt being checked against has memory access
     * @return true if commute, false otherwise.
     */
    private boolean checkCommute(IRExpr e, Set<String> temps, boolean hasMem) {
        if (e instanceof IRConst | e instanceof IRName) {
            return true;
        } else if (e instanceof IRTemp) {
            return !temps.contains(((IRTemp) e).name());
        } else if (e instanceof IRBinOp) {
            return checkCommute(((IRBinOp) e).left(), temps, hasMem)
                    || checkCommute(((IRBinOp) e).right(), temps, hasMem);
        } else if (e instanceof IRMem) {
            return !hasMem;
        } else {
            return false;
        }
    }

    /**
     * Find all the temporaries updated by a list of statements.
     * @param stmts the list of stmts
     * @return a list that contains all the temporaries updated.
     */
    private Set<String> getTemps(List<IRStmt> stmts) {
        Set<String> temps = new HashSet<>();
        for (IRStmt stmt : stmts) {
            if (stmt instanceof IRMove) {
                if (((IRMove) stmt).target() instanceof IRTemp) {
                    temps.add(((IRTemp) ((IRMove) stmt).target()).name());
                }
            }
        }

        return temps;
    }

    /**
     * Decides if a list of stmts contains a mem node.
     * @param stmts the list of stmts
     * @return true if stmts uses a Mem as a destination, false otherwise
     */
    private boolean containsMem(List<IRStmt> stmts) {
        for (IRStmt stmt : stmts) {
            if (stmt instanceof IRMove) {
                return containsMemExpr(((IRMove) stmt).target())
                        || containsMemExpr(((IRMove) stmt).source());
            } else if (stmt instanceof IRCallStmt) {
                for (IRExpr arg : ((IRCallStmt) stmt).args()) {
                    return containsMemExpr(arg);
                }
                return false;
            } else if (stmt instanceof IRJump) {
                return containsMemExpr(((IRJump) stmt).target());
            } else if (stmt instanceof IRCJump) {
                return containsMemExpr(((IRCJump) stmt).cond());
            } else if (stmt instanceof IRReturn) {
                for (IRExpr ret : ((IRReturn) stmt).rets()) {
                    return containsMemExpr(ret);
                }
                return false;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Decides if an expression contains a Mem node.
     * @param e the expression, should be a lowered expression
     * @return true if e contains Mem node, false otherwise
     */
    private boolean containsMemExpr(IRExpr e) {
        if (e instanceof IRBinOp) {
            return containsMemExpr(((IRBinOp) e).left())
                    || containsMemExpr(((IRBinOp) e).right());
        } else {
            return e instanceof IRMem;
        }
    }

}
