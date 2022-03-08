sqarray (n : int) : int[] {
    arr : int[n];
    i : int = 0;
    while (i < n) {
        arr[i] = i * i;
    }
    return arr;

}

// move arguments into TEMP
MOVE (TEMP tn) (TEMP n)

// array declaration
MOVE (TEMP t1) (TEMP tn) //
MOVE (TEMP t2) (CALL(malloc(ADD (MULT (TEMP t1) (CONST 9)) (CONST 8))))

MOVE (TEMP a) (ADD (TEMP t2) (CONST 8)) // the array
MOVE (MEM(t2)) (TEMP t1) // store length


MOVE (TEMP i) (CONST 0)

LABEL h
CJUMP (LT (i) (n)) (NAME (t)) (NAME (f))

LABEL t
MOVE (TEMP ta) (TEMP a) // array
MOVE (TEMP ti) (TEMP i) // index
CJUMP (ULT (TEMP ti) (MEM(SUB (TEMP ta) (CONST 8)))) (NAME lok) (lerr)

LABEL lok
MOVE (MEM(ADD(TEMP ta) (MULT (TEMP ti) (CONST 8)))) (MULT (TEMP i) (TEMP i))

LABEL lerr
// no idea

JUMP (NAME(h))
LABEL f



