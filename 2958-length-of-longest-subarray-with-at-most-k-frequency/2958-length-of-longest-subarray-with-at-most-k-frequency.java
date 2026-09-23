class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        Map<Integer,Integer> m = new HashMap<>();
        int l=0; int ans=Integer.MIN_VALUE;
        for(int r=0; r<nums.length; r++)
        {
            m.put(nums[r], m.getOrDefault(nums[r],0)+1);
            while(m.get(nums[r]) > k)
            {
                int reduce = m.get(nums[l]);
                reduce--;
                m.put(nums[l],reduce);
                l++;
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}