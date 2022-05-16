use io
use conv
main (ini : int[][]) {
    hello:int = 1;
    p:int = 2;
    l:int = 3;
    u:int = 4;

    a:int;
    b:int;
    c:int;

    a = hello + p + l*u;
    b = p + l*u;
    c = l*u;

    println(unparseInt(a));
    println(unparseInt(b));
    println(unparseInt(c));
    println("Hello, World!")
}
