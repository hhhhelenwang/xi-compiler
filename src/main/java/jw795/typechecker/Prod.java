package jw795.typechecker;

import java.util.List;

public class Prod implements T{
    public List<Tau> elementTypes;

    public Prod(List<Tau> elementTypes) {
        this.elementTypes = elementTypes;
    }

    @Override
    public String toStr() {
        String result = "";
        for (Tau type: elementTypes){
            result+= type.toStr() + " ";
        }
        return result;
    }

    @Override
    public boolean equals(T t) {
        if (t instanceof Prod && this.elementTypes.size() == ((Prod) t).elementTypes.size()) {
            for (int i = 0; i < this.elementTypes.size(); i++) {
                if (!this.elementTypes.get(i).equals(((Prod) t).elementTypes.get(i))) {
                    return false;
                }
            }
            return true;

        } else {
            return false;
        }
    }
}
