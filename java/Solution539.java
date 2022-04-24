import java.util.List;

class Solution539 {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440)
            return 0;
        int[] cnt = new int[2 * 1440 + 10];
        for (String str : timePoints) {
            String[] ss = str.split(":");
            int a = Integer.parseInt(ss[0]);
            int b = Integer.parseInt(ss[1]);
            cnt[a * 60 + b]++;
            cnt[a * 60 + b + 1440]++;
        }
        int ans = 1440;
        int last = -1;
        for (int i = 0; i < 2 * 1440; i++) {
            if (cnt[i] == 0)
                continue;
            if (cnt[i] > 1)
                return 0;
            else if (last != -1) {
                ans = Math.min(ans, i - last);
            }
            last = i;
        }
        return ans;

    }
}