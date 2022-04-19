use conv
funret(): int, bool, int[][]{
    return 3,true, {{2},{3}}
}

main(args: int[][]){
    x:int, y:bool, k: int[][] = funret()
    println(unparseInt(x))
}