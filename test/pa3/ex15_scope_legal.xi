use io

hello(){
}

str:int[]

fun():bool{
_ = fun()
return true;
}

pro() {
//first pass should add hello() and pro() into context
hello()
pro()

// io functions should be in context without .ixi file supplied
str = "hello world"
_ = getchar()
print(str)
println(str)
_ = readln()
_ = eof()

return
}

ifloop(){
x:int
b:bool
if(b){
    y:int = 0;
}
y:int = 1;
}

whileloop(){
b:bool
while(b){
    b = true
    str = {1,2,3}
    y:int = 0;
}
y:int = 1;
}

ifElse(){
b:bool
if(b){
    b = true
    str = {1,2,3}
    y:int = 0;
} else {
    b = false;
    str = {4,5,6}
}
y:int = 1;
}