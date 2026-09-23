class Solution {
    public int divisorSubstrings(int num, int k) {

        String s = Integer.toString(num);
        int cnt=0;
        for(int i=0; i<=s.length()-k; i++)
        {
            String curr = s.substring(i, i+k);
            if(div(s,curr))
            {
                cnt++;
            }
        }
        return cnt;
    }
    static boolean div(String act, String s)
    {
        int num = Integer.parseInt(act);
        int d = Integer.parseInt(s);
        if(d==0)
        {
            return false;
        }
        return num%d == 0;
    }
}