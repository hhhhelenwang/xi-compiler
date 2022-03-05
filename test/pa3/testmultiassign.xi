foo1():int{
    return 3
}
foo2():int,int,int[]{
    return 3,4,{}
}
foo3(){
    a:int, _, c:int[] = foo2()
}