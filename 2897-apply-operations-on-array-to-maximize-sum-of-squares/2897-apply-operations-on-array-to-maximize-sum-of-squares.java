class Solution {
    public int maxSum(List<Integer> nums, int k) {

        long res=0; int mod = 1000000007;
        int [] count = new int[32];

        for(int x : nums)
        {
            for(int b=0; b<32; b++)
            {
                if((x&(1<<b)) != 0)
                {
                    count[b]++;
                }
            }
        }
        while(k-->0)
        {
            long curr=0;
            for(int b=0; b<32; b++)
            {
                if(count[b] > 0)
                {
                    count[b]--;
                    curr |= (1 << b);
                }
            }
            res = (res+curr*curr)%mod;
        }
        return (int)res;
    }
}