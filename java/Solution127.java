import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution127 {
    String s, e;
    Set<String> set = new HashSet<>();

    public int ladderLength(String beginWord, String endWord, List<String> ws) {

        s = beginWord;
        e = endWord;
        for (String w : ws) {
            set.add(w);
        }
        if (!set.contains(e)) {
            return 0;
        }
        int ans = bfs();
        return ans == -1 ? 0 : ans + 2;
    }

    int bfs() {
        // d1 为正向
        // d2 为反向

        Deque<String> d1 = new ArrayDeque<>();
        Deque<String> d2 = new ArrayDeque<>();

        // m1 为正向记录
        // m2 为反向记录
        // map 里面储存了替换字符的次数，路径长度
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();

        d1.add(s);
        m1.put(s, 0);
        d2.add(e);
        m2.put(e, 0);
        while (!d1.isEmpty() && !d2.isEmpty()) {
            int t = -1;
            if (d1.size() > d2.size()) {
                t = update(d2, m2, m1);
            } else {
                t = update(d1, m1, m2);
            }
            if (t != -1) {
                return t;
            }

        }
        return -1;

    }

    int update(Deque<String> deque, Map<String, Integer> cur, Map<String, Integer> other) {
        int m = deque.size();
        while (m-- > 0) {
            String poll = deque.pollFirst();
            int n = poll.length();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 26; j++) {
                    String sub = poll.substring(0, i) + String.valueOf((char) ('a' + j)) + poll.substring(i + 1);
                    if (!set.contains(sub))
                        continue;
                    // 强调之前已经经历过这个点了
                    if (cur.containsKey(sub) && cur.get(sub) <= cur.get(poll) + 1) {
                        continue;
                    }
                    if (other.containsKey(sub)) {
                        return cur.get(poll) + other.get(sub);

                    }
                    deque.addLast(sub);
                    cur.put(sub, cur.get(poll) + 1);

                }

            }

        }
        return -1;
    }
}
