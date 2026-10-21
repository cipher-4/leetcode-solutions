class Solution {
    public int numEnclaves(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int c=0;
        boolean [][] vis = new boolean[m][n];

        for(int i=0; i<n; i++)
        {
            if(grid[0][i] == 1 && !vis[0][i])
            {
                dfs(0,i,grid,vis);
            }

            if(grid[m-1][i] == 1 && !vis[m-1][i])
            {
                dfs(m-1,i,grid,vis);
            }
        }

        for(int i=0; i<m; i++)
        {
            if(grid[i][0] == 1 && !vis[i][0])
            {
                dfs(i,0,grid,vis);
            }
            if(grid[i][n-1] == 1 && !vis[i][n-1])
            {
                dfs(i,n-1,grid,vis);
            }
        }

        for(int i=0; i<m;i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1 && !vis[i][j])
                {
                    c++;
                }
            }
        }
        return c;
        
    }
    static void dfs(int r, int c, int [][] grid, boolean [][] vis)
    {
        int m = grid.length;
        int n = grid[0].length;

        if(r<0 || r>=m || c<0 || c>=n)
        {
            return;
        }
        if(grid[r][c] == 0)
        {
            return;
        }
        if(vis[r][c])
        {
            return;
        }

        vis[r][c] = true;

        dfs(r-1,c,grid,vis);
        dfs(r+1,c,grid,vis);
        dfs(r,c-1,grid,vis);
        dfs(r,c+1,grid,vis);

    }
}