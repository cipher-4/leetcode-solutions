class Solution {
    public int resilientSubarray(int[] nums, int k) {

        int n = nums.length;
        int len=0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++)
        {
            int rem = nums[i]%k;
            if(i>0 && nums[i-1]%k==rem)
            {
                len++;
            }
            else
            {
                len=1;
            }

            if((long) ((len-1)*rem)%k==0)
            {
                max = Math.max(max,len);
            }
        }
        return max;
    }
}