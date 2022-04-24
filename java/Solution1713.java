import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1713 {
    public int minOperations(int[] t, int[] arr) {
        int n = t.length;
        int m = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(t[i], i);

        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int x = arr[i];
            if (map.containsKey(x))
                list.add(map.get(x));
        }

        int len = list.size();

        int[] g = new int[len + 1];
        Arrays.fill(g, (int) 1e19);
        int max = 0;
        for (int i = 0; i < len; i++) {
            int cur = list.get(i);
            int l = 1, r = i + 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (g[mid] >= cur)
                    r = mid;
                else
                    l = mid + 1;

            }
            g[r] = cur;
            max = Math.max(max, r);
        }

        return n - max;
    }

}
