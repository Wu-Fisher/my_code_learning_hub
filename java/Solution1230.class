class Solution1230 {
    public double probabilityOfHeads(double[] prob, int target) {
            int n=prob.length;
            double[][] dp=new double[n+1][target+1];
            for(int i=1;i<=target;i++)
            {
                dp[0][i]=0;
            }
            dp[0][0]=1;
            dp[1][0]=1-prob[0];
            for(int i=2;i<=n;i++)
            {
                dp[i][0]=dp[i-1][0]*(1-prob[i-1]);
            }
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=Math.min(i,target);j++)
                {
                    dp[i][j]=dp[i-1][j-1]*prob[i-1]+dp[i-1][j]*(1-prob[i-1]);
                }
            }
            return dp[n][target];

    }
}