foo(){
    x:int = length({1})
    y:int = length({true})
    z:int = length("h")
    a:int = length({{1},{2},{3}});
    a = length({{"h"}, {{1}}, {"a"}});
    a = length({true, true, true, false})
    a = length({})
    a = length({{{{}}}})
    arr:int[3]
    arr[0] = length({{},{},{}})
    arr[1] = length({{{true},{true}}})
    arr[2] = length({"h"})
}