/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
            if(root==null||root.left==null)
            {
                return root;
            }
            TreeNode r = upsideDownBinaryTree(root.left);
            root.left.right=root;
            root.left.left=root.right;
            root.left=null;
            root.right=null;
            return r;
            
    }
}