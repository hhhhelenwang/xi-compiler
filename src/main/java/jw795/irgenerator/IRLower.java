package jw795.irgenerator;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import edu.cornell.cs.cs4120.xic.ir.*;

import java.util.ArrayList;
import java.util.List;

public class IRLower {

    /**
     * An intermediate data structure to represent the pair S;e, where S is a vector of statements that
     * captures the side effect of evaluating e. All IR expression lowers to an SEPair.
     */
    class SEPair extends IRExpr_c {
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
    }

    public IRNodeFactory_c irFactory;
    // a counter to track all the temps that have been used.
    // Suppose tempCounter = n, then tn is the last temp used.
    public int tempCounter;

    public IRLower() {
        irFactory = new IRNodeFactory_c();
        tempCounter = 0;
    }

    /**
     * Lower an IR node.
     * @param node not lowered IR node
     * @return lowered IR node
     */
    public IRNode lower(IRNode node) {
        if (node instanceof IRExpr) {
            return lowerExpr((IRExpr) node);
        } else if (node instanceof IRStmt) {
            return lowerStmt((IRStmt) node);
        } else {
            return null;
        }
    }

    // Expressions ======================================================================
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
        if (commute(node.left(), node.right())) {

        } else {

        }
        return null;
    }



    /**
     * L[Call(f, e1, ..., en)]: lower an IR function call expression. Evaluates to the pair (S; e) where
     * S = vector of s_i that captures the side-effect of the function call. Call(f, e1, ..., en) should
     * only has one return value.
     * @param node
     * @return
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

            tempCounter ++;
            IRTemp argTemp = irFactory.IRTemp("t" + tempCounter);
            argTemps.add(argTemp);
            sideOfCall.add(irFactory.IRMove(argTemp, valOfArg)); // add MOVE(ti, e') as a side effect
        }

        IRCallStmt callStmt = irFactory.IRCallStmt(node.target(), (long) 1, argTemps);
        tempCounter ++;
        IRTemp temp_t = irFactory.IRTemp("t" + tempCounter);
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
        IRExpr value = lowerE.value;

        return new SEPair(sideEffects, value);
    }

    /**
     * L[ESeq(s, e)]: lower an IR ESeq expression.
     * @param node ESeq expression
     * @return pair of s and e (probably?)
     */
    public SEPair lowerESeq(IRESeq node) {
        IRStmt sideOfESeq = node.stmt();
        SEPair lowerESeq = lowerExpr(node.expr());
        List<IRStmt> sideOfE= lowerESeq.sideEffects;
        IRExpr exprVal = lowerESeq.value;
        sideOfE.add(sideOfESeq);

        return new SEPair(sideOfE, exprVal);
    }

    // Statements ======================================================================
    /**
     * L[s]: lower an IR statement into a sequence of statements.
     * @param node not lowered IR statement
     * @return an IRSeq that represent the lowered statement
     */
    public IRSeq lowerStmt(IRStmt node) {
        // TODO: SEQ, EXP, JUMP, CJump, label, move, return, call_stmt
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
        IRSeq lowerStmt;
        for (IRStmt stmt : node.stmts()) {
            lowerStmt = lowerStmt(stmt);
            sequence.addAll(lowerStmt.stmts());
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
     *
     * @param node
     * @return
     */
    public IRSeq lowerMove(IRMove node) {
        // if the target is a temp, hoist out the side effect s and append it in front of a Move to e'
        if (node.target() instanceof IRTemp) {
            SEPair lowerE = lowerExpr(node.source());
            List<IRStmt> seq = lowerE.sideEffects;
            seq.add(irFactory.IRMove(node.target(), lowerE.value));
            return irFactory.IRSeq(seq);
        } else {
            // otherwise, estimate if e1 and e2 commute in Move(e1, e2)
            // TODO: lower Move(e1, e2)
            // lower

        }
        return null;
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
            tempCounter ++;
            IRTemp temp = irFactory.IRTemp("t" + tempCounter);
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
     * @param node
     * @return
     */
    public IRSeq lowerCallStmt(IRCallStmt node) {
        List<IRStmt> sequence = new ArrayList<>();

        SEPair lowerArg;
        for (IRExpr arg: node.args()) {
            lowerArg = lowerExpr(arg);
            // add the side effect of evaluating a function argument
            sequence.addAll(lowerArg.sideEffects);
            // move the value into a temp
            tempCounter ++;




        }
        return null;
    }


    // Helper functions ================================================================

    /**
     * Decides whether e1 and e2 commute.
     * @param e1 the first expression e1
     * @param e2 the second expression e2
     * @return if e1 and e2 commute.
     */
    private boolean commute(IRExpr e1, IRExpr e2) {
        return false;
    }
}
