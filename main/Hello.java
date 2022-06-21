package main;

import DataStructures.Graphs.Graph;

/**
 * Hello
 */
public class Hello {

    public static void main(String[] args) {
        Graph g = new Graph(4);
        // graph.addEdge(0, 1);
        // graph.addEdge(0, 2);
        // graph.addEdge(1, 3);
        // graph.addEdge(4, 1);
        // graph.addEdge(6, 4);
        // graph.addEdge(5, 6);
        // graph.addEdge(5, 2);
        // graph.addEdge(6, 0);

        // graph.addEdge(1, 0);
        // graph.addEdge(0, 2);
        // graph.addEdge(2, 1);
        // graph.addEdge(0, 3);
        // graph.addEdge(1, 4);
        // //graph.BFS(2);
        // long s,e;
        // s = System.nanoTime();
        // graph.DFS();
        // e = System.nanoTime();
        // System.out.println("time Escaped : "+(e-s));
        // s = System.nanoTime();
        // graph.DFSItr(0);
        // e = System.nanoTime();
        // System.out.println("time Escaped : "+(e-s));
        // System.out.println(  "Mother vertex : "+graph.motherVertex());

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 5);
        g.addEdge(2, 5);
        g.addEdge(2,6);
        g.addEdge(6, 7);

       int res = g.connectedNodes(0, 3, 0);

        System.out.println(res);
        g.topologicalSort();
       g.findLevelOfNode(0);
    }
}