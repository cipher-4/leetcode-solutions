class Solution {
    public String[] createGrid(int m, int n) {

        char [][] g = new char[m][n];
        for(int i=0; i<m; i++)
        {
            Arrays.fill(g[i],'#');
        }
        for(int i=0; i<n; i++)
        {
            g[0][i] = '.';
        }
        for(int i=0; i<m; i++)
        {
            g[i][n-1] = '.';
        }
        String [] ans = new String[m];
        for(int i=0; i<ans.length; i++)
        {
            ans[i] = new String(g[i]);
        }
        return ans;
    }
}