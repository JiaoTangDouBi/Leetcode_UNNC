public class Solution {
    //if 1<n<11, the totally possible number of unique digits is 9*9*8*...*1
    //if n == 1, the number of unique digits is 10.
    //if n >= 11, the number of unique digits is 0.
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        else{
            int output = 10;    // when n == 1, number of unique digits is 10.
            int count = 2;
            while (count <= n && count < 11){
                int temp = 9;
                for(int i = 9; i > 10-count; i--){
                    temp *= i;
                }
                output += temp;
                count++;
            }
            return output;
        }
    }
}