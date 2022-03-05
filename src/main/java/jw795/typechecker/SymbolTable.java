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
    LinkedList<HashMap<String, Sigma>> variables;
    LinkedList<HashMap<String, Sigma>> functions;

    public SymbolTable() {
        variables = new LinkedList<>();
        variables.add(new HashMap<>());
        functions = new LinkedList<>();

        // add io support
        HashMap<String, Sigma> initialMap = new HashMap<>();
        initialMap.put("print", new Fn(new TypedArray(new Int()), new Unit()));
        initialMap.put("println", new Fn(new TypedArray(new Int()), new Unit()));
        initialMap.put("readln", new Fn(new Unit(), new TypedArray(new Int())));
        initialMap.put("getchar", new Fn(new Unit(), new Int()));
        initialMap.put("eof", new Fn(new Unit(), new Bool()));

        functions.add(initialMap);
    }

    /**
     * Enter a new level of scope.
     */
    public void enterScope() {
        // push a new empty hashmap onto the stack
        variables.addLast(new HashMap<>());

    }

    /**
     * Leave the scope when scope ends.
     */
    public void leaveScope() {
        // pop the hashmap off top of stack
        variables.removeLast();
    }

    /**
     * Find the type of id in the context.
     * @param id identifier for the variable to find type for
     * @return the type of id, null if id is not found
     */
    public Sigma findTypeofVar(String id) {
        for (int i = variables.size() - 1; i >= 0; i--) {
            HashMap<String, Sigma> context = variables.get(i);
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
    public boolean containsVar(String id) {
        for (int i = variables.size() - 1; i >= 0; i--) {
            HashMap<String, Sigma> context = variables.get(i);
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
    public void addVar(String name, Sigma t){
        HashMap<String, Sigma> lastOne = this.variables.getLast();
        lastOne.put(name, t);
    }

    /**
     * Return the domain of the symbol table as a set of identifiers.
     * @return a set of string representing the domain of the context
     */
    public Set<String> domVar() {
        Set<String> domain = new HashSet<>();
        for (HashMap<String, Sigma> context : variables) {
            domain.addAll(context.keySet());
        }
        return domain;
    }

    /**
     * Find the type of id in the context.
     * @param id identifier for the variable to find type for
     * @return the type of id, null if id is not found
     */
    public Sigma findTypeofFun(String id) {
        for (int i = functions.size() - 1; i >= 0; i--) {
            HashMap<String, Sigma> context = functions.get(i);
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
    public boolean containsFun(String id) {
        for (int i = functions.size() - 1; i >= 0; i--) {
            HashMap<String, Sigma> context = functions.get(i);
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
    public void addFun(String name, Sigma t){
        HashMap<String, Sigma> lastOne = this.functions.getLast();
        lastOne.put(name, t);
    }

    /**
     * Return the domain of the symbol table as a set of identifiers.
     * @return a set of string representing the domain of the context
     */
    public Set<String> domFun() {
        Set<String> domain = new HashSet<>();
        for (HashMap<String, Sigma> context : functions) {
            domain.addAll(context.keySet());
        }
        return domain;
    }
}
