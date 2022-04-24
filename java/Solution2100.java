import java.util.ArrayList;
import java.util.List;

class Solution2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        // 这里可以加一个time不等于0，否则只有一天也可以
        if (n == 1 && time != 0)
            return new ArrayList<>();
        int[] g = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] == security[i - 1])
                continue;
            g[i] = security[i] > security[i - 1] ? 1 : -1;

        }

        int[] a = new int[n];
        int[] b = new int[n];

        a[0] = g[0] == 1 ? 1 : 0;
        b[0] = g[0] == -1 ? 1 : 0;

        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + (g[i] == 1 ? 1 : 0);
            b[i] = b[i - 1] + (g[i] == -1 ? 1 : 0);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = time; i < n - time; i++) {
            int c = a[i] - a[i - time];
            int d = b[i + time] - b[i];
            if (c == 0 && d == 0)
                ans.add(i);
        }
        return ans;
    }
}