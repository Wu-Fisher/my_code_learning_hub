class Solution1380 {
    int N = 51;

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rows = new int[N];
        int[] cols = new int[N];
        Arrays.fill(rows, 100001);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] = Math.min(rows[i], matrix[i][j]);
                cols[j] = Math.max(cols[j], matrix[i][j]);
            }

        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int a = rows[i];
                int b = cols[j];
                if (a == b)
                    ans.add(a);

            }

        }
        return ans;
    }
}