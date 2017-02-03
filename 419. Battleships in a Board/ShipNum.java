public class Solution {
    //check every element in given board iteratively, when find one peer one ship, 
    //check the horizontal and vertical line from the current position in order to seek the whole ship.
    //replace the whole ship with a sequence of '.', and then continue.
    public int countBattleships(char[][] board) {
        if(board.length == 0 || board[0].length == 0){
            return 0;
        }
        int ship = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X'){
                    ship+=1;
                    board[i][j] = '.';
                    checkWholeShip(board,i,j);
                }
            }
        }
        return ship;
    }
    public void checkWholeShip(char[][] board, int i, int j){
        int row = i+1;
        int col = j+1;
        //check all the symbols from (i,j) horizontally and vertically, since there are no two ships adjacent.
        //don't stop replacement until find the first '.' character on this board
        while(row < board.length && board[row][j] == 'X'){
            board[row][j] = '.';
            row++;
        }
        while(col < board[0].length && board[i][col] == 'X'){
            board[i][col] = ',';
            col++;
        }
    }
}