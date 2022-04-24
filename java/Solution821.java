public class Solution821 {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        Arrays.fill(ans, n + 1);
        for (int i = 0, j = -1; i < n; i++) {
            if (s.charAt(i) == c)
                j = i;
            if (j != -1)
                ans[i] = i - j;

        }
        for (int i = n - 1, j = -1; i > -1; i--) {
            if (s.charAt(i) == c)
                j = i;
            if (j != -1)
                ans[i] = Math.min(ans[i], j - i);
        }
        return ans;

    }
}
