use io
use conv

g1:int = 0
g2:int = 0

f():int {
    g2 = g2 + 1
    g1 = g1 + g2
    println(unparseInt(g1))
    return g1
}

main (a : int[][]) {
    result:int[f() + f()][f() + f()]
}