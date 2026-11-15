class Solution {
    public int numOfSubarrays(int[] arr) {
        
        int mod = 1_000_000_007;

        int n = arr.length;
        int odd=0;
        int even=1;
        int pref=0;
        int count=0;


        for(int x : arr)
        {
            pref += x;
            if(pref%2==0)
            {
                count += odd;
                even++;
            }
            else
            {
                count += even;
                odd++;
            }
            count %= mod;
        }
        return count;
    }
}