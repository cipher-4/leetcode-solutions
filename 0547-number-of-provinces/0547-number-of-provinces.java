
class Solution {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        Queue<Integer> q= new LinkedList<>();
        boolean [] vis = new boolean[n];
        int c=0;

        for(int i=0; i<n; i++)
        {
            if(!vis[i])
            {
                q.add(i);
                vis[i] = true;
                c++;

                while(!q.isEmpty())
                {
                    Integer node = q.poll();
                    for(int x=0; x<n; x++)
                    {
                        if(isConnected[node][x] == 1 && !vis[x])
                        {
                            q.add(x);
                            vis[x] = true;
                        }
                    }
                }
            }
        }
        return c;
    }
}
