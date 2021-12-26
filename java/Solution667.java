class Solution667 {
    int[][] tr = new int[2510][26];
    int[] hash = new int[2510];
    int idx;
    public void insert(String key, int val) {
        int p = 0;
        for (int i = 0; i < key.length(); i++) {
            int u = key.charAt(i) - 'a';
            if (tr[p][u] == 0) tr[p][u] = ++idx;
            p = tr[p][u];
        }
        hash[p] = val;
    }
    public int sum(String prefix) {
        int p = 0;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (tr[p][u] == 0) return 0;
            p = tr[p][u];
        }
        return dfs(p);
    }
    int dfs(int p) {
        int ans = hash[p];
        for (int u = 0; u < 26; u++) {
            if (tr[p][u] != 0) ans += dfs(tr[p][u]);
        }
        return ans;
    }
}
//还有很多优化版本详见