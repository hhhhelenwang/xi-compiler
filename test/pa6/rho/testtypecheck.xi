
record Point2 {
    x : int
    y, z : bool
    k: Point2
}

foo(){
    p:Point2 = Point2()
    p.x = 2
    p.k = Point2(2, true, false, null)
    p = null
    x:int = 2

    while x>0 {
        break
    }
}