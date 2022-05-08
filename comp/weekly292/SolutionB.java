package comp.weekly292;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;

    }

    int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }
        int[] left = new int[] { 0, 0 };
        int[] right = new int[] { 0, 0 };
        if (root.left != null) {
            left = dfs(root.left);
        }
        if (root.right != null) {
            right = dfs(root.right);
        }
        int[] cur = new int[2];
        cur[0] = root.val + left[0] + right[0];
        cur[1] = 1 + left[1] + right[1];
        if (root.val == cur[0] / cur[1]) {
            ans++;
        }
        return cur;
    }

}