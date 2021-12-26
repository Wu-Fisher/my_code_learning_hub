class Solution2110 {
    public long getDescentPeriods(int[] prices) {
        long ans = prices.length;
        int n=prices.length;
        int p=0;
        for(int i=1;i<n;i++)
        {
            if(prices[i]==prices[i-1]-1)
                {
                    p++;
                    ans+=p;
                }
            else{
                p=0;
            }
        }
        return ans;
    }
}