class Solution1706 {
    int m, n;

    public int[] findBall(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = my_get(i, grid);
        }
        return ans;
    }

    int my_get(int idx, int[][] g) {
        int r = 0;
        int c = idx;
        while (r < m) {
            int ne = c + g[r][c];
            if (ne < 0 || ne >= n) {
                return -1;
            }
            if (g[r][ne] != g[r][c]) {
                return -1;
            }
            r++;
            c = ne;
        }
        return c;

    }
}