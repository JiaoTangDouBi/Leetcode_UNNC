public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n<=0) {
			return false;
		}
    	else{
    		double result =  (double)(Math.log(n)/Math.log(3));
    		int result_com= (int) (Math.ceil(result));
//    		System.out.println((double) (result_com - result));
        	if ((double) (result_com - result) > 0.0000000001) {
    			return false;
    		}
        	else {
    			return true;
    		}
    	}
    }
}