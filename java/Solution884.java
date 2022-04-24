import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        String[] ss1 = s1.split(" ");
        for (String str : ss1) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        String[] ss2 = s2.split(" ");
        for (String str : ss2) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (String str : map.keySet()) {
            if (map.get(str) == 1)
                list.add(str);
        }
        return list.toArray(new String[list.size()]);
    }
}
