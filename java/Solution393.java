class Solution393 {
    public boolean validUtf8(int[] data) {
        int n = data.length;
        for (int i = 0; i < n;) {
            int j = 7;
            int cur = data[i];
            while (j >= 0 && ((cur >> j) & 1) == 1) {
                j--;
            }
            int cnt = 7 - j;
            if (cnt == 1 || cnt > 4)
                return false;
            if (i + cnt - 1 >= n)
                return false;
            for (int k = i + 1; k < i + cnt; k++) {
                if (((data[k] >> 6) & 1) != 0 || ((data[k] >> 7) & 1) != 1)
                    return false;
            }
            if (cnt == 0)
                i++;
            else
                i += cnt;
        }
        return true;
    }
}