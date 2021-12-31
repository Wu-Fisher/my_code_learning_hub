class Solution2021 {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        char[] cs = s.toCharArray();
        int m= s.length();
        int[] ans = new int[m];
        for(int i=0;i<m;i++)
        {
            
            int x=startPos[0];
            int y=startPos[1];
            for(int j = i;j<m;j++)
            {
                char c = cs[j];
                switch(c)
                {
                    case 'R':y++;  
                            break;
                    case 'L':y--;
                            break;  
                    case 'U':x--;
                            break;
                    case 'D':x++;
                            break;
                }
                if(y<0||x<0||x>=n||y>=n)
                {
                    break;
                }
                else
                {
                    ans[i]++;
                }

            }
        }
          return ans;

    }
}