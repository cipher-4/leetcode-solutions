class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int m = image.length;
        int n = image[0].length;

        boolean [][] vis = new boolean[m][n];
        int [][] res = new int[m][n];

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                res[i][j]= image[i][j];
            }
        }
        
        int pc = image[sr][sc];

        if(pc == color)
        {
            return image;
        }

        dfs(sr,sc,pc,color,image,vis,res);

        return res;
        
    }
    static void dfs(int r, int c, int pc, int nc, int [][] image, boolean [][] vis, int [][] res)
    {
        int m = image.length;
        int n = image[0].length;
        
        if(r<0 || r>= m || c<0 || c>= n)
        {
            return;
        }
        if(image[r][c] != pc)
        {
            return;
        }
        if(vis[r][c])
        {
            return;
        }

        vis[r][c] = true;
        res[r][c] = nc;

        dfs(r-1,c,pc,nc,image,vis,res);
        dfs(r+1,c,pc,nc,image,vis,res);
        dfs(r,c-1,pc,nc,image,vis,res);
        dfs(r,c+1,pc,nc,image,vis,res);
    }
}