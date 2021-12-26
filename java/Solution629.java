class Solution629 {
    int mod = (int)1e9+7;
    public int kInversePairs(int n, int k) {
        int[][] f = new int[n + 1][k + 1];
        int[][] sum = new int[n + 1][k + 1];
        f[1][0] = 1;
        Arrays.fill(sum[1], 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                f[i][j] = j < i ? sum[i - 1][j] : (sum[i - 1][j] - sum[i - 1][j - (i - 1) - 1] + mod) % mod;
                sum[i][j] = j == 0 ? f[i][j] : (sum[i][j - 1] + f[i][j]) % mod;
            }
        }
        return f[n][k];
    }
}
//my wiret
class Solution {
    int mod=(int)(1e9+7);
    public int kInversePairs(int n, int k) {
            int[][] f= new int[n+1][k+1];
            int[][] sum = new int[n+1][k+1];
            // Arrays.fill(f[1],1);
            f[1][0]=1;
            Arrays.fill(sum[1],1);
            for(int i=2;i<=n;i++)
            {
                for(int j=0;j<=k;j++)
                {
                    f[i][j]=(j<i)?sum[i-1][j]:(sum[i-1][j]-sum[i-1][j-i]+mod)%mod;
                    sum[i][j]=(j==0)?f[i][0]:(sum[i][j-1]+f[i][j])%mod;
                }
            }
            return f[n][k];

    }
}
