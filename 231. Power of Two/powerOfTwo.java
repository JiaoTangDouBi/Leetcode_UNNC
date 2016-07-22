public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
			return false;
		}
    	else{
    		double result =  (double)(Math.log(n)/Math.log(2));
    		int result_com= (int) (result);
//    		System.out.println(result);
        	if (Math.abs((double) (result_com - result)) > 0.0000000001) {
    			return false;
    		}
        	else {
    			return true;
    		}
    	}
    }
}