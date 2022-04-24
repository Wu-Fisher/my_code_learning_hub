class Solution1716 {

    public int totalMoney(int n) {
        int a = n / 7, b = n % 7;
        int a1 = (1 + 7) * 7 / 2, an = (a + a + 6) * 7 / 2;
        int s1 = (a1 + an) * a / 2;
        a++;
        int s2 = (a + a + b - 1) * b / 2;
        return s1 + s2;
    }

    // public int totalMoney(int n) {
    // int ans = 0;
    // for (int i = 0; i < n / 7 + 1; i++) {
    // for (int j = 0; (i * 7 + j) < n && j < 7; j++) {
    // ans += (i + 1 + j);
    // }
    // }
    // return ans;
    // }
}