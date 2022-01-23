public class Solution1332 {
    public int removePalindromeSub(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return 2;
        }
        return 1;
    }
}
