class Solution787 {
    int max= 0x3f3f3f3f;
    int[] dist = new int[110]; 
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Arrays.fill(dist,max);
        dist[src]=0;
        for(int i=0;i<k+1;i++)
        {
            int []clone = dist.clone();
            for(int[]f:flights)
            {
                int x=f[0],y=f[1],w=f[2];
                dist[y]=Math.min(dist[y],clone[x]+w);
            }
        }
        return dist[dst]>(max/2)?-1:dist[dst];
    }
}