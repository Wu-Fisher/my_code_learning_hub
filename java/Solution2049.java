import java.util.Arrays;

class Solution2049 {
    static int N = 100010, M = N * 2;
    static int[] ne = new int[M];
    static int[] he = new int[N];
    static int[] e = new int[M];

    static int[] f = new int[N];
    int idx;

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    int dfs(int u) {
        int ans = 1;
        for (int i = he[u]; i != -1; i = ne[i]) {
            ans += dfs(e[i]);
        }
        f[u] = ans;
        return ans;
    }

    public int countHighestScoreNodes(int[] parents) {
        Arrays.fill(he, -1);
        int n = parents.length;
        idx = 0;
        for (int i = 1; i < n; i++) {
            add(parents[i], i);
        }

        dfs(0);

        long max = 0;
        int ans = 0;

        for (int x = 0; x < n; x++) {
            long cur = 1;
            for (int i = he[x]; i != -1; i = ne[i]) {
                cur *= f[e[i]];
            }
            if (x != 0)
                cur *= n - f[x];
            if (cur > max) {
                max = cur;
                ans = 1;
            } else if (cur == max)
                ans++;
        }
        return ans;

    }
}
