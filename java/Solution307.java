public class Solution307 {
    class NumArray {
        int[] tree;

        int lowbit(int x) {
            return x & (-x);
        }

        int query(int x) {
            int ans = 0;
            for (int i = x; i > 0; i -= lowbit(i))
                ans += tree[i];
            return ans;

        }

        void add(int x, int u) {
            for (int i = x; i <= n; i += lowbit(i))
                tree[i] += u;
        }

        int[] nums;
        int n;

        public NumArray(int[] _nums) {
            nums = _nums;
            n = nums.length;
            tree = new int[n + 1];
            for (int i = 0; i < n; i++)
                add(i + 1, nums[i]);
        }

        public void update(int index, int val) {
            add(index + 1, val - nums[index]);
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            return query(right + 1) - query(left);

        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * obj.update(index,val);
     * int param_2 = obj.sumRange(left,right);
     */
}
