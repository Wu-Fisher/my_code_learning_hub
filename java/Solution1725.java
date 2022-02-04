class Solution1725{
    public int countGoodRectangles(int[][] rectangles) {
        int ans = 0;
        int max = 0;

        for(int[]cur:rectangles)
        {
            int l = Math.min(cur[0],cur[1]);
            if(max<l)
            {
                ans=1;
                max=l;

            }
            else if(max==l)
            {
                ans++;
            }

        }
        return ans;
    }
}