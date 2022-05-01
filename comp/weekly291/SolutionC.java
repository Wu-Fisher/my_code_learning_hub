package comp.weekly291;

import java.util.HashSet;
import java.util.Set;

public class SolutionC {
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        int ans = 0;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + ((nums[i - 1] % p == 0) ? 1 : 0);
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (sum[j + 1] - sum[i] <= k) {
                    String ss = serialize(nums, i, j);
                    if (!set.contains(ss)) {
                        set.add(ss);
                        ans++;
                    }
                } else {
                    break;
                }
            }
        }

        return ans;

    }

    public String serialize(int[] nums, int i, int j) {
        if (i > j)
            return ",";
        StringBuilder sb = new StringBuilder();
        while (i <= j) {
            sb.append(nums[i++]);
            sb.append(",");
        }

        return sb.toString();
    }
}
