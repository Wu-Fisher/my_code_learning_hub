import java.util.Random;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution382 {
    ListNode head;
    Random random = new Random(20220116);

    public Solution(ListNode _head) {
        head=_head;
    }

    public int getRandom() {
        ListNode cur = head;
        int idx = 0;
        int ans = 0;
        while (cur != null) {
            idx++;
            if (random.nextInt(idx) == 0)
                ans = cur.val;
            cur = cur.next;
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */