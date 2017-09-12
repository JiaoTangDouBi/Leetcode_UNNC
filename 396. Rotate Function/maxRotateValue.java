class Solution {
    /*F[0] = 0*B[0] + 1*B[1] + ... + (n-1)*B[n-1]
      F[1] = 1*B[0] + 2*B[1] + ... + (n-1)*B[n-2]
      F[1]-F[0] = B[0] + ... + B[n-2] - (n-1)*B[n-1]
      F[k] - F[k-1] = B[0] + ..... - (n-1)*B[n-k] + B[n-k+1] + ... + B[n-1]
    */
    /*Keep this relationship in mind so that we can solve this problem in O(n) liner time*/
    public int maxRotateFunction(int[] A) {
        int output = 0;
        int last = output;
        for(int i = 0; i < A.length; i++){
            output += i*A[i];
        }
        last = output;
        
        int k = 1;
        while(k < A.length){
            int temp = last;
            for(int i = 0; i < A.length; i++){
                if(i == A.length - k)
                    temp -= (A.length - 1) * A[i];
                else
                    temp += A[i];
            }
            
            output = Math.max(output, temp);
            last = temp;
            k++;
        }
        
        return output;
    }
}