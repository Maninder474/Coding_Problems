package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private int V;
    private LinkedList<Integer> graph[];
    public Graph(int v){
        this.V = v;
        graph = new LinkedList[v];
        for (int i=0; i<v; ++i)
            graph[i] = new LinkedList<Integer>();
    }

    public int getVertex(){
        return V;
    }

    public LinkedList<Integer>[] getGraph(){
        return graph;
    }

    public static void main(String[] args) {
    }
}
