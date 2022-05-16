package jw795.typechecker;

import jw795.ast.*;

import java.util.*;

/**
 * Representation of a symbol table that acts as the gamma-context.
 */
public class SymbolTable {

    // the context is implemented as a stack of hashmaps
    // end of linked-list = top of stack
    LinkedList<HashMap<String, Sigma>> variables;
    LinkedList<HashMap<String, Sigma>> functions;
    HashMap<String, Record> records;
    int insideloop;

    public SymbolTable() {
        variables = new LinkedList<>();
        variables.add(new HashMap<>());
        functions = new LinkedList<>();
        records = new HashMap<>();
        insideloop = 0;

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
     * Get all the variables in the symbol table.
     * @return a map of variable ids to their types.
     */
    public HashMap<String, Sigma> getVariables() {
        HashMap<String, Sigma> result = new HashMap<>();
        for (HashMap<String, Sigma> map : variables) {
            result.putAll(map);
        }
        return result;
    }

    /**
     * Get all the functions in the symbol table.
     * @return a map of function ids to their types
     */
    public HashMap<String, Sigma> getFunctions() {
        HashMap<String, Sigma> result = new HashMap<>();
        for (HashMap<String, Sigma> map : functions) {
            result.putAll(map);
        }
        return result;
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
     * Add name and field with type Record to the symbol table
     * Since Record declare appear in both interface and program,
     * latter record would replace previous record
     * @param name id
     * @param fields map of field name with type
     */
    public void addRecord(String name, LinkedHashMap<String, Type> fields){
        LinkedHashMap<String, Tau> fty =new LinkedHashMap<>();
        fields.forEach(
            (k,v) -> {

            if (v instanceof IntType) {
                fty.put(k, new Int());
            } else if (v instanceof BoolType) {
                fty.put(k, new Bool());
            } else if (v instanceof RecordType) {
                Record thetype = this.findTypeofRecord(((RecordType) v).name);
                if (thetype != null) {
                    fty.put(k, thetype);
                } else {
                    fty.put(k, new Record(((RecordType) v).name, new LinkedHashMap<>()));
                }
            } else {
                System.out.println("got an unhandled case");
            }
        }

        );
        Record stype = new Record(name, fty );

        records.put(name, stype);


    }

    /**
     * Since there is problem of recursive definition,
     * this function get first level record type by the provided type name
     * return null when there is no such record type
     * @param id the name of type of record
     * @return type record
     */
    public Record findTypeofRecord(String id){
        if (records.containsKey(id)) {
            return records.get(id);
        }

        return null;
    }

    /**
     * If the context contains a record type name id.
     * @param id identifier for the Record to check for
     * @return true if context contains id, false otherwise
     */
    public boolean containsRecord(String id) {
        if (records.containsKey(id)) {
            return true;
        }
        return false;
    }

    public void getinloop(){
        insideloop +=1;
    }

    public void getoutloop(){
        insideloop -=1;
    }

    public int getloopnum(){
        return insideloop;
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
