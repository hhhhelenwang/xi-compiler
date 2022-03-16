package jw795.irgenerator;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import edu.cornell.cs.cs4120.xic.ir.*;
import jw795.ast.Statement;

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

    public IRLower() {
        irFactory = new IRNodeFactory_c();
    }

    /**
     * Lower an IR node.
     * @param node not lowered IR node
     * @return lowered IR node
     */
    public IRNode lower(IRNode node) {
        return null;
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
            return null;
        }
    }

    /**
     * L[s]: lower an IR statement.
     * @param node not lowered IR statement
     * @return lowered IR statement
     */
    public IRStmt lowerStmt(Statement node) {
        return null;
    }


    // Expressions ======================================================================

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
        // TODO: how to determine if e1 and e2 commutes?
        return null;
    }



    /**
     * L[Call(f, e1, ..., en)]: lower an IR function call expression. Evaluates to the pair (S; e) where
     * S = vector of s_i that captures the side-effect of the function call.
     * @param node
     * @return
     */
    // TODO: ?? should evaluate to a pair (S; e) where S = vector of s_i that captures the side-effect of
    //  the function call. But this kinda mess up the return types for expression lowerers.
    //  !! Possible solution: our implementation for pair(S; e) should extend IRExpr

    // TODO: !!!! Note on how (S; e) should be handled:
    //  suppose we have an assign statement a = foo(2), we will call lowerStmt(this node). a = foo(2) is an instance
    //  of IRMove, so lowerStmt(this node) should recursively call lowerMove() which will then call lowerExpr(a) and
    //  lowerExpr(foo(2)). The result of lowerExpr(foo(2)) should be the pair (S; e). Then lowerMove() should take S,
    //  make it into multiple statements, and shove it in front of the actual move statement. i.e. lowerMove() should
    //  return:
    //  Seq(
    //      s1,
    //      s2,
    //      ...,
    //      sn,
    //      move (Temp a, e)
    //     )
    public SEPair lowerCall(IRCall node) {
        SEPair lowerArg;
        List<IRStmt> sideOfArg; // side effect of an argument
        IRExpr valOfArg; // the value expression of the argument, without side effects

        List<IRStmt> sideOfCall = new ArrayList<>(); // all of the side effects of the call
        List<IRExpr> argTemps = new ArrayList<>();
        int i = 1;
        for (IRExpr arg : node.args()) {
            lowerArg = lowerExpr(arg);
            sideOfArg = lowerArg.sideEffects;
            valOfArg = lowerArg.value;
            sideOfCall.addAll(sideOfArg); // add side effect of argument to the overall side effects

            IRTemp argTemp = irFactory.IRTemp("t" + i);
            argTemps.add(argTemp);
            sideOfCall.add(irFactory.IRMove(argTemp, valOfArg)); // add MOVE(ti, e') as a side effect
            i ++;
        }
        IRCall call = irFactory.IRCall(node.target(), argTemps);

        return new SEPair(sideOfCall, call);
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



}
