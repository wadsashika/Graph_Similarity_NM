import java.util.ArrayList;

/**
 * Created by Sashika on 8/26/2014.
 */
public class Main {

    public static void main(String[] args) {
        try {
            Integer[][] graphBSource = new Integer[][]{{0, 1, 0, 0, 0, 0},
                    {0, 0, 0, 1, 1, 0},
                    {0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 1, 0},
                    {0, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0,}};
            Integer[][] graphASource = new Integer[][]{{0, 1, 0},
                    {0, 0, 1},
                    {0, 0, 0}};
            Graph graphA = new Graph(graphASource);
            Graph graphB = new Graph(graphBSource);

            NMSimilarity similarityMeasure = new NMSimilarity(graphA,graphB,0.0001);
            similarityMeasure.measureSimilarity();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
