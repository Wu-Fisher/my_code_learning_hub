public class Solution829 {
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        for (int i = 1; i * i <= 2 * n; i++) {
            if ((2 * n) % i == 0) {
                if ((2 * n / i + 1 - i) % 2 == 0) {
                    ans++;
                }
            }

        }
        return ans;
    }
}
