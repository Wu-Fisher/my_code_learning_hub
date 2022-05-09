public class Solution942 {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int l = 0;
        int r = n;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                ans[i] = l++;
            } else {
                ans[i] = r--;
            }

        }
        ans[n] = l;
        return ans;

    }
}
