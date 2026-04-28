package DataStructures.Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class IsCyclicGraph {
    public boolean isCyclic(boolean directed ,Graph graph) {
        int v = graph.getVertex();
        boolean visited[] = new boolean[v];
        if(directed){
            boolean rec[] = new boolean[v];
            for(int i =0;i<v;i++)
                if(isCyclicDirectedUtil(graph.getGraph(),i,visited,rec))
                    return true;
            return false;
        }else{
            for(int i = 0;i<v;i++)
                if(!visited[i] && isCyclicUnDirectedUtil(graph.getGraph(),i,visited,-1))
                    return true;
            return false;
        }
    }
    public boolean isCyclicDirectedUtil(LinkedList<Integer> adj[], int i, boolean visited[], boolean rec[]){

        if(rec[i])
            return true;
        if(visited[i])
            return false;

        Iterator<Integer> it = adj[i].listIterator();
        visited[i]=true;
        rec[i]=true;
        while(it.hasNext()){
            int n = it.next();
            if(isCyclicDirectedUtil(adj,n,visited,rec))
                return true;
        }
        rec[i]=false;
        return false;
    }

    public boolean isCyclicUnDirectedUtil(LinkedList<Integer>[] adj,int i,boolean visited[],int parent){
        visited[i]=true;

        Iterator<Integer> it = adj[i].listIterator();
        while(it.hasNext()){
            int n = it.next();
            if(!visited[n]){
                if(isCyclicUnDirectedUtil(adj,n,visited,i))
                    return true;
            } else if(n!=parent)
                return true;
        }
        return false;
    }
}
