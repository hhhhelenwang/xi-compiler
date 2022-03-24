use io


glvar:int
donothing(){

}
dosth(a:int, b:bool): int{
    if(b){
    return a
    }else{
    return -a
    }
}
domul(a:int, b:bool): int, bool{
    if(b){
    return a, b
    }else{
    return -a, b
    }
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