public class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (letters[mid] > target)
                r = mid;
            else
                l = mid + 1;

        }
        return letters[r] > target ? letters[r] : letters[0];
    }
}
