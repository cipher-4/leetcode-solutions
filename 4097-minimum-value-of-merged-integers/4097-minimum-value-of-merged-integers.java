class Solution {
    public int minMergedInteger(int[] nums) {

        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n-1; i+=2)
        {
            String curr = String.valueOf(nums[i]) + String.valueOf(nums[i+1]);
            int num = Integer.parseInt(curr);
            min = Math.min(min, num);
        }
        return min;
    }
}