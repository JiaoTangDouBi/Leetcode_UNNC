class Solution {
    /*we check the grid from top-left to right-bottom. If we find any grid whose value is 1,
      this should be the head of this island, and we check as well as change its neighbors (four directions) recursively
      until both of them are equal 0.
    */
    public int numIslands(char[][] grid) {
        int num = 0;
        int rows = grid.length;
        if(rows == 0)    return num;
        else{
            int cols = grid[0].length;
            if(cols == 0)    return num;
            else{
                for(int i = 0; i < rows; i++){
                    for(int j = 0; j < cols; j++){
                        if(grid[i][j] == '1'){
                            num++;
                            continuousChange(i, j, rows, cols, grid);
                        }
                    }
                }
            }
            return num;
        }
        
    }
    public void continuousChange(int i, int j, int rows, int cols, char[][] grid){
        if(i>-1 && j > -1 && i<rows && j < cols && grid[i][j] == '1'){
            grid[i][j] = '0';
            continuousChange(i-1, j, rows, cols, grid);
            continuousChange(i, j-1, rows, cols, grid);
            continuousChange(i+1, j, rows, cols, grid);
            continuousChange(i, j+1, rows, cols, grid);
        }
    }
}