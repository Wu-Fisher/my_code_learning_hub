public class Solution1220 {
    // int MOD = (int) 1e9 + 7;

    // public int countVowelPermutation(int n) {
    // long a = 1, e = 1, i = 1, o = 1, u = 1;
    // for (int j = 1; j < n; j++) {
    // long aa = (e + i + u) % MOD;
    // long ee = (a + i) % MOD;
    // long ii = (e + o) % MOD;
    // long oo = i;
    // long uu = (i + o) % MOD;
    // a = aa;
    // e = ee;
    // i = ii;
    // o = oo;
    // u = uu;
    // }
    // return (int) ((a + e + i + o + u) % MOD);
    // }

    // martix
    // 叶总的矩阵是转置的，不大好理解，还是放上自己写的吧
    int MOD = (int) 1e9 + 7;

    long[][] mul(long[][] a, long[][] b) {
        int m = a.length;
        int l = b.length;
        int n = b[0].length;
        long[][] cur = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < l; k++) {
                    cur[i][j] += a[i][k] * b[k][j];
                    cur[i][j] %= MOD;
                }
            }
        }
        return cur;
    }

    public int countVowelPermutation(int n) {
        long[][] ans = new long[][] {
                { 1 }, { 1 }, { 1 }, { 1 }, { 1 }
        };
        long[][] mat = new long[][] {
                { 0, 1, 1, 0, 1 },
                { 1, 0, 1, 0, 0 },
                { 0, 1, 0, 1, 0 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 1, 1, 0 }
        };
        n -= 1;
        while (n != 0) {
            if ((n & 1) == 1)
                ans = mul(mat, ans);
            mat = mul(mat, mat);
            n >>= 1;

        }
        long end = 0;
        for (int i = 0; i < 5; i++) {
            end += ans[i][0];
        }
        end %= MOD;
        return (int) end;

    }

}
