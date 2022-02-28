package jw795.typechecker;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Representation of a symbol table that acts as the gamma-context.
 */
public class SymbolTable {

    // the context is implemented as a stack of hashmaps
    // end of linked-list = top of stack
    LinkedList<HashMap<String, XiType>> gamma;

    public SymbolTable() {
        gamma = new LinkedList<>();
    }

    /**
     * Enter a new level of scope.
     */
    public void enterScope() {
        // push a new empty hashmap onto the stack
        gamma.addLast(new HashMap<>());

    }

    /**
     * Leave the scope when scope ends.
     */
    public void leaveScope() {
        // pop the hashmap off top of stack
        gamma.removeLast();
    }

    /**
     * Find the type of id in the context.
     * @param id identifier for the variable to find type for
     * @return the type of id, null if id is not found
     */
    public XiType findType(String id) {
        for (HashMap<String, XiType> context : gamma) {
            if (context.containsKey(id)) {
                return context.get(id);
            }
        }
        return null;
    }

    /**
     * If the context contains a mapping for id.
     * @param id identifier for the variable to check for
     * @return true if context contains id, false otherwise
     */
    public boolean contains(String id) {
        for (HashMap<String, XiType> context : gamma) {
            if (context.containsKey(id)) {
                return true;
            }
        }
        return false;
    }

    //add an variable with name and argumenttype in the current scope
    public void add(String name,  XiType t){
        HashMap<String, XiType> lastone = this.gamma.get(this.gamma.size()-1);
        lastone.put(name,t);
    }


}
