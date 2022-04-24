import java.util.ArrayList;
import java.util.List;

public class Solution1447 {
    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int g = gcd(i, j);
                if (g == 1) {
                    ans.add(i + "/" + j);
                }
            }
        }
        return ans;
    }
}
