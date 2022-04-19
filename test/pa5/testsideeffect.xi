globalval:int = 0


side(a:int):int{
    globalval = globalval + 1
    return 3;
}
main(args: int[][]){
    _ = side(3)
    x:int[] = "val is 0"
    x[7] = x[7] + globalval
    println(x)
}