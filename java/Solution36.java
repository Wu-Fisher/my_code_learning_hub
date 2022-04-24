class Solution36 {
    public boolean isValidSudoku(char[][] board) {
            int[][]row = new int[9][9];
            int[][]col = new int[9][9];
            int[][]box = new int[9][9];
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    if(board[i][j]=='.')continue;
                    int c=board[i][j]-'0'-1;
                    if(row[i][c]==1)return false;
                    if(col[j][c]==1)return false;
                    if(box[i/3*3+j/3][c]==1)return false;
                    row[i][c]=1;
                    col[j][c]=1;
                    box[i/3*3+j/3][c]=1;
                }
            } 
            return true;
    }
}