import java.util.Random;

public class Solution497 {
    int[] f;
    int[][] s;
    Random random = new Random(20220609);

    public Solution497(int[][] rects) {
        f = new int[rects.length + 1];
        s = rects;
        int idx = 1;
        for (int[] r : rects) {
            f[idx] = f[idx - 1] + (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
            idx++;
        }
    }

    public int[] pick() {
        int a = random.nextInt(f[s.length]) + 1;
        int idx = 0;
        while (idx < s.length) {
            if (a <= f[idx + 1]) {
                break;
            } else {
                idx++;
            }
        }
        int sx = s[idx][2] - s[idx][0] + 1;
        int sy = s[idx][3] - s[idx][1] + 1;

        return new int[] { s[idx][0] + random.nextInt(sx), s[idx][1] + random.nextInt(sy) };
    }
}
