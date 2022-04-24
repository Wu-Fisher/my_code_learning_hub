public class Solution123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if (n == 1)
            return 0;

        int s1 = 0, b1 = -prices[0];
        int s2 = 0, b2 = -prices[0];

        for (int i = 1; i < n; i++) {
            s1 = Math.max(s1, b1 + prices[i]);
            b1 = Math.max(b1, -prices[i]);
            s2 = Math.max(s2, b2 + prices[i]);
            b2 = Math.max(b2, s1 - prices[i]);

        }

        return s2;

    }
}
