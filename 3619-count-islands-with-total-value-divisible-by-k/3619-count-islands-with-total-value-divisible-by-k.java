class Solution {
    public int countIslands(int[][] grid, int k) {

        int m = grid.length; 
        int n = grid[0].length;
        boolean [][] vis = new boolean[m][n];
        int c=0;

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] != 0 && !vis[i][j])
                {
                    long res = dfs(i,j,0,grid,vis);
                    if(res % k == 0)
                    {
                        c++;
                    }
                }
            }
        }
        return c;

    }
    static long dfs(int r, int c, long sum , int [][] grid, boolean [][] vis)
    {
        int m = grid.length; 
        int n = grid[0].length;

        if(r<0 || r>=m || c<0 || c>= n)
        {
            return 0;
        }
        if(vis[r][c])
        {
            return 0;
        }
        if(grid[r][c] == 0)
        {
            return 0;
        }

        vis[r][c] = true;
        sum += grid[r][c];
        sum += dfs(r+1,c,0,grid,vis);
        sum += dfs(r-1,c,0,grid,vis);
        sum += dfs(r,c+1,0,grid,vis);
        sum += dfs(r,c-1,0,grid,vis);

        return sum;
    }
}