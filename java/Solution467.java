public class Solution467 {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int n = p.length();
        int cnt = 1;
        dp[p.charAt(0) - 'a'] = cnt;
        for (int i = 1; i < n; i++) {

            if ((p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) {
                cnt++;

            } else {
                cnt = 1;

            }

            dp[p.charAt(i) - 'a'] = Math.max(cnt, dp[p.charAt(i) - 'a']);
        }
        int ans = 0;
        for (int d : dp) {
            ans += d;
        }
        return ans;
    }
}
