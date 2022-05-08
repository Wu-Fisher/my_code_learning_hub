package comp.weekly292;

public class SolutionA {
    public String largestGoodInteger(String num) {
        String ans = "";
        int n = num.length();
        int cur = -1;
        for (int i = 0; i < n - 3; i++) {
            if (num.charAt(i) != num.charAt(i + 1) || num.charAt(i) != num.charAt(i + 2)) {
                continue;
            }
            int current = Integer.parseInt(num.substring(i, i + 3));
            if (current > cur) {
                cur = current;
                ans = num.substring(i, i + 4);
            }

        }
        return ans;
    }
}