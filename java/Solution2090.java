import java.util.Arrays;

class Solution2090 {
    public int[] getAverages(int[] nums, int k) {
            int n=nums.length;
           
            int[] ans = new int[n];
             if(n<2*k+1) 
            {
                Arrays.fill(ans,-1);
                return ans;
            }
            long dp=0;
            for(int i=0;i<k;i++)
            {
                ans[i]=-1;
                dp+=nums[i];     
            }
            for(int i=k;i<=2*k;i++)
            {
                dp+=nums[i];
            }
            int l=0,j=2*k;
            for(int i=k;i<n-k;i++)
            {
                ans[i]=(int)(dp/(2*k+1));
                dp-=nums[l];
                l++;
               
                j++;
                j%=n;
                dp+=nums[j];
             
            }
            for(int i=n-k;i<n;i++)
            {
                ans[i]=-1;
            }
            return ans;
    }
}