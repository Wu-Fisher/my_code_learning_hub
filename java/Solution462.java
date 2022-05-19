import java.util.Arrays;

public class Solution462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int ans = 0;
        while (l < r) {
            ans += nums[r] - nums[l];
            r--;
            l++;
        }
        return ans;
    }

}
