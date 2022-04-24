class Solution506 {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->b[1]-a[1]);
        int n=score.length;
        for(int i=0;i<n;i++)
        {
            q.add(new int[]{i,score[i]});
        }
        String[] ans = new String[n];
        for(int i=1;i<=n;i++)
        {
            int a = q.poll()[0];
            if(i==1)
            {
                ans[a]="Gold Medal";
            }
            else if(i==2)
            {
                ans[a]="Silver Medal";
            }
            else if(i==3)
            {
                ans[a]="Bronze Medal";
            }
            else
            {
                ans[a]=""+i;
            }

        }
        return ans;
    }
}