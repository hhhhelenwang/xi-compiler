package jw795.optimizer;

import jw795.assembly.AAOperand;

public class GraphEdge {
    private AAOperand start;
    private AAOperand dest;

    public GraphEdge (AAOperand start, AAOperand dest) {
        this.start = start;
        this.dest = dest;
    }

    public void setStart(AAOperand start) {
        this.start = start;
    }

    public AAOperand getStart() {
        return start;
    }

    public void setDest(AAOperand dest) {
        this.dest = dest;
    }

    public AAOperand getDest() {
        return dest;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GraphEdge) {
            return this.start.equals(((GraphEdge) obj).getStart()) && this.dest.equals(((GraphEdge) obj).getDest());
        } else {
            return false;
        }
    }
}
