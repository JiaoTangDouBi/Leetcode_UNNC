class Solution {
    //Start from top-right corner, and only shift down or left if necessary.
    //If the current value in current grid is same as target, return true;
    //if the current value in current grid is bigger than target, move left;
    //if the current value in current grid is smaller than target, move down.
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0)    return false;
        int col = matrix[0].length;
        if(col == 0)    return false;
        
        col -= 1;
        int currentRow = 0;
        while(col >= 0 && currentRow < row){
            if(matrix[currentRow][col] == target)
                return true;
            else if (matrix[currentRow][col] < target)
                currentRow++;
            else
                col--;
        }
        return false;
    }
}