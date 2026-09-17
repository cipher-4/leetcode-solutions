class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> st = new Stack<>();
    
        for(char x : num.toCharArray())
        {
            while(!st.isEmpty() && k>0 && (st.peek()-'0') > x-'0')
            {
                st.pop();
                k--;
            }
            st.push(x);
        }

        //12345 case
        while(!st.isEmpty() && k>0)
        {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for(char y : st)
        {
            sb.append(y);
        }

        //0 in the beg
        while(sb.length()>0 && sb.charAt(0) == '0')
        {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString(); 
    }
}