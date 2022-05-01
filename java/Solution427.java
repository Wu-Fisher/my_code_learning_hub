/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution427 {
    int[][] g;

    public Node construct(int[][] grid) {
        g = grid;
        int n = grid.length;
        return dfs(0, 0, n - 1, n - 1);

    }

    Node dfs(int a, int b, int c, int d) {
        boolean ok = true;
        int t = g[a][b];
        for (int i = a; i <= c && ok; i++) {
            for (int j = b; j <= d && ok; j++) {
                if (g[i][j] != t) {
                    ok = false;
                }
            }
        }
        if (ok)
            return new Node(t == 1, true);
        Node node = new Node(t == 1, false);
        int dx = c - a + 1;
        int dy = d - b + 1;

        node.topLeft = dfs(a, b, a + dx / 2 - 1, b + dy / 2 - 1);
        node.topRight = dfs(a, b + dy / 2, a + dx / 2 - 1, d);
        node.bottomLeft = dfs(a + dy / 2, b, c, b + dy / 2 - 1);
        node.bottomRight = dfs(a + dy / 2, b + dy / 2, c, d);
        return node;

    }
}