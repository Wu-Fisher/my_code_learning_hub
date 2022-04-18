import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String b : banned)
            set.add(b);
        char[] cs = paragraph.toCharArray();
        String ans = null;
        int n = cs.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n;) {
            if (!Character.isLetter(cs[i]) && ++i >= 0) {
                continue;
            }
            int j = i;
            while (j < n && Character.isLetter(cs[j]))
                j++;
            String s = paragraph.substring(i, j).toLowerCase();

            i = ++j;
            if (set.contains(s))
                continue;
            map.put(s, map.getOrDefault(s, 0) + 1);
            if (ans == null || map.get(s) > map.get(ans))
                ans = s;
        }
        return ans;
    }
}
