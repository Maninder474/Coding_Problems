package DataStructures.Graphs;

public class Floydwarshall {
    public void floydwarshall() {

        int INF = Integer.MAX_VALUE;
        int[][] dist = {{0, 4, INF, 5, INF},
                {INF, 0, 1, INF, 6},
                {2, INF, 0, 3, INF },
                {INF, INF, 1, 0, 2},
                {1, INF, INF, 4, 0}};
        int V = dist.length;
        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for(int j = 0;j<V;j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = Math.min(dist[i][k] + dist[k][j],dist[i][j]);
                    }
                }
    }
}
