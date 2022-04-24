public class Solution2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;

        int res = (n + m) * mean;

        for (int i : rolls) {
            res -= i;
        }
        if (res < n || res > 6 * n)
            return new int[0];
        else {
            int[] ans = new int[n];
            Arrays.fill(ans, res / n);
            if (res / n * n < res) {
                int d = res - res / n * n;
                while (d-- > 0)
                    ans[d]++;
            }
            return ans;
        }

    }
}
