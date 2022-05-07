import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution433 {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        Set<String> v = new HashSet<>();
        if (!set.contains(end))
            return -1;
        if (start.compareTo(end) == 0)
            return 0;
        Deque<String> q = new ArrayDeque<>();
        q.add(start);

        if (set.contains(start))
            set.remove(start);

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                for (String next : set) {
                    if (!v.contains(next) && isValid(cur, next)) {
                        if (next.compareTo(end) == 0)
                            return step + 1;
                        q.addLast(next);
                        v.add(next);

                    } else {
                        continue;
                    }
                }

            }
            step++;
        }
        return -1;
    }

    boolean isValid(String cur, String next) {
        int diff = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != next.charAt(i))
                diff++;
        }
        return diff == 1;

    }
}
