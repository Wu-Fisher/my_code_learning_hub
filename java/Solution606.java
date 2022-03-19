/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution606 {
    StringBuilder sb = new StringBuilder();

    public String tree2str(TreeNode root) {
        dfs(root);
        return sb.substring(1, sb.length() - 1);
    }

    void dfs(TreeNode node) {
        sb.append("(");
        sb.append(node.val);
        if (node.left != null)
            dfs(node.left);
        else if (node.right != null) {
            sb.append("()");
        }
        if (node.right != null) {
            dfs(node.right);
        }
        sb.append(")");

    }
}