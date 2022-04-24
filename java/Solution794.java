class Solution794 {
    public boolean validTicTacToe(String[] board) {
        int x=0;
        int o=0;
        char[][]kb=new char[3][3];

        for(int i =0;i<3;i++)
        {
            for(int j =0;j<3;j++)
            {
                if(board[i].charAt(j)=='X')x++;
                else if(board[i].charAt(j)=='O')o++;
                kb[i][j]=board[i].charAt(j);
            }
        }
        boolean a=check('X',kb);
        boolean b=check('O',kb);
        if(o>x||x-o>1)return false;
        if(a&&x<=o) return false;
        if(b&&o!=x) return false;
        if(a&&b)return false;
        return true;
    }
    boolean check(char c,char[][] z)
    {
        for(int i=0;i<3;i++)
        {
            
          if(z[i][0]==c&&z[i][1]==c&&z[i][2]==c)return true;
          if(z[0][i]==c&&z[1][i]==c&&z[2][i]==c)return true;

        }
        if(z[0][0]==c&&z[1][1]==c&&z[2][2]==c)return true;
        if(z[0][2]==c&&z[1][1]==c&&z[2][0]==c)return true;

        return false;
    }


}