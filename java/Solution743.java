import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution743 {
    int N = 110;
    // M为边的映射，所以应该是点的倍数
    int M = 6010;
    int[] he = new int[N];
    int[] e = new int[M];
    int[] ne = new int[M];
    int[] w = new int[M];

    // 这题也是用1-n作为节点标号（并且作为参数告诉我们的）
    int[] dist = new int[N];
    boolean[] vis = new boolean[N];

    int n, k, idx;
    int INF = 0x3f3f3f3f;

    void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        w[idx] = c;
        idx++;
    }

    public int networkDelayTime(int[][] ts, int _n, int _k) {
        n = _n;
        k = _k;
        idx = 0;
        // 这个he要在外面优化
        Arrays.fill(he, -1);
        for (int[] t : ts) {
            add(t[0], t[1], t[2]);
        }
        dijkstra();
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans > INF / 2 ? -1 : ans;

    }

    void dijkstra() {

        Arrays.fill(dist, INF);
        Arrays.fill(vis, false);

        dist[k] = 0;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[] { k, 0 });
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int id = poll[0];
            if (vis[id])
                continue;
            vis[id] = true;
            for (int i = he[id]; i != -1; i = ne[i]) {
                int j = e[i];

                if (dist[j] > dist[id] + w[i]) {
                    dist[j] = dist[id] + w[i];
                    q.add(new int[] { j, dist[j] });
                }
            }
        }

    }

}
