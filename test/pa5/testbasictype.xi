use io

glvar:int
donothing(){

}
dosth(c:int, d:bool): int{
    y:int
    if(d){
    y = c
    }else{
    y = -c
    }
    return y
}
domul(a:int, b:bool): int, bool{
    x:int;
    if(b){
    x = a
    }else{
    x = -a
    }
    return x, b
}


main(args: int[][]){
    a1:int = 'a'
    a2: int = 3
    a2 = 5
    donothing()

    a2 = dosth(3,false)
    _ = dosth(3,false)
    a6: int, _ = domul(3,true)
    a4:int[6]
    a4[0] = 3
}