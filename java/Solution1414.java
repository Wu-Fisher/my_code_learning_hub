public class Solution1414 {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        int a = 1;
        int b = 1;
        while (a + b <= k) {
            int c = a + b;
            list.add(c);
            a = b;
            b = c;

        }
        int ans = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int cur = list.get(i);
            if (cur <= k) {
                k -= cur;
                ans++;
            }
        }
        return ans;
    }
}
