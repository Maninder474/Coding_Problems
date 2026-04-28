package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Dijkstra {
    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        boolean[] mst = new boolean[V];
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[S]=0;
        for(int i = 0;i<V;i++){
            int u = GraphUtils.minset(key,mst);
            mst[u]=true;
            for (ArrayList<Integer> al : adj.get(u)) {
                if (!mst[al.get(0)] && key[al.get(0)] > al.get(1) + key[u])
                    key[al.get(0)] = key[u] + al.get(1);
            }
        }
        return key;
    }
}
