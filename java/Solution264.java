public class Solution264 {
    public int nthUglyNumber(int n) {
        int[] ans = new int[n + 1];
        ans[1] = 1;
        for (int idx = 2, a2 = 1, a3 = 1, a5 = 1; idx <= n; idx++) {
            int a = ans[a2] * 2, b = ans[a3] * 3, c = ans[a5] * 5;
            int ad = Math.min(a, Math.min(b, c));
            ans[idx] = ad;
            if (ad == a)
                a2++;
            if (ad == b)
                a3++;
            if (ad == c)
                a5++;

        }
        return ans[n];
    }
}
