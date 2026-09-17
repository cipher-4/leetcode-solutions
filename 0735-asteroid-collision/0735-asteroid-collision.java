class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();
        for(int x : asteroids)
        {
            if(x>0)
            {
                st.push(x);
            }
            else
            {
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(x))
                {
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()>0 && st.peek() == Math.abs(x))
                {
                    st.pop();
                }
                else if(st.isEmpty() || st.peek()<0)
                {
                    st.push(x);
                }
            }
        }
        int [] res = new int[st.size()];
        for(int i=0; i<res.length; i++)
        {
            res[i] = st.pop();
        }
        int [] fin = new int[res.length];
        for(int i=0; i<res.length; i++)
        {
            fin[i] = res[res.length-1-i];
        }
        return fin;
    }
}