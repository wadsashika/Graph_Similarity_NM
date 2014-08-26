import java.util.List;

/**
 * Created by Sashika on 8/26/2014.
 */
public class NMSimilarity {
    private Graph graphA;
    private Graph graphB;
    private List<List<Integer>> inNodeListA;
    private List<List<Integer>> outNodeListA;
    private List<List<Integer>> inNodeListB;
    private List<List<Integer>> outNodeListB;
    private Double[][] nodeSimilarity;
    private Double[][] inNodeSimilarity;
    private Double[][] outNodeSimilarity;
    private Double graphSimilarity;
    private Double epsilon;
    private int graphSizeA;
    private int graphSizeB;

    public NMSimilarity(Graph graphA, Graph graphB, Double epsilon) {
        try {
            this.graphA = graphA;
            this.graphB = graphB;
            this.epsilon = epsilon;
            this.inNodeListA = graphA.getInDegreeNodeList();
            this.outNodeListA = graphA.getOutDegreeNodeList();
            this.inNodeListB = graphB.getInDegreeNodeList();
            this.outNodeListB = graphB.getOutDegreeNodeList();

            this.graphSizeA = graphA.getGraphSize();
            this.graphSizeB = graphB.getGraphSize();

            this.nodeSimilarity = new Double[graphSizeA][graphSizeB];
            this.inNodeSimilarity = new Double[graphSizeA][graphSizeB];
            this.outNodeSimilarity = new Double[graphSizeA][graphSizeB];

            initializeSimilarityMatrices();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initializeSimilarityMatrices() {
        for (int i = 0; i < graphSizeA; i++) {
            for (int j = 0; j < graphSizeB; j++) {
                Double maxDegree = Double.valueOf(Math.max(inNodeListA.get(i).size(), inNodeListB.get(j).size()));
                if (maxDegree != 0) {
                    inNodeSimilarity[i][j] = ((Math.min(inNodeListA.get(i).size(), inNodeListB.get(j).size())) / (maxDegree));
                } else {
                    inNodeSimilarity[i][j] = Double.valueOf(0);
                }

                maxDegree = Double.valueOf(Math.max(outNodeListA.get(i).size(), outNodeListB.get(j).size()));
                if (maxDegree != 0) {
                    outNodeSimilarity[i][j] = ((Math.min(outNodeListA.get(i).size(), outNodeListB.get(j).size())) / (maxDegree));
                } else {
                    outNodeSimilarity[i][j] = Double.valueOf(0);
                }
            }
        }

        for (int i=0;i<graphSizeA;i++){
            for (int j=0;j<graphSizeB;j++){
                nodeSimilarity[i][j] = (inNodeSimilarity[i][j] + outNodeSimilarity[i][j])/2;
            }
        }

        for (int i = 0; i < graphSizeA; i++) {
            for (int j = 0; j < graphSizeB; j++) {
                System.out.print(nodeSimilarity[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
