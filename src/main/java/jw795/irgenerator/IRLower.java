package jw795.irgenerator;

import edu.cornell.cs.cs4120.xic.ir.*;
import jw795.ast.Statement;

public class IRLower {

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
    public IRExpr lowerExpr(IRExpr node) {
        // match the node against all IR expressions
        // TODO: binop, const, call, mem, eseq, name, temp
        if (node instanceof IRBinOp) {
            return lowerBiNop((IRBinOp) node);
        }
        return null;
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
     * L[e1 op e2]: lower an BinOp expression.
     * @param node not-lowered IR BiNop expression
     * @return lowered IR BiNop expression
     */
    public IRExpr lowerBiNop(IRBinOp node) {
        return new IRBinOp(node.opType(), lowerExpr(node.left()), lowerExpr(node.right()));
    }

    /**
     * L[CONST(n)]: lower an IR constant expression
     * @param node IR const
     * @return lowered IR const
     */
    public IRExpr lowerConst(IRConst node) {
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
    public IRExpr lowerCall(IRCall node) {
        return null;
    }

    /**
     * L[Mem(e)]: lower an IR mem expression
     * @param node not lowered IR mem expression
     * @return lowered mem expression
     */
    public IRExpr lowerMem(IRMem node) {
        return null;
    }

    /**
     * L[ESeq(s, e)]: lower an IR ESeq expression.
     * @param node ESeq expression
     * @return pair of s and e (probably?)
     */
    public IRExpr lowerESeq(IRESeq node) {
        return null;
    }

    /**
     * L[Name(e)]: lower name expression
     * @param node name expression
     * @return lowered name expression
     */
    public IRExpr lowerName(IRName node) {
        return null;
    }

    /**
     * L[Temp(e)]: lower temporary variable expression
     * @param node temp node
     * @return lowered temp node
     */
    public IRExpr lowerTemp(IRTemp node) {
        return null;
    }

}
