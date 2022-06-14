public class Solution498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] ans = new int[m * n];
        int idx = 0;
        for (int k = 0; k < m + n - 1; k++) {
            if (k % 2 != 0) {
                for (int i = Math.max(0, k - n + 1); i <= Math.min(m - 1, k); i++) {
                    ans[idx++] = mat[i][k - i];
                }
            } else {
                for (int j = Math.max(0, k - m + 1); j <= Math.min(n - 1, k); j++) {
                    ans[idx++] = mat[k - j][j];
                }
            }
        }
        return ans;
    }
}
