public class Solution682 {
    static int[] res = new int[1010];

    public int calPoints(String[] ops) {
        int idx = 0;
        for (int i = 0; i < ops.length; i++) {
            String s = ops[i];
            if (s.equals("+")) {
                res[idx] = res[idx - 1] + res[idx - 2];

            } else if (s.equals("D")) {
                res[idx] = res[idx - 1] * 2;
            } else if (s.equals("C")) {
                idx -= 2;
            } else {
                res[idx] = Integer.parseInt(s);
            }
            idx++;
        }

        int ans = 0;
        for (int i = 0; i < idx; i++) {
            ans += res[i];
        }
        return ans;
    }
}
