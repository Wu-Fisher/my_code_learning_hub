public class Solution747 {
    public int dominantIndex(int[] nums) {
        int max = 0;
        int nax = 0;
        int a = 0, b = 0;

        int n = nums.length;
        if (n == 1)
            return 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];

            if (cur > max) {
                b = a;
                nax = max;
                a = i;
                max = cur;
            } else if (cur <= max && cur > nax) {
                b = i;
                nax = cur;
            }
        }
        return max >= 2 * nax ? a : -1;
    }

}
