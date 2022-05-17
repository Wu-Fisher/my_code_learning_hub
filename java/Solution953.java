public class Solution953 {
    int[] os = new int[26];

    int check(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            int c1 = s1.charAt(i) - 'a';
            int c2 = s2.charAt(j) - 'a';
            if (c1 != c2)
                return os[c1] - os[c2];

            i++;
            j++;
        }
        if (i < n)
            return 1;
        if (j < m)
            return -1;
        return 0;
    }

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < 26; i++) {
            os[order.charAt(i) - 'a'] = i;
        }
        int n = words.length;
        for (int i = 0; i < n - 1; i++) {
            if (check(words[i], words[i + 1]) > 0)
                return false;
        }
        return true;

    }
}
