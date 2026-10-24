class Solution {
    public int[] maxProductPair(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        long mProd = Long.MIN_VALUE;
        int[] ans = new int[]{-1, -1};

        for (int k=0; k<nums.length; k++) {
            int curr = target - nums[k];

            if (map.containsKey(curr))
            {
                if (nums[k] != curr) {
                    long prod = (long) nums[k] * curr;
                    if (prod > mProd)
                    {
                        mProd = prod;
                        int prev = map.get(curr);
                        if (nums[k] > curr) {
                            ans[0] = k;
                            ans[1] = prev;
                        } else {
                            ans[0] = prev;
                            ans[1] = k;
                        }
                    }
                }
            }
            map.put(nums[k], k);
        }
        return ans;
    }
}