class Solution786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            int n=arr.length;
            PriorityQueue<int[]>q = new PriorityQueue<>((a,b)->Double.compare(b[0]*1.0/b[1],a[0]*1.0/a[1]));
            for(int i=0;i<n;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    if(q.size()<k||(arr[i]*1.0/arr[j])<(q.peek()[0]*1.0/q.peek()[1]))
                      {
                        if(q.size()==k)q.poll();
                        q.add(new int[]{arr[i],arr[j]});
                      }

                }
            }
            return q.peek();
    }
}
