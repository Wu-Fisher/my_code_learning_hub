import java.util.HashMap;
import java.util.Map;

public class Solution2227 {

}

class Encrypter {
    String[] map = new String[26];
    Map<String, Integer> cnt = new HashMap<>();

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        for (int i = 0; i < keys.length; i++) {
            map[keys[i] - 'a'] = values[i];
        }
        for (String s : dictionary) {
            String ss = encrypt(s);
            cnt.put(ss, cnt.getOrDefault(ss, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            String s = map[word1.charAt(i) - 'a'];
            if (s == null) {
                return "";
            }
            sb.append(s);
        }
        return sb.toString();
    }

    public int decrypt(String word2) {
        return cnt.getOrDefault(word2, 0);
    }
}
