public class Solution2029 {
    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];

        for (int st : stones)
            cnt[st % 3]++;
        return ((cnt[0] & 1) == 0) ? !(cnt[1] == 0 || cnt[2] == 0) : (Math.abs(cnt[1] - cnt[2]) > 2);
    }
}
