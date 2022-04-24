public class Solution868 {
    public int binaryGap(int n) {
        int ans=0;
        int i=0,j=-1;

        while(n!=0)
        {
            
            if((n&1)==1)
            {
                if(j!=-1)
                {
                    ans=Math.max(ans,i-j);
                }
                j=i;
            }
            n=(n>>1);
            i++;
        }

        return ans;
    }
}

