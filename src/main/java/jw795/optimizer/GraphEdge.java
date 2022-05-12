package jw795.optimizer;

public class GraphEdge {
    private GraphNode start;
    private GraphNode dest;

    public GraphEdge (GraphNode start, GraphNode dest) {
        this.start = start;
        this.dest = dest;
    }

    public void setStart(GraphNode start) {
        this.start = start;
    }

    public GraphNode getStart() {
        return start;
    }

    public void setDest(GraphNode dest) {
        this.dest = dest;
    }

    public GraphNode getDest() {
        return dest;
    }
}
