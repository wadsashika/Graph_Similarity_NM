import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Sashika on 8/15/2014.
 */
public class Graph {
    private Map<Integer, String> labels;
    private List<Integer> outEdgesCount;
    private List<Edge> edges;
    private List<List<Integer>> nodes;

    public Graph(Integer[][] graphMatrix, Map<Integer, String> labelList) {
        try {
            labels = labelList;
            outEdgesCount = new ArrayList<Integer>();
            edges = new ArrayList<Edge>();
            nodes = new ArrayList<List<Integer>>();

            reload(graphMatrix);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reload(Integer[][] graphMatrix) throws Exception {
        loadGraph(graphMatrix);
    }

    public void loadGraph(Integer[][] graphMatrix) throws Exception {
        int numOfNodes = graphMatrix.length;
        for (int i = 0; i < numOfNodes; i++) {
            nodes.add(new ArrayList<Integer>());
            outEdgesCount.add(0);
        }

        for (int i = 0; i < numOfNodes; i++) {
            for (int j = 0; j < numOfNodes; j++) {
                if (graphMatrix[i][j] != 0) {
                    addEdge(i, j);
                }
            }
        }
    }

    public void addEdge(int n1, int n2) {
        edges.add(new Edge(n1, n2));

        nodes.get(n1).add(n2);
        nodes.get(n2).add(n1);

        int outEdgesCountTemp = outEdgesCount.get(n1);
        outEdgesCount.add(n1, outEdgesCountTemp++);
    }

    public int getNodeCount() {
        return nodes.size();
    }

    public int getEdgeCount() {
        return edges.size();
    }

    public int getSourceOfEdge(int edgeNum) {
        return edges.get(edgeNum).getSourceNode();
    }

    public int getTerminateOfEdge(int edgeNum) {
        return edges.get(edgeNum).getTerminatingNode();
    }

    public String getLabel(int i) {
        return labels.get(i);
    }

    public Map<Integer, String> getLabels() {
        return labels;
    }

    public List<Integer> getOutEdgesCount() {
        return outEdgesCount;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public List<List<Integer>> getNodes() {
        return nodes;
    }
}
