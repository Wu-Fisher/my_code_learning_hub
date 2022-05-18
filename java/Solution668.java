public class Solution668 {
    int m;
    int n;
    int k;

    public int findKthNumber(int _m, int _n, int _k) {
        m = Math.max(_m, _n);
        n = Math.min(_m, _n);
        k = _k;
        int l = 1, r = m * n;
        while (l < r) {
            int mid = (l + r) / 2;
            if (getCnt(mid) < k)
                l = mid + 1;
            else
                r = mid;
        }
        return r;

    }

    int getCnt(int x) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (x > i * m) {
                cnt += m;
            } else {
                cnt += x / i;
            }
        }

        return cnt;
    }

}
