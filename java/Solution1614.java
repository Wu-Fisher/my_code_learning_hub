class Solution1614 {
    public int maxDepth(String s) {
        int ans = 0 ;
        int cnt = 0 ;
        int n = s .length();
        char[] cs = s.toCharArray();
        for(char c : cs)
        {
            if(c=='(')
            {
                cnt++;
            }
            else if(c==')')
            {
                cnt--;
            }
            ans=Math.max(cnt,ans);
        }
        return ans;
    }
}