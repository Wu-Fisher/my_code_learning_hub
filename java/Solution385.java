/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 *
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to
 * it.
 * public void add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
class Solution385 {
    static NestedInteger ph = new NestedInteger(0);

    public NestedInteger deserialize(String s) {
        Deque<NestedInteger> d = new ArrayDeque<>();
        char[] cs = s.toCharArray();
        int n = cs.length;
        int i = 0;
        while (i < n) {
            if (cs[i] == ',' && ++i >= 0)
                continue;
            if (cs[i] == '-' || (cs[i] >= '0' && cs[i] <= '9')) {
                int j = cs[i] == '-' ? i + 1 : i, num = 0;
                while (j < n && (cs[j] >= '0' && cs[j] <= '9')) {
                    num = num * 10 + (cs[j++] - '0');
                }
                d.addLast(new NestedInteger(cs[i] == '-' ? -num : num));
                i = j;
            } else if (cs[i] == '[') {
                d.addLast(new NestedInteger());
                d.addLast(ph);
                i++;
            } else {
                List<NestedInteger> list = new ArrayList<>();
                while (!d.isEmpty()) {
                    NestedInteger poll = d.pollLast();
                    if (poll == ph)
                        break;
                    list.add(poll);

                }
                for (int j = list.size() - 1; j >= 0; j--)
                    d.peekLast().add(list.get(j));
                i++;
            }

        }
        return d.peekLast();

    }
}
