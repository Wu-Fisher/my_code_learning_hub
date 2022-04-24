import java.util.Arrays;

class Solution1996 {
    // 没有二维排序的反而更快（在遍历中得到防御力最大值）
    public int numberOfWeakCharacters(int[][] p) {
        int n = p.length;
        int ans = 0;
        Arrays.sort(p, (a, b) -> {
            return b[0] - a[0];

        });

        for (int i = 0, cur = p[0][1]; i < n;) {
            int max = cur;
            int j = i;
            while (j < n && p[j][0] == p[i][0]) {
                if (i != 0 && p[j][1] < max) {
                    ans++;
                }
                cur = Math.max(cur, p[j][1]);
                j++;
            }

            i = j;
        }
        return ans;
    }

    // 叶总这个防御力已经排序后不用遍历同一个攻击力的时候再max比较，直接循环完成后选择同一攻击力下标最小的（i）就可以更新max值了，最后我还试了试sort里面不判断防御力，最后遍历更新防御值的方法是我最快的
    // 下面是二维排序了之后，直接选取攻击力相同的最小下标为防御力最大值

    // public int numberOfWeakCharacters(int[][] p) {
    // int n = p.length;
    // int ans = 0;
    // Arrays.sort(p, (a, b) -> {
    // if (a[0] != b[0])
    // return b[0] - a[0];
    // return b[1] - a[1];
    // });

    // for (int i = 0, cur = p[0][1]; i < n;) {
    // int max = cur;
    // int j = i;
    // while (j < n && p[j][0] == p[i][0]) {
    // if (i != 0 && p[j][1] < max) {
    // ans++;
    // }
    // j++;
    // }
    // cur = Math.max(cur, p[i][1]);
    // i = j;
    // }
    // return ans;
    // }

}