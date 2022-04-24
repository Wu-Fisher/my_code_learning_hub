import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution2034 {
    int cur;
    Map<Integer, Integer> map;
    TreeMap<Integer, Integer> tap;

    public Solution2034()
    // StockPrice
    {
        map = new HashMap<>();
        tap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        cur = Math.max(timestamp, cur);
        if (map.containsKey(timestamp)) {
            int old = map.get(timestamp);
            int cnt = tap.get(old);
            if (cnt == 1)
                tap.remove(old);
            else {
                tap.put(old, cnt - 1);
            }
        }
        map.put(timestamp, price);
        tap.put(price, tap.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return map.get(cur);
    }

    public int maximum() {
        return tap.lastKey();
    }

    public int minimum() {
        return tap.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */