package comp.weekly293;

import java.util.TreeMap;

public class SolutionD {
    class CountIntervals {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        int cnt = 0;

        public CountIntervals() {

        }

        public void add(int left, int right) {
            for (var e = m.ceilingEntry(left); e != null && e.getValue() <= right; e = m.ceilingEntry(left)) {
                int l = e.getValue();
                int r = e.getKey();
                left = Math.min(left, l);
                right = Math.max(right, r);
                m.remove(r);
                cnt -= r - l + 1;

            }
            cnt += right - left + 1;
            m.put(right, left);
        }

        public int count() {
            return cnt;
        }
    }
}
