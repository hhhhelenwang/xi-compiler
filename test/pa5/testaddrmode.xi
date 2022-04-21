use io;
use conv

main(args:int[][]){
    x:int = 5;
    y:int = 6;
    a:int;
    b:int;

    a = x + 2 * y;
    a = 2 * y + x;
    b = x + y * 2;
    b = y * 2 + x;

    a = a + 1;
    b = b - 1;

    println(unparseInt(a));
    println(unparseInt(b));
}