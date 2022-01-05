class Solution5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n<2)return s;
        char[] cs = s.toCharArray();
        int st = 0;
        int ed = 0;
        int l=0;
        for(int i = 0 ; i < n ; i++)
        {
            int l1= check(s,i,i);
            int l2= check(s,i,i+1);
            int cur = Math.max(l1,l2);
            if(l<cur)
            {
                l=cur;
                st=i-(cur-1)/2;
                ed=i+cur/2;
            }

        }
        return s.substring(st,ed+1);
        

    }
    public int check(String s , int l ,int r)
    {
        while(l>-1&&r<s.length()&&s.charAt(l)==s.charAt(r))
        {
            l--;
            r++;
        }
        return r-l-1;
    }
}