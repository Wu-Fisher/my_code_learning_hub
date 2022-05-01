public class Solution908 {
    public int smallestRangeI(int[] nums, int k) {
        int min = (int) 1e4;
        int max = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max)
                max = nums[i];
            if (nums[i] < min)
                min = nums[i];
        }
        return Math.max(max - min - 2 * k, 0);
    }
}
