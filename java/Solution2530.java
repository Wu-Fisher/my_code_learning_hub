public class Solution2530 {
    public boolean oneEditAway(String a, String b) {
        int n = a.length();
        int m = b.length();
        if (Math.abs(n - m) >= 2)
            return false;
        if (n > m)
            return oneEditAway(b, a);
        int cnt = 0;
        int i = 0, j = 0;
        while (i < n && j < m && cnt < 2) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                cnt++;
                i++;
            }

        }
        return cnt <= 1;
    }

}
