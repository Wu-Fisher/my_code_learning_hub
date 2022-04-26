import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Solution398 {
    Random random = new Random();
    Map<Integer, List<Integer>> map = new HashMap<>();

    public Solution(int[] nums) {
        int n= nums.length;
        for(int i=0;i<n;i++)
        {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int n = list.size();
        return list.get(random.nextInt(n));
    }
}
