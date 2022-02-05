class Solution1219 {
    int[][] g;
    boolean[][] vis;

    int m, n;
    int[][] dirs = new int[][] {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };

    public int getMaximumGold(int[][] grid) {
        g = grid;
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 0)
                    continue;
                vis[i][j] = true;
                int cur = dfs(i, j);
                ans = Math.max(ans, cur);
                vis[i][j] = false;
            }
        }
        return ans;
    }

    int dfs(int i, int j) {
        int ans = g[i][j];
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || vis[x][y] || g[x][y] == 0)
                continue;
            vis[x][y] = true;
            ans = Math.max(ans, g[i][j] + dfs(x, y));
            vis[x][y] = false;
        }
        return ans;
    }
}