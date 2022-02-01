public class Solution1342 {
    public int numberOfSteps(int num) {
        int len = 1;
        for (int i = 31; i >= 0; i--) {
            if (((num >> i) & 1) == 1) {
                len = i + 1;
                break;
            }
        }
        int cnt = 0;
        for (int i = 0; i < 31; i++) {
            if (((num >> i) & 1) == 1)
                cnt++;
        }

        return cnt + len - 1;
    }
}
