import java.util.HashMap;

public class Solution146 {
    class LRUCache {

        class Node {
            int key;
            int value;
            Node l, r;

            Node(int _k, int _v) {
                key = _k;
                value = _v;
            }
        }

        int n;
        Node head, tail;
        HashMap<Integer, Node> map;

        public LRUCache(int capacity) {
            n = capacity;
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.r = tail;
            tail.l = head;
            map = new HashMap<>();
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                refresh(node);
                return node.value;
            }
            return -1;

        }

        public void put(int key, int value) {
            Node node = null;
            if (map.containsKey(key)) {
                node = map.get(key);
                node.value = value;
            } else {
                if (map.size() == n) {
                    Node del = tail.l;
                    map.remove(del.key);
                    delete(del);
                }
                node = new Node(key, value);
                map.put(key, node);
            }
            refresh(node);
        }

        void refresh(Node node) {
            delete(node);
            node.r = head.r;
            head.r.l = node;
            head.r = node;
            node.l = head;
        }

        void delete(Node node) {
            // 不是新节点
            if (node.l != null) {
                Node temp = node.l;
                temp.r = node.r;
                node.r.l = temp;
            }
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}
