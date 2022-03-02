package jw795.typechecker;

import jw795.ast.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TypeChecker extends Visitor{

    private SymbolTable env;

    @Override
    public void enterScope() {
        env.enterScope();
    }

    @Override
    public void leaveScope() {
        env.leaveScope();
    }

    TypeChecker(){
        this.env = new SymbolTable();
    }

    // ================================= Visit functions for Expressions =================================
    @Override
    // TODO: naming a bit confusing, can confuse with an int type keyword
    public void visitIntLiteral(IntLiteral node) {
        node.type = new Int();
    }

    @Override
    public void visitBoolLiteral(BoolLiteral node) {
        node.type = new Bool();
    }

    @Override
    public void visitStringLit(StringLit node) { node.type = new TypedArray(new Int()); }

    @Override
    public void visitCharLiteral(CharLiteral node) {
            node.type = new Int();
    }

    // there should not be any exception throw out from the upper 4 function, since they are basic type


    @Override
    public void visitFunCallExpr(FunCallExpr node) throws Exception {
        Sigma fnType = this.env.findType(node.name);
        if(!(fnType instanceof Fn)){
            String errorMsg = errorstart(node.getLine(), node.getCol()) + node.name +  " is not a function." +
                    "Got " + fnType.toString();
            throw new Exception(errorMsg);
        } else if (!(((Fn) fnType).outputType instanceof Unit)){
            // function should not return a unit
            if (node.name.equals("length")) {
                checkLength(node);
            } else {
                List<Expr> nodeArgs = node.arguments;
                T declArgs = ((Fn) fnType).inputType;
                try {
                    if (argsConform(nodeArgs, declArgs)){
                        node.type = ((Fn) fnType).outputType;
                    }
                } catch (Exception e) {
                    String errorMsg = errorstart(node.getLine(), node.getCol()) + "Mismatch argument types in FunCall:"
                            + e.getMessage();
                    throw new Exception(errorMsg);
                }

            }
        }
        if(node.type == null){
            //this is the case when argument type does not match
            String errorMsg = errorstart(node.getLine(), node.getCol()) + "Expected " +
                    ((Fn) fnType).inputType.tostr() + ", but got ";
            for(Expr e: node.arguments){
                errorMsg += e.type.tostr();
            }
            throw new Exception(errorMsg);
        }
    }


    /** Type check the function call of length(e) function */
    //this function'error will be handle by the more general function call
    private void checkLength(FunCallExpr node){
        if((node.arguments.size() == 1)) {
            Expr arg =node.arguments.get(0);
            if(arg instanceof VarExpr){
                if(this.env.findType(((VarExpr) arg).identifier) instanceof TypedArray){
                    node.type = new Int();
                }
            }
        }
    }

    @Override
    public void visitVar(VarExpr node) throws Exception {
        if (env.contains(node.identifier)) {
            node.type = (T) env.findType(node.identifier);
        }
        else {
            String res = errorstart(node.getLine(), node.getCol());
            res += "Name " + node.identifier + " cannot be resolved";
            throw new Exception(res);
        }
    }

    @Override
    public void visitIntNeg(IntNeg node) throws Exception {
        if (node.expr.type instanceof Int) {
            node.type = new Int();
        } else {
            String res = errorstart(node.getLine(), node.getCol());
            res += "Int negation cannot be apply to" + node.expr.type.tostr();
            throw new Exception(res);
        }
    }

    /** helper to check the type of the subexpressions of algebraic and comparison binop */
    private void setBinOpIntType(BinOpExpr node) {
        if ((node.expr1.type instanceof Int) && (node.expr2.type instanceof Int)) {
            node.type = new Int();
        }
    }

    /** helper to check the type of the subexpressions of logical binop */
    private void setBinOpBoolType(BinOpExpr node) {
        if ((node.expr1.type instanceof Bool) && (node.expr2.type instanceof Bool)) {
            node.type = new Bool();
        }
    }
    private void setArrayBoolType(BinOpExpr node){
        if(node.expr1.type instanceof  Tau){
            if(node.expr2.type instanceof  Tau) {
                if (((Tau) node.expr1.type).equals(node.expr2.type)) {
                    node.type = new Bool();
                }
            }
        }
    }

    @Override
    public void visitAdd(Add node) throws Exception {
        setBinOpIntType(node);
        setArrayBoolType(node);

        if(node.type == null) {
            String result = errorstart(node.getLine(), node.getCol());
            result += "Operand of + must be same type of tau";
            throw new Exception(result);
        }
    }

    @Override
    public void visitSub(Sub node) throws Exception {
        setBinOpIntType(node);
        errrorint("-", node);
    }

    @Override
    public void visitMult(Mult node) throws Exception {
        setBinOpIntType(node);
        errrorint("*", node);
    }

    @Override
    public void visitHighMult(HighMult node) throws Exception {
        setBinOpIntType(node);
        errrorint("*>>", node);
    }

    @Override
    public void visitDiv(Div node) throws Exception {
        setBinOpIntType(node);
        errrorint("//", node);
    }

    @Override
    public void visitMod(Mod node) throws Exception {
        setBinOpIntType(node);
        errrorint("%", node);
    }

    @Override
    public void visitAnd(And node) throws Exception {
        setBinOpBoolType(node);
        errrorbool("&", node);
    }

    @Override
    public void visitOr(Or node) throws Exception {
        setBinOpBoolType(node);
        errrorbool("|", node);
    }

    @Override
    public void visitEqual(Equal node) throws Exception {
        setBinOpIntType(node);
        setBinOpBoolType(node);
        setArrayBoolType(node);

        if(node.type == null) {
            String result = errorstart(node.getLine(), node.getCol());
            result += "Operands of = must be same type of tau";
            throw new Exception(result);
        }

    }

    @Override
    public void visitNotEqual(NotEqual node) throws Exception {
        setBinOpIntType(node);
        setBinOpBoolType(node);
        setArrayBoolType(node);

        if(node.type == null) {
            String result = errorstart(node.getLine(), node.getCol());
            result += "Operands of != must be same type of tau";
            throw new Exception(result);
        }
    }

    @Override
    public void visitLessThan(LessThan node) throws Exception {
        setBinOpIntType(node);
        errrorint("<", node);

    }

    @Override
    public void visitLessEq(LessEq node) throws Exception {
        setBinOpIntType(node);
        errrorint("<=", node);
    }

    @Override
    public void visitGreaterThan(GreaterThan node) throws Exception {
        setBinOpIntType(node);
        errrorint(">", node);
    }

    @Override
    public void visitGreaterEq(GreaterEq node) throws Exception {
        setBinOpIntType(node);
        errrorint(">=", node);
    }

    @Override
    public void visitArrayExpr(ArrayExpr node) throws Exception {
        if (node.arrayElements.isEmpty()) {
            node.type = new EmptyArray();
        } else {
            T t = node.arrayElements.get(0).type;
            boolean validArray = true;
            for (Expr e: node.arrayElements) {
                T et = e.type;
                if (!(et instanceof Tau)) {
                    validArray = false;
                    break;
                } else if (((Tau) et).equals((Tau) t)) {
                    if (et instanceof Array) {
                        if (((Array)t).compare((Array)et)) {
                            t = et;
                        }
                    }
                } else {
                    validArray = false;
                    break;
                }
            }
            if (validArray) {
                node.type = new TypedArray((Tau)t);
            }else{
                String res = errorstart(node.getLine(), node.getCol());
                throw new Exception(res + "The elements of this array have different types");
            }
        }
    }

    @Override
    public void visitArrIndexExpr(ArrIndexExpr node) throws Exception {
        if (node.array.type instanceof TypedArray && node.index.type instanceof Int) {
            node.type = ((TypedArray) node.array.type).elementType;
        } else if (node.array.type instanceof EmptyArray && node.index.type instanceof Int) {
            node.type = new Unit();
        }else if(! (node.index.type instanceof Int)){
            String res = errorstart(node.getLine(), node.getCol());
            throw new Exception(res + "Expected index as int but got"+ node.index.type.tostr());
        }else{
            String res = errorstart(node.getLine(), node.getCol());
            throw  new Exception(res + "Expected an array for indedxing but got "+ node.array.type);
        }
    }

    @Override
    public void visitNot(Not node) throws Exception {
        if(node.expr.type instanceof Bool){
            node.type = new Bool();
        }
        if(node.type == null) {
            String result = errorstart(node.getLine(), node.getCol());
            result += "bool negation cannot be applied " + node.expr.type.tostr();
            throw new Exception(result);
        }

    }

    // ================================= Visit functions for Statements =================================
    @Override
    public void visitPrCall(ProcCallStmt node) throws Exception {
        // a procedure need to be fn T -> unit
        Sigma prType = this.env.findType(node.name);
        if(!(prType instanceof Fn)){
            String errorMsg = errorstart(node.getLine(), node.getCol()) + node.name +
                    " is not type fn. Got " + prType.toString();
            throw new Exception(errorMsg);
        } else if(!(((Fn) prType).outputType instanceof Unit)){
            String errorMsg = errorstart(node.getLine(), node.getCol()) + "Expected " +
                    ((Fn) prType).inputType.tostr() + ", but got ";
            for(Expr e: node.arguments){
                errorMsg += e.type.tostr();
            }
            throw new Exception(errorMsg);
        } else {
            // satisfies 2 premises above
            List<Expr> nodeArgs = node.arguments;
            T declArgs = ((Fn) prType).inputType;
            try {
                if (argsConform(nodeArgs, declArgs)){
                    node.type = new Unit();
                }
            } catch (Exception e) {
                String errorMsg = errorstart(node.getLine(), node.getCol()) + "Mismatch argument types in ProCall:"
                        + e.getMessage();
                throw new Exception(errorMsg);
            }
        }
    }

    @Override
    public void visitBlockStmt(BlockStmt node) {
        int numArgs = node.statements.size();
        boolean stmtTypeChecked = true;
        for (int i = 0; i < numArgs - 1; i++){
            if (!(node.statements.get(i).type instanceof Unit)){
                stmtTypeChecked = false;
            }
        }
        Statement lastStmt = node.statements.get(numArgs - 1);
        if (stmtTypeChecked && lastStmt.type instanceof R){
            node.type = lastStmt.type;
        }
    }


    @Override
    public void visitIfStmt(IfStmt node) throws Exception {
        if (!(node.condition.type instanceof Bool)) {
            String errorMsg = errorstart(node.getLine(), node.getCol()) + "Expected condition is type Bool, but got" +
                    node.condition.type.tostr();
            throw new Exception(errorMsg);
        } else if (!(node.clause.type instanceof R)){
            String errorMsg = errorstart(node.getLine(), node.getCol()) + "The if clause is null";
            throw new Exception(errorMsg);
        } else {
            node.type = new Unit();
        }
    }

    @Override
    public void visitIfElseStmt(IfElseStmt node) throws Exception {
        if (!(node.condition.type instanceof Bool)){
            String errorMsg = errorstart(node.getLine(), node.getCol()) + "Expected condition is type Bool, but got" +
                    node.condition.type.tostr();
            throw new Exception(errorMsg);
        } else if (!(node.ifClause.type instanceof R)){
            String errorMsg = errorstart(node.getLine(), node.getCol()) + "The if clause is null";
            throw new Exception(errorMsg);
        } else if (!(node.elseClause.type instanceof R)){
            String errorMsg = errorstart(node.getLine(), node.getCol()) + "The else clause is null";
            throw new Exception(errorMsg);
        } else {
            node.type = lub(node.ifClause.type, node.elseClause.type);
        }
    }

    /** Function lub is defined as spec: lub(R, R) = R, lub(unit, R) = lub(R, unit) = unit */
    private R lub(R r1, R r2) {
        if (r1 instanceof Unit || r2 instanceof Unit){
            return new Unit();
        } else {
            return r1;
        }
    }

    @Override
    public void visitWhileStmt(WhileStmt node) throws Exception {
        if (!(node.condition.type instanceof Bool)){
            String errorMsg = errorstart(node.getLine(), node.getCol()) + "Expected condition is type Bool, but got" +
                    node.condition.type.tostr();
            throw new Exception(errorMsg);
        } else if (!(node.loopBody.type instanceof R)){
            String errorMsg = errorstart(node.getLine(), node.getCol()) + "The while loop body is null";
            throw new Exception(errorMsg);
        } else {
            node.type = new Unit();
        }
    }

    /** helper to check the types of arg passed in match the signature of declaration correspondingly*/
    private boolean argsConform(List<Expr> nodeArgs, T declArgs) throws Exception {
        boolean valid = false;
        if (declArgs instanceof Unit && nodeArgs.size() == 0) {
            valid = true;
        } else if (declArgs instanceof Tau && nodeArgs.size() == 1){
            valid = declArgs.equals(nodeArgs.get(0).type);
            if (!valid){
                String errMsg = "Expected "+ declArgs.tostr() + ", but got " + nodeArgs.get(0).type.tostr();
                throw new Exception(errMsg);
            }
        } else if (declArgs instanceof Prod && nodeArgs.size() == ((Prod) declArgs).elementTypes.size()){
            valid = true;
            for (int i = 0; i < nodeArgs.size(); i++){
                Tau declArg = ((Prod) declArgs).elementTypes.get(i);
                Expr nodeArg = nodeArgs.get(i);
                if (!declArg.equals((Tau) nodeArg.type)){ // NOTE: expression can only type check to tau
                    String errMsg = "Expected "+ declArg.tostr() + ", but got " + nodeArg.type.toString();
                    throw new Exception(errMsg);
                }
            }
        }
        if (!valid){
            String errMsg = "Expected no argument passed in, but got ";
            for (Expr e : nodeArgs){
                errMsg += e.type.tostr();
            }
            throw new Exception(errMsg);
        }
        return valid;
    }



    @Override
    public void visitRet(ReturnStmt node) throws Exception {
        boolean isvalid =false;
        Sigma retarg = this.env.findType("return");
        if(retarg instanceof  Prod){
            isvalid = true;
            if (((Prod) retarg).elementTypes.size() == node.returnVals.size() ){
                for (int i =0; i < node.returnVals.size(); i++){
                    if(! ((Prod) retarg).elementTypes.get(i).equals(node.returnVals.get(i))){
                        isvalid = false;
                    }
                }
            }
        }else if(retarg instanceof Unit){
            if(node.returnVals.size() == 0){
                isvalid = true;
            }
        }else if(retarg instanceof Tau){
            if (node.returnVals.size() ==1 & ((Tau) retarg).equals(node.returnVals.get(0))){
                isvalid = true;
            }
        }
        if(isvalid){
            node.type = new Void();
        }else{
            String res= errorstart(node.getLine(), node.getCol());
            res += "invalid return";
            throw new Exception(res);
        }
    }

    @Override
    public void visitAssign(AssignStmt node) throws Exception {
        // TODO:
        //  x = e,
        //  e1[e2] = e2,
        //  x:tau = e,
        //  _ = e -> done
        //  d1...dn = e
        if (node.leftVal instanceof WildCard) {
            checkExprStmt(node);
        } else if (node.leftVal instanceof LeftValueList) {
            checkMultiAssign(node);
        } else if (node.leftVal instanceof VarExpr) {
            Sigma t = this.env.findType(((VarExpr) node.leftVal).identifier);

            if (t instanceof Var) {
                if (node.expr.type instanceof Tau) {
                    if (((Var) t).varType.equals((Tau)(node.expr.type))) {
                        node.type = new Unit();
                    }
                }
            }
            if(node.type == null){
                String res = errorstart(node.getLine(), node.getCol());
                res += "Cannot assign " +node.expr.type.tostr() +" to "+  ((ArrIndexExpr) node.leftVal).type.tostr();
                throw new Exception( res);
            }
        } else if (node.leftVal instanceof ArrIndexExpr) {
            if (node.expr.type instanceof Tau) {
                if (((ArrIndexExpr) node.leftVal).type.equals(node.expr.type)) {
                    node.type = new Unit();
                }
            }
            if(node.type == null){
                String res = errorstart(node.getLine(), node.getCol());
                res += "Cannot assign " +node.expr.type.tostr() +" to "+ ((ArrIndexExpr) node.leftVal).type.tostr();
                throw new Exception( res);
            }
        }
        else{
            String res = errorstart(node.getLine(), node.getCol());
            throw new Exception(res + "invalid oject to assign to");
        }
        // TODO: leave scope here?
    }

    @Override
    public void visitWildCard(WildCard node) {
        node.type = new Unit();
    }

    /** Type check _ = e */
    //Todo: we only allow wild car to be assign by a function
    //yet currently it is unchecked
    private void checkExprStmt(AssignStmt node) throws Exception{
        if (!(node.expr instanceof FunCallExpr)) {
            String pos = errorstart(node.expr.getLine(), node.expr.getCol());
            throw new Exception(pos + "Expected function call");
        }
        if (node.expr.type instanceof Tau) {
            node.type = new Unit();
        } else {
            String pos = errorstart(node.expr.getLine(), node.expr.getCol());
            throw new Exception(pos + "Expected int, bool, or array, got " + node.expr.type.tostr());
        }
    }

    /** Type check multiple assignment statement d1, d2, ..., dn = e
     * Requires:
     * - node is a multiple assign statement (check in visitAssign) so must contain a LeftValueList
     * - contains a list of declarations or wildcards on the left, checked in parsing
     * - a function call on the right, checked in parsing
     */
    private void checkMultiAssign(AssignStmt node) throws Exception {
        List<LValue> declares = ((LeftValueList) node.leftVal).declares;
        List<Tau> returnTypes = ((Prod) node.expr.type).elementTypes;
        if (declares.size() != returnTypes.size()) {
            String pos = errorstart(node.getLine(), node.getCol());
            throw new Exception(pos + "Mismatched number of values");
        }
        // check dom(gamma) does not contains varsOf(d)
        for (LValue decl: declares) {
            // dom contains varsOf(decl)
            if (env.dom().removeAll(varsOf(decl))) {
                String pos = errorstart(decl.getLine(), decl.getCol());
                throw new Exception(pos + "Variable " + ((VarDeclareStmt) decl).identifier + " already declared");
            }
        }

        // check no two declarations have same var
        for (LValue d1 : declares) {
            for (LValue d2: declares) {
                Set<String> intersect = varsOf(d1);
                intersect.retainAll(varsOf(d2));
                if (!d1.equals(d2) && !intersect.isEmpty()) {
                    String pos = errorstart(d1.getLine(), d1.getCol());
                    throw new Exception(pos + "Repeated declarations of variables");
                }
            }
        }
        // check tau(i) <= typesOf(d(i))
        for (int i = 0; i < declares.size(); i++) {
            Tau tau = returnTypes.get(i);
            LValue d = declares.get(i);
            if (tau instanceof Array && typesOf(d) instanceof Array) {
                if (!((Array) tau).compare((Array) typesOf(d))) {
                    String pos = errorstart(d.getLine(), d.getCol());
                    throw new Exception(pos + "Expected " + typesOf(d).tostr() + " got" + tau.tostr());
                }
            } else {
                if (!tau.isSubOf(typesOf(d))) {
                    String pos = errorstart(d.getLine(), d.getCol());
                    throw new Exception(pos + "Expected " + typesOf(d).tostr() + " got" + tau.tostr());
                }
            }
        }
        // all premises satisfied
        // type this statement
        node.type = new Unit();
        // update context
        for (LValue decl : declares) {
            Set<String> var = varsOf(decl);
            if (!var.isEmpty()) {
                String id = var.iterator().next();
                env.add(id, new Var((Tau) typesOf(decl)));
            }
        }

    }

    /** The set of variable in a declaration d. */
    private Set<String> varsOf(LValue d) {
        Set<String> vars = new TreeSet<>();
        if (d instanceof VarDeclareStmt) {
            String id = ((VarDeclareStmt) d).identifier;
            vars.add(id);
        }
        return vars;
    }

    /** The set of types in a declaration d. */
    private T typesOf(LValue d) {
        if (d instanceof VarDeclareStmt) {
            Tau type = typeToTau(((VarDeclareStmt) d).varType);
            return type;
        } else {
            return new Unit();
        }
    }

    @Override
    public void visitVarDecl(VarDeclareStmt node) throws Exception{
        // TODO: x:tau, x:tau[]
        if (node.varType instanceof ArrayType) { // check array declaratio
            checkArrayDecl(node);
        } else { // TODO: is it safe to use else here
            if (!env.contains(node.identifier)) {
                node.type = new Unit();
                env.add(node.identifier, new Var(typeToTau(node.varType)));
            }
            // TODO: else
        }
    }

    /** Type check array declaration x:tau[e1][e2]...[en][]...[], allow n = 0.
     *  Requires:
     *  - node is an array declaration (check when calling this method in visitVarDecl),
     *  - all dimensions are specified to the left-most (checked at parsing),
     */
    public void checkArrayDecl(VarDeclareStmt node) throws Exception{
        String id = node.identifier;
        ArrayType arrType = (ArrayType) node.varType;
        if (env.contains(id)) {
            String pos = errorstart(node.getLine(), node.getLine());
            throw new Exception(pos + "Variable already exists");
        } else {
            Type next = arrType;
            // check type
            while (next instanceof ArrayType) {
                // if dim is defined for this level
                boolean hasDim = ((ArrayType) next).length.isPresent();
                if (hasDim) {
                    Expr length = ((ArrayType) next).length.get();
                    T dimType = length.type;
                    if (!(dimType instanceof Int)) {
                        String pos = errorstart(length.getLine(), length.getLine());
                        throw new Exception(pos + "Expected int, but found " + dimType.tostr());
                    }
                    next = ((ArrayType) next).elemType;
                }
            }
        }
        // if typeChecks, build an array type with m + n levels and primitive type = next
        Tau type = typeToTau(arrType);
        env.add(id, new Var(type));
    }

    @Override
    public void visitFundef(FunctionDefine node){
        T input;
        T output;
        if(node.arguments.size() == 0){
            input = new Unit();
        }else if(node.arguments.size() == 1){
            input =  node.arguments.get(0).type;
        }else{
            List<Tau> eletype= new ArrayList<>();
            for(FunProcArgs fp: node.arguments){
                eletype.add(fp.type);
            }
            input = new Prod(eletype);
        }

        if(node.returnTypes.size() == 0){
            output =new Unit();
        }else if(node.returnTypes.size() == 1){
            output = typeToTau(node.returnTypes.get(0)) ;
        }else{
            List<Tau> rettype= new ArrayList<>();
            for(Type e: node.returnTypes){
                rettype.add(typeToTau(e));
            }
            output = new Prod(rettype);
        }

        Fn thetype = new Fn(input, output);
        this.env.add(node.name, thetype);

        this.env.leaveScope();
    }

    @Override
    public void visitPrdef(ProcedureDefine node){
        T input;
        T output;
        if(node.arguments.size() == 0){
            input = new Unit();
        }else if(node.arguments.size() == 1){
            input =  node.arguments.get(0).type;
        }else{
            List<Tau> eletype= new ArrayList<>();
            for(FunProcArgs fp: node.arguments){
                eletype.add(fp.type);
            }
            input = new Prod(eletype);
        }

        Fn thetype = new Fn(input, new Unit());
        this.env.add(node.name, thetype);

        this.env.leaveScope();
    }


    /** Build a Tau type from a Type AST node. */
    private Tau typeToTau(Type t){
        if (t instanceof IntType){
            return new Int();
        }
        else if (t instanceof BoolType){
            return new Bool();
        }
        else if (t instanceof ArrayType){
            if (((ArrayType) t).elemType == null){
                return new EmptyArray();
            }else{
                return new TypedArray(typeToTau(((ArrayType) t).elemType));
            }
        }
        return null;
    }


    /** Initialize a new object that is the same type as the Type R object passed in. R ::= unit | void */
    private R toR(R type){
        if (type instanceof Unit){
            return new Unit();
        } else if (type instanceof Void) {
            return new Void();
        }
        System.out.println("error in toR(R type): null passed in");
        return null; // an error, should not call toR on a null object
    }

    /** Initialize a new object that is the same type as the Type T object passed in */
    private T toT(T type){
        if (type instanceof Tau){
            return new Tau();
        } else if (type instanceof Bool){
            return new Bool();
        } else if (type instanceof EmptyArray){
            return new EmptyArray();
        } else if (type instanceof TypedArray){
            //TODO: cannot resolve field elementType
//            Tau eleType = (TypedArray)type.elementType;
//            return new TypedArray(eleType);
        }
        return null;
    }

    private String errorstart(int line, int colmn){
        return (line + ":" + colmn +" error: " );
    }
    private void errrorint (String operands, BinOpExpr node) throws Exception {
        if(node.type == null) {
            String result = errorstart(node.getLine(), node.getCol());
            result += "Operands of " + operands+ " must be int";
            throw new Exception(result);
        }

    }
    private void errrorbool (String operands, BinOpExpr node) throws Exception {
        if(node.type == null) {
            String result = errorstart(node.getLine(), node.getCol());
            result += "Operands of " + operands+ " must be bool";
            throw new Exception(result);
        }
    }

}
