package comp.weekly293;

public class SolutionC {
    public int largestCombination(int[] candidates) {
        int ans = 0;
        for (int i = 0; i < 25; i++) {
            int cnt = 0;
            for (int c : candidates) {
                if (((c >> i) & 1) == 1) {
                    cnt++;
                }

            }
            ans = Math.max(cnt, ans);
        }
        return ans;
    }

}
