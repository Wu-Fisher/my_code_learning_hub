package comp.weekly292;

public class SolutionC {
    int e = (int) 1e9 + 7;
    long ans = 1;

    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        int[] dp1 = new int[pressedKeys.length() + 4];
        int[] dp2 = new int[pressedKeys.length() + 5];
        dp1[0] = 0;
        dp1[1] = 1;
        dp1[2] = 2;
        dp1[3] = 4;
        int a = 3;
        dp2[0] = 0;
        dp2[1] = 1;
        dp2[2] = 2;
        dp2[3] = 4;
        dp2[4] = 8;
        int b = 4;
        for (int i = 0; i < pressedKeys.length();) {
            int j = i + 1;
            while (j < n && pressedKeys.charAt(j) == pressedKeys.charAt(i)) {
                j++;
            }
            int len = j - i;
            if (pressedKeys.charAt(i) == '7' || pressedKeys.charAt(i) == '9') {
                if (len > b) {
                    for (int k = b + 1; k <= len; k++) {
                        dp2[k] = (((dp2[k - 1] + dp2[k - 2]) % e + dp2[k - 3]) % e + dp2[k - 4]) % e;
                    }
                    b = len;

                }
                ans = (ans * dp2[len]) % e;

            } else {
                if (len > a) {
                    for (int k = a + 1; k <= len; k++) {
                        dp1[k] = ((dp1[k - 1] + dp1[k - 2]) % e + dp1[k - 3]) % e;
                    }
                    a = len;

                }
                ans = (ans * dp1[len]) % e;
            }
            i = j;

        }
        return (int) ans;
    }
}