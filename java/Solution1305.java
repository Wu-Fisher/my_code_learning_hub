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
class Solution1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        if (root1 != null)
            midorder(root1, a);
        if (root2 != null)
            midorder(root2, b);
        List<Integer> ans = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (true) {
            if (p1 == a.size()) {
                ans.addAll(b.subList(p2, b.size()));
                break;
            } else if (p2 == b.size()) {
                ans.addAll(a.subList(p1, a.size()));
                break;

            } else if (a.get(p1) < b.get(p2)) {
                ans.add(a.get(p1));
                p1++;
            } else {
                ans.add(b.get(p2));
                p2++;
            }
        }
        return ans;
    }

    public void midorder(TreeNode root, List<Integer> list) {
        if (root.left != null)
            midorder(root.left, list);
        list.add(root.val);
        if (root.right != null)
            midorder(root.right, list);
    }

}