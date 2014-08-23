import java.util.List;

/**
 * Created by Sashika on 8/21/2014.
 */
public class NMSimilarity {
    private double[][] nodeSimilarity;
    private double[][] tempNodeSimilarity;
    private Graph graphA;
    private Graph graphB;
    private int graphA_n;
    private int graphB_n;
    private double epsilon;
    private long[] solution;
    private long[] costs;
    private int firstTime;

    public int iteration(double epsilon) {
        int precision_achieved = 1;

        for (int i = 0; i < graphA_n; i++) {
            for (int j = 0; j < graphB_n; j++) {
                tempNodeSimilarity[i][j] = nodeSimilarity[i][j];
            }
        }

        for (int i = 0; i < graphA_n; i++) {
            for (int j = 0; j < graphB_n; j++) {
                if (graphA.getLabel(i).equals(graphB.getLabel(j))) {
                    List<Integer> connectedNodesA;
                    List<Integer> connectedNodesB;
                    int numberOfOutEdgesA;
                    int numberOfOutEdgesB;
                    double inSimilarity = 0;
                    double outSimilarity = 0;

                    connectedNodesA = graphA.getNodes(i);
                    connectedNodesB = graphB.getNodes(j);

                    numberOfOutEdgesA = graphA.getOutEdgesCount(i);
                    numberOfOutEdgesB = graphB.getOutEdgesCount(j);

                    if (numberOfOutEdgesA > 0 && numberOfOutEdgesB > 0) {
                        costs = new long[numberOfOutEdgesA * numberOfOutEdgesB];
                        solution = new long[numberOfOutEdgesA];

                        for (int k=0; k<numberOfOutEdgesA ; k++){
                            for (int l=0; l<numberOfOutEdgesB ; l++){
                                costs[k * numberOfOutEdgesB +l] = (long) ((1- tempNodeSimilarity[graphA.getTerminateNode(connectedNodesA.get(k))][graphB.getTerminateNode(connectedNodesB.get(l))])/epsilon);
                            }
                        }
                    }
                }
            }
        }

        return precision_achieved;
    }

}
