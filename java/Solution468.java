public class Solution468 {
    public String validIPAddress(String queryIP) {
        if (queryIP.indexOf(".") >= 1 && check4(queryIP))
            return "IPv4";
        if (queryIP.indexOf(":") >= 1 && check6(queryIP))
            return "IPv6";
        return "Neither";
    }

    public boolean check4(String ip) {
        int n = ip.length(), cnt = 0;
        char[] cs = ip.toCharArray();
        for (int i = 0; i < n && cnt <= 3;) {
            // 找连续字段
            int j = i, x = 0;
            while (j < n && cs[j] >= '0' && cs[j] <= '9' && x <= 255) {
                x = x * 10 + cs[j++] - '0';
            }

            // 间隔符之间没有数字,或者第一个就是间隔符
            if (i == j)
                return false;
            if (((j - i) > 1 && cs[i] == '0') || (x > 255))
                return false;

            i = j + 1;
            // 这里其实break也行吧
            if (j == n)
                continue;
            if (cs[j] != '.')
                return false;
            cnt++;

        }
        // 这里可以不用判断cs[0]?='.'其实一开始里面就判断了
        return cnt == 3 && cs[n - 1] != '.';

    }

    public boolean check6(String ip) {
        int n = ip.length(), cnt = 0;
        char[] cs = ip.toCharArray();
        for (int i = 0; i < n && cnt <= 7;) {
            int j = i;
            while (j < n
                    && (Character.isDigit(cs[j]) || (cs[j] >= 'A' && cs[j] <= 'F') || (cs[j] >= 'a' && cs[j] <= 'f'))) {
                j++;
            }
            if (i == j || j - i > 4)
                return false;
            i = j + 1;
            if (j == n)
                continue;
            if (cs[j] != ':')
                return false;
            cnt++;

        }
        return cnt == 7 && cs[n - 1] != ':';
    }

}
