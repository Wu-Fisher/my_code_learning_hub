public class Solution926 {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] sum = new int[n + 5];
        int ans = n;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (s.charAt(i - 1) == '0' ? 0 : 1);
        }
        for (int i = 0; i <= n; i++) {
            int l = sum[i];
            int r = n - i - (sum[n] - sum[i]);
            ans = Math.min(l + r, ans);
        }
        return ans;
    }
}
