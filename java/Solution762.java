public class Solution762
static boolean[] hash = new boolean[40];
static {
        int[] nums = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };
        for (int x : nums)
            hash[x] = true;

    }

    public int countPrimeSetBits(int left, int right) {
        int ans=0;
        for(int i=left;i<=right;i++){
            int cnt=0,x=i;
            while(x>0&&++cnt>=0)
            {
                x-=x&-x;
            }
            if(hash[cnt])
                ans++;
    }
    return ans;
    }
}
