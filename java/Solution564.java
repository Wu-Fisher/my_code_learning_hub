import java.util.HashSet;
import java.util.Set;

class Solution564 {
    public String nearestPalindromic(String s) {
        int n = s.length();
        long cur = Long.parseLong(s);
        Set<Long> set = new HashSet<>();
        set.add((long) Math.pow(10, (n - 1)) - 1);
        set.add((long) Math.pow(10, n) + 1);
        long t = Long.parseLong(s.substring(0, (n + 1) / 2));
        for (long i = t - 1; i <= t + 1; i++) {
            long temp = getNum(i, n % 2 == 0);
            // 注意这里要求不包含自身
            if (temp != cur)
                set.add(temp);
        }
        long ans = -1;
        for (long i : set) {
            if (ans == -1)
                ans = i;
            else if (Math.abs(i - cur) < Math.abs(ans - cur))
                ans = i;
            else if (Math.abs(i - cur) == Math.abs(ans - cur) && i < ans)
                ans = i;

        }
        return String.valueOf(ans);
    }

    long getNum(long k, boolean isEven) {
        StringBuilder sb = new StringBuilder();
        sb.append(k);
        int n = sb.length();
        int idx = isEven ? n - 1 : n - 2;
        while (idx >= 0)
            sb.append(sb.charAt(idx--));
        return Long.parseLong(sb.toString());
    }

}