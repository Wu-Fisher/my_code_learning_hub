
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution2045 {
    static int N = 10010, M = 4 * N, INF = 0x3f3f3f3f, idx = 0;
    static int[] he = new int[N], e = new int[M], ne = new int[M];
    static int[] dist1 = new int[N], dist2 = new int[N];

    // 利用该方法可以建立一个映射，用来解决稀疏图的一个构建问题，利用固定的空间，避免构建一个和原来点数相同的稀疏矩阵浪费空间
    void add(int a, int b) {
        // e中保存idx映射的节点
        e[idx] = b;
        // ne保存当从a到b，（idx）之后，a应该遍历相邻的下一个节点为多少
        ne[idx] = he[a];
        // he 保存的是a节点临界遍历的第一个idx值（默认为-1就是没有邻接）
        he[a] = idx;
        // 然后idx++，其实我认为可以理解为有向边
        idx++;
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Arrays.fill(dist1, INF);
        Arrays.fill(dist2, INF);
        Arrays.fill(he, -1);
        idx = 0;
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            add(u, v);
            add(v, u);

        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // 这里可以看出节点是从1开始
        q.add(new int[] { 1, 0 });
        dist1[1] = 0;
        while (!q.isEmpty()) {
            // poll 储存当前到哪个节点 ,以及出发点到该点的距离
            int[] poll = q.poll();
            int u = poll[0], step = poll[1];
            // he为该点u的第一个临接节点，ne[i]为顺着的，由于一开始初始化的he全为-1，所以当i为-1的时候停止
            for (int i = he[u]; i != -1; i = ne[i]) {
                // j为到i映射的u的邻接节点，这里可以看出e的构造
                int j = e[i];
                int a = step / change, b = step % change;
                int wait = (a & 1) == 0 ? 0 : change - b;
                int dist = step + time + wait;
                // 由于我们没有限制重复，那么得到一个新的dij优化解必须是要么优于最优解，要么优于次优解，只有这样才让他入队
                if (dist1[j] > dist) {
                    dist2[j] = dist1[j];
                    dist1[j] = dist;
                    q.add(new int[] { j, dist1[j] });
                    q.add(new int[] { j, dist2[j] });
                } else if (dist1[j] < dist && dist < dist2[j]) {
                    dist2[j] = dist;
                    q.add(new int[] { j, dist2[j] });
                }

            }

        }

        return dist2[n];

    }

    // 优化法2
    // static int N = 10010, M = 4 * N, INF = 0x3f3f3f3f, idx = 0;
    // static int[] he = new int[N], e = new int[M], ne = new int[M];
    // void add(int a, int b) {
    // e[idx] = b;
    // ne[idx] = he[a];
    // he[a] = idx;
    // idx++;
    // }
    // public int secondMinimum(int n, int[][] edges, int time, int change) {
    // Arrays.fill(he, -1);
    // idx = 0;
    // for (int[] e : edges) {
    // int u = e[0], v = e[1];
    // add(u, v); add(v, u);
    // }
    // Deque<int[]> d = new ArrayDeque<>();
    // int[] dist1 = new int[n + 1], dist2 = new int[n + 1];
    // Arrays.fill(dist1, INF);
    // Arrays.fill(dist2, INF);
    // d.addLast(new int[]{1, 0});
    // dist1[1] = 0;
    // while (!d.isEmpty()) {
    // int[] poll = d.pollFirst();
    // int u = poll[0], dist = poll[1];
    // for (int i = he[u]; i != -1; i = ne[i]) {
    // int j = e[i];
    // if (dist1[j] > dist + 1) {
    // dist2[j] = dist1[j];
    // dist1[j] = dist + 1;
    // d.addLast(new int[]{j, dist1[j]});
    // d.addLast(new int[]{j, dist2[j]});
    // } else if (dist1[j] < dist + 1 && dist + 1 < dist2[j]) {
    // dist2[j] = dist + 1;
    // d.addLast(new int[]{j, dist2[j]});
    // }
    // }
    // }
    // int ans = 0;
    // for (int i = 0; i < dist2[n]; i++) {
    // int a = ans / change, b = ans % change;
    // int wait = a % 2 == 0 ? 0 : change - b;
    // ans += time + wait;
    // }
    // return ans;
    // }

}
