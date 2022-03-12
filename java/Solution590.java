/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution590 {
    List<Integer> ans = new ArrayList<>();;

    public List<Integer> postorder(Node root) {
        dfs(root);
        return ans;
    }

    void dfs(Node node) {
        if (node == null)
            return;
        for (Node cur : node.children) {
            dfs(cur);
        }
        ans.add(node.val);
    }
}