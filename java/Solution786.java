import java.util.PriorityQueue;

class Solution786 {
  // 利用递增的特点构造多路归并
  public int[] kthSmallestPrimeFraction(int[] arr, int k) {
    int n = arr.length;
    PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
      double c = 1.0 * arr[a[0]] / arr[a[1]];
      double d = 1.0 * arr[b[0]] / arr[b[1]];
      return Double.compare(c, d);
    });
    for (int i = 1; i < n; i++) {
      q.add(new int[] {
          0, i
      });
    }
    while (k-- > 1) {
      int[] p = q.poll();
      int a = p[0], b = p[1];
      if (a + 1 < b) {
        q.add(new int[] { a + 1, b });
      }
    }
    int[] p = q.poll();
    return new int[] { arr[p[0]], arr[p[1]] };
  }

  public int[] kthSmallestPrimeFraction_old(int[] arr, int k) {
    int n = arr.length;
    PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Double.compare(b[0] * 1.0 / b[1], a[0] * 1.0 / a[1]));
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (q.size() < k || (arr[i] * 1.0 / arr[j]) < (q.peek()[0] * 1.0 / q.peek()[1])) {
          if (q.size() == k)
            q.poll();
          q.add(new int[] { arr[i], arr[j] });
        }

      }
    }
    return q.peek();
  }
}
