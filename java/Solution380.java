import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution380 {

}

class RandomizedSet {
    static int[] nums = new int[200010];
    Random random = new Random();
    Map<Integer, Integer> map = new HashMap<>();
    int idx = -1;

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        nums[++idx] = val;
        map.put(val, idx);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int loc = map.remove(val);
        if (loc != idx)
            map.put(nums[idx], loc);
        nums[loc] = nums[idx--];
        return true;
    }

    public int getRandom() {
        return nums[random.nextInt(idx + 1)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
