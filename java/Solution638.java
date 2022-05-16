import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution638 {
    // ans初始设为最大值
    int ans = 0x3f3f3f3f;
    // 为了后面递归
    List<Integer> price;
    List<List<Integer>> special;
    List<Integer> needs;
    // n为单买商品个数，m为礼包数目+商品个数（新礼包个数）
    int n, m;
    // map中储存每一个礼包可以购买的最大数目
    Map<Integer, Integer> map = new HashMap<>();

    public int shoppingOffers(List<Integer> _price, List<List<Integer>> _special, List<Integer> _needs) {

        // 基础初始化赋值
        price = _price;
        special = _special;
        needs = _needs;
        n = price.size();
        // 构建单买商品礼包，并add进入special礼包列表中
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp.add(0);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> clone = new ArrayList<>(temp);
            clone.set(i, 1);
            clone.add(price.get(i));
            special.add(clone);
        }
        m = special.size();
        // 遍历找出每个礼包所能购买的最大值，储存进入map中
        for (int i = 0; i < m; i++) {
            int max = 10;
            List<Integer> x = special.get(i);
            for (int j = 0; j < n; j++) {
                int a = x.get(j);
                int b = needs.get(j);
                if (a == 0 || b == 0)
                    continue;
                max = Math.max(max, (int) Math.ceil(b / a));
            }
            map.put(i, max);
        }
        // 开始深度搜索
        dfs(0, needs, 0);
        return ans;
    }

    public void dfs(int u, List<Integer> list, int cur) {
        // 如果当前花费已经超过目前最小值，剪枝掉，不再继续遍历
        if (cur >= ans)
            return;
        // 当所有礼包遍历完成，检查是否满足需求，若能，在比较是否是最小值，来替换ans
        if (u == m) {
            for (int i = 0; i < n; i++) {
                if (list.get(i) != 0)
                    return;
            }
            ans = (int) Math.min(cur, ans);
            return;
        }
        // 正常遍历，对该礼包所有可能数量进行遍历
        int k = map.get(u);
        List<Integer> x = special.get(u);
        out: for (int i = 0; i <= k; i++) {
            List<Integer> clist = new ArrayList<>(list);
            for (int j = 0; j < n; j++) {
                int a = x.get(j);
                int b = clist.get(j);
                // 当此i值超过需求时候，大于i的值也不行，剪枝，退出
                if (b < i * a)
                    break out;
                // 如果可以满足，则修改当前需求
                clist.set(j, b - i * a);
            }
            // 该i数量满足，接着对下一个礼包进行遍历
            dfs(u + 1, clist, cur + i * x.get(n));

        }
    }
}
