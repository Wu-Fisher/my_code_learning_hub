class Solution2038 {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        char[] cs = colors.toCharArray();
        int a=0,b=0;

        for(int i=1 ;i<n-1;i++)
        {
            if(cs[i]=='A'&&cs[i-1]=='A'&&cs[i+1]=='A')a++;
            else if(cs[i]=='B'&&cs[i-1]=='B'&&cs[i+1]=='B')b++;
        }
        return a>b;
    }
}