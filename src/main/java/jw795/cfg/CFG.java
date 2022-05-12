package jw795.cfg;

import jw795.util.FileUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;


public abstract class CFG<T> {
    private CFGNode<T> start;
    private HashMap<T, CFGNode<T>> insToCFG;

    public CFG(CFGNode<T> start, HashMap<T, CFGNode<T>> insToCFG){
        this.start = start;
        this.insToCFG = insToCFG;
    }

    /**
     * Getter for start node of CFG
     * @return the start node of CFG
     */
    public CFGNode<T> start(){
        return start;
    }

    /**
     * Flatten a CFG to a list of CFGNode
     * @return list of IRStmt
     */
    public List<CFGNode<T>> flatten(){
        List<CFGNode<T>> res = getAllSuccessors(this.start, new HashSet<>());
        return res;
    }

    /**
     * Helper that uses dfs to get all successors of a CFG node
     * @param cur current CFGNode
     * @param visited visited CFGNode
     * @return list of IRStmt
     */
     public List<CFGNode<T>> getAllSuccessors(CFGNode<T> cur, HashSet<CFGNode<T>> visited){
        List<CFGNode<T>> res = new ArrayList<>();

        if (!visited.contains(cur)){
            res.add(cur);
            visited.add(cur);
            for (CFGNode<T> successor: cur.getSuccessors()){
                res.addAll(getAllSuccessors(successor, visited));
            }
        }

        return res;
    }

    /**
     * Helper that uses dfs to get all predecessors of a CFG node
     * @param cur current CFGNode
     * @param visited visited CFGNode
     * @return list of IRStmt
     */
    public List<CFGNode<T>> getAllPredecessors(CFGNode<T> cur, HashSet<CFGNode<T>> visited){
        List<CFGNode<T>> res = new ArrayList<>();

        if (!visited.contains(cur)){
            res.add(cur);
            visited.add(cur);
            for (CFGNode<T> predecessor: cur.getPredecessors()){
                res.addAll(getAllPredecessors(predecessor, visited));
            }
        }

        return res;
    }

    /**
     * Convert CFG to dot format and save it to a file
     * @param fileName
     * @param path
     * @param graphID
     */
    public void toDotFormat(String fileName, String path, String graphID, String phase){
          //generate the target .lexed file
          File targetDotFile = FileUtil.generateTargetFileWithFuncName(fileName, path,
                  "dot", Optional.of(graphID), Optional.of(phase));

          try{
              FileWriter writer = new FileWriter(targetDotFile, Charset.forName("UTF-8"));
              List<CFGNode<T>> nodes = flatten();
              writer.write("digraph "+ graphID + " {");
              //nodes
              for (CFGNode<T> node : nodes){
                  String nodeName = nodeName(node.getStmt().toString());
                  writer.write(nodeName);
              }

              // relations
              for (CFGNode<T> node : nodes){
                  String curNodeName = nodeName(node.getStmt().toString());
                  for (CFGNode<T> successor : node.getSuccessors()){
                      String successorName = nodeName(successor.getStmt().toString());
                      writer.write(curNodeName + " -> " + successorName + ";");
                  }
              }
              writer.write("}");
              writer.close();
          }
          catch (IOException ex){
              System.out.println("IO Error when writing lexed file: " + ex.getMessage());
          }
    }

    /**
     * Helper function to generate node name by simply removing (, ), and spaces
     * */
    private String nodeName(String stmt){
        String name = stmt.replaceAll(" ", "_");
        name = name.replaceAll("\\(","").replaceAll("\\)","");
        return name;
    }

}
