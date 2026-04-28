package DataStructures.Graphs;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {


    public void topologicalSort(Graph graphObject){
        int V = graphObject.getVertex();
        Stack<Integer> st = new Stack<Integer>();
        boolean[] visited = new boolean[V];
        for(int i = 0;i<V;i++)
            if(!visited[i])
                sort(i,st,visited, graphObject.getGraph());
        while(!st.isEmpty())
            System.out.println(st.pop()+" ");
    }

     public void sort(int i,Stack<Integer> st,boolean visited[], LinkedList<Integer>[] graph){

        visited[i] = true;
        for (int s : graph[i]) {
            if (!visited[s])
                sort(s, st, visited,graph);
        }
        st.push(i);
    }
}
