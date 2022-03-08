public class Solution537 {
    public String complexNumberMultiply(String num1, String num2) {

        // \ 开始表达正则表达式
        // +有特殊含义所以用\+
        // 然后匹配i
        String[] ss1 = num1.split("\\+|i");
        String[] ss2 = num2.split("\\+|i");
        int a = Integer.parseInt(ss1[0]);
        int b = Integer.parseInt(ss1[1]);
        int c = Integer.parseInt(ss2[0]);
        int d = Integer.parseInt(ss2[1]);

        int A = a * c - b * d;
        int B = b * c + a * d;
        return A + "+" + B + "i";

    }
}
