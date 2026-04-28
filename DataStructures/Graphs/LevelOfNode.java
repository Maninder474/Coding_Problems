package DataStructures.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOfNode {
    public void findLevelOfNode(int count,Graph graphObject){
        int V = graphObject.getVertex();
        LinkedList<Integer>[] graph = graphObject.getGraph();
        Queue<Integer> q = new LinkedList<Integer>();
        boolean visited[] = new boolean[V];
        int level[] = new int[V];
        q.add(0);
        level[0]=0;
        while(!q.isEmpty()){
            int n = q.peek();
            q.poll();

            if(n!=-1){
                System.out.println(n+" -> "+level[n]);
                for (int s : graph[n]) {
                    if (!visited[s]) {
                        q.add(s);
                        visited[s] = true;
                        level[s] = level[n] + 1;
                    }
                }
            }
        }
    }
}
