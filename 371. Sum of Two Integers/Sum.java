public class Solution {
    public int getSum(int a, int b) {
        int and = a & b;
		int xor = a ^ b;
		and = and<<1;
		int c = and & xor;
		
		while (c != 0) {
			int d = and;
			and = and & xor;
			xor = d ^ xor;
			and = and<<1;
			c = and & xor;
		}
		return xor ^ and;
    }
}