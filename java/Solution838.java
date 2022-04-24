import java.util.ArrayDeque;
import java.util.Deque;

class Solution838 {
    // public String pushDominoes(String dominoes) {
    // int n = dominoes.length();
    // int[] ts = new int[n];
    // Deque<int[]> q = new ArrayDeque<>();
    // char[] cs = dominoes.toCharArray();

    // for (int i = 0; i < n; i++) {
    // char c = cs[i];
    // if (c == '.')
    // continue;
    // int d = c == 'L' ? -1 : 1;
    // q.add(new int[] { i, 1, d });
    // ts[i] = 1;
    // }
    // while (!q.isEmpty()) {
    // int[] cur = q.pollFirst();
    // int idx = cur[0];
    // int time = cur[1];
    // int de = cur[2];
    // int ne = idx + de;
    // if (ne < 0 || ne >= n)
    // continue;
    // if (ts[ne] == 0) {
    // q.addLast(new int[] { ne, time + 1, de });
    // ts[ne] = time + 1;
    // cs[ne] = de == -1 ? 'L' : 'R';
    // } else if (ts[ne] == time + 1) {
    // cs[ne] = '.';
    // }
    // }
    // return String.valueOf(cs);
    // }

    // f2
    static int N = 100010;
    static int[][] l = new int[N][2], r = new int[N][2];

    public String pushDominoes(String dominoes) {
        char[] cs = dominoes.toCharArray();
        int n = cs.length;
        for (int i = 0, j = -1; i < n; i++) {
            if (cs[i] != '.')
                j = i;
            l[i] = new int[] { j, j != -1 ? cs[j] : '.' };
        }
        for (int i = n - 1, j = -1; i >= 0; i--) {
            if (cs[i] != '.')
                j = i;
            r[i] = new int[] { j, j != -1 ? cs[j] : '.' };
        }
        for (int i = 0; i < n;) {

            if (cs[i] != '.' && ++i >= 0)
                continue;
            int j = i;
            while (j < n && cs[j] == '.')
                j++;
            j--;
            int[] a = l[i];
            int[] b = r[j];
            int loc1 = a[0], dire1 = a[1];
            int loc2 = b[0], dire2 = b[1];
            if (loc1 == -1 && loc2 == -1) {
                // 两侧都无力
            } else if (loc1 == -1) {
                // 只有右侧有力而且向左
                if (dire2 == 'L') {
                    update(cs, i, j, 'L', 'L');
                }

            } else if (loc2 == -1) {
                // 只有左侧有力，而且向右
                if (dire1 == 'R') {
                    update(cs, i, j, 'R', 'R');
                }
            } else if (!(dire1 == 'L' && dire2 == 'R')) {
                // 两侧都有力，且没有朝着相反方向
                update(cs, i, j, (char) dire1, (char) dire2);
            }
            i = j + 1;
        }
        return String.valueOf(cs);

    }

    void update(char[] cs, int l, int r, char c1, char c2) {
        for (int p = l, q = r; p <= q; p++, q--) {
            if (p == q && c1 != c2)
                continue;
            cs[p] = c1;
            cs[q] = c2;
        }
    }

}