class Solution1748 {
    public int sumOfUnique(int[] nums) {
        int[] cnt = new int[110];
        for (int num : nums) {
            cnt[num]++;
        }
        int sum = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }
}