class Solution1044 {
    long[]h;
    long[]p;
    public String longestDupSubstring(String s) {
        int P=1313131,n=s.length();
        h = new long[n+1];
        p = new long[n+1];
        p[0]=1;
        for(int i=0;i<n;i++)
        {
            p[i+1]=p[i]*P;
            h[i+1]=h[i]*P+s.charAt(i);
        }
        String ans="";
        int l=0;
        int r=n;
        while(l<r)
        {
            int mid= l+r+1>>1;
            String t = check(mid,s);
            if(t.length()>0)l=mid;
            else r=mid-1;
            ans=ans.length()<t.length()?t:ans;
        }
        return ans;

    }
    public String check(int len,String s)
    {
        int n= s.length();
        Set<Long> set = new HashSet<>();
        for(int i=1;i+len-1<=n;i++)
        {
            int j=i+len-1;
            long cur=h[j]-h[i-1]*p[j-i+1];
            if(set.contains(cur))return s.substring(i-1,j);
            set.add(cur);
        }
        return "";
    } 
}