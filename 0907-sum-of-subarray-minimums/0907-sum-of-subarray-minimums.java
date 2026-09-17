class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int [] l = new int[n];
        int [] r = new int[n];

        Stack<Integer> st = new Stack<>();
        //pse
        for(int i=0; i<n; i++)
        {
            while(!st.isEmpty() && arr[i] < arr[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                l[i] = i+1;
            }
            else
            {
                l[i] = i-st.peek();
            }
            st.push(i);
        }
        st.clear();
        //nse
        for(int i=n-1; i>=0; i--)
        {
            while(!st.isEmpty() && arr[i] <= arr[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                r[i] = n-i;
            }
            else
            {
                r[i] = st.peek()-i;
            }
            st.push(i);
        }

        int mod = 1_000_000_007;
        long sum=0;
        for(int i=0; i<n; i++)
        {
            long curr = (long) l[i]*r[i]*arr[i];
            sum += curr%mod;
        }
        return (int)(sum%mod);
    }
}