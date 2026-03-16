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

    public void addEdge(int v,int w){
        graph[v].add(w);
    }

    public void BFS(int s){
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);

        while(!queue.isEmpty()){
            s = queue.poll();
            System.out.println(s);
            Iterator<Integer> i = graph[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    queue.add(n);
                    visited[n]=true;
                }
            }
        }
    }

    public void DFSUtil(int s, boolean[] visited){
        visited[s] = true;
        System.out.println(s);

        Iterator<Integer> i = graph[s].listIterator();

        while(i.hasNext()){
            int n = i.next();
            if(!visited[n])
                DFSUtil(n,visited);
        }
    }

    public void DFSItr(int s, boolean[] visited){

        Stack<Integer> st = new Stack<Integer> ();
        st.push(s);
        while(!st.isEmpty()){
            s = st.peek();
            st.pop();
            visited[s] = true;
            System.out.println(s);
            Iterator<Integer> i = graph[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n])
                   st.push(n);
            }
        }
    }

    public void DFSItr(int s){
        boolean visited[] = new boolean[V];
        Stack<Integer> st = new Stack<Integer> ();
        st.push(s);
        while(!st.isEmpty()){
            s = st.peek();
            st.pop();
            visited[s] = true;
            System.out.println(s);
            Iterator<Integer> i = graph[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n])
                   st.push(n);
            }
        }
    }

    public void DFS(){
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            if(!visited[i])
                DFSUtil(i, visited);
    }

    public void DFSItr(){
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            if(!visited[i])
                DFSItr(i,visited);
    }

    public int motherVertex(){

        boolean visited[] = new boolean[V];
        int v =-1;
        for (int i = 0; i < V; i++)
            if(!visited[i]){
                DFSUtil(i, visited);
                v=i;
            }
        visited=new boolean[V];
        DFSUtil(v, visited);
        for (int i = 0; i < visited.length; i++)
            if(!visited[i])
                return -1;
        return v;
    }

    public int connectedNodes(int s ,int d, int count){
        if(s==d)
            count++;
        else{
            for (Integer integer : graph[s]) {
                count = connectedNodes(integer, d, count);
            }
        }
        return count;
    }

    public void findLevelOfNode(int count){
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

    public boolean isCyclic(boolean directed) {
        boolean visited[] = new boolean[V];
        if(directed){
            boolean rec[] = new boolean[V];
            for(int i =0;i<V;i++)
                if(isCyclicDirectedUtil(graph,i,visited,rec))
                    return true;
            return false;
        }else{
            for(int i = 0;i<V;i++)
                if(!visited[i] && isCyclicUnDirectedUtil(graph,i,visited,-1))
                    return true;
            return false;
        }
    }
    public boolean isCyclicDirectedUtil(LinkedList<Integer> adj[],int i,boolean visited[],boolean rec[]){
        
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

    public void topologicalSort(){
        Stack<Integer> st = new Stack<Integer>();
        boolean[] visited = new boolean[V];
        for(int i = 0;i<V;i++)
            if(!visited[i])
                sort(i,st,visited);
        while(!st.isEmpty())
          System.out.println(st.pop()+" ");
    }
    public void sort(int i,Stack<Integer> st,boolean visited[]){
        
        visited[i]=true;
        for (int n : graph[i])
            if (!visited[n])
                sort(n, st, visited);
        st.push(i);
    }

    public int spanningTree(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        boolean[] mst = new boolean[V];
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0]=0;
        for(int i = 0;i<V;i++){
            int u = minset(key,mst);
            mst[u]=true;
            for (ArrayList<Integer> al : adj.get(u))
                if (!mst[al.get(0)] && key[al.get(0)] > al.get(1))
                    key[al.get(0)] = al.get(1);
        }
        int sum = 0;
        for (int j : key) sum += j;
        return sum;
    }
    private static int minset(int key[],boolean mst[]){
        int n = key.length;
        int min = Integer.MAX_VALUE,min_index=-1;
        for(int i =0;i<n;i++)
            if(min>key[i] && !mst[i]){
                min = key[i];
                min_index = i;
            }
        return min_index;
    }

    public int[] dijkstra(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        boolean[] mst = new boolean[V];
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[S]=0;
        for(int i = 0;i<V;i++){
            int u = minset(key,mst);
            mst[u]=true;
            for (ArrayList<Integer> al : adj.get(u)) {
                if (!mst[al.get(0)] && key[al.get(0)] > al.get(1) + key[u])
                    key[al.get(0)] = key[u] + al.get(1);
            }
        }
      return key;
    }


    // Function to find the order of characters in the alien language
    public String findOrder(String[] words) {
        // code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[26];
        boolean[] visited = new boolean[26];
        for(int i = 0;i<26;i++)
            graph.add(new ArrayList<>());
        for(String s : words)
            for(char ch : s.toCharArray())
                visited[ch-'a']=true;
        for(int i = 0;i<words.length-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            int len = Math.min(s1.length(),s2.length());
            int j =0;
            while(j<len && s1.charAt(j)==s2.charAt(j)) j++;
            if(j<len){
                int u = s1.charAt(j)-'a';
                int v = s2.charAt(j)-'a';
                graph.get(u).add(v);
                inDegree[v]++;
            }else if(s1.length()>s2.length()) return "";
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<26;i++)
            if(inDegree[i]==0 && visited[i])
                q.offer(i);

        String res = "";
        while(!q.isEmpty()){
            int u = q.poll();
            res+= (char)(u+'a');
            for(int v : graph.get(u)){
                inDegree[v]--;
                if(inDegree[v]==0)
                    q.offer(v);
            }
        }

        for(int i =0;i<26;i++)
            if(visited[i] && inDegree[i]!=0)
                return "";
        return res;
    }

    public int countIslands(char[][] grid) {

        int count=0;
        int n= grid.length;
        int m = grid[0].length;
        boolean [][]visited=new boolean[n][m];

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='L' && !visited[i][j]){
                    dfs(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;

    }

    static boolean isSafe(char[][] grid, int r, int c, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        return (r>=0 && r<n && c>=0 && c<m && grid[r][c]=='L'&& !visited[r][c]);
    }

    public void dfs(char[][]grid,int r, int c,boolean [][]visited){
        visited[r][c] =true;
        int[]dr = {-1,-1,-1,0,0,1,1,1};
        int[]dc = {-1,0,1,-1,1,-1,0,1};

        for(int k=0;k<8;k++){
            int nr = r+dr[k];
            int nc = c+dc[k];

            if(isSafe(grid,nr,nc,visited))
                dfs(grid,nr,nc,visited);
        }
    }

    public static void floydwarshall() {

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

    public static void main(String[] args) {
        floydwarshall();
    }


}
