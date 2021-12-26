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
class Solution1609 {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> d = new ArrayDeque<>();
        int size;
        int prev;
        boolean flag= true;
        d.addLast(root);
        while(!d.isEmpty())
        {
            size=d.size();
            prev=(flag)?0:0x3f3f3f3f;
            while(size-->0)
            {
                TreeNode cur = d.pollFirst();
                int v= cur.val;
                if(flag&&(v<=prev||(v&1)==0))return false;
                if(!flag&&(v>=prev||(v&1)==1))return false;
                prev = v;
                if(cur.left!=null)d.addLast(cur.left);
                if(cur.right!=null)d.addLast(cur.right);
            }
            flag=!flag;
        }
        return true;
    }

}