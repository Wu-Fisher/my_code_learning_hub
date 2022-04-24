class Solution2024 {
    int k, n;
    String s;

    public int maxConsecutiveAnswers(String answerKey, int _k) {
        s = answerKey;
        k = _k;
        n = s.length();
        return Math.max(getCnt('T'), getCnt('F'));
    }

    int getCnt(char c) {
        int ans = 0;
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                cnt++;
            }
            while (cnt > k) {
                if (s.charAt(j++) == c)
                    cnt--;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

}