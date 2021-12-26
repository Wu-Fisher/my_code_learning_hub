class Solution1705 {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int n= apples.length,t=0,ans=0;
        while(t<n||!q.isEmpty())
        {
            if(t<n && apples[t]>0)q.add(new int[]{t+days[t]-1,apples[t]});
            while(!q.isEmpty()&&q.peek()[0]<t)q.poll();
            if(!q.isEmpty())
            {
                int[]cur = q.poll();
                ans++;
                if(cur[0]>t&&--cur[1]>0) q.add(cur);
            }
            t++;
        }
        return ans;
    }
}