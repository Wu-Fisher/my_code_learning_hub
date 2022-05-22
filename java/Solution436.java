import java.util.TreeMap;

public class Solution436 {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;

        int[] ans = new int[n];
        TreeMap<Integer, Integer> t = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            t.put(intervals[i][0], i);
        }
        for (int i = 0; i < n; i++) {
            var c = t.ceilingEntry(intervals[i][1]);
            if (c == null) {
                ans[i] = -1;
            } else {
                ans[i] = c.getValue();
            }

        }
        return ans;
    }

}
