public class Solution309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1)
            return 0;
        int dp0 = -prices[0], dp1 = 0, dp2 = 0;
        int a = dp0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            a = Math.max(dp0, dp2 - prices[i]);
            b = dp0 + prices[i];
            c = Math.max(dp1, dp2);

            dp0 = a;
            dp1 = b;
            dp2 = c;

        }
        return Math.max(dp1, dp2);
    }
}
