import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution1345 {
    int INF = 0x3f3f3f3f;

    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = n - 1; i > -1; i--) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<Integer>());
            list.add(i);
            map.put(arr[i], list);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        Deque<Integer> q = new ArrayDeque<>();
        dist[0] = 0;
        q.add(0);
        while (!q.isEmpty()) {
            int t = q.poll();
            int step = dist[t];
            if (t == n - 1)
                return step;

            if (t > 0 && dist[t - 1] == INF) {
                dist[t - 1] = step + 1;
                q.add(t - 1);
            }

            if (t < n - 1 && dist[t + 1] == INF) {
                dist[t + 1] = step + 1;
                q.add(t + 1);
            }

            List<Integer> list = map.getOrDefault(arr[t], new ArrayList<>());

            for (int cur : list) {
                if (cur != t) {
                    if (dist[cur] == INF) {
                        q.add(cur);
                        dist[cur] = step + 1;
                    }
                }
            }

            map.remove(arr[t]);

        }

        return -1;
    }
}