class Solution1446 {
    public int maxPower(String s) {
            int n=s.length();
            if(n==1)return 1;
            int dp1=1;
            int max=1;
            for(int i=1;i<n;i++)
            {
                if(s.charAt(i)==s.charAt(i-1))
                    dp1++;
                else    
                    dp1=1;
                max=Math.max(dp1,max);

            }
            return max;
    }
}