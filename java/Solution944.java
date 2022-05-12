public class Solution944 {
    public int minDeletionSize(String[] strs) {
        int ans = 0;
        int n = strs[0].length();
        int m = strs.length;
        out: for (int i = 0; i < n; i++) {
            {
                for (int j = 0, cur = -1; j < m; j++) {
                    int c = strs[j].charAt(i);
                    if (c < cur && ++ans >= 0)
                        continue out;
                    cur = c;
                }
            }

        }
        return ans;
    }
}
