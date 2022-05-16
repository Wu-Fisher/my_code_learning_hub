public class Solution812 {
    public double largestTriangleArea(int[][] p) {
        int n = p.length;
        double ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int a = p[j][0] - p[i][0];
                    int b = p[j][1] - p[i][1];
                    int c = p[k][0] - p[i][0];
                    int d = p[k][1] - p[i][1];

                    double cur = cross(a, b, c, d);
                    ans = Math.max(ans, cur / 2.0);
                }
            }
        }
        return ans;
    }

    double cross(int a, int b, int c, int d) {
        return Math.abs(a * d - c * b);
    }
}
