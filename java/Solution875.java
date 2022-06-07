public class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 0;
        int r = (int) 1e9;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(piles, h, mid))
                r = mid;
            else
                l = mid + 1;
        }
        return r;
    }

    boolean check(int[] p, int h, int k) {
        int sum = 0;
        for (int pp : p) {
            sum += Math.ceil(pp * 1.0 / k);
        }
        return sum <= h;
    }
}
