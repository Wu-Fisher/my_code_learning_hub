import java.util.Arrays;

public class Solution720 {
    static int N = 30010, M = 26;
    static int[][] tr = new int[N][M];
    static boolean[] isEnd = new boolean[N];
    static int idx = 0;

    void add(String s) {
        int p = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            int u = s.charAt(i) - 'a';
            if (tr[p][u] == 0)
                tr[p][u] = ++idx;
            p = tr[p][u];
        }
        isEnd[p] = true;
    }

    boolean query(String s) {
        int p = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            int u = s.charAt(i) - 'a';
            p = tr[p][u];
            if (!isEnd[p])
                return false;
        }
        return true;
    }

    public String longestWord(String[] words) {
        Arrays.fill(isEnd, false);
        for (int i = 0; i < idx; i++) {
            Arrays.fill(tr[i], 0);
        }
        idx = 0;

        String ans = "";
        for (String s : words)
            add(s);
        for (String s : words) {
            int n = s.length();
            int m = ans.length();
            if (n < m)
                continue;
            if (n == m && s.compareTo(ans) > 0)
                continue;
            if (query(s))
                ans = s;
        }
        return ans;
    }
}
