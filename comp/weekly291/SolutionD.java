package comp.weekly291;

import java.util.Arrays;

public class SolutionD {
    public long appealSum(String s) {
        long ans = 0;
        long sumlast = 0;
        int[] t = new int[26];
        Arrays.fill(t, -1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            sumlast += i - t[c];
            ans += sumlast;
            t[c] = i;
        }
        return ans;
    }
}
