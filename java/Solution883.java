public class Solution883 {
    public int projectionArea(int[][] grid) {
        int a = 0, b = 0, c = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int zy = 0;
            int zx = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0)
                    a++;
                zy = Math.max(zy, grid[i][j]);
                zx = Math.max(zx, grid[j][i]);
            }
            b += zy;
            c += zx;
        }

        return a + b + c;
    }
}
