package comp.weekly293;

import java.util.Arrays;

public class SolutionB {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int ans = special[0] - bottom;
        int n = special.length;

        for (int i = 1; i < n; i++) {
            int cur = special[i] - special[i - 1] - 1;
            if (cur > ans) {
                ans = cur;

            }
        }
        ans = Math.max(ans, top - special[n - 1]);
        return ans;

    }
}
