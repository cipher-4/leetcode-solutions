class Solution {
    public long maxAlternatingSum(int[] nums) {

        for(int i=0; i<nums.length; i++)
        {
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        int left=0;
        int right = nums.length-1;

        long score=0;
        for(int i=0; i<nums.length; i++)
        {
            long sq;
            if(i%2==0)
            {
                sq= (long)nums[right]*nums[right];
                right--;
                score += sq;
            }
            else
            {
                sq = (long)nums[left]*nums[left];
                left++;
                score -= sq;
            }
        }
        return score;
    }
}