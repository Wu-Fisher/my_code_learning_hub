class Solution1994 {
    int MOD = (int) 1e9 + 7;
    int[] p = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
    int[] cnts = new int[35];

    public int numberOfGoodSubsets(int[] nums) {
        int n = nums.length;
        for (int i : nums) {
            cnts[i]++;

        }
        int mask = 1 << 10;
        // dp数组保存状态并更新
        long[] f = new long[mask];
        // 动态规划的初始条件这个不会拿去用，但是会是一个基础条件，便于单个数的子集更新条件
        f[0] = 1;
        for (int i = 2; i <= 30; i++) {
            if (cnts[i] == 0)
                continue;
            int cur = 0;
            int x = i;

            boolean ok = true;
            for (int j = 0; i < 10; j++) {
                int t = p[j];
                int c = 0;
                // 加入该数的构成状态state，以及会不会被同一个质数多次相除
                while (x % t == 0) {
                    cur |= (1 << j);
                    x /= t;
                    c++;
                }
                // 这个数如果能够被同一个数除多次，则不行。
                if (c > 1) {
                    ok = false;
                    break;
                }
            }
            if (!ok)
                continue;

            // 这里递增递减都可以其实，不会影响到上一次转移的状态
            // 找到可以相容的新数t也就是状态state的prev状态，然后更新两者相容状态
            // 这里利用了数频（题目对于下标不同可以看作不同的数字）
            for (int prev = mask - 1; prev >= 0; prev--) {
                if ((prev & cur) != 0)
                    continue;
                f[prev | cur] = (f[prev | cur] + f[prev] * cnts[i]) % MOD;
            }

        }
        long ans = 0;
        // 遍历每一个状态的方案数目，加和
        for (int i = 1; i < mask; i++)
            ans = (ans + f[i]) % MOD;
        // 对1特殊处理
        for (int i = 0; i < cnts[1]; i++)
            ans = ans * 2 % MOD;
        return (int) ans;
    }
}