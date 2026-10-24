class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        String start = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
        String end = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;

        if(start.compareTo(end) > 0)
        {
            return 0;
        }
        
        int [] days = {31,28,31,30,31,30,31,31,30,31,30,31};

        int startD = toDay(start,days);
        int endD = toDay(end, days);

        return endD-startD+1;
    }
    static int toDay(String date, int [] days)
    {
        int month = Integer.parseInt(date.substring(0,2));
        int day = Integer.parseInt(date.substring(3,5));

        int tot = day;
        for(int i=0; i<month-1; i++)
        {
            tot += days[i];
        }
        return tot;
    }
}