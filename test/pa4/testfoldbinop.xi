main(args:int[][]){
    x:int;
    y:bool;

    x = 1+2
    x= 2-3
    x= 3*6
    x=  9/3
    x = 7%5
    x = 5*>>6
    println("int binop")

    y = 4 ==6
    y = 7>7
    y = 7 >= 8
    y = 8<7
    y = 8<=8
    println("int to bool binop")

    y = true & false
    y = true | false
    println("bool binop")

    y = true & y
    y = false | y
    y = false & y
}