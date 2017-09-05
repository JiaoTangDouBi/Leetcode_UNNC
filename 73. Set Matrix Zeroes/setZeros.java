class Solution {
    /*O(m+n) space complexity solution:
      Scrutinize the value of every objects in the matrix,
      Use two hashset to record which rows and columns should be set to 0 respectively.
    */
    /*O(1) space complexity solution:
      Instead of using two arrays to record which columns and columns contain 0 value,
      we use the elements of first row and first column to record them.
      Then during scrutinizing, we also have two booleans to check whether the first row and first column should be set to 0.
    */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if(row == 0){
            return;
        }
        else{
            int col = matrix[0].length;
            //determine whether the first row or first column should be set to 0.
            boolean firstRow = false;
            boolean firstCol = false;
            
            for(int i = 0; i < row; i++)
                for(int j = 0; j < col; j++)
                    if(matrix[i][j] == 0){
                        if(i == 0) firstRow = true;
                        if(j == 0) firstCol = true;
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                    
            for(int i = 1; i < row; i++)
                for(int j = 1; j < col; j++)
                    if(matrix[i][0] == 0 || matrix[0][j] == 0)
                        matrix[i][j] = 0;
            
            if(firstRow == true)
                for(int j = 0; j < col; j++)
                    matrix[0][j] = 0;
            if(firstCol == true)
                for(int i = 0; i < row; i++)
                    matrix[i][0] = 0;
            return;
        }
        
    }
}