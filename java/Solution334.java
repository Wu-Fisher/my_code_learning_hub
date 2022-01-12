import java.util.Arrays;

public class Solution334 {
    // staic
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length, ans = 1;
        int[] f = new int[n + 1];
        Arrays.fill(f, 0x3f3f3f3f);
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            int l = 1, r = i + 1;
            while (l < r) {

                int mid = l + r >> 1;
                if (f[mid] >= t)
                    r = mid;
                else
                    l = mid + 1;

            }
            f[r] = t;
            ans = Math.max(ans, r);

        }
        return ans >= 3;
    }

    // optimize
    public boolean increasingTriplet2(int[] nums) {
        int n = nums.length;
        int[] f = new int[4];
        // 这个取值真的很重要
        f[0] = f[1] = f[2] = (int) 1e19;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            if (t > f[2])
                return true;
            else if (t > f[1])
                f[2] = t;
            else if (t < f[1])
                f[1] = t;
        }

        return false;
    }

}
