public class Solution522 {
    public int findLUSlength(String[] strs) {
        int ans = -1;
        int n = strs.length;
        out: for (int i = 0; i < n; i++) {
            int l = strs[i].length();
            if (l > ans) {
                for (int j = 0; j < n; j++) {
                    if (i != j && isSub(strs[i], strs[j])) {
                        continue out;
                    }
                }
                ans = l;
            }

        }
        return ans;
    }

    boolean isSub(String a, String b) {
        int m = a.length(), n = b.length();
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (i < m && a.charAt(i) == b.charAt(j))
                i++;
        }
        return i == m;
    }
}
