class Solution {
    public int maxLength(int[] nums) {

        int n = nums.length;
        int res=0;

        for(int i=0; i<n; i++)
        {
            int p=1;
            int gcd=0;
            int lcm=1;
            for(int j=i; j<n; j++)
            {
                p *= nums[j];
                gcd = gcdFun(gcd,nums[j]);
                lcm = (lcm/gcdFun(lcm,nums[j]))*nums[j];
                if(p == gcd*lcm)
                {
                    res = Math.max(res,j-i+1);
                }
            }
        }
        return res;
        
    }

    static int gcdFun(int a , int b)
    {
        while(b != 0)
        {
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}