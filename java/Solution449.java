import java.util.ArrayList;
import java.util.List;

public class Solution449 {
    // Encodes a tree to a single string.
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> a = new ArrayList<>();
        dfs1(a, root);
        int n = a.size();
        for (int i = 0; i < n; i++) {
            sb.append(Integer.toString(a.get(i)));
            if (i != n - 1)
                sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;
        String[] ss = data.split(",");
        int n = ss.length;
        TreeNode node = dfs2(ss, 0, n - 1);
        return node;
    }

    void dfs1(List<Integer> a, TreeNode root) {
        if (root != null) {
            a.add(root.val);
            dfs1(a, root.left);
            dfs1(a, root.right);
        }

    }

    TreeNode dfs2(String[] ss, int i, int j) {
        if (i > j) {
            return null;
        }
        int t = Integer.parseInt(ss[i]);
        TreeNode node = new TreeNode(t);
        int k = i + 1;
        while (k <= j && Integer.parseInt(ss[k]) <= t) {
            k++;
        }
        node.left = dfs2(ss, i + 1, k - 1);
        node.right = dfs2(ss, k, j);
        return node;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
