use io
use conv

counter:int = 10
main(args: int[][]) {
    a:int = counter + 12
    while(counter > 0){
        print("counter is")
        println(counter)
        j:int
        if ( counter > 5){
            println("enter counter > 5")
            j = gcd(counter, a)
        } else {
            m:int, n:int = ratadd(2,2,4,4)
            println("else branch")
            counter = counter - m - n
            j = gcd(counter, m)
        }

        counter = counter - 1
    }
}

gcd(a:int, b:int):int {
  println("enter gcd")

  while (a != 0) {
    if (a<b) b = b - a
    else a = a - b
  }
  return b
}

ratadd(p1:int, q1:int, p2:int, q2:int) : int, int {
    println("enter ratadd")
    g:int = gcd(q1,q2)
    p3:int = p1*(q2/g) + p2*(q1/g)
    return p3, q1/g*q2
}
