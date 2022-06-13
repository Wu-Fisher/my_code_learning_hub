import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        int[] pMap = new int[26];
        int[] wMap = new int[26];
        int n = pattern.length();
        for (String word : words) {
            Arrays.fill(pMap, -1);
            Arrays.fill(wMap, -1);
            char[] cs = word.toCharArray();
            char[] ps = pattern.toCharArray();
            boolean isMatch = true;
            for (int i = 0; i < n; i++) {
                if (pMap[ps[i] - 'a'] == -1 && wMap[cs[i] - 'a'] == -1) {
                    pMap[ps[i] - 'a'] = cs[i] - 'a';
                    wMap[cs[i] - 'a'] = ps[i] - 'a';
                } else if (pMap[ps[i] - 'a'] != cs[i] - 'a' || wMap[cs[i] - 'a'] != ps[i] - 'a') {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                result.add(word);
            }
        }
        return result;
    }
}
