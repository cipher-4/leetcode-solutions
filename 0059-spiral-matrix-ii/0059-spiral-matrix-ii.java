class Solution {
    public int[][] generateMatrix(int n) {

        int [][] res = new int[n][n];

        int row = res.length;
        int col = res[0].length;

        int top=0; int bottom = row-1;
        int left=0; int right = col-1;

        int k=1;

        while(top <= bottom && left <= right)
        {
            for(int i=left; i<=right; i++)
            {
                res[top][i] = k++;
            }
            top++;

            for(int i=top; i<=bottom; i++)
            {
                res[i][right] = k++;
            }
            right--;

            for(int i=right; i>=left; i--)
            {
                res[bottom][i] = k++;
            }
            bottom--;

            for(int i=bottom; i>=top; i--)
            {
                res[i][left] = k++;
            }
            left++;
        }  
        return res;     
    }
}