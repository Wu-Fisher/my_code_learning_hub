public class Solution357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        int ans = 10;
        for (int i = 2, last = 9; i <= n; i++) {
            int cur = last * (11 - i);
            ans += cur;
            last = cur;
        }
        return ans;
    }
}
