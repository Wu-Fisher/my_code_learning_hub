import java.util.HashMap;
import java.util.Map;

class Solution2044 {
    public int countMaxOrSubsets(int[] nums) {
        int max, ans;
        max = ans = 0;

        int n = nums.length;
        int temp = (1 << n);
        for (int i = 0; i < temp; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    cur |= nums[j];
                }
            }
            if (cur > max) {
                ans = 1;
                max = cur;
            } else if (cur == max) {
                ans++;
            }
        }
        return ans;
    }

    // dp
    static Map<Integer, Integer> map = new HashMap<>();
    static {
        for (int i = 0; i < 20; i++) {
            map.put((1 << i), i);
        }
    }

    public int countMaxOrSubsets_dp(int[] nums) {
        int n = nums.length;
        int mask = 1 << n;
        int[] f = new int[mask];
        int max = 0, ans = 0;
        for (int s = 1; s < mask; s++) {
            int lowbit = (s & -s);
            int prev = s - lowbit;
            int idx = map.get(lowbit);
            f[s] = f[prev] | nums[idx];
            if (f[s] > max) {
                max = f[s];
                ans = 1;
            } else if (f[s] == max) {
                ans++;
            }
        }
        return ans;
    }
}