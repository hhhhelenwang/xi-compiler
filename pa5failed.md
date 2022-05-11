Summary
Summary
Test script: xthScript
  xic-build: OK
  Test collection: xic (Test --help)
    []: OK
  xic (Test --help): 1 out of 1 tests succeeded.
  Test collection: xic (Test -target linux)
    ex01.xi: OK
    ack.xi: Failed to execute: ack exit code 139
    primes.xi: Executable time limit of 30 SECONDS exceeded
      Stream closed
  xic (Test -target linux): 1 out of 3 tests succeeded.
    Has addressing mode: false
  Test collection: xic (Test -target linux -O)
    ex01.xi: OK
    ack.xi: Failed to execute: ack exit code 139
    primes.xi: Executable time limit of 30 SECONDS exceeded
      Stream closed
  xic (Test -target linux -O): 1 out of 3 tests succeeded.
    Has addressing mode: false
  Test collection: xic-ref (-target linux [pretest])
    test_conv.xi: OK
    test_io.xi: OK
  xic-ref (-target linux [pretest]): 2 out of 2 tests succeeded.
    Has addressing mode: false
  Test collection: xic-ref (-target linux -O [pretest])
    test_conv.xi: OK
    test_io.xi: OK
  xic-ref (-target linux -O [pretest]): 2 out of 2 tests succeeded.
    Has addressing mode: false
  Test collection: xic-ref (-target linux [basic test])
    arracc01.xi: Missing line in file arracc01.s.nml: 0
    arracc02.xi: Missing line in file arracc02.s.nml: Index: 0
    arracc03.xi: Failed to execute: arracc03 exit code 139
    arracc04.xi: Failed to execute: arracc04 exit code 139
    arracc05.xi: OK
    arracc06.xi: OK
    arracc07.xi: Missing line in file arracc07.s.nml: Index: 0
    arracc08.xi: Failed to execute: arracc08 exit code 139
    arrinit01.xi: Missing line in file arrinit01.s.nml: 1
    arrinit02.xi: Failed to execute: arrinit02 exit code 139
    arrinit03.xi: Failed to execute: arrinit03 exit code 139
    arrinit04.xi: Failed to execute: arrinit04 exit code 139
    arrinit05.xi: Failed to execute: arrinit05 exit code 139
    arrinit06.xi: Failed to execute: arrinit06 exit code 139
    assign01.xi: OK
    assign02.xi: Mismatch detected at line 2 of file assign02.s.nml
expected: 47
      found   : 9
    assign03.xi: Mismatch detected at line 1 of file assign03.s.nml
expected: 3
      found   : _xi_out_of_bounds called
    assign04.xi: Mismatch detected at line 1 of file assign04.s.nml
      expected: f() called: 1
      found   : _xi_out_of_bounds called
    assign05.xi: Mismatch detected at line 1 of file assign05.s.nml
      expected: f() called: 0
      found   : _xi_out_of_bounds called
    assign06.xi: Mismatch detected at line 1 of file assign06.s.nml
expected: f() called: 0
1/6

Summary
  found   : _xi_out_of_bounds called
assign07.xi: Failed to execute: assign07 exit code 139
assign08.xi: Failed to execute: assign08 exit code 139
assign09.xi: Mismatch detected at line 1 of file assign09.s.nml
  expected: Index: 3
  found   : _xi_out_of_bounds called
assign10.xi: Failed to execute: assign10 exit code 139
binary01.xi: OK
binary02.xi: Mismatch detected at line 1 of file binary02.s.nml
  expected: f() called: 1
  found   : f() called: 9
binary03.xi: Mismatch detected at line 2 of file binary03.s.nml
expected: 25
  found   : 47
binary04.xi: Mismatch detected at line 1 of file binary04.s.nml
  expected: f() called: 1
  found   : f() called: 9
binary05.xi: Mismatch detected at line 2 of file binary05.s.nml
expected: 0
  found   : 1
binary06.xi: Mismatch detected at line 5 of file binary06.s.nml
  expected: f() called: 0
  found   : f() called: 1
binary07.xi: Mismatch detected at line 1 of file binary07.s.nml
expected: 1
  found   : 0
binary08.xi: Failed to execute: binary08 exit code 139
binary09.xi: Failed to execute: binary09 exit code 139
binary10.xi: Failed to execute: binary10 exit code 139
binary11.xi: Failed to execute: binary11 exit code 139
binary12.xi: Failed to execute: binary12 exit code 139
block01.xi: OK
block02.xi: OK
charlit01.xi: OK
charlit02.xi: OK
functioncall01.xi: Failed to execute: functioncall01 exit code 139
functioncall02.xi: Failed to execute: functioncall02 exit code 139
functioncall03.xi: Mismatch detected at line 1 of file functioncall03.s.nml
  expected: f() called: 1
  found   : f() called: 15
functioncall04.xi: Failed to execute: functioncall04 exit code 139
if01.xi: OK
if02.xi: OK
if03.xi: OK
if04.xi: OK
if05.xi: Failed to execute: if05 exit code 139
if06.xi: Failed to execute: if06 exit code 139
if07.xi: Failed to execute: if07 exit code 139
if08.xi: Failed to execute: if08 exit code 139
if09.xi: Failed to execute: if09 exit code 139
if10.xi: Failed to execute: if10 exit code 139
intlit01.xi: OK
intlit02.xi: OK
length01.xi: Mismatch detected at line 1 of file length01.s.nml
expected: 5
  found   : 0
length02.xi: Failed to execute: length02 exit code 139
localdecl01.xi: OK
localdecl02.xi: OK
localdecl03.xi: Failed to execute: localdecl03 exit code 139
2/6

Summary
  localdecl04.xi: OK
  localdecl05.xi: OK
  localdecl06.xi: Failed to execute: localdecl06 exit code 139
  localdecl07.xi: OK
  localdecl08.xi: OK
  localdecl09.xi: OK
  localdecl10.xi: OK
  localdecl11.xi: OK
  localdecl12.xi: OK
  localdecl13.xi: Failed to execute: localdecl13 exit code 139
  localdecl14.xi: Failed to execute: localdecl14 exit code 139
  procedurecall01.xi: OK
  procedurecall02.xi: Failed to execute: procedurecall02 exit code 139
  procedurecall03.xi: OK
  procedurecall04.xi: Failed to execute: procedurecall04 exit code 139
  procedurecall05.xi: Failed to execute: procedurecall05 exit code 139
  procedurecall06.xi: Failed to execute: procedurecall06 exit code 139
  stringlit01.xi: OK
  stringlit02.xi: OK
  unary01.xi: OK
  unary02.xi: Failed to execute: unary02 exit code 139
  unary03.xi: Mismatch detected at line 1 of file unary03.s.nml
    expected: false
    found   : true
  unary04.xi: Failed to execute: unary04 exit code 139
  while01.xi: OK
  while02.xi: Failed to execute: while02 exit code 139
  while03.xi: Failed to execute: while03 exit code 139
  while04.xi: Failed to execute: while04 exit code 139
xic-ref (-target linux [basic test]): 30 out of 88 tests succeeded.
  Has addressing mode: false
Test collection: xic-ref (-target linux -O [basic test])
  arracc01.xi: Missing line in file arracc01.s.nml: 0
  arracc02.xi: Missing line in file arracc02.s.nml: Index: 0
  arracc03.xi: Failed to execute: arracc03 exit code 139
  arracc04.xi: Failed to execute: arracc04 exit code 139
  arracc05.xi: OK
  arracc06.xi: OK
  arracc07.xi: Missing line in file arracc07.s.nml: Index: 0
  arracc08.xi: Failed to execute: arracc08 exit code 139
  arrinit01.xi: Failed to execute: arrinit01 exit code 139
  arrinit02.xi: Failed to execute: arrinit02 exit code 139
  arrinit03.xi: Mismatch detected at line 1 of file arrinit03.s.nml
expected: 1
    found   : _xi_out_of_bounds called
  arrinit04.xi: Failed to execute: arrinit04 exit code 139
  arrinit05.xi: Failed to execute: arrinit05 exit code 139
  arrinit06.xi: Failed to execute: arrinit06 exit code 139
  assign01.xi: OK
  assign02.xi: Mismatch detected at line 2 of file assign02.s.nml
expected: 47
    found   : 9
  assign03.xi: Mismatch detected at line 1 of file assign03.s.nml
expected: 3
    found   : _xi_out_of_bounds called
  assign04.xi: Mismatch detected at line 1 of file assign04.s.nml
    expected: f() called: 1
    found   : _xi_out_of_bounds called
  assign05.xi: Mismatch detected at line 1 of file assign05.s.nml
expected: f() called: 0
3/6

Summary
  found   : _xi_out_of_bounds called
assign06.xi: Mismatch detected at line 1 of file assign06.s.nml
  expected: f() called: 0
  found   : _xi_out_of_bounds called
assign07.xi: Failed to execute: assign07 exit code 139
assign08.xi: Failed to execute: assign08 exit code 139
assign09.xi: Failed to execute: assign09 exit code 139
assign10.xi: Failed to execute: assign10 exit code 139
binary01.xi: OK
binary02.xi: Mismatch detected at line 1 of file binary02.s.nml
  expected: f() called: 1
  found   : f() called: 9
binary03.xi: Mismatch detected at line 2 of file binary03.s.nml
expected: 25
  found   : 47
binary04.xi: Mismatch detected at line 1 of file binary04.s.nml
  expected: f() called: 1
  found   : f() called: 9
binary05.xi: Mismatch detected at line 2 of file binary05.s.nml
expected: 0
  found   : 1
binary06.xi: Mismatch detected at line 5 of file binary06.s.nml
  expected: f() called: 0
  found   : f() called: 1
binary07.xi: Mismatch detected at line 1 of file binary07.s.nml
expected: 1
  found   : 0
binary08.xi: Failed to execute: binary08 exit code 139
binary09.xi: Failed to execute: binary09 exit code 139
binary10.xi: Failed to execute: binary10 exit code 139
binary11.xi: Failed to execute: binary11 exit code 139
binary12.xi: Failed to execute: binary12 exit code 139
block01.xi: OK
block02.xi: OK
charlit01.xi: OK
charlit02.xi: OK
functioncall01.xi: Failed to execute: functioncall01 exit code 139
functioncall02.xi: Failed to execute: functioncall02 exit code 139
functioncall03.xi: Mismatch detected at line 1 of file functioncall03.s.nml
  expected: f() called: 1
  found   : f() called: 15
functioncall04.xi: Failed to execute: functioncall04 exit code 139
if01.xi: OK
if02.xi: OK
if03.xi: OK
if04.xi: OK
if05.xi: Failed to execute: if05 exit code 139
if06.xi: Failed to execute: if06 exit code 139
if07.xi: Failed to execute: if07 exit code 139
if08.xi: Failed to execute: if08 exit code 139
if09.xi: Failed to execute: if09 exit code 139
if10.xi: Failed to execute: if10 exit code 139
intlit01.xi: OK
intlit02.xi: OK
length01.xi: Mismatch detected at line 1 of file length01.s.nml
expected: 5
  found   : 0
length02.xi: Failed to execute: length02 exit code 139
localdecl01.xi: OK
localdecl02.xi: OK
4/6

Summary
  localdecl03.xi: Failed to execute: localdecl03 exit code 139
  localdecl04.xi: OK
  localdecl05.xi: OK
  localdecl06.xi: Failed to execute: localdecl06 exit code 139
  localdecl07.xi: OK
  localdecl08.xi: OK
  localdecl09.xi: OK
  localdecl10.xi: OK
  localdecl11.xi: OK
  localdecl12.xi: OK
  localdecl13.xi: Failed to execute: localdecl13 exit code 139
  localdecl14.xi: Failed to execute: localdecl14 exit code 139
  procedurecall01.xi: OK
  procedurecall02.xi: Failed to execute: procedurecall02 exit code 139
  procedurecall03.xi: OK
  procedurecall04.xi: Failed to execute: procedurecall04 exit code 139
  procedurecall05.xi: Failed to execute: procedurecall05 exit code 139
  procedurecall06.xi: Failed to execute: procedurecall06 exit code 139
  stringlit01.xi: OK
  stringlit02.xi: OK
  unary01.xi: OK
  unary02.xi: Failed to execute: unary02 exit code 139
  unary03.xi: Mismatch detected at line 1 of file unary03.s.nml
    expected: false
    found   : true
  unary04.xi: Failed to execute: unary04 exit code 139
  while01.xi: OK
  while02.xi: Failed to execute: while02 exit code 139
  while03.xi: Failed to execute: while03 exit code 139
  while04.xi: Failed to execute: while04 exit code 139
xic-ref (-target linux -O [basic test]): 30 out of 88 tests succeeded.
  Has addressing mode: false
Test collection: xic-ref (-target linux [combo test])
  fac01.xi: Failed to execute: fac01 exit code 139
  fac02.xi: Mismatch detected at line 1 of file fac02.s.nml
    expected: 5040
    found   : 720
  fac03.xi: Failed to execute: fac03 exit code 139
  fib01.xi: Failed to execute: fib01 exit code 139
  fib02.xi: Mismatch detected at line 1 of file fib02.s.nml
expected: 13
    found   : 8
  medley01.xi: Failed to execute: medley01 exit code 139
xic-ref (-target linux [combo test]): 0 out of 6 tests succeeded.
  Has addressing mode: false
Test collection: xic-ref (-target linux -O [combo test])
  fac01.xi: Failed to execute: fac01 exit code 139
  fac02.xi: Mismatch detected at line 1 of file fac02.s.nml
    expected: 5040
    found   : 720
  fac03.xi: Failed to execute: fac03 exit code 139
  fib01.xi: Failed to execute: fib01 exit code 139
  fib02.xi: Mismatch detected at line 1 of file fib02.s.nml
expected: 13
    found   : 8
  medley01.xi: OK
xic-ref (-target linux -O [combo test]): 1 out of 6 tests succeeded.
  Has addressing mode: false
Test collection: xic-ref (-target linux [global test])
  arr2.xi: Failed to execute: arr2 exit code 139
5/6

Summary
    array.xi: Failed to execute: array exit code 139
    concat.xi: Failed to execute: concat exit code 139
    funcs.xi: OK
    multifunc.xi: Executable time limit of 30 SECONDS exceeded
      Stream closed
  xic-ref (-target linux [global test]): 1 out of 5 tests succeeded.
    Has addressing mode: false
  Test collection: xic-ref (-target linux -O [global test])
    arr2.xi: Failed to execute: arr2 exit code 139
    array.xi: Failed to execute: array exit code 139
    concat.xi: Failed to execute: concat exit code 139
    funcs.xi: OK
    multifunc.xi: Executable time limit of 30 SECONDS exceeded
      Stream closed
  xic-ref (-target linux -O [global test]): 1 out of 5 tests succeeded.
    Has addressing mode: false
xthScript: 71 out of 210 tests succeeded.
6/6

xic (Test -target linux): ack.xi
xic (Test -target linux): ack.xi
Failed to execute: ack exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-compilers/pa/pa5/grading/tests/../../../../project/xth/tests/pa5/
-target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../../project/xth/tests/pa5/ack.xi
1 use io
2 use conv
3
4 usage() {
5 println("Please specify the input size") 6}
7
8 main(args:int[][]) {
9 n: int = 11
10 r: int = Ack(2, n)
11
12 print("Ack(2,")
13 print(unparseInt(n)) 14 print("): ")
15 print(unparseInt(r)) 16 println("")
17 }
18
19 Ack(m:int, n:int):int {
20 if (m == 0) { return n+1 }
21 else if (n == 0) { return Ack(m-1, 1) }
22 else { return Ack(m-1, Ack(m, n-1)) }
23 }
Compiler's standard output:
ASM generated
Generated result:
./ack.s.nml
Expected result:
./ack.ssol.nml
1 Ack(2,11): 25
1/1

xic (Test -target linux): primes.xi
xic (Test -target linux): primes.xi
Executable time limit of 30 SECONDS exceeded
Stream closed
Command line without filenames:
xic -libpath /home/charles/ta-compilers/pa/pa5/grading/tests/../../../../project/xth/tests/pa5/
-target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../../project/xth/tests/pa5/primes.xi
1 // Self-verifying. Output removed so it can 2 // successfully compare against empty file. 3 use io
4 use conv
5
6 gcd(a:int, b:int):int {
7 8 9
while (a != 0) {
    if (a<b) b = b - a
    else a = a - b
10 }
11 return b
12 }
13
14 isprime(n:int):bool {
15
16
17
18
19 }
20 i = i+1 21 }
22 return true
23 }
24
25 largestprime(max:int):int {
i:int = 2
while (i*i <= n) {
26
27
28
29
30
31 }
32 return largest 33 }
if (gcd(i, n) != 1) {
    return false
a:int = 1
largest:int = 1
while (a < max) {
if (isprime(a)) largest = a
a = a+1
34
35 main(args:int[][]) {
36 print("Largest prime less than 1,000 is " + unparseInt(largestprime(1000))) 37 }
Compiler's standard output:
ASM generated
Generated result:
./primes.s.nml
Expected result:
./primes.ssol.nml
1 Largest prime less than 1,000 is 997
1/1

xic (Test -target linux -O): ack.xi
xic (Test -target linux -O): ack.xi
Failed to execute: ack exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-compilers/pa/pa5/grading/tests/../../../../project/xth/tests/pa5/
-target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../../project/xth/tests/pa5/ack.xi
1 use io
2 use conv
3
4 usage() {
5 println("Please specify the input size") 6}
7
8 main(args:int[][]) {
9 n: int = 11
10 r: int = Ack(2, n)
11
12 print("Ack(2,")
13 print(unparseInt(n)) 14 print("): ")
15 print(unparseInt(r)) 16 println("")
17 }
18
19 Ack(m:int, n:int):int {
20 if (m == 0) { return n+1 }
21 else if (n == 0) { return Ack(m-1, 1) }
22 else { return Ack(m-1, Ack(m, n-1)) }
23 }
Compiler's standard output:
ASM generated
Generated result:
./ack.s.nml
Expected result:
./ack.ssol.nml
1 Ack(2,11): 25
1/1

xic (Test -target linux -O): primes.xi
xic (Test -target linux -O): primes.xi
Executable time limit of 30 SECONDS exceeded
Stream closed
Command line without filenames:
xic -libpath /home/charles/ta-compilers/pa/pa5/grading/tests/../../../../project/xth/tests/pa5/
-target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../../project/xth/tests/pa5/primes.xi
1 // Self-verifying. Output removed so it can 2 // successfully compare against empty file. 3 use io
4 use conv
5
6 gcd(a:int, b:int):int {
7 8 9
while (a != 0) {
    if (a<b) b = b - a
    else a = a - b
10 }
11 return b
12 }
13
14 isprime(n:int):bool {
15
16
17
18
19 }
20 i = i+1 21 }
22 return true
23 }
24
25 largestprime(max:int):int {
i:int = 2
while (i*i <= n) {
26
27
28
29
30
31 }
32 return largest 33 }
if (gcd(i, n) != 1) {
    return false
a:int = 1
largest:int = 1
while (a < max) {
if (isprime(a)) largest = a
a = a+1
34
35 main(args:int[][]) {
36 print("Largest prime less than 1,000 is " + unparseInt(largestprime(1000))) 37 }
Compiler's standard output:
ASM generated
Generated result:
./primes.s.nml
Expected result:
./primes.ssol.nml
1 Largest prime less than 1,000 is 997
1/1

xic-ref (-target linux [basic test]): arracc01.xi
xic-ref (-target linux [basic test]): arracc01.xi
Missing line in file arracc01.s.nml: 0
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arracc01.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[5]
6 i: int = 0
7 while (i < length(a)) {
8
a[i] = i i=i+ 1
Compiler's standard output:
ASM generated
Generated result:
./arracc01.s.nml
Expected result:
./arracc01.ssol.nml
10 21 32 43 54
9
10 }
11 i = 0
12 while (i < length(a)) {
13 println(unparseInt(a[i])) 14 i=i+ 1
15 }
16 }
1/1

xic-ref (-target linux [basic test]): arracc02.xi
xic-ref (-target linux [basic test]): arracc02.xi
Missing line in file arracc02.s.nml: Index: 0
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arracc02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[5]
6 i: int = 0
7 while (i < length(a)) {
8
a[i] = i i=i+ 1
9
10 }
11 i = 0
12 while (i < length(a)) {
13 println(unparseInt(a[f(i)])) 14 i=i+ 1
15 }
16 }
17
18 f(i: int): int {
19 print("Index: ")
20 println(unparseInt(i))
21 return i
22 }
Compiler's standard output:
ASM generated
Generated result:
./arracc02.s.nml
Expected result:
./arracc02.ssol.nml
1 Index: 0 20
3 Index: 1 41
5 Index: 2 62
7 Index: 3 83
9 Index: 4 10 4
1/1

xic-ref (-target linux [basic test]): arracc03.xi
xic-ref (-target linux [basic test]): arracc03.xi
Failed to execute: arracc03 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arracc03.xi
1 use io
2 use conv
3
4 main(args: int[][]) { 5 a: int[5][4]
6{
7
8
9
16 } 17 { 18
19
i: int = 0
while (i < length(a)) {
i: int = 0
while (i < length(a)) {
j: int = 0
while (j < length(a[i])) {
10
11
12
13 }
14 i=i+ 1 15 }
20
21
22
23
24 }
25 i=i+ 1 26 }
27 } 28 }
a[i][j] = i + j j=j+ 1
         j: int = 0
         while (j < length(a[i])) {
println(unparseInt(a[i][j])) j=j+ 1
Compiler's standard output:
ASM generated
Generated result:
./arracc03.s.nml
Expected result:
./arracc03.ssol.nml
10 21 32 43 51 62 73 84 92
10 3 11 4 12 5 13 3 14 4
1/2

xic-ref (-target linux [basic test]): arracc03.xi
15 5 16 6 17 4 18 5 19 6 20 7
2/2

xic-ref (-target linux [basic test]): arracc04.xi
xic-ref (-target linux [basic test]): arracc04.xi
Failed to execute: arracc04 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arracc04.xi
1 use io
2 use conv
3
4 main(args: int[][]) { 5 a: int[5][4]
6{
7
8
9
16 } 17 { 18
19
i: int = 0
while (i < length(a)) {
i: int = 0
while (i < length(a)) {
j: int = 0
while (j < length(a[i])) {
10
11
12
13 }
14 i=i+ 1 15 }
=i+ j 1
20
21
22
23
24 }
25 i=i+ 1 26 }
a[i][j] j=j +
j: int = 0
while (j < length(a[i])) {
println(unparseInt(a[f(i)][f(j)])) j=j+ 1
27 }
28 }
29
30 f(i: int): int {
31 print("Index: ")
32 println(unparseInt(i)) 33 return i
34 }
Compiler's standard output:
ASM generated
Generated result:
./arracc04.s.nml
Expected result:
./arracc04.ssol.nml
1 Index: 0 2 Index: 0 30
4 Index: 0 5 Index: 1 61
7 Index: 0 8 Index: 2
1/2

xic-ref (-target linux [basic test]): arracc04.xi
92
10 Index: 0 11 Index: 3 12 3
13 Index: 1 14 Index: 0 15 1
16 Index: 1 17 Index: 1 18 2
19 Index: 1 20 Index: 2 21 3
22 Index: 1 23 Index: 3 24 4
25 Index: 2 26 Index: 0 27 2
28 Index: 2 29 Index: 1 30 3
31 Index: 2 32 Index: 2 33 4
34 Index: 2 35 Index: 3 36 5
37 Index: 3 38 Index: 0 39 3
40 Index: 3 41 Index: 1 42 4
43 Index: 3 44 Index: 2 45 5
46 Index: 3 47 Index: 3 48 6
49 Index: 4 50 Index: 0 51 4
52 Index: 4 53 Index: 1 54 5
55 Index: 4 56 Index: 2 57 6
58 Index: 4 59 Index: 3 60 7
2/2

xic-ref (-target linux [basic test]): arracc07.xi
xic-ref (-target linux [basic test]): arracc07.xi
Missing line in file arracc07.s.nml: Index: 0
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arracc07.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[5]
6 i: int = 0
7 while (i < length(a)) {
8
a[i] = i -1 i=i+ 1
9
10 }
11 i = 0
12
13
14
15
16
17
18 }
19 i=i+ 1 20 }
21 }
22
23 f(a: int[], i: int): int { 24 print("Index: ")
25 println(unparseInt(i))
26 a[i] = a[i] + 1
27 return a[i]
28 }
Compiler's standard output:
ASM generated
Generated result:
./arracc07.s.nml
Expected result:
./arracc07.ssol.nml
1 Index: 0 2 Index: 0 31
41
50
61
72
83
9 Index: 1
10 Index: 1 11 1
12 1
13 2
14 1
while (i < length(a)) {
  println(unparseInt(a[a[-(f(a, i) - f(a, i))]]))
  j: int = 0
  while (j < length(a)) {
println(unparseInt(a[j])) j=j+ 1
1/2

xic-ref (-target linux [basic test]): arracc07.xi
15 2
16 3
17 Index: 2 18 Index: 2 19 3
20 1
21 2
22 3
23 2
24 3
25 Index: 3 26 Index: 3 27 3
28 1
29 2
30 3
31 4
32 3
33 Index: 4 34 Index: 4 35 3
36 1
37 2
38 3
39 4
40 5
2/2

xic-ref (-target linux [basic test]): arracc08.xi
xic-ref (-target linux [basic test]): arracc08.xi
Failed to execute: arracc08 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arracc08.xi
1 use io
2 use conv
3
4 main(args: int[][]) { 5 a: int[5][4]
6{
7
8
9
i: int = 0
while (i < length(a)) {
j: int = 0
while (j < length(a[i])) {
10
11
12
13 }
14 i=i+ 1 15 }
a[i][j] = i + j j=j+ 1
16 }
17 println(unparseInt(a[f(a, 4, 2)-3][f(a, 4, 2)-6])) 18 }
19
20 f(a: int[][], i: int, j: int): int {
21 print("Index: ")
22 print(unparseInt(i))
23 print(" ")
24 println(unparseInt(j))
25 a[i][j] = a[i][j] + 1
26 return a[i][j]
27 }
Compiler's standard output:
ASM generated
Generated result:
./arracc08.s.nml
Expected result:
./arracc08.ssol.nml
1 Index: 4 2 2 Index: 4 2 38
1/1

xic-ref (-target linux [basic test]): arrinit01.xi
xic-ref (-target linux [basic test]): arrinit01.xi
Missing line in file arrinit01.s.nml: 1
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arrinit01.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[] = {1, 2, 3, 4, 5}
6 i: int = 0
7 while (i < length(a)) {
8 println(unparseInt(a[i])) 9 i=i+ 1
10 } 11 }
Compiler's standard output:
ASM generated
Generated result:
./arrinit01.s.nml
Expected result:
./arrinit01.ssol.nml
11 22 33 44 55
1/1

xic-ref (-target linux [basic test]): arrinit02.xi
xic-ref (-target linux [basic test]): arrinit02.xi
Failed to execute: arrinit02 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arrinit02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[] = {f(1), f(2), f(3), f(4), f(5)}
6 i: int = 0
7 while (i < length(a)) {
8 println(unparseInt(a[i])) 9 i=i+ 1
10 }
11 }
12
13 f(i: int): int {
14 print("f() called: ") 15 println(unparseInt(i)) 16 return i
17 }
Compiler's standard output:
ASM generated
Generated result:
./arrinit02.s.nml
1 f() called: 0 2 f() called: 0 3 f() called: 0 4 f() called: 0 5 f() called: 0 60
70 80 90
10 0 11 0 12 0 13 0 14 0 15 0 16 0 17 0 18 0 19 0 20 0 21 0 22 0 23 0 24 0 25 0 26 0 27 0 28 0
1/374

xic-ref (-target linux [basic test]): arrinit02.xi
29 0 30 0 31 0 32 0 33 0 34 0 35 0 36 0 37 0 38 0 39 0 40 0 41 0 42 0 43 0 44 0 45 0 46 0 47 0 48 0 49 0 50 0 51 0 52 0 53 0 54 0 55 0 56 0 57 0 58 0 59 0 60 0 61 0 62 0 63 0 64 0 65 0 66 0 67 0 68 0 69 0 70 0 71 0 72 0 73 0 74 0 75 0 76 0 77 0 78 0 79 0 80 0 81 0 82 0 83 0 84 0 85 0 86 0 87 0 88 0
2/374

xic-ref (-target linux [basic test]): arrinit02.xi
89 0 90 0 91 0 92 0 93 0 94 0 95 0 96 0 97 0 98 0 99 0
100 0
101 0
102 0
103 0
104 0
105 0
106 0
107 0
108 0
109 0
110 0
111 0
112 0
113 0
114 0
115 0
116 0
117 0
118 0
119 0
120 0
121 0
122 0
123 0
124 0
125 0
126 0
127 0
128 0
129 38335360 130 0
131 0
132 0
133 38335392 134 0
135 0
136 0
137 38335424 138 0
139 0
140 0
141 38335456 142 0
143 0
144 0
145 38335488 146 0
147 0
148 0
3/374

xic-ref (-target linux [basic test]): arrinit02.xi
149 38335520 150 0
151 0
152 0
153 38335552 154 0
155 0
156 0
157 38335584 158 0
159 0
160 0
161 38335616 162 0
163 0
164 0
165 38335648 166 0
167 0
168 0
169 38335680 170 0
171 0
172 0
173 38335712 174 0
175 0
176 0
177 38335744 178 0
179 0
180 0
181 38335776 182 0
183 0
184 0
185 38335808 186 0
187 0
188 0
189 38335840 190 0
191 0
192 0
193 38335872 194 0
195 0
196 0
197 38335904 198 0
199 0
200 0
201 38335936 202 0
203 0
204 0
205 38335968 206 0
207 0
208 0
4/374

xic-ref (-target linux [basic test]): arrinit02.xi
209 38336000 210 0
211 0
212 0
213 38336032 214 0
215 0
216 0
217 38336064 218 0
219 0
220 0
221 38336096 222 0
223 0
224 0
225 38336128 226 0
227 0
228 0
229 1 230 48 231 0 232 0 233 1 234 48 235 0 236 0 237 1 238 48 239 0 240 0 241 1 242 48 243 0 244 0 245 1 246 48 247 0 248 0 249 1 250 48 251 0 252 0 253 1 254 48 255 0 256 0 257 1 258 48 259 0 260 0 261 1 262 48 263 0 264 0 265 1 266 48 267 0 268 0
5/374

xic-ref (-target linux [basic test]): arrinit02.xi
269 1 270 48 271 0 272 0 273 1 274 48 275 0 276 0 277 1 278 48 279 0 280 0 281 1 282 48 283 0 284 0 285 1 286 48 287 0 288 0 289 1 290 48 291 0 292 0 293 1 294 48 295 0 296 0 297 1 298 48 299 0 300 0 301 1 302 48 303 0 304 0 305 1 306 48 307 0 308 0 309 1 310 48 311 0 312 0 313 1 314 48 315 0 316 0 317 1 318 48 319 0 320 0 321 1 322 48 323 0 324 0 325 1 326 48 327 0 328 0
6/374

xic-ref (-target linux [basic test]): arrinit02.xi
329 1 330 48 331 0 332 0 333 1 334 48 335 0 336 0 337 1 338 48 339 0 340 0 341 1 342 48 343 0 344 0 345 1 346 48 347 0 348 0 349 1 350 48 351 0 352 0 353 1 354 48 355 0 356 0 357 1 358 48 359 0 360 0 361 1 362 48 363 0 364 0 365 1 366 48 367 0 368 0 369 1 370 48 371 0 372 0 373 1 374 48 375 0 376 0 377 1 378 48 379 0 380 0 381 1 382 48 383 0 384 0 385 1 386 48 387 0 388 0
7/374

xic-ref (-target linux [basic test]): arrinit02.xi
389 1 390 48 391 0 392 0 393 1 394 48 395 0 396 0 397 1 398 48 399 0 400 0 401 1 402 48 403 0 404 0 405 1 406 48 407 0 408 0 409 1 410 48 411 0 412 0 413 1 414 48 415 0 416 0 417 1 418 48 419 0 420 0 421 1 422 48 423 0 424 0 425 1 426 48 427 0 428 0 429 1 430 48 431 0 432 0 433 1 434 48 435 0 436 0 437 1 438 48 439 0 440 0 441 1 442 48 443 0 444 0 445 1 446 48 447 0 448 0
8/374

xic-ref (-target linux [basic test]): arrinit02.xi
449 1 450 48 451 0 452 0 453 1 454 48 455 0 456 0 457 1 458 48 459 0 460 0 461 1 462 48 463 0 464 0 465 1 466 48 467 0 468 0 469 1 470 48 471 0 472 0 473 1 474 48 475 0 476 0 477 1 478 48 479 0 480 0 481 1 482 48 483 0 484 0 485 1 486 48 487 0 488 0 489 1 490 48 491 0 492 0 493 1 494 48 495 0 496 0 497 1 498 48 499 0 500 0 501 1 502 48 503 0 504 0 505 1 506 48 507 0 508 0
9/374

xic-ref (-target linux [basic test]): arrinit02.xi
509 1
510 48
511 0
512 0
513 1
514 48
515 0
516 0
517 1
518 48
519 0
520 0
521 1
522 48
523 0
524 0
525 0
526 0
527 0
528 0
529 0
530 0
531 0
532 0
533 0
534 0
535 38338560 536 0
537 0
538 0
539 0
540 0
541 0
542 0
543 0
544 0
545 38338640 546 0
547 0
548 0
549 0
550 0
551 0
552 0
553 0
554 0
555 38338720 556 0
557 0
558 0
559 0
560 0
561 0
562 0
563 0
564 0
565 38338800 566 0
567 0 568 0
10/374

xic-ref (-target linux [basic test]): arrinit02.xi
569 0
570 0
571 0
572 0
573 0
574 0
575 38338880 576 0
577 0
578 0
579 0
580 0
581 0
582 0
583 0
584 0
585 38338960 586 0
587 0
588 0
589 0
590 0
591 0
592 0
593 0
594 0
595 38339040 596 0
597 0
598 0
599 0
600 0
601 0
602 0
603 0
604 0
605 38339120 606 0
607 0
608 0
609 0
610 0
611 0
612 0
613 0
614 0
615 38339200 616 0
617 0
618 0
619 0
620 0
621 0
622 0
623 0
624 0
625 38339280 626 0
627 0 628 0
11/374

xic-ref (-target linux [basic test]): arrinit02.xi
629 0
630 0
631 0
632 0
633 0
634 0
635 38339360 636 0
637 0
638 0
639 0
640 0
641 0
642 0
643 0
644 0
645 38339440 646 0
647 0
648 0
649 0
650 0
651 0
652 0
653 0
654 0
655 38339520 656 51
657 56 658 51 659 51 660 57 661 53 662 50 663 48 664 0 665 8 666 51 667 56 668 51 669 51 670 57 671 52 672 52 673 48 674 0 675 8 676 51 677 56 678 51 679 51 680 57 681 51 682 54 683 48 684 0 685 8 686 51 687 56 688 51
12/374

xic-ref (-target linux [basic test]): arrinit02.xi
689 51 690 57 691 50 692 56 693 48 694 0 695 8 696 51 697 56 698 51 699 51 700 57 701 50 702 48 703 48 704 0 705 8 706 51 707 56 708 51 709 51 710 57 711 49 712 50 713 48 714 0 715 8 716 51 717 56 718 51 719 51 720 57 721 48 722 52 723 48 724 0 725 8 726 51 727 56 728 51 729 51 730 56 731 57 732 54 733 48 734 0 735 8 736 51 737 56 738 51 739 51 740 56 741 56 742 56 743 48 744 0 745 8 746 51 747 56 748 51
13/374

xic-ref (-target linux [basic test]): arrinit02.xi
749 51 750 56 751 56 752 48 753 48 754 0 755 8 756 51 757 56 758 51 759 51 760 56 761 55 762 50 763 48 764 0 765 8 766 51 767 56 768 51 769 51 770 56 771 54 772 52 773 48 774 0 775 8 776 51 777 56 778 51 779 51 780 56 781 53 782 54 783 48 784 0 785 8 786 51 787 56 788 51 789 51 790 54 791 49 792 50 793 56 794 0 795 8 796 51 797 56 798 51 799 51 800 54 801 48 802 57 803 54 804 0 805 8 806 51 807 56 808 51
14/374

xic-ref (-target linux [basic test]): arrinit02.xi
809 51 810 54 811 48 812 54 813 52 814 0 815 8 816 51 817 56 818 51 819 51 820 54 821 48 822 51 823 50 824 0 825 8 826 51 827 56 828 51 829 51 830 54 831 48 832 48 833 48 834 0 835 8 836 51 837 56 838 51 839 51 840 53 841 57 842 54 843 56 844 0 845 8 846 51 847 56 848 51 849 51 850 53 851 57 852 51 853 54 854 0 855 8 856 51 857 56 858 51 859 51 860 53 861 57 862 48 863 52 864 0 865 8 866 51 867 56 868 51
15/374

xic-ref (-target linux [basic test]): arrinit02.xi
869 51 870 53 871 56 872 55 873 50 874 0 875 8 876 51 877 56 878 51 879 51 880 53 881 56 882 52 883 48 884 0 885 8 886 51 887 56 888 51 889 51 890 53 891 56 892 48 893 56 894 0 895 8 896 51 897 56 898 51 899 51 900 53 901 55 902 55 903 54 904 0 905 8 906 51 907 56 908 51 909 51 910 53 911 55 912 52 913 52 914 0 915 8 916 51 917 56 918 51 919 51 920 53 921 55 922 49 923 50 924 0 925 8 926 51 927 56 928 51
16/374

xic-ref (-target linux [basic test]): arrinit02.xi
929 51 930 53 931 54 932 56 933 48 934 0 935 8 936 51 937 56 938 51 939 51 940 53 941 54 942 52 943 56 944 0 945 8 946 51 947 56 948 51 949 51 950 53 951 54 952 49 953 54 954 0 955 8 956 51 957 56 958 51 959 51 960 53 961 53 962 56 963 52 964 0 965 8 966 51 967 56 968 51 969 51 970 53 971 53 972 53 973 50 974 0 975 8 976 51 977 56 978 51 979 51 980 53 981 53 982 50 983 48 984 0 985 8 986 51 987 56 988 51
17/374

xic-ref (-target linux [basic test]): arrinit02.xi
989 51 990 53 991 52 992 56 993 56 994 0 995 8 996 51 997 56 998 51 999 51
1000 53 1001 52 1002 53 1003 54 1004 0 1005 8 1006 51 1007 56 1008 51 1009 51 1010 53 1011 52 1012 50 1013 52 1014 0 1015 8 1016 51 1017 56 1018 51 1019 51 1020 53 1021 51 1022 57 1023 50 1024 0 1025 8 1026 51 1027 56 1028 51 1029 51 1030 53 1031 51 1032 54 1033 48 1034 0 1035 0 1036 0 1037 1 1038 48 1039 0 1040 0 1041 1 1042 48 1043 0 1044 0 1045 2 1046 52 1047 56 1048 0
18/374

xic-ref (-target linux [basic test]): arrinit02.xi
1049 1 1050 49 1051 0 1052 0 1053 1 1054 48 1055 0 1056 0 1057 1 1058 48 1059 0 1060 0 1061 2 1062 52 1063 56 1064 0 1065 1 1066 49 1067 0 1068 0 1069 1 1070 48 1071 0 1072 0 1073 1 1074 48 1075 0 1076 0 1077 2 1078 52 1079 56 1080 0 1081 1 1082 49 1083 0 1084 0 1085 1 1086 48 1087 0 1088 0 1089 1 1090 48 1091 0 1092 0 1093 2 1094 52 1095 56 1096 0 1097 1 1098 49 1099 0 1100 0 1101 1 1102 48 1103 0 1104 0 1105 1 1106 48 1107 0 1108 0
19/374

xic-ref (-target linux [basic test]): arrinit02.xi
1109 2 1110 52 1111 56 1112 0 1113 1 1114 49 1115 0 1116 0 1117 1 1118 48 1119 0 1120 0 1121 1 1122 48 1123 0 1124 0 1125 2 1126 52 1127 56 1128 0 1129 1 1130 49 1131 0 1132 0 1133 1 1134 48 1135 0 1136 0 1137 1 1138 48 1139 0 1140 0 1141 2 1142 52 1143 56 1144 0 1145 1 1146 49 1147 0 1148 0 1149 1 1150 48 1151 0 1152 0 1153 1 1154 48 1155 0 1156 0 1157 2 1158 52 1159 56 1160 0 1161 1 1162 49 1163 0 1164 0 1165 1 1166 48 1167 0 1168 0
20/374

xic-ref (-target linux [basic test]): arrinit02.xi
1169 1 1170 48 1171 0 1172 0 1173 2 1174 52 1175 56 1176 0 1177 1 1178 49 1179 0 1180 0 1181 1 1182 48 1183 0 1184 0 1185 1 1186 48 1187 0 1188 0 1189 2 1190 52 1191 56 1192 0 1193 1 1194 49 1195 0 1196 0 1197 1 1198 48 1199 0 1200 0 1201 1 1202 48 1203 0 1204 0 1205 2 1206 52 1207 56 1208 0 1209 1 1210 49 1211 0 1212 0 1213 1 1214 48 1215 0 1216 0 1217 1 1218 48 1219 0 1220 0 1221 2 1222 52 1223 56 1224 0 1225 1 1226 49 1227 0 1228 0
21/374

xic-ref (-target linux [basic test]): arrinit02.xi
1229 1 1230 48 1231 0 1232 0 1233 1 1234 48 1235 0 1236 0 1237 2 1238 52 1239 56 1240 0 1241 1 1242 49 1243 0 1244 0 1245 1 1246 48 1247 0 1248 0 1249 1 1250 48 1251 0 1252 0 1253 2 1254 52 1255 56 1256 0 1257 1 1258 49 1259 0 1260 0 1261 1 1262 48 1263 0 1264 0 1265 1 1266 48 1267 0 1268 0 1269 2 1270 52 1271 56 1272 0 1273 1 1274 49 1275 0 1276 0 1277 1 1278 48 1279 0 1280 0 1281 1 1282 48 1283 0 1284 0 1285 2 1286 52 1287 56 1288 0
22/374

xic-ref (-target linux [basic test]): arrinit02.xi
1289 1 1290 49 1291 0 1292 0 1293 1 1294 48 1295 0 1296 0 1297 1 1298 48 1299 0 1300 0 1301 2 1302 52 1303 56 1304 0 1305 1 1306 49 1307 0 1308 0 1309 1 1310 48 1311 0 1312 0 1313 1 1314 48 1315 0 1316 0 1317 2 1318 52 1319 56 1320 0 1321 1 1322 49 1323 0 1324 0 1325 1 1326 48 1327 0 1328 0 1329 1 1330 48 1331 0 1332 0 1333 2 1334 52 1335 56 1336 0 1337 1 1338 49 1339 0 1340 0 1341 1 1342 48 1343 0 1344 0 1345 1 1346 48 1347 0 1348 0
23/374

xic-ref (-target linux [basic test]): arrinit02.xi
1349 2 1350 52 1351 56 1352 0 1353 1 1354 49 1355 0 1356 0 1357 1 1358 48 1359 0 1360 0 1361 1 1362 48 1363 0 1364 0 1365 2 1366 52 1367 56 1368 0 1369 1 1370 49 1371 0 1372 0 1373 1 1374 48 1375 0 1376 0 1377 1 1378 48 1379 0 1380 0 1381 2 1382 52 1383 56 1384 0 1385 1 1386 49 1387 0 1388 0 1389 1 1390 48 1391 0 1392 0 1393 1 1394 48 1395 0 1396 0 1397 2 1398 52 1399 56 1400 0 1401 1 1402 49 1403 0 1404 0 1405 1 1406 48 1407 0 1408 0
24/374

xic-ref (-target linux [basic test]): arrinit02.xi
1409 1 1410 48 1411 0 1412 0 1413 2 1414 52 1415 56 1416 0 1417 1 1418 49 1419 0 1420 0 1421 1 1422 48 1423 0 1424 0 1425 1 1426 48 1427 0 1428 0 1429 2 1430 52 1431 56 1432 0 1433 1 1434 49 1435 0 1436 0 1437 1 1438 48 1439 0 1440 0 1441 1 1442 48 1443 0 1444 0 1445 2 1446 52 1447 56 1448 0 1449 1 1450 49 1451 0 1452 0 1453 1 1454 48 1455 0 1456 0 1457 1 1458 48 1459 0 1460 0 1461 2 1462 52 1463 56 1464 0 1465 1 1466 49 1467 0 1468 0
25/374

xic-ref (-target linux [basic test]): arrinit02.xi
1469 1 1470 48 1471 0 1472 0 1473 1 1474 48 1475 0 1476 0 1477 2 1478 52 1479 56 1480 0 1481 1 1482 49 1483 0 1484 0 1485 1 1486 48 1487 0 1488 0 1489 1 1490 48 1491 0 1492 0 1493 2 1494 52 1495 56 1496 0 1497 1 1498 49 1499 0 1500 0 1501 1 1502 48 1503 0 1504 0 1505 1 1506 48 1507 0 1508 0 1509 2 1510 52 1511 56 1512 0 1513 1 1514 49 1515 0 1516 0 1517 1 1518 48 1519 0 1520 0 1521 1 1522 48 1523 0 1524 0 1525 2 1526 52 1527 56 1528 0
26/374

xic-ref (-target linux [basic test]): arrinit02.xi
1529 1 1530 49 1531 0 1532 0 1533 1 1534 48 1535 0 1536 0 1537 1 1538 48 1539 0 1540 0 1541 2 1542 52 1543 56 1544 0 1545 1 1546 49 1547 0 1548 0 1549 1 1550 48 1551 0 1552 0 1553 1 1554 48 1555 0 1556 0 1557 1 1558 48 1559 0 1560 0 1561 1 1562 48 1563 0 1564 0 1565 1 1566 48 1567 0 1568 0 1569 1 1570 48 1571 0 1572 0 1573 1 1574 48 1575 0 1576 0 1577 1 1578 48 1579 0 1580 0 1581 1 1582 48 1583 0 1584 0 1585 1 1586 48 1587 0 1588 0
27/374

xic-ref (-target linux [basic test]): arrinit02.xi
1589 1 1590 48 1591 0 1592 0 1593 1 1594 48 1595 0 1596 0 1597 1 1598 48 1599 0 1600 0 1601 1 1602 48 1603 0 1604 0 1605 2 1606 52 1607 56 1608 0 1609 1 1610 49 1611 0 1612 0 1613 1 1614 48 1615 0 1616 0 1617 1 1618 48 1619 0 1620 0 1621 2 1622 52 1623 56 1624 0 1625 1 1626 49 1627 0 1628 0 1629 1 1630 48 1631 0 1632 0 1633 1 1634 48 1635 0 1636 0 1637 2 1638 52 1639 56 1640 0 1641 1 1642 49 1643 0 1644 0 1645 1 1646 48 1647 0 1648 0
28/374

xic-ref (-target linux [basic test]): arrinit02.xi
1649 1 1650 48 1651 0 1652 0 1653 2 1654 52 1655 56 1656 0 1657 1 1658 49 1659 0 1660 0 1661 1 1662 48 1663 0 1664 0 1665 1 1666 48 1667 0 1668 0 1669 2 1670 52 1671 56 1672 0 1673 1 1674 49 1675 0 1676 0 1677 1 1678 48 1679 0 1680 0 1681 1 1682 48 1683 0 1684 0 1685 2 1686 52 1687 56 1688 0 1689 1 1690 49 1691 0 1692 0 1693 1 1694 48 1695 0 1696 0 1697 1 1698 48 1699 0 1700 0 1701 2 1702 52 1703 56 1704 0 1705 1 1706 49 1707 0 1708 0
29/374

xic-ref (-target linux [basic test]): arrinit02.xi
1709 1 1710 48 1711 0 1712 0 1713 1 1714 48 1715 0 1716 0 1717 2 1718 52 1719 56 1720 0 1721 1 1722 49 1723 0 1724 0 1725 1 1726 48 1727 0 1728 0 1729 1 1730 48 1731 0 1732 0 1733 2 1734 52 1735 56 1736 0 1737 1 1738 49 1739 0 1740 0 1741 1 1742 48 1743 0 1744 0 1745 1 1746 48 1747 0 1748 0 1749 2 1750 52 1751 56 1752 0 1753 1 1754 49 1755 0 1756 0 1757 1 1758 48 1759 0 1760 0 1761 1 1762 48 1763 0 1764 0 1765 2 1766 52 1767 56 1768 0
30/374

xic-ref (-target linux [basic test]): arrinit02.xi
1769 1 1770 49 1771 0 1772 0 1773 1 1774 48 1775 0 1776 0 1777 1 1778 48 1779 0 1780 0 1781 2 1782 52 1783 56 1784 0 1785 1 1786 49 1787 0 1788 0 1789 1 1790 48 1791 0 1792 0 1793 1 1794 48 1795 0 1796 0 1797 2 1798 52 1799 56 1800 0 1801 1 1802 49 1803 0 1804 0 1805 1 1806 48 1807 0 1808 0 1809 1 1810 48 1811 0 1812 0 1813 2 1814 52 1815 56 1816 0 1817 1 1818 49 1819 0 1820 0 1821 1 1822 48 1823 0 1824 0 1825 1 1826 48 1827 0 1828 0
31/374

xic-ref (-target linux [basic test]): arrinit02.xi
1829 2 1830 52 1831 56 1832 0 1833 1 1834 49 1835 0 1836 0 1837 1 1838 48 1839 0 1840 0 1841 1 1842 48 1843 0 1844 0 1845 2 1846 52 1847 56 1848 0 1849 1 1850 49 1851 0 1852 0 1853 1 1854 48 1855 0 1856 0 1857 1 1858 48 1859 0 1860 0 1861 2 1862 52 1863 56 1864 0 1865 1 1866 49 1867 0 1868 0 1869 1 1870 48 1871 0 1872 0 1873 1 1874 48 1875 0 1876 0 1877 2 1878 52 1879 56 1880 0 1881 1 1882 49 1883 0 1884 0 1885 1 1886 48 1887 0 1888 0
32/374

xic-ref (-target linux [basic test]): arrinit02.xi
1889 1 1890 48 1891 0 1892 0 1893 2 1894 52 1895 56 1896 0 1897 1 1898 49 1899 0 1900 0 1901 1 1902 48 1903 0 1904 0 1905 1 1906 48 1907 0 1908 0 1909 2 1910 52 1911 56 1912 0 1913 1 1914 49 1915 0 1916 0 1917 1 1918 48 1919 0 1920 0 1921 1 1922 48 1923 0 1924 0 1925 2 1926 52 1927 56 1928 0 1929 1 1930 49 1931 0 1932 0 1933 1 1934 48 1935 0 1936 0 1937 1 1938 48 1939 0 1940 0 1941 2 1942 52 1943 56 1944 0 1945 1 1946 49 1947 0 1948 0
33/374

xic-ref (-target linux [basic test]): arrinit02.xi
1949 1 1950 48 1951 0 1952 0 1953 1 1954 48 1955 0 1956 0 1957 2 1958 52 1959 56 1960 0 1961 1 1962 49 1963 0 1964 0 1965 1 1966 48 1967 0 1968 0 1969 1 1970 48 1971 0 1972 0 1973 2 1974 52 1975 56 1976 0 1977 1 1978 49 1979 0 1980 0 1981 1 1982 48 1983 0 1984 0 1985 1 1986 48 1987 0 1988 0 1989 2 1990 52 1991 56 1992 0 1993 1 1994 49 1995 0 1996 0 1997 1 1998 48 1999 0 2000 0 2001 1 2002 48 2003 0 2004 0 2005 2 2006 52 2007 56 2008 0
34/374

xic-ref (-target linux [basic test]): arrinit02.xi
2009 1 2010 49 2011 0 2012 0 2013 1 2014 48 2015 0 2016 0 2017 1 2018 48 2019 0 2020 0 2021 2 2022 52 2023 56 2024 0 2025 1 2026 49 2027 0 2028 0 2029 1 2030 48 2031 0 2032 0 2033 1 2034 48 2035 0 2036 0 2037 2 2038 52 2039 56 2040 0 2041 1 2042 49 2043 0 2044 0 2045 1 2046 48 2047 0 2048 0 2049 1 2050 48 2051 0 2052 0 2053 2 2054 52 2055 56 2056 0 2057 1 2058 49 2059 0 2060 0 2061 2 2062 53 2063 54 2064 0 2065 2 2066 53 2067 49 2068 0
35/374

xic-ref (-target linux [basic test]): arrinit02.xi
2069 1 2070 56 2071 0 2072 0 2073 1 2074 48 2075 0 2076 0 2077 2 2078 52 2079 56 2080 0 2081 2 2082 53 2083 50 2084 0 2085 2 2086 53 2087 50 2088 0 2089 2 2090 53 2091 55 2092 0 2093 2 2094 53 2095 49 2096 0 2097 2 2098 53 2099 49 2100 0 2101 2 2102 53 2103 54 2104 0 2105 2 2106 53 2107 49 2108 0 2109 1 2110 56 2111 0 2112 0 2113 1 2114 48 2115 0 2116 0 2117 2 2118 52 2119 56 2120 0 2121 2 2122 53 2123 48 2124 0 2125 2 2126 53 2127 51 2128 0
36/374

xic-ref (-target linux [basic test]): arrinit02.xi
2129 2 2130 53 2131 55 2132 0 2133 2 2134 53 2135 49 2136 0 2137 2 2138 53 2139 49 2140 0 2141 2 2142 53 2143 54 2144 0 2145 2 2146 53 2147 49 2148 0 2149 1 2150 48 2151 0 2152 0 2153 1 2154 48 2155 0 2156 0 2157 1 2158 48 2159 0 2160 0 2161 1 2162 48 2163 0 2164 0 2165 1 2166 48 2167 0 2168 0 2169 1 2170 48 2171 0 2172 0 2173 1 2174 48 2175 0 2176 0 2177 1 2178 48 2179 0 2180 0 2181 1 2182 48 2183 0 2184 0 2185 1 2186 48 2187 0 2188 0
37/374

xic-ref (-target linux [basic test]): arrinit02.xi
2189 1 2190 48 2191 0 2192 0 2193 1 2194 48 2195 0 2196 0 2197 1 2198 48 2199 0 2200 0 2201 1 2202 48 2203 0 2204 0 2205 1 2206 48 2207 0 2208 0 2209 1 2210 48 2211 0 2212 0 2213 1 2214 48 2215 0 2216 0 2217 1 2218 48 2219 0 2220 0 2221 1 2222 48 2223 0 2224 0 2225 1 2226 48 2227 0 2228 0 2229 1 2230 48 2231 0 2232 0 2233 1 2234 48 2235 0 2236 0 2237 1 2238 48 2239 0 2240 0 2241 1 2242 48 2243 0 2244 0 2245 1 2246 48 2247 0 2248 0
38/374

xic-ref (-target linux [basic test]): arrinit02.xi
2249 1 2250 48 2251 0 2252 0 2253 1 2254 48 2255 0 2256 0 2257 1 2258 48 2259 0 2260 0 2261 1 2262 48 2263 0 2264 0 2265 1 2266 48 2267 0 2268 0 2269 1 2270 48 2271 0 2272 0 2273 1 2274 48 2275 0 2276 0 2277 1 2278 48 2279 0 2280 0 2281 1 2282 48 2283 0 2284 0 2285 1 2286 48 2287 0 2288 0 2289 1 2290 48 2291 0 2292 0 2293 1 2294 48 2295 0 2296 0 2297 1 2298 48 2299 0 2300 0 2301 1 2302 48 2303 0 2304 0 2305 1 2306 48 2307 0 2308 0
39/374

xic-ref (-target linux [basic test]): arrinit02.xi
2309 1 2310 48 2311 0 2312 0 2313 1 2314 48 2315 0 2316 0 2317 1 2318 48 2319 0 2320 0 2321 1 2322 48 2323 0 2324 0 2325 1 2326 48 2327 0 2328 0 2329 1 2330 48 2331 0 2332 0 2333 1 2334 48 2335 0 2336 0 2337 1 2338 48 2339 0 2340 0 2341 1 2342 48 2343 0 2344 0 2345 1 2346 48 2347 0 2348 0 2349 1 2350 48 2351 0 2352 0 2353 1 2354 48 2355 0 2356 0 2357 1 2358 48 2359 0 2360 0 2361 1 2362 48 2363 0 2364 0 2365 1 2366 48 2367 0 2368 0
40/374

xic-ref (-target linux [basic test]): arrinit02.xi
2369 1 2370 48 2371 0 2372 0 2373 1 2374 48 2375 0 2376 0 2377 1 2378 48 2379 0 2380 0 2381 1 2382 48 2383 0 2384 0 2385 1 2386 48 2387 0 2388 0 2389 1 2390 48 2391 0 2392 0 2393 1 2394 48 2395 0 2396 0 2397 1 2398 48 2399 0 2400 0 2401 1 2402 48 2403 0 2404 0 2405 1 2406 48 2407 0 2408 0 2409 1 2410 48 2411 0 2412 0 2413 1 2414 48 2415 0 2416 0 2417 1 2418 48 2419 0 2420 0 2421 1 2422 48 2423 0 2424 0 2425 1 2426 48 2427 0 2428 0
41/374

xic-ref (-target linux [basic test]): arrinit02.xi
2429 1 2430 48 2431 0 2432 0 2433 1 2434 48 2435 0 2436 0 2437 1 2438 48 2439 0 2440 0 2441 1 2442 48 2443 0 2444 0 2445 1 2446 48 2447 0 2448 0 2449 1 2450 48 2451 0 2452 0 2453 1 2454 48 2455 0 2456 0 2457 1 2458 48 2459 0 2460 0 2461 1 2462 48 2463 0 2464 0 2465 1 2466 48 2467 0 2468 0 2469 1 2470 48 2471 0 2472 0 2473 1 2474 48 2475 0 2476 0 2477 1 2478 48 2479 0 2480 0 2481 1 2482 48 2483 0 2484 0 2485 1 2486 48 2487 0 2488 0
42/374

xic-ref (-target linux [basic test]): arrinit02.xi
2489 1 2490 48 2491 0 2492 0 2493 1 2494 48 2495 0 2496 0 2497 1 2498 48 2499 0 2500 0 2501 1 2502 48 2503 0 2504 0 2505 1 2506 48 2507 0 2508 0 2509 1 2510 48 2511 0 2512 0 2513 1 2514 48 2515 0 2516 0 2517 1 2518 48 2519 0 2520 0 2521 1 2522 48 2523 0 2524 0 2525 1 2526 48 2527 0 2528 0 2529 1 2530 48 2531 0 2532 0 2533 1 2534 48 2535 0 2536 0 2537 1 2538 48 2539 0 2540 0 2541 1 2542 48 2543 0 2544 0 2545 1 2546 48 2547 0 2548 0
43/374

xic-ref (-target linux [basic test]): arrinit02.xi
2549 1 2550 48 2551 0 2552 0 2553 1 2554 48 2555 0 2556 0 2557 1 2558 48 2559 0 2560 0 2561 1 2562 48 2563 0 2564 0 2565 1 2566 48 2567 0 2568 0 2569 1 2570 48 2571 0 2572 0 2573 1 2574 56 2575 0 2576 0 2577 1 2578 48 2579 0 2580 0 2581 2 2582 53 2583 52 2584 0 2585 2 2586 53 2587 55 2588 0 2589 2 2590 52 2591 56 2592 0 2593 2 2594 53 2595 52 2596 0 2597 2 2598 53 2599 49 2600 0 2601 2 2602 53 2603 49 2604 0 2605 2 2606 53 2607 54 2608 0
44/374

xic-ref (-target linux [basic test]): arrinit02.xi
2609 2 2610 53 2611 49 2612 0 2613 1 2614 56 2615 0 2616 0 2617 1 2618 48 2619 0 2620 0 2621 2 2622 53 2623 54 2624 0 2625 2 2626 53 2627 48 2628 0 2629 2 2630 52 2631 57 2632 0 2633 2 2634 53 2635 52 2636 0 2637 2 2638 53 2639 49 2640 0 2641 2 2642 53 2643 49 2644 0 2645 2 2646 53 2647 54 2648 0 2649 2 2650 53 2651 49 2652 0 2653 1 2654 56 2655 0 2656 0 2657 1 2658 48 2659 0 2660 0 2661 2 2662 52 2663 56 2664 0 2665 2 2666 53 2667 52 2668 0
45/374

xic-ref (-target linux [basic test]): arrinit02.xi
2669 2 2670 53 2671 51 2672 0 2673 2 2674 53 2675 54 2676 0 2677 2 2678 53 2679 49 2680 0 2681 2 2682 53 2683 49 2684 0 2685 2 2686 53 2687 54 2688 0 2689 2 2690 53 2691 49 2692 0 2693 1 2694 56 2695 0 2696 0 2697 1 2698 48 2699 0 2700 0 2701 2 2702 52 2703 56 2704 0 2705 2 2706 53 2707 50 2708 0 2709 2 2710 53 2711 52 2712 0 2713 2 2714 53 2715 54 2716 0 2717 2 2718 53 2719 49 2720 0 2721 2 2722 53 2723 49 2724 0 2725 2 2726 53 2727 54 2728 0
46/374

xic-ref (-target linux [basic test]): arrinit02.xi
2729 2 2730 53 2731 49 2732 0 2733 1 2734 56 2735 0 2736 0 2737 1 2738 48 2739 0 2740 0 2741 2 2742 52 2743 56 2744 0 2745 2 2746 53 2747 48 2748 0 2749 2 2750 53 2751 53 2752 0 2753 2 2754 53 2755 54 2756 0 2757 2 2758 53 2759 49 2760 0 2761 2 2762 53 2763 49 2764 0 2765 2 2766 53 2767 54 2768 0 2769 2 2770 53 2771 49 2772 0 2773 1 2774 56 2775 0 2776 0 2777 1 2778 48 2779 0 2780 0 2781 2 2782 52 2783 56 2784 0 2785 2 2786 52 2787 56 2788 0
47/374

xic-ref (-target linux [basic test]): arrinit02.xi
2789 2 2790 53 2791 54 2792 0 2793 2 2794 53 2795 54 2796 0 2797 2 2798 53 2799 49 2800 0 2801 2 2802 53 2803 49 2804 0 2805 2 2806 53 2807 54 2808 0 2809 2 2810 53 2811 49 2812 0 2813 1 2814 56 2815 0 2816 0 2817 1 2818 48 2819 0 2820 0 2821 2 2822 52 2823 56 2824 0 2825 2 2826 53 2827 54 2828 0 2829 2 2830 53 2831 54 2832 0 2833 2 2834 53 2835 54 2836 0 2837 2 2838 53 2839 49 2840 0 2841 2 2842 53 2843 49 2844 0 2845 2 2846 53 2847 54 2848 0
48/374

xic-ref (-target linux [basic test]): arrinit02.xi
2849 2 2850 53 2851 49 2852 0 2853 1 2854 56 2855 0 2856 0 2857 1 2858 48 2859 0 2860 0 2861 2 2862 52 2863 56 2864 0 2865 2 2866 53 2867 52 2868 0 2869 2 2870 53 2871 55 2872 0 2873 2 2874 53 2875 54 2876 0 2877 2 2878 53 2879 49 2880 0 2881 2 2882 53 2883 49 2884 0 2885 2 2886 53 2887 54 2888 0 2889 2 2890 53 2891 49 2892 0 2893 1 2894 56 2895 0 2896 0 2897 1 2898 48 2899 0 2900 0 2901 2 2902 52 2903 56 2904 0 2905 2 2906 53 2907 50 2908 0
49/374

xic-ref (-target linux [basic test]): arrinit02.xi
2909 2 2910 52 2911 56 2912 0 2913 2 2914 53 2915 55 2916 0 2917 2 2918 53 2919 49 2920 0 2921 2 2922 53 2923 49 2924 0 2925 2 2926 53 2927 54 2928 0 2929 2 2930 53 2931 49 2932 0 2933 1 2934 56 2935 0 2936 0 2937 1 2938 48 2939 0 2940 0 2941 2 2942 52 2943 56 2944 0 2945 2 2946 53 2947 48 2948 0 2949 2 2950 52 2951 57 2952 0 2953 2 2954 53 2955 55 2956 0 2957 2 2958 53 2959 49 2960 0 2961 2 2962 53 2963 49 2964 0 2965 2 2966 53 2967 54 2968 0
50/374

xic-ref (-target linux [basic test]): arrinit02.xi
2969 2 2970 53 2971 49 2972 0 2973 1 2974 56 2975 0 2976 0 2977 1 2978 48 2979 0 2980 0 2981 2 2982 52 2983 56 2984 0 2985 2 2986 52 2987 56 2988 0 2989 2 2990 53 2991 48 2992 0 2993 2 2994 53 2995 55 2996 0 2997 2 2998 53 2999 49 3000 0 3001 2 3002 53 3003 49 3004 0 3005 2 3006 53 3007 54 3008 0 3009 2 3010 53 3011 49 3012 0 3013 1 3014 56 3015 0 3016 0 3017 1 3018 48 3019 0 3020 0 3021 2 3022 52 3023 56 3024 0 3025 2 3026 53 3027 54 3028 0
51/374

xic-ref (-target linux [basic test]): arrinit02.xi
3029 2 3030 53 3031 48 3032 0 3033 2 3034 53 3035 55 3036 0 3037 2 3038 53 3039 49 3040 0 3041 2 3042 53 3043 49 3044 0 3045 2 3046 53 3047 54 3048 0 3049 2 3050 53 3051 49 3052 0 3053 1 3054 56 3055 0 3056 0 3057 1 3058 48 3059 0 3060 0 3061 2 3062 52 3063 56 3064 0 3065 2 3066 53 3067 52 3068 0 3069 2 3070 53 3071 49 3072 0 3073 2 3074 53 3075 55 3076 0 3077 2 3078 53 3079 49 3080 0 3081 2 3082 53 3083 49 3084 0 3085 2 3086 52 3087 56 3088 0
52/374

xic-ref (-target linux [basic test]): arrinit02.xi
3089 2 3090 53 3091 54 3092 0 3093 2 3094 53 3095 52 3096 0 3097 2 3098 53 3099 51 3100 0 3101 2 3102 53 3103 49 3104 0 3105 2 3106 53 3107 49 3108 0 3109 2 3110 53 3111 54 3112 0 3113 2 3114 53 3115 49 3116 0 3117 1 3118 56 3119 0 3120 0 3121 1 3122 48 3123 0 3124 0 3125 2 3126 53 3127 48 3128 0 3129 2 3130 52 3131 57 3132 0 3133 2 3134 53 3135 53 3136 0 3137 2 3138 53 3139 51 3140 0 3141 2 3142 53 3143 49 3144 0 3145 2 3146 53 3147 49 3148 0
53/374

xic-ref (-target linux [basic test]): arrinit02.xi
3149 2 3150 53 3151 54 3152 0 3153 2 3154 53 3155 49 3156 0 3157 1 3158 56 3159 0 3160 0 3161 1 3162 48 3163 0 3164 0 3165 2 3166 53 3167 50 3168 0 3169 2 3170 53 3171 50 3172 0 3173 2 3174 53 3175 53 3176 0 3177 2 3178 53 3179 51 3180 0 3181 2 3182 53 3183 49 3184 0 3185 2 3186 53 3187 49 3188 0 3189 2 3190 53 3191 54 3192 0 3193 2 3194 53 3195 49 3196 0 3197 1 3198 56 3199 0 3200 0 3201 1 3202 48 3203 0 3204 0 3205 2 3206 53 3207 52 3208 0
54/374

xic-ref (-target linux [basic test]): arrinit02.xi
3209 2 3210 53 3211 53 3212 0 3213 2 3214 53 3215 53 3216 0 3217 2 3218 53 3219 51 3220 0 3221 2 3222 53 3223 49 3224 0 3225 2 3226 53 3227 49 3228 0 3229 2 3230 53 3231 54 3232 0 3233 2 3234 53 3235 49 3236 0 3237 1 3238 56 3239 0 3240 0 3241 1 3242 48 3243 0 3244 0 3245 2 3246 53 3247 54 3248 0 3249 2 3250 52 3251 56 3252 0 3253 2 3254 53 3255 54 3256 0 3257 2 3258 53 3259 51 3260 0 3261 2 3262 53 3263 49 3264 0 3265 2 3266 53 3267 49 3268 0
55/374

xic-ref (-target linux [basic test]): arrinit02.xi
3269 2 3270 53 3271 54 3272 0 3273 2 3274 53 3275 49 3276 0 3277 1 3278 56 3279 0 3280 0 3281 1 3282 48 3283 0 3284 0 3285 2 3286 52 3287 56 3288 0 3289 2 3290 53 3291 50 3292 0 3293 2 3294 53 3295 54 3296 0 3297 2 3298 53 3299 51 3300 0 3301 2 3302 53 3303 49 3304 0 3305 2 3306 53 3307 49 3308 0 3309 2 3310 53 3311 54 3312 0 3313 2 3314 53 3315 49 3316 0 3317 1 3318 56 3319 0 3320 0 3321 1 3322 48 3323 0 3324 0 3325 2 3326 53 3327 48 3328 0
56/374

xic-ref (-target linux [basic test]): arrinit02.xi
3329 2 3330 53 3331 53 3332 0 3333 2 3334 53 3335 54 3336 0 3337 2 3338 53 3339 51 3340 0 3341 2 3342 53 3343 49 3344 0 3345 2 3346 53 3347 49 3348 0 3349 2 3350 53 3351 54 3352 0 3353 2 3354 53 3355 49 3356 0 3357 1 3358 56 3359 0 3360 0 3361 1 3362 48 3363 0 3364 0 3365 2 3366 53 3367 50 3368 0 3369 2 3370 52 3371 56 3372 0 3373 2 3374 53 3375 55 3376 0 3377 2 3378 53 3379 51 3380 0 3381 2 3382 53 3383 49 3384 0 3385 2 3386 53 3387 49 3388 0
57/374

xic-ref (-target linux [basic test]): arrinit02.xi
3389 2 3390 53 3391 54 3392 0 3393 2 3394 53 3395 49 3396 0 3397 1 3398 56 3399 0 3400 0 3401 1 3402 48 3403 0 3404 0 3405 2 3406 53 3407 52 3408 0 3409 2 3410 53 3411 49 3412 0 3413 2 3414 53 3415 55 3416 0 3417 2 3418 53 3419 51 3420 0 3421 2 3422 53 3423 49 3424 0 3425 2 3426 53 3427 49 3428 0 3429 2 3430 53 3431 54 3432 0 3433 2 3434 53 3435 49 3436 0 3437 1 3438 56 3439 0 3440 0 3441 1 3442 48 3443 0 3444 0 3445 2 3446 53 3447 54 3448 0
58/374

xic-ref (-target linux [basic test]): arrinit02.xi
3449 2 3450 53 3451 52 3452 0 3453 2 3454 53 3455 55 3456 0 3457 2 3458 53 3459 51 3460 0 3461 2 3462 53 3463 49 3464 0 3465 2 3466 53 3467 49 3468 0 3469 2 3470 53 3471 54 3472 0 3473 2 3474 53 3475 49 3476 0 3477 1 3478 56 3479 0 3480 0 3481 1 3482 48 3483 0 3484 0 3485 2 3486 52 3487 56 3488 0 3489 2 3490 52 3491 56 3492 0 3493 2 3494 52 3495 56 3496 0 3497 2 3498 53 3499 52 3500 0 3501 2 3502 53 3503 49 3504 0 3505 2 3506 53 3507 49 3508 0
59/374

xic-ref (-target linux [basic test]): arrinit02.xi
3509 2 3510 53 3511 54 3512 0 3513 2 3514 53 3515 49 3516 0 3517 1 3518 56 3519 0 3520 0 3521 1 3522 48 3523 0 3524 0 3525 2 3526 53 3527 48 3528 0 3529 2 3530 53 3531 49 3532 0 3533 2 3534 52 3535 56 3536 0 3537 2 3538 53 3539 52 3540 0 3541 2 3542 53 3543 49 3544 0 3545 2 3546 53 3547 49 3548 0 3549 2 3550 53 3551 54 3552 0 3553 2 3554 53 3555 49 3556 0 3557 1 3558 56 3559 0 3560 0 3561 1 3562 48 3563 0 3564 0 3565 2 3566 53 3567 50 3568 0
60/374

xic-ref (-target linux [basic test]): arrinit02.xi
3569 2 3570 53 3571 52 3572 0 3573 2 3574 52 3575 56 3576 0 3577 2 3578 53 3579 52 3580 0 3581 2 3582 53 3583 49 3584 0 3585 2 3586 53 3587 49 3588 0 3589 2 3590 53 3591 54 3592 0 3593 2 3594 53 3595 49 3596 0 3597 1 3598 50 3599 0 3600 0 3601 1 3602 48 3603 0 3604 0 3605 1 3606 48 3607 0 3608 0 3609 2 3610 52 3611 56 3612 0 3613 1 3614 49 3615 0 3616 0 3617 1 3618 48 3619 0 3620 0 3621 1 3622 48 3623 0 3624 0 3625 2 3626 52 3627 56 3628 0
61/374

xic-ref (-target linux [basic test]): arrinit02.xi
3629 1 3630 49 3631 0 3632 0 3633 1 3634 48 3635 0 3636 0 3637 1 3638 48 3639 0 3640 0 3641 2 3642 52 3643 57 3644 0 3645 1 3646 49 3647 0 3648 0 3649 1 3650 48 3651 0 3652 0 3653 2 3654 53 3655 54 3656 0 3657 2 3658 53 3659 50 3660 0 3661 1 3662 50 3663 0 3664 0 3665 1 3666 48 3667 0 3668 0 3669 1 3670 48 3671 0 3672 0 3673 2 3674 52 3675 56 3676 0 3677 1 3678 49 3679 0 3680 0 3681 1 3682 48 3683 0 3684 0 3685 1 3686 48 3687 0 3688 0
62/374

xic-ref (-target linux [basic test]): arrinit02.xi
3689 2 3690 52 3691 56 3692 0 3693 1 3694 49 3695 0 3696 0 3697 1 3698 48 3699 0 3700 0 3701 1 3702 48 3703 0 3704 0 3705 1 3706 48 3707 0 3708 0 3709 2 3710 52 3711 56 3712 0 3713 2 3714 53 3715 52 3716 0 3717 2 3718 53 3719 49 3720 0 3721 2 3722 53 3723 51 3724 0 3725 2 3726 53 3727 49 3728 0 3729 2 3730 53 3731 49 3732 0 3733 2 3734 53 3735 54 3736 0 3737 2 3738 53 3739 49 3740 0 3741 1 3742 56 3743 0 3744 0 3745 1 3746 48 3747 0 3748 0
63/374

xic-ref (-target linux [basic test]): arrinit02.xi
3749 2 3750 53 3751 48 3752 0 3753 2 3754 53 3755 55 3756 0 3757 2 3758 53 3759 49 3760 0 3761 2 3762 53 3763 51 3764 0 3765 2 3766 53 3767 49 3768 0 3769 2 3770 53 3771 49 3772 0 3773 2 3774 53 3775 54 3776 0 3777 2 3778 53 3779 49 3780 0 3781 1 3782 56 3783 0 3784 0 3785 1 3786 48 3787 0 3788 0 3789 2 3790 53 3791 50 3792 0 3793 2 3794 53 3795 48 3796 0 3797 2 3798 53 3799 50 3800 0 3801 2 3802 53 3803 51 3804 0 3805 2 3806 53 3807 49 3808 0
64/374

xic-ref (-target linux [basic test]): arrinit02.xi
3809 2 3810 53 3811 49 3812 0 3813 2 3814 53 3815 54 3816 0 3817 2 3818 53 3819 49 3820 0 3821 1 3822 56 3823 0 3824 0 3825 1 3826 48 3827 0 3828 0 3829 2 3830 53 3831 52 3832 0 3833 2 3834 53 3835 51 3836 0 3837 2 3838 53 3839 50 3840 0 3841 2 3842 53 3843 51 3844 0 3845 2 3846 53 3847 49 3848 0 3849 2 3850 53 3851 49 3852 0 3853 2 3854 53 3855 54 3856 0 3857 2 3858 53 3859 49 3860 0 3861 1 3862 56 3863 0 3864 0 3865 1 3866 48 3867 0 3868 0
65/374

xic-ref (-target linux [basic test]): arrinit02.xi
3869 2 3870 53 3871 54 3872 0 3873 2 3874 53 3875 54 3876 0 3877 2 3878 53 3879 50 3880 0 3881 2 3882 53 3883 51 3884 0 3885 2 3886 53 3887 49 3888 0 3889 2 3890 53 3891 49 3892 0 3893 2 3894 53 3895 54 3896 0 3897 2 3898 53 3899 49 3900 0 3901 1 3902 56 3903 0 3904 0 3905 1 3906 48 3907 0 3908 0 3909 2 3910 52 3911 56 3912 0 3913 2 3914 53 3915 48 3916 0 3917 2 3918 53 3919 51 3920 0 3921 2 3922 53 3923 51 3924 0 3925 2 3926 53 3927 49 3928 0
66/374

xic-ref (-target linux [basic test]): arrinit02.xi
3929 2 3930 53 3931 49 3932 0 3933 2 3934 53 3935 54 3936 0 3937 2 3938 53 3939 49 3940 0 3941 1 3942 56 3943 0 3944 0 3945 1 3946 48 3947 0 3948 0 3949 2 3950 53 3951 48 3952 0 3953 2 3954 53 3955 51 3956 0 3957 2 3958 53 3959 51 3960 0 3961 2 3962 53 3963 51 3964 0 3965 2 3966 53 3967 49 3968 0 3969 2 3970 53 3971 49 3972 0 3973 2 3974 53 3975 54 3976 0 3977 2 3978 53 3979 49 3980 0 3981 1 3982 56 3983 0 3984 0 3985 1 3986 48 3987 0 3988 0
67/374

xic-ref (-target linux [basic test]): arrinit02.xi
3989 2 3990 53 3991 50 3992 0 3993 2 3994 53 3995 54 3996 0 3997 2 3998 53 3999 51 4000 0 4001 2 4002 53 4003 51 4004 0 4005 2 4006 53 4007 49 4008 0 4009 2 4010 53 4011 49 4012 0 4013 2 4014 53 4015 54 4016 0 4017 2 4018 53 4019 49 4020 0 4021 1 4022 56 4023 0 4024 0 4025 1 4026 48 4027 0 4028 0 4029 2 4030 53 4031 52 4032 0 4033 2 4034 52 4035 57 4036 0 4037 2 4038 53 4039 52 4040 0 4041 2 4042 53 4043 51 4044 0 4045 2 4046 53 4047 49 4048 0
68/374

xic-ref (-target linux [basic test]): arrinit02.xi
4049 2 4050 53 4051 49 4052 0 4053 2 4054 53 4055 54 4056 0 4057 2 4058 53 4059 49 4060 0 4061 1 4062 56 4063 0 4064 0 4065 1 4066 48 4067 0 4068 0 4069 2 4070 53 4071 54 4072 0 4073 2 4074 53 4075 50 4076 0 4077 2 4078 53 4079 52 4080 0 4081 2 4082 53 4083 51 4084 0 4085 2 4086 53 4087 49 4088 0 4089 2 4090 53 4091 49 4092 0 4093 2 4094 53 4095 54 4096 0 4097 2 4098 53 4099 49 4100 0 4101 1 4102 56 4103 0 4104 0 4105 1 4106 48 4107 0 4108 0
69/374

xic-ref (-target linux [basic test]): arrinit02.xi
4109 1 4110 50 4111 0 4112 0 4113 1 4114 48 4115 0 4116 0 4117 1 4118 48 4119 0 4120 0 4121 2 4122 52 4123 56 4124 0 4125 1 4126 49 4127 0 4128 0 4129 1 4130 48 4131 0 4132 0 4133 1 4134 48 4135 0 4136 0 4137 2 4138 52 4139 56 4140 0 4141 1 4142 49 4143 0 4144 0 4145 1 4146 48 4147 0 4148 0 4149 1 4150 48 4151 0 4152 0 4153 2 4154 52 4155 57 4156 0 4157 1 4158 49 4159 0 4160 0 4161 1 4162 48 4163 0 4164 0 4165 2 4166 53 4167 54 4168 0
70/374

xic-ref (-target linux [basic test]): arrinit02.xi
4169 2 4170 53 4171 50 4172 0 4173 1 4174 50 4175 0 4176 0 4177 1 4178 48 4179 0 4180 0 4181 1 4182 48 4183 0 4184 0 4185 2 4186 52 4187 56 4188 0 4189 1 4190 49 4191 0 4192 0 4193 1 4194 48 4195 0 4196 0 4197 1 4198 48 4199 0 4200 0 4201 2 4202 52 4203 56 4204 0 4205 1 4206 49 4207 0 4208 0 4209 1 4210 48 4211 0 4212 0 4213 1 4214 48 4215 0 4216 0 4217 2 4218 52 4219 57 4220 0 4221 1 4222 49 4223 0 4224 0 4225 1 4226 48 4227 0 4228 0
71/374

xic-ref (-target linux [basic test]): arrinit02.xi
4229 2 4230 53 4231 54 4232 0 4233 2 4234 53 4235 50 4236 0 4237 1 4238 50 4239 0 4240 0 4241 1 4242 48 4243 0 4244 0 4245 1 4246 48 4247 0 4248 0 4249 2 4250 52 4251 56 4252 0 4253 1 4254 49 4255 0 4256 0 4257 1 4258 48 4259 0 4260 0 4261 1 4262 48 4263 0 4264 0 4265 2 4266 52 4267 56 4268 0 4269 1 4270 49 4271 0 4272 0 4273 1 4274 48 4275 0 4276 0 4277 1 4278 48 4279 0 4280 0 4281 2 4282 52 4283 57 4284 0 4285 1 4286 49 4287 0 4288 0
72/374

xic-ref (-target linux [basic test]): arrinit02.xi
4289 1 4290 48 4291 0 4292 0 4293 2 4294 53 4295 54 4296 0 4297 2 4298 53 4299 50 4300 0 4301 1 4302 50 4303 0 4304 0 4305 1 4306 48 4307 0 4308 0 4309 1 4310 48 4311 0 4312 0 4313 2 4314 52 4315 56 4316 0 4317 1 4318 49 4319 0 4320 0 4321 1 4322 48 4323 0 4324 0 4325 1 4326 48 4327 0 4328 0 4329 2 4330 52 4331 56 4332 0 4333 1 4334 49 4335 0 4336 0 4337 1 4338 48 4339 0 4340 0 4341 1 4342 48 4343 0 4344 0 4345 2 4346 52 4347 57 4348 0
73/374

xic-ref (-target linux [basic test]): arrinit02.xi
4349 1 4350 49 4351 0 4352 0 4353 1 4354 48 4355 0 4356 0 4357 2 4358 53 4359 54 4360 0 4361 2 4362 53 4363 50 4364 0 4365 1 4366 50 4367 0 4368 0 4369 1 4370 48 4371 0 4372 0 4373 1 4374 48 4375 0 4376 0 4377 2 4378 52 4379 56 4380 0 4381 1 4382 49 4383 0 4384 0 4385 1 4386 48 4387 0 4388 0 4389 1 4390 48 4391 0 4392 0 4393 2 4394 52 4395 56 4396 0 4397 1 4398 49 4399 0 4400 0 4401 1 4402 48 4403 0 4404 0 4405 1 4406 48 4407 0 4408 0
74/374

xic-ref (-target linux [basic test]): arrinit02.xi
4409 2 4410 52 4411 57 4412 0 4413 1 4414 49 4415 0 4416 0 4417 1 4418 48 4419 0 4420 0 4421 2 4422 53 4423 54 4424 0 4425 2 4426 53 4427 50 4428 0 4429 1 4430 50 4431 0 4432 0 4433 1 4434 48 4435 0 4436 0 4437 1 4438 48 4439 0 4440 0 4441 2 4442 52 4443 56 4444 0 4445 1 4446 49 4447 0 4448 0 4449 1 4450 48 4451 0 4452 0 4453 1 4454 48 4455 0 4456 0 4457 2 4458 52 4459 56 4460 0 4461 1 4462 49 4463 0 4464 0 4465 1 4466 48 4467 0 4468 0
75/374

xic-ref (-target linux [basic test]): arrinit02.xi
4469 1 4470 48 4471 0 4472 0 4473 2 4474 52 4475 57 4476 0 4477 1 4478 49 4479 0 4480 0 4481 1 4482 48 4483 0 4484 0 4485 2 4486 53 4487 54 4488 0 4489 2 4490 53 4491 50 4492 0 4493 1 4494 50 4495 0 4496 0 4497 1 4498 48 4499 0 4500 0 4501 1 4502 48 4503 0 4504 0 4505 2 4506 52 4507 56 4508 0 4509 1 4510 49 4511 0 4512 0 4513 1 4514 48 4515 0 4516 0 4517 1 4518 48 4519 0 4520 0 4521 2 4522 52 4523 56 4524 0 4525 1 4526 49 4527 0 4528 0
76/374

xic-ref (-target linux [basic test]): arrinit02.xi
4529 1 4530 48 4531 0 4532 0 4533 1 4534 48 4535 0 4536 0 4537 2 4538 52 4539 57 4540 0 4541 1 4542 49 4543 0 4544 0 4545 1 4546 48 4547 0 4548 0 4549 2 4550 53 4551 54 4552 0 4553 2 4554 53 4555 50 4556 0 4557 1 4558 50 4559 0 4560 0 4561 1 4562 48 4563 0 4564 0 4565 1 4566 48 4567 0 4568 0 4569 2 4570 52 4571 56 4572 0 4573 1 4574 49 4575 0 4576 0 4577 1 4578 48 4579 0 4580 0 4581 1 4582 48 4583 0 4584 0 4585 2 4586 52 4587 56 4588 0
77/374

xic-ref (-target linux [basic test]): arrinit02.xi
4589 1 4590 49 4591 0 4592 0 4593 1 4594 48 4595 0 4596 0 4597 1 4598 48 4599 0 4600 0 4601 2 4602 52 4603 57 4604 0 4605 1 4606 49 4607 0 4608 0 4609 1 4610 48 4611 0 4612 0 4613 2 4614 53 4615 54 4616 0 4617 2 4618 53 4619 50 4620 0 4621 1 4622 50 4623 0 4624 0 4625 1 4626 48 4627 0 4628 0 4629 1 4630 48 4631 0 4632 0 4633 2 4634 52 4635 56 4636 0 4637 1 4638 49 4639 0 4640 0 4641 1 4642 48 4643 0 4644 0 4645 1 4646 48 4647 0 4648 0
78/374

xic-ref (-target linux [basic test]): arrinit02.xi
4649 2 4650 52 4651 56 4652 0 4653 1 4654 49 4655 0 4656 0 4657 1 4658 48 4659 0 4660 0 4661 1 4662 48 4663 0 4664 0 4665 2 4666 52 4667 57 4668 0 4669 1 4670 49 4671 0 4672 0 4673 1 4674 48 4675 0 4676 0 4677 2 4678 53 4679 54 4680 0 4681 2 4682 53 4683 50 4684 0 4685 1 4686 50 4687 0 4688 0 4689 1 4690 48 4691 0 4692 0 4693 1 4694 48 4695 0 4696 0 4697 2 4698 52 4699 56 4700 0 4701 1 4702 49 4703 0 4704 0 4705 1 4706 48 4707 0 4708 0
79/374

xic-ref (-target linux [basic test]): arrinit02.xi
4709 1 4710 48 4711 0 4712 0 4713 2 4714 52 4715 56 4716 0 4717 1 4718 49 4719 0 4720 0 4721 1 4722 48 4723 0 4724 0 4725 1 4726 48 4727 0 4728 0 4729 2 4730 52 4731 57 4732 0 4733 1 4734 49 4735 0 4736 0 4737 1 4738 48 4739 0 4740 0 4741 2 4742 53 4743 54 4744 0 4745 2 4746 53 4747 50 4748 0 4749 1 4750 50 4751 0 4752 0 4753 1 4754 48 4755 0 4756 0 4757 1 4758 48 4759 0 4760 0 4761 2 4762 52 4763 56 4764 0 4765 1 4766 49 4767 0 4768 0
80/374

xic-ref (-target linux [basic test]): arrinit02.xi
4769 1 4770 48 4771 0 4772 0 4773 1 4774 48 4775 0 4776 0 4777 2 4778 52 4779 56 4780 0 4781 1 4782 49 4783 0 4784 0 4785 1 4786 48 4787 0 4788 0 4789 1 4790 48 4791 0 4792 0 4793 2 4794 52 4795 57 4796 0 4797 1 4798 49 4799 0 4800 0 4801 1 4802 48 4803 0 4804 0 4805 2 4806 53 4807 54 4808 0 4809 2 4810 53 4811 50 4812 0 4813 1 4814 50 4815 0 4816 0 4817 1 4818 48 4819 0 4820 0 4821 1 4822 48 4823 0 4824 0 4825 2 4826 52 4827 56 4828 0
81/374

xic-ref (-target linux [basic test]): arrinit02.xi
4829 1 4830 49 4831 0 4832 0 4833 1 4834 48 4835 0 4836 0 4837 1 4838 48 4839 0 4840 0 4841 2 4842 52 4843 56 4844 0 4845 1 4846 49 4847 0 4848 0 4849 1 4850 48 4851 0 4852 0 4853 1 4854 48 4855 0 4856 0 4857 2 4858 52 4859 57 4860 0 4861 1 4862 49 4863 0 4864 0 4865 1 4866 48 4867 0 4868 0 4869 2 4870 53 4871 54 4872 0 4873 2 4874 53 4875 50 4876 0 4877 1 4878 50 4879 0 4880 0 4881 1 4882 48 4883 0 4884 0 4885 1 4886 48 4887 0 4888 0
82/374

xic-ref (-target linux [basic test]): arrinit02.xi
4889 2 4890 52 4891 56 4892 0 4893 1 4894 49 4895 0 4896 0 4897 1 4898 48 4899 0 4900 0 4901 1 4902 48 4903 0 4904 0 4905 2 4906 52 4907 56 4908 0 4909 1 4910 49 4911 0 4912 0 4913 1 4914 48 4915 0 4916 0 4917 1 4918 48 4919 0 4920 0 4921 2 4922 52 4923 57 4924 0 4925 1 4926 49 4927 0 4928 0 4929 1 4930 48 4931 0 4932 0 4933 2 4934 53 4935 54 4936 0 4937 2 4938 53 4939 50 4940 0 4941 1 4942 50 4943 0 4944 0 4945 1 4946 48 4947 0 4948 0
83/374

xic-ref (-target linux [basic test]): arrinit02.xi
4949 1 4950 48 4951 0 4952 0 4953 2 4954 52 4955 56 4956 0 4957 1 4958 49 4959 0 4960 0 4961 1 4962 48 4963 0 4964 0 4965 1 4966 48 4967 0 4968 0 4969 2 4970 52 4971 56 4972 0 4973 1 4974 49 4975 0 4976 0 4977 1 4978 48 4979 0 4980 0 4981 1 4982 48 4983 0 4984 0 4985 2 4986 52 4987 57 4988 0 4989 1 4990 49 4991 0 4992 0 4993 1 4994 48 4995 0 4996 0 4997 2 4998 53 4999 54 5000 0 5001 2 5002 53 5003 50 5004 0 5005 1 5006 50 5007 0 5008 0
84/374

xic-ref (-target linux [basic test]): arrinit02.xi
5009 1 5010 48 5011 0 5012 0 5013 1 5014 48 5015 0 5016 0 5017 2 5018 52 5019 56 5020 0 5021 1 5022 49 5023 0 5024 0 5025 1 5026 48 5027 0 5028 0 5029 1 5030 48 5031 0 5032 0 5033 2 5034 52 5035 56 5036 0 5037 1 5038 49 5039 0 5040 0 5041 1 5042 48 5043 0 5044 0 5045 1 5046 48 5047 0 5048 0 5049 2 5050 52 5051 57 5052 0 5053 1 5054 49 5055 0 5056 0 5057 1 5058 48 5059 0 5060 0 5061 2 5062 53 5063 54 5064 0 5065 2 5066 53 5067 50 5068 0
85/374

xic-ref (-target linux [basic test]): arrinit02.xi
5069 1 5070 50 5071 0 5072 0 5073 1 5074 48 5075 0 5076 0 5077 1 5078 48 5079 0 5080 0 5081 2 5082 52 5083 56 5084 0 5085 1 5086 49 5087 0 5088 0 5089 1 5090 48 5091 0 5092 0 5093 1 5094 48 5095 0 5096 0 5097 2 5098 52 5099 56 5100 0 5101 1 5102 49 5103 0 5104 0 5105 1 5106 48 5107 0 5108 0 5109 1 5110 48 5111 0 5112 0 5113 2 5114 52 5115 57 5116 0 5117 1 5118 49 5119 0 5120 0 5121 1 5122 48 5123 0 5124 0 5125 2 5126 53 5127 54 5128 0
86/374

xic-ref (-target linux [basic test]): arrinit02.xi
5129 2 5130 53 5131 50 5132 0 5133 1 5134 50 5135 0 5136 0 5137 1 5138 48 5139 0 5140 0 5141 1 5142 48 5143 0 5144 0 5145 2 5146 52 5147 56 5148 0 5149 1 5150 49 5151 0 5152 0 5153 1 5154 48 5155 0 5156 0 5157 1 5158 48 5159 0 5160 0 5161 2 5162 52 5163 56 5164 0 5165 1 5166 49 5167 0 5168 0 5169 1 5170 48 5171 0 5172 0 5173 1 5174 48 5175 0 5176 0 5177 2 5178 52 5179 57 5180 0 5181 1 5182 49 5183 0 5184 0 5185 1 5186 48 5187 0 5188 0
87/374

xic-ref (-target linux [basic test]): arrinit02.xi
5189 2 5190 53 5191 54 5192 0 5193 2 5194 53 5195 50 5196 0 5197 1 5198 50 5199 0 5200 0 5201 1 5202 48 5203 0 5204 0 5205 1 5206 48 5207 0 5208 0 5209 2 5210 52 5211 56 5212 0 5213 1 5214 49 5215 0 5216 0 5217 1 5218 48 5219 0 5220 0 5221 1 5222 48 5223 0 5224 0 5225 2 5226 52 5227 56 5228 0 5229 1 5230 49 5231 0 5232 0 5233 1 5234 48 5235 0 5236 0 5237 1 5238 48 5239 0 5240 0 5241 2 5242 52 5243 57 5244 0 5245 1 5246 49 5247 0 5248 0
88/374

xic-ref (-target linux [basic test]): arrinit02.xi
5249 1 5250 48 5251 0 5252 0 5253 2 5254 53 5255 54 5256 0 5257 2 5258 53 5259 50 5260 0 5261 1 5262 50 5263 0 5264 0 5265 1 5266 48 5267 0 5268 0 5269 1 5270 48 5271 0 5272 0 5273 2 5274 52 5275 56 5276 0 5277 1 5278 49 5279 0 5280 0 5281 1 5282 48 5283 0 5284 0 5285 1 5286 48 5287 0 5288 0 5289 2 5290 52 5291 56 5292 0 5293 1 5294 49 5295 0 5296 0 5297 1 5298 48 5299 0 5300 0 5301 1 5302 48 5303 0 5304 0 5305 2 5306 52 5307 57 5308 0
89/374

xic-ref (-target linux [basic test]): arrinit02.xi
5309 1 5310 49 5311 0 5312 0 5313 1 5314 48 5315 0 5316 0 5317 2 5318 53 5319 54 5320 0 5321 2 5322 53 5323 50 5324 0 5325 1 5326 50 5327 0 5328 0 5329 1 5330 48 5331 0 5332 0 5333 1 5334 48 5335 0 5336 0 5337 2 5338 52 5339 56 5340 0 5341 1 5342 49 5343 0 5344 0 5345 1 5346 48 5347 0 5348 0 5349 1 5350 48 5351 0 5352 0 5353 2 5354 52 5355 56 5356 0 5357 1 5358 49 5359 0 5360 0 5361 1 5362 48 5363 0 5364 0 5365 1 5366 48 5367 0 5368 0
90/374

xic-ref (-target linux [basic test]): arrinit02.xi
5369 2 5370 52 5371 57 5372 0 5373 1 5374 49 5375 0 5376 0 5377 1 5378 48 5379 0 5380 0 5381 2 5382 53 5383 54 5384 0 5385 2 5386 53 5387 50 5388 0 5389 1 5390 50 5391 0 5392 0 5393 1 5394 48 5395 0 5396 0 5397 1 5398 48 5399 0 5400 0 5401 2 5402 52 5403 56 5404 0 5405 1 5406 49 5407 0 5408 0 5409 1 5410 48 5411 0 5412 0 5413 1 5414 48 5415 0 5416 0 5417 2 5418 52 5419 56 5420 0 5421 1 5422 49 5423 0 5424 0 5425 1 5426 48 5427 0 5428 0
91/374

xic-ref (-target linux [basic test]): arrinit02.xi
5429 1 5430 48 5431 0 5432 0 5433 2 5434 52 5435 57 5436 0 5437 1 5438 49 5439 0 5440 0 5441 1 5442 48 5443 0 5444 0 5445 2 5446 53 5447 54 5448 0 5449 2 5450 53 5451 50 5452 0 5453 1 5454 50 5455 0 5456 0 5457 1 5458 48 5459 0 5460 0 5461 1 5462 48 5463 0 5464 0 5465 2 5466 52 5467 56 5468 0 5469 1 5470 49 5471 0 5472 0 5473 1 5474 48 5475 0 5476 0 5477 1 5478 48 5479 0 5480 0 5481 2 5482 52 5483 56 5484 0 5485 1 5486 49 5487 0 5488 0
92/374

xic-ref (-target linux [basic test]): arrinit02.xi
5489 1 5490 48 5491 0 5492 0 5493 1 5494 48 5495 0 5496 0 5497 2 5498 52 5499 57 5500 0 5501 1 5502 49 5503 0 5504 0 5505 1 5506 48 5507 0 5508 0 5509 2 5510 53 5511 54 5512 0 5513 2 5514 53 5515 50 5516 0 5517 1 5518 50 5519 0 5520 0 5521 1 5522 48 5523 0 5524 0 5525 1 5526 48 5527 0 5528 0 5529 2 5530 52 5531 56 5532 0 5533 1 5534 49 5535 0 5536 0 5537 1 5538 48 5539 0 5540 0 5541 1 5542 48 5543 0 5544 0 5545 2 5546 52 5547 56 5548 0
93/374

xic-ref (-target linux [basic test]): arrinit02.xi
5549 1 5550 49 5551 0 5552 0 5553 1 5554 48 5555 0 5556 0 5557 1 5558 48 5559 0 5560 0 5561 2 5562 52 5563 57 5564 0 5565 1 5566 49 5567 0 5568 0 5569 1 5570 48 5571 0 5572 0 5573 2 5574 53 5575 54 5576 0 5577 2 5578 53 5579 50 5580 0 5581 1 5582 50 5583 0 5584 0 5585 1 5586 48 5587 0 5588 0 5589 1 5590 48 5591 0 5592 0 5593 2 5594 52 5595 56 5596 0 5597 1 5598 49 5599 0 5600 0 5601 1 5602 48 5603 0 5604 0 5605 1 5606 48 5607 0 5608 0
94/374

xic-ref (-target linux [basic test]): arrinit02.xi
5609 2 5610 52 5611 56 5612 0 5613 1 5614 49 5615 0 5616 0 5617 1 5618 48 5619 0 5620 0 5621 1 5622 48 5623 0 5624 0 5625 2 5626 52 5627 57 5628 0 5629 1 5630 49 5631 0 5632 0 5633 1 5634 48 5635 0 5636 0 5637 2 5638 53 5639 54 5640 0 5641 2 5642 53 5643 50 5644 0 5645 1 5646 49 5647 0 5648 0 5649 1 5650 48 5651 0 5652 0 5653 1 5654 48 5655 0 5656 0 5657 2 5658 52 5659 56 5660 0 5661 1 5662 49 5663 0 5664 0 5665 1 5666 48 5667 0 5668 0
95/374

xic-ref (-target linux [basic test]): arrinit02.xi
5669 1 5670 48 5671 0 5672 0 5673 2 5674 52 5675 56 5676 0 5677 1 5678 49 5679 0 5680 0 5681 1 5682 48 5683 0 5684 0 5685 1 5686 48 5687 0 5688 0 5689 2 5690 52 5691 56 5692 0 5693 1 5694 49 5695 0 5696 0 5697 1 5698 48 5699 0 5700 0 5701 1 5702 48 5703 0 5704 0 5705 2 5706 52 5707 56 5708 0 5709 1 5710 49 5711 0 5712 0 5713 1 5714 48 5715 0 5716 0 5717 1 5718 48 5719 0 5720 0 5721 2 5722 52 5723 56 5724 0 5725 1 5726 49 5727 0 5728 0
96/374

xic-ref (-target linux [basic test]): arrinit02.xi
5729 1 5730 48 5731 0 5732 0 5733 1 5734 48 5735 0 5736 0 5737 2 5738 52 5739 56 5740 0 5741 1 5742 49 5743 0 5744 0 5745 1 5746 48 5747 0 5748 0 5749 1 5750 48 5751 0 5752 0 5753 2 5754 52 5755 57 5756 0 5757 1 5758 49 5759 0 5760 0 5761 1 5762 48 5763 0 5764 0 5765 2 5766 53 5767 54 5768 0 5769 2 5770 53 5771 50 5772 0 5773 1 5774 50 5775 0 5776 0 5777 1 5778 48 5779 0 5780 0 5781 1 5782 48 5783 0 5784 0 5785 2 5786 52 5787 56 5788 0
97/374

xic-ref (-target linux [basic test]): arrinit02.xi
5789 1 5790 49 5791 0 5792 0 5793 1 5794 48 5795 0 5796 0 5797 1 5798 48 5799 0 5800 0 5801 2 5802 52 5803 56 5804 0 5805 1 5806 49 5807 0 5808 0 5809 1 5810 48 5811 0 5812 0 5813 1 5814 48 5815 0 5816 0 5817 2 5818 52 5819 57 5820 0 5821 1 5822 49 5823 0 5824 0 5825 1 5826 48 5827 0 5828 0 5829 2 5830 53 5831 54 5832 0 5833 2 5834 53 5835 50 5836 0 5837 1 5838 50 5839 0 5840 0 5841 1 5842 48 5843 0 5844 0 5845 1 5846 48 5847 0 5848 0
98/374

xic-ref (-target linux [basic test]): arrinit02.xi
5849 2 5850 52 5851 56 5852 0 5853 1 5854 49 5855 0 5856 0 5857 1 5858 48 5859 0 5860 0 5861 1 5862 48 5863 0 5864 0 5865 2 5866 52 5867 56 5868 0 5869 1 5870 49 5871 0 5872 0 5873 1 5874 48 5875 0 5876 0 5877 1 5878 48 5879 0 5880 0 5881 2 5882 52 5883 57 5884 0 5885 1 5886 49 5887 0 5888 0 5889 1 5890 48 5891 0 5892 0 5893 2 5894 53 5895 54 5896 0 5897 2 5898 53 5899 50 5900 0 5901 1 5902 50 5903 0 5904 0 5905 1 5906 48 5907 0 5908 0
99/374

xic-ref (-target linux [basic test]): arrinit02.xi
5909 1 5910 48 5911 0 5912 0 5913 2 5914 52 5915 56 5916 0 5917 1 5918 49 5919 0 5920 0 5921 1 5922 48 5923 0 5924 0 5925 1 5926 48 5927 0 5928 0 5929 2 5930 52 5931 56 5932 0 5933 1 5934 49 5935 0 5936 0 5937 1 5938 48 5939 0 5940 0 5941 1 5942 48 5943 0 5944 0 5945 2 5946 52 5947 57 5948 0 5949 1 5950 49 5951 0 5952 0 5953 1 5954 48 5955 0 5956 0 5957 2 5958 53 5959 54 5960 0 5961 2 5962 53 5963 50 5964 0 5965 1 5966 50 5967 0 5968 0
100/374

xic-ref (-target linux [basic test]): arrinit02.xi
5969 1 5970 48 5971 0 5972 0 5973 1 5974 48 5975 0 5976 0 5977 2 5978 52 5979 56 5980 0 5981 1 5982 49 5983 0 5984 0 5985 1 5986 48 5987 0 5988 0 5989 1 5990 48 5991 0 5992 0 5993 2 5994 52 5995 56 5996 0 5997 1 5998 49 5999 0 6000 0 6001 1 6002 48 6003 0 6004 0 6005 1 6006 48 6007 0 6008 0 6009 2 6010 52 6011 57 6012 0 6013 1 6014 49 6015 0 6016 0 6017 1 6018 48 6019 0 6020 0 6021 2 6022 53 6023 54 6024 0 6025 2 6026 53 6027 50 6028 0
101/374

xic-ref (-target linux [basic test]): arrinit02.xi
6029 1 6030 50 6031 0 6032 0 6033 1 6034 48 6035 0 6036 0 6037 1 6038 48 6039 0 6040 0 6041 2 6042 52 6043 56 6044 0 6045 1 6046 49 6047 0 6048 0 6049 1 6050 48 6051 0 6052 0 6053 1 6054 48 6055 0 6056 0 6057 2 6058 52 6059 56 6060 0 6061 1 6062 49 6063 0 6064 0 6065 1 6066 48 6067 0 6068 0 6069 1 6070 48 6071 0 6072 0 6073 2 6074 52 6075 57 6076 0 6077 1 6078 49 6079 0 6080 0 6081 1 6082 48 6083 0 6084 0 6085 2 6086 53 6087 54 6088 0
102/374

xic-ref (-target linux [basic test]): arrinit02.xi
6089 2 6090 53 6091 50 6092 0 6093 1 6094 50 6095 0 6096 0 6097 1 6098 48 6099 0 6100 0 6101 1 6102 48 6103 0 6104 0 6105 2 6106 52 6107 56 6108 0 6109 1 6110 49 6111 0 6112 0 6113 1 6114 48 6115 0 6116 0 6117 1 6118 48 6119 0 6120 0 6121 2 6122 52 6123 56 6124 0 6125 1 6126 49 6127 0 6128 0 6129 1 6130 48 6131 0 6132 0 6133 1 6134 48 6135 0 6136 0 6137 2 6138 52 6139 57 6140 0 6141 1 6142 49 6143 0 6144 0 6145 1 6146 48 6147 0 6148 0
103/374

xic-ref (-target linux [basic test]): arrinit02.xi
6149 2 6150 53 6151 54 6152 0 6153 2 6154 53 6155 50 6156 0 6157 0 6158 0 6159 0 6160 0 6161 0 6162 0 6163 0 6164 0 6165 0 6166 0 6167 0 6168 0 6169 0 6170 0 6171 0 6172 0 6173 0 6174 0 6175 0 6176 0 6177 0 6178 0 6179 0 6180 0 6181 0 6182 0 6183 0 6184 0 6185 0 6186 0 6187 0 6188 0 6189 0 6190 0 6191 0 6192 0 6193 0 6194 0 6195 0 6196 0 6197 0 6198 0 6199 0 6200 0 6201 0 6202 0 6203 0 6204 0 6205 0 6206 0 6207 0 6208 0
104/374

xic-ref (-target linux [basic test]): arrinit02.xi
6209 0 6210 0 6211 0 6212 0 6213 0 6214 0 6215 0 6216 0 6217 0 6218 0 6219 0 6220 0 6221 0 6222 0 6223 0 6224 0 6225 0 6226 0 6227 0 6228 0 6229 0 6230 0 6231 0 6232 0 6233 0 6234 0 6235 0 6236 0 6237 0 6238 0 6239 0 6240 0 6241 0 6242 0 6243 0 6244 0 6245 0 6246 0 6247 0 6248 0 6249 0 6250 0 6251 0 6252 0 6253 0 6254 0 6255 0 6256 0 6257 0 6258 0 6259 0 6260 0 6261 0 6262 0 6263 0 6264 0 6265 0 6266 0 6267 0 6268 0
105/374

xic-ref (-target linux [basic test]): arrinit02.xi
6269 0 6270 0 6271 0 6272 0 6273 0 6274 0 6275 0 6276 0 6277 0 6278 0 6279 0 6280 0 6281 0 6282 0 6283 0 6284 0 6285 0 6286 0 6287 0 6288 0 6289 0 6290 0 6291 0 6292 0 6293 0 6294 0 6295 0 6296 0 6297 0 6298 0 6299 0 6300 0 6301 0 6302 0 6303 0 6304 0 6305 0 6306 0 6307 0 6308 0 6309 0 6310 0 6311 0 6312 0 6313 0 6314 0 6315 0 6316 0 6317 0 6318 0 6319 0 6320 0 6321 0 6322 0 6323 0 6324 0 6325 0 6326 0 6327 0 6328 0
106/374

xic-ref (-target linux [basic test]): arrinit02.xi
6329 0 6330 0 6331 0 6332 0 6333 0 6334 0 6335 0 6336 0 6337 0 6338 0 6339 0 6340 0 6341 0 6342 0 6343 0 6344 0 6345 0 6346 0 6347 0 6348 0 6349 0 6350 0 6351 0 6352 0 6353 0 6354 0 6355 0 6356 0 6357 0 6358 0 6359 0 6360 0 6361 0 6362 0 6363 0 6364 0 6365 0 6366 0 6367 0 6368 0 6369 0 6370 0 6371 0 6372 0 6373 0 6374 0 6375 0 6376 0 6377 0 6378 0 6379 0 6380 0 6381 0 6382 0 6383 0 6384 0 6385 0 6386 0 6387 0 6388 0
107/374

xic-ref (-target linux [basic test]): arrinit02.xi
6389 0 6390 0 6391 0 6392 0 6393 0 6394 0 6395 0 6396 0 6397 0 6398 0 6399 0 6400 0 6401 0 6402 0 6403 0 6404 0 6405 0 6406 0 6407 0 6408 0 6409 0 6410 0 6411 0 6412 0 6413 0 6414 0 6415 0 6416 0 6417 0 6418 0 6419 0 6420 0 6421 0 6422 0 6423 0 6424 0 6425 0 6426 0 6427 0 6428 0 6429 0 6430 0 6431 0 6432 0 6433 0 6434 0 6435 0 6436 0 6437 0 6438 0 6439 0 6440 0 6441 0 6442 0 6443 0 6444 0 6445 0 6446 0 6447 0 6448 0
108/374

xic-ref (-target linux [basic test]): arrinit02.xi
6449 0 6450 0 6451 0 6452 0 6453 0 6454 0 6455 0 6456 0 6457 0 6458 0 6459 0 6460 0 6461 0 6462 0 6463 0 6464 0 6465 0 6466 0 6467 0 6468 0 6469 0 6470 0 6471 0 6472 0 6473 0 6474 0 6475 0 6476 0 6477 0 6478 0 6479 0 6480 0 6481 0 6482 0 6483 0 6484 0 6485 0 6486 0 6487 0 6488 0 6489 0 6490 0 6491 0 6492 0 6493 0 6494 0 6495 0 6496 0 6497 0 6498 0 6499 0 6500 0 6501 0 6502 0 6503 0 6504 0 6505 0 6506 0 6507 0 6508 0
109/374

xic-ref (-target linux [basic test]): arrinit02.xi
6509 0 6510 0 6511 0 6512 0 6513 0 6514 0 6515 0 6516 0 6517 0 6518 0 6519 0 6520 0 6521 0 6522 0 6523 0 6524 0 6525 0 6526 0 6527 0 6528 0 6529 0 6530 0 6531 0 6532 0 6533 0 6534 0 6535 0 6536 0 6537 0 6538 0 6539 0 6540 0 6541 0 6542 0 6543 0 6544 0 6545 0 6546 0 6547 0 6548 0 6549 0 6550 0 6551 0 6552 0 6553 0 6554 0 6555 0 6556 0 6557 0 6558 0 6559 0 6560 0 6561 0 6562 0 6563 0 6564 0 6565 0 6566 0 6567 0 6568 0
110/374

xic-ref (-target linux [basic test]): arrinit02.xi
6569 0 6570 0 6571 0 6572 0 6573 0 6574 0 6575 0 6576 0 6577 0 6578 0 6579 0 6580 0 6581 0 6582 0 6583 0 6584 0 6585 0 6586 0 6587 0 6588 0 6589 0 6590 0 6591 0 6592 0 6593 0 6594 0 6595 0 6596 0 6597 0 6598 0 6599 0 6600 0 6601 0 6602 0 6603 0 6604 0 6605 0 6606 0 6607 0 6608 0 6609 0 6610 0 6611 0 6612 0 6613 0 6614 0 6615 0 6616 0 6617 0 6618 0 6619 0 6620 0 6621 0 6622 0 6623 0 6624 0 6625 0 6626 0 6627 0 6628 0
111/374

xic-ref (-target linux [basic test]): arrinit02.xi
6629 0 6630 0 6631 0 6632 0 6633 0 6634 0 6635 0 6636 0 6637 0 6638 0 6639 0 6640 0 6641 0 6642 0 6643 0 6644 0 6645 0 6646 0 6647 0 6648 0 6649 0 6650 0 6651 0 6652 0 6653 0 6654 0 6655 0 6656 0 6657 0 6658 0 6659 0 6660 0 6661 0 6662 0 6663 0 6664 0 6665 0 6666 0 6667 0 6668 0 6669 2 6670 53 6671 51 6672 0 6673 0 6674 0 6675 1 6676 50 6677 0 6678 0 6679 0 6680 0 6681 1 6682 48 6683 0 6684 0 6685 0 6686 0 6687 2 6688 53
112/374

xic-ref (-target linux [basic test]): arrinit02.xi
6689 52 6690 0 6691 0 6692 0 6693 2 6694 53 6695 51 6696 0 6697 0 6698 0 6699 1 6700 50 6701 0 6702 0 6703 0 6704 0 6705 1 6706 48 6707 0 6708 0 6709 0 6710 0 6711 1 6712 48 6713 0 6714 0 6715 0 6716 0 6717 2 6718 52 6719 56 6720 0 6721 0 6722 0 6723 1 6724 49 6725 0 6726 0 6727 0 6728 0 6729 1 6730 48 6731 0 6732 0 6733 0 6734 0 6735 1 6736 48 6737 0 6738 0 6739 0 6740 0 6741 2 6742 53 6743 54 6744 0 6745 0 6746 0 6747 1 6748 49
113/374

xic-ref (-target linux [basic test]): arrinit02.xi
6749 0 6750 0 6751 0 6752 0 6753 1 6754 48 6755 0 6756 0 6757 0 6758 0 6759 2 6760 52 6761 57 6762 0 6763 0 6764 0 6765 2 6766 53 6767 51 6768 0 6769 0 6770 0 6771 1 6772 50 6773 0 6774 0 6775 0 6776 0 6777 1 6778 48 6779 0 6780 0 6781 0 6782 0 6783 2 6784 53 6785 52 6786 0 6787 0 6788 0 6789 2 6790 53 6791 51 6792 0 6793 0 6794 0 6795 1 6796 50 6797 0 6798 0 6799 0 6800 0 6801 1 6802 48 6803 0 6804 0 6805 0 6806 0 6807 2 6808 52
114/374

xic-ref (-target linux [basic test]): arrinit02.xi
6809 57 6810 0 6811 0 6812 0 6813 2 6814 53 6815 51 6816 0 6817 0 6818 0 6819 1 6820 50 6821 0 6822 0 6823 0 6824 0 6825 1 6826 48 6827 0 6828 0 6829 0 6830 0 6831 2 6832 52 6833 57 6834 0 6835 0 6836 0 6837 2 6838 53 6839 51 6840 0 6841 0 6842 0 6843 1 6844 50 6845 0 6846 0 6847 0 6848 0 6849 1 6850 48 6851 0 6852 0 6853 0 6854 0 6855 2 6856 53 6857 49 6858 0 6859 0 6860 0 6861 2 6862 53 6863 51 6864 0 6865 0 6866 0 6867 1 6868 50
115/374

xic-ref (-target linux [basic test]): arrinit02.xi
6869 0 6870 0 6871 0 6872 0 6873 1 6874 48 6875 0 6876 0 6877 0 6878 0 6879 2 6880 53 6881 53 6882 0 6883 0 6884 0 6885 2 6886 53 6887 51 6888 0 6889 0 6890 0 6891 1 6892 50 6893 0 6894 0 6895 0 6896 0 6897 1 6898 48 6899 0 6900 0 6901 0 6902 0 6903 2 6904 52 6905 57 6906 0 6907 0 6908 0 6909 2 6910 53 6911 51 6912 0 6913 0 6914 0 6915 1 6916 50 6917 0 6918 0 6919 0 6920 0 6921 1 6922 48 6923 0 6924 0 6925 0 6926 0 6927 2 6928 53
116/374

xic-ref (-target linux [basic test]): arrinit02.xi
6929 50 6930 0 6931 0 6932 0 6933 2 6934 53 6935 51 6936 0 6937 0 6938 0 6939 1 6940 50 6941 0 6942 0 6943 0 6944 0 6945 1 6946 48 6947 0 6948 0 6949 0 6950 0 6951 1 6952 48 6953 0 6954 0 6955 0 6956 0 6957 2 6958 52 6959 56 6960 0 6961 0 6962 0 6963 1 6964 49 6965 0 6966 0 6967 0 6968 0 6969 1 6970 48 6971 0 6972 0 6973 0 6974 0 6975 1 6976 48 6977 0 6978 0 6979 0 6980 0 6981 2 6982 53 6983 54 6984 0 6985 0 6986 0 6987 1 6988 49
117/374

xic-ref (-target linux [basic test]): arrinit02.xi
6989 0 6990 0 6991 0 6992 0 6993 1 6994 48 6995 0 6996 0 6997 0 6998 0 6999 2 7000 52 7001 57 7002 0 7003 0 7004 0 7005 2 7006 53 7007 51 7008 0 7009 0 7010 0 7011 1 7012 50 7013 0 7014 0 7015 0 7016 0 7017 1 7018 48 7019 0 7020 0 7021 0 7022 0 7023 2 7024 53 7025 52 7026 0 7027 0 7028 0 7029 2 7030 53 7031 51 7032 0 7033 0 7034 0 7035 1 7036 50 7037 0 7038 0 7039 0 7040 0 7041 1 7042 48 7043 0 7044 0 7045 0 7046 0 7047 2 7048 52
118/374

xic-ref (-target linux [basic test]): arrinit02.xi
7049 57 7050 0 7051 0 7052 0 7053 2 7054 53 7055 51 7056 0 7057 0 7058 0 7059 1 7060 50 7061 0 7062 0 7063 0 7064 0 7065 1 7066 48 7067 0 7068 0 7069 0 7070 0 7071 2 7072 52 7073 57 7074 0 7075 0 7076 0 7077 2 7078 53 7079 51 7080 0 7081 0 7082 0 7083 1 7084 50 7085 0 7086 0 7087 0 7088 0 7089 1 7090 48 7091 0 7092 0 7093 0 7094 0 7095 2 7096 53 7097 49 7098 0 7099 0 7100 0 7101 2 7102 53 7103 51 7104 0 7105 0 7106 0 7107 1 7108 50
119/374

xic-ref (-target linux [basic test]): arrinit02.xi
7109 0 7110 0 7111 0 7112 0 7113 1 7114 48 7115 0 7116 0 7117 0 7118 0 7119 2 7120 53 7121 53 7122 0 7123 0 7124 0 7125 2 7126 53 7127 51 7128 0 7129 0 7130 0 7131 1 7132 50 7133 0 7134 0 7135 0 7136 0 7137 1 7138 48 7139 0 7140 0 7141 0 7142 0 7143 2 7144 53 7145 54 7146 0 7147 0 7148 0 7149 2 7150 53 7151 50 7152 0 7153 0 7154 0 7155 1 7156 50 7157 0 7158 0 7159 0 7160 0 7161 1 7162 48 7163 0 7164 0 7165 0 7166 0 7167 2 7168 53
120/374

xic-ref (-target linux [basic test]): arrinit02.xi
7169 48 7170 0 7171 0 7172 0 7173 2 7174 52 7175 56 7176 0 7177 0 7178 0 7179 0 7180 0 7181 2 7182 53 7183 50 7184 0 7185 1 7186 50 7187 0 7188 0 7189 1 7190 48 7191 0 7192 0 7193 1 7194 48 7195 0 7196 0 7197 2 7198 52 7199 56 7200 0 7201 1 7202 49 7203 0 7204 0 7205 1 7206 48 7207 0 7208 0 7209 1 7210 48 7211 0 7212 0 7213 2 7214 52 7215 56 7216 0 7217 1 7218 49 7219 0 7220 0 7221 1 7222 48 7223 0 7224 0 7225 1 7226 48 7227 0 7228 0
121/374

xic-ref (-target linux [basic test]): arrinit02.xi
7229 2 7230 52 7231 57 7232 0 7233 1 7234 49 7235 0 7236 0 7237 1 7238 48 7239 0 7240 0 7241 2 7242 53 7243 54 7244 0 7245 2 7246 53 7247 50 7248 0 7249 1 7250 50 7251 0 7252 0 7253 1 7254 48 7255 0 7256 0 7257 1 7258 48 7259 0 7260 0 7261 2 7262 52 7263 56 7264 0 7265 1 7266 49 7267 0 7268 0 7269 1 7270 48 7271 0 7272 0 7273 1 7274 48 7275 0 7276 0 7277 2 7278 52 7279 56 7280 0 7281 1 7282 49 7283 0 7284 0 7285 1 7286 48 7287 0 7288 0
122/374

xic-ref (-target linux [basic test]): arrinit02.xi
7289 1 7290 48 7291 0 7292 0 7293 2 7294 52 7295 57 7296 0 7297 1 7298 49 7299 0 7300 0 7301 1 7302 48 7303 0 7304 0 7305 2 7306 53 7307 54 7308 0 7309 2 7310 53 7311 50 7312 0 7313 1 7314 50 7315 0 7316 0 7317 1 7318 48 7319 0 7320 0 7321 1 7322 48 7323 0 7324 0 7325 2 7326 52 7327 56 7328 0 7329 1 7330 49 7331 0 7332 0 7333 1 7334 48 7335 0 7336 0 7337 1 7338 48 7339 0 7340 0 7341 2 7342 52 7343 56 7344 0 7345 1 7346 49 7347 0 7348 0
123/374

xic-ref (-target linux [basic test]): arrinit02.xi
7349 1 7350 48 7351 0 7352 0 7353 1 7354 48 7355 0 7356 0 7357 2 7358 52 7359 57 7360 0 7361 1 7362 49 7363 0 7364 0 7365 1 7366 48 7367 0 7368 0 7369 2 7370 53 7371 54 7372 0 7373 2 7374 53 7375 50 7376 0 7377 1 7378 50 7379 0 7380 0 7381 1 7382 48 7383 0 7384 0 7385 1 7386 48 7387 0 7388 0 7389 2 7390 52 7391 56 7392 0 7393 1 7394 49 7395 0 7396 0 7397 1 7398 48 7399 0 7400 0 7401 1 7402 48 7403 0 7404 0 7405 2 7406 52 7407 56 7408 0
124/374

xic-ref (-target linux [basic test]): arrinit02.xi
7409 1 7410 49 7411 0 7412 0 7413 1 7414 48 7415 0 7416 0 7417 1 7418 48 7419 0 7420 0 7421 2 7422 52 7423 57 7424 0 7425 1 7426 49 7427 0 7428 0 7429 1 7430 48 7431 0 7432 0 7433 2 7434 53 7435 54 7436 0 7437 2 7438 53 7439 50 7440 0 7441 1 7442 50 7443 0 7444 0 7445 1 7446 48 7447 0 7448 0 7449 1 7450 48 7451 0 7452 0 7453 2 7454 52 7455 56 7456 0 7457 1 7458 49 7459 0 7460 0 7461 1 7462 48 7463 0 7464 0 7465 1 7466 48 7467 0 7468 0
125/374

xic-ref (-target linux [basic test]): arrinit02.xi
7469 2 7470 52 7471 56 7472 0 7473 1 7474 49 7475 0 7476 0 7477 1 7478 48 7479 0 7480 0 7481 1 7482 48 7483 0 7484 0 7485 2 7486 52 7487 57 7488 0 7489 1 7490 49 7491 0 7492 0 7493 1 7494 48 7495 0 7496 0 7497 2 7498 53 7499 54 7500 0 7501 2 7502 53 7503 50 7504 0 7505 1 7506 50 7507 0 7508 0 7509 1 7510 48 7511 0 7512 0 7513 1 7514 48 7515 0 7516 0 7517 2 7518 52 7519 56 7520 0 7521 1 7522 49 7523 0 7524 0 7525 1 7526 48 7527 0 7528 0
126/374

xic-ref (-target linux [basic test]): arrinit02.xi
7529 1 7530 48 7531 0 7532 0 7533 2 7534 52 7535 56 7536 0 7537 1 7538 49 7539 0 7540 0 7541 1 7542 48 7543 0 7544 0 7545 1 7546 48 7547 0 7548 0 7549 2 7550 52 7551 57 7552 0 7553 1 7554 49 7555 0 7556 0 7557 1 7558 48 7559 0 7560 0 7561 2 7562 53 7563 54 7564 0 7565 2 7566 53 7567 50 7568 0 7569 1 7570 50 7571 0 7572 0 7573 1 7574 48 7575 0 7576 0 7577 1 7578 48 7579 0 7580 0 7581 2 7582 52 7583 56 7584 0 7585 1 7586 49 7587 0 7588 0
127/374

xic-ref (-target linux [basic test]): arrinit02.xi
7589 1 7590 48 7591 0 7592 0 7593 1 7594 48 7595 0 7596 0 7597 2 7598 52 7599 56 7600 0 7601 1 7602 49 7603 0 7604 0 7605 1 7606 48 7607 0 7608 0 7609 1 7610 48 7611 0 7612 0 7613 2 7614 52 7615 56 7616 0 7617 1 7618 49 7619 0 7620 0 7621 1 7622 48 7623 0 7624 0 7625 1 7626 48 7627 0 7628 0 7629 2 7630 52 7631 56 7632 0 7633 1 7634 49 7635 0 7636 0 7637 1 7638 48 7639 0 7640 0 7641 1 7642 48 7643 0 7644 0 7645 2 7646 52 7647 56 7648 0
128/374

xic-ref (-target linux [basic test]): arrinit02.xi
7649 1 7650 49 7651 0 7652 0 7653 1 7654 48 7655 0 7656 0 7657 1 7658 48 7659 0 7660 0 7661 2 7662 52 7663 56 7664 0 7665 1 7666 49 7667 0 7668 0 7669 1 7670 48 7671 0 7672 0 7673 1 7674 48 7675 0 7676 0 7677 2 7678 52 7679 56 7680 0 7681 1 7682 49 7683 0 7684 0 7685 1 7686 48 7687 0 7688 0 7689 1 7690 48 7691 0 7692 0 7693 2 7694 53 7695 50 7696 0 7697 1 7698 50 7699 0 7700 0 7701 1 7702 48 7703 0 7704 0 7705 1 7706 48 7707 0 7708 0
129/374

xic-ref (-target linux [basic test]): arrinit02.xi
7709 2 7710 52 7711 56 7712 0 7713 1 7714 49 7715 0 7716 0 7717 1 7718 48 7719 0 7720 0 7721 1 7722 48 7723 0 7724 0 7725 2 7726 52 7727 56 7728 0 7729 1 7730 49 7731 0 7732 0 7733 1 7734 48 7735 0 7736 0 7737 1 7738 48 7739 0 7740 0 7741 2 7742 52 7743 57 7744 0 7745 1 7746 49 7747 0 7748 0 7749 1 7750 48 7751 0 7752 0 7753 2 7754 53 7755 54 7756 0 7757 2 7758 53 7759 50 7760 0 7761 1 7762 50 7763 0 7764 0 7765 1 7766 48 7767 0 7768 0
130/374

xic-ref (-target linux [basic test]): arrinit02.xi
7769 1 7770 48 7771 0 7772 0 7773 2 7774 52 7775 56 7776 0 7777 1 7778 49 7779 0 7780 0 7781 1 7782 48 7783 0 7784 0 7785 1 7786 48 7787 0 7788 0 7789 2 7790 52 7791 56 7792 0 7793 1 7794 49 7795 0 7796 0 7797 1 7798 48 7799 0 7800 0 7801 1 7802 48 7803 0 7804 0 7805 2 7806 52 7807 57 7808 0 7809 1 7810 49 7811 0 7812 0 7813 1 7814 48 7815 0 7816 0 7817 2 7818 53 7819 54 7820 0 7821 2 7822 53 7823 50 7824 0 7825 1 7826 50 7827 0 7828 0
131/374

xic-ref (-target linux [basic test]): arrinit02.xi
7829 1 7830 48 7831 0 7832 0 7833 1 7834 48 7835 0 7836 0 7837 2 7838 52 7839 56 7840 0 7841 1 7842 49 7843 0 7844 0 7845 1 7846 48 7847 0 7848 0 7849 1 7850 48 7851 0 7852 0 7853 2 7854 52 7855 56 7856 0 7857 1 7858 49 7859 0 7860 0 7861 1 7862 48 7863 0 7864 0 7865 1 7866 48 7867 0 7868 0 7869 2 7870 52 7871 57 7872 0 7873 1 7874 49 7875 0 7876 0 7877 1 7878 48 7879 0 7880 0 7881 2 7882 53 7883 54 7884 0 7885 2 7886 53 7887 50 7888 0
132/374

xic-ref (-target linux [basic test]): arrinit02.xi
7889 1 7890 50 7891 0 7892 0 7893 1 7894 48 7895 0 7896 0 7897 1 7898 48 7899 0 7900 0 7901 2 7902 52 7903 56 7904 0 7905 1 7906 49 7907 0 7908 0 7909 1 7910 48 7911 0 7912 0 7913 1 7914 48 7915 0 7916 0 7917 2 7918 52 7919 56 7920 0 7921 1 7922 49 7923 0 7924 0 7925 1 7926 48 7927 0 7928 0 7929 1 7930 48 7931 0 7932 0 7933 2 7934 52 7935 57 7936 0 7937 1 7938 49 7939 0 7940 0 7941 1 7942 48 7943 0 7944 0 7945 2 7946 53 7947 54 7948 0
133/374

xic-ref (-target linux [basic test]): arrinit02.xi
7949 2 7950 53 7951 50 7952 0 7953 1 7954 50 7955 0 7956 0 7957 1 7958 48 7959 0 7960 0 7961 1 7962 48 7963 0 7964 0 7965 2 7966 52 7967 56 7968 0 7969 1 7970 49 7971 0 7972 0 7973 1 7974 48 7975 0 7976 0 7977 1 7978 48 7979 0 7980 0 7981 2 7982 52 7983 56 7984 0 7985 1 7986 49 7987 0 7988 0 7989 1 7990 48 7991 0 7992 0 7993 1 7994 48 7995 0 7996 0 7997 2 7998 52 7999 57 8000 0 8001 1 8002 49 8003 0 8004 0 8005 1 8006 48 8007 0 8008 0
134/374

xic-ref (-target linux [basic test]): arrinit02.xi
8009 2 8010 53 8011 54 8012 0 8013 2 8014 53 8015 50 8016 0 8017 1 8018 50 8019 0 8020 0 8021 1 8022 48 8023 0 8024 0 8025 1 8026 48 8027 0 8028 0 8029 2 8030 52 8031 56 8032 0 8033 1 8034 49 8035 0 8036 0 8037 1 8038 48 8039 0 8040 0 8041 1 8042 48 8043 0 8044 0 8045 2 8046 52 8047 56 8048 0 8049 1 8050 49 8051 0 8052 0 8053 1 8054 48 8055 0 8056 0 8057 1 8058 48 8059 0 8060 0 8061 2 8062 52 8063 57 8064 0 8065 1 8066 49 8067 0 8068 0
135/374

xic-ref (-target linux [basic test]): arrinit02.xi
8069 1 8070 48 8071 0 8072 0 8073 2 8074 53 8075 54 8076 0 8077 2 8078 53 8079 50 8080 0 8081 1 8082 50 8083 0 8084 0 8085 1 8086 48 8087 0 8088 0 8089 1 8090 48 8091 0 8092 0 8093 2 8094 52 8095 56 8096 0 8097 1 8098 49 8099 0 8100 0 8101 1 8102 48 8103 0 8104 0 8105 1 8106 48 8107 0 8108 0 8109 2 8110 52 8111 56 8112 0 8113 1 8114 49 8115 0 8116 0 8117 1 8118 48 8119 0 8120 0 8121 1 8122 48 8123 0 8124 0 8125 2 8126 52 8127 57 8128 0
136/374

xic-ref (-target linux [basic test]): arrinit02.xi
8129 1 8130 49 8131 0 8132 0 8133 1 8134 48 8135 0 8136 0 8137 2 8138 53 8139 54 8140 0 8141 2 8142 53 8143 50 8144 0 8145 1 8146 50 8147 0 8148 0 8149 1 8150 48 8151 0 8152 0 8153 1 8154 48 8155 0 8156 0 8157 2 8158 52 8159 56 8160 0 8161 1 8162 49 8163 0 8164 0 8165 1 8166 48 8167 0 8168 0 8169 1 8170 48 8171 0 8172 0 8173 2 8174 52 8175 56 8176 0 8177 1 8178 49 8179 0 8180 0 8181 1 8182 48 8183 0 8184 0 8185 1 8186 48 8187 0 8188 0
137/374

xic-ref (-target linux [basic test]): arrinit02.xi
8189 2 8190 52 8191 57 8192 0 8193 1 8194 49 8195 0 8196 0 8197 1 8198 48 8199 0 8200 0 8201 2 8202 53 8203 54 8204 0 8205 2 8206 53 8207 50 8208 0 8209 1 8210 50 8211 0 8212 0 8213 1 8214 48 8215 0 8216 0 8217 1 8218 48 8219 0 8220 0 8221 2 8222 52 8223 56 8224 0 8225 1 8226 49 8227 0 8228 0 8229 1 8230 48 8231 0 8232 0 8233 1 8234 48 8235 0 8236 0 8237 2 8238 52 8239 56 8240 0 8241 1 8242 49 8243 0 8244 0 8245 1 8246 48 8247 0 8248 0
138/374

xic-ref (-target linux [basic test]): arrinit02.xi
8249 1 8250 48 8251 0 8252 0 8253 2 8254 52 8255 57 8256 0 8257 1 8258 49 8259 0 8260 0 8261 1 8262 48 8263 0 8264 0 8265 2 8266 53 8267 54 8268 0 8269 2 8270 53 8271 50 8272 0 8273 1 8274 50 8275 0 8276 0 8277 1 8278 48 8279 0 8280 0 8281 1 8282 48 8283 0 8284 0 8285 2 8286 52 8287 56 8288 0 8289 1 8290 49 8291 0 8292 0 8293 1 8294 48 8295 0 8296 0 8297 1 8298 48 8299 0 8300 0 8301 2 8302 52 8303 56 8304 0 8305 1 8306 49 8307 0 8308 0
139/374

xic-ref (-target linux [basic test]): arrinit02.xi
8309 1 8310 48 8311 0 8312 0 8313 1 8314 48 8315 0 8316 0 8317 2 8318 52 8319 57 8320 0 8321 1 8322 49 8323 0 8324 0 8325 1 8326 48 8327 0 8328 0 8329 2 8330 53 8331 54 8332 0 8333 2 8334 53 8335 50 8336 0 8337 1 8338 50 8339 0 8340 0 8341 1 8342 48 8343 0 8344 0 8345 1 8346 48 8347 0 8348 0 8349 2 8350 52 8351 56 8352 0 8353 1 8354 49 8355 0 8356 0 8357 1 8358 48 8359 0 8360 0 8361 1 8362 48 8363 0 8364 0 8365 2 8366 52 8367 56 8368 0
140/374

xic-ref (-target linux [basic test]): arrinit02.xi
8369 1 8370 49 8371 0 8372 0 8373 1 8374 48 8375 0 8376 0 8377 1 8378 48 8379 0 8380 0 8381 2 8382 52 8383 57 8384 0 8385 1 8386 49 8387 0 8388 0 8389 1 8390 48 8391 0 8392 0 8393 2 8394 53 8395 54 8396 0 8397 2 8398 53 8399 50 8400 0 8401 1 8402 50 8403 0 8404 0 8405 1 8406 48 8407 0 8408 0 8409 1 8410 48 8411 0 8412 0 8413 2 8414 52 8415 56 8416 0 8417 1 8418 49 8419 0 8420 0 8421 1 8422 48 8423 0 8424 0 8425 1 8426 48 8427 0 8428 0
141/374

xic-ref (-target linux [basic test]): arrinit02.xi
8429 2 8430 52 8431 56 8432 0 8433 1 8434 49 8435 0 8436 0 8437 1 8438 48 8439 0 8440 0 8441 1 8442 48 8443 0 8444 0 8445 2 8446 52 8447 57 8448 0 8449 1 8450 49 8451 0 8452 0 8453 1 8454 48 8455 0 8456 0 8457 2 8458 53 8459 54 8460 0 8461 2 8462 53 8463 50 8464 0 8465 1 8466 50 8467 0 8468 0 8469 1 8470 48 8471 0 8472 0 8473 1 8474 48 8475 0 8476 0 8477 2 8478 52 8479 56 8480 0 8481 1 8482 49 8483 0 8484 0 8485 1 8486 48 8487 0 8488 0
142/374

xic-ref (-target linux [basic test]): arrinit02.xi
8489 1 8490 48 8491 0 8492 0 8493 2 8494 52 8495 56 8496 0 8497 1 8498 49 8499 0 8500 0 8501 1 8502 48 8503 0 8504 0 8505 1 8506 48 8507 0 8508 0 8509 2 8510 52 8511 57 8512 0 8513 1 8514 49 8515 0 8516 0 8517 1 8518 48 8519 0 8520 0 8521 2 8522 53 8523 54 8524 0 8525 2 8526 53 8527 50 8528 0 8529 1 8530 50 8531 0 8532 0 8533 1 8534 48 8535 0 8536 0 8537 1 8538 48 8539 0 8540 0 8541 2 8542 52 8543 56 8544 0 8545 1 8546 49 8547 0 8548 0
143/374

xic-ref (-target linux [basic test]): arrinit02.xi
8549 1 8550 48 8551 0 8552 0 8553 1 8554 48 8555 0 8556 0 8557 2 8558 52 8559 56 8560 0 8561 1 8562 49 8563 0 8564 0 8565 1 8566 48 8567 0 8568 0 8569 1 8570 48 8571 0 8572 0 8573 2 8574 52 8575 57 8576 0 8577 1 8578 49 8579 0 8580 0 8581 1 8582 48 8583 0 8584 0 8585 2 8586 53 8587 54 8588 0 8589 2 8590 53 8591 50 8592 0 8593 1 8594 50 8595 0 8596 0 8597 1 8598 48 8599 0 8600 0 8601 1 8602 48 8603 0 8604 0 8605 2 8606 52 8607 56 8608 0
144/374

xic-ref (-target linux [basic test]): arrinit02.xi
8609 1 8610 49 8611 0 8612 0 8613 1 8614 48 8615 0 8616 0 8617 1 8618 48 8619 0 8620 0 8621 2 8622 52 8623 56 8624 0 8625 1 8626 49 8627 0 8628 0 8629 1 8630 48 8631 0 8632 0 8633 1 8634 48 8635 0 8636 0 8637 2 8638 52 8639 57 8640 0 8641 1 8642 49 8643 0 8644 0 8645 1 8646 48 8647 0 8648 0 8649 2 8650 53 8651 54 8652 0 8653 2 8654 53 8655 50 8656 0 8657 1 8658 50 8659 0 8660 0 8661 1 8662 48 8663 0 8664 0 8665 1 8666 48 8667 0 8668 0
145/374

xic-ref (-target linux [basic test]): arrinit02.xi
8669 2 8670 52 8671 56 8672 0 8673 1 8674 49 8675 0 8676 0 8677 1 8678 48 8679 0 8680 0 8681 1 8682 48 8683 0 8684 0 8685 2 8686 52 8687 56 8688 0 8689 1 8690 49 8691 0 8692 0 8693 1 8694 48 8695 0 8696 0 8697 1 8698 48 8699 0 8700 0 8701 2 8702 52 8703 57 8704 0 8705 1 8706 49 8707 0 8708 0 8709 1 8710 48 8711 0 8712 0 8713 2 8714 53 8715 54 8716 0 8717 2 8718 53 8719 51 8720 0 8721 1 8722 50 8723 0 8724 0 8725 1 8726 48 8727 0 8728 0
146/374

xic-ref (-target linux [basic test]): arrinit02.xi
8729 2 8730 53 8731 48 8732 0 8733 2 8734 53 8735 51 8736 0 8737 1 8738 50 8739 0 8740 0 8741 1 8742 48 8743 0 8744 0 8745 2 8746 53 8747 54 8748 0 8749 2 8750 53 8751 50 8752 0 8753 1 8754 50 8755 0 8756 0 8757 1 8758 48 8759 0 8760 0 8761 1 8762 48 8763 0 8764 0 8765 2 8766 52 8767 56 8768 0 8769 1 8770 49 8771 0 8772 0 8773 1 8774 48 8775 0 8776 0 8777 1 8778 48 8779 0 8780 0 8781 2 8782 53 8783 54 8784 0 8785 1 8786 49 8787 0 8788 0
147/374

xic-ref (-target linux [basic test]): arrinit02.xi
8789 1 8790 48 8791 0 8792 0 8793 2 8794 52 8795 57 8796 0 8797 2 8798 53 8799 51 8800 0 8801 1 8802 50 8803 0 8804 0 8805 1 8806 48 8807 0 8808 0 8809 2 8810 53 8811 52 8812 0 8813 2 8814 53 8815 51 8816 0 8817 1 8818 50 8819 0 8820 0 8821 1 8822 48 8823 0 8824 0 8825 1 8826 48 8827 0 8828 0 8829 2 8830 52 8831 57 8832 0 8833 1 8834 49 8835 0 8836 0 8837 1 8838 48 8839 0 8840 0 8841 2 8842 53 8843 54 8844 0 8845 2 8846 53 8847 50 8848 0
148/374

xic-ref (-target linux [basic test]): arrinit02.xi
8849 1 8850 50 8851 0 8852 0 8853 1 8854 48 8855 0 8856 0 8857 1 8858 48 8859 0 8860 0 8861 2 8862 52 8863 56 8864 0 8865 1 8866 49 8867 0 8868 0 8869 1 8870 48 8871 0 8872 0 8873 1 8874 48 8875 0 8876 0 8877 2 8878 52 8879 56 8880 0 8881 1 8882 49 8883 0 8884 0 8885 1 8886 48 8887 0 8888 0 8889 1 8890 48 8891 0 8892 0 8893 2 8894 52 8895 57 8896 0 8897 1 8898 49 8899 0 8900 0 8901 1 8902 48 8903 0 8904 0 8905 2 8906 53 8907 54 8908 0
149/374

xic-ref (-target linux [basic test]): arrinit02.xi
8909 2 8910 53 8911 50 8912 0 8913 1 8914 50 8915 0 8916 0 8917 1 8918 48 8919 0 8920 0 8921 1 8922 48 8923 0 8924 0 8925 2 8926 52 8927 56 8928 0 8929 1 8930 49 8931 0 8932 0 8933 1 8934 48 8935 0 8936 0 8937 1 8938 48 8939 0 8940 0 8941 2 8942 52 8943 56 8944 0 8945 1 8946 49 8947 0 8948 0 8949 1 8950 48 8951 0 8952 0 8953 1 8954 48 8955 0 8956 0 8957 2 8958 52 8959 57 8960 0 8961 1 8962 49 8963 0 8964 0 8965 1 8966 48 8967 0 8968 0
150/374

xic-ref (-target linux [basic test]): arrinit02.xi
8969 2 8970 53 8971 54 8972 0 8973 2 8974 53 8975 50 8976 0 8977 1 8978 50 8979 0 8980 0 8981 1 8982 48 8983 0 8984 0 8985 1 8986 48 8987 0 8988 0 8989 2 8990 52 8991 56 8992 0 8993 1 8994 49 8995 0 8996 0 8997 1 8998 48 8999 0 9000 0 9001 1 9002 48 9003 0 9004 0 9005 2 9006 52 9007 56 9008 0 9009 1 9010 49 9011 0 9012 0 9013 1 9014 48 9015 0 9016 0 9017 1 9018 48 9019 0 9020 0 9021 2 9022 52 9023 57 9024 0 9025 1 9026 49 9027 0 9028 0
151/374

xic-ref (-target linux [basic test]): arrinit02.xi
9029 1 9030 48 9031 0 9032 0 9033 2 9034 53 9035 54 9036 0 9037 2 9038 53 9039 50 9040 0 9041 1 9042 50 9043 0 9044 0 9045 1 9046 48 9047 0 9048 0 9049 1 9050 48 9051 0 9052 0 9053 2 9054 52 9055 56 9056 0 9057 1 9058 49 9059 0 9060 0 9061 1 9062 48 9063 0 9064 0 9065 1 9066 48 9067 0 9068 0 9069 2 9070 52 9071 56 9072 0 9073 1 9074 49 9075 0 9076 0 9077 1 9078 48 9079 0 9080 0 9081 1 9082 48 9083 0 9084 0 9085 2 9086 52 9087 57 9088 0
152/374

xic-ref (-target linux [basic test]): arrinit02.xi
9089 1 9090 49 9091 0 9092 0 9093 1 9094 48 9095 0 9096 0 9097 2 9098 53 9099 54 9100 0 9101 2 9102 53 9103 50 9104 0 9105 1 9106 50 9107 0 9108 0 9109 1 9110 48 9111 0 9112 0 9113 1 9114 48 9115 0 9116 0 9117 2 9118 52 9119 56 9120 0 9121 1 9122 49 9123 0 9124 0 9125 1 9126 48 9127 0 9128 0 9129 1 9130 48 9131 0 9132 0 9133 2 9134 52 9135 56 9136 0 9137 1 9138 49 9139 0 9140 0 9141 1 9142 48 9143 0 9144 0 9145 1 9146 48 9147 0 9148 0
153/374

xic-ref (-target linux [basic test]): arrinit02.xi
9149 2 9150 52 9151 57 9152 0 9153 1 9154 49 9155 0 9156 0 9157 1 9158 48 9159 0 9160 0 9161 2 9162 53 9163 54 9164 0 9165 2 9166 53 9167 50 9168 0 9169 1 9170 50 9171 0 9172 0 9173 1 9174 48 9175 0 9176 0 9177 1 9178 48 9179 0 9180 0 9181 2 9182 52 9183 56 9184 0 9185 1 9186 49 9187 0 9188 0 9189 1 9190 48 9191 0 9192 0 9193 1 9194 48 9195 0 9196 0 9197 2 9198 52 9199 56 9200 0 9201 1 9202 49 9203 0 9204 0 9205 1 9206 48 9207 0 9208 0
154/374

xic-ref (-target linux [basic test]): arrinit02.xi
9209 1 9210 48 9211 0 9212 0 9213 2 9214 52 9215 57 9216 0 9217 1 9218 49 9219 0 9220 0 9221 1 9222 48 9223 0 9224 0 9225 2 9226 53 9227 54 9228 0 9229 2 9230 52 9231 56 9232 0 9233 1 9234 49 9235 0 9236 0 9237 1 9238 48 9239 0 9240 0 9241 1 9242 48 9243 0 9244 0 9245 2 9246 52 9247 56 9248 0 9249 1 9250 49 9251 0 9252 0 9253 1 9254 48 9255 0 9256 0 9257 1 9258 48 9259 0 9260 0 9261 2 9262 52 9263 56 9264 0 9265 1 9266 49 9267 0 9268 0
155/374

xic-ref (-target linux [basic test]): arrinit02.xi
9269 1 9270 48 9271 0 9272 0 9273 1 9274 48 9275 0 9276 0 9277 2 9278 52 9279 56 9280 0 9281 1 9282 49 9283 0 9284 0 9285 1 9286 48 9287 0 9288 0 9289 1 9290 48 9291 0 9292 0 9293 2 9294 52 9295 56 9296 0 9297 1 9298 49 9299 0 9300 0 9301 1 9302 48 9303 0 9304 0 9305 1 9306 48 9307 0 9308 0 9309 2 9310 52 9311 56 9312 0 9313 1 9314 49 9315 0 9316 0 9317 1 9318 48 9319 0 9320 0 9321 1 9322 48 9323 0 9324 0 9325 2 9326 52 9327 56 9328 0
156/374

xic-ref (-target linux [basic test]): arrinit02.xi
9329 1 9330 49 9331 0 9332 0 9333 1 9334 48 9335 0 9336 0 9337 1 9338 48 9339 0 9340 0 9341 2 9342 52 9343 56 9344 0 9345 1 9346 49 9347 0 9348 0 9349 1 9350 48 9351 0 9352 0 9353 1 9354 48 9355 0 9356 0 9357 2 9358 52 9359 56 9360 0 9361 1 9362 49 9363 0 9364 0 9365 1 9366 48 9367 0 9368 0 9369 1 9370 48 9371 0 9372 0 9373 2 9374 52 9375 56 9376 0 9377 1 9378 49 9379 0 9380 0 9381 1 9382 48 9383 0 9384 0 9385 1 9386 48 9387 0 9388 0
157/374

xic-ref (-target linux [basic test]): arrinit02.xi
9389 2 9390 52 9391 56 9392 0 9393 1 9394 49 9395 0 9396 0 9397 1 9398 48 9399 0 9400 0 9401 1 9402 48 9403 0 9404 0 9405 2 9406 52 9407 56 9408 0 9409 1 9410 49 9411 0 9412 0 9413 1 9414 48 9415 0 9416 0 9417 1 9418 48 9419 0 9420 0 9421 2 9422 52 9423 56 9424 0 9425 1 9426 49 9427 0 9428 0 9429 1 9430 48 9431 0 9432 0 9433 1 9434 48 9435 0 9436 0 9437 2 9438 52 9439 56 9440 0 9441 1 9442 49 9443 0 9444 0 9445 1 9446 48 9447 0 9448 0
158/374

xic-ref (-target linux [basic test]): arrinit02.xi
9449 1 9450 48 9451 0 9452 0 9453 2 9454 52 9455 56 9456 0 9457 1 9458 49 9459 0 9460 0 9461 1 9462 48 9463 0 9464 0 9465 1 9466 48 9467 0 9468 0 9469 2 9470 52 9471 56 9472 0 9473 1 9474 49 9475 0 9476 0 9477 1 9478 48 9479 0 9480 0 9481 1 9482 48 9483 0 9484 0 9485 2 9486 52 9487 56 9488 0 9489 1 9490 49 9491 0 9492 0 9493 1 9494 48 9495 0 9496 0 9497 2 9498 52 9499 57 9500 0 9501 2 9502 53 9503 51 9504 0 9505 1 9506 50 9507 0 9508 0
159/374

xic-ref (-target linux [basic test]): arrinit02.xi
9509 1 9510 48 9511 0 9512 0 9513 2 9514 53 9515 52 9516 0 9517 2 9518 53 9519 51 9520 0 9521 1 9522 50 9523 0 9524 0 9525 1 9526 48 9527 0 9528 0 9529 2 9530 52 9531 57 9532 0 9533 2 9534 53 9535 51 9536 0 9537 1 9538 50 9539 0 9540 0 9541 1 9542 48 9543 0 9544 0 9545 2 9546 52 9547 57 9548 0 9549 2 9550 53 9551 51 9552 0 9553 1 9554 50 9555 0 9556 0 9557 1 9558 48 9559 0 9560 0 9561 2 9562 53 9563 53 9564 0 9565 2 9566 53 9567 51 9568 0
160/374

xic-ref (-target linux [basic test]): arrinit02.xi
9569 1 9570 50 9571 0 9572 0 9573 1 9574 48 9575 0 9576 0 9577 2 9578 53 9579 49 9580 0 9581 2 9582 53 9583 51 9584 0 9585 1 9586 50 9587 0 9588 0 9589 1 9590 48 9591 0 9592 0 9593 2 9594 52 9595 56 9596 0 9597 2 9598 53 9599 51 9600 0 9601 1 9602 50 9603 0 9604 0 9605 1 9606 48 9607 0 9608 0 9609 2 9610 53 9611 54 9612 0 9613 2 9614 53 9615 50 9616 0 9617 1 9618 50 9619 0 9620 0 9621 1 9622 48 9623 0 9624 0 9625 1 9626 48 9627 0 9628 0
161/374

xic-ref (-target linux [basic test]): arrinit02.xi
9629 2
9630 52
9631 56
9632 0
9633 1
9634 49
9635 0
9636 0
9637 1
9638 48
9639 0
9640 0
9641 1
9642 48
9643 0
9644 0
9645 2
9646 53
9647 54
9648 0
9649 1
9650 49
9651 0
9652 0
9653 1
9654 48
9655 0
9656 0
9657 2
9658 52
9659 57
9660 0
9661 2
9662 53
9663 51
9664 0
9665 1
9666 50
9667 0
9668 0
9669 1
9670 48
9671 0
9672 0
9673 2
9674 53
9675 52
9676 0
9677 2
9678 53
9679 51
9680 0
9681 38411776 9682 0
9683 0
9684 0
9685 38411808 9686 0
9687 0
9688 0
162/374

xic-ref (-target linux [basic test]): arrinit02.xi
9689 38411840 9690 0
9691 0
9692 0
9693 38411872 9694 0
9695 0
9696 0
9697 1 9698 48 9699 0 9700 0 9701 1 9702 48 9703 0 9704 0 9705 1 9706 48 9707 0 9708 0 9709 1 9710 48 9711 0 9712 0 9713 1 9714 48 9715 0 9716 0 9717 1 9718 48 9719 0 9720 0 9721 1 9722 48 9723 0 9724 0 9725 1 9726 48 9727 0 9728 0 9729 1 9730 48 9731 0 9732 0 9733 1 9734 48 9735 0 9736 0 9737 2 9738 53 9739 49 9740 0 9741 0 9742 0 9743 0 9744 0 9745 0 9746 0 9747 0 9748 0
163/374

xic-ref (-target linux [basic test]): arrinit02.xi
9749 0
9750 0
9751 38412288 9752 0
9753 0
9754 0
9755 0
9756 0
9757 0
9758 0
9759 0
9760 0
9761 38412368 9762 0
9763 0
9764 0
9765 0
9766 0
9767 0
9768 0
9769 0
9770 0
9771 38412448 9772 0
9773 0
9774 0
9775 0
9776 0
9777 0
9778 0
9779 0
9780 0
9781 38412528 9782 0
9783 0
9784 0
9785 0
9786 0
9787 0
9788 0
9789 0
9790 0
9791 38412608 9792 0
9793 0
9794 0
9795 0
9796 0
9797 0
9798 0
9799 0
9800 0
9801 38412688 9802 0
9803 0
9804 0
9805 0
9806 0
9807 0
9808 0
164/374

xic-ref (-target linux [basic test]): arrinit02.xi
9809 0
9810 0
9811 38412768 9812 0
9813 0
9814 0
9815 0
9816 0
9817 0
9818 0
9819 0
9820 0
9821 38412848 9822 0
9823 0
9824 0
9825 0
9826 0
9827 0
9828 0
9829 0
9830 0
9831 38412928 9832 0
9833 0
9834 0
9835 0
9836 0
9837 0
9838 0
9839 0
9840 0
9841 38413008 9842 0
9843 0
9844 0
9845 0
9846 0
9847 0
9848 0
9849 0
9850 0
9851 38413088 9852 0
9853 0
9854 0
9855 0
9856 0
9857 0
9858 0
9859 0
9860 0
9861 38413168 9862 0
9863 0
9864 0
9865 0
9866 0
9867 0
9868 0
165/374

xic-ref (-target linux [basic test]): arrinit02.xi
9869 0
9870 0
9871 38413248 9872 0
9873 0
9874 0
9875 0
9876 0
9877 0
9878 0
9879 0
9880 0
9881 38413328 9882 0
9883 0
9884 0
9885 0
9886 0
9887 0
9888 0
9889 0
9890 0
9891 38413408 9892 0
9893 0
9894 0
9895 0
9896 0
9897 0
9898 0
9899 0
9900 0
9901 38413488 9902 0
9903 0
9904 0
9905 0
9906 0
9907 0
9908 0
9909 0
9910 0
9911 38413568 9912 0
9913 0
9914 0
9915 0
9916 0
9917 0
9918 0
9919 0
9920 0
9921 38413648 9922 0
9923 0
9924 0
9925 0
9926 0
9927 0
9928 0
166/374

xic-ref (-target linux [basic test]): arrinit02.xi
9929 0
9930 0
9931 38413728 9932 0
9933 0
9934 0
9935 0
9936 0
9937 0
9938 0
9939 0
9940 0
9941 38413808 9942 0
9943 0
9944 0
9945 0
9946 0
9947 0
9948 0
9949 0
9950 0
9951 38413888 9952 0
9953 0
9954 0
9955 0
9956 0
9957 0
9958 0
9959 0
9960 0
9961 38413968 9962 0
9963 0
9964 0
9965 0
9966 0
9967 0
9968 0
9969 0
9970 0
9971 38414048 9972 0
9973 0
9974 0
9975 0
9976 0
9977 0
9978 0
9979 0
9980 0
9981 8
9982 51
9983 56
9984 52
9985 49
9986 52
9987 48
9988 52
167/374

xic-ref (-target linux [basic test]): arrinit02.xi
9989 56 9990 0 9991 8 9992 51 9993 56 9994 52 9995 49 9996 51 9997 57 9998 54 9999 56
10000 0 10001 8 10002 51 10003 56 10004 52 10005 49 10006 51 10007 56 10008 56 10009 56 10010 0 10011 8 10012 51 10013 56 10014 52 10015 49 10016 51 10017 56 10018 48 10019 56 10020 0 10021 8 10022 51 10023 56 10024 52 10025 49 10026 51 10027 55 10028 50 10029 56 10030 0 10031 8 10032 51 10033 56 10034 52 10035 49 10036 51 10037 54 10038 52 10039 56 10040 0 10041 8 10042 51 10043 56 10044 52 10045 49 10046 51 10047 53 10048 54
168/374

xic-ref (-target linux [basic test]): arrinit02.xi
10049 56 10050 0 10051 8 10052 51 10053 56 10054 52 10055 49 10056 51 10057 52 10058 56 10059 56 10060 0 10061 8 10062 51 10063 56 10064 52 10065 49 10066 51 10067 52 10068 48 10069 56 10070 0 10071 8 10072 51 10073 56 10074 52 10075 49 10076 51 10077 51 10078 50 10079 56 10080 0 10081 8 10082 51 10083 56 10084 52 10085 49 10086 51 10087 50 10088 52 10089 56 10090 0 10091 8 10092 51 10093 56 10094 52 10095 49 10096 51 10097 49 10098 54 10099 56 10100 0 10101 8 10102 51 10103 56 10104 52 10105 49 10106 51 10107 48 10108 56
169/374

xic-ref (-target linux [basic test]): arrinit02.xi
10109 56 10110 0 10111 8 10112 51 10113 56 10114 52 10115 49 10116 51 10117 48 10118 48 10119 56 10120 0 10121 8 10122 51 10123 56 10124 52 10125 49 10126 50 10127 57 10128 50 10129 56 10130 0 10131 8 10132 51 10133 56 10134 52 10135 49 10136 50 10137 56 10138 52 10139 56 10140 0 10141 8 10142 51 10143 56 10144 52 10145 49 10146 50 10147 55 10148 54 10149 56 10150 0 10151 8 10152 51 10153 56 10154 52 10155 49 10156 50 10157 54 10158 56 10159 56 10160 0 10161 8 10162 51 10163 56 10164 52 10165 49 10166 50 10167 54 10168 48
170/374

xic-ref (-target linux [basic test]): arrinit02.xi
10169 56 10170 0 10171 8 10172 51 10173 56 10174 52 10175 49 10176 50 10177 53 10178 50 10179 56 10180 0 10181 8 10182 51 10183 56 10184 52 10185 49 10186 50 10187 52 10188 52 10189 56 10190 0 10191 8 10192 51 10193 56 10194 52 10195 49 10196 50 10197 51 10198 54 10199 56 10200 0 10201 8 10202 51 10203 56 10204 52 10205 49 10206 50 10207 50 10208 56 10209 56 10210 0 10211 8 10212 51 10213 56 10214 52 10215 49 10216 49 10217 56 10218 55 10219 50 10220 0 10221 8 10222 51 10223 56 10224 52 10225 49 10226 49 10227 56 10228 52
171/374

xic-ref (-target linux [basic test]): arrinit02.xi
10229 48 10230 0 10231 8 10232 51 10233 56 10234 52 10235 49 10236 49 10237 56 10238 48 10239 56 10240 0 10241 8 10242 51 10243 56 10244 52 10245 49 10246 49 10247 55 10248 55 10249 54 10250 0 10251 0 10252 0 10253 1 10254 48 10255 0 10256 0 10257 1 10258 48 10259 0 10260 0 10261 1 10262 48 10263 0 10264 0 10265 1 10266 48 10267 0 10268 0 10269 1 10270 48 10271 0 10272 0 10273 1 10274 48 10275 0 10276 0 10277 1 10278 48 10279 0 10280 0 10281 1 10282 48 10283 0 10284 0 10285 1 10286 48 10287 0 10288 0
172/374

xic-ref (-target linux [basic test]): arrinit02.xi
10289 1 10290 48 10291 0 10292 0 10293 1 10294 48 10295 0 10296 0 10297 1 10298 48 10299 0 10300 0 10301 1 10302 48 10303 0 10304 0 10305 1 10306 48 10307 0 10308 0 10309 1 10310 48 10311 0 10312 0 10313 1 10314 48 10315 0 10316 0 10317 1 10318 48 10319 0 10320 0 10321 1 10322 48 10323 0 10324 0 10325 1 10326 48 10327 0 10328 0 10329 1 10330 48 10331 0 10332 0 10333 1 10334 48 10335 0 10336 0 10337 1 10338 48 10339 0 10340 0 10341 1 10342 48 10343 0 10344 0 10345 1 10346 48 10347 0 10348 0
173/374

xic-ref (-target linux [basic test]): arrinit02.xi
10349 1 10350 48 10351 0 10352 0 10353 1 10354 48 10355 0 10356 0 10357 1 10358 48 10359 0 10360 0 10361 1 10362 48 10363 0 10364 0 10365 1 10366 48 10367 0 10368 0 10369 1 10370 48 10371 0 10372 0 10373 1 10374 48 10375 0 10376 0 10377 1 10378 48 10379 0 10380 0 10381 1 10382 48 10383 0 10384 0 10385 1 10386 48 10387 0 10388 0 10389 1 10390 48 10391 0 10392 0 10393 1 10394 48 10395 0 10396 0 10397 1 10398 48 10399 0 10400 0 10401 1 10402 48 10403 0 10404 0 10405 1 10406 48 10407 0 10408 0
174/374

xic-ref (-target linux [basic test]): arrinit02.xi
10409 1 10410 48 10411 0 10412 0 10413 1 10414 48 10415 0 10416 0 10417 1 10418 48 10419 0 10420 0 10421 1 10422 48 10423 0 10424 0 10425 1 10426 48 10427 0 10428 0 10429 1 10430 48 10431 0 10432 0 10433 1 10434 48 10435 0 10436 0 10437 1 10438 48 10439 0 10440 0 10441 1 10442 48 10443 0 10444 0 10445 1 10446 48 10447 0 10448 0 10449 1 10450 48 10451 0 10452 0 10453 1 10454 48 10455 0 10456 0 10457 1 10458 48 10459 0 10460 0 10461 1 10462 48 10463 0 10464 0 10465 1 10466 48 10467 0 10468 0
175/374

xic-ref (-target linux [basic test]): arrinit02.xi
10469 1 10470 48 10471 0 10472 0 10473 1 10474 48 10475 0 10476 0 10477 1 10478 48 10479 0 10480 0 10481 1 10482 48 10483 0 10484 0 10485 1 10486 48 10487 0 10488 0 10489 1 10490 48 10491 0 10492 0 10493 1 10494 48 10495 0 10496 0 10497 1 10498 48 10499 0 10500 0 10501 1 10502 48 10503 0 10504 0 10505 1 10506 48 10507 0 10508 0 10509 1 10510 48 10511 0 10512 0 10513 1 10514 48 10515 0 10516 0 10517 1 10518 48 10519 0 10520 0 10521 1 10522 48 10523 0 10524 0 10525 1 10526 48 10527 0 10528 0
176/374

xic-ref (-target linux [basic test]): arrinit02.xi
10529 1 10530 48 10531 0 10532 0 10533 1 10534 48 10535 0 10536 0 10537 1 10538 48 10539 0 10540 0 10541 1 10542 48 10543 0 10544 0 10545 1 10546 48 10547 0 10548 0 10549 1 10550 48 10551 0 10552 0 10553 1 10554 48 10555 0 10556 0 10557 1 10558 48 10559 0 10560 0 10561 1 10562 48 10563 0 10564 0 10565 1 10566 48 10567 0 10568 0 10569 1 10570 48 10571 0 10572 0 10573 1 10574 48 10575 0 10576 0 10577 1 10578 48 10579 0 10580 0 10581 1 10582 48 10583 0 10584 0 10585 1 10586 48 10587 0 10588 0
177/374

xic-ref (-target linux [basic test]): arrinit02.xi
10589 1 10590 48 10591 0 10592 0 10593 1 10594 48 10595 0 10596 0 10597 1 10598 48 10599 0 10600 0 10601 1 10602 48 10603 0 10604 0 10605 1 10606 48 10607 0 10608 0 10609 1 10610 48 10611 0 10612 0 10613 1 10614 48 10615 0 10616 0 10617 1 10618 48 10619 0 10620 0 10621 1 10622 48 10623 0 10624 0 10625 1 10626 48 10627 0 10628 0 10629 1 10630 48 10631 0 10632 0 10633 1 10634 48 10635 0 10636 0 10637 1 10638 48 10639 0 10640 0 10641 1 10642 48 10643 0 10644 0 10645 1 10646 48 10647 0 10648 0
178/374

xic-ref (-target linux [basic test]): arrinit02.xi
10649 1 10650 48 10651 0 10652 0 10653 1 10654 48 10655 0 10656 0 10657 1 10658 48 10659 0 10660 0 10661 1 10662 48 10663 0 10664 0 10665 1 10666 48 10667 0 10668 0 10669 1 10670 48 10671 0 10672 0 10673 1 10674 48 10675 0 10676 0 10677 1 10678 48 10679 0 10680 0 10681 1 10682 48 10683 0 10684 0 10685 1 10686 48 10687 0 10688 0 10689 1 10690 48 10691 0 10692 0 10693 1 10694 48 10695 0 10696 0 10697 1 10698 48 10699 0 10700 0 10701 1 10702 48 10703 0 10704 0 10705 1 10706 48 10707 0 10708 0
179/374

xic-ref (-target linux [basic test]): arrinit02.xi
10709 1 10710 48 10711 0 10712 0 10713 1 10714 48 10715 0 10716 0 10717 1 10718 48 10719 0 10720 0 10721 1 10722 48 10723 0 10724 0 10725 1 10726 48 10727 0 10728 0 10729 1 10730 48 10731 0 10732 0 10733 1 10734 48 10735 0 10736 0 10737 1 10738 48 10739 0 10740 0 10741 1 10742 48 10743 0 10744 0 10745 1 10746 48 10747 0 10748 0 10749 1 10750 48 10751 0 10752 0 10753 1 10754 48 10755 0 10756 0 10757 1 10758 48 10759 0 10760 0 10761 1 10762 48 10763 0 10764 0 10765 2 10766 53 10767 54 10768 0
180/374

xic-ref (-target linux [basic test]): arrinit02.xi
10769 2 10770 53 10771 50 10772 0 10773 2 10774 53 10775 48 10776 0 10777 2 10778 53 10779 49 10780 0 10781 2 10782 52 10783 57 10784 0 10785 2 10786 53 10787 50 10788 0 10789 2 10790 53 10791 54 10792 0 10793 2 10794 53 10795 49 10796 0 10797 1 10798 56 10799 0 10800 0 10801 1 10802 48 10803 0 10804 0 10805 2 10806 53 10807 54 10808 0 10809 2 10810 53 10811 48 10812 0 10813 2 10814 53 10815 49 10816 0 10817 2 10818 53 10819 49 10820 0 10821 2 10822 52 10823 57 10824 0 10825 2 10826 53 10827 50 10828 0
181/374

xic-ref (-target linux [basic test]): arrinit02.xi
10829 2 10830 53 10831 54 10832 0 10833 2 10834 53 10835 49 10836 0 10837 1 10838 56 10839 0 10840 0 10841 1 10842 48 10843 0 10844 0 10845 2 10846 53 10847 54 10848 0 10849 2 10850 52 10851 56 10852 0 10853 2 10854 53 10855 50 10856 0 10857 2 10858 53 10859 49 10860 0 10861 2 10862 52 10863 57 10864 0 10865 2 10866 53 10867 50 10868 0 10869 2 10870 53 10871 54 10872 0 10873 2 10874 53 10875 49 10876 0 10877 1 10878 56 10879 0 10880 0 10881 1 10882 48 10883 0 10884 0 10885 2 10886 53 10887 54 10888 0
182/374

xic-ref (-target linux [basic test]): arrinit02.xi
10889 2 10890 53 10891 54 10892 0 10893 2 10894 53 10895 50 10896 0 10897 2 10898 53 10899 49 10900 0 10901 2 10902 52 10903 57 10904 0 10905 2 10906 53 10907 50 10908 0 10909 2 10910 53 10911 54 10912 0 10913 2 10914 53 10915 49 10916 0 10917 1 10918 56 10919 0 10920 0 10921 1 10922 48 10923 0 10924 0 10925 2 10926 53 10927 54 10928 0 10929 2 10930 53 10931 52 10932 0 10933 2 10934 53 10935 51 10936 0 10937 2 10938 53 10939 49 10940 0 10941 2 10942 52 10943 57 10944 0 10945 2 10946 53 10947 50 10948 0
183/374

xic-ref (-target linux [basic test]): arrinit02.xi
10949 2 10950 53 10951 54 10952 0 10953 2 10954 53 10955 49 10956 0 10957 1 10958 56 10959 0 10960 0 10961 1 10962 48 10963 0 10964 0 10965 2 10966 53 10967 54 10968 0 10969 2 10970 53 10971 50 10972 0 10973 2 10974 53 10975 52 10976 0 10977 2 10978 53 10979 49 10980 0 10981 2 10982 52 10983 57 10984 0 10985 2 10986 53 10987 50 10988 0 10989 2 10990 53 10991 54 10992 0 10993 2 10994 53 10995 49 10996 0 10997 1 10998 56 10999 0 11000 0 11001 1 11002 48 11003 0 11004 0 11005 2 11006 53 11007 54 11008 0
184/374

xic-ref (-target linux [basic test]): arrinit02.xi
11009 2 11010 53 11011 48 11012 0 11013 2 11014 53 11015 53 11016 0 11017 2 11018 53 11019 49 11020 0 11021 2 11022 52 11023 57 11024 0 11025 2 11026 53 11027 50 11028 0 11029 2 11030 53 11031 54 11032 0 11033 2 11034 53 11035 49 11036 0 11037 1 11038 56 11039 0 11040 0 11041 1 11042 48 11043 0 11044 0 11045 2 11046 53 11047 54 11048 0 11049 2 11050 52 11051 56 11052 0 11053 2 11054 53 11055 54 11056 0 11057 2 11058 53 11059 49 11060 0 11061 2 11062 52 11063 57 11064 0 11065 2 11066 53 11067 50 11068 0
185/374

xic-ref (-target linux [basic test]): arrinit02.xi
11069 2 11070 53 11071 54 11072 0 11073 2 11074 53 11075 49 11076 0 11077 1 11078 56 11079 0 11080 0 11081 1 11082 48 11083 0 11084 0 11085 2 11086 53 11087 54 11088 0 11089 2 11090 53 11091 54 11092 0 11093 2 11094 53 11095 54 11096 0 11097 2 11098 53 11099 49 11100 0 11101 2 11102 52 11103 57 11104 0 11105 2 11106 53 11107 50 11108 0 11109 2 11110 53 11111 54 11112 0 11113 2 11114 53 11115 49 11116 0 11117 1 11118 56 11119 0 11120 0 11121 1 11122 48 11123 0 11124 0 11125 2 11126 53 11127 54 11128 0
186/374

xic-ref (-target linux [basic test]): arrinit02.xi
11129 2 11130 53 11131 52 11132 0 11133 2 11134 53 11135 55 11136 0 11137 2 11138 53 11139 49 11140 0 11141 2 11142 52 11143 57 11144 0 11145 2 11146 53 11147 50 11148 0 11149 2 11150 53 11151 54 11152 0 11153 2 11154 53 11155 49 11156 0 11157 1 11158 56 11159 0 11160 0 11161 1 11162 48 11163 0 11164 0 11165 2 11166 53 11167 54 11168 0 11169 2 11170 53 11171 50 11172 0 11173 2 11174 52 11175 56 11176 0 11177 2 11178 53 11179 50 11180 0 11181 2 11182 52 11183 57 11184 0 11185 2 11186 53 11187 50 11188 0
187/374

xic-ref (-target linux [basic test]): arrinit02.xi
11189 2
11190 53 11191 54 11192 0
11193 2
11194 53 11195 49 11196 0
11197 38423904 11198 0
11199 0
11200 0
11201 38423936 11202 0
11203 0
11204 0
11205 38423968 11206 0
11207 0
11208 0
11209 38424000 11210 0
11211 0
11212 0
11213 38424032 11214 0
11215 0
11216 0
11217 1
11218 48 11219 0
11220 0
11221 1
11222 48 11223 0
11224 0
11225 1
11226 48 11227 0
11228 0
11229 1
11230 48 11231 0
11232 0
11233 1
11234 48 11235 0
11236 0
11237 1
11238 48 11239 0
11240 0
11241 1
11242 48 11243 0
11244 0
11245 1
11246 48 11247 0
11248 0
188/374

xic-ref (-target linux [basic test]): arrinit02.xi
11249 1 11250 48 11251 0 11252 0 11253 1 11254 48 11255 0 11256 0 11257 1 11258 48 11259 0 11260 0 11261 1 11262 48 11263 0 11264 0 11265 1 11266 48 11267 0 11268 0 11269 1 11270 48 11271 0 11272 0 11273 1 11274 48 11275 0 11276 0 11277 2 11278 53 11279 54 11280 0 11281 2 11282 52 11283 57 11284 0 11285 2 11286 52 11287 57 11288 0 11289 2 11290 53 11291 50 11292 0 11293 2 11294 53 11295 54 11296 0 11297 2 11298 53 11299 49 11300 0 11301 1 11302 56 11303 0 11304 0 11305 1 11306 48 11307 0 11308 0
189/374

xic-ref (-target linux [basic test]): arrinit02.xi
11309 2
11310 53 11311 54 11312 0
11313 2
11314 53 11315 54 11316 0
11317 2
11318 53 11319 48 11320 0
11321 2
11322 53 11323 48 11324 0
11325 2
11326 52 11327 57 11328 0
11329 2
11330 0
11331 0
11332 0
11333 38424992 11334 0
11335 0
11336 0
11337 38425024 11338 0
11339 0
11340 0
11341 38425056 11342 0
11343 0
11344 0
11345 38425088 11346 0
11347 0
11348 0
11349 38425120 11350 0
11351 0
11352 0
11353 38425152 11354 0
11355 0
11356 0
11357 38425184 11358 0
11359 0
11360 0
11361 38425216 11362 0
11363 0
11364 0
11365 38425248 11366 0
11367 0
11368 0
190/374

xic-ref (-target linux [basic test]): arrinit02.xi
11369 38425280 11370 0
11371 0
11372 0
11373 38425312 11374 0
11375 0
11376 0
11377 38425344 11378 0
11379 0
11380 0
11381 38425376 11382 0
11383 0
11384 0
11385 38425408 11386 0
11387 0
11388 0
11389 38425440 11390 0
11391 0
11392 0
11393 38425472 11394 0
11395 0
11396 0
11397 38425504 11398 0
11399 0
11400 0
11401 38425536 11402 0
11403 0
11404 0
11405 38425568 11406 0
11407 0
11408 0
11409 38425600 11410 0
11411 0
11412 0
11413 38425632 11414 0
11415 0
11416 0
11417 38425664 11418 0
11419 0
11420 0
11421 38425696 11422 0
11423 0
11424 0
11425 38425728 11426 0
11427 0
11428 0
191/374

xic-ref (-target linux [basic test]): arrinit02.xi
11429 38425760 11430 0
11431 0
11432 0
11433 38425792 11434 0
11435 0
11436 0
11437 38425824 11438 0
11439 0
11440 0
11441 38425856 11442 0
11443 0
11444 0
11445 1 11446 48 11447 0 11448 0 11449 1 11450 48 11451 0 11452 0 11453 1 11454 48 11455 0 11456 0 11457 1 11458 48 11459 0 11460 0 11461 1 11462 48 11463 0 11464 0 11465 1 11466 48 11467 0 11468 0 11469 1 11470 48 11471 0 11472 0 11473 1 11474 48 11475 0 11476 0 11477 1 11478 48 11479 0 11480 0 11481 1 11482 48 11483 0 11484 0 11485 1 11486 48 11487 0 11488 0
192/374

xic-ref (-target linux [basic test]): arrinit02.xi
11489 1 11490 48 11491 0 11492 0 11493 1 11494 48 11495 0 11496 0 11497 1 11498 48 11499 0 11500 0 11501 1 11502 48 11503 0 11504 0 11505 1 11506 48 11507 0 11508 0 11509 1 11510 48 11511 0 11512 0 11513 1 11514 48 11515 0 11516 0 11517 1 11518 48 11519 0 11520 0 11521 1 11522 48 11523 0 11524 0 11525 1 11526 48 11527 0 11528 0 11529 1 11530 48 11531 0 11532 0 11533 1 11534 48 11535 0 11536 0 11537 1 11538 48 11539 0 11540 0 11541 1 11542 48 11543 0 11544 0 11545 1 11546 48 11547 0 11548 0
193/374

xic-ref (-target linux [basic test]): arrinit02.xi
11549 1 11550 48 11551 0 11552 0 11553 1 11554 48 11555 0 11556 0 11557 1 11558 48 11559 0 11560 0 11561 1 11562 48 11563 0 11564 0 11565 1 11566 48 11567 0 11568 0 11569 1 11570 48 11571 0 11572 0 11573 1 11574 48 11575 0 11576 0 11577 1 11578 48 11579 0 11580 0 11581 1 11582 48 11583 0 11584 0 11585 1 11586 48 11587 0 11588 0 11589 1 11590 48 11591 0 11592 0 11593 1 11594 48 11595 0 11596 0 11597 1 11598 48 11599 0 11600 0 11601 1 11602 48 11603 0 11604 0 11605 1 11606 48 11607 0 11608 0
194/374

xic-ref (-target linux [basic test]): arrinit02.xi
11609 1 11610 48 11611 0 11612 0 11613 1 11614 48 11615 0 11616 0 11617 1 11618 48 11619 0 11620 0 11621 1 11622 48 11623 0 11624 0 11625 1 11626 48 11627 0 11628 0 11629 1 11630 48 11631 0 11632 0 11633 1 11634 48 11635 0 11636 0 11637 1 11638 48 11639 0 11640 0 11641 1 11642 48 11643 0 11644 0 11645 1 11646 48 11647 0 11648 0 11649 1 11650 48 11651 0 11652 0 11653 1 11654 48 11655 0 11656 0 11657 1 11658 48 11659 0 11660 0 11661 1 11662 48 11663 0 11664 0 11665 1 11666 48 11667 0 11668 0
195/374

xic-ref (-target linux [basic test]): arrinit02.xi
11669 1 11670 48 11671 0 11672 0 11673 1 11674 48 11675 0 11676 0 11677 1 11678 48 11679 0 11680 0 11681 1 11682 48 11683 0 11684 0 11685 1 11686 48 11687 0 11688 0 11689 1 11690 48 11691 0 11692 0 11693 1 11694 48 11695 0 11696 0 11697 1 11698 48 11699 0 11700 0 11701 1 11702 48 11703 0 11704 0 11705 1 11706 48 11707 0 11708 0 11709 1 11710 48 11711 0 11712 0 11713 1 11714 48 11715 0 11716 0 11717 1 11718 48 11719 0 11720 0 11721 1 11722 48 11723 0 11724 0 11725 1 11726 48 11727 0 11728 0
196/374

xic-ref (-target linux [basic test]): arrinit02.xi
11729 1 11730 48 11731 0 11732 0 11733 1 11734 48 11735 0 11736 0 11737 1 11738 48 11739 0 11740 0 11741 1 11742 48 11743 0 11744 0 11745 1 11746 48 11747 0 11748 0 11749 1 11750 48 11751 0 11752 0 11753 1 11754 48 11755 0 11756 0 11757 1 11758 48 11759 0 11760 0 11761 1 11762 48 11763 0 11764 0 11765 1 11766 48 11767 0 11768 0 11769 1 11770 48 11771 0 11772 0 11773 1 11774 48 11775 0 11776 0 11777 1 11778 48 11779 0 11780 0 11781 1 11782 48 11783 0 11784 0 11785 1 11786 50 11787 0 11788 0
197/374

xic-ref (-target linux [basic test]): arrinit02.xi
11789 1 11790 48 11791 0 11792 0 11793 1 11794 48 11795 0 11796 0 11797 2 11798 52 11799 56 11800 0 11801 1 11802 49 11803 0 11804 0 11805 1 11806 48 11807 0 11808 0 11809 1 11810 48 11811 0 11812 0 11813 2 11814 52 11815 56 11816 0 11817 1 11818 49 11819 0 11820 0 11821 1 11822 48 11823 0 11824 0 11825 1 11826 48 11827 0 11828 0 11829 2 11830 52 11831 56 11832 0 11833 1 11834 49 11835 0 11836 0 11837 1 11838 48 11839 0 11840 0 11841 1 11842 48 11843 0 11844 0 11845 2 11846 52 11847 56 11848 0
198/374

xic-ref (-target linux [basic test]): arrinit02.xi
11849 1 11850 49 11851 0 11852 0 11853 1 11854 48 11855 0 11856 0 11857 1 11858 48 11859 0 11860 0 11861 2 11862 52 11863 56 11864 0 11865 1 11866 49 11867 0 11868 0 11869 1 11870 48 11871 0 11872 0 11873 1 11874 48 11875 0 11876 0 11877 2 11878 52 11879 56 11880 0 11881 1 11882 49 11883 0 11884 0 11885 1 11886 48 11887 0 11888 0 11889 1 11890 48 11891 0 11892 0 11893 2 11894 52 11895 56 11896 0 11897 1 11898 49 11899 0 11900 0 11901 1 11902 48 11903 0 11904 0 11905 1 11906 48 11907 0 11908 0
199/374

xic-ref (-target linux [basic test]): arrinit02.xi
11909 2 11910 52 11911 56 11912 0 11913 1 11914 49 11915 0 11916 0 11917 1 11918 48 11919 0 11920 0 11921 1 11922 48 11923 0 11924 0 11925 2 11926 52 11927 56 11928 0 11929 1 11930 49 11931 0 11932 0 11933 1 11934 48 11935 0 11936 0 11937 1 11938 48 11939 0 11940 0 11941 2 11942 52 11943 56 11944 0 11945 1 11946 49 11947 0 11948 0 11949 1 11950 48 11951 0 11952 0 11953 1 11954 48 11955 0 11956 0 11957 2 11958 52 11959 56 11960 0 11961 1 11962 49 11963 0 11964 0 11965 1 11966 48 11967 0 11968 0
200/374

xic-ref (-target linux [basic test]): arrinit02.xi
11969 1 11970 48 11971 0 11972 0 11973 2 11974 52 11975 56 11976 0 11977 1 11978 49 11979 0 11980 0 11981 1 11982 48 11983 0 11984 0 11985 1 11986 48 11987 0 11988 0 11989 2 11990 52 11991 56 11992 0 11993 1 11994 49 11995 0 11996 0 11997 1 11998 48 11999 0 12000 0 12001 1 12002 48 12003 0 12004 0 12005 2 12006 52 12007 56 12008 0 12009 1 12010 49 12011 0 12012 0 12013 1 12014 48 12015 0 12016 0 12017 1 12018 48 12019 0 12020 0 12021 2 12022 52 12023 56 12024 0 12025 1 12026 49 12027 0 12028 0
201/374

xic-ref (-target linux [basic test]): arrinit02.xi
12029 1 12030 48 12031 0 12032 0 12033 1 12034 48 12035 0 12036 0 12037 2 12038 52 12039 56 12040 0 12041 1 12042 49 12043 0 12044 0 12045 1 12046 48 12047 0 12048 0 12049 1 12050 48 12051 0 12052 0 12053 2 12054 52 12055 56 12056 0 12057 1 12058 49 12059 0 12060 0 12061 1 12062 48 12063 0 12064 0 12065 1 12066 48 12067 0 12068 0 12069 2 12070 52 12071 56 12072 0 12073 1 12074 49 12075 0 12076 0 12077 1 12078 48 12079 0 12080 0 12081 1 12082 48 12083 0 12084 0 12085 2 12086 52 12087 56 12088 0
202/374

xic-ref (-target linux [basic test]): arrinit02.xi
12089 1 12090 49 12091 0 12092 0 12093 1 12094 48 12095 0 12096 0 12097 1 12098 48 12099 0 12100 0 12101 2 12102 52 12103 56 12104 0 12105 1 12106 49 12107 0 12108 0 12109 1 12110 48 12111 0 12112 0 12113 1 12114 48 12115 0 12116 0 12117 2 12118 52 12119 56 12120 0 12121 1 12122 49 12123 0 12124 0 12125 1 12126 48 12127 0 12128 0 12129 1 12130 48 12131 0 12132 0 12133 2 12134 52 12135 56 12136 0 12137 1 12138 49 12139 0 12140 0 12141 1 12142 48 12143 0 12144 0 12145 1 12146 48 12147 0 12148 0
203/374

xic-ref (-target linux [basic test]): arrinit02.xi
12149 2 12150 52 12151 56 12152 0 12153 1 12154 49 12155 0 12156 0 12157 1 12158 48 12159 0 12160 0 12161 1 12162 48 12163 0 12164 0 12165 2 12166 52 12167 56 12168 0 12169 1 12170 49 12171 0 12172 0 12173 1 12174 48 12175 0 12176 0 12177 1 12178 48 12179 0 12180 0 12181 2 12182 52 12183 56 12184 0 12185 1 12186 49 12187 0 12188 0 12189 1 12190 48 12191 0 12192 0 12193 1 12194 48 12195 0 12196 0 12197 2 12198 52 12199 56 12200 0 12201 1 12202 49 12203 0 12204 0 12205 1 12206 48 12207 0 12208 0
204/374

xic-ref (-target linux [basic test]): arrinit02.xi
12209 1 12210 48 12211 0 12212 0 12213 2 12214 52 12215 56 12216 0 12217 1 12218 49 12219 0 12220 0 12221 1 12222 48 12223 0 12224 0 12225 1 12226 48 12227 0 12228 0 12229 2 12230 52 12231 56 12232 0 12233 1 12234 49 12235 0 12236 0 12237 1 12238 48 12239 0 12240 0 12241 1 12242 48 12243 0 12244 0 12245 2 12246 52 12247 56 12248 0 12249 1 12250 49 12251 0 12252 0 12253 1 12254 48 12255 0 12256 0 12257 1 12258 48 12259 0 12260 0 12261 2 12262 52 12263 56 12264 0 12265 1 12266 49 12267 0 12268 0
205/374

xic-ref (-target linux [basic test]): arrinit02.xi
12269 1 12270 48 12271 0 12272 0 12273 1 12274 48 12275 0 12276 0 12277 2 12278 52 12279 56 12280 0 12281 1 12282 49 12283 0 12284 0 12285 1 12286 48 12287 0 12288 0 12289 1 12290 48 12291 0 12292 0 12293 2 12294 52 12295 56 12296 0 12297 1 12298 49 12299 0 12300 0 12301 1 12302 48 12303 0 12304 0 12305 1 12306 48 12307 0 12308 0 12309 2 12310 52 12311 56 12312 0 12313 1 12314 49 12315 0 12316 0 12317 1 12318 48 12319 0 12320 0 12321 1 12322 48 12323 0 12324 0 12325 2 12326 52 12327 56 12328 0
206/374

xic-ref (-target linux [basic test]): arrinit02.xi
12329 1 12330 49 12331 0 12332 0 12333 1 12334 48 12335 0 12336 0 12337 1 12338 48 12339 0 12340 0 12341 2 12342 52 12343 56 12344 0 12345 1 12346 49 12347 0 12348 0 12349 1 12350 48 12351 0 12352 0 12353 1 12354 48 12355 0 12356 0 12357 2 12358 52 12359 56 12360 0 12361 1 12362 49 12363 0 12364 0 12365 1 12366 48 12367 0 12368 0 12369 1 12370 48 12371 0 12372 0 12373 2 12374 52 12375 56 12376 0 12377 1 12378 49 12379 0 12380 0 12381 1 12382 48 12383 0 12384 0 12385 1 12386 48 12387 0 12388 0
207/374

xic-ref (-target linux [basic test]): arrinit02.xi
12389 2 12390 52 12391 56 12392 0 12393 1 12394 49 12395 0 12396 0 12397 1 12398 48 12399 0 12400 0 12401 1 12402 48 12403 0 12404 0 12405 2 12406 52 12407 56 12408 0 12409 1 12410 49 12411 0 12412 0 12413 1 12414 48 12415 0 12416 0 12417 1 12418 48 12419 0 12420 0 12421 2 12422 52 12423 56 12424 0 12425 1 12426 49 12427 0 12428 0 12429 1 12430 48 12431 0 12432 0 12433 1 12434 48 12435 0 12436 0 12437 2 12438 52 12439 56 12440 0 12441 1 12442 49 12443 0 12444 0 12445 1 12446 48 12447 0 12448 0
208/374

xic-ref (-target linux [basic test]): arrinit02.xi
12449 1 12450 48 12451 0 12452 0 12453 2 12454 52 12455 56 12456 0 12457 1 12458 49 12459 0 12460 0 12461 1 12462 48 12463 0 12464 0 12465 1 12466 48 12467 0 12468 0 12469 2 12470 52 12471 56 12472 0 12473 1 12474 49 12475 0 12476 0 12477 1 12478 48 12479 0 12480 0 12481 1 12482 48 12483 0 12484 0 12485 2 12486 52 12487 56 12488 0 12489 1 12490 49 12491 0 12492 0 12493 1 12494 48 12495 0 12496 0 12497 1 12498 48 12499 0 12500 0 12501 2 12502 52 12503 56 12504 0 12505 1 12506 49 12507 0 12508 0
209/374

xic-ref (-target linux [basic test]): arrinit02.xi
12509 1 12510 48 12511 0 12512 0 12513 1 12514 48 12515 0 12516 0 12517 2 12518 52 12519 56 12520 0 12521 1 12522 49 12523 0 12524 0 12525 1 12526 48 12527 0 12528 0 12529 1 12530 48 12531 0 12532 0 12533 2 12534 52 12535 56 12536 0 12537 1 12538 49 12539 0 12540 0 12541 1 12542 48 12543 0 12544 0 12545 1 12546 48 12547 0 12548 0 12549 2 12550 52 12551 56 12552 0 12553 1 12554 49 12555 0 12556 0 12557 1 12558 48 12559 0 12560 0 12561 1 12562 48 12563 0 12564 0 12565 2 12566 52 12567 56 12568 0
210/374

xic-ref (-target linux [basic test]): arrinit02.xi
12569 1 12570 49 12571 0 12572 0 12573 1 12574 48 12575 0 12576 0 12577 1 12578 48 12579 0 12580 0 12581 2 12582 52 12583 56 12584 0 12585 1 12586 49 12587 0 12588 0 12589 1 12590 48 12591 0 12592 0 12593 1 12594 48 12595 0 12596 0 12597 2 12598 52 12599 56 12600 0 12601 1 12602 49 12603 0 12604 0 12605 1 12606 48 12607 0 12608 0 12609 1 12610 48 12611 0 12612 0 12613 2 12614 52 12615 56 12616 0 12617 1 12618 49 12619 0 12620 0 12621 1 12622 48 12623 0 12624 0 12625 1 12626 48 12627 0 12628 0
211/374

xic-ref (-target linux [basic test]): arrinit02.xi
12629 2 12630 52 12631 56 12632 0 12633 1 12634 49 12635 0 12636 0 12637 1 12638 48 12639 0 12640 0 12641 1 12642 48 12643 0 12644 0 12645 2 12646 52 12647 56 12648 0 12649 1 12650 49 12651 0 12652 0 12653 1 12654 48 12655 0 12656 0 12657 1 12658 48 12659 0 12660 0 12661 2 12662 52 12663 56 12664 0 12665 1 12666 49 12667 0 12668 0 12669 1 12670 48 12671 0 12672 0 12673 1 12674 48 12675 0 12676 0 12677 2 12678 52 12679 56 12680 0 12681 1 12682 49 12683 0 12684 0 12685 1 12686 48 12687 0 12688 0
212/374

xic-ref (-target linux [basic test]): arrinit02.xi
12689 1 12690 48 12691 0 12692 0 12693 2 12694 52 12695 56 12696 0 12697 1 12698 49 12699 0 12700 0 12701 1 12702 48 12703 0 12704 0 12705 1 12706 48 12707 0 12708 0 12709 2 12710 52 12711 56 12712 0 12713 1 12714 49 12715 0 12716 0 12717 1 12718 48 12719 0 12720 0 12721 1 12722 48 12723 0 12724 0 12725 2 12726 52 12727 56 12728 0 12729 1 12730 49 12731 0 12732 0 12733 1 12734 48 12735 0 12736 0 12737 1 12738 48 12739 0 12740 0 12741 2 12742 52 12743 56 12744 0 12745 1 12746 49 12747 0 12748 0
213/374

xic-ref (-target linux [basic test]): arrinit02.xi
12749 1 12750 48 12751 0 12752 0 12753 1 12754 48 12755 0 12756 0 12757 2 12758 52 12759 56 12760 0 12761 1 12762 49 12763 0 12764 0 12765 1 12766 48 12767 0 12768 0 12769 1 12770 48 12771 0 12772 0 12773 2 12774 52 12775 56 12776 0 12777 1 12778 49 12779 0 12780 0 12781 1 12782 48 12783 0 12784 0 12785 1 12786 48 12787 0 12788 0 12789 2 12790 52 12791 56 12792 0 12793 1 12794 49 12795 0 12796 0 12797 1 12798 48 12799 0 12800 0 12801 1 12802 48 12803 0 12804 0 12805 2 12806 52 12807 56 12808 0
214/374

xic-ref (-target linux [basic test]): arrinit02.xi
12809 1 12810 49 12811 0 12812 0 12813 1 12814 48 12815 0 12816 0 12817 1 12818 48 12819 0 12820 0 12821 2 12822 52 12823 57 12824 0 12825 1 12826 49 12827 0 12828 0 12829 1 12830 48 12831 0 12832 0 12833 2 12834 53 12835 54 12836 0 12837 2 12838 53 12839 50 12840 0 12841 1 12842 50 12843 0 12844 0 12845 1 12846 48 12847 0 12848 0 12849 1 12850 48 12851 0 12852 0 12853 2 12854 52 12855 56 12856 0 12857 1 12858 49 12859 0 12860 0 12861 1 12862 48 12863 0 12864 0 12865 1 12866 48 12867 0 12868 0
215/374

xic-ref (-target linux [basic test]): arrinit02.xi
12869 2 12870 52 12871 56 12872 0 12873 1 12874 49 12875 0 12876 0 12877 1 12878 48 12879 0 12880 0 12881 1 12882 48 12883 0 12884 0 12885 2 12886 52 12887 57 12888 0 12889 1 12890 49 12891 0 12892 0 12893 1 12894 48 12895 0 12896 0 12897 2 12898 53 12899 54 12900 0 12901 2 12902 53 12903 50 12904 0 12905 1 12906 50 12907 0 12908 0 12909 1 12910 48 12911 0 12912 0 12913 1 12914 48 12915 0 12916 0 12917 2 12918 52 12919 56 12920 0 12921 1 12922 49 12923 0 12924 0 12925 1 12926 48 12927 0 12928 0
216/374

xic-ref (-target linux [basic test]): arrinit02.xi
12929 1 12930 48 12931 0 12932 0 12933 2 12934 52 12935 56 12936 0 12937 1 12938 49 12939 0 12940 0 12941 1 12942 48 12943 0 12944 0 12945 1 12946 48 12947 0 12948 0 12949 2 12950 52 12951 57 12952 0 12953 1 12954 49 12955 0 12956 0 12957 1 12958 48 12959 0 12960 0 12961 2 12962 53 12963 54 12964 0 12965 2 12966 53 12967 50 12968 0 12969 1 12970 50 12971 0 12972 0 12973 1 12974 48 12975 0 12976 0 12977 1 12978 48 12979 0 12980 0 12981 2 12982 52 12983 56 12984 0 12985 1 12986 49 12987 0 12988 0
217/374

xic-ref (-target linux [basic test]): arrinit02.xi
12989 1 12990 48 12991 0 12992 0 12993 1 12994 48 12995 0 12996 0 12997 2 12998 52 12999 56 13000 0 13001 1 13002 49 13003 0 13004 0 13005 1 13006 48 13007 0 13008 0 13009 1 13010 48 13011 0 13012 0 13013 2 13014 52 13015 57 13016 0 13017 1 13018 49 13019 0 13020 0 13021 1 13022 48 13023 0 13024 0 13025 2 13026 53 13027 54 13028 0 13029 2 13030 53 13031 50 13032 0 13033 1 13034 50 13035 0 13036 0 13037 1 13038 48 13039 0 13040 0 13041 1 13042 48 13043 0 13044 0 13045 2 13046 52 13047 56 13048 0
218/374

xic-ref (-target linux [basic test]): arrinit02.xi
13049 1 13050 49 13051 0 13052 0 13053 1 13054 48 13055 0 13056 0 13057 1 13058 48 13059 0 13060 0 13061 2 13062 52 13063 56 13064 0 13065 1 13066 49 13067 0 13068 0 13069 1 13070 48 13071 0 13072 0 13073 1 13074 48 13075 0 13076 0 13077 2 13078 52 13079 57 13080 0 13081 1 13082 49 13083 0 13084 0 13085 1 13086 48 13087 0 13088 0 13089 2 13090 53 13091 54 13092 0 13093 2 13094 53 13095 50 13096 0 13097 1 13098 50 13099 0 13100 0 13101 1 13102 48 13103 0 13104 0 13105 1 13106 48 13107 0 13108 0
219/374

xic-ref (-target linux [basic test]): arrinit02.xi
13109 2 13110 52 13111 56 13112 0 13113 1 13114 49 13115 0 13116 0 13117 1 13118 48 13119 0 13120 0 13121 1 13122 48 13123 0 13124 0 13125 2 13126 52 13127 56 13128 0 13129 1 13130 49 13131 0 13132 0 13133 1 13134 48 13135 0 13136 0 13137 1 13138 48 13139 0 13140 0 13141 2 13142 53 13143 48 13144 0 13145 1 13146 49 13147 0 13148 0 13149 1 13150 48 13151 0 13152 0 13153 1 13154 48 13155 0 13156 0 13157 2 13158 52 13159 56 13160 0 13161 1 13162 49 13163 0 13164 0 13165 1 13166 48 13167 0 13168 0
220/374

xic-ref (-target linux [basic test]): arrinit02.xi
13169 1 13170 48 13171 0 13172 0 13173 2 13174 52 13175 56 13176 0 13177 1 13178 49 13179 0 13180 0 13181 1 13182 48 13183 0 13184 0 13185 1 13186 48 13187 0 13188 0 13189 2 13190 52 13191 56 13192 0 13193 1 13194 49 13195 0 13196 0 13197 1 13198 48 13199 0 13200 0 13201 1 13202 48 13203 0 13204 0 13205 2 13206 52 13207 56 13208 0 13209 1 13210 49 13211 0 13212 0 13213 1 13214 48 13215 0 13216 0 13217 1 13218 48 13219 0 13220 0 13221 2 13222 52 13223 56 13224 0 13225 1 13226 49 13227 0 13228 0
221/374

xic-ref (-target linux [basic test]): arrinit02.xi
13229 1 13230 48 13231 0 13232 0 13233 1 13234 48 13235 0 13236 0 13237 2 13238 52 13239 56 13240 0 13241 1 13242 49 13243 0 13244 0 13245 1 13246 48 13247 0 13248 0 13249 1 13250 48 13251 0 13252 0 13253 2 13254 52 13255 56 13256 0 13257 1 13258 49 13259 0 13260 0 13261 1 13262 48 13263 0 13264 0 13265 1 13266 48 13267 0 13268 0 13269 2 13270 52 13271 56 13272 0 13273 1 13274 49 13275 0 13276 0 13277 1 13278 48 13279 0 13280 0 13281 1 13282 48 13283 0 13284 0 13285 2 13286 52 13287 56 13288 0
222/374

xic-ref (-target linux [basic test]): arrinit02.xi
13289 1 13290 49 13291 0 13292 0 13293 1 13294 48 13295 0 13296 0 13297 1 13298 48 13299 0 13300 0 13301 2 13302 52 13303 56 13304 0 13305 1 13306 49 13307 0 13308 0 13309 1 13310 48 13311 0 13312 0 13313 1 13314 48 13315 0 13316 0 13317 2 13318 52 13319 56 13320 0 13321 1 13322 49 13323 0 13324 0 13325 1 13326 48 13327 0 13328 0 13329 1 13330 48 13331 0 13332 0 13333 2 13334 52 13335 57 13336 0 13337 1 13338 49 13339 0 13340 0 13341 1 13342 48 13343 0 13344 0 13345 2 13346 53 13347 54 13348 0
223/374

xic-ref (-target linux [basic test]): arrinit02.xi
13349 2 13350 53 13351 50 13352 0 13353 1 13354 50 13355 0 13356 0 13357 1 13358 48 13359 0 13360 0 13361 1 13362 48 13363 0 13364 0 13365 2 13366 52 13367 56 13368 0 13369 1 13370 49 13371 0 13372 0 13373 1 13374 48 13375 0 13376 0 13377 1 13378 48 13379 0 13380 0 13381 2 13382 52 13383 56 13384 0 13385 1 13386 49 13387 0 13388 0 13389 1 13390 48 13391 0 13392 0 13393 1 13394 48 13395 0 13396 0 13397 2 13398 52 13399 57 13400 0 13401 1 13402 49 13403 0 13404 0 13405 1 13406 48 13407 0 13408 0
224/374

xic-ref (-target linux [basic test]): arrinit02.xi
13409 2 13410 53 13411 54 13412 0 13413 2 13414 53 13415 50 13416 0 13417 1 13418 50 13419 0 13420 0 13421 1 13422 48 13423 0 13424 0 13425 1 13426 48 13427 0 13428 0 13429 2 13430 52 13431 56 13432 0 13433 1 13434 49 13435 0 13436 0 13437 1 13438 48 13439 0 13440 0 13441 1 13442 48 13443 0 13444 0 13445 2 13446 52 13447 56 13448 0 13449 1 13450 49 13451 0 13452 0 13453 1 13454 48 13455 0 13456 0 13457 1 13458 48 13459 0 13460 0 13461 2 13462 52 13463 57 13464 0 13465 1 13466 49 13467 0 13468 0
225/374

xic-ref (-target linux [basic test]): arrinit02.xi
13469 1 13470 48 13471 0 13472 0 13473 2 13474 53 13475 54 13476 0 13477 2 13478 53 13479 50 13480 0 13481 1 13482 50 13483 0 13484 0 13485 1 13486 48 13487 0 13488 0 13489 1 13490 48 13491 0 13492 0 13493 2 13494 52 13495 56 13496 0 13497 1 13498 49 13499 0 13500 0 13501 1 13502 48 13503 0 13504 0 13505 1 13506 48 13507 0 13508 0 13509 2 13510 52 13511 56 13512 0 13513 1 13514 49 13515 0 13516 0 13517 1 13518 48 13519 0 13520 0 13521 1 13522 48 13523 0 13524 0 13525 2 13526 52 13527 57 13528 0
226/374

xic-ref (-target linux [basic test]): arrinit02.xi
13529 1 13530 49 13531 0 13532 0 13533 1 13534 48 13535 0 13536 0 13537 2 13538 53 13539 54 13540 0 13541 2 13542 53 13543 50 13544 0 13545 1 13546 50 13547 0 13548 0 13549 1 13550 48 13551 0 13552 0 13553 1 13554 48 13555 0 13556 0 13557 2 13558 52 13559 56 13560 0 13561 1 13562 49 13563 0 13564 0 13565 1 13566 48 13567 0 13568 0 13569 1 13570 48 13571 0 13572 0 13573 2 13574 52 13575 56 13576 0 13577 1 13578 49 13579 0 13580 0 13581 1 13582 48 13583 0 13584 0 13585 1 13586 48 13587 0 13588 0
227/374

xic-ref (-target linux [basic test]): arrinit02.xi
13589 2 13590 52 13591 57 13592 0 13593 1 13594 49 13595 0 13596 0 13597 1 13598 48 13599 0 13600 0 13601 2 13602 53 13603 54 13604 0 13605 2 13606 53 13607 50 13608 0 13609 1 13610 50 13611 0 13612 0 13613 1 13614 48 13615 0 13616 0 13617 1 13618 48 13619 0 13620 0 13621 2 13622 52 13623 56 13624 0 13625 1 13626 49 13627 0 13628 0 13629 1 13630 48 13631 0 13632 0 13633 1 13634 48 13635 0 13636 0 13637 2 13638 52 13639 56 13640 0 13641 1 13642 49 13643 0 13644 0 13645 1 13646 48 13647 0 13648 0
228/374

xic-ref (-target linux [basic test]): arrinit02.xi
13649 1 13650 48 13651 0 13652 0 13653 2 13654 52 13655 57 13656 0 13657 1 13658 49 13659 0 13660 0 13661 1 13662 48 13663 0 13664 0 13665 2 13666 53 13667 54 13668 0 13669 2 13670 53 13671 50 13672 0 13673 1 13674 50 13675 0 13676 0 13677 1 13678 48 13679 0 13680 0 13681 1 13682 48 13683 0 13684 0 13685 2 13686 52 13687 56 13688 0 13689 1 13690 49 13691 0 13692 0 13693 1 13694 48 13695 0 13696 0 13697 1 13698 48 13699 0 13700 0 13701 2 13702 52 13703 56 13704 0 13705 1 13706 49 13707 0 13708 0
229/374

xic-ref (-target linux [basic test]): arrinit02.xi
13709 1 13710 48 13711 0 13712 0 13713 1 13714 48 13715 0 13716 0 13717 2 13718 52 13719 57 13720 0 13721 1 13722 49 13723 0 13724 0 13725 1 13726 48 13727 0 13728 0 13729 2 13730 53 13731 54 13732 0 13733 2 13734 53 13735 50 13736 0 13737 1 13738 50 13739 0 13740 0 13741 1 13742 48 13743 0 13744 0 13745 1 13746 48 13747 0 13748 0 13749 2 13750 52 13751 56 13752 0 13753 1 13754 49 13755 0 13756 0 13757 1 13758 48 13759 0 13760 0 13761 1 13762 48 13763 0 13764 0 13765 2 13766 52 13767 56 13768 0
230/374

xic-ref (-target linux [basic test]): arrinit02.xi
13769 1 13770 49 13771 0 13772 0 13773 1 13774 48 13775 0 13776 0 13777 1 13778 48 13779 0 13780 0 13781 2 13782 52 13783 57 13784 0 13785 1 13786 49 13787 0 13788 0 13789 1 13790 48 13791 0 13792 0 13793 2 13794 53 13795 54 13796 0 13797 2 13798 53 13799 50 13800 0 13801 1 13802 50 13803 0 13804 0 13805 1 13806 48 13807 0 13808 0 13809 1 13810 48 13811 0 13812 0 13813 2 13814 52 13815 56 13816 0 13817 1 13818 49 13819 0 13820 0 13821 1 13822 48 13823 0 13824 0 13825 1 13826 48 13827 0 13828 0
231/374

xic-ref (-target linux [basic test]): arrinit02.xi
13829 2 13830 52 13831 56 13832 0 13833 1 13834 49 13835 0 13836 0 13837 1 13838 48 13839 0 13840 0 13841 1 13842 48 13843 0 13844 0 13845 2 13846 52 13847 57 13848 0 13849 1 13850 49 13851 0 13852 0 13853 1 13854 48 13855 0 13856 0 13857 2 13858 53 13859 54 13860 0 13861 2 13862 53 13863 50 13864 0 13865 1 13866 50 13867 0 13868 0 13869 1 13870 48 13871 0 13872 0 13873 1 13874 48 13875 0 13876 0 13877 2 13878 52 13879 56 13880 0 13881 1 13882 49 13883 0 13884 0 13885 1 13886 48 13887 0 13888 0
232/374

xic-ref (-target linux [basic test]): arrinit02.xi
13889 1 13890 48 13891 0 13892 0 13893 2 13894 52 13895 56 13896 0 13897 1 13898 49 13899 0 13900 0 13901 1 13902 48 13903 0 13904 0 13905 1 13906 48 13907 0 13908 0 13909 2 13910 52 13911 57 13912 0 13913 1 13914 49 13915 0 13916 0 13917 1 13918 48 13919 0 13920 0 13921 2 13922 53 13923 54 13924 0 13925 2 13926 53 13927 50 13928 0 13929 1 13930 50 13931 0 13932 0 13933 1 13934 48 13935 0 13936 0 13937 1 13938 48 13939 0 13940 0 13941 2 13942 52 13943 56 13944 0 13945 1 13946 49 13947 0 13948 0
233/374

xic-ref (-target linux [basic test]): arrinit02.xi
13949 1 13950 48 13951 0 13952 0 13953 1 13954 48 13955 0 13956 0 13957 2 13958 52 13959 56 13960 0 13961 1 13962 49 13963 0 13964 0 13965 1 13966 48 13967 0 13968 0 13969 1 13970 48 13971 0 13972 0 13973 2 13974 52 13975 57 13976 0 13977 1 13978 49 13979 0 13980 0 13981 1 13982 48 13983 0 13984 0 13985 2 13986 53 13987 54 13988 0 13989 2 13990 53 13991 50 13992 0 13993 1 13994 50 13995 0 13996 0 13997 1 13998 48 13999 0 14000 0 14001 1 14002 48 14003 0 14004 0 14005 2 14006 52 14007 56 14008 0
234/374

xic-ref (-target linux [basic test]): arrinit02.xi
14009 1 14010 49 14011 0 14012 0 14013 1 14014 48 14015 0 14016 0 14017 1 14018 48 14019 0 14020 0 14021 2 14022 52 14023 56 14024 0 14025 1 14026 49 14027 0 14028 0 14029 1 14030 48 14031 0 14032 0 14033 1 14034 48 14035 0 14036 0 14037 2 14038 52 14039 57 14040 0 14041 1 14042 49 14043 0 14044 0 14045 1 14046 48 14047 0 14048 0 14049 2 14050 53 14051 54 14052 0 14053 2 14054 53 14055 50 14056 0 14057 1 14058 50 14059 0 14060 0 14061 1 14062 48 14063 0 14064 0 14065 1 14066 48 14067 0 14068 0
235/374

xic-ref (-target linux [basic test]): arrinit02.xi
14069 2 14070 52 14071 56 14072 0 14073 1 14074 49 14075 0 14076 0 14077 1 14078 48 14079 0 14080 0 14081 1 14082 48 14083 0 14084 0 14085 2 14086 52 14087 56 14088 0 14089 1 14090 49 14091 0 14092 0 14093 1 14094 48 14095 0 14096 0 14097 1 14098 48 14099 0 14100 0 14101 2 14102 52 14103 57 14104 0 14105 1 14106 49 14107 0 14108 0 14109 1 14110 48 14111 0 14112 0 14113 2 14114 53 14115 54 14116 0 14117 2 14118 53 14119 50 14120 0 14121 1 14122 50 14123 0 14124 0 14125 1 14126 48 14127 0 14128 0
236/374

xic-ref (-target linux [basic test]): arrinit02.xi
14129 1 14130 48 14131 0 14132 0 14133 2 14134 52 14135 56 14136 0 14137 1 14138 49 14139 0 14140 0 14141 1 14142 48 14143 0 14144 0 14145 1 14146 48 14147 0 14148 0 14149 2 14150 52 14151 56 14152 0 14153 1 14154 49 14155 0 14156 0 14157 1 14158 48 14159 0 14160 0 14161 1 14162 48 14163 0 14164 0 14165 2 14166 52 14167 57 14168 0 14169 1 14170 49 14171 0 14172 0 14173 1 14174 48 14175 0 14176 0 14177 2 14178 53 14179 54 14180 0 14181 2 14182 53 14183 50 14184 0 14185 1 14186 50 14187 0 14188 0
237/374

xic-ref (-target linux [basic test]): arrinit02.xi
14189 1 14190 48 14191 0 14192 0 14193 1 14194 48 14195 0 14196 0 14197 2 14198 52 14199 56 14200 0 14201 1 14202 49 14203 0 14204 0 14205 1 14206 48 14207 0 14208 0 14209 1 14210 48 14211 0 14212 0 14213 2 14214 52 14215 56 14216 0 14217 1 14218 49 14219 0 14220 0 14221 1 14222 48 14223 0 14224 0 14225 1 14226 48 14227 0 14228 0 14229 2 14230 52 14231 57 14232 0 14233 1 14234 49 14235 0 14236 0 14237 1 14238 48 14239 0 14240 0 14241 2 14242 53 14243 54 14244 0 14245 2 14246 53 14247 50 14248 0
238/374

xic-ref (-target linux [basic test]): arrinit02.xi
14249 1 14250 50 14251 0 14252 0 14253 1 14254 48 14255 0 14256 0 14257 1 14258 48 14259 0 14260 0 14261 2 14262 52 14263 56 14264 0 14265 1 14266 49 14267 0 14268 0 14269 1 14270 48 14271 0 14272 0 14273 1 14274 48 14275 0 14276 0 14277 2 14278 52 14279 56 14280 0 14281 1 14282 49 14283 0 14284 0 14285 1 14286 48 14287 0 14288 0 14289 1 14290 48 14291 0 14292 0 14293 2 14294 52 14295 57 14296 0 14297 1 14298 49 14299 0 14300 0 14301 1 14302 48 14303 0 14304 0 14305 2 14306 53 14307 54 14308 0
239/374

xic-ref (-target linux [basic test]): arrinit02.xi
14309 2
14310 53 14311 50 14312 0
14313 1
14314 50 14315 0
14316 0
14317 1
14318 48 14319 0
14320 0
14321 1
14322 48 14323 0
14324 0
14325 2
14326 52 14327 56 14328 0
14329 1
14330 49 14331 0
14332 0
14333 1
14334 48 14335 0
14336 0
14337 1
14338 48 14339 0
14340 0
14341 2
14342 52 14343 56 14344 0
14345 1
14346 49 14347 0
14348 0
14349 0
14350 0
14351 0
14352 0
14353 0
14354 0
14355 1
14356 48 14357 0
14358 0
14359 0
14360 0
14361 38449152 14362 0
14363 0
14364 0
14365 0
14366 0
14367 38449248 14368 0
240/374

xic-ref (-target linux [basic test]): arrinit02.xi
14369 0
14370 0
14371 0
14372 0
14373 38449296 14374 0
14375 0
14376 0
14377 0
14378 0
14379 38449344 14380 0
14381 0
14382 0
14383 0
14384 0
14385 38449392 14386 0
14387 0
14388 0
14389 0
14390 0
14391 38449440 14392 0
14393 0
14394 0
14395 0
14396 0
14397 38449488 14398 0
14399 0
14400 0
14401 0
14402 0
14403 38449536 14404 0
14405 0
14406 0
14407 0
14408 0
14409 38449584 14410 0
14411 0
14412 0
14413 0
14414 0
14415 38449632 14416 0
14417 0
14418 0
14419 0
14420 0
14421 38449680 14422 0
14423 0
14424 0
14425 0
14426 0
14427 38449728 14428 0
241/374

xic-ref (-target linux [basic test]): arrinit02.xi
14429 0
14430 0
14431 0
14432 0
14433 38449776 14434 0
14435 0
14436 0
14437 0
14438 0
14439 38449824 14440 0
14441 0
14442 0
14443 0
14444 0
14445 38449872 14446 0
14447 0
14448 0
14449 0
14450 0
14451 38449920 14452 0
14453 0
14454 0
14455 0
14456 0
14457 38449968 14458 0
14459 0
14460 0
14461 0
14462 0
14463 38450016 14464 0
14465 0
14466 0
14467 0
14468 0
14469 38450064 14470 0
14471 0
14472 0
14473 0
14474 0
14475 38450112 14476 0
14477 0
14478 0
14479 0
14480 0
14481 38450160 14482 0
14483 0
14484 0
14485 0
14486 0
14487 38450208 14488 0
242/374

xic-ref (-target linux [basic test]): arrinit02.xi
14489 0
14490 0
14491 0
14492 0
14493 38450256 14494 0
14495 0
14496 0
14497 0
14498 0
14499 38450304 14500 0
14501 0
14502 0
14503 0
14504 0
14505 38450352 14506 0
14507 0
14508 0
14509 0
14510 0
14511 38450400 14512 0
14513 0
14514 0
14515 0
14516 0
14517 38450448 14518 0
14519 0
14520 0
14521 0
14522 0
14523 38450496 14524 0
14525 0
14526 0
14527 0
14528 0
14529 38450544 14530 0
14531 0
14532 0
14533 0
14534 0
14535 38450592 14536 0
14537 0
14538 0
14539 0
14540 0
14541 38450640 14542 0
14543 0
14544 0
14545 0
14546 0
14547 38450688 14548 0
243/374

xic-ref (-target linux [basic test]): arrinit02.xi
14549 0
14550 0
14551 0
14552 0
14553 38450736 14554 0
14555 0
14556 0
14557 0
14558 0
14559 38450784 14560 0
14561 0
14562 0
14563 0
14564 0
14565 38450832 14566 0
14567 0
14568 0
14569 0
14570 0
14571 38450880 14572 0
14573 0
14574 0
14575 0
14576 0
14577 38450928 14578 0
14579 0
14580 0
14581 0
14582 0
14583 38450976 14584 0
14585 0
14586 0
14587 0
14588 0
14589 38451024 14590 0
14591 0
14592 0
14593 0
14594 0
14595 38451072 14596 0
14597 0
14598 0
14599 0
14600 0
14601 38451120 14602 0
14603 0
14604 0
14605 0
14606 0
14607 38451168 14608 0
244/374

xic-ref (-target linux [basic test]): arrinit02.xi
14609 0
14610 0
14611 0
14612 0
14613 38451216 14614 0
14615 0
14616 0
14617 0
14618 0
14619 38451264 14620 0
14621 0
14622 0
14623 0
14624 0
14625 38451312 14626 0
14627 0
14628 0
14629 0
14630 0
14631 38451360 14632 0
14633 0
14634 0
14635 0
14636 0
14637 38451408 14638 0
14639 0
14640 0
14641 0
14642 0
14643 38451456 14644 0
14645 0
14646 0
14647 0
14648 0
14649 38451504 14650 0
14651 0
14652 0
14653 0
14654 0
14655 38451552 14656 0
14657 0
14658 0
14659 0
14660 0
14661 38451600 14662 0
14663 0
14664 0
14665 0
14666 0
14667 38451648 14668 0
245/374

xic-ref (-target linux [basic test]): arrinit02.xi
14669 0
14670 0
14671 0
14672 0
14673 38451696 14674 0
14675 0
14676 0
14677 0
14678 0
14679 38451744 14680 0
14681 0
14682 0
14683 0
14684 0
14685 38451792 14686 0
14687 0
14688 0
14689 0
14690 0
14691 38451840 14692 0
14693 0
14694 0
14695 0
14696 0
14697 38451888 14698 0
14699 0
14700 0
14701 0
14702 0
14703 38451936 14704 0
14705 0
14706 0
14707 0
14708 0
14709 38451984 14710 0
14711 0
14712 0
14713 0
14714 0
14715 38452032 14716 0
14717 0
14718 0
14719 0
14720 0
14721 38452080 14722 0
14723 0
14724 0
14725 0
14726 0
14727 38452128 14728 0
246/374

xic-ref (-target linux [basic test]): arrinit02.xi
14729 0
14730 0
14731 0
14732 0
14733 38452176 14734 0
14735 0
14736 0
14737 0
14738 0
14739 38452224 14740 0
14741 0
14742 0
14743 0
14744 0
14745 38452272 14746 0
14747 0
14748 0
14749 0
14750 0
14751 38452320 14752 0
14753 0
14754 0
14755 0
14756 0
14757 38452368 14758 0
14759 0
14760 0
14761 0
14762 0
14763 38452416 14764 0
14765 0
14766 0
14767 0
14768 0
14769 38452464 14770 0
14771 0
14772 0
14773 0
14774 0
14775 38452512 14776 0
14777 0
14778 0
14779 0
14780 0
14781 38452560 14782 0
14783 0
14784 0
14785 0
14786 0
14787 38452608 14788 0
247/374

xic-ref (-target linux [basic test]): arrinit02.xi
14789 0
14790 0
14791 0
14792 0
14793 38452656 14794 0
14795 0
14796 0
14797 0
14798 0
14799 38452704 14800 0
14801 0
14802 0
14803 0
14804 0
14805 38452752 14806 0
14807 0
14808 0
14809 0
14810 0
14811 38452800 14812 0
14813 0
14814 0
14815 0
14816 0
14817 38452848 14818 0
14819 0
14820 0
14821 0
14822 0
14823 38452896 14824 0
14825 0
14826 0
14827 0
14828 0
14829 38452944 14830 0
14831 0
14832 0
14833 0
14834 0
14835 38452992 14836 0
14837 0
14838 0
14839 0
14840 0
14841 38453040 14842 0
14843 0
14844 0
14845 0
14846 0
14847 38453088 14848 0
248/374

xic-ref (-target linux [basic test]): arrinit02.xi
14849 0 14850 0 14851 0 14852 0 14853 1 14854 50 14855 0 14856 0 14857 0 14858 0 14859 0 14860 0 14861 1 14862 48 14863 0 14864 0 14865 1 14866 48 14867 0 14868 0 14869 2 14870 52 14871 57 14872 0 14873 1 14874 49 14875 0 14876 0 14877 1 14878 48 14879 0 14880 0 14881 2 14882 53 14883 54 14884 0 14885 2 14886 53 14887 50 14888 0 14889 1 14890 50 14891 0 14892 0 14893 1 14894 48 14895 0 14896 0 14897 1 14898 48 14899 0 14900 0 14901 2 14902 52 14903 56 14904 0 14905 1 14906 49 14907 0 14908 0
249/374

xic-ref (-target linux [basic test]): arrinit02.xi
14909 1 14910 48 14911 0 14912 0 14913 1 14914 48 14915 0 14916 0 14917 2 14918 52 14919 56 14920 0 14921 1 14922 49 14923 0 14924 0 14925 1 14926 48 14927 0 14928 0 14929 1 14930 48 14931 0 14932 0 14933 2 14934 52 14935 57 14936 0 14937 1 14938 49 14939 0 14940 0 14941 1 14942 48 14943 0 14944 0 14945 2 14946 53 14947 54 14948 0 14949 2 14950 53 14951 50 14952 0 14953 1 14954 50 14955 0 14956 0 14957 1 14958 48 14959 0 14960 0 14961 1 14962 48 14963 0 14964 0 14965 2 14966 52 14967 56 14968 0
250/374

xic-ref (-target linux [basic test]): arrinit02.xi
14969 1 14970 49 14971 0 14972 0 14973 1 14974 48 14975 0 14976 0 14977 1 14978 48 14979 0 14980 0 14981 2 14982 52 14983 56 14984 0 14985 1 14986 49 14987 0 14988 0 14989 1 14990 48 14991 0 14992 0 14993 1 14994 48 14995 0 14996 0 14997 2 14998 52 14999 57 15000 0 15001 1 15002 49 15003 0 15004 0 15005 1 15006 48 15007 0 15008 0 15009 2 15010 53 15011 54 15012 0 15013 2 15014 53 15015 50 15016 0 15017 1 15018 50 15019 0 15020 0 15021 1 15022 48 15023 0 15024 0 15025 1 15026 48 15027 0 15028 0
251/374

xic-ref (-target linux [basic test]): arrinit02.xi
15029 2 15030 52 15031 56 15032 0 15033 1 15034 49 15035 0 15036 0 15037 1 15038 48 15039 0 15040 0 15041 1 15042 48 15043 0 15044 0 15045 2 15046 52 15047 56 15048 0 15049 1 15050 49 15051 0 15052 0 15053 1 15054 48 15055 0 15056 0 15057 1 15058 48 15059 0 15060 0 15061 2 15062 52 15063 57 15064 0 15065 1 15066 49 15067 0 15068 0 15069 1 15070 48 15071 0 15072 0 15073 2 15074 53 15075 54 15076 0 15077 2 15078 53 15079 50 15080 0 15081 1 15082 50 15083 0 15084 0 15085 1 15086 48 15087 0 15088 0
252/374

xic-ref (-target linux [basic test]): arrinit02.xi
15089 1 15090 48 15091 0 15092 0 15093 2 15094 52 15095 56 15096 0 15097 1 15098 49 15099 0 15100 0 15101 1 15102 48 15103 0 15104 0 15105 1 15106 48 15107 0 15108 0 15109 2 15110 52 15111 56 15112 0 15113 1 15114 49 15115 0 15116 0 15117 1 15118 48 15119 0 15120 0 15121 1 15122 48 15123 0 15124 0 15125 2 15126 52 15127 57 15128 0 15129 1 15130 49 15131 0 15132 0 15133 1 15134 48 15135 0 15136 0 15137 2 15138 53 15139 54 15140 0 15141 2 15142 53 15143 50 15144 0 15145 1 15146 50 15147 0 15148 0
253/374

xic-ref (-target linux [basic test]): arrinit02.xi
15149 1 15150 48 15151 0 15152 0 15153 1 15154 48 15155 0 15156 0 15157 2 15158 52 15159 56 15160 0 15161 1 15162 49 15163 0 15164 0 15165 1 15166 48 15167 0 15168 0 15169 1 15170 48 15171 0 15172 0 15173 2 15174 52 15175 56 15176 0 15177 1 15178 49 15179 0 15180 0 15181 1 15182 48 15183 0 15184 0 15185 1 15186 48 15187 0 15188 0 15189 2 15190 52 15191 57 15192 0 15193 1 15194 49 15195 0 15196 0 15197 1 15198 48 15199 0 15200 0 15201 2 15202 53 15203 54 15204 0 15205 2 15206 53 15207 50 15208 0
254/374

xic-ref (-target linux [basic test]): arrinit02.xi
15209 1 15210 50 15211 0 15212 0 15213 1 15214 48 15215 0 15216 0 15217 1 15218 48 15219 0 15220 0 15221 2 15222 52 15223 56 15224 0 15225 1 15226 49 15227 0 15228 0 15229 1 15230 48 15231 0 15232 0 15233 1 15234 48 15235 0 15236 0 15237 2 15238 52 15239 56 15240 0 15241 1 15242 49 15243 0 15244 0 15245 1 15246 48 15247 0 15248 0 15249 1 15250 48 15251 0 15252 0 15253 2 15254 52 15255 57 15256 0 15257 1 15258 49 15259 0 15260 0 15261 1 15262 48 15263 0 15264 0 15265 2 15266 53 15267 54 15268 0
255/374

xic-ref (-target linux [basic test]): arrinit02.xi
15269 2 15270 53 15271 50 15272 0 15273 1 15274 50 15275 0 15276 0 15277 1 15278 48 15279 0 15280 0 15281 1 15282 48 15283 0 15284 0 15285 2 15286 52 15287 56 15288 0 15289 1 15290 49 15291 0 15292 0 15293 1 15294 48 15295 0 15296 0 15297 1 15298 48 15299 0 15300 0 15301 2 15302 52 15303 56 15304 0 15305 1 15306 49 15307 0 15308 0 15309 1 15310 48 15311 0 15312 0 15313 1 15314 48 15315 0 15316 0 15317 2 15318 52 15319 57 15320 0 15321 1 15322 49 15323 0 15324 0 15325 1 15326 48 15327 0 15328 0
256/374

xic-ref (-target linux [basic test]): arrinit02.xi
15329 2 15330 53 15331 54 15332 0 15333 2 15334 53 15335 50 15336 0 15337 1 15338 50 15339 0 15340 0 15341 1 15342 48 15343 0 15344 0 15345 1 15346 48 15347 0 15348 0 15349 2 15350 52 15351 56 15352 0 15353 1 15354 49 15355 0 15356 0 15357 1 15358 48 15359 0 15360 0 15361 1 15362 48 15363 0 15364 0 15365 2 15366 52 15367 56 15368 0 15369 1 15370 49 15371 0 15372 0 15373 1 15374 48 15375 0 15376 0 15377 1 15378 48 15379 0 15380 0 15381 2 15382 52 15383 57 15384 0 15385 1 15386 49 15387 0 15388 0
257/374

xic-ref (-target linux [basic test]): arrinit02.xi
15389 1 15390 48 15391 0 15392 0 15393 2 15394 53 15395 54 15396 0 15397 2 15398 53 15399 50 15400 0 15401 1 15402 50 15403 0 15404 0 15405 1 15406 48 15407 0 15408 0 15409 1 15410 48 15411 0 15412 0 15413 2 15414 52 15415 56 15416 0 15417 1 15418 49 15419 0 15420 0 15421 1 15422 48 15423 0 15424 0 15425 1 15426 48 15427 0 15428 0 15429 2 15430 52 15431 56 15432 0 15433 1 15434 49 15435 0 15436 0 15437 1 15438 48 15439 0 15440 0 15441 1 15442 48 15443 0 15444 0 15445 2 15446 52 15447 57 15448 0
258/374

xic-ref (-target linux [basic test]): arrinit02.xi
15449 1 15450 49 15451 0 15452 0 15453 1 15454 48 15455 0 15456 0 15457 2 15458 53 15459 54 15460 0 15461 2 15462 53 15463 50 15464 0 15465 1 15466 50 15467 0 15468 0 15469 1 15470 48 15471 0 15472 0 15473 1 15474 48 15475 0 15476 0 15477 2 15478 52 15479 56 15480 0 15481 1 15482 49 15483 0 15484 0 15485 1 15486 48 15487 0 15488 0 15489 1 15490 48 15491 0 15492 0 15493 2 15494 52 15495 56 15496 0 15497 1 15498 49 15499 0 15500 0 15501 1 15502 48 15503 0 15504 0 15505 1 15506 48 15507 0 15508 0
259/374

xic-ref (-target linux [basic test]): arrinit02.xi
15509 2 15510 52 15511 57 15512 0 15513 1 15514 49 15515 0 15516 0 15517 1 15518 48 15519 0 15520 0 15521 2 15522 53 15523 54 15524 0 15525 2 15526 53 15527 50 15528 0 15529 1 15530 50 15531 0 15532 0 15533 1 15534 48 15535 0 15536 0 15537 1 15538 48 15539 0 15540 0 15541 2 15542 52 15543 56 15544 0 15545 1 15546 49 15547 0 15548 0 15549 1 15550 48 15551 0 15552 0 15553 1 15554 48 15555 0 15556 0 15557 2 15558 52 15559 56 15560 0 15561 1 15562 49 15563 0 15564 0 15565 1 15566 48 15567 0 15568 0
260/374

xic-ref (-target linux [basic test]): arrinit02.xi
15569 1 15570 48 15571 0 15572 0 15573 2 15574 52 15575 57 15576 0 15577 1 15578 49 15579 0 15580 0 15581 1 15582 48 15583 0 15584 0 15585 2 15586 53 15587 54 15588 0 15589 2 15590 53 15591 50 15592 0 15593 1 15594 50 15595 0 15596 0 15597 1 15598 48 15599 0 15600 0 15601 1 15602 48 15603 0 15604 0 15605 2 15606 52 15607 56 15608 0 15609 1 15610 49 15611 0 15612 0 15613 1 15614 48 15615 0 15616 0 15617 1 15618 48 15619 0 15620 0 15621 2 15622 52 15623 56 15624 0 15625 1 15626 49 15627 0 15628 0
261/374

xic-ref (-target linux [basic test]): arrinit02.xi
15629 1 15630 48 15631 0 15632 0 15633 1 15634 48 15635 0 15636 0 15637 2 15638 52 15639 57 15640 0 15641 1 15642 49 15643 0 15644 0 15645 1 15646 48 15647 0 15648 0 15649 2 15650 53 15651 54 15652 0 15653 2 15654 53 15655 50 15656 0 15657 1 15658 50 15659 0 15660 0 15661 1 15662 48 15663 0 15664 0 15665 1 15666 48 15667 0 15668 0 15669 2 15670 52 15671 56 15672 0 15673 1 15674 49 15675 0 15676 0 15677 1 15678 48 15679 0 15680 0 15681 1 15682 48 15683 0 15684 0 15685 2 15686 52 15687 56 15688 0
262/374

xic-ref (-target linux [basic test]): arrinit02.xi
15689 1 15690 49 15691 0 15692 0 15693 1 15694 48 15695 0 15696 0 15697 1 15698 48 15699 0 15700 0 15701 2 15702 52 15703 57 15704 0 15705 1 15706 49 15707 0 15708 0 15709 1 15710 48 15711 0 15712 0 15713 2 15714 53 15715 54 15716 0 15717 2 15718 53 15719 50 15720 0 15721 1 15722 50 15723 0 15724 0 15725 1 15726 48 15727 0 15728 0 15729 1 15730 48 15731 0 15732 0 15733 2 15734 52 15735 56 15736 0 15737 1 15738 49 15739 0 15740 0 15741 1 15742 48 15743 0 15744 0 15745 1 15746 48 15747 0 15748 0
263/374

xic-ref (-target linux [basic test]): arrinit02.xi
15749 2 15750 52 15751 56 15752 0 15753 1 15754 49 15755 0 15756 0 15757 1 15758 48 15759 0 15760 0 15761 1 15762 48 15763 0 15764 0 15765 2 15766 52 15767 57 15768 0 15769 1 15770 49 15771 0 15772 0 15773 1 15774 48 15775 0 15776 0 15777 2 15778 53 15779 54 15780 0 15781 2 15782 53 15783 50 15784 0 15785 1 15786 50 15787 0 15788 0 15789 1 15790 48 15791 0 15792 0 15793 1 15794 48 15795 0 15796 0 15797 2 15798 52 15799 56 15800 0 15801 1 15802 49 15803 0 15804 0 15805 1 15806 48 15807 0 15808 0
264/374

xic-ref (-target linux [basic test]): arrinit02.xi
15809 1 15810 48 15811 0 15812 0 15813 2 15814 52 15815 56 15816 0 15817 1 15818 49 15819 0 15820 0 15821 1 15822 48 15823 0 15824 0 15825 1 15826 48 15827 0 15828 0 15829 2 15830 52 15831 57 15832 0 15833 1 15834 49 15835 0 15836 0 15837 1 15838 48 15839 0 15840 0 15841 2 15842 53 15843 54 15844 0 15845 2 15846 53 15847 50 15848 0 15849 1 15850 50 15851 0 15852 0 15853 1 15854 48 15855 0 15856 0 15857 1 15858 48 15859 0 15860 0 15861 2 15862 52 15863 56 15864 0 15865 1 15866 49 15867 0 15868 0
265/374

xic-ref (-target linux [basic test]): arrinit02.xi
15869 1 15870 48 15871 0 15872 0 15873 1 15874 48 15875 0 15876 0 15877 2 15878 52 15879 56 15880 0 15881 1 15882 49 15883 0 15884 0 15885 1 15886 48 15887 0 15888 0 15889 1 15890 48 15891 0 15892 0 15893 2 15894 52 15895 57 15896 0 15897 1 15898 49 15899 0 15900 0 15901 1 15902 48 15903 0 15904 0 15905 2 15906 53 15907 54 15908 0 15909 2 15910 53 15911 50 15912 0 15913 1 15914 50 15915 0 15916 0 15917 1 15918 48 15919 0 15920 0 15921 1 15922 48 15923 0 15924 0 15925 2 15926 52 15927 56 15928 0
266/374

xic-ref (-target linux [basic test]): arrinit02.xi
15929 1 15930 49 15931 0 15932 0 15933 1 15934 48 15935 0 15936 0 15937 1 15938 48 15939 0 15940 0 15941 2 15942 52 15943 56 15944 0 15945 1 15946 49 15947 0 15948 0 15949 1 15950 48 15951 0 15952 0 15953 1 15954 48 15955 0 15956 0 15957 2 15958 52 15959 57 15960 0 15961 1 15962 49 15963 0 15964 0 15965 1 15966 48 15967 0 15968 0 15969 2 15970 53 15971 54 15972 0 15973 2 15974 53 15975 50 15976 0 15977 1 15978 50 15979 0 15980 0 15981 1 15982 48 15983 0 15984 0 15985 1 15986 48 15987 0 15988 0
267/374

xic-ref (-target linux [basic test]): arrinit02.xi
15989 2 15990 52 15991 56 15992 0 15993 1 15994 49 15995 0 15996 0 15997 1 15998 48 15999 0 16000 0 16001 1 16002 48 16003 0 16004 0 16005 2 16006 52 16007 56 16008 0 16009 1 16010 49 16011 0 16012 0 16013 1 16014 48 16015 0 16016 0 16017 1 16018 48 16019 0 16020 0 16021 2 16022 52 16023 57 16024 0 16025 1 16026 49 16027 0 16028 0 16029 1 16030 48 16031 0 16032 0 16033 2 16034 53 16035 54 16036 0 16037 2 16038 53 16039 50 16040 0 16041 1 16042 50 16043 0 16044 0 16045 1 16046 48 16047 0 16048 0
268/374

xic-ref (-target linux [basic test]): arrinit02.xi
16049 1 16050 48 16051 0 16052 0 16053 2 16054 52 16055 56 16056 0 16057 1 16058 49 16059 0 16060 0 16061 1 16062 48 16063 0 16064 0 16065 1 16066 48 16067 0 16068 0 16069 2 16070 52 16071 56 16072 0 16073 1 16074 49 16075 0 16076 0 16077 1 16078 48 16079 0 16080 0 16081 1 16082 48 16083 0 16084 0 16085 2 16086 52 16087 57 16088 0 16089 1 16090 49 16091 0 16092 0 16093 1 16094 48 16095 0 16096 0 16097 2 16098 53 16099 54 16100 0 16101 2 16102 53 16103 50 16104 0 16105 1 16106 50 16107 0 16108 0
269/374

xic-ref (-target linux [basic test]): arrinit02.xi
16109 1 16110 48 16111 0 16112 0 16113 1 16114 48 16115 0 16116 0 16117 2 16118 52 16119 56 16120 0 16121 1 16122 49 16123 0 16124 0 16125 1 16126 48 16127 0 16128 0 16129 1 16130 48 16131 0 16132 0 16133 2 16134 52 16135 56 16136 0 16137 1 16138 49 16139 0 16140 0 16141 1 16142 48 16143 0 16144 0 16145 1 16146 48 16147 0 16148 0 16149 2 16150 52 16151 57 16152 0 16153 1 16154 49 16155 0 16156 0 16157 1 16158 48 16159 0 16160 0 16161 2 16162 53 16163 54 16164 0 16165 2 16166 53 16167 50 16168 0
270/374

xic-ref (-target linux [basic test]): arrinit02.xi
16169 1 16170 50 16171 0 16172 0 16173 1 16174 48 16175 0 16176 0 16177 1 16178 48 16179 0 16180 0 16181 2 16182 52 16183 56 16184 0 16185 1 16186 49 16187 0 16188 0 16189 1 16190 48 16191 0 16192 0 16193 1 16194 48 16195 0 16196 0 16197 2 16198 52 16199 56 16200 0 16201 1 16202 49 16203 0 16204 0 16205 1 16206 48 16207 0 16208 0 16209 1 16210 48 16211 0 16212 0 16213 2 16214 52 16215 57 16216 0 16217 1 16218 49 16219 0 16220 0 16221 1 16222 48 16223 0 16224 0 16225 2 16226 53 16227 54 16228 0
271/374

xic-ref (-target linux [basic test]): arrinit02.xi
16229 2 16230 53 16231 50 16232 0 16233 1 16234 50 16235 0 16236 0 16237 1 16238 48 16239 0 16240 0 16241 1 16242 48 16243 0 16244 0 16245 2 16246 52 16247 56 16248 0 16249 1 16250 49 16251 0 16252 0 16253 1 16254 48 16255 0 16256 0 16257 1 16258 48 16259 0 16260 0 16261 2 16262 52 16263 56 16264 0 16265 1 16266 49 16267 0 16268 0 16269 1 16270 48 16271 0 16272 0 16273 1 16274 48 16275 0 16276 0 16277 2 16278 52 16279 57 16280 0 16281 1 16282 49 16283 0 16284 0 16285 1 16286 48 16287 0 16288 0
272/374

xic-ref (-target linux [basic test]): arrinit02.xi
16289 2 16290 53 16291 54 16292 0 16293 2 16294 53 16295 50 16296 0 16297 1 16298 50 16299 0 16300 0 16301 1 16302 48 16303 0 16304 0 16305 1 16306 48 16307 0 16308 0 16309 2 16310 52 16311 56 16312 0 16313 1 16314 49 16315 0 16316 0 16317 1 16318 48 16319 0 16320 0 16321 1 16322 48 16323 0 16324 0 16325 2 16326 52 16327 56 16328 0 16329 1 16330 49 16331 0 16332 0 16333 1 16334 48 16335 0 16336 0 16337 1 16338 48 16339 0 16340 0 16341 2 16342 52 16343 57 16344 0 16345 1 16346 49 16347 0 16348 0
273/374

xic-ref (-target linux [basic test]): arrinit02.xi
16349 1 16350 48 16351 0 16352 0 16353 2 16354 53 16355 54 16356 0 16357 2 16358 53 16359 50 16360 0 16361 1 16362 50 16363 0 16364 0 16365 1 16366 48 16367 0 16368 0 16369 1 16370 48 16371 0 16372 0 16373 2 16374 52 16375 56 16376 0 16377 1 16378 49 16379 0 16380 0 16381 1 16382 48 16383 0 16384 0 16385 1 16386 48 16387 0 16388 0 16389 2 16390 52 16391 56 16392 0 16393 1 16394 49 16395 0 16396 0 16397 1 16398 48 16399 0 16400 0 16401 1 16402 48 16403 0 16404 0 16405 2 16406 52 16407 57 16408 0
274/374

xic-ref (-target linux [basic test]): arrinit02.xi
16409 1 16410 49 16411 0 16412 0 16413 1 16414 48 16415 0 16416 0 16417 2 16418 53 16419 54 16420 0 16421 2 16422 53 16423 50 16424 0 16425 1 16426 50 16427 0 16428 0 16429 1 16430 48 16431 0 16432 0 16433 1 16434 48 16435 0 16436 0 16437 2 16438 52 16439 56 16440 0 16441 1 16442 49 16443 0 16444 0 16445 1 16446 48 16447 0 16448 0 16449 1 16450 48 16451 0 16452 0 16453 2 16454 52 16455 56 16456 0 16457 1 16458 49 16459 0 16460 0 16461 1 16462 48 16463 0 16464 0 16465 1 16466 48 16467 0 16468 0
275/374

xic-ref (-target linux [basic test]): arrinit02.xi
16469 2 16470 52 16471 57 16472 0 16473 1 16474 49 16475 0 16476 0 16477 1 16478 48 16479 0 16480 0 16481 2 16482 53 16483 54 16484 0 16485 2 16486 53 16487 50 16488 0 16489 1 16490 50 16491 0 16492 0 16493 1 16494 48 16495 0 16496 0 16497 1 16498 48 16499 0 16500 0 16501 2 16502 52 16503 56 16504 0 16505 1 16506 49 16507 0 16508 0 16509 1 16510 48 16511 0 16512 0 16513 1 16514 48 16515 0 16516 0 16517 2 16518 52 16519 56 16520 0 16521 1 16522 49 16523 0 16524 0 16525 1 16526 48 16527 0 16528 0
276/374

xic-ref (-target linux [basic test]): arrinit02.xi
16529 1 16530 48 16531 0 16532 0 16533 2 16534 52 16535 57 16536 0 16537 1 16538 49 16539 0 16540 0 16541 1 16542 48 16543 0 16544 0 16545 2 16546 53 16547 54 16548 0 16549 2 16550 53 16551 50 16552 0 16553 1 16554 50 16555 0 16556 0 16557 1 16558 48 16559 0 16560 0 16561 1 16562 48 16563 0 16564 0 16565 2 16566 52 16567 56 16568 0 16569 1 16570 49 16571 0 16572 0 16573 1 16574 48 16575 0 16576 0 16577 1 16578 48 16579 0 16580 0 16581 2 16582 52 16583 56 16584 0 16585 1 16586 49 16587 0 16588 0
277/374

xic-ref (-target linux [basic test]): arrinit02.xi
16589 1 16590 48 16591 0 16592 0 16593 1 16594 48 16595 0 16596 0 16597 2 16598 52 16599 57 16600 0 16601 1 16602 49 16603 0 16604 0 16605 1 16606 48 16607 0 16608 0 16609 2 16610 53 16611 54 16612 0 16613 2 16614 53 16615 50 16616 0 16617 1 16618 50 16619 0 16620 0 16621 1 16622 48 16623 0 16624 0 16625 1 16626 48 16627 0 16628 0 16629 2 16630 52 16631 56 16632 0 16633 1 16634 49 16635 0 16636 0 16637 1 16638 48 16639 0 16640 0 16641 1 16642 48 16643 0 16644 0 16645 2 16646 52 16647 56 16648 0
278/374

xic-ref (-target linux [basic test]): arrinit02.xi
16649 1 16650 49 16651 0 16652 0 16653 1 16654 48 16655 0 16656 0 16657 1 16658 48 16659 0 16660 0 16661 2 16662 52 16663 57 16664 0 16665 1 16666 49 16667 0 16668 0 16669 1 16670 48 16671 0 16672 0 16673 2 16674 53 16675 54 16676 0 16677 2 16678 53 16679 50 16680 0 16681 1 16682 50 16683 0 16684 0 16685 1 16686 48 16687 0 16688 0 16689 1 16690 48 16691 0 16692 0 16693 2 16694 52 16695 56 16696 0 16697 1 16698 49 16699 0 16700 0 16701 1 16702 48 16703 0 16704 0 16705 1 16706 48 16707 0 16708 0
279/374

xic-ref (-target linux [basic test]): arrinit02.xi
16709 2 16710 52 16711 56 16712 0 16713 1 16714 49 16715 0 16716 0 16717 1 16718 48 16719 0 16720 0 16721 1 16722 48 16723 0 16724 0 16725 2 16726 52 16727 57 16728 0 16729 1 16730 49 16731 0 16732 0 16733 1 16734 48 16735 0 16736 0 16737 2 16738 53 16739 54 16740 0 16741 2 16742 53 16743 50 16744 0 16745 1 16746 50 16747 0 16748 0 16749 1 16750 48 16751 0 16752 0 16753 1 16754 48 16755 0 16756 0 16757 2 16758 52 16759 56 16760 0 16761 1 16762 49 16763 0 16764 0 16765 1 16766 48 16767 0 16768 0
280/374

xic-ref (-target linux [basic test]): arrinit02.xi
16769 1 16770 48 16771 0 16772 0 16773 2 16774 52 16775 56 16776 0 16777 1 16778 49 16779 0 16780 0 16781 1 16782 48 16783 0 16784 0 16785 1 16786 48 16787 0 16788 0 16789 2 16790 52 16791 57 16792 0 16793 1 16794 49 16795 0 16796 0 16797 1 16798 48 16799 0 16800 0 16801 2 16802 53 16803 54 16804 0 16805 2 16806 53 16807 50 16808 0 16809 1 16810 50 16811 0 16812 0 16813 1 16814 48 16815 0 16816 0 16817 1 16818 48 16819 0 16820 0 16821 2 16822 52 16823 56 16824 0 16825 1 16826 49 16827 0 16828 0
281/374

xic-ref (-target linux [basic test]): arrinit02.xi
16829 1 16830 48 16831 0 16832 0 16833 1 16834 48 16835 0 16836 0 16837 2 16838 52 16839 56 16840 0 16841 1 16842 49 16843 0 16844 0 16845 1 16846 48 16847 0 16848 0 16849 1 16850 48 16851 0 16852 0 16853 2 16854 52 16855 57 16856 0 16857 1 16858 49 16859 0 16860 0 16861 1 16862 48 16863 0 16864 0 16865 2 16866 53 16867 54 16868 0 16869 2 16870 53 16871 50 16872 0 16873 1 16874 50 16875 0 16876 0 16877 1 16878 48 16879 0 16880 0 16881 1 16882 48 16883 0 16884 0 16885 2 16886 52 16887 56 16888 0
282/374

xic-ref (-target linux [basic test]): arrinit02.xi
16889 1 16890 49 16891 0 16892 0 16893 1 16894 48 16895 0 16896 0 16897 1 16898 48 16899 0 16900 0 16901 2 16902 52 16903 56 16904 0 16905 1 16906 49 16907 0 16908 0 16909 1 16910 48 16911 0 16912 0 16913 1 16914 48 16915 0 16916 0 16917 2 16918 52 16919 57 16920 0 16921 1 16922 49 16923 0 16924 0 16925 1 16926 48 16927 0 16928 0 16929 2 16930 53 16931 54 16932 0 16933 2 16934 53 16935 50 16936 0 16937 1 16938 50 16939 0 16940 0 16941 1 16942 48 16943 0 16944 0 16945 1 16946 48 16947 0 16948 0
283/374

xic-ref (-target linux [basic test]): arrinit02.xi
16949 2 16950 52 16951 56 16952 0 16953 1 16954 49 16955 0 16956 0 16957 1 16958 48 16959 0 16960 0 16961 1 16962 48 16963 0 16964 0 16965 2 16966 52 16967 56 16968 0 16969 1 16970 49 16971 0 16972 0 16973 1 16974 48 16975 0 16976 0 16977 1 16978 48 16979 0 16980 0 16981 2 16982 52 16983 57 16984 0 16985 1 16986 49 16987 0 16988 0 16989 1 16990 48 16991 0 16992 0 16993 2 16994 53 16995 54 16996 0 16997 2 16998 53 16999 50 17000 0 17001 1 17002 50 17003 0 17004 0 17005 1 17006 48 17007 0 17008 0
284/374

xic-ref (-target linux [basic test]): arrinit02.xi
17009 1 17010 48 17011 0 17012 0 17013 2 17014 52 17015 56 17016 0 17017 1 17018 49 17019 0 17020 0 17021 1 17022 48 17023 0 17024 0 17025 1 17026 48 17027 0 17028 0 17029 2 17030 52 17031 56 17032 0 17033 1 17034 49 17035 0 17036 0 17037 1 17038 48 17039 0 17040 0 17041 1 17042 48 17043 0 17044 0 17045 2 17046 52 17047 57 17048 0 17049 1 17050 49 17051 0 17052 0 17053 1 17054 48 17055 0 17056 0 17057 2 17058 53 17059 54 17060 0 17061 2 17062 53 17063 50 17064 0 17065 1 17066 50 17067 0 17068 0
285/374

xic-ref (-target linux [basic test]): arrinit02.xi
17069 1 17070 48 17071 0 17072 0 17073 1 17074 48 17075 0 17076 0 17077 2 17078 52 17079 56 17080 0 17081 1 17082 49 17083 0 17084 0 17085 1 17086 48 17087 0 17088 0 17089 1 17090 48 17091 0 17092 0 17093 2 17094 52 17095 56 17096 0 17097 1 17098 49 17099 0 17100 0 17101 1 17102 48 17103 0 17104 0 17105 1 17106 48 17107 0 17108 0 17109 2 17110 52 17111 57 17112 0 17113 1 17114 49 17115 0 17116 0 17117 1 17118 48 17119 0 17120 0 17121 2 17122 53 17123 54 17124 0 17125 2 17126 53 17127 50 17128 0
286/374

xic-ref (-target linux [basic test]): arrinit02.xi
17129 1 17130 50 17131 0 17132 0 17133 1 17134 48 17135 0 17136 0 17137 1 17138 48 17139 0 17140 0 17141 2 17142 52 17143 56 17144 0 17145 1 17146 49 17147 0 17148 0 17149 1 17150 48 17151 0 17152 0 17153 1 17154 48 17155 0 17156 0 17157 2 17158 52 17159 56 17160 0 17161 1 17162 49 17163 0 17164 0 17165 1 17166 48 17167 0 17168 0 17169 1 17170 48 17171 0 17172 0 17173 2 17174 52 17175 57 17176 0 17177 1 17178 49 17179 0 17180 0 17181 1 17182 48 17183 0 17184 0 17185 2 17186 53 17187 54 17188 0
287/374

xic-ref (-target linux [basic test]): arrinit02.xi
17189 2 17190 53 17191 50 17192 0 17193 1 17194 50 17195 0 17196 0 17197 1 17198 48 17199 0 17200 0 17201 1 17202 48 17203 0 17204 0 17205 2 17206 52 17207 56 17208 0 17209 1 17210 49 17211 0 17212 0 17213 1 17214 48 17215 0 17216 0 17217 1 17218 48 17219 0 17220 0 17221 2 17222 52 17223 56 17224 0 17225 1 17226 49 17227 0 17228 0 17229 1 17230 48 17231 0 17232 0 17233 1 17234 48 17235 0 17236 0 17237 2 17238 52 17239 57 17240 0 17241 1 17242 49 17243 0 17244 0 17245 1 17246 48 17247 0 17248 0
288/374

xic-ref (-target linux [basic test]): arrinit02.xi
17249 2 17250 53 17251 54 17252 0 17253 2 17254 53 17255 50 17256 0 17257 1 17258 50 17259 0 17260 0 17261 1 17262 48 17263 0 17264 0 17265 1 17266 48 17267 0 17268 0 17269 2 17270 52 17271 56 17272 0 17273 1 17274 49 17275 0 17276 0 17277 1 17278 48 17279 0 17280 0 17281 1 17282 48 17283 0 17284 0 17285 2 17286 52 17287 56 17288 0 17289 1 17290 49 17291 0 17292 0 17293 1 17294 48 17295 0 17296 0 17297 1 17298 48 17299 0 17300 0 17301 2 17302 52 17303 57 17304 0 17305 1 17306 49 17307 0 17308 0
289/374

xic-ref (-target linux [basic test]): arrinit02.xi
17309 1 17310 48 17311 0 17312 0 17313 2 17314 53 17315 54 17316 0 17317 2 17318 53 17319 50 17320 0 17321 1 17322 50 17323 0 17324 0 17325 1 17326 48 17327 0 17328 0 17329 1 17330 48 17331 0 17332 0 17333 2 17334 52 17335 56 17336 0 17337 1 17338 49 17339 0 17340 0 17341 1 17342 48 17343 0 17344 0 17345 1 17346 48 17347 0 17348 0 17349 2 17350 52 17351 56 17352 0 17353 1 17354 49 17355 0 17356 0 17357 1 17358 48 17359 0 17360 0 17361 1 17362 48 17363 0 17364 0 17365 2 17366 52 17367 57 17368 0
290/374

xic-ref (-target linux [basic test]): arrinit02.xi
17369 1 17370 49 17371 0 17372 0 17373 1 17374 48 17375 0 17376 0 17377 2 17378 53 17379 54 17380 0 17381 2 17382 53 17383 50 17384 0 17385 1 17386 50 17387 0 17388 0 17389 1 17390 48 17391 0 17392 0 17393 1 17394 48 17395 0 17396 0 17397 2 17398 52 17399 56 17400 0 17401 1 17402 49 17403 0 17404 0 17405 1 17406 48 17407 0 17408 0 17409 1 17410 48 17411 0 17412 0 17413 2 17414 52 17415 56 17416 0 17417 1 17418 49 17419 0 17420 0 17421 1 17422 48 17423 0 17424 0 17425 1 17426 48 17427 0 17428 0
291/374

xic-ref (-target linux [basic test]): arrinit02.xi
17429 2 17430 52 17431 57 17432 0 17433 1 17434 49 17435 0 17436 0 17437 1 17438 48 17439 0 17440 0 17441 2 17442 53 17443 55 17444 0 17445 2 17446 53 17447 50 17448 0 17449 1 17450 50 17451 0 17452 0 17453 1 17454 48 17455 0 17456 0 17457 1 17458 48 17459 0 17460 0 17461 2 17462 52 17463 56 17464 0 17465 1 17466 49 17467 0 17468 0 17469 1 17470 48 17471 0 17472 0 17473 1 17474 48 17475 0 17476 0 17477 2 17478 52 17479 56 17480 0 17481 1 17482 49 17483 0 17484 0 17485 1 17486 48 17487 0 17488 0
292/374

xic-ref (-target linux [basic test]): arrinit02.xi
17489 1 17490 48 17491 0 17492 0 17493 2 17494 52 17495 57 17496 0 17497 1 17498 49 17499 0 17500 0 17501 1 17502 48 17503 0 17504 0 17505 2 17506 53 17507 54 17508 0 17509 2 17510 53 17511 50 17512 0 17513 1 17514 50 17515 0 17516 0 17517 1 17518 48 17519 0 17520 0 17521 1 17522 48 17523 0 17524 0 17525 2 17526 52 17527 56 17528 0 17529 1 17530 49 17531 0 17532 0 17533 1 17534 48 17535 0 17536 0 17537 1 17538 48 17539 0 17540 0 17541 2 17542 52 17543 56 17544 0 17545 1 17546 49 17547 0 17548 0
293/374

xic-ref (-target linux [basic test]): arrinit02.xi
17549 1 17550 48 17551 0 17552 0 17553 1 17554 48 17555 0 17556 0 17557 2 17558 52 17559 57 17560 0 17561 1 17562 49 17563 0 17564 0 17565 1 17566 48 17567 0 17568 0 17569 2 17570 53 17571 54 17572 0 17573 2 17574 53 17575 50 17576 0 17577 1 17578 50 17579 0 17580 0 17581 1 17582 48 17583 0 17584 0 17585 1 17586 48 17587 0 17588 0 17589 2 17590 52 17591 56 17592 0 17593 1 17594 49 17595 0 17596 0 17597 1 17598 48 17599 0 17600 0 17601 1 17602 48 17603 0 17604 0 17605 2 17606 52 17607 56 17608 0
294/374

xic-ref (-target linux [basic test]): arrinit02.xi
17609 1 17610 49 17611 0 17612 0 17613 1 17614 48 17615 0 17616 0 17617 1 17618 48 17619 0 17620 0 17621 2 17622 53 17623 48 17624 0 17625 1 17626 49 17627 0 17628 0 17629 1 17630 48 17631 0 17632 0 17633 2 17634 53 17635 48 17636 0 17637 2 17638 53 17639 51 17640 0 17641 1 17642 50 17643 0 17644 0 17645 1 17646 48 17647 0 17648 0 17649 2 17650 53 17651 52 17652 0 17653 2 17654 53 17655 51 17656 0 17657 1 17658 50 17659 0 17660 0 17661 1 17662 48 17663 0 17664 0 17665 1 17666 48 17667 0 17668 0
295/374

xic-ref (-target linux [basic test]): arrinit02.xi
17669 2 17670 52 17671 56 17672 0 17673 1 17674 49 17675 0 17676 0 17677 1 17678 48 17679 0 17680 0 17681 1 17682 48 17683 0 17684 0 17685 2 17686 52 17687 57 17688 0 17689 1 17690 49 17691 0 17692 0 17693 1 17694 48 17695 0 17696 0 17697 2 17698 53 17699 55 17700 0 17701 2 17702 53 17703 50 17704 0 17705 1 17706 50 17707 0 17708 0 17709 1 17710 48 17711 0 17712 0 17713 1 17714 48 17715 0 17716 0 17717 2 17718 52 17719 56 17720 0 17721 1 17722 49 17723 0 17724 0 17725 1 17726 48 17727 0 17728 0
296/374

xic-ref (-target linux [basic test]): arrinit02.xi
17729 1 17730 48 17731 0 17732 0 17733 2 17734 52 17735 56 17736 0 17737 1 17738 49 17739 0 17740 0 17741 1 17742 48 17743 0 17744 0 17745 1 17746 48 17747 0 17748 0 17749 2 17750 52 17751 57 17752 0 17753 1 17754 49 17755 0 17756 0 17757 1 17758 48 17759 0 17760 0 17761 2 17762 53 17763 54 17764 0 17765 2 17766 53 17767 50 17768 0 17769 1 17770 50 17771 0 17772 0 17773 1 17774 48 17775 0 17776 0 17777 1 17778 48 17779 0 17780 0 17781 2 17782 52 17783 56 17784 0 17785 1 17786 49 17787 0 17788 0
297/374

xic-ref (-target linux [basic test]): arrinit02.xi
17789 1 17790 48 17791 0 17792 0 17793 1 17794 48 17795 0 17796 0 17797 2 17798 52 17799 56 17800 0 17801 1 17802 49 17803 0 17804 0 17805 1 17806 48 17807 0 17808 0 17809 1 17810 48 17811 0 17812 0 17813 2 17814 52 17815 57 17816 0 17817 1 17818 49 17819 0 17820 0 17821 1 17822 48 17823 0 17824 0 17825 2 17826 53 17827 54 17828 0 17829 2 17830 53 17831 50 17832 0 17833 1 17834 50 17835 0 17836 0 17837 1 17838 48 17839 0 17840 0 17841 1 17842 48 17843 0 17844 0 17845 2 17846 52 17847 56 17848 0
298/374

xic-ref (-target linux [basic test]): arrinit02.xi
17849 1 17850 49 17851 0 17852 0 17853 1 17854 48 17855 0 17856 0 17857 1 17858 48 17859 0 17860 0 17861 2 17862 52 17863 56 17864 0 17865 1 17866 49 17867 0 17868 0 17869 1 17870 48 17871 0 17872 0 17873 1 17874 48 17875 0 17876 0 17877 2 17878 52 17879 57 17880 0 17881 1 17882 49 17883 0 17884 0 17885 1 17886 48 17887 0 17888 0 17889 2 17890 53 17891 54 17892 0 17893 2 17894 53 17895 50 17896 0 17897 1 17898 50 17899 0 17900 0 17901 1 17902 48 17903 0 17904 0 17905 1 17906 48 17907 0 17908 0
299/374

xic-ref (-target linux [basic test]): arrinit02.xi
17909 2 17910 52 17911 56 17912 0 17913 1 17914 49 17915 0 17916 0 17917 1 17918 48 17919 0 17920 0 17921 1 17922 48 17923 0 17924 0 17925 2 17926 52 17927 56 17928 0 17929 1 17930 49 17931 0 17932 0 17933 1 17934 48 17935 0 17936 0 17937 1 17938 48 17939 0 17940 0 17941 2 17942 52 17943 57 17944 0 17945 1 17946 49 17947 0 17948 0 17949 1 17950 48 17951 0 17952 0 17953 2 17954 53 17955 55 17956 0 17957 2 17958 53 17959 50 17960 0 17961 1 17962 50 17963 0 17964 0 17965 1 17966 48 17967 0 17968 0
300/374

xic-ref (-target linux [basic test]): arrinit02.xi
17969 1 17970 48 17971 0 17972 0 17973 2 17974 52 17975 56 17976 0 17977 1 17978 49 17979 0 17980 0 17981 1 17982 48 17983 0 17984 0 17985 1 17986 48 17987 0 17988 0 17989 2 17990 52 17991 56 17992 0 17993 1 17994 49 17995 0 17996 0 17997 1 17998 48 17999 0 18000 0 18001 1 18002 48 18003 0 18004 0 18005 2 18006 52 18007 57 18008 0 18009 1 18010 49 18011 0 18012 0 18013 1 18014 48 18015 0 18016 0 18017 2 18018 53 18019 54 18020 0 18021 2 18022 53 18023 50 18024 0 18025 1 18026 50 18027 0 18028 0
301/374

xic-ref (-target linux [basic test]): arrinit02.xi
18029 1 18030 48 18031 0 18032 0 18033 1 18034 48 18035 0 18036 0 18037 2 18038 52 18039 56 18040 0 18041 1 18042 49 18043 0 18044 0 18045 1 18046 48 18047 0 18048 0 18049 1 18050 48 18051 0 18052 0 18053 2 18054 52 18055 56 18056 0 18057 1 18058 49 18059 0 18060 0 18061 1 18062 48 18063 0 18064 0 18065 1 18066 48 18067 0 18068 0 18069 2 18070 52 18071 57 18072 0 18073 1 18074 49 18075 0 18076 0 18077 1 18078 48 18079 0 18080 0 18081 2 18082 53 18083 54 18084 0 18085 2 18086 53 18087 50 18088 0
302/374

xic-ref (-target linux [basic test]): arrinit02.xi
18089 1 18090 50 18091 0 18092 0 18093 1 18094 48 18095 0 18096 0 18097 1 18098 48 18099 0 18100 0 18101 2 18102 52 18103 56 18104 0 18105 1 18106 49 18107 0 18108 0 18109 1 18110 48 18111 0 18112 0 18113 1 18114 48 18115 0 18116 0 18117 2 18118 52 18119 56 18120 0 18121 1 18122 49 18123 0 18124 0 18125 1 18126 48 18127 0 18128 0 18129 1 18130 48 18131 0 18132 0 18133 2 18134 53 18135 48 18136 0 18137 1 18138 49 18139 0 18140 0 18141 1 18142 48 18143 0 18144 0 18145 2 18146 53 18147 48 18148 0
303/374

xic-ref (-target linux [basic test]): arrinit02.xi
18149 2
18150 53 18151 51 18152 0
18153 1
18154 50 18155 0
18156 0
18157 1
18158 48 18159 0
18160 0
18161 2
18162 53 18163 52 18164 0
18165 2
18166 53 18167 51 18168 0
18169 1
18170 50 18171 0
18172 0
18173 1
18174 48 18175 0
18176 0
18177 1
18178 0
18179 0
18180 0
18181 38479776 18182 0
18183 0
18184 0
18185 38479808 18186 0
18187 0
18188 0
18189 38479840 18190 0
18191 0
18192 0
18193 38479872 18194 0
18195 0
18196 0
18197 38479904 18198 0
18199 0
18200 0
18201 38479936 18202 0
18203 0
18204 0
18205 38479968 18206 0
18207 0
18208 0
304/374

xic-ref (-target linux [basic test]): arrinit02.xi
18209 38480000 18210 0
18211 0
18212 0
18213 38480032 18214 0
18215 0
18216 0
18217 38480064 18218 0
18219 0
18220 0
18221 38480096 18222 0
18223 0
18224 0
18225 38480128 18226 0
18227 0
18228 0
18229 38480160 18230 0
18231 0
18232 0
18233 38480192 18234 0
18235 0
18236 0
18237 38480224 18238 0
18239 0
18240 0
18241 38480256 18242 0
18243 0
18244 0
18245 1 18246 48 18247 0 18248 0 18249 1 18250 48 18251 0 18252 0 18253 1 18254 48 18255 0 18256 0 18257 1 18258 48 18259 0 18260 0 18261 1 18262 48 18263 0 18264 0 18265 1 18266 48 18267 0 18268 0
305/374

xic-ref (-target linux [basic test]): arrinit02.xi
18269 1 18270 48 18271 0 18272 0 18273 1 18274 48 18275 0 18276 0 18277 1 18278 48 18279 0 18280 0 18281 1 18282 48 18283 0 18284 0 18285 1 18286 48 18287 0 18288 0 18289 1 18290 48 18291 0 18292 0 18293 1 18294 48 18295 0 18296 0 18297 1 18298 48 18299 0 18300 0 18301 1 18302 48 18303 0 18304 0 18305 1 18306 48 18307 0 18308 0 18309 1 18310 48 18311 0 18312 0 18313 1 18314 48 18315 0 18316 0 18317 1 18318 48 18319 0 18320 0 18321 1 18322 48 18323 0 18324 0 18325 1 18326 48 18327 0 18328 0
306/374

xic-ref (-target linux [basic test]): arrinit02.xi
18329 1 18330 48 18331 0 18332 0 18333 1 18334 48 18335 0 18336 0 18337 1 18338 48 18339 0 18340 0 18341 1 18342 48 18343 0 18344 0 18345 1 18346 48 18347 0 18348 0 18349 1 18350 48 18351 0 18352 0 18353 1 18354 48 18355 0 18356 0 18357 1 18358 48 18359 0 18360 0 18361 1 18362 48 18363 0 18364 0 18365 1 18366 48 18367 0 18368 0 18369 1 18370 48 18371 0 18372 0 18373 1 18374 48 18375 0 18376 0 18377 1 18378 48 18379 0 18380 0 18381 1 18382 48 18383 0 18384 0 18385 1 18386 48 18387 0 18388 0
307/374

xic-ref (-target linux [basic test]): arrinit02.xi
18389 1 18390 48 18391 0 18392 0 18393 1 18394 48 18395 0 18396 0 18397 1 18398 48 18399 0 18400 0 18401 1 18402 48 18403 0 18404 0 18405 1 18406 48 18407 0 18408 0 18409 1 18410 48 18411 0 18412 0 18413 1 18414 48 18415 0 18416 0 18417 1 18418 48 18419 0 18420 0 18421 1 18422 48 18423 0 18424 0 18425 1 18426 48 18427 0 18428 0 18429 1 18430 48 18431 0 18432 0 18433 1 18434 48 18435 0 18436 0 18437 1 18438 48 18439 0 18440 0 18441 1 18442 49 18443 0 18444 0 18445 0 18446 0 18447 0 18448 0
308/374

xic-ref (-target linux [basic test]): arrinit02.xi
18449 1 18450 48 18451 0 18452 0 18453 1 18454 48 18455 0 18456 0 18457 1 18458 48 18459 0 18460 0 18461 1 18462 48 18463 0 18464 0 18465 1 18466 48 18467 0 18468 0 18469 2 18470 52 18471 57 18472 0 18473 1 18474 49 18475 0 18476 0 18477 1 18478 48 18479 0 18480 0 18481 1 18482 48 18483 0 18484 0 18485 2 18486 52 18487 56 18488 0 18489 1 18490 49 18491 0 18492 0 18493 1 18494 48 18495 0 18496 0 18497 1 18498 48 18499 0 18500 0 18501 2 18502 52 18503 56 18504 0 18505 1 18506 49 18507 0 18508 0
309/374

xic-ref (-target linux [basic test]): arrinit02.xi
18509 1 18510 48 18511 0 18512 0 18513 1 18514 48 18515 0 18516 0 18517 2 18518 52 18519 56 18520 0 18521 1 18522 49 18523 0 18524 0 18525 1 18526 48 18527 0 18528 0 18529 1 18530 48 18531 0 18532 0 18533 2 18534 52 18535 56 18536 0 18537 1 18538 49 18539 0 18540 0 18541 1 18542 48 18543 0 18544 0 18545 1 18546 48 18547 0 18548 0 18549 2 18550 52 18551 56 18552 0 18553 1 18554 49 18555 0 18556 0 18557 1 18558 48 18559 0 18560 0 18561 1 18562 48 18563 0 18564 0 18565 2 18566 52 18567 56 18568 0
310/374

xic-ref (-target linux [basic test]): arrinit02.xi
18569 1 18570 49 18571 0 18572 0 18573 1 18574 48 18575 0 18576 0 18577 1 18578 48 18579 0 18580 0 18581 2 18582 52 18583 56 18584 0 18585 1 18586 49 18587 0 18588 0 18589 1 18590 48 18591 0 18592 0 18593 1 18594 48 18595 0 18596 0 18597 2 18598 52 18599 56 18600 0 18601 1 18602 49 18603 0 18604 0 18605 1 18606 48 18607 0 18608 0 18609 1 18610 48 18611 0 18612 0 18613 2 18614 52 18615 56 18616 0 18617 1 18618 49 18619 0 18620 0 18621 1 18622 48 18623 0 18624 0 18625 1 18626 48 18627 0 18628 0
311/374

xic-ref (-target linux [basic test]): arrinit02.xi
18629 2 18630 52 18631 56 18632 0 18633 1 18634 49 18635 0 18636 0 18637 1 18638 48 18639 0 18640 0 18641 1 18642 48 18643 0 18644 0 18645 2 18646 52 18647 56 18648 0 18649 1 18650 49 18651 0 18652 0 18653 1 18654 48 18655 0 18656 0 18657 1 18658 48 18659 0 18660 0 18661 2 18662 52 18663 56 18664 0 18665 1 18666 49 18667 0 18668 0 18669 1 18670 48 18671 0 18672 0 18673 1 18674 48 18675 0 18676 0 18677 2 18678 52 18679 56 18680 0 18681 1 18682 49 18683 0 18684 0 18685 1 18686 48 18687 0 18688 0
312/374

xic-ref (-target linux [basic test]): arrinit02.xi
18689 1 18690 48 18691 0 18692 0 18693 2 18694 52 18695 56 18696 0 18697 1 18698 49 18699 0 18700 0 18701 1 18702 48 18703 0 18704 0 18705 1 18706 48 18707 0 18708 0 18709 2 18710 52 18711 56 18712 0 18713 1 18714 49 18715 0 18716 0 18717 1 18718 48 18719 0 18720 0 18721 1 18722 48 18723 0 18724 0 18725 2 18726 52 18727 56 18728 0 18729 1 18730 49 18731 0 18732 0 18733 1 18734 48 18735 0 18736 0 18737 1 18738 48 18739 0 18740 0 18741 2 18742 52 18743 56 18744 0 18745 1 18746 49 18747 0 18748 0
313/374

xic-ref (-target linux [basic test]): arrinit02.xi
18749 1 18750 48 18751 0 18752 0 18753 1 18754 48 18755 0 18756 0 18757 2 18758 52 18759 56 18760 0 18761 1 18762 49 18763 0 18764 0 18765 1 18766 48 18767 0 18768 0 18769 1 18770 48 18771 0 18772 0 18773 2 18774 52 18775 56 18776 0 18777 1 18778 49 18779 0 18780 0 18781 1 18782 48 18783 0 18784 0 18785 1 18786 48 18787 0 18788 0 18789 2 18790 52 18791 56 18792 0 18793 1 18794 49 18795 0 18796 0 18797 1 18798 48 18799 0 18800 0 18801 1 18802 48 18803 0 18804 0 18805 2 18806 52 18807 56 18808 0
314/374

xic-ref (-target linux [basic test]): arrinit02.xi
18809 1 18810 49 18811 0 18812 0 18813 1 18814 48 18815 0 18816 0 18817 1 18818 48 18819 0 18820 0 18821 2 18822 52 18823 56 18824 0 18825 1 18826 49 18827 0 18828 0 18829 1 18830 48 18831 0 18832 0 18833 1 18834 48 18835 0 18836 0 18837 2 18838 52 18839 56 18840 0 18841 1 18842 49 18843 0 18844 0 18845 1 18846 48 18847 0 18848 0 18849 1 18850 48 18851 0 18852 0 18853 2 18854 52 18855 56 18856 0 18857 1 18858 49 18859 0 18860 0 18861 1 18862 48 18863 0 18864 0 18865 1 18866 48 18867 0 18868 0
315/374

xic-ref (-target linux [basic test]): arrinit02.xi
18869 2 18870 52 18871 56 18872 0 18873 1 18874 49 18875 0 18876 0 18877 1 18878 48 18879 0 18880 0 18881 1 18882 48 18883 0 18884 0 18885 2 18886 52 18887 56 18888 0 18889 1 18890 49 18891 0 18892 0 18893 1 18894 48 18895 0 18896 0 18897 1 18898 48 18899 0 18900 0 18901 2 18902 52 18903 56 18904 0 18905 1 18906 49 18907 0 18908 0 18909 1 18910 48 18911 0 18912 0 18913 1 18914 48 18915 0 18916 0 18917 2 18918 52 18919 56 18920 0 18921 1 18922 49 18923 0 18924 0 18925 1 18926 48 18927 0 18928 0
316/374

xic-ref (-target linux [basic test]): arrinit02.xi
18929 1 18930 48 18931 0 18932 0 18933 2 18934 52 18935 56 18936 0 18937 1 18938 49 18939 0 18940 0 18941 1 18942 48 18943 0 18944 0 18945 1 18946 48 18947 0 18948 0 18949 2 18950 52 18951 56 18952 0 18953 1 18954 49 18955 0 18956 0 18957 1 18958 48 18959 0 18960 0 18961 1 18962 48 18963 0 18964 0 18965 2 18966 52 18967 56 18968 0 18969 1 18970 49 18971 0 18972 0 18973 1 18974 48 18975 0 18976 0 18977 1 18978 48 18979 0 18980 0 18981 2 18982 52 18983 57 18984 0 18985 1 18986 49 18987 0 18988 0
317/374

xic-ref (-target linux [basic test]): arrinit02.xi
18989 1 18990 48 18991 0 18992 0 18993 2 18994 53 18995 54 18996 0 18997 2 18998 53 18999 50 19000 0 19001 1 19002 50 19003 0 19004 0 19005 1 19006 48 19007 0 19008 0 19009 1 19010 48 19011 0 19012 0 19013 2 19014 52 19015 56 19016 0 19017 1 19018 49 19019 0 19020 0 19021 1 19022 48 19023 0 19024 0 19025 1 19026 48 19027 0 19028 0 19029 2 19030 52 19031 56 19032 0 19033 1 19034 49 19035 0 19036 0 19037 1 19038 48 19039 0 19040 0 19041 1 19042 48 19043 0 19044 0 19045 2 19046 52 19047 57 19048 0
318/374

xic-ref (-target linux [basic test]): arrinit02.xi
19049 1 19050 49 19051 0 19052 0 19053 1 19054 48 19055 0 19056 0 19057 2 19058 53 19059 54 19060 0 19061 2 19062 53 19063 50 19064 0 19065 1 19066 50 19067 0 19068 0 19069 1 19070 48 19071 0 19072 0 19073 1 19074 48 19075 0 19076 0 19077 2 19078 52 19079 56 19080 0 19081 1 19082 49 19083 0 19084 0 19085 1 19086 48 19087 0 19088 0 19089 1 19090 48 19091 0 19092 0 19093 2 19094 52 19095 56 19096 0 19097 1 19098 49 19099 0 19100 0 19101 1 19102 48 19103 0 19104 0 19105 1 19106 48 19107 0 19108 0
319/374

xic-ref (-target linux [basic test]): arrinit02.xi
19109 2 19110 52 19111 57 19112 0 19113 1 19114 49 19115 0 19116 0 19117 1 19118 48 19119 0 19120 0 19121 2 19122 53 19123 54 19124 0 19125 2 19126 53 19127 50 19128 0 19129 1 19130 50 19131 0 19132 0 19133 1 19134 48 19135 0 19136 0 19137 1 19138 48 19139 0 19140 0 19141 2 19142 52 19143 56 19144 0 19145 1 19146 49 19147 0 19148 0 19149 1 19150 48 19151 0 19152 0 19153 1 19154 48 19155 0 19156 0 19157 2 19158 52 19159 56 19160 0 19161 1 19162 49 19163 0 19164 0 19165 1 19166 48 19167 0 19168 0
320/374

xic-ref (-target linux [basic test]): arrinit02.xi
19169 1 19170 48 19171 0 19172 0 19173 2 19174 52 19175 57 19176 0 19177 1 19178 49 19179 0 19180 0 19181 1 19182 48 19183 0 19184 0 19185 2 19186 53 19187 54 19188 0 19189 2 19190 53 19191 50 19192 0 19193 1 19194 50 19195 0 19196 0 19197 1 19198 48 19199 0 19200 0 19201 1 19202 48 19203 0 19204 0 19205 2 19206 52 19207 56 19208 0 19209 1 19210 49 19211 0 19212 0 19213 1 19214 48 19215 0 19216 0 19217 1 19218 48 19219 0 19220 0 19221 2 19222 52 19223 56 19224 0 19225 1 19226 49 19227 0 19228 0
321/374

xic-ref (-target linux [basic test]): arrinit02.xi
19229 1 19230 48 19231 0 19232 0 19233 1 19234 48 19235 0 19236 0 19237 2 19238 52 19239 57 19240 0 19241 1 19242 49 19243 0 19244 0 19245 1 19246 48 19247 0 19248 0 19249 2 19250 53 19251 54 19252 0 19253 2 19254 53 19255 50 19256 0 19257 1 19258 50 19259 0 19260 0 19261 1 19262 48 19263 0 19264 0 19265 1 19266 48 19267 0 19268 0 19269 2 19270 52 19271 56 19272 0 19273 1 19274 49 19275 0 19276 0 19277 1 19278 48 19279 0 19280 0 19281 1 19282 48 19283 0 19284 0 19285 2 19286 52 19287 56 19288 0
322/374

xic-ref (-target linux [basic test]): arrinit02.xi
19289 1 19290 49 19291 0 19292 0 19293 1 19294 48 19295 0 19296 0 19297 1 19298 48 19299 0 19300 0 19301 2 19302 52 19303 57 19304 0 19305 1 19306 49 19307 0 19308 0 19309 1 19310 48 19311 0 19312 0 19313 2 19314 53 19315 54 19316 0 19317 2 19318 53 19319 50 19320 0 19321 1 19322 50 19323 0 19324 0 19325 1 19326 48 19327 0 19328 0 19329 1 19330 48 19331 0 19332 0 19333 2 19334 52 19335 56 19336 0 19337 1 19338 49 19339 0 19340 0 19341 1 19342 48 19343 0 19344 0 19345 1 19346 48 19347 0 19348 0
323/374

xic-ref (-target linux [basic test]): arrinit02.xi
19349 2 19350 52 19351 56 19352 0 19353 1 19354 49 19355 0 19356 0 19357 1 19358 48 19359 0 19360 0 19361 1 19362 48 19363 0 19364 0 19365 2 19366 52 19367 57 19368 0 19369 1 19370 49 19371 0 19372 0 19373 1 19374 48 19375 0 19376 0 19377 2 19378 53 19379 55 19380 0 19381 2 19382 53 19383 50 19384 0 19385 1 19386 50 19387 0 19388 0 19389 1 19390 48 19391 0 19392 0 19393 1 19394 48 19395 0 19396 0 19397 2 19398 52 19399 56 19400 0 19401 1 19402 49 19403 0 19404 0 19405 1 19406 48 19407 0 19408 0
324/374

xic-ref (-target linux [basic test]): arrinit02.xi
19409 1 19410 48 19411 0 19412 0 19413 2 19414 52 19415 56 19416 0 19417 1 19418 49 19419 0 19420 0 19421 1 19422 48 19423 0 19424 0 19425 1 19426 48 19427 0 19428 0 19429 2 19430 52 19431 56 19432 0 19433 1 19434 49 19435 0 19436 0 19437 1 19438 48 19439 0 19440 0 19441 1 19442 48 19443 0 19444 0 19445 2 19446 52 19447 56 19448 0 19449 1 19450 49 19451 0 19452 0 19453 1 19454 48 19455 0 19456 0 19457 1 19458 48 19459 0 19460 0 19461 2 19462 52 19463 56 19464 0 19465 1 19466 49 19467 0 19468 0
325/374

xic-ref (-target linux [basic test]): arrinit02.xi
19469 1 19470 48 19471 0 19472 0 19473 1 19474 48 19475 0 19476 0 19477 2 19478 52 19479 56 19480 0 19481 1 19482 49 19483 0 19484 0 19485 1 19486 48 19487 0 19488 0 19489 1 19490 48 19491 0 19492 0 19493 2 19494 52 19495 57 19496 0 19497 1 19498 49 19499 0 19500 0 19501 1 19502 48 19503 0 19504 0 19505 2 19506 53 19507 54 19508 0 19509 2 19510 53 19511 50 19512 0 19513 1 19514 50 19515 0 19516 0 19517 1 19518 48 19519 0 19520 0 19521 1 19522 48 19523 0 19524 0 19525 2 19526 52 19527 56 19528 0
326/374

xic-ref (-target linux [basic test]): arrinit02.xi
19529 1 19530 49 19531 0 19532 0 19533 1 19534 48 19535 0 19536 0 19537 1 19538 48 19539 0 19540 0 19541 2 19542 52 19543 56 19544 0 19545 1 19546 49 19547 0 19548 0 19549 1 19550 48 19551 0 19552 0 19553 1 19554 48 19555 0 19556 0 19557 2 19558 52 19559 57 19560 0 19561 1 19562 49 19563 0 19564 0 19565 1 19566 48 19567 0 19568 0 19569 2 19570 53 19571 54 19572 0 19573 2 19574 53 19575 50 19576 0 19577 1 19578 50 19579 0 19580 0 19581 1 19582 48 19583 0 19584 0 19585 1 19586 48 19587 0 19588 0
327/374

xic-ref (-target linux [basic test]): arrinit02.xi
19589 2 19590 52 19591 56 19592 0 19593 1 19594 49 19595 0 19596 0 19597 1 19598 48 19599 0 19600 0 19601 1 19602 48 19603 0 19604 0 19605 2 19606 52 19607 56 19608 0 19609 1 19610 49 19611 0 19612 0 19613 1 19614 48 19615 0 19616 0 19617 1 19618 48 19619 0 19620 0 19621 2 19622 52 19623 57 19624 0 19625 1 19626 49 19627 0 19628 0 19629 1 19630 48 19631 0 19632 0 19633 2 19634 53 19635 54 19636 0 19637 2 19638 53 19639 50 19640 0 19641 1 19642 50 19643 0 19644 0 19645 1 19646 48 19647 0 19648 0
328/374

xic-ref (-target linux [basic test]): arrinit02.xi
19649 1 19650 48 19651 0 19652 0 19653 2 19654 52 19655 56 19656 0 19657 1 19658 49 19659 0 19660 0 19661 1 19662 48 19663 0 19664 0 19665 1 19666 48 19667 0 19668 0 19669 2 19670 52 19671 56 19672 0 19673 1 19674 49 19675 0 19676 0 19677 1 19678 48 19679 0 19680 0 19681 1 19682 48 19683 0 19684 0 19685 2 19686 52 19687 57 19688 0 19689 1 19690 49 19691 0 19692 0 19693 1 19694 48 19695 0 19696 0 19697 2 19698 53 19699 54 19700 0 19701 2 19702 53 19703 50 19704 0 19705 1 19706 50 19707 0 19708 0
329/374

xic-ref (-target linux [basic test]): arrinit02.xi
19709 1 19710 48 19711 0 19712 0 19713 1 19714 48 19715 0 19716 0 19717 2 19718 52 19719 56 19720 0 19721 1 19722 49 19723 0 19724 0 19725 1 19726 48 19727 0 19728 0 19729 1 19730 48 19731 0 19732 0 19733 2 19734 52 19735 56 19736 0 19737 1 19738 49 19739 0 19740 0 19741 1 19742 48 19743 0 19744 0 19745 1 19746 48 19747 0 19748 0 19749 2 19750 52 19751 57 19752 0 19753 1 19754 49 19755 0 19756 0 19757 1 19758 48 19759 0 19760 0 19761 2 19762 53 19763 54 19764 0 19765 2 19766 53 19767 50 19768 0
330/374

xic-ref (-target linux [basic test]): arrinit02.xi
19769 1 19770 50 19771 0 19772 0 19773 1 19774 48 19775 0 19776 0 19777 1 19778 48 19779 0 19780 0 19781 2 19782 52 19783 56 19784 0 19785 1 19786 49 19787 0 19788 0 19789 1 19790 48 19791 0 19792 0 19793 1 19794 48 19795 0 19796 0 19797 2 19798 52 19799 56 19800 0 19801 1 19802 49 19803 0 19804 0 19805 1 19806 48 19807 0 19808 0 19809 1 19810 48 19811 0 19812 0 19813 2 19814 52 19815 57 19816 0 19817 1 19818 49 19819 0 19820 0 19821 1 19822 48 19823 0 19824 0 19825 2 19826 53 19827 54 19828 0
331/374

xic-ref (-target linux [basic test]): arrinit02.xi
19829 2 19830 53 19831 50 19832 0 19833 1 19834 50 19835 0 19836 0 19837 1 19838 48 19839 0 19840 0 19841 1 19842 48 19843 0 19844 0 19845 2 19846 52 19847 56 19848 0 19849 1 19850 49 19851 0 19852 0 19853 1 19854 48 19855 0 19856 0 19857 1 19858 48 19859 0 19860 0 19861 2 19862 52 19863 56 19864 0 19865 1 19866 49 19867 0 19868 0 19869 1 19870 48 19871 0 19872 0 19873 1 19874 48 19875 0 19876 0 19877 2 19878 52 19879 57 19880 0 19881 1 19882 49 19883 0 19884 0 19885 1 19886 48 19887 0 19888 0
332/374

xic-ref (-target linux [basic test]): arrinit02.xi
19889 2 19890 53 19891 54 19892 0 19893 2 19894 53 19895 50 19896 0 19897 1 19898 50 19899 0 19900 0 19901 1 19902 48 19903 0 19904 0 19905 1 19906 48 19907 0 19908 0 19909 2 19910 52 19911 56 19912 0 19913 1 19914 49 19915 0 19916 0 19917 1 19918 48 19919 0 19920 0 19921 1 19922 48 19923 0 19924 0 19925 2 19926 52 19927 56 19928 0 19929 1 19930 49 19931 0 19932 0 19933 1 19934 48 19935 0 19936 0 19937 1 19938 48 19939 0 19940 0 19941 2 19942 52 19943 57 19944 0 19945 1 19946 49 19947 0 19948 0
333/374

xic-ref (-target linux [basic test]): arrinit02.xi
19949 1 19950 48 19951 0 19952 0 19953 2 19954 53 19955 54 19956 0 19957 2 19958 53 19959 50 19960 0 19961 1 19962 50 19963 0 19964 0 19965 1 19966 48 19967 0 19968 0 19969 1 19970 48 19971 0 19972 0 19973 2 19974 52 19975 56 19976 0 19977 1 19978 49 19979 0 19980 0 19981 1 19982 48 19983 0 19984 0 19985 1 19986 48 19987 0 19988 0 19989 2 19990 52 19991 56 19992 0 19993 1 19994 49 19995 0 19996 0 19997 1 19998 48 19999 0 20000 0 20001 1 20002 48 20003 0 20004 0 20005 2 20006 52 20007 57 20008 0
334/374

xic-ref (-target linux [basic test]): arrinit02.xi
20009 1 20010 49 20011 0 20012 0 20013 1 20014 48 20015 0 20016 0 20017 2 20018 53 20019 54 20020 0 20021 2 20022 53 20023 50 20024 0 20025 1 20026 50 20027 0 20028 0 20029 1 20030 48 20031 0 20032 0 20033 1 20034 48 20035 0 20036 0 20037 2 20038 52 20039 56 20040 0 20041 1 20042 49 20043 0 20044 0 20045 1 20046 48 20047 0 20048 0 20049 1 20050 48 20051 0 20052 0 20053 2 20054 52 20055 56 20056 0 20057 1 20058 49 20059 0 20060 0 20061 1 20062 48 20063 0 20064 0 20065 1 20066 48 20067 0 20068 0
335/374

xic-ref (-target linux [basic test]): arrinit02.xi
20069 2 20070 52 20071 57 20072 0 20073 1 20074 49 20075 0 20076 0 20077 1 20078 48 20079 0 20080 0 20081 2 20082 53 20083 54 20084 0 20085 2 20086 53 20087 50 20088 0 20089 1 20090 50 20091 0 20092 0 20093 1 20094 48 20095 0 20096 0 20097 1 20098 48 20099 0 20100 0 20101 2 20102 52 20103 56 20104 0 20105 1 20106 49 20107 0 20108 0 20109 1 20110 48 20111 0 20112 0 20113 1 20114 48 20115 0 20116 0 20117 2 20118 52 20119 56 20120 0 20121 1 20122 49 20123 0 20124 0 20125 1 20126 48 20127 0 20128 0
336/374

xic-ref (-target linux [basic test]): arrinit02.xi
20129 1 20130 48 20131 0 20132 0 20133 2 20134 52 20135 57 20136 0 20137 1 20138 49 20139 0 20140 0 20141 1 20142 48 20143 0 20144 0 20145 2 20146 53 20147 54 20148 0 20149 2 20150 53 20151 50 20152 0 20153 1 20154 50 20155 0 20156 0 20157 1 20158 48 20159 0 20160 0 20161 1 20162 48 20163 0 20164 0 20165 2 20166 52 20167 56 20168 0 20169 1 20170 49 20171 0 20172 0 20173 1 20174 48 20175 0 20176 0 20177 1 20178 48 20179 0 20180 0 20181 2 20182 52 20183 56 20184 0 20185 1 20186 49 20187 0 20188 0
337/374

xic-ref (-target linux [basic test]): arrinit02.xi
20189 1 20190 48 20191 0 20192 0 20193 1 20194 48 20195 0 20196 0 20197 2 20198 52 20199 57 20200 0 20201 1 20202 49 20203 0 20204 0 20205 1 20206 48 20207 0 20208 0 20209 2 20210 53 20211 54 20212 0 20213 2 20214 53 20215 50 20216 0 20217 1 20218 50 20219 0 20220 0 20221 1 20222 48 20223 0 20224 0 20225 1 20226 48 20227 0 20228 0 20229 2 20230 52 20231 56 20232 0 20233 1 20234 49 20235 0 20236 0 20237 1 20238 48 20239 0 20240 0 20241 1 20242 48 20243 0 20244 0 20245 2 20246 52 20247 56 20248 0
338/374

xic-ref (-target linux [basic test]): arrinit02.xi
20249 1 20250 49 20251 0 20252 0 20253 1 20254 48 20255 0 20256 0 20257 1 20258 48 20259 0 20260 0 20261 2 20262 52 20263 57 20264 0 20265 1 20266 49 20267 0 20268 0 20269 1 20270 48 20271 0 20272 0 20273 2 20274 53 20275 54 20276 0 20277 2 20278 53 20279 50 20280 0 20281 1 20282 50 20283 0 20284 0 20285 1 20286 48 20287 0 20288 0 20289 1 20290 48 20291 0 20292 0 20293 2 20294 52 20295 56 20296 0 20297 1 20298 49 20299 0 20300 0 20301 1 20302 48 20303 0 20304 0 20305 1 20306 48 20307 0 20308 0
339/374

xic-ref (-target linux [basic test]): arrinit02.xi
20309 2 20310 52 20311 56 20312 0 20313 1 20314 49 20315 0 20316 0 20317 1 20318 48 20319 0 20320 0 20321 1 20322 48 20323 0 20324 0 20325 2 20326 52 20327 57 20328 0 20329 1 20330 49 20331 0 20332 0 20333 1 20334 48 20335 0 20336 0 20337 2 20338 53 20339 54 20340 0 20341 2 20342 53 20343 50 20344 0 20345 1 20346 50 20347 0 20348 0 20349 1 20350 48 20351 0 20352 0 20353 1 20354 48 20355 0 20356 0 20357 2 20358 52 20359 56 20360 0 20361 1 20362 49 20363 0 20364 0 20365 1 20366 48 20367 0 20368 0
340/374

xic-ref (-target linux [basic test]): arrinit02.xi
20369 1 20370 48 20371 0 20372 0 20373 2 20374 52 20375 56 20376 0 20377 1 20378 49 20379 0 20380 0 20381 1 20382 48 20383 0 20384 0 20385 1 20386 48 20387 0 20388 0 20389 2 20390 52 20391 57 20392 0 20393 1 20394 49 20395 0 20396 0 20397 1 20398 48 20399 0 20400 0 20401 2 20402 53 20403 54 20404 0 20405 2 20406 53 20407 50 20408 0 20409 1 20410 50 20411 0 20412 0 20413 1 20414 48 20415 0 20416 0 20417 1 20418 48 20419 0 20420 0 20421 2 20422 52 20423 56 20424 0 20425 1 20426 49 20427 0 20428 0
341/374

xic-ref (-target linux [basic test]): arrinit02.xi
20429 1 20430 48 20431 0 20432 0 20433 1 20434 48 20435 0 20436 0 20437 2 20438 52 20439 56 20440 0 20441 1 20442 49 20443 0 20444 0 20445 1 20446 48 20447 0 20448 0 20449 1 20450 48 20451 0 20452 0 20453 2 20454 52 20455 57 20456 0 20457 1 20458 49 20459 0 20460 0 20461 1 20462 48 20463 0 20464 0 20465 2 20466 53 20467 54 20468 0 20469 2 20470 53 20471 50 20472 0 20473 1 20474 50 20475 0 20476 0 20477 1 20478 48 20479 0 20480 0 20481 1 20482 48 20483 0 20484 0 20485 2 20486 52 20487 56 20488 0
342/374

xic-ref (-target linux [basic test]): arrinit02.xi
20489 1 20490 49 20491 0 20492 0 20493 1 20494 48 20495 0 20496 0 20497 1 20498 48 20499 0 20500 0 20501 2 20502 52 20503 56 20504 0 20505 1 20506 49 20507 0 20508 0 20509 1 20510 48 20511 0 20512 0 20513 1 20514 48 20515 0 20516 0 20517 2 20518 52 20519 57 20520 0 20521 1 20522 49 20523 0 20524 0 20525 1 20526 48 20527 0 20528 0 20529 2 20530 53 20531 54 20532 0 20533 2 20534 53 20535 50 20536 0 20537 1 20538 50 20539 0 20540 0 20541 1 20542 48 20543 0 20544 0 20545 1 20546 48 20547 0 20548 0
343/374

xic-ref (-target linux [basic test]): arrinit02.xi
20549 2 20550 52 20551 56 20552 0 20553 1 20554 49 20555 0 20556 0 20557 1 20558 48 20559 0 20560 0 20561 1 20562 48 20563 0 20564 0 20565 2 20566 52 20567 56 20568 0 20569 1 20570 49 20571 0 20572 0 20573 1 20574 48 20575 0 20576 0 20577 1 20578 48 20579 0 20580 0 20581 2 20582 52 20583 57 20584 0 20585 1 20586 49 20587 0 20588 0 20589 1 20590 48 20591 0 20592 0 20593 2 20594 53 20595 54 20596 0 20597 2 20598 53 20599 50 20600 0 20601 1 20602 50 20603 0 20604 0 20605 1 20606 48 20607 0 20608 0
344/374

xic-ref (-target linux [basic test]): arrinit02.xi
20609 1 20610 48 20611 0 20612 0 20613 2 20614 52 20615 56 20616 0 20617 1 20618 49 20619 0 20620 0 20621 1 20622 48 20623 0 20624 0 20625 1 20626 48 20627 0 20628 0 20629 2 20630 52 20631 56 20632 0 20633 1 20634 49 20635 0 20636 0 20637 1 20638 48 20639 0 20640 0 20641 1 20642 48 20643 0 20644 0 20645 2 20646 52 20647 57 20648 0 20649 1 20650 49 20651 0 20652 0 20653 1 20654 48 20655 0 20656 0 20657 2 20658 53 20659 54 20660 0 20661 2 20662 53 20663 50 20664 0 20665 1 20666 50 20667 0 20668 0
345/374

xic-ref (-target linux [basic test]): arrinit02.xi
20669 1 20670 48 20671 0 20672 0 20673 1 20674 48 20675 0 20676 0 20677 2 20678 52 20679 56 20680 0 20681 1 20682 49 20683 0 20684 0 20685 1 20686 48 20687 0 20688 0 20689 1 20690 48 20691 0 20692 0 20693 2 20694 52 20695 56 20696 0 20697 1 20698 49 20699 0 20700 0 20701 1 20702 48 20703 0 20704 0 20705 1 20706 48 20707 0 20708 0 20709 2 20710 52 20711 57 20712 0 20713 1 20714 49 20715 0 20716 0 20717 1 20718 48 20719 0 20720 0 20721 2 20722 53 20723 54 20724 0 20725 2 20726 53 20727 50 20728 0
346/374

xic-ref (-target linux [basic test]): arrinit02.xi
20729 1 20730 50 20731 0 20732 0 20733 1 20734 48 20735 0 20736 0 20737 1 20738 48 20739 0 20740 0 20741 2 20742 52 20743 56 20744 0 20745 1 20746 49 20747 0 20748 0 20749 1 20750 48 20751 0 20752 0 20753 1 20754 48 20755 0 20756 0 20757 2 20758 52 20759 56 20760 0 20761 1 20762 49 20763 0 20764 0 20765 1 20766 48 20767 0 20768 0 20769 1 20770 48 20771 0 20772 0 20773 2 20774 52 20775 57 20776 0 20777 1 20778 49 20779 0 20780 0 20781 1 20782 48 20783 0 20784 0 20785 2 20786 53 20787 54 20788 0
347/374

xic-ref (-target linux [basic test]): arrinit02.xi
20789 2 20790 53 20791 50 20792 0 20793 1 20794 50 20795 0 20796 0 20797 1 20798 48 20799 0 20800 0 20801 1 20802 48 20803 0 20804 0 20805 2 20806 52 20807 56 20808 0 20809 1 20810 49 20811 0 20812 0 20813 1 20814 48 20815 0 20816 0 20817 1 20818 48 20819 0 20820 0 20821 2 20822 52 20823 56 20824 0 20825 1 20826 49 20827 0 20828 0 20829 1 20830 48 20831 0 20832 0 20833 1 20834 48 20835 0 20836 0 20837 2 20838 52 20839 57 20840 0 20841 1 20842 49 20843 0 20844 0 20845 1 20846 48 20847 0 20848 0
348/374

xic-ref (-target linux [basic test]): arrinit02.xi
20849 2 20850 53 20851 54 20852 0 20853 2 20854 53 20855 50 20856 0 20857 1 20858 50 20859 0 20860 0 20861 1 20862 48 20863 0 20864 0 20865 1 20866 48 20867 0 20868 0 20869 2 20870 52 20871 56 20872 0 20873 1 20874 49 20875 0 20876 0 20877 1 20878 48 20879 0 20880 0 20881 1 20882 48 20883 0 20884 0 20885 2 20886 52 20887 56 20888 0 20889 1 20890 49 20891 0 20892 0 20893 1 20894 48 20895 0 20896 0 20897 1 20898 48 20899 0 20900 0 20901 2 20902 52 20903 57 20904 0 20905 1 20906 49 20907 0 20908 0
349/374

xic-ref (-target linux [basic test]): arrinit02.xi
20909 1 20910 48 20911 0 20912 0 20913 2 20914 53 20915 54 20916 0 20917 2 20918 53 20919 50 20920 0 20921 1 20922 50 20923 0 20924 0 20925 1 20926 48 20927 0 20928 0 20929 1 20930 48 20931 0 20932 0 20933 2 20934 52 20935 56 20936 0 20937 1 20938 49 20939 0 20940 0 20941 1 20942 48 20943 0 20944 0 20945 1 20946 48 20947 0 20948 0 20949 2 20950 52 20951 56 20952 0 20953 1 20954 49 20955 0 20956 0 20957 1 20958 48 20959 0 20960 0 20961 1 20962 48 20963 0 20964 0 20965 2 20966 52 20967 57 20968 0
350/374

xic-ref (-target linux [basic test]): arrinit02.xi
20969 1 20970 49 20971 0 20972 0 20973 1 20974 48 20975 0 20976 0 20977 2 20978 53 20979 54 20980 0 20981 2 20982 53 20983 50 20984 0 20985 1 20986 50 20987 0 20988 0 20989 1 20990 48 20991 0 20992 0 20993 1 20994 48 20995 0 20996 0 20997 2 20998 52 20999 56 21000 0 21001 1 21002 49 21003 0 21004 0 21005 1 21006 48 21007 0 21008 0 21009 1 21010 48 21011 0 21012 0 21013 2 21014 52 21015 56 21016 0 21017 1 21018 49 21019 0 21020 0 21021 1 21022 48 21023 0 21024 0 21025 1 21026 48 21027 0 21028 0
351/374

xic-ref (-target linux [basic test]): arrinit02.xi
21029 2 21030 52 21031 57 21032 0 21033 1 21034 49 21035 0 21036 0 21037 1 21038 48 21039 0 21040 0 21041 2 21042 53 21043 54 21044 0 21045 2 21046 53 21047 50 21048 0 21049 1 21050 50 21051 0 21052 0 21053 1 21054 48 21055 0 21056 0 21057 1 21058 48 21059 0 21060 0 21061 2 21062 52 21063 56 21064 0 21065 1 21066 49 21067 0 21068 0 21069 1 21070 48 21071 0 21072 0 21073 1 21074 48 21075 0 21076 0 21077 2 21078 52 21079 56 21080 0 21081 1 21082 49 21083 0 21084 0 21085 1 21086 48 21087 0 21088 0
352/374

xic-ref (-target linux [basic test]): arrinit02.xi
21089 1 21090 48 21091 0 21092 0 21093 2 21094 53 21095 48 21096 0 21097 1 21098 49 21099 0 21100 0 21101 1 21102 48 21103 0 21104 0 21105 2 21106 53 21107 48 21108 0 21109 2 21110 53 21111 51 21112 0 21113 1 21114 50 21115 0 21116 0 21117 1 21118 48 21119 0 21120 0 21121 2 21122 53 21123 52 21124 0 21125 2 21126 53 21127 51 21128 0 21129 1 21130 50 21131 0 21132 0 21133 1 21134 48 21135 0 21136 0 21137 1 21138 48 21139 0 21140 0 21141 2 21142 52 21143 56 21144 0 21145 1 21146 49 21147 0 21148 0
353/374

xic-ref (-target linux [basic test]): arrinit02.xi
21149 1 21150 48 21151 0 21152 0 21153 1 21154 48 21155 0 21156 0 21157 2 21158 52 21159 57 21160 0 21161 1 21162 49 21163 0 21164 0 21165 1 21166 48 21167 0 21168 0 21169 2 21170 53 21171 55 21172 0 21173 2 21174 53 21175 50 21176 0 21177 1 21178 50 21179 0 21180 0 21181 1 21182 48 21183 0 21184 0 21185 1 21186 48 21187 0 21188 0 21189 2 21190 52 21191 56 21192 0 21193 1 21194 49 21195 0 21196 0 21197 1 21198 48 21199 0 21200 0 21201 1 21202 48 21203 0 21204 0 21205 2 21206 52 21207 56 21208 0
354/374

xic-ref (-target linux [basic test]): arrinit02.xi
21209 1 21210 49 21211 0 21212 0 21213 1 21214 48 21215 0 21216 0 21217 1 21218 48 21219 0 21220 0 21221 2 21222 52 21223 57 21224 0 21225 1 21226 49 21227 0 21228 0 21229 1 21230 48 21231 0 21232 0 21233 2 21234 53 21235 54 21236 0 21237 2 21238 53 21239 50 21240 0 21241 1 21242 50 21243 0 21244 0 21245 1 21246 48 21247 0 21248 0 21249 1 21250 48 21251 0 21252 0 21253 2 21254 52 21255 56 21256 0 21257 1 21258 49 21259 0 21260 0 21261 1 21262 48 21263 0 21264 0 21265 1 21266 48 21267 0 21268 0
355/374

xic-ref (-target linux [basic test]): arrinit02.xi
21269 2 21270 52 21271 56 21272 0 21273 1 21274 49 21275 0 21276 0 21277 1 21278 48 21279 0 21280 0 21281 1 21282 48 21283 0 21284 0 21285 2 21286 52 21287 57 21288 0 21289 1 21290 49 21291 0 21292 0 21293 1 21294 48 21295 0 21296 0 21297 2 21298 53 21299 54 21300 0 21301 2 21302 53 21303 50 21304 0 21305 1 21306 50 21307 0 21308 0 21309 1 21310 48 21311 0 21312 0 21313 1 21314 48 21315 0 21316 0 21317 2 21318 52 21319 56 21320 0 21321 1 21322 49 21323 0 21324 0 21325 1 21326 48 21327 0 21328 0
356/374

xic-ref (-target linux [basic test]): arrinit02.xi
21329 1 21330 48 21331 0 21332 0 21333 2 21334 52 21335 56 21336 0 21337 1 21338 49 21339 0 21340 0 21341 1 21342 48 21343 0 21344 0 21345 1 21346 48 21347 0 21348 0 21349 2 21350 53 21351 48 21352 0 21353 1 21354 49 21355 0 21356 0 21357 1 21358 48 21359 0 21360 0 21361 2 21362 53 21363 48 21364 0 21365 2 21366 53 21367 51 21368 0 21369 1 21370 50 21371 0 21372 0 21373 1 21374 48 21375 0 21376 0 21377 2 21378 53 21379 52 21380 0 21381 2 21382 53 21383 51 21384 0 21385 1 21386 50 21387 0 21388 0
357/374

xic-ref (-target linux [basic test]): arrinit02.xi
21389 1 21390 48 21391 0 21392 0 21393 1 21394 48 21395 0 21396 0 21397 2 21398 52 21399 56 21400 0 21401 1 21402 49 21403 0 21404 0 21405 1 21406 48 21407 0 21408 0 21409 1 21410 48 21411 0 21412 0 21413 2 21414 52 21415 57 21416 0 21417 1 21418 49 21419 0 21420 0 21421 1 21422 48 21423 0 21424 0 21425 2 21426 53 21427 55 21428 0 21429 2 21430 53 21431 50 21432 0 21433 1 21434 50 21435 0 21436 0 21437 1 21438 48 21439 0 21440 0 21441 1 21442 48 21443 0 21444 0 21445 2 21446 52 21447 56 21448 0
358/374

xic-ref (-target linux [basic test]): arrinit02.xi
21449 1 21450 49 21451 0 21452 0 21453 1 21454 48 21455 0 21456 0 21457 1 21458 48 21459 0 21460 0 21461 2 21462 52 21463 56 21464 0 21465 1 21466 49 21467 0 21468 0 21469 1 21470 48 21471 0 21472 0 21473 1 21474 48 21475 0 21476 0 21477 2 21478 52 21479 57 21480 0 21481 1 21482 49 21483 0 21484 0 21485 1 21486 48 21487 0 21488 0 21489 2 21490 53 21491 54 21492 0 21493 2 21494 53 21495 50 21496 0 21497 1 21498 50 21499 0 21500 0 21501 1 21502 48 21503 0 21504 0 21505 1 21506 48 21507 0 21508 0
359/374

xic-ref (-target linux [basic test]): arrinit02.xi
21509 2 21510 52 21511 56 21512 0 21513 1 21514 49 21515 0 21516 0 21517 1 21518 48 21519 0 21520 0 21521 1 21522 48 21523 0 21524 0 21525 2 21526 52 21527 56 21528 0 21529 1 21530 49 21531 0 21532 0 21533 1 21534 48 21535 0 21536 0 21537 1 21538 48 21539 0 21540 0 21541 2 21542 52 21543 57 21544 0 21545 1 21546 49 21547 0 21548 0 21549 1 21550 48 21551 0 21552 0 21553 2 21554 53 21555 54 21556 0 21557 2 21558 53 21559 50 21560 0 21561 1 21562 50 21563 0 21564 0 21565 1 21566 48 21567 0 21568 0
360/374

xic-ref (-target linux [basic test]): arrinit02.xi
21569 1 21570 48 21571 0 21572 0 21573 2 21574 52 21575 56 21576 0 21577 1 21578 49 21579 0 21580 0 21581 1 21582 48 21583 0 21584 0 21585 1 21586 48 21587 0 21588 0 21589 2 21590 52 21591 56 21592 0 21593 1 21594 49 21595 0 21596 0 21597 1 21598 48 21599 0 21600 0 21601 1 21602 48 21603 0 21604 0 21605 2 21606 53 21607 48 21608 0 21609 1 21610 49 21611 0 21612 0 21613 1 21614 48 21615 0 21616 0 21617 2 21618 53 21619 48 21620 0 21621 2 21622 53 21623 51 21624 0 21625 1 21626 50 21627 0 21628 0
361/374

xic-ref (-target linux [basic test]): arrinit02.xi
21629 1 21630 48 21631 0 21632 0 21633 2 21634 53 21635 52 21636 0 21637 2 21638 53 21639 51 21640 0 21641 1 21642 50 21643 0 21644 0 21645 1 21646 48 21647 0 21648 0 21649 1 21650 48 21651 0 21652 0 21653 2 21654 52 21655 56 21656 0 21657 1 21658 49 21659 0 21660 0 21661 1 21662 48 21663 0 21664 0 21665 1 21666 48 21667 0 21668 0 21669 2 21670 52 21671 57 21672 0 21673 1 21674 49 21675 0 21676 0 21677 1 21678 48 21679 0 21680 0 21681 2 21682 53 21683 55 21684 0 21685 2 21686 53 21687 50 21688 0
362/374

xic-ref (-target linux [basic test]): arrinit02.xi
21689 1 21690 50 21691 0 21692 0 21693 1 21694 48 21695 0 21696 0 21697 1 21698 48 21699 0 21700 0 21701 2 21702 52 21703 56 21704 0 21705 1 21706 49 21707 0 21708 0 21709 1 21710 48 21711 0 21712 0 21713 1 21714 48 21715 0 21716 0 21717 2 21718 52 21719 56 21720 0 21721 1 21722 49 21723 0 21724 0 21725 1 21726 48 21727 0 21728 0 21729 1 21730 48 21731 0 21732 0 21733 2 21734 52 21735 57 21736 0 21737 1 21738 49 21739 0 21740 0 21741 1 21742 48 21743 0 21744 0 21745 2 21746 53 21747 54 21748 0
363/374

xic-ref (-target linux [basic test]): arrinit02.xi
21749 2 21750 53 21751 50 21752 0 21753 1 21754 50 21755 0 21756 0 21757 1 21758 48 21759 0 21760 0 21761 1 21762 48 21763 0 21764 0 21765 2 21766 52 21767 56 21768 0 21769 1 21770 49 21771 0 21772 0 21773 1 21774 48 21775 0 21776 0 21777 1 21778 48 21779 0 21780 0 21781 2 21782 52 21783 56 21784 0 21785 1 21786 49 21787 0 21788 0 21789 1 21790 48 21791 0 21792 0 21793 1 21794 48 21795 0 21796 0 21797 2 21798 52 21799 57 21800 0 21801 1 21802 49 21803 0 21804 0 21805 1 21806 48 21807 0 21808 0
364/374

xic-ref (-target linux [basic test]): arrinit02.xi
21809 2 21810 53 21811 54 21812 0 21813 2 21814 53 21815 50 21816 0 21817 1 21818 50 21819 0 21820 0 21821 1 21822 48 21823 0 21824 0 21825 1 21826 48 21827 0 21828 0 21829 2 21830 52 21831 56 21832 0 21833 1 21834 49 21835 0 21836 0 21837 1 21838 48 21839 0 21840 0 21841 1 21842 48 21843 0 21844 0 21845 2 21846 52 21847 56 21848 0 21849 1 21850 49 21851 0 21852 0 21853 1 21854 48 21855 0 21856 0 21857 1 21858 48 21859 0 21860 0 21861 2 21862 53 21863 48 21864 0 21865 1 21866 49 21867 0 21868 0
365/374

xic-ref (-target linux [basic test]): arrinit02.xi
21869 1 21870 48 21871 0 21872 0 21873 2 21874 53 21875 48 21876 0 21877 2 21878 53 21879 51 21880 0 21881 1 21882 50 21883 0 21884 0 21885 1 21886 48 21887 0 21888 0 21889 2 21890 53 21891 52 21892 0 21893 2 21894 53 21895 51 21896 0 21897 1 21898 50 21899 0 21900 0 21901 1 21902 48 21903 0 21904 0 21905 1 21906 48 21907 0 21908 0 21909 2 21910 52 21911 56 21912 0 21913 1 21914 49 21915 0 21916 0 21917 1 21918 48 21919 0 21920 0 21921 1 21922 48 21923 0 21924 0 21925 2 21926 52 21927 57 21928 0
366/374

xic-ref (-target linux [basic test]): arrinit02.xi
21929 1 21930 49 21931 0 21932 0 21933 1 21934 48 21935 0 21936 0 21937 2 21938 53 21939 55 21940 0 21941 2 21942 53 21943 50 21944 0 21945 1 21946 50 21947 0 21948 0 21949 1 21950 48 21951 0 21952 0 21953 1 21954 48 21955 0 21956 0 21957 2 21958 52 21959 56 21960 0 21961 1 21962 49 21963 0 21964 0 21965 1 21966 48 21967 0 21968 0 21969 1 21970 48 21971 0 21972 0 21973 2 21974 52 21975 56 21976 0 21977 1 21978 49 21979 0 21980 0 21981 1 21982 48 21983 0 21984 0 21985 1 21986 48 21987 0 21988 0
367/374

xic-ref (-target linux [basic test]): arrinit02.xi
21989 2 21990 52 21991 57 21992 0 21993 1 21994 49 21995 0 21996 0 21997 1 21998 48 21999 0 22000 0 22001 2 22002 53 22003 54 22004 0 22005 2 22006 53 22007 50 22008 0 22009 1 22010 50 22011 0 22012 0 22013 1 22014 48 22015 0 22016 0 22017 1 22018 48 22019 0 22020 0 22021 2 22022 52 22023 56 22024 0 22025 1 22026 49 22027 0 22028 0 22029 1 22030 48 22031 0 22032 0 22033 1 22034 48 22035 0 22036 0 22037 2 22038 52 22039 56 22040 0 22041 1 22042 49 22043 0 22044 0 22045 1 22046 48 22047 0 22048 0
368/374

xic-ref (-target linux [basic test]): arrinit02.xi
22049 1 22050 48 22051 0 22052 0 22053 2 22054 52 22055 57 22056 0 22057 1 22058 49 22059 0 22060 0 22061 1 22062 48 22063 0 22064 0 22065 2 22066 53 22067 54 22068 0 22069 2 22070 53 22071 50 22072 0 22073 1 22074 50 22075 0 22076 0 22077 1 22078 48 22079 0 22080 0 22081 1 22082 48 22083 0 22084 0 22085 2 22086 52 22087 56 22088 0 22089 1 22090 49 22091 0 22092 0 22093 1 22094 48 22095 0 22096 0 22097 1 22098 48 22099 0 22100 0 22101 2 22102 52 22103 56 22104 0 22105 1 22106 49 22107 0 22108 0
369/374

xic-ref (-target linux [basic test]): arrinit02.xi
22109 1 22110 48 22111 0 22112 0 22113 1 22114 48 22115 0 22116 0 22117 2 22118 53 22119 48 22120 0 22121 1 22122 49 22123 0 22124 0 22125 1 22126 48 22127 0 22128 0 22129 2 22130 53 22131 48 22132 0 22133 2 22134 53 22135 51 22136 0 22137 1 22138 50 22139 0 22140 0 22141 1 22142 48 22143 0 22144 0 22145 2 22146 53 22147 52 22148 0 22149 2 22150 53 22151 51 22152 0 22153 1 22154 50 22155 0 22156 0 22157 1 22158 48 22159 0 22160 0 22161 1 22162 48 22163 0 22164 0 22165 2 22166 52 22167 56 22168 0
370/374

xic-ref (-target linux [basic test]): arrinit02.xi
22169 1 22170 49 22171 0 22172 0 22173 1 22174 48 22175 0 22176 0 22177 1 22178 48 22179 0 22180 0 22181 2 22182 52 22183 57 22184 0 22185 1 22186 49 22187 0 22188 0 22189 1 22190 48 22191 0 22192 0 22193 2 22194 53 22195 55 22196 0 22197 2 22198 53 22199 50 22200 0 22201 1 22202 50 22203 0 22204 0 22205 1 22206 48 22207 0 22208 0 22209 1 22210 48 22211 0 22212 0 22213 2 22214 52 22215 56 22216 0 22217 1 22218 49 22219 0 22220 0 22221 1 22222 48 22223 0 22224 0 22225 1 22226 48 22227 0 22228 0
371/374

xic-ref (-target linux [basic test]): arrinit02.xi
22229 2 22230 52 22231 56 22232 0 22233 1 22234 49 22235 0 22236 0 22237 1 22238 48 22239 0 22240 0 22241 1 22242 48 22243 0 22244 0 22245 2 22246 52 22247 57 22248 0 22249 1 22250 49 22251 0 22252 0 22253 1 22254 48 22255 0 22256 0 22257 2 22258 53 22259 54 22260 0 22261 2 22262 53 22263 50 22264 0 22265 1 22266 50 22267 0 22268 0 22269 1 22270 48 22271 0 22272 0 22273 1 22274 48 22275 0 22276 0 22277 2 22278 52 22279 56 22280 0 22281 1 22282 49 22283 0 22284 0 22285 1 22286 48 22287 0 22288 0
372/374

xic-ref (-target linux [basic test]): arrinit02.xi
22289 1 22290 48 22291 0 22292 0 22293 2 22294 52 22295 56 22296 0 22297 1 22298 49 22299 0 22300 0 22301 1 22302 48 22303 0 22304 0 22305 1 22306 48 22307 0 22308 0 22309 2 22310 52 22311 57 22312 0 22313 1 22314 49 22315 0 22316 0 22317 1 22318 48 22319 0 22320 0 22321 2 22322 53 22323 54 22324 0 22325 2 22326 53 22327 50 22328 0 22329 1 22330 50 22331 0 22332 0 22333 1 22334 48 22335 0 22336 0 22337 1 22338 48 22339 0 22340 0 22341 2 22342 52 22343 56 22344 0 22345 1 22346 49 22347 0 22348 0
373/374

xic-ref (-target linux [basic test]): arrinit02.xi
22349 1 22350 48 22351 0 22352 0 22353 1 22354 48 22355 0 22356 0 22357 2 22358 52 22359 56 22360 0 22361 1 22362 49 22363 0 22364 0 22365 1 22366 48 22367 0 22368 0 22369 1 22370 48 22371 0 22372 0 22373 2 22374 53 22375 48 22376 0 22377 1
Expected result:
./arrinit02.ssol.nml
1 f() called: 1 2 f() called: 2 3 f() called: 3 4 f() called: 4 5 f() called: 5 61
72 83 94
10 5
374/374

xic-ref (-target linux [basic test]): arrinit03.xi
xic-ref (-target linux [basic test]): arrinit03.xi
Failed to execute: arrinit03 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arrinit03.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[][] = {{1}, {2, 3}, {4, 5, 6}, {7, 8, 9, 10}} 6{
7
8
9
i: int = 0
while (i < length(a)) {
j: int = 0
while (j < length(a[i])) {
10
11
12
13 }
14 i=i+ 1 15 }
println(unparseInt(a[i][j])) j=j+ 1
16 } 17 }
Compiler's standard output:
ASM generated
Generated result:
./arrinit03.s.nml
Expected result:
./arrinit03.ssol.nml
11 22 33 44 55 66 77 88 99 10 10
1/1

xic-ref (-target linux [basic test]): arrinit04.xi
xic-ref (-target linux [basic test]): arrinit04.xi
Failed to execute: arrinit04 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arrinit04.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[][] = {{f(1)}, {f(2), f(3)}, {f(4), f(5), f(6)}, {f(7), f(8), f(9), f(10)}} 6{
7
8
9
i: int = 0
while (i < length(a)) {
j: int = 0
while (j < length(a[i])) {
10
11
12
13 }
14 i=i+ 1 15 }
println(unparseInt(a[i][j])) j=j+ 1
16 }
17 }
18
19 f(i: int): int {
20 print("f() called: ") 21 println(unparseInt(i)) 22 return i
23 }
Compiler's standard output:
ASM generated
Generated result:
./arrinit04.s.nml
Expected result:
./arrinit04.ssol.nml
1 f() called: 1 2 f() called: 2 3 f() called: 3 4 f() called: 4 5 f() called: 5 6 f() called: 6 7 f() called: 7 8 f() called: 8 9 f() called: 9 10 f() called: 10
11 1 12 2 13 3 14 4 15 5 16 6 17 7 18 8 19 9
1/2

xic-ref (-target linux [basic test]): arrinit04.xi
20 10
2/2

xic-ref (-target linux [basic test]): arrinit05.xi
xic-ref (-target linux [basic test]): arrinit05.xi
Failed to execute: arrinit05 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arrinit05.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int[] = {1, 2, 3}
6 a: int[] = {f(x, 1), f(x, 2), f(x, 3), f(x, 4), f(x, 5)}
7 i: int = 0
8 while (i < length(a)) {
9 println(unparseInt(a[i]))
10 i=i+ 1 11 }
12 }
13
14 f(x: int[], y: int): int { 15 print("f() called: ") 16 println(unparseInt(y))
17 x[0] = x[0] + 1
18 return x[0]
19 }
Compiler's standard output:
ASM generated
Generated result:
./arrinit05.s.nml
Expected result:
./arrinit05.ssol.nml
1 f() called: 1 2 f() called: 2 3 f() called: 3 4 f() called: 4 5 f() called: 5 62
73 84 95
10 6
1/1

xic-ref (-target linux [basic test]): arrinit06.xi
xic-ref (-target linux [basic test]): arrinit06.xi
Failed to execute: arrinit06 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arrinit06.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int[] = {1, 2, 3}
6 a: int[][] = {{f(x, 1)}, {f(x, 2), f(x, 3)}, {f(x, 4), f(x, 5), f(x, 6)},
7 8{ 9
{f(x, 7), f(x, 8), f(x, 9), f(x, 10)}}
i: int = 0
while (i < length(a)) {
  j: int = 0
  while (j < length(a[i])) {
println(unparseInt(a[i][j])) j=j+ 1
10
11
12
13
14
15 }
16 i=i+ 1 17 }
18 }
19 }
20
21 f(x: int[], y: int): int { 22 print("f() called: ") 23 println(unparseInt(y))
24 x[0] = x[0] + 1
25 return x[0]
26 }
Compiler's standard output:
ASM generated
Generated result:
./arrinit06.s.nml
Expected result:
./arrinit06.ssol.nml
1 f() called: 1 2 f() called: 2 3 f() called: 3 4 f() called: 4 5 f() called: 5 6 f() called: 6 7 f() called: 7 8 f() called: 8 9 f() called: 9 10 f() called: 10
11 2 12 3 13 4 14 5 15 6 16 7
1/2

xic-ref (-target linux [basic test]): arrinit06.xi
17 8 18 9 19 10 20 11
2/2

xic-ref (-target linux [basic test]): assign02.xi
xic-ref (-target linux [basic test]): assign02.xi
Mismatch detected at line 2 of file assign02.s.nml
expected: 47
found   : 9
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/assign02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int
6 x = f(47)
7 println(unparseInt(x)) 8}
9
10 f(x: int): int {
11 println("f() called")
12 return x
13 }
Compiler's standard output:
ASM generated
Generated result:
./assign02.s.nml
1 f() called 29
Expected result:
./assign02.ssol.nml
1 f() called 2 47
1/1

xic-ref (-target linux [basic test]): assign03.xi
xic-ref (-target linux [basic test]): assign03.xi
Mismatch detected at line 1 of file assign03.s.nml
expected: 3
found   : _xi_out_of_bounds called
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/assign03.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[3]
6 a[0] = 1
7 a[1] = 2
8 a[2] = 3
9 println(unparseInt(length(a)))
10 println(unparseInt(a[1])) 11 }
Compiler's standard output:
ASM generated
Generated result:
./assign03.s.nml
1 _xi_out_of_bounds called
Expected result:
./assign03.ssol.nml
13 22
1/1

xic-ref (-target linux [basic test]): assign04.xi
xic-ref (-target linux [basic test]): assign04.xi
Mismatch detected at line 1 of file assign04.s.nml
expected: f() called: 1
found   : _xi_out_of_bounds called
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/assign04.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[3]
6 a[0] = f(1)
7 a[1] = f(2)
8 a[2] = f(3)
9 println(unparseInt(length(a)))
10 println(unparseInt(a[1])) 11 }
12
13 f(x: int): int {
14 print("f() called: ") 15 println(unparseInt(x)) 16 return x
17 }
Compiler's standard output:
ASM generated
Generated result:
./assign04.s.nml
1 _xi_out_of_bounds called
Expected result:
./assign04.ssol.nml
1 f() called: 1 2 f() called: 2 3 f() called: 3 43
52
1/1

xic-ref (-target linux [basic test]): assign05.xi
xic-ref (-target linux [basic test]): assign05.xi
Mismatch detected at line 1 of file assign05.s.nml
expected: f() called: 0
found   : _xi_out_of_bounds called
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/assign05.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[3]
6 a[f(0)] = 1
7 a[f(1)] = 2
8 a[f(2)] = 3
9 println(unparseInt(length(a)))
10 println(unparseInt(a[1])) 11 }
12
13 f(x: int): int {
14 print("f() called: ") 15 println(unparseInt(x)) 16 return x
17 }
Compiler's standard output:
ASM generated
Generated result:
./assign05.s.nml
1 _xi_out_of_bounds called
Expected result:
./assign05.ssol.nml
1 f() called: 0 2 f() called: 1 3 f() called: 2 43
52
1/1

xic-ref (-target linux [basic test]): assign06.xi
xic-ref (-target linux [basic test]): assign06.xi
Mismatch detected at line 1 of file assign06.s.nml
expected: f() called: 0
found   : _xi_out_of_bounds called
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/assign06.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[3]
6 a[f(0)] = f(3)
7 a[f(1)] = f(4)
8 a[f(2)] = f(5)
9 println(unparseInt(length(a)))
10 println(unparseInt(a[1])) 11 }
12
13 f(x: int): int {
14 print("f() called: ") 15 println(unparseInt(x)) 16 return x
17 }
Compiler's standard output:
ASM generated
Generated result:
./assign06.s.nml
1 _xi_out_of_bounds called
Expected result:
./assign06.ssol.nml
1 f() called: 0 2 f() called: 3 3 f() called: 1 4 f() called: 4 5 f() called: 2 6 f() called: 5 73
84
1/1

xic-ref (-target linux [basic test]): assign07.xi
xic-ref (-target linux [basic test]): assign07.xi
Failed to execute: assign07 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/assign07.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[] = {1, 2, 3}
6 a[a[f(a, 1)]] = a[g(a, 2)]
7 println(unparseInt(a[0])) 8 println(unparseInt(a[1])) 9 println(unparseInt(a[2]))
10 }
11
12 f(a: int[], i: int): int { 13 print("f() called: ") 14 println(unparseInt(i)) 15 return i
16 }
17
18 g(a: int[], i: int): int { 19 print("g() called: ") 20 println(unparseInt(i))
21 a[i] = 47
22 return i
23 }
Compiler's standard output:
ASM generated
Generated result:
./assign07.s.nml
Expected result:
./assign07.ssol.nml
1 f() called: 1 2 g() called: 2 31
42
5 47
1/1

xic-ref (-target linux [basic test]): assign08.xi
xic-ref (-target linux [basic test]): assign08.xi
Failed to execute: assign08 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/assign08.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[] = {1, 2, 3}
6 a[f(a, 1)] = a[g(a, 2)]
7}
8
9 f(a: int[], i: int): int {
10 print("f() called: ") 11 println(unparseInt(i))
12 a[i] = 25
13 return i
14 }
15
16 g(a: int[], i: int): int { 17 print("g() called: ") 18 println(unparseInt(i))
19 a[i] = 47
20 return i
21 }
Compiler's standard output:
ASM generated
Generated result:
./assign08.s.nml
Expected result:
./assign08.ssol.nml
1 f() called: 1 2 g() called: 2
1/1

xic-ref (-target linux [basic test]): assign09.xi
xic-ref (-target linux [basic test]): assign09.xi
Mismatch detected at line 1 of file assign09.s.nml
expected: Index: 3
found   : _xi_out_of_bounds called
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/assign09.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int[] = {1, 2, 3, 4}
6 a: int[5][4]
7{ 8
9
i: int = 0
while (i < length(a)) {
10
11
12
13
14 }
15 i=i+ 1 16 }
j: int = 0
while (j < length(a[i])) {
a[i][j] j=j +
=i+ j 1
17 }
18 a[f(x,3)-f(x,2)][f(x,2)-f(x,1)] = 47 19 {
20
21
22
23
24
25
26 }
27 i=i+ 1
28 }
29 }
30 }
31
32 f(a: int[], i: int): int {
33 print("Index: ")
34 println(unparseInt(i))
35 a[i] = a[i] + 1
36 return a[i]
37 }
Compiler's standard output:
ASM generated
Generated result:
./assign09.s.nml
1 _xi_out_of_bounds called
Expected result:
./assign09.ssol.nml
1 Index: 3 2 Index: 2
i: int = 0
while (i < length(a)) {
j: int = 0
while (j < length(a[i])) {
println(unparseInt(a[i][j])) j=j+ 1
1/2

xic-ref (-target linux [basic test]): assign09.xi
3 Index: 2 4 Index: 1 50
61
72 83 91
10 2 11 47 12 4 13 2 14 3 15 4 16 5 17 3 18 4 19 5 20 6 21 4 22 5 23 6 24 7
2/2

xic-ref (-target linux [basic test]): assign10.xi
xic-ref (-target linux [basic test]): assign10.xi
Failed to execute: assign10 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/assign10.xi
1 use io
2 use conv
3
4 main(args: int[][]) { 5 a: int[5][4]
6{
7
8
9
i: int = 0
while (i < length(a)) {
j: int = 0
while (j < length(a[i])) {
10
11
12
13 }
14 i=i+ 1 15 }
=i+ j 1
a[i][j] j=j +
16 }
17 a[f(a, 4, 2)-3][f(a, 4, 2)-6] = 47 18 {
19
20
21
22
23
24
25 }
26 i=i+ 1
27 }
28 }
29 }
30
31 f(a: int[][], i: int, j: int): int { 32 print("Index: ")
33 print(unparseInt(i))
34 print(" ")
35 println(unparseInt(j))
36 a[i][j] = a[i][j] + 1
37 return a[i][j]
38 }
Compiler's standard output:
ASM generated
Generated result:
./assign10.s.nml
Expected result:
./assign10.ssol.nml
1 Index: 4 2 2 Index: 4 2 30
41
i: int = 0
while (i < length(a)) {
j: int = 0
while (j < length(a[i])) {
println(unparseInt(a[i][j])) j=j+ 1
1/2

xic-ref (-target linux [basic test]): assign10.xi
52 63 71 82 93
10 4 11 2 12 3 13 4 14 5 15 3 16 4 17 5 18 6 19 4 20 5 21 47 22 7
2/2

xic-ref (-target linux [basic test]): binary02.xi
xic-ref (-target linux [basic test]): binary02.xi
Mismatch detected at line 1 of file binary02.s.nml
expected: f() called: 1
found   : f() called: 9
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(f(1) + f(2)))
6 println(unparseInt(f(3) - f(2)))
7 println(unparseInt(f(4) * f(2)))
8 println(unparseInt(f(5) *>> f(2)))
9 println(unparseInt(f(6) / f(2)))
10 println(unparseInt(f(7) % f(2)))
11 }
12
13 f(x: int): int {
14 print("f() called: ") 15 println(unparseInt(x)) 16 return x
17 }
Compiler's standard output:
ASM generated
Generated result:
./binary02.s.nml
1 f() called: 9 2 f() called: 9 3 18
4 f() called: 9 5 f() called: 9 60
7 f() called: 9 8 f() called: 9 9 81
10 f() called: 9 11 f() called: 9 12 0
13 f() called: 9 14 f() called: 9 15 1
16 f() called: 9 17 f() called: 9 18 0
Expected result:
./binary02.ssol.nml
1 f() called: 1 2 f() called: 2 33
4 f() called: 3 5 f() called: 2
1/2

xic-ref (-target linux [basic test]): binary02.xi
61
7 f() called: 4 8 f() called: 2 98
10 f() called: 5 11 f() called: 2 12 0
13 f() called: 6 14 f() called: 2 15 3
16 f() called: 7 17 f() called: 2 18 1
2/2

xic-ref (-target linux [basic test]): binary03.xi
xic-ref (-target linux [basic test]): binary03.xi
Mismatch detected at line 2 of file binary03.s.nml
expected: 25
found   : 47
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary03.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(b2s(1 < 2))
6 println(b2s(3 <= 2))
7 println(b2s(4 > 2))
8 println(b2s(5 >= 2))
9 println(b2s(6 == 2))
10 println(b2s(7 != 2))
11 }
12
13 b2s(b: bool): int[] {
14 if (b) { return unparseInt(47) } else { return unparseInt(25) } 15 }
Compiler's standard output:
ASM generated
Generated result:
./binary03.s.nml
1 47 2 47 3 47 4 47 5 47 6 47
Expected result:
./binary03.ssol.nml
1 47 2 25 3 47 4 47 5 25 6 47
1/1

xic-ref (-target linux [basic test]): binary04.xi
xic-ref (-target linux [basic test]): binary04.xi
Mismatch detected at line 1 of file binary04.s.nml
expected: f() called: 1
found   : f() called: 9
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary04.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(b2s(f(1) < f(2)))
6 println(b2s(f(3) <= f(2)))
7 println(b2s(f(4) > f(2)))
8 println(b2s(f(5) >= f(2)))
9 println(b2s(f(6) == f(2)))
10 println(b2s(f(7) != f(2)))
11 }
12
13 f(x: int): int {
14 print("f() called: ") 15 println(unparseInt(x)) 16 return x
17 }
18
19 b2s(b: bool): int[] {
20 if (b) { return unparseInt(47) } else { return unparseInt(25) } 21 }
Compiler's standard output:
ASM generated
Generated result:
./binary04.s.nml
1 f() called: 9 2 f() called: 9 3 47
4 f() called: 9 5 f() called: 9 6 47
7 f() called: 9 8 f() called: 9 9 47
10 f() called: 9 11 f() called: 9 12 47
13 f() called: 9 14 f() called: 9 15 47
16 f() called: 9 17 f() called: 9 18 47
Expected result:
./binary04.ssol.nml
1 f() called: 1
1/2

xic-ref (-target linux [basic test]): binary04.xi
2 f() called: 2 3 47
4 f() called: 3 5 f() called: 2 6 25
7 f() called: 4 8 f() called: 2 9 47
10 f() called: 5 11 f() called: 2 12 47
13 f() called: 6 14 f() called: 2 15 25
16 f() called: 7 17 f() called: 2 18 47
2/2

xic-ref (-target linux [basic test]): binary05.xi
xic-ref (-target linux [basic test]): binary05.xi
Mismatch detected at line 2 of file binary05.s.nml
expected: 0
found   : 1
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary05.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(b2s(true == true))
6 println(b2s(true == false))
7 println(b2s(false == true))
8 println(b2s(false == false))
9 println(b2s(true != true))
10 println(b2s(true != false))
11 println(b2s(false != true))
12 println(b2s(false != false))
13 println(b2s(true & true))
14 println(b2s(true & false))
15 println(b2s(false & true))
16 println(b2s(false & false))
17 println(b2s(true | true))
18 println(b2s(true | false))
19 println(b2s(false | true))
20 println(b2s(false | false))
21 }
22
23 b2s(b: bool): int[] {
24 if (b) { return unparseInt(1) } else { return unparseInt(0) } 25 }
Compiler's standard output:
ASM generated
Generated result:
./binary05.s.nml
11 21 31 41 51 61 71 81 91
10 1 11 1 12 1 13 1 14 1 15 1 16 1
Expected result:
1/2

xic-ref (-target linux [basic test]): binary05.xi
./binary05.ssol.nml
11 20 30 41 50 61 71 80 91
10 0 11 0 12 0 13 1 14 1 15 1 16 0
2/2

xic-ref (-target linux [basic test]): binary06.xi
xic-ref (-target linux [basic test]): binary06.xi
Mismatch detected at line 5 of file binary06.s.nml
expected: f() called: 0
found   : f() called: 1
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary06.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(b2s(f(true) == f(true)))
6 println(b2s(f(true) == f(false)))
7 println(b2s(f(false) == f(true)))
8 println(b2s(f(false) == f(false)))
9 println(b2s(f(true) != f(true)))
10 println(b2s(f(true) != f(false)))
11 println(b2s(f(false) != f(true)))
12 println(b2s(f(false) != f(false)))
13 println(b2s(f(true) & f(true)))
14 println(b2s(f(true) & f(false)))
15 println(b2s(f(false) & f(true)))
16 println(b2s(f(false) & f(false)))
17 println(b2s(f(true) | f(true)))
18 println(b2s(f(true) | f(false)))
19 println(b2s(f(false) | f(true)))
20 println(b2s(f(false) | f(false)))
21 }
22
23 f(x: bool): bool {
24 print("f() called: ")
25 println(b2s(x))
26 return x
27 }
28
29 b2s(b: bool): int[] {
30 if (b) { return unparseInt(1) } else { return unparseInt(0) } 31 }
Compiler's standard output:
ASM generated
Generated result:
./binary06.s.nml
1 f() called: 1 2 f() called: 1 31
4 f() called: 1 5 f() called: 1 61
7 f() called: 1 8 f() called: 1 91
10 f() called: 1 11 f() called: 1 12 1
1/3

xic-ref (-target linux [basic test]): binary06.xi
13 f() called: 1 14 f() called: 1 15 1
16 f() called: 1 17 f() called: 1 18 1
19 f() called: 1 20 f() called: 1 21 1
22 f() called: 1 23 f() called: 1 24 1
25 f() called: 1 26 f() called: 1 27 1
28 f() called: 1 29 f() called: 1 30 1
31 f() called: 1 32 f() called: 1 33 1
34 f() called: 1 35 f() called: 1 36 1
37 f() called: 1 38 1
39 f() called: 1 40 1
41 f() called: 1 42 1
43 f() called: 1 44 1
Expected result:
./binary06.ssol.nml
1 f() called: 1 2 f() called: 1 31
4 f() called: 1 5 f() called: 0 60
7 f() called: 0 8 f() called: 1 90
10 f() called: 0 11 f() called: 0 12 1
13 f() called: 1 14 f() called: 1 15 0
16 f() called: 1 17 f() called: 0 18 1
19 f() called: 0 20 f() called: 1 21 1
22 f() called: 0 23 f() called: 0 24 0
25 f() called: 1
2/3

xic-ref (-target linux [basic test]): binary06.xi
26 f() called: 1 27 1
28 f() called: 1 29 f() called: 0 30 0
31 f() called: 0 32 0
33 f() called: 0 34 0
35 f() called: 1 36 1
37 f() called: 1 38 1
39 f() called: 0 40 f() called: 1 41 1
42 f() called: 0 43 f() called: 0 44 0
3/3

xic-ref (-target linux [basic test]): binary07.xi
xic-ref (-target linux [basic test]): binary07.xi
Mismatch detected at line 1 of file binary07.s.nml
expected: 1
found   : 0
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary07.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a1: int[] = {1, 2, 3}
6 a2: int[] = a1
7 a3: int[] = {1, 2, 3}
8 println(b2s(a1 == a2))
9 println(b2s(a1 != a2))
10 println(b2s(a1 == a3))
11 println(b2s(a1 != a3))
12 println(b2s(a2 == a3))
13 println(b2s(a2 != a3))
14 }
15
16 b2s(b: bool): int[] {
17 if (b) { return unparseInt(1) } else { return unparseInt(0) } 18 }
Compiler's standard output:
ASM generated
Generated result:
./binary07.s.nml
10 20 30 40 50 60
Expected result:
./binary07.ssol.nml
11 20 30 41 50 61
1/1

xic-ref (-target linux [basic test]): binary08.xi
xic-ref (-target linux [basic test]): binary08.xi
Failed to execute: binary08 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary08.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a1: int[] = {1, 2, 3}
6 a2: int[] = a1
7 a3: int[] = {1, 2, 3}
8 println(b2s(f(a1) == f(a2)))
9 println(b2s(f(a1) != f(a2)))
10 println(b2s(f(a1) == f(a3)))
11 println(b2s(f(a1) != f(a3)))
12 println(b2s(f(a2) == f(a3)))
13 println(b2s(f(a2) != f(a3)))
14 }
15
16 f(x: int[]): int[] {
17 print("f() called: ")
18 printai(x)
19 return x
20 }
21
22 printai(a: int[]) {
23 i: int = 0
24 print("{")
25 while (i < length(a)) {
26 if (i > 0) print(", ")
27 print(unparseInt(a[i]))
28 i=i+ 1
29 }
30 println("}")
31 }
32
33 b2s(b: bool): int[] {
34 if (b) { return unparseInt(1) } else { return unparseInt(0) } 35 }
Compiler's standard output:
ASM generated
Generated result:
./binary08.s.nml
Expected result:
./binary08.ssol.nml
1 f() called: {1, 2, 3} 2 f() called: {1, 2, 3} 31
4 f() called: {1, 2, 3} 5 f() called: {1, 2, 3} 60
7 f() called: {1, 2, 3}
1/2

xic-ref (-target linux [basic test]): binary08.xi
8 f() called: {1, 2, 3}
90
10 f() called: {1, 2, 3} 11 f() called: {1, 2, 3} 12 1
13 f() called: {1, 2, 3} 14 f() called: {1, 2, 3} 15 0
16 f() called: {1, 2, 3} 17 f() called: {1, 2, 3} 18 1
2/2

xic-ref (-target linux [basic test]): binary09.xi
xic-ref (-target linux [basic test]): binary09.xi
Failed to execute: binary09 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary09.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a1: int[] = {1, 2, 3, 4}
6 a2: int[] = {5, 6, 7}
7 a3: int[] = {}
8 printai(a1 + a2)
9 printai(a1 + a3)
10 printai(a2 + a3)
11 }
12
13 printai(a: int[]) { 14 i: int = 0
15 print("{")
16 while (i < length(a)) { 17 if (i > 0) print(", ") 18 print(unparseInt(a[i])) 19 i=i+ 1
20 }
21 println("}")
22 }
Compiler's standard output:
ASM generated
Generated result:
./binary09.s.nml
Expected result:
./binary09.ssol.nml
1 {1, 2, 3, 4, 5, 6, 7} 2 {1, 2, 3, 4}
3 {5, 6, 7}
1/1

xic-ref (-target linux [basic test]): binary10.xi
xic-ref (-target linux [basic test]): binary10.xi
Failed to execute: binary10 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary10.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a1: int[] = {1, 2, 3, 4}
6 a2: int[] = {5, 6, 7}
7 a3: int[] = {}
8 printai(f(a1) + f(a2))
9 printai(f(a1) + f(a3))
10 printai(f(a2) + f(a3))
11 }
12
13 f(x: int[]): int[] {
14 print("f() called: ") 15 printai(x)
16 return x
17 }
18
19 printai(a: int[]) {
20 i: int = 0
21 print("{")
22 while (i < length(a)) { 23 if (i > 0) print(", ") 24 print(unparseInt(a[i])) 25 i=i+ 1
26 }
27 println("}")
28 }
Compiler's standard output:
ASM generated
Generated result:
./binary10.s.nml
Expected result:
./binary10.ssol.nml
1 f() called: {1, 2, 3, 4} 2 f() called: {5, 6, 7}
3 {1, 2, 3, 4, 5, 6, 7}
4 f() called: {1, 2, 3, 4} 5 f() called: {}
6 {1, 2, 3, 4}
7 f() called: {5, 6, 7} 8 f() called: {}
9 {5, 6, 7}
1/1

xic-ref (-target linux [basic test]): binary11.xi
xic-ref (-target linux [basic test]): binary11.xi
Failed to execute: binary11 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary11.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int[] = {1, 2, 3}
6 println(unparseInt(f(x, 1) + f(x, 2)))
7 println(unparseInt(f(x, 3) - f(x, 2)))
8 println(unparseInt(f(x, 4) * f(x, 2)))
9 println(unparseInt(f(x, 5) *>> f(x, 2)))
10 println(unparseInt(f(x, 6) / f(x, 2)))
11 println(unparseInt(f(x, 7) % f(x, 2)))
12 println(b2s(f(x, 1) < f(x, 2)))
13 println(b2s(f(x, 3) <= f(x, 2)))
14 println(b2s(f(x, 4) > f(x, 2)))
15 println(b2s(f(x, 5) >= f(x, 2)))
16 println(b2s(f(x, 6) == f(x, 2)))
17 println(b2s(f(x, 7) != f(x, 2)))
18 }
19
20 f(x: int[], y: int): int { 21 print("f() called: ")
22 println(unparseInt(x[0])) 23 println(unparseInt(y))
24 x[0] = x[0] + 1
25 return x[0]
26 }
27
28 b2s(b: bool): int[] {
29 if (b) { return "true" } else { return "false" } 30 }
Compiler's standard output:
ASM generated
Generated result:
./binary11.s.nml
Expected result:
./binary11.ssol.nml
1 f() called: 1 21
3 f() called: 2 42
55
6 f() called: 3 73
8 f() called: 4 92
10 -1
11 f() called: 5 12 4
1/2

xic-ref (-target linux [basic test]): binary11.xi
13 f() called: 6 14 2
15 42
16 f() called: 7 17 5
18 f() called: 8 19 2
20 0
21 f() called: 9 22 6
23 f() called: 10 24 2
25 0
26 f() called: 11 27 7
28 f() called: 12 29 2
30 12
31 f() called: 13 32 1
33 f() called: 14 34 2
35 true
36 f() called: 15 37 3
38 f() called: 16 39 2
40 true
41 f() called: 17 42 4
43 f() called: 18 44 2
45 false
46 f() called: 19 47 5
48 f() called: 20 49 2
50 false
51 f() called: 21 52 6
53 f() called: 22 54 2
55 false
56 f() called: 23 57 7
58 f() called: 24 59 2
60 true
2/2

xic-ref (-target linux [basic test]): binary12.xi
xic-ref (-target linux [basic test]): binary12.xi
Failed to execute: binary12 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary12.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: bool[] = {true, false}
6 println(b2s(f(x, true) == f(x, true)))
7 println(b2s(f(x, true) == f(x, false)))
8 println(b2s(f(x, false) == f(x, true)))
9 println(b2s(f(x, false) == f(x, false)))
10 println(b2s(f(x, true) != f(x, true)))
11 println(b2s(f(x, true) != f(x, false)))
12 println(b2s(f(x, false) != f(x, true)))
13 println(b2s(f(x, false) != f(x, false)))
14 println(b2s(f(x, true) & f(x, true)))
15 println(b2s(f(x, true) & f(x, false)))
16 println(b2s(f(x, false) & f(x, true)))
17 println(b2s(f(x, false) & f(x, false)))
18 println(b2s(f(x, true) | f(x, true)))
19 println(b2s(f(x, true) | f(x, false)))
20 println(b2s(f(x, false) | f(x, true)))
21 println(b2s(f(x, false) | f(x, false)))
22 }
23
24 f(x: bool[], y: bool): bool { 25 print("f() called: ")
26 println(b2s(x[0]))
27 println(b2s(y))
28 x[0] = !x[0]
29 return x[0]
30 }
31
32 b2s(b: bool): int[] {
33 if (b) { return unparseInt(1) } else { return unparseInt(0) } 34 }
Compiler's standard output:
ASM generated
Generated result:
./binary12.s.nml
Expected result:
./binary12.ssol.nml
1 f() called: 1 21
3 f() called: 0 41
50
6 f() called: 1 71
8 f() called: 0
1/3

xic-ref (-target linux [basic test]): binary12.xi
90 10 0
11 f() called: 1 12 0
13 f() called: 0 14 1
15 0
16 f() called: 1 17 0
18 f() called: 0 19 0
20 0
21 f() called: 1 22 1
23 f() called: 0 24 1
25 1
26 f() called: 1 27 1
28 f() called: 0 29 0
30 1
31 f() called: 1 32 0
33 f() called: 0 34 1
35 1
36 f() called: 1 37 0
38 f() called: 0 39 0
40 1
41 f() called: 1 42 1
43 0
44 f() called: 0 45 1
46 f() called: 1 47 0
48 0
49 f() called: 0 50 0
51 f() called: 1 52 1
53 0
54 f() called: 0 55 0
56 f() called: 1 57 0
58 0
59 f() called: 0 60 1
61 1
62 f() called: 1 63 1
64 f() called: 0 65 0
66 1
67 f() called: 1 68 0
2/3

xic-ref (-target linux [basic test]): binary12.xi
69 f() called: 0 70 1
71 1
72 f() called: 1 73 0
74 f() called: 0 75 0
76 1
3/3

xic-ref (-target linux [basic test]): functioncall01.xi
xic-ref (-target linux [basic test]): functioncall01.xi
Failed to execute: functioncall01 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/functioncall01.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(f(0, 1))) 6}
7
8 f(x: int, y: int): int {
9 print("f() called: ")
10 println(unparseInt(y)) 11 return x + 1
12 }
Compiler's standard output:
ASM generated
Generated result:
./functioncall01.s.nml
Expected result:
./functioncall01.ssol.nml
1 f() called: 1 21
1/1

xic-ref (-target linux [basic test]): functioncall02.xi
xic-ref (-target linux [basic test]): functioncall02.xi
Failed to execute: functioncall02 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/functioncall02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(f(f(f(f(f(f(f(0, 1), 2), 3), 4), 5), 6), 7))) 6}
7
8 f(x: int, y: int): int {
9 print("f() called: ")
10 println(unparseInt(y)) 11 return x + 1
12 }
Compiler's standard output:
ASM generated
Generated result:
./functioncall02.s.nml
Expected result:
./functioncall02.ssol.nml
1 f() called: 1 2 f() called: 2 3 f() called: 3 4 f() called: 4 5 f() called: 5 6 f() called: 6 7 f() called: 7 87
1/1

xic-ref (-target linux [basic test]): functioncall03.xi
xic-ref (-target linux [basic test]): functioncall03.xi
Mismatch detected at line 1 of file functioncall03.s.nml
expected: f() called: 1
found   : f() called: 15
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/functioncall03.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(g(f(1), f(2), f(3), f(4), f(5), f(6)))) 6}
7
8 f(x: int): int {
9 print("f() called: ")
10 println(unparseInt(x)) 11 return x
12 }
13
14 g(x1: int, x2: int, x3: int, x4: int, x5: int, x6: int): int { 15 print("g() called: ")
16 print(unparseInt(x1))
17 print(" ")
18 print(unparseInt(x2)) 19 print(" ")
20 print(unparseInt(x3)) 21 print(" ")
22 print(unparseInt(x4)) 23 print(" ")
24 print(unparseInt(x5)) 25 print(" ")
26 print(unparseInt(x6))
27 println("")
28 return x1 + x2 + x3 + x4 + x5 + x6 29 }
Compiler's standard output:
ASM generated
Generated result:
./functioncall03.s.nml
1 f() called: 15
2 f() called: 15
3 f() called: 15
4 f() called: 15
5 f() called: 15
6 f() called: 15
7 g() called: 15 15 15 15 15 15 8 90
Expected result:
./functioncall03.ssol.nml
1 f() called: 1 2 f() called: 2
1/2

xic-ref (-target linux [basic test]): functioncall03.xi
3 f() called: 3
4 f() called: 4
5 f() called: 5
6 f() called: 6
7 g() called: 1 2 3 4 5 6 8 21
2/2

xic-ref (-target linux [basic test]): functioncall04.xi
xic-ref (-target linux [basic test]): functioncall04.xi
Failed to execute: functioncall04 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/functioncall04.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int[] = {1, 2, 3}
6 println(unparseInt(g(f(x, 1), f(x, 2), f(x, 3), f(x, 4), f(x, 5), f(x, 6))))
7}
8
9 f(x: int[], y: int): int {
10 print("f() called: ") 11 println(unparseInt(y))
12 x[0] = x[0] + 1
13 return x[0]
14 }
15
16 g(x1: int, x2: int, x3: int, x4: int, x5: int, x6: int): int { 17 print("g() called: ")
18 print(unparseInt(x1))
19 print(" ")
20 print(unparseInt(x2))
21 print(" ")
22 print(unparseInt(x3))
23 print(" ")
24 print(unparseInt(x4))
25 print(" ")
26 print(unparseInt(x5))
27 print(" ")
28 print(unparseInt(x6))
29 println("")
30 return x1 + x2 + x3 + x4 + x5 + x6
31 }
Compiler's standard output:
ASM generated
Generated result:
./functioncall04.s.nml
Expected result:
./functioncall04.ssol.nml
1 f() called: 1
2 f() called: 2
3 f() called: 3
4 f() called: 4
5 f() called: 5
6 f() called: 6
7 g() called: 2 3 4 5 6 7 8 27
1/1

xic-ref (-target linux [basic test]): if05.xi
xic-ref (-target linux [basic test]): if05.xi
Failed to execute: if05 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/if05.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 if (lt(0, 0)) println("true")
6 if (lt(0, -1)) println("true")
7 if (lt(0, 1)) println("true")
8 println("printed") 9}
10
11 lt(x: int, y: int): bool { 12 print("lt() called: ") 13 print(unparseInt(x))
14 print(" < ")
15 println(unparseInt(y)) 16 return x < y
17 }
Compiler's standard output:
ASM generated
Generated result:
./if05.s.nml
Expected result:
./if05.ssol.nml
1 lt() called: 0 < 0 2 lt() called: 0 < -1 3 lt() called: 0 < 1 4 true
5 printed
1/1

xic-ref (-target linux [basic test]): if06.xi
xic-ref (-target linux [basic test]): if06.xi
Failed to execute: if06 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/if06.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 if (lt(0, 0)) println("true") else println("false")
6 if (lt(0, -1)) println("true") else println("false")
7 if (lt(0, 1)) println("true") else println("false")
8 println("printed") 9}
10
11 lt(x: int, y: int): bool { 12 print("lt() called: ") 13 print(unparseInt(x))
14 print(" < ")
15 println(unparseInt(y)) 16 return x < y
17 }
Compiler's standard output:
ASM generated
Generated result:
./if06.s.nml
Expected result:
./if06.ssol.nml
1 lt() called: 0 < 0 2 false
3 lt() called: 0 < -1 4 false
5 lt() called: 0 < 1 6 true
7 printed
1/1

xic-ref (-target linux [basic test]): if07.xi
xic-ref (-target linux [basic test]): if07.xi
Failed to execute: if07 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/if07.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 if (lt(0, 0) & lt(0, 0)) println("true")
6 if (lt(0, 0) & lt(0, -1)) println("true")
7 if (lt(0, 0) & lt(0, 1)) println("true")
8 if (lt(0, -1) & lt(0, 0)) println("true")
9 if (lt(0, -1) & lt(0, -1)) println("true")
10 if (lt(0, -1) & lt(0, 1)) println("true")
11 if (lt(0, 1) & lt(0, 0)) println("true")
12 if (lt(0, 1) & lt(0, -1)) println("true")
13 if (lt(0, 1) & lt(0, 1)) println("true")
14 println("printed")
15 }
16
17 lt(x: int, y: int): bool { 18 print("lt() called: ") 19 print(unparseInt(x))
20 print(" < ")
21 println(unparseInt(y)) 22 return x < y
23 }
Compiler's standard output:
ASM generated
Generated result:
./if07.s.nml
Expected result:
./if07.ssol.nml
1 lt() called: 0 < 0 2 lt() called: 0 < 0 3 lt() called: 0 < 0 4 lt() called: 0 < -1 5 lt() called: 0 < -1 6 lt() called: 0 < -1 7 lt() called: 0 < 1 8 lt() called: 0 < 0 9 lt() called: 0 < 1 10 lt() called: 0 < -1
11 lt() called: 0 < 1 12 lt() called: 0 < 1 13 true
14 printed
1/1

xic-ref (-target linux [basic test]): if08.xi
xic-ref (-target linux [basic test]): if08.xi
Failed to execute: if08 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/if08.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 if (lt(0, 0) & lt(0, 0)) println("true") else println("false")
6 if (lt(0, 0) & lt(0, -1)) println("true") else println("false")
7 if (lt(0, 0) & lt(0, 1)) println("true") else println("false")
8 if (lt(0, -1) & lt(0, 0)) println("true") else println("false")
9 if (lt(0, -1) & lt(0, -1)) println("true") else println("false")
10 if (lt(0, -1) & lt(0, 1)) println("true") else println("false")
11 if (lt(0, 1) & lt(0, 0)) println("true") else println("false")
12 if (lt(0, 1) & lt(0, -1)) println("true") else println("false")
13 if (lt(0, 1) & lt(0, 1)) println("true") else println("false")
14 println("printed")
15 }
16
17 lt(x: int, y: int): bool { 18 print("lt() called: ") 19 print(unparseInt(x))
20 print(" < ")
21 println(unparseInt(y)) 22 return x < y
23 }
Compiler's standard output:
ASM generated
Generated result:
./if08.s.nml
Expected result:
./if08.ssol.nml
1 lt() called: 0 < 0 2 false
3 lt() called: 0 < 0 4 false
5 lt() called: 0 < 0 6 false
7 lt() called: 0 < -1 8 false
9 lt() called: 0 < -1 10 false
11 lt() called: 0 < -1 12 false
13 lt() called: 0 < 1 14 lt() called: 0 < 0 15 false
16 lt() called: 0 < 1 17 lt() called: 0 < -1 18 false
19 lt() called: 0 < 1
1/2

xic-ref (-target linux [basic test]): if08.xi
20 lt() called: 0 < 1 21 true
22 printed
2/2

xic-ref (-target linux [basic test]): if09.xi
xic-ref (-target linux [basic test]): if09.xi
Failed to execute: if09 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/if09.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 if (lt(0, 0) | lt(0, 0)) println("true")
6 if (lt(0, 0) | lt(0, -1)) println("true")
7 if (lt(0, 0) | lt(0, 1)) println("true")
8 if (lt(0, -1) | lt(0, 0)) println("true")
9 if (lt(0, -1) | lt(0, -1)) println("true")
10 if (lt(0, -1) | lt(0, 1)) println("true")
11 if (lt(0, 1) | lt(0, 0)) println("true")
12 if (lt(0, 1) | lt(0, -1)) println("true")
13 if (lt(0, 1) | lt(0, 1)) println("true")
14 println("printed")
15 }
16
17 lt(x: int, y: int): bool { 18 print("lt() called: ") 19 print(unparseInt(x))
20 print(" < ")
21 println(unparseInt(y)) 22 return x < y
23 }
Compiler's standard output:
ASM generated
Generated result:
./if09.s.nml
Expected result:
./if09.ssol.nml
1 lt() called: 0 < 0 2 lt() called: 0 < 0 3 lt() called: 0 < 0 4 lt() called: 0 < -1 5 lt() called: 0 < 0 6 lt() called: 0 < 1 7 true
8 lt() called: 0 < -1
9 lt() called: 0 < 0 10 lt() called: 0 < -1 11 lt() called: 0 < -1 12 lt() called: 0 < -1 13 lt() called: 0 < 1 14 true
15 lt() called: 0 < 1 16 true
17 lt() called: 0 < 1 18 true
19 lt() called: 0 < 1
1/2

xic-ref (-target linux [basic test]): if09.xi
20 true 21 printed
2/2

xic-ref (-target linux [basic test]): if10.xi
xic-ref (-target linux [basic test]): if10.xi
Failed to execute: if10 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/if10.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 if (lt(0, 0) | lt(0, 0)) println("true") else println("false")
6 if (lt(0, 0) | lt(0, -1)) println("true") else println("false")
7 if (lt(0, 0) | lt(0, 1)) println("true") else println("false")
8 if (lt(0, -1) | lt(0, 0)) println("true") else println("false")
9 if (lt(0, -1) | lt(0, -1)) println("true") else println("false")
10 if (lt(0, -1) | lt(0, 1)) println("true") else println("false")
11 if (lt(0, 1) | lt(0, 0)) println("true") else println("false")
12 if (lt(0, 1) | lt(0, -1)) println("true") else println("false")
13 if (lt(0, 1) | lt(0, 1)) println("true") else println("false")
14 println("printed")
15 }
16
17 lt(x: int, y: int): bool { 18 print("lt() called: ") 19 print(unparseInt(x))
20 print(" < ")
21 println(unparseInt(y)) 22 return x < y
23 }
Compiler's standard output:
ASM generated
Generated result:
./if10.s.nml
Expected result:
./if10.ssol.nml
1 lt() called: 0 < 0 2 lt() called: 0 < 0 3 false
4 lt() called: 0 < 0 5 lt() called: 0 < -1 6 false
7 lt() called: 0 < 0 8 lt() called: 0 < 1 9 true
10 lt() called: 0 < -1 11 lt() called: 0 < 0 12 false
13 lt() called: 0 < -1 14 lt() called: 0 < -1 15 false
16 lt() called: 0 < -1 17 lt() called: 0 < 1 18 true
19 lt() called: 0 < 1
1/2

xic-ref (-target linux [basic test]): if10.xi
20 true
21 lt() called: 0 < 1 22 true
23 lt() called: 0 < 1 24 true
25 printed
2/2

xic-ref (-target linux [basic test]): length01.xi
xic-ref (-target linux [basic test]): length01.xi
Mismatch detected at line 1 of file length01.s.nml
expected: 5
found   : 0
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/length01.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[] = {1, 2, 3, 4, 5}
6 println(unparseInt(length(a))) 7}
Compiler's standard output:
ASM generated
Generated result:
./length01.s.nml
10
Expected result:
./length01.ssol.nml
15
1/1

xic-ref (-target linux [basic test]): length02.xi
xic-ref (-target linux [basic test]): length02.xi
Failed to execute: length02 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/length02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[][] = {{1}, {2, 3}, {4, 5, 6}, {7, 8, 9, 10}} 6 println(unparseInt(length(a)))
7{
8
9
10
11
12 } 13 } 14 }
println(unparseInt(length(a[i]))) i=i+ 1
i: int = 0
while (i < length(a)) {
Compiler's standard output:
ASM generated
Generated result:
./length02.s.nml
Expected result:
./length02.ssol.nml
14 21 32 43 54
1/1

xic-ref (-target linux [basic test]): localdecl03.xi
xic-ref (-target linux [basic test]): localdecl03.xi
Failed to execute: localdecl03 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/localdecl03.xi
1 use io
2 use conv
3
4 main(args: int[][]) { 5 x: int[1][2][3][4][5] 6 println("done")
7}
Compiler's standard output:
ASM generated
Generated result:
./localdecl03.s.nml
Expected result:
./localdecl03.ssol.nml
1 done
1/1

xic-ref (-target linux [basic test]): localdecl06.xi
xic-ref (-target linux [basic test]): localdecl06.xi
Failed to execute: localdecl06 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/localdecl06.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a1: int[25][][][][]
6 a2: int[47][][][]
7 a3: int[20][][]
8 a4: int[16][]
9 a5: int[42]
10 a1[17] = a2
11 a1[17][16] = a3
12 a1[17][16][15] = a4
13 a1[17][16][15][14] = a5
14 a1[17][16][15][14][13] = 12
15 println(unparseInt(length(a1)))
16 println(unparseInt(length(a1[17])))
17 println(unparseInt(length(a1[17][16])))
18 println(unparseInt(length(a1[17][16][15])))
19 println(unparseInt(length(a1[17][16][15][14]))) 20 println(unparseInt(a1[17][16][15][14][13]))
21 println("done")
22 }
Compiler's standard output:
ASM generated
Generated result:
./localdecl06.s.nml
Expected result:
./localdecl06.ssol.nml
1 25 2 47 3 20 4 16 5 42 6 12 7 done
1/1

xic-ref (-target linux [basic test]): localdecl13.xi
xic-ref (-target linux [basic test]): localdecl13.xi
Failed to execute: localdecl13 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/localdecl13.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[] = {1, 2, 3}
6 x: int[f(a, 0)][f(a, 0)][f(a, 0)][][]
7 println(unparseInt(length(x)))
8 println(unparseInt(length(x[0])))
9 println(unparseInt(length(x[0][0])))
10 println(unparseInt(a[0])) 11 println(unparseInt(a[1])) 12 println(unparseInt(a[2])) 13 }
14
15 f(a: int[], i: int): int { 16 print("Index: ")
17 println(unparseInt(i))
18 a[i] = a[i] + 1
19 return a[i]
20 }
Compiler's standard output:
ASM generated
Generated result:
./localdecl13.s.nml
Expected result:
./localdecl13.ssol.nml
1 Index: 0 2 Index: 0 3 Index: 0 42
53 64 74 82 93
1/1

xic-ref (-target linux [basic test]): localdecl14.xi
xic-ref (-target linux [basic test]): localdecl14.xi
Failed to execute: localdecl14 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/localdecl14.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[] = {1, 2, 3, 4}
6 x: int[f(a,3)-f(a,2)][f(a,2)-f(a,1)][f(a,1)-f(a,0)][][]
7 println(unparseInt(length(x)))
8 println(unparseInt(length(x[0])))
9 println(unparseInt(length(x[0][0])))
10 println(unparseInt(a[0])) 11 println(unparseInt(a[1])) 12 println(unparseInt(a[2])) 13 println(unparseInt(a[3])) 14 }
15
16 f(a: int[], i: int): int { 17 print("Index: ")
18 println(unparseInt(i))
19 a[i] = a[i] + 1
20 return a[i]
21 }
Compiler's standard output:
ASM generated
Generated result:
./localdecl14.s.nml
Expected result:
./localdecl14.ssol.nml
1 Index: 3 2 Index: 2 3 Index: 2 4 Index: 1 5 Index: 1 6 Index: 0 71
82
92 10 2 11 4 12 5 13 5
1/1

xic-ref (-target linux [basic test]): procedurecall02.xi
xic-ref (-target linux [basic test]): procedurecall02.xi
Failed to execute: procedurecall02 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/procedurecall02.xi
1 use io
2 use conv
3
4 main(args: int[][]) { 5 p(47)
6}
7
8 p(x: int) {
9 print("p() called: ")
10 println(unparseInt(x)) 11 if (x <= 0) { return } 12 p(x-1)
13 print("p() post-call: ") 14 println(unparseInt(x)) 15 }
Compiler's standard output:
ASM generated
Generated result:
./procedurecall02.s.nml
Expected result:
./procedurecall02.ssol.nml
1 p() called: 47 2 p() called: 46 3 p() called: 45 4 p() called: 44 5 p() called: 43 6 p() called: 42 7 p() called: 41 8 p() called: 40 9 p() called: 39
10 p() called: 38 11 p() called: 37 12 p() called: 36 13 p() called: 35 14 p() called: 34 15 p() called: 33 16 p() called: 32 17 p() called: 31 18 p() called: 30 19 p() called: 29 20 p() called: 28 21 p() called: 27 22 p() called: 26 23 p() called: 25 24 p() called: 24 25 p() called: 23 26 p() called: 22
1/3

xic-ref (-target linux [basic test]): procedurecall02.xi
27 p() called: 21 28 p() called: 20 29 p() called: 19 30 p() called: 18 31 p() called: 17 32 p() called: 16 33 p() called: 15 34 p() called: 14 35 p() called: 13 36 p() called: 12 37 p() called: 11 38 p() called: 10 39 p() called: 9
40 p() called: 8
41 p() called: 7
42 p() called: 6
43 p() called: 5
44 p() called: 4
45 p() called: 3
46 p() called: 2
47 p() called: 1
48 p() called: 0
49 p() post-call: 1 50 p() post-call: 2 51 p() post-call: 3 52 p() post-call: 4 53 p() post-call: 5 54 p() post-call: 6 55 p() post-call: 7 56 p() post-call: 8 57 p() post-call: 9 58 p() post-call: 10 59 p() post-call: 11 60 p() post-call: 12 61 p() post-call: 13 62 p() post-call: 14 63 p() post-call: 15 64 p() post-call: 16 65 p() post-call: 17 66 p() post-call: 18 67 p() post-call: 19 68 p() post-call: 20 69 p() post-call: 21 70 p() post-call: 22 71 p() post-call: 23 72 p() post-call: 24 73 p() post-call: 25 74 p() post-call: 26 75 p() post-call: 27 76 p() post-call: 28 77 p() post-call: 29 78 p() post-call: 30 79 p() post-call: 31 80 p() post-call: 32 81 p() post-call: 33 82 p() post-call: 34 83 p() post-call: 35 84 p() post-call: 36 85 p() post-call: 37 86 p() post-call: 38
2/3

xic-ref (-target linux [basic test]): procedurecall02.xi
87 p() post-call: 39 88 p() post-call: 40 89 p() post-call: 41 90 p() post-call: 42 91 p() post-call: 43 92 p() post-call: 44 93 p() post-call: 45 94 p() post-call: 46 95 p() post-call: 47
3/3

xic-ref (-target linux [basic test]): procedurecall04.xi
xic-ref (-target linux [basic test]): procedurecall04.xi
Failed to execute: procedurecall04 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/procedurecall04.xi
1 use io
2 use conv
3
4 main(args: int[][]) { 5 p(47)
6}
7
8 p(x: int) {
9 print("p() called: ")
10 println(unparseInt(x)) 11 if (x <= 0) { return } 12 p(x-1)
13 print("p() post-call: ") 14 println(unparseInt(x)) 15 return
16 }
Compiler's standard output:
ASM generated
Generated result:
./procedurecall04.s.nml
Expected result:
./procedurecall04.ssol.nml
1 p() called: 47 2 p() called: 46 3 p() called: 45 4 p() called: 44 5 p() called: 43 6 p() called: 42 7 p() called: 41 8 p() called: 40 9 p() called: 39
10 p() called: 38 11 p() called: 37 12 p() called: 36 13 p() called: 35 14 p() called: 34 15 p() called: 33 16 p() called: 32 17 p() called: 31 18 p() called: 30 19 p() called: 29 20 p() called: 28 21 p() called: 27 22 p() called: 26 23 p() called: 25 24 p() called: 24 25 p() called: 23
1/3

xic-ref (-target linux [basic test]): procedurecall04.xi
26 p() called: 22 27 p() called: 21 28 p() called: 20 29 p() called: 19 30 p() called: 18 31 p() called: 17 32 p() called: 16 33 p() called: 15 34 p() called: 14 35 p() called: 13 36 p() called: 12 37 p() called: 11 38 p() called: 10 39 p() called: 9
40 p() called: 8
41 p() called: 7
42 p() called: 6
43 p() called: 5
44 p() called: 4
45 p() called: 3
46 p() called: 2
47 p() called: 1
48 p() called: 0
49 p() post-call: 1 50 p() post-call: 2 51 p() post-call: 3 52 p() post-call: 4 53 p() post-call: 5 54 p() post-call: 6 55 p() post-call: 7 56 p() post-call: 8 57 p() post-call: 9 58 p() post-call: 10 59 p() post-call: 11 60 p() post-call: 12 61 p() post-call: 13 62 p() post-call: 14 63 p() post-call: 15 64 p() post-call: 16 65 p() post-call: 17 66 p() post-call: 18 67 p() post-call: 19 68 p() post-call: 20 69 p() post-call: 21 70 p() post-call: 22 71 p() post-call: 23 72 p() post-call: 24 73 p() post-call: 25 74 p() post-call: 26 75 p() post-call: 27 76 p() post-call: 28 77 p() post-call: 29 78 p() post-call: 30 79 p() post-call: 31 80 p() post-call: 32 81 p() post-call: 33 82 p() post-call: 34 83 p() post-call: 35 84 p() post-call: 36 85 p() post-call: 37
2/3

xic-ref (-target linux [basic test]): procedurecall04.xi
86 p() post-call: 38 87 p() post-call: 39 88 p() post-call: 40 89 p() post-call: 41 90 p() post-call: 42 91 p() post-call: 43 92 p() post-call: 44 93 p() post-call: 45 94 p() post-call: 46 95 p() post-call: 47
3/3

xic-ref (-target linux [basic test]): procedurecall05.xi
xic-ref (-target linux [basic test]): procedurecall05.xi
Failed to execute: procedurecall05 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/procedurecall05.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 p(f(1), f(2), f(3), f(4), f(5), f(6)) 6}
7
8 f(x: int): int {
9 print("f() called: ")
10 println(unparseInt(x)) 11 return x
12 }
13
14 p(x1: int, x2: int, x3: int, x4: int, x5: int, x6: int) { 15 print("p() called: ")
16 print(unparseInt(x1))
17 print(" ")
18 print(unparseInt(x2)) 19 print(" ")
20 print(unparseInt(x3)) 21 print(" ")
22 print(unparseInt(x4)) 23 print(" ")
24 print(unparseInt(x5)) 25 print(" ")
26 print(unparseInt(x6)) 27 println("")
28 }
Compiler's standard output:
ASM generated
Generated result:
./procedurecall05.s.nml
Expected result:
./procedurecall05.ssol.nml
1 f() called: 1
2 f() called: 2
3 f() called: 3
4 f() called: 4
5 f() called: 5
6 f() called: 6
7 p() called: 1 2 3 4 5 6
1/1

xic-ref (-target linux [basic test]): procedurecall06.xi
xic-ref (-target linux [basic test]): procedurecall06.xi
Failed to execute: procedurecall06 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/procedurecall06.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int[] = {1, 2, 3}
6 p(f(x, 1), f(x, 2), f(x, 3), f(x, 4), f(x, 5), f(x, 6))
7}
8
9 f(x: int[], y: int): int {
10 print("f() called: ") 11 println(unparseInt(y))
12 x[0] = x[0] + 1
13 return x[0]
14 }
15
16 p(x1: int, x2: int, x3: int, x4: int, x5: int, x6: int) { 17 print("p() called: ")
18 print(unparseInt(x1))
19 print(" ")
20 print(unparseInt(x2))
21 print(" ")
22 print(unparseInt(x3))
23 print(" ")
24 print(unparseInt(x4))
25 print(" ")
26 print(unparseInt(x5))
27 print(" ")
28 print(unparseInt(x6))
29 println("")
30 }
Compiler's standard output:
ASM generated
Generated result:
./procedurecall06.s.nml
Expected result:
./procedurecall06.ssol.nml
1 f() called: 1
2 f() called: 2
3 f() called: 3
4 f() called: 4
5 f() called: 5
6 f() called: 6
7 p() called: 2 3 4 5 6 7
1/1

xic-ref (-target linux [basic test]): unary02.xi
xic-ref (-target linux [basic test]): unary02.xi
Failed to execute: unary02 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/unary02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(-f(47))) 6 println(unparseInt(-f(0))) 7}
8
9 f(x: int): int {
10 println("f() called: " + unparseInt(x))
11 return x
12 }
Compiler's standard output:
ASM generated
Generated result:
./unary02.s.nml
Expected result:
./unary02.ssol.nml
1 f() called: 47 2 -47
3 f() called: 0 40
1/1

xic-ref (-target linux [basic test]): unary03.xi
xic-ref (-target linux [basic test]): unary03.xi
Mismatch detected at line 1 of file unary03.s.nml
expected: false
found   : true
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/unary03.xi
1 use io
2 use conv
3
4 main(args: int[][]) { 5 println(b2s(!true)) 6 println(b2s(!false)) 7}
8
9 b2s(b: bool): int[] {
10 if (b) { return "true" } else { return "false" } 11 }
Compiler's standard output:
ASM generated
Generated result:
./unary03.s.nml
1 true 2 true
Expected result:
./unary03.ssol.nml
1 false 2 true
1/1

xic-ref (-target linux [basic test]): unary04.xi
xic-ref (-target linux [basic test]): unary04.xi
Failed to execute: unary04 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/unary04.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(b2s(!f(true))) 6 println(b2s(!f(false))) 7}
8
9 f(x: bool): bool {
10 println("f() called: " + b2s(x))
11 return x
12 } 13
14 b2s(b: bool): int[] {
15 if (b) { return "true" } else { return "false" } 16 }
Compiler's standard output:
ASM generated
Generated result:
./unary04.s.nml
Expected result:
./unary04.ssol.nml
1 f() called: true 2 false
3 f() called: false 4 true
1/1

xic-ref (-target linux [basic test]): while02.xi
xic-ref (-target linux [basic test]): while02.xi
Failed to execute: while02 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/while02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int = 0
6 while (lt(x, 7)) {
7 println(unparseInt(x)) 8 x=x+ 1
9}
10 println("done")
11 }
12
13 lt(x: int, y: int): bool {
14 println("lt() called: " + unparseInt(x) + " < " + unparseInt(y))
15 return x < y
16 }
Compiler's standard output:
ASM generated
Generated result:
./while02.s.nml
Expected result:
./while02.ssol.nml
1 lt() called: 0 < 7 20
3 lt() called: 1 < 7 41
5 lt() called: 2 < 7 62
7 lt() called: 3 < 7 83
9 lt() called: 4 < 7 10 4
11 lt() called: 5 < 7 12 5
13 lt() called: 6 < 7 14 6
15 lt() called: 7 < 7 16 done
1/1

xic-ref (-target linux [basic test]): while03.xi
xic-ref (-target linux [basic test]): while03.xi
Failed to execute: while03 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/while03.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int = 0
6 while (f() & lt(x, 7) & g()) {
7 println(unparseInt(x)) 8 x=x+ 1
9}
10 println("done")
11 }
12
13 lt(x: int, y: int): bool { 14 print("lt() called: ") 15 print(unparseInt(x))
16 print(" < ")
17 println(unparseInt(y)) 18 return x < y
19 }
20
21 f(): bool {
22 println("f() called")
23 return true
24 }
25
26 g(): bool {
27 println("g() called")
28 return true
29 }
Compiler's standard output:
ASM generated
Generated result:
./while03.s.nml
Expected result:
./while03.ssol.nml
1 f() called
2 lt() called: 0 < 7 3 g() called
40
5 f() called
6 lt() called: 1 < 7 7 g() called
81
9 f() called
10 lt() called: 2 < 7 11 g() called
12 2
13 f() called
1/2

xic-ref (-target linux [basic test]): while03.xi
14 lt() called: 3 < 7 15 g() called
16 3
17 f() called
18 lt() called: 4 < 7 19 g() called
20 4
21 f() called
22 lt() called: 5 < 7 23 g() called
24 5
25 f() called
26 lt() called: 6 < 7 27 g() called
28 6
29 f() called
30 lt() called: 7 < 7 31 done
2/2

xic-ref (-target linux [basic test]): while04.xi
xic-ref (-target linux [basic test]): while04.xi
Failed to execute: while04 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/while04.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int = 0
6 while (f() | lt(x, 7) | g()) {
7 println(unparseInt(x)) 8 x=x+ 1
9}
10 println("done")
11 }
12
13 lt(x: int, y: int): bool { 14 print("lt() called: ") 15 print(unparseInt(x))
16 print(" < ")
17 println(unparseInt(y)) 18 return x < y
19 }
20
21 f(): bool {
22 println("f() called")
23 return false
24 }
25
26 g(): bool {
27 println("g() called")
28 return false
29 }
Compiler's standard output:
ASM generated
Generated result:
./while04.s.nml
Expected result:
./while04.ssol.nml
1 f() called
2 lt() called: 0 < 7 30
4 f() called
5 lt() called: 1 < 7 61
7 f() called
8 lt() called: 2 < 7 92
10 f() called
11 lt() called: 3 < 7 12 3
13 f() called
1/2

xic-ref (-target linux [basic test]): while04.xi
14 lt() called: 4 < 7 15 4
16 f() called
17 lt() called: 5 < 7 18 5
19 f() called
20 lt() called: 6 < 7 21 6
22 f() called
23 lt() called: 7 < 7 24 g() called
25 done
2/2

xic-ref (-target linux -O [basic test]): arracc01.xi
xic-ref (-target linux -O [basic test]): arracc01.xi
Missing line in file arracc01.s.nml: 0
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arracc01.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[5]
6 i: int = 0
7 while (i < length(a)) {
8
a[i] = i i=i+ 1
Compiler's standard output:
ASM generated
Generated result:
./arracc01.s.nml
Expected result:
./arracc01.ssol.nml
10 21 32 43 54
9
10 }
11 i = 0
12 while (i < length(a)) {
13 println(unparseInt(a[i])) 14 i=i+ 1
15 }
16 }
1/1

xic-ref (-target linux -O [basic test]): arracc02.xi
xic-ref (-target linux -O [basic test]): arracc02.xi
Missing line in file arracc02.s.nml: Index: 0
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arracc02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[5]
6 i: int = 0
7 while (i < length(a)) {
8
a[i] = i i=i+ 1
9
10 }
11 i = 0
12 while (i < length(a)) {
13 println(unparseInt(a[f(i)])) 14 i=i+ 1
15 }
16 }
17
18 f(i: int): int {
19 print("Index: ")
20 println(unparseInt(i))
21 return i
22 }
Compiler's standard output:
ASM generated
Generated result:
./arracc02.s.nml
Expected result:
./arracc02.ssol.nml
1 Index: 0 20
3 Index: 1 41
5 Index: 2 62
7 Index: 3 83
9 Index: 4 10 4
1/1

xic-ref (-target linux -O [basic test]): arracc03.xi
xic-ref (-target linux -O [basic test]): arracc03.xi
Failed to execute: arracc03 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arracc03.xi
1 use io
2 use conv
3
4 main(args: int[][]) { 5 a: int[5][4]
6{
7
8
9
16 } 17 { 18
19
i: int = 0
while (i < length(a)) {
i: int = 0
while (i < length(a)) {
j: int = 0
while (j < length(a[i])) {
10
11
12
13 }
14 i=i+ 1 15 }
20
21
22
23
24 }
25 i=i+ 1 26 }
27 } 28 }
a[i][j] = i + j j=j+ 1
         j: int = 0
         while (j < length(a[i])) {
println(unparseInt(a[i][j])) j=j+ 1
Compiler's standard output:
ASM generated
Generated result:
./arracc03.s.nml
Expected result:
./arracc03.ssol.nml
10 21 32 43 51 62 73 84 92
10 3 11 4 12 5 13 3 14 4
1/2

xic-ref (-target linux -O [basic test]): arracc03.xi
15 5 16 6 17 4 18 5 19 6 20 7
2/2

xic-ref (-target linux -O [basic test]): arracc04.xi
xic-ref (-target linux -O [basic test]): arracc04.xi
Failed to execute: arracc04 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arracc04.xi
1 use io
2 use conv
3
4 main(args: int[][]) { 5 a: int[5][4]
6{
7
8
9
16 } 17 { 18
19
i: int = 0
while (i < length(a)) {
i: int = 0
while (i < length(a)) {
j: int = 0
while (j < length(a[i])) {
10
11
12
13 }
14 i=i+ 1 15 }
=i+ j 1
20
21
22
23
24 }
25 i=i+ 1 26 }
a[i][j] j=j +
j: int = 0
while (j < length(a[i])) {
println(unparseInt(a[f(i)][f(j)])) j=j+ 1
27 }
28 }
29
30 f(i: int): int {
31 print("Index: ")
32 println(unparseInt(i)) 33 return i
34 }
Compiler's standard output:
ASM generated
Generated result:
./arracc04.s.nml
Expected result:
./arracc04.ssol.nml
1 Index: 0 2 Index: 0 30
4 Index: 0 5 Index: 1 61
7 Index: 0 8 Index: 2
1/2

xic-ref (-target linux -O [basic test]): arracc04.xi
92
10 Index: 0 11 Index: 3 12 3
13 Index: 1 14 Index: 0 15 1
16 Index: 1 17 Index: 1 18 2
19 Index: 1 20 Index: 2 21 3
22 Index: 1 23 Index: 3 24 4
25 Index: 2 26 Index: 0 27 2
28 Index: 2 29 Index: 1 30 3
31 Index: 2 32 Index: 2 33 4
34 Index: 2 35 Index: 3 36 5
37 Index: 3 38 Index: 0 39 3
40 Index: 3 41 Index: 1 42 4
43 Index: 3 44 Index: 2 45 5
46 Index: 3 47 Index: 3 48 6
49 Index: 4 50 Index: 0 51 4
52 Index: 4 53 Index: 1 54 5
55 Index: 4 56 Index: 2 57 6
58 Index: 4 59 Index: 3 60 7
2/2

xic-ref (-target linux -O [basic test]): arracc07.xi
xic-ref (-target linux -O [basic test]): arracc07.xi
Missing line in file arracc07.s.nml: Index: 0
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arracc07.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[5]
6 i: int = 0
7 while (i < length(a)) {
8
a[i] = i -1 i=i+ 1
9
10 }
11 i = 0
12
13
14
15
16
17
18 }
19 i=i+ 1 20 }
21 }
22
23 f(a: int[], i: int): int { 24 print("Index: ")
25 println(unparseInt(i))
26 a[i] = a[i] + 1
27 return a[i]
28 }
Compiler's standard output:
ASM generated
Generated result:
./arracc07.s.nml
Expected result:
./arracc07.ssol.nml
1 Index: 0 2 Index: 0 31
41
50
61
72
83
9 Index: 1
10 Index: 1 11 1
12 1
13 2
14 1
while (i < length(a)) {
  println(unparseInt(a[a[-(f(a, i) - f(a, i))]]))
  j: int = 0
  while (j < length(a)) {
println(unparseInt(a[j])) j=j+ 1
1/2

xic-ref (-target linux -O [basic test]): arracc07.xi
15 2
16 3
17 Index: 2 18 Index: 2 19 3
20 1
21 2
22 3
23 2
24 3
25 Index: 3 26 Index: 3 27 3
28 1
29 2
30 3
31 4
32 3
33 Index: 4 34 Index: 4 35 3
36 1
37 2
38 3
39 4
40 5
2/2

xic-ref (-target linux -O [basic test]): arracc08.xi
xic-ref (-target linux -O [basic test]): arracc08.xi
Failed to execute: arracc08 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arracc08.xi
1 use io
2 use conv
3
4 main(args: int[][]) { 5 a: int[5][4]
6{
7
8
9
i: int = 0
while (i < length(a)) {
j: int = 0
while (j < length(a[i])) {
10
11
12
13 }
14 i=i+ 1 15 }
a[i][j] = i + j j=j+ 1
16 }
17 println(unparseInt(a[f(a, 4, 2)-3][f(a, 4, 2)-6])) 18 }
19
20 f(a: int[][], i: int, j: int): int {
21 print("Index: ")
22 print(unparseInt(i))
23 print(" ")
24 println(unparseInt(j))
25 a[i][j] = a[i][j] + 1
26 return a[i][j]
27 }
Compiler's standard output:
ASM generated
Generated result:
./arracc08.s.nml
Expected result:
./arracc08.ssol.nml
1 Index: 4 2 2 Index: 4 2 38
1/1

xic-ref (-target linux -O [basic test]): arrinit01.xi
xic-ref (-target linux -O [basic test]): arrinit01.xi
Failed to execute: arrinit01 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arrinit01.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[] = {1, 2, 3, 4, 5}
6 i: int = 0
7 while (i < length(a)) {
8 println(unparseInt(a[i])) 9 i=i+ 1
10 } 11 }
Compiler's standard output:
ASM generated
Generated result:
./arrinit01.s.nml
10 20 30 40 50 60 70 80 90
10 0 11 0 12 0 13 0 14 0 15 0 16 0 17 0 18 0 19 0 20 0 21 0 22 0 23 0 24 0 25 0 26 0 27 0 28 0 29 0 30 0 31 0 32 0 33 0 34 0
1/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
35 0 36 0 37 0 38 0 39 0 40 0 41 0 42 0 43 0 44 0 45 0 46 0 47 0 48 0 49 0 50 0 51 0 52 0 53 0 54 0 55 0 56 0 57 0 58 0 59 0 60 0 61 0 62 0 63 0 64 0 65 0 66 0 67 0 68 0 69 0 70 0 71 0 72 0 73 0 74 0 75 0 76 0 77 0 78 0 79 0 80 0 81 0 82 0 83 0 84 0 85 0 86 0 87 0 88 0 89 0 90 0 91 0 92 0 93 0 94 0
2/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
95 0 96 0 97 0 98 0 99 0
100 0
101 0
102 0
103 0
104 0
105 0
106 0
107 0
108 0
109 0
110 0
111 0
112 0
113 0
114 0
115 0
116 0
117 0
118 0
119 0
120 0
121 0
122 0
123 0
124 0
125 0
126 0
127 0
128 0
129 0
130 0
131 0
132 21803968 133 0
134 0
135 0
136 21804000 137 0
138 0
139 0
140 21804032 141 0
142 0
143 0
144 21804064 145 0
146 0
147 0
148 21804096 149 0
150 0
151 0
152 21804128 153 0
154 0
3/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
155 0
156 21804160 157 0
158 0
159 0
160 21804192 161 0
162 0
163 0
164 21804224 165 0
166 0
167 0
168 21804256 169 0
170 0
171 0
172 21804288 173 0
174 0
175 0
176 21804320 177 0
178 0
179 0
180 21804352 181 0
182 0
183 0
184 21804384 185 0
186 0
187 0
188 21804416 189 0
190 0
191 0
192 21804448 193 0
194 0
195 0
196 21804480 197 0
198 0
199 0
200 21804512 201 0
202 0
203 0
204 21804544 205 0
206 0
207 0
208 21804576 209 0
210 0
211 0
212 21804608 213 0
214 0
4/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
215 0
216 21804640 217 0
218 0
219 0
220 21804672 221 0
222 0
223 0
224 21804704 225 0
226 0
227 0
228 1
229 48
230 0
231 0
232 1
233 48
234 0
235 0
236 1
237 48
238 0
239 0
240 1
241 48
242 0
243 0
244 1
245 48
246 0
247 0
248 1
249 48
250 0
251 0
252 1
253 48
254 0
255 0
256 1
257 48
258 0
259 0
260 1
261 48
262 0
263 0
264 1
265 48
266 0
267 0
268 1
269 48
270 0
271 0
272 1
273 48
274 0
5/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
275 0 276 1 277 48 278 0 279 0 280 1 281 48 282 0 283 0 284 1 285 48 286 0 287 0 288 1 289 48 290 0 291 0 292 1 293 48 294 0 295 0 296 1 297 48 298 0 299 0 300 1 301 48 302 0 303 0 304 1 305 48 306 0 307 0 308 1 309 48 310 0 311 0 312 1 313 48 314 0 315 0 316 1 317 48 318 0 319 0 320 1 321 48 322 0 323 0 324 1 325 48 326 0 327 0 328 1 329 48 330 0 331 0 332 1 333 48 334 0
6/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
335 0 336 1 337 48 338 0 339 0 340 1 341 48 342 0 343 0 344 1 345 48 346 0 347 0 348 1 349 48 350 0 351 0 352 1 353 48 354 0 355 0 356 1 357 48 358 0 359 0 360 1 361 48 362 0 363 0 364 1 365 48 366 0 367 0 368 1 369 48 370 0 371 0 372 1 373 48 374 0 375 0 376 1 377 48 378 0 379 0 380 1 381 48 382 0 383 0 384 1 385 48 386 0 387 0 388 1 389 48 390 0 391 0 392 1 393 48 394 0
7/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
395 0 396 1 397 48 398 0 399 0 400 1 401 48 402 0 403 0 404 1 405 48 406 0 407 0 408 1 409 48 410 0 411 0 412 1 413 48 414 0 415 0 416 1 417 48 418 0 419 0 420 1 421 48 422 0 423 0 424 1 425 48 426 0 427 0 428 1 429 48 430 0 431 0 432 1 433 48 434 0 435 0 436 1 437 48 438 0 439 0 440 1 441 48 442 0 443 0 444 1 445 48 446 0 447 0 448 1 449 48 450 0 451 0 452 1 453 48 454 0
8/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
455 0 456 1 457 48 458 0 459 0 460 1 461 48 462 0 463 0 464 1 465 48 466 0 467 0 468 1 469 48 470 0 471 0 472 1 473 48 474 0 475 0 476 1 477 48 478 0 479 0 480 1 481 48 482 0 483 0 484 1 485 48 486 0 487 0 488 1 489 48 490 0 491 0 492 1 493 48 494 0 495 0 496 1 497 48 498 0 499 0 500 1 501 48 502 0 503 0 504 1 505 48 506 0 507 0 508 1 509 48 510 0 511 0 512 1 513 48 514 0
9/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
515 0
516 1
517 48
518 0
519 0
520 0
521 0
522 0
523 0
524 0
525 0
526 0
527 0
528 0
529 0
530 21807104 531 0
532 0
533 0
534 0
535 0
536 0
537 0
538 0
539 0
540 21807184 541 0
542 0
543 0
544 0
545 0
546 0
547 0
548 0
549 0
550 21807264 551 0
552 0
553 0
554 0
555 0
556 0
557 0
558 0
559 0
560 21807344 561 0
562 0
563 0
564 0
565 0
566 0
567 0
568 0
569 0
570 21807424 571 0
572 0 573 0 574 0
10/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
575 0
576 0
577 0
578 0
579 0
580 21807504 581 0
582 0
583 0
584 0
585 0
586 0
587 0
588 0
589 0
590 21807584 591 0
592 0
593 0
594 0
595 0
596 0
597 0
598 0
599 0
600 21807664 601 0
602 0
603 0
604 0
605 0
606 0
607 0
608 0
609 0
610 21807744 611 0
612 0
613 0
614 0
615 0
616 0
617 0
618 0
619 0
620 21807824 621 0
622 0
623 0
624 0
625 0
626 0
627 0
628 0
629 0
630 21807904 631 0
632 0 633 0 634 0
11/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
635 0
636 0
637 0
638 0
639 0
640 21807984 641 0
642 0
643 0
644 0
645 0
646 0
647 0
648 0
649 0
650 21808064 651 0
652 0 653 0 654 0 655 0 656 0 657 0 658 0 659 0 660 8 661 50 662 49 663 56 664 48 665 56 666 48 667 54 668 52 669 0 670 8 671 50 672 49 673 56 674 48 675 55 676 57 677 56 678 52 679 0 680 8 681 50 682 49 683 56 684 48 685 55 686 57 687 48 688 52 689 0 690 8 691 50 692 49 693 56 694 48
12/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
695 55 696 56 697 50 698 52 699 0 700 8 701 50 702 49 703 56 704 48 705 55 706 55 707 52 708 52 709 0 710 8 711 50 712 49 713 56 714 48 715 55 716 54 717 54 718 52 719 0 720 8 721 50 722 49 723 56 724 48 725 55 726 53 727 56 728 52 729 0 730 8 731 50 732 49 733 56 734 48 735 55 736 53 737 48 738 52 739 0 740 8 741 50 742 49 743 56 744 48 745 55 746 52 747 50 748 52 749 0 750 8 751 50 752 49 753 56 754 48
13/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
755 55 756 51 757 52 758 52 759 0 760 8 761 50 762 49 763 56 764 48 765 55 766 50 767 54 768 52 769 0 770 8 771 50 772 49 773 56 774 48 775 55 776 49 777 56 778 52 779 0 780 8 781 50 782 49 783 56 784 48 785 55 786 49 787 48 788 52 789 0 790 8 791 50 792 49 793 56 794 48 795 52 796 55 797 48 798 52 799 0 800 8 801 50 802 49 803 56 804 48 805 52 806 54 807 55 808 50 809 0 810 8 811 50 812 49 813 56 814 48
14/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
815 52 816 54 817 52 818 48 819 0 820 8 821 50 822 49 823 56 824 48 825 52 826 54 827 48 828 56 829 0 830 8 831 50 832 49 833 56 834 48 835 52 836 53 837 55 838 54 839 0 840 8 841 50 842 49 843 56 844 48 845 52 846 53 847 52 848 52 849 0 850 8 851 50 852 49 853 56 854 48 855 52 856 53 857 49 858 50 859 0 860 8 861 50 862 49 863 56 864 48 865 52 866 52 867 56 868 48 869 0 870 8 871 50 872 49 873 56 874 48
15/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
875 52 876 52 877 52 878 56 879 0 880 8 881 50 882 49 883 56 884 48 885 52 886 52 887 49 888 54 889 0 890 8 891 50 892 49 893 56 894 48 895 52 896 51 897 56 898 52 899 0 900 8 901 50 902 49 903 56 904 48 905 52 906 51 907 53 908 50 909 0 910 8 911 50 912 49 913 56 914 48 915 52 916 51 917 50 918 48 919 0 920 8 921 50 922 49 923 56 924 48 925 52 926 50 927 56 928 56 929 0 930 8 931 50 932 49 933 56 934 48
16/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
935 52 936 50 937 53 938 54 939 0 940 8 941 50 942 49 943 56 944 48 945 52 946 50 947 50 948 52 949 0 950 8 951 50 952 49 953 56 954 48 955 52 956 49 957 57 958 50 959 0 960 8 961 50 962 49 963 56 964 48 965 52 966 49 967 54 968 48 969 0 970 8 971 50 972 49 973 56 974 48 975 52 976 49 977 50 978 56 979 0 980 8 981 50 982 49 983 56 984 48 985 52 986 48 987 57 988 54 989 0 990 8 991 50 992 49 993 56 994 48
17/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
995 52 996 48 997 54 998 52 999 0
1000 8 1001 50 1002 49 1003 56 1004 48 1005 52 1006 48 1007 51 1008 50 1009 0 1010 8 1011 50 1012 49 1013 56 1014 48 1015 52 1016 48 1017 48 1018 48 1019 0 1020 8 1021 50 1022 49 1023 56 1024 48 1025 51 1026 57 1027 54 1028 56 1029 0 1030 0 1031 0 1032 1 1033 48 1034 0 1035 0 1036 1 1037 48 1038 0 1039 0 1040 2 1041 52 1042 56 1043 0 1044 1 1045 49 1046 0 1047 0 1048 1 1049 48 1050 0 1051 0 1052 1 1053 48 1054 0
18/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
1055 0 1056 2 1057 52 1058 56 1059 0 1060 1 1061 49 1062 0 1063 0 1064 1 1065 48 1066 0 1067 0 1068 1 1069 48 1070 0 1071 0 1072 2 1073 52 1074 56 1075 0 1076 1 1077 49 1078 0 1079 0 1080 1 1081 48 1082 0 1083 0 1084 1 1085 48 1086 0 1087 0 1088 2 1089 52 1090 56 1091 0 1092 1 1093 49 1094 0 1095 0 1096 1 1097 48 1098 0 1099 0 1100 1 1101 48 1102 0 1103 0 1104 2 1105 52 1106 56 1107 0 1108 1 1109 49 1110 0 1111 0 1112 1 1113 48 1114 0
19/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
1115 0 1116 1 1117 48 1118 0 1119 0 1120 2 1121 52 1122 56 1123 0 1124 1 1125 49 1126 0 1127 0 1128 1 1129 48 1130 0 1131 0 1132 1 1133 48 1134 0 1135 0 1136 2 1137 52 1138 56 1139 0 1140 1 1141 49 1142 0 1143 0 1144 1 1145 48 1146 0 1147 0 1148 1 1149 48 1150 0 1151 0 1152 2 1153 52 1154 56 1155 0 1156 1 1157 49 1158 0 1159 0 1160 1 1161 48 1162 0 1163 0 1164 1 1165 48 1166 0 1167 0 1168 2 1169 52 1170 56 1171 0 1172 1 1173 49 1174 0
20/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
1175 0 1176 1 1177 48 1178 0 1179 0 1180 1 1181 48 1182 0 1183 0 1184 2 1185 52 1186 56 1187 0 1188 1 1189 49 1190 0 1191 0 1192 1 1193 48 1194 0 1195 0 1196 1 1197 48 1198 0 1199 0 1200 2 1201 52 1202 56 1203 0 1204 1 1205 49 1206 0 1207 0 1208 1 1209 48 1210 0 1211 0 1212 1 1213 48 1214 0 1215 0 1216 2 1217 52 1218 56 1219 0 1220 1 1221 49 1222 0 1223 0 1224 1 1225 48 1226 0 1227 0 1228 1 1229 48 1230 0 1231 0 1232 2 1233 52 1234 56
21/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
1235 0 1236 1 1237 49 1238 0 1239 0 1240 1 1241 48 1242 0 1243 0 1244 1 1245 48 1246 0 1247 0 1248 2 1249 52 1250 56 1251 0 1252 1 1253 49 1254 0 1255 0 1256 1 1257 48 1258 0 1259 0 1260 1 1261 48 1262 0 1263 0 1264 2 1265 52 1266 56 1267 0 1268 1 1269 49 1270 0 1271 0 1272 1 1273 48 1274 0 1275 0 1276 1 1277 48 1278 0 1279 0 1280 2 1281 52 1282 56 1283 0 1284 1 1285 49 1286 0 1287 0 1288 1 1289 48 1290 0 1291 0 1292 1 1293 48 1294 0
22/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
1295 0 1296 2 1297 52 1298 56 1299 0 1300 1 1301 49 1302 0 1303 0 1304 1 1305 48 1306 0 1307 0 1308 1 1309 48 1310 0 1311 0 1312 2 1313 52 1314 56 1315 0 1316 1 1317 49 1318 0 1319 0 1320 1 1321 48 1322 0 1323 0 1324 1 1325 48 1326 0 1327 0 1328 2 1329 52 1330 56 1331 0 1332 1 1333 49 1334 0 1335 0 1336 1 1337 48 1338 0 1339 0 1340 1 1341 48 1342 0 1343 0 1344 2 1345 52 1346 56 1347 0 1348 1 1349 49 1350 0 1351 0 1352 1 1353 48 1354 0
23/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
1355 0 1356 1 1357 48 1358 0 1359 0 1360 2 1361 52 1362 56 1363 0 1364 1 1365 49 1366 0 1367 0 1368 1 1369 48 1370 0 1371 0 1372 1 1373 48 1374 0 1375 0 1376 2 1377 52 1378 56 1379 0 1380 1 1381 49 1382 0 1383 0 1384 1 1385 48 1386 0 1387 0 1388 1 1389 48 1390 0 1391 0 1392 2 1393 52 1394 56 1395 0 1396 1 1397 49 1398 0 1399 0 1400 1 1401 48 1402 0 1403 0 1404 1 1405 48 1406 0 1407 0 1408 2 1409 52 1410 56 1411 0 1412 1 1413 49 1414 0
24/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
1415 0 1416 1 1417 48 1418 0 1419 0 1420 1 1421 48 1422 0 1423 0 1424 2 1425 52 1426 56 1427 0 1428 1 1429 49 1430 0 1431 0 1432 1 1433 48 1434 0 1435 0 1436 1 1437 48 1438 0 1439 0 1440 2 1441 52 1442 56 1443 0 1444 1 1445 49 1446 0 1447 0 1448 1 1449 48 1450 0 1451 0 1452 1 1453 48 1454 0 1455 0 1456 2 1457 52 1458 56 1459 0 1460 1 1461 49 1462 0 1463 0 1464 1 1465 48 1466 0 1467 0 1468 1 1469 48 1470 0 1471 0 1472 2 1473 52 1474 56
25/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
1475 0 1476 1 1477 49 1478 0 1479 0 1480 1 1481 48 1482 0 1483 0 1484 1 1485 48 1486 0 1487 0 1488 2 1489 52 1490 56 1491 0 1492 1 1493 49 1494 0 1495 0 1496 1 1497 48 1498 0 1499 0 1500 1 1501 48 1502 0 1503 0 1504 2 1505 52 1506 56 1507 0 1508 1 1509 49 1510 0 1511 0 1512 1 1513 48 1514 0 1515 0 1516 1 1517 48 1518 0 1519 0 1520 2 1521 52 1522 56 1523 0 1524 1 1525 49 1526 0 1527 0 1528 1 1529 48 1530 0 1531 0 1532 1 1533 48 1534 0
26/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
1535 0 1536 2 1537 52 1538 56 1539 0 1540 1 1541 49 1542 0 1543 0 1544 1 1545 48 1546 0 1547 0 1548 1 1549 48 1550 0 1551 0 1552 1 1553 48 1554 0 1555 0 1556 1 1557 48 1558 0 1559 0 1560 1 1561 48 1562 0 1563 0 1564 1 1565 48 1566 0 1567 0 1568 1 1569 48 1570 0 1571 0 1572 1 1573 48 1574 0 1575 0 1576 1 1577 48 1578 0 1579 0 1580 1 1581 48 1582 0 1583 0 1584 1 1585 48 1586 0 1587 0 1588 1 1589 48 1590 0 1591 0 1592 1 1593 48 1594 0
27/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
1595 0 1596 1 1597 48 1598 0 1599 0 1600 1 1601 48 1602 0 1603 0 1604 1 1605 48 1606 0 1607 0 1608 1 1609 48 1610 0 1611 0 1612 1 1613 48 1614 0 1615 0 1616 2 1617 52 1618 56 1619 0 1620 1 1621 49 1622 0 1623 0 1624 1 1625 48 1626 0 1627 0 1628 1 1629 48 1630 0 1631 0 1632 2 1633 52 1634 56 1635 0 1636 1 1637 49 1638 0 1639 0 1640 1 1641 48 1642 0 1643 0 1644 1 1645 48 1646 0 1647 0 1648 2 1649 52 1650 56 1651 0 1652 1 1653 49 1654 0
28/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
1655 0 1656 1 1657 48 1658 0 1659 0 1660 1 1661 48 1662 0 1663 0 1664 2 1665 52 1666 56 1667 0 1668 1 1669 49 1670 0 1671 0 1672 1 1673 48 1674 0 1675 0 1676 1 1677 48 1678 0 1679 0 1680 2 1681 52 1682 56 1683 0 1684 1 1685 49 1686 0 1687 0 1688 1 1689 48 1690 0 1691 0 1692 1 1693 48 1694 0 1695 0 1696 2 1697 52 1698 56 1699 0 1700 1 1701 49 1702 0 1703 0 1704 1 1705 48 1706 0 1707 0 1708 1 1709 48 1710 0 1711 0 1712 2 1713 52 1714 56
29/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
1715 0 1716 1 1717 49 1718 0 1719 0 1720 1 1721 48 1722 0 1723 0 1724 1 1725 48 1726 0 1727 0 1728 2 1729 52 1730 56 1731 0 1732 1 1733 49 1734 0 1735 0 1736 1 1737 48 1738 0 1739 0 1740 1 1741 48 1742 0 1743 0 1744 2 1745 52 1746 56 1747 0 1748 1 1749 49 1750 0 1751 0 1752 1 1753 48 1754 0 1755 0 1756 1 1757 48 1758 0 1759 0 1760 2 1761 52 1762 56 1763 0 1764 1 1765 49 1766 0 1767 0 1768 1 1769 48 1770 0 1771 0 1772 1 1773 48 1774 0
30/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
1775 0 1776 2 1777 52 1778 56 1779 0 1780 1 1781 49 1782 0 1783 0 1784 1 1785 48 1786 0 1787 0 1788 1 1789 48 1790 0 1791 0 1792 2 1793 52 1794 56 1795 0 1796 1 1797 49 1798 0 1799 0 1800 1 1801 48 1802 0 1803 0 1804 1 1805 48 1806 0 1807 0 1808 2 1809 52 1810 56 1811 0 1812 1 1813 49 1814 0 1815 0 1816 1 1817 48 1818 0 1819 0 1820 1 1821 48 1822 0 1823 0 1824 2 1825 52 1826 56 1827 0 1828 1 1829 49 1830 0 1831 0 1832 1 1833 48 1834 0
31/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
1835 0 1836 1 1837 48 1838 0 1839 0 1840 2 1841 52 1842 56 1843 0 1844 1 1845 49 1846 0 1847 0 1848 1 1849 48 1850 0 1851 0 1852 1 1853 48 1854 0 1855 0 1856 2 1857 52 1858 56 1859 0 1860 1 1861 49 1862 0 1863 0 1864 1 1865 48 1866 0 1867 0 1868 1 1869 48 1870 0 1871 0 1872 2 1873 52 1874 56 1875 0 1876 1 1877 49 1878 0 1879 0 1880 1 1881 48 1882 0 1883 0 1884 1 1885 48 1886 0 1887 0 1888 2 1889 52 1890 56 1891 0 1892 1 1893 49 1894 0
32/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
1895 0 1896 1 1897 48 1898 0 1899 0 1900 1 1901 48 1902 0 1903 0 1904 2 1905 52 1906 56 1907 0 1908 1 1909 49 1910 0 1911 0 1912 1 1913 48 1914 0 1915 0 1916 1 1917 48 1918 0 1919 0 1920 2 1921 52 1922 56 1923 0 1924 1 1925 49 1926 0 1927 0 1928 1 1929 48 1930 0 1931 0 1932 1 1933 48 1934 0 1935 0 1936 2 1937 52 1938 56 1939 0 1940 1 1941 49 1942 0 1943 0 1944 1 1945 48 1946 0 1947 0 1948 1 1949 48 1950 0 1951 0 1952 2 1953 52 1954 56
33/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
1955 0 1956 1 1957 49 1958 0 1959 0 1960 1 1961 48 1962 0 1963 0 1964 1 1965 48 1966 0 1967 0 1968 2 1969 52 1970 56 1971 0 1972 1 1973 49 1974 0 1975 0 1976 1 1977 48 1978 0 1979 0 1980 1 1981 48 1982 0 1983 0 1984 2 1985 52 1986 56 1987 0 1988 1 1989 49 1990 0 1991 0 1992 1 1993 48 1994 0 1995 0 1996 1 1997 48 1998 0 1999 0 2000 2 2001 52 2002 56 2003 0 2004 1 2005 49 2006 0 2007 0 2008 1 2009 48 2010 0 2011 0 2012 1 2013 48 2014 0
34/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
2015 0 2016 2 2017 52 2018 56 2019 0 2020 1 2021 49 2022 0 2023 0 2024 1 2025 48 2026 0 2027 0 2028 1 2029 48 2030 0 2031 0 2032 2 2033 52 2034 56 2035 0 2036 1 2037 49 2038 0 2039 0 2040 1 2041 48 2042 0 2043 0 2044 1 2045 48 2046 0 2047 0 2048 2 2049 52 2050 56 2051 0 2052 1 2053 49 2054 0 2055 0 2056 2 2057 53 2058 55 2059 0 2060 2 2061 53 2062 53 2063 0 2064 2 2065 52 2066 56 2067 0 2068 2 2069 53 2070 54 2071 0 2072 2 2073 52 2074 57
35/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
2075 0 2076 2 2077 53 2078 48 2079 0 2080 1 2081 56 2082 0 2083 0 2084 1 2085 48 2086 0 2087 0 2088 2 2089 53 2090 50 2091 0 2092 2 2093 53 2094 52 2095 0 2096 2 2097 52 2098 56 2099 0 2100 2 2101 53 2102 54 2103 0 2104 2 2105 52 2106 56 2107 0 2108 2 2109 53 2110 54 2111 0 2112 2 2113 52 2114 57 2115 0 2116 2 2117 53 2118 48 2119 0 2120 1 2121 56 2122 0 2123 0 2124 1 2125 48 2126 0 2127 0 2128 1 2129 48 2130 0 2131 0 2132 1 2133 48 2134 0
36/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
2135 0 2136 1 2137 48 2138 0 2139 0 2140 1 2141 48 2142 0 2143 0 2144 1 2145 48 2146 0 2147 0 2148 1 2149 48 2150 0 2151 0 2152 1 2153 48 2154 0 2155 0 2156 1 2157 48 2158 0 2159 0 2160 1 2161 48 2162 0 2163 0 2164 1 2165 48 2166 0 2167 0 2168 1 2169 48 2170 0 2171 0 2172 1 2173 48 2174 0 2175 0 2176 1 2177 48 2178 0 2179 0 2180 1 2181 48 2182 0 2183 0 2184 1 2185 48 2186 0 2187 0 2188 1 2189 48 2190 0 2191 0 2192 1 2193 48 2194 0
37/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
2195 0 2196 1 2197 48 2198 0 2199 0 2200 1 2201 48 2202 0 2203 0 2204 1 2205 48 2206 0 2207 0 2208 1 2209 48 2210 0 2211 0 2212 1 2213 48 2214 0 2215 0 2216 1 2217 48 2218 0 2219 0 2220 1 2221 48 2222 0 2223 0 2224 1 2225 48 2226 0 2227 0 2228 1 2229 48 2230 0 2231 0 2232 1 2233 48 2234 0 2235 0 2236 1 2237 48 2238 0 2239 0 2240 1 2241 48 2242 0 2243 0 2244 1 2245 48 2246 0 2247 0 2248 1 2249 48 2250 0 2251 0 2252 1 2253 48 2254 0
38/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
2255 0 2256 1 2257 48 2258 0 2259 0 2260 1 2261 48 2262 0 2263 0 2264 1 2265 48 2266 0 2267 0 2268 1 2269 48 2270 0 2271 0 2272 1 2273 48 2274 0 2275 0 2276 1 2277 48 2278 0 2279 0 2280 1 2281 48 2282 0 2283 0 2284 1 2285 48 2286 0 2287 0 2288 1 2289 48 2290 0 2291 0 2292 1 2293 48 2294 0 2295 0 2296 1 2297 48 2298 0 2299 0 2300 1 2301 48 2302 0 2303 0 2304 1 2305 48 2306 0 2307 0 2308 1 2309 48 2310 0 2311 0 2312 1 2313 48 2314 0
39/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
2315 0 2316 1 2317 48 2318 0 2319 0 2320 1 2321 48 2322 0 2323 0 2324 1 2325 48 2326 0 2327 0 2328 1 2329 48 2330 0 2331 0 2332 1 2333 48 2334 0 2335 0 2336 1 2337 48 2338 0 2339 0 2340 1 2341 48 2342 0 2343 0 2344 1 2345 48 2346 0 2347 0 2348 1 2349 48 2350 0 2351 0 2352 1 2353 48 2354 0 2355 0 2356 1 2357 48 2358 0 2359 0 2360 1 2361 48 2362 0 2363 0 2364 1 2365 48 2366 0 2367 0 2368 1 2369 48 2370 0 2371 0 2372 1 2373 48 2374 0
40/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
2375 0 2376 1 2377 48 2378 0 2379 0 2380 1 2381 48 2382 0 2383 0 2384 1 2385 48 2386 0 2387 0 2388 1 2389 48 2390 0 2391 0 2392 1 2393 48 2394 0 2395 0 2396 1 2397 48 2398 0 2399 0 2400 1 2401 48 2402 0 2403 0 2404 1 2405 48 2406 0 2407 0 2408 1 2409 48 2410 0 2411 0 2412 1 2413 48 2414 0 2415 0 2416 1 2417 48 2418 0 2419 0 2420 1 2421 48 2422 0 2423 0 2424 1 2425 48 2426 0 2427 0 2428 1 2429 48 2430 0 2431 0 2432 1 2433 48 2434 0
41/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
2435 0 2436 1 2437 48 2438 0 2439 0 2440 1 2441 48 2442 0 2443 0 2444 1 2445 48 2446 0 2447 0 2448 1 2449 48 2450 0 2451 0 2452 1 2453 48 2454 0 2455 0 2456 1 2457 48 2458 0 2459 0 2460 1 2461 48 2462 0 2463 0 2464 1 2465 48 2466 0 2467 0 2468 1 2469 48 2470 0 2471 0 2472 1 2473 48 2474 0 2475 0 2476 1 2477 48 2478 0 2479 0 2480 1 2481 48 2482 0 2483 0 2484 1 2485 48 2486 0 2487 0 2488 1 2489 48 2490 0 2491 0 2492 1 2493 48 2494 0
42/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
2495 0 2496 1 2497 48 2498 0 2499 0 2500 1 2501 48 2502 0 2503 0 2504 1 2505 48 2506 0 2507 0 2508 1 2509 48 2510 0 2511 0 2512 1 2513 48 2514 0 2515 0 2516 1 2517 48 2518 0 2519 0 2520 1 2521 48 2522 0 2523 0 2524 1 2525 48 2526 0 2527 0 2528 1 2529 48 2530 0 2531 0 2532 1 2533 48 2534 0 2535 0 2536 1 2537 48 2538 0 2539 0 2540 1 2541 48 2542 0 2543 0 2544 1 2545 48 2546 0 2547 0 2548 1 2549 48 2550 0 2551 0 2552 1 2553 48 2554 0
43/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
2555 0 2556 1 2557 48 2558 0 2559 0 2560 1 2561 48 2562 0 2563 0 2564 1 2565 48 2566 0 2567 0 2568 2 2569 52 2570 56 2571 0 2572 2 2573 53 2574 54 2575 0 2576 2 2577 52 2578 57 2579 0 2580 2 2581 53 2582 48 2583 0 2584 1 2585 56 2586 0 2587 0 2588 1 2589 48 2590 0 2591 0 2592 2 2593 53 2594 50 2595 0 2596 2 2597 52 2598 56 2599 0 2600 2 2601 53 2602 53 2603 0 2604 2 2605 53 2606 50 2607 0 2608 2 2609 52 2610 56 2611 0 2612 2 2613 53 2614 54
44/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
2615 0 2616 2 2617 52 2618 57 2619 0 2620 2 2621 53 2622 48 2623 0 2624 1 2625 56 2626 0 2627 0 2628 1 2629 48 2630 0 2631 0 2632 2 2633 53 2634 50 2635 0 2636 2 2637 52 2638 56 2639 0 2640 2 2641 52 2642 57 2643 0 2644 2 2645 53 2646 53 2647 0 2648 2 2649 52 2650 56 2651 0 2652 2 2653 53 2654 54 2655 0 2656 2 2657 52 2658 57 2659 0 2660 2 2661 53 2662 48 2663 0 2664 1 2665 56 2666 0 2667 0 2668 1 2669 48 2670 0 2671 0 2672 2 2673 53 2674 50
45/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
2675 0 2676 2 2677 53 2678 54 2679 0 2680 2 2681 52 2682 57 2683 0 2684 2 2685 53 2686 53 2687 0 2688 2 2689 52 2690 56 2691 0 2692 2 2693 53 2694 54 2695 0 2696 2 2697 52 2698 57 2699 0 2700 2 2701 53 2702 48 2703 0 2704 1 2705 56 2706 0 2707 0 2708 1 2709 48 2710 0 2711 0 2712 2 2713 53 2714 50 2715 0 2716 2 2717 53 2718 52 2719 0 2720 2 2721 53 2722 48 2723 0 2724 2 2725 53 2726 53 2727 0 2728 2 2729 52 2730 56 2731 0 2732 2 2733 53 2734 54
46/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
2735 0 2736 2 2737 52 2738 57 2739 0 2740 2 2741 53 2742 48 2743 0 2744 1 2745 56 2746 0 2747 0 2748 1 2749 48 2750 0 2751 0 2752 2 2753 53 2754 50 2755 0 2756 2 2757 53 2758 50 2759 0 2760 2 2761 53 2762 49 2763 0 2764 2 2765 53 2766 53 2767 0 2768 2 2769 52 2770 56 2771 0 2772 2 2773 53 2774 54 2775 0 2776 2 2777 52 2778 57 2779 0 2780 2 2781 53 2782 48 2783 0 2784 1 2785 56 2786 0 2787 0 2788 1 2789 48 2790 0 2791 0 2792 2 2793 53 2794 50
47/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
2795 0 2796 2 2797 53 2798 48 2799 0 2800 2 2801 53 2802 50 2803 0 2804 2 2805 53 2806 53 2807 0 2808 2 2809 52 2810 56 2811 0 2812 2 2813 53 2814 54 2815 0 2816 2 2817 52 2818 57 2819 0 2820 2 2821 53 2822 48 2823 0 2824 1 2825 56 2826 0 2827 0 2828 1 2829 48 2830 0 2831 0 2832 2 2833 53 2834 50 2835 0 2836 2 2837 52 2838 56 2839 0 2840 2 2841 53 2842 51 2843 0 2844 2 2845 53 2846 53 2847 0 2848 2 2849 52 2850 56 2851 0 2852 2 2853 53 2854 54
48/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
2855 0 2856 2 2857 52 2858 57 2859 0 2860 2 2861 53 2862 48 2863 0 2864 1 2865 56 2866 0 2867 0 2868 1 2869 48 2870 0 2871 0 2872 2 2873 53 2874 50 2875 0 2876 2 2877 53 2878 54 2879 0 2880 2 2881 53 2882 51 2883 0 2884 2 2885 53 2886 53 2887 0 2888 2 2889 52 2890 56 2891 0 2892 2 2893 53 2894 54 2895 0 2896 2 2897 52 2898 57 2899 0 2900 2 2901 53 2902 48 2903 0 2904 1 2905 56 2906 0 2907 0 2908 1 2909 48 2910 0 2911 0 2912 2 2913 53 2914 50
49/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
2915 0 2916 2 2917 53 2918 52 2919 0 2920 2 2921 53 2922 52 2923 0 2924 2 2925 53 2926 53 2927 0 2928 2 2929 52 2930 56 2931 0 2932 2 2933 53 2934 54 2935 0 2936 2 2937 52 2938 57 2939 0 2940 2 2941 53 2942 48 2943 0 2944 1 2945 56 2946 0 2947 0 2948 1 2949 48 2950 0 2951 0 2952 2 2953 53 2954 50 2955 0 2956 2 2957 53 2958 50 2959 0 2960 2 2961 53 2962 53 2963 0 2964 2 2965 53 2966 53 2967 0 2968 2 2969 52 2970 56 2971 0 2972 2 2973 53 2974 54
50/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
2975 0 2976 2 2977 52 2978 57 2979 0 2980 2 2981 53 2982 48 2983 0 2984 1 2985 56 2986 0 2987 0 2988 1 2989 48 2990 0 2991 0 2992 2 2993 53 2994 50 2995 0 2996 2 2997 53 2998 48 2999 0 3000 2 3001 53 3002 54 3003 0 3004 2 3005 53 3006 53 3007 0 3008 2 3009 52 3010 56 3011 0 3012 2 3013 53 3014 54 3015 0 3016 2 3017 52 3018 57 3019 0 3020 2 3021 53 3022 48 3023 0 3024 1 3025 56 3026 0 3027 0 3028 1 3029 48 3030 0 3031 0 3032 2 3033 53 3034 50
51/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
3035 0 3036 2 3037 52 3038 56 3039 0 3040 2 3041 53 3042 55 3043 0 3044 2 3045 53 3046 53 3047 0 3048 2 3049 52 3050 56 3051 0 3052 2 3053 53 3054 54 3055 0 3056 2 3057 52 3058 57 3059 0 3060 2 3061 53 3062 48 3063 0 3064 1 3065 56 3066 0 3067 0 3068 1 3069 48 3070 0 3071 0 3072 2 3073 53 3074 50 3075 0 3076 2 3077 53 3078 54 3079 0 3080 2 3081 52 3082 57 3083 0 3084 2 3085 53 3086 48 3087 0 3088 1 3089 56 3090 0 3091 0 3092 1 3093 48 3094 0
52/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
3095 0 3096 2 3097 53 3098 54 3099 0 3100 2 3101 53 3102 54 3103 0 3104 2 3105 53 3106 48 3107 0 3108 2 3109 53 3110 50 3111 0 3112 2 3113 52 3114 56 3115 0 3116 2 3117 53 3118 54 3119 0 3120 2 3121 52 3122 57 3123 0 3124 2 3125 53 3126 48 3127 0 3128 1 3129 56 3130 0 3131 0 3132 1 3133 48 3134 0 3135 0 3136 2 3137 52 3138 56 3139 0 3140 2 3141 53 3142 48 3143 0 3144 2 3145 53 3146 49 3147 0 3148 2 3149 53 3150 50 3151 0 3152 2 3153 52 3154 56
53/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
3155 0 3156 2 3157 53 3158 54 3159 0 3160 2 3161 52 3162 57 3163 0 3164 2 3165 53 3166 48 3167 0 3168 1 3169 56 3170 0 3171 0 3172 1 3173 48 3174 0 3175 0 3176 2 3177 53 3178 48 3179 0 3180 2 3181 53 3182 51 3183 0 3184 2 3185 53 3186 49 3187 0 3188 2 3189 53 3190 50 3191 0 3192 2 3193 52 3194 56 3195 0 3196 2 3197 53 3198 54 3199 0 3200 2 3201 52 3202 57 3203 0 3204 2 3205 53 3206 48 3207 0 3208 1 3209 56 3210 0 3211 0 3212 1 3213 48 3214 0
54/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
3215 0 3216 2 3217 53 3218 50 3219 0 3220 2 3221 53 3222 54 3223 0 3224 2 3225 53 3226 49 3227 0 3228 2 3229 53 3230 50 3231 0 3232 2 3233 52 3234 56 3235 0 3236 2 3237 53 3238 54 3239 0 3240 2 3241 52 3242 57 3243 0 3244 2 3245 53 3246 48 3247 0 3248 1 3249 56 3250 0 3251 0 3252 1 3253 48 3254 0 3255 0 3256 2 3257 53 3258 52 3259 0 3260 2 3261 52 3262 57 3263 0 3264 2 3265 53 3266 50 3267 0 3268 2 3269 53 3270 50 3271 0 3272 2 3273 52 3274 56
55/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
3275 0 3276 2 3277 53 3278 54 3279 0 3280 2 3281 52 3282 57 3283 0 3284 2 3285 53 3286 48 3287 0 3288 1 3289 56 3290 0 3291 0 3292 1 3293 48 3294 0 3295 0 3296 2 3297 53 3298 54 3299 0 3300 2 3301 53 3302 50 3303 0 3304 2 3305 53 3306 50 3307 0 3308 2 3309 53 3310 50 3311 0 3312 2 3313 52 3314 56 3315 0 3316 2 3317 53 3318 54 3319 0 3320 2 3321 52 3322 57 3323 0 3324 2 3325 53 3326 48 3327 0 3328 1 3329 56 3330 0 3331 0 3332 1 3333 48 3334 0
56/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
3335 0 3336 2 3337 52 3338 56 3339 0 3340 2 3341 53 3342 54 3343 0 3344 2 3345 53 3346 50 3347 0 3348 2 3349 53 3350 50 3351 0 3352 2 3353 52 3354 56 3355 0 3356 2 3357 53 3358 54 3359 0 3360 2 3361 52 3362 57 3363 0 3364 2 3365 53 3366 48 3367 0 3368 1 3369 56 3370 0 3371 0 3372 1 3373 48 3374 0 3375 0 3376 2 3377 53 3378 48 3379 0 3380 2 3381 52 3382 57 3383 0 3384 2 3385 53 3386 51 3387 0 3388 2 3389 53 3390 50 3391 0 3392 2 3393 52 3394 56
57/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
3395 0 3396 2 3397 53 3398 54 3399 0 3400 2 3401 52 3402 57 3403 0 3404 2 3405 53 3406 48 3407 0 3408 1 3409 56 3410 0 3411 0 3412 1 3413 48 3414 0 3415 0 3416 2 3417 53 3418 50 3419 0 3420 2 3421 53 3422 50 3423 0 3424 2 3425 53 3426 51 3427 0 3428 2 3429 53 3430 50 3431 0 3432 2 3433 52 3434 56 3435 0 3436 2 3437 53 3438 54 3439 0 3440 2 3441 52 3442 57 3443 0 3444 2 3445 53 3446 48 3447 0 3448 1 3449 56 3450 0 3451 0 3452 1 3453 48 3454 0
58/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
3455 0 3456 2 3457 53 3458 52 3459 0 3460 2 3461 53 3462 53 3463 0 3464 2 3465 53 3466 51 3467 0 3468 2 3469 53 3470 50 3471 0 3472 2 3473 52 3474 56 3475 0 3476 2 3477 53 3478 54 3479 0 3480 2 3481 52 3482 57 3483 0 3484 2 3485 53 3486 48 3487 0 3488 1 3489 56 3490 0 3491 0 3492 1 3493 48 3494 0 3495 0 3496 2 3497 53 3498 54 3499 0 3500 2 3501 52 3502 56 3503 0 3504 2 3505 53 3506 52 3507 0 3508 2 3509 53 3510 50 3511 0 3512 2 3513 52 3514 56
59/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
3515 0 3516 2 3517 53 3518 54 3519 0 3520 2 3521 52 3522 57 3523 0 3524 2 3525 53 3526 48 3527 0 3528 1 3529 56 3530 0 3531 0 3532 1 3533 48 3534 0 3535 0 3536 2 3537 52 3538 56 3539 0 3540 2 3541 53 3542 50 3543 0 3544 2 3545 53 3546 52 3547 0 3548 2 3549 53 3550 50 3551 0 3552 2 3553 52 3554 56 3555 0 3556 2 3557 53 3558 54 3559 0 3560 2 3561 52 3562 57 3563 0 3564 2 3565 53 3566 48 3567 0 3568 1 3569 56 3570 0 3571 0 3572 1 3573 48 3574 0
60/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
3575 0 3576 2 3577 53 3578 48 3579 0 3580 2 3581 53 3582 53 3583 0 3584 2 3585 53 3586 52 3587 0 3588 2 3589 53 3590 50 3591 0 3592 1 3593 49 3594 0 3595 0 3596 1 3597 48 3598 0 3599 0 3600 2 3601 53 3602 54 3603 0 3604 2 3605 53 3606 50 3607 0 3608 1 3609 50 3610 0 3611 0 3612 1 3613 48 3614 0 3615 0 3616 1 3617 48 3618 0 3619 0 3620 2 3621 52 3622 56 3623 0 3624 1 3625 49 3626 0 3627 0 3628 1 3629 48 3630 0 3631 0 3632 1 3633 48 3634 0
61/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
3635 0 3636 2 3637 52 3638 56 3639 0 3640 1 3641 49 3642 0 3643 0 3644 1 3645 48 3646 0 3647 0 3648 1 3649 48 3650 0 3651 0 3652 2 3653 52 3654 57 3655 0 3656 1 3657 49 3658 0 3659 0 3660 1 3661 48 3662 0 3663 0 3664 2 3665 53 3666 54 3667 0 3668 2 3669 53 3670 50 3671 0 3672 1 3673 50 3674 0 3675 0 3676 1 3677 48 3678 0 3679 0 3680 1 3681 48 3682 0 3683 0 3684 2 3685 52 3686 56 3687 0 3688 1 3689 49 3690 0 3691 0 3692 1 3693 48 3694 0
62/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
3695 0 3696 1 3697 48 3698 0 3699 0 3700 2 3701 52 3702 56 3703 0 3704 1 3705 49 3706 0 3707 0 3708 1 3709 48 3710 0 3711 0 3712 1 3713 48 3714 0 3715 0 3716 1 3717 48 3718 0 3719 0 3720 2 3721 53 3722 54 3723 0 3724 2 3725 53 3726 52 3727 0 3728 2 3729 53 3730 55 3731 0 3732 2 3733 53 3734 49 3735 0 3736 2 3737 52 3738 56 3739 0 3740 2 3741 53 3742 54 3743 0 3744 2 3745 52 3746 57 3747 0 3748 2 3749 53 3750 48 3751 0 3752 1 3753 56 3754 0
63/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
3755 0 3756 1 3757 48 3758 0 3759 0 3760 2 3761 52 3762 56 3763 0 3764 2 3765 52 3766 56 3767 0 3768 2 3769 52 3770 56 3771 0 3772 2 3773 53 3774 50 3775 0 3776 2 3777 52 3778 56 3779 0 3780 2 3781 53 3782 54 3783 0 3784 2 3785 52 3786 57 3787 0 3788 2 3789 53 3790 48 3791 0 3792 1 3793 56 3794 0 3795 0 3796 1 3797 48 3798 0 3799 0 3800 2 3801 53 3802 48 3803 0 3804 2 3805 53 3806 49 3807 0 3808 2 3809 52 3810 56 3811 0 3812 2 3813 53 3814 50
64/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
3815 0 3816 2 3817 52 3818 56 3819 0 3820 2 3821 53 3822 54 3823 0 3824 2 3825 52 3826 57 3827 0 3828 2 3829 53 3830 48 3831 0 3832 1 3833 56 3834 0 3835 0 3836 1 3837 48 3838 0 3839 0 3840 2 3841 53 3842 50 3843 0 3844 2 3845 53 3846 52 3847 0 3848 2 3849 52 3850 56 3851 0 3852 2 3853 53 3854 50 3855 0 3856 2 3857 52 3858 56 3859 0 3860 2 3861 53 3862 54 3863 0 3864 2 3865 52 3866 57 3867 0 3868 2 3869 53 3870 48 3871 0 3872 1 3873 56 3874 0
65/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
3875 0 3876 1 3877 48 3878 0 3879 0 3880 2 3881 53 3882 52 3883 0 3884 2 3885 53 3886 55 3887 0 3888 2 3889 52 3890 56 3891 0 3892 2 3893 53 3894 50 3895 0 3896 2 3897 52 3898 56 3899 0 3900 2 3901 53 3902 54 3903 0 3904 2 3905 52 3906 57 3907 0 3908 2 3909 53 3910 48 3911 0 3912 1 3913 56 3914 0 3915 0 3916 1 3917 48 3918 0 3919 0 3920 2 3921 53 3922 54 3923 0 3924 2 3925 53 3926 48 3927 0 3928 2 3929 52 3930 57 3931 0 3932 2 3933 53 3934 50
66/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
3935 0 3936 2 3937 52 3938 56 3939 0 3940 2 3941 53 3942 54 3943 0 3944 2 3945 52 3946 57 3947 0 3948 2 3949 53 3950 48 3951 0 3952 1 3953 56 3954 0 3955 0 3956 1 3957 48 3958 0 3959 0 3960 2 3961 52 3962 56 3963 0 3964 2 3965 53 3966 52 3967 0 3968 2 3969 52 3970 57 3971 0 3972 2 3973 53 3974 50 3975 0 3976 2 3977 52 3978 56 3979 0 3980 2 3981 53 3982 54 3983 0 3984 2 3985 52 3986 57 3987 0 3988 2 3989 53 3990 48 3991 0 3992 1 3993 56 3994 0
67/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
3995 0 3996 1 3997 48 3998 0 3999 0 4000 2 4001 53 4002 48 4003 0 4004 2 4005 53 4006 55 4007 0 4008 2 4009 52 4010 57 4011 0 4012 2 4013 53 4014 50 4015 0 4016 2 4017 52 4018 56 4019 0 4020 2 4021 53 4022 54 4023 0 4024 2 4025 52 4026 57 4027 0 4028 2 4029 53 4030 48 4031 0 4032 1 4033 56 4034 0 4035 0 4036 1 4037 48 4038 0 4039 0 4040 2 4041 53 4042 50 4043 0 4044 2 4045 53 4046 48 4047 0 4048 2 4049 53 4050 48 4051 0 4052 2 4053 53 4054 50
68/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
4055 0 4056 2 4057 52 4058 56 4059 0 4060 2 4061 53 4062 54 4063 0 4064 2 4065 52 4066 57 4067 0 4068 2 4069 53 4070 48 4071 0 4072 1 4073 56 4074 0 4075 0 4076 1 4077 48 4078 0 4079 0 4080 2 4081 53 4082 52 4083 0 4084 2 4085 53 4086 51 4087 0 4088 2 4089 53 4090 48 4091 0 4092 2 4093 53 4094 50 4095 0 4096 2 4097 52 4098 56 4099 0 4100 2 4101 53 4102 54 4103 0 4104 1 4105 49 4106 0 4107 0 4108 1 4109 48 4110 0 4111 0 4112 2 4113 53 4114 54
69/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
4115 0 4116 2 4117 53 4118 50 4119 0 4120 1 4121 50 4122 0 4123 0 4124 1 4125 48 4126 0 4127 0 4128 1 4129 48 4130 0 4131 0 4132 2 4133 52 4134 56 4135 0 4136 1 4137 49 4138 0 4139 0 4140 1 4141 48 4142 0 4143 0 4144 1 4145 48 4146 0 4147 0 4148 2 4149 52 4150 56 4151 0 4152 1 4153 49 4154 0 4155 0 4156 1 4157 48 4158 0 4159 0 4160 1 4161 48 4162 0 4163 0 4164 2 4165 52 4166 57 4167 0 4168 1 4169 49 4170 0 4171 0 4172 1 4173 48 4174 0
70/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
4175 0 4176 2 4177 53 4178 54 4179 0 4180 2 4181 53 4182 50 4183 0 4184 1 4185 50 4186 0 4187 0 4188 1 4189 48 4190 0 4191 0 4192 1 4193 48 4194 0 4195 0 4196 2 4197 52 4198 56 4199 0 4200 1 4201 49 4202 0 4203 0 4204 1 4205 48 4206 0 4207 0 4208 1 4209 48 4210 0 4211 0 4212 2 4213 52 4214 56 4215 0 4216 1 4217 49 4218 0 4219 0 4220 1 4221 48 4222 0 4223 0 4224 1 4225 48 4226 0 4227 0 4228 2 4229 52 4230 57 4231 0 4232 1 4233 49 4234 0
71/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
4235 0 4236 1 4237 48 4238 0 4239 0 4240 2 4241 53 4242 54 4243 0 4244 2 4245 53 4246 50 4247 0 4248 1 4249 50 4250 0 4251 0 4252 1 4253 48 4254 0 4255 0 4256 1 4257 48 4258 0 4259 0 4260 2 4261 52 4262 56 4263 0 4264 1 4265 49 4266 0 4267 0 4268 1 4269 48 4270 0 4271 0 4272 1 4273 48 4274 0 4275 0 4276 2 4277 52 4278 56 4279 0 4280 1 4281 49 4282 0 4283 0 4284 1 4285 48 4286 0 4287 0 4288 1 4289 48 4290 0 4291 0 4292 2 4293 52 4294 57
72/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
4295 0 4296 1 4297 49 4298 0 4299 0 4300 1 4301 48 4302 0 4303 0 4304 2 4305 53 4306 54 4307 0 4308 2 4309 53 4310 50 4311 0 4312 1 4313 50 4314 0 4315 0 4316 1 4317 48 4318 0 4319 0 4320 1 4321 48 4322 0 4323 0 4324 2 4325 52 4326 56 4327 0 4328 1 4329 49 4330 0 4331 0 4332 1 4333 48 4334 0 4335 0 4336 1 4337 48 4338 0 4339 0 4340 2 4341 52 4342 56 4343 0 4344 1 4345 49 4346 0 4347 0 4348 1 4349 48 4350 0 4351 0 4352 1 4353 48 4354 0
73/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
4355 0 4356 2 4357 52 4358 57 4359 0 4360 1 4361 49 4362 0 4363 0 4364 1 4365 48 4366 0 4367 0 4368 2 4369 53 4370 54 4371 0 4372 2 4373 53 4374 50 4375 0 4376 1 4377 50 4378 0 4379 0 4380 1 4381 48 4382 0 4383 0 4384 1 4385 48 4386 0 4387 0 4388 2 4389 52 4390 56 4391 0 4392 1 4393 49 4394 0 4395 0 4396 1 4397 48 4398 0 4399 0 4400 1 4401 48 4402 0 4403 0 4404 2 4405 52 4406 56 4407 0 4408 1 4409 49 4410 0 4411 0 4412 1 4413 48 4414 0
74/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
4415 0 4416 1 4417 48 4418 0 4419 0 4420 2 4421 52 4422 57 4423 0 4424 1 4425 49 4426 0 4427 0 4428 1 4429 48 4430 0 4431 0 4432 2 4433 53 4434 54 4435 0 4436 2 4437 53 4438 50 4439 0 4440 1 4441 50 4442 0 4443 0 4444 1 4445 48 4446 0 4447 0 4448 1 4449 48 4450 0 4451 0 4452 2 4453 52 4454 56 4455 0 4456 1 4457 49 4458 0 4459 0 4460 1 4461 48 4462 0 4463 0 4464 1 4465 48 4466 0 4467 0 4468 2 4469 52 4470 56 4471 0 4472 1 4473 49 4474 0
75/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
4475 0 4476 1 4477 48 4478 0 4479 0 4480 1 4481 48 4482 0 4483 0 4484 2 4485 52 4486 57 4487 0 4488 1 4489 49 4490 0 4491 0 4492 1 4493 48 4494 0 4495 0 4496 2 4497 53 4498 54 4499 0 4500 2 4501 53 4502 50 4503 0 4504 1 4505 50 4506 0 4507 0 4508 1 4509 48 4510 0 4511 0 4512 1 4513 48 4514 0 4515 0 4516 2 4517 52 4518 56 4519 0 4520 1 4521 49 4522 0 4523 0 4524 1 4525 48 4526 0 4527 0 4528 1 4529 48 4530 0 4531 0 4532 2 4533 52 4534 56
76/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
4535 0 4536 1 4537 49 4538 0 4539 0 4540 1 4541 48 4542 0 4543 0 4544 1 4545 48 4546 0 4547 0 4548 2 4549 52 4550 57 4551 0 4552 1 4553 49 4554 0 4555 0 4556 1 4557 48 4558 0 4559 0 4560 2 4561 53 4562 54 4563 0 4564 2 4565 53 4566 50 4567 0 4568 1 4569 50 4570 0 4571 0 4572 1 4573 48 4574 0 4575 0 4576 1 4577 48 4578 0 4579 0 4580 2 4581 52 4582 56 4583 0 4584 1 4585 49 4586 0 4587 0 4588 1 4589 48 4590 0 4591 0 4592 1 4593 48 4594 0
77/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
4595 0 4596 2 4597 52 4598 56 4599 0 4600 1 4601 49 4602 0 4603 0 4604 1 4605 48 4606 0 4607 0 4608 1 4609 48 4610 0 4611 0 4612 2 4613 52 4614 57 4615 0 4616 1 4617 49 4618 0 4619 0 4620 1 4621 48 4622 0 4623 0 4624 2 4625 53 4626 54 4627 0 4628 2 4629 53 4630 50 4631 0 4632 1 4633 50 4634 0 4635 0 4636 1 4637 48 4638 0 4639 0 4640 1 4641 48 4642 0 4643 0 4644 2 4645 52 4646 56 4647 0 4648 1 4649 49 4650 0 4651 0 4652 1 4653 48 4654 0
78/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
4655 0 4656 1 4657 48 4658 0 4659 0 4660 2 4661 52 4662 56 4663 0 4664 1 4665 49 4666 0 4667 0 4668 1 4669 48 4670 0 4671 0 4672 1 4673 48 4674 0 4675 0 4676 2 4677 52 4678 57 4679 0 4680 1 4681 49 4682 0 4683 0 4684 1 4685 48 4686 0 4687 0 4688 2 4689 53 4690 54 4691 0 4692 2 4693 53 4694 50 4695 0 4696 1 4697 50 4698 0 4699 0 4700 1 4701 48 4702 0 4703 0 4704 1 4705 48 4706 0 4707 0 4708 2 4709 52 4710 56 4711 0 4712 1 4713 49 4714 0
79/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
4715 0 4716 1 4717 48 4718 0 4719 0 4720 1 4721 48 4722 0 4723 0 4724 2 4725 52 4726 56 4727 0 4728 1 4729 49 4730 0 4731 0 4732 1 4733 48 4734 0 4735 0 4736 1 4737 48 4738 0 4739 0 4740 2 4741 52 4742 57 4743 0 4744 1 4745 49 4746 0 4747 0 4748 1 4749 48 4750 0 4751 0 4752 2 4753 53 4754 54 4755 0 4756 2 4757 53 4758 50 4759 0 4760 1 4761 50 4762 0 4763 0 4764 1 4765 48 4766 0 4767 0 4768 1 4769 48 4770 0 4771 0 4772 2 4773 52 4774 56
80/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
4775 0 4776 1 4777 49 4778 0 4779 0 4780 1 4781 48 4782 0 4783 0 4784 1 4785 48 4786 0 4787 0 4788 2 4789 52 4790 56 4791 0 4792 1 4793 49 4794 0 4795 0 4796 1 4797 48 4798 0 4799 0 4800 1 4801 48 4802 0 4803 0 4804 2 4805 52 4806 57 4807 0 4808 1 4809 49 4810 0 4811 0 4812 1 4813 48 4814 0 4815 0 4816 2 4817 53 4818 54 4819 0 4820 2 4821 53 4822 50 4823 0 4824 1 4825 50 4826 0 4827 0 4828 1 4829 48 4830 0 4831 0 4832 1 4833 48 4834 0
81/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
4835 0 4836 2 4837 52 4838 56 4839 0 4840 1 4841 49 4842 0 4843 0 4844 1 4845 48 4846 0 4847 0 4848 1 4849 48 4850 0 4851 0 4852 2 4853 52 4854 56 4855 0 4856 1 4857 49 4858 0 4859 0 4860 1 4861 48 4862 0 4863 0 4864 1 4865 48 4866 0 4867 0 4868 2 4869 52 4870 57 4871 0 4872 1 4873 49 4874 0 4875 0 4876 1 4877 48 4878 0 4879 0 4880 2 4881 53 4882 54 4883 0 4884 2 4885 53 4886 50 4887 0 4888 1 4889 50 4890 0 4891 0 4892 1 4893 48 4894 0
82/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
4895 0 4896 1 4897 48 4898 0 4899 0 4900 2 4901 52 4902 56 4903 0 4904 1 4905 49 4906 0 4907 0 4908 1 4909 48 4910 0 4911 0 4912 1 4913 48 4914 0 4915 0 4916 2 4917 52 4918 56 4919 0 4920 1 4921 49 4922 0 4923 0 4924 1 4925 48 4926 0 4927 0 4928 1 4929 48 4930 0 4931 0 4932 2 4933 52 4934 57 4935 0 4936 1 4937 49 4938 0 4939 0 4940 1 4941 48 4942 0 4943 0 4944 2 4945 53 4946 54 4947 0 4948 2 4949 53 4950 50 4951 0 4952 1 4953 50 4954 0
83/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
4955 0 4956 1 4957 48 4958 0 4959 0 4960 1 4961 48 4962 0 4963 0 4964 2 4965 52 4966 56 4967 0 4968 1 4969 49 4970 0 4971 0 4972 1 4973 48 4974 0 4975 0 4976 1 4977 48 4978 0 4979 0 4980 2 4981 52 4982 56 4983 0 4984 1 4985 49 4986 0 4987 0 4988 1 4989 48 4990 0 4991 0 4992 1 4993 48 4994 0 4995 0 4996 2 4997 52 4998 57 4999 0 5000 1 5001 49 5002 0 5003 0 5004 1 5005 48 5006 0 5007 0 5008 2 5009 53 5010 54 5011 0 5012 2 5013 53 5014 50
84/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
5015 0 5016 1 5017 50 5018 0 5019 0 5020 1 5021 48 5022 0 5023 0 5024 1 5025 48 5026 0 5027 0 5028 2 5029 52 5030 56 5031 0 5032 1 5033 49 5034 0 5035 0 5036 1 5037 48 5038 0 5039 0 5040 1 5041 48 5042 0 5043 0 5044 2 5045 52 5046 56 5047 0 5048 1 5049 49 5050 0 5051 0 5052 1 5053 48 5054 0 5055 0 5056 1 5057 48 5058 0 5059 0 5060 2 5061 52 5062 57 5063 0 5064 1 5065 49 5066 0 5067 0 5068 1 5069 48 5070 0 5071 0 5072 2 5073 53 5074 54
85/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
5075 0 5076 2 5077 53 5078 50 5079 0 5080 1 5081 50 5082 0 5083 0 5084 1 5085 48 5086 0 5087 0 5088 1 5089 48 5090 0 5091 0 5092 2 5093 52 5094 56 5095 0 5096 1 5097 49 5098 0 5099 0 5100 1 5101 48 5102 0 5103 0 5104 1 5105 48 5106 0 5107 0 5108 2 5109 52 5110 56 5111 0 5112 1 5113 49 5114 0 5115 0 5116 1 5117 48 5118 0 5119 0 5120 1 5121 48 5122 0 5123 0 5124 2 5125 52 5126 57 5127 0 5128 1 5129 49 5130 0 5131 0 5132 1 5133 48 5134 0
86/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
5135 0 5136 2 5137 53 5138 54 5139 0 5140 2 5141 53 5142 50 5143 0 5144 1 5145 50 5146 0 5147 0 5148 1 5149 48 5150 0 5151 0 5152 1 5153 48 5154 0 5155 0 5156 2 5157 52 5158 56 5159 0 5160 1 5161 49 5162 0 5163 0 5164 1 5165 48 5166 0 5167 0 5168 1 5169 48 5170 0 5171 0 5172 2 5173 52 5174 56 5175 0 5176 1 5177 49 5178 0 5179 0 5180 1 5181 48 5182 0 5183 0 5184 1 5185 48 5186 0 5187 0 5188 2 5189 52 5190 57 5191 0 5192 1 5193 49 5194 0
87/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
5195 0 5196 1 5197 48 5198 0 5199 0 5200 2 5201 53 5202 54 5203 0 5204 2 5205 53 5206 50 5207 0 5208 1 5209 50 5210 0 5211 0 5212 1 5213 48 5214 0 5215 0 5216 1 5217 48 5218 0 5219 0 5220 2 5221 52 5222 56 5223 0 5224 1 5225 49 5226 0 5227 0 5228 1 5229 48 5230 0 5231 0 5232 1 5233 48 5234 0 5235 0 5236 2 5237 52 5238 56 5239 0 5240 1 5241 49 5242 0 5243 0 5244 1 5245 48 5246 0 5247 0 5248 1 5249 48 5250 0 5251 0 5252 2 5253 52 5254 57
88/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
5255 0 5256 1 5257 49 5258 0 5259 0 5260 1 5261 48 5262 0 5263 0 5264 2 5265 53 5266 54 5267 0 5268 2 5269 53 5270 50 5271 0 5272 1 5273 50 5274 0 5275 0 5276 1 5277 48 5278 0 5279 0 5280 1 5281 48 5282 0 5283 0 5284 2 5285 52 5286 56 5287 0 5288 1 5289 49 5290 0 5291 0 5292 1 5293 48 5294 0 5295 0 5296 1 5297 48 5298 0 5299 0 5300 2 5301 52 5302 56 5303 0 5304 1 5305 49 5306 0 5307 0 5308 1 5309 48 5310 0 5311 0 5312 1 5313 48 5314 0
89/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
5315 0 5316 2 5317 52 5318 57 5319 0 5320 1 5321 49 5322 0 5323 0 5324 1 5325 48 5326 0 5327 0 5328 2 5329 53 5330 54 5331 0 5332 2 5333 53 5334 50 5335 0 5336 1 5337 50 5338 0 5339 0 5340 1 5341 48 5342 0 5343 0 5344 1 5345 48 5346 0 5347 0 5348 2 5349 52 5350 56 5351 0 5352 1 5353 49 5354 0 5355 0 5356 1 5357 48 5358 0 5359 0 5360 1 5361 48 5362 0 5363 0 5364 2 5365 52 5366 56 5367 0 5368 1 5369 49 5370 0 5371 0 5372 1 5373 48 5374 0
90/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
5375 0 5376 1 5377 48 5378 0 5379 0 5380 2 5381 52 5382 57 5383 0 5384 1 5385 49 5386 0 5387 0 5388 1 5389 48 5390 0 5391 0 5392 2 5393 53 5394 54 5395 0 5396 2 5397 53 5398 50 5399 0 5400 1 5401 50 5402 0 5403 0 5404 1 5405 48 5406 0 5407 0 5408 1 5409 48 5410 0 5411 0 5412 2 5413 52 5414 56 5415 0 5416 1 5417 49 5418 0 5419 0 5420 1 5421 48 5422 0 5423 0 5424 1 5425 48 5426 0 5427 0 5428 2 5429 52 5430 56 5431 0 5432 1 5433 49 5434 0
91/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
5435 0 5436 1 5437 48 5438 0 5439 0 5440 1 5441 48 5442 0 5443 0 5444 2 5445 52 5446 57 5447 0 5448 1 5449 49 5450 0 5451 0 5452 1 5453 48 5454 0 5455 0 5456 2 5457 53 5458 54 5459 0 5460 2 5461 53 5462 50 5463 0 5464 1 5465 50 5466 0 5467 0 5468 1 5469 48 5470 0 5471 0 5472 1 5473 48 5474 0 5475 0 5476 2 5477 52 5478 56 5479 0 5480 1 5481 49 5482 0 5483 0 5484 1 5485 48 5486 0 5487 0 5488 1 5489 48 5490 0 5491 0 5492 2 5493 52 5494 56
92/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
5495 0 5496 1 5497 49 5498 0 5499 0 5500 1 5501 48 5502 0 5503 0 5504 1 5505 48 5506 0 5507 0 5508 2 5509 52 5510 57 5511 0 5512 1 5513 49 5514 0 5515 0 5516 1 5517 48 5518 0 5519 0 5520 2 5521 53 5522 54 5523 0 5524 2 5525 53 5526 50 5527 0 5528 1 5529 50 5530 0 5531 0 5532 1 5533 48 5534 0 5535 0 5536 1 5537 48 5538 0 5539 0 5540 2 5541 52 5542 56 5543 0 5544 1 5545 49 5546 0 5547 0 5548 1 5549 48 5550 0 5551 0 5552 1 5553 48 5554 0
93/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
5555 0 5556 2 5557 52 5558 56 5559 0 5560 1 5561 49 5562 0 5563 0 5564 1 5565 48 5566 0 5567 0 5568 1 5569 48 5570 0 5571 0 5572 2 5573 52 5574 57 5575 0 5576 1 5577 49 5578 0 5579 0 5580 1 5581 48 5582 0 5583 0 5584 2 5585 53 5586 54 5587 0 5588 2 5589 53 5590 50 5591 0 5592 1 5593 50 5594 0 5595 0 5596 1 5597 48 5598 0 5599 0 5600 1 5601 48 5602 0 5603 0 5604 2 5605 52 5606 56 5607 0 5608 1 5609 49 5610 0 5611 0 5612 1 5613 48 5614 0
94/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
5615 0 5616 1 5617 48 5618 0 5619 0 5620 2 5621 52 5622 56 5623 0 5624 1 5625 49 5626 0 5627 0 5628 1 5629 48 5630 0 5631 0 5632 1 5633 48 5634 0 5635 0 5636 2 5637 52 5638 57 5639 0 5640 1 5641 49 5642 0 5643 0 5644 1 5645 48 5646 0 5647 0 5648 1 5649 48 5650 0 5651 0 5652 2 5653 52 5654 56 5655 0 5656 1 5657 49 5658 0 5659 0 5660 1 5661 48 5662 0 5663 0 5664 1 5665 48 5666 0 5667 0 5668 2 5669 52 5670 56 5671 0 5672 1 5673 49 5674 0
95/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
5675 0 5676 1 5677 48 5678 0 5679 0 5680 1 5681 48 5682 0 5683 0 5684 2 5685 52 5686 56 5687 0 5688 1 5689 49 5690 0 5691 0 5692 1 5693 48 5694 0 5695 0 5696 1 5697 48 5698 0 5699 0 5700 2 5701 52 5702 56 5703 0 5704 1 5705 49 5706 0 5707 0 5708 1 5709 48 5710 0 5711 0 5712 1 5713 48 5714 0 5715 0 5716 2 5717 52 5718 56 5719 0 5720 1 5721 49 5722 0 5723 0 5724 1 5725 48 5726 0 5727 0 5728 1 5729 48 5730 0 5731 0 5732 2 5733 52 5734 56
96/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
5735 0 5736 1 5737 49 5738 0 5739 0 5740 1 5741 48 5742 0 5743 0 5744 1 5745 48 5746 0 5747 0 5748 2 5749 52 5750 56 5751 0 5752 1 5753 49 5754 0 5755 0 5756 1 5757 48 5758 0 5759 0 5760 1 5761 48 5762 0 5763 0 5764 2 5765 52 5766 57 5767 0 5768 1 5769 49 5770 0 5771 0 5772 1 5773 48 5774 0 5775 0 5776 2 5777 53 5778 54 5779 0 5780 2 5781 53 5782 50 5783 0 5784 1 5785 50 5786 0 5787 0 5788 1 5789 48 5790 0 5791 0 5792 1 5793 48 5794 0
97/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
5795 0 5796 2 5797 52 5798 56 5799 0 5800 1 5801 49 5802 0 5803 0 5804 1 5805 48 5806 0 5807 0 5808 1 5809 48 5810 0 5811 0 5812 2 5813 52 5814 56 5815 0 5816 1 5817 49 5818 0 5819 0 5820 1 5821 48 5822 0 5823 0 5824 1 5825 48 5826 0 5827 0 5828 2 5829 52 5830 57 5831 0 5832 1 5833 49 5834 0 5835 0 5836 1 5837 48 5838 0 5839 0 5840 2 5841 53 5842 54 5843 0 5844 2 5845 53 5846 50 5847 0 5848 1 5849 50 5850 0 5851 0 5852 1 5853 48 5854 0
98/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
5855 0 5856 1 5857 48 5858 0 5859 0 5860 2 5861 52 5862 56 5863 0 5864 1 5865 49 5866 0 5867 0 5868 1 5869 48 5870 0 5871 0 5872 1 5873 48 5874 0 5875 0 5876 2 5877 52 5878 56 5879 0 5880 1 5881 49 5882 0 5883 0 5884 1 5885 48 5886 0 5887 0 5888 1 5889 48 5890 0 5891 0 5892 2 5893 52 5894 57 5895 0 5896 1 5897 49 5898 0 5899 0 5900 1 5901 48 5902 0 5903 0 5904 2 5905 53 5906 54 5907 0 5908 2 5909 53 5910 50 5911 0 5912 1 5913 50 5914 0
99/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
5915 0 5916 1 5917 48 5918 0 5919 0 5920 1 5921 48 5922 0 5923 0 5924 2 5925 52 5926 56 5927 0 5928 1 5929 49 5930 0 5931 0 5932 1 5933 48 5934 0 5935 0 5936 1 5937 48 5938 0 5939 0 5940 2 5941 52 5942 56 5943 0 5944 1 5945 49 5946 0 5947 0 5948 1 5949 48 5950 0 5951 0 5952 1 5953 48 5954 0 5955 0 5956 2 5957 52 5958 57 5959 0 5960 1 5961 49 5962 0 5963 0 5964 1 5965 48 5966 0 5967 0 5968 2 5969 53 5970 54 5971 0 5972 2 5973 53 5974 50
100/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
5975 0 5976 1 5977 50 5978 0 5979 0 5980 1 5981 48 5982 0 5983 0 5984 1 5985 48 5986 0 5987 0 5988 2 5989 52 5990 56 5991 0 5992 1 5993 49 5994 0 5995 0 5996 1 5997 48 5998 0 5999 0 6000 1 6001 48 6002 0 6003 0 6004 2 6005 52 6006 56 6007 0 6008 1 6009 49 6010 0 6011 0 6012 1 6013 48 6014 0 6015 0 6016 1 6017 48 6018 0 6019 0 6020 2 6021 52 6022 57 6023 0 6024 1 6025 49 6026 0 6027 0 6028 1 6029 48 6030 0 6031 0 6032 2 6033 53 6034 54
101/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
6035 0 6036 2 6037 53 6038 50 6039 0 6040 1 6041 50 6042 0 6043 0 6044 1 6045 48 6046 0 6047 0 6048 1 6049 48 6050 0 6051 0 6052 2 6053 52 6054 56 6055 0 6056 1 6057 49 6058 0 6059 0 6060 1 6061 48 6062 0 6063 0 6064 1 6065 48 6066 0 6067 0 6068 2 6069 52 6070 56 6071 0 6072 1 6073 49 6074 0 6075 0 6076 1 6077 48 6078 0 6079 0 6080 1 6081 48 6082 0 6083 0 6084 2 6085 52 6086 57 6087 0 6088 1 6089 49 6090 0 6091 0 6092 1 6093 48 6094 0
102/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
6095 0 6096 2 6097 53 6098 54 6099 0 6100 2 6101 53 6102 50 6103 0 6104 1 6105 50 6106 0 6107 0 6108 1 6109 48 6110 0 6111 0 6112 1 6113 48 6114 0 6115 0 6116 2 6117 52 6118 56 6119 0 6120 1 6121 49 6122 0 6123 0 6124 1 6125 48 6126 0 6127 0 6128 1 6129 48 6130 0 6131 0 6132 2 6133 52 6134 56 6135 0 6136 1 6137 49 6138 0 6139 0 6140 1 6141 48 6142 0 6143 0 6144 1 6145 48 6146 0 6147 0 6148 2 6149 52 6150 57 6151 0 6152 0 6153 0 6154 0
103/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
6155 0 6156 0 6157 0 6158 0 6159 0 6160 0 6161 0 6162 0 6163 0 6164 0 6165 0 6166 0 6167 0 6168 0 6169 0 6170 0 6171 0 6172 0 6173 0 6174 0 6175 0 6176 0 6177 0 6178 0 6179 0 6180 0 6181 0 6182 0 6183 0 6184 0 6185 0 6186 0 6187 0 6188 0 6189 0 6190 0 6191 0 6192 0 6193 0 6194 0 6195 0 6196 0 6197 0 6198 0 6199 0 6200 0 6201 0 6202 0 6203 0 6204 0 6205 0 6206 0 6207 0 6208 0 6209 0 6210 0 6211 0 6212 0 6213 0 6214 0
104/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
6215 0 6216 0 6217 0 6218 0 6219 0 6220 0 6221 0 6222 0 6223 0 6224 0 6225 0 6226 0 6227 0 6228 0 6229 0 6230 0 6231 0 6232 0 6233 0 6234 0 6235 0 6236 0 6237 0 6238 0 6239 0 6240 0 6241 0 6242 0 6243 0 6244 0 6245 0 6246 0 6247 0 6248 0 6249 0 6250 0 6251 0 6252 0 6253 0 6254 0 6255 0 6256 0 6257 0 6258 0 6259 0 6260 0 6261 0 6262 0 6263 0 6264 0 6265 0 6266 0 6267 0 6268 0 6269 0 6270 0 6271 0 6272 0 6273 0 6274 0
105/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
6275 0 6276 0 6277 0 6278 0 6279 0 6280 0 6281 0 6282 0 6283 0 6284 0 6285 0 6286 0 6287 0 6288 0 6289 0 6290 0 6291 0 6292 0 6293 0 6294 0 6295 0 6296 0 6297 0 6298 0 6299 0 6300 0 6301 0 6302 0 6303 0 6304 0 6305 0 6306 0 6307 0 6308 0 6309 0 6310 0 6311 0 6312 0 6313 0 6314 0 6315 0 6316 0 6317 0 6318 0 6319 0 6320 0 6321 0 6322 0 6323 0 6324 0 6325 0 6326 0 6327 0 6328 0 6329 0 6330 0 6331 0 6332 0 6333 0 6334 0
106/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
6335 0 6336 0 6337 0 6338 0 6339 0 6340 0 6341 0 6342 0 6343 0 6344 0 6345 0 6346 0 6347 0 6348 0 6349 0 6350 0 6351 0 6352 0 6353 0 6354 0 6355 0 6356 0 6357 0 6358 0 6359 0 6360 0 6361 0 6362 0 6363 0 6364 0 6365 0 6366 0 6367 0 6368 0 6369 0 6370 0 6371 0 6372 0 6373 0 6374 0 6375 0 6376 0 6377 0 6378 0 6379 0 6380 0 6381 0 6382 0 6383 0 6384 0 6385 0 6386 0 6387 0 6388 0 6389 0 6390 0 6391 0 6392 0 6393 0 6394 0
107/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
6395 0 6396 0 6397 0 6398 0 6399 0 6400 0 6401 0 6402 0 6403 0 6404 0 6405 0 6406 0 6407 0 6408 0 6409 0 6410 0 6411 0 6412 0 6413 0 6414 0 6415 0 6416 0 6417 0 6418 0 6419 0 6420 0 6421 0 6422 0 6423 0 6424 0 6425 0 6426 0 6427 0 6428 0 6429 0 6430 0 6431 0 6432 0 6433 0 6434 0 6435 0 6436 0 6437 0 6438 0 6439 0 6440 0 6441 0 6442 0 6443 0 6444 0 6445 0 6446 0 6447 0 6448 0 6449 0 6450 0 6451 0 6452 0 6453 0 6454 0
108/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
6455 0 6456 0 6457 0 6458 0 6459 0 6460 0 6461 0 6462 0 6463 0 6464 0 6465 0 6466 0 6467 0 6468 0 6469 0 6470 0 6471 0 6472 0 6473 0 6474 0 6475 0 6476 0 6477 0 6478 0 6479 0 6480 0 6481 0 6482 0 6483 0 6484 0 6485 0 6486 0 6487 0 6488 0 6489 0 6490 0 6491 0 6492 0 6493 0 6494 0 6495 0 6496 0 6497 0 6498 0 6499 0 6500 0 6501 0 6502 0 6503 0 6504 0 6505 0 6506 0 6507 0 6508 0 6509 0 6510 0 6511 0 6512 0 6513 0 6514 0
109/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
6515 0 6516 0 6517 0 6518 0 6519 0 6520 0 6521 0 6522 0 6523 0 6524 0 6525 0 6526 0 6527 0 6528 0 6529 0 6530 0 6531 0 6532 0 6533 0 6534 0 6535 0 6536 0 6537 0 6538 0 6539 0 6540 0 6541 0 6542 0 6543 0 6544 0 6545 0 6546 0 6547 0 6548 0 6549 0 6550 0 6551 0 6552 0 6553 0 6554 0 6555 0 6556 0 6557 0 6558 0 6559 0 6560 0 6561 0 6562 0 6563 0 6564 0 6565 0 6566 0 6567 0 6568 0 6569 0 6570 0 6571 0 6572 0 6573 0 6574 0
110/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
6575 0 6576 0 6577 0 6578 0 6579 0 6580 0 6581 0 6582 0 6583 0 6584 0 6585 0 6586 0 6587 0 6588 0 6589 0 6590 0 6591 0 6592 0 6593 0 6594 0 6595 0 6596 0 6597 0 6598 0 6599 0 6600 0 6601 0 6602 0 6603 0 6604 0 6605 0 6606 0 6607 0 6608 0 6609 0 6610 0 6611 0 6612 0 6613 0 6614 0 6615 0 6616 0 6617 0 6618 0 6619 0 6620 0 6621 0 6622 0 6623 0 6624 0 6625 0 6626 0 6627 0 6628 0 6629 0 6630 0 6631 0 6632 0 6633 0 6634 0
111/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
6635 0 6636 0 6637 0 6638 0 6639 0 6640 0 6641 0 6642 0 6643 0 6644 0 6645 0 6646 0 6647 0 6648 0 6649 0 6650 0 6651 0 6652 0 6653 0 6654 0 6655 0 6656 0 6657 0 6658 0 6659 0 6660 0 6661 0 6662 0 6663 0 6664 2 6665 53 6666 54 6667 0 6668 0 6669 0 6670 1 6671 49 6672 0 6673 0 6674 0 6675 0 6676 1 6677 48 6678 0 6679 0 6680 0 6681 0 6682 2 6683 52 6684 56 6685 0 6686 0 6687 0 6688 2 6689 53 6690 51 6691 0 6692 0 6693 0 6694 1
112/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
6695 50 6696 0 6697 0 6698 0 6699 0 6700 1 6701 48 6702 0 6703 0 6704 0 6705 0 6706 2 6707 53 6708 55 6709 0 6710 0 6711 0 6712 2 6713 53 6714 50 6715 0 6716 0 6717 0 6718 1 6719 50 6720 0 6721 0 6722 0 6723 0 6724 1 6725 48 6726 0 6727 0 6728 0 6729 0 6730 2 6731 53 6732 52 6733 0 6734 0 6735 0 6736 2 6737 53 6738 51 6739 0 6740 0 6741 0 6742 1 6743 50 6744 0 6745 0 6746 0 6747 0 6748 1 6749 48 6750 0 6751 0 6752 0 6753 0 6754 2
113/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
6755 53 6756 54 6757 0 6758 0 6759 0 6760 2 6761 53 6762 50 6763 0 6764 0 6765 0 6766 1 6767 50 6768 0 6769 0 6770 0 6771 0 6772 1 6773 48 6774 0 6775 0 6776 0 6777 0 6778 2 6779 53 6780 48 6781 0 6782 0 6783 0 6784 2 6785 53 6786 51 6787 0 6788 0 6789 0 6790 1 6791 50 6792 0 6793 0 6794 0 6795 0 6796 1 6797 48 6798 0 6799 0 6800 0 6801 0 6802 2 6803 53 6804 49 6805 0 6806 0 6807 0 6808 2 6809 53 6810 51 6811 0 6812 0 6813 0 6814 1
114/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
6815 50 6816 0 6817 0 6818 0 6819 0 6820 1 6821 48 6822 0 6823 0 6824 0 6825 0 6826 2 6827 53 6828 48 6829 0 6830 0 6831 0 6832 2 6833 53 6834 51 6835 0 6836 0 6837 0 6838 1 6839 50 6840 0 6841 0 6842 0 6843 0 6844 1 6845 48 6846 0 6847 0 6848 0 6849 0 6850 2 6851 53 6852 48 6853 0 6854 0 6855 0 6856 2 6857 53 6858 51 6859 0 6860 0 6861 0 6862 1 6863 50 6864 0 6865 0 6866 0 6867 0 6868 1 6869 48 6870 0 6871 0 6872 0 6873 0 6874 1
115/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
6875 48 6876 0 6877 0 6878 0 6879 0 6880 2 6881 52 6882 56 6883 0 6884 0 6885 0 6886 1 6887 49 6888 0 6889 0 6890 0 6891 0 6892 1 6893 48 6894 0 6895 0 6896 0 6897 0 6898 1 6899 48 6900 0 6901 0 6902 0 6903 0 6904 2 6905 53 6906 54 6907 0 6908 0 6909 0 6910 1 6911 49 6912 0 6913 0 6914 0 6915 0 6916 1 6917 48 6918 0 6919 0 6920 0 6921 0 6922 2 6923 52 6924 56 6925 0 6926 0 6927 0 6928 2 6929 53 6930 51 6931 0 6932 0 6933 0 6934 1
116/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
6935 50 6936 0 6937 0 6938 0 6939 0 6940 1 6941 48 6942 0 6943 0 6944 0 6945 0 6946 2 6947 53 6948 55 6949 0 6950 0 6951 0 6952 2 6953 53 6954 50 6955 0 6956 0 6957 0 6958 1 6959 50 6960 0 6961 0 6962 0 6963 0 6964 1 6965 48 6966 0 6967 0 6968 0 6969 0 6970 2 6971 53 6972 52 6973 0 6974 0 6975 0 6976 2 6977 53 6978 51 6979 0 6980 0 6981 0 6982 1 6983 50 6984 0 6985 0 6986 0 6987 0 6988 1 6989 48 6990 0 6991 0 6992 0 6993 0 6994 2
117/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
6995 53 6996 54 6997 0 6998 0 6999 0 7000 2 7001 53 7002 50 7003 0 7004 0 7005 0 7006 1 7007 50 7008 0 7009 0 7010 0 7011 0 7012 1 7013 48 7014 0 7015 0 7016 0 7017 0 7018 2 7019 53 7020 48 7021 0 7022 0 7023 0 7024 2 7025 53 7026 51 7027 0 7028 0 7029 0 7030 1 7031 50 7032 0 7033 0 7034 0 7035 0 7036 1 7037 48 7038 0 7039 0 7040 0 7041 0 7042 2 7043 53 7044 49 7045 0 7046 0 7047 0 7048 2 7049 53 7050 51 7051 0 7052 0 7053 0 7054 1
118/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
7055 50 7056 0 7057 0 7058 0 7059 0 7060 1 7061 48 7062 0 7063 0 7064 0 7065 0 7066 2 7067 53 7068 55 7069 0 7070 0 7071 0 7072 2 7073 53 7074 50 7075 0 7076 0 7077 0 7078 1 7079 50 7080 0 7081 0 7082 0 7083 0 7084 1 7085 48 7086 0 7087 0 7088 0 7089 0 7090 2 7091 52 7092 56 7093 0 7094 0 7095 0 7096 2 7097 53 7098 51 7099 0 7100 0 7101 0 7102 1 7103 50 7104 0 7105 0 7106 0 7107 0 7108 1 7109 48 7110 0 7111 0 7112 0 7113 0 7114 1
119/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
7115 48 7116 0 7117 0 7118 0 7119 0 7120 2 7121 52 7122 56 7123 0 7124 0 7125 0 7126 1 7127 49 7128 0 7129 0 7130 0 7131 0 7132 1 7133 48 7134 0 7135 0 7136 0 7137 0 7138 1 7139 48 7140 0 7141 0 7142 0 7143 0 7144 2 7145 53 7146 54 7147 0 7148 0 7149 0 7150 1 7151 49 7152 0 7153 0 7154 0 7155 0 7156 1 7157 48 7158 0 7159 0 7160 0 7161 0 7162 2 7163 52 7164 56 7165 0 7166 0 7167 0 7168 2 7169 52 7170 56 7171 0 7172 0 7173 0 7174 0
120/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
7175 0 7176 2 7177 52 7178 57 7179 0 7180 1 7181 49 7182 0 7183 0 7184 1 7185 48 7186 0 7187 0 7188 2 7189 53 7190 54 7191 0 7192 2 7193 53 7194 50 7195 0 7196 1 7197 50 7198 0 7199 0 7200 1 7201 48 7202 0 7203 0 7204 1 7205 48 7206 0 7207 0 7208 2 7209 52 7210 56 7211 0 7212 1 7213 49 7214 0 7215 0 7216 1 7217 48 7218 0 7219 0 7220 1 7221 48 7222 0 7223 0 7224 2 7225 52 7226 56 7227 0 7228 1 7229 49 7230 0 7231 0 7232 1 7233 48 7234 0
121/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
7235 0 7236 1 7237 48 7238 0 7239 0 7240 2 7241 52 7242 57 7243 0 7244 1 7245 49 7246 0 7247 0 7248 1 7249 48 7250 0 7251 0 7252 2 7253 53 7254 54 7255 0 7256 2 7257 53 7258 50 7259 0 7260 1 7261 50 7262 0 7263 0 7264 1 7265 48 7266 0 7267 0 7268 1 7269 48 7270 0 7271 0 7272 2 7273 52 7274 56 7275 0 7276 1 7277 49 7278 0 7279 0 7280 1 7281 48 7282 0 7283 0 7284 1 7285 48 7286 0 7287 0 7288 2 7289 52 7290 56 7291 0 7292 1 7293 49 7294 0
122/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
7295 0 7296 1 7297 48 7298 0 7299 0 7300 1 7301 48 7302 0 7303 0 7304 2 7305 52 7306 57 7307 0 7308 1 7309 49 7310 0 7311 0 7312 1 7313 48 7314 0 7315 0 7316 2 7317 53 7318 54 7319 0 7320 2 7321 53 7322 50 7323 0 7324 1 7325 50 7326 0 7327 0 7328 1 7329 48 7330 0 7331 0 7332 1 7333 48 7334 0 7335 0 7336 2 7337 52 7338 56 7339 0 7340 1 7341 49 7342 0 7343 0 7344 1 7345 48 7346 0 7347 0 7348 1 7349 48 7350 0 7351 0 7352 2 7353 52 7354 56
123/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
7355 0 7356 1 7357 49 7358 0 7359 0 7360 1 7361 48 7362 0 7363 0 7364 1 7365 48 7366 0 7367 0 7368 2 7369 52 7370 57 7371 0 7372 1 7373 49 7374 0 7375 0 7376 1 7377 48 7378 0 7379 0 7380 2 7381 53 7382 54 7383 0 7384 2 7385 53 7386 50 7387 0 7388 1 7389 50 7390 0 7391 0 7392 1 7393 48 7394 0 7395 0 7396 1 7397 48 7398 0 7399 0 7400 2 7401 52 7402 56 7403 0 7404 1 7405 49 7406 0 7407 0 7408 1 7409 48 7410 0 7411 0 7412 1 7413 48 7414 0
124/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
7415 0 7416 2 7417 52 7418 56 7419 0 7420 1 7421 49 7422 0 7423 0 7424 1 7425 48 7426 0 7427 0 7428 1 7429 48 7430 0 7431 0 7432 2 7433 52 7434 57 7435 0 7436 1 7437 49 7438 0 7439 0 7440 1 7441 48 7442 0 7443 0 7444 2 7445 53 7446 54 7447 0 7448 2 7449 53 7450 50 7451 0 7452 1 7453 50 7454 0 7455 0 7456 1 7457 48 7458 0 7459 0 7460 1 7461 48 7462 0 7463 0 7464 2 7465 52 7466 56 7467 0 7468 1 7469 49 7470 0 7471 0 7472 1 7473 48 7474 0
125/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
7475 0 7476 1 7477 48 7478 0 7479 0 7480 2 7481 52 7482 56 7483 0 7484 1 7485 49 7486 0 7487 0 7488 1 7489 48 7490 0 7491 0 7492 1 7493 48 7494 0 7495 0 7496 2 7497 52 7498 57 7499 0 7500 1 7501 49 7502 0 7503 0 7504 1 7505 48 7506 0 7507 0 7508 2 7509 53 7510 54 7511 0 7512 2 7513 53 7514 50 7515 0 7516 1 7517 50 7518 0 7519 0 7520 1 7521 48 7522 0 7523 0 7524 1 7525 48 7526 0 7527 0 7528 2 7529 52 7530 56 7531 0 7532 1 7533 49 7534 0
126/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
7535 0 7536 1 7537 48 7538 0 7539 0 7540 1 7541 48 7542 0 7543 0 7544 2 7545 52 7546 56 7547 0 7548 1 7549 49 7550 0 7551 0 7552 1 7553 48 7554 0 7555 0 7556 1 7557 48 7558 0 7559 0 7560 2 7561 52 7562 56 7563 0 7564 1 7565 49 7566 0 7567 0 7568 1 7569 48 7570 0 7571 0 7572 1 7573 48 7574 0 7575 0 7576 2 7577 52 7578 56 7579 0 7580 1 7581 49 7582 0 7583 0 7584 1 7585 48 7586 0 7587 0 7588 1 7589 48 7590 0 7591 0 7592 2 7593 52 7594 56
127/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
7595 0 7596 1 7597 49 7598 0 7599 0 7600 1 7601 48 7602 0 7603 0 7604 1 7605 48 7606 0 7607 0 7608 2 7609 52 7610 56 7611 0 7612 1 7613 49 7614 0 7615 0 7616 1 7617 48 7618 0 7619 0 7620 1 7621 48 7622 0 7623 0 7624 2 7625 52 7626 56 7627 0 7628 1 7629 49 7630 0 7631 0 7632 1 7633 48 7634 0 7635 0 7636 1 7637 48 7638 0 7639 0 7640 2 7641 52 7642 56 7643 0 7644 1 7645 49 7646 0 7647 0 7648 1 7649 48 7650 0 7651 0 7652 1 7653 48 7654 0
128/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
7655 0 7656 2 7657 52 7658 56 7659 0 7660 1 7661 49 7662 0 7663 0 7664 1 7665 48 7666 0 7667 0 7668 1 7669 48 7670 0 7671 0 7672 2 7673 52 7674 56 7675 0 7676 1 7677 49 7678 0 7679 0 7680 1 7681 48 7682 0 7683 0 7684 1 7685 48 7686 0 7687 0 7688 2 7689 52 7690 57 7691 0 7692 1 7693 49 7694 0 7695 0 7696 1 7697 48 7698 0 7699 0 7700 2 7701 53 7702 54 7703 0 7704 2 7705 53 7706 50 7707 0 7708 1 7709 50 7710 0 7711 0 7712 1 7713 48 7714 0
129/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
7715 0 7716 1 7717 48 7718 0 7719 0 7720 2 7721 52 7722 56 7723 0 7724 1 7725 49 7726 0 7727 0 7728 1 7729 48 7730 0 7731 0 7732 1 7733 48 7734 0 7735 0 7736 2 7737 52 7738 56 7739 0 7740 1 7741 49 7742 0 7743 0 7744 1 7745 48 7746 0 7747 0 7748 1 7749 48 7750 0 7751 0 7752 2 7753 52 7754 57 7755 0 7756 1 7757 49 7758 0 7759 0 7760 1 7761 48 7762 0 7763 0 7764 2 7765 53 7766 54 7767 0 7768 2 7769 53 7770 50 7771 0 7772 1 7773 50 7774 0
130/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
7775 0 7776 1 7777 48 7778 0 7779 0 7780 1 7781 48 7782 0 7783 0 7784 2 7785 52 7786 56 7787 0 7788 1 7789 49 7790 0 7791 0 7792 1 7793 48 7794 0 7795 0 7796 1 7797 48 7798 0 7799 0 7800 2 7801 52 7802 56 7803 0 7804 1 7805 49 7806 0 7807 0 7808 1 7809 48 7810 0 7811 0 7812 1 7813 48 7814 0 7815 0 7816 2 7817 52 7818 57 7819 0 7820 1 7821 49 7822 0 7823 0 7824 1 7825 48 7826 0 7827 0 7828 2 7829 53 7830 54 7831 0 7832 2 7833 53 7834 50
131/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
7835 0 7836 1 7837 50 7838 0 7839 0 7840 1 7841 48 7842 0 7843 0 7844 1 7845 48 7846 0 7847 0 7848 2 7849 52 7850 56 7851 0 7852 1 7853 49 7854 0 7855 0 7856 1 7857 48 7858 0 7859 0 7860 1 7861 48 7862 0 7863 0 7864 2 7865 52 7866 56 7867 0 7868 1 7869 49 7870 0 7871 0 7872 1 7873 48 7874 0 7875 0 7876 1 7877 48 7878 0 7879 0 7880 2 7881 52 7882 57 7883 0 7884 1 7885 49 7886 0 7887 0 7888 1 7889 48 7890 0 7891 0 7892 2 7893 53 7894 54
132/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
7895 0 7896 2 7897 53 7898 50 7899 0 7900 1 7901 50 7902 0 7903 0 7904 1 7905 48 7906 0 7907 0 7908 1 7909 48 7910 0 7911 0 7912 2 7913 52 7914 56 7915 0 7916 1 7917 49 7918 0 7919 0 7920 1 7921 48 7922 0 7923 0 7924 1 7925 48 7926 0 7927 0 7928 2 7929 52 7930 56 7931 0 7932 1 7933 49 7934 0 7935 0 7936 1 7937 48 7938 0 7939 0 7940 1 7941 48 7942 0 7943 0 7944 2 7945 52 7946 57 7947 0 7948 1 7949 49 7950 0 7951 0 7952 1 7953 48 7954 0
133/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
7955 0 7956 2 7957 53 7958 54 7959 0 7960 2 7961 53 7962 50 7963 0 7964 1 7965 50 7966 0 7967 0 7968 1 7969 48 7970 0 7971 0 7972 1 7973 48 7974 0 7975 0 7976 2 7977 52 7978 56 7979 0 7980 1 7981 49 7982 0 7983 0 7984 1 7985 48 7986 0 7987 0 7988 1 7989 48 7990 0 7991 0 7992 2 7993 52 7994 56 7995 0 7996 1 7997 49 7998 0 7999 0 8000 1 8001 48 8002 0 8003 0 8004 1 8005 48 8006 0 8007 0 8008 2 8009 52 8010 57 8011 0 8012 1 8013 49 8014 0
134/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
8015 0 8016 1 8017 48 8018 0 8019 0 8020 2 8021 53 8022 54 8023 0 8024 2 8025 53 8026 50 8027 0 8028 1 8029 50 8030 0 8031 0 8032 1 8033 48 8034 0 8035 0 8036 1 8037 48 8038 0 8039 0 8040 2 8041 52 8042 56 8043 0 8044 1 8045 49 8046 0 8047 0 8048 1 8049 48 8050 0 8051 0 8052 1 8053 48 8054 0 8055 0 8056 2 8057 52 8058 56 8059 0 8060 1 8061 49 8062 0 8063 0 8064 1 8065 48 8066 0 8067 0 8068 1 8069 48 8070 0 8071 0 8072 2 8073 52 8074 57
135/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
8075 0 8076 1 8077 49 8078 0 8079 0 8080 1 8081 48 8082 0 8083 0 8084 2 8085 53 8086 54 8087 0 8088 2 8089 53 8090 50 8091 0 8092 1 8093 50 8094 0 8095 0 8096 1 8097 48 8098 0 8099 0 8100 1 8101 48 8102 0 8103 0 8104 2 8105 52 8106 56 8107 0 8108 1 8109 49 8110 0 8111 0 8112 1 8113 48 8114 0 8115 0 8116 1 8117 48 8118 0 8119 0 8120 2 8121 52 8122 56 8123 0 8124 1 8125 49 8126 0 8127 0 8128 1 8129 48 8130 0 8131 0 8132 1 8133 48 8134 0
136/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
8135 0 8136 2 8137 52 8138 57 8139 0 8140 1 8141 49 8142 0 8143 0 8144 1 8145 48 8146 0 8147 0 8148 2 8149 53 8150 54 8151 0 8152 2 8153 53 8154 50 8155 0 8156 1 8157 50 8158 0 8159 0 8160 1 8161 48 8162 0 8163 0 8164 1 8165 48 8166 0 8167 0 8168 2 8169 52 8170 56 8171 0 8172 1 8173 49 8174 0 8175 0 8176 1 8177 48 8178 0 8179 0 8180 1 8181 48 8182 0 8183 0 8184 2 8185 52 8186 56 8187 0 8188 1 8189 49 8190 0 8191 0 8192 1 8193 48 8194 0
137/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
8195 0 8196 1 8197 48 8198 0 8199 0 8200 2 8201 52 8202 57 8203 0 8204 1 8205 49 8206 0 8207 0 8208 1 8209 48 8210 0 8211 0 8212 2 8213 53 8214 54 8215 0 8216 2 8217 53 8218 50 8219 0 8220 1 8221 50 8222 0 8223 0 8224 1 8225 48 8226 0 8227 0 8228 1 8229 48 8230 0 8231 0 8232 2 8233 52 8234 56 8235 0 8236 1 8237 49 8238 0 8239 0 8240 1 8241 48 8242 0 8243 0 8244 1 8245 48 8246 0 8247 0 8248 2 8249 52 8250 56 8251 0 8252 1 8253 49 8254 0
138/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
8255 0 8256 1 8257 48 8258 0 8259 0 8260 1 8261 48 8262 0 8263 0 8264 2 8265 52 8266 57 8267 0 8268 1 8269 49 8270 0 8271 0 8272 1 8273 48 8274 0 8275 0 8276 2 8277 53 8278 54 8279 0 8280 2 8281 53 8282 50 8283 0 8284 1 8285 50 8286 0 8287 0 8288 1 8289 48 8290 0 8291 0 8292 1 8293 48 8294 0 8295 0 8296 2 8297 52 8298 56 8299 0 8300 1 8301 49 8302 0 8303 0 8304 1 8305 48 8306 0 8307 0 8308 1 8309 48 8310 0 8311 0 8312 2 8313 52 8314 56
139/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
8315 0 8316 1 8317 49 8318 0 8319 0 8320 1 8321 48 8322 0 8323 0 8324 1 8325 48 8326 0 8327 0 8328 2 8329 52 8330 57 8331 0 8332 1 8333 49 8334 0 8335 0 8336 1 8337 48 8338 0 8339 0 8340 2 8341 53 8342 54 8343 0 8344 2 8345 53 8346 50 8347 0 8348 1 8349 50 8350 0 8351 0 8352 1 8353 48 8354 0 8355 0 8356 1 8357 48 8358 0 8359 0 8360 2 8361 52 8362 56 8363 0 8364 1 8365 49 8366 0 8367 0 8368 1 8369 48 8370 0 8371 0 8372 1 8373 48 8374 0
140/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
8375 0 8376 2 8377 52 8378 56 8379 0 8380 1 8381 49 8382 0 8383 0 8384 1 8385 48 8386 0 8387 0 8388 1 8389 48 8390 0 8391 0 8392 2 8393 52 8394 57 8395 0 8396 1 8397 49 8398 0 8399 0 8400 1 8401 48 8402 0 8403 0 8404 2 8405 53 8406 54 8407 0 8408 2 8409 53 8410 50 8411 0 8412 1 8413 50 8414 0 8415 0 8416 1 8417 48 8418 0 8419 0 8420 1 8421 48 8422 0 8423 0 8424 2 8425 52 8426 56 8427 0 8428 1 8429 49 8430 0 8431 0 8432 1 8433 48 8434 0
141/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
8435 0 8436 1 8437 48 8438 0 8439 0 8440 2 8441 52 8442 56 8443 0 8444 1 8445 49 8446 0 8447 0 8448 1 8449 48 8450 0 8451 0 8452 1 8453 48 8454 0 8455 0 8456 2 8457 52 8458 57 8459 0 8460 1 8461 49 8462 0 8463 0 8464 1 8465 48 8466 0 8467 0 8468 2 8469 53 8470 54 8471 0 8472 2 8473 53 8474 50 8475 0 8476 1 8477 50 8478 0 8479 0 8480 1 8481 48 8482 0 8483 0 8484 1 8485 48 8486 0 8487 0 8488 2 8489 52 8490 56 8491 0 8492 1 8493 49 8494 0
142/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
8495 0 8496 1 8497 48 8498 0 8499 0 8500 1 8501 48 8502 0 8503 0 8504 2 8505 52 8506 56 8507 0 8508 1 8509 49 8510 0 8511 0 8512 1 8513 48 8514 0 8515 0 8516 1 8517 48 8518 0 8519 0 8520 2 8521 52 8522 57 8523 0 8524 1 8525 49 8526 0 8527 0 8528 1 8529 48 8530 0 8531 0 8532 2 8533 53 8534 54 8535 0 8536 2 8537 53 8538 50 8539 0 8540 1 8541 50 8542 0 8543 0 8544 1 8545 48 8546 0 8547 0 8548 1 8549 48 8550 0 8551 0 8552 2 8553 52 8554 56
143/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
8555 0 8556 1 8557 49 8558 0 8559 0 8560 1 8561 48 8562 0 8563 0 8564 1 8565 48 8566 0 8567 0 8568 2 8569 52 8570 56 8571 0 8572 1 8573 49 8574 0 8575 0 8576 1 8577 48 8578 0 8579 0 8580 1 8581 48 8582 0 8583 0 8584 2 8585 52 8586 57 8587 0 8588 1 8589 49 8590 0 8591 0 8592 1 8593 48 8594 0 8595 0 8596 2 8597 53 8598 54 8599 0 8600 2 8601 53 8602 50 8603 0 8604 1 8605 50 8606 0 8607 0 8608 1 8609 48 8610 0 8611 0 8612 1 8613 48 8614 0
144/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
8615 0 8616 2 8617 52 8618 56 8619 0 8620 1 8621 49 8622 0 8623 0 8624 1 8625 48 8626 0 8627 0 8628 1 8629 48 8630 0 8631 0 8632 2 8633 52 8634 56 8635 0 8636 1 8637 49 8638 0 8639 0 8640 1 8641 48 8642 0 8643 0 8644 1 8645 48 8646 0 8647 0 8648 2 8649 52 8650 57 8651 0 8652 1 8653 49 8654 0 8655 0 8656 1 8657 48 8658 0 8659 0 8660 2 8661 53 8662 54 8663 0 8664 2 8665 53 8666 50 8667 0 8668 1 8669 50 8670 0 8671 0 8672 1 8673 48 8674 0
145/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
8675 0 8676 1 8677 48 8678 0 8679 0 8680 2 8681 52 8682 56 8683 0 8684 1 8685 49 8686 0 8687 0 8688 1 8689 48 8690 0 8691 0 8692 1 8693 48 8694 0 8695 0 8696 2 8697 52 8698 56 8699 0 8700 1 8701 49 8702 0 8703 0 8704 1 8705 48 8706 0 8707 0 8708 1 8709 48 8710 0 8711 0 8712 2 8713 52 8714 56 8715 0 8716 1 8717 49 8718 0 8719 0 8720 1 8721 48 8722 0 8723 0 8724 1 8725 48 8726 0 8727 0 8728 2 8729 53 8730 54 8731 0 8732 1 8733 49 8734 0
146/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
8735 0 8736 1 8737 48 8738 0 8739 0 8740 2 8741 52 8742 56 8743 0 8744 2 8745 53 8746 51 8747 0 8748 1 8749 50 8750 0 8751 0 8752 1 8753 48 8754 0 8755 0 8756 2 8757 53 8758 55 8759 0 8760 2 8761 53 8762 50 8763 0 8764 1 8765 50 8766 0 8767 0 8768 1 8769 48 8770 0 8771 0 8772 2 8773 53 8774 52 8775 0 8776 2 8777 53 8778 51 8779 0 8780 1 8781 50 8782 0 8783 0 8784 1 8785 48 8786 0 8787 0 8788 2 8789 53 8790 54 8791 0 8792 2 8793 53 8794 50
147/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
8795 0 8796 1 8797 50 8798 0 8799 0 8800 1 8801 48 8802 0 8803 0 8804 2 8805 53 8806 51 8807 0 8808 2 8809 53 8810 51 8811 0 8812 1 8813 50 8814 0 8815 0 8816 1 8817 48 8818 0 8819 0 8820 2 8821 53 8822 53 8823 0 8824 2 8825 53 8826 51 8827 0 8828 1 8829 50 8830 0 8831 0 8832 1 8833 48 8834 0 8835 0 8836 1 8837 48 8838 0 8839 0 8840 2 8841 52 8842 57 8843 0 8844 1 8845 49 8846 0 8847 0 8848 1 8849 48 8850 0 8851 0 8852 2 8853 53 8854 54
148/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
8855 0 8856 2 8857 53 8858 50 8859 0 8860 1 8861 50 8862 0 8863 0 8864 1 8865 48 8866 0 8867 0 8868 1 8869 48 8870 0 8871 0 8872 2 8873 52 8874 56 8875 0 8876 1 8877 49 8878 0 8879 0 8880 1 8881 48 8882 0 8883 0 8884 1 8885 48 8886 0 8887 0 8888 2 8889 52 8890 56 8891 0 8892 1 8893 49 8894 0 8895 0 8896 1 8897 48 8898 0 8899 0 8900 1 8901 48 8902 0 8903 0 8904 2 8905 52 8906 57 8907 0 8908 1 8909 49 8910 0 8911 0 8912 1 8913 48 8914 0
149/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
8915 0 8916 2 8917 53 8918 54 8919 0 8920 2 8921 53 8922 50 8923 0 8924 1 8925 50 8926 0 8927 0 8928 1 8929 48 8930 0 8931 0 8932 1 8933 48 8934 0 8935 0 8936 2 8937 52 8938 56 8939 0 8940 1 8941 49 8942 0 8943 0 8944 1 8945 48 8946 0 8947 0 8948 1 8949 48 8950 0 8951 0 8952 2 8953 52 8954 56 8955 0 8956 1 8957 49 8958 0 8959 0 8960 1 8961 48 8962 0 8963 0 8964 1 8965 48 8966 0 8967 0 8968 2 8969 52 8970 57 8971 0 8972 1 8973 49 8974 0
150/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
8975 0 8976 1 8977 48 8978 0 8979 0 8980 2 8981 53 8982 54 8983 0 8984 2 8985 53 8986 50 8987 0 8988 1 8989 50 8990 0 8991 0 8992 1 8993 48 8994 0 8995 0 8996 1 8997 48 8998 0 8999 0 9000 2 9001 52 9002 56 9003 0 9004 1 9005 49 9006 0 9007 0 9008 1 9009 48 9010 0 9011 0 9012 1 9013 48 9014 0 9015 0 9016 2 9017 52 9018 56 9019 0 9020 1 9021 49 9022 0 9023 0 9024 1 9025 48 9026 0 9027 0 9028 1 9029 48 9030 0 9031 0 9032 2 9033 52 9034 57
151/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
9035 0 9036 1 9037 49 9038 0 9039 0 9040 1 9041 48 9042 0 9043 0 9044 2 9045 53 9046 54 9047 0 9048 2 9049 53 9050 50 9051 0 9052 1 9053 50 9054 0 9055 0 9056 1 9057 48 9058 0 9059 0 9060 1 9061 48 9062 0 9063 0 9064 2 9065 52 9066 56 9067 0 9068 1 9069 49 9070 0 9071 0 9072 1 9073 48 9074 0 9075 0 9076 1 9077 48 9078 0 9079 0 9080 2 9081 52 9082 56 9083 0 9084 1 9085 49 9086 0 9087 0 9088 1 9089 48 9090 0 9091 0 9092 1 9093 48 9094 0
152/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
9095 0 9096 2 9097 52 9098 57 9099 0 9100 1 9101 49 9102 0 9103 0 9104 1 9105 48 9106 0 9107 0 9108 2 9109 53 9110 54 9111 0 9112 2 9113 53 9114 50 9115 0 9116 1 9117 50 9118 0 9119 0 9120 1 9121 48 9122 0 9123 0 9124 1 9125 48 9126 0 9127 0 9128 2 9129 52 9130 56 9131 0 9132 1 9133 49 9134 0 9135 0 9136 1 9137 48 9138 0 9139 0 9140 1 9141 48 9142 0 9143 0 9144 2 9145 52 9146 56 9147 0 9148 1 9149 49 9150 0 9151 0 9152 1 9153 48 9154 0
153/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
9155 0 9156 1 9157 48 9158 0 9159 0 9160 2 9161 52 9162 57 9163 0 9164 1 9165 49 9166 0 9167 0 9168 1 9169 48 9170 0 9171 0 9172 2 9173 53 9174 54 9175 0 9176 2 9177 53 9178 50 9179 0 9180 1 9181 50 9182 0 9183 0 9184 1 9185 48 9186 0 9187 0 9188 1 9189 48 9190 0 9191 0 9192 2 9193 52 9194 56 9195 0 9196 1 9197 49 9198 0 9199 0 9200 1 9201 48 9202 0 9203 0 9204 1 9205 48 9206 0 9207 0 9208 2 9209 52 9210 56 9211 0 9212 1 9213 49 9214 0
154/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
9215 0 9216 1 9217 48 9218 0 9219 0 9220 1 9221 48 9222 0 9223 0 9224 2 9225 52 9226 56 9227 0 9228 1 9229 49 9230 0 9231 0 9232 1 9233 48 9234 0 9235 0 9236 1 9237 48 9238 0 9239 0 9240 2 9241 52 9242 56 9243 0 9244 1 9245 49 9246 0 9247 0 9248 1 9249 48 9250 0 9251 0 9252 1 9253 48 9254 0 9255 0 9256 2 9257 52 9258 56 9259 0 9260 1 9261 49 9262 0 9263 0 9264 1 9265 48 9266 0 9267 0 9268 1 9269 48 9270 0 9271 0 9272 2 9273 52 9274 56
155/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
9275 0 9276 1 9277 49 9278 0 9279 0 9280 1 9281 48 9282 0 9283 0 9284 1 9285 48 9286 0 9287 0 9288 2 9289 52 9290 56 9291 0 9292 1 9293 49 9294 0 9295 0 9296 1 9297 48 9298 0 9299 0 9300 1 9301 48 9302 0 9303 0 9304 2 9305 52 9306 56 9307 0 9308 1 9309 49 9310 0 9311 0 9312 1 9313 48 9314 0 9315 0 9316 1 9317 48 9318 0 9319 0 9320 2 9321 52 9322 56 9323 0 9324 1 9325 49 9326 0 9327 0 9328 1 9329 48 9330 0 9331 0 9332 1 9333 48 9334 0
156/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
9335 0 9336 2 9337 52 9338 56 9339 0 9340 1 9341 49 9342 0 9343 0 9344 1 9345 48 9346 0 9347 0 9348 1 9349 48 9350 0 9351 0 9352 2 9353 52 9354 56 9355 0 9356 1 9357 49 9358 0 9359 0 9360 1 9361 48 9362 0 9363 0 9364 1 9365 48 9366 0 9367 0 9368 2 9369 52 9370 56 9371 0 9372 1 9373 49 9374 0 9375 0 9376 1 9377 48 9378 0 9379 0 9380 1 9381 48 9382 0 9383 0 9384 2 9385 52 9386 56 9387 0 9388 1 9389 49 9390 0 9391 0 9392 1 9393 48 9394 0
157/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
9395 0 9396 1 9397 48 9398 0 9399 0 9400 2 9401 52 9402 56 9403 0 9404 1 9405 49 9406 0 9407 0 9408 1 9409 48 9410 0 9411 0 9412 1 9413 48 9414 0 9415 0 9416 2 9417 52 9418 56 9419 0 9420 1 9421 49 9422 0 9423 0 9424 1 9425 48 9426 0 9427 0 9428 1 9429 48 9430 0 9431 0 9432 2 9433 52 9434 56 9435 0 9436 1 9437 49 9438 0 9439 0 9440 1 9441 48 9442 0 9443 0 9444 1 9445 48 9446 0 9447 0 9448 2 9449 52 9450 56 9451 0 9452 1 9453 49 9454 0
158/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
9455 0 9456 1 9457 48 9458 0 9459 0 9460 1 9461 48 9462 0 9463 0 9464 2 9465 52 9466 56 9467 0 9468 1 9469 49 9470 0 9471 0 9472 1 9473 48 9474 0 9475 0 9476 1 9477 48 9478 0 9479 0 9480 2 9481 52 9482 56 9483 0 9484 1 9485 49 9486 0 9487 0 9488 1 9489 48 9490 0 9491 0 9492 1 9493 48 9494 0 9495 0 9496 2 9497 52 9498 56 9499 0 9500 1 9501 49 9502 0 9503 0 9504 1 9505 48 9506 0 9507 0 9508 1 9509 48 9510 0 9511 0 9512 2 9513 52 9514 56
159/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
9515 0 9516 1 9517 49 9518 0 9519 0 9520 1 9521 48 9522 0 9523 0 9524 1 9525 48 9526 0 9527 0 9528 2 9529 52 9530 56 9531 0 9532 1 9533 49 9534 0 9535 0 9536 1 9537 48 9538 0 9539 0 9540 1 9541 48 9542 0 9543 0 9544 2 9545 52 9546 56 9547 0 9548 1 9549 49 9550 0 9551 0 9552 1 9553 48 9554 0 9555 0 9556 1 9557 48 9558 0 9559 0 9560 2 9561 52 9562 56 9563 0 9564 1 9565 49 9566 0 9567 0 9568 1 9569 48 9570 0 9571 0 9572 1 9573 48 9574 0
160/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
9575 0 9576 2 9577 52 9578 56 9579 0 9580 1 9581 49 9582 0 9583 0 9584 1 9585 48 9586 0 9587 0 9588 1 9589 48 9590 0 9591 0 9592 2 9593 53 9594 54 9595 0 9596 1 9597 49 9598 0 9599 0 9600 1 9601 48 9602 0 9603 0 9604 2 9605 52 9606 56 9607 0 9608 2 9609 53 9610 51 9611 0 9612 1 9613 50 9614 0 9615 0 9616 1 9617 48 9618 0 9619 0 9620 2 9621 53 9622 55 9623 0 9624 2 9625 53 9626 50 9627 0 9628 1 9629 50 9630 0 9631 0 9632 1 9633 48 9634 0
161/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
9635 0
9636 2
9637 53
9638 52
9639 0
9640 2
9641 53
9642 51
9643 0
9644 1
9645 50
9646 0
9647 0
9648 1
9649 48
9650 0
9651 0
9652 2
9653 53
9654 54
9655 0
9656 2
9657 53
9658 50
9659 0
9660 1
9661 50
9662 0
9663 0
9664 1
9665 48
9666 0
9667 0
9668 2
9669 53
9670 52
9671 0
9672 2
9673 53
9674 51
9675 0
9676 1
9677 50
9678 0
9679 0
9680 21880352 9681 0
9682 0
9683 0
9684 21880384 9685 0
9686 0
9687 0
9688 21880416 9689 0
9690 0
9691 0
9692 1
9693 48
9694 0
162/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
9695 0
9696 1
9697 48
9698 0
9699 0
9700 1
9701 48
9702 0
9703 0
9704 1
9705 48
9706 0
9707 0
9708 1
9709 48
9710 0
9711 0
9712 1
9713 48
9714 0
9715 0
9716 1
9717 48
9718 0
9719 0
9720 1
9721 48
9722 0
9723 0
9724 1
9725 48
9726 0
9727 0
9728 1
9729 48
9730 0
9731 0
9732 1
9733 48
9734 0
9735 0
9736 0
9737 0
9738 0
9739 0
9740 0
9741 0
9742 0
9743 0
9744 0
9745 0
9746 21880832 9747 0
9748 0 9749 0 9750 0 9751 0 9752 0 9753 0 9754 0
163/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
9755 0
9756 21880912 9757 0
9758 0
9759 0
9760 0
9761 0
9762 0
9763 0
9764 0
9765 0
9766 21880992 9767 0
9768 0
9769 0
9770 0
9771 0
9772 0
9773 0
9774 0
9775 0
9776 21881072 9777 0
9778 0
9779 0
9780 0
9781 0
9782 0
9783 0
9784 0
9785 0
9786 21881152 9787 0
9788 0
9789 0
9790 0
9791 0
9792 0
9793 0
9794 0
9795 0
9796 21881232 9797 0
9798 0
9799 0
9800 0
9801 0
9802 0
9803 0
9804 0
9805 0
9806 21881312 9807 0
9808 0
9809 0
9810 0
9811 0
9812 0
9813 0
9814 0
164/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
9815 0
9816 21881392 9817 0
9818 0
9819 0
9820 0
9821 0
9822 0
9823 0
9824 0
9825 0
9826 21881472 9827 0
9828 0
9829 0
9830 0
9831 0
9832 0
9833 0
9834 0
9835 0
9836 21881552 9837 0
9838 0
9839 0
9840 0
9841 0
9842 0
9843 0
9844 0
9845 0
9846 21881632 9847 0
9848 0
9849 0
9850 0
9851 0
9852 0
9853 0
9854 0
9855 0
9856 21881712 9857 0
9858 0
9859 0
9860 0
9861 0
9862 0
9863 0
9864 0
9865 0
9866 21881792 9867 0
9868 0
9869 0
9870 0
9871 0
9872 0
9873 0
9874 0
165/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
9875 0
9876 21881872 9877 0
9878 0
9879 0
9880 0
9881 0
9882 0
9883 0
9884 0
9885 0
9886 21881952 9887 0
9888 0
9889 0
9890 0
9891 0
9892 0
9893 0
9894 0
9895 0
9896 21882032 9897 0
9898 0
9899 0
9900 0
9901 0
9902 0
9903 0
9904 0
9905 0
9906 21882112 9907 0
9908 0
9909 0
9910 0
9911 0
9912 0
9913 0
9914 0
9915 0
9916 21882192 9917 0
9918 0
9919 0
9920 0
9921 0
9922 0
9923 0
9924 0
9925 0
9926 21882272 9927 0
9928 0
9929 0
9930 0
9931 0
9932 0
9933 0
9934 0
166/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
9935 0
9936 21882352 9937 0
9938 0
9939 0
9940 0
9941 0
9942 0
9943 0
9944 0
9945 0
9946 21882432 9947 0
9948 0
9949 0
9950 0
9951 0
9952 0
9953 0
9954 0
9955 0
9956 21882512 9957 0
9958 0
9959 0
9960 0
9961 0
9962 0
9963 0
9964 0
9965 0
9966 21882592 9967 0
9968 0
9969 0
9970 0
9971 0
9972 0
9973 0
9974 0
9975 0
9976 21882672 9977 50
9978 49
9979 56
9980 56
9981 50
9982 54
9983 55
9984 50
9985 0
9986 8
9987 50
9988 49
9989 56
9990 56
9991 50
9992 53
9993 57
9994 50
167/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
9995 0 9996 8 9997 50 9998 49 9999 56
10000 56 10001 50 10002 53 10003 49 10004 50 10005 0 10006 8 10007 50 10008 49 10009 56 10010 56 10011 50 10012 52 10013 51 10014 50 10015 0 10016 8 10017 50 10018 49 10019 56 10020 56 10021 50 10022 51 10023 53 10024 50 10025 0 10026 8 10027 50 10028 49 10029 56 10030 56 10031 50 10032 50 10033 55 10034 50 10035 0 10036 8 10037 50 10038 49 10039 56 10040 56 10041 50 10042 49 10043 57 10044 50 10045 0 10046 8 10047 50 10048 49 10049 56 10050 56 10051 50 10052 49 10053 49 10054 50
168/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
10055 0 10056 8 10057 50 10058 49 10059 56 10060 56 10061 50 10062 48 10063 51 10064 50 10065 0 10066 8 10067 50 10068 49 10069 56 10070 56 10071 49 10072 57 10073 53 10074 50 10075 0 10076 8 10077 50 10078 49 10079 56 10080 56 10081 49 10082 56 10083 55 10084 50 10085 0 10086 8 10087 50 10088 49 10089 56 10090 56 10091 49 10092 55 10093 57 10094 50 10095 0 10096 8 10097 50 10098 49 10099 56 10100 56 10101 49 10102 55 10103 49 10104 50 10105 0 10106 8 10107 50 10108 49 10109 56 10110 56 10111 49 10112 54 10113 51 10114 50
169/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
10115 0 10116 8 10117 50 10118 49 10119 56 10120 56 10121 49 10122 53 10123 53 10124 50 10125 0 10126 8 10127 50 10128 49 10129 56 10130 56 10131 49 10132 52 10133 55 10134 50 10135 0 10136 8 10137 50 10138 49 10139 56 10140 56 10141 49 10142 51 10143 57 10144 50 10145 0 10146 8 10147 50 10148 49 10149 56 10150 56 10151 49 10152 51 10153 49 10154 50 10155 0 10156 8 10157 50 10158 49 10159 56 10160 56 10161 49 10162 50 10163 51 10164 50 10165 0 10166 8 10167 50 10168 49 10169 56 10170 56 10171 49 10172 49 10173 53 10174 50
170/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
10175 0 10176 8 10177 50 10178 49 10179 56 10180 56 10181 49 10182 48 10183 55 10184 50 10185 0 10186 8 10187 50 10188 49 10189 56 10190 56 10191 48 10192 57 10193 57 10194 50 10195 0 10196 8 10197 50 10198 49 10199 56 10200 56 10201 48 10202 57 10203 49 10204 50 10205 0 10206 8 10207 50 10208 49 10209 56 10210 56 10211 48 10212 56 10213 51 10214 50 10215 0 10216 8 10217 50 10218 49 10219 56 10220 56 10221 48 10222 52 10223 49 10224 54 10225 0 10226 8 10227 50 10228 49 10229 56 10230 56 10231 48 10232 51 10233 56 10234 52
171/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
10235 0 10236 8 10237 50 10238 49 10239 56 10240 56 10241 48 10242 51 10243 53 10244 50 10245 0 10246 0 10247 0 10248 1 10249 48 10250 0 10251 0 10252 1 10253 48 10254 0 10255 0 10256 1 10257 48 10258 0 10259 0 10260 1 10261 48 10262 0 10263 0 10264 1 10265 48 10266 0 10267 0 10268 1 10269 48 10270 0 10271 0 10272 1 10273 48 10274 0 10275 0 10276 1 10277 48 10278 0 10279 0 10280 1 10281 48 10282 0 10283 0 10284 1 10285 48 10286 0 10287 0 10288 1 10289 48 10290 0 10291 0 10292 1 10293 48 10294 0
172/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
10295 0 10296 1 10297 48 10298 0 10299 0 10300 1 10301 48 10302 0 10303 0 10304 1 10305 48 10306 0 10307 0 10308 1 10309 48 10310 0 10311 0 10312 1 10313 48 10314 0 10315 0 10316 1 10317 48 10318 0 10319 0 10320 1 10321 48 10322 0 10323 0 10324 1 10325 48 10326 0 10327 0 10328 1 10329 48 10330 0 10331 0 10332 1 10333 48 10334 0 10335 0 10336 1 10337 48 10338 0 10339 0 10340 1 10341 48 10342 0 10343 0 10344 1 10345 48 10346 0 10347 0 10348 1 10349 48 10350 0 10351 0 10352 1 10353 48 10354 0
173/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
10355 0 10356 1 10357 48 10358 0 10359 0 10360 1 10361 48 10362 0 10363 0 10364 1 10365 48 10366 0 10367 0 10368 1 10369 48 10370 0 10371 0 10372 1 10373 48 10374 0 10375 0 10376 1 10377 48 10378 0 10379 0 10380 1 10381 48 10382 0 10383 0 10384 1 10385 48 10386 0 10387 0 10388 1 10389 48 10390 0 10391 0 10392 1 10393 48 10394 0 10395 0 10396 1 10397 48 10398 0 10399 0 10400 1 10401 48 10402 0 10403 0 10404 1 10405 48 10406 0 10407 0 10408 1 10409 48 10410 0 10411 0 10412 1 10413 48 10414 0
174/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
10415 0 10416 1 10417 48 10418 0 10419 0 10420 1 10421 48 10422 0 10423 0 10424 1 10425 48 10426 0 10427 0 10428 1 10429 48 10430 0 10431 0 10432 1 10433 48 10434 0 10435 0 10436 1 10437 48 10438 0 10439 0 10440 1 10441 48 10442 0 10443 0 10444 1 10445 48 10446 0 10447 0 10448 1 10449 48 10450 0 10451 0 10452 1 10453 48 10454 0 10455 0 10456 1 10457 48 10458 0 10459 0 10460 1 10461 48 10462 0 10463 0 10464 1 10465 48 10466 0 10467 0 10468 1 10469 48 10470 0 10471 0 10472 1 10473 48 10474 0
175/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
10475 0 10476 1 10477 48 10478 0 10479 0 10480 1 10481 48 10482 0 10483 0 10484 1 10485 48 10486 0 10487 0 10488 1 10489 48 10490 0 10491 0 10492 1 10493 48 10494 0 10495 0 10496 1 10497 48 10498 0 10499 0 10500 1 10501 48 10502 0 10503 0 10504 1 10505 48 10506 0 10507 0 10508 1 10509 48 10510 0 10511 0 10512 1 10513 48 10514 0 10515 0 10516 1 10517 48 10518 0 10519 0 10520 1 10521 48 10522 0 10523 0 10524 1 10525 48 10526 0 10527 0 10528 1 10529 48 10530 0 10531 0 10532 1 10533 48 10534 0
176/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
10535 0 10536 1 10537 48 10538 0 10539 0 10540 1 10541 48 10542 0 10543 0 10544 1 10545 48 10546 0 10547 0 10548 1 10549 48 10550 0 10551 0 10552 1 10553 48 10554 0 10555 0 10556 1 10557 48 10558 0 10559 0 10560 1 10561 48 10562 0 10563 0 10564 1 10565 48 10566 0 10567 0 10568 1 10569 48 10570 0 10571 0 10572 1 10573 48 10574 0 10575 0 10576 1 10577 48 10578 0 10579 0 10580 1 10581 48 10582 0 10583 0 10584 1 10585 48 10586 0 10587 0 10588 1 10589 48 10590 0 10591 0 10592 1 10593 48 10594 0
177/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
10595 0 10596 1 10597 48 10598 0 10599 0 10600 1 10601 48 10602 0 10603 0 10604 1 10605 48 10606 0 10607 0 10608 1 10609 48 10610 0 10611 0 10612 1 10613 48 10614 0 10615 0 10616 1 10617 48 10618 0 10619 0 10620 1 10621 48 10622 0 10623 0 10624 1 10625 48 10626 0 10627 0 10628 1 10629 48 10630 0 10631 0 10632 1 10633 48 10634 0 10635 0 10636 1 10637 48 10638 0 10639 0 10640 1 10641 48 10642 0 10643 0 10644 1 10645 48 10646 0 10647 0 10648 1 10649 48 10650 0 10651 0 10652 1 10653 48 10654 0
178/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
10655 0 10656 1 10657 48 10658 0 10659 0 10660 1 10661 48 10662 0 10663 0 10664 1 10665 48 10666 0 10667 0 10668 1 10669 48 10670 0 10671 0 10672 1 10673 48 10674 0 10675 0 10676 1 10677 48 10678 0 10679 0 10680 1 10681 48 10682 0 10683 0 10684 1 10685 48 10686 0 10687 0 10688 1 10689 48 10690 0 10691 0 10692 1 10693 48 10694 0 10695 0 10696 1 10697 48 10698 0 10699 0 10700 1 10701 48 10702 0 10703 0 10704 1 10705 48 10706 0 10707 0 10708 1 10709 48 10710 0 10711 0 10712 1 10713 48 10714 0
179/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
10715 0 10716 1 10717 48 10718 0 10719 0 10720 1 10721 48 10722 0 10723 0 10724 1 10725 48 10726 0 10727 0 10728 1 10729 48 10730 0 10731 0 10732 1 10733 48 10734 0 10735 0 10736 1 10737 48 10738 0 10739 0 10740 1 10741 48 10742 0 10743 0 10744 1 10745 48 10746 0 10747 0 10748 1 10749 48 10750 0 10751 0 10752 1 10753 48 10754 0 10755 0 10756 1 10757 48 10758 0 10759 0 10760 2 10761 52 10762 57 10763 0 10764 2 10765 53 10766 48 10767 0 10768 1 10769 56 10770 0 10771 0 10772 1 10773 48 10774 0
180/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
10775 0 10776 2 10777 53 10778 48 10779 0 10780 2 10781 53 10782 53 10783 0 10784 2 10785 53 10786 54 10787 0 10788 2 10789 52 10790 57 10791 0 10792 2 10793 53 10794 54 10795 0 10796 2 10797 53 10798 54 10799 0 10800 2 10801 52 10802 57 10803 0 10804 2 10805 53 10806 48 10807 0 10808 1 10809 56 10810 0 10811 0 10812 1 10813 48 10814 0 10815 0 10816 2 10817 53 10818 48 10819 0 10820 2 10821 53 10822 51 10823 0 10824 2 10825 53 10826 55 10827 0 10828 2 10829 52 10830 57 10831 0 10832 2 10833 53 10834 54
181/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
10835 0 10836 2 10837 53 10838 54 10839 0 10840 2 10841 52 10842 57 10843 0 10844 2 10845 53 10846 48 10847 0 10848 1 10849 56 10850 0 10851 0 10852 1 10853 48 10854 0 10855 0 10856 2 10857 53 10858 48 10859 0 10860 2 10861 53 10862 49 10863 0 10864 2 10865 52 10866 56 10867 0 10868 2 10869 53 10870 48 10871 0 10872 2 10873 53 10874 54 10875 0 10876 2 10877 53 10878 54 10879 0 10880 2 10881 52 10882 57 10883 0 10884 2 10885 53 10886 48 10887 0 10888 1 10889 56 10890 0 10891 0 10892 1 10893 48 10894 0
182/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
10895 0 10896 2 10897 53 10898 48 10899 0 10900 2 10901 52 10902 57 10903 0 10904 2 10905 52 10906 57 10907 0 10908 2 10909 53 10910 48 10911 0 10912 2 10913 53 10914 54 10915 0 10916 2 10917 53 10918 54 10919 0 10920 2 10921 52 10922 57 10923 0 10924 2 10925 53 10926 48 10927 0 10928 1 10929 56 10930 0 10931 0 10932 1 10933 48 10934 0 10935 0 10936 2 10937 53 10938 48 10939 0 10940 2 10941 53 10942 55 10943 0 10944 2 10945 52 10946 57 10947 0 10948 2 10949 53 10950 48 10951 0 10952 2 10953 53 10954 54
183/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
10955 0 10956 2 10957 53 10958 54 10959 0 10960 2 10961 52 10962 57 10963 0 10964 2 10965 53 10966 48 10967 0 10968 1 10969 56 10970 0 10971 0 10972 1 10973 48 10974 0 10975 0 10976 2 10977 53 10978 48 10979 0 10980 2 10981 53 10982 53 10983 0 10984 2 10985 53 10986 48 10987 0 10988 2 10989 53 10990 48 10991 0 10992 2 10993 53 10994 54 10995 0 10996 2 10997 53 10998 54 10999 0 11000 2 11001 52 11002 57 11003 0 11004 2 11005 53 11006 48 11007 0 11008 1 11009 56 11010 0 11011 0 11012 1 11013 48 11014 0
184/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
11015 0 11016 2 11017 53 11018 48 11019 0 11020 2 11021 53 11022 51 11023 0 11024 2 11025 53 11026 49 11027 0 11028 2 11029 53 11030 48 11031 0 11032 2 11033 53 11034 54 11035 0 11036 2 11037 53 11038 54 11039 0 11040 2 11041 52 11042 57 11043 0 11044 2 11045 53 11046 48 11047 0 11048 1 11049 56 11050 0 11051 0 11052 1 11053 48 11054 0 11055 0 11056 2 11057 53 11058 48 11059 0 11060 2 11061 53 11062 49 11063 0 11064 2 11065 53 11066 50 11067 0 11068 2 11069 53 11070 48 11071 0 11072 2 11073 53 11074 54
185/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
11075 0 11076 2 11077 53 11078 54 11079 0 11080 2 11081 52 11082 57 11083 0 11084 2 11085 53 11086 48 11087 0 11088 1 11089 56 11090 0 11091 0 11092 1 11093 48 11094 0 11095 0 11096 2 11097 53 11098 48 11099 0 11100 2 11101 52 11102 57 11103 0 11104 2 11105 53 11106 51 11107 0 11108 2 11109 53 11110 48 11111 0 11112 2 11113 53 11114 54 11115 0 11116 2 11117 53 11118 54 11119 0 11120 2 11121 52 11122 57 11123 0 11124 2 11125 53 11126 48 11127 0 11128 1 11129 56 11130 0 11131 0 11132 1 11133 48 11134 0
186/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
11135 0 11136 2 11137 53 11138 48 11139 0 11140 2 11141 53 11142 55 11143 0 11144 2 11145 53 11146 51 11147 0 11148 2 11149 53 11150 48 11151 0 11152 2 11153 53 11154 54 11155 0 11156 2 11157 53 11158 54 11159 0 11160 2 11161 52 11162 57 11163 0 11164 2 11165 53 11166 48 11167 0 11168 1 11169 56 11170 0 11171 0 11172 1 11173 48 11174 0 11175 0 11176 2 11177 53 11178 48 11179 0 11180 2 11181 53 11182 53 11183 0 11184 2 11185 53 11186 52 11187 0 11188 2 11189 53 11190 48 11191 0 11192 2 11193 53 11194 54
187/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
11195 0
11196 21892480 11197 0
11198 0
11199 0
11200 21892512 11201 0
11202 0
11203 0
11204 21892544 11205 0
11206 0
11207 0
11208 21892576 11209 0
11210 0
11211 0
11212 21892608 11213 0
11214 0
11215 0
11216 1
11217 48 11218 0
11219 0
11220 1
11221 48 11222 0
11223 0
11224 1
11225 48 11226 0
11227 0
11228 1
11229 48 11230 0
11231 0
11232 1
11233 48 11234 0
11235 0
11236 1
11237 48 11238 0
11239 0
11240 1
11241 48 11242 0
11243 0
11244 1
11245 48 11246 0
11247 0
11248 1
11249 48 11250 0
11251 0
11252 1
11253 48 11254 0
188/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
11255 0 11256 1 11257 48 11258 0 11259 0 11260 1 11261 48 11262 0 11263 0 11264 1 11265 48 11266 0 11267 0 11268 1 11269 48 11270 0 11271 0 11272 1 11273 56 11274 0 11275 0 11276 1 11277 48 11278 0 11279 0 11280 2 11281 53 11282 48 11283 0 11284 2 11285 53 11286 49 11287 0 11288 2 11289 53 11290 54 11291 0 11292 2 11293 52 11294 56 11295 0 11296 2 11297 53 11298 54 11299 0 11300 2 11301 53 11302 54 11303 0 11304 2 11305 52 11306 57 11307 0 11308 2 11309 53 11310 48 11311 0 11312 1 11313 56 11314 0
189/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
11315 0
11316 1
11317 48 11318 0
11319 0
11320 2
11321 53 11322 48 11323 0
11324 2
11325 52 11326 57 11327 0
11328 2
11329 0
11330 0
11331 0
11332 21893568 11333 0
11334 0
11335 0
11336 21893600 11337 0
11338 0
11339 0
11340 21893632 11341 0
11342 0
11343 0
11344 21893664 11345 0
11346 0
11347 0
11348 21893696 11349 0
11350 0
11351 0
11352 21893728 11353 0
11354 0
11355 0
11356 21893760 11357 0
11358 0
11359 0
11360 21893792 11361 0
11362 0
11363 0
11364 21893824 11365 0
11366 0
11367 0
11368 21893856 11369 0
11370 0
11371 0
11372 21893888 11373 0
11374 0
190/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
11375 0
11376 21893920 11377 0
11378 0
11379 0
11380 21893952 11381 0
11382 0
11383 0
11384 21893984 11385 0
11386 0
11387 0
11388 21894016 11389 0
11390 0
11391 0
11392 21894048 11393 0
11394 0
11395 0
11396 21894080 11397 0
11398 0
11399 0
11400 21894112 11401 0
11402 0
11403 0
11404 21894144 11405 0
11406 0
11407 0
11408 21894176 11409 0
11410 0
11411 0
11412 21894208 11413 0
11414 0
11415 0
11416 21894240 11417 0
11418 0
11419 0
11420 21894272 11421 0
11422 0
11423 0
11424 21894304 11425 0
11426 0
11427 0
11428 21894336 11429 0
11430 0
11431 0
11432 21894368 11433 0
11434 0
191/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
11435 0
11436 21894400 11437 0
11438 0
11439 0
11440 21894432 11441 0
11442 0
11443 0
11444 1
11445 48 11446 0
11447 0
11448 1
11449 48 11450 0
11451 0
11452 1
11453 48 11454 0
11455 0
11456 1
11457 48 11458 0
11459 0
11460 1
11461 48 11462 0
11463 0
11464 1
11465 48 11466 0
11467 0
11468 1
11469 48 11470 0
11471 0
11472 1
11473 48 11474 0
11475 0
11476 1
11477 48 11478 0
11479 0
11480 1
11481 48 11482 0
11483 0
11484 1
11485 48 11486 0
11487 0
11488 1
11489 48 11490 0
11491 0
11492 1
11493 48 11494 0
192/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
11495 0 11496 1 11497 48 11498 0 11499 0 11500 1 11501 48 11502 0 11503 0 11504 1 11505 48 11506 0 11507 0 11508 1 11509 48 11510 0 11511 0 11512 1 11513 48 11514 0 11515 0 11516 1 11517 48 11518 0 11519 0 11520 1 11521 48 11522 0 11523 0 11524 1 11525 48 11526 0 11527 0 11528 1 11529 48 11530 0 11531 0 11532 1 11533 48 11534 0 11535 0 11536 1 11537 48 11538 0 11539 0 11540 1 11541 48 11542 0 11543 0 11544 1 11545 48 11546 0 11547 0 11548 1 11549 48 11550 0 11551 0 11552 1 11553 48 11554 0
193/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
11555 0 11556 1 11557 48 11558 0 11559 0 11560 1 11561 48 11562 0 11563 0 11564 1 11565 48 11566 0 11567 0 11568 1 11569 48 11570 0 11571 0 11572 1 11573 48 11574 0 11575 0 11576 1 11577 48 11578 0 11579 0 11580 1 11581 48 11582 0 11583 0 11584 1 11585 48 11586 0 11587 0 11588 1 11589 48 11590 0 11591 0 11592 1 11593 48 11594 0 11595 0 11596 1 11597 48 11598 0 11599 0 11600 1 11601 48 11602 0 11603 0 11604 1 11605 48 11606 0 11607 0 11608 1 11609 48 11610 0 11611 0 11612 1 11613 48 11614 0
194/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
11615 0 11616 1 11617 48 11618 0 11619 0 11620 1 11621 48 11622 0 11623 0 11624 1 11625 48 11626 0 11627 0 11628 1 11629 48 11630 0 11631 0 11632 1 11633 48 11634 0 11635 0 11636 1 11637 48 11638 0 11639 0 11640 1 11641 48 11642 0 11643 0 11644 1 11645 48 11646 0 11647 0 11648 1 11649 48 11650 0 11651 0 11652 1 11653 48 11654 0 11655 0 11656 1 11657 48 11658 0 11659 0 11660 1 11661 48 11662 0 11663 0 11664 1 11665 48 11666 0 11667 0 11668 1 11669 48 11670 0 11671 0 11672 1 11673 48 11674 0
195/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
11675 0 11676 1 11677 48 11678 0 11679 0 11680 1 11681 48 11682 0 11683 0 11684 1 11685 48 11686 0 11687 0 11688 1 11689 48 11690 0 11691 0 11692 1 11693 48 11694 0 11695 0 11696 1 11697 48 11698 0 11699 0 11700 1 11701 48 11702 0 11703 0 11704 1 11705 48 11706 0 11707 0 11708 1 11709 48 11710 0 11711 0 11712 1 11713 48 11714 0 11715 0 11716 1 11717 48 11718 0 11719 0 11720 1 11721 48 11722 0 11723 0 11724 1 11725 48 11726 0 11727 0 11728 1 11729 48 11730 0 11731 0 11732 1 11733 48 11734 0
196/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
11735 0 11736 1 11737 48 11738 0 11739 0 11740 1 11741 48 11742 0 11743 0 11744 1 11745 48 11746 0 11747 0 11748 1 11749 48 11750 0 11751 0 11752 1 11753 48 11754 0 11755 0 11756 1 11757 48 11758 0 11759 0 11760 1 11761 48 11762 0 11763 0 11764 1 11765 48 11766 0 11767 0 11768 1 11769 48 11770 0 11771 0 11772 1 11773 48 11774 0 11775 0 11776 1 11777 48 11778 0 11779 0 11780 1 11781 50 11782 0 11783 0 11784 1 11785 48 11786 0 11787 0 11788 1 11789 48 11790 0 11791 0 11792 2 11793 52 11794 56
197/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
11795 0 11796 1 11797 49 11798 0 11799 0 11800 1 11801 48 11802 0 11803 0 11804 1 11805 48 11806 0 11807 0 11808 2 11809 52 11810 56 11811 0 11812 1 11813 49 11814 0 11815 0 11816 1 11817 48 11818 0 11819 0 11820 1 11821 48 11822 0 11823 0 11824 2 11825 52 11826 56 11827 0 11828 1 11829 49 11830 0 11831 0 11832 1 11833 48 11834 0 11835 0 11836 1 11837 48 11838 0 11839 0 11840 2 11841 52 11842 56 11843 0 11844 1 11845 49 11846 0 11847 0 11848 1 11849 48 11850 0 11851 0 11852 1 11853 48 11854 0
198/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
11855 0 11856 2 11857 52 11858 56 11859 0 11860 1 11861 49 11862 0 11863 0 11864 1 11865 48 11866 0 11867 0 11868 1 11869 48 11870 0 11871 0 11872 2 11873 52 11874 56 11875 0 11876 1 11877 49 11878 0 11879 0 11880 1 11881 48 11882 0 11883 0 11884 1 11885 48 11886 0 11887 0 11888 2 11889 52 11890 56 11891 0 11892 1 11893 49 11894 0 11895 0 11896 1 11897 48 11898 0 11899 0 11900 1 11901 48 11902 0 11903 0 11904 2 11905 52 11906 56 11907 0 11908 1 11909 49 11910 0 11911 0 11912 1 11913 48 11914 0
199/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
11915 0 11916 1 11917 48 11918 0 11919 0 11920 2 11921 52 11922 56 11923 0 11924 1 11925 49 11926 0 11927 0 11928 1 11929 48 11930 0 11931 0 11932 1 11933 48 11934 0 11935 0 11936 2 11937 52 11938 56 11939 0 11940 1 11941 49 11942 0 11943 0 11944 1 11945 48 11946 0 11947 0 11948 1 11949 48 11950 0 11951 0 11952 2 11953 52 11954 56 11955 0 11956 1 11957 49 11958 0 11959 0 11960 1 11961 48 11962 0 11963 0 11964 1 11965 48 11966 0 11967 0 11968 2 11969 52 11970 56 11971 0 11972 1 11973 49 11974 0
200/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
11975 0 11976 1 11977 48 11978 0 11979 0 11980 1 11981 48 11982 0 11983 0 11984 2 11985 52 11986 56 11987 0 11988 1 11989 49 11990 0 11991 0 11992 1 11993 48 11994 0 11995 0 11996 1 11997 48 11998 0 11999 0 12000 2 12001 52 12002 56 12003 0 12004 1 12005 49 12006 0 12007 0 12008 1 12009 48 12010 0 12011 0 12012 1 12013 48 12014 0 12015 0 12016 2 12017 52 12018 56 12019 0 12020 1 12021 49 12022 0 12023 0 12024 1 12025 48 12026 0 12027 0 12028 1 12029 48 12030 0 12031 0 12032 2 12033 52 12034 56
201/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
12035 0 12036 1 12037 49 12038 0 12039 0 12040 1 12041 48 12042 0 12043 0 12044 1 12045 48 12046 0 12047 0 12048 2 12049 52 12050 56 12051 0 12052 1 12053 49 12054 0 12055 0 12056 1 12057 48 12058 0 12059 0 12060 1 12061 48 12062 0 12063 0 12064 2 12065 52 12066 56 12067 0 12068 1 12069 49 12070 0 12071 0 12072 1 12073 48 12074 0 12075 0 12076 1 12077 48 12078 0 12079 0 12080 2 12081 52 12082 56 12083 0 12084 1 12085 49 12086 0 12087 0 12088 1 12089 48 12090 0 12091 0 12092 1 12093 48 12094 0
202/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
12095 0 12096 2 12097 52 12098 56 12099 0 12100 1 12101 49 12102 0 12103 0 12104 1 12105 48 12106 0 12107 0 12108 1 12109 48 12110 0 12111 0 12112 2 12113 52 12114 56 12115 0 12116 1 12117 49 12118 0 12119 0 12120 1 12121 48 12122 0 12123 0 12124 1 12125 48 12126 0 12127 0 12128 2 12129 52 12130 56 12131 0 12132 1 12133 49 12134 0 12135 0 12136 1 12137 48 12138 0 12139 0 12140 1 12141 48 12142 0 12143 0 12144 2 12145 52 12146 56 12147 0 12148 1 12149 49 12150 0 12151 0 12152 1 12153 48 12154 0
203/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
12155 0 12156 1 12157 48 12158 0 12159 0 12160 2 12161 52 12162 56 12163 0 12164 1 12165 49 12166 0 12167 0 12168 1 12169 48 12170 0 12171 0 12172 1 12173 48 12174 0 12175 0 12176 2 12177 52 12178 56 12179 0 12180 1 12181 49 12182 0 12183 0 12184 1 12185 48 12186 0 12187 0 12188 1 12189 48 12190 0 12191 0 12192 2 12193 52 12194 56 12195 0 12196 1 12197 49 12198 0 12199 0 12200 1 12201 48 12202 0 12203 0 12204 1 12205 48 12206 0 12207 0 12208 2 12209 52 12210 56 12211 0 12212 1 12213 49 12214 0
204/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
12215 0 12216 1 12217 48 12218 0 12219 0 12220 1 12221 48 12222 0 12223 0 12224 2 12225 52 12226 56 12227 0 12228 1 12229 49 12230 0 12231 0 12232 1 12233 48 12234 0 12235 0 12236 1 12237 48 12238 0 12239 0 12240 2 12241 52 12242 56 12243 0 12244 1 12245 49 12246 0 12247 0 12248 1 12249 48 12250 0 12251 0 12252 1 12253 48 12254 0 12255 0 12256 2 12257 52 12258 56 12259 0 12260 1 12261 49 12262 0 12263 0 12264 1 12265 48 12266 0 12267 0 12268 1 12269 48 12270 0 12271 0 12272 2 12273 52 12274 56
205/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
12275 0 12276 1 12277 49 12278 0 12279 0 12280 1 12281 48 12282 0 12283 0 12284 1 12285 48 12286 0 12287 0 12288 2 12289 52 12290 56 12291 0 12292 1 12293 49 12294 0 12295 0 12296 1 12297 48 12298 0 12299 0 12300 1 12301 48 12302 0 12303 0 12304 2 12305 52 12306 56 12307 0 12308 1 12309 49 12310 0 12311 0 12312 1 12313 48 12314 0 12315 0 12316 1 12317 48 12318 0 12319 0 12320 2 12321 52 12322 56 12323 0 12324 1 12325 49 12326 0 12327 0 12328 1 12329 48 12330 0 12331 0 12332 1 12333 48 12334 0
206/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
12335 0 12336 2 12337 52 12338 56 12339 0 12340 1 12341 49 12342 0 12343 0 12344 1 12345 48 12346 0 12347 0 12348 1 12349 48 12350 0 12351 0 12352 2 12353 52 12354 56 12355 0 12356 1 12357 49 12358 0 12359 0 12360 1 12361 48 12362 0 12363 0 12364 1 12365 48 12366 0 12367 0 12368 2 12369 52 12370 56 12371 0 12372 1 12373 49 12374 0 12375 0 12376 1 12377 48 12378 0 12379 0 12380 1 12381 48 12382 0 12383 0 12384 2 12385 52 12386 56 12387 0 12388 1 12389 49 12390 0 12391 0 12392 1 12393 48 12394 0
207/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
12395 0 12396 1 12397 48 12398 0 12399 0 12400 2 12401 52 12402 56 12403 0 12404 1 12405 49 12406 0 12407 0 12408 1 12409 48 12410 0 12411 0 12412 1 12413 48 12414 0 12415 0 12416 2 12417 52 12418 56 12419 0 12420 1 12421 49 12422 0 12423 0 12424 1 12425 48 12426 0 12427 0 12428 1 12429 48 12430 0 12431 0 12432 2 12433 52 12434 56 12435 0 12436 1 12437 49 12438 0 12439 0 12440 1 12441 48 12442 0 12443 0 12444 1 12445 48 12446 0 12447 0 12448 2 12449 52 12450 56 12451 0 12452 1 12453 49 12454 0
208/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
12455 0 12456 1 12457 48 12458 0 12459 0 12460 1 12461 48 12462 0 12463 0 12464 2 12465 52 12466 56 12467 0 12468 1 12469 49 12470 0 12471 0 12472 1 12473 48 12474 0 12475 0 12476 1 12477 48 12478 0 12479 0 12480 2 12481 52 12482 56 12483 0 12484 1 12485 49 12486 0 12487 0 12488 1 12489 48 12490 0 12491 0 12492 1 12493 48 12494 0 12495 0 12496 2 12497 52 12498 56 12499 0 12500 1 12501 49 12502 0 12503 0 12504 1 12505 48 12506 0 12507 0 12508 1 12509 48 12510 0 12511 0 12512 2 12513 52 12514 56
209/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
12515 0 12516 1 12517 49 12518 0 12519 0 12520 1 12521 48 12522 0 12523 0 12524 1 12525 48 12526 0 12527 0 12528 2 12529 52 12530 56 12531 0 12532 1 12533 49 12534 0 12535 0 12536 1 12537 48 12538 0 12539 0 12540 1 12541 48 12542 0 12543 0 12544 2 12545 52 12546 56 12547 0 12548 1 12549 49 12550 0 12551 0 12552 1 12553 48 12554 0 12555 0 12556 1 12557 48 12558 0 12559 0 12560 2 12561 52 12562 56 12563 0 12564 1 12565 49 12566 0 12567 0 12568 1 12569 48 12570 0 12571 0 12572 1 12573 48 12574 0
210/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
12575 0 12576 2 12577 52 12578 56 12579 0 12580 1 12581 49 12582 0 12583 0 12584 1 12585 48 12586 0 12587 0 12588 1 12589 48 12590 0 12591 0 12592 2 12593 52 12594 56 12595 0 12596 1 12597 49 12598 0 12599 0 12600 1 12601 48 12602 0 12603 0 12604 1 12605 48 12606 0 12607 0 12608 2 12609 52 12610 56 12611 0 12612 1 12613 49 12614 0 12615 0 12616 1 12617 48 12618 0 12619 0 12620 1 12621 48 12622 0 12623 0 12624 2 12625 52 12626 56 12627 0 12628 1 12629 49 12630 0 12631 0 12632 1 12633 48 12634 0
211/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
12635 0 12636 1 12637 48 12638 0 12639 0 12640 2 12641 52 12642 56 12643 0 12644 1 12645 49 12646 0 12647 0 12648 1 12649 48 12650 0 12651 0 12652 1 12653 48 12654 0 12655 0 12656 2 12657 52 12658 56 12659 0 12660 1 12661 49 12662 0 12663 0 12664 1 12665 48 12666 0 12667 0 12668 1 12669 48 12670 0 12671 0 12672 2 12673 52 12674 56 12675 0 12676 1 12677 49 12678 0 12679 0 12680 1 12681 48 12682 0 12683 0 12684 1 12685 48 12686 0 12687 0 12688 2 12689 52 12690 56 12691 0 12692 1 12693 49 12694 0
212/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
12695 0 12696 1 12697 48 12698 0 12699 0 12700 1 12701 48 12702 0 12703 0 12704 2 12705 52 12706 56 12707 0 12708 1 12709 49 12710 0 12711 0 12712 1 12713 48 12714 0 12715 0 12716 1 12717 48 12718 0 12719 0 12720 2 12721 52 12722 56 12723 0 12724 1 12725 49 12726 0 12727 0 12728 1 12729 48 12730 0 12731 0 12732 1 12733 48 12734 0 12735 0 12736 2 12737 52 12738 56 12739 0 12740 1 12741 49 12742 0 12743 0 12744 1 12745 48 12746 0 12747 0 12748 1 12749 48 12750 0 12751 0 12752 2 12753 52 12754 56
213/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
12755 0 12756 1 12757 49 12758 0 12759 0 12760 1 12761 48 12762 0 12763 0 12764 1 12765 48 12766 0 12767 0 12768 2 12769 52 12770 56 12771 0 12772 1 12773 49 12774 0 12775 0 12776 1 12777 48 12778 0 12779 0 12780 1 12781 48 12782 0 12783 0 12784 2 12785 52 12786 56 12787 0 12788 1 12789 49 12790 0 12791 0 12792 1 12793 48 12794 0 12795 0 12796 1 12797 48 12798 0 12799 0 12800 2 12801 52 12802 56 12803 0 12804 1 12805 49 12806 0 12807 0 12808 1 12809 48 12810 0 12811 0 12812 1 12813 48 12814 0
214/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
12815 0 12816 2 12817 52 12818 56 12819 0 12820 1 12821 49 12822 0 12823 0 12824 1 12825 48 12826 0 12827 0 12828 1 12829 48 12830 0 12831 0 12832 2 12833 52 12834 57 12835 0 12836 1 12837 49 12838 0 12839 0 12840 1 12841 48 12842 0 12843 0 12844 2 12845 53 12846 54 12847 0 12848 2 12849 53 12850 50 12851 0 12852 1 12853 50 12854 0 12855 0 12856 1 12857 48 12858 0 12859 0 12860 1 12861 48 12862 0 12863 0 12864 2 12865 52 12866 56 12867 0 12868 1 12869 49 12870 0 12871 0 12872 1 12873 48 12874 0
215/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
12875 0 12876 1 12877 48 12878 0 12879 0 12880 2 12881 52 12882 56 12883 0 12884 1 12885 49 12886 0 12887 0 12888 1 12889 48 12890 0 12891 0 12892 1 12893 48 12894 0 12895 0 12896 2 12897 52 12898 57 12899 0 12900 1 12901 49 12902 0 12903 0 12904 1 12905 48 12906 0 12907 0 12908 2 12909 53 12910 54 12911 0 12912 2 12913 53 12914 50 12915 0 12916 1 12917 50 12918 0 12919 0 12920 1 12921 48 12922 0 12923 0 12924 1 12925 48 12926 0 12927 0 12928 2 12929 52 12930 56 12931 0 12932 1 12933 49 12934 0
216/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
12935 0 12936 1 12937 48 12938 0 12939 0 12940 1 12941 48 12942 0 12943 0 12944 2 12945 52 12946 56 12947 0 12948 1 12949 49 12950 0 12951 0 12952 1 12953 48 12954 0 12955 0 12956 1 12957 48 12958 0 12959 0 12960 2 12961 52 12962 57 12963 0 12964 1 12965 49 12966 0 12967 0 12968 1 12969 48 12970 0 12971 0 12972 2 12973 53 12974 54 12975 0 12976 2 12977 53 12978 50 12979 0 12980 1 12981 50 12982 0 12983 0 12984 1 12985 48 12986 0 12987 0 12988 1 12989 48 12990 0 12991 0 12992 2 12993 52 12994 56
217/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
12995 0 12996 1 12997 49 12998 0 12999 0 13000 1 13001 48 13002 0 13003 0 13004 1 13005 48 13006 0 13007 0 13008 2 13009 52 13010 56 13011 0 13012 1 13013 49 13014 0 13015 0 13016 1 13017 48 13018 0 13019 0 13020 1 13021 48 13022 0 13023 0 13024 2 13025 52 13026 57 13027 0 13028 1 13029 49 13030 0 13031 0 13032 1 13033 48 13034 0 13035 0 13036 2 13037 53 13038 54 13039 0 13040 2 13041 53 13042 50 13043 0 13044 1 13045 50 13046 0 13047 0 13048 1 13049 48 13050 0 13051 0 13052 1 13053 48 13054 0
218/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
13055 0 13056 2 13057 52 13058 56 13059 0 13060 1 13061 49 13062 0 13063 0 13064 1 13065 48 13066 0 13067 0 13068 1 13069 48 13070 0 13071 0 13072 2 13073 52 13074 56 13075 0 13076 1 13077 49 13078 0 13079 0 13080 1 13081 48 13082 0 13083 0 13084 1 13085 48 13086 0 13087 0 13088 2 13089 52 13090 57 13091 0 13092 1 13093 49 13094 0 13095 0 13096 1 13097 48 13098 0 13099 0 13100 2 13101 53 13102 54 13103 0 13104 2 13105 53 13106 50 13107 0 13108 1 13109 50 13110 0 13111 0 13112 1 13113 48 13114 0
219/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
13115 0 13116 1 13117 48 13118 0 13119 0 13120 2 13121 52 13122 56 13123 0 13124 1 13125 49 13126 0 13127 0 13128 1 13129 48 13130 0 13131 0 13132 1 13133 48 13134 0 13135 0 13136 2 13137 52 13138 56 13139 0 13140 1 13141 49 13142 0 13143 0 13144 1 13145 48 13146 0 13147 0 13148 1 13149 48 13150 0 13151 0 13152 2 13153 53 13154 48 13155 0 13156 1 13157 49 13158 0 13159 0 13160 1 13161 48 13162 0 13163 0 13164 1 13165 48 13166 0 13167 0 13168 2 13169 52 13170 56 13171 0 13172 1 13173 49 13174 0
220/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
13175 0 13176 1 13177 48 13178 0 13179 0 13180 1 13181 48 13182 0 13183 0 13184 2 13185 52 13186 56 13187 0 13188 1 13189 49 13190 0 13191 0 13192 1 13193 48 13194 0 13195 0 13196 1 13197 48 13198 0 13199 0 13200 2 13201 52 13202 56 13203 0 13204 1 13205 49 13206 0 13207 0 13208 1 13209 48 13210 0 13211 0 13212 1 13213 48 13214 0 13215 0 13216 2 13217 52 13218 56 13219 0 13220 1 13221 49 13222 0 13223 0 13224 1 13225 48 13226 0 13227 0 13228 1 13229 48 13230 0 13231 0 13232 2 13233 52 13234 56
221/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
13235 0 13236 1 13237 49 13238 0 13239 0 13240 1 13241 48 13242 0 13243 0 13244 1 13245 48 13246 0 13247 0 13248 2 13249 52 13250 56 13251 0 13252 1 13253 49 13254 0 13255 0 13256 1 13257 48 13258 0 13259 0 13260 1 13261 48 13262 0 13263 0 13264 2 13265 52 13266 56 13267 0 13268 1 13269 49 13270 0 13271 0 13272 1 13273 48 13274 0 13275 0 13276 1 13277 48 13278 0 13279 0 13280 2 13281 52 13282 56 13283 0 13284 1 13285 49 13286 0 13287 0 13288 1 13289 48 13290 0 13291 0 13292 1 13293 48 13294 0
222/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
13295 0 13296 2 13297 52 13298 56 13299 0 13300 1 13301 49 13302 0 13303 0 13304 1 13305 48 13306 0 13307 0 13308 1 13309 48 13310 0 13311 0 13312 2 13313 52 13314 56 13315 0 13316 1 13317 49 13318 0 13319 0 13320 1 13321 48 13322 0 13323 0 13324 1 13325 48 13326 0 13327 0 13328 2 13329 52 13330 56 13331 0 13332 1 13333 49 13334 0 13335 0 13336 1 13337 48 13338 0 13339 0 13340 1 13341 48 13342 0 13343 0 13344 2 13345 52 13346 57 13347 0 13348 1 13349 49 13350 0 13351 0 13352 1 13353 48 13354 0
223/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
13355 0 13356 2 13357 53 13358 54 13359 0 13360 2 13361 53 13362 50 13363 0 13364 1 13365 50 13366 0 13367 0 13368 1 13369 48 13370 0 13371 0 13372 1 13373 48 13374 0 13375 0 13376 2 13377 52 13378 56 13379 0 13380 1 13381 49 13382 0 13383 0 13384 1 13385 48 13386 0 13387 0 13388 1 13389 48 13390 0 13391 0 13392 2 13393 52 13394 56 13395 0 13396 1 13397 49 13398 0 13399 0 13400 1 13401 48 13402 0 13403 0 13404 1 13405 48 13406 0 13407 0 13408 2 13409 52 13410 57 13411 0 13412 1 13413 49 13414 0
224/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
13415 0 13416 1 13417 48 13418 0 13419 0 13420 2 13421 53 13422 54 13423 0 13424 2 13425 53 13426 50 13427 0 13428 1 13429 50 13430 0 13431 0 13432 1 13433 48 13434 0 13435 0 13436 1 13437 48 13438 0 13439 0 13440 2 13441 52 13442 56 13443 0 13444 1 13445 49 13446 0 13447 0 13448 1 13449 48 13450 0 13451 0 13452 1 13453 48 13454 0 13455 0 13456 2 13457 52 13458 56 13459 0 13460 1 13461 49 13462 0 13463 0 13464 1 13465 48 13466 0 13467 0 13468 1 13469 48 13470 0 13471 0 13472 2 13473 52 13474 57
225/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
13475 0 13476 1 13477 49 13478 0 13479 0 13480 1 13481 48 13482 0 13483 0 13484 2 13485 53 13486 54 13487 0 13488 2 13489 53 13490 50 13491 0 13492 1 13493 50 13494 0 13495 0 13496 1 13497 48 13498 0 13499 0 13500 1 13501 48 13502 0 13503 0 13504 2 13505 52 13506 56 13507 0 13508 1 13509 49 13510 0 13511 0 13512 1 13513 48 13514 0 13515 0 13516 1 13517 48 13518 0 13519 0 13520 2 13521 52 13522 56 13523 0 13524 1 13525 49 13526 0 13527 0 13528 1 13529 48 13530 0 13531 0 13532 1 13533 48 13534 0
226/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
13535 0 13536 2 13537 52 13538 57 13539 0 13540 1 13541 49 13542 0 13543 0 13544 1 13545 48 13546 0 13547 0 13548 2 13549 53 13550 54 13551 0 13552 2 13553 53 13554 50 13555 0 13556 1 13557 50 13558 0 13559 0 13560 1 13561 48 13562 0 13563 0 13564 1 13565 48 13566 0 13567 0 13568 2 13569 52 13570 56 13571 0 13572 1 13573 49 13574 0 13575 0 13576 1 13577 48 13578 0 13579 0 13580 1 13581 48 13582 0 13583 0 13584 2 13585 52 13586 56 13587 0 13588 1 13589 49 13590 0 13591 0 13592 1 13593 48 13594 0
227/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
13595 0 13596 1 13597 48 13598 0 13599 0 13600 2 13601 52 13602 57 13603 0 13604 1 13605 49 13606 0 13607 0 13608 1 13609 48 13610 0 13611 0 13612 2 13613 53 13614 54 13615 0 13616 2 13617 53 13618 50 13619 0 13620 1 13621 50 13622 0 13623 0 13624 1 13625 48 13626 0 13627 0 13628 1 13629 48 13630 0 13631 0 13632 2 13633 52 13634 56 13635 0 13636 1 13637 49 13638 0 13639 0 13640 1 13641 48 13642 0 13643 0 13644 1 13645 48 13646 0 13647 0 13648 2 13649 52 13650 56 13651 0 13652 1 13653 49 13654 0
228/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
13655 0 13656 1 13657 48 13658 0 13659 0 13660 1 13661 48 13662 0 13663 0 13664 2 13665 52 13666 57 13667 0 13668 1 13669 49 13670 0 13671 0 13672 1 13673 48 13674 0 13675 0 13676 2 13677 53 13678 54 13679 0 13680 2 13681 53 13682 50 13683 0 13684 1 13685 50 13686 0 13687 0 13688 1 13689 48 13690 0 13691 0 13692 1 13693 48 13694 0 13695 0 13696 2 13697 52 13698 56 13699 0 13700 1 13701 49 13702 0 13703 0 13704 1 13705 48 13706 0 13707 0 13708 1 13709 48 13710 0 13711 0 13712 2 13713 52 13714 56
229/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
13715 0 13716 1 13717 49 13718 0 13719 0 13720 1 13721 48 13722 0 13723 0 13724 1 13725 48 13726 0 13727 0 13728 2 13729 52 13730 57 13731 0 13732 1 13733 49 13734 0 13735 0 13736 1 13737 48 13738 0 13739 0 13740 2 13741 53 13742 54 13743 0 13744 2 13745 53 13746 50 13747 0 13748 1 13749 50 13750 0 13751 0 13752 1 13753 48 13754 0 13755 0 13756 1 13757 48 13758 0 13759 0 13760 2 13761 52 13762 56 13763 0 13764 1 13765 49 13766 0 13767 0 13768 1 13769 48 13770 0 13771 0 13772 1 13773 48 13774 0
230/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
13775 0 13776 2 13777 52 13778 56 13779 0 13780 1 13781 49 13782 0 13783 0 13784 1 13785 48 13786 0 13787 0 13788 1 13789 48 13790 0 13791 0 13792 2 13793 52 13794 57 13795 0 13796 1 13797 49 13798 0 13799 0 13800 1 13801 48 13802 0 13803 0 13804 2 13805 53 13806 54 13807 0 13808 2 13809 53 13810 50 13811 0 13812 1 13813 50 13814 0 13815 0 13816 1 13817 48 13818 0 13819 0 13820 1 13821 48 13822 0 13823 0 13824 2 13825 52 13826 56 13827 0 13828 1 13829 49 13830 0 13831 0 13832 1 13833 48 13834 0
231/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
13835 0 13836 1 13837 48 13838 0 13839 0 13840 2 13841 52 13842 56 13843 0 13844 1 13845 49 13846 0 13847 0 13848 1 13849 48 13850 0 13851 0 13852 1 13853 48 13854 0 13855 0 13856 2 13857 52 13858 57 13859 0 13860 1 13861 49 13862 0 13863 0 13864 1 13865 48 13866 0 13867 0 13868 2 13869 53 13870 54 13871 0 13872 2 13873 53 13874 50 13875 0 13876 1 13877 50 13878 0 13879 0 13880 1 13881 48 13882 0 13883 0 13884 1 13885 48 13886 0 13887 0 13888 2 13889 52 13890 56 13891 0 13892 1 13893 49 13894 0
232/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
13895 0 13896 1 13897 48 13898 0 13899 0 13900 1 13901 48 13902 0 13903 0 13904 2 13905 52 13906 56 13907 0 13908 1 13909 49 13910 0 13911 0 13912 1 13913 48 13914 0 13915 0 13916 1 13917 48 13918 0 13919 0 13920 2 13921 52 13922 57 13923 0 13924 1 13925 49 13926 0 13927 0 13928 1 13929 48 13930 0 13931 0 13932 2 13933 53 13934 54 13935 0 13936 2 13937 53 13938 50 13939 0 13940 1 13941 50 13942 0 13943 0 13944 1 13945 48 13946 0 13947 0 13948 1 13949 48 13950 0 13951 0 13952 2 13953 52 13954 56
233/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
13955 0 13956 1 13957 49 13958 0 13959 0 13960 1 13961 48 13962 0 13963 0 13964 1 13965 48 13966 0 13967 0 13968 2 13969 52 13970 56 13971 0 13972 1 13973 49 13974 0 13975 0 13976 1 13977 48 13978 0 13979 0 13980 1 13981 48 13982 0 13983 0 13984 2 13985 52 13986 57 13987 0 13988 1 13989 49 13990 0 13991 0 13992 1 13993 48 13994 0 13995 0 13996 2 13997 53 13998 54 13999 0 14000 2 14001 53 14002 50 14003 0 14004 1 14005 50 14006 0 14007 0 14008 1 14009 48 14010 0 14011 0 14012 1 14013 48 14014 0
234/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
14015 0 14016 2 14017 52 14018 56 14019 0 14020 1 14021 49 14022 0 14023 0 14024 1 14025 48 14026 0 14027 0 14028 1 14029 48 14030 0 14031 0 14032 2 14033 52 14034 56 14035 0 14036 1 14037 49 14038 0 14039 0 14040 1 14041 48 14042 0 14043 0 14044 1 14045 48 14046 0 14047 0 14048 2 14049 52 14050 57 14051 0 14052 1 14053 49 14054 0 14055 0 14056 1 14057 48 14058 0 14059 0 14060 2 14061 53 14062 54 14063 0 14064 2 14065 53 14066 50 14067 0 14068 1 14069 50 14070 0 14071 0 14072 1 14073 48 14074 0
235/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
14075 0 14076 1 14077 48 14078 0 14079 0 14080 2 14081 52 14082 56 14083 0 14084 1 14085 49 14086 0 14087 0 14088 1 14089 48 14090 0 14091 0 14092 1 14093 48 14094 0 14095 0 14096 2 14097 52 14098 56 14099 0 14100 1 14101 49 14102 0 14103 0 14104 1 14105 48 14106 0 14107 0 14108 1 14109 48 14110 0 14111 0 14112 2 14113 52 14114 57 14115 0 14116 1 14117 49 14118 0 14119 0 14120 1 14121 48 14122 0 14123 0 14124 2 14125 53 14126 54 14127 0 14128 2 14129 53 14130 50 14131 0 14132 1 14133 50 14134 0
236/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
14135 0 14136 1 14137 48 14138 0 14139 0 14140 1 14141 48 14142 0 14143 0 14144 2 14145 52 14146 56 14147 0 14148 1 14149 49 14150 0 14151 0 14152 1 14153 48 14154 0 14155 0 14156 1 14157 48 14158 0 14159 0 14160 2 14161 52 14162 56 14163 0 14164 1 14165 49 14166 0 14167 0 14168 1 14169 48 14170 0 14171 0 14172 1 14173 48 14174 0 14175 0 14176 2 14177 52 14178 57 14179 0 14180 1 14181 49 14182 0 14183 0 14184 1 14185 48 14186 0 14187 0 14188 2 14189 53 14190 54 14191 0 14192 2 14193 53 14194 50
237/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
14195 0 14196 1 14197 50 14198 0 14199 0 14200 1 14201 48 14202 0 14203 0 14204 1 14205 48 14206 0 14207 0 14208 2 14209 52 14210 56 14211 0 14212 1 14213 49 14214 0 14215 0 14216 1 14217 48 14218 0 14219 0 14220 1 14221 48 14222 0 14223 0 14224 2 14225 52 14226 56 14227 0 14228 1 14229 49 14230 0 14231 0 14232 1 14233 48 14234 0 14235 0 14236 1 14237 48 14238 0 14239 0 14240 2 14241 52 14242 57 14243 0 14244 1 14245 49 14246 0 14247 0 14248 1 14249 48 14250 0 14251 0 14252 2 14253 53 14254 54
238/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
14255 0 14256 2 14257 53 14258 50 14259 0 14260 1 14261 50 14262 0 14263 0 14264 1 14265 48 14266 0 14267 0 14268 1 14269 48 14270 0 14271 0 14272 2 14273 52 14274 56 14275 0 14276 1 14277 49 14278 0 14279 0 14280 1 14281 48 14282 0 14283 0 14284 1 14285 48 14286 0 14287 0 14288 2 14289 52 14290 56 14291 0 14292 1 14293 49 14294 0 14295 0 14296 1 14297 48 14298 0 14299 0 14300 1 14301 48 14302 0 14303 0 14304 2 14305 52 14306 57 14307 0 14308 1 14309 49 14310 0 14311 0 14312 1 14313 48 14314 0
239/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
14315 0
14316 2
14317 53 14318 54 14319 0
14320 2
14321 53 14322 50 14323 0
14324 1
14325 50 14326 0
14327 0
14328 1
14329 48 14330 0
14331 0
14332 1
14333 48 14334 0
14335 0
14336 2
14337 52 14338 56 14339 0
14340 1
14341 49 14342 0
14343 0
14344 0
14345 0
14346 0
14347 0
14348 0
14349 0
14350 1
14351 48 14352 0
14353 0
14354 0
14355 0
14356 21917696 14357 0
14358 0
14359 0
14360 0
14361 0
14362 21917792 14363 0
14364 0
14365 0
14366 0
14367 0
14368 21917840 14369 0
14370 0
14371 0
14372 0
14373 0
14374 21917888
240/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
14375 0
14376 0
14377 0
14378 0
14379 0
14380 21917936 14381 0
14382 0
14383 0
14384 0
14385 0
14386 21917984 14387 0
14388 0
14389 0
14390 0
14391 0
14392 21918032 14393 0
14394 0
14395 0
14396 0
14397 0
14398 21918080 14399 0
14400 0
14401 0
14402 0
14403 0
14404 21918128 14405 0
14406 0
14407 0
14408 0
14409 0
14410 21918176 14411 0
14412 0
14413 0
14414 0
14415 0
14416 21918224 14417 0
14418 0
14419 0
14420 0
14421 0
14422 21918272 14423 0
14424 0
14425 0
14426 0
14427 0
14428 21918320 14429 0
14430 0
14431 0
14432 0
14433 0
14434 21918368
241/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
14435 0
14436 0
14437 0
14438 0
14439 0
14440 21918416 14441 0
14442 0
14443 0
14444 0
14445 0
14446 21918464 14447 0
14448 0
14449 0
14450 0
14451 0
14452 21918512 14453 0
14454 0
14455 0
14456 0
14457 0
14458 21918560 14459 0
14460 0
14461 0
14462 0
14463 0
14464 21918608 14465 0
14466 0
14467 0
14468 0
14469 0
14470 21918656 14471 0
14472 0
14473 0
14474 0
14475 0
14476 21918704 14477 0
14478 0
14479 0
14480 0
14481 0
14482 21918752 14483 0
14484 0
14485 0
14486 0
14487 0
14488 21918800 14489 0
14490 0
14491 0
14492 0
14493 0
14494 21918848
242/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
14495 0
14496 0
14497 0
14498 0
14499 0
14500 21918896 14501 0
14502 0
14503 0
14504 0
14505 0
14506 21918944 14507 0
14508 0
14509 0
14510 0
14511 0
14512 21918992 14513 0
14514 0
14515 0
14516 0
14517 0
14518 21919040 14519 0
14520 0
14521 0
14522 0
14523 0
14524 21919088 14525 0
14526 0
14527 0
14528 0
14529 0
14530 21919136 14531 0
14532 0
14533 0
14534 0
14535 0
14536 21919184 14537 0
14538 0
14539 0
14540 0
14541 0
14542 21919232 14543 0
14544 0
14545 0
14546 0
14547 0
14548 21919280 14549 0
14550 0
14551 0
14552 0
14553 0
14554 21919328
243/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
14555 0
14556 0
14557 0
14558 0
14559 0
14560 21919376 14561 0
14562 0
14563 0
14564 0
14565 0
14566 21919424 14567 0
14568 0
14569 0
14570 0
14571 0
14572 21919472 14573 0
14574 0
14575 0
14576 0
14577 0
14578 21919520 14579 0
14580 0
14581 0
14582 0
14583 0
14584 21919568 14585 0
14586 0
14587 0
14588 0
14589 0
14590 21919616 14591 0
14592 0
14593 0
14594 0
14595 0
14596 21919664 14597 0
14598 0
14599 0
14600 0
14601 0
14602 21919712 14603 0
14604 0
14605 0
14606 0
14607 0
14608 21919760 14609 0
14610 0
14611 0
14612 0
14613 0
14614 21919808
244/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
14615 0
14616 0
14617 0
14618 0
14619 0
14620 21919856 14621 0
14622 0
14623 0
14624 0
14625 0
14626 21919904 14627 0
14628 0
14629 0
14630 0
14631 0
14632 21919952 14633 0
14634 0
14635 0
14636 0
14637 0
14638 21920000 14639 0
14640 0
14641 0
14642 0
14643 0
14644 21920048 14645 0
14646 0
14647 0
14648 0
14649 0
14650 21920096 14651 0
14652 0
14653 0
14654 0
14655 0
14656 21920144 14657 0
14658 0
14659 0
14660 0
14661 0
14662 21920192 14663 0
14664 0
14665 0
14666 0
14667 0
14668 21920240 14669 0
14670 0
14671 0
14672 0
14673 0
14674 21920288
245/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
14675 0
14676 0
14677 0
14678 0
14679 0
14680 21920336 14681 0
14682 0
14683 0
14684 0
14685 0
14686 21920384 14687 0
14688 0
14689 0
14690 0
14691 0
14692 21920432 14693 0
14694 0
14695 0
14696 0
14697 0
14698 21920480 14699 0
14700 0
14701 0
14702 0
14703 0
14704 21920528 14705 0
14706 0
14707 0
14708 0
14709 0
14710 21920576 14711 0
14712 0
14713 0
14714 0
14715 0
14716 21920624 14717 0
14718 0
14719 0
14720 0
14721 0
14722 21920672 14723 0
14724 0
14725 0
14726 0
14727 0
14728 21920720 14729 0
14730 0
14731 0
14732 0
14733 0
14734 21920768
246/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
14735 0
14736 0
14737 0
14738 0
14739 0
14740 21920816 14741 0
14742 0
14743 0
14744 0
14745 0
14746 21920864 14747 0
14748 0
14749 0
14750 0
14751 0
14752 21920912 14753 0
14754 0
14755 0
14756 0
14757 0
14758 21920960 14759 0
14760 0
14761 0
14762 0
14763 0
14764 21921008 14765 0
14766 0
14767 0
14768 0
14769 0
14770 21921056 14771 0
14772 0
14773 0
14774 0
14775 0
14776 21921104 14777 0
14778 0
14779 0
14780 0
14781 0
14782 21921152 14783 0
14784 0
14785 0
14786 0
14787 0
14788 21921200 14789 0
14790 0
14791 0
14792 0
14793 0
14794 21921248
247/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
14795 0
14796 0
14797 0
14798 0
14799 0
14800 21921296 14801 0
14802 0
14803 0
14804 0
14805 0
14806 21921344 14807 0
14808 0
14809 0
14810 0
14811 0
14812 21921392 14813 0
14814 0
14815 0
14816 0
14817 0
14818 21921440 14819 0
14820 0
14821 0
14822 0
14823 0
14824 21921488 14825 0
14826 0
14827 0
14828 0
14829 0
14830 21921536 14831 0
14832 0
14833 0
14834 0
14835 0
14836 21921584 14837 0
14838 0
14839 0
14840 0
14841 0
14842 21921632 14843 0
14844 0 14845 0 14846 0 14847 0 14848 1 14849 50 14850 0 14851 0 14852 0 14853 0 14854 0
248/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
14855 0 14856 1 14857 48 14858 0 14859 0 14860 1 14861 48 14862 0 14863 0 14864 2 14865 52 14866 56 14867 0 14868 1 14869 49 14870 0 14871 0 14872 1 14873 48 14874 0 14875 0 14876 1 14877 48 14878 0 14879 0 14880 2 14881 52 14882 57 14883 0 14884 1 14885 49 14886 0 14887 0 14888 1 14889 48 14890 0 14891 0 14892 2 14893 53 14894 54 14895 0 14896 2 14897 53 14898 50 14899 0 14900 1 14901 50 14902 0 14903 0 14904 1 14905 48 14906 0 14907 0 14908 1 14909 48 14910 0 14911 0 14912 2 14913 52 14914 56
249/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
14915 0 14916 1 14917 49 14918 0 14919 0 14920 1 14921 48 14922 0 14923 0 14924 1 14925 48 14926 0 14927 0 14928 2 14929 52 14930 56 14931 0 14932 1 14933 49 14934 0 14935 0 14936 1 14937 48 14938 0 14939 0 14940 1 14941 48 14942 0 14943 0 14944 2 14945 52 14946 57 14947 0 14948 1 14949 49 14950 0 14951 0 14952 1 14953 48 14954 0 14955 0 14956 2 14957 53 14958 54 14959 0 14960 2 14961 53 14962 50 14963 0 14964 1 14965 50 14966 0 14967 0 14968 1 14969 48 14970 0 14971 0 14972 1 14973 48 14974 0
250/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
14975 0 14976 2 14977 52 14978 56 14979 0 14980 1 14981 49 14982 0 14983 0 14984 1 14985 48 14986 0 14987 0 14988 1 14989 48 14990 0 14991 0 14992 2 14993 52 14994 56 14995 0 14996 1 14997 49 14998 0 14999 0 15000 1 15001 48 15002 0 15003 0 15004 1 15005 48 15006 0 15007 0 15008 2 15009 52 15010 57 15011 0 15012 1 15013 49 15014 0 15015 0 15016 1 15017 48 15018 0 15019 0 15020 2 15021 53 15022 54 15023 0 15024 2 15025 53 15026 50 15027 0 15028 1 15029 50 15030 0 15031 0 15032 1 15033 48 15034 0
251/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
15035 0 15036 1 15037 48 15038 0 15039 0 15040 2 15041 52 15042 56 15043 0 15044 1 15045 49 15046 0 15047 0 15048 1 15049 48 15050 0 15051 0 15052 1 15053 48 15054 0 15055 0 15056 2 15057 52 15058 56 15059 0 15060 1 15061 49 15062 0 15063 0 15064 1 15065 48 15066 0 15067 0 15068 1 15069 48 15070 0 15071 0 15072 2 15073 52 15074 57 15075 0 15076 1 15077 49 15078 0 15079 0 15080 1 15081 48 15082 0 15083 0 15084 2 15085 53 15086 54 15087 0 15088 2 15089 53 15090 50 15091 0 15092 1 15093 50 15094 0
252/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
15095 0 15096 1 15097 48 15098 0 15099 0 15100 1 15101 48 15102 0 15103 0 15104 2 15105 52 15106 56 15107 0 15108 1 15109 49 15110 0 15111 0 15112 1 15113 48 15114 0 15115 0 15116 1 15117 48 15118 0 15119 0 15120 2 15121 52 15122 56 15123 0 15124 1 15125 49 15126 0 15127 0 15128 1 15129 48 15130 0 15131 0 15132 1 15133 48 15134 0 15135 0 15136 2 15137 52 15138 57 15139 0 15140 1 15141 49 15142 0 15143 0 15144 1 15145 48 15146 0 15147 0 15148 2 15149 53 15150 54 15151 0 15152 2 15153 53 15154 50
253/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
15155 0 15156 1 15157 50 15158 0 15159 0 15160 1 15161 48 15162 0 15163 0 15164 1 15165 48 15166 0 15167 0 15168 2 15169 52 15170 56 15171 0 15172 1 15173 49 15174 0 15175 0 15176 1 15177 48 15178 0 15179 0 15180 1 15181 48 15182 0 15183 0 15184 2 15185 52 15186 56 15187 0 15188 1 15189 49 15190 0 15191 0 15192 1 15193 48 15194 0 15195 0 15196 1 15197 48 15198 0 15199 0 15200 2 15201 52 15202 57 15203 0 15204 1 15205 49 15206 0 15207 0 15208 1 15209 48 15210 0 15211 0 15212 2 15213 53 15214 54
254/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
15215 0 15216 2 15217 53 15218 50 15219 0 15220 1 15221 50 15222 0 15223 0 15224 1 15225 48 15226 0 15227 0 15228 1 15229 48 15230 0 15231 0 15232 2 15233 52 15234 56 15235 0 15236 1 15237 49 15238 0 15239 0 15240 1 15241 48 15242 0 15243 0 15244 1 15245 48 15246 0 15247 0 15248 2 15249 52 15250 56 15251 0 15252 1 15253 49 15254 0 15255 0 15256 1 15257 48 15258 0 15259 0 15260 1 15261 48 15262 0 15263 0 15264 2 15265 52 15266 57 15267 0 15268 1 15269 49 15270 0 15271 0 15272 1 15273 48 15274 0
255/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
15275 0 15276 2 15277 53 15278 54 15279 0 15280 2 15281 53 15282 50 15283 0 15284 1 15285 50 15286 0 15287 0 15288 1 15289 48 15290 0 15291 0 15292 1 15293 48 15294 0 15295 0 15296 2 15297 52 15298 56 15299 0 15300 1 15301 49 15302 0 15303 0 15304 1 15305 48 15306 0 15307 0 15308 1 15309 48 15310 0 15311 0 15312 2 15313 52 15314 56 15315 0 15316 1 15317 49 15318 0 15319 0 15320 1 15321 48 15322 0 15323 0 15324 1 15325 48 15326 0 15327 0 15328 2 15329 52 15330 57 15331 0 15332 1 15333 49 15334 0
256/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
15335 0 15336 1 15337 48 15338 0 15339 0 15340 2 15341 53 15342 54 15343 0 15344 2 15345 53 15346 50 15347 0 15348 1 15349 50 15350 0 15351 0 15352 1 15353 48 15354 0 15355 0 15356 1 15357 48 15358 0 15359 0 15360 2 15361 52 15362 56 15363 0 15364 1 15365 49 15366 0 15367 0 15368 1 15369 48 15370 0 15371 0 15372 1 15373 48 15374 0 15375 0 15376 2 15377 52 15378 56 15379 0 15380 1 15381 49 15382 0 15383 0 15384 1 15385 48 15386 0 15387 0 15388 1 15389 48 15390 0 15391 0 15392 2 15393 52 15394 57
257/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
15395 0 15396 1 15397 49 15398 0 15399 0 15400 1 15401 48 15402 0 15403 0 15404 2 15405 53 15406 54 15407 0 15408 2 15409 53 15410 50 15411 0 15412 1 15413 50 15414 0 15415 0 15416 1 15417 48 15418 0 15419 0 15420 1 15421 48 15422 0 15423 0 15424 2 15425 52 15426 56 15427 0 15428 1 15429 49 15430 0 15431 0 15432 1 15433 48 15434 0 15435 0 15436 1 15437 48 15438 0 15439 0 15440 2 15441 52 15442 56 15443 0 15444 1 15445 49 15446 0 15447 0 15448 1 15449 48 15450 0 15451 0 15452 1 15453 48 15454 0
258/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
15455 0 15456 2 15457 52 15458 57 15459 0 15460 1 15461 49 15462 0 15463 0 15464 1 15465 48 15466 0 15467 0 15468 2 15469 53 15470 54 15471 0 15472 2 15473 53 15474 50 15475 0 15476 1 15477 50 15478 0 15479 0 15480 1 15481 48 15482 0 15483 0 15484 1 15485 48 15486 0 15487 0 15488 2 15489 52 15490 56 15491 0 15492 1 15493 49 15494 0 15495 0 15496 1 15497 48 15498 0 15499 0 15500 1 15501 48 15502 0 15503 0 15504 2 15505 52 15506 56 15507 0 15508 1 15509 49 15510 0 15511 0 15512 1 15513 48 15514 0
259/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
15515 0 15516 1 15517 48 15518 0 15519 0 15520 2 15521 52 15522 57 15523 0 15524 1 15525 49 15526 0 15527 0 15528 1 15529 48 15530 0 15531 0 15532 2 15533 53 15534 54 15535 0 15536 2 15537 53 15538 50 15539 0 15540 1 15541 50 15542 0 15543 0 15544 1 15545 48 15546 0 15547 0 15548 1 15549 48 15550 0 15551 0 15552 2 15553 52 15554 56 15555 0 15556 1 15557 49 15558 0 15559 0 15560 1 15561 48 15562 0 15563 0 15564 1 15565 48 15566 0 15567 0 15568 2 15569 52 15570 56 15571 0 15572 1 15573 49 15574 0
260/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
15575 0 15576 1 15577 48 15578 0 15579 0 15580 1 15581 48 15582 0 15583 0 15584 2 15585 52 15586 57 15587 0 15588 1 15589 49 15590 0 15591 0 15592 1 15593 48 15594 0 15595 0 15596 2 15597 53 15598 54 15599 0 15600 2 15601 53 15602 50 15603 0 15604 1 15605 50 15606 0 15607 0 15608 1 15609 48 15610 0 15611 0 15612 1 15613 48 15614 0 15615 0 15616 2 15617 52 15618 56 15619 0 15620 1 15621 49 15622 0 15623 0 15624 1 15625 48 15626 0 15627 0 15628 1 15629 48 15630 0 15631 0 15632 2 15633 52 15634 56
261/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
15635 0 15636 1 15637 49 15638 0 15639 0 15640 1 15641 48 15642 0 15643 0 15644 1 15645 48 15646 0 15647 0 15648 2 15649 52 15650 57 15651 0 15652 1 15653 49 15654 0 15655 0 15656 1 15657 48 15658 0 15659 0 15660 2 15661 53 15662 54 15663 0 15664 2 15665 53 15666 50 15667 0 15668 1 15669 50 15670 0 15671 0 15672 1 15673 48 15674 0 15675 0 15676 1 15677 48 15678 0 15679 0 15680 2 15681 52 15682 56 15683 0 15684 1 15685 49 15686 0 15687 0 15688 1 15689 48 15690 0 15691 0 15692 1 15693 48 15694 0
262/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
15695 0 15696 2 15697 52 15698 56 15699 0 15700 1 15701 49 15702 0 15703 0 15704 1 15705 48 15706 0 15707 0 15708 1 15709 48 15710 0 15711 0 15712 2 15713 52 15714 57 15715 0 15716 1 15717 49 15718 0 15719 0 15720 1 15721 48 15722 0 15723 0 15724 2 15725 53 15726 54 15727 0 15728 2 15729 53 15730 50 15731 0 15732 1 15733 50 15734 0 15735 0 15736 1 15737 48 15738 0 15739 0 15740 1 15741 48 15742 0 15743 0 15744 2 15745 52 15746 56 15747 0 15748 1 15749 49 15750 0 15751 0 15752 1 15753 48 15754 0
263/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
15755 0 15756 1 15757 48 15758 0 15759 0 15760 2 15761 52 15762 56 15763 0 15764 1 15765 49 15766 0 15767 0 15768 1 15769 48 15770 0 15771 0 15772 1 15773 48 15774 0 15775 0 15776 2 15777 52 15778 57 15779 0 15780 1 15781 49 15782 0 15783 0 15784 1 15785 48 15786 0 15787 0 15788 2 15789 53 15790 54 15791 0 15792 2 15793 53 15794 50 15795 0 15796 1 15797 50 15798 0 15799 0 15800 1 15801 48 15802 0 15803 0 15804 1 15805 48 15806 0 15807 0 15808 2 15809 52 15810 56 15811 0 15812 1 15813 49 15814 0
264/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
15815 0 15816 1 15817 48 15818 0 15819 0 15820 1 15821 48 15822 0 15823 0 15824 2 15825 52 15826 56 15827 0 15828 1 15829 49 15830 0 15831 0 15832 1 15833 48 15834 0 15835 0 15836 1 15837 48 15838 0 15839 0 15840 2 15841 52 15842 57 15843 0 15844 1 15845 49 15846 0 15847 0 15848 1 15849 48 15850 0 15851 0 15852 2 15853 53 15854 54 15855 0 15856 2 15857 53 15858 50 15859 0 15860 1 15861 50 15862 0 15863 0 15864 1 15865 48 15866 0 15867 0 15868 1 15869 48 15870 0 15871 0 15872 2 15873 52 15874 56
265/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
15875 0 15876 1 15877 49 15878 0 15879 0 15880 1 15881 48 15882 0 15883 0 15884 1 15885 48 15886 0 15887 0 15888 2 15889 52 15890 56 15891 0 15892 1 15893 49 15894 0 15895 0 15896 1 15897 48 15898 0 15899 0 15900 1 15901 48 15902 0 15903 0 15904 2 15905 52 15906 57 15907 0 15908 1 15909 49 15910 0 15911 0 15912 1 15913 48 15914 0 15915 0 15916 2 15917 53 15918 54 15919 0 15920 2 15921 53 15922 50 15923 0 15924 1 15925 50 15926 0 15927 0 15928 1 15929 48 15930 0 15931 0 15932 1 15933 48 15934 0
266/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
15935 0 15936 2 15937 52 15938 56 15939 0 15940 1 15941 49 15942 0 15943 0 15944 1 15945 48 15946 0 15947 0 15948 1 15949 48 15950 0 15951 0 15952 2 15953 52 15954 56 15955 0 15956 1 15957 49 15958 0 15959 0 15960 1 15961 48 15962 0 15963 0 15964 1 15965 48 15966 0 15967 0 15968 2 15969 52 15970 57 15971 0 15972 1 15973 49 15974 0 15975 0 15976 1 15977 48 15978 0 15979 0 15980 2 15981 53 15982 54 15983 0 15984 2 15985 53 15986 50 15987 0 15988 1 15989 50 15990 0 15991 0 15992 1 15993 48 15994 0
267/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
15995 0 15996 1 15997 48 15998 0 15999 0 16000 2 16001 52 16002 56 16003 0 16004 1 16005 49 16006 0 16007 0 16008 1 16009 48 16010 0 16011 0 16012 1 16013 48 16014 0 16015 0 16016 2 16017 52 16018 56 16019 0 16020 1 16021 49 16022 0 16023 0 16024 1 16025 48 16026 0 16027 0 16028 1 16029 48 16030 0 16031 0 16032 2 16033 52 16034 57 16035 0 16036 1 16037 49 16038 0 16039 0 16040 1 16041 48 16042 0 16043 0 16044 2 16045 53 16046 54 16047 0 16048 2 16049 53 16050 50 16051 0 16052 1 16053 50 16054 0
268/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
16055 0 16056 1 16057 48 16058 0 16059 0 16060 1 16061 48 16062 0 16063 0 16064 2 16065 52 16066 56 16067 0 16068 1 16069 49 16070 0 16071 0 16072 1 16073 48 16074 0 16075 0 16076 1 16077 48 16078 0 16079 0 16080 2 16081 52 16082 56 16083 0 16084 1 16085 49 16086 0 16087 0 16088 1 16089 48 16090 0 16091 0 16092 1 16093 48 16094 0 16095 0 16096 2 16097 52 16098 57 16099 0 16100 1 16101 49 16102 0 16103 0 16104 1 16105 48 16106 0 16107 0 16108 2 16109 53 16110 54 16111 0 16112 2 16113 53 16114 50
269/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
16115 0 16116 1 16117 50 16118 0 16119 0 16120 1 16121 48 16122 0 16123 0 16124 1 16125 48 16126 0 16127 0 16128 2 16129 52 16130 56 16131 0 16132 1 16133 49 16134 0 16135 0 16136 1 16137 48 16138 0 16139 0 16140 1 16141 48 16142 0 16143 0 16144 2 16145 52 16146 56 16147 0 16148 1 16149 49 16150 0 16151 0 16152 1 16153 48 16154 0 16155 0 16156 1 16157 48 16158 0 16159 0 16160 2 16161 52 16162 57 16163 0 16164 1 16165 49 16166 0 16167 0 16168 1 16169 48 16170 0 16171 0 16172 2 16173 53 16174 54
270/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
16175 0 16176 2 16177 53 16178 50 16179 0 16180 1 16181 50 16182 0 16183 0 16184 1 16185 48 16186 0 16187 0 16188 1 16189 48 16190 0 16191 0 16192 2 16193 52 16194 56 16195 0 16196 1 16197 49 16198 0 16199 0 16200 1 16201 48 16202 0 16203 0 16204 1 16205 48 16206 0 16207 0 16208 2 16209 52 16210 56 16211 0 16212 1 16213 49 16214 0 16215 0 16216 1 16217 48 16218 0 16219 0 16220 1 16221 48 16222 0 16223 0 16224 2 16225 52 16226 57 16227 0 16228 1 16229 49 16230 0 16231 0 16232 1 16233 48 16234 0
271/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
16235 0 16236 2 16237 53 16238 54 16239 0 16240 2 16241 53 16242 50 16243 0 16244 1 16245 50 16246 0 16247 0 16248 1 16249 48 16250 0 16251 0 16252 1 16253 48 16254 0 16255 0 16256 2 16257 52 16258 56 16259 0 16260 1 16261 49 16262 0 16263 0 16264 1 16265 48 16266 0 16267 0 16268 1 16269 48 16270 0 16271 0 16272 2 16273 52 16274 56 16275 0 16276 1 16277 49 16278 0 16279 0 16280 1 16281 48 16282 0 16283 0 16284 1 16285 48 16286 0 16287 0 16288 2 16289 52 16290 57 16291 0 16292 1 16293 49 16294 0
272/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
16295 0 16296 1 16297 48 16298 0 16299 0 16300 2 16301 53 16302 54 16303 0 16304 2 16305 53 16306 50 16307 0 16308 1 16309 50 16310 0 16311 0 16312 1 16313 48 16314 0 16315 0 16316 1 16317 48 16318 0 16319 0 16320 2 16321 52 16322 56 16323 0 16324 1 16325 49 16326 0 16327 0 16328 1 16329 48 16330 0 16331 0 16332 1 16333 48 16334 0 16335 0 16336 2 16337 52 16338 56 16339 0 16340 1 16341 49 16342 0 16343 0 16344 1 16345 48 16346 0 16347 0 16348 1 16349 48 16350 0 16351 0 16352 2 16353 52 16354 57
273/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
16355 0 16356 1 16357 49 16358 0 16359 0 16360 1 16361 48 16362 0 16363 0 16364 2 16365 53 16366 54 16367 0 16368 2 16369 53 16370 50 16371 0 16372 1 16373 50 16374 0 16375 0 16376 1 16377 48 16378 0 16379 0 16380 1 16381 48 16382 0 16383 0 16384 2 16385 52 16386 56 16387 0 16388 1 16389 49 16390 0 16391 0 16392 1 16393 48 16394 0 16395 0 16396 1 16397 48 16398 0 16399 0 16400 2 16401 52 16402 56 16403 0 16404 1 16405 49 16406 0 16407 0 16408 1 16409 48 16410 0 16411 0 16412 1 16413 48 16414 0
274/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
16415 0 16416 2 16417 52 16418 57 16419 0 16420 1 16421 49 16422 0 16423 0 16424 1 16425 48 16426 0 16427 0 16428 2 16429 53 16430 54 16431 0 16432 2 16433 53 16434 50 16435 0 16436 1 16437 50 16438 0 16439 0 16440 1 16441 48 16442 0 16443 0 16444 1 16445 48 16446 0 16447 0 16448 2 16449 52 16450 56 16451 0 16452 1 16453 49 16454 0 16455 0 16456 1 16457 48 16458 0 16459 0 16460 1 16461 48 16462 0 16463 0 16464 2 16465 52 16466 56 16467 0 16468 1 16469 49 16470 0 16471 0 16472 1 16473 48 16474 0
275/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
16475 0 16476 1 16477 48 16478 0 16479 0 16480 2 16481 52 16482 57 16483 0 16484 1 16485 49 16486 0 16487 0 16488 1 16489 48 16490 0 16491 0 16492 2 16493 53 16494 54 16495 0 16496 2 16497 53 16498 50 16499 0 16500 1 16501 50 16502 0 16503 0 16504 1 16505 48 16506 0 16507 0 16508 1 16509 48 16510 0 16511 0 16512 2 16513 52 16514 56 16515 0 16516 1 16517 49 16518 0 16519 0 16520 1 16521 48 16522 0 16523 0 16524 1 16525 48 16526 0 16527 0 16528 2 16529 52 16530 56 16531 0 16532 1 16533 49 16534 0
276/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
16535 0 16536 1 16537 48 16538 0 16539 0 16540 1 16541 48 16542 0 16543 0 16544 2 16545 52 16546 57 16547 0 16548 1 16549 49 16550 0 16551 0 16552 1 16553 48 16554 0 16555 0 16556 2 16557 53 16558 54 16559 0 16560 2 16561 53 16562 50 16563 0 16564 1 16565 50 16566 0 16567 0 16568 1 16569 48 16570 0 16571 0 16572 1 16573 48 16574 0 16575 0 16576 2 16577 52 16578 56 16579 0 16580 1 16581 49 16582 0 16583 0 16584 1 16585 48 16586 0 16587 0 16588 1 16589 48 16590 0 16591 0 16592 2 16593 52 16594 56
277/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
16595 0 16596 1 16597 49 16598 0 16599 0 16600 1 16601 48 16602 0 16603 0 16604 1 16605 48 16606 0 16607 0 16608 2 16609 52 16610 57 16611 0 16612 1 16613 49 16614 0 16615 0 16616 1 16617 48 16618 0 16619 0 16620 2 16621 53 16622 54 16623 0 16624 2 16625 53 16626 50 16627 0 16628 1 16629 50 16630 0 16631 0 16632 1 16633 48 16634 0 16635 0 16636 1 16637 48 16638 0 16639 0 16640 2 16641 52 16642 56 16643 0 16644 1 16645 49 16646 0 16647 0 16648 1 16649 48 16650 0 16651 0 16652 1 16653 48 16654 0
278/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
16655 0 16656 2 16657 52 16658 56 16659 0 16660 1 16661 49 16662 0 16663 0 16664 1 16665 48 16666 0 16667 0 16668 1 16669 48 16670 0 16671 0 16672 2 16673 52 16674 57 16675 0 16676 1 16677 49 16678 0 16679 0 16680 1 16681 48 16682 0 16683 0 16684 2 16685 53 16686 54 16687 0 16688 2 16689 53 16690 50 16691 0 16692 1 16693 50 16694 0 16695 0 16696 1 16697 48 16698 0 16699 0 16700 1 16701 48 16702 0 16703 0 16704 2 16705 52 16706 56 16707 0 16708 1 16709 49 16710 0 16711 0 16712 1 16713 48 16714 0
279/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
16715 0 16716 1 16717 48 16718 0 16719 0 16720 2 16721 52 16722 56 16723 0 16724 1 16725 49 16726 0 16727 0 16728 1 16729 48 16730 0 16731 0 16732 1 16733 48 16734 0 16735 0 16736 2 16737 52 16738 57 16739 0 16740 1 16741 49 16742 0 16743 0 16744 1 16745 48 16746 0 16747 0 16748 2 16749 53 16750 54 16751 0 16752 2 16753 53 16754 50 16755 0 16756 1 16757 50 16758 0 16759 0 16760 1 16761 48 16762 0 16763 0 16764 1 16765 48 16766 0 16767 0 16768 2 16769 52 16770 56 16771 0 16772 1 16773 49 16774 0
280/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
16775 0 16776 1 16777 48 16778 0 16779 0 16780 1 16781 48 16782 0 16783 0 16784 2 16785 52 16786 56 16787 0 16788 1 16789 49 16790 0 16791 0 16792 1 16793 48 16794 0 16795 0 16796 1 16797 48 16798 0 16799 0 16800 2 16801 52 16802 57 16803 0 16804 1 16805 49 16806 0 16807 0 16808 1 16809 48 16810 0 16811 0 16812 2 16813 53 16814 54 16815 0 16816 2 16817 53 16818 50 16819 0 16820 1 16821 50 16822 0 16823 0 16824 1 16825 48 16826 0 16827 0 16828 1 16829 48 16830 0 16831 0 16832 2 16833 52 16834 56
281/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
16835 0 16836 1 16837 49 16838 0 16839 0 16840 1 16841 48 16842 0 16843 0 16844 1 16845 48 16846 0 16847 0 16848 2 16849 52 16850 56 16851 0 16852 1 16853 49 16854 0 16855 0 16856 1 16857 48 16858 0 16859 0 16860 1 16861 48 16862 0 16863 0 16864 2 16865 52 16866 57 16867 0 16868 1 16869 49 16870 0 16871 0 16872 1 16873 48 16874 0 16875 0 16876 2 16877 53 16878 54 16879 0 16880 2 16881 53 16882 50 16883 0 16884 1 16885 50 16886 0 16887 0 16888 1 16889 48 16890 0 16891 0 16892 1 16893 48 16894 0
282/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
16895 0 16896 2 16897 52 16898 56 16899 0 16900 1 16901 49 16902 0 16903 0 16904 1 16905 48 16906 0 16907 0 16908 1 16909 48 16910 0 16911 0 16912 2 16913 52 16914 56 16915 0 16916 1 16917 49 16918 0 16919 0 16920 1 16921 48 16922 0 16923 0 16924 1 16925 48 16926 0 16927 0 16928 2 16929 52 16930 57 16931 0 16932 1 16933 49 16934 0 16935 0 16936 1 16937 48 16938 0 16939 0 16940 2 16941 53 16942 54 16943 0 16944 2 16945 53 16946 50 16947 0 16948 1 16949 50 16950 0 16951 0 16952 1 16953 48 16954 0
283/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
16955 0 16956 1 16957 48 16958 0 16959 0 16960 2 16961 52 16962 56 16963 0 16964 1 16965 49 16966 0 16967 0 16968 1 16969 48 16970 0 16971 0 16972 1 16973 48 16974 0 16975 0 16976 2 16977 52 16978 56 16979 0 16980 1 16981 49 16982 0 16983 0 16984 1 16985 48 16986 0 16987 0 16988 1 16989 48 16990 0 16991 0 16992 2 16993 52 16994 57 16995 0 16996 1 16997 49 16998 0 16999 0 17000 1 17001 48 17002 0 17003 0 17004 2 17005 53 17006 54 17007 0 17008 2 17009 53 17010 50 17011 0 17012 1 17013 50 17014 0
284/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
17015 0 17016 1 17017 48 17018 0 17019 0 17020 1 17021 48 17022 0 17023 0 17024 2 17025 52 17026 56 17027 0 17028 1 17029 49 17030 0 17031 0 17032 1 17033 48 17034 0 17035 0 17036 1 17037 48 17038 0 17039 0 17040 2 17041 52 17042 56 17043 0 17044 1 17045 49 17046 0 17047 0 17048 1 17049 48 17050 0 17051 0 17052 1 17053 48 17054 0 17055 0 17056 2 17057 52 17058 57 17059 0 17060 1 17061 49 17062 0 17063 0 17064 1 17065 48 17066 0 17067 0 17068 2 17069 53 17070 54 17071 0 17072 2 17073 53 17074 50
285/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
17075 0 17076 1 17077 50 17078 0 17079 0 17080 1 17081 48 17082 0 17083 0 17084 1 17085 48 17086 0 17087 0 17088 2 17089 52 17090 56 17091 0 17092 1 17093 49 17094 0 17095 0 17096 1 17097 48 17098 0 17099 0 17100 1 17101 48 17102 0 17103 0 17104 2 17105 52 17106 56 17107 0 17108 1 17109 49 17110 0 17111 0 17112 1 17113 48 17114 0 17115 0 17116 1 17117 48 17118 0 17119 0 17120 2 17121 52 17122 57 17123 0 17124 1 17125 49 17126 0 17127 0 17128 1 17129 48 17130 0 17131 0 17132 2 17133 53 17134 54
286/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
17135 0 17136 2 17137 53 17138 50 17139 0 17140 1 17141 50 17142 0 17143 0 17144 1 17145 48 17146 0 17147 0 17148 1 17149 48 17150 0 17151 0 17152 2 17153 52 17154 56 17155 0 17156 1 17157 49 17158 0 17159 0 17160 1 17161 48 17162 0 17163 0 17164 1 17165 48 17166 0 17167 0 17168 2 17169 52 17170 56 17171 0 17172 1 17173 49 17174 0 17175 0 17176 1 17177 48 17178 0 17179 0 17180 1 17181 48 17182 0 17183 0 17184 2 17185 52 17186 57 17187 0 17188 1 17189 49 17190 0 17191 0 17192 1 17193 48 17194 0
287/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
17195 0 17196 2 17197 53 17198 54 17199 0 17200 2 17201 53 17202 50 17203 0 17204 1 17205 50 17206 0 17207 0 17208 1 17209 48 17210 0 17211 0 17212 1 17213 48 17214 0 17215 0 17216 2 17217 52 17218 56 17219 0 17220 1 17221 49 17222 0 17223 0 17224 1 17225 48 17226 0 17227 0 17228 1 17229 48 17230 0 17231 0 17232 2 17233 52 17234 56 17235 0 17236 1 17237 49 17238 0 17239 0 17240 1 17241 48 17242 0 17243 0 17244 1 17245 48 17246 0 17247 0 17248 2 17249 52 17250 57 17251 0 17252 1 17253 49 17254 0
288/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
17255 0 17256 1 17257 48 17258 0 17259 0 17260 2 17261 53 17262 54 17263 0 17264 2 17265 53 17266 50 17267 0 17268 1 17269 50 17270 0 17271 0 17272 1 17273 48 17274 0 17275 0 17276 1 17277 48 17278 0 17279 0 17280 2 17281 52 17282 56 17283 0 17284 1 17285 49 17286 0 17287 0 17288 1 17289 48 17290 0 17291 0 17292 1 17293 48 17294 0 17295 0 17296 2 17297 52 17298 56 17299 0 17300 1 17301 49 17302 0 17303 0 17304 1 17305 48 17306 0 17307 0 17308 1 17309 48 17310 0 17311 0 17312 2 17313 52 17314 57
289/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
17315 0 17316 1 17317 49 17318 0 17319 0 17320 1 17321 48 17322 0 17323 0 17324 2 17325 53 17326 54 17327 0 17328 2 17329 53 17330 50 17331 0 17332 1 17333 50 17334 0 17335 0 17336 1 17337 48 17338 0 17339 0 17340 1 17341 48 17342 0 17343 0 17344 2 17345 52 17346 56 17347 0 17348 1 17349 49 17350 0 17351 0 17352 1 17353 48 17354 0 17355 0 17356 1 17357 48 17358 0 17359 0 17360 2 17361 52 17362 56 17363 0 17364 1 17365 49 17366 0 17367 0 17368 1 17369 48 17370 0 17371 0 17372 1 17373 48 17374 0
290/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
17375 0 17376 2 17377 52 17378 57 17379 0 17380 1 17381 49 17382 0 17383 0 17384 1 17385 48 17386 0 17387 0 17388 2 17389 53 17390 54 17391 0 17392 2 17393 53 17394 50 17395 0 17396 1 17397 50 17398 0 17399 0 17400 1 17401 48 17402 0 17403 0 17404 1 17405 48 17406 0 17407 0 17408 2 17409 52 17410 56 17411 0 17412 1 17413 49 17414 0 17415 0 17416 1 17417 48 17418 0 17419 0 17420 1 17421 48 17422 0 17423 0 17424 2 17425 52 17426 56 17427 0 17428 1 17429 49 17430 0 17431 0 17432 1 17433 48 17434 0
291/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
17435 0 17436 1 17437 48 17438 0 17439 0 17440 2 17441 52 17442 57 17443 0 17444 1 17445 49 17446 0 17447 0 17448 1 17449 48 17450 0 17451 0 17452 2 17453 53 17454 54 17455 0 17456 2 17457 53 17458 50 17459 0 17460 1 17461 50 17462 0 17463 0 17464 1 17465 48 17466 0 17467 0 17468 1 17469 48 17470 0 17471 0 17472 2 17473 52 17474 56 17475 0 17476 1 17477 49 17478 0 17479 0 17480 1 17481 48 17482 0 17483 0 17484 1 17485 48 17486 0 17487 0 17488 2 17489 52 17490 56 17491 0 17492 1 17493 49 17494 0
292/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
17495 0 17496 1 17497 48 17498 0 17499 0 17500 1 17501 48 17502 0 17503 0 17504 2 17505 52 17506 57 17507 0 17508 1 17509 49 17510 0 17511 0 17512 1 17513 48 17514 0 17515 0 17516 2 17517 53 17518 54 17519 0 17520 2 17521 53 17522 50 17523 0 17524 1 17525 50 17526 0 17527 0 17528 1 17529 48 17530 0 17531 0 17532 1 17533 48 17534 0 17535 0 17536 2 17537 52 17538 56 17539 0 17540 1 17541 49 17542 0 17543 0 17544 1 17545 48 17546 0 17547 0 17548 1 17549 48 17550 0 17551 0 17552 2 17553 52 17554 56
293/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
17555 0 17556 1 17557 49 17558 0 17559 0 17560 1 17561 48 17562 0 17563 0 17564 1 17565 48 17566 0 17567 0 17568 2 17569 53 17570 48 17571 0 17572 1 17573 49 17574 0 17575 0 17576 1 17577 48 17578 0 17579 0 17580 2 17581 53 17582 48 17583 0 17584 2 17585 53 17586 51 17587 0 17588 1 17589 50 17590 0 17591 0 17592 1 17593 48 17594 0 17595 0 17596 2 17597 53 17598 52 17599 0 17600 2 17601 53 17602 51 17603 0 17604 1 17605 50 17606 0 17607 0 17608 1 17609 48 17610 0 17611 0 17612 1 17613 48 17614 0
294/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
17615 0 17616 2 17617 52 17618 56 17619 0 17620 1 17621 49 17622 0 17623 0 17624 1 17625 48 17626 0 17627 0 17628 1 17629 48 17630 0 17631 0 17632 2 17633 52 17634 57 17635 0 17636 1 17637 49 17638 0 17639 0 17640 1 17641 48 17642 0 17643 0 17644 2 17645 53 17646 55 17647 0 17648 2 17649 53 17650 50 17651 0 17652 1 17653 50 17654 0 17655 0 17656 1 17657 48 17658 0 17659 0 17660 1 17661 48 17662 0 17663 0 17664 2 17665 52 17666 56 17667 0 17668 1 17669 49 17670 0 17671 0 17672 1 17673 48 17674 0
295/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
17675 0 17676 1 17677 48 17678 0 17679 0 17680 2 17681 52 17682 56 17683 0 17684 1 17685 49 17686 0 17687 0 17688 1 17689 48 17690 0 17691 0 17692 1 17693 48 17694 0 17695 0 17696 2 17697 52 17698 57 17699 0 17700 1 17701 49 17702 0 17703 0 17704 1 17705 48 17706 0 17707 0 17708 2 17709 53 17710 54 17711 0 17712 2 17713 53 17714 50 17715 0 17716 1 17717 50 17718 0 17719 0 17720 1 17721 48 17722 0 17723 0 17724 1 17725 48 17726 0 17727 0 17728 2 17729 52 17730 56 17731 0 17732 1 17733 49 17734 0
296/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
17735 0 17736 1 17737 48 17738 0 17739 0 17740 1 17741 48 17742 0 17743 0 17744 2 17745 52 17746 56 17747 0 17748 1 17749 49 17750 0 17751 0 17752 1 17753 48 17754 0 17755 0 17756 1 17757 48 17758 0 17759 0 17760 2 17761 52 17762 57 17763 0 17764 1 17765 49 17766 0 17767 0 17768 1 17769 48 17770 0 17771 0 17772 2 17773 53 17774 54 17775 0 17776 2 17777 53 17778 50 17779 0 17780 1 17781 50 17782 0 17783 0 17784 1 17785 48 17786 0 17787 0 17788 1 17789 48 17790 0 17791 0 17792 2 17793 52 17794 56
297/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
17795 0 17796 1 17797 49 17798 0 17799 0 17800 1 17801 48 17802 0 17803 0 17804 1 17805 48 17806 0 17807 0 17808 2 17809 52 17810 56 17811 0 17812 1 17813 49 17814 0 17815 0 17816 1 17817 48 17818 0 17819 0 17820 1 17821 48 17822 0 17823 0 17824 2 17825 52 17826 57 17827 0 17828 1 17829 49 17830 0 17831 0 17832 1 17833 48 17834 0 17835 0 17836 2 17837 53 17838 54 17839 0 17840 2 17841 53 17842 50 17843 0 17844 1 17845 50 17846 0 17847 0 17848 1 17849 48 17850 0 17851 0 17852 1 17853 48 17854 0
298/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
17855 0 17856 2 17857 52 17858 56 17859 0 17860 1 17861 49 17862 0 17863 0 17864 1 17865 48 17866 0 17867 0 17868 1 17869 48 17870 0 17871 0 17872 2 17873 52 17874 56 17875 0 17876 1 17877 49 17878 0 17879 0 17880 1 17881 48 17882 0 17883 0 17884 1 17885 48 17886 0 17887 0 17888 2 17889 52 17890 57 17891 0 17892 1 17893 49 17894 0 17895 0 17896 1 17897 48 17898 0 17899 0 17900 2 17901 53 17902 54 17903 0 17904 2 17905 53 17906 50 17907 0 17908 1 17909 50 17910 0 17911 0 17912 1 17913 48 17914 0
299/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
17915 0 17916 1 17917 48 17918 0 17919 0 17920 2 17921 52 17922 56 17923 0 17924 1 17925 49 17926 0 17927 0 17928 1 17929 48 17930 0 17931 0 17932 1 17933 48 17934 0 17935 0 17936 2 17937 52 17938 56 17939 0 17940 1 17941 49 17942 0 17943 0 17944 1 17945 48 17946 0 17947 0 17948 1 17949 48 17950 0 17951 0 17952 2 17953 52 17954 57 17955 0 17956 1 17957 49 17958 0 17959 0 17960 1 17961 48 17962 0 17963 0 17964 2 17965 53 17966 54 17967 0 17968 2 17969 53 17970 50 17971 0 17972 1 17973 50 17974 0
300/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
17975 0 17976 1 17977 48 17978 0 17979 0 17980 1 17981 48 17982 0 17983 0 17984 2 17985 52 17986 56 17987 0 17988 1 17989 49 17990 0 17991 0 17992 1 17993 48 17994 0 17995 0 17996 1 17997 48 17998 0 17999 0 18000 2 18001 52 18002 56 18003 0 18004 1 18005 49 18006 0 18007 0 18008 1 18009 48 18010 0 18011 0 18012 1 18013 48 18014 0 18015 0 18016 2 18017 52 18018 57 18019 0 18020 1 18021 49 18022 0 18023 0 18024 1 18025 48 18026 0 18027 0 18028 2 18029 53 18030 54 18031 0 18032 2 18033 53 18034 50
301/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
18035 0 18036 1 18037 50 18038 0 18039 0 18040 1 18041 48 18042 0 18043 0 18044 1 18045 48 18046 0 18047 0 18048 2 18049 52 18050 56 18051 0 18052 1 18053 49 18054 0 18055 0 18056 1 18057 48 18058 0 18059 0 18060 1 18061 48 18062 0 18063 0 18064 2 18065 52 18066 56 18067 0 18068 1 18069 49 18070 0 18071 0 18072 1 18073 48 18074 0 18075 0 18076 1 18077 48 18078 0 18079 0 18080 2 18081 53 18082 48 18083 0 18084 1 18085 49 18086 0 18087 0 18088 1 18089 48 18090 0 18091 0 18092 2 18093 53 18094 48
302/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
18095 0 18096 2 18097 53 18098 51 18099 0 18100 1 18101 50 18102 0 18103 0 18104 1 18105 48 18106 0 18107 0 18108 2 18109 53 18110 52 18111 0 18112 2 18113 53 18114 51 18115 0 18116 1 18117 50 18118 0 18119 0 18120 1 18121 48 18122 0 18123 0 18124 1 18125 48 18126 0 18127 0 18128 2 18129 52 18130 56 18131 0 18132 1 18133 49 18134 0 18135 0 18136 1 18137 48 18138 0 18139 0 18140 1 18141 48 18142 0 18143 0 18144 2 18145 52 18146 57 18147 0 18148 1 18149 49 18150 0 18151 0 18152 1 18153 48 18154 0
303/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
18155 0
18156 2
18157 53 18158 55 18159 0
18160 2
18161 53 18162 50 18163 0
18164 1
18165 50 18166 0
18167 0
18168 1
18169 48 18170 0
18171 0
18172 1
18173 48 18174 0
18175 0
18176 2
18177 0
18178 0
18179 0
18180 21948352 18181 0
18182 0
18183 0
18184 21948384 18185 0
18186 0
18187 0
18188 21948416 18189 0
18190 0
18191 0
18192 21948448 18193 0
18194 0
18195 0
18196 21948480 18197 0
18198 0
18199 0
18200 21948512 18201 0
18202 0
18203 0
18204 21948544 18205 0
18206 0
18207 0
18208 21948576 18209 0
18210 0
18211 0
18212 21948608 18213 0
18214 0
304/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
18215 0
18216 21948640 18217 0
18218 0
18219 0
18220 21948672 18221 0
18222 0
18223 0
18224 21948704 18225 0
18226 0
18227 0
18228 21948736 18229 0
18230 0
18231 0
18232 21948768 18233 0
18234 0
18235 0
18236 21948800 18237 0
18238 0
18239 0
18240 21948832 18241 0
18242 0
18243 0
18244 1
18245 48 18246 0
18247 0
18248 1
18249 48 18250 0
18251 0
18252 1
18253 48 18254 0
18255 0
18256 1
18257 48 18258 0
18259 0
18260 1
18261 48 18262 0
18263 0
18264 1
18265 48 18266 0
18267 0
18268 1
18269 48 18270 0
18271 0
18272 1
18273 48 18274 0
305/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
18275 0 18276 1 18277 48 18278 0 18279 0 18280 1 18281 48 18282 0 18283 0 18284 1 18285 48 18286 0 18287 0 18288 1 18289 48 18290 0 18291 0 18292 1 18293 48 18294 0 18295 0 18296 1 18297 48 18298 0 18299 0 18300 1 18301 48 18302 0 18303 0 18304 1 18305 48 18306 0 18307 0 18308 1 18309 48 18310 0 18311 0 18312 1 18313 48 18314 0 18315 0 18316 1 18317 48 18318 0 18319 0 18320 1 18321 48 18322 0 18323 0 18324 1 18325 48 18326 0 18327 0 18328 1 18329 48 18330 0 18331 0 18332 1 18333 48 18334 0
306/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
18335 0 18336 1 18337 48 18338 0 18339 0 18340 1 18341 48 18342 0 18343 0 18344 1 18345 48 18346 0 18347 0 18348 1 18349 48 18350 0 18351 0 18352 1 18353 48 18354 0 18355 0 18356 1 18357 48 18358 0 18359 0 18360 1 18361 48 18362 0 18363 0 18364 1 18365 48 18366 0 18367 0 18368 1 18369 48 18370 0 18371 0 18372 1 18373 48 18374 0 18375 0 18376 1 18377 48 18378 0 18379 0 18380 1 18381 48 18382 0 18383 0 18384 1 18385 48 18386 0 18387 0 18388 1 18389 48 18390 0 18391 0 18392 1 18393 48 18394 0
307/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
18395 0
18396 1
18397 48 18398 0
18399 0
18400 1
18401 48 18402 0
18403 0
18404 1
18405 48 18406 0
18407 0
18408 1
18409 48 18410 0
18411 0
18412 1
18413 48 18414 0
18415 0
18416 1
18417 48 18418 0
18419 0
18420 1
18421 48 18422 0
18423 0
18424 1
18425 48 18426 0
18427 0
18428 1
18429 48 18430 0
18431 0
18432 1
18433 48 18434 0
18435 0
18436 1
18437 50 18438 0
18439 0
18440 0
18441 0
18442 0
18443 0
18444 21950464 18445 0
18446 0 18447 0 18448 1 18449 48 18450 0 18451 0 18452 1 18453 48 18454 0
308/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
18455 0 18456 1 18457 48 18458 0 18459 0 18460 1 18461 48 18462 0 18463 0 18464 1 18465 48 18466 0 18467 0 18468 1 18469 48 18470 0 18471 0 18472 1 18473 48 18474 0 18475 0 18476 1 18477 48 18478 0 18479 0 18480 2 18481 53 18482 48 18483 0 18484 1 18485 49 18486 0 18487 0 18488 1 18489 48 18490 0 18491 0 18492 1 18493 48 18494 0 18495 0 18496 2 18497 52 18498 56 18499 0 18500 1 18501 49 18502 0 18503 0 18504 1 18505 48 18506 0 18507 0 18508 1 18509 48 18510 0 18511 0 18512 2 18513 52 18514 56
309/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
18515 0 18516 1 18517 49 18518 0 18519 0 18520 1 18521 48 18522 0 18523 0 18524 1 18525 48 18526 0 18527 0 18528 2 18529 52 18530 56 18531 0 18532 1 18533 49 18534 0 18535 0 18536 1 18537 48 18538 0 18539 0 18540 1 18541 48 18542 0 18543 0 18544 2 18545 52 18546 56 18547 0 18548 1 18549 49 18550 0 18551 0 18552 1 18553 48 18554 0 18555 0 18556 1 18557 48 18558 0 18559 0 18560 2 18561 52 18562 56 18563 0 18564 1 18565 49 18566 0 18567 0 18568 1 18569 48 18570 0 18571 0 18572 1 18573 48 18574 0
310/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
18575 0 18576 2 18577 52 18578 56 18579 0 18580 1 18581 49 18582 0 18583 0 18584 1 18585 48 18586 0 18587 0 18588 1 18589 48 18590 0 18591 0 18592 2 18593 52 18594 56 18595 0 18596 1 18597 49 18598 0 18599 0 18600 1 18601 48 18602 0 18603 0 18604 1 18605 48 18606 0 18607 0 18608 2 18609 52 18610 56 18611 0 18612 1 18613 49 18614 0 18615 0 18616 1 18617 48 18618 0 18619 0 18620 1 18621 48 18622 0 18623 0 18624 2 18625 52 18626 56 18627 0 18628 1 18629 49 18630 0 18631 0 18632 1 18633 48 18634 0
311/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
18635 0 18636 1 18637 48 18638 0 18639 0 18640 2 18641 52 18642 56 18643 0 18644 1 18645 49 18646 0 18647 0 18648 1 18649 48 18650 0 18651 0 18652 1 18653 48 18654 0 18655 0 18656 2 18657 52 18658 56 18659 0 18660 1 18661 49 18662 0 18663 0 18664 1 18665 48 18666 0 18667 0 18668 1 18669 48 18670 0 18671 0 18672 2 18673 52 18674 56 18675 0 18676 1 18677 49 18678 0 18679 0 18680 1 18681 48 18682 0 18683 0 18684 1 18685 48 18686 0 18687 0 18688 2 18689 52 18690 56 18691 0 18692 1 18693 49 18694 0
312/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
18695 0 18696 1 18697 48 18698 0 18699 0 18700 1 18701 48 18702 0 18703 0 18704 2 18705 52 18706 56 18707 0 18708 1 18709 49 18710 0 18711 0 18712 1 18713 48 18714 0 18715 0 18716 1 18717 48 18718 0 18719 0 18720 2 18721 52 18722 56 18723 0 18724 1 18725 49 18726 0 18727 0 18728 1 18729 48 18730 0 18731 0 18732 1 18733 48 18734 0 18735 0 18736 2 18737 52 18738 56 18739 0 18740 1 18741 49 18742 0 18743 0 18744 1 18745 48 18746 0 18747 0 18748 1 18749 48 18750 0 18751 0 18752 2 18753 52 18754 56
313/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
18755 0 18756 1 18757 49 18758 0 18759 0 18760 1 18761 48 18762 0 18763 0 18764 1 18765 48 18766 0 18767 0 18768 2 18769 52 18770 56 18771 0 18772 1 18773 49 18774 0 18775 0 18776 1 18777 48 18778 0 18779 0 18780 1 18781 48 18782 0 18783 0 18784 2 18785 52 18786 56 18787 0 18788 1 18789 49 18790 0 18791 0 18792 1 18793 48 18794 0 18795 0 18796 1 18797 48 18798 0 18799 0 18800 2 18801 52 18802 56 18803 0 18804 1 18805 49 18806 0 18807 0 18808 1 18809 48 18810 0 18811 0 18812 1 18813 48 18814 0
314/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
18815 0 18816 2 18817 52 18818 56 18819 0 18820 1 18821 49 18822 0 18823 0 18824 1 18825 48 18826 0 18827 0 18828 1 18829 48 18830 0 18831 0 18832 2 18833 52 18834 56 18835 0 18836 1 18837 49 18838 0 18839 0 18840 1 18841 48 18842 0 18843 0 18844 1 18845 48 18846 0 18847 0 18848 2 18849 52 18850 56 18851 0 18852 1 18853 49 18854 0 18855 0 18856 1 18857 48 18858 0 18859 0 18860 1 18861 48 18862 0 18863 0 18864 2 18865 52 18866 56 18867 0 18868 1 18869 49 18870 0 18871 0 18872 1 18873 48 18874 0
315/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
18875 0 18876 1 18877 48 18878 0 18879 0 18880 2 18881 52 18882 56 18883 0 18884 1 18885 49 18886 0 18887 0 18888 1 18889 48 18890 0 18891 0 18892 1 18893 48 18894 0 18895 0 18896 2 18897 52 18898 56 18899 0 18900 1 18901 49 18902 0 18903 0 18904 1 18905 48 18906 0 18907 0 18908 1 18909 48 18910 0 18911 0 18912 2 18913 52 18914 56 18915 0 18916 1 18917 49 18918 0 18919 0 18920 1 18921 48 18922 0 18923 0 18924 1 18925 48 18926 0 18927 0 18928 2 18929 52 18930 56 18931 0 18932 1 18933 49 18934 0
316/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
18935 0 18936 1 18937 48 18938 0 18939 0 18940 1 18941 48 18942 0 18943 0 18944 2 18945 52 18946 56 18947 0 18948 1 18949 49 18950 0 18951 0 18952 1 18953 50 18954 0 18955 0 18956 1 18957 48 18958 0 18959 0 18960 1 18961 48 18962 0 18963 0 18964 2 18965 52 18966 56 18967 0 18968 1 18969 49 18970 0 18971 0 18972 1 18973 48 18974 0 18975 0 18976 1 18977 48 18978 0 18979 0 18980 2 18981 52 18982 56 18983 0 18984 1 18985 49 18986 0 18987 0 18988 1 18989 48 18990 0 18991 0 18992 1 18993 48 18994 0
317/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
18995 0 18996 2 18997 52 18998 57 18999 0 19000 1 19001 49 19002 0 19003 0 19004 1 19005 48 19006 0 19007 0 19008 2 19009 53 19010 54 19011 0 19012 2 19013 53 19014 50 19015 0 19016 1 19017 50 19018 0 19019 0 19020 1 19021 48 19022 0 19023 0 19024 1 19025 48 19026 0 19027 0 19028 2 19029 52 19030 56 19031 0 19032 1 19033 49 19034 0 19035 0 19036 1 19037 48 19038 0 19039 0 19040 1 19041 48 19042 0 19043 0 19044 2 19045 52 19046 56 19047 0 19048 1 19049 49 19050 0 19051 0 19052 1 19053 48 19054 0
318/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
19055 0 19056 1 19057 48 19058 0 19059 0 19060 2 19061 52 19062 57 19063 0 19064 1 19065 49 19066 0 19067 0 19068 1 19069 48 19070 0 19071 0 19072 2 19073 53 19074 54 19075 0 19076 2 19077 53 19078 50 19079 0 19080 1 19081 50 19082 0 19083 0 19084 1 19085 48 19086 0 19087 0 19088 1 19089 48 19090 0 19091 0 19092 2 19093 52 19094 56 19095 0 19096 1 19097 49 19098 0 19099 0 19100 1 19101 48 19102 0 19103 0 19104 1 19105 48 19106 0 19107 0 19108 2 19109 52 19110 56 19111 0 19112 1 19113 49 19114 0
319/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
19115 0 19116 1 19117 48 19118 0 19119 0 19120 1 19121 48 19122 0 19123 0 19124 2 19125 52 19126 57 19127 0 19128 1 19129 49 19130 0 19131 0 19132 1 19133 48 19134 0 19135 0 19136 2 19137 53 19138 54 19139 0 19140 2 19141 53 19142 50 19143 0 19144 1 19145 50 19146 0 19147 0 19148 1 19149 48 19150 0 19151 0 19152 1 19153 48 19154 0 19155 0 19156 2 19157 52 19158 56 19159 0 19160 1 19161 49 19162 0 19163 0 19164 1 19165 48 19166 0 19167 0 19168 1 19169 48 19170 0 19171 0 19172 2 19173 52 19174 56
320/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
19175 0 19176 1 19177 49 19178 0 19179 0 19180 1 19181 48 19182 0 19183 0 19184 1 19185 48 19186 0 19187 0 19188 2 19189 52 19190 57 19191 0 19192 1 19193 49 19194 0 19195 0 19196 1 19197 48 19198 0 19199 0 19200 2 19201 53 19202 54 19203 0 19204 2 19205 53 19206 50 19207 0 19208 1 19209 50 19210 0 19211 0 19212 1 19213 48 19214 0 19215 0 19216 1 19217 48 19218 0 19219 0 19220 2 19221 52 19222 56 19223 0 19224 1 19225 49 19226 0 19227 0 19228 1 19229 48 19230 0 19231 0 19232 1 19233 48 19234 0
321/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
19235 0 19236 2 19237 52 19238 56 19239 0 19240 1 19241 49 19242 0 19243 0 19244 1 19245 48 19246 0 19247 0 19248 1 19249 48 19250 0 19251 0 19252 2 19253 52 19254 57 19255 0 19256 1 19257 49 19258 0 19259 0 19260 1 19261 48 19262 0 19263 0 19264 2 19265 53 19266 54 19267 0 19268 2 19269 53 19270 50 19271 0 19272 1 19273 50 19274 0 19275 0 19276 1 19277 48 19278 0 19279 0 19280 1 19281 48 19282 0 19283 0 19284 2 19285 52 19286 56 19287 0 19288 1 19289 49 19290 0 19291 0 19292 1 19293 48 19294 0
322/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
19295 0 19296 1 19297 48 19298 0 19299 0 19300 2 19301 52 19302 56 19303 0 19304 1 19305 49 19306 0 19307 0 19308 1 19309 48 19310 0 19311 0 19312 1 19313 48 19314 0 19315 0 19316 2 19317 52 19318 57 19319 0 19320 1 19321 49 19322 0 19323 0 19324 1 19325 48 19326 0 19327 0 19328 2 19329 52 19330 56 19331 0 19332 2 19333 53 19334 51 19335 0 19336 1 19337 50 19338 0 19339 0 19340 1 19341 48 19342 0 19343 0 19344 1 19345 48 19346 0 19347 0 19348 2 19349 52 19350 56 19351 0 19352 1 19353 49 19354 0
323/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
19355 0 19356 1 19357 48 19358 0 19359 0 19360 1 19361 48 19362 0 19363 0 19364 2 19365 52 19366 56 19367 0 19368 1 19369 49 19370 0 19371 0 19372 1 19373 48 19374 0 19375 0 19376 1 19377 48 19378 0 19379 0 19380 2 19381 52 19382 56 19383 0 19384 1 19385 49 19386 0 19387 0 19388 1 19389 48 19390 0 19391 0 19392 1 19393 48 19394 0 19395 0 19396 2 19397 52 19398 56 19399 0 19400 1 19401 49 19402 0 19403 0 19404 1 19405 48 19406 0 19407 0 19408 1 19409 48 19410 0 19411 0 19412 2 19413 52 19414 56
324/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
19415 0 19416 1 19417 49 19418 0 19419 0 19420 1 19421 48 19422 0 19423 0 19424 1 19425 48 19426 0 19427 0 19428 2 19429 52 19430 56 19431 0 19432 1 19433 49 19434 0 19435 0 19436 1 19437 48 19438 0 19439 0 19440 1 19441 48 19442 0 19443 0 19444 2 19445 52 19446 56 19447 0 19448 1 19449 49 19450 0 19451 0 19452 1 19453 48 19454 0 19455 0 19456 1 19457 48 19458 0 19459 0 19460 2 19461 52 19462 56 19463 0 19464 1 19465 50 19466 0 19467 0 19468 1 19469 48 19470 0 19471 0 19472 1 19473 48 19474 0
325/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
19475 0 19476 2 19477 52 19478 56 19479 0 19480 1 19481 49 19482 0 19483 0 19484 1 19485 48 19486 0 19487 0 19488 1 19489 48 19490 0 19491 0 19492 2 19493 52 19494 56 19495 0 19496 1 19497 49 19498 0 19499 0 19500 1 19501 48 19502 0 19503 0 19504 1 19505 48 19506 0 19507 0 19508 2 19509 52 19510 57 19511 0 19512 1 19513 49 19514 0 19515 0 19516 1 19517 48 19518 0 19519 0 19520 2 19521 53 19522 54 19523 0 19524 2 19525 53 19526 50 19527 0 19528 1 19529 50 19530 0 19531 0 19532 1 19533 48 19534 0
326/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
19535 0 19536 1 19537 48 19538 0 19539 0 19540 2 19541 52 19542 56 19543 0 19544 1 19545 49 19546 0 19547 0 19548 1 19549 48 19550 0 19551 0 19552 1 19553 48 19554 0 19555 0 19556 2 19557 52 19558 56 19559 0 19560 1 19561 49 19562 0 19563 0 19564 1 19565 48 19566 0 19567 0 19568 1 19569 48 19570 0 19571 0 19572 2 19573 52 19574 57 19575 0 19576 1 19577 49 19578 0 19579 0 19580 1 19581 48 19582 0 19583 0 19584 2 19585 53 19586 54 19587 0 19588 2 19589 53 19590 50 19591 0 19592 1 19593 50 19594 0
327/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
19595 0 19596 1 19597 48 19598 0 19599 0 19600 1 19601 48 19602 0 19603 0 19604 2 19605 52 19606 56 19607 0 19608 1 19609 49 19610 0 19611 0 19612 1 19613 48 19614 0 19615 0 19616 1 19617 48 19618 0 19619 0 19620 2 19621 52 19622 56 19623 0 19624 1 19625 49 19626 0 19627 0 19628 1 19629 48 19630 0 19631 0 19632 1 19633 48 19634 0 19635 0 19636 2 19637 52 19638 57 19639 0 19640 1 19641 49 19642 0 19643 0 19644 1 19645 48 19646 0 19647 0 19648 2 19649 53 19650 54 19651 0 19652 2 19653 53 19654 50
328/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
19655 0 19656 1 19657 50 19658 0 19659 0 19660 1 19661 48 19662 0 19663 0 19664 1 19665 48 19666 0 19667 0 19668 2 19669 52 19670 56 19671 0 19672 1 19673 49 19674 0 19675 0 19676 1 19677 48 19678 0 19679 0 19680 1 19681 48 19682 0 19683 0 19684 2 19685 52 19686 56 19687 0 19688 1 19689 49 19690 0 19691 0 19692 1 19693 48 19694 0 19695 0 19696 1 19697 48 19698 0 19699 0 19700 2 19701 52 19702 57 19703 0 19704 1 19705 49 19706 0 19707 0 19708 1 19709 48 19710 0 19711 0 19712 2 19713 53 19714 54
329/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
19715 0 19716 2 19717 53 19718 50 19719 0 19720 1 19721 50 19722 0 19723 0 19724 1 19725 48 19726 0 19727 0 19728 1 19729 48 19730 0 19731 0 19732 2 19733 52 19734 56 19735 0 19736 1 19737 49 19738 0 19739 0 19740 1 19741 48 19742 0 19743 0 19744 1 19745 48 19746 0 19747 0 19748 2 19749 52 19750 56 19751 0 19752 1 19753 49 19754 0 19755 0 19756 1 19757 48 19758 0 19759 0 19760 1 19761 48 19762 0 19763 0 19764 2 19765 52 19766 57 19767 0 19768 1 19769 49 19770 0 19771 0 19772 1 19773 48 19774 0
330/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
19775 0 19776 2 19777 53 19778 54 19779 0 19780 2 19781 53 19782 50 19783 0 19784 1 19785 50 19786 0 19787 0 19788 1 19789 48 19790 0 19791 0 19792 1 19793 48 19794 0 19795 0 19796 2 19797 52 19798 56 19799 0 19800 1 19801 49 19802 0 19803 0 19804 1 19805 48 19806 0 19807 0 19808 1 19809 48 19810 0 19811 0 19812 2 19813 52 19814 56 19815 0 19816 1 19817 49 19818 0 19819 0 19820 1 19821 48 19822 0 19823 0 19824 1 19825 48 19826 0 19827 0 19828 2 19829 52 19830 57 19831 0 19832 1 19833 49 19834 0
331/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
19835 0 19836 1 19837 48 19838 0 19839 0 19840 2 19841 53 19842 54 19843 0 19844 2 19845 53 19846 50 19847 0 19848 1 19849 50 19850 0 19851 0 19852 1 19853 48 19854 0 19855 0 19856 1 19857 48 19858 0 19859 0 19860 2 19861 52 19862 56 19863 0 19864 1 19865 49 19866 0 19867 0 19868 1 19869 48 19870 0 19871 0 19872 1 19873 48 19874 0 19875 0 19876 2 19877 52 19878 56 19879 0 19880 1 19881 49 19882 0 19883 0 19884 1 19885 48 19886 0 19887 0 19888 1 19889 48 19890 0 19891 0 19892 2 19893 52 19894 57
332/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
19895 0 19896 1 19897 49 19898 0 19899 0 19900 1 19901 48 19902 0 19903 0 19904 2 19905 53 19906 54 19907 0 19908 2 19909 53 19910 50 19911 0 19912 1 19913 50 19914 0 19915 0 19916 1 19917 48 19918 0 19919 0 19920 1 19921 48 19922 0 19923 0 19924 2 19925 52 19926 56 19927 0 19928 1 19929 49 19930 0 19931 0 19932 1 19933 48 19934 0 19935 0 19936 1 19937 48 19938 0 19939 0 19940 2 19941 52 19942 56 19943 0 19944 1 19945 49 19946 0 19947 0 19948 1 19949 48 19950 0 19951 0 19952 1 19953 48 19954 0
333/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
19955 0 19956 2 19957 52 19958 57 19959 0 19960 1 19961 49 19962 0 19963 0 19964 1 19965 48 19966 0 19967 0 19968 2 19969 53 19970 54 19971 0 19972 2 19973 53 19974 50 19975 0 19976 1 19977 50 19978 0 19979 0 19980 1 19981 48 19982 0 19983 0 19984 1 19985 48 19986 0 19987 0 19988 2 19989 52 19990 56 19991 0 19992 1 19993 49 19994 0 19995 0 19996 1 19997 48 19998 0 19999 0 20000 1 20001 48 20002 0 20003 0 20004 2 20005 52 20006 56 20007 0 20008 1 20009 49 20010 0 20011 0 20012 1 20013 48 20014 0
334/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
20015 0 20016 1 20017 48 20018 0 20019 0 20020 2 20021 52 20022 57 20023 0 20024 1 20025 49 20026 0 20027 0 20028 1 20029 48 20030 0 20031 0 20032 2 20033 53 20034 54 20035 0 20036 2 20037 53 20038 50 20039 0 20040 1 20041 50 20042 0 20043 0 20044 1 20045 48 20046 0 20047 0 20048 1 20049 48 20050 0 20051 0 20052 2 20053 52 20054 56 20055 0 20056 1 20057 49 20058 0 20059 0 20060 1 20061 48 20062 0 20063 0 20064 1 20065 48 20066 0 20067 0 20068 2 20069 52 20070 56 20071 0 20072 1 20073 49 20074 0
335/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
20075 0 20076 1 20077 48 20078 0 20079 0 20080 1 20081 48 20082 0 20083 0 20084 2 20085 52 20086 57 20087 0 20088 1 20089 49 20090 0 20091 0 20092 1 20093 48 20094 0 20095 0 20096 2 20097 53 20098 54 20099 0 20100 2 20101 53 20102 50 20103 0 20104 1 20105 50 20106 0 20107 0 20108 1 20109 48 20110 0 20111 0 20112 1 20113 48 20114 0 20115 0 20116 2 20117 52 20118 56 20119 0 20120 1 20121 49 20122 0 20123 0 20124 1 20125 48 20126 0 20127 0 20128 1 20129 48 20130 0 20131 0 20132 2 20133 52 20134 56
336/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
20135 0 20136 1 20137 49 20138 0 20139 0 20140 1 20141 48 20142 0 20143 0 20144 1 20145 48 20146 0 20147 0 20148 2 20149 52 20150 57 20151 0 20152 1 20153 49 20154 0 20155 0 20156 1 20157 48 20158 0 20159 0 20160 2 20161 53 20162 54 20163 0 20164 2 20165 53 20166 50 20167 0 20168 1 20169 50 20170 0 20171 0 20172 1 20173 48 20174 0 20175 0 20176 1 20177 48 20178 0 20179 0 20180 2 20181 52 20182 56 20183 0 20184 1 20185 49 20186 0 20187 0 20188 1 20189 48 20190 0 20191 0 20192 1 20193 48 20194 0
337/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
20195 0 20196 2 20197 52 20198 56 20199 0 20200 1 20201 49 20202 0 20203 0 20204 1 20205 48 20206 0 20207 0 20208 1 20209 48 20210 0 20211 0 20212 2 20213 52 20214 57 20215 0 20216 1 20217 49 20218 0 20219 0 20220 1 20221 48 20222 0 20223 0 20224 2 20225 53 20226 54 20227 0 20228 2 20229 53 20230 50 20231 0 20232 1 20233 50 20234 0 20235 0 20236 1 20237 48 20238 0 20239 0 20240 1 20241 48 20242 0 20243 0 20244 2 20245 52 20246 56 20247 0 20248 1 20249 49 20250 0 20251 0 20252 1 20253 48 20254 0
338/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
20255 0 20256 1 20257 48 20258 0 20259 0 20260 2 20261 52 20262 56 20263 0 20264 1 20265 49 20266 0 20267 0 20268 1 20269 48 20270 0 20271 0 20272 1 20273 48 20274 0 20275 0 20276 2 20277 52 20278 57 20279 0 20280 1 20281 49 20282 0 20283 0 20284 1 20285 48 20286 0 20287 0 20288 2 20289 53 20290 54 20291 0 20292 2 20293 53 20294 50 20295 0 20296 1 20297 50 20298 0 20299 0 20300 1 20301 48 20302 0 20303 0 20304 1 20305 48 20306 0 20307 0 20308 2 20309 52 20310 56 20311 0 20312 1 20313 49 20314 0
339/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
20315 0 20316 1 20317 48 20318 0 20319 0 20320 1 20321 48 20322 0 20323 0 20324 2 20325 52 20326 56 20327 0 20328 1 20329 49 20330 0 20331 0 20332 1 20333 48 20334 0 20335 0 20336 1 20337 48 20338 0 20339 0 20340 2 20341 52 20342 57 20343 0 20344 1 20345 49 20346 0 20347 0 20348 1 20349 48 20350 0 20351 0 20352 2 20353 53 20354 54 20355 0 20356 2 20357 53 20358 50 20359 0 20360 1 20361 50 20362 0 20363 0 20364 1 20365 48 20366 0 20367 0 20368 1 20369 48 20370 0 20371 0 20372 2 20373 52 20374 56
340/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
20375 0 20376 1 20377 49 20378 0 20379 0 20380 1 20381 48 20382 0 20383 0 20384 1 20385 48 20386 0 20387 0 20388 2 20389 52 20390 56 20391 0 20392 1 20393 49 20394 0 20395 0 20396 1 20397 48 20398 0 20399 0 20400 1 20401 48 20402 0 20403 0 20404 2 20405 52 20406 57 20407 0 20408 1 20409 49 20410 0 20411 0 20412 1 20413 48 20414 0 20415 0 20416 2 20417 53 20418 54 20419 0 20420 2 20421 53 20422 50 20423 0 20424 1 20425 50 20426 0 20427 0 20428 1 20429 48 20430 0 20431 0 20432 1 20433 48 20434 0
341/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
20435 0 20436 2 20437 52 20438 56 20439 0 20440 1 20441 49 20442 0 20443 0 20444 1 20445 48 20446 0 20447 0 20448 1 20449 48 20450 0 20451 0 20452 2 20453 52 20454 56 20455 0 20456 1 20457 49 20458 0 20459 0 20460 1 20461 48 20462 0 20463 0 20464 1 20465 48 20466 0 20467 0 20468 2 20469 52 20470 57 20471 0 20472 1 20473 49 20474 0 20475 0 20476 1 20477 48 20478 0 20479 0 20480 2 20481 53 20482 54 20483 0 20484 2 20485 53 20486 50 20487 0 20488 1 20489 49 20490 0 20491 0 20492 1 20493 48 20494 0
342/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
20495 0 20496 1 20497 48 20498 0 20499 0 20500 2 20501 52 20502 56 20503 0 20504 1 20505 49 20506 0 20507 0 20508 1 20509 48 20510 0 20511 0 20512 1 20513 48 20514 0 20515 0 20516 2 20517 53 20518 48 20519 0 20520 1 20521 49 20522 0 20523 0 20524 1 20525 48 20526 0 20527 0 20528 1 20529 48 20530 0 20531 0 20532 2 20533 52 20534 57 20535 0 20536 1 20537 49 20538 0 20539 0 20540 1 20541 48 20542 0 20543 0 20544 2 20545 53 20546 54 20547 0 20548 2 20549 53 20550 50 20551 0 20552 1 20553 50 20554 0
343/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
20555 0 20556 1 20557 48 20558 0 20559 0 20560 1 20561 48 20562 0 20563 0 20564 2 20565 52 20566 56 20567 0 20568 1 20569 49 20570 0 20571 0 20572 1 20573 48 20574 0 20575 0 20576 1 20577 48 20578 0 20579 0 20580 2 20581 52 20582 56 20583 0 20584 1 20585 49 20586 0 20587 0 20588 1 20589 48 20590 0 20591 0 20592 1 20593 48 20594 0 20595 0 20596 2 20597 52 20598 57 20599 0 20600 1 20601 49 20602 0 20603 0 20604 1 20605 48 20606 0 20607 0 20608 2 20609 53 20610 54 20611 0 20612 2 20613 53 20614 50
344/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
20615 0 20616 1 20617 50 20618 0 20619 0 20620 1 20621 48 20622 0 20623 0 20624 1 20625 48 20626 0 20627 0 20628 2 20629 52 20630 56 20631 0 20632 1 20633 49 20634 0 20635 0 20636 1 20637 48 20638 0 20639 0 20640 1 20641 48 20642 0 20643 0 20644 2 20645 52 20646 56 20647 0 20648 1 20649 49 20650 0 20651 0 20652 1 20653 48 20654 0 20655 0 20656 1 20657 48 20658 0 20659 0 20660 2 20661 52 20662 57 20663 0 20664 1 20665 49 20666 0 20667 0 20668 1 20669 48 20670 0 20671 0 20672 2 20673 53 20674 54
345/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
20675 0 20676 2 20677 53 20678 50 20679 0 20680 1 20681 50 20682 0 20683 0 20684 1 20685 48 20686 0 20687 0 20688 1 20689 48 20690 0 20691 0 20692 2 20693 52 20694 56 20695 0 20696 1 20697 49 20698 0 20699 0 20700 1 20701 48 20702 0 20703 0 20704 1 20705 48 20706 0 20707 0 20708 2 20709 52 20710 56 20711 0 20712 1 20713 49 20714 0 20715 0 20716 1 20717 48 20718 0 20719 0 20720 1 20721 48 20722 0 20723 0 20724 2 20725 52 20726 57 20727 0 20728 1 20729 49 20730 0 20731 0 20732 1 20733 48 20734 0
346/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
20735 0 20736 2 20737 53 20738 54 20739 0 20740 2 20741 53 20742 50 20743 0 20744 1 20745 50 20746 0 20747 0 20748 1 20749 48 20750 0 20751 0 20752 1 20753 48 20754 0 20755 0 20756 2 20757 52 20758 56 20759 0 20760 1 20761 49 20762 0 20763 0 20764 1 20765 48 20766 0 20767 0 20768 1 20769 48 20770 0 20771 0 20772 2 20773 52 20774 56 20775 0 20776 1 20777 49 20778 0 20779 0 20780 1 20781 48 20782 0 20783 0 20784 1 20785 48 20786 0 20787 0 20788 2 20789 52 20790 57 20791 0 20792 1 20793 49 20794 0
347/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
20795 0 20796 1 20797 48 20798 0 20799 0 20800 2 20801 53 20802 54 20803 0 20804 2 20805 53 20806 50 20807 0 20808 1 20809 50 20810 0 20811 0 20812 1 20813 48 20814 0 20815 0 20816 1 20817 48 20818 0 20819 0 20820 2 20821 52 20822 56 20823 0 20824 1 20825 49 20826 0 20827 0 20828 1 20829 48 20830 0 20831 0 20832 1 20833 48 20834 0 20835 0 20836 2 20837 52 20838 56 20839 0 20840 1 20841 49 20842 0 20843 0 20844 1 20845 48 20846 0 20847 0 20848 1 20849 48 20850 0 20851 0 20852 2 20853 52 20854 57
348/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
20855 0 20856 1 20857 49 20858 0 20859 0 20860 1 20861 48 20862 0 20863 0 20864 2 20865 53 20866 54 20867 0 20868 2 20869 53 20870 50 20871 0 20872 1 20873 50 20874 0 20875 0 20876 1 20877 48 20878 0 20879 0 20880 1 20881 48 20882 0 20883 0 20884 2 20885 52 20886 56 20887 0 20888 1 20889 49 20890 0 20891 0 20892 1 20893 48 20894 0 20895 0 20896 1 20897 48 20898 0 20899 0 20900 2 20901 52 20902 56 20903 0 20904 1 20905 49 20906 0 20907 0 20908 1 20909 48 20910 0 20911 0 20912 1 20913 48 20914 0
349/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
20915 0 20916 2 20917 52 20918 57 20919 0 20920 1 20921 49 20922 0 20923 0 20924 1 20925 48 20926 0 20927 0 20928 2 20929 53 20930 54 20931 0 20932 2 20933 53 20934 50 20935 0 20936 1 20937 50 20938 0 20939 0 20940 1 20941 48 20942 0 20943 0 20944 1 20945 48 20946 0 20947 0 20948 2 20949 52 20950 56 20951 0 20952 1 20953 49 20954 0 20955 0 20956 1 20957 48 20958 0 20959 0 20960 1 20961 48 20962 0 20963 0 20964 2 20965 52 20966 56 20967 0 20968 1 20969 49 20970 0 20971 0 20972 1 20973 48 20974 0
350/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
20975 0 20976 1 20977 48 20978 0 20979 0 20980 2 20981 52 20982 57 20983 0 20984 1 20985 49 20986 0 20987 0 20988 1 20989 48 20990 0 20991 0 20992 2 20993 53 20994 54 20995 0 20996 2 20997 53 20998 50 20999 0 21000 1 21001 49 21002 0 21003 0 21004 1 21005 48 21006 0 21007 0 21008 1 21009 48 21010 0 21011 0 21012 2 21013 52 21014 56 21015 0 21016 1 21017 49 21018 0 21019 0 21020 1 21021 48 21022 0 21023 0 21024 1 21025 48 21026 0 21027 0 21028 2 21029 53 21030 48 21031 0 21032 1 21033 49 21034 0
351/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
21035 0 21036 1 21037 48 21038 0 21039 0 21040 2 21041 53 21042 48 21043 0 21044 2 21045 53 21046 51 21047 0 21048 1 21049 50 21050 0 21051 0 21052 1 21053 48 21054 0 21055 0 21056 2 21057 53 21058 52 21059 0 21060 2 21061 53 21062 51 21063 0 21064 1 21065 50 21066 0 21067 0 21068 1 21069 48 21070 0 21071 0 21072 1 21073 48 21074 0 21075 0 21076 2 21077 52 21078 56 21079 0 21080 1 21081 49 21082 0 21083 0 21084 1 21085 48 21086 0 21087 0 21088 1 21089 48 21090 0 21091 0 21092 2 21093 52 21094 57
352/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
21095 0 21096 1 21097 49 21098 0 21099 0 21100 1 21101 48 21102 0 21103 0 21104 2 21105 53 21106 55 21107 0 21108 2 21109 53 21110 50 21111 0 21112 1 21113 50 21114 0 21115 0 21116 1 21117 48 21118 0 21119 0 21120 1 21121 48 21122 0 21123 0 21124 2 21125 52 21126 56 21127 0 21128 1 21129 49 21130 0 21131 0 21132 1 21133 48 21134 0 21135 0 21136 1 21137 48 21138 0 21139 0 21140 2 21141 52 21142 56 21143 0 21144 1 21145 49 21146 0 21147 0 21148 1 21149 48 21150 0 21151 0 21152 1 21153 48 21154 0
353/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
21155 0 21156 2 21157 52 21158 57 21159 0 21160 1 21161 49 21162 0 21163 0 21164 1 21165 48 21166 0 21167 0 21168 2 21169 53 21170 54 21171 0 21172 2 21173 53 21174 50 21175 0 21176 1 21177 50 21178 0 21179 0 21180 1 21181 48 21182 0 21183 0 21184 1 21185 48 21186 0 21187 0 21188 2 21189 52 21190 56 21191 0 21192 1 21193 49 21194 0 21195 0 21196 1 21197 48 21198 0 21199 0 21200 1 21201 48 21202 0 21203 0 21204 2 21205 52 21206 56 21207 0 21208 1 21209 49 21210 0 21211 0 21212 1 21213 48 21214 0
354/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
21215 0 21216 1 21217 48 21218 0 21219 0 21220 2 21221 52 21222 57 21223 0 21224 1 21225 49 21226 0 21227 0 21228 1 21229 48 21230 0 21231 0 21232 2 21233 53 21234 54 21235 0 21236 2 21237 53 21238 50 21239 0 21240 1 21241 50 21242 0 21243 0 21244 1 21245 48 21246 0 21247 0 21248 1 21249 48 21250 0 21251 0 21252 2 21253 52 21254 56 21255 0 21256 1 21257 49 21258 0 21259 0 21260 1 21261 48 21262 0 21263 0 21264 1 21265 48 21266 0 21267 0 21268 2 21269 52 21270 56 21271 0 21272 1 21273 49 21274 0
355/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
21275 0 21276 1 21277 48 21278 0 21279 0 21280 1 21281 48 21282 0 21283 0 21284 2 21285 53 21286 48 21287 0 21288 1 21289 49 21290 0 21291 0 21292 1 21293 48 21294 0 21295 0 21296 2 21297 53 21298 48 21299 0 21300 2 21301 53 21302 51 21303 0 21304 1 21305 50 21306 0 21307 0 21308 1 21309 48 21310 0 21311 0 21312 2 21313 53 21314 52 21315 0 21316 2 21317 53 21318 51 21319 0 21320 1 21321 50 21322 0 21323 0 21324 1 21325 48 21326 0 21327 0 21328 1 21329 48 21330 0 21331 0 21332 2 21333 52 21334 56
356/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
21335 0 21336 1 21337 49 21338 0 21339 0 21340 1 21341 48 21342 0 21343 0 21344 1 21345 48 21346 0 21347 0 21348 2 21349 52 21350 57 21351 0 21352 1 21353 49 21354 0 21355 0 21356 1 21357 48 21358 0 21359 0 21360 2 21361 53 21362 55 21363 0 21364 2 21365 53 21366 50 21367 0 21368 1 21369 50 21370 0 21371 0 21372 1 21373 48 21374 0 21375 0 21376 1 21377 48 21378 0 21379 0 21380 2 21381 52 21382 56 21383 0 21384 1 21385 49 21386 0 21387 0 21388 1 21389 48 21390 0 21391 0 21392 1 21393 48 21394 0
357/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
21395 0 21396 2 21397 52 21398 56 21399 0 21400 1 21401 49 21402 0 21403 0 21404 1 21405 48 21406 0 21407 0 21408 1 21409 48 21410 0 21411 0 21412 2 21413 52 21414 57 21415 0 21416 1 21417 49 21418 0 21419 0 21420 1 21421 48 21422 0 21423 0 21424 2 21425 53 21426 54 21427 0 21428 2 21429 53 21430 50 21431 0 21432 1 21433 50 21434 0 21435 0 21436 1 21437 48 21438 0 21439 0 21440 1 21441 48 21442 0 21443 0 21444 2 21445 52 21446 56 21447 0 21448 1 21449 49 21450 0 21451 0 21452 1 21453 48 21454 0
358/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
21455 0 21456 1 21457 48 21458 0 21459 0 21460 2 21461 52 21462 56 21463 0 21464 1 21465 49 21466 0 21467 0 21468 1 21469 48 21470 0 21471 0 21472 1 21473 48 21474 0 21475 0 21476 2 21477 52 21478 57 21479 0 21480 1 21481 49 21482 0 21483 0 21484 1 21485 48 21486 0 21487 0 21488 2 21489 53 21490 54 21491 0 21492 2 21493 53 21494 50 21495 0 21496 1 21497 50 21498 0 21499 0 21500 1 21501 48 21502 0 21503 0 21504 1 21505 48 21506 0 21507 0 21508 2 21509 52 21510 56 21511 0 21512 1 21513 49 21514 0
359/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
21515 0 21516 1 21517 48 21518 0 21519 0 21520 1 21521 48 21522 0 21523 0 21524 2 21525 52 21526 56 21527 0 21528 1 21529 49 21530 0 21531 0 21532 1 21533 48 21534 0 21535 0 21536 1 21537 48 21538 0 21539 0 21540 2 21541 53 21542 48 21543 0 21544 1 21545 49 21546 0 21547 0 21548 1 21549 48 21550 0 21551 0 21552 2 21553 53 21554 48 21555 0 21556 2 21557 53 21558 51 21559 0 21560 1 21561 50 21562 0 21563 0 21564 1 21565 48 21566 0 21567 0 21568 2 21569 53 21570 52 21571 0 21572 2 21573 53 21574 51
360/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
21575 0 21576 1 21577 50 21578 0 21579 0 21580 1 21581 48 21582 0 21583 0 21584 1 21585 48 21586 0 21587 0 21588 2 21589 52 21590 56 21591 0 21592 1 21593 49 21594 0 21595 0 21596 1 21597 48 21598 0 21599 0 21600 1 21601 48 21602 0 21603 0 21604 2 21605 52 21606 57 21607 0 21608 1 21609 49 21610 0 21611 0 21612 1 21613 48 21614 0 21615 0 21616 2 21617 53 21618 55 21619 0 21620 2 21621 53 21622 50 21623 0 21624 1 21625 50 21626 0 21627 0 21628 1 21629 48 21630 0 21631 0 21632 1 21633 48 21634 0
361/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
21635 0 21636 2 21637 52 21638 56 21639 0 21640 1 21641 49 21642 0 21643 0 21644 1 21645 48 21646 0 21647 0 21648 1 21649 48 21650 0 21651 0 21652 2 21653 52 21654 56 21655 0 21656 1 21657 49 21658 0 21659 0 21660 1 21661 48 21662 0 21663 0 21664 1 21665 48 21666 0 21667 0 21668 2 21669 52 21670 57 21671 0 21672 1 21673 49 21674 0 21675 0 21676 1 21677 48 21678 0 21679 0 21680 2 21681 53 21682 54 21683 0 21684 2 21685 53 21686 50 21687 0 21688 1 21689 50 21690 0 21691 0 21692 1 21693 48 21694 0
362/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
21695 0 21696 1 21697 48 21698 0 21699 0 21700 2 21701 52 21702 56 21703 0 21704 1 21705 49 21706 0 21707 0 21708 1 21709 48 21710 0 21711 0 21712 1 21713 48 21714 0 21715 0 21716 2 21717 52 21718 56 21719 0 21720 1 21721 49 21722 0 21723 0 21724 1 21725 48 21726 0 21727 0 21728 1 21729 48 21730 0 21731 0 21732 2 21733 52 21734 57 21735 0 21736 1 21737 49 21738 0 21739 0 21740 1 21741 48 21742 0 21743 0 21744 2 21745 53 21746 54 21747 0 21748 2 21749 53 21750 50 21751 0 21752 1 21753 50 21754 0
363/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
21755 0 21756 1 21757 48 21758 0 21759 0 21760 1 21761 48 21762 0 21763 0 21764 2 21765 52 21766 56 21767 0 21768 1 21769 49 21770 0 21771 0 21772 1 21773 48 21774 0 21775 0 21776 1 21777 48 21778 0 21779 0 21780 2 21781 52 21782 56 21783 0 21784 1 21785 49 21786 0 21787 0 21788 1 21789 48 21790 0 21791 0 21792 1 21793 48 21794 0 21795 0 21796 2 21797 53 21798 48 21799 0 21800 1 21801 49 21802 0 21803 0 21804 1 21805 48 21806 0 21807 0 21808 2 21809 53 21810 48 21811 0 21812 2 21813 53 21814 51
364/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
21815 0 21816 1 21817 50 21818 0 21819 0 21820 1 21821 48 21822 0 21823 0 21824 2 21825 53 21826 52 21827 0 21828 2 21829 53 21830 51 21831 0 21832 1 21833 50 21834 0 21835 0 21836 1 21837 48 21838 0 21839 0 21840 1 21841 48 21842 0 21843 0 21844 2 21845 52 21846 56 21847 0 21848 1 21849 49 21850 0 21851 0 21852 1 21853 48 21854 0 21855 0 21856 1 21857 48 21858 0 21859 0 21860 2 21861 52 21862 57 21863 0 21864 1 21865 49 21866 0 21867 0 21868 1 21869 48 21870 0 21871 0 21872 2 21873 53 21874 55
365/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
21875 0 21876 2 21877 53 21878 50 21879 0 21880 1 21881 50 21882 0 21883 0 21884 1 21885 48 21886 0 21887 0 21888 1 21889 48 21890 0 21891 0 21892 2 21893 52 21894 56 21895 0 21896 1 21897 49 21898 0 21899 0 21900 1 21901 48 21902 0 21903 0 21904 1 21905 48 21906 0 21907 0 21908 2 21909 52 21910 56 21911 0 21912 1 21913 49 21914 0 21915 0 21916 1 21917 48 21918 0 21919 0 21920 1 21921 48 21922 0 21923 0 21924 2 21925 52 21926 57 21927 0 21928 1 21929 49 21930 0 21931 0 21932 1 21933 48 21934 0
366/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
21935 0 21936 2 21937 53 21938 54 21939 0 21940 2 21941 53 21942 50 21943 0 21944 1 21945 50 21946 0 21947 0 21948 1 21949 48 21950 0 21951 0 21952 1 21953 48 21954 0 21955 0 21956 2 21957 52 21958 56 21959 0 21960 1 21961 49 21962 0 21963 0 21964 1 21965 48 21966 0 21967 0 21968 1 21969 48 21970 0 21971 0 21972 2 21973 52 21974 56 21975 0 21976 1 21977 49 21978 0 21979 0 21980 1 21981 48 21982 0 21983 0 21984 1 21985 48 21986 0 21987 0 21988 2 21989 52 21990 57 21991 0 21992 1 21993 49 21994 0
367/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
21995 0 21996 1 21997 48 21998 0 21999 0 22000 2 22001 53 22002 54 22003 0 22004 2 22005 53 22006 50 22007 0 22008 1 22009 50 22010 0 22011 0 22012 1 22013 48 22014 0 22015 0 22016 1 22017 48 22018 0 22019 0 22020 2 22021 52 22022 56 22023 0 22024 1 22025 49 22026 0 22027 0 22028 1 22029 48 22030 0 22031 0 22032 1 22033 48 22034 0 22035 0 22036 2 22037 52 22038 56 22039 0 22040 1 22041 49 22042 0 22043 0 22044 1 22045 48 22046 0 22047 0 22048 1 22049 48 22050 0 22051 0 22052 2 22053 53 22054 48
368/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
22055 0 22056 1 22057 49 22058 0 22059 0 22060 1 22061 48 22062 0 22063 0 22064 2 22065 53 22066 49 22067 0 22068 2 22069 53 22070 51 22071 0 22072 1 22073 50 22074 0 22075 0 22076 1 22077 48 22078 0 22079 0 22080 2 22081 53 22082 54 22083 0 22084 2 22085 53 22086 50 22087 0 22088 1 22089 50 22090 0 22091 0 22092 1 22093 48 22094 0 22095 0 22096 1 22097 48 22098 0 22099 0 22100 2 22101 52 22102 56 22103 0 22104 1 22105 49 22106 0 22107 0 22108 1 22109 48 22110 0 22111 0 22112 1 22113 48 22114 0
369/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
22115 0 22116 2 22117 52 22118 57 22119 0 22120 1 22121 49 22122 0 22123 0 22124 1 22125 48 22126 0 22127 0 22128 2 22129 53 22130 55 22131 0 22132 2 22133 53 22134 50 22135 0 22136 1 22137 50 22138 0 22139 0 22140 1 22141 48 22142 0 22143 0 22144 1 22145 48 22146 0 22147 0 22148 2 22149 52 22150 56 22151 0 22152 1 22153 49 22154 0 22155 0 22156 1 22157 48 22158 0 22159 0 22160 1 22161 48 22162 0 22163 0 22164 2 22165 52 22166 56 22167 0 22168 1 22169 49 22170 0 22171 0 22172 1 22173 48 22174 0
370/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
22175 0 22176 1 22177 48 22178 0 22179 0 22180 2 22181 52 22182 57 22183 0 22184 1 22185 49 22186 0 22187 0 22188 1 22189 48 22190 0 22191 0 22192 2 22193 53 22194 54 22195 0 22196 2 22197 53 22198 50 22199 0 22200 1 22201 50 22202 0 22203 0 22204 1 22205 48 22206 0 22207 0 22208 1 22209 48 22210 0 22211 0 22212 2 22213 52 22214 56 22215 0 22216 1 22217 49 22218 0 22219 0 22220 1 22221 48 22222 0 22223 0 22224 1 22225 48 22226 0 22227 0 22228 2 22229 52 22230 56 22231 0 22232 1 22233 49 22234 0
371/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
22235 0 22236 1 22237 48 22238 0 22239 0 22240 1 22241 48 22242 0 22243 0 22244 2 22245 52 22246 57 22247 0 22248 1 22249 49 22250 0 22251 0 22252 1 22253 48 22254 0 22255 0 22256 2 22257 53 22258 54 22259 0 22260 2 22261 53 22262 50 22263 0 22264 1 22265 50 22266 0 22267 0 22268 1 22269 48 22270 0 22271 0 22272 1 22273 48 22274 0 22275 0 22276 2 22277 52 22278 56 22279 0 22280 1 22281 49 22282 0 22283 0 22284 1 22285 48 22286 0 22287 0 22288 1 22289 48 22290 0 22291 0 22292 2 22293 52 22294 56
372/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
22295 0 22296 1 22297 49 22298 0 22299 0 22300 1 22301 48 22302 0 22303 0 22304 1 22305 48 22306 0 22307 0 22308 2 22309 53 22310 48 22311 0 22312 1 22313 49 22314 0 22315 0 22316 1 22317 48 22318 0 22319 0 22320 2 22321 53 22322 48 22323 0 22324 2 22325 53 22326 51 22327 0 22328 1 22329 50 22330 0 22331 0 22332 1 22333 48 22334 0 22335 0 22336 2 22337 53 22338 52 22339 0 22340 2 22341 53 22342 51 22343 0 22344 1 22345 50 22346 0 22347 0 22348 1 22349 48 22350 0 22351 0 22352 1 22353 48 22354 0
373/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
22355 0 22356 2 22357 52 22358 56 22359 0 22360 1 22361 49 22362 0 22363 0 22364 1 22365 48 22366 0 22367 0 22368 1 22369 48 22370 0 22371 0 22372 2 22373 52 22374 57 22375 0 22376 1 22377 49 22378 0 22379 0 22380 1 22381 48 22382 0 22383 0 22384 2 22385 53 22386 55 22387 0 22388 2 22389 53 22390 50 22391 0 22392 1 22393 50 22394 0 22395 0 22396 1 22397 48 22398 0 22399 0 22400 1 22401 48 22402 0 22403 0 22404 2 22405 52 22406 56 22407 0 22408 1 22409 49 22410 0 22411 0 22412 1 22413 48
374/375

xic-ref (-target linux -O [basic test]): arrinit01.xi
Expected result:
./arrinit01.ssol.nml
11 22 33 44 55
375/375

xic-ref (-target linux -O [basic test]): arrinit02.xi
xic-ref (-target linux -O [basic test]): arrinit02.xi
Failed to execute: arrinit02 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arrinit02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[] = {f(1), f(2), f(3), f(4), f(5)}
6 i: int = 0
7 while (i < length(a)) {
8 println(unparseInt(a[i])) 9 i=i+ 1
10 }
11 }
12
13 f(i: int): int {
14 print("f() called: ") 15 println(unparseInt(i)) 16 return i
17 }
Compiler's standard output:
ASM generated
Generated result:
./arrinit02.s.nml
1 f() called: 0 2 f() called: 0 3 f() called: 0 4 f() called: 0 5 f() called: 0 60
70 80 90
10 0 11 0 12 0 13 0 14 0 15 0 16 0 17 0 18 0 19 0 20 0 21 0 22 0 23 0 24 0 25 0 26 0 27 0 28 0
1/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
29 0 30 0 31 0 32 0 33 0 34 0 35 0 36 0 37 0 38 0 39 0 40 0 41 0 42 0 43 0 44 0 45 0 46 0 47 0 48 0 49 0 50 0 51 0 52 0 53 0 54 0 55 0 56 0 57 0 58 0 59 0 60 0 61 0 62 0 63 0 64 0 65 0 66 0 67 0 68 0 69 0 70 0 71 0 72 0 73 0 74 0 75 0 76 0 77 0 78 0 79 0 80 0 81 0 82 0 83 0 84 0 85 0 86 0 87 0 88 0
2/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
89 0 90 0 91 0 92 0 93 0 94 0 95 0 96 0 97 0 98 0 99 0
100 0
101 0
102 0
103 0
104 0
105 0
106 0
107 0
108 0
109 0
110 0
111 0
112 0
113 0
114 0
115 0
116 0
117 0
118 0
119 0
120 0
121 0
122 0
123 0
124 0
125 0
126 0
127 0
128 0
129 35156864 130 0
131 0
132 0
133 35156896 134 0
135 0
136 0
137 35156928 138 0
139 0
140 0
141 35156960 142 0
143 0
144 0
145 35156992 146 0
147 0
148 0
3/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
149 35157024 150 0
151 0
152 0
153 35157056 154 0
155 0
156 0
157 35157088 158 0
159 0
160 0
161 35157120 162 0
163 0
164 0
165 35157152 166 0
167 0
168 0
169 35157184 170 0
171 0
172 0
173 35157216 174 0
175 0
176 0
177 35157248 178 0
179 0
180 0
181 35157280 182 0
183 0
184 0
185 35157312 186 0
187 0
188 0
189 35157344 190 0
191 0
192 0
193 35157376 194 0
195 0
196 0
197 35157408 198 0
199 0
200 0
201 35157440 202 0
203 0
204 0
205 35157472 206 0
207 0
208 0
4/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
209 35157504 210 0
211 0
212 0
213 35157536 214 0
215 0
216 0
217 35157568 218 0
219 0
220 0
221 35157600 222 0
223 0
224 0
225 35157632 226 0
227 0
228 0
229 1 230 48 231 0 232 0 233 1 234 48 235 0 236 0 237 1 238 48 239 0 240 0 241 1 242 48 243 0 244 0 245 1 246 48 247 0 248 0 249 1 250 48 251 0 252 0 253 1 254 48 255 0 256 0 257 1 258 48 259 0 260 0 261 1 262 48 263 0 264 0 265 1 266 48 267 0 268 0
5/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
269 1 270 48 271 0 272 0 273 1 274 48 275 0 276 0 277 1 278 48 279 0 280 0 281 1 282 48 283 0 284 0 285 1 286 48 287 0 288 0 289 1 290 48 291 0 292 0 293 1 294 48 295 0 296 0 297 1 298 48 299 0 300 0 301 1 302 48 303 0 304 0 305 1 306 48 307 0 308 0 309 1 310 48 311 0 312 0 313 1 314 48 315 0 316 0 317 1 318 48 319 0 320 0 321 1 322 48 323 0 324 0 325 1 326 48 327 0 328 0
6/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
329 1 330 48 331 0 332 0 333 1 334 48 335 0 336 0 337 1 338 48 339 0 340 0 341 1 342 48 343 0 344 0 345 1 346 48 347 0 348 0 349 1 350 48 351 0 352 0 353 1 354 48 355 0 356 0 357 1 358 48 359 0 360 0 361 1 362 48 363 0 364 0 365 1 366 48 367 0 368 0 369 1 370 48 371 0 372 0 373 1 374 48 375 0 376 0 377 1 378 48 379 0 380 0 381 1 382 48 383 0 384 0 385 1 386 48 387 0 388 0
7/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
389 1 390 48 391 0 392 0 393 1 394 48 395 0 396 0 397 1 398 48 399 0 400 0 401 1 402 48 403 0 404 0 405 1 406 48 407 0 408 0 409 1 410 48 411 0 412 0 413 1 414 48 415 0 416 0 417 1 418 48 419 0 420 0 421 1 422 48 423 0 424 0 425 1 426 48 427 0 428 0 429 1 430 48 431 0 432 0 433 1 434 48 435 0 436 0 437 1 438 48 439 0 440 0 441 1 442 48 443 0 444 0 445 1 446 48 447 0 448 0
8/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
449 1 450 48 451 0 452 0 453 1 454 48 455 0 456 0 457 1 458 48 459 0 460 0 461 1 462 48 463 0 464 0 465 1 466 48 467 0 468 0 469 1 470 48 471 0 472 0 473 1 474 48 475 0 476 0 477 1 478 48 479 0 480 0 481 1 482 48 483 0 484 0 485 1 486 48 487 0 488 0 489 1 490 48 491 0 492 0 493 1 494 48 495 0 496 0 497 1 498 48 499 0 500 0 501 1 502 48 503 0 504 0 505 1 506 48 507 0 508 0
9/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
509 1
510 48
511 0
512 0
513 1
514 48
515 0
516 0
517 1
518 48
519 0
520 0
521 1
522 48
523 0
524 0
525 0
526 0
527 0
528 0
529 0
530 0
531 0
532 0
533 0
534 0
535 35160064 536 0
537 0
538 0
539 0
540 0
541 0
542 0
543 0
544 0
545 35160144 546 0
547 0
548 0
549 0
550 0
551 0
552 0
553 0
554 0
555 35160224 556 0
557 0
558 0
559 0
560 0
561 0
562 0
563 0
564 0
565 35160304 566 0
567 0 568 0
10/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
569 0
570 0
571 0
572 0
573 0
574 0
575 35160384 576 0
577 0
578 0
579 0
580 0
581 0
582 0
583 0
584 0
585 35160464 586 0
587 0
588 0
589 0
590 0
591 0
592 0
593 0
594 0
595 35160544 596 0
597 0
598 0
599 0
600 0
601 0
602 0
603 0
604 0
605 35160624 606 0
607 0
608 0
609 0
610 0
611 0
612 0
613 0
614 0
615 35160704 616 0
617 0
618 0
619 0
620 0
621 0
622 0
623 0
624 0
625 35160784 626 0
627 0 628 0
11/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
629 0
630 0
631 0
632 0
633 0
634 0
635 35160864 636 0
637 0
638 0
639 0
640 0
641 0
642 0
643 0
644 0
645 35160944 646 0
647 0
648 0
649 0
650 0
651 0
652 0
653 0
654 0
655 35161024 656 51
657 53 658 49 659 54 660 49 661 48 662 50 663 52 664 0 665 8 666 51 667 53 668 49 669 54 670 48 671 57 672 52 673 52 674 0 675 8 676 51 677 53 678 49 679 54 680 48 681 56 682 54 683 52 684 0 685 8 686 51 687 53 688 49
12/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
689 54 690 48 691 55 692 56 693 52 694 0 695 8 696 51 697 53 698 49 699 54 700 48 701 55 702 48 703 52 704 0 705 8 706 51 707 53 708 49 709 54 710 48 711 54 712 50 713 52 714 0 715 8 716 51 717 53 718 49 719 54 720 48 721 53 722 52 723 52 724 0 725 8 726 51 727 53 728 49 729 54 730 48 731 52 732 54 733 52 734 0 735 8 736 51 737 53 738 49 739 54 740 48 741 51 742 56 743 52 744 0 745 8 746 51 747 53 748 49
13/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
749 54 750 48 751 51 752 48 753 52 754 0 755 8 756 51 757 53 758 49 759 54 760 48 761 50 762 50 763 52 764 0 765 8 766 51 767 53 768 49 769 54 770 48 771 49 772 52 773 52 774 0 775 8 776 51 777 53 778 49 779 54 780 48 781 48 782 54 783 52 784 0 785 8 786 51 787 53 788 49 789 53 790 55 791 54 792 51 793 50 794 0 795 8 796 51 797 53 798 49 799 53 800 55 801 54 802 48 803 48 804 0 805 8 806 51 807 53 808 49
14/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
809 53 810 55 811 53 812 54 813 56 814 0 815 8 816 51 817 53 818 49 819 53 820 55 821 53 822 51 823 54 824 0 825 8 826 51 827 53 828 49 829 53 830 55 831 53 832 48 833 52 834 0 835 8 836 51 837 53 838 49 839 53 840 55 841 52 842 55 843 50 844 0 845 8 846 51 847 53 848 49 849 53 850 55 851 52 852 52 853 48 854 0 855 8 856 51 857 53 858 49 859 53 860 55 861 52 862 48 863 56 864 0 865 8 866 51 867 53 868 49
15/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
869 53 870 55 871 51 872 55 873 54 874 0 875 8 876 51 877 53 878 49 879 53 880 55 881 51 882 52 883 52 884 0 885 8 886 51 887 53 888 49 889 53 890 55 891 51 892 49 893 50 894 0 895 8 896 51 897 53 898 49 899 53 900 55 901 50 902 56 903 48 904 0 905 8 906 51 907 53 908 49 909 53 910 55 911 50 912 52 913 56 914 0 915 8 916 51 917 53 918 49 919 53 920 55 921 50 922 49 923 54 924 0 925 8 926 51 927 53 928 49
16/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
929 53 930 55 931 49 932 56 933 52 934 0 935 8 936 51 937 53 938 49 939 53 940 55 941 49 942 53 943 50 944 0 945 8 946 51 947 53 948 49 949 53 950 55 951 49 952 50 953 48 954 0 955 8 956 51 957 53 958 49 959 53 960 55 961 48 962 56 963 56 964 0 965 8 966 51 967 53 968 49 969 53 970 55 971 48 972 53 973 54 974 0 975 8 976 51 977 53 978 49 979 53 980 55 981 48 982 50 983 52 984 0 985 8 986 51 987 53 988 49
17/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
989 53 990 54 991 57 992 57 993 50 994 0 995 8 996 51 997 53 998 49 999 53
1000 54 1001 57 1002 54 1003 48 1004 0 1005 8 1006 51 1007 53 1008 49 1009 53 1010 54 1011 57 1012 50 1013 56 1014 0 1015 8 1016 51 1017 53 1018 49 1019 53 1020 54 1021 56 1022 57 1023 54 1024 0 1025 8 1026 51 1027 53 1028 49 1029 53 1030 54 1031 56 1032 54 1033 52 1034 0 1035 0 1036 0 1037 1 1038 48 1039 0 1040 0 1041 1 1042 48 1043 0 1044 0 1045 2 1046 52 1047 56 1048 0
18/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
1049 1 1050 49 1051 0 1052 0 1053 1 1054 48 1055 0 1056 0 1057 1 1058 48 1059 0 1060 0 1061 2 1062 52 1063 56 1064 0 1065 1 1066 49 1067 0 1068 0 1069 1 1070 48 1071 0 1072 0 1073 1 1074 48 1075 0 1076 0 1077 2 1078 52 1079 56 1080 0 1081 1 1082 49 1083 0 1084 0 1085 1 1086 48 1087 0 1088 0 1089 1 1090 48 1091 0 1092 0 1093 2 1094 52 1095 56 1096 0 1097 1 1098 49 1099 0 1100 0 1101 1 1102 48 1103 0 1104 0 1105 1 1106 48 1107 0 1108 0
19/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
1109 2 1110 52 1111 56 1112 0 1113 1 1114 49 1115 0 1116 0 1117 1 1118 48 1119 0 1120 0 1121 1 1122 48 1123 0 1124 0 1125 2 1126 52 1127 56 1128 0 1129 1 1130 49 1131 0 1132 0 1133 1 1134 48 1135 0 1136 0 1137 1 1138 48 1139 0 1140 0 1141 2 1142 52 1143 56 1144 0 1145 1 1146 49 1147 0 1148 0 1149 1 1150 48 1151 0 1152 0 1153 1 1154 48 1155 0 1156 0 1157 2 1158 52 1159 56 1160 0 1161 1 1162 49 1163 0 1164 0 1165 1 1166 48 1167 0 1168 0
20/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
1169 1 1170 48 1171 0 1172 0 1173 2 1174 52 1175 56 1176 0 1177 1 1178 49 1179 0 1180 0 1181 1 1182 48 1183 0 1184 0 1185 1 1186 48 1187 0 1188 0 1189 2 1190 52 1191 56 1192 0 1193 1 1194 49 1195 0 1196 0 1197 1 1198 48 1199 0 1200 0 1201 1 1202 48 1203 0 1204 0 1205 2 1206 52 1207 56 1208 0 1209 1 1210 49 1211 0 1212 0 1213 1 1214 48 1215 0 1216 0 1217 1 1218 48 1219 0 1220 0 1221 2 1222 52 1223 56 1224 0 1225 1 1226 49 1227 0 1228 0
21/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
1229 1 1230 48 1231 0 1232 0 1233 1 1234 48 1235 0 1236 0 1237 2 1238 52 1239 56 1240 0 1241 1 1242 49 1243 0 1244 0 1245 1 1246 48 1247 0 1248 0 1249 1 1250 48 1251 0 1252 0 1253 2 1254 52 1255 56 1256 0 1257 1 1258 49 1259 0 1260 0 1261 1 1262 48 1263 0 1264 0 1265 1 1266 48 1267 0 1268 0 1269 2 1270 52 1271 56 1272 0 1273 1 1274 49 1275 0 1276 0 1277 1 1278 48 1279 0 1280 0 1281 1 1282 48 1283 0 1284 0 1285 2 1286 52 1287 56 1288 0
22/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
1289 1 1290 49 1291 0 1292 0 1293 1 1294 48 1295 0 1296 0 1297 1 1298 48 1299 0 1300 0 1301 2 1302 52 1303 56 1304 0 1305 1 1306 49 1307 0 1308 0 1309 1 1310 48 1311 0 1312 0 1313 1 1314 48 1315 0 1316 0 1317 2 1318 52 1319 56 1320 0 1321 1 1322 49 1323 0 1324 0 1325 1 1326 48 1327 0 1328 0 1329 1 1330 48 1331 0 1332 0 1333 2 1334 52 1335 56 1336 0 1337 1 1338 49 1339 0 1340 0 1341 1 1342 48 1343 0 1344 0 1345 1 1346 48 1347 0 1348 0
23/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
1349 2 1350 52 1351 56 1352 0 1353 1 1354 49 1355 0 1356 0 1357 1 1358 48 1359 0 1360 0 1361 1 1362 48 1363 0 1364 0 1365 2 1366 52 1367 56 1368 0 1369 1 1370 49 1371 0 1372 0 1373 1 1374 48 1375 0 1376 0 1377 1 1378 48 1379 0 1380 0 1381 2 1382 52 1383 56 1384 0 1385 1 1386 49 1387 0 1388 0 1389 1 1390 48 1391 0 1392 0 1393 1 1394 48 1395 0 1396 0 1397 2 1398 52 1399 56 1400 0 1401 1 1402 49 1403 0 1404 0 1405 1 1406 48 1407 0 1408 0
24/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
1409 1 1410 48 1411 0 1412 0 1413 2 1414 52 1415 56 1416 0 1417 1 1418 49 1419 0 1420 0 1421 1 1422 48 1423 0 1424 0 1425 1 1426 48 1427 0 1428 0 1429 2 1430 52 1431 56 1432 0 1433 1 1434 49 1435 0 1436 0 1437 1 1438 48 1439 0 1440 0 1441 1 1442 48 1443 0 1444 0 1445 2 1446 52 1447 56 1448 0 1449 1 1450 49 1451 0 1452 0 1453 1 1454 48 1455 0 1456 0 1457 1 1458 48 1459 0 1460 0 1461 2 1462 52 1463 56 1464 0 1465 1 1466 49 1467 0 1468 0
25/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
1469 1 1470 48 1471 0 1472 0 1473 1 1474 48 1475 0 1476 0 1477 2 1478 52 1479 56 1480 0 1481 1 1482 49 1483 0 1484 0 1485 1 1486 48 1487 0 1488 0 1489 1 1490 48 1491 0 1492 0 1493 2 1494 52 1495 56 1496 0 1497 1 1498 49 1499 0 1500 0 1501 1 1502 48 1503 0 1504 0 1505 1 1506 48 1507 0 1508 0 1509 2 1510 52 1511 56 1512 0 1513 1 1514 49 1515 0 1516 0 1517 1 1518 48 1519 0 1520 0 1521 1 1522 48 1523 0 1524 0 1525 2 1526 52 1527 56 1528 0
26/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
1529 1 1530 49 1531 0 1532 0 1533 1 1534 48 1535 0 1536 0 1537 1 1538 48 1539 0 1540 0 1541 2 1542 52 1543 56 1544 0 1545 1 1546 49 1547 0 1548 0 1549 1 1550 48 1551 0 1552 0 1553 1 1554 48 1555 0 1556 0 1557 1 1558 48 1559 0 1560 0 1561 1 1562 48 1563 0 1564 0 1565 1 1566 48 1567 0 1568 0 1569 1 1570 48 1571 0 1572 0 1573 1 1574 48 1575 0 1576 0 1577 1 1578 48 1579 0 1580 0 1581 1 1582 48 1583 0 1584 0 1585 1 1586 48 1587 0 1588 0
27/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
1589 1 1590 48 1591 0 1592 0 1593 1 1594 48 1595 0 1596 0 1597 1 1598 48 1599 0 1600 0 1601 1 1602 48 1603 0 1604 0 1605 2 1606 52 1607 56 1608 0 1609 1 1610 49 1611 0 1612 0 1613 1 1614 48 1615 0 1616 0 1617 1 1618 48 1619 0 1620 0 1621 2 1622 52 1623 56 1624 0 1625 1 1626 49 1627 0 1628 0 1629 1 1630 48 1631 0 1632 0 1633 1 1634 48 1635 0 1636 0 1637 2 1638 52 1639 56 1640 0 1641 1 1642 49 1643 0 1644 0 1645 1 1646 48 1647 0 1648 0
28/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
1649 1 1650 48 1651 0 1652 0 1653 2 1654 52 1655 56 1656 0 1657 1 1658 49 1659 0 1660 0 1661 1 1662 48 1663 0 1664 0 1665 1 1666 48 1667 0 1668 0 1669 2 1670 52 1671 56 1672 0 1673 1 1674 49 1675 0 1676 0 1677 1 1678 48 1679 0 1680 0 1681 1 1682 48 1683 0 1684 0 1685 2 1686 52 1687 56 1688 0 1689 1 1690 49 1691 0 1692 0 1693 1 1694 48 1695 0 1696 0 1697 1 1698 48 1699 0 1700 0 1701 2 1702 52 1703 56 1704 0 1705 1 1706 49 1707 0 1708 0
29/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
1709 1 1710 48 1711 0 1712 0 1713 1 1714 48 1715 0 1716 0 1717 2 1718 52 1719 56 1720 0 1721 1 1722 49 1723 0 1724 0 1725 1 1726 48 1727 0 1728 0 1729 1 1730 48 1731 0 1732 0 1733 2 1734 52 1735 56 1736 0 1737 1 1738 49 1739 0 1740 0 1741 1 1742 48 1743 0 1744 0 1745 1 1746 48 1747 0 1748 0 1749 2 1750 52 1751 56 1752 0 1753 1 1754 49 1755 0 1756 0 1757 1 1758 48 1759 0 1760 0 1761 1 1762 48 1763 0 1764 0 1765 2 1766 52 1767 56 1768 0
30/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
1769 1 1770 49 1771 0 1772 0 1773 1 1774 48 1775 0 1776 0 1777 1 1778 48 1779 0 1780 0 1781 2 1782 52 1783 56 1784 0 1785 1 1786 49 1787 0 1788 0 1789 1 1790 48 1791 0 1792 0 1793 1 1794 48 1795 0 1796 0 1797 2 1798 52 1799 56 1800 0 1801 1 1802 49 1803 0 1804 0 1805 1 1806 48 1807 0 1808 0 1809 1 1810 48 1811 0 1812 0 1813 2 1814 52 1815 56 1816 0 1817 1 1818 49 1819 0 1820 0 1821 1 1822 48 1823 0 1824 0 1825 1 1826 48 1827 0 1828 0
31/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
1829 2 1830 52 1831 56 1832 0 1833 1 1834 49 1835 0 1836 0 1837 1 1838 48 1839 0 1840 0 1841 1 1842 48 1843 0 1844 0 1845 2 1846 52 1847 56 1848 0 1849 1 1850 49 1851 0 1852 0 1853 1 1854 48 1855 0 1856 0 1857 1 1858 48 1859 0 1860 0 1861 2 1862 52 1863 56 1864 0 1865 1 1866 49 1867 0 1868 0 1869 1 1870 48 1871 0 1872 0 1873 1 1874 48 1875 0 1876 0 1877 2 1878 52 1879 56 1880 0 1881 1 1882 49 1883 0 1884 0 1885 1 1886 48 1887 0 1888 0
32/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
1889 1 1890 48 1891 0 1892 0 1893 2 1894 52 1895 56 1896 0 1897 1 1898 49 1899 0 1900 0 1901 1 1902 48 1903 0 1904 0 1905 1 1906 48 1907 0 1908 0 1909 2 1910 52 1911 56 1912 0 1913 1 1914 49 1915 0 1916 0 1917 1 1918 48 1919 0 1920 0 1921 1 1922 48 1923 0 1924 0 1925 2 1926 52 1927 56 1928 0 1929 1 1930 49 1931 0 1932 0 1933 1 1934 48 1935 0 1936 0 1937 1 1938 48 1939 0 1940 0 1941 2 1942 52 1943 56 1944 0 1945 1 1946 49 1947 0 1948 0
33/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
1949 1 1950 48 1951 0 1952 0 1953 1 1954 48 1955 0 1956 0 1957 2 1958 52 1959 56 1960 0 1961 1 1962 49 1963 0 1964 0 1965 1 1966 48 1967 0 1968 0 1969 1 1970 48 1971 0 1972 0 1973 2 1974 52 1975 56 1976 0 1977 1 1978 49 1979 0 1980 0 1981 1 1982 48 1983 0 1984 0 1985 1 1986 48 1987 0 1988 0 1989 2 1990 52 1991 56 1992 0 1993 1 1994 49 1995 0 1996 0 1997 1 1998 48 1999 0 2000 0 2001 1 2002 48 2003 0 2004 0 2005 2 2006 52 2007 56 2008 0
34/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
2009 1 2010 49 2011 0 2012 0 2013 1 2014 48 2015 0 2016 0 2017 1 2018 48 2019 0 2020 0 2021 2 2022 52 2023 56 2024 0 2025 1 2026 49 2027 0 2028 0 2029 1 2030 48 2031 0 2032 0 2033 1 2034 48 2035 0 2036 0 2037 2 2038 52 2039 56 2040 0 2041 1 2042 49 2043 0 2044 0 2045 1 2046 48 2047 0 2048 0 2049 1 2050 48 2051 0 2052 0 2053 2 2054 52 2055 56 2056 0 2057 1 2058 49 2059 0 2060 0 2061 2 2062 53 2063 51 2064 0 2065 2 2066 53 2067 49 2068 0
35/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
2069 1 2070 56 2071 0 2072 0 2073 1 2074 48 2075 0 2076 0 2077 2 2078 53 2079 50 2080 0 2081 2 2082 53 2083 50 2084 0 2085 2 2086 53 2087 55 2088 0 2089 2 2090 52 2091 56 2092 0 2093 2 2094 53 2095 52 2096 0 2097 2 2098 52 2099 57 2100 0 2101 2 2102 53 2103 51 2104 0 2105 2 2106 53 2107 49 2108 0 2109 1 2110 56 2111 0 2112 0 2113 1 2114 48 2115 0 2116 0 2117 2 2118 53 2119 50 2120 0 2121 2 2122 53 2123 48 2124 0 2125 2 2126 52 2127 56 2128 0
36/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
2129 2 2130 52 2131 57 2132 0 2133 2 2134 53 2135 52 2136 0 2137 2 2138 52 2139 57 2140 0 2141 2 2142 53 2143 51 2144 0 2145 2 2146 53 2147 49 2148 0 2149 1 2150 48 2151 0 2152 0 2153 1 2154 48 2155 0 2156 0 2157 1 2158 48 2159 0 2160 0 2161 1 2162 48 2163 0 2164 0 2165 1 2166 48 2167 0 2168 0 2169 1 2170 48 2171 0 2172 0 2173 1 2174 48 2175 0 2176 0 2177 1 2178 48 2179 0 2180 0 2181 1 2182 48 2183 0 2184 0 2185 1 2186 48 2187 0 2188 0
37/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
2189 1 2190 48 2191 0 2192 0 2193 1 2194 48 2195 0 2196 0 2197 1 2198 48 2199 0 2200 0 2201 1 2202 48 2203 0 2204 0 2205 1 2206 48 2207 0 2208 0 2209 1 2210 48 2211 0 2212 0 2213 1 2214 48 2215 0 2216 0 2217 1 2218 48 2219 0 2220 0 2221 1 2222 48 2223 0 2224 0 2225 1 2226 48 2227 0 2228 0 2229 1 2230 48 2231 0 2232 0 2233 1 2234 48 2235 0 2236 0 2237 1 2238 48 2239 0 2240 0 2241 1 2242 48 2243 0 2244 0 2245 1 2246 48 2247 0 2248 0
38/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
2249 1 2250 48 2251 0 2252 0 2253 1 2254 48 2255 0 2256 0 2257 1 2258 48 2259 0 2260 0 2261 1 2262 48 2263 0 2264 0 2265 1 2266 48 2267 0 2268 0 2269 1 2270 48 2271 0 2272 0 2273 1 2274 48 2275 0 2276 0 2277 1 2278 48 2279 0 2280 0 2281 1 2282 48 2283 0 2284 0 2285 1 2286 48 2287 0 2288 0 2289 1 2290 48 2291 0 2292 0 2293 1 2294 48 2295 0 2296 0 2297 1 2298 48 2299 0 2300 0 2301 1 2302 48 2303 0 2304 0 2305 1 2306 48 2307 0 2308 0
39/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
2309 1 2310 48 2311 0 2312 0 2313 1 2314 48 2315 0 2316 0 2317 1 2318 48 2319 0 2320 0 2321 1 2322 48 2323 0 2324 0 2325 1 2326 48 2327 0 2328 0 2329 1 2330 48 2331 0 2332 0 2333 1 2334 48 2335 0 2336 0 2337 1 2338 48 2339 0 2340 0 2341 1 2342 48 2343 0 2344 0 2345 1 2346 48 2347 0 2348 0 2349 1 2350 48 2351 0 2352 0 2353 1 2354 48 2355 0 2356 0 2357 1 2358 48 2359 0 2360 0 2361 1 2362 48 2363 0 2364 0 2365 1 2366 48 2367 0 2368 0
40/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
2369 1 2370 48 2371 0 2372 0 2373 1 2374 48 2375 0 2376 0 2377 1 2378 48 2379 0 2380 0 2381 1 2382 48 2383 0 2384 0 2385 1 2386 48 2387 0 2388 0 2389 1 2390 48 2391 0 2392 0 2393 1 2394 48 2395 0 2396 0 2397 1 2398 48 2399 0 2400 0 2401 1 2402 48 2403 0 2404 0 2405 1 2406 48 2407 0 2408 0 2409 1 2410 48 2411 0 2412 0 2413 1 2414 48 2415 0 2416 0 2417 1 2418 48 2419 0 2420 0 2421 1 2422 48 2423 0 2424 0 2425 1 2426 48 2427 0 2428 0
41/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
2429 1 2430 48 2431 0 2432 0 2433 1 2434 48 2435 0 2436 0 2437 1 2438 48 2439 0 2440 0 2441 1 2442 48 2443 0 2444 0 2445 1 2446 48 2447 0 2448 0 2449 1 2450 48 2451 0 2452 0 2453 1 2454 48 2455 0 2456 0 2457 1 2458 48 2459 0 2460 0 2461 1 2462 48 2463 0 2464 0 2465 1 2466 48 2467 0 2468 0 2469 1 2470 48 2471 0 2472 0 2473 1 2474 48 2475 0 2476 0 2477 1 2478 48 2479 0 2480 0 2481 1 2482 48 2483 0 2484 0 2485 1 2486 48 2487 0 2488 0
42/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
2489 1 2490 48 2491 0 2492 0 2493 1 2494 48 2495 0 2496 0 2497 1 2498 48 2499 0 2500 0 2501 1 2502 48 2503 0 2504 0 2505 1 2506 48 2507 0 2508 0 2509 1 2510 48 2511 0 2512 0 2513 1 2514 48 2515 0 2516 0 2517 1 2518 48 2519 0 2520 0 2521 1 2522 48 2523 0 2524 0 2525 1 2526 48 2527 0 2528 0 2529 1 2530 48 2531 0 2532 0 2533 1 2534 48 2535 0 2536 0 2537 1 2538 48 2539 0 2540 0 2541 1 2542 48 2543 0 2544 0 2545 1 2546 48 2547 0 2548 0
43/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
2549 1 2550 48 2551 0 2552 0 2553 1 2554 48 2555 0 2556 0 2557 1 2558 48 2559 0 2560 0 2561 1 2562 48 2563 0 2564 0 2565 1 2566 48 2567 0 2568 0 2569 1 2570 48 2571 0 2572 0 2573 1 2574 56 2575 0 2576 0 2577 1 2578 48 2579 0 2580 0 2581 2 2582 52 2583 56 2584 0 2585 2 2586 52 2587 56 2588 0 2589 2 2590 53 2591 52 2592 0 2593 2 2594 53 2595 53 2596 0 2597 2 2598 53 2599 51 2600 0 2601 2 2602 52 2603 57 2604 0 2605 2 2606 53 2607 51 2608 0
44/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
2609 2 2610 53 2611 49 2612 0 2613 1 2614 56 2615 0 2616 0 2617 1 2618 48 2619 0 2620 0 2621 2 2622 53 2623 48 2624 0 2625 2 2626 53 2627 49 2628 0 2629 2 2630 53 2631 52 2632 0 2633 2 2634 53 2635 53 2636 0 2637 2 2638 53 2639 51 2640 0 2641 2 2642 52 2643 57 2644 0 2645 2 2646 53 2647 51 2648 0 2649 2 2650 53 2651 49 2652 0 2653 1 2654 56 2655 0 2656 0 2657 1 2658 48 2659 0 2660 0 2661 2 2662 53 2663 50 2664 0 2665 2 2666 53 2667 52 2668 0
45/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
2669 2 2670 52 2671 56 2672 0 2673 2 2674 52 2675 56 2676 0 2677 2 2678 53 2679 52 2680 0 2681 2 2682 52 2683 57 2684 0 2685 2 2686 53 2687 51 2688 0 2689 2 2690 53 2691 49 2692 0 2693 1 2694 56 2695 0 2696 0 2697 1 2698 48 2699 0 2700 0 2701 2 2702 53 2703 50 2704 0 2705 2 2706 53 2707 50 2708 0 2709 2 2710 52 2711 57 2712 0 2713 2 2714 52 2715 56 2716 0 2717 2 2718 53 2719 52 2720 0 2721 2 2722 52 2723 57 2724 0 2725 2 2726 53 2727 51 2728 0
46/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
2729 2 2730 53 2731 49 2732 0 2733 1 2734 56 2735 0 2736 0 2737 1 2738 48 2739 0 2740 0 2741 2 2742 53 2743 50 2744 0 2745 2 2746 53 2747 48 2748 0 2749 2 2750 53 2751 48 2752 0 2753 2 2754 52 2755 56 2756 0 2757 2 2758 53 2759 52 2760 0 2761 2 2762 52 2763 57 2764 0 2765 2 2766 53 2767 51 2768 0 2769 2 2770 53 2771 49 2772 0 2773 1 2774 56 2775 0 2776 0 2777 1 2778 48 2779 0 2780 0 2781 2 2782 53 2783 50 2784 0 2785 2 2786 52 2787 56 2788 0
47/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
2789 2 2790 53 2791 49 2792 0 2793 2 2794 52 2795 56 2796 0 2797 2 2798 53 2799 52 2800 0 2801 2 2802 52 2803 57 2804 0 2805 2 2806 53 2807 51 2808 0 2809 2 2810 53 2811 49 2812 0 2813 1 2814 56 2815 0 2816 0 2817 1 2818 48 2819 0 2820 0 2821 2 2822 53 2823 50 2824 0 2825 2 2826 53 2827 54 2828 0 2829 2 2830 53 2831 49 2832 0 2833 2 2834 52 2835 56 2836 0 2837 2 2838 53 2839 52 2840 0 2841 2 2842 52 2843 57 2844 0 2845 2 2846 53 2847 51 2848 0
48/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
2849 2 2850 53 2851 49 2852 0 2853 1 2854 56 2855 0 2856 0 2857 1 2858 48 2859 0 2860 0 2861 2 2862 53 2863 50 2864 0 2865 2 2866 53 2867 52 2868 0 2869 2 2870 53 2871 50 2872 0 2873 2 2874 52 2875 56 2876 0 2877 2 2878 53 2879 52 2880 0 2881 2 2882 52 2883 57 2884 0 2885 2 2886 53 2887 51 2888 0 2889 2 2890 53 2891 49 2892 0 2893 1 2894 56 2895 0 2896 0 2897 1 2898 48 2899 0 2900 0 2901 2 2902 53 2903 50 2904 0 2905 2 2906 53 2907 50 2908 0
49/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
2909 2 2910 53 2911 51 2912 0 2913 2 2914 52 2915 56 2916 0 2917 2 2918 53 2919 52 2920 0 2921 2 2922 52 2923 57 2924 0 2925 2 2926 53 2927 51 2928 0 2929 2 2930 53 2931 49 2932 0 2933 1 2934 56 2935 0 2936 0 2937 1 2938 48 2939 0 2940 0 2941 2 2942 53 2943 50 2944 0 2945 2 2946 53 2947 48 2948 0 2949 2 2950 53 2951 52 2952 0 2953 2 2954 52 2955 56 2956 0 2957 2 2958 53 2959 52 2960 0 2961 2 2962 52 2963 57 2964 0 2965 2 2966 53 2967 51 2968 0
50/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
2969 2 2970 53 2971 49 2972 0 2973 1 2974 56 2975 0 2976 0 2977 1 2978 48 2979 0 2980 0 2981 2 2982 53 2983 50 2984 0 2985 2 2986 52 2987 56 2988 0 2989 2 2990 53 2991 53 2992 0 2993 2 2994 52 2995 56 2996 0 2997 2 2998 53 2999 52 3000 0 3001 2 3002 52 3003 57 3004 0 3005 2 3006 53 3007 51 3008 0 3009 2 3010 53 3011 49 3012 0 3013 1 3014 56 3015 0 3016 0 3017 1 3018 48 3019 0 3020 0 3021 2 3022 53 3023 50 3024 0 3025 2 3026 53 3027 54 3028 0
51/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
3029 2 3030 53 3031 53 3032 0 3033 2 3034 52 3035 56 3036 0 3037 2 3038 53 3039 52 3040 0 3041 2 3042 52 3043 57 3044 0 3045 2 3046 53 3047 51 3048 0 3049 2 3050 53 3051 49 3052 0 3053 1 3054 56 3055 0 3056 0 3057 1 3058 48 3059 0 3060 0 3061 2 3062 53 3063 50 3064 0 3065 2 3066 53 3067 52 3068 0 3069 2 3070 53 3071 54 3072 0 3073 2 3074 52 3075 56 3076 0 3077 2 3078 53 3079 52 3080 0 3081 2 3082 52 3083 57 3084 0 3085 2 3086 53 3087 50 3088 0
52/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
3089 2 3090 53 3091 54 3092 0 3093 2 3094 52 3095 57 3096 0 3097 2 3098 53 3099 53 3100 0 3101 2 3102 53 3103 51 3104 0 3105 2 3106 52 3107 57 3108 0 3109 2 3110 53 3111 51 3112 0 3113 2 3114 53 3115 49 3116 0 3117 1 3118 56 3119 0 3120 0 3121 1 3122 48 3123 0 3124 0 3125 2 3126 53 3127 52 3128 0 3129 2 3130 52 3131 57 3132 0 3133 2 3134 53 3135 48 3136 0 3137 2 3138 53 3139 53 3140 0 3141 2 3142 53 3143 51 3144 0 3145 2 3146 52 3147 57 3148 0
53/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
3149 2 3150 53 3151 51 3152 0 3153 2 3154 53 3155 49 3156 0 3157 1 3158 56 3159 0 3160 0 3161 1 3162 48 3163 0 3164 0 3165 2 3166 53 3167 54 3168 0 3169 2 3170 53 3171 50 3172 0 3173 2 3174 53 3175 48 3176 0 3177 2 3178 53 3179 53 3180 0 3181 2 3182 53 3183 51 3184 0 3185 2 3186 52 3187 57 3188 0 3189 2 3190 53 3191 51 3192 0 3193 2 3194 53 3195 49 3196 0 3197 1 3198 56 3199 0 3200 0 3201 1 3202 48 3203 0 3204 0 3205 2 3206 52 3207 56 3208 0
54/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
3209 2 3210 53 3211 54 3212 0 3213 2 3214 53 3215 48 3216 0 3217 2 3218 53 3219 53 3220 0 3221 2 3222 53 3223 51 3224 0 3225 2 3226 52 3227 57 3228 0 3229 2 3230 53 3231 51 3232 0 3233 2 3234 53 3235 49 3236 0 3237 1 3238 56 3239 0 3240 0 3241 1 3242 48 3243 0 3244 0 3245 2 3246 53 3247 48 3248 0 3249 2 3250 52 3251 57 3252 0 3253 2 3254 53 3255 49 3256 0 3257 2 3258 53 3259 53 3260 0 3261 2 3262 53 3263 51 3264 0 3265 2 3266 52 3267 57 3268 0
55/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
3269 2 3270 53 3271 51 3272 0 3273 2 3274 53 3275 49 3276 0 3277 1 3278 56 3279 0 3280 0 3281 1 3282 48 3283 0 3284 0 3285 2 3286 53 3287 50 3288 0 3289 2 3290 53 3291 50 3292 0 3293 2 3294 53 3295 49 3296 0 3297 2 3298 53 3299 53 3300 0 3301 2 3302 53 3303 51 3304 0 3305 2 3306 52 3307 57 3308 0 3309 2 3310 53 3311 51 3312 0 3313 2 3314 53 3315 49 3316 0 3317 1 3318 56 3319 0 3320 0 3321 1 3322 48 3323 0 3324 0 3325 2 3326 53 3327 52 3328 0
56/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
3329 2 3330 53 3331 53 3332 0 3333 2 3334 53 3335 49 3336 0 3337 2 3338 53 3339 53 3340 0 3341 2 3342 53 3343 51 3344 0 3345 2 3346 52 3347 57 3348 0 3349 2 3350 53 3351 51 3352 0 3353 2 3354 53 3355 49 3356 0 3357 1 3358 56 3359 0 3360 0 3361 1 3362 48 3363 0 3364 0 3365 2 3366 53 3367 54 3368 0 3369 2 3370 52 3371 56 3372 0 3373 2 3374 53 3375 50 3376 0 3377 2 3378 53 3379 53 3380 0 3381 2 3382 53 3383 51 3384 0 3385 2 3386 52 3387 57 3388 0
57/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
3389 2 3390 53 3391 51 3392 0 3393 2 3394 53 3395 49 3396 0 3397 1 3398 56 3399 0 3400 0 3401 1 3402 48 3403 0 3404 0 3405 2 3406 52 3407 56 3408 0 3409 2 3410 53 3411 50 3412 0 3413 2 3414 53 3415 50 3416 0 3417 2 3418 53 3419 53 3420 0 3421 2 3422 53 3423 51 3424 0 3425 2 3426 52 3427 57 3428 0 3429 2 3430 53 3431 51 3432 0 3433 2 3434 53 3435 49 3436 0 3437 1 3438 56 3439 0 3440 0 3441 1 3442 48 3443 0 3444 0 3445 2 3446 53 3447 48 3448 0
58/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
3449 2 3450 53 3451 53 3452 0 3453 2 3454 53 3455 50 3456 0 3457 2 3458 53 3459 53 3460 0 3461 2 3462 53 3463 51 3464 0 3465 2 3466 52 3467 57 3468 0 3469 2 3470 53 3471 51 3472 0 3473 2 3474 53 3475 49 3476 0 3477 1 3478 56 3479 0 3480 0 3481 1 3482 48 3483 0 3484 0 3485 2 3486 53 3487 50 3488 0 3489 2 3490 52 3491 56 3492 0 3493 2 3494 53 3495 51 3496 0 3497 2 3498 53 3499 53 3500 0 3501 2 3502 53 3503 51 3504 0 3505 2 3506 52 3507 57 3508 0
59/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
3509 2 3510 53 3511 51 3512 0 3513 2 3514 53 3515 49 3516 0 3517 1 3518 56 3519 0 3520 0 3521 1 3522 48 3523 0 3524 0 3525 2 3526 53 3527 52 3528 0 3529 2 3530 53 3531 49 3532 0 3533 2 3534 53 3535 51 3536 0 3537 2 3538 53 3539 53 3540 0 3541 2 3542 53 3543 51 3544 0 3545 2 3546 52 3547 57 3548 0 3549 2 3550 53 3551 51 3552 0 3553 2 3554 53 3555 49 3556 0 3557 1 3558 56 3559 0 3560 0 3561 1 3562 48 3563 0 3564 0 3565 2 3566 53 3567 54 3568 0
60/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
3569 2 3570 53 3571 52 3572 0 3573 2 3574 53 3575 51 3576 0 3577 2 3578 53 3579 53 3580 0 3581 2 3582 53 3583 51 3584 0 3585 2 3586 52 3587 57 3588 0 3589 2 3590 53 3591 51 3592 0 3593 2 3594 53 3595 49 3596 0 3597 1 3598 50 3599 0 3600 0 3601 1 3602 48 3603 0 3604 0 3605 1 3606 48 3607 0 3608 0 3609 2 3610 52 3611 56 3612 0 3613 1 3614 49 3615 0 3616 0 3617 1 3618 48 3619 0 3620 0 3621 1 3622 48 3623 0 3624 0 3625 2 3626 52 3627 56 3628 0
61/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
3629 1 3630 49 3631 0 3632 0 3633 1 3634 48 3635 0 3636 0 3637 1 3638 48 3639 0 3640 0 3641 2 3642 52 3643 57 3644 0 3645 1 3646 49 3647 0 3648 0 3649 1 3650 48 3651 0 3652 0 3653 2 3654 53 3655 54 3656 0 3657 2 3658 53 3659 50 3660 0 3661 1 3662 50 3663 0 3664 0 3665 1 3666 48 3667 0 3668 0 3669 1 3670 48 3671 0 3672 0 3673 2 3674 52 3675 56 3676 0 3677 1 3678 49 3679 0 3680 0 3681 1 3682 48 3683 0 3684 0 3685 1 3686 48 3687 0 3688 0
62/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
3689 2 3690 52 3691 56 3692 0 3693 1 3694 49 3695 0 3696 0 3697 1 3698 48 3699 0 3700 0 3701 1 3702 48 3703 0 3704 0 3705 1 3706 48 3707 0 3708 0 3709 2 3710 53 3711 50 3712 0 3713 2 3714 53 3715 52 3716 0 3717 2 3718 53 3719 54 3720 0 3721 2 3722 53 3723 52 3724 0 3725 2 3726 53 3727 51 3728 0 3729 2 3730 52 3731 57 3732 0 3733 2 3734 53 3735 51 3736 0 3737 2 3738 53 3739 49 3740 0 3741 1 3742 56 3743 0 3744 0 3745 1 3746 48 3747 0 3748 0
63/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
3749 2 3750 53 3751 52 3752 0 3753 2 3754 53 3755 55 3756 0 3757 2 3758 53 3759 54 3760 0 3761 2 3762 53 3763 52 3764 0 3765 2 3766 53 3767 51 3768 0 3769 2 3770 52 3771 57 3772 0 3773 2 3774 53 3775 51 3776 0 3777 2 3778 53 3779 49 3780 0 3781 1 3782 56 3783 0 3784 0 3785 1 3786 48 3787 0 3788 0 3789 2 3790 53 3791 54 3792 0 3793 2 3794 53 3795 48 3796 0 3797 2 3798 53 3799 55 3800 0 3801 2 3802 53 3803 52 3804 0 3805 2 3806 53 3807 51 3808 0
64/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
3809 2 3810 52 3811 57 3812 0 3813 2 3814 53 3815 51 3816 0 3817 2 3818 53 3819 49 3820 0 3821 1 3822 56 3823 0 3824 0 3825 1 3826 48 3827 0 3828 0 3829 2 3830 52 3831 56 3832 0 3833 2 3834 53 3835 52 3836 0 3837 2 3838 53 3839 55 3840 0 3841 2 3842 53 3843 52 3844 0 3845 2 3846 53 3847 51 3848 0 3849 2 3850 52 3851 57 3852 0 3853 2 3854 53 3855 51 3856 0 3857 2 3858 53 3859 49 3860 0 3861 1 3862 56 3863 0 3864 0 3865 1 3866 48 3867 0 3868 0
65/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
3869 2 3870 53 3871 48 3872 0 3873 2 3874 53 3875 55 3876 0 3877 2 3878 53 3879 55 3880 0 3881 2 3882 53 3883 52 3884 0 3885 2 3886 53 3887 51 3888 0 3889 2 3890 52 3891 57 3892 0 3893 2 3894 53 3895 51 3896 0 3897 2 3898 53 3899 49 3900 0 3901 1 3902 56 3903 0 3904 0 3905 1 3906 48 3907 0 3908 0 3909 2 3910 53 3911 50 3912 0 3913 2 3914 53 3915 48 3916 0 3917 2 3918 52 3919 56 3920 0 3921 2 3922 53 3923 53 3924 0 3925 2 3926 53 3927 51 3928 0
66/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
3929 2 3930 52 3931 57 3932 0 3933 2 3934 53 3935 51 3936 0 3937 2 3938 53 3939 49 3940 0 3941 1 3942 56 3943 0 3944 0 3945 1 3946 48 3947 0 3948 0 3949 2 3950 53 3951 52 3952 0 3953 2 3954 53 3955 51 3956 0 3957 2 3958 52 3959 56 3960 0 3961 2 3962 53 3963 53 3964 0 3965 2 3966 53 3967 51 3968 0 3969 2 3970 52 3971 57 3972 0 3973 2 3974 53 3975 51 3976 0 3977 2 3978 53 3979 49 3980 0 3981 1 3982 56 3983 0 3984 0 3985 1 3986 48 3987 0 3988 0
67/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
3989 2 3990 53 3991 54 3992 0 3993 2 3994 53 3995 54 3996 0 3997 2 3998 52 3999 56 4000 0 4001 2 4002 53 4003 53 4004 0 4005 2 4006 53 4007 51 4008 0 4009 2 4010 52 4011 57 4012 0 4013 2 4014 53 4015 51 4016 0 4017 2 4018 53 4019 49 4020 0 4021 1 4022 56 4023 0 4024 0 4025 1 4026 48 4027 0 4028 0 4029 2 4030 52 4031 56 4032 0 4033 2 4034 53 4035 48 4036 0 4037 2 4038 52 4039 57 4040 0 4041 2 4042 53 4043 53 4044 0 4045 2 4046 53 4047 51 4048 0
68/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
4049 2 4050 52 4051 57 4052 0 4053 2 4054 53 4055 51 4056 0 4057 2 4058 53 4059 49 4060 0 4061 1 4062 56 4063 0 4064 0 4065 1 4066 48 4067 0 4068 0 4069 2 4070 53 4071 48 4072 0 4073 2 4074 53 4075 51 4076 0 4077 2 4078 52 4079 57 4080 0 4081 2 4082 53 4083 53 4084 0 4085 2 4086 53 4087 51 4088 0 4089 2 4090 52 4091 57 4092 0 4093 2 4094 53 4095 51 4096 0 4097 2 4098 53 4099 49 4100 0 4101 1 4102 56 4103 0 4104 0 4105 1 4106 48 4107 0 4108 0
69/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
4109 1 4110 50 4111 0 4112 0 4113 1 4114 48 4115 0 4116 0 4117 1 4118 48 4119 0 4120 0 4121 2 4122 52 4123 56 4124 0 4125 1 4126 49 4127 0 4128 0 4129 1 4130 48 4131 0 4132 0 4133 1 4134 48 4135 0 4136 0 4137 2 4138 52 4139 56 4140 0 4141 1 4142 49 4143 0 4144 0 4145 1 4146 48 4147 0 4148 0 4149 1 4150 48 4151 0 4152 0 4153 2 4154 52 4155 57 4156 0 4157 1 4158 49 4159 0 4160 0 4161 1 4162 48 4163 0 4164 0 4165 2 4166 53 4167 54 4168 0
70/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
4169 2 4170 53 4171 50 4172 0 4173 1 4174 50 4175 0 4176 0 4177 1 4178 48 4179 0 4180 0 4181 1 4182 48 4183 0 4184 0 4185 2 4186 52 4187 56 4188 0 4189 1 4190 49 4191 0 4192 0 4193 1 4194 48 4195 0 4196 0 4197 1 4198 48 4199 0 4200 0 4201 2 4202 52 4203 56 4204 0 4205 1 4206 49 4207 0 4208 0 4209 1 4210 48 4211 0 4212 0 4213 1 4214 48 4215 0 4216 0 4217 2 4218 52 4219 57 4220 0 4221 1 4222 49 4223 0 4224 0 4225 1 4226 48 4227 0 4228 0
71/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
4229 2 4230 53 4231 54 4232 0 4233 2 4234 53 4235 50 4236 0 4237 1 4238 50 4239 0 4240 0 4241 1 4242 48 4243 0 4244 0 4245 1 4246 48 4247 0 4248 0 4249 2 4250 52 4251 56 4252 0 4253 1 4254 49 4255 0 4256 0 4257 1 4258 48 4259 0 4260 0 4261 1 4262 48 4263 0 4264 0 4265 2 4266 52 4267 56 4268 0 4269 1 4270 49 4271 0 4272 0 4273 1 4274 48 4275 0 4276 0 4277 1 4278 48 4279 0 4280 0 4281 2 4282 52 4283 57 4284 0 4285 1 4286 49 4287 0 4288 0
72/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
4289 1 4290 48 4291 0 4292 0 4293 2 4294 53 4295 54 4296 0 4297 2 4298 53 4299 50 4300 0 4301 1 4302 50 4303 0 4304 0 4305 1 4306 48 4307 0 4308 0 4309 1 4310 48 4311 0 4312 0 4313 2 4314 52 4315 56 4316 0 4317 1 4318 49 4319 0 4320 0 4321 1 4322 48 4323 0 4324 0 4325 1 4326 48 4327 0 4328 0 4329 2 4330 52 4331 56 4332 0 4333 1 4334 49 4335 0 4336 0 4337 1 4338 48 4339 0 4340 0 4341 1 4342 48 4343 0 4344 0 4345 2 4346 52 4347 57 4348 0
73/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
4349 1 4350 49 4351 0 4352 0 4353 1 4354 48 4355 0 4356 0 4357 2 4358 53 4359 54 4360 0 4361 2 4362 53 4363 50 4364 0 4365 1 4366 50 4367 0 4368 0 4369 1 4370 48 4371 0 4372 0 4373 1 4374 48 4375 0 4376 0 4377 2 4378 52 4379 56 4380 0 4381 1 4382 49 4383 0 4384 0 4385 1 4386 48 4387 0 4388 0 4389 1 4390 48 4391 0 4392 0 4393 2 4394 52 4395 56 4396 0 4397 1 4398 49 4399 0 4400 0 4401 1 4402 48 4403 0 4404 0 4405 1 4406 48 4407 0 4408 0
74/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
4409 2 4410 52 4411 57 4412 0 4413 1 4414 49 4415 0 4416 0 4417 1 4418 48 4419 0 4420 0 4421 2 4422 53 4423 54 4424 0 4425 2 4426 53 4427 50 4428 0 4429 1 4430 50 4431 0 4432 0 4433 1 4434 48 4435 0 4436 0 4437 1 4438 48 4439 0 4440 0 4441 2 4442 52 4443 56 4444 0 4445 1 4446 49 4447 0 4448 0 4449 1 4450 48 4451 0 4452 0 4453 1 4454 48 4455 0 4456 0 4457 2 4458 52 4459 56 4460 0 4461 1 4462 49 4463 0 4464 0 4465 1 4466 48 4467 0 4468 0
75/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
4469 1 4470 48 4471 0 4472 0 4473 2 4474 52 4475 57 4476 0 4477 1 4478 49 4479 0 4480 0 4481 1 4482 48 4483 0 4484 0 4485 2 4486 53 4487 54 4488 0 4489 2 4490 53 4491 50 4492 0 4493 1 4494 50 4495 0 4496 0 4497 1 4498 48 4499 0 4500 0 4501 1 4502 48 4503 0 4504 0 4505 2 4506 52 4507 56 4508 0 4509 1 4510 49 4511 0 4512 0 4513 1 4514 48 4515 0 4516 0 4517 1 4518 48 4519 0 4520 0 4521 2 4522 52 4523 56 4524 0 4525 1 4526 49 4527 0 4528 0
76/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
4529 1 4530 48 4531 0 4532 0 4533 1 4534 48 4535 0 4536 0 4537 2 4538 52 4539 57 4540 0 4541 1 4542 49 4543 0 4544 0 4545 1 4546 48 4547 0 4548 0 4549 2 4550 53 4551 54 4552 0 4553 2 4554 53 4555 50 4556 0 4557 1 4558 50 4559 0 4560 0 4561 1 4562 48 4563 0 4564 0 4565 1 4566 48 4567 0 4568 0 4569 2 4570 52 4571 56 4572 0 4573 1 4574 49 4575 0 4576 0 4577 1 4578 48 4579 0 4580 0 4581 1 4582 48 4583 0 4584 0 4585 2 4586 52 4587 56 4588 0
77/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
4589 1 4590 49 4591 0 4592 0 4593 1 4594 48 4595 0 4596 0 4597 1 4598 48 4599 0 4600 0 4601 2 4602 52 4603 57 4604 0 4605 1 4606 49 4607 0 4608 0 4609 1 4610 48 4611 0 4612 0 4613 2 4614 53 4615 54 4616 0 4617 2 4618 53 4619 50 4620 0 4621 1 4622 50 4623 0 4624 0 4625 1 4626 48 4627 0 4628 0 4629 1 4630 48 4631 0 4632 0 4633 2 4634 52 4635 56 4636 0 4637 1 4638 49 4639 0 4640 0 4641 1 4642 48 4643 0 4644 0 4645 1 4646 48 4647 0 4648 0
78/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
4649 2 4650 52 4651 56 4652 0 4653 1 4654 49 4655 0 4656 0 4657 1 4658 48 4659 0 4660 0 4661 1 4662 48 4663 0 4664 0 4665 2 4666 52 4667 57 4668 0 4669 1 4670 49 4671 0 4672 0 4673 1 4674 48 4675 0 4676 0 4677 2 4678 53 4679 54 4680 0 4681 2 4682 53 4683 50 4684 0 4685 1 4686 50 4687 0 4688 0 4689 1 4690 48 4691 0 4692 0 4693 1 4694 48 4695 0 4696 0 4697 2 4698 52 4699 56 4700 0 4701 1 4702 49 4703 0 4704 0 4705 1 4706 48 4707 0 4708 0
79/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
4709 1 4710 48 4711 0 4712 0 4713 2 4714 52 4715 56 4716 0 4717 1 4718 49 4719 0 4720 0 4721 1 4722 48 4723 0 4724 0 4725 1 4726 48 4727 0 4728 0 4729 2 4730 52 4731 57 4732 0 4733 1 4734 49 4735 0 4736 0 4737 1 4738 48 4739 0 4740 0 4741 2 4742 53 4743 54 4744 0 4745 2 4746 53 4747 50 4748 0 4749 1 4750 50 4751 0 4752 0 4753 1 4754 48 4755 0 4756 0 4757 1 4758 48 4759 0 4760 0 4761 2 4762 52 4763 56 4764 0 4765 1 4766 49 4767 0 4768 0
80/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
4769 1 4770 48 4771 0 4772 0 4773 1 4774 48 4775 0 4776 0 4777 2 4778 52 4779 56 4780 0 4781 1 4782 49 4783 0 4784 0 4785 1 4786 48 4787 0 4788 0 4789 1 4790 48 4791 0 4792 0 4793 2 4794 52 4795 57 4796 0 4797 1 4798 49 4799 0 4800 0 4801 1 4802 48 4803 0 4804 0 4805 2 4806 53 4807 54 4808 0 4809 2 4810 53 4811 50 4812 0 4813 1 4814 50 4815 0 4816 0 4817 1 4818 48 4819 0 4820 0 4821 1 4822 48 4823 0 4824 0 4825 2 4826 52 4827 56 4828 0
81/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
4829 1 4830 49 4831 0 4832 0 4833 1 4834 48 4835 0 4836 0 4837 1 4838 48 4839 0 4840 0 4841 2 4842 52 4843 56 4844 0 4845 1 4846 49 4847 0 4848 0 4849 1 4850 48 4851 0 4852 0 4853 1 4854 48 4855 0 4856 0 4857 2 4858 52 4859 57 4860 0 4861 1 4862 49 4863 0 4864 0 4865 1 4866 48 4867 0 4868 0 4869 2 4870 53 4871 54 4872 0 4873 2 4874 53 4875 50 4876 0 4877 1 4878 50 4879 0 4880 0 4881 1 4882 48 4883 0 4884 0 4885 1 4886 48 4887 0 4888 0
82/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
4889 2 4890 52 4891 56 4892 0 4893 1 4894 49 4895 0 4896 0 4897 1 4898 48 4899 0 4900 0 4901 1 4902 48 4903 0 4904 0 4905 2 4906 52 4907 56 4908 0 4909 1 4910 49 4911 0 4912 0 4913 1 4914 48 4915 0 4916 0 4917 1 4918 48 4919 0 4920 0 4921 2 4922 52 4923 57 4924 0 4925 1 4926 49 4927 0 4928 0 4929 1 4930 48 4931 0 4932 0 4933 2 4934 53 4935 54 4936 0 4937 2 4938 53 4939 50 4940 0 4941 1 4942 50 4943 0 4944 0 4945 1 4946 48 4947 0 4948 0
83/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
4949 1 4950 48 4951 0 4952 0 4953 2 4954 52 4955 56 4956 0 4957 1 4958 49 4959 0 4960 0 4961 1 4962 48 4963 0 4964 0 4965 1 4966 48 4967 0 4968 0 4969 2 4970 52 4971 56 4972 0 4973 1 4974 49 4975 0 4976 0 4977 1 4978 48 4979 0 4980 0 4981 1 4982 48 4983 0 4984 0 4985 2 4986 52 4987 57 4988 0 4989 1 4990 49 4991 0 4992 0 4993 1 4994 48 4995 0 4996 0 4997 2 4998 53 4999 54 5000 0 5001 2 5002 53 5003 50 5004 0 5005 1 5006 50 5007 0 5008 0
84/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
5009 1 5010 48 5011 0 5012 0 5013 1 5014 48 5015 0 5016 0 5017 2 5018 52 5019 56 5020 0 5021 1 5022 49 5023 0 5024 0 5025 1 5026 48 5027 0 5028 0 5029 1 5030 48 5031 0 5032 0 5033 2 5034 52 5035 56 5036 0 5037 1 5038 49 5039 0 5040 0 5041 1 5042 48 5043 0 5044 0 5045 1 5046 48 5047 0 5048 0 5049 2 5050 52 5051 57 5052 0 5053 1 5054 49 5055 0 5056 0 5057 1 5058 48 5059 0 5060 0 5061 2 5062 53 5063 54 5064 0 5065 2 5066 53 5067 50 5068 0
85/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
5069 1 5070 50 5071 0 5072 0 5073 1 5074 48 5075 0 5076 0 5077 1 5078 48 5079 0 5080 0 5081 2 5082 52 5083 56 5084 0 5085 1 5086 49 5087 0 5088 0 5089 1 5090 48 5091 0 5092 0 5093 1 5094 48 5095 0 5096 0 5097 2 5098 52 5099 56 5100 0 5101 1 5102 49 5103 0 5104 0 5105 1 5106 48 5107 0 5108 0 5109 1 5110 48 5111 0 5112 0 5113 2 5114 52 5115 57 5116 0 5117 1 5118 49 5119 0 5120 0 5121 1 5122 48 5123 0 5124 0 5125 2 5126 53 5127 54 5128 0
86/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
5129 2 5130 53 5131 50 5132 0 5133 1 5134 50 5135 0 5136 0 5137 1 5138 48 5139 0 5140 0 5141 1 5142 48 5143 0 5144 0 5145 2 5146 52 5147 56 5148 0 5149 1 5150 49 5151 0 5152 0 5153 1 5154 48 5155 0 5156 0 5157 1 5158 48 5159 0 5160 0 5161 2 5162 52 5163 56 5164 0 5165 1 5166 49 5167 0 5168 0 5169 1 5170 48 5171 0 5172 0 5173 1 5174 48 5175 0 5176 0 5177 2 5178 52 5179 57 5180 0 5181 1 5182 49 5183 0 5184 0 5185 1 5186 48 5187 0 5188 0
87/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
5189 2 5190 53 5191 54 5192 0 5193 2 5194 53 5195 50 5196 0 5197 1 5198 50 5199 0 5200 0 5201 1 5202 48 5203 0 5204 0 5205 1 5206 48 5207 0 5208 0 5209 2 5210 52 5211 56 5212 0 5213 1 5214 49 5215 0 5216 0 5217 1 5218 48 5219 0 5220 0 5221 1 5222 48 5223 0 5224 0 5225 2 5226 52 5227 56 5228 0 5229 1 5230 49 5231 0 5232 0 5233 1 5234 48 5235 0 5236 0 5237 1 5238 48 5239 0 5240 0 5241 2 5242 52 5243 57 5244 0 5245 1 5246 49 5247 0 5248 0
88/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
5249 1 5250 48 5251 0 5252 0 5253 2 5254 53 5255 54 5256 0 5257 2 5258 53 5259 50 5260 0 5261 1 5262 50 5263 0 5264 0 5265 1 5266 48 5267 0 5268 0 5269 1 5270 48 5271 0 5272 0 5273 2 5274 52 5275 56 5276 0 5277 1 5278 49 5279 0 5280 0 5281 1 5282 48 5283 0 5284 0 5285 1 5286 48 5287 0 5288 0 5289 2 5290 52 5291 56 5292 0 5293 1 5294 49 5295 0 5296 0 5297 1 5298 48 5299 0 5300 0 5301 1 5302 48 5303 0 5304 0 5305 2 5306 52 5307 57 5308 0
89/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
5309 1 5310 49 5311 0 5312 0 5313 1 5314 48 5315 0 5316 0 5317 2 5318 53 5319 54 5320 0 5321 2 5322 53 5323 50 5324 0 5325 1 5326 50 5327 0 5328 0 5329 1 5330 48 5331 0 5332 0 5333 1 5334 48 5335 0 5336 0 5337 2 5338 52 5339 56 5340 0 5341 1 5342 49 5343 0 5344 0 5345 1 5346 48 5347 0 5348 0 5349 1 5350 48 5351 0 5352 0 5353 2 5354 52 5355 56 5356 0 5357 1 5358 49 5359 0 5360 0 5361 1 5362 48 5363 0 5364 0 5365 1 5366 48 5367 0 5368 0
90/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
5369 2 5370 52 5371 57 5372 0 5373 1 5374 49 5375 0 5376 0 5377 1 5378 48 5379 0 5380 0 5381 2 5382 53 5383 54 5384 0 5385 2 5386 53 5387 50 5388 0 5389 1 5390 50 5391 0 5392 0 5393 1 5394 48 5395 0 5396 0 5397 1 5398 48 5399 0 5400 0 5401 2 5402 52 5403 56 5404 0 5405 1 5406 49 5407 0 5408 0 5409 1 5410 48 5411 0 5412 0 5413 1 5414 48 5415 0 5416 0 5417 2 5418 52 5419 56 5420 0 5421 1 5422 49 5423 0 5424 0 5425 1 5426 48 5427 0 5428 0
91/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
5429 1 5430 48 5431 0 5432 0 5433 2 5434 52 5435 57 5436 0 5437 1 5438 49 5439 0 5440 0 5441 1 5442 48 5443 0 5444 0 5445 2 5446 53 5447 54 5448 0 5449 2 5450 53 5451 50 5452 0 5453 1 5454 50 5455 0 5456 0 5457 1 5458 48 5459 0 5460 0 5461 1 5462 48 5463 0 5464 0 5465 2 5466 52 5467 56 5468 0 5469 1 5470 49 5471 0 5472 0 5473 1 5474 48 5475 0 5476 0 5477 1 5478 48 5479 0 5480 0 5481 2 5482 52 5483 56 5484 0 5485 1 5486 49 5487 0 5488 0
92/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
5489 1 5490 48 5491 0 5492 0 5493 1 5494 48 5495 0 5496 0 5497 2 5498 52 5499 57 5500 0 5501 1 5502 49 5503 0 5504 0 5505 1 5506 48 5507 0 5508 0 5509 2 5510 53 5511 54 5512 0 5513 2 5514 53 5515 50 5516 0 5517 1 5518 50 5519 0 5520 0 5521 1 5522 48 5523 0 5524 0 5525 1 5526 48 5527 0 5528 0 5529 2 5530 52 5531 56 5532 0 5533 1 5534 49 5535 0 5536 0 5537 1 5538 48 5539 0 5540 0 5541 1 5542 48 5543 0 5544 0 5545 2 5546 52 5547 56 5548 0
93/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
5549 1 5550 49 5551 0 5552 0 5553 1 5554 48 5555 0 5556 0 5557 1 5558 48 5559 0 5560 0 5561 2 5562 52 5563 57 5564 0 5565 1 5566 49 5567 0 5568 0 5569 1 5570 48 5571 0 5572 0 5573 2 5574 53 5575 54 5576 0 5577 2 5578 53 5579 50 5580 0 5581 1 5582 50 5583 0 5584 0 5585 1 5586 48 5587 0 5588 0 5589 1 5590 48 5591 0 5592 0 5593 2 5594 52 5595 56 5596 0 5597 1 5598 49 5599 0 5600 0 5601 1 5602 48 5603 0 5604 0 5605 1 5606 48 5607 0 5608 0
94/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
5609 2 5610 52 5611 56 5612 0 5613 1 5614 49 5615 0 5616 0 5617 1 5618 48 5619 0 5620 0 5621 1 5622 48 5623 0 5624 0 5625 2 5626 52 5627 57 5628 0 5629 1 5630 49 5631 0 5632 0 5633 1 5634 48 5635 0 5636 0 5637 2 5638 53 5639 54 5640 0 5641 2 5642 53 5643 50 5644 0 5645 1 5646 49 5647 0 5648 0 5649 1 5650 48 5651 0 5652 0 5653 1 5654 48 5655 0 5656 0 5657 2 5658 52 5659 56 5660 0 5661 1 5662 49 5663 0 5664 0 5665 1 5666 48 5667 0 5668 0
95/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
5669 1 5670 48 5671 0 5672 0 5673 2 5674 52 5675 56 5676 0 5677 1 5678 49 5679 0 5680 0 5681 1 5682 48 5683 0 5684 0 5685 1 5686 48 5687 0 5688 0 5689 2 5690 52 5691 56 5692 0 5693 1 5694 49 5695 0 5696 0 5697 1 5698 48 5699 0 5700 0 5701 1 5702 48 5703 0 5704 0 5705 2 5706 52 5707 56 5708 0 5709 1 5710 49 5711 0 5712 0 5713 1 5714 48 5715 0 5716 0 5717 1 5718 48 5719 0 5720 0 5721 2 5722 52 5723 56 5724 0 5725 1 5726 49 5727 0 5728 0
96/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
5729 1 5730 48 5731 0 5732 0 5733 1 5734 48 5735 0 5736 0 5737 2 5738 52 5739 56 5740 0 5741 1 5742 49 5743 0 5744 0 5745 1 5746 48 5747 0 5748 0 5749 1 5750 48 5751 0 5752 0 5753 2 5754 52 5755 57 5756 0 5757 1 5758 49 5759 0 5760 0 5761 1 5762 48 5763 0 5764 0 5765 2 5766 53 5767 54 5768 0 5769 2 5770 53 5771 50 5772 0 5773 1 5774 50 5775 0 5776 0 5777 1 5778 48 5779 0 5780 0 5781 1 5782 48 5783 0 5784 0 5785 2 5786 52 5787 56 5788 0
97/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
5789 1 5790 49 5791 0 5792 0 5793 1 5794 48 5795 0 5796 0 5797 1 5798 48 5799 0 5800 0 5801 2 5802 52 5803 56 5804 0 5805 1 5806 49 5807 0 5808 0 5809 1 5810 48 5811 0 5812 0 5813 1 5814 48 5815 0 5816 0 5817 2 5818 52 5819 57 5820 0 5821 1 5822 49 5823 0 5824 0 5825 1 5826 48 5827 0 5828 0 5829 2 5830 53 5831 54 5832 0 5833 2 5834 53 5835 50 5836 0 5837 1 5838 50 5839 0 5840 0 5841 1 5842 48 5843 0 5844 0 5845 1 5846 48 5847 0 5848 0
98/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
5849 2 5850 52 5851 56 5852 0 5853 1 5854 49 5855 0 5856 0 5857 1 5858 48 5859 0 5860 0 5861 1 5862 48 5863 0 5864 0 5865 2 5866 52 5867 56 5868 0 5869 1 5870 49 5871 0 5872 0 5873 1 5874 48 5875 0 5876 0 5877 1 5878 48 5879 0 5880 0 5881 2 5882 52 5883 57 5884 0 5885 1 5886 49 5887 0 5888 0 5889 1 5890 48 5891 0 5892 0 5893 2 5894 53 5895 54 5896 0 5897 2 5898 53 5899 50 5900 0 5901 1 5902 50 5903 0 5904 0 5905 1 5906 48 5907 0 5908 0
99/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
5909 1 5910 48 5911 0 5912 0 5913 2 5914 52 5915 56 5916 0 5917 1 5918 49 5919 0 5920 0 5921 1 5922 48 5923 0 5924 0 5925 1 5926 48 5927 0 5928 0 5929 2 5930 52 5931 56 5932 0 5933 1 5934 49 5935 0 5936 0 5937 1 5938 48 5939 0 5940 0 5941 1 5942 48 5943 0 5944 0 5945 2 5946 52 5947 57 5948 0 5949 1 5950 49 5951 0 5952 0 5953 1 5954 48 5955 0 5956 0 5957 2 5958 53 5959 54 5960 0 5961 2 5962 53 5963 50 5964 0 5965 1 5966 50 5967 0 5968 0
100/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
5969 1 5970 48 5971 0 5972 0 5973 1 5974 48 5975 0 5976 0 5977 2 5978 52 5979 56 5980 0 5981 1 5982 49 5983 0 5984 0 5985 1 5986 48 5987 0 5988 0 5989 1 5990 48 5991 0 5992 0 5993 2 5994 52 5995 56 5996 0 5997 1 5998 49 5999 0 6000 0 6001 1 6002 48 6003 0 6004 0 6005 1 6006 48 6007 0 6008 0 6009 2 6010 52 6011 57 6012 0 6013 1 6014 49 6015 0 6016 0 6017 1 6018 48 6019 0 6020 0 6021 2 6022 53 6023 54 6024 0 6025 2 6026 53 6027 50 6028 0
101/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
6029 1 6030 50 6031 0 6032 0 6033 1 6034 48 6035 0 6036 0 6037 1 6038 48 6039 0 6040 0 6041 2 6042 52 6043 56 6044 0 6045 1 6046 49 6047 0 6048 0 6049 1 6050 48 6051 0 6052 0 6053 1 6054 48 6055 0 6056 0 6057 2 6058 52 6059 56 6060 0 6061 1 6062 49 6063 0 6064 0 6065 1 6066 48 6067 0 6068 0 6069 1 6070 48 6071 0 6072 0 6073 2 6074 52 6075 57 6076 0 6077 1 6078 49 6079 0 6080 0 6081 1 6082 48 6083 0 6084 0 6085 2 6086 53 6087 54 6088 0
102/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
6089 2 6090 53 6091 50 6092 0 6093 1 6094 50 6095 0 6096 0 6097 1 6098 48 6099 0 6100 0 6101 1 6102 48 6103 0 6104 0 6105 2 6106 52 6107 56 6108 0 6109 1 6110 49 6111 0 6112 0 6113 1 6114 48 6115 0 6116 0 6117 1 6118 48 6119 0 6120 0 6121 2 6122 52 6123 56 6124 0 6125 1 6126 49 6127 0 6128 0 6129 1 6130 48 6131 0 6132 0 6133 1 6134 48 6135 0 6136 0 6137 2 6138 52 6139 57 6140 0 6141 1 6142 49 6143 0 6144 0 6145 1 6146 48 6147 0 6148 0
103/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
6149 2 6150 53 6151 54 6152 0 6153 2 6154 53 6155 50 6156 0 6157 0 6158 0 6159 0 6160 0 6161 0 6162 0 6163 0 6164 0 6165 0 6166 0 6167 0 6168 0 6169 0 6170 0 6171 0 6172 0 6173 0 6174 0 6175 0 6176 0 6177 0 6178 0 6179 0 6180 0 6181 0 6182 0 6183 0 6184 0 6185 0 6186 0 6187 0 6188 0 6189 0 6190 0 6191 0 6192 0 6193 0 6194 0 6195 0 6196 0 6197 0 6198 0 6199 0 6200 0 6201 0 6202 0 6203 0 6204 0 6205 0 6206 0 6207 0 6208 0
104/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
6209 0 6210 0 6211 0 6212 0 6213 0 6214 0 6215 0 6216 0 6217 0 6218 0 6219 0 6220 0 6221 0 6222 0 6223 0 6224 0 6225 0 6226 0 6227 0 6228 0 6229 0 6230 0 6231 0 6232 0 6233 0 6234 0 6235 0 6236 0 6237 0 6238 0 6239 0 6240 0 6241 0 6242 0 6243 0 6244 0 6245 0 6246 0 6247 0 6248 0 6249 0 6250 0 6251 0 6252 0 6253 0 6254 0 6255 0 6256 0 6257 0 6258 0 6259 0 6260 0 6261 0 6262 0 6263 0 6264 0 6265 0 6266 0 6267 0 6268 0
105/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
6269 0 6270 0 6271 0 6272 0 6273 0 6274 0 6275 0 6276 0 6277 0 6278 0 6279 0 6280 0 6281 0 6282 0 6283 0 6284 0 6285 0 6286 0 6287 0 6288 0 6289 0 6290 0 6291 0 6292 0 6293 0 6294 0 6295 0 6296 0 6297 0 6298 0 6299 0 6300 0 6301 0 6302 0 6303 0 6304 0 6305 0 6306 0 6307 0 6308 0 6309 0 6310 0 6311 0 6312 0 6313 0 6314 0 6315 0 6316 0 6317 0 6318 0 6319 0 6320 0 6321 0 6322 0 6323 0 6324 0 6325 0 6326 0 6327 0 6328 0
106/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
6329 0 6330 0 6331 0 6332 0 6333 0 6334 0 6335 0 6336 0 6337 0 6338 0 6339 0 6340 0 6341 0 6342 0 6343 0 6344 0 6345 0 6346 0 6347 0 6348 0 6349 0 6350 0 6351 0 6352 0 6353 0 6354 0 6355 0 6356 0 6357 0 6358 0 6359 0 6360 0 6361 0 6362 0 6363 0 6364 0 6365 0 6366 0 6367 0 6368 0 6369 0 6370 0 6371 0 6372 0 6373 0 6374 0 6375 0 6376 0 6377 0 6378 0 6379 0 6380 0 6381 0 6382 0 6383 0 6384 0 6385 0 6386 0 6387 0 6388 0
107/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
6389 0 6390 0 6391 0 6392 0 6393 0 6394 0 6395 0 6396 0 6397 0 6398 0 6399 0 6400 0 6401 0 6402 0 6403 0 6404 0 6405 0 6406 0 6407 0 6408 0 6409 0 6410 0 6411 0 6412 0 6413 0 6414 0 6415 0 6416 0 6417 0 6418 0 6419 0 6420 0 6421 0 6422 0 6423 0 6424 0 6425 0 6426 0 6427 0 6428 0 6429 0 6430 0 6431 0 6432 0 6433 0 6434 0 6435 0 6436 0 6437 0 6438 0 6439 0 6440 0 6441 0 6442 0 6443 0 6444 0 6445 0 6446 0 6447 0 6448 0
108/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
6449 0 6450 0 6451 0 6452 0 6453 0 6454 0 6455 0 6456 0 6457 0 6458 0 6459 0 6460 0 6461 0 6462 0 6463 0 6464 0 6465 0 6466 0 6467 0 6468 0 6469 0 6470 0 6471 0 6472 0 6473 0 6474 0 6475 0 6476 0 6477 0 6478 0 6479 0 6480 0 6481 0 6482 0 6483 0 6484 0 6485 0 6486 0 6487 0 6488 0 6489 0 6490 0 6491 0 6492 0 6493 0 6494 0 6495 0 6496 0 6497 0 6498 0 6499 0 6500 0 6501 0 6502 0 6503 0 6504 0 6505 0 6506 0 6507 0 6508 0
109/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
6509 0 6510 0 6511 0 6512 0 6513 0 6514 0 6515 0 6516 0 6517 0 6518 0 6519 0 6520 0 6521 0 6522 0 6523 0 6524 0 6525 0 6526 0 6527 0 6528 0 6529 0 6530 0 6531 0 6532 0 6533 0 6534 0 6535 0 6536 0 6537 0 6538 0 6539 0 6540 0 6541 0 6542 0 6543 0 6544 0 6545 0 6546 0 6547 0 6548 0 6549 0 6550 0 6551 0 6552 0 6553 0 6554 0 6555 0 6556 0 6557 0 6558 0 6559 0 6560 0 6561 0 6562 0 6563 0 6564 0 6565 0 6566 0 6567 0 6568 0
110/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
6569 0 6570 0 6571 0 6572 0 6573 0 6574 0 6575 0 6576 0 6577 0 6578 0 6579 0 6580 0 6581 0 6582 0 6583 0 6584 0 6585 0 6586 0 6587 0 6588 0 6589 0 6590 0 6591 0 6592 0 6593 0 6594 0 6595 0 6596 0 6597 0 6598 0 6599 0 6600 0 6601 0 6602 0 6603 0 6604 0 6605 0 6606 0 6607 0 6608 0 6609 0 6610 0 6611 0 6612 0 6613 0 6614 0 6615 0 6616 0 6617 0 6618 0 6619 0 6620 0 6621 0 6622 0 6623 0 6624 0 6625 0 6626 0 6627 0 6628 0
111/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
6629 0 6630 0 6631 0 6632 0 6633 0 6634 0 6635 0 6636 0 6637 0 6638 0 6639 0 6640 0 6641 0 6642 0 6643 0 6644 0 6645 0 6646 0 6647 0 6648 0 6649 0 6650 0 6651 0 6652 0 6653 0 6654 0 6655 0 6656 0 6657 0 6658 0 6659 0 6660 0 6661 0 6662 0 6663 0 6664 0 6665 0 6666 0 6667 0 6668 0 6669 2 6670 53 6671 51 6672 0 6673 0 6674 0 6675 1 6676 50 6677 0 6678 0 6679 0 6680 0 6681 1 6682 48 6683 0 6684 0 6685 0 6686 0 6687 2 6688 52
112/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
6689 56 6690 0 6691 0 6692 0 6693 2 6694 53 6695 51 6696 0 6697 0 6698 0 6699 1 6700 50 6701 0 6702 0 6703 0 6704 0 6705 1 6706 48 6707 0 6708 0 6709 0 6710 0 6711 1 6712 48 6713 0 6714 0 6715 0 6716 0 6717 2 6718 52 6719 56 6720 0 6721 0 6722 0 6723 1 6724 49 6725 0 6726 0 6727 0 6728 0 6729 1 6730 48 6731 0 6732 0 6733 0 6734 0 6735 1 6736 48 6737 0 6738 0 6739 0 6740 0 6741 2 6742 53 6743 54 6744 0 6745 0 6746 0 6747 1 6748 49
113/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
6749 0 6750 0 6751 0 6752 0 6753 1 6754 48 6755 0 6756 0 6757 0 6758 0 6759 2 6760 52 6761 57 6762 0 6763 0 6764 0 6765 2 6766 53 6767 51 6768 0 6769 0 6770 0 6771 1 6772 50 6773 0 6774 0 6775 0 6776 0 6777 1 6778 48 6779 0 6780 0 6781 0 6782 0 6783 2 6784 53 6785 49 6786 0 6787 0 6788 0 6789 2 6790 53 6791 51 6792 0 6793 0 6794 0 6795 1 6796 50 6797 0 6798 0 6799 0 6800 0 6801 1 6802 48 6803 0 6804 0 6805 0 6806 0 6807 2 6808 53
114/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
6809 55 6810 0 6811 0 6812 0 6813 2 6814 53 6815 50 6816 0 6817 0 6818 0 6819 1 6820 50 6821 0 6822 0 6823 0 6824 0 6825 1 6826 48 6827 0 6828 0 6829 0 6830 0 6831 2 6832 53 6833 49 6834 0 6835 0 6836 0 6837 2 6838 53 6839 51 6840 0 6841 0 6842 0 6843 1 6844 50 6845 0 6846 0 6847 0 6848 0 6849 1 6850 48 6851 0 6852 0 6853 0 6854 0 6855 2 6856 53 6857 51 6858 0 6859 0 6860 0 6861 2 6862 53 6863 51 6864 0 6865 0 6866 0 6867 1 6868 50
115/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
6869 0 6870 0 6871 0 6872 0 6873 1 6874 48 6875 0 6876 0 6877 0 6878 0 6879 2 6880 53 6881 48 6882 0 6883 0 6884 0 6885 2 6886 53 6887 51 6888 0 6889 0 6890 0 6891 1 6892 50 6893 0 6894 0 6895 0 6896 0 6897 1 6898 48 6899 0 6900 0 6901 0 6902 0 6903 2 6904 53 6905 48 6906 0 6907 0 6908 0 6909 2 6910 53 6911 51 6912 0 6913 0 6914 0 6915 1 6916 50 6917 0 6918 0 6919 0 6920 0 6921 1 6922 48 6923 0 6924 0 6925 0 6926 0 6927 2 6928 53
116/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
6929 54 6930 0 6931 0 6932 0 6933 2 6934 53 6935 50 6936 0 6937 0 6938 0 6939 1 6940 50 6941 0 6942 0 6943 0 6944 0 6945 1 6946 48 6947 0 6948 0 6949 0 6950 0 6951 1 6952 48 6953 0 6954 0 6955 0 6956 0 6957 2 6958 52 6959 56 6960 0 6961 0 6962 0 6963 1 6964 49 6965 0 6966 0 6967 0 6968 0 6969 1 6970 48 6971 0 6972 0 6973 0 6974 0 6975 1 6976 48 6977 0 6978 0 6979 0 6980 0 6981 2 6982 53 6983 54 6984 0 6985 0 6986 0 6987 1 6988 49
117/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
6989 0 6990 0 6991 0 6992 0 6993 1 6994 48 6995 0 6996 0 6997 0 6998 0 6999 2 7000 52 7001 57 7002 0 7003 0 7004 0 7005 2 7006 53 7007 51 7008 0 7009 0 7010 0 7011 1 7012 50 7013 0 7014 0 7015 0 7016 0 7017 1 7018 48 7019 0 7020 0 7021 0 7022 0 7023 2 7024 53 7025 49 7026 0 7027 0 7028 0 7029 2 7030 53 7031 51 7032 0 7033 0 7034 0 7035 1 7036 50 7037 0 7038 0 7039 0 7040 0 7041 1 7042 48 7043 0 7044 0 7045 0 7046 0 7047 2 7048 53
118/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
7049 55 7050 0 7051 0 7052 0 7053 2 7054 53 7055 50 7056 0 7057 0 7058 0 7059 1 7060 50 7061 0 7062 0 7063 0 7064 0 7065 1 7066 48 7067 0 7068 0 7069 0 7070 0 7071 2 7072 53 7073 49 7074 0 7075 0 7076 0 7077 2 7078 53 7079 51 7080 0 7081 0 7082 0 7083 1 7084 50 7085 0 7086 0 7087 0 7088 0 7089 1 7090 48 7091 0 7092 0 7093 0 7094 0 7095 2 7096 53 7097 51 7098 0 7099 0 7100 0 7101 2 7102 53 7103 51 7104 0 7105 0 7106 0 7107 1 7108 50
119/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
7109 0 7110 0 7111 0 7112 0 7113 1 7114 48 7115 0 7116 0 7117 0 7118 0 7119 2 7120 53 7121 48 7122 0 7123 0 7124 0 7125 2 7126 53 7127 51 7128 0 7129 0 7130 0 7131 1 7132 50 7133 0 7134 0 7135 0 7136 0 7137 1 7138 48 7139 0 7140 0 7141 0 7142 0 7143 2 7144 53 7145 54 7146 0 7147 0 7148 0 7149 2 7150 53 7151 50 7152 0 7153 0 7154 0 7155 1 7156 50 7157 0 7158 0 7159 0 7160 0 7161 1 7162 48 7163 0 7164 0 7165 0 7166 0 7167 2 7168 53
120/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
7169 52 7170 0 7171 0 7172 0 7173 2 7174 52 7175 56 7176 0 7177 0 7178 0 7179 0 7180 0 7181 2 7182 53 7183 50 7184 0 7185 1 7186 50 7187 0 7188 0 7189 1 7190 48 7191 0 7192 0 7193 1 7194 48 7195 0 7196 0 7197 2 7198 52 7199 56 7200 0 7201 1 7202 49 7203 0 7204 0 7205 1 7206 48 7207 0 7208 0 7209 1 7210 48 7211 0 7212 0 7213 2 7214 52 7215 56 7216 0 7217 1 7218 49 7219 0 7220 0 7221 1 7222 48 7223 0 7224 0 7225 1 7226 48 7227 0 7228 0
121/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
7229 2 7230 52 7231 57 7232 0 7233 1 7234 49 7235 0 7236 0 7237 1 7238 48 7239 0 7240 0 7241 2 7242 53 7243 54 7244 0 7245 2 7246 53 7247 50 7248 0 7249 1 7250 50 7251 0 7252 0 7253 1 7254 48 7255 0 7256 0 7257 1 7258 48 7259 0 7260 0 7261 2 7262 52 7263 56 7264 0 7265 1 7266 49 7267 0 7268 0 7269 1 7270 48 7271 0 7272 0 7273 1 7274 48 7275 0 7276 0 7277 2 7278 52 7279 56 7280 0 7281 1 7282 49 7283 0 7284 0 7285 1 7286 48 7287 0 7288 0
122/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
7289 1 7290 48 7291 0 7292 0 7293 2 7294 52 7295 57 7296 0 7297 1 7298 49 7299 0 7300 0 7301 1 7302 48 7303 0 7304 0 7305 2 7306 53 7307 54 7308 0 7309 2 7310 53 7311 50 7312 0 7313 1 7314 50 7315 0 7316 0 7317 1 7318 48 7319 0 7320 0 7321 1 7322 48 7323 0 7324 0 7325 2 7326 52 7327 56 7328 0 7329 1 7330 49 7331 0 7332 0 7333 1 7334 48 7335 0 7336 0 7337 1 7338 48 7339 0 7340 0 7341 2 7342 52 7343 56 7344 0 7345 1 7346 49 7347 0 7348 0
123/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
7349 1 7350 48 7351 0 7352 0 7353 1 7354 48 7355 0 7356 0 7357 2 7358 52 7359 57 7360 0 7361 1 7362 49 7363 0 7364 0 7365 1 7366 48 7367 0 7368 0 7369 2 7370 53 7371 54 7372 0 7373 2 7374 53 7375 50 7376 0 7377 1 7378 50 7379 0 7380 0 7381 1 7382 48 7383 0 7384 0 7385 1 7386 48 7387 0 7388 0 7389 2 7390 52 7391 56 7392 0 7393 1 7394 49 7395 0 7396 0 7397 1 7398 48 7399 0 7400 0 7401 1 7402 48 7403 0 7404 0 7405 2 7406 52 7407 56 7408 0
124/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
7409 1 7410 49 7411 0 7412 0 7413 1 7414 48 7415 0 7416 0 7417 1 7418 48 7419 0 7420 0 7421 2 7422 52 7423 57 7424 0 7425 1 7426 49 7427 0 7428 0 7429 1 7430 48 7431 0 7432 0 7433 2 7434 53 7435 54 7436 0 7437 2 7438 53 7439 50 7440 0 7441 1 7442 50 7443 0 7444 0 7445 1 7446 48 7447 0 7448 0 7449 1 7450 48 7451 0 7452 0 7453 2 7454 52 7455 56 7456 0 7457 1 7458 49 7459 0 7460 0 7461 1 7462 48 7463 0 7464 0 7465 1 7466 48 7467 0 7468 0
125/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
7469 2 7470 52 7471 56 7472 0 7473 1 7474 49 7475 0 7476 0 7477 1 7478 48 7479 0 7480 0 7481 1 7482 48 7483 0 7484 0 7485 2 7486 52 7487 57 7488 0 7489 1 7490 49 7491 0 7492 0 7493 1 7494 48 7495 0 7496 0 7497 2 7498 53 7499 54 7500 0 7501 2 7502 53 7503 50 7504 0 7505 1 7506 50 7507 0 7508 0 7509 1 7510 48 7511 0 7512 0 7513 1 7514 48 7515 0 7516 0 7517 2 7518 52 7519 56 7520 0 7521 1 7522 49 7523 0 7524 0 7525 1 7526 48 7527 0 7528 0
126/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
7529 1 7530 48 7531 0 7532 0 7533 2 7534 52 7535 56 7536 0 7537 1 7538 49 7539 0 7540 0 7541 1 7542 48 7543 0 7544 0 7545 1 7546 48 7547 0 7548 0 7549 2 7550 52 7551 57 7552 0 7553 1 7554 49 7555 0 7556 0 7557 1 7558 48 7559 0 7560 0 7561 2 7562 53 7563 54 7564 0 7565 2 7566 53 7567 50 7568 0 7569 1 7570 50 7571 0 7572 0 7573 1 7574 48 7575 0 7576 0 7577 1 7578 48 7579 0 7580 0 7581 2 7582 52 7583 56 7584 0 7585 1 7586 49 7587 0 7588 0
127/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
7589 1 7590 48 7591 0 7592 0 7593 1 7594 48 7595 0 7596 0 7597 2 7598 52 7599 56 7600 0 7601 1 7602 49 7603 0 7604 0 7605 1 7606 48 7607 0 7608 0 7609 1 7610 48 7611 0 7612 0 7613 2 7614 52 7615 56 7616 0 7617 1 7618 49 7619 0 7620 0 7621 1 7622 48 7623 0 7624 0 7625 1 7626 48 7627 0 7628 0 7629 2 7630 52 7631 56 7632 0 7633 1 7634 49 7635 0 7636 0 7637 1 7638 48 7639 0 7640 0 7641 1 7642 48 7643 0 7644 0 7645 2 7646 52 7647 56 7648 0
128/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
7649 1 7650 49 7651 0 7652 0 7653 1 7654 48 7655 0 7656 0 7657 1 7658 48 7659 0 7660 0 7661 2 7662 52 7663 56 7664 0 7665 1 7666 49 7667 0 7668 0 7669 1 7670 48 7671 0 7672 0 7673 1 7674 48 7675 0 7676 0 7677 2 7678 52 7679 56 7680 0 7681 1 7682 49 7683 0 7684 0 7685 1 7686 48 7687 0 7688 0 7689 1 7690 48 7691 0 7692 0 7693 2 7694 53 7695 50 7696 0 7697 1 7698 50 7699 0 7700 0 7701 1 7702 48 7703 0 7704 0 7705 1 7706 48 7707 0 7708 0
129/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
7709 2 7710 52 7711 56 7712 0 7713 1 7714 49 7715 0 7716 0 7717 1 7718 48 7719 0 7720 0 7721 1 7722 48 7723 0 7724 0 7725 2 7726 52 7727 56 7728 0 7729 1 7730 49 7731 0 7732 0 7733 1 7734 48 7735 0 7736 0 7737 1 7738 48 7739 0 7740 0 7741 2 7742 52 7743 57 7744 0 7745 1 7746 49 7747 0 7748 0 7749 1 7750 48 7751 0 7752 0 7753 2 7754 53 7755 54 7756 0 7757 2 7758 53 7759 50 7760 0 7761 1 7762 50 7763 0 7764 0 7765 1 7766 48 7767 0 7768 0
130/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
7769 1 7770 48 7771 0 7772 0 7773 2 7774 52 7775 56 7776 0 7777 1 7778 49 7779 0 7780 0 7781 1 7782 48 7783 0 7784 0 7785 1 7786 48 7787 0 7788 0 7789 2 7790 52 7791 56 7792 0 7793 1 7794 49 7795 0 7796 0 7797 1 7798 48 7799 0 7800 0 7801 1 7802 48 7803 0 7804 0 7805 2 7806 52 7807 57 7808 0 7809 1 7810 49 7811 0 7812 0 7813 1 7814 48 7815 0 7816 0 7817 2 7818 53 7819 54 7820 0 7821 2 7822 53 7823 50 7824 0 7825 1 7826 50 7827 0 7828 0
131/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
7829 1 7830 48 7831 0 7832 0 7833 1 7834 48 7835 0 7836 0 7837 2 7838 52 7839 56 7840 0 7841 1 7842 49 7843 0 7844 0 7845 1 7846 48 7847 0 7848 0 7849 1 7850 48 7851 0 7852 0 7853 2 7854 52 7855 56 7856 0 7857 1 7858 49 7859 0 7860 0 7861 1 7862 48 7863 0 7864 0 7865 1 7866 48 7867 0 7868 0 7869 2 7870 52 7871 57 7872 0 7873 1 7874 49 7875 0 7876 0 7877 1 7878 48 7879 0 7880 0 7881 2 7882 53 7883 54 7884 0 7885 2 7886 53 7887 50 7888 0
132/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
7889 1 7890 50 7891 0 7892 0 7893 1 7894 48 7895 0 7896 0 7897 1 7898 48 7899 0 7900 0 7901 2 7902 52 7903 56 7904 0 7905 1 7906 49 7907 0 7908 0 7909 1 7910 48 7911 0 7912 0 7913 1 7914 48 7915 0 7916 0 7917 2 7918 52 7919 56 7920 0 7921 1 7922 49 7923 0 7924 0 7925 1 7926 48 7927 0 7928 0 7929 1 7930 48 7931 0 7932 0 7933 2 7934 52 7935 57 7936 0 7937 1 7938 49 7939 0 7940 0 7941 1 7942 48 7943 0 7944 0 7945 2 7946 53 7947 54 7948 0
133/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
7949 2 7950 53 7951 50 7952 0 7953 1 7954 50 7955 0 7956 0 7957 1 7958 48 7959 0 7960 0 7961 1 7962 48 7963 0 7964 0 7965 2 7966 52 7967 56 7968 0 7969 1 7970 49 7971 0 7972 0 7973 1 7974 48 7975 0 7976 0 7977 1 7978 48 7979 0 7980 0 7981 2 7982 52 7983 56 7984 0 7985 1 7986 49 7987 0 7988 0 7989 1 7990 48 7991 0 7992 0 7993 1 7994 48 7995 0 7996 0 7997 2 7998 52 7999 57 8000 0 8001 1 8002 49 8003 0 8004 0 8005 1 8006 48 8007 0 8008 0
134/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
8009 2 8010 53 8011 54 8012 0 8013 2 8014 53 8015 50 8016 0 8017 1 8018 50 8019 0 8020 0 8021 1 8022 48 8023 0 8024 0 8025 1 8026 48 8027 0 8028 0 8029 2 8030 52 8031 56 8032 0 8033 1 8034 49 8035 0 8036 0 8037 1 8038 48 8039 0 8040 0 8041 1 8042 48 8043 0 8044 0 8045 2 8046 52 8047 56 8048 0 8049 1 8050 49 8051 0 8052 0 8053 1 8054 48 8055 0 8056 0 8057 1 8058 48 8059 0 8060 0 8061 2 8062 52 8063 57 8064 0 8065 1 8066 49 8067 0 8068 0
135/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
8069 1 8070 48 8071 0 8072 0 8073 2 8074 53 8075 54 8076 0 8077 2 8078 53 8079 50 8080 0 8081 1 8082 50 8083 0 8084 0 8085 1 8086 48 8087 0 8088 0 8089 1 8090 48 8091 0 8092 0 8093 2 8094 52 8095 56 8096 0 8097 1 8098 49 8099 0 8100 0 8101 1 8102 48 8103 0 8104 0 8105 1 8106 48 8107 0 8108 0 8109 2 8110 52 8111 56 8112 0 8113 1 8114 49 8115 0 8116 0 8117 1 8118 48 8119 0 8120 0 8121 1 8122 48 8123 0 8124 0 8125 2 8126 52 8127 57 8128 0
136/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
8129 1 8130 49 8131 0 8132 0 8133 1 8134 48 8135 0 8136 0 8137 2 8138 53 8139 54 8140 0 8141 2 8142 53 8143 50 8144 0 8145 1 8146 50 8147 0 8148 0 8149 1 8150 48 8151 0 8152 0 8153 1 8154 48 8155 0 8156 0 8157 2 8158 52 8159 56 8160 0 8161 1 8162 49 8163 0 8164 0 8165 1 8166 48 8167 0 8168 0 8169 1 8170 48 8171 0 8172 0 8173 2 8174 52 8175 56 8176 0 8177 1 8178 49 8179 0 8180 0 8181 1 8182 48 8183 0 8184 0 8185 1 8186 48 8187 0 8188 0
137/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
8189 2 8190 52 8191 57 8192 0 8193 1 8194 49 8195 0 8196 0 8197 1 8198 48 8199 0 8200 0 8201 2 8202 53 8203 54 8204 0 8205 2 8206 53 8207 50 8208 0 8209 1 8210 50 8211 0 8212 0 8213 1 8214 48 8215 0 8216 0 8217 1 8218 48 8219 0 8220 0 8221 2 8222 52 8223 56 8224 0 8225 1 8226 49 8227 0 8228 0 8229 1 8230 48 8231 0 8232 0 8233 1 8234 48 8235 0 8236 0 8237 2 8238 52 8239 56 8240 0 8241 1 8242 49 8243 0 8244 0 8245 1 8246 48 8247 0 8248 0
138/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
8249 1 8250 48 8251 0 8252 0 8253 2 8254 52 8255 57 8256 0 8257 1 8258 49 8259 0 8260 0 8261 1 8262 48 8263 0 8264 0 8265 2 8266 53 8267 54 8268 0 8269 2 8270 53 8271 50 8272 0 8273 1 8274 50 8275 0 8276 0 8277 1 8278 48 8279 0 8280 0 8281 1 8282 48 8283 0 8284 0 8285 2 8286 52 8287 56 8288 0 8289 1 8290 49 8291 0 8292 0 8293 1 8294 48 8295 0 8296 0 8297 1 8298 48 8299 0 8300 0 8301 2 8302 52 8303 56 8304 0 8305 1 8306 49 8307 0 8308 0
139/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
8309 1 8310 48 8311 0 8312 0 8313 1 8314 48 8315 0 8316 0 8317 2 8318 52 8319 57 8320 0 8321 1 8322 49 8323 0 8324 0 8325 1 8326 48 8327 0 8328 0 8329 2 8330 53 8331 54 8332 0 8333 2 8334 53 8335 50 8336 0 8337 1 8338 50 8339 0 8340 0 8341 1 8342 48 8343 0 8344 0 8345 1 8346 48 8347 0 8348 0 8349 2 8350 52 8351 56 8352 0 8353 1 8354 49 8355 0 8356 0 8357 1 8358 48 8359 0 8360 0 8361 1 8362 48 8363 0 8364 0 8365 2 8366 52 8367 56 8368 0
140/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
8369 1 8370 49 8371 0 8372 0 8373 1 8374 48 8375 0 8376 0 8377 1 8378 48 8379 0 8380 0 8381 2 8382 52 8383 57 8384 0 8385 1 8386 49 8387 0 8388 0 8389 1 8390 48 8391 0 8392 0 8393 2 8394 53 8395 54 8396 0 8397 2 8398 53 8399 50 8400 0 8401 1 8402 50 8403 0 8404 0 8405 1 8406 48 8407 0 8408 0 8409 1 8410 48 8411 0 8412 0 8413 2 8414 52 8415 56 8416 0 8417 1 8418 49 8419 0 8420 0 8421 1 8422 48 8423 0 8424 0 8425 1 8426 48 8427 0 8428 0
141/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
8429 2 8430 52 8431 56 8432 0 8433 1 8434 49 8435 0 8436 0 8437 1 8438 48 8439 0 8440 0 8441 1 8442 48 8443 0 8444 0 8445 2 8446 52 8447 57 8448 0 8449 1 8450 49 8451 0 8452 0 8453 1 8454 48 8455 0 8456 0 8457 2 8458 53 8459 54 8460 0 8461 2 8462 53 8463 50 8464 0 8465 1 8466 50 8467 0 8468 0 8469 1 8470 48 8471 0 8472 0 8473 1 8474 48 8475 0 8476 0 8477 2 8478 52 8479 56 8480 0 8481 1 8482 49 8483 0 8484 0 8485 1 8486 48 8487 0 8488 0
142/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
8489 1 8490 48 8491 0 8492 0 8493 2 8494 52 8495 56 8496 0 8497 1 8498 49 8499 0 8500 0 8501 1 8502 48 8503 0 8504 0 8505 1 8506 48 8507 0 8508 0 8509 2 8510 52 8511 57 8512 0 8513 1 8514 49 8515 0 8516 0 8517 1 8518 48 8519 0 8520 0 8521 2 8522 53 8523 54 8524 0 8525 2 8526 53 8527 50 8528 0 8529 1 8530 50 8531 0 8532 0 8533 1 8534 48 8535 0 8536 0 8537 1 8538 48 8539 0 8540 0 8541 2 8542 52 8543 56 8544 0 8545 1 8546 49 8547 0 8548 0
143/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
8549 1 8550 48 8551 0 8552 0 8553 1 8554 48 8555 0 8556 0 8557 2 8558 52 8559 56 8560 0 8561 1 8562 49 8563 0 8564 0 8565 1 8566 48 8567 0 8568 0 8569 1 8570 48 8571 0 8572 0 8573 2 8574 52 8575 57 8576 0 8577 1 8578 49 8579 0 8580 0 8581 1 8582 48 8583 0 8584 0 8585 2 8586 53 8587 54 8588 0 8589 2 8590 53 8591 50 8592 0 8593 1 8594 50 8595 0 8596 0 8597 1 8598 48 8599 0 8600 0 8601 1 8602 48 8603 0 8604 0 8605 2 8606 52 8607 56 8608 0
144/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
8609 1 8610 49 8611 0 8612 0 8613 1 8614 48 8615 0 8616 0 8617 1 8618 48 8619 0 8620 0 8621 2 8622 52 8623 56 8624 0 8625 1 8626 49 8627 0 8628 0 8629 1 8630 48 8631 0 8632 0 8633 1 8634 48 8635 0 8636 0 8637 2 8638 52 8639 57 8640 0 8641 1 8642 49 8643 0 8644 0 8645 1 8646 48 8647 0 8648 0 8649 2 8650 53 8651 54 8652 0 8653 2 8654 53 8655 50 8656 0 8657 1 8658 50 8659 0 8660 0 8661 1 8662 48 8663 0 8664 0 8665 1 8666 48 8667 0 8668 0
145/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
8669 2 8670 52 8671 56 8672 0 8673 1 8674 49 8675 0 8676 0 8677 1 8678 48 8679 0 8680 0 8681 1 8682 48 8683 0 8684 0 8685 2 8686 52 8687 56 8688 0 8689 1 8690 49 8691 0 8692 0 8693 1 8694 48 8695 0 8696 0 8697 1 8698 48 8699 0 8700 0 8701 2 8702 52 8703 57 8704 0 8705 1 8706 49 8707 0 8708 0 8709 1 8710 48 8711 0 8712 0 8713 2 8714 53 8715 54 8716 0 8717 2 8718 53 8719 51 8720 0 8721 1 8722 50 8723 0 8724 0 8725 1 8726 48 8727 0 8728 0
146/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
8729 2 8730 53 8731 48 8732 0 8733 2 8734 53 8735 51 8736 0 8737 1 8738 50 8739 0 8740 0 8741 1 8742 48 8743 0 8744 0 8745 2 8746 53 8747 48 8748 0 8749 2 8750 53 8751 51 8752 0 8753 1 8754 50 8755 0 8756 0 8757 1 8758 48 8759 0 8760 0 8761 1 8762 48 8763 0 8764 0 8765 2 8766 52 8767 56 8768 0 8769 1 8770 49 8771 0 8772 0 8773 1 8774 48 8775 0 8776 0 8777 1 8778 48 8779 0 8780 0 8781 2 8782 53 8783 54 8784 0 8785 1 8786 49 8787 0 8788 0
147/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
8789 1 8790 48 8791 0 8792 0 8793 2 8794 52 8795 57 8796 0 8797 2 8798 53 8799 51 8800 0 8801 1 8802 50 8803 0 8804 0 8805 1 8806 48 8807 0 8808 0 8809 2 8810 53 8811 49 8812 0 8813 2 8814 53 8815 51 8816 0 8817 1 8818 50 8819 0 8820 0 8821 1 8822 48 8823 0 8824 0 8825 1 8826 48 8827 0 8828 0 8829 2 8830 52 8831 57 8832 0 8833 1 8834 49 8835 0 8836 0 8837 1 8838 48 8839 0 8840 0 8841 2 8842 53 8843 54 8844 0 8845 2 8846 53 8847 50 8848 0
148/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
8849 1 8850 50 8851 0 8852 0 8853 1 8854 48 8855 0 8856 0 8857 1 8858 48 8859 0 8860 0 8861 2 8862 52 8863 56 8864 0 8865 1 8866 49 8867 0 8868 0 8869 1 8870 48 8871 0 8872 0 8873 1 8874 48 8875 0 8876 0 8877 2 8878 52 8879 56 8880 0 8881 1 8882 49 8883 0 8884 0 8885 1 8886 48 8887 0 8888 0 8889 1 8890 48 8891 0 8892 0 8893 2 8894 52 8895 57 8896 0 8897 1 8898 49 8899 0 8900 0 8901 1 8902 48 8903 0 8904 0 8905 2 8906 53 8907 54 8908 0
149/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
8909 2 8910 53 8911 50 8912 0 8913 1 8914 50 8915 0 8916 0 8917 1 8918 48 8919 0 8920 0 8921 1 8922 48 8923 0 8924 0 8925 2 8926 52 8927 56 8928 0 8929 1 8930 49 8931 0 8932 0 8933 1 8934 48 8935 0 8936 0 8937 1 8938 48 8939 0 8940 0 8941 2 8942 52 8943 56 8944 0 8945 1 8946 49 8947 0 8948 0 8949 1 8950 48 8951 0 8952 0 8953 1 8954 48 8955 0 8956 0 8957 2 8958 52 8959 57 8960 0 8961 1 8962 49 8963 0 8964 0 8965 1 8966 48 8967 0 8968 0
150/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
8969 2 8970 53 8971 54 8972 0 8973 2 8974 53 8975 50 8976 0 8977 1 8978 50 8979 0 8980 0 8981 1 8982 48 8983 0 8984 0 8985 1 8986 48 8987 0 8988 0 8989 2 8990 52 8991 56 8992 0 8993 1 8994 49 8995 0 8996 0 8997 1 8998 48 8999 0 9000 0 9001 1 9002 48 9003 0 9004 0 9005 2 9006 52 9007 56 9008 0 9009 1 9010 49 9011 0 9012 0 9013 1 9014 48 9015 0 9016 0 9017 1 9018 48 9019 0 9020 0 9021 2 9022 52 9023 57 9024 0 9025 1 9026 49 9027 0 9028 0
151/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
9029 1 9030 48 9031 0 9032 0 9033 2 9034 53 9035 54 9036 0 9037 2 9038 53 9039 50 9040 0 9041 1 9042 50 9043 0 9044 0 9045 1 9046 48 9047 0 9048 0 9049 1 9050 48 9051 0 9052 0 9053 2 9054 52 9055 56 9056 0 9057 1 9058 49 9059 0 9060 0 9061 1 9062 48 9063 0 9064 0 9065 1 9066 48 9067 0 9068 0 9069 2 9070 52 9071 56 9072 0 9073 1 9074 49 9075 0 9076 0 9077 1 9078 48 9079 0 9080 0 9081 1 9082 48 9083 0 9084 0 9085 2 9086 52 9087 57 9088 0
152/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
9089 1 9090 49 9091 0 9092 0 9093 1 9094 48 9095 0 9096 0 9097 2 9098 53 9099 54 9100 0 9101 2 9102 53 9103 50 9104 0 9105 1 9106 50 9107 0 9108 0 9109 1 9110 48 9111 0 9112 0 9113 1 9114 48 9115 0 9116 0 9117 2 9118 52 9119 56 9120 0 9121 1 9122 49 9123 0 9124 0 9125 1 9126 48 9127 0 9128 0 9129 1 9130 48 9131 0 9132 0 9133 2 9134 52 9135 56 9136 0 9137 1 9138 49 9139 0 9140 0 9141 1 9142 48 9143 0 9144 0 9145 1 9146 48 9147 0 9148 0
153/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
9149 2 9150 52 9151 57 9152 0 9153 1 9154 49 9155 0 9156 0 9157 1 9158 48 9159 0 9160 0 9161 2 9162 53 9163 54 9164 0 9165 2 9166 53 9167 50 9168 0 9169 1 9170 50 9171 0 9172 0 9173 1 9174 48 9175 0 9176 0 9177 1 9178 48 9179 0 9180 0 9181 2 9182 52 9183 56 9184 0 9185 1 9186 49 9187 0 9188 0 9189 1 9190 48 9191 0 9192 0 9193 1 9194 48 9195 0 9196 0 9197 2 9198 52 9199 56 9200 0 9201 1 9202 49 9203 0 9204 0 9205 1 9206 48 9207 0 9208 0
154/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
9209 1 9210 48 9211 0 9212 0 9213 2 9214 52 9215 57 9216 0 9217 1 9218 49 9219 0 9220 0 9221 1 9222 48 9223 0 9224 0 9225 2 9226 53 9227 54 9228 0 9229 2 9230 52 9231 56 9232 0 9233 1 9234 49 9235 0 9236 0 9237 1 9238 48 9239 0 9240 0 9241 1 9242 48 9243 0 9244 0 9245 2 9246 52 9247 56 9248 0 9249 1 9250 49 9251 0 9252 0 9253 1 9254 48 9255 0 9256 0 9257 1 9258 48 9259 0 9260 0 9261 2 9262 52 9263 56 9264 0 9265 1 9266 49 9267 0 9268 0
155/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
9269 1 9270 48 9271 0 9272 0 9273 1 9274 48 9275 0 9276 0 9277 2 9278 52 9279 56 9280 0 9281 1 9282 49 9283 0 9284 0 9285 1 9286 48 9287 0 9288 0 9289 1 9290 48 9291 0 9292 0 9293 2 9294 52 9295 56 9296 0 9297 1 9298 49 9299 0 9300 0 9301 1 9302 48 9303 0 9304 0 9305 1 9306 48 9307 0 9308 0 9309 2 9310 52 9311 56 9312 0 9313 1 9314 49 9315 0 9316 0 9317 1 9318 48 9319 0 9320 0 9321 1 9322 48 9323 0 9324 0 9325 2 9326 52 9327 56 9328 0
156/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
9329 1 9330 49 9331 0 9332 0 9333 1 9334 48 9335 0 9336 0 9337 1 9338 48 9339 0 9340 0 9341 2 9342 52 9343 56 9344 0 9345 1 9346 49 9347 0 9348 0 9349 1 9350 48 9351 0 9352 0 9353 1 9354 48 9355 0 9356 0 9357 2 9358 52 9359 56 9360 0 9361 1 9362 49 9363 0 9364 0 9365 1 9366 48 9367 0 9368 0 9369 1 9370 48 9371 0 9372 0 9373 2 9374 52 9375 56 9376 0 9377 1 9378 49 9379 0 9380 0 9381 1 9382 48 9383 0 9384 0 9385 1 9386 48 9387 0 9388 0
157/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
9389 2 9390 52 9391 56 9392 0 9393 1 9394 49 9395 0 9396 0 9397 1 9398 48 9399 0 9400 0 9401 1 9402 48 9403 0 9404 0 9405 2 9406 52 9407 56 9408 0 9409 1 9410 49 9411 0 9412 0 9413 1 9414 48 9415 0 9416 0 9417 1 9418 48 9419 0 9420 0 9421 2 9422 52 9423 56 9424 0 9425 1 9426 49 9427 0 9428 0 9429 1 9430 48 9431 0 9432 0 9433 1 9434 48 9435 0 9436 0 9437 2 9438 52 9439 56 9440 0 9441 1 9442 49 9443 0 9444 0 9445 1 9446 48 9447 0 9448 0
158/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
9449 1 9450 48 9451 0 9452 0 9453 2 9454 52 9455 56 9456 0 9457 1 9458 49 9459 0 9460 0 9461 1 9462 48 9463 0 9464 0 9465 1 9466 48 9467 0 9468 0 9469 2 9470 52 9471 56 9472 0 9473 1 9474 49 9475 0 9476 0 9477 1 9478 48 9479 0 9480 0 9481 1 9482 48 9483 0 9484 0 9485 2 9486 52 9487 56 9488 0 9489 1 9490 49 9491 0 9492 0 9493 1 9494 48 9495 0 9496 0 9497 2 9498 52 9499 57 9500 0 9501 2 9502 53 9503 51 9504 0 9505 1 9506 50 9507 0 9508 0
159/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
9509 1 9510 48 9511 0 9512 0 9513 2 9514 53 9515 49 9516 0 9517 2 9518 53 9519 51 9520 0 9521 1 9522 50 9523 0 9524 0 9525 1 9526 48 9527 0 9528 0 9529 2 9530 53 9531 55 9532 0 9533 2 9534 53 9535 50 9536 0 9537 1 9538 50 9539 0 9540 0 9541 1 9542 48 9543 0 9544 0 9545 2 9546 53 9547 50 9548 0 9549 2 9550 53 9551 51 9552 0 9553 1 9554 50 9555 0 9556 0 9557 1 9558 48 9559 0 9560 0 9561 2 9562 53 9563 55 9564 0 9565 2 9566 53 9567 50 9568 0
160/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
9569 1 9570 50 9571 0 9572 0 9573 1 9574 48 9575 0 9576 0 9577 2 9578 53 9579 54 9580 0 9581 2 9582 53 9583 50 9584 0 9585 1 9586 50 9587 0 9588 0 9589 1 9590 48 9591 0 9592 0 9593 2 9594 52 9595 56 9596 0 9597 2 9598 53 9599 51 9600 0 9601 1 9602 50 9603 0 9604 0 9605 1 9606 48 9607 0 9608 0 9609 2 9610 53 9611 48 9612 0 9613 2 9614 53 9615 51 9616 0 9617 1 9618 50 9619 0 9620 0 9621 1 9622 48 9623 0 9624 0 9625 1 9626 48 9627 0 9628 0
161/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
9629 2
9630 52
9631 56
9632 0
9633 1
9634 49
9635 0
9636 0
9637 1
9638 48
9639 0
9640 0
9641 1
9642 48
9643 0
9644 0
9645 2
9646 53
9647 54
9648 0
9649 1
9650 49
9651 0
9652 0
9653 1
9654 48
9655 0
9656 0
9657 2
9658 52
9659 57
9660 0
9661 2
9662 53
9663 51
9664 0
9665 1
9666 50
9667 0
9668 0
9669 1
9670 48
9671 0
9672 0
9673 2
9674 53
9675 49
9676 0
9677 2
9678 53
9679 51
9680 0
9681 35233280 9682 0
9683 0
9684 0
9685 35233312 9686 0
9687 0
9688 0
162/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
9689 35233344 9690 0
9691 0
9692 0
9693 35233376 9694 0
9695 0
9696 0
9697 1 9698 48 9699 0 9700 0 9701 1 9702 48 9703 0 9704 0 9705 1 9706 48 9707 0 9708 0 9709 1 9710 48 9711 0 9712 0 9713 1 9714 48 9715 0 9716 0 9717 1 9718 48 9719 0 9720 0 9721 1 9722 48 9723 0 9724 0 9725 1 9726 48 9727 0 9728 0 9729 1 9730 48 9731 0 9732 0 9733 1 9734 48 9735 0 9736 0 9737 1 9738 48 9739 0 9740 0 9741 0 9742 0 9743 0 9744 0 9745 0 9746 0 9747 0 9748 0
163/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
9749 0
9750 0
9751 35233792 9752 0
9753 0
9754 0
9755 0
9756 0
9757 0
9758 0
9759 0
9760 0
9761 35233872 9762 0
9763 0
9764 0
9765 0
9766 0
9767 0
9768 0
9769 0
9770 0
9771 35233952 9772 0
9773 0
9774 0
9775 0
9776 0
9777 0
9778 0
9779 0
9780 0
9781 35234032 9782 0
9783 0
9784 0
9785 0
9786 0
9787 0
9788 0
9789 0
9790 0
9791 35234112 9792 0
9793 0
9794 0
9795 0
9796 0
9797 0
9798 0
9799 0
9800 0
9801 35234192 9802 0
9803 0
9804 0
9805 0
9806 0
9807 0
9808 0
164/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
9809 0
9810 0
9811 35234272 9812 0
9813 0
9814 0
9815 0
9816 0
9817 0
9818 0
9819 0
9820 0
9821 35234352 9822 0
9823 0
9824 0
9825 0
9826 0
9827 0
9828 0
9829 0
9830 0
9831 35234432 9832 0
9833 0
9834 0
9835 0
9836 0
9837 0
9838 0
9839 0
9840 0
9841 35234512 9842 0
9843 0
9844 0
9845 0
9846 0
9847 0
9848 0
9849 0
9850 0
9851 35234592 9852 0
9853 0
9854 0
9855 0
9856 0
9857 0
9858 0
9859 0
9860 0
9861 35234672 9862 0
9863 0
9864 0
9865 0
9866 0
9867 0
9868 0
165/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
9869 0
9870 0
9871 35234752 9872 0
9873 0
9874 0
9875 0
9876 0
9877 0
9878 0
9879 0
9880 0
9881 35234832 9882 0
9883 0
9884 0
9885 0
9886 0
9887 0
9888 0
9889 0
9890 0
9891 35234912 9892 0
9893 0
9894 0
9895 0
9896 0
9897 0
9898 0
9899 0
9900 0
9901 35234992 9902 0
9903 0
9904 0
9905 0
9906 0
9907 0
9908 0
9909 0
9910 0
9911 35235072 9912 0
9913 0
9914 0
9915 0
9916 0
9917 0
9918 0
9919 0
9920 0
9921 35235152 9922 0
9923 0
9924 0
9925 0
9926 0
9927 0
9928 0
166/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
9929 0
9930 0
9931 35235232 9932 0
9933 0
9934 0
9935 0
9936 0
9937 0
9938 0
9939 0
9940 0
9941 35235312 9942 0
9943 0
9944 0
9945 0
9946 0
9947 0
9948 0
9949 0
9950 0
9951 35235392 9952 0
9953 0
9954 0
9955 0
9956 0
9957 0
9958 0
9959 0
9960 0
9961 35235472 9962 0
9963 0
9964 0
9965 0
9966 0
9967 0
9968 0
9969 0
9970 0
9971 35235552 9972 0
9973 0
9974 0
9975 0
9976 0
9977 0
9978 0
9979 0
9980 0
9981 8
9982 51
9983 53
9984 50
9985 51
9986 53
9987 53
9988 53
167/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
9989 50 9990 0 9991 8 9992 51 9993 53 9994 50 9995 51 9996 53 9997 52 9998 55 9999 50
10000 0 10001 8 10002 51 10003 53 10004 50 10005 51 10006 53 10007 51 10008 57 10009 50 10010 0 10011 8 10012 51 10013 53 10014 50 10015 51 10016 53 10017 51 10018 49 10019 50 10020 0 10021 8 10022 51 10023 53 10024 50 10025 51 10026 53 10027 50 10028 51 10029 50 10030 0 10031 8 10032 51 10033 53 10034 50 10035 51 10036 53 10037 49 10038 53 10039 50 10040 0 10041 8 10042 51 10043 53 10044 50 10045 51 10046 53 10047 48 10048 55
168/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
10049 50 10050 0 10051 8 10052 51 10053 53 10054 50 10055 51 10056 52 10057 57 10058 57 10059 50 10060 0 10061 8 10062 51 10063 53 10064 50 10065 51 10066 52 10067 57 10068 49 10069 50 10070 0 10071 8 10072 51 10073 53 10074 50 10075 51 10076 52 10077 56 10078 51 10079 50 10080 0 10081 8 10082 51 10083 53 10084 50 10085 51 10086 52 10087 55 10088 53 10089 50 10090 0 10091 8 10092 51 10093 53 10094 50 10095 51 10096 52 10097 54 10098 55 10099 50 10100 0 10101 8 10102 51 10103 53 10104 50 10105 51 10106 52 10107 53 10108 57
169/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
10109 50 10110 0 10111 8 10112 51 10113 53 10114 50 10115 51 10116 52 10117 53 10118 49 10119 50 10120 0 10121 8 10122 51 10123 53 10124 50 10125 51 10126 52 10127 52 10128 51 10129 50 10130 0 10131 8 10132 51 10133 53 10134 50 10135 51 10136 52 10137 51 10138 53 10139 50 10140 0 10141 8 10142 51 10143 53 10144 50 10145 51 10146 52 10147 50 10148 55 10149 50 10150 0 10151 8 10152 51 10153 53 10154 50 10155 51 10156 52 10157 49 10158 57 10159 50 10160 0 10161 8 10162 51 10163 53 10164 50 10165 51 10166 52 10167 49 10168 49
170/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
10169 50 10170 0 10171 8 10172 51 10173 53 10174 50 10175 51 10176 52 10177 48 10178 51 10179 50 10180 0 10181 8 10182 51 10183 53 10184 50 10185 51 10186 51 10187 57 10188 53 10189 50 10190 0 10191 8 10192 51 10193 53 10194 50 10195 51 10196 51 10197 56 10198 55 10199 50 10200 0 10201 8 10202 51 10203 53 10204 50 10205 51 10206 51 10207 55 10208 57 10209 50 10210 0 10211 8 10212 51 10213 53 10214 50 10215 51 10216 51 10217 51 10218 55 10219 54 10220 0 10221 8 10222 51 10223 53 10224 50 10225 51 10226 51 10227 51 10228 52
171/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
10229 52 10230 0 10231 8 10232 51 10233 53 10234 50 10235 51 10236 51 10237 51 10238 49 10239 50 10240 0 10241 8 10242 51 10243 53 10244 50 10245 51 10246 51 10247 50 10248 56 10249 48 10250 0 10251 0 10252 0 10253 1 10254 48 10255 0 10256 0 10257 1 10258 48 10259 0 10260 0 10261 1 10262 48 10263 0 10264 0 10265 1 10266 48 10267 0 10268 0 10269 1 10270 48 10271 0 10272 0 10273 1 10274 48 10275 0 10276 0 10277 1 10278 48 10279 0 10280 0 10281 1 10282 48 10283 0 10284 0 10285 1 10286 48 10287 0 10288 0
172/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
10289 1 10290 48 10291 0 10292 0 10293 1 10294 48 10295 0 10296 0 10297 1 10298 48 10299 0 10300 0 10301 1 10302 48 10303 0 10304 0 10305 1 10306 48 10307 0 10308 0 10309 1 10310 48 10311 0 10312 0 10313 1 10314 48 10315 0 10316 0 10317 1 10318 48 10319 0 10320 0 10321 1 10322 48 10323 0 10324 0 10325 1 10326 48 10327 0 10328 0 10329 1 10330 48 10331 0 10332 0 10333 1 10334 48 10335 0 10336 0 10337 1 10338 48 10339 0 10340 0 10341 1 10342 48 10343 0 10344 0 10345 1 10346 48 10347 0 10348 0
173/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
10349 1 10350 48 10351 0 10352 0 10353 1 10354 48 10355 0 10356 0 10357 1 10358 48 10359 0 10360 0 10361 1 10362 48 10363 0 10364 0 10365 1 10366 48 10367 0 10368 0 10369 1 10370 48 10371 0 10372 0 10373 1 10374 48 10375 0 10376 0 10377 1 10378 48 10379 0 10380 0 10381 1 10382 48 10383 0 10384 0 10385 1 10386 48 10387 0 10388 0 10389 1 10390 48 10391 0 10392 0 10393 1 10394 48 10395 0 10396 0 10397 1 10398 48 10399 0 10400 0 10401 1 10402 48 10403 0 10404 0 10405 1 10406 48 10407 0 10408 0
174/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
10409 1 10410 48 10411 0 10412 0 10413 1 10414 48 10415 0 10416 0 10417 1 10418 48 10419 0 10420 0 10421 1 10422 48 10423 0 10424 0 10425 1 10426 48 10427 0 10428 0 10429 1 10430 48 10431 0 10432 0 10433 1 10434 48 10435 0 10436 0 10437 1 10438 48 10439 0 10440 0 10441 1 10442 48 10443 0 10444 0 10445 1 10446 48 10447 0 10448 0 10449 1 10450 48 10451 0 10452 0 10453 1 10454 48 10455 0 10456 0 10457 1 10458 48 10459 0 10460 0 10461 1 10462 48 10463 0 10464 0 10465 1 10466 48 10467 0 10468 0
175/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
10469 1 10470 48 10471 0 10472 0 10473 1 10474 48 10475 0 10476 0 10477 1 10478 48 10479 0 10480 0 10481 1 10482 48 10483 0 10484 0 10485 1 10486 48 10487 0 10488 0 10489 1 10490 48 10491 0 10492 0 10493 1 10494 48 10495 0 10496 0 10497 1 10498 48 10499 0 10500 0 10501 1 10502 48 10503 0 10504 0 10505 1 10506 48 10507 0 10508 0 10509 1 10510 48 10511 0 10512 0 10513 1 10514 48 10515 0 10516 0 10517 1 10518 48 10519 0 10520 0 10521 1 10522 48 10523 0 10524 0 10525 1 10526 48 10527 0 10528 0
176/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
10529 1 10530 48 10531 0 10532 0 10533 1 10534 48 10535 0 10536 0 10537 1 10538 48 10539 0 10540 0 10541 1 10542 48 10543 0 10544 0 10545 1 10546 48 10547 0 10548 0 10549 1 10550 48 10551 0 10552 0 10553 1 10554 48 10555 0 10556 0 10557 1 10558 48 10559 0 10560 0 10561 1 10562 48 10563 0 10564 0 10565 1 10566 48 10567 0 10568 0 10569 1 10570 48 10571 0 10572 0 10573 1 10574 48 10575 0 10576 0 10577 1 10578 48 10579 0 10580 0 10581 1 10582 48 10583 0 10584 0 10585 1 10586 48 10587 0 10588 0
177/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
10589 1 10590 48 10591 0 10592 0 10593 1 10594 48 10595 0 10596 0 10597 1 10598 48 10599 0 10600 0 10601 1 10602 48 10603 0 10604 0 10605 1 10606 48 10607 0 10608 0 10609 1 10610 48 10611 0 10612 0 10613 1 10614 48 10615 0 10616 0 10617 1 10618 48 10619 0 10620 0 10621 1 10622 48 10623 0 10624 0 10625 1 10626 48 10627 0 10628 0 10629 1 10630 48 10631 0 10632 0 10633 1 10634 48 10635 0 10636 0 10637 1 10638 48 10639 0 10640 0 10641 1 10642 48 10643 0 10644 0 10645 1 10646 48 10647 0 10648 0
178/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
10649 1 10650 48 10651 0 10652 0 10653 1 10654 48 10655 0 10656 0 10657 1 10658 48 10659 0 10660 0 10661 1 10662 48 10663 0 10664 0 10665 1 10666 48 10667 0 10668 0 10669 1 10670 48 10671 0 10672 0 10673 1 10674 48 10675 0 10676 0 10677 1 10678 48 10679 0 10680 0 10681 1 10682 48 10683 0 10684 0 10685 1 10686 48 10687 0 10688 0 10689 1 10690 48 10691 0 10692 0 10693 1 10694 48 10695 0 10696 0 10697 1 10698 48 10699 0 10700 0 10701 1 10702 48 10703 0 10704 0 10705 1 10706 48 10707 0 10708 0
179/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
10709 1 10710 48 10711 0 10712 0 10713 1 10714 48 10715 0 10716 0 10717 1 10718 48 10719 0 10720 0 10721 1 10722 48 10723 0 10724 0 10725 1 10726 48 10727 0 10728 0 10729 1 10730 48 10731 0 10732 0 10733 1 10734 48 10735 0 10736 0 10737 1 10738 48 10739 0 10740 0 10741 1 10742 48 10743 0 10744 0 10745 1 10746 48 10747 0 10748 0 10749 1 10750 48 10751 0 10752 0 10753 1 10754 48 10755 0 10756 0 10757 1 10758 48 10759 0 10760 0 10761 1 10762 48 10763 0 10764 0 10765 1 10766 48 10767 0 10768 0
180/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
10769 2 10770 53 10771 48 10772 0 10773 2 10774 53 10775 51 10776 0 10777 2 10778 53 10779 53 10780 0 10781 2 10782 53 10783 50 10784 0 10785 2 10786 53 10787 49 10788 0 10789 2 10790 53 10791 48 10792 0 10793 2 10794 53 10795 51 10796 0 10797 2 10798 53 10799 49 10800 0 10801 1 10802 56 10803 0 10804 0 10805 1 10806 48 10807 0 10808 0 10809 2 10810 53 10811 48 10812 0 10813 2 10814 53 10815 49 10816 0 10817 2 10818 53 10819 54 10820 0 10821 2 10822 53 10823 50 10824 0 10825 2 10826 53 10827 49 10828 0
181/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
10829 2 10830 53 10831 48 10832 0 10833 2 10834 53 10835 51 10836 0 10837 2 10838 53 10839 49 10840 0 10841 1 10842 56 10843 0 10844 0 10845 1 10846 48 10847 0 10848 0 10849 2 10850 53 10851 48 10852 0 10853 2 10854 52 10855 57 10856 0 10857 2 10858 53 10859 55 10860 0 10861 2 10862 53 10863 50 10864 0 10865 2 10866 53 10867 49 10868 0 10869 2 10870 53 10871 48 10872 0 10873 2 10874 53 10875 51 10876 0 10877 2 10878 53 10879 49 10880 0 10881 1 10882 56 10883 0 10884 0 10885 1 10886 48 10887 0 10888 0
182/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
10889 2 10890 53 10891 48 10892 0 10893 2 10894 53 10895 55 10896 0 10897 2 10898 53 10899 55 10900 0 10901 2 10902 53 10903 50 10904 0 10905 2 10906 53 10907 49 10908 0 10909 2 10910 53 10911 48 10912 0 10913 2 10914 53 10915 51 10916 0 10917 2 10918 53 10919 49 10920 0 10921 1 10922 56 10923 0 10924 0 10925 1 10926 48 10927 0 10928 0 10929 2 10930 53 10931 48 10932 0 10933 2 10934 53 10935 53 10936 0 10937 2 10938 52 10939 56 10940 0 10941 2 10942 53 10943 51 10944 0 10945 2 10946 53 10947 49 10948 0
183/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
10949 2 10950 53 10951 48 10952 0 10953 2 10954 53 10955 51 10956 0 10957 2 10958 53 10959 49 10960 0 10961 1 10962 56 10963 0 10964 0 10965 1 10966 48 10967 0 10968 0 10969 2 10970 53 10971 48 10972 0 10973 2 10974 53 10975 51 10976 0 10977 2 10978 52 10979 57 10980 0 10981 2 10982 53 10983 51 10984 0 10985 2 10986 53 10987 49 10988 0 10989 2 10990 53 10991 48 10992 0 10993 2 10994 53 10995 51 10996 0 10997 2 10998 53 10999 49 11000 0 11001 1 11002 56 11003 0 11004 0 11005 1 11006 48 11007 0 11008 0
184/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
11009 2 11010 53 11011 48 11012 0 11013 2 11014 53 11015 49 11016 0 11017 2 11018 53 11019 48 11020 0 11021 2 11022 53 11023 51 11024 0 11025 2 11026 53 11027 49 11028 0 11029 2 11030 53 11031 48 11032 0 11033 2 11034 53 11035 51 11036 0 11037 2 11038 53 11039 49 11040 0 11041 1 11042 56 11043 0 11044 0 11045 1 11046 48 11047 0 11048 0 11049 2 11050 53 11051 48 11052 0 11053 2 11054 52 11055 57 11056 0 11057 2 11058 53 11059 49 11060 0 11061 2 11062 53 11063 51 11064 0 11065 2 11066 53 11067 49 11068 0
185/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
11069 2 11070 53 11071 48 11072 0 11073 2 11074 53 11075 51 11076 0 11077 2 11078 53 11079 49 11080 0 11081 1 11082 56 11083 0 11084 0 11085 1 11086 48 11087 0 11088 0 11089 2 11090 53 11091 48 11092 0 11093 2 11094 53 11095 55 11096 0 11097 2 11098 53 11099 49 11100 0 11101 2 11102 53 11103 51 11104 0 11105 2 11106 53 11107 49 11108 0 11109 2 11110 53 11111 48 11112 0 11113 2 11114 53 11115 51 11116 0 11117 2 11118 53 11119 49 11120 0 11121 1 11122 56 11123 0 11124 0 11125 1 11126 48 11127 0 11128 0
186/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
11129 2 11130 53 11131 48 11132 0 11133 2 11134 53 11135 53 11136 0 11137 2 11138 53 11139 50 11140 0 11141 2 11142 53 11143 51 11144 0 11145 2 11146 53 11147 49 11148 0 11149 2 11150 53 11151 48 11152 0 11153 2 11154 53 11155 51 11156 0 11157 2 11158 53 11159 49 11160 0 11161 1 11162 56 11163 0 11164 0 11165 1 11166 48 11167 0 11168 0 11169 2 11170 53 11171 48 11172 0 11173 2 11174 53 11175 51 11176 0 11177 2 11178 53 11179 51 11180 0 11181 2 11182 53 11183 51 11184 0 11185 2 11186 53 11187 49 11188 0
187/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
11189 2
11190 53 11191 48 11192 0
11193 2
11194 53 11195 51 11196 0
11197 2
11198 53 11199 0
11200 0
11201 35245440 11202 0
11203 0
11204 0
11205 35245472 11206 0
11207 0
11208 0
11209 35245504 11210 0
11211 0
11212 0
11213 35245536 11214 0
11215 0
11216 0
11217 1
11218 48 11219 0
11220 0
11221 1
11222 48 11223 0
11224 0
11225 1
11226 48 11227 0
11228 0
11229 1
11230 48 11231 0
11232 0
11233 1
11234 48 11235 0
11236 0
11237 1
11238 48 11239 0
11240 0
11241 1
11242 48 11243 0
11244 0
11245 1
11246 48 11247 0
11248 0
188/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
11249 1 11250 48 11251 0 11252 0 11253 1 11254 48 11255 0 11256 0 11257 1 11258 48 11259 0 11260 0 11261 1 11262 48 11263 0 11264 0 11265 1 11266 48 11267 0 11268 0 11269 1 11270 48 11271 0 11272 0 11273 2 11274 53 11275 51 11276 0 11277 2 11278 53 11279 53 11280 0 11281 2 11282 53 11283 49 11284 0 11285 2 11286 53 11287 49 11288 0 11289 2 11290 53 11291 49 11292 0 11293 2 11294 53 11295 48 11296 0 11297 2 11298 53 11299 51 11300 0 11301 2 11302 53 11303 49 11304 0 11305 1 11306 56 11307 0 11308 0
189/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
11309 1
11310 48 11311 0
11312 0
11313 2
11314 53 11315 48 11316 0
11317 2
11318 53 11319 55 11320 0
11321 2
11322 53 11323 53 11324 0
11325 2
11326 53 11327 49 11328 0
11329 2
11330 53 11331 0
11332 0
11333 35246496 11334 0
11335 0
11336 0
11337 35246528 11338 0
11339 0
11340 0
11341 35246560 11342 0
11343 0
11344 0
11345 35246592 11346 0
11347 0
11348 0
11349 35246624 11350 0
11351 0
11352 0
11353 35246656 11354 0
11355 0
11356 0
11357 35246688 11358 0
11359 0
11360 0
11361 35246720 11362 0
11363 0
11364 0
11365 35246752 11366 0
11367 0
11368 0
190/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
11369 35246784 11370 0
11371 0
11372 0
11373 35246816 11374 0
11375 0
11376 0
11377 35246848 11378 0
11379 0
11380 0
11381 35246880 11382 0
11383 0
11384 0
11385 35246912 11386 0
11387 0
11388 0
11389 35246944 11390 0
11391 0
11392 0
11393 35246976 11394 0
11395 0
11396 0
11397 35247008 11398 0
11399 0
11400 0
11401 35247040 11402 0
11403 0
11404 0
11405 35247072 11406 0
11407 0
11408 0
11409 35247104 11410 0
11411 0
11412 0
11413 35247136 11414 0
11415 0
11416 0
11417 35247168 11418 0
11419 0
11420 0
11421 35247200 11422 0
11423 0
11424 0
11425 35247232 11426 0
11427 0
11428 0
191/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
11429 35247264 11430 0
11431 0
11432 0
11433 35247296 11434 0
11435 0
11436 0
11437 35247328 11438 0
11439 0
11440 0
11441 35247360 11442 0
11443 0
11444 0
11445 1 11446 48 11447 0 11448 0 11449 1 11450 48 11451 0 11452 0 11453 1 11454 48 11455 0 11456 0 11457 1 11458 48 11459 0 11460 0 11461 1 11462 48 11463 0 11464 0 11465 1 11466 48 11467 0 11468 0 11469 1 11470 48 11471 0 11472 0 11473 1 11474 48 11475 0 11476 0 11477 1 11478 48 11479 0 11480 0 11481 1 11482 48 11483 0 11484 0 11485 1 11486 48 11487 0 11488 0
192/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
11489 1 11490 48 11491 0 11492 0 11493 1 11494 48 11495 0 11496 0 11497 1 11498 48 11499 0 11500 0 11501 1 11502 48 11503 0 11504 0 11505 1 11506 48 11507 0 11508 0 11509 1 11510 48 11511 0 11512 0 11513 1 11514 48 11515 0 11516 0 11517 1 11518 48 11519 0 11520 0 11521 1 11522 48 11523 0 11524 0 11525 1 11526 48 11527 0 11528 0 11529 1 11530 48 11531 0 11532 0 11533 1 11534 48 11535 0 11536 0 11537 1 11538 48 11539 0 11540 0 11541 1 11542 48 11543 0 11544 0 11545 1 11546 48 11547 0 11548 0
193/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
11549 1 11550 48 11551 0 11552 0 11553 1 11554 48 11555 0 11556 0 11557 1 11558 48 11559 0 11560 0 11561 1 11562 48 11563 0 11564 0 11565 1 11566 48 11567 0 11568 0 11569 1 11570 48 11571 0 11572 0 11573 1 11574 48 11575 0 11576 0 11577 1 11578 48 11579 0 11580 0 11581 1 11582 48 11583 0 11584 0 11585 1 11586 48 11587 0 11588 0 11589 1 11590 48 11591 0 11592 0 11593 1 11594 48 11595 0 11596 0 11597 1 11598 48 11599 0 11600 0 11601 1 11602 48 11603 0 11604 0 11605 1 11606 48 11607 0 11608 0
194/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
11609 1 11610 48 11611 0 11612 0 11613 1 11614 48 11615 0 11616 0 11617 1 11618 48 11619 0 11620 0 11621 1 11622 48 11623 0 11624 0 11625 1 11626 48 11627 0 11628 0 11629 1 11630 48 11631 0 11632 0 11633 1 11634 48 11635 0 11636 0 11637 1 11638 48 11639 0 11640 0 11641 1 11642 48 11643 0 11644 0 11645 1 11646 48 11647 0 11648 0 11649 1 11650 48 11651 0 11652 0 11653 1 11654 48 11655 0 11656 0 11657 1 11658 48 11659 0 11660 0 11661 1 11662 48 11663 0 11664 0 11665 1 11666 48 11667 0 11668 0
195/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
11669 1 11670 48 11671 0 11672 0 11673 1 11674 48 11675 0 11676 0 11677 1 11678 48 11679 0 11680 0 11681 1 11682 48 11683 0 11684 0 11685 1 11686 48 11687 0 11688 0 11689 1 11690 48 11691 0 11692 0 11693 1 11694 48 11695 0 11696 0 11697 1 11698 48 11699 0 11700 0 11701 1 11702 48 11703 0 11704 0 11705 1 11706 48 11707 0 11708 0 11709 1 11710 48 11711 0 11712 0 11713 1 11714 48 11715 0 11716 0 11717 1 11718 48 11719 0 11720 0 11721 1 11722 48 11723 0 11724 0 11725 1 11726 48 11727 0 11728 0
196/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
11729 1 11730 48 11731 0 11732 0 11733 1 11734 48 11735 0 11736 0 11737 1 11738 48 11739 0 11740 0 11741 1 11742 48 11743 0 11744 0 11745 1 11746 48 11747 0 11748 0 11749 1 11750 48 11751 0 11752 0 11753 1 11754 48 11755 0 11756 0 11757 1 11758 48 11759 0 11760 0 11761 1 11762 48 11763 0 11764 0 11765 1 11766 48 11767 0 11768 0 11769 1 11770 48 11771 0 11772 0 11773 1 11774 48 11775 0 11776 0 11777 1 11778 48 11779 0 11780 0 11781 1 11782 48 11783 0 11784 0 11785 2 11786 53 11787 51 11788 0
197/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
11789 1 11790 49 11791 0 11792 0 11793 1 11794 48 11795 0 11796 0 11797 1 11798 48 11799 0 11800 0 11801 2 11802 52 11803 56 11804 0 11805 1 11806 49 11807 0 11808 0 11809 1 11810 48 11811 0 11812 0 11813 1 11814 48 11815 0 11816 0 11817 2 11818 52 11819 56 11820 0 11821 1 11822 49 11823 0 11824 0 11825 1 11826 48 11827 0 11828 0 11829 1 11830 48 11831 0 11832 0 11833 2 11834 52 11835 56 11836 0 11837 1 11838 49 11839 0 11840 0 11841 1 11842 48 11843 0 11844 0 11845 1 11846 48 11847 0 11848 0
198/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
11849 2 11850 52 11851 56 11852 0 11853 1 11854 49 11855 0 11856 0 11857 1 11858 48 11859 0 11860 0 11861 1 11862 48 11863 0 11864 0 11865 2 11866 52 11867 56 11868 0 11869 1 11870 49 11871 0 11872 0 11873 1 11874 48 11875 0 11876 0 11877 1 11878 48 11879 0 11880 0 11881 2 11882 52 11883 56 11884 0 11885 1 11886 49 11887 0 11888 0 11889 1 11890 48 11891 0 11892 0 11893 1 11894 48 11895 0 11896 0 11897 2 11898 52 11899 56 11900 0 11901 1 11902 49 11903 0 11904 0 11905 1 11906 48 11907 0 11908 0
199/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
11909 1 11910 48 11911 0 11912 0 11913 2 11914 52 11915 56 11916 0 11917 1 11918 49 11919 0 11920 0 11921 1 11922 48 11923 0 11924 0 11925 1 11926 48 11927 0 11928 0 11929 2 11930 52 11931 56 11932 0 11933 1 11934 49 11935 0 11936 0 11937 1 11938 48 11939 0 11940 0 11941 1 11942 48 11943 0 11944 0 11945 2 11946 52 11947 56 11948 0 11949 1 11950 49 11951 0 11952 0 11953 1 11954 48 11955 0 11956 0 11957 1 11958 48 11959 0 11960 0 11961 2 11962 52 11963 56 11964 0 11965 1 11966 49 11967 0 11968 0
200/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
11969 1 11970 48 11971 0 11972 0 11973 1 11974 48 11975 0 11976 0 11977 2 11978 52 11979 56 11980 0 11981 1 11982 49 11983 0 11984 0 11985 1 11986 48 11987 0 11988 0 11989 1 11990 48 11991 0 11992 0 11993 2 11994 52 11995 56 11996 0 11997 1 11998 49 11999 0 12000 0 12001 1 12002 48 12003 0 12004 0 12005 1 12006 48 12007 0 12008 0 12009 2 12010 52 12011 56 12012 0 12013 1 12014 49 12015 0 12016 0 12017 1 12018 48 12019 0 12020 0 12021 1 12022 48 12023 0 12024 0 12025 2 12026 52 12027 56 12028 0
201/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
12029 1 12030 49 12031 0 12032 0 12033 1 12034 48 12035 0 12036 0 12037 1 12038 48 12039 0 12040 0 12041 2 12042 52 12043 56 12044 0 12045 1 12046 49 12047 0 12048 0 12049 1 12050 48 12051 0 12052 0 12053 1 12054 48 12055 0 12056 0 12057 2 12058 52 12059 56 12060 0 12061 1 12062 49 12063 0 12064 0 12065 1 12066 48 12067 0 12068 0 12069 1 12070 48 12071 0 12072 0 12073 2 12074 52 12075 56 12076 0 12077 1 12078 49 12079 0 12080 0 12081 1 12082 48 12083 0 12084 0 12085 1 12086 48 12087 0 12088 0
202/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
12089 2 12090 52 12091 56 12092 0 12093 1 12094 49 12095 0 12096 0 12097 1 12098 48 12099 0 12100 0 12101 1 12102 48 12103 0 12104 0 12105 2 12106 52 12107 56 12108 0 12109 1 12110 49 12111 0 12112 0 12113 1 12114 48 12115 0 12116 0 12117 1 12118 48 12119 0 12120 0 12121 2 12122 52 12123 56 12124 0 12125 1 12126 49 12127 0 12128 0 12129 1 12130 48 12131 0 12132 0 12133 1 12134 48 12135 0 12136 0 12137 2 12138 52 12139 56 12140 0 12141 1 12142 49 12143 0 12144 0 12145 1 12146 48 12147 0 12148 0
203/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
12149 1 12150 48 12151 0 12152 0 12153 2 12154 52 12155 56 12156 0 12157 1 12158 49 12159 0 12160 0 12161 1 12162 48 12163 0 12164 0 12165 1 12166 48 12167 0 12168 0 12169 2 12170 52 12171 56 12172 0 12173 1 12174 49 12175 0 12176 0 12177 1 12178 48 12179 0 12180 0 12181 1 12182 48 12183 0 12184 0 12185 2 12186 52 12187 56 12188 0 12189 1 12190 49 12191 0 12192 0 12193 1 12194 48 12195 0 12196 0 12197 1 12198 48 12199 0 12200 0 12201 2 12202 52 12203 56 12204 0 12205 1 12206 49 12207 0 12208 0
204/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
12209 1 12210 48 12211 0 12212 0 12213 1 12214 48 12215 0 12216 0 12217 2 12218 52 12219 56 12220 0 12221 1 12222 49 12223 0 12224 0 12225 1 12226 48 12227 0 12228 0 12229 1 12230 48 12231 0 12232 0 12233 2 12234 52 12235 56 12236 0 12237 1 12238 49 12239 0 12240 0 12241 1 12242 48 12243 0 12244 0 12245 1 12246 48 12247 0 12248 0 12249 2 12250 52 12251 56 12252 0 12253 1 12254 49 12255 0 12256 0 12257 1 12258 48 12259 0 12260 0 12261 1 12262 48 12263 0 12264 0 12265 2 12266 52 12267 56 12268 0
205/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
12269 1 12270 49 12271 0 12272 0 12273 1 12274 48 12275 0 12276 0 12277 1 12278 48 12279 0 12280 0 12281 2 12282 52 12283 56 12284 0 12285 1 12286 49 12287 0 12288 0 12289 1 12290 48 12291 0 12292 0 12293 1 12294 48 12295 0 12296 0 12297 2 12298 52 12299 56 12300 0 12301 1 12302 49 12303 0 12304 0 12305 1 12306 48 12307 0 12308 0 12309 1 12310 48 12311 0 12312 0 12313 2 12314 52 12315 56 12316 0 12317 1 12318 49 12319 0 12320 0 12321 1 12322 48 12323 0 12324 0 12325 1 12326 48 12327 0 12328 0
206/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
12329 2 12330 52 12331 56 12332 0 12333 1 12334 49 12335 0 12336 0 12337 1 12338 48 12339 0 12340 0 12341 1 12342 48 12343 0 12344 0 12345 2 12346 52 12347 56 12348 0 12349 1 12350 49 12351 0 12352 0 12353 1 12354 48 12355 0 12356 0 12357 1 12358 48 12359 0 12360 0 12361 2 12362 52 12363 56 12364 0 12365 1 12366 49 12367 0 12368 0 12369 1 12370 48 12371 0 12372 0 12373 1 12374 48 12375 0 12376 0 12377 2 12378 52 12379 56 12380 0 12381 1 12382 49 12383 0 12384 0 12385 1 12386 48 12387 0 12388 0
207/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
12389 1 12390 48 12391 0 12392 0 12393 2 12394 52 12395 56 12396 0 12397 1 12398 49 12399 0 12400 0 12401 1 12402 48 12403 0 12404 0 12405 1 12406 48 12407 0 12408 0 12409 2 12410 52 12411 56 12412 0 12413 1 12414 49 12415 0 12416 0 12417 1 12418 48 12419 0 12420 0 12421 1 12422 48 12423 0 12424 0 12425 2 12426 52 12427 56 12428 0 12429 1 12430 49 12431 0 12432 0 12433 1 12434 48 12435 0 12436 0 12437 1 12438 48 12439 0 12440 0 12441 2 12442 52 12443 56 12444 0 12445 1 12446 49 12447 0 12448 0
208/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
12449 1 12450 48 12451 0 12452 0 12453 1 12454 48 12455 0 12456 0 12457 2 12458 52 12459 56 12460 0 12461 1 12462 49 12463 0 12464 0 12465 1 12466 48 12467 0 12468 0 12469 1 12470 48 12471 0 12472 0 12473 2 12474 52 12475 56 12476 0 12477 1 12478 49 12479 0 12480 0 12481 1 12482 48 12483 0 12484 0 12485 1 12486 48 12487 0 12488 0 12489 2 12490 52 12491 56 12492 0 12493 1 12494 49 12495 0 12496 0 12497 1 12498 48 12499 0 12500 0 12501 1 12502 48 12503 0 12504 0 12505 2 12506 52 12507 56 12508 0
209/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
12509 1 12510 49 12511 0 12512 0 12513 1 12514 48 12515 0 12516 0 12517 1 12518 48 12519 0 12520 0 12521 2 12522 52 12523 56 12524 0 12525 1 12526 49 12527 0 12528 0 12529 1 12530 48 12531 0 12532 0 12533 1 12534 48 12535 0 12536 0 12537 2 12538 52 12539 56 12540 0 12541 1 12542 49 12543 0 12544 0 12545 1 12546 48 12547 0 12548 0 12549 1 12550 48 12551 0 12552 0 12553 2 12554 52 12555 56 12556 0 12557 1 12558 49 12559 0 12560 0 12561 1 12562 48 12563 0 12564 0 12565 1 12566 48 12567 0 12568 0
210/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
12569 2 12570 52 12571 56 12572 0 12573 1 12574 49 12575 0 12576 0 12577 1 12578 48 12579 0 12580 0 12581 1 12582 48 12583 0 12584 0 12585 2 12586 52 12587 56 12588 0 12589 1 12590 49 12591 0 12592 0 12593 1 12594 48 12595 0 12596 0 12597 1 12598 48 12599 0 12600 0 12601 2 12602 52 12603 56 12604 0 12605 1 12606 49 12607 0 12608 0 12609 1 12610 48 12611 0 12612 0 12613 1 12614 48 12615 0 12616 0 12617 2 12618 52 12619 56 12620 0 12621 1 12622 49 12623 0 12624 0 12625 1 12626 48 12627 0 12628 0
211/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
12629 1 12630 48 12631 0 12632 0 12633 2 12634 52 12635 56 12636 0 12637 1 12638 49 12639 0 12640 0 12641 1 12642 48 12643 0 12644 0 12645 1 12646 48 12647 0 12648 0 12649 2 12650 52 12651 56 12652 0 12653 1 12654 49 12655 0 12656 0 12657 1 12658 48 12659 0 12660 0 12661 1 12662 48 12663 0 12664 0 12665 2 12666 52 12667 56 12668 0 12669 1 12670 49 12671 0 12672 0 12673 1 12674 48 12675 0 12676 0 12677 1 12678 48 12679 0 12680 0 12681 2 12682 52 12683 56 12684 0 12685 1 12686 49 12687 0 12688 0
212/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
12689 1 12690 48 12691 0 12692 0 12693 1 12694 48 12695 0 12696 0 12697 2 12698 52 12699 56 12700 0 12701 1 12702 49 12703 0 12704 0 12705 1 12706 48 12707 0 12708 0 12709 1 12710 48 12711 0 12712 0 12713 2 12714 52 12715 56 12716 0 12717 1 12718 49 12719 0 12720 0 12721 1 12722 48 12723 0 12724 0 12725 1 12726 48 12727 0 12728 0 12729 2 12730 52 12731 56 12732 0 12733 1 12734 49 12735 0 12736 0 12737 1 12738 48 12739 0 12740 0 12741 1 12742 48 12743 0 12744 0 12745 2 12746 52 12747 56 12748 0
213/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
12749 1 12750 49 12751 0 12752 0 12753 1 12754 48 12755 0 12756 0 12757 1 12758 48 12759 0 12760 0 12761 2 12762 52 12763 56 12764 0 12765 1 12766 49 12767 0 12768 0 12769 1 12770 48 12771 0 12772 0 12773 1 12774 48 12775 0 12776 0 12777 2 12778 52 12779 56 12780 0 12781 1 12782 49 12783 0 12784 0 12785 1 12786 48 12787 0 12788 0 12789 1 12790 48 12791 0 12792 0 12793 2 12794 52 12795 56 12796 0 12797 1 12798 49 12799 0 12800 0 12801 1 12802 48 12803 0 12804 0 12805 1 12806 48 12807 0 12808 0
214/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
12809 2 12810 52 12811 56 12812 0 12813 1 12814 49 12815 0 12816 0 12817 1 12818 48 12819 0 12820 0 12821 2 12822 53 12823 54 12824 0 12825 2 12826 53 12827 50 12828 0 12829 1 12830 50 12831 0 12832 0 12833 1 12834 48 12835 0 12836 0 12837 1 12838 48 12839 0 12840 0 12841 2 12842 52 12843 56 12844 0 12845 1 12846 49 12847 0 12848 0 12849 1 12850 48 12851 0 12852 0 12853 1 12854 48 12855 0 12856 0 12857 2 12858 52 12859 56 12860 0 12861 1 12862 49 12863 0 12864 0 12865 1 12866 48 12867 0 12868 0
215/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
12869 1 12870 48 12871 0 12872 0 12873 2 12874 52 12875 57 12876 0 12877 1 12878 49 12879 0 12880 0 12881 1 12882 48 12883 0 12884 0 12885 2 12886 53 12887 54 12888 0 12889 2 12890 53 12891 50 12892 0 12893 1 12894 50 12895 0 12896 0 12897 1 12898 48 12899 0 12900 0 12901 1 12902 48 12903 0 12904 0 12905 2 12906 52 12907 56 12908 0 12909 1 12910 49 12911 0 12912 0 12913 1 12914 48 12915 0 12916 0 12917 1 12918 48 12919 0 12920 0 12921 2 12922 52 12923 56 12924 0 12925 1 12926 49 12927 0 12928 0
216/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
12929 1 12930 48 12931 0 12932 0 12933 1 12934 48 12935 0 12936 0 12937 2 12938 52 12939 57 12940 0 12941 1 12942 49 12943 0 12944 0 12945 1 12946 48 12947 0 12948 0 12949 2 12950 53 12951 54 12952 0 12953 2 12954 53 12955 50 12956 0 12957 1 12958 50 12959 0 12960 0 12961 1 12962 48 12963 0 12964 0 12965 1 12966 48 12967 0 12968 0 12969 2 12970 52 12971 56 12972 0 12973 1 12974 49 12975 0 12976 0 12977 1 12978 48 12979 0 12980 0 12981 1 12982 48 12983 0 12984 0 12985 2 12986 52 12987 56 12988 0
217/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
12989 1 12990 49 12991 0 12992 0 12993 1 12994 48 12995 0 12996 0 12997 1 12998 48 12999 0 13000 0 13001 2 13002 52 13003 57 13004 0 13005 1 13006 49 13007 0 13008 0 13009 1 13010 48 13011 0 13012 0 13013 2 13014 53 13015 54 13016 0 13017 2 13018 53 13019 50 13020 0 13021 1 13022 50 13023 0 13024 0 13025 1 13026 48 13027 0 13028 0 13029 1 13030 48 13031 0 13032 0 13033 2 13034 52 13035 56 13036 0 13037 1 13038 49 13039 0 13040 0 13041 1 13042 48 13043 0 13044 0 13045 1 13046 48 13047 0 13048 0
218/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
13049 2 13050 52 13051 56 13052 0 13053 1 13054 49 13055 0 13056 0 13057 1 13058 48 13059 0 13060 0 13061 1 13062 48 13063 0 13064 0 13065 2 13066 52 13067 57 13068 0 13069 1 13070 49 13071 0 13072 0 13073 1 13074 48 13075 0 13076 0 13077 2 13078 53 13079 54 13080 0 13081 2 13082 53 13083 50 13084 0 13085 1 13086 50 13087 0 13088 0 13089 1 13090 48 13091 0 13092 0 13093 1 13094 48 13095 0 13096 0 13097 2 13098 52 13099 56 13100 0 13101 1 13102 49 13103 0 13104 0 13105 1 13106 48 13107 0 13108 0
219/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
13109 1 13110 48 13111 0 13112 0 13113 2 13114 52 13115 56 13116 0 13117 1 13118 49 13119 0 13120 0 13121 1 13122 48 13123 0 13124 0 13125 1 13126 48 13127 0 13128 0 13129 2 13130 52 13131 57 13132 0 13133 1 13134 49 13135 0 13136 0 13137 1 13138 48 13139 0 13140 0 13141 2 13142 53 13143 49 13144 0 13145 2 13146 53 13147 51 13148 0 13149 1 13150 50 13151 0 13152 0 13153 1 13154 48 13155 0 13156 0 13157 1 13158 48 13159 0 13160 0 13161 2 13162 52 13163 56 13164 0 13165 1 13166 49 13167 0 13168 0
220/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
13169 1 13170 48 13171 0 13172 0 13173 1 13174 48 13175 0 13176 0 13177 2 13178 52 13179 56 13180 0 13181 1 13182 49 13183 0 13184 0 13185 1 13186 48 13187 0 13188 0 13189 1 13190 48 13191 0 13192 0 13193 2 13194 52 13195 56 13196 0 13197 1 13198 49 13199 0 13200 0 13201 1 13202 48 13203 0 13204 0 13205 1 13206 48 13207 0 13208 0 13209 2 13210 52 13211 56 13212 0 13213 1 13214 49 13215 0 13216 0 13217 1 13218 48 13219 0 13220 0 13221 1 13222 48 13223 0 13224 0 13225 2 13226 52 13227 56 13228 0
221/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
13229 1 13230 49 13231 0 13232 0 13233 1 13234 48 13235 0 13236 0 13237 1 13238 48 13239 0 13240 0 13241 2 13242 52 13243 56 13244 0 13245 1 13246 49 13247 0 13248 0 13249 1 13250 48 13251 0 13252 0 13253 1 13254 48 13255 0 13256 0 13257 2 13258 52 13259 56 13260 0 13261 1 13262 49 13263 0 13264 0 13265 1 13266 48 13267 0 13268 0 13269 1 13270 48 13271 0 13272 0 13273 2 13274 52 13275 56 13276 0 13277 1 13278 49 13279 0 13280 0 13281 1 13282 48 13283 0 13284 0 13285 1 13286 48 13287 0 13288 0
222/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
13289 2 13290 52 13291 56 13292 0 13293 1 13294 49 13295 0 13296 0 13297 1 13298 48 13299 0 13300 0 13301 1 13302 48 13303 0 13304 0 13305 2 13306 52 13307 56 13308 0 13309 1 13310 49 13311 0 13312 0 13313 1 13314 48 13315 0 13316 0 13317 1 13318 48 13319 0 13320 0 13321 2 13322 52 13323 56 13324 0 13325 1 13326 49 13327 0 13328 0 13329 1 13330 48 13331 0 13332 0 13333 2 13334 53 13335 54 13336 0 13337 2 13338 53 13339 50 13340 0 13341 1 13342 50 13343 0 13344 0 13345 1 13346 48 13347 0 13348 0
223/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
13349 1 13350 48 13351 0 13352 0 13353 2 13354 52 13355 56 13356 0 13357 1 13358 49 13359 0 13360 0 13361 1 13362 48 13363 0 13364 0 13365 1 13366 48 13367 0 13368 0 13369 2 13370 52 13371 56 13372 0 13373 1 13374 49 13375 0 13376 0 13377 1 13378 48 13379 0 13380 0 13381 1 13382 48 13383 0 13384 0 13385 2 13386 52 13387 57 13388 0 13389 1 13390 49 13391 0 13392 0 13393 1 13394 48 13395 0 13396 0 13397 2 13398 53 13399 54 13400 0 13401 2 13402 53 13403 50 13404 0 13405 1 13406 50 13407 0 13408 0
224/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
13409 1 13410 48 13411 0 13412 0 13413 1 13414 48 13415 0 13416 0 13417 2 13418 52 13419 56 13420 0 13421 1 13422 49 13423 0 13424 0 13425 1 13426 48 13427 0 13428 0 13429 1 13430 48 13431 0 13432 0 13433 2 13434 52 13435 56 13436 0 13437 1 13438 49 13439 0 13440 0 13441 1 13442 48 13443 0 13444 0 13445 1 13446 48 13447 0 13448 0 13449 2 13450 52 13451 57 13452 0 13453 1 13454 49 13455 0 13456 0 13457 1 13458 48 13459 0 13460 0 13461 2 13462 53 13463 54 13464 0 13465 2 13466 53 13467 50 13468 0
225/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
13469 1 13470 50 13471 0 13472 0 13473 1 13474 48 13475 0 13476 0 13477 1 13478 48 13479 0 13480 0 13481 2 13482 52 13483 56 13484 0 13485 1 13486 49 13487 0 13488 0 13489 1 13490 48 13491 0 13492 0 13493 1 13494 48 13495 0 13496 0 13497 2 13498 52 13499 56 13500 0 13501 1 13502 49 13503 0 13504 0 13505 1 13506 48 13507 0 13508 0 13509 1 13510 48 13511 0 13512 0 13513 2 13514 52 13515 57 13516 0 13517 1 13518 49 13519 0 13520 0 13521 1 13522 48 13523 0 13524 0 13525 2 13526 53 13527 54 13528 0
226/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
13529 2 13530 53 13531 50 13532 0 13533 1 13534 50 13535 0 13536 0 13537 1 13538 48 13539 0 13540 0 13541 1 13542 48 13543 0 13544 0 13545 2 13546 52 13547 56 13548 0 13549 1 13550 49 13551 0 13552 0 13553 1 13554 48 13555 0 13556 0 13557 1 13558 48 13559 0 13560 0 13561 2 13562 52 13563 56 13564 0 13565 1 13566 49 13567 0 13568 0 13569 1 13570 48 13571 0 13572 0 13573 1 13574 48 13575 0 13576 0 13577 2 13578 52 13579 57 13580 0 13581 1 13582 49 13583 0 13584 0 13585 1 13586 48 13587 0 13588 0
227/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
13589 2 13590 53 13591 54 13592 0 13593 2 13594 53 13595 50 13596 0 13597 1 13598 50 13599 0 13600 0 13601 1 13602 48 13603 0 13604 0 13605 1 13606 48 13607 0 13608 0 13609 2 13610 52 13611 56 13612 0 13613 1 13614 49 13615 0 13616 0 13617 1 13618 48 13619 0 13620 0 13621 1 13622 48 13623 0 13624 0 13625 2 13626 52 13627 56 13628 0 13629 1 13630 49 13631 0 13632 0 13633 1 13634 48 13635 0 13636 0 13637 1 13638 48 13639 0 13640 0 13641 2 13642 52 13643 57 13644 0 13645 1 13646 49 13647 0 13648 0
228/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
13649 1 13650 48 13651 0 13652 0 13653 2 13654 53 13655 54 13656 0 13657 2 13658 53 13659 50 13660 0 13661 1 13662 50 13663 0 13664 0 13665 1 13666 48 13667 0 13668 0 13669 1 13670 48 13671 0 13672 0 13673 2 13674 52 13675 56 13676 0 13677 1 13678 49 13679 0 13680 0 13681 1 13682 48 13683 0 13684 0 13685 1 13686 48 13687 0 13688 0 13689 2 13690 52 13691 56 13692 0 13693 1 13694 49 13695 0 13696 0 13697 1 13698 48 13699 0 13700 0 13701 1 13702 48 13703 0 13704 0 13705 2 13706 52 13707 57 13708 0
229/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
13709 1 13710 49 13711 0 13712 0 13713 1 13714 48 13715 0 13716 0 13717 2 13718 53 13719 54 13720 0 13721 2 13722 53 13723 50 13724 0 13725 1 13726 50 13727 0 13728 0 13729 1 13730 48 13731 0 13732 0 13733 1 13734 48 13735 0 13736 0 13737 2 13738 52 13739 56 13740 0 13741 1 13742 49 13743 0 13744 0 13745 1 13746 48 13747 0 13748 0 13749 1 13750 48 13751 0 13752 0 13753 2 13754 52 13755 56 13756 0 13757 1 13758 49 13759 0 13760 0 13761 1 13762 48 13763 0 13764 0 13765 1 13766 48 13767 0 13768 0
230/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
13769 2 13770 52 13771 57 13772 0 13773 1 13774 49 13775 0 13776 0 13777 1 13778 48 13779 0 13780 0 13781 2 13782 53 13783 54 13784 0 13785 2 13786 53 13787 50 13788 0 13789 1 13790 50 13791 0 13792 0 13793 1 13794 48 13795 0 13796 0 13797 1 13798 48 13799 0 13800 0 13801 2 13802 52 13803 56 13804 0 13805 1 13806 49 13807 0 13808 0 13809 1 13810 48 13811 0 13812 0 13813 1 13814 48 13815 0 13816 0 13817 2 13818 52 13819 56 13820 0 13821 1 13822 49 13823 0 13824 0 13825 1 13826 48 13827 0 13828 0
231/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
13829 1 13830 48 13831 0 13832 0 13833 2 13834 52 13835 57 13836 0 13837 1 13838 49 13839 0 13840 0 13841 1 13842 48 13843 0 13844 0 13845 2 13846 53 13847 54 13848 0 13849 2 13850 53 13851 50 13852 0 13853 1 13854 50 13855 0 13856 0 13857 1 13858 48 13859 0 13860 0 13861 1 13862 48 13863 0 13864 0 13865 2 13866 52 13867 56 13868 0 13869 1 13870 49 13871 0 13872 0 13873 1 13874 48 13875 0 13876 0 13877 1 13878 48 13879 0 13880 0 13881 2 13882 52 13883 56 13884 0 13885 1 13886 49 13887 0 13888 0
232/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
13889 1 13890 48 13891 0 13892 0 13893 1 13894 48 13895 0 13896 0 13897 2 13898 52 13899 57 13900 0 13901 1 13902 49 13903 0 13904 0 13905 1 13906 48 13907 0 13908 0 13909 2 13910 53 13911 54 13912 0 13913 2 13914 53 13915 50 13916 0 13917 1 13918 50 13919 0 13920 0 13921 1 13922 48 13923 0 13924 0 13925 1 13926 48 13927 0 13928 0 13929 2 13930 52 13931 56 13932 0 13933 1 13934 49 13935 0 13936 0 13937 1 13938 48 13939 0 13940 0 13941 1 13942 48 13943 0 13944 0 13945 2 13946 52 13947 56 13948 0
233/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
13949 1 13950 49 13951 0 13952 0 13953 1 13954 48 13955 0 13956 0 13957 1 13958 48 13959 0 13960 0 13961 2 13962 52 13963 57 13964 0 13965 1 13966 49 13967 0 13968 0 13969 1 13970 48 13971 0 13972 0 13973 2 13974 53 13975 54 13976 0 13977 2 13978 53 13979 50 13980 0 13981 1 13982 50 13983 0 13984 0 13985 1 13986 48 13987 0 13988 0 13989 1 13990 48 13991 0 13992 0 13993 2 13994 52 13995 56 13996 0 13997 1 13998 49 13999 0 14000 0 14001 1 14002 48 14003 0 14004 0 14005 1 14006 48 14007 0 14008 0
234/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
14009 2 14010 52 14011 56 14012 0 14013 1 14014 49 14015 0 14016 0 14017 1 14018 48 14019 0 14020 0 14021 1 14022 48 14023 0 14024 0 14025 2 14026 52 14027 57 14028 0 14029 1 14030 49 14031 0 14032 0 14033 1 14034 48 14035 0 14036 0 14037 2 14038 53 14039 54 14040 0 14041 2 14042 53 14043 50 14044 0 14045 1 14046 50 14047 0 14048 0 14049 1 14050 48 14051 0 14052 0 14053 1 14054 48 14055 0 14056 0 14057 2 14058 52 14059 56 14060 0 14061 1 14062 49 14063 0 14064 0 14065 1 14066 48 14067 0 14068 0
235/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
14069 1 14070 48 14071 0 14072 0 14073 2 14074 52 14075 56 14076 0 14077 1 14078 49 14079 0 14080 0 14081 1 14082 48 14083 0 14084 0 14085 1 14086 48 14087 0 14088 0 14089 2 14090 52 14091 57 14092 0 14093 1 14094 49 14095 0 14096 0 14097 1 14098 48 14099 0 14100 0 14101 2 14102 53 14103 54 14104 0 14105 2 14106 53 14107 50 14108 0 14109 1 14110 50 14111 0 14112 0 14113 1 14114 48 14115 0 14116 0 14117 1 14118 48 14119 0 14120 0 14121 2 14122 52 14123 56 14124 0 14125 1 14126 49 14127 0 14128 0
236/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
14129 1 14130 48 14131 0 14132 0 14133 1 14134 48 14135 0 14136 0 14137 2 14138 52 14139 56 14140 0 14141 1 14142 49 14143 0 14144 0 14145 1 14146 48 14147 0 14148 0 14149 1 14150 48 14151 0 14152 0 14153 2 14154 52 14155 57 14156 0 14157 1 14158 49 14159 0 14160 0 14161 1 14162 48 14163 0 14164 0 14165 2 14166 53 14167 54 14168 0 14169 2 14170 53 14171 50 14172 0 14173 1 14174 50 14175 0 14176 0 14177 1 14178 48 14179 0 14180 0 14181 1 14182 48 14183 0 14184 0 14185 2 14186 52 14187 56 14188 0
237/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
14189 1 14190 49 14191 0 14192 0 14193 1 14194 48 14195 0 14196 0 14197 1 14198 48 14199 0 14200 0 14201 2 14202 52 14203 56 14204 0 14205 1 14206 49 14207 0 14208 0 14209 1 14210 48 14211 0 14212 0 14213 1 14214 48 14215 0 14216 0 14217 2 14218 52 14219 57 14220 0 14221 1 14222 49 14223 0 14224 0 14225 1 14226 48 14227 0 14228 0 14229 2 14230 53 14231 54 14232 0 14233 2 14234 53 14235 50 14236 0 14237 1 14238 50 14239 0 14240 0 14241 1 14242 48 14243 0 14244 0 14245 1 14246 48 14247 0 14248 0
238/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
14249 2 14250 52 14251 56 14252 0 14253 1 14254 49 14255 0 14256 0 14257 1 14258 48 14259 0 14260 0 14261 1 14262 48 14263 0 14264 0 14265 2 14266 52 14267 56 14268 0 14269 1 14270 49 14271 0 14272 0 14273 1 14274 48 14275 0 14276 0 14277 1 14278 48 14279 0 14280 0 14281 2 14282 52 14283 57 14284 0 14285 1 14286 49 14287 0 14288 0 14289 1 14290 48 14291 0 14292 0 14293 2 14294 53 14295 54 14296 0 14297 2 14298 53 14299 50 14300 0 14301 1 14302 50 14303 0 14304 0 14305 1 14306 48 14307 0 14308 0
239/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
14309 1
14310 48 14311 0
14312 0
14313 2
14314 52 14315 56 14316 0
14317 1
14318 49 14319 0
14320 0
14321 1
14322 48 14323 0
14324 0
14325 1
14326 48 14327 0
14328 0
14329 2
14330 52 14331 56 14332 0
14333 1
14334 49 14335 0
14336 0
14337 1
14338 48 14339 0
14340 0
14341 1
14342 48 14343 0
14344 0
14345 2
14346 52 14347 57 14348 0
14349 0
14350 0
14351 0
14352 0
14353 0
14354 0
14355 1
14356 50 14357 0
14358 0
14359 0
14360 0
14361 35270656 14362 0
14363 0
14364 0
14365 0
14366 0
14367 35270752 14368 0
240/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
14369 0
14370 0
14371 0
14372 0
14373 35270800 14374 0
14375 0
14376 0
14377 0
14378 0
14379 35270848 14380 0
14381 0
14382 0
14383 0
14384 0
14385 35270896 14386 0
14387 0
14388 0
14389 0
14390 0
14391 35270944 14392 0
14393 0
14394 0
14395 0
14396 0
14397 35270992 14398 0
14399 0
14400 0
14401 0
14402 0
14403 35271040 14404 0
14405 0
14406 0
14407 0
14408 0
14409 35271088 14410 0
14411 0
14412 0
14413 0
14414 0
14415 35271136 14416 0
14417 0
14418 0
14419 0
14420 0
14421 35271184 14422 0
14423 0
14424 0
14425 0
14426 0
14427 35271232 14428 0
241/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
14429 0
14430 0
14431 0
14432 0
14433 35271280 14434 0
14435 0
14436 0
14437 0
14438 0
14439 35271328 14440 0
14441 0
14442 0
14443 0
14444 0
14445 35271376 14446 0
14447 0
14448 0
14449 0
14450 0
14451 35271424 14452 0
14453 0
14454 0
14455 0
14456 0
14457 35271472 14458 0
14459 0
14460 0
14461 0
14462 0
14463 35271520 14464 0
14465 0
14466 0
14467 0
14468 0
14469 35271568 14470 0
14471 0
14472 0
14473 0
14474 0
14475 35271616 14476 0
14477 0
14478 0
14479 0
14480 0
14481 35271664 14482 0
14483 0
14484 0
14485 0
14486 0
14487 35271712 14488 0
242/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
14489 0
14490 0
14491 0
14492 0
14493 35271760 14494 0
14495 0
14496 0
14497 0
14498 0
14499 35271808 14500 0
14501 0
14502 0
14503 0
14504 0
14505 35271856 14506 0
14507 0
14508 0
14509 0
14510 0
14511 35271904 14512 0
14513 0
14514 0
14515 0
14516 0
14517 35271952 14518 0
14519 0
14520 0
14521 0
14522 0
14523 35272000 14524 0
14525 0
14526 0
14527 0
14528 0
14529 35272048 14530 0
14531 0
14532 0
14533 0
14534 0
14535 35272096 14536 0
14537 0
14538 0
14539 0
14540 0
14541 35272144 14542 0
14543 0
14544 0
14545 0
14546 0
14547 35272192 14548 0
243/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
14549 0
14550 0
14551 0
14552 0
14553 35272240 14554 0
14555 0
14556 0
14557 0
14558 0
14559 35272288 14560 0
14561 0
14562 0
14563 0
14564 0
14565 35272336 14566 0
14567 0
14568 0
14569 0
14570 0
14571 35272384 14572 0
14573 0
14574 0
14575 0
14576 0
14577 35272432 14578 0
14579 0
14580 0
14581 0
14582 0
14583 35272480 14584 0
14585 0
14586 0
14587 0
14588 0
14589 35272528 14590 0
14591 0
14592 0
14593 0
14594 0
14595 35272576 14596 0
14597 0
14598 0
14599 0
14600 0
14601 35272624 14602 0
14603 0
14604 0
14605 0
14606 0
14607 35272672 14608 0
244/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
14609 0
14610 0
14611 0
14612 0
14613 35272720 14614 0
14615 0
14616 0
14617 0
14618 0
14619 35272768 14620 0
14621 0
14622 0
14623 0
14624 0
14625 35272816 14626 0
14627 0
14628 0
14629 0
14630 0
14631 35272864 14632 0
14633 0
14634 0
14635 0
14636 0
14637 35272912 14638 0
14639 0
14640 0
14641 0
14642 0
14643 35272960 14644 0
14645 0
14646 0
14647 0
14648 0
14649 35273008 14650 0
14651 0
14652 0
14653 0
14654 0
14655 35273056 14656 0
14657 0
14658 0
14659 0
14660 0
14661 35273104 14662 0
14663 0
14664 0
14665 0
14666 0
14667 35273152 14668 0
245/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
14669 0
14670 0
14671 0
14672 0
14673 35273200 14674 0
14675 0
14676 0
14677 0
14678 0
14679 35273248 14680 0
14681 0
14682 0
14683 0
14684 0
14685 35273296 14686 0
14687 0
14688 0
14689 0
14690 0
14691 35273344 14692 0
14693 0
14694 0
14695 0
14696 0
14697 35273392 14698 0
14699 0
14700 0
14701 0
14702 0
14703 35273440 14704 0
14705 0
14706 0
14707 0
14708 0
14709 35273488 14710 0
14711 0
14712 0
14713 0
14714 0
14715 35273536 14716 0
14717 0
14718 0
14719 0
14720 0
14721 35273584 14722 0
14723 0
14724 0
14725 0
14726 0
14727 35273632 14728 0
246/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
14729 0
14730 0
14731 0
14732 0
14733 35273680 14734 0
14735 0
14736 0
14737 0
14738 0
14739 35273728 14740 0
14741 0
14742 0
14743 0
14744 0
14745 35273776 14746 0
14747 0
14748 0
14749 0
14750 0
14751 35273824 14752 0
14753 0
14754 0
14755 0
14756 0
14757 35273872 14758 0
14759 0
14760 0
14761 0
14762 0
14763 35273920 14764 0
14765 0
14766 0
14767 0
14768 0
14769 35273968 14770 0
14771 0
14772 0
14773 0
14774 0
14775 35274016 14776 0
14777 0
14778 0
14779 0
14780 0
14781 35274064 14782 0
14783 0
14784 0
14785 0
14786 0
14787 35274112 14788 0
247/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
14789 0
14790 0
14791 0
14792 0
14793 35274160 14794 0
14795 0
14796 0
14797 0
14798 0
14799 35274208 14800 0
14801 0
14802 0
14803 0
14804 0
14805 35274256 14806 0
14807 0
14808 0
14809 0
14810 0
14811 35274304 14812 0
14813 0
14814 0
14815 0
14816 0
14817 35274352 14818 0
14819 0
14820 0
14821 0
14822 0
14823 35274400 14824 0
14825 0
14826 0
14827 0
14828 0
14829 35274448 14830 0
14831 0
14832 0
14833 0
14834 0
14835 35274496 14836 0
14837 0
14838 0
14839 0
14840 0
14841 35274544 14842 0
14843 0
14844 0
14845 0
14846 0
14847 35274592 14848 0
248/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
14849 0 14850 0 14851 0 14852 0 14853 2 14854 53 14855 51 14856 0 14857 0 14858 0 14859 0 14860 0 14861 1 14862 49 14863 0 14864 0 14865 1 14866 48 14867 0 14868 0 14869 2 14870 53 14871 54 14872 0 14873 2 14874 53 14875 50 14876 0 14877 1 14878 50 14879 0 14880 0 14881 1 14882 48 14883 0 14884 0 14885 1 14886 48 14887 0 14888 0 14889 2 14890 52 14891 56 14892 0 14893 1 14894 49 14895 0 14896 0 14897 1 14898 48 14899 0 14900 0 14901 1 14902 48 14903 0 14904 0 14905 2 14906 52 14907 56 14908 0
249/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
14909 1 14910 49 14911 0 14912 0 14913 1 14914 48 14915 0 14916 0 14917 1 14918 48 14919 0 14920 0 14921 2 14922 52 14923 57 14924 0 14925 1 14926 49 14927 0 14928 0 14929 1 14930 48 14931 0 14932 0 14933 2 14934 53 14935 54 14936 0 14937 2 14938 53 14939 50 14940 0 14941 1 14942 50 14943 0 14944 0 14945 1 14946 48 14947 0 14948 0 14949 1 14950 48 14951 0 14952 0 14953 2 14954 52 14955 56 14956 0 14957 1 14958 49 14959 0 14960 0 14961 1 14962 48 14963 0 14964 0 14965 1 14966 48 14967 0 14968 0
250/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
14969 2 14970 52 14971 56 14972 0 14973 1 14974 49 14975 0 14976 0 14977 1 14978 48 14979 0 14980 0 14981 1 14982 48 14983 0 14984 0 14985 2 14986 52 14987 57 14988 0 14989 1 14990 49 14991 0 14992 0 14993 1 14994 48 14995 0 14996 0 14997 2 14998 53 14999 54 15000 0 15001 2 15002 53 15003 50 15004 0 15005 1 15006 50 15007 0 15008 0 15009 1 15010 48 15011 0 15012 0 15013 1 15014 48 15015 0 15016 0 15017 2 15018 52 15019 56 15020 0 15021 1 15022 49 15023 0 15024 0 15025 1 15026 48 15027 0 15028 0
251/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
15029 1 15030 48 15031 0 15032 0 15033 2 15034 52 15035 56 15036 0 15037 1 15038 49 15039 0 15040 0 15041 1 15042 48 15043 0 15044 0 15045 1 15046 48 15047 0 15048 0 15049 2 15050 52 15051 57 15052 0 15053 1 15054 49 15055 0 15056 0 15057 1 15058 48 15059 0 15060 0 15061 2 15062 53 15063 54 15064 0 15065 2 15066 53 15067 50 15068 0 15069 1 15070 50 15071 0 15072 0 15073 1 15074 48 15075 0 15076 0 15077 1 15078 48 15079 0 15080 0 15081 2 15082 52 15083 56 15084 0 15085 1 15086 49 15087 0 15088 0
252/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
15089 1 15090 48 15091 0 15092 0 15093 1 15094 48 15095 0 15096 0 15097 2 15098 52 15099 56 15100 0 15101 1 15102 49 15103 0 15104 0 15105 1 15106 48 15107 0 15108 0 15109 1 15110 48 15111 0 15112 0 15113 2 15114 52 15115 57 15116 0 15117 1 15118 49 15119 0 15120 0 15121 1 15122 48 15123 0 15124 0 15125 2 15126 53 15127 54 15128 0 15129 2 15130 53 15131 50 15132 0 15133 1 15134 50 15135 0 15136 0 15137 1 15138 48 15139 0 15140 0 15141 1 15142 48 15143 0 15144 0 15145 2 15146 52 15147 56 15148 0
253/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
15149 1 15150 49 15151 0 15152 0 15153 1 15154 48 15155 0 15156 0 15157 1 15158 48 15159 0 15160 0 15161 2 15162 52 15163 56 15164 0 15165 1 15166 49 15167 0 15168 0 15169 1 15170 48 15171 0 15172 0 15173 1 15174 48 15175 0 15176 0 15177 2 15178 52 15179 57 15180 0 15181 1 15182 49 15183 0 15184 0 15185 1 15186 48 15187 0 15188 0 15189 2 15190 53 15191 54 15192 0 15193 2 15194 53 15195 50 15196 0 15197 1 15198 50 15199 0 15200 0 15201 1 15202 48 15203 0 15204 0 15205 1 15206 48 15207 0 15208 0
254/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
15209 2 15210 52 15211 56 15212 0 15213 1 15214 49 15215 0 15216 0 15217 1 15218 48 15219 0 15220 0 15221 1 15222 48 15223 0 15224 0 15225 2 15226 52 15227 56 15228 0 15229 1 15230 49 15231 0 15232 0 15233 1 15234 48 15235 0 15236 0 15237 1 15238 48 15239 0 15240 0 15241 2 15242 52 15243 57 15244 0 15245 1 15246 49 15247 0 15248 0 15249 1 15250 48 15251 0 15252 0 15253 2 15254 53 15255 54 15256 0 15257 2 15258 53 15259 50 15260 0 15261 1 15262 50 15263 0 15264 0 15265 1 15266 48 15267 0 15268 0
255/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
15269 1 15270 48 15271 0 15272 0 15273 2 15274 52 15275 56 15276 0 15277 1 15278 49 15279 0 15280 0 15281 1 15282 48 15283 0 15284 0 15285 1 15286 48 15287 0 15288 0 15289 2 15290 52 15291 56 15292 0 15293 1 15294 49 15295 0 15296 0 15297 1 15298 48 15299 0 15300 0 15301 1 15302 48 15303 0 15304 0 15305 2 15306 52 15307 57 15308 0 15309 1 15310 49 15311 0 15312 0 15313 1 15314 48 15315 0 15316 0 15317 2 15318 53 15319 54 15320 0 15321 2 15322 53 15323 50 15324 0 15325 1 15326 50 15327 0 15328 0
256/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
15329 1 15330 48 15331 0 15332 0 15333 1 15334 48 15335 0 15336 0 15337 2 15338 52 15339 56 15340 0 15341 1 15342 49 15343 0 15344 0 15345 1 15346 48 15347 0 15348 0 15349 1 15350 48 15351 0 15352 0 15353 2 15354 52 15355 56 15356 0 15357 1 15358 49 15359 0 15360 0 15361 1 15362 48 15363 0 15364 0 15365 1 15366 48 15367 0 15368 0 15369 2 15370 52 15371 57 15372 0 15373 1 15374 49 15375 0 15376 0 15377 1 15378 48 15379 0 15380 0 15381 2 15382 53 15383 54 15384 0 15385 2 15386 53 15387 50 15388 0
257/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
15389 1 15390 50 15391 0 15392 0 15393 1 15394 48 15395 0 15396 0 15397 1 15398 48 15399 0 15400 0 15401 2 15402 52 15403 56 15404 0 15405 1 15406 49 15407 0 15408 0 15409 1 15410 48 15411 0 15412 0 15413 1 15414 48 15415 0 15416 0 15417 2 15418 52 15419 56 15420 0 15421 1 15422 49 15423 0 15424 0 15425 1 15426 48 15427 0 15428 0 15429 1 15430 48 15431 0 15432 0 15433 2 15434 52 15435 57 15436 0 15437 1 15438 49 15439 0 15440 0 15441 1 15442 48 15443 0 15444 0 15445 2 15446 53 15447 54 15448 0
258/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
15449 2 15450 53 15451 50 15452 0 15453 1 15454 50 15455 0 15456 0 15457 1 15458 48 15459 0 15460 0 15461 1 15462 48 15463 0 15464 0 15465 2 15466 52 15467 56 15468 0 15469 1 15470 49 15471 0 15472 0 15473 1 15474 48 15475 0 15476 0 15477 1 15478 48 15479 0 15480 0 15481 2 15482 52 15483 56 15484 0 15485 1 15486 49 15487 0 15488 0 15489 1 15490 48 15491 0 15492 0 15493 1 15494 48 15495 0 15496 0 15497 2 15498 52 15499 57 15500 0 15501 1 15502 49 15503 0 15504 0 15505 1 15506 48 15507 0 15508 0
259/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
15509 2 15510 53 15511 54 15512 0 15513 2 15514 53 15515 50 15516 0 15517 1 15518 50 15519 0 15520 0 15521 1 15522 48 15523 0 15524 0 15525 1 15526 48 15527 0 15528 0 15529 2 15530 52 15531 56 15532 0 15533 1 15534 49 15535 0 15536 0 15537 1 15538 48 15539 0 15540 0 15541 1 15542 48 15543 0 15544 0 15545 2 15546 52 15547 56 15548 0 15549 1 15550 49 15551 0 15552 0 15553 1 15554 48 15555 0 15556 0 15557 1 15558 48 15559 0 15560 0 15561 2 15562 52 15563 57 15564 0 15565 1 15566 49 15567 0 15568 0
260/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
15569 1 15570 48 15571 0 15572 0 15573 2 15574 53 15575 54 15576 0 15577 2 15578 53 15579 50 15580 0 15581 1 15582 50 15583 0 15584 0 15585 1 15586 48 15587 0 15588 0 15589 1 15590 48 15591 0 15592 0 15593 2 15594 52 15595 56 15596 0 15597 1 15598 49 15599 0 15600 0 15601 1 15602 48 15603 0 15604 0 15605 1 15606 48 15607 0 15608 0 15609 2 15610 52 15611 56 15612 0 15613 1 15614 49 15615 0 15616 0 15617 1 15618 48 15619 0 15620 0 15621 1 15622 48 15623 0 15624 0 15625 2 15626 52 15627 57 15628 0
261/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
15629 1 15630 49 15631 0 15632 0 15633 1 15634 48 15635 0 15636 0 15637 2 15638 53 15639 54 15640 0 15641 2 15642 53 15643 50 15644 0 15645 1 15646 50 15647 0 15648 0 15649 1 15650 48 15651 0 15652 0 15653 1 15654 48 15655 0 15656 0 15657 2 15658 52 15659 56 15660 0 15661 1 15662 49 15663 0 15664 0 15665 1 15666 48 15667 0 15668 0 15669 1 15670 48 15671 0 15672 0 15673 2 15674 52 15675 56 15676 0 15677 1 15678 49 15679 0 15680 0 15681 1 15682 48 15683 0 15684 0 15685 1 15686 48 15687 0 15688 0
262/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
15689 2 15690 52 15691 57 15692 0 15693 1 15694 49 15695 0 15696 0 15697 1 15698 48 15699 0 15700 0 15701 2 15702 53 15703 54 15704 0 15705 2 15706 53 15707 50 15708 0 15709 1 15710 50 15711 0 15712 0 15713 1 15714 48 15715 0 15716 0 15717 1 15718 48 15719 0 15720 0 15721 2 15722 52 15723 56 15724 0 15725 1 15726 49 15727 0 15728 0 15729 1 15730 48 15731 0 15732 0 15733 1 15734 48 15735 0 15736 0 15737 2 15738 52 15739 56 15740 0 15741 1 15742 49 15743 0 15744 0 15745 1 15746 48 15747 0 15748 0
263/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
15749 1 15750 48 15751 0 15752 0 15753 2 15754 52 15755 57 15756 0 15757 1 15758 49 15759 0 15760 0 15761 1 15762 48 15763 0 15764 0 15765 2 15766 53 15767 54 15768 0 15769 2 15770 53 15771 50 15772 0 15773 1 15774 50 15775 0 15776 0 15777 1 15778 48 15779 0 15780 0 15781 1 15782 48 15783 0 15784 0 15785 2 15786 52 15787 56 15788 0 15789 1 15790 49 15791 0 15792 0 15793 1 15794 48 15795 0 15796 0 15797 1 15798 48 15799 0 15800 0 15801 2 15802 52 15803 56 15804 0 15805 1 15806 49 15807 0 15808 0
264/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
15809 1 15810 48 15811 0 15812 0 15813 1 15814 48 15815 0 15816 0 15817 2 15818 52 15819 57 15820 0 15821 1 15822 49 15823 0 15824 0 15825 1 15826 48 15827 0 15828 0 15829 2 15830 53 15831 54 15832 0 15833 2 15834 53 15835 50 15836 0 15837 1 15838 50 15839 0 15840 0 15841 1 15842 48 15843 0 15844 0 15845 1 15846 48 15847 0 15848 0 15849 2 15850 52 15851 56 15852 0 15853 1 15854 49 15855 0 15856 0 15857 1 15858 48 15859 0 15860 0 15861 1 15862 48 15863 0 15864 0 15865 2 15866 52 15867 56 15868 0
265/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
15869 1 15870 49 15871 0 15872 0 15873 1 15874 48 15875 0 15876 0 15877 1 15878 48 15879 0 15880 0 15881 2 15882 52 15883 57 15884 0 15885 1 15886 49 15887 0 15888 0 15889 1 15890 48 15891 0 15892 0 15893 2 15894 53 15895 54 15896 0 15897 2 15898 53 15899 50 15900 0 15901 1 15902 50 15903 0 15904 0 15905 1 15906 48 15907 0 15908 0 15909 1 15910 48 15911 0 15912 0 15913 2 15914 52 15915 56 15916 0 15917 1 15918 49 15919 0 15920 0 15921 1 15922 48 15923 0 15924 0 15925 1 15926 48 15927 0 15928 0
266/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
15929 2 15930 52 15931 56 15932 0 15933 1 15934 49 15935 0 15936 0 15937 1 15938 48 15939 0 15940 0 15941 1 15942 48 15943 0 15944 0 15945 2 15946 52 15947 57 15948 0 15949 1 15950 49 15951 0 15952 0 15953 1 15954 48 15955 0 15956 0 15957 2 15958 53 15959 54 15960 0 15961 2 15962 53 15963 50 15964 0 15965 1 15966 50 15967 0 15968 0 15969 1 15970 48 15971 0 15972 0 15973 1 15974 48 15975 0 15976 0 15977 2 15978 52 15979 56 15980 0 15981 1 15982 49 15983 0 15984 0 15985 1 15986 48 15987 0 15988 0
267/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
15989 1 15990 48 15991 0 15992 0 15993 2 15994 52 15995 56 15996 0 15997 1 15998 49 15999 0 16000 0 16001 1 16002 48 16003 0 16004 0 16005 1 16006 48 16007 0 16008 0 16009 2 16010 52 16011 57 16012 0 16013 1 16014 49 16015 0 16016 0 16017 1 16018 48 16019 0 16020 0 16021 2 16022 53 16023 54 16024 0 16025 2 16026 53 16027 50 16028 0 16029 1 16030 50 16031 0 16032 0 16033 1 16034 48 16035 0 16036 0 16037 1 16038 48 16039 0 16040 0 16041 2 16042 52 16043 56 16044 0 16045 1 16046 49 16047 0 16048 0
268/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
16049 1 16050 48 16051 0 16052 0 16053 1 16054 48 16055 0 16056 0 16057 2 16058 52 16059 56 16060 0 16061 1 16062 49 16063 0 16064 0 16065 1 16066 48 16067 0 16068 0 16069 1 16070 48 16071 0 16072 0 16073 2 16074 52 16075 57 16076 0 16077 1 16078 49 16079 0 16080 0 16081 1 16082 48 16083 0 16084 0 16085 2 16086 53 16087 54 16088 0 16089 2 16090 53 16091 50 16092 0 16093 1 16094 50 16095 0 16096 0 16097 1 16098 48 16099 0 16100 0 16101 1 16102 48 16103 0 16104 0 16105 2 16106 52 16107 56 16108 0
269/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
16109 1 16110 49 16111 0 16112 0 16113 1 16114 48 16115 0 16116 0 16117 1 16118 48 16119 0 16120 0 16121 2 16122 52 16123 56 16124 0 16125 1 16126 49 16127 0 16128 0 16129 1 16130 48 16131 0 16132 0 16133 1 16134 48 16135 0 16136 0 16137 2 16138 52 16139 57 16140 0 16141 1 16142 49 16143 0 16144 0 16145 1 16146 48 16147 0 16148 0 16149 2 16150 53 16151 54 16152 0 16153 2 16154 53 16155 50 16156 0 16157 1 16158 50 16159 0 16160 0 16161 1 16162 48 16163 0 16164 0 16165 1 16166 48 16167 0 16168 0
270/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
16169 2 16170 52 16171 56 16172 0 16173 1 16174 49 16175 0 16176 0 16177 1 16178 48 16179 0 16180 0 16181 1 16182 48 16183 0 16184 0 16185 2 16186 52 16187 56 16188 0 16189 1 16190 49 16191 0 16192 0 16193 1 16194 48 16195 0 16196 0 16197 1 16198 48 16199 0 16200 0 16201 2 16202 52 16203 57 16204 0 16205 1 16206 49 16207 0 16208 0 16209 1 16210 48 16211 0 16212 0 16213 2 16214 53 16215 54 16216 0 16217 2 16218 53 16219 50 16220 0 16221 1 16222 50 16223 0 16224 0 16225 1 16226 48 16227 0 16228 0
271/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
16229 1 16230 48 16231 0 16232 0 16233 2 16234 52 16235 56 16236 0 16237 1 16238 49 16239 0 16240 0 16241 1 16242 48 16243 0 16244 0 16245 1 16246 48 16247 0 16248 0 16249 2 16250 52 16251 56 16252 0 16253 1 16254 49 16255 0 16256 0 16257 1 16258 48 16259 0 16260 0 16261 1 16262 48 16263 0 16264 0 16265 2 16266 52 16267 57 16268 0 16269 1 16270 49 16271 0 16272 0 16273 1 16274 48 16275 0 16276 0 16277 2 16278 53 16279 54 16280 0 16281 2 16282 53 16283 50 16284 0 16285 1 16286 50 16287 0 16288 0
272/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
16289 1 16290 48 16291 0 16292 0 16293 1 16294 48 16295 0 16296 0 16297 2 16298 52 16299 56 16300 0 16301 1 16302 49 16303 0 16304 0 16305 1 16306 48 16307 0 16308 0 16309 1 16310 48 16311 0 16312 0 16313 2 16314 52 16315 56 16316 0 16317 1 16318 49 16319 0 16320 0 16321 1 16322 48 16323 0 16324 0 16325 1 16326 48 16327 0 16328 0 16329 2 16330 52 16331 57 16332 0 16333 1 16334 49 16335 0 16336 0 16337 1 16338 48 16339 0 16340 0 16341 2 16342 53 16343 54 16344 0 16345 2 16346 53 16347 50 16348 0
273/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
16349 1 16350 50 16351 0 16352 0 16353 1 16354 48 16355 0 16356 0 16357 1 16358 48 16359 0 16360 0 16361 2 16362 52 16363 56 16364 0 16365 1 16366 49 16367 0 16368 0 16369 1 16370 48 16371 0 16372 0 16373 1 16374 48 16375 0 16376 0 16377 2 16378 52 16379 56 16380 0 16381 1 16382 49 16383 0 16384 0 16385 1 16386 48 16387 0 16388 0 16389 1 16390 48 16391 0 16392 0 16393 2 16394 52 16395 57 16396 0 16397 1 16398 49 16399 0 16400 0 16401 1 16402 48 16403 0 16404 0 16405 2 16406 53 16407 54 16408 0
274/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
16409 2 16410 53 16411 50 16412 0 16413 1 16414 50 16415 0 16416 0 16417 1 16418 48 16419 0 16420 0 16421 1 16422 48 16423 0 16424 0 16425 2 16426 52 16427 56 16428 0 16429 1 16430 49 16431 0 16432 0 16433 1 16434 48 16435 0 16436 0 16437 1 16438 48 16439 0 16440 0 16441 2 16442 52 16443 56 16444 0 16445 1 16446 49 16447 0 16448 0 16449 1 16450 48 16451 0 16452 0 16453 1 16454 48 16455 0 16456 0 16457 2 16458 52 16459 57 16460 0 16461 1 16462 49 16463 0 16464 0 16465 1 16466 48 16467 0 16468 0
275/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
16469 2 16470 53 16471 54 16472 0 16473 2 16474 53 16475 50 16476 0 16477 1 16478 50 16479 0 16480 0 16481 1 16482 48 16483 0 16484 0 16485 1 16486 48 16487 0 16488 0 16489 2 16490 52 16491 56 16492 0 16493 1 16494 49 16495 0 16496 0 16497 1 16498 48 16499 0 16500 0 16501 1 16502 48 16503 0 16504 0 16505 2 16506 52 16507 56 16508 0 16509 1 16510 49 16511 0 16512 0 16513 1 16514 48 16515 0 16516 0 16517 1 16518 48 16519 0 16520 0 16521 2 16522 52 16523 57 16524 0 16525 1 16526 49 16527 0 16528 0
276/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
16529 1 16530 48 16531 0 16532 0 16533 2 16534 53 16535 54 16536 0 16537 2 16538 53 16539 50 16540 0 16541 1 16542 50 16543 0 16544 0 16545 1 16546 48 16547 0 16548 0 16549 1 16550 48 16551 0 16552 0 16553 2 16554 52 16555 56 16556 0 16557 1 16558 49 16559 0 16560 0 16561 1 16562 48 16563 0 16564 0 16565 1 16566 48 16567 0 16568 0 16569 2 16570 52 16571 56 16572 0 16573 1 16574 49 16575 0 16576 0 16577 1 16578 48 16579 0 16580 0 16581 1 16582 48 16583 0 16584 0 16585 2 16586 52 16587 57 16588 0
277/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
16589 1 16590 49 16591 0 16592 0 16593 1 16594 48 16595 0 16596 0 16597 2 16598 53 16599 54 16600 0 16601 2 16602 53 16603 50 16604 0 16605 1 16606 50 16607 0 16608 0 16609 1 16610 48 16611 0 16612 0 16613 1 16614 48 16615 0 16616 0 16617 2 16618 52 16619 56 16620 0 16621 1 16622 49 16623 0 16624 0 16625 1 16626 48 16627 0 16628 0 16629 1 16630 48 16631 0 16632 0 16633 2 16634 52 16635 56 16636 0 16637 1 16638 49 16639 0 16640 0 16641 1 16642 48 16643 0 16644 0 16645 1 16646 48 16647 0 16648 0
278/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
16649 2 16650 52 16651 57 16652 0 16653 1 16654 49 16655 0 16656 0 16657 1 16658 48 16659 0 16660 0 16661 2 16662 53 16663 54 16664 0 16665 2 16666 53 16667 50 16668 0 16669 1 16670 50 16671 0 16672 0 16673 1 16674 48 16675 0 16676 0 16677 1 16678 48 16679 0 16680 0 16681 2 16682 52 16683 56 16684 0 16685 1 16686 49 16687 0 16688 0 16689 1 16690 48 16691 0 16692 0 16693 1 16694 48 16695 0 16696 0 16697 2 16698 52 16699 56 16700 0 16701 1 16702 49 16703 0 16704 0 16705 1 16706 48 16707 0 16708 0
279/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
16709 1 16710 48 16711 0 16712 0 16713 2 16714 52 16715 57 16716 0 16717 1 16718 49 16719 0 16720 0 16721 1 16722 48 16723 0 16724 0 16725 2 16726 53 16727 54 16728 0 16729 2 16730 53 16731 50 16732 0 16733 1 16734 50 16735 0 16736 0 16737 1 16738 48 16739 0 16740 0 16741 1 16742 48 16743 0 16744 0 16745 2 16746 52 16747 56 16748 0 16749 1 16750 49 16751 0 16752 0 16753 1 16754 48 16755 0 16756 0 16757 1 16758 48 16759 0 16760 0 16761 2 16762 52 16763 56 16764 0 16765 1 16766 49 16767 0 16768 0
280/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
16769 1 16770 48 16771 0 16772 0 16773 1 16774 48 16775 0 16776 0 16777 2 16778 52 16779 57 16780 0 16781 1 16782 49 16783 0 16784 0 16785 1 16786 48 16787 0 16788 0 16789 2 16790 53 16791 54 16792 0 16793 2 16794 53 16795 50 16796 0 16797 1 16798 50 16799 0 16800 0 16801 1 16802 48 16803 0 16804 0 16805 1 16806 48 16807 0 16808 0 16809 2 16810 52 16811 56 16812 0 16813 1 16814 49 16815 0 16816 0 16817 1 16818 48 16819 0 16820 0 16821 1 16822 48 16823 0 16824 0 16825 2 16826 52 16827 56 16828 0
281/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
16829 1 16830 49 16831 0 16832 0 16833 1 16834 48 16835 0 16836 0 16837 1 16838 48 16839 0 16840 0 16841 2 16842 52 16843 57 16844 0 16845 1 16846 49 16847 0 16848 0 16849 1 16850 48 16851 0 16852 0 16853 2 16854 53 16855 54 16856 0 16857 2 16858 53 16859 50 16860 0 16861 1 16862 50 16863 0 16864 0 16865 1 16866 48 16867 0 16868 0 16869 1 16870 48 16871 0 16872 0 16873 2 16874 52 16875 56 16876 0 16877 1 16878 49 16879 0 16880 0 16881 1 16882 48 16883 0 16884 0 16885 1 16886 48 16887 0 16888 0
282/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
16889 2 16890 52 16891 56 16892 0 16893 1 16894 49 16895 0 16896 0 16897 1 16898 48 16899 0 16900 0 16901 1 16902 48 16903 0 16904 0 16905 2 16906 52 16907 57 16908 0 16909 1 16910 49 16911 0 16912 0 16913 1 16914 48 16915 0 16916 0 16917 2 16918 53 16919 54 16920 0 16921 2 16922 53 16923 50 16924 0 16925 1 16926 50 16927 0 16928 0 16929 1 16930 48 16931 0 16932 0 16933 1 16934 48 16935 0 16936 0 16937 2 16938 52 16939 56 16940 0 16941 1 16942 49 16943 0 16944 0 16945 1 16946 48 16947 0 16948 0
283/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
16949 1 16950 48 16951 0 16952 0 16953 2 16954 52 16955 56 16956 0 16957 1 16958 49 16959 0 16960 0 16961 1 16962 48 16963 0 16964 0 16965 1 16966 48 16967 0 16968 0 16969 2 16970 52 16971 57 16972 0 16973 1 16974 49 16975 0 16976 0 16977 1 16978 48 16979 0 16980 0 16981 2 16982 53 16983 54 16984 0 16985 2 16986 53 16987 50 16988 0 16989 1 16990 50 16991 0 16992 0 16993 1 16994 48 16995 0 16996 0 16997 1 16998 48 16999 0 17000 0 17001 2 17002 52 17003 56 17004 0 17005 1 17006 49 17007 0 17008 0
284/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
17009 1 17010 48 17011 0 17012 0 17013 1 17014 48 17015 0 17016 0 17017 2 17018 52 17019 56 17020 0 17021 1 17022 49 17023 0 17024 0 17025 1 17026 48 17027 0 17028 0 17029 1 17030 48 17031 0 17032 0 17033 2 17034 52 17035 57 17036 0 17037 1 17038 49 17039 0 17040 0 17041 1 17042 48 17043 0 17044 0 17045 2 17046 53 17047 54 17048 0 17049 2 17050 53 17051 50 17052 0 17053 1 17054 50 17055 0 17056 0 17057 1 17058 48 17059 0 17060 0 17061 1 17062 48 17063 0 17064 0 17065 2 17066 52 17067 56 17068 0
285/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
17069 1 17070 49 17071 0 17072 0 17073 1 17074 48 17075 0 17076 0 17077 1 17078 48 17079 0 17080 0 17081 2 17082 52 17083 56 17084 0 17085 1 17086 49 17087 0 17088 0 17089 1 17090 48 17091 0 17092 0 17093 1 17094 48 17095 0 17096 0 17097 2 17098 52 17099 57 17100 0 17101 1 17102 49 17103 0 17104 0 17105 1 17106 48 17107 0 17108 0 17109 2 17110 53 17111 54 17112 0 17113 2 17114 53 17115 50 17116 0 17117 1 17118 50 17119 0 17120 0 17121 1 17122 48 17123 0 17124 0 17125 1 17126 48 17127 0 17128 0
286/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
17129 2 17130 52 17131 56 17132 0 17133 1 17134 49 17135 0 17136 0 17137 1 17138 48 17139 0 17140 0 17141 1 17142 48 17143 0 17144 0 17145 2 17146 52 17147 56 17148 0 17149 1 17150 49 17151 0 17152 0 17153 1 17154 48 17155 0 17156 0 17157 1 17158 48 17159 0 17160 0 17161 2 17162 52 17163 57 17164 0 17165 1 17166 49 17167 0 17168 0 17169 1 17170 48 17171 0 17172 0 17173 2 17174 53 17175 54 17176 0 17177 2 17178 53 17179 50 17180 0 17181 1 17182 50 17183 0 17184 0 17185 1 17186 48 17187 0 17188 0
287/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
17189 1 17190 48 17191 0 17192 0 17193 2 17194 52 17195 56 17196 0 17197 1 17198 49 17199 0 17200 0 17201 1 17202 48 17203 0 17204 0 17205 1 17206 48 17207 0 17208 0 17209 2 17210 52 17211 56 17212 0 17213 1 17214 49 17215 0 17216 0 17217 1 17218 48 17219 0 17220 0 17221 1 17222 48 17223 0 17224 0 17225 2 17226 52 17227 57 17228 0 17229 1 17230 49 17231 0 17232 0 17233 1 17234 48 17235 0 17236 0 17237 2 17238 53 17239 54 17240 0 17241 2 17242 53 17243 50 17244 0 17245 1 17246 50 17247 0 17248 0
288/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
17249 1 17250 48 17251 0 17252 0 17253 1 17254 48 17255 0 17256 0 17257 2 17258 52 17259 56 17260 0 17261 1 17262 49 17263 0 17264 0 17265 1 17266 48 17267 0 17268 0 17269 1 17270 48 17271 0 17272 0 17273 2 17274 52 17275 56 17276 0 17277 1 17278 49 17279 0 17280 0 17281 1 17282 48 17283 0 17284 0 17285 1 17286 48 17287 0 17288 0 17289 2 17290 52 17291 57 17292 0 17293 1 17294 49 17295 0 17296 0 17297 1 17298 48 17299 0 17300 0 17301 2 17302 53 17303 54 17304 0 17305 2 17306 53 17307 50 17308 0
289/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
17309 1 17310 50 17311 0 17312 0 17313 1 17314 48 17315 0 17316 0 17317 1 17318 48 17319 0 17320 0 17321 2 17322 52 17323 56 17324 0 17325 1 17326 49 17327 0 17328 0 17329 1 17330 48 17331 0 17332 0 17333 1 17334 48 17335 0 17336 0 17337 2 17338 52 17339 56 17340 0 17341 1 17342 49 17343 0 17344 0 17345 1 17346 48 17347 0 17348 0 17349 1 17350 48 17351 0 17352 0 17353 2 17354 52 17355 57 17356 0 17357 1 17358 49 17359 0 17360 0 17361 1 17362 48 17363 0 17364 0 17365 2 17366 53 17367 54 17368 0
290/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
17369 2 17370 53 17371 50 17372 0 17373 1 17374 50 17375 0 17376 0 17377 1 17378 48 17379 0 17380 0 17381 1 17382 48 17383 0 17384 0 17385 2 17386 52 17387 56 17388 0 17389 1 17390 49 17391 0 17392 0 17393 1 17394 48 17395 0 17396 0 17397 1 17398 48 17399 0 17400 0 17401 2 17402 52 17403 56 17404 0 17405 1 17406 49 17407 0 17408 0 17409 1 17410 48 17411 0 17412 0 17413 1 17414 48 17415 0 17416 0 17417 2 17418 52 17419 57 17420 0 17421 1 17422 49 17423 0 17424 0 17425 1 17426 48 17427 0 17428 0
291/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
17429 2 17430 53 17431 48 17432 0 17433 2 17434 53 17435 51 17436 0 17437 1 17438 50 17439 0 17440 0 17441 1 17442 48 17443 0 17444 0 17445 2 17446 53 17447 52 17448 0 17449 2 17450 53 17451 51 17452 0 17453 1 17454 50 17455 0 17456 0 17457 1 17458 48 17459 0 17460 0 17461 1 17462 48 17463 0 17464 0 17465 2 17466 52 17467 56 17468 0 17469 1 17470 49 17471 0 17472 0 17473 1 17474 48 17475 0 17476 0 17477 1 17478 48 17479 0 17480 0 17481 2 17482 52 17483 57 17484 0 17485 1 17486 49 17487 0 17488 0
292/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
17489 1 17490 48 17491 0 17492 0 17493 2 17494 53 17495 55 17496 0 17497 2 17498 53 17499 50 17500 0 17501 1 17502 50 17503 0 17504 0 17505 1 17506 48 17507 0 17508 0 17509 1 17510 48 17511 0 17512 0 17513 2 17514 52 17515 56 17516 0 17517 1 17518 49 17519 0 17520 0 17521 1 17522 48 17523 0 17524 0 17525 1 17526 48 17527 0 17528 0 17529 2 17530 52 17531 56 17532 0 17533 1 17534 49 17535 0 17536 0 17537 1 17538 48 17539 0 17540 0 17541 1 17542 48 17543 0 17544 0 17545 2 17546 52 17547 57 17548 0
293/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
17549 1 17550 49 17551 0 17552 0 17553 1 17554 48 17555 0 17556 0 17557 2 17558 53 17559 54 17560 0 17561 2 17562 53 17563 50 17564 0 17565 1 17566 50 17567 0 17568 0 17569 1 17570 48 17571 0 17572 0 17573 1 17574 48 17575 0 17576 0 17577 2 17578 52 17579 56 17580 0 17581 1 17582 49 17583 0 17584 0 17585 1 17586 48 17587 0 17588 0 17589 1 17590 48 17591 0 17592 0 17593 2 17594 52 17595 56 17596 0 17597 1 17598 49 17599 0 17600 0 17601 1 17602 48 17603 0 17604 0 17605 1 17606 48 17607 0 17608 0
294/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
17609 2 17610 52 17611 57 17612 0 17613 1 17614 49 17615 0 17616 0 17617 1 17618 48 17619 0 17620 0 17621 2 17622 53 17623 54 17624 0 17625 2 17626 53 17627 50 17628 0 17629 1 17630 50 17631 0 17632 0 17633 1 17634 48 17635 0 17636 0 17637 1 17638 48 17639 0 17640 0 17641 2 17642 52 17643 56 17644 0 17645 1 17646 49 17647 0 17648 0 17649 1 17650 48 17651 0 17652 0 17653 1 17654 48 17655 0 17656 0 17657 2 17658 52 17659 56 17660 0 17661 1 17662 49 17663 0 17664 0 17665 1 17666 48 17667 0 17668 0
295/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
17669 1 17670 48 17671 0 17672 0 17673 2 17674 53 17675 48 17676 0 17677 1 17678 49 17679 0 17680 0 17681 1 17682 48 17683 0 17684 0 17685 2 17686 53 17687 48 17688 0 17689 2 17690 53 17691 51 17692 0 17693 1 17694 50 17695 0 17696 0 17697 1 17698 48 17699 0 17700 0 17701 2 17702 53 17703 52 17704 0 17705 2 17706 53 17707 51 17708 0 17709 1 17710 50 17711 0 17712 0 17713 1 17714 48 17715 0 17716 0 17717 1 17718 48 17719 0 17720 0 17721 2 17722 52 17723 56 17724 0 17725 1 17726 49 17727 0 17728 0
296/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
17729 1 17730 48 17731 0 17732 0 17733 1 17734 48 17735 0 17736 0 17737 2 17738 52 17739 57 17740 0 17741 1 17742 49 17743 0 17744 0 17745 1 17746 48 17747 0 17748 0 17749 2 17750 53 17751 54 17752 0 17753 2 17754 53 17755 50 17756 0 17757 1 17758 50 17759 0 17760 0 17761 1 17762 48 17763 0 17764 0 17765 1 17766 48 17767 0 17768 0 17769 2 17770 52 17771 56 17772 0 17773 1 17774 49 17775 0 17776 0 17777 1 17778 48 17779 0 17780 0 17781 1 17782 48 17783 0 17784 0 17785 2 17786 52 17787 56 17788 0
297/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
17789 1 17790 49 17791 0 17792 0 17793 1 17794 48 17795 0 17796 0 17797 1 17798 48 17799 0 17800 0 17801 2 17802 52 17803 57 17804 0 17805 1 17806 49 17807 0 17808 0 17809 1 17810 48 17811 0 17812 0 17813 2 17814 53 17815 54 17816 0 17817 2 17818 53 17819 50 17820 0 17821 1 17822 50 17823 0 17824 0 17825 1 17826 48 17827 0 17828 0 17829 1 17830 48 17831 0 17832 0 17833 2 17834 52 17835 56 17836 0 17837 1 17838 49 17839 0 17840 0 17841 1 17842 48 17843 0 17844 0 17845 1 17846 48 17847 0 17848 0
298/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
17849 2 17850 52 17851 56 17852 0 17853 1 17854 49 17855 0 17856 0 17857 1 17858 48 17859 0 17860 0 17861 1 17862 48 17863 0 17864 0 17865 2 17866 52 17867 57 17868 0 17869 1 17870 49 17871 0 17872 0 17873 1 17874 48 17875 0 17876 0 17877 2 17878 53 17879 54 17880 0 17881 2 17882 53 17883 50 17884 0 17885 1 17886 50 17887 0 17888 0 17889 1 17890 48 17891 0 17892 0 17893 1 17894 48 17895 0 17896 0 17897 2 17898 52 17899 56 17900 0 17901 1 17902 49 17903 0 17904 0 17905 1 17906 48 17907 0 17908 0
299/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
17909 1 17910 48 17911 0 17912 0 17913 2 17914 52 17915 56 17916 0 17917 1 17918 49 17919 0 17920 0 17921 1 17922 48 17923 0 17924 0 17925 1 17926 48 17927 0 17928 0 17929 2 17930 52 17931 57 17932 0 17933 1 17934 49 17935 0 17936 0 17937 1 17938 48 17939 0 17940 0 17941 2 17942 53 17943 48 17944 0 17945 2 17946 53 17947 51 17948 0 17949 1 17950 50 17951 0 17952 0 17953 1 17954 48 17955 0 17956 0 17957 2 17958 53 17959 52 17960 0 17961 2 17962 53 17963 51 17964 0 17965 1 17966 50 17967 0 17968 0
300/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
17969 1 17970 48 17971 0 17972 0 17973 1 17974 48 17975 0 17976 0 17977 2 17978 52 17979 56 17980 0 17981 1 17982 49 17983 0 17984 0 17985 1 17986 48 17987 0 17988 0 17989 1 17990 48 17991 0 17992 0 17993 2 17994 52 17995 57 17996 0 17997 1 17998 49 17999 0 18000 0 18001 1 18002 48 18003 0 18004 0 18005 2 18006 53 18007 55 18008 0 18009 2 18010 53 18011 50 18012 0 18013 1 18014 50 18015 0 18016 0 18017 1 18018 48 18019 0 18020 0 18021 1 18022 48 18023 0 18024 0 18025 2 18026 52 18027 56 18028 0
301/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
18029 1 18030 49 18031 0 18032 0 18033 1 18034 48 18035 0 18036 0 18037 1 18038 48 18039 0 18040 0 18041 2 18042 52 18043 56 18044 0 18045 1 18046 49 18047 0 18048 0 18049 1 18050 48 18051 0 18052 0 18053 1 18054 48 18055 0 18056 0 18057 2 18058 52 18059 57 18060 0 18061 1 18062 49 18063 0 18064 0 18065 1 18066 48 18067 0 18068 0 18069 2 18070 53 18071 54 18072 0 18073 2 18074 53 18075 50 18076 0 18077 1 18078 50 18079 0 18080 0 18081 1 18082 48 18083 0 18084 0 18085 1 18086 48 18087 0 18088 0
302/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
18089 2 18090 52 18091 56 18092 0 18093 1 18094 49 18095 0 18096 0 18097 1 18098 48 18099 0 18100 0 18101 1 18102 48 18103 0 18104 0 18105 2 18106 52 18107 56 18108 0 18109 1 18110 49 18111 0 18112 0 18113 1 18114 48 18115 0 18116 0 18117 1 18118 48 18119 0 18120 0 18121 2 18122 52 18123 57 18124 0 18125 1 18126 49 18127 0 18128 0 18129 1 18130 48 18131 0 18132 0 18133 2 18134 53 18135 54 18136 0 18137 2 18138 53 18139 50 18140 0 18141 1 18142 50 18143 0 18144 0 18145 1 18146 48 18147 0 18148 0
303/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
18149 1
18150 48 18151 0
18152 0
18153 2
18154 52 18155 56 18156 0
18157 1
18158 49 18159 0
18160 0
18161 1
18162 48 18163 0
18164 0
18165 1
18166 48 18167 0
18168 0
18169 2
18170 52 18171 56 18172 0
18173 1
18174 49 18175 0
18176 0
18177 1
18178 48 18179 0
18180 0
18181 35301280 18182 0
18183 0
18184 0
18185 35301312 18186 0
18187 0
18188 0
18189 35301344 18190 0
18191 0
18192 0
18193 35301376 18194 0
18195 0
18196 0
18197 35301408 18198 0
18199 0
18200 0
18201 35301440 18202 0
18203 0
18204 0
18205 35301472 18206 0
18207 0
18208 0
304/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
18209 35301504 18210 0
18211 0
18212 0
18213 35301536 18214 0
18215 0
18216 0
18217 35301568 18218 0
18219 0
18220 0
18221 35301600 18222 0
18223 0
18224 0
18225 35301632 18226 0
18227 0
18228 0
18229 35301664 18230 0
18231 0
18232 0
18233 35301696 18234 0
18235 0
18236 0
18237 35301728 18238 0
18239 0
18240 0
18241 35301760 18242 0
18243 0
18244 0
18245 1 18246 48 18247 0 18248 0 18249 1 18250 48 18251 0 18252 0 18253 1 18254 48 18255 0 18256 0 18257 1 18258 48 18259 0 18260 0 18261 1 18262 48 18263 0 18264 0 18265 1 18266 48 18267 0 18268 0
305/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
18269 1 18270 48 18271 0 18272 0 18273 1 18274 48 18275 0 18276 0 18277 1 18278 48 18279 0 18280 0 18281 1 18282 48 18283 0 18284 0 18285 1 18286 48 18287 0 18288 0 18289 1 18290 48 18291 0 18292 0 18293 1 18294 48 18295 0 18296 0 18297 1 18298 48 18299 0 18300 0 18301 1 18302 48 18303 0 18304 0 18305 1 18306 48 18307 0 18308 0 18309 1 18310 48 18311 0 18312 0 18313 1 18314 48 18315 0 18316 0 18317 1 18318 48 18319 0 18320 0 18321 1 18322 48 18323 0 18324 0 18325 1 18326 48 18327 0 18328 0
306/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
18329 1 18330 48 18331 0 18332 0 18333 1 18334 48 18335 0 18336 0 18337 1 18338 48 18339 0 18340 0 18341 1 18342 48 18343 0 18344 0 18345 1 18346 48 18347 0 18348 0 18349 1 18350 48 18351 0 18352 0 18353 1 18354 48 18355 0 18356 0 18357 1 18358 48 18359 0 18360 0 18361 1 18362 48 18363 0 18364 0 18365 1 18366 48 18367 0 18368 0 18369 1 18370 48 18371 0 18372 0 18373 1 18374 48 18375 0 18376 0 18377 1 18378 48 18379 0 18380 0 18381 1 18382 48 18383 0 18384 0 18385 1 18386 48 18387 0 18388 0
307/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
18389 1 18390 48 18391 0 18392 0 18393 1 18394 48 18395 0 18396 0 18397 1 18398 48 18399 0 18400 0 18401 1 18402 48 18403 0 18404 0 18405 1 18406 48 18407 0 18408 0 18409 1 18410 48 18411 0 18412 0 18413 1 18414 48 18415 0 18416 0 18417 1 18418 48 18419 0 18420 0 18421 1 18422 48 18423 0 18424 0 18425 1 18426 48 18427 0 18428 0 18429 1 18430 48 18431 0 18432 0 18433 1 18434 48 18435 0 18436 0 18437 1 18438 48 18439 0 18440 0 18441 1 18442 48 18443 0 18444 0 18445 0 18446 0 18447 0 18448 0
308/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
18449 35303424 18450 0
18451 0
18452 0
18453 1 18454 48 18455 0 18456 0 18457 1 18458 48 18459 0 18460 0 18461 1 18462 48 18463 0 18464 0 18465 1 18466 48 18467 0 18468 0 18469 1 18470 48 18471 0 18472 0 18473 1 18474 48 18475 0 18476 0 18477 2 18478 52 18479 56 18480 0 18481 1 18482 49 18483 0 18484 0 18485 1 18486 48 18487 0 18488 0 18489 1 18490 48 18491 0 18492 0 18493 2 18494 52 18495 56 18496 0 18497 1 18498 49 18499 0 18500 0 18501 1 18502 48 18503 0 18504 0 18505 1 18506 48 18507 0 18508 0
309/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
18509 2 18510 52 18511 56 18512 0 18513 1 18514 49 18515 0 18516 0 18517 1 18518 48 18519 0 18520 0 18521 1 18522 48 18523 0 18524 0 18525 2 18526 52 18527 56 18528 0 18529 1 18530 49 18531 0 18532 0 18533 1 18534 48 18535 0 18536 0 18537 1 18538 48 18539 0 18540 0 18541 2 18542 52 18543 56 18544 0 18545 1 18546 49 18547 0 18548 0 18549 1 18550 48 18551 0 18552 0 18553 1 18554 48 18555 0 18556 0 18557 2 18558 52 18559 56 18560 0 18561 1 18562 49 18563 0 18564 0 18565 1 18566 48 18567 0 18568 0
310/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
18569 1 18570 48 18571 0 18572 0 18573 2 18574 52 18575 56 18576 0 18577 1 18578 49 18579 0 18580 0 18581 1 18582 48 18583 0 18584 0 18585 1 18586 48 18587 0 18588 0 18589 2 18590 52 18591 56 18592 0 18593 1 18594 49 18595 0 18596 0 18597 1 18598 48 18599 0 18600 0 18601 1 18602 48 18603 0 18604 0 18605 2 18606 52 18607 56 18608 0 18609 1 18610 49 18611 0 18612 0 18613 1 18614 48 18615 0 18616 0 18617 1 18618 48 18619 0 18620 0 18621 2 18622 52 18623 56 18624 0 18625 1 18626 49 18627 0 18628 0
311/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
18629 1 18630 48 18631 0 18632 0 18633 1 18634 48 18635 0 18636 0 18637 2 18638 52 18639 56 18640 0 18641 1 18642 49 18643 0 18644 0 18645 1 18646 48 18647 0 18648 0 18649 1 18650 48 18651 0 18652 0 18653 2 18654 52 18655 56 18656 0 18657 1 18658 49 18659 0 18660 0 18661 1 18662 48 18663 0 18664 0 18665 1 18666 48 18667 0 18668 0 18669 2 18670 52 18671 56 18672 0 18673 1 18674 49 18675 0 18676 0 18677 1 18678 48 18679 0 18680 0 18681 1 18682 48 18683 0 18684 0 18685 2 18686 52 18687 56 18688 0
312/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
18689 1 18690 49 18691 0 18692 0 18693 1 18694 48 18695 0 18696 0 18697 1 18698 48 18699 0 18700 0 18701 2 18702 52 18703 56 18704 0 18705 1 18706 49 18707 0 18708 0 18709 1 18710 48 18711 0 18712 0 18713 1 18714 48 18715 0 18716 0 18717 2 18718 52 18719 56 18720 0 18721 1 18722 49 18723 0 18724 0 18725 1 18726 48 18727 0 18728 0 18729 1 18730 48 18731 0 18732 0 18733 2 18734 52 18735 56 18736 0 18737 1 18738 49 18739 0 18740 0 18741 1 18742 48 18743 0 18744 0 18745 1 18746 48 18747 0 18748 0
313/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
18749 2 18750 52 18751 56 18752 0 18753 1 18754 49 18755 0 18756 0 18757 1 18758 48 18759 0 18760 0 18761 1 18762 48 18763 0 18764 0 18765 2 18766 52 18767 56 18768 0 18769 1 18770 49 18771 0 18772 0 18773 1 18774 48 18775 0 18776 0 18777 1 18778 48 18779 0 18780 0 18781 2 18782 52 18783 56 18784 0 18785 1 18786 49 18787 0 18788 0 18789 1 18790 48 18791 0 18792 0 18793 1 18794 48 18795 0 18796 0 18797 2 18798 52 18799 56 18800 0 18801 1 18802 49 18803 0 18804 0 18805 1 18806 48 18807 0 18808 0
314/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
18809 1 18810 48 18811 0 18812 0 18813 2 18814 52 18815 56 18816 0 18817 1 18818 49 18819 0 18820 0 18821 1 18822 48 18823 0 18824 0 18825 1 18826 48 18827 0 18828 0 18829 2 18830 52 18831 56 18832 0 18833 1 18834 49 18835 0 18836 0 18837 1 18838 48 18839 0 18840 0 18841 1 18842 48 18843 0 18844 0 18845 2 18846 52 18847 56 18848 0 18849 1 18850 49 18851 0 18852 0 18853 1 18854 48 18855 0 18856 0 18857 1 18858 48 18859 0 18860 0 18861 2 18862 52 18863 56 18864 0 18865 1 18866 49 18867 0 18868 0
315/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
18869 1 18870 48 18871 0 18872 0 18873 1 18874 48 18875 0 18876 0 18877 2 18878 52 18879 56 18880 0 18881 1 18882 49 18883 0 18884 0 18885 1 18886 48 18887 0 18888 0 18889 1 18890 48 18891 0 18892 0 18893 2 18894 52 18895 56 18896 0 18897 1 18898 49 18899 0 18900 0 18901 1 18902 48 18903 0 18904 0 18905 1 18906 48 18907 0 18908 0 18909 2 18910 52 18911 56 18912 0 18913 1 18914 49 18915 0 18916 0 18917 1 18918 48 18919 0 18920 0 18921 1 18922 48 18923 0 18924 0 18925 2 18926 52 18927 56 18928 0
316/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
18929 1 18930 49 18931 0 18932 0 18933 1 18934 48 18935 0 18936 0 18937 1 18938 48 18939 0 18940 0 18941 2 18942 52 18943 56 18944 0 18945 1 18946 49 18947 0 18948 0 18949 1 18950 48 18951 0 18952 0 18953 1 18954 48 18955 0 18956 0 18957 1 18958 48 18959 0 18960 0 18961 2 18962 52 18963 57 18964 0 18965 1 18966 49 18967 0 18968 0 18969 1 18970 48 18971 0 18972 0 18973 2 18974 53 18975 54 18976 0 18977 2 18978 53 18979 50 18980 0 18981 1 18982 50 18983 0 18984 0 18985 1 18986 48 18987 0 18988 0
317/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
18989 1 18990 48 18991 0 18992 0 18993 2 18994 52 18995 56 18996 0 18997 1 18998 49 18999 0 19000 0 19001 1 19002 48 19003 0 19004 0 19005 1 19006 48 19007 0 19008 0 19009 2 19010 52 19011 56 19012 0 19013 1 19014 49 19015 0 19016 0 19017 1 19018 48 19019 0 19020 0 19021 1 19022 48 19023 0 19024 0 19025 2 19026 52 19027 57 19028 0 19029 1 19030 49 19031 0 19032 0 19033 1 19034 48 19035 0 19036 0 19037 2 19038 53 19039 54 19040 0 19041 2 19042 53 19043 50 19044 0 19045 1 19046 50 19047 0 19048 0
318/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
19049 1 19050 48 19051 0 19052 0 19053 1 19054 48 19055 0 19056 0 19057 2 19058 52 19059 56 19060 0 19061 1 19062 49 19063 0 19064 0 19065 1 19066 48 19067 0 19068 0 19069 1 19070 48 19071 0 19072 0 19073 2 19074 52 19075 56 19076 0 19077 1 19078 49 19079 0 19080 0 19081 1 19082 48 19083 0 19084 0 19085 1 19086 48 19087 0 19088 0 19089 2 19090 52 19091 57 19092 0 19093 1 19094 49 19095 0 19096 0 19097 1 19098 48 19099 0 19100 0 19101 2 19102 53 19103 54 19104 0 19105 2 19106 53 19107 50 19108 0
319/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
19109 1 19110 50 19111 0 19112 0 19113 1 19114 48 19115 0 19116 0 19117 1 19118 48 19119 0 19120 0 19121 2 19122 52 19123 56 19124 0 19125 1 19126 49 19127 0 19128 0 19129 1 19130 48 19131 0 19132 0 19133 1 19134 48 19135 0 19136 0 19137 2 19138 52 19139 56 19140 0 19141 1 19142 49 19143 0 19144 0 19145 1 19146 48 19147 0 19148 0 19149 1 19150 48 19151 0 19152 0 19153 2 19154 52 19155 57 19156 0 19157 1 19158 49 19159 0 19160 0 19161 1 19162 48 19163 0 19164 0 19165 2 19166 53 19167 54 19168 0
320/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
19169 2 19170 53 19171 50 19172 0 19173 1 19174 50 19175 0 19176 0 19177 1 19178 48 19179 0 19180 0 19181 1 19182 48 19183 0 19184 0 19185 2 19186 52 19187 56 19188 0 19189 1 19190 49 19191 0 19192 0 19193 1 19194 48 19195 0 19196 0 19197 1 19198 48 19199 0 19200 0 19201 2 19202 52 19203 56 19204 0 19205 1 19206 49 19207 0 19208 0 19209 1 19210 48 19211 0 19212 0 19213 1 19214 48 19215 0 19216 0 19217 2 19218 52 19219 57 19220 0 19221 1 19222 49 19223 0 19224 0 19225 1 19226 48 19227 0 19228 0
321/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
19229 2 19230 53 19231 54 19232 0 19233 2 19234 53 19235 50 19236 0 19237 1 19238 50 19239 0 19240 0 19241 1 19242 48 19243 0 19244 0 19245 1 19246 48 19247 0 19248 0 19249 2 19250 52 19251 56 19252 0 19253 1 19254 49 19255 0 19256 0 19257 1 19258 48 19259 0 19260 0 19261 1 19262 48 19263 0 19264 0 19265 2 19266 52 19267 56 19268 0 19269 1 19270 49 19271 0 19272 0 19273 1 19274 48 19275 0 19276 0 19277 1 19278 48 19279 0 19280 0 19281 2 19282 52 19283 57 19284 0 19285 1 19286 49 19287 0 19288 0
322/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
19289 1 19290 48 19291 0 19292 0 19293 2 19294 53 19295 54 19296 0 19297 2 19298 53 19299 50 19300 0 19301 1 19302 50 19303 0 19304 0 19305 1 19306 48 19307 0 19308 0 19309 1 19310 48 19311 0 19312 0 19313 2 19314 52 19315 56 19316 0 19317 1 19318 49 19319 0 19320 0 19321 1 19322 48 19323 0 19324 0 19325 1 19326 48 19327 0 19328 0 19329 2 19330 52 19331 56 19332 0 19333 1 19334 49 19335 0 19336 0 19337 1 19338 48 19339 0 19340 0 19341 1 19342 48 19343 0 19344 0 19345 2 19346 52 19347 57 19348 0
323/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
19349 1 19350 49 19351 0 19352 0 19353 1 19354 48 19355 0 19356 0 19357 2 19358 53 19359 54 19360 0 19361 2 19362 53 19363 50 19364 0 19365 1 19366 50 19367 0 19368 0 19369 1 19370 48 19371 0 19372 0 19373 1 19374 48 19375 0 19376 0 19377 2 19378 52 19379 56 19380 0 19381 1 19382 49 19383 0 19384 0 19385 1 19386 48 19387 0 19388 0 19389 1 19390 48 19391 0 19392 0 19393 2 19394 52 19395 56 19396 0 19397 1 19398 49 19399 0 19400 0 19401 1 19402 48 19403 0 19404 0 19405 1 19406 48 19407 0 19408 0
324/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
19409 2 19410 52 19411 56 19412 0 19413 1 19414 49 19415 0 19416 0 19417 1 19418 48 19419 0 19420 0 19421 1 19422 48 19423 0 19424 0 19425 2 19426 52 19427 56 19428 0 19429 1 19430 49 19431 0 19432 0 19433 1 19434 48 19435 0 19436 0 19437 1 19438 48 19439 0 19440 0 19441 2 19442 52 19443 56 19444 0 19445 1 19446 49 19447 0 19448 0 19449 1 19450 48 19451 0 19452 0 19453 1 19454 48 19455 0 19456 0 19457 2 19458 52 19459 56 19460 0 19461 1 19462 49 19463 0 19464 0 19465 1 19466 48 19467 0 19468 0
325/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
19469 1 19470 48 19471 0 19472 0 19473 2 19474 52 19475 57 19476 0 19477 1 19478 49 19479 0 19480 0 19481 1 19482 48 19483 0 19484 0 19485 2 19486 53 19487 54 19488 0 19489 2 19490 53 19491 50 19492 0 19493 1 19494 50 19495 0 19496 0 19497 1 19498 48 19499 0 19500 0 19501 1 19502 48 19503 0 19504 0 19505 2 19506 52 19507 56 19508 0 19509 1 19510 49 19511 0 19512 0 19513 1 19514 48 19515 0 19516 0 19517 1 19518 48 19519 0 19520 0 19521 2 19522 52 19523 56 19524 0 19525 1 19526 49 19527 0 19528 0
326/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
19529 1 19530 48 19531 0 19532 0 19533 1 19534 48 19535 0 19536 0 19537 2 19538 52 19539 57 19540 0 19541 1 19542 49 19543 0 19544 0 19545 1 19546 48 19547 0 19548 0 19549 2 19550 53 19551 54 19552 0 19553 2 19554 53 19555 50 19556 0 19557 1 19558 50 19559 0 19560 0 19561 1 19562 48 19563 0 19564 0 19565 1 19566 48 19567 0 19568 0 19569 2 19570 52 19571 56 19572 0 19573 1 19574 49 19575 0 19576 0 19577 1 19578 48 19579 0 19580 0 19581 1 19582 48 19583 0 19584 0 19585 2 19586 52 19587 56 19588 0
327/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
19589 1 19590 49 19591 0 19592 0 19593 1 19594 48 19595 0 19596 0 19597 1 19598 48 19599 0 19600 0 19601 2 19602 52 19603 57 19604 0 19605 1 19606 49 19607 0 19608 0 19609 1 19610 48 19611 0 19612 0 19613 2 19614 53 19615 54 19616 0 19617 2 19618 53 19619 50 19620 0 19621 1 19622 50 19623 0 19624 0 19625 1 19626 48 19627 0 19628 0 19629 1 19630 48 19631 0 19632 0 19633 2 19634 52 19635 56 19636 0 19637 1 19638 49 19639 0 19640 0 19641 1 19642 48 19643 0 19644 0 19645 1 19646 48 19647 0 19648 0
328/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
19649 2 19650 52 19651 56 19652 0 19653 1 19654 49 19655 0 19656 0 19657 1 19658 48 19659 0 19660 0 19661 1 19662 48 19663 0 19664 0 19665 2 19666 52 19667 57 19668 0 19669 1 19670 49 19671 0 19672 0 19673 1 19674 48 19675 0 19676 0 19677 2 19678 53 19679 54 19680 0 19681 2 19682 53 19683 50 19684 0 19685 1 19686 50 19687 0 19688 0 19689 1 19690 48 19691 0 19692 0 19693 1 19694 48 19695 0 19696 0 19697 2 19698 52 19699 56 19700 0 19701 1 19702 49 19703 0 19704 0 19705 1 19706 48 19707 0 19708 0
329/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
19709 1 19710 48 19711 0 19712 0 19713 2 19714 52 19715 56 19716 0 19717 1 19718 49 19719 0 19720 0 19721 1 19722 48 19723 0 19724 0 19725 1 19726 48 19727 0 19728 0 19729 2 19730 52 19731 57 19732 0 19733 1 19734 49 19735 0 19736 0 19737 1 19738 48 19739 0 19740 0 19741 2 19742 53 19743 54 19744 0 19745 2 19746 53 19747 50 19748 0 19749 1 19750 50 19751 0 19752 0 19753 1 19754 48 19755 0 19756 0 19757 1 19758 48 19759 0 19760 0 19761 2 19762 52 19763 56 19764 0 19765 1 19766 49 19767 0 19768 0
330/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
19769 1 19770 48 19771 0 19772 0 19773 1 19774 48 19775 0 19776 0 19777 2 19778 52 19779 56 19780 0 19781 1 19782 49 19783 0 19784 0 19785 1 19786 48 19787 0 19788 0 19789 1 19790 48 19791 0 19792 0 19793 2 19794 52 19795 57 19796 0 19797 1 19798 49 19799 0 19800 0 19801 1 19802 48 19803 0 19804 0 19805 2 19806 53 19807 54 19808 0 19809 2 19810 53 19811 50 19812 0 19813 1 19814 50 19815 0 19816 0 19817 1 19818 48 19819 0 19820 0 19821 1 19822 48 19823 0 19824 0 19825 2 19826 52 19827 56 19828 0
331/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
19829 1 19830 49 19831 0 19832 0 19833 1 19834 48 19835 0 19836 0 19837 1 19838 48 19839 0 19840 0 19841 2 19842 52 19843 56 19844 0 19845 1 19846 49 19847 0 19848 0 19849 1 19850 48 19851 0 19852 0 19853 1 19854 48 19855 0 19856 0 19857 2 19858 52 19859 57 19860 0 19861 1 19862 49 19863 0 19864 0 19865 1 19866 48 19867 0 19868 0 19869 2 19870 53 19871 54 19872 0 19873 2 19874 53 19875 50 19876 0 19877 1 19878 50 19879 0 19880 0 19881 1 19882 48 19883 0 19884 0 19885 1 19886 48 19887 0 19888 0
332/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
19889 2 19890 52 19891 56 19892 0 19893 1 19894 49 19895 0 19896 0 19897 1 19898 48 19899 0 19900 0 19901 1 19902 48 19903 0 19904 0 19905 2 19906 52 19907 56 19908 0 19909 1 19910 49 19911 0 19912 0 19913 1 19914 48 19915 0 19916 0 19917 1 19918 48 19919 0 19920 0 19921 2 19922 52 19923 57 19924 0 19925 1 19926 49 19927 0 19928 0 19929 1 19930 48 19931 0 19932 0 19933 2 19934 53 19935 54 19936 0 19937 2 19938 53 19939 50 19940 0 19941 1 19942 50 19943 0 19944 0 19945 1 19946 48 19947 0 19948 0
333/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
19949 1 19950 48 19951 0 19952 0 19953 2 19954 52 19955 56 19956 0 19957 1 19958 49 19959 0 19960 0 19961 1 19962 48 19963 0 19964 0 19965 1 19966 48 19967 0 19968 0 19969 2 19970 52 19971 56 19972 0 19973 1 19974 49 19975 0 19976 0 19977 1 19978 48 19979 0 19980 0 19981 1 19982 48 19983 0 19984 0 19985 2 19986 52 19987 57 19988 0 19989 1 19990 49 19991 0 19992 0 19993 1 19994 48 19995 0 19996 0 19997 2 19998 53 19999 54 20000 0 20001 2 20002 53 20003 50 20004 0 20005 1 20006 50 20007 0 20008 0
334/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
20009 1 20010 48 20011 0 20012 0 20013 1 20014 48 20015 0 20016 0 20017 2 20018 52 20019 56 20020 0 20021 1 20022 49 20023 0 20024 0 20025 1 20026 48 20027 0 20028 0 20029 1 20030 48 20031 0 20032 0 20033 2 20034 52 20035 56 20036 0 20037 1 20038 49 20039 0 20040 0 20041 1 20042 48 20043 0 20044 0 20045 1 20046 48 20047 0 20048 0 20049 2 20050 52 20051 57 20052 0 20053 1 20054 49 20055 0 20056 0 20057 1 20058 48 20059 0 20060 0 20061 2 20062 53 20063 54 20064 0 20065 2 20066 53 20067 50 20068 0
335/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
20069 1 20070 50 20071 0 20072 0 20073 1 20074 48 20075 0 20076 0 20077 1 20078 48 20079 0 20080 0 20081 2 20082 52 20083 56 20084 0 20085 1 20086 49 20087 0 20088 0 20089 1 20090 48 20091 0 20092 0 20093 1 20094 48 20095 0 20096 0 20097 2 20098 52 20099 56 20100 0 20101 1 20102 49 20103 0 20104 0 20105 1 20106 48 20107 0 20108 0 20109 1 20110 48 20111 0 20112 0 20113 2 20114 52 20115 57 20116 0 20117 1 20118 49 20119 0 20120 0 20121 1 20122 48 20123 0 20124 0 20125 2 20126 53 20127 54 20128 0
336/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
20129 2 20130 53 20131 50 20132 0 20133 1 20134 50 20135 0 20136 0 20137 1 20138 48 20139 0 20140 0 20141 1 20142 48 20143 0 20144 0 20145 2 20146 52 20147 56 20148 0 20149 1 20150 49 20151 0 20152 0 20153 1 20154 48 20155 0 20156 0 20157 1 20158 48 20159 0 20160 0 20161 2 20162 52 20163 56 20164 0 20165 1 20166 49 20167 0 20168 0 20169 1 20170 48 20171 0 20172 0 20173 1 20174 48 20175 0 20176 0 20177 2 20178 52 20179 57 20180 0 20181 1 20182 49 20183 0 20184 0 20185 1 20186 48 20187 0 20188 0
337/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
20189 2 20190 53 20191 54 20192 0 20193 2 20194 53 20195 50 20196 0 20197 1 20198 50 20199 0 20200 0 20201 1 20202 48 20203 0 20204 0 20205 1 20206 48 20207 0 20208 0 20209 2 20210 52 20211 56 20212 0 20213 1 20214 49 20215 0 20216 0 20217 1 20218 48 20219 0 20220 0 20221 1 20222 48 20223 0 20224 0 20225 2 20226 52 20227 56 20228 0 20229 1 20230 49 20231 0 20232 0 20233 1 20234 48 20235 0 20236 0 20237 1 20238 48 20239 0 20240 0 20241 2 20242 52 20243 57 20244 0 20245 1 20246 49 20247 0 20248 0
338/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
20249 1 20250 48 20251 0 20252 0 20253 2 20254 53 20255 54 20256 0 20257 2 20258 53 20259 50 20260 0 20261 1 20262 50 20263 0 20264 0 20265 1 20266 48 20267 0 20268 0 20269 1 20270 48 20271 0 20272 0 20273 2 20274 52 20275 56 20276 0 20277 1 20278 49 20279 0 20280 0 20281 1 20282 48 20283 0 20284 0 20285 1 20286 48 20287 0 20288 0 20289 2 20290 52 20291 56 20292 0 20293 1 20294 49 20295 0 20296 0 20297 1 20298 48 20299 0 20300 0 20301 1 20302 48 20303 0 20304 0 20305 2 20306 52 20307 57 20308 0
339/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
20309 1 20310 49 20311 0 20312 0 20313 1 20314 48 20315 0 20316 0 20317 2 20318 53 20319 54 20320 0 20321 2 20322 53 20323 50 20324 0 20325 1 20326 50 20327 0 20328 0 20329 1 20330 48 20331 0 20332 0 20333 1 20334 48 20335 0 20336 0 20337 2 20338 52 20339 56 20340 0 20341 1 20342 49 20343 0 20344 0 20345 1 20346 48 20347 0 20348 0 20349 1 20350 48 20351 0 20352 0 20353 2 20354 52 20355 56 20356 0 20357 1 20358 49 20359 0 20360 0 20361 1 20362 48 20363 0 20364 0 20365 1 20366 48 20367 0 20368 0
340/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
20369 2 20370 52 20371 57 20372 0 20373 1 20374 49 20375 0 20376 0 20377 1 20378 48 20379 0 20380 0 20381 2 20382 53 20383 54 20384 0 20385 2 20386 53 20387 50 20388 0 20389 1 20390 50 20391 0 20392 0 20393 1 20394 48 20395 0 20396 0 20397 1 20398 48 20399 0 20400 0 20401 2 20402 52 20403 56 20404 0 20405 1 20406 49 20407 0 20408 0 20409 1 20410 48 20411 0 20412 0 20413 1 20414 48 20415 0 20416 0 20417 2 20418 52 20419 56 20420 0 20421 1 20422 49 20423 0 20424 0 20425 1 20426 48 20427 0 20428 0
341/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
20429 1 20430 48 20431 0 20432 0 20433 2 20434 52 20435 57 20436 0 20437 1 20438 49 20439 0 20440 0 20441 1 20442 48 20443 0 20444 0 20445 2 20446 53 20447 54 20448 0 20449 2 20450 53 20451 50 20452 0 20453 1 20454 50 20455 0 20456 0 20457 1 20458 48 20459 0 20460 0 20461 1 20462 48 20463 0 20464 0 20465 2 20466 52 20467 56 20468 0 20469 1 20470 49 20471 0 20472 0 20473 1 20474 48 20475 0 20476 0 20477 1 20478 48 20479 0 20480 0 20481 2 20482 52 20483 56 20484 0 20485 1 20486 49 20487 0 20488 0
342/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
20489 1 20490 48 20491 0 20492 0 20493 2 20494 53 20495 55 20496 0 20497 2 20498 53 20499 50 20500 0 20501 1 20502 50 20503 0 20504 0 20505 1 20506 48 20507 0 20508 0 20509 1 20510 48 20511 0 20512 0 20513 2 20514 52 20515 56 20516 0 20517 1 20518 49 20519 0 20520 0 20521 1 20522 48 20523 0 20524 0 20525 1 20526 48 20527 0 20528 0 20529 2 20530 52 20531 56 20532 0 20533 1 20534 49 20535 0 20536 0 20537 1 20538 48 20539 0 20540 0 20541 1 20542 48 20543 0 20544 0 20545 2 20546 52 20547 56 20548 0
343/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
20549 1 20550 49 20551 0 20552 0 20553 1 20554 48 20555 0 20556 0 20557 1 20558 48 20559 0 20560 0 20561 2 20562 52 20563 57 20564 0 20565 1 20566 49 20567 0 20568 0 20569 1 20570 48 20571 0 20572 0 20573 2 20574 53 20575 54 20576 0 20577 2 20578 53 20579 50 20580 0 20581 1 20582 50 20583 0 20584 0 20585 1 20586 48 20587 0 20588 0 20589 1 20590 48 20591 0 20592 0 20593 2 20594 52 20595 56 20596 0 20597 1 20598 49 20599 0 20600 0 20601 1 20602 48 20603 0 20604 0 20605 1 20606 48 20607 0 20608 0
344/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
20609 2 20610 52 20611 56 20612 0 20613 1 20614 49 20615 0 20616 0 20617 1 20618 48 20619 0 20620 0 20621 1 20622 48 20623 0 20624 0 20625 2 20626 52 20627 57 20628 0 20629 1 20630 49 20631 0 20632 0 20633 1 20634 48 20635 0 20636 0 20637 2 20638 53 20639 54 20640 0 20641 2 20642 53 20643 50 20644 0 20645 1 20646 50 20647 0 20648 0 20649 1 20650 48 20651 0 20652 0 20653 1 20654 48 20655 0 20656 0 20657 2 20658 52 20659 56 20660 0 20661 1 20662 49 20663 0 20664 0 20665 1 20666 48 20667 0 20668 0
345/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
20669 1 20670 48 20671 0 20672 0 20673 2 20674 52 20675 56 20676 0 20677 1 20678 49 20679 0 20680 0 20681 1 20682 48 20683 0 20684 0 20685 1 20686 48 20687 0 20688 0 20689 2 20690 52 20691 57 20692 0 20693 1 20694 49 20695 0 20696 0 20697 1 20698 48 20699 0 20700 0 20701 2 20702 53 20703 54 20704 0 20705 2 20706 53 20707 50 20708 0 20709 1 20710 50 20711 0 20712 0 20713 1 20714 48 20715 0 20716 0 20717 1 20718 48 20719 0 20720 0 20721 2 20722 52 20723 56 20724 0 20725 1 20726 49 20727 0 20728 0
346/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
20729 1 20730 48 20731 0 20732 0 20733 1 20734 48 20735 0 20736 0 20737 2 20738 52 20739 56 20740 0 20741 1 20742 49 20743 0 20744 0 20745 1 20746 48 20747 0 20748 0 20749 1 20750 48 20751 0 20752 0 20753 2 20754 52 20755 57 20756 0 20757 1 20758 49 20759 0 20760 0 20761 1 20762 48 20763 0 20764 0 20765 2 20766 53 20767 54 20768 0 20769 2 20770 53 20771 50 20772 0 20773 1 20774 50 20775 0 20776 0 20777 1 20778 48 20779 0 20780 0 20781 1 20782 48 20783 0 20784 0 20785 2 20786 52 20787 56 20788 0
347/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
20789 1 20790 49 20791 0 20792 0 20793 1 20794 48 20795 0 20796 0 20797 1 20798 48 20799 0 20800 0 20801 2 20802 52 20803 56 20804 0 20805 1 20806 49 20807 0 20808 0 20809 1 20810 48 20811 0 20812 0 20813 1 20814 48 20815 0 20816 0 20817 2 20818 52 20819 57 20820 0 20821 1 20822 49 20823 0 20824 0 20825 1 20826 48 20827 0 20828 0 20829 2 20830 53 20831 54 20832 0 20833 2 20834 53 20835 50 20836 0 20837 1 20838 50 20839 0 20840 0 20841 1 20842 48 20843 0 20844 0 20845 1 20846 48 20847 0 20848 0
348/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
20849 2 20850 52 20851 56 20852 0 20853 1 20854 49 20855 0 20856 0 20857 1 20858 48 20859 0 20860 0 20861 1 20862 48 20863 0 20864 0 20865 2 20866 52 20867 56 20868 0 20869 1 20870 49 20871 0 20872 0 20873 1 20874 48 20875 0 20876 0 20877 1 20878 48 20879 0 20880 0 20881 2 20882 52 20883 57 20884 0 20885 1 20886 49 20887 0 20888 0 20889 1 20890 48 20891 0 20892 0 20893 2 20894 53 20895 54 20896 0 20897 2 20898 53 20899 50 20900 0 20901 1 20902 50 20903 0 20904 0 20905 1 20906 48 20907 0 20908 0
349/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
20909 1 20910 48 20911 0 20912 0 20913 2 20914 52 20915 56 20916 0 20917 1 20918 49 20919 0 20920 0 20921 1 20922 48 20923 0 20924 0 20925 1 20926 48 20927 0 20928 0 20929 2 20930 52 20931 56 20932 0 20933 1 20934 49 20935 0 20936 0 20937 1 20938 48 20939 0 20940 0 20941 1 20942 48 20943 0 20944 0 20945 2 20946 52 20947 57 20948 0 20949 1 20950 49 20951 0 20952 0 20953 1 20954 48 20955 0 20956 0 20957 2 20958 53 20959 54 20960 0 20961 2 20962 53 20963 50 20964 0 20965 1 20966 50 20967 0 20968 0
350/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
20969 1 20970 48 20971 0 20972 0 20973 1 20974 48 20975 0 20976 0 20977 2 20978 52 20979 56 20980 0 20981 1 20982 49 20983 0 20984 0 20985 1 20986 48 20987 0 20988 0 20989 1 20990 48 20991 0 20992 0 20993 2 20994 52 20995 56 20996 0 20997 1 20998 49 20999 0 21000 0 21001 1 21002 48 21003 0 21004 0 21005 2 21006 53 21007 55 21008 0 21009 2 21010 53 21011 50 21012 0 21013 1 21014 50 21015 0 21016 0 21017 1 21018 48 21019 0 21020 0 21021 1 21022 48 21023 0 21024 0 21025 2 21026 52 21027 56 21028 0
351/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
21029 1 21030 49 21031 0 21032 0 21033 1 21034 48 21035 0 21036 0 21037 1 21038 48 21039 0 21040 0 21041 2 21042 52 21043 56 21044 0 21045 1 21046 49 21047 0 21048 0 21049 1 21050 48 21051 0 21052 0 21053 1 21054 48 21055 0 21056 0 21057 2 21058 52 21059 57 21060 0 21061 1 21062 49 21063 0 21064 0 21065 1 21066 48 21067 0 21068 0 21069 2 21070 53 21071 54 21072 0 21073 2 21074 53 21075 50 21076 0 21077 1 21078 50 21079 0 21080 0 21081 1 21082 48 21083 0 21084 0 21085 1 21086 48 21087 0 21088 0
352/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
21089 2 21090 52 21091 56 21092 0 21093 1 21094 49 21095 0 21096 0 21097 1 21098 48 21099 0 21100 0 21101 1 21102 48 21103 0 21104 0 21105 2 21106 52 21107 56 21108 0 21109 1 21110 49 21111 0 21112 0 21113 1 21114 48 21115 0 21116 0 21117 1 21118 48 21119 0 21120 0 21121 2 21122 52 21123 57 21124 0 21125 1 21126 49 21127 0 21128 0 21129 1 21130 48 21131 0 21132 0 21133 2 21134 53 21135 54 21136 0 21137 2 21138 53 21139 50 21140 0 21141 1 21142 50 21143 0 21144 0 21145 1 21146 48 21147 0 21148 0
353/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
21149 1 21150 48 21151 0 21152 0 21153 2 21154 52 21155 56 21156 0 21157 1 21158 49 21159 0 21160 0 21161 1 21162 48 21163 0 21164 0 21165 1 21166 48 21167 0 21168 0 21169 2 21170 52 21171 56 21172 0 21173 1 21174 49 21175 0 21176 0 21177 1 21178 48 21179 0 21180 0 21181 1 21182 48 21183 0 21184 0 21185 2 21186 53 21187 48 21188 0 21189 1 21190 49 21191 0 21192 0 21193 1 21194 48 21195 0 21196 0 21197 2 21198 53 21199 48 21200 0 21201 2 21202 53 21203 51 21204 0 21205 1 21206 50 21207 0 21208 0
354/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
21209 1 21210 48 21211 0 21212 0 21213 2 21214 53 21215 52 21216 0 21217 2 21218 53 21219 51 21220 0 21221 1 21222 50 21223 0 21224 0 21225 1 21226 48 21227 0 21228 0 21229 1 21230 48 21231 0 21232 0 21233 2 21234 52 21235 56 21236 0 21237 1 21238 49 21239 0 21240 0 21241 1 21242 48 21243 0 21244 0 21245 1 21246 48 21247 0 21248 0 21249 2 21250 52 21251 57 21252 0 21253 1 21254 49 21255 0 21256 0 21257 1 21258 48 21259 0 21260 0 21261 2 21262 53 21263 55 21264 0 21265 2 21266 53 21267 50 21268 0
355/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
21269 1 21270 50 21271 0 21272 0 21273 1 21274 48 21275 0 21276 0 21277 1 21278 48 21279 0 21280 0 21281 2 21282 52 21283 56 21284 0 21285 1 21286 49 21287 0 21288 0 21289 1 21290 48 21291 0 21292 0 21293 1 21294 48 21295 0 21296 0 21297 2 21298 52 21299 56 21300 0 21301 1 21302 49 21303 0 21304 0 21305 1 21306 48 21307 0 21308 0 21309 1 21310 48 21311 0 21312 0 21313 2 21314 52 21315 57 21316 0 21317 1 21318 49 21319 0 21320 0 21321 1 21322 48 21323 0 21324 0 21325 2 21326 53 21327 54 21328 0
356/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
21329 2 21330 53 21331 50 21332 0 21333 1 21334 50 21335 0 21336 0 21337 1 21338 48 21339 0 21340 0 21341 1 21342 48 21343 0 21344 0 21345 2 21346 52 21347 56 21348 0 21349 1 21350 49 21351 0 21352 0 21353 1 21354 48 21355 0 21356 0 21357 1 21358 48 21359 0 21360 0 21361 2 21362 52 21363 56 21364 0 21365 1 21366 49 21367 0 21368 0 21369 1 21370 48 21371 0 21372 0 21373 1 21374 48 21375 0 21376 0 21377 2 21378 52 21379 57 21380 0 21381 1 21382 49 21383 0 21384 0 21385 1 21386 48 21387 0 21388 0
357/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
21389 2 21390 53 21391 54 21392 0 21393 2 21394 53 21395 50 21396 0 21397 1 21398 50 21399 0 21400 0 21401 1 21402 48 21403 0 21404 0 21405 1 21406 48 21407 0 21408 0 21409 2 21410 52 21411 56 21412 0 21413 1 21414 49 21415 0 21416 0 21417 1 21418 48 21419 0 21420 0 21421 1 21422 48 21423 0 21424 0 21425 2 21426 52 21427 56 21428 0 21429 1 21430 49 21431 0 21432 0 21433 1 21434 48 21435 0 21436 0 21437 1 21438 48 21439 0 21440 0 21441 2 21442 53 21443 48 21444 0 21445 1 21446 49 21447 0 21448 0
358/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
21449 1 21450 48 21451 0 21452 0 21453 2 21454 53 21455 48 21456 0 21457 2 21458 53 21459 51 21460 0 21461 1 21462 50 21463 0 21464 0 21465 1 21466 48 21467 0 21468 0 21469 2 21470 53 21471 52 21472 0 21473 2 21474 53 21475 51 21476 0 21477 1 21478 50 21479 0 21480 0 21481 1 21482 48 21483 0 21484 0 21485 1 21486 48 21487 0 21488 0 21489 2 21490 52 21491 56 21492 0 21493 1 21494 49 21495 0 21496 0 21497 1 21498 48 21499 0 21500 0 21501 1 21502 48 21503 0 21504 0 21505 2 21506 52 21507 57 21508 0
359/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
21509 1 21510 49 21511 0 21512 0 21513 1 21514 48 21515 0 21516 0 21517 2 21518 53 21519 55 21520 0 21521 2 21522 53 21523 50 21524 0 21525 1 21526 50 21527 0 21528 0 21529 1 21530 48 21531 0 21532 0 21533 1 21534 48 21535 0 21536 0 21537 2 21538 52 21539 56 21540 0 21541 1 21542 49 21543 0 21544 0 21545 1 21546 48 21547 0 21548 0 21549 1 21550 48 21551 0 21552 0 21553 2 21554 52 21555 56 21556 0 21557 1 21558 49 21559 0 21560 0 21561 1 21562 48 21563 0 21564 0 21565 1 21566 48 21567 0 21568 0
360/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
21569 2 21570 52 21571 57 21572 0 21573 1 21574 49 21575 0 21576 0 21577 1 21578 48 21579 0 21580 0 21581 2 21582 53 21583 54 21584 0 21585 2 21586 53 21587 50 21588 0 21589 1 21590 50 21591 0 21592 0 21593 1 21594 48 21595 0 21596 0 21597 1 21598 48 21599 0 21600 0 21601 2 21602 52 21603 56 21604 0 21605 1 21606 49 21607 0 21608 0 21609 1 21610 48 21611 0 21612 0 21613 1 21614 48 21615 0 21616 0 21617 2 21618 52 21619 56 21620 0 21621 1 21622 49 21623 0 21624 0 21625 1 21626 48 21627 0 21628 0
361/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
21629 1 21630 48 21631 0 21632 0 21633 2 21634 52 21635 57 21636 0 21637 1 21638 49 21639 0 21640 0 21641 1 21642 48 21643 0 21644 0 21645 2 21646 53 21647 54 21648 0 21649 2 21650 53 21651 50 21652 0 21653 1 21654 50 21655 0 21656 0 21657 1 21658 48 21659 0 21660 0 21661 1 21662 48 21663 0 21664 0 21665 2 21666 52 21667 56 21668 0 21669 1 21670 49 21671 0 21672 0 21673 1 21674 48 21675 0 21676 0 21677 1 21678 48 21679 0 21680 0 21681 2 21682 52 21683 56 21684 0 21685 1 21686 49 21687 0 21688 0
362/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
21689 1 21690 48 21691 0 21692 0 21693 1 21694 48 21695 0 21696 0 21697 2 21698 53 21699 48 21700 0 21701 1 21702 49 21703 0 21704 0 21705 1 21706 48 21707 0 21708 0 21709 2 21710 53 21711 48 21712 0 21713 2 21714 53 21715 51 21716 0 21717 1 21718 50 21719 0 21720 0 21721 1 21722 48 21723 0 21724 0 21725 2 21726 53 21727 52 21728 0 21729 2 21730 53 21731 51 21732 0 21733 1 21734 50 21735 0 21736 0 21737 1 21738 48 21739 0 21740 0 21741 1 21742 48 21743 0 21744 0 21745 2 21746 52 21747 56 21748 0
363/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
21749 1 21750 49 21751 0 21752 0 21753 1 21754 48 21755 0 21756 0 21757 1 21758 48 21759 0 21760 0 21761 2 21762 52 21763 57 21764 0 21765 1 21766 49 21767 0 21768 0 21769 1 21770 48 21771 0 21772 0 21773 2 21774 53 21775 55 21776 0 21777 2 21778 53 21779 50 21780 0 21781 1 21782 50 21783 0 21784 0 21785 1 21786 48 21787 0 21788 0 21789 1 21790 48 21791 0 21792 0 21793 2 21794 52 21795 56 21796 0 21797 1 21798 49 21799 0 21800 0 21801 1 21802 48 21803 0 21804 0 21805 1 21806 48 21807 0 21808 0
364/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
21809 2 21810 52 21811 56 21812 0 21813 1 21814 49 21815 0 21816 0 21817 1 21818 48 21819 0 21820 0 21821 1 21822 48 21823 0 21824 0 21825 2 21826 52 21827 57 21828 0 21829 1 21830 49 21831 0 21832 0 21833 1 21834 48 21835 0 21836 0 21837 2 21838 53 21839 54 21840 0 21841 2 21842 53 21843 50 21844 0 21845 1 21846 50 21847 0 21848 0 21849 1 21850 48 21851 0 21852 0 21853 1 21854 48 21855 0 21856 0 21857 2 21858 52 21859 56 21860 0 21861 1 21862 49 21863 0 21864 0 21865 1 21866 48 21867 0 21868 0
365/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
21869 1 21870 48 21871 0 21872 0 21873 2 21874 52 21875 56 21876 0 21877 1 21878 49 21879 0 21880 0 21881 1 21882 48 21883 0 21884 0 21885 1 21886 48 21887 0 21888 0 21889 2 21890 52 21891 57 21892 0 21893 1 21894 49 21895 0 21896 0 21897 1 21898 48 21899 0 21900 0 21901 2 21902 53 21903 54 21904 0 21905 2 21906 53 21907 50 21908 0 21909 1 21910 50 21911 0 21912 0 21913 1 21914 48 21915 0 21916 0 21917 1 21918 48 21919 0 21920 0 21921 2 21922 52 21923 56 21924 0 21925 1 21926 49 21927 0 21928 0
366/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
21929 1 21930 48 21931 0 21932 0 21933 1 21934 48 21935 0 21936 0 21937 2 21938 52 21939 56 21940 0 21941 1 21942 49 21943 0 21944 0 21945 1 21946 48 21947 0 21948 0 21949 1 21950 48 21951 0 21952 0 21953 2 21954 53 21955 48 21956 0 21957 1 21958 49 21959 0 21960 0 21961 1 21962 48 21963 0 21964 0 21965 2 21966 53 21967 48 21968 0 21969 2 21970 53 21971 51 21972 0 21973 1 21974 50 21975 0 21976 0 21977 1 21978 48 21979 0 21980 0 21981 2 21982 53 21983 52 21984 0 21985 2 21986 53 21987 51 21988 0
367/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
21989 1 21990 50 21991 0 21992 0 21993 1 21994 48 21995 0 21996 0 21997 1 21998 48 21999 0 22000 0 22001 2 22002 52 22003 56 22004 0 22005 1 22006 49 22007 0 22008 0 22009 1 22010 48 22011 0 22012 0 22013 1 22014 48 22015 0 22016 0 22017 2 22018 52 22019 57 22020 0 22021 1 22022 49 22023 0 22024 0 22025 1 22026 48 22027 0 22028 0 22029 2 22030 53 22031 55 22032 0 22033 2 22034 53 22035 50 22036 0 22037 1 22038 50 22039 0 22040 0 22041 1 22042 48 22043 0 22044 0 22045 1 22046 48 22047 0 22048 0
368/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
22049 2 22050 52 22051 56 22052 0 22053 1 22054 49 22055 0 22056 0 22057 1 22058 48 22059 0 22060 0 22061 1 22062 48 22063 0 22064 0 22065 2 22066 52 22067 56 22068 0 22069 1 22070 49 22071 0 22072 0 22073 1 22074 48 22075 0 22076 0 22077 1 22078 48 22079 0 22080 0 22081 2 22082 52 22083 57 22084 0 22085 1 22086 49 22087 0 22088 0 22089 1 22090 48 22091 0 22092 0 22093 2 22094 53 22095 54 22096 0 22097 2 22098 53 22099 50 22100 0 22101 1 22102 50 22103 0 22104 0 22105 1 22106 48 22107 0 22108 0
369/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
22109 1 22110 48 22111 0 22112 0 22113 2 22114 52 22115 56 22116 0 22117 1 22118 49 22119 0 22120 0 22121 1 22122 48 22123 0 22124 0 22125 1 22126 48 22127 0 22128 0 22129 2 22130 52 22131 56 22132 0 22133 1 22134 49 22135 0 22136 0 22137 1 22138 48 22139 0 22140 0 22141 1 22142 48 22143 0 22144 0 22145 2 22146 52 22147 57 22148 0 22149 1 22150 49 22151 0 22152 0 22153 1 22154 48 22155 0 22156 0 22157 2 22158 53 22159 54 22160 0 22161 2 22162 53 22163 50 22164 0 22165 1 22166 50 22167 0 22168 0
370/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
22169 1 22170 48 22171 0 22172 0 22173 1 22174 48 22175 0 22176 0 22177 2 22178 52 22179 56 22180 0 22181 1 22182 49 22183 0 22184 0 22185 1 22186 48 22187 0 22188 0 22189 1 22190 48 22191 0 22192 0 22193 2 22194 52 22195 56 22196 0 22197 1 22198 49 22199 0 22200 0 22201 1 22202 48 22203 0 22204 0 22205 1 22206 48 22207 0 22208 0 22209 2 22210 53 22211 48 22212 0 22213 1 22214 49 22215 0 22216 0 22217 1 22218 48 22219 0 22220 0 22221 2 22222 53 22223 48 22224 0 22225 2 22226 53 22227 51 22228 0
371/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
22229 1 22230 50 22231 0 22232 0 22233 1 22234 48 22235 0 22236 0 22237 2 22238 53 22239 52 22240 0 22241 2 22242 53 22243 51 22244 0 22245 1 22246 50 22247 0 22248 0 22249 1 22250 48 22251 0 22252 0 22253 1 22254 48 22255 0 22256 0 22257 2 22258 52 22259 56 22260 0 22261 1 22262 49 22263 0 22264 0 22265 1 22266 48 22267 0 22268 0 22269 1 22270 48 22271 0 22272 0 22273 2 22274 52 22275 57 22276 0 22277 1 22278 49 22279 0 22280 0 22281 1 22282 48 22283 0 22284 0 22285 2 22286 53 22287 55 22288 0
372/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
22289 2 22290 53 22291 50 22292 0 22293 1 22294 50 22295 0 22296 0 22297 1 22298 48 22299 0 22300 0 22301 1 22302 48 22303 0 22304 0 22305 2 22306 52 22307 56 22308 0 22309 1 22310 49 22311 0 22312 0 22313 1 22314 48 22315 0 22316 0 22317 1 22318 48 22319 0 22320 0 22321 2 22322 52 22323 56 22324 0 22325 1 22326 49 22327 0 22328 0 22329 1 22330 48 22331 0 22332 0 22333 1 22334 48 22335 0 22336 0 22337 2 22338 52 22339 57 22340 0 22341 1 22342 49 22343 0 22344 0 22345 1 22346 48 22347 0 22348 0
373/374

xic-ref (-target linux -O [basic test]): arrinit02.xi
22349 2 22350 53 22351 54 22352 0 22353 2 22354 53 22355 50 22356 0 22357 1 22358 50 22359 0 22360 0 22361 1 22362 48 22363 0 22364 0 22365 1 22366 48 22367 0 22368 0 22369 2 22370 52 22371 56 22372 0 22373 1 22374 49 22375 0
Expected result:
./arrinit02.ssol.nml
1 f() called: 1 2 f() called: 2 3 f() called: 3 4 f() called: 4 5 f() called: 5 61
72 83 94
10 5
374/374

xic-ref (-target linux -O [basic test]): arrinit03.xi
xic-ref (-target linux -O [basic test]): arrinit03.xi
Mismatch detected at line 1 of file arrinit03.s.nml
expected: 1
found   : _xi_out_of_bounds called
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arrinit03.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[][] = {{1}, {2, 3}, {4, 5, 6}, {7, 8, 9, 10}} 6{
7
8
9
i: int = 0
while (i < length(a)) {
j: int = 0
while (j < length(a[i])) {
10
11
12
13 }
14 i=i+ 1 15 }
println(unparseInt(a[i][j])) j=j+ 1
16 } 17 }
Compiler's standard output:
ASM generated
Generated result:
./arrinit03.s.nml
1 _xi_out_of_bounds called
Expected result:
./arrinit03.ssol.nml
11 22 33 44 55 66 77 88 99 10 10
1/1

xic-ref (-target linux -O [basic test]): arrinit04.xi
xic-ref (-target linux -O [basic test]): arrinit04.xi
Failed to execute: arrinit04 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arrinit04.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[][] = {{f(1)}, {f(2), f(3)}, {f(4), f(5), f(6)}, {f(7), f(8), f(9), f(10)}} 6{
7
8
9
i: int = 0
while (i < length(a)) {
j: int = 0
while (j < length(a[i])) {
10
11
12
13 }
14 i=i+ 1 15 }
println(unparseInt(a[i][j])) j=j+ 1
16 }
17 }
18
19 f(i: int): int {
20 print("f() called: ") 21 println(unparseInt(i)) 22 return i
23 }
Compiler's standard output:
ASM generated
Generated result:
./arrinit04.s.nml
Expected result:
./arrinit04.ssol.nml
1 f() called: 1 2 f() called: 2 3 f() called: 3 4 f() called: 4 5 f() called: 5 6 f() called: 6 7 f() called: 7 8 f() called: 8 9 f() called: 9 10 f() called: 10
11 1 12 2 13 3 14 4 15 5 16 6 17 7 18 8 19 9
1/2

xic-ref (-target linux -O [basic test]): arrinit04.xi
20 10
2/2

xic-ref (-target linux -O [basic test]): arrinit05.xi
xic-ref (-target linux -O [basic test]): arrinit05.xi
Failed to execute: arrinit05 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arrinit05.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int[] = {1, 2, 3}
6 a: int[] = {f(x, 1), f(x, 2), f(x, 3), f(x, 4), f(x, 5)}
7 i: int = 0
8 while (i < length(a)) {
9 println(unparseInt(a[i]))
10 i=i+ 1 11 }
12 }
13
14 f(x: int[], y: int): int { 15 print("f() called: ") 16 println(unparseInt(y))
17 x[0] = x[0] + 1
18 return x[0]
19 }
Compiler's standard output:
ASM generated
Generated result:
./arrinit05.s.nml
Expected result:
./arrinit05.ssol.nml
1 f() called: 1 2 f() called: 2 3 f() called: 3 4 f() called: 4 5 f() called: 5 62
73 84 95
10 6
1/1

xic-ref (-target linux -O [basic test]): arrinit06.xi
xic-ref (-target linux -O [basic test]): arrinit06.xi
Failed to execute: arrinit06 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/arrinit06.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int[] = {1, 2, 3}
6 a: int[][] = {{f(x, 1)}, {f(x, 2), f(x, 3)}, {f(x, 4), f(x, 5), f(x, 6)},
7 8{ 9
{f(x, 7), f(x, 8), f(x, 9), f(x, 10)}}
i: int = 0
while (i < length(a)) {
  j: int = 0
  while (j < length(a[i])) {
println(unparseInt(a[i][j])) j=j+ 1
10
11
12
13
14
15 }
16 i=i+ 1 17 }
18 }
19 }
20
21 f(x: int[], y: int): int { 22 print("f() called: ") 23 println(unparseInt(y))
24 x[0] = x[0] + 1
25 return x[0]
26 }
Compiler's standard output:
ASM generated
Generated result:
./arrinit06.s.nml
Expected result:
./arrinit06.ssol.nml
1 f() called: 1 2 f() called: 2 3 f() called: 3 4 f() called: 4 5 f() called: 5 6 f() called: 6 7 f() called: 7 8 f() called: 8 9 f() called: 9 10 f() called: 10
11 2 12 3 13 4 14 5 15 6 16 7
1/2

xic-ref (-target linux -O [basic test]): arrinit06.xi
17 8 18 9 19 10 20 11
2/2

xic-ref (-target linux -O [basic test]): assign02.xi
xic-ref (-target linux -O [basic test]): assign02.xi
Mismatch detected at line 2 of file assign02.s.nml
expected: 47
found   : 9
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/assign02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int
6 x = f(47)
7 println(unparseInt(x)) 8}
9
10 f(x: int): int {
11 println("f() called")
12 return x
13 }
Compiler's standard output:
ASM generated
Generated result:
./assign02.s.nml
1 f() called 29
Expected result:
./assign02.ssol.nml
1 f() called 2 47
1/1

xic-ref (-target linux -O [basic test]): assign03.xi
xic-ref (-target linux -O [basic test]): assign03.xi
Mismatch detected at line 1 of file assign03.s.nml
expected: 3
found   : _xi_out_of_bounds called
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/assign03.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[3]
6 a[0] = 1
7 a[1] = 2
8 a[2] = 3
9 println(unparseInt(length(a)))
10 println(unparseInt(a[1])) 11 }
Compiler's standard output:
ASM generated
Generated result:
./assign03.s.nml
1 _xi_out_of_bounds called
Expected result:
./assign03.ssol.nml
13 22
1/1

xic-ref (-target linux -O [basic test]): assign04.xi
xic-ref (-target linux -O [basic test]): assign04.xi
Mismatch detected at line 1 of file assign04.s.nml
expected: f() called: 1
found   : _xi_out_of_bounds called
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/assign04.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[3]
6 a[0] = f(1)
7 a[1] = f(2)
8 a[2] = f(3)
9 println(unparseInt(length(a)))
10 println(unparseInt(a[1])) 11 }
12
13 f(x: int): int {
14 print("f() called: ") 15 println(unparseInt(x)) 16 return x
17 }
Compiler's standard output:
ASM generated
Generated result:
./assign04.s.nml
1 _xi_out_of_bounds called
Expected result:
./assign04.ssol.nml
1 f() called: 1 2 f() called: 2 3 f() called: 3 43
52
1/1

xic-ref (-target linux -O [basic test]): assign05.xi
xic-ref (-target linux -O [basic test]): assign05.xi
Mismatch detected at line 1 of file assign05.s.nml
expected: f() called: 0
found   : _xi_out_of_bounds called
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/assign05.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[3]
6 a[f(0)] = 1
7 a[f(1)] = 2
8 a[f(2)] = 3
9 println(unparseInt(length(a)))
10 println(unparseInt(a[1])) 11 }
12
13 f(x: int): int {
14 print("f() called: ") 15 println(unparseInt(x)) 16 return x
17 }
Compiler's standard output:
ASM generated
Generated result:
./assign05.s.nml
1 _xi_out_of_bounds called
Expected result:
./assign05.ssol.nml
1 f() called: 0 2 f() called: 1 3 f() called: 2 43
52
1/1

xic-ref (-target linux -O [basic test]): assign06.xi
xic-ref (-target linux -O [basic test]): assign06.xi
Mismatch detected at line 1 of file assign06.s.nml
expected: f() called: 0
found   : _xi_out_of_bounds called
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/assign06.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[3]
6 a[f(0)] = f(3)
7 a[f(1)] = f(4)
8 a[f(2)] = f(5)
9 println(unparseInt(length(a)))
10 println(unparseInt(a[1])) 11 }
12
13 f(x: int): int {
14 print("f() called: ") 15 println(unparseInt(x)) 16 return x
17 }
Compiler's standard output:
ASM generated
Generated result:
./assign06.s.nml
1 _xi_out_of_bounds called
Expected result:
./assign06.ssol.nml
1 f() called: 0 2 f() called: 3 3 f() called: 1 4 f() called: 4 5 f() called: 2 6 f() called: 5 73
84
1/1

xic-ref (-target linux -O [basic test]): assign07.xi
xic-ref (-target linux -O [basic test]): assign07.xi
Failed to execute: assign07 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/assign07.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[] = {1, 2, 3}
6 a[a[f(a, 1)]] = a[g(a, 2)]
7 println(unparseInt(a[0])) 8 println(unparseInt(a[1])) 9 println(unparseInt(a[2]))
10 }
11
12 f(a: int[], i: int): int { 13 print("f() called: ") 14 println(unparseInt(i)) 15 return i
16 }
17
18 g(a: int[], i: int): int { 19 print("g() called: ") 20 println(unparseInt(i))
21 a[i] = 47
22 return i
23 }
Compiler's standard output:
ASM generated
Generated result:
./assign07.s.nml
Expected result:
./assign07.ssol.nml
1 f() called: 1 2 g() called: 2 31
42
5 47
1/1

xic-ref (-target linux -O [basic test]): assign08.xi
xic-ref (-target linux -O [basic test]): assign08.xi
Failed to execute: assign08 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/assign08.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[] = {1, 2, 3}
6 a[f(a, 1)] = a[g(a, 2)]
7}
8
9 f(a: int[], i: int): int {
10 print("f() called: ") 11 println(unparseInt(i))
12 a[i] = 25
13 return i
14 }
15
16 g(a: int[], i: int): int { 17 print("g() called: ") 18 println(unparseInt(i))
19 a[i] = 47
20 return i
21 }
Compiler's standard output:
ASM generated
Generated result:
./assign08.s.nml
Expected result:
./assign08.ssol.nml
1 f() called: 1 2 g() called: 2
1/1

xic-ref (-target linux -O [basic test]): assign09.xi
xic-ref (-target linux -O [basic test]): assign09.xi
Failed to execute: assign09 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/assign09.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int[] = {1, 2, 3, 4}
6 a: int[5][4]
7{ 8
9
i: int = 0
while (i < length(a)) {
10
11
12
13
14 }
15 i=i+ 1 16 }
j: int = 0
while (j < length(a[i])) {
a[i][j] j=j +
=i+ j 1
17 }
18 a[f(x,3)-f(x,2)][f(x,2)-f(x,1)] = 47 19 {
20
21
22
23
24
25
26 }
27 i=i+ 1
28 }
29 }
30 }
31
32 f(a: int[], i: int): int {
33 print("Index: ")
34 println(unparseInt(i))
35 a[i] = a[i] + 1
36 return a[i]
37 }
Compiler's standard output:
ASM generated
Generated result:
./assign09.s.nml
Expected result:
./assign09.ssol.nml
1 Index: 3 2 Index: 2 3 Index: 2 4 Index: 1 50
i: int = 0
while (i < length(a)) {
j: int = 0
while (j < length(a[i])) {
println(unparseInt(a[i][j])) j=j+ 1
1/2

xic-ref (-target linux -O [basic test]): assign09.xi
61 72 83 91
10 2 11 47 12 4 13 2 14 3 15 4 16 5 17 3 18 4 19 5 20 6 21 4 22 5 23 6 24 7
2/2

xic-ref (-target linux -O [basic test]): assign10.xi
xic-ref (-target linux -O [basic test]): assign10.xi
Failed to execute: assign10 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/assign10.xi
1 use io
2 use conv
3
4 main(args: int[][]) { 5 a: int[5][4]
6{
7
8
9
i: int = 0
while (i < length(a)) {
j: int = 0
while (j < length(a[i])) {
10
11
12
13 }
14 i=i+ 1 15 }
=i+ j 1
a[i][j] j=j +
16 }
17 a[f(a, 4, 2)-3][f(a, 4, 2)-6] = 47 18 {
19
20
21
22
23
24
25 }
26 i=i+ 1
27 }
28 }
29 }
30
31 f(a: int[][], i: int, j: int): int { 32 print("Index: ")
33 print(unparseInt(i))
34 print(" ")
35 println(unparseInt(j))
36 a[i][j] = a[i][j] + 1
37 return a[i][j]
38 }
Compiler's standard output:
ASM generated
Generated result:
./assign10.s.nml
Expected result:
./assign10.ssol.nml
1 Index: 4 2 2 Index: 4 2 30
41
i: int = 0
while (i < length(a)) {
j: int = 0
while (j < length(a[i])) {
println(unparseInt(a[i][j])) j=j+ 1
1/2

xic-ref (-target linux -O [basic test]): assign10.xi
52 63 71 82 93
10 4 11 2 12 3 13 4 14 5 15 3 16 4 17 5 18 6 19 4 20 5 21 47 22 7
2/2

xic-ref (-target linux -O [basic test]): binary02.xi
xic-ref (-target linux -O [basic test]): binary02.xi
Mismatch detected at line 1 of file binary02.s.nml
expected: f() called: 1
found   : f() called: 9
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(f(1) + f(2)))
6 println(unparseInt(f(3) - f(2)))
7 println(unparseInt(f(4) * f(2)))
8 println(unparseInt(f(5) *>> f(2)))
9 println(unparseInt(f(6) / f(2)))
10 println(unparseInt(f(7) % f(2)))
11 }
12
13 f(x: int): int {
14 print("f() called: ") 15 println(unparseInt(x)) 16 return x
17 }
Compiler's standard output:
ASM generated
Generated result:
./binary02.s.nml
1 f() called: 9 2 f() called: 9 3 18
4 f() called: 9 5 f() called: 9 60
7 f() called: 9 8 f() called: 9 9 81
10 f() called: 9 11 f() called: 9 12 0
13 f() called: 9 14 f() called: 9 15 1
16 f() called: 9 17 f() called: 9 18 0
Expected result:
./binary02.ssol.nml
1 f() called: 1 2 f() called: 2 33
4 f() called: 3 5 f() called: 2
1/2

xic-ref (-target linux -O [basic test]): binary02.xi
61
7 f() called: 4 8 f() called: 2 98
10 f() called: 5 11 f() called: 2 12 0
13 f() called: 6 14 f() called: 2 15 3
16 f() called: 7 17 f() called: 2 18 1
2/2

xic-ref (-target linux -O [basic test]): binary03.xi
xic-ref (-target linux -O [basic test]): binary03.xi
Mismatch detected at line 2 of file binary03.s.nml
expected: 25
found   : 47
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary03.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(b2s(1 < 2))
6 println(b2s(3 <= 2))
7 println(b2s(4 > 2))
8 println(b2s(5 >= 2))
9 println(b2s(6 == 2))
10 println(b2s(7 != 2))
11 }
12
13 b2s(b: bool): int[] {
14 if (b) { return unparseInt(47) } else { return unparseInt(25) } 15 }
Compiler's standard output:
ASM generated
Generated result:
./binary03.s.nml
1 47 2 47 3 47 4 47 5 47 6 47
Expected result:
./binary03.ssol.nml
1 47 2 25 3 47 4 47 5 25 6 47
1/1

xic-ref (-target linux -O [basic test]): binary04.xi
xic-ref (-target linux -O [basic test]): binary04.xi
Mismatch detected at line 1 of file binary04.s.nml
expected: f() called: 1
found   : f() called: 9
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary04.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(b2s(f(1) < f(2)))
6 println(b2s(f(3) <= f(2)))
7 println(b2s(f(4) > f(2)))
8 println(b2s(f(5) >= f(2)))
9 println(b2s(f(6) == f(2)))
10 println(b2s(f(7) != f(2)))
11 }
12
13 f(x: int): int {
14 print("f() called: ") 15 println(unparseInt(x)) 16 return x
17 }
18
19 b2s(b: bool): int[] {
20 if (b) { return unparseInt(47) } else { return unparseInt(25) } 21 }
Compiler's standard output:
ASM generated
Generated result:
./binary04.s.nml
1 f() called: 9 2 f() called: 9 3 47
4 f() called: 9 5 f() called: 9 6 47
7 f() called: 9 8 f() called: 9 9 47
10 f() called: 9 11 f() called: 9 12 47
13 f() called: 9 14 f() called: 9 15 47
16 f() called: 9 17 f() called: 9 18 47
Expected result:
./binary04.ssol.nml
1 f() called: 1
1/2

xic-ref (-target linux -O [basic test]): binary04.xi
2 f() called: 2 3 47
4 f() called: 3 5 f() called: 2 6 25
7 f() called: 4 8 f() called: 2 9 47
10 f() called: 5 11 f() called: 2 12 47
13 f() called: 6 14 f() called: 2 15 25
16 f() called: 7 17 f() called: 2 18 47
2/2

xic-ref (-target linux -O [basic test]): binary05.xi
xic-ref (-target linux -O [basic test]): binary05.xi
Mismatch detected at line 2 of file binary05.s.nml
expected: 0
found   : 1
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary05.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(b2s(true == true))
6 println(b2s(true == false))
7 println(b2s(false == true))
8 println(b2s(false == false))
9 println(b2s(true != true))
10 println(b2s(true != false))
11 println(b2s(false != true))
12 println(b2s(false != false))
13 println(b2s(true & true))
14 println(b2s(true & false))
15 println(b2s(false & true))
16 println(b2s(false & false))
17 println(b2s(true | true))
18 println(b2s(true | false))
19 println(b2s(false | true))
20 println(b2s(false | false))
21 }
22
23 b2s(b: bool): int[] {
24 if (b) { return unparseInt(1) } else { return unparseInt(0) } 25 }
Compiler's standard output:
ASM generated
Generated result:
./binary05.s.nml
11 21 31 41 51 61 71 81 91
10 1 11 1 12 1 13 1 14 1 15 1 16 1
Expected result:
1/2

xic-ref (-target linux -O [basic test]): binary05.xi
./binary05.ssol.nml
11 20 30 41 50 61 71 80 91
10 0 11 0 12 0 13 1 14 1 15 1 16 0
2/2

xic-ref (-target linux -O [basic test]): binary06.xi
xic-ref (-target linux -O [basic test]): binary06.xi
Mismatch detected at line 5 of file binary06.s.nml
expected: f() called: 0
found   : f() called: 1
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary06.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(b2s(f(true) == f(true)))
6 println(b2s(f(true) == f(false)))
7 println(b2s(f(false) == f(true)))
8 println(b2s(f(false) == f(false)))
9 println(b2s(f(true) != f(true)))
10 println(b2s(f(true) != f(false)))
11 println(b2s(f(false) != f(true)))
12 println(b2s(f(false) != f(false)))
13 println(b2s(f(true) & f(true)))
14 println(b2s(f(true) & f(false)))
15 println(b2s(f(false) & f(true)))
16 println(b2s(f(false) & f(false)))
17 println(b2s(f(true) | f(true)))
18 println(b2s(f(true) | f(false)))
19 println(b2s(f(false) | f(true)))
20 println(b2s(f(false) | f(false)))
21 }
22
23 f(x: bool): bool {
24 print("f() called: ")
25 println(b2s(x))
26 return x
27 }
28
29 b2s(b: bool): int[] {
30 if (b) { return unparseInt(1) } else { return unparseInt(0) } 31 }
Compiler's standard output:
ASM generated
Generated result:
./binary06.s.nml
1 f() called: 1 2 f() called: 1 31
4 f() called: 1 5 f() called: 1 61
7 f() called: 1 8 f() called: 1 91
10 f() called: 1 11 f() called: 1 12 1
1/3

xic-ref (-target linux -O [basic test]): binary06.xi
13 f() called: 1 14 f() called: 1 15 1
16 f() called: 1 17 f() called: 1 18 1
19 f() called: 1 20 f() called: 1 21 1
22 f() called: 1 23 f() called: 1 24 1
25 f() called: 1 26 f() called: 1 27 1
28 f() called: 1 29 f() called: 1 30 1
31 f() called: 1 32 f() called: 1 33 1
34 f() called: 1 35 f() called: 1 36 1
37 f() called: 1 38 1
39 f() called: 1 40 1
41 f() called: 1 42 1
43 f() called: 1 44 1
Expected result:
./binary06.ssol.nml
1 f() called: 1 2 f() called: 1 31
4 f() called: 1 5 f() called: 0 60
7 f() called: 0 8 f() called: 1 90
10 f() called: 0 11 f() called: 0 12 1
13 f() called: 1 14 f() called: 1 15 0
16 f() called: 1 17 f() called: 0 18 1
19 f() called: 0 20 f() called: 1 21 1
22 f() called: 0 23 f() called: 0 24 0
25 f() called: 1
2/3

xic-ref (-target linux -O [basic test]): binary06.xi
26 f() called: 1 27 1
28 f() called: 1 29 f() called: 0 30 0
31 f() called: 0 32 0
33 f() called: 0 34 0
35 f() called: 1 36 1
37 f() called: 1 38 1
39 f() called: 0 40 f() called: 1 41 1
42 f() called: 0 43 f() called: 0 44 0
3/3

xic-ref (-target linux -O [basic test]): binary07.xi
xic-ref (-target linux -O [basic test]): binary07.xi
Mismatch detected at line 1 of file binary07.s.nml
expected: 1
found   : 0
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary07.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a1: int[] = {1, 2, 3}
6 a2: int[] = a1
7 a3: int[] = {1, 2, 3}
8 println(b2s(a1 == a2))
9 println(b2s(a1 != a2))
10 println(b2s(a1 == a3))
11 println(b2s(a1 != a3))
12 println(b2s(a2 == a3))
13 println(b2s(a2 != a3))
14 }
15
16 b2s(b: bool): int[] {
17 if (b) { return unparseInt(1) } else { return unparseInt(0) } 18 }
Compiler's standard output:
ASM generated
Generated result:
./binary07.s.nml
10 20 30 40 50 60
Expected result:
./binary07.ssol.nml
11 20 30 41 50 61
1/1

xic-ref (-target linux -O [basic test]): binary08.xi
xic-ref (-target linux -O [basic test]): binary08.xi
Failed to execute: binary08 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary08.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a1: int[] = {1, 2, 3}
6 a2: int[] = a1
7 a3: int[] = {1, 2, 3}
8 println(b2s(f(a1) == f(a2)))
9 println(b2s(f(a1) != f(a2)))
10 println(b2s(f(a1) == f(a3)))
11 println(b2s(f(a1) != f(a3)))
12 println(b2s(f(a2) == f(a3)))
13 println(b2s(f(a2) != f(a3)))
14 }
15
16 f(x: int[]): int[] {
17 print("f() called: ")
18 printai(x)
19 return x
20 }
21
22 printai(a: int[]) {
23 i: int = 0
24 print("{")
25 while (i < length(a)) {
26 if (i > 0) print(", ")
27 print(unparseInt(a[i]))
28 i=i+ 1
29 }
30 println("}")
31 }
32
33 b2s(b: bool): int[] {
34 if (b) { return unparseInt(1) } else { return unparseInt(0) } 35 }
Compiler's standard output:
ASM generated
Generated result:
./binary08.s.nml
Expected result:
./binary08.ssol.nml
1 f() called: {1, 2, 3} 2 f() called: {1, 2, 3} 31
4 f() called: {1, 2, 3} 5 f() called: {1, 2, 3} 60
7 f() called: {1, 2, 3}
1/2

xic-ref (-target linux -O [basic test]): binary08.xi
8 f() called: {1, 2, 3}
90
10 f() called: {1, 2, 3} 11 f() called: {1, 2, 3} 12 1
13 f() called: {1, 2, 3} 14 f() called: {1, 2, 3} 15 0
16 f() called: {1, 2, 3} 17 f() called: {1, 2, 3} 18 1
2/2

xic-ref (-target linux -O [basic test]): binary09.xi
xic-ref (-target linux -O [basic test]): binary09.xi
Failed to execute: binary09 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary09.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a1: int[] = {1, 2, 3, 4}
6 a2: int[] = {5, 6, 7}
7 a3: int[] = {}
8 printai(a1 + a2)
9 printai(a1 + a3)
10 printai(a2 + a3)
11 }
12
13 printai(a: int[]) { 14 i: int = 0
15 print("{")
16 while (i < length(a)) { 17 if (i > 0) print(", ") 18 print(unparseInt(a[i])) 19 i=i+ 1
20 }
21 println("}")
22 }
Compiler's standard output:
ASM generated
Generated result:
./binary09.s.nml
Expected result:
./binary09.ssol.nml
1 {1, 2, 3, 4, 5, 6, 7} 2 {1, 2, 3, 4}
3 {5, 6, 7}
1/1

xic-ref (-target linux -O [basic test]): binary10.xi
xic-ref (-target linux -O [basic test]): binary10.xi
Failed to execute: binary10 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary10.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a1: int[] = {1, 2, 3, 4}
6 a2: int[] = {5, 6, 7}
7 a3: int[] = {}
8 printai(f(a1) + f(a2))
9 printai(f(a1) + f(a3))
10 printai(f(a2) + f(a3))
11 }
12
13 f(x: int[]): int[] {
14 print("f() called: ") 15 printai(x)
16 return x
17 }
18
19 printai(a: int[]) {
20 i: int = 0
21 print("{")
22 while (i < length(a)) { 23 if (i > 0) print(", ") 24 print(unparseInt(a[i])) 25 i=i+ 1
26 }
27 println("}")
28 }
Compiler's standard output:
ASM generated
Generated result:
./binary10.s.nml
Expected result:
./binary10.ssol.nml
1 f() called: {1, 2, 3, 4} 2 f() called: {5, 6, 7}
3 {1, 2, 3, 4, 5, 6, 7}
4 f() called: {1, 2, 3, 4} 5 f() called: {}
6 {1, 2, 3, 4}
7 f() called: {5, 6, 7} 8 f() called: {}
9 {5, 6, 7}
1/1

xic-ref (-target linux -O [basic test]): binary11.xi
xic-ref (-target linux -O [basic test]): binary11.xi
Failed to execute: binary11 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary11.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int[] = {1, 2, 3}
6 println(unparseInt(f(x, 1) + f(x, 2)))
7 println(unparseInt(f(x, 3) - f(x, 2)))
8 println(unparseInt(f(x, 4) * f(x, 2)))
9 println(unparseInt(f(x, 5) *>> f(x, 2)))
10 println(unparseInt(f(x, 6) / f(x, 2)))
11 println(unparseInt(f(x, 7) % f(x, 2)))
12 println(b2s(f(x, 1) < f(x, 2)))
13 println(b2s(f(x, 3) <= f(x, 2)))
14 println(b2s(f(x, 4) > f(x, 2)))
15 println(b2s(f(x, 5) >= f(x, 2)))
16 println(b2s(f(x, 6) == f(x, 2)))
17 println(b2s(f(x, 7) != f(x, 2)))
18 }
19
20 f(x: int[], y: int): int { 21 print("f() called: ")
22 println(unparseInt(x[0])) 23 println(unparseInt(y))
24 x[0] = x[0] + 1
25 return x[0]
26 }
27
28 b2s(b: bool): int[] {
29 if (b) { return "true" } else { return "false" } 30 }
Compiler's standard output:
ASM generated
Generated result:
./binary11.s.nml
Expected result:
./binary11.ssol.nml
1 f() called: 1 21
3 f() called: 2 42
55
6 f() called: 3 73
8 f() called: 4 92
10 -1
11 f() called: 5 12 4
1/2

xic-ref (-target linux -O [basic test]): binary11.xi
13 f() called: 6 14 2
15 42
16 f() called: 7 17 5
18 f() called: 8 19 2
20 0
21 f() called: 9 22 6
23 f() called: 10 24 2
25 0
26 f() called: 11 27 7
28 f() called: 12 29 2
30 12
31 f() called: 13 32 1
33 f() called: 14 34 2
35 true
36 f() called: 15 37 3
38 f() called: 16 39 2
40 true
41 f() called: 17 42 4
43 f() called: 18 44 2
45 false
46 f() called: 19 47 5
48 f() called: 20 49 2
50 false
51 f() called: 21 52 6
53 f() called: 22 54 2
55 false
56 f() called: 23 57 7
58 f() called: 24 59 2
60 true
2/2

xic-ref (-target linux -O [basic test]): binary12.xi
xic-ref (-target linux -O [basic test]): binary12.xi
Failed to execute: binary12 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/binary12.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: bool[] = {true, false}
6 println(b2s(f(x, true) == f(x, true)))
7 println(b2s(f(x, true) == f(x, false)))
8 println(b2s(f(x, false) == f(x, true)))
9 println(b2s(f(x, false) == f(x, false)))
10 println(b2s(f(x, true) != f(x, true)))
11 println(b2s(f(x, true) != f(x, false)))
12 println(b2s(f(x, false) != f(x, true)))
13 println(b2s(f(x, false) != f(x, false)))
14 println(b2s(f(x, true) & f(x, true)))
15 println(b2s(f(x, true) & f(x, false)))
16 println(b2s(f(x, false) & f(x, true)))
17 println(b2s(f(x, false) & f(x, false)))
18 println(b2s(f(x, true) | f(x, true)))
19 println(b2s(f(x, true) | f(x, false)))
20 println(b2s(f(x, false) | f(x, true)))
21 println(b2s(f(x, false) | f(x, false)))
22 }
23
24 f(x: bool[], y: bool): bool { 25 print("f() called: ")
26 println(b2s(x[0]))
27 println(b2s(y))
28 x[0] = !x[0]
29 return x[0]
30 }
31
32 b2s(b: bool): int[] {
33 if (b) { return unparseInt(1) } else { return unparseInt(0) } 34 }
Compiler's standard output:
ASM generated
Generated result:
./binary12.s.nml
Expected result:
./binary12.ssol.nml
1 f() called: 1 21
3 f() called: 0 41
50
6 f() called: 1 71
8 f() called: 0
1/3

xic-ref (-target linux -O [basic test]): binary12.xi
90 10 0
11 f() called: 1 12 0
13 f() called: 0 14 1
15 0
16 f() called: 1 17 0
18 f() called: 0 19 0
20 0
21 f() called: 1 22 1
23 f() called: 0 24 1
25 1
26 f() called: 1 27 1
28 f() called: 0 29 0
30 1
31 f() called: 1 32 0
33 f() called: 0 34 1
35 1
36 f() called: 1 37 0
38 f() called: 0 39 0
40 1
41 f() called: 1 42 1
43 0
44 f() called: 0 45 1
46 f() called: 1 47 0
48 0
49 f() called: 0 50 0
51 f() called: 1 52 1
53 0
54 f() called: 0 55 0
56 f() called: 1 57 0
58 0
59 f() called: 0 60 1
61 1
62 f() called: 1 63 1
64 f() called: 0 65 0
66 1
67 f() called: 1 68 0
2/3

xic-ref (-target linux -O [basic test]): binary12.xi
69 f() called: 0 70 1
71 1
72 f() called: 1 73 0
74 f() called: 0 75 0
76 1
3/3

xic-ref (-target linux -O [basic test]): functioncall01.xi
xic-ref (-target linux -O [basic test]): functioncall01.xi
Failed to execute: functioncall01 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/functioncall01.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(f(0, 1))) 6}
7
8 f(x: int, y: int): int {
9 print("f() called: ")
10 println(unparseInt(y)) 11 return x + 1
12 }
Compiler's standard output:
ASM generated
Generated result:
./functioncall01.s.nml
Expected result:
./functioncall01.ssol.nml
1 f() called: 1 21
1/1

xic-ref (-target linux -O [basic test]): functioncall02.xi
xic-ref (-target linux -O [basic test]): functioncall02.xi
Failed to execute: functioncall02 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/functioncall02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(f(f(f(f(f(f(f(0, 1), 2), 3), 4), 5), 6), 7))) 6}
7
8 f(x: int, y: int): int {
9 print("f() called: ")
10 println(unparseInt(y)) 11 return x + 1
12 }
Compiler's standard output:
ASM generated
Generated result:
./functioncall02.s.nml
Expected result:
./functioncall02.ssol.nml
1 f() called: 1 2 f() called: 2 3 f() called: 3 4 f() called: 4 5 f() called: 5 6 f() called: 6 7 f() called: 7 87
1/1

xic-ref (-target linux -O [basic test]): functioncall03.xi
xic-ref (-target linux -O [basic test]): functioncall03.xi
Mismatch detected at line 1 of file functioncall03.s.nml
expected: f() called: 1
found   : f() called: 15
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/functioncall03.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(g(f(1), f(2), f(3), f(4), f(5), f(6)))) 6}
7
8 f(x: int): int {
9 print("f() called: ")
10 println(unparseInt(x)) 11 return x
12 }
13
14 g(x1: int, x2: int, x3: int, x4: int, x5: int, x6: int): int { 15 print("g() called: ")
16 print(unparseInt(x1))
17 print(" ")
18 print(unparseInt(x2)) 19 print(" ")
20 print(unparseInt(x3)) 21 print(" ")
22 print(unparseInt(x4)) 23 print(" ")
24 print(unparseInt(x5)) 25 print(" ")
26 print(unparseInt(x6))
27 println("")
28 return x1 + x2 + x3 + x4 + x5 + x6 29 }
Compiler's standard output:
ASM generated
Generated result:
./functioncall03.s.nml
1 f() called: 15
2 f() called: 15
3 f() called: 15
4 f() called: 15
5 f() called: 15
6 f() called: 15
7 g() called: 15 15 15 15 15 15 8 90
Expected result:
./functioncall03.ssol.nml
1 f() called: 1 2 f() called: 2
1/2

xic-ref (-target linux -O [basic test]): functioncall03.xi
3 f() called: 3
4 f() called: 4
5 f() called: 5
6 f() called: 6
7 g() called: 1 2 3 4 5 6 8 21
2/2

xic-ref (-target linux -O [basic test]): functioncall04.xi
xic-ref (-target linux -O [basic test]): functioncall04.xi
Failed to execute: functioncall04 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/functioncall04.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int[] = {1, 2, 3}
6 println(unparseInt(g(f(x, 1), f(x, 2), f(x, 3), f(x, 4), f(x, 5), f(x, 6))))
7}
8
9 f(x: int[], y: int): int {
10 print("f() called: ") 11 println(unparseInt(y))
12 x[0] = x[0] + 1
13 return x[0]
14 }
15
16 g(x1: int, x2: int, x3: int, x4: int, x5: int, x6: int): int { 17 print("g() called: ")
18 print(unparseInt(x1))
19 print(" ")
20 print(unparseInt(x2))
21 print(" ")
22 print(unparseInt(x3))
23 print(" ")
24 print(unparseInt(x4))
25 print(" ")
26 print(unparseInt(x5))
27 print(" ")
28 print(unparseInt(x6))
29 println("")
30 return x1 + x2 + x3 + x4 + x5 + x6
31 }
Compiler's standard output:
ASM generated
Generated result:
./functioncall04.s.nml
Expected result:
./functioncall04.ssol.nml
1 f() called: 1
2 f() called: 2
3 f() called: 3
4 f() called: 4
5 f() called: 5
6 f() called: 6
7 g() called: 2 3 4 5 6 7 8 27
1/1

xic-ref (-target linux -O [basic test]): if05.xi
xic-ref (-target linux -O [basic test]): if05.xi
Failed to execute: if05 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/if05.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 if (lt(0, 0)) println("true")
6 if (lt(0, -1)) println("true")
7 if (lt(0, 1)) println("true")
8 println("printed") 9}
10
11 lt(x: int, y: int): bool { 12 print("lt() called: ") 13 print(unparseInt(x))
14 print(" < ")
15 println(unparseInt(y)) 16 return x < y
17 }
Compiler's standard output:
ASM generated
Generated result:
./if05.s.nml
Expected result:
./if05.ssol.nml
1 lt() called: 0 < 0 2 lt() called: 0 < -1 3 lt() called: 0 < 1 4 true
5 printed
1/1

xic-ref (-target linux -O [basic test]): if06.xi
xic-ref (-target linux -O [basic test]): if06.xi
Failed to execute: if06 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/if06.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 if (lt(0, 0)) println("true") else println("false")
6 if (lt(0, -1)) println("true") else println("false")
7 if (lt(0, 1)) println("true") else println("false")
8 println("printed") 9}
10
11 lt(x: int, y: int): bool { 12 print("lt() called: ") 13 print(unparseInt(x))
14 print(" < ")
15 println(unparseInt(y)) 16 return x < y
17 }
Compiler's standard output:
ASM generated
Generated result:
./if06.s.nml
Expected result:
./if06.ssol.nml
1 lt() called: 0 < 0 2 false
3 lt() called: 0 < -1 4 false
5 lt() called: 0 < 1 6 true
7 printed
1/1

xic-ref (-target linux -O [basic test]): if07.xi
xic-ref (-target linux -O [basic test]): if07.xi
Failed to execute: if07 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/if07.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 if (lt(0, 0) & lt(0, 0)) println("true")
6 if (lt(0, 0) & lt(0, -1)) println("true")
7 if (lt(0, 0) & lt(0, 1)) println("true")
8 if (lt(0, -1) & lt(0, 0)) println("true")
9 if (lt(0, -1) & lt(0, -1)) println("true")
10 if (lt(0, -1) & lt(0, 1)) println("true")
11 if (lt(0, 1) & lt(0, 0)) println("true")
12 if (lt(0, 1) & lt(0, -1)) println("true")
13 if (lt(0, 1) & lt(0, 1)) println("true")
14 println("printed")
15 }
16
17 lt(x: int, y: int): bool { 18 print("lt() called: ") 19 print(unparseInt(x))
20 print(" < ")
21 println(unparseInt(y)) 22 return x < y
23 }
Compiler's standard output:
ASM generated
Generated result:
./if07.s.nml
Expected result:
./if07.ssol.nml
1 lt() called: 0 < 0 2 lt() called: 0 < 0 3 lt() called: 0 < 0 4 lt() called: 0 < -1 5 lt() called: 0 < -1 6 lt() called: 0 < -1 7 lt() called: 0 < 1 8 lt() called: 0 < 0 9 lt() called: 0 < 1 10 lt() called: 0 < -1
11 lt() called: 0 < 1 12 lt() called: 0 < 1 13 true
14 printed
1/1

xic-ref (-target linux -O [basic test]): if08.xi
xic-ref (-target linux -O [basic test]): if08.xi
Failed to execute: if08 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/if08.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 if (lt(0, 0) & lt(0, 0)) println("true") else println("false")
6 if (lt(0, 0) & lt(0, -1)) println("true") else println("false")
7 if (lt(0, 0) & lt(0, 1)) println("true") else println("false")
8 if (lt(0, -1) & lt(0, 0)) println("true") else println("false")
9 if (lt(0, -1) & lt(0, -1)) println("true") else println("false")
10 if (lt(0, -1) & lt(0, 1)) println("true") else println("false")
11 if (lt(0, 1) & lt(0, 0)) println("true") else println("false")
12 if (lt(0, 1) & lt(0, -1)) println("true") else println("false")
13 if (lt(0, 1) & lt(0, 1)) println("true") else println("false")
14 println("printed")
15 }
16
17 lt(x: int, y: int): bool { 18 print("lt() called: ") 19 print(unparseInt(x))
20 print(" < ")
21 println(unparseInt(y)) 22 return x < y
23 }
Compiler's standard output:
ASM generated
Generated result:
./if08.s.nml
Expected result:
./if08.ssol.nml
1 lt() called: 0 < 0 2 false
3 lt() called: 0 < 0 4 false
5 lt() called: 0 < 0 6 false
7 lt() called: 0 < -1 8 false
9 lt() called: 0 < -1 10 false
11 lt() called: 0 < -1 12 false
13 lt() called: 0 < 1 14 lt() called: 0 < 0 15 false
16 lt() called: 0 < 1 17 lt() called: 0 < -1 18 false
19 lt() called: 0 < 1
1/2

xic-ref (-target linux -O [basic test]): if08.xi
20 lt() called: 0 < 1 21 true
22 printed
2/2

xic-ref (-target linux -O [basic test]): if09.xi
xic-ref (-target linux -O [basic test]): if09.xi
Failed to execute: if09 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/if09.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 if (lt(0, 0) | lt(0, 0)) println("true")
6 if (lt(0, 0) | lt(0, -1)) println("true")
7 if (lt(0, 0) | lt(0, 1)) println("true")
8 if (lt(0, -1) | lt(0, 0)) println("true")
9 if (lt(0, -1) | lt(0, -1)) println("true")
10 if (lt(0, -1) | lt(0, 1)) println("true")
11 if (lt(0, 1) | lt(0, 0)) println("true")
12 if (lt(0, 1) | lt(0, -1)) println("true")
13 if (lt(0, 1) | lt(0, 1)) println("true")
14 println("printed")
15 }
16
17 lt(x: int, y: int): bool { 18 print("lt() called: ") 19 print(unparseInt(x))
20 print(" < ")
21 println(unparseInt(y)) 22 return x < y
23 }
Compiler's standard output:
ASM generated
Generated result:
./if09.s.nml
Expected result:
./if09.ssol.nml
1 lt() called: 0 < 0 2 lt() called: 0 < 0 3 lt() called: 0 < 0 4 lt() called: 0 < -1 5 lt() called: 0 < 0 6 lt() called: 0 < 1 7 true
8 lt() called: 0 < -1
9 lt() called: 0 < 0 10 lt() called: 0 < -1 11 lt() called: 0 < -1 12 lt() called: 0 < -1 13 lt() called: 0 < 1 14 true
15 lt() called: 0 < 1 16 true
17 lt() called: 0 < 1 18 true
19 lt() called: 0 < 1
1/2

xic-ref (-target linux -O [basic test]): if09.xi
20 true 21 printed
2/2

xic-ref (-target linux -O [basic test]): if10.xi
xic-ref (-target linux -O [basic test]): if10.xi
Failed to execute: if10 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/if10.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 if (lt(0, 0) | lt(0, 0)) println("true") else println("false")
6 if (lt(0, 0) | lt(0, -1)) println("true") else println("false")
7 if (lt(0, 0) | lt(0, 1)) println("true") else println("false")
8 if (lt(0, -1) | lt(0, 0)) println("true") else println("false")
9 if (lt(0, -1) | lt(0, -1)) println("true") else println("false")
10 if (lt(0, -1) | lt(0, 1)) println("true") else println("false")
11 if (lt(0, 1) | lt(0, 0)) println("true") else println("false")
12 if (lt(0, 1) | lt(0, -1)) println("true") else println("false")
13 if (lt(0, 1) | lt(0, 1)) println("true") else println("false")
14 println("printed")
15 }
16
17 lt(x: int, y: int): bool { 18 print("lt() called: ") 19 print(unparseInt(x))
20 print(" < ")
21 println(unparseInt(y)) 22 return x < y
23 }
Compiler's standard output:
ASM generated
Generated result:
./if10.s.nml
Expected result:
./if10.ssol.nml
1 lt() called: 0 < 0 2 lt() called: 0 < 0 3 false
4 lt() called: 0 < 0 5 lt() called: 0 < -1 6 false
7 lt() called: 0 < 0 8 lt() called: 0 < 1 9 true
10 lt() called: 0 < -1 11 lt() called: 0 < 0 12 false
13 lt() called: 0 < -1 14 lt() called: 0 < -1 15 false
16 lt() called: 0 < -1 17 lt() called: 0 < 1 18 true
19 lt() called: 0 < 1
1/2

xic-ref (-target linux -O [basic test]): if10.xi
20 true
21 lt() called: 0 < 1 22 true
23 lt() called: 0 < 1 24 true
25 printed
2/2

xic-ref (-target linux -O [basic test]): length01.xi
xic-ref (-target linux -O [basic test]): length01.xi
Mismatch detected at line 1 of file length01.s.nml
expected: 5
found   : 0
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/length01.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[] = {1, 2, 3, 4, 5}
6 println(unparseInt(length(a))) 7}
Compiler's standard output:
ASM generated
Generated result:
./length01.s.nml
10
Expected result:
./length01.ssol.nml
15
1/1

xic-ref (-target linux -O [basic test]): length02.xi
xic-ref (-target linux -O [basic test]): length02.xi
Failed to execute: length02 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/length02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[][] = {{1}, {2, 3}, {4, 5, 6}, {7, 8, 9, 10}} 6 println(unparseInt(length(a)))
7{
8
9
10
11
12 } 13 } 14 }
println(unparseInt(length(a[i]))) i=i+ 1
i: int = 0
while (i < length(a)) {
Compiler's standard output:
ASM generated
Generated result:
./length02.s.nml
Expected result:
./length02.ssol.nml
14 21 32 43 54
1/1

xic-ref (-target linux -O [basic test]): localdecl03.xi
xic-ref (-target linux -O [basic test]): localdecl03.xi
Failed to execute: localdecl03 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/localdecl03.xi
1 use io
2 use conv
3
4 main(args: int[][]) { 5 x: int[1][2][3][4][5] 6 println("done")
7}
Compiler's standard output:
ASM generated
Generated result:
./localdecl03.s.nml
Expected result:
./localdecl03.ssol.nml
1 done
1/1

xic-ref (-target linux -O [basic test]): localdecl06.xi
xic-ref (-target linux -O [basic test]): localdecl06.xi
Failed to execute: localdecl06 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/localdecl06.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a1: int[25][][][][]
6 a2: int[47][][][]
7 a3: int[20][][]
8 a4: int[16][]
9 a5: int[42]
10 a1[17] = a2
11 a1[17][16] = a3
12 a1[17][16][15] = a4
13 a1[17][16][15][14] = a5
14 a1[17][16][15][14][13] = 12
15 println(unparseInt(length(a1)))
16 println(unparseInt(length(a1[17])))
17 println(unparseInt(length(a1[17][16])))
18 println(unparseInt(length(a1[17][16][15])))
19 println(unparseInt(length(a1[17][16][15][14]))) 20 println(unparseInt(a1[17][16][15][14][13]))
21 println("done")
22 }
Compiler's standard output:
ASM generated
Generated result:
./localdecl06.s.nml
Expected result:
./localdecl06.ssol.nml
1 25 2 47 3 20 4 16 5 42 6 12 7 done
1/1

xic-ref (-target linux -O [basic test]): localdecl13.xi
xic-ref (-target linux -O [basic test]): localdecl13.xi
Failed to execute: localdecl13 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/localdecl13.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[] = {1, 2, 3}
6 x: int[f(a, 0)][f(a, 0)][f(a, 0)][][]
7 println(unparseInt(length(x)))
8 println(unparseInt(length(x[0])))
9 println(unparseInt(length(x[0][0])))
10 println(unparseInt(a[0])) 11 println(unparseInt(a[1])) 12 println(unparseInt(a[2])) 13 }
14
15 f(a: int[], i: int): int { 16 print("Index: ")
17 println(unparseInt(i))
18 a[i] = a[i] + 1
19 return a[i]
20 }
Compiler's standard output:
ASM generated
Generated result:
./localdecl13.s.nml
Expected result:
./localdecl13.ssol.nml
1 Index: 0 2 Index: 0 3 Index: 0 42
53 64 74 82 93
1/1

xic-ref (-target linux -O [basic test]): localdecl14.xi
xic-ref (-target linux -O [basic test]): localdecl14.xi
Failed to execute: localdecl14 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/localdecl14.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 a: int[] = {1, 2, 3, 4}
6 x: int[f(a,3)-f(a,2)][f(a,2)-f(a,1)][f(a,1)-f(a,0)][][]
7 println(unparseInt(length(x)))
8 println(unparseInt(length(x[0])))
9 println(unparseInt(length(x[0][0])))
10 println(unparseInt(a[0])) 11 println(unparseInt(a[1])) 12 println(unparseInt(a[2])) 13 println(unparseInt(a[3])) 14 }
15
16 f(a: int[], i: int): int { 17 print("Index: ")
18 println(unparseInt(i))
19 a[i] = a[i] + 1
20 return a[i]
21 }
Compiler's standard output:
ASM generated
Generated result:
./localdecl14.s.nml
Expected result:
./localdecl14.ssol.nml
1 Index: 3 2 Index: 2 3 Index: 2 4 Index: 1 5 Index: 1 6 Index: 0 71
82
92 10 2 11 4 12 5 13 5
1/1

xic-ref (-target linux -O [basic test]): procedurecall02.xi
xic-ref (-target linux -O [basic test]): procedurecall02.xi
Failed to execute: procedurecall02 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/procedurecall02.xi
1 use io
2 use conv
3
4 main(args: int[][]) { 5 p(47)
6}
7
8 p(x: int) {
9 print("p() called: ")
10 println(unparseInt(x)) 11 if (x <= 0) { return } 12 p(x-1)
13 print("p() post-call: ") 14 println(unparseInt(x)) 15 }
Compiler's standard output:
ASM generated
Generated result:
./procedurecall02.s.nml
Expected result:
./procedurecall02.ssol.nml
1 p() called: 47 2 p() called: 46 3 p() called: 45 4 p() called: 44 5 p() called: 43 6 p() called: 42 7 p() called: 41 8 p() called: 40 9 p() called: 39
10 p() called: 38 11 p() called: 37 12 p() called: 36 13 p() called: 35 14 p() called: 34 15 p() called: 33 16 p() called: 32 17 p() called: 31 18 p() called: 30 19 p() called: 29 20 p() called: 28 21 p() called: 27 22 p() called: 26 23 p() called: 25 24 p() called: 24 25 p() called: 23 26 p() called: 22
1/3

xic-ref (-target linux -O [basic test]): procedurecall02.xi
27 p() called: 21 28 p() called: 20 29 p() called: 19 30 p() called: 18 31 p() called: 17 32 p() called: 16 33 p() called: 15 34 p() called: 14 35 p() called: 13 36 p() called: 12 37 p() called: 11 38 p() called: 10 39 p() called: 9
40 p() called: 8
41 p() called: 7
42 p() called: 6
43 p() called: 5
44 p() called: 4
45 p() called: 3
46 p() called: 2
47 p() called: 1
48 p() called: 0
49 p() post-call: 1 50 p() post-call: 2 51 p() post-call: 3 52 p() post-call: 4 53 p() post-call: 5 54 p() post-call: 6 55 p() post-call: 7 56 p() post-call: 8 57 p() post-call: 9 58 p() post-call: 10 59 p() post-call: 11 60 p() post-call: 12 61 p() post-call: 13 62 p() post-call: 14 63 p() post-call: 15 64 p() post-call: 16 65 p() post-call: 17 66 p() post-call: 18 67 p() post-call: 19 68 p() post-call: 20 69 p() post-call: 21 70 p() post-call: 22 71 p() post-call: 23 72 p() post-call: 24 73 p() post-call: 25 74 p() post-call: 26 75 p() post-call: 27 76 p() post-call: 28 77 p() post-call: 29 78 p() post-call: 30 79 p() post-call: 31 80 p() post-call: 32 81 p() post-call: 33 82 p() post-call: 34 83 p() post-call: 35 84 p() post-call: 36 85 p() post-call: 37 86 p() post-call: 38
2/3

xic-ref (-target linux -O [basic test]): procedurecall02.xi
87 p() post-call: 39 88 p() post-call: 40 89 p() post-call: 41 90 p() post-call: 42 91 p() post-call: 43 92 p() post-call: 44 93 p() post-call: 45 94 p() post-call: 46 95 p() post-call: 47
3/3

xic-ref (-target linux -O [basic test]): procedurecall04.xi
xic-ref (-target linux -O [basic test]): procedurecall04.xi
Failed to execute: procedurecall04 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/procedurecall04.xi
1 use io
2 use conv
3
4 main(args: int[][]) { 5 p(47)
6}
7
8 p(x: int) {
9 print("p() called: ")
10 println(unparseInt(x)) 11 if (x <= 0) { return } 12 p(x-1)
13 print("p() post-call: ") 14 println(unparseInt(x)) 15 return
16 }
Compiler's standard output:
ASM generated
Generated result:
./procedurecall04.s.nml
Expected result:
./procedurecall04.ssol.nml
1 p() called: 47 2 p() called: 46 3 p() called: 45 4 p() called: 44 5 p() called: 43 6 p() called: 42 7 p() called: 41 8 p() called: 40 9 p() called: 39
10 p() called: 38 11 p() called: 37 12 p() called: 36 13 p() called: 35 14 p() called: 34 15 p() called: 33 16 p() called: 32 17 p() called: 31 18 p() called: 30 19 p() called: 29 20 p() called: 28 21 p() called: 27 22 p() called: 26 23 p() called: 25 24 p() called: 24 25 p() called: 23
1/3

xic-ref (-target linux -O [basic test]): procedurecall04.xi
26 p() called: 22 27 p() called: 21 28 p() called: 20 29 p() called: 19 30 p() called: 18 31 p() called: 17 32 p() called: 16 33 p() called: 15 34 p() called: 14 35 p() called: 13 36 p() called: 12 37 p() called: 11 38 p() called: 10 39 p() called: 9
40 p() called: 8
41 p() called: 7
42 p() called: 6
43 p() called: 5
44 p() called: 4
45 p() called: 3
46 p() called: 2
47 p() called: 1
48 p() called: 0
49 p() post-call: 1 50 p() post-call: 2 51 p() post-call: 3 52 p() post-call: 4 53 p() post-call: 5 54 p() post-call: 6 55 p() post-call: 7 56 p() post-call: 8 57 p() post-call: 9 58 p() post-call: 10 59 p() post-call: 11 60 p() post-call: 12 61 p() post-call: 13 62 p() post-call: 14 63 p() post-call: 15 64 p() post-call: 16 65 p() post-call: 17 66 p() post-call: 18 67 p() post-call: 19 68 p() post-call: 20 69 p() post-call: 21 70 p() post-call: 22 71 p() post-call: 23 72 p() post-call: 24 73 p() post-call: 25 74 p() post-call: 26 75 p() post-call: 27 76 p() post-call: 28 77 p() post-call: 29 78 p() post-call: 30 79 p() post-call: 31 80 p() post-call: 32 81 p() post-call: 33 82 p() post-call: 34 83 p() post-call: 35 84 p() post-call: 36 85 p() post-call: 37
2/3

xic-ref (-target linux -O [basic test]): procedurecall04.xi
86 p() post-call: 38 87 p() post-call: 39 88 p() post-call: 40 89 p() post-call: 41 90 p() post-call: 42 91 p() post-call: 43 92 p() post-call: 44 93 p() post-call: 45 94 p() post-call: 46 95 p() post-call: 47
3/3

xic-ref (-target linux -O [basic test]): procedurecall05.xi
xic-ref (-target linux -O [basic test]): procedurecall05.xi
Failed to execute: procedurecall05 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/procedurecall05.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 p(f(1), f(2), f(3), f(4), f(5), f(6)) 6}
7
8 f(x: int): int {
9 print("f() called: ")
10 println(unparseInt(x)) 11 return x
12 }
13
14 p(x1: int, x2: int, x3: int, x4: int, x5: int, x6: int) { 15 print("p() called: ")
16 print(unparseInt(x1))
17 print(" ")
18 print(unparseInt(x2)) 19 print(" ")
20 print(unparseInt(x3)) 21 print(" ")
22 print(unparseInt(x4)) 23 print(" ")
24 print(unparseInt(x5)) 25 print(" ")
26 print(unparseInt(x6)) 27 println("")
28 }
Compiler's standard output:
ASM generated
Generated result:
./procedurecall05.s.nml
Expected result:
./procedurecall05.ssol.nml
1 f() called: 1
2 f() called: 2
3 f() called: 3
4 f() called: 4
5 f() called: 5
6 f() called: 6
7 p() called: 1 2 3 4 5 6
1/1

xic-ref (-target linux -O [basic test]): procedurecall06.xi
xic-ref (-target linux -O [basic test]): procedurecall06.xi
Failed to execute: procedurecall06 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/procedurecall06.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int[] = {1, 2, 3}
6 p(f(x, 1), f(x, 2), f(x, 3), f(x, 4), f(x, 5), f(x, 6))
7}
8
9 f(x: int[], y: int): int {
10 print("f() called: ") 11 println(unparseInt(y))
12 x[0] = x[0] + 1
13 return x[0]
14 }
15
16 p(x1: int, x2: int, x3: int, x4: int, x5: int, x6: int) { 17 print("p() called: ")
18 print(unparseInt(x1))
19 print(" ")
20 print(unparseInt(x2))
21 print(" ")
22 print(unparseInt(x3))
23 print(" ")
24 print(unparseInt(x4))
25 print(" ")
26 print(unparseInt(x5))
27 print(" ")
28 print(unparseInt(x6))
29 println("")
30 }
Compiler's standard output:
ASM generated
Generated result:
./procedurecall06.s.nml
Expected result:
./procedurecall06.ssol.nml
1 f() called: 1
2 f() called: 2
3 f() called: 3
4 f() called: 4
5 f() called: 5
6 f() called: 6
7 p() called: 2 3 4 5 6 7
1/1

xic-ref (-target linux -O [basic test]): unary02.xi
xic-ref (-target linux -O [basic test]): unary02.xi
Failed to execute: unary02 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/unary02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(-f(47))) 6 println(unparseInt(-f(0))) 7}
8
9 f(x: int): int {
10 println("f() called: " + unparseInt(x))
11 return x
12 }
Compiler's standard output:
ASM generated
Generated result:
./unary02.s.nml
Expected result:
./unary02.ssol.nml
1 f() called: 47 2 -47
3 f() called: 0 40
1/1

xic-ref (-target linux -O [basic test]): unary03.xi
xic-ref (-target linux -O [basic test]): unary03.xi
Mismatch detected at line 1 of file unary03.s.nml
expected: false
found   : true
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/unary03.xi
1 use io
2 use conv
3
4 main(args: int[][]) { 5 println(b2s(!true)) 6 println(b2s(!false)) 7}
8
9 b2s(b: bool): int[] {
10 if (b) { return "true" } else { return "false" } 11 }
Compiler's standard output:
ASM generated
Generated result:
./unary03.s.nml
1 true 2 true
Expected result:
./unary03.ssol.nml
1 false 2 true
1/1

xic-ref (-target linux -O [basic test]): unary04.xi
xic-ref (-target linux -O [basic test]): unary04.xi
Failed to execute: unary04 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/unary04.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(b2s(!f(true))) 6 println(b2s(!f(false))) 7}
8
9 f(x: bool): bool {
10 println("f() called: " + b2s(x))
11 return x
12 } 13
14 b2s(b: bool): int[] {
15 if (b) { return "true" } else { return "false" } 16 }
Compiler's standard output:
ASM generated
Generated result:
./unary04.s.nml
Expected result:
./unary04.ssol.nml
1 f() called: true 2 false
3 f() called: false 4 true
1/1

xic-ref (-target linux -O [basic test]): while02.xi
xic-ref (-target linux -O [basic test]): while02.xi
Failed to execute: while02 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/while02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int = 0
6 while (lt(x, 7)) {
7 println(unparseInt(x)) 8 x=x+ 1
9}
10 println("done")
11 }
12
13 lt(x: int, y: int): bool {
14 println("lt() called: " + unparseInt(x) + " < " + unparseInt(y))
15 return x < y
16 }
Compiler's standard output:
ASM generated
Generated result:
./while02.s.nml
Expected result:
./while02.ssol.nml
1 lt() called: 0 < 7 20
3 lt() called: 1 < 7 41
5 lt() called: 2 < 7 62
7 lt() called: 3 < 7 83
9 lt() called: 4 < 7 10 4
11 lt() called: 5 < 7 12 5
13 lt() called: 6 < 7 14 6
15 lt() called: 7 < 7 16 done
1/1

xic-ref (-target linux -O [basic test]): while03.xi
xic-ref (-target linux -O [basic test]): while03.xi
Failed to execute: while03 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/while03.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int = 0
6 while (f() & lt(x, 7) & g()) {
7 println(unparseInt(x)) 8 x=x+ 1
9}
10 println("done")
11 }
12
13 lt(x: int, y: int): bool { 14 print("lt() called: ") 15 print(unparseInt(x))
16 print(" < ")
17 println(unparseInt(y)) 18 return x < y
19 }
20
21 f(): bool {
22 println("f() called")
23 return true
24 }
25
26 g(): bool {
27 println("g() called")
28 return true
29 }
Compiler's standard output:
ASM generated
Generated result:
./while03.s.nml
Expected result:
./while03.ssol.nml
1 f() called
2 lt() called: 0 < 7 3 g() called
40
5 f() called
6 lt() called: 1 < 7 7 g() called
81
9 f() called
10 lt() called: 2 < 7 11 g() called
12 2
13 f() called
1/2

xic-ref (-target linux -O [basic test]): while03.xi
14 lt() called: 3 < 7 15 g() called
16 3
17 f() called
18 lt() called: 4 < 7 19 g() called
20 4
21 f() called
22 lt() called: 5 < 7 23 g() called
24 5
25 f() called
26 lt() called: 6 < 7 27 g() called
28 6
29 f() called
30 lt() called: 7 < 7 31 done
2/2

xic-ref (-target linux -O [basic test]): while04.xi
xic-ref (-target linux -O [basic test]): while04.xi
Failed to execute: while04 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/base/while04.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 x: int = 0
6 while (f() | lt(x, 7) | g()) {
7 println(unparseInt(x)) 8 x=x+ 1
9}
10 println("done")
11 }
12
13 lt(x: int, y: int): bool { 14 print("lt() called: ") 15 print(unparseInt(x))
16 print(" < ")
17 println(unparseInt(y)) 18 return x < y
19 }
20
21 f(): bool {
22 println("f() called")
23 return false
24 }
25
26 g(): bool {
27 println("g() called")
28 return false
29 }
Compiler's standard output:
ASM generated
Generated result:
./while04.s.nml
Expected result:
./while04.ssol.nml
1 f() called
2 lt() called: 0 < 7 30
4 f() called
5 lt() called: 1 < 7 61
7 f() called
8 lt() called: 2 < 7 92
10 f() called
11 lt() called: 3 < 7 12 3
13 f() called
1/2

xic-ref (-target linux -O [basic test]): while04.xi
14 lt() called: 4 < 7 15 4
16 f() called
17 lt() called: 5 < 7 18 5
19 f() called
20 lt() called: 6 < 7 21 6
22 f() called
23 lt() called: 7 < 7 24 g() called
25 done
2/2

xic-ref (-target linux [combo test]): fac01.xi
xic-ref (-target linux [combo test]): fac01.xi
Failed to execute: fac01 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/fac01.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(fac(7))) 6}
7
8 fac(n: int): int {
9 if (n <= 1) { return 1 }
10 return n * fac(n-1)
11 }
Compiler's standard output:
ASM generated
Generated result:
./fac01.s.nml
Expected result:
./fac01.ssol.nml
1 5040
1/1

xic-ref (-target linux [combo test]): fac02.xi
xic-ref (-target linux [combo test]): fac02.xi
Mismatch detected at line 1 of file fac02.s.nml
expected: 5040
found   : 720
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/fac02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(fac(7))) 6}
7
8 fac(n: int): int {
9 10 11 12 13
i: int = 1
result: int = 1
while (i <= n) {
result = result * i i=i+ 1
14 }
15 return result 16 }
Compiler's standard output:
ASM generated
Generated result:
./fac02.s.nml
1 720
Expected result:
./fac02.ssol.nml
1 5040
1/1

xic-ref (-target linux [combo test]): fac03.xi
xic-ref (-target linux [combo test]): fac03.xi
Failed to execute: fac03 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/fac03.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(fac(7))) 6}
7
8 fac(n: int): int {
9 return fac'(n, 1)
10 }
11
12 fac'(n: int, accum: int): int {
13 if (n <= 1) { return accum }
14 return fac'(n-1, n*accum)
15 }
Compiler's standard output:
ASM generated
Generated result:
./fac03.s.nml
Expected result:
./fac03.ssol.nml
1 5040
1/1

xic-ref (-target linux [combo test]): fib01.xi
xic-ref (-target linux [combo test]): fib01.xi
Failed to execute: fib01 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/fib01.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(fib(7))) 6}
7
8 fib(n: int): int {
9 if (n <= 0) { return 0 }
10 if (n == 1) { return 1 }
11 return fib(n-1) + fib(n-2)
12 }
Compiler's standard output:
ASM generated
Generated result:
./fib01.s.nml
Expected result:
./fib01.ssol.nml
1 13
1/1

xic-ref (-target linux [combo test]): fib02.xi
xic-ref (-target linux [combo test]): fib02.xi
Mismatch detected at line 1 of file fib02.s.nml
expected: 13
found   : 8
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/fib02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(fib(7))) 6}
7
8 fib(n: int): int {
 9
10
11
12
13
14
15
16
17
i: int = 2
r: int = 1
r1: int = 0
if (n <= 0) { return r1 }
while (i <= n) {
newr: int = r + r1 r1 = r
r = newr
i=i+ 1
18 }
19 return r 20 }
Compiler's standard output:
ASM generated
Generated result:
./fib02.s.nml
18
Expected result:
./fib02.ssol.nml
1 13
1/1

xic-ref (-target linux [combo test]): medley01.xi
xic-ref (-target linux [combo test]): medley01.xi
Failed to execute: medley01 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/medley01.xi
1 use io
2 use conv
3
4 main(args:int[][]) {
5 println({{"hello"}, {"world"}}[1][0])
6 _ = id(id(id(1)))
7
8 foo() 9
10 aa:int[][] = {{1,2,3},{4,5},{6}}
11 ff(aa)[1] = aa[2][0]
12 println(unparseInt(aa[0][1]))
13 println(unparseInt(length(aa[2]))) 14
15 aa[0][2] = gg(aa)
16 println(unparseInt(aa[0][2])) 17 }
18
19 ff(a:int[][]): int[] {
20 a[2] = {47,48,49,50}
21 return a[0]
22 }
23
24 gg(a:int[][]): int {
25 a[0] = {0}
26 return 59
27 }
28
29 foo() {
30 a:int[] = {1,2,3}
31 a[f(a)[1]] = a[g(a)]
32 println(unparseInt(a[0])) 33 println(unparseInt(a[1])) 34 println(unparseInt(a[2])) 35 }
36
37 f(a:int[]):int[] {
38 println("hello");
39 return a;
40 }
41
42 g(a:int[]):int {
43 println("world");
44 a[1] = 6
45 return 1;
46 }
47
48 id(x: int): int { 49 return x;
50 }
1/2

xic-ref (-target linux [combo test]): medley01.xi Compiler's standard output:
ASM generated
Generated result:
./medley01.s.nml
Expected result:
./medley01.ssol.nml
1 _xi_out_of_bounds called
2/2

xic-ref (-target linux -O [combo test]): fac01.xi
xic-ref (-target linux -O [combo test]): fac01.xi
Failed to execute: fac01 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/fac01.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(fac(7))) 6}
7
8 fac(n: int): int {
9 if (n <= 1) { return 1 }
10 return n * fac(n-1)
11 }
Compiler's standard output:
ASM generated
Generated result:
./fac01.s.nml
Expected result:
./fac01.ssol.nml
1 5040
1/1

xic-ref (-target linux -O [combo test]): fac02.xi
xic-ref (-target linux -O [combo test]): fac02.xi
Mismatch detected at line 1 of file fac02.s.nml
expected: 5040
found   : 720
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/fac02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(fac(7))) 6}
7
8 fac(n: int): int {
9 10 11 12 13
i: int = 1
result: int = 1
while (i <= n) {
result = result * i i=i+ 1
14 }
15 return result 16 }
Compiler's standard output:
ASM generated
Generated result:
./fac02.s.nml
1 720
Expected result:
./fac02.ssol.nml
1 5040
1/1

xic-ref (-target linux -O [combo test]): fac03.xi
xic-ref (-target linux -O [combo test]): fac03.xi
Failed to execute: fac03 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/fac03.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(fac(7))) 6}
7
8 fac(n: int): int {
9 return fac'(n, 1)
10 }
11
12 fac'(n: int, accum: int): int {
13 if (n <= 1) { return accum }
14 return fac'(n-1, n*accum)
15 }
Compiler's standard output:
ASM generated
Generated result:
./fac03.s.nml
Expected result:
./fac03.ssol.nml
1 5040
1/1

xic-ref (-target linux -O [combo test]): fib01.xi
xic-ref (-target linux -O [combo test]): fib01.xi
Failed to execute: fib01 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/fib01.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(fib(7))) 6}
7
8 fib(n: int): int {
9 if (n <= 0) { return 0 }
10 if (n == 1) { return 1 }
11 return fib(n-1) + fib(n-2)
12 }
Compiler's standard output:
ASM generated
Generated result:
./fib01.s.nml
Expected result:
./fib01.ssol.nml
1 13
1/1

xic-ref (-target linux -O [combo test]): fib02.xi
xic-ref (-target linux -O [combo test]): fib02.xi
Mismatch detected at line 1 of file fib02.s.nml
expected: 13
found   : 8
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/combo/fib02.xi
1 use io
2 use conv
3
4 main(args: int[][]) {
5 println(unparseInt(fib(7))) 6}
7
8 fib(n: int): int {
 9
10
11
12
13
14
15
16
17
i: int = 2
r: int = 1
r1: int = 0
if (n <= 0) { return r1 }
while (i <= n) {
newr: int = r + r1 r1 = r
r = newr
i=i+ 1
18 }
19 return r 20 }
Compiler's standard output:
ASM generated
Generated result:
./fib02.s.nml
18
Expected result:
./fib02.ssol.nml
1 13
1/1

xic-ref (-target linux [global test]): arr2.xi
xic-ref (-target linux [global test]): arr2.xi
Failed to execute: arr2 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/global/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/global/arr2.xi
1 use io
2 use conv
3
4 x : int[]
5
6 f(a : int[]) : int {
7 a[0] = 5
8 return length(a)
9}
10
11 main(args:int[][]) {
12 x = {0,0,0}
13 println(unparseInt(x[0])) // 0
14 len : int = f(x)
15 println(unparseInt(x[0])) // 5
16 }
Compiler's standard output:
ASM generated
Generated result:
./arr2.s.nml
Expected result:
./arr2.ssol.nml
10 25
1/1

xic-ref (-target linux [global test]): array.xi
xic-ref (-target linux [global test]): array.xi
Failed to execute: array exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/global/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/global/array.xi
1 use io
2 use conv
3
4 b : int[]
5
6 f(a : int[]) { 7 a[2] = 5 8}
9
10 main(args : int[][]) {
11 b = {0,0,0}
12 f(b)
13 println(unparseInt(b[2])) // this is 5 14 }
Compiler's standard output:
ASM generated
Generated result:
./array.s.nml
Expected result:
./array.ssol.nml
15
1/1

xic-ref (-target linux [global test]): concat.xi
xic-ref (-target linux [global test]): concat.xi
Failed to execute: concat exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/global/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/global/concat.xi
1 use io
2 use conv
3
4 f(a : int[], n : int) : int[] {
5 if (n == 0) { return "" }
6 return a + f(a,n-1)
7}
8 x : int = 2
9 main(args:int[][]) {
10 println(f("hello", x)) 11 }
Compiler's standard output:
ASM generated
Generated result:
./concat.s.nml
Expected result:
./concat.ssol.nml
1 hellohello
1/1

xic-ref (-target linux [global test]): multifunc.xi
xic-ref (-target linux [global test]): multifunc.xi
Executable time limit of 30 SECONDS exceeded
Stream closed
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/global/../../lib -target linux
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/global/multifunc.xi
1 use io
2 use conv
3
4 f1(x:int) : int { 5 println("f1") 6 return x*2 7}
8
9 g1(x:int) : int {
10 return x-5
11 }
12
13 f2(x:int, y:int) : int, int { 14 return x+y, x*y
15 }
16
17 f3(x:int, y:int, z:int) : int, int, int {
18 return g1(x), g1(y), f1(z)
19 }
20
21 f4(x:int, y:int, z:int, w:int) : int, int, int, int {
22 return g1(x), g1(y), f1(z), f1(w)
23 }
24
25 f5(x:int, y:int, z:int, w:int, u:int) : int, int, int, int, int {
26 return g1(x), g1(y), f1(z), f1(w), g1(u)
27 }
28
29 f6(x:int, y:int, z:int, w:int, u:int, v:int) : int, int, int, int, int, int {
30 return g1(x), g1(y), f1(z), f1(w), g1(u), f1(v)
31 }
32
33 f7(x:int, y:int, z:int, w:int, u:int, v:int, o:int) : int, int, int, int, int, int, int { 34 return g1(x), g1(y), f1(z), f1(w), g1(u), f1(v), g1(o)
35 }
36
37 f8(x:int, y:int, z:int, w:int, u:int, v:int, o:int, i:int) : int, int, int, int, int, int, int, int {
38 return g1(x), g1(y), f1(z), f1(w), g1(u), f1(v), g1(o), f1(i)
39 }
40
41 f9(x:int, y:int, z:int, w:int, u:int, v:int, o:int, i:int, a:int) : int, int, int, int, int, int, int, int, int {
42 return g1(x), g1(y), f1(z), f1(w), g1(u), f1(v), g1(o), f1(i), f1(a)
43 }
44
45 f10(x:int, y:int, z:int, w:int, u:int, v:int, o:int, i:int, a:int, b:int) : int, int, int, int, int, int, int, int, int, int {
46 return g1(x), g1(y), f1(z), f1(w), g1(u), f1(v), g1(o), f1(i), f1(a), g1(b)
47 }
1/4

xic-ref (-target linux [global test]): multifunc.xi
48
49 f11(x:int, y:int, z:int, w:int, u:int, v:int, o:int, i:int, a:int, b:int, c:int) : int, int, int, int, int, int, int, int, int, int, int {
50 return g1(x), g1(y), f1(z), f1(w), g1(u), f1(v), g1(o), f1(i), f1(a), g1(b), g1(c)
51 }
52
53
54 main (args : int[][]) {
55 v1:int = f1(1)
56 v2:int, v3:int = f2(2, 3)
57 v4:int, v5:int, v6:int = f3(4, 5, 6)
58 v7:int, v8:int, v9:int, v10:int = f4(7,8,9,10)
59 v11:int, v12:int, v13:int, v14:int, v15:int = f5(11,12,13,14,15)
60 v16:int, v17:int, v18:int, v19:int, v20:int, v21:int = f6(16,17,18,19,20,21)
61 v22:int, v23:int, v24:int, v25:int, v26:int, v27:int, v28:int = f7(22,23,24,25,26,27,28)
62 v29:int, v30:int, v31:int, v32:int, v33:int, v34:int, v35:int, v36:int =
f8(29,30,31,32,33,34,35,36)
63 v37:int, v38:int, v39:int, v40:int, v41:int, v42:int, v43:int, v44:int, v45:int = f9(37,38,39,40,41,42,43,44,45)
64 v46:int, v47:int, v48:int, v49:int, v50:int, v51:int, v52:int, v53:int, v54:int, v55:int = f10(46,47,48,49,50,51,52,53,54,55)
65 v56:int, v57:int, v58:int, v59:int, v60:int, v61:int, v62:int, v63:int, v64:int, v65:int, v66:int = f11(56,57,58,59,60,61,62,63,64,65,66)
66
67
68
v20,
69
v38,
70
v56,
71
72 }
73
74
75
76
77 } 78 }
a:int[] = {
    v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19,
v21, v22, v23, v24, v25, v26, v27, v28, v29, v30, v31, v32, v33, v34, v35, v36, v37,
v39, v40, v41, v42, v43, v44, v45, v46, v47, v48, v49, v50, v51, v52, v53, v54, v55,
v57, v58, v59, v60, v61, v62, v63, v64, v65, v66
i:int = 0
while (i < length(a)) {
println(unparseInt(a[i])) i=i+ 1
Compiler's standard output:
ASM generated
Generated result:
./multifunc.s.nml
Expected result:
./multifunc.ssol.nml
1 f1 2 f1 3 f1 4 f1 5 f1 6 f1 7 f1 8 f1 9 f1
10 f1 11 f1 12 f1
2/4

xic-ref (-target linux [global test]): multifunc.xi
13 f1 14 f1 15 f1 16 f1 17 f1 18 f1 19 f1 20 f1 21 f1 22 f1 23 f1 24 f1 25 f1 26 f1 27 f1 28 f1 29 f1 30 f1 31 f1 32 2 33 5 34 6 35 -1 36 0 37 12 38 2 39 3 40 18 41 20 42 6 43 7 44 26 45 28 46 10 47 11 48 12 49 36 50 38 51 15 52 42 53 17 54 18 55 48 56 50 57 21 58 54 59 23 60 24 61 25 62 62 63 64 64 28 65 68 66 30 67 72 68 32 69 33 70 78 71 80 72 36
3/4

xic-ref (-target linux [global test]): multifunc.xi
73 84 74 38 75 88 76 90 77 41 78 42 79 96 80 98 81 45 82 102 83 47 84 106 85 108 86 50 87 51 88 52 89 116 90 118 91 55 92 122 93 57 94 126 95 128 96 60 97 61
4/4

xic-ref (-target linux -O [global test]): arr2.xi
xic-ref (-target linux -O [global test]): arr2.xi
Failed to execute: arr2 exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/global/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/global/arr2.xi
1 use io
2 use conv
3
4 x : int[]
5
6 f(a : int[]) : int {
7 a[0] = 5
8 return length(a)
9}
10
11 main(args:int[][]) {
12 x = {0,0,0}
13 println(unparseInt(x[0])) // 0
14 len : int = f(x)
15 println(unparseInt(x[0])) // 5
16 }
Compiler's standard output:
ASM generated
Generated result:
./arr2.s.nml
Expected result:
./arr2.ssol.nml
10 25
1/1

xic-ref (-target linux -O [global test]): array.xi
xic-ref (-target linux -O [global test]): array.xi
Failed to execute: array exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/global/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/global/array.xi
1 use io
2 use conv
3
4 b : int[]
5
6 f(a : int[]) { 7 a[2] = 5 8}
9
10 main(args : int[][]) {
11 b = {0,0,0}
12 f(b)
13 println(unparseInt(b[2])) // this is 5 14 }
Compiler's standard output:
ASM generated
Generated result:
./array.s.nml
Expected result:
./array.ssol.nml
15
1/1

xic-ref (-target linux -O [global test]): concat.xi
xic-ref (-target linux -O [global test]): concat.xi
Failed to execute: concat exit code 139
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/global/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/global/concat.xi
1 use io
2 use conv
3
4 f(a : int[], n : int) : int[] {
5 if (n == 0) { return "" }
6 return a + f(a,n-1)
7}
8 x : int = 2
9 main(args:int[][]) {
10 println(f("hello", x)) 11 }
Compiler's standard output:
ASM generated
Generated result:
./concat.s.nml
Expected result:
./concat.ssol.nml
1 hellohello
1/1

xic-ref (-target linux -O [global test]): multifunc.xi
xic-ref (-target linux -O [global test]): multifunc.xi
Executable time limit of 30 SECONDS exceeded
Stream closed
Command line without filenames:
xic -libpath /home/charles/ta-
compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/global/../../lib -target linux -O
Content of test case:
/home/charles/ta-compilers/pa/pa5/grading/tests/../../../pa4/grading/tests/global/multifunc.xi
1 use io
2 use conv
3
4 f1(x:int) : int { 5 println("f1") 6 return x*2 7}
8
9 g1(x:int) : int {
10 return x-5
11 }
12
13 f2(x:int, y:int) : int, int { 14 return x+y, x*y
15 }
16
17 f3(x:int, y:int, z:int) : int, int, int {
18 return g1(x), g1(y), f1(z)
19 }
20
21 f4(x:int, y:int, z:int, w:int) : int, int, int, int {
22 return g1(x), g1(y), f1(z), f1(w)
23 }
24
25 f5(x:int, y:int, z:int, w:int, u:int) : int, int, int, int, int {
26 return g1(x), g1(y), f1(z), f1(w), g1(u)
27 }
28
29 f6(x:int, y:int, z:int, w:int, u:int, v:int) : int, int, int, int, int, int {
30 return g1(x), g1(y), f1(z), f1(w), g1(u), f1(v)
31 }
32
33 f7(x:int, y:int, z:int, w:int, u:int, v:int, o:int) : int, int, int, int, int, int, int { 34 return g1(x), g1(y), f1(z), f1(w), g1(u), f1(v), g1(o)
35 }
36
37 f8(x:int, y:int, z:int, w:int, u:int, v:int, o:int, i:int) : int, int, int, int, int, int, int, int {
38 return g1(x), g1(y), f1(z), f1(w), g1(u), f1(v), g1(o), f1(i)
39 }
40
41 f9(x:int, y:int, z:int, w:int, u:int, v:int, o:int, i:int, a:int) : int, int, int, int, int, int, int, int, int {
42 return g1(x), g1(y), f1(z), f1(w), g1(u), f1(v), g1(o), f1(i), f1(a)
43 }
44
45 f10(x:int, y:int, z:int, w:int, u:int, v:int, o:int, i:int, a:int, b:int) : int, int, int, int, int, int, int, int, int, int {
46 return g1(x), g1(y), f1(z), f1(w), g1(u), f1(v), g1(o), f1(i), f1(a), g1(b)
47 }
1/4

xic-ref (-target linux -O [global test]): multifunc.xi
48
49 f11(x:int, y:int, z:int, w:int, u:int, v:int, o:int, i:int, a:int, b:int, c:int) : int, int, int, int, int, int, int, int, int, int, int {
50 return g1(x), g1(y), f1(z), f1(w), g1(u), f1(v), g1(o), f1(i), f1(a), g1(b), g1(c)
51 }
52
53
54 main (args : int[][]) {
55 v1:int = f1(1)
56 v2:int, v3:int = f2(2, 3)
57 v4:int, v5:int, v6:int = f3(4, 5, 6)
58 v7:int, v8:int, v9:int, v10:int = f4(7,8,9,10)
59 v11:int, v12:int, v13:int, v14:int, v15:int = f5(11,12,13,14,15)
60 v16:int, v17:int, v18:int, v19:int, v20:int, v21:int = f6(16,17,18,19,20,21)
61 v22:int, v23:int, v24:int, v25:int, v26:int, v27:int, v28:int = f7(22,23,24,25,26,27,28)
62 v29:int, v30:int, v31:int, v32:int, v33:int, v34:int, v35:int, v36:int =
f8(29,30,31,32,33,34,35,36)
63 v37:int, v38:int, v39:int, v40:int, v41:int, v42:int, v43:int, v44:int, v45:int = f9(37,38,39,40,41,42,43,44,45)
64 v46:int, v47:int, v48:int, v49:int, v50:int, v51:int, v52:int, v53:int, v54:int, v55:int = f10(46,47,48,49,50,51,52,53,54,55)
65 v56:int, v57:int, v58:int, v59:int, v60:int, v61:int, v62:int, v63:int, v64:int, v65:int, v66:int = f11(56,57,58,59,60,61,62,63,64,65,66)
66
67
68
v20,
69
v38,
70
v56,
71
72 }
73
74
75
76
77 } 78 }
a:int[] = {
    v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19,
v21, v22, v23, v24, v25, v26, v27, v28, v29, v30, v31, v32, v33, v34, v35, v36, v37,
v39, v40, v41, v42, v43, v44, v45, v46, v47, v48, v49, v50, v51, v52, v53, v54, v55,
v57, v58, v59, v60, v61, v62, v63, v64, v65, v66
i:int = 0
while (i < length(a)) {
println(unparseInt(a[i])) i=i+ 1
Compiler's standard output:
ASM generated
Generated result:
./multifunc.s.nml
Expected result:
./multifunc.ssol.nml
1 f1 2 f1 3 f1 4 f1 5 f1 6 f1 7 f1 8 f1 9 f1
10 f1 11 f1 12 f1
2/4

xic-ref (-target linux -O [global test]): multifunc.xi
13 f1 14 f1 15 f1 16 f1 17 f1 18 f1 19 f1 20 f1 21 f1 22 f1 23 f1 24 f1 25 f1 26 f1 27 f1 28 f1 29 f1 30 f1 31 f1 32 2 33 5 34 6 35 -1 36 0 37 12 38 2 39 3 40 18 41 20 42 6 43 7 44 26 45 28 46 10 47 11 48 12 49 36 50 38 51 15 52 42 53 17 54 18 55 48 56 50 57 21 58 54 59 23 60 24 61 25 62 62 63 64 64 28 65 68 66 30 67 72 68 32 69 33 70 78 71 80 72 36
3/4

xic-ref (-target linux -O [global test]): multifunc.xi
73 84 74 38 75 88 76 90 77 41 78 42 79 96 80 98 81 45 82 102 83 47 84 106 85 108 86 50 87 51 88 52 89 116 90 118 91 55 92 122 93 57 94 126 95 128 96 60 97 61
4/4
