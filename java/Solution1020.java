
class Solution1020 {
    int N = 550;
    int[] p = new int[N * N];
    int m, n;
    int[][] g;

    // 查找节点x属于哪一个联通分量
    // 由于联通分量本身具有传递性，所以这里的查找也是利用了一定递归的规则
    int find(int x) {
        // 如果x是一开始初始化的分量结果，则不变
        if (x != p[x])
            p[x] = find(p[x]);
        // 如果p[x]已经被修改过，则p[x]中储存的是他连接的最近节点的连通分量上
        return p[x];
    }

    // 判断两者是否为一个连通分量
    boolean query(int a, int b) {
        return find(a) == find(b);

    }

    // 将a节点联通到b节点的连通分量上
    // 该函数的联通具有顺序性
    void union(int a, int b) {
        p[find(a)] = find(b);
    }

    // 0号作为超级源点，所以+1
    int getIdx(int x, int y) {
        return x * n + y + 1;
    }

    public int numEnclaves(int[][] grid) {
        g = grid;
        // 之前这里重新int乐一下-😓-
        m = g.length;
        n = g[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                p[getIdx(i, j)] = getIdx(i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (g[i][j] != 1 || query(getIdx(i, j), 0))
                        continue;
                    dfs(i, j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 1 && !query(getIdx(i, j), 0)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    void dfs(int x, int y) {
        union(getIdx(x, y), 0);
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || g[nx][ny] != 1 || query(0, getIdx(nx, ny)))
                continue;
            dfs(nx, ny);
        }
    }

}
