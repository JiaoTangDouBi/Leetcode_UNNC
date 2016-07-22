public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int i = 1;
    	int number = 0;
    	for (int j = 1; j <= 32; j++) {
    		if ((n & i) != 0) {
				number ++;
			}
    		i = i<<1;
		}
    	return number;
    }
}