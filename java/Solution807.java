class Solution807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
            int n=grid.length;
            int []maxc=new int[n];
            int []maxl=new int[n];
            
            
            for(int i=0;i<n;i++)
            {
                int max=0;
                for(int j=0;j<n;j++)
                {
                    max=Math.max(grid[i][j],max);
                }
                maxc[i]=max;
            }
            for(int i=0;i<n;i++)
            {
                int max=0;
                for(int j=0;j<n;j++)
                {
                    max=Math.max(grid[j][i],max);
                }
                maxl[i]=max;
            }
            int ans=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    ans+=Math.min(maxc[i],maxl[j])-grid[i][j];
                }
            }
            return ans;

    }
}