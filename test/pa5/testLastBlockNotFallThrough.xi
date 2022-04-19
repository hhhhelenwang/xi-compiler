use io
use conv

var:int = 0
main(args: int[][]) {

    b:bool = produceBool(1)
    sideEffect()

    if (1==1 & var == 1){
        println("enter if")
        if (true & b){
            println("success")
        }
    }
}

sideEffect(){
    var = 1
}

produceBool(i:int):bool{
    if (i>0){
        return (1+1+1) > 2
    } else {
        return length("12345") == 1
    }
}