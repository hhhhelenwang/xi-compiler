//  x = e,
//  e1[e2] = e2,
//  x:tau = e,
//  _ = e -> done
//  d1...dn = e
a:int = 2
b:bool
c:int[]
d:bool[]
arr:int[][][]

multi_return(): int, int, bool, bool{
    return 1, a, b, true
}

single_return():int{
    return 100;
}

foo(){
e:int[1][2]
f:bool[5][]
s: int[] = "Hello";

a = 1;
a = single_return();
b = true;
b = false;
c = {1, 2, 3}
d = {}
d = {true}
e = {{1,2}}
f = {{},{},{},{},{}}
f = {{true,true},{true,false},{false,true},{true,false},{true,false}}

s[1] = 3
d[0] = false
f[0] = {true,false}
f[0][1] = false

_ = single_return()
_, x:int, y:bool, _ = multi_return()
}