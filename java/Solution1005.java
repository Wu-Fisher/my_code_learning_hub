class Solution1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
            PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->nums[a]-nums[b]);
            boolean z=false;
            int n= nums.length;
            int idx=0;
            for(int i=0;i<n;i++)
            {
                if(nums[i]<0) q.add(i);
                if(nums[i]==0) z=true;
                if(Math.abs(nums[i])<Math.abs(nums[idx]))   idx=i;
            }

            if(k<=q.size())
            {
                while(k-->0)
                {
                    nums[q.peek()]=-nums[q.poll()];
                }

            }
            else
            {
                  while(!q.isEmpty())
                {
                    nums[q.peek()]=-nums[q.poll()];
                    k--;
                }
                if(!z&&(k%2!=0))
                {
                    nums[idx]=-nums[idx];
                }

            }
            int ans=0;
            for(int x:nums)
            {
                ans+=x;
            }
            return ans;


    }
}