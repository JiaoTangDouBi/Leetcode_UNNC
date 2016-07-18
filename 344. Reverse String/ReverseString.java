public class Solution {
    public String reverseString(String s) {
        int length = s.length();
		StringBuilder strb = new StringBuilder(s);
//		String s1 = "";
		for (int i = 0; i <(length/2); i++) {
			int j = length - i - 1;
			String help = String.valueOf(s.charAt(j));
			String help1 = String.valueOf(s.charAt(i));
			strb.replace(j, j+1, help1);
			strb.replace(i, i+1, help);
		}
		s=strb.toString();
		return s;
    }
}