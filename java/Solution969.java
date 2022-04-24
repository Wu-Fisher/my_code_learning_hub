import java.util.ArrayList;
import java.util.List;

class Solution969 {
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        int[] idx = new int[n + 10];
        for (int i = 0; i < n; i++)
            idx[arr[i]] = i;
        List<Integer> ans = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
            int id = idx[i];
            if (id == i - 1)
                continue;
            if (id != 0) {
                ans.add(id + 1);
                reverse(arr, idx, 0, id);
            }
            ans.add(i);
            reverse(arr, idx, 0, i - 1);
        }
        return ans;
    }

    public void reverse(int[] arr, int[] idx, int i, int j) {
        while (i < j) {
            idx[arr[i]] = j;
            idx[arr[j]] = i;
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}