import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution1001 {
    int[][] dirs = new int[][] {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 },
            { 0, 0 },
            { 1, 1 },
            { 1, -1 },
            { -1, 1 },
            { -1, -1 }
    };

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        long N = n;
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        Set<Long> set = new HashSet<>();
        for (int[] lamp : lamps) {
            int x = lamp[0];
            int y = lamp[1];
            if (set.contains(x * N + y))
                continue;

            set.add(x * N + y);
            increment(row, x);
            increment(col, y);
            increment(left, x + y);
            increment(right, x - y);

        }

        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int[] q = queries[i];
            int x = q[0];
            int y = q[1];
            int a = x + y;
            int b = x - y;
            if (row.containsKey(x) || col.containsKey(y) || left.containsKey(a) || right.containsKey(b)) {
                ans[i] = 1;
            }
            for (int[] dir : dirs) {
                int xx = x + dir[0];
                int yy = y + dir[1];
                if (xx < 0 || xx >= N || yy < 0 || yy >= N) {
                    continue;
                }
                long key = xx * N + yy;
                if (set.contains(key)) {
                    set.remove(key);
                    decrement(row, xx);
                    decrement(col, yy);
                    decrement(left, xx + yy);
                    decrement(right, xx - yy);
                }

            }
        }
        return ans;
    }

    void increment(Map<Integer, Integer> map, int key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    void decrement(Map<Integer, Integer> map, int key) {
        if (map.get(key) == 1) {
            map.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
        }
    }

}