//三维背包问题
public class Solution1995 {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int [][][]  f = new int[n+1][110][4];
        f[0][0][0]=1;
        for(int i = 1;i<=n;i++)
        {
            int cur = nums[i-1];
            for(int j=0;j<110;j++)
            {
                for(int k=0;k<4;k++)
                {
                    f[i][j][k]+=f[i-1][j][k];
                    if(j-cur>=0&&k>0)f[i][j][k]+=f[i-1][j-cur][k-1];
                }
            }
        }
        int ans = 0;
        for(int i=3;i<n;i++)
        {
            ans+=f[i][nums[i]][3];
        }
        return ans;
    }
}

// 维度优化

class Solution1995_v2 {
    public int countQuadruplets(int[] nums) {
        int n = nums.length, ans = 0;
        int[][] f = new int[110][4];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int t = nums[i - 1];
            ans += f[t][3];
            for (int j = 109; j >= 0; j--) {
                for (int k = 3; k >= 0; k--) {
                    if (j - t >= 0 && k - 1 >= 0) f[j][k] += f[j - t][k - 1];
                }
            }
        }
        return ans;
    }
}
