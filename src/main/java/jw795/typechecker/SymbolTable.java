package jw795.typechecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Representation of a symbol table that acts as the gamma-context.
 */
public class SymbolTable {

    // the context is implemented as a stack of hashmaps
    // end of linked-list = top of stack
    LinkedList<HashMap<String, Sigma>> gamma;

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
    public Sigma findType(String id) {
        for (HashMap<String, Sigma> context : gamma) {
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
        for (HashMap<String, Sigma> context : gamma) {
            if (context.containsKey(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add identifier name and its type t to the symbol table.
     * @param name identifier of the variable
     * @param t type of the variable
     */
    public void add(String name,  Sigma t){
        HashMap<String, Sigma> lastOne = this.gamma.getLast();
        lastOne.put(name, t);
    }

    /**
     * Return the domain of the symbol table as a set of identifiers.
     * @return a set of string representing the domain of the context
     */
    public Set<String> dom() {
        Set<String> domain = new HashSet<>();
        for (HashMap<String, Sigma> context : gamma) {
            domain.addAll(context.keySet());
        }
        return domain;
    }


}
