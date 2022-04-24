class Solution1575 {
    public String modifyString(String s) {
        char[] cs= s.toCharArray();
        int n = s.length();
        for(int i = 0; i<n;i++)
        {
            for(int c=0;c<3&&cs[i]=='?';c++)
            {
                boolean t = true;
                if(i>0&&cs[i-1]=='a'+c)t=false;
                if(i<n-1&&cs[i+1]=='a'+c) t=false;
                if(t)
                {
                    cs[i]=(char)('a'+c);
                    break;
                }
            }
        }
        return String.valueOf(cs);
    }
}