import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1765 {
    public int[][] highestPeak(int[][] g) {
        int m = g.length, n = g[0].length;
        int[][] ans = new int[m][n];
        Deque<int[]> d = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 1)
                    d.addLast(new int[] { i, j });
                ans[i][j] = g[i][j] == 1 ? 0 : -1;

            }
        }
        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int h = 1;

        while (!d.isEmpty()) {
            int k = d.size();
            while (k-- > 0) {
                int[] poll = d.pollFirst();
                int x = poll[0], y = poll[1];
                for (int[] dr : dirs) {
                    int nx = x + dr[0];
                    int ny = y + dr[1];
                    if (nx < 0 || ny < 0 || nx > m - 1 || ny > n - 1)
                        continue;
                    if (ans[nx][ny] != -1)
                        continue;
                    ans[nx][ny] = h;
                    d.addLast(new int[] { nx, ny });
                }
            }
            h++;
        }

        return ans;

    }
}
