# AST Hierarchy
The hiearchy of the AST is defined as follows:

ASTNode (interface)
- Program (root node of AST) impl. 
- Type (interface, all classes below implements Type)
    - intType
    - boolType
    - arrayType

- FunProcArgs (impl. ASTNode, represent the parameters in function/procedure declaration)

- Function (implements ASTNode)

- Expr (extends ASTNode, interface, all below implements Expr)
    - UnOpExpr
    - BinOpExpr
    - IntExpr
    - BoolExpr
    - VarExpr
    - CharExpr
    - FunCallExpr
    - ArrayExpr
    - ArrIndexExpr
    - Lvalue (value that goes to left of assign, interface used by assignment statement)
    - Rvalue (right of assign, interface used by assignment statement)

- Statement (extends ASTNode, interface, all below implements Statement)
    - AssignStmt
    - IfStmt
    - IfElseStmt
    - WhileStmt
    - ReturnStmt
    - ProcCallStmt
    - BlockStmt
    - VarDeclareStmt
    - UseStmt

