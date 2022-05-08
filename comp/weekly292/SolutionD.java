package comp.weekly292;

public class SolutionD {
    char[][] g;
    int m, n;
    boolean[][][] vis;

    public boolean hasValidPath(char[][] grid) {
        g = grid;
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n][m + n];
        if ((n + m) % 2 == 0 || grid[0][0] != '(' || grid[m - 1][n - 1] != ')')
            return false;
        return dfs(0, 0, 0);

    }

    boolean dfs(int x, int y, int c) {

        // 这个剪枝防止了！！等价！！路径的重复判断
        // 即到这个位置的前置左括号相同，相当于等价路径，结果是相同的
        if (vis[x][y][c])
            return false;
        vis[x][y][c] = true;
        if (x == m - 1 && y == n - 1)
            return c == 1;
        if ((c - (m - x) - (n - y) + 1) > 0)
            return false;
        if (g[x][y] == '(') {
            c++;
        } else {
            c--;
        }

        return c >= 0 && ((x < m - 1 && dfs(x + 1, y, c)) || (y < n - 1 && dfs(x, y + 1, c)));

    }
}