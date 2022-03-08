public class Solution504 {
    public String convertToBase7(int n) {
        boolean f = n < 0;
        if (f)
            n = -n;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(n % 7);
            n /= 7;
        } while (n != 0);
        sb.reverse();
        return f ? "-" + sb.toString() : sb.toString();
    }
}
