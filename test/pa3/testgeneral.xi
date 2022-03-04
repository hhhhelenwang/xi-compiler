use io
foo(){
}
doo(){
    a:int
    a = -1
    b:bool = !true
    a = a + 3
    a = a - 2
    a = 3 * 2
    a = 3 *>> 2
    a = 5 / 6
    a = 5 % 6
    b = b & false
    b = true | false | false
    c:bool = false
    d:bool = b == d
    d = a == 3
    d = 5 != 6
    d = 5 < 6
    d = 5 <= 6
    d = 5 > 6
    d = 5 >=6

    a1: int[][] = {{},{}}
    a2: int[][] = {{1,2},{3,4}}
    d = a1 == a2
    d = a1 != a2
    a1 = a1 + a2
    a3: bool[]
    a4: bool[3][4]
    a5: bool[3][][]

    a = a2[3][4]
}
foo2():bool{
    doo()
    a6:int = length({})
    a7:int = length({{true},{false}})
    return true
}
foo3(){
    thebool:bool = foo2()
    if(true){
        b1:int = 3
    }
    if(true){
        b1:int = 3
    }else{
        b2:int = 3
    }
    while(true){
    }
    c1:bool, c2:bool, _ = foo4()
}
foo4():bool, bool, bool{
    return true, false, true
}

globd: int = 3
