public class Solution {
    //In this problem, we tend to find the longest path of every arithmetic slice,
    //Therefore, the eligible number of a given pair [P,Q] = 1+2+...+((Q-P+1)-2)
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3)
            return 0;
        int sum = 0;
        //initialize the start index of arithmetic slice and value of interval
        int start = 0;
        int interval = A[1]-A[0];
        for(int i = 1; i < A.length; i++){
            if(A[i] - A[i-1] != interval){
            //the end of current arithmetic slice.
                int length = i - start;
                if(length >= 3){
                    sum += (length-1)*(length-2)/2;
                }
                //update the info of the next arithmetic slice
                start = i-1;
                interval = A[i] - A[i-1];
            }
        }
        if(A.length-start >= 3){
            int length = A.length-start;
            sum += (length-1)*(length-2)/2;
        }
        return sum;
    }
}