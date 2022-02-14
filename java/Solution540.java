class Solution540 {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;

            if (mid % 2 == 0) {
                if (mid + 1 < n && nums[mid] == nums[mid + 1])
                    // 这里稳妥一点+1，但是可以优化成+2，因为越界理应不存在
                    l = mid + 2;
                else
                    r = mid;
            } else {
                if (mid - 1 > -1 && nums[mid] == nums[mid - 1])
                    l = mid + 1;
                else
                    r = mid;
            }

        }
        return nums[r];
    }
}