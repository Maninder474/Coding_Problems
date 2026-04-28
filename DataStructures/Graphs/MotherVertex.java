package DataStructures.Graphs;

public class MotherVertex {
    public int motherVertex(Graph graph){

        int v = graph.getVertex();
        boolean visited[] = new boolean[v];
        int motherVertex =-1;
        for (int i = 0; i < v; i++)
            if(!visited[i]){
                GraphUtils.DFSItr(i, visited,graph);
                motherVertex=i;
            }
        visited=new boolean[v];
        GraphUtils.DFSItr(motherVertex, visited,graph);
        for (int i = 0; i < visited.length; i++)
            if(!visited[i])
                return -1;
        return motherVertex;
    }
}
