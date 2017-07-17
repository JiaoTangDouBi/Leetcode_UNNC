public class Solution {
    //Start from the top-left grid, and find boats iteratively.
    //We only count a boat when we find it's head. The head is defined as the most top-left cell.
    public int countBattleships(char[][] board) {
        int row = board.length;
        if(row == 0)    return 0;
        int col = board[0].length;
        if(col == 0)    return 0;
        int num = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'X'){
                    boolean first = true;
                    if(i>0 && board[i-1][j] == 'X'){
                        first = false;
                    }
                    if(j>0 && board[i][j-1] == 'X')
                        first = false;

                    if(first)
                        num++;
                }
            }
        }
        return num;
    }
}