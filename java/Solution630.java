class Solution630 {
    public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses,(a,b)->a[1]-b[1]);
            PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);
            int sum =0;
            for(int[]c : courses)
            {
                int x=c[0],y=c[1];
                sum+=x;
                q.add(x);
                if(sum>y)sum-=q.poll();
            }
            return q.size();
    }
}