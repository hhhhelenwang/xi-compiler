use io
record Point2 {
    x : int
    y, z : bool
}

foo(p:Point2){
    p.x = 2
    p.y = false
    p.z = p.y
    break
    p.x = null
}
