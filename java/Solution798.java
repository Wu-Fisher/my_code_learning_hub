import java.util.Arrays;

public class Solution798 {
    static int N = 100010;
    static int[] a = new int[N];

    void add(int c, int b) {
        a[c]++;
        a[b + 1]--;
    }

    public int bestRotation(int[] nums) {
        Arrays.fill(a, 0);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int c = (n - nums[i] + i) % n;
            int b = i + 1;
            if (b <= c) {
                add(b, c);
            } else {
                add(0, c);
                add(b, n - 1);
            }
        }

        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + a[i];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > a[ans]) {
                ans = i;
            }
        }
        return ans;
    }
}
