package DataStructures.DynamicProgramming;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostPath {
    public int minimumCostPath(int[][] grid) {

        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0],b[0]));
        int [][] cost = new int[n][n];
        for(int [] row :cost)
            Arrays.fill(row,Integer.MAX_VALUE);
        cost[0][0]=grid[0][0];
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
        pq.offer(new int[]{grid[0][0],0,0});
        while(!pq.isEmpty()){
            int []top = pq.poll();
            int i = top[1],j = top[2];
            for(int[] d : dir){
                int x = i+d[0];
                int y = j+d[1];
                if(isValid(x,y,n) && cost[i][j]+grid[x][y]<cost[x][y]){
                    cost[x][y] = cost[i][j]+grid[x][y];
                    pq.offer(new int[]{cost[x][y],x,y});
                }
            }
        }
        return cost[n-1][n-1];

    }

    public boolean isValid(int i,int j,int n){
        return i>=0 && i<n && j>=0 && j<n;
    }
}
