import java.util.ArrayList;
import java.util.List;

public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int cur : nums) {
            int x = Math.abs(cur);
            if (nums[x - 1] < 0)
                ans.add(x);
            else
                nums[x - 1] *= -1;
        }
        return ans;
    }

    public List<Integer> findDuplicates_B(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                ans.add(nums[i]);
        }
        return ans;
    }
}
