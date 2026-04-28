package DataStructures.Graphs;

public class CountIslands {
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
    public void dfs(char[][]grid,int r, int c,boolean [][]visited){
        visited[r][c] =true;
        int[]dr = {-1,-1,-1,0,0,1,1,1};
        int[]dc = {-1,0,1,-1,1,-1,0,1};

        for(int k=0;k<8;k++){
            int nr = r+dr[k];
            int nc = c+dc[k];

            if(GraphUtils.isSafe(grid,nr,nc,visited))
                dfs(grid,nr,nc,visited);
        }
    }
}
