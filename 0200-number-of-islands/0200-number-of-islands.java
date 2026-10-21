class Solution {
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean [][] vis = new boolean[m][n];
        int c=0;

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == '1' && !vis[i][j])
                {
                    c++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return c;
    }
    static void dfs(int r, int c, char [][] g, boolean [][] vis)
    {
        int m = g.length;
        int n = g[0].length;

        if(r<0 || r>=m || c<0 || c>=n )
        {
            return;
        }

        if(g[r][c] == '0')
        {
            return;
        }

        if(vis[r][c])
        {
            return;
        }

        vis[r][c] = true;
        dfs(r-1,c,g,vis);
        dfs(r+1,c,g,vis);
        dfs(r,c-1,g,vis);
        dfs(r,c+1,g,vis);

    }
}