import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution417 {
    int[][] h;
    int m;
    int n;

    public List<List<Integer>> pacificAtlantic(int[][] _heights) {
        h = _heights;
        m = h.length;
        n = h[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] a = new boolean[m][n];
        boolean[][] b = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(a, i, 0);
            dfs(b, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(a, 0, i);
            dfs(b, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] && b[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    public void dfs(boolean[][] v, int a, int b) {
        if (v[a][b])
            return;
        v[a][b] = true;
        int cur = h[a][b];
        if (a > 0 && h[a - 1][b] >= cur)
            dfs(v, a - 1, b);
        if (a < m - 1 && h[a + 1][b] >= cur)
            dfs(v, a + 1, b);
        if (b > 0 && h[a][b - 1] >= cur)
            dfs(v, a, b - 1);
        if (b < n - 1 && h[a][b + 1] >= cur)
            dfs(v, a, b + 1);
    }
}