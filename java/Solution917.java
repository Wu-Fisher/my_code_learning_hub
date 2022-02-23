class Solution917 {
    public String reverseOnlyLetters(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int i = 0, j = n - 1;
        while (i < j) {
            while (!Character.isLetter(cs[i]) && i < j)
                i++;
            while (!Character.isLetter(cs[j]) && i < j)
                j--;
            if (i < j) {
                char c = cs[i];
                cs[i] = cs[j];
                cs[j] = c;
                i++;
                j--;
            }
        }
        return String.valueOf(cs);
    }
}