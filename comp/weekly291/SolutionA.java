package comp.weekly291;

public class SolutionA {
    public String removeDigit(String number, char digit) {
        int n = number.length();
        int cur = n - 1;
        for (int i = 0; i < n; i++) {
            char c = number.charAt(i);
            if (c != digit) {
                continue;
            }
            if (i < n - 1 && c - number.charAt(i + 1) < 0) {
                return number.substring(0, i) + number.substring(i + 1, n);
            } else {
                cur = i;

            }
        }
        return number.substring(0, cur) + number.substring(cur + 1, n);

    }
}
