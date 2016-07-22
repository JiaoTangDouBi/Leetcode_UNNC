public class Solution {
    public boolean isHappy(int n) {
        int sum = 0;
    	HashSet<Integer> cord = new HashSet<Integer>();
        String aaa = String.valueOf(Math.abs(n));
    	while (n != 1 && !cord.contains(sum)) {
    		cord.add(sum);
    		sum = 0;
    		int[] digit = new int[aaa.length()];
        	for (int i = 0; i < aaa.length(); i++) {
    			digit[i] = Integer.parseInt(String.valueOf(aaa.charAt(i)));
    		}
        	for (int i = 0; i < digit.length; i++) {
				sum += Math.pow(digit[i], 2);
			}
			n = sum;
// 			System.out.println("sum = "+sum);
        	aaa = String.valueOf(Math.abs(n));
		}
    	if (n == 1) {
			return true;
		}
    	else {
			return false;
		}
    }
}