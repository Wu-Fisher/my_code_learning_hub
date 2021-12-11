class Solution322 {
    public int coinChange(int[] coins, int amount) {
            int max=amount+1;
            int[] dp= new int[amount+1];
            Arrays.fill(dp,max);
            dp[0]=0;
            for(int i=1;i<=amount;i++)
            {
                for(int co :coins)
                {
                    if(co<=i)
                    {
                        dp[i]=Math.min(dp[i-co]+1,dp[i]);
                    }
                }
            }
            return dp[amount]>=max?-1:dp[amount];
    }
}