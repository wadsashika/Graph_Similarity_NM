/**
 * Created by Sashika on 8/15/2014.
 */
public class Edge {
    private int sourceNode;
    private int terminatingNode;
    private int weight;

    public Edge(int sourceNode, int terminatingNode, int weight) {
        this.sourceNode = sourceNode;
        this.terminatingNode = terminatingNode;
        this.weight = weight;
    }

    public Edge(int sourceNode, int terminatingNode) {
        this.sourceNode = sourceNode;
        this.terminatingNode = terminatingNode;
    }

    public int getSourceNode() {
        return sourceNode;
    }

    public void setSourceNode(int sourceNode) {
        this.sourceNode = sourceNode;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTerminatingNode() {
        return terminatingNode;
    }

    public void setTerminatingNode(int terminatingNode) {
        this.terminatingNode = terminatingNode;
    }
}
