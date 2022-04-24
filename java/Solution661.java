class Solution661 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] sum = new int[m + 10][n + 10];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + img[i - 1][j - 1];
            }
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int a = Math.max(0, i - 1);
                int b = Math.max(0, j - 1);
                int c = Math.min(m - 1, i + 1);
                int d = Math.min(n - 1, j + 1);
                int cnt = (c - a + 1) * (d - b + 1);
                ans[i][j] = (sum[c + 1][d + 1] - sum[a][d + 1] - sum[c + 1][b] + sum[a][b]) / cnt;
            }
        }
        return ans;
    }
}