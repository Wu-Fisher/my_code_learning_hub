class Solution1944 {
    public int[] canSeePersonsCount(int[] heights) {
        int n= heights.length;
        Deque<Integer> d = new ArrayDeque<Integer>();
        int[] ans= new int[n];
        for(int i=n-1;i>=0;i--)
        {
            while(!d.isEmpty())
            {
                ans[i]++;
                if(heights[i]>heights[d.getFirst()])
                {
                    d.pollFirst();
                    //d.removeLast();
                }
                else
                {
                    break;
                }
            }
            d.push(i);
        }
        return ans;
    }
}