class Solution1034 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m=grid.length;int n=grid[0].length;
        int[][]ans= new int[m][n];
        int[][]dirs= new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Deque<int[]> q= new ArrayDeque<>();
        q.addLast(new int []{row,col});
        while(!q.isEmpty())
        {
            int []p= q.pollFirst();
            int x=p[0],y=p[1],cnt=0;
            
            for(int[] dir : dirs)
            {
                int xn=x+dir[0];
                int yn=y+dir[1];
                if(xn<0||xn>m-1||yn<0||yn>n-1)continue;
                if(grid[xn][yn]!=grid[x][y])
                {
                    continue;
                }
                else
                {
                    cnt++;
                }
                if(ans[xn][yn]!=0)continue;
                else q.addLast(new int[]{xn,yn});
            }
            ans[x][y]=cnt==4?grid[x][y]:color;

        }
        for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(ans[i][j]==0)ans[i][j]=grid[i][j];
                }
            }
        return ans;
    
    }

}