class Solution2016 {
    public int maximumDifference(int[] nums) {
        int n = nums.length, ans = -1;
        for (int i = 0, min = nums[0]; i < n; i++) {
            if (nums[i] > min)
                ans = Math.max(ans, nums[i] - min);
            min = Math.min(min, nums[i]);
        }
        return ans;
    }
}