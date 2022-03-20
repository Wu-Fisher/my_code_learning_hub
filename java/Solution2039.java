import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution2039 {
    static int N = 100010;
    static int INF = 0x3f3f3f3f;
    static int[] h = new int[N];
    static int[] e = new int[2 * N];
    static int[] ne = new int[2 * N];
    static int[] dist = new int[N];

    static int idx;

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        Arrays.fill(h, -1);
        Arrays.fill(dist, INF);
        idx = 0;
        for (int[] e : edges) {
            add(e[0], e[1]);
            add(e[1], e[0]);
        }
        Deque<Integer> q = new ArrayDeque<>();

        q.add(0);
        dist[0] = 0;
        int n = patience.length;
        while (!q.isEmpty()) {
            int u = q.pollFirst();
            int t = dist[u];
            for (int i = h[u]; i != -1; i = ne[i]) {
                int v = e[i];
                if (dist[v] != INF)
                    continue;
                dist[v] = dist[u] + 1;
                q.addLast(v);
            }
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            int d = dist[i] * 2;
            int t = patience[i];
            int cur = d <= t ? d : (d - 1) / t * t + d;
            if (cur > ans)
                ans = cur;
        }
        return ans + 1;
    }
}
