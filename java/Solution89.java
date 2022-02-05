import java.util.ArrayList;
import java.util.List;

class Solution89 {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            ans.add((i >> 1) ^ i);
        }
        return ans;
    }
}