public class Solution905 {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;

        int i = 0;
        int j = n - 1;
        while (i < j) {
            while (nums[i] % 2 == 0 && i < j) {
                i++;
            }
            while (j > i && nums[j] % 2 == 1) {
                j--;
            }
            swap(i, j, nums);
        }
        return nums;

    }

    public void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
