class Solution689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = new int [3];
        int sum1=0,idx1=0,max1=0;
        int sum2=0,idx2=0,max12=0;
        int sum3=0,idx3=0,max123=0;
        for(int i=2*k;i<nums.length;i++)
        {
            sum3+=nums[i];
            //2k
            sum2+=nums[i-k];
            //k
            sum1+=nums[i-2*k];
            //0
            if(i>=3*k-1)
            {
                if(sum1>max1)
                {
                    idx1=i-3*k+1;
                    max1=sum1;
                }
                if(max1+sum2>max12)
                {
                    max12=max1+sum2;
                    idx3=idx1;
                    idx2=i-2*k+1;
                }
                if(max12+sum3>max123)
                {
                    max123=max12+sum3;
                    
                    ans[0]=idx3;
                    ans[1]=idx2;
                    ans[2]=i-k+1;
                }
                sum1-=nums[i-3*k+1];
                sum2-=nums[i-2*k+1];
                sum3-=nums[i-k+1];

            }


        }
        return ans;
    }
}