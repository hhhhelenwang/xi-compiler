package jw795.cfg;

import java_cup.runtime.Symbol;
import jw795.util.FileUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public abstract class CFG<T> {
    private CFGNode<T> start;

    public CFG(CFGNode<T> start){
        this.start = start;
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
     * Helper that uses dfs to get all CFG nodes
     * @param cur current CFGNode
     * @param visited visited CFGNode
     * @return list of IRStmt
     */
     List<CFGNode<T>> getAllSuccessors(CFGNode<T> cur, HashSet<CFGNode<T>> visited){
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
     * Helper to connect two CFGNodes. Specifically, make next to cur's successor, and cur to next's predecessor
     * @param cur
     * @param next
     */
    void connect(CFGNode<T> cur, CFGNode<T> next){
        next.addPredecessor(cur);
        cur.addSuccessor(next);
    }

    /**
     * Convert CFG to dot format and save it to a file
     * @param fileName
     * @param path
     * @param graphID
     */
    public void toDotFormat(String fileName, String path, String graphID){
          //generate the target .lexed file
          File targetDotFile = FileUtil.generateTargetFile(fileName, path, ".txt");

          try{
              FileWriter writer = new FileWriter(targetDotFile, Charset.forName("UTF-8"));
              List<CFGNode<T>> nodes = flatten();
              writer.write("digraph "+ graphID + " {");
              for (CFGNode<T> node : nodes){
                  String curNodeName = node.toString().replaceAll(" ", "_");
                  writer.write(curNodeName + ";");
                  for (CFGNode<T> successor : node.getSuccessors()){
                      String successorName = successor.toString().replaceAll(" ", "_");
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

}
