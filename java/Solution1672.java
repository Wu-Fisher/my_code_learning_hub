public class Solution1672 {
    public int maximumWealth(int[][] accounts) {
        int ans = 0;
        for (int[] a : accounts) {
            int cur = 0;
            for (int b : a) {
                cur += b;
            }
            if (cur > ans) {
                ans = cur;
            }
        }
        return ans;
    }
}
