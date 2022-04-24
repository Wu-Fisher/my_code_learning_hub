import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        long[] h = new long[n + 1];
        long[] p = new long[n + 1];
        p[0] = 1;
        int P = 13131;
        for (int i = 0; i < n; i++) {
            h[i + 1] = h[i] * P + s.charAt(i);
            p[i + 1] = p[i] * P;
        }
        List<String> ans = new ArrayList<>();
        Set<Long> set = new HashSet<>();

        for (int i = 1; i + 9 <= n; i++) {
            int j = i + 9;
            long cur = h[j] - h[i - 1] * p[10];
            if (set.contains(cur)) {
                String ss = s.substring(i - 1, j);
                if (!ans.contains(ss))
                    ans.add(ss);
            } else
                set.add(cur);
        }
        return ans;
    }
}