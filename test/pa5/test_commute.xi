use io
use conv
g1:int = 5
g2:int = 6
f() : int {
    g1 = g1 + 1
    return g1;
}

main (a : int[][]) {
    b:int = f() + g1;
    print(unparseInt(b));
}