class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int [][] dis = new int[m][n];
        boolean [][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mat[i][j] == 0 && !vis[i][j])
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j] = true;
                }
            }
        }

        int [] drow = {-1,0,1,0};
        int [] dcol = {0,1,0,-1};

        while(!q.isEmpty())
        {
            int r = q.peek().row;
            int c = q.peek().col;
            int count = q.peek().d;
            q.poll();

            dis[r][c] = count; 

            for(int i=0; i<4; i++)
            {
                int nr = r + drow[i];
                int nc = c + dcol[i];

                if(nr >=0 && nr<m && nc>=0 && nc<n && !vis[nr][nc])
                {
                    vis[nr][nc] = true;
                    q.add(new Pair(nr,nc,count+1));
                }
            }
        }
        return dis;
    }
}

class Pair
{
    int row;
    int col;
    int d;
    Pair(int row, int col, int d)
    {
        this.row = row;
        this.col = col;
        this.d = d;
    }
}