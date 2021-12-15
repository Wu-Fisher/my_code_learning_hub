class Solution851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
            int n = quiet.length;
            int[][]w = new int [n][n];
            int[]d= new int[n];
            for(int[] r: richer)
            {
                int a=r[0],b=r[1];
                w[a][b]=1;
                d[b]++;
            }
            int[] ans= new int[n];
            Deque<Integer> q  = new ArrayDeque<>();
            for(int i=0;i<n;i++)
            {
                ans[i]=i;
                if(d[i]==0)q.addLast(i);
            }
            while(!q.isEmpty())
            {
                int t = q.pollFirst();
                for(int i=0;i<n;i++)
                {
                    if(w[t][i]==1)
                    {
                        if(quiet[ans[t]]<quiet[ans[i]]) ans[i]=ans[t];
                        if(--d[i]==0)q.addLast(i);
                    }
                }
            }
            return ans;
    }
}