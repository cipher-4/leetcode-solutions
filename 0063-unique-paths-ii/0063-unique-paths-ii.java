class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for(int [] row : dp)
        {
            Arrays.fill(row,-1);
        }
        int res = fun(m-1,n-1,obstacleGrid,dp);
        return res;
    }
    static int fun(int i, int j,int [][] obstacleGrid ,int [][] dp)
    {
        if(i<0 || j<0)
        {
            return 0;
        }

        if(obstacleGrid[i][j] == 1)
        {
            return 0;
        }

        if(i == 0 && j==0)
        {
            return 1;
        }

        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        int up = fun(i-1,j,obstacleGrid,dp);
        int left = fun(i,j-1,obstacleGrid,dp);

        return dp[i][j] = up+left;
    }

}