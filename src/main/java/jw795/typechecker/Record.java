package jw795.typechecker;

import java.util.LinkedHashMap;

public class Record extends Tau {
    public String name;
    public LinkedHashMap<String, Tau> fields;

    public Record(String n, LinkedHashMap<String, Tau> f){
        name = n;
        fields = f;
    }

    public String toStr(){
        return "t";
    }
}
