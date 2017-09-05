class Solution {
    /*For a given nxn matrix, We only care about the implementation of points in the outer bound.
      Here is the formular of change (you can verify it by your own)
      m[i,j] -> m[j,n-i+j] -> m[n-i+j,n] -> m[n, i] (j==0)
      By doing this, all the outer bound points can be rotated w/o exception.
      For the inner matrix, we can solve it by recursion.
      Cuz implement every point once, Time Complexity (O(n^2))
    */
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) return;
        rotateRec(matrix, 0, row-1);
        return;
    }
    
    public void rotateRec(int[][] matrix, int j, int n){
        if(n <= j){
            return;
        }
        else{
            for(int i = j; i <= n-1; i++){
                int hold = matrix[j][n-i+j];
                matrix[j][n-i+j] = matrix[i][j];
                matrix[i][j] = matrix[n][i];
                matrix[n][i] = matrix[n-i+j][n];
                matrix[n-i+j][n] = hold;
            }
            rotateRec(matrix, j+1, n-1);
            return;
        }
    }
}