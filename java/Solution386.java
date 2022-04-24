import java.util.List;
import java.util.ArrayList;

public class Solution386 {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++) {
            dfs(i, n);
        }
        return ans;
    }

    void dfs(int cur, int limit) {
        if (cur > limit) {
            return;
        }
        ans.add(cur);
        for (int i = 0; i < 10; i++) {
            dfs(cur * 10 + i, limit);
        }
    }
}
