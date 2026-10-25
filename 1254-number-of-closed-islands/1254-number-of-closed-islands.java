class Solution {
    public int closedIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean [][] vis = new boolean[m][n];
        int c=0;

        for(int i=0; i<n; i++)
        {
            if(grid[0][i] == 0 && !vis[0][i])
            {
                dfs(0,i,grid,vis);
            }
            if(grid[m-1][i] == 0 && !vis[m-1][i])
            {
                dfs(m-1,i,grid,vis);
            }
        }
        for(int i=0; i<m; i++)
        {
            if(grid[i][0] == 0 && !vis[i][0])
            {
                dfs(i,0,grid,vis);
            }
            if(grid[i][n-1] == 0 && !vis[i][n-1])
            {
                dfs(i,n-1,grid,vis);
            }
        }
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 0 && !vis[i][j])
                {
                    c++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return c;
    }
    public void dfs(int r, int c, int [][] grid, boolean [][] vis)
    {
        int m = grid.length;
        int n = grid[0].length;

        if(r<0 || r>=m || c<0 || c>= n)
        {
            return;
        }
        if(grid[r][c] == 1)
        {
            return;
        }
        if(vis[r][c])
        {
            return;
        }
        vis[r][c] = true;
        dfs(r+1,c,grid,vis);
        dfs(r-1,c,grid,vis);
        dfs(r,c+1,grid,vis);
        dfs(r,c-1,grid,vis);
    }
}