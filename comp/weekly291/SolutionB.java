package comp.weekly291;

import java.util.HashMap;
import java.util.Map;

public class SolutionB {
    public int minimumCardPickup(int[] cards) {
        int ans = (int) 1e6;
        Map<Integer, Integer> map = new HashMap<>();
        int n = cards.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(cards[i])) {
                int old = map.get(cards[i]);
                ans = Math.min(ans, i - old + 1);
            }
            map.put(cards[i], i);
        }
        return ans == (int) 1e6 ? -1 : ans;

    }
}
