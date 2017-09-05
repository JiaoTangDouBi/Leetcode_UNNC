class Solution {
    //Use the dynamic programming, for a given k, we only need to hold the k-1 th row's values.
    //The space complexity should be O(2k) = O(k)
    //Here is the recurrsive formular between a value in kth row and its predecedors:
    /*v[i][k] = v[i-1][k-1] + v[i][k-1]*/
    public List<Integer> getRow(int rowIndex) {
        List<Integer> previousRow = new ArrayList<Integer>();
        List<Integer> currentRow  = new ArrayList<Integer>();
        currentRow.add(1);
        int counter = 1;
        while(counter <= rowIndex){
            //deep copy the last row
            previousRow = currentRow;
            currentRow = new ArrayList<>();
            for(int i = 0; i <= counter; i++){
                int temp = 0;
                if(i-1 > -1){
                    temp += previousRow.get(i-1);
                }
                if(i < previousRow.size()){
                    temp += previousRow.get(i);
                }
                currentRow.add(temp);
            }
            counter++;
        }
        return currentRow;
    }
}