import java.util.Random;

class Solution384 {
    int[] nnn;
    int n;
    Random random = new Random();

    public Solution384(int[] nums) {
        nnn = nums;
        n = nums.length;
    }

    public int[] reset() {
        return nnn;
    }

    public int[] shuffle() {
        int[] ans = nnn.clone();
        for (int i = 0; i < n; i++) {
            int c = ans[i];
            int j = i + random.nextInt(n - i);
            ans[i] = ans[j];
            ans[j] = c;
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */