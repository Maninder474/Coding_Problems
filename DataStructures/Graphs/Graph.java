package DataStructures.Graphs;

import java.util.ArrayList;
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

    public void DFSUtil(int s,boolean visited[]){
        visited[s] = true;
        System.out.println(s);

        Iterator<Integer> i = graph[s].listIterator();

        while(i.hasNext()){
            int n = i.next();
            if(!visited[n])
                DFSUtil(n,visited);
        }
    }

    public void DFSItr(int s,boolean visited[]){

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
            Iterator<Integer> ls = graph[s].listIterator();
            while(ls.hasNext()){
                s = ls.next();
             count=   connectedNodes(s,d,count);
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
                Iterator<Integer> it = graph[n].listIterator();
                while(it.hasNext()){
                    int s = it.next();
                    if(!visited[s]){
                        q.add(s);
                        visited[s]=true;
                        level[s]=level[n]+1;
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
                if(!visited[i])
                    if(isCyclicUnDirectedUtil(graph,i,visited,-1))
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
        boolean visited[] = new boolean[V];
        for(int i = 0;i<V;i++)
            if(!visited[i])
                sort(i,st,visited);
        while(!st.isEmpty()){
          System.out.println(st.pop()+" ");
        }
    }
    public void sort(int i,Stack<Integer> st,boolean visited[]){
        
        visited[i]=true;
        Iterator<Integer> it = graph[i].listIterator();
        while(it.hasNext()){
            int n = it.next();
            if(!visited[n]){
                sort(n,st,visited);
            }
        }
        st.push(i);
    }

    public int spanningTree(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        boolean mst[] = new boolean[V];
        int key[] = new int[V];
        for(int i = 0;i<V;i++)
            key[i]=Integer.MAX_VALUE;
        key[0]=0;
        for(int i = 0;i<V;i++){
            int u = minset(key,mst);
            mst[u]=true;
            Iterator<ArrayList<Integer>> it = adj.get(u).listIterator();
            while(it.hasNext()){
                ArrayList<Integer> al = it.next();
                if(!mst[al.get(0)] && key[al.get(0)]>al.get(1)){
                    key[al.get(0)] = al.get(1);
                }
            }
        }
        int sum = 0;
        for(int i = 0;i<key.length;i++)
            sum+= key[i];
        return sum;
    }
    private static int minset(int key[],boolean mst[]){
        int n = key.length;
        int min = Integer.MAX_VALUE,min_index=-1;
        for(int i =0;i<n;i++)
            if(min>key[i] && mst[i]==false){
                min = key[i];
                min_index = i;
            }
        return min_index;
    }

    public int[] dijkstra(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        boolean mst[] = new boolean[V];
        int key[] = new int[V];
        for(int i = 0;i<V;i++)
            key[i]=Integer.MAX_VALUE;
        key[S]=0;
        for(int i = 0;i<V;i++){
            int u = minset(key,mst);
            mst[u]=true;
            Iterator<ArrayList<Integer>> it = adj.get(u).listIterator();
            while(it.hasNext()){
                ArrayList<Integer> al = it.next();
                if(!mst[al.get(0)] && key[al.get(0)]>al.get(1)+key[u]){
                    key[al.get(0)] =key[u]+ al.get(1);
                }
            }
        }
      return key;
    }
}