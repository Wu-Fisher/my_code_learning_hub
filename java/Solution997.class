class Solution997 {
    public int findJudge(int n, int[][] trust) {
        int[] in =  new int[n];
        int[] out = new int [n];
        for(int[]t :trust)
        {
            int a=t[0]-1;
            int b=t[1]-1;
            in[b]++;
            out[a]++;
        }
        for(int i=0;i<n;i++)
        {
            if(in[i]==n-1&&out[i]==0)
            {
                return i+1;
            }
        }
        return -1;
        
    }
}