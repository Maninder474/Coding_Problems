package DataStructures.Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphUtils {
    public void bfs(int s,Graph graph){
        boolean visited[] = new boolean[graph.getVertex()];
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);

        while(!queue.isEmpty()){
            s = queue.poll();
            System.out.println(s);
            Iterator<Integer> i = graph.getGraph()[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    queue.add(n);
                    visited[n]=true;
                }
            }
        }
    }

    public void DFSRec(int s, boolean[] visited,Graph graph){
        visited[s] = true;
        System.out.println(s);

        Iterator<Integer> i = graph.getGraph()[s].listIterator();

        while(i.hasNext()){
            int n = i.next();
            if(!visited[n])
                DFSRec(n,visited,graph);
        }
    }

    public static void DFSItr(int s, boolean[] visited,Graph graph){

        Stack<Integer> st = new Stack<Integer> ();
        st.push(s);
        while(!st.isEmpty()){
            s = st.peek();
            st.pop();
            visited[s] = true;
            System.out.println(s);
            Iterator<Integer> i = graph.getGraph()[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n])
                    st.push(n);
            }
        }
    }

    public static int minset(int key[],boolean mst[]){
        int n = key.length;
        int min = Integer.MAX_VALUE,min_index=-1;
        for(int i =0;i<n;i++)
            if(min>key[i] && !mst[i]){
                min = key[i];
                min_index = i;
            }
        return min_index;
    }

    static boolean isSafe(char[][] grid, int r, int c, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        return (r>=0 && r<n && c>=0 && c<m && grid[r][c]=='L'&& !visited[r][c]);
    }
}
