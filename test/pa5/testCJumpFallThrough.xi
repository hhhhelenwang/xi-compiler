use io
use conv
main(args: int[][]) {
    course:int = 4122
    b:bool = isTrue()

    while(b){
        print("enter while")
        println("");

        if(course > 4120) {
            println("enter true branch")
            course = course - 1
        } else {
            println("enter if x == 4120")
            b = false

        }
    }
}

isTrue ():bool{
    println("AHHHH");
    return 1 != 2
}