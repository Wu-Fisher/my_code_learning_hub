import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Node> d = new ArrayDeque<>();
        if (root != null)
            d.add(root);
        while (!d.isEmpty()) {
            int size = d.size();
            List<Integer> l = new ArrayList<>();
            while (size-- > 0) {
                Node t = d.pollFirst();
                for (Node node : t.children)
                    d.addLast(node);
                l.add(t.val);
            }
            ans.add(l);
        }
        return ans;
    }

}
