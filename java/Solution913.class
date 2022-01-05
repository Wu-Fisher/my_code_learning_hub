class Solution913 {
    static int N=55;
    static int[][][] f = new int[2*N*N][N][N];
    int [][]g;
    int n;
    public int catMouseGame(int[][] graph) {
        g=graph;
        n=g.length;
        for(int k=0;k<2*n*n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j = 0;j<n;j++)
                {
                    f[k][i][j]=-1;
                }
            }
        }
        return dfs(0,1,2);
    }
    public int dfs(int k,int i,int j)
    {
        int ans=f[k][i][j];
        if(i==0)ans=1;
        else if(i==j) ans=2;
        else if(k>=2*n*n) ans=0;
        else if(ans==-1)
        {
            if(k%2==0)
            //mouse
            {
                boolean win =false;
                boolean draw = false;
                for(int s : g[i])
                {
                    int t = dfs(k+1,s,j);
                    if(t==1) win=true;
                    else if(t==0) draw=true;
                    if(win)break;
                }
                if(win)ans=1;
                else if(draw) ans=0;
                else ans=2;
            }
            else
            //cat
            {
                boolean win =false;
                boolean draw = false;
                for(int s : g[j])
                {
                    if(s==0)continue;
                    int t = dfs(k+1,i,s);
                    if(t==2) win=true;
                    else if(t==0) draw=true;
                    if(win)break;
                }
                if(win)ans=2;
                else if(draw) ans=0;
                else ans=1;
            }

        }
        f[k][i][j]=ans;
        return ans;
    }   
}