package DataStructures.Graphs;

import java.util.LinkedList;

public class ConnectedNodes {
    public int connectedNodes(Graph graphs,int s ,int d, int count){
        LinkedList<Integer>[] graph = graphs.getGraph();
        if(s==d)
            count++;
        else{
            for (Integer integer : graph[s]) {
                count = connectedNodes(graphs,integer, d, count);
            }
        }
        return count;
    }
}
