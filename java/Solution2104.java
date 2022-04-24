import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2104 {
    // public long subArrayRanges_First(int[] nums) {
    // int n = nums.length;
    // long ans = 0;
    // for (int i = 0; i < n - 1; i++) {
    // int min = nums[i];
    // int max = nums[i];
    // for (int j = i + 1; j < n; j++) {
    // min = Math.min(min, nums[j]);
    // max = Math.max(max, nums[j]);
    // ans += max - min;
    // }

    // }
    // return ans;
    // }
    int n;

    public long subArrayRanges(int[] nums) {
        n = nums.length;
        long[] min = getCnt(nums, true);
        long[] max = getCnt(nums, false);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (max[i] - min[i]) * nums[i];
        }
        return ans;
    }

    // isMin 为true则寻找每个点作为多少个范围的最小值
    long[] getCnt(int[] nums, boolean isMin) {
        int[] a = new int[n];
        int[] b = new int[n];
        Deque<Integer> d = new ArrayDeque<>();

        // a保存i左边坐标
        for (int i = 0; i < n; i++) {
            while (!d.isEmpty() && (isMin ? nums[d.peekLast()] >= nums[i] : nums[d.peekLast()] <= nums[i]))
                d.pollLast();

            a[i] = d.isEmpty() ? -1 : d.peekLast();
            d.addLast(i);

        }
        d.clear();
        // 注意这里就用的是大于号而不是大于等于
        // 就是之前提到的避免重复
        // 比如说在一个范围内，如果不这样处理，可能两个相同的2都会作为一次最小值出现，但是该范围（子数组）显然只使用了其中的一个2作为一个最小值来计算
        // 例子[1,2,2,1]，这里的两个2都会被算作在一个整个数组范围里面的最大值的一个次数显然是算多了，所以我们通过左开右闭来避免这种重复，并且保证重复的数字的区间范围只会被纳入一次

        for (int i = n - 1; i >= 0; i--) {
            while (!d.isEmpty() && (isMin ? nums[d.peekLast()] > nums[i] : nums[d.peekLast()] < nums[i]))
                d.pollLast();
            b[i] = d.isEmpty() ? n : d.peekLast();
            d.addLast(i);

        }
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (i - a[i]) * (b[i] - i) * 1L;
        }
        return ans;
    }

}
