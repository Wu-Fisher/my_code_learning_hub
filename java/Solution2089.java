class Solution2089 {
    public List<Integer> targetIndices(int[] nums, int target) {
            int cnt1=0;
            int cnt2=0;
            List<Integer> ans = new ArrayList<>();
            for(int i =0;i<nums.length;i++)
            {
                if(nums[i]<target) cnt1++;
                else if(nums[i]==target) cnt2++;

                }
            for(int i= cnt1;i<cnt1+cnt2;i++)
            {
                ans.add(i);
            }
            return ans;
    }
}