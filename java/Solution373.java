import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution373 {
    boolean t = true;

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;
        int m = nums2.length;
        if (n > m) {
            t = false;
            return kSmallestPairs(nums2, nums1, k);
        }
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - (nums1[b[0]] + nums2[b[1]]));
        // 如果k小于n，那么对于有序对（i，j）来说i一定小于k，不会存在比k大的i，这里可以优化一下空间
        for (int i = 0; i < Math.min(k, n); i++) {
            q.add(new int[] { i, 0 });
        }
        while (ans.size() < k && !q.isEmpty()) {
            int[] cur = q.poll();
            int a = cur[0], b = cur[1];
            ans.add(new ArrayList<>() {
                {
                    add(t ? nums1[a] : nums2[b]);
                    add(t ? nums2[b] : nums1[a]);
                }

            });
            if (b + 1 < m)
                q.add(new int[] { a, b + 1 });
        }
        return ans;

    }
}