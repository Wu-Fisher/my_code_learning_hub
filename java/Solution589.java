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

class Solution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        dfs(root);
        return ans;
    }

    public void dfs(Node root) {
        if (root == null)
            return;
        ans.add(root.val);
        for (Node no : root.children) {
            dfs(no);
        }
    }

    public List<Integer> preorder_nonrecusive(Node root) {
        List<Integer> ans = new ArrayList<>();
        Deque<Object[]> d = new ArrayDeque<>();
        d.add(new Object[] { root, 0 });
        while (!d.isEmpty()) {
            Object[] obs = d.pollLast();
            Node cur = (Node) obs[0];
            int cnt = (Integer) obs[1];
            if (cur == null)
                continue;
            if (cnt == 0)
                ans.add(cur.val);
            if (cnt < cur.children.size()) {
                d.addLast(new Object[] { cur, cnt + 1 });
                d.addLast(new Object[] { cur.children.get(cnt), 0 });
            }

        }
        return ans;
    }

}