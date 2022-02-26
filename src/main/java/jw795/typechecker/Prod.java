package jw795.typechecker;

import java.util.List;

public class Prod implements T{
    List<Tau> elementTypes;

    public Prod(List<Tau> elementTypes) {
        this.elementTypes = elementTypes;
    }
}
