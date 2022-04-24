class Solution2006 {
    public int countKDifference(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[110];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            if (cur - k >= 0)
                ans += cnt[cur - k];
            if (cur + k < 110)
                ans += cnt[cur + k];
            cnt[cur]++;
        }
        return ans;
    }
}