package jw795.typechecker;

import java.util.HashMap;

public class Record extends Tau {
    public String name;
    public HashMap<String, Tau> fields;

    public Record(String n, HashMap<String, Tau> f){
        name = n;
        fields = f;
    }

    public String toStr(){
        return "t";
    }
}
