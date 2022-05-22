public class Solution464 {
    int n = 0;
    int t = 0;
    int[] f = new int[1 << 20];

    public int dfs(int state, int cur) {
        if (f[state] != 0)
            return f[state];
        for (int i = 0; i < n; i++) {
            if (((state >> i) & 1) == 1)
                continue;
            int nstate = state | (1 << i);
            if (cur + i + 1 >= t)
                return f[state] = 1;
            if (dfs(nstate, cur + i + 1) == -1)
                return f[state] = 1;

        }
        return f[state] = -1;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        n = maxChoosableInteger;
        t = desiredTotal;
        if (n * (n + 1) / 2 < t)
            return false;
        if (t == 0)
            return true;

        return dfs(0, 0) == 1;
    }

}
