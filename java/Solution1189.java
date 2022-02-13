class Solution1189 {
    public int maxNumberOfBalloons(String text) {
        int ans = (int)1e4 ;
        int[] cnt = new int[5];
        for(char c : text.toCharArray())
        {
            if(c=='b')cnt[0]++;
            else if(c=='a')cnt[1]++;
            else if(c=='l')cnt[2]++;
            else if(c=='o')cnt[3]++;
            else if(c=='n')cnt[4]++;

        }
        cnt[2]/=2;
        cnt[3]/=2;
        for(int i = 0 ;i<5;i++)
        {
            ans=Math.min(ans,cnt[i]);
        }
        return ans;
    }
}