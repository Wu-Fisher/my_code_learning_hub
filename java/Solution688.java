class Solution688 {
    int[][] dirs = new int[][] { { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { -2, -1 }, { -2, 1 }, { 2, -1 },
            { 2, 1 } };

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] f = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j][0] = 1;
            }
        }
        for (int p = 1; p <= k; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] d : dirs) {
                        int nx = i + d[0];
                        int ny = j + d[1];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                            continue;
                        f[i][j][p] += f[nx][ny][p - 1] * 0.125;
                    }
                }
            }

        }
        return f[row][column][k];

    }
}