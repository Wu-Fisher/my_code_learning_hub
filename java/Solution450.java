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

class Solution450 {
    int key;

    public TreeNode deleteNode(TreeNode root, int _key) {
        key = _key;
        return dfs(root);
    }

    TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.val == key) {
            if (node.right != null) {
                TreeNode ns = node.right;
                TreeNode hs = node;
                while (ns.left != null) {
                    hs = ns;
                    ns = ns.left;
                }
                if (hs == node) {
                    ns.left = node.left;
                } else {
                    hs.left = ns.right;
                    ns.left = node.left;
                    ns.right = node.right;
                }
                return ns;
            } else {
                return node.left;
            }
        }
        if (node.val < key) {
            node.right = dfs(node.right);
        } else {
            node.left = dfs(node.left);
        }
        return node;
    }
}