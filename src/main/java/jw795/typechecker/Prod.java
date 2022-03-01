package jw795.typechecker;

import java.util.List;

public class Prod implements T{
    public List<Tau> elementTypes;

    public Prod(List<Tau> elementTypes) {
        this.elementTypes = elementTypes;
    }

    @Override
    public String tostr() {
        String result = "";
        for (Tau type: elementTypes){
            result+= type.tostr() + " ";
        }
        return result;
    }
}
