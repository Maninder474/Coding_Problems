package DataStructures.Graphs;

import DataStructures.util.arrays.ArrayUtil;

public class RottenOranges {
    // This function returns the minimum time required to rot all oranges. If it is impossible to rot every orange then returns -1.
    // 0 means empty cell, 1 means fresh orange and 2 means rotten orange.
    // we can use bfs to solve this problem but here i am using simple simulation to solve this problem.
    // we will keep on rotting the fresh oranges until there is no change in the grid and then we will check if there is any fresh orange left or not.
    // time complexity of this solution is O(n*m*max(time)) where time is the time taken to rot all oranges.
    // we can optimize this solution by using bfs and keeping track of the time taken to rot each orange and then we can return the maximum time taken to rot all oranges.
    // we can also optimize this solution by using a queue to keep track of the rotten oranges and then we can rot the fresh oranges in one pass and then we can return the time taken to rot all oranges.
    public static int orangesRot(int[][] grid){
        int n = grid.length,m = grid[0].length;
        boolean changed = false;
        int time = 0;
        int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while(true) {
            changed = false;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if(grid[i][j]==2)
                        for(int []dir :directions){
                            int x = i+dir[0],y = j+dir[1];
                            if(ArrayUtil.isSafe(x,y,n,m) && grid[x][y] == 1){
                                grid[x][y] = 2;
                                changed = true;
                            }
                        }
            if (!changed)
                break;
            time++;
        }
        for (int[] ints : grid)
            for (int j = 0; j < m; j++)
                if (ints[j] == 1)
                    return -1;
        return time;
    }

}
