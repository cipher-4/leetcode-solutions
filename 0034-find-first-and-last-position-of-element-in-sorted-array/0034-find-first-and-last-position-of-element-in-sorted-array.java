class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length-1;

        int lb = lower(nums, target);
        int ub = upper(nums, target);

        if(lb == nums.length || nums[lb] != target)
        {
            return new int[]{-1,-1};
        }
        return new int[]{lb,ub-1};
    }
    public static int lower(int [] arr, int t)
    {
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;

        while(low <= high)
        {
            int mid = low+(high-low)/2;
            if(arr[mid] >= t)
            {
                ans = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return ans;
    }

    public static int upper(int [] arr, int t)
    {
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;

        while(low <= high)
        {
            int mid = low+(high-low)/2;
            if(arr[mid] > t)
            {
                ans = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return ans;
    }



}