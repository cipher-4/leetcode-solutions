class Solution {
    public String reverseParentheses(String s) {
        
        Stack<String> st = new Stack<>();
        String curr = "";

        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
            {
                st.push(curr);
                curr = "";
            }
            else if(ch == ')')
            {
                curr = new StringBuilder(curr).reverse().toString();
                curr = st.pop() + curr;
            }
            else
            {
                curr += ch;
            }
        }
        return curr;
    }
}