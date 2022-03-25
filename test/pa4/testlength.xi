use conv
use io

main(args: int[][]){
    x:int = length({1})
    println(unparseInt(x)) //1
    y:int = length({true})
    println(unparseInt(y)) //1
    z:int = length("h")
    println(unparseInt(z)) //1
    a:int = length({{1},{2},{3}});
    println(unparseInt(a)) //3
    a = length({{"h"}, {{1}}, {"a"}});
    println(unparseInt(a)) //3
    a = length({true, true, true, false})
    println(unparseInt(a)) //4
    a = length({})
    println(unparseInt(a)) //0
    a = length({{{{}}}})
    println(unparseInt(a))  //1
}