class Solution {
    public int totalMoney(int n) {
        int ans = 0;
        for (int i = 0; i < n / 7 + 1; i++) {
            for (int j = 0; (i * 7 + j) < n && j < 7; j++) {
                ans += (i + 1 + j);
            }
        }
        return ans;
    }
}