import java.util.ArrayDeque;
import java.util.Deque;

public class Solution933 {
    class RecentCounter {
        Deque<Integer> q = new ArrayDeque<>();

        public RecentCounter() {
            q.clear();
        }

        public int ping(int t) {
            while (!q.isEmpty() && q.peekFirst() < t - 3000) {
                q.pollFirst();
            }
            q.addLast(t);
            return q.size();
        }
    }

    /**
     * Your RecentCounter object will be instantiated and called as such:
     * RecentCounter obj = new RecentCounter();
     * int param_1 = obj.ping(t);
     */
}
