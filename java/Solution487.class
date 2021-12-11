class Solution487 {
    public int findMaxConsecutiveOnes(int[] nums) {
            int n=nums.length;
            if(n==1)return 1;
            int ans=0;
            int dp1=0;
            int dp2=0;
            for(int i=0;i<n;i++)
            {
                if(nums[i]==1)
                {
                    dp1++;
                    dp2++;
                }
                else
                {
                    dp1=dp2+1;
                    dp2=0;
                }
                ans=Math.max(ans,dp1);
            }
            return ans;
    }
}