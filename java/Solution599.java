class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int n = list1.length;
        int m = list2.length;

        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            map.put(list1[i], i);
        int min = 3000;
        for (int i = 0; i < m; i++) {
            String str = list2[i];
            if (!map.containsKey(str))
                continue;
            int cur = map.get(str) + i;
            if (cur < min) {
                min = cur;
                ans.clear();
                ans.add(str);
            } else if (cur == min) {
                ans.add(str);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}