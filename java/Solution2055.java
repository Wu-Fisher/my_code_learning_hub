import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int m = queries.length;
        int[] ans = new int[m];
        int[] cnt = new int[n + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '|')
                list.add(i);
            cnt[i + 1] = cnt[i] + (c == '*' ? 1 : 0);
        }
        int ll = list.size();
        if (ll == 0)
            return ans;
        for (int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int c = -1, d = n;

            int l = 0, r = ll - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (list.get(mid) >= a)
                    r = mid;
                else
                    l = mid + 1;
            }
            if (list.get(r) >= a)
                c = list.get(r);
            else
                continue;

            l = 0;
            r = ll - 1;
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (list.get(mid) <= b)
                    l = mid;
                else
                    r = mid - 1;
            }
            if (list.get(l) <= b)
                d = list.get(l);
            else
                continue;
            if (c <= d)
                ans[i] = cnt[d + 1] - cnt[c];
        }
        return ans;

    }

    public int[] platesBetweenCandles_second(String s, int[][] queries) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int m = queries.length;
        int[] l = new int[n];
        int[] r = new int[n];
        int[] ans = new int[m];
        int[] cnt = new int[n + 1];
        for (int i = 0, j = n - 1, p = -1, q = -1; i < n && j > -1; i++, j--) {
            if (cs[i] == '|')
                p = i;
            if (cs[j] == '|')
                q = j;
            l[i] = p;
            r[j] = q;
            cnt[i + 1] = cnt[i] + (cs[i] == '*' ? 1 : 0);

        }

        for (int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int c = r[a];
            int d = l[b];
            if (c > -1 && c <= d)
                ans[i] = cnt[d + 1] - cnt[c];
            else
                continue;
        }
        return ans;
    }
}