class Solution2047 {
    public int countValidWords(String sentence) {
        String[] ss = sentence.split(" ");
        int ans = 0;

        for (String str : ss) {
            if (check(str))
                ans++;
        }
        return ans;

    }

    boolean check(String str) {

        int n = str.length();
        char[] cs = str.toCharArray();
        if (n == 0)
            return false;
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(cs[i]))
                return false;
            else if (cs[i] == ' ')
                return false;
            else if (cs[i] == '-' && ++c >= 0) {
                if (i == 0 || i == n - 1 || c > 1)
                    return false;
                else if (!Character.isLetter(cs[i - 1]) || !Character.isLetter(cs[i + 1]))
                    return false;
            } else if (cs[i] == '!' || cs[i] == '.' || cs[i] == ',') {
                if (i != n - 1)
                    return false;
            } else if (!Character.isLetter(cs[i]))
                return false;

        }
        return true;
    }
}