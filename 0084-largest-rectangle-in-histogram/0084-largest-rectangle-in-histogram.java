class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int [] l = new int[n];
        int [] r = new int[n];
        Stack<Integer> st = new Stack<>();

        //pse 
        for(int i=0; i<n; i++)
        {
            while(!st.isEmpty() && heights[i] < heights[st.peek()])
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
        //nse
        st.clear();
        for(int i=n-1; i>=0; i--)
        {
            while(!st.isEmpty() && heights[i] <= heights[st.peek()])
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
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
        {
            int width = (r[i] + l[i] - 1);
            int res = heights[i] * width;
            max = Math.max(max,res);
        }
        return max;
    }
}