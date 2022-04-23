public class Solution396 {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n * 2 + 10];
        for (int i = 1; i <= 2 * n; i++) {
            sum[i] = sum[i - 1] + nums[(i - 1) % n];
        }
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += i * nums[i];
        }
        for (int i = n + 1, cur = ans; i < 2 * n; i++) {
            cur += (n - 1) * nums[(i - 1) % n];
            cur -= sum[i - 1] - sum[i - n];
            if (cur > ans)
                ans = cur;
        }
        return ans;
    }
}
